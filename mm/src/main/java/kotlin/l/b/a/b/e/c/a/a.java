package kotlin.l.b.a.b.e.c.a;

import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPOptionalID;
import kotlin.aa;
import kotlin.g.b.p;

public class a {
    static final /* synthetic */ boolean $assertionsDisabled = (!a.class.desiredAssertionStatus());
    private static final boolean TCv;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(59225);
        switch (i2) {
            case 1:
            case 3:
            case 6:
            case 8:
            case 10:
            case 12:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 2:
            case 4:
            case 5:
            case 7:
            case 9:
            case 11:
            case 13:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 1:
            case 3:
            case 6:
            case 8:
            case 10:
            case 12:
            case 14:
                i3 = 2;
                break;
            case 2:
            case 4:
            case 5:
            case 7:
            case 9:
            case 11:
            case 13:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 3:
            case 6:
            case 8:
            case 10:
            case 12:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
                break;
            case 2:
            case 4:
            case 5:
            case 7:
            case 9:
            case 11:
            case 13:
            default:
                objArr[0] = "data";
                break;
        }
        switch (i2) {
            case 1:
                objArr[1] = "encodeBytes";
                break;
            case 2:
            case 4:
            case 5:
            case 7:
            case 9:
            case 11:
            case 13:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/BitEncoding";
                break;
            case 3:
                objArr[1] = "encode8to7";
                break;
            case 6:
                objArr[1] = "splitBytesToStringArray";
                break;
            case 8:
                objArr[1] = "decodeBytes";
                break;
            case 10:
                objArr[1] = "dropMarker";
                break;
            case 12:
                objArr[1] = "combineStringArrayIntoBytes";
                break;
            case 14:
                objArr[1] = "decode7to8";
                break;
        }
        switch (i2) {
            case 1:
            case 3:
            case 6:
            case 8:
            case 10:
            case 12:
            case 14:
                break;
            case 2:
                objArr[2] = "encode8to7";
                break;
            case 4:
                objArr[2] = "addModuloByte";
                break;
            case 5:
                objArr[2] = "splitBytesToStringArray";
                break;
            case 7:
                objArr[2] = "decodeBytes";
                break;
            case 9:
                objArr[2] = "dropMarker";
                break;
            case 11:
                objArr[2] = "combineStringArrayIntoBytes";
                break;
            case 13:
                objArr[2] = "decode7to8";
                break;
            default:
                objArr[2] = "encodeBytes";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 1:
            case 3:
            case 6:
            case 8:
            case 10:
            case 12:
            case 14:
                illegalStateException = new IllegalStateException(format);
                break;
            case 2:
            case 4:
            case 5:
            case 7:
            case 9:
            case 11:
            case 13:
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(59225);
        throw illegalStateException;
    }

    static {
        String str;
        AppMethodBeat.i(59224);
        try {
            str = System.getProperty("kotlin.jvm.serialization.use8to7");
        } catch (SecurityException e2) {
            str = null;
        }
        TCv = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(str);
        AppMethodBeat.o(59224);
    }

    private a() {
    }

    private static void dg(byte[] bArr) {
        AppMethodBeat.i(59219);
        if (bArr == null) {
            atM(4);
        }
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = (byte) ((bArr[i2] + Byte.MAX_VALUE) & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH);
        }
        AppMethodBeat.o(59219);
    }

    public static byte[] al(String[] strArr) {
        int i2;
        boolean z = false;
        AppMethodBeat.i(59220);
        if (strArr == null) {
            atM(7);
        }
        if (strArr.length > 0 && !strArr[0].isEmpty()) {
            char charAt = strArr[0].charAt(0);
            if (charAt == 0) {
                String[] am = am(strArr);
                p.h(am, "strings");
                int i3 = 0;
                for (String str : am) {
                    i3 += str.length();
                }
                byte[] bArr = new byte[i3];
                int i4 = 0;
                for (String str2 : am) {
                    int length = str2.length() - 1;
                    if (length >= 0) {
                        int i5 = 0;
                        while (true) {
                            i2 = i4 + 1;
                            bArr[i4] = (byte) str2.charAt(i5);
                            if (i5 == length) {
                                break;
                            }
                            i5++;
                            i4 = i2;
                        }
                    } else {
                        i2 = i4;
                    }
                    i4 = i2;
                }
                if (i4 == bArr.length) {
                    z = true;
                }
                if (!aa.SXc || z) {
                    AppMethodBeat.o(59220);
                    return bArr;
                }
                AssertionError assertionError = new AssertionError("Should have reached the end");
                AppMethodBeat.o(59220);
                throw assertionError;
            } else if (charAt == 65535) {
                strArr = am(strArr);
            }
        }
        byte[] an = an(strArr);
        dg(an);
        byte[] dh = dh(an);
        AppMethodBeat.o(59220);
        return dh;
    }

    private static String[] am(String[] strArr) {
        AppMethodBeat.i(59221);
        if (strArr == null) {
            atM(9);
        }
        String[] strArr2 = (String[]) strArr.clone();
        strArr2[0] = strArr2[0].substring(1);
        if (strArr2 == null) {
            atM(10);
        }
        AppMethodBeat.o(59221);
        return strArr2;
    }

    private static byte[] an(String[] strArr) {
        AppMethodBeat.i(59222);
        if (strArr == null) {
            atM(11);
        }
        int i2 = 0;
        for (String str : strArr) {
            if ($assertionsDisabled || str.length() <= 65535) {
                i2 += str.length();
            } else {
                AssertionError assertionError = new AssertionError("String is too long: " + str.length());
                AppMethodBeat.o(59222);
                throw assertionError;
            }
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        for (String str2 : strArr) {
            int length = str2.length();
            int i4 = 0;
            while (i4 < length) {
                bArr[i3] = (byte) str2.charAt(i4);
                i4++;
                i3++;
            }
        }
        AppMethodBeat.o(59222);
        return bArr;
    }

    private static byte[] dh(byte[] bArr) {
        AppMethodBeat.i(59223);
        if (bArr == null) {
            atM(13);
        }
        int length = (bArr.length * 7) / 8;
        byte[] bArr2 = new byte[length];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            i3++;
            bArr2[i4] = (byte) (((bArr[i3] & 255) >>> i2) + ((bArr[i3] & ((1 << (i2 + 1)) - 1)) << (7 - i2)));
            if (i2 == 6) {
                i3++;
                i2 = 0;
            } else {
                i2++;
            }
        }
        AppMethodBeat.o(59223);
        return bArr2;
    }
}
