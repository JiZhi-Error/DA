package com.tencent.mm.plugin.sns.ad.g;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.a.a.a.g;
import com.tencent.mm.plugin.sns.d.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class n {
    public static n Dwr = new n();
    public g<String, Bitmap> Dwq = new g<>(5);

    static {
        AppMethodBeat.i(95042);
        AppMethodBeat.o(95042);
    }

    private n() {
        AppMethodBeat.i(95040);
        AppMethodBeat.o(95040);
    }

    public final Bitmap getBitmap(String str) {
        Bitmap k;
        AppMethodBeat.i(95041);
        if (!this.Dwq.check(str) || (k = this.Dwq.aT(str)) == null) {
            Log.i("MicroMsg.SnsTimelineAdResourceMgr", "not hit cache %s", str);
            k = a.k(str, 0.1f);
            if (k != null) {
                this.Dwq.put(str, k);
            }
            AppMethodBeat.o(95041);
        } else {
            Log.i("MicroMsg.SnsTimelineAdResourceMgr", "hit cache %s", str);
            AppMethodBeat.o(95041);
        }
        return k;
    }
}
