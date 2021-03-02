package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.WechatNativeExtraDataInvokeFunctionalPage;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApiInterceptor;", "", "()V", "APIs", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalDirectApi;", "Lkotlin/collections/HashMap;", "TAG", "shouldIntercept", "", "context", "Landroid/content/Context;", "invokeArgs", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "appOpenBundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "plugin-appbrand-integration_release"})
public final class c {
    private static final HashMap<String, b> nbl;
    public static final c nbm = new c();

    static {
        AppMethodBeat.i(228894);
        HashMap<String, b> hashMap = new HashMap<>();
        b[] bVarArr = {new e(), new f(), new g()};
        for (int i2 = 0; i2 < 3; i2++) {
            b bVar = bVarArr[i2];
            hashMap.put(bVar.bOK(), bVar);
        }
        nbl = hashMap;
        AppMethodBeat.o(228894);
    }

    private c() {
    }

    public static final boolean a(Context context, WechatNativeExtraDataInvokeFunctionalPage wechatNativeExtraDataInvokeFunctionalPage, g gVar) {
        AppMethodBeat.i(228893);
        p.h(context, "context");
        p.h(wechatNativeExtraDataInvokeFunctionalPage, "invokeArgs");
        p.h(gVar, "appOpenBundle");
        b bVar = nbl.get(wechatNativeExtraDataInvokeFunctionalPage.nbb);
        if (bVar == null) {
            AppMethodBeat.o(228893);
            return false;
        }
        Log.i("MicroMsg.AppBrand.FunctionalDirectApiInterceptor", "intercept by directApi[" + bVar.bOK() + ']');
        bVar.a(wechatNativeExtraDataInvokeFunctionalPage, gVar);
        AppMethodBeat.o(228893);
        return true;
    }
}
