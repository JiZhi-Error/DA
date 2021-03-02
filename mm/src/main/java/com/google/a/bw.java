package com.google.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* access modifiers changed from: package-private */
public final class bw implements au {
    private final boolean bWz;
    final aw bXE;
    final bl bZn;
    final int[] bZo;
    final w[] bZp;

    bw(bl blVar, boolean z, int[] iArr, w[] wVarArr, Object obj) {
        this.bZn = blVar;
        this.bWz = z;
        this.bZo = iArr;
        this.bZp = wVarArr;
        this.bXE = (aw) ae.checkNotNull(obj, "defaultInstance");
    }

    @Override // com.google.a.au
    public final bl He() {
        return this.bZn;
    }

    @Override // com.google.a.au
    public final boolean Hf() {
        return this.bWz;
    }

    @Override // com.google.a.au
    public final aw Hg() {
        return this.bXE;
    }

    public static a gO(int i2) {
        return new a(i2);
    }

    public static final class a {
        boolean bWz;
        private bl bZn;
        int[] bZo;
        private final List<w> bZq;
        private boolean bZr;
        Object bZs;

        public a() {
            this.bZo = null;
            this.bZq = new ArrayList();
        }

        public a(int i2) {
            this.bZo = null;
            this.bZq = new ArrayList(i2);
        }

        public final void a(bl blVar) {
            this.bZn = (bl) ae.checkNotNull(blVar, "syntax");
        }

        public final void a(w wVar) {
            if (this.bZr) {
                throw new IllegalStateException("Builder can only build once");
            }
            this.bZq.add(wVar);
        }

        public final bw HF() {
            if (this.bZr) {
                throw new IllegalStateException("Builder can only build once");
            } else if (this.bZn == null) {
                throw new IllegalStateException("Must specify a proto syntax");
            } else {
                this.bZr = true;
                Collections.sort(this.bZq);
                return new bw(this.bZn, this.bWz, this.bZo, (w[]) this.bZq.toArray(new w[0]), this.bZs);
            }
        }
    }
}
