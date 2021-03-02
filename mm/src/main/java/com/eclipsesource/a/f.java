package com.eclipsesource.a;

import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.io.Reader;
import java.io.StringReader;

final class f {
    private final Reader aZR;
    private final char[] aZS;
    private int aZT;
    private int aZU;
    private int aZV;
    private int aZW;
    private StringBuilder aZX;
    private int aZY;
    private int index;
    private int line;

    f(String str) {
        this(new StringReader(str), Math.max(10, Math.min(1024, str.length())));
        AppMethodBeat.i(74742);
        AppMethodBeat.o(74742);
    }

    private f(Reader reader, int i2) {
        AppMethodBeat.i(74743);
        this.aZR = reader;
        this.aZS = new char[i2];
        this.line = 1;
        this.aZY = -1;
        AppMethodBeat.o(74743);
    }

    /* access modifiers changed from: package-private */
    public final h sj() {
        AppMethodBeat.i(74744);
        switch (this.aZW) {
            case 34:
                h sq = sq();
                AppMethodBeat.o(74744);
                return sq;
            case 45:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case n.CTRL_INDEX /*{ENCODED_INT: 57}*/:
                h st = st();
                AppMethodBeat.o(74744);
                return st;
            case PlayerException.EXCEPTION_IN_PREPARE /*{ENCODED_INT: 91}*/:
                b sk = sk();
                AppMethodBeat.o(74744);
                return sk;
            case 102:
                h sp = sp();
                AppMethodBeat.o(74744);
                return sp;
            case 110:
                h sn = sn();
                AppMethodBeat.o(74744);
                return sn;
            case 116:
                h so = so();
                AppMethodBeat.o(74744);
                return so;
            case 123:
                e sl = sl();
                AppMethodBeat.o(74744);
                return sl;
            default:
                j aV = aV("value");
                AppMethodBeat.o(74744);
                throw aV;
        }
    }

    private b sk() {
        AppMethodBeat.i(74745);
        sy();
        b bVar = new b();
        sx();
        if (e(']')) {
            AppMethodBeat.o(74745);
        } else {
            do {
                sx();
                bVar.a(sj());
                sx();
            } while (e(','));
            if (!e(']')) {
                j aV = aV("',' or ']'");
                AppMethodBeat.o(74745);
                throw aV;
            }
            AppMethodBeat.o(74745);
        }
        return bVar;
    }

    private e sl() {
        AppMethodBeat.i(74746);
        sy();
        e eVar = new e();
        sx();
        if (e('}')) {
            AppMethodBeat.o(74746);
        } else {
            do {
                sx();
                String sm = sm();
                sx();
                if (!e(':')) {
                    j aV = aV("':'");
                    AppMethodBeat.o(74746);
                    throw aV;
                }
                sx();
                eVar.a(sm, sj());
                sx();
            } while (e(','));
            if (!e('}')) {
                j aV2 = aV("',' or '}'");
                AppMethodBeat.o(74746);
                throw aV2;
            }
            AppMethodBeat.o(74746);
        }
        return eVar;
    }

    private String sm() {
        AppMethodBeat.i(74747);
        if (this.aZW != 34) {
            j aV = aV("name");
            AppMethodBeat.o(74747);
            throw aV;
        }
        String sr = sr();
        AppMethodBeat.o(74747);
        return sr;
    }

    private h sn() {
        AppMethodBeat.i(74748);
        sy();
        d('u');
        d('l');
        d('l');
        h hVar = a.aZC;
        AppMethodBeat.o(74748);
        return hVar;
    }

    private h so() {
        AppMethodBeat.i(74749);
        sy();
        d('r');
        d('u');
        d('e');
        h hVar = a.aZD;
        AppMethodBeat.o(74749);
        return hVar;
    }

    private h sp() {
        AppMethodBeat.i(74750);
        sy();
        d('a');
        d('l');
        d('s');
        d('e');
        h hVar = a.aZE;
        AppMethodBeat.o(74750);
        return hVar;
    }

    private void d(char c2) {
        AppMethodBeat.i(74751);
        if (!e(c2)) {
            j aV = aV("'" + c2 + "'");
            AppMethodBeat.o(74751);
            throw aV;
        }
        AppMethodBeat.o(74751);
    }

    private h sq() {
        AppMethodBeat.i(74752);
        g gVar = new g(sr());
        AppMethodBeat.o(74752);
        return gVar;
    }

    private String sr() {
        AppMethodBeat.i(74753);
        sy();
        sz();
        while (this.aZW != 34) {
            if (this.aZW == 92) {
                sA();
                ss();
                sz();
            } else if (this.aZW < 32) {
                j aV = aV("valid string character");
                AppMethodBeat.o(74753);
                throw aV;
            } else {
                sy();
            }
        }
        String sB = sB();
        sy();
        AppMethodBeat.o(74753);
        return sB;
    }

    private void ss() {
        AppMethodBeat.i(74754);
        sy();
        switch (this.aZW) {
            case 34:
            case 47:
            case 92:
                this.aZX.append((char) this.aZW);
                break;
            case 98:
                this.aZX.append('\b');
                break;
            case 102:
                this.aZX.append('\f');
                break;
            case 110:
                this.aZX.append('\n');
                break;
            case 114:
                this.aZX.append('\r');
                break;
            case 116:
                this.aZX.append('\t');
                break;
            case 117:
                char[] cArr = new char[4];
                for (int i2 = 0; i2 < 4; i2++) {
                    sy();
                    if (!sE()) {
                        j aV = aV("hexadecimal digit");
                        AppMethodBeat.o(74754);
                        throw aV;
                    }
                    cArr[i2] = (char) this.aZW;
                }
                this.aZX.append((char) Integer.parseInt(new String(cArr), 16));
                break;
            default:
                j aV2 = aV("valid escape sequence");
                AppMethodBeat.o(74754);
                throw aV2;
        }
        sy();
        AppMethodBeat.o(74754);
    }

