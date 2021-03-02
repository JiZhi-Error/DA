package com.tencent.thumbplayer.api;

import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.b.a;
import com.tencent.thumbplayer.core.common.TPVideoFrame;
import com.tencent.thumbplayer.core.imagegenerator.ITPImageGeneratorCallback;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGenerator;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.utils.g;
import java.util.HashMap;
import java.util.Map;

public class TPVideoCapture implements ITPImageGeneratorCallback {
    private static final String TAG = "TPThumbPlayer[TPVideoCapture.java]";
    private Map<String, TPVideoCaptureCallBack> mCallBackMap;
    private int mHeight = 0;
    private long mOpaque = 0;
    private long mRequestedTimeMsToleranceAfter = 0;
    private long mRequestedTimeMsToleranceBefore = 0;
    private TPImageGenerator mTpImageGenerator;
    private int mWidth = 0;

    public interface TPVideoCaptureCallBack {
        void onCaptureError(int i2);

        void onCaptureSuccess(Bitmap[] bitmapArr);
    }

    public TPVideoCapture(String str) {
        AppMethodBeat.i(189050);
        this.mTpImageGenerator = new TPImageGenerator(str, this);
        this.mCallBackMap = new HashMap();
        try {
            this.mTpImageGenerator.init();
            AppMethodBeat.o(189050);
        } catch (Exception e2) {
            g.e(TAG, "init: " + Log.getStackTraceString(e2));
            AppMethodBeat.o(189050);
        }
    }

    public void setSize(int i2, int i3) {
        AppMethodBeat.i(189051);
        if (i2 < 0 || i3 < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Size is illegal");
            AppMethodBeat.o(189051);
            throw illegalArgumentException;
        }
        this.mWidth = i2;
        this.mHeight = i3;
        AppMethodBeat.o(189051);
    }

    public void setTimeMsTolerance(long j2, long j3) {
        AppMethodBeat.i(189052);
        if (j2 > j3) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Tolerance is illegal");
            AppMethodBeat.o(189052);
            throw illegalArgumentException;
        }
        this.mRequestedTimeMsToleranceBefore = j2;
        this.mRequestedTimeMsToleranceAfter = j3;
        AppMethodBeat.o(189052);
    }

    public void generateImageAsyncAtTime(long j2, TPVideoCaptureCallBack tPVideoCaptureCallBack) {
        AppMethodBeat.i(189053);
        this.mOpaque++;
        this.mCallBackMap.put(generateOpaqueKey(this.mOpaque, j2), tPVideoCaptureCallBack);
        try {
            this.mTpImageGenerator.generateImageAsyncAtTime(j2, this.mOpaque, getParameters());
            AppMethodBeat.o(189053);
        } catch (Exception e2) {
            g.e(TAG, "generateImageAsyncAtTime: " + Log.getStackTraceString(e2));
            AppMethodBeat.o(189053);
        }
    }

    public void generateImagesAsyncForTimes(long[] jArr, TPVideoCaptureCallBack tPVideoCaptureCallBack) {
        AppMethodBeat.i(189054);
        this.mOpaque++;
        for (long j2 : jArr) {
            this.mCallBackMap.put(generateOpaqueKey(this.mOpaque, j2), tPVideoCaptureCallBack);
        }
        try {
            this.mTpImageGenerator.generateImagesAsyncForTimes(jArr, this.mOpaque, getParameters());
            AppMethodBeat.o(189054);
        } catch (Exception e2) {
            g.e(TAG, "generateImagesAsyncForTimes: " + Log.getStackTraceString(e2));
            AppMethodBeat.o(189054);
        }
    }

    public void release() {
        AppMethodBeat.i(189055);
        try {
            this.mTpImageGenerator.cancelAllImageGenerations();
            this.mTpImageGenerator.unInit();
        } catch (Exception e2) {
            g.e(TAG, "release: " + Log.getStackTraceString(e2));
        }
        this.mCallBackMap.clear();
        this.mTpImageGenerator = null;
        AppMethodBeat.o(189055);
    }

    private TPImageGeneratorParams getParameters() {
        AppMethodBeat.i(189056);
        TPImageGeneratorParams tPImageGeneratorParams = new TPImageGeneratorParams();
        tPImageGeneratorParams.format = 37;
        tPImageGeneratorParams.width = this.mWidth;
        tPImageGeneratorParams.height = this.mHeight;
        tPImageGeneratorParams.requestedTimeMsToleranceAfter = this.mRequestedTimeMsToleranceAfter;
        tPImageGeneratorParams.requestedTimeMsToleranceBefore = this.mRequestedTimeMsToleranceBefore;
        AppMethodBeat.o(189056);
        return tPImageGeneratorParams;
    }

    private String generateOpaqueKey(long j2, long j3) {
        AppMethodBeat.i(189057);
        String str = "opaque_" + j2 + "time_" + j3;
        AppMethodBeat.o(189057);
        return str;
    }

    @Override // com.tencent.thumbplayer.core.imagegenerator.ITPImageGeneratorCallback
    public void onImageGenerationCompleted(int i2, long j2, long j3, long j4, TPVideoFrame tPVideoFrame) {
        Bitmap[] bitmapArr;
        AppMethodBeat.i(189058);
        TPVideoCaptureCallBack tPVideoCaptureCallBack = this.mCallBackMap.get(generateOpaqueKey(j4, j2));
        if (tPVideoCaptureCallBack != null) {
            if (i2 != 0 || tPVideoFrame == null) {
                tPVideoCaptureCallBack.onCaptureError(i2);
            } else {
                if (tPVideoFrame.data.length <= 0 || tPVideoFrame.height == 0 || tPVideoFrame.width == 0) {
                    bitmapArr = null;
                } else {
                    Bitmap[] bitmapArr2 = new Bitmap[tPVideoFrame.data.length];
                    for (int i3 = 0; i3 < tPVideoFrame.data.length; i3++) {
                        bitmapArr2[i3] = a.k(tPVideoFrame.data[i3], tPVideoFrame.width, tPVideoFrame.height, tPVideoFrame.rotation);
                    }
                    bitmapArr = bitmapArr2;
                }
                tPVideoCaptureCallBack.onCaptureSuccess(bitmapArr);
            }
        }
        this.mCallBackMap.remove(generateOpaqueKey(j4, j2));
        AppMethodBeat.o(189058);
    }
}
