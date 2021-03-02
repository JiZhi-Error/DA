package com.b.a.a;

import android.net.wifi.ScanResult;
import android.os.Handler;
import com.b.a.a.ab;
import com.b.a.a.d;
import com.b.a.a.k;
import com.b.a.a.r;
import com.b.a.a.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.List;

abstract class b extends a {
    private z chq;

    /* access modifiers changed from: package-private */
    public abstract void a(double d2, double d3, int i2, int i3, int i4, int i5, int i6, float f2, long j2, long j3);

    /* access modifiers changed from: package-private */
    public abstract void a(float f2, float f3, int i2, float f4, float f5, float f6, long j2);

    /* access modifiers changed from: package-private */
    public abstract void a(int i2, String str, long j2, long j3);

    /* access modifiers changed from: package-private */
    public abstract void a(x xVar, long j2, long j3);

    /* access modifiers changed from: package-private */
    public abstract void a(List<ScanResult> list, long j2, long j3);

    b() {
        super(ab.JD(), r.Jg(), u.Jx(), k.Jc());
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.d
    public synchronized void a(Handler handler, d.a aVar) {
        if (handler == null) {
            throw new Exception("CoreAssembly: master thread handler must be specified and cannot be null");
        }
        this.chq = z.b(handler);
        super.a(handler, aVar);
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.a
    public final void a(Handler handler, Handler[] handlerArr) {
        handlerArr[0] = handler;
        handlerArr[1] = null;
        handlerArr[2] = handler;
        handlerArr[3] = handler;
    }

    /* access modifiers changed from: package-private */
    @Override // com.b.a.a.a
    public final void a(d.a aVar, d.a[] aVarArr) {
        aVarArr[0] = aVar;
        aVarArr[1] = null;
        aVarArr[2] = null;
        aVarArr[3] = a(aVar);
    }

    @Override // com.b.a.a.m
    public void a(p pVar) {
        switch (pVar.what) {
            case 101:
                a(((ab.a) pVar).cnJ, pVar.cke, pVar.ckf);
                return;
            case 201:
                b(pVar);
                return;
            case 202:
                b(pVar);
                return;
            case 301:
                u.e eVar = (u.e) pVar;
                a(eVar.x, eVar.y, eVar.cmD, eVar.cmB, eVar.cmC, eVar.bdN, eVar.ckf);
                return;
            case 401:
                k.b bVar = (k.b) pVar;
                a(bVar.lat, bVar.lng, Double.valueOf(bVar.cjm).intValue(), Math.round(bVar.cjn), Math.round(bVar.bdN), bVar.cjp, bVar.cjq, bVar.cjo, bVar.cjr, bVar.ckf);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: package-private */
    public k.a a(d.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new k.a(Math.max(aVar.chx, 10000L));
    }

    private void b(p pVar) {
        if (this.chq != null) {
            try {
                this.chq.execute(new a(this, pVar, (byte) 0));
            } catch (Exception e2) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class a implements Runnable {
        private final WeakReference<b> chr;
        private final p chs;

        private a(b bVar, p pVar) {
            AppMethodBeat.i(88017);
            if (bVar == null || pVar == null) {
                Exception exc = new Exception("CoreAssembly: HandleMsgTask: null arg");
                AppMethodBeat.o(88017);
                throw exc;
            }
            this.chr = new WeakReference<>(bVar);
            this.chs = pVar;
            AppMethodBeat.o(88017);
        }

        /* synthetic */ a(b bVar, p pVar, byte b2) {
            this(bVar, pVar);
        }

        public final void run() {
            AppMethodBeat.i(88018);
            b bVar = this.chr.get();
            if (bVar != null) {
                switch (this.chs.what) {
                    case 202:
                        r.f fVar = (r.f) this.chs;
                        if (fVar.resultCode != 1) {
                            bVar.a(fVar.resultCode, fVar.message, fVar.cke, fVar.ckf);
                            break;
                        } else {
                            bVar.a(fVar.ckB, fVar.cke, fVar.ckf);
                            AppMethodBeat.o(88018);
                            return;
                        }
                }
            }
            AppMethodBeat.o(88018);
        }
    }
}
