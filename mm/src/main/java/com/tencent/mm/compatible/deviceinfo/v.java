package com.tencent.mm.compatible.deviceinfo;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.concurrent.atomic.AtomicInteger;

public final class v {
    private static final AtomicInteger gIG = new AtomicInteger(0);
    private static final AtomicInteger gIH = new AtomicInteger(0);
    public Camera gII;
    public volatile boolean gIJ = false;

    static {
        AppMethodBeat.i(155758);
        AppMethodBeat.o(155758);
    }

    public v(Camera camera) {
        AppMethodBeat.i(155744);
        this.gII = camera;
        if (camera != null) {
            gIG.incrementAndGet();
            Log.printInfoStack("MicroMsg.MCamera", "init MCamera, initCount:%s, releaseCount:%s, isCameraRelease:%s", gIG, gIH, Boolean.valueOf(this.gIJ));
            if (gIG.get() - gIH.get() > 1) {
                Log.i("MicroMsg.MCamera", "MCamera leak, do report, current process:%s", MMApplicationContext.getProcessName());
                a aVar = a.INSTANCE;
                a.v(650, 61);
                if (MMApplicationContext.isMMProcess()) {
                    a aVar2 = a.INSTANCE;
                    a.v(650, 62);
                } else if (MMApplicationContext.isToolsProcess()) {
                    a aVar3 = a.INSTANCE;
                    a.v(650, 63);
                } else if (MMApplicationContext.isAppBrandProcess()) {
                    a aVar4 = a.INSTANCE;
                    a.v(650, 64);
                }
                gIG.set(0);
                gIH.set(0);
            }
            this.gIJ = false;
            AppMethodBeat.o(155744);
            return;
        }
        Log.printInfoStack("MicroMsg.MCamera", "init MCamera with null camera!!!", new Object[0]);
        AppMethodBeat.o(155744);
    }

    public final Camera.Parameters getParameters() {
        AppMethodBeat.i(155745);
        if (this.gII != null) {
            Camera.Parameters parameters = this.gII.getParameters();
            AppMethodBeat.o(155745);
            return parameters;
        }
        AppMethodBeat.o(155745);
        return null;
    }

    public final void setParameters(Camera.Parameters parameters) {
        AppMethodBeat.i(155746);
        if (this.gII != null) {
            this.gII.setParameters(parameters);
        }
        AppMethodBeat.o(155746);
    }

    public final void setPreviewDisplay(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(155747);
        if (this.gII != null) {
            this.gII.setPreviewDisplay(surfaceHolder);
        }
        AppMethodBeat.o(155747);
    }

    public final void setPreviewTexture(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(155748);
        if (this.gII != null) {
            this.gII.setPreviewTexture(surfaceTexture);
        }
        AppMethodBeat.o(155748);
    }

    public final void startPreview() {
        AppMethodBeat.i(155749);
        if (this.gII != null) {
            this.gII.startPreview();
        }
        AppMethodBeat.o(155749);
    }

    public final void setDisplayOrientation(int i2) {
        AppMethodBeat.i(155750);
        if (this.gII != null) {
            this.gII.setDisplayOrientation(i2);
        }
        AppMethodBeat.o(155750);
    }

    public final void stopPreview() {
        AppMethodBeat.i(155751);
        if (this.gII != null) {
            this.gII.stopPreview();
        }
        AppMethodBeat.o(155751);
    }

    public final void autoFocus(final Camera.AutoFocusCallback autoFocusCallback) {
        AppMethodBeat.i(155752);
        if (this.gII != null) {
            this.gII.autoFocus(new Camera.AutoFocusCallback() {
                /* class com.tencent.mm.compatible.deviceinfo.v.AnonymousClass1 */

                public final void onAutoFocus(boolean z, Camera camera) {
                    AppMethodBeat.i(160384);
                    if (!v.this.gIJ) {
                        autoFocusCallback.onAutoFocus(z, camera);
                    }
                    AppMethodBeat.o(160384);
                }
            });
        }
        AppMethodBeat.o(155752);
    }

    public final void cancelAutoFocus() {
        AppMethodBeat.i(155753);
        if (this.gII != null) {
            this.gII.cancelAutoFocus();
        }
        AppMethodBeat.o(155753);
    }

    public final void release() {
        AppMethodBeat.i(155754);
        if (this.gII != null) {
            try {
                this.gIJ = true;
                this.gII.release();
                gIH.incrementAndGet();
                Log.printInfoStack("MicroMsg.MCamera", "release MCamera, initCount: %s, releaseCount: %s,isCameraRelease %s", gIG, gIH, Boolean.valueOf(this.gIJ));
                AppMethodBeat.o(155754);
            } catch (Exception e2) {
                Log.i("MicroMsg.MCamera", "release camera failed cause sometimes native crash while", e2.fillInStackTrace());
                gIH.incrementAndGet();
                Log.printInfoStack("MicroMsg.MCamera", "release MCamera, initCount: %s, releaseCount: %s,isCameraRelease %s", gIG, gIH, Boolean.valueOf(this.gIJ));
                AppMethodBeat.o(155754);
            } catch (Throwable th) {
                gIH.incrementAndGet();
                Log.printInfoStack("MicroMsg.MCamera", "release MCamera, initCount: %s, releaseCount: %s,isCameraRelease %s", gIG, gIH, Boolean.valueOf(this.gIJ));
                AppMethodBeat.o(155754);
                throw th;
            }
        } else {
            AppMethodBeat.o(155754);
        }
    }

    public final void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        AppMethodBeat.i(155755);
        if (this.gII != null) {
            this.gII.setPreviewCallback(previewCallback);
        }
        AppMethodBeat.o(155755);
    }

    public final void setPreviewCallbackWithBuffer(Camera.PreviewCallback previewCallback) {
        AppMethodBeat.i(155756);
        if (this.gII != null) {
            this.gII.setPreviewCallbackWithBuffer(previewCallback);
        }
        AppMethodBeat.o(155756);
    }

    public final void addCallbackBuffer(byte[] bArr) {
        AppMethodBeat.i(155757);
        if (this.gII != null) {
            this.gII.addCallbackBuffer(bArr);
        }
        AppMethodBeat.o(155757);
    }
}
