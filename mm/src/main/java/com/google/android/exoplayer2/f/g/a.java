package com.google.android.exoplayer2.f.g;

import android.text.TextUtils;
import com.google.android.exoplayer2.i.e;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* access modifiers changed from: package-private */
public final class a {
    private static final Pattern bDt = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private final m bDu = new m();
    private final StringBuilder bDv = new StringBuilder();

    static {
        AppMethodBeat.i(92883);
        AppMethodBeat.o(92883);
    }

    public a() {
        AppMethodBeat.i(92876);
        AppMethodBeat.o(92876);
    }

    public final d C(m mVar) {
        String str;
        String sb;
        AppMethodBeat.i(92877);
        this.bDv.setLength(0);
        int i2 = mVar.position;
        do {
        } while (!TextUtils.isEmpty(mVar.readLine()));
        this.bDu.n(mVar.data, mVar.position);
        this.bDu.setPosition(i2);
        m mVar2 = this.bDu;
        StringBuilder sb2 = this.bDv;
        D(mVar2);
        if (mVar2.xd() < 5) {
            str = null;
        } else if (!"::cue".equals(mVar2.readString(5))) {
            str = null;
        } else {
            int i3 = mVar2.position;
            String a2 = a(mVar2, sb2);
            if (a2 == null) {
                str = null;
            } else if ("{".equals(a2)) {
                mVar2.setPosition(i3);
                str = "";
            } else {
                str = null;
                if ("(".equals(a2)) {
                    int i4 = mVar2.position;
                    int i5 = mVar2.limit;
                    int i6 = i4;
                    boolean z = false;
                    while (i6 < i5 && !z) {
                        int i7 = i6 + 1;
                        boolean z2 = ((char) mVar2.data[i6]) == ')';
                        i6 = i7;
                        z = z2;
                    }
                    str = mVar2.readString((i6 - 1) - mVar2.position).trim();
                }
                String a3 = a(mVar2, sb2);
                if (!")".equals(a3) || a3 == null) {
                    str = null;
                }
            }
        }
        if (str == null || !"{".equals(a(this.bDu, this.bDv))) {
            AppMethodBeat.o(92877);
            return null;
        }
        d dVar = new d();
        if (!"".equals(str)) {
            int indexOf = str.indexOf(91);
            if (indexOf != -1) {
                Matcher matcher = bDt.matcher(str.substring(indexOf));
                if (matcher.matches()) {
                    dVar.bDC = matcher.group(1);
                }
                str = str.substring(0, indexOf);
            }
            String[] split = str.split("\\.");
            String str2 = split[0];
            int indexOf2 = str2.indexOf(35);
            if (indexOf2 != -1) {
                dVar.bDA = str2.substring(0, indexOf2);
                dVar.aQa = str2.substring(indexOf2 + 1);
            } else {
                dVar.bDA = str2;
            }
            if (split.length > 1) {
                dVar.bDB = Arrays.asList((String[]) Arrays.copyOfRange(split, 1, split.length));
            }
        }
        String str3 = null;
        boolean z3 = false;
        while (!z3) {
            int i8 = this.bDu.position;
            str3 = a(this.bDu, this.bDv);
            z3 = str3 == null || "}".equals(str3);
            if (!z3) {
                this.bDu.setPosition(i8);
                m mVar3 = this.bDu;
                StringBuilder sb3 = this.bDv;
                D(mVar3);
                String b2 = b(mVar3, sb3);
                if (!"".equals(b2) && ":".equals(a(mVar3, sb3))) {
                    D(mVar3);
                    StringBuilder sb4 = new StringBuilder();
                    boolean z4 = false;
                    while (true) {
                        if (z4) {
                            sb = sb4.toString();
                            break;
                        }
                        int i9 = mVar3.position;
                        String a4 = a(mVar3, sb3);
                        if (a4 == null) {
                            sb = null;
                            break;
                        } else if ("}".equals(a4) || ";".equals(a4)) {
                            mVar3.setPosition(i9);
                            z4 = true;
                        } else {
                            sb4.append(a4);
                        }
                    }
                    if (sb != null && !"".equals(sb)) {
                        int i10 = mVar3.position;
                        String a5 = a(mVar3, sb3);
                        if (!";".equals(a5)) {
                            if ("}".equals(a5)) {
                                mVar3.setPosition(i10);
                            }
                        }
                        if ("color".equals(b2)) {
                            dVar.bCV = e.bw(sb);
                            dVar.bCW = true;
                        } else if ("background-color".equals(b2)) {
                            dVar.backgroundColor = e.bw(sb);
                            dVar.bCX = true;
                        } else if ("text-decoration".equals(b2)) {
                            if ("underline".equals(sb)) {
                                dVar.bCZ = 1;
                            }
                        } else if ("font-family".equals(b2)) {
                            dVar.fontFamily = x.bH(sb);
                        } else if ("font-weight".equals(b2)) {
                            if ("bold".equals(sb)) {
                                dVar.bDa = 1;
                            }
                        } else if ("font-style".equals(b2) && "italic".equals(sb)) {
                            dVar.bDb = 1;
                        }
                    }
                }
            }
        }
        if ("}".equals(str3)) {
            AppMethodBeat.o(92877);
            return dVar;
        }
        AppMethodBeat.o(92877);
        return null;
    }

