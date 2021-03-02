package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.TbsListener;

public class bf extends bs<g> {
    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "setFontSizeCallback";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
        AppMethodBeat.i(210957);
        int optInt = aVar.ctb.csi.optInt("fontSize");
        CONTEXT context = aVar.cta;
        Log.i("MicroMsg.LuggageMMWebPage", "localSetFontSize, fontSize = ".concat(String.valueOf(optInt)));
        switch (optInt) {
            case 1:
                context.ITd.getSettings().setTextZoom(80);
                break;
            case 2:
                context.ITd.getSettings().setTextZoom(100);
                break;
            case 3:
                context.ITd.getSettings().setTextZoom(110);
                break;
            case 4:
                context.ITd.getSettings().setTextZoom(112);
                break;
            case 5:
                context.ITd.getSettings().setTextZoom(112);
                break;
            case 6:
                context.ITd.getSettings().setTextZoom(140);
                break;
            case 7:
                context.ITd.getSettings().setTextZoom(155);
                break;
            case 8:
                context.ITd.getSettings().setTextZoom(TbsListener.ErrorCode.STARTDOWNLOAD_6);
                break;
            default:
                context.ITd.getSettings().setTextZoom(100);
                break;
        }
        Log.i("MicroMsg.JsApiSetFrontSizeCallback", "doSetFontSizeCb, fontSize = ".concat(String.valueOf(optInt)));
        aVar.c("", null);
        AppMethodBeat.o(210957);
    }
}
