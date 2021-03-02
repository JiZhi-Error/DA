package com.tencent.mm.plugin.lite.b;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.boots.a.g;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public enum e {
    INSTANCE;
    
    public Map<Long, a> yEF = new ConcurrentHashMap();
    private m yEG = new m() {
        /* class com.tencent.mm.plugin.lite.b.e.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.downloader.model.m
        public final void k(long j2, String str) {
            AppMethodBeat.i(198860);
            Log.i("MicroMsg.LiteAppDownloadPkg", "onTaskStarted id:%s savedFilePath:%s", Long.valueOf(j2), str);
            AppMethodBeat.o(198860);
        }

        @Override // com.tencent.mm.plugin.downloader.model.m
        public final void b(long j2, String str, boolean z) {
            AppMethodBeat.i(198861);
            if (!e.this.yEF.containsKey(Long.valueOf(j2))) {
                AppMethodBeat.o(198861);
                return;
            }
            a aVar = e.this.yEF.get(Long.valueOf(j2));
            if (Util.isNullOrNil(str)) {
                e.this.yEF.remove(Long.valueOf(j2));
                if (aVar.yEK != null) {
                    aVar.yEK.dTu();
                }
                AppMethodBeat.o(198861);
                return;
            }
            h.INSTANCE.n(1293, 94, 1);
            g gVar = aVar.yEJ;
            e.this.yEF.remove(Long.valueOf(j2));
            String aw = h.aw(gVar.appId, gVar.cri, gVar.pkL);
            Log.i("MicroMsg.LiteAppDownloadPkg", "download %s success. path:%s, dir:%s, patchId:%s", gVar.appId, str, aw, gVar.cri);
            o oVar = new o(aw);
            if (!oVar.exists()) {
                oVar.mkdirs();
            }
            try {
                e.ix(s.k(str, false), aw);
                try {
                    WxaLiteAppInfo wxaLiteAppInfo = new WxaLiteAppInfo();
                    wxaLiteAppInfo.appId = gVar.appId;
                    wxaLiteAppInfo.path = aw;
                    wxaLiteAppInfo.crh = gVar.crh;
                    wxaLiteAppInfo.type = aVar.yEL;
                    wxaLiteAppInfo.crj = System.currentTimeMillis() / 1000;
                    wxaLiteAppInfo.cri = gVar.cri;
                    wxaLiteAppInfo.md5 = gVar.pkL;
                    f.ecC();
                    f.b(wxaLiteAppInfo);
                    f.ecC();
                    f.c(wxaLiteAppInfo);
                    if (aVar.yEK != null) {
                        aVar.yEK.a(wxaLiteAppInfo);
                    }
                    AppMethodBeat.o(198861);
                } catch (Exception e2) {
                    h.INSTANCE.n(1293, 98, 1);
                    h.INSTANCE.a(20752, "2", true, true);
                    if (aVar.yEK != null) {
                        aVar.yEK.dTu();
                    }
                    Log.printErrStackTrace("MicroMsg.LiteAppDownloadPkg", e2, "", new Object[0]);
                    AppMethodBeat.o(198861);
                }
            } catch (Exception e3) {
                h.INSTANCE.a(20752, "1", true, true);
                h.INSTANCE.n(1293, 98, 1);
                if (aVar.yEK != null) {
                    aVar.yEK.dTu();
                }
                Log.printErrStackTrace("MicroMsg.LiteAppDownloadPkg", e3, "unzip", new Object[0]);
                AppMethodBeat.o(198861);
            }
        }

        @Override // com.tencent.mm.plugin.downloader.model.m
        public final void b(long j2, int i2, boolean z) {
            AppMethodBeat.i(198862);
            if (!e.this.yEF.containsKey(Long.valueOf(j2))) {
                AppMethodBeat.o(198862);
                return;
            }
            Log.e("MicroMsg.LiteAppDownloadPkg", "down fail, id:".concat(String.valueOf(j2)));
            h.INSTANCE.a(20752, AppEventsConstants.EVENT_PARAM_VALUE_NO, true, true);
            h.INSTANCE.n(1293, 95, 1);
            a aVar = e.this.yEF.get(Long.valueOf(j2));
            e.this.yEF.remove(Long.valueOf(j2));
            if (aVar.yEK != null) {
                aVar.yEK.dTu();
            }
            AppMethodBeat.o(198862);
        }

        @Override // com.tencent.mm.plugin.downloader.model.m
        public final void Bd(long j2) {
            AppMethodBeat.i(198863);
            e.this.yEF.remove(Long.valueOf(j2));
            AppMethodBeat.o(198863);
        }

        @Override // com.tencent.mm.plugin.downloader.model.m
        public final void Be(long j2) {
        }

        @Override // com.tencent.mm.plugin.downloader.model.m
        public final void a(long j2, String str, long j3, long j4) {
        }

        @Override // com.tencent.mm.plugin.downloader.model.m
        public final void l(long j2, String str) {
        }

        @Override // com.tencent.mm.plugin.downloader.model.m
        public final void Bf(long j2) {
        }
    };

    public static e valueOf(String str) {
        AppMethodBeat.i(198865);
        e eVar = (e) Enum.valueOf(e.class, str);
        AppMethodBeat.o(198865);
        return eVar;
    }

    static {
        AppMethodBeat.i(198869);
        AppMethodBeat.o(198869);
    }

    /* access modifiers changed from: package-private */
    public class a {
        public g yEJ;
        public com.tencent.mm.plugin.lite.launch.a yEK;
        public String yEL;

        public a(g gVar, String str, com.tencent.mm.plugin.lite.launch.a aVar) {
            this.yEJ = gVar;
            this.yEL = str;
            this.yEK = aVar;
        }
    }

    private e(String str) {
        AppMethodBeat.i(198866);
        f.cBv();
        c.a(this.yEG);
        AppMethodBeat.o(198866);
    }

    public static void ix(String str, String str2) {
        ZipInputStream zipInputStream;
        AppMethodBeat.i(198867);
        try {
            zipInputStream = new ZipInputStream(s.openRead(str));
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        String name = nextEntry.getName();
                        if (!name.contains("../") && !name.contains("..\\")) {
                            if (nextEntry.isDirectory()) {
                                o oVar = new o(str2 + FilePathGenerator.ANDROID_DIR_SEP + name.substring(0, name.length() - 1));
                                if (oVar.isFile()) {
                                    oVar.delete();
                                }
                                oVar.mkdirs();
                            } else {
                                o oVar2 = new o(str2 + FilePathGenerator.ANDROID_DIR_SEP + name);
                                o heq = oVar2.heq();
                                if (!heq.exists()) {
                                    heq.mkdirs();
                                }
                                OutputStream ap = s.ap(oVar2);
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = zipInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    ap.write(bArr, 0, read);
                                }
                                ap.close();
                            }
                        }
                    } else {
                        aa.closeQuietly(zipInputStream);
                        AppMethodBeat.o(198867);
                        return;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        AppMethodBeat.o(198867);
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        aa.closeQuietly(zipInputStream);
                        AppMethodBeat.o(198867);
                        throw th;
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
            zipInputStream = null;
            AppMethodBeat.o(198867);
            throw e;
        } catch (Throwable th2) {
            th = th2;
            zipInputStream = null;
            aa.closeQuietly(zipInputStream);
            AppMethodBeat.o(198867);
            throw th;
        }
    }

    public final void a(g gVar, String str, com.tencent.mm.plugin.lite.launch.a aVar) {
        AppMethodBeat.i(198868);
        h.INSTANCE.n(1293, 93, 1);
        g.a aVar2 = new g.a();
        aVar2.alj(gVar.pkK);
        aVar2.all(gVar.pkL);
        aVar2.Fl(2);
        aVar2.kT(false);
        this.yEF.put(Long.valueOf(f.cBv().a(aVar2.qIY)), new a(gVar, str, aVar));
        AppMethodBeat.o(198868);
    }
}
