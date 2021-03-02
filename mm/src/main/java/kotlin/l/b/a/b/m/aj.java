package kotlin.l.b.a.b.m;

import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.i.c;
import kotlin.l.b.a.b.m.c.j;
import kotlin.l.b.a.b.m.c.l;
import kotlin.n.n;

public abstract class aj extends bg implements j, l {
    public abstract aj EG(boolean z);

    public abstract aj d(g gVar);

    public aj() {
        super((byte) 0);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder();
        Iterator it = hzL().iterator();
        while (it.hasNext()) {
            n.a(sb, "[", c.a(c.TFj, (kotlin.l.b.a.b.b.a.c) it.next()), "] ");
        }
        sb.append(hKE());
        if (!hKB().isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            kotlin.a.j.a(hKB(), sb, ", ", "<", ">", 0, null, null, 112);
        }
        if (hEa()) {
            sb.append("?");
        }
        String sb2 = sb.toString();
        p.g(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
