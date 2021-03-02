package com.tencent.thumbplayer.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPPlayerState;

public final class g {
    private TPPlayerState RWr;

    public g(TPPlayerState tPPlayerState) {
        this.RWr = tPPlayerState;
    }

    public final boolean aqS(int i2) {
        AppMethodBeat.i(188724);
        if (i2 == 1) {
            boolean a2 = a(this.RWr);
            AppMethodBeat.o(188724);
            return a2;
        } else if (i2 == 2) {
            boolean is = this.RWr.is(1);
            AppMethodBeat.o(188724);
            return is;
        } else if (i2 == 3) {
            boolean b2 = b(this.RWr);
            AppMethodBeat.o(188724);
            return b2;
        } else if (i2 == 4) {
            AppMethodBeat.o(188724);
            return true;
        } else if (i2 == 5) {
            boolean c2 = c(this.RWr);
            AppMethodBeat.o(188724);
            return c2;
        } else if (i2 == 6) {
            boolean d2 = d(this.RWr);
            AppMethodBeat.o(188724);
            return d2;
        } else if (i2 == 7) {
            boolean e2 = e(this.RWr);
            AppMethodBeat.o(188724);
            return e2;
        } else if (i2 == 8) {
            boolean f2 = f(this.RWr);
            AppMethodBeat.o(188724);
            return f2;
        } else if (i2 == 9) {
            boolean g2 = g(this.RWr);
            AppMethodBeat.o(188724);
            return g2;
        } else if (i2 == 11) {
            boolean h2 = h(this.RWr);
            AppMethodBeat.o(188724);
            return h2;
        } else if (i2 == 12) {
            boolean i3 = i(this.RWr);
            AppMethodBeat.o(188724);
            return i3;
        } else if (i2 == 13) {
            boolean j2 = j(this.RWr);
            AppMethodBeat.o(188724);
            return j2;
        } else if (i2 == 14) {
            boolean k = k(this.RWr);
            AppMethodBeat.o(188724);
            return k;
        } else if (i2 == 15) {
            boolean l = l(this.RWr);
            AppMethodBeat.o(188724);
            return l;
        } else if (i2 == 16) {
            boolean m = m(this.RWr);
            AppMethodBeat.o(188724);
            return m;
        } else if (i2 == 17) {
            boolean t = t(this.RWr);
            AppMethodBeat.o(188724);
            return t;
        } else if (i2 == 18) {
            boolean u = u(this.RWr);
            AppMethodBeat.o(188724);
            return u;
        } else {
            AppMethodBeat.o(188724);
            return false;
        }
    }

    public final boolean aqT(int i2) {
        AppMethodBeat.i(188725);
        if (i2 == 1) {
            boolean is = this.RWr.is(3);
            AppMethodBeat.o(188725);
            return is;
        } else if (i2 == 2) {
            boolean n = n(this.RWr);
            AppMethodBeat.o(188725);
            return n;
        } else if (i2 == 3) {
            boolean o = o(this.RWr);
            AppMethodBeat.o(188725);
            return o;
        } else if (i2 == 4) {
            boolean p = p(this.RWr);
            AppMethodBeat.o(188725);
            return p;
        } else if (i2 == 5) {
            boolean q = q(this.RWr);
            AppMethodBeat.o(188725);
            return q;
        } else if (i2 == 6) {
            boolean r = r(this.RWr);
            AppMethodBeat.o(188725);
            return r;
        } else if (i2 == 7) {
            boolean s = s(this.RWr);
            AppMethodBeat.o(188725);
            return s;
        } else {
            AppMethodBeat.o(188725);
            return false;
        }
    }

    private static boolean a(TPPlayerState tPPlayerState) {
        AppMethodBeat.i(188726);
        if (tPPlayerState.is(2) || tPPlayerState.is(8) || tPPlayerState.is(9)) {
            AppMethodBeat.o(188726);
            return true;
        }
        AppMethodBeat.o(188726);
        return false;
    }

    private static boolean b(TPPlayerState tPPlayerState) {
        AppMethodBeat.i(188727);
        if (tPPlayerState.is(1) || tPPlayerState.is(2) || tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(7) || tPPlayerState.is(8) || tPPlayerState.is(9)) {
            AppMethodBeat.o(188727);
            return true;
        }
        AppMethodBeat.o(188727);
        return false;
    }

    private static boolean c(TPPlayerState tPPlayerState) {
        AppMethodBeat.i(188728);
        if (tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(7)) {
            AppMethodBeat.o(188728);
            return true;
        }
        AppMethodBeat.o(188728);
        return false;
    }

    private static boolean d(TPPlayerState tPPlayerState) {
        AppMethodBeat.i(188729);
        if (tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(7)) {
            AppMethodBeat.o(188729);
            return true;
        }
        AppMethodBeat.o(188729);
        return false;
    }

