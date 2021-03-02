package com.tencent.xweb.xwalk;

import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkNavigationHistory;

public final class q extends WebBackForwardList {
    XWalkNavigationHistory SHK;

    public q(XWalkNavigationHistory xWalkNavigationHistory) {
        this.SHK = xWalkNavigationHistory;
    }

    public final WebHistoryItem getCurrentItem() {
        AppMethodBeat.i(207315);
        if (this.SHK == null) {
            AppMethodBeat.o(207315);
            return null;
        }
        r rVar = new r(this.SHK.getCurrentItem());
        AppMethodBeat.o(207315);
        return rVar;
    }

    public final int getCurrentIndex() {
        AppMethodBeat.i(207316);
        int intValue = (this.SHK == null ? null : Integer.valueOf(this.SHK.getCurrentIndex())).intValue();
        AppMethodBeat.o(207316);
        return intValue;
    }

    public final WebHistoryItem getItemAtIndex(int i2) {
        AppMethodBeat.i(207317);
        if (this.SHK == null) {
            AppMethodBeat.o(207317);
            return null;
        }
        r rVar = new r(this.SHK.getItemAt(i2));
        AppMethodBeat.o(207317);
        return rVar;
    }

    public final int getSize() {
        AppMethodBeat.i(207318);
        int intValue = (this.SHK == null ? null : Integer.valueOf(this.SHK.size())).intValue();
        AppMethodBeat.o(207318);
        return intValue;
    }

    /* access modifiers changed from: protected */
    @Override // android.webkit.WebBackForwardList, android.webkit.WebBackForwardList, java.lang.Object
    public final WebBackForwardList clone() {
        AppMethodBeat.i(207319);
        q qVar = new q(this.SHK);
        AppMethodBeat.o(207319);
        return qVar;
    }
}
