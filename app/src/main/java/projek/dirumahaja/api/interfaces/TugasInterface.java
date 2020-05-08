package projek.dirumahaja.api.interfaces;

import projek.dirumahaja.api.config.Config;
import projek.dirumahaja.model.tugas.TugasResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface TugasInterface {
    @FormUrlEncoded
    @POST(Config.API_TUGAS)
    Call<TugasResponse> getAllTugas(
            @Field("action") String action,
            @Field("email") String email,
            @Field("idKelas") int idKelas
    );
}
