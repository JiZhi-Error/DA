package android.support.a;

import android.support.a.b;

public final class d extends b<d> {
    private e gj;
    private float gk;
    private boolean gl;

    public <K> d(K k, c<K> cVar) {
        super(k, cVar);
        this.gj = null;
        this.gk = Float.MAX_VALUE;
        this.gl = false;
    }

    public <K> d(K k, c<K> cVar, byte b2) {
        super(k, cVar);
        this.gj = null;
        this.gk = Float.MAX_VALUE;
        this.gl = false;
        this.gj = new e(1.0f);
    }

    public final e aJ() {
        return this.gj;
    }

    public final d a(e eVar) {
        this.gj = eVar;
        return this;
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.a.b
    public final boolean e(long j2) {
        boolean z;
        if (this.gl) {
            if (this.gk != Float.MAX_VALUE) {
                this.gj.gt = (double) this.gk;
                this.gk = Float.MAX_VALUE;
            }
            this.fZ = (float) this.gj.gt;
            this.fY = 0.0f;
            this.gl = false;
            return true;
        }
        if (this.gk != Float.MAX_VALUE) {
            b.a a2 = this.gj.a((double) this.fZ, (double) this.fY, j2 / 2);
            this.gj.gt = (double) this.gk;
            this.gk = Float.MAX_VALUE;
            b.a a3 = this.gj.a((double) a2.fZ, (double) a2.fY, j2 / 2);
            this.fZ = a3.fZ;
            this.fY = a3.fY;
        } else {
            b.a a4 = this.gj.a((double) this.fZ, (double) this.fY, j2);
            this.fZ = a4.fZ;
            this.fY = a4.fY;
        }
        this.fZ = Math.max(this.fZ, this.ge);
        this.fZ = Math.min(this.fZ, this.gd);
        float f2 = this.fZ;
        float f3 = this.fY;
        e eVar = this.gj;
        if (((double) Math.abs(f3)) >= eVar.gp || ((double) Math.abs(f2 - ((float) eVar.gt))) >= eVar.go) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return false;
        }
        this.fZ = (float) this.gj.gt;
        this.fY = 0.0f;
        return true;
    }

    @Override // android.support.a.b
    public final void start() {
        if (this.gj == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double d2 = (double) ((float) this.gj.gt);
        if (d2 > ((double) this.gd)) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        } else if (d2 < ((double) this.ge)) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        } else {
            e eVar = this.gj;
            eVar.go = Math.abs((double) (this.gf * 0.75f));
            eVar.gp = eVar.go * 62.5d;
            super.start();
        }
    }
}
