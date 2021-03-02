package com.tencent.liteav.basic.c;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.liteav.basic.c.g;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.component.TAVExporter;
import javax.microedition.khronos.egl.EGLContext;

public class f implements g.a, m {

    /* renamed from: a  reason: collision with root package name */
    public int f274a = 25;

    /* renamed from: b  reason: collision with root package name */
    private volatile HandlerThread f275b = null;

    /* renamed from: c  reason: collision with root package name */
    private volatile g f276c = null;

    /* renamed from: d  reason: collision with root package name */
    private n f277d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f278e = null;

    /* renamed from: f  reason: collision with root package name */
    private SurfaceTexture f279f = null;

    /* renamed from: g  reason: collision with root package name */
    private boolean f280g = false;

    /* renamed from: h  reason: collision with root package name */
    private long f281h = 0;

    /* renamed from: i  reason: collision with root package name */
    private long f282i = 0;

    /* renamed from: j  reason: collision with root package name */
    private float[] f283j = new float[16];

    static /* synthetic */ void a(f fVar, int i2) {
        AppMethodBeat.i(222228);
        fVar.a(i2);
        AppMethodBeat.o(222228);
    }

    static /* synthetic */ void a(f fVar, int i2, Runnable runnable) {
        AppMethodBeat.i(222229);
        fVar.a(i2, runnable);
        AppMethodBeat.o(222229);
    }

    public f() {
        AppMethodBeat.i(222211);
        AppMethodBeat.o(222211);
    }

    @Override // com.tencent.liteav.basic.c.m
    public void a(int i2, boolean z) {
        AppMethodBeat.i(222212);
        this.f274a = i2;
        b();
        AppMethodBeat.o(222212);
    }

    @Override // com.tencent.liteav.basic.c.m
    public void a() {
        AppMethodBeat.i(222213);
        f();
        AppMethodBeat.o(222213);
    }

    @Override // com.tencent.liteav.basic.c.m
    public void setSurfaceTextureListener(n nVar) {
        this.f277d = nVar;
    }

    @Override // com.tencent.liteav.basic.c.m
    public SurfaceTexture getSurfaceTexture() {
        return this.f279f;
    }

    @Override // com.tencent.liteav.basic.c.m
    public EGLContext getGLContext() {
        EGLContext a2;
        AppMethodBeat.i(222214);
        synchronized (this) {
            try {
                a2 = this.f276c != null ? this.f276c.a() : null;
            } finally {
                AppMethodBeat.o(222214);
            }
        }
        return a2;
    }

    @Override // com.tencent.liteav.basic.c.m
    public void a(Runnable runnable) {
        AppMethodBeat.i(222215);
        synchronized (this) {
            try {
                if (this.f276c != null) {
                    this.f276c.post(runnable);
                }
            } finally {
                AppMethodBeat.o(222215);
            }
        }
    }

