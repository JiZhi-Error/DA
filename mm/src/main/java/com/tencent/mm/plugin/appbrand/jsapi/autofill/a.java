package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class a extends ClickableSpan {
    private String lId;
    private int lIe = MMApplicationContext.getContext().getResources().getColor(R.color.Link);

    public a(String str) {
        AppMethodBeat.i(46107);
        this.lId = str;
        AppMethodBeat.o(46107);
    }

    public final void updateDrawState(TextPaint textPaint) {
        AppMethodBeat.i(46108);
        super.updateDrawState(textPaint);
        textPaint.setColor(this.lIe);
        textPaint.setUnderlineText(false);
        AppMethodBeat.o(46108);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(46109);
        if (Util.isNullOrNil(this.lId)) {
            Log.e("MicroMsg.ExposeSpan", "exposeUrl is null, return");
            AppMethodBeat.o(46109);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.lId);
        intent.putExtra("forceHideShare", true);
        c.b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        Log.d("MicroMsg.ExposeSpan", "expose click, exposeUrl:%s", this.lId);
        AppMethodBeat.o(46109);
    }
}
