package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMImageView extends ImageView {
    public MMImageView(Context context) {
        super(context);
    }

    public MMImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        AppMethodBeat.i(141460);
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(MMImageView.class.getName());
        AppMethodBeat.o(141460);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        AppMethodBeat.i(141461);
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(MMImageView.class.getName());
        AppMethodBeat.o(141461);
    }
}
