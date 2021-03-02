package com.tencent.mm.plugin.sns.model.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.a.c;
import com.tencent.mm.vfs.s;

public final class g extends c {
    public g(c.a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    @Override // com.tencent.mm.plugin.sns.model.a.c
    public final String aPI(String str) {
        return str;
    }

    @Override // com.tencent.mm.plugin.sns.model.a.c
    public final boolean fbX() {
        String j2;
        AppMethodBeat.i(96072);
        if (this.DPt == null || TextUtils.isEmpty(this.DPt.DEu)) {
            j2 = r.j(this.ebR);
        } else {
            j2 = this.DPt.DEu;
        }
        s.bo(this.DPt.getPath(), this.DPt.fbV(), j2);
        AppMethodBeat.o(96072);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.model.a.c
    public final int getMediaType() {
        return 2;
    }
}
