package com.tencent.mm.plugin.appbrand.appcache;

import android.net.Uri;
import android.os.Bundle;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ab;
import com.tencent.mm.i.g;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.a.b;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.pluginsdk.j.a.c.e;
import com.tencent.mm.pluginsdk.j.a.c.f;
import com.tencent.mm.pluginsdk.j.a.c.k;
import com.tencent.mm.pluginsdk.j.a.c.l;
import com.tencent.mm.pluginsdk.j.a.c.m;
import com.tencent.mm.pluginsdk.j.a.c.n;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;

public final class az {
    final b kML = new b();

    az() {
        AppMethodBeat.i(90618);
        AppMethodBeat.o(90618);
    }

    public static String bwm() {
        AppMethodBeat.i(90619);
        String str = g.aAh().cachePath;
        if (!str.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            str = str + FilePathGenerator.ANDROID_DIR_SEP;
        }
        String str2 = str + "appbrand/pkg/";
        FilePathGenerator.checkMkdir(str2);
        AppMethodBeat.o(90619);
        return str2;
    }

    public final int c(com.tencent.mm.plugin.appbrand.appcache.a.a aVar) {
        AppMethodBeat.i(90620);
        if (this.kML.bed(aVar.JYs)) {
            Log.i("MicroMsg.WxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s already in queue", aVar.JYs);
            AppMethodBeat.o(90620);
            return 0;
        }
        int b2 = this.kML.b((l) aVar);
        Log.i("MicroMsg.WxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s, addResult %d", aVar.JYs, Integer.valueOf(b2));
        AppMethodBeat.o(90620);
        return b2;
    }

    /* access modifiers changed from: package-private */
    public static final class c extends n.a<com.tencent.mm.plugin.appbrand.appcache.a.a> {
        private static final ThreadLocal<a> kMW = new ThreadLocal<a>() {
            /* class com.tencent.mm.plugin.appbrand.appcache.az.c.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public final /* synthetic */ a initialValue() {
                AppMethodBeat.i(90601);
                a aVar = new a((byte) 0);
                AppMethodBeat.o(90601);
                return aVar;
            }
        };
        private String kMX = null;
        final ae.a kMY;

        static {
            AppMethodBeat.i(90609);
            AppMethodBeat.o(90609);
        }

        c(com.tencent.mm.plugin.appbrand.appcache.a.a aVar) {
            super(aVar);
            AppMethodBeat.i(90602);
            ae.a b2 = ae.b(aVar);
            this.kMY = b2 == null ? m.kKB : b2;
            AppMethodBeat.o(90602);
        }

