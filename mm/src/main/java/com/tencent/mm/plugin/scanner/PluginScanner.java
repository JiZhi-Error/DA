package com.tencent.mm.plugin.scanner;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.b;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.scanner.model.v;
import com.tencent.mm.plugin.scanner.util.g;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.y;
import com.tencent.qbar.a;
import com.tencent.qbar.e;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class PluginScanner extends f implements c, f {
    private static final IListener<cs> CzS = new IListener<cs>() {
        /* class com.tencent.mm.plugin.scanner.PluginScanner.AnonymousClass1 */

        {
            AppMethodBeat.i(240707);
            this.__eventId = cs.class.getName().hashCode();
            AppMethodBeat.o(240707);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(cs csVar) {
            AppMethodBeat.i(240709);
            boolean a2 = a(csVar);
            AppMethodBeat.o(240709);
            return a2;
        }

        private boolean a(cs csVar) {
            AppMethodBeat.i(240708);
            if (Util.isNullOrNil(csVar.dFQ.path)) {
                Log.e("MicroMsg.PluginScanner", "[-] img path is null or empty.");
                csVar.dFR.dFS = null;
                AppMethodBeat.o(240708);
            } else {
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                final String[][] strArr = {null};
                e.hki().a(MMApplicationContext.getContext(), System.currentTimeMillis(), csVar.dFQ.path, new e.b() {
                    /* class com.tencent.mm.plugin.scanner.PluginScanner.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.qbar.e.b
                    public final void a(long j2, e.d dVar) {
                        AppMethodBeat.i(240706);
                        if (dVar.CGY != null) {
                            String[] strArr = new String[dVar.CGY.size()];
                            int i2 = 0;
                            for (a.C2180a aVar : dVar.CGY) {
                                strArr[i2] = aVar.data;
                                i2++;
                            }
                            synchronized (strArr) {
                                try {
                                    strArr[0] = strArr;
                                } catch (Throwable th) {
                                    AppMethodBeat.o(240706);
                                    throw th;
                                }
                            }
                        }
                        countDownLatch.countDown();
                        AppMethodBeat.o(240706);
                    }
                });
                try {
                    countDownLatch.await(5, TimeUnit.SECONDS);
                } catch (Throwable th) {
                    Log.printErrStackTrace("MicroMsg.PluginScanner", th, "[-] Timeout when wait for decoding.", new Object[0]);
                    String[] strArr2 = {"<timeout>"};
                    csVar.dFR.dFS = strArr2;
                    csVar.dFR.isTimeout = true;
                }
                synchronized (strArr) {
                    try {
                        if (strArr[0] == null || strArr[0].length <= 0) {
                            csVar.dFR.dFS = null;
                        } else {
                            csVar.dFR.dFS = strArr[0];
                        }
                    } finally {
                        AppMethodBeat.o(240708);
                    }
                }
            }
            return false;
        }
    };
    private p CzR = new p();

    public PluginScanner() {
        AppMethodBeat.i(51554);
        AppMethodBeat.o(51554);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(240710);
        EventCenter.instance.add(CzS);
        y.b("ImageSearchFilePath", "image_search_temp/", 259200000, 68);
        AppMethodBeat.o(240710);
    }

    static {
        AppMethodBeat.i(240711);
        AppMethodBeat.o(240711);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(51555);
        b.bfQ("scanner");
        pin(new com.tencent.mm.model.y(j.class));
        if (gVar.aBb()) {
            v vVar = v.CFW;
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.h(context, "context");
            o oVar = new o(v.cF(context));
            if (!oVar.exists()) {
                oVar.mkdirs();
            }
            v.j(context, "scan_goods/center_det.bin", v.cF(context) + "center_det.bin");
            v.j(context, "scan_goods/center_det.param", v.cF(context) + "center_det.param");
            com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.scanner.api.c.class, new com.tencent.mm.plugin.scanner.g.b());
            com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.scanner.api.b.class, new com.tencent.mm.plugin.scanner.g.a());
            g.a aVar = com.tencent.mm.plugin.scanner.util.g.CTH;
            com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.scanner.util.g(), "//scan");
            com.tencent.mm.plugin.scanner.box.a.a.a aVar2 = com.tencent.mm.plugin.scanner.box.a.a.a.CDH;
            com.tencent.mm.plugin.webview.d.o oVar2 = com.tencent.mm.plugin.webview.d.o.ISi;
            com.tencent.mm.plugin.webview.d.o.bM((Map) com.tencent.mm.plugin.scanner.box.a.a.a.CDG.getValue());
            AppMethodBeat.o(51555);
        } else if (gVar.FY(":tools")) {
            com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.scanner.api.c.class, new com.tencent.mm.plugin.scanner.g.b());
            AppMethodBeat.o(51555);
        } else {
            if (gVar.FZ(":appbrand")) {
                com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.scanner.api.c.class, new com.tencent.mm.plugin.scanner.g.b());
            }
            AppMethodBeat.o(51555);
        }
    }

    @Override // com.tencent.mm.plugin.scanner.f
    public p getScanCdnService() {
        return this.CzR;
    }

    @Override // com.tencent.mm.plugin.scanner.f
    public String getAccScannerPath() {
        AppMethodBeat.i(51556);
        j.eOR();
        String accScannerPath = j.getAccScannerPath();
        AppMethodBeat.o(51556);
        return accScannerPath;
    }

    @Override // com.tencent.mm.plugin.scanner.f
    public String getScanImageSaveDir() {
        AppMethodBeat.i(51557);
        j.eOR();
        String scanImageSaveDir = j.getScanImageSaveDir();
        AppMethodBeat.o(51557);
        return scanImageSaveDir;
    }

    @Override // com.tencent.mm.plugin.scanner.f
    public String genScanCaptureImgPath(String str) {
        AppMethodBeat.i(51558);
        j.eOR();
        String str2 = j.getScanImageSaveDir() + String.format("%s_%d.%s", "capture", Long.valueOf(System.currentTimeMillis()), str);
        AppMethodBeat.o(51558);
        return str2;
    }

    @Override // com.tencent.mm.plugin.scanner.f
    public String genScanTmpImgPath(String str) {
        AppMethodBeat.i(51559);
        j.eOR();
        String genScanTmpImgPath = j.genScanTmpImgPath(str);
        AppMethodBeat.o(51559);
        return genScanTmpImgPath;
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
    }
}
