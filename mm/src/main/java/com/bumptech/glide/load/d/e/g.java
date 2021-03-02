package com.bumptech.glide.load.d.e;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.e.f;
import com.bumptech.glide.i;
import com.bumptech.glide.j;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
public final class g {
    private final e aCj;
    final j aDc;
    private l<Bitmap> aId;
    final com.bumptech.glide.b.a aLR;
    private boolean aLS;
    private boolean aLT;
    private i<Bitmap> aLU;
    a aLV;
    boolean aLW;
    a aLX;
    Bitmap aLY;
    a aLZ;
    final List<b> callbacks;
    private final Handler handler;
    boolean isRunning;

    public interface b {
        void pN();
    }

    g(com.bumptech.glide.c cVar, com.bumptech.glide.b.a aVar, int i2, int i3, l<Bitmap> lVar, Bitmap bitmap) {
        this(cVar.aCj, com.bumptech.glide.c.ag(cVar.aCm.getBaseContext()), aVar, com.bumptech.glide.c.ag(cVar.aCm.getBaseContext()).nT().a(((f) ((f) f.b(com.bumptech.glide.load.b.j.aHa).pW()).pX()).aR(i2, i3)), lVar, bitmap);
        AppMethodBeat.i(77513);
        AppMethodBeat.o(77513);
    }

    private g(e eVar, j jVar, com.bumptech.glide.b.a aVar, i<Bitmap> iVar, l<Bitmap> lVar, Bitmap bitmap) {
        AppMethodBeat.i(77514);
        this.callbacks = new ArrayList();
        this.aDc = jVar;
        Handler handler2 = new Handler(Looper.getMainLooper(), new c());
        this.aCj = eVar;
        this.handler = handler2;
        this.aLU = iVar;
        this.aLR = aVar;
        a(lVar, bitmap);
        AppMethodBeat.o(77514);
    }

    /* access modifiers changed from: package-private */
    public final void a(b bVar) {
        AppMethodBeat.i(77516);
        if (this.aLW) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot subscribe to a cleared frame loader");
            AppMethodBeat.o(77516);
            throw illegalStateException;
        } else if (this.callbacks.contains(bVar)) {
            IllegalStateException illegalStateException2 = new IllegalStateException("Cannot subscribe twice in a row");
            AppMethodBeat.o(77516);
            throw illegalStateException2;
        } else {
            boolean isEmpty = this.callbacks.isEmpty();
            this.callbacks.add(bVar);
            if (isEmpty) {
                start();
            }
            AppMethodBeat.o(77516);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(b bVar) {
        AppMethodBeat.i(77517);
        this.callbacks.remove(bVar);
        if (this.callbacks.isEmpty()) {
            this.isRunning = false;
        }
        AppMethodBeat.o(77517);
    }

    /* access modifiers changed from: package-private */
    public final int getFrameCount() {
        AppMethodBeat.i(77518);
        int frameCount = this.aLR.getFrameCount();
        AppMethodBeat.o(77518);
        return frameCount;
    }

    private void start() {
        AppMethodBeat.i(77519);
        if (this.isRunning) {
            AppMethodBeat.o(77519);
            return;
        }
        this.isRunning = true;
        this.aLW = false;
        pP();
        AppMethodBeat.o(77519);
    }

    /* access modifiers changed from: package-private */
    public final Bitmap pO() {
        if (this.aLV != null) {
            return this.aLV.aMb;
        }
        return this.aLY;
    }

    private void pP() {
        AppMethodBeat.i(77520);
        if (!this.isRunning || this.aLS) {
            AppMethodBeat.o(77520);
            return;
        }
        if (this.aLT) {
            com.bumptech.glide.g.j.checkArgument(this.aLZ == null, "Pending target must be null when starting from the first frame");
            this.aLR.oh();
            this.aLT = false;
        }
        if (this.aLZ != null) {
            a aVar = this.aLZ;
            this.aLZ = null;
            a(aVar);
            AppMethodBeat.o(77520);
            return;
        }
        this.aLS = true;
        long of = ((long) this.aLR.of()) + SystemClock.uptimeMillis();
        this.aLR.advance();
        this.aLX = new a(this.handler, this.aLR.og(), of);
        this.aLU.a(f.g(pR())).Q(this.aLR).b(this.aLX);
        AppMethodBeat.o(77520);
    }

    /* access modifiers changed from: package-private */
    public final void pQ() {
        AppMethodBeat.i(77521);
        if (this.aLY != null) {
            this.aCj.g(this.aLY);
            this.aLY = null;
        }
        AppMethodBeat.o(77521);
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar) {
        AppMethodBeat.i(77522);
        this.aLS = false;
        if (this.aLW) {
            this.handler.obtainMessage(2, aVar).sendToTarget();
            AppMethodBeat.o(77522);
        } else if (!this.isRunning) {
            this.aLZ = aVar;
            AppMethodBeat.o(77522);
        } else {
            if (aVar.aMb != null) {
                pQ();
                a aVar2 = this.aLV;
                this.aLV = aVar;
                for (int size = this.callbacks.size() - 1; size >= 0; size--) {
                    this.callbacks.get(size).pN();
                }
                if (aVar2 != null) {
                    this.handler.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            pP();
            AppMethodBeat.o(77522);
        }
    }

    class c implements Handler.Callback {
        c() {
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(77512);
            if (message.what == 1) {
                g.this.a((a) message.obj);
                AppMethodBeat.o(77512);
                return true;
            }
            if (message.what == 2) {
                g.this.aDc.c((a) message.obj);
            }
            AppMethodBeat.o(77512);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends com.bumptech.glide.e.a.c<Bitmap> {
        private final long aMa;
        Bitmap aMb;
        private final Handler handler;
        final int index;

        @Override // com.bumptech.glide.e.a.e
        public final /* synthetic */ void aa(Object obj) {
            AppMethodBeat.i(77511);
            this.aMb = (Bitmap) obj;
            this.handler.sendMessageAtTime(this.handler.obtainMessage(1, this), this.aMa);
            AppMethodBeat.o(77511);
        }

        a(Handler handler2, int i2, long j2) {
            this.handler = handler2;
            this.index = i2;
            this.aMa = j2;
        }
    }

    private static com.bumptech.glide.load.g pR() {
        AppMethodBeat.i(77523);
        com.bumptech.glide.f.b bVar = new com.bumptech.glide.f.b(Double.valueOf(Math.random()));
        AppMethodBeat.o(77523);
        return bVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(l<Bitmap> lVar, Bitmap bitmap) {
        AppMethodBeat.i(77515);
        this.aId = (l) com.bumptech.glide.g.j.checkNotNull(lVar, "Argument must not be null");
        this.aLY = (Bitmap) com.bumptech.glide.g.j.checkNotNull(bitmap, "Argument must not be null");
        this.aLU = this.aLU.a(new f().a(lVar));
        AppMethodBeat.o(77515);
    }
}
