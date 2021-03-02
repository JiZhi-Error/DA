package com.tencent.mm.plugin.appbrand.wxawidget.console;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public final class e {
    private static final List<WeakReference<ControlBoardPanel>> oFQ = new LinkedList();
    private static final ControlBoardPanel.a oFR = new ControlBoardPanel.a() {
        /* class com.tencent.mm.plugin.appbrand.wxawidget.console.e.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.wxawidget.console.ControlBoardPanel.a
        public final void a(ControlBoardPanel controlBoardPanel, boolean z) {
            AppMethodBeat.i(121639);
            if (!z) {
                e.a(controlBoardPanel);
            }
            AppMethodBeat.o(121639);
        }
    };

    static {
        AppMethodBeat.i(121642);
        AppMethodBeat.o(121642);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x009e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void eD(android.content.Context r11) {
        /*
        // Method dump skipped, instructions count: 160
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.wxawidget.console.e.eD(android.content.Context):void");
    }

    static /* synthetic */ void a(ControlBoardPanel controlBoardPanel) {
        AppMethodBeat.i(121641);
        if (controlBoardPanel != null) {
            for (int i2 = 0; i2 < oFQ.size(); i2++) {
                WeakReference<ControlBoardPanel> weakReference = oFQ.get(i2);
                if (weakReference != null && controlBoardPanel == weakReference.get()) {
                    oFQ.remove(weakReference);
                }
            }
        }
        AppMethodBeat.o(121641);
    }
}
