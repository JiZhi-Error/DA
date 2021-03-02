package com.google.a;

import com.facebook.appevents.AppEventsConstants;
import com.google.a.by;
import com.google.a.bz;
import com.google.a.cc;
import com.google.a.l;
import com.qq.taf.jce.JceStruct;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public final class bx {
    private static final b bZt;
    private static final Logger logger = Logger.getLogger(bx.class.getName());

    static /* synthetic */ void a(int i2, Object obj, d dVar) {
        switch (cj.gX(i2)) {
            case 0:
                dVar.u(aG(((Long) obj).longValue()));
                return;
            case 1:
                dVar.u(String.format(null, "0x%016x", (Long) obj));
                return;
            case 2:
                try {
                    cc f2 = cc.f((g) obj);
                    dVar.u("{");
                    dVar.HI();
                    dVar.HG();
                    c.bZC.a((c) f2, (cc) dVar);
                    dVar.HH();
                    dVar.u("}");
                    return;
                } catch (af e2) {
                    dVar.u("\"");
                    dVar.u(by.e((g) obj));
                    dVar.u("\"");
                    return;
                }
            case 3:
                c.bZC.a((c) ((cc) obj), (cc) dVar);
                return;
            case 4:
            default:
                throw new IllegalArgumentException("Bad tag: ".concat(String.valueOf(i2)));
            case 5:
                dVar.u(String.format(null, "0x%08x", (Integer) obj));
                return;
        }
    }

    private bx() {
    }

    static {
        b.a aVar = new b.a();
        bZt = new b(aVar.bZu, aVar.bZv, aVar.bZw, aVar.bZx, aVar.bZy, (byte) 0);
    }

    public static String a(az azVar) {
        try {
            StringBuilder sb = new StringBuilder();
            c.bZC.a((c) azVar, (az) b(sb));
            return sb.toString();
        } catch (IOException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static String ab(cc ccVar) {
        try {
            StringBuilder sb = new StringBuilder();
            c.bZC.a((c) ccVar, (cc) b(sb));
            return sb.toString();
        } catch (IOException e2) {
            throw new IllegalStateException(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c {
        static final c bZC = new c(true);
        static final c bZD = new c(false);
        private final boolean bZE;

        private c(boolean z) {
            this.bZE = z;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void a(az azVar, d dVar) {
            for (Map.Entry<l.f, Object> entry : azVar.FS().entrySet()) {
                l.f key = entry.getKey();
                Object value = entry.getValue();
                if (key.FJ()) {
                    for (Object obj : (List) value) {
                        a(key, obj, dVar);
                    }
                } else {
                    a(key, value, dVar);
                }
            }
            a(azVar.Ax(), dVar);
        }

        private void b(l.f fVar, Object obj, d dVar) {
            String replace;
            switch (fVar.bSS) {
                case INT32:
                case SINT32:
                case SFIXED32:
                    dVar.u(((Integer) obj).toString());
                    return;
                case INT64:
                case SINT64:
                case SFIXED64:
                    dVar.u(((Long) obj).toString());
                    return;
                case BOOL:
                    dVar.u(((Boolean) obj).toString());
                    return;
                case FLOAT:
                    dVar.u(((Float) obj).toString());
                    return;
                case DOUBLE:
                    dVar.u(((Double) obj).toString());
                    return;
                case UINT32:
                case FIXED32:
                    dVar.u(bx.gP(((Integer) obj).intValue()));
                    return;
                case UINT64:
                case FIXED64:
                    dVar.u(bx.aG(((Long) obj).longValue()));
                    return;
                case STRING:
                    dVar.u("\"");
                    if (this.bZE) {
                        replace = by.e(g.bZ((String) obj));
                    } else {
                        replace = bx.cl((String) obj).replace("\n", "\\n");
                    }
                    dVar.u(replace);
                    dVar.u("\"");
                    return;
                case BYTES:
                    dVar.u("\"");
                    if (obj instanceof g) {
                        dVar.u(bx.e((g) obj));
                    } else {
                        dVar.u(bx.H((byte[]) obj));
                    }
                    dVar.u("\"");
                    return;
                case ENUM:
                    dVar.u(((l.e) obj).bSM.getName());
                    return;
                case MESSAGE:
                case GROUP:
                    a((at) obj, dVar);
                    return;
                default:
                    return;
            }
        }

        private static void a(int i2, int i3, List<?> list, d dVar) {
            for (Object obj : list) {
                dVar.u(String.valueOf(i2));
                dVar.u(": ");
                bx.a(i3, obj, dVar);
                dVar.HI();
            }
        }

        private void a(l.f fVar, Object obj, d dVar) {
            if (fVar.bSP.Cp()) {
                dVar.u("[");
                if (!fVar.bSs.bSq.AG().bRt || fVar.bSS != l.f.b.MESSAGE || !fVar.FI() || fVar.FM() != fVar.FN()) {
                    dVar.u(fVar.fullName);
                } else {
                    dVar.u(fVar.FN().fullName);
                }
                dVar.u("]");
            } else if (fVar.bSS == l.f.b.GROUP) {
                dVar.u(fVar.FN().bSq.getName());
            } else {
                dVar.u(fVar.bSP.getName());
            }
            if (fVar.bSS.bTz == l.f.a.MESSAGE) {
                dVar.u(" {");
                dVar.HI();
                dVar.HG();
            } else {
                dVar.u(": ");
            }
            b(fVar, obj, dVar);
            if (fVar.bSS.bTz == l.f.a.MESSAGE) {
                dVar.HH();
                dVar.u("}");
            }
            dVar.HI();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void a(cc ccVar, d dVar) {
            for (Map.Entry<Integer, cc.b> entry : ccVar.bZN.entrySet()) {
                int intValue = entry.getKey().intValue();
                cc.b value = entry.getValue();
                a(intValue, 0, value.bZT, dVar);
                a(intValue, 5, value.bZU, dVar);
                a(intValue, 1, value.bZV, dVar);
                a(intValue, 2, value.bZW, dVar);
                for (cc ccVar2 : value.bZX) {
                    dVar.u(entry.getKey().toString());
                    dVar.u(" {");
                    dVar.HI();
                    dVar.HG();
                    a(ccVar2, dVar);
                    dVar.HH();
                    dVar.u("}");
                    dVar.HI();
                }
            }
        }
    }

    public static String gP(int i2) {
        if (i2 >= 0) {
            return Integer.toString(i2);
        }
        return Long.toString(((long) i2) & Util.MAX_32BIT_VALUE);
    }

    public static String aG(long j2) {
        if (j2 >= 0) {
            return Long.toString(j2);
        }
        return BigInteger.valueOf(MAlarmHandler.NEXT_FIRE_INTERVAL & j2).setBit(63).toString();
    }

    private static d b(Appendable appendable) {
        return new d(appendable, (byte) 0);
    }

    /* access modifiers changed from: package-private */
    public static final class d {
        private final Appendable bZF;
        private final StringBuilder bZG;
        private final boolean bZH;
        private boolean bZI;

        /* synthetic */ d(Appendable appendable, byte b2) {
            this(appendable);
        }

        private d(Appendable appendable) {
            this.bZG = new StringBuilder();
            this.bZI = false;
            this.bZF = appendable;
            this.bZH = false;
        }

        public final void HG() {
            this.bZG.append("  ");
        }

        public final void HH() {
            int length = this.bZG.length();
            if (length == 0) {
                throw new IllegalArgumentException(" Outdent() without matching Indent().");
            }
            this.bZG.setLength(length - 2);
        }

        public final void u(CharSequence charSequence) {
            if (this.bZI) {
                this.bZI = false;
                this.bZF.append(this.bZH ? " " : this.bZG);
            }
            this.bZF.append(charSequence);
        }

        public final void HI() {
            if (!this.bZH) {
                this.bZF.append("\n");
            }
            this.bZI = true;
        }
    }

    public static class b {
        private final boolean bZu;
        private final boolean bZv;
        private final boolean bZw;
        private final EnumC0089b bZx;
        private bz.a bZy;

        public static class a {
            boolean bZu = false;
            boolean bZv = false;
            boolean bZw = false;
            EnumC0089b bZx = EnumC0089b.ALLOW_SINGULAR_OVERWRITES;
            bz.a bZy = null;
        }

        /* renamed from: com.google.a.bx$b$b  reason: collision with other inner class name */
        public enum EnumC0089b {
            ALLOW_SINGULAR_OVERWRITES,
            FORBID_SINGULAR_OVERWRITES
        }

        /* synthetic */ b(boolean z, boolean z2, boolean z3, EnumC0089b bVar, bz.a aVar, byte b2) {
            this(z, z2, z3, bVar, aVar);
        }

        private b(boolean z, boolean z2, boolean z3, EnumC0089b bVar, bz.a aVar) {
            this.bZu = z;
            this.bZv = z2;
            this.bZw = z3;
            this.bZx = bVar;
            this.bZy = aVar;
        }
    }

    public static String e(g gVar) {
        return by.e(gVar);
    }

    public static g t(CharSequence charSequence) {
        int i2;
        g bZ = g.bZ(charSequence.toString());
        byte[] bArr = new byte[bZ.size()];
        int i3 = 0;
        for (int i4 = 0; i4 < bZ.size(); i4 = i2 + 1) {
            byte fB = bZ.fB(i4);
            if (fB != 92) {
                bArr[i3] = fB;
                i2 = i4;
                i3++;
            } else if (i4 + 1 < bZ.size()) {
                i2 = i4 + 1;
                byte fB2 = bZ.fB(i2);
                if (e(fB2)) {
                    int g2 = g(fB2);
                    if (i2 + 1 < bZ.size() && e(bZ.fB(i2 + 1))) {
                        i2++;
                        g2 = (g2 * 8) + g(bZ.fB(i2));
                    }
                    if (i2 + 1 < bZ.size() && e(bZ.fB(i2 + 1))) {
                        i2++;
                        g2 = (g2 * 8) + g(bZ.fB(i2));
                    }
                    bArr[i3] = (byte) g2;
                    i3++;
                } else {
                    switch (fB2) {
                        case 34:
                            bArr[i3] = 34;
                            i3++;
                            continue;
                        case 39:
                            bArr[i3] = 39;
                            i3++;
                            continue;
                        case 92:
                            bArr[i3] = 92;
                            i3++;
                            continue;
                        case PlayerException.EXCEPTION_IN_RELEASE /*{ENCODED_INT: 97}*/:
                            bArr[i3] = 7;
                            i3++;
                            continue;
                        case 98:
                            bArr[i3] = 8;
                            i3++;
                            continue;
                        case 102:
                            bArr[i3] = JceStruct.ZERO_TAG;
                            i3++;
                            continue;
                        case 110:
                            bArr[i3] = 10;
                            i3++;
                            continue;
                        case 114:
                            bArr[i3] = JceStruct.SIMPLE_LIST;
                            i3++;
                            continue;
                        case 116:
                            bArr[i3] = 9;
                            i3++;
                            continue;
                        case 118:
                            bArr[i3] = JceStruct.STRUCT_END;
                            i3++;
                            continue;
                        case 120:
                            if (i2 + 1 >= bZ.size() || !f(bZ.fB(i2 + 1))) {
                                throw new a("Invalid escape sequence: '\\x' with no digits");
                            }
                            i2++;
                            int g3 = g(bZ.fB(i2));
                            if (i2 + 1 < bZ.size() && f(bZ.fB(i2 + 1))) {
                                i2++;
                                g3 = (g3 * 16) + g(bZ.fB(i2));
                            }
                            bArr[i3] = (byte) g3;
                            i3++;
                            continue;
                        default:
                            throw new a("Invalid escape sequence: '\\" + ((char) fB2) + '\'');
                    }
                }
            } else {
                throw new a("Invalid escape sequence: '\\' at end of string.");
            }
        }
        if (bArr.length == i3) {
            return g.A(bArr);
        }
        return g.p(bArr, 0, i3);
    }

    public static class a extends IOException {
        a(String str) {
            super(str);
        }
    }

    private static boolean e(byte b2) {
        return 48 <= b2 && b2 <= 55;
    }

    private static boolean f(byte b2) {
        return (48 <= b2 && b2 <= 57) || (97 <= b2 && b2 <= 102) || (65 <= b2 && b2 <= 70);
    }

    private static int g(byte b2) {
        if (48 <= b2 && b2 <= 57) {
            return b2 - 48;
        }
        if (97 > b2 || b2 > 122) {
            return (b2 - 65) + 10;
        }
        return (b2 - 97) + 10;
    }

    static int cm(String str) {
        return (int) b(str, true, false);
    }

    static int cn(String str) {
        return (int) b(str, false, false);
    }

    static long co(String str) {
        return b(str, true, true);
    }

    static long cp(String str) {
        return b(str, false, true);
    }

    private static long b(String str, boolean z, boolean z2) {
        boolean z3;
        int i2;
        BigInteger bigInteger;
        long j2;
        if (!str.startsWith("-", 0)) {
            z3 = false;
            i2 = 0;
        } else if (!z) {
            throw new NumberFormatException("Number must be positive: ".concat(String.valueOf(str)));
        } else {
            z3 = true;
            i2 = 1;
        }
        int i3 = 10;
        if (str.startsWith("0x", i2)) {
            i2 += 2;
            i3 = 16;
        } else if (str.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO, i2)) {
            i3 = 8;
        }
        String substring = str.substring(i2);
        if (substring.length() < 16) {
            long parseLong = Long.parseLong(substring, i3);
            if (z3) {
                j2 = -parseLong;
            } else {
                j2 = parseLong;
            }
            if (z2) {
                return j2;
            }
            if (z) {
                if (j2 <= 2147483647L && j2 >= -2147483648L) {
                    return j2;
                }
                throw new NumberFormatException("Number out of range for 32-bit signed integer: ".concat(String.valueOf(str)));
            } else if (j2 < 4294967296L && j2 >= 0) {
                return j2;
            } else {
                throw new NumberFormatException("Number out of range for 32-bit unsigned integer: ".concat(String.valueOf(str)));
            }
        } else {
            BigInteger bigInteger2 = new BigInteger(substring, i3);
            if (z3) {
                bigInteger = bigInteger2.negate();
            } else {
                bigInteger = bigInteger2;
            }
            if (!z2) {
                if (z) {
                    if (bigInteger.bitLength() > 31) {
                        throw new NumberFormatException("Number out of range for 32-bit signed integer: ".concat(String.valueOf(str)));
                    }
                } else if (bigInteger.bitLength() > 32) {
                    throw new NumberFormatException("Number out of range for 32-bit unsigned integer: ".concat(String.valueOf(str)));
                }
            } else if (z) {
                if (bigInteger.bitLength() > 63) {
                    throw new NumberFormatException("Number out of range for 64-bit signed integer: ".concat(String.valueOf(str)));
                }
            } else if (bigInteger.bitLength() > 64) {
                throw new NumberFormatException("Number out of range for 64-bit unsigned integer: ".concat(String.valueOf(str)));
            }
            return bigInteger.longValue();
        }
    }

    public static String H(byte[] bArr) {
        return by.a(new by.a(bArr) {
            /* class com.google.a.by.AnonymousClass2 */
            final /* synthetic */ byte[] bZK;

            {
                this.bZK = r1;
            }

            @Override // com.google.a.by.a
            public final int size() {
                return this.bZK.length;
            }

            @Override // com.google.a.by.a
            public final byte fB(int i2) {
                return this.bZK[i2];
            }
        });
    }

    public static String cl(String str) {
        return str.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
