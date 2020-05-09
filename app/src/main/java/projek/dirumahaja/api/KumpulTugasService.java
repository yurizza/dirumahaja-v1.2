package projek.dirumahaja.api;

import android.content.Context;

import projek.dirumahaja.api.config.RetrofitBuilder;
import projek.dirumahaja.api.interfaces.KumpulTugasInterface;
import retrofit2.Callback;

public class KumpulTugasService {
    private KumpulTugasInterface kumpulTugasInterface;
    public KumpulTugasService(Context context){
        kumpulTugasInterface = RetrofitBuilder.builder(context).create(KumpulTugasInterface.class);
    }

    public void setKumpulTugas(String action, String email, int idTugas, String deskripsi, Callback callback){
        kumpulTugasInterface.kumpulTugas(action,email,idTugas,deskripsi).enqueue(callback);
    }
}
