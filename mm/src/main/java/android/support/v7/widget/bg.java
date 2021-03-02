package android.support.v7.widget;

import android.support.v4.e.g;
import android.support.v4.e.l;
import android.support.v7.widget.RecyclerView;

/* access modifiers changed from: package-private */
public final class bg {
    final android.support.v4.e.a<RecyclerView.v, a> azU = new android.support.v4.e.a<>();
    final g<RecyclerView.v> azV = new g<>();

    /* access modifiers changed from: package-private */
    public interface b {
        void a(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);

        void b(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);

        void c(RecyclerView.v vVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);

        void j(RecyclerView.v vVar);
    }

    bg() {
    }

    /* access modifiers changed from: package-private */
    public final void clear() {
        this.azU.clear();
        this.azV.clear();
    }

    /* access modifiers changed from: package-private */
    public final void b(RecyclerView.v vVar, RecyclerView.f.c cVar) {
        a aVar = this.azU.get(vVar);
        if (aVar == null) {
            aVar = a.nm();
            this.azU.put(vVar, aVar);
        }
        aVar.azW = cVar;
        aVar.flags |= 4;
    }

    /* access modifiers changed from: package-private */
    public final boolean G(RecyclerView.v vVar) {
        a aVar = this.azU.get(vVar);
        return (aVar == null || (aVar.flags & 1) == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final RecyclerView.f.c d(RecyclerView.v vVar, int i2) {
        a valueAt;
        RecyclerView.f.c cVar = null;
        int indexOfKey = this.azU.indexOfKey(vVar);
        if (!(indexOfKey < 0 || (valueAt = this.azU.valueAt(indexOfKey)) == null || (valueAt.flags & i2) == 0)) {
            valueAt.flags &= i2 ^ -1;
            if (i2 == 4) {
                cVar = valueAt.azW;
            } else if (i2 == 8) {
                cVar = valueAt.azX;
            } else {
                throw new IllegalArgumentException("Must provide flag PRE or POST");
            }
            if ((valueAt.flags & 12) == 0) {
                this.azU.removeAt(indexOfKey);
                a.a(valueAt);
            }
        }
        return cVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(long j2, RecyclerView.v vVar) {
        this.azV.put(j2, vVar);
    }

    /* access modifiers changed from: package-private */
    public final void c(RecyclerView.v vVar, RecyclerView.f.c cVar) {
        a aVar = this.azU.get(vVar);
        if (aVar == null) {
            aVar = a.nm();
            this.azU.put(vVar, aVar);
        }
        aVar.flags |= 2;
        aVar.azW = cVar;
    }

    /* access modifiers changed from: package-private */
    public final boolean H(RecyclerView.v vVar) {
        a aVar = this.azU.get(vVar);
        return (aVar == null || (aVar.flags & 4) == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final RecyclerView.v n(long j2) {
        return this.azV.get(j2, null);
    }

    /* access modifiers changed from: package-private */
    public final void d(RecyclerView.v vVar, RecyclerView.f.c cVar) {
        a aVar = this.azU.get(vVar);
        if (aVar == null) {
            aVar = a.nm();
            this.azU.put(vVar, aVar);
        }
        aVar.azX = cVar;
        aVar.flags |= 8;
    }

    /* access modifiers changed from: package-private */
    public final void I(RecyclerView.v vVar) {
        a aVar = this.azU.get(vVar);
        if (aVar == null) {
            aVar = a.nm();
            this.azU.put(vVar, aVar);
        }
        aVar.flags |= 1;
    }

    /* access modifiers changed from: package-private */
    public final void J(RecyclerView.v vVar) {
        a aVar = this.azU.get(vVar);
        if (aVar != null) {
            aVar.flags &= -2;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(b bVar) {
        for (int size = this.azU.size() - 1; size >= 0; size--) {
            RecyclerView.v keyAt = this.azU.keyAt(size);
            a removeAt = this.azU.removeAt(size);
            if ((removeAt.flags & 3) == 3) {
                bVar.j(keyAt);
            } else if ((removeAt.flags & 1) != 0) {
                if (removeAt.azW == null) {
                    bVar.j(keyAt);
                } else {
                    bVar.a(keyAt, removeAt.azW, removeAt.azX);
                }
            } else if ((removeAt.flags & 14) == 14) {
                bVar.b(keyAt, removeAt.azW, removeAt.azX);
            } else if ((removeAt.flags & 12) == 12) {
                bVar.c(keyAt, removeAt.azW, removeAt.azX);
            } else if ((removeAt.flags & 4) != 0) {
                bVar.a(keyAt, removeAt.azW, null);
            } else if ((removeAt.flags & 8) != 0) {
                bVar.b(keyAt, removeAt.azW, removeAt.azX);
            }
            a.a(removeAt);
        }
    }

    /* access modifiers changed from: package-private */
    public final void K(RecyclerView.v vVar) {
        int size = this.azV.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            } else if (vVar == this.azV.valueAt(size)) {
                this.azV.removeAt(size);
                break;
            } else {
                size--;
            }
        }
        a remove = this.azU.remove(vVar);
        if (remove != null) {
            a.a(remove);
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        static l.a<a> azY = new l.b(20);
        RecyclerView.f.c azW;
        RecyclerView.f.c azX;
        int flags;

        private a() {
        }

        static a nm() {
            a acquire = azY.acquire();
            return acquire == null ? new a() : acquire;
        }

        static void a(a aVar) {
            aVar.flags = 0;
            aVar.azW = null;
            aVar.azX = null;
            azY.release(aVar);
        }

        static void nn() {
            do {
            } while (azY.acquire() != null);
        }
    }
}
