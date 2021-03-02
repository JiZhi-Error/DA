package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u0002H\u0002H\u0000¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, hxF = {"invokeMMAsync", "", "T", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "p", "(Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;Ljava/lang/Object;)V", "plugin-appbrand-integration_release"})
public final class f {
    public static final <T> void a(b<T, IPCVoid> bVar, T t) {
        AppMethodBeat.i(50984);
        p.h(bVar, "$this$invokeMMAsync");
        XIPCInvoker.a(MainProcessIPCService.dkO, t, bVar.getClass(), null);
        AppMethodBeat.o(50984);
    }
}
