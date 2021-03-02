package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Util;

public class LoadingMoreView extends LinearLayout {
    protected LinearLayout ErQ;
    protected TextView ErR;
    Animation ErS = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
    private Context context;
    ImageView dPk;
    protected LinearLayout pXt;
    protected LinearLayout pXu;

    public LoadingMoreView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(97930);
        this.context = context2;
        init();
        AppMethodBeat.o(97930);
    }

    public LoadingMoreView(Context context2) {
        super(context2);
        AppMethodBeat.i(97931);
        this.context = context2;
        init();
        AppMethodBeat.o(97931);
    }

    private void init() {
        AppMethodBeat.i(97932);
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.bwn, (ViewGroup) this, true);
        this.dPk = (ImageView) findViewById(R.id.ki);
        this.pXt = (LinearLayout) inflate.findViewById(R.id.epm);
        this.pXu = (LinearLayout) inflate.findViewById(R.id.epf);
        this.ErQ = (LinearLayout) inflate.findViewById(R.id.gu9);
        this.ErR = (TextView) inflate.findViewById(R.id.gu_);
        this.pXt.setVisibility(0);
        this.pXu.setVisibility(8);
        this.ErQ.setVisibility(8);
        this.ErS.setDuration(1000);
        this.ErS.setRepeatCount(-1);
        this.ErS.setInterpolator(new LinearInterpolator());
        this.dPk.startAnimation(this.ErS);
        AppMethodBeat.o(97932);
    }

    public final void PL() {
        AppMethodBeat.i(97933);
        this.pXt.setVisibility(0);
        this.pXu.setVisibility(8);
        this.ErQ.setVisibility(8);
        AppMethodBeat.o(97933);
    }

    public final void aQU(String str) {
        AppMethodBeat.i(97934);
        this.pXt.setVisibility(8);
        if (Util.isNullOrNil(str)) {
            this.pXu.setVisibility(0);
            this.ErQ.setVisibility(8);
            AppMethodBeat.o(97934);
            return;
        }
        this.ErQ.setVisibility(0);
        this.pXu.setVisibility(8);
        this.ErR.setText(str);
        AppMethodBeat.o(97934);
    }
}
