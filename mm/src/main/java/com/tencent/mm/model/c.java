package com.tencent.mm.model;

import android.content.SharedPreferences;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b.d;
import com.tencent.mm.model.bp;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.cf;
import com.tencent.mm.storage.i;
import com.tencent.mm.storage.k;
import com.tencent.mm.storage.m;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.w;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class c {
    public static HashMap<Integer, h.b> baseDBFactories;
    public cb iBo;
    public ca iBp;
    com.tencent.mm.storage.h iBq;
    i iBr;
    com.tencent.mm.model.b.c iBs;
    d iBt;
    k iBu;
    o iBv;
    m iBw;
    com.tencent.mm.model.b.b iBx;

    public interface a {
        void fo(boolean z);
    }

    public c() {
        AppMethodBeat.i(20248);
        g.aAi();
        e aAh = g.aAh();
        aAh.hqD.add(new h.a() {
            /* class com.tencent.mm.model.c.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.a
            public final void azX() {
                com.tencent.mm.modelstat.m bgo;
                AppMethodBeat.i(20242);
                g.aAi();
                if (g.aAc() && (bgo = q.bgo()) != null) {
                    Log.i("MicroMsg.AccountStorage", "summer preCloseCallback netStatStg: ".concat(String.valueOf(bgo)));
                    long currentTimeMillis = System.currentTimeMillis();
                    bgo.joS.appendAll(true);
                    Log.i("MicroMsg.NetStat", "summer net appendAllToDisk end takes: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                }
                AppMethodBeat.o(20242);
            }

            @Override // com.tencent.mm.storagebase.h.a
            public final void azY() {
            }

            @Override // com.tencent.mm.storagebase.h.a
            public final void azZ() {
            }
        });
        com.tencent.mm.kernel.a.c.aAu().add(new com.tencent.mm.kernel.api.b() {
            /* class com.tencent.mm.model.c.AnonymousClass3 */

            @Override // com.tencent.mm.kernel.api.b
            public final List<String> aAo() {
                AppMethodBeat.i(20243);
                LinkedList linkedList = new LinkedList();
                Collections.addAll(linkedList, "image/shakeTranImg/", "emoji/", "mailapp/", "favoffline/", "voice2/", "video/", "attachment/");
                AppMethodBeat.o(20243);
                return linkedList;
            }
        });
        com.tencent.mm.kernel.a.c.aAu().add(new f() {
            /* class com.tencent.mm.model.c.AnonymousClass4 */

            @Override // com.tencent.mm.kernel.api.f
            public final void aAp() {
                AppMethodBeat.i(20244);
                bg.aVE();
                AppMethodBeat.o(20244);
            }

            @Override // com.tencent.mm.kernel.api.f
            public final void FU(String str) {
                AppMethodBeat.i(20245);
                if (com.tencent.mm.compatible.util.e.apn()) {
                    g.aAi();
                    if (g.aAh().hqF.equals(com.tencent.mm.loader.j.b.aKJ())) {
                        g.aAi();
                        ThreadPool.post(new b(g.aAh().cachePath, str), "AccountStorage_moveDataFiles");
                    }
                }
                AppMethodBeat.o(20245);
            }
        });
        AppMethodBeat.o(20248);
    }

    public static int getUin() {
        AppMethodBeat.i(20249);
        g.aAi();
        g.aAf();
        int uin = com.tencent.mm.kernel.a.getUin();
        AppMethodBeat.o(20249);
        return uin;
    }

    public static String aSJ() {
        AppMethodBeat.i(20250);
        g.aAi();
        String str = g.aAh().hqF;
        AppMethodBeat.o(20250);
        return str;
    }

    public static void azS() {
        AppMethodBeat.i(20251);
        g.aAi();
        g.aAh().azS();
        AppMethodBeat.o(20251);
    }

    public static boolean isSDCardAvailable() {
        AppMethodBeat.i(20252);
        g.aAi();
        boolean isSDCardAvailable = g.aAh().isSDCardAvailable();
        AppMethodBeat.o(20252);
        return isSDCardAvailable;
    }

    public static String azL() {
        AppMethodBeat.i(20253);
        g.aAi();
        String azL = g.aAh().azL();
        AppMethodBeat.o(20253);
        return azL;
    }

    public static void closeDB() {
        AppMethodBeat.i(20254);
        g.aAi();
        g.aAh().CL(null);
        AppMethodBeat.o(20254);
    }

    public static void a(bc bcVar) {
        AppMethodBeat.i(20255);
        g.aAi();
        g.aAf().a(bcVar);
        AppMethodBeat.o(20255);
    }

    public static void b(bc bcVar) {
        AppMethodBeat.i(20256);
        g.aAi();
        g.aAf().b(bcVar);
        AppMethodBeat.o(20256);
    }

    public static void azl() {
        AppMethodBeat.i(20257);
        g.aAi();
        g.aAf().azl();
        AppMethodBeat.o(20257);
    }

    public static boolean azn() {
        AppMethodBeat.i(20258);
        g.aAi();
        boolean qd = com.tencent.mm.kernel.a.qd(g.aAf().hpS);
        AppMethodBeat.o(20258);
        return qd;
    }

    public static int aSK() {
        AppMethodBeat.i(20259);
        g.aAi();
        int i2 = g.aAf().hpT;
        AppMethodBeat.o(20259);
        return i2;
    }

    public static h getDataDB() {
        AppMethodBeat.i(20260);
        g.aAi();
        h hVar = g.aAh().hqK;
        AppMethodBeat.o(20260);
        return hVar;
    }

    public static h aSL() {
        AppMethodBeat.i(20261);
        g.aAi();
        h hVar = g.aAh().hqL;
        AppMethodBeat.o(20261);
        return hVar;
    }

    public static SharedPreferences FQ(String str) {
        AppMethodBeat.i(20262);
        g.aAi();
        SharedPreferences FQ = g.aAh().FQ(str);
        AppMethodBeat.o(20262);
        return FQ;
    }

    public static ao azQ() {
        AppMethodBeat.i(20263);
        g.aAi();
        ao azQ = g.aAh().azQ();
        AppMethodBeat.o(20263);
        return azQ;
    }

    public static j aSM() {
        AppMethodBeat.i(20264);
        j aSM = ((l) g.af(l.class)).aSM();
        AppMethodBeat.o(20264);
        return aSM;
    }

    public static bv aSN() {
        AppMethodBeat.i(20265);
        bv aSN = ((l) g.af(l.class)).aSN();
        AppMethodBeat.o(20265);
        return aSN;
    }

    public static n aSO() {
        AppMethodBeat.i(20266);
        n aSO = ((l) g.af(l.class)).aSO();
        AppMethodBeat.o(20266);
        return aSO;
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.f aSP() {
        AppMethodBeat.i(231535);
        com.tencent.mm.plugin.messenger.foundation.a.a.f aSP = ((l) g.af(l.class)).aSP();
        AppMethodBeat.o(231535);
        return aSP;
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.i aSQ() {
        AppMethodBeat.i(20267);
        com.tencent.mm.plugin.messenger.foundation.a.a.i eiy = ((l) g.af(l.class)).eiy();
        AppMethodBeat.o(20267);
        return eiy;
    }

    public static t aSR() {
        AppMethodBeat.i(20268);
        t aSR = ((com.tencent.mm.al.q) g.af(com.tencent.mm.al.q.class)).aSR();
        AppMethodBeat.o(20268);
        return aSR;
    }

    public static u aSS() {
        AppMethodBeat.i(20269);
        u aSS = ((com.tencent.mm.al.q) g.af(com.tencent.mm.al.q.class)).aSS();
        AppMethodBeat.o(20269);
        return aSS;
    }

    public static bw aST() {
        AppMethodBeat.i(20270);
        bw aST = ((l) g.af(l.class)).aST();
        AppMethodBeat.o(20270);
        return aST;
    }

    public static com.tencent.mm.plugin.downloader.g.b aSU() {
        AppMethodBeat.i(20271);
        com.tencent.mm.plugin.downloader.g.b aSU = ((com.tencent.mm.plugin.downloader.a.d) g.af(com.tencent.mm.plugin.downloader.a.d.class)).aSU();
        AppMethodBeat.o(20271);
        return aSU;
    }

    public static bz aSV() {
        AppMethodBeat.i(20272);
        bz aSV = ((com.tencent.mm.plugin.m.a.a) g.af(com.tencent.mm.plugin.m.a.a.class)).aSV();
        AppMethodBeat.o(20272);
        return aSV;
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.l aSW() {
        AppMethodBeat.i(20273);
        com.tencent.mm.plugin.messenger.foundation.a.a.l aSW = ((l) g.af(l.class)).aSW();
        AppMethodBeat.o(20273);
        return aSW;
    }

    public static ap aSX() {
        AppMethodBeat.i(20274);
        g.aAi();
        g.aAf().azk();
        ap aSX = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX();
        AppMethodBeat.o(20274);
        return aSX;
    }

    public static String aSY() {
        AppMethodBeat.i(20275);
        String aSY = com.tencent.mm.plugin.image.d.aSY();
        AppMethodBeat.o(20275);
        return aSY;
    }

    public static String aSZ() {
        AppMethodBeat.i(20276);
        String aSZ = com.tencent.mm.plugin.image.d.aSZ();
        AppMethodBeat.o(20276);
        return aSZ;
    }

    public static String aTa() {
        AppMethodBeat.i(20277);
        String aTa = s.aTa();
        AppMethodBeat.o(20277);
        return aTa;
    }

    public static String aTb() {
        AppMethodBeat.i(20278);
        String aTb = com.tencent.mm.plugin.record.b.aTb();
        AppMethodBeat.o(20278);
        return aTb;
    }

    public static String aTc() {
        AppMethodBeat.i(20279);
        String aTc = ap.aTc();
        AppMethodBeat.o(20279);
        return aTc;
    }

    public static String aTd() {
        AppMethodBeat.i(20280);
        StringBuilder sb = new StringBuilder();
        g.aAi();
        String sb2 = sb.append(g.aAh().hqG).append("emoji/").toString();
        AppMethodBeat.o(20280);
        return sb2;
    }

    public static String getAccVideoPath() {
        AppMethodBeat.i(20281);
        com.tencent.mm.modelvideo.o.bhi();
        String accVideoPath = com.tencent.mm.modelvideo.o.getAccVideoPath();
        AppMethodBeat.o(20281);
        return accVideoPath;
    }

    public static String aTe() {
        AppMethodBeat.i(20282);
        StringBuilder sb = new StringBuilder();
        g.aAi();
        String sb2 = sb.append(g.aAh().hqG).append("image/shakeTranImg/").toString();
        AppMethodBeat.o(20282);
        return sb2;
    }

    public static String aTf() {
        AppMethodBeat.i(20283);
        String aTf = com.tencent.mm.plugin.h.a.aTf();
        AppMethodBeat.o(20283);
        return aTf;
    }

    public static String aTg() {
        AppMethodBeat.i(20284);
        StringBuilder sb = new StringBuilder();
        g.aAi();
        String sb2 = sb.append(g.aAh().hqG).append("attachment/").toString();
        AppMethodBeat.o(20284);
        return sb2;
    }

    public static String aTh() {
        AppMethodBeat.i(20285);
        String aTh = ((com.tencent.mm.al.q) g.af(com.tencent.mm.al.q.class)).aTh();
        AppMethodBeat.o(20285);
        return aTh;
    }

    public static String aTi() {
        AppMethodBeat.i(20286);
        StringBuilder sb = new StringBuilder();
        g.aAi();
        String sb2 = sb.append(g.aAh().hqG).append("record/").toString();
        AppMethodBeat.o(20286);
        return sb2;
    }

    public static String getAccSnsPath() {
        AppMethodBeat.i(20287);
        String accSnsPath = ((com.tencent.mm.plugin.sns.b.c) g.ah(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsPath();
        AppMethodBeat.o(20287);
        return accSnsPath;
    }

    public static String getAccSnsTmpPath() {
        AppMethodBeat.i(20288);
        String accSnsTmpPath = ((com.tencent.mm.plugin.sns.b.c) g.ah(com.tencent.mm.plugin.sns.b.c.class)).getAccSnsTmpPath();
        AppMethodBeat.o(20288);
        return accSnsTmpPath;
    }

    public static String aTj() {
        AppMethodBeat.i(20289);
        StringBuilder sb = new StringBuilder();
        bg.aVF();
        String sb2 = sb.append(getAccPath()).append("voiceremind/").toString();
        AppMethodBeat.o(20289);
        return sb2;
    }

    public static String aTk() {
        AppMethodBeat.i(20290);
        StringBuilder sb = new StringBuilder();
        bg.aVF();
        String sb2 = sb.append(getAccPath()).append("wenote/").toString();
        AppMethodBeat.o(20290);
        return sb2;
    }

    public static String azN() {
        AppMethodBeat.i(20291);
        g.aAi();
        String azN = g.aAh().azN();
        AppMethodBeat.o(20291);
        return azN;
    }

    public static String azO() {
        AppMethodBeat.i(20292);
        g.aAi();
        String azO = g.aAh().azO();
        AppMethodBeat.o(20292);
        return azO;
    }

    public static String azM() {
        AppMethodBeat.i(20293);
        g.aAi();
        String str = g.aAh().cachePath;
        AppMethodBeat.o(20293);
        return str;
    }

    public static String getAccPath() {
        AppMethodBeat.i(20294);
        g.aAi();
        String str = g.aAh().hqG;
        AppMethodBeat.o(20294);
        return str;
    }

    public final void aTl() {
        AppMethodBeat.i(20295);
        String str = g.aAh().cachePath;
        String str2 = g.aAh().hqG;
        String[] a2 = new com.tencent.mm.vfs.o(str).a(new w() {
            /* class com.tencent.mm.model.c.AnonymousClass5 */

            @Override // com.tencent.mm.vfs.w
            public final boolean accept(com.tencent.mm.vfs.o oVar, String str) {
                AppMethodBeat.i(231534);
                if (str.equals("EnMicroMsg.db") || str.startsWith("EnMicroMsg.dberr") || str.equals("FTS5IndexMicroMsg_encrypt.db")) {
                    AppMethodBeat.o(231534);
                    return true;
                }
                AppMethodBeat.o(231534);
                return false;
            }
        });
        if (a2 == null) {
            AppMethodBeat.o(20295);
            return;
        }
        for (String str3 : a2) {
            String str4 = str2 + str3 + ".dump";
            com.tencent.mm.vfs.s.deleteFile(str4);
            com.tencent.mm.vfs.s.nw(str + str3, str4);
            Log.i("MicroMsg.AccountStorage", "Exported: ".concat(String.valueOf(str4)));
        }
        AppMethodBeat.o(20295);
    }

    public static void clearPluginData(int i2) {
        AppMethodBeat.i(20296);
        y.rN(i2);
        if ((i2 & 16) != 0) {
            bp.a("medianote", (bp.a) null);
            bg.aVF();
            aST().bjW("medianote");
        }
        AppMethodBeat.o(20296);
    }

    static class b implements Runnable {
        String from;
        String to;

        public b(String str, String str2) {
            this.from = str;
            this.to = str2;
        }

        public final void run() {
            AppMethodBeat.i(20247);
            if (Util.isNullOrNil(this.from) || Util.isNullOrNil(this.to)) {
                AppMethodBeat.o(20247);
                return;
            }
            Log.i("MicroMsg.AccountStorage", "MoveDataFiles :" + this.from + " to :" + this.to);
            if (!com.tencent.mm.compatible.util.e.apn()) {
                AppMethodBeat.o(20247);
            } else if (!this.to.substring(0, com.tencent.mm.loader.j.b.aKJ().length()).equals(com.tencent.mm.loader.j.b.aKJ())) {
                AppMethodBeat.o(20247);
            } else {
                com.tencent.mm.vfs.s.cL(this.from + "image/", this.to + "image/");
                com.tencent.mm.vfs.s.cL(this.from + "video/", this.to + "video/");
                com.tencent.mm.vfs.s.cL(this.from + "voice/", this.to + "voice/");
                com.tencent.mm.vfs.s.cL(this.from + "voice2/", this.to + "voice2/");
                com.tencent.mm.vfs.s.cL(this.from + "package/", this.to + "package/");
                com.tencent.mm.vfs.s.cL(this.from + "emoji/", this.to + "emoji/");
                com.tencent.mm.vfs.s.cL(this.from + "mailapp/", this.to + "mailapp/");
                com.tencent.mm.vfs.s.cL(this.from + "brandicon/", this.to + "brandicon/");
                AppMethodBeat.o(20247);
            }
        }
    }

    static {
        AppMethodBeat.i(20305);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("BOTTLE_MESSAGE_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.model.c.AnonymousClass6 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return bk.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("APPBRAND_MESSAGE_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.model.c.AnonymousClass7 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.storage.h.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("APPBRAND_NOTIFY_MESSAGE_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.model.c.AnonymousClass8 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return i.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("BackupMoveTime".hashCode()), new h.b() {
            /* class com.tencent.mm.model.c.AnonymousClass9 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return k.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("BackupTempMoveTime".hashCode()), new h.b() {
            /* class com.tencent.mm.model.c.AnonymousClass10 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return o.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("BackupRecoverMsgListDataId".hashCode()), new h.b() {
            /* class com.tencent.mm.model.c.AnonymousClass2 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return m.SQL_CREATE;
            }
        });
        AppMethodBeat.o(20305);
    }

    public final com.tencent.mm.model.b.c aTm() {
        AppMethodBeat.i(20297);
        g.aAi();
        g.aAf().azk();
        com.tencent.mm.model.b.c cVar = this.iBs;
        AppMethodBeat.o(20297);
        return cVar;
    }

    public final d aTn() {
        AppMethodBeat.i(20298);
        g.aAi();
        g.aAf().azk();
        d dVar = this.iBt;
        AppMethodBeat.o(20298);
        return dVar;
    }

    public final com.tencent.mm.model.b.b aTo() {
        AppMethodBeat.i(20299);
        g.aAi();
        g.aAf().azk();
        com.tencent.mm.model.b.b bVar = this.iBx;
        AppMethodBeat.o(20299);
        return bVar;
    }

    public static com.tencent.mm.storage.g aTp() {
        AppMethodBeat.i(20300);
        g.aAi();
        g.aAf().azk();
        com.tencent.mm.storage.g aTp = com.tencent.mm.plugin.c.a.bqE().aTp();
        AppMethodBeat.o(20300);
        return aTp;
    }

    public static com.tencent.mm.plugin.messenger.foundation.a.a.c aTq() {
        AppMethodBeat.i(20301);
        g.aAi();
        g.aAf().azk();
        com.tencent.mm.plugin.messenger.foundation.a.a.c aTq = ((l) g.af(l.class)).aTq();
        AppMethodBeat.o(20301);
        return aTq;
    }

    public final k aTr() {
        AppMethodBeat.i(CdnLogic.kMediaTypeAppVideo);
        g.aAi();
        g.aAf().azk();
        k kVar = this.iBu;
        AppMethodBeat.o(CdnLogic.kMediaTypeAppVideo);
        return kVar;
    }

    public final o aTs() {
        AppMethodBeat.i(20303);
        g.aAi();
        g.aAf().azk();
        o oVar = this.iBv;
        AppMethodBeat.o(20303);
        return oVar;
    }

    public final m aTt() {
        AppMethodBeat.i(CdnLogic.kMediaTypeAppImageStorage);
        g.aAi();
        g.aAf().azk();
        m mVar = this.iBw;
        AppMethodBeat.o(CdnLogic.kMediaTypeAppImageStorage);
        return mVar;
    }

    public static cf getNotifyMessageRecordStorage() {
        AppMethodBeat.i(231536);
        g.aAi();
        g.aAf().azk();
        cf notifyMessageRecordStorage = ((com.tencent.mm.plugin.notifymessage.a) g.ah(com.tencent.mm.plugin.notifymessage.a.class)).getNotifyMessageRecordStorage();
        AppMethodBeat.o(231536);
        return notifyMessageRecordStorage;
    }
}