    private static boolean e(TPPlayerState tPPlayerState) {
        AppMethodBeat.i(188730);
        if (tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(6) || tPPlayerState.is(7)) {
            AppMethodBeat.o(188730);
            return true;
        }
        AppMethodBeat.o(188730);
        return false;
    }

    private static boolean f(TPPlayerState tPPlayerState) {
        AppMethodBeat.i(188731);
        if (tPPlayerState.is(1) || tPPlayerState.is(2) || tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(7) || tPPlayerState.is(10)) {
            AppMethodBeat.o(188731);
            return true;
        }
        AppMethodBeat.o(188731);
        return false;
    }

    private static boolean g(TPPlayerState tPPlayerState) {
        AppMethodBeat.i(188732);
        if (tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(7)) {
            AppMethodBeat.o(188732);
            return true;
        }
        AppMethodBeat.o(188732);
        return false;
    }

    private static boolean h(TPPlayerState tPPlayerState) {
        AppMethodBeat.i(188733);
        if (tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(7)) {
            AppMethodBeat.o(188733);
            return true;
        }
        AppMethodBeat.o(188733);
        return false;
    }

    private static boolean i(TPPlayerState tPPlayerState) {
        AppMethodBeat.i(188734);
        if (tPPlayerState.is(1) || tPPlayerState.is(2) || tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(7)) {
            AppMethodBeat.o(188734);
            return true;
        }
        AppMethodBeat.o(188734);
        return false;
    }

    private static boolean j(TPPlayerState tPPlayerState) {
        AppMethodBeat.i(188735);
        if (tPPlayerState.is(1) || tPPlayerState.is(2) || tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(7)) {
            AppMethodBeat.o(188735);
            return true;
        }
        AppMethodBeat.o(188735);
        return false;
    }

    private static boolean k(TPPlayerState tPPlayerState) {
        AppMethodBeat.i(188736);
        if (tPPlayerState.is(1) || tPPlayerState.is(2) || tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(7)) {
            AppMethodBeat.o(188736);
            return true;
        }
        AppMethodBeat.o(188736);
        return false;
    }

    private static boolean l(TPPlayerState tPPlayerState) {
        AppMethodBeat.i(188737);
        if (tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(7)) {
            AppMethodBeat.o(188737);
            return true;
        }
        AppMethodBeat.o(188737);
        return false;
    }

    private static boolean m(TPPlayerState tPPlayerState) {
        AppMethodBeat.i(188738);
        if (tPPlayerState.is(1) || tPPlayerState.is(2) || tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(7) || tPPlayerState.is(10)) {
            AppMethodBeat.o(188738);
            return true;
        }
        AppMethodBeat.o(188738);
        return false;
    }

    private static boolean n(TPPlayerState tPPlayerState) {
        AppMethodBeat.i(188739);
        if (tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6)) {
            AppMethodBeat.o(188739);
            return true;
        }
        AppMethodBeat.o(188739);
        return false;
    }

    private static boolean o(TPPlayerState tPPlayerState) {
        AppMethodBeat.i(188740);
        if (tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6)) {
            AppMethodBeat.o(188740);
            return true;
        }
        AppMethodBeat.o(188740);
        return false;
    }

    private static boolean p(TPPlayerState tPPlayerState) {
        AppMethodBeat.i(188741);
        if (tPPlayerState.is(2) || tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6)) {
            AppMethodBeat.o(188741);
            return true;
        }
        AppMethodBeat.o(188741);
        return false;
    }

    private static boolean q(TPPlayerState tPPlayerState) {
        AppMethodBeat.i(188742);
        if (tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6)) {
            AppMethodBeat.o(188742);
            return true;
        }
        AppMethodBeat.o(188742);
        return false;
    }

    private static boolean r(TPPlayerState tPPlayerState) {
        AppMethodBeat.i(188743);
        if (tPPlayerState.is(3) || tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6)) {
            AppMethodBeat.o(188743);
            return true;
        }
        AppMethodBeat.o(188743);
        return false;
    }

    private static boolean s(TPPlayerState tPPlayerState) {
        AppMethodBeat.i(188744);
        if (tPPlayerState.is(5) || tPPlayerState.is(6)) {
            AppMethodBeat.o(188744);
            return true;
        }
        AppMethodBeat.o(188744);
        return false;
    }

    private static boolean t(TPPlayerState tPPlayerState) {
        AppMethodBeat.i(188745);
        if (tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(6) || tPPlayerState.is(7)) {
            AppMethodBeat.o(188745);
            return true;
        }
        AppMethodBeat.o(188745);
        return false;
    }

    private static boolean u(TPPlayerState tPPlayerState) {
        AppMethodBeat.i(188746);
        if (tPPlayerState.is(4) || tPPlayerState.is(5) || tPPlayerState.is(8) || tPPlayerState.is(9) || tPPlayerState.is(6) || tPPlayerState.is(7)) {
            AppMethodBeat.o(188746);
            return true;
        }
        AppMethodBeat.o(188746);
        return false;
    }
}
