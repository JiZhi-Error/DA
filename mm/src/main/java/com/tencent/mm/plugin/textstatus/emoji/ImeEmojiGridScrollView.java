package com.tencent.mm.plugin.textstatus.emoji;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u001a\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiGridScrollView;", "Landroid/support/v4/widget/NestedScrollView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lastY", "getLastY", "()I", "setLastY", "(I)V", "onInterceptTouchEvent", "", "event", "Landroid/view/MotionEvent;", "Companion", "plugin-textstatus_release"})
public final class ImeEmojiGridScrollView extends NestedScrollView {
    public static final a VcV = new a((byte) 0);
    private int wqz;

    static {
        AppMethodBeat.i(258337);
        AppMethodBeat.o(258337);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/emoji/ImeEmojiGridScrollView$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ImeEmojiGridScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(258335);
        AppMethodBeat.o(258335);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImeEmojiGridScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(258336);
        AppMethodBeat.o(258336);
    }

    public final int getLastY() {
        return this.wqz;
    }

    public final void setLastY(int i2) {
        this.wqz = i2;
    }

    @Override // android.support.v4.widget.NestedScrollView
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(258334);
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getActionMasked()) : null;
        int floatValue = (int) ((Float) (motionEvent != null ? Float.valueOf(motionEvent.getRawY()) : Double.valueOf(0.0d))).floatValue();
        Log.v("WxIme.ImeEmojiGridScrollView", "action " + valueOf + ' ' + getX());
        if (valueOf != null && valueOf.intValue() == 0) {
            this.wqz = floatValue;
        } else if (valueOf != null && valueOf.intValue() == 2 && Math.abs(this.wqz - floatValue) > 20) {
            Log.i("WxIme.ImeEmojiGridScrollView", "ImeEmojiGridScrollView onInterceptTouchEvent");
            AppMethodBeat.o(258334);
            return true;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(258334);
        return onInterceptTouchEvent;
    }
}
