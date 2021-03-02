package com.tencent.mm.plugin.setting.ui.setting;

import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b {
    LinearLayout DfK;
    LinearLayout DfL;
    LinearLayout DfM;
    LinearLayout DfN;
    LinearLayout DfO;

    b() {
    }

    public final void aNi(String str) {
        AppMethodBeat.i(74625);
        if (str.equals("downloading")) {
            this.DfK.setVisibility(0);
            this.DfL.setVisibility(8);
            this.DfM.setVisibility(8);
            this.DfN.setVisibility(8);
            this.DfO.setVisibility(8);
            AppMethodBeat.o(74625);
        } else if (str.equals("downloaded")) {
            this.DfK.setVisibility(8);
            this.DfL.setVisibility(0);
            this.DfM.setVisibility(8);
            this.DfN.setVisibility(8);
            this.DfO.setVisibility(8);
            AppMethodBeat.o(74625);
        } else if (str.equals("undownloaded")) {
            this.DfK.setVisibility(8);
            this.DfL.setVisibility(8);
            this.DfM.setVisibility(0);
            this.DfN.setVisibility(8);
            this.DfO.setVisibility(8);
            AppMethodBeat.o(74625);
        } else if (str.equals("using")) {
            this.DfK.setVisibility(8);
            this.DfL.setVisibility(8);
            this.DfM.setVisibility(8);
            this.DfN.setVisibility(0);
            this.DfO.setVisibility(8);
            AppMethodBeat.o(74625);
        } else if (str.equals("canceling")) {
            this.DfK.setVisibility(8);
            this.DfL.setVisibility(8);
            this.DfM.setVisibility(8);
            this.DfN.setVisibility(8);
            this.DfO.setVisibility(0);
            AppMethodBeat.o(74625);
        } else {
            AppMethodBeat.o(74625);
        }
    }
}
