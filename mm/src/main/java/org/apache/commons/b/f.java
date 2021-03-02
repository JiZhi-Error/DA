package org.apache.commons.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;
import org.apache.commons.b.b.d;
import org.apache.commons.b.c.a;

public final class f {
    private static final String Ufx = "\"";
    private static final char[] Ufy = {',', '\"', '\r', '\n'};

    public static String bve(String str) {
        AppMethodBeat.i(40737);
        String bvf = bvf(str);
        AppMethodBeat.o(40737);
        return bvf;
    }

    private static String bvf(String str) {
        AppMethodBeat.i(40738);
        if (str == null) {
            AppMethodBeat.o(40738);
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter(str.length() * 2);
            a(stringWriter, str);
            String stringWriter2 = stringWriter.toString();
            AppMethodBeat.o(40738);
            return stringWriter2;
        } catch (IOException e2) {
            i iVar = new i(e2);
            AppMethodBeat.o(40738);
            throw iVar;
        }
    }

    private static void a(Writer writer, String str) {
        AppMethodBeat.i(40739);
        if (str == null) {
            AppMethodBeat.o(40739);
            return;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt > 4095) {
                writer.write(new StringBuffer("\\u").append(I(charAt)).toString());
            } else if (charAt > 255) {
                writer.write(new StringBuffer("\\u0").append(I(charAt)).toString());
            } else if (charAt > 127) {
                writer.write(new StringBuffer("\\u00").append(I(charAt)).toString());
            } else if (charAt < ' ') {
                switch (charAt) {
                    case '\b':
                        writer.write(92);
                        writer.write(98);
                        continue;
                    case '\t':
                        writer.write(92);
                        writer.write(116);
                        continue;
                    case '\n':
                        writer.write(92);
                        writer.write(110);
                        continue;
                    case 11:
                    default:
                        if (charAt <= 15) {
                            writer.write(new StringBuffer("\\u000").append(I(charAt)).toString());
                            break;
                        } else {
                            writer.write(new StringBuffer("\\u00").append(I(charAt)).toString());
                            continue;
                        }
                    case '\f':
                        writer.write(92);
                        writer.write(102);
                        continue;
                    case '\r':
                        writer.write(92);
                        writer.write(114);
                        continue;
                }
            } else {
                switch (charAt) {
                    case '\"':
                        writer.write(92);
                        writer.write(34);
                        continue;
                    case '\'':
                        writer.write(92);
                        writer.write(39);
                        continue;
                    case '/':
                        writer.write(92);
                        writer.write(47);
                        continue;
                    case '\\':
                        writer.write(92);
                        writer.write(92);
                        continue;
                    default:
                        writer.write(charAt);
                        continue;
                }
            }
        }
        AppMethodBeat.o(40739);
    }

    private static String I(char c2) {
        AppMethodBeat.i(40740);
        String upperCase = Integer.toHexString(c2).toUpperCase(Locale.ENGLISH);
        AppMethodBeat.o(40740);
        return upperCase;
    }

    private static String bvg(String str) {
        AppMethodBeat.i(40741);
        if (str == null) {
            AppMethodBeat.o(40741);
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter(str.length());
            b(stringWriter, str);
            String stringWriter2 = stringWriter.toString();
            AppMethodBeat.o(40741);
            return stringWriter2;
        } catch (IOException e2) {
            i iVar = new i(e2);
            AppMethodBeat.o(40741);
            throw iVar;
        }
    }

    private static void b(Writer writer, String str) {
        AppMethodBeat.i(40742);
        if (str == null) {
            AppMethodBeat.o(40742);
            return;
        }
        int length = str.length();
        a aVar = new a(4);
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (z) {
                aVar.J(charAt);
                if (aVar.length() == 4) {
                    try {
                        writer.write((char) Integer.parseInt(aVar.toString(), 16));
                        aVar.hPP();
                        z = false;
                        z2 = false;
                    } catch (NumberFormatException e2) {
                        d dVar = new d("Unable to parse unicode value: ".concat(String.valueOf(aVar)), e2);
                        AppMethodBeat.o(40742);
                        throw dVar;
                    }
                }
            } else if (z2) {
                switch (charAt) {
                    case '\"':
                        writer.write(34);
                        z2 = false;
                        continue;
                    case '\'':
                        writer.write(39);
                        z2 = false;
                        continue;
                    case '\\':
                        writer.write(92);
                        z2 = false;
                        continue;
                    case 'b':
                        writer.write(8);
                        z2 = false;
                        continue;
                    case 'f':
                        writer.write(12);
                        z2 = false;
                        continue;
                    case 'n':
                        writer.write(10);
                        z2 = false;
                        continue;
                    case 'r':
                        writer.write(13);
                        z2 = false;
                        continue;
                    case 't':
                        writer.write(9);
                        z2 = false;
                        continue;
                    case 'u':
                        z = true;
                        z2 = false;
                        continue;
                    default:
                        writer.write(charAt);
                        z2 = false;
                        continue;
                }
            } else if (charAt == '\\') {
                z2 = true;
            } else {
                writer.write(charAt);
            }
        }
        if (z2) {
            writer.write(92);
        }
        AppMethodBeat.o(40742);
    }

    public static String bvh(String str) {
        AppMethodBeat.i(40743);
        String bvg = bvg(str);
        AppMethodBeat.o(40743);
        return bvg;
    }

    public static String bvi(String str) {
        AppMethodBeat.i(40744);
        if (str == null) {
            AppMethodBeat.o(40744);
            return null;
        }
        String unescape = c.Ufn.unescape(str);
        AppMethodBeat.o(40744);
        return unescape;
    }
}
