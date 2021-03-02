package kotlin.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.t;

public enum e {
    FIELD,
    FILE,
    PROPERTY,
    PROPERTY_GETTER("get"),
    PROPERTY_SETTER("set"),
    RECEIVER,
    CONSTRUCTOR_PARAMETER("param"),
    SETTER_PARAMETER("setparam"),
    PROPERTY_DELEGATE_FIELD("delegate");
    
    public final String Tiv;

    public static e valueOf(String str) {
        AppMethodBeat.i(56938);
        e eVar = (e) Enum.valueOf(e.class, str);
        AppMethodBeat.o(56938);
        return eVar;
    }

    private /* synthetic */ e() {
        this(null);
    }

    private e(String str) {
        AppMethodBeat.i(56936);
        if (str == null) {
            String name = name();
            if (name == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(56936);
                throw tVar;
            }
            str = name.toLowerCase();
            p.g(str, "(this as java.lang.String).toLowerCase()");
        }
        this.Tiv = str;
        AppMethodBeat.o(56936);
    }

    static {
        AppMethodBeat.i(56935);
        AppMethodBeat.o(56935);
    }
}
