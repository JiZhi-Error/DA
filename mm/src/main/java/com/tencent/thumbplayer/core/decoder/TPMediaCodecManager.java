package com.tencent.thumbplayer.core.decoder;

import android.os.Build;
import android.util.SparseArray;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPMethodCalledByNative;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import java.util.concurrent.atomic.AtomicInteger;

public class TPMediaCodecManager {
    private static final String TAG = "TPMediaCodecManager";
    private static AtomicInteger codecNum = new AtomicInteger(0);
    private static SparseArray<ITPMediaCodecDecoder> mCodecList = new SparseArray<>();

    private static native void _onMediaCodecException(int i2, String str);

    private static native void _onMediaCodecReady(int i2, String str);

    static {
        AppMethodBeat.i(189921);
        AppMethodBeat.o(189921);
    }

    @TPMethodCalledByNative
    public static int getSDKVersion() {
        return Build.VERSION.SDK_INT;
    }

    @TPMethodCalledByNative
    public static int createMediaCodec(boolean z) {
        ITPMediaCodecDecoder tPMediaCodecVideoDecoder;
        AppMethodBeat.i(189898);
        if (codecNum.get() >= Integer.MAX_VALUE) {
            codecNum.set(0);
        }
        int andIncrement = codecNum.getAndIncrement();
        if (z) {
            tPMediaCodecVideoDecoder = new TPMediaCodecAudioDecoder(andIncrement);
        } else {
            tPMediaCodecVideoDecoder = new TPMediaCodecVideoDecoder(andIncrement);
        }
        addCodecToList(andIncrement, tPMediaCodecVideoDecoder);
        AppMethodBeat.o(189898);
        return andIncrement;
    }

    @TPMethodCalledByNative
    public static boolean initVideoMediaCodec(int i2, String str, int i3, int i4, int i5, Surface surface, int i6, int i7, int i8) {
        AppMethodBeat.i(189899);
        ITPMediaCodecDecoder codecById = getCodecById(i2);
        if (codecById == null) {
            TPNativeLog.printLog(3, TAG, "initVideoMediaCodec failed!");
            AppMethodBeat.o(189899);
            return false;
        } else if (!codecById.initDecoder(str, i3, i4, i5, surface, i6, i7, i8)) {
            AppMethodBeat.o(189899);
            return false;
        } else {
            boolean startDecoder = codecById.startDecoder();
            AppMethodBeat.o(189899);
            return startDecoder;
        }
    }

    @TPMethodCalledByNative
    public static boolean initAudioMediaCodec(int i2, String str, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(189900);
        ITPMediaCodecDecoder codecById = getCodecById(i2);
        if (codecById == null) {
            TPNativeLog.printLog(3, TAG, "initAudioMediaCodec failed!");
            AppMethodBeat.o(189900);
            return false;
        } else if (!codecById.initDecoder(str, i3, i4, i5, i6)) {
            AppMethodBeat.o(189900);
            return false;
        } else {
            boolean startDecoder = codecById.startDecoder();
            AppMethodBeat.o(189900);
            return startDecoder;
        }
    }

    @TPMethodCalledByNative
    public static int setMediaCodecSurface(int i2, Surface surface) {
        AppMethodBeat.i(189901);
        ITPMediaCodecDecoder codecById = getCodecById(i2);
        if (codecById == null) {
            TPNativeLog.printLog(3, TAG, "setMediaCodecSurface failed!");
            AppMethodBeat.o(189901);
            return 3;
        }
        int outputSurface = codecById.setOutputSurface(surface);
        AppMethodBeat.o(189901);
        return outputSurface;
    }

    @TPMethodCalledByNative
    public static int sendOnePacket(int i2, byte[] bArr, boolean z, long j2, boolean z2) {
        AppMethodBeat.i(189902);
        ITPMediaCodecDecoder codecById = getCodecById(i2);
        if (codecById == null) {
            TPNativeLog.printLog(3, TAG, "sendOnePacket failed!");
            AppMethodBeat.o(189902);
            return 3;
        }
        int decode = codecById.decode(bArr, z, j2, z2);
        AppMethodBeat.o(189902);
        return decode;
    }

