package projek.dirumahaja.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import projek.dirumahaja.api.TugasService;
import projek.dirumahaja.model.tugas.KelasItem;
import projek.dirumahaja.model.tugas.TugasResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TugasViewModel extends ViewModel {
    private TugasService tugasService;

    private MutableLiveData<ArrayList<KelasItem>> listMutableLiveData = new MutableLiveData<ArrayList<KelasItem>>();

    public void setTugas(String email,int idKelas){
        if (this.tugasService ==null){
            tugasService = new TugasService();
        }
        tugasService.getApiTugas().getAllTugas("get",email,idKelas).enqueue(new Callback<TugasResponse>() {
            @Override
            public void onResponse(Call<TugasResponse> call, Response<TugasResponse> response) {
                TugasResponse tugasResponse = response.body();
                if (tugasResponse!=null && !tugasResponse.isError()){
                    ArrayList<KelasItem> kelasItem = tugasResponse.getKelas();
                    listMutableLiveData.postValue(kelasItem);
                }
            }

            @Override
            public void onFailure(Call<TugasResponse> call, Throwable t) {

            }
        });
    }
    public LiveData<ArrayList<KelasItem>> getKelas(){
        return listMutableLiveData;
    }
}
