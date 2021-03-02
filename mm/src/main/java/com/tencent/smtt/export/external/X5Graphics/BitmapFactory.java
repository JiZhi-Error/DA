package com.tencent.smtt.export.external.X5Graphics;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BitmapFactory {
    private static final int CONFIG_ALPHA_8 = 1;
    private static final int CONFIG_ARGB_4444 = 4;
    private static final int CONFIG_ARGB_8888 = 5;
    private static final int CONFIG_RGB_565 = 3;
    public static final int SHARPP_STATUS_OK = 0;
    public static final int TPGType = 2;
    public static final String TPGmimetype = "image/tpg";
    public static final int sharpPType = 1;
    public static final String sharpPmimetype = "image/sharpp";

    public static class Options {
        public Bitmap inBitmap = null;
        public boolean inJustDecodeBounds = false;
        public Bitmap.Config inPreferredConfig = Bitmap.Config.ARGB_8888;
        public int inSampleSize = 1;
        public long outDelayTime = 0;
        public int outHeight = 0;
        public String outMimeType = "";
        public int outWidth = 0;
    }

    private static native void nativeCloseDecoder(long j2);

    private static native BitmapInfo nativeCreateDecoder(byte[] bArr);

    private static native BitmapInfo nativeDecodeInfo(byte[] bArr, int i2, int i3);

    private static native OneFrameInfo nativeDecodeOneFrameNewPixel(byte[] bArr, int i2, long j2, int i3, int i4, int i5);

    private static native int nativeDecodeOneFrameUseBmp(byte[] bArr, int i2, long j2, int i3, int i4, int i5, Bitmap bitmap);

    private static native int[] nativeDecodePixels(byte[] bArr, int i2, int i3, int i4, int i5);

    private static native int nativeLoadSharpP();

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.smtt.export.external.X5Graphics.BitmapFactory$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = new int[Bitmap.Config.values().length];

        static {
            AppMethodBeat.i(53153);
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_8888.ordinal()] = 4;
                AppMethodBeat.o(53153);
            } catch (NoSuchFieldError e5) {
                AppMethodBeat.o(53153);
            }
        }
    }

    private static int getBitmapConfigValue(Bitmap.Config config) {
        AppMethodBeat.i(53154);
        switch (AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()]) {
            case 1:
                AppMethodBeat.o(53154);
                return 1;
            case 2:
                AppMethodBeat.o(53154);
                return 3;
            case 3:
                AppMethodBeat.o(53154);
                return 4;
            case 4:
                AppMethodBeat.o(53154);
                return 5;
            default:
                AppMethodBeat.o(53154);
                return 0;
        }
    }

    private static int getBitmapStride(Bitmap.Config config, int i2) {
        AppMethodBeat.i(53155);
        switch (AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()]) {
            case 1:
                AppMethodBeat.o(53155);
                return i2;
            case 2:
                int i3 = i2 * 2;
                AppMethodBeat.o(53155);
                return i3;
            case 3:
                int i4 = i2 * 2;
                AppMethodBeat.o(53155);
                return i4;
            case 4:
                int i5 = i2 * 4;
                AppMethodBeat.o(53155);
                return i5;
            default:
                AppMethodBeat.o(53155);
                return 0;
        }
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i2, int i3, Options options) {
        int i4;
        Bitmap bitmap;
        AppMethodBeat.i(53156);
        if (!X5Graphics.isEnable()) {
            AppMethodBeat.o(53156);
            return null;
        }
        new StringBuilder("decodeByteArray 0data = ").append(bArr).append(", len = ").append(bArr.length);
        if ((i2 | i3) < 0 || bArr.length < i2 + i3) {
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
            AppMethodBeat.o(53156);
            throw arrayIndexOutOfBoundsException;
        }
        BitmapInfo nativeDecodeInfo = nativeDecodeInfo(bArr, i2, i3);
        if (nativeDecodeInfo == null) {
            AppMethodBeat.o(53156);
            return null;
        }
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        if (options != null) {
            options.outWidth = nativeDecodeInfo.width;
            options.outHeight = nativeDecodeInfo.height;
            options.outMimeType = nativeDecodeInfo.mimeType;
            if (options.inJustDecodeBounds) {
                AppMethodBeat.o(53156);
                return null;
            } else if (options.inPreferredConfig != Bitmap.Config.ARGB_8888) {
                AppMethodBeat.o(53156);
                return null;
            } else if (options.inSampleSize <= 0) {
                AppMethodBeat.o(53156);
                return null;
            } else {
                int i5 = options.inSampleSize;
                config = options.inPreferredConfig;
                if (options.inBitmap != null) {
                    bitmap = options.inBitmap;
                    if (bitmap.getWidth() != nativeDecodeInfo.width) {
                        AppMethodBeat.o(53156);
                        return null;
                    } else if (bitmap.getHeight() != nativeDecodeInfo.height) {
                        AppMethodBeat.o(53156);
                        return null;
                    } else if (bitmap.getConfig() != config) {
                        AppMethodBeat.o(53156);
                        return null;
                    }
                } else {
                    bitmap = null;
                }
                options.outWidth = nativeDecodeInfo.width / i5;
                options.outHeight = nativeDecodeInfo.height / i5;
                new StringBuilder("decodeByteArray 3 outWidth=").append(options.outWidth).append(";outHeight=").append(options.outHeight);
                i4 = i5;
            }
        } else {
            i4 = 1;
            bitmap = null;
        }
        int bitmapConfigValue = getBitmapConfigValue(config);
        if (bitmapConfigValue == 0) {
            AppMethodBeat.o(53156);
            return null;
        }
        int[] nativeDecodePixels = nativeDecodePixels(bArr, i2, i3, bitmapConfigValue, i4);
        if (nativeDecodePixels == null) {
            AppMethodBeat.o(53156);
            return null;
        } else if (bitmap != null) {
            bitmap.setPixels(nativeDecodePixels, 0, getBitmapStride(config, nativeDecodeInfo.width / i4) / 4, 0, 0, nativeDecodeInfo.width / i4, nativeDecodeInfo.height / i4);
            AppMethodBeat.o(53156);
            return bitmap;
        } else {
            new StringBuilder("decodeByteArray 6 length=").append(nativeDecodePixels.length).append("; width=").append(nativeDecodeInfo.width / i4).append("; height=").append(nativeDecodeInfo.height / i4);
            Bitmap createBitmap = Bitmap.createBitmap(nativeDecodePixels, nativeDecodeInfo.width / i4, nativeDecodeInfo.height / i4, config);
            AppMethodBeat.o(53156);
            return createBitmap;
        }
    }

    public static class BitmapInfo {
        public long decodeHandle;
        public int frameCount;
        public int height;
        public int imageType;
        public String mimeType;
        public int width;

        public BitmapInfo(int i2, int i3, int i4, long j2, int i5, String str) {
            this.width = i2;
            this.height = i3;
            this.mimeType = str;
            this.frameCount = i4;
            this.decodeHandle = j2;
            this.imageType = i5;
        }
    }

    public static class OneFrameInfo {
        public int frameDuration;
        public int[] framePixel;

        public OneFrameInfo(int i2, int[] iArr) {
            this.frameDuration = i2;
            this.framePixel = iArr;
        }
    }

    private static BitmapInfo generateBitmapInfo(int i2, int i3, int i4, long j2, int i5, String str) {
        AppMethodBeat.i(53157);
        BitmapInfo bitmapInfo = new BitmapInfo(i2, i3, i4, j2, i5, str);
        AppMethodBeat.o(53157);
        return bitmapInfo;
    }

    private static OneFrameInfo generateFrameInfo(int i2, int[] iArr) {
        AppMethodBeat.i(53158);
        OneFrameInfo oneFrameInfo = new OneFrameInfo(i2, iArr);
        AppMethodBeat.o(53158);
        return oneFrameInfo;
    }

    public static BitmapInfo parseHeader(byte[] bArr) {
        AppMethodBeat.i(53159);
        new StringBuilder("parseHeader 0 data = ").append(bArr).append(", len = ").append(bArr.length);
        if (!X5Graphics.isEnable()) {
            AppMethodBeat.o(53159);
            return null;
        }
        BitmapInfo nativeDecodeInfo = nativeDecodeInfo(bArr, 0, bArr.length);
        new StringBuilder("parseHeader 2 bmpInfo=").append(nativeDecodeInfo);
        AppMethodBeat.o(53159);
        return nativeDecodeInfo;
    }

    public static BitmapInfo createDecoder(byte[] bArr) {
        AppMethodBeat.i(53160);
        new StringBuilder("createDecoder 0data = ").append(bArr).append(", len = ").append(bArr.length);
        if (!X5Graphics.isEnable()) {
            AppMethodBeat.o(53160);
            return null;
        }
        BitmapInfo nativeCreateDecoder = nativeCreateDecoder(bArr);
        new StringBuilder("createDecoder 2 bmpInfo=").append(nativeCreateDecoder);
        AppMethodBeat.o(53160);
        return nativeCreateDecoder;
    }

    public static Bitmap decodeOneFrame(byte[] bArr, int i2, BitmapInfo bitmapInfo, Options options) {
        Bitmap.Config config;
        Bitmap bitmap;
        OneFrameInfo nativeDecodeOneFrameNewPixel;
        AppMethodBeat.i(53161);
        new StringBuilder("decodeOneFrame 0 data.length=").append(bArr.length).append(", frameIndex = ").append(i2);
        if (!X5Graphics.isEnable()) {
            AppMethodBeat.o(53161);
            return null;
        } else if (bitmapInfo == null) {
            AppMethodBeat.o(53161);
            return null;
        } else {
            new StringBuilder("decodeOneFrame 1 frameCount = ").append(bitmapInfo.frameCount).append("; decodeHandle=").append(bitmapInfo.decodeHandle);
            if (bitmapInfo.decodeHandle == 0) {
                AppMethodBeat.o(53161);
                return null;
            }
            Bitmap bitmap2 = null;
            Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
            int i3 = bitmapInfo.width;
            int i4 = bitmapInfo.height;
            if (options != null) {
                new StringBuilder("decodeOneFrame 3  inSampleSize=").append(options.inSampleSize).append(", outDelayTime=").append(options.outDelayTime);
                options.outWidth = bitmapInfo.width;
                options.outHeight = bitmapInfo.height;
                options.outMimeType = bitmapInfo.mimeType;
                if (options.inJustDecodeBounds) {
                    AppMethodBeat.o(53161);
                    return null;
                } else if (options.inPreferredConfig != Bitmap.Config.ARGB_8888) {
                    AppMethodBeat.o(53161);
                    return null;
                } else if (options.inSampleSize <= 0) {
                    AppMethodBeat.o(53161);
                    return null;
                } else {
                    int i5 = options.inSampleSize;
                    Bitmap.Config config3 = options.inPreferredConfig;
                    if (options.inBitmap != null) {
                        bitmap2 = options.inBitmap;
                        if (bitmap2.getWidth() != bitmapInfo.width) {
                            AppMethodBeat.o(53161);
                            return null;
                        } else if (bitmap2.getHeight() != bitmapInfo.height) {
                            AppMethodBeat.o(53161);
                            return null;
                        } else if (bitmap2.getConfig() != config3) {
                            AppMethodBeat.o(53161);
                            return null;
                        }
                    }
                    options.outWidth = bitmapInfo.width / i5;
                    options.outHeight = bitmapInfo.height / i5;
                    i3 = options.outWidth;
                    i4 = options.outHeight;
                    new StringBuilder("decodeOneFrame  4  outWidth=").append(options.outWidth).append(";outHeight=").append(options.outHeight);
                    config = config3;
                    bitmap = bitmap2;
                }
            } else {
                config = config2;
                bitmap = null;
            }
            int bitmapConfigValue = getBitmapConfigValue(config);
            if (bitmapConfigValue == 0) {
                AppMethodBeat.o(53161);
                return null;
            }
            new StringBuilder("decodeOneFrame  5 dstBitmap=").append(bitmap);
            long currentTimeMillis = System.currentTimeMillis();
            OneFrameInfo oneFrameInfo = new OneFrameInfo(0, null);
            if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() <= 1 || bitmap.getHeight() <= 1) {
                nativeDecodeOneFrameNewPixel = nativeDecodeOneFrameNewPixel(bArr, i2, bitmapInfo.decodeHandle, bitmapConfigValue, i3, i4);
            } else {
                oneFrameInfo.frameDuration = nativeDecodeOneFrameUseBmp(bArr, i2, bitmapInfo.decodeHandle, bitmapConfigValue, i3, i4, bitmap);
                nativeDecodeOneFrameNewPixel = oneFrameInfo;
            }
            new StringBuilder("decodeOneFrame  6  oneFrame=").append(nativeDecodeOneFrameNewPixel);
            if (nativeDecodeOneFrameNewPixel == null) {
                AppMethodBeat.o(53161);
                return null;
            }
            new StringBuilder("decodeOneFrame  7  duration=").append(nativeDecodeOneFrameNewPixel.frameDuration);
            int[] iArr = nativeDecodeOneFrameNewPixel.framePixel;
            if (options != null) {
                if (nativeDecodeOneFrameNewPixel.frameDuration < 0) {
                    AppMethodBeat.o(53161);
                    return null;
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (((long) nativeDecodeOneFrameNewPixel.frameDuration) > currentTimeMillis2) {
                    options.outDelayTime = ((long) nativeDecodeOneFrameNewPixel.frameDuration) - currentTimeMillis2;
                } else {
                    options.outDelayTime = 0;
                }
                new StringBuilder("decodeOneFrame  8  opts.outDelayTime=").append(options.outDelayTime);
            }
            if (bitmap != null) {
                new StringBuilder("decodeOneFrame  9 dstBitmap=").append(bitmap).append(";dstBitmap.isRecycled()=").append(bitmap.isRecycled()).append(";bmpWidth=").append(bitmap.getWidth()).append(";bmpHeight=").append(bitmap.getHeight());
                AppMethodBeat.o(53161);
                return bitmap;
            } else if (iArr == null) {
                AppMethodBeat.o(53161);
                return null;
            } else {
                new StringBuilder("decodeOneFrame 10 length=").append(iArr.length).append("; width=").append(i3).append("; height=").append(i4).append(";config=").append(config);
                Bitmap createBitmap = Bitmap.createBitmap(iArr, i3, i4, config);
                AppMethodBeat.o(53161);
                return createBitmap;
            }
        }
    }

    public static void closeDecoder(BitmapInfo bitmapInfo) {
        AppMethodBeat.i(53162);
        new StringBuilder("closeDecoder 0 decodeHandle = ").append(bitmapInfo.decodeHandle);
        if (!X5Graphics.isEnable()) {
            AppMethodBeat.o(53162);
        } else if (bitmapInfo.decodeHandle == 0) {
            AppMethodBeat.o(53162);
        } else {
            nativeCloseDecoder(bitmapInfo.decodeHandle);
            AppMethodBeat.o(53162);
        }
    }

    public static boolean loadSharpSuccess() {
        boolean z = false;
        AppMethodBeat.i(53163);
        if (!X5Graphics.isEnable()) {
            AppMethodBeat.o(53163);
        } else {
            if (nativeLoadSharpP() != 0) {
                z = true;
            }
            AppMethodBeat.o(53163);
        }
        return z;
    }
}
