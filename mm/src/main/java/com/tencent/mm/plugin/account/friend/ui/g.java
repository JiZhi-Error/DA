package com.tencent.mm.plugin.account.friend.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.account.friend.a.ak;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;

public final class g implements i {
    private Context context;
    private ProgressDialog iLh;
    a khG;
    private boolean khH = true;
    String khI = "";

    public interface a {
        void i(boolean z, String str);
    }

    public g(Context context2, a aVar) {
        this.context = context2;
        this.khG = aVar;
        this.khH = true;
    }

    public g(Context context2, a aVar, byte b2) {
        this.context = context2;
        this.khG = aVar;
        this.khH = false;
    }

    public final void t(int[] iArr) {
        AppMethodBeat.i(131310);
        com.tencent.mm.kernel.g.azz().a(116, this);
        final ak akVar = new ak(iArr);
        com.tencent.mm.kernel.g.azz().a(akVar, 0);
        if (this.khH) {
            Context context2 = this.context;
            this.context.getString(R.string.e4m);
            this.iLh = h.a(context2, this.context.getString(R.string.e4k), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.account.friend.ui.g.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(131308);
                    com.tencent.mm.kernel.g.azz().a(akVar);
                    g.this.khG.i(false, g.this.khI);
                    AppMethodBeat.o(131308);
                }
            });
        }
        AppMethodBeat.o(131310);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(131311);
        if (qVar.getType() != 116) {
            AppMethodBeat.o(131311);
            return;
        }
        if (this.iLh != null) {
            this.iLh.dismiss();
            this.iLh = null;
        }
        com.tencent.mm.kernel.g.azz().b(116, this);
        if (i2 == 0 && i3 == 0) {
            Log.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailSuccess");
            if (this.khH) {
                h.a(this.context, (int) R.string.e4j, (int) R.string.zb, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.friend.ui.g.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(131309);
                        g.this.khG.i(true, g.this.khI);
                        AppMethodBeat.o(131309);
                    }
                });
                AppMethodBeat.o(131311);
                return;
            }
            this.khG.i(true, this.khI);
            AppMethodBeat.o(131311);
            return;
        }
        Log.i("MicroMsg.SendInviteEmail", "dealSendInviteEmailFail");
        this.khG.i(false, this.khI);
        AppMethodBeat.o(131311);
    }
}
