package com.tencent.mm.al.c;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.protocal.protobuf.eww;

public final class b {
    private boolean iQO = false;
    private eww iQP;

    public final void fI(String str) {
        AppMethodBeat.i(212208);
        if (this.iQP != null) {
            AppMethodBeat.o(212208);
            return;
        }
        if (!this.iQO) {
            n.Nu(str);
            this.iQO = true;
        }
        this.iQP = n.Nt(str);
        AppMethodBeat.o(212208);
    }

    public final void z(Activity activity) {
        AppMethodBeat.i(212209);
        if (this.iQP == null) {
            AppMethodBeat.o(212209);
            return;
        }
        switch (this.iQP.vjQ) {
            case 1:
                a.a(activity, this.iQP.Nup);
                AppMethodBeat.o(212209);
                return;
            case 2:
                a.a(activity, this.iQP.Nuq);
                break;
        }
        AppMethodBeat.o(212209);
    }
}
