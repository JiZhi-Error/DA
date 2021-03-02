package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bt {
    private static LinkedList<Class<? extends b>> xwA;

    public static synchronized LinkedList<Class<? extends b>> dTr() {
        LinkedList<Class<? extends b>> linkedList;
        synchronized (bt.class) {
            AppMethodBeat.i(78642);
            xwA = new LinkedList<>();
            aQ(an.class);
            aQ(bb.class);
            aQ(bm.class);
            aQ(ar.class);
            aQ(ah.class);
            aQ(a.class);
            aQ(aq.class);
            aQ(ba.class);
            aQ(t.class);
            aQ(av.class);
            aQ(z.class);
            aQ(al.class);
            aQ(w.class);
            aQ(u.class);
            aQ(m.class);
            aQ(b.class);
            aQ(c.class);
            aQ(g.class);
            aQ(h.class);
            aQ(i.class);
            aQ(j.class);
            aQ(k.class);
            aQ(l.class);
            aQ(o.class);
            aQ(s.class);
            aQ(x.class);
            aQ(aa.class);
            aQ(ab.class);
            aQ(ac.class);
            aQ(af.class);
            aQ(ag.class);
            aQ(aj.class);
            aQ(as.class);
            aQ(aw.class);
            aQ(bc.class);
            aQ(bd.class);
            aQ(bh.class);
            aQ(bi.class);
            aQ(bj.class);
            aQ(bl.class);
            aQ(bn.class);
            aQ(bo.class);
            aQ(bq.class);
            aQ(bp.class);
            aQ(y.class);
            aQ(f.class);
            aQ(n.class);
            aQ(ai.class);
            aQ(ak.class);
            aQ(ad.class);
            aQ(au.class);
            aQ(bg.class);
            aQ(ae.class);
            aQ(ax.class);
            aQ(p.class);
            aQ(ao.class);
            aQ(ap.class);
            aQ(at.class);
            aQ(q.class);
            aQ(e.class);
            aQ(r.class);
            aQ(d.class);
            aQ(bk.class);
            aQ(bf.class);
            aQ(v.class);
            aQ(ay.class);
            aQ(am.class);
            linkedList = xwA;
            AppMethodBeat.o(78642);
        }
        return linkedList;
    }

    private static void aQ(Class<? extends b> cls) {
        AppMethodBeat.i(78643);
        xwA.add(cls);
        AppMethodBeat.o(78643);
    }
}
