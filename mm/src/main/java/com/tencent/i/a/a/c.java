package com.tencent.i.a.a;

import android.content.Context;
import com.tencent.i.a.a.a.a;
import com.tencent.i.a.a.b.b;
import com.tencent.i.a.j;
import com.tencent.i.a.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    public m SqN;
    public b SqO;
    public com.tencent.h.a.b SqP;
    public e SqQ;
    public com.tencent.i.a.d.b SqR;
    public a SqS;
    public Context mAppContext;

    public c(Context context, m mVar) {
        AppMethodBeat.i(214683);
        this.mAppContext = context != null ? context.getApplicationContext() : context;
        this.SqO = new b();
        this.SqR = new com.tencent.i.a.d.b(this);
        this.SqS = new a(this);
        this.SqN = mVar;
        if (mVar == null) {
            m.a aVar = new m.a();
            aVar.SqJ = new j();
            this.SqN = aVar.hqb();
        }
        AppMethodBeat.o(214683);
    }
}
