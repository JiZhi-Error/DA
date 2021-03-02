package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class c {
    private static c hce;
    public boolean gZj;
    public long hcf;
    public int hcg;
    public int hch;
    public int scene;

    public static c awc() {
        AppMethodBeat.i(104481);
        if (hce == null) {
            hce = new c();
        }
        c cVar = hce;
        AppMethodBeat.o(104481);
        return cVar;
    }

    public final void zj(long j2) {
        AppMethodBeat.i(104482);
        Log.i("EmojiClickReport", "panelShow");
        this.hcf = j2;
        this.hcg = 1;
        AppMethodBeat.o(104482);
    }

    public final void a(String str, boolean z, int i2) {
        int i3 = 1;
        AppMethodBeat.i(104483);
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.hcf;
        h hVar = h.INSTANCE;
        Object[] objArr = new Object[12];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(this.scene);
        objArr[2] = Integer.valueOf(z ? 1 : 0);
        objArr[3] = 0;
        objArr[4] = 0;
        objArr[5] = Integer.valueOf(i2);
        if (!this.gZj) {
            i3 = 0;
        }
        objArr[6] = Integer.valueOf(i3);
        objArr[7] = Integer.valueOf(this.hch);
        objArr[8] = Integer.valueOf(this.hcg);
        objArr[9] = Long.valueOf(j2);
        objArr[10] = Long.valueOf(currentTimeMillis);
        objArr[11] = Long.valueOf(this.hcf);
        hVar.a(13470, objArr);
        this.hcg++;
        AppMethodBeat.o(104483);
    }
}
