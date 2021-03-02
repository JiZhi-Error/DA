package com.tencent.mm.plugin.game.model;

import android.content.SharedPreferences;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.b.a;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.m;
import com.tencent.mm.plugin.game.c.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

public final class k implements m {
    private static Set<a> qFF = Collections.synchronizedSet(new HashSet());
    private static k xEJ = null;
    private static HashMap<String, b> xEK = new HashMap<>();

    public interface a {
        void e(int i2, String str, boolean z);
    }

    static {
        AppMethodBeat.i(41432);
        AppMethodBeat.o(41432);
    }

    private k() {
    }

    public static k dVi() {
        AppMethodBeat.i(41412);
        if (xEJ == null) {
            xEJ = new k();
        }
        k kVar = xEJ;
        AppMethodBeat.o(41412);
        return kVar;
    }

    public static void a(a aVar) {
        AppMethodBeat.i(41413);
        synchronized (qFF) {
            try {
                qFF.add(aVar);
            } finally {
                AppMethodBeat.o(41413);
            }
        }
    }

    public static void b(a aVar) {
        AppMethodBeat.i(41414);
        synchronized (qFF) {
            try {
                qFF.remove(aVar);
                Log.d("MicroMsg.GameDownloadEventBus", "removeListener, size:%d, listener:%s", Integer.valueOf(qFF.size()), aVar);
            } finally {
                AppMethodBeat.o(41414);
            }
        }
    }

