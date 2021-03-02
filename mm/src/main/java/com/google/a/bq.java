package com.google.a;

import com.google.a.a;
import com.google.a.a.AbstractC0085a;
import com.google.a.az;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class bq<MType extends a, BType extends a.AbstractC0085a, IType extends az> implements a.b {
    List<MType> bNN;
    boolean bWv;
    a.b bYP;
    private boolean bYQ;
    List<bu<MType, BType, IType>> bYR;
    private b<MType, BType, IType> bYS;
    private a<MType, BType, IType> bYT;
    private c<MType, BType, IType> bYU;

    public bq(List<MType> list, boolean z, a.b bVar, boolean z2) {
        this.bNN = list;
        this.bYQ = z;
        this.bYP = bVar;
        this.bWv = z2;
    }

    private void Hm() {
        if (!this.bYQ) {
            this.bNN = new ArrayList(this.bNN);
            this.bYQ = true;
        }
    }

    public final int getCount() {
        return this.bNN.size();
    }

    public final boolean isEmpty() {
        return this.bNN.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public final MType s(int i2, boolean z) {
        if (this.bYR == null) {
            return this.bNN.get(i2);
        }
        bu<MType, BType, IType> buVar = this.bYR.get(i2);
        if (buVar == null) {
            return this.bNN.get(i2);
        }
        return z ? buVar.Hv() : buVar.Hu();
    }

    public final bq<MType, BType, IType> a(MType mtype) {
        ae.checkNotNull(mtype);
        Hm();
        this.bNN.add(mtype);
        if (this.bYR != null) {
            this.bYR.add(null);
        }
        onChanged();
        Hn();
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.a.bq<MType extends com.google.a.a, BType extends com.google.a.a$a, IType extends com.google.a.az> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004b A[LOOP:1: B:16:0x0045->B:18:0x004b, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.a.bq<MType, BType, IType> a(java.lang.Iterable<? extends MType> r4) {
        /*
            r3 = this;
            java.util.Iterator r1 = r4.iterator()
        L_0x0004:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x0014
            java.lang.Object r0 = r1.next()
            com.google.a.a r0 = (com.google.a.a) r0
            com.google.a.ae.checkNotNull(r0)
            goto L_0x0004
        L_0x0014:
            r0 = -1
            boolean r1 = r4 instanceof java.util.Collection
            if (r1 == 0) goto L_0x005c
            r0 = r4
            java.util.Collection r0 = (java.util.Collection) r0
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0023
        L_0x0022:
            return r3
        L_0x0023:
            int r0 = r0.size()
            r1 = r0
        L_0x0028:
            r3.Hm()
            if (r1 < 0) goto L_0x0041
            java.util.List<MType extends com.google.a.a> r0 = r3.bNN
            boolean r0 = r0 instanceof java.util.ArrayList
            if (r0 == 0) goto L_0x0041
            java.util.List<MType extends com.google.a.a> r0 = r3.bNN
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.util.List<MType extends com.google.a.a> r2 = r3.bNN
            int r2 = r2.size()
            int r1 = r1 + r2
            r0.ensureCapacity(r1)
        L_0x0041:
            java.util.Iterator r1 = r4.iterator()
        L_0x0045:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x0055
            java.lang.Object r0 = r1.next()
            com.google.a.a r0 = (com.google.a.a) r0
            r3.a(r0)
            goto L_0x0045
        L_0x0055:
            r3.onChanged()
            r3.Hn()
            goto L_0x0022
        L_0x005c:
            r1 = r0
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.bq.a(java.lang.Iterable):com.google.a.bq");
    }

    public final List<MType> build() {
        boolean z;
        this.bWv = true;
        if (!this.bYQ && this.bYR == null) {
            return this.bNN;
        }
        if (!this.bYQ) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.bNN.size()) {
                    z = true;
                    break;
                }
                MType mtype = this.bNN.get(i2);
                bu<MType, BType, IType> buVar = this.bYR.get(i2);
                if (!(buVar == null || buVar.Hv() == mtype)) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (z) {
                return this.bNN;
            }
        }
        Hm();
        for (int i3 = 0; i3 < this.bNN.size(); i3++) {
            this.bNN.set(i3, s(i3, true));
        }
        this.bNN = Collections.unmodifiableList(this.bNN);
        this.bYQ = false;
        return this.bNN;
    }

    private void onChanged() {
        if (this.bWv && this.bYP != null) {
            this.bYP.yH();
            this.bWv = false;
        }
    }

    @Override // com.google.a.a.b
    public final void yH() {
        onChanged();
    }

    private void Hn() {
        if (this.bYS != null) {
            this.bYS.Ho();
        }
        if (this.bYT != null) {
            this.bYT.Ho();
        }
        if (this.bYU != null) {
            this.bYU.Ho();
        }
    }

    /* access modifiers changed from: package-private */
    public static class b<MType extends a, BType extends a.AbstractC0085a, IType extends az> extends AbstractList<MType> implements List<MType> {
        bq<MType, BType, IType> bYV;

        public final int size() {
            return this.bYV.getCount();
        }

        /* access modifiers changed from: package-private */
        public final void Ho() {
            this.modCount++;
        }

        @Override // java.util.List, java.util.AbstractList
        public final /* synthetic */ Object get(int i2) {
            return this.bYV.s(i2, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static class a<MType extends a, BType extends a.AbstractC0085a, IType extends az> extends AbstractList<BType> implements List<BType> {
        bq<MType, BType, IType> bYV;

        public final int size() {
            return this.bYV.getCount();
        }

        /* access modifiers changed from: package-private */
        public final void Ho() {
            this.modCount++;
        }

        @Override // java.util.List, java.util.AbstractList
        public final /* synthetic */ Object get(int i2) {
            bq<MType, BType, IType> bqVar = this.bYV;
            if (bqVar.bYR == null) {
                bqVar.bYR = new ArrayList(bqVar.bNN.size());
                for (int i3 = 0; i3 < bqVar.bNN.size(); i3++) {
                    bqVar.bYR.add(null);
                }
            }
            bu<MType, BType, IType> buVar = bqVar.bYR.get(i2);
            if (buVar == null) {
                bu<MType, BType, IType> buVar2 = new bu<>(bqVar.bNN.get(i2), bqVar, bqVar.bWv);
                bqVar.bYR.set(i2, buVar2);
                buVar = buVar2;
            }
            return buVar.Hw();
        }
    }

    /* access modifiers changed from: package-private */
    public static class c<MType extends a, BType extends a.AbstractC0085a, IType extends az> extends AbstractList<IType> implements List<IType> {
        bq<MType, BType, IType> bYV;

        public final int size() {
            return this.bYV.getCount();
        }

        /* access modifiers changed from: package-private */
        public final void Ho() {
            this.modCount++;
        }

        @Override // java.util.List, java.util.AbstractList
        public final /* bridge */ /* synthetic */ Object get(int i2) {
            bq<MType, BType, IType> bqVar = this.bYV;
            if (bqVar.bYR == null) {
                return bqVar.bNN.get(i2);
            }
            bu<MType, BType, IType> buVar = bqVar.bYR.get(i2);
            if (buVar == null) {
                return bqVar.bNN.get(i2);
            }
            if (buVar.bZa != null) {
                return buVar.bZa;
            }
            return buVar.bZb;
        }
    }
}
