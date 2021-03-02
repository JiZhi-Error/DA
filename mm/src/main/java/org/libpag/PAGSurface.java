package org.libpag;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.os.Build;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import org.extra.tools.b;
import org.libpag.reporter.AVReportCenter;

public class PAGSurface {
    long nativeSurface = 0;
    private Surface surface = null;
    private int textureID = 0;

    private static native long SetupFromSurfaceWithGLContext(Surface surface2, long j2);

    public static native long SetupFromTexture(int i2, int i3, int i4, boolean z);

    private native void nativeFinalize();

    private static native void nativeInit();

    private native void nativeRelease();

    public native boolean clearAll();

    public native void freeCache();

    public native int height();

    public native boolean present();

    public native void updateSize();

    public native int width();

    public static PAGSurface FromSurfaceTexture(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(236924);
        PAGSurface FromSurfaceTexture = FromSurfaceTexture(surfaceTexture, EGL14.EGL_NO_CONTEXT);
        AppMethodBeat.o(236924);
        return FromSurfaceTexture;
    }

    public static PAGSurface FromSurfaceTexture(SurfaceTexture surfaceTexture, EGLContext eGLContext) {
        AppMethodBeat.i(236925);
        if (surfaceTexture == null) {
            AppMethodBeat.o(236925);
            return null;
        }
        PAGSurface FromSurface = FromSurface(new Surface(surfaceTexture), eGLContext);
        AppMethodBeat.o(236925);
        return FromSurface;
    }

    public static PAGSurface FromSurface(Surface surface2) {
        AppMethodBeat.i(236926);
        PAGSurface FromSurface = FromSurface(surface2, EGL14.EGL_NO_CONTEXT);
        AppMethodBeat.o(236926);
        return FromSurface;
    }

    public static PAGSurface FromSurface(Surface surface2, EGLContext eGLContext) {
        long j2;
        AppMethodBeat.i(236927);
        if (surface2 == null) {
            AppMethodBeat.o(236927);
            return null;
        }
        if (eGLContext == null || eGLContext == EGL14.EGL_NO_CONTEXT) {
            j2 = 0;
        } else if (Build.VERSION.SDK_INT >= 21) {
            j2 = eGLContext.getNativeHandle();
        } else {
            j2 = (long) eGLContext.getHandle();
        }
        long SetupFromSurfaceWithGLContext = SetupFromSurfaceWithGLContext(surface2, j2);
        if (SetupFromSurfaceWithGLContext == 0) {
            AppMethodBeat.o(236927);
            return null;
        }
        PAGSurface pAGSurface = new PAGSurface(SetupFromSurfaceWithGLContext);
        pAGSurface.surface = surface2;
        AppMethodBeat.o(236927);
        return pAGSurface;
    }

    public static PAGSurface FromTexture(int i2, int i3, int i4) {
        AppMethodBeat.i(236928);
        PAGSurface FromTexture = FromTexture(i2, i3, i4, false);
        AppMethodBeat.o(236928);
        return FromTexture;
    }

    public static PAGSurface FromTexture(int i2, int i3, int i4, boolean z) {
        AppMethodBeat.i(236929);
        long SetupFromTexture = SetupFromTexture(i2, i3, i4, z);
        if (SetupFromTexture == 0) {
            AppMethodBeat.o(236929);
            return null;
        }
        PAGSurface pAGSurface = new PAGSurface(SetupFromTexture);
        pAGSurface.textureID = i2;
        AppMethodBeat.o(236929);
        return pAGSurface;
    }

    private PAGSurface(long j2) {
        this.nativeSurface = j2;
    }

    public void release() {
        AppMethodBeat.i(236930);
        nativeRelease();
        AppMethodBeat.o(236930);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(236931);
        nativeFinalize();
        AppMethodBeat.o(236931);
    }

    public static void OnReportData(HashMap<String, String> hashMap) {
        AppMethodBeat.i(236932);
        if (hashMap == null || hashMap.isEmpty()) {
            AppMethodBeat.o(236932);
            return;
        }
        AVReportCenter.getInstance().commit(hashMap);
        AppMethodBeat.o(236932);
    }

    static {
        AppMethodBeat.i(236933);
        b.loadLibrary("pag");
        nativeInit();
        if (b.getAppContext() != null) {
            AVReportCenter.getInstance().init(b.getAppContext());
        }
        AppMethodBeat.o(236933);
    }
}
