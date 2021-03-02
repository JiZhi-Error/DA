package com.google.a;

import com.google.a.a;
import com.google.a.at;
import com.google.a.l;
import com.google.a.x;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class m extends a {
    private int bNa = -1;
    final l.a bTT;
    final x<l.f> bTU;
    final l.f[] bTV;
    final cc bTW;

    m(l.a aVar, x<l.f> xVar, l.f[] fVarArr, cc ccVar) {
        this.bTT = aVar;
        this.bTU = xVar;
        this.bTV = fVarArr;
        this.bTW = ccVar;
    }

    public static a d(l.a aVar) {
        return new a(aVar, (byte) 0);
    }

    @Override // com.google.a.az
    public final l.a AS() {
        return this.bTT;
    }

    @Override // com.google.a.az
    public final Map<l.f, Object> FS() {
        return this.bTU.FS();
    }

    @Override // com.google.a.az
    public final boolean e(l.f fVar) {
        g(fVar);
        return this.bTU.a(fVar);
    }

    @Override // com.google.a.az
    public final Object f(l.f fVar) {
        g(fVar);
        Object b2 = this.bTU.b(fVar);
        if (b2 != null) {
            return b2;
        }
        if (fVar.FJ()) {
            return Collections.emptyList();
        }
        if (fVar.bSS.bTz == l.f.a.MESSAGE) {
            return c(fVar.FN());
        }
        return fVar.getDefaultValue();
    }

    @Override // com.google.a.az
    public final cc Ax() {
        return this.bTW;
    }

    static boolean a(l.a aVar, x<l.f> xVar) {
        for (l.f fVar : aVar.getFields()) {
            if (fVar.FH() && !xVar.a(fVar)) {
                return false;
            }
        }
        return xVar.isInitialized();
    }

    @Override // com.google.a.a, com.google.a.ax
    public final boolean isInitialized() {
        return a(this.bTT, this.bTU);
    }

    @Override // com.google.a.aw, com.google.a.a
    public final void a(i iVar) {
        int i2 = 0;
        if (this.bTT.bSq.AG().bRt) {
            x<l.f> xVar = this.bTU;
            while (i2 < xVar.bUB.Hx()) {
                x.a(xVar.bUB.gM(i2), iVar);
                i2++;
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : xVar.bUB.Hy()) {
                x.a(entry, iVar);
            }
            this.bTW.c(iVar);
            return;
        }
        x<l.f> xVar2 = this.bTU;
        while (i2 < xVar2.bUB.Hx()) {
            Map.Entry<FieldDescriptorType, Object> gM = xVar2.bUB.gM(i2);
            x.a((x.a<?>) gM.getKey(), gM.getValue(), iVar);
            i2++;
        }
        for (Map.Entry<FieldDescriptorType, Object> entry2 : xVar2.bUB.Hy()) {
            x.a((x.a<?>) entry2.getKey(), entry2.getValue(), iVar);
        }
        this.bTW.a(iVar);
    }

    @Override // com.google.a.aw, com.google.a.a
    public final int yC() {
        int i2;
        int i3 = 0;
        int i4 = this.bNa;
        if (i4 == -1) {
            if (this.bTT.bSq.AG().bRt) {
                x<l.f> xVar = this.bTU;
                int i5 = 0;
                while (true) {
                    i2 = i3;
                    if (i5 >= xVar.bUB.Hx()) {
                        break;
                    }
                    i3 = x.c(xVar.bUB.gM(i5)) + i2;
                    i5++;
                }
                for (Map.Entry<FieldDescriptorType, Object> entry : xVar.bUB.Hy()) {
                    i2 += x.c(entry);
                }
                i4 = this.bTW.HL() + i2;
            } else {
                i4 = this.bTU.yC() + this.bTW.yC();
            }
            this.bNa = i4;
        }
        return i4;
    }

    /* access modifiers changed from: private */
    /* renamed from: FT */
    public a AO() {
        return new a(this.bTT, (byte) 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: FU */
    public a AN() {
        return AO().c(this);
    }

    @Override // com.google.a.aw
    public final bj<m> AK() {
        return new c<m>() {
            /* class com.google.a.m.AnonymousClass1 */

            /* access modifiers changed from: private */
            /* renamed from: C */
            public m d(h hVar, r rVar) {
                a d2 = m.d(m.this.bTT);
                try {
                    d2.c(hVar, rVar);
                    return d2.Bo();
                } catch (af e2) {
                    e2.bXr = d2.Bo();
                    throw e2;
                } catch (IOException e3) {
                    af afVar = new af(e3);
                    afVar.bXr = d2.Bo();
                    throw afVar;
                }
            }
        };
    }

    public static final class a extends a.AbstractC0085a<a> {
        private final l.a bTT;
        private x<l.f> bTU;
        private final l.f[] bTV;
        private cc bTW;

        /* synthetic */ a(l.a aVar, byte b2) {
            this(aVar);
        }

        private a(l.a aVar) {
            this.bTT = aVar;
            this.bTU = x.Gi();
            this.bTW = cc.HK();
            this.bTV = new l.f[aVar.bSq.AE()];
            if (aVar.bSq.AG().bRv) {
                for (l.f fVar : this.bTT.getFields()) {
                    if (fVar.bSS.bTz == l.f.a.MESSAGE) {
                        this.bTU.a(fVar, m.c(fVar.FN()));
                    } else {
                        this.bTU.a(fVar, fVar.getDefaultValue());
                    }
                }
            }
        }

        /* renamed from: B */
        public final a c(at atVar) {
            if (!(atVar instanceof m)) {
                return (a) super.c(atVar);
            }
            m mVar = (m) atVar;
            if (mVar.bTT != this.bTT) {
                throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
            }
            yL();
            this.bTU.a(mVar.bTU);
            a(mVar.bTW);
            for (int i2 = 0; i2 < this.bTV.length; i2++) {
                if (this.bTV[i2] == null) {
                    this.bTV[i2] = mVar.bTV[i2];
                } else if (!(mVar.bTV[i2] == null || this.bTV[i2] == mVar.bTV[i2])) {
                    this.bTU.c(this.bTV[i2]);
                    this.bTV[i2] = mVar.bTV[i2];
                }
            }
            return this;
        }

        /* access modifiers changed from: private */
        /* renamed from: FV */
        public m Bp() {
            if (isInitialized()) {
                return Bo();
            }
            throw b(new m(this.bTT, this.bTU, (l.f[]) Arrays.copyOf(this.bTV, this.bTV.length), this.bTW));
        }

        /* renamed from: FW */
        public final m Bo() {
            this.bTU.yK();
            return new m(this.bTT, this.bTU, (l.f[]) Arrays.copyOf(this.bTV, this.bTV.length), this.bTW);
        }

        /* access modifiers changed from: private */
        /* renamed from: FX */
        public a yG() {
            a aVar = new a(this.bTT);
            aVar.bTU.a(this.bTU);
            aVar.a(this.bTW);
            System.arraycopy(this.bTV, 0, aVar.bTV, 0, this.bTV.length);
            return aVar;
        }

        @Override // com.google.a.ax
        public final boolean isInitialized() {
            return m.a(this.bTT, this.bTU);
        }

        @Override // com.google.a.az, com.google.a.at.a
        public final l.a AS() {
            return this.bTT;
        }

        @Override // com.google.a.az
        public final Map<l.f, Object> FS() {
            return this.bTU.FS();
        }

        @Override // com.google.a.a.AbstractC0085a
        public final boolean a(l.j jVar) {
            d(jVar);
            if (this.bTV[jVar.index] == null) {
                return false;
            }
            return true;
        }

        @Override // com.google.a.a.AbstractC0085a
        public final l.f b(l.j jVar) {
            d(jVar);
            return this.bTV[jVar.index];
        }

        @Override // com.google.a.az
        public final boolean e(l.f fVar) {
            g(fVar);
            return this.bTU.a(fVar);
        }

        @Override // com.google.a.az
        public final Object f(l.f fVar) {
            g(fVar);
            Object b2 = this.bTU.b(fVar);
            if (b2 != null) {
                return b2;
            }
            if (fVar.FJ()) {
                return Collections.emptyList();
            }
            if (fVar.bSS.bTz == l.f.a.MESSAGE) {
                return m.c(fVar.FN());
            }
            return fVar.getDefaultValue();
        }

        @Override // com.google.a.az
        public final cc Ax() {
            return this.bTW;
        }

        /* access modifiers changed from: private */
        /* renamed from: aa */
        public a a(cc ccVar) {
            this.bTW = cc.ac(this.bTW).ae(ccVar).Bp();
            return this;
        }

        private static void am(Object obj) {
            ae.checkNotNull(obj);
            if (!(obj instanceof l.e)) {
                throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
            }
        }

        private void yL() {
            if (this.bTU.bUC) {
                this.bTU = this.bTU.clone();
            }
        }

        private void g(l.f fVar) {
            if (fVar.bSs != this.bTT) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        private void d(l.j jVar) {
            if (jVar.bSs != this.bTT) {
                throw new IllegalArgumentException("OneofDescriptor does not match message type.");
            }
        }

        @Override // com.google.a.at.a
        public final /* bridge */ /* synthetic */ at.a f(cc ccVar) {
            this.bTW = ccVar;
            return this;
        }

        @Override // com.google.a.at.a
        public final /* synthetic */ at.a e(l.f fVar, Object obj) {
            g(fVar);
            yL();
            this.bTU.b(fVar, obj);
            return this;
        }

        @Override // com.google.a.at.a
        public final /* synthetic */ at.a f(l.f fVar, Object obj) {
            g(fVar);
            yL();
            if (fVar.bSS == l.f.b.ENUM) {
                if (fVar.FJ()) {
                    for (Object obj2 : (List) obj) {
                        am(obj2);
                    }
                } else {
                    am(obj);
                }
            }
            l.j jVar = fVar.bSU;
            if (jVar != null) {
                int i2 = jVar.index;
                l.f fVar2 = this.bTV[i2];
                if (!(fVar2 == null || fVar2 == fVar)) {
                    this.bTU.c(fVar2);
                }
                this.bTV[i2] = fVar;
            } else if (fVar.bSr.FQ() == l.g.a.PROTO3 && !fVar.FJ() && fVar.bSS.bTz != l.f.a.MESSAGE && obj.equals(fVar.getDefaultValue())) {
                this.bTU.c(fVar);
                return this;
            }
            this.bTU.a(fVar, obj);
            return this;
        }

        @Override // com.google.a.at.a
        public final /* synthetic */ at.a h(l.f fVar) {
            g(fVar);
            if (fVar.bSS.bTz == l.f.a.MESSAGE) {
                return new a(fVar.FN());
            }
            throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
        }

        @Override // com.google.a.ax
        public final /* synthetic */ aw AP() {
            return m.c(this.bTT);
        }

        @Override // com.google.a.az
        public final /* synthetic */ at AQ() {
            return m.c(this.bTT);
        }
    }

    public static m c(l.a aVar) {
        return new m(aVar, x.Gj(), new l.f[aVar.bSq.AE()], cc.HK());
    }

    private void g(l.f fVar) {
        if (fVar.bSs != this.bTT) {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }
    }

    @Override // com.google.a.ax
    public final /* synthetic */ aw AP() {
        return c(this.bTT);
    }

    @Override // com.google.a.az
    public final /* synthetic */ at AQ() {
        return c(this.bTT);
    }
}
