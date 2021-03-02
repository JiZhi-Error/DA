package com.tencent.mm.plugin.appbrand.networking;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver;", "Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceImpl;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "TAG", "", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "mNetworkStateChangedReceiver", "com/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1", "Lcom/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1;", "onRegister", "", "onUnregister", "luggage-wxa-app_release"})
public final class f extends g {
    private final String TAG = "Luggage.WXA.NetworkServiceBySystemReceiver";
    private final NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1 njB = new NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(AppBrandRuntime appBrandRuntime) {
        super(appBrandRuntime);
        p.h(appBrandRuntime, "rt");
        AppMethodBeat.i(135584);
        AppMethodBeat.o(135584);
    }

    public static final /* synthetic */ void a(f fVar) {
        AppMethodBeat.i(135585);
        super.bPO();
        AppMethodBeat.o(135585);
    }

    private static Context getAppContext() {
        AppMethodBeat.i(176454);
        Context context = MMApplicationContext.getContext();
        if (context == null) {
            p.hyc();
        }
        AppMethodBeat.o(176454);
        return context;
    }

    @Override // com.tencent.mm.kernel.c.b, com.tencent.mm.plugin.appbrand.networking.g
    public final void aBc() {
        AppMethodBeat.i(135582);
        super.aBc();
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            getAppContext().registerReceiver(this.njB, intentFilter);
            AppMethodBeat.o(135582);
        } catch (Throwable th) {
            Log.e(this.TAG, "register network receiver, t=".concat(String.valueOf(th)));
            AppMethodBeat.o(135582);
        }
    }

    @Override // com.tencent.mm.kernel.c.b, com.tencent.mm.plugin.appbrand.networking.g
    public final void aBd() {
        AppMethodBeat.i(135583);
        super.aBd();
        try {
            getAppContext().unregisterReceiver(this.njB);
            AppMethodBeat.o(135583);
        } catch (Throwable th) {
            Log.e(this.TAG, "unregister network receiver, t=".concat(String.valueOf(th)));
            AppMethodBeat.o(135583);
        }
    }
}
