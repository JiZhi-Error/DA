package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.br;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.cj;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.pluginsdk.j.a.a.f;
import com.tencent.mm.pluginsdk.j.a.a.g;
import com.tencent.mm.pluginsdk.j.a.a.i;
import com.tencent.mm.pluginsdk.j.a.a.j;
import com.tencent.mm.pluginsdk.j.a.c.d;
import com.tencent.mm.pluginsdk.j.a.c.g;
import com.tencent.mm.pluginsdk.j.a.c.i;
import com.tencent.mm.pluginsdk.j.a.c.l;
import com.tencent.mm.pluginsdk.j.a.c.m;
import com.tencent.mm.pluginsdk.j.a.c.n;
import com.tencent.mm.pluginsdk.j.a.c.q;
import com.tencent.mm.protocal.protobuf.dov;
import com.tencent.mm.protocal.protobuf.dyk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ar;
import com.tencent.recovery.wx.util.WXUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

public final class b {
    private final Set<AbstractC2018b> JYC;
    private final k JYD;
    private final d JYE;

    /* renamed from: com.tencent.mm.pluginsdk.j.a.a.b$b  reason: collision with other inner class name */
    public interface AbstractC2018b {
        boolean gnG();
    }

    /* synthetic */ b(byte b2) {
        this();
    }

    /* access modifiers changed from: package-private */
    public final Set<AbstractC2018b> gnB() {
        Set<AbstractC2018b> newSetFromMap;
        AppMethodBeat.i(151928);
        synchronized (this.JYC) {
            try {
                newSetFromMap = Collections.newSetFromMap(new android.support.v4.e.a(this.JYC.size()));
                newSetFromMap.addAll(this.JYC);
            } finally {
                AppMethodBeat.o(151928);
            }
        }
        return newSetFromMap;
    }

    public final void aP(int i2, int i3, int i4) {
        AppMethodBeat.i(151930);
        g(i2, i3, i4, true);
        AppMethodBeat.o(151930);
    }

