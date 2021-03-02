package com.tencent.mm.plugin.story.api;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public abstract class AbsStoryHeaderTipView extends RelativeLayout {
    public abstract void fjz();

    public abstract void fmT();

    public abstract void fmU();

    public abstract void onCreateView();

    public abstract void onDestroyView();

    public abstract void setSnsType(int i2);

    public AbsStoryHeaderTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AbsStoryHeaderTipView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
