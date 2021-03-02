package com.tencent.mm.plugin.sns.ad.i;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    public static void j(String str, ImageView imageView) {
        AppMethodBeat.i(202342);
        if (!str.equals((String) imageView.getTag(R.id.hu3))) {
            imageView.setImageDrawable(null);
            loadImage(str, imageView);
        }
        AppMethodBeat.o(202342);
    }

    public static void a(String str, ImageView imageView, int i2) {
        AppMethodBeat.i(202343);
        if (imageView == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(202343);
            return;
        }
        try {
            if (!str.equals((String) imageView.getTag(R.id.hu3))) {
                b(str, imageView, i2);
            }
            AppMethodBeat.o(202343);
        } catch (Throwable th) {
            AppMethodBeat.o(202343);
        }
    }

    public static void loadImage(final String str, final ImageView imageView) {
        AppMethodBeat.i(202344);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(202344);
            return;
        }
        Log.d("SnsAd.AdImageLoader", "loadImage, hash=" + imageView.hashCode() + ", url=" + str);
        imageView.setTag(R.id.hu3, str);
        h.a(str, false, (f.a) new f.a() {
            /* class com.tencent.mm.plugin.sns.ad.i.b.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
            public final void eWN() {
            }

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
            public final void eWO() {
                AppMethodBeat.i(202336);
                imageView.setTag(R.id.hu3, "");
                Log.e("SnsAd.AdImageLoader", "onDownloadError, hash=" + imageView.hashCode() + ", url=" + str);
                AppMethodBeat.o(202336);
            }

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
            public final void aNH(String str) {
                AppMethodBeat.i(202337);
                try {
                    String str2 = (String) imageView.getTag(R.id.hu3);
                    String kz = TextUtils.isEmpty(str2) ? "" : h.kz("adId", str2);
                    if (TextUtils.isEmpty(str) || !str.equals(kz)) {
                        Log.d("SnsAd.AdImageLoader", "onDownloaded, url changed");
                        AppMethodBeat.o(202337);
                        return;
                    }
                    Bitmap decodeFile = BitmapUtil.decodeFile(str, null);
                    if (decodeFile != null) {
                        imageView.setImageBitmap(decodeFile);
                        Log.d("SnsAd.AdImageLoader", "onDownloaded succ, hash=" + imageView.hashCode());
                        AppMethodBeat.o(202337);
                        return;
                    }
                    Log.e("SnsAd.AdImageLoader", "onDownloaded, bitmap==null");
                    AppMethodBeat.o(202337);
                } catch (Throwable th) {
                    Log.e("SnsAd.AdImageLoader", "onDownloaded, exp=" + th.toString());
                    AppMethodBeat.o(202337);
                }
            }
        });
        AppMethodBeat.o(202344);
    }

    private static void b(final String str, final ImageView imageView, final int i2) {
        AppMethodBeat.i(202345);
        if (TextUtils.isEmpty(str) || imageView == null) {
            AppMethodBeat.o(202345);
            return;
        }
        Log.d("SnsAd.AdImageLoader", "loadImageEx, hash=" + imageView.hashCode() + ", url=" + str);
        imageView.setTag(R.id.hu3, str);
        h.a(str, false, (f.a) new f.a() {
            /* class com.tencent.mm.plugin.sns.ad.i.b.AnonymousClass2 */
            boolean started = false;

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
            public final void eWN() {
                this.started = true;
            }

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
            public final void eWO() {
                AppMethodBeat.i(202338);
                try {
                    k.it(i2, 1);
                    imageView.setTag(R.id.hu3, "");
                    imageView.setImageDrawable(null);
                } catch (Throwable th) {
                }
                Log.e("SnsAd.AdImageLoader", "onDownloadError, hash=" + imageView.hashCode() + ", url=" + str);
                AppMethodBeat.o(202338);
            }

            /* JADX WARNING: Removed duplicated region for block: B:9:0x001d A[Catch:{ Throwable -> 0x0080 }] */
            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void aNH(java.lang.String r7) {
                /*
                // Method dump skipped, instructions count: 133
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ad.i.b.AnonymousClass2.aNH(java.lang.String):void");
            }
        });
        AppMethodBeat.o(202345);
    }

    public static Drawable a(Resources resources, String str) {
        AppMethodBeat.i(202346);
        try {
            Bitmap decodeFile = BitmapUtil.decodeFile(str, null);
            if (decodeFile != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, decodeFile);
                AppMethodBeat.o(202346);
                return bitmapDrawable;
            }
            Log.e("SnsAd.AdImageLoader", "getDrawableFromFile bitmap==null, path=".concat(String.valueOf(str)));
            AppMethodBeat.o(202346);
            return null;
        } catch (Throwable th) {
            Log.e("SnsAd.AdImageLoader", "getDrawableFromFile exp=" + th.toString() + ", path=" + str);
        }
    }
}
