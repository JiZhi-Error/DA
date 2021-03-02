package io.flutter.embedding.engine.b;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.c;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;

@TargetApi(16)
public final class a implements c {
    private final b SMD = new b() {
        /* class io.flutter.embedding.engine.b.a.AnonymousClass1 */

        @Override // io.flutter.embedding.engine.b.b
        public final void dLt() {
            a.this.SPD = true;
        }

        @Override // io.flutter.embedding.engine.b.b
        public final void dLu() {
            a.this.SPD = false;
        }
    };
    public final FlutterJNI SNV;
    private b SNt;
    private final AtomicLong SPC = new AtomicLong(0);
    public boolean SPD = false;
    private Surface surface;

    public static final class b {
        public float SPH = 1.0f;
        public int SPI = 0;
        public int SPJ = 0;
        public int SPK = 0;
        public int SPL = 0;
        public int SPM = 0;
        public int SPN = 0;
        public int SPO = 0;
        public int SPP = 0;
        public int height = 0;
        public int paddingBottom = 0;
        public int paddingLeft = 0;
        public int paddingRight = 0;
        public int paddingTop = 0;
        public int width = 0;
    }

    public a(FlutterJNI flutterJNI) {
        AppMethodBeat.i(10185);
        this.SNV = flutterJNI;
        this.SNV.addIsDisplayingFlutterUiListener(this.SMD);
        AppMethodBeat.o(10185);
    }

    public final void addIsDisplayingFlutterUiListener(b bVar) {
        AppMethodBeat.i(214977);
        this.SNV.addIsDisplayingFlutterUiListener(bVar);
        if (this.SPD) {
            bVar.dLt();
        }
        AppMethodBeat.o(214977);
    }

    public final void removeIsDisplayingFlutterUiListener(b bVar) {
        AppMethodBeat.i(214978);
        this.SNV.removeIsDisplayingFlutterUiListener(bVar);
        AppMethodBeat.o(214978);
    }

    @Override // io.flutter.view.c
    public final c.a hwY() {
        AppMethodBeat.i(10190);
        io.flutter.a.hwd();
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.detachFromGLContext();
        C2245a aVar = new C2245a(this.SPC.getAndIncrement(), surfaceTexture);
        new StringBuilder("New SurfaceTexture ID: ").append(aVar.id);
        io.flutter.a.hwd();
        this.SNV.registerTexture(aVar.id, surfaceTexture);
        AppMethodBeat.o(10190);
        return aVar;
    }

    /* renamed from: io.flutter.embedding.engine.b.a$a  reason: collision with other inner class name */
    final class C2245a implements c.a {
        private SurfaceTexture.OnFrameAvailableListener SPF = new SurfaceTexture.OnFrameAvailableListener() {
            /* class io.flutter.embedding.engine.b.a.C2245a.AnonymousClass1 */

            public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(10197);
                if (C2245a.this.released) {
                    AppMethodBeat.o(10197);
                    return;
                }
                a aVar = a.this;
                aVar.SNV.markTextureFrameAvailable(C2245a.this.id);
                AppMethodBeat.o(10197);
            }
        };
        final long id;
        boolean released;
        private final SurfaceTexture surfaceTexture;

        C2245a(long j2, SurfaceTexture surfaceTexture2) {
            AppMethodBeat.i(10195);
            this.id = j2;
            this.surfaceTexture = surfaceTexture2;
            if (Build.VERSION.SDK_INT >= 21) {
                this.surfaceTexture.setOnFrameAvailableListener(this.SPF, new Handler());
                AppMethodBeat.o(10195);
                return;
            }
            this.surfaceTexture.setOnFrameAvailableListener(this.SPF);
            AppMethodBeat.o(10195);
        }

        @Override // io.flutter.view.c.a
        public final SurfaceTexture surfaceTexture() {
            return this.surfaceTexture;
        }

        @Override // io.flutter.view.c.a
        public final long hxb() {
            return this.id;
        }

        @Override // io.flutter.view.c.a
        public final void release() {
            AppMethodBeat.i(10196);
            if (this.released) {
                AppMethodBeat.o(10196);
                return;
            }
            new StringBuilder("Releasing a SurfaceTexture (").append(this.id).append(").");
            io.flutter.a.hwd();
            this.surfaceTexture.release();
            a aVar = a.this;
            aVar.SNV.unregisterTexture(this.id);
            this.released = true;
            AppMethodBeat.o(10196);
        }
    }

    public final void o(Surface surface2) {
        AppMethodBeat.i(214979);
        if (this.surface != null) {
            hwZ();
        }
        this.surface = surface2;
        this.SNV.onSurfaceCreated(surface2);
        AppMethodBeat.o(214979);
    }

    public final void p(Surface surface2) {
        AppMethodBeat.i(214980);
        this.surface = surface2;
        this.SNV.onSurfaceWindowChanged(surface2);
        AppMethodBeat.o(214980);
    }

    public final void surfaceChanged(int i2, int i3) {
        AppMethodBeat.i(10192);
        this.SNV.onSurfaceChanged(i2, i3);
        AppMethodBeat.o(10192);
    }

    public final void hwZ() {
        AppMethodBeat.i(214981);
        this.SNV.onSurfaceDestroyed();
        this.surface = null;
        if (this.SPD) {
            this.SMD.dLu();
        }
        this.SPD = false;
        AppMethodBeat.o(214981);
    }

    public final void a(b bVar) {
        AppMethodBeat.i(10193);
        new StringBuilder("Setting viewport metrics\nSize: ").append(bVar.width).append(" x ").append(bVar.height).append("\nPadding - L: ").append(bVar.paddingLeft).append(", T: ").append(bVar.paddingTop).append(", R: ").append(bVar.paddingRight).append(", B: ").append(bVar.paddingBottom).append("\nInsets - L: ").append(bVar.SPL).append(", T: ").append(bVar.SPI).append(", R: ").append(bVar.SPJ).append(", B: ").append(bVar.SPK).append("\nSystem Gesture Insets - L: ").append(bVar.SPP).append(", T: ").append(bVar.SPM).append(", R: ").append(bVar.SPN).append(", B: ").append(bVar.SPK);
        io.flutter.a.hwd();
        this.SNt = bVar;
        this.SNV.setViewportMetrics(bVar.SPH, bVar.width, bVar.height, bVar.paddingTop, bVar.paddingRight, bVar.paddingBottom, bVar.paddingLeft, bVar.SPI, bVar.SPJ, bVar.SPK, bVar.SPL, bVar.SPM, bVar.SPN, bVar.SPO, bVar.SPP);
        AppMethodBeat.o(10193);
    }

    public final void dispatchPointerDataPacket(ByteBuffer byteBuffer, int i2) {
        AppMethodBeat.i(10194);
        this.SNV.dispatchPointerDataPacket(byteBuffer, i2);
        AppMethodBeat.o(10194);
    }

    public final void hxa() {
        AppMethodBeat.i(214982);
        this.SNV.setSemanticsEnabled(false);
        AppMethodBeat.o(214982);
    }
}
