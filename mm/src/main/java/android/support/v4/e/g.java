package android.support.v4.e;

public final class g<E> implements Cloneable {
    public static final Object OT = new Object();
    public boolean OU;
    public long[] OV;
    public Object[] OW;
    public int mSize;

    public g() {
        this((byte) 0);
    }

    private g(byte b2) {
        this.OU = false;
        int aI = d.aI(10);
        this.OV = new long[aI];
        this.OW = new Object[aI];
        this.mSize = 0;
    }

    /* renamed from: fx */
    public final g<E> clone() {
        try {
            g<E> gVar = (g) super.clone();
            gVar.OV = (long[]) this.OV.clone();
            gVar.OW = (Object[]) this.OW.clone();
            return gVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final E get(long j2, E e2) {
        int a2 = d.a(this.OV, this.mSize, j2);
        return (a2 < 0 || this.OW[a2] == OT) ? e2 : (E) this.OW[a2];
    }

    public final void removeAt(int i2) {
        if (this.OW[i2] != OT) {
            this.OW[i2] = OT;
            this.OU = true;
        }
    }

    private void gc() {
        int i2 = this.mSize;
        long[] jArr = this.OV;
        Object[] objArr = this.OW;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != OT) {
                if (i4 != i3) {
                    jArr[i3] = jArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.OU = false;
        this.mSize = i3;
    }

    public final void put(long j2, E e2) {
        int a2 = d.a(this.OV, this.mSize, j2);
        if (a2 >= 0) {
            this.OW[a2] = e2;
            return;
        }
        int i2 = a2 ^ -1;
        if (i2 >= this.mSize || this.OW[i2] != OT) {
            if (this.OU && this.mSize >= this.OV.length) {
                gc();
                i2 = d.a(this.OV, this.mSize, j2) ^ -1;
            }
            if (this.mSize >= this.OV.length) {
                int aI = d.aI(this.mSize + 1);
                long[] jArr = new long[aI];
                Object[] objArr = new Object[aI];
                System.arraycopy(this.OV, 0, jArr, 0, this.OV.length);
                System.arraycopy(this.OW, 0, objArr, 0, this.OW.length);
                this.OV = jArr;
                this.OW = objArr;
            }
            if (this.mSize - i2 != 0) {
                long[] jArr2 = this.OV;
                System.arraycopy(jArr2, i2, jArr2, i2 + 1, this.mSize - i2);
                Object[] objArr2 = this.OW;
                System.arraycopy(objArr2, i2, objArr2, i2 + 1, this.mSize - i2);
            }
            this.OV[i2] = j2;
            this.OW[i2] = e2;
            this.mSize++;
            return;
        }
        this.OV[i2] = j2;
        this.OW[i2] = e2;
    }

    public final int size() {
        if (this.OU) {
            gc();
        }
        return this.mSize;
    }

    public final long keyAt(int i2) {
        if (this.OU) {
            gc();
        }
        return this.OV[i2];
    }

    public final E valueAt(int i2) {
        if (this.OU) {
            gc();
        }
        return (E) this.OW[i2];
    }

    public final int indexOfKey(long j2) {
        if (this.OU) {
            gc();
        }
        return d.a(this.OV, this.mSize, j2);
    }

    public final void clear() {
        int i2 = this.mSize;
        Object[] objArr = this.OW;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.mSize = 0;
        this.OU = false;
    }

    public final void append(long j2, E e2) {
        if (this.mSize == 0 || j2 > this.OV[this.mSize - 1]) {
            if (this.OU && this.mSize >= this.OV.length) {
                gc();
            }
            int i2 = this.mSize;
            if (i2 >= this.OV.length) {
                int aI = d.aI(i2 + 1);
                long[] jArr = new long[aI];
                Object[] objArr = new Object[aI];
                System.arraycopy(this.OV, 0, jArr, 0, this.OV.length);
                System.arraycopy(this.OW, 0, objArr, 0, this.OW.length);
                this.OV = jArr;
                this.OW = objArr;
            }
            this.OV[i2] = j2;
            this.OW[i2] = e2;
            this.mSize = i2 + 1;
            return;
        }
        put(j2, e2);
    }

    public final String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.mSize; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(keyAt(i2));
            sb.append('=');
            E valueAt = valueAt(i2);
            if (valueAt != this) {
                sb.append((Object) valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
