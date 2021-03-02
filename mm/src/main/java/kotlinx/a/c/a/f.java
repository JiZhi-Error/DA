package kotlinx.a.c.a;

import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.t;
import kotlinx.a.c.e;

@l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0010\u0001\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\fH\u0002J \u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\fH\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\fJ\u0018\u0010\"\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010#\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\fH\u0002J\u0018\u0010$\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u0006\u0010%\u001a\u00020\u0014J.\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030(H\b¢\u0006\u0002\b)J*\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u00112\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00030-H\b¢\u0006\u0002\b.J\u0006\u0010/\u001a\u00020\u0014J\u0006\u00100\u001a\u00020\u0003J\u0006\u00101\u001a\u00020\u0003J\b\u00102\u001a\u00020\u0003H\u0002J\u0006\u00103\u001a\u00020\u0003J\b\u00104\u001a\u00020\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\nR\u000e\u0010\u000e\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u00065"}, hxF = {"Lkotlinx/serialization/json/internal/JsonReader;", "", "source", "", "(Ljava/lang/String;)V", "buf", "", "canBeginValue", "", "getCanBeginValue", "()Z", "currentPosition", "", "isDone", "length", "offset", "tokenClass", "", "tokenPosition", "append", "", "ch", "", "appendEsc", "startPosition", "appendHex", "startPos", "appendRange", "fromIndex", "toIndex", "fail", "", "message", "position", "fromHexChar", "nextLiteral", "nextString", "nextToken", "require", "condition", "Lkotlin/Function0;", "require$kotlinx_serialization_runtime", "requireTokenClass", "expected", "errorMessage", "Lkotlin/Function1;", "requireTokenClass$kotlinx_serialization_runtime", "skipElement", "takeBooleanStringUnquoted", "takeString", "takeStringInternal", "takeStringQuoted", "toString", "kotlinx-serialization-runtime"})
public final class f {
    public byte Ual = JceStruct.ZERO_TAG;
    int Uam;
    private char[] buf = new char[16];
    private int length;
    private int offset = -1;
    private final String source;
    public int zaD;

    public f(String str) {
        p.h(str, "source");
        AppMethodBeat.i(225674);
        this.source = str;
        hPc();
        AppMethodBeat.o(225674);
    }

    public final boolean hOY() {
        switch (this.Ual) {
            case 0:
            case 1:
            case 6:
            case 8:
            case 10:
                return true;
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 9:
            default:
                return false;
        }
    }

    public final String hOZ() {
        AppMethodBeat.i(225659);
        if (this.Ual == 0 || this.Ual == 1) {
            String hPb = hPb();
            AppMethodBeat.o(225659);
            return hPb;
        }
        ib("Expected string or non-null literal", this.Uam);
        AppMethodBeat.o(225659);
        throw null;
    }

    public final String hPa() {
        AppMethodBeat.i(225660);
        if (this.Ual != 1) {
            ib("Expected string literal with quotes. Use 'JsonConfiguration.isLenient = true' to accept non-compliant JSON", this.Uam);
            AppMethodBeat.o(225660);
            throw null;
        }
        String hPb = hPb();
        AppMethodBeat.o(225660);
        return hPb;
    }

