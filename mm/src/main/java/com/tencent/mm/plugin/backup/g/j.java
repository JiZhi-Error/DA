package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.Queue;

public final class j {
    private static int oQe = 60000;
    private a oLY;
    long oQf = 0;
    long oQg;
    long oQh;
    long oQi;
    long oQj;
    int oQk = 0;
    Queue<Long> oQl = new LinkedList();
    MTimerHandler oQm = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.backup.g.j.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            long j2;
            AppMethodBeat.i(21735);
            long milliSecondsToNow = Util.milliSecondsToNow(j.this.oQi);
            if (milliSecondsToNow != 0) {
                j.this.oQg = (j.this.oQh / milliSecondsToNow) * 1000;
                j.this.oQl.offer(Long.valueOf(j.this.oQg));
                try {
                    j2 = ((Long) j.this.oQl.poll()).longValue();
                } catch (Exception e2) {
                    j2 = 0;
                }
                j.this.oQg = (((j.this.oQf * 10) - j2) + j.this.oQg) / 10;
                j.this.oQg = j.this.oQg > 0 ? j.this.oQg : 0;
                j.this.oQf = j.this.oQg;
                j.this.oQh = 0;
                j.this.oQi = Util.nowMilliSecond();
                j.this.oLY.cfI();
                if (j.this.oQg >= 102400) {
                    if (j.this.oQk != 0) {
                        j.this.oQk = 0;
                        j.this.oQj = 0;
                        j.this.oLY.Bf(0);
                        Log.i("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is not low speed now.");
                    }
                } else if (j.this.oQg < 2) {
                    if (j.this.oQk == 0) {
                        j.this.oQk = 1;
                        j.this.oLY.Bf(1);
                        j.this.oQj = Util.nowMilliSecond();
                        Log.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is too low speed! backupLowSpeedStartTime[%d]", Long.valueOf(j.this.oQj));
                    } else if (j.this.oQk == 1) {
                        if (j.this.oQj <= 0) {
                            j.this.oQj = Util.nowMilliSecond();
                            Log.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is too low speed! backupLowSpeedStartTime[%d]", Long.valueOf(j.this.oQj));
                        } else if (Util.milliSecondsToNow(j.this.oQj) > ((long) j.oQe)) {
                            Log.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler low speed overtime, overtime[%d]", Long.valueOf(Util.milliSecondsToNow(j.this.oQj)));
                            j.this.oQk = 2;
                            j.this.oLY.cfJ();
                            j.this.oQj = 0;
                            AppMethodBeat.o(21735);
                            return false;
                        }
                    }
                } else if (j.this.oQk != 1) {
                    j.this.oQk = 1;
                    j.this.oLY.Bf(1);
                    Log.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is weak now.");
                }
            }
            AppMethodBeat.o(21735);
            return true;
        }
    }, true);

    public interface a {
        void Bf(int i2);

        void cfI();

        void cfJ();
    }

    public j(a aVar) {
        AppMethodBeat.i(21736);
        this.oLY = aVar;
        AppMethodBeat.o(21736);
    }

    static String Bx(long j2) {
        AppMethodBeat.i(21737);
        if ((j2 >> 30) > 0) {
            String sizeGB = Util.getSizeGB(j2, 100.0d);
            AppMethodBeat.o(21737);
            return sizeGB;
        } else if ((j2 >> 20) > 0) {
            String sizeMB = Util.getSizeMB(j2, 100.0d);
            AppMethodBeat.o(21737);
            return sizeMB;
        } else if ((j2 >> 9) > 0) {
            String str = Math.round(((float) j2) / 1024.0f) + " KB";
            AppMethodBeat.o(21737);
            return str;
        } else {
            String str2 = j2 + " B";
            AppMethodBeat.o(21737);
            return str2;
        }
    }
}
