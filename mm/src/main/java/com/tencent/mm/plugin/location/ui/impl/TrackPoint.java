package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.location_soso.ViewManager;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;

public class TrackPoint extends LinearLayout {
    private Context mContext;
    public ViewManager mViewManager;
    private double mbh = -1.0d;
    private double mbi = -1.0d;
    private double mbj = -1.0d;
    private double mbk = -1.0d;
    private String username;
    private boolean visible = true;
    public FrameLayout yOd;
    public ImageView yOe;
    private double yOf = 0.0d;

    public TrackPoint(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(56180);
        this.mContext = context;
        init(0);
        AppMethodBeat.o(56180);
    }

    public TrackPoint(Context context, ViewManager viewManager) {
        super(context);
        AppMethodBeat.i(56181);
        this.mContext = context;
        this.mViewManager = viewManager;
        init(0);
        AppMethodBeat.o(56181);
    }

    public TrackPoint(Context context, ViewManager viewManager, byte b2) {
        super(context);
        AppMethodBeat.i(56182);
        this.mContext = context;
        this.mViewManager = viewManager;
        init(R.drawable.ct0);
        AppMethodBeat.o(56182);
    }

    private void init(int i2) {
        AppMethodBeat.i(56183);
        this.yOd = (FrameLayout) View.inflate(this.mContext, R.layout.c4i, null);
        this.yOe = new ImageView(this.mContext);
        if (i2 > 0) {
            this.yOe.setImageResource(i2);
        } else {
            this.yOe.setImageResource(R.drawable.ct1);
        }
        this.yOe.setBackgroundResource(R.drawable.aij);
        this.yOe.setFocusable(true);
        this.yOe.setFocusableInTouchMode(true);
        AppMethodBeat.o(56183);
    }

    public void setOnLocationOnClickListener(View.OnClickListener onClickListener) {
    }

    public void setOnAvatarOnClickListener(View.OnClickListener onClickListener) {
    }

    public void setAvatar(String str) {
        AppMethodBeat.i(56184);
        if (str.equals(this.username)) {
            Log.i("MicroMsg.TrackPoint", "skip this set avatar");
            AppMethodBeat.o(56184);
            return;
        }
        this.username = str;
        a.b.d((ImageView) this.yOd.findViewById(R.id.mt), str);
        if (this.mViewManager != null) {
            this.mViewManager.updateMarkerView(this.yOd);
        }
        AppMethodBeat.o(56184);
    }

    public double getHeading() {
        return this.yOf;
    }

    public void setHeading(double d2) {
        this.yOf = d2;
    }

    public final void eee() {
        AppMethodBeat.i(56185);
        this.visible = false;
        this.yOd.setVisibility(4);
        if (this.mViewManager != null) {
            this.mViewManager.toggleViewVisible(this.yOd);
        }
        AppMethodBeat.o(56185);
    }

    public final void eef() {
        AppMethodBeat.i(56186);
        this.visible = true;
        this.yOd.setVisibility(0);
        if (this.mViewManager != null) {
            this.mViewManager.toggleViewVisible(this.yOd);
        }
        AppMethodBeat.o(56186);
    }

    public final void x(double d2) {
        AppMethodBeat.i(56187);
        this.yOf = d2;
        if (this.mViewManager != null) {
            this.mViewManager.updateRotation(this.yOe, (float) d2);
        }
        AppMethodBeat.o(56187);
    }

    public double getLatOffest() {
        return this.mbh - this.mbj;
    }

    public double getLongOffset() {
        return this.mbi - this.mbk;
    }

    public final void n(double d2, double d3) {
        AppMethodBeat.i(56188);
        if (this.mViewManager != null) {
            this.mViewManager.updateViewLayout(this.yOd, d2, d3, false);
            this.mViewManager.updateLocationPinLayout(this.yOe, d2, d3, false);
        }
        AppMethodBeat.o(56188);
    }

    public final void o(double d2, double d3) {
        AppMethodBeat.i(56189);
        if (this.mViewManager != null) {
            this.mViewManager.addView(this.yOd, d2, d3);
            this.mViewManager.addView(this.yOe, d2, d3);
        }
        AppMethodBeat.o(56189);
    }

    public final void set2Top() {
        AppMethodBeat.i(56190);
        if (this.mViewManager != null) {
            this.mViewManager.setMarker2Top(this.yOd);
            this.mViewManager.setMarker2Top(this.yOe);
        }
        AppMethodBeat.o(56190);
    }
}
