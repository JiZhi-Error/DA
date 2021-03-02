package com.tencent.mm.plugin.sns.ad.widget.b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.ui.widget.a.e;

public final class c {
    public final b DBG;
    final SnsInfo DqO;
    public View mContentView;
    public final Context mContext;
    public e oXS;

    public c(Context context, SnsInfo snsInfo, b bVar) {
        this.mContext = context;
        this.DqO = snsInfo;
        this.DBG = bVar;
    }

    public final void dismiss() {
        AppMethodBeat.i(202492);
        try {
            if (this.oXS != null && this.oXS.isShowing()) {
                this.oXS.bMo();
            }
            AppMethodBeat.o(202492);
        } catch (Throwable th) {
            AppMethodBeat.o(202492);
        }
    }
}
