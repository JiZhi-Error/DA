package com.tencent.luggage.xweb_ext.extendplugin.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.ag.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;

public final class e {
    public static a f(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppBrandRuntime runtime;
        AppMethodBeat.i(215542);
        Log.d("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide");
        f NN = aVar.NN();
        if (NN instanceof ac) {
            runtime = ((ac) NN).getRuntime();
        } else {
            runtime = NN instanceof s ? ((s) NN).getRuntime() : null;
        }
        if (runtime == null) {
            Log.w("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide, runtime is null");
            AppMethodBeat.o(215542);
            return null;
        }
        a aVar2 = (a) runtime.aw(a.class);
        if (aVar2 == null) {
            Log.i("AppBrand.MicroMsg.AudioOfVideoBackgroundPlayManagerProvider", "provide, create");
            aVar2 = new a(runtime);
            runtime.a(aVar2);
        }
        AppMethodBeat.o(215542);
        return aVar2;
    }
}
