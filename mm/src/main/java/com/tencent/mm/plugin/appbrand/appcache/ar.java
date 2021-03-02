package com.tencent.mm.plugin.appbrand.appcache;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.appbrand.app.PluginAppBrand;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.page.bj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0017R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/appcache/WxaCommLibCodeCacheHelper;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaCommLibPreloadSessionInMM$ICommLibSessionDelegate;", "()V", "LAST_DEV_LIB_VERSION_CODE_KEY", "", "LAST_DEV_LIB_VERSION_NAME_KEY", "SP", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getSP", "()Landroid/content/SharedPreferences;", "TAG", "onUpdateUsingVersion", "", "reader", "Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;", "plugin-appbrand-integration_release"})
public final class ar implements at.a {
    public static final ar kLY = new ar();

    static {
        AppMethodBeat.i(50179);
        AppMethodBeat.o(50179);
    }

    private ar() {
    }

    @Override // com.tencent.mm.plugin.appbrand.appcache.at.a
    @SuppressLint({"ApplySharedPref"})
    public final void b(ICommLibReader iCommLibReader) {
        AppMethodBeat.i(50178);
        p.h(iCommLibReader, "reader");
        d.i(new a(iCommLibReader));
        AppMethodBeat.o(50178);
    }

    public static final /* synthetic */ SharedPreferences bvP() {
        AppMethodBeat.i(50180);
        SharedPreferences processSharedPrefs = PluginAppBrand.getProcessSharedPrefs();
        AppMethodBeat.o(50180);
        return processSharedPrefs;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ICommLibReader kLZ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ICommLibReader iCommLibReader) {
            super(0);
            this.kLZ = iCommLibReader;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(50177);
            String bvb = this.kLZ.bvb();
            if ((bvb != null && n.a((CharSequence) bvb, (CharSequence) "develop", false)) || this.kLZ.bvd() == 0) {
                ar arVar = ar.kLY;
                if (!p.j(ar.bvP().getString("__WxaCommLibCodeCacheHelper__LAST_DEV_LIB_VERSION_NAME_KEY", null), this.kLZ.bvb())) {
                    ar arVar2 = ar.kLY;
                    int i2 = ar.bvP().getInt("__WxaCommLibCodeCacheHelper__LAST_DEV_LIB_VERSION_CODE_KEY", this.kLZ.bvd());
                    Log.i("MicroMsg.AppBrand.WxaCommLibCodeCacheHelper", "delete expired CommLib CodeCache version=".concat(String.valueOf(i2)));
                    bj.a aVar = bj.ntu;
                    s.dy(bj.a.yR(i2), true);
                    ar arVar3 = ar.kLY;
                    ar.bvP().edit().putString("__WxaCommLibCodeCacheHelper__LAST_DEV_LIB_VERSION_NAME_KEY", this.kLZ.bvb()).putInt("__WxaCommLibCodeCacheHelper__LAST_DEV_LIB_VERSION_CODE_KEY", this.kLZ.bvd()).commit();
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(50177);
            return xVar;
        }
    }
}
