package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.protocal.protobuf.amh;
import com.tencent.mm.protocal.protobuf.cki;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.vk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;

public final class u {
    public static final u HtN = new u();
    private static final String HtO = (fMX() + "/save/");
    private static final String HtP = (fMX() + "/fetch/");
    private long HtA;
    private List<Bankcard> HtB;
    private List<Bankcard> HtC;
    private ReentrantLock HtD = new ReentrantLock();
    public String HtE;
    public String HtF;
    public String HtG;
    public int HtH;
    public String HtI;
    public String HtJ;
    public String HtK;
    public amh HtL;
    public Vector<a> HtM = new Vector<>();
    public cki Htx;
    public cki Hty;
    private long Htz;

    public interface a {
        void xK(boolean z);
    }

    public u() {
        AppMethodBeat.i(68461);
        AppMethodBeat.o(68461);
    }

    static {
        AppMethodBeat.i(68473);
        AppMethodBeat.o(68473);
    }

    public final void a(cki cki, final boolean z, boolean z2) {
        AppMethodBeat.i(213851);
        if (z2) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.wallet.balance.model.lqt.u.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(68459);
                    Iterator it = u.this.HtM.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).xK(true);
                    }
                    AppMethodBeat.o(68459);
                }
            });
            AppMethodBeat.o(213851);
            return;
        }
        if (cki != null) {
            this.HtD.lock();
            if (z) {
                this.Htx = cki;
                this.HtB = null;
                this.Htz = System.currentTimeMillis();
            } else {
                this.Hty = cki;
                this.HtC = null;
                this.HtA = System.currentTimeMillis();
            }
            this.HtD.unlock();
            Log.i("MicroMsg.LqtBindQueryInfoCache", "setCache: %s, save: %s", cki, Boolean.valueOf(z));
            try {
                final byte[] byteArray = cki.toByteArray();
                ThreadPool.post(new Runnable() {
                    /* class com.tencent.mm.plugin.wallet.balance.model.lqt.u.AnonymousClass3 */

                    public final void run() {
                        String str;
                        AppMethodBeat.i(213850);
                        if (byteArray != null) {
                            u.this.HtD.lock();
                            if (z) {
                                if (s.YS(u.HtO)) {
                                    s.dy(u.HtO, true);
                                }
                                s.boN(u.HtO);
                                u.this.HtB = null;
                            } else {
                                if (s.YS(u.HtP)) {
                                    s.dy(u.HtP, true);
                                }
                                s.boN(u.HtP);
                                u.this.HtC = null;
                            }
                            u.this.HtD.unlock();
                            try {
                                String sb = new StringBuilder().append(System.currentTimeMillis()).toString();
                                Object[] objArr = new Object[3];
                                objArr[0] = z ? u.HtO : u.HtP;
                                objArr[1] = sb;
                                objArr[2] = Boolean.valueOf(z);
                                Log.i("MicroMsg.LqtBindQueryInfoCache", "saveCacheToDisk, dir: %s, name: %s, save: %s", objArr);
                                long currentTicks = Util.currentTicks();
                                StringBuilder sb2 = new StringBuilder();
                                if (z) {
                                    str = u.HtO;
                                } else {
                                    str = u.HtP;
                                }
                                String sb3 = sb2.append(str).append(sb).toString();
                                byte[] bArr = byteArray;
                                s.f(sb3, bArr, bArr.length);
                                Log.i("MicroMsg.LqtBindQueryInfoCache", "finish saveCacheToDisk, used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
                                AppMethodBeat.o(213850);
                                return;
                            } catch (Exception e2) {
                                Log.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", e2, "saveCacheToDisk error: %s", e2.getMessage());
                            }
                        }
                        AppMethodBeat.o(213850);
                    }
                }, "LqtBindQueryInfoCache_saveCacheToDiski");
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", e2, "saveCacheToDisk error: %s", e2.getMessage());
            }
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.wallet.balance.model.lqt.u.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(68460);
                    Iterator it = u.this.HtM.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).xK(false);
                    }
                    AppMethodBeat.o(68460);
                }
            });
        }
        AppMethodBeat.o(213851);
    }

    public final void a(cuv cuv) {
        this.HtE = cuv.HtE;
        this.HtF = cuv.HtF;
        this.HtG = cuv.HtG;
        this.HtH = cuv.HtH;
        this.HtI = cuv.HtI;
        this.HtJ = cuv.MAc;
        this.HtL = cuv.MAd;
    }

    public final Bankcard xE(boolean z) {
        List<Bankcard> xH;
        AppMethodBeat.i(68463);
        xI(z);
        cki cki = z ? this.Htx : this.Hty;
        if (cki != null && !Util.isNullOrNil(cki.MpG) && (xH = xH(z)) != null && xH.size() > 0) {
            String str = cki.MpG;
            if (!Util.isNullOrNil(str)) {
                for (Bankcard bankcard : xH) {
                    if (bankcard != null && str.equals(bankcard.field_bindSerial)) {
                        AppMethodBeat.o(68463);
                        return bankcard;
                    }
                }
            }
        }
        AppMethodBeat.o(68463);
        return null;
    }

    public final Bankcard fMU() {
        AppMethodBeat.i(68464);
        xI(true);
        cki cki = this.Htx;
        if (cki != null) {
            Bankcard a2 = ai.a(cki.MpI);
            AppMethodBeat.o(68464);
            return a2;
        }
        AppMethodBeat.o(68464);
        return null;
    }

    public final cki xF(boolean z) {
        AppMethodBeat.i(213852);
        xI(z);
        if (z) {
            cki cki = this.Htx;
            AppMethodBeat.o(213852);
            return cki;
        }
        cki cki2 = this.Hty;
        AppMethodBeat.o(213852);
        return cki2;
    }

    public final List<Bankcard> xG(boolean z) {
        AppMethodBeat.i(68465);
        xI(z);
        if ((z ? this.Htx : this.Hty) != null) {
            List<Bankcard> xH = xH(z);
            AppMethodBeat.o(68465);
            return xH;
        }
        AppMethodBeat.o(68465);
        return null;
    }

    public final String fMV() {
        AppMethodBeat.i(68466);
        xI(true);
        cki cki = this.Htx;
        if (cki != null) {
            String str = cki.MpM;
            AppMethodBeat.o(68466);
            return str;
        }
        AppMethodBeat.o(68466);
        return "";
    }

    public final int fMW() {
        AppMethodBeat.i(68467);
        xI(true);
        cki cki = this.Htx;
        if (cki != null) {
            int i2 = cki.MpN;
            AppMethodBeat.o(68467);
            return i2;
        }
        AppMethodBeat.o(68467);
        return 0;
    }

    public static List<Bankcard> aem(int i2) {
        AppMethodBeat.i(68468);
        List<Bankcard> xG = HtN.xG(i2 == 1);
        if (xG == null || xG.size() == 0) {
            com.tencent.mm.plugin.wallet.a.s.fOg();
            xG = com.tencent.mm.plugin.wallet.a.s.fOh().fRJ();
        }
        LinkedList linkedList = new LinkedList();
        if (xG != null) {
            for (Bankcard bankcard : xG) {
                if (bankcard.fQb()) {
                    com.tencent.mm.plugin.wallet.a.s.fOg();
                    if (!com.tencent.mm.plugin.wallet.a.s.fOh().fRm()) {
                        linkedList.add(bankcard);
                    }
                }
                if (i2 == 1 && (bankcard.field_support_lqt_turn_in == 1 || bankcard.fQb())) {
                    linkedList.add(bankcard);
                }
                if (i2 == 2 && (bankcard.field_support_lqt_turn_out == 1 || bankcard.fQb())) {
                    linkedList.add(bankcard);
                }
            }
        }
        AppMethodBeat.o(68468);
        return linkedList;
    }

    private List<Bankcard> xH(boolean z) {
        Bankcard a2;
        Bankcard a3;
        AppMethodBeat.i(68469);
        cki cki = z ? this.Htx : this.Hty;
        try {
            this.HtD.lock();
            if (cki == null) {
                if (z) {
                    this.HtB = null;
                } else {
                    this.HtC = null;
                }
                return null;
            }
            if (z) {
                if (this.HtB != null && this.HtB.size() > 0) {
                    List<Bankcard> list = this.HtB;
                    this.HtD.unlock();
                    AppMethodBeat.o(68469);
                    return list;
                }
            } else if (this.HtC != null && this.HtC.size() > 0) {
                List<Bankcard> list2 = this.HtC;
                this.HtD.unlock();
                AppMethodBeat.o(68469);
                return list2;
            }
            if (z) {
                this.HtB = new ArrayList();
                if (!(this.Htx.MpI == null || (a3 = ai.a(this.Htx.MpI)) == null)) {
                    this.HtB.add(a3);
                }
                if (this.Htx.LSL != null && this.Htx.LSL.size() > 0) {
                    Iterator<vk> it = this.Htx.LSL.iterator();
                    while (it.hasNext()) {
                        Bankcard a4 = d.a(it.next());
                        if (a4 != null) {
                            this.HtB.add(a4);
                        }
                    }
                }
                List<Bankcard> list3 = this.HtB;
                this.HtD.unlock();
                AppMethodBeat.o(68469);
                return list3;
            }
            this.HtC = new ArrayList();
            if (!(this.Hty.MpI == null || (a2 = ai.a(this.Hty.MpI)) == null)) {
                this.HtC.add(a2);
            }
            if (this.Hty.LSL != null && this.Hty.LSL.size() > 0) {
                Iterator<vk> it2 = this.Hty.LSL.iterator();
                while (it2.hasNext()) {
                    Bankcard a5 = d.a(it2.next());
                    if (a5 != null) {
                        this.HtC.add(a5);
                    }
                }
            }
            List<Bankcard> list4 = this.HtC;
            this.HtD.unlock();
            AppMethodBeat.o(68469);
            return list4;
        } finally {
            this.HtD.unlock();
            AppMethodBeat.o(68469);
        }
    }

    public final void xI(boolean z) {
        AppMethodBeat.i(68470);
        long currentTimeMillis = System.currentTimeMillis();
        cki cki = z ? this.Htx : this.Hty;
        long j2 = z ? this.Htz : this.HtA;
        if (cki != null || !z) {
            if (currentTimeMillis - j2 > Util.MILLSECONDS_OF_HOUR) {
                Log.i("MicroMsg.LqtBindQueryInfoCache", "checkCache, saveCache time exceed, try reload from disk");
            }
            AppMethodBeat.o(68470);
            return;
        }
        xJ(z);
        AppMethodBeat.o(68470);
    }

    private static String fMX() {
        AppMethodBeat.i(68471);
        String str = b.aKJ() + "wallet/lqt/";
        AppMethodBeat.o(68471);
        return str;
    }

    private void xJ(boolean z) {
        AppMethodBeat.i(68472);
        String str = z ? HtO : HtP;
        Iterable<e> dC = s.dC(str, false);
        if (dC == null) {
            AppMethodBeat.o(68472);
            return;
        }
        Log.i("MicroMsg.LqtBindQueryInfoCache", "tryLoadCacheFromDisk: %s, save: %s", dC, Boolean.valueOf(z));
        long currentTimeMillis = System.currentTimeMillis();
        for (e eVar : dC) {
            String str2 = eVar.name;
            String str3 = str + str2;
            long j2 = Util.getLong(str2, 0);
            Log.i("MicroMsg.LqtBindQueryInfoCache", "file name: %s", Long.valueOf(j2));
            if (j2 <= 0) {
                s.deleteFile(str3);
            } else if (currentTimeMillis - j2 < Util.MILLSECONDS_OF_HOUR) {
                byte[] aW = s.aW(str3, 0, -1);
                cki cki = new cki();
                try {
                    cki.parseFrom(aW);
                } catch (IOException e2) {
                    cki = null;
                    Log.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", e2, "parse bindquery from cache error: %s", e2.getMessage());
                }
                if (cki != null) {
                    this.HtD.lock();
                    if (z) {
                        this.Htx = cki;
                        this.HtB = null;
                        this.Htz = j2;
                    } else {
                        this.Hty = cki;
                        this.HtC = null;
                        this.HtA = j2;
                    }
                    this.HtD.unlock();
                    Log.i("MicroMsg.LqtBindQueryInfoCache", "succ get saveCache: %s %s", cki, Long.valueOf(j2));
                    AppMethodBeat.o(68472);
                    return;
                }
            } else {
                s.deleteFile(str3);
            }
        }
        AppMethodBeat.o(68472);
    }
}
