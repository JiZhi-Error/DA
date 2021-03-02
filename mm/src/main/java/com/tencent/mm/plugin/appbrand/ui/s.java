package com.tencent.mm.plugin.appbrand.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.service.d;
import com.tencent.mm.sdk.event.EventCenter;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIEnterAnimationCompleteIPCNotify;", "", "()V", "doNotify", "", "processName", "", "appBrandUiName", "IPC_Notify", "plugin-appbrand-integration_release"})
public final class s {
    public static final s nXy = new s();

    static {
        AppMethodBeat.i(51152);
        AppMethodBeat.o(51152);
    }

    private s() {
    }

    public static void eK(String str, String str2) {
        AppMethodBeat.i(51151);
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            AppMethodBeat.o(51151);
            return;
        }
        if (str2 == null) {
            str2 = BuildConfig.COMMAND;
        }
        XIPCInvoker.a(str, new IPCString(str2), a.class, null);
        AppMethodBeat.o(51151);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIEnterAnimationCompleteIPCNotify$IPC_Notify;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
    public static final class a implements b<IPCString, IPCVoid> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCString iPCString, d<IPCVoid> dVar) {
            String str;
            AppMethodBeat.i(51150);
            IPCString iPCString2 = iPCString;
            com.tencent.mm.plugin.appbrand.service.d dVar2 = new com.tencent.mm.plugin.appbrand.service.d();
            d.a aVar = dVar2.nMq;
            if (iPCString2 == null || (str = iPCString2.value) == null) {
                str = "";
            }
            aVar.nMr = str;
            EventCenter.instance.asyncPublish(dVar2, Looper.getMainLooper());
            if (dVar != null) {
                dVar.bn(IPCVoid.hnE);
                AppMethodBeat.o(51150);
                return;
            }
            AppMethodBeat.o(51150);
        }
    }
}
