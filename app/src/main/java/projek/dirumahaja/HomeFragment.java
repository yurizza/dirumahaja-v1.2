package projek.dirumahaja;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{
    ImageView profil, tugas, diskusi, kelas;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        profil = (ImageView) view.findViewById(R.id.menu_profil);
        tugas = (ImageView) view.findViewById(R.id.menu_tugas);
        diskusi = (ImageView) view.findViewById(R.id.menu_obrolan);
        kelas = (ImageView) view.findViewById(R.id.menu_kelas);

        profil.setOnClickListener(this);
        tugas.setOnClickListener(this);
        diskusi.setOnClickListener(this);
        kelas.setOnClickListener(this);

        return view;
    }
    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()){
            case R.id.menu_profil:
                fragment = new ProfilFragment();
                replaceFragment(fragment);
                break;

            case R.id.menu_tugas:
                fragment = new PekeraanFragment();
                replaceFragment (fragment);
                break;

            case R.id.menu_obrolan:
                fragment = new ObrolanFragment();
                replaceFragment (fragment);
                break;

            case R.id.menu_kelas:
                fragment = new KelasDetailFragment();
                replaceFragment (fragment);
                break;
        }

    }
    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fl_home, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fl_home, fragment);
        fragmentTransaction.commit();

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Beranda");
    }
}
