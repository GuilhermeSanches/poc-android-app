package br.com.android.pocapp.view.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.android.pocapp.R;

/**
 * Created by guilherme.sanches on 08/08/2017.
 */

public class FilmsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveBundle) {
        View view = inflater.inflate(R.layout.main_line_view, container, false);
        return view;
    }
}
