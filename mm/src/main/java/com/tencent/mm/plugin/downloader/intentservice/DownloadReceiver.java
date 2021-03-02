package com.tencent.mm.plugin.downloader.intentservice;

import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.app.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.notification.d;

public class DownloadReceiver extends ResultReceiver {
    private static final String TAG = DownloadReceiver.class.getSimpleName();
    private s.c Ij;

    static {
        AppMethodBeat.i(88887);
        AppMethodBeat.o(88887);
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i2, Bundle bundle) {
        AppMethodBeat.i(88886);
        super.onReceiveResult(i2, bundle);
        if (i2 == 4657) {
            int i3 = bundle.getInt("progress");
            if (d.AGv == null) {
                AppMethodBeat.o(88886);
                return;
            } else if (i3 < 100) {
                this.Ij.b(100, i3, false).g("Download in progress:".concat(String.valueOf(i3)));
                d.AGv.notify(4657, this.Ij.build());
                AppMethodBeat.o(88886);
                return;
            } else {
                this.Ij.b(0, 0, false).g("Download Complete");
                d.AGv.notify(4658, this.Ij.build());
            }
        }
        AppMethodBeat.o(88886);
    }
}
