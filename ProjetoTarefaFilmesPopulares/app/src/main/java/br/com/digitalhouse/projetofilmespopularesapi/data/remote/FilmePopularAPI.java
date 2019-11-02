package br.com.digitalhouse.projetofilmespopularesapi.data.remote;

import br.com.digitalhouse.projetofilmespopularesapi.model.FilmePopular;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmePopularAPI {

    @GET("movie/popular")
    Observable<FilmePopular> getAllFilmesPop(@Query("api_key") String apiKey);
}
