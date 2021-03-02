package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.e.v;

public abstract class w implements v {
    public static final a Tnu = new a((byte) 0);

    /* access modifiers changed from: protected */
    public abstract Type hCJ();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static w b(Type type) {
            AppMethodBeat.i(57504);
            p.h(type, "type");
            if ((type instanceof Class) && ((Class) type).isPrimitive()) {
                v vVar = new v((Class) type);
                AppMethodBeat.o(57504);
                return vVar;
            } else if ((type instanceof GenericArrayType) || ((type instanceof Class) && ((Class) type).isArray())) {
                i iVar = new i(type);
                AppMethodBeat.o(57504);
                return iVar;
            } else if (type instanceof WildcardType) {
                z zVar = new z((WildcardType) type);
                AppMethodBeat.o(57504);
                return zVar;
            } else {
                l lVar = new l(type);
                AppMethodBeat.o(57504);
                return lVar;
            }
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof w) && p.j(hCJ(), ((w) obj).hCJ());
    }

    public int hashCode() {
        return hCJ().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + hCJ();
    }
}
