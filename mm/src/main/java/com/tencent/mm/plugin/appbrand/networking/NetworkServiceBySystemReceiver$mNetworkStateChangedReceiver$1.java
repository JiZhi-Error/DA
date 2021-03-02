package com.tencent.mm.plugin.appbrand.networking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/appbrand/networking/NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "luggage-wxa-app_release"})
public final class NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ f njC;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    NetworkServiceBySystemReceiver$mNetworkStateChangedReceiver$1(f fVar) {
        this.njC = fVar;
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(135581);
        p.h(context, "context");
        p.h(intent, "intent");
        f.a(this.njC);
        AppMethodBeat.o(135581);
    }
}