        /* access modifiers changed from: protected */
        public final com.tencent.mm.plugin.appbrand.appcache.a.a bwn() {
            AppMethodBeat.i(90603);
            com.tencent.mm.plugin.appbrand.appcache.a.a aVar = (com.tencent.mm.plugin.appbrand.appcache.a.a) super.bwt();
            AppMethodBeat.o(90603);
            return aVar;
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.n.a, com.tencent.mm.pluginsdk.j.a.c.e
        public final String getURL() {
            return this.kMX;
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.n.a, com.tencent.mm.pluginsdk.j.a.c.e
        public final boolean AX(long j2) {
            AppMethodBeat.i(90606);
            StatFs statFs = new StatFs(aa.z(new o(getFilePath()).heq().her()));
            long availableBlocks = (long) (statFs.getAvailableBlocks() * statFs.getBlockSize());
            if (availableBlocks < 0 || availableBlocks > j2) {
                AppMethodBeat.o(90606);
                return true;
            }
            AppMethodBeat.o(90606);
            return false;
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.e
        public final String avy() {
            return "AppBrandWxaPkgDownloader";
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.n.a, com.tencent.mm.pluginsdk.j.a.c.e
        public final boolean bwo() {
            return true;
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.n.a, com.tencent.mm.pluginsdk.j.a.c.e
        public final boolean bwp() {
            return false;
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.n.a, com.tencent.mm.pluginsdk.j.a.c.e
        public final boolean bwq() {
            return true;
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.n.a
        public final boolean bwr() {
            return false;
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.n.a, com.tencent.mm.pluginsdk.j.a.c.e
        public final boolean bws() {
            AppMethodBeat.i(90607);
            switch (ab.ape()) {
                case 0:
                    AppMethodBeat.o(90607);
                    return false;
                case 1:
                    boolean bws = super.bws();
                    AppMethodBeat.o(90607);
                    return bws;
                default:
                    AppMethodBeat.o(90607);
                    return false;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x00a4  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00bd  */
        @Override // com.tencent.mm.pluginsdk.j.a.c.n.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.tencent.mm.pluginsdk.j.a.c.m a(com.tencent.mm.pluginsdk.j.a.c.j r11) {
            /*
            // Method dump skipped, instructions count: 200
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.appcache.az.c.a(com.tencent.mm.pluginsdk.j.a.c.j):com.tencent.mm.pluginsdk.j.a.c.m");
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.f.d
        public final /* bridge */ /* synthetic */ f.b bwt() {
            AppMethodBeat.i(90608);
            com.tencent.mm.plugin.appbrand.appcache.a.a aVar = (com.tencent.mm.plugin.appbrand.appcache.a.a) super.bwt();
            AppMethodBeat.o(90608);
            return aVar;
        }
    }

    /* access modifiers changed from: package-private */
    public final class b extends n {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.pluginsdk.j.a.c.f$b] */
        @Override // com.tencent.mm.pluginsdk.j.a.c.n, com.tencent.mm.pluginsdk.j.a.c.f
        public final /* bridge */ /* synthetic */ f.d a(l lVar) {
            AppMethodBeat.i(90600);
            f.d a2 = a(lVar);
            AppMethodBeat.o(90600);
            return a2;
        }

        b() {
            super("WxaPkgDownload", new d());
            AppMethodBeat.i(90596);
            AppMethodBeat.o(90596);
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.n
        public final void shutdown() {
            AppMethodBeat.i(90597);
            super.shutdown();
            ((d) this.Kad).kMZ.quit();
            AppMethodBeat.o(90597);
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.n
        public final f.d a(l lVar) {
            AppMethodBeat.i(90598);
            c cVar = new c((com.tencent.mm.plugin.appbrand.appcache.a.a) lVar);
            cVar.Kag = this.Kad;
            AppMethodBeat.o(90598);
            return cVar;
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.n
        public final int b(l lVar) {
            AppMethodBeat.i(90599);
            int b2 = super.b(lVar);
            if (b2 == 1) {
                super.b((f.b) lVar);
                AppMethodBeat.o(90599);
                return 2;
            }
            AppMethodBeat.o(90599);
            return b2;
        }
    }

    /* access modifiers changed from: package-private */
    public final class d implements com.tencent.mm.pluginsdk.j.a.c.c {
        final MMHandler kMZ = new MMHandler("WxaPkgDownloadPerformerEventDispatchThread");

        d() {
            AppMethodBeat.i(90611);
            AppMethodBeat.o(90611);
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.c
        public final void a(final e eVar, final m mVar) {
            AppMethodBeat.i(90612);
            this.kMZ.post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.appcache.az.d.AnonymousClass1 */

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                public final void run() {
                    AppMethodBeat.i(90610);
                    switch (mVar.status) {
                        case 2:
                            d.c(eVar, mVar);
                            AppMethodBeat.o(90610);
                            return;
                        case 3:
                            d.b(eVar, mVar);
                            break;
                        case 4:
                            d.d(eVar, mVar);
                            AppMethodBeat.o(90610);
                            return;
                    }
                    AppMethodBeat.o(90610);
                }
            });
            AppMethodBeat.o(90612);
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.c
        public final void C(String str, int i2, int i3) {
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.c
        public final void O(String str, long j2) {
        }

        public static void b(e eVar, m mVar) {
            AppMethodBeat.i(90613);
            a((c) eVar, mVar);
            AppMethodBeat.o(90613);
        }

        public static void c(e eVar, m mVar) {
            AppMethodBeat.i(90614);
            com.tencent.mm.plugin.appbrand.appcache.a.a bwn = ((c) eVar).bwn();
            if (bwn instanceof aw) {
                aw awVar = (aw) bwn;
                ae.a aVar = ((c) eVar).kMY;
                bh bub = ((com.tencent.mm.plugin.appbrand.api.e) g.af(com.tencent.mm.plugin.appbrand.api.e.class)).bub();
                if (bub == null) {
                    bj.a(awVar.JYs, awVar.appId, b.a.EnumC0543a.ENV_ERR, (bj.b) null);
                    AppMethodBeat.o(90614);
                    return;
                }
                String str = awVar.appId;
                int i2 = awVar.kMt;
                int i3 = awVar.kMu;
                String bwb = awVar.bwb();
                bd a2 = bub.a(str, i2, 0, "pkgPath");
                if (a2 == null) {
                    Log.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadComplete, get NULL oldInfo with appId[%s] version[%d]", str, Integer.valueOf(i2));
                    bj.a(awVar.JYs, awVar.appId, b.a.EnumC0543a.ENV_ERR, (bj.b) null);
                    AppMethodBeat.o(90614);
                    return;
                }
                aVar.bvm();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                int B = s.B(a2.field_pkgPath, bwb, awVar.getFilePath());
                Log.i("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "applyPkgPatch, appId[%s], oldPath[%s], newPath[%s], patchPath[%s], cost %d, ret %d", awVar.appId, a2.field_pkgPath, bwb, awVar.getFilePath(), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime), Integer.valueOf(B));
                aVar.vQ(B);
                boolean z = awVar.kMv instanceof b.AbstractC0544b;
                if (B == 0) {
                    Collection<bj.a> Vu = bj.Vu(awVar.JYs);
                    i iVar = new i();
                    i iVar2 = new i();
                    i iVar3 = new i();
                    bj.a(awVar.JYs, new bj.a(iVar, iVar2, iVar3) {
                        /* class com.tencent.mm.plugin.appbrand.appcache.s.AnonymousClass1 */
                        final /* synthetic */ i kKM;
                        final /* synthetic */ i kKN;
                        final /* synthetic */ i kKO;

                        {
                            this.kKM = r1;
                            this.kKN = r2;
                            this.kKO = r3;
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.String, com.tencent.mm.plugin.appbrand.appcache.a.b$a$a, java.lang.Object] */
                        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.String */
                        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.tencent.mm.plugin.appbrand.appcache.a.b$a$a */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
                        public final /* bridge */ /* synthetic */ void a(String str, b.a.EnumC0543a aVar, bj.b bVar) {
                            this.kKM.value = str;
                            this.kKN.value = aVar;
                            this.kKO.value = (T) bVar;
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
                        public final /* bridge */ /* synthetic */ void cr(WxaPkgLoadProgress wxaPkgLoadProgress) {
                        }
                    });
                    bj.a(awVar.JYs, awVar.appId, bwb, i3, 0, aVar);
                    boolean z2 = b.a.EnumC0543a.OK == iVar2.value;
                    Log.i("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadComplete, urlKey[%s] verifyOk[%s] canFallback[%b]", awVar.JYs, Boolean.valueOf(z2), Boolean.valueOf(z));
                    if (z2 || !z) {
                        if (Vu != null) {
                            for (bj.a aVar2 : Vu) {
                                aVar2.a(iVar.value, iVar2.value, iVar3.value);
                            }
                        }
                        AppMethodBeat.o(90614);
                        return;
                    }
                    bj.a(awVar.JYs, Vu);
                }
                s.deleteFile(bwb);
                s.deleteFile(awVar.getFilePath());
                s.AnonymousClass2 r1 = new bj.a(bj.Vu(awVar.JYs), awVar) {
                    /* class com.tencent.mm.plugin.appbrand.appcache.s.AnonymousClass2 */
                    private final boolean kKP;
                    final /* synthetic */ Collection kKQ;
                    final /* synthetic */ aw kKR;

                    {
                        this.kKQ = r4;
                        this.kKR = r5;
                        AppMethodBeat.i(230553);
                        this.kKP = this.kKQ != null && this.kKQ.contains(this.kKR.kMv);
                        AppMethodBeat.o(230553);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.String, com.tencent.mm.plugin.appbrand.appcache.a.b$a$a, java.lang.Object] */
                    @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
                    public final /* synthetic */ void a(String str, b.a.EnumC0543a aVar, bj.b bVar) {
                        AppMethodBeat.i(230555);
                        bj.b bVar2 = bVar;
                        if (this.kKQ != null && !this.kKQ.isEmpty()) {
                            for (bj.a aVar2 : this.kKQ) {
                                aVar2.a(str, aVar, bVar2);
                            }
                        }
                        if (!this.kKP) {
                            this.kKR.kMv.a(str, aVar, bVar2);
                        }
                        AppMethodBeat.o(230555);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.plugin.appbrand.appcache.a.b.a
                    public final /* synthetic */ void cr(WxaPkgLoadProgress wxaPkgLoadProgress) {
                        AppMethodBeat.i(230554);
                        WxaPkgLoadProgress wxaPkgLoadProgress2 = wxaPkgLoadProgress;
                        if (this.kKQ != null && !this.kKQ.isEmpty()) {
                            for (bj.a aVar : this.kKQ) {
                                aVar.cr(wxaPkgLoadProgress2);
                            }
                        }
                        if (!this.kKP) {
                            this.kKR.kMv.cr(wxaPkgLoadProgress2);
                        }
                        AppMethodBeat.o(230554);
                    }
                };
                if (awVar.kMv instanceof b.AbstractC0544b) {
                    ((b.AbstractC0544b) awVar.kMv).bwD();
                }
                bd a3 = bub.a(awVar.appId, awVar.kMu, 0, "downloadURL");
                if (a3 == null || TextUtils.isEmpty(a3.field_downloadURL)) {
                    Log.e("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "onIncrementalPkgDownloadComplete, fallback non-incremental get EMPTY url with key[%s]", awVar.JYs);
                    r1.a(awVar.appId, b.a.EnumC0543a.ENV_ERR, null);
                    AppMethodBeat.o(90614);
                    return;
                }
                if (!bj.c(awVar.appId, 0, awVar.kMu, a3.field_downloadURL, r1)) {
                    r1.a(awVar.appId, b.a.EnumC0543a.ENV_ERR, null);
                }
                AppMethodBeat.o(90614);
            } else if (bwn instanceof bs) {
                bt.a((bs) bwn, ((c) eVar).kMY);
                AppMethodBeat.o(90614);
            } else if (bwn instanceof l) {
                k.INSTANCE.a((l) bwn, mVar);
                AppMethodBeat.o(90614);
            } else {
                String str2 = ((c) eVar).bwn().appId;
                try {
                    bj.a(mVar.JYs, str2, mVar.filePath, ((c) eVar).bwn().version, ((c) eVar).bwn().dMe, ((c) eVar).kMY);
                    AppMethodBeat.o(90614);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.WxaPkgDownloadPerformer", e2, "dispatchComplete", new Object[0]);
                    bj.cu(mVar.JYs, str2);
                    AppMethodBeat.o(90614);
                }
            }
        }

        public static void d(e eVar, m mVar) {
            AppMethodBeat.i(90615);
            a((c) eVar, mVar);
            AppMethodBeat.o(90615);
        }

        @Override // com.tencent.mm.pluginsdk.j.a.c.c
        public final void a(String str, k kVar) {
            AppMethodBeat.i(90616);
            bj.a(str, (WxaPkgLoadProgress) kVar);
            AppMethodBeat.o(90616);
        }

        private static void a(c cVar, m mVar) {
            b.a.EnumC0543a aVar;
            AppMethodBeat.i(90617);
            com.tencent.mm.vfs.s.deleteFile(mVar.filePath);
            if (cVar.bwn() instanceof l) {
                k.INSTANCE.a((l) cVar.bwn(), mVar);
                AppMethodBeat.o(90617);
            } else if (cVar.bwn() instanceof aw) {
                s.a((aw) cVar.bwn(), mVar, cVar.kMY);
                AppMethodBeat.o(90617);
            } else if (cVar.bwn() instanceof bs) {
                bt.a((bs) cVar.bwn(), mVar, cVar.kMY);
                AppMethodBeat.o(90617);
            } else {
                String str = cVar.bwn().appId;
                if (!(mVar.Kab instanceof com.tencent.mm.pluginsdk.j.a.b.a)) {
                    switch (mVar.httpStatusCode) {
                        case 403:
                        case 404:
                            aVar = b.a.EnumC0543a.SEVER_FILE_NOT_FOUND;
                            break;
                        default:
                            aVar = b.a.EnumC0543a.FAILED;
                            break;
                    }
                } else {
                    aVar = b.a.EnumC0543a.DISK_FULL;
                }
                bj.a(mVar.JYs, str, aVar);
                AppMethodBeat.o(90617);
            }
        }
    }

    static final class a {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        public final m a(c cVar) {
            final MTimerHandler mTimerHandler;
            AppMethodBeat.i(90595);
            String gnA = cVar.gnA();
            try {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                final i iVar = new i();
                final com.tencent.mm.plugin.appbrand.appcache.a.a bwn = cVar.bwn();
                final String str = bwn.JYs;
                final ae.a aVar = cVar.kMY;
                if (cVar.bwn().kOB) {
                    mTimerHandler = new MTimerHandler(p.ayg().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                        /* class com.tencent.mm.plugin.appbrand.appcache.az.a.AnonymousClass1 */

                        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                        public final boolean onTimerExpired() {
                            AppMethodBeat.i(90593);
                            com.tencent.mm.an.f.baQ().Oc(str);
                            aVar.bvk();
                            com.tencent.mm.vfs.s.deleteFile(bwn.getFilePath());
                            iVar.value = null;
                            countDownLatch.countDown();
                            AppMethodBeat.o(90593);
                            return false;
                        }
                    }, false);
                } else {
                    mTimerHandler = null;
                }
                final com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
                gVar.taskName = "task_WxaPkgDownloadPerformer";
                AnonymousClass2 r9 = new AbstractC0545a(cVar, gVar) {
                    /* class com.tencent.mm.plugin.appbrand.appcache.az.a.AnonymousClass2 */

                    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.tencent.mm.pluginsdk.j.a.c.m */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* access modifiers changed from: package-private */
                    @Override // com.tencent.mm.plugin.appbrand.appcache.az.a.AbstractC0545a
                    public final void c(m mVar) {
                        AppMethodBeat.i(90594);
                        if (mTimerHandler != null) {
                            mTimerHandler.stopTimer();
                        }
                        iVar.value = mVar;
                        countDownLatch.countDown();
                        AppMethodBeat.o(90594);
                    }
                };
                gVar.field_mediaId = str;
                gVar.field_fullpath = bwn.getFilePath();
                gVar.gqB = bwn.url;
                gVar.ehd = false;
                gVar.gqy = r9;
                gVar.gqC = (int) TimeUnit.MILLISECONDS.toSeconds((long) bwn.getConnectTimeout());
                gVar.gqD = (int) TimeUnit.MILLISECONDS.toSeconds((long) bwn.getReadTimeout());
                gVar.field_fileType = com.tencent.mm.i.a.gqa;
                if (bwn instanceof l) {
                    gVar.gqF = false;
                } else if (!bwn.appId.startsWith("wxfe02ecfe70800f46")) {
                    if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_pkg_download_use_cronet, BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.DEBUG)) {
                        gVar.gqM = true;
                    }
                } else if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_pkg_download_use_cronet_for_weishi, false)) {
                    gVar.gqM = true;
                }
                if (gVar.gqM) {
                    gVar.gqN = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_wxapkg_cdn_download_use_newdns, BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.DEBUG);
                } else {
                    com.tencent.luggage.sdk.g.c.a("WxaDownloadProfile| getHost", new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.appcache.az.a.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(161748);
                            String host = Uri.parse(gVar.gqB).getHost();
                            if (!Util.isNullOrNil(host)) {
                                ArrayList<String> Vd = aa.Vd(host);
                                gVar.gqE = new String[Vd.size()];
                                Vd.toArray(gVar.gqE);
                            }
                            AppMethodBeat.o(161748);
                        }
                    });
                }
                Log.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "downloadUsingCDN, cdnTask made, forceUseCronet:%b, forceUseNewDns:%b, url %s", Boolean.valueOf(gVar.gqM), Boolean.valueOf(gVar.gqN), cVar.getURL());
                com.tencent.mm.an.f.baQ().b(gVar, -1);
                if (mTimerHandler != null) {
                    mTimerHandler.startTimer((long) bwn.getReadTimeout());
                }
                try {
                    countDownLatch.await();
                    T t = iVar.value;
                    AppMethodBeat.o(90595);
                    return t;
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform, urlKey %s semaphore await e = %s", gnA, e2);
                    AppMethodBeat.o(90595);
                    return null;
                }
            } catch (Exception e3) {
                Log.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform urlKey %s exp %s", gnA, e3);
                AppMethodBeat.o(90595);
                return null;
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.appcache.az$a$a  reason: collision with other inner class name */
        static abstract class AbstractC0545a implements g.a {
            private final c kMT;
            private final com.tencent.mm.i.g kMU;

            /* access modifiers changed from: package-private */
            public abstract void c(m mVar);

            AbstractC0545a(c cVar, com.tencent.mm.i.g gVar) {
                this.kMT = cVar;
                this.kMU = gVar;
            }

            @Override // com.tencent.mm.i.g.a
            public final int a(String str, int i2, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                m mVar;
                if (i2 != 0) {
                    c(new m(this.kMT, new SSLException(String.format(Locale.US, "CdnHttpsAddTaskFailed$%s$%d", this.kMT.gnA(), Integer.valueOf(i2))), 3));
                    Log.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, startRet %d", this.kMT.gnA(), Integer.valueOf(i2));
                    return 0;
                } else if (cVar != null) {
                    com.tencent.mm.pluginsdk.j.a.c.c cVar2 = this.kMT.Kag;
                    if (cVar2 != null) {
                        cVar2.a(this.kMT.gnA(), new WxaPkgLoadProgress(Math.round((((float) cVar.field_finishedLength) / ((float) cVar.field_toltalLength)) * 100.0f), cVar.field_finishedLength, cVar.field_toltalLength));
                    }
                    return 0;
                } else {
                    if (dVar != null) {
                        Object[] objArr = new Object[5];
                        objArr[0] = this.kMT.gnA();
                        objArr[1] = Integer.valueOf(dVar.field_retCode);
                        objArr[2] = dVar.field_httpResponseHeader;
                        objArr[3] = Integer.valueOf(dVar.field_httpStatusCode);
                        objArr[4] = Boolean.valueOf(dVar.cronetTaskResult != null);
                        Log.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, retCode %d, responseHeader %s, httpStatusCode %d, useCronet %b", objArr);
                        if (dVar.field_retCode == 0 && 200 == dVar.field_httpStatusCode) {
                            m mVar2 = new m("AppBrandWxaPkgDownloader", this.kMT.gnA(), this.kMU.gqB, this.kMT.getFilePath(), -1, null, 2, null);
                            a(mVar2, dVar.cronetTaskResult);
                            c(mVar2);
                            int boW = (int) com.tencent.mm.vfs.s.boW(this.kMT.bwn().getFilePath());
                            if (ay.a.iDr != null) {
                                ay.a.iDr.dl(boW, 0);
                            }
                        } else {
                            if (dVar.field_fileLength <= 0 || this.kMT.AX(dVar.field_fileLength)) {
                                mVar = new m(this.kMT, new SSLException(String.format(Locale.US, "CdnHttpsDownloadFailed$%s$%d", this.kMT.gnA(), Integer.valueOf(dVar.field_retCode))), dVar.field_httpStatusCode, 3);
                            } else {
                                mVar = new m(this.kMT, new com.tencent.mm.pluginsdk.j.a.b.a(), dVar.field_httpStatusCode, 3);
                            }
                            a(mVar, dVar.cronetTaskResult);
                            c(mVar);
                        }
                    }
                    return 0;
                }
            }

            private void a(m mVar, CdnLogic.CronetTaskResult cronetTaskResult) {
                boolean z;
                if (cronetTaskResult != null) {
                    Bundle bundle = mVar.bundle;
                    if (this.kMU.gqN || !this.kMU.gqM) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bundle.putBoolean("RESPONSE_KEY_USE_NEWDNS", z);
                    mVar.bundle.putBoolean("RESPONSE_KEY_USE_QUIC", cronetTaskResult.useQuic);
                    mVar.bundle.putBoolean("RESPONSE_KEY_USE_HTTP2", cronetTaskResult.useHttp2);
                    if (cronetTaskResult.performance != null) {
                        mVar.bundle.putParcelable("RESPONSE_KEY_CRONET_PERFORMANCE", cronetTaskResult.performance);
                        Log.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "fill cronet performance profile, urlKey:%s, resp.status:%d, url:%s, performance:%s", mVar.JYs, Integer.valueOf(mVar.status), mVar.url, cronetTaskResult.performance);
                    }
                }
            }

            @Override // com.tencent.mm.i.g.a
            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            @Override // com.tencent.mm.i.g.a
            public final byte[] f(String str, byte[] bArr) {
                return new byte[0];
            }
        }
    }
}
