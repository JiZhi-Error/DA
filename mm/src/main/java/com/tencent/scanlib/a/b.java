package com.tencent.scanlib.a;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.util.concurrent.Callable;

public final class b {

    public static abstract class a implements Callable<Void> {
    }

    /* renamed from: com.tencent.scanlib.a.b$b  reason: collision with other inner class name */
    public static abstract class AbstractCallableC2185b implements Callable<Void> {

        /* renamed from: com.tencent.scanlib.a.b$b$a */
        public interface a {
            void eRl();
        }
    }

    public static abstract class c implements Callable<Void> {

        public interface a {
            void eRl();
        }
    }

    public static abstract class d implements Callable<Void> {

        public interface a {
            void eRk();
        }
    }

    public static abstract class e implements Callable<Void> {
    }

    public static class g extends AbstractCallableC2185b {
        private f ROm;
        private int rotation;

        public g(f fVar, int i2) {
            this.ROm = fVar;
            this.rotation = i2;
        }

        @Override // java.util.concurrent.Callable
        private Void call() {
            AppMethodBeat.i(174584);
            try {
                if (!this.ROm.isOpen()) {
                    Log.i("CameraTask.DefaultOpenTask", "open camera");
                    this.ROm.aqD(this.rotation);
                    this.ROm.a(new Camera.PreviewCallback() {
                        /* class com.tencent.scanlib.a.b.g.AnonymousClass1 */

                        public final void onPreviewFrame(byte[] bArr, Camera camera) {
                        }
                    });
                }
            } catch (Exception e2) {
                Log.e("CameraTask.DefaultOpenTask", "open camera failed! %s", e2.getMessage());
            }
            AppMethodBeat.o(174584);
            return null;
        }
    }

    public static class f extends a {
        private f ROm;

        public f(f fVar) {
            this.ROm = fVar;
        }

        @Override // java.util.concurrent.Callable
        private Void call() {
            AppMethodBeat.i(174582);
            try {
                if (this.ROm.isOpen()) {
                    this.ROm.close();
                    Log.i("CameraTask.DefaultCloseTask", "close camera");
                }
            } catch (Exception e2) {
                Log.e("CameraTask.DefaultCloseTask", "close camera failed! %s", e2.getMessage());
            }
            AppMethodBeat.o(174582);
            return null;
        }
    }

    public static class i extends d {
        private f ROm;
        private SurfaceTexture surfaceTexture;

        public i(f fVar, SurfaceTexture surfaceTexture2) {
            this.ROm = fVar;
            this.surfaceTexture = surfaceTexture2;
        }

        @Override // java.util.concurrent.Callable
        private Void call() {
            AppMethodBeat.i(174588);
            try {
                if (this.ROm.isOpen() && !this.ROm.dEO()) {
                    Log.i("CameraTask.DefaultStartPreviewTask", "start preview");
                    this.ROm.r(this.surfaceTexture);
                }
            } catch (Exception e2) {
                Log.e("CameraTask.DefaultStartPreviewTask", "start preview failed! %s", e2.getMessage());
            }
            AppMethodBeat.o(174588);
            return null;
        }
    }

    public static class j extends e {
        private f ROm;

        public j(f fVar) {
            this.ROm = fVar;
        }

        @Override // java.util.concurrent.Callable
        private Void call() {
            AppMethodBeat.i(174590);
            try {
                if (this.ROm.dEO()) {
                    Log.i("CameraTask.DefaultStopPreviewTask", "stop preview");
                    this.ROm.stopPreview();
                }
            } catch (Exception e2) {
                Log.i("CameraTask.DefaultStopPreviewTask", "stop preview failed! %s", e2.getMessage());
            }
            AppMethodBeat.o(174590);
            return null;
        }
    }

    public static class h extends c {
        private f ROm;
        private int rotation;

        public h(f fVar, int i2) {
            this.ROm = fVar;
            this.rotation = i2;
        }

        @Override // java.util.concurrent.Callable
        private Void call() {
            AppMethodBeat.i(174586);
            try {
                Log.i("CameraTask.CameraReOpenTask", "reopen camera");
                this.ROm.close();
                this.ROm.aqD(this.rotation);
                this.ROm.a(new Camera.PreviewCallback() {
                    /* class com.tencent.scanlib.a.b.h.AnonymousClass1 */

                    public final void onPreviewFrame(byte[] bArr, Camera camera) {
                    }
                });
            } catch (Exception e2) {
                Log.e("CameraTask.CameraReOpenTask", "reopen camera failed! %s", e2.getMessage());
            }
            AppMethodBeat.o(174586);
            return null;
        }
    }
}
