package br.com.digitalhouse.projetoretrofitfilmes.data.remote;

import br.com.digitalhouse.projetoretrofitfilmes.model.Results;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmeAPI {

    @GET("movie/now_playing")
    Observable<Results> getAllFilmes(@Query("api_key") String apiKey);
}
