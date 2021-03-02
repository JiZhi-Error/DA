package com.danikula.videocache;

import android.text.TextUtils;
import com.danikula.videocache.headers.EmptyHeadersInjector;
import com.danikula.videocache.headers.HeaderInjector;
import com.danikula.videocache.sourcestorage.SourceInfoStorage;
import com.danikula.videocache.sourcestorage.SourceInfoStorageFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HttpUrlSource implements Source {
    private static final int MAX_REDIRECTS = 5;
    private HttpURLConnection connection;
    private final HeaderInjector headerInjector;
    private InputStream inputStream;
    private SourceInfo sourceInfo;
    private final SourceInfoStorage sourceInfoStorage;

    public HttpUrlSource(String str) {
        this(str, SourceInfoStorageFactory.newEmptySourceInfoStorage());
        AppMethodBeat.i(223171);
        AppMethodBeat.o(223171);
    }

    public HttpUrlSource(String str, SourceInfoStorage sourceInfoStorage2) {
        this(str, sourceInfoStorage2, new EmptyHeadersInjector());
        AppMethodBeat.i(223172);
        AppMethodBeat.o(223172);
    }

    public HttpUrlSource(String str, SourceInfoStorage sourceInfoStorage2, HeaderInjector headerInjector2) {
        AppMethodBeat.i(183583);
        this.sourceInfoStorage = (SourceInfoStorage) Preconditions.checkNotNull(sourceInfoStorage2);
        this.headerInjector = (HeaderInjector) Preconditions.checkNotNull(headerInjector2);
        SourceInfo sourceInfo2 = sourceInfoStorage2.get(str);
        this.sourceInfo = sourceInfo2 == null ? new SourceInfo(str, -2147483648L, ProxyCacheUtils.getSupposablyMime(str)) : sourceInfo2;
        AppMethodBeat.o(183583);
    }

    public HttpUrlSource(HttpUrlSource httpUrlSource) {
        this.sourceInfo = httpUrlSource.sourceInfo;
        this.sourceInfoStorage = httpUrlSource.sourceInfoStorage;
        this.headerInjector = httpUrlSource.headerInjector;
    }

    @Override // com.danikula.videocache.Source
    public synchronized long length() {
        long j2;
        AppMethodBeat.i(183584);
        if (this.sourceInfo.length == -2147483648L) {
            fetchContentInfo();
        }
        j2 = this.sourceInfo.length;
        AppMethodBeat.o(183584);
        return j2;
    }

    @Override // com.danikula.videocache.Source
    public void open(long j2) {
        AppMethodBeat.i(183585);
        try {
            this.connection = openConnection(j2, -1);
            String contentType = this.connection.getContentType();
            this.inputStream = new BufferedInputStream(this.connection.getInputStream(), 8192);
            this.sourceInfo = new SourceInfo(this.sourceInfo.url, readSourceAvailableBytes(this.connection, j2, this.connection.getResponseCode()), contentType);
            this.sourceInfoStorage.put(this.sourceInfo.url, this.sourceInfo);
            AppMethodBeat.o(183585);
        } catch (IOException e2) {
            ProxyCacheException proxyCacheException = new ProxyCacheException("Error opening connection for " + this.sourceInfo.url + " with offset " + j2, e2);
            AppMethodBeat.o(183585);
            throw proxyCacheException;
        }
    }

    private long readSourceAvailableBytes(HttpURLConnection httpURLConnection, long j2, int i2) {
        AppMethodBeat.i(183586);
        long contentLength = getContentLength(httpURLConnection);
        if (i2 == 200) {
            AppMethodBeat.o(183586);
            return contentLength;
        } else if (i2 == 206) {
            long j3 = contentLength + j2;
            AppMethodBeat.o(183586);
            return j3;
        } else {
            long j4 = this.sourceInfo.length;
            AppMethodBeat.o(183586);
            return j4;
        }
    }

    private long getContentLength(HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(183587);
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            AppMethodBeat.o(183587);
            return -1;
        }
        long parseLong = Long.parseLong(headerField);
        AppMethodBeat.o(183587);
        return parseLong;
    }

    @Override // com.danikula.videocache.Source
    public void close() {
        AppMethodBeat.i(183588);
        if (this.connection != null) {
            try {
                this.connection.disconnect();
                AppMethodBeat.o(183588);
                return;
            } catch (IllegalArgumentException | NullPointerException e2) {
                RuntimeException runtimeException = new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e2);
                AppMethodBeat.o(183588);
                throw runtimeException;
            } catch (ArrayIndexOutOfBoundsException e3) {
                Logger.error("Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue.");
            }
        }
        AppMethodBeat.o(183588);
    }

    @Override // com.danikula.videocache.Source
    public int read(byte[] bArr) {
        AppMethodBeat.i(183589);
        if (this.inputStream == null) {
            ProxyCacheException proxyCacheException = new ProxyCacheException("Error reading data from " + this.sourceInfo.url + ": connection is absent!");
            AppMethodBeat.o(183589);
            throw proxyCacheException;
        }
        try {
            int read = this.inputStream.read(bArr, 0, bArr.length);
            AppMethodBeat.o(183589);
            return read;
        } catch (InterruptedIOException e2) {
            InterruptedProxyCacheException interruptedProxyCacheException = new InterruptedProxyCacheException("Reading source " + this.sourceInfo.url + " is interrupted", e2);
            AppMethodBeat.o(183589);
            throw interruptedProxyCacheException;
        } catch (IOException e3) {
            ProxyCacheException proxyCacheException2 = new ProxyCacheException("Error reading data from " + this.sourceInfo.url, e3);
            AppMethodBeat.o(183589);
            throw proxyCacheException2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void fetchContentInfo() {
        /*
        // Method dump skipped, instructions count: 176
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danikula.videocache.HttpUrlSource.fetchContentInfo():void");
    }

    private HttpURLConnection openConnection(long j2, int i2) {
        HttpURLConnection httpURLConnection;
        boolean z;
        AppMethodBeat.i(183591);
        String str = this.sourceInfo.url;
        int i3 = 0;
        do {
            Logger.debug("Open connection " + (j2 > 0 ? " with offset ".concat(String.valueOf(j2)) : "") + " to " + str);
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            injectCustomHeaders(httpURLConnection, str);
            if (j2 > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j2 + "-");
            }
            if (i2 > 0) {
                httpURLConnection.setConnectTimeout(i2);
                httpURLConnection.setReadTimeout(i2);
            }
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                str = httpURLConnection.getHeaderField("Location");
                i3++;
                httpURLConnection.disconnect();
            }
            if (i3 > 5) {
                ProxyCacheException proxyCacheException = new ProxyCacheException("Too many redirects: ".concat(String.valueOf(i3)));
                AppMethodBeat.o(183591);
                throw proxyCacheException;
            }
        } while (z);
        AppMethodBeat.o(183591);
        return httpURLConnection;
    }

    private void injectCustomHeaders(HttpURLConnection httpURLConnection, String str) {
        AppMethodBeat.i(223173);
        for (Map.Entry<String, String> entry : this.headerInjector.addHeaders(str).entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        AppMethodBeat.o(223173);
    }

    public synchronized String getMime() {
        String str;
        AppMethodBeat.i(183593);
        if (TextUtils.isEmpty(this.sourceInfo.mime)) {
            fetchContentInfo();
        }
        str = this.sourceInfo.mime;
        AppMethodBeat.o(183593);
        return str;
    }

    public String getUrl() {
        return this.sourceInfo.url;
    }

    public String toString() {
        AppMethodBeat.i(183594);
        String str = "HttpUrlSource{sourceInfo='" + this.sourceInfo + "}";
        AppMethodBeat.o(183594);
        return str;
    }
}
