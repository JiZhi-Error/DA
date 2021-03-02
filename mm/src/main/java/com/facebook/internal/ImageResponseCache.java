package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* access modifiers changed from: package-private */
public class ImageResponseCache {
    static final String TAG = ImageResponseCache.class.getSimpleName();
    private static FileLruCache imageCache;

    ImageResponseCache() {
    }

    static {
        AppMethodBeat.i(17834);
        AppMethodBeat.o(17834);
    }

    static synchronized FileLruCache getCache(Context context) {
        FileLruCache fileLruCache;
        synchronized (ImageResponseCache.class) {
            AppMethodBeat.i(17829);
            if (imageCache == null) {
                imageCache = new FileLruCache(TAG, new FileLruCache.Limits());
            }
            fileLruCache = imageCache;
            AppMethodBeat.o(17829);
        }
        return fileLruCache;
    }

    static InputStream getCachedImageStream(Uri uri, Context context) {
        AppMethodBeat.i(17830);
        InputStream inputStream = null;
        if (uri != null && isCDNURL(uri)) {
            try {
                inputStream = getCache(context).get(uri.toString());
            } catch (IOException e2) {
                Logger.log(LoggingBehavior.CACHE, 5, TAG, e2.toString());
            }
        }
        AppMethodBeat.o(17830);
        return inputStream;
    }

    static InputStream interceptAndCacheImageStream(Context context, HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(17831);
        InputStream inputStream = null;
        if (httpURLConnection.getResponseCode() == 200) {
            Uri parse = Uri.parse(httpURLConnection.getURL().toString());
            inputStream = httpURLConnection.getInputStream();
            try {
                if (isCDNURL(parse)) {
                    inputStream = getCache(context).interceptAndPut(parse.toString(), new BufferedHttpInputStream(inputStream, httpURLConnection));
                }
            } catch (IOException e2) {
            }
        }
        AppMethodBeat.o(17831);
        return inputStream;
    }

    private static boolean isCDNURL(Uri uri) {
        AppMethodBeat.i(17832);
        if (uri != null) {
            String host = uri.getHost();
            if (host.endsWith("fbcdn.net")) {
                AppMethodBeat.o(17832);
                return true;
            } else if (host.startsWith("fbcdn") && host.endsWith("akamaihd.net")) {
                AppMethodBeat.o(17832);
                return true;
            }
        }
        AppMethodBeat.o(17832);
        return false;
    }

    static void clearCache(Context context) {
        AppMethodBeat.i(17833);
        try {
            getCache(context).clearCache();
            AppMethodBeat.o(17833);
        } catch (IOException e2) {
            Logger.log(LoggingBehavior.CACHE, 5, TAG, "clearCache failed " + e2.getMessage());
            AppMethodBeat.o(17833);
        }
    }

    static class BufferedHttpInputStream extends BufferedInputStream {
        HttpURLConnection connection;

        BufferedHttpInputStream(InputStream inputStream, HttpURLConnection httpURLConnection) {
            super(inputStream, 8192);
            this.connection = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.BufferedInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
        public void close() {
            AppMethodBeat.i(17828);
            super.close();
            Utility.disconnectQuietly(this.connection);
            AppMethodBeat.o(17828);
        }
    }
}
