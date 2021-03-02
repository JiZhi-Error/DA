package com.tencent.mm.plugin.webview.l;

import android.content.Context;
import android.view.View;
import android.webkit.JavascriptInterface;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.l.c;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0017\u001a\u00020\u0018J$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u001dJ \u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0018\u0010&\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0007R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8FX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/webview/webcompt/WebComptTagJsApiHandler;", "", "jsapi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "(Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;)V", "debugInfo", "", "getDebugInfo", "()Ljava/lang/String;", "debugListener", "Landroid/view/View$OnLongClickListener;", "getDebugListener", "()Landroid/view/View$OnLongClickListener;", "debugListener$delegate", "Lkotlin/Lazy;", "firstTimeConfig", "", "lastAppId", "webComponent", "Lcom/tencent/mm/plugin/webview/webcompt/WebComponent;", "webComptSettings", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "clear", "", "config", "appId", "url", "webCompts", "Ljava/util/LinkedList;", "dispatchEvent", "webCompt", "event", "message", "getInterceptResponse", "Lcom/tencent/xweb/WebResourceResponse;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/xweb/WebResourceRequest;", "sendMessage", "webview-sdk_release"})
public final class k {
    private final h IBw;
    final c JEJ = new c(new WeakReference(this.IBw));
    private boolean JEQ = true;
    String JER = "";
    final HashMap<String, cel> JES = new HashMap<>();
    private final f JET = g.ah(new c(this));

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/JSAPIWebCompt;", "invoke"})
    static final class b extends q implements kotlin.g.a.b<cel, String> {
        public static final b JEX = new b();

        static {
            AppMethodBeat.i(82964);
            AppMethodBeat.o(82964);
        }

        b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(cel cel) {
            AppMethodBeat.i(82963);
            cel cel2 = cel;
            p.h(cel2, LocaleUtil.ITALIAN);
            String str = "name: " + cel2.name + "\nmd5: " + cel2.md5 + "\nurl: " + cel2.url;
            AppMethodBeat.o(82963);
            return str;
        }
    }

