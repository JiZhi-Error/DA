package kotlin.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.a.ae;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.s;

public enum n {
    CLASS("class"),
    ANNOTATION_CLASS("annotation class"),
    TYPE_PARAMETER("type parameter", false),
    PROPERTY("property"),
    FIELD("field"),
    LOCAL_VARIABLE("local variable"),
    VALUE_PARAMETER("value parameter"),
    CONSTRUCTOR("constructor"),
    FUNCTION("function"),
    PROPERTY_GETTER("getter"),
    PROPERTY_SETTER("setter"),
    TYPE("type usage", false),
    EXPRESSION("expression", false),
    FILE("file", false),
    TYPEALIAS("typealias", false),
    TYPE_PROJECTION("type projection", false),
    STAR_PROJECTION("star projection", false),
    PROPERTY_PARAMETER("property constructor parameter", false),
    CLASS_ONLY("class", false),
    OBJECT("object", false),
    COMPANION_OBJECT("companion object", false),
    INTERFACE("interface", false),
    ENUM_CLASS("enum class", false),
    ENUM_ENTRY("enum entry", false),
    LOCAL_CLASS("local class", false),
    LOCAL_FUNCTION("local function", false),
    MEMBER_FUNCTION("member function", false),
    TOP_LEVEL_FUNCTION("top level function", false),
    MEMBER_PROPERTY("member property", false),
    MEMBER_PROPERTY_WITH_BACKING_FIELD("member property with backing field", false),
    MEMBER_PROPERTY_WITH_DELEGATE("member property with delegate", false),
    MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("member property without backing field or delegate", false),
    TOP_LEVEL_PROPERTY("top level property", false),
    TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD("top level property with backing field", false),
    TOP_LEVEL_PROPERTY_WITH_DELEGATE("top level property with delegate", false),
    TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE("top level property without backing field or delegate", false),
    INITIALIZER("initializer", false),
    DESTRUCTURING_DECLARATION("destructuring declaration", false),
    LAMBDA_EXPRESSION("lambda expression", false),
    ANONYMOUS_FUNCTION("anonymous function", false),
    OBJECT_LITERAL("object literal", false);
    
    private static final Set<n> TjL;
    private static final Set<n> TjM = e.Y(values());
    private static final Map<e, n> TjN = ae.e(s.U(e.CONSTRUCTOR_PARAMETER, VALUE_PARAMETER), s.U(e.FIELD, FIELD), s.U(e.PROPERTY, PROPERTY), s.U(e.FILE, FILE), s.U(e.PROPERTY_GETTER, PROPERTY_GETTER), s.U(e.PROPERTY_SETTER, PROPERTY_SETTER), s.U(e.RECEIVER, VALUE_PARAMETER), s.U(e.SETTER_PARAMETER, VALUE_PARAMETER), s.U(e.PROPERTY_DELEGATE_FIELD, FIELD));
    public static final a TjO = new a((byte) 0);
    private static final HashMap<String, n> map = new HashMap<>();
    private final String description;
    private final boolean isDefault;

    public static n valueOf(String str) {
        AppMethodBeat.i(56981);
        n nVar = (n) Enum.valueOf(n.class, str);
        AppMethodBeat.o(56981);
        return nVar;
    }

    private /* synthetic */ n(String str) {
        this(str, true);
    }

    private n(String str, boolean z) {
        this.description = str;
        this.isDefault = z;
    }

    static {
        AppMethodBeat.i(56979);
        n[] values = values();
        for (n nVar : values) {
            map.put(nVar.name(), nVar);
        }
        n[] values2 = values();
        ArrayList arrayList = new ArrayList();
        for (n nVar2 : values2) {
            if (nVar2.isDefault) {
                arrayList.add(nVar2);
            }
        }
        TjL = j.r((Iterable) arrayList);
        AppMethodBeat.o(56979);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
