package android.support.v4.d;

import java.util.Locale;

public final class e {
    public static final d Oq = new C0024e(null, false);
    public static final d Or = new C0024e(null, true);
    public static final d Os = new C0024e(b.Oz, false);
    public static final d Ot = new C0024e(b.Oz, true);
    public static final d Ou = new C0024e(a.Ox, false);
    public static final d Ov = f.OC;

    interface c {
        int b(CharSequence charSequence, int i2);
    }

    static int aE(int i2) {
        switch (i2) {
            case 0:
                return 1;
            case 1:
            case 2:
                return 0;
            default:
                return 2;
        }
    }

    static int aF(int i2) {
        switch (i2) {
            case 0:
            case 14:
            case 15:
                return 1;
            case 1:
            case 2:
            case 16:
            case 17:
                return 0;
            default:
                return 2;
        }
    }

    static abstract class d implements d {
        private final c OA;

        /* access modifiers changed from: protected */
        public abstract boolean fq();

        d(c cVar) {
            this.OA = cVar;
        }

        @Override // android.support.v4.d.d
        public final boolean a(CharSequence charSequence, int i2) {
            if (charSequence == null || i2 < 0 || charSequence.length() - i2 < 0) {
                throw new IllegalArgumentException();
            } else if (this.OA == null) {
                return fq();
            } else {
                switch (this.OA.b(charSequence, i2)) {
                    case 0:
                        return true;
                    case 1:
                        return false;
                    default:
                        return fq();
                }
            }
        }
    }

    /* renamed from: android.support.v4.d.e$e  reason: collision with other inner class name */
    static class C0024e extends d {
        private final boolean OB;

        C0024e(c cVar, boolean z) {
            super(cVar);
            this.OB = z;
        }

        /* access modifiers changed from: protected */
        @Override // android.support.v4.d.e.d
        public final boolean fq() {
            return this.OB;
        }
    }

    static class b implements c {
        static final b Oz = new b();

        @Override // android.support.v4.d.e.c
        public final int b(CharSequence charSequence, int i2) {
            int i3 = i2 + 0;
            int i4 = 2;
            for (int i5 = 0; i5 < i3 && i4 == 2; i5++) {
                i4 = e.aF(Character.getDirectionality(charSequence.charAt(i5)));
            }
            return i4;
        }

        private b() {
        }
    }

    static class a implements c {
        static final a Ox = new a(true);
        static final a Oy = new a(false);
        private final boolean Ow;

        @Override // android.support.v4.d.e.c
        public final int b(CharSequence charSequence, int i2) {
            int i3 = i2 + 0;
            boolean z = false;
            for (int i4 = 0; i4 < i3; i4++) {
                switch (e.aE(Character.getDirectionality(charSequence.charAt(i4)))) {
                    case 0:
                        if (!this.Ow) {
                            z = true;
                            break;
                        } else {
                            return 0;
                        }
                    case 1:
                        if (this.Ow) {
                            z = true;
                            break;
                        } else {
                            return 1;
                        }
                }
            }
            if (z) {
                return !this.Ow ? 0 : 1;
            }
            return 2;
        }

        private a(boolean z) {
            this.Ow = z;
        }
    }

    static class f extends d {
        static final f OC = new f();

        f() {
            super(null);
        }

        /* access modifiers changed from: protected */
        @Override // android.support.v4.d.e.d
        public final boolean fq() {
            if (f.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                return true;
            }
            return false;
        }
    }
}
