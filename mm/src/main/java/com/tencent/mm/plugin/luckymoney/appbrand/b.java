package com.tencent.mm.plugin.luckymoney.appbrand;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI;

public final class b implements a {
    @Override // com.tencent.mm.plugin.luckymoney.appbrand.a
    public final void a(Activity activity, String str, int i2, String str2, int i3) {
        AppMethodBeat.i(174315);
        activity.startActivityForResult(new Intent(activity, WxaLuckyMoneyPrepareUI.class).putExtra("appId", str).putExtra("defaultWishingWord", str2).putExtra("range", i2), i3);
        AppMethodBeat.o(174315);
    }

    @Override // com.tencent.mm.plugin.luckymoney.appbrand.a
    public final void a(Activity activity, String str, String str2, int i2) {
        AppMethodBeat.i(174316);
        activity.startActivityForResult(new Intent(activity, WxaLuckyMoneyReceiveUI.class).putExtra("appId", str2).putExtra("sendId", str), i2);
        AppMethodBeat.o(174316);
    }
}
