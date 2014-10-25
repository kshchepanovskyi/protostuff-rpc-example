package io.protostuff.example.search;

import java.util.Arrays;
import java.util.List;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import static com.google.common.util.concurrent.Futures.immediateFuture;

/**
 * @author Konstantin Shchepanovskyi
 */
public class DummySearchService implements SearchService {

    @Override
    public ListenableFuture<SearchResponse> search(SearchRequest request) {
        SearchResponse response = new SearchResponse();
        List<String> resultList = Arrays.asList("Result 1", "Result 2");
        response.setResultList(resultList);
        return immediateFuture(response);
    }

    @Override
    public ListenableFuture<SearchResponse> extendedSearch(ExtendedSearchRequest request) {
        SearchResponse response = new SearchResponse();
        List<String> resultList = Arrays.asList("Result 1", "Result 2", "Result 3");
        response.setResultList(resultList);
        return immediateFuture(response);
    }
}
