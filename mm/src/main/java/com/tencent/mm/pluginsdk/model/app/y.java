package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.Log;

public final class y implements u {
    public a JWu;
    q dGJ;
    public Context mContext;
    public com.tencent.mm.ui.base.q tipDialog;

    public interface a {
        void onFinished();
    }

    public y(Context context, a aVar) {
        this.mContext = context;
        this.JWu = aVar;
    }

    @Override // com.tencent.mm.pluginsdk.model.app.u
    public final void a(int i2, int i3, String str, aa aaVar) {
        AppMethodBeat.i(151803);
        Log.i("MicroMsg.LoadAppInfoAfterLogin", "OnScenEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        com.tencent.mm.plugin.r.a.eAV().b(7, this);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (this.JWu != null) {
            this.JWu.onFinished();
        }
        q.gna();
        AppMethodBeat.o(151803);
    }
}
