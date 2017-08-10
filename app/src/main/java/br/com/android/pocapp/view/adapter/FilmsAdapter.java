package br.com.android.pocapp.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import br.com.android.pocapp.R;
import br.com.android.pocapp.view.adapter.viewholder.FilmsHolder;
import br.com.android.pocapp.domain.Films;

/**
 * Created by guilherme.sanches on 08/08/2017.
 */

public class FilmsAdapter extends RecyclerView.Adapter<FilmsHolder> {
    private final List<Films> mFilms;

    private Context context;

    private int lastPosition = -1;

    public FilmsAdapter(ArrayList films, Context context) {
        this.mFilms = films;
        this.context = context;
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
       setAnimation(holder);
    }

    /**
     * Method to format date
     * @param date
     * @return
     */
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

    /**
     * Set animation in elements of RecycleView
     * @param holder
     */
    public void setAnimation(FilmsHolder holder) {
        try {
            YoYo.with(Techniques.ZoomIn).duration(1500).playOn(holder.firstLetter);
        }catch (Exception e){
            Log.i("AdapterFilms", e.getMessage());
        }
    }
}
