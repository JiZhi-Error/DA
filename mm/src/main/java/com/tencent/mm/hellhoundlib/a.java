package com.tencent.mm.hellhoundlib;

import android.app.Activity;
import android.content.Intent;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.hellhoundlib.a.c;
import java.util.List;
import java.util.Map;

public final class a {
    private static a hlD;
    private static g hlH = null;
    private static c hlI = null;
    private final e hlE = new e() {
        /* class com.tencent.mm.hellhoundlib.a.AnonymousClass1 */
    };
    private final f hlF = new f() {
        /* class com.tencent.mm.hellhoundlib.a.AnonymousClass2 */
    };
    public d hlG = null;

    public static a axP() {
        AppMethodBeat.i(55503);
        if (hlD == null) {
            synchronized (a.class) {
                try {
                    if (hlD == null) {
                        hlD = new a();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(55503);
                    throw th;
                }
            }
        }
        a aVar = hlD;
        AppMethodBeat.o(55503);
        return aVar;
    }

    private a() {
        AppMethodBeat.i(55504);
        AppMethodBeat.o(55504);
    }

    public final void g(Object obj, int i2) {
        AppMethodBeat.i(55505);
        switch (i2) {
            case 0:
                if (this.hlG != null) {
                    this.hlG.bf(obj);
                    AppMethodBeat.o(55505);
                    return;
                }
                break;
            case 2:
                if (this.hlG != null) {
                    this.hlG.bg(obj);
                    AppMethodBeat.o(55505);
                    return;
                }
                break;
            case 3:
                if (this.hlG != null) {
                    this.hlG.bi(obj);
                    AppMethodBeat.o(55505);
                    return;
                }
                break;
            case 4:
                if (this.hlG != null) {
                    this.hlG.bj(obj);
                    AppMethodBeat.o(55505);
                    return;
                }
                break;
            case 5:
                if (this.hlG != null) {
                    this.hlG.bk(obj);
                    break;
                }
                break;
            case 6:
                if (this.hlG != null) {
                    this.hlG.bh(obj);
                    AppMethodBeat.o(55505);
                    return;
                }
                break;
        }
        AppMethodBeat.o(55505);
    }

    public final void a(Object obj, Intent intent) {
        AppMethodBeat.i(55506);
        if (!b.be(obj)) {
            AppMethodBeat.o(55506);
            return;
        }
        if (this.hlG != null) {
            this.hlG.b(obj, intent);
        }
        AppMethodBeat.o(55506);
    }

    public final void bd(Object obj) {
        AppMethodBeat.i(55508);
        if ((obj instanceof Activity) && this.hlG != null) {
            this.hlG.x((Activity) obj);
        }
        AppMethodBeat.o(55508);
    }

    public static void a(Map<String, List<Pair<String, String>>> map, c cVar) {
        AppMethodBeat.i(55510);
        com.tencent.mm.hellhoundlib.a.a.g(map, cVar);
        AppMethodBeat.o(55510);
    }

    public static void b(Map<String, List<Pair<String, String>>> map, c cVar) {
        AppMethodBeat.i(177061);
        com.tencent.mm.hellhoundlib.a.a.h(map, cVar);
        AppMethodBeat.o(177061);
    }

    public static void c(Map<String, Pair<String, List<Pair<String, String>>>> map, c cVar) {
        AppMethodBeat.i(168718);
        com.tencent.mm.hellhoundlib.a.a.i(map, cVar);
        AppMethodBeat.o(168718);
    }

    public static void d(Map<String, Pair<String, List<Pair<String, String>>>> map, c cVar) {
        AppMethodBeat.i(177062);
        com.tencent.mm.hellhoundlib.a.a.j(map, cVar);
        AppMethodBeat.o(177062);
    }

    public static void e(Map<String, Map<String, List<Pair<String, String>>>> map, c cVar) {
        AppMethodBeat.i(177063);
        com.tencent.mm.hellhoundlib.a.a.k(map, cVar);
        AppMethodBeat.o(177063);
    }

    public static void f(Map<String, Map<String, List<Pair<String, String>>>> map, c cVar) {
        AppMethodBeat.i(177064);
        com.tencent.mm.hellhoundlib.a.a.l(map, cVar);
        AppMethodBeat.o(177064);
    }

    public static void a(List<Pair<String, String>> list, b bVar) {
        AppMethodBeat.i(177065);
        com.tencent.mm.hellhoundlib.a.a.c(list, bVar);
        AppMethodBeat.o(177065);
    }

    public static void b(List<Pair<String, String>> list, b bVar) {
        AppMethodBeat.i(183783);
        com.tencent.mm.hellhoundlib.a.a.d(list, bVar);
        AppMethodBeat.o(183783);
    }

    public static void a(Map<String, List<Pair<String, String>>> map, b bVar) {
        AppMethodBeat.i(183784);
        com.tencent.mm.hellhoundlib.a.a.c(map, bVar);
        AppMethodBeat.o(183784);
    }

    public static void b(Map<String, List<Pair<String, String>>> map, b bVar) {
        AppMethodBeat.i(183785);
        com.tencent.mm.hellhoundlib.a.a.d(map, bVar);
        AppMethodBeat.o(183785);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, Object obj, Object[] objArr) {
        AppMethodBeat.i(177066);
        if (str2 == null && str3 == null) {
            com.tencent.mm.hellhoundlib.a.a.a(str, str4, str5, str6, obj, objArr);
            AppMethodBeat.o(177066);
            return;
        }
        com.tencent.mm.hellhoundlib.a.a.b(str, str2, str3, str4, str5, str6, obj, objArr);
        AppMethodBeat.o(177066);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, Object obj, Object obj2) {
        AppMethodBeat.i(186279);
        if (str2 == null && str3 == null) {
            com.tencent.mm.hellhoundlib.a.a.a(str, str4, str5, str6, obj, obj2);
            AppMethodBeat.o(186279);
            return;
        }
        com.tencent.mm.hellhoundlib.a.a.a(str, str4, str5, str6, obj2);
        AppMethodBeat.o(186279);
    }
}
