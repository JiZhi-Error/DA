package com.c.a.c;

public abstract class n<T> extends b implements p<T> {
    public static final Object cqE = new Object();
    public static final a cqF = new a();
    protected transient Object[] cqC;
    protected final p<T> cqD = this;

    /* access modifiers changed from: package-private */
    public static class a {
        a() {
        }
    }

    /* renamed from: Ku */
    public n<T> clone() {
        n<T> nVar = (n) super.clone();
        nVar.cqC = (Object[]) this.cqC.clone();
        return nVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.c.a.c.b
    public final int capacity() {
        return this.cqC.length;
    }

    /* access modifiers changed from: protected */
    @Override // com.c.a.c.b
    public void removeAt(int i2) {
        this.cqC[i2] = cqE;
        super.removeAt(i2);
    }

    /* access modifiers changed from: protected */
    @Override // com.c.a.c.b
    public int hw(int i2) {
        int hw = super.hw(i2);
        this.cqC = new Object[hw];
        return hw;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.c.a.c.s<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean b(s<T> sVar) {
        Object[] objArr = this.cqC;
        int length = objArr.length;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return true;
            }
            if (objArr[i2] != null && objArr[i2] != cqE && !sVar.aD(objArr[i2])) {
                return false;
            }
            length = i2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean contains(Object obj) {
        return aH(obj) >= 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: com.c.a.c.p<T> */
    /* JADX DEBUG: Multi-variable search result rejected for r5v4, resolved type: com.c.a.c.p<T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    public final int aH(T t) {
        Object[] objArr = this.cqC;
        int length = objArr.length;
        int aG = this.cqD.aG(t) & Integer.MAX_VALUE;
        int i2 = aG % length;
        Object obj = objArr[i2];
        if (obj != null && (obj == cqE || !this.cqD.equals(obj, t))) {
            int i3 = (aG % (length - 2)) + 1;
            while (true) {
                i2 -= i3;
                if (i2 < 0) {
                    i2 += length;
                }
                obj = objArr[i2];
                if (obj == null || (obj != cqE && this.cqD.equals(obj, t))) {
                    break;
                }
            }
        }
        if (obj == null) {
            return -1;
        }
        return i2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: com.c.a.c.p<T> */
    /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: com.c.a.c.p<T> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v6, resolved type: com.c.a.c.p<T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    public final int aI(T t) {
        int i2;
        Object obj;
        int i3;
        Object[] objArr = this.cqC;
        int length = objArr.length;
        int aG = this.cqD.aG(t) & Integer.MAX_VALUE;
        int i4 = aG % length;
        Object obj2 = objArr[i4];
        if (obj2 == null) {
            return i4;
        }
        if (obj2 != cqE && this.cqD.equals(obj2, t)) {
            return (-i4) - 1;
        }
        int i5 = (aG % (length - 2)) + 1;
        int i6 = obj2 == cqE ? i4 : -1;
        while (true) {
            i2 = i4 - i5;
            if (i2 < 0) {
                i2 += length;
            }
            obj = objArr[i2];
            if (i6 == -1 && obj == cqE) {
                i6 = i2;
            }
            if (obj != null && obj != cqE && !this.cqD.equals(obj, t)) {
                i4 = i2;
            }
        }
        if (obj == cqE) {
            i3 = i2;
            while (obj != null && (obj == cqE || !this.cqD.equals(obj, t))) {
                int i7 = i3 - i5;
                if (i7 < 0) {
                    i7 += length;
                }
                obj = objArr[i7];
                i3 = i7;
            }
        } else {
            i3 = i2;
        }
        if (obj == null || obj == cqE) {
            return i6 != -1 ? i6 : i3;
        }
        return (-i3) - 1;
    }

    @Override // com.c.a.c.p
    public final int aG(T t) {
        if (t != null) {
            return t.hashCode();
        }
        return 0;
    }

    @Override // com.c.a.c.p
    public final boolean equals(T t, T t2) {
        if (t != null) {
            return t.equals(t2);
        }
        return t2 == null;
    }

    /* access modifiers changed from: protected */
    public final void w(Object obj, Object obj2) {
        throw new IllegalArgumentException("Equal objects must have equal hashcodes. During rehashing, Trove discovered that the following two objects claim to be equal (as in java.lang.Object.equals() or TObjectHashingStrategy.equals()) but their hashCodes (or those calculated by your TObjectHashingStrategy) are not equal.This violates the general contract of java.lang.Object.hashCode().  See bullet point two in that method's documentation. object #1 =" + obj + (obj == null ? "" : " (" + obj.getClass() + ")") + ", hashCode=" + this.cqD.aG(obj) + "; object #2 =" + obj2 + (obj2 == null ? "" : " (" + obj2.getClass() + ")") + ", hashCode=" + this.cqD.aG(obj2));
    }
}
