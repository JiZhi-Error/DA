package kotlin.l.b.a.b.e.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.h.a;
import kotlin.l.b.a.b.h.d;
import kotlin.l.b.a.b.h.e;
import kotlin.l.b.a.b.h.f;
import kotlin.l.b.a.b.h.g;
import kotlin.l.b.a.b.h.i;
import kotlin.l.b.a.b.h.j;
import kotlin.l.b.a.b.h.k;
import kotlin.l.b.a.b.h.q;
import kotlin.l.b.a.b.h.s;
import kotlin.l.b.a.b.h.w;
import kotlin.l.b.a.b.h.z;

public final class a {
    public static final i.f<a.p, List<a.C2299a>> TAN = i.a(a.p.hGS(), a.C2299a.hEr(), 100, z.a.MESSAGE, a.C2299a.class);
    public static final i.f<a.r, List<a.C2299a>> TAO = i.a(a.r.hHz(), a.C2299a.hEr(), 100, z.a.MESSAGE, a.C2299a.class);
    public static final i.f<a.c, b> TBL = i.a(a.c.hFs(), b.hIs(), b.hIs(), 100, z.a.MESSAGE, b.class);
    public static final i.f<a.h, b> TBM = i.a(a.h.hFZ(), b.hIs(), b.hIs(), 100, z.a.MESSAGE, b.class);
    public static final i.f<a.h, Integer> TBN = i.a(a.h.hFZ(), 0, null, 101, z.a.INT32, Integer.class);
    public static final i.f<a.m, c> TBO = i.a(a.m.hGv(), c.hIx(), c.hIx(), 100, z.a.MESSAGE, c.class);
    public static final i.f<a.m, Integer> TBP = i.a(a.m.hGv(), 0, null, 101, z.a.INT32, Integer.class);
    public static final i.f<a.p, Boolean> TBQ = i.a(a.p.hGS(), Boolean.FALSE, null, 101, z.a.BOOL, Boolean.class);
    public static final i.f<a.b, Integer> TBR = i.a(a.b.hEY(), 0, null, 101, z.a.INT32, Integer.class);
    public static final i.f<a.b, List<a.m>> TBS = i.a(a.b.hEY(), a.m.hGv(), 102, z.a.MESSAGE, a.m.class);
    public static final i.f<a.b, Integer> TBT = i.a(a.b.hEY(), 0, null, 103, z.a.INT32, Integer.class);
    public static final i.f<a.k, Integer> TBU = i.a(a.k.hGj(), 0, null, 101, z.a.INT32, Integer.class);
    public static final i.f<a.k, List<a.m>> TBV = i.a(a.k.hGj(), a.m.hGv(), 102, z.a.MESSAGE, a.m.class);

    public static void a(g gVar) {
        AppMethodBeat.i(59217);
        gVar.a(TBL);
        gVar.a(TBM);
        gVar.a(TBN);
        gVar.a(TBO);
        gVar.a(TBP);
        gVar.a(TAN);
        gVar.a(TBQ);
        gVar.a(TAO);
        gVar.a(TBR);
        gVar.a(TBS);
        gVar.a(TBT);
        gVar.a(TBU);
        gVar.a(TBV);
        AppMethodBeat.o(59217);
    }

    public static final class d extends i implements f {
        private static final d TCe;
        public static s<d> TwL = new kotlin.l.b.a.b.h.b<d>() {
            /* class kotlin.l.b.a.b.e.c.a.d.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.h.s
            public final /* synthetic */ Object a(e eVar, g gVar) {
                AppMethodBeat.i(59160);
                d dVar = new d(eVar, gVar, (byte) 0);
                AppMethodBeat.o(59160);
                return dVar;
            }
        };
        public List<b> TCf;
        public List<Integer> TCg;
        private int TCh;
        private final kotlin.l.b.a.b.h.d TwK;
        private byte bPe;
        private int bVY;

        /* synthetic */ d(e eVar, g gVar, byte b2) {
            this(eVar, gVar);
        }

        /* synthetic */ d(i.a aVar, byte b2) {
            this(aVar);
        }

        private d(i.a aVar) {
            super((byte) 0);
            this.TCh = -1;
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = aVar.TwK;
        }

        private d() {
            this.TCh = -1;
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = kotlin.l.b.a.b.h.d.TDp;
        }

