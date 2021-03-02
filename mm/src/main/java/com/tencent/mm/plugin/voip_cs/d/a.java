package com.tencent.mm.plugin.voip_cs.d;

import android.hardware.Camera;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip_cs.c.c;
import com.tencent.mm.plugin.voip_cs.c.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends com.tencent.mm.plugin.voip.video.camera.prev.a {
    public a() {
        super(640, 480);
    }

    public final void fMQ() {
        int i2;
        AppMethodBeat.i(125487);
        try {
            if (this.zNY != null) {
                Camera.Size previewSize = this.zNY.getPreviewSize();
                d fMt = c.fMt();
                if (this.zOb) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                this.zNY.getPreviewFrameRate();
                int i3 = this.zOk;
                int i4 = this.zOl;
                int i5 = previewSize.width;
                int i6 = previewSize.height;
                Log.d("MicroMsg.VoipCSReportHelper", "setCameraInfo");
                fMt.HqX = i2;
                fMt.HqT = i3;
                fMt.HqU = i4;
                fMt.HqV = i5;
                fMt.HqW = i6;
            }
            AppMethodBeat.o(125487);
        } catch (Exception e2) {
            Log.e("MicroMsg.CSCaptureRender", "getCameraDataForVoipCS failed" + e2.getMessage());
            AppMethodBeat.o(125487);
        }
    }
}
