package com.tencent.mm.plugin.sight.base;

import android.graphics.Bitmap;
import android.os.Build;
import android.view.Surface;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.http.HttpClientWrapper;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.vfs.s;
import java.io.File;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class SightVideoJNI {
    public static final int MMSIGHT_YUV420P = 2;
    public static final int MMSIGHT_YUV420SP = 1;
    private static final Object MMSightLock = new Object();
    private static final String TAG = "MicroMsg.SightVideoJNI";
    public static final int TYPE_BITMAP = 1;
    public static final int TYPE_SURFACE = 0;

    public static native void NV21ToYUV420XXAndScaleRotate(byte[] bArr, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, boolean z2);

    public static native void blendYuvFrame(byte[] bArr, byte[] bArr2, int i2, int i3);

    public static native void cropCameraData(byte[] bArr, byte[] bArr2, int i2, int i3, int i4);

    public static native void cropCameraDataLongEdge(byte[] bArr, byte[] bArr2, int i2, int i3, int i4);

    public static native void cropCameraDataLongEdgeCenterCrop(byte[] bArr, byte[] bArr2, int i2, int i3, int i4);

    public static native int drawFrame(int i2, Bitmap bitmap, int i3, Bitmap bitmap2, boolean z, boolean z2);

    public static native int drawScaledFrame(int i2, Bitmap bitmap, int i3, int i4);

    public static native int drawSurfaceColor(Surface surface, int i2);

    public static native int drawSurfaceFrame(int i2, Surface surface, int i3, Bitmap bitmap, boolean z);

    public static native int drawSurfaceThumb(Surface surface, Bitmap bitmap, Bitmap bitmap2);

    public static native int freeAll();

    public static native int freeObj(int i2);

    public static native int[] getBlurThumbData(int i2);

    public static native int[] getBlurThumbDataFromBmp(Bitmap bitmap);

    public static native int getHeight(int i2);

    private static native byte[] getMP4Chpl(String str);

    private static native byte[] getMP4Cprt(String str);

    private static native byte[] getMP4RecordInfo(String str);

    private static native int getMp4Rotate(String str);

    private static native String getSimpleMp4Info(String str, boolean z);

    public static native byte[] getThumbData(int i2);

    public static native double getVideoDuration(int i2);

    public static native int getVideoHeight(int i2);

    public static native String getVideoInfo(int i2);

    public static native double getVideoPlayTime(int i2);

    public static native double getVideoRate(int i2);

    public static native double getVideoStartTime(int i2);

    public static native int getVideoWidth(int i2);

    public static native int getWidth(int i2);

    public static native int handleThumb(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3);

    public static native int initDataBufferForMMSight(int i2, int i3, int i4, int i5, int i6, float f2, int i7, int i8, int i9, int i10, float f3, boolean z, boolean z2, int i11, boolean z3, String str, boolean z4, boolean z5, boolean z6);

    private static native int initDataBufferForRemux(String str, boolean z, boolean z2, boolean z3);

    public static native void initScaleAndRoateBuffer(int i2);

    private static native boolean isH265Video(String str);

    private static native int isSightOk(String str, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int i2);

    public static native byte[] loadAACData(int i2);

    public static native void mirrorCameraData(byte[] bArr, int i2, int i3, boolean z);

    private static native int muxing(int i2, String str, int i3, int i4, int i5, int i6, long j2, String str2, float f2, int i7, int i8, int i9, int i10, int i11, float f3, byte[] bArr, int i12, boolean z, boolean z2, boolean z3, boolean z4);

    public static native void nativeBufferCopy(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i2, int i3, int i4);

    private static native int openFile(String str, int i2, int i3, boolean z);

    private static native boolean optimizeMP4(String str, String str2);

    public static native void paddingYuvData16(byte[] bArr, byte[] bArr2, int i2, int i3, int i4);

    public static native void registerALL();

    public static native void releaseBigSightDataBuffer(int i2);

    public static native int releaseRecorderBuffer();

    public static native void releaseScaleAndRoateBuffer(int i2);

    private static native int remuxing(String str, String str2, int i2, int i3, int i4, int i5, int i6, int i7, float f2, float f3, byte[] bArr, int i8, boolean z, int i9, int i10, String str3, boolean z2);

    public static native void rgbaToNV21(int[] iArr, byte[] bArr, int i2, int i3);

    public static native int seekStream(double d2, int i2);

    public static native int seekStreamWithFlag(double d2, int i2, int i3);

    public static native void setRotateForBufId(int i2, int i3);

    private static native int shouldRemuxing(String str, int i2, int i3, int i4, double d2, int i5);

    private static native void tagMP4CprtChpl(String str, byte[] bArr, int i2, byte[] bArr2, int i3, boolean z);

    private static native void tagMP4Dscp(String str, byte[] bArr, int i2);

    private static native void tagMP4RecordInfo(String str, byte[] bArr, int i2);

    private static native int tagRotateVideo(String str, String str2, int i2);

    public static native int triggerEncode(int i2, int i3, boolean z);

    public static native void writeAACData(int i2, ByteBuffer byteBuffer, int i3, long j2);

    public static native void writeAACDataWithADTS(int i2, ByteBuffer byteBuffer, int i3, long j2, int i4, int i5, int i6);

    public static native void writeBlurData(int i2, byte[] bArr, int i3, int i4, int i5);

    private static native void writeDtsData(int i2, long j2);

    public static native void writeH264Data(int i2, ByteBuffer byteBuffer, int i3, long j2);

    public static native void writeRGBDataForMMSight(int i2, Buffer buffer, int i3, int i4, boolean z, boolean z2, int i5, int i6);

    public static native void writeThumbData(int i2, byte[] bArr, int i3, int i4, int i5);

    public static native void writeYuvDataForMMSight(int i2, byte[] bArr, int i3, int i4, int i5, boolean z, boolean z2, int i6, int i7);

    public static native void writeYuvDataForMMSightWithBuffer(int i2, Buffer buffer, int i3, int i4, boolean z, boolean z2, int i5, int i6);

    static {
        AppMethodBeat.i(133637);
        AppMethodBeat.o(133637);
    }

    public static int openFileVFS(String str, int i2, int i3, boolean z) {
        AppMethodBeat.i(133608);
        int openFile = openFile(q.k(str, false), i2, i3, z);
        AppMethodBeat.o(133608);
        return openFile;
    }

    public static int initDataBufferForMMSightLock(int i2, int i3, int i4, int i5, int i6, float f2, int i7, int i8, int i9, int i10, float f3, boolean z, boolean z2, int i11, boolean z3, boolean z4, boolean z5) {
        int initDataBufferForMMSight;
        AppMethodBeat.i(201790);
        synchronized (MMSightLock) {
            try {
                initDataBufferForMMSight = initDataBufferForMMSight(i2, i3, i4, i5, i6, f2, i7, i8, i9, i10, f3, z, z2, i11, z3, b.eVt(), z5, true, z4);
            } finally {
                AppMethodBeat.o(201790);
            }
        }
        return initDataBufferForMMSight;
    }

    public static int initDataBufferForMMSightLock(int i2, int i3, int i4, int i5, int i6, float f2, int i7, int i8, int i9, int i10, float f3, boolean z, boolean z2, int i11, boolean z3) {
        int initDataBufferForMMSight;
        AppMethodBeat.i(133611);
        synchronized (MMSightLock) {
            try {
                initDataBufferForMMSight = initDataBufferForMMSight(i2, i3, i4, i5, i6, f2, i7, i8, i9, i10, f3, z, z2, i11, z3, b.eVt(), b.aj(z2, false), true, false);
            } finally {
                AppMethodBeat.o(133611);
            }
        }
        return initDataBufferForMMSight;
    }

    public static int initDataBufferForMMSightLock(int i2, int i3, int i4, int i5, int i6, float f2, int i7, int i8, int i9, int i10, float f3, boolean z, boolean z2, int i11, String str) {
        int initDataBufferForMMSight;
        AppMethodBeat.i(201791);
        synchronized (MMSightLock) {
            try {
                initDataBufferForMMSight = initDataBufferForMMSight(i2, i3, i4, i5, i6, f2, i7, i8, i9, i10, f3, z, z2, i11, false, str, b.aj(z2, false), true, false);
            } finally {
                AppMethodBeat.o(201791);
            }
        }
        return initDataBufferForMMSight;
    }

    public static int initDataBufferForRemux(boolean z) {
        AppMethodBeat.i(133612);
        int initDataBufferForRemux = initDataBufferForRemux(b.eVt(), b.aj(false, z), true, z);
        AppMethodBeat.o(133612);
        return initDataBufferForRemux;
    }

    public static void releaseBigSightDataBufferLock(int i2) {
        AppMethodBeat.i(133613);
        synchronized (MMSightLock) {
            try {
                releaseBigSightDataBuffer(i2);
            } finally {
                AppMethodBeat.o(133613);
            }
        }
    }

    public static void releaseRecorderBufferRef(String str) {
        AppMethodBeat.i(133614);
        Log.d(TAG, "ashutest::call release recorder buffer, %s", str);
        releaseRecorderBuffer();
        AppMethodBeat.o(133614);
    }

    public static void releaseRecorderBufferRefLock(String str) {
        AppMethodBeat.i(133615);
        synchronized (MMSightLock) {
            try {
                Log.d(TAG, "ashutest::call release recorder buffer, %s", str);
                releaseRecorderBuffer();
            } finally {
                AppMethodBeat.o(133615);
            }
        }
    }

    public static void writeAACDataLock(int i2, ByteBuffer byteBuffer, int i3, long j2) {
        AppMethodBeat.i(133617);
        synchronized (MMSightLock) {
            try {
                writeAACData(i2, byteBuffer, i3, j2);
            } finally {
                AppMethodBeat.o(133617);
            }
        }
    }

    public static void writeAACDataWithADTSLock(int i2, ByteBuffer byteBuffer, int i3, long j2, int i4, int i5, int i6) {
        AppMethodBeat.i(133618);
        synchronized (MMSightLock) {
            try {
                writeAACDataWithADTS(i2, byteBuffer, i3, j2, i4, i5, i6);
            } finally {
                AppMethodBeat.o(133618);
            }
        }
    }

    public static void writeYuvDataForMMSightLock(int i2, byte[] bArr, int i3, int i4, int i5, boolean z, boolean z2, int i6, int i7) {
        AppMethodBeat.i(133619);
        synchronized (MMSightLock) {
            try {
                writeYuvDataForMMSight(i2, bArr, i3, i4, i5, z, z2, i6, i7);
            } finally {
                AppMethodBeat.o(133619);
            }
        }
    }

    public static void writeH264DataLock(int i2, ByteBuffer byteBuffer, int i3, long j2) {
        AppMethodBeat.i(133620);
        synchronized (MMSightLock) {
            try {
                writeH264Data(i2, byteBuffer, i3, j2);
            } finally {
                AppMethodBeat.o(133620);
            }
        }
    }

    public static void writeDtsDataLock(int i2, long j2) {
        AppMethodBeat.i(201792);
        synchronized (MMSightLock) {
            try {
                writeDtsData(i2, j2);
            } finally {
                AppMethodBeat.o(201792);
            }
        }
    }

    public static int muxingLock(int i2, String str, int i3, int i4, int i5, int i6, long j2, String str2, float f2, int i7, int i8, int i9, int i10, int i11, float f3, byte[] bArr, int i12, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        int muxing;
        AppMethodBeat.i(201793);
        synchronized (MMSightLock) {
            try {
                long currentTicks = Util.currentTicks();
                muxing = muxing(i2, q.k(str, false), i3, i4, i5, i6, j2, q.k(str2, true), f2, i7, i8, i9, i10, i11, f3, bArr, i12, z, z2, z5, b.eVs());
                b.am(0, 1);
                if (muxing < 0) {
                    b.am(2, 1);
                } else {
                    b.am(1, 1);
                }
                long ticksToNow = Util.ticksToNow(currentTicks);
                b.am(3, ticksToNow);
                Log.i("MicroMsg.WechatSight.PacketMuxerController", "WechatSight reportMuxingResult retVal: %d", Integer.valueOf(muxing));
                switch (muxing) {
                    case HttpClientWrapper.RET_NETWORK_UNAVAILABLE /*{ENCODED_INT: -10006}*/:
                        b.am(40, 1);
                        b.am(42, 1);
                        b.am(43, ticksToNow);
                        break;
                    case HttpClientWrapper.RET_CODE_UNKOWN_HOST /*{ENCODED_INT: -10005}*/:
                        b.am(35, 1);
                        b.am(37, 1);
                        b.am(38, ticksToNow);
                        break;
                    case HttpClientWrapper.RET_CODE_FILE_NOT_FOUND /*{ENCODED_INT: -10004}*/:
                        b.am(30, 1);
                        b.am(32, 1);
                        b.am(33, ticksToNow);
                        break;
                    case HttpClientWrapper.RET_CODE_ILLEGAL_STATE /*{ENCODED_INT: -10003}*/:
                        b.am(25, 1);
                        b.am(27, 1);
                        b.am(28, ticksToNow);
                        break;
                    case HttpClientWrapper.RET_CODE_PROTOCOL /*{ENCODED_INT: -10002}*/:
                        b.am(20, 1);
                        b.am(22, 1);
                        b.am(23, ticksToNow);
                        break;
                    case -10001:
                        b.am(15, 1);
                        b.am(17, 1);
                        b.am(18, ticksToNow);
                        break;
                    case 10001:
                        b.am(15, 1);
                        b.am(16, 1);
                        b.am(18, ticksToNow);
                        break;
                    case 10002:
                        b.am(20, 1);
                        b.am(21, 1);
                        b.am(23, ticksToNow);
                        break;
                    case ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL /*{ENCODED_INT: 10003}*/:
                        b.am(25, 1);
                        b.am(26, 1);
                        b.am(28, ticksToNow);
                        break;
                    case ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL /*{ENCODED_INT: 10004}*/:
                        b.am(30, 1);
                        b.am(31, 1);
                        b.am(33, ticksToNow);
                        break;
                    case 10005:
                        b.am(35, 1);
                        b.am(36, 1);
                        b.am(38, ticksToNow);
                        break;
                    case 10006:
                        b.am(40, 1);
                        b.am(41, 1);
                        b.am(43, ticksToNow);
                        break;
                }
            } finally {
                AppMethodBeat.o(201793);
            }
        }
        return muxing;
    }

    public static int shouldRemuxingVFS(String str, int i2, int i3, int i4, double d2, int i5) {
        AppMethodBeat.i(133622);
        int shouldRemuxing = shouldRemuxing(q.k(str, false), i2, i3, i4, d2, i5);
        AppMethodBeat.o(133622);
        return shouldRemuxing;
    }

    public static int remuxingVFS(String str, String str2, int i2, int i3, int i4, int i5, int i6, int i7, float f2, float f3, byte[] bArr, int i8, boolean z, int i9, int i10) {
        AppMethodBeat.i(133623);
        boolean eVr = b.eVr();
        int remuxing = remuxing(q.k(str, false), q.k(str2, true), i2, i3, i4, i5, i6, i7, f2, f3, bArr, i8, z, i9, i10, b.eVt(), eVr);
        if (eVr) {
            b.am(82, 1);
            if (remuxing < 0) {
                b.am(81, 1);
            } else {
                b.am(80, 1);
            }
        } else {
            b.am(85, 1);
            if (remuxing < 0) {
                b.am(84, 1);
            } else {
                b.am(83, 1);
            }
        }
        AppMethodBeat.o(133623);
        return remuxing;
    }

    public static String getSimpleMp4InfoVFS(String str) {
        AppMethodBeat.i(133624);
        String simpleMp4Info = getSimpleMp4Info(q.k(str, false), c.baV());
        AppMethodBeat.o(133624);
        return simpleMp4Info;
    }

    public static String getSimpleMp4InfoVFS(String str, boolean z) {
        AppMethodBeat.i(201794);
        String simpleMp4Info = getSimpleMp4Info(q.k(str, false), c.baV());
        AppMethodBeat.o(201794);
        return simpleMp4Info;
    }

    public static boolean isH265VideoVFS(String str) {
        AppMethodBeat.i(133625);
        boolean isH265Video = isH265Video(q.k(str, false));
        AppMethodBeat.o(133625);
        return isH265Video;
    }

    public static int isSightOkVFS(String str, int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int i2) {
        AppMethodBeat.i(133626);
        int isSightOk = isSightOk(q.k(str, false), iArr, iArr2, iArr3, iArr4, iArr5, i2);
        AppMethodBeat.o(133626);
        return isSightOk;
    }

    public static int tagRotateVideoVFS(String str, String str2, int i2) {
        AppMethodBeat.i(133627);
        int tagRotateVideo = tagRotateVideo(q.k(str, false), q.k(str2, true), i2);
        AppMethodBeat.o(133627);
        return tagRotateVideo;
    }

    public static int getMp4RotateVFS(String str) {
        AppMethodBeat.i(133628);
        int mp4Rotate = getMp4Rotate(q.k(str, false));
        AppMethodBeat.o(133628);
        return mp4Rotate;
    }

    public static void tagMp4RecordInfo(String str, String str2) {
        AppMethodBeat.i(133630);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(133630);
            return;
        }
        long currentTicks = Util.currentTicks();
        byte[] bytes = str2.getBytes();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bytes.length + 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        allocateDirect.put(new byte[]{85, -60});
        allocateDirect.put(bytes);
        byte[] array = allocateDirect.array();
        tagMP4RecordInfo(q.k(str, false), array, array.length);
        Log.i(TAG, "tagMP4RecordInfo used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(133630);
    }

    public static String getMp4RecordInfo(String str) {
        AppMethodBeat.i(133631);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(133631);
            return null;
        }
        byte[] mP4RecordInfo = getMP4RecordInfo(q.k(str, false));
        if (mP4RecordInfo != null && mP4RecordInfo.length > 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= mP4RecordInfo.length) {
                    i2 = 0;
                    break;
                } else if (mP4RecordInfo[i2] == -60) {
                    break;
                } else {
                    i2++;
                }
            }
            Log.i(TAG, "getMp4RecordInfo, index: %s", Integer.valueOf(i2));
            if (i2 + 1 < mP4RecordInfo.length) {
                try {
                    byte[] bArr = new byte[(mP4RecordInfo.length - (i2 + 1))];
                    System.arraycopy(mP4RecordInfo, i2 + 1, bArr, 0, bArr.length);
                    String str2 = new String(bArr);
                    AppMethodBeat.o(133631);
                    return str2;
                } catch (Exception e2) {
                }
            }
        }
        AppMethodBeat.o(133631);
        return null;
    }

    public static void tagMP4Dscp(String str, byte[] bArr) {
        AppMethodBeat.i(133632);
        if (Util.isNullOrNil(str) || bArr == null) {
            AppMethodBeat.o(133632);
            return;
        }
        long currentTicks = Util.currentTicks();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length + 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        allocateDirect.put(new byte[]{85, -60});
        allocateDirect.put(bArr);
        byte[] array = allocateDirect.array();
        tagMP4Dscp(q.k(str, false), array, array.length);
        Log.i(TAG, "tagMP4Dscp used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(133632);
    }

    public static String getMP4CprtH(String str) {
        AppMethodBeat.i(133633);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(133633);
            return null;
        }
        byte[] mP4Cprt = getMP4Cprt(q.k(str, false));
        if (mP4Cprt != null && mP4Cprt.length > 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= mP4Cprt.length) {
                    i2 = 0;
                    break;
                } else if (mP4Cprt[i2] == -57) {
                    break;
                } else {
                    i2++;
                }
            }
            Log.i(TAG, "tagMP4Cprt, index: %s", Integer.valueOf(i2));
            if (i2 + 1 < mP4Cprt.length) {
                try {
                    byte[] bArr = new byte[(mP4Cprt.length - (i2 + 1))];
                    System.arraycopy(mP4Cprt, i2 + 1, bArr, 0, bArr.length);
                    String str2 = new String(bArr);
                    AppMethodBeat.o(133633);
                    return str2;
                } catch (Exception e2) {
                }
            }
        }
        AppMethodBeat.o(133633);
        return null;
    }

    public static void tagMP4CprtChpl(String str, String str2, byte[] bArr, boolean z) {
        AppMethodBeat.i(133634);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(133634);
            return;
        }
        long currentTicks = Util.currentTicks();
        byte[] bytes = str2.getBytes();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bytes.length + 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        allocateDirect.put(new byte[]{21, -57});
        allocateDirect.put(bytes);
        byte[] array = allocateDirect.array();
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(bArr.length + 2);
        allocateDirect2.order(ByteOrder.nativeOrder());
        allocateDirect2.put(new byte[]{85, -60});
        allocateDirect2.put(bArr);
        byte[] array2 = allocateDirect2.array();
        tagMP4CprtChpl(q.k(str, false), array, array.length, array2, array2.length, z);
        Log.i(TAG, "tagMP4CprtInfo used %sms", Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(133634);
    }

    public static void addReportMetadata(String str, int[] iArr, int i2, int i3) {
        AppMethodBeat.i(133635);
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_mmadaptive_android_extrabitrate, 0);
        Log.i(TAG, "ABA: Adaptive Bitrate RemuxOutput: %s, abaSwitch: [%d] ,qpSwitch [%d] androidflag[%d]", str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(a2));
        if (i2 == 1 || i2 == 2) {
            byte[] bArr = {1, 0, 0, 0};
            int i4 = 0;
            int i5 = 0;
            if (iArr != null) {
                bArr[2] = (byte) iArr[3];
                i4 = iArr[3];
                i5 = iArr[4];
            }
            if (a2 == 1) {
                bArr[3] = 66;
            } else {
                bArr[3] = 68;
            }
            Log.i(TAG, "ABA: Adaptive Bitrate RemuxOutput: %s  [%d]", str, Integer.valueOf(i4));
            if (i4 > 0) {
                tagMP4CprtChpl(str, "AdaptiveBitrateUP", bArr, true);
            } else if (i5 > 0) {
                tagMP4CprtChpl(str, "AdaptiveBitrateDown", bArr, true);
            } else {
                tagMP4CprtChpl(str, "AdaptiveBitrateUP", bArr, false);
            }
            optimizeMP4VFS(str);
        }
        if (i3 == 1 || i3 == 2) {
            byte[] bArr2 = {0, 1, 0, 0};
            bArr2[2] = (byte) iArr[3];
            if (a2 == 1) {
                bArr2[3] = 66;
            } else {
                bArr2[3] = 68;
            }
            Log.i(TAG, "ABA: Adaptive Bitrate(QP) RemuxOutput: %s  [%d]", str, Integer.valueOf(iArr[3]));
            if (iArr[3] > 0) {
                Log.i(TAG, "ABA: Adaptive Bitrate Write Atom: %s  [%d]", str, Integer.valueOf(iArr[3]));
                tagMP4CprtChpl(str, "AdaptiveBitrateUP", bArr2, true);
            } else {
                tagMP4CprtChpl(str, "AdaptiveBitrateUP", bArr2, false);
            }
            optimizeMP4VFS(str);
        }
        AppMethodBeat.o(133635);
    }

    public static boolean optimizeMP4VFS(String str) {
        AppMethodBeat.i(201795);
        final String k = q.k(str, true);
        String str2 = k + ".tmp";
        boolean optimizeMP4 = optimizeMP4(k, str2);
        Log.d(TAG, "optimizeMP4VFS result:%s", Boolean.valueOf(optimizeMP4));
        if (optimizeMP4) {
            s.nx(str2, k);
            if (Build.VERSION.SDK_INT >= 30 && !k.contains(FilePathGenerator.ANDROID_DIR_SEP + MMApplicationContext.getContext().getPackageName()) && !new File(new File(k).getParent(), FilePathGenerator.NO_MEDIA_FILENAME).exists()) {
                h.RTc.o(new Runnable() {
                    /* class com.tencent.mm.plugin.sight.base.SightVideoJNI.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(201789);
                        AndroidMediaUtil.insertPathIntoMediaStore(MMApplicationContext.getContext(), k);
                        AppMethodBeat.o(201789);
                    }
                }, 800);
            }
        } else {
            Log.e(TAG, "optimizeMP4VFS error");
            s.deleteFile(str2);
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(986, 147, 1);
        }
        AppMethodBeat.o(201795);
        return optimizeMP4;
    }

    public static void reportIDKey(long j2, long j3, long j4) {
        AppMethodBeat.i(176224);
        try {
            e.INSTANCE.idkeyStat(j2, j3, j4, false);
            Log.d(TAG, "reportIDKey jni called: %d, %d, %d", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
            AppMethodBeat.o(176224);
        } catch (Error e2) {
            Log.printErrStackTrace(TAG, e2, "reportIDKey jni called error", new Object[0]);
            AppMethodBeat.o(176224);
        }
    }
}
