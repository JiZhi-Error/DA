package com.tencent.mm.plugin.facedetect;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expansions.a;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class FaceProNative {
    public static final int ROTFLIPHOR = 3;
    public static final int ROTFLIPLEFT = 4;
    public static final int ROTFLIPRIGHT = 5;
    public static final int ROTLEFT = 1;
    public static final int ROTRIGHT = 2;
    public static final int ROTSTABLE = 0;
    private static final String TAG = "MicroMsg.FaceProNative";
    private static final long TIMEOUT_CHECKER = 3600000;
    private static String[] cachedStr = null;
    public static volatile boolean hasDetectInit = false;
    private static long lastCheckTime = -1;
    private long nativePtr;

    private native void NativeConstructor();

    private native void NativeDestructor();

    public static native String addVerifyData2Jpg(String str, String str2, String str3);

    public static native int engineVersion();

    public static native int nativeFacedetectInitBin(byte[] bArr);

    public static native void nativeFacedetectRelease();

    public static native int nativeFacedetectWithBitmap(Object obj);

    public static native boolean nativeInit();

    public native FaceStatus engineFaceProcess(byte[] bArr, int i2, int i3, int i4, int i5, int i6);

    public native int[] engineGetAllMotions();

    public native int engineGetCurrMotion();

    public native String engineGetCurrMotionData();

    public native int engineGroupChange();

    public native int engineInit(String str, byte[] bArr, String str2, String str3);

    public native int engineNextMotion();

    public native int engineRelease();

    public native int engineReleaseCurrMotion();

    public native FaceResult engineReleaseOut();

    public native int engineSetVoiceData(byte[] bArr);

    public native int engineStartRecord();

    public FaceProNative() {
        AppMethodBeat.i(103563);
        if (PluginFace.isEnabled()) {
            tryLoadLibrary();
            NativeConstructor();
        }
        AppMethodBeat.o(103563);
    }

    public void destroy() {
        AppMethodBeat.i(103564);
        if (PluginFace.isEnabled()) {
            NativeDestructor();
        }
        AppMethodBeat.o(103564);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(103565);
        super.finalize();
        if (PluginFace.isEnabled()) {
            NativeDestructor();
        }
        AppMethodBeat.o(103565);
    }

    public static class FaceStatus implements Parcelable {
        public static final Parcelable.Creator<FaceStatus> CREATOR = new Parcelable.Creator<FaceStatus>() {
            /* class com.tencent.mm.plugin.facedetect.FaceProNative.FaceStatus.AnonymousClass1 */

            @Override // android.os.Parcelable.Creator
            public final FaceStatus createFromParcel(Parcel parcel) {
                AppMethodBeat.i(103556);
                FaceStatus faceStatus = new FaceStatus(parcel);
                AppMethodBeat.o(103556);
                return faceStatus;
            }

            @Override // android.os.Parcelable.Creator
            public final FaceStatus[] newArray(int i2) {
                return new FaceStatus[i2];
            }
        };
        public Rect facerect;
        public float pitch;
        public int result;
        public float roll;
        public float[] xys;
        public float yaw;

        public FaceStatus() {
        }

        protected FaceStatus(Parcel parcel) {
            AppMethodBeat.i(103559);
            this.result = parcel.readInt();
            this.facerect = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
            this.xys = parcel.createFloatArray();
            this.pitch = parcel.readFloat();
            this.yaw = parcel.readFloat();
            this.roll = parcel.readFloat();
            AppMethodBeat.o(103559);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(103560);
            parcel.writeInt(this.result);
            parcel.writeParcelable(this.facerect, i2);
            parcel.writeFloatArray(this.xys);
            parcel.writeFloat(this.pitch);
            parcel.writeFloat(this.yaw);
            parcel.writeFloat(this.roll);
            AppMethodBeat.o(103560);
        }

        public int describeContents() {
            return 0;
        }

        static {
            AppMethodBeat.i(103562);
            AppMethodBeat.o(103562);
        }

        public String toString() {
            AppMethodBeat.i(103561);
            String str = "FaceStatus{result=" + this.result + ", facerect=" + this.facerect + ", pitch=" + this.pitch + ", yaw=" + this.yaw + ", roll=" + this.roll + '}';
            AppMethodBeat.o(103561);
            return str;
        }
    }

    public static class FaceResult implements Parcelable {
        public static final Parcelable.Creator<FaceResult> CREATOR = new Parcelable.Creator<FaceResult>() {
            /* class com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult.AnonymousClass1 */

            @Override // android.os.Parcelable.Creator
            public final FaceResult createFromParcel(Parcel parcel) {
                AppMethodBeat.i(103549);
                FaceResult faceResult = new FaceResult(parcel);
                AppMethodBeat.o(103549);
                return faceResult;
            }

            @Override // android.os.Parcelable.Creator
            public final FaceResult[] newArray(int i2) {
                return new FaceResult[i2];
            }
        };
        public byte[] data;
        public int result;
        public byte[] sidedata;

        public FaceResult() {
        }

        protected FaceResult(Parcel parcel) {
            AppMethodBeat.i(103552);
            this.result = parcel.readInt();
            this.data = parcel.createByteArray();
            this.sidedata = parcel.createByteArray();
            AppMethodBeat.o(103552);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(103553);
            parcel.writeInt(this.result);
            parcel.writeByteArray(this.data);
            parcel.writeByteArray(this.sidedata);
            AppMethodBeat.o(103553);
        }

        public int describeContents() {
            return 0;
        }

        static {
            AppMethodBeat.i(103555);
            AppMethodBeat.o(103555);
        }

        public String toString() {
            int i2 = 0;
            AppMethodBeat.i(103554);
            StringBuilder append = new StringBuilder("FaceResult{result=").append(this.result).append(", sidedataLen=").append(this.sidedata == null ? 0 : this.sidedata.length).append(", dataLen=");
            if (this.data != null) {
                i2 = this.data.length;
            }
            String sb = append.append(i2).append('}').toString();
            AppMethodBeat.o(103554);
            return sb;
        }
    }

    static {
        AppMethodBeat.i(103569);
        tryLoadLibrary();
        AppMethodBeat.o(103569);
    }

    public static int detectFaceCnt(String str) {
        return 0;
    }

    public static void checkInitDetectFace() {
        AppMethodBeat.i(103566);
        synchronized (FaceProNative.class) {
            try {
                Log.printInfoStack(TAG, "checkInitDetectFace, hasDetectInit: %s", Boolean.valueOf(hasDetectInit));
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.facedetect.FaceProNative.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(103548);
                        if (!FaceProNative.hasDetectInit && PluginFace.isEnabled()) {
                            int nativeFacedetectInitBin = FaceProNative.nativeFacedetectInitBin(s.aW(p.cTl(), 0, -1));
                            if (nativeFacedetectInitBin == -1) {
                                Log.w(FaceProNative.TAG, "detectFaceCnt init failed: %s", p.cTl());
                                AppMethodBeat.o(103548);
                                return;
                            }
                            Log.i(FaceProNative.TAG, "detectFaceCnt init:%d, %s", Integer.valueOf(nativeFacedetectInitBin), p.cTl());
                            FaceProNative.hasDetectInit = true;
                        }
                        AppMethodBeat.o(103548);
                    }
                });
            } finally {
                AppMethodBeat.o(103566);
            }
        }
    }

    private static void tryLoadLibrary() {
        AppMethodBeat.i(103567);
        if (PluginFace.isEnabled()) {
            a.aoa("wechatvoicereco");
            a.aoa("wechatxlog");
        }
        AppMethodBeat.o(103567);
    }

    @Keep
    public static String[] getDynamicValue(String str) {
        AppMethodBeat.i(103568);
        if (System.currentTimeMillis() - lastCheckTime >= 3600000) {
            lastCheckTime = System.currentTimeMillis();
            String value = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue(str);
            if (!Util.isNullOrNil(value)) {
                try {
                    JSONArray jSONArray = new JSONArray(value);
                    ArrayList arrayList = new ArrayList(5);
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        arrayList.add(jSONArray.getString(i2));
                    }
                    cachedStr = new String[length];
                    arrayList.toArray(cachedStr);
                } catch (JSONException e2) {
                    Log.printErrStackTrace(TAG, e2, "hy: array resolve failed", new Object[0]);
                }
            }
        }
        String[] strArr = cachedStr;
        AppMethodBeat.o(103568);
        return strArr;
    }
}
