package com.tencent.luggage.sdk.b.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, hxF = {"Lcom/tencent/luggage/sdk/jsapi/component/service/EventOnSubPackageReady;", "", "moduleName", "", "(Ljava/lang/String;)V", "TAG", "getModuleName", "()Ljava/lang/String;", "dispatch", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "toEventJSONObject", "Lorg/json/JSONObject;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPluginPkgInfo;", "luggage-wechat-full-sdk_release"})
public final class g {
    final String TAG = "Luggage.FULL.EventOnSubPackageReady";
    final String cBp;

    public g(String str) {
        p.h(str, "moduleName");
        AppMethodBeat.i(182999);
        this.cBp = str;
        AppMethodBeat.o(182999);
    }
}