    @TPMethodCalledByNative
    public static TPFrameInfo receiveOneFrame(int i2) {
        AppMethodBeat.i(189903);
        ITPMediaCodecDecoder codecById = getCodecById(i2);
        if (codecById == null) {
            TPNativeLog.printLog(3, TAG, "receiveOneFrame failed!");
            AppMethodBeat.o(189903);
            return null;
        }
        TPFrameInfo dequeueOutputBuffer = codecById.dequeueOutputBuffer();
        AppMethodBeat.o(189903);
        return dequeueOutputBuffer;
    }

    @TPMethodCalledByNative
    public static int releaseVideoFrame(int i2, int i3, boolean z) {
        AppMethodBeat.i(189904);
        ITPMediaCodecDecoder codecById = getCodecById(i2);
        if (codecById == null) {
            TPNativeLog.printLog(3, TAG, "releaseVideoFrame failed!");
            AppMethodBeat.o(189904);
            return 3;
        }
        int releaseOutputBuffer = codecById.releaseOutputBuffer(i3, z);
        AppMethodBeat.o(189904);
        return releaseOutputBuffer;
    }

    @TPMethodCalledByNative
    public static int releaseMediaCodec(int i2) {
        AppMethodBeat.i(189905);
        ITPMediaCodecDecoder codecById = getCodecById(i2);
        if (codecById == null) {
            TPNativeLog.printLog(3, TAG, "releaseMediaCodec failed!");
            AppMethodBeat.o(189905);
            return 3;
        }
        removeCodecFromList(i2);
        int release = codecById.release();
        AppMethodBeat.o(189905);
        return release;
    }

    @TPMethodCalledByNative
    public static int signalEndOfStream(int i2) {
        AppMethodBeat.i(189906);
        ITPMediaCodecDecoder codecById = getCodecById(i2);
        if (codecById == null) {
            TPNativeLog.printLog(3, TAG, "signalEndOfStream failed!");
            AppMethodBeat.o(189906);
            return 3;
        }
        int signalEndOfStream = codecById.signalEndOfStream();
        AppMethodBeat.o(189906);
        return signalEndOfStream;
    }

    @TPMethodCalledByNative
    public static int flushMediaCodec(int i2) {
        AppMethodBeat.i(189907);
        ITPMediaCodecDecoder codecById = getCodecById(i2);
        if (codecById == null) {
            TPNativeLog.printLog(3, TAG, "flushMediaCodec failed!");
            AppMethodBeat.o(189907);
            return 3;
        }
        int flush = codecById.flush();
        AppMethodBeat.o(189907);
        return flush;
    }

    @TPMethodCalledByNative
    public static boolean setMediaCodecParamInt(int i2, int i3, int i4) {
        AppMethodBeat.i(189908);
        ITPMediaCodecDecoder codecById = getCodecById(i2);
        if (codecById == null) {
            TPNativeLog.printLog(3, TAG, "setMediaCodecParamInt failed!");
            AppMethodBeat.o(189908);
            return false;
        }
        boolean paramInt = codecById.setParamInt(i3, i4);
        AppMethodBeat.o(189908);
        return paramInt;
    }

    @TPMethodCalledByNative
    public static boolean setMediaCodecParamLong(int i2, int i3, long j2) {
        AppMethodBeat.i(189909);
        ITPMediaCodecDecoder codecById = getCodecById(i2);
        if (codecById == null) {
            TPNativeLog.printLog(3, TAG, "setMediaCodecParamLong failed!");
            AppMethodBeat.o(189909);
            return false;
        }
        boolean paramLong = codecById.setParamLong(i3, j2);
        AppMethodBeat.o(189909);
        return paramLong;
    }

    @TPMethodCalledByNative
    public static boolean setMediaCodecParamBool(int i2, int i3, boolean z) {
        AppMethodBeat.i(189910);
        ITPMediaCodecDecoder codecById = getCodecById(i2);
        if (codecById == null) {
            TPNativeLog.printLog(3, TAG, "setMediaCodecParamBool failed!");
            AppMethodBeat.o(189910);
            return false;
        }
        boolean paramBool = codecById.setParamBool(i3, z);
        AppMethodBeat.o(189910);
        return paramBool;
    }

