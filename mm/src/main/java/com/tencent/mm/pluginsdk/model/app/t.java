package com.tencent.mm.pluginsdk.model.app;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

/* access modifiers changed from: package-private */
public final class t implements Runnable {
    private String appId = null;
    private MMHandler handler = null;
    private int jjN = 0;
    private String url = null;

    public t(MMHandler mMHandler, String str, int i2, String str2) {
        this.handler = mMHandler;
        this.appId = str;
        this.jjN = i2;
        this.url = str2;
    }

    public final void run() {
        AppMethodBeat.i(151793);
        if (this.appId == null || this.appId.length() == 0 || this.url == null || this.url.length() == 0) {
            AppMethodBeat.o(151793);
            return;
        }
        x xVar = new x(this.appId, this.jjN, Util.httpGet(this.url));
        Message obtain = Message.obtain();
        obtain.obj = xVar;
        this.handler.sendMessage(obtain);
        AppMethodBeat.o(151793);
    }
}
