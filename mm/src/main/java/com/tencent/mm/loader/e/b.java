package com.tencent.mm.loader.e;

import com.tencent.mm.loader.d.b;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;

public final class b extends com.tencent.mm.loader.d.b<String> {
    @Override // com.tencent.mm.loader.d.b
    public final void a(com.tencent.mm.loader.h.a.a<String> aVar, g gVar, b.AbstractC0401b bVar) {
        Log.i("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data from url:%s", aVar);
        try {
            bVar.a(a.Hj(aVar.value()));
            return;
        } catch (InterruptedException e2) {
            Log.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", Util.stackTraceToString(e2));
        } catch (UnknownHostException e3) {
            Log.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", Util.stackTraceToString(e3));
        } catch (SSLHandshakeException e4) {
            Log.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", Util.stackTraceToString(e4));
        } catch (SocketException e5) {
            Log.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", Util.stackTraceToString(e5));
        } catch (SocketTimeoutException e6) {
            Log.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", Util.stackTraceToString(e6));
        } catch (IOException e7) {
            Log.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", Util.stackTraceToString(e7));
        } catch (Exception e8) {
            Log.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] get image data failed.:%s", Util.stackTraceToString(e8));
        }
        Log.e("MicroMsg.Loader.DefaultImageDownloader", "[cpan] onError");
        bVar.onError();
    }

    static class a {
        public static com.tencent.mm.loader.h.b Hj(String str) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT);
            if (httpURLConnection == null) {
                Log.i("MicroMsg.Loader.DefaultImageDownloader.HttpClientFactory", "open connection failed.");
            }
            if (httpURLConnection.getResponseCode() >= 300) {
                try {
                    httpURLConnection.getInputStream().close();
                } catch (Exception e2) {
                    Log.e("MicroMsg.Loader.DefaultImageDownloader.HttpClientFactory", e2.getMessage());
                }
                httpURLConnection.disconnect();
                Log.w("MicroMsg.Loader.DefaultImageDownloader.HttpClientFactory", "dz[httpURLConnectionGet 300]");
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            String contentType = httpURLConnection.getContentType();
            byte[] r = e.r(inputStream);
            try {
                httpURLConnection.getInputStream().close();
            } catch (Exception e3) {
                Log.e("MicroMsg.Loader.DefaultImageDownloader.HttpClientFactory", e3.getMessage());
            }
            httpURLConnection.disconnect();
            return com.tencent.mm.loader.h.b.d(r, contentType);
        }
    }
}
