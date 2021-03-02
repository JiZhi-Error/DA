package android.support.v4.d;

import android.text.SpannableStringBuilder;
import com.qq.taf.jce.JceStruct;
import java.util.Locale;

public final class a {
    static final d NT = e.Os;
    private static final String NU = Character.toString(8206);
    private static final String NV = Character.toString(8207);
    static final a NW = new a(false, 2, NT);
    static final a NX = new a(true, 2, NT);
    private final int FV;
    private final boolean NY;
    private final d NZ;

    /* renamed from: android.support.v4.d.a$a  reason: collision with other inner class name */
    public static final class C0022a {
        int FV = 2;
        boolean NY = a.a(Locale.getDefault());
        d Oa = a.NT;
    }

    public static a fg() {
        C0022a aVar = new C0022a();
        if (aVar.FV == 2 && aVar.Oa == NT) {
            return aVar.NY ? NX : NW;
        }
        return new a(aVar.NY, aVar.FV, aVar.Oa);
    }

    private a(boolean z, int i2, d dVar) {
        this.NY = z;
        this.FV = i2;
        this.NZ = dVar;
    }

    private CharSequence a(CharSequence charSequence, d dVar) {
        boolean z;
        d dVar2;
        String str;
        d dVar3;
        String str2;
        if (charSequence == null) {
            return null;
        }
        boolean a2 = dVar.a(charSequence, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if ((this.FV & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (a2) {
                dVar3 = e.Or;
            } else {
                dVar3 = e.Oq;
            }
            boolean a3 = dVar3.a(charSequence, charSequence.length());
            if (!this.NY && (a3 || n(charSequence) == 1)) {
                str2 = NU;
            } else if (!this.NY || (a3 && n(charSequence) != -1)) {
                str2 = "";
            } else {
                str2 = NV;
            }
            spannableStringBuilder.append((CharSequence) str2);
        }
        if (a2 != this.NY) {
            spannableStringBuilder.append(a2 ? (char) 8235 : 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (a2) {
            dVar2 = e.Or;
        } else {
            dVar2 = e.Oq;
        }
        boolean a4 = dVar2.a(charSequence, charSequence.length());
        if (!this.NY && (a4 || m(charSequence) == 1)) {
            str = NU;
        } else if (!this.NY || (a4 && m(charSequence) != -1)) {
            str = "";
        } else {
            str = NV;
        }
        spannableStringBuilder.append((CharSequence) str);
        return spannableStringBuilder;
    }

    public final CharSequence unicodeWrap(CharSequence charSequence) {
        return a(charSequence, this.NZ);
    }

    static boolean a(Locale locale) {
        return f.getLayoutDirectionFromLocale(locale) == 1;
    }

    private static int m(CharSequence charSequence) {
        return new b(charSequence).fi();
    }

    private static int n(CharSequence charSequence) {
        return new b(charSequence).fh();
    }

    /* access modifiers changed from: package-private */
    public static class b {
        private static final byte[] Ob = new byte[1792];
        private final boolean Oc = false;
        private int Od;
        private char Oe;
        private final int length;
        private final CharSequence text;

        static {
            for (int i2 = 0; i2 < 1792; i2++) {
                Ob[i2] = Character.getDirectionality(i2);
            }
        }

        b(CharSequence charSequence) {
            this.text = charSequence;
            this.length = charSequence.length();
        }

        /* access modifiers changed from: package-private */
        public final int fh() {
            this.Od = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (this.Od < this.length && i2 == 0) {
                switch (fj()) {
                    case 0:
                        if (i4 != 0) {
                            i2 = i4;
                            break;
                        } else {
                            return -1;
                        }
                    case 1:
                    case 2:
                        if (i4 != 0) {
                            i2 = i4;
                            break;
                        } else {
                            return 1;
                        }
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    default:
                        i2 = i4;
                        break;
                    case 9:
                        break;
                    case 14:
                    case 15:
                        i4++;
                        i3 = -1;
                        break;
                    case 16:
                    case 17:
                        i4++;
                        i3 = 1;
                        break;
                    case 18:
                        i4--;
                        i3 = 0;
                        break;
                }
            }
            if (i2 == 0) {
                return 0;
            }
            if (i3 != 0) {
                return i3;
            }
            while (this.Od > 0) {
                switch (fl()) {
                    case 14:
                    case 15:
                        if (i2 != i4) {
                            i4--;
                            break;
                        } else {
                            return -1;
                        }
                    case 16:
                    case 17:
                        if (i2 != i4) {
                            i4--;
                            break;
                        } else {
                            return 1;
                        }
                    case 18:
                        i4++;
                        break;
                }
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public final int fi() {
            this.Od = this.length;
            int i2 = 0;
            int i3 = 0;
            while (this.Od > 0) {
                switch (fl()) {
                    case 0:
                        if (i3 != 0) {
                            if (i2 != 0) {
                                break;
                            } else {
                                i2 = i3;
                                break;
                            }
                        } else {
                            return -1;
                        }
                    case 1:
                    case 2:
                        if (i3 != 0) {
                            if (i2 != 0) {
                                break;
                            } else {
                                i2 = i3;
                                break;
                            }
                        } else {
                            return 1;
                        }
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    default:
                        if (i2 != 0) {
                            break;
                        } else {
                            i2 = i3;
                            break;
                        }
                    case 9:
                        break;
                    case 14:
                    case 15:
                        if (i2 != i3) {
                            i3--;
                            break;
                        } else {
                            return -1;
                        }
                    case 16:
                    case 17:
                        if (i2 != i3) {
                            i3--;
                            break;
                        } else {
                            return 1;
                        }
                    case 18:
                        i3++;
                        break;
                }
            }
            return 0;
        }

        private static byte a(char c2) {
            return c2 < 1792 ? Ob[c2] : Character.getDirectionality(c2);
        }

        private byte fj() {
            this.Oe = this.text.charAt(this.Od);
            if (Character.isHighSurrogate(this.Oe)) {
                int codePointAt = Character.codePointAt(this.text, this.Od);
                this.Od += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.Od++;
            byte a2 = a(this.Oe);
            if (!this.Oc) {
                return a2;
            }
            if (this.Oe == '<') {
                return fm();
            }
            if (this.Oe == '&') {
                return fo();
            }
            return a2;
        }

        private byte fl() {
            this.Oe = this.text.charAt(this.Od - 1);
            if (Character.isLowSurrogate(this.Oe)) {
                int codePointBefore = Character.codePointBefore(this.text, this.Od);
                this.Od -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.Od--;
            byte a2 = a(this.Oe);
            if (!this.Oc) {
                return a2;
            }
            if (this.Oe == '>') {
                return fn();
            }
            if (this.Oe == ';') {
                return fp();
            }
            return a2;
        }

        private byte fm() {
            int i2 = this.Od;
            while (this.Od < this.length) {
                CharSequence charSequence = this.text;
                int i3 = this.Od;
                this.Od = i3 + 1;
                this.Oe = charSequence.charAt(i3);
                if (this.Oe == '>') {
                    return JceStruct.ZERO_TAG;
                }
                if (this.Oe == '\"' || this.Oe == '\'') {
                    char c2 = this.Oe;
                    while (this.Od < this.length) {
                        CharSequence charSequence2 = this.text;
                        int i4 = this.Od;
                        this.Od = i4 + 1;
                        char charAt = charSequence2.charAt(i4);
                        this.Oe = charAt;
                        if (charAt == c2) {
                            break;
                        }
                    }
                }
            }
            this.Od = i2;
            this.Oe = '<';
            return JceStruct.SIMPLE_LIST;
        }

        private byte fn() {
            int i2 = this.Od;
            while (this.Od > 0) {
                CharSequence charSequence = this.text;
                int i3 = this.Od - 1;
                this.Od = i3;
                this.Oe = charSequence.charAt(i3);
                if (this.Oe != '<') {
                    if (this.Oe == '>') {
                        break;
                    } else if (this.Oe == '\"' || this.Oe == '\'') {
                        char c2 = this.Oe;
                        while (this.Od > 0) {
                            CharSequence charSequence2 = this.text;
                            int i4 = this.Od - 1;
                            this.Od = i4;
                            char charAt = charSequence2.charAt(i4);
                            this.Oe = charAt;
                            if (charAt == c2) {
                                break;
                            }
                        }
                    }
                } else {
                    return JceStruct.ZERO_TAG;
                }
            }
            this.Od = i2;
            this.Oe = '>';
            return JceStruct.SIMPLE_LIST;
        }

        private byte fo() {
            while (this.Od < this.length) {
                CharSequence charSequence = this.text;
                int i2 = this.Od;
                this.Od = i2 + 1;
                char charAt = charSequence.charAt(i2);
                this.Oe = charAt;
                if (charAt == ';') {
                    return JceStruct.ZERO_TAG;
                }
            }
            return JceStruct.ZERO_TAG;
        }

        private byte fp() {
            int i2 = this.Od;
            while (this.Od > 0) {
                CharSequence charSequence = this.text;
                int i3 = this.Od - 1;
                this.Od = i3;
                this.Oe = charSequence.charAt(i3);
                if (this.Oe != '&') {
                    if (this.Oe == ';') {
                        break;
                    }
                } else {
                    return JceStruct.ZERO_TAG;
                }
            }
            this.Od = i2;
            this.Oe = ';';
            return JceStruct.SIMPLE_LIST;
        }
    }
}
