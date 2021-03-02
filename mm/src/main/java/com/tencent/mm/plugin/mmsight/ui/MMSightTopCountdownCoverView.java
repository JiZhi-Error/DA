package com.tencent.mm.plugin.mmsight.ui;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.ao;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MMSightTopCountdownCoverView extends FrameLayout {
    final MMHandler mHandler = new MMHandler(Looper.getMainLooper());
    final View zBU;
    private final ImageView zBV;
    final TextView zBW;
    final TextView zBX;
    long zBY;
    long zBZ;
    final Runnable zCa = new Runnable() {
        /* class com.tencent.mm.plugin.mmsight.ui.MMSightTopCountdownCoverView.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(94567);
            MMSightTopCountdownCoverView.a(MMSightTopCountdownCoverView.this);
            AppMethodBeat.o(94567);
        }
    };
    final Runnable zCb = new Runnable() {
        /* class com.tencent.mm.plugin.mmsight.ui.MMSightTopCountdownCoverView.AnonymousClass2 */

        public final void run() {
            AppMethodBeat.i(94568);
            long j2 = (MMSightTopCountdownCoverView.this.zBZ - 400) - MMSightTopCountdownCoverView.this.zBY;
            MMSightTopCountdownCoverView.this.zBW.setText(String.format(Locale.US, "%02d:%02d", Long.valueOf(j2 / TimeUnit.MINUTES.toMillis(1)), Long.valueOf(Math.max(Math.round(((double) (j2 % TimeUnit.MINUTES.toMillis(1))) / ((double) TimeUnit.SECONDS.toMillis(1))), 0L))));
            MMSightTopCountdownCoverView.this.mHandler.postDelayed(this, 1000);
            MMSightTopCountdownCoverView.this.zBY += 1000;
            AppMethodBeat.o(94568);
        }
    };
    final ObjectAnimator zCc;

    public MMSightTopCountdownCoverView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(94569);
        LayoutInflater.from(getContext()).inflate(R.layout.bar, (ViewGroup) this, true);
        this.zBU = findViewById(R.id.aq4);
        this.zBV = (ImageView) findViewById(R.id.bgi);
        this.zBW = (TextView) findViewById(R.id.bgj);
        this.zBX = (TextView) findViewById(R.id.bgf);
        this.zCc = ObjectAnimator.ofFloat(this.zBV, "alpha", 1.0f, 0.0f, 1.0f);
        this.zCc.setDuration(2000L);
        this.zCc.setInterpolator(new AccelerateInterpolator());
        this.zCc.setRepeatCount(-1);
        this.zCc.setRepeatMode(1);
        setBackgroundColor(Color.argb(Math.round(127.5f), 0, 0, 0));
        ekK();
        setVisibility(8);
        AppMethodBeat.o(94569);
    }

    public MMSightTopCountdownCoverView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(94570);
        LayoutInflater.from(getContext()).inflate(R.layout.bar, (ViewGroup) this, true);
        this.zBU = findViewById(R.id.aq4);
        this.zBV = (ImageView) findViewById(R.id.bgi);
        this.zBW = (TextView) findViewById(R.id.bgj);
        this.zBX = (TextView) findViewById(R.id.bgf);
        this.zCc = ObjectAnimator.ofFloat(this.zBV, "alpha", 1.0f, 0.0f, 1.0f);
        this.zCc.setDuration(2000L);
        this.zCc.setInterpolator(new AccelerateInterpolator());
        this.zCc.setRepeatCount(-1);
        this.zCc.setRepeatMode(1);
        setBackgroundColor(Color.argb(Math.round(127.5f), 0, 0, 0));
        ekK();
        setVisibility(8);
        AppMethodBeat.o(94570);
    }

    private void ekK() {
        int paddingTop;
        AppMethodBeat.i(94571);
        Context context = getContext();
        if (!(context instanceof Activity)) {
            AppMethodBeat.o(94571);
            return;
        }
        Rect bl = ao.bl((Activity) context);
        int paddingLeft = getPaddingLeft();
        if (bl != null) {
            paddingTop = bl.top + getPaddingTop();
        } else {
            paddingTop = getPaddingTop();
        }
        setPadding(paddingLeft, paddingTop, getPaddingRight(), getPaddingBottom());
        AppMethodBeat.o(94571);
    }

    public final void ekL() {
        AppMethodBeat.i(94572);
        if (this.zBZ > 0) {
            ekN();
            this.zBV.setAlpha(1.0f);
            this.zBW.setText(String.format(Locale.US, "%02d:%02d", 0, 0));
            this.zBZ = 0;
            this.zBY = 0;
        }
        AppMethodBeat.o(94572);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(94573);
        super.onDetachedFromWindow();
        ekN();
        AppMethodBeat.o(94573);
    }

    /* access modifiers changed from: package-private */
    public final void ekM() {
        AppMethodBeat.i(94574);
        this.mHandler.removeCallbacks(this.zCb);
        this.mHandler.removeCallbacks(this.zCa);
        AppMethodBeat.o(94574);
    }

    private void ekN() {
        AppMethodBeat.i(94575);
        ekM();
        this.zCc.cancel();
        AppMethodBeat.o(94575);
    }

    static /* synthetic */ void a(MMSightTopCountdownCoverView mMSightTopCountdownCoverView) {
        AppMethodBeat.i(94576);
        mMSightTopCountdownCoverView.zBU.setVisibility(0);
        mMSightTopCountdownCoverView.zBX.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mMSightTopCountdownCoverView.zBW.getLayoutParams();
        layoutParams.removeRule(13);
        layoutParams.addRule(14);
        layoutParams.addRule(2, mMSightTopCountdownCoverView.zBU.getId());
        mMSightTopCountdownCoverView.requestLayout();
        mMSightTopCountdownCoverView.invalidate();
        AppMethodBeat.o(94576);
    }
}
