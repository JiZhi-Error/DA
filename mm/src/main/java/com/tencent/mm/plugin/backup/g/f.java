package com.tencent.mm.plugin.backup.g;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.i.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import junit.framework.Assert;

public final class f {
    public static int oPJ = 10000;
    public static int oPK = 5000;
    private int oPL = 0;
    private long oPM = 0;
    private long oPN = 0;
    private boolean oPO = false;
    private Boolean oPP = null;

    public final void cgJ() {
        AppMethodBeat.i(21721);
        this.oPM = Util.nowMilliSecond();
        Log.d("MicroMsg.BackupHeartBeatHandler", "updateHeartBeatTimeStamp[%d]", Long.valueOf(this.oPM));
        this.oPO = false;
        if (this.oPL != 0) {
            this.oPL = 0;
            start(false);
        }
        AppMethodBeat.o(21721);
    }

    public final void cgK() {
        AppMethodBeat.i(21722);
        this.oPN = this.oPN == MAlarmHandler.NEXT_FIRE_INTERVAL ? 0 : this.oPN + 1;
        e eVar = new e();
        eVar.oPN = this.oPN;
        try {
            Log.i("MicroMsg.BackupHeartBeatHandler", "sendBackupHeartBeatRequest send heartbeat req, ack:%d", Long.valueOf(eVar.oPN));
            b.N(eVar.toByteArray(), 9);
            AppMethodBeat.o(21722);
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.BackupHeartBeatHandler", e2, "buf to BackupHeartBeatRequest err.", new Object[0]);
            AppMethodBeat.o(21722);
        }
    }

    public final void stop() {
        AppMethodBeat.i(21723);
        if (this.oPP != null) {
            Log.i("MicroMsg.BackupHeartBeatHandler", "stop");
            this.oPP = Boolean.TRUE;
        }
        AppMethodBeat.o(21723);
    }

    public final void start(boolean z) {
        AppMethodBeat.i(21724);
        if (z) {
            Assert.assertTrue("New BackupHeartBeatHandler EveryTime !", this.oPP == null);
        }
        Log.i("MicroMsg.BackupHeartBeatHandler", "start backup heart beat handler.");
        cgJ();
        this.oPP = Boolean.FALSE;
        h.RTc.ba(new com.tencent.f.i.h() {
            /* class com.tencent.mm.plugin.backup.g.f.AnonymousClass1 */

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                return "BackupSendBackupHeartBeat";
            }

            public final void run() {
                AppMethodBeat.i(21720);
                while (!f.this.oPP.booleanValue()) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e2) {
                    }
                    if (f.this.oPP.booleanValue()) {
                        Log.e("MicroMsg.BackupHeartBeatHandler", "start BackupSendBackupHeartBeat thread stopped.");
                        AppMethodBeat.o(21720);
                        return;
                    }
                    long milliSecondsToNow = Util.milliSecondsToNow(f.this.oPM);
                    Log.d("MicroMsg.BackupHeartBeatHandler", "start heartBeatState[%d], heartBeatTimeStamp[%d], timeDiff[%d], hasSendHeartBeat[%b]", Integer.valueOf(f.this.oPL), Long.valueOf(f.this.oPM), Long.valueOf(milliSecondsToNow), Boolean.valueOf(f.this.oPO));
                    if (!f.this.oPO) {
                        if (milliSecondsToNow < ((long) f.oPJ)) {
                            f.this.oPL = 0;
                        } else {
                            Log.e("MicroMsg.BackupHeartBeatHandler", "start send heartbeat req, heartBeatTimeStamp[%d], timeDiff[%d]", Long.valueOf(f.this.oPM), Long.valueOf(milliSecondsToNow));
                            f.this.cgK();
                            f.this.cgJ();
                            f.this.oPO = true;
                        }
                    } else if (milliSecondsToNow >= ((long) f.oPK)) {
                        if (f.this.oPL != 1) {
                            Log.e("MicroMsg.BackupHeartBeatHandler", "start weak connect Timeout Now! heartBeatTimeStamp[%d], timeDiff[%d]", Long.valueOf(f.this.oPM), Long.valueOf(milliSecondsToNow));
                            f.this.oPL = 1;
                        }
                        f.this.stop();
                        AppMethodBeat.o(21720);
                        return;
                    }
                }
                AppMethodBeat.o(21720);
            }
        });
        cgK();
        AppMethodBeat.o(21724);
    }
}
