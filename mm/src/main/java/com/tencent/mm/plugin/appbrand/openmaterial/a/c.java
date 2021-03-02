package com.tencent.mm.plugin.appbrand.openmaterial.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0000J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0006\u0010\u0013\u001a\u00020\fJ\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/openmaterial/data/MimeType;", "", "type", "", "subType", "(Ljava/lang/String;Ljava/lang/String;)V", "getSubType", "()Ljava/lang/String;", "getType", "component1", "component2", "contains", "", "mimeType", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "isWildcard", "toString", "Companion", "plugin-appbrand-integration_release"})
public final class c {
    private static final Comparator<c> nlt = b.nlv;
    public static final a nlu = new a((byte) 0);
    final String nls;
    final String type;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        if (kotlin.g.b.p.j(r3.nls, r4.nls) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r2 = 229151(0x37f1f, float:3.21109E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            if (r3 == r4) goto L_0x0022
            boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.openmaterial.a.c
            if (r0 == 0) goto L_0x0027
            com.tencent.mm.plugin.appbrand.openmaterial.a.c r4 = (com.tencent.mm.plugin.appbrand.openmaterial.a.c) r4
            java.lang.String r0 = r3.type
            java.lang.String r1 = r4.type
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0027
            java.lang.String r0 = r3.nls
            java.lang.String r1 = r4.nls
            boolean r0 = kotlin.g.b.p.j(r0, r1)
            if (r0 == 0) goto L_0x0027
        L_0x0022:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
        L_0x0026:
            return r0
        L_0x0027:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0026
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.openmaterial.a.c.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(229150);
        String str = this.type;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.nls;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode + i2;
        AppMethodBeat.o(229150);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(229149);
        String str = "MimeType(type=" + this.type + ", subType=" + this.nls + ")";
        AppMethodBeat.o(229149);
        return str;
    }

    public /* synthetic */ c(String str, String str2, byte b2) {
        this(str, str2);
    }

    private c(String str, String str2) {
        this.type = str;
        this.nls = str2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/openmaterial/data/MimeType$Companion;", "", "()V", "comparator", "Ljava/util/Comparator;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/data/MimeType;", "getComparator", "()Ljava/util/Comparator;", "create", "mimeType", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static c adm(String str) {
            AppMethodBeat.i(229146);
            p.h(str, "mimeType");
            Log.d("MicroMsg.AppBrand.OpenMaterialMimeTypeWhiteList", "MimeType#create, mimeType: ".concat(String.valueOf(str)));
            Locale locale = Locale.US;
            p.g(locale, "Locale.US");
            String lowerCase = str.toLowerCase(locale);
            p.g(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            List<String> a2 = n.a((CharSequence) lowerCase, new char[]{'/'});
            if (2 != a2.size()) {
                Log.w("MicroMsg.AppBrand.OpenMaterialMimeTypeWhiteList", "MimeType#create, typeList is illegal");
                AppMethodBeat.o(229146);
                return null;
            }
            String str2 = a2.get(0);
            if (p.j("*", str2)) {
                Log.w("MicroMsg.AppBrand.OpenMaterialMimeTypeWhiteList", "MimeType#create, type is wildcard");
                AppMethodBeat.o(229146);
                return null;
            }
            c cVar = new c(str2, a2.get(1), (byte) 0);
            AppMethodBeat.o(229146);
            return cVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "lhs", "Lcom/tencent/mm/plugin/appbrand/openmaterial/data/MimeType;", "kotlin.jvm.PlatformType", "rhs", "compare"})
    static final class b<T> implements Comparator<c> {
        public static final b nlv = new b();

        static {
            AppMethodBeat.i(229145);
            AppMethodBeat.o(229145);
        }

        b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(c cVar, c cVar2) {
            AppMethodBeat.i(229144);
            c cVar3 = cVar;
            c cVar4 = cVar2;
            if (cVar3 == null) {
                AppMethodBeat.o(229144);
                return 1;
            } else if (cVar4 == null) {
                AppMethodBeat.o(229144);
                return -1;
            } else if (cVar3.bQf()) {
                AppMethodBeat.o(229144);
                return 1;
            } else if (cVar4.bQf()) {
                AppMethodBeat.o(229144);
                return -1;
            } else {
                AppMethodBeat.o(229144);
                return 0;
            }
        }
    }

    static {
        AppMethodBeat.i(229148);
        AppMethodBeat.o(229148);
    }

    public final boolean bQf() {
        AppMethodBeat.i(229147);
        boolean j2 = p.j("*", this.nls);
        AppMethodBeat.o(229147);
        return j2;
    }
}
