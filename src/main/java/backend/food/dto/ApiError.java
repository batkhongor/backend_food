package backend.food.dto;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
public class ApiError {

	   private HttpStatus status;
	   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	   private LocalDateTime timestamp;
	   private String error;
	   private String message;

	   private ApiError() {
	       timestamp = LocalDateTime.now();
	   }

	   public ApiError(HttpStatus status) {
	       this();
	       this.status = status;
	   }

	   public ApiError(HttpStatus status, Throwable ex) {
	       this();
	       this.status = status;
	       this.error = "Unexpected error";
	       this.message = ex.getLocalizedMessage();
	   }

	   public ApiError(HttpStatus status, String error, Throwable ex) {
	       this();
	       this.status = status;
	       this.error = error;
	       this.message = ex.getLocalizedMessage();
	   }
	}