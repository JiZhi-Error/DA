package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.R;

public class SightLocationWidget extends LocationWidget {
    public SightLocationWidget(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public SightLocationWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.LocationWidget
    public int getNormalStateImageResource() {
        return R.raw.sight_icon_location_normal;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.LocationWidget
    public int getSelectedStateImageResource() {
        return R.raw.sight_icon_location_selected;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ui.LocationWidget
    public int getLayoutResource() {
        return R.layout.b2f;
    }
}
