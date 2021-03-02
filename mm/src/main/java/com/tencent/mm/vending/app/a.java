package com.tencent.mm.vending.app;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.base.Vending;
import com.tencent.mm.vending.base.a;
import com.tencent.mm.vending.e.c;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a implements com.tencent.mm.vending.e.b {
    public c<Vending> QYN = new c<>();
    Map<Class, AbstractC2149a> QYO = new ConcurrentHashMap();
    byte[] QYP = new byte[0];
    com.tencent.mm.vending.base.a<Object> QYQ = new com.tencent.mm.vending.base.a<Object>() {
        /* class com.tencent.mm.vending.app.a.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.vending.base.Vending, com.tencent.mm.vending.base.a
        public final /* synthetic */ Object resolveAsynchronous(Class<?> cls) {
            AppMethodBeat.i(74890);
            Object bl = bl(cls);
            AppMethodBeat.o(74890);
            return bl;
        }

        @Override // com.tencent.mm.vending.base.a
        public final Object bl(Class<?> cls) {
            AppMethodBeat.i(74889);
            AbstractC2149a aVar = a.this.QYO.get(cls);
            if (aVar != null) {
                aVar.QYX = true;
                Object bmp = aVar.bmp();
                aVar.QYX = false;
                if (aVar.QYW) {
                    aVar.QYY = defer(cls);
                } else {
                    AppMethodBeat.o(74889);
                    return bmp;
                }
            }
            AppMethodBeat.o(74889);
            return null;
        }
    };
    private AtomicBoolean QYR = new AtomicBoolean(false);
    volatile boolean QYS = false;
    Map<Class, com.tencent.mm.vending.b.c<b>> QYT = new HashMap();
    public com.tencent.mm.vending.d.a QYU;
    Context mContext;
    private c rfv = new c();

    public interface b<_Struct> {
        void co(_Struct _struct);
    }

    /* renamed from: com.tencent.mm.vending.app.a$a  reason: collision with other inner class name */
    public abstract class AbstractC2149a<_Struct> {
        boolean QYW = false;
        boolean QYX = false;
        Vending.h QYY;

        /* access modifiers changed from: protected */
        public abstract _Struct bmp();

        public AbstractC2149a() {
        }
    }

    public a() {
        this.QYN.keep(this.QYQ);
        this.QYQ.addVendingDataResolvedCallback(new a.AbstractC2150a() {
            /* class com.tencent.mm.vending.app.a.AnonymousClass2 */

            @Override // com.tencent.mm.vending.base.Vending.e
            public final /* synthetic */ void eh(Object obj) {
                AppMethodBeat.i(74895);
                Class cls = (Class) obj;
                com.tencent.mm.vending.b.c<b> cVar = a.this.QYT.get(cls);
                if (cVar != null) {
                    cVar.invoke(g.eo(a.this.QYQ.get(cls)));
                }
                AppMethodBeat.o(74895);
            }
        });
    }

    @Override // com.tencent.mm.vending.e.b
    public void keep(com.tencent.mm.vending.e.a aVar) {
        this.rfv.keep(aVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.tencent.mm.vending.app.a$b<_Struct> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <_Struct> void a(Class<_Struct> cls, b<_Struct> bVar) {
        com.tencent.mm.vending.b.c<b> cVar = this.QYT.get(cls);
        if (cVar == null) {
            cVar = new com.tencent.mm.vending.b.c<b>(d.UI) {
                /* class com.tencent.mm.vending.app.a.AnonymousClass3 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.vending.j.a] */
                @Override // com.tencent.mm.vending.b.c
                public final /* synthetic */ void a(b bVar, com.tencent.mm.vending.j.a aVar) {
                    AppMethodBeat.i(74888);
                    bVar.co(aVar.get(0));
                    AppMethodBeat.o(74888);
                }
            };
            this.QYT.put(cls, cVar);
        }
        cVar.add(bVar);
        Object peek = this.QYQ.peek(cls);
        if (peek != null) {
            bVar.co(peek);
        }
    }

    public final <_Struct> _Struct y(Class<_Struct> cls) {
        hdo();
        if (Looper.myLooper() == Looper.getMainLooper() && !this.QYS) {
            synchronized (this.QYP) {
                if (!this.QYS) {
                    try {
                        this.QYP.wait();
                    } catch (InterruptedException e2) {
                        com.tencent.mm.vending.f.a.printErrStackTrace("Vending.Interactor", e2, "", new Object[0]);
                    }
                }
            }
        }
        return (_Struct) this.QYQ.get(cls);
    }

    public final void bk(Class<?> cls) {
        hdo();
        this.QYQ.request(cls);
    }

    /* access modifiers changed from: protected */
    public final <_Struct> void a(Class<_Struct> cls, AbstractC2149a<_Struct> aVar) {
        hdo();
        this.QYO.put(cls, aVar);
    }

    private void hdo() {
        if (Looper.myLooper() == this.QYQ.getLooper() && !this.QYR.get()) {
            com.tencent.mm.vending.f.a.e("Vending.Interactor", "This interactor has not call onCreate() yet! Interactor : %s", this);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        this.QYR.set(true);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.rfv.dead();
        this.QYN.dead();
    }
}
