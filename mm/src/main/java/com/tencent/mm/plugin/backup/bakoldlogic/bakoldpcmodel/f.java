package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.q;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.b.d;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.i.ab;
import com.tencent.mm.plugin.backup.i.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.protocal.protobuf.it;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class f implements j {
    boolean dLD = false;
    boolean ifz = false;
    Object lock = new Object();
    boolean oKz = false;
    e.d oRA;
    private i oRB;
    boolean oRC = false;
    int oRG = 0;
    HashSet<String> oRz = new HashSet<>();
    List<t> oSa;
    List<t> oSb;
    int oSc = 0;
    public boolean oSd = false;
    long oSe;
    long oSf;
    int oSg;

    public f() {
        AppMethodBeat.i(21925);
        AppMethodBeat.o(21925);
    }

    public final void pause() {
        AppMethodBeat.i(21926);
        Log.i("MicroMsg.RecoverPCServer", "pause");
        this.dLD = true;
        AppMethodBeat.o(21926);
    }

    public final void resume() {
        AppMethodBeat.i(21927);
        Log.i("MicroMsg.RecoverPCServer", "resume");
        this.dLD = false;
        synchronized (this.lock) {
            try {
                this.lock.notifyAll();
            } finally {
                AppMethodBeat.o(21927);
            }
        }
    }

    public final void cancel() {
        AppMethodBeat.i(21928);
        Log.i("MicroMsg.RecoverPCServer", "cancel");
        this.ifz = true;
        synchronized (this.lock) {
            try {
                this.lock.notifyAll();
            } catch (Throwable th) {
                AppMethodBeat.o(21928);
                throw th;
            }
        }
        b.b(7, this.oRB);
        this.oRA = null;
        this.oSd = false;
        this.oKz = false;
        this.oSc = 0;
        this.oSg = 0;
        AppMethodBeat.o(21928);
    }

    /* access modifiers changed from: package-private */
    public final void chq() {
        AppMethodBeat.i(21929);
        if (!this.oRC || this.ifz) {
            AppMethodBeat.o(21929);
            return;
        }
        synchronized (this.lock) {
            try {
                if (this.oRz.isEmpty()) {
                    if (!this.ifz) {
                        this.oSd = true;
                        this.oSg = 0;
                        a.cgZ().cha().oRS = 6;
                        a.cgZ().cha().oRT = 5;
                        if (this.oRA != null) {
                            this.oRA.chn();
                        } else {
                            Log.i("MicroMsg.RecoverPCServer", "operatorCallback is null");
                        }
                        b.b(7, this.oRB);
                        eT(0, 0);
                        e.chl();
                        Log.i("MicroMsg.RecoverPCServer", "checkRecover publicRestAccUinEven");
                    } else {
                        return;
                    }
                }
                AppMethodBeat.o(21929);
            } finally {
                AppMethodBeat.o(21929);
            }
        }
    }

    public static int ca(List<t> list) {
        AppMethodBeat.i(21930);
        int i2 = 0;
        for (t tVar : list) {
            try {
                i2 = ((it) new it().parseFrom(s.aW(a.cgW() + "backupItem/" + a.agK(tVar.ID) + tVar.ID, 0, -1))).oTA.size() + i2;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.RecoverPCServer", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(21930);
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final void eT(int i2, int i3) {
        AppMethodBeat.i(21931);
        int i4 = (int) (i2 == 0 ? 0 : (((long) i2) * 100) / ((long) i3));
        if (!(i2 == 0 && i3 == 0) && i4 <= this.oSc) {
            AppMethodBeat.o(21931);
            return;
        }
        this.oSc = i4;
        if (!this.dLD && !this.ifz && this.oRA != null && this.oSc >= 0 && this.oSc <= 100) {
            this.oRA.Bz(this.oSc);
        }
        ab abVar = new ab();
        abVar.oTl = 13;
        abVar.oUK = 0;
        abVar.oUL = this.oSc;
        try {
            Log.i("MicroMsg.RecoverPCServer", "send progress cmd, progress :%d", Integer.valueOf(i4));
            b.N(abVar.toByteArray(), 3);
            AppMethodBeat.o(21931);
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.RecoverPCServer", e2, "", new Object[0]);
            Log.e("MicroMsg.RecoverPCServer", "buf to PacketCommandRequest err");
            AppMethodBeat.o(21931);
        }
    }

    /* access modifiers changed from: package-private */
    public final int a(String str, HashMap<String, Integer> hashMap, c cVar, HashSet<String> hashSet) {
        String str2;
        long j2;
        AppMethodBeat.i(21932);
        long currentTimeMillis = System.currentTimeMillis();
        byte[] aW = s.aW(str, 0, -1);
        try {
            it itVar = (it) new it().parseFrom(aW);
            Iterator<is> it = itVar.oTA.iterator();
            while (it.hasNext()) {
                is next = it.next();
                if (this.dLD && !this.ifz) {
                    synchronized (this.lock) {
                        try {
                            this.lock.wait();
                        } catch (InterruptedException e2) {
                            Log.printErrStackTrace("MicroMsg.RecoverPCServer", e2, "", new Object[0]);
                        }
                        try {
                        } catch (Throwable th) {
                            AppMethodBeat.o(21932);
                            throw th;
                        }
                    }
                }
                if (this.ifz) {
                    Log.i("MicroMsg.RecoverPCServer", "backupImp canceled");
                    AppMethodBeat.o(21932);
                    return -1;
                }
                try {
                    String str3 = (String) com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().azQ().get(2, (Object) null);
                    com.tencent.mm.plugin.messenger.foundation.a.a.i aSQ = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().aSQ();
                    String str4 = next.KHl.MTo;
                    String str5 = next.KHm.MTo;
                    if (Util.isNullOrNil(str4) || Util.isNullOrNil(str5)) {
                        Object[] objArr = new Object[2];
                        if (str4 == null) {
                            str4 = BuildConfig.COMMAND;
                        }
                        objArr[0] = str4;
                        if (str5 == null) {
                            str5 = BuildConfig.COMMAND;
                        }
                        objArr[1] = str5;
                        Log.w("MicroMsg.BackupPackMsgLogic", "recoverMsg fromUserName or toUserName is null, fromUserName[%s], toUserName[%s]", objArr);
                    } else {
                        Log.i("MicroMsg.BackupPackMsgLogic", "recoverMsg, type[%d], from[%s], to[%s]", Integer.valueOf(next.oUv), str4, str5);
                        com.tencent.mm.plugin.backup.bakoldlogic.d.c chx = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx();
                        if (chx.uin == 0) {
                            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
                            AppMethodBeat.o(21932);
                            throw bVar;
                        }
                        l lVar = chx.oQB;
                        bv aSN = com.tencent.mm.plugin.backup.bakoldlogic.d.b.chw().chx().aSN();
                        boolean z = lVar.has(str4) || str3.equals(str4);
                        if (z) {
                            str2 = str5;
                        } else {
                            str2 = str4;
                        }
                        if (next.KMW != 0) {
                            j2 = next.KMW;
                        } else {
                            j2 = ((long) next.KMO) * 1000;
                        }
                        hashSet.add(str2);
                        List<String> cfd = a.cfd();
                        if (cfd.contains(str4) || cfd.contains(str5)) {
                            Log.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: " + str4 + " " + str5);
                        } else {
                            if (next.Brn == 0 && next.Brl != 0) {
                                next.Brn = (long) next.Brl;
                            }
                            if (next.Brn != 0) {
                                if (!str3.equals(str4)) {
                                    str5 = str4;
                                }
                                ca aJ = aSQ.aJ(str5, next.Brn);
                                if (aJ.field_msgId != 0) {
                                    Log.i("MicroMsg.BackupPackMsgLogic", "recoverMsg msg exist");
                                } else {
                                    if (next.Brn != 0) {
                                        aJ.yF(next.Brn);
                                    }
                                    aJ.yH((long) next.KMV);
                                    aJ.setCreateTime(j2);
                                    aJ.setFlag(next.KMX);
                                    aJ.setType(next.oUv);
                                    as Kn = aSN.Kn(str2);
                                    if (Kn == null || Util.isNullOrNil(Kn.field_username) || !Kn.gBM()) {
                                        aJ.nv(z ? 1 : 0);
                                        aJ.Cy(str2);
                                        aJ.setStatus(z ? next.KMN : 4);
                                        if (hashMap.get(str2) == null) {
                                            hashMap.put(str2, 0);
                                        }
                                        if (!z && next.KMN == 3) {
                                            hashMap.put(str2, Integer.valueOf(Util.nullAs(hashMap.get(str2), 0) + 1));
                                        }
                                        com.tencent.mm.plugin.backup.bakoldlogic.b.j Bt = d.cgY().Bt(next.oUv);
                                        if (Bt == null) {
                                            Log.i("MicroMsg.BackupPackMsgLogic", "recoverMsg unknown type");
                                        } else {
                                            Bt.a(str3, next, aJ);
                                        }
                                    } else {
                                        Log.w("MicroMsg.BackupPackMsgLogic", "recoverMsg hit the blockList: ".concat(String.valueOf(str2)));
                                    }
                                }
                            } else {
                                Log.w("MicroMsg.BackupPackMsgLogic", "recoverMsg drop the item server id < 0");
                            }
                        }
                    }
                    this.oRG++;
                    if (this.oRG % 100 == 0) {
                        chr();
                    }
                } catch (Exception e3) {
                    Log.e("MicroMsg.RecoverPCServer", "readFromSdcard err:" + e3.toString());
                    Log.printErrStackTrace("MicroMsg.RecoverPCServer", e3, "", new Object[0]);
                }
                com.tencent.mm.plugin.backup.c.e.Bd(next.oUv);
                long nowMilliSecond = Util.nowMilliSecond();
                if (nowMilliSecond - cVar.hwQ > 10000) {
                    cVar.end();
                    cVar.begin();
                    cVar.hwQ = nowMilliSecond;
                }
            }
            com.tencent.mm.plugin.backup.c.e.cfo();
            Log.d("MicroMsg.RecoverPCServer", "read item time " + (System.currentTimeMillis() - currentTimeMillis));
            int size = itVar.oTA.size();
            AppMethodBeat.o(21932);
            return size;
        } catch (Exception e4) {
            Object[] objArr2 = new Object[3];
            objArr2[0] = str;
            objArr2[1] = e4;
            objArr2[2] = Integer.valueOf(aW == null ? 0 : aW.length);
            Log.e("MicroMsg.RecoverPCServer", "read mmPath errr %s, %s, len:%d", objArr2);
            Log.printErrStackTrace("MicroMsg.RecoverPCServer", e4, "", new Object[0]);
            AppMethodBeat.o(21932);
            return 0;
        }
    }

    public final void chr() {
        AppMethodBeat.i(21933);
        System.gc();
        long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
        long j2 = Runtime.getRuntime().totalMemory() / 1000;
        Log.i("MicroMsg.RecoverPCServer", "memoryInfo avail/total, dalvik[%dk, %dk, user:%dk], recoverCnt:%d", Long.valueOf(freeMemory), Long.valueOf(j2), Long.valueOf(j2 - freeMemory), Integer.valueOf(this.oRG));
        AppMethodBeat.o(21933);
    }

    @Override // com.tencent.mm.ak.j
    public final void a(int i2, int i3, q qVar) {
        AppMethodBeat.i(21934);
        this.oSf += (long) i2;
        int i4 = this.oSe == 0 ? 0 : (int) ((this.oSf * 100) / this.oSe);
        if (i4 > this.oSg) {
            this.oSg = i4;
            com.tencent.mm.plugin.backup.bakoldlogic.c.d.setProgress(this.oSg);
        }
        if (this.dLD || this.ifz || this.oRA == null || this.oSg < 0 || this.oSg > 100) {
            Log.d("MicroMsg.RecoverPCServer", "failed to call operatorCallback.onNetProgress:%d", Integer.valueOf(this.oSg));
            AppMethodBeat.o(21934);
            return;
        }
        this.oRA.By(this.oSg);
        AppMethodBeat.o(21934);
    }

    static /* synthetic */ void a(f fVar) {
        AppMethodBeat.i(21935);
        s.dy(a.cgW(), true);
        fVar.oRB = new i() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.AnonymousClass3 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(21921);
                com.tencent.mm.plugin.backup.bakoldlogic.c.d dVar = (com.tencent.mm.plugin.backup.bakoldlogic.c.d) qVar;
                Log.i("MicroMsg.RecoverPCServer", "onSceneEnd %s, %d, %d", dVar.id, Integer.valueOf(i2), Integer.valueOf(i3));
                synchronized (f.this.lock) {
                    try {
                        f.this.oRz.remove(dVar.id);
                        Log.i("MicroMsg.RecoverPCServer", "onSceneEnd left: size:%d", Integer.valueOf(f.this.oRz.size()));
                        if (f.this.oRz.size() <= 10) {
                            f.this.lock.notifyAll();
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(21921);
                        throw th;
                    }
                }
                f.this.oRG++;
                if (f.this.oRG % 300 == 0) {
                    f.this.chr();
                }
                f.this.chq();
                AppMethodBeat.o(21921);
            }
        };
        b.a(7, fVar.oRB);
        for (t tVar : fVar.oSb) {
            if (fVar.dLD && !fVar.ifz) {
                Log.i("MicroMsg.RecoverPCServer", "hit pause");
                synchronized (fVar.lock) {
                    try {
                        fVar.lock.wait();
                    } catch (InterruptedException e2) {
                        Log.printErrStackTrace("MicroMsg.RecoverPCServer", e2, "", new Object[0]);
                    }
                    try {
                    } catch (Throwable th) {
                        AppMethodBeat.o(21935);
                        throw th;
                    }
                }
            }
            if (fVar.ifz) {
                Log.i("MicroMsg.RecoverPCServer", "backupImp canceled");
                AppMethodBeat.o(21935);
                return;
            }
            com.tencent.mm.plugin.backup.bakoldlogic.c.d dVar = new com.tencent.mm.plugin.backup.bakoldlogic.c.d(a.cgW(), tVar.ID, 2, tVar.oUq, fVar, a.cgZ().oJa);
            synchronized (fVar.lock) {
                try {
                    dVar.cgA();
                    fVar.oRz.add(tVar.ID);
                    Log.i("MicroMsg.RecoverPCServer", "media recoverImp now: size:%d", Integer.valueOf(fVar.oRz.size()));
                    if (fVar.oRz.size() > 10) {
                        try {
                            fVar.lock.wait();
                        } catch (InterruptedException e3) {
                            Log.printErrStackTrace("MicroMsg.RecoverPCServer", e3, "", new Object[0]);
                        }
                    }
                } catch (Throwable th2) {
                    AppMethodBeat.o(21935);
                    throw th2;
                }
            }
        }
        for (t tVar2 : fVar.oSa) {
            if (fVar.dLD && !fVar.ifz) {
                Log.i("MicroMsg.RecoverPCServer", "hit pause");
                synchronized (fVar.lock) {
                    try {
                        fVar.lock.wait();
                    } catch (InterruptedException e4) {
                        Log.printErrStackTrace("MicroMsg.RecoverPCServer", e4, "", new Object[0]);
                    }
                    try {
                    } catch (Throwable th3) {
                        AppMethodBeat.o(21935);
                        throw th3;
                    }
                }
            }
            if (fVar.ifz) {
                Log.i("MicroMsg.RecoverPCServer", "backupImp canceled");
                AppMethodBeat.o(21935);
                return;
            }
            com.tencent.mm.plugin.backup.bakoldlogic.c.d dVar2 = new com.tencent.mm.plugin.backup.bakoldlogic.c.d(a.cgW(), tVar2.ID, 1, tVar2.oUq, fVar, a.cgZ().oJa);
            synchronized (fVar.lock) {
                try {
                    dVar2.cgA();
                    fVar.oRz.add(tVar2.ID);
                    Log.i("MicroMsg.RecoverPCServer", "digest recoverImp now: size:%d", Integer.valueOf(fVar.oRz.size()));
                    if (fVar.oRz.size() > 10) {
                        try {
                            fVar.lock.wait();
                        } catch (InterruptedException e5) {
                            Log.printErrStackTrace("MicroMsg.RecoverPCServer", e5, "", new Object[0]);
                        }
                    }
                } catch (Throwable th4) {
                    AppMethodBeat.o(21935);
                    throw th4;
                }
            }
        }
        fVar.oRC = true;
        Log.i("MicroMsg.RecoverPCServer", "send RestoreData req finish");
        fVar.chq();
        AppMethodBeat.o(21935);
    }
}
