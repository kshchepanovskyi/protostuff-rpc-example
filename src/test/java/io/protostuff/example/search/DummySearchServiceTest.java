package io.protostuff.example.search;

import java.util.Arrays;

import org.junit.Test;

import com.google.common.util.concurrent.ListenableFuture;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * @author Konstantin Shchepanovskyi
 */
public class DummySearchServiceTest {

    private final SearchService searchService = new DummySearchService();

    @Test
    public void testSearch() throws Exception {
        SearchRequest request = new SearchRequest("hello");
        ListenableFuture<SearchResponse> future = searchService.search(request);
        SearchResponse searchResponse = future.get();
        assertEquals(searchResponse.getResultList(), asList("Result 1", "Result 2"));
    }

    @Test
    public void testExtendedSearch() throws Exception {
        ExtendedSearchRequest request = new ExtendedSearchRequest();
        request.setKeywordsList(Arrays.asList("hi", "hello"));
        ListenableFuture<SearchResponse> future = searchService.extendedSearch(request);
        SearchResponse searchResponse = future.get();
        assertEquals(searchResponse.getResultList(), asList("Result 1", "Result 2", "Result 3"));
    }
}