    private h st() {
        AppMethodBeat.i(74755);
        sz();
        e('-');
        int i2 = this.aZW;
        if (!sw()) {
            j aV = aV("digit");
            AppMethodBeat.o(74755);
            throw aV;
        }
        if (i2 != 48) {
            do {
            } while (sw());
        }
        su();
        sv();
        d dVar = new d(sB());
        AppMethodBeat.o(74755);
        return dVar;
    }

    private boolean su() {
        AppMethodBeat.i(74756);
        if (!e('.')) {
            AppMethodBeat.o(74756);
            return false;
        } else if (!sw()) {
            j aV = aV("digit");
            AppMethodBeat.o(74756);
            throw aV;
        } else {
            do {
            } while (sw());
            AppMethodBeat.o(74756);
            return true;
        }
    }

    private boolean sv() {
        AppMethodBeat.i(74757);
        if (e('e') || e('E')) {
            if (!e('+')) {
                e('-');
            }
            if (!sw()) {
                j aV = aV("digit");
                AppMethodBeat.o(74757);
                throw aV;
            }
            do {
            } while (sw());
            AppMethodBeat.o(74757);
            return true;
        }
        AppMethodBeat.o(74757);
        return false;
    }

    private boolean e(char c2) {
        AppMethodBeat.i(74758);
        if (this.aZW != c2) {
            AppMethodBeat.o(74758);
            return false;
        }
        sy();
        AppMethodBeat.o(74758);
        return true;
    }

    private boolean sw() {
        AppMethodBeat.i(74759);
        if (!sD()) {
            AppMethodBeat.o(74759);
            return false;
        }
        sy();
        AppMethodBeat.o(74759);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void sx() {
        AppMethodBeat.i(74760);
        while (sC()) {
            sy();
        }
        AppMethodBeat.o(74760);
    }

    /* access modifiers changed from: package-private */
    public final void sy() {
        AppMethodBeat.i(74761);
        if (this.index == this.aZU) {
            if (this.aZY != -1) {
                this.aZX.append(this.aZS, this.aZY, this.aZU - this.aZY);
                this.aZY = 0;
            }
            this.aZT += this.aZU;
            this.aZU = this.aZR.read(this.aZS, 0, this.aZS.length);
            this.index = 0;
            if (this.aZU == -1) {
                this.aZW = -1;
                AppMethodBeat.o(74761);
                return;
            }
        }
        if (this.aZW == 10) {
            this.line++;
            this.aZV = this.aZT + this.index;
        }
        char[] cArr = this.aZS;
        int i2 = this.index;
        this.index = i2 + 1;
        this.aZW = cArr[i2];
        AppMethodBeat.o(74761);
    }

    private void sz() {
        AppMethodBeat.i(74762);
        if (this.aZX == null) {
            this.aZX = new StringBuilder();
        }
        this.aZY = this.index - 1;
        AppMethodBeat.o(74762);
    }

    private void sA() {
        AppMethodBeat.i(74763);
        int i2 = this.aZW == -1 ? this.index : this.index - 1;
        StringBuilder sb = this.aZX;
        char[] cArr = this.aZS;
        int i3 = this.aZY;
        sb.append(cArr, i3, i2 - i3);
        this.aZY = -1;
        AppMethodBeat.o(74763);
    }

    private String sB() {
        String str;
        AppMethodBeat.i(74764);
        int i2 = this.aZW == -1 ? this.index : this.index - 1;
        if (this.aZX.length() > 0) {
            StringBuilder sb = this.aZX;
            char[] cArr = this.aZS;
            int i3 = this.aZY;
            sb.append(cArr, i3, i2 - i3);
            str = this.aZX.toString();
            this.aZX.setLength(0);
        } else {
            str = new String(this.aZS, this.aZY, i2 - this.aZY);
        }
        this.aZY = -1;
        AppMethodBeat.o(74764);
        return str;
    }

    private j aV(String str) {
        AppMethodBeat.i(74765);
        if (sF()) {
            j aW = aW("Unexpected end of input");
            AppMethodBeat.o(74765);
            return aW;
        }
        j aW2 = aW("Expected ".concat(String.valueOf(str)));
        AppMethodBeat.o(74765);
        return aW2;
    }

    /* access modifiers changed from: package-private */
    public final j aW(String str) {
        AppMethodBeat.i(74766);
        int i2 = this.aZT + this.index;
        int i3 = i2 - this.aZV;
        if (!sF()) {
            i2--;
        }
        j jVar = new j(str, i2, this.line, i3 - 1);
        AppMethodBeat.o(74766);
        return jVar;
    }

    private boolean sC() {
        return this.aZW == 32 || this.aZW == 9 || this.aZW == 10 || this.aZW == 13;
    }

    private boolean sD() {
        return this.aZW >= 48 && this.aZW <= 57;
    }

    private boolean sE() {
        return (this.aZW >= 48 && this.aZW <= 57) || (this.aZW >= 97 && this.aZW <= 102) || (this.aZW >= 65 && this.aZW <= 70);
    }

    /* access modifiers changed from: package-private */
    public final boolean sF() {
        return this.aZW == -1;
    }
}
