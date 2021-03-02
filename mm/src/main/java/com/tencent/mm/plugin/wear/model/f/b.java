package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.R;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;

public abstract class b extends c {
    protected static String c(String str, ca caVar) {
        if (ab.Eq(str)) {
            String d2 = d(str, caVar);
            return String.format(MMApplicationContext.getContext().getString(R.string.ffw), h.aWo(d2), (char) 8203, h.aP(caVar).iAc);
        }
        return String.format(MMApplicationContext.getContext().getString(R.string.ffx), h.aP(caVar).iAc);
    }

    protected static String d(String str, ca caVar) {
        int Kp;
        String trim;
        return (!ab.Eq(str) || (Kp = bp.Kp(caVar.field_content)) == -1 || (trim = caVar.field_content.substring(0, Kp).trim()) == null || trim.length() <= 0) ? str : trim;
    }
}
