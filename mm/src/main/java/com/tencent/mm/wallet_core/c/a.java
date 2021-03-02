package com.tencent.mm.wallet_core.c;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public abstract class a<K extends dpc, P extends c<K>> {
    protected MutableLiveData<K> Rtg = new MutableLiveData<>();
    protected MutableLiveData<K> Rth = new MutableLiveData<>();
    protected List<AbstractC2168a<K>> callbacks = new ArrayList();
    protected P iLD;
    protected boolean zjy = false;

    /* renamed from: com.tencent.mm.wallet_core.c.a$a  reason: collision with other inner class name */
    public interface AbstractC2168a<K> {
        void d(K k, int i2, int i3);

        void dx(K k);
    }

    /* access modifiers changed from: protected */
    public abstract void b(c.a<K> aVar);

    /* access modifiers changed from: protected */
    public abstract K efb();

    public final void a(AbstractC2168a<K> aVar, long j2) {
        Log.i("MicroMsg.AsyncCgiLoader", "try do cgi: %s, %s", Boolean.TRUE, Long.valueOf(j2));
        if (j2 <= 0) {
            a((AbstractC2168a) aVar, true);
        } else {
            h.RTc.o(new Runnable(aVar, true) {
                /* class com.tencent.mm.wallet_core.c.a.AnonymousClass1 */
                final /* synthetic */ AbstractC2168a Rti;
                final /* synthetic */ boolean Rtj = true;

                {
                    this.Rti = r3;
                }

                public final void run() {
                    AppMethodBeat.i(163879);
                    a.this.a((a) this.Rti, (AbstractC2168a) this.Rtj);
                    AppMethodBeat.o(163879);
                }
            }, j2);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(AbstractC2168a<K> aVar, boolean z) {
        K efb = efb();
        boolean z2 = efb != null;
        if (z2) {
            if (aVar != null) {
                aVar.dx(efb);
            }
            this.Rtg.postValue(efb);
        }
        if (!z2 || z) {
            if (aVar != null && !this.callbacks.contains(aVar)) {
                this.callbacks.add(aVar);
            }
            hhi();
        }
    }

    private void hhi() {
        Log.i("MicroMsg.AsyncCgiLoader", "trigger cgi: %s", Boolean.valueOf(this.zjy));
        if (!this.zjy) {
            this.zjy = true;
            P p = this.iLD;
            Assert.assertNotNull("cgi must not be null", p);
            p.aYI().h(new com.tencent.mm.vending.c.a<c.a<K>, c.a<K>>() {
                /* class com.tencent.mm.wallet_core.c.a.AnonymousClass3 */

                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(163880);
                    c.a<K> aVar = (c.a) obj;
                    a.this.b(aVar);
                    AppMethodBeat.o(163880);
                    return aVar;
                }
            }).b(new com.tencent.mm.vending.c.a<Object, c.a<K>>() {
                /* class com.tencent.mm.wallet_core.c.a.AnonymousClass2 */

                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(72722);
                    a.this.zjy = false;
                    a.a(a.this, (c.a) obj);
                    AppMethodBeat.o(72722);
                    return null;
                }
            });
        }
    }

    public final void cancel() {
        if (this.iLD != null) {
            this.iLD.cancel();
        }
    }

    public final void b(P p) {
        this.iLD = p;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [T extends com.tencent.mm.protocal.protobuf.dpc, java.lang.Object] */
    static /* synthetic */ void a(a aVar, c.a aVar2) {
        for (int size = aVar.callbacks.size() - 1; size >= 0; size--) {
            AbstractC2168a<K> aVar3 = aVar.callbacks.get(size);
            aVar3.d(aVar2.iLC, aVar2.errCode, aVar2.errType);
            aVar.callbacks.remove(aVar3);
        }
        aVar.Rth.setValue(aVar2.iLC);
    }
}
