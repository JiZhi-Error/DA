package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.b;
import com.tencent.mm.loader.e.e;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\f\rB\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderImageDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "()V", "loadDataImp", "", "item", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "Companion", "DefaultHttpClientFactory", "plugin-finder_release"})
public final class j extends com.tencent.mm.loader.d.b<o> {
    public static final a uIu = new a((byte) 0);

    static {
        AppMethodBeat.i(166323);
        AppMethodBeat.o(166323);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderImageDownloader$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.loader.d.b
    public final void a(com.tencent.mm.loader.h.a.a<o> aVar, g gVar, b.AbstractC0401b bVar) {
        String aBE;
        com.tencent.mm.loader.h.b d2;
        AppMethodBeat.i(166322);
        p.h(aVar, "item");
        p.h(gVar, "fileNameCreator");
        p.h(bVar, "callback");
        try {
            o value = aVar.value();
            if (value.djU() == x.FULL_IMAGE) {
                aBE = value.getUrl();
            } else {
                aBE = value.aBE();
            }
            Log.i("Finder.ImageDownloader", "loadDataImp http " + value.djU() + " thumbUrl " + value.aBE() + " url " + value.getUrl());
            b bVar2 = b.uIv;
            p.h(aBE, "url");
            HttpURLConnection aud = b.aud(aBE);
            if (aud.getResponseCode() >= 300) {
                aud.disconnect();
                Log.w("Finder.ImageDownloader", "dz[httpURLConnectionGet 300]");
                d2 = null;
            } else {
                InputStream inputStream = aud.getInputStream();
                String contentType = aud.getContentType();
                byte[] r = e.r(inputStream);
                aud.disconnect();
                d2 = com.tencent.mm.loader.h.b.d(r, contentType);
            }
            if (d2 != null) {
                bVar.a(d2);
                AppMethodBeat.o(166322);
                return;
            }
            bVar.onError();
            AppMethodBeat.o(166322);
        } catch (InterruptedException e2) {
            Log.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", Util.stackTraceToString(e2));
            bVar.onError();
            AppMethodBeat.o(166322);
        } catch (UnknownHostException e3) {
            Log.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", Util.stackTraceToString(e3));
            bVar.onError();
            AppMethodBeat.o(166322);
        } catch (SSLHandshakeException e4) {
            Log.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", Util.stackTraceToString(e4));
            bVar.onError();
            AppMethodBeat.o(166322);
        } catch (SocketException e5) {
            Log.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", Util.stackTraceToString(e5));
            bVar.onError();
            AppMethodBeat.o(166322);
        } catch (SocketTimeoutException e6) {
            Log.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", Util.stackTraceToString(e6));
            bVar.onError();
            AppMethodBeat.o(166322);
        } catch (IOException e7) {
            Log.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", Util.stackTraceToString(e7));
            bVar.onError();
            AppMethodBeat.o(166322);
        } catch (Exception e8) {
            Log.e("Finder.ImageDownloader", "[cpan] getOption image data failed.:%s", Util.stackTraceToString(e8));
            bVar.onError();
            AppMethodBeat.o(166322);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderImageDownloader$DefaultHttpClientFactory;", "", "()V", "httpURLConnectionGet", "Lcom/tencent/mm/loader/model/HttpResponse;", "url", "", "openConnection", "Ljava/net/HttpURLConnection;", "plugin-finder_release"})
    public static final class b {
        public static final b uIv = new b();

        static {
            AppMethodBeat.i(166321);
            AppMethodBeat.o(166321);
        }

        private b() {
        }

        public static HttpURLConnection aud(String str) {
            AppMethodBeat.i(166320);
            p.h(str, "url");
            Log.i("Finder.ImageDownloader", "[openConnection] url:".concat(String.valueOf(str)));
            URLConnection openConnection = new URL(str).openConnection();
            if (openConnection == null) {
                t tVar = new t("null cannot be cast to non-null type java.net.HttpURLConnection");
                AppMethodBeat.o(166320);
                throw tVar;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT);
            AppMethodBeat.o(166320);
            return httpURLConnection;
        }
    }
}
