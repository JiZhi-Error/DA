package com.tencent.mm.plugin.appbrand.widget.music;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class MusicSeekBar extends FrameLayout {
    private Context context;
    boolean isLoading;
    private TextView oyN;
    private TextView oyO;
    private SeekBar oyP;
    ValueAnimator oyQ;
    boolean oyR;
    a oyS;
    Drawable oyT;
    private a oyU;

    public interface a {
        void As(int i2);
    }

    public MusicSeekBar(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public MusicSeekBar(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(133762);
        this.oyR = false;
        this.isLoading = false;
        this.context = context2;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.bem, this);
        this.oyN = (TextView) inflate.findViewById(R.id.bji);
        this.oyO = (TextView) inflate.findViewById(R.id.c3t);
        this.oyP = (SeekBar) inflate.findViewById(R.id.hgn);
        this.oyN.setText("00:00");
        this.oyO.setText("--:--");
        this.oyS = new a(getResources().getDrawable(R.drawable.ci2));
        this.oyT = getResources().getDrawable(R.drawable.amd);
        this.oyP.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar.AnonymousClass1 */

            public final void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            }

            public final void onStartTrackingTouch(SeekBar seekBar) {
                MusicSeekBar.this.oyR = true;
            }

            public final void onStopTrackingTouch(SeekBar seekBar) {
                AppMethodBeat.i(133760);
                MusicSeekBar.this.oyR = false;
                if (MusicSeekBar.this.oyU != null) {
                    MusicSeekBar.this.oyU.As(seekBar.getProgress());
                }
                AppMethodBeat.o(133760);
            }
        });
        AppMethodBeat.o(133762);
    }

    public void setOnSeekBarChange(a aVar) {
        this.oyU = aVar;
    }

    public final void jl(boolean z) {
        AppMethodBeat.i(133763);
        if (this.oyQ == null) {
            this.oyQ = ValueAnimator.ofFloat(0.0f, 360.0f);
            this.oyQ.setTarget(this.oyP);
            this.oyQ.setRepeatCount(100);
            this.oyQ.setDuration(5000L);
            this.oyQ.setInterpolator(new LinearInterpolator());
            this.oyQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar.AnonymousClass2 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(133761);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    a aVar = MusicSeekBar.this.oyS;
                    aVar.oyX = floatValue;
                    aVar.invalidateSelf();
                    MusicSeekBar.this.oyP.setThumb(MusicSeekBar.this.oyS);
                    AppMethodBeat.o(133761);
                }
            });
        }
        this.isLoading = z;
        if (z) {
            this.oyQ.start();
            AppMethodBeat.o(133763);
            return;
        }
        this.oyQ.cancel();
        this.oyP.setThumb(this.oyT);
        AppMethodBeat.o(133763);
    }

    public void setColor(int i2) {
        AppMethodBeat.i(133764);
        this.oyN.setTextColor(i2);
        this.oyO.setTextColor(i2);
        this.oyP.getProgressDrawable().setColorFilter(i2, PorterDuff.Mode.MULTIPLY);
        this.oyP.getThumb().setColorFilter(i2, PorterDuff.Mode.MULTIPLY);
        this.oyT.setColorFilter(i2, PorterDuff.Mode.MULTIPLY);
        this.oyS.setColorFilter(i2, PorterDuff.Mode.MULTIPLY);
        AppMethodBeat.o(133764);
    }

    public void setProgress(int i2) {
        AppMethodBeat.i(133765);
        if (this.isLoading || this.oyR) {
            AppMethodBeat.o(133765);
            return;
        }
        this.oyN.setText(Ar(i2));
        this.oyP.setProgress(i2);
        AppMethodBeat.o(133765);
    }

    public void setMaxProgress(int i2) {
        AppMethodBeat.i(133766);
        this.oyO.setText(Ar(i2));
        this.oyP.setMax(i2);
        AppMethodBeat.o(133766);
    }

    private static String Ar(int i2) {
        AppMethodBeat.i(133767);
        StringBuilder sb = new StringBuilder();
        long j2 = (long) (i2 / 60000);
        long floor = (long) Math.floor((double) (((long) (i2 % 60000)) / 1000));
        if (j2 < 10) {
            sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        sb.append(j2 + ":");
        if (floor < 10) {
            sb.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        sb.append(floor);
        String sb2 = sb.toString();
        AppMethodBeat.o(133767);
        return sb2;
    }
}
