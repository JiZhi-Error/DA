package com.tencent.luggage.game.d.b;

import com.tencent.luggage.game.widget.input.WAGamePanelInputEditText;
import com.tencent.luggage.game.widget.input.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class f extends d<s> {
    private static final int CTRL_INDEX = 463;
    private static final String NAME = "updateKeyboard";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(130621);
        final s sVar2 = sVar;
        final String optString = jSONObject.optString("value");
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.luggage.game.d.b.f.AnonymousClass1 */

            public final void run() {
                ac currentPageView;
                AppMethodBeat.i(130620);
                if (!sVar2.isRunning() || (currentPageView = sVar2.getCurrentPageView()) == null) {
                    AppMethodBeat.o(130620);
                    return;
                }
                a cd = a.cd(currentPageView.getContentView());
                if (cd != null) {
                    WAGamePanelInputEditText attachedEditText = cd.getAttachedEditText();
                    int maxLength = attachedEditText.getMaxLength();
                    Log.v("MicroMsg.WAGameJsApiUpdateKeyboard", "maxLength(%d).", Integer.valueOf(maxLength));
                    if (!Util.isNullOrNil(optString)) {
                        if (maxLength > 0) {
                            attachedEditText.setText(optString.length() > maxLength ? optString.substring(0, maxLength) : optString);
                        } else {
                            attachedEditText.setText(optString);
                        }
                        attachedEditText.setSelection(attachedEditText.getText().length());
                    } else {
                        attachedEditText.setText("");
                    }
                    sVar2.i(i2, f.this.h("ok", null));
                    AppMethodBeat.o(130620);
                    return;
                }
                sVar2.i(i2, f.this.h("fail", null));
                AppMethodBeat.o(130620);
            }
        });
        AppMethodBeat.o(130621);
    }
}
