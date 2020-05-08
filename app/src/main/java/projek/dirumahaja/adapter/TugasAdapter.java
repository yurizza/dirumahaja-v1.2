package projek.dirumahaja.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import projek.dirumahaja.KerjakanTugasActivity;
import projek.dirumahaja.R;
import projek.dirumahaja.model.User;
import projek.dirumahaja.model.tugas.KelasItem;
import projek.dirumahaja.util.PrefUtil;

public class TugasAdapter extends RecyclerView.Adapter<TugasAdapter.ViewHolder> {
private ArrayList<KelasItem> kelasItems=new ArrayList<>();
private Context context;

public TugasAdapter(Context context) {
        this.context = context;
        }

public void setData(ArrayList<KelasItem> items){
        kelasItems.clear();
        kelasItems.addAll(items);
        notifyDataSetChanged();
        }
@NonNull
@Override
public TugasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_list_tugas,parent,false);
        return new ViewHolder(view);
        }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvNamaKelas.setText(kelasItems.get(position).getNamaKelas()+" ");
        holder.tvSubKelas.setText(kelasItems.get(position).getSubKelas());
        holder.tvJudul.setText(kelasItems.get(position).getJudulTugas());
        holder.tvDeskripsi.setText(kelasItems.get(position).getDeskripsiTugas());
        holder.tvTenggat.setText(kelasItems.get(position).getTanggalUpload());
        holder.tvTanggal.setText(kelasItems.get(position).getTanggalTenggat());
    }

@Override
public int getItemCount() {
        return kelasItems.size();
        }

public class  ViewHolder extends RecyclerView.ViewHolder {
    User user = PrefUtil.getUser(context, PrefUtil.USER_SESSION);
    TextView tvJudul,tvDeskripsi,tvTanggal,tvTenggat,tvNamaKelas,tvSubKelas;
    CardView cvKelas;
    LinearLayout layoutItemList;
    public ViewHolder(@NonNull final View itemView) {
        super(itemView);
        tvNamaKelas=itemView.findViewById(R.id.tv_nama_kelas);
        tvSubKelas =itemView.findViewById(R.id.tv_sub_kelas);
        tvJudul = itemView.findViewById(R.id.tv_judul);
        tvDeskripsi = itemView.findViewById(R.id.tv_deskripsi);
        tvTanggal = itemView.findViewById(R.id.tv_upload);
        tvTenggat = itemView.findViewById(R.id.tv_tenggat);
//        cvKelas = itemView.findViewById(R.id.cv_tugas);
        layoutItemList= itemView.findViewById(R.id.layout_item_list_tugas);
        layoutItemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
//
                intent = new Intent(context, KerjakanTugasActivity.class);
//                intent.putExtra("email",user.getData().getEmail());
//                    Toast.makeText(v.getContext(),user.getData().getEmail(), Toast.LENGTH_SHORT).show();
                intent.putExtra("idTugas",kelasItems.get(getAdapterPosition()).getIdTugas());
                intent.putExtra("namaKelas",kelasItems.get(getAdapterPosition()).getNamaKelas());
                intent.putExtra("subKelas",kelasItems.get(getAdapterPosition()).getSubKelas());
//                intent.putExtra("kodeKelas",kelasItems.get(getAdapterPosition()).getKodeKelas());
//                intent.putExtra("pengajar",kelasItems.get(getAdapterPosition()).getPengajar());
                v.getContext().startActivity(intent);
            }
        });
    }
}
}