package com.tencent.mm.plugin.subapp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsListener;

public final class b implements ay.c {
    @Override // com.tencent.mm.model.ay.c
    public final String rV(int i2) {
        AppMethodBeat.i(28906);
        String ba = ba(i2, true);
        AppMethodBeat.o(28906);
        return ba;
    }

    @Override // com.tencent.mm.model.ay.c
    public final String rW(int i2) {
        AppMethodBeat.i(28907);
        String ba = ba(i2, false);
        AppMethodBeat.o(28907);
        return ba;
    }

    private String ba(int i2, boolean z) {
        AppMethodBeat.i(28908);
        bg.aVF();
        if (!c.isSDCardAvailable()) {
            AppMethodBeat.o(28908);
            return null;
        }
        String bb = bb(i2, z);
        if (s.YS(bb)) {
            AppMethodBeat.o(28908);
            return bb;
        }
        aVq();
        AppMethodBeat.o(28908);
        return null;
    }

    @Override // com.tencent.mm.model.ay.c
    public final void aVq() {
        AppMethodBeat.i(28909);
        bg.aVF();
        if (!c.isSDCardAvailable()) {
            AppMethodBeat.o(28909);
            return;
        }
        bg.aVF();
        long nullAs = Util.nullAs((Long) c.azQ().get(66051, (Object) null), 0);
        long nowMilliSecond = Util.nowMilliSecond();
        if (432000000 > nowMilliSecond - nullAs) {
            AppMethodBeat.o(28909);
            return;
        }
        bg.aVF();
        c.azQ().set(66051, Long.valueOf(nowMilliSecond));
        new a();
        AppMethodBeat.o(28909);
    }

    /* access modifiers changed from: package-private */
    public static class a implements i {
        public a() {
            AppMethodBeat.i(28904);
            bg.azz().a(TbsListener.ErrorCode.STARTDOWNLOAD_8, this);
            bg.azz().a(new a(), 0);
            AppMethodBeat.o(28904);
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(28905);
            bg.azz().b(TbsListener.ErrorCode.STARTDOWNLOAD_8, this);
            AppMethodBeat.o(28905);
        }
    }

    @Override // com.tencent.mm.model.ay.c
    public final boolean rX(int i2) {
        AppMethodBeat.i(28910);
        if (i2 == 0) {
            AppMethodBeat.o(28910);
            return false;
        }
        for (int i3 = 0; i3 < 32; i3++) {
            if (!s.YS(E((1 << i3) & i2, false)) || !s.YS(E((1 << i3) & i2, true))) {
                AppMethodBeat.o(28910);
                return false;
            }
        }
        AppMethodBeat.o(28910);
        return true;
    }

    private String bb(int i2, boolean z) {
        AppMethodBeat.i(28911);
        int abj = abj(i2);
        if (abj == 0) {
            AppMethodBeat.o(28911);
            return null;
        }
        String E = E(abj, z);
        AppMethodBeat.o(28911);
        return E;
    }

    @Override // com.tencent.mm.model.ay.c
    public final String E(int i2, boolean z) {
        AppMethodBeat.i(28912);
        if (i2 == 0) {
            AppMethodBeat.o(28912);
            return null;
        }
        String str = com.tencent.mm.loader.j.b.aKN() + "vuserpic_" + Integer.toHexString(i2) + (z ? "_HD" : "") + ".png";
        AppMethodBeat.o(28912);
        return str;
    }

    private static int abi(int i2) {
        if (i2 == 0) {
            return -1;
        }
        int i3 = 0;
        while (i3 < 32 && (i2 = (i2 >> 1) & Integer.MAX_VALUE) != 0) {
            i3++;
        }
        return i3;
    }

    private static int abj(int i2) {
        AppMethodBeat.i(28913);
        int abi = abi(i2);
        if (abi == -1) {
            AppMethodBeat.o(28913);
            return 0;
        }
        int i3 = 1 << abi;
        AppMethodBeat.o(28913);
        return i3;
    }
}
