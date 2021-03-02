package kotlin.l.b.a.b.j.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.tmassistantsdk.downloadservice.DownloadSetting;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.f.b;

public enum d {
    BOOLEAN(h.BOOLEAN, DownloadSetting.TYPE_BOOLEAN, "Z", "java.lang.Boolean"),
    CHAR(h.CHAR, "char", "C", "java.lang.Character"),
    BYTE(h.BYTE, "byte", "B", "java.lang.Byte"),
    SHORT(h.SHORT, "short", "S", "java.lang.Short"),
    INT(h.INT, "int", "I", "java.lang.Integer"),
    FLOAT(h.FLOAT, "float", "F", "java.lang.Float"),
    LONG(h.LONG, "long", "J", "java.lang.Long"),
    DOUBLE(h.DOUBLE, "double", QLog.TAG_REPORTLEVEL_DEVELOPER, "java.lang.Double");
    
    private static final Set<b> TJe = new HashSet();
    private static final Map<String, d> TJf = new HashMap();
    private static final Map<h, d> TJg = new EnumMap(h.class);
    private static final Map<String, d> TJh = new HashMap();
    private final h TJi;
    private final b TJj;
    private final String desc;
    private final String name;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(60185);
        switch (i2) {
            case 2:
            case 4:
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 3:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 2:
            case 4:
            case 10:
            case 11:
            case 12:
            case 13:
                i3 = 2;
                break;
            case 3:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 7:
                objArr[0] = "name";
                break;
            case 2:
            case 4:
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
                break;
            case 3:
                objArr[0] = "type";
                break;
            case 5:
            case 8:
                objArr[0] = "desc";
                break;
            case 6:
                objArr[0] = "primitiveType";
                break;
            case 9:
                objArr[0] = "wrapperClassName";
                break;
            default:
                objArr[0] = "className";
                break;
        }
        switch (i2) {
            case 2:
            case 4:
                objArr[1] = "get";
                break;
            case 3:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
                break;
            case 10:
                objArr[1] = "getPrimitiveType";
                break;
            case 11:
                objArr[1] = "getJavaKeywordName";
                break;
            case 12:
                objArr[1] = "getDesc";
                break;
            case 13:
                objArr[1] = "getWrapperFqName";
                break;
        }
        switch (i2) {
            case 1:
            case 3:
                objArr[2] = "get";
                break;
            case 2:
            case 4:
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            case 5:
                objArr[2] = "getByDesc";
                break;
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[2] = "<init>";
                break;
            default:
                objArr[2] = "isWrapperClassName";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 2:
            case 4:
            case 10:
            case 11:
            case 12:
            case 13:
                illegalStateException = new IllegalStateException(format);
                break;
            case 3:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(60185);
        throw illegalStateException;
    }

    public static d valueOf(String str) {
        AppMethodBeat.i(60176);
        d dVar = (d) Enum.valueOf(d.class, str);
        AppMethodBeat.o(60176);
        return dVar;
    }

    static {
        AppMethodBeat.i(60184);
        d[] values = values();
        for (d dVar : values) {
            TJe.add(dVar.hKL());
            TJf.put(dVar.hKK(), dVar);
            TJg.put(dVar.hKJ(), dVar);
            TJh.put(dVar.getDesc(), dVar);
        }
        AppMethodBeat.o(60184);
    }

    public static d buk(String str) {
        AppMethodBeat.i(60177);
        if (str == null) {
            atM(1);
        }
        d dVar = TJf.get(str);
        if (dVar == null) {
            AssertionError assertionError = new AssertionError("Non-primitive type name passed: ".concat(String.valueOf(str)));
            AppMethodBeat.o(60177);
            throw assertionError;
        }
        if (dVar == null) {
            atM(2);
        }
        AppMethodBeat.o(60177);
        return dVar;
    }

    public static d d(h hVar) {
        AppMethodBeat.i(60178);
        if (hVar == null) {
            atM(3);
        }
        d dVar = TJg.get(hVar);
        if (dVar == null) {
            atM(4);
        }
        AppMethodBeat.o(60178);
        return dVar;
    }

    private d(h hVar, String str, String str2, String str3) {
        if (hVar == null) {
            atM(6);
        }
        AppMethodBeat.i(60179);
        this.TJi = hVar;
        this.name = str;
        this.desc = str2;
        this.TJj = new b(str3);
        AppMethodBeat.o(60179);
    }

    public final h hKJ() {
        AppMethodBeat.i(60180);
        h hVar = this.TJi;
        if (hVar == null) {
            atM(10);
        }
        AppMethodBeat.o(60180);
        return hVar;
    }

    public final String hKK() {
        AppMethodBeat.i(60181);
        String str = this.name;
        if (str == null) {
            atM(11);
        }
        AppMethodBeat.o(60181);
        return str;
    }

    public final String getDesc() {
        AppMethodBeat.i(60182);
        String str = this.desc;
        if (str == null) {
            atM(12);
        }
        AppMethodBeat.o(60182);
        return str;
    }

    public final b hKL() {
        AppMethodBeat.i(60183);
        b bVar = this.TJj;
        if (bVar == null) {
            atM(13);
        }
        AppMethodBeat.o(60183);
        return bVar;
    }
}
