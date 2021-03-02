package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;

public class a extends e implements SurfaceTexture.OnFrameAvailableListener {
    private c A;
    private TXSVideoFrame B;
    private TXCYuvTextureRender C;
    private Object D = null;
    private Object E = new Object();
    private h F;
    private TXCYuvTextureRender G;
    private final Queue<Runnable> H = new LinkedList();

    /* renamed from: a  reason: collision with root package name */
    g f1081a;

    /* renamed from: b  reason: collision with root package name */
    AbstractC0159a f1082b;

    /* renamed from: c  reason: collision with root package name */
    AbstractC0159a f1083c;
    private final int q = 0;
    private final int r = 0;
    private final int s = 0;
    private final int t = 0;
    private Object u = new Object();
    private b v;
    private SurfaceTexture w;
    private c x;
    private boolean y;
    private float[] z = new float[16];

    /* renamed from: com.tencent.liteav.renderer.a$a  reason: collision with other inner class name */
    public interface AbstractC0159a {
        void onTextureProcess(int i2, int i3, int i4, int i5);
    }

    public a() {
        AppMethodBeat.i(16847);
        AppMethodBeat.o(16847);
    }

    public void a(g gVar) {
        this.f1081a = gVar;
    }

    public void a(AbstractC0159a aVar) {
        AppMethodBeat.i(16848);
        this.f1082b = aVar;
        if (!(aVar == null || this.C == null)) {
            this.C.setHasFrameBuffer(this.f1124h, this.f1125i);
        }
        AppMethodBeat.o(16848);
    }

    public void b(AbstractC0159a aVar) {
        AppMethodBeat.i(16849);
        this.f1083c = aVar;
        if (!(aVar == null || this.C == null)) {
            this.C.setHasFrameBuffer(this.f1124h, this.f1125i);
        }
        AppMethodBeat.o(16849);
    }

    @Override // com.tencent.liteav.renderer.e
    public void a(TXSVideoFrame tXSVideoFrame, int i2, int i3, int i4) {
        AppMethodBeat.i(16850);
        synchronized (this) {
            try {
                if (this.B != null) {
                    this.B.release();
                }
                this.B = tXSVideoFrame;
            } finally {
                AppMethodBeat.o(16850);
            }
        }
        super.a(tXSVideoFrame, i2, i3, i4);
        synchronized (this.u) {
            try {
                if (this.v != null) {
                    this.v.c();
                }
            } finally {
                AppMethodBeat.o(16850);
            }
        }
    }

    @Override // com.tencent.liteav.renderer.e
    public void a(int i2, int i3, int i4, boolean z2, int i5) {
        AppMethodBeat.i(16851);
        GLES20.glViewport(0, 0, g(), h());
        if (this.A != null) {
            this.A.a(i2, z2, i5);
        }
        super.a(i2, i3, i4, z2, i5);
        synchronized (this.u) {
            try {
                if (this.v != null) {
                    this.v.c();
                }
            } finally {
                AppMethodBeat.o(16851);
            }
        }
    }

    @Override // com.tencent.liteav.renderer.e
    public SurfaceTexture a() {
        return this.w;
    }

