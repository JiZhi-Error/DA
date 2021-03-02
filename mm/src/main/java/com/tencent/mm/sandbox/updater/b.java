package com.tencent.mm.sandbox.updater;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.network.x;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.bwp;
import com.tencent.mm.protocal.protobuf.bwq;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.jr;
import com.tencent.mm.sandbox.b;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.io.File;

public final class b extends c {
    private int LVT = 0;
    private int NEH = 0;
    private final int NEI = 5;
    private b.a NEJ;
    private a NEK = null;
    private b.a NEL = new b.a() {
        /* class com.tencent.mm.sandbox.updater.b.AnonymousClass1 */

        @Override // com.tencent.mm.sandbox.b.a
        public final void b(int i2, int i3, dpc dpc) {
            AppMethodBeat.i(32657);
            if (i2 == 200 && i3 == 0 && (dpc == null || dpc.getBaseResponse().Ret == 0)) {
                bwq bwq = (bwq) dpc;
                Log.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : file dir = " + com.tencent.mm.loader.j.b.aKD());
                Log.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : total len = " + bwq.BsF);
                Log.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : start pos = " + bwq.BsG);
                Log.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : data len = " + bwq.BsH);
                if (bwq.BsH <= 0 || bwq.BsI == null) {
                    Log.e("MicroMsg.NetSceneGetUpdatePack", "data is null");
                    b.this.NEJ.b(i2, -1, null);
                    AppMethodBeat.o(32657);
                } else if (bwq.BsI.getILen() != bwq.BsH) {
                    Log.e("MicroMsg.NetSceneGetUpdatePack", "data len not match with data buf, dataLen = " + bwq.BsH + " data buf len = " + bwq.BsI.getILen());
                    b.this.NEJ.b(4, -1, null);
                    AppMethodBeat.o(32657);
                } else if (bwq.BsG < 0 || bwq.BsG + bwq.BsH > bwq.BsF) {
                    Log.e("MicroMsg.NetSceneGetUpdatePack", "startPos = " + bwq.BsG + " dataLen = " + bwq.BsH + " totalLen = " + bwq.BsF);
                    b.this.NEJ.b(4, -1, null);
                    AppMethodBeat.o(32657);
                } else if (bwq.BsF <= 0) {
                    Log.e("MicroMsg.NetSceneGetUpdatePack", "totalLen is invalid: totalLen = " + bwq.BsF);
                    b.this.NEJ.b(4, -1, null);
                    AppMethodBeat.o(32657);
                } else {
                    int A = d.A(c.NEn + b.this.NEr + ".temp", bwq.BsI.getBuffer().toByteArray());
                    if (A != 0) {
                        Log.e("MicroMsg.NetSceneGetUpdatePack", "appendBuf failed : ".concat(String.valueOf(A)));
                        b.this.NEJ.b(4, -1, null);
                        AppMethodBeat.o(32657);
                        return;
                    }
                    b.this.NEq = bwq.BsH + bwq.BsG;
                    b.this.NEp = bwq.BsF;
                    b.this.NEJ.fn(bwq.BsF, bwq.BsG);
                    if (bwq.BsG + bwq.BsH >= bwq.BsF) {
                        try {
                            if (b.this.NEr.equalsIgnoreCase(d.bhK(b.e(b.this)))) {
                                d.bo(c.NEn, b.this.NEr + ".temp", b.this.NEr + ".apk");
                                b.this.NEJ.b(200, 0, dpc);
                                AppMethodBeat.o(32657);
                                return;
                            }
                            Log.e("MicroMsg.NetSceneGetUpdatePack", "update pack check error");
                            new File(b.i(b.this)).delete();
                            b.this.NEJ.b(-1, -1, dpc);
                            AppMethodBeat.o(32657);
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e2, "", new Object[0]);
                            AppMethodBeat.o(32657);
                        }
                    } else {
                        b.this.a(b.this.NEJ);
                        AppMethodBeat.o(32657);
                    }
                }
            } else if (b.this.gvZ() || b.a(b.this) >= b.this.cze.length * 5) {
                b.this.NEJ.b(i2, i3, dpc);
                AppMethodBeat.o(32657);
            } else {
                b.this.a(b.this.NEJ);
                AppMethodBeat.o(32657);
            }
        }

        @Override // com.tencent.mm.sandbox.a
        public final void MC(long j2) {
            AppMethodBeat.i(32658);
            b.this.NEJ.MC(j2);
            AppMethodBeat.o(32658);
        }

        @Override // com.tencent.mm.sandbox.a
        public final void MD(long j2) {
            AppMethodBeat.i(32659);
            b.this.NEJ.MD(j2);
            AppMethodBeat.o(32659);
        }

