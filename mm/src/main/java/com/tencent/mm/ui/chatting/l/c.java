package com.tencent.mm.ui.chatting.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;

public final class c {
    public static final c PEZ = new c();
    public int IvL;
    public int PFa;
    public int PFb;
    public int PFc;
    public int mCount;
    public int mSuccessCount;

    static {
        AppMethodBeat.i(36612);
        AppMethodBeat.o(36612);
    }

    public final void f(boolean z, boolean z2, String str) {
        AppMethodBeat.i(36607);
        Log.i("MicroMsg.GetChatroomReporter", "[recordFetch] isDown:" + z + " isSuccess:" + z2 + " chatroomid:" + str);
        if (z) {
            this.PFa++;
        } else {
            this.PFb++;
        }
        this.mCount++;
        if (!z2) {
            this.IvL++;
            AppMethodBeat.o(36607);
            return;
        }
        this.mSuccessCount++;
        AppMethodBeat.o(36607);
    }

    public final void anx(int i2) {
        this.PFc += i2;
    }

    public static void aU(String str, int i2, int i3) {
        AppMethodBeat.i(36608);
        Log.i("MicroMsg.GetChatroomReporter", "[report] chatroomId:%s cleanCount:%s count:%s ", str, Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 > 0) {
            e.INSTANCE.idkeyStat(403, 67, 1, true);
            e.INSTANCE.idkeyStat(403, 68, (long) i2, true);
        }
        e.INSTANCE.idkeyStat(403, 70, (long) i3, true);
        if (i3 <= 5) {
            e.INSTANCE.idkeyStat(403, 71, 1, true);
            AppMethodBeat.o(36608);
        } else if (i3 <= 10) {
            e.INSTANCE.idkeyStat(403, 72, 1, true);
            AppMethodBeat.o(36608);
        } else if (i3 <= 20) {
            e.INSTANCE.idkeyStat(403, 73, 1, true);
            AppMethodBeat.o(36608);
        } else if (i3 <= 30) {
            e.INSTANCE.idkeyStat(403, 74, 1, true);
            AppMethodBeat.o(36608);
        } else if (i3 <= 50) {
            e.INSTANCE.idkeyStat(403, 75, 1, true);
            AppMethodBeat.o(36608);
        } else {
            e.INSTANCE.idkeyStat(403, 76, 1, true);
            AppMethodBeat.o(36608);
        }
    }

    public static void gTH() {
        AppMethodBeat.i(36609);
        e.INSTANCE.idkeyStat(403, 77, 1, true);
        AppMethodBeat.o(36609);
    }

    public static void gTI() {
        AppMethodBeat.i(36610);
        e.INSTANCE.idkeyStat(403, 41, 1, false);
        AppMethodBeat.o(36610);
    }

    public static void gTJ() {
        AppMethodBeat.i(36611);
        e.INSTANCE.idkeyStat(403, 78, 1, false);
        AppMethodBeat.o(36611);
    }
}
