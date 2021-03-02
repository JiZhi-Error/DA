package com.tencent.mm.plugin.webview.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c;
import com.tencent.mm.plugin.webview.ui.tools.newjsapi.JsApiOpenFinderView;
import com.tencent.mm.plugin.webview.ui.tools.newjsapi.JsApiOpenWeiXinPage;
import com.tencent.mm.plugin.webview.ui.tools.newjsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.newjsapi.e;
import com.tencent.mm.plugin.webview.ui.tools.newjsapi.h;
import com.tencent.mm.plugin.webview.ui.tools.newjsapi.i;
import com.tencent.mm.plugin.webview.ui.tools.newjsapi.k;
import com.tencent.mm.plugin.webview.ui.tools.newjsapi.m;
import com.tencent.mm.plugin.webview.ui.tools.newjsapi.n;
import com.tencent.mm.plugin.webview.ui.tools.newjsapi.o;
import com.tencent.mm.plugin.webview.ui.tools.newjsapi.r;
import com.tencent.mm.plugin.webview.ui.tools.newjsapi.s;
import com.tencent.mm.plugin.webview.ui.tools.newjsapi.t;
import com.tencent.mm.plugin.webview.ui.tools.newjsapi.u;
import com.tencent.mm.plugin.webview.ui.tools.newjsapi.v;
import com.tencent.mm.plugin.webview.ui.tools.newjsapi.w;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u000e*\b\u0012\u0004\u0012\u00020\u00060\u000fR'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/webview/jsapi/DefaultJsApiPool;", "", "()V", "jsApis", "", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "getJsApis", "()Ljava/util/Map;", "jsApis$delegate", "Lkotlin/Lazy;", "initJsApiPool", "", "toMap", "Ljava/util/HashMap;", "", "plugin-webview_release"})
public final class a {
    private static final f CDG = g.ah(C1948a.IQY);
    public static final a IQX = new a();

    static {
        AppMethodBeat.i(210311);
        AppMethodBeat.o(210311);
    }

    private a() {
    }

    public static HashMap<String, com.tencent.mm.plugin.webview.d.c.a> gz(List<? extends com.tencent.mm.plugin.webview.d.c.a> list) {
        AppMethodBeat.i(210309);
        p.h(list, "$this$toMap");
        HashMap<String, com.tencent.mm.plugin.webview.d.c.a> hashMap = new HashMap<>();
        for (T t : list) {
            hashMap.put(t.ePz(), t);
        }
        AppMethodBeat.o(210309);
        return hashMap;
    }

    public static void gaR() {
        AppMethodBeat.i(210310);
        p pVar = p.ISk;
        p.bN((Map) CDG.getValue());
        AppMethodBeat.o(210310);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.webview.d.a$a  reason: collision with other inner class name */
    static final class C1948a extends q implements kotlin.g.a.a<HashMap<String, com.tencent.mm.plugin.webview.d.c.a>> {
        public static final C1948a IQY = new C1948a();

        static {
            AppMethodBeat.i(210308);
            AppMethodBeat.o(210308);
        }

        C1948a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ HashMap<String, com.tencent.mm.plugin.webview.d.c.a> invoke() {
            AppMethodBeat.i(210307);
            a aVar = a.IQX;
            HashMap<String, com.tencent.mm.plugin.webview.d.c.a> gz = a.gz(j.listOf((Object[]) new com.tencent.mm.plugin.webview.d.c.a[]{o.Jxz, com.tencent.mm.plugin.webview.ui.tools.newjsapi.f.Jxf, e.Jxe, com.tencent.mm.plugin.webview.ui.tools.newjsapi.q.JxD, m.Jxt, n.Jxy, com.tencent.mm.plugin.webview.ui.tools.newjsapi.l.Jxn, h.Jxi, i.Jxk, d.JwZ, com.tencent.mm.plugin.webview.ui.tools.newjsapi.j.Jxl, v.VhP, w.VhQ, u.VhO, b.JsA, com.tencent.mm.plugin.webview.ui.tools.jsapi.d.JsC, c.JsB, t.JxK, com.tencent.mm.plugin.webview.ui.tools.jsapi.e.JsD, new com.tencent.mm.plugin.webview.h.b(), k.Jxm, com.tencent.mm.plugin.webview.ui.tools.newjsapi.p.JxA, JsApiOpenFinderView.JxB, JsApiOpenWeiXinPage.JxC, com.tencent.mm.plugin.webview.ui.tools.newjsapi.b.JwW, com.tencent.mm.plugin.webview.ui.tools.newjsapi.c.JwY, r.JxE, s.JxJ, com.tencent.mm.plugin.webview.ui.tools.newjsapi.g.Jxg}));
            AppMethodBeat.o(210307);
            return gz;
        }
    }
}
