package com.tencent.mm.plugin.wallet_core;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.b;
import com.tencent.mm.plugin.wxpaysdk.api.c;

public final class a implements c {
    @Override // com.tencent.mm.plugin.wxpaysdk.api.c
    public final com.tencent.mm.pluginsdk.b.a hK(Context context) {
        AppMethodBeat.i(69863);
        b bVar = new b(context);
        AppMethodBeat.o(69863);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.wxpaysdk.api.c
    public final com.tencent.mm.pluginsdk.b.a hL(Context context) {
        AppMethodBeat.i(214159);
        com.tencent.mm.plugin.wallet_core.ui.a aVar = new com.tencent.mm.plugin.wallet_core.ui.a(context);
        AppMethodBeat.o(214159);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.wxpaysdk.api.c
    public final void h(Activity activity, Bundle bundle) {
        AppMethodBeat.i(163871);
        bundle.putInt("real_name_verify_mode", 2);
        com.tencent.mm.wallet_core.a.a(activity, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle);
        AppMethodBeat.o(163871);
    }
}
