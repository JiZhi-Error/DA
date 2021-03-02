package com.tencent.i.a.b;

import com.tencent.i.a.b.c.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public abstract class b {
    public a Sre = new a();

    /* access modifiers changed from: protected */
    public abstract void hql();

    public b() {
        hql();
    }

    public class a {
        public HashMap<Integer, d> wLb = new HashMap<>();

        public a() {
            AppMethodBeat.i(214698);
            AppMethodBeat.o(214698);
        }

        public final void a(d dVar) {
            AppMethodBeat.i(214699);
            if (!this.wLb.containsKey(dVar)) {
                this.wLb.put(Integer.valueOf(dVar.getTaskId()), dVar);
            }
            AppMethodBeat.o(214699);
        }
    }
}
