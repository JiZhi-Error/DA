package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import android.support.annotation.Keep;
import android.util.Base64;
import com.github.henryye.nativeiv.a.c;
import com.github.henryye.nativeiv.api.IImageDecodeService;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Keep
public class BaseImageDecodeService implements IImageDecodeService {
    private static final String TAG = "BaseImageDecodeService";
    private IImageDecodeService.b mCompactDecodeEventListener = new a(this, (byte) 0);
    private List<IImageDecodeService.b> mDecodeEventListeners = new LinkedList();
    private IImageDecodeService.a mDecodeSlave = null;
    private com.github.henryye.nativeiv.b.b mFallbackImageStreamFetcher;
    private com.github.henryye.nativeiv.b.a mHttpImageStreamFetcher = new com.github.henryye.nativeiv.b.a();
    private LinkedList<com.github.henryye.nativeiv.b.b> mImageStreamFetcherList = new LinkedList<>();
    private boolean mIsTrackInitImages = false;

    public BaseImageDecodeService() {
        AppMethodBeat.i(127304);
        addImageStreamFetcher(this.mHttpImageStreamFetcher, false);
        setBitmapDecodeSlave(new a());
        AppMethodBeat.o(127304);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void init() {
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void release() {
        AppMethodBeat.i(127305);
        if (this.mDecodeSlave != null) {
            this.mDecodeSlave.destroy();
            this.mDecodeSlave = null;
        }
        AppMethodBeat.o(127305);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public Bitmap getBitmap(int i2, int i3) {
        AppMethodBeat.i(127306);
        Bitmap aX = e.sR().baK.aX(i2, i3);
        AppMethodBeat.o(127306);
        return aX;
    }

    private Bitmap.CompressFormat ensureCompressFormat(String str) {
        AppMethodBeat.i(127307);
        if ("image/webp".equals(str)) {
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.WEBP;
            AppMethodBeat.o(127307);
            return compressFormat;
        } else if ("image/jpeg".equals(str) || "image/jpg".equals(str)) {
            Bitmap.CompressFormat compressFormat2 = Bitmap.CompressFormat.JPEG;
            AppMethodBeat.o(127307);
            return compressFormat2;
        } else {
            Bitmap.CompressFormat compressFormat3 = Bitmap.CompressFormat.PNG;
            AppMethodBeat.o(127307);
            return compressFormat3;
        }
    }

    private Bitmap.CompressFormat ensureCompressFormat(int i2) {
        switch (i2) {
            case 1:
                return Bitmap.CompressFormat.WEBP;
            case 2:
                return Bitmap.CompressFormat.JPEG;
            default:
                return Bitmap.CompressFormat.PNG;
        }
    }

    private int ensureQuality(float f2) {
        if (f2 < 0.0f || f2 > 1.0f) {
            f2 = 0.92f;
        }
        return (int) (100.0f * f2);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public String encodeToBase64(Bitmap bitmap, int i2, float f2) {
        AppMethodBeat.i(127308);
        if (bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0 || bitmap.isRecycled()) {
            AppMethodBeat.o(127308);
            return null;
        }
        Bitmap.CompressFormat ensureCompressFormat = ensureCompressFormat(i2);
        int ensureQuality = ensureQuality(f2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean compress = bitmap.compress(ensureCompressFormat, ensureQuality, byteArrayOutputStream);
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            com.github.henryye.nativeiv.a.b.e(TAG, "base64_encode IOException e %s", e2.toString());
            compress = false;
        }
        if (!compress || byteArrayOutputStream.size() <= 0) {
            com.github.henryye.nativeiv.a.b.e(TAG, "base64_encode Bitmap compress error.", new Object[0]);
            AppMethodBeat.o(127308);
            return null;
        }
        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
        AppMethodBeat.o(127308);
        return encodeToString;
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public byte[] encodeToBuffer(Bitmap bitmap, int i2, float f2) {
        AppMethodBeat.i(127309);
        if (bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0 || bitmap.isRecycled()) {
            AppMethodBeat.o(127309);
            return null;
        }
        Bitmap.CompressFormat ensureCompressFormat = ensureCompressFormat(i2);
        int ensureQuality = ensureQuality(f2);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean compress = bitmap.compress(ensureCompressFormat, ensureQuality, byteArrayOutputStream);
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            com.github.henryye.nativeiv.a.b.e(TAG, "encodeToBuffer IOException e %s", e2.toString());
            compress = false;
        }
        if (!compress || byteArrayOutputStream.size() <= 0) {
            com.github.henryye.nativeiv.a.b.e(TAG, "encodeToBuffer Bitmap compress error.", new Object[0]);
            AppMethodBeat.o(127309);
            return null;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(127309);
        return byteArray;
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void releaseBitmap(Bitmap bitmap) {
        AppMethodBeat.i(127310);
        if (bitmap == null) {
            AppMethodBeat.o(127310);
            return;
        }
        com.github.henryye.nativeiv.a.b.i(TAG, "recycle because releaseBitmap", new Object[0]);
        bitmap.recycle();
        AppMethodBeat.o(127310);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public IBitmap loadBitmapSync(Object obj, ImageDecodeConfig imageDecodeConfig) {
        com.github.henryye.nativeiv.b.b bVar;
        AppMethodBeat.i(127311);
        if (imageDecodeConfig == null) {
            imageDecodeConfig = new ImageDecodeConfig();
        }
        Iterator<com.github.henryye.nativeiv.b.b> it = this.mImageStreamFetcherList.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            bVar = it.next();
            if (bVar.accept(obj)) {
                break;
            }
        }
        if (bVar == null) {
            bVar = this.mFallbackImageStreamFetcher;
        }
        if (bVar == null) {
            com.github.henryye.nativeiv.a.b.e(TAG, "No fit image stream fetcher found for %s", obj.toString());
            AppMethodBeat.o(127311);
            return null;
        }
        IImageDecodeService.a aVar = this.mDecodeSlave;
        if (aVar == null || aVar.isDestroyed()) {
            com.github.henryye.nativeiv.a.b.w(TAG, "BitmapDecodeSlave destroyed", new Object[0]);
            AppMethodBeat.o(127311);
            return null;
        }
        IBitmap a2 = aVar.a(obj.toString(), obj, bVar, imageDecodeConfig);
        AppMethodBeat.o(127311);
        return a2;
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public IBitmap loadBitmapSync(String str) {
        AppMethodBeat.i(127312);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(127312);
            return null;
        }
        IBitmap loadBitmapSync = loadBitmapSync(str, new ImageDecodeConfig());
        AppMethodBeat.o(127312);
        return loadBitmapSync;
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public IBitmap loadBitmapSync(String str, ImageDecodeConfig imageDecodeConfig) {
        AppMethodBeat.i(127313);
        IBitmap loadBitmapSync = loadBitmapSync((Object) str, imageDecodeConfig);
        AppMethodBeat.o(127313);
        return loadBitmapSync;
    }

    public static class b implements IImageDecodeService.c {
        @Override // com.github.henryye.nativeiv.api.IImageDecodeService.c
        public final void ad(Object obj) {
            AppMethodBeat.i(127301);
            if (obj != null) {
                ((IBitmap) obj).recycle();
            }
            AppMethodBeat.o(127301);
        }
    }

    /* access modifiers changed from: package-private */
    public static class c implements Runnable {
        private Object bam;
        private ImageDecodeConfig ban;
        private WeakReference<BaseImageDecodeService> bao;
        private final b bap = new b();
        private volatile boolean ue = false;

        c(BaseImageDecodeService baseImageDecodeService, Object obj, ImageDecodeConfig imageDecodeConfig) {
            AppMethodBeat.i(127302);
            this.bam = obj;
            this.ban = imageDecodeConfig;
            this.bao = new WeakReference<>(baseImageDecodeService);
            AppMethodBeat.o(127302);
        }

        public final void run() {
            AppMethodBeat.i(127303);
            if (this.ue) {
                AppMethodBeat.o(127303);
            } else if (this.bao.get() == null) {
                AppMethodBeat.o(127303);
            } else {
                IBitmap loadBitmapSync = this.bao.get().loadBitmapSync(this.bam, this.ban);
                if (this.ue) {
                    if (loadBitmapSync != null) {
                        loadBitmapSync.recycle();
                    }
                    AppMethodBeat.o(127303);
                    return;
                }
                this.bao.get().mCompactDecodeEventListener.a(this.bam.toString(), loadBitmapSync, this.bap, this.ban);
                AppMethodBeat.o(127303);
            }
        }
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void loadBitmapAsync(String str) {
        AppMethodBeat.i(127314);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(127314);
            return;
        }
        loadBitmapAsync(str, new ImageDecodeConfig());
        AppMethodBeat.o(127314);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void loadBitmapAsync(String str, ImageDecodeConfig imageDecodeConfig) {
        AppMethodBeat.i(127315);
        loadBitmapAsync((Object) str, imageDecodeConfig);
        AppMethodBeat.o(127315);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void loadBitmapAsync(Object obj, ImageDecodeConfig imageDecodeConfig) {
        AppMethodBeat.i(127316);
        if (imageDecodeConfig == null) {
            imageDecodeConfig = new ImageDecodeConfig();
        }
        runInThreadPool(obj, new c(this, obj, imageDecodeConfig));
        AppMethodBeat.o(127316);
    }

    private void runInThreadPool(Object obj, Runnable runnable) {
        AppMethodBeat.i(127317);
        if (this.mHttpImageStreamFetcher.accept(obj)) {
            d.INSTANCE.baE.execute(runnable);
            AppMethodBeat.o(127317);
            return;
        }
        d.INSTANCE.baF.execute(runnable);
        AppMethodBeat.o(127317);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void addImageStreamFetcher(com.github.henryye.nativeiv.b.b bVar, boolean z) {
        AppMethodBeat.i(127318);
        com.github.henryye.nativeiv.a.b.i(TAG, "hy: %d adding stream fetcher: %s %b", Integer.valueOf(hashCode()), bVar.getClass().getSimpleName(), Boolean.valueOf(z));
        if (!z) {
            this.mImageStreamFetcherList.push(bVar);
            AppMethodBeat.o(127318);
            return;
        }
        this.mFallbackImageStreamFetcher = bVar;
        AppMethodBeat.o(127318);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void removeImageStreamFetcher(com.github.henryye.nativeiv.b.b bVar, boolean z) {
        AppMethodBeat.i(127319);
        com.github.henryye.nativeiv.a.b.i(TAG, "hy: %d removing stream fetcher: %s %b", Integer.valueOf(hashCode()), bVar.getClass().getSimpleName(), Boolean.valueOf(z));
        if (!z) {
            this.mImageStreamFetcherList.remove(bVar);
            AppMethodBeat.o(127319);
            return;
        }
        this.mFallbackImageStreamFetcher = null;
        AppMethodBeat.o(127319);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void setIdKeyReportDelegate(c.a aVar) {
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void setKvReportDelegate(c.b bVar) {
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void setBitmapDecodeSlave(IImageDecodeService.a aVar) {
        AppMethodBeat.i(127320);
        this.mDecodeSlave = aVar;
        this.mDecodeSlave.a(this.mCompactDecodeEventListener);
        AppMethodBeat.o(127320);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void addDecodeEventListener(IImageDecodeService.b bVar) {
        AppMethodBeat.i(127321);
        this.mDecodeEventListeners.add(bVar);
        AppMethodBeat.o(127321);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void removeDecodeEventListener(IImageDecodeService.b bVar) {
        AppMethodBeat.i(127322);
        this.mDecodeEventListeners.remove(bVar);
        AppMethodBeat.o(127322);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void setMaxDecodeDimension(int i2, int i3) {
        AppMethodBeat.i(127323);
        this.mDecodeSlave.aW(i2, i3);
        AppMethodBeat.o(127323);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void setNetworkTimeout(int i2, int i3) {
        AppMethodBeat.i(127324);
        com.github.henryye.nativeiv.b.a aVar = this.mHttpImageStreamFetcher;
        if (i2 <= 0 || i3 <= 0) {
            AppMethodBeat.o(127324);
            return;
        }
        aVar.bbs = i2;
        aVar.bbt = i3;
        com.github.henryye.nativeiv.a.b.i("NativeImageHttpFetcher", "Http Timeout Set: connection[%d] read[%d]", Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(127324);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void forceSetUseType(BitmapType bitmapType) {
        AppMethodBeat.i(127325);
        this.mDecodeSlave.forceSetUseType(bitmapType);
        AppMethodBeat.o(127325);
    }

    class a implements IImageDecodeService.b {
        private a() {
        }

        /* synthetic */ a(BaseImageDecodeService baseImageDecodeService, byte b2) {
            this();
        }

        @Override // com.github.henryye.nativeiv.api.IImageDecodeService.b
        public final void a(String str, IImageDecodeService.b.a aVar, com.github.henryye.nativeiv.api.a aVar2) {
            AppMethodBeat.i(127299);
            for (IImageDecodeService.b bVar : BaseImageDecodeService.this.mDecodeEventListeners) {
                bVar.a(str, aVar, aVar2);
            }
            AppMethodBeat.o(127299);
        }

        @Override // com.github.henryye.nativeiv.api.IImageDecodeService.b
        public final void a(String str, Object obj, IImageDecodeService.c cVar, ImageDecodeConfig imageDecodeConfig) {
            AppMethodBeat.i(127300);
            for (IImageDecodeService.b bVar : BaseImageDecodeService.this.mDecodeEventListeners) {
                bVar.a(str, obj, cVar, imageDecodeConfig);
            }
            AppMethodBeat.o(127300);
        }
    }
}
