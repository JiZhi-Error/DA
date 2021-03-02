package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.d.a.a;
import java.util.LinkedList;
import java.util.List;

public final class h {
    private static Class[] PnN = {ad.class, x.class, c.class, aq.class, bf.class, g.class, be.class, ao.class, bc.class, t.class, e.class, az.class, al.class, bi.class, m.class, ae.class, z.class, bh.class, aw.class, ak.class, bd.class, b.class, ax.class, aj.class, r.class, o.class, ap.class, ay.class, s.class, bg.class, au.class, am.class, v.class, d.class, y.class, bb.class, as.class, ac.class, ab.class, w.class, f.class, aa.class, n.class, at.class, i.class, j.class, ar.class, av.class, q.class, u.class, an.class};
    private static List<a> PnO;

    public static List<a> getComponents() {
        AppMethodBeat.i(35178);
        if (PnO == null) {
            PnO = new LinkedList();
            Class[] clsArr = PnN;
            for (Class cls : clsArr) {
                if (cls.isAnnotationPresent(com.tencent.mm.ui.chatting.d.a.a.class)) {
                    com.tencent.mm.ui.chatting.d.a.a aVar = (com.tencent.mm.ui.chatting.d.a.a) cls.getAnnotation(com.tencent.mm.ui.chatting.d.a.a.class);
                    if (aVar.gRF() == a.C2091a.class) {
                        PnO.add(new a(cls, cls));
                    } else {
                        PnO.add(new a(aVar.gRF(), cls));
                    }
                } else {
                    PnO.add(new a(cls, cls));
                }
            }
        }
        List<a> list = PnO;
        AppMethodBeat.o(35178);
        return list;
    }

    public static class a {
        public Class<? extends af> PnP;
        public Class<? extends af> aWC;

        public a(Class<? extends af> cls, Class<? extends af> cls2) {
            this.aWC = cls;
            this.PnP = cls2;
        }

        public final af gPt() {
            AppMethodBeat.i(35177);
            try {
                af afVar = (af) this.PnP.newInstance();
                AppMethodBeat.o(35177);
                return afVar;
            } catch (InstantiationException e2) {
                Log.printErrStackTrace("ChattingComponentFactory", e2, "", new Object[0]);
                AppMethodBeat.o(35177);
                return null;
            } catch (IllegalAccessException e3) {
                Log.printErrStackTrace("ChattingComponentFactory", e3, "", new Object[0]);
                AppMethodBeat.o(35177);
                return null;
            }
        }
    }
}
