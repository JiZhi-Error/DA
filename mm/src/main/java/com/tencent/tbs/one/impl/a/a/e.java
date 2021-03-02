package com.tencent.tbs.one.impl.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public final class e extends d {

    /* renamed from: b  reason: collision with root package name */
    private AtomicInteger f2344b = new AtomicInteger();

    /* renamed from: c  reason: collision with root package name */
    private Executor f2345c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2346d;

    /* renamed from: e  reason: collision with root package name */
    private List<c> f2347e = new ArrayList();

    public e(Executor executor) {
        AppMethodBeat.i(173938);
        this.f2345c = executor;
        AppMethodBeat.o(173938);
    }

    @Override // com.tencent.tbs.one.impl.a.a.d
    public final void a() {
        AppMethodBeat.i(173940);
        this.f2344b.incrementAndGet();
        AppMethodBeat.o(173940);
    }

    @Override // com.tencent.tbs.one.impl.a.a.d
    public final void a(c cVar) {
        AppMethodBeat.i(173939);
        cVar.f2337b = this;
        this.f2346d = true;
        cVar.a();
        this.f2346d = false;
        c[] cVarArr = (c[]) this.f2347e.toArray(new c[0]);
        this.f2347e.clear();
        for (c cVar2 : cVarArr) {
            this.f2345c.execute(cVar2);
        }
        AppMethodBeat.o(173939);
    }

    @Override // com.tencent.tbs.one.impl.a.a.d
    public final void b() {
        AppMethodBeat.i(173942);
        if (this.f2344b.decrementAndGet() <= 0 && this.f2343a != null) {
            this.f2343a.a();
        }
        AppMethodBeat.o(173942);
    }

    @Override // com.tencent.tbs.one.impl.a.a.d
    public final void b(c cVar) {
        AppMethodBeat.i(173941);
        if (this.f2346d) {
            this.f2347e.add(cVar);
            AppMethodBeat.o(173941);
            return;
        }
        this.f2345c.execute(cVar);
        AppMethodBeat.o(173941);
    }
}
