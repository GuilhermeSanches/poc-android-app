package br.com.android.pocapp.view.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.android.pocapp.R;

/**
 * Created by guilherme.sanches on 08/08/2017.
 */

public class FilmsHolder extends RecyclerView.ViewHolder {

    /**
     * Reference to textView title in UI
     */
    public TextView title;

    /**
     * Reference to textView Director name in UI
     */
    public TextView subTitle;

    /**
     * Reference to textView avatar logo in UI
     */
    public TextView firstLetter;

    /**
     * Reference to Date release in UI
     */
    public TextView releaseDate;

    /*
     * Constructor of class
     */
    public FilmsHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title_card);
        subTitle = (TextView) itemView.findViewById(R.id.sub_title);
        firstLetter = (TextView) itemView.findViewById(R.id.film_first_letter_call);
        releaseDate = (TextView) itemView.findViewById(R.id.sub_title2);

    }
}
