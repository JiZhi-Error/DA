package kotlin.n;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m.i;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\f\n\u0002\b\u0011\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\b\u001a\u0019\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\b\u001a)\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\b\u001a\n\u0010\u0017\u001a\u00020\u0002*\u00020\u0002\u001a\u0014\u0010\u0017\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\u0015\u0010\u001a\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\b\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\b\u001a\u001d\u0010\u001d\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\b\u001a\u001c\u0010 \u001a\u00020\u0011*\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a\f\u0010$\u001a\u00020\u0002*\u00020\u0014H\u0007\u001a \u0010$\u001a\u00020\u0002*\u00020\u00142\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007\u001a\u0015\u0010&\u001a\u00020#*\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\b\u001a\u0015\u0010&\u001a\u00020#*\u00020\u00022\u0006\u0010'\u001a\u00020(H\b\u001a\n\u0010)\u001a\u00020\u0002*\u00020\u0002\u001a\u0014\u0010)\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\f\u0010*\u001a\u00020\u0002*\u00020\rH\u0007\u001a*\u0010*\u001a\u00020\u0002*\u00020\r2\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020#H\u0007\u001a\f\u0010,\u001a\u00020\r*\u00020\u0002H\u0007\u001a*\u0010,\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020#H\u0007\u001a\u001c\u0010-\u001a\u00020#*\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a \u0010/\u001a\u00020#*\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a2\u00100\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\b¢\u0006\u0002\u00104\u001a*\u00100\u001a\u00020\u0002*\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\b¢\u0006\u0002\u00105\u001a:\u00100\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\b¢\u0006\u0002\u00106\u001a2\u00100\u001a\u00020\u0002*\u00020\u00042\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\b¢\u0006\u0002\u00107\u001a\r\u00108\u001a\u00020\u0002*\u00020\u0002H\b\u001a\n\u00109\u001a\u00020#*\u00020(\u001a\u001d\u0010:\u001a\u00020\u0011*\u00020\u00022\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0011H\b\u001a\u001d\u0010:\u001a\u00020\u0011*\u00020\u00022\u0006\u0010>\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u0011H\b\u001a\u001d\u0010?\u001a\u00020\u0011*\u00020\u00022\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0011H\b\u001a\u001d\u0010?\u001a\u00020\u0011*\u00020\u00022\u0006\u0010>\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u0011H\b\u001a\u001d\u0010@\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u0011H\b\u001a4\u0010B\u001a\u00020#*\u00020(2\u0006\u0010C\u001a\u00020\u00112\u0006\u0010!\u001a\u00020(2\u0006\u0010D\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a4\u0010B\u001a\u00020#*\u00020\u00022\u0006\u0010C\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a\u0012\u0010E\u001a\u00020\u0002*\u00020(2\u0006\u0010F\u001a\u00020\u0011\u001a$\u0010G\u001a\u00020\u0002*\u00020\u00022\u0006\u0010H\u001a\u00020<2\u0006\u0010I\u001a\u00020<2\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010G\u001a\u00020\u0002*\u00020\u00022\u0006\u0010J\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010H\u001a\u00020<2\u0006\u0010I\u001a\u00020<2\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010J\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a\"\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00020N*\u00020(2\u0006\u0010O\u001a\u00020P2\b\b\u0002\u0010Q\u001a\u00020\u0011\u001a\u001c\u0010R\u001a\u00020#*\u00020\u00022\u0006\u0010S\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010R\u001a\u00020#*\u00020\u00022\u0006\u0010S\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a\u0015\u0010T\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0011H\b\u001a\u001d\u0010T\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\b\u001a\u0017\u0010U\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\b\u001a\r\u0010V\u001a\u00020\u0014*\u00020\u0002H\b\u001a3\u0010V\u001a\u00020\u0014*\u00020\u00022\u0006\u0010W\u001a\u00020\u00142\b\b\u0002\u0010X\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\b\u001a \u0010V\u001a\u00020\u0014*\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007\u001a\r\u0010Y\u001a\u00020\u0002*\u00020\u0002H\b\u001a\u0015\u0010Y\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\b\u001a\u0017\u0010Z\u001a\u00020P*\u00020\u00022\b\b\u0002\u0010[\u001a\u00020\u0011H\b\u001a\r\u0010\\\u001a\u00020\u0002*\u00020\u0002H\b\u001a\u0015\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\b\"%\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006]"}, hxF = {"CASE_INSENSITIVE_ORDER", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "Lkotlin/String$Companion;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "String", "stringBuffer", "Ljava/lang/StringBuffer;", "stringBuilder", "Ljava/lang/StringBuilder;", "bytes", "", "charset", "Ljava/nio/charset/Charset;", "offset", "", "length", "chars", "", "codePoints", "", "capitalize", "locale", "Ljava/util/Locale;", "codePointAt", FirebaseAnalytics.b.INDEX, "codePointBefore", "codePointCount", "beginIndex", "endIndex", "compareTo", FacebookRequestErrorClassification.KEY_OTHER, "ignoreCase", "", "concatToString", "startIndex", "contentEquals", "charSequence", "", "decapitalize", "decodeToString", "throwOnInvalidSequence", "encodeToByteArray", "endsWith", "suffix", "equals", "format", "args", "", "", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "intern", "isBlank", "nativeIndexOf", "ch", "", "fromIndex", "str", "nativeLastIndexOf", "offsetByCodePoints", "codePointOffset", "regionMatches", "thisOffset", "otherOffset", "repeat", "n", "replace", "oldChar", "newChar", "oldValue", "newValue", "replaceFirst", "split", "", "regex", "Ljava/util/regex/Pattern;", "limit", "startsWith", "prefix", "substring", "toByteArray", "toCharArray", "destination", "destinationOffset", "toLowerCase", "toPattern", "flags", "toUpperCase", "kotlin-stdlib"}, hxG = 1)
public class w extends v {
    public static final boolean I(String str, String str2, boolean z) {
        AppMethodBeat.i(129365);
        if (str == null) {
            if (str2 == null) {
                AppMethodBeat.o(129365);
                return true;
            }
            AppMethodBeat.o(129365);
            return false;
        } else if (!z) {
            boolean equals = str.equals(str2);
            AppMethodBeat.o(129365);
            return equals;
        } else {
            boolean equalsIgnoreCase = str.equalsIgnoreCase(str2);
            AppMethodBeat.o(129365);
            return equalsIgnoreCase;
        }
    }

