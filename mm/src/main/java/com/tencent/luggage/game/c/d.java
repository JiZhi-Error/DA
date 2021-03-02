package com.tencent.luggage.game.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.support.v7.widget.AppCompatTextView;
import android.view.MotionEvent;
import com.tencent.luggage.game.c.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"ViewConstructor"})
public final class d extends AppCompatTextView {
    StringBuilder bDv = new StringBuilder(100);
    private final List<f> cvc = new ArrayList(4);
    public e.c cvd = null;
    public MTimerHandler cve = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.luggage.game.c.d.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(130512);
            d.this.cvc.clear();
            if (d.this.cvd != null) {
                d.this.cvd.F(d.this.cvc);
            }
            d dVar = d.this;
            List<f> list = d.this.cvc;
            dVar.bDv.setLength(0);
            for (f fVar : list) {
                dVar.bDv.append(fVar.key).append("[").append(fVar.cvw).append("] ");
            }
            dVar.setText(dVar.bDv);
            AppMethodBeat.o(130512);
            return true;
        }
    }, true);

    public d(Context context) {
        super(context);
        AppMethodBeat.i(130513);
        setTextSize(12.0f);
        setTextColor(-65536);
        setFocusable(false);
        setClickable(false);
        setOnClickListener(null);
        this.cve.startTimer(2000);
        AppMethodBeat.o(130513);
    }

    public final void setInfo(List<f> list) {
        AppMethodBeat.i(130514);
        this.bDv.setLength(0);
        for (f fVar : list) {
            this.bDv.append(fVar.key).append("[").append(fVar.cvw).append("] ");
        }
        setText(this.bDv);
        AppMethodBeat.o(130514);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public final void setOnRequestUpdateShowItemsCallback(e.c cVar) {
        this.cvd = cVar;
    }
}
