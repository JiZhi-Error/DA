package com.tencent.mm.pluginsdk.ui.applet;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.b;
import com.tencent.mm.av.a.b.e;
import com.tencent.mm.hardcoder.g;
import com.tencent.mm.pluginsdk.ui.applet.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\rH\u0016J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnection;", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpClientFactory$ImageHttpUrlConnection;", "url", "", "forceNormal", "", "connectionListener", "Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListener;", "(Ljava/lang/String;ZLcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnectionListener;)V", "mConnection", "Ljava/net/HttpURLConnection;", "mConnectionListener", "requestImageType", "", "closeInputStream", "", "inputStream", "Ljava/io/InputStream;", "disconnect", "forceWebp", "getDataResponse", "Lcom/tencent/mm/modelimage/loader/model/Response;", "getInputStream", "getResponseCode", "newConnection", "onRequest", "onResultError", "responseCode", "onResultSuccess", "response", "Companion", "plugin-biz_release"})
public final class i implements h.b {
    public static final a KeB = new a((byte) 0);
    private int KeA = -1;
    private final j Key;
    private final boolean Kez;
    private HttpURLConnection mConnection;
    private String url;

    static {
        AppMethodBeat.i(124876);
        AppMethodBeat.o(124876);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageHttpUrlConnection$Companion;", "", "()V", "TAG", "", "plugin-biz_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public i(String str, boolean z, j jVar) {
        this.url = str;
        this.Kez = z;
        this.Key = jVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.h.b
    public final HttpURLConnection gpj() {
        j jVar;
        String l;
        AppMethodBeat.i(124868);
        String str = this.url;
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(124868);
            return null;
        }
        String str2 = this.url;
        if (this.Kez) {
            String str3 = this.url;
            if (str3 == null) {
                l = null;
            } else {
                g gVar = g.Kev;
                Uri parse = Uri.parse(str3);
                p.g(parse, "Uri.parse(url)");
                String b2 = g.b(parse, "tp");
                Log.d("MicroMsg.BizImageHttpUrlConnection", "alvinluo forceWebp url: %s, temp: %s", str3, b2);
                l = b.l(b2, false);
            }
            this.url = l;
        }
        j jVar2 = this.Key;
        if (jVar2 != null) {
            jVar2.ey(str2, this.url);
        }
        if (this.Kez && (jVar = this.Key) != null) {
            jVar.gpk();
        }
        j jVar3 = this.Key;
        if (jVar3 != null) {
            jVar3.gpl();
        }
        URLConnection openConnection = new URL(this.url).openConnection();
        if (openConnection == null) {
            t tVar = new t("null cannot be cast to non-null type java.net.HttpURLConnection");
            AppMethodBeat.o(124868);
            throw tVar;
        }
        this.mConnection = (HttpURLConnection) openConnection;
        HttpURLConnection httpURLConnection = this.mConnection;
        if (httpURLConnection != null) {
            httpURLConnection.setConnectTimeout(15000);
        }
        HttpURLConnection httpURLConnection2 = this.mConnection;
        if (httpURLConnection2 != null) {
            httpURLConnection2.setReadTimeout(g.sHCENCODEVIDEOTIMEOUT);
        }
        if (!this.Kez && b.fo(this.url)) {
            Log.v("MicroMsg.BizImageHttpUrlConnection", "alvinluo BizImage get WxPic");
            this.KeA = 1;
            HttpURLConnection httpURLConnection3 = this.mConnection;
            if (httpURLConnection3 != null) {
                httpURLConnection3.addRequestProperty("Accept", "image/wxpic");
            }
        } else if (b.fm(this.url)) {
            Log.v("MicroMsg.BizImageHttpUrlConnection", "alvinluo BizImage get Webp");
            this.KeA = 2;
            HttpURLConnection httpURLConnection4 = this.mConnection;
            if (httpURLConnection4 != null) {
                httpURLConnection4.setRequestProperty("Referer", com.tencent.mm.av.t.tu(d.KyO));
            }
        } else {
            Log.v("MicroMsg.BizImageHttpUrlConnection", "alvinluo BizImage get jpeg");
            this.KeA = 0;
        }
        j jVar4 = this.Key;
        if (jVar4 != null) {
            jVar4.gpm();
        }
        HttpURLConnection httpURLConnection5 = this.mConnection;
        AppMethodBeat.o(124868);
        return httpURLConnection5;
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.h.b
    public final InputStream getInputStream() {
        AppMethodBeat.i(124870);
        HttpURLConnection httpURLConnection = this.mConnection;
        if (httpURLConnection != null) {
            InputStream inputStream = httpURLConnection.getInputStream();
            AppMethodBeat.o(124870);
            return inputStream;
        }
        AppMethodBeat.o(124870);
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.h.b
    public final void O(InputStream inputStream) {
        AppMethodBeat.i(124871);
        j jVar = this.Key;
        if (jVar != null) {
            jVar.gpr();
        }
        Util.qualityClose(inputStream);
        j jVar2 = this.Key;
        if (jVar2 != null) {
            jVar2.gps();
            AppMethodBeat.o(124871);
            return;
        }
        AppMethodBeat.o(124871);
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.h.b
    public final com.tencent.mm.av.a.d.b P(InputStream inputStream) {
        int i2;
        String str = null;
        AppMethodBeat.i(124872);
        Object[] objArr = new Object[3];
        HttpURLConnection httpURLConnection = this.mConnection;
        objArr[0] = httpURLConnection != null ? httpURLConnection.getContentType() : null;
        objArr[1] = this.url;
        HttpURLConnection httpURLConnection2 = this.mConnection;
        objArr[2] = httpURLConnection2 != null ? Integer.valueOf(httpURLConnection2.getContentLength()) : null;
        Log.d("MicroMsg.BizImageHttpUrlConnection", "alvinluo getDataResponse contentType: %s, url: %s, contentLength: %s", objArr);
        j jVar = this.Key;
        if (jVar != null) {
            jVar.gpp();
        }
        if (inputStream == null) {
            HttpURLConnection httpURLConnection3 = this.mConnection;
            if (httpURLConnection3 != null) {
                inputStream = httpURLConnection3.getInputStream();
            } else {
                inputStream = null;
            }
        }
        byte[] r = e.r(inputStream);
        HttpURLConnection httpURLConnection4 = this.mConnection;
        if (httpURLConnection4 != null) {
            str = httpURLConnection4.getContentType();
        }
        com.tencent.mm.av.a.d.b bVar = new com.tencent.mm.av.a.d.b(r, str, (byte) 0);
        HttpURLConnection httpURLConnection5 = this.mConnection;
        if (httpURLConnection5 != null) {
            i2 = httpURLConnection5.getContentLength();
        } else {
            i2 = 0;
        }
        bVar.tA(i2);
        j jVar2 = this.Key;
        if (jVar2 != null) {
            jVar2.gpq();
        }
        AppMethodBeat.o(124872);
        return bVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.h.b
    public final void disconnect() {
        InputStream inputStream;
        AppMethodBeat.i(124873);
        try {
            HttpURLConnection httpURLConnection = this.mConnection;
            if (!(httpURLConnection == null || (inputStream = httpURLConnection.getInputStream()) == null)) {
                inputStream.close();
            }
            HttpURLConnection httpURLConnection2 = this.mConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            j jVar = this.Key;
            if (jVar != null) {
                jVar.gpt();
                AppMethodBeat.o(124873);
                return;
            }
            AppMethodBeat.o(124873);
        } catch (Exception e2) {
            AppMethodBeat.o(124873);
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.h.b
    public final void b(com.tencent.mm.av.a.d.b bVar) {
        AppMethodBeat.i(124874);
        p.h(bVar, "response");
        j jVar = this.Key;
        if (jVar != null) {
            jVar.b(bVar);
            AppMethodBeat.o(124874);
            return;
        }
        AppMethodBeat.o(124874);
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.h.b
    public final void aih(int i2) {
        AppMethodBeat.i(124875);
        j jVar = this.Key;
        if (jVar != null) {
            jVar.aih(i2);
            AppMethodBeat.o(124875);
            return;
        }
        AppMethodBeat.o(124875);
    }

    @Override // com.tencent.mm.pluginsdk.ui.applet.h.b
    public final int getResponseCode() {
        AppMethodBeat.i(124869);
        j jVar = this.Key;
        if (jVar != null) {
            jVar.bz(this.KeA, this.Kez);
        }
        j jVar2 = this.Key;
        if (jVar2 != null) {
            jVar2.gpn();
        }
        HttpURLConnection httpURLConnection = this.mConnection;
        int responseCode = httpURLConnection != null ? httpURLConnection.getResponseCode() : -1;
        j jVar3 = this.Key;
        if (jVar3 != null) {
            jVar3.gpo();
        }
        AppMethodBeat.o(124869);
        return responseCode;
    }
}
