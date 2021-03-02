package com.tencent.mm.gpu.c;

import android.opengl.EGL14;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.gpu.PluginGpuRes;
import com.tencent.mm.gpu.d.b;
import com.tencent.mm.gpu.d.d;
import com.tencent.mm.gpu.e.c;
import com.tencent.mm.openglapihook.OpenGLHook;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.wxperf.jni.egl.EglHook;
import java.util.ArrayList;
import java.util.Map;

public final class a implements OpenGLHook.a, EglHook.OnChangeListener {
    private long hjc = 0;

    @Override // com.tencent.wxperf.jni.egl.EglHook.OnChangeListener
    public final void onCreateEglContext(com.tencent.wxperf.jni.egl.a aVar) {
        AppMethodBeat.i(186162);
        if (PluginGpuRes.hiS) {
            MultiProcessMMKV.getSingleMMKV("mmkv_gpu_service_key_single").putBoolean("eglCreateContext_status", true);
            Log.e("Gpu.OpenglHookListener", "onCreateEglContext needCheckMMKV, put KEY_EGL_CREATE_CONTEXT_STATUS == true");
        }
        Log.e("Gpu.OpenglHookListener", "onCreateEglContext " + aVar.Syr);
        c.e((long) c.Fi(MMApplicationContext.getProcessName()), 178, 1);
        com.tencent.mm.gpu.d.a.axl().a(new b(17, aVar.Syr));
        AppMethodBeat.o(186162);
    }

    @Override // com.tencent.wxperf.jni.egl.EglHook.OnChangeListener
    public final void onDeleteEglContext(long j2) {
        AppMethodBeat.i(186163);
        if (PluginGpuRes.hiS) {
            MultiProcessMMKV.getSingleMMKV("mmkv_gpu_service_key_single").putBoolean("eglDestroyContext_status", true);
            Log.e("Gpu.OpenglHookListener", "onDeleteEglContext needCheckMMKV, put KEY_EGL_CREATE_CONTEXT_STATUS == true");
        }
        Log.e("Gpu.OpenglHookListener", "onDeleteEglContext ".concat(String.valueOf(j2)));
        c.e((long) c.Fi(MMApplicationContext.getProcessName()), 179, 1);
        com.tencent.mm.gpu.d.a.axl().b(new b(17, j2));
        com.tencent.mm.gpu.d.c axn = com.tencent.mm.gpu.d.c.axn();
        axn.hjg.post(new Runnable(j2) {
            /* class com.tencent.mm.gpu.d.c.AnonymousClass3 */
            final /* synthetic */ long hjm;

            {
                this.hjm = r2;
            }

            public final void run() {
                AppMethodBeat.i(186181);
                synchronized (c.this.hjf) {
                    try {
                        for (Map map : c.this.hjf.values()) {
                            map.remove(Long.valueOf(this.hjm));
                        }
                    } finally {
                        AppMethodBeat.o(186181);
                    }
                }
            }
        });
        AppMethodBeat.o(186163);
    }

    @Override // com.tencent.wxperf.jni.egl.EglHook.OnChangeListener
    public final void onCreateEglWindowSurface(com.tencent.wxperf.jni.egl.a aVar) {
        AppMethodBeat.i(186164);
        if (PluginGpuRes.hiS) {
            MultiProcessMMKV.getSingleMMKV("mmkv_gpu_service_key_single").putBoolean("eglCreateSurface_status", true);
            Log.e("Gpu.OpenglHookListener", "onCreatePbufferSurface needCheckMMKV, put KEY_EGL_CREATE_SURFACE_STATUS == true");
        }
        Log.e("Gpu.OpenglHookListener", "onCreateEglWindowSurface " + aVar.Syr);
        c.e((long) c.Fi(MMApplicationContext.getProcessName()), 180, 1);
        com.tencent.mm.gpu.d.a.axl().a(new b(18, aVar.Syr));
        AppMethodBeat.o(186164);
    }

    @Override // com.tencent.wxperf.jni.egl.EglHook.OnChangeListener
    public final void onCreatePbufferSurface(com.tencent.wxperf.jni.egl.a aVar) {
        AppMethodBeat.i(186165);
        if (PluginGpuRes.hiS) {
            MultiProcessMMKV.getSingleMMKV("mmkv_gpu_service_key_single").putBoolean("eglCreateSurface_status", true);
            Log.e("Gpu.OpenglHookListener", "onCreatePbufferSurface needCheckMMKV, put KEY_EGL_CREATE_SURFACE_STATUS == true");
        }
        Log.e("Gpu.OpenglHookListener", "onCreatePbufferSurface = " + aVar.Syr);
        c.e((long) c.Fi(MMApplicationContext.getProcessName()), 181, 1);
        com.tencent.mm.gpu.d.a.axl().a(new b(18, aVar.Syr));
        AppMethodBeat.o(186165);
    }

