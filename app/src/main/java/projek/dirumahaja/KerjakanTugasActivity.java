package projek.dirumahaja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import projek.dirumahaja.api.KumpulTugasService;
import projek.dirumahaja.dialog.LoadingDialog;
import projek.dirumahaja.model.BaseResponse;
import projek.dirumahaja.model.User;
import projek.dirumahaja.util.PrefUtil;
import retrofit2.Call;
import retrofit2.Callback;

public class KerjakanTugasActivity extends AppCompatActivity {
    private EditText etDeskripsi;
    ImageView ivSend;
    private TextView tvNamaKelas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kerjakan_tugas);
        etDeskripsi = findViewById(R.id.et_upload_tugas);
        ivSend  = findViewById(R.id.iv_send);
        tvNamaKelas = findViewById(R.id.tv_detail_nama_kelas);

        String namaKelas = getIntent().getStringExtra("namaKelas");
        String subKelas = getIntent().getStringExtra("subKelas");

        tvNamaKelas.setText(namaKelas+" "+subKelas);
        ivSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kumpulAct();
            }
        });
    }
    void kumpulAct() {
        User user = PrefUtil.getUser(KerjakanTugasActivity.this,PrefUtil.USER_SESSION);
        String strDeskripsi= etDeskripsi.getText().toString();
        String email = user.getData().getEmail();
        final int idTugas = getIntent().getIntExtra("idTugas",0);
//        final LoadingDialog loadingDialog = new LoadingDialog(KerjakanTugasActivity.this);
//        loadingDialog.startLoadingDialog();
        KumpulTugasService kumpulTugasService = new KumpulTugasService(this);
        kumpulTugasService.setKumpulTugas("kumpul",email,idTugas,strDeskripsi, new Callback() {
            @Override
            public void onFailure(Call call, Throwable t) {
//                loadingDialog.dismissDialog();
                Toast.makeText(KerjakanTugasActivity.this, "An error occurred!"+idTugas, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onResponse(retrofit2.Call call, retrofit2.Response response) {
                BaseResponse baseResponse = (BaseResponse) response.body();

                if(baseResponse != null) {
                    if(!baseResponse.isError()) {
//                        loadingDialog.dismissDialog();
                        Toast.makeText(KerjakanTugasActivity.this, baseResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
//                    loadingDialog.dismissDialog();
                    Toast.makeText(KerjakanTugasActivity.this, baseResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
//                loadingDialog.dismissDialog();
            }
        });

    }
}
