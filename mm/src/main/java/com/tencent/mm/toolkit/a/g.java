package com.tencent.mm.toolkit.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.toolkit.a.a.c;
import com.tencent.mm.toolkit.a.a.d;

public final class g implements d {
    private final c OvK = new b(this.OvL);
    private final a OvL = new a();

    public g() {
        AppMethodBeat.i(196825);
        AppMethodBeat.o(196825);
    }

    public final d jG(Context context) {
        AppMethodBeat.i(196826);
        this.OvK.gS(context);
        AppMethodBeat.o(196826);
        return this;
    }

    @Override // com.tencent.mm.toolkit.a.a.d
    public final int e(c cVar) {
        AppMethodBeat.i(196827);
        this.OvK.b(cVar);
        while (cVar.mState == 2030) {
            try {
                Thread.sleep((long) cVar.gGc().getTimeout());
                this.OvK.b(cVar);
            } catch (InterruptedException e2) {
                boolean z = e.DEBUG;
                cVar.mState = 2040;
                a.a(cVar, 1301, e2.getLocalizedMessage());
            }
        }
        AppMethodBeat.o(196827);
        return 0;
    }

    @Override // com.tencent.mm.toolkit.a.a.d
    public final void f(c cVar) {
        AppMethodBeat.i(196828);
        if (e.DEBUG) {
            new StringBuilder("Request finish, id = ").append(cVar.mId).append(", state = ").append(cVar.mState);
            e.gGd();
        }
        AppMethodBeat.o(196828);
    }
}
