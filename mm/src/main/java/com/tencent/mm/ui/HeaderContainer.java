package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class HeaderContainer extends FrameLayout {
    private Rect FTJ = new Rect();
    private j OCr;
    private ad OCs;

    public HeaderContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(33167);
        init(context);
        AppMethodBeat.o(33167);
    }

    public HeaderContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(33168);
        init(context);
        AppMethodBeat.o(33168);
    }

    public void setAnimController(j jVar) {
        AppMethodBeat.i(33169);
        this.OCr = jVar;
        if (!(this.OCs == null || this.OCr == null)) {
            this.OCr.a(this.OCs);
        }
        AppMethodBeat.o(33169);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(33170);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(33170);
    }

    private void init(Context context) {
        AppMethodBeat.i(33171);
        this.OCs = new ad(context);
        this.OCs.setHeaderContainer(this);
        this.OCs.setId(R.id.fl_);
        addView(this.OCs, new FrameLayout.LayoutParams(-1, -2));
        AppMethodBeat.o(33171);
    }

    public Rect getBackUpFooterRect() {
        return this.FTJ;
    }

    public ad getHeaderView() {
        return this.OCs;
    }
}
