package com.tencent.mm.plugin.downloader.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class FileDownloadNotificationClickReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(89129);
        Log.i("MicroMsg.FileDownloadNotificationClickReceiver", "onReceive");
        Log.i("MicroMsg.FileDownloadNotificationClickReceiver", "topActivityName = ".concat(String.valueOf(Util.getTopActivityName(context))));
        Bundle extras = intent.getExtras();
        Intent intent2 = new Intent(context, FileDownloadConfirmUI.class);
        intent2.putExtras(extras);
        intent2.setFlags(268435456);
        a bl = new a().bl(intent2);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/downloader/ui/FileDownloadNotificationClickReceiver", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/downloader/ui/FileDownloadNotificationClickReceiver", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(89129);
    }
}
