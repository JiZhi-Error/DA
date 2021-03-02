package com.tencent.mm.plugin.facedetect.ui;

import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.lang.ref.WeakReference;

public final class a {
    static CountDownTimerC1039a sTu = new CountDownTimerC1039a();
    RelativeLayout sTs;
    private Animation sTt;

    static {
        AppMethodBeat.i(103917);
        AppMethodBeat.o(103917);
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.a$a  reason: collision with other inner class name */
    public static class CountDownTimerC1039a extends CountDownTimer {
        private int sTA = 0;
        int sTB = 0;
        private WeakReference<TextView> sTx = null;
        private WeakReference<TextView> sTy = null;
        private String sTz = null;

        public CountDownTimerC1039a() {
            super(MAlarmHandler.NEXT_FIRE_INTERVAL, 500);
        }

        public final void onTick(long j2) {
            AppMethodBeat.i(103904);
            if (this.sTx == null || this.sTx.get() == null || this.sTy == null || this.sTy.get() == null) {
                Log.w("MicroMsg.FaceDetectJumper", "hy: tv ref released");
                cancel();
            } else {
                this.sTx.get().setText(this.sTz.substring(0, this.sTA));
                this.sTy.get().setText(this.sTz.substring(this.sTA, this.sTA + (this.sTB % ((this.sTz.length() - this.sTA) + 1))));
            }
            this.sTB++;
            AppMethodBeat.o(103904);
        }

        public final void onFinish() {
        }
    }
}
