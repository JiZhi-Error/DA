package io.flutter.embedding.android;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.b.a;
import io.flutter.embedding.engine.b.b;
import io.flutter.embedding.engine.b.c;

public class FlutterSurfaceView extends SurfaceView implements c {
    private final b SMD;
    private a SMT;
    private boolean SMW;
    private final boolean SNc;
    private boolean SNd;
    private final SurfaceHolder.Callback SNe;

    static /* synthetic */ void b(FlutterSurfaceView flutterSurfaceView) {
        AppMethodBeat.i(10016);
        flutterSurfaceView.hww();
        AppMethodBeat.o(10016);
    }

    static /* synthetic */ void c(FlutterSurfaceView flutterSurfaceView) {
        AppMethodBeat.i(10018);
        flutterSurfaceView.hwx();
        AppMethodBeat.o(10018);
    }

    public FlutterSurfaceView(Context context) {
        this(context, null, false);
    }

    public FlutterSurfaceView(Context context, boolean z) {
        this(context, null, z);
    }

    public FlutterSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, false);
    }

    private FlutterSurfaceView(Context context, AttributeSet attributeSet, boolean z) {
        super(context, attributeSet);
        AppMethodBeat.i(10010);
        this.SNd = false;
        this.SMW = false;
        this.SNe = new SurfaceHolder.Callback() {
            /* class io.flutter.embedding.android.FlutterSurfaceView.AnonymousClass1 */

            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                AppMethodBeat.i(9967);
                io.flutter.a.hwd();
                FlutterSurfaceView.this.SNd = true;
                if (FlutterSurfaceView.this.SMW) {
                    FlutterSurfaceView.b(FlutterSurfaceView.this);
                }
                AppMethodBeat.o(9967);
            }

            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
                AppMethodBeat.i(9968);
                io.flutter.a.hwd();
                if (FlutterSurfaceView.this.SMW) {
                    FlutterSurfaceView.a(FlutterSurfaceView.this, i3, i4);
                }
                AppMethodBeat.o(9968);
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                AppMethodBeat.i(9969);
                io.flutter.a.hwd();
                FlutterSurfaceView.this.SNd = false;
                if (FlutterSurfaceView.this.SMW) {
                    FlutterSurfaceView.c(FlutterSurfaceView.this);
                }
                AppMethodBeat.o(9969);
            }
        };
        this.SMD = new b() {
            /* class io.flutter.embedding.android.FlutterSurfaceView.AnonymousClass2 */

            @Override // io.flutter.embedding.engine.b.b
            public final void dLt() {
                AppMethodBeat.i(215048);
                io.flutter.a.hwd();
                FlutterSurfaceView.this.setAlpha(1.0f);
                if (FlutterSurfaceView.this.SMT != null) {
                    FlutterSurfaceView.this.SMT.removeIsDisplayingFlutterUiListener(this);
                }
                AppMethodBeat.o(215048);
            }

            @Override // io.flutter.embedding.engine.b.b
            public final void dLu() {
            }
        };
        this.SNc = z;
        if (this.SNc) {
            getHolder().setFormat(-2);
            setZOrderOnTop(true);
        }
        getHolder().addCallback(this.SNe);
        setAlpha(0.0f);
        AppMethodBeat.o(10010);
    }

    @Override // io.flutter.embedding.engine.b.c
    public a getAttachedRenderer() {
        return this.SMT;
    }

    @Override // io.flutter.embedding.engine.b.c
    public final void a(a aVar) {
        AppMethodBeat.i(CdnLogic.kMediaTypeBeatificFile);
        io.flutter.a.hwd();
        if (this.SMT != null) {
            io.flutter.a.hwd();
            this.SMT.hwZ();
            this.SMT.removeIsDisplayingFlutterUiListener(this.SMD);
        }
        this.SMT = aVar;
        this.SMW = true;
        this.SMT.addIsDisplayingFlutterUiListener(this.SMD);
        if (this.SNd) {
            io.flutter.a.hwd();
            hww();
        }
        AppMethodBeat.o(CdnLogic.kMediaTypeBeatificFile);
    }

    @Override // io.flutter.embedding.engine.b.c
    public final void hwu() {
        AppMethodBeat.i(10012);
        if (this.SMT != null) {
            if (getWindowToken() != null) {
                io.flutter.a.hwd();
                hwx();
            }
            setAlpha(0.0f);
            this.SMT.removeIsDisplayingFlutterUiListener(this.SMD);
            this.SMT = null;
            this.SMW = false;
            AppMethodBeat.o(10012);
            return;
        }
        io.flutter.a.hwf();
        AppMethodBeat.o(10012);
    }

    @Override // io.flutter.embedding.engine.b.c
    public final void pause() {
        AppMethodBeat.i(215099);
        if (this.SMT != null) {
            this.SMT = null;
            this.SMW = false;
            AppMethodBeat.o(215099);
            return;
        }
        io.flutter.a.hwf();
        AppMethodBeat.o(215099);
    }

    private void hww() {
        AppMethodBeat.i(10013);
        if (this.SMT == null || getHolder() == null) {
            IllegalStateException illegalStateException = new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
            AppMethodBeat.o(10013);
            throw illegalStateException;
        }
        this.SMT.o(getHolder().getSurface());
        AppMethodBeat.o(10013);
    }

    private void hwx() {
        AppMethodBeat.i(10014);
        if (this.SMT == null) {
            IllegalStateException illegalStateException = new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
            AppMethodBeat.o(10014);
            throw illegalStateException;
        }
        this.SMT.hwZ();
        AppMethodBeat.o(10014);
    }

    static /* synthetic */ void a(FlutterSurfaceView flutterSurfaceView, int i2, int i3) {
        AppMethodBeat.i(10017);
        if (flutterSurfaceView.SMT == null) {
            IllegalStateException illegalStateException = new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
            AppMethodBeat.o(10017);
            throw illegalStateException;
        }
        new StringBuilder("Notifying FlutterRenderer that Android surface size has changed to ").append(i2).append(" x ").append(i3);
        io.flutter.a.hwd();
        flutterSurfaceView.SMT.surfaceChanged(i2, i3);
        AppMethodBeat.o(10017);
    }
}
