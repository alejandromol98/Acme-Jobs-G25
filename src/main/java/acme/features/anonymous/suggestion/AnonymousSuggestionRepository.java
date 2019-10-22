
package acme.features.anonymous.suggestion;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.suggestions.Suggestion;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousSuggestionRepository extends AbstractRepository {

	@Query("select s from Suggestion s")
	Collection<Suggestion> findMany();
}
