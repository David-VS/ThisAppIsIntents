package be.ehb.thisappisintents.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import be.ehb.thisappisintents.R;

public class DestinationFragment extends Fragment {

    private View.OnClickListener websiteListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW);
            Uri data = Uri.parse("http://www.ehb.be");
            webIntent.setData(data);

            startActivity(webIntent);
        }
    };

    private View.OnClickListener locationListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent locIntent = new Intent(Intent.ACTION_VIEW);
            Uri data = Uri.parse("geo:40,3?z=8");
            locIntent.setData(data);

            startActivity(locIntent);
        }
    };

    public DestinationFragment() {
    }

    static public DestinationFragment newInstance(){
        return new DestinationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_destination, container, false);

        Button btnWeb = rootView.findViewById(R.id.btn_website);
        btnWeb.setOnClickListener(websiteListener);

        Button btnLoc = rootView.findViewById(R.id.btn_location);
        btnLoc.setOnClickListener(locationListener);

        return rootView;
    }
}
