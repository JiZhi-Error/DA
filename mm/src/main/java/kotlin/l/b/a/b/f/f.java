package kotlin.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f implements Comparable<f> {
    public final boolean TDa;
    private final String name;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(59331);
        switch (i2) {
            case 1:
            case 2:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 1:
            case 2:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 2:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
                break;
            default:
                objArr[0] = "name";
                break;
        }
        switch (i2) {
            case 1:
                objArr[1] = "asString";
                break;
            case 2:
                objArr[1] = "getIdentifier";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
                break;
        }
        switch (i2) {
            case 1:
            case 2:
                break;
            case 3:
                objArr[2] = "identifier";
                break;
            case 4:
                objArr[2] = "isValidIdentifier";
                break;
            case 5:
                objArr[2] = "special";
                break;
            case 6:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 1:
            case 2:
                illegalStateException = new IllegalStateException(format);
                break;
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(59331);
        throw illegalStateException;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(f fVar) {
        AppMethodBeat.i(59330);
        int u = u(fVar);
        AppMethodBeat.o(59330);
        return u;
    }

    private f(String str, boolean z) {
        if (str == null) {
            atM(0);
        }
        AppMethodBeat.i(59320);
        this.name = str;
        this.TDa = z;
        AppMethodBeat.o(59320);
    }

    public final String sG() {
        AppMethodBeat.i(59321);
        String str = this.name;
        if (str == null) {
            atM(1);
        }
        AppMethodBeat.o(59321);
        return str;
    }

    public final String getIdentifier() {
        AppMethodBeat.i(59322);
        if (this.TDa) {
            IllegalStateException illegalStateException = new IllegalStateException("not identifier: ".concat(String.valueOf(this)));
            AppMethodBeat.o(59322);
            throw illegalStateException;
        }
        String sG = sG();
        if (sG == null) {
            atM(2);
        }
        AppMethodBeat.o(59322);
        return sG;
    }

    public final int u(f fVar) {
        AppMethodBeat.i(59323);
        int compareTo = this.name.compareTo(fVar.name);
        AppMethodBeat.o(59323);
        return compareTo;
    }

    public static f btY(String str) {
        AppMethodBeat.i(59324);
        if (str == null) {
            atM(3);
        }
        f fVar = new f(str, false);
        AppMethodBeat.o(59324);
        return fVar;
    }

    public static boolean btZ(String str) {
        AppMethodBeat.i(59325);
        if (str == null) {
            atM(4);
        }
        if (str.isEmpty() || str.startsWith("<")) {
            AppMethodBeat.o(59325);
            return false;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '.' || charAt == '/' || charAt == '\\') {
                AppMethodBeat.o(59325);
                return false;
            }
        }
        AppMethodBeat.o(59325);
        return true;
    }

    public static f bua(String str) {
        AppMethodBeat.i(59326);
        if (str == null) {
            atM(5);
        }
        if (!str.startsWith("<")) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("special name must start with '<': ".concat(String.valueOf(str)));
            AppMethodBeat.o(59326);
            throw illegalArgumentException;
        }
        f fVar = new f(str, true);
        AppMethodBeat.o(59326);
        return fVar;
    }

    public static f bub(String str) {
        AppMethodBeat.i(59327);
        if (str == null) {
            atM(6);
        }
        if (str.startsWith("<")) {
            f bua = bua(str);
            AppMethodBeat.o(59327);
            return bua;
        }
        f btY = btY(str);
        AppMethodBeat.o(59327);
        return btY;
    }

    public final String toString() {
        return this.name;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(59328);
        if (this == obj) {
            AppMethodBeat.o(59328);
            return true;
        } else if (!(obj instanceof f)) {
            AppMethodBeat.o(59328);
            return false;
        } else {
            f fVar = (f) obj;
            if (this.TDa != fVar.TDa) {
                AppMethodBeat.o(59328);
                return false;
            } else if (!this.name.equals(fVar.name)) {
                AppMethodBeat.o(59328);
                return false;
            } else {
                AppMethodBeat.o(59328);
                return true;
            }
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(59329);
        int hashCode = (this.TDa ? 1 : 0) + (this.name.hashCode() * 31);
        AppMethodBeat.o(59329);
        return hashCode;
    }
}
