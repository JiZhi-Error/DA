package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0012\u001a\u00020\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0014J(\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0014J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/LiveFriendsTraditionNestedLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "headLayout", "Landroid/view/View;", "headLayoutHeight", "isHeadHide", "", "lastY", "rlLayout", "onFinishInflate", "", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "scrollTo", "x", "y", "Companion", "plugin-finder_release"})
public final class LiveFriendsTraditionNestedLayout extends LinearLayout {
    public static final a wqA = new a((byte) 0);
    private View wqt;
    private int wqv;
    private View wqx;
    private boolean wqy;
    private int wqz;

    static {
        AppMethodBeat.i(255069);
        AppMethodBeat.o(255069);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveFriendsTraditionNestedLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(255067);
        AppMethodBeat.o(255067);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveFriendsTraditionNestedLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(255068);
        AppMethodBeat.o(255068);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/LiveFriendsTraditionNestedLayout$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(255061);
        p.h(motionEvent, "event");
        int action = motionEvent.getAction() & 255;
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.wqz = y;
                break;
            case 2:
                int i2 = this.wqz - y;
                if (Math.abs(i2) > ViewConfiguration.getTouchSlop()) {
                    if (i2 > 0 && !this.wqy) {
                        Log.d("LiveFriendsTraditionNestedLayout", "onInterceptTouchEvent: 开始向上拦截");
                        AppMethodBeat.o(255061);
                        return true;
                    } else if (i2 < 0 && this.wqy) {
                        Log.d("LiveFriendsTraditionNestedLayout", "onInterceptTouchEvent: 开始向下拦截");
                        AppMethodBeat.o(255061);
                        return true;
                    }
                }
                break;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(255061);
        return onInterceptTouchEvent;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(255062);
        p.h(motionEvent, "event");
        int action = motionEvent.getAction() & 255;
        int y = (int) motionEvent.getY();
        switch (action) {
            case 0:
                this.wqz = y;
                break;
            case 2:
                int i2 = this.wqz - y;
                if (Math.abs(i2) > ViewConfiguration.getTouchSlop()) {
                    scrollBy(0, i2);
                }
                this.wqz = y;
                break;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(255062);
        return onTouchEvent;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(255063);
        super.onMeasure(i2, i3);
        View view = this.wqx;
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        if (layoutParams != null) {
            int measuredHeight = getMeasuredHeight();
            View view2 = this.wqt;
            layoutParams.height = (view2 != null ? view2.getMeasuredHeight() : 0) + measuredHeight;
        }
        View view3 = this.wqx;
        if (view3 != null) {
            view3.setLayoutParams(layoutParams);
        }
        super.onMeasure(i2, i3);
        AppMethodBeat.o(255063);
    }

    public final void scrollTo(int i2, int i3) {
        boolean z = false;
        AppMethodBeat.i(255064);
        if (i3 < 0) {
            i3 = 0;
        }
        if (i3 > this.wqv) {
            i3 = this.wqv;
        }
        super.scrollTo(i2, i3);
        if (getScrollY() == this.wqv) {
            z = true;
        }
        this.wqy = z;
        AppMethodBeat.o(255064);
    }

    /* access modifiers changed from: protected */
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(255065);
        super.onSizeChanged(i2, i3, i4, i5);
        View view = this.wqt;
        this.wqv = view != null ? view.getMeasuredHeight() : 0;
        AppMethodBeat.o(255065);
    }

    /* access modifiers changed from: protected */
    public final void onFinishInflate() {
        AppMethodBeat.i(255066);
        super.onFinishInflate();
        this.wqx = findViewById(R.id.h7t);
        AppMethodBeat.o(255066);
    }
}
