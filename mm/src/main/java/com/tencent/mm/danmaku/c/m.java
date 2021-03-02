package com.tencent.mm.danmaku.c;

import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.a.c;
import com.tencent.ugc.TXRecordCommon;

public final class m {
    private static boolean gPM = true;
    public static int gPS = 16;
    public int atU;
    public int gOF;
    public float gOR;
    public boolean gOS;
    public int gPH;
    public int gPI;
    public int gPJ;
    public float gPK;
    public boolean gPL = true;
    public float gPN;
    public float gPO;
    public float gPP;
    public float gPQ;
    private boolean gPR = false;
    public int mScreenHeight;
    public int mScreenWidth;

    public m() {
        AppMethodBeat.i(241693);
        DisplayMetrics displayMetrics = c.arU().getResources().getDisplayMetrics();
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        if (this.gPR) {
            this.mScreenHeight = Math.max(i2, i3);
            this.mScreenWidth = Math.min(i2, i3);
        } else {
            this.mScreenHeight = Math.min(i2, i3);
            this.mScreenWidth = Math.max(i2, i3);
        }
        this.atU = TXRecordCommon.AUDIO_SAMPLERATE_8000;
        pa(12);
        this.gOF = 3;
        am(1.5f);
        this.gPJ = com.tencent.mm.danmaku.e.c.ao(1.0f);
        this.gPK = (float) com.tencent.mm.danmaku.e.c.ao(5.0f);
        this.gOR = (float) com.tencent.mm.danmaku.e.c.ao(5.0f);
        this.gPL = true;
        this.gOS = true;
        this.gPN = (float) com.tencent.mm.danmaku.e.c.ao(16.0f);
        this.gPO = 0.0f;
        an(5.0f);
        this.gPQ = (float) com.tencent.mm.danmaku.e.c.ao(4.0f);
        AppMethodBeat.o(241693);
    }

    public static void asX() {
        gPM = false;
    }

    public static boolean asY() {
        return gPM;
    }

    public final void asZ() {
        this.gOF = 2;
    }

    public final void pa(int i2) {
        AppMethodBeat.i(241694);
        this.gPH = com.tencent.mm.danmaku.e.c.ao((float) i2);
        AppMethodBeat.o(241694);
    }

    public final void am(float f2) {
        AppMethodBeat.i(241695);
        this.gPI = com.tencent.mm.danmaku.e.c.ao(f2);
        AppMethodBeat.o(241695);
    }

    public final void ata() {
        this.atU = 6000;
    }

    public final void atb() {
        this.gPL = true;
    }

    public final void an(float f2) {
        AppMethodBeat.i(241696);
        this.gPP = (float) com.tencent.mm.danmaku.e.c.ao(f2);
        AppMethodBeat.o(241696);
    }
}
