import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import com.itask.service.TaskController;

public class ServletInitializer extends SpringBootServletInitializer{
	@Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(TaskController.class);  
    }  
}
