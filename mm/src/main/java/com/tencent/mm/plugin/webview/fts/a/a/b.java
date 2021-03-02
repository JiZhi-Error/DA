package com.tencent.mm.plugin.webview.fts.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.oc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.i;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.fbm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.storage.c;
import java.util.List;

public final class b {
    private static final b IPA = new b();
    private a IPB;

    static {
        AppMethodBeat.i(77984);
        AppMethodBeat.o(77984);
    }

    public static b gaE() {
        return IPA;
    }

    private b() {
    }

    public static boolean a(c cVar) {
        AppMethodBeat.i(77982);
        if ("1".equals(cVar.gzz().get("canPreloadWidget"))) {
            AppMethodBeat.o(77982);
            return true;
        }
        Log.i("WidgetPkgPreDownloadMgr", "abtest close preDownload");
        AppMethodBeat.o(77982);
        return false;
    }

    /* access modifiers changed from: package-private */
    public static class a implements Runnable {
        boolean ifP;
        List<fbm> list;
        MMHandler mHandler;
        int sTB = 0;

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(77981);
            aVar.gaF();
            AppMethodBeat.o(77981);
        }

        public a(List<fbm> list2) {
            this.list = list2;
        }

        public final void run() {
            AppMethodBeat.i(77979);
            try {
                int i2 = this.sTB + 1;
                this.sTB = i2;
                if (i2 > this.list.size()) {
                    Log.i("WidgetPkgPreDownloadMgr", "download over, index %d", Integer.valueOf(this.sTB));
                    this.list = null;
                    Thread.currentThread().interrupt();
                    this.mHandler = null;
                    AppMethodBeat.o(77979);
                    return;
                }
                final fbm fbm = this.list.get(this.sTB - 1);
                Log.i("WidgetPkgPreDownloadMgr", "try to download pkg appid %s, md5 %s", fbm.dNI, fbm.NxJ);
                if (fbm != null) {
                    if (TextUtils.isEmpty(fbm.dNI) || TextUtils.isEmpty(fbm.NxJ) || TextUtils.isEmpty(fbm.BsJ)) {
                        Log.e("WidgetPkgPreDownloadMgr", "invalid appinfo");
                        gaF();
                        AppMethodBeat.o(77979);
                        return;
                    }
                    ((i) g.af(i.class)).a(fbm.dNI, fbm.KXD, fbm.NxJ, fbm.BsJ);
                    if (((i) g.af(i.class)).an(fbm.dNI, fbm.KXD)) {
                        Log.i("WidgetPkgPreDownloadMgr", "pkg exist,run next");
                        gaF();
                        AppMethodBeat.o(77979);
                        return;
                    }
                    Log.i("WidgetPkgPreDownloadMgr", "pkg not exist,starting download");
                    h.INSTANCE.dN(918, 1);
                    final long currentTimeMillis = System.currentTimeMillis();
                    ((i) g.af(i.class)).a(fbm.dNI, fbm.KXD, fbm.BsJ, new j() {
                        /* class com.tencent.mm.plugin.webview.fts.a.a.b.a.AnonymousClass1 */

                        @Override // com.tencent.mm.modelappbrand.j
                        public final void b(boolean z, long j2) {
                            long j3;
                            AppMethodBeat.i(77978);
                            Log.i("WidgetPkgPreDownloadMgr", "down succ %b", Boolean.valueOf(z));
                            if (z) {
                                h.INSTANCE.dN(918, 2);
                            } else {
                                h.INSTANCE.dN(918, 3);
                            }
                            a.a(a.this);
                            oc ocVar = new oc();
                            ocVar.enR = ocVar.x("appid", fbm.dNI, true);
                            ocVar.exo = (long) fbm.KXD;
                            ocVar.fgP = ocVar.x("downloadUrl", fbm.BsJ, true);
                            ocVar.fiT = ocVar.x("pkgMd5", fbm.NxJ, true);
                            ocVar.fiW = System.currentTimeMillis();
                            if (z) {
                                j3 = 1;
                            } else {
                                j3 = 0;
                            }
                            ocVar.fiU = j3;
                            ocVar.fiV = System.currentTimeMillis() - currentTimeMillis;
                            ocVar.fiX = j2;
                            ocVar.bfK();
                            AppMethodBeat.o(77978);
                        }
                    });
                }
                AppMethodBeat.o(77979);
            } catch (Exception e2) {
                Log.printErrStackTrace("WidgetPkgPreDownloadMgr", e2, "", new Object[0]);
                AppMethodBeat.o(77979);
            }
        }

        private void gaF() {
            AppMethodBeat.i(77980);
            this.mHandler.postDelayed(this, 500);
            AppMethodBeat.o(77980);
        }
    }

    static /* synthetic */ void a(b bVar, List list) {
        AppMethodBeat.i(77983);
        if (list == null) {
            Log.i("WidgetPkgPreDownloadMgr", "empty rsp");
            AppMethodBeat.o(77983);
            return;
        }
        if (bVar.IPB != null) {
            bVar.IPB.ifP = true;
        }
        bVar.IPB = new a(list);
        a aVar = bVar.IPB;
        aVar.ifP = false;
        aVar.mHandler = new MMHandler("WidgetPkgPreDownloadMgr");
        aVar.mHandler.post(aVar);
        Log.i("WidgetPkgPreDownloadMgr", "starting download %d app", Integer.valueOf(aVar.list == null ? -1 : aVar.list.size()));
        AppMethodBeat.o(77983);
    }
}
