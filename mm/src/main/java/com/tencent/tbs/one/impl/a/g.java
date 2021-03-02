package com.tencent.tbs.one.impl.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class g<T> extends a<T> {

    /* renamed from: b  reason: collision with root package name */
    private List<a<T>> f2358b;

    /* renamed from: c  reason: collision with root package name */
    private a<T> f2359c;

    public g(a<T>[] aVarArr) {
        AppMethodBeat.i(173888);
        this.f2358b = new ArrayList(Arrays.asList(aVarArr));
        AppMethodBeat.o(173888);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.tbs.one.impl.a.a
    public final void a() {
        AppMethodBeat.i(173889);
        c();
        AppMethodBeat.o(173889);
    }

    @Override // com.tencent.tbs.one.impl.a.a
    public final void b() {
        AppMethodBeat.i(173891);
        super.b();
        if (this.f2359c != null) {
            this.f2359c.b();
        }
        AppMethodBeat.o(173891);
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        AppMethodBeat.i(173890);
        this.f2359c = this.f2358b.remove(0);
        final boolean z = this.f2358b.size() == 0;
        this.f2359c.a((l) new l<T>() {
            /* class com.tencent.tbs.one.impl.a.g.AnonymousClass1 */

            @Override // com.tencent.tbs.one.impl.a.l
            public final void a(int i2, int i3) {
                AppMethodBeat.i(173956);
                g.this.a(i3);
                AppMethodBeat.o(173956);
            }

            @Override // com.tencent.tbs.one.impl.a.l
            public final void a(int i2, String str, Throwable th) {
                AppMethodBeat.i(173958);
                f.a(str, th);
                if (z || g.this.f2326a) {
                    g.this.a(i2, str, th);
                    AppMethodBeat.o(173958);
                    return;
                }
                g.this.c();
                AppMethodBeat.o(173958);
            }

            @Override // com.tencent.tbs.one.impl.a.l
            public final void a(T t) {
                AppMethodBeat.i(173957);
                g.this.a((Object) t);
                AppMethodBeat.o(173957);
            }
        });
        AppMethodBeat.o(173890);
    }
}
