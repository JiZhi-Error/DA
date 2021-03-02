package com.tencent.thumbplayer.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.a;
import com.tencent.thumbplayer.api.TPCaptureCallBack;
import com.tencent.thumbplayer.b.b;
import com.tencent.thumbplayer.core.imagegenerator.TPImageGeneratorParams;
import java.io.FileDescriptor;
import java.util.HashMap;
import java.util.Map;

public final class c implements a, b.a {
    private FileDescriptor RYF;
    private Map<Integer, TPCaptureCallBack> mCallBackMap = new HashMap();
    private String mUrl;

    public c(String str) {
        AppMethodBeat.i(189092);
        this.mUrl = str;
        AppMethodBeat.o(189092);
    }

    public c(FileDescriptor fileDescriptor) {
        AppMethodBeat.i(189093);
        this.RYF = fileDescriptor;
        AppMethodBeat.o(189093);
    }

    @Override // com.tencent.thumbplayer.a.a.a
    public final void a(long j2, TPImageGeneratorParams tPImageGeneratorParams, TPCaptureCallBack tPCaptureCallBack) {
        AppMethodBeat.i(189094);
        this.mCallBackMap.put(Integer.valueOf(b.hne().a(this.mUrl, this.RYF, j2, tPImageGeneratorParams.width, tPImageGeneratorParams.height, this)), tPCaptureCallBack);
        AppMethodBeat.o(189094);
    }

    @Override // com.tencent.thumbplayer.a.a.a
    public final void release() {
        AppMethodBeat.i(189095);
        this.mCallBackMap.clear();
        AppMethodBeat.o(189095);
    }

    @Override // com.tencent.thumbplayer.b.b.a
    public final void f(int i2, Bitmap bitmap) {
        AppMethodBeat.i(189096);
        TPCaptureCallBack tPCaptureCallBack = this.mCallBackMap.get(Integer.valueOf(i2));
        if (tPCaptureCallBack != null) {
            tPCaptureCallBack.onCaptureVideoSuccess(bitmap);
        }
        AppMethodBeat.o(189096);
    }

    @Override // com.tencent.thumbplayer.b.b.a
    public final void arl(int i2) {
        AppMethodBeat.i(189097);
        TPCaptureCallBack tPCaptureCallBack = this.mCallBackMap.get(Integer.valueOf(i2));
        if (tPCaptureCallBack != null) {
            tPCaptureCallBack.onCaptureVideoFailed(1000001);
        }
        AppMethodBeat.o(189097);
    }
}
