package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class o implements View.OnTouchListener {
    private static boolean DEBUG = false;
    private static int FfB;
    private static int Pw = ViewConfiguration.getTapTimeout();
    private p Kru = null;
    private boolean Krv = false;
    private View Krw = null;
    private MMHandler Krx = new MMHandler(Looper.getMainLooper());
    private b Kry = new b(this, (byte) 0);
    private a Krz = new a();
    private a mAdTagClickCallback;
    public int mAdTagClickScene;
    String mSessionId;
    private boolean ooU = false;
    private int position;
    private Context uiContext = null;
    private View view;

    static /* synthetic */ void a(o oVar, int i2) {
        AppMethodBeat.i(152337);
        oVar.aiL(i2);
        AppMethodBeat.o(152337);
    }

    static {
        AppMethodBeat.i(152338);
        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
        FfB = longPressTimeout;
        if (longPressTimeout > Pw * 2) {
            FfB -= Pw;
        }
        Log.d("MicroMsg.PressSpanTouchListener", "long press timeout:%d", Integer.valueOf(FfB));
        AppMethodBeat.o(152338);
    }

    public o() {
        AppMethodBeat.i(152331);
        AppMethodBeat.o(152331);
    }

    public o(Context context) {
        AppMethodBeat.i(152332);
        this.uiContext = context;
        AppMethodBeat.o(152332);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x017b, code lost:
        if (r6 > (((com.tencent.mm.kiss.widget.textview.StaticTextView) r12).getVerticalDrawOffset() + r3.getHeight())) goto L_0x017d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01b7, code lost:
        if (r6 > (((android.widget.TextView) r12).getTotalPaddingTop() + r3.getHeight())) goto L_0x01b9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x040c  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0413  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
        /*
        // Method dump skipped, instructions count: 1107
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.span.o.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private void af(MotionEvent motionEvent) {
        AppMethodBeat.i(152334);
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            resetStatus();
        }
        AppMethodBeat.o(152334);
    }

    public final void resetStatus() {
        AppMethodBeat.i(152335);
        if (this.Kru != null) {
            this.Kru.setIsPressed(false);
            this.Kru.setContext(null);
            this.Krw.invalidate();
            this.Krw = null;
            this.Kru = null;
        }
        AppMethodBeat.o(152335);
    }

    class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(o oVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(152330);
            o.a(o.this, o.Pw);
            AppMethodBeat.o(152330);
        }
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        a() {
        }

        public final void run() {
            AppMethodBeat.i(152329);
            if (o.this.view != null && o.this.view.isPressed()) {
                Log.d("MicroMsg.PressSpanTouchListener", "long pressed timeout");
                o.this.ooU = true;
                o.this.resetStatus();
            }
            AppMethodBeat.o(152329);
        }
    }

    private void aiL(int i2) {
        AppMethodBeat.i(152336);
        if (this.view != null) {
            this.Krx.postDelayed(this.Krz, (long) (FfB - i2));
        }
        AppMethodBeat.o(152336);
    }

    public final void setAdTagClickCallback(a aVar, int i2) {
        this.mAdTagClickCallback = aVar;
        this.position = i2;
    }
}