    @Override // com.tencent.liteav.basic.c.m
    public void a(boolean z) {
        AppMethodBeat.i(222216);
        synchronized (this) {
            try {
                if (this.f276c != null) {
                    this.f276c.removeCallbacksAndMessages(null);
                }
                this.f280g = false;
                if (this.f279f == null || this.f278e == null) {
                    try {
                        AppMethodBeat.o(222216);
                    } catch (Throwable th) {
                        AppMethodBeat.o(222216);
                        throw th;
                    }
                } else {
                    this.f279f.updateTexImage();
                    this.f279f.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
                        /* class com.tencent.liteav.basic.c.f.AnonymousClass1 */

                        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                            AppMethodBeat.i(222191);
                            f.a(f.this, 103, new Runnable() {
                                /* class com.tencent.liteav.basic.c.f.AnonymousClass1.AnonymousClass1 */

                                public void run() {
                                    AppMethodBeat.i(222189);
                                    f.this.f280g = true;
                                    f.a(f.this, 102);
                                    AppMethodBeat.o(222189);
                                }
                            });
                            surfaceTexture.setOnFrameAvailableListener(null);
                            AppMethodBeat.o(222191);
                        }
                    });
                    AppMethodBeat.o(222216);
                }
            } catch (Exception e2) {
                TXCLog.e("TXGLSurfaceTextureThread", "updateTexImage failed." + e2.getMessage());
            }
        }
    }

    @Override // com.tencent.liteav.basic.c.m
    public void a(int i2, boolean z, int i3, int i4, int i5, boolean z2) {
    }

    @Override // com.tencent.liteav.basic.c.m
    public void a(byte[] bArr) {
    }

    @Override // com.tencent.liteav.basic.c.m
    public void setRendMode(int i2) {
    }

    @Override // com.tencent.liteav.basic.c.m
    public void setRendMirror(int i2) {
    }

    @Override // com.tencent.liteav.basic.c.g.a
    public void c() {
        AppMethodBeat.i(222217);
        h();
        AppMethodBeat.o(222217);
    }

    @Override // com.tencent.liteav.basic.c.g.a
    public void d() {
        AppMethodBeat.i(222218);
        a(102, 5);
        if (!i()) {
            AppMethodBeat.o(222218);
        } else if (this.f279f == null || this.f278e == null) {
            AppMethodBeat.o(222218);
        } else {
            try {
                this.f279f.updateTexImage();
                this.f279f.getTransformMatrix(this.f283j);
            } catch (Exception e2) {
                TXCLog.e("TXGLSurfaceTextureThread", "onMsgRend Exception " + e2.getMessage());
            }
            n nVar = this.f277d;
            if (nVar != null) {
                nVar.a(this.f278e[0], this.f283j);
            }
            AppMethodBeat.o(222218);
        }
    }

    @Override // com.tencent.liteav.basic.c.g.a
    public void e() {
        AppMethodBeat.i(222219);
        g();
        AppMethodBeat.o(222219);
    }

    private void b() {
        AppMethodBeat.i(222220);
        f();
        synchronized (this) {
            try {
                this.f275b = new HandlerThread("TXGLSurfaceTextureThread");
                this.f275b.start();
                this.f276c = new g(this.f275b.getLooper());
                this.f276c.a(this);
                this.f276c.f288a = TAVExporter.VIDEO_EXPORT_HEIGHT;
                this.f276c.f289b = TAVExporter.VIDEO_EXPORT_WIDTH;
                TXCLog.w("TXGLSurfaceTextureThread", "create gl thread " + this.f275b.getName());
            } catch (Throwable th) {
                AppMethodBeat.o(222220);
                throw th;
            }
        }
        a(100);
        AppMethodBeat.o(222220);
    }

    private void f() {
        AppMethodBeat.i(222221);
        synchronized (this) {
            try {
                if (this.f276c != null) {
                    g.a(this.f276c, this.f275b);
                    TXCLog.w("TXGLSurfaceTextureThread", "destroy gl thread");
                }
                this.f276c = null;
                this.f275b = null;
            } finally {
                AppMethodBeat.o(222221);
            }
        }
    }

    private void a(int i2, long j2) {
        AppMethodBeat.i(222222);
        synchronized (this) {
            try {
                if (this.f276c != null) {
                    this.f276c.sendEmptyMessageDelayed(i2, j2);
                }
            } finally {
                AppMethodBeat.o(222222);
            }
        }
    }

    private void a(int i2) {
        AppMethodBeat.i(222223);
        synchronized (this) {
            try {
                if (this.f276c != null) {
                    this.f276c.sendEmptyMessage(i2);
                }
            } finally {
                AppMethodBeat.o(222223);
            }
        }
    }

    private void a(int i2, Runnable runnable) {
        AppMethodBeat.i(222224);
        synchronized (this) {
            try {
                if (this.f276c != null) {
                    Message message = new Message();
                    message.what = i2;
                    message.obj = runnable;
                    this.f276c.sendMessage(message);
                }
            } finally {
                AppMethodBeat.o(222224);
            }
        }
    }

    private void g() {
        AppMethodBeat.i(222225);
        TXCLog.w("TXGLSurfaceTextureThread", "destroy surface texture ");
        n nVar = this.f277d;
        if (nVar != null) {
            nVar.b(this.f279f);
        }
        if (this.f279f != null) {
            this.f279f.setOnFrameAvailableListener(null);
            this.f279f.release();
            this.f280g = false;
            this.f279f = null;
        }
        if (this.f278e != null) {
            GLES20.glDeleteTextures(1, this.f278e, 0);
            this.f278e = null;
        }
        AppMethodBeat.o(222225);
    }

    private void h() {
        AppMethodBeat.i(222226);
        TXCLog.w("TXGLSurfaceTextureThread", "init surface texture ");
        this.f278e = new int[1];
        this.f278e[0] = j.b();
        if (this.f278e[0] <= 0) {
            this.f278e = null;
            AppMethodBeat.o(222226);
            return;
        }
        this.f279f = new SurfaceTexture(this.f278e[0]);
        this.f279f.setDefaultBufferSize(TAVExporter.VIDEO_EXPORT_HEIGHT, TAVExporter.VIDEO_EXPORT_WIDTH);
        this.f279f.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
            /* class com.tencent.liteav.basic.c.f.AnonymousClass2 */

            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(222209);
                f.a(f.this, 103, new Runnable() {
                    /* class com.tencent.liteav.basic.c.f.AnonymousClass2.AnonymousClass1 */

                    public void run() {
                        AppMethodBeat.i(222309);
                        f.this.f280g = true;
                        f.a(f.this, 102);
                        AppMethodBeat.o(222309);
                    }
                });
                surfaceTexture.setOnFrameAvailableListener(null);
                AppMethodBeat.o(222209);
            }
        });
        n nVar = this.f277d;
        if (nVar != null) {
            nVar.a(this.f279f);
        }
        AppMethodBeat.o(222226);
    }

    private boolean i() {
        AppMethodBeat.i(222227);
        if (!this.f280g) {
            this.f281h = 0;
            this.f282i = System.nanoTime();
            AppMethodBeat.o(222227);
            return false;
        }
        long nanoTime = System.nanoTime();
        if (nanoTime < this.f282i + ((((this.f281h * 1000) * 1000) * 1000) / ((long) this.f274a))) {
            AppMethodBeat.o(222227);
            return false;
        }
        if (this.f282i == 0) {
            this.f282i = nanoTime;
        } else if (nanoTime > this.f282i + 1000000000) {
            this.f281h = 0;
            this.f282i = nanoTime;
        }
        this.f281h++;
        AppMethodBeat.o(222227);
        return true;
    }
}
