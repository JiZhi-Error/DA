package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.HashMap;
import java.util.Map;

public class MMPageControlView extends LinearLayout {
    protected int ORM = R.layout.baq;
    protected Context context;
    protected int count;
    protected ImageView dKU;
    protected Map<Integer, ImageView> map = new HashMap();

    public final void kX(int i2, int i3) {
        AppMethodBeat.i(142052);
        this.count = i2;
        Za(i3);
        AppMethodBeat.o(142052);
    }

    public void setPage(int i2) {
        AppMethodBeat.i(142053);
        Za(i2);
        AppMethodBeat.o(142053);
    }

    public void setIndicatorLayoutRes(int i2) {
        this.ORM = i2;
    }

    public MMPageControlView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(142055);
        this.context = context2;
        AppMethodBeat.o(142055);
    }

    /* access modifiers changed from: protected */
    public void Za(int i2) {
        AppMethodBeat.i(142056);
        removeAllViews();
        if (i2 >= this.count) {
            AppMethodBeat.o(142056);
            return;
        }
        int i3 = this.count;
        for (int i4 = 0; i4 < i3; i4++) {
            this.dKU = null;
            if (i2 == i4) {
                if (this.map.size() > i4) {
                    this.dKU = this.map.get(Integer.valueOf(i4));
                }
                if (this.dKU == null) {
                    this.dKU = (ImageView) View.inflate(this.context, this.ORM, null).findViewById(R.id.fgh);
                    this.map.put(Integer.valueOf(i4), this.dKU);
                }
                this.dKU.setSelected(true);
            } else {
                if (this.map.size() > i4) {
                    this.dKU = this.map.get(Integer.valueOf(i4));
                }
                if (this.dKU == null) {
                    this.dKU = (ImageView) View.inflate(this.context, this.ORM, null).findViewById(R.id.fgh);
                    this.map.put(Integer.valueOf(i4), this.dKU);
                }
                this.dKU.setSelected(false);
            }
            if (i4 == 0) {
                this.dKU.setPadding(0, 0, 0, 0);
            }
            addView(this.dKU);
        }
        AppMethodBeat.o(142056);
    }
}
