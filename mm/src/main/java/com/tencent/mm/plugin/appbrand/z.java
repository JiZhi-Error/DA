package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.c.c;
import com.tencent.mm.kernel.c.d;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class z extends d {
    private final Set<Class<? extends a>> kEJ = Collections.newSetFromMap(new ConcurrentHashMap());
    private volatile d.a kEK;

    public z() {
        AppMethodBeat.i(134622);
        super.a(new d.a() {
            /* class com.tencent.mm.plugin.appbrand.z.AnonymousClass1 */

            @Override // com.tencent.mm.kernel.c.d.a
            public final void a(Class<? extends a> cls, c cVar) {
                AppMethodBeat.i(134619);
                z.this.kEJ.add(cls);
                d.a aVar = z.this.kEK;
                if (aVar != null) {
                    aVar.a(cls, cVar);
                }
                AppMethodBeat.o(134619);
            }

            @Override // com.tencent.mm.kernel.c.d.a
            public final void b(Class<? extends a> cls, c cVar) {
                AppMethodBeat.i(134620);
                d.a aVar = z.this.kEK;
                if (aVar != null) {
                    aVar.b(cls, cVar);
                }
                AppMethodBeat.o(134620);
            }

            @Override // com.tencent.mm.kernel.c.d.a
            public final void a(Class<? extends a> cls, a aVar) {
                AppMethodBeat.i(134621);
                d.a aVar2 = z.this.kEK;
                if (aVar2 != null) {
                    aVar2.a(cls, aVar);
                }
                AppMethodBeat.o(134621);
            }
        });
        AppMethodBeat.o(134622);
    }

    @Override // com.tencent.mm.kernel.c.d
    public final void a(d.a aVar) {
        this.kEK = aVar;
    }

    public final void unregisterAll() {
        AppMethodBeat.i(134623);
        HashSet<Class<? extends a>> hashSet = new HashSet(this.kEJ);
        this.kEJ.clear();
        for (Class<? extends a> cls : hashSet) {
            super.ag(cls);
        }
        AppMethodBeat.o(134623);
    }
}
