package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.ca;
import java.util.Map;

public final class c extends a {
    public c(Map<String, String> map, ca caVar) {
        super(map, caVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.az.a
    public final boolean aTA() {
        AppMethodBeat.i(101784);
        if (this.values == null) {
            AppMethodBeat.o(101784);
        } else if (!this.TYPE.equals("chatroommuteexpt")) {
            AppMethodBeat.o(101784);
        } else {
            String str = (String) this.values.get(".sysmsg.chatroommuteexpt.link.text");
            String str2 = ((String) this.values.get(".sysmsg.chatroommuteexpt.text")) + str;
            this.jfI.add(str);
            this.jfJ.addFirst(Integer.valueOf(str2.length() - str.length()));
            this.jfK.add(Integer.valueOf(str2.length()));
            this.jfG = str2;
            AppMethodBeat.o(101784);
        }
        return false;
    }
}
