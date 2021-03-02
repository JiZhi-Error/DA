package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.choosemsgfile.b.b.a;
import com.tencent.mm.plugin.choosemsgfile.b.b.e;
import com.tencent.mm.plugin.choosemsgfile.b.b.j;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.vending.e.b;

public final class d extends c {
    private int aqi;
    private MTimerHandler cve;
    private int fs = 0;

    static /* synthetic */ void c(d dVar) {
        AppMethodBeat.i(123233);
        dVar.callback();
        AppMethodBeat.o(123233);
    }

    public d(a aVar, a aVar2, b bVar) {
        super(aVar, aVar2, bVar);
        AppMethodBeat.i(123229);
        this.aqi = aVar.cyt();
        AppMethodBeat.o(123229);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.choosemsgfile.b.a.c
    public final boolean cyn() {
        AppMethodBeat.i(123230);
        if (cyq()) {
            callback();
        }
        boolean cyq = cyq();
        AppMethodBeat.o(123230);
        return cyq;
    }

    private boolean cyq() {
        if (this.qno instanceof j) {
            return ((j) this.qno).qnM;
        }
        if (this.qno instanceof e) {
            return ((e) this.qno).qnM;
        }
        return false;
    }

    private void callback() {
        AppMethodBeat.i(123232);
        if (cyr()) {
            MsgFile msgFile = new MsgFile();
            msgFile.fileSize = this.qno.cyt();
            msgFile.filePath = "only for test";
            msgFile.fileName = this.qno.getFileName() + "." + msgFile.gCr;
            msgFile.type = "file";
            msgFile.gCr = this.qno.getFileExt();
            msgFile.timeStamp = this.qno.getTimeStamp();
            b(msgFile);
            AppMethodBeat.o(123232);
            return;
        }
        cyp();
        AppMethodBeat.o(123232);
    }

    private boolean cyr() {
        if (this.qno instanceof j) {
            return ((j) this.qno).qnO;
        }
        if (this.qno instanceof e) {
            return ((e) this.qno).qnO;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.choosemsgfile.b.a.c
    public final boolean checkValid() {
        if (this.qno instanceof j) {
            return ((j) this.qno).qnL;
        }
        if (this.qno instanceof e) {
            return ((e) this.qno).qnL;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.choosemsgfile.b.a.c
    public final void bPM() {
        boolean z;
        long j2;
        AppMethodBeat.i(123231);
        if (this.qno instanceof j) {
            z = ((j) this.qno).qnN;
        } else if (this.qno instanceof e) {
            z = ((e) this.qno).qnN;
        } else {
            z = false;
        }
        if (z) {
            if (this.cve == null) {
                this.cve = new MTimerHandler(g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                    /* class com.tencent.mm.plugin.choosemsgfile.b.a.d.AnonymousClass1 */

                    @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                    public final boolean onTimerExpired() {
                        AppMethodBeat.i(123228);
                        d.this.fs += 1048576;
                        if (d.this.fs > d.this.aqi) {
                            d.this.fs = d.this.aqi;
                        }
                        d.this.fl(d.this.fs, d.this.aqi);
                        if (d.this.fs == d.this.aqi) {
                            d.c(d.this);
                            d.this.cve.stopTimer();
                            d.this.cve = null;
                        }
                        AppMethodBeat.o(123228);
                        return true;
                    }
                }, true);
            }
            MTimerHandler mTimerHandler = this.cve;
            if (this.qno instanceof j) {
                j2 = ((j) this.qno).qnP;
            } else if (this.qno instanceof e) {
                j2 = ((e) this.qno).qnP;
            } else {
                j2 = 1000;
            }
            mTimerHandler.startTimer(j2);
            AppMethodBeat.o(123231);
            return;
        }
        callback();
        AppMethodBeat.o(123231);
    }
}
