package kotlin.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public static final b TCQ = new b("");
    public final c TCR;
    private transient b TCS;

    public static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(59296);
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 8:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                i3 = 2;
                break;
            case 8:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "fqName";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 12:
                objArr[0] = "segment";
                break;
            case 13:
                objArr[0] = "shortName";
                break;
            default:
                objArr[0] = "names";
                break;
        }
        switch (i2) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
                objArr[1] = "toUnsafe";
                break;
            case 6:
            case 7:
                objArr[1] = "parent";
                break;
            case 8:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 9:
                objArr[1] = "shortName";
                break;
            case 10:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 11:
                objArr[1] = "pathSegments";
                break;
        }
        switch (i2) {
            case 1:
            case 2:
            case 3:
                objArr[2] = "<init>";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                break;
            case 8:
                objArr[2] = "child";
                break;
            case 12:
                objArr[2] = "startsWith";
                break;
            case 13:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "fromSegments";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                illegalStateException = new IllegalStateException(format);
                break;
            case 8:
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(59296);
        throw illegalStateException;
    }

    static {
        AppMethodBeat.i(59295);
        AppMethodBeat.o(59295);
    }

    public b(String str) {
        if (str == null) {
            atM(1);
        }
        AppMethodBeat.i(59280);
        this.TCR = new c(str, this);
        AppMethodBeat.o(59280);
    }

    public b(c cVar) {
        if (cVar == null) {
            atM(2);
        }
        AppMethodBeat.i(59281);
        this.TCR = cVar;
        AppMethodBeat.o(59281);
    }

    private b(c cVar, b bVar) {
        if (cVar == null) {
            atM(3);
        }
        AppMethodBeat.i(59282);
        this.TCR = cVar;
        this.TCS = bVar;
        AppMethodBeat.o(59282);
    }

    public final String sG() {
        AppMethodBeat.i(59283);
        String sG = this.TCR.sG();
        if (sG == null) {
            atM(4);
        }
        AppMethodBeat.o(59283);
        return sG;
    }

    public final c hJe() {
        AppMethodBeat.i(59284);
        c cVar = this.TCR;
        if (cVar == null) {
            atM(5);
        }
        AppMethodBeat.o(59284);
        return cVar;
    }

    public final boolean isRoot() {
        AppMethodBeat.i(258557);
        boolean isEmpty = this.TCR.TCW.isEmpty();
        AppMethodBeat.o(258557);
        return isEmpty;
    }

    public final b hJf() {
        b bVar;
        AppMethodBeat.i(59286);
        if (this.TCS != null) {
            bVar = this.TCS;
            if (bVar == null) {
                atM(6);
            }
            AppMethodBeat.o(59286);
        } else if (isRoot()) {
            IllegalStateException illegalStateException = new IllegalStateException("root");
            AppMethodBeat.o(59286);
            throw illegalStateException;
        } else {
            this.TCS = new b(this.TCR.hJk());
            bVar = this.TCS;
            if (bVar == null) {
                atM(7);
            }
            AppMethodBeat.o(59286);
        }
        return bVar;
    }

    public final b p(f fVar) {
        AppMethodBeat.i(59287);
        if (fVar == null) {
            atM(8);
        }
        b bVar = new b(this.TCR.s(fVar), this);
        AppMethodBeat.o(59287);
        return bVar;
    }

    public final f hJg() {
        AppMethodBeat.i(59288);
        f hJg = this.TCR.hJg();
        if (hJg == null) {
            atM(9);
        }
        AppMethodBeat.o(59288);
        return hJg;
    }

    public final f hJh() {
        AppMethodBeat.i(59289);
        f hJh = this.TCR.hJh();
        if (hJh == null) {
            atM(10);
        }
        AppMethodBeat.o(59289);
        return hJh;
    }

    public final boolean q(f fVar) {
        AppMethodBeat.i(59290);
        if (fVar == null) {
            atM(12);
        }
        boolean q = this.TCR.q(fVar);
        AppMethodBeat.o(59290);
        return q;
    }

    public static b r(f fVar) {
        AppMethodBeat.i(59291);
        if (fVar == null) {
            atM(13);
        }
        b bVar = new b(c.t(fVar));
        AppMethodBeat.o(59291);
        return bVar;
    }

    public final String toString() {
        AppMethodBeat.i(59292);
        String cVar = this.TCR.toString();
        AppMethodBeat.o(59292);
        return cVar;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(59293);
        if (this == obj) {
            AppMethodBeat.o(59293);
            return true;
        } else if (!(obj instanceof b)) {
            AppMethodBeat.o(59293);
            return false;
        } else if (!this.TCR.equals(((b) obj).TCR)) {
            AppMethodBeat.o(59293);
            return false;
        } else {
            AppMethodBeat.o(59293);
            return true;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(59294);
        int hashCode = this.TCR.hashCode();
        AppMethodBeat.o(59294);
        return hashCode;
    }
}
