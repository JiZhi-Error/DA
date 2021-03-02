package com.tencent.thumbplayer.b;

import android.graphics.Bitmap;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.a;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.core.common.TPVideoFrame;
import com.tencent.thumbplayer.core.imagegenerator.ITPImageGeneratorCallback;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGenerator;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.utils.g;
import java.util.HashMap;
import java.util.Map;

public final class d implements a, ITPImageGeneratorCallback {
    private TPImageGenerator RYG;
    private Map<Long, TPCaptureCallBack> mCallBackMap;
    private long mOpaque = 0;

    public d(String str) {
        AppMethodBeat.i(189098);
        this.RYG = new TPImageGenerator(str, this);
        this.mCallBackMap = new HashMap();
        try {
            this.RYG.init();
            AppMethodBeat.o(189098);
        } catch (Exception e2) {
            g.e("TPThumbPlayer[TPThumbCapture.java]", "init: " + Log.getStackTraceString(e2));
            AppMethodBeat.o(189098);
        }
    }

    public d(int i2) {
        AppMethodBeat.i(189099);
        this.RYG = new TPImageGenerator(i2, this);
        this.mCallBackMap = new HashMap();
        try {
            this.RYG.init();
            AppMethodBeat.o(189099);
        } catch (Exception e2) {
            g.e("TPThumbPlayer[TPThumbCapture.java]", "init: " + Log.getStackTraceString(e2));
            AppMethodBeat.o(189099);
        }
    }

    @Override // com.tencent.thumbplayer.a.a.a
    public final void a(long j2, TPImageGeneratorParams tPImageGeneratorParams, TPCaptureCallBack tPCaptureCallBack) {
        AppMethodBeat.i(189100);
        this.mOpaque++;
        this.mCallBackMap.put(Long.valueOf(this.mOpaque), tPCaptureCallBack);
        try {
            this.RYG.generateImageAsyncAtTime(j2, this.mOpaque, tPImageGeneratorParams);
            AppMethodBeat.o(189100);
        } catch (Exception e2) {
            g.e("TPThumbPlayer[TPThumbCapture.java]", "generateImageAsyncAtTime: " + Log.getStackTraceString(e2));
            AppMethodBeat.o(189100);
        }
    }

    @Override // com.tencent.thumbplayer.a.a.a
    public final void release() {
        AppMethodBeat.i(189101);
        try {
            this.RYG.cancelAllImageGenerations();
            this.RYG.unInit();
        } catch (Exception e2) {
            g.e("TPThumbPlayer[TPThumbCapture.java]", "release: " + Log.getStackTraceString(e2));
        }
        this.mCallBackMap.clear();
        this.RYG = null;
        AppMethodBeat.o(189101);
    }

    @Override // com.tencent.thumbplayer.core.imagegenerator.ITPImageGeneratorCallback
    public final void onImageGenerationCompleted(int i2, long j2, long j3, long j4, TPVideoFrame tPVideoFrame) {
        Bitmap bitmap;
        AppMethodBeat.i(189102);
        TPCaptureCallBack tPCaptureCallBack = this.mCallBackMap.get(Long.valueOf(j4));
        if (tPCaptureCallBack != null) {
            if (i2 != 0 || tPVideoFrame == null) {
                tPCaptureCallBack.onCaptureVideoFailed(i2);
            } else {
                if (tPVideoFrame.data.length <= 0 || tPVideoFrame.height == 0 || tPVideoFrame.width == 0) {
                    bitmap = null;
                } else {
                    bitmap = a.k(tPVideoFrame.data[0], tPVideoFrame.width, tPVideoFrame.height, tPVideoFrame.rotation);
                }
                if (bitmap != null) {
                    tPCaptureCallBack.onCaptureVideoSuccess(bitmap);
                } else {
                    tPCaptureCallBack.onCaptureVideoFailed(1000001);
                }
            }
        }
        this.mCallBackMap.remove(Long.valueOf(j4));
        AppMethodBeat.o(189102);
    }
}
