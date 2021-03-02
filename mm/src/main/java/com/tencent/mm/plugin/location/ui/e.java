package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class e implements c {
    public boolean dJM = false;
    private boolean isVisible = true;
    public String kHV;
    private String yFq;
    private double yFu = 1000000.0d;
    private double yFv = 1000000.0d;
    private boolean yHP = true;
    private View yHQ;
    private d yHR;
    private TextView yHS;
    private TextView yHT;
    public ImageButton yHU;
    private String yHw = "";

    public e(d dVar, Context context) {
        AppMethodBeat.i(55842);
        View findViewById = ((Activity) context).findViewById(R.id.eqb);
        this.yHS = (TextView) findViewById.findViewById(R.id.eq_);
        this.yHT = (TextView) findViewById.findViewById(R.id.eqa);
        this.yHU = (ImageButton) findViewById.findViewById(R.id.eqj);
        this.yHR = dVar;
        this.yHQ = findViewById;
        AppMethodBeat.o(55842);
    }

    @Override // com.tencent.mm.plugin.location.ui.c
    public final void setText(String str) {
        AppMethodBeat.i(55843);
        this.yFq = str;
        String str2 = this.yFq;
        Log.d("NewItemOverlay", "popView " + this.yHQ.getWidth() + " " + this.yHQ.getHeight());
        if (str2 != null && !str2.equals("")) {
            this.yHT.setText(str2);
        }
        if (this.kHV == null || this.kHV.equals("")) {
            this.yHS.setText(R.string.ekg);
        } else {
            this.yHS.setText(this.kHV);
        }
        if (this.yHP) {
            this.yHQ.setVisibility(0);
            this.yHQ.invalidate();
        }
        AppMethodBeat.o(55843);
    }

    @Override // com.tencent.mm.plugin.location.ui.c
    public final String getPreText() {
        return this.yHw;
    }
}
