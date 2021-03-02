package com.tencent.mm.pluginsdk.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

@TargetApi(16)
public class VoiceInputLayoutImpl extends VoiceInputLayout {
    private l KdL;
    private View.OnLongClickListener aYy = new View.OnLongClickListener() {
        /* class com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl.AnonymousClass1 */

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(31288);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/pluginsdk/ui/VoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            Log.d("MicroMsg.VoiceInputLayoutImp", "btn onLongClickListener currentState %s", Integer.valueOf(VoiceInputLayoutImpl.this.currentState));
            VoiceInputLayoutImpl.this.xfD = true;
            VoiceInputLayoutImpl.this.KdL.goW();
            a.a(true, (Object) this, "com/tencent/mm/pluginsdk/ui/VoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(31288);
            return true;
        }
    };
    private View.OnTouchListener aZa = new View.OnTouchListener() {
        /* class com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl.AnonymousClass2 */

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(31289);
            switch (motionEvent.getAction()) {
                case 0:
                    VoiceInputLayoutImpl.this.xfD = false;
                    VoiceInputLayoutImpl.this.xfF = Util.currentTicks();
                    Log.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", Integer.valueOf(VoiceInputLayoutImpl.this.currentState), Long.valueOf(VoiceInputLayoutImpl.this.xfF));
                    VoiceInputLayoutImpl.this.KdL.goX();
                    VoiceInputLayoutImpl.this.T(false, false);
                    break;
                case 1:
                    Log.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_UP currentState %s longClickDown %s", Integer.valueOf(VoiceInputLayoutImpl.this.currentState), Boolean.valueOf(VoiceInputLayoutImpl.this.xfD));
                    if (!VoiceInputLayoutImpl.this.xfD) {
                        VoiceInputLayoutImpl.this.T(false, true);
                        break;
                    } else {
                        VoiceInputLayoutImpl.this.T(true, false);
                        VoiceInputLayoutImpl.this.xfD = false;
                        VoiceInputLayoutImpl.this.xfF = 0;
                        break;
                    }
            }
            AppMethodBeat.o(31289);
            return false;
        }
    };
    private View xfA;
    private boolean xfD = false;
    private long xfF;

    public VoiceInputLayoutImpl(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(31295);
        init(context);
        AppMethodBeat.o(31295);
    }

    public VoiceInputLayoutImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(31296);
        init(context);
        AppMethodBeat.o(31296);
    }

    private void init(Context context) {
        AppMethodBeat.i(31297);
        this.xfA = inflate(context, R.layout.c6i, this).findViewById(R.id.ja2);
        this.xfA.setLayerType(1, null);
        this.KdL = new l(context);
        this.xfA.setBackground(this.KdL);
        this.xfA.setEnabled(true);
        this.xfA.setOnTouchListener(this.aZa);
        this.xfA.setOnLongClickListener(this.aYy);
        reset(true);
        if (isInEditMode()) {
            AppMethodBeat.o(31297);
            return;
        }
        if (!dzA()) {
            dPX();
        }
        AppMethodBeat.o(31297);
    }

    public final void T(boolean z, boolean z2) {
        AppMethodBeat.i(31298);
        Log.d("MicroMsg.VoiceInputLayoutImp", "directStart currentState = %s longUp = %s clickUp = %s", Integer.valueOf(this.currentState), Boolean.valueOf(z), Boolean.valueOf(z2));
        if (this.currentState == 1) {
            if (z || z2) {
                if (z && !z2) {
                    bv(4, this.xfD);
                    bv(this.currentState, this.xfD);
                    this.KdL.dPL();
                    AppMethodBeat.o(31298);
                    return;
                }
            } else if (!dzA()) {
                dPX();
                AppMethodBeat.o(31298);
                return;
            } else {
                dQm();
                AppMethodBeat.o(31298);
                return;
            }
        } else if (this.currentState == 2) {
            if (!z2) {
                if (z) {
                    bv(4, this.xfD);
                }
                bv(this.currentState, this.xfD);
                dQn();
                AppMethodBeat.o(31298);
                return;
            }
            this.KdL.dPL();
            biE();
            if (this.KdJ != null) {
                this.KdJ.dPW();
            }
            bv(5, this.xfD);
            AppMethodBeat.o(31298);
            return;
        } else if (!z && !z2) {
            bv(this.currentState, this.xfD);
            biE();
            AppMethodBeat.o(31298);
            return;
        } else if (z && !z2) {
            bv(4, this.xfD);
            bv(this.currentState, this.xfD);
            this.KdL.dPL();
        }
        AppMethodBeat.o(31298);
    }

    private void dPX() {
        AppMethodBeat.i(31299);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(31290);
                VoiceInputLayoutImpl.this.KdL.goZ();
                AppMethodBeat.o(31290);
            }
        });
        dQp();
        AppMethodBeat.o(31299);
    }

    private static boolean dzA() {
        AppMethodBeat.i(31300);
        int aYS = bg.azz().aYS();
        if (aYS == 4 || aYS == 6) {
            AppMethodBeat.o(31300);
            return true;
        }
        AppMethodBeat.o(31300);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.pluginsdk.ui.VoiceInputLayout
    public final void dPZ() {
        AppMethodBeat.i(31301);
        runOnUiThread(new Runnable(true) {
            /* class com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl.AnonymousClass4 */
            final /* synthetic */ boolean xfH = true;

            public final void run() {
                AppMethodBeat.i(31291);
                VoiceInputLayoutImpl.this.KdL.zP(this.xfH);
                AppMethodBeat.o(31291);
            }
        });
        AppMethodBeat.o(31301);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.pluginsdk.ui.VoiceInputLayout
    public final void hs(boolean z) {
        AppMethodBeat.i(31302);
        if (!z) {
            bv(17, false);
        }
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(31292);
                VoiceInputLayoutImpl.this.KdL.goY();
                AppMethodBeat.o(31292);
            }
        });
        AppMethodBeat.o(31302);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.pluginsdk.ui.VoiceInputLayout
    public final void onReset() {
        AppMethodBeat.i(31303);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(31293);
                VoiceInputLayoutImpl.this.KdL.dPL();
                AppMethodBeat.o(31293);
            }
        });
        AppMethodBeat.o(31303);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.pluginsdk.ui.VoiceInputLayout
    public final void Ny(final int i2) {
        AppMethodBeat.i(31304);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.VoiceInputLayoutImpl.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(31294);
                VoiceInputLayoutImpl.this.KdL.aic(i2);
                AppMethodBeat.o(31294);
            }
        });
        AppMethodBeat.o(31304);
    }

    private static void runOnUiThread(Runnable runnable) {
        AppMethodBeat.i(31305);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            MMHandlerThread.postToMainThread(runnable);
            AppMethodBeat.o(31305);
            return;
        }
        runnable.run();
        AppMethodBeat.o(31305);
    }

    private void bv(int i2, boolean z) {
        AppMethodBeat.i(31306);
        log_13905 log_13905 = new log_13905();
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        if (!z) {
            voiceInputBehavior.click = i2;
        } else if (this.xhk) {
            voiceInputBehavior.fullScreenVoiceLongClick = i2;
            if (!(i2 == 4 || !this.xfD || this.xfF == 0)) {
                voiceInputBehavior.fullScreenVoiceLongClickTime = Util.ticksToNow(this.xfF);
            }
        } else {
            voiceInputBehavior.longClick = i2;
            if (!(i2 == 4 || !this.xfD || this.xfF == 0)) {
                voiceInputBehavior.longClickTime = Util.ticksToNow(this.xfF);
            }
        }
        log_13905.viOp_ = voiceInputBehavior;
        h.INSTANCE.c(13905, log_13905);
        Log.i("MicroMsg.VoiceInputLayoutImp", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime));
        AppMethodBeat.o(31306);
    }
}
