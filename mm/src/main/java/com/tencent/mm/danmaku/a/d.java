package com.tencent.mm.danmaku.a;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build;
import android.os.Message;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.a.g;
import com.tencent.mm.danmaku.c.m;
import com.tencent.mm.danmaku.d.b;
import com.tencent.mm.danmaku.d.c;
import com.tencent.mm.danmaku.d.f;
import com.tencent.mm.danmaku.d.g;
import com.tencent.mm.danmaku.d.h;
import com.tencent.mm.danmaku.render.NativeDanmakuView;
import com.tencent.mm.danmaku.render.d;
import com.tencent.mm.danmaku.render.e;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.Util;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public final class d implements View.OnTouchListener, d.a {
    private static final DecimalFormat gNV = new DecimalFormat("00.00");
    private static final DecimalFormat gNW = new DecimalFormat("00");
    volatile boolean gNB;
    private volatile boolean gNC;
    private volatile boolean gND;
    private final com.tencent.mm.danmaku.render.d gNE;
    final e gNF;
    final f gNG;
    final h gNH;
    private long gNI;
    long gNJ;
    boolean gNK;
    private volatile boolean gNL = true;
    private long gNM;
    private long gNN;
    private long gNO;
    int gNP;
    int gNQ;
    int gNR;
    private String gNS;
    private long gNT;
    private long gNU;
    final Queue<h> gNX = new LinkedBlockingDeque();
    private final List<com.tencent.mm.danmaku.b.a> gNY = new LinkedList();
    final a gNZ;
    com.tencent.mm.danmaku.c.a gNt;
    final b gNu;
    final f gNv;
    final c gNw;
    g.b gOa;
    private d.b gOb;
    i gOc;
    private Object gOd = new Object();
    private boolean gOe = true;
    private int gOf = 0;
    private a gOg;

    static /* synthetic */ void a(d dVar, Canvas canvas) {
        AppMethodBeat.i(241634);
        dVar.draw(canvas);
        AppMethodBeat.o(241634);
    }

    static /* synthetic */ boolean a(d dVar, b bVar) {
        boolean z;
        if (!dVar.gND || dVar.gNB) {
            z = false;
        } else {
            z = true;
        }
        return z && bVar.gQt != -1;
    }

    static {
        AppMethodBeat.i(241635);
        AppMethodBeat.o(241635);
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public class a implements Choreographer.FrameCallback {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b2) {
            this();
        }

        public final void doFrame(long j2) {
            AppMethodBeat.i(241605);
            if (d.this.asa()) {
                d.this.gOc.asq();
            }
            AppMethodBeat.o(241605);
        }
    }

    protected d(View view, com.tencent.mm.danmaku.c.a aVar) {
        com.tencent.mm.danmaku.render.d dVar;
        AppMethodBeat.i(241606);
        this.gNt = aVar;
        if (view instanceof SurfaceView) {
            dVar = new com.tencent.mm.danmaku.render.f((SurfaceView) view);
        } else if (view instanceof TextureView) {
            dVar = new com.tencent.mm.danmaku.render.g((TextureView) view);
        } else if (view instanceof NativeDanmakuView) {
            dVar = new e((NativeDanmakuView) view);
        } else {
            dVar = null;
        }
        this.gNE = dVar;
        if (this.gNE != null) {
            this.gNE.a(this);
            this.gNE.setOnTouchListener(this);
            this.gNv = new f();
            this.gNw = new c();
            this.gNu = new b();
            this.gNH = new h(aVar);
            g.a aVar2 = new g.a();
            this.gNF = new e(this.gNv, aVar2);
            this.gNZ = a.a(aVar, this.gNu, aVar2, this.gNv, this.gNw);
            this.gNG = new f(aVar);
            this.gOc = new i(this);
            if (this.gNE instanceof NativeDanmakuView) {
                this.gOc.gOC = 1;
            }
            if (Build.VERSION.SDK_INT < 16 || !(this.gNE instanceof NativeDanmakuView)) {
                this.gOf = 1;
            } else {
                this.gOf = 0;
            }
            if (this.gOf == 0) {
                this.gOg = new a(this, (byte) 0);
            }
            AppMethodBeat.o(241606);
            return;
        }
        RuntimeException runtimeException = new RuntimeException("root view not a IDanmakuView");
        AppMethodBeat.o(241606);
        throw runtimeException;
    }

    /* access modifiers changed from: protected */
    public final void c(Point point) {
        AppMethodBeat.i(241607);
        point.y = (int) (((float) point.y) - this.gNE.atd());
        h hVar = new h(this.gNw.gQv, point, 0);
        if (com.tencent.mm.danmaku.e.e.gQV >= 4) {
            com.tencent.mm.danmaku.e.e.v("DanmakuManager", "addClickPoint:", hVar);
        }
        this.gNX.add(hVar);
        this.gOc.sendMessage(10);
        AppMethodBeat.o(241607);
    }

    /* access modifiers changed from: protected */
    public final void resume() {
        AppMethodBeat.i(241608);
        com.tencent.mm.danmaku.e.e.v("DanmakuManager", "resume()");
        this.gOc.sendMessage(2);
        AppMethodBeat.o(241608);
    }

    /* access modifiers changed from: protected */
    public final void pause() {
        AppMethodBeat.i(241609);
        com.tencent.mm.danmaku.e.e.i("DanmakuManager", "pause()");
        this.gOc.sendMessage(3);
        AppMethodBeat.o(241609);
    }

    /* access modifiers changed from: protected */
    public final void clear() {
        AppMethodBeat.i(241610);
        com.tencent.mm.danmaku.e.e.v("DanmakuManager", "clear");
        this.gOc.sendMessage(9);
        if (this.gNF != null) {
            this.gNF.clear();
        }
        AppMethodBeat.o(241610);
    }

    /* access modifiers changed from: protected */
    public final void release() {
        AppMethodBeat.i(241611);
        com.tencent.mm.danmaku.e.e.v("DanmakuManager", "release() mIsQuited = " + this.gNB);
        if (!this.gNB) {
            com.tencent.mm.danmaku.e.e.v("DanmakuManager", "quit(); mIsQuited = true");
            this.gNB = true;
            this.gOc.sendMessage(6);
            if (arW()) {
                Choreographer.getInstance().removeFrameCallback(this.gOg);
            }
            asd();
        }
        this.gOc.sendMessage(8);
        this.gOa = null;
        AppMethodBeat.o(241611);
    }

    private void yX(long j2) {
        AppMethodBeat.i(241613);
        if (arW()) {
            AppMethodBeat.o(241613);
            return;
        }
        asd();
        if (asa()) {
            i iVar = this.gOc;
            if (iVar.asr()) {
                iVar.gOz.removeMessages(4);
                iVar.gOz.sendEmptyMessageDelayed(4, j2);
            }
        }
        AppMethodBeat.o(241613);
    }

    private boolean arW() {
        return this.gOf == 0 && this.gOg != null;
    }

    private boolean arX() {
        Canvas canvas;
        AppMethodBeat.i(241614);
        try {
            canvas = this.gNE.lockCanvas();
        } catch (Throwable th) {
            com.tencent.mm.danmaku.e.e.e("surface_lock", "draw exception " + ((Object) BuildConfig.COMMAND), th);
            canvas = null;
        }
        if (canvas != null) {
            draw(canvas);
            AppMethodBeat.o(241614);
            return true;
        }
        arY();
        AppMethodBeat.o(241614);
        return false;
    }

    private void draw(Canvas canvas) {
        AppMethodBeat.i(241615);
        if (canvas != null) {
            try {
                com.tencent.mm.danmaku.e.d.n(canvas);
                this.gNZ.h(canvas);
                k(canvas);
            } catch (Throwable th) {
                com.tencent.mm.danmaku.e.e.e("surface_lock", "unlockCanvas exception " + canvas.hashCode(), th);
                AppMethodBeat.o(241615);
                return;
            }
        }
        try {
            j(canvas);
            AppMethodBeat.o(241615);
        } catch (Throwable th2) {
            com.tencent.mm.danmaku.e.e.e("surface_lock", "unlockCanvas exception " + canvas.hashCode(), th2);
            AppMethodBeat.o(241615);
        }
    }

    private void j(Canvas canvas) {
        AppMethodBeat.i(241616);
        if (canvas != null) {
            if (this.gND) {
                this.gNE.unlockCanvasAndPost(canvas);
                AppMethodBeat.o(241616);
                return;
            }
            this.gNE.unlock();
        }
        AppMethodBeat.o(241616);
    }

    private void arY() {
        AppMethodBeat.i(241617);
        asd();
        if (this.gOb == null) {
            this.gOb = new d.b() {
                /* class com.tencent.mm.danmaku.a.d.AnonymousClass1 */

                @Override // com.tencent.mm.danmaku.render.d.b
                public final void l(Canvas canvas) {
                    AppMethodBeat.i(241601);
                    d.a(d.this, canvas);
                    synchronized (d.this.gOd) {
                        try {
                            d.this.gOe = true;
                            d.this.gOd.notifyAll();
                        } catch (Throwable th) {
                            AppMethodBeat.o(241601);
                            throw th;
                        }
                    }
                    d.this.gOc.sendMessage(12);
                    AppMethodBeat.o(241601);
                }
            };
        }
        this.gNE.a(this.gOb);
        synchronized (this.gOd) {
            while (!this.gOe && asa()) {
                try {
                    try {
                        this.gOd.wait(200);
                    } catch (InterruptedException e2) {
                        if (!asa()) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                    }
                } finally {
                    AppMethodBeat.o(241617);
                }
            }
            this.gOe = false;
        }
    }

    private void arZ() {
        AppMethodBeat.i(241618);
        this.gNY.addAll(this.gNZ.arS());
        this.gNZ.arT();
        for (com.tencent.mm.danmaku.b.a aVar : this.gNY) {
            Bitmap asJ = aVar.asJ();
            if (asJ != null) {
                aVar.w(null);
                aVar.asL();
                this.gNu.gNx.x(asJ);
            }
        }
        for (com.tencent.mm.danmaku.b.a aVar2 : this.gNY) {
            this.gNt.e(aVar2).h(aVar2);
            f fVar = this.gNG;
            int type = aVar2.getType();
            BlockingQueue<com.tencent.mm.danmaku.b.a> blockingQueue = fVar.gOp.get(type);
            if (blockingQueue == null) {
                blockingQueue = new LinkedBlockingQueue<>();
                fVar.gOp.put(type, blockingQueue);
            }
            if (300 > blockingQueue.size()) {
                blockingQueue.add(aVar2);
            }
        }
        this.gNY.clear();
        AppMethodBeat.o(241618);
    }

    private void k(Canvas canvas) {
        long j2;
        String zg;
        AppMethodBeat.i(241619);
        if (com.tencent.mm.danmaku.e.e.gQV >= 4) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j3 = uptimeMillis - this.gNM;
            this.gNP++;
            this.gNR = (int) (((long) this.gNR) + j3);
            if (j3 > ((long) (m.gPS + 1))) {
                this.gNQ++;
                if (com.tencent.mm.danmaku.e.e.gQV >= 5) {
                    com.tencent.mm.danmaku.e.e.w("DanmakuManager", "a draw block:".concat(String.valueOf(j3)));
                }
            }
            com.tencent.mm.danmaku.b.a asl = this.gNF.asl();
            if (this.gNP % 60 == 1) {
                StringBuilder append = new StringBuilder().append(com.tencent.mm.danmaku.e.e.gQV).append(",t:").append(com.tencent.mm.danmaku.e.c.zg(SystemClock.uptimeMillis())).append(",f:");
                if (this.gNw.gQw == 0) {
                    j2 = 1;
                } else {
                    j2 = this.gNw.gQw;
                }
                StringBuilder append2 = append.append(1000 / j2).append(",ds:").append(this.gNZ.arR()).append(",ts:").append(this.gNF.gOl.mSize).append(",mt:").append(gNW.format(this.gNN - this.gNM)).append(",lt:").append(gNW.format(this.gNO - this.gNN)).append(",dt:").append(gNW.format(uptimeMillis - this.gNO)).append(",tt:").append(gNW.format(j3)).append(",jp:").append(gNV.format((double) ((((float) this.gNQ) * 100.0f) / ((float) this.gNP)))).append("%,at:").append(gNV.format((double) (((float) this.gNR) / ((float) this.gNP)))).append(",fd:");
                if (asl == null) {
                    zg = BuildConfig.COMMAND;
                } else {
                    zg = com.tencent.mm.danmaku.e.c.zg(asl.getTime());
                }
                this.gNS = append2.append(zg).append(",cs:").append(gNV.format((double) ((((float) this.gNu.gNx.gQp) / 1024.0f) / 1024.0f))).append(",uc:").append(gNV.format((double) ((((float) this.gNu.gNx.gQr) * 100.0f) / ((float) this.gNu.gNx.gQq)))).toString();
            }
            if (this.gNS != null) {
                com.tencent.mm.danmaku.e.d.a(canvas, this.gNS);
            }
        }
        AppMethodBeat.o(241619);
    }

    /* access modifiers changed from: protected */
    public final boolean asa() {
        AppMethodBeat.i(241620);
        boolean z = this.gND && !this.gNB && this.gNC;
        com.tencent.mm.danmaku.e.e.v("DanmakuManager", "isPrepared() = " + z + ", mIsSurfaceCreated = " + this.gND + ", mIsQuited = " + this.gNB + ", mIsPlaying = " + this.gNC);
        AppMethodBeat.o(241620);
        return z;
    }

    /* access modifiers changed from: protected */
    public final boolean isPlaying() {
        AppMethodBeat.i(241621);
        boolean z = !this.gNB && this.gNC;
        com.tencent.mm.danmaku.e.e.d("DanmakuManager", "isPlaying() = " + z + " : mIsQuited = " + this.gNB + ", mIsPlaying = " + this.gNC);
        AppMethodBeat.o(241621);
        return z;
    }

    /* access modifiers changed from: protected */
    public final void asb() {
        AppMethodBeat.i(241622);
        com.tencent.mm.danmaku.e.e.i("DanmakuManager", "handleResume()");
        if (!this.gNC) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.gNI = uptimeMillis - this.gNJ;
            if (com.tencent.mm.danmaku.e.e.gQV >= 5) {
                com.tencent.mm.danmaku.e.e.d("DanmakuManager", "handleResume, mBaseTime = " + this.gNI + ", currentTime = " + uptimeMillis + ", mPauseTime = " + this.gNJ);
            }
            this.gNw.gNI = SystemClock.uptimeMillis();
        }
        this.gNC = true;
        this.gNS = null;
        asc();
        if (com.tencent.mm.danmaku.e.e.gQV >= 5) {
            com.tencent.mm.danmaku.e.e.d("DanmakuManager", "message resume:mPausedTime:", Long.valueOf(this.gNJ), ",mBaseTime:", Long.valueOf(this.gNI));
        }
        AppMethodBeat.o(241622);
    }

    private void asc() {
        AppMethodBeat.i(241623);
        com.tencent.mm.danmaku.e.e.v("DanmakuManager", "resumeUpdateMessage()");
        if (isPlaying()) {
            this.gOc.asq();
        }
        AppMethodBeat.o(241623);
    }

    private void asd() {
        AppMethodBeat.i(241624);
        com.tencent.mm.danmaku.e.e.v("DanmakuManager", "removeUpdateMessage()");
        this.gOc.asp();
        AppMethodBeat.o(241624);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    public final void ase() {
        AppMethodBeat.i(241625);
        com.tencent.mm.danmaku.e.e.v("DanmakuManager", "handleUpdate()");
        asd();
        if (asa()) {
            if (arW()) {
                Choreographer.getInstance().postFrameCallback(this.gOg);
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            if (arV()) {
                yX((uptimeMillis + ((long) m.gPS)) - SystemClock.uptimeMillis());
            }
        }
        AppMethodBeat.o(241625);
    }

    /* access modifiers changed from: protected */
    public final void asf() {
        long j2;
        AppMethodBeat.i(241626);
        com.tencent.mm.danmaku.e.e.i("DanmakuManager", "handlePause()");
        asd();
        this.gNC = false;
        if (this.gNt.isLive()) {
            j2 = this.gNv.gQA;
        } else {
            j2 = this.gNw.gQv;
        }
        this.gNJ = j2;
        if (com.tencent.mm.danmaku.e.e.gQV >= 5) {
            com.tencent.mm.danmaku.e.e.v("DanmakuManager", "message pause:mPausedTime:", Long.valueOf(this.gNJ));
        }
        AppMethodBeat.o(241626);
    }

    /* access modifiers changed from: protected */
    public final void i(Message message) {
        AppMethodBeat.i(241627);
        com.tencent.mm.danmaku.e.e.i("DanmakuManager", "handleSeek() msg.obj is null = " + (message.obj == null));
        if (message.obj != null) {
            this.gNJ = ((Long) message.obj).longValue();
            this.gNK = true;
            asb();
        }
        if (com.tencent.mm.danmaku.e.e.gQV >= 5) {
            com.tencent.mm.danmaku.e.e.v("DanmakuManager", "message seek:startTime:", Long.valueOf(this.gNJ));
        }
        AppMethodBeat.o(241627);
    }

    @Override // com.tencent.mm.danmaku.render.d.a
    public final void asg() {
        AppMethodBeat.i(241628);
        com.tencent.mm.danmaku.e.e.i("surface_lock", "surfaceCreated");
        AppMethodBeat.o(241628);
    }

    @Override // com.tencent.mm.danmaku.render.d.a
    public final void ash() {
        AppMethodBeat.i(241629);
        com.tencent.mm.danmaku.e.e.i("surface_lock", "surfaceChanged");
        this.gND = true;
        asc();
        AppMethodBeat.o(241629);
    }

    @Override // com.tencent.mm.danmaku.render.d.a
    public final void asi() {
        AppMethodBeat.i(241630);
        this.gND = false;
        asd();
        com.tencent.mm.danmaku.e.e.i("surface_lock", "surfaceDestroyed");
        AppMethodBeat.o(241630);
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(241631);
        if (this.gNL) {
            if (com.tencent.mm.danmaku.e.e.gQV >= 4) {
                com.tencent.mm.danmaku.e.e.v("DanmakuManager", "onClick:", motionEvent);
            }
            if ((motionEvent.getAction() & 255) == 0) {
                c(new Point((int) motionEvent.getX(), (int) motionEvent.getY()));
            }
        }
        AppMethodBeat.o(241631);
        return false;
    }

    /* access modifiers changed from: protected */
    public final void asj() {
        AppMethodBeat.i(241632);
        arZ();
        yX(4);
        AppMethodBeat.o(241632);
    }

    /* access modifiers changed from: protected */
    public final void ask() {
        Object valueOf;
        AppMethodBeat.i(241633);
        com.tencent.mm.danmaku.e.e.i("surface_lock", "handleClearDrawingCache");
        asd();
        if (this.gND) {
            Object obj = null;
            try {
                Canvas lockCanvas = this.gNE.lockCanvas();
                StringBuilder sb = new StringBuilder("clearDrawing lockCanvas ");
                if (lockCanvas == null) {
                    valueOf = BuildConfig.COMMAND;
                } else {
                    valueOf = Integer.valueOf(lockCanvas.hashCode());
                }
                com.tencent.mm.danmaku.e.e.i("surface_lock", sb.append(valueOf).toString());
                if (lockCanvas != null) {
                    com.tencent.mm.danmaku.e.d.n(lockCanvas);
                }
                if (lockCanvas != null) {
                    try {
                        this.gNE.unlockCanvasAndPost(lockCanvas);
                        com.tencent.mm.danmaku.e.e.i("surface_lock", "clearDrawing unlockCanvas " + lockCanvas.hashCode());
                    } catch (Throwable th) {
                        com.tencent.mm.danmaku.e.e.e("surface_lock", "clearDrawing unlockCanvasAndPost exception: " + lockCanvas.hashCode(), th);
                        AppMethodBeat.o(241633);
                        return;
                    }
                }
                AppMethodBeat.o(241633);
            } catch (Throwable th2) {
                com.tencent.mm.danmaku.e.e.e("surface_lock", "clearDrawing unlockCanvasAndPost exception: " + obj.hashCode(), th2);
                AppMethodBeat.o(241633);
            }
        } else {
            AppMethodBeat.o(241633);
        }
    }

    private boolean arV() {
        long j2;
        boolean z;
        Throwable th;
        int size;
        boolean z2;
        AppMethodBeat.i(241612);
        f fVar = this.gNv;
        if (this.gNt.isLive()) {
            j2 = SystemClock.uptimeMillis() - this.gNI;
        } else {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis - this.gNT >= 200) {
                this.gNT = uptimeMillis;
                j2 = this.gNt.asQ();
                this.gNU = j2;
            } else {
                j2 = (uptimeMillis + this.gNU) - this.gNT;
            }
        }
        fVar.gQA = j2;
        c cVar = this.gNw;
        cVar.gQw = SystemClock.uptimeMillis() - cVar.gNI;
        cVar.gQv += cVar.gQw;
        cVar.gNI = SystemClock.uptimeMillis();
        if (com.tencent.mm.danmaku.e.e.gQV >= 5) {
            com.tencent.mm.danmaku.e.e.v("DanmakuManager", "updateFrame:currentTime:", Long.valueOf(this.gNw.gQv), ",lastInterval:", Long.valueOf(this.gNw.gQw));
        }
        if (this.gNK) {
            this.gNZ.arQ();
            this.gNK = false;
        }
        try {
            if (com.tencent.mm.danmaku.e.e.gQV >= 4) {
                this.gNM = SystemClock.uptimeMillis();
            }
            e eVar = this.gNF;
            eVar.asm();
            com.tencent.mm.danmaku.d.g<com.tencent.mm.danmaku.b.a> gVar = eVar.gOl;
            long j3 = eVar.gNv.gQA;
            List<com.tencent.mm.danmaku.b.a> list = eVar.gOk;
            g.a<T> aVar = gVar.gQB.gQD;
            int i2 = 0;
            while (i2 < 3 && aVar != gVar.gQB && gVar.gQC.m(aVar.mData, j3) <= 0) {
                if (list != null) {
                    list.add(aVar.mData);
                    i2++;
                }
                gVar.mSize--;
                aVar = aVar.gQD;
            }
            if (c.gNA && com.tencent.mm.danmaku.f.d.isEmpty(list)) {
                if (gVar.gQB.gQD == gVar.gQB) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2 && (aVar.mData instanceof com.tencent.mm.danmaku.b.a)) {
                    T t = aVar.mData;
                    long abs = Math.abs(t.getTime() - j3);
                    if (abs > Util.MILLSECONDS_OF_MINUTE) {
                        com.tencent.mm.danmaku.e.e.w("DanmakuDataSource", "Danmaku upload to screen fail, deltaTime = " + abs + " , curTime = " + j3 + ", curDanmaku = " + ((Object) t));
                    }
                }
            }
            gVar.gQB.gQD = aVar;
            aVar.gQE = gVar.gQB;
            eVar.aa(eVar.gOk);
            eVar.asn();
            List<com.tencent.mm.danmaku.b.a> list2 = eVar.gOk;
            if (com.tencent.mm.danmaku.e.e.gQV >= 4 && (size = list2.size()) > 0) {
                com.tencent.mm.danmaku.e.e.d("DanmakuManager", "new danmaku to draw:", Integer.valueOf(size));
            }
            Iterator<com.tencent.mm.danmaku.b.a> it = list2.iterator();
            while (it.hasNext()) {
                com.tencent.mm.danmaku.b.a next = it.next();
                it.remove();
                com.tencent.mm.danmaku.e.e.i("DanmakuManager", "upload, danmaku = ".concat(String.valueOf(next)));
                if (next.yY(this.gNv.gQA)) {
                    if (com.tencent.mm.danmaku.e.e.gQV >= 4) {
                        com.tencent.mm.danmaku.e.e.d("DanmakuManager", "before measure ", next, " is out side");
                    }
                    this.gNY.add(next);
                } else {
                    if (com.tencent.mm.danmaku.e.e.gQV >= 4 && next.asM()) {
                        com.tencent.mm.danmaku.e.e.d("MustShowDMComment", "不可淘汰弹幕从数据源的绘制列表中取出加入到Window中:".concat(String.valueOf(next)));
                    }
                    next.ze(this.gNw.gQv);
                    this.gNZ.a(next);
                }
            }
            if (com.tencent.mm.danmaku.e.e.gQV >= 4) {
                this.gNN = SystemClock.uptimeMillis();
            }
            this.gNZ.layout();
            if (com.tencent.mm.danmaku.e.e.gQV >= 4) {
                this.gNO = SystemClock.uptimeMillis();
            }
            z = arX();
            if (z) {
                try {
                    arZ();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z = true;
            com.tencent.mm.danmaku.e.e.e("DanmakuManager", th.toString(), th);
            AppMethodBeat.o(241612);
            return z;
        }
        AppMethodBeat.o(241612);
        return z;
    }
}
