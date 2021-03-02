package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.brandservice.ui.b.d;

public final class am extends a {
    public ProgressBar progressBar;
    public View puO;
    public LinearLayout pyc;
    public TextView pyd;
    public TextView pye;
    public LinearLayout pyf;
    public TextView pyg;

    public final View cU(Context context) {
        AppMethodBeat.i(194973);
        if (this.puO != null) {
            View view = this.puO;
            AppMethodBeat.o(194973);
            return view;
        }
        this.puO = View.inflate(context, R.layout.k3, null);
        this.pyc = (LinearLayout) this.puO.findViewById(R.id.a7t);
        this.pyd = (TextView) this.puO.findViewById(R.id.a8x);
        this.pyf = (LinearLayout) this.puO.findViewById(R.id.a8r);
        this.pyg = (TextView) this.puO.findViewById(R.id.a8s);
        this.progressBar = (ProgressBar) this.puO.findViewById(R.id.a8v);
        this.pye = (TextView) this.puO.findViewById(R.id.a8w);
        d dVar = d.pMy;
        d.i(this.pyd);
        d dVar2 = d.pMy;
        d.i(this.pye);
        View view2 = this.puO;
        AppMethodBeat.o(194973);
        return view2;
    }
}
