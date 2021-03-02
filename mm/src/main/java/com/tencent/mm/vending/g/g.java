package com.tencent.mm.vending.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.b;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.vending.j.d;
import com.tencent.mm.vending.j.e;
import com.tencent.mm.vending.j.f;
import com.tencent.mm.vending.j.h;
import com.tencent.mm.vending.j.i;
import java.util.Stack;

public final class g {
    private static final a RaF = new a();

    static {
        AppMethodBeat.i(74824);
        AppMethodBeat.o(74824);
    }

    public static final c<Void> hdG() {
        AppMethodBeat.i(74809);
        c<Void> H = new e().H(new Object[0]);
        AppMethodBeat.o(74809);
        return H;
    }

    public static final <Var1> c<Var1> en(Var1 var1) {
        AppMethodBeat.i(74810);
        c<Var1> H = new e().H(var1);
        AppMethodBeat.o(74810);
        return H;
    }

    public static final <Var1, Var2> c<c<Var1, Var2>> O(Var1 var1, Var2 var2) {
        AppMethodBeat.i(74811);
        c<c<Var1, Var2>> H = new e().H(var1, var2);
        AppMethodBeat.o(74811);
        return H;
    }

    public static final <Var1, Var2, Var3> c<d<Var1, Var2, Var3>> h(Var1 var1, Var2 var2, Var3 var3) {
        AppMethodBeat.i(74812);
        c<d<Var1, Var2, Var3>> H = new e().H(var1, var2, var3);
        AppMethodBeat.o(74812);
        return H;
    }

    public static final <Var1, Var2, Var3, Var4> c<e<Var1, Var2, Var3, Var4>> a(Var1 var1, Var2 var2, Var3 var3, Var4 var4) {
        AppMethodBeat.i(74813);
        c<e<Var1, Var2, Var3, Var4>> H = new e().H(var1, var2, var3, var4);
        AppMethodBeat.o(74813);
        return H;
    }

    public static final <Var1, Var2, Var3, Var4, Var5> c<f<Var1, Var2, Var3, Var4, Var5>> b(Var1 var1, Var2 var2, Var3 var3, Var4 var4, Var5 var5) {
        AppMethodBeat.i(74814);
        c<f<Var1, Var2, Var3, Var4, Var5>> H = new e().H(var1, var2, var3, var4, var5);
        AppMethodBeat.o(74814);
        return H;
    }

    public static final <Var1, Var2, Var3, Var4, Var5, Var6, Var7> c<h<Var1, Var2, Var3, Var4, Var5, Var6, Var7>> a(Var1 var1, Var2 var2, Var3 var3, Var4 var4, Var5 var5, Var6 var6, Var7 var7) {
        AppMethodBeat.i(74816);
        c<h<Var1, Var2, Var3, Var4, Var5, Var6, Var7>> H = new e().H(var1, var2, var3, var4, var5, var6, var7);
        AppMethodBeat.o(74816);
        return H;
    }

    public static final <Var1, Var2, Var3, Var4, Var5, Var6, Var7, Var8> c<i<Var1, Var2, Var3, Var4, Var5, Var6, Var7, Var8>> a(Var1 var1, Var2 var2, Var3 var3, Var4 var4, Var5 var5, Var6 var6, Var7 var7, Var8 var8) {
        AppMethodBeat.i(201259);
        c<i<Var1, Var2, Var3, Var4, Var5, Var6, Var7, Var8>> H = new e().H(var1, var2, var3, var4, var5, var6, var7, var8);
        AppMethodBeat.o(201259);
        return H;
    }

    public static <$1> b<$1> eo($1 _1) {
        AppMethodBeat.i(74817);
        b<$1> ep = a.ep(_1);
        AppMethodBeat.o(74817);
        return ep;
    }

    public static <$1, $2> c<$1, $2> P($1 _1, $2 _2) {
        AppMethodBeat.i(74818);
        c<$1, $2> Q = a.Q(_1, _2);
        AppMethodBeat.o(74818);
        return Q;
    }

    public static final b hdx() {
        AppMethodBeat.i(74819);
        f hdF = f.hdF();
        Stack<c> stack = hdF.RaE.get();
        c peek = stack == null ? null : stack.size() == 0 ? null : hdF.RaE.get().peek();
        if (peek != null) {
            b hdx = peek.hdx();
            AppMethodBeat.o(74819);
            return hdx;
        }
        a aVar = RaF;
        AppMethodBeat.o(74819);
        return aVar;
    }

    public static final b hdH() {
        AppMethodBeat.i(74820);
        b hdx = hdx();
        if (hdx != null) {
            hdx.hdw();
        } else {
            com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
        }
        AppMethodBeat.o(74820);
        return hdx;
    }

    public static final void a(b bVar, Object... objArr) {
        AppMethodBeat.i(74821);
        if (bVar == null) {
            com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
            AppMethodBeat.o(74821);
        } else if (objArr.length > 0) {
            bVar.G(objArr);
            AppMethodBeat.o(74821);
        } else {
            bVar.resume();
            AppMethodBeat.o(74821);
        }
    }

    public static final void b(b bVar) {
        AppMethodBeat.i(74822);
        if (bVar == null) {
            com.tencent.mm.vending.f.a.w("Vending.QuickAccess", "dummy mario", new Object[0]);
            AppMethodBeat.o(74822);
            return;
        }
        bVar.ej(null);
        AppMethodBeat.o(74822);
    }

    public static final <_Var> void a(d<_Var> dVar) {
        AppMethodBeat.i(74823);
        final b hdH = hdH();
        dVar.a(new d.b<_Var>() {
            /* class com.tencent.mm.vending.g.g.AnonymousClass2 */

            @Override // com.tencent.mm.vending.g.d.b
            public final void bz(_Var _var) {
                AppMethodBeat.i(74808);
                g.a(hdH, _var);
                AppMethodBeat.o(74808);
            }
        }).a(new d.a() {
            /* class com.tencent.mm.vending.g.g.AnonymousClass1 */

            @Override // com.tencent.mm.vending.g.d.a
            public final void cn(Object obj) {
                AppMethodBeat.i(74825);
                hdH.ej(obj);
                AppMethodBeat.o(74825);
            }
        });
        AppMethodBeat.o(74823);
    }
}
