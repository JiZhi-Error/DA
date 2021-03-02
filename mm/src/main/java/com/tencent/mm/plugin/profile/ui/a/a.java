package com.tencent.mm.plugin.profile.ui.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.br.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.profile.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;

public final class a implements i {
    b BiP;
    private MTimerHandler BiQ = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.profile.ui.a.a.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(27422);
            if (!a.this.dKq.isFinishing()) {
                a aVar = a.this;
                Activity activity = a.this.dKq;
                a.this.dKq.getString(R.string.zb);
                aVar.wSy = h.a((Context) activity, a.this.dKq.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.profile.ui.a.a.AnonymousClass1.AnonymousClass1 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(27421);
                        bg.azz().a(a.this.BiP);
                        a.this.wSy = null;
                        AppMethodBeat.o(27421);
                    }
                });
            }
            AppMethodBeat.o(27422);
            return false;
        }
    }, false);
    Activity dKq;
    q wSy;

    public a(Activity activity) {
        AppMethodBeat.i(27423);
        this.dKq = activity;
        AppMethodBeat.o(27423);
    }

    public final void jx(String str, String str2) {
        AppMethodBeat.i(27424);
        if (str == null) {
            Log.e("MicroMsg.ViewTWeibo", "null weibo id");
            AppMethodBeat.o(27424);
            return;
        }
        bg.azz().a(205, this);
        this.BiP = new b(Util.nullAsNil(str).replace("http://t.qq.com/", "").trim(), str2);
        bg.azz().a(this.BiP, 0);
        this.BiQ.startTimer(3000);
        AppMethodBeat.o(27424);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(27425);
        bg.azz().b(205, this);
        b bVar = (b) qVar;
        if (i2 == 0 && i3 == 0) {
            openWebView(bVar.getURL());
            AppMethodBeat.o(27425);
            return;
        }
        if (i2 != 4) {
            Log.e("MicroMsg.ViewTWeibo", "view weibo failed: " + i2 + ", " + i3);
        }
        openWebView("http://t.qq.com/" + bVar.BcV);
        AppMethodBeat.o(27425);
    }

    private void openWebView(String str) {
        AppMethodBeat.i(27426);
        this.BiQ.stopTimer();
        if (this.wSy != null) {
            this.wSy.dismiss();
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.putExtra("title", this.dKq.getString(R.string.bhq));
        intent.putExtra("zoom", true);
        intent.putExtra("vertical_scroll", false);
        c.b(this.dKq, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(27426);
    }
}
