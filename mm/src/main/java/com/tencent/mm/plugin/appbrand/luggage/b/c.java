package com.tencent.mm.plugin.appbrand.luggage.b;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.appbrand.jsapi.z.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/customize/FontScaleProviderWC;", "Lcom/tencent/mm/plugin/appbrand/util/ActivityLifecycleCallbacksAdapter;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/IFontScaleProvider;", "()V", "mFontScale", "", "getCurrentFontScale", "getFromSp", "onActivityResumed", "", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "watchApp", "app", "Landroid/app/Application;", "plugin-appbrand-integration_release"})
public final class c extends com.tencent.mm.plugin.appbrand.ac.a implements b {
    private static float nab;
    public static final c nac = new c();

    static {
        AppMethodBeat.i(50850);
        AppMethodBeat.o(50850);
    }

    private c() {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.z.b
    public final float bIO() {
        AppMethodBeat.i(50847);
        if (nab <= 0.0f) {
            nab = bOv();
        }
        float f2 = nab;
        AppMethodBeat.o(50847);
        return f2;
    }

    private static float bOv() {
        float f2 = 1.0f;
        AppMethodBeat.i(50848);
        try {
            f2 = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 4).getFloat("text_size_scale_key", 1.0f);
        } catch (Throwable th) {
        }
        AppMethodBeat.o(50848);
        return f2;
    }

    @Override // com.tencent.mm.plugin.appbrand.ac.a
    public final void onActivityResumed(Activity activity) {
        AppMethodBeat.i(50849);
        d.i(a.nad);
        AppMethodBeat.o(50849);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        public static final a nad = new a();

        static {
            AppMethodBeat.i(50846);
            AppMethodBeat.o(50846);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(50845);
            c.nac.bIO();
            x xVar = x.SXb;
            AppMethodBeat.o(50845);
            return xVar;
        }
    }
}
