package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h extends LinearLayout {
    private int EoC = 6;
    private LinearLayout EoD;
    private int bva = 0;
    private Context context;

    public final void setLineMaxCounte(int i2) {
        if (i2 > 0) {
            this.EoC = i2;
        }
    }

    public h(Context context2) {
        super(context2);
        AppMethodBeat.i(97792);
        this.context = context2;
        setOrientation(1);
        AppMethodBeat.o(97792);
    }

    public final void addView(View view) {
        AppMethodBeat.i(97793);
        if (this.bva % this.EoC == 0) {
            this.EoD = new LinearLayout(this.context);
            this.EoD.setOrientation(0);
            this.EoD.addView(view);
            super.addView(this.EoD);
        } else {
            this.EoD.addView(view);
        }
        this.bva++;
        AppMethodBeat.o(97793);
    }
}
