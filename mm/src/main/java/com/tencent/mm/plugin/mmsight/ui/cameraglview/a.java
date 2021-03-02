package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {
    public g iqW = new g() {
        /* class com.tencent.mm.plugin.mmsight.ui.cameraglview.a.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.mmsight.model.g
        public final boolean ai(byte[] bArr) {
            AppMethodBeat.i(94762);
            if (a.this.zEa != null) {
                MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = a.this.zEa;
                if (bArr == null || mMSightCameraGLSurfaceView.zEc == null || mMSightCameraGLSurfaceView.zEc.kxV) {
                    Log.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
                } else {
                    mMSightCameraGLSurfaceView.zEc.b(bArr, mMSightCameraGLSurfaceView.kxW, mMSightCameraGLSurfaceView.kxX, mMSightCameraGLSurfaceView.iqx, false);
                    mMSightCameraGLSurfaceView.requestRender();
                }
            }
            AppMethodBeat.o(94762);
            return false;
        }
    };
    MMSightCameraGLSurfaceView zEa;

    public final void a(byte[] bArr, boolean z, int i2) {
        AppMethodBeat.i(94763);
        if (this.zEa != null) {
            this.zEa.e(bArr, i2, z);
        }
        AppMethodBeat.o(94763);
    }

    public a(MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView) {
        AppMethodBeat.i(94764);
        this.zEa = mMSightCameraGLSurfaceView;
        AppMethodBeat.o(94764);
    }

    public final void aq(int i2, int i3, int i4) {
        AppMethodBeat.i(94765);
        Log.d("MicroMsg.MMSightCameraDrawController", "cameraPreviewWidth: " + i2 + " cameraPreviewHeight : " + i3 + " rotate : " + i4);
        if (this.zEa != null) {
            int i5 = (i4 == 0 || i4 == 180) ? i2 : i3;
            if (i4 == 0 || i4 == 180) {
                i2 = i3;
            }
            this.zEa.aq(i5, i2, i4);
        }
        AppMethodBeat.o(94765);
    }

    public final void aEy() {
        AppMethodBeat.i(94766);
        if (this.zEa != null) {
            this.zEa.aEy();
        }
        AppMethodBeat.o(94766);
    }
}
