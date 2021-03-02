package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB+\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016R9\u0010\r\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/InterceptRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "beforeDispatchTouchEvent", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "Lkotlin/ParameterName;", "name", "ev", "", "getBeforeDispatchTouchEvent", "()Lkotlin/jvm/functions/Function1;", "setBeforeDispatchTouchEvent", "(Lkotlin/jvm/functions/Function1;)V", "onInterceptTouchEvent", "plugin-mv_release"})
public final class InterceptRelativeLayout extends RelativeLayout {
    private b<? super MotionEvent, Boolean> AwA;

    public InterceptRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InterceptRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super android.view.MotionEvent, java.lang.Boolean>, kotlin.g.a.b<android.view.MotionEvent, java.lang.Boolean> */
    public final b<MotionEvent, Boolean> getBeforeDispatchTouchEvent() {
        return this.AwA;
    }

    public final void setBeforeDispatchTouchEvent(b<? super MotionEvent, Boolean> bVar) {
        this.AwA = bVar;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Boolean invoke;
        AppMethodBeat.i(257402);
        b<? super MotionEvent, Boolean> bVar = this.AwA;
        if (bVar == null || (invoke = bVar.invoke(motionEvent)) == null) {
            AppMethodBeat.o(257402);
            return false;
        }
        boolean booleanValue = invoke.booleanValue();
        AppMethodBeat.o(257402);
        return booleanValue;
    }
}
