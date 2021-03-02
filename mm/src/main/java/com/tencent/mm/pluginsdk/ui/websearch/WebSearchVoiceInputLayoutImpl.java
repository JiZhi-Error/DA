package com.tencent.mm.pluginsdk.ui.websearch;

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
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

@TargetApi(16)
public class WebSearchVoiceInputLayoutImpl extends VoiceInputLayout {
    private l KdL;
    private View.OnLongClickListener aYy = new View.OnLongClickListener() {
        /* class com.tencent.mm.pluginsdk.ui.websearch.WebSearchVoiceInputLayoutImpl.AnonymousClass1 */

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(32025);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            Log.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onLongClickListener currentState %s", Integer.valueOf(WebSearchVoiceInputLayoutImpl.this.currentState));
            WebSearchVoiceInputLayoutImpl.this.xfD = true;
            WebSearchVoiceInputLayoutImpl.this.KdL.goW();
            a.a(true, (Object) this, "com/tencent/mm/pluginsdk/ui/websearch/WebSearchVoiceInputLayoutImpl$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(32025);
            return true;
        }
    };
    private View.OnTouchListener aZa = new View.OnTouchListener() {
        /* class com.tencent.mm.pluginsdk.ui.websearch.WebSearchVoiceInputLayoutImpl.AnonymousClass2 */

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(32026);
            switch (motionEvent.getAction()) {
                case 0:
                    WebSearchVoiceInputLayoutImpl.this.xfD = false;
                    WebSearchVoiceInputLayoutImpl.this.xfF = Util.currentTicks();
                    Log.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", Integer.valueOf(WebSearchVoiceInputLayoutImpl.this.currentState), Long.valueOf(WebSearchVoiceInputLayoutImpl.this.xfF));
                    WebSearchVoiceInputLayoutImpl.this.KdL.goX();
                    WebSearchVoiceInputLayoutImpl.this.T(false, false);
                    break;
                case 1:
                    Log.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "btn onTouch ACTION_UP currentState %s longClickDown %s", Integer.valueOf(WebSearchVoiceInputLayoutImpl.this.currentState), Boolean.valueOf(WebSearchVoiceInputLayoutImpl.this.xfD));
                    if (!WebSearchVoiceInputLayoutImpl.this.xfD) {
                        WebSearchVoiceInputLayoutImpl.this.T(false, true);
                        break;
                    } else {
                        WebSearchVoiceInputLayoutImpl.this.T(true, false);
                        WebSearchVoiceInputLayoutImpl.this.xfD = false;
                        WebSearchVoiceInputLayoutImpl.this.xfF = 0;
                        break;
                    }
            }
            AppMethodBeat.o(32026);
            return false;
        }
    };
    private View xfA;
    private boolean xfD = false;
    private long xfF;

    public WebSearchVoiceInputLayoutImpl(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(32032);
        init(context);
        AppMethodBeat.o(32032);
    }

    public WebSearchVoiceInputLayoutImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(32033);
        init(context);
        AppMethodBeat.o(32033);
    }

    private void init(Context context) {
        AppMethodBeat.i(32034);
        this.xfA = inflate(context, R.layout.c6i, this).findViewById(R.id.ja2);
        this.xfA.setLayerType(1, null);
        this.KdL = new l(context);
        this.xfA.setBackground(this.KdL);
        this.xfA.setEnabled(true);
        this.xfA.setOnTouchListener(this.aZa);
        this.xfA.setOnLongClickListener(this.aYy);
        reset(true);
        if (isInEditMode()) {
            AppMethodBeat.o(32034);
            return;
        }
        if (!dzA()) {
            dPX();
        }
        AppMethodBeat.o(32034);
    }

    public final void T(boolean z, boolean z2) {
        AppMethodBeat.i(32035);
        Log.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "directStart currentState = %s longUp = %s clickUp = %s", Integer.valueOf(this.currentState), Boolean.valueOf(z), Boolean.valueOf(z2));
        if (this.currentState == 1) {
            if (z || z2) {
                if (z && !z2) {
                    this.KdL.dPL();
                    AppMethodBeat.o(32035);
                    return;
                }
            } else if (!dzA()) {
                dPX();
                AppMethodBeat.o(32035);
                return;
            } else {
                dQm();
                AppMethodBeat.o(32035);
                return;
            }
        } else if (this.currentState == 2) {
            if (!z2) {
                dQn();
                AppMethodBeat.o(32035);
                return;
            }
            this.KdL.dPL();
            biE();
            if (this.KdJ != null) {
                this.KdJ.dPW();
                AppMethodBeat.o(32035);
                return;
            }
        } else if (!z && !z2) {
            biE();
            AppMethodBeat.o(32035);
            return;
        } else if (z && !z2) {
            this.KdL.dPL();
        }
        AppMethodBeat.o(32035);
    }

    private void dPX() {
        AppMethodBeat.i(32036);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.websearch.WebSearchVoiceInputLayoutImpl.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(32027);
                WebSearchVoiceInputLayoutImpl.this.KdL.goZ();
                AppMethodBeat.o(32027);
            }
        });
        dQp();
        AppMethodBeat.o(32036);
    }

    private static boolean dzA() {
        AppMethodBeat.i(32037);
        int aYS = bg.azz().aYS();
        if (aYS == 4 || aYS == 6) {
            AppMethodBeat.o(32037);
            return true;
        }
        AppMethodBeat.o(32037);
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.VoiceInputLayout
    public final void dPZ() {
        AppMethodBeat.i(32038);
        runOnUiThread(new Runnable(true) {
            /* class com.tencent.mm.pluginsdk.ui.websearch.WebSearchVoiceInputLayoutImpl.AnonymousClass4 */
            final /* synthetic */ boolean xfH = true;

            public final void run() {
                AppMethodBeat.i(32028);
                WebSearchVoiceInputLayoutImpl.this.KdL.zP(this.xfH);
                AppMethodBeat.o(32028);
            }
        });
        AppMethodBeat.o(32038);
    }

    @Override // com.tencent.mm.pluginsdk.ui.VoiceInputLayout
    public final void hs(boolean z) {
        AppMethodBeat.i(32039);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.websearch.WebSearchVoiceInputLayoutImpl.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(32029);
                WebSearchVoiceInputLayoutImpl.this.KdL.goY();
                AppMethodBeat.o(32029);
            }
        });
        AppMethodBeat.o(32039);
    }

    @Override // com.tencent.mm.pluginsdk.ui.VoiceInputLayout
    public final void onReset() {
        AppMethodBeat.i(32040);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.websearch.WebSearchVoiceInputLayoutImpl.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(32030);
                WebSearchVoiceInputLayoutImpl.this.KdL.dPL();
                AppMethodBeat.o(32030);
            }
        });
        AppMethodBeat.o(32040);
    }

    @Override // com.tencent.mm.pluginsdk.ui.VoiceInputLayout
    public final void Ny(final int i2) {
        AppMethodBeat.i(32041);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.websearch.WebSearchVoiceInputLayoutImpl.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(32031);
                WebSearchVoiceInputLayoutImpl.this.KdL.aic(i2);
                AppMethodBeat.o(32031);
            }
        });
        AppMethodBeat.o(32041);
    }

    private static void runOnUiThread(Runnable runnable) {
        AppMethodBeat.i(32042);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            MMHandlerThread.postToMainThread(runnable);
            AppMethodBeat.o(32042);
            return;
        }
        runnable.run();
        AppMethodBeat.o(32042);
    }
}
