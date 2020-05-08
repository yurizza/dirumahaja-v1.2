package projek.dirumahaja.api;

import projek.dirumahaja.api.config.Config;
import projek.dirumahaja.api.interfaces.TugasInterface;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TugasService {
    private Retrofit retrofit;
    public TugasInterface getApiTugas(){
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(Config.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(TugasInterface.class);
    }
}
