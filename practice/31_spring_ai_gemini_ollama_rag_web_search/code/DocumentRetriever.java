/**
 * Component responsible for retrieving {@link Document}s from an underlying data source,
 * such as a search engine, a vector store, a database, or a knowledge graph.
 *
 * @author Christian Tzolov
 * @author Thomas Vitale
 * @since 1.0.0
 */
public interface DocumentRetriever extends Function<Query, List<Document>> {

	/**
	 * Retrieves relevant documents from an underlying data source based on the given
	 * query.
	 * @param query The query to use for retrieving documents
	 * @return The list of relevant documents
	 */
	List<Document> retrieve(Query query);

	default List<Document> apply(Query query) {
		return retrieve(query);
	}

}