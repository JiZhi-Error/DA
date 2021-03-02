package com.tencent.mm.av;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class p {
    private static p iZI;
    ConcurrentHashMap<Long, d> iZG = new ConcurrentHashMap<>();
    public c iZH = new c();
    public ConcurrentHashMap<Long, e> iZJ = new ConcurrentHashMap<>();
    private ArrayList<Long> iZK = new ArrayList<>();
    ArrayList<e> iZL = new ArrayList<>();

    public static class d {
        public long offset;
        public long total;
    }

    public p() {
        AppMethodBeat.i(150733);
        AppMethodBeat.o(150733);
    }

    public static p bcF() {
        AppMethodBeat.i(150734);
        if (iZI == null) {
            synchronized (p.class) {
                try {
                    if (iZI == null) {
                        iZI = new p();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(150734);
                    throw th;
                }
            }
        }
        p pVar = iZI;
        AppMethodBeat.o(150734);
        return pVar;
    }

    public static class e {
        String dJw;
        int dQd;
        int iXp;
        String iZX;
        String iZY;
        String iZZ;
        long jaa;
        PString jab;
        PInt jac;
        PInt jad;
        com.tencent.mm.b.b jae;
        com.tencent.mm.b.b jaf;
        a jag;
        long msgId;
        int source;

        public static e a(String str, int i2, int i3, int i4, String str2, String str3, PString pString, PInt pInt, PInt pInt2, com.tencent.mm.b.b bVar, com.tencent.mm.b.b bVar2) {
            AppMethodBeat.i(150732);
            e eVar = new e();
            eVar.iZX = str;
            eVar.iXp = i2;
            eVar.source = i3;
            eVar.dQd = i4;
            eVar.iZY = str2;
            eVar.jab = pString;
            eVar.jad = pInt2;
            eVar.jac = pInt;
            eVar.iZZ = str3;
            eVar.jaf = bVar2;
            eVar.jae = bVar;
            if (p.iZI.bcG()) {
                a.a(eVar);
            }
            AppMethodBeat.o(150732);
            return eVar;
        }
    }

    public final ArrayList<String> OJ(String str) {
        AppMethodBeat.i(150735);
        ArrayList<String> arrayList = new ArrayList<>();
        if (!Util.isNullOrNil(str)) {
            for (e eVar : this.iZJ.values()) {
                if (str.equals(eVar.dJw)) {
                    arrayList.add(eVar.iZX);
                }
            }
        }
        AppMethodBeat.o(150735);
        return arrayList;
    }

    public final ArrayList<Integer> OK(String str) {
        AppMethodBeat.i(150736);
        Collection<e> values = this.iZJ.values();
        for (e eVar : values) {
            PString pString = new PString();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            eVar.jaa = q.bcR().a(eVar.dJw, eVar.iZX, eVar.iXp, eVar.source, eVar.dQd, pString, pInt, pInt2, eVar.iZY, eVar.iZZ, eVar.msgId, eVar.jae, eVar.jaf, eVar.jag, -1);
            ca Hb = ((l) g.af(l.class)).eiy().Hb(eVar.msgId);
            if (Util.isNullOrNil(Hb.field_imgPath)) {
                Hb.Cz(pString.value);
                Hb.nG(pInt.value);
                Hb.nH(pInt2.value);
                ((l) g.af(l.class)).eiy().a(eVar.msgId, Hb);
            }
        }
        if (!Util.isNullOrNil(str)) {
            for (e eVar2 : values) {
                if (!str.equals(eVar2.dJw)) {
                    this.iZJ.remove(Long.valueOf(eVar2.msgId));
                    this.iZK.remove(Long.valueOf(eVar2.msgId));
                    Log.e("MicroMsg.SendImgSpeeder", "fatal!! Send user mis-match, want:%s, fact:%s", str, eVar2.dJw);
                }
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < this.iZK.size(); i2++) {
            arrayList.add(Integer.valueOf((int) this.iZJ.get(this.iZK.get(i2)).jaa));
        }
        this.iZJ.clear();
        this.iZK.clear();
        Log.i("MicroMsg.SendImgSpeeder", "syncImgData, id size %d", Integer.valueOf(arrayList.size()));
        AppMethodBeat.o(150736);
        return arrayList;
    }

    public final boolean AA(long j2) {
        AppMethodBeat.i(150737);
        boolean containsKey = this.iZG.containsKey(Long.valueOf(j2));
        AppMethodBeat.o(150737);
        return containsKey;
    }

    public final d AB(long j2) {
        AppMethodBeat.i(150738);
        d dVar = this.iZG.get(Long.valueOf(j2));
        AppMethodBeat.o(150738);
        return dVar;
    }

    public final void a(ArrayList<String> arrayList, boolean z, int i2, int i3, String str) {
        AppMethodBeat.i(150739);
        Log.i("MicroMsg.SendImgSpeeder", "summersafecdn sendThumbImg fileSize:%d, compressImg[%b], source[%d], user:%s", Integer.valueOf(arrayList.size()), Boolean.valueOf(z), Integer.valueOf(i2), str);
        Iterator<e> it = this.iZL.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (!arrayList.contains(next.iZX) || ((!Util.isNullOrNil(next.dJw) && !next.dJw.equalsIgnoreCase(str)) || (!Util.isNullOrNil(str) && !str.equalsIgnoreCase(next.dJw)))) {
                it.remove();
            } else {
                next.iXp = g(next.iZX, str, z);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String next2 = it2.next();
            Iterator<e> it3 = this.iZL.iterator();
            while (it3.hasNext()) {
                e next3 = it3.next();
                if (next3.iZX.equals(next2)) {
                    arrayList2.add(next3);
                }
            }
        }
        this.iZL.clear();
        this.iZL.addAll(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        if (arrayList.size() == 9) {
            com.tencent.mm.plugin.report.service.g.Wl(18);
        } else if (arrayList.size() == 1) {
            boolean isWifi = NetStatusUtil.isWifi(MMApplicationContext.getContext());
            com.tencent.mm.plugin.report.service.g.Wl(25);
            if (isWifi) {
                if (z.f(arrayList.get(0), str, z)) {
                    com.tencent.mm.plugin.report.service.g.Wl(23);
                } else {
                    com.tencent.mm.plugin.report.service.g.Wl(21);
                }
            }
        } else {
            com.tencent.mm.plugin.report.service.g.Wl(24);
        }
        Iterator<String> it4 = arrayList.iterator();
        while (it4.hasNext()) {
            String next4 = it4.next();
            if (next4 == null || next4.equals("") || !s.YS(next4)) {
                Log.d("MicroMsg.SendImgSpeeder", " doSendImage : filePath is null or empty");
            } else if (ImgUtil.isGif(next4)) {
                Log.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add filePath:%s filesize:%d", next4, Long.valueOf(s.boW(next4)));
            } else if (!OL(next4)) {
                arrayList3.add(next4);
            }
        }
        Iterator it5 = arrayList3.iterator();
        while (it5.hasNext()) {
            a(i2, i3, (String) it5.next(), str, z);
        }
        ArrayList arrayList4 = new ArrayList();
        long beginTransaction = g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
        ((l) g.af(l.class)).eiy().aEs("SendImgSpeeder");
        boolean z2 = true;
        int i4 = 0;
        while (i4 < this.iZL.size()) {
            e eVar = this.iZL.get(i4);
            if (ImgUtil.isGif(eVar.iZX)) {
                Log.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add to msg table");
            } else {
                z2 = false;
                ca caVar = new ca();
                caVar.setType(ab.JH(str));
                caVar.Cy(str);
                caVar.nv(1);
                caVar.setStatus(1);
                caVar.Cz(eVar.jab.value);
                caVar.nG(eVar.jac.value);
                caVar.nH(eVar.jad.value);
                String ajw = br.ajw();
                if ((ajw != null && !ajw.equals(caVar.fqK)) || (ajw == null && caVar.fqK != null)) {
                    caVar.BB(ajw);
                }
                a.C0409a.anC().n(caVar);
                caVar.setCreateTime(bp.Kw(caVar.field_talker));
                arrayList4.add(caVar);
                long aC = ((l) g.af(l.class)).eiy().aC(caVar);
                if (aC <= 0) {
                    Log.e("MicroMsg.SendImgSpeeder", "insert error! %s", str);
                } else {
                    eVar.msgId = aC;
                    this.iZJ.put(Long.valueOf(eVar.msgId), eVar);
                    this.iZK.add(Long.valueOf(eVar.msgId));
                }
            }
            i4++;
            z2 = z2;
        }
        this.iZL.clear();
        if (beginTransaction > 0) {
            g.aAh().hqK.endTransaction(beginTransaction);
        }
        if (z2) {
            ((l) g.af(l.class)).eiy().aEt("SendImgSpeeder");
        }
        AppMethodBeat.o(150739);
    }

    private boolean OL(String str) {
        AppMethodBeat.i(150740);
        Iterator<e> it = this.iZL.iterator();
        while (it.hasNext()) {
            if (it.next().iZX.equals(str)) {
                AppMethodBeat.o(150740);
                return true;
            }
        }
        AppMethodBeat.o(150740);
        return false;
    }

    public final boolean bcG() {
        AppMethodBeat.i(150741);
        if (this.iZL.size() <= 0 || g.a.eOH().CyB > 2) {
            AppMethodBeat.o(150741);
            return true;
        }
        Log.i("MicroMsg.SendImgSpeeder", "cpu core is low ,do not use multi mode");
        AppMethodBeat.o(150741);
        return false;
    }

    public final void a(int i2, int i3, String str, String str2, boolean z) {
        AppMethodBeat.i(150742);
        if (OL(str)) {
            AppMethodBeat.o(150742);
            return;
        }
        int g2 = g(str, str2, z);
        PString pString = new PString();
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        com.tencent.mm.b.b bVar = null;
        com.tencent.mm.b.b bVar2 = null;
        String str3 = null;
        String str4 = null;
        if (bcG()) {
            b ts = this.iZH.ts(1);
            b ts2 = this.iZH.ts(2);
            bVar = ts.iZT;
            bVar2 = ts2.iZT;
            str3 = ts2.iZU;
            str4 = ts.iZU;
        }
        q.bcR().a(str2, str, g2, pString, pInt, pInt2, i3, R.drawable.c3h, str3);
        e a2 = e.a(str, g2, i2, i3, str3, str4, pString, pInt, pInt2, bVar, bVar2);
        a2.dJw = str2;
        this.iZL.add(a2);
        Log.i("MicroMsg.SendImgSpeeder", "summersafecdn img path %s has prebuild, user:%s", str, str2);
        AppMethodBeat.o(150742);
    }

    private static int g(String str, String str2, boolean z) {
        AppMethodBeat.i(150743);
        if (z.f(str, str2, z)) {
            AppMethodBeat.o(150743);
            return 1;
        }
        AppMethodBeat.o(150743);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public static class b {
        com.tencent.mm.b.b iZT;
        String iZU;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    public static class c {
        private LinkedList<b> iZV = new LinkedList<>();
        private LinkedList<b> iZW = new LinkedList<>();

        public c() {
            AppMethodBeat.i(150724);
            AppMethodBeat.o(150724);
        }

        private static b bcK() {
            AppMethodBeat.i(150726);
            b bVar = new b((byte) 0);
            if (Util.isNullOrNil((String) null)) {
                bVar.iZU = i.bcA();
            } else {
                bVar.iZU = null;
            }
            String OD = q.bcR().OD(bVar.iZU);
            if (!OM(OD)) {
                AppMethodBeat.o(150726);
                return null;
            }
            bVar.iZT = new com.tencent.mm.b.b(OD);
            AppMethodBeat.o(150726);
            return bVar;
        }

        private static b bcL() {
            AppMethodBeat.i(150727);
            b bVar = new b((byte) 0);
            if (Util.isNullOrNil((String) null)) {
                bVar.iZU = i.bcA();
            } else {
                bVar.iZU = null;
            }
            String OC = q.bcR().OC(bVar.iZU);
            if (!OM(OC)) {
                AppMethodBeat.o(150727);
                return null;
            }
            bVar.iZT = new com.tencent.mm.b.b(OC);
            AppMethodBeat.o(150727);
            return bVar;
        }

        private static boolean OM(String str) {
            AppMethodBeat.i(150728);
            if (s.boW(str) > 0) {
                Log.e("MicroMsg.SendImgSpeeder", "file has exist %s", str);
                AppMethodBeat.o(150728);
                return false;
            }
            AppMethodBeat.o(150728);
            return true;
        }

        public final synchronized b ts(int i2) {
            b bVar;
            AppMethodBeat.i(150729);
            bVar = null;
            if (i2 == 1) {
                if (this.iZV.size() > 0) {
                    bVar = this.iZV.remove();
                    bcM();
                } else {
                    bVar = bcK();
                }
            } else if (i2 == 2) {
                if (this.iZW.size() > 0) {
                    bVar = this.iZW.remove();
                    bcN();
                } else {
                    bVar = bcL();
                }
            }
            bcJ();
            AppMethodBeat.o(150729);
            return bVar;
        }

        private synchronized void bcM() {
            AppMethodBeat.i(150730);
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < this.iZV.size(); i2++) {
                sb.append(this.iZV.get(i2).iZU);
                if (i2 != this.iZV.size() - 1) {
                    sb.append("-");
                }
            }
            Log.d("MicroMsg.SendImgSpeeder", "sync big des to file %s ", sb.toString());
            com.tencent.mm.kernel.g.aAh().azQ().set(348176, sb.toString());
            AppMethodBeat.o(150730);
        }

        private synchronized void bcN() {
            AppMethodBeat.i(150731);
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < this.iZW.size(); i2++) {
                sb.append(this.iZW.get(i2).iZU);
                if (i2 != this.iZW.size() - 1) {
                    sb.append("-");
                }
            }
            Log.d("MicroMsg.SendImgSpeeder", "sync thumb des to file %s ", sb.toString());
            com.tencent.mm.kernel.g.aAh().azQ().set(348177, sb.toString());
            AppMethodBeat.o(150731);
        }

        public final synchronized void bcJ() {
            synchronized (this) {
                AppMethodBeat.i(150725);
                int size = this.iZV.size();
                if (size < 0) {
                    int i2 = 5 - size;
                    for (int i3 = 0; i3 < i2; i3++) {
                        this.iZV.add(bcK());
                    }
                    Log.i("MicroMsg.SendImgSpeeder", "add big File pool added size %d , all size %d", Integer.valueOf(i2), Integer.valueOf(this.iZV.size()));
                    bcM();
                }
                int size2 = this.iZW.size();
                if (size2 < 0) {
                    int i4 = 5 - size2;
                    for (int i5 = 0; i5 < i4; i5++) {
                        this.iZW.add(bcL());
                    }
                    bcN();
                    Log.i("MicroMsg.SendImgSpeeder", "add big thumb pool added size %d , all size %d", Integer.valueOf(i4), Integer.valueOf(this.iZW.size()));
                }
                AppMethodBeat.o(150725);
            }
        }
    }

    public static class a {
        static MMHandler dgG;
        private ReentrantLock dgE = new ReentrantLock();
        private Condition dgF = this.dgE.newCondition();
        int iXp;
        C0275a iZM;

        /* renamed from: com.tencent.mm.av.p$a$a  reason: collision with other inner class name */
        public static class C0275a {
            String iXy;
            PString iZP;
            PString iZQ;
            PString iZR;
            PString iZS;
        }

        public a() {
            AppMethodBeat.i(150721);
            AppMethodBeat.o(150721);
        }

        public static a a(final e eVar) {
            AppMethodBeat.i(150722);
            synchronized (a.class) {
                try {
                    if (dgG == null) {
                        dgG = new MMHandler("big file gen Worker");
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(150722);
                    throw th;
                }
            }
            a aVar = new a();
            eVar.jag = aVar;
            dgG.post(new Runnable() {
                /* class com.tencent.mm.av.p.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(150720);
                    Long valueOf = Long.valueOf(System.currentTimeMillis());
                    C0275a aVar = new C0275a();
                    aVar.iZP = new PString();
                    aVar.iZQ = new PString();
                    aVar.iZR = new PString();
                    aVar.iZS = new PString();
                    aVar.iXy = q.bcR().a(eVar.dJw, eVar.iZX, h.Ow(eVar.iZX), eVar.iXp, true, aVar.iZP, aVar.iZQ, aVar.iZR, aVar.iZS, eVar.iZZ, eVar.jae, -1);
                    a.this.dgE.lock();
                    try {
                        a.this.iZM = aVar;
                        a.this.dgF.signal();
                        Log.i("MicroMsg.SendImgSpeeder", "notify big file gen prepared %s last %d", eVar.iZX, Long.valueOf(System.currentTimeMillis() - valueOf.longValue()));
                    } finally {
                        a.this.dgE.unlock();
                        AppMethodBeat.o(150720);
                    }
                }
            });
            aVar.iXp = eVar.iXp;
            AppMethodBeat.o(150722);
            return aVar;
        }

        public final C0275a bcI() {
            AppMethodBeat.i(150723);
            this.dgE.lock();
            while (this.iZM == null) {
                try {
                    Log.i("MicroMsg.SendImgSpeeder", "getResult await");
                    this.dgF.await();
                } catch (Exception e2) {
                    this.dgE.unlock();
                } catch (Throwable th) {
                    this.dgE.unlock();
                    AppMethodBeat.o(150723);
                    throw th;
                }
            }
            this.dgE.unlock();
            C0275a aVar = this.iZM;
            AppMethodBeat.o(150723);
            return aVar;
        }
    }
}
