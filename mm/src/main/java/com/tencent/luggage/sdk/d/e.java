package com.tencent.luggage.sdk.d;

import android.content.res.Configuration;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.plugin.appbrand.config.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\b¨\u0006\u0010"}, hxF = {"Lcom/tencent/luggage/sdk/runtime/AppBrandWindowLayoutManagerDummy;", "C", "Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;", "Lcom/tencent/luggage/sdk/runtime/IAppBrandWindowLayoutManager;", "()V", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "initConfig", "(Lcom/tencent/luggage/sdk/config/AppBrandInitConfigLU;)V", "onAppConfigGot", "appConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandAppConfig;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onInitConfigUpdated", "luggage-wechat-full-sdk_release"})
public final class e<C extends AppBrandInitConfigLU> implements f<C> {
    @Override // com.tencent.luggage.sdk.d.f
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(230037);
        p.h(configuration, "newConfig");
        AppMethodBeat.o(230037);
    }

    @Override // com.tencent.luggage.sdk.d.f
    public final void a(C c2) {
        AppMethodBeat.i(230038);
        p.h(c2, "initConfig");
        AppMethodBeat.o(230038);
    }

    @Override // com.tencent.luggage.sdk.d.f
    public final void b(C c2) {
        AppMethodBeat.i(230039);
        p.h(c2, "initConfig");
        AppMethodBeat.o(230039);
    }

    @Override // com.tencent.luggage.sdk.d.f
    public final void a(b bVar) {
        AppMethodBeat.i(230040);
        p.h(bVar, "appConfig");
        AppMethodBeat.o(230040);
    }
}
