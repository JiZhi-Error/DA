package com.tencent.mm.plugin.scanner.g;

import android.content.Context;
import android.content.Intent;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.api.e;
import com.tencent.mm.plugin.scanner.api.f;
import com.tencent.mm.plugin.scanner.api.g;
import com.tencent.mm.plugin.scanner.i;
import com.tencent.mm.plugin.scanner.model.ac;
import com.tencent.mm.plugin.scanner.ui.BaseScanUI;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010\u0016\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00122\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0016J\u001a\u0010\u001e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\"\u0010\u001f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010 \u001a\u00020!H\u0016J\u001c\u0010\"\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010#\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/scanner/service/ScanServiceImpl;", "Lcom/tencent/mm/plugin/scanner/api/IScanService;", "()V", "imageUploader", "Lcom/tencent/mm/plugin/scanner/model/AiScanImageSceneUploader;", "cancelPreviewImage", "", "session", "", "cancelUploadImage", "createImageOCRHelper", "Lcom/tencent/mm/plugin/scanner/api/ocr/IImageOCRHelper;", "context", "Landroid/content/Context;", "getSearchImagePath", "", "msgId", "canUseThumb", "", "preloadResource", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;", "previewImageForSearch", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageRequest;", "callback", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResultCallback;", "showOCRMenu", "ratioList", "", "", "startScanGoods", "startScanGoodsForResult", "requestCode", "", "uploadImageForOcr", "uploadImageForSearch", "Companion", "plugin-scan_release"})
public final class b implements com.tencent.mm.plugin.scanner.api.c {
    public static final a CIZ = new a((byte) 0);
    private com.tencent.mm.plugin.scanner.model.c CIY;

    static {
        AppMethodBeat.i(240576);
        AppMethodBeat.o(240576);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/scanner/service/ScanServiceImpl$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.scanner.api.c
    public final void a(Context context, ScanGoodsRequest scanGoodsRequest) {
        AppMethodBeat.i(240566);
        p.h(context, "context");
        if (scanGoodsRequest == null) {
            AppMethodBeat.o(240566);
            return;
        }
        Log.i("MicroMsg.ScanServiceImpl", "startScanGoods");
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 12);
        intent.putExtra("key_scan_request", scanGoodsRequest);
        intent.setClass(context, BaseScanUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/scanner/service/ScanServiceImpl", "startScanGoods", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/scanner/service/ScanServiceImpl", "startScanGoods", "(Landroid/content/Context;Lcom/tencent/mm/plugin/scanner/api/ScanGoodsRequest;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(240566);
    }

    @Override // com.tencent.mm.plugin.scanner.api.c
    public final void a(Context context, ScanGoodsRequest scanGoodsRequest, int i2) {
        AppMethodBeat.i(240567);
        p.h(context, "context");
        Log.i("MicroMsg.ScanServiceImpl", "startScanGoodsForResult requestCode: %d", Integer.valueOf(i2));
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 12);
        intent.putExtra("key_scan_request", scanGoodsRequest);
        com.tencent.mm.br.c.a(context, "scanner", ".ui.BaseScanUI", intent, i2, false);
        AppMethodBeat.o(240567);
    }

