package kotlin.l.b.a.b.e;

import android.support.constraint.ConstraintLayout;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.thumbplayer.core.common.TPCodecParamers;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.l.b.a.b.h.a;
import kotlin.l.b.a.b.h.d;
import kotlin.l.b.a.b.h.i;
import kotlin.l.b.a.b.h.j;
import kotlin.l.b.a.b.h.q;

public final class a {

    public enum j implements j.a {
        FINAL(0),
        OPEN(1),
        ABSTRACT(2),
        SEALED(3);
        
        private static j.b<j> Txp = new j.b<j>() {
            /* class kotlin.l.b.a.b.e.a.j.AnonymousClass1 */

            /* Return type fixed from 'kotlin.l.b.a.b.h.j$a' to match base method */
            @Override // kotlin.l.b.a.b.h.j.b
            public final /* synthetic */ j aua(int i2) {
                AppMethodBeat.i(58623);
                j auu = j.auu(i2);
                AppMethodBeat.o(58623);
                return auu;
            }
        };
        private final int value;

        public static j valueOf(String str) {
            AppMethodBeat.i(58625);
            j jVar = (j) Enum.valueOf(j.class, str);
            AppMethodBeat.o(58625);
            return jVar;
        }

        static {
            AppMethodBeat.i(58626);
            AppMethodBeat.o(58626);
        }

        @Override // kotlin.l.b.a.b.h.j.a
        public final int getNumber() {
            return this.value;
        }

        public static j auu(int i2) {
            switch (i2) {
                case 0:
                    return FINAL;
                case 1:
                    return OPEN;
                case 2:
                    return ABSTRACT;
                case 3:
                    return SEALED;
                default:
                    return null;
            }
        }

        private j(int i2) {
            this.value = i2;
        }
    }

    public enum w implements j.a {
        INTERNAL(0),
        PRIVATE(1),
        PROTECTED(2),
        PUBLIC(3),
        PRIVATE_TO_THIS(4),
        LOCAL(5);
        
        private static j.b<w> Txp = new j.b<w>() {
            /* class kotlin.l.b.a.b.e.a.w.AnonymousClass1 */

            /* Return type fixed from 'kotlin.l.b.a.b.h.j$a' to match base method */
            @Override // kotlin.l.b.a.b.h.j.b
            public final /* synthetic */ w aua(int i2) {
                AppMethodBeat.i(59042);
                w avj = w.avj(i2);
                AppMethodBeat.o(59042);
                return avj;
            }
        };
        private final int value;

        public static w valueOf(String str) {
            AppMethodBeat.i(59044);
            w wVar = (w) Enum.valueOf(w.class, str);
            AppMethodBeat.o(59044);
            return wVar;
        }

        static {
            AppMethodBeat.i(59045);
            AppMethodBeat.o(59045);
        }

        @Override // kotlin.l.b.a.b.h.j.a
        public final int getNumber() {
            return this.value;
        }

        public static w avj(int i2) {
            switch (i2) {
                case 0:
                    return INTERNAL;
                case 1:
                    return PRIVATE;
                case 2:
                    return PROTECTED;
                case 3:
                    return PUBLIC;
                case 4:
                    return PRIVATE_TO_THIS;
                case 5:
                    return LOCAL;
                default:
                    return null;
            }
        }

        private w(int i2) {
            this.value = i2;
        }
    }

    public enum i implements j.a {
        DECLARATION(0),
        FAKE_OVERRIDE(1),
        DELEGATION(2),
        SYNTHESIZED(3);
        
        private static j.b<i> Txp = new j.b<i>() {
            /* class kotlin.l.b.a.b.e.a.i.AnonymousClass1 */

            /* Return type fixed from 'kotlin.l.b.a.b.h.j$a' to match base method */
            @Override // kotlin.l.b.a.b.h.j.b
            public final /* synthetic */ i aua(int i2) {
                AppMethodBeat.i(58619);
                i aut = i.aut(i2);
                AppMethodBeat.o(58619);
                return aut;
            }
        };
        private final int value;

        public static i valueOf(String str) {
            AppMethodBeat.i(58621);
            i iVar = (i) Enum.valueOf(i.class, str);
            AppMethodBeat.o(58621);
            return iVar;
        }

        static {
            AppMethodBeat.i(58622);
            AppMethodBeat.o(58622);
        }

        @Override // kotlin.l.b.a.b.h.j.a
        public final int getNumber() {
            return this.value;
        }

        public static i aut(int i2) {
            switch (i2) {
                case 0:
                    return DECLARATION;
                case 1:
                    return FAKE_OVERRIDE;
                case 2:
                    return DELEGATION;
                case 3:
                    return SYNTHESIZED;
                default:
                    return null;
            }
        }

        private i(int i2) {
            this.value = i2;
        }
    }

    public static final class o extends kotlin.l.b.a.b.h.i implements q {
        public static kotlin.l.b.a.b.h.s<o> TwL = new kotlin.l.b.a.b.h.b<o>() {
            /* class kotlin.l.b.a.b.e.a.o.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.h.s
            public final /* synthetic */ Object a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58777);
                o oVar = new o(eVar, gVar, (byte) 0);
                AppMethodBeat.o(58777);
                return oVar;
            }
        };
        private static final o Tzh;
        private final kotlin.l.b.a.b.h.d TwK;
        private kotlin.l.b.a.b.h.o Tzi;
        private byte bPe;
        private int bVY;

        /* synthetic */ o(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar, byte b2) {
            this(eVar, gVar);
        }

        /* synthetic */ o(i.a aVar, byte b2) {
            this(aVar);
        }

        private o(i.a aVar) {
            super((byte) 0);
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = aVar.TwK;
        }

        private o() {
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = kotlin.l.b.a.b.h.d.TDp;
        }

        public static o hGN() {
            return Tzh;
        }

        private o(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
            AppMethodBeat.i(58793);
            this.bPe = -1;
            this.bVY = -1;
            this.Tzi = kotlin.l.b.a.b.h.n.TDQ;
            d.b hJo = kotlin.l.b.a.b.h.d.hJo();
            kotlin.l.b.a.b.h.f f2 = kotlin.l.b.a.b.h.f.f(hJo, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int yT = eVar.yT();
                    switch (yT) {
                        case 0:
                            z = true;
                            break;
                        case 10:
                            kotlin.l.b.a.b.h.d hJt = eVar.hJt();
                            if (!z2 || !true) {
                                this.Tzi = new kotlin.l.b.a.b.h.n();
                                z2 |= true;
                            }
                            this.Tzi.f(hJt);
                            break;
                        default:
                            if (a(eVar, f2, gVar, yT)) {
                                break;
                            } else {
                                z = true;
                                break;
                            }
                    }
                } catch (kotlin.l.b.a.b.h.k e2) {
                    e2.TDK = this;
                    AppMethodBeat.o(58793);
                    throw e2;
                } catch (IOException e3) {
                    kotlin.l.b.a.b.h.k kVar = new kotlin.l.b.a.b.h.k(e3.getMessage());
                    kVar.TDK = this;
                    AppMethodBeat.o(58793);
                    throw kVar;
                } catch (Throwable th) {
                    if (z2 && true) {
                        this.Tzi = this.Tzi.hJM();
                    }
                    try {
                        f2.flush();
                        this.TwK = hJo.hJs();
                    } catch (IOException e4) {
                        this.TwK = hJo.hJs();
                    } catch (Throwable th2) {
                        this.TwK = hJo.hJs();
                        AppMethodBeat.o(58793);
                        throw th2;
                    }
                    Gw();
                    AppMethodBeat.o(58793);
                    throw th;
                }
            }
            if (z2 && true) {
                this.Tzi = this.Tzi.hJM();
            }
            try {
                f2.flush();
                this.TwK = hJo.hJs();
            } catch (IOException e5) {
                this.TwK = hJo.hJs();
            } catch (Throwable th3) {
                this.TwK = hJo.hJs();
                AppMethodBeat.o(58793);
                throw th3;
            }
            Gw();
            AppMethodBeat.o(58793);
        }

        static {
            AppMethodBeat.i(58800);
            o oVar = new o();
            Tzh = oVar;
            oVar.Tzi = kotlin.l.b.a.b.h.n.TDQ;
            AppMethodBeat.o(58800);
        }

        @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
        public final kotlin.l.b.a.b.h.s<o> hEs() {
            return TwL;
        }

        public final String getString(int i2) {
            AppMethodBeat.i(58794);
            String str = (String) this.Tzi.get(i2);
            AppMethodBeat.o(58794);
            return str;
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
        public final void a(kotlin.l.b.a.b.h.f fVar) {
            AppMethodBeat.i(58795);
            yC();
            for (int i2 = 0; i2 < this.Tzi.size(); i2++) {
                fVar.a(1, this.Tzi.avC(i2));
            }
            fVar.e(this.TwK);
            AppMethodBeat.o(58795);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final int yC() {
            int i2 = 0;
            AppMethodBeat.i(58796);
            int i3 = this.bVY;
            if (i3 != -1) {
                AppMethodBeat.o(58796);
                return i3;
            }
            for (int i4 = 0; i4 < this.Tzi.size(); i4++) {
                i2 = kotlin.l.b.a.b.h.f.d(this.Tzi.avC(i4)) + i2;
            }
            int size = i2 + 0 + (this.Tzi.size() * 1) + this.TwK.size();
            this.bVY = size;
            AppMethodBeat.o(58796);
            return size;
        }

        /* renamed from: kotlin.l.b.a.b.e.a$o$a  reason: collision with other inner class name */
        public static final class C2319a extends i.a<o, C2319a> implements q {
            private kotlin.l.b.a.b.h.o Tzi = kotlin.l.b.a.b.h.n.TDQ;
            private int bOT;

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.l.b.a.b.h.i] */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2319a a(o oVar) {
                AppMethodBeat.i(58784);
                C2319a e2 = e(oVar);
                AppMethodBeat.o(58784);
                return e2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
            public final /* synthetic */ a.AbstractC2337a c(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58786);
                C2319a s = s(eVar, gVar);
                AppMethodBeat.o(58786);
                return s;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a, java.lang.Object
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(58791);
                C2319a hGO = hGO();
                AppMethodBeat.o(58791);
                return hGO;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q.a d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58788);
                C2319a s = s(eVar, gVar);
                AppMethodBeat.o(58788);
                return s;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2319a hEE() {
                AppMethodBeat.i(58785);
                C2319a hGO = hGO();
                AppMethodBeat.o(58785);
                return hGO;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ a.AbstractC2337a hEF() {
                AppMethodBeat.i(58787);
                C2319a hGO = hGO();
                AppMethodBeat.o(58787);
                return hGO;
            }

            private C2319a() {
            }

            public final o hGP() {
                AppMethodBeat.i(58779);
                o oVar = new o(this, (byte) 0);
                if ((this.bOT & 1) == 1) {
                    this.Tzi = this.Tzi.hJM();
                    this.bOT &= -2;
                }
                oVar.Tzi = this.Tzi;
                AppMethodBeat.o(58779);
                return oVar;
            }

            public final C2319a e(o oVar) {
                AppMethodBeat.i(58780);
                if (oVar == o.hGN()) {
                    AppMethodBeat.o(58780);
                } else {
                    if (!oVar.Tzi.isEmpty()) {
                        if (this.Tzi.isEmpty()) {
                            this.Tzi = oVar.Tzi;
                            this.bOT &= -2;
                        } else {
                            hGQ();
                            this.Tzi.addAll(oVar.Tzi);
                        }
                    }
                    this.TwK = this.TwK.a(oVar.TwK);
                    AppMethodBeat.o(58780);
                }
                return this;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private kotlin.l.b.a.b.e.a.o.C2319a s(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                /*
                    r4 = this;
                    r3 = 58781(0xe59d, float:8.237E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    r2 = 0
                    kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.a$o> r0 = kotlin.l.b.a.b.e.a.o.TwL     // Catch:{ k -> 0x0016 }
                    java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                    kotlin.l.b.a.b.e.a$o r0 = (kotlin.l.b.a.b.e.a.o) r0     // Catch:{ k -> 0x0016 }
                    r4.e(r0)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return r4
                L_0x0016:
                    r0 = move-exception
                    r1 = r0
                    kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                    kotlin.l.b.a.b.e.a$o r0 = (kotlin.l.b.a.b.e.a.o) r0     // Catch:{ all -> 0x002e }
                    r2 = 58781(0xe59d, float:8.237E-41)
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.o.C2319a.s(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.a$o$a");
            }

            private void hGQ() {
                AppMethodBeat.i(58782);
                if ((this.bOT & 1) != 1) {
                    this.Tzi = new kotlin.l.b.a.b.h.n(this.Tzi);
                    this.bOT |= 1;
                }
                AppMethodBeat.o(58782);
            }

            private C2319a hGO() {
                AppMethodBeat.i(58778);
                C2319a e2 = new C2319a().e(hGP());
                AppMethodBeat.o(58778);
                return e2;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ o hED() {
                AppMethodBeat.i(58783);
                o hGN = o.hGN();
                AppMethodBeat.o(58783);
                return hGN;
            }

            @Override // kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEG() {
                AppMethodBeat.i(58789);
                o hGP = hGP();
                if (!hGP.isInitialized()) {
                    kotlin.l.b.a.b.h.w wVar = new kotlin.l.b.a.b.h.w();
                    AppMethodBeat.o(58789);
                    throw wVar;
                }
                AppMethodBeat.o(58789);
                return hGP;
            }

            @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                AppMethodBeat.i(58790);
                o hGN = o.hGN();
                AppMethodBeat.o(58790);
                return hGN;
            }

            static /* synthetic */ C2319a hGR() {
                AppMethodBeat.i(58792);
                C2319a aVar = new C2319a();
                AppMethodBeat.o(58792);
                return aVar;
            }
        }

        public static C2319a b(o oVar) {
            AppMethodBeat.i(58797);
            C2319a e2 = C2319a.hGR().e(oVar);
            AppMethodBeat.o(58797);
            return e2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEw() {
            AppMethodBeat.i(58798);
            C2319a e2 = C2319a.hGR().e(this);
            AppMethodBeat.o(58798);
            return e2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEx() {
            AppMethodBeat.i(58799);
            C2319a hGR = C2319a.hGR();
            AppMethodBeat.o(58799);
            return hGR;
        }

        @Override // kotlin.l.b.a.b.h.r
        public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
            return Tzh;
        }
    }

    public static final class n extends kotlin.l.b.a.b.h.i implements p {
        public static kotlin.l.b.a.b.h.s<n> TwL = new kotlin.l.b.a.b.h.b<n>() {
            /* class kotlin.l.b.a.b.e.a.n.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.h.s
            public final /* synthetic */ Object a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58723);
                n nVar = new n(eVar, gVar, (byte) 0);
                AppMethodBeat.o(58723);
                return nVar;
            }
        };
        private static final n TyX;
        private final kotlin.l.b.a.b.h.d TwK;
        private List<b> TyY;
        private byte bPe;
        private int bVY;

        /* synthetic */ n(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar, byte b2) {
            this(eVar, gVar);
        }

        /* synthetic */ n(i.a aVar, byte b2) {
            this(aVar);
        }

        private n(i.a aVar) {
            super((byte) 0);
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = aVar.TwK;
        }

        private n() {
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = kotlin.l.b.a.b.h.d.TDp;
        }

        public static n hGC() {
            return TyX;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: java.util.List<kotlin.l.b.a.b.e.a$n$b> */
        /* JADX WARN: Multi-variable type inference failed */
        private n(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
            AppMethodBeat.i(58768);
            this.bPe = -1;
            this.bVY = -1;
            this.TyY = Collections.emptyList();
            d.b hJo = kotlin.l.b.a.b.h.d.hJo();
            kotlin.l.b.a.b.h.f f2 = kotlin.l.b.a.b.h.f.f(hJo, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int yT = eVar.yT();
                    switch (yT) {
                        case 0:
                            z = true;
                            break;
                        case 10:
                            if (!z2 || !true) {
                                this.TyY = new ArrayList();
                                z2 |= true;
                            }
                            this.TyY.add(eVar.a(b.TwL, gVar));
                            break;
                        default:
                            if (a(eVar, f2, gVar, yT)) {
                                break;
                            } else {
                                z = true;
                                break;
                            }
                    }
                } catch (kotlin.l.b.a.b.h.k e2) {
                    e2.TDK = this;
                    AppMethodBeat.o(58768);
                    throw e2;
                } catch (IOException e3) {
                    kotlin.l.b.a.b.h.k kVar = new kotlin.l.b.a.b.h.k(e3.getMessage());
                    kVar.TDK = this;
                    AppMethodBeat.o(58768);
                    throw kVar;
                } catch (Throwable th) {
                    if (z2 && true) {
                        this.TyY = Collections.unmodifiableList(this.TyY);
                    }
                    try {
                        f2.flush();
                        this.TwK = hJo.hJs();
                    } catch (IOException e4) {
                        this.TwK = hJo.hJs();
                    } catch (Throwable th2) {
                        this.TwK = hJo.hJs();
                        AppMethodBeat.o(58768);
                        throw th2;
                    }
                    Gw();
                    AppMethodBeat.o(58768);
                    throw th;
                }
            }
            if (z2 && true) {
                this.TyY = Collections.unmodifiableList(this.TyY);
            }
            try {
                f2.flush();
                this.TwK = hJo.hJs();
            } catch (IOException e5) {
                this.TwK = hJo.hJs();
            } catch (Throwable th3) {
                this.TwK = hJo.hJs();
                AppMethodBeat.o(58768);
                throw th3;
            }
            Gw();
            AppMethodBeat.o(58768);
        }

        static {
            AppMethodBeat.i(58776);
            n nVar = new n();
            TyX = nVar;
            nVar.TyY = Collections.emptyList();
            AppMethodBeat.o(58776);
        }

        @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
        public final kotlin.l.b.a.b.h.s<n> hEs() {
            return TwL;
        }

        public static final class b extends kotlin.l.b.a.b.h.i implements o {
            public static kotlin.l.b.a.b.h.s<b> TwL = new kotlin.l.b.a.b.h.b<b>() {
                /* class kotlin.l.b.a.b.e.a.n.b.AnonymousClass1 */

                @Override // kotlin.l.b.a.b.h.s
                public final /* synthetic */ Object a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                    AppMethodBeat.i(58741);
                    b bVar = new b(eVar, gVar, (byte) 0);
                    AppMethodBeat.o(58741);
                    return bVar;
                }
            };
            private static final b TyZ;
            private final kotlin.l.b.a.b.h.d TwK;
            public int Tza;
            public int Tzb;
            public EnumC2318b Tzc;
            private int bOT;
            private byte bPe;
            private int bVY;

            /* synthetic */ b(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar, byte b2) {
                this(eVar, gVar);
            }

            /* synthetic */ b(i.a aVar, byte b2) {
                this(aVar);
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

            public static b hGH() {
                return TyZ;
            }

            private b(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58761);
                this.bPe = -1;
                this.bVY = -1;
                hEu();
                d.b hJo = kotlin.l.b.a.b.h.d.hJo();
                kotlin.l.b.a.b.h.f f2 = kotlin.l.b.a.b.h.f.f(hJo, 1);
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
                                this.Tza = eVar.zi();
                                break;
                            case 16:
                                this.bOT |= 2;
                                this.Tzb = eVar.zi();
                                break;
                            case 24:
                                int zi = eVar.zi();
                                EnumC2318b auF = EnumC2318b.auF(zi);
                                if (auF != null) {
                                    this.bOT |= 4;
                                    this.Tzc = auF;
                                    break;
                                } else {
                                    f2.hc(yT);
                                    f2.hc(zi);
                                    break;
                                }
                            default:
                                if (a(eVar, f2, gVar, yT)) {
                                    break;
                                } else {
                                    z = true;
                                    break;
                                }
                        }
                    } catch (kotlin.l.b.a.b.h.k e2) {
                        e2.TDK = this;
                        AppMethodBeat.o(58761);
                        throw e2;
                    } catch (IOException e3) {
                        kotlin.l.b.a.b.h.k kVar = new kotlin.l.b.a.b.h.k(e3.getMessage());
                        kVar.TDK = this;
                        AppMethodBeat.o(58761);
                        throw kVar;
                    } catch (Throwable th) {
                        try {
                            f2.flush();
                            this.TwK = hJo.hJs();
                        } catch (IOException e4) {
                            this.TwK = hJo.hJs();
                        } catch (Throwable th2) {
                            this.TwK = hJo.hJs();
                            AppMethodBeat.o(58761);
                            throw th2;
                        }
                        Gw();
                        AppMethodBeat.o(58761);
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
                    AppMethodBeat.o(58761);
                    throw th3;
                }
                Gw();
                AppMethodBeat.o(58761);
            }

            static {
                AppMethodBeat.i(58767);
                b bVar = new b();
                TyZ = bVar;
                bVar.hEu();
                AppMethodBeat.o(58767);
            }

            @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
            public final kotlin.l.b.a.b.h.s<b> hEs() {
                return TwL;
            }

            /* renamed from: kotlin.l.b.a.b.e.a$n$b$b  reason: collision with other inner class name */
            public enum EnumC2318b implements j.a {
                CLASS(0),
                PACKAGE(1),
                LOCAL(2);
                
                private static j.b<EnumC2318b> Txp = new j.b<EnumC2318b>() {
                    /* class kotlin.l.b.a.b.e.a.n.b.EnumC2318b.AnonymousClass1 */

                    /* Return type fixed from 'kotlin.l.b.a.b.h.j$a' to match base method */
                    @Override // kotlin.l.b.a.b.h.j.b
                    public final /* synthetic */ EnumC2318b aua(int i2) {
                        AppMethodBeat.i(58757);
                        EnumC2318b auF = EnumC2318b.auF(i2);
                        AppMethodBeat.o(58757);
                        return auF;
                    }
                };
                final int value;

                public static EnumC2318b valueOf(String str) {
                    AppMethodBeat.i(58759);
                    EnumC2318b bVar = (EnumC2318b) Enum.valueOf(EnumC2318b.class, str);
                    AppMethodBeat.o(58759);
                    return bVar;
                }

                static {
                    AppMethodBeat.i(58760);
                    AppMethodBeat.o(58760);
                }

                @Override // kotlin.l.b.a.b.h.j.a
                public final int getNumber() {
                    return this.value;
                }

                public static EnumC2318b auF(int i2) {
                    switch (i2) {
                        case 0:
                            return CLASS;
                        case 1:
                            return PACKAGE;
                        case 2:
                            return LOCAL;
                        default:
                            return null;
                    }
                }

                private EnumC2318b(int i2) {
                    this.value = i2;
                }
            }

            public final boolean hGI() {
                return (this.bOT & 1) == 1;
            }

            public final boolean hGJ() {
                return (this.bOT & 2) == 2;
            }

            public final boolean hFG() {
                return (this.bOT & 4) == 4;
            }

            private void hEu() {
                this.Tza = -1;
                this.Tzb = 0;
                this.Tzc = EnumC2318b.PACKAGE;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                AppMethodBeat.i(58762);
                byte b2 = this.bPe;
                if (b2 == 1) {
                    AppMethodBeat.o(58762);
                    return true;
                } else if (b2 == 0) {
                    AppMethodBeat.o(58762);
                    return false;
                } else if (!hGJ()) {
                    this.bPe = 0;
                    AppMethodBeat.o(58762);
                    return false;
                } else {
                    this.bPe = 1;
                    AppMethodBeat.o(58762);
                    return true;
                }
            }

            @Override // kotlin.l.b.a.b.h.q
            public final void a(kotlin.l.b.a.b.h.f fVar) {
                AppMethodBeat.i(58763);
                yC();
                if ((this.bOT & 1) == 1) {
                    fVar.bs(1, this.Tza);
                }
                if ((this.bOT & 2) == 2) {
                    fVar.bs(2, this.Tzb);
                }
                if ((this.bOT & 4) == 4) {
                    fVar.nb(3, this.Tzc.value);
                }
                fVar.e(this.TwK);
                AppMethodBeat.o(58763);
            }

            @Override // kotlin.l.b.a.b.h.q
            public final int yC() {
                AppMethodBeat.i(58764);
                int i2 = this.bVY;
                if (i2 != -1) {
                    AppMethodBeat.o(58764);
                    return i2;
                }
                int i3 = 0;
                if ((this.bOT & 1) == 1) {
                    i3 = kotlin.l.b.a.b.h.f.bu(1, this.Tza) + 0;
                }
                if ((this.bOT & 2) == 2) {
                    i3 += kotlin.l.b.a.b.h.f.bu(2, this.Tzb);
                }
                if ((this.bOT & 4) == 4) {
                    i3 += kotlin.l.b.a.b.h.f.bv(3, this.Tzc.value);
                }
                int size = i3 + this.TwK.size();
                this.bVY = size;
                AppMethodBeat.o(58764);
                return size;
            }

            /* renamed from: kotlin.l.b.a.b.e.a$n$b$a  reason: collision with other inner class name */
            public static final class C2317a extends i.a<b, C2317a> implements o {
                private int Tza = -1;
                private int Tzb;
                private EnumC2318b Tzc = EnumC2318b.PACKAGE;
                private int bOT;

                /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.l.b.a.b.h.i] */
                @Override // kotlin.l.b.a.b.h.i.a
                public final /* synthetic */ C2317a a(b bVar) {
                    AppMethodBeat.i(58748);
                    C2317a b2 = b(bVar);
                    AppMethodBeat.o(58748);
                    return b2;
                }

                @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
                public final /* synthetic */ a.AbstractC2337a c(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                    AppMethodBeat.i(58750);
                    C2317a r = r(eVar, gVar);
                    AppMethodBeat.o(58750);
                    return r;
                }

                @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a, java.lang.Object
                public final /* synthetic */ Object clone() {
                    AppMethodBeat.i(58755);
                    C2317a hGK = hGK();
                    AppMethodBeat.o(58755);
                    return hGK;
                }

                @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
                public final /* synthetic */ q.a d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                    AppMethodBeat.i(58752);
                    C2317a r = r(eVar, gVar);
                    AppMethodBeat.o(58752);
                    return r;
                }

                /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
                @Override // kotlin.l.b.a.b.h.i.a
                public final /* synthetic */ C2317a hEE() {
                    AppMethodBeat.i(58749);
                    C2317a hGK = hGK();
                    AppMethodBeat.o(58749);
                    return hGK;
                }

                @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a
                public final /* synthetic */ a.AbstractC2337a hEF() {
                    AppMethodBeat.i(58751);
                    C2317a hGK = hGK();
                    AppMethodBeat.o(58751);
                    return hGK;
                }

                private C2317a() {
                }

                private b hGL() {
                    int i2 = 1;
                    AppMethodBeat.i(58743);
                    b bVar = new b(this, (byte) 0);
                    int i3 = this.bOT;
                    if ((i3 & 1) != 1) {
                        i2 = 0;
                    }
                    bVar.Tza = this.Tza;
                    if ((i3 & 2) == 2) {
                        i2 |= 2;
                    }
                    bVar.Tzb = this.Tzb;
                    if ((i3 & 4) == 4) {
                        i2 |= 4;
                    }
                    bVar.Tzc = this.Tzc;
                    bVar.bOT = i2;
                    AppMethodBeat.o(58743);
                    return bVar;
                }

                public final C2317a b(b bVar) {
                    AppMethodBeat.i(58744);
                    if (bVar == b.hGH()) {
                        AppMethodBeat.o(58744);
                    } else {
                        if (bVar.hGI()) {
                            auD(bVar.Tza);
                        }
                        if (bVar.hGJ()) {
                            auE(bVar.Tzb);
                        }
                        if (bVar.hFG()) {
                            a(bVar.Tzc);
                        }
                        this.TwK = this.TwK.a(bVar.TwK);
                        AppMethodBeat.o(58744);
                    }
                    return this;
                }

                @Override // kotlin.l.b.a.b.h.r
                public final boolean isInitialized() {
                    boolean z;
                    if ((this.bOT & 2) == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    return z;
                }

                /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                private kotlin.l.b.a.b.e.a.n.b.C2317a r(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                    /*
                        r4 = this;
                        r3 = 58745(0xe579, float:8.2319E-41)
                        com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                        r2 = 0
                        kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.a$n$b> r0 = kotlin.l.b.a.b.e.a.n.b.TwL     // Catch:{ k -> 0x0016 }
                        java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                        kotlin.l.b.a.b.e.a$n$b r0 = (kotlin.l.b.a.b.e.a.n.b) r0     // Catch:{ k -> 0x0016 }
                        r4.b(r0)
                        com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                        return r4
                    L_0x0016:
                        r0 = move-exception
                        r1 = r0
                        kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                        kotlin.l.b.a.b.e.a$n$b r0 = (kotlin.l.b.a.b.e.a.n.b) r0     // Catch:{ all -> 0x002e }
                        r2 = 58745(0xe579, float:8.2319E-41)
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
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.n.b.C2317a.r(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.a$n$b$a");
                }

                private C2317a auD(int i2) {
                    this.bOT |= 1;
                    this.Tza = i2;
                    return this;
                }

                private C2317a auE(int i2) {
                    this.bOT |= 2;
                    this.Tzb = i2;
                    return this;
                }

                private C2317a a(EnumC2318b bVar) {
                    AppMethodBeat.i(58746);
                    if (bVar == null) {
                        NullPointerException nullPointerException = new NullPointerException();
                        AppMethodBeat.o(58746);
                        throw nullPointerException;
                    }
                    this.bOT |= 4;
                    this.Tzc = bVar;
                    AppMethodBeat.o(58746);
                    return this;
                }

                private C2317a hGK() {
                    AppMethodBeat.i(58742);
                    C2317a b2 = new C2317a().b(hGL());
                    AppMethodBeat.o(58742);
                    return b2;
                }

                /* Return type fixed from 'kotlin.l.b.a.b.h.i' to match base method */
                @Override // kotlin.l.b.a.b.h.i.a
                public final /* synthetic */ b hED() {
                    AppMethodBeat.i(58747);
                    b hGH = b.hGH();
                    AppMethodBeat.o(58747);
                    return hGH;
                }

                @Override // kotlin.l.b.a.b.h.q.a
                public final /* synthetic */ kotlin.l.b.a.b.h.q hEG() {
                    AppMethodBeat.i(58753);
                    b hGL = hGL();
                    if (!hGL.isInitialized()) {
                        kotlin.l.b.a.b.h.w wVar = new kotlin.l.b.a.b.h.w();
                        AppMethodBeat.o(58753);
                        throw wVar;
                    }
                    AppMethodBeat.o(58753);
                    return hGL;
                }

                @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
                public final /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                    AppMethodBeat.i(58754);
                    b hGH = b.hGH();
                    AppMethodBeat.o(58754);
                    return hGH;
                }

                static /* synthetic */ C2317a hGM() {
                    AppMethodBeat.i(58756);
                    C2317a aVar = new C2317a();
                    AppMethodBeat.o(58756);
                    return aVar;
                }
            }

            @Override // kotlin.l.b.a.b.h.q
            public final /* synthetic */ q.a hEw() {
                AppMethodBeat.i(58765);
                C2317a b2 = C2317a.hGM().b(this);
                AppMethodBeat.o(58765);
                return b2;
            }

            @Override // kotlin.l.b.a.b.h.q
            public final /* synthetic */ q.a hEx() {
                AppMethodBeat.i(58766);
                C2317a hGM = C2317a.hGM();
                AppMethodBeat.o(58766);
                return hGM;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                return TyZ;
            }
        }

        public final b auC(int i2) {
            AppMethodBeat.i(58769);
            b bVar = this.TyY.get(i2);
            AppMethodBeat.o(58769);
            return bVar;
        }

        @Override // kotlin.l.b.a.b.h.r
        public final boolean isInitialized() {
            AppMethodBeat.i(58770);
            byte b2 = this.bPe;
            if (b2 == 1) {
                AppMethodBeat.o(58770);
                return true;
            } else if (b2 == 0) {
                AppMethodBeat.o(58770);
                return false;
            } else {
                for (int i2 = 0; i2 < this.TyY.size(); i2++) {
                    if (!auC(i2).isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58770);
                        return false;
                    }
                }
                this.bPe = 1;
                AppMethodBeat.o(58770);
                return true;
            }
        }

        @Override // kotlin.l.b.a.b.h.q
        public final void a(kotlin.l.b.a.b.h.f fVar) {
            AppMethodBeat.i(58771);
            yC();
            for (int i2 = 0; i2 < this.TyY.size(); i2++) {
                fVar.a(1, this.TyY.get(i2));
            }
            fVar.e(this.TwK);
            AppMethodBeat.o(58771);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final int yC() {
            AppMethodBeat.i(58772);
            int i2 = this.bVY;
            if (i2 != -1) {
                AppMethodBeat.o(58772);
                return i2;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.TyY.size(); i4++) {
                i3 += kotlin.l.b.a.b.h.f.c(1, this.TyY.get(i4));
            }
            int size = this.TwK.size() + i3;
            this.bVY = size;
            AppMethodBeat.o(58772);
            return size;
        }

        /* renamed from: kotlin.l.b.a.b.e.a$n$a  reason: collision with other inner class name */
        public static final class C2316a extends i.a<n, C2316a> implements p {
            private List<b> TyY = Collections.emptyList();
            private int bOT;

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.l.b.a.b.h.i] */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2316a a(n nVar) {
                AppMethodBeat.i(58732);
                C2316a e2 = e(nVar);
                AppMethodBeat.o(58732);
                return e2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
            public final /* synthetic */ a.AbstractC2337a c(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58734);
                C2316a q = q(eVar, gVar);
                AppMethodBeat.o(58734);
                return q;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a, java.lang.Object
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(58739);
                C2316a hGD = hGD();
                AppMethodBeat.o(58739);
                return hGD;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q.a d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58736);
                C2316a q = q(eVar, gVar);
                AppMethodBeat.o(58736);
                return q;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2316a hEE() {
                AppMethodBeat.i(58733);
                C2316a hGD = hGD();
                AppMethodBeat.o(58733);
                return hGD;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ a.AbstractC2337a hEF() {
                AppMethodBeat.i(58735);
                C2316a hGD = hGD();
                AppMethodBeat.o(58735);
                return hGD;
            }

            private C2316a() {
                AppMethodBeat.i(58724);
                AppMethodBeat.o(58724);
            }

            public final n hGE() {
                AppMethodBeat.i(58726);
                n nVar = new n(this, (byte) 0);
                if ((this.bOT & 1) == 1) {
                    this.TyY = Collections.unmodifiableList(this.TyY);
                    this.bOT &= -2;
                }
                nVar.TyY = this.TyY;
                AppMethodBeat.o(58726);
                return nVar;
            }

            public final C2316a e(n nVar) {
                AppMethodBeat.i(58727);
                if (nVar == n.hGC()) {
                    AppMethodBeat.o(58727);
                } else {
                    if (!nVar.TyY.isEmpty()) {
                        if (this.TyY.isEmpty()) {
                            this.TyY = nVar.TyY;
                            this.bOT &= -2;
                        } else {
                            hGF();
                            this.TyY.addAll(nVar.TyY);
                        }
                    }
                    this.TwK = this.TwK.a(nVar.TwK);
                    AppMethodBeat.o(58727);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private kotlin.l.b.a.b.e.a.n.C2316a q(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                /*
                    r4 = this;
                    r3 = 58729(0xe569, float:8.2297E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    r2 = 0
                    kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.a$n> r0 = kotlin.l.b.a.b.e.a.n.TwL     // Catch:{ k -> 0x0016 }
                    java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                    kotlin.l.b.a.b.e.a$n r0 = (kotlin.l.b.a.b.e.a.n) r0     // Catch:{ k -> 0x0016 }
                    r4.e(r0)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return r4
                L_0x0016:
                    r0 = move-exception
                    r1 = r0
                    kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                    kotlin.l.b.a.b.e.a$n r0 = (kotlin.l.b.a.b.e.a.n) r0     // Catch:{ all -> 0x002e }
                    r2 = 58729(0xe569, float:8.2297E-41)
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.n.C2316a.q(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.a$n$a");
            }

            private void hGF() {
                AppMethodBeat.i(58730);
                if ((this.bOT & 1) != 1) {
                    this.TyY = new ArrayList(this.TyY);
                    this.bOT |= 1;
                }
                AppMethodBeat.o(58730);
            }

            private C2316a hGD() {
                AppMethodBeat.i(58725);
                C2316a e2 = new C2316a().e(hGE());
                AppMethodBeat.o(58725);
                return e2;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                AppMethodBeat.i(58728);
                for (int i2 = 0; i2 < this.TyY.size(); i2++) {
                    if (!this.TyY.get(i2).isInitialized()) {
                        AppMethodBeat.o(58728);
                        return false;
                    }
                }
                AppMethodBeat.o(58728);
                return true;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ n hED() {
                AppMethodBeat.i(58731);
                n hGC = n.hGC();
                AppMethodBeat.o(58731);
                return hGC;
            }

            @Override // kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEG() {
                AppMethodBeat.i(58737);
                n hGE = hGE();
                if (!hGE.isInitialized()) {
                    kotlin.l.b.a.b.h.w wVar = new kotlin.l.b.a.b.h.w();
                    AppMethodBeat.o(58737);
                    throw wVar;
                }
                AppMethodBeat.o(58737);
                return hGE;
            }

            @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                AppMethodBeat.i(58738);
                n hGC = n.hGC();
                AppMethodBeat.o(58738);
                return hGC;
            }

            static /* synthetic */ C2316a hGG() {
                AppMethodBeat.i(58740);
                C2316a aVar = new C2316a();
                AppMethodBeat.o(58740);
                return aVar;
            }
        }

        public static C2316a b(n nVar) {
            AppMethodBeat.i(58773);
            C2316a e2 = C2316a.hGG().e(nVar);
            AppMethodBeat.o(58773);
            return e2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEw() {
            AppMethodBeat.i(58774);
            C2316a e2 = C2316a.hGG().e(this);
            AppMethodBeat.o(58774);
            return e2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEx() {
            AppMethodBeat.i(58775);
            C2316a hGG = C2316a.hGG();
            AppMethodBeat.o(58775);
            return hGG;
        }

        @Override // kotlin.l.b.a.b.h.r
        public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
            return TyX;
        }
    }

    /* renamed from: kotlin.l.b.a.b.e.a$a  reason: collision with other inner class name */
    public static final class C2299a extends kotlin.l.b.a.b.h.i implements d {
        private static final C2299a TwJ;
        public static kotlin.l.b.a.b.h.s<C2299a> TwL = new kotlin.l.b.a.b.h.b<C2299a>() {
            /* class kotlin.l.b.a.b.e.a.C2299a.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.h.s
            public final /* synthetic */ Object a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58302);
                C2299a aVar = new C2299a(eVar, gVar, (byte) 0);
                AppMethodBeat.o(58302);
                return aVar;
            }
        };
        private final kotlin.l.b.a.b.h.d TwK;
        public int TwM;
        public List<C2301a> TwN;
        private int bOT;
        private byte bPe;
        private int bVY;

        /* synthetic */ C2299a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar, byte b2) {
            this(eVar, gVar);
        }

        /* synthetic */ C2299a(i.a aVar, byte b2) {
            this(aVar);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEw() {
            AppMethodBeat.i(58388);
            b hEv = hEv();
            AppMethodBeat.o(58388);
            return hEv;
        }

        private C2299a(i.a aVar) {
            super((byte) 0);
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = aVar.TwK;
        }

        private C2299a() {
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = kotlin.l.b.a.b.h.d.TDp;
        }

        public static C2299a hEr() {
            return TwJ;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: java.util.List<kotlin.l.b.a.b.e.a$a$a> */
        /* JADX WARN: Multi-variable type inference failed */
        private C2299a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
            AppMethodBeat.i(58380);
            this.bPe = -1;
            this.bVY = -1;
            hEu();
            d.b hJo = kotlin.l.b.a.b.h.d.hJo();
            kotlin.l.b.a.b.h.f f2 = kotlin.l.b.a.b.h.f.f(hJo, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int yT = eVar.yT();
                    switch (yT) {
                        case 0:
                            z = true;
                            break;
                        case 8:
                            this.bOT |= 1;
                            this.TwM = eVar.zi();
                            break;
                        case 18:
                            if (!(z2 & true)) {
                                this.TwN = new ArrayList();
                                z2 |= true;
                            }
                            this.TwN.add(eVar.a(C2301a.TwL, gVar));
                            break;
                        default:
                            if (a(eVar, f2, gVar, yT)) {
                                break;
                            } else {
                                z = true;
                                break;
                            }
                    }
                } catch (kotlin.l.b.a.b.h.k e2) {
                    e2.TDK = this;
                    AppMethodBeat.o(58380);
                    throw e2;
                } catch (IOException e3) {
                    kotlin.l.b.a.b.h.k kVar = new kotlin.l.b.a.b.h.k(e3.getMessage());
                    kVar.TDK = this;
                    AppMethodBeat.o(58380);
                    throw kVar;
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.TwN = Collections.unmodifiableList(this.TwN);
                    }
                    try {
                        f2.flush();
                        this.TwK = hJo.hJs();
                    } catch (IOException e4) {
                        this.TwK = hJo.hJs();
                    } catch (Throwable th2) {
                        this.TwK = hJo.hJs();
                        AppMethodBeat.o(58380);
                        throw th2;
                    }
                    Gw();
                    AppMethodBeat.o(58380);
                    throw th;
                }
            }
            if (z2 & true) {
                this.TwN = Collections.unmodifiableList(this.TwN);
            }
            try {
                f2.flush();
                this.TwK = hJo.hJs();
            } catch (IOException e5) {
                this.TwK = hJo.hJs();
            } catch (Throwable th3) {
                this.TwK = hJo.hJs();
                AppMethodBeat.o(58380);
                throw th3;
            }
            Gw();
            AppMethodBeat.o(58380);
        }

        static {
            AppMethodBeat.i(58390);
            C2299a aVar = new C2299a();
            TwJ = aVar;
            aVar.hEu();
            AppMethodBeat.o(58390);
        }

        @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
        public final kotlin.l.b.a.b.h.s<C2299a> hEs() {
            return TwL;
        }

        /* renamed from: kotlin.l.b.a.b.e.a$a$a  reason: collision with other inner class name */
        public static final class C2301a extends kotlin.l.b.a.b.h.i implements c {
            public static kotlin.l.b.a.b.h.s<C2301a> TwL = new kotlin.l.b.a.b.h.b<C2301a>() {
                /* class kotlin.l.b.a.b.e.a.C2299a.C2301a.AnonymousClass1 */

                @Override // kotlin.l.b.a.b.h.s
                public final /* synthetic */ Object a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                    AppMethodBeat.i(58303);
                    C2301a aVar = new C2301a(eVar, gVar, (byte) 0);
                    AppMethodBeat.o(58303);
                    return aVar;
                }
            };
            private static final C2301a TwO;
            private final kotlin.l.b.a.b.h.d TwK;
            public int TwP;
            public b TwQ;
            private int bOT;
            private byte bPe;
            private int bVY;

            /* synthetic */ C2301a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar, byte b2) {
                this(eVar, gVar);
            }

            /* synthetic */ C2301a(i.a aVar, byte b2) {
                this(aVar);
            }

            private C2301a(i.a aVar) {
                super((byte) 0);
                this.bPe = -1;
                this.bVY = -1;
                this.TwK = aVar.TwK;
            }

            private C2301a() {
                this.bPe = -1;
                this.bVY = -1;
                this.TwK = kotlin.l.b.a.b.h.d.TDp;
            }

            public static C2301a hEz() {
                return TwO;
            }

            private C2301a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                b.C2303a aVar;
                AppMethodBeat.i(58355);
                this.bPe = -1;
                this.bVY = -1;
                hEu();
                d.b hJo = kotlin.l.b.a.b.h.d.hJo();
                kotlin.l.b.a.b.h.f f2 = kotlin.l.b.a.b.h.f.f(hJo, 1);
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
                                this.TwP = eVar.zi();
                                break;
                            case 18:
                                if ((this.bOT & 2) == 2) {
                                    aVar = b.b(this.TwQ);
                                } else {
                                    aVar = null;
                                }
                                this.TwQ = (b) eVar.a(b.TwL, gVar);
                                if (aVar != null) {
                                    aVar.e(this.TwQ);
                                    this.TwQ = aVar.hER();
                                }
                                this.bOT |= 2;
                                break;
                            default:
                                if (a(eVar, f2, gVar, yT)) {
                                    break;
                                } else {
                                    z = true;
                                    break;
                                }
                        }
                    } catch (kotlin.l.b.a.b.h.k e2) {
                        e2.TDK = this;
                        AppMethodBeat.o(58355);
                        throw e2;
                    } catch (IOException e3) {
                        kotlin.l.b.a.b.h.k kVar = new kotlin.l.b.a.b.h.k(e3.getMessage());
                        kVar.TDK = this;
                        AppMethodBeat.o(58355);
                        throw kVar;
                    } catch (Throwable th) {
                        try {
                            f2.flush();
                            this.TwK = hJo.hJs();
                        } catch (IOException e4) {
                            this.TwK = hJo.hJs();
                        } catch (Throwable th2) {
                            this.TwK = hJo.hJs();
                            AppMethodBeat.o(58355);
                            throw th2;
                        }
                        Gw();
                        AppMethodBeat.o(58355);
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
                    AppMethodBeat.o(58355);
                    throw th3;
                }
                Gw();
                AppMethodBeat.o(58355);
            }

            static {
                AppMethodBeat.i(58362);
                C2301a aVar = new C2301a();
                TwO = aVar;
                aVar.hEu();
                AppMethodBeat.o(58362);
            }

            @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
            public final kotlin.l.b.a.b.h.s<C2301a> hEs() {
                return TwL;
            }

            /* renamed from: kotlin.l.b.a.b.e.a$a$a$b */
            public static final class b extends kotlin.l.b.a.b.h.i implements b {
                public static kotlin.l.b.a.b.h.s<b> TwL = new kotlin.l.b.a.b.h.b<b>() {
                    /* class kotlin.l.b.a.b.e.a.C2299a.C2301a.b.AnonymousClass1 */

                    @Override // kotlin.l.b.a.b.h.s
                    public final /* synthetic */ Object a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                        AppMethodBeat.i(58321);
                        b bVar = new b(eVar, gVar, (byte) 0);
                        AppMethodBeat.o(58321);
                        return bVar;
                    }
                };
                private static final b TwR;
                private final kotlin.l.b.a.b.h.d TwK;
                public EnumC2304b TwS;
                public long TwT;
                public float TwU;
                public int TwV;
                public int TwW;
                public int TwX;
                public C2299a TwY;
                public List<b> TwZ;
                public int Txa;
                public int Txb;
                private int bOT;
                private byte bPe;
                public double bSh;
                private int bVY;

                /* synthetic */ b(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar, byte b2) {
                    this(eVar, gVar);
                }

                /* synthetic */ b(i.a aVar, byte b2) {
                    this(aVar);
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

                public static b hEI() {
                    return TwR;
                }

                /* JADX DEBUG: Multi-variable search result rejected for r0v22, resolved type: java.util.List<kotlin.l.b.a.b.e.a$a$a$b> */
                /* JADX WARN: Multi-variable type inference failed */
                private b(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                    b bVar;
                    AppMethodBeat.i(58345);
                    this.bPe = -1;
                    this.bVY = -1;
                    hEu();
                    d.b hJo = kotlin.l.b.a.b.h.d.hJo();
                    kotlin.l.b.a.b.h.f f2 = kotlin.l.b.a.b.h.f.f(hJo, 1);
                    boolean z = false;
                    boolean z2 = false;
                    while (!z) {
                        try {
                            int yT = eVar.yT();
                            switch (yT) {
                                case 0:
                                    z = true;
                                    break;
                                case 8:
                                    int zi = eVar.zi();
                                    EnumC2304b atZ = EnumC2304b.atZ(zi);
                                    if (atZ != null) {
                                        this.bOT |= 1;
                                        this.TwS = atZ;
                                        break;
                                    } else {
                                        f2.hc(yT);
                                        f2.hc(zi);
                                        break;
                                    }
                                case 16:
                                    this.bOT |= 2;
                                    this.TwT = kotlin.l.b.a.b.h.e.Ph(eVar.zl());
                                    break;
                                case 29:
                                    this.bOT |= 4;
                                    this.TwU = Float.intBitsToFloat(eVar.zm());
                                    break;
                                case 33:
                                    this.bOT |= 8;
                                    this.bSh = Double.longBitsToDouble(eVar.zn());
                                    break;
                                case 40:
                                    this.bOT |= 16;
                                    this.TwV = eVar.zi();
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                                    this.bOT |= 32;
                                    this.TwW = eVar.zi();
                                    break;
                                case 56:
                                    this.bOT |= 64;
                                    this.TwX = eVar.zi();
                                    break;
                                case 66:
                                    if ((this.bOT & 128) == 128) {
                                        bVar = this.TwY.hEv();
                                    } else {
                                        bVar = null;
                                    }
                                    this.TwY = (C2299a) eVar.a(C2299a.TwL, gVar);
                                    if (bVar != null) {
                                        bVar.e(this.TwY);
                                        this.TwY = bVar.hEV();
                                    }
                                    this.bOT |= 128;
                                    break;
                                case 74:
                                    if (!(z2 & true)) {
                                        this.TwZ = new ArrayList();
                                        z2 |= true;
                                    }
                                    this.TwZ.add(eVar.a(TwL, gVar));
                                    break;
                                case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL:
                                    this.bOT |= 512;
                                    this.Txb = eVar.zi();
                                    break;
                                case TPCodecParamers.TP_PROFILE_H264_EXTENDED:
                                    this.bOT |= 256;
                                    this.Txa = eVar.zi();
                                    break;
                                default:
                                    if (a(eVar, f2, gVar, yT)) {
                                        break;
                                    } else {
                                        z = true;
                                        break;
                                    }
                            }
                        } catch (kotlin.l.b.a.b.h.k e2) {
                            e2.TDK = this;
                            AppMethodBeat.o(58345);
                            throw e2;
                        } catch (IOException e3) {
                            kotlin.l.b.a.b.h.k kVar = new kotlin.l.b.a.b.h.k(e3.getMessage());
                            kVar.TDK = this;
                            AppMethodBeat.o(58345);
                            throw kVar;
                        } catch (Throwable th) {
                            if (z2 & true) {
                                this.TwZ = Collections.unmodifiableList(this.TwZ);
                            }
                            try {
                                f2.flush();
                                this.TwK = hJo.hJs();
                            } catch (IOException e4) {
                                this.TwK = hJo.hJs();
                            } catch (Throwable th2) {
                                this.TwK = hJo.hJs();
                                AppMethodBeat.o(58345);
                                throw th2;
                            }
                            Gw();
                            AppMethodBeat.o(58345);
                            throw th;
                        }
                    }
                    if (z2 & true) {
                        this.TwZ = Collections.unmodifiableList(this.TwZ);
                    }
                    try {
                        f2.flush();
                        this.TwK = hJo.hJs();
                    } catch (IOException e5) {
                        this.TwK = hJo.hJs();
                    } catch (Throwable th3) {
                        this.TwK = hJo.hJs();
                        AppMethodBeat.o(58345);
                        throw th3;
                    }
                    Gw();
                    AppMethodBeat.o(58345);
                }

                static {
                    AppMethodBeat.i(58354);
                    b bVar = new b();
                    TwR = bVar;
                    bVar.hEu();
                    AppMethodBeat.o(58354);
                }

                @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
                public final kotlin.l.b.a.b.h.s<b> hEs() {
                    return TwL;
                }

                /* renamed from: kotlin.l.b.a.b.e.a$a$a$b$b  reason: collision with other inner class name */
                public enum EnumC2304b implements j.a {
                    BYTE(0),
                    CHAR(1),
                    SHORT(2),
                    INT(3),
                    LONG(4),
                    FLOAT(5),
                    DOUBLE(6),
                    BOOLEAN(7),
                    STRING(8),
                    CLASS(9),
                    ENUM(10),
                    ANNOTATION(11),
                    ARRAY(12);
                    
                    private static j.b<EnumC2304b> Txp = new j.b<EnumC2304b>() {
                        /* class kotlin.l.b.a.b.e.a.C2299a.C2301a.b.EnumC2304b.AnonymousClass1 */

                        /* Return type fixed from 'kotlin.l.b.a.b.h.j$a' to match base method */
                        @Override // kotlin.l.b.a.b.h.j.b
                        public final /* synthetic */ EnumC2304b aua(int i2) {
                            AppMethodBeat.i(58341);
                            EnumC2304b atZ = EnumC2304b.atZ(i2);
                            AppMethodBeat.o(58341);
                            return atZ;
                        }
                    };
                    final int value;

                    public static EnumC2304b valueOf(String str) {
                        AppMethodBeat.i(58343);
                        EnumC2304b bVar = (EnumC2304b) Enum.valueOf(EnumC2304b.class, str);
                        AppMethodBeat.o(58343);
                        return bVar;
                    }

                    static {
                        AppMethodBeat.i(58344);
                        AppMethodBeat.o(58344);
                    }

                    @Override // kotlin.l.b.a.b.h.j.a
                    public final int getNumber() {
                        return this.value;
                    }

                    public static EnumC2304b atZ(int i2) {
                        switch (i2) {
                            case 0:
                                return BYTE;
                            case 1:
                                return CHAR;
                            case 2:
                                return SHORT;
                            case 3:
                                return INT;
                            case 4:
                                return LONG;
                            case 5:
                                return FLOAT;
                            case 6:
                                return DOUBLE;
                            case 7:
                                return BOOLEAN;
                            case 8:
                                return STRING;
                            case 9:
                                return CLASS;
                            case 10:
                                return ENUM;
                            case 11:
                                return ANNOTATION;
                            case 12:
                                return ARRAY;
                            default:
                                return null;
                        }
                    }

                    private EnumC2304b(int i2) {
                        this.value = i2;
                    }
                }

                public final boolean Cm() {
                    return (this.bOT & 1) == 1;
                }

                public final boolean hEJ() {
                    return (this.bOT & 2) == 2;
                }

                public final boolean hEK() {
                    return (this.bOT & 4) == 4;
                }

                public final boolean Fe() {
                    return (this.bOT & 8) == 8;
                }

                public final boolean Ff() {
                    return (this.bOT & 16) == 16;
                }

                public final boolean hEL() {
                    return (this.bOT & 32) == 32;
                }

                public final boolean hEM() {
                    return (this.bOT & 64) == 64;
                }

                public final boolean hEN() {
                    return (this.bOT & 128) == 128;
                }

                public final b atT(int i2) {
                    AppMethodBeat.i(58346);
                    b bVar = this.TwZ.get(i2);
                    AppMethodBeat.o(58346);
                    return bVar;
                }

                public final boolean hEO() {
                    return (this.bOT & 256) == 256;
                }

                public final boolean hEP() {
                    return (this.bOT & 512) == 512;
                }

                private void hEu() {
                    AppMethodBeat.i(58347);
                    this.TwS = EnumC2304b.BYTE;
                    this.TwT = 0;
                    this.TwU = 0.0f;
                    this.bSh = 0.0d;
                    this.TwV = 0;
                    this.TwW = 0;
                    this.TwX = 0;
                    this.TwY = C2299a.hEr();
                    this.TwZ = Collections.emptyList();
                    this.Txa = 0;
                    this.Txb = 0;
                    AppMethodBeat.o(58347);
                }

                @Override // kotlin.l.b.a.b.h.r
                public final boolean isInitialized() {
                    AppMethodBeat.i(58348);
                    byte b2 = this.bPe;
                    if (b2 == 1) {
                        AppMethodBeat.o(58348);
                        return true;
                    } else if (b2 == 0) {
                        AppMethodBeat.o(58348);
                        return false;
                    } else if (!hEN() || this.TwY.isInitialized()) {
                        for (int i2 = 0; i2 < this.TwZ.size(); i2++) {
                            if (!atT(i2).isInitialized()) {
                                this.bPe = 0;
                                AppMethodBeat.o(58348);
                                return false;
                            }
                        }
                        this.bPe = 1;
                        AppMethodBeat.o(58348);
                        return true;
                    } else {
                        this.bPe = 0;
                        AppMethodBeat.o(58348);
                        return false;
                    }
                }

                @Override // kotlin.l.b.a.b.h.q
                public final void a(kotlin.l.b.a.b.h.f fVar) {
                    AppMethodBeat.i(58349);
                    yC();
                    if ((this.bOT & 1) == 1) {
                        fVar.nb(1, this.TwS.value);
                    }
                    if ((this.bOT & 2) == 2) {
                        long j2 = this.TwT;
                        fVar.br(2, 0);
                        fVar.aw(j2);
                    }
                    if ((this.bOT & 4) == 4) {
                        float f2 = this.TwU;
                        fVar.br(3, 5);
                        fVar.ad(f2);
                    }
                    if ((this.bOT & 8) == 8) {
                        double d2 = this.bSh;
                        fVar.br(4, 1);
                        fVar.f(d2);
                    }
                    if ((this.bOT & 16) == 16) {
                        fVar.bs(5, this.TwV);
                    }
                    if ((this.bOT & 32) == 32) {
                        fVar.bs(6, this.TwW);
                    }
                    if ((this.bOT & 64) == 64) {
                        fVar.bs(7, this.TwX);
                    }
                    if ((this.bOT & 128) == 128) {
                        fVar.a(8, this.TwY);
                    }
                    for (int i2 = 0; i2 < this.TwZ.size(); i2++) {
                        fVar.a(9, this.TwZ.get(i2));
                    }
                    if ((this.bOT & 512) == 512) {
                        fVar.bs(10, this.Txb);
                    }
                    if ((this.bOT & 256) == 256) {
                        fVar.bs(11, this.Txa);
                    }
                    fVar.e(this.TwK);
                    AppMethodBeat.o(58349);
                }

                @Override // kotlin.l.b.a.b.h.q
                public final int yC() {
                    int i2;
                    int i3;
                    int i4 = 0;
                    AppMethodBeat.i(58350);
                    int i5 = this.bVY;
                    if (i5 != -1) {
                        AppMethodBeat.o(58350);
                        return i5;
                    }
                    if ((this.bOT & 1) == 1) {
                        i2 = kotlin.l.b.a.b.h.f.bv(1, this.TwS.value) + 0;
                    } else {
                        i2 = 0;
                    }
                    if ((this.bOT & 2) == 2) {
                        i2 += kotlin.l.b.a.b.h.f.Pi(this.TwT);
                    }
                    if ((this.bOT & 4) == 4) {
                        i2 += kotlin.l.b.a.b.h.f.fS(3) + 4;
                    }
                    if ((this.bOT & 8) == 8) {
                        i2 += kotlin.l.b.a.b.h.f.fS(4) + 8;
                    }
                    if ((this.bOT & 16) == 16) {
                        i2 += kotlin.l.b.a.b.h.f.bu(5, this.TwV);
                    }
                    if ((this.bOT & 32) == 32) {
                        i2 += kotlin.l.b.a.b.h.f.bu(6, this.TwW);
                    }
                    if ((this.bOT & 64) == 64) {
                        i2 += kotlin.l.b.a.b.h.f.bu(7, this.TwX);
                    }
                    if ((this.bOT & 128) == 128) {
                        i2 += kotlin.l.b.a.b.h.f.c(8, this.TwY);
                    }
                    while (true) {
                        i3 = i2;
                        if (i4 >= this.TwZ.size()) {
                            break;
                        }
                        i2 = kotlin.l.b.a.b.h.f.c(9, this.TwZ.get(i4)) + i3;
                        i4++;
                    }
                    if ((this.bOT & 512) == 512) {
                        i3 += kotlin.l.b.a.b.h.f.bu(10, this.Txb);
                    }
                    if ((this.bOT & 256) == 256) {
                        i3 += kotlin.l.b.a.b.h.f.bu(11, this.Txa);
                    }
                    int size = this.TwK.size() + i3;
                    this.bVY = size;
                    AppMethodBeat.o(58350);
                    return size;
                }

                /* renamed from: kotlin.l.b.a.b.e.a$a$a$b$a  reason: collision with other inner class name */
                public static final class C2303a extends i.a<b, C2303a> implements b {
                    private EnumC2304b TwS = EnumC2304b.BYTE;
                    private long TwT;
                    private float TwU;
                    private int TwV;
                    private int TwW;
                    private int TwX;
                    private C2299a TwY = C2299a.hEr();
                    private List<b> TwZ = Collections.emptyList();
                    private int Txa;
                    private int Txb;
                    private int bOT;
                    private double bSh;

                    /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.l.b.a.b.h.i] */
                    @Override // kotlin.l.b.a.b.h.i.a
                    public final /* synthetic */ C2303a a(b bVar) {
                        AppMethodBeat.i(58332);
                        C2303a e2 = e(bVar);
                        AppMethodBeat.o(58332);
                        return e2;
                    }

                    @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
                    public final /* synthetic */ a.AbstractC2337a c(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                        AppMethodBeat.i(58334);
                        C2303a e2 = e(eVar, gVar);
                        AppMethodBeat.o(58334);
                        return e2;
                    }

                    @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a, java.lang.Object
                    public final /* synthetic */ Object clone() {
                        AppMethodBeat.i(58339);
                        C2303a hEQ = hEQ();
                        AppMethodBeat.o(58339);
                        return hEQ;
                    }

                    @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
                    public final /* synthetic */ q.a d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                        AppMethodBeat.i(58336);
                        C2303a e2 = e(eVar, gVar);
                        AppMethodBeat.o(58336);
                        return e2;
                    }

                    /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
                    @Override // kotlin.l.b.a.b.h.i.a
                    public final /* synthetic */ C2303a hEE() {
                        AppMethodBeat.i(58333);
                        C2303a hEQ = hEQ();
                        AppMethodBeat.o(58333);
                        return hEQ;
                    }

                    @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a
                    public final /* synthetic */ a.AbstractC2337a hEF() {
                        AppMethodBeat.i(58335);
                        C2303a hEQ = hEQ();
                        AppMethodBeat.o(58335);
                        return hEQ;
                    }

                    private C2303a() {
                        AppMethodBeat.i(58322);
                        AppMethodBeat.o(58322);
                    }

                    public final b hER() {
                        int i2 = 1;
                        AppMethodBeat.i(58324);
                        b bVar = new b(this, (byte) 0);
                        int i3 = this.bOT;
                        if ((i3 & 1) != 1) {
                            i2 = 0;
                        }
                        bVar.TwS = this.TwS;
                        if ((i3 & 2) == 2) {
                            i2 |= 2;
                        }
                        bVar.TwT = this.TwT;
                        if ((i3 & 4) == 4) {
                            i2 |= 4;
                        }
                        bVar.TwU = this.TwU;
                        if ((i3 & 8) == 8) {
                            i2 |= 8;
                        }
                        bVar.bSh = this.bSh;
                        if ((i3 & 16) == 16) {
                            i2 |= 16;
                        }
                        bVar.TwV = this.TwV;
                        if ((i3 & 32) == 32) {
                            i2 |= 32;
                        }
                        bVar.TwW = this.TwW;
                        if ((i3 & 64) == 64) {
                            i2 |= 64;
                        }
                        bVar.TwX = this.TwX;
                        if ((i3 & 128) == 128) {
                            i2 |= 128;
                        }
                        bVar.TwY = this.TwY;
                        if ((this.bOT & 256) == 256) {
                            this.TwZ = Collections.unmodifiableList(this.TwZ);
                            this.bOT &= -257;
                        }
                        bVar.TwZ = this.TwZ;
                        if ((i3 & 512) == 512) {
                            i2 |= 256;
                        }
                        bVar.Txa = this.Txa;
                        if ((i3 & 1024) == 1024) {
                            i2 |= 512;
                        }
                        bVar.Txb = this.Txb;
                        bVar.bOT = i2;
                        AppMethodBeat.o(58324);
                        return bVar;
                    }

                    public final C2303a e(b bVar) {
                        AppMethodBeat.i(58325);
                        if (bVar == b.hEI()) {
                            AppMethodBeat.o(58325);
                        } else {
                            if (bVar.Cm()) {
                                a(bVar.TwS);
                            }
                            if (bVar.hEJ()) {
                                Pg(bVar.TwT);
                            }
                            if (bVar.hEK()) {
                                cT(bVar.TwU);
                            }
                            if (bVar.Fe()) {
                                N(bVar.bSh);
                            }
                            if (bVar.Ff()) {
                                atU(bVar.TwV);
                            }
                            if (bVar.hEL()) {
                                atV(bVar.TwW);
                            }
                            if (bVar.hEM()) {
                                atW(bVar.TwX);
                            }
                            if (bVar.hEN()) {
                                d(bVar.TwY);
                            }
                            if (!bVar.TwZ.isEmpty()) {
                                if (this.TwZ.isEmpty()) {
                                    this.TwZ = bVar.TwZ;
                                    this.bOT &= -257;
                                } else {
                                    hES();
                                    this.TwZ.addAll(bVar.TwZ);
                                }
                            }
                            if (bVar.hEO()) {
                                atX(bVar.Txa);
                            }
                            if (bVar.hEP()) {
                                atY(bVar.Txb);
                            }
                            this.TwK = this.TwK.a(bVar.TwK);
                            AppMethodBeat.o(58325);
                        }
                        return this;
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    private kotlin.l.b.a.b.e.a.C2299a.C2301a.b.C2303a e(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                        /*
                            r4 = this;
                            r3 = 58327(0xe3d7, float:8.1734E-41)
                            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                            r2 = 0
                            kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.a$a$a$b> r0 = kotlin.l.b.a.b.e.a.C2299a.C2301a.b.TwL     // Catch:{ k -> 0x0016 }
                            java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                            kotlin.l.b.a.b.e.a$a$a$b r0 = (kotlin.l.b.a.b.e.a.C2299a.C2301a.b) r0     // Catch:{ k -> 0x0016 }
                            r4.e(r0)
                            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                            return r4
                        L_0x0016:
                            r0 = move-exception
                            r1 = r0
                            kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                            kotlin.l.b.a.b.e.a$a$a$b r0 = (kotlin.l.b.a.b.e.a.C2299a.C2301a.b) r0     // Catch:{ all -> 0x002e }
                            r2 = 58327(0xe3d7, float:8.1734E-41)
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
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.C2299a.C2301a.b.C2303a.e(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.a$a$a$b$a");
                    }

                    private C2303a a(EnumC2304b bVar) {
                        AppMethodBeat.i(58328);
                        if (bVar == null) {
                            NullPointerException nullPointerException = new NullPointerException();
                            AppMethodBeat.o(58328);
                            throw nullPointerException;
                        }
                        this.bOT |= 1;
                        this.TwS = bVar;
                        AppMethodBeat.o(58328);
                        return this;
                    }

                    private C2303a Pg(long j2) {
                        this.bOT |= 2;
                        this.TwT = j2;
                        return this;
                    }

                    private C2303a cT(float f2) {
                        this.bOT |= 4;
                        this.TwU = f2;
                        return this;
                    }

                    private C2303a N(double d2) {
                        this.bOT |= 8;
                        this.bSh = d2;
                        return this;
                    }

                    private C2303a atU(int i2) {
                        this.bOT |= 16;
                        this.TwV = i2;
                        return this;
                    }

                    private C2303a atV(int i2) {
                        this.bOT |= 32;
                        this.TwW = i2;
                        return this;
                    }

                    private C2303a atW(int i2) {
                        this.bOT |= 64;
                        this.TwX = i2;
                        return this;
                    }

                    private C2303a d(C2299a aVar) {
                        AppMethodBeat.i(58329);
                        if ((this.bOT & 128) != 128 || this.TwY == C2299a.hEr()) {
                            this.TwY = aVar;
                        } else {
                            this.TwY = C2299a.a(this.TwY).e(aVar).hEV();
                        }
                        this.bOT |= 128;
                        AppMethodBeat.o(58329);
                        return this;
                    }

                    private void hES() {
                        AppMethodBeat.i(58330);
                        if ((this.bOT & 256) != 256) {
                            this.TwZ = new ArrayList(this.TwZ);
                            this.bOT |= 256;
                        }
                        AppMethodBeat.o(58330);
                    }

                    private C2303a atX(int i2) {
                        this.bOT |= 512;
                        this.Txa = i2;
                        return this;
                    }

                    private C2303a atY(int i2) {
                        this.bOT |= 1024;
                        this.Txb = i2;
                        return this;
                    }

                    private C2303a hEQ() {
                        AppMethodBeat.i(58323);
                        C2303a e2 = new C2303a().e(hER());
                        AppMethodBeat.o(58323);
                        return e2;
                    }

                    @Override // kotlin.l.b.a.b.h.r
                    public final boolean isInitialized() {
                        AppMethodBeat.i(58326);
                        if (!((this.bOT & 128) == 128) || this.TwY.isInitialized()) {
                            for (int i2 = 0; i2 < this.TwZ.size(); i2++) {
                                if (!this.TwZ.get(i2).isInitialized()) {
                                    AppMethodBeat.o(58326);
                                    return false;
                                }
                            }
                            AppMethodBeat.o(58326);
                            return true;
                        }
                        AppMethodBeat.o(58326);
                        return false;
                    }

                    /* Return type fixed from 'kotlin.l.b.a.b.h.i' to match base method */
                    @Override // kotlin.l.b.a.b.h.i.a
                    public final /* synthetic */ b hED() {
                        AppMethodBeat.i(58331);
                        b hEI = b.hEI();
                        AppMethodBeat.o(58331);
                        return hEI;
                    }

                    @Override // kotlin.l.b.a.b.h.q.a
                    public final /* synthetic */ kotlin.l.b.a.b.h.q hEG() {
                        AppMethodBeat.i(58337);
                        b hER = hER();
                        if (!hER.isInitialized()) {
                            kotlin.l.b.a.b.h.w wVar = new kotlin.l.b.a.b.h.w();
                            AppMethodBeat.o(58337);
                            throw wVar;
                        }
                        AppMethodBeat.o(58337);
                        return hER;
                    }

                    @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
                    public final /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                        AppMethodBeat.i(58338);
                        b hEI = b.hEI();
                        AppMethodBeat.o(58338);
                        return hEI;
                    }

                    static /* synthetic */ C2303a hET() {
                        AppMethodBeat.i(58340);
                        C2303a aVar = new C2303a();
                        AppMethodBeat.o(58340);
                        return aVar;
                    }
                }

                public static C2303a b(b bVar) {
                    AppMethodBeat.i(58351);
                    C2303a e2 = C2303a.hET().e(bVar);
                    AppMethodBeat.o(58351);
                    return e2;
                }

                @Override // kotlin.l.b.a.b.h.q
                public final /* synthetic */ q.a hEw() {
                    AppMethodBeat.i(58352);
                    C2303a e2 = C2303a.hET().e(this);
                    AppMethodBeat.o(58352);
                    return e2;
                }

                @Override // kotlin.l.b.a.b.h.q
                public final /* synthetic */ q.a hEx() {
                    AppMethodBeat.i(58353);
                    C2303a hET = C2303a.hET();
                    AppMethodBeat.o(58353);
                    return hET;
                }

                @Override // kotlin.l.b.a.b.h.r
                public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                    return TwR;
                }
            }

            public final boolean hEA() {
                return (this.bOT & 1) == 1;
            }

            public final boolean hasValue() {
                return (this.bOT & 2) == 2;
            }

            private void hEu() {
                AppMethodBeat.i(58356);
                this.TwP = 0;
                this.TwQ = b.hEI();
                AppMethodBeat.o(58356);
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                AppMethodBeat.i(58357);
                byte b2 = this.bPe;
                if (b2 == 1) {
                    AppMethodBeat.o(58357);
                    return true;
                } else if (b2 == 0) {
                    AppMethodBeat.o(58357);
                    return false;
                } else if (!hEA()) {
                    this.bPe = 0;
                    AppMethodBeat.o(58357);
                    return false;
                } else if (!hasValue()) {
                    this.bPe = 0;
                    AppMethodBeat.o(58357);
                    return false;
                } else if (!this.TwQ.isInitialized()) {
                    this.bPe = 0;
                    AppMethodBeat.o(58357);
                    return false;
                } else {
                    this.bPe = 1;
                    AppMethodBeat.o(58357);
                    return true;
                }
            }

            @Override // kotlin.l.b.a.b.h.q
            public final void a(kotlin.l.b.a.b.h.f fVar) {
                AppMethodBeat.i(58358);
                yC();
                if ((this.bOT & 1) == 1) {
                    fVar.bs(1, this.TwP);
                }
                if ((this.bOT & 2) == 2) {
                    fVar.a(2, this.TwQ);
                }
                fVar.e(this.TwK);
                AppMethodBeat.o(58358);
            }

            @Override // kotlin.l.b.a.b.h.q
            public final int yC() {
                AppMethodBeat.i(58359);
                int i2 = this.bVY;
                if (i2 != -1) {
                    AppMethodBeat.o(58359);
                    return i2;
                }
                int i3 = 0;
                if ((this.bOT & 1) == 1) {
                    i3 = kotlin.l.b.a.b.h.f.bu(1, this.TwP) + 0;
                }
                if ((this.bOT & 2) == 2) {
                    i3 += kotlin.l.b.a.b.h.f.c(2, this.TwQ);
                }
                int size = i3 + this.TwK.size();
                this.bVY = size;
                AppMethodBeat.o(58359);
                return size;
            }

            /* renamed from: kotlin.l.b.a.b.e.a$a$a$a  reason: collision with other inner class name */
            public static final class C2302a extends i.a<C2301a, C2302a> implements c {
                private int TwP;
                private b TwQ = b.hEI();
                private int bOT;

                /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.l.b.a.b.h.i] */
                @Override // kotlin.l.b.a.b.h.i.a
                public final /* synthetic */ C2302a a(C2301a aVar) {
                    AppMethodBeat.i(58312);
                    C2302a b2 = b(aVar);
                    AppMethodBeat.o(58312);
                    return b2;
                }

                @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
                public final /* synthetic */ a.AbstractC2337a c(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                    AppMethodBeat.i(58314);
                    C2302a b2 = b(eVar, gVar);
                    AppMethodBeat.o(58314);
                    return b2;
                }

                @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a, java.lang.Object
                public final /* synthetic */ Object clone() {
                    AppMethodBeat.i(58319);
                    C2302a hEB = hEB();
                    AppMethodBeat.o(58319);
                    return hEB;
                }

                @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
                public final /* synthetic */ q.a d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                    AppMethodBeat.i(58316);
                    C2302a b2 = b(eVar, gVar);
                    AppMethodBeat.o(58316);
                    return b2;
                }

                /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
                @Override // kotlin.l.b.a.b.h.i.a
                public final /* synthetic */ C2302a hEE() {
                    AppMethodBeat.i(58313);
                    C2302a hEB = hEB();
                    AppMethodBeat.o(58313);
                    return hEB;
                }

                @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a
                public final /* synthetic */ a.AbstractC2337a hEF() {
                    AppMethodBeat.i(58315);
                    C2302a hEB = hEB();
                    AppMethodBeat.o(58315);
                    return hEB;
                }

                private C2302a() {
                    AppMethodBeat.i(58304);
                    AppMethodBeat.o(58304);
                }

                private C2301a hEC() {
                    int i2 = 1;
                    AppMethodBeat.i(58306);
                    C2301a aVar = new C2301a(this, (byte) 0);
                    int i3 = this.bOT;
                    if ((i3 & 1) != 1) {
                        i2 = 0;
                    }
                    aVar.TwP = this.TwP;
                    if ((i3 & 2) == 2) {
                        i2 |= 2;
                    }
                    aVar.TwQ = this.TwQ;
                    aVar.bOT = i2;
                    AppMethodBeat.o(58306);
                    return aVar;
                }

                public final C2302a b(C2301a aVar) {
                    AppMethodBeat.i(58307);
                    if (aVar == C2301a.hEz()) {
                        AppMethodBeat.o(58307);
                    } else {
                        if (aVar.hEA()) {
                            atS(aVar.TwP);
                        }
                        if (aVar.hasValue()) {
                            a(aVar.TwQ);
                        }
                        this.TwK = this.TwK.a(aVar.TwK);
                        AppMethodBeat.o(58307);
                    }
                    return this;
                }

                /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                private kotlin.l.b.a.b.e.a.C2299a.C2301a.C2302a b(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                    /*
                        r4 = this;
                        r3 = 58309(0xe3c5, float:8.1708E-41)
                        com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                        r2 = 0
                        kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.a$a$a> r0 = kotlin.l.b.a.b.e.a.C2299a.C2301a.TwL     // Catch:{ k -> 0x0016 }
                        java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                        kotlin.l.b.a.b.e.a$a$a r0 = (kotlin.l.b.a.b.e.a.C2299a.C2301a) r0     // Catch:{ k -> 0x0016 }
                        r4.b(r0)
                        com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                        return r4
                    L_0x0016:
                        r0 = move-exception
                        r1 = r0
                        kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                        kotlin.l.b.a.b.e.a$a$a r0 = (kotlin.l.b.a.b.e.a.C2299a.C2301a) r0     // Catch:{ all -> 0x002e }
                        r2 = 58309(0xe3c5, float:8.1708E-41)
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
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.C2299a.C2301a.C2302a.b(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.a$a$a$a");
                }

                private C2302a atS(int i2) {
                    this.bOT |= 1;
                    this.TwP = i2;
                    return this;
                }

                private C2302a a(b bVar) {
                    AppMethodBeat.i(58310);
                    if ((this.bOT & 2) != 2 || this.TwQ == b.hEI()) {
                        this.TwQ = bVar;
                    } else {
                        this.TwQ = b.b(this.TwQ).e(bVar).hER();
                    }
                    this.bOT |= 2;
                    AppMethodBeat.o(58310);
                    return this;
                }

                private C2302a hEB() {
                    AppMethodBeat.i(58305);
                    C2302a b2 = new C2302a().b(hEC());
                    AppMethodBeat.o(58305);
                    return b2;
                }

                @Override // kotlin.l.b.a.b.h.r
                public final boolean isInitialized() {
                    boolean z;
                    boolean z2;
                    AppMethodBeat.i(58308);
                    if ((this.bOT & 1) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        AppMethodBeat.o(58308);
                        return false;
                    }
                    if ((this.bOT & 2) == 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        AppMethodBeat.o(58308);
                        return false;
                    } else if (!this.TwQ.isInitialized()) {
                        AppMethodBeat.o(58308);
                        return false;
                    } else {
                        AppMethodBeat.o(58308);
                        return true;
                    }
                }

                /* Return type fixed from 'kotlin.l.b.a.b.h.i' to match base method */
                @Override // kotlin.l.b.a.b.h.i.a
                public final /* synthetic */ C2301a hED() {
                    AppMethodBeat.i(58311);
                    C2301a hEz = C2301a.hEz();
                    AppMethodBeat.o(58311);
                    return hEz;
                }

                @Override // kotlin.l.b.a.b.h.q.a
                public final /* synthetic */ kotlin.l.b.a.b.h.q hEG() {
                    AppMethodBeat.i(58317);
                    C2301a hEC = hEC();
                    if (!hEC.isInitialized()) {
                        kotlin.l.b.a.b.h.w wVar = new kotlin.l.b.a.b.h.w();
                        AppMethodBeat.o(58317);
                        throw wVar;
                    }
                    AppMethodBeat.o(58317);
                    return hEC;
                }

                @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
                public final /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                    AppMethodBeat.i(58318);
                    C2301a hEz = C2301a.hEz();
                    AppMethodBeat.o(58318);
                    return hEz;
                }

                static /* synthetic */ C2302a hEH() {
                    AppMethodBeat.i(58320);
                    C2302a aVar = new C2302a();
                    AppMethodBeat.o(58320);
                    return aVar;
                }
            }

            @Override // kotlin.l.b.a.b.h.q
            public final /* synthetic */ q.a hEw() {
                AppMethodBeat.i(58360);
                C2302a b2 = C2302a.hEH().b(this);
                AppMethodBeat.o(58360);
                return b2;
            }

            @Override // kotlin.l.b.a.b.h.q
            public final /* synthetic */ q.a hEx() {
                AppMethodBeat.i(58361);
                C2302a hEH = C2302a.hEH();
                AppMethodBeat.o(58361);
                return hEH;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                return TwO;
            }
        }

        public final boolean hEt() {
            return (this.bOT & 1) == 1;
        }

        public final int getArgumentCount() {
            AppMethodBeat.i(58381);
            int size = this.TwN.size();
            AppMethodBeat.o(58381);
            return size;
        }

        private void hEu() {
            AppMethodBeat.i(58382);
            this.TwM = 0;
            this.TwN = Collections.emptyList();
            AppMethodBeat.o(58382);
        }

        @Override // kotlin.l.b.a.b.h.r
        public final boolean isInitialized() {
            AppMethodBeat.i(58383);
            byte b2 = this.bPe;
            if (b2 == 1) {
                AppMethodBeat.o(58383);
                return true;
            } else if (b2 == 0) {
                AppMethodBeat.o(58383);
                return false;
            } else if (!hEt()) {
                this.bPe = 0;
                AppMethodBeat.o(58383);
                return false;
            } else {
                for (int i2 = 0; i2 < getArgumentCount(); i2++) {
                    if (!this.TwN.get(i2).isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58383);
                        return false;
                    }
                }
                this.bPe = 1;
                AppMethodBeat.o(58383);
                return true;
            }
        }

        @Override // kotlin.l.b.a.b.h.q
        public final void a(kotlin.l.b.a.b.h.f fVar) {
            AppMethodBeat.i(58384);
            yC();
            if ((this.bOT & 1) == 1) {
                fVar.bs(1, this.TwM);
            }
            for (int i2 = 0; i2 < this.TwN.size(); i2++) {
                fVar.a(2, this.TwN.get(i2));
            }
            fVar.e(this.TwK);
            AppMethodBeat.o(58384);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final int yC() {
            AppMethodBeat.i(58385);
            int i2 = this.bVY;
            if (i2 != -1) {
                AppMethodBeat.o(58385);
                return i2;
            }
            int bu = (this.bOT & 1) == 1 ? kotlin.l.b.a.b.h.f.bu(1, this.TwM) + 0 : 0;
            for (int i3 = 0; i3 < this.TwN.size(); i3++) {
                bu = kotlin.l.b.a.b.h.f.c(2, this.TwN.get(i3)) + bu;
            }
            int size = this.TwK.size() + bu;
            this.bVY = size;
            AppMethodBeat.o(58385);
            return size;
        }

        /* renamed from: kotlin.l.b.a.b.e.a$a$b */
        public static final class b extends i.a<C2299a, b> implements d {
            private int TwM;
            private List<C2301a> TwN = Collections.emptyList();
            private int bOT;

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.l.b.a.b.h.i] */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ b a(C2299a aVar) {
                AppMethodBeat.i(58371);
                b e2 = e(aVar);
                AppMethodBeat.o(58371);
                return e2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
            public final /* synthetic */ a.AbstractC2337a c(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58373);
                b f2 = f(eVar, gVar);
                AppMethodBeat.o(58373);
                return f2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a, java.lang.Object
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(58378);
                b hEU = hEU();
                AppMethodBeat.o(58378);
                return hEU;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q.a d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58375);
                b f2 = f(eVar, gVar);
                AppMethodBeat.o(58375);
                return f2;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ b hEE() {
                AppMethodBeat.i(58372);
                b hEU = hEU();
                AppMethodBeat.o(58372);
                return hEU;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ a.AbstractC2337a hEF() {
                AppMethodBeat.i(58374);
                b hEU = hEU();
                AppMethodBeat.o(58374);
                return hEU;
            }

            private b() {
                AppMethodBeat.i(58363);
                AppMethodBeat.o(58363);
            }

            public final C2299a hEV() {
                int i2 = 1;
                AppMethodBeat.i(58365);
                C2299a aVar = new C2299a(this, (byte) 0);
                if ((this.bOT & 1) != 1) {
                    i2 = 0;
                }
                aVar.TwM = this.TwM;
                if ((this.bOT & 2) == 2) {
                    this.TwN = Collections.unmodifiableList(this.TwN);
                    this.bOT &= -3;
                }
                aVar.TwN = this.TwN;
                aVar.bOT = i2;
                AppMethodBeat.o(58365);
                return aVar;
            }

            public final b e(C2299a aVar) {
                AppMethodBeat.i(58366);
                if (aVar == C2299a.hEr()) {
                    AppMethodBeat.o(58366);
                } else {
                    if (aVar.hEt()) {
                        aub(aVar.TwM);
                    }
                    if (!aVar.TwN.isEmpty()) {
                        if (this.TwN.isEmpty()) {
                            this.TwN = aVar.TwN;
                            this.bOT &= -3;
                        } else {
                            hEW();
                            this.TwN.addAll(aVar.TwN);
                        }
                    }
                    this.TwK = this.TwK.a(aVar.TwK);
                    AppMethodBeat.o(58366);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private kotlin.l.b.a.b.e.a.C2299a.b f(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                /*
                    r4 = this;
                    r3 = 58368(0xe400, float:8.1791E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    r2 = 0
                    kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.a$a> r0 = kotlin.l.b.a.b.e.a.C2299a.TwL     // Catch:{ k -> 0x0016 }
                    java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                    kotlin.l.b.a.b.e.a$a r0 = (kotlin.l.b.a.b.e.a.C2299a) r0     // Catch:{ k -> 0x0016 }
                    r4.e(r0)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return r4
                L_0x0016:
                    r0 = move-exception
                    r1 = r0
                    kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                    kotlin.l.b.a.b.e.a$a r0 = (kotlin.l.b.a.b.e.a.C2299a) r0     // Catch:{ all -> 0x002e }
                    r2 = 58368(0xe400, float:8.1791E-41)
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.C2299a.b.f(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.a$a$b");
            }

            private b aub(int i2) {
                this.bOT |= 1;
                this.TwM = i2;
                return this;
            }

            private void hEW() {
                AppMethodBeat.i(58369);
                if ((this.bOT & 2) != 2) {
                    this.TwN = new ArrayList(this.TwN);
                    this.bOT |= 2;
                }
                AppMethodBeat.o(58369);
            }

            private b hEU() {
                AppMethodBeat.i(58364);
                b e2 = new b().e(hEV());
                AppMethodBeat.o(58364);
                return e2;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                AppMethodBeat.i(58367);
                if (!((this.bOT & 1) == 1)) {
                    AppMethodBeat.o(58367);
                    return false;
                }
                for (int i2 = 0; i2 < this.TwN.size(); i2++) {
                    if (!this.TwN.get(i2).isInitialized()) {
                        AppMethodBeat.o(58367);
                        return false;
                    }
                }
                AppMethodBeat.o(58367);
                return true;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2299a hED() {
                AppMethodBeat.i(58370);
                C2299a hEr = C2299a.hEr();
                AppMethodBeat.o(58370);
                return hEr;
            }

            @Override // kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEG() {
                AppMethodBeat.i(58376);
                C2299a hEV = hEV();
                if (!hEV.isInitialized()) {
                    kotlin.l.b.a.b.h.w wVar = new kotlin.l.b.a.b.h.w();
                    AppMethodBeat.o(58376);
                    throw wVar;
                }
                AppMethodBeat.o(58376);
                return hEV;
            }

            @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                AppMethodBeat.i(58377);
                C2299a hEr = C2299a.hEr();
                AppMethodBeat.o(58377);
                return hEr;
            }

            static /* synthetic */ b hEX() {
                AppMethodBeat.i(58379);
                b bVar = new b();
                AppMethodBeat.o(58379);
                return bVar;
            }
        }

        public static b a(C2299a aVar) {
            AppMethodBeat.i(58386);
            b e2 = b.hEX().e(aVar);
            AppMethodBeat.o(58386);
            return e2;
        }

        public final b hEv() {
            AppMethodBeat.i(58387);
            b e2 = b.hEX().e(this);
            AppMethodBeat.o(58387);
            return e2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEx() {
            AppMethodBeat.i(58389);
            b hEX = b.hEX();
            AppMethodBeat.o(58389);
            return hEX;
        }

        @Override // kotlin.l.b.a.b.h.r
        public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
            return TwJ;
        }
    }

    public static final class p extends i.c<p> implements t {
        public static kotlin.l.b.a.b.h.s<p> TwL = new kotlin.l.b.a.b.h.b<p>() {
            /* class kotlin.l.b.a.b.e.a.p.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.h.s
            public final /* synthetic */ Object a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58801);
                p pVar = new p(eVar, gVar, (byte) 0);
                AppMethodBeat.o(58801);
                return pVar;
            }
        };
        private static final p Tzj;
        private final kotlin.l.b.a.b.h.d TwK;
        public List<C2320a> TwN;
        public int Txb;
        public boolean Tzk;
        public int Tzl;
        public p Tzm;
        public int Tzn;
        public int Tzo;
        public int Tzp;
        public int Tzq;
        public int Tzr;
        public p Tzs;
        public int Tzt;
        public p Tzu;
        public int Tzv;
        private int bOT;
        private byte bPe;
        private int bVY;

        /* synthetic */ p(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar, byte b2) {
            this(eVar, gVar);
        }

        /* synthetic */ p(i.b bVar, byte b2) {
            this(bVar);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEw() {
            AppMethodBeat.i(58863);
            b hHf = hHf();
            AppMethodBeat.o(58863);
            return hHf;
        }

        private p(i.b<p, ?> bVar) {
            super(bVar);
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = bVar.TwK;
        }

        private p() {
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = kotlin.l.b.a.b.h.d.TDp;
        }

        public static p hGS() {
            return Tzj;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v77, resolved type: java.util.List<kotlin.l.b.a.b.e.a$p$a> */
        /* JADX WARN: Multi-variable type inference failed */
        private p(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
            b bVar;
            b bVar2;
            b bVar3;
            AppMethodBeat.i(58855);
            this.bPe = -1;
            this.bVY = -1;
            hEu();
            d.b hJo = kotlin.l.b.a.b.h.d.hJo();
            kotlin.l.b.a.b.h.f f2 = kotlin.l.b.a.b.h.f.f(hJo, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int yT = eVar.yT();
                    switch (yT) {
                        case 0:
                            z = true;
                            break;
                        case 8:
                            this.bOT |= 4096;
                            this.Txb = eVar.zi();
                            break;
                        case 18:
                            if (!z2 || !true) {
                                this.TwN = new ArrayList();
                                z2 |= true;
                            }
                            this.TwN.add(eVar.a(C2320a.TwL, gVar));
                            break;
                        case 24:
                            this.bOT |= 1;
                            this.Tzk = eVar.yZ();
                            break;
                        case 32:
                            this.bOT |= 2;
                            this.Tzl = eVar.zi();
                            break;
                        case 42:
                            if ((this.bOT & 4) == 4) {
                                bVar3 = b.hHp().j(this.Tzm);
                            } else {
                                bVar3 = null;
                            }
                            this.Tzm = (p) eVar.a(TwL, gVar);
                            if (bVar3 != null) {
                                bVar3.j(this.Tzm);
                                this.Tzm = bVar3.hHo();
                            }
                            this.bOT |= 4;
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                            this.bOT |= 16;
                            this.Tzo = eVar.zi();
                            break;
                        case 56:
                            this.bOT |= 32;
                            this.Tzp = eVar.zi();
                            break;
                        case 64:
                            this.bOT |= 8;
                            this.Tzn = eVar.zi();
                            break;
                        case 72:
                            this.bOT |= 64;
                            this.Tzq = eVar.zi();
                            break;
                        case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE:
                            if ((this.bOT & 256) == 256) {
                                bVar2 = b.hHp().j(this.Tzs);
                            } else {
                                bVar2 = null;
                            }
                            this.Tzs = (p) eVar.a(TwL, gVar);
                            if (bVar2 != null) {
                                bVar2.j(this.Tzs);
                                this.Tzs = bVar2.hHo();
                            }
                            this.bOT |= 256;
                            break;
                        case TPCodecParamers.TP_PROFILE_H264_EXTENDED:
                            this.bOT |= 512;
                            this.Tzt = eVar.zi();
                            break;
                        case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT:
                            this.bOT |= 128;
                            this.Tzr = eVar.zi();
                            break;
                        case 106:
                            if ((this.bOT & 1024) == 1024) {
                                bVar = b.hHp().j(this.Tzu);
                            } else {
                                bVar = null;
                            }
                            this.Tzu = (p) eVar.a(TwL, gVar);
                            if (bVar != null) {
                                bVar.j(this.Tzu);
                                this.Tzu = bVar.hHo();
                            }
                            this.bOT |= 1024;
                            break;
                        case 112:
                            this.bOT |= 2048;
                            this.Tzv = eVar.zi();
                            break;
                        default:
                            if (a(eVar, f2, gVar, yT)) {
                                break;
                            } else {
                                z = true;
                                break;
                            }
                    }
                } catch (kotlin.l.b.a.b.h.k e2) {
                    e2.TDK = this;
                    AppMethodBeat.o(58855);
                    throw e2;
                } catch (IOException e3) {
                    kotlin.l.b.a.b.h.k kVar = new kotlin.l.b.a.b.h.k(e3.getMessage());
                    kVar.TDK = this;
                    AppMethodBeat.o(58855);
                    throw kVar;
                } catch (Throwable th) {
                    if (z2 && true) {
                        this.TwN = Collections.unmodifiableList(this.TwN);
                    }
                    try {
                        f2.flush();
                        this.TwK = hJo.hJs();
                    } catch (IOException e4) {
                        this.TwK = hJo.hJs();
                    } catch (Throwable th2) {
                        this.TwK = hJo.hJs();
                        AppMethodBeat.o(58855);
                        throw th2;
                    }
                    this.TDA.yK();
                    AppMethodBeat.o(58855);
                    throw th;
                }
            }
            if (z2 && true) {
                this.TwN = Collections.unmodifiableList(this.TwN);
            }
            try {
                f2.flush();
                this.TwK = hJo.hJs();
            } catch (IOException e5) {
                this.TwK = hJo.hJs();
            } catch (Throwable th3) {
                this.TwK = hJo.hJs();
                AppMethodBeat.o(58855);
                throw th3;
            }
            this.TDA.yK();
            AppMethodBeat.o(58855);
        }

        static {
            AppMethodBeat.i(58865);
            p pVar = new p();
            Tzj = pVar;
            pVar.hEu();
            AppMethodBeat.o(58865);
        }

        @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
        public final kotlin.l.b.a.b.h.s<p> hEs() {
            return TwL;
        }

        /* renamed from: kotlin.l.b.a.b.e.a$p$a  reason: collision with other inner class name */
        public static final class C2320a extends kotlin.l.b.a.b.h.i implements r {
            public static kotlin.l.b.a.b.h.s<C2320a> TwL = new kotlin.l.b.a.b.h.b<C2320a>() {
                /* class kotlin.l.b.a.b.e.a.p.C2320a.AnonymousClass1 */

                @Override // kotlin.l.b.a.b.h.s
                public final /* synthetic */ Object a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                    AppMethodBeat.i(58802);
                    C2320a aVar = new C2320a(eVar, gVar, (byte) 0);
                    AppMethodBeat.o(58802);
                    return aVar;
                }
            };
            private static final C2320a Tzw;
            private final kotlin.l.b.a.b.h.d TwK;
            public b Tzx;
            public p Tzy;
            public int Tzz;
            private int bOT;
            private byte bPe;
            private int bVY;

            /* synthetic */ C2320a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar, byte b2) {
                this(eVar, gVar);
            }

            /* synthetic */ C2320a(i.a aVar, byte b2) {
                this(aVar);
            }

            private C2320a(i.a aVar) {
                super((byte) 0);
                this.bPe = -1;
                this.bVY = -1;
                this.TwK = aVar.TwK;
            }

            private C2320a() {
                this.bPe = -1;
                this.bVY = -1;
                this.TwK = kotlin.l.b.a.b.h.d.TDp;
            }

            public static C2320a hHg() {
                return Tzw;
            }

            private C2320a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                b bVar;
                AppMethodBeat.i(58825);
                this.bPe = -1;
                this.bVY = -1;
                hEu();
                d.b hJo = kotlin.l.b.a.b.h.d.hJo();
                kotlin.l.b.a.b.h.f f2 = kotlin.l.b.a.b.h.f.f(hJo, 1);
                boolean z = false;
                while (!z) {
                    try {
                        int yT = eVar.yT();
                        switch (yT) {
                            case 0:
                                z = true;
                                break;
                            case 8:
                                int zi = eVar.zi();
                                b auH = b.auH(zi);
                                if (auH != null) {
                                    this.bOT |= 1;
                                    this.Tzx = auH;
                                    break;
                                } else {
                                    f2.hc(yT);
                                    f2.hc(zi);
                                    break;
                                }
                            case 18:
                                if ((this.bOT & 2) == 2) {
                                    bVar = this.Tzy.hHf();
                                } else {
                                    bVar = null;
                                }
                                this.Tzy = (p) eVar.a(p.TwL, gVar);
                                if (bVar != null) {
                                    bVar.j(this.Tzy);
                                    this.Tzy = bVar.hHo();
                                }
                                this.bOT |= 2;
                                break;
                            case 24:
                                this.bOT |= 4;
                                this.Tzz = eVar.zi();
                                break;
                            default:
                                if (a(eVar, f2, gVar, yT)) {
                                    break;
                                } else {
                                    z = true;
                                    break;
                                }
                        }
                    } catch (kotlin.l.b.a.b.h.k e2) {
                        e2.TDK = this;
                        AppMethodBeat.o(58825);
                        throw e2;
                    } catch (IOException e3) {
                        kotlin.l.b.a.b.h.k kVar = new kotlin.l.b.a.b.h.k(e3.getMessage());
                        kVar.TDK = this;
                        AppMethodBeat.o(58825);
                        throw kVar;
                    } catch (Throwable th) {
                        try {
                            f2.flush();
                            this.TwK = hJo.hJs();
                        } catch (IOException e4) {
                            this.TwK = hJo.hJs();
                        } catch (Throwable th2) {
                            this.TwK = hJo.hJs();
                            AppMethodBeat.o(58825);
                            throw th2;
                        }
                        Gw();
                        AppMethodBeat.o(58825);
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
                    AppMethodBeat.o(58825);
                    throw th3;
                }
                Gw();
                AppMethodBeat.o(58825);
            }

            static {
                AppMethodBeat.i(58832);
                C2320a aVar = new C2320a();
                Tzw = aVar;
                aVar.hEu();
                AppMethodBeat.o(58832);
            }

            @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
            public final kotlin.l.b.a.b.h.s<C2320a> hEs() {
                return TwL;
            }

            /* renamed from: kotlin.l.b.a.b.e.a$p$a$b */
            public enum b implements j.a {
                IN(0),
                OUT(1),
                INV(2),
                STAR(3);
                
                private static j.b<b> Txp = new j.b<b>() {
                    /* class kotlin.l.b.a.b.e.a.p.C2320a.b.AnonymousClass1 */

                    /* Return type fixed from 'kotlin.l.b.a.b.h.j$a' to match base method */
                    @Override // kotlin.l.b.a.b.h.j.b
                    public final /* synthetic */ b aua(int i2) {
                        AppMethodBeat.i(58821);
                        b auH = b.auH(i2);
                        AppMethodBeat.o(58821);
                        return auH;
                    }
                };
                final int value;

                public static b valueOf(String str) {
                    AppMethodBeat.i(58823);
                    b bVar = (b) Enum.valueOf(b.class, str);
                    AppMethodBeat.o(58823);
                    return bVar;
                }

                static {
                    AppMethodBeat.i(58824);
                    AppMethodBeat.o(58824);
                }

                @Override // kotlin.l.b.a.b.h.j.a
                public final int getNumber() {
                    return this.value;
                }

                public static b auH(int i2) {
                    switch (i2) {
                        case 0:
                            return IN;
                        case 1:
                            return OUT;
                        case 2:
                            return INV;
                        case 3:
                            return STAR;
                        default:
                            return null;
                    }
                }

                private b(int i2) {
                    this.value = i2;
                }
            }

            public final boolean hHh() {
                return (this.bOT & 1) == 1;
            }

            public final boolean Cm() {
                return (this.bOT & 2) == 2;
            }

            public final boolean hHi() {
                return (this.bOT & 4) == 4;
            }

            private void hEu() {
                AppMethodBeat.i(58826);
                this.Tzx = b.INV;
                this.Tzy = p.hGS();
                this.Tzz = 0;
                AppMethodBeat.o(58826);
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                AppMethodBeat.i(58827);
                byte b2 = this.bPe;
                if (b2 == 1) {
                    AppMethodBeat.o(58827);
                    return true;
                } else if (b2 == 0) {
                    AppMethodBeat.o(58827);
                    return false;
                } else if (!Cm() || this.Tzy.isInitialized()) {
                    this.bPe = 1;
                    AppMethodBeat.o(58827);
                    return true;
                } else {
                    this.bPe = 0;
                    AppMethodBeat.o(58827);
                    return false;
                }
            }

            @Override // kotlin.l.b.a.b.h.q
            public final void a(kotlin.l.b.a.b.h.f fVar) {
                AppMethodBeat.i(58828);
                yC();
                if ((this.bOT & 1) == 1) {
                    fVar.nb(1, this.Tzx.value);
                }
                if ((this.bOT & 2) == 2) {
                    fVar.a(2, this.Tzy);
                }
                if ((this.bOT & 4) == 4) {
                    fVar.bs(3, this.Tzz);
                }
                fVar.e(this.TwK);
                AppMethodBeat.o(58828);
            }

            @Override // kotlin.l.b.a.b.h.q
            public final int yC() {
                AppMethodBeat.i(58829);
                int i2 = this.bVY;
                if (i2 != -1) {
                    AppMethodBeat.o(58829);
                    return i2;
                }
                int i3 = 0;
                if ((this.bOT & 1) == 1) {
                    i3 = kotlin.l.b.a.b.h.f.bv(1, this.Tzx.value) + 0;
                }
                if ((this.bOT & 2) == 2) {
                    i3 += kotlin.l.b.a.b.h.f.c(2, this.Tzy);
                }
                if ((this.bOT & 4) == 4) {
                    i3 += kotlin.l.b.a.b.h.f.bu(3, this.Tzz);
                }
                int size = i3 + this.TwK.size();
                this.bVY = size;
                AppMethodBeat.o(58829);
                return size;
            }

            /* renamed from: kotlin.l.b.a.b.e.a$p$a$a  reason: collision with other inner class name */
            public static final class C2321a extends i.a<C2320a, C2321a> implements r {
                private b Tzx = b.INV;
                private p Tzy = p.hGS();
                private int Tzz;
                private int bOT;

                /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.l.b.a.b.h.i] */
                @Override // kotlin.l.b.a.b.h.i.a
                public final /* synthetic */ C2321a a(C2320a aVar) {
                    AppMethodBeat.i(58812);
                    C2321a b2 = b(aVar);
                    AppMethodBeat.o(58812);
                    return b2;
                }

                @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
                public final /* synthetic */ a.AbstractC2337a c(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                    AppMethodBeat.i(58814);
                    C2321a t = t(eVar, gVar);
                    AppMethodBeat.o(58814);
                    return t;
                }

                @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a, java.lang.Object
                public final /* synthetic */ Object clone() {
                    AppMethodBeat.i(58819);
                    C2321a hHj = hHj();
                    AppMethodBeat.o(58819);
                    return hHj;
                }

                @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
                public final /* synthetic */ q.a d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                    AppMethodBeat.i(58816);
                    C2321a t = t(eVar, gVar);
                    AppMethodBeat.o(58816);
                    return t;
                }

                /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
                @Override // kotlin.l.b.a.b.h.i.a
                public final /* synthetic */ C2321a hEE() {
                    AppMethodBeat.i(58813);
                    C2321a hHj = hHj();
                    AppMethodBeat.o(58813);
                    return hHj;
                }

                @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a
                public final /* synthetic */ a.AbstractC2337a hEF() {
                    AppMethodBeat.i(58815);
                    C2321a hHj = hHj();
                    AppMethodBeat.o(58815);
                    return hHj;
                }

                private C2321a() {
                    AppMethodBeat.i(58803);
                    AppMethodBeat.o(58803);
                }

                private C2320a hHk() {
                    int i2 = 1;
                    AppMethodBeat.i(58805);
                    C2320a aVar = new C2320a(this, (byte) 0);
                    int i3 = this.bOT;
                    if ((i3 & 1) != 1) {
                        i2 = 0;
                    }
                    aVar.Tzx = this.Tzx;
                    if ((i3 & 2) == 2) {
                        i2 |= 2;
                    }
                    aVar.Tzy = this.Tzy;
                    if ((i3 & 4) == 4) {
                        i2 |= 4;
                    }
                    aVar.Tzz = this.Tzz;
                    aVar.bOT = i2;
                    AppMethodBeat.o(58805);
                    return aVar;
                }

                public final C2321a b(C2320a aVar) {
                    AppMethodBeat.i(58806);
                    if (aVar == C2320a.hHg()) {
                        AppMethodBeat.o(58806);
                    } else {
                        if (aVar.hHh()) {
                            a(aVar.Tzx);
                        }
                        if (aVar.Cm()) {
                            i(aVar.Tzy);
                        }
                        if (aVar.hHi()) {
                            auG(aVar.Tzz);
                        }
                        this.TwK = this.TwK.a(aVar.TwK);
                        AppMethodBeat.o(58806);
                    }
                    return this;
                }

                /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                private kotlin.l.b.a.b.e.a.p.C2320a.C2321a t(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                    /*
                        r4 = this;
                        r3 = 58808(0xe5b8, float:8.2408E-41)
                        com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                        r2 = 0
                        kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.a$p$a> r0 = kotlin.l.b.a.b.e.a.p.C2320a.TwL     // Catch:{ k -> 0x0016 }
                        java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                        kotlin.l.b.a.b.e.a$p$a r0 = (kotlin.l.b.a.b.e.a.p.C2320a) r0     // Catch:{ k -> 0x0016 }
                        r4.b(r0)
                        com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                        return r4
                    L_0x0016:
                        r0 = move-exception
                        r1 = r0
                        kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                        kotlin.l.b.a.b.e.a$p$a r0 = (kotlin.l.b.a.b.e.a.p.C2320a) r0     // Catch:{ all -> 0x002e }
                        r2 = 58808(0xe5b8, float:8.2408E-41)
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
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.p.C2320a.C2321a.t(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.a$p$a$a");
                }

                private C2321a a(b bVar) {
                    AppMethodBeat.i(58809);
                    if (bVar == null) {
                        NullPointerException nullPointerException = new NullPointerException();
                        AppMethodBeat.o(58809);
                        throw nullPointerException;
                    }
                    this.bOT |= 1;
                    this.Tzx = bVar;
                    AppMethodBeat.o(58809);
                    return this;
                }

                private C2321a i(p pVar) {
                    AppMethodBeat.i(58810);
                    if ((this.bOT & 2) != 2 || this.Tzy == p.hGS()) {
                        this.Tzy = pVar;
                    } else {
                        this.Tzy = p.f(this.Tzy).j(pVar).hHo();
                    }
                    this.bOT |= 2;
                    AppMethodBeat.o(58810);
                    return this;
                }

                private C2321a auG(int i2) {
                    this.bOT |= 4;
                    this.Tzz = i2;
                    return this;
                }

                private C2321a hHj() {
                    AppMethodBeat.i(58804);
                    C2321a b2 = new C2321a().b(hHk());
                    AppMethodBeat.o(58804);
                    return b2;
                }

                @Override // kotlin.l.b.a.b.h.r
                public final boolean isInitialized() {
                    boolean z;
                    AppMethodBeat.i(58807);
                    if ((this.bOT & 2) == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z || this.Tzy.isInitialized()) {
                        AppMethodBeat.o(58807);
                        return true;
                    }
                    AppMethodBeat.o(58807);
                    return false;
                }

                /* Return type fixed from 'kotlin.l.b.a.b.h.i' to match base method */
                @Override // kotlin.l.b.a.b.h.i.a
                public final /* synthetic */ C2320a hED() {
                    AppMethodBeat.i(58811);
                    C2320a hHg = C2320a.hHg();
                    AppMethodBeat.o(58811);
                    return hHg;
                }

                @Override // kotlin.l.b.a.b.h.q.a
                public final /* synthetic */ kotlin.l.b.a.b.h.q hEG() {
                    AppMethodBeat.i(58817);
                    C2320a hHk = hHk();
                    if (!hHk.isInitialized()) {
                        kotlin.l.b.a.b.h.w wVar = new kotlin.l.b.a.b.h.w();
                        AppMethodBeat.o(58817);
                        throw wVar;
                    }
                    AppMethodBeat.o(58817);
                    return hHk;
                }

                @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
                public final /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                    AppMethodBeat.i(58818);
                    C2320a hHg = C2320a.hHg();
                    AppMethodBeat.o(58818);
                    return hHg;
                }

                static /* synthetic */ C2321a hHl() {
                    AppMethodBeat.i(58820);
                    C2321a aVar = new C2321a();
                    AppMethodBeat.o(58820);
                    return aVar;
                }
            }

            @Override // kotlin.l.b.a.b.h.q
            public final /* synthetic */ q.a hEw() {
                AppMethodBeat.i(58830);
                C2321a b2 = C2321a.hHl().b(this);
                AppMethodBeat.o(58830);
                return b2;
            }

            @Override // kotlin.l.b.a.b.h.q
            public final /* synthetic */ q.a hEx() {
                AppMethodBeat.i(58831);
                C2321a hHl = C2321a.hHl();
                AppMethodBeat.o(58831);
                return hHl;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                return Tzw;
            }
        }

        public final int getArgumentCount() {
            AppMethodBeat.i(58856);
            int size = this.TwN.size();
            AppMethodBeat.o(58856);
            return size;
        }

        public final boolean hGT() {
            return (this.bOT & 1) == 1;
        }

        public final boolean hGU() {
            return (this.bOT & 2) == 2;
        }

        public final boolean hGV() {
            return (this.bOT & 4) == 4;
        }

        public final boolean hGW() {
            return (this.bOT & 8) == 8;
        }

        public final boolean hGX() {
            return (this.bOT & 16) == 16;
        }

        public final boolean hGY() {
            return (this.bOT & 32) == 32;
        }

        public final boolean hGZ() {
            return (this.bOT & 64) == 64;
        }

        public final boolean hHa() {
            return (this.bOT & 128) == 128;
        }

        public final boolean hHb() {
            return (this.bOT & 256) == 256;
        }

        public final boolean hHc() {
            return (this.bOT & 512) == 512;
        }

        public final boolean hHd() {
            return (this.bOT & 1024) == 1024;
        }

        public final boolean hHe() {
            return (this.bOT & 2048) == 2048;
        }

        public final boolean hEP() {
            return (this.bOT & 4096) == 4096;
        }

        private void hEu() {
            AppMethodBeat.i(58857);
            this.TwN = Collections.emptyList();
            this.Tzk = false;
            this.Tzl = 0;
            this.Tzm = Tzj;
            this.Tzn = 0;
            this.Tzo = 0;
            this.Tzp = 0;
            this.Tzq = 0;
            this.Tzr = 0;
            this.Tzs = Tzj;
            this.Tzt = 0;
            this.Tzu = Tzj;
            this.Tzv = 0;
            this.Txb = 0;
            AppMethodBeat.o(58857);
        }

        @Override // kotlin.l.b.a.b.h.r
        public final boolean isInitialized() {
            AppMethodBeat.i(58858);
            byte b2 = this.bPe;
            if (b2 == 1) {
                AppMethodBeat.o(58858);
                return true;
            } else if (b2 == 0) {
                AppMethodBeat.o(58858);
                return false;
            } else {
                for (int i2 = 0; i2 < getArgumentCount(); i2++) {
                    if (!this.TwN.get(i2).isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58858);
                        return false;
                    }
                }
                if (hGV() && !this.Tzm.isInitialized()) {
                    this.bPe = 0;
                    AppMethodBeat.o(58858);
                    return false;
                } else if (hHb() && !this.Tzs.isInitialized()) {
                    this.bPe = 0;
                    AppMethodBeat.o(58858);
                    return false;
                } else if (hHd() && !this.Tzu.isInitialized()) {
                    this.bPe = 0;
                    AppMethodBeat.o(58858);
                    return false;
                } else if (!this.TDA.isInitialized()) {
                    this.bPe = 0;
                    AppMethodBeat.o(58858);
                    return false;
                } else {
                    this.bPe = 1;
                    AppMethodBeat.o(58858);
                    return true;
                }
            }
        }

        @Override // kotlin.l.b.a.b.h.q
        public final void a(kotlin.l.b.a.b.h.f fVar) {
            AppMethodBeat.i(58859);
            yC();
            i.c<MessageType>.a hJC = hJC();
            if ((this.bOT & 4096) == 4096) {
                fVar.bs(1, this.Txb);
            }
            for (int i2 = 0; i2 < this.TwN.size(); i2++) {
                fVar.a(2, this.TwN.get(i2));
            }
            if ((this.bOT & 1) == 1) {
                fVar.EJ(this.Tzk);
            }
            if ((this.bOT & 2) == 2) {
                fVar.bs(4, this.Tzl);
            }
            if ((this.bOT & 4) == 4) {
                fVar.a(5, this.Tzm);
            }
            if ((this.bOT & 16) == 16) {
                fVar.bs(6, this.Tzo);
            }
            if ((this.bOT & 32) == 32) {
                fVar.bs(7, this.Tzp);
            }
            if ((this.bOT & 8) == 8) {
                fVar.bs(8, this.Tzn);
            }
            if ((this.bOT & 64) == 64) {
                fVar.bs(9, this.Tzq);
            }
            if ((this.bOT & 256) == 256) {
                fVar.a(10, this.Tzs);
            }
            if ((this.bOT & 512) == 512) {
                fVar.bs(11, this.Tzt);
            }
            if ((this.bOT & 128) == 128) {
                fVar.bs(12, this.Tzr);
            }
            if ((this.bOT & 1024) == 1024) {
                fVar.a(13, this.Tzu);
            }
            if ((this.bOT & 2048) == 2048) {
                fVar.bs(14, this.Tzv);
            }
            hJC.b(200, fVar);
            fVar.e(this.TwK);
            AppMethodBeat.o(58859);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final int yC() {
            int i2;
            int i3;
            int i4 = 0;
            AppMethodBeat.i(58860);
            int i5 = this.bVY;
            if (i5 != -1) {
                AppMethodBeat.o(58860);
                return i5;
            }
            if ((this.bOT & 4096) == 4096) {
                i2 = kotlin.l.b.a.b.h.f.bu(1, this.Txb) + 0;
            } else {
                i2 = 0;
            }
            while (true) {
                i3 = i2;
                if (i4 >= this.TwN.size()) {
                    break;
                }
                i2 = kotlin.l.b.a.b.h.f.c(2, this.TwN.get(i4)) + i3;
                i4++;
            }
            if ((this.bOT & 1) == 1) {
                i3 += kotlin.l.b.a.b.h.f.fS(3) + 1;
            }
            if ((this.bOT & 2) == 2) {
                i3 += kotlin.l.b.a.b.h.f.bu(4, this.Tzl);
            }
            if ((this.bOT & 4) == 4) {
                i3 += kotlin.l.b.a.b.h.f.c(5, this.Tzm);
            }
            if ((this.bOT & 16) == 16) {
                i3 += kotlin.l.b.a.b.h.f.bu(6, this.Tzo);
            }
            if ((this.bOT & 32) == 32) {
                i3 += kotlin.l.b.a.b.h.f.bu(7, this.Tzp);
            }
            if ((this.bOT & 8) == 8) {
                i3 += kotlin.l.b.a.b.h.f.bu(8, this.Tzn);
            }
            if ((this.bOT & 64) == 64) {
                i3 += kotlin.l.b.a.b.h.f.bu(9, this.Tzq);
            }
            if ((this.bOT & 256) == 256) {
                i3 += kotlin.l.b.a.b.h.f.c(10, this.Tzs);
            }
            if ((this.bOT & 512) == 512) {
                i3 += kotlin.l.b.a.b.h.f.bu(11, this.Tzt);
            }
            if ((this.bOT & 128) == 128) {
                i3 += kotlin.l.b.a.b.h.f.bu(12, this.Tzr);
            }
            if ((this.bOT & 1024) == 1024) {
                i3 += kotlin.l.b.a.b.h.f.c(13, this.Tzu);
            }
            if ((this.bOT & 2048) == 2048) {
                i3 += kotlin.l.b.a.b.h.f.bu(14, this.Tzv);
            }
            int yC = this.TDA.yC() + i3 + this.TwK.size();
            this.bVY = yC;
            AppMethodBeat.o(58860);
            return yC;
        }

        public static final class b extends i.b<p, b> implements t {
            private List<C2320a> TwN = Collections.emptyList();
            private int Txb;
            private boolean Tzk;
            private int Tzl;
            private p Tzm = p.hGS();
            private int Tzn;
            private int Tzo;
            private int Tzp;
            private int Tzq;
            private int Tzr;
            private p Tzs = p.hGS();
            private int Tzt;
            private p Tzu = p.hGS();
            private int Tzv;
            private int bOT;

            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ i.a a(kotlin.l.b.a.b.h.i iVar) {
                AppMethodBeat.i(58847);
                b j2 = j((p) iVar);
                AppMethodBeat.o(58847);
                return j2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
            public final /* synthetic */ a.AbstractC2337a c(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58849);
                b u = u(eVar, gVar);
                AppMethodBeat.o(58849);
                return u;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a, java.lang.Object
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(58853);
                b hHm = hHm();
                AppMethodBeat.o(58853);
                return hHm;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q.a d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58851);
                b u = u(eVar, gVar);
                AppMethodBeat.o(58851);
                return u;
            }

            @Override // kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ i.a hEE() {
                AppMethodBeat.i(58848);
                b hHm = hHm();
                AppMethodBeat.o(58848);
                return hHm;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ a.AbstractC2337a hEF() {
                AppMethodBeat.i(58850);
                b hHm = hHm();
                AppMethodBeat.o(58850);
                return hHm;
            }

            @Override // kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEG() {
                AppMethodBeat.i(58852);
                p hHn = hHn();
                AppMethodBeat.o(58852);
                return hHn;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$b' to match base method */
            @Override // kotlin.l.b.a.b.h.i.b
            public final /* synthetic */ b hFq() {
                AppMethodBeat.i(58844);
                b hHm = hHm();
                AppMethodBeat.o(58844);
                return hHm;
            }

            private b() {
                AppMethodBeat.i(58833);
                AppMethodBeat.o(58833);
            }

            public final p hHn() {
                AppMethodBeat.i(58835);
                p hHo = hHo();
                if (!hHo.isInitialized()) {
                    kotlin.l.b.a.b.h.w wVar = new kotlin.l.b.a.b.h.w();
                    AppMethodBeat.o(58835);
                    throw wVar;
                }
                AppMethodBeat.o(58835);
                return hHo;
            }

            public final p hHo() {
                int i2 = 1;
                AppMethodBeat.i(58836);
                p pVar = new p(this, (byte) 0);
                int i3 = this.bOT;
                if ((this.bOT & 1) == 1) {
                    this.TwN = Collections.unmodifiableList(this.TwN);
                    this.bOT &= -2;
                }
                pVar.TwN = this.TwN;
                if ((i3 & 2) != 2) {
                    i2 = 0;
                }
                pVar.Tzk = this.Tzk;
                if ((i3 & 4) == 4) {
                    i2 |= 2;
                }
                pVar.Tzl = this.Tzl;
                if ((i3 & 8) == 8) {
                    i2 |= 4;
                }
                pVar.Tzm = this.Tzm;
                if ((i3 & 16) == 16) {
                    i2 |= 8;
                }
                pVar.Tzn = this.Tzn;
                if ((i3 & 32) == 32) {
                    i2 |= 16;
                }
                pVar.Tzo = this.Tzo;
                if ((i3 & 64) == 64) {
                    i2 |= 32;
                }
                pVar.Tzp = this.Tzp;
                if ((i3 & 128) == 128) {
                    i2 |= 64;
                }
                pVar.Tzq = this.Tzq;
                if ((i3 & 256) == 256) {
                    i2 |= 128;
                }
                pVar.Tzr = this.Tzr;
                if ((i3 & 512) == 512) {
                    i2 |= 256;
                }
                pVar.Tzs = this.Tzs;
                if ((i3 & 1024) == 1024) {
                    i2 |= 512;
                }
                pVar.Tzt = this.Tzt;
                if ((i3 & 2048) == 2048) {
                    i2 |= 1024;
                }
                pVar.Tzu = this.Tzu;
                if ((i3 & 4096) == 4096) {
                    i2 |= 2048;
                }
                pVar.Tzv = this.Tzv;
                if ((i3 & 8192) == 8192) {
                    i2 |= 4096;
                }
                pVar.Txb = this.Txb;
                pVar.bOT = i2;
                AppMethodBeat.o(58836);
                return pVar;
            }

            public final b j(p pVar) {
                AppMethodBeat.i(58837);
                if (pVar == p.hGS()) {
                    AppMethodBeat.o(58837);
                } else {
                    if (!pVar.TwN.isEmpty()) {
                        if (this.TwN.isEmpty()) {
                            this.TwN = pVar.TwN;
                            this.bOT &= -2;
                        } else {
                            hEW();
                            this.TwN.addAll(pVar.TwN);
                        }
                    }
                    if (pVar.hGT()) {
                        EH(pVar.Tzk);
                    }
                    if (pVar.hGU()) {
                        auI(pVar.Tzl);
                    }
                    if (pVar.hGV()) {
                        k(pVar.Tzm);
                    }
                    if (pVar.hGW()) {
                        auJ(pVar.Tzn);
                    }
                    if (pVar.hGX()) {
                        auK(pVar.Tzo);
                    }
                    if (pVar.hGY()) {
                        auL(pVar.Tzp);
                    }
                    if (pVar.hGZ()) {
                        auM(pVar.Tzq);
                    }
                    if (pVar.hHa()) {
                        auN(pVar.Tzr);
                    }
                    if (pVar.hHb()) {
                        l(pVar.Tzs);
                    }
                    if (pVar.hHc()) {
                        auO(pVar.Tzt);
                    }
                    if (pVar.hHd()) {
                        m(pVar.Tzu);
                    }
                    if (pVar.hHe()) {
                        auP(pVar.Tzv);
                    }
                    if (pVar.hEP()) {
                        auQ(pVar.Txb);
                    }
                    a((i.c) pVar);
                    this.TwK = this.TwK.a(pVar.TwK);
                    AppMethodBeat.o(58837);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private kotlin.l.b.a.b.e.a.p.b u(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                /*
                    r4 = this;
                    r3 = 58839(0xe5d7, float:8.2451E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    r2 = 0
                    kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.a$p> r0 = kotlin.l.b.a.b.e.a.p.TwL     // Catch:{ k -> 0x0016 }
                    java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                    kotlin.l.b.a.b.e.a$p r0 = (kotlin.l.b.a.b.e.a.p) r0     // Catch:{ k -> 0x0016 }
                    r4.j(r0)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return r4
                L_0x0016:
                    r0 = move-exception
                    r1 = r0
                    kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                    kotlin.l.b.a.b.e.a$p r0 = (kotlin.l.b.a.b.e.a.p) r0     // Catch:{ all -> 0x002e }
                    r2 = 58839(0xe5d7, float:8.2451E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)     // Catch:{ all -> 0x0023 }
                    throw r1     // Catch:{ all -> 0x0023 }
                L_0x0023:
                    r1 = move-exception
                    r2 = r0
                L_0x0025:
                    if (r2 == 0) goto L_0x002a
                    r4.j(r2)
                L_0x002a:
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    throw r1
                L_0x002e:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x0025
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.p.b.u(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.a$p$b");
            }

            private void hEW() {
                AppMethodBeat.i(58840);
                if ((this.bOT & 1) != 1) {
                    this.TwN = new ArrayList(this.TwN);
                    this.bOT |= 1;
                }
                AppMethodBeat.o(58840);
            }

            public final b EH(boolean z) {
                this.bOT |= 2;
                this.Tzk = z;
                return this;
            }

            private b auI(int i2) {
                this.bOT |= 4;
                this.Tzl = i2;
                return this;
            }

            private b k(p pVar) {
                AppMethodBeat.i(58841);
                if ((this.bOT & 8) != 8 || this.Tzm == p.hGS()) {
                    this.Tzm = pVar;
                } else {
                    this.Tzm = p.f(this.Tzm).j(pVar).hHo();
                }
                this.bOT |= 8;
                AppMethodBeat.o(58841);
                return this;
            }

            private b auJ(int i2) {
                this.bOT |= 16;
                this.Tzn = i2;
                return this;
            }

            private b auK(int i2) {
                this.bOT |= 32;
                this.Tzo = i2;
                return this;
            }

            private b auL(int i2) {
                this.bOT |= 64;
                this.Tzp = i2;
                return this;
            }

            private b auM(int i2) {
                this.bOT |= 128;
                this.Tzq = i2;
                return this;
            }

            private b auN(int i2) {
                this.bOT |= 256;
                this.Tzr = i2;
                return this;
            }

            private b l(p pVar) {
                AppMethodBeat.i(58842);
                if ((this.bOT & 512) != 512 || this.Tzs == p.hGS()) {
                    this.Tzs = pVar;
                } else {
                    this.Tzs = p.f(this.Tzs).j(pVar).hHo();
                }
                this.bOT |= 512;
                AppMethodBeat.o(58842);
                return this;
            }

            private b auO(int i2) {
                this.bOT |= 1024;
                this.Tzt = i2;
                return this;
            }

            private b m(p pVar) {
                AppMethodBeat.i(58843);
                if ((this.bOT & 2048) != 2048 || this.Tzu == p.hGS()) {
                    this.Tzu = pVar;
                } else {
                    this.Tzu = p.f(this.Tzu).j(pVar).hHo();
                }
                this.bOT |= 2048;
                AppMethodBeat.o(58843);
                return this;
            }

            private b auP(int i2) {
                this.bOT |= 4096;
                this.Tzv = i2;
                return this;
            }

            private b auQ(int i2) {
                this.bOT |= 8192;
                this.Txb = i2;
                return this;
            }

            private b hHm() {
                AppMethodBeat.i(58834);
                b j2 = new b().j(hHo());
                AppMethodBeat.o(58834);
                return j2;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                AppMethodBeat.i(58838);
                for (int i2 = 0; i2 < this.TwN.size(); i2++) {
                    if (!this.TwN.get(i2).isInitialized()) {
                        AppMethodBeat.o(58838);
                        return false;
                    }
                }
                if (!((this.bOT & 8) == 8) || this.Tzm.isInitialized()) {
                    if (!((this.bOT & 512) == 512) || this.Tzs.isInitialized()) {
                        if (((this.bOT & 2048) == 2048) && !this.Tzu.isInitialized()) {
                            AppMethodBeat.o(58838);
                            return false;
                        } else if (!this.TDA.isInitialized()) {
                            AppMethodBeat.o(58838);
                            return false;
                        } else {
                            AppMethodBeat.o(58838);
                            return true;
                        }
                    } else {
                        AppMethodBeat.o(58838);
                        return false;
                    }
                } else {
                    AppMethodBeat.o(58838);
                    return false;
                }
            }

            @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                AppMethodBeat.i(58845);
                p hGS = p.hGS();
                AppMethodBeat.o(58845);
                return hGS;
            }

            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ kotlin.l.b.a.b.h.i hED() {
                AppMethodBeat.i(58846);
                p hGS = p.hGS();
                AppMethodBeat.o(58846);
                return hGS;
            }

            static /* synthetic */ b hHp() {
                AppMethodBeat.i(58854);
                b bVar = new b();
                AppMethodBeat.o(58854);
                return bVar;
            }
        }

        public static b f(p pVar) {
            AppMethodBeat.i(258555);
            b j2 = b.hHp().j(pVar);
            AppMethodBeat.o(258555);
            return j2;
        }

        public final b hHf() {
            AppMethodBeat.i(258556);
            b j2 = b.hHp().j(this);
            AppMethodBeat.o(258556);
            return j2;
        }

        @Override // kotlin.l.b.a.b.h.r
        public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
            return Tzj;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEx() {
            AppMethodBeat.i(58864);
            b hHp = b.hHp();
            AppMethodBeat.o(58864);
            return hHp;
        }
    }

    public static final class r extends i.c<r> implements u {
        public static kotlin.l.b.a.b.h.s<r> TwL = new kotlin.l.b.a.b.h.b<r>() {
            /* class kotlin.l.b.a.b.e.a.r.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.h.s
            public final /* synthetic */ Object a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58898);
                r rVar = new r(eVar, gVar, (byte) 0);
                AppMethodBeat.o(58898);
                return rVar;
            }
        };
        private static final r TzL;
        private final kotlin.l.b.a.b.h.d TwK;
        public int TwM;
        public int Tyk;
        public boolean TzM;
        public b TzN;
        public List<p> TzO;
        public List<Integer> TzP;
        private int TzQ;
        private int bOT;
        private byte bPe;
        private int bVY;

        /* synthetic */ r(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar, byte b2) {
            this(eVar, gVar);
        }

        /* synthetic */ r(i.b bVar, byte b2) {
            this(bVar);
        }

        private r(i.b<r, ?> bVar) {
            super(bVar);
            this.TzQ = -1;
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = bVar.TwK;
        }

        private r() {
            this.TzQ = -1;
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = kotlin.l.b.a.b.h.d.TDp;
        }

        public static r hHz() {
            return TzL;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v32, resolved type: java.util.List<kotlin.l.b.a.b.e.a$p> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x005f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private r(kotlin.l.b.a.b.h.e r12, kotlin.l.b.a.b.h.g r13) {
            /*
            // Method dump skipped, instructions count: 436
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.r.<init>(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):void");
        }

        static {
            AppMethodBeat.i(58930);
            r rVar = new r();
            TzL = rVar;
            rVar.hEu();
            AppMethodBeat.o(58930);
        }

        @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
        public final kotlin.l.b.a.b.h.s<r> hEs() {
            return TwL;
        }

        public enum b implements j.a {
            IN(0),
            OUT(1),
            INV(2);
            
            private static j.b<b> Txp = new j.b<b>() {
                /* class kotlin.l.b.a.b.e.a.r.b.AnonymousClass1 */

                /* Return type fixed from 'kotlin.l.b.a.b.h.j$a' to match base method */
                @Override // kotlin.l.b.a.b.h.j.b
                public final /* synthetic */ b aua(int i2) {
                    AppMethodBeat.i(58919);
                    b auX = b.auX(i2);
                    AppMethodBeat.o(58919);
                    return auX;
                }
            };
            final int value;

            public static b valueOf(String str) {
                AppMethodBeat.i(58921);
                b bVar = (b) Enum.valueOf(b.class, str);
                AppMethodBeat.o(58921);
                return bVar;
            }

            static {
                AppMethodBeat.i(58922);
                AppMethodBeat.o(58922);
            }

            @Override // kotlin.l.b.a.b.h.j.a
            public final int getNumber() {
                return this.value;
            }

            public static b auX(int i2) {
                switch (i2) {
                    case 0:
                        return IN;
                    case 1:
                        return OUT;
                    case 2:
                        return INV;
                    default:
                        return null;
                }
            }

            private b(int i2) {
                this.value = i2;
            }
        }

        public final boolean hEt() {
            return (this.bOT & 1) == 1;
        }

        public final boolean Az() {
            return (this.bOT & 2) == 2;
        }

        public final boolean hHA() {
            return (this.bOT & 4) == 4;
        }

        public final boolean hHB() {
            return (this.bOT & 8) == 8;
        }

        private void hEu() {
            AppMethodBeat.i(58924);
            this.TwM = 0;
            this.Tyk = 0;
            this.TzM = false;
            this.TzN = b.INV;
            this.TzO = Collections.emptyList();
            this.TzP = Collections.emptyList();
            AppMethodBeat.o(58924);
        }

        @Override // kotlin.l.b.a.b.h.r
        public final boolean isInitialized() {
            AppMethodBeat.i(58925);
            byte b2 = this.bPe;
            if (b2 == 1) {
                AppMethodBeat.o(58925);
                return true;
            } else if (b2 == 0) {
                AppMethodBeat.o(58925);
                return false;
            } else if (!hEt()) {
                this.bPe = 0;
                AppMethodBeat.o(58925);
                return false;
            } else if (!Az()) {
                this.bPe = 0;
                AppMethodBeat.o(58925);
                return false;
            } else {
                for (int i2 = 0; i2 < this.TzO.size(); i2++) {
                    if (!this.TzO.get(i2).isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58925);
                        return false;
                    }
                }
                if (!this.TDA.isInitialized()) {
                    this.bPe = 0;
                    AppMethodBeat.o(58925);
                    return false;
                }
                this.bPe = 1;
                AppMethodBeat.o(58925);
                return true;
            }
        }

        @Override // kotlin.l.b.a.b.h.q
        public final void a(kotlin.l.b.a.b.h.f fVar) {
            AppMethodBeat.i(58926);
            yC();
            i.c<MessageType>.a hJC = hJC();
            if ((this.bOT & 1) == 1) {
                fVar.bs(1, this.TwM);
            }
            if ((this.bOT & 2) == 2) {
                fVar.bs(2, this.Tyk);
            }
            if ((this.bOT & 4) == 4) {
                fVar.EJ(this.TzM);
            }
            if ((this.bOT & 8) == 8) {
                fVar.nb(4, this.TzN.value);
            }
            for (int i2 = 0; i2 < this.TzO.size(); i2++) {
                fVar.a(5, this.TzO.get(i2));
            }
            if (this.TzP.size() > 0) {
                fVar.hc(50);
                fVar.hc(this.TzQ);
            }
            for (int i3 = 0; i3 < this.TzP.size(); i3++) {
                fVar.fK(this.TzP.get(i3).intValue());
            }
            hJC.b(1000, fVar);
            fVar.e(this.TwK);
            AppMethodBeat.o(58926);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final int yC() {
            AppMethodBeat.i(58927);
            int i2 = this.bVY;
            if (i2 != -1) {
                AppMethodBeat.o(58927);
                return i2;
            }
            int bu = (this.bOT & 1) == 1 ? kotlin.l.b.a.b.h.f.bu(1, this.TwM) + 0 : 0;
            if ((this.bOT & 2) == 2) {
                bu += kotlin.l.b.a.b.h.f.bu(2, this.Tyk);
            }
            if ((this.bOT & 4) == 4) {
                bu += kotlin.l.b.a.b.h.f.fS(3) + 1;
            }
            if ((this.bOT & 8) == 8) {
                bu += kotlin.l.b.a.b.h.f.bv(4, this.TzN.value);
            }
            int i3 = bu;
            for (int i4 = 0; i4 < this.TzO.size(); i4++) {
                i3 += kotlin.l.b.a.b.h.f.c(5, this.TzO.get(i4));
            }
            int i5 = 0;
            int i6 = 0;
            while (i5 < this.TzP.size()) {
                i5++;
                i6 = kotlin.l.b.a.b.h.f.fT(this.TzP.get(i5).intValue()) + i6;
            }
            int i7 = i3 + i6;
            if (!this.TzP.isEmpty()) {
                i7 = i7 + 1 + kotlin.l.b.a.b.h.f.fT(i6);
            }
            this.TzQ = i6;
            int yC = i7 + this.TDA.yC() + this.TwK.size();
            this.bVY = yC;
            AppMethodBeat.o(58927);
            return yC;
        }

        /* renamed from: kotlin.l.b.a.b.e.a$r$a  reason: collision with other inner class name */
        public static final class C2323a extends i.b<r, C2323a> implements u {
            private int TwM;
            private int Tyk;
            private boolean TzM;
            private b TzN = b.INV;
            private List<p> TzO = Collections.emptyList();
            private List<Integer> TzP = Collections.emptyList();
            private int bOT;

            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ i.a a(kotlin.l.b.a.b.h.i iVar) {
                AppMethodBeat.i(58911);
                C2323a d2 = d((r) iVar);
                AppMethodBeat.o(58911);
                return d2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
            public final /* synthetic */ a.AbstractC2337a c(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58913);
                C2323a w = w(eVar, gVar);
                AppMethodBeat.o(58913);
                return w;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a, java.lang.Object
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(58917);
                C2323a hHC = hHC();
                AppMethodBeat.o(58917);
                return hHC;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q.a d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58915);
                C2323a w = w(eVar, gVar);
                AppMethodBeat.o(58915);
                return w;
            }

            @Override // kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ i.a hEE() {
                AppMethodBeat.i(58912);
                C2323a hHC = hHC();
                AppMethodBeat.o(58912);
                return hHC;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ a.AbstractC2337a hEF() {
                AppMethodBeat.i(58914);
                C2323a hHC = hHC();
                AppMethodBeat.o(58914);
                return hHC;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$b' to match base method */
            @Override // kotlin.l.b.a.b.h.i.b
            public final /* synthetic */ C2323a hFq() {
                AppMethodBeat.i(58908);
                C2323a hHC = hHC();
                AppMethodBeat.o(58908);
                return hHC;
            }

            private C2323a() {
                AppMethodBeat.i(58899);
                AppMethodBeat.o(58899);
            }

            private r hHD() {
                int i2 = 1;
                AppMethodBeat.i(58901);
                r rVar = new r(this, (byte) 0);
                int i3 = this.bOT;
                if ((i3 & 1) != 1) {
                    i2 = 0;
                }
                rVar.TwM = this.TwM;
                if ((i3 & 2) == 2) {
                    i2 |= 2;
                }
                rVar.Tyk = this.Tyk;
                if ((i3 & 4) == 4) {
                    i2 |= 4;
                }
                rVar.TzM = this.TzM;
                if ((i3 & 8) == 8) {
                    i2 |= 8;
                }
                rVar.TzN = this.TzN;
                if ((this.bOT & 16) == 16) {
                    this.TzO = Collections.unmodifiableList(this.TzO);
                    this.bOT &= -17;
                }
                rVar.TzO = this.TzO;
                if ((this.bOT & 32) == 32) {
                    this.TzP = Collections.unmodifiableList(this.TzP);
                    this.bOT &= -33;
                }
                rVar.TzP = this.TzP;
                rVar.bOT = i2;
                AppMethodBeat.o(58901);
                return rVar;
            }

            public final C2323a d(r rVar) {
                AppMethodBeat.i(58902);
                if (rVar == r.hHz()) {
                    AppMethodBeat.o(58902);
                } else {
                    if (rVar.hEt()) {
                        auV(rVar.TwM);
                    }
                    if (rVar.Az()) {
                        auW(rVar.Tyk);
                    }
                    if (rVar.hHA()) {
                        EI(rVar.TzM);
                    }
                    if (rVar.hHB()) {
                        a(rVar.TzN);
                    }
                    if (!rVar.TzO.isEmpty()) {
                        if (this.TzO.isEmpty()) {
                            this.TzO = rVar.TzO;
                            this.bOT &= -17;
                        } else {
                            hHE();
                            this.TzO.addAll(rVar.TzO);
                        }
                    }
                    if (!rVar.TzP.isEmpty()) {
                        if (this.TzP.isEmpty()) {
                            this.TzP = rVar.TzP;
                            this.bOT &= -33;
                        } else {
                            hHF();
                            this.TzP.addAll(rVar.TzP);
                        }
                    }
                    a((i.c) rVar);
                    this.TwK = this.TwK.a(rVar.TwK);
                    AppMethodBeat.o(58902);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private kotlin.l.b.a.b.e.a.r.C2323a w(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                /*
                    r4 = this;
                    r3 = 58904(0xe618, float:8.2542E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    r2 = 0
                    kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.a$r> r0 = kotlin.l.b.a.b.e.a.r.TwL     // Catch:{ k -> 0x0016 }
                    java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                    kotlin.l.b.a.b.e.a$r r0 = (kotlin.l.b.a.b.e.a.r) r0     // Catch:{ k -> 0x0016 }
                    r4.d(r0)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return r4
                L_0x0016:
                    r0 = move-exception
                    r1 = r0
                    kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                    kotlin.l.b.a.b.e.a$r r0 = (kotlin.l.b.a.b.e.a.r) r0     // Catch:{ all -> 0x002e }
                    r2 = 58904(0xe618, float:8.2542E-41)
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.r.C2323a.w(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.a$r$a");
            }

            private C2323a auV(int i2) {
                this.bOT |= 1;
                this.TwM = i2;
                return this;
            }

            private C2323a auW(int i2) {
                this.bOT |= 2;
                this.Tyk = i2;
                return this;
            }

            private C2323a EI(boolean z) {
                this.bOT |= 4;
                this.TzM = z;
                return this;
            }

            private C2323a a(b bVar) {
                AppMethodBeat.i(58905);
                if (bVar == null) {
                    NullPointerException nullPointerException = new NullPointerException();
                    AppMethodBeat.o(58905);
                    throw nullPointerException;
                }
                this.bOT |= 8;
                this.TzN = bVar;
                AppMethodBeat.o(58905);
                return this;
            }

            private void hHE() {
                AppMethodBeat.i(58906);
                if ((this.bOT & 16) != 16) {
                    this.TzO = new ArrayList(this.TzO);
                    this.bOT |= 16;
                }
                AppMethodBeat.o(58906);
            }

            private void hHF() {
                AppMethodBeat.i(58907);
                if ((this.bOT & 32) != 32) {
                    this.TzP = new ArrayList(this.TzP);
                    this.bOT |= 32;
                }
                AppMethodBeat.o(58907);
            }

            private C2323a hHC() {
                AppMethodBeat.i(58900);
                C2323a d2 = new C2323a().d(hHD());
                AppMethodBeat.o(58900);
                return d2;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                AppMethodBeat.i(58903);
                if (!((this.bOT & 1) == 1)) {
                    AppMethodBeat.o(58903);
                    return false;
                }
                if (!((this.bOT & 2) == 2)) {
                    AppMethodBeat.o(58903);
                    return false;
                }
                for (int i2 = 0; i2 < this.TzO.size(); i2++) {
                    if (!this.TzO.get(i2).isInitialized()) {
                        AppMethodBeat.o(58903);
                        return false;
                    }
                }
                if (!this.TDA.isInitialized()) {
                    AppMethodBeat.o(58903);
                    return false;
                }
                AppMethodBeat.o(58903);
                return true;
            }

            @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                AppMethodBeat.i(58909);
                r hHz = r.hHz();
                AppMethodBeat.o(58909);
                return hHz;
            }

            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ kotlin.l.b.a.b.h.i hED() {
                AppMethodBeat.i(58910);
                r hHz = r.hHz();
                AppMethodBeat.o(58910);
                return hHz;
            }

            @Override // kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEG() {
                AppMethodBeat.i(58916);
                r hHD = hHD();
                if (!hHD.isInitialized()) {
                    kotlin.l.b.a.b.h.w wVar = new kotlin.l.b.a.b.h.w();
                    AppMethodBeat.o(58916);
                    throw wVar;
                }
                AppMethodBeat.o(58916);
                return hHD;
            }

            static /* synthetic */ C2323a hHG() {
                AppMethodBeat.i(58918);
                C2323a aVar = new C2323a();
                AppMethodBeat.o(58918);
                return aVar;
            }
        }

        @Override // kotlin.l.b.a.b.h.r
        public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
            return TzL;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEw() {
            AppMethodBeat.i(58928);
            C2323a d2 = C2323a.hHG().d(this);
            AppMethodBeat.o(58928);
            return d2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEx() {
            AppMethodBeat.i(58929);
            C2323a hHG = C2323a.hHG();
            AppMethodBeat.o(58929);
            return hHG;
        }
    }

    public static final class b extends i.c<b> implements e {
        public static kotlin.l.b.a.b.h.s<b> TwL = new kotlin.l.b.a.b.h.b<b>() {
            /* class kotlin.l.b.a.b.e.a.b.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.h.s
            public final /* synthetic */ Object a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58391);
                b bVar = new b(eVar, gVar, (byte) 0);
                AppMethodBeat.o(58391);
                return bVar;
            }
        };
        private static final b Txr;
        private final kotlin.l.b.a.b.h.d TwK;
        public List<c> TxA;
        public List<h> TxB;
        public List<m> TxC;
        public List<q> TxD;
        public List<f> TxE;
        public List<Integer> TxF;
        private int TxG;
        public s TxH;
        public List<Integer> TxI;
        public v TxJ;
        public int Txb;
        public int Txs;
        public int Txt;
        public List<r> Txu;
        public List<p> Txv;
        public List<Integer> Txw;
        private int Txx;
        public List<Integer> Txy;
        private int Txz;
        private int bOT;
        private byte bPe;
        private int bVY;

        /* synthetic */ b(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar, byte b2) {
            this(eVar, gVar);
        }

        /* synthetic */ b(i.b bVar, byte b2) {
            this(bVar);
        }

        private b(i.b<b, ?> bVar) {
            super(bVar);
            this.Txx = -1;
            this.Txz = -1;
            this.TxG = -1;
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = bVar.TwK;
        }

        private b() {
            this.Txx = -1;
            this.Txz = -1;
            this.TxG = -1;
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = kotlin.l.b.a.b.h.d.TDp;
        }

        public static b hEY() {
            return Txr;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v79, resolved type: java.util.List<kotlin.l.b.a.b.e.a$f> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v82, resolved type: java.util.List<kotlin.l.b.a.b.e.a$q> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v85, resolved type: java.util.List<kotlin.l.b.a.b.e.a$m> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v88, resolved type: java.util.List<kotlin.l.b.a.b.e.a$h> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v91, resolved type: java.util.List<kotlin.l.b.a.b.e.a$c> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v99, resolved type: java.util.List<kotlin.l.b.a.b.e.a$p> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v102, resolved type: java.util.List<kotlin.l.b.a.b.e.a$r> */
        /* JADX WARN: Multi-variable type inference failed */
        private b(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
            v.C2327a aVar;
            s.C2324a aVar2;
            AppMethodBeat.i(58426);
            this.Txx = -1;
            this.Txz = -1;
            this.TxG = -1;
            this.bPe = -1;
            this.bVY = -1;
            hEu();
            boolean z = false;
            d.b hJo = kotlin.l.b.a.b.h.d.hJo();
            kotlin.l.b.a.b.h.f f2 = kotlin.l.b.a.b.h.f.f(hJo, 1);
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
                            this.Txb = eVar.zi();
                            break;
                        case 16:
                            if (!(z & true)) {
                                this.Txw = new ArrayList();
                                z |= true;
                            }
                            this.Txw.add(Integer.valueOf(eVar.zi()));
                            break;
                        case 18:
                            int fH = eVar.fH(eVar.zi());
                            if (!(z & true) && eVar.zk() > 0) {
                                this.Txw = new ArrayList();
                                z |= true;
                            }
                            while (eVar.zk() > 0) {
                                this.Txw.add(Integer.valueOf(eVar.zi()));
                            }
                            eVar.fI(fH);
                            break;
                        case 24:
                            this.bOT |= 2;
                            this.Txs = eVar.zi();
                            break;
                        case 32:
                            this.bOT |= 4;
                            this.Txt = eVar.zi();
                            break;
                        case 42:
                            if (!(z & true)) {
                                this.Txu = new ArrayList();
                                z |= true;
                            }
                            this.Txu.add(eVar.a(r.TwL, gVar));
                            break;
                        case 50:
                            if (!(z & true)) {
                                this.Txv = new ArrayList();
                                z |= true;
                            }
                            this.Txv.add(eVar.a(p.TwL, gVar));
                            break;
                        case 56:
                            if (!(z & true)) {
                                this.Txy = new ArrayList();
                                z |= true;
                            }
                            this.Txy.add(Integer.valueOf(eVar.zi()));
                            break;
                        case 58:
                            int fH2 = eVar.fH(eVar.zi());
                            if (!(z & true) && eVar.zk() > 0) {
                                this.Txy = new ArrayList();
                                z |= true;
                            }
                            while (eVar.zk() > 0) {
                                this.Txy.add(Integer.valueOf(eVar.zi()));
                            }
                            eVar.fI(fH2);
                            break;
                        case 66:
                            if (!(z & true)) {
                                this.TxA = new ArrayList();
                                z |= true;
                            }
                            this.TxA.add(eVar.a(c.TwL, gVar));
                            break;
                        case 74:
                            if (!(z & true)) {
                                this.TxB = new ArrayList();
                                z |= true;
                            }
                            this.TxB.add(eVar.a(h.TwL, gVar));
                            break;
                        case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE:
                            if (!(z & true)) {
                                this.TxC = new ArrayList();
                                z |= true;
                            }
                            this.TxC.add(eVar.a(m.TwL, gVar));
                            break;
                        case 90:
                            if (!(z & true)) {
                                this.TxD = new ArrayList();
                                z |= true;
                            }
                            this.TxD.add(eVar.a(q.TwL, gVar));
                            break;
                        case 106:
                            if (!(z & true)) {
                                this.TxE = new ArrayList();
                                z |= true;
                            }
                            this.TxE.add(eVar.a(f.TwL, gVar));
                            break;
                        case 128:
                            if (!(z & true)) {
                                this.TxF = new ArrayList();
                                z |= true;
                            }
                            this.TxF.add(Integer.valueOf(eVar.zi()));
                            break;
                        case 130:
                            int fH3 = eVar.fH(eVar.zi());
                            if (!(z & true) && eVar.zk() > 0) {
                                this.TxF = new ArrayList();
                                z |= true;
                            }
                            while (eVar.zk() > 0) {
                                this.TxF.add(Integer.valueOf(eVar.zi()));
                            }
                            eVar.fI(fH3);
                            break;
                        case 242:
                            if ((this.bOT & 8) == 8) {
                                aVar2 = s.d(this.TxH);
                            } else {
                                aVar2 = null;
                            }
                            this.TxH = (s) eVar.a(s.TwL, gVar);
                            if (aVar2 != null) {
                                aVar2.g(this.TxH);
                                this.TxH = aVar2.hHK();
                            }
                            this.bOT |= 8;
                            break;
                        case 248:
                            if (!(z & true)) {
                                this.TxI = new ArrayList();
                                z |= true;
                            }
                            this.TxI.add(Integer.valueOf(eVar.zi()));
                            break;
                        case 250:
                            int fH4 = eVar.fH(eVar.zi());
                            if (!(z & true) && eVar.zk() > 0) {
                                this.TxI = new ArrayList();
                                z |= true;
                            }
                            while (eVar.zk() > 0) {
                                this.TxI.add(Integer.valueOf(eVar.zi()));
                            }
                            eVar.fI(fH4);
                            break;
                        case CdnLogic.kAppTypeFestivalVideo:
                            if ((this.bOT & 16) == 16) {
                                aVar = v.c(this.TxJ);
                            } else {
                                aVar = null;
                            }
                            this.TxJ = (v) eVar.a(v.TwL, gVar);
                            if (aVar != null) {
                                aVar.f(this.TxJ);
                                this.TxJ = aVar.hIf();
                            }
                            this.bOT |= 16;
                            break;
                        default:
                            if (a(eVar, f2, gVar, yT)) {
                                break;
                            } else {
                                z2 = true;
                                break;
                            }
                    }
                } catch (kotlin.l.b.a.b.h.k e2) {
                    e2.TDK = this;
                    AppMethodBeat.o(58426);
                    throw e2;
                } catch (IOException e3) {
                    kotlin.l.b.a.b.h.k kVar = new kotlin.l.b.a.b.h.k(e3.getMessage());
                    kVar.TDK = this;
                    AppMethodBeat.o(58426);
                    throw kVar;
                } catch (Throwable th) {
                    if (z & true) {
                        this.Txw = Collections.unmodifiableList(this.Txw);
                    }
                    if (z & true) {
                        this.Txu = Collections.unmodifiableList(this.Txu);
                    }
                    if (z & true) {
                        this.Txv = Collections.unmodifiableList(this.Txv);
                    }
                    if (z & true) {
                        this.Txy = Collections.unmodifiableList(this.Txy);
                    }
                    if (z & true) {
                        this.TxA = Collections.unmodifiableList(this.TxA);
                    }
                    if (z & true) {
                        this.TxB = Collections.unmodifiableList(this.TxB);
                    }
                    if (z & true) {
                        this.TxC = Collections.unmodifiableList(this.TxC);
                    }
                    if (z & true) {
                        this.TxD = Collections.unmodifiableList(this.TxD);
                    }
                    if (z & true) {
                        this.TxE = Collections.unmodifiableList(this.TxE);
                    }
                    if (z & true) {
                        this.TxF = Collections.unmodifiableList(this.TxF);
                    }
                    if (z & true) {
                        this.TxI = Collections.unmodifiableList(this.TxI);
                    }
                    try {
                        f2.flush();
                        this.TwK = hJo.hJs();
                    } catch (IOException e4) {
                        this.TwK = hJo.hJs();
                    } catch (Throwable th2) {
                        this.TwK = hJo.hJs();
                        AppMethodBeat.o(58426);
                        throw th2;
                    }
                    this.TDA.yK();
                    AppMethodBeat.o(58426);
                    throw th;
                }
            }
            if (z & true) {
                this.Txw = Collections.unmodifiableList(this.Txw);
            }
            if (z & true) {
                this.Txu = Collections.unmodifiableList(this.Txu);
            }
            if (z & true) {
                this.Txv = Collections.unmodifiableList(this.Txv);
            }
            if (z & true) {
                this.Txy = Collections.unmodifiableList(this.Txy);
            }
            if (z & true) {
                this.TxA = Collections.unmodifiableList(this.TxA);
            }
            if (z & true) {
                this.TxB = Collections.unmodifiableList(this.TxB);
            }
            if (z & true) {
                this.TxC = Collections.unmodifiableList(this.TxC);
            }
            if (z & true) {
                this.TxD = Collections.unmodifiableList(this.TxD);
            }
            if (z & true) {
                this.TxE = Collections.unmodifiableList(this.TxE);
            }
            if (z & true) {
                this.TxF = Collections.unmodifiableList(this.TxF);
            }
            if (z & true) {
                this.TxI = Collections.unmodifiableList(this.TxI);
            }
            try {
                f2.flush();
                this.TwK = hJo.hJs();
            } catch (IOException e5) {
                this.TwK = hJo.hJs();
            } catch (Throwable th3) {
                this.TwK = hJo.hJs();
                AppMethodBeat.o(58426);
                throw th3;
            }
            this.TDA.yK();
            AppMethodBeat.o(58426);
        }

        static {
            AppMethodBeat.i(58434);
            b bVar = new b();
            Txr = bVar;
            bVar.hEu();
            AppMethodBeat.o(58434);
        }

        @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
        public final kotlin.l.b.a.b.h.s<b> hEs() {
            return TwL;
        }

        /* renamed from: kotlin.l.b.a.b.e.a$b$b  reason: collision with other inner class name */
        public enum EnumC2306b implements j.a {
            CLASS(0),
            INTERFACE(1),
            ENUM_CLASS(2),
            ENUM_ENTRY(3),
            ANNOTATION_CLASS(4),
            OBJECT(5),
            COMPANION_OBJECT(6);
            
            private static j.b<EnumC2306b> Txp = new j.b<EnumC2306b>() {
                /* class kotlin.l.b.a.b.e.a.b.EnumC2306b.AnonymousClass1 */

                /* Return type fixed from 'kotlin.l.b.a.b.h.j$a' to match base method */
                @Override // kotlin.l.b.a.b.h.j.b
                public final /* synthetic */ EnumC2306b aua(int i2) {
                    AppMethodBeat.i(58422);
                    EnumC2306b auf = EnumC2306b.auf(i2);
                    AppMethodBeat.o(58422);
                    return auf;
                }
            };
            private final int value;

            public static EnumC2306b valueOf(String str) {
                AppMethodBeat.i(58424);
                EnumC2306b bVar = (EnumC2306b) Enum.valueOf(EnumC2306b.class, str);
                AppMethodBeat.o(58424);
                return bVar;
            }

            static {
                AppMethodBeat.i(58425);
                AppMethodBeat.o(58425);
            }

            @Override // kotlin.l.b.a.b.h.j.a
            public final int getNumber() {
                return this.value;
            }

            public static EnumC2306b auf(int i2) {
                switch (i2) {
                    case 0:
                        return CLASS;
                    case 1:
                        return INTERFACE;
                    case 2:
                        return ENUM_CLASS;
                    case 3:
                        return ENUM_ENTRY;
                    case 4:
                        return ANNOTATION_CLASS;
                    case 5:
                        return OBJECT;
                    case 6:
                        return COMPANION_OBJECT;
                    default:
                        return null;
                }
            }

            private EnumC2306b(int i2) {
                this.value = i2;
            }
        }

        public final boolean hEP() {
            return (this.bOT & 1) == 1;
        }

        public final boolean hEZ() {
            return (this.bOT & 2) == 2;
        }

        public final boolean hFa() {
            return (this.bOT & 4) == 4;
        }

        public final boolean hFb() {
            return (this.bOT & 8) == 8;
        }

        public final boolean hFc() {
            return (this.bOT & 16) == 16;
        }

        private void hEu() {
            AppMethodBeat.i(58427);
            this.Txb = 6;
            this.Txs = 0;
            this.Txt = 0;
            this.Txu = Collections.emptyList();
            this.Txv = Collections.emptyList();
            this.Txw = Collections.emptyList();
            this.Txy = Collections.emptyList();
            this.TxA = Collections.emptyList();
            this.TxB = Collections.emptyList();
            this.TxC = Collections.emptyList();
            this.TxD = Collections.emptyList();
            this.TxE = Collections.emptyList();
            this.TxF = Collections.emptyList();
            this.TxH = s.hHH();
            this.TxI = Collections.emptyList();
            this.TxJ = v.hId();
            AppMethodBeat.o(58427);
        }

        @Override // kotlin.l.b.a.b.h.r
        public final boolean isInitialized() {
            AppMethodBeat.i(58428);
            byte b2 = this.bPe;
            if (b2 == 1) {
                AppMethodBeat.o(58428);
                return true;
            } else if (b2 == 0) {
                AppMethodBeat.o(58428);
                return false;
            } else if (!hEZ()) {
                this.bPe = 0;
                AppMethodBeat.o(58428);
                return false;
            } else {
                for (int i2 = 0; i2 < this.Txu.size(); i2++) {
                    if (!this.Txu.get(i2).isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58428);
                        return false;
                    }
                }
                for (int i3 = 0; i3 < this.Txv.size(); i3++) {
                    if (!this.Txv.get(i3).isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58428);
                        return false;
                    }
                }
                for (int i4 = 0; i4 < this.TxA.size(); i4++) {
                    if (!this.TxA.get(i4).isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58428);
                        return false;
                    }
                }
                for (int i5 = 0; i5 < this.TxB.size(); i5++) {
                    if (!this.TxB.get(i5).isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58428);
                        return false;
                    }
                }
                for (int i6 = 0; i6 < this.TxC.size(); i6++) {
                    if (!this.TxC.get(i6).isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58428);
                        return false;
                    }
                }
                for (int i7 = 0; i7 < this.TxD.size(); i7++) {
                    if (!this.TxD.get(i7).isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58428);
                        return false;
                    }
                }
                for (int i8 = 0; i8 < this.TxE.size(); i8++) {
                    if (!this.TxE.get(i8).isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58428);
                        return false;
                    }
                }
                if (hFb() && !this.TxH.isInitialized()) {
                    this.bPe = 0;
                    AppMethodBeat.o(58428);
                    return false;
                } else if (!this.TDA.isInitialized()) {
                    this.bPe = 0;
                    AppMethodBeat.o(58428);
                    return false;
                } else {
                    this.bPe = 1;
                    AppMethodBeat.o(58428);
                    return true;
                }
            }
        }

        @Override // kotlin.l.b.a.b.h.q
        public final void a(kotlin.l.b.a.b.h.f fVar) {
            AppMethodBeat.i(58429);
            yC();
            i.c<MessageType>.a hJC = hJC();
            if ((this.bOT & 1) == 1) {
                fVar.bs(1, this.Txb);
            }
            if (this.Txw.size() > 0) {
                fVar.hc(18);
                fVar.hc(this.Txx);
            }
            for (int i2 = 0; i2 < this.Txw.size(); i2++) {
                fVar.fK(this.Txw.get(i2).intValue());
            }
            if ((this.bOT & 2) == 2) {
                fVar.bs(3, this.Txs);
            }
            if ((this.bOT & 4) == 4) {
                fVar.bs(4, this.Txt);
            }
            for (int i3 = 0; i3 < this.Txu.size(); i3++) {
                fVar.a(5, this.Txu.get(i3));
            }
            for (int i4 = 0; i4 < this.Txv.size(); i4++) {
                fVar.a(6, this.Txv.get(i4));
            }
            if (this.Txy.size() > 0) {
                fVar.hc(58);
                fVar.hc(this.Txz);
            }
            for (int i5 = 0; i5 < this.Txy.size(); i5++) {
                fVar.fK(this.Txy.get(i5).intValue());
            }
            for (int i6 = 0; i6 < this.TxA.size(); i6++) {
                fVar.a(8, this.TxA.get(i6));
            }
            for (int i7 = 0; i7 < this.TxB.size(); i7++) {
                fVar.a(9, this.TxB.get(i7));
            }
            for (int i8 = 0; i8 < this.TxC.size(); i8++) {
                fVar.a(10, this.TxC.get(i8));
            }
            for (int i9 = 0; i9 < this.TxD.size(); i9++) {
                fVar.a(11, this.TxD.get(i9));
            }
            for (int i10 = 0; i10 < this.TxE.size(); i10++) {
                fVar.a(13, this.TxE.get(i10));
            }
            if (this.TxF.size() > 0) {
                fVar.hc(130);
                fVar.hc(this.TxG);
            }
            for (int i11 = 0; i11 < this.TxF.size(); i11++) {
                fVar.fK(this.TxF.get(i11).intValue());
            }
            if ((this.bOT & 8) == 8) {
                fVar.a(30, this.TxH);
            }
            for (int i12 = 0; i12 < this.TxI.size(); i12++) {
                fVar.bs(31, this.TxI.get(i12).intValue());
            }
            if ((this.bOT & 16) == 16) {
                fVar.a(32, this.TxJ);
            }
            hJC.b(19000, fVar);
            fVar.e(this.TwK);
            AppMethodBeat.o(58429);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final int yC() {
            int i2;
            AppMethodBeat.i(58430);
            int i3 = this.bVY;
            if (i3 != -1) {
                AppMethodBeat.o(58430);
                return i3;
            }
            int bu = (this.bOT & 1) == 1 ? kotlin.l.b.a.b.h.f.bu(1, this.Txb) + 0 : 0;
            int i4 = 0;
            for (int i5 = 0; i5 < this.Txw.size(); i5++) {
                i4 += kotlin.l.b.a.b.h.f.fT(this.Txw.get(i5).intValue());
            }
            int i6 = bu + i4;
            if (!this.Txw.isEmpty()) {
                i6 = i6 + 1 + kotlin.l.b.a.b.h.f.fT(i4);
            }
            this.Txx = i4;
            if ((this.bOT & 2) == 2) {
                i6 += kotlin.l.b.a.b.h.f.bu(3, this.Txs);
            }
            if ((this.bOT & 4) == 4) {
                i6 += kotlin.l.b.a.b.h.f.bu(4, this.Txt);
            }
            int i7 = i6;
            for (int i8 = 0; i8 < this.Txu.size(); i8++) {
                i7 += kotlin.l.b.a.b.h.f.c(5, this.Txu.get(i8));
            }
            for (int i9 = 0; i9 < this.Txv.size(); i9++) {
                i7 += kotlin.l.b.a.b.h.f.c(6, this.Txv.get(i9));
            }
            int i10 = 0;
            for (int i11 = 0; i11 < this.Txy.size(); i11++) {
                i10 += kotlin.l.b.a.b.h.f.fT(this.Txy.get(i11).intValue());
            }
            int i12 = i7 + i10;
            if (!this.Txy.isEmpty()) {
                i12 = i12 + 1 + kotlin.l.b.a.b.h.f.fT(i10);
            }
            this.Txz = i10;
            int i13 = i12;
            for (int i14 = 0; i14 < this.TxA.size(); i14++) {
                i13 += kotlin.l.b.a.b.h.f.c(8, this.TxA.get(i14));
            }
            for (int i15 = 0; i15 < this.TxB.size(); i15++) {
                i13 += kotlin.l.b.a.b.h.f.c(9, this.TxB.get(i15));
            }
            for (int i16 = 0; i16 < this.TxC.size(); i16++) {
                i13 += kotlin.l.b.a.b.h.f.c(10, this.TxC.get(i16));
            }
            for (int i17 = 0; i17 < this.TxD.size(); i17++) {
                i13 += kotlin.l.b.a.b.h.f.c(11, this.TxD.get(i17));
            }
            for (int i18 = 0; i18 < this.TxE.size(); i18++) {
                i13 += kotlin.l.b.a.b.h.f.c(13, this.TxE.get(i18));
            }
            int i19 = 0;
            for (int i20 = 0; i20 < this.TxF.size(); i20++) {
                i19 += kotlin.l.b.a.b.h.f.fT(this.TxF.get(i20).intValue());
            }
            int i21 = i13 + i19;
            if (!this.TxF.isEmpty()) {
                i21 = i21 + 2 + kotlin.l.b.a.b.h.f.fT(i19);
            }
            this.TxG = i19;
            if ((this.bOT & 8) == 8) {
                i2 = i21 + kotlin.l.b.a.b.h.f.c(30, this.TxH);
            } else {
                i2 = i21;
            }
            int i22 = 0;
            int i23 = 0;
            while (i22 < this.TxI.size()) {
                i22++;
                i23 = kotlin.l.b.a.b.h.f.fT(this.TxI.get(i22).intValue()) + i23;
            }
            int size = i2 + i23 + (this.TxI.size() * 2);
            if ((this.bOT & 16) == 16) {
                size += kotlin.l.b.a.b.h.f.c(32, this.TxJ);
            }
            int yC = size + this.TDA.yC() + this.TwK.size();
            this.bVY = yC;
            AppMethodBeat.o(58430);
            return yC;
        }

        public static b a(InputStream inputStream, kotlin.l.b.a.b.h.g gVar) {
            AppMethodBeat.i(58431);
            b j2 = TwL.j(inputStream, gVar);
            AppMethodBeat.o(58431);
            return j2;
        }

        /* renamed from: kotlin.l.b.a.b.e.a$b$a  reason: collision with other inner class name */
        public static final class C2305a extends i.b<b, C2305a> implements e {
            private List<c> TxA = Collections.emptyList();
            private List<h> TxB = Collections.emptyList();
            private List<m> TxC = Collections.emptyList();
            private List<q> TxD = Collections.emptyList();
            private List<f> TxE = Collections.emptyList();
            private List<Integer> TxF = Collections.emptyList();
            private s TxH = s.hHH();
            private List<Integer> TxI = Collections.emptyList();
            private v TxJ = v.hId();
            private int Txb = 6;
            private int Txs;
            private int Txt;
            private List<r> Txu = Collections.emptyList();
            private List<p> Txv = Collections.emptyList();
            private List<Integer> Txw = Collections.emptyList();
            private List<Integer> Txy = Collections.emptyList();
            private int bOT;

            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ i.a a(kotlin.l.b.a.b.h.i iVar) {
                AppMethodBeat.i(58414);
                C2305a m = m((b) iVar);
                AppMethodBeat.o(58414);
                return m;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
            public final /* synthetic */ a.AbstractC2337a c(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58416);
                C2305a g2 = g(eVar, gVar);
                AppMethodBeat.o(58416);
                return g2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a, java.lang.Object
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(58420);
                C2305a hFd = hFd();
                AppMethodBeat.o(58420);
                return hFd;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q.a d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58418);
                C2305a g2 = g(eVar, gVar);
                AppMethodBeat.o(58418);
                return g2;
            }

            @Override // kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ i.a hEE() {
                AppMethodBeat.i(58415);
                C2305a hFd = hFd();
                AppMethodBeat.o(58415);
                return hFd;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ a.AbstractC2337a hEF() {
                AppMethodBeat.i(58417);
                C2305a hFd = hFd();
                AppMethodBeat.o(58417);
                return hFd;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$b' to match base method */
            @Override // kotlin.l.b.a.b.h.i.b
            public final /* synthetic */ C2305a hFq() {
                AppMethodBeat.i(58411);
                C2305a hFd = hFd();
                AppMethodBeat.o(58411);
                return hFd;
            }

            private C2305a() {
                AppMethodBeat.i(58392);
                AppMethodBeat.o(58392);
            }

            private b hFe() {
                int i2 = 1;
                AppMethodBeat.i(58394);
                b bVar = new b(this, (byte) 0);
                int i3 = this.bOT;
                if ((i3 & 1) != 1) {
                    i2 = 0;
                }
                bVar.Txb = this.Txb;
                if ((i3 & 2) == 2) {
                    i2 |= 2;
                }
                bVar.Txs = this.Txs;
                if ((i3 & 4) == 4) {
                    i2 |= 4;
                }
                bVar.Txt = this.Txt;
                if ((this.bOT & 8) == 8) {
                    this.Txu = Collections.unmodifiableList(this.Txu);
                    this.bOT &= -9;
                }
                bVar.Txu = this.Txu;
                if ((this.bOT & 16) == 16) {
                    this.Txv = Collections.unmodifiableList(this.Txv);
                    this.bOT &= -17;
                }
                bVar.Txv = this.Txv;
                if ((this.bOT & 32) == 32) {
                    this.Txw = Collections.unmodifiableList(this.Txw);
                    this.bOT &= -33;
                }
                bVar.Txw = this.Txw;
                if ((this.bOT & 64) == 64) {
                    this.Txy = Collections.unmodifiableList(this.Txy);
                    this.bOT &= -65;
                }
                bVar.Txy = this.Txy;
                if ((this.bOT & 128) == 128) {
                    this.TxA = Collections.unmodifiableList(this.TxA);
                    this.bOT &= -129;
                }
                bVar.TxA = this.TxA;
                if ((this.bOT & 256) == 256) {
                    this.TxB = Collections.unmodifiableList(this.TxB);
                    this.bOT &= -257;
                }
                bVar.TxB = this.TxB;
                if ((this.bOT & 512) == 512) {
                    this.TxC = Collections.unmodifiableList(this.TxC);
                    this.bOT &= -513;
                }
                bVar.TxC = this.TxC;
                if ((this.bOT & 1024) == 1024) {
                    this.TxD = Collections.unmodifiableList(this.TxD);
                    this.bOT &= -1025;
                }
                bVar.TxD = this.TxD;
                if ((this.bOT & 2048) == 2048) {
                    this.TxE = Collections.unmodifiableList(this.TxE);
                    this.bOT &= -2049;
                }
                bVar.TxE = this.TxE;
                if ((this.bOT & 4096) == 4096) {
                    this.TxF = Collections.unmodifiableList(this.TxF);
                    this.bOT &= -4097;
                }
                bVar.TxF = this.TxF;
                if ((i3 & 8192) == 8192) {
                    i2 |= 8;
                }
                bVar.TxH = this.TxH;
                if ((this.bOT & 16384) == 16384) {
                    this.TxI = Collections.unmodifiableList(this.TxI);
                    this.bOT &= -16385;
                }
                bVar.TxI = this.TxI;
                if ((i3 & 32768) == 32768) {
                    i2 |= 16;
                }
                bVar.TxJ = this.TxJ;
                bVar.bOT = i2;
                AppMethodBeat.o(58394);
                return bVar;
            }

            public final C2305a m(b bVar) {
                AppMethodBeat.i(58395);
                if (bVar == b.hEY()) {
                    AppMethodBeat.o(58395);
                } else {
                    if (bVar.hEP()) {
                        auc(bVar.Txb);
                    }
                    if (bVar.hEZ()) {
                        aud(bVar.Txs);
                    }
                    if (bVar.hFa()) {
                        aue(bVar.Txt);
                    }
                    if (!bVar.Txu.isEmpty()) {
                        if (this.Txu.isEmpty()) {
                            this.Txu = bVar.Txu;
                            this.bOT &= -9;
                        } else {
                            hFf();
                            this.Txu.addAll(bVar.Txu);
                        }
                    }
                    if (!bVar.Txv.isEmpty()) {
                        if (this.Txv.isEmpty()) {
                            this.Txv = bVar.Txv;
                            this.bOT &= -17;
                        } else {
                            hFg();
                            this.Txv.addAll(bVar.Txv);
                        }
                    }
                    if (!bVar.Txw.isEmpty()) {
                        if (this.Txw.isEmpty()) {
                            this.Txw = bVar.Txw;
                            this.bOT &= -33;
                        } else {
                            hFh();
                            this.Txw.addAll(bVar.Txw);
                        }
                    }
                    if (!bVar.Txy.isEmpty()) {
                        if (this.Txy.isEmpty()) {
                            this.Txy = bVar.Txy;
                            this.bOT &= -65;
                        } else {
                            hFi();
                            this.Txy.addAll(bVar.Txy);
                        }
                    }
                    if (!bVar.TxA.isEmpty()) {
                        if (this.TxA.isEmpty()) {
                            this.TxA = bVar.TxA;
                            this.bOT &= -129;
                        } else {
                            hFj();
                            this.TxA.addAll(bVar.TxA);
                        }
                    }
                    if (!bVar.TxB.isEmpty()) {
                        if (this.TxB.isEmpty()) {
                            this.TxB = bVar.TxB;
                            this.bOT &= -257;
                        } else {
                            hFk();
                            this.TxB.addAll(bVar.TxB);
                        }
                    }
                    if (!bVar.TxC.isEmpty()) {
                        if (this.TxC.isEmpty()) {
                            this.TxC = bVar.TxC;
                            this.bOT &= -513;
                        } else {
                            hFl();
                            this.TxC.addAll(bVar.TxC);
                        }
                    }
                    if (!bVar.TxD.isEmpty()) {
                        if (this.TxD.isEmpty()) {
                            this.TxD = bVar.TxD;
                            this.bOT &= -1025;
                        } else {
                            hFm();
                            this.TxD.addAll(bVar.TxD);
                        }
                    }
                    if (!bVar.TxE.isEmpty()) {
                        if (this.TxE.isEmpty()) {
                            this.TxE = bVar.TxE;
                            this.bOT &= -2049;
                        } else {
                            hFn();
                            this.TxE.addAll(bVar.TxE);
                        }
                    }
                    if (!bVar.TxF.isEmpty()) {
                        if (this.TxF.isEmpty()) {
                            this.TxF = bVar.TxF;
                            this.bOT &= -4097;
                        } else {
                            hFo();
                            this.TxF.addAll(bVar.TxF);
                        }
                    }
                    if (bVar.hFb()) {
                        a(bVar.TxH);
                    }
                    if (!bVar.TxI.isEmpty()) {
                        if (this.TxI.isEmpty()) {
                            this.TxI = bVar.TxI;
                            this.bOT &= -16385;
                        } else {
                            hFp();
                            this.TxI.addAll(bVar.TxI);
                        }
                    }
                    if (bVar.hFc()) {
                        a(bVar.TxJ);
                    }
                    a((i.c) bVar);
                    this.TwK = this.TwK.a(bVar.TwK);
                    AppMethodBeat.o(58395);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private kotlin.l.b.a.b.e.a.b.C2305a g(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                /*
                    r4 = this;
                    r3 = 58397(0xe41d, float:8.1832E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    r2 = 0
                    kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.a$b> r0 = kotlin.l.b.a.b.e.a.b.TwL     // Catch:{ k -> 0x0016 }
                    java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                    kotlin.l.b.a.b.e.a$b r0 = (kotlin.l.b.a.b.e.a.b) r0     // Catch:{ k -> 0x0016 }
                    r4.m(r0)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return r4
                L_0x0016:
                    r0 = move-exception
                    r1 = r0
                    kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                    kotlin.l.b.a.b.e.a$b r0 = (kotlin.l.b.a.b.e.a.b) r0     // Catch:{ all -> 0x002e }
                    r2 = 58397(0xe41d, float:8.1832E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)     // Catch:{ all -> 0x0023 }
                    throw r1     // Catch:{ all -> 0x0023 }
                L_0x0023:
                    r1 = move-exception
                    r2 = r0
                L_0x0025:
                    if (r2 == 0) goto L_0x002a
                    r4.m(r2)
                L_0x002a:
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    throw r1
                L_0x002e:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x0025
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.b.C2305a.g(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.a$b$a");
            }

            private C2305a auc(int i2) {
                this.bOT |= 1;
                this.Txb = i2;
                return this;
            }

            private C2305a aud(int i2) {
                this.bOT |= 2;
                this.Txs = i2;
                return this;
            }

            private C2305a aue(int i2) {
                this.bOT |= 4;
                this.Txt = i2;
                return this;
            }

            private void hFf() {
                AppMethodBeat.i(58398);
                if ((this.bOT & 8) != 8) {
                    this.Txu = new ArrayList(this.Txu);
                    this.bOT |= 8;
                }
                AppMethodBeat.o(58398);
            }

            private void hFg() {
                AppMethodBeat.i(58399);
                if ((this.bOT & 16) != 16) {
                    this.Txv = new ArrayList(this.Txv);
                    this.bOT |= 16;
                }
                AppMethodBeat.o(58399);
            }

            private void hFh() {
                AppMethodBeat.i(58400);
                if ((this.bOT & 32) != 32) {
                    this.Txw = new ArrayList(this.Txw);
                    this.bOT |= 32;
                }
                AppMethodBeat.o(58400);
            }

            private void hFi() {
                AppMethodBeat.i(58401);
                if ((this.bOT & 64) != 64) {
                    this.Txy = new ArrayList(this.Txy);
                    this.bOT |= 64;
                }
                AppMethodBeat.o(58401);
            }

            private void hFj() {
                AppMethodBeat.i(58402);
                if ((this.bOT & 128) != 128) {
                    this.TxA = new ArrayList(this.TxA);
                    this.bOT |= 128;
                }
                AppMethodBeat.o(58402);
            }

            private void hFk() {
                AppMethodBeat.i(58403);
                if ((this.bOT & 256) != 256) {
                    this.TxB = new ArrayList(this.TxB);
                    this.bOT |= 256;
                }
                AppMethodBeat.o(58403);
            }

            private void hFl() {
                AppMethodBeat.i(58404);
                if ((this.bOT & 512) != 512) {
                    this.TxC = new ArrayList(this.TxC);
                    this.bOT |= 512;
                }
                AppMethodBeat.o(58404);
            }

            private void hFm() {
                AppMethodBeat.i(58405);
                if ((this.bOT & 1024) != 1024) {
                    this.TxD = new ArrayList(this.TxD);
                    this.bOT |= 1024;
                }
                AppMethodBeat.o(58405);
            }

            private void hFn() {
                AppMethodBeat.i(58406);
                if ((this.bOT & 2048) != 2048) {
                    this.TxE = new ArrayList(this.TxE);
                    this.bOT |= 2048;
                }
                AppMethodBeat.o(58406);
            }

            private void hFo() {
                AppMethodBeat.i(58407);
                if ((this.bOT & 4096) != 4096) {
                    this.TxF = new ArrayList(this.TxF);
                    this.bOT |= 4096;
                }
                AppMethodBeat.o(58407);
            }

            private C2305a a(s sVar) {
                AppMethodBeat.i(58408);
                if ((this.bOT & 8192) != 8192 || this.TxH == s.hHH()) {
                    this.TxH = sVar;
                } else {
                    this.TxH = s.d(this.TxH).g(sVar).hHK();
                }
                this.bOT |= 8192;
                AppMethodBeat.o(58408);
                return this;
            }

            private void hFp() {
                AppMethodBeat.i(58409);
                if ((this.bOT & 16384) != 16384) {
                    this.TxI = new ArrayList(this.TxI);
                    this.bOT |= 16384;
                }
                AppMethodBeat.o(58409);
            }

            private C2305a a(v vVar) {
                AppMethodBeat.i(58410);
                if ((this.bOT & 32768) != 32768 || this.TxJ == v.hId()) {
                    this.TxJ = vVar;
                } else {
                    this.TxJ = v.c(this.TxJ).f(vVar).hIf();
                }
                this.bOT |= 32768;
                AppMethodBeat.o(58410);
                return this;
            }

            private C2305a hFd() {
                AppMethodBeat.i(58393);
                C2305a m = new C2305a().m(hFe());
                AppMethodBeat.o(58393);
                return m;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                AppMethodBeat.i(58396);
                if (!((this.bOT & 2) == 2)) {
                    AppMethodBeat.o(58396);
                    return false;
                }
                for (int i2 = 0; i2 < this.Txu.size(); i2++) {
                    if (!this.Txu.get(i2).isInitialized()) {
                        AppMethodBeat.o(58396);
                        return false;
                    }
                }
                for (int i3 = 0; i3 < this.Txv.size(); i3++) {
                    if (!this.Txv.get(i3).isInitialized()) {
                        AppMethodBeat.o(58396);
                        return false;
                    }
                }
                for (int i4 = 0; i4 < this.TxA.size(); i4++) {
                    if (!this.TxA.get(i4).isInitialized()) {
                        AppMethodBeat.o(58396);
                        return false;
                    }
                }
                for (int i5 = 0; i5 < this.TxB.size(); i5++) {
                    if (!this.TxB.get(i5).isInitialized()) {
                        AppMethodBeat.o(58396);
                        return false;
                    }
                }
                for (int i6 = 0; i6 < this.TxC.size(); i6++) {
                    if (!this.TxC.get(i6).isInitialized()) {
                        AppMethodBeat.o(58396);
                        return false;
                    }
                }
                for (int i7 = 0; i7 < this.TxD.size(); i7++) {
                    if (!this.TxD.get(i7).isInitialized()) {
                        AppMethodBeat.o(58396);
                        return false;
                    }
                }
                for (int i8 = 0; i8 < this.TxE.size(); i8++) {
                    if (!this.TxE.get(i8).isInitialized()) {
                        AppMethodBeat.o(58396);
                        return false;
                    }
                }
                if (((this.bOT & 8192) == 8192) && !this.TxH.isInitialized()) {
                    AppMethodBeat.o(58396);
                    return false;
                } else if (!this.TDA.isInitialized()) {
                    AppMethodBeat.o(58396);
                    return false;
                } else {
                    AppMethodBeat.o(58396);
                    return true;
                }
            }

            @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                AppMethodBeat.i(58412);
                b hEY = b.hEY();
                AppMethodBeat.o(58412);
                return hEY;
            }

            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ kotlin.l.b.a.b.h.i hED() {
                AppMethodBeat.i(58413);
                b hEY = b.hEY();
                AppMethodBeat.o(58413);
                return hEY;
            }

            @Override // kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEG() {
                AppMethodBeat.i(58419);
                b hFe = hFe();
                if (!hFe.isInitialized()) {
                    kotlin.l.b.a.b.h.w wVar = new kotlin.l.b.a.b.h.w();
                    AppMethodBeat.o(58419);
                    throw wVar;
                }
                AppMethodBeat.o(58419);
                return hFe;
            }

            static /* synthetic */ C2305a hFr() {
                AppMethodBeat.i(58421);
                C2305a aVar = new C2305a();
                AppMethodBeat.o(58421);
                return aVar;
            }
        }

        @Override // kotlin.l.b.a.b.h.r
        public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
            return Txr;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEw() {
            AppMethodBeat.i(58432);
            C2305a m = C2305a.hFr().m(this);
            AppMethodBeat.o(58432);
            return m;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEx() {
            AppMethodBeat.i(58433);
            C2305a hFr = C2305a.hFr();
            AppMethodBeat.o(58433);
            return hFr;
        }
    }

    public static final class k extends i.c<k> implements m {
        public static kotlin.l.b.a.b.h.s<k> TwL = new kotlin.l.b.a.b.h.b<k>() {
            /* class kotlin.l.b.a.b.e.a.k.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.h.s
            public final /* synthetic */ Object a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58627);
                k kVar = new k(eVar, gVar, (byte) 0);
                AppMethodBeat.o(58627);
                return kVar;
            }
        };
        private static final k TyN;
        private final kotlin.l.b.a.b.h.d TwK;
        public List<h> TxB;
        public List<m> TxC;
        public List<q> TxD;
        public s TxH;
        public v TxJ;
        private int bOT;
        private byte bPe;
        private int bVY;

        /* synthetic */ k(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar, byte b2) {
            this(eVar, gVar);
        }

        /* synthetic */ k(i.b bVar, byte b2) {
            this(bVar);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEw() {
            AppMethodBeat.i(58658);
            C2313a hGk = hGk();
            AppMethodBeat.o(58658);
            return hGk;
        }

        private k(i.b<k, ?> bVar) {
            super(bVar);
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = bVar.TwK;
        }

        private k() {
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = kotlin.l.b.a.b.h.d.TDp;
        }

        public static k hGj() {
            return TyN;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v44, resolved type: java.util.List<kotlin.l.b.a.b.e.a$q> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: java.util.List<kotlin.l.b.a.b.e.a$m> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v50, resolved type: java.util.List<kotlin.l.b.a.b.e.a$h> */
        /* JADX WARN: Multi-variable type inference failed */
        private k(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
            v.C2327a aVar;
            s.C2324a aVar2;
            AppMethodBeat.i(58650);
            this.bPe = -1;
            this.bVY = -1;
            hEu();
            boolean z = false;
            d.b hJo = kotlin.l.b.a.b.h.d.hJo();
            kotlin.l.b.a.b.h.f f2 = kotlin.l.b.a.b.h.f.f(hJo, 1);
            boolean z2 = false;
            while (!z2) {
                try {
                    int yT = eVar.yT();
                    switch (yT) {
                        case 0:
                            z2 = true;
                            break;
                        case 26:
                            if (!z || !true) {
                                this.TxB = new ArrayList();
                                z |= true;
                            }
                            this.TxB.add(eVar.a(h.TwL, gVar));
                            break;
                        case 34:
                            if (!(z & true)) {
                                this.TxC = new ArrayList();
                                z |= true;
                            }
                            this.TxC.add(eVar.a(m.TwL, gVar));
                            break;
                        case 42:
                            if (!(z & true)) {
                                this.TxD = new ArrayList();
                                z |= true;
                            }
                            this.TxD.add(eVar.a(q.TwL, gVar));
                            break;
                        case 242:
                            if ((this.bOT & 1) == 1) {
                                aVar2 = s.d(this.TxH);
                            } else {
                                aVar2 = null;
                            }
                            this.TxH = (s) eVar.a(s.TwL, gVar);
                            if (aVar2 != null) {
                                aVar2.g(this.TxH);
                                this.TxH = aVar2.hHK();
                            }
                            this.bOT |= 1;
                            break;
                        case CdnLogic.kAppTypeFestivalVideo:
                            if ((this.bOT & 2) == 2) {
                                aVar = v.c(this.TxJ);
                            } else {
                                aVar = null;
                            }
                            this.TxJ = (v) eVar.a(v.TwL, gVar);
                            if (aVar != null) {
                                aVar.f(this.TxJ);
                                this.TxJ = aVar.hIf();
                            }
                            this.bOT |= 2;
                            break;
                        default:
                            if (a(eVar, f2, gVar, yT)) {
                                break;
                            } else {
                                z2 = true;
                                break;
                            }
                    }
                } catch (kotlin.l.b.a.b.h.k e2) {
                    e2.TDK = this;
                    AppMethodBeat.o(58650);
                    throw e2;
                } catch (IOException e3) {
                    kotlin.l.b.a.b.h.k kVar = new kotlin.l.b.a.b.h.k(e3.getMessage());
                    kVar.TDK = this;
                    AppMethodBeat.o(58650);
                    throw kVar;
                } catch (Throwable th) {
                    if (z && true) {
                        this.TxB = Collections.unmodifiableList(this.TxB);
                    }
                    if (z & true) {
                        this.TxC = Collections.unmodifiableList(this.TxC);
                    }
                    if (z & true) {
                        this.TxD = Collections.unmodifiableList(this.TxD);
                    }
                    try {
                        f2.flush();
                        this.TwK = hJo.hJs();
                    } catch (IOException e4) {
                        this.TwK = hJo.hJs();
                    } catch (Throwable th2) {
                        this.TwK = hJo.hJs();
                        AppMethodBeat.o(58650);
                        throw th2;
                    }
                    this.TDA.yK();
                    AppMethodBeat.o(58650);
                    throw th;
                }
            }
            if (z && true) {
                this.TxB = Collections.unmodifiableList(this.TxB);
            }
            if (z & true) {
                this.TxC = Collections.unmodifiableList(this.TxC);
            }
            if (z & true) {
                this.TxD = Collections.unmodifiableList(this.TxD);
            }
            try {
                f2.flush();
                this.TwK = hJo.hJs();
            } catch (IOException e5) {
                this.TwK = hJo.hJs();
            } catch (Throwable th3) {
                this.TwK = hJo.hJs();
                AppMethodBeat.o(58650);
                throw th3;
            }
            this.TDA.yK();
            AppMethodBeat.o(58650);
        }

        static {
            AppMethodBeat.i(58660);
            k kVar = new k();
            TyN = kVar;
            kVar.hEu();
            AppMethodBeat.o(58660);
        }

        @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
        public final kotlin.l.b.a.b.h.s<k> hEs() {
            return TwL;
        }

        public final boolean hFb() {
            return (this.bOT & 1) == 1;
        }

        public final boolean hFc() {
            return (this.bOT & 2) == 2;
        }

        private void hEu() {
            AppMethodBeat.i(58651);
            this.TxB = Collections.emptyList();
            this.TxC = Collections.emptyList();
            this.TxD = Collections.emptyList();
            this.TxH = s.hHH();
            this.TxJ = v.hId();
            AppMethodBeat.o(58651);
        }

        @Override // kotlin.l.b.a.b.h.r
        public final boolean isInitialized() {
            AppMethodBeat.i(58652);
            byte b2 = this.bPe;
            if (b2 == 1) {
                AppMethodBeat.o(58652);
                return true;
            } else if (b2 == 0) {
                AppMethodBeat.o(58652);
                return false;
            } else {
                for (int i2 = 0; i2 < this.TxB.size(); i2++) {
                    if (!this.TxB.get(i2).isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58652);
                        return false;
                    }
                }
                for (int i3 = 0; i3 < this.TxC.size(); i3++) {
                    if (!this.TxC.get(i3).isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58652);
                        return false;
                    }
                }
                for (int i4 = 0; i4 < this.TxD.size(); i4++) {
                    if (!this.TxD.get(i4).isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58652);
                        return false;
                    }
                }
                if (hFb() && !this.TxH.isInitialized()) {
                    this.bPe = 0;
                    AppMethodBeat.o(58652);
                    return false;
                } else if (!this.TDA.isInitialized()) {
                    this.bPe = 0;
                    AppMethodBeat.o(58652);
                    return false;
                } else {
                    this.bPe = 1;
                    AppMethodBeat.o(58652);
                    return true;
                }
            }
        }

        @Override // kotlin.l.b.a.b.h.q
        public final void a(kotlin.l.b.a.b.h.f fVar) {
            AppMethodBeat.i(58653);
            yC();
            i.c<MessageType>.a hJC = hJC();
            for (int i2 = 0; i2 < this.TxB.size(); i2++) {
                fVar.a(3, this.TxB.get(i2));
            }
            for (int i3 = 0; i3 < this.TxC.size(); i3++) {
                fVar.a(4, this.TxC.get(i3));
            }
            for (int i4 = 0; i4 < this.TxD.size(); i4++) {
                fVar.a(5, this.TxD.get(i4));
            }
            if ((this.bOT & 1) == 1) {
                fVar.a(30, this.TxH);
            }
            if ((this.bOT & 2) == 2) {
                fVar.a(32, this.TxJ);
            }
            hJC.b(200, fVar);
            fVar.e(this.TwK);
            AppMethodBeat.o(58653);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final int yC() {
            AppMethodBeat.i(58654);
            int i2 = this.bVY;
            if (i2 != -1) {
                AppMethodBeat.o(58654);
                return i2;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.TxB.size(); i4++) {
                i3 += kotlin.l.b.a.b.h.f.c(3, this.TxB.get(i4));
            }
            for (int i5 = 0; i5 < this.TxC.size(); i5++) {
                i3 += kotlin.l.b.a.b.h.f.c(4, this.TxC.get(i5));
            }
            for (int i6 = 0; i6 < this.TxD.size(); i6++) {
                i3 += kotlin.l.b.a.b.h.f.c(5, this.TxD.get(i6));
            }
            if ((this.bOT & 1) == 1) {
                i3 += kotlin.l.b.a.b.h.f.c(30, this.TxH);
            }
            if ((this.bOT & 2) == 2) {
                i3 += kotlin.l.b.a.b.h.f.c(32, this.TxJ);
            }
            int yC = this.TDA.yC() + i3 + this.TwK.size();
            this.bVY = yC;
            AppMethodBeat.o(58654);
            return yC;
        }

        public static k c(InputStream inputStream, kotlin.l.b.a.b.h.g gVar) {
            AppMethodBeat.i(58655);
            k j2 = TwL.j(inputStream, gVar);
            AppMethodBeat.o(58655);
            return j2;
        }

        /* renamed from: kotlin.l.b.a.b.e.a$k$a  reason: collision with other inner class name */
        public static final class C2313a extends i.b<k, C2313a> implements m {
            private List<h> TxB = Collections.emptyList();
            private List<m> TxC = Collections.emptyList();
            private List<q> TxD = Collections.emptyList();
            private s TxH = s.hHH();
            private v TxJ = v.hId();
            private int bOT;

            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ i.a a(kotlin.l.b.a.b.h.i iVar) {
                AppMethodBeat.i(58642);
                C2313a f2 = f((k) iVar);
                AppMethodBeat.o(58642);
                return f2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
            public final /* synthetic */ a.AbstractC2337a c(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58644);
                C2313a n = n(eVar, gVar);
                AppMethodBeat.o(58644);
                return n;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a, java.lang.Object
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(58648);
                C2313a hGl = hGl();
                AppMethodBeat.o(58648);
                return hGl;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q.a d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58646);
                C2313a n = n(eVar, gVar);
                AppMethodBeat.o(58646);
                return n;
            }

            @Override // kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ i.a hEE() {
                AppMethodBeat.i(58643);
                C2313a hGl = hGl();
                AppMethodBeat.o(58643);
                return hGl;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ a.AbstractC2337a hEF() {
                AppMethodBeat.i(58645);
                C2313a hGl = hGl();
                AppMethodBeat.o(58645);
                return hGl;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$b' to match base method */
            @Override // kotlin.l.b.a.b.h.i.b
            public final /* synthetic */ C2313a hFq() {
                AppMethodBeat.i(58639);
                C2313a hGl = hGl();
                AppMethodBeat.o(58639);
                return hGl;
            }

            private C2313a() {
                AppMethodBeat.i(58628);
                AppMethodBeat.o(58628);
            }

            public final k hGm() {
                int i2 = 1;
                AppMethodBeat.i(58630);
                k kVar = new k(this, (byte) 0);
                int i3 = this.bOT;
                if ((this.bOT & 1) == 1) {
                    this.TxB = Collections.unmodifiableList(this.TxB);
                    this.bOT &= -2;
                }
                kVar.TxB = this.TxB;
                if ((this.bOT & 2) == 2) {
                    this.TxC = Collections.unmodifiableList(this.TxC);
                    this.bOT &= -3;
                }
                kVar.TxC = this.TxC;
                if ((this.bOT & 4) == 4) {
                    this.TxD = Collections.unmodifiableList(this.TxD);
                    this.bOT &= -5;
                }
                kVar.TxD = this.TxD;
                if ((i3 & 8) != 8) {
                    i2 = 0;
                }
                kVar.TxH = this.TxH;
                if ((i3 & 16) == 16) {
                    i2 |= 2;
                }
                kVar.TxJ = this.TxJ;
                kVar.bOT = i2;
                AppMethodBeat.o(58630);
                return kVar;
            }

            public final C2313a f(k kVar) {
                AppMethodBeat.i(58631);
                if (kVar == k.hGj()) {
                    AppMethodBeat.o(58631);
                } else {
                    if (!kVar.TxB.isEmpty()) {
                        if (this.TxB.isEmpty()) {
                            this.TxB = kVar.TxB;
                            this.bOT &= -2;
                        } else {
                            hFk();
                            this.TxB.addAll(kVar.TxB);
                        }
                    }
                    if (!kVar.TxC.isEmpty()) {
                        if (this.TxC.isEmpty()) {
                            this.TxC = kVar.TxC;
                            this.bOT &= -3;
                        } else {
                            hFl();
                            this.TxC.addAll(kVar.TxC);
                        }
                    }
                    if (!kVar.TxD.isEmpty()) {
                        if (this.TxD.isEmpty()) {
                            this.TxD = kVar.TxD;
                            this.bOT &= -5;
                        } else {
                            hFm();
                            this.TxD.addAll(kVar.TxD);
                        }
                    }
                    if (kVar.hFb()) {
                        c(kVar.TxH);
                    }
                    if (kVar.hFc()) {
                        b(kVar.TxJ);
                    }
                    a((i.c) kVar);
                    this.TwK = this.TwK.a(kVar.TwK);
                    AppMethodBeat.o(58631);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private kotlin.l.b.a.b.e.a.k.C2313a n(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                /*
                    r4 = this;
                    r3 = 58633(0xe509, float:8.2162E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    r2 = 0
                    kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.a$k> r0 = kotlin.l.b.a.b.e.a.k.TwL     // Catch:{ k -> 0x0016 }
                    java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                    kotlin.l.b.a.b.e.a$k r0 = (kotlin.l.b.a.b.e.a.k) r0     // Catch:{ k -> 0x0016 }
                    r4.f(r0)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return r4
                L_0x0016:
                    r0 = move-exception
                    r1 = r0
                    kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                    kotlin.l.b.a.b.e.a$k r0 = (kotlin.l.b.a.b.e.a.k) r0     // Catch:{ all -> 0x002e }
                    r2 = 58633(0xe509, float:8.2162E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)     // Catch:{ all -> 0x0023 }
                    throw r1     // Catch:{ all -> 0x0023 }
                L_0x0023:
                    r1 = move-exception
                    r2 = r0
                L_0x0025:
                    if (r2 == 0) goto L_0x002a
                    r4.f(r2)
                L_0x002a:
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    throw r1
                L_0x002e:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x0025
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.k.C2313a.n(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.a$k$a");
            }

            private void hFk() {
                AppMethodBeat.i(58634);
                if ((this.bOT & 1) != 1) {
                    this.TxB = new ArrayList(this.TxB);
                    this.bOT |= 1;
                }
                AppMethodBeat.o(58634);
            }

            private void hFl() {
                AppMethodBeat.i(58635);
                if ((this.bOT & 2) != 2) {
                    this.TxC = new ArrayList(this.TxC);
                    this.bOT |= 2;
                }
                AppMethodBeat.o(58635);
            }

            private void hFm() {
                AppMethodBeat.i(58636);
                if ((this.bOT & 4) != 4) {
                    this.TxD = new ArrayList(this.TxD);
                    this.bOT |= 4;
                }
                AppMethodBeat.o(58636);
            }

            private C2313a c(s sVar) {
                AppMethodBeat.i(58637);
                if ((this.bOT & 8) != 8 || this.TxH == s.hHH()) {
                    this.TxH = sVar;
                } else {
                    this.TxH = s.d(this.TxH).g(sVar).hHK();
                }
                this.bOT |= 8;
                AppMethodBeat.o(58637);
                return this;
            }

            private C2313a b(v vVar) {
                AppMethodBeat.i(58638);
                if ((this.bOT & 16) != 16 || this.TxJ == v.hId()) {
                    this.TxJ = vVar;
                } else {
                    this.TxJ = v.c(this.TxJ).f(vVar).hIf();
                }
                this.bOT |= 16;
                AppMethodBeat.o(58638);
                return this;
            }

            private C2313a hGl() {
                AppMethodBeat.i(58629);
                C2313a f2 = new C2313a().f(hGm());
                AppMethodBeat.o(58629);
                return f2;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                AppMethodBeat.i(58632);
                for (int i2 = 0; i2 < this.TxB.size(); i2++) {
                    if (!this.TxB.get(i2).isInitialized()) {
                        AppMethodBeat.o(58632);
                        return false;
                    }
                }
                for (int i3 = 0; i3 < this.TxC.size(); i3++) {
                    if (!this.TxC.get(i3).isInitialized()) {
                        AppMethodBeat.o(58632);
                        return false;
                    }
                }
                for (int i4 = 0; i4 < this.TxD.size(); i4++) {
                    if (!this.TxD.get(i4).isInitialized()) {
                        AppMethodBeat.o(58632);
                        return false;
                    }
                }
                if (((this.bOT & 8) == 8) && !this.TxH.isInitialized()) {
                    AppMethodBeat.o(58632);
                    return false;
                } else if (!this.TDA.isInitialized()) {
                    AppMethodBeat.o(58632);
                    return false;
                } else {
                    AppMethodBeat.o(58632);
                    return true;
                }
            }

            @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                AppMethodBeat.i(58640);
                k hGj = k.hGj();
                AppMethodBeat.o(58640);
                return hGj;
            }

            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ kotlin.l.b.a.b.h.i hED() {
                AppMethodBeat.i(58641);
                k hGj = k.hGj();
                AppMethodBeat.o(58641);
                return hGj;
            }

            @Override // kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEG() {
                AppMethodBeat.i(58647);
                k hGm = hGm();
                if (!hGm.isInitialized()) {
                    kotlin.l.b.a.b.h.w wVar = new kotlin.l.b.a.b.h.w();
                    AppMethodBeat.o(58647);
                    throw wVar;
                }
                AppMethodBeat.o(58647);
                return hGm;
            }

            static /* synthetic */ C2313a hGn() {
                AppMethodBeat.i(58649);
                C2313a aVar = new C2313a();
                AppMethodBeat.o(58649);
                return aVar;
            }
        }

        public static C2313a a(k kVar) {
            AppMethodBeat.i(58656);
            C2313a f2 = C2313a.hGn().f(kVar);
            AppMethodBeat.o(58656);
            return f2;
        }

        public final C2313a hGk() {
            AppMethodBeat.i(58657);
            C2313a f2 = C2313a.hGn().f(this);
            AppMethodBeat.o(58657);
            return f2;
        }

        @Override // kotlin.l.b.a.b.h.r
        public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
            return TyN;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEx() {
            AppMethodBeat.i(58659);
            C2313a hGn = C2313a.hGn();
            AppMethodBeat.o(58659);
            return hGn;
        }
    }

    public static final class s extends kotlin.l.b.a.b.h.i implements v {
        public static kotlin.l.b.a.b.h.s<s> TwL = new kotlin.l.b.a.b.h.b<s>() {
            /* class kotlin.l.b.a.b.e.a.s.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.h.s
            public final /* synthetic */ Object a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58931);
                s sVar = new s(eVar, gVar, (byte) 0);
                AppMethodBeat.o(58931);
                return sVar;
            }
        };
        private static final s TzV;
        private final kotlin.l.b.a.b.h.d TwK;
        public List<p> TzW;
        public int TzX;
        private int bOT;
        private byte bPe;
        private int bVY;

        /* synthetic */ s(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar, byte b2) {
            this(eVar, gVar);
        }

        /* synthetic */ s(i.a aVar, byte b2) {
            this(aVar);
        }

        private s(i.a aVar) {
            super((byte) 0);
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = aVar.TwK;
        }

        private s() {
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = kotlin.l.b.a.b.h.d.TDp;
        }

        public static s hHH() {
            return TzV;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: java.util.List<kotlin.l.b.a.b.e.a$p> */
        /* JADX WARN: Multi-variable type inference failed */
        private s(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
            AppMethodBeat.i(58949);
            this.bPe = -1;
            this.bVY = -1;
            hEu();
            d.b hJo = kotlin.l.b.a.b.h.d.hJo();
            kotlin.l.b.a.b.h.f f2 = kotlin.l.b.a.b.h.f.f(hJo, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int yT = eVar.yT();
                    switch (yT) {
                        case 0:
                            z = true;
                            break;
                        case 10:
                            if (!z2 || !true) {
                                this.TzW = new ArrayList();
                                z2 |= true;
                            }
                            this.TzW.add(eVar.a(p.TwL, gVar));
                            break;
                        case 16:
                            this.bOT |= 1;
                            this.TzX = eVar.zi();
                            break;
                        default:
                            if (a(eVar, f2, gVar, yT)) {
                                break;
                            } else {
                                z = true;
                                break;
                            }
                    }
                } catch (kotlin.l.b.a.b.h.k e2) {
                    e2.TDK = this;
                    AppMethodBeat.o(58949);
                    throw e2;
                } catch (IOException e3) {
                    kotlin.l.b.a.b.h.k kVar = new kotlin.l.b.a.b.h.k(e3.getMessage());
                    kVar.TDK = this;
                    AppMethodBeat.o(58949);
                    throw kVar;
                } catch (Throwable th) {
                    if (z2 && true) {
                        this.TzW = Collections.unmodifiableList(this.TzW);
                    }
                    try {
                        f2.flush();
                        this.TwK = hJo.hJs();
                    } catch (IOException e4) {
                        this.TwK = hJo.hJs();
                    } catch (Throwable th2) {
                        this.TwK = hJo.hJs();
                        AppMethodBeat.o(58949);
                        throw th2;
                    }
                    Gw();
                    AppMethodBeat.o(58949);
                    throw th;
                }
            }
            if (z2 && true) {
                this.TzW = Collections.unmodifiableList(this.TzW);
            }
            try {
                f2.flush();
                this.TwK = hJo.hJs();
            } catch (IOException e5) {
                this.TwK = hJo.hJs();
            } catch (Throwable th3) {
                this.TwK = hJo.hJs();
                AppMethodBeat.o(58949);
                throw th3;
            }
            Gw();
            AppMethodBeat.o(58949);
        }

        static {
            AppMethodBeat.i(58957);
            s sVar = new s();
            TzV = sVar;
            sVar.hEu();
            AppMethodBeat.o(58957);
        }

        @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
        public final kotlin.l.b.a.b.h.s<s> hEs() {
            return TwL;
        }

        public final boolean hHI() {
            return (this.bOT & 1) == 1;
        }

        private void hEu() {
            AppMethodBeat.i(58950);
            this.TzW = Collections.emptyList();
            this.TzX = -1;
            AppMethodBeat.o(58950);
        }

        @Override // kotlin.l.b.a.b.h.r
        public final boolean isInitialized() {
            AppMethodBeat.i(58951);
            byte b2 = this.bPe;
            if (b2 == 1) {
                AppMethodBeat.o(58951);
                return true;
            } else if (b2 == 0) {
                AppMethodBeat.o(58951);
                return false;
            } else {
                for (int i2 = 0; i2 < this.TzW.size(); i2++) {
                    if (!this.TzW.get(i2).isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58951);
                        return false;
                    }
                }
                this.bPe = 1;
                AppMethodBeat.o(58951);
                return true;
            }
        }

        @Override // kotlin.l.b.a.b.h.q
        public final void a(kotlin.l.b.a.b.h.f fVar) {
            AppMethodBeat.i(58952);
            yC();
            for (int i2 = 0; i2 < this.TzW.size(); i2++) {
                fVar.a(1, this.TzW.get(i2));
            }
            if ((this.bOT & 1) == 1) {
                fVar.bs(2, this.TzX);
            }
            fVar.e(this.TwK);
            AppMethodBeat.o(58952);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final int yC() {
            AppMethodBeat.i(58953);
            int i2 = this.bVY;
            if (i2 != -1) {
                AppMethodBeat.o(58953);
                return i2;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.TzW.size(); i4++) {
                i3 += kotlin.l.b.a.b.h.f.c(1, this.TzW.get(i4));
            }
            if ((this.bOT & 1) == 1) {
                i3 += kotlin.l.b.a.b.h.f.bu(2, this.TzX);
            }
            int size = this.TwK.size() + i3;
            this.bVY = size;
            AppMethodBeat.o(58953);
            return size;
        }

        /* renamed from: kotlin.l.b.a.b.e.a$s$a  reason: collision with other inner class name */
        public static final class C2324a extends i.a<s, C2324a> implements v {
            private List<p> TzW = Collections.emptyList();
            private int TzX = -1;
            private int bOT;

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.l.b.a.b.h.i] */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2324a a(s sVar) {
                AppMethodBeat.i(58940);
                C2324a g2 = g(sVar);
                AppMethodBeat.o(58940);
                return g2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
            public final /* synthetic */ a.AbstractC2337a c(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58942);
                C2324a x = x(eVar, gVar);
                AppMethodBeat.o(58942);
                return x;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a, java.lang.Object
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(58947);
                C2324a hHJ = hHJ();
                AppMethodBeat.o(58947);
                return hHJ;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q.a d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58944);
                C2324a x = x(eVar, gVar);
                AppMethodBeat.o(58944);
                return x;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2324a hEE() {
                AppMethodBeat.i(58941);
                C2324a hHJ = hHJ();
                AppMethodBeat.o(58941);
                return hHJ;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ a.AbstractC2337a hEF() {
                AppMethodBeat.i(58943);
                C2324a hHJ = hHJ();
                AppMethodBeat.o(58943);
                return hHJ;
            }

            private C2324a() {
                AppMethodBeat.i(58932);
                AppMethodBeat.o(58932);
            }

            public final s hHK() {
                int i2 = 1;
                AppMethodBeat.i(58934);
                s sVar = new s(this, (byte) 0);
                int i3 = this.bOT;
                if ((this.bOT & 1) == 1) {
                    this.TzW = Collections.unmodifiableList(this.TzW);
                    this.bOT &= -2;
                }
                sVar.TzW = this.TzW;
                if ((i3 & 2) != 2) {
                    i2 = 0;
                }
                sVar.TzX = this.TzX;
                sVar.bOT = i2;
                AppMethodBeat.o(58934);
                return sVar;
            }

            public final C2324a g(s sVar) {
                AppMethodBeat.i(58935);
                if (sVar == s.hHH()) {
                    AppMethodBeat.o(58935);
                } else {
                    if (!sVar.TzW.isEmpty()) {
                        if (this.TzW.isEmpty()) {
                            this.TzW = sVar.TzW;
                            this.bOT &= -2;
                        } else {
                            hHL();
                            this.TzW.addAll(sVar.TzW);
                        }
                    }
                    if (sVar.hHI()) {
                        auY(sVar.TzX);
                    }
                    this.TwK = this.TwK.a(sVar.TwK);
                    AppMethodBeat.o(58935);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private kotlin.l.b.a.b.e.a.s.C2324a x(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                /*
                    r4 = this;
                    r3 = 58937(0xe639, float:8.2588E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    r2 = 0
                    kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.a$s> r0 = kotlin.l.b.a.b.e.a.s.TwL     // Catch:{ k -> 0x0016 }
                    java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                    kotlin.l.b.a.b.e.a$s r0 = (kotlin.l.b.a.b.e.a.s) r0     // Catch:{ k -> 0x0016 }
                    r4.g(r0)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return r4
                L_0x0016:
                    r0 = move-exception
                    r1 = r0
                    kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                    kotlin.l.b.a.b.e.a$s r0 = (kotlin.l.b.a.b.e.a.s) r0     // Catch:{ all -> 0x002e }
                    r2 = 58937(0xe639, float:8.2588E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)     // Catch:{ all -> 0x0023 }
                    throw r1     // Catch:{ all -> 0x0023 }
                L_0x0023:
                    r1 = move-exception
                    r2 = r0
                L_0x0025:
                    if (r2 == 0) goto L_0x002a
                    r4.g(r2)
                L_0x002a:
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    throw r1
                L_0x002e:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x0025
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.s.C2324a.x(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.a$s$a");
            }

            private void hHL() {
                AppMethodBeat.i(58938);
                if ((this.bOT & 1) != 1) {
                    this.TzW = new ArrayList(this.TzW);
                    this.bOT |= 1;
                }
                AppMethodBeat.o(58938);
            }

            private C2324a auY(int i2) {
                this.bOT |= 2;
                this.TzX = i2;
                return this;
            }

            private C2324a hHJ() {
                AppMethodBeat.i(58933);
                C2324a g2 = new C2324a().g(hHK());
                AppMethodBeat.o(58933);
                return g2;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                AppMethodBeat.i(58936);
                for (int i2 = 0; i2 < this.TzW.size(); i2++) {
                    if (!this.TzW.get(i2).isInitialized()) {
                        AppMethodBeat.o(58936);
                        return false;
                    }
                }
                AppMethodBeat.o(58936);
                return true;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ s hED() {
                AppMethodBeat.i(58939);
                s hHH = s.hHH();
                AppMethodBeat.o(58939);
                return hHH;
            }

            @Override // kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEG() {
                AppMethodBeat.i(58945);
                s hHK = hHK();
                if (!hHK.isInitialized()) {
                    kotlin.l.b.a.b.h.w wVar = new kotlin.l.b.a.b.h.w();
                    AppMethodBeat.o(58945);
                    throw wVar;
                }
                AppMethodBeat.o(58945);
                return hHK;
            }

            @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                AppMethodBeat.i(58946);
                s hHH = s.hHH();
                AppMethodBeat.o(58946);
                return hHH;
            }

            static /* synthetic */ C2324a hHM() {
                AppMethodBeat.i(58948);
                C2324a aVar = new C2324a();
                AppMethodBeat.o(58948);
                return aVar;
            }
        }

        public static C2324a d(s sVar) {
            AppMethodBeat.i(58954);
            C2324a g2 = C2324a.hHM().g(sVar);
            AppMethodBeat.o(58954);
            return g2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEw() {
            AppMethodBeat.i(58955);
            C2324a g2 = C2324a.hHM().g(this);
            AppMethodBeat.o(58955);
            return g2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEx() {
            AppMethodBeat.i(58956);
            C2324a hHM = C2324a.hHM();
            AppMethodBeat.o(58956);
            return hHM;
        }

        @Override // kotlin.l.b.a.b.h.r
        public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
            return TzV;
        }
    }

    public static final class c extends i.c<c> implements f {
        public static kotlin.l.b.a.b.h.s<c> TwL = new kotlin.l.b.a.b.h.b<c>() {
            /* class kotlin.l.b.a.b.e.a.c.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.h.s
            public final /* synthetic */ Object a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58435);
                c cVar = new c(eVar, gVar, (byte) 0);
                AppMethodBeat.o(58435);
                return cVar;
            }
        };
        private static final c TxS;
        private final kotlin.l.b.a.b.h.d TwK;
        public List<Integer> TxI;
        public List<t> TxT;
        public int Txb;
        private int bOT;
        private byte bPe;
        private int bVY;

        /* synthetic */ c(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar, byte b2) {
            this(eVar, gVar);
        }

        /* synthetic */ c(i.b bVar, byte b2) {
            this(bVar);
        }

        private c(i.b<c, ?> bVar) {
            super(bVar);
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = bVar.TwK;
        }

        private c() {
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = kotlin.l.b.a.b.h.d.TDp;
        }

        public static c hFs() {
            return TxS;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v32, resolved type: java.util.List<kotlin.l.b.a.b.e.a$t> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x004f  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x005b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private c(kotlin.l.b.a.b.h.e r12, kotlin.l.b.a.b.h.g r13) {
            /*
            // Method dump skipped, instructions count: 364
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.c.<init>(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):void");
        }

        static {
            AppMethodBeat.i(58462);
            c cVar = new c();
            TxS = cVar;
            cVar.hEu();
            AppMethodBeat.o(58462);
        }

        @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
        public final kotlin.l.b.a.b.h.s<c> hEs() {
            return TwL;
        }

        public final boolean hEP() {
            return (this.bOT & 1) == 1;
        }

        private void hEu() {
            AppMethodBeat.i(58456);
            this.Txb = 6;
            this.TxT = Collections.emptyList();
            this.TxI = Collections.emptyList();
            AppMethodBeat.o(58456);
        }

        @Override // kotlin.l.b.a.b.h.r
        public final boolean isInitialized() {
            AppMethodBeat.i(58457);
            byte b2 = this.bPe;
            if (b2 == 1) {
                AppMethodBeat.o(58457);
                return true;
            } else if (b2 == 0) {
                AppMethodBeat.o(58457);
                return false;
            } else {
                for (int i2 = 0; i2 < this.TxT.size(); i2++) {
                    if (!this.TxT.get(i2).isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58457);
                        return false;
                    }
                }
                if (!this.TDA.isInitialized()) {
                    this.bPe = 0;
                    AppMethodBeat.o(58457);
                    return false;
                }
                this.bPe = 1;
                AppMethodBeat.o(58457);
                return true;
            }
        }

        @Override // kotlin.l.b.a.b.h.q
        public final void a(kotlin.l.b.a.b.h.f fVar) {
            AppMethodBeat.i(58458);
            yC();
            i.c<MessageType>.a hJC = hJC();
            if ((this.bOT & 1) == 1) {
                fVar.bs(1, this.Txb);
            }
            for (int i2 = 0; i2 < this.TxT.size(); i2++) {
                fVar.a(2, this.TxT.get(i2));
            }
            for (int i3 = 0; i3 < this.TxI.size(); i3++) {
                fVar.bs(31, this.TxI.get(i3).intValue());
            }
            hJC.b(19000, fVar);
            fVar.e(this.TwK);
            AppMethodBeat.o(58458);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final int yC() {
            AppMethodBeat.i(58459);
            int i2 = this.bVY;
            if (i2 != -1) {
                AppMethodBeat.o(58459);
                return i2;
            }
            int bu = (this.bOT & 1) == 1 ? kotlin.l.b.a.b.h.f.bu(1, this.Txb) + 0 : 0;
            for (int i3 = 0; i3 < this.TxT.size(); i3++) {
                bu += kotlin.l.b.a.b.h.f.c(2, this.TxT.get(i3));
            }
            int i4 = 0;
            int i5 = 0;
            while (i4 < this.TxI.size()) {
                i4++;
                i5 = kotlin.l.b.a.b.h.f.fT(this.TxI.get(i4).intValue()) + i5;
            }
            int size = bu + i5 + (this.TxI.size() * 2) + this.TDA.yC() + this.TwK.size();
            this.bVY = size;
            AppMethodBeat.o(58459);
            return size;
        }

        /* renamed from: kotlin.l.b.a.b.e.a$c$a  reason: collision with other inner class name */
        public static final class C2307a extends i.b<c, C2307a> implements f {
            private List<Integer> TxI = Collections.emptyList();
            private List<t> TxT = Collections.emptyList();
            private int Txb = 6;
            private int bOT;

            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ i.a a(kotlin.l.b.a.b.h.i iVar) {
                AppMethodBeat.i(58447);
                C2307a d2 = d((c) iVar);
                AppMethodBeat.o(58447);
                return d2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
            public final /* synthetic */ a.AbstractC2337a c(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58449);
                C2307a h2 = h(eVar, gVar);
                AppMethodBeat.o(58449);
                return h2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a, java.lang.Object
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(58453);
                C2307a hFt = hFt();
                AppMethodBeat.o(58453);
                return hFt;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q.a d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58451);
                C2307a h2 = h(eVar, gVar);
                AppMethodBeat.o(58451);
                return h2;
            }

            @Override // kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ i.a hEE() {
                AppMethodBeat.i(58448);
                C2307a hFt = hFt();
                AppMethodBeat.o(58448);
                return hFt;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ a.AbstractC2337a hEF() {
                AppMethodBeat.i(58450);
                C2307a hFt = hFt();
                AppMethodBeat.o(58450);
                return hFt;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$b' to match base method */
            @Override // kotlin.l.b.a.b.h.i.b
            public final /* synthetic */ C2307a hFq() {
                AppMethodBeat.i(58444);
                C2307a hFt = hFt();
                AppMethodBeat.o(58444);
                return hFt;
            }

            private C2307a() {
                AppMethodBeat.i(58436);
                AppMethodBeat.o(58436);
            }

            private c hFu() {
                int i2 = 1;
                AppMethodBeat.i(58438);
                c cVar = new c(this, (byte) 0);
                if ((this.bOT & 1) != 1) {
                    i2 = 0;
                }
                cVar.Txb = this.Txb;
                if ((this.bOT & 2) == 2) {
                    this.TxT = Collections.unmodifiableList(this.TxT);
                    this.bOT &= -3;
                }
                cVar.TxT = this.TxT;
                if ((this.bOT & 4) == 4) {
                    this.TxI = Collections.unmodifiableList(this.TxI);
                    this.bOT &= -5;
                }
                cVar.TxI = this.TxI;
                cVar.bOT = i2;
                AppMethodBeat.o(58438);
                return cVar;
            }

            public final C2307a d(c cVar) {
                AppMethodBeat.i(58439);
                if (cVar == c.hFs()) {
                    AppMethodBeat.o(58439);
                } else {
                    if (cVar.hEP()) {
                        aug(cVar.Txb);
                    }
                    if (!cVar.TxT.isEmpty()) {
                        if (this.TxT.isEmpty()) {
                            this.TxT = cVar.TxT;
                            this.bOT &= -3;
                        } else {
                            hFv();
                            this.TxT.addAll(cVar.TxT);
                        }
                    }
                    if (!cVar.TxI.isEmpty()) {
                        if (this.TxI.isEmpty()) {
                            this.TxI = cVar.TxI;
                            this.bOT &= -5;
                        } else {
                            hFp();
                            this.TxI.addAll(cVar.TxI);
                        }
                    }
                    a((i.c) cVar);
                    this.TwK = this.TwK.a(cVar.TwK);
                    AppMethodBeat.o(58439);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private kotlin.l.b.a.b.e.a.c.C2307a h(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                /*
                    r4 = this;
                    r3 = 58441(0xe449, float:8.1893E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    r2 = 0
                    kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.a$c> r0 = kotlin.l.b.a.b.e.a.c.TwL     // Catch:{ k -> 0x0016 }
                    java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                    kotlin.l.b.a.b.e.a$c r0 = (kotlin.l.b.a.b.e.a.c) r0     // Catch:{ k -> 0x0016 }
                    r4.d(r0)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return r4
                L_0x0016:
                    r0 = move-exception
                    r1 = r0
                    kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                    kotlin.l.b.a.b.e.a$c r0 = (kotlin.l.b.a.b.e.a.c) r0     // Catch:{ all -> 0x002e }
                    r2 = 58441(0xe449, float:8.1893E-41)
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.c.C2307a.h(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.a$c$a");
            }

            private C2307a aug(int i2) {
                this.bOT |= 1;
                this.Txb = i2;
                return this;
            }

            private void hFv() {
                AppMethodBeat.i(58442);
                if ((this.bOT & 2) != 2) {
                    this.TxT = new ArrayList(this.TxT);
                    this.bOT |= 2;
                }
                AppMethodBeat.o(58442);
            }

            private void hFp() {
                AppMethodBeat.i(58443);
                if ((this.bOT & 4) != 4) {
                    this.TxI = new ArrayList(this.TxI);
                    this.bOT |= 4;
                }
                AppMethodBeat.o(58443);
            }

            private C2307a hFt() {
                AppMethodBeat.i(58437);
                C2307a d2 = new C2307a().d(hFu());
                AppMethodBeat.o(58437);
                return d2;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                AppMethodBeat.i(58440);
                for (int i2 = 0; i2 < this.TxT.size(); i2++) {
                    if (!this.TxT.get(i2).isInitialized()) {
                        AppMethodBeat.o(58440);
                        return false;
                    }
                }
                if (!this.TDA.isInitialized()) {
                    AppMethodBeat.o(58440);
                    return false;
                }
                AppMethodBeat.o(58440);
                return true;
            }

            @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                AppMethodBeat.i(58445);
                c hFs = c.hFs();
                AppMethodBeat.o(58445);
                return hFs;
            }

            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ kotlin.l.b.a.b.h.i hED() {
                AppMethodBeat.i(58446);
                c hFs = c.hFs();
                AppMethodBeat.o(58446);
                return hFs;
            }

            @Override // kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEG() {
                AppMethodBeat.i(58452);
                c hFu = hFu();
                if (!hFu.isInitialized()) {
                    kotlin.l.b.a.b.h.w wVar = new kotlin.l.b.a.b.h.w();
                    AppMethodBeat.o(58452);
                    throw wVar;
                }
                AppMethodBeat.o(58452);
                return hFu;
            }

            static /* synthetic */ C2307a hFw() {
                AppMethodBeat.i(58454);
                C2307a aVar = new C2307a();
                AppMethodBeat.o(58454);
                return aVar;
            }
        }

        @Override // kotlin.l.b.a.b.h.r
        public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
            return TxS;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEw() {
            AppMethodBeat.i(58460);
            C2307a d2 = C2307a.hFw().d(this);
            AppMethodBeat.o(58460);
            return d2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEx() {
            AppMethodBeat.i(58461);
            C2307a hFw = C2307a.hFw();
            AppMethodBeat.o(58461);
            return hFw;
        }
    }

    public static final class h extends i.c<h> implements k {
        public static kotlin.l.b.a.b.h.s<h> TwL = new kotlin.l.b.a.b.h.b<h>() {
            /* class kotlin.l.b.a.b.e.a.h.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.h.s
            public final /* synthetic */ Object a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58585);
                h hVar = new h(eVar, gVar, (byte) 0);
                AppMethodBeat.o(58585);
                return hVar;
            }
        };
        private static final h Tyw;
        private final kotlin.l.b.a.b.h.d TwK;
        public s TxH;
        public List<Integer> TxI;
        public List<t> TxT;
        public int Txb;
        public List<r> Txu;
        public p TyA;
        public int TyB;
        d TyC;
        public int Tyk;
        public int Tyx;
        public p Tyy;
        public int Tyz;
        private int bOT;
        private byte bPe;
        private int bVY;

        /* synthetic */ h(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar, byte b2) {
            this(eVar, gVar);
        }

        /* synthetic */ h(i.b bVar, byte b2) {
            this(bVar);
        }

        private h(i.b<h, ?> bVar) {
            super(bVar);
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = bVar.TwK;
        }

        private h() {
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = kotlin.l.b.a.b.h.d.TDp;
        }

        public static h hFZ() {
            return Tyw;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v62, resolved type: java.util.List<kotlin.l.b.a.b.e.a$t> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v76, resolved type: java.util.List<kotlin.l.b.a.b.e.a$r> */
        /* JADX WARN: Multi-variable type inference failed */
        private h(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
            d.C2308a aVar;
            s.C2324a aVar2;
            p.b bVar;
            p.b bVar2;
            AppMethodBeat.i(58610);
            this.bPe = -1;
            this.bVY = -1;
            hEu();
            boolean z = false;
            d.b hJo = kotlin.l.b.a.b.h.d.hJo();
            kotlin.l.b.a.b.h.f f2 = kotlin.l.b.a.b.h.f.f(hJo, 1);
            boolean z2 = false;
            while (!z2) {
                try {
                    int yT = eVar.yT();
                    switch (yT) {
                        case 0:
                            z2 = true;
                            break;
                        case 8:
                            this.bOT |= 2;
                            this.Tyx = eVar.zi();
                            break;
                        case 16:
                            this.bOT |= 4;
                            this.Tyk = eVar.zi();
                            break;
                        case 26:
                            if ((this.bOT & 8) == 8) {
                                bVar2 = p.f(this.Tyy);
                            } else {
                                bVar2 = null;
                            }
                            this.Tyy = (p) eVar.a(p.TwL, gVar);
                            if (bVar2 != null) {
                                bVar2.j(this.Tyy);
                                this.Tyy = bVar2.hHo();
                            }
                            this.bOT |= 8;
                            break;
                        case 34:
                            if (!(z & true)) {
                                this.Txu = new ArrayList();
                                z |= true;
                            }
                            this.Txu.add(eVar.a(r.TwL, gVar));
                            break;
                        case 42:
                            if ((this.bOT & 32) == 32) {
                                bVar = p.f(this.TyA);
                            } else {
                                bVar = null;
                            }
                            this.TyA = (p) eVar.a(p.TwL, gVar);
                            if (bVar != null) {
                                bVar.j(this.TyA);
                                this.TyA = bVar.hHo();
                            }
                            this.bOT |= 32;
                            break;
                        case 50:
                            if (!(z & true)) {
                                this.TxT = new ArrayList();
                                z |= true;
                            }
                            this.TxT.add(eVar.a(t.TwL, gVar));
                            break;
                        case 56:
                            this.bOT |= 16;
                            this.Tyz = eVar.zi();
                            break;
                        case 64:
                            this.bOT |= 64;
                            this.TyB = eVar.zi();
                            break;
                        case 72:
                            this.bOT |= 1;
                            this.Txb = eVar.zi();
                            break;
                        case 242:
                            if ((this.bOT & 128) == 128) {
                                aVar2 = s.d(this.TxH);
                            } else {
                                aVar2 = null;
                            }
                            this.TxH = (s) eVar.a(s.TwL, gVar);
                            if (aVar2 != null) {
                                aVar2.g(this.TxH);
                                this.TxH = aVar2.hHK();
                            }
                            this.bOT |= 128;
                            break;
                        case 248:
                            if (!(z & true)) {
                                this.TxI = new ArrayList();
                                z |= true;
                            }
                            this.TxI.add(Integer.valueOf(eVar.zi()));
                            break;
                        case 250:
                            int fH = eVar.fH(eVar.zi());
                            if (!(z & true) && eVar.zk() > 0) {
                                this.TxI = new ArrayList();
                                z |= true;
                            }
                            while (eVar.zk() > 0) {
                                this.TxI.add(Integer.valueOf(eVar.zi()));
                            }
                            eVar.fI(fH);
                            break;
                        case CdnLogic.kAppTypeFestivalVideo:
                            if ((this.bOT & 256) == 256) {
                                aVar = this.TyC.hFy();
                            } else {
                                aVar = null;
                            }
                            this.TyC = (d) eVar.a(d.TwL, gVar);
                            if (aVar != null) {
                                aVar.d(this.TyC);
                                this.TyC = aVar.hFA();
                            }
                            this.bOT |= 256;
                            break;
                        default:
                            if (a(eVar, f2, gVar, yT)) {
                                break;
                            } else {
                                z2 = true;
                                break;
                            }
                    }
                } catch (kotlin.l.b.a.b.h.k e2) {
                    e2.TDK = this;
                    AppMethodBeat.o(58610);
                    throw e2;
                } catch (IOException e3) {
                    kotlin.l.b.a.b.h.k kVar = new kotlin.l.b.a.b.h.k(e3.getMessage());
                    kVar.TDK = this;
                    AppMethodBeat.o(58610);
                    throw kVar;
                } catch (Throwable th) {
                    if (z & true) {
                        this.Txu = Collections.unmodifiableList(this.Txu);
                    }
                    if (z & true) {
                        this.TxT = Collections.unmodifiableList(this.TxT);
                    }
                    if (z & true) {
                        this.TxI = Collections.unmodifiableList(this.TxI);
                    }
                    try {
                        f2.flush();
                        this.TwK = hJo.hJs();
                    } catch (IOException e4) {
                        this.TwK = hJo.hJs();
                    } catch (Throwable th2) {
                        this.TwK = hJo.hJs();
                        AppMethodBeat.o(58610);
                        throw th2;
                    }
                    this.TDA.yK();
                    AppMethodBeat.o(58610);
                    throw th;
                }
            }
            if (z & true) {
                this.Txu = Collections.unmodifiableList(this.Txu);
            }
            if (z & true) {
                this.TxT = Collections.unmodifiableList(this.TxT);
            }
            if (z & true) {
                this.TxI = Collections.unmodifiableList(this.TxI);
            }
            try {
                f2.flush();
                this.TwK = hJo.hJs();
            } catch (IOException e5) {
                this.TwK = hJo.hJs();
            } catch (Throwable th3) {
                this.TwK = hJo.hJs();
                AppMethodBeat.o(58610);
                throw th3;
            }
            this.TDA.yK();
            AppMethodBeat.o(58610);
        }

        static {
            AppMethodBeat.i(58618);
            h hVar = new h();
            Tyw = hVar;
            hVar.hEu();
            AppMethodBeat.o(58618);
        }

        @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
        public final kotlin.l.b.a.b.h.s<h> hEs() {
            return TwL;
        }

        public final boolean hEP() {
            return (this.bOT & 1) == 1;
        }

        public final boolean hGa() {
            return (this.bOT & 2) == 2;
        }

        public final boolean Az() {
            return (this.bOT & 4) == 4;
        }

        public final boolean hGb() {
            return (this.bOT & 8) == 8;
        }

        public final boolean hGc() {
            return (this.bOT & 16) == 16;
        }

        public final boolean hGd() {
            return (this.bOT & 32) == 32;
        }

        public final boolean hGe() {
            return (this.bOT & 64) == 64;
        }

        public final boolean hFb() {
            return (this.bOT & 128) == 128;
        }

        public final boolean hGf() {
            return (this.bOT & 256) == 256;
        }

        private void hEu() {
            AppMethodBeat.i(58611);
            this.Txb = 6;
            this.Tyx = 6;
            this.Tyk = 0;
            this.Tyy = p.hGS();
            this.Tyz = 0;
            this.Txu = Collections.emptyList();
            this.TyA = p.hGS();
            this.TyB = 0;
            this.TxT = Collections.emptyList();
            this.TxH = s.hHH();
            this.TxI = Collections.emptyList();
            this.TyC = d.hFx();
            AppMethodBeat.o(58611);
        }

        @Override // kotlin.l.b.a.b.h.r
        public final boolean isInitialized() {
            AppMethodBeat.i(58612);
            byte b2 = this.bPe;
            if (b2 == 1) {
                AppMethodBeat.o(58612);
                return true;
            } else if (b2 == 0) {
                AppMethodBeat.o(58612);
                return false;
            } else if (!Az()) {
                this.bPe = 0;
                AppMethodBeat.o(58612);
                return false;
            } else if (!hGb() || this.Tyy.isInitialized()) {
                for (int i2 = 0; i2 < this.Txu.size(); i2++) {
                    if (!this.Txu.get(i2).isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58612);
                        return false;
                    }
                }
                if (!hGd() || this.TyA.isInitialized()) {
                    for (int i3 = 0; i3 < this.TxT.size(); i3++) {
                        if (!this.TxT.get(i3).isInitialized()) {
                            this.bPe = 0;
                            AppMethodBeat.o(58612);
                            return false;
                        }
                    }
                    if (hFb() && !this.TxH.isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58612);
                        return false;
                    } else if (hGf() && !this.TyC.isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58612);
                        return false;
                    } else if (!this.TDA.isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58612);
                        return false;
                    } else {
                        this.bPe = 1;
                        AppMethodBeat.o(58612);
                        return true;
                    }
                } else {
                    this.bPe = 0;
                    AppMethodBeat.o(58612);
                    return false;
                }
            } else {
                this.bPe = 0;
                AppMethodBeat.o(58612);
                return false;
            }
        }

        @Override // kotlin.l.b.a.b.h.q
        public final void a(kotlin.l.b.a.b.h.f fVar) {
            AppMethodBeat.i(58613);
            yC();
            i.c<MessageType>.a hJC = hJC();
            if ((this.bOT & 2) == 2) {
                fVar.bs(1, this.Tyx);
            }
            if ((this.bOT & 4) == 4) {
                fVar.bs(2, this.Tyk);
            }
            if ((this.bOT & 8) == 8) {
                fVar.a(3, this.Tyy);
            }
            for (int i2 = 0; i2 < this.Txu.size(); i2++) {
                fVar.a(4, this.Txu.get(i2));
            }
            if ((this.bOT & 32) == 32) {
                fVar.a(5, this.TyA);
            }
            for (int i3 = 0; i3 < this.TxT.size(); i3++) {
                fVar.a(6, this.TxT.get(i3));
            }
            if ((this.bOT & 16) == 16) {
                fVar.bs(7, this.Tyz);
            }
            if ((this.bOT & 64) == 64) {
                fVar.bs(8, this.TyB);
            }
            if ((this.bOT & 1) == 1) {
                fVar.bs(9, this.Txb);
            }
            if ((this.bOT & 128) == 128) {
                fVar.a(30, this.TxH);
            }
            for (int i4 = 0; i4 < this.TxI.size(); i4++) {
                fVar.bs(31, this.TxI.get(i4).intValue());
            }
            if ((this.bOT & 256) == 256) {
                fVar.a(32, this.TyC);
            }
            hJC.b(19000, fVar);
            fVar.e(this.TwK);
            AppMethodBeat.o(58613);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final int yC() {
            AppMethodBeat.i(58614);
            int i2 = this.bVY;
            if (i2 != -1) {
                AppMethodBeat.o(58614);
                return i2;
            }
            int bu = (this.bOT & 2) == 2 ? kotlin.l.b.a.b.h.f.bu(1, this.Tyx) + 0 : 0;
            if ((this.bOT & 4) == 4) {
                bu += kotlin.l.b.a.b.h.f.bu(2, this.Tyk);
            }
            if ((this.bOT & 8) == 8) {
                bu += kotlin.l.b.a.b.h.f.c(3, this.Tyy);
            }
            int i3 = bu;
            for (int i4 = 0; i4 < this.Txu.size(); i4++) {
                i3 += kotlin.l.b.a.b.h.f.c(4, this.Txu.get(i4));
            }
            if ((this.bOT & 32) == 32) {
                i3 += kotlin.l.b.a.b.h.f.c(5, this.TyA);
            }
            for (int i5 = 0; i5 < this.TxT.size(); i5++) {
                i3 += kotlin.l.b.a.b.h.f.c(6, this.TxT.get(i5));
            }
            if ((this.bOT & 16) == 16) {
                i3 += kotlin.l.b.a.b.h.f.bu(7, this.Tyz);
            }
            if ((this.bOT & 64) == 64) {
                i3 += kotlin.l.b.a.b.h.f.bu(8, this.TyB);
            }
            if ((this.bOT & 1) == 1) {
                i3 += kotlin.l.b.a.b.h.f.bu(9, this.Txb);
            }
            if ((this.bOT & 128) == 128) {
                i3 += kotlin.l.b.a.b.h.f.c(30, this.TxH);
            }
            int i6 = 0;
            int i7 = 0;
            while (i6 < this.TxI.size()) {
                i6++;
                i7 = kotlin.l.b.a.b.h.f.fT(this.TxI.get(i6).intValue()) + i7;
            }
            int size = i3 + i7 + (this.TxI.size() * 2);
            if ((this.bOT & 256) == 256) {
                size += kotlin.l.b.a.b.h.f.c(32, this.TyC);
            }
            int yC = size + this.TDA.yC() + this.TwK.size();
            this.bVY = yC;
            AppMethodBeat.o(58614);
            return yC;
        }

        public static h b(InputStream inputStream, kotlin.l.b.a.b.h.g gVar) {
            AppMethodBeat.i(58615);
            h j2 = TwL.j(inputStream, gVar);
            AppMethodBeat.o(58615);
            return j2;
        }

        /* renamed from: kotlin.l.b.a.b.e.a$h$a  reason: collision with other inner class name */
        public static final class C2312a extends i.b<h, C2312a> implements k {
            private s TxH = s.hHH();
            private List<Integer> TxI = Collections.emptyList();
            private List<t> TxT = Collections.emptyList();
            private int Txb = 6;
            private List<r> Txu = Collections.emptyList();
            private p TyA = p.hGS();
            private int TyB;
            private d TyC = d.hFx();
            private int Tyk;
            private int Tyx = 6;
            private p Tyy = p.hGS();
            private int Tyz;
            private int bOT;

            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ i.a a(kotlin.l.b.a.b.h.i iVar) {
                AppMethodBeat.i(58602);
                C2312a e2 = e((h) iVar);
                AppMethodBeat.o(58602);
                return e2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
            public final /* synthetic */ a.AbstractC2337a c(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58604);
                C2312a m = m(eVar, gVar);
                AppMethodBeat.o(58604);
                return m;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a, java.lang.Object
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(58608);
                C2312a hGg = hGg();
                AppMethodBeat.o(58608);
                return hGg;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q.a d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58606);
                C2312a m = m(eVar, gVar);
                AppMethodBeat.o(58606);
                return m;
            }

            @Override // kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ i.a hEE() {
                AppMethodBeat.i(58603);
                C2312a hGg = hGg();
                AppMethodBeat.o(58603);
                return hGg;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ a.AbstractC2337a hEF() {
                AppMethodBeat.i(58605);
                C2312a hGg = hGg();
                AppMethodBeat.o(58605);
                return hGg;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$b' to match base method */
            @Override // kotlin.l.b.a.b.h.i.b
            public final /* synthetic */ C2312a hFq() {
                AppMethodBeat.i(58599);
                C2312a hGg = hGg();
                AppMethodBeat.o(58599);
                return hGg;
            }

            private C2312a() {
                AppMethodBeat.i(58586);
                AppMethodBeat.o(58586);
            }

            private h hGh() {
                int i2 = 1;
                AppMethodBeat.i(58588);
                h hVar = new h(this, (byte) 0);
                int i3 = this.bOT;
                if ((i3 & 1) != 1) {
                    i2 = 0;
                }
                hVar.Txb = this.Txb;
                if ((i3 & 2) == 2) {
                    i2 |= 2;
                }
                hVar.Tyx = this.Tyx;
                if ((i3 & 4) == 4) {
                    i2 |= 4;
                }
                hVar.Tyk = this.Tyk;
                if ((i3 & 8) == 8) {
                    i2 |= 8;
                }
                hVar.Tyy = this.Tyy;
                if ((i3 & 16) == 16) {
                    i2 |= 16;
                }
                hVar.Tyz = this.Tyz;
                if ((this.bOT & 32) == 32) {
                    this.Txu = Collections.unmodifiableList(this.Txu);
                    this.bOT &= -33;
                }
                hVar.Txu = this.Txu;
                if ((i3 & 64) == 64) {
                    i2 |= 32;
                }
                hVar.TyA = this.TyA;
                if ((i3 & 128) == 128) {
                    i2 |= 64;
                }
                hVar.TyB = this.TyB;
                if ((this.bOT & 256) == 256) {
                    this.TxT = Collections.unmodifiableList(this.TxT);
                    this.bOT &= -257;
                }
                hVar.TxT = this.TxT;
                if ((i3 & 512) == 512) {
                    i2 |= 128;
                }
                hVar.TxH = this.TxH;
                if ((this.bOT & 1024) == 1024) {
                    this.TxI = Collections.unmodifiableList(this.TxI);
                    this.bOT &= -1025;
                }
                hVar.TxI = this.TxI;
                if ((i3 & 2048) == 2048) {
                    i2 |= 256;
                }
                hVar.TyC = this.TyC;
                hVar.bOT = i2;
                AppMethodBeat.o(58588);
                return hVar;
            }

            public final C2312a e(h hVar) {
                AppMethodBeat.i(58589);
                if (hVar == h.hFZ()) {
                    AppMethodBeat.o(58589);
                } else {
                    if (hVar.hEP()) {
                        auo(hVar.Txb);
                    }
                    if (hVar.hGa()) {
                        aup(hVar.Tyx);
                    }
                    if (hVar.Az()) {
                        auq(hVar.Tyk);
                    }
                    if (hVar.hGb()) {
                        b(hVar.Tyy);
                    }
                    if (hVar.hGc()) {
                        aur(hVar.Tyz);
                    }
                    if (!hVar.Txu.isEmpty()) {
                        if (this.Txu.isEmpty()) {
                            this.Txu = hVar.Txu;
                            this.bOT &= -33;
                        } else {
                            hFf();
                            this.Txu.addAll(hVar.Txu);
                        }
                    }
                    if (hVar.hGd()) {
                        c(hVar.TyA);
                    }
                    if (hVar.hGe()) {
                        aus(hVar.TyB);
                    }
                    if (!hVar.TxT.isEmpty()) {
                        if (this.TxT.isEmpty()) {
                            this.TxT = hVar.TxT;
                            this.bOT &= -257;
                        } else {
                            hFv();
                            this.TxT.addAll(hVar.TxT);
                        }
                    }
                    if (hVar.hFb()) {
                        b(hVar.TxH);
                    }
                    if (!hVar.TxI.isEmpty()) {
                        if (this.TxI.isEmpty()) {
                            this.TxI = hVar.TxI;
                            this.bOT &= -1025;
                        } else {
                            hFp();
                            this.TxI.addAll(hVar.TxI);
                        }
                    }
                    if (hVar.hGf()) {
                        e(hVar.TyC);
                    }
                    a((i.c) hVar);
                    this.TwK = this.TwK.a(hVar.TwK);
                    AppMethodBeat.o(58589);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private kotlin.l.b.a.b.e.a.h.C2312a m(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                /*
                    r4 = this;
                    r3 = 58591(0xe4df, float:8.2103E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    r2 = 0
                    kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.a$h> r0 = kotlin.l.b.a.b.e.a.h.TwL     // Catch:{ k -> 0x0016 }
                    java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                    kotlin.l.b.a.b.e.a$h r0 = (kotlin.l.b.a.b.e.a.h) r0     // Catch:{ k -> 0x0016 }
                    r4.e(r0)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return r4
                L_0x0016:
                    r0 = move-exception
                    r1 = r0
                    kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                    kotlin.l.b.a.b.e.a$h r0 = (kotlin.l.b.a.b.e.a.h) r0     // Catch:{ all -> 0x002e }
                    r2 = 58591(0xe4df, float:8.2103E-41)
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.h.C2312a.m(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.a$h$a");
            }

            private C2312a auo(int i2) {
                this.bOT |= 1;
                this.Txb = i2;
                return this;
            }

            private C2312a aup(int i2) {
                this.bOT |= 2;
                this.Tyx = i2;
                return this;
            }

            private C2312a auq(int i2) {
                this.bOT |= 4;
                this.Tyk = i2;
                return this;
            }

            private C2312a b(p pVar) {
                AppMethodBeat.i(58592);
                if ((this.bOT & 8) != 8 || this.Tyy == p.hGS()) {
                    this.Tyy = pVar;
                } else {
                    this.Tyy = p.f(this.Tyy).j(pVar).hHo();
                }
                this.bOT |= 8;
                AppMethodBeat.o(58592);
                return this;
            }

            private C2312a aur(int i2) {
                this.bOT |= 16;
                this.Tyz = i2;
                return this;
            }

            private void hFf() {
                AppMethodBeat.i(58593);
                if ((this.bOT & 32) != 32) {
                    this.Txu = new ArrayList(this.Txu);
                    this.bOT |= 32;
                }
                AppMethodBeat.o(58593);
            }

            private C2312a c(p pVar) {
                AppMethodBeat.i(58594);
                if ((this.bOT & 64) != 64 || this.TyA == p.hGS()) {
                    this.TyA = pVar;
                } else {
                    this.TyA = p.f(this.TyA).j(pVar).hHo();
                }
                this.bOT |= 64;
                AppMethodBeat.o(58594);
                return this;
            }

            private C2312a aus(int i2) {
                this.bOT |= 128;
                this.TyB = i2;
                return this;
            }

            private void hFv() {
                AppMethodBeat.i(58595);
                if ((this.bOT & 256) != 256) {
                    this.TxT = new ArrayList(this.TxT);
                    this.bOT |= 256;
                }
                AppMethodBeat.o(58595);
            }

            private C2312a b(s sVar) {
                AppMethodBeat.i(58596);
                if ((this.bOT & 512) != 512 || this.TxH == s.hHH()) {
                    this.TxH = sVar;
                } else {
                    this.TxH = s.d(this.TxH).g(sVar).hHK();
                }
                this.bOT |= 512;
                AppMethodBeat.o(58596);
                return this;
            }

            private void hFp() {
                AppMethodBeat.i(58597);
                if ((this.bOT & 1024) != 1024) {
                    this.TxI = new ArrayList(this.TxI);
                    this.bOT |= 1024;
                }
                AppMethodBeat.o(58597);
            }

            private C2312a e(d dVar) {
                AppMethodBeat.i(58598);
                if ((this.bOT & 2048) != 2048 || this.TyC == d.hFx()) {
                    this.TyC = dVar;
                } else {
                    this.TyC = d.a(this.TyC).d(dVar).hFA();
                }
                this.bOT |= 2048;
                AppMethodBeat.o(58598);
                return this;
            }

            private C2312a hGg() {
                AppMethodBeat.i(58587);
                C2312a e2 = new C2312a().e(hGh());
                AppMethodBeat.o(58587);
                return e2;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                AppMethodBeat.i(58590);
                if (!((this.bOT & 4) == 4)) {
                    AppMethodBeat.o(58590);
                    return false;
                }
                if (!((this.bOT & 8) == 8) || this.Tyy.isInitialized()) {
                    for (int i2 = 0; i2 < this.Txu.size(); i2++) {
                        if (!this.Txu.get(i2).isInitialized()) {
                            AppMethodBeat.o(58590);
                            return false;
                        }
                    }
                    if (!((this.bOT & 64) == 64) || this.TyA.isInitialized()) {
                        for (int i3 = 0; i3 < this.TxT.size(); i3++) {
                            if (!this.TxT.get(i3).isInitialized()) {
                                AppMethodBeat.o(58590);
                                return false;
                            }
                        }
                        if (!((this.bOT & 512) == 512) || this.TxH.isInitialized()) {
                            if (((this.bOT & 2048) == 2048) && !this.TyC.isInitialized()) {
                                AppMethodBeat.o(58590);
                                return false;
                            } else if (!this.TDA.isInitialized()) {
                                AppMethodBeat.o(58590);
                                return false;
                            } else {
                                AppMethodBeat.o(58590);
                                return true;
                            }
                        } else {
                            AppMethodBeat.o(58590);
                            return false;
                        }
                    } else {
                        AppMethodBeat.o(58590);
                        return false;
                    }
                } else {
                    AppMethodBeat.o(58590);
                    return false;
                }
            }

            @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                AppMethodBeat.i(58600);
                h hFZ = h.hFZ();
                AppMethodBeat.o(58600);
                return hFZ;
            }

            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ kotlin.l.b.a.b.h.i hED() {
                AppMethodBeat.i(58601);
                h hFZ = h.hFZ();
                AppMethodBeat.o(58601);
                return hFZ;
            }

            @Override // kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEG() {
                AppMethodBeat.i(58607);
                h hGh = hGh();
                if (!hGh.isInitialized()) {
                    kotlin.l.b.a.b.h.w wVar = new kotlin.l.b.a.b.h.w();
                    AppMethodBeat.o(58607);
                    throw wVar;
                }
                AppMethodBeat.o(58607);
                return hGh;
            }

            static /* synthetic */ C2312a hGi() {
                AppMethodBeat.i(58609);
                C2312a aVar = new C2312a();
                AppMethodBeat.o(58609);
                return aVar;
            }
        }

        @Override // kotlin.l.b.a.b.h.r
        public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
            return Tyw;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEw() {
            AppMethodBeat.i(58616);
            C2312a e2 = C2312a.hGi().e(this);
            AppMethodBeat.o(58616);
            return e2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEx() {
            AppMethodBeat.i(58617);
            C2312a hGi = C2312a.hGi();
            AppMethodBeat.o(58617);
            return hGi;
        }
    }

    public static final class m extends i.c<m> implements n {
        public static kotlin.l.b.a.b.h.s<m> TwL = new kotlin.l.b.a.b.h.b<m>() {
            /* class kotlin.l.b.a.b.e.a.m.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.h.s
            public final /* synthetic */ Object a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58692);
                m mVar = new m(eVar, gVar, (byte) 0);
                AppMethodBeat.o(58692);
                return mVar;
            }
        };
        private static final m TyT;
        private final kotlin.l.b.a.b.h.d TwK;
        public List<Integer> TxI;
        public int Txb;
        public List<r> Txu;
        public p TyA;
        public int TyB;
        public t TyU;
        public int TyV;
        public int TyW;
        public int Tyk;
        public int Tyx;
        public p Tyy;
        public int Tyz;
        private int bOT;
        private byte bPe;
        private int bVY;

        /* synthetic */ m(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar, byte b2) {
            this(eVar, gVar);
        }

        /* synthetic */ m(i.b bVar, byte b2) {
            this(bVar);
        }

        private m(i.b<m, ?> bVar) {
            super(bVar);
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = bVar.TwK;
        }

        private m() {
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = kotlin.l.b.a.b.h.d.TDp;
        }

        public static m hGv() {
            return TyT;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v81, resolved type: java.util.List<kotlin.l.b.a.b.e.a$r> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0055  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0061  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private m(kotlin.l.b.a.b.h.e r13, kotlin.l.b.a.b.h.g r14) {
            /*
            // Method dump skipped, instructions count: 642
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.m.<init>(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):void");
        }

        static {
            AppMethodBeat.i(58722);
            m mVar = new m();
            TyT = mVar;
            mVar.hEu();
            AppMethodBeat.o(58722);
        }

        @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
        public final kotlin.l.b.a.b.h.s<m> hEs() {
            return TwL;
        }

        public final boolean hEP() {
            return (this.bOT & 1) == 1;
        }

        public final boolean hGa() {
            return (this.bOT & 2) == 2;
        }

        public final boolean Az() {
            return (this.bOT & 4) == 4;
        }

        public final boolean hGb() {
            return (this.bOT & 8) == 8;
        }

        public final boolean hGc() {
            return (this.bOT & 16) == 16;
        }

        public final boolean hGd() {
            return (this.bOT & 32) == 32;
        }

        public final boolean hGe() {
            return (this.bOT & 64) == 64;
        }

        public final boolean hGw() {
            return (this.bOT & 128) == 128;
        }

        public final boolean hGx() {
            return (this.bOT & 256) == 256;
        }

        public final boolean hGy() {
            return (this.bOT & 512) == 512;
        }

        private void hEu() {
            AppMethodBeat.i(58716);
            this.Txb = com.tencent.mm.plugin.appbrand.jsapi.openvoice.m.CTRL_INDEX;
            this.Tyx = 2054;
            this.Tyk = 0;
            this.Tyy = p.hGS();
            this.Tyz = 0;
            this.Txu = Collections.emptyList();
            this.TyA = p.hGS();
            this.TyB = 0;
            this.TyU = t.hHN();
            this.TyV = 0;
            this.TyW = 0;
            this.TxI = Collections.emptyList();
            AppMethodBeat.o(58716);
        }

        @Override // kotlin.l.b.a.b.h.r
        public final boolean isInitialized() {
            AppMethodBeat.i(58717);
            byte b2 = this.bPe;
            if (b2 == 1) {
                AppMethodBeat.o(58717);
                return true;
            } else if (b2 == 0) {
                AppMethodBeat.o(58717);
                return false;
            } else if (!Az()) {
                this.bPe = 0;
                AppMethodBeat.o(58717);
                return false;
            } else if (!hGb() || this.Tyy.isInitialized()) {
                for (int i2 = 0; i2 < this.Txu.size(); i2++) {
                    if (!this.Txu.get(i2).isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58717);
                        return false;
                    }
                }
                if (hGd() && !this.TyA.isInitialized()) {
                    this.bPe = 0;
                    AppMethodBeat.o(58717);
                    return false;
                } else if (hGw() && !this.TyU.isInitialized()) {
                    this.bPe = 0;
                    AppMethodBeat.o(58717);
                    return false;
                } else if (!this.TDA.isInitialized()) {
                    this.bPe = 0;
                    AppMethodBeat.o(58717);
                    return false;
                } else {
                    this.bPe = 1;
                    AppMethodBeat.o(58717);
                    return true;
                }
            } else {
                this.bPe = 0;
                AppMethodBeat.o(58717);
                return false;
            }
        }

        @Override // kotlin.l.b.a.b.h.q
        public final void a(kotlin.l.b.a.b.h.f fVar) {
            AppMethodBeat.i(58718);
            yC();
            i.c<MessageType>.a hJC = hJC();
            if ((this.bOT & 2) == 2) {
                fVar.bs(1, this.Tyx);
            }
            if ((this.bOT & 4) == 4) {
                fVar.bs(2, this.Tyk);
            }
            if ((this.bOT & 8) == 8) {
                fVar.a(3, this.Tyy);
            }
            for (int i2 = 0; i2 < this.Txu.size(); i2++) {
                fVar.a(4, this.Txu.get(i2));
            }
            if ((this.bOT & 32) == 32) {
                fVar.a(5, this.TyA);
            }
            if ((this.bOT & 128) == 128) {
                fVar.a(6, this.TyU);
            }
            if ((this.bOT & 256) == 256) {
                fVar.bs(7, this.TyV);
            }
            if ((this.bOT & 512) == 512) {
                fVar.bs(8, this.TyW);
            }
            if ((this.bOT & 16) == 16) {
                fVar.bs(9, this.Tyz);
            }
            if ((this.bOT & 64) == 64) {
                fVar.bs(10, this.TyB);
            }
            if ((this.bOT & 1) == 1) {
                fVar.bs(11, this.Txb);
            }
            for (int i3 = 0; i3 < this.TxI.size(); i3++) {
                fVar.bs(31, this.TxI.get(i3).intValue());
            }
            hJC.b(19000, fVar);
            fVar.e(this.TwK);
            AppMethodBeat.o(58718);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final int yC() {
            AppMethodBeat.i(58719);
            int i2 = this.bVY;
            if (i2 != -1) {
                AppMethodBeat.o(58719);
                return i2;
            }
            int bu = (this.bOT & 2) == 2 ? kotlin.l.b.a.b.h.f.bu(1, this.Tyx) + 0 : 0;
            if ((this.bOT & 4) == 4) {
                bu += kotlin.l.b.a.b.h.f.bu(2, this.Tyk);
            }
            if ((this.bOT & 8) == 8) {
                bu += kotlin.l.b.a.b.h.f.c(3, this.Tyy);
            }
            int i3 = bu;
            for (int i4 = 0; i4 < this.Txu.size(); i4++) {
                i3 += kotlin.l.b.a.b.h.f.c(4, this.Txu.get(i4));
            }
            if ((this.bOT & 32) == 32) {
                i3 += kotlin.l.b.a.b.h.f.c(5, this.TyA);
            }
            if ((this.bOT & 128) == 128) {
                i3 += kotlin.l.b.a.b.h.f.c(6, this.TyU);
            }
            if ((this.bOT & 256) == 256) {
                i3 += kotlin.l.b.a.b.h.f.bu(7, this.TyV);
            }
            if ((this.bOT & 512) == 512) {
                i3 += kotlin.l.b.a.b.h.f.bu(8, this.TyW);
            }
            if ((this.bOT & 16) == 16) {
                i3 += kotlin.l.b.a.b.h.f.bu(9, this.Tyz);
            }
            if ((this.bOT & 64) == 64) {
                i3 += kotlin.l.b.a.b.h.f.bu(10, this.TyB);
            }
            if ((this.bOT & 1) == 1) {
                i3 += kotlin.l.b.a.b.h.f.bu(11, this.Txb);
            }
            int i5 = 0;
            int i6 = 0;
            while (i5 < this.TxI.size()) {
                i5++;
                i6 = kotlin.l.b.a.b.h.f.fT(this.TxI.get(i5).intValue()) + i6;
            }
            int size = i3 + i6 + (this.TxI.size() * 2) + this.TDA.yC() + this.TwK.size();
            this.bVY = size;
            AppMethodBeat.o(58719);
            return size;
        }

        /* renamed from: kotlin.l.b.a.b.e.a$m$a  reason: collision with other inner class name */
        public static final class C2315a extends i.b<m, C2315a> implements n {
            private List<Integer> TxI = Collections.emptyList();
            private int Txb = com.tencent.mm.plugin.appbrand.jsapi.openvoice.m.CTRL_INDEX;
            private List<r> Txu = Collections.emptyList();
            private p TyA = p.hGS();
            private int TyB;
            private t TyU = t.hHN();
            private int TyV;
            private int TyW;
            private int Tyk;
            private int Tyx = 2054;
            private p Tyy = p.hGS();
            private int Tyz;
            private int bOT;

            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ i.a a(kotlin.l.b.a.b.h.i iVar) {
                AppMethodBeat.i(58707);
                C2315a d2 = d((m) iVar);
                AppMethodBeat.o(58707);
                return d2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
            public final /* synthetic */ a.AbstractC2337a c(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58709);
                C2315a p = p(eVar, gVar);
                AppMethodBeat.o(58709);
                return p;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a, java.lang.Object
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(58713);
                C2315a hGz = hGz();
                AppMethodBeat.o(58713);
                return hGz;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q.a d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58711);
                C2315a p = p(eVar, gVar);
                AppMethodBeat.o(58711);
                return p;
            }

            @Override // kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ i.a hEE() {
                AppMethodBeat.i(58708);
                C2315a hGz = hGz();
                AppMethodBeat.o(58708);
                return hGz;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ a.AbstractC2337a hEF() {
                AppMethodBeat.i(58710);
                C2315a hGz = hGz();
                AppMethodBeat.o(58710);
                return hGz;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$b' to match base method */
            @Override // kotlin.l.b.a.b.h.i.b
            public final /* synthetic */ C2315a hFq() {
                AppMethodBeat.i(58704);
                C2315a hGz = hGz();
                AppMethodBeat.o(58704);
                return hGz;
            }

            private C2315a() {
                AppMethodBeat.i(58693);
                AppMethodBeat.o(58693);
            }

            private m hGA() {
                int i2 = 1;
                AppMethodBeat.i(58695);
                m mVar = new m(this, (byte) 0);
                int i3 = this.bOT;
                if ((i3 & 1) != 1) {
                    i2 = 0;
                }
                mVar.Txb = this.Txb;
                if ((i3 & 2) == 2) {
                    i2 |= 2;
                }
                mVar.Tyx = this.Tyx;
                if ((i3 & 4) == 4) {
                    i2 |= 4;
                }
                mVar.Tyk = this.Tyk;
                if ((i3 & 8) == 8) {
                    i2 |= 8;
                }
                mVar.Tyy = this.Tyy;
                if ((i3 & 16) == 16) {
                    i2 |= 16;
                }
                mVar.Tyz = this.Tyz;
                if ((this.bOT & 32) == 32) {
                    this.Txu = Collections.unmodifiableList(this.Txu);
                    this.bOT &= -33;
                }
                mVar.Txu = this.Txu;
                if ((i3 & 64) == 64) {
                    i2 |= 32;
                }
                mVar.TyA = this.TyA;
                if ((i3 & 128) == 128) {
                    i2 |= 64;
                }
                mVar.TyB = this.TyB;
                if ((i3 & 256) == 256) {
                    i2 |= 128;
                }
                mVar.TyU = this.TyU;
                if ((i3 & 512) == 512) {
                    i2 |= 256;
                }
                mVar.TyV = this.TyV;
                if ((i3 & 1024) == 1024) {
                    i2 |= 512;
                }
                mVar.TyW = this.TyW;
                if ((this.bOT & 2048) == 2048) {
                    this.TxI = Collections.unmodifiableList(this.TxI);
                    this.bOT &= -2049;
                }
                mVar.TxI = this.TxI;
                mVar.bOT = i2;
                AppMethodBeat.o(58695);
                return mVar;
            }

            public final C2315a d(m mVar) {
                AppMethodBeat.i(58696);
                if (mVar == m.hGv()) {
                    AppMethodBeat.o(58696);
                } else {
                    if (mVar.hEP()) {
                        auv(mVar.Txb);
                    }
                    if (mVar.hGa()) {
                        auw(mVar.Tyx);
                    }
                    if (mVar.Az()) {
                        aux(mVar.Tyk);
                    }
                    if (mVar.hGb()) {
                        d(mVar.Tyy);
                    }
                    if (mVar.hGc()) {
                        auy(mVar.Tyz);
                    }
                    if (!mVar.Txu.isEmpty()) {
                        if (this.Txu.isEmpty()) {
                            this.Txu = mVar.Txu;
                            this.bOT &= -33;
                        } else {
                            hFf();
                            this.Txu.addAll(mVar.Txu);
                        }
                    }
                    if (mVar.hGd()) {
                        e(mVar.TyA);
                    }
                    if (mVar.hGe()) {
                        auz(mVar.TyB);
                    }
                    if (mVar.hGw()) {
                        a(mVar.TyU);
                    }
                    if (mVar.hGx()) {
                        auA(mVar.TyV);
                    }
                    if (mVar.hGy()) {
                        auB(mVar.TyW);
                    }
                    if (!mVar.TxI.isEmpty()) {
                        if (this.TxI.isEmpty()) {
                            this.TxI = mVar.TxI;
                            this.bOT &= -2049;
                        } else {
                            hFp();
                            this.TxI.addAll(mVar.TxI);
                        }
                    }
                    a((i.c) mVar);
                    this.TwK = this.TwK.a(mVar.TwK);
                    AppMethodBeat.o(58696);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private kotlin.l.b.a.b.e.a.m.C2315a p(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                /*
                    r4 = this;
                    r3 = 58698(0xe54a, float:8.2253E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    r2 = 0
                    kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.a$m> r0 = kotlin.l.b.a.b.e.a.m.TwL     // Catch:{ k -> 0x0016 }
                    java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                    kotlin.l.b.a.b.e.a$m r0 = (kotlin.l.b.a.b.e.a.m) r0     // Catch:{ k -> 0x0016 }
                    r4.d(r0)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return r4
                L_0x0016:
                    r0 = move-exception
                    r1 = r0
                    kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                    kotlin.l.b.a.b.e.a$m r0 = (kotlin.l.b.a.b.e.a.m) r0     // Catch:{ all -> 0x002e }
                    r2 = 58698(0xe54a, float:8.2253E-41)
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.m.C2315a.p(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.a$m$a");
            }

            private C2315a auv(int i2) {
                this.bOT |= 1;
                this.Txb = i2;
                return this;
            }

            private C2315a auw(int i2) {
                this.bOT |= 2;
                this.Tyx = i2;
                return this;
            }

            private C2315a aux(int i2) {
                this.bOT |= 4;
                this.Tyk = i2;
                return this;
            }

            private C2315a d(p pVar) {
                AppMethodBeat.i(58699);
                if ((this.bOT & 8) != 8 || this.Tyy == p.hGS()) {
                    this.Tyy = pVar;
                } else {
                    this.Tyy = p.f(this.Tyy).j(pVar).hHo();
                }
                this.bOT |= 8;
                AppMethodBeat.o(58699);
                return this;
            }

            private C2315a auy(int i2) {
                this.bOT |= 16;
                this.Tyz = i2;
                return this;
            }

            private void hFf() {
                AppMethodBeat.i(58700);
                if ((this.bOT & 32) != 32) {
                    this.Txu = new ArrayList(this.Txu);
                    this.bOT |= 32;
                }
                AppMethodBeat.o(58700);
            }

            private C2315a e(p pVar) {
                AppMethodBeat.i(58701);
                if ((this.bOT & 64) != 64 || this.TyA == p.hGS()) {
                    this.TyA = pVar;
                } else {
                    this.TyA = p.f(this.TyA).j(pVar).hHo();
                }
                this.bOT |= 64;
                AppMethodBeat.o(58701);
                return this;
            }

            private C2315a auz(int i2) {
                this.bOT |= 128;
                this.TyB = i2;
                return this;
            }

            private C2315a a(t tVar) {
                AppMethodBeat.i(58702);
                if ((this.bOT & 256) != 256 || this.TyU == t.hHN()) {
                    this.TyU = tVar;
                } else {
                    this.TyU = t.b(this.TyU).d(tVar).hHR();
                }
                this.bOT |= 256;
                AppMethodBeat.o(58702);
                return this;
            }

            private C2315a auA(int i2) {
                this.bOT |= 512;
                this.TyV = i2;
                return this;
            }

            private C2315a auB(int i2) {
                this.bOT |= 1024;
                this.TyW = i2;
                return this;
            }

            private void hFp() {
                AppMethodBeat.i(58703);
                if ((this.bOT & 2048) != 2048) {
                    this.TxI = new ArrayList(this.TxI);
                    this.bOT |= 2048;
                }
                AppMethodBeat.o(58703);
            }

            private C2315a hGz() {
                AppMethodBeat.i(58694);
                C2315a d2 = new C2315a().d(hGA());
                AppMethodBeat.o(58694);
                return d2;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                AppMethodBeat.i(58697);
                if (!((this.bOT & 4) == 4)) {
                    AppMethodBeat.o(58697);
                    return false;
                }
                if (!((this.bOT & 8) == 8) || this.Tyy.isInitialized()) {
                    for (int i2 = 0; i2 < this.Txu.size(); i2++) {
                        if (!this.Txu.get(i2).isInitialized()) {
                            AppMethodBeat.o(58697);
                            return false;
                        }
                    }
                    if (!((this.bOT & 64) == 64) || this.TyA.isInitialized()) {
                        if (((this.bOT & 256) == 256) && !this.TyU.isInitialized()) {
                            AppMethodBeat.o(58697);
                            return false;
                        } else if (!this.TDA.isInitialized()) {
                            AppMethodBeat.o(58697);
                            return false;
                        } else {
                            AppMethodBeat.o(58697);
                            return true;
                        }
                    } else {
                        AppMethodBeat.o(58697);
                        return false;
                    }
                } else {
                    AppMethodBeat.o(58697);
                    return false;
                }
            }

            @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                AppMethodBeat.i(58705);
                m hGv = m.hGv();
                AppMethodBeat.o(58705);
                return hGv;
            }

            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ kotlin.l.b.a.b.h.i hED() {
                AppMethodBeat.i(58706);
                m hGv = m.hGv();
                AppMethodBeat.o(58706);
                return hGv;
            }

            @Override // kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEG() {
                AppMethodBeat.i(58712);
                m hGA = hGA();
                if (!hGA.isInitialized()) {
                    kotlin.l.b.a.b.h.w wVar = new kotlin.l.b.a.b.h.w();
                    AppMethodBeat.o(58712);
                    throw wVar;
                }
                AppMethodBeat.o(58712);
                return hGA;
            }

            static /* synthetic */ C2315a hGB() {
                AppMethodBeat.i(58714);
                C2315a aVar = new C2315a();
                AppMethodBeat.o(58714);
                return aVar;
            }
        }

        @Override // kotlin.l.b.a.b.h.r
        public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
            return TyT;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEw() {
            AppMethodBeat.i(58720);
            C2315a d2 = C2315a.hGB().d(this);
            AppMethodBeat.o(58720);
            return d2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEx() {
            AppMethodBeat.i(58721);
            C2315a hGB = C2315a.hGB();
            AppMethodBeat.o(58721);
            return hGB;
        }
    }

    public static final class t extends i.c<t> implements w {
        public static kotlin.l.b.a.b.h.s<t> TwL = new kotlin.l.b.a.b.h.b<t>() {
            /* class kotlin.l.b.a.b.e.a.t.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.h.s
            public final /* synthetic */ Object a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58958);
                t tVar = new t(eVar, gVar, (byte) 0);
                AppMethodBeat.o(58958);
                return tVar;
            }
        };
        private static final t TzY;
        public int TAa;
        private final kotlin.l.b.a.b.h.d TwK;
        public int Txb;
        public int Tyk;
        public p TzZ;
        public p Tzy;
        public int Tzz;
        private int bOT;
        private byte bPe;
        private int bVY;

        /* synthetic */ t(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar, byte b2) {
            this(eVar, gVar);
        }

        /* synthetic */ t(i.b bVar, byte b2) {
            this(bVar);
        }

        private t(i.b<t, ?> bVar) {
            super(bVar);
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = bVar.TwK;
        }

        private t() {
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = kotlin.l.b.a.b.h.d.TDp;
        }

        public static t hHN() {
            return TzY;
        }

        private t(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
            p.b bVar;
            p.b bVar2;
            AppMethodBeat.i(58978);
            this.bPe = -1;
            this.bVY = -1;
            hEu();
            d.b hJo = kotlin.l.b.a.b.h.d.hJo();
            kotlin.l.b.a.b.h.f f2 = kotlin.l.b.a.b.h.f.f(hJo, 1);
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
                            this.Txb = eVar.zi();
                            break;
                        case 16:
                            this.bOT |= 2;
                            this.Tyk = eVar.zi();
                            break;
                        case 26:
                            if ((this.bOT & 4) == 4) {
                                bVar2 = this.Tzy.hHf();
                            } else {
                                bVar2 = null;
                            }
                            this.Tzy = (p) eVar.a(p.TwL, gVar);
                            if (bVar2 != null) {
                                bVar2.j(this.Tzy);
                                this.Tzy = bVar2.hHo();
                            }
                            this.bOT |= 4;
                            break;
                        case 34:
                            if ((this.bOT & 16) == 16) {
                                bVar = this.TzZ.hHf();
                            } else {
                                bVar = null;
                            }
                            this.TzZ = (p) eVar.a(p.TwL, gVar);
                            if (bVar != null) {
                                bVar.j(this.TzZ);
                                this.TzZ = bVar.hHo();
                            }
                            this.bOT |= 16;
                            break;
                        case 40:
                            this.bOT |= 8;
                            this.Tzz = eVar.zi();
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                            this.bOT |= 32;
                            this.TAa = eVar.zi();
                            break;
                        default:
                            if (a(eVar, f2, gVar, yT)) {
                                break;
                            } else {
                                z = true;
                                break;
                            }
                    }
                } catch (kotlin.l.b.a.b.h.k e2) {
                    e2.TDK = this;
                    AppMethodBeat.o(58978);
                    throw e2;
                } catch (IOException e3) {
                    kotlin.l.b.a.b.h.k kVar = new kotlin.l.b.a.b.h.k(e3.getMessage());
                    kVar.TDK = this;
                    AppMethodBeat.o(58978);
                    throw kVar;
                } catch (Throwable th) {
                    try {
                        f2.flush();
                        this.TwK = hJo.hJs();
                    } catch (IOException e4) {
                        this.TwK = hJo.hJs();
                    } catch (Throwable th2) {
                        this.TwK = hJo.hJs();
                        AppMethodBeat.o(58978);
                        throw th2;
                    }
                    this.TDA.yK();
                    AppMethodBeat.o(58978);
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
                AppMethodBeat.o(58978);
                throw th3;
            }
            this.TDA.yK();
            AppMethodBeat.o(58978);
        }

        static {
            AppMethodBeat.i(58986);
            t tVar = new t();
            TzY = tVar;
            tVar.hEu();
            AppMethodBeat.o(58986);
        }

        @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
        public final kotlin.l.b.a.b.h.s<t> hEs() {
            return TwL;
        }

        public final boolean hEP() {
            return (this.bOT & 1) == 1;
        }

        public final boolean Az() {
            return (this.bOT & 2) == 2;
        }

        public final boolean Cm() {
            return (this.bOT & 4) == 4;
        }

        public final boolean hHi() {
            return (this.bOT & 8) == 8;
        }

        public final boolean hHO() {
            return (this.bOT & 16) == 16;
        }

        public final boolean hHP() {
            return (this.bOT & 32) == 32;
        }

        private void hEu() {
            AppMethodBeat.i(58979);
            this.Txb = 0;
            this.Tyk = 0;
            this.Tzy = p.hGS();
            this.Tzz = 0;
            this.TzZ = p.hGS();
            this.TAa = 0;
            AppMethodBeat.o(58979);
        }

        @Override // kotlin.l.b.a.b.h.r
        public final boolean isInitialized() {
            AppMethodBeat.i(58980);
            byte b2 = this.bPe;
            if (b2 == 1) {
                AppMethodBeat.o(58980);
                return true;
            } else if (b2 == 0) {
                AppMethodBeat.o(58980);
                return false;
            } else if (!Az()) {
                this.bPe = 0;
                AppMethodBeat.o(58980);
                return false;
            } else if (Cm() && !this.Tzy.isInitialized()) {
                this.bPe = 0;
                AppMethodBeat.o(58980);
                return false;
            } else if (hHO() && !this.TzZ.isInitialized()) {
                this.bPe = 0;
                AppMethodBeat.o(58980);
                return false;
            } else if (!this.TDA.isInitialized()) {
                this.bPe = 0;
                AppMethodBeat.o(58980);
                return false;
            } else {
                this.bPe = 1;
                AppMethodBeat.o(58980);
                return true;
            }
        }

        @Override // kotlin.l.b.a.b.h.q
        public final void a(kotlin.l.b.a.b.h.f fVar) {
            AppMethodBeat.i(58981);
            yC();
            i.c<MessageType>.a hJC = hJC();
            if ((this.bOT & 1) == 1) {
                fVar.bs(1, this.Txb);
            }
            if ((this.bOT & 2) == 2) {
                fVar.bs(2, this.Tyk);
            }
            if ((this.bOT & 4) == 4) {
                fVar.a(3, this.Tzy);
            }
            if ((this.bOT & 16) == 16) {
                fVar.a(4, this.TzZ);
            }
            if ((this.bOT & 8) == 8) {
                fVar.bs(5, this.Tzz);
            }
            if ((this.bOT & 32) == 32) {
                fVar.bs(6, this.TAa);
            }
            hJC.b(200, fVar);
            fVar.e(this.TwK);
            AppMethodBeat.o(58981);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final int yC() {
            AppMethodBeat.i(58982);
            int i2 = this.bVY;
            if (i2 != -1) {
                AppMethodBeat.o(58982);
                return i2;
            }
            int i3 = 0;
            if ((this.bOT & 1) == 1) {
                i3 = kotlin.l.b.a.b.h.f.bu(1, this.Txb) + 0;
            }
            if ((this.bOT & 2) == 2) {
                i3 += kotlin.l.b.a.b.h.f.bu(2, this.Tyk);
            }
            if ((this.bOT & 4) == 4) {
                i3 += kotlin.l.b.a.b.h.f.c(3, this.Tzy);
            }
            if ((this.bOT & 16) == 16) {
                i3 += kotlin.l.b.a.b.h.f.c(4, this.TzZ);
            }
            if ((this.bOT & 8) == 8) {
                i3 += kotlin.l.b.a.b.h.f.bu(5, this.Tzz);
            }
            if ((this.bOT & 32) == 32) {
                i3 += kotlin.l.b.a.b.h.f.bu(6, this.TAa);
            }
            int yC = i3 + this.TDA.yC() + this.TwK.size();
            this.bVY = yC;
            AppMethodBeat.o(58982);
            return yC;
        }

        /* renamed from: kotlin.l.b.a.b.e.a$t$a  reason: collision with other inner class name */
        public static final class C2325a extends i.b<t, C2325a> implements w {
            private int TAa;
            private int Txb;
            private int Tyk;
            private p TzZ = p.hGS();
            private p Tzy = p.hGS();
            private int Tzz;
            private int bOT;

            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ i.a a(kotlin.l.b.a.b.h.i iVar) {
                AppMethodBeat.i(58970);
                C2325a d2 = d((t) iVar);
                AppMethodBeat.o(58970);
                return d2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
            public final /* synthetic */ a.AbstractC2337a c(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58972);
                C2325a y = y(eVar, gVar);
                AppMethodBeat.o(58972);
                return y;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a, java.lang.Object
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(58976);
                C2325a hHQ = hHQ();
                AppMethodBeat.o(58976);
                return hHQ;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q.a d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58974);
                C2325a y = y(eVar, gVar);
                AppMethodBeat.o(58974);
                return y;
            }

            @Override // kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ i.a hEE() {
                AppMethodBeat.i(58971);
                C2325a hHQ = hHQ();
                AppMethodBeat.o(58971);
                return hHQ;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ a.AbstractC2337a hEF() {
                AppMethodBeat.i(58973);
                C2325a hHQ = hHQ();
                AppMethodBeat.o(58973);
                return hHQ;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$b' to match base method */
            @Override // kotlin.l.b.a.b.h.i.b
            public final /* synthetic */ C2325a hFq() {
                AppMethodBeat.i(58967);
                C2325a hHQ = hHQ();
                AppMethodBeat.o(58967);
                return hHQ;
            }

            private C2325a() {
                AppMethodBeat.i(58959);
                AppMethodBeat.o(58959);
            }

            public final t hHR() {
                int i2 = 1;
                AppMethodBeat.i(58961);
                t tVar = new t(this, (byte) 0);
                int i3 = this.bOT;
                if ((i3 & 1) != 1) {
                    i2 = 0;
                }
                tVar.Txb = this.Txb;
                if ((i3 & 2) == 2) {
                    i2 |= 2;
                }
                tVar.Tyk = this.Tyk;
                if ((i3 & 4) == 4) {
                    i2 |= 4;
                }
                tVar.Tzy = this.Tzy;
                if ((i3 & 8) == 8) {
                    i2 |= 8;
                }
                tVar.Tzz = this.Tzz;
                if ((i3 & 16) == 16) {
                    i2 |= 16;
                }
                tVar.TzZ = this.TzZ;
                if ((i3 & 32) == 32) {
                    i2 |= 32;
                }
                tVar.TAa = this.TAa;
                tVar.bOT = i2;
                AppMethodBeat.o(58961);
                return tVar;
            }

            public final C2325a d(t tVar) {
                AppMethodBeat.i(58962);
                if (tVar == t.hHN()) {
                    AppMethodBeat.o(58962);
                } else {
                    if (tVar.hEP()) {
                        auZ(tVar.Txb);
                    }
                    if (tVar.Az()) {
                        ava(tVar.Tyk);
                    }
                    if (tVar.Cm()) {
                        p(tVar.Tzy);
                    }
                    if (tVar.hHi()) {
                        avb(tVar.Tzz);
                    }
                    if (tVar.hHO()) {
                        q(tVar.TzZ);
                    }
                    if (tVar.hHP()) {
                        avc(tVar.TAa);
                    }
                    a((i.c) tVar);
                    this.TwK = this.TwK.a(tVar.TwK);
                    AppMethodBeat.o(58962);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private kotlin.l.b.a.b.e.a.t.C2325a y(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                /*
                    r4 = this;
                    r3 = 58964(0xe654, float:8.2626E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    r2 = 0
                    kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.a$t> r0 = kotlin.l.b.a.b.e.a.t.TwL     // Catch:{ k -> 0x0016 }
                    java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                    kotlin.l.b.a.b.e.a$t r0 = (kotlin.l.b.a.b.e.a.t) r0     // Catch:{ k -> 0x0016 }
                    r4.d(r0)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return r4
                L_0x0016:
                    r0 = move-exception
                    r1 = r0
                    kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                    kotlin.l.b.a.b.e.a$t r0 = (kotlin.l.b.a.b.e.a.t) r0     // Catch:{ all -> 0x002e }
                    r2 = 58964(0xe654, float:8.2626E-41)
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.t.C2325a.y(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.a$t$a");
            }

            private C2325a auZ(int i2) {
                this.bOT |= 1;
                this.Txb = i2;
                return this;
            }

            private C2325a ava(int i2) {
                this.bOT |= 2;
                this.Tyk = i2;
                return this;
            }

            private C2325a p(p pVar) {
                AppMethodBeat.i(58965);
                if ((this.bOT & 4) != 4 || this.Tzy == p.hGS()) {
                    this.Tzy = pVar;
                } else {
                    this.Tzy = p.f(this.Tzy).j(pVar).hHo();
                }
                this.bOT |= 4;
                AppMethodBeat.o(58965);
                return this;
            }

            private C2325a avb(int i2) {
                this.bOT |= 8;
                this.Tzz = i2;
                return this;
            }

            private C2325a q(p pVar) {
                AppMethodBeat.i(58966);
                if ((this.bOT & 16) != 16 || this.TzZ == p.hGS()) {
                    this.TzZ = pVar;
                } else {
                    this.TzZ = p.f(this.TzZ).j(pVar).hHo();
                }
                this.bOT |= 16;
                AppMethodBeat.o(58966);
                return this;
            }

            private C2325a avc(int i2) {
                this.bOT |= 32;
                this.TAa = i2;
                return this;
            }

            private C2325a hHQ() {
                AppMethodBeat.i(58960);
                C2325a d2 = new C2325a().d(hHR());
                AppMethodBeat.o(58960);
                return d2;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                boolean z;
                boolean z2;
                boolean z3;
                AppMethodBeat.i(58963);
                if ((this.bOT & 2) == 2) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    AppMethodBeat.o(58963);
                    return false;
                }
                if ((this.bOT & 4) == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2 || this.Tzy.isInitialized()) {
                    if ((this.bOT & 16) == 16) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3 && !this.TzZ.isInitialized()) {
                        AppMethodBeat.o(58963);
                        return false;
                    } else if (!this.TDA.isInitialized()) {
                        AppMethodBeat.o(58963);
                        return false;
                    } else {
                        AppMethodBeat.o(58963);
                        return true;
                    }
                } else {
                    AppMethodBeat.o(58963);
                    return false;
                }
            }

            @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                AppMethodBeat.i(58968);
                t hHN = t.hHN();
                AppMethodBeat.o(58968);
                return hHN;
            }

            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ kotlin.l.b.a.b.h.i hED() {
                AppMethodBeat.i(58969);
                t hHN = t.hHN();
                AppMethodBeat.o(58969);
                return hHN;
            }

            @Override // kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEG() {
                AppMethodBeat.i(58975);
                t hHR = hHR();
                if (!hHR.isInitialized()) {
                    kotlin.l.b.a.b.h.w wVar = new kotlin.l.b.a.b.h.w();
                    AppMethodBeat.o(58975);
                    throw wVar;
                }
                AppMethodBeat.o(58975);
                return hHR;
            }

            static /* synthetic */ C2325a hHS() {
                AppMethodBeat.i(58977);
                C2325a aVar = new C2325a();
                AppMethodBeat.o(58977);
                return aVar;
            }
        }

        public static C2325a b(t tVar) {
            AppMethodBeat.i(58983);
            C2325a d2 = C2325a.hHS().d(tVar);
            AppMethodBeat.o(58983);
            return d2;
        }

        @Override // kotlin.l.b.a.b.h.r
        public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
            return TzY;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEw() {
            AppMethodBeat.i(58984);
            C2325a d2 = C2325a.hHS().d(this);
            AppMethodBeat.o(58984);
            return d2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEx() {
            AppMethodBeat.i(58985);
            C2325a hHS = C2325a.hHS();
            AppMethodBeat.o(58985);
            return hHS;
        }
    }

    public static final class q extends i.c<q> implements s {
        public static kotlin.l.b.a.b.h.s<q> TwL = new kotlin.l.b.a.b.h.b<q>() {
            /* class kotlin.l.b.a.b.e.a.q.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.h.s
            public final /* synthetic */ Object a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58866);
                q qVar = new q(eVar, gVar, (byte) 0);
                AppMethodBeat.o(58866);
                return qVar;
            }
        };
        private static final q TzF;
        private final kotlin.l.b.a.b.h.d TwK;
        public List<Integer> TxI;
        public int Txb;
        public List<r> Txu;
        public int Tyk;
        public p TzG;
        public int TzH;
        public p TzI;
        public int TzJ;
        public List<C2299a> TzK;
        private int bOT;
        private byte bPe;
        private int bVY;

        /* synthetic */ q(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar, byte b2) {
            this(eVar, gVar);
        }

        /* synthetic */ q(i.b bVar, byte b2) {
            this(bVar);
        }

        private q(i.b<q, ?> bVar) {
            super(bVar);
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = bVar.TwK;
        }

        private q() {
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = kotlin.l.b.a.b.h.d.TDp;
        }

        public static q hHq() {
            return TzF;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v50, resolved type: java.util.List<kotlin.l.b.a.b.e.a$a> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v79, resolved type: java.util.List<kotlin.l.b.a.b.e.a$r> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0055  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0061  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x006d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private q(kotlin.l.b.a.b.h.e r13, kotlin.l.b.a.b.h.g r14) {
            /*
            // Method dump skipped, instructions count: 592
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.q.<init>(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):void");
        }

        static {
            AppMethodBeat.i(58897);
            q qVar = new q();
            TzF = qVar;
            qVar.hEu();
            AppMethodBeat.o(58897);
        }

        @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
        public final kotlin.l.b.a.b.h.s<q> hEs() {
            return TwL;
        }

        public final boolean hEP() {
            return (this.bOT & 1) == 1;
        }

        public final boolean Az() {
            return (this.bOT & 2) == 2;
        }

        public final boolean hHr() {
            return (this.bOT & 4) == 4;
        }

        public final boolean hHs() {
            return (this.bOT & 8) == 8;
        }

        public final boolean hHt() {
            return (this.bOT & 16) == 16;
        }

        public final boolean hHu() {
            return (this.bOT & 32) == 32;
        }

        private void hEu() {
            AppMethodBeat.i(58890);
            this.Txb = 6;
            this.Tyk = 0;
            this.Txu = Collections.emptyList();
            this.TzG = p.hGS();
            this.TzH = 0;
            this.TzI = p.hGS();
            this.TzJ = 0;
            this.TzK = Collections.emptyList();
            this.TxI = Collections.emptyList();
            AppMethodBeat.o(58890);
        }

        @Override // kotlin.l.b.a.b.h.r
        public final boolean isInitialized() {
            AppMethodBeat.i(58891);
            byte b2 = this.bPe;
            if (b2 == 1) {
                AppMethodBeat.o(58891);
                return true;
            } else if (b2 == 0) {
                AppMethodBeat.o(58891);
                return false;
            } else if (!Az()) {
                this.bPe = 0;
                AppMethodBeat.o(58891);
                return false;
            } else {
                for (int i2 = 0; i2 < this.Txu.size(); i2++) {
                    if (!this.Txu.get(i2).isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58891);
                        return false;
                    }
                }
                if (hHr() && !this.TzG.isInitialized()) {
                    this.bPe = 0;
                    AppMethodBeat.o(58891);
                    return false;
                } else if (!hHt() || this.TzI.isInitialized()) {
                    for (int i3 = 0; i3 < this.TzK.size(); i3++) {
                        if (!this.TzK.get(i3).isInitialized()) {
                            this.bPe = 0;
                            AppMethodBeat.o(58891);
                            return false;
                        }
                    }
                    if (!this.TDA.isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58891);
                        return false;
                    }
                    this.bPe = 1;
                    AppMethodBeat.o(58891);
                    return true;
                } else {
                    this.bPe = 0;
                    AppMethodBeat.o(58891);
                    return false;
                }
            }
        }

        @Override // kotlin.l.b.a.b.h.q
        public final void a(kotlin.l.b.a.b.h.f fVar) {
            AppMethodBeat.i(58892);
            yC();
            i.c<MessageType>.a hJC = hJC();
            if ((this.bOT & 1) == 1) {
                fVar.bs(1, this.Txb);
            }
            if ((this.bOT & 2) == 2) {
                fVar.bs(2, this.Tyk);
            }
            for (int i2 = 0; i2 < this.Txu.size(); i2++) {
                fVar.a(3, this.Txu.get(i2));
            }
            if ((this.bOT & 4) == 4) {
                fVar.a(4, this.TzG);
            }
            if ((this.bOT & 8) == 8) {
                fVar.bs(5, this.TzH);
            }
            if ((this.bOT & 16) == 16) {
                fVar.a(6, this.TzI);
            }
            if ((this.bOT & 32) == 32) {
                fVar.bs(7, this.TzJ);
            }
            for (int i3 = 0; i3 < this.TzK.size(); i3++) {
                fVar.a(8, this.TzK.get(i3));
            }
            for (int i4 = 0; i4 < this.TxI.size(); i4++) {
                fVar.bs(31, this.TxI.get(i4).intValue());
            }
            hJC.b(200, fVar);
            fVar.e(this.TwK);
            AppMethodBeat.o(58892);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final int yC() {
            AppMethodBeat.i(58893);
            int i2 = this.bVY;
            if (i2 != -1) {
                AppMethodBeat.o(58893);
                return i2;
            }
            int bu = (this.bOT & 1) == 1 ? kotlin.l.b.a.b.h.f.bu(1, this.Txb) + 0 : 0;
            if ((this.bOT & 2) == 2) {
                bu += kotlin.l.b.a.b.h.f.bu(2, this.Tyk);
            }
            int i3 = bu;
            for (int i4 = 0; i4 < this.Txu.size(); i4++) {
                i3 += kotlin.l.b.a.b.h.f.c(3, this.Txu.get(i4));
            }
            if ((this.bOT & 4) == 4) {
                i3 += kotlin.l.b.a.b.h.f.c(4, this.TzG);
            }
            if ((this.bOT & 8) == 8) {
                i3 += kotlin.l.b.a.b.h.f.bu(5, this.TzH);
            }
            if ((this.bOT & 16) == 16) {
                i3 += kotlin.l.b.a.b.h.f.c(6, this.TzI);
            }
            if ((this.bOT & 32) == 32) {
                i3 += kotlin.l.b.a.b.h.f.bu(7, this.TzJ);
            }
            for (int i5 = 0; i5 < this.TzK.size(); i5++) {
                i3 += kotlin.l.b.a.b.h.f.c(8, this.TzK.get(i5));
            }
            int i6 = 0;
            int i7 = 0;
            while (i6 < this.TxI.size()) {
                i6++;
                i7 = kotlin.l.b.a.b.h.f.fT(this.TxI.get(i6).intValue()) + i7;
            }
            int size = i3 + i7 + (this.TxI.size() * 2) + this.TDA.yC() + this.TwK.size();
            this.bVY = size;
            AppMethodBeat.o(58893);
            return size;
        }

        public static q e(InputStream inputStream, kotlin.l.b.a.b.h.g gVar) {
            AppMethodBeat.i(58894);
            q i2 = TwL.i(inputStream, gVar);
            AppMethodBeat.o(58894);
            return i2;
        }

        /* renamed from: kotlin.l.b.a.b.e.a$q$a  reason: collision with other inner class name */
        public static final class C2322a extends i.b<q, C2322a> implements s {
            private List<Integer> TxI = Collections.emptyList();
            private int Txb = 6;
            private List<r> Txu = Collections.emptyList();
            private int Tyk;
            private p TzG = p.hGS();
            private int TzH;
            private p TzI = p.hGS();
            private int TzJ;
            private List<C2299a> TzK = Collections.emptyList();
            private int bOT;

            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ i.a a(kotlin.l.b.a.b.h.i iVar) {
                AppMethodBeat.i(58881);
                C2322a e2 = e((q) iVar);
                AppMethodBeat.o(58881);
                return e2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
            public final /* synthetic */ a.AbstractC2337a c(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58883);
                C2322a v = v(eVar, gVar);
                AppMethodBeat.o(58883);
                return v;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a, java.lang.Object
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(58887);
                C2322a hHv = hHv();
                AppMethodBeat.o(58887);
                return hHv;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q.a d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58885);
                C2322a v = v(eVar, gVar);
                AppMethodBeat.o(58885);
                return v;
            }

            @Override // kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ i.a hEE() {
                AppMethodBeat.i(58882);
                C2322a hHv = hHv();
                AppMethodBeat.o(58882);
                return hHv;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ a.AbstractC2337a hEF() {
                AppMethodBeat.i(58884);
                C2322a hHv = hHv();
                AppMethodBeat.o(58884);
                return hHv;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$b' to match base method */
            @Override // kotlin.l.b.a.b.h.i.b
            public final /* synthetic */ C2322a hFq() {
                AppMethodBeat.i(58878);
                C2322a hHv = hHv();
                AppMethodBeat.o(58878);
                return hHv;
            }

            private C2322a() {
                AppMethodBeat.i(58867);
                AppMethodBeat.o(58867);
            }

            private q hHw() {
                int i2 = 1;
                AppMethodBeat.i(58869);
                q qVar = new q(this, (byte) 0);
                int i3 = this.bOT;
                if ((i3 & 1) != 1) {
                    i2 = 0;
                }
                qVar.Txb = this.Txb;
                if ((i3 & 2) == 2) {
                    i2 |= 2;
                }
                qVar.Tyk = this.Tyk;
                if ((this.bOT & 4) == 4) {
                    this.Txu = Collections.unmodifiableList(this.Txu);
                    this.bOT &= -5;
                }
                qVar.Txu = this.Txu;
                if ((i3 & 8) == 8) {
                    i2 |= 4;
                }
                qVar.TzG = this.TzG;
                if ((i3 & 16) == 16) {
                    i2 |= 8;
                }
                qVar.TzH = this.TzH;
                if ((i3 & 32) == 32) {
                    i2 |= 16;
                }
                qVar.TzI = this.TzI;
                if ((i3 & 64) == 64) {
                    i2 |= 32;
                }
                qVar.TzJ = this.TzJ;
                if ((this.bOT & 128) == 128) {
                    this.TzK = Collections.unmodifiableList(this.TzK);
                    this.bOT &= -129;
                }
                qVar.TzK = this.TzK;
                if ((this.bOT & 256) == 256) {
                    this.TxI = Collections.unmodifiableList(this.TxI);
                    this.bOT &= -257;
                }
                qVar.TxI = this.TxI;
                qVar.bOT = i2;
                AppMethodBeat.o(58869);
                return qVar;
            }

            public final C2322a e(q qVar) {
                AppMethodBeat.i(58870);
                if (qVar == q.hHq()) {
                    AppMethodBeat.o(58870);
                } else {
                    if (qVar.hEP()) {
                        auR(qVar.Txb);
                    }
                    if (qVar.Az()) {
                        auS(qVar.Tyk);
                    }
                    if (!qVar.Txu.isEmpty()) {
                        if (this.Txu.isEmpty()) {
                            this.Txu = qVar.Txu;
                            this.bOT &= -5;
                        } else {
                            hFf();
                            this.Txu.addAll(qVar.Txu);
                        }
                    }
                    if (qVar.hHr()) {
                        n(qVar.TzG);
                    }
                    if (qVar.hHs()) {
                        auT(qVar.TzH);
                    }
                    if (qVar.hHt()) {
                        o(qVar.TzI);
                    }
                    if (qVar.hHu()) {
                        auU(qVar.TzJ);
                    }
                    if (!qVar.TzK.isEmpty()) {
                        if (this.TzK.isEmpty()) {
                            this.TzK = qVar.TzK;
                            this.bOT &= -129;
                        } else {
                            hHx();
                            this.TzK.addAll(qVar.TzK);
                        }
                    }
                    if (!qVar.TxI.isEmpty()) {
                        if (this.TxI.isEmpty()) {
                            this.TxI = qVar.TxI;
                            this.bOT &= -257;
                        } else {
                            hFp();
                            this.TxI.addAll(qVar.TxI);
                        }
                    }
                    a((i.c) qVar);
                    this.TwK = this.TwK.a(qVar.TwK);
                    AppMethodBeat.o(58870);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private kotlin.l.b.a.b.e.a.q.C2322a v(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                /*
                    r4 = this;
                    r3 = 58872(0xe5f8, float:8.2497E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    r2 = 0
                    kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.a$q> r0 = kotlin.l.b.a.b.e.a.q.TwL     // Catch:{ k -> 0x0016 }
                    java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                    kotlin.l.b.a.b.e.a$q r0 = (kotlin.l.b.a.b.e.a.q) r0     // Catch:{ k -> 0x0016 }
                    r4.e(r0)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return r4
                L_0x0016:
                    r0 = move-exception
                    r1 = r0
                    kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                    kotlin.l.b.a.b.e.a$q r0 = (kotlin.l.b.a.b.e.a.q) r0     // Catch:{ all -> 0x002e }
                    r2 = 58872(0xe5f8, float:8.2497E-41)
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.q.C2322a.v(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.a$q$a");
            }

            private C2322a auR(int i2) {
                this.bOT |= 1;
                this.Txb = i2;
                return this;
            }

            private C2322a auS(int i2) {
                this.bOT |= 2;
                this.Tyk = i2;
                return this;
            }

            private void hFf() {
                AppMethodBeat.i(58873);
                if ((this.bOT & 4) != 4) {
                    this.Txu = new ArrayList(this.Txu);
                    this.bOT |= 4;
                }
                AppMethodBeat.o(58873);
            }

            private C2322a n(p pVar) {
                AppMethodBeat.i(58874);
                if ((this.bOT & 8) != 8 || this.TzG == p.hGS()) {
                    this.TzG = pVar;
                } else {
                    this.TzG = p.f(this.TzG).j(pVar).hHo();
                }
                this.bOT |= 8;
                AppMethodBeat.o(58874);
                return this;
            }

            private C2322a auT(int i2) {
                this.bOT |= 16;
                this.TzH = i2;
                return this;
            }

            private C2322a o(p pVar) {
                AppMethodBeat.i(58875);
                if ((this.bOT & 32) != 32 || this.TzI == p.hGS()) {
                    this.TzI = pVar;
                } else {
                    this.TzI = p.f(this.TzI).j(pVar).hHo();
                }
                this.bOT |= 32;
                AppMethodBeat.o(58875);
                return this;
            }

            private C2322a auU(int i2) {
                this.bOT |= 64;
                this.TzJ = i2;
                return this;
            }

            private void hHx() {
                AppMethodBeat.i(58876);
                if ((this.bOT & 128) != 128) {
                    this.TzK = new ArrayList(this.TzK);
                    this.bOT |= 128;
                }
                AppMethodBeat.o(58876);
            }

            private void hFp() {
                AppMethodBeat.i(58877);
                if ((this.bOT & 256) != 256) {
                    this.TxI = new ArrayList(this.TxI);
                    this.bOT |= 256;
                }
                AppMethodBeat.o(58877);
            }

            private C2322a hHv() {
                AppMethodBeat.i(58868);
                C2322a e2 = new C2322a().e(hHw());
                AppMethodBeat.o(58868);
                return e2;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                AppMethodBeat.i(58871);
                if (!((this.bOT & 2) == 2)) {
                    AppMethodBeat.o(58871);
                    return false;
                }
                for (int i2 = 0; i2 < this.Txu.size(); i2++) {
                    if (!this.Txu.get(i2).isInitialized()) {
                        AppMethodBeat.o(58871);
                        return false;
                    }
                }
                if (!((this.bOT & 8) == 8) || this.TzG.isInitialized()) {
                    if (!((this.bOT & 32) == 32) || this.TzI.isInitialized()) {
                        for (int i3 = 0; i3 < this.TzK.size(); i3++) {
                            if (!this.TzK.get(i3).isInitialized()) {
                                AppMethodBeat.o(58871);
                                return false;
                            }
                        }
                        if (!this.TDA.isInitialized()) {
                            AppMethodBeat.o(58871);
                            return false;
                        }
                        AppMethodBeat.o(58871);
                        return true;
                    }
                    AppMethodBeat.o(58871);
                    return false;
                }
                AppMethodBeat.o(58871);
                return false;
            }

            @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                AppMethodBeat.i(58879);
                q hHq = q.hHq();
                AppMethodBeat.o(58879);
                return hHq;
            }

            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ kotlin.l.b.a.b.h.i hED() {
                AppMethodBeat.i(58880);
                q hHq = q.hHq();
                AppMethodBeat.o(58880);
                return hHq;
            }

            @Override // kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEG() {
                AppMethodBeat.i(58886);
                q hHw = hHw();
                if (!hHw.isInitialized()) {
                    kotlin.l.b.a.b.h.w wVar = new kotlin.l.b.a.b.h.w();
                    AppMethodBeat.o(58886);
                    throw wVar;
                }
                AppMethodBeat.o(58886);
                return hHw;
            }

            static /* synthetic */ C2322a hHy() {
                AppMethodBeat.i(58888);
                C2322a aVar = new C2322a();
                AppMethodBeat.o(58888);
                return aVar;
            }
        }

        @Override // kotlin.l.b.a.b.h.r
        public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
            return TzF;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEw() {
            AppMethodBeat.i(58895);
            C2322a e2 = C2322a.hHy().e(this);
            AppMethodBeat.o(58895);
            return e2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEx() {
            AppMethodBeat.i(58896);
            C2322a hHy = C2322a.hHy();
            AppMethodBeat.o(58896);
            return hHy;
        }
    }

    public static final class f extends i.c<f> implements i {
        public static kotlin.l.b.a.b.h.s<f> TwL = new kotlin.l.b.a.b.h.b<f>() {
            /* class kotlin.l.b.a.b.e.a.f.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.h.s
            public final /* synthetic */ Object a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58527);
                f fVar = new f(eVar, gVar, (byte) 0);
                AppMethodBeat.o(58527);
                return fVar;
            }
        };
        private static final f Tyj;
        private final kotlin.l.b.a.b.h.d TwK;
        public int Tyk;
        private int bOT;
        private byte bPe;
        private int bVY;

        /* synthetic */ f(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar, byte b2) {
            this(eVar, gVar);
        }

        /* synthetic */ f(i.b bVar, byte b2) {
            this(bVar);
        }

        private f(i.b<f, ?> bVar) {
            super(bVar);
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = bVar.TwK;
        }

        private f() {
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = kotlin.l.b.a.b.h.d.TDp;
        }

        public static f hFL() {
            return Tyj;
        }

        private f(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
            boolean z = false;
            AppMethodBeat.i(58544);
            this.bPe = -1;
            this.bVY = -1;
            this.Tyk = 0;
            d.b hJo = kotlin.l.b.a.b.h.d.hJo();
            kotlin.l.b.a.b.h.f f2 = kotlin.l.b.a.b.h.f.f(hJo, 1);
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
                        default:
                            if (a(eVar, f2, gVar, yT)) {
                                break;
                            } else {
                                z = true;
                                break;
                            }
                    }
                } catch (kotlin.l.b.a.b.h.k e2) {
                    e2.TDK = this;
                    AppMethodBeat.o(58544);
                    throw e2;
                } catch (IOException e3) {
                    kotlin.l.b.a.b.h.k kVar = new kotlin.l.b.a.b.h.k(e3.getMessage());
                    kVar.TDK = this;
                    AppMethodBeat.o(58544);
                    throw kVar;
                } catch (Throwable th) {
                    try {
                        f2.flush();
                        this.TwK = hJo.hJs();
                    } catch (IOException e4) {
                        this.TwK = hJo.hJs();
                    } catch (Throwable th2) {
                        this.TwK = hJo.hJs();
                        AppMethodBeat.o(58544);
                        throw th2;
                    }
                    this.TDA.yK();
                    AppMethodBeat.o(58544);
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
                AppMethodBeat.o(58544);
                throw th3;
            }
            this.TDA.yK();
            AppMethodBeat.o(58544);
        }

        static {
            AppMethodBeat.i(58550);
            f fVar = new f();
            Tyj = fVar;
            fVar.Tyk = 0;
            AppMethodBeat.o(58550);
        }

        @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
        public final kotlin.l.b.a.b.h.s<f> hEs() {
            return TwL;
        }

        public final boolean Az() {
            return (this.bOT & 1) == 1;
        }

        @Override // kotlin.l.b.a.b.h.r
        public final boolean isInitialized() {
            AppMethodBeat.i(58545);
            byte b2 = this.bPe;
            if (b2 == 1) {
                AppMethodBeat.o(58545);
                return true;
            } else if (b2 == 0) {
                AppMethodBeat.o(58545);
                return false;
            } else if (!this.TDA.isInitialized()) {
                this.bPe = 0;
                AppMethodBeat.o(58545);
                return false;
            } else {
                this.bPe = 1;
                AppMethodBeat.o(58545);
                return true;
            }
        }

        @Override // kotlin.l.b.a.b.h.q
        public final void a(kotlin.l.b.a.b.h.f fVar) {
            AppMethodBeat.i(58546);
            yC();
            i.c<MessageType>.a hJC = hJC();
            if ((this.bOT & 1) == 1) {
                fVar.bs(1, this.Tyk);
            }
            hJC.b(200, fVar);
            fVar.e(this.TwK);
            AppMethodBeat.o(58546);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final int yC() {
            AppMethodBeat.i(58547);
            int i2 = this.bVY;
            if (i2 != -1) {
                AppMethodBeat.o(58547);
                return i2;
            }
            int i3 = 0;
            if ((this.bOT & 1) == 1) {
                i3 = kotlin.l.b.a.b.h.f.bu(1, this.Tyk) + 0;
            }
            int yC = i3 + this.TDA.yC() + this.TwK.size();
            this.bVY = yC;
            AppMethodBeat.o(58547);
            return yC;
        }

        /* renamed from: kotlin.l.b.a.b.e.a$f$a  reason: collision with other inner class name */
        public static final class C2310a extends i.b<f, C2310a> implements i {
            private int Tyk;
            private int bOT;

            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ i.a a(kotlin.l.b.a.b.h.i iVar) {
                AppMethodBeat.i(58536);
                C2310a b2 = b((f) iVar);
                AppMethodBeat.o(58536);
                return b2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
            public final /* synthetic */ a.AbstractC2337a c(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58538);
                C2310a k = k(eVar, gVar);
                AppMethodBeat.o(58538);
                return k;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a, java.lang.Object
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(58542);
                C2310a hFM = hFM();
                AppMethodBeat.o(58542);
                return hFM;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q.a d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58540);
                C2310a k = k(eVar, gVar);
                AppMethodBeat.o(58540);
                return k;
            }

            @Override // kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ i.a hEE() {
                AppMethodBeat.i(58537);
                C2310a hFM = hFM();
                AppMethodBeat.o(58537);
                return hFM;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ a.AbstractC2337a hEF() {
                AppMethodBeat.i(58539);
                C2310a hFM = hFM();
                AppMethodBeat.o(58539);
                return hFM;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$b' to match base method */
            @Override // kotlin.l.b.a.b.h.i.b
            public final /* synthetic */ C2310a hFq() {
                AppMethodBeat.i(58533);
                C2310a hFM = hFM();
                AppMethodBeat.o(58533);
                return hFM;
            }

            private C2310a() {
            }

            private f hFN() {
                int i2 = 1;
                AppMethodBeat.i(58529);
                f fVar = new f(this, (byte) 0);
                if ((this.bOT & 1) != 1) {
                    i2 = 0;
                }
                fVar.Tyk = this.Tyk;
                fVar.bOT = i2;
                AppMethodBeat.o(58529);
                return fVar;
            }

            public final C2310a b(f fVar) {
                AppMethodBeat.i(58530);
                if (fVar == f.hFL()) {
                    AppMethodBeat.o(58530);
                } else {
                    if (fVar.Az()) {
                        auj(fVar.Tyk);
                    }
                    a((i.c) fVar);
                    this.TwK = this.TwK.a(fVar.TwK);
                    AppMethodBeat.o(58530);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private kotlin.l.b.a.b.e.a.f.C2310a k(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                /*
                    r4 = this;
                    r3 = 58532(0xe4a4, float:8.2021E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    r2 = 0
                    kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.a$f> r0 = kotlin.l.b.a.b.e.a.f.TwL     // Catch:{ k -> 0x0016 }
                    java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                    kotlin.l.b.a.b.e.a$f r0 = (kotlin.l.b.a.b.e.a.f) r0     // Catch:{ k -> 0x0016 }
                    r4.b(r0)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return r4
                L_0x0016:
                    r0 = move-exception
                    r1 = r0
                    kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                    kotlin.l.b.a.b.e.a$f r0 = (kotlin.l.b.a.b.e.a.f) r0     // Catch:{ all -> 0x002e }
                    r2 = 58532(0xe4a4, float:8.2021E-41)
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.f.C2310a.k(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.a$f$a");
            }

            private C2310a auj(int i2) {
                this.bOT |= 1;
                this.Tyk = i2;
                return this;
            }

            private C2310a hFM() {
                AppMethodBeat.i(58528);
                C2310a b2 = new C2310a().b(hFN());
                AppMethodBeat.o(58528);
                return b2;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                AppMethodBeat.i(58531);
                if (!this.TDA.isInitialized()) {
                    AppMethodBeat.o(58531);
                    return false;
                }
                AppMethodBeat.o(58531);
                return true;
            }

            @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                AppMethodBeat.i(58534);
                f hFL = f.hFL();
                AppMethodBeat.o(58534);
                return hFL;
            }

            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ kotlin.l.b.a.b.h.i hED() {
                AppMethodBeat.i(58535);
                f hFL = f.hFL();
                AppMethodBeat.o(58535);
                return hFL;
            }

            @Override // kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEG() {
                AppMethodBeat.i(58541);
                f hFN = hFN();
                if (!hFN.isInitialized()) {
                    kotlin.l.b.a.b.h.w wVar = new kotlin.l.b.a.b.h.w();
                    AppMethodBeat.o(58541);
                    throw wVar;
                }
                AppMethodBeat.o(58541);
                return hFN;
            }

            static /* synthetic */ C2310a hFO() {
                AppMethodBeat.i(58543);
                C2310a aVar = new C2310a();
                AppMethodBeat.o(58543);
                return aVar;
            }
        }

        @Override // kotlin.l.b.a.b.h.r
        public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
            return Tyj;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEw() {
            AppMethodBeat.i(58548);
            C2310a b2 = C2310a.hFO().b(this);
            AppMethodBeat.o(58548);
            return b2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEx() {
            AppMethodBeat.i(58549);
            C2310a hFO = C2310a.hFO();
            AppMethodBeat.o(58549);
            return hFO;
        }
    }

    public static final class u extends kotlin.l.b.a.b.h.i implements x {
        private static final u TAb;
        public static kotlin.l.b.a.b.h.s<u> TwL = new kotlin.l.b.a.b.h.b<u>() {
            /* class kotlin.l.b.a.b.e.a.u.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.h.s
            public final /* synthetic */ Object a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58987);
                u uVar = new u(eVar, gVar, (byte) 0);
                AppMethodBeat.o(58987);
                return uVar;
            }
        };
        public int TAc;
        public int TAd;
        public b TAe;
        public int TAf;
        public int TAg;
        public c TAh;
        private final kotlin.l.b.a.b.h.d TwK;
        private int bOT;
        private byte bPe;
        private int bVY;

        /* synthetic */ u(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar, byte b2) {
            this(eVar, gVar);
        }

        /* synthetic */ u(i.a aVar, byte b2) {
            this(aVar);
        }

        private u(i.a aVar) {
            super((byte) 0);
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = aVar.TwK;
        }

        private u() {
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = kotlin.l.b.a.b.h.d.TDp;
        }

        public static u hHT() {
            return TAb;
        }

        private u(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
            AppMethodBeat.i(59012);
            this.bPe = -1;
            this.bVY = -1;
            hEu();
            d.b hJo = kotlin.l.b.a.b.h.d.hJo();
            kotlin.l.b.a.b.h.f f2 = kotlin.l.b.a.b.h.f.f(hJo, 1);
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
                            this.TAc = eVar.zi();
                            break;
                        case 16:
                            this.bOT |= 2;
                            this.TAd = eVar.zi();
                            break;
                        case 24:
                            int zi = eVar.zi();
                            b avh = b.avh(zi);
                            if (avh != null) {
                                this.bOT |= 4;
                                this.TAe = avh;
                                break;
                            } else {
                                f2.hc(yT);
                                f2.hc(zi);
                                break;
                            }
                        case 32:
                            this.bOT |= 8;
                            this.TAf = eVar.zi();
                            break;
                        case 40:
                            this.bOT |= 16;
                            this.TAg = eVar.zi();
                            break;
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                            int zi2 = eVar.zi();
                            c avi = c.avi(zi2);
                            if (avi != null) {
                                this.bOT |= 32;
                                this.TAh = avi;
                                break;
                            } else {
                                f2.hc(yT);
                                f2.hc(zi2);
                                break;
                            }
                        default:
                            if (a(eVar, f2, gVar, yT)) {
                                break;
                            } else {
                                z = true;
                                break;
                            }
                    }
                } catch (kotlin.l.b.a.b.h.k e2) {
                    e2.TDK = this;
                    AppMethodBeat.o(59012);
                    throw e2;
                } catch (IOException e3) {
                    kotlin.l.b.a.b.h.k kVar = new kotlin.l.b.a.b.h.k(e3.getMessage());
                    kVar.TDK = this;
                    AppMethodBeat.o(59012);
                    throw kVar;
                } catch (Throwable th) {
                    try {
                        f2.flush();
                        this.TwK = hJo.hJs();
                    } catch (IOException e4) {
                        this.TwK = hJo.hJs();
                    } catch (Throwable th2) {
                        this.TwK = hJo.hJs();
                        AppMethodBeat.o(59012);
                        throw th2;
                    }
                    Gw();
                    AppMethodBeat.o(59012);
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
                AppMethodBeat.o(59012);
                throw th3;
            }
            Gw();
            AppMethodBeat.o(59012);
        }

        static {
            AppMethodBeat.i(59017);
            u uVar = new u();
            TAb = uVar;
            uVar.hEu();
            AppMethodBeat.o(59017);
        }

        @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
        public final kotlin.l.b.a.b.h.s<u> hEs() {
            return TwL;
        }

        public enum b implements j.a {
            WARNING(0),
            ERROR(1),
            HIDDEN(2);
            
            private static j.b<b> Txp = new j.b<b>() {
                /* class kotlin.l.b.a.b.e.a.u.b.AnonymousClass1 */

                /* Return type fixed from 'kotlin.l.b.a.b.h.j$a' to match base method */
                @Override // kotlin.l.b.a.b.h.j.b
                public final /* synthetic */ b aua(int i2) {
                    AppMethodBeat.i(59004);
                    b avh = b.avh(i2);
                    AppMethodBeat.o(59004);
                    return avh;
                }
            };
            final int value;

            public static b valueOf(String str) {
                AppMethodBeat.i(59006);
                b bVar = (b) Enum.valueOf(b.class, str);
                AppMethodBeat.o(59006);
                return bVar;
            }

            static {
                AppMethodBeat.i(59007);
                AppMethodBeat.o(59007);
            }

            @Override // kotlin.l.b.a.b.h.j.a
            public final int getNumber() {
                return this.value;
            }

            public static b avh(int i2) {
                switch (i2) {
                    case 0:
                        return WARNING;
                    case 1:
                        return ERROR;
                    case 2:
                        return HIDDEN;
                    default:
                        return null;
                }
            }

            private b(int i2) {
                this.value = i2;
            }
        }

        public enum c implements j.a {
            LANGUAGE_VERSION(0),
            COMPILER_VERSION(1),
            API_VERSION(2);
            
            private static j.b<c> Txp = new j.b<c>() {
                /* class kotlin.l.b.a.b.e.a.u.c.AnonymousClass1 */

                /* Return type fixed from 'kotlin.l.b.a.b.h.j$a' to match base method */
                @Override // kotlin.l.b.a.b.h.j.b
                public final /* synthetic */ c aua(int i2) {
                    AppMethodBeat.i(59008);
                    c avi = c.avi(i2);
                    AppMethodBeat.o(59008);
                    return avi;
                }
            };
            final int value;

            public static c valueOf(String str) {
                AppMethodBeat.i(59010);
                c cVar = (c) Enum.valueOf(c.class, str);
                AppMethodBeat.o(59010);
                return cVar;
            }

            static {
                AppMethodBeat.i(59011);
                AppMethodBeat.o(59011);
            }

            @Override // kotlin.l.b.a.b.h.j.a
            public final int getNumber() {
                return this.value;
            }

            public static c avi(int i2) {
                switch (i2) {
                    case 0:
                        return LANGUAGE_VERSION;
                    case 1:
                        return COMPILER_VERSION;
                    case 2:
                        return API_VERSION;
                    default:
                        return null;
                }
            }

            private c(int i2) {
                this.value = i2;
            }
        }

        public final boolean hHU() {
            return (this.bOT & 1) == 1;
        }

        public final boolean hHV() {
            return (this.bOT & 2) == 2;
        }

        public final boolean hHW() {
            return (this.bOT & 4) == 4;
        }

        public final boolean hHX() {
            return (this.bOT & 8) == 8;
        }

        public final boolean hHY() {
            return (this.bOT & 16) == 16;
        }

        public final boolean hHZ() {
            return (this.bOT & 32) == 32;
        }

        private void hEu() {
            this.TAc = 0;
            this.TAd = 0;
            this.TAe = b.ERROR;
            this.TAf = 0;
            this.TAg = 0;
            this.TAh = c.LANGUAGE_VERSION;
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
        public final void a(kotlin.l.b.a.b.h.f fVar) {
            AppMethodBeat.i(59013);
            yC();
            if ((this.bOT & 1) == 1) {
                fVar.bs(1, this.TAc);
            }
            if ((this.bOT & 2) == 2) {
                fVar.bs(2, this.TAd);
            }
            if ((this.bOT & 4) == 4) {
                fVar.nb(3, this.TAe.value);
            }
            if ((this.bOT & 8) == 8) {
                fVar.bs(4, this.TAf);
            }
            if ((this.bOT & 16) == 16) {
                fVar.bs(5, this.TAg);
            }
            if ((this.bOT & 32) == 32) {
                fVar.nb(6, this.TAh.value);
            }
            fVar.e(this.TwK);
            AppMethodBeat.o(59013);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final int yC() {
            AppMethodBeat.i(59014);
            int i2 = this.bVY;
            if (i2 != -1) {
                AppMethodBeat.o(59014);
                return i2;
            }
            int i3 = 0;
            if ((this.bOT & 1) == 1) {
                i3 = kotlin.l.b.a.b.h.f.bu(1, this.TAc) + 0;
            }
            if ((this.bOT & 2) == 2) {
                i3 += kotlin.l.b.a.b.h.f.bu(2, this.TAd);
            }
            if ((this.bOT & 4) == 4) {
                i3 += kotlin.l.b.a.b.h.f.bv(3, this.TAe.value);
            }
            if ((this.bOT & 8) == 8) {
                i3 += kotlin.l.b.a.b.h.f.bu(4, this.TAf);
            }
            if ((this.bOT & 16) == 16) {
                i3 += kotlin.l.b.a.b.h.f.bu(5, this.TAg);
            }
            if ((this.bOT & 32) == 32) {
                i3 += kotlin.l.b.a.b.h.f.bv(6, this.TAh.value);
            }
            int size = i3 + this.TwK.size();
            this.bVY = size;
            AppMethodBeat.o(59014);
            return size;
        }

        /* renamed from: kotlin.l.b.a.b.e.a$u$a  reason: collision with other inner class name */
        public static final class C2326a extends i.a<u, C2326a> implements x {
            private int TAc;
            private int TAd;
            private b TAe = b.ERROR;
            private int TAf;
            private int TAg;
            private c TAh = c.LANGUAGE_VERSION;
            private int bOT;

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.l.b.a.b.h.i] */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2326a a(u uVar) {
                AppMethodBeat.i(58995);
                C2326a b2 = b(uVar);
                AppMethodBeat.o(58995);
                return b2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
            public final /* synthetic */ a.AbstractC2337a c(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58997);
                C2326a z = z(eVar, gVar);
                AppMethodBeat.o(58997);
                return z;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a, java.lang.Object
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(59002);
                C2326a hIa = hIa();
                AppMethodBeat.o(59002);
                return hIa;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q.a d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58999);
                C2326a z = z(eVar, gVar);
                AppMethodBeat.o(58999);
                return z;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2326a hEE() {
                AppMethodBeat.i(58996);
                C2326a hIa = hIa();
                AppMethodBeat.o(58996);
                return hIa;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ a.AbstractC2337a hEF() {
                AppMethodBeat.i(58998);
                C2326a hIa = hIa();
                AppMethodBeat.o(58998);
                return hIa;
            }

            private C2326a() {
            }

            private u hIb() {
                int i2 = 1;
                AppMethodBeat.i(58989);
                u uVar = new u(this, (byte) 0);
                int i3 = this.bOT;
                if ((i3 & 1) != 1) {
                    i2 = 0;
                }
                uVar.TAc = this.TAc;
                if ((i3 & 2) == 2) {
                    i2 |= 2;
                }
                uVar.TAd = this.TAd;
                if ((i3 & 4) == 4) {
                    i2 |= 4;
                }
                uVar.TAe = this.TAe;
                if ((i3 & 8) == 8) {
                    i2 |= 8;
                }
                uVar.TAf = this.TAf;
                if ((i3 & 16) == 16) {
                    i2 |= 16;
                }
                uVar.TAg = this.TAg;
                if ((i3 & 32) == 32) {
                    i2 |= 32;
                }
                uVar.TAh = this.TAh;
                uVar.bOT = i2;
                AppMethodBeat.o(58989);
                return uVar;
            }

            public final C2326a b(u uVar) {
                AppMethodBeat.i(58990);
                if (uVar == u.hHT()) {
                    AppMethodBeat.o(58990);
                } else {
                    if (uVar.hHU()) {
                        avd(uVar.TAc);
                    }
                    if (uVar.hHV()) {
                        ave(uVar.TAd);
                    }
                    if (uVar.hHW()) {
                        a(uVar.TAe);
                    }
                    if (uVar.hHX()) {
                        avf(uVar.TAf);
                    }
                    if (uVar.hHY()) {
                        avg(uVar.TAg);
                    }
                    if (uVar.hHZ()) {
                        a(uVar.TAh);
                    }
                    this.TwK = this.TwK.a(uVar.TwK);
                    AppMethodBeat.o(58990);
                }
                return this;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private kotlin.l.b.a.b.e.a.u.C2326a z(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                /*
                    r4 = this;
                    r3 = 58991(0xe66f, float:8.2664E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    r2 = 0
                    kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.a$u> r0 = kotlin.l.b.a.b.e.a.u.TwL     // Catch:{ k -> 0x0016 }
                    java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                    kotlin.l.b.a.b.e.a$u r0 = (kotlin.l.b.a.b.e.a.u) r0     // Catch:{ k -> 0x0016 }
                    r4.b(r0)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return r4
                L_0x0016:
                    r0 = move-exception
                    r1 = r0
                    kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                    kotlin.l.b.a.b.e.a$u r0 = (kotlin.l.b.a.b.e.a.u) r0     // Catch:{ all -> 0x002e }
                    r2 = 58991(0xe66f, float:8.2664E-41)
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.u.C2326a.z(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.a$u$a");
            }

            private C2326a avd(int i2) {
                this.bOT |= 1;
                this.TAc = i2;
                return this;
            }

            private C2326a ave(int i2) {
                this.bOT |= 2;
                this.TAd = i2;
                return this;
            }

            private C2326a a(b bVar) {
                AppMethodBeat.i(58992);
                if (bVar == null) {
                    NullPointerException nullPointerException = new NullPointerException();
                    AppMethodBeat.o(58992);
                    throw nullPointerException;
                }
                this.bOT |= 4;
                this.TAe = bVar;
                AppMethodBeat.o(58992);
                return this;
            }

            private C2326a avf(int i2) {
                this.bOT |= 8;
                this.TAf = i2;
                return this;
            }

            private C2326a avg(int i2) {
                this.bOT |= 16;
                this.TAg = i2;
                return this;
            }

            private C2326a a(c cVar) {
                AppMethodBeat.i(58993);
                if (cVar == null) {
                    NullPointerException nullPointerException = new NullPointerException();
                    AppMethodBeat.o(58993);
                    throw nullPointerException;
                }
                this.bOT |= 32;
                this.TAh = cVar;
                AppMethodBeat.o(58993);
                return this;
            }

            private C2326a hIa() {
                AppMethodBeat.i(58988);
                C2326a b2 = new C2326a().b(hIb());
                AppMethodBeat.o(58988);
                return b2;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ u hED() {
                AppMethodBeat.i(58994);
                u hHT = u.hHT();
                AppMethodBeat.o(58994);
                return hHT;
            }

            @Override // kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEG() {
                AppMethodBeat.i(59000);
                u hIb = hIb();
                if (!hIb.isInitialized()) {
                    kotlin.l.b.a.b.h.w wVar = new kotlin.l.b.a.b.h.w();
                    AppMethodBeat.o(59000);
                    throw wVar;
                }
                AppMethodBeat.o(59000);
                return hIb;
            }

            @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                AppMethodBeat.i(59001);
                u hHT = u.hHT();
                AppMethodBeat.o(59001);
                return hHT;
            }

            static /* synthetic */ C2326a hIc() {
                AppMethodBeat.i(59003);
                C2326a aVar = new C2326a();
                AppMethodBeat.o(59003);
                return aVar;
            }
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEw() {
            AppMethodBeat.i(59015);
            C2326a b2 = C2326a.hIc().b(this);
            AppMethodBeat.o(59015);
            return b2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEx() {
            AppMethodBeat.i(59016);
            C2326a hIc = C2326a.hIc();
            AppMethodBeat.o(59016);
            return hIc;
        }

        @Override // kotlin.l.b.a.b.h.r
        public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
            return TAb;
        }
    }

    public static final class v extends kotlin.l.b.a.b.h.i implements y {
        private static final v TAq;
        public static kotlin.l.b.a.b.h.s<v> TwL = new kotlin.l.b.a.b.h.b<v>() {
            /* class kotlin.l.b.a.b.e.a.v.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.h.s
            public final /* synthetic */ Object a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(59018);
                v vVar = new v(eVar, gVar, (byte) 0);
                AppMethodBeat.o(59018);
                return vVar;
            }
        };
        public List<u> TAr;
        private final kotlin.l.b.a.b.h.d TwK;
        private byte bPe;
        private int bVY;

        /* synthetic */ v(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar, byte b2) {
            this(eVar, gVar);
        }

        /* synthetic */ v(i.a aVar, byte b2) {
            this(aVar);
        }

        private v(i.a aVar) {
            super((byte) 0);
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = aVar.TwK;
        }

        private v() {
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = kotlin.l.b.a.b.h.d.TDp;
        }

        public static v hId() {
            return TAq;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: java.util.List<kotlin.l.b.a.b.e.a$u> */
        /* JADX WARN: Multi-variable type inference failed */
        private v(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
            AppMethodBeat.i(59035);
            this.bPe = -1;
            this.bVY = -1;
            this.TAr = Collections.emptyList();
            d.b hJo = kotlin.l.b.a.b.h.d.hJo();
            kotlin.l.b.a.b.h.f f2 = kotlin.l.b.a.b.h.f.f(hJo, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int yT = eVar.yT();
                    switch (yT) {
                        case 0:
                            z = true;
                            break;
                        case 10:
                            if (!z2 || !true) {
                                this.TAr = new ArrayList();
                                z2 |= true;
                            }
                            this.TAr.add(eVar.a(u.TwL, gVar));
                            break;
                        default:
                            if (a(eVar, f2, gVar, yT)) {
                                break;
                            } else {
                                z = true;
                                break;
                            }
                    }
                } catch (kotlin.l.b.a.b.h.k e2) {
                    e2.TDK = this;
                    AppMethodBeat.o(59035);
                    throw e2;
                } catch (IOException e3) {
                    kotlin.l.b.a.b.h.k kVar = new kotlin.l.b.a.b.h.k(e3.getMessage());
                    kVar.TDK = this;
                    AppMethodBeat.o(59035);
                    throw kVar;
                } catch (Throwable th) {
                    if (z2 && true) {
                        this.TAr = Collections.unmodifiableList(this.TAr);
                    }
                    try {
                        f2.flush();
                        this.TwK = hJo.hJs();
                    } catch (IOException e4) {
                        this.TwK = hJo.hJs();
                    } catch (Throwable th2) {
                        this.TwK = hJo.hJs();
                        AppMethodBeat.o(59035);
                        throw th2;
                    }
                    Gw();
                    AppMethodBeat.o(59035);
                    throw th;
                }
            }
            if (z2 && true) {
                this.TAr = Collections.unmodifiableList(this.TAr);
            }
            try {
                f2.flush();
                this.TwK = hJo.hJs();
            } catch (IOException e5) {
                this.TwK = hJo.hJs();
            } catch (Throwable th3) {
                this.TwK = hJo.hJs();
                AppMethodBeat.o(59035);
                throw th3;
            }
            Gw();
            AppMethodBeat.o(59035);
        }

        static {
            AppMethodBeat.i(59041);
            v vVar = new v();
            TAq = vVar;
            vVar.TAr = Collections.emptyList();
            AppMethodBeat.o(59041);
        }

        @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
        public final kotlin.l.b.a.b.h.s<v> hEs() {
            return TwL;
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
        public final void a(kotlin.l.b.a.b.h.f fVar) {
            AppMethodBeat.i(59036);
            yC();
            for (int i2 = 0; i2 < this.TAr.size(); i2++) {
                fVar.a(1, this.TAr.get(i2));
            }
            fVar.e(this.TwK);
            AppMethodBeat.o(59036);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final int yC() {
            AppMethodBeat.i(59037);
            int i2 = this.bVY;
            if (i2 != -1) {
                AppMethodBeat.o(59037);
                return i2;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.TAr.size(); i4++) {
                i3 += kotlin.l.b.a.b.h.f.c(1, this.TAr.get(i4));
            }
            int size = this.TwK.size() + i3;
            this.bVY = size;
            AppMethodBeat.o(59037);
            return size;
        }

        /* renamed from: kotlin.l.b.a.b.e.a$v$a  reason: collision with other inner class name */
        public static final class C2327a extends i.a<v, C2327a> implements y {
            private List<u> TAr = Collections.emptyList();
            private int bOT;

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.l.b.a.b.h.i] */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2327a a(v vVar) {
                AppMethodBeat.i(59026);
                C2327a f2 = f(vVar);
                AppMethodBeat.o(59026);
                return f2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
            public final /* synthetic */ a.AbstractC2337a c(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(59028);
                C2327a A = A(eVar, gVar);
                AppMethodBeat.o(59028);
                return A;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a, java.lang.Object
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(59033);
                C2327a hIe = hIe();
                AppMethodBeat.o(59033);
                return hIe;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q.a d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(59030);
                C2327a A = A(eVar, gVar);
                AppMethodBeat.o(59030);
                return A;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2327a hEE() {
                AppMethodBeat.i(59027);
                C2327a hIe = hIe();
                AppMethodBeat.o(59027);
                return hIe;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ a.AbstractC2337a hEF() {
                AppMethodBeat.i(59029);
                C2327a hIe = hIe();
                AppMethodBeat.o(59029);
                return hIe;
            }

            private C2327a() {
                AppMethodBeat.i(59019);
                AppMethodBeat.o(59019);
            }

            public final v hIf() {
                AppMethodBeat.i(59021);
                v vVar = new v(this, (byte) 0);
                if ((this.bOT & 1) == 1) {
                    this.TAr = Collections.unmodifiableList(this.TAr);
                    this.bOT &= -2;
                }
                vVar.TAr = this.TAr;
                AppMethodBeat.o(59021);
                return vVar;
            }

            public final C2327a f(v vVar) {
                AppMethodBeat.i(59022);
                if (vVar == v.hId()) {
                    AppMethodBeat.o(59022);
                } else {
                    if (!vVar.TAr.isEmpty()) {
                        if (this.TAr.isEmpty()) {
                            this.TAr = vVar.TAr;
                            this.bOT &= -2;
                        } else {
                            hIg();
                            this.TAr.addAll(vVar.TAr);
                        }
                    }
                    this.TwK = this.TwK.a(vVar.TwK);
                    AppMethodBeat.o(59022);
                }
                return this;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                return true;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private kotlin.l.b.a.b.e.a.v.C2327a A(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                /*
                    r4 = this;
                    r3 = 59023(0xe68f, float:8.2709E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    r2 = 0
                    kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.a$v> r0 = kotlin.l.b.a.b.e.a.v.TwL     // Catch:{ k -> 0x0016 }
                    java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                    kotlin.l.b.a.b.e.a$v r0 = (kotlin.l.b.a.b.e.a.v) r0     // Catch:{ k -> 0x0016 }
                    r4.f(r0)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return r4
                L_0x0016:
                    r0 = move-exception
                    r1 = r0
                    kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                    kotlin.l.b.a.b.e.a$v r0 = (kotlin.l.b.a.b.e.a.v) r0     // Catch:{ all -> 0x002e }
                    r2 = 59023(0xe68f, float:8.2709E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)     // Catch:{ all -> 0x0023 }
                    throw r1     // Catch:{ all -> 0x0023 }
                L_0x0023:
                    r1 = move-exception
                    r2 = r0
                L_0x0025:
                    if (r2 == 0) goto L_0x002a
                    r4.f(r2)
                L_0x002a:
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    throw r1
                L_0x002e:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x0025
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.v.C2327a.A(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.a$v$a");
            }

            private void hIg() {
                AppMethodBeat.i(59024);
                if ((this.bOT & 1) != 1) {
                    this.TAr = new ArrayList(this.TAr);
                    this.bOT |= 1;
                }
                AppMethodBeat.o(59024);
            }

            private C2327a hIe() {
                AppMethodBeat.i(59020);
                C2327a f2 = new C2327a().f(hIf());
                AppMethodBeat.o(59020);
                return f2;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ v hED() {
                AppMethodBeat.i(59025);
                v hId = v.hId();
                AppMethodBeat.o(59025);
                return hId;
            }

            @Override // kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEG() {
                AppMethodBeat.i(59031);
                v hIf = hIf();
                if (!hIf.isInitialized()) {
                    kotlin.l.b.a.b.h.w wVar = new kotlin.l.b.a.b.h.w();
                    AppMethodBeat.o(59031);
                    throw wVar;
                }
                AppMethodBeat.o(59031);
                return hIf;
            }

            @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                AppMethodBeat.i(59032);
                v hId = v.hId();
                AppMethodBeat.o(59032);
                return hId;
            }

            static /* synthetic */ C2327a hIh() {
                AppMethodBeat.i(59034);
                C2327a aVar = new C2327a();
                AppMethodBeat.o(59034);
                return aVar;
            }
        }

        public static C2327a c(v vVar) {
            AppMethodBeat.i(59038);
            C2327a f2 = C2327a.hIh().f(vVar);
            AppMethodBeat.o(59038);
            return f2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEw() {
            AppMethodBeat.i(59039);
            C2327a f2 = C2327a.hIh().f(this);
            AppMethodBeat.o(59039);
            return f2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEx() {
            AppMethodBeat.i(59040);
            C2327a hIh = C2327a.hIh();
            AppMethodBeat.o(59040);
            return hIh;
        }

        @Override // kotlin.l.b.a.b.h.r
        public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
            return TAq;
        }
    }

    public static final class l extends i.c<l> implements l {
        public static kotlin.l.b.a.b.h.s<l> TwL = new kotlin.l.b.a.b.h.b<l>() {
            /* class kotlin.l.b.a.b.e.a.l.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.h.s
            public final /* synthetic */ Object a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58661);
                l lVar = new l(eVar, gVar, (byte) 0);
                AppMethodBeat.o(58661);
                return lVar;
            }
        };
        private static final l TyO;
        private final kotlin.l.b.a.b.h.d TwK;
        public o TyP;
        public n TyQ;
        public k TyR;
        public List<b> TyS;
        private int bOT;
        private byte bPe;
        private int bVY;

        /* synthetic */ l(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar, byte b2) {
            this(eVar, gVar);
        }

        /* synthetic */ l(i.b bVar, byte b2) {
            this(bVar);
        }

        private l(i.b<l, ?> bVar) {
            super(bVar);
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = bVar.TwK;
        }

        private l() {
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = kotlin.l.b.a.b.h.d.TDp;
        }

        public static l hGo() {
            return TyO;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v11, resolved type: java.util.List<kotlin.l.b.a.b.e.a$b> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0070  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private l(kotlin.l.b.a.b.h.e r11, kotlin.l.b.a.b.h.g r12) {
            /*
            // Method dump skipped, instructions count: 400
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.l.<init>(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):void");
        }

        static {
            AppMethodBeat.i(58691);
            l lVar = new l();
            TyO = lVar;
            lVar.hEu();
            AppMethodBeat.o(58691);
        }

        @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
        public final kotlin.l.b.a.b.h.s<l> hEs() {
            return TwL;
        }

        public final boolean hGp() {
            return (this.bOT & 1) == 1;
        }

        public final boolean hGq() {
            return (this.bOT & 2) == 2;
        }

        public final boolean CL() {
            return (this.bOT & 4) == 4;
        }

        private void hEu() {
            AppMethodBeat.i(58684);
            this.TyP = o.hGN();
            this.TyQ = n.hGC();
            this.TyR = k.hGj();
            this.TyS = Collections.emptyList();
            AppMethodBeat.o(58684);
        }

        @Override // kotlin.l.b.a.b.h.r
        public final boolean isInitialized() {
            AppMethodBeat.i(58685);
            byte b2 = this.bPe;
            if (b2 == 1) {
                AppMethodBeat.o(58685);
                return true;
            } else if (b2 == 0) {
                AppMethodBeat.o(58685);
                return false;
            } else if (hGq() && !this.TyQ.isInitialized()) {
                this.bPe = 0;
                AppMethodBeat.o(58685);
                return false;
            } else if (!CL() || this.TyR.isInitialized()) {
                for (int i2 = 0; i2 < this.TyS.size(); i2++) {
                    if (!this.TyS.get(i2).isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58685);
                        return false;
                    }
                }
                if (!this.TDA.isInitialized()) {
                    this.bPe = 0;
                    AppMethodBeat.o(58685);
                    return false;
                }
                this.bPe = 1;
                AppMethodBeat.o(58685);
                return true;
            } else {
                this.bPe = 0;
                AppMethodBeat.o(58685);
                return false;
            }
        }

        @Override // kotlin.l.b.a.b.h.q
        public final void a(kotlin.l.b.a.b.h.f fVar) {
            AppMethodBeat.i(58686);
            yC();
            i.c<MessageType>.a hJC = hJC();
            if ((this.bOT & 1) == 1) {
                fVar.a(1, this.TyP);
            }
            if ((this.bOT & 2) == 2) {
                fVar.a(2, this.TyQ);
            }
            if ((this.bOT & 4) == 4) {
                fVar.a(3, this.TyR);
            }
            for (int i2 = 0; i2 < this.TyS.size(); i2++) {
                fVar.a(4, this.TyS.get(i2));
            }
            hJC.b(200, fVar);
            fVar.e(this.TwK);
            AppMethodBeat.o(58686);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final int yC() {
            AppMethodBeat.i(58687);
            int i2 = this.bVY;
            if (i2 != -1) {
                AppMethodBeat.o(58687);
                return i2;
            }
            int c2 = (this.bOT & 1) == 1 ? kotlin.l.b.a.b.h.f.c(1, this.TyP) + 0 : 0;
            if ((this.bOT & 2) == 2) {
                c2 += kotlin.l.b.a.b.h.f.c(2, this.TyQ);
            }
            if ((this.bOT & 4) == 4) {
                c2 += kotlin.l.b.a.b.h.f.c(3, this.TyR);
            }
            for (int i3 = 0; i3 < this.TyS.size(); i3++) {
                c2 = kotlin.l.b.a.b.h.f.c(4, this.TyS.get(i3)) + c2;
            }
            int yC = this.TDA.yC() + c2 + this.TwK.size();
            this.bVY = yC;
            AppMethodBeat.o(58687);
            return yC;
        }

        public static l d(InputStream inputStream, kotlin.l.b.a.b.h.g gVar) {
            AppMethodBeat.i(58688);
            l j2 = TwL.j(inputStream, gVar);
            AppMethodBeat.o(58688);
            return j2;
        }

        /* renamed from: kotlin.l.b.a.b.e.a$l$a  reason: collision with other inner class name */
        public static final class C2314a extends i.b<l, C2314a> implements l {
            private o TyP = o.hGN();
            private n TyQ = n.hGC();
            private k TyR = k.hGj();
            private List<b> TyS = Collections.emptyList();
            private int bOT;

            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ i.a a(kotlin.l.b.a.b.h.i iVar) {
                AppMethodBeat.i(58675);
                C2314a c2 = c((l) iVar);
                AppMethodBeat.o(58675);
                return c2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
            public final /* synthetic */ a.AbstractC2337a c(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58677);
                C2314a o = o(eVar, gVar);
                AppMethodBeat.o(58677);
                return o;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a, java.lang.Object
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(58681);
                C2314a hGr = hGr();
                AppMethodBeat.o(58681);
                return hGr;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q.a d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58679);
                C2314a o = o(eVar, gVar);
                AppMethodBeat.o(58679);
                return o;
            }

            @Override // kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ i.a hEE() {
                AppMethodBeat.i(58676);
                C2314a hGr = hGr();
                AppMethodBeat.o(58676);
                return hGr;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.b, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ a.AbstractC2337a hEF() {
                AppMethodBeat.i(58678);
                C2314a hGr = hGr();
                AppMethodBeat.o(58678);
                return hGr;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$b' to match base method */
            @Override // kotlin.l.b.a.b.h.i.b
            public final /* synthetic */ C2314a hFq() {
                AppMethodBeat.i(58672);
                C2314a hGr = hGr();
                AppMethodBeat.o(58672);
                return hGr;
            }

            private C2314a() {
                AppMethodBeat.i(58662);
                AppMethodBeat.o(58662);
            }

            private l hGs() {
                int i2 = 1;
                AppMethodBeat.i(58664);
                l lVar = new l(this, (byte) 0);
                int i3 = this.bOT;
                if ((i3 & 1) != 1) {
                    i2 = 0;
                }
                lVar.TyP = this.TyP;
                if ((i3 & 2) == 2) {
                    i2 |= 2;
                }
                lVar.TyQ = this.TyQ;
                if ((i3 & 4) == 4) {
                    i2 |= 4;
                }
                lVar.TyR = this.TyR;
                if ((this.bOT & 8) == 8) {
                    this.TyS = Collections.unmodifiableList(this.TyS);
                    this.bOT &= -9;
                }
                lVar.TyS = this.TyS;
                lVar.bOT = i2;
                AppMethodBeat.o(58664);
                return lVar;
            }

            public final C2314a c(l lVar) {
                AppMethodBeat.i(58665);
                if (lVar == l.hGo()) {
                    AppMethodBeat.o(58665);
                } else {
                    if (lVar.hGp()) {
                        a(lVar.TyP);
                    }
                    if (lVar.hGq()) {
                        a(lVar.TyQ);
                    }
                    if (lVar.CL()) {
                        g(lVar.TyR);
                    }
                    if (!lVar.TyS.isEmpty()) {
                        if (this.TyS.isEmpty()) {
                            this.TyS = lVar.TyS;
                            this.bOT &= -9;
                        } else {
                            hGt();
                            this.TyS.addAll(lVar.TyS);
                        }
                    }
                    a((i.c) lVar);
                    this.TwK = this.TwK.a(lVar.TwK);
                    AppMethodBeat.o(58665);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private kotlin.l.b.a.b.e.a.l.C2314a o(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                /*
                    r4 = this;
                    r3 = 58667(0xe52b, float:8.221E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    r2 = 0
                    kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.a$l> r0 = kotlin.l.b.a.b.e.a.l.TwL     // Catch:{ k -> 0x0016 }
                    java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                    kotlin.l.b.a.b.e.a$l r0 = (kotlin.l.b.a.b.e.a.l) r0     // Catch:{ k -> 0x0016 }
                    r4.c(r0)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return r4
                L_0x0016:
                    r0 = move-exception
                    r1 = r0
                    kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                    kotlin.l.b.a.b.e.a$l r0 = (kotlin.l.b.a.b.e.a.l) r0     // Catch:{ all -> 0x002e }
                    r2 = 58667(0xe52b, float:8.221E-41)
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.l.C2314a.o(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.a$l$a");
            }

            private C2314a a(o oVar) {
                AppMethodBeat.i(58668);
                if ((this.bOT & 1) != 1 || this.TyP == o.hGN()) {
                    this.TyP = oVar;
                } else {
                    this.TyP = o.b(this.TyP).e(oVar).hGP();
                }
                this.bOT |= 1;
                AppMethodBeat.o(58668);
                return this;
            }

            private C2314a a(n nVar) {
                AppMethodBeat.i(58669);
                if ((this.bOT & 2) != 2 || this.TyQ == n.hGC()) {
                    this.TyQ = nVar;
                } else {
                    this.TyQ = n.b(this.TyQ).e(nVar).hGE();
                }
                this.bOT |= 2;
                AppMethodBeat.o(58669);
                return this;
            }

            private C2314a g(k kVar) {
                AppMethodBeat.i(58670);
                if ((this.bOT & 4) != 4 || this.TyR == k.hGj()) {
                    this.TyR = kVar;
                } else {
                    this.TyR = k.a(this.TyR).f(kVar).hGm();
                }
                this.bOT |= 4;
                AppMethodBeat.o(58670);
                return this;
            }

            private void hGt() {
                AppMethodBeat.i(58671);
                if ((this.bOT & 8) != 8) {
                    this.TyS = new ArrayList(this.TyS);
                    this.bOT |= 8;
                }
                AppMethodBeat.o(58671);
            }

            private C2314a hGr() {
                AppMethodBeat.i(58663);
                C2314a c2 = new C2314a().c(hGs());
                AppMethodBeat.o(58663);
                return c2;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                AppMethodBeat.i(58666);
                if (!((this.bOT & 2) == 2) || this.TyQ.isInitialized()) {
                    if (!((this.bOT & 4) == 4) || this.TyR.isInitialized()) {
                        for (int i2 = 0; i2 < this.TyS.size(); i2++) {
                            if (!this.TyS.get(i2).isInitialized()) {
                                AppMethodBeat.o(58666);
                                return false;
                            }
                        }
                        if (!this.TDA.isInitialized()) {
                            AppMethodBeat.o(58666);
                            return false;
                        }
                        AppMethodBeat.o(58666);
                        return true;
                    }
                    AppMethodBeat.o(58666);
                    return false;
                }
                AppMethodBeat.o(58666);
                return false;
            }

            @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                AppMethodBeat.i(58673);
                l hGo = l.hGo();
                AppMethodBeat.o(58673);
                return hGo;
            }

            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ kotlin.l.b.a.b.h.i hED() {
                AppMethodBeat.i(58674);
                l hGo = l.hGo();
                AppMethodBeat.o(58674);
                return hGo;
            }

            @Override // kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEG() {
                AppMethodBeat.i(58680);
                l hGs = hGs();
                if (!hGs.isInitialized()) {
                    kotlin.l.b.a.b.h.w wVar = new kotlin.l.b.a.b.h.w();
                    AppMethodBeat.o(58680);
                    throw wVar;
                }
                AppMethodBeat.o(58680);
                return hGs;
            }

            static /* synthetic */ C2314a hGu() {
                AppMethodBeat.i(58682);
                C2314a aVar = new C2314a();
                AppMethodBeat.o(58682);
                return aVar;
            }
        }

        @Override // kotlin.l.b.a.b.h.r
        public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
            return TyO;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEw() {
            AppMethodBeat.i(58689);
            C2314a c2 = C2314a.hGu().c(this);
            AppMethodBeat.o(58689);
            return c2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEx() {
            AppMethodBeat.i(58690);
            C2314a hGu = C2314a.hGu();
            AppMethodBeat.o(58690);
            return hGu;
        }
    }

    public static final class d extends kotlin.l.b.a.b.h.i implements g {
        public static kotlin.l.b.a.b.h.s<d> TwL = new kotlin.l.b.a.b.h.b<d>() {
            /* class kotlin.l.b.a.b.e.a.d.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.h.s
            public final /* synthetic */ Object a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58463);
                d dVar = new d(eVar, gVar, (byte) 0);
                AppMethodBeat.o(58463);
                return dVar;
            }
        };
        private static final d TxU;
        private final kotlin.l.b.a.b.h.d TwK;
        private List<e> TxV;
        private byte bPe;
        private int bVY;

        /* synthetic */ d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar, byte b2) {
            this(eVar, gVar);
        }

        /* synthetic */ d(i.a aVar, byte b2) {
            this(aVar);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEw() {
            AppMethodBeat.i(58487);
            C2308a hFy = hFy();
            AppMethodBeat.o(58487);
            return hFy;
        }

        private d(i.a aVar) {
            super((byte) 0);
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = aVar.TwK;
        }

        private d() {
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = kotlin.l.b.a.b.h.d.TDp;
        }

        public static d hFx() {
            return TxU;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: java.util.List<kotlin.l.b.a.b.e.a$e> */
        /* JADX WARN: Multi-variable type inference failed */
        private d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
            AppMethodBeat.i(58481);
            this.bPe = -1;
            this.bVY = -1;
            this.TxV = Collections.emptyList();
            d.b hJo = kotlin.l.b.a.b.h.d.hJo();
            kotlin.l.b.a.b.h.f f2 = kotlin.l.b.a.b.h.f.f(hJo, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int yT = eVar.yT();
                    switch (yT) {
                        case 0:
                            z = true;
                            break;
                        case 10:
                            if (!z2 || !true) {
                                this.TxV = new ArrayList();
                                z2 |= true;
                            }
                            this.TxV.add(eVar.a(e.TwL, gVar));
                            break;
                        default:
                            if (a(eVar, f2, gVar, yT)) {
                                break;
                            } else {
                                z = true;
                                break;
                            }
                    }
                } catch (kotlin.l.b.a.b.h.k e2) {
                    e2.TDK = this;
                    AppMethodBeat.o(58481);
                    throw e2;
                } catch (IOException e3) {
                    kotlin.l.b.a.b.h.k kVar = new kotlin.l.b.a.b.h.k(e3.getMessage());
                    kVar.TDK = this;
                    AppMethodBeat.o(58481);
                    throw kVar;
                } catch (Throwable th) {
                    if (z2 && true) {
                        this.TxV = Collections.unmodifiableList(this.TxV);
                    }
                    try {
                        f2.flush();
                        this.TwK = hJo.hJs();
                    } catch (IOException e4) {
                        this.TwK = hJo.hJs();
                    } catch (Throwable th2) {
                        this.TwK = hJo.hJs();
                        AppMethodBeat.o(58481);
                        throw th2;
                    }
                    Gw();
                    AppMethodBeat.o(58481);
                    throw th;
                }
            }
            if (z2 && true) {
                this.TxV = Collections.unmodifiableList(this.TxV);
            }
            try {
                f2.flush();
                this.TwK = hJo.hJs();
            } catch (IOException e5) {
                this.TwK = hJo.hJs();
            } catch (Throwable th3) {
                this.TwK = hJo.hJs();
                AppMethodBeat.o(58481);
                throw th3;
            }
            Gw();
            AppMethodBeat.o(58481);
        }

        static {
            AppMethodBeat.i(58489);
            d dVar = new d();
            TxU = dVar;
            dVar.TxV = Collections.emptyList();
            AppMethodBeat.o(58489);
        }

        @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
        public final kotlin.l.b.a.b.h.s<d> hEs() {
            return TwL;
        }

        @Override // kotlin.l.b.a.b.h.r
        public final boolean isInitialized() {
            AppMethodBeat.i(58482);
            byte b2 = this.bPe;
            if (b2 == 1) {
                AppMethodBeat.o(58482);
                return true;
            } else if (b2 == 0) {
                AppMethodBeat.o(58482);
                return false;
            } else {
                for (int i2 = 0; i2 < this.TxV.size(); i2++) {
                    if (!this.TxV.get(i2).isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58482);
                        return false;
                    }
                }
                this.bPe = 1;
                AppMethodBeat.o(58482);
                return true;
            }
        }

        @Override // kotlin.l.b.a.b.h.q
        public final void a(kotlin.l.b.a.b.h.f fVar) {
            AppMethodBeat.i(58483);
            yC();
            for (int i2 = 0; i2 < this.TxV.size(); i2++) {
                fVar.a(1, this.TxV.get(i2));
            }
            fVar.e(this.TwK);
            AppMethodBeat.o(58483);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final int yC() {
            AppMethodBeat.i(58484);
            int i2 = this.bVY;
            if (i2 != -1) {
                AppMethodBeat.o(58484);
                return i2;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.TxV.size(); i4++) {
                i3 += kotlin.l.b.a.b.h.f.c(1, this.TxV.get(i4));
            }
            int size = this.TwK.size() + i3;
            this.bVY = size;
            AppMethodBeat.o(58484);
            return size;
        }

        /* renamed from: kotlin.l.b.a.b.e.a$d$a  reason: collision with other inner class name */
        public static final class C2308a extends i.a<d, C2308a> implements g {
            private List<e> TxV = Collections.emptyList();
            private int bOT;

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.l.b.a.b.h.i] */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2308a a(d dVar) {
                AppMethodBeat.i(58472);
                C2308a d2 = d(dVar);
                AppMethodBeat.o(58472);
                return d2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
            public final /* synthetic */ a.AbstractC2337a c(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58474);
                C2308a i2 = i(eVar, gVar);
                AppMethodBeat.o(58474);
                return i2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a, java.lang.Object
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(58479);
                C2308a hFz = hFz();
                AppMethodBeat.o(58479);
                return hFz;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q.a d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58476);
                C2308a i2 = i(eVar, gVar);
                AppMethodBeat.o(58476);
                return i2;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2308a hEE() {
                AppMethodBeat.i(58473);
                C2308a hFz = hFz();
                AppMethodBeat.o(58473);
                return hFz;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ a.AbstractC2337a hEF() {
                AppMethodBeat.i(58475);
                C2308a hFz = hFz();
                AppMethodBeat.o(58475);
                return hFz;
            }

            private C2308a() {
                AppMethodBeat.i(58464);
                AppMethodBeat.o(58464);
            }

            public final d hFA() {
                AppMethodBeat.i(58466);
                d dVar = new d(this, (byte) 0);
                if ((this.bOT & 1) == 1) {
                    this.TxV = Collections.unmodifiableList(this.TxV);
                    this.bOT &= -2;
                }
                dVar.TxV = this.TxV;
                AppMethodBeat.o(58466);
                return dVar;
            }

            public final C2308a d(d dVar) {
                AppMethodBeat.i(58467);
                if (dVar == d.hFx()) {
                    AppMethodBeat.o(58467);
                } else {
                    if (!dVar.TxV.isEmpty()) {
                        if (this.TxV.isEmpty()) {
                            this.TxV = dVar.TxV;
                            this.bOT &= -2;
                        } else {
                            hFB();
                            this.TxV.addAll(dVar.TxV);
                        }
                    }
                    this.TwK = this.TwK.a(dVar.TwK);
                    AppMethodBeat.o(58467);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private kotlin.l.b.a.b.e.a.d.C2308a i(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                /*
                    r4 = this;
                    r3 = 58469(0xe465, float:8.1933E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    r2 = 0
                    kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.a$d> r0 = kotlin.l.b.a.b.e.a.d.TwL     // Catch:{ k -> 0x0016 }
                    java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                    kotlin.l.b.a.b.e.a$d r0 = (kotlin.l.b.a.b.e.a.d) r0     // Catch:{ k -> 0x0016 }
                    r4.d(r0)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return r4
                L_0x0016:
                    r0 = move-exception
                    r1 = r0
                    kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                    kotlin.l.b.a.b.e.a$d r0 = (kotlin.l.b.a.b.e.a.d) r0     // Catch:{ all -> 0x002e }
                    r2 = 58469(0xe465, float:8.1933E-41)
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.d.C2308a.i(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.a$d$a");
            }

            private void hFB() {
                AppMethodBeat.i(58470);
                if ((this.bOT & 1) != 1) {
                    this.TxV = new ArrayList(this.TxV);
                    this.bOT |= 1;
                }
                AppMethodBeat.o(58470);
            }

            private C2308a hFz() {
                AppMethodBeat.i(58465);
                C2308a d2 = new C2308a().d(hFA());
                AppMethodBeat.o(58465);
                return d2;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                AppMethodBeat.i(58468);
                for (int i2 = 0; i2 < this.TxV.size(); i2++) {
                    if (!this.TxV.get(i2).isInitialized()) {
                        AppMethodBeat.o(58468);
                        return false;
                    }
                }
                AppMethodBeat.o(58468);
                return true;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ d hED() {
                AppMethodBeat.i(58471);
                d hFx = d.hFx();
                AppMethodBeat.o(58471);
                return hFx;
            }

            @Override // kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEG() {
                AppMethodBeat.i(58477);
                d hFA = hFA();
                if (!hFA.isInitialized()) {
                    kotlin.l.b.a.b.h.w wVar = new kotlin.l.b.a.b.h.w();
                    AppMethodBeat.o(58477);
                    throw wVar;
                }
                AppMethodBeat.o(58477);
                return hFA;
            }

            @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                AppMethodBeat.i(58478);
                d hFx = d.hFx();
                AppMethodBeat.o(58478);
                return hFx;
            }

            static /* synthetic */ C2308a hFC() {
                AppMethodBeat.i(58480);
                C2308a aVar = new C2308a();
                AppMethodBeat.o(58480);
                return aVar;
            }
        }

        public static C2308a a(d dVar) {
            AppMethodBeat.i(58485);
            C2308a d2 = C2308a.hFC().d(dVar);
            AppMethodBeat.o(58485);
            return d2;
        }

        public final C2308a hFy() {
            AppMethodBeat.i(58486);
            C2308a d2 = C2308a.hFC().d(this);
            AppMethodBeat.o(58486);
            return d2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEx() {
            AppMethodBeat.i(58488);
            C2308a hFC = C2308a.hFC();
            AppMethodBeat.o(58488);
            return hFC;
        }

        @Override // kotlin.l.b.a.b.h.r
        public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
            return TxU;
        }
    }

    public static final class e extends kotlin.l.b.a.b.h.i implements h {
        public static kotlin.l.b.a.b.h.s<e> TwL = new kotlin.l.b.a.b.h.b<e>() {
            /* class kotlin.l.b.a.b.e.a.e.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.h.s
            public final /* synthetic */ Object a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58490);
                e eVar2 = new e(eVar, gVar, (byte) 0);
                AppMethodBeat.o(58490);
                return eVar2;
            }
        };
        private static final e TxW;
        private final kotlin.l.b.a.b.h.d TwK;
        b TxX;
        private List<g> TxY;
        g TxZ;
        c Tya;
        private int bOT;
        private byte bPe;
        private int bVY;

        /* synthetic */ e(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar, byte b2) {
            this(eVar, gVar);
        }

        /* synthetic */ e(i.a aVar, byte b2) {
            this(aVar);
        }

        private e(i.a aVar) {
            super((byte) 0);
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = aVar.TwK;
        }

        private e() {
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = kotlin.l.b.a.b.h.d.TDp;
        }

        public static e hFD() {
            return TxW;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v28, resolved type: java.util.List<kotlin.l.b.a.b.e.a$g> */
        /* JADX WARN: Multi-variable type inference failed */
        private e(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
            g.C2311a aVar;
            AppMethodBeat.i(58519);
            this.bPe = -1;
            this.bVY = -1;
            hEu();
            d.b hJo = kotlin.l.b.a.b.h.d.hJo();
            kotlin.l.b.a.b.h.f f2 = kotlin.l.b.a.b.h.f.f(hJo, 1);
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    int yT = eVar.yT();
                    switch (yT) {
                        case 0:
                            z = true;
                            break;
                        case 8:
                            int zi = eVar.zi();
                            b auh = b.auh(zi);
                            if (auh != null) {
                                this.bOT |= 1;
                                this.TxX = auh;
                                break;
                            } else {
                                f2.hc(yT);
                                f2.hc(zi);
                                break;
                            }
                        case 18:
                            if (!(z2 & true)) {
                                this.TxY = new ArrayList();
                                z2 |= true;
                            }
                            this.TxY.add(eVar.a(g.TwL, gVar));
                            break;
                        case 26:
                            if ((this.bOT & 2) == 2) {
                                aVar = g.b(this.TxZ);
                            } else {
                                aVar = null;
                            }
                            this.TxZ = (g) eVar.a(g.TwL, gVar);
                            if (aVar != null) {
                                aVar.f(this.TxZ);
                                this.TxZ = aVar.hFV();
                            }
                            this.bOT |= 2;
                            break;
                        case 32:
                            int zi2 = eVar.zi();
                            c aui = c.aui(zi2);
                            if (aui != null) {
                                this.bOT |= 4;
                                this.Tya = aui;
                                break;
                            } else {
                                f2.hc(yT);
                                f2.hc(zi2);
                                break;
                            }
                        default:
                            if (a(eVar, f2, gVar, yT)) {
                                break;
                            } else {
                                z = true;
                                break;
                            }
                    }
                } catch (kotlin.l.b.a.b.h.k e2) {
                    e2.TDK = this;
                    AppMethodBeat.o(58519);
                    throw e2;
                } catch (IOException e3) {
                    kotlin.l.b.a.b.h.k kVar = new kotlin.l.b.a.b.h.k(e3.getMessage());
                    kVar.TDK = this;
                    AppMethodBeat.o(58519);
                    throw kVar;
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.TxY = Collections.unmodifiableList(this.TxY);
                    }
                    try {
                        f2.flush();
                        this.TwK = hJo.hJs();
                    } catch (IOException e4) {
                        this.TwK = hJo.hJs();
                    } catch (Throwable th2) {
                        this.TwK = hJo.hJs();
                        AppMethodBeat.o(58519);
                        throw th2;
                    }
                    Gw();
                    AppMethodBeat.o(58519);
                    throw th;
                }
            }
            if (z2 & true) {
                this.TxY = Collections.unmodifiableList(this.TxY);
            }
            try {
                f2.flush();
                this.TwK = hJo.hJs();
            } catch (IOException e5) {
                this.TwK = hJo.hJs();
            } catch (Throwable th3) {
                this.TwK = hJo.hJs();
                AppMethodBeat.o(58519);
                throw th3;
            }
            Gw();
            AppMethodBeat.o(58519);
        }

        static {
            AppMethodBeat.i(58526);
            e eVar = new e();
            TxW = eVar;
            eVar.hEu();
            AppMethodBeat.o(58526);
        }

        @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
        public final kotlin.l.b.a.b.h.s<e> hEs() {
            return TwL;
        }

        public enum b implements j.a {
            RETURNS_CONSTANT(0),
            CALLS(1),
            RETURNS_NOT_NULL(2);
            
            private static j.b<b> Txp = new j.b<b>() {
                /* class kotlin.l.b.a.b.e.a.e.b.AnonymousClass1 */

                /* Return type fixed from 'kotlin.l.b.a.b.h.j$a' to match base method */
                @Override // kotlin.l.b.a.b.h.j.b
                public final /* synthetic */ b aua(int i2) {
                    AppMethodBeat.i(58511);
                    b auh = b.auh(i2);
                    AppMethodBeat.o(58511);
                    return auh;
                }
            };
            final int value;

            public static b valueOf(String str) {
                AppMethodBeat.i(58513);
                b bVar = (b) Enum.valueOf(b.class, str);
                AppMethodBeat.o(58513);
                return bVar;
            }

            static {
                AppMethodBeat.i(58514);
                AppMethodBeat.o(58514);
            }

            @Override // kotlin.l.b.a.b.h.j.a
            public final int getNumber() {
                return this.value;
            }

            public static b auh(int i2) {
                switch (i2) {
                    case 0:
                        return RETURNS_CONSTANT;
                    case 1:
                        return CALLS;
                    case 2:
                        return RETURNS_NOT_NULL;
                    default:
                        return null;
                }
            }

            private b(int i2) {
                this.value = i2;
            }
        }

        public enum c implements j.a {
            AT_MOST_ONCE(0),
            EXACTLY_ONCE(1),
            AT_LEAST_ONCE(2);
            
            private static j.b<c> Txp = new j.b<c>() {
                /* class kotlin.l.b.a.b.e.a.e.c.AnonymousClass1 */

                /* Return type fixed from 'kotlin.l.b.a.b.h.j$a' to match base method */
                @Override // kotlin.l.b.a.b.h.j.b
                public final /* synthetic */ c aua(int i2) {
                    AppMethodBeat.i(58515);
                    c aui = c.aui(i2);
                    AppMethodBeat.o(58515);
                    return aui;
                }
            };
            final int value;

            public static c valueOf(String str) {
                AppMethodBeat.i(58517);
                c cVar = (c) Enum.valueOf(c.class, str);
                AppMethodBeat.o(58517);
                return cVar;
            }

            static {
                AppMethodBeat.i(58518);
                AppMethodBeat.o(58518);
            }

            @Override // kotlin.l.b.a.b.h.j.a
            public final int getNumber() {
                return this.value;
            }

            public static c aui(int i2) {
                switch (i2) {
                    case 0:
                        return AT_MOST_ONCE;
                    case 1:
                        return EXACTLY_ONCE;
                    case 2:
                        return AT_LEAST_ONCE;
                    default:
                        return null;
                }
            }

            private c(int i2) {
                this.value = i2;
            }
        }

        public final boolean hFE() {
            return (this.bOT & 1) == 1;
        }

        public final boolean hFF() {
            return (this.bOT & 2) == 2;
        }

        public final boolean hFG() {
            return (this.bOT & 4) == 4;
        }

        private void hEu() {
            AppMethodBeat.i(58520);
            this.TxX = b.RETURNS_CONSTANT;
            this.TxY = Collections.emptyList();
            this.TxZ = g.hFP();
            this.Tya = c.AT_MOST_ONCE;
            AppMethodBeat.o(58520);
        }

        @Override // kotlin.l.b.a.b.h.r
        public final boolean isInitialized() {
            AppMethodBeat.i(58521);
            byte b2 = this.bPe;
            if (b2 == 1) {
                AppMethodBeat.o(58521);
                return true;
            } else if (b2 == 0) {
                AppMethodBeat.o(58521);
                return false;
            } else {
                for (int i2 = 0; i2 < this.TxY.size(); i2++) {
                    if (!this.TxY.get(i2).isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58521);
                        return false;
                    }
                }
                if (!hFF() || this.TxZ.isInitialized()) {
                    this.bPe = 1;
                    AppMethodBeat.o(58521);
                    return true;
                }
                this.bPe = 0;
                AppMethodBeat.o(58521);
                return false;
            }
        }

        @Override // kotlin.l.b.a.b.h.q
        public final void a(kotlin.l.b.a.b.h.f fVar) {
            AppMethodBeat.i(58522);
            yC();
            if ((this.bOT & 1) == 1) {
                fVar.nb(1, this.TxX.value);
            }
            for (int i2 = 0; i2 < this.TxY.size(); i2++) {
                fVar.a(2, this.TxY.get(i2));
            }
            if ((this.bOT & 2) == 2) {
                fVar.a(3, this.TxZ);
            }
            if ((this.bOT & 4) == 4) {
                fVar.nb(4, this.Tya.value);
            }
            fVar.e(this.TwK);
            AppMethodBeat.o(58522);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final int yC() {
            int i2;
            int i3;
            int i4 = 0;
            AppMethodBeat.i(58523);
            int i5 = this.bVY;
            if (i5 != -1) {
                AppMethodBeat.o(58523);
                return i5;
            }
            if ((this.bOT & 1) == 1) {
                i2 = kotlin.l.b.a.b.h.f.bv(1, this.TxX.value) + 0;
            } else {
                i2 = 0;
            }
            while (true) {
                i3 = i2;
                if (i4 >= this.TxY.size()) {
                    break;
                }
                i2 = kotlin.l.b.a.b.h.f.c(2, this.TxY.get(i4)) + i3;
                i4++;
            }
            if ((this.bOT & 2) == 2) {
                i3 += kotlin.l.b.a.b.h.f.c(3, this.TxZ);
            }
            if ((this.bOT & 4) == 4) {
                i3 += kotlin.l.b.a.b.h.f.bv(4, this.Tya.value);
            }
            int size = this.TwK.size() + i3;
            this.bVY = size;
            AppMethodBeat.o(58523);
            return size;
        }

        /* renamed from: kotlin.l.b.a.b.e.a$e$a  reason: collision with other inner class name */
        public static final class C2309a extends i.a<e, C2309a> implements h {
            private b TxX = b.RETURNS_CONSTANT;
            private List<g> TxY = Collections.emptyList();
            private g TxZ = g.hFP();
            private c Tya = c.AT_MOST_ONCE;
            private int bOT;

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.l.b.a.b.h.i] */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2309a a(e eVar) {
                AppMethodBeat.i(58502);
                C2309a c2 = c(eVar);
                AppMethodBeat.o(58502);
                return c2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
            public final /* synthetic */ a.AbstractC2337a c(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58504);
                C2309a j2 = j(eVar, gVar);
                AppMethodBeat.o(58504);
                return j2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a, java.lang.Object
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(58509);
                C2309a hFH = hFH();
                AppMethodBeat.o(58509);
                return hFH;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q.a d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58506);
                C2309a j2 = j(eVar, gVar);
                AppMethodBeat.o(58506);
                return j2;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2309a hEE() {
                AppMethodBeat.i(58503);
                C2309a hFH = hFH();
                AppMethodBeat.o(58503);
                return hFH;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ a.AbstractC2337a hEF() {
                AppMethodBeat.i(58505);
                C2309a hFH = hFH();
                AppMethodBeat.o(58505);
                return hFH;
            }

            private C2309a() {
                AppMethodBeat.i(58491);
                AppMethodBeat.o(58491);
            }

            private e hFI() {
                int i2 = 1;
                AppMethodBeat.i(58493);
                e eVar = new e(this, (byte) 0);
                int i3 = this.bOT;
                if ((i3 & 1) != 1) {
                    i2 = 0;
                }
                eVar.TxX = this.TxX;
                if ((this.bOT & 2) == 2) {
                    this.TxY = Collections.unmodifiableList(this.TxY);
                    this.bOT &= -3;
                }
                eVar.TxY = this.TxY;
                if ((i3 & 4) == 4) {
                    i2 |= 2;
                }
                eVar.TxZ = this.TxZ;
                if ((i3 & 8) == 8) {
                    i2 |= 4;
                }
                eVar.Tya = this.Tya;
                eVar.bOT = i2;
                AppMethodBeat.o(58493);
                return eVar;
            }

            public final C2309a c(e eVar) {
                AppMethodBeat.i(58494);
                if (eVar == e.hFD()) {
                    AppMethodBeat.o(58494);
                } else {
                    if (eVar.hFE()) {
                        a(eVar.TxX);
                    }
                    if (!eVar.TxY.isEmpty()) {
                        if (this.TxY.isEmpty()) {
                            this.TxY = eVar.TxY;
                            this.bOT &= -3;
                        } else {
                            hFJ();
                            this.TxY.addAll(eVar.TxY);
                        }
                    }
                    if (eVar.hFF()) {
                        a(eVar.TxZ);
                    }
                    if (eVar.hFG()) {
                        a(eVar.Tya);
                    }
                    this.TwK = this.TwK.a(eVar.TwK);
                    AppMethodBeat.o(58494);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private kotlin.l.b.a.b.e.a.e.C2309a j(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                /*
                    r4 = this;
                    r3 = 58496(0xe480, float:8.197E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    r2 = 0
                    kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.a$e> r0 = kotlin.l.b.a.b.e.a.e.TwL     // Catch:{ k -> 0x0016 }
                    java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                    kotlin.l.b.a.b.e.a$e r0 = (kotlin.l.b.a.b.e.a.e) r0     // Catch:{ k -> 0x0016 }
                    r4.c(r0)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return r4
                L_0x0016:
                    r0 = move-exception
                    r1 = r0
                    kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                    kotlin.l.b.a.b.e.a$e r0 = (kotlin.l.b.a.b.e.a.e) r0     // Catch:{ all -> 0x002e }
                    r2 = 58496(0xe480, float:8.197E-41)
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.e.C2309a.j(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.a$e$a");
            }

            private C2309a a(b bVar) {
                AppMethodBeat.i(58497);
                if (bVar == null) {
                    NullPointerException nullPointerException = new NullPointerException();
                    AppMethodBeat.o(58497);
                    throw nullPointerException;
                }
                this.bOT |= 1;
                this.TxX = bVar;
                AppMethodBeat.o(58497);
                return this;
            }

            private void hFJ() {
                AppMethodBeat.i(58498);
                if ((this.bOT & 2) != 2) {
                    this.TxY = new ArrayList(this.TxY);
                    this.bOT |= 2;
                }
                AppMethodBeat.o(58498);
            }

            private C2309a a(g gVar) {
                AppMethodBeat.i(58499);
                if ((this.bOT & 4) != 4 || this.TxZ == g.hFP()) {
                    this.TxZ = gVar;
                } else {
                    this.TxZ = g.b(this.TxZ).f(gVar).hFV();
                }
                this.bOT |= 4;
                AppMethodBeat.o(58499);
                return this;
            }

            private C2309a a(c cVar) {
                AppMethodBeat.i(58500);
                if (cVar == null) {
                    NullPointerException nullPointerException = new NullPointerException();
                    AppMethodBeat.o(58500);
                    throw nullPointerException;
                }
                this.bOT |= 8;
                this.Tya = cVar;
                AppMethodBeat.o(58500);
                return this;
            }

            private C2309a hFH() {
                AppMethodBeat.i(58492);
                C2309a c2 = new C2309a().c(hFI());
                AppMethodBeat.o(58492);
                return c2;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                AppMethodBeat.i(58495);
                for (int i2 = 0; i2 < this.TxY.size(); i2++) {
                    if (!this.TxY.get(i2).isInitialized()) {
                        AppMethodBeat.o(58495);
                        return false;
                    }
                }
                if (!((this.bOT & 4) == 4) || this.TxZ.isInitialized()) {
                    AppMethodBeat.o(58495);
                    return true;
                }
                AppMethodBeat.o(58495);
                return false;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ e hED() {
                AppMethodBeat.i(58501);
                e hFD = e.hFD();
                AppMethodBeat.o(58501);
                return hFD;
            }

            @Override // kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEG() {
                AppMethodBeat.i(58507);
                e hFI = hFI();
                if (!hFI.isInitialized()) {
                    kotlin.l.b.a.b.h.w wVar = new kotlin.l.b.a.b.h.w();
                    AppMethodBeat.o(58507);
                    throw wVar;
                }
                AppMethodBeat.o(58507);
                return hFI;
            }

            @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                AppMethodBeat.i(58508);
                e hFD = e.hFD();
                AppMethodBeat.o(58508);
                return hFD;
            }

            static /* synthetic */ C2309a hFK() {
                AppMethodBeat.i(58510);
                C2309a aVar = new C2309a();
                AppMethodBeat.o(58510);
                return aVar;
            }
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEw() {
            AppMethodBeat.i(58524);
            C2309a c2 = C2309a.hFK().c(this);
            AppMethodBeat.o(58524);
            return c2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEx() {
            AppMethodBeat.i(58525);
            C2309a hFK = C2309a.hFK();
            AppMethodBeat.o(58525);
            return hFK;
        }

        @Override // kotlin.l.b.a.b.h.r
        public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
            return TxW;
        }
    }

    public static final class g extends kotlin.l.b.a.b.h.i implements j {
        public static kotlin.l.b.a.b.h.s<g> TwL = new kotlin.l.b.a.b.h.b<g>() {
            /* class kotlin.l.b.a.b.e.a.g.AnonymousClass1 */

            @Override // kotlin.l.b.a.b.h.s
            public final /* synthetic */ Object a(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58551);
                g gVar2 = new g(eVar, gVar, (byte) 0);
                AppMethodBeat.o(58551);
                return gVar2;
            }
        };
        private static final g Tyl;
        private final kotlin.l.b.a.b.h.d TwK;
        int Txb;
        int Tym;
        b Tyn;
        p Tyo;
        int Typ;
        private List<g> Tyq;
        private List<g> Tyr;
        private int bOT;
        private byte bPe;
        private int bVY;

        /* synthetic */ g(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar, byte b2) {
            this(eVar, gVar);
        }

        /* synthetic */ g(i.a aVar, byte b2) {
            this(aVar);
        }

        private g(i.a aVar) {
            super((byte) 0);
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = aVar.TwK;
        }

        private g() {
            this.bPe = -1;
            this.bVY = -1;
            this.TwK = kotlin.l.b.a.b.h.d.TDp;
        }

        public static g hFP() {
            return Tyl;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v11, resolved type: java.util.List<kotlin.l.b.a.b.e.a$g> */
        /* JADX DEBUG: Multi-variable search result rejected for r0v36, resolved type: java.util.List<kotlin.l.b.a.b.e.a$g> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x005f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private g(kotlin.l.b.a.b.h.e r12, kotlin.l.b.a.b.h.g r13) {
            /*
            // Method dump skipped, instructions count: 434
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.g.<init>(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):void");
        }

        static {
            AppMethodBeat.i(58584);
            g gVar = new g();
            Tyl = gVar;
            gVar.hEu();
            AppMethodBeat.o(58584);
        }

        @Override // kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.h.i
        public final kotlin.l.b.a.b.h.s<g> hEs() {
            return TwL;
        }

        public enum b implements j.a {
            TRUE(0),
            FALSE(1),
            NULL(2);
            
            private static j.b<b> Txp = new j.b<b>() {
                /* class kotlin.l.b.a.b.e.a.g.b.AnonymousClass1 */

                /* Return type fixed from 'kotlin.l.b.a.b.h.j$a' to match base method */
                @Override // kotlin.l.b.a.b.h.j.b
                public final /* synthetic */ b aua(int i2) {
                    AppMethodBeat.i(58572);
                    b aun = b.aun(i2);
                    AppMethodBeat.o(58572);
                    return aun;
                }
            };
            final int value;

            public static b valueOf(String str) {
                AppMethodBeat.i(58574);
                b bVar = (b) Enum.valueOf(b.class, str);
                AppMethodBeat.o(58574);
                return bVar;
            }

            static {
                AppMethodBeat.i(58575);
                AppMethodBeat.o(58575);
            }

            @Override // kotlin.l.b.a.b.h.j.a
            public final int getNumber() {
                return this.value;
            }

            public static b aun(int i2) {
                switch (i2) {
                    case 0:
                        return TRUE;
                    case 1:
                        return FALSE;
                    case 2:
                        return NULL;
                    default:
                        return null;
                }
            }

            private b(int i2) {
                this.value = i2;
            }
        }

        public final boolean hEP() {
            return (this.bOT & 1) == 1;
        }

        public final boolean hFQ() {
            return (this.bOT & 2) == 2;
        }

        public final boolean hFR() {
            return (this.bOT & 4) == 4;
        }

        public final boolean hFS() {
            return (this.bOT & 8) == 8;
        }

        public final boolean hFT() {
            return (this.bOT & 16) == 16;
        }

        private void hEu() {
            AppMethodBeat.i(58577);
            this.Txb = 0;
            this.Tym = 0;
            this.Tyn = b.TRUE;
            this.Tyo = p.hGS();
            this.Typ = 0;
            this.Tyq = Collections.emptyList();
            this.Tyr = Collections.emptyList();
            AppMethodBeat.o(58577);
        }

        @Override // kotlin.l.b.a.b.h.r
        public final boolean isInitialized() {
            AppMethodBeat.i(58578);
            byte b2 = this.bPe;
            if (b2 == 1) {
                AppMethodBeat.o(58578);
                return true;
            } else if (b2 == 0) {
                AppMethodBeat.o(58578);
                return false;
            } else if (!hFS() || this.Tyo.isInitialized()) {
                for (int i2 = 0; i2 < this.Tyq.size(); i2++) {
                    if (!this.Tyq.get(i2).isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58578);
                        return false;
                    }
                }
                for (int i3 = 0; i3 < this.Tyr.size(); i3++) {
                    if (!this.Tyr.get(i3).isInitialized()) {
                        this.bPe = 0;
                        AppMethodBeat.o(58578);
                        return false;
                    }
                }
                this.bPe = 1;
                AppMethodBeat.o(58578);
                return true;
            } else {
                this.bPe = 0;
                AppMethodBeat.o(58578);
                return false;
            }
        }

        @Override // kotlin.l.b.a.b.h.q
        public final void a(kotlin.l.b.a.b.h.f fVar) {
            AppMethodBeat.i(58579);
            yC();
            if ((this.bOT & 1) == 1) {
                fVar.bs(1, this.Txb);
            }
            if ((this.bOT & 2) == 2) {
                fVar.bs(2, this.Tym);
            }
            if ((this.bOT & 4) == 4) {
                fVar.nb(3, this.Tyn.value);
            }
            if ((this.bOT & 8) == 8) {
                fVar.a(4, this.Tyo);
            }
            if ((this.bOT & 16) == 16) {
                fVar.bs(5, this.Typ);
            }
            for (int i2 = 0; i2 < this.Tyq.size(); i2++) {
                fVar.a(6, this.Tyq.get(i2));
            }
            for (int i3 = 0; i3 < this.Tyr.size(); i3++) {
                fVar.a(7, this.Tyr.get(i3));
            }
            fVar.e(this.TwK);
            AppMethodBeat.o(58579);
        }

        @Override // kotlin.l.b.a.b.h.q
        public final int yC() {
            AppMethodBeat.i(58580);
            int i2 = this.bVY;
            if (i2 != -1) {
                AppMethodBeat.o(58580);
                return i2;
            }
            int bu = (this.bOT & 1) == 1 ? kotlin.l.b.a.b.h.f.bu(1, this.Txb) + 0 : 0;
            if ((this.bOT & 2) == 2) {
                bu += kotlin.l.b.a.b.h.f.bu(2, this.Tym);
            }
            if ((this.bOT & 4) == 4) {
                bu += kotlin.l.b.a.b.h.f.bv(3, this.Tyn.value);
            }
            if ((this.bOT & 8) == 8) {
                bu += kotlin.l.b.a.b.h.f.c(4, this.Tyo);
            }
            if ((this.bOT & 16) == 16) {
                bu += kotlin.l.b.a.b.h.f.bu(5, this.Typ);
            }
            int i3 = bu;
            for (int i4 = 0; i4 < this.Tyq.size(); i4++) {
                i3 += kotlin.l.b.a.b.h.f.c(6, this.Tyq.get(i4));
            }
            for (int i5 = 0; i5 < this.Tyr.size(); i5++) {
                i3 += kotlin.l.b.a.b.h.f.c(7, this.Tyr.get(i5));
            }
            int size = this.TwK.size() + i3;
            this.bVY = size;
            AppMethodBeat.o(58580);
            return size;
        }

        /* renamed from: kotlin.l.b.a.b.e.a$g$a  reason: collision with other inner class name */
        public static final class C2311a extends i.a<g, C2311a> implements j {
            private int Txb;
            private int Tym;
            private b Tyn = b.TRUE;
            private p Tyo = p.hGS();
            private int Typ;
            private List<g> Tyq = Collections.emptyList();
            private List<g> Tyr = Collections.emptyList();
            private int bOT;

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [kotlin.l.b.a.b.h.i] */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2311a a(g gVar) {
                AppMethodBeat.i(58563);
                C2311a f2 = f(gVar);
                AppMethodBeat.o(58563);
                return f2;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a
            public final /* synthetic */ a.AbstractC2337a c(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58565);
                C2311a l = l(eVar, gVar);
                AppMethodBeat.o(58565);
                return l;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a, java.lang.Object
            public final /* synthetic */ Object clone() {
                AppMethodBeat.i(58570);
                C2311a hFU = hFU();
                AppMethodBeat.o(58570);
                return hFU;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ q.a d(kotlin.l.b.a.b.h.e eVar, kotlin.l.b.a.b.h.g gVar) {
                AppMethodBeat.i(58567);
                C2311a l = l(eVar, gVar);
                AppMethodBeat.o(58567);
                return l;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i$a' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ C2311a hEE() {
                AppMethodBeat.i(58564);
                C2311a hFU = hFU();
                AppMethodBeat.o(58564);
                return hFU;
            }

            @Override // kotlin.l.b.a.b.h.a.AbstractC2337a, kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ a.AbstractC2337a hEF() {
                AppMethodBeat.i(58566);
                C2311a hFU = hFU();
                AppMethodBeat.o(58566);
                return hFU;
            }

            private C2311a() {
                AppMethodBeat.i(58552);
                AppMethodBeat.o(58552);
            }

            public final g hFV() {
                int i2 = 1;
                AppMethodBeat.i(58554);
                g gVar = new g(this, (byte) 0);
                int i3 = this.bOT;
                if ((i3 & 1) != 1) {
                    i2 = 0;
                }
                gVar.Txb = this.Txb;
                if ((i3 & 2) == 2) {
                    i2 |= 2;
                }
                gVar.Tym = this.Tym;
                if ((i3 & 4) == 4) {
                    i2 |= 4;
                }
                gVar.Tyn = this.Tyn;
                if ((i3 & 8) == 8) {
                    i2 |= 8;
                }
                gVar.Tyo = this.Tyo;
                if ((i3 & 16) == 16) {
                    i2 |= 16;
                }
                gVar.Typ = this.Typ;
                if ((this.bOT & 32) == 32) {
                    this.Tyq = Collections.unmodifiableList(this.Tyq);
                    this.bOT &= -33;
                }
                gVar.Tyq = this.Tyq;
                if ((this.bOT & 64) == 64) {
                    this.Tyr = Collections.unmodifiableList(this.Tyr);
                    this.bOT &= -65;
                }
                gVar.Tyr = this.Tyr;
                gVar.bOT = i2;
                AppMethodBeat.o(58554);
                return gVar;
            }

            public final C2311a f(g gVar) {
                AppMethodBeat.i(58555);
                if (gVar == g.hFP()) {
                    AppMethodBeat.o(58555);
                } else {
                    if (gVar.hEP()) {
                        auk(gVar.Txb);
                    }
                    if (gVar.hFQ()) {
                        aul(gVar.Tym);
                    }
                    if (gVar.hFR()) {
                        a(gVar.Tyn);
                    }
                    if (gVar.hFS()) {
                        a(gVar.Tyo);
                    }
                    if (gVar.hFT()) {
                        aum(gVar.Typ);
                    }
                    if (!gVar.Tyq.isEmpty()) {
                        if (this.Tyq.isEmpty()) {
                            this.Tyq = gVar.Tyq;
                            this.bOT &= -33;
                        } else {
                            hFW();
                            this.Tyq.addAll(gVar.Tyq);
                        }
                    }
                    if (!gVar.Tyr.isEmpty()) {
                        if (this.Tyr.isEmpty()) {
                            this.Tyr = gVar.Tyr;
                            this.bOT &= -65;
                        } else {
                            hFX();
                            this.Tyr.addAll(gVar.Tyr);
                        }
                    }
                    this.TwK = this.TwK.a(gVar.TwK);
                    AppMethodBeat.o(58555);
                }
                return this;
            }

            /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private kotlin.l.b.a.b.e.a.g.C2311a l(kotlin.l.b.a.b.h.e r5, kotlin.l.b.a.b.h.g r6) {
                /*
                    r4 = this;
                    r3 = 58557(0xe4bd, float:8.2056E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    r2 = 0
                    kotlin.l.b.a.b.h.s<kotlin.l.b.a.b.e.a$g> r0 = kotlin.l.b.a.b.e.a.g.TwL     // Catch:{ k -> 0x0016 }
                    java.lang.Object r0 = r0.a(r5, r6)     // Catch:{ k -> 0x0016 }
                    kotlin.l.b.a.b.e.a$g r0 = (kotlin.l.b.a.b.e.a.g) r0     // Catch:{ k -> 0x0016 }
                    r4.f(r0)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return r4
                L_0x0016:
                    r0 = move-exception
                    r1 = r0
                    kotlin.l.b.a.b.h.q r0 = r1.TDK     // Catch:{ all -> 0x002e }
                    kotlin.l.b.a.b.e.a$g r0 = (kotlin.l.b.a.b.e.a.g) r0     // Catch:{ all -> 0x002e }
                    r2 = 58557(0xe4bd, float:8.2056E-41)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)     // Catch:{ all -> 0x0023 }
                    throw r1     // Catch:{ all -> 0x0023 }
                L_0x0023:
                    r1 = move-exception
                    r2 = r0
                L_0x0025:
                    if (r2 == 0) goto L_0x002a
                    r4.f(r2)
                L_0x002a:
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    throw r1
                L_0x002e:
                    r0 = move-exception
                    r1 = r0
                    goto L_0x0025
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.e.a.g.C2311a.l(kotlin.l.b.a.b.h.e, kotlin.l.b.a.b.h.g):kotlin.l.b.a.b.e.a$g$a");
            }

            private C2311a auk(int i2) {
                this.bOT |= 1;
                this.Txb = i2;
                return this;
            }

            private C2311a aul(int i2) {
                this.bOT |= 2;
                this.Tym = i2;
                return this;
            }

            private C2311a a(b bVar) {
                AppMethodBeat.i(58558);
                if (bVar == null) {
                    NullPointerException nullPointerException = new NullPointerException();
                    AppMethodBeat.o(58558);
                    throw nullPointerException;
                }
                this.bOT |= 4;
                this.Tyn = bVar;
                AppMethodBeat.o(58558);
                return this;
            }

            private C2311a a(p pVar) {
                AppMethodBeat.i(58559);
                if ((this.bOT & 8) != 8 || this.Tyo == p.hGS()) {
                    this.Tyo = pVar;
                } else {
                    this.Tyo = p.f(this.Tyo).j(pVar).hHo();
                }
                this.bOT |= 8;
                AppMethodBeat.o(58559);
                return this;
            }

            private C2311a aum(int i2) {
                this.bOT |= 16;
                this.Typ = i2;
                return this;
            }

            private void hFW() {
                AppMethodBeat.i(58560);
                if ((this.bOT & 32) != 32) {
                    this.Tyq = new ArrayList(this.Tyq);
                    this.bOT |= 32;
                }
                AppMethodBeat.o(58560);
            }

            private void hFX() {
                AppMethodBeat.i(58561);
                if ((this.bOT & 64) != 64) {
                    this.Tyr = new ArrayList(this.Tyr);
                    this.bOT |= 64;
                }
                AppMethodBeat.o(58561);
            }

            private C2311a hFU() {
                AppMethodBeat.i(58553);
                C2311a f2 = new C2311a().f(hFV());
                AppMethodBeat.o(58553);
                return f2;
            }

            @Override // kotlin.l.b.a.b.h.r
            public final boolean isInitialized() {
                AppMethodBeat.i(58556);
                if (!((this.bOT & 8) == 8) || this.Tyo.isInitialized()) {
                    for (int i2 = 0; i2 < this.Tyq.size(); i2++) {
                        if (!this.Tyq.get(i2).isInitialized()) {
                            AppMethodBeat.o(58556);
                            return false;
                        }
                    }
                    for (int i3 = 0; i3 < this.Tyr.size(); i3++) {
                        if (!this.Tyr.get(i3).isInitialized()) {
                            AppMethodBeat.o(58556);
                            return false;
                        }
                    }
                    AppMethodBeat.o(58556);
                    return true;
                }
                AppMethodBeat.o(58556);
                return false;
            }

            /* Return type fixed from 'kotlin.l.b.a.b.h.i' to match base method */
            @Override // kotlin.l.b.a.b.h.i.a
            public final /* synthetic */ g hED() {
                AppMethodBeat.i(58562);
                g hFP = g.hFP();
                AppMethodBeat.o(58562);
                return hFP;
            }

            @Override // kotlin.l.b.a.b.h.q.a
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEG() {
                AppMethodBeat.i(58568);
                g hFV = hFV();
                if (!hFV.isInitialized()) {
                    kotlin.l.b.a.b.h.w wVar = new kotlin.l.b.a.b.h.w();
                    AppMethodBeat.o(58568);
                    throw wVar;
                }
                AppMethodBeat.o(58568);
                return hFV;
            }

            @Override // kotlin.l.b.a.b.h.i.a, kotlin.l.b.a.b.h.r
            public final /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
                AppMethodBeat.i(58569);
                g hFP = g.hFP();
                AppMethodBeat.o(58569);
                return hFP;
            }

            static /* synthetic */ C2311a hFY() {
                AppMethodBeat.i(58571);
                C2311a aVar = new C2311a();
                AppMethodBeat.o(58571);
                return aVar;
            }
        }

        public static C2311a b(g gVar) {
            AppMethodBeat.i(58581);
            C2311a f2 = C2311a.hFY().f(gVar);
            AppMethodBeat.o(58581);
            return f2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEw() {
            AppMethodBeat.i(58582);
            C2311a f2 = C2311a.hFY().f(this);
            AppMethodBeat.o(58582);
            return f2;
        }

        @Override // kotlin.l.b.a.b.h.q
        public final /* synthetic */ q.a hEx() {
            AppMethodBeat.i(58583);
            C2311a hFY = C2311a.hFY();
            AppMethodBeat.o(58583);
            return hFY;
        }

        @Override // kotlin.l.b.a.b.h.r
        public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.h.q hEy() {
            return Tyl;
        }
    }
}
