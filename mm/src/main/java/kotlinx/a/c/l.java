package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.t;
import kotlinx.a.n;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0000\u001a \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0000\u001a\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0000\u001a\u0016\u0010\u0012\u001a\u00020\u0005*\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u0013"}, hxF = {"InvalidFloatingPoint", "Lkotlinx/serialization/json/JsonEncodingException;", "value", "", "type", "", "output", "key", "InvalidKeyKindException", "keyDescriptor", "Lkotlinx/serialization/SerialDescriptor;", "JsonDecodingException", "Lkotlinx/serialization/json/JsonDecodingException;", "offset", "", "message", "input", "UnknownKeyException", "minify", "kotlinx-serialization-runtime"})
public final class l {
    public static final e af(int i2, String str, String str2) {
        AppMethodBeat.i(225747);
        p.h(str, "message");
        p.h(str2, "input");
        e eVar = new e(i2, str + ".\n JSON input: " + hW(str2, i2));
        AppMethodBeat.o(225747);
        return eVar;
    }

    public static final j a(Number number, String str, String str2) {
        AppMethodBeat.i(225748);
        p.h(number, "value");
        p.h(str, "type");
        p.h(str2, "output");
        j jVar = new j("'" + number + "' is not a valid '" + str + "' as per JSON specification. You can enable 'serializeSpecialFloatingPointValues' property to serialize such values\nCurrent output: " + hW(str2, -1));
        AppMethodBeat.o(225748);
        return jVar;
    }

    public static final j f(n nVar) {
        AppMethodBeat.i(225749);
        p.h(nVar, "keyDescriptor");
        j jVar = new j("Value of type '" + nVar.hOz() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + nVar.hOA() + ".'\nYou can convert such maps to arrays [key1, value1, key2, value2,...] using 'allowStructuredMapKeys' property in JsonConfiguration");
        AppMethodBeat.o(225749);
        return jVar;
    }

    public static final String hW(String str, int i2) {
        AppMethodBeat.i(225750);
        if (str.length() < 200) {
            AppMethodBeat.o(225750);
            return str;
        } else if (i2 == -1) {
            int length = str.length() - 60;
            if (length <= 0) {
                AppMethodBeat.o(225750);
                return str;
            }
            StringBuilder sb = new StringBuilder(".....");
            if (str == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(225750);
                throw tVar;
            }
            String substring = str.substring(length);
            p.g(substring, "(this as java.lang.String).substring(startIndex)");
            String sb2 = sb.append(substring).toString();
            AppMethodBeat.o(225750);
            return sb2;
        } else {
            int i3 = i2 - 30;
            int i4 = i2 + 30;
            String str2 = i3 <= 0 ? "" : ".....";
            String str3 = i4 >= str.length() ? "" : ".....";
            StringBuilder append = new StringBuilder().append(str2);
            int mZ = j.mZ(i3, 0);
            int na = j.na(i4, str.length());
            if (str == null) {
                t tVar2 = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(225750);
                throw tVar2;
            }
            String substring2 = str.substring(mZ, na);
            p.g(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String sb3 = append.append(substring2).append(str3).toString();
            AppMethodBeat.o(225750);
            return sb3;
        }
    }
}
