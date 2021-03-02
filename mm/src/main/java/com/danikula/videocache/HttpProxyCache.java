package com.danikula.videocache;

import android.text.TextUtils;
import com.danikula.videocache.file.FileCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

class HttpProxyCache extends ProxyCache {
    private static final float NO_CACHE_BARRIER = 0.2f;
    private final FileCache cache;
    private CacheListener listener;
    private final HttpUrlSource source;

    public HttpProxyCache(HttpUrlSource httpUrlSource, FileCache fileCache) {
        super(httpUrlSource, fileCache);
        this.cache = fileCache;
        this.source = httpUrlSource;
    }

    public void registerCacheListener(CacheListener cacheListener) {
        this.listener = cacheListener;
    }

    public void processRequest(GetRequest getRequest, Socket socket) {
        AppMethodBeat.i(223132);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(newResponseHeaders(getRequest).getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
        long j2 = getRequest.rangeOffset;
        if (isUseCache(getRequest)) {
            responseWithCache(bufferedOutputStream, j2);
            AppMethodBeat.o(223132);
            return;
        }
        responseWithoutCache(bufferedOutputStream, j2);
        AppMethodBeat.o(223132);
    }

    private boolean isUseCache(GetRequest getRequest) {
        boolean z;
        AppMethodBeat.i(223133);
        long length = this.source.length();
        if (length > 0) {
            z = true;
        } else {
            z = false;
        }
        long available = this.cache.available();
        if (!z || !getRequest.partial || ((float) getRequest.rangeOffset) <= ((float) available) + (((float) length) * NO_CACHE_BARRIER)) {
            AppMethodBeat.o(223133);
            return true;
        }
        AppMethodBeat.o(223133);
        return false;
    }

    private String newResponseHeaders(GetRequest getRequest) {
        boolean z;
        long j2;
        boolean z2;
        AppMethodBeat.i(223134);
        String mime = this.source.getMime();
        boolean z3 = !TextUtils.isEmpty(mime);
        long available = this.cache.isCompleted() ? this.cache.available() : this.source.length();
        if (available >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (getRequest.partial) {
            j2 = available - getRequest.rangeOffset;
        } else {
            j2 = available;
        }
        if (!z || !getRequest.partial) {
            z2 = false;
        } else {
            z2 = true;
        }
        String str = (getRequest.partial ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n") + "Accept-Ranges: bytes\n" + (z ? format("Content-Length: %d\n", Long.valueOf(j2)) : "") + (z2 ? format("Content-Range: bytes %d-%d/%d\n", Long.valueOf(getRequest.rangeOffset), Long.valueOf(available - 1), Long.valueOf(available)) : "") + (z3 ? format("Content-Type: %s\n", mime) : "") + "\n";
        AppMethodBeat.o(223134);
        return str;
    }

    private void responseWithCache(OutputStream outputStream, long j2) {
        AppMethodBeat.i(183565);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = read(bArr, j2, 8192);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                j2 += (long) read;
            } else {
                outputStream.flush();
                AppMethodBeat.o(183565);
                return;
            }
        }
    }

    private void responseWithoutCache(OutputStream outputStream, long j2) {
        AppMethodBeat.i(183566);
        HttpUrlSource httpUrlSource = new HttpUrlSource(this.source);
        try {
            httpUrlSource.open((long) ((int) j2));
            byte[] bArr = new byte[8192];
            while (true) {
                int read = httpUrlSource.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    outputStream.flush();
                    return;
                }
            }
        } finally {
            httpUrlSource.close();
            AppMethodBeat.o(183566);
        }
    }

    private String format(String str, Object... objArr) {
        AppMethodBeat.i(183567);
        String format = String.format(Locale.US, str, objArr);
        AppMethodBeat.o(183567);
        return format;
    }

    /* access modifiers changed from: protected */
    @Override // com.danikula.videocache.ProxyCache
    public void onCachePercentsAvailableChanged(int i2) {
        AppMethodBeat.i(183568);
        if (this.listener != null) {
            this.listener.onCacheAvailable(this.cache.file, this.source.getUrl(), i2);
        }
        AppMethodBeat.o(183568);
    }
}
