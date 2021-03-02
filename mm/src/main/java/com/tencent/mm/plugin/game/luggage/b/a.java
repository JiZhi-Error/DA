package com.tencent.mm.plugin.game.luggage.b;

import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.be;
import java.util.LinkedList;

public final class a {
    private static LinkedList<Class<? extends b>> xwA;

    public static synchronized LinkedList<Class<? extends b>> dTr() {
        LinkedList<Class<? extends b>> linkedList;
        synchronized (a.class) {
            AppMethodBeat.i(83049);
            xwA = new LinkedList<>();
            aQ(g.class);
            aQ(k.class);
            aQ(l.class);
            aQ(n.class);
            aQ(o.class);
            aQ(w.class);
            aQ(y.class);
            aQ(aa.class);
            aQ(ah.class);
            aQ(ad.class);
            aQ(ae.class);
            aQ(t.class);
            aQ(c.class);
            aQ(b.class);
            aQ(v.class);
            aQ(j.class);
            aQ(u.class);
            aQ(f.class);
            aQ(ab.class);
            aQ(e.class);
            aQ(ac.class);
            aQ(s.class);
            aQ(ak.class);
            aQ(be.class);
            aQ(d.class);
            aQ(m.class);
            aQ(z.class);
            aQ(ai.class);
            aQ(aj.class);
            aQ(r.class);
            aQ(ag.class);
            aQ(x.class);
            aQ(af.class);
            aQ(i.class);
            aQ(q.class);
            aQ(p.class);
            linkedList = xwA;
            AppMethodBeat.o(83049);
        }
        return linkedList;
    }

    private static void aQ(Class<? extends b> cls) {
        AppMethodBeat.i(83050);
        xwA.add(cls);
        AppMethodBeat.o(83050);
    }
}
