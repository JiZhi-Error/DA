package android.support.v4.e;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class n<K, V> {
    static Object[] Pe;
    static int Pf;
    static Object[] Pg;
    static int Ph;
    int[] OM;
    Object[] OO;
    int mSize;

    private static int c(int[] iArr, int i2, int i3) {
        try {
            return d.b(iArr, i2, i3);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new ConcurrentModificationException();
        }
    }

    private int indexOf(Object obj, int i2) {
        int i3 = this.mSize;
        if (i3 == 0) {
            return -1;
        }
        int c2 = c(this.OM, i3, i2);
        if (c2 < 0 || obj.equals(this.OO[c2 << 1])) {
            return c2;
        }
        int i4 = c2 + 1;
        while (i4 < i3 && this.OM[i4] == i2) {
            if (obj.equals(this.OO[i4 << 1])) {
                return i4;
            }
            i4++;
        }
        int i5 = c2 - 1;
        while (i5 >= 0 && this.OM[i5] == i2) {
            if (obj.equals(this.OO[i5 << 1])) {
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
        int c2 = c(this.OM, i2, 0);
        if (c2 < 0 || this.OO[c2 << 1] == null) {
            return c2;
        }
        int i3 = c2 + 1;
        while (i3 < i2 && this.OM[i3] == 0) {
            if (this.OO[i3 << 1] == null) {
                return i3;
            }
            i3++;
        }
        int i4 = c2 - 1;
        while (i4 >= 0 && this.OM[i4] == 0) {
            if (this.OO[i4 << 1] == null) {
                return i4;
            }
            i4--;
        }
        return i3 ^ -1;
    }

    private void aH(int i2) {
        if (i2 == 8) {
            synchronized (a.class) {
                if (Pg != null) {
                    Object[] objArr = Pg;
                    this.OO = objArr;
                    Pg = (Object[]) objArr[0];
                    this.OM = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    Ph--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (a.class) {
                if (Pe != null) {
                    Object[] objArr2 = Pe;
                    this.OO = objArr2;
                    Pe = (Object[]) objArr2[0];
                    this.OM = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    Pf--;
                    return;
                }
            }
        }
        this.OM = new int[i2];
        this.OO = new Object[(i2 << 1)];
    }

    private static void a(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (a.class) {
                if (Ph < 10) {
                    objArr[0] = Pg;
                    objArr[1] = iArr;
                    for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    Pg = objArr;
                    Ph++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (a.class) {
                if (Pf < 10) {
                    objArr[0] = Pe;
                    objArr[1] = iArr;
                    for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    Pe = objArr;
                    Pf++;
                }
            }
        }
    }

    public n() {
        this.OM = d.OQ;
        this.OO = d.OS;
        this.mSize = 0;
    }

    public n(int i2) {
        if (i2 == 0) {
            this.OM = d.OQ;
            this.OO = d.OS;
        } else {
            aH(i2);
        }
        this.mSize = 0;
    }

    public n(n<K, V> nVar) {
        this();
        if (nVar != null) {
            a(nVar);
        }
    }

    public void clear() {
        if (this.mSize > 0) {
            int[] iArr = this.OM;
            Object[] objArr = this.OO;
            int i2 = this.mSize;
            this.OM = d.OQ;
            this.OO = d.OS;
            this.mSize = 0;
            a(iArr, objArr, i2);
        }
        if (this.mSize > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final void ensureCapacity(int i2) {
        int i3 = this.mSize;
        if (this.OM.length < i2) {
            int[] iArr = this.OM;
            Object[] objArr = this.OO;
            aH(i2);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.OM, 0, i3);
                System.arraycopy(objArr, 0, this.OO, 0, i3 << 1);
            }
            a(iArr, objArr, i3);
        }
        if (this.mSize != i3) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public final int indexOfKey(Object obj) {
        return obj == null ? fv() : indexOf(obj, obj.hashCode());
    }

    /* access modifiers changed from: package-private */
    public final int indexOfValue(Object obj) {
        int i2 = 1;
        int i3 = this.mSize * 2;
        Object[] objArr = this.OO;
        if (obj == null) {
            while (i2 < i3) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
                i2 += 2;
            }
        } else {
            while (i2 < i3) {
                if (obj.equals(objArr[i2])) {
                    return i2 >> 1;
                }
                i2 += 2;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return indexOfValue(obj) >= 0;
    }

    public V get(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return (V) this.OO[(indexOfKey << 1) + 1];
        }
        return null;
    }

    public final K keyAt(int i2) {
        return (K) this.OO[i2 << 1];
    }

    public final V valueAt(int i2) {
        return (V) this.OO[(i2 << 1) + 1];
    }

    public V setValueAt(int i2, V v) {
        int i3 = (i2 << 1) + 1;
        V v2 = (V) this.OO[i3];
        this.OO[i3] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    public V put(K k, V v) {
        int hashCode;
        int indexOf;
        int i2 = 8;
        int i3 = this.mSize;
        if (k == null) {
            indexOf = fv();
            hashCode = 0;
        } else {
            hashCode = k.hashCode();
            indexOf = indexOf(k, hashCode);
        }
        if (indexOf >= 0) {
            int i4 = (indexOf << 1) + 1;
            V v2 = (V) this.OO[i4];
            this.OO[i4] = v;
            return v2;
        }
        int i5 = indexOf ^ -1;
        if (i3 >= this.OM.length) {
            if (i3 >= 8) {
                i2 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i2 = 4;
            }
            int[] iArr = this.OM;
            Object[] objArr = this.OO;
            aH(i2);
            if (i3 != this.mSize) {
                throw new ConcurrentModificationException();
            }
            if (this.OM.length > 0) {
                System.arraycopy(iArr, 0, this.OM, 0, iArr.length);
                System.arraycopy(objArr, 0, this.OO, 0, objArr.length);
            }
            a(iArr, objArr, i3);
        }
        if (i5 < i3) {
            int[] iArr2 = this.OM;
            System.arraycopy(iArr2, i5, iArr2, i5 + 1, i3 - i5);
            System.arraycopy(this.OO, i5 << 1, this.OO, (i5 + 1) << 1, (this.mSize - i5) << 1);
        }
        if (i3 != this.mSize || i5 >= this.OM.length) {
            throw new ConcurrentModificationException();
        }
        this.OM[i5] = hashCode;
        this.OO[i5 << 1] = k;
        this.OO[(i5 << 1) + 1] = v;
        this.mSize++;
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: android.support.v4.e.n<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(n<? extends K, ? extends V> nVar) {
        int i2 = nVar.mSize;
        ensureCapacity(this.mSize + i2);
        if (this.mSize != 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                put(nVar.keyAt(i3), nVar.valueAt(i3));
            }
        } else if (i2 > 0) {
            System.arraycopy(nVar.OM, 0, this.OM, 0, i2);
            System.arraycopy(nVar.OO, 0, this.OO, 0, i2 << 1);
            this.mSize = i2;
        }
    }

    public V remove(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public V removeAt(int i2) {
        int i3;
        int i4 = 8;
        V v = (V) this.OO[(i2 << 1) + 1];
        int i5 = this.mSize;
        if (i5 <= 1) {
            a(this.OM, this.OO, i5);
            this.OM = d.OQ;
            this.OO = d.OS;
            i3 = 0;
        } else {
            int i6 = i5 - 1;
            if (this.OM.length <= 8 || this.mSize >= this.OM.length / 3) {
                if (i2 < i6) {
                    System.arraycopy(this.OM, i2 + 1, this.OM, i2, i6 - i2);
                    System.arraycopy(this.OO, (i2 + 1) << 1, this.OO, i2 << 1, (i6 - i2) << 1);
                }
                this.OO[i6 << 1] = null;
                this.OO[(i6 << 1) + 1] = null;
                i3 = i6;
            } else {
                if (i5 > 8) {
                    i4 = (i5 >> 1) + i5;
                }
                int[] iArr = this.OM;
                Object[] objArr = this.OO;
                aH(i4);
                if (i5 != this.mSize) {
                    throw new ConcurrentModificationException();
                }
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.OM, 0, i2);
                    System.arraycopy(objArr, 0, this.OO, 0, i2 << 1);
                }
                if (i2 < i6) {
                    System.arraycopy(iArr, i2 + 1, this.OM, i2, i6 - i2);
                    System.arraycopy(objArr, (i2 + 1) << 1, this.OO, i2 << 1, (i6 - i2) << 1);
                }
                i3 = i6;
            }
        }
        if (i5 != this.mSize) {
            throw new ConcurrentModificationException();
        }
        this.mSize = i3;
        return v;
    }

    public int size() {
        return this.mSize;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (size() != nVar.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.mSize; i2++) {
                try {
                    K keyAt = keyAt(i2);
                    V valueAt = valueAt(i2);
                    Object obj2 = nVar.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !nVar.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!valueAt.equals(obj2)) {
                        return false;
                    }
                } catch (NullPointerException e2) {
                    return false;
                } catch (ClassCastException e3) {
                    return false;
                }
            }
            return true;
        } else if (!(obj instanceof Map)) {
            return false;
        } else {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.mSize; i3++) {
                try {
                    K keyAt2 = keyAt(i3);
                    V valueAt2 = valueAt(i3);
                    Object obj3 = map.get(keyAt2);
                    if (valueAt2 == null) {
                        if (obj3 != null || !map.containsKey(keyAt2)) {
                            return false;
                        }
                    } else if (!valueAt2.equals(obj3)) {
                        return false;
                    }
                } catch (NullPointerException e4) {
                    return false;
                } catch (ClassCastException e5) {
                    return false;
                }
            }
            return true;
        }
    }

    public int hashCode() {
        int[] iArr = this.OM;
        Object[] objArr = this.OO;
        int i2 = this.mSize;
        int i3 = 1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            Object obj = objArr[i3];
            i5 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i4];
            i4++;
            i3 += 2;
        }
        return i5;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.mSize; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            K keyAt = keyAt(i2);
            if (keyAt != this) {
                sb.append((Object) keyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V valueAt = valueAt(i2);
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
