package com.tencent.mm.ui.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b {
    private List<String> OLY = new ArrayList();
    private final String TAG = "MicroMsg.Accessibility.Tool";

    public b() {
        AppMethodBeat.i(141500);
        AppMethodBeat.o(141500);
    }

    public final b blW(String str) {
        AppMethodBeat.i(141501);
        this.OLY.add(str);
        AppMethodBeat.o(141501);
        return this;
    }

    public final void gt(View view) {
        AppMethodBeat.i(141502);
        if (view != null && this.OLY.size() > 0) {
            String str = "";
            Iterator<String> it = this.OLY.iterator();
            while (it.hasNext()) {
                str = str + it.next() + ",";
            }
            view.setContentDescription(str);
        }
        AppMethodBeat.o(141502);
    }
}
