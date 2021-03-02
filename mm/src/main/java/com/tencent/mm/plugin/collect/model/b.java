package com.tencent.mm.plugin.collect.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.c;
import com.tencent.mm.cb.a;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.qbar.f;

public final class b {
    public static Bitmap a(Context context, String str, String str2, int i2, String str3, u.a aVar, int i3) {
        AppMethodBeat.i(63769);
        Bitmap a2 = a(context, str, str2, i2, str3, aVar, false, i3);
        AppMethodBeat.o(63769);
        return a2;
    }

    public static Bitmap a(Context context, String str, String str2, int i2, String str3, u.a aVar, boolean z, int i3) {
        AppMethodBeat.i(63770);
        Bitmap a2 = a(context, str, str2, i2, str3, BackwardSupportUtil.BitmapFactory.fromDPToPix(context, 197.0f), aVar, z, i3, 0.0f, true);
        AppMethodBeat.o(63770);
        return a2;
    }

    public static Bitmap a(Context context, String str, String str2, int i2, String str3, int i3, u.a aVar, boolean z, int i4, float f2, boolean z2) {
        int i5;
        Bitmap bitmap;
        AppMethodBeat.i(213144);
        int i6 = (int) (((float) i3) * 0.26f);
        int i7 = (int) (((float) i3) * 0.22f);
        int i8 = (int) (((float) i3) * 0.076f);
        try {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Log.i("MicroMsg.CollectBitmapFactory", "createCollectQrcode size avatarSize %s dpCanvas %s", Integer.valueOf(i7), Integer.valueOf(i6));
            Bitmap createBitmap = Bitmap.createBitmap(i6, i6, Bitmap.Config.ARGB_8888);
            Bitmap bitmap2 = null;
            if (i2 == 1 && !Util.isNullOrNil(str3)) {
                bitmap2 = u.a(new c(str3));
                u.b(aVar);
            }
            Log.i("MicroMsg.CollectBitmapFactory", "avaterRoundSize：%s, useOwnDefault:%s", Float.valueOf(f2), Boolean.valueOf(z2));
            if (bitmap2 == null && z2) {
                Log.i("MicroMsg.CollectBitmapFactory", "avatar == null,use own avatar");
                bitmap2 = c.e(str2, i7, i7, (int) (((float) i7) * 0.06f));
            }
            if (bitmap2 == null) {
                Log.i("MicroMsg.CollectBitmapFactory", "avatar == null,use default");
                Bitmap decodeStream = BackwardSupportUtil.BitmapFactory.decodeStream(MMApplicationContext.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
                bitmap2 = BitmapUtil.getRoundedCornerBitmap(decodeStream, false, 0.06f * ((float) decodeStream.getWidth()));
            }
            if (bitmap2 != null && z) {
                bitmap2 = BitmapUtil.getRoundedCornerBitmap(bitmap2, false, ((float) bitmap2.getWidth()) * 0.5f);
            }
            if (bitmap2 != null && f2 > 0.0f) {
                bitmap2 = BitmapUtil.getRoundedCornerBitmap(bitmap2, false, (float) a.fromDPToPix(MMApplicationContext.getContext(), 2));
            }
            Canvas canvas = new Canvas(createBitmap);
            int i9 = (i6 - i7) / 2;
            canvas.drawBitmap(bitmap2, (Rect) null, new Rect(i9, i9, i6 - i9, i6 - i9), paint);
            canvas.drawBitmap(MMBitmapFactory.decodeStream(context.getResources().openRawResource(R.drawable.c51)), (Rect) null, new Rect(i6 - i8, i6 - i8, i6, i6), paint);
            if (Util.isEqual(i4, -1) || Util.isEqual(i4, 0)) {
                i5 = 3;
            } else {
                i5 = i4;
            }
            byte[] bArr = new byte[40000];
            int[] iArr = new int[2];
            int a2 = f.a(bArr, iArr, str, 12, i5, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            if (a2 == 0) {
                bitmap = com.tencent.mm.by.a.a.a(context, createBitmap, bArr, iArr, 0.1d);
                if (bitmap == null) {
                    Log.i("MicroMsg.QRCodeBitmapFactory", "createBitmap bm is error result %d %s", Integer.valueOf(a2), Util.getStack().toString());
                } else {
                    Log.i("MicroMsg.QRCodeBitmapFactory", "createBitmap %s", bitmap);
                }
            } else {
                Log.i("MicroMsg.QRCodeBitmapFactory", "result %d %s", Integer.valueOf(a2), Util.getStack().toString());
                bitmap = null;
            }
            Log.i("MicroMsg.CollectBitmapFactory", "bitmap recycle %s errorLevel:%s", createBitmap, Integer.valueOf(i5));
            createBitmap.recycle();
            AppMethodBeat.o(213144);
            return bitmap;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CollectBitmapFactory", e2, "", new Object[0]);
            AppMethodBeat.o(213144);
            return null;
        }
    }
}
