package com.tencent.mm.plugin.downloader.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.Environment;
import android.os.ResultReceiver;
import android.support.v4.app.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bq.a;
import com.tencent.mm.vfs.o;

public class DownloadFileService extends IntentService {
    private static final String TAG = DownloadFileService.class.getSimpleName();
    private ResultReceiver qHC;
    private int qHD;
    private int qHE;

    static {
        AppMethodBeat.i(88885);
        AppMethodBeat.o(88885);
    }

    public DownloadFileService() {
        super("com.tencent.mm.plugin.downloader.intentservice.DownloadFileService");
    }

    public void onCreate() {
        AppMethodBeat.i(88882);
        super.onCreate();
        s.c cd = a.cd(this, "reminder_channel_id");
        cd.f("Something Download").g("Download in progress").as(R.drawable.icon);
        startForeground(4657, cd.build());
        AppMethodBeat.o(88882);
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        AppMethodBeat.i(88883);
        String string = intent.getExtras().getString("url");
        this.qHC = (ResultReceiver) intent.getParcelableExtra("receiver");
        o oVar = new o(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download");
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        e(string, new o(oVar, "file11.apk"));
        AppMethodBeat.o(88883);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0085 A[SYNTHETIC, Splitter:B:22:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008a A[Catch:{ IOException -> 0x00d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f5 A[SYNTHETIC, Splitter:B:44:0x00f5] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00fa A[Catch:{ IOException -> 0x0104 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0121 A[SYNTHETIC, Splitter:B:55:0x0121] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0126 A[Catch:{ IOException -> 0x0131 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0143 A[SYNTHETIC, Splitter:B:65:0x0143] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0148 A[Catch:{ IOException -> 0x0152 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e(java.lang.String r13, com.tencent.mm.vfs.o r14) {
        /*
        // Method dump skipped, instructions count: 390
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.downloader.intentservice.DownloadFileService.e(java.lang.String, com.tencent.mm.vfs.o):void");
    }
}
