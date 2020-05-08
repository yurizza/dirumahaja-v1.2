package projek.dirumahaja.api.interfaces;

import projek.dirumahaja.api.config.Config;
import projek.dirumahaja.model.BaseResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface KumpulTugasInterface {
    @FormUrlEncoded
    @POST(Config.API_TUGAS)
    Call<BaseResponse> kumpulTugas(
            @Field("action") String action,
            @Field("email") String email,
            @Field("idTugas") int idTugas,
            @Field("deskripsi") String deskripsi
            );
}
