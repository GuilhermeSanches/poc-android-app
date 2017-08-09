package br.com.android.pocapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import java.util.ArrayList;

import br.com.android.pocapp.R;

import br.com.android.pocapp.adapter.viewholder.BootHolder;
import br.com.android.pocapp.domain.BootInfo;

/**
 * Created by guilherme.sanches on 09/08/2017.
 */

public class BootAdapter extends RecyclerView.Adapter<BootHolder> {

    private ArrayList<BootInfo> mDatesBoot;

    public BootAdapter(ArrayList<BootInfo> dates) {
        this.mDatesBoot = dates;
    }

    @Override
    public BootHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BootHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.boot_line_view, parent, false));
    }

    @Override
    public void onBindViewHolder(BootHolder holder, int position) {
        BootInfo bootInfo = mDatesBoot.get(position);
        holder.date.setText(bootInfo.getmTime());
        holder.type.setText(bootInfo.getmType() == 1 ? "On" : "Off");
    }

    @Override
    public int getItemCount() {
            return mDatesBoot != null ? mDatesBoot.size() : 0;
        }
    }
