package be.ehb.thisappisintents.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import be.ehb.thisappisintents.R;
import be.ehb.thisappisintents.model.Persoon;
import be.ehb.thisappisintents.model.PersoonDAO;


public class HomeFragment extends Fragment {

    private Spinner spiPersonen;
    private Button btnDetails;
    //listener
    private final View.OnClickListener detailListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Persoon geselecteerd = (Persoon) spiPersonen.getSelectedItem();

            Bundle data = new Bundle();
            data.putSerializable("persoon", geselecteerd);

            Navigation.findNavController(view).navigate(R.id.nav_to_destination, data);
        }
    };

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //verwijzing naar layout
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        //verwijzingen naar wat in scherm zit
        spiPersonen = rootView.findViewById(R.id.spi_personen);
        btnDetails = rootView.findViewById(R.id.btn_details);
        //spinner opvullen
        //aanmaken adapter, dit bevat de layout voor rijen en array met gegevens
        ArrayAdapter<Persoon> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1,
                PersoonDAO.getInstance().getPersonen());
        //adapter aan spinner vasthangen
        spiPersonen.setAdapter(adapter);
        //listener voor button
        btnDetails.setOnClickListener(detailListener);

        return rootView;
    }
}