package com.tencent.mm.plugin.scanner.box;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/ScanBoxTemplateManager;", "", "()V", "TAG", "", "getImageOcrTemplateHtmlFile", "getScanGoodsTemplateHtmlFile", "plugin-scan_release"})
public final class o {
    public static final o CDl = new o();

    static {
        AppMethodBeat.i(52135);
        AppMethodBeat.o(52135);
    }

    private o() {
    }

    public static String ePx() {
        AppMethodBeat.i(240300);
        at afr = ai.afr(4);
        p.g(afr, "WebSearchApiLogic.getSea…TEMPLATE_TYPE_SCAN_GOODS)");
        String fYv = afr.fYv();
        Log.v("MicroMsg.ScanBoxTemplateManager", "alvinluo getScanGoodsTemplateHtmlFile: %s", fYv);
        p.g(fYv, "htmlPath");
        AppMethodBeat.o(240300);
        return fYv;
    }

    public static String ePy() {
        AppMethodBeat.i(240301);
        at afr = ai.afr(8);
        p.g(afr, "WebSearchApiLogic.getSea….TEMPLATE_TYPE_IMAGE_OCR)");
        String fYv = afr.fYv();
        Log.v("MicroMsg.ScanBoxTemplateManager", "alvinluo getImageOcrTemplateHtmlFile templateHtmlPath: %s", fYv);
        p.g(fYv, "htmlPath");
        AppMethodBeat.o(240301);
        return fYv;
    }
}
