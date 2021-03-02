package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.n.n;
import kotlin.o;
import kotlin.t;
import org.apache.commons.a.e;
import org.apache.commons.b.f;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 Q2\u00020\u0001:\u0001QB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020?0CJ$\u0010D\u001a\u00020\u000b2\u001a\u0010E\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0G\u0018\u00010FH\u0002J\u0006\u0010H\u001a\u00020?J<\u0010I\u001a\u00020?2\u0006\u0010J\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020M2\u001c\b\u0002\u0010E\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0G\u0018\u00010FJ\u0006\u0010N\u001a\u00020?J\u0016\u0010 \u001a\u00020?2\u0006\u0010O\u001a\u00020\u001d2\u0006\u0010P\u001a\u00020\u001dR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR6\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R*\u0010\"\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0#\u0018\u00010#X\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010)\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R\u001a\u0010,\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0019R\u001a\u0010/\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019R*\u00103\u001a\b\u0012\u0004\u0012\u00020\u000b022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b02@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R*\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b02@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u00105R\u001a\u00108\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR\u001a\u0010;\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0006\"\u0004\b=\u0010\b¨\u0006R"}, hxF = {"Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "Lcom/tencent/mm/pluginsdk/PerformanceHelper;", "()V", "createTime", "", "getCreateTime", "()J", "setCreateTime", "(J)V", "<set-?>", "Ljava/util/HashMap;", "", "headers", "getHeaders", "()Ljava/util/HashMap;", "initUrl", "getInitUrl", "()Ljava/lang/String;", "setInitUrl", "(Ljava/lang/String;)V", "invokerReused", "", "getInvokerReused", "()Z", "setInvokerReused", "(Z)V", "isTemplate", "setTemplate", "openArticleScene", "", "getOpenArticleScene", "()I", "setOpenArticleScene", "(I)V", "preAuthInfo", "", "getPreAuthInfo", "()[[Ljava/lang/String;", "setPreAuthInfo", "([[Ljava/lang/String;)V", "[[Ljava/lang/String;", "preauth", "getPreauth", "setPreauth", "predns", "getPredns", "setPredns", "prefetch", "getPrefetch", "setPrefetch", "Ljava/util/LinkedList;", "prefetchCSS", "getPrefetchCSS", "()Ljava/util/LinkedList;", "prefetchJS", "getPrefetchJS", "startActivity", "getStartActivity", "setStartActivity", "templateUpdateDataTime", "getTemplateUpdateDataTime", "setTemplateUpdateDataTime", "fetchDocumentTime", "", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "callback", "Lkotlin/Function0;", "formatPerformanceInfo", "performanceInfo", "", "Lkotlin/Pair;", "onCreate", SharePatchInfo.FINGER_PRINT, "titles", "data", "webview", "Lcom/tencent/xweb/WebView;", "printPerformance", "openScene", "fromScene", "Companion", "webview-sdk_release"})
public final class j extends r {
    public static final a JBQ = new a((byte) 0);
    private static final String TAG = TAG;
    public String ISo = "";
    public String[][] JBI;
    public boolean JBJ;
    public long JBK;
    public boolean JBL;
    public LinkedList<String> JBM = new LinkedList<>();
    public LinkedList<String> JBN = new LinkedList<>();
    public HashMap<String, String> JBO = new HashMap<>();
    public long JBP;
    public boolean Jct;
    public boolean Jcu;
    public boolean Jcv;
    public int Jis;
    public long createTime;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "s", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
    public static final class b<T> implements ValueCallback<String> {
        final /* synthetic */ j JBR;
        final /* synthetic */ kotlin.g.a.a ihE;

        public b(j jVar, kotlin.g.a.a aVar) {
            this.JBR = jVar;
            this.ihE = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.webkit.ValueCallback
        public final /* synthetic */ void onReceiveValue(String str) {
            AppMethodBeat.i(225176);
            Looper.myQueue().addIdleHandler(new a(this, str));
            AppMethodBeat.o(225176);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, hxF = {"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"})
        public static final class a implements MessageQueue.IdleHandler {
            final /* synthetic */ b JBS;
            final /* synthetic */ String JBT;

            public a(b bVar, String str) {
                this.JBS = bVar;
                this.JBT = str;
            }

            public final boolean queueIdle() {
                AppMethodBeat.i(225175);
                Looper.myQueue().removeIdleHandler(this);
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    String str = this.JBT;
                    p.g(str, "s");
                    int length = this.JBT.length() - 1;
                    if (str == null) {
                        t tVar = new t("null cannot be cast to non-null type java.lang.String");
                        AppMethodBeat.o(225175);
                        throw tVar;
                    }
                    String substring = str.substring(1, length);
                    p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    JSONObject jSONObject = new JSONObject(f.bvh(substring));
                    Iterator<String> keys = jSONObject.keys();
                    p.g(keys, "keys()");
                    while (keys.hasNext()) {
                        JSONObject optJSONObject = jSONObject.optJSONObject(keys.next());
                        Iterator<String> keys2 = optJSONObject.keys();
                        p.g(keys2, "keys()");
                        while (keys2.hasNext()) {
                            String next = keys2.next();
                            this.JBS.JBR.bN(next, optJSONObject.optLong(next));
                        }
                    }
                    this.JBS.ihE.invoke();
                    this.JBS.JBR.giI();
                    Log.v(j.TAG, "onReceiveValue cost %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(225175);
                    return false;
                } catch (Exception e2) {
                    Log.w(j.TAG, "fetchDocumentTime ex: %s", e2.getMessage());
                }
            }
        }
    }

    public j() {
        AppMethodBeat.i(82763);
        AppMethodBeat.o(82763);
    }

    public final void giI() {
        AppMethodBeat.i(82760);
        if (this.JTb == null || this.JTb.isEmpty()) {
            AppMethodBeat.o(82760);
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = this.JTb.iterator();
        while (it.hasNext()) {
            r.a aVar = (r.a) it.next();
            sb.append("[");
            sb.append(aVar.key);
            sb.append(": ");
            sb.append(aVar.time);
            if (aVar.time > this.createTime) {
                sb.append(", ").append(aVar.time - this.createTime);
            }
            if (!Util.isNullOrNil(aVar.detail)) {
                sb.append(", ").append(aVar.detail);
            }
            sb.append("] ");
        }
        Log.i(TAG, "webview Performance: %s", sb.toString());
        this.JTb.clear();
        AppMethodBeat.o(82760);
    }

    public static void a(String str, String str2, WebView webView, List<o<String, String>> list) {
        AppMethodBeat.i(82761);
        p.h(str, "titles");
        p.h(str2, "data");
        p.h(webView, "webview");
        if (com.tencent.mm.plugin.webview.d.l.gbo()) {
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            byte[] byteArray = e.toByteArray(context.getAssets().open("jsapi/vconsole_performance.js"));
            p.g(byteArray, "IOUtils.toByteArray(MMAp…console_performance.js\"))");
            webView.evaluateJavascript(n.by(n.by(n.by(new String(byteArray, d.UTF_8), "$WF_DATAS$", str2), "$WF_TITLES$", str), "$WF_LOG$", im(list)), null);
        }
        AppMethodBeat.o(82761);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x007b, code lost:
        if (r0 == null) goto L_0x007d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String im(java.util.List<kotlin.o<java.lang.String, java.lang.String>> r9) {
        /*
        // Method dump skipped, instructions count: 132
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.k.j.im(java.util.List):java.lang.String");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper$Companion;", "", "()V", "TAG", "", "webview-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(82764);
        AppMethodBeat.o(82764);
    }
}
