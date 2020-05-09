package projek.dirumahaja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import projek.dirumahaja.adapter.TugasAdapter;
import projek.dirumahaja.model.tugas.KelasItem;
import projek.dirumahaja.viewModel.TugasViewModel;

public class TugasAnggotaActivity extends AppCompatActivity {
    private TugasAdapter tugasAdapter;
    private RecyclerView rvTugas;
    private TugasViewModel tugasViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas_anggota);

        final int idKelas = getIntent().getIntExtra("idKelas", 0);
        final String email = getIntent().getStringExtra("email");
        tugasAct(email,idKelas);

    }
    private void tugasAct(String email,int idKelas) {
//        final LoadingDialog loadingDialog = new LoadingDialog(TugasAnggotaActivity.this);
//        loadingDialog.startLoadingDialog();
        tugasAdapter = new TugasAdapter(this);
        tugasAdapter.notifyDataSetChanged();
//        Toast.makeText(TugasAnggotaActivity.this, "hallo" +email + idKelas, Toast.LENGTH_SHORT).show();
        rvTugas = findViewById(R.id.rv_list_tugas);
        rvTugas.setLayoutManager(new GridLayoutManager(this, 1));

        tugasViewModel = new ViewModelProvider(this).get(TugasViewModel.class);
        tugasViewModel.setTugas(email, idKelas);
        tugasViewModel.getKelas().observe(this, getKelas);
        rvTugas.setAdapter(tugasAdapter);
//        loadingDialog.dismissDialog();
    }

    private Observer<ArrayList<KelasItem>> getKelas = new Observer<ArrayList<KelasItem>>() {
        @Override
        public void onChanged(ArrayList<KelasItem> kelasItems) {
            if (kelasItems!= null)
                tugasAdapter.setData(kelasItems);
            else
              Toast.makeText(TugasAnggotaActivity.this, "kosong", Toast.LENGTH_SHORT).show();
        }
    };
}
