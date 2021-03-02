package com.tencent.mm.plugin.downloader.model;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;

public class FileDownloadPendingReceive extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(89005);
        Log.i("MicroMsg.FileDownloadPendingReceive", "onReceive()");
        intent.setComponent(new ComponentName(intent.getComponent().getPackageName(), FileDownloadService.class.getName()));
        c.startService(intent);
        AppMethodBeat.o(89005);
    }
}
