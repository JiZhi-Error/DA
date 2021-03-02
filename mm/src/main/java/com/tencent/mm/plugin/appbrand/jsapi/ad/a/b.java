package com.tencent.mm.plugin.appbrand.jsapi.ad.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.d.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.ad.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;

@TargetApi(5)
public class b extends a {
    private a mFB;
    private c.b mFC;
    private int mFE;
    private Runnable mFF = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.ad.a.b.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(137895);
            b.this.bLl();
            AppMethodBeat.o(137895);
        }
    };

    public b() {
        AppMethodBeat.i(137896);
        AppMethodBeat.o(137896);
    }

    /* access modifiers changed from: protected */
    public synchronized void release() {
        AppMethodBeat.i(137897);
        this.mFC = null;
        if (this.mFB != null) {
            this.mFB.dBf.release();
            this.mFB = null;
        }
        AppMethodBeat.o(137897);
    }

    public com.tencent.mm.plugin.appbrand.jsapi.ad.c bLl() {
        AppMethodBeat.i(137898);
        if (this.mFB == null) {
            Log.e("MicroMsg.DefaultLuggageRecorder", "mRecorderPcm is null, err");
            com.tencent.mm.plugin.appbrand.jsapi.ad.c cVar = new com.tencent.mm.plugin.appbrand.jsapi.ad.c("may be not start", new Object[0]);
            AppMethodBeat.o(137898);
            return cVar;
        }
        this.mFB.ZZ();
        String str = this.mFC.filePath;
        int i2 = this.mFE;
        int boW = (int) s.boW(this.mFC.filePath);
        S(str, i2, boW);
        Log.i("MicroMsg.DefaultLuggageRecorder", "stopRecord() filePath:%s duration:%d fileSize:%d", str, Integer.valueOf(i2), Integer.valueOf(boW));
        release();
        com.tencent.mm.plugin.appbrand.jsapi.ad.c cVar2 = com.tencent.mm.plugin.appbrand.jsapi.ad.c.mFz;
        AppMethodBeat.o(137898);
        return cVar2;
    }
}