        @Override // com.tencent.mm.sandbox.b.a
        public final void fn(int i2, int i3) {
        }
    };
    private String[] cze;
    private byte[] ees;
    private byte[] jDo;
    private byte[] jDs;
    private int uin;

    static /* synthetic */ int a(b bVar) {
        int i2 = bVar.LVT + 1;
        bVar.LVT = i2;
        return i2;
    }

    static /* synthetic */ String e(b bVar) {
        AppMethodBeat.i(32668);
        String bhO = bVar.bhO();
        AppMethodBeat.o(32668);
        return bhO;
    }

    static /* synthetic */ String i(b bVar) {
        AppMethodBeat.i(32669);
        String bhO = bVar.bhO();
        AppMethodBeat.o(32669);
        return bhO;
    }

    public b(int i2, String str, int i3, int i4, byte[] bArr, byte[] bArr2, String[] strArr, boolean z) {
        super(i2, str, i3, z);
        AppMethodBeat.i(32665);
        this.cze = strArr;
        if (strArr == null || strArr.length == 0) {
            this.cze = new String[]{WeChatHosts.domainString(R.string.e2c)};
        }
        this.uin = i4;
        this.jDo = bArr;
        this.ees = bArr2;
        AppMethodBeat.o(32665);
    }

    @Override // com.tencent.mm.sandbox.b
    public final void a(b.a aVar) {
        AppMethodBeat.i(32666);
        this.NEJ = aVar;
        int i2 = this.NEH + 1;
        this.NEH = i2;
        if (i2 > 1000) {
            Log.d("MicroMsg.NetSceneGetUpdatePack", "doSceneCnt > DOSCENE_LIMIT, return");
            this.NEJ.b(-1, -1, null);
            AppMethodBeat.o(32666);
        } else if (!e.yV((long) this.NEp)) {
            Log.e("MicroMsg.NetSceneGetUpdatePack", "SDCard full, packSize=[%s]", Integer.valueOf(this.NEp));
            aVar.b(-1, -1, null);
            AppMethodBeat.o(32666);
        } else {
            bwp bwp = new bwp();
            jr jrVar = new jr();
            jrVar.KOj = d.KyO;
            jrVar.Scene = 0;
            jrVar.rBx = this.uin;
            jrVar.KOi = com.tencent.mm.bw.b.cD(q.aoG().getBytes());
            if (jrVar.KOi.zy.length >= 16) {
                jrVar.KOi = jrVar.KOi.aiU(16);
            }
            jrVar.KOk = com.tencent.mm.bw.b.cD(d.ics.getBytes());
            if (jrVar.KOk.zy.length >= 132) {
                jrVar.KOk = jrVar.KOk.aiU(132);
            }
            jrVar.KOh = com.tencent.mm.bw.b.cD(this.jDo);
            if (jrVar.KOh.zy.length >= 36) {
                jrVar.KOh = jrVar.KOh.aiU(36);
            }
            bwp.setBaseRequest(jrVar);
            bwp.Mck = this.NEo;
            bwp.BsG = this.NEq;
            bwp.BsF = this.NEp;
            a aVar2 = new a(this.cze[this.LVT / 5], this.NEL);
            this.NEK = aVar2;
            aVar2.execute(bwp);
            AppMethodBeat.o(32666);
        }
    }

    @Override // com.tencent.mm.sandbox.b
    public final void cancel() {
        AppMethodBeat.i(32667);
        Log.i("MicroMsg.NetSceneGetUpdatePack", "do cancel, updateType = " + this.NEo);
        if (this.NEK != null && !this.NEK.isCancelled()) {
            this.NEK.cancel(true);
        }
        AppMethodBeat.o(32667);
    }

    /* access modifiers changed from: package-private */
    public class a extends AsyncTask<bwp, Integer, bwq> {
        private b.a NEJ = null;
        private x NEN = null;
        private int NEO = 200;
        private PInt NEP = new PInt();
        private String host = null;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ bwq doInBackground(bwp[] bwpArr) {
            AppMethodBeat.i(32664);
            bwq a2 = a(bwpArr);
            AppMethodBeat.o(32664);
            return a2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ void onPostExecute(bwq bwq) {
            AppMethodBeat.i(32663);
            bwq bwq2 = bwq;
            Log.d("MicroMsg.NetSceneGetUpdatePack", "onPostExecute, netRet=" + this.NEO + ", svrRet=" + this.NEP.value + ", result=" + bwq2);
            this.NEJ.b(this.NEO, this.NEP.value, bwq2);
            AppMethodBeat.o(32663);
        }

        public a(String str, b.a aVar) {
            AppMethodBeat.i(32660);
            this.host = str;
            this.NEJ = aVar;
            AppMethodBeat.o(32660);
        }

        /* JADX WARNING: Removed duplicated region for block: B:102:0x033c  */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x02d0 A[SYNTHETIC, Splitter:B:76:0x02d0] */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x02d5 A[SYNTHETIC, Splitter:B:79:0x02d5] */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x02de  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x032e A[SYNTHETIC, Splitter:B:95:0x032e] */
        /* JADX WARNING: Removed duplicated region for block: B:98:0x0333 A[SYNTHETIC, Splitter:B:98:0x0333] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private com.tencent.mm.protocal.protobuf.bwq a(com.tencent.mm.protocal.protobuf.bwp... r18) {
            /*
            // Method dump skipped, instructions count: 893
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sandbox.updater.b.a.a(com.tencent.mm.protocal.protobuf.bwp[]):com.tencent.mm.protocal.protobuf.bwq");
        }

        /* access modifiers changed from: protected */
        public final void onCancelled() {
            AppMethodBeat.i(32662);
            Log.d("MicroMsg.NetSceneGetUpdatePack", "task had been cancelled.");
            if (this.NEN != null) {
                this.NEN.disconnect();
            }
            AppMethodBeat.o(32662);
        }
    }
}
