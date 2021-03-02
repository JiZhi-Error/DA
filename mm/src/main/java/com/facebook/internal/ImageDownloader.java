package com.facebook.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.facebook.internal.WorkQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ImageDownloader {
    private static final int CACHE_READ_QUEUE_MAX_CONCURRENT = 2;
    private static final int DOWNLOAD_QUEUE_MAX_CONCURRENT = 8;
    private static WorkQueue cacheReadQueue = new WorkQueue(2);
    private static WorkQueue downloadQueue = new WorkQueue(8);
    private static Handler handler;
    private static final Map<RequestKey, DownloaderContext> pendingRequests = new HashMap();

    static /* synthetic */ void access$100(RequestKey requestKey, Context context, boolean z) {
        AppMethodBeat.i(17821);
        readFromCache(requestKey, context, z);
        AppMethodBeat.o(17821);
    }

    static /* synthetic */ void access$200(RequestKey requestKey, Context context) {
        AppMethodBeat.i(17822);
        download(requestKey, context);
        AppMethodBeat.o(17822);
    }

    static {
        AppMethodBeat.i(17823);
        AppMethodBeat.o(17823);
    }

    public static void downloadAsync(ImageRequest imageRequest) {
        AppMethodBeat.i(17809);
        if (imageRequest == null) {
            AppMethodBeat.o(17809);
            return;
        }
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        synchronized (pendingRequests) {
            try {
                DownloaderContext downloaderContext = pendingRequests.get(requestKey);
                if (downloaderContext != null) {
                    downloaderContext.request = imageRequest;
                    downloaderContext.isCancelled = false;
                    downloaderContext.workItem.moveToFront();
                } else {
                    enqueueCacheRead(imageRequest, requestKey, imageRequest.isCachedRedirectAllowed());
                }
            } finally {
                AppMethodBeat.o(17809);
            }
        }
    }

    public static boolean cancelRequest(ImageRequest imageRequest) {
        boolean z;
        AppMethodBeat.i(17810);
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        synchronized (pendingRequests) {
            try {
                DownloaderContext downloaderContext = pendingRequests.get(requestKey);
                if (downloaderContext == null) {
                    z = false;
                } else if (downloaderContext.workItem.cancel()) {
                    pendingRequests.remove(requestKey);
                    z = true;
                } else {
                    downloaderContext.isCancelled = true;
                    z = true;
                }
            } finally {
                AppMethodBeat.o(17810);
            }
        }
        return z;
    }

    public static void prioritizeRequest(ImageRequest imageRequest) {
        AppMethodBeat.i(17811);
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        synchronized (pendingRequests) {
            try {
                DownloaderContext downloaderContext = pendingRequests.get(requestKey);
                if (downloaderContext != null) {
                    downloaderContext.workItem.moveToFront();
                }
            } finally {
                AppMethodBeat.o(17811);
            }
        }
    }

    public static void clearCache(Context context) {
        AppMethodBeat.i(17812);
        ImageResponseCache.clearCache(context);
        UrlRedirectCache.clearCache();
        AppMethodBeat.o(17812);
    }

    private static void enqueueCacheRead(ImageRequest imageRequest, RequestKey requestKey, boolean z) {
        AppMethodBeat.i(17813);
        enqueueRequest(imageRequest, requestKey, cacheReadQueue, new CacheReadWorkItem(imageRequest.getContext(), requestKey, z));
        AppMethodBeat.o(17813);
    }

    private static void enqueueDownload(ImageRequest imageRequest, RequestKey requestKey) {
        AppMethodBeat.i(17814);
        enqueueRequest(imageRequest, requestKey, downloadQueue, new DownloadImageWorkItem(imageRequest.getContext(), requestKey));
        AppMethodBeat.o(17814);
    }

    private static void enqueueRequest(ImageRequest imageRequest, RequestKey requestKey, WorkQueue workQueue, Runnable runnable) {
        AppMethodBeat.i(17815);
        synchronized (pendingRequests) {
            try {
                DownloaderContext downloaderContext = new DownloaderContext();
                downloaderContext.request = imageRequest;
                pendingRequests.put(requestKey, downloaderContext);
                downloaderContext.workItem = workQueue.addActiveWorkItem(runnable);
            } finally {
                AppMethodBeat.o(17815);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r1 = r0.request;
        r5 = r1.getCallback();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void issueResponse(com.facebook.internal.ImageDownloader.RequestKey r8, final java.lang.Exception r9, final android.graphics.Bitmap r10, final boolean r11) {
        /*
            r7 = 17816(0x4598, float:2.4966E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r7)
            com.facebook.internal.ImageDownloader$DownloaderContext r0 = removePendingRequest(r8)
            if (r0 == 0) goto L_0x0026
            boolean r1 = r0.isCancelled
            if (r1 != 0) goto L_0x0026
            com.facebook.internal.ImageRequest r1 = r0.request
            com.facebook.internal.ImageRequest$Callback r5 = r1.getCallback()
            if (r5 == 0) goto L_0x0026
            android.os.Handler r6 = getHandler()
            com.facebook.internal.ImageDownloader$1 r0 = new com.facebook.internal.ImageDownloader$1
            r2 = r9
            r3 = r11
            r4 = r10
            r0.<init>(r1, r2, r3, r4, r5)
            r6.post(r0)
        L_0x0026:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.ImageDownloader.issueResponse(com.facebook.internal.ImageDownloader$RequestKey, java.lang.Exception, android.graphics.Bitmap, boolean):void");
    }

    private static void readFromCache(RequestKey requestKey, Context context, boolean z) {
        boolean z2;
        InputStream inputStream;
        InputStream inputStream2;
        Uri redirectedUri;
        boolean z3 = false;
        AppMethodBeat.i(17817);
        if (!z || (redirectedUri = UrlRedirectCache.getRedirectedUri(requestKey.uri)) == null) {
            z2 = false;
            inputStream = null;
        } else {
            inputStream = ImageResponseCache.getCachedImageStream(redirectedUri, context);
            if (inputStream != null) {
                z3 = true;
            }
            z2 = z3;
        }
        if (!z2) {
            inputStream2 = ImageResponseCache.getCachedImageStream(requestKey.uri, context);
        } else {
            inputStream2 = inputStream;
        }
        if (inputStream2 != null) {
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream2);
            Utility.closeQuietly(inputStream2);
            issueResponse(requestKey, null, decodeStream, z2);
            AppMethodBeat.o(17817);
            return;
        }
        DownloaderContext removePendingRequest = removePendingRequest(requestKey);
        if (removePendingRequest != null && !removePendingRequest.isCancelled) {
            enqueueDownload(removePendingRequest.request, requestKey);
        }
        AppMethodBeat.o(17817);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c4, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c5, code lost:
        r6 = null;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00cf, code lost:
        r3 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d0, code lost:
        r5 = true;
        r6 = null;
        r7 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c4 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:4:0x001a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void download(com.facebook.internal.ImageDownloader.RequestKey r11, android.content.Context r12) {
        /*
        // Method dump skipped, instructions count: 240
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.ImageDownloader.download(com.facebook.internal.ImageDownloader$RequestKey, android.content.Context):void");
    }

    private static synchronized Handler getHandler() {
        Handler handler2;
        synchronized (ImageDownloader.class) {
            AppMethodBeat.i(17819);
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler2 = handler;
            AppMethodBeat.o(17819);
        }
        return handler2;
    }

    private static DownloaderContext removePendingRequest(RequestKey requestKey) {
        DownloaderContext remove;
        AppMethodBeat.i(17820);
        synchronized (pendingRequests) {
            try {
                remove = pendingRequests.remove(requestKey);
            } finally {
                AppMethodBeat.o(17820);
            }
        }
        return remove;
    }

    /* access modifiers changed from: package-private */
    public static class RequestKey {
        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;
        Object tag;
        Uri uri;

        RequestKey(Uri uri2, Object obj) {
            this.uri = uri2;
            this.tag = obj;
        }

        public int hashCode() {
            AppMethodBeat.i(17808);
            int hashCode = ((this.uri.hashCode() + 1073) * 37) + this.tag.hashCode();
            AppMethodBeat.o(17808);
            return hashCode;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof RequestKey)) {
                return false;
            }
            RequestKey requestKey = (RequestKey) obj;
            if (requestKey.uri == this.uri && requestKey.tag == this.tag) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public static class DownloaderContext {
        boolean isCancelled;
        ImageRequest request;
        WorkQueue.WorkItem workItem;

        private DownloaderContext() {
        }
    }

    /* access modifiers changed from: package-private */
    public static class CacheReadWorkItem implements Runnable {
        private boolean allowCachedRedirects;
        private Context context;
        private RequestKey key;

        CacheReadWorkItem(Context context2, RequestKey requestKey, boolean z) {
            this.context = context2;
            this.key = requestKey;
            this.allowCachedRedirects = z;
        }

        public void run() {
            AppMethodBeat.i(17806);
            ImageDownloader.access$100(this.key, this.context, this.allowCachedRedirects);
            AppMethodBeat.o(17806);
        }
    }

    /* access modifiers changed from: package-private */
    public static class DownloadImageWorkItem implements Runnable {
        private Context context;
        private RequestKey key;

        DownloadImageWorkItem(Context context2, RequestKey requestKey) {
            this.context = context2;
            this.key = requestKey;
        }

        public void run() {
            AppMethodBeat.i(17807);
            ImageDownloader.access$200(this.key, this.context);
            AppMethodBeat.o(17807);
        }
    }
}
