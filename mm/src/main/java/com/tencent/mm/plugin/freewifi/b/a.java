package com.tencent.mm.plugin.freewifi.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import java.util.LinkedHashMap;
import java.util.Map;

public final class a {
    private Map<String, b> aNT;
    private boolean wNZ;

    public static class b {
        String dFd;
        int wNc;
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    private a() {
        AppMethodBeat.i(24740);
        this.wNZ = false;
        this.aNT = new LinkedHashMap<String, b>() {
            /* class com.tencent.mm.plugin.freewifi.b.a.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Map$Entry] */
            /* access modifiers changed from: protected */
            @Override // java.util.LinkedHashMap
            public final boolean removeEldestEntry(Map.Entry<String, b> entry) {
                AppMethodBeat.i(24738);
                if (size() > 512) {
                    AppMethodBeat.o(24738);
                    return true;
                }
                AppMethodBeat.o(24738);
                return false;
            }
        };
        AppMethodBeat.o(24740);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.freewifi.b.a$a  reason: collision with other inner class name */
    public static class C1370a {
        private static a wOb = new a((byte) 0);

        static {
            AppMethodBeat.i(24739);
            AppMethodBeat.o(24739);
        }
    }

    private static String hr(String str, String str2) {
        AppMethodBeat.i(24741);
        String str3 = str + "-" + str2;
        AppMethodBeat.o(24741);
        return str3;
    }

    public final synchronized void g(String str, String str2, String str3, int i2) {
        AppMethodBeat.i(24742);
        if (m.eP(str) || m.eP(str2) || m.eP(str3) || !(i2 == 4 || i2 == 31)) {
            AppMethodBeat.o(24742);
        } else {
            b bVar = new b();
            bVar.dFd = str3;
            bVar.wNc = i2;
            this.aNT.put(hr(str, str2), bVar);
            AppMethodBeat.o(24742);
        }
    }

    public final synchronized b hs(String str, String str2) {
        b bVar;
        AppMethodBeat.i(24743);
        if (m.eP(str) || m.eP(str2)) {
            bVar = null;
            AppMethodBeat.o(24743);
        } else {
            bVar = this.aNT.get(hr(str, str2));
            AppMethodBeat.o(24743);
        }
        return bVar;
    }

    public final synchronized int size() {
        int size;
        AppMethodBeat.i(24744);
        size = this.aNT.size();
        AppMethodBeat.o(24744);
        return size;
    }
}
