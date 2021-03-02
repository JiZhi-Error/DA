package com.tencent.mm.vending.base;

import com.tencent.mm.vending.base.Vending;

public abstract class b<_Struct, _Change> extends Vending<_Struct, Integer, _Change> {
    public int QZi = 5;
    private a QZj = new a((byte) 0);
    public int mCount = 0;

    /* access modifiers changed from: protected */
    public abstract _Struct aac(int i2);

    /* access modifiers changed from: protected */
    public abstract int hdn();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.vending.base.Vending
    public /* synthetic */ boolean invalidIndex(Integer num) {
        return num.intValue() < 0;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.vending.base.Vending$i, java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.vending.base.Vending
    public /* synthetic */ void requestIndexImpl(Vending.i iVar, Integer num) {
        Integer num2 = num;
        int i2 = this.mCount;
        if (i2 > 0) {
            lR(Math.min(i2 - 1, num2.intValue()), Math.min(i2 - 1, num2.intValue() + this.QZi));
            lR(Math.max(Math.min(0, num2.intValue()), num2.intValue()), Math.max(Math.min(0, num2.intValue()), num2.intValue() - this.QZi));
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.vending.base.Vending
    public /* synthetic */ Object resolveAsynchronous(Integer num) {
        return aac(num.intValue());
    }

    public final <T> T get(int i2) {
        if (this.mCount != 0) {
            return (T) super.get(Integer.valueOf(i2));
        }
        com.tencent.mm.vending.f.a.e("Vending.ForwardVending", "mCount is 0, why call get()?", new Object[0]);
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.vending.base.Vending
    public void synchronizing(int i2, Object obj) {
        this.mCount = hdn();
        com.tencent.mm.vending.f.a.i("Vending.ForwardVending", "the count %s", Integer.valueOf(this.mCount));
    }

    private void lR(int i2, int i3) {
        int[] iArr;
        int i4;
        boolean z = i2 >= i3;
        int min = Math.min(i2, i3);
        int max = Math.max(i2, i3);
        synchronized (this.QZj) {
            a aVar = this.QZj;
            if (!aVar.initialized) {
                aVar.set(min, max);
                aVar.initialized = true;
                iArr = new int[]{min, max};
            } else {
                int i5 = aVar.Al;
                int i6 = aVar.An;
                if (i5 > max || i6 < min) {
                    if (i5 > max + 1 || i6 < min - 1) {
                        aVar.set(min, max);
                    }
                    iArr = new int[]{min, max};
                } else if (min < i5) {
                    if (max > i6) {
                        aVar.set(min, max);
                        iArr = new int[]{min, i5 - 1, i6 + 1, max};
                    } else {
                        aVar.set(min, i6);
                        iArr = new int[]{min, i5 - 1};
                    }
                } else if (max > i6) {
                    aVar.set(i5, max);
                    iArr = new int[]{i6 + 1, max};
                } else {
                    iArr = null;
                }
            }
        }
        if (iArr != null) {
            int length = z ? iArr.length - 2 : 0;
            while (true) {
                if (z) {
                    if (length < 0) {
                        return;
                    }
                } else if (length >= iArr.length) {
                    return;
                }
                int i7 = iArr[length];
                int i8 = iArr[length + 1];
                int abs = Math.abs(i7 - i8);
                for (int i9 = 0; i9 <= abs; i9++) {
                    if (z) {
                        i4 = i8 - i9;
                    } else {
                        i4 = i7 + i9;
                    }
                    Vending.f<_Index> loader = getLoader();
                    Integer valueOf = Integer.valueOf(i4);
                    if (!loader.kQW.get()) {
                        synchronized (loader.QZp) {
                            Vending.f.b bVar = loader.QZn.get(valueOf);
                            if (bVar == null || bVar == Vending.f.b.NIL) {
                                loader.QZn.put(valueOf, Vending.f.b.PENDING);
                                loader.mVendingHandler.sendMessage(loader.mVendingHandler.obtainMessage(0, valueOf));
                            }
                        }
                    }
                }
                length = z ? length - 2 : length + 2;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.vending.base.Vending
    public void loaderClear() {
        synchronized (this.QZj) {
            a aVar = this.QZj;
            aVar.Al = -1;
            aVar.An = -1;
            aVar.initialized = false;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        public int Al;
        public int An;
        boolean initialized;

        private a() {
            this.Al = -1;
            this.An = -1;
            this.initialized = false;
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final void set(int i2, int i3) {
            this.Al = i2;
            this.An = i3;
        }
    }
}
