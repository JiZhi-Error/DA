package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzabg {
    static String zza(zzyw zzyw) {
        AppMethodBeat.i(40200);
        zzabh zzabh = new zzabh(zzyw);
        StringBuilder sb = new StringBuilder(zzabh.size());
        for (int i2 = 0; i2 < zzabh.size(); i2++) {
            byte zzae = zzabh.zzae(i2);
            switch (zzae) {
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
                    if (zzae < 32 || zzae > 126) {
                        sb.append('\\');
                        sb.append((char) (((zzae >>> 6) & 3) + 48));
                        sb.append((char) (((zzae >>> 3) & 7) + 48));
                        sb.append((char) ((zzae & 7) + 48));
                        break;
                    } else {
                        sb.append((char) zzae);
                        break;
                    }
                    break;
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(40200);
        return sb2;
    }
}
