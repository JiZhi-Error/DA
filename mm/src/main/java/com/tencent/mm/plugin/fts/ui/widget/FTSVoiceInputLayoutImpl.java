package com.tencent.mm.plugin.fts.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

@TargetApi(16)
public class FTSVoiceInputLayoutImpl extends VoiceInputLayout {
    private View.OnLongClickListener aYy = new View.OnLongClickListener() {
        /* class com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl.AnonymousClass2 */

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(112307);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputLayoutImpl$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            Log.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onLongClickListener currentState %s", Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState));
            FTSVoiceInputLayoutImpl.this.xfD = true;
            a aVar = FTSVoiceInputLayoutImpl.this.xfC;
            Log.d("MicroMsg.FTSVoiceInputDrawable", "longClickState %s", Integer.valueOf(aVar.currentState));
            aVar.currentState = 7;
            aVar.invalidateSelf();
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/fts/ui/widget/FTSVoiceInputLayoutImpl$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(112307);
            return true;
        }
    };
    private View.OnTouchListener aZa = new View.OnTouchListener() {
        /* class com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl.AnonymousClass3 */

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(112308);
            switch (motionEvent.getAction()) {
                case 0:
                    if (NetStatusUtil.isConnected(FTSVoiceInputLayoutImpl.this.getContext())) {
                        FTSVoiceInputLayoutImpl.this.xfE = false;
                        FTSVoiceInputLayoutImpl.this.xfD = false;
                        FTSVoiceInputLayoutImpl.this.xfF = Util.currentTicks();
                        ((a) FTSVoiceInputLayoutImpl.this.xhi).dPP();
                        Log.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState), Long.valueOf(FTSVoiceInputLayoutImpl.this.xfF));
                        a aVar = FTSVoiceInputLayoutImpl.this.xfC;
                        Log.d("MicroMsg.FTSVoiceInputDrawable", "readyPressState %s", Integer.valueOf(aVar.currentState));
                        aVar.currentState = 6;
                        aVar.invalidateSelf();
                        FTSVoiceInputLayoutImpl.this.T(false, false);
                        FTSVoiceInputLayoutImpl.d(FTSVoiceInputLayoutImpl.this);
                        break;
                    } else {
                        FTSVoiceInputLayoutImpl.this.xfE = true;
                        FTSVoiceInputLayoutImpl.this.xhi.Nx(12);
                        break;
                    }
                case 1:
                    if (!FTSVoiceInputLayoutImpl.this.xfE) {
                        Log.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onTouch ACTION_UP currentState %s longClickDown %s", Integer.valueOf(FTSVoiceInputLayoutImpl.this.currentState), Boolean.valueOf(FTSVoiceInputLayoutImpl.this.xfD));
                        if (FTSVoiceInputLayoutImpl.this.xfD) {
                            FTSVoiceInputLayoutImpl.this.T(true, false);
                            FTSVoiceInputLayoutImpl.this.xfD = false;
                            FTSVoiceInputLayoutImpl.this.xfF = 0;
                        } else {
                            FTSVoiceInputLayoutImpl.this.T(false, true);
                        }
                        FTSVoiceInputLayoutImpl.g(FTSVoiceInputLayoutImpl.this);
                        ((a) FTSVoiceInputLayoutImpl.this.xhi).dPO();
                        break;
                    } else {
                        FTSVoiceInputLayoutImpl.this.xfE = false;
                        break;
                    }
            }
            AppMethodBeat.o(112308);
            return false;
        }
    };
    private View xfA;
    private TextView xfB;
    private a xfC;
    private boolean xfD = false;
    private boolean xfE = false;
    private long xfF;

    public interface a extends VoiceInputLayout.b {
        void dPO();

        void dPP();
    }

    public FTSVoiceInputLayoutImpl(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(112314);
        init(context);
        AppMethodBeat.o(112314);
    }

    public FTSVoiceInputLayoutImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(112315);
        init(context);
        AppMethodBeat.o(112315);
    }

    private void init(Context context) {
        AppMethodBeat.i(112316);
        View inflate = inflate(context, R.layout.any, this);
        this.xfA = inflate.findViewById(R.id.ja2);
        this.xfA.setLayerType(1, null);
        this.xfC = new a(context);
        this.xfA.setBackground(this.xfC);
        this.xfA.setEnabled(true);
        this.xfA.setOnTouchListener(this.aZa);
        this.xfA.setOnLongClickListener(this.aYy);
        this.xfB = (TextView) inflate.findViewById(R.id.dbe);
        reset(true);
        if (isInEditMode()) {
            AppMethodBeat.o(112316);
            return;
        }
        if (!dzA()) {
            dPX();
        }
        AppMethodBeat.o(112316);
    }

    public void setFTSVoiceDetectListener(a aVar) {
        AppMethodBeat.i(112317);
        super.setVoiceDetectListener(aVar);
        AppMethodBeat.o(112317);
    }

    public final void T(boolean z, boolean z2) {
        AppMethodBeat.i(112318);
        Log.d("MicroMsg.FTSVoiceInputLayoutImpl", "directStart currentState = %s longUp = %s clickUp = %s", Integer.valueOf(this.currentState), Boolean.valueOf(z), Boolean.valueOf(z2));
        if (this.currentState == 1) {
            if (!z && !z2) {
                dQm();
                AppMethodBeat.o(112318);
                return;
            } else if (z && !z2) {
                this.xfC.dPL();
                AppMethodBeat.o(112318);
                return;
            }
        } else if (this.currentState == 2) {
            if (!z2) {
                dQn();
                AppMethodBeat.o(112318);
                return;
            }
            this.xfC.dPL();
            biE();
            if (this.xfw != null) {
                this.xfw.dPW();
                AppMethodBeat.o(112318);
                return;
            }
        } else if (!z && !z2) {
            biE();
            AppMethodBeat.o(112318);
            return;
        } else if (z && !z2) {
            this.xfC.dPL();
        }
        AppMethodBeat.o(112318);
    }

    private void dPX() {
        AppMethodBeat.i(112319);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(112309);
                a aVar = FTSVoiceInputLayoutImpl.this.xfC;
                Log.d("MicroMsg.FTSVoiceInputDrawable", "disableState %s", Integer.valueOf(aVar.currentState));
                aVar.currentState = 5;
                aVar.invalidateSelf();
                AppMethodBeat.o(112309);
            }
        });
        dQp();
        AppMethodBeat.o(112319);
    }

    private static boolean dPY() {
        AppMethodBeat.i(112320);
        int aYS = g.azz().aYS();
        if (aYS == 4 || aYS == 6) {
            AppMethodBeat.o(112320);
            return true;
        }
        AppMethodBeat.o(112320);
        return false;
    }

    private static boolean dzA() {
        boolean z;
        AppMethodBeat.i(112321);
        if (g.aAe().azG().aBb()) {
            boolean dPY = dPY();
            AppMethodBeat.o(112321);
            return dPY;
        }
        if (NetStatusUtil.isConnected(MMApplicationContext.getContext())) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(112321);
            return true;
        }
        AppMethodBeat.o(112321);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout
    public final void dPZ() {
        AppMethodBeat.i(112322);
        runOnUiThread(new Runnable(true) {
            /* class com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl.AnonymousClass5 */
            final /* synthetic */ boolean xfH = true;

            public final void run() {
                AppMethodBeat.i(112310);
                a aVar = FTSVoiceInputLayoutImpl.this.xfC;
                boolean z = this.xfH;
                Log.d("MicroMsg.FTSVoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", 0, Boolean.valueOf(z));
                if (!z) {
                    aVar.currentState = 3;
                }
                aVar.xfj = a.Nw(0);
                aVar.invalidateSelf();
                aVar.xfl = 0;
                AppMethodBeat.o(112310);
            }
        });
        AppMethodBeat.o(112322);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout
    public final void dQa() {
        AppMethodBeat.i(112323);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(112311);
                a aVar = FTSVoiceInputLayoutImpl.this.xfC;
                Log.d("MicroMsg.FTSVoiceInputDrawable", "recognizingState %s", Integer.valueOf(aVar.currentState));
                aVar.currentState = 4;
                AppMethodBeat.o(112311);
            }
        });
        AppMethodBeat.o(112323);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout
    public final void onReset() {
        AppMethodBeat.i(112324);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(112312);
                FTSVoiceInputLayoutImpl.g(FTSVoiceInputLayoutImpl.this);
                FTSVoiceInputLayoutImpl.this.xfC.dPL();
                AppMethodBeat.o(112312);
            }
        });
        AppMethodBeat.o(112324);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout
    public final void Ny(final int i2) {
        AppMethodBeat.i(112325);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(112313);
                a aVar = FTSVoiceInputLayoutImpl.this.xfC;
                int i2 = i2;
                Log.d("MicroMsg.FTSVoiceInputDrawable", "recordingState() called with: maxAmplitudeRate = [%s]", Integer.valueOf(i2));
                aVar.xfj = a.Nw(i2);
                aVar.invalidateSelf();
                aVar.xfl = i2;
                AppMethodBeat.o(112313);
            }
        });
        AppMethodBeat.o(112325);
    }

    private static void runOnUiThread(Runnable runnable) {
        AppMethodBeat.i(112326);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            MMHandlerThread.postToMainThread(runnable);
            AppMethodBeat.o(112326);
            return;
        }
        runnable.run();
        AppMethodBeat.o(112326);
    }

    static /* synthetic */ void d(FTSVoiceInputLayoutImpl fTSVoiceInputLayoutImpl) {
        AppMethodBeat.i(112327);
        fTSVoiceInputLayoutImpl.xfB.setVisibility(8);
        AppMethodBeat.o(112327);
    }

    static /* synthetic */ void g(FTSVoiceInputLayoutImpl fTSVoiceInputLayoutImpl) {
        AppMethodBeat.i(112328);
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(112306);
                FTSVoiceInputLayoutImpl.this.xfB.setVisibility(0);
                AppMethodBeat.o(112306);
            }
        }, 100);
        AppMethodBeat.o(112328);
    }
}
