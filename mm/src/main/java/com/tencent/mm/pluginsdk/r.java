package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

public class r {
    private long JTa = System.currentTimeMillis();
    protected ConcurrentLinkedDeque<a> JTb = new ConcurrentLinkedDeque<>();
    protected HashMap<String, a> JTc = new HashMap<>();

    public r() {
        AppMethodBeat.i(141154);
        AppMethodBeat.o(141154);
    }

    public final long getStartTime() {
        return this.JTa;
    }

    public final void bN(String str, long j2) {
        AppMethodBeat.i(141155);
        i(str, j2, "");
        AppMethodBeat.o(141155);
    }

    private void i(String str, long j2, String str2) {
        AppMethodBeat.i(141156);
        this.JTb.add(new a(str, j2, str2));
        j(str, j2, str2);
        AppMethodBeat.o(141156);
    }

    public final long bO(String str, long j2) {
        AppMethodBeat.i(141157);
        if (this.JTb == null || this.JTb.isEmpty()) {
            AppMethodBeat.o(141157);
            return j2;
        }
        Iterator<a> it = this.JTb.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.key.equals(str)) {
                long j3 = next.time;
                AppMethodBeat.o(141157);
                return j3;
            }
        }
        AppMethodBeat.o(141157);
        return j2;
    }

    private void j(String str, long j2, String str2) {
        AppMethodBeat.i(205086);
        if (str.equals("onPageStarted") || str.equals("onPageFinished") || str.equals("getA8KeyStart") || str.equals("getA8KeyEnd") || str.equals("firstScreenTimestamp") || str.equals("firstScreenTime")) {
            if (this.JTc.get(str) == null) {
                this.JTc.put(str, new a(str, j2, str2));
            }
            this.JTc.get(str).time = j2;
        }
        AppMethodBeat.o(205086);
    }

    public final long bdg(String str) {
        AppMethodBeat.i(205087);
        if (this.JTc == null || this.JTc.isEmpty()) {
            AppMethodBeat.o(205087);
            return 0;
        } else if (this.JTc.get(str) != null) {
            long j2 = this.JTc.get(str).time;
            AppMethodBeat.o(205087);
            return j2;
        } else {
            AppMethodBeat.o(205087);
            return 0;
        }
    }

    public class a {
        public String detail;
        public String key;
        public long time;

        a(String str, long j2, String str2) {
            this.key = str;
            this.time = j2;
            this.detail = str2;
        }
    }
}
