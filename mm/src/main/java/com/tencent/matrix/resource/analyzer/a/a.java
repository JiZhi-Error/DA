package com.tencent.matrix.resource.analyzer.a;

import com.c.a.b.j;
import com.c.a.b.l;
import com.c.a.c.d;
import com.c.a.c.s;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

public final class a {
    public static void a(l lVar) {
        final d dVar = new d();
        final Collection<j> Kn = lVar.Kn();
        for (j jVar : Kn) {
            String format = String.format("%s@0x%08x", jVar.cpi.mName, Long.valueOf(jVar.getId()));
            if (!dVar.containsKey(format)) {
                dVar.put(format, jVar);
            }
        }
        Kn.clear();
        dVar.b(new s<String>() {
            /* class com.tencent.matrix.resource.analyzer.a.a.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.c.a.c.s
            public final /* synthetic */ boolean aD(String str) {
                return Kn.add(dVar.get(str));
            }
        });
    }

    public static long bg(long j2) {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - j2);
    }
}
