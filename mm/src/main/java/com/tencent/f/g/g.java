package com.tencent.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class g {
    public a RUb;
    HashMap<String, Object> map = new HashMap<>();

    public g(a aVar) {
        AppMethodBeat.i(183329);
        this.RUb = aVar;
        AppMethodBeat.o(183329);
    }

    public final int hmu() {
        AppMethodBeat.i(183330);
        int i2 = this.RUb.RUd.get();
        AppMethodBeat.o(183330);
        return i2;
    }

    public final void put(String str, long j2) {
        AppMethodBeat.i(183331);
        this.map.put(str, Long.valueOf(j2));
        AppMethodBeat.o(183331);
    }

    public final void hE(String str, int i2) {
        AppMethodBeat.i(183332);
        this.RUb.RUc.put(str, Integer.valueOf(i2));
        AppMethodBeat.o(183332);
    }

    public final int hF(String str, int i2) {
        AppMethodBeat.i(183333);
        Object obj = this.RUb.RUc.get(str);
        if (obj == null) {
            AppMethodBeat.o(183333);
            return i2;
        }
        int intValue = ((Integer) obj).intValue();
        AppMethodBeat.o(183333);
        return intValue;
    }

    public final long getLong(String str, long j2) {
        AppMethodBeat.i(183334);
        Object obj = this.map.get(str);
        if (obj == null) {
            AppMethodBeat.o(183334);
            return j2;
        }
        long longValue = ((Long) obj).longValue();
        AppMethodBeat.o(183334);
        return longValue;
    }

    public static final class a {
        public ConcurrentHashMap<String, Object> RUc = new ConcurrentHashMap<>();
        public AtomicInteger RUd;
        public String key;

        public a(String str, AtomicInteger atomicInteger) {
            AppMethodBeat.i(183328);
            this.key = str;
            this.RUd = atomicInteger;
            AppMethodBeat.o(183328);
        }
    }
}
