package com.tencent.mm.api;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;

public abstract class SmileyPanel extends ChatFooterPanel {
    public SmileyPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void set16029ExtraInfo(String str) {
    }
}
