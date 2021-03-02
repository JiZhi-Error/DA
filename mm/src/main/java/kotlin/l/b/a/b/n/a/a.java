package kotlin.l.b.a.b.n.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.n.n;

public final class a {
    public static final String bur(String str) {
        boolean z;
        char charAt;
        Object obj;
        boolean z2;
        AppMethodBeat.i(61336);
        p.h(str, "$this$decapitalizeSmartForCompiler");
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z || !hS(str, 0)) {
            AppMethodBeat.o(61336);
            return str;
        } else if (str.length() == 1 || !hS(str, 1)) {
            p.h(str, "$this$decapitalizeAsciiOnly");
            if ((str.length() == 0) || 'A' > (charAt = str.charAt(0)) || 'Z' < charAt) {
                AppMethodBeat.o(61336);
                return str;
            }
            char lowerCase = Character.toLowerCase(charAt);
            String substring = str.substring(1);
            p.g(substring, "(this as java.lang.String).substring(startIndex)");
            String str2 = String.valueOf(lowerCase) + substring;
            AppMethodBeat.o(61336);
            return str2;
        } else {
            Iterator it = n.aN(str).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                Object next = it.next();
                if (!hS(str, ((Number) next).intValue())) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    obj = next;
                    break;
                }
            }
            Integer num = (Integer) obj;
            if (num != null) {
                int intValue = num.intValue() - 1;
                StringBuilder sb = new StringBuilder();
                String substring2 = str.substring(0, intValue);
                p.g(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                StringBuilder append = sb.append(bus(substring2));
                String substring3 = str.substring(intValue);
                p.g(substring3, "(this as java.lang.String).substring(startIndex)");
                String sb2 = append.append(substring3).toString();
                AppMethodBeat.o(61336);
                return sb2;
            }
            String bus = bus(str);
            AppMethodBeat.o(61336);
            return bus;
        }
    }

    private static final boolean hS(String str, int i2) {
        AppMethodBeat.i(61337);
        char charAt = str.charAt(i2);
        if ('A' <= charAt && 'Z' >= charAt) {
            AppMethodBeat.o(61337);
            return true;
        }
        AppMethodBeat.o(61337);
        return false;
    }

    private static final String bus(String str) {
        AppMethodBeat.i(61338);
        String buu = buu(str);
        AppMethodBeat.o(61338);
        return buu;
    }

    public static final String but(String str) {
        boolean z;
        AppMethodBeat.i(61339);
        p.h(str, "$this$capitalizeAsciiOnly");
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AppMethodBeat.o(61339);
            return str;
        }
        char charAt = str.charAt(0);
        if ('a' <= charAt && 'z' >= charAt) {
            char upperCase = Character.toUpperCase(charAt);
            String substring = str.substring(1);
            p.g(substring, "(this as java.lang.String).substring(startIndex)");
            String str2 = String.valueOf(upperCase) + substring;
            AppMethodBeat.o(61339);
            return str2;
        }
        AppMethodBeat.o(61339);
        return str;
    }

    private static String buu(String str) {
        AppMethodBeat.i(61340);
        p.h(str, "$this$toLowerCaseAsciiOnly");
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if ('A' <= charAt && 'Z' >= charAt) {
                charAt = Character.toLowerCase(charAt);
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        p.g(sb2, "builder.toString()");
        AppMethodBeat.o(61340);
        return sb2;
    }
}
