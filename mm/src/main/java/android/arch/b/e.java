package android.arch.b;

import android.arch.a.a.a;
import android.arch.b.d;
import android.arch.b.h;
import android.arch.lifecycle.ComputableLiveData;
import android.arch.lifecycle.LiveData;
import java.util.concurrent.Executor;

public final class e<Key, Value> {
    private Key ec;
    private h.d ed;
    private d.a<Key, Value> ee;
    private h.a ef;
    private Executor eg = a.U();

    public e(d.a<Key, Value> aVar, h.d dVar) {
        if (dVar == null) {
            throw new IllegalArgumentException("PagedList.Config must be provided");
        }
        this.ee = aVar;
        this.ed = dVar;
    }

    public final e<Key, Value> a(h.a<Value> aVar) {
        this.ef = aVar;
        return this;
    }

    public final e<Key, Value> a(Executor executor) {
        this.eg = executor;
        return this;
    }

    public final LiveData<h<Value>> as() {
        final Key key = this.ec;
        final h.d dVar = this.ed;
        final h.a aVar = this.ef;
        final d.a<Key, Value> aVar2 = this.ee;
        final Executor T = a.T();
        final Executor executor = this.eg;
        return new ComputableLiveData<h<Value>>(executor) {
            /* class android.arch.b.e.AnonymousClass1 */
            private d<Key, Value> dY;
            private h<Value> eh;
            private final d.b ei = new d.b() {
                /* class android.arch.b.e.AnonymousClass1.AnonymousClass1 */
            };

            /* JADX DEBUG: Multi-variable search result rejected for r0v22, resolved type: java.lang.Object */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.arch.lifecycle.ComputableLiveData
            public final /* synthetic */ Object compute() {
                Key aq = this.eh != null ? this.eh.aq() : (Key) key;
                do {
                    if (this.dY != null) {
                        this.dY.dW.remove(this.ei);
                    }
                    this.dY = aVar2.ar();
                    this.dY.dW.add(this.ei);
                    h.b bVar = new h.b(this.dY, dVar);
                    bVar.eO = T;
                    bVar.eg = executor;
                    bVar.ef = aVar;
                    bVar.eP = aq;
                    if (bVar.eO == null) {
                        throw new IllegalArgumentException("MainThreadExecutor required");
                    } else if (bVar.eg == null) {
                        throw new IllegalArgumentException("BackgroundThreadExecutor required");
                    } else {
                        this.eh = h.a(bVar.dY, bVar.eO, bVar.eg, bVar.ef, bVar.ed, bVar.eP);
                    }
                } while (this.eh.isDetached());
                return this.eh;
            }
        }.getLiveData();
    }
}
