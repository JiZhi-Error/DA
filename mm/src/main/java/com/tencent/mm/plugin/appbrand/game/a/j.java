package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.n.n;

public final class j extends v<Boolean> {
    private static final HashMap<String, j> lrJ = new HashMap<>();
    public static final a lrK = new a((byte) 0);
    final String lrG;
    private final boolean lrH;
    private final boolean lrI;

    private j(String str) {
        p.h(str, "kv");
        AppMethodBeat.i(50377);
        this.lrG = str;
        this.lrH = false;
        this.lrI = true;
        boolean z = !n.aL(this.lrG);
        if (!aa.SXc || z) {
            AppMethodBeat.o(50377);
            return;
        }
        AssertionError assertionError = new AssertionError("Assertion failed");
        AppMethodBeat.o(50377);
        throw assertionError;
    }

    private /* synthetic */ j(String str, byte b2) {
        this(str);
    }

    @Override // com.tencent.mm.plugin.appbrand.game.a.v
    public final String bCY() {
        return this.lrG;
    }

    @Override // com.tencent.mm.plugin.appbrand.game.a.v
    public final boolean bDa() {
        return this.lrI;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        static void a(j jVar) {
            AppMethodBeat.i(50374);
            HashMap hashMap = j.lrJ;
            String str = jVar.lrG;
            if (str == null) {
                p.hyc();
            }
            hashMap.put(str, jVar);
            AppMethodBeat.o(50374);
        }
    }

    static {
        AppMethodBeat.i(50378);
        a.a(new j("localso", (byte) 0));
        a.a(new j("renderprofiler", (byte) 0));
        a.a(new j("debugNode", (byte) 0));
        a.a(new j("tracejstask", (byte) 0));
        AppMethodBeat.o(50378);
    }

    @Override // com.tencent.mm.plugin.appbrand.game.a.v
    public final /* synthetic */ Boolean bDb() {
        AppMethodBeat.i(50375);
        Boolean valueOf = Boolean.valueOf(this.lrH);
        AppMethodBeat.o(50375);
        return valueOf;
    }

    @Override // com.tencent.mm.plugin.appbrand.game.a.v
    public final /* synthetic */ Boolean YH(String str) {
        AppMethodBeat.i(50376);
        Boolean YJ = YJ(str);
        AppMethodBeat.o(50376);
        return YJ;
    }

    public static final j YI(String str) {
        AppMethodBeat.i(50379);
        p.h(str, "kv_name");
        j jVar = lrJ.get(str);
        if (jVar == null) {
            p.hyc();
        }
        j jVar2 = jVar;
        AppMethodBeat.o(50379);
        return jVar2;
    }
}
