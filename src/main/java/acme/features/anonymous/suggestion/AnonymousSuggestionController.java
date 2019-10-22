
package acme.features.anonymous.suggestion;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.suggestions.Suggestion;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/suggestion/")
public class AnonymousSuggestionController extends AbstractController<Anonymous, Suggestion> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AnonymousSuggestionListService		listService;

	@Autowired
	private AnonymousSuggestionCreateService	createService;


	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);

	}

}
