package com.bumptech.glide.load.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.g.c;
import com.bumptech.glide.g.f;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c.g;
import com.bumptech.glide.load.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public final class j implements d<InputStream> {
    static final b aFi = new a();
    private final g aFj;
    private final b aFk;
    private HttpURLConnection aFl;
    private InputStream aFm;
    private volatile boolean isCancelled;
    private final int timeout;

    /* access modifiers changed from: package-private */
    public interface b {
        HttpURLConnection b(URL url);
    }

    static {
        AppMethodBeat.i(76893);
        AppMethodBeat.o(76893);
    }

    public j(g gVar, int i2) {
        this(gVar, i2, aFi);
    }

    private j(g gVar, int i2, b bVar) {
        this.aFj = gVar;
        this.timeout = i2;
        this.aFk = bVar;
    }

    @Override // com.bumptech.glide.load.a.d
    public final void a(com.bumptech.glide.g gVar, d.a<? super InputStream> aVar) {
        AppMethodBeat.i(76890);
        long qt = f.qt();
        try {
            g gVar2 = this.aFj;
            if (gVar2.aJU == null) {
                if (TextUtils.isEmpty(gVar2.aJT)) {
                    String str = gVar2.aJS;
                    if (TextUtils.isEmpty(str)) {
                        str = ((URL) com.bumptech.glide.g.j.checkNotNull(gVar2.url, "Argument must not be null")).toString();
                    }
                    gVar2.aJT = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
                }
                gVar2.aJU = new URL(gVar2.aJT);
            }
            aVar.S(a(gVar2.aJU, 0, null, this.aFj.aJR.getHeaders()));
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                new StringBuilder("Finished http url fetcher fetch in ").append(f.p(qt));
                AppMethodBeat.o(76890);
                return;
            }
        } catch (IOException e2) {
            Log.isLoggable("HttpUrlFetcher", 3);
            aVar.e(e2);
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                new StringBuilder("Finished http url fetcher fetch in ").append(f.p(qt));
                AppMethodBeat.o(76890);
                return;
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                new StringBuilder("Finished http url fetcher fetch in ").append(f.p(qt));
            }
            AppMethodBeat.o(76890);
            throw th;
        }
        AppMethodBeat.o(76890);
    }

    private InputStream a(URL url, int i2, URL url2, Map<String, String> map) {
        AppMethodBeat.i(76891);
        while (i2 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        e eVar = new e("In re-direct loop");
                        AppMethodBeat.o(76891);
                        throw eVar;
                    }
                } catch (URISyntaxException e2) {
                }
            }
            this.aFl = this.aFk.b(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.aFl.addRequestProperty(entry.getKey(), entry.getValue());
            }
            this.aFl.setConnectTimeout(this.timeout);
            this.aFl.setReadTimeout(this.timeout);
            this.aFl.setUseCaches(false);
            this.aFl.setDoInput(true);
            this.aFl.setInstanceFollowRedirects(false);
            this.aFl.connect();
            this.aFm = this.aFl.getInputStream();
            if (this.isCancelled) {
                AppMethodBeat.o(76891);
                return null;
            }
            int responseCode = this.aFl.getResponseCode();
            if (responseCode / 100 == 2) {
                HttpURLConnection httpURLConnection = this.aFl;
                if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                    this.aFm = c.a(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
                } else {
                    if (Log.isLoggable("HttpUrlFetcher", 3)) {
                        new StringBuilder("Got non empty content encoding: ").append(httpURLConnection.getContentEncoding());
                    }
                    this.aFm = httpURLConnection.getInputStream();
                }
                InputStream inputStream = this.aFm;
                AppMethodBeat.o(76891);
                return inputStream;
            }
            if (responseCode / 100 == 3) {
                String headerField = this.aFl.getHeaderField("Location");
                if (TextUtils.isEmpty(headerField)) {
                    e eVar2 = new e("Received empty or null redirect url");
                    AppMethodBeat.o(76891);
                    throw eVar2;
                }
                url = new URL(url, headerField);
                cleanup();
                i2++;
                url2 = url;
            } else if (responseCode == -1) {
                e eVar3 = new e(responseCode);
                AppMethodBeat.o(76891);
                throw eVar3;
            } else {
                e eVar4 = new e(this.aFl.getResponseMessage(), responseCode);
                AppMethodBeat.o(76891);
                throw eVar4;
            }
        }
        e eVar5 = new e("Too many (> 5) redirects!");
        AppMethodBeat.o(76891);
        throw eVar5;
    }

    @Override // com.bumptech.glide.load.a.d
    public final void cleanup() {
        AppMethodBeat.i(76892);
        if (this.aFm != null) {
            try {
                this.aFm.close();
            } catch (IOException e2) {
            }
        }
        if (this.aFl != null) {
            this.aFl.disconnect();
        }
        this.aFl = null;
        AppMethodBeat.o(76892);
    }

    @Override // com.bumptech.glide.load.a.d
    public final void cancel() {
        this.isCancelled = true;
    }

    @Override // com.bumptech.glide.load.a.d
    public final Class<InputStream> os() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.a.d
    public final com.bumptech.glide.load.a ot() {
        return com.bumptech.glide.load.a.REMOTE;
    }

    static class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.a.j.b
        public final HttpURLConnection b(URL url) {
            AppMethodBeat.i(76889);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            AppMethodBeat.o(76889);
            return httpURLConnection;
        }
    }
}
