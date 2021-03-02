package kotlinx.a.c.a;

import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0000\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a\u0018\u0010\r\u001a\u00020\u000e*\u00060\u000fj\u0002`\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0000\u001a\f\u0010\u0012\u001a\u00020\u0007*\u00020\u0002H\u0000\u001a\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0007*\u00020\u0002H\u0000¢\u0006\u0002\u0010\u0014\" \u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018\u0002X\u0004¢\u0006\n\n\u0002\u0010\u0005\u0012\u0004\b\u0003\u0010\u0004¨\u0006\u0015"}, hxF = {"ESCAPE_CHARS", "", "", "ESCAPE_CHARS$annotations", "()V", "[Ljava/lang/String;", "shouldBeQuoted", "", "str", "toHexChar", "", "i", "", "printQuoted", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "value", "toBooleanStrict", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "kotlinx-serialization-runtime"})
public final class p {
    private static final String[] Uay;

    private static final char awg(int i2) {
        int i3 = i2 & 15;
        if (i3 < 10) {
            return (char) (i3 + 48);
        }
        return (char) ((i3 - 10) + 97);
    }

    static {
        AppMethodBeat.i(225702);
        String[] strArr = new String[128];
        for (int i2 = 0; i2 <= 31; i2++) {
            char awg = awg(i2 >> 12);
            char awg2 = awg(i2 >> 8);
            char awg3 = awg(i2 >> 4);
            strArr[i2] = "\\u" + awg + awg2 + awg3 + awg(i2);
        }
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        Uay = strArr;
        AppMethodBeat.o(225702);
    }

    public static final void b(StringBuilder sb, String str) {
        int i2;
        AppMethodBeat.i(225698);
        kotlin.g.b.p.h(sb, "$this$printQuoted");
        kotlin.g.b.p.h(str, "value");
        sb.append('\"');
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            char charAt = str.charAt(i3);
            if (charAt < Uay.length) {
                String str2 = Uay[charAt];
                if (str2 == null) {
                    i2 = i4;
                } else {
                    sb.append((CharSequence) str, i4, i3);
                    sb.append(str2);
                    i2 = i3 + 1;
                }
            } else {
                i2 = i4;
            }
            i3++;
            i4 = i2;
        }
        sb.append((CharSequence) str, i4, length);
        sb.append('\"');
        AppMethodBeat.o(225698);
    }

    public static final boolean buR(String str) {
        AppMethodBeat.i(225699);
        kotlin.g.b.p.h(str, "$this$toBooleanStrict");
        Boolean buS = buS(str);
        if (buS != null) {
            boolean booleanValue = buS.booleanValue();
            AppMethodBeat.o(225699);
            return booleanValue;
        }
        IllegalStateException illegalStateException = new IllegalStateException(str + " does not represent a Boolean");
        AppMethodBeat.o(225699);
        throw illegalStateException;
    }

    public static final Boolean buS(String str) {
        AppMethodBeat.i(225700);
        kotlin.g.b.p.h(str, "$this$toBooleanStrictOrNull");
        if (n.I(str, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, true)) {
            Boolean bool = Boolean.TRUE;
            AppMethodBeat.o(225700);
            return bool;
        } else if (n.I(str, "false", true)) {
            Boolean bool2 = Boolean.FALSE;
            AppMethodBeat.o(225700);
            return bool2;
        } else {
            AppMethodBeat.o(225700);
            return null;
        }
    }

    public static final boolean buT(String str) {
        AppMethodBeat.i(225701);
        kotlin.g.b.p.h(str, "str");
        if (kotlin.g.b.p.j(str, BuildConfig.COMMAND)) {
            AppMethodBeat.o(225701);
            return true;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (g.G(str.charAt(i2)) != 0) {
                AppMethodBeat.o(225701);
                return true;
            }
        }
        AppMethodBeat.o(225701);
        return false;
    }
}
