package com.tencent.mm.ui.chatting.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.d.af;
import com.tencent.mm.ui.chatting.d.ag;
import java.util.HashMap;

public final class a {
    public HashMap<Class<? extends af>, af> PDU = new HashMap<>();
    private com.tencent.mm.ui.chatting.e.a dom;

    public a(com.tencent.mm.ui.chatting.e.a aVar) {
        AppMethodBeat.i(36433);
        this.dom = aVar;
        AppMethodBeat.o(36433);
    }

    public final <T extends af, V extends Class<T>> T bh(V v) {
        AppMethodBeat.i(36434);
        if (!v.isInterface()) {
            RuntimeException runtimeException = new RuntimeException("[get] " + v + " is not a interface!");
            AppMethodBeat.o(36434);
            throw runtimeException;
        } else if (this.PDU.containsKey(v)) {
            T t = (T) this.PDU.get(v);
            AppMethodBeat.o(36434);
            return t;
        } else {
            AppMethodBeat.o(36434);
            return null;
        }
    }

    public final void a(Class<? extends af> cls, af afVar) {
        AppMethodBeat.i(36435);
        if (this.PDU.put(cls, afVar) != null) {
            Log.w("MicroMsg.ChattingComponentManager", "[register] %s has register", cls);
        }
        if (afVar instanceof ag) {
            long currentTimeMillis = System.currentTimeMillis();
            ((ag) afVar).a(this.dom);
            Log.i("MicroMsg.ChattingComponentManager", "[install] listener:%s cost:%sms", afVar.getClass().getName(), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        AppMethodBeat.o(36435);
    }
}
