package com.tencent.mm.plugin.voip_cs.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a {
    private static a HrS;
    public e qtg = new e(MMApplicationContext.getContext());

    private a() {
        AppMethodBeat.i(125364);
        AppMethodBeat.o(125364);
    }

    public static a fMA() {
        AppMethodBeat.i(125365);
        if (HrS == null) {
            HrS = new a();
        }
        a aVar = HrS;
        AppMethodBeat.o(125365);
        return aVar;
    }

    public static a fMB() {
        AppMethodBeat.i(125366);
        if (HrS == null) {
            HrS = fMA();
        }
        a aVar = HrS;
        AppMethodBeat.o(125366);
        return aVar;
    }

    public final void fMC() {
        AppMethodBeat.i(125367);
        if (this.qtg != null) {
            this.qtg.bl(0, true);
        }
        AppMethodBeat.o(125367);
    }

    public final void stopRing() {
        AppMethodBeat.i(125368);
        if (this.qtg != null) {
            this.qtg.stop();
        }
        AppMethodBeat.o(125368);
    }

    public final boolean czl() {
        AppMethodBeat.i(125369);
        if (this.qtg != null) {
            boolean YZ = this.qtg.YZ();
            AppMethodBeat.o(125369);
            return YZ;
        }
        AppMethodBeat.o(125369);
        return true;
    }
}
