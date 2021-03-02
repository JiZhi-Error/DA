package com.tencent.mm.plugin.sns.ad.widget.countdown;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.ad.i.e;
import com.tencent.mm.plugin.sns.ad.i.m;
import com.tencent.mm.sdk.platformtools.Log;

public class CountDownTimerLayout extends LinearLayout implements LifecycleObserver, c {
    private TextView DAi;
    private TextView DAj;
    private TextView DAk;
    private TextView DAl;
    private TextView DAm;
    private boolean DAn = true;
    private long DAo = -1;
    private d DAp;
    private a DAq;

    public CountDownTimerLayout(Context context) {
        super(context);
        AppMethodBeat.i(202382);
        cMn();
        AppMethodBeat.o(202382);
    }

    public CountDownTimerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(202383);
        cMn();
        AppMethodBeat.o(202383);
    }

    public CountDownTimerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(202384);
        cMn();
        AppMethodBeat.o(202384);
    }

    public CountDownTimerLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        AppMethodBeat.i(202385);
        cMn();
        AppMethodBeat.o(202385);
    }

    private void cMn() {
        AppMethodBeat.i(202386);
        try {
            LayoutInflater.from(getContext()).inflate(R.layout.bv0, this);
            this.DAq = new a(this);
            this.DAi = (TextView) findViewById(R.id.hu5);
            this.DAj = (TextView) findViewById(R.id.hu4);
            this.DAk = (TextView) findViewById(R.id.hu6);
            this.DAl = (TextView) findViewById(R.id.hu7);
            this.DAm = (TextView) findViewById(R.id.hu8);
            AppMethodBeat.o(202386);
        } catch (Throwable th) {
            AppMethodBeat.o(202386);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(202387);
        super.onAttachedToWindow();
        try {
            Context context = getContext();
            if (context instanceof FragmentActivity) {
                ((FragmentActivity) context).getLifecycle().addObserver(this);
            }
            AppMethodBeat.o(202387);
        } catch (Throwable th) {
            AppMethodBeat.o(202387);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(202388);
        super.onDetachedFromWindow();
        try {
            Context context = getContext();
            if (context instanceof FragmentActivity) {
                ((FragmentActivity) context).getLifecycle().removeObserver(this);
            }
            d countDownVM = getCountDownVM();
            if (this.DAq != null) {
                a.a(countDownVM);
            }
            AppMethodBeat.o(202388);
        } catch (Throwable th) {
            AppMethodBeat.o(202388);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void doPause(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(202389);
        try {
            Log.d("SnsAd.CountDownTimerLayout", "the doPause is called");
            this.DAn = false;
            AppMethodBeat.o(202389);
        } catch (Throwable th) {
            AppMethodBeat.o(202389);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void doResume(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(202390);
        try {
            Log.d("SnsAd.CountDownTimerLayout", "the doResume is called");
            this.DAn = true;
            if (!this.DAn || !isAttachedToWindow()) {
                AppMethodBeat.o(202390);
                return;
            }
            if (this.DAo >= 0) {
                setDateTime(e.a(this.DAo, null));
            }
            AppMethodBeat.o(202390);
        } catch (Throwable th) {
            AppMethodBeat.o(202390);
        }
    }

    private void setDateTime(e.a aVar) {
        AppMethodBeat.i(202391);
        if (aVar == null) {
            Log.w("SnsAd.CountDownTimerLayout", "the date time is null!!");
            AppMethodBeat.o(202391);
            return;
        }
        if (aVar.grV > 0) {
            m.u(this.DAj, true);
            m.u(this.DAi, true);
            e(this.DAj, String.valueOf(aVar.grV));
        } else {
            m.u(this.DAj, false);
            m.u(this.DAi, false);
        }
        e(this.DAk, e.XS(aVar.hour));
        e(this.DAl, e.XS(aVar.minute));
        e(this.DAm, e.XS(aVar.second));
        AppMethodBeat.o(202391);
    }

    private static void e(TextView textView, String str) {
        AppMethodBeat.i(202392);
        if (textView != null) {
            textView.setText(str);
        }
        AppMethodBeat.o(202392);
    }

    @Override // com.tencent.mm.plugin.sns.ad.widget.countdown.c
    public d getCountDownVM() {
        return this.DAp;
    }

    @Override // com.tencent.mm.plugin.sns.ad.widget.countdown.c
    public final void b(long j2, e.a aVar) {
        AppMethodBeat.i(202393);
        try {
            this.DAo = j2;
            if (isAttachedToWindow() && this.DAn) {
                setDateTime(aVar);
            }
            AppMethodBeat.o(202393);
        } catch (Throwable th) {
            AppMethodBeat.o(202393);
        }
    }
}
