package com.tencent.mm.kernel.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.a.b;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import junit.framework.Assert;

public final class a {
    public static long hrN;
    public static long hrO;
    public static long hrP;
    public b hrL;
    public b hrM;
    private volatile boolean mConfigured = false;

    public final void a(b bVar) {
        AppMethodBeat.i(158326);
        Assert.assertNotNull(bVar);
        h.aAl().aAe();
        this.hrM = bVar;
        AppMethodBeat.o(158326);
    }

    public final void aAr() {
        AppMethodBeat.i(158327);
        Assert.assertNotNull("You must call whichBootStep(BootStep defaultOne, BootStep ... bootSteps) to specify your BootStep instance first!", this.hrM);
        AppMethodBeat.o(158327);
    }

    public final void VZ() {
        AppMethodBeat.i(158328);
        hrP = SystemClock.elapsedRealtime();
        k("hello WeChat.", new Object[0]);
        this.hrM.VZ();
        AppMethodBeat.o(158328);
    }

    public static final void k(String str, Object... objArr) {
        AppMethodBeat.i(158332);
        if (objArr.length == 0) {
            j.i("MMSkeleton.Boot", str, new Object[0]);
            AppMethodBeat.o(158332);
            return;
        }
        j.i("MMSkeleton.Boot", str, objArr);
        AppMethodBeat.o(158332);
    }

    public static String zr(long j2) {
        AppMethodBeat.i(158333);
        String str = (System.currentTimeMillis() - j2) + LocaleUtil.MALAY;
        AppMethodBeat.o(158333);
        return str;
    }

    public final void Wa() {
        AppMethodBeat.i(158329);
        long currentTimeMillis = System.currentTimeMillis();
        k("boot install plugins...", new Object[0]);
        this.hrM.Wa();
        this.mConfigured = true;
        k("boot all installed plugins : %s...", h.aAl().aAd().azF());
        k("boot install plugins done in [%s].", zr(currentTimeMillis));
        AppMethodBeat.o(158329);
    }

    public final void aAs() {
        AppMethodBeat.i(158330);
        long currentTimeMillis = System.currentTimeMillis();
        k("boot make dependency of plugins...", new Object[0]);
        this.hrM.aAs();
        k("boot make dependency of done in [%s].", zr(currentTimeMillis));
        AppMethodBeat.o(158330);
    }

    public final void a(g gVar) {
        AppMethodBeat.i(158331);
        long currentTimeMillis = System.currentTimeMillis();
        k("boot configure plugins...", new Object[0]);
        this.hrM.a(gVar);
        k("boot configure plugins done in [%s].", zr(currentTimeMillis));
        AppMethodBeat.o(158331);
    }
}
