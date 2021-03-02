package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.b.a;
import io.flutter.embedding.engine.b.c;

public class FlutterTextureView extends TextureView implements c {
    private Surface AsF;
    private a SMT;
    private boolean SMW;
    private boolean SNd;
    private final TextureView.SurfaceTextureListener SNg;

    static /* synthetic */ void b(FlutterTextureView flutterTextureView) {
        AppMethodBeat.i(9976);
        flutterTextureView.hww();
        AppMethodBeat.o(9976);
    }

    static /* synthetic */ void c(FlutterTextureView flutterTextureView) {
        AppMethodBeat.i(9978);
        flutterTextureView.hwx();
        AppMethodBeat.o(9978);
    }

    public FlutterTextureView(Context context) {
        this(context, null);
    }

    public FlutterTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(9970);
        this.SNd = false;
        this.SMW = false;
        this.SNg = new TextureView.SurfaceTextureListener() {
            /* class io.flutter.embedding.android.FlutterTextureView.AnonymousClass1 */

            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
                AppMethodBeat.i(10019);
                io.flutter.a.hwd();
                FlutterTextureView.this.SNd = true;
                if (FlutterTextureView.this.SMW) {
                    FlutterTextureView.b(FlutterTextureView.this);
                }
                AppMethodBeat.o(10019);
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
                AppMethodBeat.i(10020);
                io.flutter.a.hwd();
                if (FlutterTextureView.this.SMW) {
                    FlutterTextureView.a(FlutterTextureView.this, i2, i3);
                }
                AppMethodBeat.o(10020);
            }

            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(10021);
                io.flutter.a.hwd();
                FlutterTextureView.this.SNd = false;
                if (FlutterTextureView.this.SMW) {
                    FlutterTextureView.c(FlutterTextureView.this);
                }
                AppMethodBeat.o(10021);
                return true;
            }
        };
        setSurfaceTextureListener(this.SNg);
        AppMethodBeat.o(9970);
    }

    @Override // io.flutter.embedding.engine.b.c
    public a getAttachedRenderer() {
        return this.SMT;
    }

    @Override // io.flutter.embedding.engine.b.c
    public final void a(a aVar) {
        AppMethodBeat.i(9971);
        io.flutter.a.hwd();
        if (this.SMT != null) {
            io.flutter.a.hwd();
            this.SMT.hwZ();
        }
        this.SMT = aVar;
        this.SMW = true;
        if (this.SNd) {
            io.flutter.a.hwd();
            hww();
        }
        AppMethodBeat.o(9971);
    }

    @Override // io.flutter.embedding.engine.b.c
    public final void hwu() {
        AppMethodBeat.i(9972);
        if (this.SMT != null) {
            if (getWindowToken() != null) {
                io.flutter.a.hwd();
                hwx();
            }
            this.SMT = null;
            this.SMW = false;
            AppMethodBeat.o(9972);
            return;
        }
        io.flutter.a.hwf();
        AppMethodBeat.o(9972);
    }

    @Override // io.flutter.embedding.engine.b.c
    public final void pause() {
        AppMethodBeat.i(215066);
        if (this.SMT != null) {
            this.SMT = null;
            this.SMW = false;
            AppMethodBeat.o(215066);
            return;
        }
        io.flutter.a.hwf();
        AppMethodBeat.o(215066);
    }

    private void hww() {
        AppMethodBeat.i(9973);
        if (this.SMT == null || getSurfaceTexture() == null) {
            IllegalStateException illegalStateException = new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
            AppMethodBeat.o(9973);
            throw illegalStateException;
        }
        this.AsF = new Surface(getSurfaceTexture());
        this.SMT.o(this.AsF);
        AppMethodBeat.o(9973);
    }

    private void hwx() {
        AppMethodBeat.i(9974);
        if (this.SMT == null) {
            IllegalStateException illegalStateException = new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
            AppMethodBeat.o(9974);
            throw illegalStateException;
        }
        this.SMT.hwZ();
        this.AsF.release();
        this.AsF = null;
        AppMethodBeat.o(9974);
    }

    static /* synthetic */ void a(FlutterTextureView flutterTextureView, int i2, int i3) {
        AppMethodBeat.i(9977);
        if (flutterTextureView.SMT == null) {
            IllegalStateException illegalStateException = new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
            AppMethodBeat.o(9977);
            throw illegalStateException;
        }
        new StringBuilder("Notifying FlutterRenderer that Android surface size has changed to ").append(i2).append(" x ").append(i3);
        io.flutter.a.hwd();
        flutterTextureView.SMT.surfaceChanged(i2, i3);
        AppMethodBeat.o(9977);
    }
}
