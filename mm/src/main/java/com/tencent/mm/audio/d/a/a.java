package com.tencent.mm.audio.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.media.record.a.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {
    public b dBf;
    private d dBg;
    private Object dBh;

    public final boolean ZZ() {
        boolean z;
        AppMethodBeat.i(146311);
        if (this.dBf == null) {
            Log.e("MicroMsg.RecorderPcm", "stopRecord fail, recorder is null, return");
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(146311);
            return false;
        }
        boolean ZZ = this.dBf.ZZ();
        synchronized (this.dBh) {
            try {
                if (this.dBg != null) {
                    this.dBg.flush();
                    this.dBg.close();
                    this.dBg = null;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(146311);
                throw th;
            }
        }
        this.dBf.release();
        Log.i("MicroMsg.RecorderPcm", "stopRecord:%b", Boolean.valueOf(ZZ));
        AppMethodBeat.o(146311);
        return ZZ;
    }
}
