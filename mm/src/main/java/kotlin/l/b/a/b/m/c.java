package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Set;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l.b.a.b.m.c.h;
import kotlin.l.b.a.b.m.c.j;
import kotlin.l.b.a.b.m.c.n;
import kotlin.l.b.a.b.m.g;

public final class c {
    public static final c TNi = new c();

    static {
        AppMethodBeat.i(60571);
        AppMethodBeat.o(60571);
    }

    private c() {
    }

    public static boolean a(g gVar, j jVar, g.b bVar) {
        g.b.c cVar;
        AppMethodBeat.i(60569);
        p.h(gVar, "$this$hasNotNullSupertype");
        p.h(jVar, "type");
        p.h(bVar, "supertypesPolicy");
        if ((gVar.b(jVar) && !gVar.h(jVar)) || gVar.h((h) jVar)) {
            AppMethodBeat.o(60569);
            return true;
        }
        gVar.initialize();
        ArrayDeque<j> arrayDeque = gVar.TNp;
        if (arrayDeque == null) {
            p.hyc();
        }
        Set<j> set = gVar.TNq;
        if (set == null) {
            p.hyc();
        }
        arrayDeque.push(jVar);
        while (true) {
            if (!(!arrayDeque.isEmpty())) {
                gVar.clear();
                AppMethodBeat.o(60569);
                return false;
            } else if (set.size() > 1000) {
                IllegalStateException illegalStateException = new IllegalStateException(("Too many supertypes for type: " + jVar + ". Supertypes = " + kotlin.a.j.a(set, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (b) null, 63)).toString());
                AppMethodBeat.o(60569);
                throw illegalStateException;
            } else {
                j pop = arrayDeque.pop();
                p.g(pop, "current");
                if (set.add(pop)) {
                    if (gVar.h(pop)) {
                        cVar = g.b.c.TNw;
                    } else {
                        cVar = bVar;
                    }
                    g.b bVar2 = p.j(cVar, g.b.c.TNw) ^ true ? cVar : null;
                    if (bVar2 != null) {
                        for (h hVar : gVar.k(gVar.i(pop))) {
                            j b2 = bVar2.b(gVar, hVar);
                            if ((gVar.b(b2) && !gVar.h(b2)) || gVar.h((h) b2)) {
                                gVar.clear();
                                AppMethodBeat.o(60569);
                                return true;
                            }
                            arrayDeque.add(b2);
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    static boolean a(g gVar, j jVar, n nVar) {
        g.b.C2363b bVar;
        AppMethodBeat.i(60570);
        p.h(gVar, "$this$hasPathByNotMarkedNullableNodes");
        p.h(jVar, "start");
        p.h(nVar, "end");
        if (b(gVar, jVar, nVar)) {
            AppMethodBeat.o(60570);
            return true;
        }
        gVar.initialize();
        ArrayDeque<j> arrayDeque = gVar.TNp;
        if (arrayDeque == null) {
            p.hyc();
        }
        Set<j> set = gVar.TNq;
        if (set == null) {
            p.hyc();
        }
        arrayDeque.push(jVar);
        while (true) {
            if (!(!arrayDeque.isEmpty())) {
                gVar.clear();
                AppMethodBeat.o(60570);
                return false;
            } else if (set.size() > 1000) {
                IllegalStateException illegalStateException = new IllegalStateException(("Too many supertypes for type: " + jVar + ". Supertypes = " + kotlin.a.j.a(set, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (b) null, 63)).toString());
                AppMethodBeat.o(60570);
                throw illegalStateException;
            } else {
                j pop = arrayDeque.pop();
                p.g(pop, "current");
                if (set.add(pop)) {
                    if (gVar.h(pop)) {
                        bVar = g.b.c.TNw;
                    } else {
                        bVar = g.b.C2363b.TNv;
                    }
                    g.b bVar2 = p.j(bVar, g.b.c.TNw) ^ true ? bVar : null;
                    if (bVar2 != null) {
                        for (h hVar : gVar.k(gVar.i(pop))) {
                            j b2 = bVar2.b(gVar, hVar);
                            if (b(gVar, b2, nVar)) {
                                gVar.clear();
                                AppMethodBeat.o(60570);
                                return true;
                            }
                            arrayDeque.add(b2);
                        }
                        continue;
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    private static boolean b(g gVar, j jVar, n nVar) {
        AppMethodBeat.i(186266);
        if (gVar.j((h) jVar)) {
            AppMethodBeat.o(186266);
            return true;
        } else if (gVar.h(jVar)) {
            AppMethodBeat.o(186266);
            return false;
        } else if (!gVar.hLw() || !gVar.e(jVar)) {
            boolean b2 = gVar.b(gVar.i(jVar), nVar);
            AppMethodBeat.o(186266);
            return b2;
        } else {
            AppMethodBeat.o(186266);
            return true;
        }
    }
}
