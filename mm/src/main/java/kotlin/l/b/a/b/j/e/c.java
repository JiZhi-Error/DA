package kotlin.l.b.a.b.j.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.f.b;

public final class c {
    private b TiI;
    public final String TvL;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(60174);
        switch (i2) {
            case 3:
            case 6:
            case 7:
            case 8:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 4:
            case 5:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 3:
            case 6:
            case 7:
            case 8:
                i3 = 2;
                break;
            case 4:
            case 5:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "classId";
                break;
            case 2:
            case 4:
                objArr[0] = "fqName";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
                break;
            case 5:
            default:
                objArr[0] = "internalName";
                break;
        }
        switch (i2) {
            case 3:
                objArr[1] = "byFqNameWithoutInnerClasses";
                break;
            case 4:
            case 5:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmClassName";
                break;
            case 6:
                objArr[1] = "getFqNameForClassNameWithoutDollars";
                break;
            case 7:
                objArr[1] = "getPackageFqName";
                break;
            case 8:
                objArr[1] = "getInternalName";
                break;
        }
        switch (i2) {
            case 1:
                objArr[2] = "byClassId";
                break;
            case 2:
            case 4:
                objArr[2] = "byFqNameWithoutInnerClasses";
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                break;
            case 5:
                objArr[2] = "<init>";
                break;
            default:
                objArr[2] = "byInternalName";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 3:
            case 6:
            case 7:
            case 8:
                illegalStateException = new IllegalStateException(format);
                break;
            case 4:
            case 5:
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(60174);
        throw illegalStateException;
    }

    public static c buj(String str) {
        AppMethodBeat.i(60165);
        if (str == null) {
            atM(0);
        }
        c cVar = new c(str);
        AppMethodBeat.o(60165);
        return cVar;
    }

    public static c e(a aVar) {
        AppMethodBeat.i(60166);
        if (aVar == null) {
            atM(1);
        }
        b hIY = aVar.hIY();
        String replace = aVar.hIZ().sG().replace('.', '$');
        if (hIY.isRoot()) {
            c cVar = new c(replace);
            AppMethodBeat.o(60166);
            return cVar;
        }
        c cVar2 = new c(hIY.sG().replace('.', '/') + FilePathGenerator.ANDROID_DIR_SEP + replace);
        AppMethodBeat.o(60166);
        return cVar2;
    }

    public static c q(b bVar) {
        AppMethodBeat.i(60167);
        if (bVar == null) {
            atM(2);
        }
        c cVar = new c(bVar.sG().replace('.', '/'));
        cVar.TiI = bVar;
        AppMethodBeat.o(60167);
        return cVar;
    }

    private c(String str) {
        if (str == null) {
            atM(5);
        }
        AppMethodBeat.i(60168);
        this.TvL = str;
        AppMethodBeat.o(60168);
    }

    public final b hIY() {
        AppMethodBeat.i(60170);
        int lastIndexOf = this.TvL.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP);
        if (lastIndexOf == -1) {
            b bVar = b.TCQ;
            if (bVar == null) {
                atM(7);
            }
            AppMethodBeat.o(60170);
            return bVar;
        }
        b bVar2 = new b(this.TvL.substring(0, lastIndexOf).replace('/', '.'));
        AppMethodBeat.o(60170);
        return bVar2;
    }

    public final String hKI() {
        AppMethodBeat.i(60171);
        String str = this.TvL;
        if (str == null) {
            atM(8);
        }
        AppMethodBeat.o(60171);
        return str;
    }

    public final String toString() {
        return this.TvL;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(60172);
        if (this == obj) {
            AppMethodBeat.o(60172);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(60172);
            return false;
        } else {
            boolean equals = this.TvL.equals(((c) obj).TvL);
            AppMethodBeat.o(60172);
            return equals;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(60173);
        int hashCode = this.TvL.hashCode();
        AppMethodBeat.o(60173);
        return hashCode;
    }
}
