package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;

public final class h {
    static int index = 0;
    private a oOt;
    int[] oPY = {1000, 1000, 1000, 2000, 5000, 9000, 1000};
    int oPZ = 0;
    MTimerHandler oQa = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.backup.g.h.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(21731);
            if (h.this.stopped) {
                Log.e("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler stopped is true, index[%d]", Integer.valueOf(h.index));
                h.this.oPZ = 0;
                AppMethodBeat.o(21731);
            } else {
                Log.i("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler start reconnect, index[%d]", Integer.valueOf(h.index));
                if (h.index < h.this.oPY.length) {
                    h.this.oOt.cgh();
                    h.this.oQa.startTimer((long) h.this.oPY[h.index]);
                    h.aYz();
                } else {
                    h.this.stopped = true;
                    h.this.oPZ = 0;
                    h.this.oOt.cgi();
                }
                AppMethodBeat.o(21731);
            }
            return false;
        }
    }, false);
    boolean stopped = false;

    public interface a {
        void cgh();

        void cgi();
    }

    static /* synthetic */ int aYz() {
        int i2 = index;
        index = i2 + 1;
        return i2;
    }

    public h(a aVar) {
        AppMethodBeat.i(21732);
        this.oOt = aVar;
        AppMethodBeat.o(21732);
    }
}
