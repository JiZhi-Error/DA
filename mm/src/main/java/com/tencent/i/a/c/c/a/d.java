package com.tencent.i.a.c.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class d {
    b SsI;
    a SsJ;

    public d(b bVar, a aVar) {
        this.SsI = bVar;
        this.SsJ = aVar;
    }

    public static class b {
        Queue<Integer> SsM = new LinkedList();
        Map<Integer, c> SsN = new HashMap();

        public b() {
            AppMethodBeat.i(214774);
            AppMethodBeat.o(214774);
        }

        public final c asF(int i2) {
            AppMethodBeat.i(214775);
            try {
                if (this.SsM.remove(Integer.valueOf(i2))) {
                    c remove = this.SsN.remove(Integer.valueOf(i2));
                    AppMethodBeat.o(214775);
                    return remove;
                }
            } catch (Throwable th) {
            }
            AppMethodBeat.o(214775);
            return null;
        }

        public final boolean hqB() {
            AppMethodBeat.i(214776);
            c cVar = this.SsN.get(this.SsM.peek());
            if (cVar == null || !cVar.SsG) {
                AppMethodBeat.o(214776);
                return false;
            }
            AppMethodBeat.o(214776);
            return true;
        }

        public final void hqC() {
            AppMethodBeat.i(214777);
            if (hqB()) {
                AppMethodBeat.o(214777);
                return;
            }
            c cVar = this.SsN.get(this.SsM.peek());
            if (cVar != null) {
                cVar.SsG = true;
            }
            AppMethodBeat.o(214777);
        }
    }

    public static class a {
        private Map<Integer, Integer> SsK = new HashMap();
        private int SsL;

        public a() {
            AppMethodBeat.i(214770);
            AppMethodBeat.o(214770);
        }

        public final int asD(int i2) {
            AppMethodBeat.i(214771);
            if (this.SsK.containsKey(Integer.valueOf(i2))) {
                int intValue = this.SsK.get(Integer.valueOf(i2)).intValue();
                AppMethodBeat.o(214771);
                return intValue;
            }
            int i3 = this.SsL + 1;
            this.SsL = i3;
            this.SsK.put(Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(214771);
            return i3;
        }

        public final void asE(int i2) {
            AppMethodBeat.i(214772);
            this.SsK.remove(Integer.valueOf(i2));
            AppMethodBeat.o(214772);
        }

        public final int hqA() {
            AppMethodBeat.i(214773);
            int size = this.SsK.size();
            AppMethodBeat.o(214773);
            return size;
        }
    }
}
