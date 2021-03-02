package com.google.a;

import com.google.a.ae;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* access modifiers changed from: package-private */
public final class ad extends d<Integer> implements ae.d, bk, RandomAccess {
    private static final ad bXn;
    private int[] bXo;
    private int size;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // com.google.a.d, java.util.List, java.util.AbstractList
    public final /* synthetic */ void add(int i2, Integer num) {
        bw(i2, num.intValue());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // com.google.a.d, java.util.List, java.util.AbstractList
    public final /* synthetic */ Integer set(int i2, Integer num) {
        int intValue = num.intValue();
        yL();
        gG(i2);
        int i3 = this.bXo[i2];
        this.bXo[i2] = intValue;
        return Integer.valueOf(i3);
    }

    static {
        ad adVar = new ad(new int[0], 0);
        bXn = adVar;
        adVar.bNd = false;
    }

    public static ad GE() {
        return bXn;
    }

    ad() {
        this(new int[10], 0);
    }

    private ad(int[] iArr, int i2) {
        this.bXo = iArr;
        this.size = i2;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        yL();
        if (i3 < i2) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.bXo;
        System.arraycopy(iArr, i3, iArr, i2, this.size - i3);
        this.size -= i3 - i2;
        this.modCount++;
    }

    @Override // com.google.a.d
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ad)) {
            return super.equals(obj);
        }
        ad adVar = (ad) obj;
        if (this.size != adVar.size) {
            return false;
        }
        int[] iArr = adVar.bXo;
        for (int i2 = 0; i2 < this.size; i2++) {
            if (this.bXo[i2] != iArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.a.d
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.size; i3++) {
            i2 = (i2 * 31) + this.bXo[i3];
        }
        return i2;
    }

    @Override // com.google.a.ae.d
    /* renamed from: gE */
    public final ae.d gI(int i2) {
        if (i2 >= this.size) {
            return new ad(Arrays.copyOf(this.bXo, i2), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.a.ae.d
    public final int getInt(int i2) {
        gG(i2);
        return this.bXo[i2];
    }

    public final int size() {
        return this.size;
    }

    @Override // com.google.a.ae.d
    public final void gF(int i2) {
        bw(this.size, i2);
    }

    private void bw(int i2, int i3) {
        yL();
        if (i2 < 0 || i2 > this.size) {
            throw new IndexOutOfBoundsException(gH(i2));
        }
        if (this.size < this.bXo.length) {
            int[] iArr = this.bXo;
            System.arraycopy(iArr, i2, iArr, i2 + 1, this.size - i2);
        } else {
            int[] iArr2 = new int[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.bXo, 0, iArr2, 0, i2);
            System.arraycopy(this.bXo, i2, iArr2, i2 + 1, this.size - i2);
            this.bXo = iArr2;
        }
        this.bXo[i2] = i3;
        this.size++;
        this.modCount++;
    }

    @Override // com.google.a.d, java.util.AbstractCollection, java.util.List, java.util.Collection
    public final boolean addAll(Collection<? extends Integer> collection) {
        yL();
        ae.checkNotNull(collection);
        if (!(collection instanceof ad)) {
            return super.addAll(collection);
        }
        ad adVar = (ad) collection;
        if (adVar.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < adVar.size) {
            throw new OutOfMemoryError();
        }
        int i2 = this.size + adVar.size;
        if (i2 > this.bXo.length) {
            this.bXo = Arrays.copyOf(this.bXo, i2);
        }
        System.arraycopy(adVar.bXo, 0, this.bXo, this.size, adVar.size);
        this.size = i2;
        this.modCount++;
        return true;
    }

    @Override // com.google.a.d, java.util.List
    public final boolean remove(Object obj) {
        yL();
        for (int i2 = 0; i2 < this.size; i2++) {
            if (obj.equals(Integer.valueOf(this.bXo[i2]))) {
                System.arraycopy(this.bXo, i2 + 1, this.bXo, i2, (this.size - i2) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private void gG(int i2) {
        if (i2 < 0 || i2 >= this.size) {
            throw new IndexOutOfBoundsException(gH(i2));
        }
    }

    private String gH(int i2) {
        return "Index:" + i2 + ", Size:" + this.size;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.a.d, java.util.List, java.util.AbstractList
    public final /* synthetic */ Integer remove(int i2) {
        yL();
        gG(i2);
        int i3 = this.bXo[i2];
        if (i2 < this.size - 1) {
            System.arraycopy(this.bXo, i2 + 1, this.bXo, i2, (this.size - i2) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i3);
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i2) {
        return Integer.valueOf(getInt(i2));
    }
}