    public static void cBn() {
        AppMethodBeat.i(41415);
        if (xEJ == null) {
            xEJ = new k();
        }
        com.tencent.mm.plugin.downloader.b.a.a(new a.b() {
            /* class com.tencent.mm.plugin.game.model.k.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.downloader.b.a.b
            public final void O(int i2, long j2) {
                AppMethodBeat.i(41409);
                if (i2 == 9) {
                    k.access$000(j2);
                }
                AppMethodBeat.o(41409);
            }
        });
        f.cBv();
        c.a(xEJ);
        AppMethodBeat.o(41415);
    }

    public static void cBo() {
        AppMethodBeat.i(41416);
        f.cBv();
        c.b(xEJ);
        xEJ = null;
        qFF.clear();
        xEK.clear();
        AppMethodBeat.o(41416);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void P(long r12, final int r14) {
        /*
        // Method dump skipped, instructions count: 250
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.model.k.P(long, int):void");
    }

    /* access modifiers changed from: package-private */
    public static class b {
        String appId = "";
        String dFN = "";
        String md5 = "";
        int scene = 0;
        String xEN = "";
        boolean xEO = false;

        b(String str, int i2, String str2, String str3, String str4) {
            this.md5 = str;
            this.scene = i2;
            this.appId = str2;
            this.xEN = str3;
            this.dFN = str4;
        }
    }

    public static void a(String str, String str2, int i2, String str3, String str4) {
        AppMethodBeat.i(41418);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(41418);
            return;
        }
        b bVar = new b(str2, i2, str3, "", str4);
        bVar.xEO = true;
        xEK.put(str, bVar);
        AppMethodBeat.o(41418);
    }

    public static void r(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(41419);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(41419);
            return;
        }
        xEK.put(str, new b(str2, 1002, str3, "", str4));
        AppMethodBeat.o(41419);
    }

    public static void a(String str, String str2, int i2, String str3, String str4, String str5) {
        AppMethodBeat.i(41420);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(41420);
            return;
        }
        xEK.put(str, new b(str2, i2, str3, str4, str5));
        AppMethodBeat.o(41420);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void k(long j2, String str) {
        AppMethodBeat.i(41421);
        P(j2, 1);
        com.tencent.mm.plugin.game.c.c cVar = com.tencent.mm.plugin.game.c.c.xvR;
        com.tencent.mm.plugin.game.c.c.report(j2);
        AppMethodBeat.o(41421);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void b(long j2, String str, boolean z) {
        com.tencent.mm.plugin.downloader.g.a Cw;
        AppMethodBeat.i(41422);
        Log.i("MicroMsg.GameDownloadEventBus", "onTaskFinished, path = %s, fileExists = %b", str, Boolean.valueOf(s.YS(str)));
        if (Util.isNullOrNil(str) || !s.YS(str)) {
            com.tencent.mm.plugin.downloader.g.a Cw2 = d.Cw(j2);
            if (Cw2 != null) {
                Cw2.field_status = 4;
                Cw2.field_errCode = com.tencent.mm.plugin.downloader.a.a.qFv;
                d.e(Cw2);
            }
            b(j2, com.tencent.mm.plugin.downloader.a.a.qFv, z);
            if (Cw2 != null) {
                com.tencent.mm.plugin.downloader.f.a.aa(Cw2.field_appId, 9);
            }
            AppMethodBeat.o(41422);
            return;
        }
        P(j2, 3);
        if (z && (Cw = d.Cw(j2)) != null) {
            com.tencent.mm.game.report.api.a.hhr.c(Cw.field_appId, 5, 0, null, null);
        }
        e.report(j2);
        com.tencent.mm.plugin.game.c.c cVar = com.tencent.mm.plugin.game.c.c.xvR;
        com.tencent.mm.plugin.game.c.c.report(j2);
        AppMethodBeat.o(41422);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void b(long j2, int i2, boolean z) {
        AppMethodBeat.i(41423);
        com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw == null || !Cw.field_downloadInWifi || NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            P(j2, 5);
            d(j2, i2, z);
            e.report(j2);
            com.tencent.mm.plugin.game.c.c cVar = com.tencent.mm.plugin.game.c.c.xvR;
            com.tencent.mm.plugin.game.c.c.report(j2);
            com.tencent.mm.plugin.downloader.model.a.Cm(j2);
            AppMethodBeat.o(41423);
            return;
        }
        Log.i("MicroMsg.GameDownloadEventBus", "wifi pause, return");
        Cw.field_status = 2;
        Cw.field_errCode = 0;
        d.e(Cw);
        com.tencent.mm.plugin.downloader.f.b bVar = new com.tencent.mm.plugin.downloader.f.b();
        bVar.k(Cw);
        com.tencent.mm.plugin.downloader.f.a.a(13, bVar);
        AppMethodBeat.o(41423);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void Bd(long j2) {
        AppMethodBeat.i(41424);
        P(j2, 4);
        com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw != null) {
            e.aL(MMApplicationContext.getContext(), Cw.field_appId);
        }
        com.tencent.mm.plugin.game.c.c cVar = com.tencent.mm.plugin.game.c.c.xvR;
        com.tencent.mm.plugin.game.c.c.report(j2);
        AppMethodBeat.o(41424);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void Be(long j2) {
        AppMethodBeat.i(41425);
        P(j2, 2);
        AppMethodBeat.o(41425);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void a(long j2, String str, long j3, long j4) {
        AppMethodBeat.i(204159);
        P(j2, 6);
        AppMethodBeat.o(204159);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void l(long j2, String str) {
        AppMethodBeat.i(41427);
        P(j2, 7);
        AppMethodBeat.o(41427);
    }

    @Override // com.tencent.mm.plugin.downloader.model.m
    public final void Bf(long j2) {
    }

    private static void d(long j2, int i2, boolean z) {
        AppMethodBeat.i(41428);
        com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
        if (Cw != null) {
            String str = null;
            if (i2 == com.tencent.mm.plugin.downloader.a.a.qFs) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ChannelId", Cw.field_channelId);
                    jSONObject.put("DownloadSize", Cw.field_downloadedSize);
                    str = com.tencent.mm.plugin.game.d.a.Fh(jSONObject.toString());
                    Log.d("MicroMsg.GameDownloadEventBus", "extInfo = " + jSONObject.toString());
                } catch (Exception e2) {
                    Log.e("MicroMsg.GameDownloadEventBus", "reportDownloadFailed, e = " + e2.getMessage());
                }
            }
            a(Cw.field_appId, i2, z, str);
        }
        AppMethodBeat.o(41428);
    }

    public static void a(String str, int i2, boolean z, String str2) {
        int i3;
        AppMethodBeat.i(41429);
        if (i2 == 710 || i2 == 711) {
            i3 = com.tencent.mm.plugin.downloader.a.a.qFu;
        } else {
            i3 = i2;
        }
        Log.i("MicroMsg.GameDownloadEventBus", "appid = %s, errCode = %d", str, Integer.valueOf(i3));
        if (!z) {
            com.tencent.mm.game.report.api.a.hhr.c(str, 2, i3, null, str2);
            AppMethodBeat.o(41429);
            return;
        }
        com.tencent.mm.game.report.api.a.hhr.c(str, 4, i3, null, str2);
        AppMethodBeat.o(41429);
    }

    public static void hK(String str, String str2) {
        AppMethodBeat.i(41430);
        com.tencent.mm.game.report.api.a.hhr.c(str, 6, 0, null, str2);
        AppMethodBeat.o(41430);
    }

    static /* synthetic */ void access$000(final long j2) {
        AppMethodBeat.i(41431);
        h.RTc.a(new Runnable() {
            /* class com.tencent.mm.plugin.game.model.k.AnonymousClass3 */

            public final void run() {
                long j2;
                AppMethodBeat.i(41411);
                com.tencent.mm.plugin.downloader.g.a Cw = d.Cw(j2);
                if (Cw == null) {
                    Log.e("MicroMsg.GameDownloadEventBus", "fInfo is null");
                    AppMethodBeat.o(41411);
                    return;
                }
                if (Cw.field_status == 3) {
                    if (s.YS(Cw.field_filePath)) {
                        Log.i("MicroMsg.GameDownloadEventBus", "onInstallFinish, delete file: %s", Cw.field_filePath);
                        s.deleteFile(Cw.field_filePath);
                    }
                    Log.i("MicroMsg.GameDownloadEventBus", "removeDownloadInfo, appId=" + Cw.field_appId);
                    d.Cx(j2);
                    d.ald(Cw.field_appId);
                    d.alc(Cw.field_downloadUrl);
                    com.tencent.mm.plugin.downloader.f.b bVar = new com.tencent.mm.plugin.downloader.f.b();
                    bVar.k(Cw);
                    com.tencent.mm.plugin.downloader.f.a.a(5, bVar);
                    com.tencent.mm.plugin.downloader.f.a.aa(Cw.field_appId, 8);
                    b bVar2 = (b) k.xEK.get(Cw.field_downloadUrl);
                    if (bVar2 == null) {
                        com.tencent.mm.plugin.downloader.f.a.a(Cw.field_appId, Cw.field_scene, 5, Cw.field_md5, Cw.field_downloadUrl, "", Cw.field_extInfo);
                        AppMethodBeat.o(41411);
                        return;
                    }
                    com.tencent.mm.plugin.downloader.f.a.a(bVar2.appId, bVar2.scene, 5, bVar2.md5, Cw.field_downloadUrl, bVar2.xEN, bVar2.dFN);
                    String str = Cw.field_packageName;
                    SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("install_begin_time", 0);
                    if (sharedPreferences != null) {
                        j2 = sharedPreferences.getLong(str, 0);
                    } else {
                        j2 = 0;
                    }
                    if (System.currentTimeMillis() - j2 <= 600000) {
                        com.tencent.mm.plugin.downloader.f.a.a(17, bVar);
                    }
                }
                AppMethodBeat.o(41411);
            }
        }, 500, "onInstallFinish");
        AppMethodBeat.o(41431);
    }
}