    public static final class a implements g {
        private final IListener JYT = new IListener<ps>() {
            /* class com.tencent.mm.pluginsdk.j.a.a.b.a.AnonymousClass1 */

            {
                AppMethodBeat.i(161790);
                this.__eventId = ps.class.getName().hashCode();
                AppMethodBeat.o(161790);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(ps psVar) {
                AppMethodBeat.i(151920);
                if (com.tencent.mm.kernel.g.aAf().azp()) {
                    com.tencent.mm.kernel.g.aAf();
                    if (!com.tencent.mm.kernel.a.azj()) {
                        long nowSecond = Util.nowSecond();
                        long nullAs = Util.nullAs((Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_RES_DOWNLOADER_CHECK_RES_UPDATE_INTERVAL_LONG, (Object) null), 0);
                        if (nullAs != 0 && nullAs < nowSecond) {
                            p.cjR();
                        }
                    }
                }
                AppMethodBeat.o(151920);
                return false;
            }
        };
        private final cj.a JYU = new cj.a() {
            /* class com.tencent.mm.pluginsdk.j.a.a.b.a.AnonymousClass2 */

            @Override // com.tencent.mm.model.cj.a
            public final void a(h.a aVar) {
                AppMethodBeat.i(151921);
                String a2 = z.a(aVar.heO.KHn);
                if (Util.isNullOrNil(a2)) {
                    Log.w("MicroMsg.ResDownloader.CheckResUpdateHelper", "msg content is null");
                    AppMethodBeat.o(151921);
                    return;
                }
                Log.d("MicroMsg.CheckResUpdateNewXmlParser", "receive msg: \n".concat(String.valueOf(a2)));
                if (!Util.isNullOrNil(a2)) {
                    Map<String, String> parseXml = XmlParser.parseXml(a2, "sysmsg", null);
                    j.F(0, 0);
                    Object[] objArr = new Object[1];
                    objArr[0] = parseXml == null ? BuildConfig.COMMAND : String.valueOf(parseXml.size());
                    Log.i("MicroMsg.CheckResUpdateNewXmlParser", "parsed values.size = %s", objArr);
                    if (parseXml == null) {
                        j.F(0, 30);
                    } else {
                        j.F(0, 31);
                    }
                    if (parseXml != null && parseXml.size() > 0 && Util.nullAsNil(parseXml.get(".sysmsg.$type")).equalsIgnoreCase("resourcemgr")) {
                        e.j(".sysmsg", "delete", parseXml);
                        e.j(".sysmsg", "cache", parseXml);
                        e.j(".sysmsg", "decrypt", parseXml);
                    }
                }
                AppMethodBeat.o(151921);
            }

            @Override // com.tencent.mm.model.cj.a
            public final void a(h.c cVar) {
            }
        };
        private final h JYV = new h();

        public a() {
            AppMethodBeat.i(151923);
            AppMethodBeat.o(151923);
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.g
        public final void gnE() {
            AppMethodBeat.i(151924);
            EventCenter.instance.addListener(this.JYT);
            ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("resourcemgr", this.JYU, true);
            com.tencent.mm.kernel.g.aAk().postToWorkerDelayed(new Runnable() {
                /* class com.tencent.mm.pluginsdk.j.a.a.b.a.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(151922);
                    p.cjR();
                    AppMethodBeat.o(151922);
                }
            }, 10000);
            AppMethodBeat.o(151924);
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.g
        public final void onAccountRelease() {
            AppMethodBeat.i(151925);
            EventCenter.instance.removeListener(this.JYT);
            ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("resourcemgr", this.JYU, true);
            AppMethodBeat.o(151925);
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.g
        public final String avy() {
            return "CheckResUpdate";
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.g
        public final n.a c(l lVar) {
            AppMethodBeat.i(151926);
            if (!(lVar instanceof c)) {
                Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "get mismatch NetworkRequest type, return null");
                AppMethodBeat.o(151926);
                return null;
            }
            Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "return CheckResUpdateNetworkRequestHandler");
            d dVar = new d((c) lVar);
            AppMethodBeat.o(151926);
            return dVar;
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.g
        public final com.tencent.mm.pluginsdk.j.a.c.h gnF() {
            return this.JYV;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c {
        private static final b JYX = new b((byte) 0);

        static {
            AppMethodBeat.i(151927);
            AppMethodBeat.o(151927);
        }
    }

    public static b gnC() {
        AppMethodBeat.i(169213);
        if (!MMApplicationContext.isMainProcess()) {
            Assert.fail("Inaccessible in child process.");
        }
        b bVar = c.JYX;
        AppMethodBeat.o(169213);
        return bVar;
    }

    private b() {
        AppMethodBeat.i(151932);
        this.JYC = Collections.newSetFromMap(new android.support.v4.e.a(i.JZf.length));
        this.JYD = new k();
        this.JYE = new d() {
            /* class com.tencent.mm.pluginsdk.j.a.a.b.AnonymousClass3 */

            @Override // com.tencent.mm.pluginsdk.j.a.c.d
            public final void bdV(String str) {
                AppMethodBeat.i(151912);
                Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener.onComplete, urlkey = ".concat(String.valueOf(str)));
                com.tencent.mm.pluginsdk.j.a.c.s beg = q.a.goa().beg(str);
                if (beg == null) {
                    AppMethodBeat.o(151912);
                    return;
                }
                j.F(beg.field_reportId, 10);
                j.F(beg.field_reportId, 15);
                j.m(beg.field_resType, beg.field_subType, Util.getInt(beg.field_fileVersion, 0), (int) beg.field_reportId, 77);
                if ((!beg.field_fileCompress || beg.field_fileEncrypt) && beg.field_fileUpdated) {
                    j.a(beg.field_resType, beg.field_subType, beg.field_url, Util.getInt(beg.field_fileVersion, 0), beg.field_maxRetryTimes > beg.field_retryTimes ? j.a.RETRY_SUCC : j.a.SUCC, true, Util.nullAsNil(beg.field_groupId2).equals("NewXml"), false, beg.field_sampleId);
                }
                if (beg.field_fileCompress || beg.field_fileEncrypt) {
                    Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener, addDecryptRequest");
                    b.this.b(beg);
                    AppMethodBeat.o(151912);
                    return;
                }
                final bp bpVar = new bp();
                bpVar.dEN.filePath = beg.field_filePath;
                bpVar.dEN.dER = beg.field_originalMd5;
                bpVar.dEN.dEQ = beg.field_fileUpdated;
                bpVar.dEN.dEP = Util.getInt(beg.field_fileVersion, 0);
                bpVar.dEN.dEO = beg.field_resType;
                bpVar.dEN.subType = beg.field_subType;
                q.a.goa().handler.post(new Runnable() {
                    /* class com.tencent.mm.pluginsdk.j.a.a.b.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(223822);
                        EventCenter.instance.publish(bpVar);
                        AppMethodBeat.o(223822);
                    }
                });
                beg.field_fileUpdated = false;
                q.a.goa().h(beg);
                AppMethodBeat.o(151912);
            }

            @Override // com.tencent.mm.pluginsdk.j.a.c.d
            public final void a(String str, m mVar) {
                boolean z = true;
                AppMethodBeat.i(151913);
                Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "networkEventListener.onFailed: %s", str);
                i.bdY(str);
                com.tencent.mm.pluginsdk.j.a.c.s beg = q.a.goa().beg(str);
                if (beg == null) {
                    AppMethodBeat.o(151913);
                    return;
                }
                if (!(mVar == null || mVar.Kab == null)) {
                    if (mVar.Kab instanceof com.tencent.mm.pluginsdk.j.a.b.a) {
                        j.F(beg.field_reportId, 7);
                        z = false;
                    } else if (mVar.Kab instanceof com.tencent.mm.pluginsdk.j.a.b.c) {
                        j.F(beg.field_reportId, 16);
                        z = false;
                    }
                }
                if (z) {
                    j.F(beg.field_reportId, 11);
                }
                j.F(beg.field_reportId, 44);
                j.a(beg.field_resType, beg.field_subType, beg.field_url, Util.getInt(beg.field_fileVersion, 0), j.a.FAIL, false, "NewXml".equalsIgnoreCase(beg.field_groupId2), false, beg.field_sampleId);
                j.m(beg.field_resType, beg.field_subType, Util.getInt(beg.field_fileVersion, 0), (int) beg.field_reportId, 78);
                AppMethodBeat.o(151913);
            }

            @Override // com.tencent.mm.pluginsdk.j.a.c.d
            public final String avy() {
                return "CheckResUpdate";
            }

            @Override // com.tencent.mm.pluginsdk.j.a.c.d
            public final void bdW(String str) {
                boolean z;
                AppMethodBeat.i(151914);
                q goa = q.a.goa();
                if (goa.lsb) {
                    z = goa.Kal.bec(str);
                } else {
                    z = false;
                }
                if (!z) {
                    i.bdY(str);
                }
                AppMethodBeat.o(151914);
            }
        };
        q goa = q.a.goa();
        d dVar = this.JYE;
        Log.d("MicroMsg.ResDownloaderCore", "addNetworkEventLister, groupId = %s, listener = %s", "CheckResUpdate", dVar);
        if (goa.lsb) {
            i iVar = goa.Kam;
            Log.d("MicroMsg.ResDownloader.NetworkEventDispatcher", "addNetworkEventListener, listener = ".concat(String.valueOf(dVar)));
            if (dVar != null) {
                int hashCode = "CheckResUpdate".hashCode();
                synchronized (iVar.JZS) {
                    try {
                        List<d> list = iVar.JZR.get(hashCode);
                        list = list == null ? new LinkedList<>() : list;
                        list.add(dVar);
                        iVar.JZR.put(hashCode, list);
                    } finally {
                        AppMethodBeat.o(151932);
                    }
                }
                return;
            }
        }
        AppMethodBeat.o(151932);
    }

    public static void ahP(int i2) {
        AppMethodBeat.i(151933);
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, resType = %d", Integer.valueOf(i2));
        com.tencent.mm.kernel.g.aAf();
        boolean azo = com.tencent.mm.kernel.a.azo();
        boolean equals = bf.iDu.aA(WXUtil.LAST_LOGIN_USERNAME, "").equals("");
        if (azo || !equals) {
            com.tencent.mm.kernel.g.aAg().hqi.a(new m(i2), 0);
            AppMethodBeat.o(151933);
            return;
        }
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, not login, skip");
        AppMethodBeat.o(151933);
    }

    /* access modifiers changed from: package-private */
    public final void b(com.tencent.mm.pluginsdk.j.a.c.s sVar) {
        AppMethodBeat.i(151936);
        Log.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "addDecryptRequest, urlkey = " + sVar.field_urlKey);
        k kVar = this.JYD;
        if (kVar.bed(sVar.field_urlKey)) {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task");
            AppMethodBeat.o(151936);
            return;
        }
        kVar.a(a.a(sVar));
        AppMethodBeat.o(151936);
    }

    static void c(com.tencent.mm.pluginsdk.j.a.c.s sVar) {
        AppMethodBeat.i(151937);
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "performDecryptDirectly, urlkey %s", sVar.field_urlKey);
        k.g(sVar);
        AppMethodBeat.o(151937);
    }

    /* access modifiers changed from: package-private */
    public final void a(final int i2, dov dov, final boolean z) {
        AppMethodBeat.i(151938);
        final String kD = i.kD(i2, dov.MJT);
        if (dov.MSk == null) {
            Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDeleteOperation(), resource.Info = null");
            AppMethodBeat.o(151938);
            return;
        }
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive delete-op, fromNewXml(%b), %d.%d, file version (%d)", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(dov.MJT), Integer.valueOf(dov.MSk.MSu));
        j.F((long) dov.MSm, 3);
        final int i3 = dov.MSk.MSu;
        final int i4 = dov.MJT;
        final int i5 = dov.MSm;
        final String str = dov.MSn;
        q.a.goa().aj(new Runnable() {
            /* class com.tencent.mm.pluginsdk.j.a.a.b.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(151915);
                com.tencent.mm.pluginsdk.j.a.c.s beg = q.a.goa().beg(kD);
                int i2 = i2;
                int i3 = i4;
                int i4 = i3;
                int i5 = i5;
                String str = str;
                boolean z = z;
                Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "record ".concat(String.valueOf(beg)));
                Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "delete version %d", Integer.valueOf(i4));
                boolean z2 = false;
                if (beg == null) {
                    j.F((long) i5, 47);
                    j.F((long) i5, 22);
                    z2 = true;
                } else if (Util.getInt(beg.field_fileVersion, 0) <= i4) {
                    z2 = true;
                } else {
                    j.F(beg.field_reportId, 47);
                    j.F(beg.field_reportId, 22);
                }
                String kD = i.kD(i2, i3);
                String aee = i.aee(kD);
                Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoDeleteLogic", "doDelete(%b), filePath(%s)", Boolean.valueOf(z2), aee);
                if (z2) {
                    q.a.goa().Zb(kD);
                    b.gnC().h(i2, i3, 2, z);
                    if ((com.tencent.mm.pluginsdk.j.a.d.a.bej(aee) & true & com.tencent.mm.pluginsdk.j.a.d.a.bej(aee + ".decompressed")) && com.tencent.mm.pluginsdk.j.a.d.a.bej(aee + ".decrypted")) {
                        if (beg != null) {
                            j.F(beg.field_reportId, 21);
                            j.a(beg.field_resType, beg.field_subType, i4, z, beg.field_sampleId);
                        }
                    } else if (beg != null) {
                        j.F(beg.field_reportId, 22);
                        j.F(beg.field_reportId, 47);
                    }
                    if (beg == null) {
                        com.tencent.mm.pluginsdk.j.a.c.s sVar = new com.tencent.mm.pluginsdk.j.a.c.s();
                        sVar.field_urlKey = kD;
                        sVar.field_resType = i2;
                        sVar.field_subType = i3;
                        sVar.field_deleted = true;
                        sVar.field_fileVersion = String.valueOf(i4);
                        sVar.field_reportId = (long) i5;
                        sVar.field_sampleId = str;
                        q.a.goa().h(sVar);
                        AppMethodBeat.o(151915);
                        return;
                    }
                    beg.field_deleted = true;
                    beg.field_fileVersion = String.valueOf(i4);
                    q.a.goa().h(beg);
                }
                AppMethodBeat.o(151915);
            }
        });
        AppMethodBeat.o(151938);
    }

    /* access modifiers changed from: package-private */
    public final void b(int i2, dov dov, boolean z) {
        String valueOf;
        AppMethodBeat.i(151939);
        final String kD = i.kD(i2, dov.MJT);
        if (dov.MSk == null) {
            Log.e("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveCacheOperation(%s), resource.Info = null, return", kD);
            AppMethodBeat.o(151939);
            return;
        }
        Object[] objArr = new Object[9];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(dov.MJT);
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = Integer.valueOf(dov.MSk.MSu);
        if (dov.MSk.MSw == null) {
            valueOf = BuildConfig.COMMAND;
        } else {
            valueOf = String.valueOf(dov.MSk.MSw.size());
        }
        objArr[4] = valueOf;
        objArr[5] = Integer.valueOf(dov.MSm);
        objArr[6] = dov.MSn;
        objArr[7] = dov.MSk.Url;
        objArr[8] = dov.MSk.MSx;
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive cache-op, urlKey = %d.%d,  fromNewXml = %b, file version = %d, eccSignatureList.size = %s, reportId = %s, sampleId = %s, url = %s, data = %s", objArr);
        if (dov.MSk.MSw != null) {
            Iterator<dyk> it = dov.MSk.MSw.iterator();
            while (it.hasNext()) {
                dyk next = it.next();
                Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, sigInfo: version(%d), signature(%s) ", Integer.valueOf(next.Version), next.MYa.yO());
            }
        }
        j.Mr((long) dov.MSm);
        if (!z) {
            j.F((long) dov.MSm, 1);
        }
        if (dov.Lbj != 0 && ((long) dov.Lbj) <= Util.nowSecond()) {
            Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "recourse(%s) is expired before do download, expireTime = %d, fileVersion = %d", kD, Integer.valueOf(dov.Lbj), Integer.valueOf(dov.MSk.MSu));
            j.F((long) dov.MSm, 14);
            j.F((long) dov.MSm, 44);
            j.a(i2, dov.MJT, dov.MSk.Url, dov.MSk.MSu, j.a.FILE_EXPIRED, false, z, false, dov.MSn);
            AppMethodBeat.o(151939);
        } else if (!Util.isNullOrNil(dov.MSk.Url) || dov.MSk.MSx != null) {
            g.a aVar = new g.a(dov.MSk.Url);
            aVar.bea(kD);
            aVar.dEO = i2;
            aVar.subType = dov.MJT;
            aVar.Ms((long) dov.Lbj);
            aVar.dEP = dov.MSk.MSu;
            aVar.beb(dov.MSk.MD5);
            aVar.JYZ = i.a.ahR(dov.MSk.MSv);
            aVar.JZa = i.a.ahQ(dov.MSk.MSv);
            aVar.IBJ = (long) dov.MSm;
            aVar.JYz = dov.MSn;
            aVar.ahY(dov.MSo > 0 ? dov.MSo : 3);
            aVar.JZb = dov.JZb;
            aVar.ahX(dov.MSp);
            aVar.dEU = z;
            if (!Util.isNullOrNil(dov.MSk.MSw)) {
                aVar.JYx = dov.MSk.MSw.get(0).MYa.zy;
            }
            if (dov.MSl != null && !Util.isNullOrNil(dov.MSl.MSt)) {
                aVar.JYv = dov.MSl.MSt;
                aVar.JYw = dov.MSl.MSs;
            }
            if (dov.MSk.MSx != null && dov.MSk.MSx.zy.length > 0) {
                aVar.JYY = dov.MSk.MSx.toByteArray();
            }
            aVar.dER = dov.MSk.MSy;
            aVar.fileSize = (long) dov.MSk.FileSize;
            aVar.ahZ(dov.MhZ);
            final g gnK = aVar.gnK();
            Log.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "request (%s)", gnK.toString());
            q.a.goa().aj(new Runnable() {
                /* class com.tencent.mm.pluginsdk.j.a.a.b.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(151916);
                    com.tencent.mm.pluginsdk.j.a.c.s beg = q.a.goa().beg(kD);
                    g gVar = gnK;
                    if (beg == null) {
                        Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record is null, urlKey = %s", gVar.JYs);
                    } else {
                        Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record: urlKey = %s, url = %s, contentLength = %d, deleted = %b, eccSignature = %s, expireTime = %d, fileCompress = %b, fileEncrypt = %b, filePath = %s, fileUpdated = %b, fileVersion = %s, from = %s, keyVersion = %s, (encryptKey == null) = %b, maxRetryTimes = %d, retriedTimes = %d, sampleId = %s, dlStatus = %d", beg.field_urlKey, beg.field_url, Long.valueOf(beg.field_contentLength), Boolean.valueOf(beg.field_deleted), beg.field_eccSignature, Long.valueOf(beg.field_expireTime), Boolean.valueOf(beg.field_fileCompress), Boolean.valueOf(beg.field_fileEncrypt), beg.field_filePath, Boolean.valueOf(beg.field_fileUpdated), beg.field_fileVersion, beg.field_groupId2, Integer.valueOf(beg.field_keyVersion), Boolean.valueOf(Util.isNullOrNil(beg.field_encryptKey)), Integer.valueOf(beg.field_maxRetryTimes), Integer.valueOf(beg.field_retryTimes), beg.field_sampleId, Integer.valueOf(beg.field_status));
                        Log.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record.encryptKey = %s", beg.field_encryptKey);
                    }
                    if (beg != null && beg.field_deleted && gVar.bdX(beg.field_fileVersion) <= 0) {
                        Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "deletedFile.version = %s, cacheReq.version = %s, this file should have been deleted, skip this cache-op", beg.field_fileVersion, gVar.JZK);
                        AppMethodBeat.o(151916);
                    } else if (beg == null) {
                        com.tencent.mm.pluginsdk.j.a.c.s gnJ = gVar.gnJ();
                        gnJ.field_fileUpdated = true;
                        gnJ.field_needRetry = true;
                        if (Util.isNullOrNil(gnJ.field_encryptKey)) {
                            gnJ.field_keyVersion = -1;
                        }
                        Log.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new record ".concat(String.valueOf(gnJ)));
                        q.a.goa().h(gnJ);
                        b.gnC().h(gVar.dEO, gVar.subType, 0, gVar.dEU);
                        f.a.a(true, true, gnJ, gVar);
                        AppMethodBeat.o(151916);
                    } else {
                        Log.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record is not null");
                        beg.field_networkType = gVar.networkType;
                        if (Util.isNullOrNil(beg.field_originalMd5)) {
                            beg.field_originalMd5 = gVar.dER;
                        }
                        if (gVar.bdX(beg.field_fileVersion) > 0) {
                            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new version of file, re-download");
                            com.tencent.mm.pluginsdk.j.a.c.s gnJ2 = gVar.gnJ();
                            if (beg.field_keyVersion >= gVar.JYw) {
                                gnJ2.field_keyVersion = beg.field_keyVersion;
                                gnJ2.field_encryptKey = beg.field_encryptKey;
                            }
                            gnJ2.field_fileUpdated = true;
                            gnJ2.field_needRetry = true;
                            gnJ2.field_deleted = false;
                            q.a.goa().h(gnJ2);
                            b.gnC().h(gVar.dEO, gVar.subType, 0, gVar.dEU);
                            q.a.goa().Zb(gVar.JYs);
                            f.a.a(false, true, gnJ2, gVar);
                            AppMethodBeat.o(151916);
                        } else if (gVar.bdX(beg.field_fileVersion) == 0 && !beg.field_needRetry) {
                            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "no need retry, resType %d, subType %d, version %s", Integer.valueOf(beg.field_resType), Integer.valueOf(beg.field_subType), beg.field_fileVersion);
                            AppMethodBeat.o(151916);
                        } else if (beg.field_status == 2 || beg.field_status == 1 || beg.field_status == 0) {
                            long hv = com.tencent.mm.pluginsdk.j.a.d.a.hv(beg.field_filePath);
                            if (beg.field_contentLength > hv) {
                                Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "content-length(%d) > fileSize(%d), resume download", Long.valueOf(beg.field_contentLength), Long.valueOf(hv));
                                if (0 == hv) {
                                    b.gnC().h(gVar.dEO, gVar.subType, 0, gVar.dEU);
                                    f.a.a(false, true, beg, gVar);
                                    AppMethodBeat.o(151916);
                                    return;
                                }
                                f.a.a(true, false, beg, gVar);
                                AppMethodBeat.o(151916);
                            } else if (!Util.nullAsNil(com.tencent.mm.vfs.s.bhK(i.aee(gVar.JYs))).equals(beg.field_md5)) {
                                Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download");
                                f.a.a(false, true, beg, gVar);
                                AppMethodBeat.o(151916);
                            } else {
                                Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "md5 check ok, file download complete, throw event to do decrypt %s", beg.field_urlKey);
                                beg.field_status = 2;
                                beg.field_contentLength = com.tencent.mm.pluginsdk.j.a.d.a.hv(beg.field_filePath);
                                beg.field_fileUpdated = false;
                                beg.field_reportId = gVar.IBJ;
                                q.a.goa().h(beg);
                                j.F(beg.field_reportId, 13);
                                j.F(beg.field_reportId, 44);
                                j.a(beg.field_resType, beg.field_subType, beg.field_url, Util.getInt(beg.field_fileVersion, 0), j.a.FILE_LATEST, true, "NewXml".equalsIgnoreCase(beg.field_groupId2), true, beg.field_sampleId);
                                if (gVar.JYZ || gVar.JZa) {
                                    Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "send query and decrypt request %s", gVar.JYs);
                                    f.b.a(beg, false, false);
                                    AppMethodBeat.o(151916);
                                    return;
                                }
                                b.gnC().a(gVar.dEO, gVar.subType, i.aee(gVar.JYs), Util.getInt(gVar.JZK, 0), gVar.dER);
                                AppMethodBeat.o(151916);
                            }
                        } else {
                            if (beg.field_status == 4 || beg.field_status == 3) {
                                Log.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download %s", beg.field_urlKey);
                                f.a.a(false, true, beg, gVar);
                            }
                            AppMethodBeat.o(151916);
                        }
                    }
                }
            });
            AppMethodBeat.o(151939);
        } else {
            Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "cache-op, invalid cache operation, url and data is null or nil, skip");
            AppMethodBeat.o(151939);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, dov dov, boolean z, final boolean z2) {
        AppMethodBeat.i(151940);
        final String kD = i.kD(i2, dov.MJT);
        if (dov.MSl == null || Util.isNullOrNil(dov.MSl.MSt)) {
            Log.e("MicroMsg.ResDownloader.CheckResUpdateHelper", "onReceiveDecryptOperation(), resource.Key invalid, resource=%d.%d", Integer.valueOf(i2), Integer.valueOf(dov.MJT));
            AppMethodBeat.o(151940);
            return;
        }
        Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "receive decrypt-op, fromNewXml(%b), %d.%d, key version (%d)", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(dov.MJT), Integer.valueOf(dov.MSl.MSs));
        Log.d("MicroMsg.ResDownloader.CheckResUpdateHelper", "key (%s)", dov.MSl.MSt);
        j.F((long) dov.MSm, 4);
        final String str = dov.MSk.MSy;
        final String str2 = dov.MSl.MSt;
        final int i3 = dov.MSl.MSs;
        final int i4 = dov.MSm;
        final String str3 = dov.MSn;
        AnonymousClass6 r0 = new Runnable() {
            /* class com.tencent.mm.pluginsdk.j.a.a.b.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(151917);
                com.tencent.mm.pluginsdk.j.a.c.s beg = q.a.goa().beg(kD);
                String str = str;
                String str2 = str2;
                int i2 = i3;
                int i3 = i4;
                String str3 = str3;
                boolean z = z2;
                if (beg == null) {
                    com.tencent.mm.pluginsdk.j.a.c.s sVar = new com.tencent.mm.pluginsdk.j.a.c.s();
                    sVar.field_keyVersion = i2;
                    sVar.field_encryptKey = str2;
                    sVar.field_reportId = (long) i3;
                    sVar.field_sampleId = str3;
                    sVar.field_originalMd5 = str;
                    q.a.goa().h(sVar);
                    j.F((long) i3, 51);
                    j.F((long) i3, 45);
                    AppMethodBeat.o(151917);
                } else if (beg.field_keyVersion < i2) {
                    beg.field_keyVersion = i2;
                    beg.field_encryptKey = str2;
                    beg.field_reportId = (long) i3;
                    beg.field_sampleId = str3;
                    if (Util.isNullOrNil(beg.field_originalMd5)) {
                        beg.field_originalMd5 = str;
                    }
                    q.a.goa().h(beg);
                    f.b.a(beg, true, z);
                    AppMethodBeat.o(151917);
                } else {
                    if (z && beg.field_keyVersion == i2) {
                        f.b.a(beg, true, true);
                    }
                    AppMethodBeat.o(151917);
                }
            }
        };
        if (z2) {
            r0.run();
            AppMethodBeat.o(151940);
            return;
        }
        q.a.goa().aj(r0);
        AppMethodBeat.o(151940);
    }

    public final void g(final int i2, final int i3, final int i4, final boolean z) {
        AppMethodBeat.i(151929);
        q.a.goa().aj(new Runnable() {
            /* class com.tencent.mm.pluginsdk.j.a.a.b.AnonymousClass1 */

            public final void run() {
                boolean z;
                AppMethodBeat.i(151910);
                com.tencent.mm.pluginsdk.j.a.c.s beg = q.a.goa().beg(i.kD(i2, i3));
                if (beg != null && (-1 == i4 || String.valueOf(i4).equals(beg.field_fileVersion))) {
                    if (!z) {
                        z = true;
                    } else {
                        z = false;
                    }
                    beg.field_needRetry = z;
                    q.a.goa().h(beg);
                }
                AppMethodBeat.o(151910);
            }
        });
        AppMethodBeat.o(151929);
    }

    public static String kC(int i2, int i3) {
        String str;
        AppMethodBeat.i(151934);
        com.tencent.mm.pluginsdk.j.a.c.s beg = q.a.goa().beg(i.kD(i2, i3));
        if (beg == null) {
            Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, get null info, return", Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(151934);
            return null;
        }
        Log.v("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, queried primeInfo { deleted = %b, filepath = %s, md5 = %s, compress = %b, encrypt = %b, originalMd5 = %s }", Boolean.valueOf(beg.field_deleted), beg.field_filePath, beg.field_md5, Boolean.valueOf(beg.field_fileCompress), Boolean.valueOf(beg.field_fileEncrypt), beg.field_originalMd5);
        if (beg.field_fileCompress || beg.field_fileEncrypt) {
            if (beg.field_fileCompress) {
                str = beg.field_filePath + ".decompressed";
            } else if (beg.field_fileEncrypt) {
                str = beg.field_filePath + ".decrypted";
            } else {
                str = null;
            }
            if (Util.isNullOrNil(str)) {
                Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, filePath invalid return null ", Integer.valueOf(i2), Integer.valueOf(i3));
                AppMethodBeat.o(151934);
                return null;
            } else if (Util.isNullOrNil(beg.field_originalMd5) || !Util.nullAsNil(com.tencent.mm.vfs.s.bhK(str)).equals(beg.field_originalMd5)) {
                Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, needDecrypt(%b) needDecompress(%b), file invalid, return null ", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(beg.field_fileEncrypt), Boolean.valueOf(beg.field_fileCompress));
                AppMethodBeat.o(151934);
                return null;
            } else {
                Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, need decrypt or decompress, file valid, ret = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                AppMethodBeat.o(151934);
                return str;
            }
        } else if (beg.field_deleted || Util.isNullOrNil(beg.field_filePath) || !Util.nullAsNil(com.tencent.mm.vfs.s.bhK(beg.field_filePath)).equals(beg.field_md5)) {
            Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file invalid, return null", Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(151934);
            return null;
        } else {
            Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getCachedFilePath, %d.%d, not need decrypt and file valid, return path(%s)", Integer.valueOf(i2), Integer.valueOf(i3), beg.field_filePath);
            String str2 = beg.field_filePath;
            AppMethodBeat.o(151934);
            return str2;
        }
    }

    public static String gnD() {
        AppMethodBeat.i(151935);
        com.tencent.mm.pluginsdk.j.a.c.s beg = q.a.goa().beg(i.kD(60, 3));
        if (beg == null) {
            Log.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getOriginalMd5, %d.%d, get null info, return", 60, 3);
            AppMethodBeat.o(151935);
            return null;
        }
        String str = beg.field_originalMd5;
        AppMethodBeat.o(151935);
        return str;
    }

    /* access modifiers changed from: package-private */
    public final void a(final int i2, final int i3, final String str, final int i4, final String str2) {
        AppMethodBeat.i(151941);
        q.a.goa().aj(new Runnable() {
            /* class com.tencent.mm.pluginsdk.j.a.a.b.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(151918);
                b bVar = b.this;
                int i2 = i2;
                int i3 = i3;
                String str = str;
                int i4 = i4;
                String str2 = str2;
                com.tencent.mm.pluginsdk.j.a.c.s beg = q.a.goa().beg(i.kD(i2, i3));
                if (beg == null) {
                    AppMethodBeat.o(151918);
                    return;
                }
                boolean z = beg.field_fileUpdated;
                beg.field_fileUpdated = false;
                q.a.goa().h(beg);
                if (i4 == Util.getInt(beg.field_fileVersion, 0)) {
                    if (q.a.goa().handler == null) {
                        Log.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventFileCached: get null eventThread ");
                        AppMethodBeat.o(151918);
                        return;
                    }
                    q.a.goa().handler.post(new Runnable(i2, i3, str, i4, z, str2) {
                        /* class com.tencent.mm.pluginsdk.j.a.a.b.AnonymousClass8 */
                        final /* synthetic */ int JYR;
                        final /* synthetic */ boolean JYS;
                        final /* synthetic */ String lhI;
                        final /* synthetic */ int lyz;
                        final /* synthetic */ String val$filePath;
                        final /* synthetic */ int yUO;

                        {
                            this.yUO = r2;
                            this.lyz = r3;
                            this.val$filePath = r4;
                            this.JYR = r5;
                            this.JYS = r6;
                            this.lhI = r7;
                        }

                        public final void run() {
                            AppMethodBeat.i(151919);
                            bp bpVar = new bp();
                            bpVar.dEN.dEO = this.yUO;
                            bpVar.dEN.subType = this.lyz;
                            bpVar.dEN.filePath = this.val$filePath;
                            bpVar.dEN.dEP = this.JYR;
                            bpVar.dEN.dEQ = this.JYS;
                            bpVar.dEN.dER = this.lhI;
                            EventCenter.instance.publish(bpVar);
                            AppMethodBeat.o(151919);
                        }
                    });
                }
                AppMethodBeat.o(151918);
            }
        });
        AppMethodBeat.o(151941);
    }

    /* access modifiers changed from: package-private */
    public final void h(final int i2, final int i3, final int i4, final boolean z) {
        AppMethodBeat.i(151942);
        if (q.a.goa().handler == null) {
            Log.f("MicroMsg.ResDownloader.CheckResUpdateHelper", "sendEventPreOperation: get null eventThread ");
            AppMethodBeat.o(151942);
            return;
        }
        q.a.goa().handler.post(new Runnable() {
            /* class com.tencent.mm.pluginsdk.j.a.a.b.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(151911);
                br brVar = new br();
                brVar.dEV.dDe = i4;
                brVar.dEV.dEO = i2;
                brVar.dEV.subType = i3;
                brVar.dEV.dEU = z;
                EventCenter.instance.publish(brVar);
                AppMethodBeat.o(151911);
            }
        });
        AppMethodBeat.o(151942);
    }
}
