package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.c.c;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class d implements j {
    private boolean dLD = false;
    private Random hmb = new Random();
    private boolean ifz = false;
    Object lock = new Object();
    e.d oRA;
    i oRB;
    boolean oRC = false;
    private long oRD;
    private long oRE;
    int oRF;
    int oRG = 0;
    List<String> oRy = new LinkedList();
    HashSet<String> oRz = new HashSet<>();

    public d() {
        AppMethodBeat.i(21887);
        AppMethodBeat.o(21887);
    }

    public final void pause() {
        AppMethodBeat.i(21888);
        Log.i("MicroMsg.BakPCServer", "pause");
        this.dLD = true;
        AppMethodBeat.o(21888);
    }

    public final void resume() {
        AppMethodBeat.i(21889);
        Log.i("MicroMsg.BakPCServer", "resume");
        this.dLD = false;
        synchronized (this.lock) {
            try {
                this.lock.notifyAll();
            } finally {
                AppMethodBeat.o(21889);
            }
        }
    }

    public final void cancel() {
        AppMethodBeat.i(21890);
        Log.i("MicroMsg.BakPCServer", "cancel");
        this.ifz = true;
        b.b(5, this.oRB);
        this.oRA = null;
        this.oRC = false;
        this.oRF = 0;
        synchronized (this.lock) {
            try {
                this.lock.notifyAll();
            } finally {
                AppMethodBeat.o(21890);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x009b, code lost:
        r7 = new com.tencent.mm.storage.ca();
        r7.convertFrom(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a4, code lost:
        if (r4 <= 0) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a6, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ae, code lost:
        if (r7.field_msgSvrId != 0) goto L_0x0134;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b0, code lost:
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.BackupPackMsgLogic", "packedMsg msgSvrId is 0, talker[%s], type[%d]", r7.field_talker, java.lang.Integer.valueOf(r7.getType()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00cc, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00cd, code lost:
        r11 = r4 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0130, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0134, code lost:
        r2 = new com.tencent.mm.protocal.protobuf.is();
        r2.Brn = r7.field_msgSvrId;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0140, code lost:
        if (r7.field_isSend != 1) goto L_0x01d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0142, code lost:
        r2.KHl = new com.tencent.mm.protocal.protobuf.dqi().bhy(r20);
        r2.KHm = new com.tencent.mm.protocal.protobuf.dqi().bhy(r7.field_talker);
        r5 = 2;
        r6 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x015e, code lost:
        r6.KMN = r5;
        r2.KMS = new com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t();
        r2.KMT = 0;
        r2.KMU = 0;
        r2.KHq = "";
        r2.oUv = com.tencent.mm.pluginsdk.model.app.m.ahM(r7.getType());
        r2.KMO = (int) (r7.field_createTime / 1000);
        r2.KMW = r7.field_createTime;
        r2.KMV = (int) r7.field_msgSeq;
        r2.KMX = r7.field_flag;
        r5 = new com.tencent.mm.protocal.protobuf.dqi();
        r5.bhy(com.tencent.mm.sdk.platformtools.Util.nullAs(r7.field_content, ""));
        r2.KHn = r5;
        r5 = com.tencent.mm.plugin.backup.bakoldlogic.b.d.cgY().Bt(com.tencent.mm.pluginsdk.model.app.m.ahM(r7.getType()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01b5, code lost:
        if (r5 != null) goto L_0x01f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01b7, code lost:
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.BackupPackMsgLogic", "packedMsg unknow type[%d]", java.lang.Integer.valueOf(r7.getType()));
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01d1, code lost:
        r2.KHl = new com.tencent.mm.protocal.protobuf.dqi().bhy(r7.field_talker);
        r2.KHm = new com.tencent.mm.protocal.protobuf.dqi().bhy(r20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01eb, code lost:
        if (r5 == false) goto L_0x01f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01ed, code lost:
        r5 = 3;
        r6 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01f1, code lost:
        r5 = 4;
        r6 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01f5, code lost:
        r5 = r5.a(r2, r7, r20, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01fb, code lost:
        if (r5 >= 0) goto L_0x0200;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01fd, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0200, code lost:
        r12.value += (long) r5;
        r12.value += 60;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x020f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0210, code lost:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("MicroMsg.BakPCServer", r2, "", new java.lang.Object[0]);
        com.tencent.mm.sdk.platformtools.Log.f("MicroMsg.BakPCServer", "backupChatMsg %s".concat(java.lang.String.valueOf(r2)));
        r2 = null;
        r11 = r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean F(java.lang.String r19, java.lang.String r20, int r21) {
        /*
        // Method dump skipped, instructions count: 797
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d.F(java.lang.String, java.lang.String, int):boolean");
    }

    /* access modifiers changed from: package-private */
    public final void chg() {
        AppMethodBeat.i(21892);
        if (!this.oRC || this.ifz) {
            AppMethodBeat.o(21892);
            return;
        }
        synchronized (this.lock) {
            try {
                if (this.oRz.isEmpty()) {
                    a.cgZ().cha().oRS = 4;
                    a.cgZ().cha().oRT = 3;
                    b.b(5, this.oRB);
                    new com.tencent.mm.plugin.backup.bakoldlogic.c.b(5).cgA();
                    a.cgZ().chb().oRu++;
                    if (this.oRA != null) {
                        this.oRA.chn();
                    } else {
                        Log.i("MicroMsg.BakPCServer", "operatorCallback is null");
                    }
                    cancel();
                    Log.i("MicroMsg.BakPCServer", "send backup finish cmd");
                }
            } finally {
                AppMethodBeat.o(21892);
            }
        }
    }

    private static String b(Random random) {
        AppMethodBeat.i(21893);
        String messageDigest = g.getMessageDigest(new StringBuilder().append(Util.currentTicks()).append(random.nextDouble()).toString().getBytes());
        AppMethodBeat.o(21893);
        return messageDigest;
    }

    @Override // com.tencent.mm.ak.j
    public final void a(int i2, int i3, q qVar) {
        AppMethodBeat.i(21894);
        this.oRE += (long) i2;
        int i4 = this.oRD == 0 ? 0 : (int) ((this.oRE * 100) / this.oRD);
        if (i4 > this.oRF) {
            this.oRF = i4;
            c.setProgress(this.oRF);
            if (!this.dLD && !this.ifz && this.oRA != null && this.oRF >= 0 && this.oRF <= 100) {
                this.oRA.By(this.oRF);
            }
        }
        AppMethodBeat.o(21894);
    }
}
