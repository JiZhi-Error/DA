package com.tencent.mm.ui.widget.cedit.api;

import android.text.InputFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.f;
import java.lang.ref.WeakReference;

public final class d extends c {
    protected WeakReference<c> QFO;

    private d(WeakReference<c> weakReference) {
        super("");
        this.QFO = weakReference;
    }

    public static d a(c cVar) {
        AppMethodBeat.i(205446);
        d dVar = new d(new WeakReference(cVar));
        AppMethodBeat.o(205446);
        return dVar;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ui.tools.b.c, com.tencent.mm.ui.tools.b.a
    public final void dSw() {
        AppMethodBeat.i(205447);
        if (!this.QxK) {
            if (this.QFO == null) {
                Log.w("MicroMsg.InputIEdtBoundaryCheck", "edit text view is null");
                AppMethodBeat.o(205447);
                return;
            } else if (Util.isNullOrNil(this.QxO)) {
                this.QFO.get().setFilters(new InputFilter[]{a(this.QxM, this.ots)});
            } else {
                this.QxO.add(a(this.QxM, this.ots));
                this.QFO.get().setFilters((InputFilter[]) this.QxO.toArray(new InputFilter[this.QxO.size()]));
            }
        }
        if (this.QxP != null) {
            switch (bCj()) {
                case 0:
                    this.QxP.Tw(this.mText);
                    AppMethodBeat.o(205447);
                    return;
                case 1:
                    this.QxP.Tx(this.mText);
                    AppMethodBeat.o(205447);
                    return;
                case 2:
                    this.QxP.dv(this.mText);
                    break;
            }
        }
        AppMethodBeat.o(205447);
    }

    @Override // com.tencent.mm.ui.tools.b.c, com.tencent.mm.ui.tools.b.a
    public final int bCj() {
        boolean z;
        AppMethodBeat.i(205448);
        if (Util.isNullOrNil(this.mText)) {
            if (this.QFO == null) {
                AppMethodBeat.o(205448);
                return 1;
            }
            this.mText = this.QFO.get().getText().toString().trim();
        }
        int a2 = f.a(this.mText, this.ots);
        if (a2 < 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Log.w("MicroMsg.InputIEdtBoundaryCheck", "you are crazy =.=!that is 2 GB character!");
            AppMethodBeat.o(205448);
            return 2;
        } else if (a2 < this.QxN) {
            AppMethodBeat.o(205448);
            return 1;
        } else if (a2 > this.QxM) {
            AppMethodBeat.o(205448);
            return 2;
        } else {
            AppMethodBeat.o(205448);
            return 0;
        }
    }
}
