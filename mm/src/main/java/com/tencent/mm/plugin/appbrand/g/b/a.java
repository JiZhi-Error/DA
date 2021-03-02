package com.tencent.mm.plugin.appbrand.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a {
    private static a ljL;
    public List<AbstractC0581a> listeners = new ArrayList();
    public boolean ljM = false;
    public Map<String, c> ljN = new HashMap();

    /* renamed from: com.tencent.mm.plugin.appbrand.g.b.a$a  reason: collision with other inner class name */
    public interface AbstractC0581a {
        void a(c cVar);

        void b(c cVar);

        void c(c cVar);
    }

    private a() {
        AppMethodBeat.i(158902);
        AppMethodBeat.o(158902);
    }

    public static a bBl() {
        AppMethodBeat.i(158903);
        if (ljL == null) {
            synchronized (a.class) {
                try {
                    if (ljL == null) {
                        ljL = new a();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(158903);
                    throw th;
                }
            }
        }
        a aVar = ljL;
        AppMethodBeat.o(158903);
        return aVar;
    }

    public final boolean contains(String str) {
        AppMethodBeat.i(158904);
        boolean containsKey = this.ljN.containsKey(str);
        AppMethodBeat.o(158904);
        return containsKey;
    }

    public final void remove(String str) {
        AppMethodBeat.i(158905);
        if (this.ljM) {
            AppMethodBeat.o(158905);
            return;
        }
        c remove = this.ljN.remove(str);
        int i2 = 0;
        while (i2 < this.listeners.size()) {
            AbstractC0581a aVar = this.listeners.get(i2);
            if (aVar != null) {
                aVar.b(remove);
                i2++;
            } else {
                this.listeners.remove(i2);
            }
        }
        AppMethodBeat.o(158905);
    }

    public final c Yb(String str) {
        AppMethodBeat.i(158906);
        c cVar = this.ljN.get(str);
        AppMethodBeat.o(158906);
        return cVar;
    }

    public final Collection<c> bBm() {
        AppMethodBeat.i(158907);
        Collection<c> values = this.ljN.values();
        AppMethodBeat.o(158907);
        return values;
    }

    public final void bBn() {
        this.ljM = true;
    }

    public final void a(AbstractC0581a aVar) {
        AppMethodBeat.i(158908);
        if (this.ljM) {
            AppMethodBeat.o(158908);
            return;
        }
        if (!this.listeners.contains(aVar)) {
            this.listeners.add(aVar);
        }
        AppMethodBeat.o(158908);
    }

    public final void b(AbstractC0581a aVar) {
        AppMethodBeat.i(158909);
        this.listeners.remove(aVar);
        AppMethodBeat.o(158909);
    }

    public final void destroy() {
        AppMethodBeat.i(158910);
        this.ljN.clear();
        ljL = null;
        AppMethodBeat.o(158910);
    }
}