        public static d hIF() {
            return TCe;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v30, resolved type: java.util.List<kotlin.l.b.a.b.e.c.a$d$b> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00a9  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00b5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private d(kotlin.l.b.a.b.h.e r11, kotlin.l.b.a.b.h.g r12) {
            /*
            // Method dump skipped, instructions count: 344
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.c.a.d.<init>(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):void");
        }

        static {
            AppMethodBeat.i(59216);
            d dVar = new d();
            TCe = dVar;
            dVar.hEu();
            AppMethodBeat.o(59216);
        }

        @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
        public final s<d> hEs() {
            return TwL;
        }

        public static final class b extends i implements e {
            private static final b TCi;
            public static s<b> TwL = new kotlin.l.b.a.b.h.b<b>() {
                /* class kotlin.l.b.a.b.e.c.a.d.b.AnonymousClass1 */

                @Override // kotlin.l.b.a.b.h.s
                public final /* synthetic */ Object a(e eVar, g gVar) {
                    AppMethodBeat.i(59178);
                    b bVar = new b(eVar, gVar, (byte) 0);
                    AppMethodBeat.o(59178);
                    return bVar;
                }
            };
            public int TCj;
            public int TCk;
            public Object TCl;
            public EnumC2336b TCm;
            public List<Integer> TCn;
            private int TCo;
            public List<Integer> TCp;
            private int TCq;
            private final kotlin.l.b.a.b.h.d TwK;
            private int bOT;
            private byte bPe;
            private int bVY;

            /* synthetic */ b(e eVar, g gVar, byte b2) {
                this(eVar, gVar);
            }

            /* synthetic */ b(i.a aVar, byte b2) {
                this(aVar);
            }

            private b(i.a aVar) {
                super((byte) 0);
                this.TCo = -1;
                this.TCq = -1;
                this.bPe = -1;
                this.bVY = -1;
                this.TwK = aVar.TwK;
            }

            private b() {
                this.TCo = -1;
                this.TCq = -1;
                this.bPe = -1;
                this.bVY = -1;
                this.TwK = kotlin.l.b.a.b.h.d.TDp;
            }

            public static b hIL() {
                return TCi;
            }

            private b(e eVar, g gVar) {
                AppMethodBeat.i(59201);
                this.TCo = -1;
                this.TCq = -1;
                this.bPe = -1;
                this.bVY = -1;
                hEu();
                boolean z = false;
                d.b hJo = kotlin.l.b.a.b.h.d.hJo();
                f f2 = f.f(hJo, 1);
                boolean z2 = false;
                while (!z2) {
                    try {
                        int yT = eVar.yT();
                        switch (yT) {
                            case 0:
                                z2 = true;
                                break;
                            case 8:
                                this.bOT |= 1;
                                this.TCj = eVar.zi();
                                break;
                            case 16:
                                this.bOT |= 2;
                                this.TCk = eVar.zi();
                                break;
                            case 24:
                                int zi = eVar.zi();
                                EnumC2336b avv = EnumC2336b.avv(zi);
                                if (avv != null) {
                                    this.bOT |= 8;
                                    this.TCm = avv;
                                    break;
                                } else {
                                    f2.hc(yT);
                                    f2.hc(zi);
                                    break;
                                }
                            case 32:
                                if (!(z & true)) {
                                    this.TCn = new ArrayList();
                                    z |= true;
                                }
                                this.TCn.add(Integer.valueOf(eVar.zi()));
                                break;
                            case 34:
                                int fH = eVar.fH(eVar.zi());
                                if (!(z & true) && eVar.zk() > 0) {
                                    this.TCn = new ArrayList();
                                    z |= true;
                                }
                                while (eVar.zk() > 0) {
                                    this.TCn.add(Integer.valueOf(eVar.zi()));
                                }
                                eVar.fI(fH);
                                break;
                            case 40:
                                if (!(z & true)) {
                                    this.TCp = new ArrayList();
                                    z |= true;
                                }
                                this.TCp.add(Integer.valueOf(eVar.zi()));
                                break;
                            case 42:
                                int fH2 = eVar.fH(eVar.zi());
                                if (!(z & true) && eVar.zk() > 0) {
                                    this.TCp = new ArrayList();
                                    z |= true;
                                }
                                while (eVar.zk() > 0) {
                                    this.TCp.add(Integer.valueOf(eVar.zi()));
                                }
                                eVar.fI(fH2);
                                break;
                            case 50:
                                kotlin.l.b.a.b.h.d hJt = eVar.hJt();
                                this.bOT |= 4;
                                this.TCl = hJt;
                                break;
                            default:
                                if (a(eVar, f2, gVar, yT)) {
                                    break;
                                } else {
                                    z2 = true;
                                    break;
                                }
                        }
                    } catch (k e2) {
                        e2.TDK = this;
                        AppMethodBeat.o(59201);
                        throw e2;
                    } catch (IOException e3) {
                        k kVar = new k(e3.getMessage());
                        kVar.TDK = this;
                        AppMethodBeat.o(59201);
                        throw kVar;
                    } catch (Throwable th) {
                        if (z & true) {
                            this.TCn = Collections.unmodifiableList(this.TCn);
                        }
                        if (z & true) {
                            this.TCp = Collections.unmodifiableList(this.TCp);
                        }
                        try {
                            f2.flush();
                            this.TwK = hJo.hJs();
                        } catch (IOException e4) {
                            this.TwK = hJo.hJs();
                        } catch (Throwable th2) {
                            this.TwK = hJo.hJs();
                            AppMethodBeat.o(59201);
                            throw th2;
                        }
                        Gw();
                        AppMethodBeat.o(59201);
                        throw th;
                    }
                }
                if (z & true) {
                    this.TCn = Collections.unmodifiableList(this.TCn);
                }
                if (z & true) {
                    this.TCp = Collections.unmodifiableList(this.TCp);
                }
                try {
                    f2.flush();
                    this.TwK = hJo.hJs();
                } catch (IOException e5) {
                    this.TwK = hJo.hJs();
                } catch (Throwable th3) {
                    this.TwK = hJo.hJs();
                    AppMethodBeat.o(59201);
                    throw th3;
                }
                Gw();
                AppMethodBeat.o(59201);
            }

            static {
                AppMethodBeat.i(59208);
                b bVar = new b();
                TCi = bVar;
                bVar.hEu();
                AppMethodBeat.o(59208);
            }

            @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
            public final s<b> hEs() {
                return TwL;
            }

            /* renamed from: kotlin.l.b.a.b.e.c.a$d$b$b  reason: collision with other inner class name */
            public enum EnumC2336b implements j.a {
                NONE(0),
                INTERNAL_TO_CLASS_ID(1),
                DESC_TO_CLASS_ID(2);
                
                private static j.b<EnumC2336b> Txp = new j.b<EnumC2336b>() {
                    /* class kotlin.l.b.a.b.e.c.a.d.b.EnumC2336b.AnonymousClass1 */

                    /* Return type fixed from 'kotlin.l.b.a.b.h.j$a' to match base method */
                    @Override // kotlin.l.b.a.b.h.j.b
                    public final /* synthetic */ EnumC2336b aua(int i2) {
                        AppMethodBeat.i(59197);
                        EnumC2336b avv = EnumC2336b.avv(i2);
                        AppMethodBeat.o(59197);
                        return avv;
                    }
                };
                final int value;

                public static EnumC2336b valueOf(String str) {
                    AppMethodBeat.i(59199);
                    EnumC2336b bVar = (EnumC2336b) Enum.valueOf(EnumC2336b.class, str);
                    AppMethodBeat.o(59199);
                    return bVar;
                }

                static {
                    AppMethodBeat.i(59200);
                    AppMethodBeat.o(59200);
                }

                @Override // kotlin.l.b.a.b.h.j.a
                public final int getNumber() {
                    return this.value;
                }

                public static EnumC2336b avv(int i2) {
                    switch (i2) {
                        case 0:
                            return NONE;
                        case 1:
                            return INTERNAL_TO_CLASS_ID;
                        case 2:
                            return DESC_TO_CLASS_ID;
                        default:
                            return null;
                    }
                }

                private EnumC2336b(int i2) {
                    this.value = i2;
                }
            }

            public final boolean hIM() {
                return (this.bOT & 1) == 1;
            }

            public final boolean hIN() {
                return (this.bOT & 2) == 2;
            }

            public final boolean hIO() {
                return (this.bOT & 4) == 4;
            }

            private kotlin.l.b.a.b.h.d hIP() {
                AppMethodBeat.i(59202);
                Object obj = this.TCl;
                if (obj instanceof String) {
                    kotlin.l.b.a.b.h.d bud = kotlin.l.b.a.b.h.d.bud((String) obj);
                    this.TCl = bud;
                    AppMethodBeat.o(59202);
                    return bud;
                }
                kotlin.l.b.a.b.h.d dVar = (kotlin.l.b.a.b.h.d) obj;
                AppMethodBeat.o(59202);
                return dVar;
            }

            public final boolean hIQ() {
                return (this.bOT & 8) == 8;
            }

            private void hEu() {
                AppMethodBeat.i(59203);
                this.TCj = 1;
                this.TCk = 0;
                this.TCl = "";
                this.TCm = EnumC2336b.NONE;
                this.TCn = Collections.emptyList();
                this.TCp = Collections.emptyList();
                AppMethodBeat.o(59203);
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                byte b2 = this.bPe;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                this.bPe = 1;
                return true;
            }

            @Override // kotlin.l.b.a.b.h.q
            public final void a(f fVar) {
                AppMethodBeat.i(59204);
                yC();
                if ((this.bOT & 1) == 1) {
                    fVar.bs(1, this.TCj);
                }
                if ((this.bOT & 2) == 2) {
                    fVar.bs(2, this.TCk);
                }
                if ((this.bOT & 8) == 8) {
                    fVar.nb(3, this.TCm.value);
                }
                if (this.TCn.size() > 0) {
                    fVar.hc(34);
                    fVar.hc(this.TCo);
                }
                for (int i2 = 0; i2 < this.TCn.size(); i2++) {
                    fVar.fK(this.TCn.get(i2).intValue());
                }
                if (this.TCp.size() > 0) {
                    fVar.hc(42);
                    fVar.hc(this.TCq);
                }
                for (int i3 = 0; i3 < this.TCp.size(); i3++) {
                    fVar.fK(this.TCp.get(i3).intValue());
                }
                if ((this.bOT & 4) == 4) {
                    fVar.a(6, hIP());
                }
                fVar.e(this.TwK);
                AppMethodBeat.o(59204);
            }

            @Override // kotlin.l.b.a.b.h.q
            public final int yC() {
                int i2;
                int i3;
                AppMethodBeat.i(59205);
                int i4 = this.bVY;
                if (i4 != -1) {
                    AppMethodBeat.o(59205);
                    return i4;
                }
                int bu = (this.bOT & 1) == 1 ? f.bu(1, this.TCj) + 0 : 0;
                if ((this.bOT & 2) == 2) {
                    bu += f.bu(2, this.TCk);
                }
                if ((this.bOT & 8) == 8) {
                    i2 = bu + f.bv(3, this.TCm.value);
                } else {
                    i2 = bu;
                }
                int i5 = 0;
                for (int i6 = 0; i6 < this.TCn.size(); i6++) {
                    i5 += f.fT(this.TCn.get(i6).intValue());
                }
                int i7 = i2 + i5;
                if (!this.TCn.isEmpty()) {
                    i3 = i7 + 1 + f.fT(i5);
                } else {
                    i3 = i7;
                }
                this.TCo = i5;
                int i8 = 0;
                int i9 = 0;
                while (i8 < this.TCp.size()) {
                    i8++;
                    i9 = f.fT(this.TCp.get(i8).intValue()) + i9;
                }
                int i10 = i3 + i9;
                if (!this.TCp.isEmpty()) {
                    i10 = i10 + 1 + f.fT(i9);
                }
                this.TCq = i9;
                if ((this.bOT & 4) == 4) {
                    i10 += f.c(hIP());
                }
                int size = i10 + this.TwK.size();
                this.bVY = size;
                AppMethodBeat.o(59205);
                return size;
            }

            /* renamed from: kotlin.l.b.a.b.e.c.a$d$b$a  reason: collision with other inner class name */
            public static final class C2335a extends i.a<b, C2335a> implements e {
                private int TCj = 1;
                private int TCk;
                private Object TCl = "";
                private EnumC2336b TCm = EnumC2336b.NONE;
                private List<Integer> TCn = Collections.emptyList();
                private List<Integer> TCp = Collections.emptyList();
                private int bOT;

                /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.l.b.a.b.h.i] */
                @Override // kotlin.l.b.a.b.h.i.a
                public final /* synthetic */ C2335a a(b bVar) {
                    AppMethodBeat.i(59188);
                    C2335a e2 = e(bVar);
                    AppMethodBeat.o(59188);
                    return e2;
                }

                @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
                public final /* synthetic */ a.AbstractC2337a c(e eVar, g gVar) {
                    AppMethodBeat.i(59190);
                    C2335a F = F(eVar, gVar);
                    AppMethodBeat.o(59190);
                    return F;
                }

                @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a, java.lang.Object
                public final /* synthetic */ Object clone() {
                    AppMethodBeat.i(59195);
                    C2335a hIR = hIR();
                    AppMethodBeat.o(59195);
                    return hIR;
                }

                @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
                public final /* synthetic */ q.a d(e eVar, g gVar) {
                    AppMethodBeat.i(59192);
                    C2335a F = F(eVar, gVar);
                    AppMethodBeat.o(59192);
                    return F;
                }

                /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
                @Override // kotlin.l.b.a.b.h.i.a
                public final /* synthetic */ C2335a hEE() {
                    AppMethodBeat.i(59189);
                    C2335a hIR = hIR();
                    AppMethodBeat.o(59189);
                    return hIR;
                }

                @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a
                public final /* synthetic */ a.AbstractC2337a hEF() {
                    AppMethodBeat.i(59191);
                    C2335a hIR = hIR();
                    AppMethodBeat.o(59191);
                    return hIR;
                }

                private C2335a() {
                    AppMethodBeat.i(59179);
                    AppMethodBeat.o(59179);
                }

                private b hIS() {
                    int i2 = 1;
                    AppMethodBeat.i(59181);
                    b bVar = new b(this, (byte) 0);
                    int i3 = this.bOT;
                    if ((i3 & 1) != 1) {
                        i2 = 0;
                    }
                    bVar.TCj = this.TCj;
                    if ((i3 & 2) == 2) {
                        i2 |= 2;
                    }
                    bVar.TCk = this.TCk;
                    if ((i3 & 4) == 4) {
                        i2 |= 4;
                    }
                    bVar.TCl = this.TCl;
                    if ((i3 & 8) == 8) {
                        i2 |= 8;
                    }
                    bVar.TCm = this.TCm;
                    if ((this.bOT & 16) == 16) {
                        this.TCn = Collections.unmodifiableList(this.TCn);
                        this.bOT &= -17;
                    }
                    bVar.TCn = this.TCn;
                    if ((this.bOT & 32) == 32) {
                        this.TCp = Collections.unmodifiableList(this.TCp);
                        this.bOT &= -33;
                    }
                    bVar.TCp = this.TCp;
                    bVar.bOT = i2;
                    AppMethodBeat.o(59181);
                    return bVar;
                }

                public final C2335a e(b bVar) {
                    AppMethodBeat.i(59182);
                    if (bVar == b.hIL()) {
                        AppMethodBeat.o(59182);
                    } else {
                        if (bVar.hIM()) {
                            avt(bVar.TCj);
                        }
                        if (bVar.hIN()) {
                            avu(bVar.TCk);
                        }
                        if (bVar.hIO()) {
                            this.bOT |= 4;
                            this.TCl = bVar.TCl;
                        }
                        if (bVar.hIQ()) {
                            a(bVar.TCm);
                        }
                        if (!bVar.TCn.isEmpty()) {
                            if (this.TCn.isEmpty()) {
                                this.TCn = bVar.TCn;
                                this.bOT &= -17;
                            } else {
                                hIT();
                                this.TCn.addAll(bVar.TCn);
                            }
                        }
                        if (!bVar.TCp.isEmpty()) {
                            if (this.TCp.isEmpty()) {
                                this.TCp = bVar.TCp;
                                this.bOT &= -33;
                            } else {
                                hIU();
                                this.TCp.addAll(bVar.TCp);
                            }
                        }
                        this.TwK = this.TwK.a(bVar.TwK);
                        AppMethodBeat.o(59182);
                    }
                    return this;
                }

                @Override // kotlin.l.b.a.b.h.r
                public final boolean isInitialized() {
                    return true;
                }

                /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                private kotlin.l.b.a.b.e.c.a.d.b.C2335a F(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                    /*
                        r4 = this;
                        r3 = 59183(0xe72f, float:8.2933E-41)
                        com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                        r2 = 0
                        kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.c.a$d$b> r0 = kotlin.l.b.a.b.e.c.a.d.b.TwL     // Catch:{ k -> 0x0016 }
                        java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                        kotlin.l.b.a.b.e.c.a$d$b r0 = (kotlin.l.b.a.b.e.c.a.d.b) r0     // Catch:{ k -> 0x0016 }
                        r4.e(r0)
                        com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                        return r4
                    L_0x0016:
                        r0 = move-exception
                        r1 = r0
                        kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                        kotlin.l.b.a.b.e.c.a$d$b r0 = (kotlin.l.b.a.b.e.c.a.d.b) r0     // Catch:{ all -> 0x002e }
                        r2 = 59183(0xe72f, float:8.2933E-41)
                        com.tencent.matrix.trace.core.AppMethodBeat.o(r2)     // Catch:{ all -> 0x0023 }
                        throw r1     // Catch:{ all -> 0x0023 }
                    L_0x0023:
                        r1 = move-exception
                        r2 = r0
                    L_0x0025:
                        if (r2 == 0) goto L_0x002a
                        r4.e(r2)
                    L_0x002a:
                        com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                        throw r1
                    L_0x002e:
                        r0 = move-exception
                        r1 = r0
                        goto L_0x0025
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.c.a.d.b.C2335a.F(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.c.a$d$b$a");
                }

                private C2335a avt(int i2) {
                    this.bOT |= 1;
                    this.TCj = i2;
                    return this;
                }

                private C2335a avu(int i2) {
                    this.bOT |= 2;
                    this.TCk = i2;
                    return this;
                }

                private C2335a a(EnumC2336b bVar) {
                    AppMethodBeat.i(59184);
                    if (bVar == null) {
                        NullPointerException nullPointerException = new NullPointerException();
                        AppMethodBeat.o(59184);
                        throw nullPointerException;
                    }
                    this.bOT |= 8;
                    this.TCm = bVar;
                    AppMethodBeat.o(59184);
                    return this;
                }

                private void hIT() {
                    AppMethodBeat.i(59185);
                    if ((this.bOT & 16) != 16) {
                        this.TCn = new ArrayList(this.TCn);
                        this.bOT |= 16;
                    }
                    AppMethodBeat.o(59185);
                }

                private void hIU() {
                    AppMethodBeat.i(59186);
                    if ((this.bOT & 32) != 32) {
                        this.TCp = new ArrayList(this.TCp);
                        this.bOT |= 32;
                    }
                    AppMethodBeat.o(59186);
                }

                private C2335a hIR() {
                    AppMethodBeat.i(59180);
                    C2335a e2 = new C2335a().e(hIS());
                    AppMethodBeat.o(59180);
                    return e2;
                }

                /* Return type fixed from 'kotlin.l.b.a.b.h.i' to match base method */
                @Override // kotlin.l.b.a.b.h.i.a
                public final /* synthetic */ b hED() {
                    AppMethodBeat.i(59187);
                    b hIL = b.hIL();
                    AppMethodBeat.o(59187);
                    return hIL;
                }

                @Override // kotlin.l.b.a.b.h.q.a
                public final /* synthetic */ q hEG() {
                    AppMethodBeat.i(59193);
                    b hIS = hIS();
                    if (!hIS.isInitialized()) {
                        w wVar = new w();
                        AppMethodBeat.o(59193);
                        throw wVar;
                    }
                    AppMethodBeat.o(59193);
                    return hIS;
                }

                @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
                public final /* synthetic */ q hEy() {
                    AppMethodBeat.i(59194);
                    b hIL = b.hIL();
                    AppMethodBeat.o(59194);
                    return hIL;
                }

                static /* synthetic */ C2335a hIV() {
                    AppMethodBeat.i(59196);
                    C2335a aVar = new C2335a();
                    AppMethodBeat.o(59196);
                    return aVar;
                }
            }

            @Override // kotlin.l.b.a.b.h.q
            public final /* synthetic */ q.a hEw() {
                AppMethodBeat.i(59206);
                C2335a e2 = C2335a.hIV().e(this);
                AppMethodBeat.o(59206);
                return e2;
            }

            @Override // kotlin.l.b.a.b.h.q
            public final /* synthetic */ q.a hEx() {
                AppMethodBeat.i(59207);
                C2335a hIV = C2335a.hIV();
                AppMethodBeat.o(59207);
                return hIV;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final /* bridge */ /* synthetic */ q hEy() {
                return TCi;
            }
        }

        private void hEu() {
            AppMethodBeat.i(59210);
            this.TCf = Collections.emptyList();
            this.TCg = Collections.emptyList();
            AppMethodBeat.o(59210);
        }

        @Override // kotlin.l.b.a.b.h.r
        public final boolean isInitialized() {
            byte b2 = this.bPe;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.bPe = 1;
            return true;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final void a(f fVar) {
            AppMethodBeat.i(59211);
            yC();
            for (int i2 = 0; i2 < this.TCf.size(); i2++) {
                fVar.a(1, this.TCf.get(i2));
            }
            if (this.TCg.size() > 0) {
                fVar.hc(42);
                fVar.hc(this.TCh);
            }
            for (int i3 = 0; i3 < this.TCg.size(); i3++) {
                fVar.fK(this.TCg.get(i3).intValue());
            }
            fVar.e(this.TwK);
            AppMethodBeat.o(59211);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final int yC() {
            AppMethodBeat.i(59212);
            int i2 = this.bVY;
            if (i2 != -1) {
                AppMethodBeat.o(59212);
                return i2;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.TCf.size(); i4++) {
                i3 += f.c(1, this.TCf.get(i4));
            }
            int i5 = 0;
            int i6 = 0;
            while (i5 < this.TCg.size()) {
                i5++;
                i6 = f.fT(this.TCg.get(i5).intValue()) + i6;
            }
            int i7 = i3 + i6;
            if (!this.TCg.isEmpty()) {
                i7 = i7 + 1 + f.fT(i6);
            }
            this.TCh = i6;
            int size = i7 + this.TwK.size();
            this.bVY = size;
            AppMethodBeat.o(59212);
            return size;
        }

        public static d f(InputStream inputStream, g gVar) {
            AppMethodBeat.i(59213);
            d i2 = TwL.i(inputStream, gVar);
            AppMethodBeat.o(59213);
            return i2;
        }

        /* renamed from: kotlin.l.b.a.b.e.c.a$d$a  reason: collision with other inner class name */
        public static final class C2334a extends i.a<d, C2334a> implements f {
            private List<b> TCf = Collections.emptyList();
            private List<Integer> TCg = Collections.emptyList();
            private int bOT;

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.l.b.a.b.h.i] */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2334a a(d dVar) {
                AppMethodBeat.i(59169);
                C2334a d2 = d(dVar);
                AppMethodBeat.o(59169);
                return d2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
            public final /* synthetic */ a.AbstractC2337a c(e eVar, g gVar) {
                AppMethodBeat.i(59171);
                C2334a E = E(eVar, gVar);
                AppMethodBeat.o(59171);
                return E;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a, java.lang.Object
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(59176);
                C2334a hIG = hIG();
                AppMethodBeat.o(59176);
                return hIG;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q.a d(e eVar, g gVar) {
                AppMethodBeat.i(59173);
                C2334a E = E(eVar, gVar);
                AppMethodBeat.o(59173);
                return E;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2334a hEE() {
                AppMethodBeat.i(59170);
                C2334a hIG = hIG();
                AppMethodBeat.o(59170);
                return hIG;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ a.AbstractC2337a hEF() {
                AppMethodBeat.i(59172);
                C2334a hIG = hIG();
                AppMethodBeat.o(59172);
                return hIG;
            }

            private C2334a() {
                AppMethodBeat.i(59161);
                AppMethodBeat.o(59161);
            }

            private d hIH() {
                AppMethodBeat.i(59163);
                d dVar = new d(this, (byte) 0);
                if ((this.bOT & 1) == 1) {
                    this.TCf = Collections.unmodifiableList(this.TCf);
                    this.bOT &= -2;
                }
                dVar.TCf = this.TCf;
                if ((this.bOT & 2) == 2) {
                    this.TCg = Collections.unmodifiableList(this.TCg);
                    this.bOT &= -3;
                }
                dVar.TCg = this.TCg;
                AppMethodBeat.o(59163);
                return dVar;
            }

            public final C2334a d(d dVar) {
                AppMethodBeat.i(59164);
                if (dVar == d.hIF()) {
                    AppMethodBeat.o(59164);
                } else {
                    if (!dVar.TCf.isEmpty()) {
                        if (this.TCf.isEmpty()) {
                            this.TCf = dVar.TCf;
                            this.bOT &= -2;
                        } else {
                            hII();
                            this.TCf.addAll(dVar.TCf);
                        }
                    }
                    if (!dVar.TCg.isEmpty()) {
                        if (this.TCg.isEmpty()) {
                            this.TCg = dVar.TCg;
                            this.bOT &= -3;
                        } else {
                            hIJ();
                            this.TCg.addAll(dVar.TCg);
                        }
                    }
                    this.TwK = this.TwK.a(dVar.TwK);
                    AppMethodBeat.o(59164);
                }
                return this;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private kotlin.l.b.a.b.e.c.a.d.C2334a E(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                /*
                    r4 = this;
                    r3 = 59165(0xe71d, float:8.2908E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    r2 = 0
                    kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.c.a$d> r0 = kotlin.l.b.a.b.e.c.a.d.TwL     // Catch:{ k -> 0x0016 }
                    java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                    kotlin.l.b.a.b.e.c.a$d r0 = (kotlin.l.b.a.b.e.c.a.d) r0     // Catch:{ k -> 0x0016 }
                    r4.d(r0)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return r4
                L_0x0016:
                    r0 = move-exception
                    r1 = r0
                    kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                    kotlin.l.b.a.b.e.c.a$d r0 = (kotlin.l.b.a.b.e.c.a.d) r0     // Catch:{ all -> 0x002e }
                    r2 = 59165(0xe71d, float:8.2908E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)     // Catch:{ all -> 0x0023 }
                    throw r1     // Catch:{ all -> 0x0023 }
                L_0x0023:
                    r1 = move-exception
                    r2 = r0
                L_0x0025:
                    if (r2 == 0) goto L_0x002a
                    r4.d(r2)
                L_0x002a:
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    throw r1
                L_0x002e:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x0025
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.c.a.d.C2334a.E(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.c.a$d$a");
            }

            private void hII() {
                AppMethodBeat.i(59166);
                if ((this.bOT & 1) != 1) {
                    this.TCf = new ArrayList(this.TCf);
                    this.bOT |= 1;
                }
                AppMethodBeat.o(59166);
            }

            private void hIJ() {
                AppMethodBeat.i(59167);
                if ((this.bOT & 2) != 2) {
                    this.TCg = new ArrayList(this.TCg);
                    this.bOT |= 2;
                }
                AppMethodBeat.o(59167);
            }

            private C2334a hIG() {
                AppMethodBeat.i(59162);
                C2334a d2 = new C2334a().d(hIH());
                AppMethodBeat.o(59162);
                return d2;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ d hED() {
                AppMethodBeat.i(59168);
                d hIF = d.hIF();
                AppMethodBeat.o(59168);
                return hIF;
            }

            @Override // kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q hEG() {
                AppMethodBeat.i(59174);
                d hIH = hIH();
                if (!hIH.isInitialized()) {
                    w wVar = new w();
                    AppMethodBeat.o(59174);
                    throw wVar;
                }
                AppMethodBeat.o(59174);
                return hIH;
            }

            @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
            public final /* synthetic */ q hEy() {
                AppMethodBeat.i(59175);
                d hIF = d.hIF();
                AppMethodBeat.o(59175);
                return hIF;
            }

            static /* synthetic */ C2334a hIK() {
                AppMethodBeat.i(59177);
                C2334a aVar = new C2334a();
                AppMethodBeat.o(59177);
                return aVar;
            }
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEw() {
            AppMethodBeat.i(59214);
            C2334a d2 = C2334a.hIK().d(this);
            AppMethodBeat.o(59214);
            return d2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEx() {
            AppMethodBeat.i(59215);
            C2334a hIK = C2334a.hIK();
            AppMethodBeat.o(59215);
            return hIK;
        }

        @Override // kotlin.l.b.a.b.h.r
        public final /* bridge */ /* synthetic */ q hEy() {
            return TCe;
        }
    }

    public static final class b extends i implements c {
        private static final b TBY;
        public static s<b> TwL = new kotlin.l.b.a.b.h.b<b>() {
            /* class kotlin.l.b.a.b.e.c.a.b.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.h.s
            public final /* synthetic */ Object a(e eVar, g gVar) {
                AppMethodBeat.i(59110);
                b bVar = new b(eVar, gVar, (byte) 0);
                AppMethodBeat.o(59110);
                return bVar;
            }
        };
        public int TBX;
        private final kotlin.l.b.a.b.h.d TwK;
        public int Tyk;
        private int bOT;
        private byte bPe;
        private int bVY;

        /* synthetic */ b(e eVar, g gVar, byte b2) {
            this(eVar, gVar);
        }

        /* synthetic */ b(i.a aVar, byte b2) {
            this(aVar);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEw() {
            AppMethodBeat.i(59130);
            C2332a hIt = hIt();
            AppMethodBeat.o(59130);
            return hIt;
        }

        private b(i.a aVar) {
            super((byte) 0);
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = aVar.TwK;
        }

        private b() {
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = kotlin.l.b.a.b.h.d.TDp;
        }

        public static b hIs() {
            return TBY;
        }

        private b(e eVar, g gVar) {
            AppMethodBeat.i(59125);
            this.bPe = -1;
            this.bVY = -1;
            hEu();
            d.b hJo = kotlin.l.b.a.b.h.d.hJo();
            f f2 = f.f(hJo, 1);
            boolean z = false;
            while (!z) {
                try {
                    int yT = eVar.yT();
                    switch (yT) {
                        case 0:
                            z = true;
                            break;
                        case 8:
                            this.bOT |= 1;
                            this.Tyk = eVar.zi();
                            break;
                        case 16:
                            this.bOT |= 2;
                            this.TBX = eVar.zi();
                            break;
                        default:
                            if (a(eVar, f2, gVar, yT)) {
                                break;
                            } else {
                                z = true;
                                break;
                            }
                    }
                } catch (k e2) {
                    e2.TDK = this;
                    AppMethodBeat.o(59125);
                    throw e2;
                } catch (IOException e3) {
                    k kVar = new k(e3.getMessage());
                    kVar.TDK = this;
                    AppMethodBeat.o(59125);
                    throw kVar;
                } catch (Throwable th) {
                    try {
                        f2.flush();
                        this.TwK = hJo.hJs();
                    } catch (IOException e4) {
                        this.TwK = hJo.hJs();
                    } catch (Throwable th2) {
                        this.TwK = hJo.hJs();
                        AppMethodBeat.o(59125);
                        throw th2;
                    }
                    Gw();
                    AppMethodBeat.o(59125);
                    throw th;
                }
            }
            try {
                f2.flush();
                this.TwK = hJo.hJs();
            } catch (IOException e5) {
                this.TwK = hJo.hJs();
            } catch (Throwable th3) {
                this.TwK = hJo.hJs();
                AppMethodBeat.o(59125);
                throw th3;
            }
            Gw();
            AppMethodBeat.o(59125);
        }

        static {
            AppMethodBeat.i(59132);
            b bVar = new b();
            TBY = bVar;
            bVar.hEu();
            AppMethodBeat.o(59132);
        }

        @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
        public final s<b> hEs() {
            return TwL;
        }

        public final boolean Az() {
            return (this.bOT & 1) == 1;
        }

        public final boolean hIn() {
            return (this.bOT & 2) == 2;
        }

        private void hEu() {
            this.Tyk = 0;
            this.TBX = 0;
        }

        @Override // kotlin.l.b.a.b.h.r
        public final boolean isInitialized() {
            byte b2 = this.bPe;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.bPe = 1;
            return true;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final void a(f fVar) {
            AppMethodBeat.i(59126);
            yC();
            if ((this.bOT & 1) == 1) {
                fVar.bs(1, this.Tyk);
            }
            if ((this.bOT & 2) == 2) {
                fVar.bs(2, this.TBX);
            }
            fVar.e(this.TwK);
            AppMethodBeat.o(59126);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final int yC() {
            AppMethodBeat.i(59127);
            int i2 = this.bVY;
            if (i2 != -1) {
                AppMethodBeat.o(59127);
                return i2;
            }
            int i3 = 0;
            if ((this.bOT & 1) == 1) {
                i3 = f.bu(1, this.Tyk) + 0;
            }
            if ((this.bOT & 2) == 2) {
                i3 += f.bu(2, this.TBX);
            }
            int size = i3 + this.TwK.size();
            this.bVY = size;
            AppMethodBeat.o(59127);
            return size;
        }

        /* renamed from: kotlin.l.b.a.b.e.c.a$b$a  reason: collision with other inner class name */
        public static final class C2332a extends i.a<b, C2332a> implements c {
            private int TBX;
            private int Tyk;
            private int bOT;

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.l.b.a.b.h.i] */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2332a a(b bVar) {
                AppMethodBeat.i(59116);
                C2332a c2 = c(bVar);
                AppMethodBeat.o(59116);
                return c2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
            public final /* synthetic */ a.AbstractC2337a c(e eVar, g gVar) {
                AppMethodBeat.i(59118);
                C2332a C = C(eVar, gVar);
                AppMethodBeat.o(59118);
                return C;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a, java.lang.Object
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(59123);
                C2332a hIu = hIu();
                AppMethodBeat.o(59123);
                return hIu;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q.a d(e eVar, g gVar) {
                AppMethodBeat.i(59120);
                C2332a C = C(eVar, gVar);
                AppMethodBeat.o(59120);
                return C;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2332a hEE() {
                AppMethodBeat.i(59117);
                C2332a hIu = hIu();
                AppMethodBeat.o(59117);
                return hIu;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ a.AbstractC2337a hEF() {
                AppMethodBeat.i(59119);
                C2332a hIu = hIu();
                AppMethodBeat.o(59119);
                return hIu;
            }

            private C2332a() {
            }

            public final b hIv() {
                int i2 = 1;
                AppMethodBeat.i(59112);
                b bVar = new b(this, (byte) 0);
                int i3 = this.bOT;
                if ((i3 & 1) != 1) {
                    i2 = 0;
                }
                bVar.Tyk = this.Tyk;
                if ((i3 & 2) == 2) {
                    i2 |= 2;
                }
                bVar.TBX = this.TBX;
                bVar.bOT = i2;
                AppMethodBeat.o(59112);
                return bVar;
            }

            public final C2332a c(b bVar) {
                AppMethodBeat.i(59113);
                if (bVar == b.hIs()) {
                    AppMethodBeat.o(59113);
                } else {
                    if (bVar.Az()) {
                        avr(bVar.Tyk);
                    }
                    if (bVar.hIn()) {
                        avs(bVar.TBX);
                    }
                    this.TwK = this.TwK.a(bVar.TwK);
                    AppMethodBeat.o(59113);
                }
                return this;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private kotlin.l.b.a.b.e.c.a.b.C2332a C(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                /*
                    r4 = this;
                    r3 = 59114(0xe6ea, float:8.2836E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    r2 = 0
                    kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.c.a$b> r0 = kotlin.l.b.a.b.e.c.a.b.TwL     // Catch:{ k -> 0x0016 }
                    java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                    kotlin.l.b.a.b.e.c.a$b r0 = (kotlin.l.b.a.b.e.c.a.b) r0     // Catch:{ k -> 0x0016 }
                    r4.c(r0)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return r4
                L_0x0016:
                    r0 = move-exception
                    r1 = r0
                    kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                    kotlin.l.b.a.b.e.c.a$b r0 = (kotlin.l.b.a.b.e.c.a.b) r0     // Catch:{ all -> 0x002e }
                    r2 = 59114(0xe6ea, float:8.2836E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)     // Catch:{ all -> 0x0023 }
                    throw r1     // Catch:{ all -> 0x0023 }
                L_0x0023:
                    r1 = move-exception
                    r2 = r0
                L_0x0025:
                    if (r2 == 0) goto L_0x002a
                    r4.c(r2)
                L_0x002a:
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    throw r1
                L_0x002e:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x0025
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.c.a.b.C2332a.C(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.c.a$b$a");
            }

            private C2332a avr(int i2) {
                this.bOT |= 1;
                this.Tyk = i2;
                return this;
            }

            private C2332a avs(int i2) {
                this.bOT |= 2;
                this.TBX = i2;
                return this;
            }

            private C2332a hIu() {
                AppMethodBeat.i(59111);
                C2332a c2 = new C2332a().c(hIv());
                AppMethodBeat.o(59111);
                return c2;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ b hED() {
                AppMethodBeat.i(59115);
                b hIs = b.hIs();
                AppMethodBeat.o(59115);
                return hIs;
            }

            @Override // kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q hEG() {
                AppMethodBeat.i(59121);
                b hIv = hIv();
                if (!hIv.isInitialized()) {
                    w wVar = new w();
                    AppMethodBeat.o(59121);
                    throw wVar;
                }
                AppMethodBeat.o(59121);
                return hIv;
            }

            @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
            public final /* synthetic */ q hEy() {
                AppMethodBeat.i(59122);
                b hIs = b.hIs();
                AppMethodBeat.o(59122);
                return hIs;
            }

            static /* synthetic */ C2332a hIw() {
                AppMethodBeat.i(59124);
                C2332a aVar = new C2332a();
                AppMethodBeat.o(59124);
                return aVar;
            }
        }

        public static C2332a a(b bVar) {
            AppMethodBeat.i(59128);
            C2332a c2 = C2332a.hIw().c(bVar);
            AppMethodBeat.o(59128);
            return c2;
        }

        public final C2332a hIt() {
            AppMethodBeat.i(59129);
            C2332a c2 = C2332a.hIw().c(this);
            AppMethodBeat.o(59129);
            return c2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEx() {
            AppMethodBeat.i(59131);
            C2332a hIw = C2332a.hIw();
            AppMethodBeat.o(59131);
            return hIw;
        }

        @Override // kotlin.l.b.a.b.h.r
        public final /* bridge */ /* synthetic */ q hEy() {
            return TBY;
        }
    }

    /* renamed from: kotlin.l.b.a.b.e.c.a$a  reason: collision with other inner class name */
    public static final class C2330a extends i implements b {
        private static final C2330a TBW;
        public static s<C2330a> TwL = new kotlin.l.b.a.b.h.b<C2330a>() {
            /* class kotlin.l.b.a.b.e.c.a.C2330a.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.h.s
            public final /* synthetic */ Object a(e eVar, g gVar) {
                AppMethodBeat.i(59087);
                C2330a aVar = new C2330a(eVar, gVar, (byte) 0);
                AppMethodBeat.o(59087);
                return aVar;
            }
        };
        public int TBX;
        private final kotlin.l.b.a.b.h.d TwK;
        public int Tyk;
        private int bOT;
        private byte bPe;
        private int bVY;

        /* synthetic */ C2330a(e eVar, g gVar, byte b2) {
            this(eVar, gVar);
        }

        /* synthetic */ C2330a(i.a aVar, byte b2) {
            this(aVar);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEw() {
            AppMethodBeat.i(59107);
            C2331a hIo = hIo();
            AppMethodBeat.o(59107);
            return hIo;
        }

        private C2330a(i.a aVar) {
            super((byte) 0);
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = aVar.TwK;
        }

        private C2330a() {
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = kotlin.l.b.a.b.h.d.TDp;
        }

        public static C2330a hIm() {
            return TBW;
        }

        private C2330a(e eVar, g gVar) {
            AppMethodBeat.i(59102);
            this.bPe = -1;
            this.bVY = -1;
            hEu();
            d.b hJo = kotlin.l.b.a.b.h.d.hJo();
            f f2 = f.f(hJo, 1);
            boolean z = false;
            while (!z) {
                try {
                    int yT = eVar.yT();
                    switch (yT) {
                        case 0:
                            z = true;
                            break;
                        case 8:
                            this.bOT |= 1;
                            this.Tyk = eVar.zi();
                            break;
                        case 16:
                            this.bOT |= 2;
                            this.TBX = eVar.zi();
                            break;
                        default:
                            if (a(eVar, f2, gVar, yT)) {
                                break;
                            } else {
                                z = true;
                                break;
                            }
                    }
                } catch (k e2) {
                    e2.TDK = this;
                    AppMethodBeat.o(59102);
                    throw e2;
                } catch (IOException e3) {
                    k kVar = new k(e3.getMessage());
                    kVar.TDK = this;
                    AppMethodBeat.o(59102);
                    throw kVar;
                } catch (Throwable th) {
                    try {
                        f2.flush();
                        this.TwK = hJo.hJs();
                    } catch (IOException e4) {
                        this.TwK = hJo.hJs();
                    } catch (Throwable th2) {
                        this.TwK = hJo.hJs();
                        AppMethodBeat.o(59102);
                        throw th2;
                    }
                    Gw();
                    AppMethodBeat.o(59102);
                    throw th;
                }
            }
            try {
                f2.flush();
                this.TwK = hJo.hJs();
            } catch (IOException e5) {
                this.TwK = hJo.hJs();
            } catch (Throwable th3) {
                this.TwK = hJo.hJs();
                AppMethodBeat.o(59102);
                throw th3;
            }
            Gw();
            AppMethodBeat.o(59102);
        }

        static {
            AppMethodBeat.i(59109);
            C2330a aVar = new C2330a();
            TBW = aVar;
            aVar.hEu();
            AppMethodBeat.o(59109);
        }

        @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
        public final s<C2330a> hEs() {
            return TwL;
        }

        public final boolean Az() {
            return (this.bOT & 1) == 1;
        }

        public final boolean hIn() {
            return (this.bOT & 2) == 2;
        }

        private void hEu() {
            this.Tyk = 0;
            this.TBX = 0;
        }

        @Override // kotlin.l.b.a.b.h.r
        public final boolean isInitialized() {
            byte b2 = this.bPe;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.bPe = 1;
            return true;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final void a(f fVar) {
            AppMethodBeat.i(59103);
            yC();
            if ((this.bOT & 1) == 1) {
                fVar.bs(1, this.Tyk);
            }
            if ((this.bOT & 2) == 2) {
                fVar.bs(2, this.TBX);
            }
            fVar.e(this.TwK);
            AppMethodBeat.o(59103);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final int yC() {
            AppMethodBeat.i(59104);
            int i2 = this.bVY;
            if (i2 != -1) {
                AppMethodBeat.o(59104);
                return i2;
            }
            int i3 = 0;
            if ((this.bOT & 1) == 1) {
                i3 = f.bu(1, this.Tyk) + 0;
            }
            if ((this.bOT & 2) == 2) {
                i3 += f.bu(2, this.TBX);
            }
            int size = i3 + this.TwK.size();
            this.bVY = size;
            AppMethodBeat.o(59104);
            return size;
        }

        /* renamed from: kotlin.l.b.a.b.e.c.a$a$a  reason: collision with other inner class name */
        public static final class C2331a extends i.a<C2330a, C2331a> implements b {
            private int TBX;
            private int Tyk;
            private int bOT;

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.l.b.a.b.h.i] */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2331a a(C2330a aVar) {
                AppMethodBeat.i(59093);
                C2331a c2 = c(aVar);
                AppMethodBeat.o(59093);
                return c2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
            public final /* synthetic */ a.AbstractC2337a c(e eVar, g gVar) {
                AppMethodBeat.i(59095);
                C2331a B = B(eVar, gVar);
                AppMethodBeat.o(59095);
                return B;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a, java.lang.Object
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(59100);
                C2331a hIp = hIp();
                AppMethodBeat.o(59100);
                return hIp;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q.a d(e eVar, g gVar) {
                AppMethodBeat.i(59097);
                C2331a B = B(eVar, gVar);
                AppMethodBeat.o(59097);
                return B;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2331a hEE() {
                AppMethodBeat.i(59094);
                C2331a hIp = hIp();
                AppMethodBeat.o(59094);
                return hIp;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ a.AbstractC2337a hEF() {
                AppMethodBeat.i(59096);
                C2331a hIp = hIp();
                AppMethodBeat.o(59096);
                return hIp;
            }

            private C2331a() {
            }

            public final C2330a hIq() {
                int i2 = 1;
                AppMethodBeat.i(59089);
                C2330a aVar = new C2330a(this, (byte) 0);
                int i3 = this.bOT;
                if ((i3 & 1) != 1) {
                    i2 = 0;
                }
                aVar.Tyk = this.Tyk;
                if ((i3 & 2) == 2) {
                    i2 |= 2;
                }
                aVar.TBX = this.TBX;
                aVar.bOT = i2;
                AppMethodBeat.o(59089);
                return aVar;
            }

            public final C2331a c(C2330a aVar) {
                AppMethodBeat.i(59090);
                if (aVar == C2330a.hIm()) {
                    AppMethodBeat.o(59090);
                } else {
                    if (aVar.Az()) {
                        avp(aVar.Tyk);
                    }
                    if (aVar.hIn()) {
                        avq(aVar.TBX);
                    }
                    this.TwK = this.TwK.a(aVar.TwK);
                    AppMethodBeat.o(59090);
                }
                return this;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private kotlin.l.b.a.b.e.c.a.C2330a.C2331a B(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                /*
                    r4 = this;
                    r3 = 59091(0xe6d3, float:8.2804E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    r2 = 0
                    kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.c.a$a> r0 = kotlin.l.b.a.b.e.c.a.C2330a.TwL     // Catch:{ k -> 0x0016 }
                    java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                    kotlin.l.b.a.b.e.c.a$a r0 = (kotlin.l.b.a.b.e.c.a.C2330a) r0     // Catch:{ k -> 0x0016 }
                    r4.c(r0)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return r4
                L_0x0016:
                    r0 = move-exception
                    r1 = r0
                    kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                    kotlin.l.b.a.b.e.c.a$a r0 = (kotlin.l.b.a.b.e.c.a.C2330a) r0     // Catch:{ all -> 0x002e }
                    r2 = 59091(0xe6d3, float:8.2804E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)     // Catch:{ all -> 0x0023 }
                    throw r1     // Catch:{ all -> 0x0023 }
                L_0x0023:
                    r1 = move-exception
                    r2 = r0
                L_0x0025:
                    if (r2 == 0) goto L_0x002a
                    r4.c(r2)
                L_0x002a:
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    throw r1
                L_0x002e:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x0025
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.c.a.C2330a.C2331a.B(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.c.a$a$a");
            }

            private C2331a avp(int i2) {
                this.bOT |= 1;
                this.Tyk = i2;
                return this;
            }

            private C2331a avq(int i2) {
                this.bOT |= 2;
                this.TBX = i2;
                return this;
            }

            private C2331a hIp() {
                AppMethodBeat.i(59088);
                C2331a c2 = new C2331a().c(hIq());
                AppMethodBeat.o(59088);
                return c2;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2330a hED() {
                AppMethodBeat.i(59092);
                C2330a hIm = C2330a.hIm();
                AppMethodBeat.o(59092);
                return hIm;
            }

            @Override // kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q hEG() {
                AppMethodBeat.i(59098);
                C2330a hIq = hIq();
                if (!hIq.isInitialized()) {
                    w wVar = new w();
                    AppMethodBeat.o(59098);
                    throw wVar;
                }
                AppMethodBeat.o(59098);
                return hIq;
            }

            @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
            public final /* synthetic */ q hEy() {
                AppMethodBeat.i(59099);
                C2330a hIm = C2330a.hIm();
                AppMethodBeat.o(59099);
                return hIm;
            }

            static /* synthetic */ C2331a hIr() {
                AppMethodBeat.i(59101);
                C2331a aVar = new C2331a();
                AppMethodBeat.o(59101);
                return aVar;
            }
        }

        public static C2331a a(C2330a aVar) {
            AppMethodBeat.i(59105);
            C2331a c2 = C2331a.hIr().c(aVar);
            AppMethodBeat.o(59105);
            return c2;
        }

        public final C2331a hIo() {
            AppMethodBeat.i(59106);
            C2331a c2 = C2331a.hIr().c(this);
            AppMethodBeat.o(59106);
            return c2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEx() {
            AppMethodBeat.i(59108);
            C2331a hIr = C2331a.hIr();
            AppMethodBeat.o(59108);
            return hIr;
        }

        @Override // kotlin.l.b.a.b.h.r
        public final /* bridge */ /* synthetic */ q hEy() {
            return TBW;
        }
    }

    public static final class c extends i implements d {
        private static final c TBZ;
        public static s<c> TwL = new kotlin.l.b.a.b.h.b<c>() {
            /* class kotlin.l.b.a.b.e.c.a.c.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.h.s
            public final /* synthetic */ Object a(e eVar, g gVar) {
                AppMethodBeat.i(59133);
                c cVar = new c(eVar, gVar, (byte) 0);
                AppMethodBeat.o(59133);
                return cVar;
            }
        };
        public C2330a TCa;
        public b TCb;
        public b TCc;
        public b TCd;
        private final kotlin.l.b.a.b.h.d TwK;
        private int bOT;
        private byte bPe;
        private int bVY;

        /* synthetic */ c(e eVar, g gVar, byte b2) {
            this(eVar, gVar);
        }

        /* synthetic */ c(i.a aVar, byte b2) {
            this(aVar);
        }

        private c(i.a aVar) {
            super((byte) 0);
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = aVar.TwK;
        }

        private c() {
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = kotlin.l.b.a.b.h.d.TDp;
        }

        public static c hIx() {
            return TBZ;
        }

        private c(e eVar, g gVar) {
            b.C2332a aVar;
            b.C2332a aVar2;
            b.C2332a aVar3;
            C2330a.C2331a aVar4;
            AppMethodBeat.i(59153);
            this.bPe = -1;
            this.bVY = -1;
            hEu();
            d.b hJo = kotlin.l.b.a.b.h.d.hJo();
            f f2 = f.f(hJo, 1);
            boolean z = false;
            while (!z) {
                try {
                    int yT = eVar.yT();
                    switch (yT) {
                        case 0:
                            z = true;
                            break;
                        case 10:
                            if ((this.bOT & 1) == 1) {
                                aVar4 = this.TCa.hIo();
                            } else {
                                aVar4 = null;
                            }
                            this.TCa = (C2330a) eVar.a(C2330a.TwL, gVar);
                            if (aVar4 != null) {
                                aVar4.c(this.TCa);
                                this.TCa = aVar4.hIq();
                            }
                            this.bOT |= 1;
                            break;
                        case 18:
                            if ((this.bOT & 2) == 2) {
                                aVar3 = this.TCb.hIt();
                            } else {
                                aVar3 = null;
                            }
                            this.TCb = (b) eVar.a(b.TwL, gVar);
                            if (aVar3 != null) {
                                aVar3.c(this.TCb);
                                this.TCb = aVar3.hIv();
                            }
                            this.bOT |= 2;
                            break;
                        case 26:
                            if ((this.bOT & 4) == 4) {
                                aVar2 = this.TCc.hIt();
                            } else {
                                aVar2 = null;
                            }
                            this.TCc = (b) eVar.a(b.TwL, gVar);
                            if (aVar2 != null) {
                                aVar2.c(this.TCc);
                                this.TCc = aVar2.hIv();
                            }
                            this.bOT |= 4;
                            break;
                        case 34:
                            if ((this.bOT & 8) == 8) {
                                aVar = this.TCd.hIt();
                            } else {
                                aVar = null;
                            }
                            this.TCd = (b) eVar.a(b.TwL, gVar);
                            if (aVar != null) {
                                aVar.c(this.TCd);
                                this.TCd = aVar.hIv();
                            }
                            this.bOT |= 8;
                            break;
                        default:
                            if (a(eVar, f2, gVar, yT)) {
                                break;
                            } else {
                                z = true;
                                break;
                            }
                    }
                } catch (k e2) {
                    e2.TDK = this;
                    AppMethodBeat.o(59153);
                    throw e2;
                } catch (IOException e3) {
                    k kVar = new k(e3.getMessage());
                    kVar.TDK = this;
                    AppMethodBeat.o(59153);
                    throw kVar;
                } catch (Throwable th) {
                    try {
                        f2.flush();
                        this.TwK = hJo.hJs();
                    } catch (IOException e4) {
                        this.TwK = hJo.hJs();
                    } catch (Throwable th2) {
                        this.TwK = hJo.hJs();
                        AppMethodBeat.o(59153);
                        throw th2;
                    }
                    Gw();
                    AppMethodBeat.o(59153);
                    throw th;
                }
            }
            try {
                f2.flush();
                this.TwK = hJo.hJs();
            } catch (IOException e5) {
                this.TwK = hJo.hJs();
            } catch (Throwable th3) {
                this.TwK = hJo.hJs();
                AppMethodBeat.o(59153);
                throw th3;
            }
            Gw();
            AppMethodBeat.o(59153);
        }

        static {
            AppMethodBeat.i(59159);
            c cVar = new c();
            TBZ = cVar;
            cVar.hEu();
            AppMethodBeat.o(59159);
        }

        @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
        public final s<c> hEs() {
            return TwL;
        }

        public final boolean hIy() {
            return (this.bOT & 1) == 1;
        }

        public final boolean hIz() {
            return (this.bOT & 2) == 2;
        }

        public final boolean hIA() {
            return (this.bOT & 4) == 4;
        }

        public final boolean hIB() {
            return (this.bOT & 8) == 8;
        }

        private void hEu() {
            AppMethodBeat.i(59154);
            this.TCa = C2330a.hIm();
            this.TCb = b.hIs();
            this.TCc = b.hIs();
            this.TCd = b.hIs();
            AppMethodBeat.o(59154);
        }

        @Override // kotlin.l.b.a.b.h.r
        public final boolean isInitialized() {
            byte b2 = this.bPe;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.bPe = 1;
            return true;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final void a(f fVar) {
            AppMethodBeat.i(59155);
            yC();
            if ((this.bOT & 1) == 1) {
                fVar.a(1, this.TCa);
            }
            if ((this.bOT & 2) == 2) {
                fVar.a(2, this.TCb);
            }
            if ((this.bOT & 4) == 4) {
                fVar.a(3, this.TCc);
            }
            if ((this.bOT & 8) == 8) {
                fVar.a(4, this.TCd);
            }
            fVar.e(this.TwK);
            AppMethodBeat.o(59155);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final int yC() {
            AppMethodBeat.i(59156);
            int i2 = this.bVY;
            if (i2 != -1) {
                AppMethodBeat.o(59156);
                return i2;
            }
            int i3 = 0;
            if ((this.bOT & 1) == 1) {
                i3 = f.c(1, this.TCa) + 0;
            }
            if ((this.bOT & 2) == 2) {
                i3 += f.c(2, this.TCb);
            }
            if ((this.bOT & 4) == 4) {
                i3 += f.c(3, this.TCc);
            }
            if ((this.bOT & 8) == 8) {
                i3 += f.c(4, this.TCd);
            }
            int size = i3 + this.TwK.size();
            this.bVY = size;
            AppMethodBeat.o(59156);
            return size;
        }

        /* renamed from: kotlin.l.b.a.b.e.c.a$c$a  reason: collision with other inner class name */
        public static final class C2333a extends i.a<c, C2333a> implements d {
            private C2330a TCa = C2330a.hIm();
            private b TCb = b.hIs();
            private b TCc = b.hIs();
            private b TCd = b.hIs();
            private int bOT;

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.l.b.a.b.h.i] */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2333a a(c cVar) {
                AppMethodBeat.i(59144);
                C2333a b2 = b(cVar);
                AppMethodBeat.o(59144);
                return b2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
            public final /* synthetic */ a.AbstractC2337a c(e eVar, g gVar) {
                AppMethodBeat.i(59146);
                C2333a D = D(eVar, gVar);
                AppMethodBeat.o(59146);
                return D;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a, java.lang.Object
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(59151);
                C2333a hIC = hIC();
                AppMethodBeat.o(59151);
                return hIC;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q.a d(e eVar, g gVar) {
                AppMethodBeat.i(59148);
                C2333a D = D(eVar, gVar);
                AppMethodBeat.o(59148);
                return D;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2333a hEE() {
                AppMethodBeat.i(59145);
                C2333a hIC = hIC();
                AppMethodBeat.o(59145);
                return hIC;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ a.AbstractC2337a hEF() {
                AppMethodBeat.i(59147);
                C2333a hIC = hIC();
                AppMethodBeat.o(59147);
                return hIC;
            }

            private C2333a() {
                AppMethodBeat.i(59134);
                AppMethodBeat.o(59134);
            }

            private c hID() {
                int i2 = 1;
                AppMethodBeat.i(59136);
                c cVar = new c(this, (byte) 0);
                int i3 = this.bOT;
                if ((i3 & 1) != 1) {
                    i2 = 0;
                }
                cVar.TCa = this.TCa;
                if ((i3 & 2) == 2) {
                    i2 |= 2;
                }
                cVar.TCb = this.TCb;
                if ((i3 & 4) == 4) {
                    i2 |= 4;
                }
                cVar.TCc = this.TCc;
                if ((i3 & 8) == 8) {
                    i2 |= 8;
                }
                cVar.TCd = this.TCd;
                cVar.bOT = i2;
                AppMethodBeat.o(59136);
                return cVar;
            }

            public final C2333a b(c cVar) {
                AppMethodBeat.i(59137);
                if (cVar == c.hIx()) {
                    AppMethodBeat.o(59137);
                } else {
                    if (cVar.hIy()) {
                        d(cVar.TCa);
                    }
                    if (cVar.hIz()) {
                        d(cVar.TCb);
                    }
                    if (cVar.hIA()) {
                        e(cVar.TCc);
                    }
                    if (cVar.hIB()) {
                        f(cVar.TCd);
                    }
                    this.TwK = this.TwK.a(cVar.TwK);
                    AppMethodBeat.o(59137);
                }
                return this;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private kotlin.l.b.a.b.e.c.a.c.C2333a D(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                /*
                    r4 = this;
                    r3 = 59138(0xe702, float:8.287E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    r2 = 0
                    kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.c.a$c> r0 = kotlin.l.b.a.b.e.c.a.c.TwL     // Catch:{ k -> 0x0016 }
                    java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                    kotlin.l.b.a.b.e.c.a$c r0 = (kotlin.l.b.a.b.e.c.a.c) r0     // Catch:{ k -> 0x0016 }
                    r4.b(r0)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return r4
                L_0x0016:
                    r0 = move-exception
                    r1 = r0
                    kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                    kotlin.l.b.a.b.e.c.a$c r0 = (kotlin.l.b.a.b.e.c.a.c) r0     // Catch:{ all -> 0x002e }
                    r2 = 59138(0xe702, float:8.287E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)     // Catch:{ all -> 0x0023 }
                    throw r1     // Catch:{ all -> 0x0023 }
                L_0x0023:
                    r1 = move-exception
                    r2 = r0
                L_0x0025:
                    if (r2 == 0) goto L_0x002a
                    r4.b(r2)
                L_0x002a:
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    throw r1
                L_0x002e:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x0025
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.c.a.c.C2333a.D(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.c.a$c$a");
            }

            private C2333a d(C2330a aVar) {
                AppMethodBeat.i(59139);
                if ((this.bOT & 1) != 1 || this.TCa == C2330a.hIm()) {
                    this.TCa = aVar;
                } else {
                    this.TCa = C2330a.a(this.TCa).c(aVar).hIq();
                }
                this.bOT |= 1;
                AppMethodBeat.o(59139);
                return this;
            }

            private C2333a d(b bVar) {
                AppMethodBeat.i(59140);
                if ((this.bOT & 2) != 2 || this.TCb == b.hIs()) {
                    this.TCb = bVar;
                } else {
                    this.TCb = b.a(this.TCb).c(bVar).hIv();
                }
                this.bOT |= 2;
                AppMethodBeat.o(59140);
                return this;
            }

            private C2333a e(b bVar) {
                AppMethodBeat.i(59141);
                if ((this.bOT & 4) != 4 || this.TCc == b.hIs()) {
                    this.TCc = bVar;
                } else {
                    this.TCc = b.a(this.TCc).c(bVar).hIv();
                }
                this.bOT |= 4;
                AppMethodBeat.o(59141);
                return this;
            }

            private C2333a f(b bVar) {
                AppMethodBeat.i(59142);
                if ((this.bOT & 8) != 8 || this.TCd == b.hIs()) {
                    this.TCd = bVar;
                } else {
                    this.TCd = b.a(this.TCd).c(bVar).hIv();
                }
                this.bOT |= 8;
                AppMethodBeat.o(59142);
                return this;
            }

            private C2333a hIC() {
                AppMethodBeat.i(59135);
                C2333a b2 = new C2333a().b(hID());
                AppMethodBeat.o(59135);
                return b2;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ c hED() {
                AppMethodBeat.i(59143);
                c hIx = c.hIx();
                AppMethodBeat.o(59143);
                return hIx;
            }

            @Override // kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q hEG() {
                AppMethodBeat.i(59149);
                c hID = hID();
                if (!hID.isInitialized()) {
                    w wVar = new w();
                    AppMethodBeat.o(59149);
                    throw wVar;
                }
                AppMethodBeat.o(59149);
                return hID;
            }

            @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
            public final /* synthetic */ q hEy() {
                AppMethodBeat.i(59150);
                c hIx = c.hIx();
                AppMethodBeat.o(59150);
                return hIx;
            }

            static /* synthetic */ C2333a hIE() {
                AppMethodBeat.i(59152);
                C2333a aVar = new C2333a();
                AppMethodBeat.o(59152);
                return aVar;
            }
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEw() {
            AppMethodBeat.i(59157);
            C2333a b2 = C2333a.hIE().b(this);
            AppMethodBeat.o(59157);
            return b2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEx() {
            AppMethodBeat.i(59158);
            C2333a hIE = C2333a.hIE();
            AppMethodBeat.o(59158);
            return hIE;
        }

        @Override // kotlin.l.b.a.b.h.r
        public final /* bridge */ /* synthetic */ q hEy() {
            return TBZ;
        }
    }

    static {
        AppMethodBeat.i(59218);
        AppMethodBeat.o(59218);
    }
}
