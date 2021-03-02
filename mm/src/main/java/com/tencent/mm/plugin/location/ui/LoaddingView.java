package com.tencent.mm.plugin.location.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Util;

public class LoaddingView extends LinearLayout implements c {
    private Animation FN;
    private TextView yHs;
    private ProgressBar yHt;
    private View yHu;
    private boolean yHv = false;
    private String yHw = "";

    @TargetApi(11)
    public LoaddingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(55801);
        init(context);
        AppMethodBeat.o(55801);
    }

    public LoaddingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(55802);
        init(context);
        AppMethodBeat.o(55802);
    }

    private void init(Context context) {
        AppMethodBeat.i(55803);
        this.FN = AnimationUtils.loadAnimation(context, R.anim.fc);
        View inflate = LayoutInflater.from(context).inflate(R.layout.b2e, (ViewGroup) this, true);
        this.yHt = (ProgressBar) inflate.findViewById(R.id.eqg);
        this.yHs = (TextView) inflate.findViewById(R.id.eqx);
        this.yHu = inflate.findViewById(R.id.eq8);
        this.yHs.setText("");
        this.yHs.setVisibility(0);
        this.yHt.setVisibility(0);
        AppMethodBeat.o(55803);
    }

    public void setProgressAlwaysGone(boolean z) {
        AppMethodBeat.i(55804);
        this.yHv = z;
        this.yHt.setVisibility(8);
        this.yHs.setVisibility(8);
        AppMethodBeat.o(55804);
    }

    @Override // com.tencent.mm.plugin.location.ui.c
    public void setText(String str) {
        AppMethodBeat.i(55805);
        if (this.yHs == null || this.yHt == null || this.yHv) {
            AppMethodBeat.o(55805);
        } else if (!Util.isNullOrNil(str)) {
            this.yHs.setText(String.valueOf(str));
            this.yHt.setVisibility(8);
            this.yHs.setVisibility(0);
            AppMethodBeat.o(55805);
        } else {
            this.yHs.setText("");
            this.yHs.setVisibility(0);
            this.yHt.setVisibility(0);
            AppMethodBeat.o(55805);
        }
    }

    public void setPreText(String str) {
        AppMethodBeat.i(55806);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(55806);
            return;
        }
        this.yHw = str + "\n";
        AppMethodBeat.o(55806);
    }

    @Override // com.tencent.mm.plugin.location.ui.c
    public String getPreText() {
        return this.yHw;
    }
}