    public k(h hVar) {
        p.h(hVar, "jsapi");
        AppMethodBeat.i(225220);
        this.IBw = hVar;
        AppMethodBeat.o(225220);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void sendMessage(String str, String str2) {
        AppMethodBeat.i(82968);
        p.h(str, "webCompt");
        p.h(str2, "message");
        c cVar = this.JEJ;
        p.h(str, "webCompt");
        p.h(str2, "message");
        Log.v(c.TAG, "postToBack " + str + ' ' + str2);
        com.tencent.mm.plugin.appbrand.m.g bbt = cVar.bbt(str);
        if (bbt != null) {
            c.c(bbt, "WeixinWebCompt.onMessage(" + str2 + ')');
        }
        cVar.JCS.a(b.SEND_TO_JS_CONTEXT);
        AppMethodBeat.o(82968);
    }

    public final void bi(String str, String str2, String str3) {
        AppMethodBeat.i(225218);
        p.h(str, "webCompt");
        p.h(str2, "event");
        this.JEJ.bi(str, str2, str3);
        AppMethodBeat.o(225218);
    }

    public final void clear() {
        AppMethodBeat.i(82969);
        this.JER = "";
        this.JEQ = true;
        this.JES.clear();
        this.JEJ.clear();
        AppMethodBeat.o(82969);
    }

    public final void c(String str, String str2, LinkedList<cel> linkedList) {
        boolean z;
        AppMethodBeat.i(225219);
        p.h(str, "appId");
        p.h(str2, "url");
        p.h(linkedList, "webCompts");
        if (linkedList.isEmpty()) {
            c.b bVar = c.JDf;
            Log.w(c.TAG, "webCompt is null");
            AppMethodBeat.o(225219);
            return;
        }
        r rVar = new r();
        if (this.JES.isEmpty()) {
            if (!linkedList.isEmpty()) {
                this.JEJ.JCS.a(b.AUTH_WITH_FIRST_TIME);
            }
        }
        z.a aVar = new z.a();
        aVar.SYB = false;
        if (this.JEQ) {
            aVar.SYB = true;
        } else if (!p.j(this.JER, str)) {
            clear();
            this.JEJ.giK();
            this.JEJ.JCS.JEO.clear();
        } else {
            this.JEJ.JCS.a(b.REAUTH);
        }
        this.JER = str;
        this.JEQ = false;
        if (!linkedList.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            c.b bVar2 = c.JDf;
            d.b(c.TAG, new a(this, linkedList, rVar, str, str2, aVar));
        }
        AppMethodBeat.o(225219);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ k JEU;
        final /* synthetic */ LinkedList JEV;
        final /* synthetic */ z.a JEW;
        final /* synthetic */ r JEh;
        final /* synthetic */ String kPQ;
        final /* synthetic */ String mkH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(k kVar, LinkedList linkedList, r rVar, String str, String str2, z.a aVar) {
            super(0);
            this.JEU = kVar;
            this.JEV = linkedList;
            this.JEh = rVar;
            this.kPQ = str;
            this.mkH = str2;
            this.JEW = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(82962);
            for (cel cel : this.JEV) {
                if (this.JEU.JES.containsKey(cel.name)) {
                    c cVar = this.JEU.JEJ;
                    r rVar = this.JEh;
                    p.h(cel, "webCompt");
                    p.h(rVar, "performanceHelper");
                    c.l.a aVar = (c.l.a) cVar.giJ().get(cel.name);
                    if (aVar != null) {
                        c.a(aVar.giZ(), cel, rVar.getStartTime());
                    }
                } else {
                    String str = cel.name;
                    p.g(str, "webCompt.name");
                    this.JEU.JES.put(str, cel);
                    c cVar2 = this.JEU.JEJ;
                    String str2 = this.kPQ;
                    String str3 = this.mkH;
                    r rVar2 = this.JEh;
                    boolean z = this.JEW.SYB;
                    p.h(str2, "appId");
                    p.h(str3, "url");
                    p.h(cel, "webCompt");
                    p.h(rVar2, "performanceHelper");
                    c.a(rVar2, c.k.STEP_CREATE_JS_CXT);
                    cVar2.JCS.a(b.CREATE_JS_CONTEXT);
                    String str4 = cel.name;
                    Log.i(c.TAG, "createJsContext ".concat(String.valueOf(str4)));
                    z.f fVar = new z.f();
                    fVar.SYG = (T) c.p.JEp;
                    kotlinx.coroutines.f.b(bn.TUK, ba.hMW().plus(new c.n(CoroutineExceptionHandler.TTS, cVar2, fVar)), new c.o(cVar2, z, rVar2, str3, cel, str4, str2, fVar, null), 2);
                    this.JEU.JEJ.JCS.JEO.add(Long.valueOf((long) cel.MjU));
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(82962);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/view/View$OnLongClickListener;", "invoke"})
    static final class c extends q implements kotlin.g.a.a<View.OnLongClickListener> {
        final /* synthetic */ k JEU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(k kVar) {
            super(0);
            this.JEU = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View.OnLongClickListener invoke() {
            AppMethodBeat.i(82966);
            AnonymousClass1 r0 = new View.OnLongClickListener(this) {
                /* class com.tencent.mm.plugin.webview.l.k.c.AnonymousClass1 */
                final /* synthetic */ c JEY;

                {
                    this.JEY = r1;
                }

                public final boolean onLongClick(View view) {
                    boolean z;
                    AppMethodBeat.i(82965);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/webcompt/WebComptTagJsApiHandler$debugListener$2$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    if (!n.aL(this.JEY.JEU.JER)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        p.g(view, "view");
                        Context context = view.getContext();
                        k kVar = this.JEY.JEU;
                        StringBuilder sb = new StringBuilder("[webCompts]\n            ");
                        Collection<cel> values = kVar.JES.values();
                        p.g(values, "webComptSettings.values");
                        StringBuilder append = sb.append(j.a(values, "\n\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, b.JEX, 30)).append("\n\n            ");
                        c.b bVar2 = c.JDf;
                        com.tencent.mm.ui.base.h.X(context, n.buv(append.append(c.b.ejA()).append("\n            ").toString()), "");
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(z, this, "com/tencent/mm/plugin/webview/webcompt/WebComptTagJsApiHandler$debugListener$2$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(82965);
                    return z;
                }
            };
            AppMethodBeat.o(82966);
            return r0;
        }
    }
}
