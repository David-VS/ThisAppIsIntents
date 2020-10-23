package be.ehb.thisappisintents.fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import be.ehb.thisappisintents.R;
import be.ehb.thisappisintents.model.Persoon;

public class DestinationFragment extends Fragment {

    private Persoon geselecteerdPersoon;

    private View.OnClickListener homepageListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Uri page = Uri.parse(geselecteerdPersoon.getHomepage());
            Intent intent = new Intent(Intent.ACTION_VIEW, page);

            startActivity(intent);
        }
    };

    private View.OnClickListener callListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            Uri tel = Uri.parse(geselecteerdPersoon.getTel());
            intent.setData(tel);

            startActivity(intent);
        }
    };

    public DestinationFragment() {
    }

    static public DestinationFragment newInstance(){
        return new DestinationFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_destination, container, false);

        TextView tvNaam = rootView.findViewById(R.id.tv_naam);
        Button btnCall = rootView.findViewById(R.id.btn_call);
        Button btnHomepage = rootView.findViewById(R.id.btn_homepage);

        geselecteerdPersoon = (Persoon) getArguments().getSerializable("persoon");


        //waarden gebruiken
        tvNaam.setText(geselecteerdPersoon.getNaam());

        btnHomepage.setOnClickListener(homepageListener);
        btnCall.setOnClickListener(callListener);

        return rootView;
    }
}
