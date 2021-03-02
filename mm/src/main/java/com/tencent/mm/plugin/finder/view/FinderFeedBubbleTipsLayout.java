package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.HardTouchableLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ#\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\n\b\u0000\u0010\u000f*\u0004\u0018\u00010\u00102\b\b\u0001\u0010\u0011\u001a\u00020\t¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0002J0\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tH\u0014R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderFeedBubbleTipsLayout;", "Lcom/tencent/mm/view/HardTouchableLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "temLocation1", "", "temLocation2", "getView", "T", "Landroid/view/View;", "viewId", "(I)Landroid/view/View;", "moveViewAboveLikeTargetView", "", "view", "targetView", "onLayout", "changed", "", "left", "top", "right", "bottom", "plugin-finder_release"})
public final class FinderFeedBubbleTipsLayout extends HardTouchableLayout {
    private final int[] wme;
    private final int[] wmf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFeedBubbleTipsLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(254796);
        this.wme = new int[2];
        this.wmf = new int[2];
        AppMethodBeat.o(254796);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFeedBubbleTipsLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(254797);
        this.wme = new int[2];
        this.wmf = new int[2];
        AppMethodBeat.o(254797);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (r0 != null) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0027, code lost:
        if (r1 != null) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onLayout(boolean r8, int r9, int r10, int r11, int r12) {
        /*
        // Method dump skipped, instructions count: 101
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.view.FinderFeedBubbleTipsLayout.onLayout(boolean, int, int, int, int):void");
    }

    private final void k(View view, View view2) {
        AppMethodBeat.i(254794);
        if (view != null) {
            if (!(view.getVisibility() == 0)) {
                view = null;
            }
            if (view != null) {
                if (view2 != null) {
                    view2.getLocationInWindow(this.wme);
                    getLocationInWindow(this.wmf);
                    int i2 = this.wme[1] - this.wmf[1];
                    if (i2 > 0) {
                        view.layout(view.getLeft(), i2 - view.getHeight(), view.getRight(), i2);
                    }
                    AppMethodBeat.o(254794);
                    return;
                }
                AppMethodBeat.o(254794);
                return;
            }
        }
        AppMethodBeat.o(254794);
    }

    private <T extends View> T Mn(int i2) {
        AppMethodBeat.i(254795);
        T t = (T) findViewById(i2);
        if (t != null) {
            AppMethodBeat.o(254795);
            return t;
        }
        AppMethodBeat.o(254795);
        return null;
    }
}
