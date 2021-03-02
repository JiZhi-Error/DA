package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.MMPageControlView;

public class AdLandingControlView extends MMPageControlView {
    public AdLandingControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mm.ui.base.MMPageControlView
    public final void Za(int i2) {
        AppMethodBeat.i(96829);
        removeAllViews();
        if (i2 >= this.count) {
            AppMethodBeat.o(96829);
            return;
        }
        int i3 = this.count;
        for (int i4 = 0; i4 < i3; i4++) {
            this.dKU = null;
            if (i2 == i4) {
                if (this.map.size() > i4) {
                    this.dKU = (ImageView) this.map.get(Integer.valueOf(i4));
                }
                if (this.dKU == null) {
                    this.dKU = (ImageView) View.inflate(this.context, this.ORM, null).findViewById(R.id.fgh);
                    this.map.put(Integer.valueOf(i4), this.dKU);
                }
                this.dKU.setSelected(true);
            } else {
                if (this.map.size() > i4) {
                    this.dKU = (ImageView) this.map.get(Integer.valueOf(i4));
                }
                if (this.dKU == null) {
                    this.dKU = (ImageView) View.inflate(this.context, this.ORM, null).findViewById(R.id.fgh);
                    this.map.put(Integer.valueOf(i4), this.dKU);
                }
                this.dKU.setSelected(false);
            }
            addView(this.dKU);
        }
        AppMethodBeat.o(96829);
    }
}
