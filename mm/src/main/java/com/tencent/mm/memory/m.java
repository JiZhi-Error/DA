package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.graphics.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.InputStream;

public final class m extends l {
    private static int itE = -1;

    @Override // com.tencent.mm.memory.l
    public final Bitmap a(String str, BitmapFactory.Options options) {
        InputStream inputStream;
        Throwable th;
        Exception e2;
        Bitmap bitmap = null;
        AppMethodBeat.i(156432);
        try {
            inputStream = s.openRead(str);
            try {
                bitmap = b(inputStream, null, options);
                Util.qualityClose(inputStream);
                AppMethodBeat.o(156432);
            } catch (Exception e3) {
                e2 = e3;
                try {
                    Log.e("MicroMsg.PurgeableBitmapFactory", "decode error: %s", e2.getMessage());
                    Util.qualityClose(inputStream);
                    AppMethodBeat.o(156432);
                    return bitmap;
                } catch (Throwable th2) {
                    th = th2;
                    Util.qualityClose(inputStream);
                    AppMethodBeat.o(156432);
                    throw th;
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            inputStream = null;
            Log.e("MicroMsg.PurgeableBitmapFactory", "decode error: %s", e2.getMessage());
            Util.qualityClose(inputStream);
            AppMethodBeat.o(156432);
            return bitmap;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            Util.qualityClose(inputStream);
            AppMethodBeat.o(156432);
            throw th;
        }
        return bitmap;
    }

    @Override // com.tencent.mm.memory.l
    public final Bitmap a(String str, Rect rect, BitmapFactory.Options options) {
        InputStream inputStream;
        Throwable th;
        Exception e2;
        Bitmap bitmap = null;
        AppMethodBeat.i(156433);
        try {
            inputStream = s.openRead(str);
            try {
                bitmap = b(inputStream, rect, options);
                Util.qualityClose(inputStream);
                AppMethodBeat.o(156433);
            } catch (Exception e3) {
                e2 = e3;
                try {
                    Log.e("MicroMsg.PurgeableBitmapFactory", "decode error: %s", e2.getMessage());
                    Util.qualityClose(inputStream);
                    AppMethodBeat.o(156433);
                    return bitmap;
                } catch (Throwable th2) {
                    th = th2;
                    Util.qualityClose(inputStream);
                    AppMethodBeat.o(156433);
                    throw th;
                }
            }
        } catch (Exception e4) {
            e2 = e4;
            inputStream = null;
            Log.e("MicroMsg.PurgeableBitmapFactory", "decode error: %s", e2.getMessage());
            Util.qualityClose(inputStream);
            AppMethodBeat.o(156433);
            return bitmap;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            Util.qualityClose(inputStream);
            AppMethodBeat.o(156433);
            throw th;
        }
        return bitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap b(java.io.InputStream r8, android.graphics.Rect r9, android.graphics.BitmapFactory.Options r10) {
        /*
        // Method dump skipped, instructions count: 177
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.memory.m.b(java.io.InputStream, android.graphics.Rect, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    private static Bitmap c(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        byte[] bArr;
        Throwable th;
        Exception e2;
        Bitmap a2;
        AppMethodBeat.i(156435);
        int i2 = -1;
        if (inputStream != null) {
            try {
                i2 = inputStream.available();
                byte[] bArr2 = (byte[]) g.ity.b(Integer.valueOf(i2));
                if (bArr2 == null) {
                    try {
                        bArr = new byte[i2];
                    } catch (Exception e3) {
                        e2 = e3;
                        bArr = bArr2;
                        try {
                            Log.e("MicroMsg.PurgeableBitmapFactory", "decodeByByteArray error: %s", e2.getMessage());
                            Util.qualityClose(inputStream);
                            if (i2 > 0 && bArr != null) {
                                g.ity.k(bArr);
                            }
                            AppMethodBeat.o(156435);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            Util.qualityClose(inputStream);
                            if (i2 > 0 && bArr != null) {
                                g.ity.k(bArr);
                            }
                            AppMethodBeat.o(156435);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bArr = bArr2;
                        Util.qualityClose(inputStream);
                        g.ity.k(bArr);
                        AppMethodBeat.o(156435);
                        throw th;
                    }
                } else {
                    bArr = bArr2;
                }
                try {
                    inputStream.read(bArr);
                    if (rect == null) {
                        a2 = MMBitmapFactory.decodeByteArray(bArr, 0, i2, options);
                    } else {
                        a2 = b.a(bArr, i2, rect, options);
                    }
                    Bitmap pinBitmap = MMBitmapFactory.pinBitmap(a2);
                    Util.qualityClose(inputStream);
                    if (i2 > 0 && bArr != null) {
                        g.ity.k(bArr);
                    }
                    AppMethodBeat.o(156435);
                    return pinBitmap;
                } catch (Exception e4) {
                    e2 = e4;
                    Log.e("MicroMsg.PurgeableBitmapFactory", "decodeByByteArray error: %s", e2.getMessage());
                    Util.qualityClose(inputStream);
                    g.ity.k(bArr);
                    AppMethodBeat.o(156435);
                    return null;
                }
            } catch (Exception e5) {
                e2 = e5;
                bArr = null;
                Log.e("MicroMsg.PurgeableBitmapFactory", "decodeByByteArray error: %s", e2.getMessage());
                Util.qualityClose(inputStream);
                g.ity.k(bArr);
                AppMethodBeat.o(156435);
                return null;
            } catch (Throwable th4) {
                th = th4;
                bArr = null;
                Util.qualityClose(inputStream);
                g.ity.k(bArr);
                AppMethodBeat.o(156435);
                throw th;
            }
        } else {
            Util.qualityClose(inputStream);
            AppMethodBeat.o(156435);
            return null;
        }
    }

    @Override // com.tencent.mm.memory.l
    public final void x(Bitmap bitmap) {
        AppMethodBeat.i(156436);
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    Log.i("MicroMsg.PurgeableBitmapFactory", "bitmap recycle %s", bitmap.toString());
                    bitmap.recycle();
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.PurgeableBitmapFactory", "recycle error: %s", e2.getMessage());
                AppMethodBeat.o(156436);
                return;
            }
        }
        AppMethodBeat.o(156436);
    }
}
