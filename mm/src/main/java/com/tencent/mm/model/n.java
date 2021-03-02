package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.a;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class n extends a {
    public n(Map<String, String> map, ca caVar) {
        super(map, caVar);
    }

    @Override // com.tencent.mm.az.a
    public final boolean aTA() {
        AppMethodBeat.i(123970);
        if (this.values == null) {
            AppMethodBeat.o(123970);
        } else if (!this.TYPE.equals("biz_services_mute")) {
            AppMethodBeat.o(123970);
        } else {
            String str = (String) this.values.get(".sysmsg.biz_services_mute.link.text");
            String str2 = ((String) this.values.get(".sysmsg.biz_services_mute.text")) + str;
            this.jfI.add(str);
            this.jfJ.addFirst(Integer.valueOf(str2.length() - str.length()));
            this.jfK.add(Integer.valueOf(str2.length()));
            this.jfG = str2;
            AppMethodBeat.o(123970);
        }
        return false;
    }

    public static void aTB() {
        AppMethodBeat.i(123971);
        a.AbstractC0276a.a("biz_services_mute", new a.AbstractC0276a() {
            /* class com.tencent.mm.model.n.AnonymousClass1 */

            @Override // com.tencent.mm.az.a.AbstractC0276a
            public final a a(Map<String, String> map, ca caVar) {
                AppMethodBeat.i(123969);
                n nVar = new n(map, caVar);
                AppMethodBeat.o(123969);
                return nVar;
            }
        });
        AppMethodBeat.o(123971);
    }
}
