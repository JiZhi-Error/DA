package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.View;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.a.n;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.protocal.protobuf.fdz;
import com.tencent.mm.protocal.protobuf.fei;
import org.json.JSONObject;

public final class t extends n {
    public fei xdP;
    public fdz xee;
    private a xef = new a();

    public t(int i2) {
        super(i2);
        AppMethodBeat.i(112131);
        AppMethodBeat.o(112131);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a, com.tencent.mm.plugin.fts.ui.a.n
    public final void a(Context context, a.AbstractC1374a aVar, Object... objArr) {
        AppMethodBeat.i(112132);
        super.a(context, aVar, objArr);
        try {
            if ("HOME".equals(new JSONObject(this.xdP.NzC).optString(FirebaseAnalytics.b.CONTENT_TYPE, ""))) {
                gE(2, 0);
                AppMethodBeat.o(112132);
                return;
            }
            gE(1, 0);
            AppMethodBeat.o(112132);
        } catch (Exception e2) {
            AppMethodBeat.o(112132);
        }
    }

    public class a extends n.b {
        public a() {
            super();
        }

        @Override // com.tencent.mm.plugin.fts.ui.a.n.b, com.tencent.mm.plugin.fts.a.d.a.a.b
        public final boolean a(Context context, View view, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(235408);
            ((h) g.af(h.class)).b(context, 60, "", t.this.wWd.wWB);
            AppMethodBeat.o(235408);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a, com.tencent.mm.plugin.fts.ui.a.n
    public final a.b axc() {
        return this.xef;
    }
}
