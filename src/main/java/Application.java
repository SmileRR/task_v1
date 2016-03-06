

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itask.service.TaskController;

/**
 * App
 *
 */
@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(TaskController.class);
	}
}
