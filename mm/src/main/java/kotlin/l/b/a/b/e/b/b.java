package kotlin.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.h.j;

public final class b {
    public static final a TAT = c.hIk();
    public static final a TAU;
    public static final c<a.w> TAV;
    public static final c<a.j> TAW;
    public static final c<a.b.EnumC2306b> TAY;
    public static final a TAZ;
    public static final a TBA;
    public static final a TBB;
    public static final a TBC;
    public static final a TBD;
    public static final a TBE = c.hIk();
    public static final a TBa;
    public static final a TBb;
    public static final a TBc;
    public static final a TBd;
    public static final a TBe = c.a(TAV);
    public static final c<a.i> TBf;
    public static final a TBg;
    public static final a TBh;
    public static final a TBi;
    public static final a TBj;
    public static final a TBk;
    public static final a TBl;
    public static final a TBm;
    public static final a TBn;
    public static final a TBo;
    public static final a TBp;
    public static final a TBq;
    public static final a TBr;
    public static final a TBs;
    public static final a TBt;
    public static final a TBu;
    public static final a TBv;
    public static final a TBw;
    public static final a TBx;
    public static final a TBy;
    public static final a TBz;

    private static /* synthetic */ void atM(int i2) {
        AppMethodBeat.i(59062);
        Object[] objArr = new Object[3];
        switch (i2) {
            case 1:
            case 5:
            case 8:
            case 11:
                objArr[0] = "modality";
                break;
            case 2:
                objArr[0] = "kind";
                break;
            case 3:
            case 4:
            case 7:
            case 10:
            default:
                objArr[0] = "visibility";
                break;
            case 6:
            case 9:
                objArr[0] = "memberKind";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags";
        switch (i2) {
            case 3:
                objArr[2] = "getConstructorFlags";
                break;
            case 4:
            case 5:
            case 6:
                objArr[2] = "getFunctionFlags";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "getPropertyFlags";
                break;
            case 10:
            case 11:
                objArr[2] = "getAccessorFlags";
                break;
            default:
                objArr[2] = "getClassFlags";
                break;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        AppMethodBeat.o(59062);
        throw illegalArgumentException;
    }

    static {
        AppMethodBeat.i(59061);
        a hIk = c.hIk();
        TAU = hIk;
        c<a.w> a2 = c.a(hIk, a.w.values());
        TAV = a2;
        c<a.j> a3 = c.a(a2, a.j.values());
        TAW = a3;
        c<a.b.EnumC2306b> a4 = c.a(a3, a.b.EnumC2306b.values());
        TAY = a4;
        a a5 = c.a(a4);
        TAZ = a5;
        a a6 = c.a(a5);
        TBa = a6;
        a a7 = c.a(a6);
        TBb = a7;
        a a8 = c.a(a7);
        TBc = a8;
        TBd = c.a(a8);
        c<a.i> a9 = c.a(TAW, a.i.values());
        TBf = a9;
        a a10 = c.a(a9);
        TBg = a10;
        a a11 = c.a(a10);
        TBh = a11;
        a a12 = c.a(a11);
        TBi = a12;
        a a13 = c.a(a12);
        TBj = a13;
        a a14 = c.a(a13);
        TBk = a14;
        a a15 = c.a(a14);
        TBl = a15;
        TBm = c.a(a15);
        a a16 = c.a(TBf);
        TBn = a16;
        a a17 = c.a(a16);
        TBo = a17;
        a a18 = c.a(a17);
        TBp = a18;
        a a19 = c.a(a18);
        TBq = a19;
        a a20 = c.a(a19);
        TBr = a20;
        a a21 = c.a(a20);
        TBs = a21;
        a a22 = c.a(a21);
        TBt = a22;
        a a23 = c.a(a22);
        TBu = a23;
        TBv = c.a(a23);
        a a24 = c.a(TAU);
        TBw = a24;
        a a25 = c.a(a24);
        TBx = a25;
        TBy = c.a(a25);
        a a26 = c.a(TAW);
        TBz = a26;
        a a27 = c.a(a26);
        TBA = a27;
        TBB = c.a(a27);
        a hIk2 = c.hIk();
        TBC = hIk2;
        TBD = c.a(hIk2);
        AppMethodBeat.o(59061);
    }

    public static int a(boolean z, a.w wVar, a.j jVar) {
        AppMethodBeat.i(59060);
        if (wVar == null) {
            atM(10);
        }
        if (jVar == null) {
            atM(11);
        }
        int x = TAU.x(Boolean.valueOf(z)) | TAW.fv(jVar) | TAV.fv(wVar) | TBz.x(Boolean.FALSE) | TBA.x(Boolean.FALSE) | TBB.x(Boolean.FALSE);
        AppMethodBeat.o(59060);
        return x;
    }

    public static abstract class c<E> {
        public final int TBG;
        public final int offset;

        public abstract int fv(E e2);

        public abstract E get(int i2);

        /* synthetic */ c(int i2, int i3, byte b2) {
            this(i2, i3);
        }

        public static <E extends j.a> c<E> a(c<?> cVar, E[] eArr) {
            return new C2329b(cVar.offset + cVar.TBG, eArr);
        }

        public static a hIk() {
            return new a(0);
        }

        public static a a(c<?> cVar) {
            return new a(cVar.offset + cVar.TBG);
        }

        private c(int i2, int i3) {
            this.offset = i2;
            this.TBG = i3;
        }
    }

    public static class a extends c<Boolean> {
        private static /* synthetic */ void hIj() {
            AppMethodBeat.i(59055);
            IllegalStateException illegalStateException = new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$BooleanFlagField", "get"));
            AppMethodBeat.o(59055);
            throw illegalStateException;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.l.b.a.b.e.b.b.c
        public final /* synthetic */ int fv(Boolean bool) {
            AppMethodBeat.i(59053);
            int x = x(bool);
            AppMethodBeat.o(59053);
            return x;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.l.b.a.b.e.b.b.c
        public final /* synthetic */ Boolean get(int i2) {
            AppMethodBeat.i(59054);
            Boolean avk = avk(i2);
            AppMethodBeat.o(59054);
            return avk;
        }

        public a(int i2) {
            super(i2, 1, (byte) 0);
        }

        public final Boolean avk(int i2) {
            boolean z = true;
            AppMethodBeat.i(59051);
            if (((1 << this.offset) & i2) == 0) {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            if (valueOf == null) {
                hIj();
            }
            AppMethodBeat.o(59051);
            return valueOf;
        }

        public final int x(Boolean bool) {
            AppMethodBeat.i(59052);
            if (bool.booleanValue()) {
                int i2 = 1 << this.offset;
                AppMethodBeat.o(59052);
                return i2;
            }
            AppMethodBeat.o(59052);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: kotlin.l.b.a.b.e.b.b$b  reason: collision with other inner class name */
    public static class C2329b<E extends j.a> extends c<E> {
        private final E[] TBF;

        @Override // kotlin.l.b.a.b.e.b.b.c
        public final /* synthetic */ int fv(Object obj) {
            AppMethodBeat.i(59058);
            int number = ((j.a) obj).getNumber() << this.offset;
            AppMethodBeat.o(59058);
            return number;
        }

        public C2329b(int i2, E[] eArr) {
            super(i2, ai(eArr), (byte) 0);
            AppMethodBeat.i(59056);
            this.TBF = eArr;
            AppMethodBeat.o(59056);
        }

        private static <E> int ai(E[] eArr) {
            AppMethodBeat.i(59057);
            if (eArr == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"));
                AppMethodBeat.o(59057);
                throw illegalArgumentException;
            }
            int length = eArr.length - 1;
            if (length == 0) {
                AppMethodBeat.o(59057);
                return 1;
            }
            for (int i2 = 31; i2 >= 0; i2--) {
                if (((1 << i2) & length) != 0) {
                    int i3 = i2 + 1;
                    AppMethodBeat.o(59057);
                    return i3;
                }
            }
            IllegalStateException illegalStateException = new IllegalStateException("Empty enum: " + eArr.getClass());
            AppMethodBeat.o(59057);
            throw illegalStateException;
        }

        @Override // kotlin.l.b.a.b.e.b.b.c
        public final /* synthetic */ Object get(int i2) {
            AppMethodBeat.i(59059);
            int i3 = ((((1 << this.TBG) - 1) << this.offset) & i2) >> this.offset;
            E[] eArr = this.TBF;
            for (E e2 : eArr) {
                if (e2.getNumber() == i3) {
                    AppMethodBeat.o(59059);
                    return e2;
                }
            }
            AppMethodBeat.o(59059);
            return null;
        }
    }
}
