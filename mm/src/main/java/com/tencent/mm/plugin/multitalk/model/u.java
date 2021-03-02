package com.tencent.mm.plugin.multitalk.model;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bh.e;

public final class u {
    private boolean zNL;
    private boolean zNM;

    public final void as(Activity activity) {
        AppMethodBeat.i(114574);
        if (!this.zNL) {
            this.zNL = true;
            e.a(activity, R.string.f6p, null);
        }
        AppMethodBeat.o(114574);
    }

    public final void at(Activity activity) {
        AppMethodBeat.i(114575);
        if (!this.zNM) {
            this.zNM = true;
            com.tencent.mm.ui.base.u.cF(activity, activity.getResources().getText(R.string.i1j).toString());
        }
        AppMethodBeat.o(114575);
    }

    public final void reset() {
        this.zNM = false;
        this.zNL = false;
    }
}
