package com.tencent.mm.picker.base.c;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;

public final class d extends Handler {
    private final WheelView jKa;

    public d(WheelView wheelView) {
        this.jKa = wheelView;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void handleMessage(Message message) {
        AppMethodBeat.i(175297);
        switch (message.what) {
            case 1000:
                this.jKa.invalidate();
                AppMethodBeat.o(175297);
                return;
            case 2000:
                this.jKa.a(WheelView.a.FLING);
                AppMethodBeat.o(175297);
                return;
            case 3000:
                WheelView wheelView = this.jKa;
                if (wheelView.jKl != null) {
                    wheelView.postDelayed(new Runnable() {
                        /* class com.tencent.mm.picker.base.view.WheelView.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(175299);
                            WheelView.this.jKl.onItemSelected(WheelView.this.getCurrentItem());
                            AppMethodBeat.o(175299);
                        }
                    }, 200);
                    break;
                }
                break;
        }
        AppMethodBeat.o(175297);
    }
}
