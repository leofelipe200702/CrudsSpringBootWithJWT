package angular.with.basic;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://crudusers-angular.herokuapp.com")
@RestController
public class BasicAuthenticationController {

	@GetMapping(path = "/basicauth")
	public BasicAuthenticationBean helloWorldBean() {
		// throw new RuntimeException("Erro consumindo mensagem via web service");
		return new BasicAuthenticationBean("Login Efetuado com sucesso");
	}

}
