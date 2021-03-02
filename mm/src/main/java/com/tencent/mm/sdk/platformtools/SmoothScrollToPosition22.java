package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.os.Build;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;

/* access modifiers changed from: package-private */
public class SmoothScrollToPosition22 implements BackwardSupportUtil.SmoothScrollFactory.IScroll {
    private static final int SCROLL_UNIT = 10;
    private byte _hellAccFlag_;

    SmoothScrollToPosition22() {
    }

    @Override // com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory.IScroll
    @TargetApi(8)
    public void doScroll(ListView listView) {
        AppMethodBeat.i(156352);
        if (listView.getFirstVisiblePosition() > 10) {
            listView.setSelection(10);
        }
        if (Build.VERSION.SDK_INT >= 8) {
            a a2 = c.a(0, new a());
            com.tencent.mm.hellhoundlib.a.a.a(listView, a2.axQ(), "com/tencent/mm/sdk/platformtools/SmoothScrollToPosition22", "doScroll", "(Landroid/widget/ListView;)V", "Undefined", "smoothScrollToPosition", "(I)V");
            listView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(listView, "com/tencent/mm/sdk/platformtools/SmoothScrollToPosition22", "doScroll", "(Landroid/widget/ListView;)V", "Undefined", "smoothScrollToPosition", "(I)V");
        }
        AppMethodBeat.o(156352);
    }

    @Override // com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory.IScroll
    @TargetApi(8)
    public void doScroll(ListView listView, int i2) {
        AppMethodBeat.i(156353);
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition > i2 && firstVisiblePosition - i2 > 10) {
            listView.setSelection(i2 + 10);
        } else if (firstVisiblePosition < i2 && i2 - firstVisiblePosition > 10) {
            listView.setSelection(i2 - 10);
        }
        if (Build.VERSION.SDK_INT >= 8) {
            a a2 = c.a(i2, new a());
            com.tencent.mm.hellhoundlib.a.a.a(listView, a2.axQ(), "com/tencent/mm/sdk/platformtools/SmoothScrollToPosition22", "doScroll", "(Landroid/widget/ListView;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
            listView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(listView, "com/tencent/mm/sdk/platformtools/SmoothScrollToPosition22", "doScroll", "(Landroid/widget/ListView;I)V", "Undefined", "smoothScrollToPosition", "(I)V");
        }
        AppMethodBeat.o(156353);
    }

    @Override // com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory.IScroll
    @TargetApi(11)
    public void doScrollFromTop(ListView listView, int i2) {
        AppMethodBeat.i(215440);
        listView.getFirstVisiblePosition();
        listView.setSelection(i2);
        AppMethodBeat.o(215440);
    }
}
