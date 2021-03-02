package com.tencent.thumbplayer.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.g.a.a;
import com.tencent.thumbplayer.utils.g;

public final class b implements a {
    @Override // com.tencent.thumbplayer.g.a.a
    public final void aSs() {
    }

    @Override // com.tencent.thumbplayer.g.a.a
    public final void onDetach() {
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.thumbplayer.g.a.a
    public final void b(int i2, int i3, int i4, String str, Object obj) {
        AppMethodBeat.i(189522);
        switch (i2) {
            case 101:
                g.d("TPLogPlugin", "create player adapter");
                AppMethodBeat.o(189522);
                return;
            case 102:
                g.d("TPLogPlugin", "start prepare");
                AppMethodBeat.o(189522);
                return;
            case 103:
                g.d("TPLogPlugin", "on prepared");
                AppMethodBeat.o(189522);
                return;
            case 104:
                g.d("TPLogPlugin", "start play");
                AppMethodBeat.o(189522);
                return;
            case 106:
                g.d("TPLogPlugin", "on paused");
                AppMethodBeat.o(189522);
                return;
            case 107:
                g.d("TPLogPlugin", "on stoped");
                AppMethodBeat.o(189522);
                return;
            case 108:
                g.d("TPLogPlugin", "on error:".concat(String.valueOf(i3)));
                AppMethodBeat.o(189522);
                return;
            case 109:
                g.d("TPLogPlugin", "start seek");
                AppMethodBeat.o(189522);
                return;
            case 110:
                g.d("TPLogPlugin", "seek complete");
                AppMethodBeat.o(189522);
                return;
            case 111:
                g.d("TPLogPlugin", "on play complete");
                AppMethodBeat.o(189522);
                return;
            case 112:
                g.d("TPLogPlugin", "on release");
                break;
            case 113:
                g.d("TPLogPlugin", "on reset");
                AppMethodBeat.o(189522);
                return;
        }
        AppMethodBeat.o(189522);
    }
}
