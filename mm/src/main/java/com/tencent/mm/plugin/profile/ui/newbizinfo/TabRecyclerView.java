package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/TabRecyclerView;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "app_release"})
public class TabRecyclerView extends RecyclerView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(39625);
        AppMethodBeat.o(39625);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(39626);
        AppMethodBeat.o(39626);
    }

    @Override // android.support.v7.widget.RecyclerView
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(39624);
        p.h(motionEvent, "ev");
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        if (iArr[0] < 30) {
            AppMethodBeat.o(39624);
            return true;
        }
        AppMethodBeat.o(39624);
        return false;
    }
}
