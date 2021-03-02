package com.tencent.mm.plugin.topstory.ui;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.topstory.a.g;
import com.tencent.mm.storage.ar;
import com.tencent.smtt.sdk.TbsListener;

public final class d implements g {
    @Override // com.tencent.mm.plugin.topstory.a.g
    public final void bF(Context context, String str) {
        AppMethodBeat.i(125891);
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_LAST_ENTER_TAB_REC_INT, (Object) 110);
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_HAS_HAOKAN_RESULT_INT, (Object) 1);
        c.a(context, (int) TbsListener.ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02, (Bundle) null, str);
        AppMethodBeat.o(125891);
    }

    @Override // com.tencent.mm.plugin.topstory.a.g
    public final boolean fxP() {
        boolean z;
        AppMethodBeat.i(125892);
        boolean Pi = b.Pi((String) com.tencent.mm.kernel.g.aAh().azQ().get(274436, (Object) null));
        if ((z.aUd() & 67108864) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (Pi || z) {
            AppMethodBeat.o(125892);
            return false;
        }
        AppMethodBeat.o(125892);
        return true;
    }

    @Override // com.tencent.mm.plugin.topstory.a.g
    public final void aW(String str, String str2, String str3) {
        AppMethodBeat.i(236381);
        c.aW(str, str2, str3);
        AppMethodBeat.o(236381);
    }

    @Override // com.tencent.mm.plugin.topstory.a.g
    public final void hv(Context context) {
        AppMethodBeat.i(236382);
        c.hw(context);
        AppMethodBeat.o(236382);
    }
}
