package com.tencent.mm.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/executor/FunctionExecutorFactory;", "", "()V", "FUNCTION_MSG_OP_DELAY", "", "FUNCTION_MSG_OP_DELETE", "FUNCTION_MSG_OP_SHOW", "FUNCTION_MSG_OP_UPDATE", "FUNCTION_MSG_OP_UPDATE_BUT_NO_SHOW", "get", "Lcom/tencent/mm/executor/IOpExecutor;", "op", "plugin-functionmsg_release"})
public final class a {
    public static final a heZ = new a();

    static {
        AppMethodBeat.i(114128);
        AppMethodBeat.o(114128);
    }

    private a() {
    }

    public static b pu(int i2) {
        AppMethodBeat.i(114127);
        switch (i2) {
            case 0:
                g gVar = new g();
                AppMethodBeat.o(114127);
                return gVar;
            case 1:
                d dVar = new d();
                AppMethodBeat.o(114127);
                return dVar;
            case 2:
                e eVar = new e();
                AppMethodBeat.o(114127);
                return eVar;
            case 3:
                f fVar = new f();
                AppMethodBeat.o(114127);
                return fVar;
            case 101:
                c cVar = new c();
                AppMethodBeat.o(114127);
                return cVar;
            default:
                AppMethodBeat.o(114127);
                return null;
        }
    }
}
