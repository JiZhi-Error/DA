package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.base.q;
import com.tencent.smtt.sdk.TbsListener;

public final class h implements i {
    MTimerHandler BiQ = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.scanner.ui.h.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(52016);
            h hVar = h.this;
            Context context = h.this.context;
            h.this.context.getString(R.string.zb);
            hVar.wSy = com.tencent.mm.ui.base.h.a(context, h.this.context.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.scanner.ui.h.AnonymousClass1.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(52015);
                    g.azz().a(h.this.CPb);
                    h.this.wSy = null;
                    AppMethodBeat.o(52015);
                }
            });
            AppMethodBeat.o(52016);
            return false;
        }
    }, false);
    l CPb;
    Context context;
    String url;
    q wSy;

    public h(Context context2) {
        AppMethodBeat.i(52017);
        this.context = context2;
        AppMethodBeat.o(52017);
    }

    /* access modifiers changed from: package-private */
    public final void b(String str, int i2, byte[] bArr) {
        AppMethodBeat.i(52018);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        intent.putExtra("geta8key_session_id", i2);
        intent.putExtra("geta8key_cookie", bArr);
        com.tencent.mm.plugin.scanner.h.jRt.i(intent, this.context);
        AppMethodBeat.o(52018);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(52019);
        this.BiQ.stopTimer();
        if (this.wSy != null) {
            this.wSy.dismiss();
        }
        g.azz().b(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, this);
        l lVar = (l) qVar;
        if (i2 == 0 && i3 == 0) {
            String beQ = lVar.beQ();
            if (beQ == null || beQ.length() == 0) {
                b(this.url, lVar.beY(), lVar.bfa());
                AppMethodBeat.o(52019);
                return;
            }
            b(beQ, lVar.beY(), lVar.bfa());
            AppMethodBeat.o(52019);
            return;
        }
        Log.e("MicroMsg.scanner.ViewMMURL", "getA8Key fail, errType = " + i2 + ", errCode = " + i3);
        b(this.url, lVar.beY(), lVar.bfa());
        AppMethodBeat.o(52019);
    }
}
