package com.tencent.mm.media.j.a;

import android.opengl.GLSurfaceView;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 02\u00020\u0001:\u00010B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u001a\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J-\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0&¢\u0006\u0002\u0010'J0\u0010(\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0003H\u0002J \u0010,\u001a\u00020-2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010)\u001a\u00020 H\u0002J-\u0010.\u001a\u00020-2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0&H\u0002¢\u0006\u0002\u0010/R\u000e\u0010\n\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fXD¢\u0006\u0004\n\u0002\b\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000¨\u00061"}, hxF = {"Lcom/tencent/mm/media/render/config/RenderConfigChooser;", "Landroid/opengl/GLSurfaceView$EGLConfigChooser;", "mRedSize", "", "mGreenSize", "mBlueSize", "mAlphaSize", "mDepthSize", "mStencilSize", "(IIIIII)V", "EGL_OPENGL_ES2_BIT", "TAG", "", "TAG$1", "getMAlphaSize", "()I", "setMAlphaSize", "(I)V", "getMBlueSize", "setMBlueSize", "getMDepthSize", "setMDepthSize", "getMGreenSize", "setMGreenSize", "getMRedSize", "setMRedSize", "getMStencilSize", "setMStencilSize", "mValue", "", "s_configAttribs2", "chooseConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "egl", "Ljavax/microedition/khronos/egl/EGL10;", ServerProtocol.DIALOG_PARAM_DISPLAY, "Ljavax/microedition/khronos/egl/EGLDisplay;", "configs", "", "(Ljavax/microedition/khronos/egl/EGL10;Ljavax/microedition/khronos/egl/EGLDisplay;[Ljavax/microedition/khronos/egl/EGLConfig;)Ljavax/microedition/khronos/egl/EGLConfig;", "findConfigAttrib", "config", "attribute", "defaultValue", "printConfig", "", "printConfigs", "(Ljavax/microedition/khronos/egl/EGL10;Ljavax/microedition/khronos/egl/EGLDisplay;[Ljavax/microedition/khronos/egl/EGLConfig;)V", "Companion", "plugin-mediaeditor_release"})
public final class a implements GLSurfaceView.EGLConfigChooser {
    private static final String TAG = TAG;
    public static final C0422a ijC = new C0422a((byte) 0);
    private final int EGL_OPENGL_ES2_BIT = 4;
    private final int[] gSm = new int[1];
    private int gSn = 5;
    private int gSo = 6;
    private int gSp = 5;
    private int gSq = 0;
    private int gSr = 0;
    private int gSs = 0;
    private final String gVB = "MicroMsg.RenderConfigChooser";
    private final int[] ijB = {12324, 4, 12323, 4, 12322, 4, 12352, this.EGL_OPENGL_ES2_BIT, 12344};

    public a() {
        AppMethodBeat.i(93849);
        AppMethodBeat.o(93849);
    }

    public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        AppMethodBeat.i(93845);
        p.h(egl10, "egl");
        p.h(eGLDisplay, ServerProtocol.DIALOG_PARAM_DISPLAY);
        int[] iArr = new int[1];
        egl10.eglChooseConfig(eGLDisplay, this.ijB, null, 0, iArr);
        int i2 = iArr[0];
        if (i2 <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No configs match configSpec");
            AppMethodBeat.o(93845);
            throw illegalArgumentException;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[i2];
        egl10.eglChooseConfig(eGLDisplay, this.ijB, eGLConfigArr, i2, iArr);
        c(egl10, eGLDisplay, eGLConfigArr);
        EGLConfig b2 = b(egl10, eGLDisplay, eGLConfigArr);
        AppMethodBeat.o(93845);
        return b2;
    }

    private EGLConfig b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
        AppMethodBeat.i(93846);
        p.h(egl10, "egl");
        p.h(eGLDisplay, ServerProtocol.DIALOG_PARAM_DISPLAY);
        p.h(eGLConfigArr, "configs");
        for (EGLConfig eGLConfig : eGLConfigArr) {
            if (eGLConfig == null) {
                p.hyc();
            }
            int a2 = a(egl10, eGLDisplay, eGLConfig, 12325);
            int a3 = a(egl10, eGLDisplay, eGLConfig, 12326);
            if (a2 >= this.gSr && a3 >= this.gSs) {
                int a4 = a(egl10, eGLDisplay, eGLConfig, 12324);
                int a5 = a(egl10, eGLDisplay, eGLConfig, 12323);
                int a6 = a(egl10, eGLDisplay, eGLConfig, 12322);
                int a7 = a(egl10, eGLDisplay, eGLConfig, 12321);
                if (a4 == this.gSn && a5 == this.gSo && a6 == this.gSp && a7 == this.gSq) {
                    AppMethodBeat.o(93846);
                    return eGLConfig;
                }
            }
        }
        AppMethodBeat.o(93846);
        return null;
    }

    private final int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2) {
        AppMethodBeat.i(93847);
        if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.gSm)) {
            int i3 = this.gSm[0];
            AppMethodBeat.o(93847);
            return i3;
        }
        AppMethodBeat.o(93847);
        return 0;
    }

    private final void c(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
        AppMethodBeat.i(93848);
        int length = eGLConfigArr.length;
        String str = this.gVB;
        ae aeVar = ae.SYK;
        String format = String.format("%d configurations", Arrays.copyOf(new Object[]{Integer.valueOf(length)}, 1));
        p.g(format, "java.lang.String.format(format, *args)");
        Log.i(str, format);
        for (int i2 = 0; i2 < length; i2++) {
            String str2 = this.gVB;
            ae aeVar2 = ae.SYK;
            String format2 = String.format("Configuration %d:\n", Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
            p.g(format2, "java.lang.String.format(format, *args)");
            Log.i(str2, format2);
            EGLConfig eGLConfig = eGLConfigArr[i2];
            if (eGLConfig == null) {
                p.hyc();
            }
            int[] iArr = {12320, 12321, 12322, 12323, 12324, 12325, 12326, 12327, 12328, 12329, 12330, 12331, 12332, 12333, 12334, 12335, 12336, 12337, 12338, 12339, 12340, 12343, 12342, 12341, 12345, 12346, 12347, 12348, 12349, 12350, 12351, 12352, 12354};
            String[] strArr = {"EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE", "EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE", "EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT", "EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT", "EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH", "EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID", "EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES", "EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE", "EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE", "EGL_TRANSPARENT_GREEN_VALUE", "EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB", "EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL", "EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE", "EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE", "EGL_RENDERABLE_TYPE", "EGL_CONFORMANT"};
            int[] iArr2 = new int[1];
            for (int i3 = 0; i3 < 33; i3++) {
                egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, iArr[i3], iArr2);
            }
        }
        AppMethodBeat.o(93848);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/media/render/config/RenderConfigChooser$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.j.a.a$a  reason: collision with other inner class name */
    public static final class C0422a {
        private C0422a() {
        }

        public /* synthetic */ C0422a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(93850);
        AppMethodBeat.o(93850);
    }
}
