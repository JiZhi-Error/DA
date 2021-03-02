package android.support.v4.e;

public final class o<E> implements Cloneable {
    private static final Object OT = new Object();
    public boolean OU;
    private Object[] OW;
    public int[] Pi;
    public int mSize;

    public o() {
        this(10);
    }

    public o(int i2) {
        this.OU = false;
        if (i2 == 0) {
            this.Pi = d.OQ;
            this.OW = d.OS;
        } else {
            int idealIntArraySize = d.idealIntArraySize(i2);
            this.Pi = new int[idealIntArraySize];
            this.OW = new Object[idealIntArraySize];
        }
        this.mSize = 0;
    }

    /* renamed from: fy */
    public final o<E> clone() {
        try {
            o<E> oVar = (o) super.clone();
            oVar.Pi = (int[]) this.Pi.clone();
            oVar.OW = (Object[]) this.OW.clone();
            return oVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final E get(int i2, E e2) {
        int b2 = d.b(this.Pi, this.mSize, i2);
        return (b2 < 0 || this.OW[b2] == OT) ? e2 : (E) this.OW[b2];
    }

    public final void delete(int i2) {
        int b2 = d.b(this.Pi, this.mSize, i2);
        if (b2 >= 0 && this.OW[b2] != OT) {
            this.OW[b2] = OT;
            this.OU = true;
        }
    }

    public final void gc() {
        int i2 = this.mSize;
        int[] iArr = this.Pi;
        Object[] objArr = this.OW;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != OT) {
                if (i4 != i3) {
                    iArr[i3] = iArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.OU = false;
        this.mSize = i3;
    }

    public final void put(int i2, E e2) {
        int b2 = d.b(this.Pi, this.mSize, i2);
        if (b2 >= 0) {
            this.OW[b2] = e2;
            return;
        }
        int i3 = b2 ^ -1;
        if (i3 >= this.mSize || this.OW[i3] != OT) {
            if (this.OU && this.mSize >= this.Pi.length) {
                gc();
                i3 = d.b(this.Pi, this.mSize, i2) ^ -1;
            }
            if (this.mSize >= this.Pi.length) {
                int idealIntArraySize = d.idealIntArraySize(this.mSize + 1);
                int[] iArr = new int[idealIntArraySize];
                Object[] objArr = new Object[idealIntArraySize];
                System.arraycopy(this.Pi, 0, iArr, 0, this.Pi.length);
                System.arraycopy(this.OW, 0, objArr, 0, this.OW.length);
                this.Pi = iArr;
                this.OW = objArr;
            }
            if (this.mSize - i3 != 0) {
                int[] iArr2 = this.Pi;
                System.arraycopy(iArr2, i3, iArr2, i3 + 1, this.mSize - i3);
                Object[] objArr2 = this.OW;
                System.arraycopy(objArr2, i3, objArr2, i3 + 1, this.mSize - i3);
            }
            this.Pi[i3] = i2;
            this.OW[i3] = e2;
            this.mSize++;
            return;
        }
        this.Pi[i3] = i2;
        this.OW[i3] = e2;
    }

    public final int size() {
        if (this.OU) {
            gc();
        }
        return this.mSize;
    }

    public final int keyAt(int i2) {
        if (this.OU) {
            gc();
        }
        return this.Pi[i2];
    }

    public final E valueAt(int i2) {
        if (this.OU) {
            gc();
        }
        return (E) this.OW[i2];
    }

    public final int indexOfValue(E e2) {
        if (this.OU) {
            gc();
        }
        for (int i2 = 0; i2 < this.mSize; i2++) {
            if (this.OW[i2] == e2) {
                return i2;
            }
        }
        return -1;
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

    public final void append(int i2, E e2) {
        if (this.mSize == 0 || i2 > this.Pi[this.mSize - 1]) {
            if (this.OU && this.mSize >= this.Pi.length) {
                gc();
            }
            int i3 = this.mSize;
            if (i3 >= this.Pi.length) {
                int idealIntArraySize = d.idealIntArraySize(i3 + 1);
                int[] iArr = new int[idealIntArraySize];
                Object[] objArr = new Object[idealIntArraySize];
                System.arraycopy(this.Pi, 0, iArr, 0, this.Pi.length);
                System.arraycopy(this.OW, 0, objArr, 0, this.OW.length);
                this.Pi = iArr;
                this.OW = objArr;
            }
            this.Pi[i3] = i2;
            this.OW[i3] = e2;
            this.mSize = i3 + 1;
            return;
        }
        put(i2, e2);
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
