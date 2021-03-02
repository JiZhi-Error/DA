package com.tencent.mm.gpu.service;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openglapihook.FuncSeeker;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mmkv.MMKV;

public class GpuHookServiceImpl extends GpuHookService {
    private EGLConfig hiT;
    private EGLContext hiU;
    private EGLSurface hiV;
    private EGLDisplay mEGLDisplay;

    @Override // com.tencent.mm.gpu.service.GpuHookService
    public final void axt() {
        AppMethodBeat.i(186207);
        if (!((b) g.af(b.class)).a(b.a.clicfg_gpu_opengl_api_hook_laboratory, true)) {
            AppMethodBeat.o(186207);
            return;
        }
        MMKV.initialize(MMApplicationContext.getContext());
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("mmkv_gpu_service_key_muti");
        mmkv.putBoolean("key_has_function_seek_start", true);
        this.mEGLDisplay = EGL14.eglGetDisplay(0);
        if (this.mEGLDisplay != EGL14.EGL_NO_DISPLAY) {
            int[] iArr = new int[2];
            if (EGL14.eglInitialize(this.mEGLDisplay, iArr, 0, iArr, 1)) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (EGL14.eglChooseConfig(this.mEGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                    this.hiT = eGLConfigArr[0];
                    this.hiU = EGL14.eglCreateContext(this.mEGLDisplay, this.hiT, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                    if (this.hiU != EGL14.EGL_NO_CONTEXT) {
                        this.hiV = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, this.hiT, new int[]{12375, 64, 12374, 64, 12344}, 0);
                        if (this.hiV != EGL14.EGL_NO_SURFACE && EGL14.eglMakeCurrent(this.mEGLDisplay, this.hiV, this.hiV, this.hiU)) {
                            GLES20.glFlush();
                        }
                    }
                }
            }
        }
        int funcIndex = FuncSeeker.getFuncIndex("glGenTextures");
        int funcIndex2 = FuncSeeker.getFuncIndex("glDeleteTextures");
        int funcIndex3 = FuncSeeker.getFuncIndex("glGenBuffers");
        int funcIndex4 = FuncSeeker.getFuncIndex("glDeleteBuffers");
        int funcIndex5 = FuncSeeker.getFuncIndex("glGenFramebuffers");
        int funcIndex6 = FuncSeeker.getFuncIndex("glDeleteFramebuffers");
        int funcIndex7 = FuncSeeker.getFuncIndex("glGenRenderbuffers");
        int funcIndex8 = FuncSeeker.getFuncIndex("glDeleteRenderbuffers");
        int funcIndex9 = FuncSeeker.getFuncIndex("glGetError");
        mmkv.putInt("glGenTextures_index", funcIndex);
        mmkv.putInt("glDeleteTextures_index", funcIndex2);
        mmkv.putInt("glGenBuffers_index", funcIndex3);
        mmkv.putInt("glDeleteBuffers_index", funcIndex4);
        mmkv.putInt("glGenFramebuffers_index", funcIndex5);
        mmkv.putInt("glDeleteFramebuffers_index", funcIndex6);
        mmkv.putInt("glGenRenderbuffers_index", funcIndex7);
        mmkv.putInt("glDeleteRenderbuffers_index", funcIndex8);
        mmkv.putInt("glGetError_index", funcIndex9);
        mmkv.putBoolean("key_finish_function_seek", true);
        mmkv.commit();
        EGL14.eglDestroySurface(this.mEGLDisplay, this.hiV);
        EGL14.eglDestroyContext(this.mEGLDisplay, this.hiU);
        EGL14.eglReleaseThread();
        EGL14.eglTerminate(this.mEGLDisplay);
        this.mEGLDisplay = null;
        this.hiT = null;
        this.hiU = null;
        this.hiV = null;
        new StringBuilder().append(MMApplicationContext.getProcessName()).append(": System.exit()");
        a a2 = c.a(0, new a());
        Object obj = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/gpu/service/GpuHookServiceImpl", "main", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
        System.exit(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/gpu/service/GpuHookServiceImpl", "main", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
        AppMethodBeat.o(186207);
    }
}
