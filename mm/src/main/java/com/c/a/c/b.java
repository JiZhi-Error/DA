package com.c.a.c;

public abstract class b implements Cloneable {
    private transient int _size;
    private transient int cqg;
    private transient int cqh;
    private float cqi;
    private int cqj;

    /* access modifiers changed from: protected */
    public abstract int capacity();

    /* access modifiers changed from: protected */
    public abstract void hx(int i2);

    public b() {
        this((byte) 0);
    }

    private b(byte b2) {
        this.cqi = 0.8f;
        hw(6);
    }

    @Override // java.lang.Object
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    public boolean isEmpty() {
        return this._size == 0;
    }

    public int size() {
        return this._size;
    }

    public final void ensureCapacity(int i2) {
        if (i2 > this.cqj - size()) {
            hx(a.hv(((int) (((float) i2) + (((float) size()) / this.cqi))) + 2));
            hy(capacity());
        }
    }

    /* access modifiers changed from: protected */
    public void removeAt(int i2) {
        this._size--;
        this.cqh++;
        if (this.cqh > this._size && capacity() > 42) {
            hx(a.hv(((int) (((float) size()) / this.cqi)) + 2));
            hy(capacity());
        }
    }

    public final void Kr() {
        if (this.cqh < 0) {
            throw new IllegalStateException("Unpaired stop/startCompactingOnRemove");
        }
        this.cqh -= capacity();
    }

    public final void Ks() {
        if (this.cqh >= 0) {
            throw new IllegalStateException("Unpaired stop/startCompactingOnRemove");
        }
        this.cqh += capacity();
    }

    public void clear() {
        this._size = 0;
        this.cqg = capacity();
        this.cqh = 0;
    }

    /* access modifiers changed from: protected */
    public int hw(int i2) {
        int hv = a.hv(i2);
        hy(hv);
        return hv;
    }

    private void hy(int i2) {
        this.cqj = Math.min(i2 - 1, (int) (((float) i2) * this.cqi));
        this.cqg = i2 - this._size;
        this.cqh = 0;
    }

    /* access modifiers changed from: protected */
    public final void bO(boolean z) {
        if (z) {
            this.cqg--;
        } else {
            this.cqh--;
        }
        int i2 = this._size + 1;
        this._size = i2;
        if (i2 > this.cqj || this.cqg == 0) {
            hx(a.hv(capacity() << 1));
            hy(capacity());
        }
    }
}