    private static void D(m mVar) {
        AppMethodBeat.i(92878);
        boolean z = true;
        while (mVar.xd() > 0 && z) {
            z = E(mVar) || F(mVar);
        }
        AppMethodBeat.o(92878);
    }

    private static String a(m mVar, StringBuilder sb) {
        AppMethodBeat.i(92879);
        D(mVar);
        if (mVar.xd() == 0) {
            AppMethodBeat.o(92879);
            return null;
        }
        String b2 = b(mVar, sb);
        if (!"".equals(b2)) {
            AppMethodBeat.o(92879);
            return b2;
        }
        String sb2 = new StringBuilder().append((char) mVar.readUnsignedByte()).toString();
        AppMethodBeat.o(92879);
        return sb2;
    }

    private static String b(m mVar, StringBuilder sb) {
        boolean z = false;
        AppMethodBeat.i(92882);
        sb.setLength(0);
        int i2 = mVar.position;
        int i3 = mVar.limit;
        while (i2 < i3 && !z) {
            char c2 = (char) mVar.data[i2];
            if ((c2 < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !((c2 >= '0' && c2 <= '9') || c2 == '#' || c2 == '-' || c2 == '.' || c2 == '_'))) {
                z = true;
            } else {
                i2++;
                sb.append(c2);
            }
        }
        mVar.eZ(i2 - mVar.position);
        String sb2 = sb.toString();
        AppMethodBeat.o(92882);
        return sb2;
    }

    private static boolean E(m mVar) {
        AppMethodBeat.i(92880);
        switch ((char) mVar.data[mVar.position]) {
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
                mVar.eZ(1);
                AppMethodBeat.o(92880);
                return true;
            default:
                AppMethodBeat.o(92880);
                return false;
        }
    }

    private static boolean F(m mVar) {
        AppMethodBeat.i(92881);
        int i2 = mVar.position;
        int i3 = mVar.limit;
        byte[] bArr = mVar.data;
        if (i2 + 2 <= i3) {
            int i4 = i2 + 1;
            if (bArr[i2] == 47) {
                int i5 = i4 + 1;
                if (bArr[i4] == 42) {
                    while (i5 + 1 < i3) {
                        int i6 = i5 + 1;
                        if (((char) bArr[i5]) == '*' && ((char) bArr[i6]) == '/') {
                            int i7 = i6 + 1;
                            i3 = i7;
                            i5 = i7;
                        } else {
                            i5 = i6;
                        }
                    }
                    mVar.eZ(i3 - mVar.position);
                    AppMethodBeat.o(92881);
                    return true;
                }
            }
        }
        AppMethodBeat.o(92881);
        return false;
    }
}
