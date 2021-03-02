package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.R;

public class SightAtContactWidget extends AtContactWidget {
    @TargetApi(11)
    public SightAtContactWidget(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public SightAtContactWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.AtContactWidget
    public int getLayoutResource() {
        return R.layout.bsm;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.AtContactWidget
    public int getWithDrawableId() {
        return R.raw.sight_icon_mention;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.AtContactWidget
    public int getWithEmptyDrawableId() {
        return R.raw.sight_icon_mention;
    }
}
