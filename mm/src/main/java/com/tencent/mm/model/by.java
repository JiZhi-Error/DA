package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.a;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class by extends a {
    public by(Map<String, String> map, ca caVar) {
        super(map, caVar);
    }

    @Override // com.tencent.mm.az.a
    public final boolean aTA() {
        AppMethodBeat.i(123973);
        if (this.values == null) {
            AppMethodBeat.o(123973);
        } else if (!this.TYPE.equals("reportbizlocation")) {
            AppMethodBeat.o(123973);
        } else {
            String str = (String) this.values.get(".sysmsg.reportbizlocation.link.text");
            String str2 = ((String) this.values.get(".sysmsg.reportbizlocation.text")) + str;
            this.jfI.add(str);
            this.jfJ.addFirst(Integer.valueOf(str2.length() - str.length()));
            this.jfK.add(Integer.valueOf(str2.length()));
            this.jfG = str2;
            AppMethodBeat.o(123973);
        }
        return false;
    }

    public static void aTB() {
        AppMethodBeat.i(123974);
        a.AbstractC0276a.a("reportbizlocation", new a.AbstractC0276a() {
            /* class com.tencent.mm.model.by.AnonymousClass1 */

            @Override // com.tencent.mm.az.a.AbstractC0276a
            public final a a(Map<String, String> map, ca caVar) {
                AppMethodBeat.i(123972);
                by byVar = new by(map, caVar);
                AppMethodBeat.o(123972);
                return byVar;
            }
        });
        AppMethodBeat.o(123974);
    }
}
