package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tavkit.component.TAVExporter;
import java.io.OutputStream;

public final class a {
    protected d EjP;
    protected int mScreenHeight = TAVExporter.VIDEO_EXPORT_HEIGHT;
    protected int mScreenWidth = TAVExporter.VIDEO_EXPORT_WIDTH;

    public interface d {
        void a(boolean z, String str, Bitmap bitmap, String str2);

        void onStart(String str);
    }

    public a() {
        AppMethodBeat.i(97242);
        try {
            int[] ha = ap.ha(MMApplicationContext.getContext());
            if (ha[0] > 0 && ha[1] > 0) {
                this.mScreenWidth = Math.min(ha[0], ha[1]);
                this.mScreenHeight = Math.max(ha[0], ha[1]);
                Log.i("SphereImageView.SphereImageLoader", "screen.w=" + this.mScreenWidth + ", screen.h=" + this.mScreenHeight);
            }
            AppMethodBeat.o(97242);
        } catch (Exception e2) {
            Log.e("SphereImageView.SphereImageLoader", "init exp=" + e2.toString());
            AppMethodBeat.o(97242);
        }
    }

    public final void l(final String str, final int i2, final int i3, final String str2) {
        AppMethodBeat.i(97243);
        Log.i("SphereImageView.SphereImageLoader", "loadImage, view.w=" + i2 + ", view.h=" + i3 + ", scene=" + str2);
        if (i2 == 0 || i3 == 0) {
            AppMethodBeat.o(97243);
            return;
        }
        if (this.EjP != null) {
            this.EjP.onStart(str);
        }
        String aQe = aQe(str);
        if (!TextUtils.isEmpty(aQe)) {
            Log.i("SphereImageView.SphereImageLoader", "hit disk cache, path=".concat(String.valueOf(aQe)));
            new AsyncTaskC1727a(str, i2, i3, str2).execute(aQe);
            AppMethodBeat.o(97243);
            return;
        }
        Log.i("SphereImageView.SphereImageLoader", "no cache, download");
        h.a(str, 133, new f.a() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
            public final void eWN() {
                AppMethodBeat.i(97232);
                Log.i("SphereImageView.SphereImageLoader", "onStartDownload");
                AppMethodBeat.o(97232);
            }

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
            public final void eWO() {
                AppMethodBeat.i(97233);
                Log.e("SphereImageView.SphereImageLoader", "onDownloadError");
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(97231);
                        if (a.this.EjP != null) {
                            a.this.EjP.a(false, "onDownloadError", null, str);
                        }
                        AppMethodBeat.o(97231);
                    }
                });
                AppMethodBeat.o(97233);
            }

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
            public final void aNH(String str) {
                AppMethodBeat.i(97234);
                Log.i("SphereImageView.SphereImageLoader", "loadImage onDownloaded, path=".concat(String.valueOf(str)));
                new AsyncTaskC1727a(str, i2, i3, str2).execute(str);
                AppMethodBeat.o(97234);
            }
        });
        AppMethodBeat.o(97243);
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a$a  reason: collision with other inner class name */
    protected class AsyncTaskC1727a extends AsyncTask<String, Void, Bitmap> {
        int EjS;
        int EjT;
        String errorInfo = "";
        String scene;
        String url;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ Bitmap doInBackground(String[] strArr) {
            AppMethodBeat.i(97237);
            Bitmap N = N(strArr);
            AppMethodBeat.o(97237);
            return N;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.os.AsyncTask
        public final /* synthetic */ void onPostExecute(Bitmap bitmap) {
            AppMethodBeat.i(97236);
            Bitmap bitmap2 = bitmap;
            if (a.this.EjP != null) {
                a.this.EjP.a(bitmap2 != null, this.errorInfo, bitmap2, this.url);
            }
            AppMethodBeat.o(97236);
        }

        public AsyncTaskC1727a(String str, int i2, int i3, String str2) {
            this.url = str;
            this.EjS = i2;
            this.EjT = i3;
            this.scene = str2;
        }

        private Bitmap N(String... strArr) {
            int width;
            int i2 = 1;
            int i3 = 0;
            AppMethodBeat.i(97235);
            if (strArr == null || strArr.length == 0 || TextUtils.isEmpty(strArr[0])) {
                Log.e("SphereImageView.SphereImageLoader", "ImageDecodeTask run, path is empty");
                this.errorInfo = "path is empty";
                AppMethodBeat.o(97235);
                return null;
            }
            Bitmap bitmap = null;
            long currentTimeMillis = System.currentTimeMillis();
            String str = strArr[0];
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                MMBitmapFactory.decodeFile(str, options);
                int i4 = options.outWidth;
                int i5 = options.outHeight;
                if ("scene_ad_landing" == this.scene) {
                    if (i4 >= 4000 && a.this.mScreenWidth < 1080) {
                        i2 = 2;
                    }
                } else if ("scene_timeline" == this.scene) {
                    if (i4 >= 4000) {
                        i2 = a.this.mScreenWidth >= 1080 ? 2 : 4;
                    } else if (i4 >= 2000 && a.this.mScreenWidth < 1080) {
                        i2 = 2;
                    }
                }
                Log.i("SphereImageView.SphereImageLoader", "decode, bmp.w=" + i4 + ", bmp.h=" + i5 + ", screen.w=" + a.this.mScreenWidth + ", screen.h=" + a.this.mScreenHeight + ", view.w=" + this.EjS + ", view.h=" + this.EjT + ", inSampleSize=" + i2);
                options.inJustDecodeBounds = false;
                options.inSampleSize = i2;
                bitmap = MMBitmapFactory.decodeFile(str, options);
            } catch (Exception e2) {
                this.errorInfo = e2.toString();
                Log.e("SphereImageView.SphereImageLoader", "ImageDecodeTask, exp:" + this.errorInfo);
            } catch (OutOfMemoryError e3) {
                this.errorInfo = e3.toString();
                Log.e("SphereImageView.SphereImageLoader", "ImageDecodeTask, oom:" + this.errorInfo);
                Log.i("SphereImageView.SphereImageLoader", "ImageDecodeTask, try again after oom");
                System.gc();
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inSampleSize = 1 + 1;
                bitmap = MMBitmapFactory.decodeFile(str, options2);
            } catch (Throwable th) {
                this.errorInfo = e3.toString();
                Log.e("SphereImageView.SphereImageLoader", "ImageDecodeTask, try again exp:" + this.errorInfo);
            }
            StringBuilder append = new StringBuilder("ImageDecodeTask end, totalTime=").append(System.currentTimeMillis() - currentTimeMillis).append(", bmp.w=");
            if (bitmap == null) {
                width = 0;
            } else {
                width = bitmap.getWidth();
            }
            StringBuilder append2 = append.append(width).append(", bmp.h=");
            if (bitmap != null) {
                i3 = bitmap.getHeight();
            }
            Log.i("SphereImageView.SphereImageLoader", append2.append(i3).append(", path=").append(str).toString());
            AppMethodBeat.o(97235);
            return bitmap;
        }
    }

    public static class c extends AsyncTask<Void, Void, Bitmap> {
        d EjU;
        String imageUrl;
        String scene;
        String thumbUrl;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ Bitmap doInBackground(Void[] voidArr) {
            AppMethodBeat.i(97241);
            Bitmap rL = rL();
            AppMethodBeat.o(97241);
            return rL;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.os.AsyncTask
        public final /* synthetic */ void onPostExecute(Bitmap bitmap) {
            AppMethodBeat.i(97240);
            Bitmap bitmap2 = bitmap;
            if (this.EjU != null) {
                this.EjU.a(true, "", bitmap2, this.imageUrl);
            }
            AppMethodBeat.o(97240);
        }

        public c(String str, String str2, String str3, d dVar) {
            this.imageUrl = str;
            this.thumbUrl = str2;
            this.scene = str3;
            this.EjU = dVar;
        }

        private Bitmap rL() {
            AppMethodBeat.i(97239);
            Bitmap kw = a.kw(this.imageUrl, this.scene);
            if (kw != null) {
                Log.i("SphereImageView.SphereImageLoader", "has shot");
            } else {
                try {
                    if (!TextUtils.isEmpty(this.thumbUrl)) {
                        kw = h.kD("adId", this.thumbUrl);
                        if (kw != null) {
                            Log.i("SphereImageView.SphereImageLoader", "has cache thumb");
                        }
                    } else {
                        Log.e("SphereImageView.SphereImageLoader", "thumbUrl is empty");
                    }
                } catch (Throwable th) {
                    Log.e("SphereImageView.SphereImageLoader", "getCachedImg exp:" + th.toString());
                }
            }
            AppMethodBeat.o(97239);
            return kw;
        }
    }

    private static String aQe(String str) {
        AppMethodBeat.i(97244);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(97244);
            return null;
        }
        try {
            String kz = h.kz("adId", str);
            if (!TextUtils.isEmpty(kz) && s.YS(kz)) {
                AppMethodBeat.o(97244);
                return kz;
            }
        } catch (Exception e2) {
            Log.e("SphereImageView.SphereImageLoader", "getImgCacheFilePath, exp:" + e2.toString());
        }
        AppMethodBeat.o(97244);
        return "";
    }

    public final void a(d dVar) {
        this.EjP = dVar;
    }

    public static void a(TextureView textureView, String str, String str2) {
        AppMethodBeat.i(97245);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap bitmap = textureView.getBitmap();
            if (bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0 || TextUtils.isEmpty(str)) {
                Log.e("SphereImageView.SphereImageLoader", "saveSphereImageViewShootAsyn, params err");
                AppMethodBeat.o(97245);
                return;
            }
            new b(bitmap, str, str2).execute(new Void[0]);
            Log.i("SphereImageView.SphereImageLoader", "saveSphereImageViewShootAsyn, timeCost=" + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(97245);
        } catch (Throwable th) {
            Log.e("SphereImageView.SphereImageLoader", "saveSphereImageViewShootAsyn, exp=" + th.toString());
            AppMethodBeat.o(97245);
        }
    }

    public static boolean a(Bitmap bitmap, String str, String str2) {
        boolean z;
        AppMethodBeat.i(97246);
        if (TextUtils.isEmpty(str)) {
            Log.e("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot, imageUrl is empty, scene=".concat(String.valueOf(str2)));
            AppMethodBeat.o(97246);
            return false;
        } else if (bitmap == null || bitmap.getHeight() <= 0 || bitmap.getWidth() <= 0) {
            Log.e("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot, bitmap==null or size<=0, scene=".concat(String.valueOf(str2)));
            AppMethodBeat.o(97246);
            return false;
        } else {
            OutputStream outputStream = null;
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (bitmap == null || bitmap.getWidth() < 20 || bitmap.getHeight() < 20) {
                    z = false;
                } else {
                    int i2 = 0;
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    for (int i3 = 0; i3 < 10; i3++) {
                        for (int i4 = 0; i4 < 10; i4++) {
                            i2 += bitmap.getPixel(i3, i4) & 16777215;
                        }
                    }
                    if (i2 != 0) {
                        z = true;
                    } else {
                        for (int i5 = width - 10; i5 < width; i5++) {
                            for (int i6 = 0; i6 < 10; i6++) {
                                i2 += bitmap.getPixel(i5, i6) & 16777215;
                            }
                        }
                        if (i2 != 0) {
                            z = true;
                        } else {
                            for (int i7 = 0; i7 < 10; i7++) {
                                for (int i8 = height - 10; i8 < height; i8++) {
                                    i2 += bitmap.getPixel(i7, i8) & 16777215;
                                }
                            }
                            if (i2 != 0) {
                                z = true;
                            } else {
                                for (int i9 = width - 10; i9 < width; i9++) {
                                    for (int i10 = height - 10; i10 < height; i10++) {
                                        i2 += bitmap.getPixel(i9, i10) & 16777215;
                                    }
                                }
                                if (i2 != 0) {
                                    z = true;
                                } else {
                                    int i11 = width / 2;
                                    int i12 = height / 2;
                                    for (int i13 = i11 - 5; i13 < i11 + 5; i13++) {
                                        for (int i14 = i12 - 5; i14 < i12 + 5; i14++) {
                                            i2 += bitmap.getPixel(i13, i14) & 16777215;
                                        }
                                    }
                                    if (i2 != 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                }
                            }
                        }
                    }
                }
                if (z) {
                    String ky = ky(str2, str);
                    OutputStream ap = s.ap(new o(ky));
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 90, ap);
                    ap.flush();
                    Log.i("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot, timeCost=" + (System.currentTimeMillis() - currentTimeMillis) + ", bmp.w=" + bitmap.getWidth() + ", h=" + bitmap.getHeight() + ", path=" + ky + ", isValid=true");
                    if (ap != null) {
                        try {
                            ap.close();
                        } catch (Exception e2) {
                            Log.e("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot, fout.close exp:" + e2.toString() + ", scene=" + str2);
                        }
                    }
                    AppMethodBeat.o(97246);
                    return true;
                }
                Log.i("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot, isValid=false");
                AppMethodBeat.o(97246);
                return false;
            } catch (Exception e3) {
                Log.e("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot exp:" + e3.toString() + ", scene=" + str2);
                if (0 != 0) {
                    try {
                        outputStream.close();
                    } catch (Exception e4) {
                        Log.e("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot, fout.close exp:" + e4.toString() + ", scene=" + str2);
                    }
                }
            } catch (OutOfMemoryError e5) {
                Log.e("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot OOM:" + e5.toString() + ", scene=" + str2);
                if (0 != 0) {
                    try {
                        outputStream.close();
                    } catch (Exception e6) {
                        Log.e("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot, fout.close exp:" + e6.toString() + ", scene=" + str2);
                    }
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        outputStream.close();
                    } catch (Exception e7) {
                        Log.e("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot, fout.close exp:" + e7.toString() + ", scene=" + str2);
                    }
                }
                AppMethodBeat.o(97246);
                throw th;
            }
        }
    }

    public static Bitmap kw(String str, String str2) {
        boolean z = false;
        AppMethodBeat.i(97247);
        if (TextUtils.isEmpty(str)) {
            Log.e("SphereImageView.SphereImageLoader", "getSphereImageViewFrameShot, imageUrl is empty, scene=".concat(String.valueOf(str2)));
            AppMethodBeat.o(97247);
            return null;
        }
        try {
            String ky = ky(str2, str);
            if (TextUtils.isEmpty(ky) || !s.YS(ky)) {
                Log.e("SphereImageView.SphereImageLoader", "getSphereImageViewFrameShot, file not exists, scene=" + str2 + ", path=" + ky);
                AppMethodBeat.o(97247);
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap decodeFile = MMBitmapFactory.decodeFile(ky);
            long currentTimeMillis2 = System.currentTimeMillis();
            int width = decodeFile == null ? 0 : decodeFile.getWidth();
            int height = decodeFile == null ? 0 : decodeFile.getHeight();
            StringBuilder append = new StringBuilder("getSphereImageViewFrameShot, timeCost=").append(currentTimeMillis2 - currentTimeMillis).append(", bmp==null?");
            if (decodeFile == null) {
                z = true;
            }
            Log.i("SphereImageView.SphereImageLoader", append.append(z).append(", w=").append(width).append(", h=").append(height).append(", path=").append(ky).toString());
            AppMethodBeat.o(97247);
            return decodeFile;
        } catch (Exception e2) {
            Log.e("SphereImageView.SphereImageLoader", "getSphereImageViewFrameShot, exp:" + e2.toString() + ", scene=" + str2);
        } catch (OutOfMemoryError e3) {
            Log.e("SphereImageView.SphereImageLoader", "getSphereImageViewFrameShot, OOM:" + e3.toString() + ", scene=" + str2);
        }
    }

    public static boolean kx(String str, String str2) {
        boolean z;
        AppMethodBeat.i(97248);
        if (TextUtils.isEmpty(str)) {
            Log.e("SphereImageView.SphereImageLoader", "hasSphereImageViewFrameShot, imageUrl is empty, scene=".concat(String.valueOf(str2)));
            AppMethodBeat.o(97248);
            return false;
        }
        try {
            String ky = ky(str2, str);
            if (TextUtils.isEmpty(ky) || !s.YS(ky)) {
                z = false;
            } else {
                z = true;
            }
            Log.i("SphereImageView.SphereImageLoader", "hasSphereImageViewFrameShot, ret=" + z + ", scene=" + str2);
            AppMethodBeat.o(97248);
            return z;
        } catch (Exception e2) {
            Log.e("SphereImageView.SphereImageLoader", "hasSphereImageViewFrameShot, exp:" + e2.toString() + ", scene=" + str2);
            AppMethodBeat.o(97248);
            return false;
        }
    }

    private static String ky(String str, String str2) {
        AppMethodBeat.i(97249);
        String kz = h.kz("sphere_shot_".concat(String.valueOf(str)), str2);
        AppMethodBeat.o(97249);
        return kz;
    }

    protected static class b extends AsyncTask<Void, Void, Void> {
        Bitmap bitmap;
        String imageUrl;
        String scene;

        public b(Bitmap bitmap2, String str, String str2) {
            this.bitmap = bitmap2;
            this.imageUrl = str;
            this.scene = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ Void doInBackground(Void[] voidArr) {
            AppMethodBeat.i(97238);
            a.a(this.bitmap, this.imageUrl, this.scene);
            AppMethodBeat.o(97238);
            return null;
        }
    }
}
