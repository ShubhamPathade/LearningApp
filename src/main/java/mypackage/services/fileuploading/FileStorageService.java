package mypackage.services.fileuploading;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {

	private final Path fileStorageLocation;
	
	@Autowired
	public FileStorageService(FileStorageProperties fileStorageProperties) {
		this.fileStorageLocation=Paths.get(fileStorageProperties.getUploadDir())
				.toAbsolutePath().normalize();
		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception ex) {
			// TODO: handle exception
			throw new FileStorageException("Could not create directory where the uploaded files will be stored.",ex);
		}
	}
	
	public String storeFile(MultipartFile file) {
        // Normalize file name
		String fileName=StringUtils.cleanPath(file.getOriginalFilename());
		try {
            // Check if the file's name contains invalid characters
			if(fileName.contains("..")) {
				throw new FileStorageException("Sorry ! Filename contains invalid path sequence "+fileName);
			}
			
            // Copy file to the target location (Replacing existing file with the same name)
			Path targetLocation=this.fileStorageLocation.resolve(fileName);
			System.out.println(targetLocation.getRoot());
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			return fileName;
		} catch (Exception ex) {
			// TODO: handle exception
			throw new FileStorageException("Could not store file "+fileName+" . Please try again!",ex);
		}
	}
	
	public Resource loadFileAsResource(String fileName) {
		try {
			Path filePath=this.fileStorageLocation.resolve(fileName).normalize();
			Resource resource=new UrlResource(filePath.toUri());
			if(resource.exists()) {
				return resource;
			}else {
				throw new FileNotFoundException("File not found "+fileName);
			}
		}catch (MalformedURLException ex) {
			// TODO: handle exception
			throw new FileNotFoundException("File not found "+fileName,ex);
		}
	}
}
