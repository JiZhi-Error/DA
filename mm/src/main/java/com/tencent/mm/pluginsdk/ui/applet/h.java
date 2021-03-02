package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;
import java.net.HttpURLConnection;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\r\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010\f\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpClientFactory;", "", "()V", "TAG", "", "httpURLConnectionGet", "Lcom/tencent/mm/modelimage/loader/model/Response;", "url", "forceNormal", "", "connectionListener", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListener;", "shouldCheckNoCache", "HttpUrlConnectionHelper", "ImageHttpUrlConnection", "plugin-biz_release"})
public final class h {
    public static final h Kew = new h();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\t\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\n\u001a\u00020\u000bH&J\n\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000bH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\bH&¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpClientFactory$ImageHttpUrlConnection;", "", "closeInputStream", "", "inputStream", "Ljava/io/InputStream;", "disconnect", "getDataResponse", "Lcom/tencent/mm/modelimage/loader/model/Response;", "getInputStream", "getResponseCode", "", "newConnection", "Ljava/net/HttpURLConnection;", "onResultError", "responseCode", "onResultSuccess", "response", "plugin-biz_release"})
    public interface b {
        void O(InputStream inputStream);

        com.tencent.mm.av.a.d.b P(InputStream inputStream);

        void aih(int i2);

        void b(com.tencent.mm.av.a.d.b bVar);

        void disconnect();

        InputStream getInputStream();

        int getResponseCode();

        HttpURLConnection gpj();
    }

    static {
        AppMethodBeat.i(124867);
        AppMethodBeat.o(124867);
    }

    private h() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpClientFactory$HttpUrlConnectionHelper;", "", "()V", "createBizImageHttpUrlConnection", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpClientFactory$ImageHttpUrlConnection;", "url", "", "forceNormal", "", "connectionListener", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListener;", "plugin-biz_release"})
    public static final class a {
        public static final a Kex = new a();

        static {
            AppMethodBeat.i(124865);
            AppMethodBeat.o(124865);
        }

        private a() {
        }

        public static b b(String str, boolean z, j jVar) {
            AppMethodBeat.i(124864);
            i iVar = new i(str, z, jVar);
            AppMethodBeat.o(124864);
            return iVar;
        }
    }

    public static com.tencent.mm.av.a.d.b a(String str, boolean z, j jVar) {
        AppMethodBeat.i(124866);
        p.h(str, "url");
        a aVar = a.Kex;
        b b2 = a.b(str, z, jVar);
        try {
            b2.gpj();
            int responseCode = b2.getResponseCode();
            InputStream inputStream = b2.getInputStream();
            if (responseCode >= 300) {
                b2.O(inputStream);
                b2.disconnect();
                Log.w("MicroMsg.BizImageHttpClientFactory", "httpURLConnectionGet responseCode: %d", Integer.valueOf(responseCode));
                b2.aih(responseCode);
                AppMethodBeat.o(124866);
                return null;
            }
            com.tencent.mm.av.a.d.b P = b2.P(inputStream);
            b2.O(inputStream);
            b2.disconnect();
            b2.b(P);
            AppMethodBeat.o(124866);
            return P;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BizImageHttpClientFactory", e2, "alvinluo httpURLConnectionGet exception: ", new Object[0]);
            b2.aih(-1);
            AppMethodBeat.o(124866);
            return null;
        }
    }
}
