package kotlin.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import kotlin.n.n;

public final class a {
    static final /* synthetic */ boolean $assertionsDisabled = (!a.class.desiredAssertionStatus());
    public final boolean BPb;
    private final b TCO;
    private final b TfF;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(59279);
        switch (i2) {
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 8:
            case 10:
            case 11:
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                i3 = 2;
                break;
            case 8:
            case 10:
            case 11:
            case 12:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 3:
                objArr[0] = "packageFqName";
                break;
            case 2:
                objArr[0] = "relativeClassName";
                break;
            case 4:
                objArr[0] = "topLevelName";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 10:
                objArr[0] = "segment";
                break;
            case 11:
            case 12:
                objArr[0] = "string";
                break;
            default:
                objArr[0] = "topLevelFqName";
                break;
        }
        switch (i2) {
            case 5:
                objArr[1] = "getPackageFqName";
                break;
            case 6:
                objArr[1] = "getRelativeClassName";
                break;
            case 7:
                objArr[1] = "getShortClassName";
                break;
            case 8:
            case 10:
            case 11:
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/ClassId";
                break;
            case 9:
                objArr[1] = "asSingleFqName";
                break;
            case 13:
            case 14:
                objArr[1] = "asString";
                break;
        }
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
                objArr[2] = "<init>";
                break;
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                break;
            case 8:
                objArr[2] = "createNestedClassId";
                break;
            case 10:
                objArr[2] = "startsWith";
                break;
            case 11:
            case 12:
                objArr[2] = "fromString";
                break;
            default:
                objArr[2] = "topLevel";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 5:
            case 6:
            case 7:
            case 9:
            case 13:
            case 14:
                illegalStateException = new IllegalStateException(format);
                break;
            case 8:
            case 10:
            case 11:
            case 12:
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(59279);
        throw illegalStateException;
    }

    static {
        AppMethodBeat.i(59278);
        AppMethodBeat.o(59278);
    }

    public static a p(b bVar) {
        AppMethodBeat.i(59262);
        if (bVar == null) {
            atM(0);
        }
        a aVar = new a(bVar.hJf(), bVar.hJg());
        AppMethodBeat.o(59262);
        return aVar;
    }

    public a(b bVar, b bVar2, boolean z) {
        if (bVar == null) {
            atM(1);
        }
        if (bVar2 == null) {
            atM(2);
        }
        AppMethodBeat.i(59263);
        this.TfF = bVar;
        if ($assertionsDisabled || !bVar2.TCR.TCW.isEmpty()) {
            this.TCO = bVar2;
            this.BPb = z;
            AppMethodBeat.o(59263);
            return;
        }
        AssertionError assertionError = new AssertionError("Class name must not be root: " + bVar + (z ? " (local)" : ""));
        AppMethodBeat.o(59263);
        throw assertionError;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public a(b bVar, f fVar) {
        this(bVar, b.r(fVar), false);
        if (bVar == null) {
            atM(3);
        }
        if (fVar == null) {
            atM(4);
        }
        AppMethodBeat.i(59264);
        AppMethodBeat.o(59264);
    }

    public final b hIY() {
        AppMethodBeat.i(59265);
        b bVar = this.TfF;
        if (bVar == null) {
            atM(5);
        }
        AppMethodBeat.o(59265);
        return bVar;
    }

    public final b hIZ() {
        AppMethodBeat.i(59266);
        b bVar = this.TCO;
        if (bVar == null) {
            atM(6);
        }
        AppMethodBeat.o(59266);
        return bVar;
    }

    public final f hJa() {
        AppMethodBeat.i(59267);
        f hJg = this.TCO.hJg();
        if (hJg == null) {
            atM(7);
        }
        AppMethodBeat.o(59267);
        return hJg;
    }

    public final a o(f fVar) {
        AppMethodBeat.i(59268);
        if (fVar == null) {
            atM(8);
        }
        a aVar = new a(hIY(), this.TCO.p(fVar), this.BPb);
        AppMethodBeat.o(59268);
        return aVar;
    }

    public final a hJb() {
        AppMethodBeat.i(59269);
        b hJf = this.TCO.hJf();
        if (hJf.TCR.TCW.isEmpty()) {
            AppMethodBeat.o(59269);
            return null;
        }
        a aVar = new a(hIY(), hJf, this.BPb);
        AppMethodBeat.o(59269);
        return aVar;
    }

    public final boolean hJc() {
        AppMethodBeat.i(59270);
        if (!this.TCO.hJf().TCR.TCW.isEmpty()) {
            AppMethodBeat.o(59270);
            return true;
        }
        AppMethodBeat.o(59270);
        return false;
    }

    public final b hJd() {
        AppMethodBeat.i(59271);
        if (this.TfF.TCR.TCW.isEmpty()) {
            b bVar = this.TCO;
            if (bVar == null) {
                atM(9);
            }
            AppMethodBeat.o(59271);
            return bVar;
        }
        b bVar2 = new b(this.TfF.sG() + "." + this.TCO.sG());
        AppMethodBeat.o(59271);
        return bVar2;
    }

    public static a btX(String str) {
        AppMethodBeat.i(59272);
        a dT = dT(str, false);
        AppMethodBeat.o(59272);
        return dT;
    }

    public static a dT(String str, boolean z) {
        AppMethodBeat.i(59273);
        if (str == null) {
            atM(12);
        }
        a aVar = new a(new b(n.oC(str, "").replace('/', '.')), new b(n.b(str, '/', str)), z);
        AppMethodBeat.o(59273);
        return aVar;
    }

    public final String sG() {
        String str;
        AppMethodBeat.i(59274);
        if (this.TfF.TCR.TCW.isEmpty()) {
            str = this.TCO.sG();
            if (str == null) {
                atM(13);
            }
            AppMethodBeat.o(59274);
        } else {
            str = this.TfF.sG().replace('.', '/') + FilePathGenerator.ANDROID_DIR_SEP + this.TCO.sG();
            if (str == null) {
                atM(14);
            }
            AppMethodBeat.o(59274);
        }
        return str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(59275);
        if (this == obj) {
            AppMethodBeat.o(59275);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(59275);
            return false;
        } else {
            a aVar = (a) obj;
            if (!this.TfF.equals(aVar.TfF) || !this.TCO.equals(aVar.TCO) || this.BPb != aVar.BPb) {
                AppMethodBeat.o(59275);
                return false;
            }
            AppMethodBeat.o(59275);
            return true;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(59276);
        int hashCode = (((this.TfF.hashCode() * 31) + this.TCO.hashCode()) * 31) + Boolean.valueOf(this.BPb).hashCode();
        AppMethodBeat.o(59276);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(59277);
        if (this.TfF.TCR.TCW.isEmpty()) {
            String str = FilePathGenerator.ANDROID_DIR_SEP + sG();
            AppMethodBeat.o(59277);
            return str;
        }
        String sG = sG();
        AppMethodBeat.o(59277);
        return sG;
    }
}