    @Override // com.tencent.wxperf.jni.egl.EglHook.OnChangeListener
    public final void onDeleteEglSurface(long j2) {
        AppMethodBeat.i(186166);
        if (PluginGpuRes.hiS) {
            MultiProcessMMKV.getSingleMMKV("mmkv_gpu_service_key_single").putBoolean("eglDestroySurface_status", true);
            Log.e("Gpu.OpenglHookListener", "onDeleteEglSurface needCheckMMKV, put KEY_EGL_DESTROY_SURFACE_STATUS == true");
        }
        Log.e("Gpu.OpenglHookListener", "onDeleteEglSurface = ".concat(String.valueOf(j2)));
        c.e((long) c.Fi(MMApplicationContext.getProcessName()), 182, 1);
        com.tencent.mm.gpu.d.a.axl().b(new b(18, j2));
        AppMethodBeat.o(186166);
    }

    @Override // com.tencent.mm.openglapihook.OpenGLHook.a
    public final void a(com.tencent.mm.openglapihook.a aVar) {
        AppMethodBeat.i(186153);
        if (aVar.jGJ != 1285) {
            AppMethodBeat.o(186153);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.hjc > 300000) {
            this.hjc = currentTimeMillis;
            int Fi = c.Fi(MMApplicationContext.getProcessName());
            if (Fi != -1) {
                int currSpend = PluginGpuRes.getCurrSpend();
                if (currSpend <= 0) {
                    Log.e("Gpu.GpuResReport", "spend error, spend = ".concat(String.valueOf(currSpend)));
                } else {
                    c.e((long) Fi, 136, 1);
                }
            }
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                /* class com.tencent.mm.gpu.c.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(186152);
                    MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("mmkv_gpu_service_key_single");
                    singleMMKV.putInt("glGetErrorOOM_is_die", 0);
                    singleMMKV.commit();
                    AppMethodBeat.o(186152);
                }
            }, 180000);
            MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("mmkv_gpu_service_key_single");
            singleMMKV.putInt("glGetErrorOOM_is_die", 1);
            singleMMKV.commit();
        }
        int Fi2 = c.Fi(MMApplicationContext.getProcessName());
        if (Fi2 != -1) {
            int currSpend2 = PluginGpuRes.getCurrSpend();
            if (currSpend2 <= 0) {
                Log.e("Gpu.GpuResReport", "spend error, spend = ".concat(String.valueOf(currSpend2)));
                AppMethodBeat.o(186153);
                return;
            }
            if (currSpend2 <= 3) {
                c.e((long) Fi2, 82, 1);
            }
            if (currSpend2 <= 30) {
                c.e((long) Fi2, 7, 1);
                AppMethodBeat.o(186153);
                return;
            } else if (currSpend2 <= 60) {
                c.e((long) Fi2, 16, 1);
                AppMethodBeat.o(186153);
                return;
            } else if (currSpend2 <= 90) {
                c.e((long) Fi2, 25, 1);
                AppMethodBeat.o(186153);
                return;
            } else if (currSpend2 <= 120) {
                c.e((long) Fi2, 34, 1);
                AppMethodBeat.o(186153);
                return;
            } else if (currSpend2 <= 150) {
                c.e((long) Fi2, 43, 1);
                AppMethodBeat.o(186153);
                return;
            } else if (currSpend2 <= 180) {
                c.e((long) Fi2, 52, 1);
                AppMethodBeat.o(186153);
                return;
            } else if (currSpend2 <= 240) {
                c.e((long) Fi2, 61, 1);
                AppMethodBeat.o(186153);
                return;
            } else if (currSpend2 <= 300) {
                c.e((long) Fi2, 70, 1);
                AppMethodBeat.o(186153);
                return;
            } else {
                c.e((long) Fi2, 79, 1);
            }
        }
        AppMethodBeat.o(186153);
    }

    @Override // com.tencent.mm.openglapihook.OpenGLHook.a
    public final void b(com.tencent.mm.openglapihook.a aVar) {
        AppMethodBeat.i(186154);
        int[] iArr = aVar.jGI;
        if (iArr.length == 0) {
            Log.e("Gpu.OpenglHookListener", "onGlGenTextures, ids length = 0");
            AppMethodBeat.o(186154);
            return;
        }
        long nativeHandle = EGL14.eglGetCurrentContext().getNativeHandle();
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            arrayList.add(new d(1, i2, nativeHandle));
        }
        com.tencent.mm.gpu.d.c.axn().ae(arrayList);
        AppMethodBeat.o(186154);
    }

    @Override // com.tencent.mm.openglapihook.OpenGLHook.a
    public final void c(com.tencent.mm.openglapihook.a aVar) {
        AppMethodBeat.i(186155);
        int[] iArr = aVar.jGI;
        if (iArr.length == 0) {
            Log.e("Gpu.OpenglHookListener", "onGlDeleteTextures, ids length = 0");
            AppMethodBeat.o(186155);
            return;
        }
        long nativeHandle = EGL14.eglGetCurrentContext().getNativeHandle();
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            arrayList.add(new d(1, i2, nativeHandle));
        }
        com.tencent.mm.gpu.d.c.axn().af(arrayList);
        AppMethodBeat.o(186155);
    }

    @Override // com.tencent.mm.openglapihook.OpenGLHook.a
    public final void d(com.tencent.mm.openglapihook.a aVar) {
        AppMethodBeat.i(186156);
        int[] iArr = aVar.jGI;
        if (iArr.length == 0) {
            Log.e("Gpu.OpenglHookListener", "onGlGenBuffers, ids length = 0");
            AppMethodBeat.o(186156);
            return;
        }
        long nativeHandle = EGL14.eglGetCurrentContext().getNativeHandle();
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            arrayList.add(new d(2, i2, nativeHandle));
        }
        com.tencent.mm.gpu.d.c.axn().ae(arrayList);
        AppMethodBeat.o(186156);
    }

    @Override // com.tencent.mm.openglapihook.OpenGLHook.a
    public final void e(com.tencent.mm.openglapihook.a aVar) {
        AppMethodBeat.i(186157);
        int[] iArr = aVar.jGI;
        if (iArr.length == 0) {
            Log.e("Gpu.OpenglHookListener", "onGlDeleteBuffers, ids length = 0");
            AppMethodBeat.o(186157);
            return;
        }
        long nativeHandle = EGL14.eglGetCurrentContext().getNativeHandle();
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            arrayList.add(new d(2, i2, nativeHandle));
        }
        com.tencent.mm.gpu.d.c.axn().af(arrayList);
        AppMethodBeat.o(186157);
    }

    @Override // com.tencent.mm.openglapihook.OpenGLHook.a
    public final void f(com.tencent.mm.openglapihook.a aVar) {
        AppMethodBeat.i(186158);
        int[] iArr = aVar.jGI;
        if (iArr.length == 0) {
            Log.e("Gpu.OpenglHookListener", "onGlGenFramebuffers, ids length = 0");
            AppMethodBeat.o(186158);
            return;
        }
        long nativeHandle = EGL14.eglGetCurrentContext().getNativeHandle();
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            arrayList.add(new d(3, i2, nativeHandle));
        }
        com.tencent.mm.gpu.d.c.axn().ae(arrayList);
        AppMethodBeat.o(186158);
    }

    @Override // com.tencent.mm.openglapihook.OpenGLHook.a
    public final void g(com.tencent.mm.openglapihook.a aVar) {
        AppMethodBeat.i(186159);
        int[] iArr = aVar.jGI;
        if (iArr.length == 0) {
            Log.e("Gpu.OpenglHookListener", "onGlDeleteFramebuffers, ids length = 0");
            AppMethodBeat.o(186159);
            return;
        }
        long nativeHandle = EGL14.eglGetCurrentContext().getNativeHandle();
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            arrayList.add(new d(3, i2, nativeHandle));
        }
        com.tencent.mm.gpu.d.c.axn().af(arrayList);
        AppMethodBeat.o(186159);
    }

    @Override // com.tencent.mm.openglapihook.OpenGLHook.a
    public final void h(com.tencent.mm.openglapihook.a aVar) {
        AppMethodBeat.i(186160);
        int[] iArr = aVar.jGI;
        if (iArr.length == 0) {
            Log.e("Gpu.OpenglHookListener", "onGlGenRenderbuffers, ids length = 0");
            AppMethodBeat.o(186160);
            return;
        }
        long nativeHandle = EGL14.eglGetCurrentContext().getNativeHandle();
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            arrayList.add(new d(4, i2, nativeHandle));
        }
        com.tencent.mm.gpu.d.c.axn().ae(arrayList);
        AppMethodBeat.o(186160);
    }

    @Override // com.tencent.mm.openglapihook.OpenGLHook.a
    public final void i(com.tencent.mm.openglapihook.a aVar) {
        AppMethodBeat.i(186161);
        int[] iArr = aVar.jGI;
        if (iArr.length == 0) {
            Log.e("Gpu.OpenglHookListener", "onGlDeleteRenderbuffers, ids length = 0");
            AppMethodBeat.o(186161);
            return;
        }
        long nativeHandle = EGL14.eglGetCurrentContext().getNativeHandle();
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            arrayList.add(new d(4, i2, nativeHandle));
        }
        com.tencent.mm.gpu.d.c.axn().af(arrayList);
        AppMethodBeat.o(186161);
    }
}
