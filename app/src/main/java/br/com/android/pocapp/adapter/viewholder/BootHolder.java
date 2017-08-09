package br.com.android.pocapp.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.android.pocapp.R;

/**
 * Created by guilherme.sanches on 09/08/2017.
 */

public class BootHolder extends RecyclerView.ViewHolder {

    public TextView date;
    public TextView type;

    public BootHolder(View itemView) {
        super(itemView);
        this.date = (TextView) itemView.findViewById(R.id.title_card_boot);
        this.type = (TextView) itemView.findViewById(R.id.film_img);
    }


}