    public static final String a(String str, char c2, char c3) {
        AppMethodBeat.i(129366);
        p.h(str, "$this$replace");
        String replace = str.replace(c2, c3);
        p.g(replace, "(this as java.lang.Strin…replace(oldChar, newChar)");
        AppMethodBeat.o(129366);
        return replace;
    }

    public static final String j(String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(129367);
        p.h(str, "$this$replace");
        p.h(str2, "oldValue");
        p.h(str3, "newValue");
        String a2 = i.a(n.b(str, new String[]{str2}, z, 4), str3);
        AppMethodBeat.o(129367);
        return a2;
    }

    public static final String by(String str, String str2, String str3) {
        AppMethodBeat.i(129368);
        p.h(str, "$this$replaceFirst");
        p.h(str2, "oldValue");
        p.h(str3, "newValue");
        int a2 = n.a((CharSequence) str, str2, 0, false, 2);
        if (a2 < 0) {
            AppMethodBeat.o(129368);
            return str;
        }
        String obj = n.a(str, a2, str2.length() + a2, str3).toString();
        AppMethodBeat.o(129368);
        return obj;
    }

    public static final boolean J(String str, String str2, boolean z) {
        AppMethodBeat.i(206256);
        p.h(str, "$this$startsWith");
        p.h(str2, "prefix");
        if (!z) {
            boolean startsWith = str.startsWith(str2);
            AppMethodBeat.o(206256);
            return startsWith;
        }
        boolean a2 = n.a(str, 0, str2, 0, str2.length(), z);
        AppMethodBeat.o(206256);
        return a2;
    }

    public static final boolean nm(String str, String str2) {
        AppMethodBeat.i(129370);
        p.h(str, "$this$endsWith");
        p.h(str2, "suffix");
        boolean endsWith = str.endsWith(str2);
        AppMethodBeat.o(129370);
        return endsWith;
    }

    public static final boolean aL(CharSequence charSequence) {
        boolean z;
        AppMethodBeat.i(129371);
        p.h(charSequence, "$this$isBlank");
        if (charSequence.length() != 0) {
            Iterator it = n.aN(charSequence).iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!a.isWhitespace(charSequence.charAt(((ab) it).nextInt()))) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            if (!z) {
                AppMethodBeat.o(129371);
                return false;
            }
        }
        AppMethodBeat.o(129371);
        return true;
    }

    public static final boolean a(String str, int i2, String str2, int i3, int i4, boolean z) {
        AppMethodBeat.i(206258);
        p.h(str, "$this$regionMatches");
        p.h(str2, FacebookRequestErrorClassification.KEY_OTHER);
        if (!z) {
            boolean regionMatches = str.regionMatches(0, str2, i3, i4);
            AppMethodBeat.o(206258);
            return regionMatches;
        }
        boolean regionMatches2 = str.regionMatches(z, 0, str2, i3, i4);
        AppMethodBeat.o(206258);
        return regionMatches2;
    }

    public static final String capitalize(String str) {
        AppMethodBeat.i(129373);
        p.h(str, "$this$capitalize");
        if (!(str.length() > 0) || !Character.isLowerCase(str.charAt(0))) {
            AppMethodBeat.o(129373);
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, 1);
        p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (substring == null) {
            t tVar = new t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(129373);
            throw tVar;
        }
        String upperCase = substring.toUpperCase();
        p.g(upperCase, "(this as java.lang.String).toUpperCase()");
        StringBuilder append = sb.append(upperCase);
        String substring2 = str.substring(1);
        p.g(substring2, "(this as java.lang.String).substring(startIndex)");
        String sb2 = append.append(substring2).toString();
        AppMethodBeat.o(129373);
        return sb2;
    }

    public static final String r(CharSequence charSequence, int i2) {
        int i3 = 1;
        AppMethodBeat.i(129374);
        p.h(charSequence, "$this$repeat");
        if (!(i2 >= 0)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i2 + '.').toString());
            AppMethodBeat.o(129374);
            throw illegalArgumentException;
        }
        switch (i2) {
            case 0:
                AppMethodBeat.o(129374);
                return "";
            case 1:
                String obj = charSequence.toString();
                AppMethodBeat.o(129374);
                return obj;
            default:
                switch (charSequence.length()) {
                    case 0:
                        AppMethodBeat.o(129374);
                        return "";
                    case 1:
                        char charAt = charSequence.charAt(0);
                        char[] cArr = new char[i2];
                        for (int i4 = 0; i4 < i2; i4++) {
                            cArr[i4] = charAt;
                        }
                        String str = new String(cArr);
                        AppMethodBeat.o(129374);
                        return str;
                    default:
                        StringBuilder sb = new StringBuilder(charSequence.length() * i2);
                        if (i2 > 0) {
                            while (true) {
                                sb.append(charSequence);
                                if (i3 != i2) {
                                    i3++;
                                }
                            }
                        }
                        String sb2 = sb.toString();
                        p.g(sb2, "sb.toString()");
                        AppMethodBeat.o(129374);
                        return sb2;
                }
        }
    }
}
