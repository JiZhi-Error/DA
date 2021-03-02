package com.tencent.mm.gpu;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.google.android.gms.gcm.Task;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.hr;
import com.tencent.mm.gpu.a.a;
import com.tencent.mm.gpu.g.a;
import com.tencent.mm.gpu.g.b;
import com.tencent.mm.gpu.service.GpuHookService;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.openglapihook.OpenGLHook;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mmkv.MMKV;
import com.tencent.wxperf.jni.egl.EglHook;

public class PluginGpuRes extends f implements o, a, c {
    private static int hiP = 0;
    private static boolean hiQ = false;
    public static boolean hiS = false;
    private static boolean isFront = true;
    private String[] hiO = {com.tencent.mm.gpu.b.a.hiY, com.tencent.mm.gpu.b.a.hja, com.tencent.mm.gpu.b.a.hjb};
    private boolean hiR = false;
    private EGLConfig hiT;
    private EGLContext hiU;
    private EGLSurface hiV;
    private IListener hiW = new IListener<hr>() {
        /* class com.tencent.mm.gpu.PluginGpuRes.AnonymousClass2 */

        {
            AppMethodBeat.i(186134);
            this.__eventId = hr.class.getName().hashCode();
            AppMethodBeat.o(186134);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hr hrVar) {
            AppMethodBeat.i(186135);
            hr hrVar2 = hrVar;
            Log.i("Gpu.PluginGpuRes", "finder event id = " + hrVar2.dMk.eventId);
            if (hrVar2.dMk.eventId == 0) {
                b axB = b.axB();
                Log.i("MicroMsg.KeyBusinessMonitor", "register:".concat(String.valueOf("finder")));
                axB.axC();
                axB.hjG = "finder";
                Log.i("MicroMsg.KeyBusinessMonitor", "startWork:" + axB.hjG);
                com.tencent.mm.gpu.g.a axy = com.tencent.mm.gpu.g.a.axy();
                a.AbstractC0347a aVar = axB.hjL;
                if (aVar != null) {
                    synchronized (axy.mListeners) {
                        try {
                            if (!axy.mListeners.contains(aVar)) {
                                axy.mListeners.add(aVar);
                            }
                        } finally {
                            AppMethodBeat.o(186135);
                        }
                    }
                }
                return true;
            } else if (hrVar2.dMk.eventId == 1) {
                b axB2 = b.axB();
                Log.i("MicroMsg.KeyBusinessMonitor", "unregister:".concat(String.valueOf("finder")));
                axB2.axC();
                AppMethodBeat.o(186135);
                return true;
            } else {
                AppMethodBeat.o(186135);
                return false;
            }
        }
    };
    private EGLDisplay mEGLDisplay;

    public PluginGpuRes() {
        AppMethodBeat.i(186137);
        AppMethodBeat.o(186137);
    }

