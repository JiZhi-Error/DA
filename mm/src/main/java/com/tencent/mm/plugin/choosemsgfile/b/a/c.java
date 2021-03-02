package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.e.b;

public abstract class c implements a, Runnable {
    private static long qnq = 2000;
    private int iKP;
    private int offset;
    protected com.tencent.mm.plugin.choosemsgfile.b.b.a qno;
    protected a qnp;
    private boolean qnr = false;
    private Runnable qns = new Runnable() {
        /* class com.tencent.mm.plugin.choosemsgfile.b.a.c.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(123227);
            c.this.qnr = true;
            if (c.this.qnp != null) {
                c.this.qnp.fk(c.this.offset, c.this.iKP);
            }
            AppMethodBeat.o(123227);
        }
    };

    /* access modifiers changed from: protected */
    public abstract void bPM();

    /* access modifiers changed from: protected */
    public abstract boolean checkValid();

    /* access modifiers changed from: protected */
    public abstract boolean cyn();

    public c(com.tencent.mm.plugin.choosemsgfile.b.b.a aVar, a aVar2, b bVar) {
        this.qno = aVar;
        this.qnp = aVar2;
        if (bVar != null) {
            bVar.keep(this);
        }
    }

    @Override // com.tencent.mm.vending.e.a
    public void dead() {
    }

    public void run() {
        MMHandlerThread.postToMainThreadDelayed(this.qns, qnq);
        bPM();
    }

    /* access modifiers changed from: protected */
    public final synchronized void b(MsgFile msgFile) {
        Log.i("MicroMsg.MsgFileWorker_Base", "onDownloadSuccess msgFile:%s", msgFile);
        if (this.qnp != null) {
            this.qnp.a(msgFile);
            this.qnp = null;
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void cyo() {
        Log.i("MicroMsg.MsgFileWorker_Base", "onDownloadStop");
        if (this.qnp != null) {
            this.qnp.cyl();
            this.qnp = null;
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void cyp() {
        Log.i("MicroMsg.MsgFileWorker_Base", "onDownloadFail");
        if (this.qnp != null) {
            this.qnp.cyk();
            this.qnp = null;
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void fl(int i2, int i3) {
        Log.v("MicroMsg.MsgFileWorker_Base", "onDownloadProgress offset:%d totalLen:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.offset = i2;
        this.iKP = i3;
        if (this.qnr && this.qnp != null) {
            this.qnp.fk(i2, i3);
        }
    }

    public String toString() {
        return "MsgFileWorker_Base{mMsgItem=" + this.qno + '}';
    }
}
