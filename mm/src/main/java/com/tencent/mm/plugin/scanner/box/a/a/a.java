package com.tencent.mm.plugin.scanner.box.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.box.a.b;
import com.tencent.mm.plugin.scanner.box.a.c;
import com.tencent.mm.plugin.scanner.box.a.d;
import com.tencent.mm.plugin.scanner.box.a.e;
import java.util.HashMap;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u000e*\b\u0012\u0004\u0012\u00020\u00060\u000fR'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/jsapi/base/DefaultScanJsApiPool;", "", "()V", "jsApis", "", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "getJsApis", "()Ljava/util/Map;", "jsApis$delegate", "Lkotlin/Lazy;", "initJsApiPool", "", "toMap", "Ljava/util/HashMap;", "", "plugin-scan_release"})
public final class a {
    public static final f CDG = g.ah(C1666a.CDI);
    public static final a CDH = new a();

    static {
        AppMethodBeat.i(240358);
        AppMethodBeat.o(240358);
    }

    private a() {
    }

    public static HashMap<String, com.tencent.mm.plugin.webview.d.c.a> gz(List<? extends com.tencent.mm.plugin.webview.d.c.a> list) {
        AppMethodBeat.i(240357);
        p.h(list, "$this$toMap");
        HashMap<String, com.tencent.mm.plugin.webview.d.c.a> hashMap = new HashMap<>();
        for (T t : list) {
            hashMap.put(t.ePz(), t);
        }
        AppMethodBeat.o(240357);
        return hashMap;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.scanner.box.a.a.a$a  reason: collision with other inner class name */
    static final class C1666a extends q implements kotlin.g.a.a<HashMap<String, com.tencent.mm.plugin.webview.d.c.a>> {
        public static final C1666a CDI = new C1666a();

        static {
            AppMethodBeat.i(240356);
            AppMethodBeat.o(240356);
        }

        C1666a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ HashMap<String, com.tencent.mm.plugin.webview.d.c.a> invoke() {
            AppMethodBeat.i(240355);
            a aVar = a.CDH;
            HashMap<String, com.tencent.mm.plugin.webview.d.c.a> gz = a.gz(j.listOf((Object[]) new b[]{c.CDC, d.CDD, b.CDB, com.tencent.mm.plugin.scanner.box.a.a.CDA, e.CDF}));
            AppMethodBeat.o(240355);
            return gz;
        }
    }
}
