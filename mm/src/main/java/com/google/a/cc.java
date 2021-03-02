package com.google.a;

import com.google.a.aw;
import com.google.a.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class cc implements aw {
    private static final cc bZM = new cc(Collections.emptyMap(), Collections.emptyMap());
    private static final c bZP = new c();
    final Map<Integer, b> bZN;
    private final Map<Integer, b> bZO;

    private cc() {
        this.bZN = null;
        this.bZO = null;
    }

    public static a HJ() {
        return a.HN();
    }

    public static cc HK() {
        return bZM;
    }

    cc(Map<Integer, b> map, Map<Integer, b> map2) {
        this.bZN = map;
        this.bZO = map2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cc) || !this.bZN.equals(((cc) obj).bZN)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.bZN.hashCode();
    }

    @Override // com.google.a.aw
    public final void a(i iVar) {
        for (Map.Entry<Integer, b> entry : this.bZN.entrySet()) {
            b value = entry.getValue();
            int intValue = entry.getKey().intValue();
            for (Long l : value.bZT) {
                iVar.n(intValue, l.longValue());
            }
            for (Integer num : value.bZU) {
                iVar.bt(intValue, num.intValue());
            }
            for (Long l2 : value.bZV) {
                iVar.o(intValue, l2.longValue());
            }
            for (g gVar : value.bZW) {
                iVar.a(intValue, gVar);
            }
            for (cc ccVar : value.bZX) {
                iVar.e(intValue, ccVar);
            }
        }
    }

    public final String toString() {
        return bx.ab(this);
    }

    @Override // com.google.a.aw
    public final g yI() {
        try {
            g.f fE = g.fE(yC());
            a(fE.bNn);
            return fE.yS();
        } catch (IOException e2) {
            throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e2);
        }
    }

    @Override // com.google.a.aw
    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[yC()];
            i C = i.C(bArr);
            a(C);
            C.zA();
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e2);
        }
    }

    @Override // com.google.a.aw
    public final int yC() {
        int i2 = 0;
        for (Map.Entry<Integer, b> entry : this.bZN.entrySet()) {
            i2 = entry.getValue().gS(entry.getKey().intValue()) + i2;
        }
        return i2;
    }

    public final void c(i iVar) {
        for (Map.Entry<Integer, b> entry : this.bZN.entrySet()) {
            entry.getValue().a(entry.getKey().intValue(), iVar);
        }
    }

    public final int HL() {
        int i2 = 0;
        for (Map.Entry<Integer, b> entry : this.bZN.entrySet()) {
            i2 = entry.getValue().gT(entry.getKey().intValue()) + i2;
        }
        return i2;
    }

    @Override // com.google.a.ax
    public final boolean isInitialized() {
        return true;
    }

    public static final class a implements aw.a {
        private Map<Integer, b> bZN;
        private int bZQ;
        private b.a bZR;

        private a() {
        }

        private b.a gQ(int i2) {
            if (this.bZR != null) {
                if (i2 == this.bZQ) {
                    return this.bZR;
                }
                b(this.bZQ, this.bZR.HQ());
            }
            if (i2 == 0) {
                return null;
            }
            b bVar = this.bZN.get(Integer.valueOf(i2));
            this.bZQ = i2;
            this.bZR = b.HO();
            if (bVar != null) {
                this.bZR.f(bVar);
            }
            return this.bZR;
        }

        /* renamed from: HM */
        public final cc Bp() {
            cc ccVar;
            gQ(0);
            if (this.bZN.isEmpty()) {
                ccVar = cc.HK();
            } else {
                ccVar = new cc(Collections.unmodifiableMap(this.bZN), Collections.unmodifiableMap(((TreeMap) this.bZN).descendingMap()));
            }
            this.bZN = null;
            return ccVar;
        }

        public final a ae(cc ccVar) {
            if (ccVar != cc.HK()) {
                for (Map.Entry entry : ccVar.bZN.entrySet()) {
                    a(((Integer) entry.getKey()).intValue(), (b) entry.getValue());
                }
            }
            return this;
        }

        public final a a(int i2, b bVar) {
            if (i2 == 0) {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            }
            if (gR(i2)) {
                gQ(i2).f(bVar);
            } else {
                b(i2, bVar);
            }
            return this;
        }

        public final a bx(int i2, int i3) {
            if (i2 == 0) {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            }
            gQ(i2).aH((long) i3);
            return this;
        }

        private boolean gR(int i2) {
            if (i2 != 0) {
                return i2 == this.bZQ || this.bZN.containsKey(Integer.valueOf(i2));
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        private a b(int i2, b bVar) {
            if (i2 == 0) {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            }
            if (this.bZR != null && this.bZQ == i2) {
                this.bZR = null;
                this.bZQ = 0;
            }
            if (this.bZN.isEmpty()) {
                this.bZN = new TreeMap();
            }
            this.bZN.put(Integer.valueOf(i2), bVar);
            return this;
        }

        public final a b(h hVar) {
            int yT;
            do {
                yT = hVar.yT();
                if (yT == 0) {
                    break;
                }
            } while (a(yT, hVar));
            return this;
        }

        public final boolean a(int i2, h hVar) {
            int gY = cj.gY(i2);
            switch (cj.gX(i2)) {
                case 0:
                    gQ(gY).aH(hVar.yV());
                    return true;
                case 1:
                    gQ(gY).aI(hVar.yX());
                    return true;
                case 2:
                    gQ(gY).h(hVar.zb());
                    return true;
                case 3:
                    a HJ = cc.HJ();
                    hVar.a(gY, HJ, p.FY());
                    gQ(gY).af(HJ.Bp());
                    return true;
                case 4:
                    return false;
                case 5:
                    gQ(gY).gU(hVar.yY());
                    return true;
                default:
                    throw af.GL();
            }
        }

        public final a g(g gVar) {
            try {
                h yQ = gVar.yQ();
                b(yQ);
                yQ.fF(0);
                return this;
            } catch (af e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e3);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: I */
        public a x(byte[] bArr) {
            try {
                h B = h.B(bArr);
                b(B);
                B.fF(0);
                return this;
            } catch (af e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e3);
            }
        }

        @Override // com.google.a.ax
        public final boolean isInitialized() {
            return true;
        }

        @Override // java.lang.Object
        public final /* synthetic */ Object clone() {
            gQ(0);
            return cc.HJ().ae(new cc(this.bZN, Collections.unmodifiableMap(((TreeMap) this.bZN).descendingMap())));
        }

        @Override // com.google.a.aw.a
        public final /* synthetic */ aw.a a(aw awVar) {
            if (awVar instanceof cc) {
                return ae((cc) awVar);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        @Override // com.google.a.aw.a
        public final /* synthetic */ aw.a c(h hVar, r rVar) {
            return b(hVar);
        }

        @Override // com.google.a.ax
        public final /* synthetic */ aw AP() {
            return cc.HK();
        }

        static /* synthetic */ a HN() {
            a aVar = new a();
            aVar.bZN = Collections.emptyMap();
            aVar.bZQ = 0;
            aVar.bZR = null;
            return aVar;
        }
    }

    public static final class b {
        private static final b bZS = HO().HQ();
        List<Long> bZT;
        List<Integer> bZU;
        List<Long> bZV;
        List<g> bZW;
        List<cc> bZX;

        private /* synthetic */ b(byte b2) {
            this();
        }

        private b() {
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            return Arrays.equals(HP(), ((b) obj).HP());
        }

        public final int hashCode() {
            return Arrays.hashCode(HP());
        }

        private Object[] HP() {
            return new Object[]{this.bZT, this.bZU, this.bZV, this.bZW, this.bZX};
        }

        public final int gS(int i2) {
            int i3;
            int i4 = 0;
            Iterator<Long> it = this.bZT.iterator();
            while (true) {
                i3 = i4;
                if (!it.hasNext()) {
                    break;
                }
                i4 = i.p(i2, it.next().longValue()) + i3;
            }
            for (Integer num : this.bZU) {
                num.intValue();
                i3 += i.fP(i2);
            }
            for (Long l : this.bZV) {
                l.longValue();
                i3 += i.fQ(i2);
            }
            for (g gVar : this.bZW) {
                i3 += i.c(i2, gVar);
            }
            for (cc ccVar : this.bZX) {
                i3 += i.f(i2, ccVar);
            }
            return i3;
        }

        public final void a(int i2, i iVar) {
            for (g gVar : this.bZW) {
                iVar.b(i2, gVar);
            }
        }

        public final int gT(int i2) {
            int i3 = 0;
            for (g gVar : this.bZW) {
                i3 = i.d(i2, gVar) + i3;
            }
            return i3;
        }

        public static final class a {
            b bZY;

            a() {
            }

            public final b HQ() {
                if (this.bZY.bZT == null) {
                    this.bZY.bZT = Collections.emptyList();
                } else {
                    this.bZY.bZT = Collections.unmodifiableList(this.bZY.bZT);
                }
                if (this.bZY.bZU == null) {
                    this.bZY.bZU = Collections.emptyList();
                } else {
                    this.bZY.bZU = Collections.unmodifiableList(this.bZY.bZU);
                }
                if (this.bZY.bZV == null) {
                    this.bZY.bZV = Collections.emptyList();
                } else {
                    this.bZY.bZV = Collections.unmodifiableList(this.bZY.bZV);
                }
                if (this.bZY.bZW == null) {
                    this.bZY.bZW = Collections.emptyList();
                } else {
                    this.bZY.bZW = Collections.unmodifiableList(this.bZY.bZW);
                }
                if (this.bZY.bZX == null) {
                    this.bZY.bZX = Collections.emptyList();
                } else {
                    this.bZY.bZX = Collections.unmodifiableList(this.bZY.bZX);
                }
                b bVar = this.bZY;
                this.bZY = null;
                return bVar;
            }

            public final a f(b bVar) {
                if (!bVar.bZT.isEmpty()) {
                    if (this.bZY.bZT == null) {
                        this.bZY.bZT = new ArrayList();
                    }
                    this.bZY.bZT.addAll(bVar.bZT);
                }
                if (!bVar.bZU.isEmpty()) {
                    if (this.bZY.bZU == null) {
                        this.bZY.bZU = new ArrayList();
                    }
                    this.bZY.bZU.addAll(bVar.bZU);
                }
                if (!bVar.bZV.isEmpty()) {
                    if (this.bZY.bZV == null) {
                        this.bZY.bZV = new ArrayList();
                    }
                    this.bZY.bZV.addAll(bVar.bZV);
                }
                if (!bVar.bZW.isEmpty()) {
                    if (this.bZY.bZW == null) {
                        this.bZY.bZW = new ArrayList();
                    }
                    this.bZY.bZW.addAll(bVar.bZW);
                }
                if (!bVar.bZX.isEmpty()) {
                    if (this.bZY.bZX == null) {
                        this.bZY.bZX = new ArrayList();
                    }
                    this.bZY.bZX.addAll(bVar.bZX);
                }
                return this;
            }

            public final a aH(long j2) {
                if (this.bZY.bZT == null) {
                    this.bZY.bZT = new ArrayList();
                }
                this.bZY.bZT.add(Long.valueOf(j2));
                return this;
            }

            public final a gU(int i2) {
                if (this.bZY.bZU == null) {
                    this.bZY.bZU = new ArrayList();
                }
                this.bZY.bZU.add(Integer.valueOf(i2));
                return this;
            }

            public final a aI(long j2) {
                if (this.bZY.bZV == null) {
                    this.bZY.bZV = new ArrayList();
                }
                this.bZY.bZV.add(Long.valueOf(j2));
                return this;
            }

            public final a h(g gVar) {
                if (this.bZY.bZW == null) {
                    this.bZY.bZW = new ArrayList();
                }
                this.bZY.bZW.add(gVar);
                return this;
            }

            public final a af(cc ccVar) {
                if (this.bZY.bZX == null) {
                    this.bZY.bZX = new ArrayList();
                }
                this.bZY.bZX.add(ccVar);
                return this;
            }
        }

        public static a HO() {
            a aVar = new a();
            aVar.bZY = new b((byte) 0);
            return aVar;
        }
    }

    public static final class c extends c<cc> {
        @Override // com.google.a.bj
        public final /* synthetic */ Object d(h hVar, r rVar) {
            return c(hVar);
        }

        private static cc c(h hVar) {
            a HJ = cc.HJ();
            try {
                HJ.b(hVar);
                return HJ.Bp();
            } catch (af e2) {
                e2.bXr = HJ.Bp();
                throw e2;
            } catch (IOException e3) {
                af afVar = new af(e3);
                afVar.bXr = HJ.Bp();
                throw afVar;
            }
        }
    }

    public static a ac(cc ccVar) {
        return a.HN().ae(ccVar);
    }

    public static cc f(g gVar) {
        return a.HN().g(gVar).Bp();
    }

    @Override // com.google.a.aw
    public final /* synthetic */ aw.a AN() {
        return a.HN().ae(this);
    }

    @Override // com.google.a.aw
    public final /* synthetic */ aw.a AO() {
        return a.HN();
    }

    @Override // com.google.a.aw
    public final /* bridge */ /* synthetic */ bj AK() {
        return bZP;
    }

    @Override // com.google.a.ax
    public final /* bridge */ /* synthetic */ aw AP() {
        return bZM;
    }
}
