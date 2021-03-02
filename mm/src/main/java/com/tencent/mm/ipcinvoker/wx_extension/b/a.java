package com.tencent.mm.ipcinvoker.wx_extension.b;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import java.lang.reflect.Modifier;
import junit.framework.Assert;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aG\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\b¢\u0006\u0002\u0010\t\u001a7\u0010\n\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000b¢\u0006\u0002\u0010\f\u001a\u0013\u0010\u0005\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\r0\bH\u0002¨\u0006\u000e"}, hxF = {"ipcInvokeMM", "", "PARAM", "RET", NativeProtocol.WEB_DIALOG_PARAMS, "invoke", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "(Ljava/lang/Object;Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;)V", "ipcInvokeMMSync", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "(Ljava/lang/Object;Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;)Ljava/lang/Object;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "lib-ipcinvoker-wx-extension_release"})
public final class a {
    public static final /* synthetic */ <PARAM, RET> void a(PARAM param, b<PARAM, RET> bVar, d<RET> dVar) {
        AppMethodBeat.i(225241);
        p.h(bVar, "invoke");
        Assert.assertTrue(Modifier.isStatic(bVar.getClass().getModifiers()));
        XIPCInvoker.a(MainProcessIPCService.dkO, param, bVar.getClass(), dVar);
        AppMethodBeat.o(225241);
    }

    public static final /* synthetic */ void a(d<IPCVoid> dVar) {
        AppMethodBeat.i(225242);
        p.h(dVar, "$this$invoke");
        dVar.bn(IPCVoid.hnE);
        AppMethodBeat.o(225242);
    }

    public static final /* synthetic */ <PARAM, RET> RET a(PARAM param, k<PARAM, RET> kVar) {
        AppMethodBeat.i(225243);
        p.h(kVar, "invoke");
        Assert.assertTrue(Modifier.isStatic(kVar.getClass().getModifiers()));
        RET ret = (RET) XIPCInvoker.a(MainProcessIPCService.dkO, param, kVar.getClass());
        AppMethodBeat.o(225243);
        return ret;
    }
}