    @Override // com.tencent.mm.plugin.scanner.api.c
    public final long a(e eVar, g gVar) {
        AppMethodBeat.i(240568);
        eVar.CAT = 1;
        if (eVar.sessionId == 0) {
            eVar.sessionId = System.currentTimeMillis();
        }
        if (this.CIY == null) {
            this.CIY = new com.tencent.mm.plugin.scanner.model.c();
        }
        d dVar = new d(gVar);
        com.tencent.mm.plugin.scanner.model.c cVar = this.CIY;
        if (cVar != null) {
            cVar.a(eVar.sessionId, eVar, dVar);
        }
        long j2 = eVar.sessionId;
        AppMethodBeat.o(240568);
        return j2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "session", "", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onCallback"})
    static final class d implements g {
        final /* synthetic */ g CJa;

        d(g gVar) {
            this.CJa = gVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, java.lang.Object] */
        @Override // com.tencent.mm.plugin.scanner.api.a
        public final /* synthetic */ void c(long j2, f fVar) {
            AppMethodBeat.i(240564);
            a(j2, fVar);
            AppMethodBeat.o(240564);
        }

        @Override // com.tencent.mm.plugin.scanner.api.g
        public final void a(long j2, f fVar) {
            AppMethodBeat.i(240565);
            p.h(fVar, "result");
            Log.i("MicroMsg.ScanServiceImpl", "alvinluo uploadImage onCallback success: %b, imagePath: %s, reqKey: %s, jumpType: %d", Boolean.valueOf(fVar.success), fVar.imagePath, fVar.dDL, Integer.valueOf(fVar.jumpType));
            g gVar = this.CJa;
            if (gVar != null) {
                gVar.a(j2, fVar);
                AppMethodBeat.o(240565);
                return;
            }
            AppMethodBeat.o(240565);
        }
    }

    @Override // com.tencent.mm.plugin.scanner.api.c
    public final long b(e eVar, g gVar) {
        AppMethodBeat.i(240569);
        if (eVar == null) {
            AppMethodBeat.o(240569);
            return 0;
        }
        eVar.CAT = 3;
        if (eVar.sessionId == 0) {
            eVar.sessionId = System.currentTimeMillis();
        }
        if (this.CIY == null) {
            this.CIY = new com.tencent.mm.plugin.scanner.model.c();
        }
        c cVar = new c(gVar);
        com.tencent.mm.plugin.scanner.model.c cVar2 = this.CIY;
        if (cVar2 != null) {
            cVar2.a(eVar.sessionId, eVar, cVar);
        }
        long j2 = eVar.sessionId;
        AppMethodBeat.o(240569);
        return j2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "session", "", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onCallback"})
    static final class c implements g {
        final /* synthetic */ g CJa;

        c(g gVar) {
            this.CJa = gVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, java.lang.Object] */
        @Override // com.tencent.mm.plugin.scanner.api.a
        public final /* synthetic */ void c(long j2, f fVar) {
            AppMethodBeat.i(240562);
            a(j2, fVar);
            AppMethodBeat.o(240562);
        }

        @Override // com.tencent.mm.plugin.scanner.api.g
        public final void a(long j2, f fVar) {
            AppMethodBeat.i(240563);
            p.h(fVar, "result");
            Log.i("MicroMsg.ScanServiceImpl", "alvinluo uploadImageForOcr onCallback success: %b, imagePath: %s, reqKey: %s, jumpType: %d", Boolean.valueOf(fVar.success), fVar.imagePath, fVar.dDL, Integer.valueOf(fVar.jumpType));
            g gVar = this.CJa;
            if (gVar != null) {
                gVar.a(j2, fVar);
                AppMethodBeat.o(240563);
                return;
            }
            AppMethodBeat.o(240563);
        }
    }

    @Override // com.tencent.mm.plugin.scanner.api.c
    public final void Ir(long j2) {
        AppMethodBeat.i(240570);
        com.tencent.mm.plugin.scanner.model.c cVar = this.CIY;
        if (cVar != null) {
            cVar.cancel(j2);
            AppMethodBeat.o(240570);
            return;
        }
        AppMethodBeat.o(240570);
    }

    @Override // com.tencent.mm.plugin.scanner.api.c
    public final String Iq(long j2) {
        AppMethodBeat.i(240571);
        ac acVar = ac.CGB;
        String G = ac.G(j2, false);
        AppMethodBeat.o(240571);
        return G;
    }

    @Override // com.tencent.mm.plugin.scanner.api.c
    public final long c(e eVar, g gVar) {
        AppMethodBeat.i(240572);
        if (eVar == null) {
            AppMethodBeat.o(240572);
            return 0;
        }
        eVar.CAT = 2;
        if (eVar.sessionId == 0) {
            eVar.sessionId = System.currentTimeMillis();
        }
        if (this.CIY == null) {
            this.CIY = new com.tencent.mm.plugin.scanner.model.c();
        }
        C1672b bVar = new C1672b(gVar);
        com.tencent.mm.plugin.scanner.model.c cVar = this.CIY;
        if (cVar != null) {
            cVar.a(eVar.sessionId, eVar, bVar);
        }
        long j2 = eVar.sessionId;
        AppMethodBeat.o(240572);
        return j2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "session", "", "result", "Lcom/tencent/mm/plugin/scanner/api/ScanOpImageResult;", "onCallback"})
    /* renamed from: com.tencent.mm.plugin.scanner.g.b$b  reason: collision with other inner class name */
    static final class C1672b implements g {
        final /* synthetic */ g CJa;

        C1672b(g gVar) {
            this.CJa = gVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [long, java.lang.Object] */
        @Override // com.tencent.mm.plugin.scanner.api.a
        public final /* synthetic */ void c(long j2, f fVar) {
            AppMethodBeat.i(240560);
            a(j2, fVar);
            AppMethodBeat.o(240560);
        }

        @Override // com.tencent.mm.plugin.scanner.api.g
        public final void a(long j2, f fVar) {
            AppMethodBeat.i(240561);
            p.h(fVar, "result");
            Log.i("MicroMsg.ScanServiceImpl", "alvinluo previewImage onCallback success: %b, imagePath: %s, reqKey: %s, jumpType: %d", Boolean.valueOf(fVar.success), fVar.imagePath, fVar.dDL, Integer.valueOf(fVar.jumpType));
            g gVar = this.CJa;
            if (gVar != null) {
                gVar.a(j2, fVar);
                AppMethodBeat.o(240561);
                return;
            }
            AppMethodBeat.o(240561);
        }
    }

    @Override // com.tencent.mm.plugin.scanner.api.c
    public final void Is(long j2) {
        AppMethodBeat.i(240573);
        com.tencent.mm.plugin.scanner.model.c cVar = this.CIY;
        if (cVar != null) {
            cVar.cancel(j2);
            AppMethodBeat.o(240573);
            return;
        }
        AppMethodBeat.o(240573);
    }

    @Override // com.tencent.mm.plugin.scanner.api.c
    public final boolean gy(List<Float> list) {
        AppMethodBeat.i(240574);
        if (list == null) {
            AppMethodBeat.o(240574);
            return false;
        } else if (!com.tencent.mm.plugin.scanner.c.a.ePI() || !i.gx(list)) {
            AppMethodBeat.o(240574);
            return false;
        } else {
            AppMethodBeat.o(240574);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.scanner.api.c
    public final com.tencent.mm.plugin.scanner.api.a.a gT(Context context) {
        AppMethodBeat.i(240575);
        p.h(context, "context");
        com.tencent.mm.plugin.scanner.e.b bVar = new com.tencent.mm.plugin.scanner.e.b(context);
        AppMethodBeat.o(240575);
        return bVar;
    }
}
