package projek.dirumahaja;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import projek.dirumahaja.adapter.TugasAdapter;
import projek.dirumahaja.dialog.LoadingDialog;
import projek.dirumahaja.model.User;
import projek.dirumahaja.model.tugas.KelasItem;
import projek.dirumahaja.util.PrefUtil;
import projek.dirumahaja.viewModel.TugasViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class PekeraanFragment extends Fragment {

    private TugasAdapter tugasAdapter;
    private RecyclerView rvTugas;
    private TugasViewModel tugasViewModel;
    public PekeraanFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pekeraan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Pekerjaan Rumah");
        User user = PrefUtil.getUser(getActivity(),PrefUtil.USER_SESSION);
        String strEmail = user.getData().getEmail();
        final LoadingDialog loadingDialog = new LoadingDialog(requireActivity());
        loadingDialog.startLoadingDialog();
        tugasAdapter = new TugasAdapter(getActivity());
        tugasAdapter.notifyDataSetChanged();

        rvTugas = view.findViewById(R.id.rv_list_tugas);
        rvTugas.setLayoutManager(new GridLayoutManager(getActivity(), 1));

        tugasViewModel = new ViewModelProvider(this).get(TugasViewModel.class);
        tugasViewModel.setTugas(strEmail, -1);
        tugasViewModel.getKelas().observe(this, getKelas);
        rvTugas.setAdapter(tugasAdapter);
        loadingDialog.dismissDialog();

    }
    private Observer<ArrayList<KelasItem>> getKelas = new Observer<ArrayList<KelasItem>>() {
        @Override
        public void onChanged(ArrayList<KelasItem> kelasItems) {
            if (kelasItems!= null)
                tugasAdapter.setData(kelasItems);
        }
    };

}
