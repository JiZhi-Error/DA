package com.tencent.mm.plugin.vlog.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB+\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u001c\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J \u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0013H\u0002J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0010R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/widget/CropOperationContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "editorLayoutIds", "", "isEditorItemFirstTouch", "", "canReceiveEvent", "view", "Landroid/view/View;", "ev", "Landroid/view/MotionEvent;", "dispatchTouchEvent", "dispatchTransformedTouchEvent", "event", "cancel", "child", "setEditorItemFirstTouch", "", "enable", "Companion", "plugin-vlog_release"})
public final class CropOperationContainer extends RelativeLayout {
    public static final a GQh = new a((byte) 0);
    private final Set<Integer> GQf;
    private boolean GQg;

    static {
        AppMethodBeat.i(192168);
        AppMethodBeat.o(192168);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/widget/CropOperationContainer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public CropOperationContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(192166);
        this.GQf = ak.setOf((Object[]) new Integer[]{Integer.valueOf((int) R.id.j4q), Integer.valueOf((int) R.id.gb9)});
        AppMethodBeat.o(192166);
    }

    public CropOperationContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(192167);
        this.GQf = ak.setOf((Object[]) new Integer[]{Integer.valueOf((int) R.id.j4q), Integer.valueOf((int) R.id.gb9)});
        AppMethodBeat.o(192167);
    }

    public final void setEditorItemFirstTouch(boolean z) {
        this.GQg = z;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.i(192164);
        Log.d("CropOperationContainer", "dispatchTouchEvent: ".concat(String.valueOf(motionEvent)));
        if (!this.GQg) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(192164);
            return dispatchTouchEvent;
        }
        boolean z2 = false;
        for (int childCount = getChildCount() - 1; childCount >= 0 && !z2; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt == null || motionEvent == null) {
                z = false;
            } else {
                float x = (motionEvent.getX() + ((float) getScrollX())) - ((float) childAt.getLeft());
                float y = (motionEvent.getY() + ((float) getScrollY())) - ((float) childAt.getTop());
                z = childAt.getVisibility() == 0 && x >= 0.0f && x < ((float) (childAt.getRight() - childAt.getLeft())) && y >= 0.0f && y < ((float) (childAt.getBottom() - childAt.getTop()));
            }
            if (z) {
                Set<Integer> set = this.GQf;
                p.g(childAt, "childView");
                if (set.contains(Integer.valueOf(childAt.getId()))) {
                    if (motionEvent == null) {
                        p.hyc();
                    }
                    z2 = a(motionEvent, childAt);
                }
            }
        }
        for (int childCount2 = getChildCount() - 1; childCount2 >= 0 && !z2; childCount2--) {
            View childAt2 = getChildAt(childCount2);
            if (childAt2 != null && motionEvent != null && childAt2.getVisibility() == 0 && !this.GQf.contains(Integer.valueOf(childAt2.getId()))) {
                z2 = a(motionEvent, childAt2);
            }
        }
        AppMethodBeat.o(192164);
        return z2;
    }

    private final boolean a(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(192165);
        int action = motionEvent.getAction();
        if (action == 3) {
            motionEvent.setAction(3);
            boolean dispatchTouchEvent = view.dispatchTouchEvent(motionEvent);
            motionEvent.setAction(action);
            AppMethodBeat.o(192165);
            return dispatchTouchEvent;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        p.g(obtain, "MotionEvent.obtain(event)");
        obtain.offsetLocation((float) (getScrollX() - view.getLeft()), (float) (getScrollY() - view.getTop()));
        boolean dispatchTouchEvent2 = view.dispatchTouchEvent(obtain);
        obtain.recycle();
        AppMethodBeat.o(192165);
        return dispatchTouchEvent2;
    }
}
