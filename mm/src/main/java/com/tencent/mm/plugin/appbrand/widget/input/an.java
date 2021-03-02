package com.tencent.mm.plugin.appbrand.widget.input;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class an implements View.OnTouchListener {
    private static final int Pv = ViewConfiguration.getLongPressTimeout();
    private final Handler ovL = new Handler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.appbrand.widget.input.an.AnonymousClass1 */

        public final void handleMessage(Message message) {
            AppMethodBeat.i(136606);
            switch (message.what) {
                case 1:
                case 2:
                    if (an.a(an.this)) {
                        sendMessageDelayed(Message.obtain(an.this.ovL, 2), 50);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(136606);
        }
    };
    private float ovM;
    private float ovN;
    private boolean ovO = false;

    public an() {
        AppMethodBeat.i(136607);
        AppMethodBeat.o(136607);
    }

    static {
        AppMethodBeat.i(136611);
        AppMethodBeat.o(136611);
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(136608);
        switch (motionEvent.getActionMasked()) {
            case 0:
                view.setPressed(true);
                this.ovL.sendMessageDelayed(Message.obtain(this.ovL, 1), (long) Pv);
                this.ovM = motionEvent.getX();
                this.ovN = motionEvent.getY();
                break;
            case 1:
                if (!this.ovO && this.ovL.hasMessages(1)) {
                    bJj();
                }
                di(view);
                break;
            case 2:
                int scaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (((float) (-scaledTouchSlop)) > x || x > ((float) (view.getWidth() + scaledTouchSlop)) || ((float) (-scaledTouchSlop)) > y || y > ((float) (scaledTouchSlop + view.getHeight()))) {
                    this.ovO = true;
                    break;
                }
            case 3:
                di(view);
                break;
        }
        AppMethodBeat.o(136608);
        return true;
    }

    private void di(View view) {
        AppMethodBeat.i(136609);
        view.setPressed(false);
        this.ovO = false;
        this.ovL.removeMessages(1);
        this.ovL.removeMessages(2);
        AppMethodBeat.o(136609);
    }

    /* access modifiers changed from: protected */
    public void bJj() {
    }

    /* access modifiers changed from: protected */
    public void cbF() {
    }

    static /* synthetic */ boolean a(an anVar) {
        AppMethodBeat.i(136610);
        if (!anVar.ovO) {
            anVar.cbF();
            AppMethodBeat.o(136610);
            return true;
        }
        AppMethodBeat.o(136610);
        return false;
    }
}
