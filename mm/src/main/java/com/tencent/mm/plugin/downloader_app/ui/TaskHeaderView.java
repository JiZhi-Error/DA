package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader_app.a.i;

public class TaskHeaderView extends LinearLayout {
    private TextView qMD;
    private TextView qME;
    private View qMF;

    public TaskHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(9022);
        super.onFinishInflate();
        this.qMF = findViewById(R.id.brs);
        this.qMD = (TextView) findViewById(R.id.eah);
        this.qME = (TextView) findViewById(R.id.h7p);
        AppMethodBeat.o(9022);
    }

    public final void a(i iVar, boolean z) {
        AppMethodBeat.i(9023);
        if (iVar.type == 1) {
            this.qMD.setText(getResources().getString(R.string.boc));
            this.qME.setVisibility(8);
        } else if (iVar.type == 3) {
            this.qMD.setText(getResources().getString(R.string.hsz));
            this.qME.setText(getResources().getString(R.string.hsy, Integer.valueOf(iVar.qLh)));
            this.qME.setVisibility(0);
        } else if (iVar.type == 5) {
            this.qMD.setText(getResources().getString(R.string.bnv));
            this.qME.setVisibility(8);
        }
        if (z) {
            this.qMF.setVisibility(0);
        } else {
            this.qMF.setVisibility(8);
        }
        if (iVar.pSk) {
            this.qMD.setTextColor(getContext().getResources().getColor(R.color.m6));
            this.qME.setVisibility(8);
            AppMethodBeat.o(9023);
            return;
        }
        this.qMD.setTextColor(getContext().getResources().getColor(R.color.wb));
        this.qME.setVisibility(0);
        AppMethodBeat.o(9023);
    }
}
