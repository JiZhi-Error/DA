package com.tencent.mm.plugin.favorite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.pluginsdk.ui.tools.a;

public final class e implements ab {
    @Override // com.tencent.mm.plugin.fav.a.ab
    public final int a(WXMediaMessage wXMediaMessage, String str, String str2, String str3) {
        AppMethodBeat.i(24603);
        int a2 = m.a(wXMediaMessage, str, str2, str3, 3, (String) null);
        AppMethodBeat.o(24603);
        return a2;
    }

    @Override // com.tencent.mm.plugin.fav.a.ab
    public final int a(k.b bVar, WXMediaMessage wXMediaMessage, String str) {
        AppMethodBeat.i(24604);
        int a2 = m.a(bVar, wXMediaMessage, str, 0, null);
        AppMethodBeat.o(24604);
        return a2;
    }

    @Override // com.tencent.mm.plugin.fav.a.ab
    public final void b(Activity activity, String str, String str2) {
        AppMethodBeat.i(24605);
        a.b(activity, str, str2, 2);
        AppMethodBeat.o(24605);
    }

    @Override // com.tencent.mm.plugin.fav.a.ab
    public final void c(Activity activity, int i2, int i3, Intent intent) {
        AppMethodBeat.i(24606);
        a.a(activity, i2, i3, intent, true, (int) R.string.fds, (int) R.string.fdt, 2);
        AppMethodBeat.o(24606);
    }

    @Override // com.tencent.mm.plugin.fav.a.ab
    public final int asd(String str) {
        AppMethodBeat.i(24607);
        int bdt = r.bdt(str);
        AppMethodBeat.o(24607);
        return bdt;
    }

    @Override // com.tencent.mm.plugin.fav.a.ab
    public final void a(Context context, String str, g gVar, boolean z, y.a aVar) {
        AppMethodBeat.i(24608);
        o.a aVar2 = new o.a(context);
        aVar2.ea(str);
        d.a(aVar2, context, gVar);
        d.b(aVar2, context, gVar);
        aVar2.p(Boolean.valueOf(z)).aii(R.string.yq).a(aVar).kdo.show();
        AppMethodBeat.o(24608);
    }
}
