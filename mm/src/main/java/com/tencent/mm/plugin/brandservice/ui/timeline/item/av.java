package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class av extends ag {
    public final View cU(Context context) {
        AppMethodBeat.i(194977);
        if (this.puO != null) {
            View view = this.puO;
            AppMethodBeat.o(194977);
            return view;
        }
        this.puO = View.inflate(context, R.layout.l5, null);
        cne();
        View view2 = this.puO;
        AppMethodBeat.o(194977);
        return view2;
    }
}
