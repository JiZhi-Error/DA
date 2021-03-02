package com.tencent.mm.plugin.wallet_core.ui.view;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.robinhood.ticker.TickerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.smtt.sdk.WebView;

public class WcPayMoneyLoadingView extends FrameLayout implements LifecycleObserver {
    private TickerView Ioo;
    private String Iop = "";
    private String Ioq;
    private boolean Ior = false;
    public Runnable Ios = new Runnable() {
        /* class com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(71596);
            Log.i("MicroMsg.WcPayMoneyLoadingView", "show loading pb");
            WcPayMoneyLoadingView.this.kdb.setVisibility(0);
            WcPayMoneyLoadingView.this.Ior = true;
            AppMethodBeat.o(71596);
        }
    };
    public ProgressBar kdb;

    public WcPayMoneyLoadingView(Context context) {
        super(context);
        AppMethodBeat.i(71597);
        init();
        AppMethodBeat.o(71597);
    }

    public WcPayMoneyLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(71598);
        init();
        c(attributeSet, -1);
        AppMethodBeat.o(71598);
    }

    public WcPayMoneyLoadingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(71599);
        init();
        c(attributeSet, i2);
        AppMethodBeat.o(71599);
    }

    private void c(AttributeSet attributeSet, int i2) {
        AppMethodBeat.i(71600);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C2011a.WcPayMoneyLoadingViewAttrs, i2, 0);
        float dimension = obtainStyledAttributes.getDimension(0, 15.0f);
        int color = obtainStyledAttributes.getColor(1, WebView.NIGHT_MODE_COLOR);
        int integer = obtainStyledAttributes.getInteger(3, 4);
        obtainStyledAttributes.getInteger(2, 0);
        obtainStyledAttributes.recycle();
        setTextSize(dimension);
        setTextColor(color);
        setTypeface(f.aS(getContext(), integer));
        AppMethodBeat.o(71600);
    }

    private void init() {
        AppMethodBeat.i(71601);
        inflate(getContext(), R.layout.bbg, this);
        this.Ioo = (TickerView) findViewById(R.id.ff3);
        this.Ioo.setCharacterLists("0123456789");
        AppMethodBeat.o(71601);
    }

    public void setLoadingPb(ProgressBar progressBar) {
        this.kdb = progressBar;
    }

    public void setProgressBarStyle(int i2) {
        AppMethodBeat.i(71602);
        if (i2 == 0) {
            this.kdb.setIndeterminateDrawable(getResources().getDrawable(R.drawable.apc));
            AppMethodBeat.o(71602);
            return;
        }
        this.kdb.setIndeterminateDrawable(getResources().getDrawable(R.drawable.ap_));
        AppMethodBeat.o(71602);
    }

    public void setTypeface(Typeface typeface) {
        AppMethodBeat.i(71603);
        this.Ioo.setTypeface(typeface);
        AppMethodBeat.o(71603);
    }

    public void setTextSize(float f2) {
        AppMethodBeat.i(71604);
        this.Ioo.setTextSize(f2);
        AppMethodBeat.o(71604);
    }

    public void setTextColor(int i2) {
        AppMethodBeat.i(71605);
        this.Ioo.setTextColor(i2);
        AppMethodBeat.o(71605);
    }

    public void setPrefixSymbol(String str) {
        this.Iop = str;
    }

    public void setMoney(String str) {
        AppMethodBeat.i(71606);
        cH(str, false);
        AppMethodBeat.o(71606);
    }

    public final void cH(String str, boolean z) {
        AppMethodBeat.i(71607);
        if (str == null) {
            AppMethodBeat.o(71607);
            return;
        }
        if (Util.isNullOrNil(this.Ioq)) {
            setFirstMoney(str);
            if (z) {
                removeCallbacks(this.Ios);
                AppMethodBeat.o(71607);
                return;
            }
        } else {
            setNewMoney(str);
        }
        AppMethodBeat.o(71607);
    }

    public void setFirstMoney(String str) {
        AppMethodBeat.i(71608);
        Log.d("MicroMsg.WcPayMoneyLoadingView", "set last money: %s", str);
        this.Ioq = str;
        if (!Util.isNullOrNil(str)) {
            this.Ioo.setText(this.Iop + str, false);
        }
        postDelayed(this.Ios, 500);
        AppMethodBeat.o(71608);
    }

    public void setNewMoney(String str) {
        boolean z = false;
        AppMethodBeat.i(71609);
        Log.d("MicroMsg.WcPayMoneyLoadingView", "set new money: %s", str);
        removeCallbacks(this.Ios);
        this.kdb.setVisibility(8);
        if (this.Ioq.length() != str.length()) {
            this.Ioo.setAnimationDuration(800);
        } else {
            this.Ioo.setAnimationDuration(500);
        }
        if (Util.getDouble(str, 0.0d) > Util.getDouble(this.Ioq, 0.0d)) {
            this.Ioo.setPreferredScrollingDirection(TickerView.a.DOWN);
        } else {
            this.Ioo.setPreferredScrollingDirection(TickerView.a.UP);
        }
        boolean z2 = this.Ior;
        if (!Util.isNullOrNil(this.Ioq)) {
            z = z2;
        }
        this.Ioo.setText(this.Iop + str, z);
        AppMethodBeat.o(71609);
    }

    public final void reset() {
        AppMethodBeat.i(71610);
        Log.d("MicroMsg.WcPayMoneyLoadingView", "reset money");
        this.Ioq = null;
        AppMethodBeat.o(71610);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onActivityDestroy() {
        AppMethodBeat.i(71611);
        removeCallbacks(this.Ios);
        AppMethodBeat.o(71611);
    }
}
