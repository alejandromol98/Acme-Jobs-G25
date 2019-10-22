
package acme.features.anonymous.suggestion;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.suggestions.Suggestion;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousSuggestionCreateService implements AbstractCreateService<Anonymous, Suggestion> {

	// Internal Service -----------------------------------------------

	@Autowired
	AnonymousSuggestionRepository repository;


	@Override
	public boolean authorise(final Request<Suggestion> request) {
		assert request != null;

		return true;
	}

	@Override
	public Suggestion instantiate(final Request<Suggestion> request) {
		assert request != null;

		Suggestion result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		result = new Suggestion();
		result.setAuthor("Miguel");
		result.setSuggestion("Me gustaría poder registrarme en la página");
		result.setMoment(moment);

		return result;

	}

	@Override
	public void unbind(final Request<Suggestion> request, final Suggestion entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "suggestion");
	}

	@Override
	public void bind(final Request<Suggestion> request, final Suggestion entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void validate(final Request<Suggestion> request, final Suggestion entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<Suggestion> request, final Suggestion entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);
	}

}