    /* access modifiers changed from: package-private */
    public final String hPb() {
        String substring;
        AppMethodBeat.i(225661);
        if (this.offset < 0) {
            substring = new String(this.buf, 0, this.length);
        } else {
            String str = this.source;
            int i2 = this.offset;
            int i3 = this.offset + this.length;
            if (str == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(225661);
                throw tVar;
            }
            substring = str.substring(i2, i3);
            p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        hPc();
        AppMethodBeat.o(225661);
        return substring;
    }

    private final void append(char c2) {
        AppMethodBeat.i(225662);
        if (this.length >= this.buf.length) {
            char[] copyOf = Arrays.copyOf(this.buf, this.buf.length * 2);
            p.g(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            this.buf = copyOf;
        }
        char[] cArr = this.buf;
        int i2 = this.length;
        this.length = i2 + 1;
        cArr[i2] = c2;
        AppMethodBeat.o(225662);
    }

    private final void bd(String str, int i2, int i3) {
        AppMethodBeat.i(225663);
        int i4 = i3 - i2;
        int i5 = this.length;
        int i6 = i5 + i4;
        if (i6 > this.buf.length) {
            char[] copyOf = Arrays.copyOf(this.buf, j.mZ(i6, this.buf.length * 2));
            p.g(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            this.buf = copyOf;
        }
        for (int i7 = 0; i7 < i4; i7++) {
            this.buf[i5 + i7] = str.charAt(i2 + i7);
        }
        this.length += i4;
        AppMethodBeat.o(225663);
    }

    public final void hPc() {
        AppMethodBeat.i(225664);
        String str = this.source;
        int i2 = this.zaD;
        while (i2 < str.length()) {
            byte G = g.G(str.charAt(i2));
            if (G == 3) {
                i2++;
            } else if (G == 0) {
                hX(str, i2);
                AppMethodBeat.o(225664);
                return;
            } else if (G == 1) {
                hY(str, i2);
                AppMethodBeat.o(225664);
                return;
            } else {
                this.Uam = i2;
                this.Ual = G;
                this.zaD = i2 + 1;
                AppMethodBeat.o(225664);
                return;
            }
        }
        this.Uam = i2;
        this.Ual = JceStruct.ZERO_TAG;
        AppMethodBeat.o(225664);
    }

    private final void hX(String str, int i2) {
        AppMethodBeat.i(225665);
        this.Uam = i2;
        this.offset = i2;
        while (i2 < str.length() && g.G(str.charAt(i2)) == 0) {
            i2++;
        }
        this.zaD = i2;
        this.length = i2 - this.offset;
        this.Ual = g.o(str, this.offset, this.length, BuildConfig.COMMAND) ? (byte) 10 : 0;
        AppMethodBeat.o(225665);
    }

    private final void hY(String str, int i2) {
        AppMethodBeat.i(225666);
        this.Uam = i2;
        this.length = 0;
        int i3 = i2 + 1;
        int i4 = i3;
        while (str.charAt(i3) != '\"') {
            if (str.charAt(i3) == '\\') {
                bd(str, i4, i3);
                i3 = hZ(str, i3 + 1);
                i4 = i3;
            } else {
                i3++;
                if (i3 >= str.length()) {
                    ib("EOF", i3);
                    AppMethodBeat.o(225666);
                    throw null;
                }
            }
        }
        if (i4 == i2 + 1) {
            this.offset = i4;
            this.length = i3 - i4;
        } else {
            bd(str, i4, i3);
            this.offset = -1;
        }
        this.zaD = i3 + 1;
        this.Ual = 1;
        AppMethodBeat.o(225666);
    }

    private final int hZ(String str, int i2) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(225667);
        if (i2 < str.length()) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            ib("Unexpected EOF after escape character", i2);
            AppMethodBeat.o(225667);
            throw null;
        }
        int i3 = i2 + 1;
        char charAt = str.charAt(i2);
        if (charAt == 'u') {
            int ia = ia(str, i3);
            AppMethodBeat.o(225667);
            return ia;
        }
        char awf = g.awf(charAt);
        if (awf == 0) {
            z2 = false;
        }
        if (!z2) {
            ib("Invalid escaped char '" + charAt + '\'', i3);
            AppMethodBeat.o(225667);
            throw null;
        }
        append(awf);
        AppMethodBeat.o(225667);
        return i3;
    }

    private final int ia(String str, int i2) {
        AppMethodBeat.i(225668);
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int i5 = i4 + 1;
        int ic = (ic(str, i3) << 8) + (ic(str, i2) << 12) + (ic(str, i4) << 4);
        int i6 = i5 + 1;
        append((char) (ic + ic(str, i5)));
        AppMethodBeat.o(225668);
        return i6;
    }

    public final void hPd() {
        boolean z;
        AppMethodBeat.i(225669);
        if (this.Ual == 6 || this.Ual == 8) {
            ArrayList arrayList = new ArrayList();
            do {
                switch (this.Ual) {
                    case 6:
                    case 8:
                        arrayList.add(Byte.valueOf(this.Ual));
                        break;
                    case 7:
                        if (((Number) kotlin.a.j.ku(arrayList)).byteValue() == 6) {
                            arrayList.remove(arrayList.size() - 1);
                            break;
                        } else {
                            e af = kotlinx.a.c.l.af(this.zaD, "found } instead of ]", this.source);
                            AppMethodBeat.o(225669);
                            throw af;
                        }
                    case 9:
                        if (((Number) kotlin.a.j.ku(arrayList)).byteValue() == 8) {
                            arrayList.remove(arrayList.size() - 1);
                            break;
                        } else {
                            e af2 = kotlinx.a.c.l.af(this.zaD, "found ] instead of }", this.source);
                            AppMethodBeat.o(225669);
                            throw af2;
                        }
                }
                hPc();
                if (!arrayList.isEmpty()) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
            } while (z);
            AppMethodBeat.o(225669);
            return;
        }
        hPc();
        AppMethodBeat.o(225669);
    }

    public final String toString() {
        AppMethodBeat.i(225670);
        String str = "JsonReader(source='" + this.source + "', currentPosition=" + this.zaD + ", tokenClass=" + ((int) this.Ual) + ", tokenPosition=" + this.Uam + ", offset=" + this.offset + ')';
        AppMethodBeat.o(225670);
        return str;
    }

    public static /* synthetic */ Void a(f fVar, String str) {
        AppMethodBeat.i(225672);
        Void ib = fVar.ib(str, fVar.zaD);
        AppMethodBeat.o(225672);
        return ib;
    }

    public final Void ib(String str, int i2) {
        AppMethodBeat.i(225671);
        p.h(str, "message");
        e af = kotlinx.a.c.l.af(i2, str, this.source);
        AppMethodBeat.o(225671);
        throw af;
    }

    private final int ic(String str, int i2) {
        boolean z;
        AppMethodBeat.i(225673);
        if (i2 < str.length()) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            ib("Unexpected EOF during unicode escape", i2);
            AppMethodBeat.o(225673);
            throw null;
        }
        char charAt = str.charAt(i2);
        if ('0' <= charAt && '9' >= charAt) {
            int i3 = charAt - '0';
            AppMethodBeat.o(225673);
            return i3;
        } else if ('a' <= charAt && 'f' >= charAt) {
            int i4 = (charAt - 'a') + 10;
            AppMethodBeat.o(225673);
            return i4;
        } else if ('A' <= charAt && 'F' >= charAt) {
            int i5 = (charAt - 'A') + 10;
            AppMethodBeat.o(225673);
            return i5;
        } else {
            a(this, "Invalid toHexChar char '" + charAt + "' in unicode escape");
            AppMethodBeat.o(225673);
            throw null;
        }
    }
}
