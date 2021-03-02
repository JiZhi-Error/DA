package com.tencent.mm.plugin.downloader;

import android.os.FileObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.plugin.appbrand.jsapi.ce;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends FileObserver {
    private String qFa;

    public a(String str) {
        super(q.k(str, false), (int) ce.CTRL_INDEX);
        AppMethodBeat.i(192243);
        this.qFa = str;
        AppMethodBeat.o(192243);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void onEvent(int i2, String str) {
        AppMethodBeat.i(88814);
        if (str == null) {
            Log.e("DownloadsObserver", "path should be null");
            AppMethodBeat.o(88814);
            return;
        }
        String str2 = this.qFa + str;
        switch (i2) {
            case 8:
                Log.i("DownloadsObserver", "close write file: %s", str2);
                AppMethodBeat.o(88814);
                return;
            case 32:
                Log.i("DownloadsObserver", "open file: %s", str2);
                AppMethodBeat.o(88814);
                return;
            case 64:
                Log.i("DownloadsObserver", "move from file: %s", str2);
                break;
            case 512:
                Log.i("DownloadsObserver", "delete file: %s", str2);
                AppMethodBeat.o(88814);
                return;
        }
        AppMethodBeat.o(88814);
    }
}
