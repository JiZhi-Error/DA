package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u001c\u0010\u000b\u001a\u00020\t8FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\t8FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/StoryCommentBubbleView;", "Landroid/widget/ImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bubbleLeft", "getBubbleLeft", "()I", "setBubbleLeft", "(I)V", "bubbleTop", "getBubbleTop", "setBubbleTop", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "plugin-story_release"})
public final class StoryCommentBubbleView extends ImageView {
    private int FBD;
    private int FBE;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoryCommentBubbleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(120093);
        AppMethodBeat.o(120093);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StoryCommentBubbleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(120094);
        AppMethodBeat.o(120094);
    }

    public final void setBubbleLeft(int i2) {
        this.FBD = i2;
    }

    public final int getBubbleLeft() {
        AppMethodBeat.i(120090);
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int i2 = iArr[0];
        AppMethodBeat.o(120090);
        return i2;
    }

    public final void setBubbleTop(int i2) {
        this.FBE = i2;
    }

    public final int getBubbleTop() {
        AppMethodBeat.i(120091);
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int i2 = iArr[1];
        AppMethodBeat.o(120091);
        return i2;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(120092);
        p.h(motionEvent, "event");
        switch (motionEvent.getActionMasked()) {
            case 0:
                animate().scaleX(1.3f).scaleY(1.3f).setDuration(100).start();
                break;
            case 1:
            case 3:
                animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
                break;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(120092);
        return onTouchEvent;
    }
}
