
package acme.features.anonymous.suggestion;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.suggestions.Suggestion;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousSuggestionListService implements AbstractListService<Anonymous, Suggestion> {

	// Internal Service -----------------------------------------------

	@Autowired
	AnonymousSuggestionRepository repository;


	// AbastractListService<Administrator, Shout> interface -----------

	@Override
	public boolean authorise(final Request<Suggestion> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<Suggestion> findMany(final Request<Suggestion> request) {
		assert request != null;

		Collection<Suggestion> result;

		result = this.repository.findMany();

		return result;
	}

	@Override
	public void unbind(final Request<Suggestion> request, final Suggestion entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "suggestion", "moment");
	}

}
