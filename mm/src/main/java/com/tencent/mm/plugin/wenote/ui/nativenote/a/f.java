package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.e;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.Util;

public final class f extends a {
    private TextView JKQ;
    private View JKR;
    public LinearLayout JKS;

    public f(View view, k kVar) {
        super(view, kVar);
        AppMethodBeat.i(30858);
        this.JKS = (LinearLayout) view.findViewById(R.id.g1f);
        this.JKS.setVisibility(0);
        this.JKQ = (TextView) view.findViewById(R.id.g1h);
        this.JKR = view.findViewById(R.id.g1g);
        AppMethodBeat.o(30858);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a
    public final void a(c cVar, int i2, int i3) {
        Object format;
        AppMethodBeat.i(30859);
        if (cVar.getType() != -3) {
            AppMethodBeat.o(30859);
        } else if (this.JJu.JIH == 3) {
            this.JKS.setVisibility(8);
            AppMethodBeat.o(30859);
        } else {
            this.JKS.setVisibility(0);
            e eVar = (e) cVar;
            if (eVar.JHM <= 0) {
                AppMethodBeat.o(30859);
                return;
            }
            Context context = this.JKQ.getContext();
            long j2 = eVar.JHM;
            if (j2 < Util.MILLSECONDS_OF_HOUR) {
                format = "";
            } else {
                format = DateFormat.format(context.getString(R.string.ca5), j2);
            }
            this.JKQ.setText(this.JKQ.getContext().getString(R.string.fe_) + " " + format);
            AppMethodBeat.o(30859);
        }
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a
    public final int cCY() {
        return -3;
    }
}
