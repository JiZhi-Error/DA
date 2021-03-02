package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0002 !B/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tB/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\n\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bB/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\rB/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u000e\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\u000fB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\f\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\u0010B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\u0011B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u000e\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\u0012B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\n\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\u0013J\u0006\u0010\u001a\u001a\u00020\u0015J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001J\u0006\u0010\u001c\u001a\u00020\u0019J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0015J(\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002R\u0016\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "", "surface", "Landroid/view/Surface;", "x", "", "y", "width", "height", "(Landroid/view/Surface;IIII)V", "Landroid/graphics/SurfaceTexture;", "(Landroid/graphics/SurfaceTexture;IIII)V", "Landroid/view/SurfaceHolder;", "(Landroid/view/SurfaceHolder;IIII)V", "Landroid/view/SurfaceView;", "(Landroid/view/SurfaceView;IIII)V", "(Landroid/view/SurfaceHolder;II)V", "(Landroid/view/Surface;II)V", "(Landroid/view/SurfaceView;II)V", "(Landroid/graphics/SurfaceTexture;II)V", "eglSurface", "Landroid/opengl/EGLSurface;", "kotlin.jvm.PlatformType", "type", "viewport", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface$Viewport;", "getEglSurface", "getSurface", "getViewport", "setEglSurface", "", "setViewport", "Companion", "Viewport", "plugin-voip_release"})
public final class f {
    public static final a Hnw = new a((byte) 0);
    Object Hnu;
    b Hnv;
    EGLSurface eglSurface;
    private int type;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface$Viewport;", "", "()V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "width", "getWidth", "setWidth", "x", "getX", "setX", "y", "getY", "setY", "plugin-voip_release"})
    public static final class b {
        int height;
        int width;
        int x;
        int y;
    }

    static {
        AppMethodBeat.i(236213);
        AppMethodBeat.o(236213);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface$Companion;", "", "()V", "TAG", "", "TYPE_PBUFFER_SURFACE", "", "TYPE_PIXMAP_SURFACE", "TYPE_WINDOW_SURFACE", "plugin-voip_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private f(Surface surface) {
        p.h(surface, "surface");
        AppMethodBeat.i(236209);
        this.eglSurface = EGL14.EGL_NO_SURFACE;
        this.Hnv = new b();
        jM(0, 0);
        this.Hnu = surface;
        this.type = 0;
        AppMethodBeat.o(236209);
    }

    private f(SurfaceTexture surfaceTexture) {
        p.h(surfaceTexture, "surface");
        AppMethodBeat.i(236210);
        this.eglSurface = EGL14.EGL_NO_SURFACE;
        this.Hnv = new b();
        jM(0, 0);
        this.Hnu = surfaceTexture;
        this.type = 0;
        AppMethodBeat.o(236210);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public f(Surface surface, byte b2) {
        this(surface);
        p.h(surface, "surface");
        AppMethodBeat.i(236211);
        AppMethodBeat.o(236211);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public f(SurfaceTexture surfaceTexture, byte b2) {
        this(surfaceTexture);
        p.h(surfaceTexture, "surface");
        AppMethodBeat.i(236212);
        AppMethodBeat.o(236212);
    }

    private final void jM(int i2, int i3) {
        this.Hnv.x = 0;
        this.Hnv.y = 0;
        this.Hnv.width = 0;
        this.Hnv.height = 0;
    }

    public final EGLSurface fLS() {
        AppMethodBeat.i(236208);
        EGLSurface eGLSurface = this.eglSurface;
        p.g(eGLSurface, "eglSurface");
        AppMethodBeat.o(236208);
        return eGLSurface;
    }
}
