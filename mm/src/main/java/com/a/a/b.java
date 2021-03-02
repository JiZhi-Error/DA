package com.a.a;

import com.a.a.h;
import com.a.a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class b {
    private e aOd;
    private t aOe;
    private boolean aOf;

    /* access modifiers changed from: package-private */
    public interface f {
        boolean a(p pVar, h.al alVar);
    }

    /* access modifiers changed from: package-private */
    public enum e {
        all,
        aural,
        braille,
        embossed,
        handheld,
        print,
        projection,
        screen,
        speech,
        tty,
        tv;

        public static e valueOf(String str) {
            AppMethodBeat.i(206418);
            e eVar = (e) Enum.valueOf(e.class, str);
            AppMethodBeat.o(206418);
            return eVar;
        }

        static {
            AppMethodBeat.i(206419);
            AppMethodBeat.o(206419);
        }
    }

    /* access modifiers changed from: package-private */
    public enum d {
        DESCENDANT,
        CHILD,
        FOLLOWS;

        public static d valueOf(String str) {
            AppMethodBeat.i(206415);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(206415);
            return dVar;
        }

        static {
            AppMethodBeat.i(206416);
            AppMethodBeat.o(206416);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.a.a.b$b  reason: collision with other inner class name */
    public enum EnumC0056b {
        EXISTS,
        EQUALS,
        INCLUDES,
        DASHMATCH;

        public static EnumC0056b valueOf(String str) {
            AppMethodBeat.i(206405);
            EnumC0056b bVar = (EnumC0056b) Enum.valueOf(EnumC0056b.class, str);
            AppMethodBeat.o(206405);
            return bVar;
        }

        static {
            AppMethodBeat.i(206406);
            AppMethodBeat.o(206406);
        }
    }

    /* access modifiers changed from: package-private */
    public enum i {
        target,
        root,
        nth_child,
        nth_last_child,
        nth_of_type,
        nth_last_of_type,
        first_child,
        last_child,
        first_of_type,
        last_of_type,
        only_child,
        only_of_type,
        empty,
        not,
        lang,
        link,
        visited,
        hover,
        active,
        focus,
        enabled,
        disabled,
        checked,
        indeterminate,
        UNSUPPORTED;
        
        private static final Map<String, i> aNT = new HashMap();

        public static i valueOf(String str) {
            AppMethodBeat.i(206424);
            i iVar = (i) Enum.valueOf(i.class, str);
            AppMethodBeat.o(206424);
            return iVar;
        }

        static {
            AppMethodBeat.i(206426);
            i[] values = values();
            for (i iVar : values) {
                if (iVar != UNSUPPORTED) {
                    aNT.put(iVar.name().replace('_', '-'), iVar);
                }
            }
            AppMethodBeat.o(206426);
        }

        public static i Y(String str) {
            AppMethodBeat.i(206425);
            i iVar = aNT.get(str);
            if (iVar != null) {
                AppMethodBeat.o(206425);
                return iVar;
            }
            i iVar2 = UNSUPPORTED;
            AppMethodBeat.o(206425);
            return iVar2;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        final EnumC0056b aOi;
        public final String name;
        public final String value;

        a(String str, EnumC0056b bVar, String str2) {
            this.name = str;
            this.aOi = bVar;
            this.value = str2;
        }
    }

    /* access modifiers changed from: package-private */
    public static class s {
        d aPp = null;
        List<a> aPq = null;
        List<f> aPr = null;
        String tag = null;

        s(d dVar, String str) {
            AppMethodBeat.i(206440);
            this.aPp = dVar == null ? d.DESCENDANT : dVar;
            this.tag = str;
            AppMethodBeat.o(206440);
        }

        /* access modifiers changed from: package-private */
        public final void a(String str, EnumC0056b bVar, String str2) {
            AppMethodBeat.i(206441);
            if (this.aPq == null) {
                this.aPq = new ArrayList();
            }
            this.aPq.add(new a(str, bVar, str2));
            AppMethodBeat.o(206441);
        }

        public final String toString() {
            AppMethodBeat.i(206442);
            StringBuilder sb = new StringBuilder();
            if (this.aPp == d.CHILD) {
                sb.append("> ");
            } else if (this.aPp == d.FOLLOWS) {
                sb.append("+ ");
            }
            sb.append(this.tag == null ? "*" : this.tag);
            if (this.aPq != null) {
                for (a aVar : this.aPq) {
                    sb.append('[').append(aVar.name);
                    switch (aVar.aOi) {
                        case EQUALS:
                            sb.append('=').append(aVar.value);
                            break;
                        case INCLUDES:
                            sb.append("~=").append(aVar.value);
                            break;
                        case DASHMATCH:
                            sb.append("|=").append(aVar.value);
                            break;
                    }
                    sb.append(']');
                }
            }
            if (this.aPr != null) {
                for (f fVar : this.aPr) {
                    sb.append(':').append(fVar);
                }
            }
            String sb2 = sb.toString();
            AppMethodBeat.o(206442);
            return sb2;
        }
    }

    /* access modifiers changed from: package-private */
    public static class q {
        List<o> aPm = null;

        q() {
        }

        /* access modifiers changed from: package-private */
        public final void a(o oVar) {
            AppMethodBeat.i(206433);
            if (this.aPm == null) {
                this.aPm = new ArrayList();
            }
            for (int i2 = 0; i2 < this.aPm.size(); i2++) {
                if (this.aPm.get(i2).aPj.aPo > oVar.aPj.aPo) {
                    this.aPm.add(i2, oVar);
                    AppMethodBeat.o(206433);
                    return;
                }
            }
            this.aPm.add(oVar);
            AppMethodBeat.o(206433);
        }

        /* access modifiers changed from: package-private */
        public final void a(q qVar) {
            AppMethodBeat.i(206434);
            if (qVar.aPm == null) {
                AppMethodBeat.o(206434);
                return;
            }
            if (this.aPm == null) {
                this.aPm = new ArrayList(qVar.aPm.size());
            }
            for (o oVar : qVar.aPm) {
                a(oVar);
            }
            AppMethodBeat.o(206434);
        }

        public final String toString() {
            AppMethodBeat.i(206435);
            if (this.aPm == null) {
                AppMethodBeat.o(206435);
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (o oVar : this.aPm) {
                sb.append(oVar.toString()).append('\n');
            }
            String sb2 = sb.toString();
            AppMethodBeat.o(206435);
            return sb2;
        }
    }

    /* access modifiers changed from: package-private */
    public enum t {
        Document,
        RenderOptions;

        public static t valueOf(String str) {
            AppMethodBeat.i(206444);
            t tVar = (t) Enum.valueOf(t.class, str);
            AppMethodBeat.o(206444);
            return tVar;
        }

        static {
            AppMethodBeat.i(206445);
            AppMethodBeat.o(206445);
        }
    }

    /* access modifiers changed from: package-private */
    public static class o {
        t aOe;
        r aPj = null;
        h.ae aPk = null;

        o(r rVar, h.ae aeVar, t tVar) {
            this.aPj = rVar;
            this.aPk = aeVar;
            this.aOe = tVar;
        }

        public final String toString() {
            AppMethodBeat.i(206431);
            String str = String.valueOf(this.aPj) + " {...} (src=" + this.aOe + ")";
            AppMethodBeat.o(206431);
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    public static class r {
        List<s> aPn;
        int aPo;

        private r() {
            this.aPn = null;
            this.aPo = 0;
        }

        /* synthetic */ r(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final int size() {
            AppMethodBeat.i(206436);
            if (this.aPn == null) {
                AppMethodBeat.o(206436);
                return 0;
            }
            int size = this.aPn.size();
            AppMethodBeat.o(206436);
            return size;
        }

        /* access modifiers changed from: package-private */
        public final s du(int i2) {
            AppMethodBeat.i(206437);
            s sVar = this.aPn.get(i2);
            AppMethodBeat.o(206437);
            return sVar;
        }

        /* access modifiers changed from: package-private */
        public final boolean isEmpty() {
            AppMethodBeat.i(206438);
            if (this.aPn == null || this.aPn.isEmpty()) {
                AppMethodBeat.o(206438);
                return true;
            }
            AppMethodBeat.o(206438);
            return false;
        }

        /* access modifiers changed from: package-private */
        public final void qF() {
            this.aPo += 1000;
        }

        public final String toString() {
            AppMethodBeat.i(206439);
            StringBuilder sb = new StringBuilder();
            for (s sVar : this.aPn) {
                sb.append(sVar).append(' ');
            }
            String sb2 = sb.append('[').append(this.aPo).append(']').toString();
            AppMethodBeat.o(206439);
            return sb2;
        }
    }

    b() {
        this(e.screen, t.Document);
    }

    b(e eVar, t tVar) {
        this.aOd = null;
        this.aOe = null;
        this.aOf = false;
        this.aOd = eVar;
        this.aOe = tVar;
    }

    /* access modifiers changed from: package-private */
    public final q W(String str) {
        AppMethodBeat.i(206446);
        c cVar = new c(str);
        cVar.rs();
        q c2 = c(cVar);
        AppMethodBeat.o(206446);
        return c2;
    }

    static boolean a(String str, e eVar) {
        AppMethodBeat.i(206447);
        c cVar = new c(str);
        cVar.rs();
        boolean a2 = a(a(cVar), eVar);
        AppMethodBeat.o(206447);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public static class c extends l.h {
        c(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", ""));
            AppMethodBeat.i(206407);
            AppMethodBeat.o(206407);
        }

        /* access modifiers changed from: package-private */
        public final String qA() {
            AppMethodBeat.i(206408);
            int qB = qB();
            if (qB == this.position) {
                AppMethodBeat.o(206408);
                return null;
            }
            String substring = this.aWy.substring(this.position, qB);
            this.position = qB;
            AppMethodBeat.o(206408);
            return substring;
        }

        private int qB() {
            AppMethodBeat.i(206409);
            if (empty()) {
                int i2 = this.position;
                AppMethodBeat.o(206409);
                return i2;
            }
            int i3 = this.position;
            int i4 = this.position;
            int charAt = this.aWy.charAt(this.position);
            if (charAt == 45) {
                charAt = ry();
            }
            if ((charAt >= 65 && charAt <= 90) || ((charAt >= 97 && charAt <= 122) || charAt == 95)) {
                int ry = ry();
                while (true) {
                    if ((ry < 65 || ry > 90) && ((ry < 97 || ry > 122) && !((ry >= 48 && ry <= 57) || ry == 45 || ry == 95))) {
                        break;
                    }
                    ry = ry();
                }
                i4 = this.position;
            }
            this.position = i3;
            AppMethodBeat.o(206409);
            return i4;
        }

        /* access modifiers changed from: package-private */
        public final List<r> qC() {
            AppMethodBeat.i(206410);
            if (empty()) {
                AppMethodBeat.o(206410);
                return null;
            }
            ArrayList arrayList = new ArrayList(1);
            r rVar = new r((byte) 0);
            while (!empty() && a(rVar)) {
                if (rt()) {
                    arrayList.add(rVar);
                    rVar = new r((byte) 0);
                }
            }
            if (!rVar.isEmpty()) {
                arrayList.add(rVar);
            }
            AppMethodBeat.o(206410);
            return arrayList;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:214:0x04a2, code lost:
            if (b(')') == false) goto L_0x04a4;
         */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x003a  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0046  */
        /* JADX WARNING: Removed duplicated region for block: B:218:0x04b5  */
        /* JADX WARNING: Removed duplicated region for block: B:222:0x04d4  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x007e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean a(com.a.a.b.r r19) {
            /*
            // Method dump skipped, instructions count: 1322
            */
            throw new UnsupportedOperationException("Method not decompiled: com.a.a.b.c.a(com.a.a.b$r):boolean");
        }

        /* access modifiers changed from: package-private */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public int f102a;

            /* renamed from: b  reason: collision with root package name */
            public int f103b;

            a(int i2, int i3) {
                this.f102a = i2;
                this.f103b = i3;
            }
        }

        /* access modifiers changed from: package-private */
        public final String qD() {
            AppMethodBeat.i(206412);
            if (empty()) {
                AppMethodBeat.o(206412);
                return null;
            }
            int i2 = this.position;
            int i3 = this.position;
            int charAt = this.aWy.charAt(this.position);
            while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33 && !dw(charAt)) {
                if (!isWhitespace(charAt)) {
                    i3 = this.position + 1;
                }
                charAt = ry();
            }
            if (this.position > i2) {
                String substring = this.aWy.substring(i2, i3);
                AppMethodBeat.o(206412);
                return substring;
            }
            this.position = i2;
            AppMethodBeat.o(206412);
            return null;
        }

        /* access modifiers changed from: package-private */
        public final String qE() {
            int dt;
            AppMethodBeat.i(206413);
            if (empty()) {
                AppMethodBeat.o(206413);
                return null;
            }
            char charAt = this.aWy.charAt(this.position);
            if (charAt == '\'' || charAt == '\"') {
                StringBuilder sb = new StringBuilder();
                this.position++;
                int intValue = rv().intValue();
                while (intValue != -1 && intValue != charAt) {
                    if (intValue == 92) {
                        intValue = rv().intValue();
                        if (intValue != -1) {
                            if (intValue == 10 || intValue == 13 || intValue == 12) {
                                intValue = rv().intValue();
                            } else {
                                int dt2 = dt(intValue);
                                if (dt2 != -1) {
                                    for (int i2 = 1; i2 <= 5 && (dt = dt((intValue = rv().intValue()))) != -1; i2++) {
                                        dt2 = (dt2 * 16) + dt;
                                    }
                                    sb.append((char) dt2);
                                }
                            }
                        }
                    }
                    sb.append((char) intValue);
                    intValue = rv().intValue();
                }
                String sb2 = sb.toString();
                AppMethodBeat.o(206413);
                return sb2;
            }
            AppMethodBeat.o(206413);
            return null;
        }

        static int dt(int i2) {
            if (i2 >= 48 && i2 <= 57) {
                return i2 - 48;
            }
            if (i2 >= 65 && i2 <= 70) {
                return (i2 - 65) + 10;
            }
            if (i2 < 97 || i2 > 102) {
                return -1;
            }
            return (i2 - 97) + 10;
        }
    }

    private static boolean a(List<e> list, e eVar) {
        AppMethodBeat.i(206448);
        for (e eVar2 : list) {
            if (eVar2 != e.all) {
                if (eVar2 == eVar) {
                }
            }
            AppMethodBeat.o(206448);
            return true;
        }
        AppMethodBeat.o(206448);
        return false;
    }

    private static List<e> a(c cVar) {
        String rz;
        AppMethodBeat.i(206449);
        ArrayList arrayList = new ArrayList();
        while (!cVar.empty() && (rz = cVar.rz()) != null) {
            try {
                arrayList.add(e.valueOf(rz));
            } catch (IllegalArgumentException e2) {
            }
            if (!cVar.rt()) {
                break;
            }
        }
        AppMethodBeat.o(206449);
        return arrayList;
    }

    private static void b(c cVar) {
        AppMethodBeat.i(206450);
        int i2 = 0;
        while (!cVar.empty()) {
            int intValue = cVar.rv().intValue();
            if (intValue == 59 && i2 == 0) {
                AppMethodBeat.o(206450);
                return;
            } else if (intValue == 123) {
                i2++;
            } else if (intValue == 125 && i2 > 0 && i2 - 1 == 0) {
                AppMethodBeat.o(206450);
                return;
            }
        }
        AppMethodBeat.o(206450);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01a1, code lost:
        if (r12.aO(")") == false) goto L_0x01a3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.a.a.b.q c(com.a.a.b.c r12) {
        /*
        // Method dump skipped, instructions count: 512
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.b.c(com.a.a.b$c):com.a.a.b$q");
    }

    public static List<String> X(String str) {
        AppMethodBeat.i(206453);
        c cVar = new c(str);
        ArrayList arrayList = null;
        while (!cVar.empty()) {
            String a2 = cVar.a(' ', false);
            if (a2 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(a2);
                cVar.rs();
            }
        }
        AppMethodBeat.o(206453);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public static class p {
        h.al aPl;

        p() {
        }

        public final String toString() {
            AppMethodBeat.i(206432);
            if (this.aPl != null) {
                String format = String.format("<%s id=\"%s\">", this.aPl.getNodeName(), this.aPl.id);
                AppMethodBeat.o(206432);
                return format;
            }
            AppMethodBeat.o(206432);
            return "";
        }
    }

    static boolean a(p pVar, r rVar, h.al alVar) {
        AppMethodBeat.i(206454);
        ArrayList arrayList = new ArrayList();
        for (h.aj ajVar = alVar.aSP; ajVar != null; ajVar = ((h.an) ajVar).aSP) {
            arrayList.add(0, ajVar);
        }
        int size = arrayList.size() - 1;
        if (rVar.size() == 1) {
            boolean a2 = a(pVar, rVar.du(0), alVar);
            AppMethodBeat.o(206454);
            return a2;
        }
        boolean a3 = a(pVar, rVar, rVar.size() - 1, arrayList, size, alVar);
        AppMethodBeat.o(206454);
        return a3;
    }

    private static boolean a(p pVar, r rVar, int i2, List<h.aj> list, int i3, h.al alVar) {
        AppMethodBeat.i(206455);
        while (true) {
            s du = rVar.du(i2);
            if (!a(pVar, du, alVar)) {
                AppMethodBeat.o(206455);
                return false;
            } else if (du.aPp == d.DESCENDANT) {
                if (i2 == 0) {
                    AppMethodBeat.o(206455);
                    return true;
                }
                while (i3 >= 0) {
                    if (a(pVar, rVar, i2 - 1, list, i3)) {
                        AppMethodBeat.o(206455);
                        return true;
                    }
                    i3--;
                }
                AppMethodBeat.o(206455);
                return false;
            } else if (du.aPp == d.CHILD) {
                boolean a2 = a(pVar, rVar, i2 - 1, list, i3);
                AppMethodBeat.o(206455);
                return a2;
            } else {
                int a3 = a(list, i3, alVar);
                if (a3 <= 0) {
                    AppMethodBeat.o(206455);
                    return false;
                }
                i2--;
                alVar = (h.al) alVar.aSP.getChildren().get(a3 - 1);
            }
        }
    }

    private static boolean a(p pVar, r rVar, int i2, List<h.aj> list, int i3) {
        AppMethodBeat.i(206456);
        int i4 = i3;
        while (true) {
            s du = rVar.du(i2);
            h.al alVar = (h.al) list.get(i4);
            if (!a(pVar, du, alVar)) {
                AppMethodBeat.o(206456);
                return false;
            } else if (du.aPp == d.DESCENDANT) {
                if (i2 == 0) {
                    AppMethodBeat.o(206456);
                    return true;
                }
                while (i4 > 0) {
                    i4--;
                    if (a(pVar, rVar, i2 - 1, list, i4)) {
                        AppMethodBeat.o(206456);
                        return true;
                    }
                }
                AppMethodBeat.o(206456);
                return false;
            } else if (du.aPp == d.CHILD) {
                i2--;
                i4--;
            } else {
                int a2 = a(list, i4, alVar);
                if (a2 <= 0) {
                    AppMethodBeat.o(206456);
                    return false;
                }
                boolean a3 = a(pVar, rVar, i2 - 1, list, i4, (h.al) alVar.aSP.getChildren().get(a2 - 1));
                AppMethodBeat.o(206456);
                return a3;
            }
        }
    }

    private static int a(List<h.aj> list, int i2, h.al alVar) {
        int i3 = 0;
        AppMethodBeat.i(206457);
        if (i2 < 0) {
            AppMethodBeat.o(206457);
            return 0;
        } else if (list.get(i2) != alVar.aSP) {
            AppMethodBeat.o(206457);
            return -1;
        } else {
            for (h.an anVar : alVar.aSP.getChildren()) {
                if (anVar == alVar) {
                    AppMethodBeat.o(206457);
                    return i3;
                }
                i3++;
            }
            AppMethodBeat.o(206457);
            return -1;
        }
    }

    private static boolean a(p pVar, s sVar, h.al alVar) {
        AppMethodBeat.i(206458);
        if (sVar.tag == null || sVar.tag.equals(alVar.getNodeName().toLowerCase(Locale.US))) {
            if (sVar.aPq != null) {
                for (a aVar : sVar.aPq) {
                    String str = aVar.name;
                    char c2 = 65535;
                    switch (str.hashCode()) {
                        case 3355:
                            if (str.equals("id")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 94742904:
                            if (str.equals("class")) {
                                c2 = 1;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            if (aVar.value.equals(alVar.id)) {
                                break;
                            } else {
                                AppMethodBeat.o(206458);
                                return false;
                            }
                        case 1:
                            if (alVar.aSN == null) {
                                AppMethodBeat.o(206458);
                                return false;
                            } else if (alVar.aSN.contains(aVar.value)) {
                                break;
                            } else {
                                AppMethodBeat.o(206458);
                                return false;
                            }
                        default:
                            AppMethodBeat.o(206458);
                            return false;
                    }
                }
            }
            if (sVar.aPr != null) {
                for (f fVar : sVar.aPr) {
                    if (!fVar.a(pVar, alVar)) {
                        AppMethodBeat.o(206458);
                        return false;
                    }
                }
            }
            AppMethodBeat.o(206458);
            return true;
        }
        AppMethodBeat.o(206458);
        return false;
    }

    /* access modifiers changed from: package-private */
    public static class g implements f {

        /* renamed from: a  reason: collision with root package name */
        private int f104a;
        private boolean aOE;
        private boolean aOF;
        private String aOG;

        /* renamed from: b  reason: collision with root package name */
        private int f105b;

        g(int i2, int i3, boolean z, boolean z2, String str) {
            this.f104a = i2;
            this.f105b = i3;
            this.aOE = z;
            this.aOF = z2;
            this.aOG = str;
        }

        @Override // com.a.a.b.f
        public final boolean a(p pVar, h.al alVar) {
            int i2;
            int i3;
            int i4;
            AppMethodBeat.i(206420);
            String nodeName = (!this.aOF || this.aOG != null) ? this.aOG : alVar.getNodeName();
            if (alVar.aSP != null) {
                Iterator<h.an> it = alVar.aSP.getChildren().iterator();
                i3 = 0;
                i2 = 0;
                while (it.hasNext()) {
                    h.al alVar2 = (h.al) it.next();
                    if (alVar2 == alVar) {
                        i2 = i3;
                    }
                    if (nodeName == null || alVar2.getNodeName().equals(nodeName)) {
                        i4 = i3 + 1;
                    } else {
                        i4 = i3;
                    }
                    i3 = i4;
                }
            } else {
                i3 = 1;
                i2 = 0;
            }
            int i5 = this.aOE ? i2 + 1 : i3 - i2;
            if (this.f104a == 0) {
                if (i5 == this.f105b) {
                    AppMethodBeat.o(206420);
                    return true;
                }
                AppMethodBeat.o(206420);
                return false;
            } else if ((i5 - this.f105b) % this.f104a == 0 && (Integer.signum(i5 - this.f105b) == 0 || Integer.signum(i5 - this.f105b) == Integer.signum(this.f104a))) {
                AppMethodBeat.o(206420);
                return true;
            } else {
                AppMethodBeat.o(206420);
                return false;
            }
        }

        public final String toString() {
            AppMethodBeat.i(206421);
            String str = this.aOE ? "" : "last-";
            if (this.aOF) {
                String format = String.format("nth-%schild(%dn%+d of type <%s>)", str, Integer.valueOf(this.f104a), Integer.valueOf(this.f105b), this.aOG);
                AppMethodBeat.o(206421);
                return format;
            }
            String format2 = String.format("nth-%schild(%dn%+d)", str, Integer.valueOf(this.f104a), Integer.valueOf(this.f105b));
            AppMethodBeat.o(206421);
            return format2;
        }
    }

    /* access modifiers changed from: package-private */
    public static class l implements f {
        private boolean aOF;
        private String aOG;

        public l(boolean z, String str) {
            this.aOF = z;
            this.aOG = str;
        }

        @Override // com.a.a.b.f
        public final boolean a(p pVar, h.al alVar) {
            int i2;
            int i3;
            AppMethodBeat.i(206429);
            String nodeName = (!this.aOF || this.aOG != null) ? this.aOG : alVar.getNodeName();
            if (alVar.aSP != null) {
                Iterator<h.an> it = alVar.aSP.getChildren().iterator();
                i2 = 0;
                while (it.hasNext()) {
                    h.al alVar2 = (h.al) it.next();
                    if (nodeName == null || alVar2.getNodeName().equals(nodeName)) {
                        i3 = i2 + 1;
                    } else {
                        i3 = i2;
                    }
                    i2 = i3;
                }
            } else {
                i2 = 1;
            }
            if (i2 == 1) {
                AppMethodBeat.o(206429);
                return true;
            }
            AppMethodBeat.o(206429);
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(206430);
            if (this.aOF) {
                String format = String.format("only-of-type <%s>", this.aOG);
                AppMethodBeat.o(206430);
                return format;
            }
            String format2 = String.format("only-child", new Object[0]);
            AppMethodBeat.o(206430);
            return format2;
        }
    }

    /* access modifiers changed from: package-private */
    public static class m implements f {
        private m() {
        }

        /* synthetic */ m(byte b2) {
            this();
        }

        @Override // com.a.a.b.f
        public final boolean a(p pVar, h.al alVar) {
            return alVar.aSP == null;
        }

        public final String toString() {
            return "root";
        }
    }

    /* access modifiers changed from: package-private */
    public static class h implements f {
        private h() {
        }

        /* synthetic */ h(byte b2) {
            this();
        }

        @Override // com.a.a.b.f
        public final boolean a(p pVar, h.al alVar) {
            AppMethodBeat.i(206422);
            if (!(alVar instanceof h.aj)) {
                AppMethodBeat.o(206422);
                return true;
            } else if (((h.aj) alVar).getChildren().size() == 0) {
                AppMethodBeat.o(206422);
                return true;
            } else {
                AppMethodBeat.o(206422);
                return false;
            }
        }

        public final String toString() {
            return "empty";
        }
    }

    /* access modifiers changed from: package-private */
    public static class j implements f {
        List<r> aPh;

        j(List<r> list) {
            this.aPh = list;
        }

        @Override // com.a.a.b.f
        public final boolean a(p pVar, h.al alVar) {
            AppMethodBeat.i(206427);
            for (r rVar : this.aPh) {
                if (b.a(pVar, rVar, alVar)) {
                    AppMethodBeat.o(206427);
                    return false;
                }
            }
            AppMethodBeat.o(206427);
            return true;
        }

        public final String toString() {
            AppMethodBeat.i(206428);
            String str = "not(" + this.aPh + ")";
            AppMethodBeat.o(206428);
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    public static class n implements f {
        private n() {
        }

        /* synthetic */ n(byte b2) {
            this();
        }

        @Override // com.a.a.b.f
        public final boolean a(p pVar, h.al alVar) {
            if (pVar == null || alVar != pVar.aPl) {
                return false;
            }
            return true;
        }

        public final String toString() {
            return "target";
        }
    }

    /* access modifiers changed from: package-private */
    public static class k implements f {
        private String aPi;

        k(String str) {
            this.aPi = str;
        }

        @Override // com.a.a.b.f
        public final boolean a(p pVar, h.al alVar) {
            return false;
        }

        public final String toString() {
            return this.aPi;
        }
    }

    private boolean a(q qVar, c cVar) {
        AppMethodBeat.i(206452);
        List<r> qC = cVar.qC();
        if (qC == null || qC.isEmpty()) {
            AppMethodBeat.o(206452);
            return false;
        } else if (!cVar.b('{')) {
            a aVar = new a("Malformed rule block: expected '{'");
            AppMethodBeat.o(206452);
            throw aVar;
        } else {
            cVar.rs();
            h.ae aeVar = new h.ae();
            do {
                String qA = cVar.qA();
                cVar.rs();
                if (cVar.b(':')) {
                    cVar.rs();
                    String qD = cVar.qD();
                    if (qD != null) {
                        cVar.rs();
                        if (cVar.b('!')) {
                            cVar.rs();
                            if (!cVar.aO("important")) {
                                a aVar2 = new a("Malformed rule set: found unexpected '!'");
                                AppMethodBeat.o(206452);
                                throw aVar2;
                            }
                            cVar.rs();
                        }
                        cVar.b(';');
                        l.a(aeVar, qA, qD);
                        cVar.rs();
                        if (cVar.empty()) {
                            break;
                        }
                    } else {
                        a aVar3 = new a("Expected property value");
                        AppMethodBeat.o(206452);
                        throw aVar3;
                    }
                } else {
                    a aVar4 = new a("Expected ':'");
                    AppMethodBeat.o(206452);
                    throw aVar4;
                }
            } while (!cVar.b('}'));
            cVar.rs();
            for (r rVar : qC) {
                qVar.a(new o(rVar, aeVar, this.aOe));
            }
            AppMethodBeat.o(206452);
            return true;
        }
    }
}
