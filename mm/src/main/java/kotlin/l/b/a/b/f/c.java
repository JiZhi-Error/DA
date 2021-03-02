package kotlin.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.a.e;
import kotlin.g.a.b;

public final class c {
    private static final f TCT = f.bua("<root>");
    private static final Pattern TCU = Pattern.compile("\\.");
    private static final b<String, f> TCV = new b<String, f>() {
        /* class kotlin.l.b.a.b.f.c.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ f invoke(String str) {
            AppMethodBeat.i(59297);
            f bub = f.bub(str);
            AppMethodBeat.o(59297);
            return bub;
        }
    };
    public final String TCW;
    private transient b TCX;
    private transient c TCY;
    private transient f TCZ;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(59316);
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 15:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                i3 = 2;
                break;
            case 9:
            case 15:
            case 16:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "safe";
                break;
            case 2:
            case 3:
            default:
                objArr[0] = "fqName";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                break;
            case 9:
                objArr[0] = "name";
                break;
            case 15:
                objArr[0] = "segment";
                break;
            case 16:
                objArr[0] = "shortName";
                break;
        }
        switch (i2) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
            case 6:
                objArr[1] = "toSafe";
                break;
            case 7:
            case 8:
                objArr[1] = "parent";
                break;
            case 9:
            case 15:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                break;
            case 10:
            case 11:
                objArr[1] = "shortName";
                break;
            case 12:
            case 13:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 14:
                objArr[1] = "pathSegments";
                break;
            case 17:
                objArr[1] = "toString";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                break;
            case 9:
                objArr[2] = "child";
                break;
            case 15:
                objArr[2] = "startsWith";
                break;
            case 16:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                illegalStateException = new IllegalStateException(format);
                break;
            case 9:
            case 15:
            case 16:
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(59316);
        throw illegalStateException;
    }

    static {
        AppMethodBeat.i(59315);
        AppMethodBeat.o(59315);
    }

    c(String str, b bVar) {
        if (str == null) {
            atM(0);
        }
        AppMethodBeat.i(59298);
        this.TCW = str;
        this.TCX = bVar;
        AppMethodBeat.o(59298);
    }

    private c(String str) {
        if (str == null) {
            atM(2);
        }
        AppMethodBeat.i(59299);
        this.TCW = str;
        AppMethodBeat.o(59299);
    }

    private c(String str, c cVar, f fVar) {
        if (str == null) {
            atM(3);
        }
        AppMethodBeat.i(59300);
        this.TCW = str;
        this.TCY = cVar;
        this.TCZ = fVar;
        AppMethodBeat.o(59300);
    }

    private void compute() {
        AppMethodBeat.i(59301);
        int lastIndexOf = this.TCW.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            this.TCZ = f.bub(this.TCW.substring(lastIndexOf + 1));
            this.TCY = new c(this.TCW.substring(0, lastIndexOf));
            AppMethodBeat.o(59301);
            return;
        }
        this.TCZ = f.bub(this.TCW);
        this.TCY = b.TCQ.hJe();
        AppMethodBeat.o(59301);
    }

    public final String sG() {
        AppMethodBeat.i(59302);
        String str = this.TCW;
        if (str == null) {
            atM(4);
        }
        AppMethodBeat.o(59302);
        return str;
    }

    public final boolean hJi() {
        AppMethodBeat.i(59303);
        if (this.TCX != null || sG().indexOf(60) < 0) {
            AppMethodBeat.o(59303);
            return true;
        }
        AppMethodBeat.o(59303);
        return false;
    }

    public final b hJj() {
        b bVar;
        AppMethodBeat.i(59304);
        if (this.TCX != null) {
            bVar = this.TCX;
            if (bVar == null) {
                atM(5);
            }
            AppMethodBeat.o(59304);
        } else {
            this.TCX = new b(this);
            bVar = this.TCX;
            if (bVar == null) {
                atM(6);
            }
            AppMethodBeat.o(59304);
        }
        return bVar;
    }

    public final c hJk() {
        c cVar;
        AppMethodBeat.i(59305);
        if (this.TCY != null) {
            cVar = this.TCY;
            if (cVar == null) {
                atM(7);
            }
            AppMethodBeat.o(59305);
        } else if (this.TCW.isEmpty()) {
            IllegalStateException illegalStateException = new IllegalStateException("root");
            AppMethodBeat.o(59305);
            throw illegalStateException;
        } else {
            compute();
            cVar = this.TCY;
            if (cVar == null) {
                atM(8);
            }
            AppMethodBeat.o(59305);
        }
        return cVar;
    }

    public final f hJg() {
        f fVar;
        AppMethodBeat.i(59307);
        if (this.TCZ != null) {
            fVar = this.TCZ;
            if (fVar == null) {
                atM(10);
            }
            AppMethodBeat.o(59307);
        } else if (this.TCW.isEmpty()) {
            IllegalStateException illegalStateException = new IllegalStateException("root");
            AppMethodBeat.o(59307);
            throw illegalStateException;
        } else {
            compute();
            fVar = this.TCZ;
            if (fVar == null) {
                atM(11);
            }
            AppMethodBeat.o(59307);
        }
        return fVar;
    }

    public static c t(f fVar) {
        AppMethodBeat.i(59311);
        if (fVar == null) {
            atM(16);
        }
        c cVar = new c(fVar.sG(), b.TCQ.hJe(), fVar);
        AppMethodBeat.o(59311);
        return cVar;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(59313);
        if (this == obj) {
            AppMethodBeat.o(59313);
            return true;
        } else if (!(obj instanceof c)) {
            AppMethodBeat.o(59313);
            return false;
        } else if (!this.TCW.equals(((c) obj).TCW)) {
            AppMethodBeat.o(59313);
            return false;
        } else {
            AppMethodBeat.o(59313);
            return true;
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(59314);
        int hashCode = this.TCW.hashCode();
        AppMethodBeat.o(59314);
        return hashCode;
    }

    public final c s(f fVar) {
        String str;
        AppMethodBeat.i(59306);
        if (fVar == null) {
            atM(9);
        }
        if (this.TCW.isEmpty()) {
            str = fVar.sG();
        } else {
            str = this.TCW + "." + fVar.sG();
        }
        c cVar = new c(str, this, fVar);
        AppMethodBeat.o(59306);
        return cVar;
    }

    public final f hJh() {
        f hJg;
        AppMethodBeat.i(59308);
        if (this.TCW.isEmpty()) {
            hJg = TCT;
            if (hJg == null) {
                atM(12);
            }
            AppMethodBeat.o(59308);
        } else {
            hJg = hJg();
            if (hJg == null) {
                atM(13);
            }
            AppMethodBeat.o(59308);
        }
        return hJg;
    }

    public final List<f> hJl() {
        AppMethodBeat.i(59309);
        List<f> emptyList = this.TCW.isEmpty() ? Collections.emptyList() : e.a(TCU.split(this.TCW), TCV);
        if (emptyList == null) {
            atM(14);
        }
        AppMethodBeat.o(59309);
        return emptyList;
    }

    public final boolean q(f fVar) {
        AppMethodBeat.i(59310);
        if (fVar == null) {
            atM(15);
        }
        if (this.TCW.isEmpty()) {
            AppMethodBeat.o(59310);
            return false;
        }
        int indexOf = this.TCW.indexOf(46);
        String str = this.TCW;
        String sG = fVar.sG();
        if (indexOf == -1) {
            indexOf = this.TCW.length();
        }
        boolean regionMatches = str.regionMatches(0, sG, 0, indexOf);
        AppMethodBeat.o(59310);
        return regionMatches;
    }

    public final String toString() {
        AppMethodBeat.i(59312);
        String sG = this.TCW.isEmpty() ? TCT.sG() : this.TCW;
        if (sG == null) {
            atM(17);
        }
        AppMethodBeat.o(59312);
        return sG;
    }
}
