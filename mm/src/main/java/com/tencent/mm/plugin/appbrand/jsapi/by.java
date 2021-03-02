package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.protocal.protobuf.dyq;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import org.json.JSONObject;

public final class by extends d<s> {
    public static final int CTRL_INDEX = 247;
    public static final String NAME = "openDeliveryList";
    private static final String lAZ = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + "/bizmall/expressentry");

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(147139);
        s sVar2 = sVar;
        String optString = jSONObject.optString(SearchIntents.EXTRA_QUERY);
        if (!Util.isNullOrNil(optString)) {
            String str = lAZ + optString;
            dyq dyq = new dyq();
            dyq.MYe = true;
            dyq.MYd = true;
            Context context = sVar2.getContext();
            if (context != null) {
                ((ag) sVar2.M(ag.class)).a(context, str, dyq);
                sVar2.i(i2, h("ok", null));
                AppMethodBeat.o(147139);
                return;
            }
        }
        sVar2.i(i2, h("fail", null));
        AppMethodBeat.o(147139);
    }

    static {
        AppMethodBeat.i(229889);
        AppMethodBeat.o(229889);
    }
}
