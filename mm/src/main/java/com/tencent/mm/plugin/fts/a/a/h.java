package com.tencent.mm.plugin.fts.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.recovery.log.RecoveryFileLog;
import java.util.ArrayList;
import java.util.List;

public final class h {
    private static final a wWG = new a() {
        /* class com.tencent.mm.plugin.fts.a.a.h.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.fts.a.a.h.a
        public final String[] split(String str) {
            AppMethodBeat.i(131688);
            String[] split = c.a.wVe.split(str);
            AppMethodBeat.o(131688);
            return split;
        }

        @Override // com.tencent.mm.plugin.fts.a.a.h.a
        public final String[] ayy(String str) {
            AppMethodBeat.i(131689);
            String[] split = c.a.wVe.split(str, 2);
            AppMethodBeat.o(131689);
            return split;
        }
    };
    public String wWB;
    public String wWC;
    public String[] wWD;
    public String[] wWE;
    public List<c> wWF = new ArrayList();

    public interface a {
        String[] ayy(String str);

        String[] split(String str);
    }

    public static class b {
        public String content;
        public d wWH;
        public List<String> wWI;
    }

    private h() {
        AppMethodBeat.i(131696);
        AppMethodBeat.o(131696);
    }

    public static class c {
        public List<b> wWJ = new ArrayList();

        public c() {
            AppMethodBeat.i(131690);
            AppMethodBeat.o(131690);
        }

        private List<String> dOA() {
            AppMethodBeat.i(131691);
            ArrayList arrayList = new ArrayList();
            for (b bVar : this.wWJ) {
                if (!arrayList.contains(bVar.content)) {
                    arrayList.add(bVar.content);
                }
            }
            AppMethodBeat.o(131691);
            return arrayList;
        }

        public final String dOB() {
            AppMethodBeat.i(131692);
            List<String> dOA = dOA();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < dOA.size(); i2++) {
                String str = dOA.get(i2);
                sb.append("\"");
                sb.append(str);
                char charAt = str.charAt(str.length() - 1);
                if (g.C(charAt) || g.D(charAt)) {
                    sb.append("\"*");
                } else {
                    sb.append("\"");
                }
                if (i2 != dOA.size() - 1) {
                    sb.append(" OR ");
                }
            }
            String sb2 = sb.toString();
            AppMethodBeat.o(131692);
            return sb2;
        }
    }

    public final String dOz() {
        AppMethodBeat.i(131697);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < this.wWF.size(); i2++) {
            stringBuffer.append("(");
            stringBuffer.append(this.wWF.get(i2).dOB());
            stringBuffer.append(")");
            if (i2 != this.wWF.size() - 1) {
                stringBuffer.append(" AND ");
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(131697);
        return stringBuffer2;
    }

    public enum d {
        FullPY,
        ShortPY,
        OTHER;

        public static d valueOf(String str) {
            AppMethodBeat.i(131694);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(131694);
            return dVar;
        }

        static {
            AppMethodBeat.i(131695);
            AppMethodBeat.o(131695);
        }
    }

    private static c bD(String str, boolean z) {
        int i2 = 0;
        AppMethodBeat.i(131698);
        if (z) {
            int i3 = 0;
            while (true) {
                if (i3 >= str.length()) {
                    break;
                } else if (!g.C(str.charAt(i3))) {
                    z = false;
                    break;
                } else {
                    i3++;
                }
            }
        }
        c cVar = new c();
        if (z) {
            com.tencent.mm.plugin.fts.a.b.b bVar = g.wVM;
            ArrayList arrayList = new ArrayList();
            char[] charArray = str.toLowerCase().toCharArray();
            while (true) {
                if (i2 >= charArray.length) {
                    break;
                }
                if (bVar.wXu.wXv[charArray[i2] - 'a'] == null) {
                    arrayList.clear();
                    break;
                }
                arrayList.add(String.valueOf(charArray[i2]));
                i2++;
            }
            if (arrayList.size() > 0) {
                b bVar2 = new b();
                bVar2.wWH = d.ShortPY;
                bVar2.content = Util.listToString(arrayList, RecoveryFileLog.SPLITTER);
                bVar2.wWI = arrayList;
                cVar.wWJ.add(bVar2);
            }
            List<List<String>> ayA = g.wVM.ayA(str);
            if (ayA.size() > 0) {
                for (List<String> list : ayA) {
                    if (list.size() > 0) {
                        b bVar3 = new b();
                        bVar3.wWH = d.FullPY;
                        bVar3.content = Util.listToString(list, RecoveryFileLog.SPLITTER);
                        bVar3.wWI = list;
                        cVar.wWJ.add(bVar3);
                    }
                }
            }
            b bVar4 = new b();
            bVar4.wWH = d.OTHER;
            bVar4.content = str;
            cVar.wWJ.add(bVar4);
        } else {
            b bVar5 = new b();
            bVar5.wWH = d.OTHER;
            bVar5.content = str;
            cVar.wWJ.add(bVar5);
        }
        AppMethodBeat.o(131698);
        return cVar;
    }

    public static h bE(String str, boolean z) {
        AppMethodBeat.i(131699);
        h a2 = a(str, z, wWG);
        AppMethodBeat.o(131699);
        return a2;
    }

    public static h a(String str, boolean z, a aVar) {
        AppMethodBeat.i(131700);
        h hVar = new h();
        hVar.wWB = str;
        hVar.wWC = com.tencent.mm.plugin.fts.a.d.ayq(str);
        hVar.wWD = aVar.split(hVar.wWC);
        hVar.wWE = aVar.ayy(hVar.wWC);
        for (String str2 : hVar.wWD) {
            hVar.wWF.add(bD(str2, z));
        }
        AppMethodBeat.o(131700);
        return hVar;
    }

    static {
        AppMethodBeat.i(131701);
        AppMethodBeat.o(131701);
    }
}
