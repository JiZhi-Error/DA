package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.cd;
import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import java.util.List;

public final class d extends a {
    public d() {
        super(9);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.b.a
    public final void a(Context context, g gVar, m mVar) {
        AppMethodBeat.i(78686);
        boolean z = gVar.mParams.getBoolean("is_favorite_item", false);
        boolean z2 = gVar.mParams.getBoolean("key_detail_can_delete", true);
        if (z && z2) {
            mVar.b(9, context.getString(R.string.tf), R.raw.bottomsheet_icon_del);
        }
        AppMethodBeat.o(78686);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.b.a
    public final void a(Context context, final g gVar) {
        AppMethodBeat.i(78687);
        h.a(context, context.getString(R.string.th), (List<String>) null, (List<Integer>) null, context.getString(R.string.tf), new h.e() {
            /* class com.tencent.mm.plugin.webview.luggage.b.d.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.h.e
            public final void cy(int i2, int i3) {
                AppMethodBeat.i(78685);
                switch (i3) {
                    case -1:
                        Bundle bundle = new Bundle();
                        bundle.putLong("fav_local_id", gVar.mParams.getLong("fav_local_id", -1));
                        FavUrlTask favUrlTask = new FavUrlTask();
                        favUrlTask.actionType = 4;
                        favUrlTask.dQL = bundle;
                        AppBrandMainProcessService.b(favUrlTask);
                        if (favUrlTask.result) {
                            gVar.hb(true);
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(78685);
            }
        });
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(cd.CTRL_INDEX, 3);
        AppMethodBeat.o(78687);
    }
}
