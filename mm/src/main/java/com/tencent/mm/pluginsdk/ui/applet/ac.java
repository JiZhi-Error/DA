package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.b.p;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.smtt.sdk.TbsListener;

public final class ac implements i {
    private MTimerHandler BiQ = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.pluginsdk.ui.applet.ac.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(31428);
            ac acVar = ac.this;
            Context context = ac.this.context;
            ac.this.context.getString(R.string.zb);
            acVar.wSy = h.a(context, ac.this.context.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.pluginsdk.ui.applet.ac.AnonymousClass1.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(31427);
                    bg.azz().a(ac.this.CPb);
                    ac.this.wSy = null;
                    AppMethodBeat.o(31427);
                }
            });
            AppMethodBeat.o(31428);
            return false;
        }
    }, false);
    l CPb;
    private String Kgo;
    Context context;
    q wSy;

    public ac(Context context2) {
        AppMethodBeat.i(31429);
        this.context = context2;
        AppMethodBeat.o(31429);
    }

    public final void beU(String str) {
        AppMethodBeat.i(31430);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.ViewQZone", "go fail, qqNum is null");
            AppMethodBeat.o(31430);
            return;
        }
        this.Kgo = str;
        bg.aVF();
        String str2 = (String) c.azQ().get(46, (Object) null);
        bg.aVF();
        String nullAsNil = Util.nullAsNil((String) c.azQ().get(72, (Object) null));
        Log.i("MicroMsg.ViewQZone", "get a2key:[%s], get new a2key:[%s]", str2, nullAsNil);
        if (!Util.isNullOrNil(str2) || !Util.isNullOrNil(nullAsNil)) {
            bg.azz().a(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, this);
            this.CPb = new l(p.fd(str), (int) System.currentTimeMillis());
            bg.azz().a(this.CPb, 0);
            this.BiQ.startTimer(3000);
            AppMethodBeat.o(31430);
            return;
        }
        beV(str);
        AppMethodBeat.o(31430);
    }

    private void beV(String str) {
        AppMethodBeat.i(31431);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.context.getString(R.string.bed, str));
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        intent.putExtra("neverGetA8Key", true);
        com.tencent.mm.br.c.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", intent);
        AppMethodBeat.o(31431);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(31432);
        this.BiQ.stopTimer();
        if (this.wSy != null) {
            this.wSy.dismiss();
        }
        bg.azz().b(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, this);
        if (i2 == 0 && i3 == 0) {
            l lVar = (l) qVar;
            String beQ = lVar.beQ();
            if (beQ == null || beQ.length() == 0) {
                beV(this.Kgo);
                AppMethodBeat.o(31432);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", beQ);
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            intent.putExtra("neverGetA8Key", true);
            intent.putExtra("geta8key_session_id", lVar.beY());
            com.tencent.mm.br.c.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", intent);
            AppMethodBeat.o(31432);
            return;
        }
        Log.e("MicroMsg.ViewQZone", "getA8Key fail, errType = " + i2 + ", errCode = " + i3);
        beV(this.Kgo);
        AppMethodBeat.o(31432);
    }
}
