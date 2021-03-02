package com.facebook.internal;

import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.facebook.internal.FileLruCache;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/* access modifiers changed from: package-private */
public class UrlRedirectCache {
    private static final String REDIRECT_CONTENT_TAG = (TAG + "_Redirect");
    static final String TAG = UrlRedirectCache.class.getSimpleName();
    private static FileLruCache urlRedirectCache;

    UrlRedirectCache() {
    }

    static {
        AppMethodBeat.i(17925);
        AppMethodBeat.o(17925);
    }

    static synchronized FileLruCache getCache() {
        FileLruCache fileLruCache;
        synchronized (UrlRedirectCache.class) {
            AppMethodBeat.i(17921);
            if (urlRedirectCache == null) {
                urlRedirectCache = new FileLruCache(TAG, new FileLruCache.Limits());
            }
            fileLruCache = urlRedirectCache;
            AppMethodBeat.o(17921);
        }
        return fileLruCache;
    }

    static Uri getRedirectedUri(Uri uri) {
        InputStreamReader inputStreamReader;
        Throwable th;
        InputStreamReader inputStreamReader2;
        AppMethodBeat.i(17922);
        if (uri == null) {
            AppMethodBeat.o(17922);
            return null;
        }
        String uri2 = uri.toString();
        try {
            FileLruCache cache = getCache();
            boolean z = false;
            inputStreamReader2 = null;
            while (true) {
                try {
                    InputStream inputStream = cache.get(uri2, REDIRECT_CONTENT_TAG);
                    if (inputStream == null) {
                        break;
                    }
                    z = true;
                    inputStreamReader = new InputStreamReader(inputStream);
                    try {
                        char[] cArr = new char[128];
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            int read = inputStreamReader.read(cArr, 0, 128);
                            if (read <= 0) {
                                break;
                            }
                            sb.append(cArr, 0, read);
                        }
                        Utility.closeQuietly(inputStreamReader);
                        uri2 = sb.toString();
                        inputStreamReader2 = inputStreamReader;
                    } catch (IOException e2) {
                        Utility.closeQuietly(inputStreamReader);
                        AppMethodBeat.o(17922);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStreamReader2 = inputStreamReader;
                        Utility.closeQuietly(inputStreamReader2);
                        AppMethodBeat.o(17922);
                        throw th;
                    }
                } catch (IOException e3) {
                    inputStreamReader = inputStreamReader2;
                    Utility.closeQuietly(inputStreamReader);
                    AppMethodBeat.o(17922);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    Utility.closeQuietly(inputStreamReader2);
                    AppMethodBeat.o(17922);
                    throw th;
                }
            }
            if (z) {
                Uri parse = Uri.parse(uri2);
                Utility.closeQuietly(inputStreamReader2);
                AppMethodBeat.o(17922);
                return parse;
            }
            Utility.closeQuietly(inputStreamReader2);
            AppMethodBeat.o(17922);
            return null;
        } catch (IOException e4) {
            inputStreamReader = null;
            Utility.closeQuietly(inputStreamReader);
            AppMethodBeat.o(17922);
            return null;
        } catch (Throwable th4) {
            th = th4;
            inputStreamReader2 = null;
            Utility.closeQuietly(inputStreamReader2);
            AppMethodBeat.o(17922);
            throw th;
        }
    }

    static void cacheUriRedirect(Uri uri, Uri uri2) {
        AppMethodBeat.i(17923);
        if (uri == null || uri2 == null) {
            AppMethodBeat.o(17923);
            return;
        }
        OutputStream outputStream = null;
        try {
            outputStream = getCache().openPutStream(uri.toString(), REDIRECT_CONTENT_TAG);
            outputStream.write(uri2.toString().getBytes());
        } catch (IOException e2) {
        } finally {
            Utility.closeQuietly(outputStream);
            AppMethodBeat.o(17923);
        }
    }

    static void clearCache() {
        AppMethodBeat.i(17924);
        try {
            getCache().clearCache();
            AppMethodBeat.o(17924);
        } catch (IOException e2) {
            Logger.log(LoggingBehavior.CACHE, 5, TAG, "clearCache failed " + e2.getMessage());
            AppMethodBeat.o(17924);
        }
    }
}
