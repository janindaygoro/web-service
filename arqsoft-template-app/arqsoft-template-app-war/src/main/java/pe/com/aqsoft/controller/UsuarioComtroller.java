package pe.com.aqsoft.controller;

import java.util.Locale;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UsuarioComtroller {

//	private static final Logger logger = LoggerFactory
//		      .getLogger(UsuarioComtroller.class);
	
	@RequestMapping(value = "/UsuarioComtroller", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		System.out.println("/n ============web service 1============= /n");
		return "mensaje 1";
	}

	@RequestMapping(value = "/ex/foos", method = RequestMethod.GET)
//	@ResponseBody
	public String getFoosBySimplePath() {
		System.out.println("/n ============web service 2============= /n");
		return "Get some Foos";
	}

}
