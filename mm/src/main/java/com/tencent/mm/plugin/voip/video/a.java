package com.tencent.mm.plugin.voip.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.GLTextureView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

/* access modifiers changed from: package-private */
public final class a implements GLTextureView.e {
    private static int EGL_OPENGL_ES2_BIT = 4;
    private static int[] ijB = {12324, 4, 12323, 4, 12322, 4, 12352, EGL_OPENGL_ES2_BIT, 12344};
    private int[] gSm = new int[1];
    protected int gSn = 5;
    protected int gSo = 6;
    protected int gSp = 5;
    protected int gSq = 0;
    protected int gSr = 0;
    protected int gSs = 0;

    public a() {
        AppMethodBeat.i(115569);
        AppMethodBeat.o(115569);
    }

    @Override // com.tencent.mm.plugin.voip.video.GLTextureView.e
    public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
        AppMethodBeat.i(115570);
        int[] iArr = new int[1];
        egl10.eglChooseConfig(eGLDisplay, ijB, null, 0, iArr);
        int i2 = iArr[0];
        if (i2 <= 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No configs match configSpec");
            AppMethodBeat.o(115570);
            throw illegalArgumentException;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[i2];
        egl10.eglChooseConfig(eGLDisplay, ijB, eGLConfigArr, i2, iArr);
        EGLConfig b2 = b(egl10, eGLDisplay, eGLConfigArr);
        AppMethodBeat.o(115570);
        return b2;
    }

    private EGLConfig b(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
        AppMethodBeat.i(115571);
        for (EGLConfig eGLConfig : eGLConfigArr) {
            int a2 = a(egl10, eGLDisplay, eGLConfig, 12325);
            int a3 = a(egl10, eGLDisplay, eGLConfig, 12326);
            if (a2 >= this.gSr && a3 >= this.gSs) {
                int a4 = a(egl10, eGLDisplay, eGLConfig, 12324);
                int a5 = a(egl10, eGLDisplay, eGLConfig, 12323);
                int a6 = a(egl10, eGLDisplay, eGLConfig, 12322);
                int a7 = a(egl10, eGLDisplay, eGLConfig, 12321);
                if (a4 == this.gSn && a5 == this.gSo && a6 == this.gSp && a7 == this.gSq) {
                    AppMethodBeat.o(115571);
                    return eGLConfig;
                }
            }
        }
        AppMethodBeat.o(115571);
        return null;
    }

    private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2) {
        AppMethodBeat.i(115572);
        if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.gSm)) {
            int i3 = this.gSm[0];
            AppMethodBeat.o(115572);
            return i3;
        }
        AppMethodBeat.o(115572);
        return 0;
    }
}