    static /* synthetic */ void access$000(PluginGpuRes pluginGpuRes) {
        AppMethodBeat.i(186150);
        pluginGpuRes.start();
        AppMethodBeat.o(186150);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(186138);
        alias(com.tencent.mm.gpu.a.a.class);
        AppMethodBeat.o(186138);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(186139);
        dependsOnRoot();
        AppMethodBeat.o(186139);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(186140);
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.gpu.PluginGpuRes.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(186133);
                PluginGpuRes.access$000(PluginGpuRes.this);
                AppMethodBeat.o(186133);
            }
        });
        AppMethodBeat.o(186140);
    }

    private void start() {
        AppMethodBeat.i(186141);
        if (!((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_gpu_service_open, true)) {
            AppMethodBeat.o(186141);
            return;
        }
        Log.d("Gpu.PluginGpuRes", "PluginGpuRes execute");
        MMKV.initialize(MMApplicationContext.getContext());
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("mmkv_gpu_service_key_muti");
        MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("mmkv_gpu_service_key_single");
        if (singleMMKV.getInt("glGetErrorOOM_is_die", 0) == 1) {
            int Fi = com.tencent.mm.gpu.e.c.Fi(MMApplicationContext.getProcessName());
            if (Fi != -1) {
                int currSpend = getCurrSpend();
                if (currSpend <= 0) {
                    Log.e("Gpu.GpuResReport", "spend error, spend = ".concat(String.valueOf(currSpend)));
                } else {
                    com.tencent.mm.gpu.e.c.e((long) Fi, 137, 1);
                }
            }
            singleMMKV.putInt("glGetErrorOOM_is_die", 0);
            singleMMKV.commit();
        }
        if (!isInWhiteList(MMApplicationContext.getProcessName())) {
            AppMethodBeat.o(186141);
            return;
        }
        h.RTc.a(new Runnable() {
            /* class com.tencent.mm.gpu.PluginGpuRes.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(186136);
                PluginGpuRes.hiP += 1800000;
                AppMethodBeat.o(186136);
            }
        }, 1800000, 1800000);
        com.tencent.mm.gpu.e.b bVar = new com.tencent.mm.gpu.e.b();
        com.tencent.mm.gpu.e.a aVar = new com.tencent.mm.gpu.e.a();
        h.RTc.a(bVar, 1800000, 1800000);
        h.RTc.a(aVar, 1800000, 1800000);
        com.tencent.mm.gpu.g.a axy = com.tencent.mm.gpu.g.a.axy();
        if (axy.hjE) {
            Log.e("MicroMsg.GpuMemoryWatchDog", "GPU WATCH DOG HAS BEGIN!");
        } else if (isSkipModel()) {
            Log.e("MicroMsg.GpuMemoryWatchDog", "skip current phone model");
        } else {
            Log.i("MicroMsg.GpuMemoryWatchDog", "do not skip current phone model");
            h.RTc.a(axy, 900000, 900000);
            axy.hjE = true;
        }
        EventCenter.instance.add(this.hiW);
        boolean z = mmkv.getBoolean("key_has_function_seek_start", false);
        boolean z2 = mmkv.getBoolean("key_finish_function_seek", false);
        Log.e("Gpu.PluginGpuRes", "hasStart = ".concat(String.valueOf(z)));
        Log.e("Gpu.PluginGpuRes", "hasFinish = ".concat(String.valueOf(z2)));
        if (z) {
            if (z2) {
                com.tencent.mm.gpu.e.c.axr();
                int i2 = singleMMKV.getInt("openGL_api_hook_flag", -1);
                if (i2 == -1 || i2 == 1) {
                    singleMMKV.putInt("openGL_api_hook_flag", 2);
                    singleMMKV.commit();
                    boolean a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_gpu_opengl_api_hook_not_laboratory, false);
                    Log.i("Gpu.PluginGpuRes", "openOpenGLHook:".concat(String.valueOf(a2)));
                    if (a2) {
                        Log.e("Gpu.PluginGpuRes", "open opengl hook");
                        startGLHook();
                    } else {
                        Log.e("Gpu.PluginGpuRes", "close opengl hook");
                    }
                    singleMMKV.putInt("openGL_api_hook_flag", 1);
                    singleMMKV.commit();
                    EglHook eglHook = EglHook.Syq;
                    EglHook.a(new com.tencent.mm.gpu.c.a());
                    if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_egl_hook_open, false)) {
                        Log.e("Gpu.PluginGpuRes", "open egl hook");
                        startEGLHook();
                        this.hiR = false;
                        initOpenGL(true);
                        if (!this.hiR) {
                            release(true);
                        }
                        handleEGLHookReport(singleMMKV);
                    } else {
                        Log.e("Gpu.PluginGpuRes", "close egl hook");
                    }
                } else {
                    Log.e("Gpu.PluginGpuRes", "has fail before");
                    AppMethodBeat.o(186141);
                    return;
                }
            } else {
                com.tencent.mm.gpu.e.c.axs();
            }
        }
        Log.d("Gpu.PluginGpuRes", "PluginGpuRes execute end");
        AppMethodBeat.o(186141);
    }

    private void handleEGLHookReport(MultiProcessMMKV multiProcessMMKV) {
        AppMethodBeat.i(186142);
        hiS = false;
        boolean z = multiProcessMMKV.getBoolean("eglCreateContext_status", false);
        boolean z2 = multiProcessMMKV.getBoolean("eglCreateSurface_status", false);
        boolean z3 = multiProcessMMKV.getBoolean("eglDestroySurface_status", false);
        boolean z4 = multiProcessMMKV.getBoolean("eglDestroyContext_status", false);
        if (z) {
            com.tencent.mm.gpu.e.c.axp();
            Log.e("Gpu.PluginGpuRes", "hook EGL create context success");
        } else {
            com.tencent.mm.gpu.e.c.axq();
            Log.e("Gpu.PluginGpuRes", "hook EGL create context fail");
        }
        if (z2) {
            com.tencent.mm.gpu.e.c.axp();
            Log.e("Gpu.PluginGpuRes", "hook EGL create surface success");
        } else {
            com.tencent.mm.gpu.e.c.axq();
            Log.e("Gpu.PluginGpuRes", "hook EGL create surface fail");
        }
        if (z3) {
            com.tencent.mm.gpu.e.c.axp();
            Log.e("Gpu.PluginGpuRes", "hook EGL destroy context success");
        } else {
            com.tencent.mm.gpu.e.c.axq();
            Log.e("Gpu.PluginGpuRes", "hook EGL destroy context fail");
        }
        if (z4) {
            com.tencent.mm.gpu.e.c.axp();
            Log.e("Gpu.PluginGpuRes", "hook EGL destroy surface success");
            AppMethodBeat.o(186142);
            return;
        }
        com.tencent.mm.gpu.e.c.axq();
        Log.e("Gpu.PluginGpuRes", "hook EGL destroy surface fail");
        AppMethodBeat.o(186142);
    }

    private void startEGLHook() {
    }

    private void startGLHook() {
        AppMethodBeat.i(186143);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("mmkv_gpu_service_key_muti");
        initOpenGL(false);
        if (this.hiR) {
            AppMethodBeat.o(186143);
            return;
        }
        testMemoryShake();
        int i2 = mmkv.getInt("glGenTextures_index", -1000);
        int i3 = mmkv.getInt("glDeleteTextures_index", -1000);
        int i4 = mmkv.getInt("glGenBuffers_index", -1000);
        int i5 = mmkv.getInt("glDeleteBuffers_index", -1000);
        int i6 = mmkv.getInt("glGenFramebuffers_index", -1000);
        int i7 = mmkv.getInt("glDeleteFramebuffers_index", -1000);
        int i8 = mmkv.getInt("glGenRenderbuffers_index", -1000);
        int i9 = mmkv.getInt("glDeleteRenderbuffers_index", -1000);
        int i10 = mmkv.getInt("glGetError_index", -1000);
        OpenGLHook.getInstance().init();
        OpenGLHook.getInstance().setListener(new com.tencent.mm.gpu.c.a());
        if (i2 < 0 || i3 < 0) {
            Log.e("Gpu.PluginGpuRes", "opengl hook fail : Textures : %d,%d", Integer.valueOf(i2), Integer.valueOf(i3));
            com.tencent.mm.gpu.e.c.e(1403, 6, 1);
            com.tencent.mm.gpu.e.c.axs();
        } else {
            OpenGLHook.getInstance().hook("glGenTextures", i2);
            OpenGLHook.getInstance().hook("glDeleteTextures", i3);
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glDeleteTextures(1, iArr, 0);
            Log.i("Gpu.PluginGpuRes", "opengl hook succ : Textures : %d,%d", Integer.valueOf(i2), Integer.valueOf(i3));
            com.tencent.mm.gpu.e.c.e(1403, 13, 1);
            com.tencent.mm.gpu.e.c.axr();
        }
        if (i4 < 0 || i5 < 0) {
            Log.e("Gpu.PluginGpuRes", "opengl hook fail : Buffers : %d,%d", Integer.valueOf(i4), Integer.valueOf(i5));
            com.tencent.mm.gpu.e.c.e(1403, 7, 1);
            com.tencent.mm.gpu.e.c.axs();
        } else {
            OpenGLHook.getInstance().hook("glGenBuffers", i4);
            OpenGLHook.getInstance().hook("glDeleteBuffers", i5);
            int[] iArr2 = new int[1];
            GLES20.glGenBuffers(1, iArr2, 0);
            GLES20.glDeleteBuffers(1, iArr2, 0);
            Log.i("Gpu.PluginGpuRes", "opengl hook succ : Buffers : %d,%d", Integer.valueOf(i4), Integer.valueOf(i5));
            com.tencent.mm.gpu.e.c.e(1403, 14, 1);
            com.tencent.mm.gpu.e.c.axr();
        }
        if (i6 < 0 || i7 < 0) {
            Log.e("Gpu.PluginGpuRes", "opengl hook fail : Framebuffers : %d,%d", Integer.valueOf(i6), Integer.valueOf(i7));
            com.tencent.mm.gpu.e.c.e(1403, 8, 1);
            com.tencent.mm.gpu.e.c.axs();
        } else {
            OpenGLHook.getInstance().hook("glGenFramebuffers", i6);
            OpenGLHook.getInstance().hook("glDeleteFramebuffers", i7);
            int[] iArr3 = new int[1];
            GLES20.glGenFramebuffers(1, iArr3, 0);
            GLES20.glDeleteFramebuffers(1, iArr3, 0);
            Log.i("Gpu.PluginGpuRes", "opengl hook succ : Framebuffers : %d,%d", Integer.valueOf(i6), Integer.valueOf(i7));
            com.tencent.mm.gpu.e.c.e(1403, 15, 1);
            com.tencent.mm.gpu.e.c.axr();
        }
        if (i8 < 0 || i9 < 0) {
            Log.e("Gpu.PluginGpuRes", "opengl hook fail : Renderbuffers : %d,%d", Integer.valueOf(i8), Integer.valueOf(i9));
            com.tencent.mm.gpu.e.c.e(1403, 9, 1);
            com.tencent.mm.gpu.e.c.axs();
        } else {
            OpenGLHook.getInstance().hook("glGenRenderbuffers", i8);
            OpenGLHook.getInstance().hook("glDeleteRenderbuffers", i9);
            int[] iArr4 = new int[1];
            GLES20.glGenRenderbuffers(1, iArr4, 0);
            GLES20.glDeleteRenderbuffers(1, iArr4, 0);
            Log.i("Gpu.PluginGpuRes", "opengl hook succ : Renderbuffers : %d,%d", Integer.valueOf(i8), Integer.valueOf(i9));
            com.tencent.mm.gpu.e.c.e(1403, 16, 1);
            com.tencent.mm.gpu.e.c.axr();
        }
        if (i10 < 0) {
            Log.e("Gpu.PluginGpuRes", "opengl hook fail : GetError : %d", Integer.valueOf(i10));
            com.tencent.mm.gpu.e.c.e(1403, 10, 1);
            com.tencent.mm.gpu.e.c.axs();
        } else {
            OpenGLHook.getInstance().hook("glGetError", i10);
            GLES20.glGetError();
            Log.i("Gpu.PluginGpuRes", "opengl hook succ : GetError : %d", Integer.valueOf(i10));
            com.tencent.mm.gpu.e.c.e(1403, 17, 1);
            com.tencent.mm.gpu.e.c.axr();
        }
        release(false);
        AppMethodBeat.o(186143);
    }

    public static int getCurrSpend() {
        return hiP / 60000;
    }

    private boolean isInWhiteList(String str) {
        AppMethodBeat.i(186144);
        if (str == null || "".equals(str)) {
            AppMethodBeat.o(186144);
            return false;
        } else if (str.startsWith(com.tencent.mm.gpu.b.a.hiZ)) {
            AppMethodBeat.o(186144);
            return true;
        } else {
            for (String str2 : this.hiO) {
                if (str.equals(str2)) {
                    AppMethodBeat.o(186144);
                    return true;
                }
            }
            AppMethodBeat.o(186144);
            return false;
        }
    }

    private void release(boolean z) {
        AppMethodBeat.i(186145);
        MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("mmkv_gpu_service_key_single");
        if (z) {
            singleMMKV.putBoolean("eglDestroySurface_status", false);
        }
        EGL14.eglDestroySurface(this.mEGLDisplay, this.hiV);
        if (z) {
            singleMMKV.putBoolean("eglDestroyContext_status", false);
        }
        EGL14.eglDestroyContext(this.mEGLDisplay, this.hiU);
        EGL14.eglReleaseThread();
        EGL14.eglTerminate(this.mEGLDisplay);
        this.mEGLDisplay = null;
        this.hiT = null;
        this.hiU = null;
        this.hiV = null;
        AppMethodBeat.o(186145);
    }

    private void initOpenGL(boolean z) {
        AppMethodBeat.i(186146);
        this.mEGLDisplay = EGL14.eglGetDisplay(0);
        if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
            Log.e("Gpu.PluginGpuRes", "mEGLDisplay == EGL14.EGL_NO_DISPLAY");
            this.hiR = true;
            AppMethodBeat.o(186146);
            return;
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(this.mEGLDisplay, iArr, 0, iArr, 1)) {
            Log.e("Gpu.PluginGpuRes", "eglInitialize fail");
            this.hiR = true;
            AppMethodBeat.o(186146);
            return;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.mEGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            Log.e("Gpu.PluginGpuRes", "eglChooseConfig fail");
            this.hiR = true;
            AppMethodBeat.o(186146);
            return;
        }
        this.hiT = eGLConfigArr[0];
        int[] iArr2 = {12440, 2, 12344};
        MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("mmkv_gpu_service_key_single");
        if (z) {
            singleMMKV.putBoolean("eglCreateContext_status", false);
        }
        this.hiU = EGL14.eglCreateContext(this.mEGLDisplay, this.hiT, EGL14.EGL_NO_CONTEXT, iArr2, 0);
        if (this.hiU == EGL14.EGL_NO_CONTEXT) {
            Log.e("Gpu.PluginGpuRes", "EGL14.eglGetError() = ".concat(String.valueOf(EGL14.eglGetError())));
            Log.e("Gpu.PluginGpuRes", "mEglContext == EGL14.EGL_NO_CONTEXT");
            this.hiR = true;
            AppMethodBeat.o(186146);
            return;
        }
        int[] iArr3 = {12375, 64, 12374, 64, 12344};
        if (z) {
            singleMMKV.putBoolean("eglCreateSurface_status", false);
        }
        this.hiV = EGL14.eglCreatePbufferSurface(this.mEGLDisplay, this.hiT, iArr3, 0);
        if (this.hiV == EGL14.EGL_NO_SURFACE) {
            Log.e("Gpu.PluginGpuRes", "mEglSurface == EGL14.EGL_NO_SURFACE");
            this.hiR = true;
            AppMethodBeat.o(186146);
        } else if (!EGL14.eglMakeCurrent(this.mEGLDisplay, this.hiV, this.hiV, this.hiU)) {
            Log.e("Gpu.PluginGpuRes", "eglMakeCurrent fail");
            this.hiR = true;
            AppMethodBeat.o(186146);
        } else {
            GLES20.glFlush();
            AppMethodBeat.o(186146);
        }
    }

    private static void skipCurrentModel() {
        hiQ = true;
    }

    public static boolean isSkipModel() {
        return hiQ;
    }

    private static void testMemoryShake() {
        AppMethodBeat.i(186147);
        com.tencent.mm.gpu.f.a aVar = new com.tencent.mm.gpu.f.a();
        int axw = aVar.axw();
        int axv = aVar.axv();
        int axu = aVar.axu();
        Bitmap decodeResource = BitmapFactory.decodeResource(MMApplicationContext.getResources(), R.drawable.coi);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, Task.EXTRAS_LIMIT_BYTES, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLUtils.texImage2D(3553, 0, decodeResource, 0);
        GLES20.glBindTexture(3553, 0);
        decodeResource.recycle();
        com.tencent.mm.gpu.f.a aVar2 = new com.tencent.mm.gpu.f.a();
        int axw2 = aVar2.axw();
        int axv2 = aVar2.axv();
        int axu2 = aVar2.axu();
        if (axw == axw2 && axu == axu2 && axv == axv2) {
            Log.d("Gpu.PluginGpuRes", "testMemoryShake: init == new");
            skipCurrentModel();
        }
        Log.d("Gpu.PluginGpuRes", "testMemoryShake: init != new");
        GLES20.glDeleteTextures(1, iArr, 0);
        AppMethodBeat.o(186147);
    }

    @Override // com.tencent.mm.app.o
    public void onAppForeground(String str) {
        isFront = true;
    }

    @Override // com.tencent.mm.app.o
    public void onAppBackground(String str) {
        isFront = false;
    }

    public static boolean isFront() {
        return isFront;
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(186148);
        Log.e("Gpu.PluginGpuRes", "onAccountInitialized start");
        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_gpu_process_open, false);
        Log.i("Gpu.PluginGpuRes", "openGpuProcess = ".concat(String.valueOf(a2)));
        if (!a2) {
            AppMethodBeat.o(186148);
            return;
        }
        startGpuHookService();
        Log.e("Gpu.PluginGpuRes", "onAccountInitialized end");
        AppMethodBeat.o(186148);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
    }

    private void startGpuHookService() {
        AppMethodBeat.i(186149);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("mmkv_gpu_service_key_muti");
        long j2 = mmkv.getLong("openGL_api_service_time", -1);
        if (j2 == -1) {
            mmkv.putLong("openGL_api_service_time", System.currentTimeMillis());
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - j2 < 604800000) {
                Log.e("Gpu.PluginGpuRes", "startGpuHookService fail, because less than 7 days");
                AppMethodBeat.o(186149);
                return;
            }
            mmkv.putLong("openGL_api_service_time", currentTimeMillis);
            Log.e("Gpu.PluginGpuRes", "startGpuHookService success, because equals or more than 7 days");
        }
        Log.i("Gpu.PluginGpuRes", "[sunny]ec:%d,t:%s,itv:%d", 1, "OpenGL_Api_Hook", 120);
        try {
            GpuHookService.F(MMApplicationContext.getContext(), "OpenGL_Api_Hook");
            AppMethodBeat.o(186149);
        } catch (Exception e2) {
            Log.e("Gpu.PluginGpuRes", "GpuHookService.enableGpuHook");
            AppMethodBeat.o(186149);
        }
    }
}