    public Object b() {
        Object a2;
        AppMethodBeat.i(222346);
        synchronized (this.u) {
            try {
                a2 = this.v != null ? this.v.a() : null;
            } finally {
                AppMethodBeat.o(222346);
            }
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.liteav.renderer.e
    public void a(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(16853);
        super.a(surfaceTexture);
        TXCLog.w("TXCVideoRender", "play:vrender: create render thread when onSurfaceCreate");
        c((Object) null);
        AppMethodBeat.o(16853);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.liteav.renderer.e
    public void b(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(16854);
        super.b(surfaceTexture);
        TXCLog.w("TXCVideoRender", "play:vrender: quit render thread when onSurfaceRelease");
        e();
        AppMethodBeat.o(16854);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.liteav.renderer.e
    public void a(int i2, int i3) {
        AppMethodBeat.i(16855);
        super.a(i2, i3);
        if (this.C != null) {
            this.C.setVideoSize(i2, i3);
        }
        if (this.x != null) {
            this.x.a(i2, i3);
        }
        AppMethodBeat.o(16855);
    }

    /* access modifiers changed from: package-private */
    public void a(Object obj) {
        AppMethodBeat.i(16856);
        synchronized (this.E) {
            try {
                this.D = obj;
                TXCLog.w("TXCVideoRender", "play:vrender: TXCGLRender initTextureRender ".concat(String.valueOf(this)));
                o();
                if (this.f1121e != null) {
                    this.f1121e.a(this.f1122f, this.f1123g);
                    this.f1121e.b(this.f1124h, this.f1125i);
                }
                if (this.x != null) {
                    this.x.b();
                    this.w = new SurfaceTexture(this.x.a());
                    this.w.setOnFrameAvailableListener(this);
                }
                if (this.C != null) {
                    this.C.createTexture();
                }
                if (!(this.f1082b == null || this.C == null)) {
                    this.C.setHasFrameBuffer(this.f1124h, this.f1125i);
                }
                if (this.A != null) {
                    this.A.b();
                }
                if (this.o != null) {
                    this.o.onSurfaceTextureAvailable(this.w);
                }
            } finally {
                AppMethodBeat.o(16856);
            }
        }
    }

    private void o() {
        AppMethodBeat.i(222347);
        this.x = new c(true);
        this.C = new TXCYuvTextureRender();
        this.A = new c(false);
        AppMethodBeat.o(222347);
    }

    /* access modifiers changed from: package-private */
    public void b(Object obj) {
        AppMethodBeat.i(16858);
        synchronized (this.E) {
            try {
                if (this.D != obj) {
                    TXCLog.w("TXCVideoRender", "play:vrender: TXCGLRender destroyTextureRender ignore when not the same gl thread ".concat(String.valueOf(this)));
                    return;
                }
                this.D = null;
                TXCLog.w("TXCVideoRender", "play:vrender: TXCGLRender destroyTextureRender ".concat(String.valueOf(this)));
                try {
                    if (this.o != null) {
                        this.o.onSurfaceTextureDestroy(this.w);
                    }
                } catch (Exception e2) {
                    TXCLog.e("TXCVideoRender", "callback failed.", e2);
                }
                if (this.x != null) {
                    this.x.c();
                    this.x = null;
                }
                if (this.C != null) {
                    this.C.onSurfaceDestroy();
                    this.C = null;
                }
                if (this.A != null) {
                    this.A.c();
                    this.A = null;
                }
                this.w = null;
                if (this.F != null) {
                    this.F.c();
                    this.F = null;
                }
                if (this.G != null) {
                    this.G.onSurfaceDestroy();
                    this.G = null;
                }
                AppMethodBeat.o(16858);
            } finally {
                AppMethodBeat.o(16858);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        AppMethodBeat.i(16859);
        do {
        } while (a(this.H));
        boolean p = p();
        AppMethodBeat.o(16859);
        return p;
    }

    /* access modifiers changed from: package-private */
    public SurfaceTexture d() {
        AppMethodBeat.i(16860);
        if (this.f1120d != null) {
            SurfaceTexture surfaceTexture = this.f1120d.getSurfaceTexture();
            AppMethodBeat.o(16860);
            return surfaceTexture;
        }
        AppMethodBeat.o(16860);
        return null;
    }

    @Override // com.tencent.liteav.renderer.e
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.tencent.liteav.renderer.e
    public void c(Object obj) {
        AppMethodBeat.i(222348);
        synchronized (this.u) {
            try {
                if (this.v == null) {
                    this.v = new b(new WeakReference(this));
                    this.v.a(obj);
                    this.v.start();
                    this.v.c();
                    TXCLog.w("TXCVideoRender", "play:vrender: start render thread id " + getID() + ", glContext " + obj + ", " + this);
                } else {
                    TXCLog.w("TXCVideoRender", "play:vrender: start render thread when running " + getID() + ", " + this);
                }
            } finally {
                AppMethodBeat.o(222348);
            }
        }
    }

    @Override // com.tencent.liteav.renderer.e
    public void e() {
        AppMethodBeat.i(16861);
        synchronized (this.u) {
            try {
                if (this.v != null) {
                    this.v.b();
                    this.v.c();
                    this.v = null;
                    TXCLog.w("TXCVideoRender", "play:vrender: quit render thread id" + getID() + ", " + this);
                }
            } finally {
                AppMethodBeat.o(16861);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        r7 = r13.f1083c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        if (r2 == false) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
        if (r13.w == null) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        r13.w.updateTexImage();
        r13.w.getTransformMatrix(r13.z);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
        if (r13.f1081a == null) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        if (r13.x == null) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
        r13.f1081a.a(r13.x.a(), r13.z);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0053, code lost:
        if (r7 == null) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
        r1 = r13.x.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005d, code lost:
        if (r13.F != null) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005f, code lost:
        r13.F = new com.tencent.liteav.renderer.h(java.lang.Boolean.TRUE);
        r13.F.b();
        r13.F.a(true);
        r13.F.b(com.tencent.rtmp.TXLiveConstants.RENDER_ROTATION_180);
        r13.F.a(com.tencent.liteav.renderer.h.f1147a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0080, code lost:
        r13.F.a(r13.z);
        r13.F.b(r13.f1124h, r13.f1125i);
        r13.F.a(r13.f1124h, r13.f1125i);
        r7.onTextureProcess(r13.F.d(r1), i(), j(), r13.k);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ae, code lost:
        if (r13.l != 1) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b2, code lost:
        if (r13.x == null) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b4, code lost:
        a(r0, r13.x.a(), r13.z, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00df, code lost:
        if (r13.x == null) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e1, code lost:
        android.opengl.GLES20.glBindFramebuffer(36160, 0);
        r13.x.a(r13.w);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f0, code lost:
        if (r6 == null) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f4, code lost:
        if (r13.C == null) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f8, code lost:
        if (r13.f1082b == null) goto L_0x0165;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00fa, code lost:
        r13.C.setHasFrameBuffer(r13.f1124h, r13.f1125i);
        r2 = r13.C.drawToTexture(r6);
        r13.f1082b.onTextureProcess(r2, i(), j(), r13.k);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011a, code lost:
        if (r13.l != 1) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x011c, code lost:
        if (r2 != -1) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x011e, code lost:
        r13.C.setHasFrameBuffer(r13.f1124h, r13.f1125i);
        r2 = r13.C.drawToTexture(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x012d, code lost:
        a(r0, r2, (float[]) null, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0130, code lost:
        if (r7 == null) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0134, code lost:
        if (r13.G != null) goto L_0x0147;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0136, code lost:
        r13.G = new com.tencent.liteav.renderer.TXCYuvTextureRender();
        r13.G.createTexture();
        r13.G.flipVertical(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0147, code lost:
        r13.G.setHasFrameBuffer(r13.f1124h, r13.f1125i);
        r7.onTextureProcess(r13.G.drawToTexture(r6), i(), j(), r13.k);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0167, code lost:
        if (r13.l != 0) goto L_0x0174;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0169, code lost:
        android.opengl.GLES20.glBindFramebuffer(36160, 0);
        r13.C.drawFrame(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0174, code lost:
        r2 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0176, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        android.opengl.GLES20.glViewport(0, 0, g(), h());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if (r13.l != 1) goto L_0x0176;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        r0 = b();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean p() {
        /*
        // Method dump skipped, instructions count: 377
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.renderer.a.p():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(16864);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        r0.run();
        com.tencent.matrix.trace.core.AppMethodBeat.o(16864);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        if (r0 != null) goto L_0x0027;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.util.Queue<java.lang.Runnable> r4) {
        /*
            r3 = this;
            r1 = 0
            r2 = 16864(0x41e0, float:2.3631E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            monitor-enter(r4)
            boolean r0 = r4.isEmpty()     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x0013
            monitor-exit(r4)     // Catch:{ all -> 0x0021 }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            r0 = r1
        L_0x0012:
            return r0
        L_0x0013:
            java.lang.Object r0 = r4.poll()
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            monitor-exit(r4)
            if (r0 != 0) goto L_0x0027
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            r0 = r1
            goto L_0x0012
        L_0x0021:
            r0 = move-exception
            monitor-exit(r4)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        L_0x0027:
            r0.run()
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0012
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.renderer.a.a(java.util.Queue):boolean");
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(222350);
        synchronized (this) {
            try {
                this.y = true;
            } finally {
                AppMethodBeat.o(222350);
            }
        }
        synchronized (this.u) {
            try {
                if (this.v != null) {
                    this.v.c();
                }
            } finally {
                AppMethodBeat.o(222350);
            }
        }
    }

    @Override // java.lang.Object, com.tencent.liteav.basic.module.a
    public void finalize() {
        AppMethodBeat.i(16865);
        super.finalize();
        TXCLog.w("TXCVideoRender", "play:vrender: quit render thread when finalize");
        try {
            e();
            AppMethodBeat.o(16865);
        } catch (Exception e2) {
            TXCLog.e("TXCVideoRender", "quit render thread failed.", e2);
            AppMethodBeat.o(16865);
        }
    }
}
