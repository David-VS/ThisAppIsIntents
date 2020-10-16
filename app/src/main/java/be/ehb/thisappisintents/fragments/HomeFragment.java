package be.ehb.thisappisintents.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import be.ehb.thisappisintents.R;


public class HomeFragment extends Fragment {

    //listener
    private View.OnClickListener goToDestinationListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Navigation.findNavController(view).navigate(R.id.nav_to_destination);
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

        Button btnDestination = rootView.findViewById(R.id.btn_to_destination);
        btnDestination.setOnClickListener(goToDestinationListener);

        return rootView;
    }
}