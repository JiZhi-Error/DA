package com.tencent.worddetect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.worddetect.WordDetectNative;
import java.nio.ByteBuffer;

public class a {
    private static WordDetectNative SxA;
    private static int Sxz;

    /* renamed from: com.tencent.worddetect.a$a  reason: collision with other inner class name */
    public interface AbstractC2226a {
        public static final WordDetectNative.WordDetectDetailResult SxB = new WordDetectNative.WordDetectDetailResult();
    }

    static {
        AppMethodBeat.i(194841);
        Sxz = 11;
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_scan_image_word_detect_rate_limit, 0);
        if (a2 >= 10 && a2 <= 15) {
            Sxz = a2;
        }
        Log.i("MicroMsg.WordDetectModHelper", "alvinluo initWordDetectHelper ratioLimit: %s, config: %s", Integer.valueOf(Sxz), Integer.valueOf(a2));
        AppMethodBeat.o(194841);
    }

    private static WordDetectNative.ConfigParam lz(Context context) {
        AppMethodBeat.i(91186);
        try {
            o oVar = new o(com.tencent.mm.loader.j.b.aKA().replace("/data/user/0", "/data/data") + "files/", "word_detect");
            if (!oVar.exists()) {
                oVar.mkdirs();
            }
            String z = aa.z(oVar.her());
            String str = z + "/net_fc.bin";
            String str2 = z + "/net_fc.param";
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("word_detect_mode_lib");
            boolean z2 = mmkv.getBoolean("word_detect_mode_version_2", false);
            if (!z2) {
                s.deleteFile(str);
                s.deleteFile(str2);
                mmkv.putBoolean("word_detect_mode_version_2", true);
            }
            if (!z2 || !s.YS(str)) {
                FilesCopy.copyAssets(context, "qbar/net_fc.bin", str);
                FilesCopy.copyAssets(context, "qbar/net_fc.param", str2);
            }
            WordDetectNative.ConfigParam configParam = new WordDetectNative.ConfigParam();
            configParam.detect_model_bin = str;
            configParam.detect_model_param = str2;
            AppMethodBeat.o(91186);
            return configParam;
        } catch (Exception e2) {
            Log.w("MicroMsg.WordDetectModHelper", "getWordDetectParam err %s", e2.getMessage());
            AppMethodBeat.o(91186);
            return null;
        }
    }

    private static byte[] aP(Bitmap bitmap) {
        AppMethodBeat.i(91187);
        try {
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            byte[] bArr = new byte[((array.length / 4) * 3)];
            for (int i2 = 0; i2 < array.length / 4; i2++) {
                bArr[i2 * 3] = array[(i2 * 4) + 2];
                bArr[(i2 * 3) + 1] = array[(i2 * 4) + 1];
                bArr[(i2 * 3) + 2] = array[i2 * 4];
            }
            AppMethodBeat.o(91187);
            return bArr;
        } catch (OutOfMemoryError e2) {
            AppMethodBeat.o(91187);
            return null;
        }
    }

    public static int cZ(Context context, String str) {
        AppMethodBeat.i(91188);
        if (SxA == null) {
            synchronized (a.class) {
                try {
                    if (SxA == null) {
                        WordDetectNative wordDetectNative = new WordDetectNative();
                        SxA = wordDetectNative;
                        wordDetectNative.init(lz(context));
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(91188);
                    throw th;
                }
            }
        }
        if (str == null || str.length() <= 0) {
            Log.e("MicroMsg.WordDetectModHelper", "in decodeFile, file == null");
            AppMethodBeat.o(91188);
            return 0;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapUtil.decodeFile(str, options);
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            int i2 = options.outWidth * options.outHeight * 3;
            float f2 = (((float) options.outHeight) * 1.0f) / ((float) options.outWidth);
            if (i2 > 52428800) {
                Log.w("MicroMsg.WordDetectModHelper", "bitmap too large %d x %d, quit", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                AppMethodBeat.o(91188);
                return 0;
            } else if (f2 > ((float) Sxz) || f2 < 1.0f / ((float) Sxz)) {
                Log.w("MicroMsg.WordDetectModHelper", "bitmap width_height ratio too large %f, quit", Float.valueOf(f2));
                AppMethodBeat.o(91188);
                return 0;
            } else {
                if (i2 > 10485760) {
                    Log.i("MicroMsg.WordDetectModHelper", "bitmap too large %d x %d, sample", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                    options2.inSampleSize = 2;
                }
                Bitmap decodeFile = BitmapUtil.decodeFile(str, options2);
                if (decodeFile == null) {
                    Log.e("MicroMsg.WordDetectModHelper", "decode bitmap is null!");
                    AppMethodBeat.o(91188);
                    return 0;
                }
                byte[] aP = aP(decodeFile);
                if (Util.isNullOrNil(aP)) {
                    AppMethodBeat.o(91188);
                    return 0;
                }
                int width = decodeFile.getWidth();
                int height = decodeFile.getHeight();
                int scanImage = SxA.scanImage(aP, width, height, 3);
                Log.i("MicroMsg.WordDetectModHelper", "data length = %d, w = %d, h = %d, scanImage result %d", Integer.valueOf(aP.length), Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(scanImage));
                if (scanImage != 0) {
                    AppMethodBeat.o(91188);
                    return 0;
                }
                int result = SxA.getResult();
                Log.i("MicroMsg.WordDetectModHelper", "decodeFile ret = %d, cost %d", Integer.valueOf(result), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(91188);
                return result;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.WordDetectModHelper", "Detect Word Error, e: %s", e2.getMessage());
            AppMethodBeat.o(91188);
            return 0;
        } catch (Error e3) {
            Log.e("MicroMsg.WordDetectModHelper", "System Error， error: %s", e3.getMessage());
            AppMethodBeat.o(91188);
            return 0;
        }
    }

    public static WordDetectNative.WordDetectDetailResult da(Context context, String str) {
        AppMethodBeat.i(194840);
        if (SxA == null) {
            synchronized (a.class) {
                try {
                    if (SxA == null) {
                        WordDetectNative wordDetectNative = new WordDetectNative();
                        SxA = wordDetectNative;
                        wordDetectNative.init(lz(context));
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(194840);
                    throw th;
                }
            }
        }
        if (str == null || str.length() <= 0) {
            Log.e("MicroMsg.WordDetectModHelper", "in decodeFile, file == null");
            WordDetectNative.WordDetectDetailResult wordDetectDetailResult = AbstractC2226a.SxB;
            AppMethodBeat.o(194840);
            return wordDetectDetailResult;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapUtil.decodeFile(str, options);
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            int i2 = options.outWidth * options.outHeight * 3;
            float f2 = (((float) options.outHeight) * 1.0f) / ((float) options.outWidth);
            if (i2 > 52428800) {
                Log.w("MicroMsg.WordDetectModHelper", "bitmap too large %d x %d, quit", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                WordDetectNative.WordDetectDetailResult wordDetectDetailResult2 = AbstractC2226a.SxB;
                AppMethodBeat.o(194840);
                return wordDetectDetailResult2;
            } else if (f2 > ((float) Sxz) || f2 < 1.0f / ((float) Sxz)) {
                Log.w("MicroMsg.WordDetectModHelper", "bitmap width_height ratio too large %f, quit", Float.valueOf(f2));
                WordDetectNative.WordDetectDetailResult wordDetectDetailResult3 = AbstractC2226a.SxB;
                AppMethodBeat.o(194840);
                return wordDetectDetailResult3;
            } else {
                if (i2 > 10485760) {
                    Log.i("MicroMsg.WordDetectModHelper", "bitmap too large %d x %d, sample", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                    options2.inSampleSize = 2;
                }
                Bitmap decodeFile = BitmapUtil.decodeFile(str, options2);
                if (decodeFile == null) {
                    Log.e("MicroMsg.WordDetectModHelper", "decode bitmap is null!");
                    WordDetectNative.WordDetectDetailResult wordDetectDetailResult4 = AbstractC2226a.SxB;
                    AppMethodBeat.o(194840);
                    return wordDetectDetailResult4;
                }
                byte[] aP = aP(decodeFile);
                if (Util.isNullOrNil(aP)) {
                    WordDetectNative.WordDetectDetailResult wordDetectDetailResult5 = AbstractC2226a.SxB;
                    AppMethodBeat.o(194840);
                    return wordDetectDetailResult5;
                }
                int width = decodeFile.getWidth();
                int height = decodeFile.getHeight();
                int scanImage = SxA.scanImage(aP, width, height, 3);
                Log.i("MicroMsg.WordDetectModHelper", "data length = %d, w = %d, h = %d, scanImage result %d", Integer.valueOf(aP.length), Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(scanImage));
                if (scanImage != 0) {
                    WordDetectNative.WordDetectDetailResult wordDetectDetailResult6 = AbstractC2226a.SxB;
                    AppMethodBeat.o(194840);
                    return wordDetectDetailResult6;
                }
                WordDetectNative.WordDetectDetailResult wordDetectDetailResult7 = new WordDetectNative.WordDetectDetailResult();
                if (SxA.getDetailResult(wordDetectDetailResult7) != 0) {
                    WordDetectNative.WordDetectDetailResult wordDetectDetailResult8 = AbstractC2226a.SxB;
                    AppMethodBeat.o(194840);
                    return wordDetectDetailResult8;
                }
                Log.i("MicroMsg.WordDetectModHelper", "decodeFile result %s, cost %d", wordDetectDetailResult7.rate_lang, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(194840);
                return wordDetectDetailResult7;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.WordDetectModHelper", "Detect Word Error, e: %s", e2.getMessage());
            WordDetectNative.WordDetectDetailResult wordDetectDetailResult9 = AbstractC2226a.SxB;
            AppMethodBeat.o(194840);
            return wordDetectDetailResult9;
        } catch (Error e3) {
            Log.e("MicroMsg.WordDetectModHelper", "System Error， error: %s", e3.getMessage());
            WordDetectNative.WordDetectDetailResult wordDetectDetailResult92 = AbstractC2226a.SxB;
            AppMethodBeat.o(194840);
            return wordDetectDetailResult92;
        }
    }
}
