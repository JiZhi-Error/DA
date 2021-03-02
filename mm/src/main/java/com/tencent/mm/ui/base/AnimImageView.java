package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.at;

public class AnimImageView extends TextView {
    private boolean ONW = false;
    private AnimationDrawable ONX;
    private Context context;
    private boolean isRunning = false;
    private AlphaAnimation qUh;
    private AnimationDrawable qUi;
    private int type = 1;

    public void setType(int i2) {
        AppMethodBeat.i(33854);
        this.type = i2;
        if (this.ONW) {
            if (i2 == 2) {
                setBackgroundResource(R.color.h8);
                AppMethodBeat.o(33854);
                return;
            }
            setBackgroundDrawable(a.l(this.context, R.drawable.mv));
            AppMethodBeat.o(33854);
        } else if (i2 == 2) {
            setBackgroundResource(R.color.h9);
            AppMethodBeat.o(33854);
        } else {
            setBackgroundDrawable(a.l(this.context, R.drawable.oq));
            AppMethodBeat.o(33854);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bWT() {
        /*
        // Method dump skipped, instructions count: 132
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.base.AnimImageView.bWT():void");
    }

    public void setFromVoice(boolean z) {
        this.ONW = z;
    }

    public void setFromGroup(boolean z) {
    }

    public final void cEA() {
        AppMethodBeat.i(33856);
        if (this.qUh != null && this.qUh.isInitialized()) {
            setAnimation(null);
        }
        if (this.type == 1 || this.type == 2) {
            this.isRunning = false;
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.qUi.stop();
            this.ONX.stop();
        }
        AppMethodBeat.o(33856);
    }

    public AnimImageView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(33857);
        this.context = context2;
        blc();
        AppMethodBeat.o(33857);
    }

    public AnimImageView(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(33858);
        this.context = context2;
        blc();
        AppMethodBeat.o(33858);
    }

    private void blc() {
        AppMethodBeat.i(33859);
        this.qUh = new AlphaAnimation(0.1f, 1.0f);
        this.qUh.setDuration(1000);
        this.qUh.setRepeatCount(-1);
        this.qUh.setRepeatMode(2);
        this.qUi = new com.tencent.mm.ui.f.a();
        Drawable aN = at.aN(getContext(), R.attr.e3);
        aN.setBounds(0, 0, aN.getIntrinsicWidth(), aN.getIntrinsicHeight());
        this.qUi.addFrame(aN, 300);
        Drawable aN2 = at.aN(getContext(), R.attr.e4);
        aN2.setBounds(0, 0, aN2.getIntrinsicWidth(), aN2.getIntrinsicHeight());
        this.qUi.addFrame(aN2, 300);
        Drawable aN3 = at.aN(getContext(), R.attr.e5);
        aN3.setBounds(0, 0, aN3.getIntrinsicWidth(), aN3.getIntrinsicHeight());
        this.qUi.addFrame(aN3, 300);
        this.qUi.setOneShot(false);
        this.qUi.setVisible(true, true);
        this.ONX = new com.tencent.mm.ui.f.a();
        Drawable drawable = getResources().getDrawable(R.raw.chatto_voice_playing_f1);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.ONX.addFrame(drawable, 300);
        Drawable drawable2 = getResources().getDrawable(R.raw.chatto_voice_playing_f2);
        drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
        this.ONX.addFrame(drawable2, 300);
        Drawable drawable3 = getResources().getDrawable(R.raw.chatto_voice_playing_f3);
        drawable3.setBounds(0, 0, drawable3.getIntrinsicWidth(), drawable3.getIntrinsicHeight());
        this.ONX.addFrame(drawable3, 300);
        this.ONX.setOneShot(false);
        this.ONX.setVisible(true, true);
        AppMethodBeat.o(33859);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(33860);
        try {
            super.onMeasure(i2, i3);
            AppMethodBeat.o(33860);
        } catch (Throwable th) {
            AppMethodBeat.o(33860);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(33861);
        try {
            super.onDraw(canvas);
            AppMethodBeat.o(33861);
        } catch (Throwable th) {
            AppMethodBeat.o(33861);
        }
    }

    public int getBaseline() {
        AppMethodBeat.i(33862);
        try {
            int baseline = super.getBaseline();
            AppMethodBeat.o(33862);
            return baseline;
        } catch (Throwable th) {
            AppMethodBeat.o(33862);
            return -1;
        }
    }

    public boolean onPreDraw() {
        AppMethodBeat.i(33863);
        try {
            boolean onPreDraw = super.onPreDraw();
            AppMethodBeat.o(33863);
            return onPreDraw;
        } catch (Throwable th) {
            AppMethodBeat.o(33863);
            return true;
        }
    }
}
