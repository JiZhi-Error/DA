package com.google.b.d;

import com.google.b.b.b;
import com.google.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.Map;

public final class d extends o {

    /* access modifiers changed from: package-private */
    public enum a {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1;

        public static a valueOf(String str) {
            AppMethodBeat.i(12218);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(12218);
            return aVar;
        }

        static {
            AppMethodBeat.i(12219);
            AppMethodBeat.o(12219);
        }
    }

    @Override // com.google.b.d.o, com.google.b.g
    public final b a(String str, com.google.b.a aVar, int i2, int i3, Map<c, ?> map) {
        AppMethodBeat.i(12378);
        if (aVar != com.google.b.a.CODE_128) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(aVar)));
            AppMethodBeat.o(12378);
            throw illegalArgumentException;
        }
        b a2 = super.a(str, aVar, i2, i3, map);
        AppMethodBeat.o(12378);
        return a2;
    }

    @Override // com.google.b.d.o
    public final boolean[] ct(String str) {
        int i2;
        int i3;
        int i4 = 0;
        AppMethodBeat.i(12379);
        int length = str.length();
        if (length <= 0 || length > 80) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(length)));
            AppMethodBeat.o(12379);
            throw illegalArgumentException;
        }
        for (int i5 = 0; i5 < length; i5++) {
            char charAt = str.charAt(i5);
            if (charAt < ' ' || charAt > '~') {
                switch (charAt) {
                    default:
                        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Bad character in input: ".concat(String.valueOf(charAt)));
                        AppMethodBeat.o(12379);
                        throw illegalArgumentException2;
                    case TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID /*{ENCODED_INT: 241}*/:
                    case 242:
                    case com.tencent.mm.plugin.appbrand.jsapi.o.b.d.CTRL_INDEX /*{ENCODED_INT: 243}*/:
                    case 244:
                        break;
                }
            }
        }
        ArrayList<int[]> arrayList = new ArrayList();
        int i6 = 0;
        int i7 = 0;
        int i8 = 1;
        int i9 = 0;
        while (i6 < length) {
            int c2 = c(str, i6, i7);
            if (c2 == i7) {
                switch (str.charAt(i6)) {
                    case TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID /*{ENCODED_INT: 241}*/:
                        i2 = 102;
                        break;
                    case 242:
                        i2 = 97;
                        break;
                    case com.tencent.mm.plugin.appbrand.jsapi.o.b.d.CTRL_INDEX /*{ENCODED_INT: 243}*/:
                        i2 = 96;
                        break;
                    case 244:
                        i2 = 100;
                        break;
                    default:
                        if (i7 == 100) {
                            i2 = str.charAt(i6) - ' ';
                            break;
                        } else {
                            i2 = Integer.parseInt(str.substring(i6, i6 + 2));
                            i6++;
                            break;
                        }
                }
                i6++;
                c2 = i7;
            } else if (i7 == 0) {
                i2 = c2 == 100 ? 104 : 105;
            } else {
                i2 = c2;
            }
            arrayList.add(c.ceh[i2]);
            i9 += i2 * i8;
            if (i6 != 0) {
                i3 = i8 + 1;
            } else {
                i3 = i8;
            }
            i7 = c2;
            i8 = i3;
        }
        arrayList.add(c.ceh[i9 % 103]);
        arrayList.add(c.ceh[106]);
        int i10 = 0;
        for (int[] iArr : arrayList) {
            for (int i11 : iArr) {
                i10 += i11;
            }
        }
        boolean[] zArr = new boolean[i10];
        for (int[] iArr2 : arrayList) {
            i4 += a(zArr, i4, iArr2, true);
        }
        AppMethodBeat.o(12379);
        return zArr;
    }

    private static a d(CharSequence charSequence, int i2) {
        AppMethodBeat.i(12380);
        int length = charSequence.length();
        if (i2 >= length) {
            a aVar = a.UNCODABLE;
            AppMethodBeat.o(12380);
            return aVar;
        }
        char charAt = charSequence.charAt(i2);
        if (charAt == 241) {
            a aVar2 = a.FNC_1;
            AppMethodBeat.o(12380);
            return aVar2;
        } else if (charAt < '0' || charAt > '9') {
            a aVar3 = a.UNCODABLE;
            AppMethodBeat.o(12380);
            return aVar3;
        } else if (i2 + 1 >= length) {
            a aVar4 = a.ONE_DIGIT;
            AppMethodBeat.o(12380);
            return aVar4;
        } else {
            char charAt2 = charSequence.charAt(i2 + 1);
            if (charAt2 < '0' || charAt2 > '9') {
                a aVar5 = a.ONE_DIGIT;
                AppMethodBeat.o(12380);
                return aVar5;
            }
            a aVar6 = a.TWO_DIGITS;
            AppMethodBeat.o(12380);
            return aVar6;
        }
    }

    private static int c(CharSequence charSequence, int i2, int i3) {
        a d2;
        AppMethodBeat.i(12381);
        a d3 = d(charSequence, i2);
        if (d3 == a.UNCODABLE || d3 == a.ONE_DIGIT) {
            AppMethodBeat.o(12381);
            return 100;
        } else if (i3 == 99) {
            AppMethodBeat.o(12381);
            return i3;
        } else if (i3 != 100) {
            if (d3 == a.FNC_1) {
                d3 = d(charSequence, i2 + 1);
            }
            if (d3 == a.TWO_DIGITS) {
                AppMethodBeat.o(12381);
                return 99;
            }
            AppMethodBeat.o(12381);
            return 100;
        } else if (d3 == a.FNC_1) {
            AppMethodBeat.o(12381);
            return i3;
        } else {
            a d4 = d(charSequence, i2 + 2);
            if (d4 == a.UNCODABLE || d4 == a.ONE_DIGIT) {
                AppMethodBeat.o(12381);
                return i3;
            } else if (d4 != a.FNC_1) {
                int i4 = i2 + 4;
                while (true) {
                    d2 = d(charSequence, i4);
                    if (d2 != a.TWO_DIGITS) {
                        break;
                    }
                    i4 += 2;
                }
                if (d2 == a.ONE_DIGIT) {
                    AppMethodBeat.o(12381);
                    return 100;
                }
                AppMethodBeat.o(12381);
                return 99;
            } else if (d(charSequence, i2 + 3) == a.TWO_DIGITS) {
                AppMethodBeat.o(12381);
                return 99;
            } else {
                AppMethodBeat.o(12381);
                return 100;
            }
        }
    }
}
