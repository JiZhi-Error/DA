package com.bumptech.glide.load.c;

import android.support.v4.e.l;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.a.d;
import com.bumptech.glide.load.c.n;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* access modifiers changed from: package-private */
public final class q<Model, Data> implements n<Model, Data> {
    private final List<n<Model, Data>> aFP;
    private final l.a<List<Throwable>> aKm;

    q(List<n<Model, Data>> list, l.a<List<Throwable>> aVar) {
        this.aFP = list;
        this.aKm = aVar;
    }

    @Override // com.bumptech.glide.load.c.n
    public final n.a<Data> b(Model model, int i2, int i3, i iVar) {
        g gVar;
        n.a<Data> b2;
        AppMethodBeat.i(77284);
        int size = this.aFP.size();
        ArrayList arrayList = new ArrayList(size);
        int i4 = 0;
        g gVar2 = null;
        while (i4 < size) {
            n<Model, Data> nVar = this.aFP.get(i4);
            if (!nVar.X(model) || (b2 = nVar.b(model, i2, i3, iVar)) == null) {
                gVar = gVar2;
            } else {
                gVar = b2.aFO;
                arrayList.add(b2.aKh);
            }
            i4++;
            gVar2 = gVar;
        }
        if (arrayList.isEmpty() || gVar2 == null) {
            AppMethodBeat.o(77284);
            return null;
        }
        n.a<Data> aVar = new n.a<>(gVar2, new a(arrayList, this.aKm));
        AppMethodBeat.o(77284);
        return aVar;
    }

    @Override // com.bumptech.glide.load.c.n
    public final boolean X(Model model) {
        AppMethodBeat.i(77285);
        for (n<Model, Data> nVar : this.aFP) {
            if (nVar.X(model)) {
                AppMethodBeat.o(77285);
                return true;
            }
        }
        AppMethodBeat.o(77285);
        return false;
    }

    public final String toString() {
        AppMethodBeat.i(77286);
        String str = "MultiModelLoader{modelLoaders=" + Arrays.toString(this.aFP.toArray()) + '}';
        AppMethodBeat.o(77286);
        return str;
    }

    static class a<Data> implements d<Data>, d.a<Data> {
        private final l.a<List<Throwable>> aDa;
        private com.bumptech.glide.g aGc;
        private final List<d<Data>> aKn;
        private d.a<? super Data> aKo;
        private List<Throwable> aKp;
        private int currentIndex = 0;
        private boolean isCancelled;

        a(List<d<Data>> list, l.a<List<Throwable>> aVar) {
            AppMethodBeat.i(77275);
            this.aDa = aVar;
            j.b(list);
            this.aKn = list;
            AppMethodBeat.o(77275);
        }

        @Override // com.bumptech.glide.load.a.d
        public final void a(com.bumptech.glide.g gVar, d.a<? super Data> aVar) {
            AppMethodBeat.i(77276);
            this.aGc = gVar;
            this.aKo = aVar;
            this.aKp = this.aDa.acquire();
            this.aKn.get(this.currentIndex).a(gVar, this);
            if (this.isCancelled) {
                cancel();
            }
            AppMethodBeat.o(77276);
        }

        @Override // com.bumptech.glide.load.a.d
        public final void cleanup() {
            AppMethodBeat.i(77277);
            if (this.aKp != null) {
                this.aDa.release(this.aKp);
            }
            this.aKp = null;
            for (d<Data> dVar : this.aKn) {
                dVar.cleanup();
            }
            AppMethodBeat.o(77277);
        }

        @Override // com.bumptech.glide.load.a.d
        public final void cancel() {
            AppMethodBeat.i(77278);
            this.isCancelled = true;
            for (d<Data> dVar : this.aKn) {
                dVar.cancel();
            }
            AppMethodBeat.o(77278);
        }

        @Override // com.bumptech.glide.load.a.d
        public final Class<Data> os() {
            AppMethodBeat.i(77279);
            Class<Data> os = this.aKn.get(0).os();
            AppMethodBeat.o(77279);
            return os;
        }

        @Override // com.bumptech.glide.load.a.d
        public final com.bumptech.glide.load.a ot() {
            AppMethodBeat.i(77280);
            com.bumptech.glide.load.a ot = this.aKn.get(0).ot();
            AppMethodBeat.o(77280);
            return ot;
        }

        @Override // com.bumptech.glide.load.a.d.a
        public final void S(Data data) {
            AppMethodBeat.i(77281);
            if (data != null) {
                this.aKo.S(data);
                AppMethodBeat.o(77281);
                return;
            }
            pu();
            AppMethodBeat.o(77281);
        }

        @Override // com.bumptech.glide.load.a.d.a
        public final void e(Exception exc) {
            AppMethodBeat.i(77282);
            ((List) j.checkNotNull(this.aKp, "Argument must not be null")).add(exc);
            pu();
            AppMethodBeat.o(77282);
        }

        private void pu() {
            AppMethodBeat.i(77283);
            if (this.isCancelled) {
                AppMethodBeat.o(77283);
            } else if (this.currentIndex < this.aKn.size() - 1) {
                this.currentIndex++;
                a(this.aGc, this.aKo);
                AppMethodBeat.o(77283);
            } else {
                j.checkNotNull(this.aKp, "Argument must not be null");
                this.aKo.e(new com.bumptech.glide.load.b.q("Fetch failed", new ArrayList(this.aKp)));
                AppMethodBeat.o(77283);
            }
        }
    }
}
