package com.tencent.mm.plugin.wallet_core.ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.l.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;

public class WalletAwardShakeAnimView extends RelativeLayout {
    private View Ind;
    private TextView Ine;
    private String Inf;
    private int Ing = 0;
    private String Inh;
    private int Ini = 0;
    private ValueAnimator Inj;
    private a Ink;
    private Runnable delayNofiyRunnable = new Runnable() {
        /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(71495);
            WalletAwardShakeAnimView.a(WalletAwardShakeAnimView.this);
            AppMethodBeat.o(71495);
        }
    };
    private boolean isInvokeCallback = false;
    private boolean isStartShake = false;
    private long lastShakeTime;
    private d shakeSensor;

    public interface a {
        void yx(boolean z);
    }

    static /* synthetic */ void h(WalletAwardShakeAnimView walletAwardShakeAnimView) {
        AppMethodBeat.i(71509);
        walletAwardShakeAnimView.fTQ();
        AppMethodBeat.o(71509);
    }

    public WalletAwardShakeAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(71499);
        init();
        AppMethodBeat.o(71499);
    }

    public WalletAwardShakeAnimView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(71500);
        init();
        AppMethodBeat.o(71500);
    }

    private void init() {
        AppMethodBeat.i(71501);
        aa.jQ(getContext()).inflate(R.layout.c7i, this);
        findViewById(R.id.y1).setBackground(getResources().getDrawable(R.raw.wallet_new_shakea_anim_view_bg));
        this.Ind = findViewById(R.id.hng);
        this.Ine = (TextView) findViewById(R.id.hnf);
        AppMethodBeat.o(71501);
    }

    public void setShakeOrClickCallback(a aVar) {
        this.Ink = aVar;
    }

    public void setShakeHintWording(String str) {
        AppMethodBeat.i(71502);
        this.Inf = str;
        this.Ine.setText(str);
        AppMethodBeat.o(71502);
    }

    public void setShakeHintWordingColor(int i2) {
        AppMethodBeat.i(71503);
        this.Ing = i2;
        this.Ine.setTextColor(i2);
        AppMethodBeat.o(71503);
    }

    public void setAfterHintWording(String str) {
        this.Inh = str;
    }

    public void setAfterHintWordingColor(int i2) {
        this.Ini = i2;
    }

    public final void fTP() {
        AppMethodBeat.i(71504);
        Log.i("MicroMsg.WalletAwardShakeAnimView", "startShake");
        getContext();
        this.shakeSensor = new d();
        this.shakeSensor.a(new d.a() {
            /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView.AnonymousClass2 */

            @Override // com.tencent.mm.pluginsdk.l.d.a
            public final void onShake(boolean z) {
                AppMethodBeat.i(71496);
                Log.i("MicroMsg.WalletAwardShakeAnimView", "onShake");
                long ticksToNow = Util.ticksToNow(WalletAwardShakeAnimView.this.lastShakeTime);
                if (!WalletAwardShakeAnimView.this.isStartShake) {
                    if (ticksToNow < 1200) {
                        AppMethodBeat.o(71496);
                        return;
                    }
                } else if (ticksToNow < 80) {
                    AppMethodBeat.o(71496);
                    return;
                }
                WalletAwardShakeAnimView.this.lastShakeTime = Util.currentTicks();
                WalletAwardShakeAnimView.this.isStartShake = true;
                if (!WalletAwardShakeAnimView.this.isInvokeCallback) {
                    WalletAwardShakeAnimView.this.isInvokeCallback = true;
                    WalletAwardShakeAnimView.g(WalletAwardShakeAnimView.this);
                }
                AppMethodBeat.o(71496);
            }

            @Override // com.tencent.mm.pluginsdk.l.d.a
            public final void onRelease() {
            }
        });
        this.lastShakeTime = Util.currentTicks();
        setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(71497);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/view/WalletAwardShakeAnimView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!WalletAwardShakeAnimView.this.isInvokeCallback) {
                    WalletAwardShakeAnimView.this.isInvokeCallback = true;
                    PlaySound.play(WalletAwardShakeAnimView.this.getContext(), R.string.gzt);
                    WalletAwardShakeAnimView.h(WalletAwardShakeAnimView.this);
                    if (WalletAwardShakeAnimView.this.Ink != null) {
                        WalletAwardShakeAnimView.this.Ink.yx(false);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/WalletAwardShakeAnimView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(71497);
            }
        });
        MMHandlerThread.removeRunnable(this.delayNofiyRunnable);
        MMHandlerThread.postToMainThreadDelayed(this.delayNofiyRunnable, 3000);
        AppMethodBeat.o(71504);
    }

    private void fTQ() {
        AppMethodBeat.i(71505);
        if (this.Inj != null) {
            this.Inj.cancel();
        }
        this.Inj = ValueAnimator.ofFloat(-30.0f, 30.0f);
        this.Inj.setInterpolator(new LinearInterpolator());
        this.Inj.setRepeatMode(2);
        this.Inj.setRepeatCount(-1);
        this.Inj.setDuration(300L);
        this.Inj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView.AnonymousClass4 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(71498);
                WalletAwardShakeAnimView.this.Ind.setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
                AppMethodBeat.o(71498);
            }
        });
        this.Inj.start();
        AppMethodBeat.o(71505);
    }

    public final void destroy() {
        AppMethodBeat.i(71506);
        if (this.shakeSensor != null) {
            this.shakeSensor.cBo();
            this.shakeSensor = null;
        }
        this.isInvokeCallback = false;
        this.isStartShake = false;
        if (this.Inj != null) {
            this.Inj.cancel();
        }
        this.Ind.setRotation(0.0f);
        if (!Util.isNullOrNil(this.Inf)) {
            this.Ine.setText(this.Inf);
        } else {
            this.Ine.setText(getResources().getText(R.string.isw));
        }
        if (this.Ing != 0) {
            this.Ine.setTextColor(this.Ing);
        } else {
            this.Ine.setTextColor(getResources().getColor(R.color.a5e));
        }
        MMHandlerThread.removeRunnable(this.delayNofiyRunnable);
        AppMethodBeat.o(71506);
    }

    static /* synthetic */ void a(WalletAwardShakeAnimView walletAwardShakeAnimView) {
        AppMethodBeat.i(71507);
        Log.i("MicroMsg.WalletAwardShakeAnimView", "delayNotifyClick, isInvokeCallback: %s", Boolean.valueOf(walletAwardShakeAnimView.isInvokeCallback));
        if (!walletAwardShakeAnimView.isInvokeCallback) {
            if (!Util.isNullOrNil(walletAwardShakeAnimView.Inh)) {
                walletAwardShakeAnimView.Ine.setText(walletAwardShakeAnimView.Inh);
            } else {
                walletAwardShakeAnimView.Ine.setText(walletAwardShakeAnimView.getContext().getString(R.string.isv));
            }
            if (walletAwardShakeAnimView.Ini != 0) {
                walletAwardShakeAnimView.Ine.setTextColor(walletAwardShakeAnimView.Ini);
            }
        }
        AppMethodBeat.o(71507);
    }

    static /* synthetic */ void g(WalletAwardShakeAnimView walletAwardShakeAnimView) {
        AppMethodBeat.i(71508);
        Log.i("MicroMsg.WalletAwardShakeAnimView", "onStartShakeOrClick");
        PlaySound.play(walletAwardShakeAnimView.getContext(), R.string.gzt);
        walletAwardShakeAnimView.fTQ();
        if (walletAwardShakeAnimView.Ink != null) {
            walletAwardShakeAnimView.Ink.yx(true);
        }
        AppMethodBeat.o(71508);
    }
}
