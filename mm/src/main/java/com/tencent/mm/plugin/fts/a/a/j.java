package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Comparator;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class j {
    private static final AtomicInteger wWR = new AtomicInteger(0);
    public MMHandler handler = null;
    public final int id = wWR.incrementAndGet();
    public int kXb = 0;
    public String query = null;
    public int scene = -1;
    public String talker = null;
    public String wWS = null;
    public String wWT = null;
    public int[] wWU = null;
    public int[] wWV = null;
    public int wWW = Integer.MAX_VALUE;
    public HashSet<String> wWX = new HashSet<>();
    public Comparator<m> wWY = null;
    public l wWZ = null;

    static {
        AppMethodBeat.i(131707);
        AppMethodBeat.o(131707);
    }

    public j() {
        AppMethodBeat.i(131703);
        AppMethodBeat.o(131703);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(131705);
        if (this == obj) {
            AppMethodBeat.o(131705);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(131705);
            return false;
        } else if (this.id != ((j) obj).id) {
            AppMethodBeat.o(131705);
            return false;
        } else {
            AppMethodBeat.o(131705);
            return true;
        }
    }

    public String toString() {
        AppMethodBeat.i(131706);
        String format = String.format("{id: %d, query: %s}", Integer.valueOf(this.id), this.query);
        AppMethodBeat.o(131706);
        return format;
    }

    public static j a(String str, int[] iArr, int[] iArr2, int i2, HashSet<String> hashSet, Comparator<m> comparator, l lVar, MMHandler mMHandler) {
        AppMethodBeat.i(131704);
        j jVar = new j();
        jVar.query = str;
        jVar.wWS = null;
        jVar.wWU = iArr;
        jVar.wWV = iArr2;
        jVar.wWW = i2;
        jVar.wWX = hashSet;
        jVar.wWY = comparator;
        jVar.wWZ = lVar;
        jVar.handler = mMHandler;
        AppMethodBeat.o(131704);
        return jVar;
    }
}
