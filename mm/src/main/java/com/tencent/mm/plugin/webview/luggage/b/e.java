package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.cd;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.ui.base.m;

public final class e extends a {
    public e() {
        super(12);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.b.a
    public final void a(Context context, g gVar) {
        AppMethodBeat.i(78689);
        Intent intent = new Intent();
        intent.putExtra("key_fav_scene", 2);
        intent.putExtra("key_fav_item_id", gVar.mParams.getLong("fav_local_id", -1));
        b.b(context, ".ui.FavTagEditUI", intent);
        h.INSTANCE.dN(cd.CTRL_INDEX, 1);
        AppMethodBeat.o(78689);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.b.a
    public final void a(Context context, g gVar, m mVar) {
        AppMethodBeat.i(78688);
        boolean z = gVar.mParams.getBoolean("is_favorite_item", false);
        boolean z2 = gVar.mParams.getBoolean("key_detail_can_delete", true);
        if (z && z2) {
            mVar.b(12, context.getString(R.string.c90), R.raw.bottomsheet_icon_addtag);
        }
        AppMethodBeat.o(78688);
    }
}
