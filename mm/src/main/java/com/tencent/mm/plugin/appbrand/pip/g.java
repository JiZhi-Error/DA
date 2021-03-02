package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.lp;
import com.tencent.mm.plugin.appbrand.jsapi.s.b;
import com.tencent.mm.sdk.platformtools.Log;

public enum g implements d {
    INSTANCE;

    public static g valueOf(String str) {
        AppMethodBeat.i(227356);
        g gVar = (g) Enum.valueOf(g.class, str);
        AppMethodBeat.o(227356);
        return gVar;
    }

    static {
        AppMethodBeat.i(227361);
        AppMethodBeat.o(227361);
    }

    @Override // com.tencent.mm.plugin.appbrand.pip.d
    public final void a(c cVar, b.a aVar) {
        int i2 = 1;
        AppMethodBeat.i(227357);
        Log.d("MicroMsg.AppBrand.AppBrandPipReporter", "onVideoSupportPip, baseInfo: %s, mode: %s", cVar, aVar);
        lp a2 = a(cVar);
        a2.eZk = 1;
        switch (aVar) {
            case PUSH:
                break;
            case POP:
                i2 = 2;
                break;
            case PUSH_AND_POP:
                i2 = 3;
                break;
            default:
                i2 = 0;
                break;
        }
        a2.eZl = (long) i2;
        a2.bfK();
        AppMethodBeat.o(227357);
    }

    @Override // com.tencent.mm.plugin.appbrand.pip.d
    public final void b(c cVar, b.a aVar) {
        long j2;
        AppMethodBeat.i(227358);
        Log.d("MicroMsg.AppBrand.AppBrandPipReporter", "onPipShow, baseInfo: %s, mode: %s", cVar, aVar);
        lp a2 = a(cVar);
        if (b.a.PUSH == aVar) {
            j2 = 2;
        } else {
            j2 = 3;
        }
        a2.eZk = j2;
        a2.bfK();
        AppMethodBeat.o(227358);
    }

    @Override // com.tencent.mm.plugin.appbrand.pip.d
    public final void a(c cVar, e eVar) {
        int i2;
        int i3 = 4;
        AppMethodBeat.i(227359);
        Log.d("MicroMsg.AppBrand.AppBrandPipReporter", "onPipHide, baseInfo: %s, hideReason: %s", cVar, eVar);
        lp a2 = a(cVar);
        switch (eVar) {
            case PIP_CLICKED:
                i2 = 4;
                break;
            case PIP_CLOSE_BUTTON_CLICKED:
                i2 = 5;
                break;
            default:
                i2 = 6;
                break;
        }
        a2.eZk = (long) i2;
        if (6 == i2) {
            switch (eVar) {
                case OTHER_VIDEO_AUTO_PLAY:
                    i3 = 1;
                    break;
                case OTHER_VIDEO_PLAY:
                    i3 = 2;
                    break;
                case PAGE_RE_LAUNCH:
                    i3 = 3;
                    break;
                case EXIT_PIP_CALLED:
                    break;
                default:
                    i3 = 0;
                    break;
            }
            a2.eZl = (long) i3;
        }
        a2.bfK();
        AppMethodBeat.o(227359);
    }

    private static lp a(c cVar) {
        AppMethodBeat.i(227360);
        lp yY = new lp().yW(cVar.appId).yX(cVar.dCx).yY(cVar.videoUrl);
        AppMethodBeat.o(227360);
        return yY;
    }
}
