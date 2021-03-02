package com.tencent.mm.plugin.sns.ui.b;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class a {
    protected Context ETH;
    protected b ETI;
    protected int ETJ;
    protected int ETK;
    protected int ETL;
    protected int ETM;
    protected int ETN;
    protected int ETO;
    protected boolean Exy;
    protected int targetHeight;
    protected int targetWidth;
    protected View view;
    protected ValueAnimator yTl;

    public a(Activity activity, View view2, boolean z) {
        this.ETH = activity;
        this.view = view2;
        this.Exy = z;
    }

    public final void aG(Bundle bundle) {
        AppMethodBeat.i(176405);
        this.ETJ = bundle.getInt("param_thumb_left");
        this.ETK = bundle.getInt("param_thumb_top");
        this.ETL = bundle.getInt("param_thumb_width");
        this.ETM = bundle.getInt("param_thumb_height");
        this.targetWidth = bundle.getInt("param_target_width");
        this.targetHeight = bundle.getInt("param_target_height");
        this.ETN = this.targetHeight - this.ETM;
        this.ETO = this.targetWidth - this.ETL;
        Log.i("MicroMsg.SnsAdAnimation", "left=%s, top=%s, width=%s, height=%s, targetW=%s, targetH=%s", Integer.valueOf(this.ETJ), Integer.valueOf(this.ETK), Integer.valueOf(this.ETL), Integer.valueOf(this.ETM), Integer.valueOf(this.targetWidth), Integer.valueOf(this.targetHeight));
        AppMethodBeat.o(176405);
    }

    public void fkj() {
        AppMethodBeat.i(176406);
        if (this.yTl != null && !this.yTl.isStarted()) {
            this.yTl.setStartDelay(0);
            this.yTl.start();
        }
        AppMethodBeat.o(176406);
    }

    public final void a(b bVar) {
        this.ETI = bVar;
    }
}
