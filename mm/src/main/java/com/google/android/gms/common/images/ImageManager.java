package com.google.android.gms.common.images;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.e.h;
import android.widget.ImageView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.images.ImageRequest;
import com.google.android.gms.common.images.internal.PostProcessedResourceCache;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    public static final int PRIORITY_HIGH = 3;
    public static final int PRIORITY_LOW = 1;
    public static final int PRIORITY_MEDIUM = 2;
    private static final Object zzov = new Object();
    private static HashSet<Uri> zzow = new HashSet<>();
    private static ImageManager zzox;
    private static ImageManager zzoy;
    private final Context mContext;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final ExecutorService zzoz = Executors.newFixedThreadPool(4);
    private final zza zzpa;
    private final PostProcessedResourceCache zzpb;
    private final Map<ImageRequest, ImageReceiver> zzpc;
    private final Map<Uri, ImageReceiver> zzpd;
    private final Map<Uri, Long> zzpe;

    /* access modifiers changed from: package-private */
    @KeepName
    public final class ImageReceiver extends ResultReceiver {
        private final Uri mUri;
        private final ArrayList<ImageRequest> zzpf = new ArrayList<>();

        ImageReceiver(Uri uri) {
            super(new Handler(Looper.getMainLooper()));
            AppMethodBeat.i(11695);
            this.mUri = uri;
            AppMethodBeat.o(11695);
        }

        public final void onReceiveResult(int i2, Bundle bundle) {
            AppMethodBeat.i(11699);
            ImageManager.this.zzoz.execute(new zzb(this.mUri, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
            AppMethodBeat.o(11699);
        }

        public final void zza(ImageRequest imageRequest) {
            AppMethodBeat.i(11696);
            Asserts.checkMainThread("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zzpf.add(imageRequest);
            AppMethodBeat.o(11696);
        }

        public final void zzb(ImageRequest imageRequest) {
            AppMethodBeat.i(11697);
            Asserts.checkMainThread("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zzpf.remove(imageRequest);
            AppMethodBeat.o(11697);
        }

        public final void zzco() {
            AppMethodBeat.i(11698);
            Intent intent = new Intent(Constants.ACTION_LOAD_IMAGE);
            intent.putExtra(Constants.EXTRA_URI, this.mUri);
            intent.putExtra(Constants.EXTRA_RESULT_RECEIVER, this);
            intent.putExtra(Constants.EXTRA_PRIORITY, 3);
            ImageManager.this.mContext.sendBroadcast(intent);
            AppMethodBeat.o(11698);
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    /* access modifiers changed from: package-private */
    public static final class zza extends h<ImageRequest.zza, Bitmap> {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public zza(android.content.Context r5) {
            /*
                r4 = this;
                r3 = 1048576(0x100000, float:1.469368E-39)
                r2 = 11700(0x2db4, float:1.6395E-41)
                java.lang.String r0 = "activity"
                java.lang.Object r0 = r5.getSystemService(r0)
                android.app.ActivityManager r0 = (android.app.ActivityManager) r0
                android.content.pm.ApplicationInfo r1 = r5.getApplicationInfo()
                int r1 = r1.flags
                r1 = r1 & r3
                if (r1 == 0) goto L_0x002e
                r1 = 1
            L_0x0017:
                if (r1 == 0) goto L_0x0030
                int r0 = r0.getLargeMemoryClass()
            L_0x001d:
                int r0 = r0 * r3
                r1 = 1051260355(0x3ea8f5c3, float:0.33)
                float r0 = (float) r0
                float r0 = r0 * r1
                int r0 = (int) r0
                r4.<init>(r0)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                return
            L_0x002e:
                r1 = 0
                goto L_0x0017
            L_0x0030:
                int r0 = r0.getMemoryClass()
                goto L_0x001d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.images.ImageManager.zza.<init>(android.content.Context):void");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [boolean, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // android.support.v4.e.h
        public final /* synthetic */ void entryRemoved(boolean z, ImageRequest.zza zza, Bitmap bitmap, Bitmap bitmap2) {
            AppMethodBeat.i(11702);
            super.entryRemoved(z, zza, bitmap, bitmap2);
            AppMethodBeat.o(11702);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.support.v4.e.h
        public final /* synthetic */ int sizeOf(ImageRequest.zza zza, Bitmap bitmap) {
            AppMethodBeat.i(11701);
            Bitmap bitmap2 = bitmap;
            int height = bitmap2.getHeight() * bitmap2.getRowBytes();
            AppMethodBeat.o(11701);
            return height;
        }
    }

    final class zzb implements Runnable {
        private final Uri mUri;
        private final ParcelFileDescriptor zzph;

        public zzb(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.mUri = uri;
            this.zzph = parcelFileDescriptor;
        }

        public final void run() {
            AppMethodBeat.i(11703);
            Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.zzph != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.zzph.getFileDescriptor());
                } catch (OutOfMemoryError e2) {
                    String valueOf = String.valueOf(this.mUri);
                    new StringBuilder(String.valueOf(valueOf).length() + 34).append("OOM while loading bitmap for uri: ").append(valueOf);
                    z = true;
                }
                try {
                    this.zzph.close();
                } catch (IOException e3) {
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.mHandler.post(new zze(this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
                AppMethodBeat.o(11703);
            } catch (InterruptedException e4) {
                String valueOf2 = String.valueOf(this.mUri);
                new StringBuilder(String.valueOf(valueOf2).length() + 32).append("Latch interrupted while posting ").append(valueOf2);
                AppMethodBeat.o(11703);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final class zzc implements Runnable {
        private final ImageRequest zzpi;

        public zzc(ImageRequest imageRequest) {
            this.zzpi = imageRequest;
        }

        public final void run() {
            AppMethodBeat.i(11704);
            Asserts.checkMainThread("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zzpc.get(this.zzpi);
            if (imageReceiver != null) {
                ImageManager.this.zzpc.remove(this.zzpi);
                imageReceiver.zzb(this.zzpi);
            }
            ImageRequest.zza zza = this.zzpi.zzpk;
            if (zza.uri == null) {
                this.zzpi.zza(ImageManager.this.mContext, ImageManager.this.zzpb, true);
                AppMethodBeat.o(11704);
                return;
            }
            Bitmap zza2 = ImageManager.zza(ImageManager.this, zza);
            if (zza2 != null) {
                this.zzpi.zza(ImageManager.this.mContext, zza2, true);
                AppMethodBeat.o(11704);
                return;
            }
            Long l = (Long) ImageManager.this.zzpe.get(zza.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < Util.MILLSECONDS_OF_HOUR) {
                    this.zzpi.zza(ImageManager.this.mContext, ImageManager.this.zzpb, true);
                    AppMethodBeat.o(11704);
                    return;
                }
                ImageManager.this.zzpe.remove(zza.uri);
            }
            this.zzpi.zza(ImageManager.this.mContext, ImageManager.this.zzpb);
            ImageReceiver imageReceiver2 = (ImageReceiver) ImageManager.this.zzpd.get(zza.uri);
            if (imageReceiver2 == null) {
                imageReceiver2 = new ImageReceiver(zza.uri);
                ImageManager.this.zzpd.put(zza.uri, imageReceiver2);
            }
            imageReceiver2.zza(this.zzpi);
            if (!(this.zzpi instanceof ImageRequest.ListenerImageRequest)) {
                ImageManager.this.zzpc.put(this.zzpi, imageReceiver2);
            }
            synchronized (ImageManager.zzov) {
                try {
                    if (!ImageManager.zzow.contains(zza.uri)) {
                        ImageManager.zzow.add(zza.uri);
                        imageReceiver2.zzco();
                    }
                } finally {
                    AppMethodBeat.o(11704);
                }
            }
        }
    }

    static final class zzd implements ComponentCallbacks2 {
        private final zza zzpa;

        public zzd(zza zza) {
            this.zzpa = zza;
        }

        public final void onConfigurationChanged(Configuration configuration) {
        }

        public final void onLowMemory() {
            AppMethodBeat.i(11705);
            this.zzpa.evictAll();
            AppMethodBeat.o(11705);
        }

        public final void onTrimMemory(int i2) {
            AppMethodBeat.i(11706);
            if (i2 >= 60) {
                this.zzpa.evictAll();
                AppMethodBeat.o(11706);
                return;
            }
            if (i2 >= 20) {
                this.zzpa.trimToSize(this.zzpa.size() / 2);
            }
            AppMethodBeat.o(11706);
        }
    }

    final class zze implements Runnable {
        private final Bitmap mBitmap;
        private final Uri mUri;
        private final CountDownLatch zzfd;
        private boolean zzpj;

        public zze(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.zzpj = z;
            this.zzfd = countDownLatch;
        }

        public final void run() {
            AppMethodBeat.i(11707);
            Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (ImageManager.this.zzpa != null) {
                if (this.zzpj) {
                    ImageManager.this.zzpa.evictAll();
                    System.gc();
                    this.zzpj = false;
                    ImageManager.this.mHandler.post(this);
                    AppMethodBeat.o(11707);
                    return;
                } else if (z) {
                    ImageManager.this.zzpa.put(new ImageRequest.zza(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zzpd.remove(this.mUri);
            if (imageReceiver != null) {
                ArrayList arrayList = imageReceiver.zzpf;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ImageRequest imageRequest = (ImageRequest) arrayList.get(i2);
                    if (z) {
                        imageRequest.zza(ImageManager.this.mContext, this.mBitmap, false);
                    } else {
                        ImageManager.this.zzpe.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                        imageRequest.zza(ImageManager.this.mContext, ImageManager.this.zzpb, false);
                    }
                    if (!(imageRequest instanceof ImageRequest.ListenerImageRequest)) {
                        ImageManager.this.zzpc.remove(imageRequest);
                    }
                }
            }
            this.zzfd.countDown();
            synchronized (ImageManager.zzov) {
                try {
                    ImageManager.zzow.remove(this.mUri);
                } finally {
                    AppMethodBeat.o(11707);
                }
            }
        }
    }

    static {
        AppMethodBeat.i(11719);
        AppMethodBeat.o(11719);
    }

    private ImageManager(Context context, boolean z) {
        AppMethodBeat.i(11710);
        this.mContext = context.getApplicationContext();
        if (z) {
            this.zzpa = new zza(this.mContext);
            this.mContext.registerComponentCallbacks(new zzd(this.zzpa));
        } else {
            this.zzpa = null;
        }
        this.zzpb = new PostProcessedResourceCache();
        this.zzpc = new HashMap();
        this.zzpd = new HashMap();
        this.zzpe = new HashMap();
        AppMethodBeat.o(11710);
    }

    public static ImageManager create(Context context) {
        AppMethodBeat.i(11708);
        ImageManager create = create(context, false);
        AppMethodBeat.o(11708);
        return create;
    }

    public static ImageManager create(Context context, boolean z) {
        AppMethodBeat.i(11709);
        if (z) {
            if (zzoy == null) {
                zzoy = new ImageManager(context, true);
            }
            ImageManager imageManager = zzoy;
            AppMethodBeat.o(11709);
            return imageManager;
        }
        if (zzox == null) {
            zzox = new ImageManager(context, false);
        }
        ImageManager imageManager2 = zzox;
        AppMethodBeat.o(11709);
        return imageManager2;
    }

    static /* synthetic */ Bitmap zza(ImageManager imageManager, ImageRequest.zza zza2) {
        AppMethodBeat.i(11718);
        Bitmap zza3 = imageManager.zza(zza2);
        AppMethodBeat.o(11718);
        return zza3;
    }

    private final Bitmap zza(ImageRequest.zza zza2) {
        AppMethodBeat.i(11717);
        if (this.zzpa == null) {
            AppMethodBeat.o(11717);
            return null;
        }
        Bitmap bitmap = (Bitmap) this.zzpa.get(zza2);
        AppMethodBeat.o(11717);
        return bitmap;
    }

    public final void loadImage(ImageView imageView, int i2) {
        AppMethodBeat.i(11712);
        loadImage(new ImageRequest.ImageViewImageRequest(imageView, i2));
        AppMethodBeat.o(11712);
    }

    public final void loadImage(ImageView imageView, Uri uri) {
        AppMethodBeat.i(11711);
        loadImage(new ImageRequest.ImageViewImageRequest(imageView, uri));
        AppMethodBeat.o(11711);
    }

    public final void loadImage(ImageView imageView, Uri uri, int i2) {
        AppMethodBeat.i(11713);
        ImageRequest.ImageViewImageRequest imageViewImageRequest = new ImageRequest.ImageViewImageRequest(imageView, uri);
        imageViewImageRequest.setNoDataPlaceholder(i2);
        loadImage(imageViewImageRequest);
        AppMethodBeat.o(11713);
    }

    public final void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        AppMethodBeat.i(11714);
        loadImage(new ImageRequest.ListenerImageRequest(onImageLoadedListener, uri));
        AppMethodBeat.o(11714);
    }

    public final void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i2) {
        AppMethodBeat.i(11715);
        ImageRequest.ListenerImageRequest listenerImageRequest = new ImageRequest.ListenerImageRequest(onImageLoadedListener, uri);
        listenerImageRequest.setNoDataPlaceholder(i2);
        loadImage(listenerImageRequest);
        AppMethodBeat.o(11715);
    }

    public final void loadImage(ImageRequest imageRequest) {
        AppMethodBeat.i(11716);
        Asserts.checkMainThread("ImageManager.loadImage() must be called in the main thread");
        new zzc(imageRequest).run();
        AppMethodBeat.o(11716);
    }
}
