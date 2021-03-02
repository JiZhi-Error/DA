package com.tencent.tbs.one.impl.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.a.m;

public class c<T> extends l<T> {
    static /* synthetic */ void a(c cVar, int i2, int i3) {
        AppMethodBeat.i(174187);
        super.a(i2, i3);
        AppMethodBeat.o(174187);
    }

    static /* synthetic */ void a(c cVar, int i2, String str, Throwable th) {
        AppMethodBeat.i(174189);
        super.a(i2, str, th);
        AppMethodBeat.o(174189);
    }

    static /* synthetic */ void a(c cVar, Object obj) {
        AppMethodBeat.i(174188);
        super.a(obj);
        AppMethodBeat.o(174188);
    }

    @Override // com.tencent.tbs.one.impl.a.l
    public void a(final int i2, final int i3) {
        AppMethodBeat.i(174184);
        m.a(new Runnable() {
            /* class com.tencent.tbs.one.impl.common.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(174190);
                c.a(c.this, i2, i3);
                AppMethodBeat.o(174190);
            }
        });
        AppMethodBeat.o(174184);
    }

    @Override // com.tencent.tbs.one.impl.a.l
    public void a(final int i2, final String str, final Throwable th) {
        AppMethodBeat.i(174186);
        m.a(new Runnable() {
            /* class com.tencent.tbs.one.impl.common.c.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(174183);
                c.a(c.this, i2, str, th);
                AppMethodBeat.o(174183);
            }
        });
        AppMethodBeat.o(174186);
    }

    @Override // com.tencent.tbs.one.impl.a.l
    public void a(final T t) {
        AppMethodBeat.i(174185);
        m.a(new Runnable() {
            /* class com.tencent.tbs.one.impl.common.c.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(174255);
                c.a(c.this, t);
                AppMethodBeat.o(174255);
            }
        });
        AppMethodBeat.o(174185);
    }
}
