package br.com.android.pocapp.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import br.com.android.pocapp.dao.BootDao;

/**
 * Created by guilherme.sanches on 09/08/2017.
 */

public class BootBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(Intent.ACTION_SHUTDOWN.equalsIgnoreCase(intent.getAction())) {
            BootDao bootDao = new BootDao(context);
            bootDao.save(0);
        }

        if(Intent.ACTION_BOOT_COMPLETED.equalsIgnoreCase(intent.getAction())) {
            BootDao bootDao = new BootDao(context);
            bootDao.save(1);
        }
    }
}
