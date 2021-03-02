package com.tencent.mm.graphics;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Keep;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.cd;
import com.tencent.mm.plugin.appbrand.jsapi.dg;
import com.tencent.mm.plugin.appbrand.jsapi.dh;
import com.tencent.mm.plugin.appbrand.jsapi.di;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.stubs.logger.Log;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Keep
public class MMBitmapFactory {
    private static final int DENSITY_DEFAULT = 160;
    private static final int REWIND_BUFFER_SIZE = 8388608;
    private static final String TAG = "MicroMsg.MMBitmapFactory";
    private static final int TEMP_STORAGE_SIZE = 4096;
    private static a sDecodeCanary = null;
    private static boolean sForceUsingSystemDecoderOpt = false;
    private static b sStreamProvider = null;

    @Keep
    public static class Options extends BitmapFactory.Options {
        @Keep
        public boolean inUseSmoothSample = true;
    }

    private static native void nativeAddExternalLibDir(String str);

    private static native Bitmap nativeDecodeByteArray(byte[] bArr, int i2, int i3, BitmapFactory.Options options);

    private static native Bitmap nativeDecodeFileDescriptor(FileDescriptor fileDescriptor, byte[] bArr, Rect rect, BitmapFactory.Options options);

    private static native Bitmap nativeDecodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options);

    private static native boolean nativeIsSeekable(FileDescriptor fileDescriptor);

    private static native int nativePinBitmap(Bitmap bitmap);

    private static native int nativeUnPinBitmap(Bitmap bitmap);

    static {
        AppMethodBeat.i(1011);
        loadNativeModule("mmimgcodec");
        AppMethodBeat.o(1011);
    }

    public static abstract class b {
        public InputStream getStreamFromPath(String str) {
            return new FileInputStream(str);
        }
    }

    public static void addExternalCodecLibDir(String str) {
        AppMethodBeat.i(980);
        Log.i(TAG, "[+] add external codec library path: %s", str);
        nativeAddExternalLibDir(str);
        AppMethodBeat.o(980);
    }

    public static void setStreamProvider(b bVar) {
        sStreamProvider = bVar;
    }

    public static void setDecodeCanary(a aVar) {
        sDecodeCanary = aVar;
    }

    public static String getVersion() {
        return "0.2.26";
    }

    public static void setForceUsingSystemDecoder(boolean z) {
        AppMethodBeat.i(981);
        Log.w(TAG, "[!] setForceUsingSystemDecoder, value: %s", Boolean.valueOf(z));
        sForceUsingSystemDecoderOpt = z;
        AppMethodBeat.o(981);
    }

    public static Bitmap decodeResource(Resources resources, int i2) {
        AppMethodBeat.i(cd.CTRL_INDEX);
        Log.d(TAG, "[*] transfer invocation to BitmapFactory.decodeResource, res: %s, id: %s", resources, Integer.valueOf(i2));
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, i2);
        AppMethodBeat.o(cd.CTRL_INDEX);
        return decodeResource;
    }

    public static Bitmap decodeResource(Resources resources, int i2, BitmapFactory.Options options) {
        AppMethodBeat.i(983);
        Log.d(TAG, "[*] transfer invocation to BitmapFactory.decodeResource, res: %s, id: %s, opts: %s", resources, Integer.valueOf(i2), options);
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, i2, options);
        AppMethodBeat.o(983);
        return decodeResource;
    }

    public static Bitmap decodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        AppMethodBeat.i(984);
        Log.d(TAG, "[*] transfer invocation to BitmapFactory.decodeResourceStream, res: %s, value: %s, is: %s, pad: %s, opts: %s", resources, typedValue, inputStream, rect, options);
        Bitmap decodeResourceStream = BitmapFactory.decodeResourceStream(resources, typedValue, inputStream, rect, options);
        AppMethodBeat.o(984);
        return decodeResourceStream;
    }

    public static Bitmap decodeFile(String str) {
        AppMethodBeat.i(985);
        assertNotNull(str, "'pathName' is null.");
        Bitmap decodeFileInternal = decodeFileInternal(str, null);
        AppMethodBeat.o(985);
        return decodeFileInternal;
    }

    public static Bitmap decodeFile(String str, BitmapFactory.Options options) {
        AppMethodBeat.i(986);
        assertNotNull(str, "'pathName' is null.");
        Bitmap decodeFileInternal = decodeFileInternal(str, options);
        AppMethodBeat.o(986);
        return decodeFileInternal;
    }

    private static Bitmap decodeFileInternal(String str, BitmapFactory.Options options) {
        InputStream inputStream;
        Throwable th;
        Throwable th2;
        boolean z = true;
        AppMethodBeat.i(987);
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        if (isForceSystemDecoder(options)) {
            Log.w(TAG, "[!] force decoding file %s by system codec.", str);
            Bitmap decodeFileWithStreamBySystemInternal = decodeFileWithStreamBySystemInternal(str, options);
            AppMethodBeat.o(987);
            return decodeFileWithStreamBySystemInternal;
        }
        try {
            inputStream = wrapUnResetableStreamOnDemand(getStreamFromPath(str));
            try {
                inputStream.mark(getCompatibleRewindBufferSize());
                Bitmap nativeDecodeStream = nativeDecodeStream(inputStream, null, options);
                if (options.outMimeType == null) {
                    z = false;
                }
                if (z) {
                    announceDecodeResult(options, nativeDecodeStream, false);
                    setDensityFromOptions(nativeDecodeStream, options);
                    Bitmap scaleBitmapOnDemand = scaleBitmapOnDemand(nativeDecodeStream, options);
                    closeQuietly(inputStream);
                    AppMethodBeat.o(987);
                    return scaleBitmapOnDemand;
                }
                Log.w(TAG, "[!] unsupported image format, try to decode with system codec.");
                Bitmap decodeFileWithStreamBySystemInternal2 = decodeFileWithStreamBySystemInternal(str, options);
                closeQuietly(inputStream);
                AppMethodBeat.o(987);
                return decodeFileWithStreamBySystemInternal2;
            } catch (Throwable th3) {
                th2 = th3;
                try {
                    Log.e(TAG, th2, "decode failed.");
                    closeQuietly(inputStream);
                    AppMethodBeat.o(987);
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    closeQuietly(inputStream);
                    AppMethodBeat.o(987);
                    throw th;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            closeQuietly(inputStream);
            AppMethodBeat.o(987);
            throw th;
        }
    }

    private static Bitmap decodeFileWithStreamBySystemInternal(String str, BitmapFactory.Options options) {
        InputStream inputStream;
        Throwable th;
        Throwable th2;
        AppMethodBeat.i(dh.CTRL_INDEX);
        if (sStreamProvider != null) {
            try {
                inputStream = wrapUnResetableStreamOnDemand(getStreamFromPath(str));
                try {
                    inputStream.mark(getCompatibleRewindBufferSize());
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                    announceDecodeResult(options, decodeStream, true);
                    closeQuietly(inputStream);
                    AppMethodBeat.o(dh.CTRL_INDEX);
                    return decodeStream;
                } catch (Throwable th3) {
                    th2 = th3;
                    try {
                        Log.e(TAG, th2, "decode by system failed.");
                        closeQuietly(inputStream);
                        AppMethodBeat.o(dh.CTRL_INDEX);
                        return null;
                    } catch (Throwable th4) {
                        th = th4;
                        closeQuietly(inputStream);
                        AppMethodBeat.o(dh.CTRL_INDEX);
                        throw th;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
                closeQuietly(inputStream);
                AppMethodBeat.o(dh.CTRL_INDEX);
                throw th;
            }
        } else {
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                announceDecodeResult(options, decodeFile, true);
                AppMethodBeat.o(dh.CTRL_INDEX);
                return decodeFile;
            } catch (Throwable th6) {
                Log.e(TAG, th6, "decode by system failed.");
                AppMethodBeat.o(dh.CTRL_INDEX);
                return null;
            }
        }
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor) {
        AppMethodBeat.i(dg.CTRL_INDEX);
        assertNotNull(fileDescriptor, "'fd' is null.");
        Bitmap decodeFileDescriptorInternal = decodeFileDescriptorInternal(fileDescriptor, null, null);
        AppMethodBeat.o(dg.CTRL_INDEX);
        return decodeFileDescriptorInternal;
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        AppMethodBeat.i(di.CTRL_INDEX);
        assertNotNull(fileDescriptor, "'fd' is null.");
        Bitmap decodeFileDescriptorInternal = decodeFileDescriptorInternal(fileDescriptor, rect, options);
        AppMethodBeat.o(di.CTRL_INDEX);
        return decodeFileDescriptorInternal;
    }

    private static Bitmap decodeFileDescriptorInternal(FileDescriptor fileDescriptor, Rect rect, BitmapFactory.Options options) {
        FileInputStream fileInputStream;
        Throwable th;
        Throwable th2;
        boolean z = false;
        AppMethodBeat.i(991);
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        if (isForceSystemDecoder(options)) {
            Log.w(TAG, "[!] force decoding fd %s by system codec.", fileDescriptor);
            Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
            announceDecodeResult(options, decodeFileDescriptor, true);
            AppMethodBeat.o(991);
            return decodeFileDescriptor;
        } else if (nativeIsSeekable(fileDescriptor)) {
            try {
                Bitmap nativeDecodeFileDescriptor = nativeDecodeFileDescriptor(fileDescriptor, getOrCreateStorageBuffer(options), rect, options);
                if (options.outMimeType != null) {
                    z = true;
                }
                if (z) {
                    announceDecodeResult(options, nativeDecodeFileDescriptor, false);
                    setDensityFromOptions(nativeDecodeFileDescriptor, options);
                    Bitmap scaleBitmapOnDemand = scaleBitmapOnDemand(nativeDecodeFileDescriptor, options);
                    AppMethodBeat.o(991);
                    return scaleBitmapOnDemand;
                }
                Log.w(TAG, "[!] unsupported image format, try to decode with system codec.");
                Bitmap decodeFileDescriptor2 = BitmapFactory.decodeFileDescriptor(fileDescriptor, rect, options);
                announceDecodeResult(options, decodeFileDescriptor2, true);
                AppMethodBeat.o(991);
                return decodeFileDescriptor2;
            } catch (Throwable th3) {
                Log.e(TAG, th3, "decode failed.");
                AppMethodBeat.o(991);
                return null;
            }
        } else {
            try {
                fileInputStream = new FileInputStream(fileDescriptor);
                try {
                    Bitmap decodeStreamInternal = decodeStreamInternal(fileInputStream, rect, options);
                    closeQuietly(fileInputStream);
                    AppMethodBeat.o(991);
                    return decodeStreamInternal;
                } catch (Throwable th4) {
                    th2 = th4;
                    try {
                        Log.e(TAG, th2, "decode failed.");
                        closeQuietly(fileInputStream);
                        AppMethodBeat.o(991);
                        return null;
                    } catch (Throwable th5) {
                        th = th5;
                        closeQuietly(fileInputStream);
                        AppMethodBeat.o(991);
                        throw th;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = null;
                closeQuietly(fileInputStream);
                AppMethodBeat.o(991);
                throw th;
            }
        }
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(TbsLog.TBSLOG_CODE_SDK_UNAVAIL_X5CORE);
        assertNotNull(bArr, "'data' is null.");
        Bitmap decodeByteArrayInternal = decodeByteArrayInternal(bArr, i2, i3, null);
        AppMethodBeat.o(TbsLog.TBSLOG_CODE_SDK_UNAVAIL_X5CORE);
        return decodeByteArrayInternal;
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i2, int i3, BitmapFactory.Options options) {
        AppMethodBeat.i(TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE);
        assertNotNull(bArr, "'data' is null.");
        Bitmap decodeByteArrayInternal = decodeByteArrayInternal(bArr, i2, i3, options);
        AppMethodBeat.o(TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE);
        return decodeByteArrayInternal;
    }

    private static Bitmap decodeByteArrayInternal(byte[] bArr, int i2, int i3, BitmapFactory.Options options) {
        boolean z = false;
        AppMethodBeat.i(TbsLog.TBSLOG_CODE_SDK_NO_SHARE_X5CORE);
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        if (isForceSystemDecoder(options)) {
            Log.w(TAG, "[!] force decoding data by system codec.");
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, i2, i3, options);
            announceDecodeResult(options, decodeByteArray, true);
            AppMethodBeat.o(TbsLog.TBSLOG_CODE_SDK_NO_SHARE_X5CORE);
            return decodeByteArray;
        }
        try {
            Bitmap nativeDecodeByteArray = nativeDecodeByteArray(bArr, i2, i3, options);
            if (options.outMimeType != null) {
                z = true;
            }
            if (z) {
                announceDecodeResult(options, nativeDecodeByteArray, false);
                setDensityFromOptions(nativeDecodeByteArray, options);
                Bitmap scaleBitmapOnDemand = scaleBitmapOnDemand(nativeDecodeByteArray, options);
                AppMethodBeat.o(TbsLog.TBSLOG_CODE_SDK_NO_SHARE_X5CORE);
                return scaleBitmapOnDemand;
            }
            Log.w(TAG, "[!] unsupported image format, try to decode with system codec.");
            Bitmap decodeByteArray2 = BitmapFactory.decodeByteArray(bArr, i2, i3, options);
            announceDecodeResult(options, decodeByteArray2, true);
            AppMethodBeat.o(TbsLog.TBSLOG_CODE_SDK_NO_SHARE_X5CORE);
            return decodeByteArray2;
        } catch (Throwable th) {
            Log.e(TAG, th, "decode failed.");
            AppMethodBeat.o(TbsLog.TBSLOG_CODE_SDK_NO_SHARE_X5CORE);
            return null;
        }
    }

    public static Bitmap decodeStream(InputStream inputStream) {
        AppMethodBeat.i(TbsLog.TBSLOG_CODE_SDK_THIRD_MODE);
        assertNotNull(inputStream, "'is' is null.");
        Bitmap decodeStreamInternal = decodeStreamInternal(inputStream, null, null);
        AppMethodBeat.o(TbsLog.TBSLOG_CODE_SDK_THIRD_MODE);
        return decodeStreamInternal;
    }

    public static Bitmap decodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        AppMethodBeat.i(TbsLog.TBSLOG_CODE_SDK_SELF_MODE);
        assertNotNull(inputStream, "'is' is null.");
        Bitmap decodeStreamInternal = decodeStreamInternal(inputStream, rect, options);
        AppMethodBeat.o(TbsLog.TBSLOG_CODE_SDK_SELF_MODE);
        return decodeStreamInternal;
    }

    private static Bitmap decodeStreamInternal(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR);
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        if (inputStream instanceof AssetManager.AssetInputStream) {
            Log.w(TAG, "[!] force decoding stream by system codec since it's asset stream.");
            z = true;
        } else if (isForceSystemDecoder(options)) {
            Log.w(TAG, "[!] force decoding stream by system codec since specific options.");
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, rect, options);
            announceDecodeResult(options, decodeStream, true);
            AppMethodBeat.o(TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR);
            return decodeStream;
        }
        try {
            InputStream wrapUnResetableStreamOnDemand = wrapUnResetableStreamOnDemand(inputStream);
            wrapUnResetableStreamOnDemand.mark(getCompatibleRewindBufferSize());
            Bitmap nativeDecodeStream = nativeDecodeStream(wrapUnResetableStreamOnDemand, rect, options);
            if (options.outMimeType != null) {
                z2 = true;
            }
            if (z2) {
                announceDecodeResult(options, nativeDecodeStream, false);
                setDensityFromOptions(nativeDecodeStream, options);
                Bitmap scaleBitmapOnDemand = scaleBitmapOnDemand(nativeDecodeStream, options);
                AppMethodBeat.o(TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR);
                return scaleBitmapOnDemand;
            }
            Log.w(TAG, "[!] unsupported image format, try to decode with system codec.");
            wrapUnResetableStreamOnDemand.reset();
            wrapUnResetableStreamOnDemand.mark(getCompatibleRewindBufferSize());
            Bitmap decodeStream2 = BitmapFactory.decodeStream(wrapUnResetableStreamOnDemand, rect, options);
            announceDecodeResult(options, decodeStream2, true);
            AppMethodBeat.o(TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR);
            return decodeStream2;
        } catch (Throwable th) {
            Log.e(TAG, th, "decode failed.");
            AppMethodBeat.o(TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR);
            return null;
        }
    }

    private static InputStream getStreamFromPath(String str) {
        AppMethodBeat.i(TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR);
        if (sStreamProvider != null) {
            InputStream streamFromPath = sStreamProvider.getStreamFromPath(str);
            if (streamFromPath == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Injected stream provider returned null in getStreamFromPath.");
                AppMethodBeat.o(TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR);
                throw illegalArgumentException;
            }
            AppMethodBeat.o(TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR);
            return streamFromPath;
        }
        FileInputStream fileInputStream = new FileInputStream(str);
        AppMethodBeat.o(TbsLog.TBSLOG_CODE_SDK_LOAD_ERROR);
        return fileInputStream;
    }

    private static void announceDecodeResult(BitmapFactory.Options options, Bitmap bitmap, boolean z) {
        AppMethodBeat.i(999);
        assertNotNull(options, "[-] opts is null.");
        String str = z ? "system" : "mmcodec";
        if (!(bitmap == null && options.outMimeType == null) && options.outWidth > 0 && options.outHeight > 0) {
            Log.i(TAG, "[+] decode success by %s, boundsOnly:%s, w:%s, h:%s, mime-type:%s, sampleSize:%s", str, Boolean.valueOf(options.inJustDecodeBounds), Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), options.outMimeType, Integer.valueOf(options.inSampleSize));
            if (!(sDecodeCanary == null || bitmap == null || options.inJustDecodeBounds)) {
                int byteCount = bitmap.getByteCount();
                if (((long) byteCount) >= 20971520) {
                    sDecodeCanary.a(options, byteCount);
                }
                AppMethodBeat.o(999);
                return;
            }
        } else {
            Log.e(TAG, "[+] fail to decode by %s", str);
        }
        AppMethodBeat.o(999);
    }

    public static Bitmap pinBitmap(Bitmap bitmap) {
        AppMethodBeat.i(1000);
        if (bitmap != null && !bitmap.isRecycled()) {
            Log.i(TAG, "[tomys] Try to pin bmp (%s), [w: %s, h: %s, config: %s, size: %s]", bitmap, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), bitmap.getConfig(), Integer.valueOf(bitmap.getByteCount()));
            int nativePinBitmap = nativePinBitmap(bitmap);
            if (nativePinBitmap < 0) {
                Log.e(TAG, "pinBitmap failed, ret: %s", Integer.valueOf(nativePinBitmap));
            }
        }
        AppMethodBeat.o(1000);
        return bitmap;
    }

    public static Bitmap unPinBitmap(Bitmap bitmap) {
        AppMethodBeat.i(1001);
        if (bitmap != null && !bitmap.isRecycled()) {
            Log.i(TAG, "[tomys] Try to unpin bmp (%s), [w: %s, h: %s, config: %s, size: %s]", bitmap, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), bitmap.getConfig(), Integer.valueOf(bitmap.getByteCount()));
            int nativeUnPinBitmap = nativeUnPinBitmap(bitmap);
            if (nativeUnPinBitmap < 0) {
                Log.e(TAG, "unPinBitmap failed, ret: %s", Integer.valueOf(nativeUnPinBitmap));
            }
        }
        AppMethodBeat.o(1001);
        return bitmap;
    }

    private static boolean isForceSystemDecoder(BitmapFactory.Options options) {
        AppMethodBeat.i(1002);
        if (sForceUsingSystemDecoderOpt || (options != null && Build.VERSION.SDK_INT >= 26 && Bitmap.Config.HARDWARE.equals(options.inPreferredConfig))) {
            AppMethodBeat.o(1002);
            return true;
        }
        AppMethodBeat.o(1002);
        return false;
    }

    private static void assertNotNull(Object obj, String str) {
        AppMethodBeat.i(1003);
        if (obj == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str);
            AppMethodBeat.o(1003);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(1003);
    }

    private static void closeQuietly(Closeable closeable) {
        AppMethodBeat.i(1004);
        if (closeable == null) {
            AppMethodBeat.o(1004);
            return;
        }
        try {
            closeable.close();
            AppMethodBeat.o(1004);
        } catch (Throwable th) {
            AppMethodBeat.o(1004);
        }
    }

    private static byte[] getOrCreateStorageBuffer(BitmapFactory.Options options) {
        byte[] bArr = options != null ? options.inTempStorage : null;
        return bArr != null ? bArr : new byte[4096];
    }

    private static Bitmap scaleBitmapOnDemand(Bitmap bitmap, BitmapFactory.Options options) {
        float f2;
        AppMethodBeat.i(1005);
        if (bitmap == null || options == null) {
            AppMethodBeat.o(1005);
            return bitmap;
        } else if (!options.inScaled) {
            AppMethodBeat.o(1005);
            return bitmap;
        } else {
            int i2 = options.inDensity;
            int i3 = options.inTargetDensity;
            int i4 = options.inScreenDensity;
            if (i2 == 0 || i3 == 0 || i2 == i4) {
                f2 = 1.0f;
            } else {
                f2 = ((float) i3) / ((float) i2);
            }
            if (f2 == 1.0f) {
                AppMethodBeat.o(1005);
                return bitmap;
            }
            int width = (int) ((((float) bitmap.getWidth()) * f2) + 0.5f);
            int height = (int) ((f2 * ((float) bitmap.getHeight())) + 0.5f);
            float width2 = ((float) width) / ((float) bitmap.getWidth());
            float height2 = ((float) height) / ((float) bitmap.getHeight());
            Log.d(TAG, "[+] Bmp to scale: [sw: %s, sh: %s, dw: %s, dh: %s, scX: %s, scY: %s]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(width), Integer.valueOf(height), Float.valueOf(width2), Float.valueOf(height2));
            Matrix matrix = new Matrix();
            matrix.setScale(width2, height2);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (createBitmap != bitmap) {
                bitmap.recycle();
            }
            AppMethodBeat.o(1005);
            return createBitmap;
        }
    }

    private static void setDensityFromOptions(Bitmap bitmap, BitmapFactory.Options options) {
        AppMethodBeat.i(1006);
        if (bitmap == null || options == null) {
            AppMethodBeat.o(1006);
            return;
        }
        int i2 = options.inDensity;
        if (i2 != 0) {
            bitmap.setDensity(i2);
            int i3 = options.inTargetDensity;
            if (i3 == 0 || i2 == i3 || i2 == options.inScreenDensity) {
                AppMethodBeat.o(1006);
                return;
            }
            byte[] ninePatchChunk = bitmap.getNinePatchChunk();
            boolean z = ninePatchChunk != null && NinePatch.isNinePatchChunk(ninePatchChunk);
            if (options.inScaled || z) {
                bitmap.setDensity(i3);
            }
            AppMethodBeat.o(1006);
            return;
        }
        if (options.inBitmap != null) {
            bitmap.setDensity(160);
        }
        AppMethodBeat.o(1006);
    }

    private static int getCompatibleRewindBufferSize() {
        AppMethodBeat.i(1007);
        if ("HUAWEI".equals(Build.MANUFACTURER)) {
            AppMethodBeat.o(1007);
        } else {
            AppMethodBeat.o(1007);
        }
        return 8388608;
    }

    private static InputStream wrapUnResetableStreamOnDemand(InputStream inputStream) {
        AppMethodBeat.i(1008);
        if (inputStream.markSupported()) {
            AppMethodBeat.o(1008);
            return inputStream;
        } else if (inputStream instanceof FileInputStream) {
            a aVar = new a((FileInputStream) inputStream);
            AppMethodBeat.o(1008);
            return aVar;
        } else {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            AppMethodBeat.o(1008);
            return bufferedInputStream;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends FilterInputStream {
        private long hjN = 0;

        public a(FileInputStream fileInputStream) {
            super(fileInputStream);
        }

        public final boolean markSupported() {
            return true;
        }

        public final synchronized void mark(int i2) {
            AppMethodBeat.i(978);
            try {
                this.hjN = ((FileInputStream) this.in).getChannel().position();
                AppMethodBeat.o(978);
            } catch (IOException e2) {
                Log.e(MMBitmapFactory.TAG, e2, "fail to mark position.");
                this.hjN = -1;
                AppMethodBeat.o(978);
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public final synchronized void reset() {
            AppMethodBeat.i(979);
            if (this.hjN < 0) {
                IOException iOException = new IOException("Illegal marked position: " + this.hjN);
                AppMethodBeat.o(979);
                throw iOException;
            }
            ((FileInputStream) this.in).getChannel().position(this.hjN);
            AppMethodBeat.o(979);
        }
    }

    private static void loadNativeModule(String str) {
        AppMethodBeat.i(1009);
        try {
            System.loadLibrary(str);
            Log.i(TAG, "Successfully load native module: %s", str);
            AppMethodBeat.o(1009);
        } catch (Throwable th) {
            Log.e(TAG, th, "Fail to load native module: %s", str);
            RuntimeException runtimeException = new RuntimeException(th);
            AppMethodBeat.o(1009);
            throw runtimeException;
        }
    }

    private MMBitmapFactory() {
        AppMethodBeat.i(1010);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(1010);
        throw unsupportedOperationException;
    }
}
