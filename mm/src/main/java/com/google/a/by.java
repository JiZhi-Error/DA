package com.google.a;

/* access modifiers changed from: package-private */
public final class by {

    /* access modifiers changed from: package-private */
    public interface a {
        byte fB(int i2);

        int size();
    }

    static String a(a aVar) {
        StringBuilder sb = new StringBuilder(aVar.size());
        for (int i2 = 0; i2 < aVar.size(); i2++) {
            byte fB = aVar.fB(i2);
            switch (fB) {
                case 7:
                    sb.append("\\a");
                    break;
                case 8:
                    sb.append("\\b");
                    break;
                case 9:
                    sb.append("\\t");
                    break;
                case 10:
                    sb.append("\\n");
                    break;
                case 11:
                    sb.append("\\v");
                    break;
                case 12:
                    sb.append("\\f");
                    break;
                case 13:
                    sb.append("\\r");
                    break;
                case 34:
                    sb.append("\\\"");
                    break;
                case 39:
                    sb.append("\\'");
                    break;
                case 92:
                    sb.append("\\\\");
                    break;
                default:
                    if (fB < 32 || fB > 126) {
                        sb.append('\\');
                        sb.append((char) (((fB >>> 6) & 3) + 48));
                        sb.append((char) (((fB >>> 3) & 7) + 48));
                        sb.append((char) ((fB & 7) + 48));
                        break;
                    } else {
                        sb.append((char) fB);
                        break;
                    }
            }
        }
        return sb.toString();
    }

    static String e(final g gVar) {
        return a(new a() {
            /* class com.google.a.by.AnonymousClass1 */

            @Override // com.google.a.by.a
            public final int size() {
                return gVar.size();
            }

            @Override // com.google.a.by.a
            public final byte fB(int i2) {
                return gVar.fB(i2);
            }
        });
    }
}
