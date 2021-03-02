package com.tencent.xweb.x5;

import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i extends WebBackForwardList {
    private com.tencent.smtt.sdk.WebBackForwardList SFo;

    public i(com.tencent.smtt.sdk.WebBackForwardList webBackForwardList) {
        this.SFo = webBackForwardList;
    }

    public final WebHistoryItem getCurrentItem() {
        AppMethodBeat.i(207190);
        if (this.SFo == null) {
            AppMethodBeat.o(207190);
            return null;
        }
        k kVar = new k(this.SFo.getCurrentItem());
        AppMethodBeat.o(207190);
        return kVar;
    }

    public final int getCurrentIndex() {
        AppMethodBeat.i(207191);
        int intValue = (this.SFo == null ? null : Integer.valueOf(this.SFo.getCurrentIndex())).intValue();
        AppMethodBeat.o(207191);
        return intValue;
    }

    public final WebHistoryItem getItemAtIndex(int i2) {
        AppMethodBeat.i(207192);
        if (this.SFo == null) {
            AppMethodBeat.o(207192);
            return null;
        }
        k kVar = new k(this.SFo.getItemAtIndex(i2));
        AppMethodBeat.o(207192);
        return kVar;
    }

    public final int getSize() {
        AppMethodBeat.i(207193);
        int intValue = (this.SFo == null ? null : Integer.valueOf(this.SFo.getSize())).intValue();
        AppMethodBeat.o(207193);
        return intValue;
    }

    /* access modifiers changed from: protected */
    @Override // android.webkit.WebBackForwardList, android.webkit.WebBackForwardList, java.lang.Object
    public final WebBackForwardList clone() {
        AppMethodBeat.i(207194);
        i iVar = new i(this.SFo);
        AppMethodBeat.o(207194);
        return iVar;
    }
}