    @TPMethodCalledByNative
    public static boolean setMediaCodecParamString(int i2, int i3, String str) {
        AppMethodBeat.i(189911);
        ITPMediaCodecDecoder codecById = getCodecById(i2);
        if (codecById == null) {
            TPNativeLog.printLog(3, TAG, "setMediaCodecParamString failed!");
            AppMethodBeat.o(189911);
            return false;
        }
        boolean paramString = codecById.setParamString(i3, str);
        AppMethodBeat.o(189911);
        return paramString;
    }

    @TPMethodCalledByNative
    public static boolean setMediaCodecParamBytes(int i2, int i3, byte[] bArr) {
        AppMethodBeat.i(189912);
        ITPMediaCodecDecoder codecById = getCodecById(i2);
        if (codecById == null) {
            TPNativeLog.printLog(3, TAG, "setMediaCodecParamBytes failed!");
            AppMethodBeat.o(189912);
            return false;
        }
        boolean paramBytes = codecById.setParamBytes(i3, bArr);
        AppMethodBeat.o(189912);
        return paramBytes;
    }

    @TPMethodCalledByNative
    public static boolean setMediaCodecParamObject(int i2, int i3, Object obj) {
        AppMethodBeat.i(189913);
        ITPMediaCodecDecoder codecById = getCodecById(i2);
        if (codecById == null) {
            TPNativeLog.printLog(3, TAG, "setMediaCodecParamObject failed!");
            AppMethodBeat.o(189913);
            return false;
        }
        boolean paramObject = codecById.setParamObject(i3, obj);
        AppMethodBeat.o(189913);
        return paramObject;
    }

    @TPMethodCalledByNative
    public static void setCryptoInfo(int i2, int i3, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i4) {
        AppMethodBeat.i(189914);
        ITPMediaCodecDecoder codecById = getCodecById(i2);
        if (codecById == null) {
            TPNativeLog.printLog(3, TAG, "setMediaCodecParamObject failed!");
            AppMethodBeat.o(189914);
            return;
        }
        codecById.setCryptoInfo(i3, iArr, iArr2, bArr, bArr2, i4);
        AppMethodBeat.o(189914);
    }

    @TPMethodCalledByNative
    public static int setMediaCodecOperateRate(int i2, float f2) {
        AppMethodBeat.i(189915);
        ITPMediaCodecDecoder codecById = getCodecById(i2);
        if (codecById == null) {
            TPNativeLog.printLog(3, TAG, "setMediaCodecOperateRate failed!");
            AppMethodBeat.o(189915);
            return 3;
        }
        int operateRate = codecById.setOperateRate(f2);
        AppMethodBeat.o(189915);
        return operateRate;
    }

    public static void onMediaCodecReady(int i2, String str) {
        AppMethodBeat.i(189916);
        _onMediaCodecReady(i2, str);
        AppMethodBeat.o(189916);
    }

    public static void onMediaCodecException(int i2, String str) {
        AppMethodBeat.i(189917);
        _onMediaCodecException(i2, str);
        AppMethodBeat.o(189917);
    }

    private static void addCodecToList(int i2, ITPMediaCodecDecoder iTPMediaCodecDecoder) {
        AppMethodBeat.i(189918);
        synchronized (TPMediaCodecManager.class) {
            try {
                mCodecList.put(i2, iTPMediaCodecDecoder);
            } finally {
                AppMethodBeat.o(189918);
            }
        }
    }

    private static void removeCodecFromList(int i2) {
        AppMethodBeat.i(189919);
        synchronized (TPMediaCodecManager.class) {
            try {
                mCodecList.remove(i2);
            } finally {
                AppMethodBeat.o(189919);
            }
        }
    }

    private static ITPMediaCodecDecoder getCodecById(int i2) {
        ITPMediaCodecDecoder iTPMediaCodecDecoder;
        AppMethodBeat.i(189920);
        synchronized (TPMediaCodecManager.class) {
            try {
                iTPMediaCodecDecoder = mCodecList.get(i2);
            } catch (Throwable th) {
                AppMethodBeat.o(189920);
                throw th;
            }
        }
        if (iTPMediaCodecDecoder == null) {
            TPNativeLog.printLog(3, TAG, "No such codec by id:".concat(String.valueOf(i2)));
            AppMethodBeat.o(189920);
            return null;
        }
        AppMethodBeat.o(189920);
        return iTPMediaCodecDecoder;
    }
}
