package com.tencent.mm.plugin.webview.luggage;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.luggage.d.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.webview.f.c;
import com.tencent.mm.plugin.webview.luggage.webview_impl.LuggageWebMultiTaskUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class r {
    private static HashMap<String, Integer> IUO = new HashMap<>();
    private static LuggageWebMultiTaskUIC.b IUP = new LuggageWebMultiTaskUIC.b() {
        /* class com.tencent.mm.plugin.webview.luggage.r.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.webview.luggage.webview_impl.LuggageWebMultiTaskUIC.b
        public final void p(MultiTaskInfo multiTaskInfo) {
            AppMethodBeat.i(210940);
            ToolsProcessIPCService.a(new IPCString(multiTaskInfo.field_id), a.class, null);
            AppMethodBeat.o(210940);
        }
    };

    static {
        AppMethodBeat.i(78434);
        AppMethodBeat.o(78434);
    }

    public static void a(String str, p pVar, c cVar) {
        AppMethodBeat.i(210941);
        if (IUO.containsKey(str)) {
            AppMethodBeat.o(210941);
            return;
        }
        int a2 = n.a(pVar, cVar);
        Log.i("MicroMsg.LuggageWebViewFloatBallManager", "onMultiTaskItemClick, stash, ballKey = %s, ticket = %d", str, Integer.valueOf(a2));
        IUO.put(str, Integer.valueOf(a2));
        AppMethodBeat.o(210941);
    }

    public static int aYv(String str) {
        AppMethodBeat.i(78430);
        Log.i("MicroMsg.LuggageWebViewFloatBallManager", "onMultiTaskItemClick, size = %d", Integer.valueOf(IUO.size()));
        int nullAs = Util.nullAs(IUO.remove(str), -1);
        AppMethodBeat.o(78430);
        return nullAs;
    }

    public static void aYw(String str) {
        AppMethodBeat.i(78431);
        if (IUO.containsKey(str)) {
            n.remove(Util.nullAsInt(IUO.remove(str), -1));
        }
        AppMethodBeat.o(78431);
    }

    public static void gcb() {
        AppMethodBeat.i(78432);
        Log.d("MicroMsg.LuggageWebViewFloatBallManager", "addFloatBallInfoEventListener");
        LuggageWebMultiTaskUIC.a aVar = LuggageWebMultiTaskUIC.IXk;
        LuggageWebMultiTaskUIC.b bVar = IUP;
        kotlin.g.b.p.h(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        LuggageWebMultiTaskUIC.gcs().add(bVar);
        AppMethodBeat.o(78432);
    }

    public static void gcc() {
        AppMethodBeat.i(78433);
        LuggageWebMultiTaskUIC.a aVar = LuggageWebMultiTaskUIC.IXk;
        LuggageWebMultiTaskUIC.b bVar = IUP;
        kotlin.g.b.p.h(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        LuggageWebMultiTaskUIC.gcs().remove(bVar);
        AppMethodBeat.o(78433);
    }

    static class a implements b<IPCString, IPCVoid> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(IPCString iPCString, d<IPCVoid> dVar) {
            AppMethodBeat.i(78428);
            r.aYw(iPCString.value);
            AppMethodBeat.o(78428);
        }
    }
}
