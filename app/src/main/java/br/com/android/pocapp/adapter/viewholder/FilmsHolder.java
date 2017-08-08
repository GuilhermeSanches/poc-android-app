package br.com.android.pocapp.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Date;

import br.com.android.pocapp.R;

/**
 * Created by guilherme.sanches on 08/08/2017.
 */

public class FilmsHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public TextView subTitle;
    public TextView firstLetter;
    public TextView releaseDate;

    public FilmsHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title_card);
        subTitle = (TextView) itemView.findViewById(R.id.sub_title);
        firstLetter = (TextView) itemView.findViewById(R.id.film_first_letter_call);
        releaseDate = (TextView) itemView.findViewById(R.id.sub_title2);

    }
}
