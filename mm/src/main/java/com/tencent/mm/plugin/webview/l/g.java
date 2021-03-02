package com.tencent.mm.plugin.webview.l;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.webview.l.c;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/webview/webcompt/WebComptCommand;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", ch.COL_USERNAME, "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "webview-sdk_release"})
public final class g implements com.tencent.mm.pluginsdk.cmd.a {
    public static final a JEH = new a((byte) 0);

    static {
        AppMethodBeat.i(82929);
        AppMethodBeat.o(82929);
    }

    public static final String bbx(String str) {
        AppMethodBeat.i(82931);
        String bbx = a.bbx(str);
        AppMethodBeat.o(82931);
        return bbx;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/webview/webcompt/WebComptCommand$Companion;", "", "()V", "command", "", "debug", "", "getDebug", "()Z", "debugA8Key", "getDebugA8Key", "()Ljava/lang/String;", "debugJS", "getDebugJS", "mockHost", "url", "register", "", "webview-sdk_release"})
    public static final class a {

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"hash", "", "Ljava/net/URL;", "invoke"})
        /* renamed from: com.tencent.mm.plugin.webview.l.g$a$a  reason: collision with other inner class name */
        public static final class C1964a extends q implements b<URL, String> {
            public static final C1964a JEI = new C1964a();

            static {
                AppMethodBeat.i(82926);
                AppMethodBeat.o(82926);
            }

            C1964a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ String invoke(URL url) {
                AppMethodBeat.i(82924);
                String d2 = d(url);
                AppMethodBeat.o(82924);
                return d2;
            }

            public static String d(URL url) {
                AppMethodBeat.i(82925);
                p.h(url, "$this$hash");
                String ref = url.getRef();
                p.g(ref, "ref");
                if (!n.aL(ref)) {
                    String str = "#" + url.getRef();
                    AppMethodBeat.o(82925);
                    return str;
                }
                String ref2 = url.getRef();
                p.g(ref2, "ref");
                AppMethodBeat.o(82925);
                return ref2;
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static String bbx(String str) {
            AppMethodBeat.i(225216);
            p.h(str, "url");
            C1964a aVar = C1964a.JEI;
            if (getDebug()) {
                try {
                    Iterator<T> it = n.a(n.oD(str, "#"), new String[]{"&"}).iterator();
                    while (it.hasNext()) {
                        List<String> a2 = n.a((CharSequence) it.next(), new String[]{"="});
                        if (a2.size() == 2 && p.j(a2.get(0), "mock")) {
                            URL url = new URL(str);
                            StringBuilder append = new StringBuilder().append(url.getProtocol()).append("://").append(a2.get(1)).append(url.getFile());
                            C1964a aVar2 = C1964a.JEI;
                            String sb = append.append(C1964a.d(url)).toString();
                            AppMethodBeat.o(225216);
                            return sb;
                        }
                    }
                    URL url2 = new URL(str);
                    if (h.cdi().containsKey("mock_" + url2.getHost())) {
                        StringBuilder append2 = new StringBuilder().append(url2.getProtocol()).append("://").append(h.cdi().getString("mock_" + url2.getHost(), url2.getHost())).append(url2.getFile());
                        C1964a aVar3 = C1964a.JEI;
                        String sb2 = append2.append(C1964a.d(url2)).toString();
                        AppMethodBeat.o(225216);
                        return sb2;
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("WebComptCommand", e2, "mockHost", new Object[0]);
                }
            }
            AppMethodBeat.o(225216);
            return str;
        }

        public static boolean getDebug() {
            AppMethodBeat.i(82927);
            if (h.cdi().containsKey("debug")) {
                boolean z = h.cdi().getBoolean("debug", false);
                AppMethodBeat.o(82927);
                return z;
            } else if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
                AppMethodBeat.o(82927);
                return true;
            } else {
                AppMethodBeat.o(82927);
                return false;
            }
        }
    }

    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, String[] strArr, String str) {
        boolean z;
        AppMethodBeat.i(82928);
        p.h(context, "context");
        p.h(strArr, "args");
        p.h(str, ch.COL_USERNAME);
        if (!h.fZP()) {
            AppMethodBeat.o(82928);
            return false;
        }
        Iterator af = kotlin.g.b.b.af(strArr);
        if (!p.j((String) af.next(), "//webcompt")) {
            AppMethodBeat.o(82928);
            return false;
        }
        String str2 = (String) af.next();
        switch (str2.hashCode()) {
            case -1869744043:
                if (str2.equals("debugA8Key")) {
                    h.cdi().putBoolean("debug", true).putString("debugA8Key", (String) af.next());
                    h.showToast("webcompt set debugA8Key");
                    AppMethodBeat.o(82928);
                    return true;
                }
                AppMethodBeat.o(82928);
                return false;
            case 3357066:
                if (str2.equals("mock")) {
                    h.cdi().putString("mock_" + ((String) af.next()), (String) af.next());
                    h.showToast("webcompt mock");
                    AppMethodBeat.o(82928);
                    return true;
                }
                AppMethodBeat.o(82928);
                return false;
            case 94746189:
                if (str2.equals("clear")) {
                    if (!af.hasNext() || !p.j((String) af.next(), "sd")) {
                        h.cdi().clear();
                        h.showToast("webcompt clear all commands");
                        AppMethodBeat.o(82928);
                        return true;
                    }
                    if (af.hasNext()) {
                        String str3 = (String) af.next();
                        switch (str3.hashCode()) {
                            case 96801:
                                if (str3.equals("app")) {
                                    c.b bVar = c.JDf;
                                    c.b.e(false, false, 2);
                                    x xVar = x.SXb;
                                    h.showToast("webcompt clear sdcard app files");
                                    break;
                                }
                                break;
                            case 101415985:
                                if (str3.equals("jsapi")) {
                                    c.b bVar2 = c.JDf;
                                    c.b.e(false, false, 1);
                                    x xVar2 = x.SXb;
                                    h.showToast("webcompt clear sdcard jsapi files");
                                    break;
                                }
                                break;
                        }
                    } else {
                        c.b bVar3 = c.JDf;
                        c.b.e(false, false, 3);
                        x xVar3 = x.SXb;
                        h.showToast("webcompt clear all sdcard files");
                    }
                    AppMethodBeat.o(82928);
                    return true;
                }
                AppMethodBeat.o(82928);
                return false;
            case 95458899:
                if (str2.equals("debug")) {
                    MultiProcessMMKV cdi = h.cdi();
                    if (!af.hasNext() || !p.j((String) af.next(), "false")) {
                        z = true;
                    } else {
                        z = false;
                    }
                    cdi.putBoolean("debug", z);
                    h.showToast("webcompt set debug:" + a.getDebug());
                    AppMethodBeat.o(82928);
                    return true;
                }
                AppMethodBeat.o(82928);
                return false;
            case 1541691100:
                if (str2.equals("debugJS")) {
                    h.cdi().putBoolean("debug", true).putString("debugJS", (String) af.next());
                    h.showToast("webcompt set debugJS");
                    AppMethodBeat.o(82928);
                    return true;
                }
                AppMethodBeat.o(82928);
                return false;
            default:
                AppMethodBeat.o(82928);
                return false;
        }
    }

    public static final void LW() {
        AppMethodBeat.i(82930);
        com.tencent.mm.pluginsdk.cmd.b.a(new g(), "//webcompt");
        AppMethodBeat.o(82930);
    }
}
