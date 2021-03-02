package com.tencent.mm.by.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.qbar.f;
import java.util.Arrays;

public final class a {
    public static Bitmap b(Context context, Bitmap bitmap, String str) {
        AppMethodBeat.i(168778);
        byte[] bArr = new byte[40000];
        int[] iArr = new int[2];
        int a2 = f.a(bArr, iArr, str, 12, 3, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        if (a2 == 0) {
            Bitmap a3 = a(context, bitmap, bArr, iArr, 0.0d);
            if (a3 == null) {
                Log.i("MicroMsg.QRCodeBitmapFactory", "createBitmap bm is error result %d %s", Integer.valueOf(a2), Util.getStack().toString());
            } else {
                Log.i("MicroMsg.QRCodeBitmapFactory", "createBitmap %s", a3);
            }
            AppMethodBeat.o(168778);
            return a3;
        }
        Log.i("MicroMsg.QRCodeBitmapFactory", "result %d %s", Integer.valueOf(a2), Util.getStack().toString());
        AppMethodBeat.o(168778);
        return null;
    }

    public static Bitmap a(Context context, Bitmap bitmap, byte[] bArr, int[] iArr, double d2) {
        AppMethodBeat.i(168779);
        int width = bitmap.getWidth();
        int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(context, 197.0f);
        if (fromDPToPix < width) {
            fromDPToPix = width;
        }
        int i2 = (int) (((double) iArr[0]) * d2);
        int i3 = fromDPToPix / (iArr[0] + (i2 * 2));
        int i4 = i3 == 0 ? 1 : i3;
        int i5 = i2 * i4;
        int i6 = i4 * (iArr[0] + (i2 * 2));
        int i7 = (iArr[1] * i4) + (i2 * i4 * 2);
        if (i6 < width) {
            i6 = width;
        }
        if (i7 < width) {
            i7 = width;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
        int[] iArr2 = new int[(i6 * i7)];
        int i8 = (i6 - width) / 2;
        int i9 = 0;
        for (int i10 = i8; i10 < i6 - i8 && i9 < width; i10++) {
            int i11 = 0;
            int i12 = i8;
            while (i12 < i7 - i8 && i11 < width) {
                iArr2[(i10 * i6) + i12] = bitmap.getPixel(i11, i9);
                i12++;
                i11++;
            }
            i9++;
        }
        for (int i13 = 0; i13 < iArr[1]; i13++) {
            for (int i14 = 0; i14 < iArr[0]; i14++) {
                if (bArr[(iArr[0] * i13) + i14] == 1) {
                    for (int i15 = 0; i15 < i4; i15++) {
                        for (int i16 = 0; i16 < i4; i16++) {
                            if (iArr2[(((i13 * i4) + i5 + i15) * i6) + (i14 * i4) + i5 + i16] == 0) {
                                iArr2[(((i13 * i4) + i5 + i15) * i6) + (i14 * i4) + i5 + i16] = -16777216;
                            }
                        }
                    }
                } else {
                    for (int i17 = 0; i17 < i4; i17++) {
                        for (int i18 = 0; i18 < i4; i18++) {
                            if (iArr2[(((i13 * i4) + i5 + i17) * i6) + (i14 * i4) + i5 + i18] == 0) {
                                iArr2[(((i13 * i4) + i5 + i17) * i6) + (i14 * i4) + i5 + i18] = -1;
                            }
                        }
                    }
                }
            }
        }
        createBitmap.setPixels(iArr2, 0, i6, 0, 0, i6, i7);
        AppMethodBeat.o(168779);
        return createBitmap;
    }

    public static Bitmap b(Context context, String str, int i2, int i3) {
        AppMethodBeat.i(91133);
        Bitmap a2 = a(context, str, i2, i3, 0.1d);
        AppMethodBeat.o(91133);
        return a2;
    }

    public static Bitmap a(Context context, String str, int i2, int i3, double d2) {
        AppMethodBeat.i(91134);
        byte[] bArr = new byte[40000];
        int[] iArr = new int[2];
        int a2 = f.a(bArr, iArr, str, i2, i3, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        if (a2 == 0) {
            Bitmap a3 = a(context, bArr, iArr, i2, d2);
            if (a3 == null) {
                Log.i("MicroMsg.QRCodeBitmapFactory", "createBitmap bm is error result %d %s", Integer.valueOf(a2), Util.getStack().toString());
            } else {
                Log.i("MicroMsg.QRCodeBitmapFactory", "createBitmap %s", a3);
            }
            AppMethodBeat.o(91134);
            return a3;
        }
        Log.i("MicroMsg.QRCodeBitmapFactory", "result %d %s", Integer.valueOf(a2), Util.getStack().toString());
        AppMethodBeat.o(91134);
        return null;
    }

    private static Bitmap a(Context context, byte[] bArr, int[] iArr, int i2, double d2) {
        int i3;
        int i4;
        AppMethodBeat.i(91135);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i5 = displayMetrics.widthPixels;
        int i6 = displayMetrics.heightPixels;
        if (i5 >= i6) {
            i5 = i6;
        }
        int i7 = (int) (((double) i5) * 0.8d);
        int i8 = (int) (((double) iArr[0]) * d2);
        if (i2 == 12) {
            int i9 = i7 / (iArr[0] + (i8 * 2));
            if (i9 == 0) {
                i9 = 1;
            }
            i3 = i9;
            i4 = i9;
        } else if (i2 == 5) {
            int i10 = i7 / (iArr[0] + (i8 * 2));
            if (i10 == 0) {
                i10 = 1;
            }
            i3 = (iArr[0] * i10) / iArr[1];
            i4 = i10;
        } else {
            i3 = 0;
            i4 = 0;
        }
        int i11 = i8 * i4;
        int i12 = i4 * (iArr[0] + (i8 * 2));
        int i13 = (iArr[1] * i3) + (i4 * 2 * i8);
        Bitmap createBitmap = Bitmap.createBitmap(i12, i13, Bitmap.Config.ARGB_8888);
        int[] iArr2 = new int[(i12 * i13)];
        Arrays.fill(iArr2, -1);
        for (int i14 = 0; i14 < iArr[1]; i14++) {
            for (int i15 = 0; i15 < iArr[0]; i15++) {
                if (bArr[(iArr[0] * i14) + i15] == 1) {
                    for (int i16 = 0; i16 < i3; i16++) {
                        for (int i17 = 0; i17 < i4; i17++) {
                            iArr2[(((i14 * i3) + i11 + i16) * i12) + (i15 * i4) + i11 + i17] = -16777216;
                        }
                    }
                } else {
                    for (int i18 = 0; i18 < i3; i18++) {
                        for (int i19 = 0; i19 < i4; i19++) {
                            iArr2[(((i14 * i3) + i11 + i18) * i12) + (i15 * i4) + i11 + i19] = -1;
                        }
                    }
                }
            }
        }
        createBitmap.setPixels(iArr2, 0, i12, 0, 0, i12, i13);
        AppMethodBeat.o(91135);
        return createBitmap;
    }

    public static Bitmap ct(Context context, String str) {
        AppMethodBeat.i(91136);
        byte[] bArr = new byte[40000];
        int[] iArr = new int[2];
        int a2 = f.a(bArr, iArr, str, 12, 1, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        if (a2 == 0) {
            Bitmap a3 = a(context, bArr, iArr);
            if (a3 == null) {
                Log.i("MicroMsg.QRCodeBitmapFactory", "createBitmap bm is error result %d %s", Integer.valueOf(a2), Util.getStack().toString());
            } else {
                Log.i("MicroMsg.QRCodeBitmapFactory", "createBitmap %s", a3);
            }
            AppMethodBeat.o(91136);
            return a3;
        }
        Log.i("MicroMsg.QRCodeBitmapFactory", "result %d %s", Integer.valueOf(a2), Util.getStack().toString());
        AppMethodBeat.o(91136);
        return null;
    }

    private static Bitmap a(Context context, byte[] bArr, int[] iArr) {
        AppMethodBeat.i(91137);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i2 = displayMetrics.widthPixels;
        int i3 = displayMetrics.heightPixels;
        if (i2 >= i3) {
            i2 = i3;
        }
        int i4 = (int) (((double) iArr[0]) * 0.1d);
        int i5 = ((int) (((double) i2) * 0.8d)) / (iArr[0] + (i4 * 2));
        int i6 = i5 == 0 ? 1 : i5;
        int i7 = i4 * i6;
        int i8 = i6 * (iArr[0] + (i4 * 2));
        int i9 = (iArr[1] * i6) + (i6 * 2 * i4);
        Bitmap createBitmap = Bitmap.createBitmap(i8, i9, Bitmap.Config.ARGB_8888);
        int[] iArr2 = new int[(i8 * i9)];
        int i10 = (i6 * 2) + (i6 / 2);
        int i11 = (i6 * 3) + (i6 / 2);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Arrays.fill(iArr2, -1);
        int[] iArr3 = {(i6 * 3) + (i6 / 2), (i6 * 3) + (i6 / 2), (((iArr[0] - 1) - 3) * i6) + (i6 / 2), (i6 * 3) + (i6 / 2), (i6 * 3) + (i6 / 2), (((iArr[1] - 1) - 3) * i6) + (i6 / 2)};
        for (int i12 = 0; i12 < iArr[1]; i12++) {
            for (int i13 = 0; i13 < iArr[0]; i13++) {
                if (bArr[(iArr[0] * i12) + i13] == 1) {
                    if ((i12 >= 0 && i12 <= 6 && i13 >= 0 && i13 <= 6) || ((i12 >= 0 && i12 <= 6 && i13 >= iArr[0] - 7 && i13 <= iArr[0] - 1) || (i12 >= iArr[1] - 7 && i12 <= iArr[1] - 1 && i13 >= 0 && i13 <= 6))) {
                        for (int i14 = 0; i14 < i6; i14++) {
                            for (int i15 = 0; i15 < i6; i15++) {
                                iArr2[(((i12 * i6) + i7 + i14) * i8) + (i13 * i6) + i7 + i15] = -1;
                            }
                        }
                    } else if (gun()) {
                        for (int i16 = 0; i16 < i6; i16++) {
                            for (int i17 = 0; i17 < i6; i17++) {
                                iArr2[(((i12 * i6) + i7 + i16) * i8) + (i13 * i6) + i7 + i17] = -3041484;
                            }
                        }
                    } else {
                        for (int i18 = 0; i18 < i6; i18++) {
                            for (int i19 = 0; i19 < i6; i19++) {
                                iArr2[(((i12 * i6) + i7 + i18) * i8) + (i13 * i6) + i7 + i19] = -2598591;
                            }
                        }
                    }
                }
            }
        }
        createBitmap.setPixels(iArr2, 0, i8, 0, 0, i8, i9);
        for (int i20 = 0; i20 < 3; i20++) {
            paint.setColor(-2598591);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle((float) ((i6 * i4) + iArr3[i20 * 2]), (float) ((i6 * i4) + iArr3[(i20 * 2) + 1]), (float) i11, paint);
            paint.setColor(-1);
            canvas.drawCircle((float) ((i6 * i4) + iArr3[i20 * 2]), (float) ((i6 * i4) + iArr3[(i20 * 2) + 1]), (float) i10, paint);
        }
        for (int i21 = 0; i21 < 3; i21++) {
            paint.setColor(-3041484);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawRect((float) ((((i6 * i4) + iArr3[i21 * 2]) - i6) - ((i6 * 1) / 4)), (float) ((((i6 * i4) + iArr3[(i21 * 2) + 1]) - i6) - ((i6 * 1) / 4)), (float) (((i6 * 1) / 4) + (i6 * i4) + iArr3[i21 * 2] + i6), (float) (((i6 * 1) / 4) + (i6 * i4) + iArr3[(i21 * 2) + 1] + i6), paint);
        }
        for (int i22 = 0; i22 < 3; i22++) {
            paint.setColor(-1);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            Path path = new Path();
            path.moveTo((float) ((((i6 * i4) + iArr3[i22 * 2]) - i6) - ((i6 * 1) / 4)), (float) ((((i6 * i4) + iArr3[(i22 * 2) + 1]) - i6) - ((i6 * 1) / 4)));
            path.quadTo((float) ((i6 * i4) + iArr3[i22 * 2]), (float) (((i6 * i4) + iArr3[(i22 * 2) + 1]) - i6), (float) ((i6 * i4) + iArr3[i22 * 2] + i6 + (i6 / 4)), (float) ((((i6 * i4) + iArr3[(i22 * 2) + 1]) - i6) - ((i6 * 1) / 4)));
            path.lineTo((float) ((((i6 * i4) + iArr3[i22 * 2]) - i6) - ((i6 * 1) / 4)), (float) ((((i6 * i4) + iArr3[(i22 * 2) + 1]) - i6) - ((i6 * 1) / 4)));
            path.close();
            canvas.drawPath(path, paint);
            path.moveTo((float) ((((i6 * i4) + iArr3[i22 * 2]) - i6) - ((i6 * 1) / 4)), (float) ((((i6 * i4) + iArr3[(i22 * 2) + 1]) - i6) - ((i6 * 1) / 4)));
            path.quadTo((float) (((i6 * i4) + iArr3[i22 * 2]) - i6), (float) ((i6 * i4) + iArr3[(i22 * 2) + 1]), (float) ((((i6 * i4) + iArr3[i22 * 2]) - i6) - (i6 / 4)), (float) ((i6 * i4) + iArr3[(i22 * 2) + 1] + i6 + ((i6 * 1) / 4)));
            path.lineTo((float) ((((i6 * i4) + iArr3[i22 * 2]) - i6) - ((i6 * 1) / 4)), (float) ((((i6 * i4) + iArr3[(i22 * 2) + 1]) - i6) - ((i6 * 1) / 4)));
            path.close();
            canvas.drawPath(path, paint);
            path.moveTo((float) ((i6 * i4) + iArr3[i22 * 2] + i6 + ((i6 * 1) / 4)), (float) ((i6 * i4) + iArr3[(i22 * 2) + 1] + i6 + ((i6 * 1) / 4)));
            path.quadTo((float) ((i6 * i4) + iArr3[i22 * 2]), (float) ((i6 * i4) + iArr3[(i22 * 2) + 1] + i6), (float) ((((i6 * i4) + iArr3[i22 * 2]) - i6) - (i6 / 4)), (float) ((i6 * i4) + iArr3[(i22 * 2) + 1] + i6 + ((i6 * 1) / 4)));
            path.lineTo((float) ((i6 * i4) + iArr3[i22 * 2] + i6 + ((i6 * 1) / 4)), (float) ((i6 * i4) + iArr3[(i22 * 2) + 1] + i6 + ((i6 * 1) / 4)));
            path.close();
            canvas.drawPath(path, paint);
            path.moveTo((float) ((i6 * i4) + iArr3[i22 * 2] + i6 + ((i6 * 1) / 4)), (float) ((i6 * i4) + iArr3[(i22 * 2) + 1] + i6 + ((i6 * 1) / 4)));
            path.quadTo((float) ((i6 * i4) + iArr3[i22 * 2] + i6), (float) ((i6 * i4) + iArr3[(i22 * 2) + 1]), (float) ((i6 * i4) + iArr3[i22 * 2] + i6 + (i6 / 4)), (float) ((((i6 * i4) + iArr3[(i22 * 2) + 1]) - i6) - ((i6 * 1) / 4)));
            path.lineTo((float) ((i6 * i4) + iArr3[i22 * 2] + i6 + ((i6 * 1) / 4)), (float) ((i6 * i4) + iArr3[(i22 * 2) + 1] + i6 + ((i6 * 1) / 4)));
            path.close();
            canvas.drawPath(path, paint);
        }
        AppMethodBeat.o(91137);
        return createBitmap;
    }

    private static boolean gun() {
        AppMethodBeat.i(91138);
        boolean[] zArr = new boolean[10];
        zArr[5] = true;
        boolean z = zArr[(int) (Math.random() * 10.0d)];
        AppMethodBeat.o(91138);
        return z;
    }
}
