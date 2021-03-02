package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.u;

public class MovableVideoView extends OpenGlView {
    public int HhR;
    private int HhS;
    private int HhT;
    private float dsy;
    private float dsz;
    private long lTb;
    private View.OnClickListener mOnClickListener;
    private int mScreenHeight;
    public int mScreenWidth;
    public int mWidth;

    public MovableVideoView(Context context) {
        this(context, null);
    }

    public MovableVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mWidth = 320;
        this.HhR = 240;
        this.HhS = 800;
        this.HhT = 480;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2 = 0;
        AppMethodBeat.i(115637);
        Log.d("MicroMsg.MovableVideoView", "event: " + motionEvent.getAction());
        switch (motionEvent.getAction()) {
            case 0:
                this.dsy = motionEvent.getRawX();
                this.dsz = motionEvent.getRawY();
                this.lTb = System.currentTimeMillis();
                break;
            case 1:
                long currentTimeMillis = System.currentTimeMillis();
                if (this.lTb != 0 && currentTimeMillis - this.lTb < 300 && currentTimeMillis - this.lTb >= 0 && this.mOnClickListener != null) {
                    this.mOnClickListener.onClick(this);
                }
                h.INSTANCE.a(11079, 2);
                break;
            case 2:
                float rawX = motionEvent.getRawX() - this.dsy;
                float rawY = motionEvent.getRawY() - this.dsz;
                if (Math.abs(rawX) > 1.0f || Math.abs(rawY) > 1.0f) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
                    int i3 = (int) (((float) layoutParams.rightMargin) - rawX);
                    int i4 = (int) (rawY + ((float) layoutParams.topMargin));
                    if (i3 < 0) {
                        i3 = 0;
                    } else if (i3 > this.HhT) {
                        i3 = this.HhT;
                    }
                    layoutParams.rightMargin = i3;
                    if (i4 >= 0) {
                        i2 = i4 > this.HhS ? this.HhS : i4;
                    }
                    layoutParams.topMargin = i2;
                    setLayoutParams(layoutParams);
                    this.dsy = motionEvent.getRawX();
                    this.dsz = motionEvent.getRawY();
                    break;
                }
        }
        AppMethodBeat.o(115637);
        return true;
    }

    public final void jF(int i2, int i3) {
        AppMethodBeat.i(115638);
        this.mWidth = i2;
        this.HhR = i3;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (this.mScreenWidth == 0) {
            this.mScreenWidth = windowManager.getDefaultDisplay().getWidth();
            this.mScreenHeight = windowManager.getDefaultDisplay().getHeight();
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i3);
        layoutParams.addRule(21, -1);
        layoutParams.topMargin = a.fromDPToPix(getContext(), 12) + u.ay(getContext());
        layoutParams.rightMargin = layoutParams.topMargin - u.ay(getContext());
        setLayoutParams(layoutParams);
        this.HhS = this.mScreenHeight - this.HhR;
        this.HhT = this.mScreenWidth - this.mWidth;
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        AppMethodBeat.o(115638);
    }

    @Override // com.tencent.mm.plugin.voip.video.OpenGlView
    public final void jG(int i2, int i3) {
        AppMethodBeat.i(260043);
        jF(i2, i3);
        AppMethodBeat.o(260043);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.tencent.mm.plugin.voip.video.OpenGlView
    public final void jH(int i2, int i3) {
        AppMethodBeat.i(115640);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, i3);
        layoutParams2.rightMargin = layoutParams.rightMargin;
        layoutParams2.topMargin = layoutParams.topMargin;
        layoutParams2.addRule(21, -1);
        this.mWidth = i2;
        this.HhR = i3;
        setLayoutParams(layoutParams2);
        AppMethodBeat.o(115640);
    }
}
