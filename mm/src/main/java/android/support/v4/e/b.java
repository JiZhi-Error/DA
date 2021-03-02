package android.support.v4.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b<E> implements Collection<E>, Set<E> {
    private static final int[] OF = new int[0];
    private static final Object[] OG = new Object[0];
    private static Object[] OH;
    private static int OI;
    private static Object[] OJ;
    private static int OL;
    private i<E, E> OD;
    private int[] OM;
    public Object[] OO;
    int mSize;

    private int indexOf(Object obj, int i2) {
        int i3 = this.mSize;
        if (i3 == 0) {
            return -1;
        }
        int b2 = d.b(this.OM, i3, i2);
        if (b2 < 0 || obj.equals(this.OO[b2])) {
            return b2;
        }
        int i4 = b2 + 1;
        while (i4 < i3 && this.OM[i4] == i2) {
            if (obj.equals(this.OO[i4])) {
                return i4;
            }
            i4++;
        }
        int i5 = b2 - 1;
        while (i5 >= 0 && this.OM[i5] == i2) {
            if (obj.equals(this.OO[i5])) {
                return i5;
            }
            i5--;
        }
        return i4 ^ -1;
    }

    private int fv() {
        int i2 = this.mSize;
        if (i2 == 0) {
            return -1;
        }
        int b2 = d.b(this.OM, i2, 0);
        if (b2 < 0 || this.OO[b2] == null) {
            return b2;
        }
        int i3 = b2 + 1;
        while (i3 < i2 && this.OM[i3] == 0) {
            if (this.OO[i3] == null) {
                return i3;
            }
            i3++;
        }
        int i4 = b2 - 1;
        while (i4 >= 0 && this.OM[i4] == 0) {
            if (this.OO[i4] == null) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    private void aH(int i2) {
        if (i2 == 8) {
            synchronized (b.class) {
                if (OJ != null) {
                    Object[] objArr = OJ;
                    this.OO = objArr;
                    OJ = (Object[]) objArr[0];
                    this.OM = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    OL--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (b.class) {
                if (OH != null) {
                    Object[] objArr2 = OH;
                    this.OO = objArr2;
                    OH = (Object[]) objArr2[0];
                    this.OM = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    OI--;
                    return;
                }
            }
        }
        this.OM = new int[i2];
        this.OO = new Object[i2];
    }

    private static void a(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (OL < 10) {
                    objArr[0] = OJ;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    OJ = objArr;
                    OL++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (b.class) {
                if (OI < 10) {
                    objArr[0] = OH;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    OH = objArr;
                    OI++;
                }
            }
        }
    }

    public b() {
        this(0);
    }

    public b(int i2) {
        if (i2 == 0) {
            this.OM = OF;
            this.OO = OG;
        } else {
            aH(i2);
        }
        this.mSize = 0;
    }

    public final void clear() {
        if (this.mSize != 0) {
            a(this.OM, this.OO, this.mSize);
            this.OM = OF;
            this.OO = OG;
            this.mSize = 0;
        }
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public final int indexOf(Object obj) {
        return obj == null ? fv() : indexOf(obj, obj.hashCode());
    }

    public final boolean isEmpty() {
        return this.mSize <= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(E e2) {
        int hashCode;
        int indexOf;
        int i2 = 8;
        if (e2 == null) {
            indexOf = fv();
            hashCode = 0;
        } else {
            hashCode = e2.hashCode();
            indexOf = indexOf(e2, hashCode);
        }
        if (indexOf >= 0) {
            return false;
        }
        int i3 = indexOf ^ -1;
        if (this.mSize >= this.OM.length) {
            if (this.mSize >= 8) {
                i2 = this.mSize + (this.mSize >> 1);
            } else if (this.mSize < 4) {
                i2 = 4;
            }
            int[] iArr = this.OM;
            Object[] objArr = this.OO;
            aH(i2);
            if (this.OM.length > 0) {
                System.arraycopy(iArr, 0, this.OM, 0, iArr.length);
                System.arraycopy(objArr, 0, this.OO, 0, objArr.length);
            }
            a(iArr, objArr, this.mSize);
        }
        if (i3 < this.mSize) {
            int[] iArr2 = this.OM;
            System.arraycopy(iArr2, i3, iArr2, i3 + 1, this.mSize - i3);
            Object[] objArr2 = this.OO;
            System.arraycopy(objArr2, i3, objArr2, i3 + 1, this.mSize - i3);
        }
        this.OM[i3] = hashCode;
        this.OO[i3] = e2;
        this.mSize++;
        return true;
    }

    public final boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public final E removeAt(int i2) {
        int i3 = 8;
        E e2 = (E) this.OO[i2];
        if (this.mSize <= 1) {
            a(this.OM, this.OO, this.mSize);
            this.OM = OF;
            this.OO = OG;
            this.mSize = 0;
        } else if (this.OM.length <= 8 || this.mSize >= this.OM.length / 3) {
            this.mSize--;
            if (i2 < this.mSize) {
                System.arraycopy(this.OM, i2 + 1, this.OM, i2, this.mSize - i2);
                System.arraycopy(this.OO, i2 + 1, this.OO, i2, this.mSize - i2);
            }
            this.OO[this.mSize] = null;
        } else {
            if (this.mSize > 8) {
                i3 = this.mSize + (this.mSize >> 1);
            }
            int[] iArr = this.OM;
            Object[] objArr = this.OO;
            aH(i3);
            this.mSize--;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.OM, 0, i2);
                System.arraycopy(objArr, 0, this.OO, 0, i2);
            }
            if (i2 < this.mSize) {
                System.arraycopy(iArr, i2 + 1, this.OM, i2, this.mSize - i2);
                System.arraycopy(objArr, i2 + 1, this.OO, i2, this.mSize - i2);
            }
        }
        return e2;
    }

    public final int size() {
        return this.mSize;
    }

    public final Object[] toArray() {
        Object[] objArr = new Object[this.mSize];
        System.arraycopy(this.OO, 0, objArr, 0, this.mSize);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] tArr) {
        T[] tArr2 = tArr.length < this.mSize ? (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.mSize)) : tArr;
        System.arraycopy(this.OO, 0, tArr2, 0, this.mSize);
        if (tArr2.length > this.mSize) {
            tArr2[this.mSize] = null;
        }
        return tArr2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.mSize; i2++) {
            try {
                if (!set.contains(this.OO[i2])) {
                    return false;
                }
            } catch (NullPointerException e2) {
                return false;
            } catch (ClassCastException e3) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int[] iArr = this.OM;
        int i2 = this.mSize;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            i3++;
            i4 = iArr[i3] + i4;
        }
        return i4;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.mSize; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object obj = this.OO[i2];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: android.support.v4.e.b<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends E> collection) {
        boolean z = false;
        int size = this.mSize + collection.size();
        if (this.OM.length < size) {
            int[] iArr = this.OM;
            Object[] objArr = this.OO;
            aH(size);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.OM, 0, this.mSize);
                System.arraycopy(objArr, 0, this.OO, 0, this.mSize);
            }
            a(iArr, objArr, this.mSize);
        }
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection<?> collection) {
        boolean z = false;
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i2 = this.mSize - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.OO[i2])) {
                removeAt(i2);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator<E> iterator() {
        if (this.OD == null) {
            this.OD = new i<E, E>() {
                /* class android.support.v4.e.b.AnonymousClass1 */

                /* access modifiers changed from: protected */
                @Override // android.support.v4.e.i
                public final int fs() {
                    return b.this.mSize;
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v4.e.i
                public final Object z(int i2, int i3) {
                    return b.this.OO[i2];
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v4.e.i
                public final int E(Object obj) {
                    return b.this.indexOf(obj);
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v4.e.i
                public final int F(Object obj) {
                    return b.this.indexOf(obj);
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v4.e.i
                public final Map<E, E> ft() {
                    throw new UnsupportedOperationException("not a map");
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v4.e.i
                public final void b(E e2, E e3) {
                    b.this.add(e2);
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v4.e.i
                public final E a(int i2, E e2) {
                    throw new UnsupportedOperationException("not a map");
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v4.e.i
                public final void aG(int i2) {
                    b.this.removeAt(i2);
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v4.e.i
                public final void fu() {
                    b.this.clear();
                }
            };
        }
        return this.OD.getKeySet().iterator();
    }
}
