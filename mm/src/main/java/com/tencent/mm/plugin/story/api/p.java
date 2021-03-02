package com.tencent.mm.plugin.story.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class p {
    public static b FkJ;
    public int FkI;
    public long key;

    public interface b {
        long B(List<String> list, int i2);

        long a(List<String> list, String str, int i2);

        long a(List<String> list, String str, Map<String, ArrayList<Long>> map, ArrayList<Long> arrayList, int i2);

        long a(List<String> list, Map<String, ArrayList<Long>> map, int i2);
    }

    public p(long j2, int i2) {
        this.key = j2;
        this.FkI = i2;
    }

    public static class a {
        private static a FkK;
        private Map<Long, p> FkL = new HashMap();

        public a() {
            AppMethodBeat.i(118428);
            AppMethodBeat.o(118428);
        }

        public static a fns() {
            AppMethodBeat.i(118429);
            if (FkK == null) {
                FkK = new a();
            }
            a aVar = FkK;
            AppMethodBeat.o(118429);
            return aVar;
        }

        public final void a(long j2, p pVar) {
            AppMethodBeat.i(118430);
            this.FkL.put(Long.valueOf(j2), pVar);
            AppMethodBeat.o(118430);
        }

        public final p Kg(long j2) {
            AppMethodBeat.i(118431);
            p remove = this.FkL.remove(Long.valueOf(j2));
            AppMethodBeat.o(118431);
            return remove;
        }
    }
}
