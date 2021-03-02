package com.tencent.mm.sdk.platformtools;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;

/* access modifiers changed from: package-private */
public class SmoothScrollToPosition21below implements BackwardSupportUtil.SmoothScrollFactory.IScroll {
    SmoothScrollToPosition21below() {
    }

    @Override // com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory.IScroll
    public void doScroll(ListView listView) {
        AppMethodBeat.i(215437);
        listView.setSelection(0);
        AppMethodBeat.o(215437);
    }

    @Override // com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory.IScroll
    public void doScroll(ListView listView, int i2) {
        AppMethodBeat.i(215438);
        listView.setSelection(i2);
        AppMethodBeat.o(215438);
    }

    @Override // com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory.IScroll
    public void doScrollFromTop(ListView listView, int i2) {
        AppMethodBeat.i(215439);
        listView.setSelectionFromTop(i2, 0);
        AppMethodBeat.o(215439);
    }
}
