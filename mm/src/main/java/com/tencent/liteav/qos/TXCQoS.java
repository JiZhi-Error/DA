package com.tencent.liteav.qos;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.liteav.basic.a.c;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TXCQoS {
    public static final int AUTO_ADJUST_LIVEPUSH_RESOLUTION_STRATEGY = 1;
    public static final int AUTO_ADJUST_REALTIME_VIDEOCHAT_STRATEGY = 5;
    private static final Map<Integer, c> RESOLUTION_MAP;
    static final String TAG = "TXCQos";
    private int mAutoStrategy = -1;
    private int mBitrate = 0;
    private Handler mHandler = new Handler();
    private int mHeight = 0;
    private long mInstance;
    private long mInterval = 1000;
    private boolean mIsEnableDrop = false;
    private a mListener;
    private b mNotifyListener;
    private Runnable mRunnable = new Runnable() {
        /* class com.tencent.liteav.qos.TXCQoS.AnonymousClass1 */

        public void run() {
            AppMethodBeat.i(16202);
            if (TXCQoS.this.mListener != null) {
                int b2 = TXCQoS.this.mListener.b();
                int c2 = TXCQoS.this.mListener.c();
                int d2 = TXCQoS.this.mListener.d();
                int e2 = TXCQoS.this.mListener.e();
                int f2 = TXCQoS.this.mListener.f();
                int g2 = TXCQoS.this.mListener.g();
                int h2 = TXCQoS.this.mListener.h();
                TXCQoS.access$200(TXCQoS.this, TXCQoS.this.mInstance, b2);
                TXCQoS.access$300(TXCQoS.this, TXCQoS.this.mInstance, e2, f2, g2, d2, c2, h2);
                boolean access$400 = TXCQoS.access$400(TXCQoS.this, TXCQoS.this.mInstance);
                if (TXCQoS.this.mIsEnableDrop != access$400) {
                    TXCQoS.this.mIsEnableDrop = access$400;
                    TXCQoS.this.mListener.a(access$400);
                }
                int access$600 = TXCQoS.access$600(TXCQoS.this, TXCQoS.this.mInstance);
                int access$700 = TXCQoS.access$700(TXCQoS.this, TXCQoS.this.mInstance);
                int access$800 = TXCQoS.access$800(TXCQoS.this, TXCQoS.this.mInstance);
                if (access$700 == TXCQoS.this.mWidth && access$800 == TXCQoS.this.mHeight) {
                    if (access$600 != TXCQoS.this.mBitrate) {
                        TXCQoS.this.mListener.b(access$600, 0, 0);
                        if (TXCQoS.this.mNotifyListener != null) {
                            Bundle bundle = new Bundle();
                            bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, "Adjust encoding bitrate:new bitrate:".concat(String.valueOf(access$600)));
                            bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                            bundle.putString("EVT_USERID", TXCQoS.this.mUserID);
                            TXCQoS.this.mNotifyListener.onNotifyEvent(1006, bundle);
                        }
                    }
                } else if (TXCQoS.this.mAutoStrategy == 1 || TXCQoS.this.mAutoStrategy == 5) {
                    TXCQoS.this.mListener.b(access$600, access$700, access$800);
                    if (TXCQoS.this.mNotifyListener != null) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, "Adjust resolution:new bitrate:" + access$600 + " new resolution:" + access$700 + "*" + access$800);
                        bundle2.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                        TXCQoS.this.mNotifyListener.onNotifyEvent(1005, bundle2);
                    }
                }
                TXCQoS.this.mBitrate = access$600;
                TXCQoS.this.mWidth = access$700;
                TXCQoS.this.mHeight = access$800;
            }
            TXCQoS.this.mHandler.postDelayed(this, TXCQoS.this.mInterval);
            AppMethodBeat.o(16202);
        }
    };
    private String mUserID = "";
    private int mWidth = 0;

    private native void nativeAddQueueInputSize(long j2, int i2);

    private native void nativeAddQueueOutputSize(long j2, int i2);

    private native void nativeAdjustBitrate(long j2, int i2, int i3, int i4, int i5, int i6, int i7);

    private native void nativeDeinit(long j2);

    private native int nativeGetBitrate(long j2);

    private native int nativeGetHeight(long j2);

    private static native int nativeGetProperResolutionByVideoBitrate(boolean z, int i2, int i3);

    private native int nativeGetWidth(long j2);

    private native long nativeInit(boolean z);

    private native boolean nativeIsEnableDrop(long j2);

    private native void nativeReset(long j2, boolean z);

    private native void nativeSetAutoAdjustBitrate(long j2, boolean z);

    private native void nativeSetAutoAdjustStrategy(long j2, int i2);

    private native void nativeSetHasVideo(long j2, boolean z);

    private native void nativeSetVideoDefaultResolution(long j2, int i2);

    private native void nativeSetVideoEncBitrate(long j2, int i2, int i3, int i4);

    private native void nativeSetVideoExpectBitrate(long j2, int i2);

    private native void nativeSetVideoRealBitrate(long j2, int i2);

    static /* synthetic */ void access$200(TXCQoS tXCQoS, long j2, int i2) {
        AppMethodBeat.i(16215);
        tXCQoS.nativeSetVideoRealBitrate(j2, i2);
        AppMethodBeat.o(16215);
    }

    static /* synthetic */ void access$300(TXCQoS tXCQoS, long j2, int i2, int i3, int i4, int i5, int i6, int i7) {
        AppMethodBeat.i(16216);
        tXCQoS.nativeAdjustBitrate(j2, i2, i3, i4, i5, i6, i7);
        AppMethodBeat.o(16216);
    }

    static /* synthetic */ boolean access$400(TXCQoS tXCQoS, long j2) {
        AppMethodBeat.i(16217);
        boolean nativeIsEnableDrop = tXCQoS.nativeIsEnableDrop(j2);
        AppMethodBeat.o(16217);
        return nativeIsEnableDrop;
    }

    static /* synthetic */ int access$600(TXCQoS tXCQoS, long j2) {
        AppMethodBeat.i(16218);
        int nativeGetBitrate = tXCQoS.nativeGetBitrate(j2);
        AppMethodBeat.o(16218);
        return nativeGetBitrate;
    }

    static /* synthetic */ int access$700(TXCQoS tXCQoS, long j2) {
        AppMethodBeat.i(16219);
        int nativeGetWidth = tXCQoS.nativeGetWidth(j2);
        AppMethodBeat.o(16219);
        return nativeGetWidth;
    }

    static /* synthetic */ int access$800(TXCQoS tXCQoS, long j2) {
        AppMethodBeat.i(16220);
        int nativeGetHeight = tXCQoS.nativeGetHeight(j2);
        AppMethodBeat.o(16220);
        return nativeGetHeight;
    }

    static {
        AppMethodBeat.i(16221);
        HashMap hashMap = new HashMap();
        hashMap.put(0, c.RESOLUTION_TYPE_360_640);
        hashMap.put(1, c.RESOLUTION_TYPE_540_960);
        hashMap.put(2, c.RESOLUTION_TYPE_720_1280);
        hashMap.put(3, c.RESOLUTION_TYPE_640_360);
        hashMap.put(4, c.RESOLUTION_TYPE_960_540);
        hashMap.put(5, c.RESOLUTION_TYPE_1280_720);
        hashMap.put(6, c.RESOLUTION_TYPE_320_480);
        hashMap.put(7, c.RESOLUTION_TYPE_180_320);
        hashMap.put(8, c.RESOLUTION_TYPE_270_480);
        hashMap.put(9, c.RESOLUTION_TYPE_320_180);
        hashMap.put(10, c.RESOLUTION_TYPE_480_270);
        hashMap.put(11, c.RESOLUTION_TYPE_240_320);
        hashMap.put(12, c.RESOLUTION_TYPE_360_480);
        hashMap.put(13, c.RESOLUTION_TYPE_480_640);
        hashMap.put(14, c.RESOLUTION_TYPE_320_240);
        hashMap.put(15, c.RESOLUTION_TYPE_480_360);
        hashMap.put(16, c.RESOLUTION_TYPE_640_480);
        hashMap.put(17, c.RESOLUTION_TYPE_480_480);
        hashMap.put(18, c.RESOLUTION_TYPE_270_270);
        hashMap.put(19, c.RESOLUTION_TYPE_160_160);
        RESOLUTION_MAP = Collections.unmodifiableMap(hashMap);
        f.f();
        AppMethodBeat.o(16221);
    }

    public TXCQoS(boolean z) {
        AppMethodBeat.i(16203);
        this.mInstance = nativeInit(z);
        AppMethodBeat.o(16203);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(16204);
        try {
            nativeDeinit(this.mInstance);
        } finally {
            super.finalize();
            AppMethodBeat.o(16204);
        }
    }

    public void start(long j2) {
        AppMethodBeat.i(16205);
        this.mInterval = j2;
        this.mHandler.postDelayed(this.mRunnable, this.mInterval);
        AppMethodBeat.o(16205);
    }

    public void stop() {
        AppMethodBeat.i(16206);
        this.mHandler.removeCallbacks(this.mRunnable);
        this.mAutoStrategy = -1;
        AppMethodBeat.o(16206);
    }

    public String getUserID() {
        return this.mUserID;
    }

    public void setUserID(String str) {
        this.mUserID = str;
    }

    public void setNotifyListener(b bVar) {
        this.mNotifyListener = bVar;
    }

    public void setListener(a aVar) {
        this.mListener = aVar;
    }

    public void reset(boolean z) {
        AppMethodBeat.i(16207);
        nativeReset(this.mInstance, z);
        AppMethodBeat.o(16207);
    }

    public boolean isEnableDrop() {
        AppMethodBeat.i(16208);
        boolean nativeIsEnableDrop = nativeIsEnableDrop(this.mInstance);
        AppMethodBeat.o(16208);
        return nativeIsEnableDrop;
    }

    public void setHasVideo(boolean z) {
        AppMethodBeat.i(16209);
        nativeSetHasVideo(this.mInstance, z);
        AppMethodBeat.o(16209);
    }

    public void setAutoAdjustBitrate(boolean z) {
        AppMethodBeat.i(16210);
        TXCLog.i(TAG, "autoAdjustBitrate is " + (z ? "yes" : "no"));
        nativeSetAutoAdjustBitrate(this.mInstance, z);
        AppMethodBeat.o(16210);
    }

    public void setAutoAdjustStrategy(int i2) {
        AppMethodBeat.i(16211);
        TXCLog.i(TAG, "autoAdjustStrategy is ".concat(String.valueOf(i2)));
        nativeSetAutoAdjustStrategy(this.mInstance, i2);
        this.mAutoStrategy = i2;
        AppMethodBeat.o(16211);
    }

    public void setDefaultVideoResolution(c cVar) {
        int i2 = 0;
        AppMethodBeat.i(221784);
        TXCLog.i(TAG, "DefaultVideoResolution is ".concat(String.valueOf(cVar)));
        this.mWidth = 0;
        this.mHeight = 0;
        for (Map.Entry<Integer, c> entry : RESOLUTION_MAP.entrySet()) {
            if (entry.getValue() == cVar) {
                i2 = entry.getKey().intValue();
            } else {
                i2 = i2;
            }
        }
        nativeSetVideoDefaultResolution(this.mInstance, i2);
        AppMethodBeat.o(221784);
    }

    public void setVideoEncBitrate(int i2, int i3, int i4) {
        AppMethodBeat.i(16213);
        this.mBitrate = 0;
        nativeSetVideoEncBitrate(this.mInstance, i2, i3, i4);
        AppMethodBeat.o(16213);
    }

    public void setVideoExpectBitrate(int i2) {
        AppMethodBeat.i(16214);
        nativeSetVideoExpectBitrate(this.mInstance, i2);
        AppMethodBeat.o(16214);
    }

    public static c getProperResolutionByVideoBitrate(boolean z, int i2, int i3) {
        AppMethodBeat.i(221785);
        c cVar = RESOLUTION_MAP.get(Integer.valueOf(nativeGetProperResolutionByVideoBitrate(z, i2, i3)));
        AppMethodBeat.o(221785);
        return cVar;
    }
}
