package com.tencent.mm.memory.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.a.a.d;
import com.tencent.mm.memory.a.a.a.g;
import java.util.concurrent.ConcurrentHashMap;

public class b {
    private static volatile b iua;
    public static final com.tencent.mm.memory.a.a.a.a iub;
    private final String TAG = "MicroMsg.CacheInvoke";
    public ConcurrentHashMap<String, AbstractC0442b> itH = new ConcurrentHashMap<>();
    private AbstractC0442b iuc = null;

    /* renamed from: com.tencent.mm.memory.a.a.b$b  reason: collision with other inner class name */
    public interface AbstractC0442b<T> {
        void aSl();

        com.tencent.mm.memory.a.a.a.a aSm();

        d<String, T> aSn();

        f<String, T> aSo();
    }

    static {
        AppMethodBeat.i(156504);
        com.tencent.mm.memory.a.a.a.a aSp = com.tencent.mm.memory.a.a.a.a.aSp();
        iub = aSp;
        b aSk = aSk();
        a aVar = new a(aSp);
        aSk.itH.put(aSp.dUb, aVar);
        if (aSp.equals(iub)) {
            aSk.iuc = aVar;
        }
        AppMethodBeat.o(156504);
    }

    b() {
        AppMethodBeat.i(156498);
        AppMethodBeat.o(156498);
    }

    static class a implements AbstractC0442b {
        private static String iug = "//data[%d,%d]::%s::%s";
        private d<String, a> iud = null;
        private g<String, Object> iue = null;
        private com.tencent.mm.memory.a.a.a.a iuf;

        a(com.tencent.mm.memory.a.a.a.a aVar) {
            AppMethodBeat.i(156496);
            this.iuf = aVar;
            this.iud = new com.tencent.mm.memory.a.a.a.f<String, a>(aVar, new f.b<String, a>() {
                /* class com.tencent.mm.memory.a.a.b.a.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
                @Override // com.tencent.mm.b.f.b
                public final /* synthetic */ void c(String str, a aVar, a aVar2) {
                    f.b bVar;
                    AppMethodBeat.i(156494);
                    String str2 = str;
                    a aVar3 = aVar;
                    a aVar4 = aVar2;
                    if (!(aVar3 == null || aVar3.itV == null || aVar3.itV.get() == null || (bVar = aVar3.itV.get()) == null)) {
                        bVar.c(str2, aVar3, aVar4);
                    }
                    AppMethodBeat.o(156494);
                }
            }, new f.c<String, a>() {
                /* class com.tencent.mm.memory.a.a.b.a.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // com.tencent.mm.b.f.c
                public final /* bridge */ /* synthetic */ int y(String str, a aVar) {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        return aVar2.itX;
                    }
                    return 0;
                }
            }) {
                /* class com.tencent.mm.memory.a.a.b.a.AnonymousClass3 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // com.tencent.mm.memory.a.a.a.f
                public final /* synthetic */ String B(String str, String str2) {
                    AppMethodBeat.i(156495);
                    String str3 = str + "@" + str2;
                    AppMethodBeat.o(156495);
                    return str3;
                }
            };
            this.iue = new g<>(10);
            AppMethodBeat.o(156496);
        }

        @Override // com.tencent.mm.memory.a.a.b.AbstractC0442b
        public final void aSl() {
            AppMethodBeat.i(156497);
            this.iud.trimToSize(this.iuf.iuk / 2);
            AppMethodBeat.o(156497);
        }

        @Override // com.tencent.mm.memory.a.a.b.AbstractC0442b
        public final com.tencent.mm.memory.a.a.a.a aSm() {
            return this.iuf;
        }

        @Override // com.tencent.mm.memory.a.a.b.AbstractC0442b
        public final d aSn() {
            return this.iud;
        }

        @Override // com.tencent.mm.memory.a.a.b.AbstractC0442b
        public final f aSo() {
            return this.iue;
        }
    }

    public static b aSk() {
        AppMethodBeat.i(156499);
        if (iua == null) {
            synchronized (b.class) {
                try {
                    if (iua == null) {
                        iua = new b();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(156499);
                    throw th;
                }
            }
        }
        b bVar = iua;
        AppMethodBeat.o(156499);
        return bVar;
    }

    private static AbstractC0442b b(com.tencent.mm.memory.a.a.a.a aVar) {
        AppMethodBeat.i(156500);
        AbstractC0442b bVar = aSk().itH.get(aVar.dUb);
        AppMethodBeat.o(156500);
        return bVar;
    }

    public static d<String, a> c(com.tencent.mm.memory.a.a.a.a aVar) {
        AppMethodBeat.i(156501);
        if (aVar == null || aVar.equals("")) {
            AppMethodBeat.o(156501);
            return null;
        } else if (iub.equals(aVar)) {
            d<String, a> aSn = aSk().iuc.aSn();
            AppMethodBeat.o(156501);
            return aSn;
        } else {
            aSk();
            d<String, a> aSn2 = b(aVar).aSn();
            AppMethodBeat.o(156501);
            return aSn2;
        }
    }

    public static f<String, Object> d(com.tencent.mm.memory.a.a.a.a aVar) {
        AppMethodBeat.i(156502);
        if (aVar == null || aVar.equals("")) {
            AppMethodBeat.o(156502);
            return null;
        } else if (iub.equals(aVar)) {
            f<String, Object> aSo = aSk().iuc.aSo();
            AppMethodBeat.o(156502);
            return aSo;
        } else {
            aSk();
            f<String, Object> aSo2 = b(aVar).aSo();
            AppMethodBeat.o(156502);
            return aSo2;
        }
    }

    public static int e(com.tencent.mm.memory.a.a.a.a aVar) {
        AppMethodBeat.i(156503);
        if (aVar == null || aVar.equals("")) {
            AppMethodBeat.o(156503);
            return Integer.MAX_VALUE;
        } else if (iub.equals(aVar)) {
            int i2 = aSk().iuc.aSm().iuk;
            AppMethodBeat.o(156503);
            return i2;
        } else {
            aSk();
            int i3 = b(aVar).aSm().iuk;
            AppMethodBeat.o(156503);
            return i3;
        }
    }
}
