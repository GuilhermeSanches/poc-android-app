package br.com.android.pocapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import br.com.android.pocapp.R;
import br.com.android.pocapp.adapter.viewholder.FilmsHolder;
import br.com.android.pocapp.domain.Films;

/**
 * Created by guilherme.sanches on 08/08/2017.
 */

public class FilmsAdapter extends RecyclerView.Adapter<FilmsHolder> {
    private final List<Films> mFilms;


    public FilmsAdapter(ArrayList films) {
        this.mFilms = films;
    }

    @Override
    public FilmsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FilmsHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_line_view, parent, false));
    }

    @Override
    public void onBindViewHolder(FilmsHolder holder, int position) {
        Films film = mFilms.get(position);
        holder.title.setText( film.getmTitle());
        holder.subTitle.setText( film.getmDirector());
        holder.firstLetter.setText(film.getmTitle().toString().charAt(0)+"");
        holder.releaseDate.setText("Lançado em: "+formatDate((film.getmReleaseDate())));
    }

    private String formatDate(Date date) {
        String resultDate;
        SimpleDateFormat dateFormat;
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        resultDate = dateFormat.format(date);
        return resultDate;
    }

    @Override
    public int getItemCount() {
        return mFilms != null ? mFilms.size() : 0;
    }
}
