package com.tencent.soter.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.f;
import java.util.HashMap;

public final class a {
    private static HashMap<Class, C2189a> RQv = new HashMap<>();

    static {
        AppMethodBeat.i(15);
        AppMethodBeat.o(15);
    }

    public static boolean a(Class cls, f fVar) {
        AppMethodBeat.i(14);
        if (fVar.isSuccess()) {
            AppMethodBeat.o(14);
            return false;
        }
        C2189a aVar = RQv.get(cls);
        if (aVar == null) {
            aVar = new C2189a((byte) 0);
            aVar.a(fVar);
            RQv.put(cls, aVar);
        } else if (fVar.errCode != aVar.errCode || !fVar.errMsg.equals(aVar.errMsg)) {
            aVar.a(fVar);
        } else {
            aVar.cBY++;
            if (aVar.cBY >= 2) {
                AppMethodBeat.o(14);
                return true;
            }
        }
        d.d("Soter.RemoveASKStrategy", "error counter: %s", Integer.valueOf(aVar.cBY));
        AppMethodBeat.o(14);
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.soter.a.c.a$a  reason: collision with other inner class name */
    public static class C2189a {
        int cBY;
        int errCode;
        String errMsg;

        private C2189a() {
        }

        /* synthetic */ C2189a(byte b2) {
            this();
        }

        public final void a(f fVar) {
            this.errCode = fVar.errCode;
            this.errMsg = fVar.errMsg;
            this.cBY = 1;
        }
    }
}
