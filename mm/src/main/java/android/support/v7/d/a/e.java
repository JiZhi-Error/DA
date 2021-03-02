package android.support.v7.d.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.d.a.b;
import android.util.StateSet;

class e extends b {
    private a ade;
    private boolean xp;

    e() {
        this(null, null);
    }

    @Override // android.support.v7.d.a.b
    public boolean isStateful() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.d.a.b
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int h2 = this.ade.h(iArr);
        if (h2 < 0) {
            h2 = this.ade.h(StateSet.WILD_CARD);
        }
        return selectDrawable(h2) || onStateChange;
    }

    @Override // android.support.v7.d.a.b
    public Drawable mutate() {
        if (!this.xp && super.mutate() == this) {
            this.ade.ht();
            this.xp = true;
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: hr */
    public a hs() {
        return new a(this.ade, this, null);
    }

    /* access modifiers changed from: package-private */
    public static class a extends b.AbstractC0046b {
        int[][] adf;

        a(a aVar, e eVar, Resources resources) {
            super(aVar, eVar, resources);
            if (aVar != null) {
                this.adf = aVar.adf;
            } else {
                this.adf = new int[this.acy.length][];
            }
        }

        /* access modifiers changed from: package-private */
        @Override // android.support.v7.d.a.b.AbstractC0046b
        public void ht() {
            int[][] iArr = new int[this.adf.length][];
            for (int length = this.adf.length - 1; length >= 0; length--) {
                iArr[length] = this.adf[length] != null ? (int[]) this.adf[length].clone() : null;
            }
            this.adf = iArr;
        }

        /* access modifiers changed from: package-private */
        public final int h(int[] iArr) {
            int[][] iArr2 = this.adf;
            int i2 = this.acz;
            for (int i3 = 0; i3 < i2; i3++) {
                if (StateSet.stateSetMatches(iArr2[i3], iArr)) {
                    return i3;
                }
            }
            return -1;
        }

        public Drawable newDrawable() {
            return new e(this, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new e(this, resources);
        }

        @Override // android.support.v7.d.a.b.AbstractC0046b
        public final void growArray(int i2, int i3) {
            super.growArray(i2, i3);
            int[][] iArr = new int[i3][];
            System.arraycopy(this.adf, 0, iArr, 0, i2);
            this.adf = iArr;
        }
    }

    @Override // android.support.v7.d.a.b
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.d.a.b
    public void a(b.AbstractC0046b bVar) {
        super.a(bVar);
        if (bVar instanceof a) {
            this.ade = (a) bVar;
        }
    }

    e(a aVar, Resources resources) {
        a(new a(aVar, this, resources));
        onStateChange(getState());
    }

    e(byte b2) {
    }
}
