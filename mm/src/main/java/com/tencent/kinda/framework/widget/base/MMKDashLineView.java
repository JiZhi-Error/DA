package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.kinda.gen.DynamicColor;
import com.tencent.kinda.gen.KDashLineView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.at;

public class MMKDashLineView extends MMKView<LinearLayout> implements KDashLineView {
    private LinearLayout contentView;
    private boolean isVertical = false;
    private DynamicColor mDashColor = new DynamicColor(-1, 0);
    private float mDashWidth = ((float) at.fromDPToPix(this.mContext, 2));
    private View mLine;

    public MMKDashLineView() {
        AppMethodBeat.i(170120);
        AppMethodBeat.o(170120);
    }

    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public LinearLayout createView(Context context) {
        AppMethodBeat.i(19013);
        this.contentView = (LinearLayout) View.inflate(context, R.layout.axt, null);
        LinearLayout linearLayout = this.contentView;
        AppMethodBeat.o(19013);
        return linearLayout;
    }

    @Override // com.tencent.kinda.gen.KDashLineView
    public void setDashWidth(float f2) {
        this.mDashWidth = f2;
    }

    @Override // com.tencent.kinda.gen.KDashLineView
    public float getDashWidth() {
        return this.mDashWidth;
    }

    @Override // com.tencent.kinda.gen.KDashLineView
    public void setDashColor(DynamicColor dynamicColor) {
        this.mDashColor = dynamicColor;
    }

    @Override // com.tencent.kinda.gen.KDashLineView
    public DynamicColor getDashColor() {
        return this.mDashColor;
    }

    @Override // com.tencent.kinda.gen.KDashLineView
    public void setVertical(boolean z) {
        AppMethodBeat.i(170121);
        this.isVertical = z;
        if (this.isVertical) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            this.contentView.setGravity(17);
            this.contentView.setLayoutParams(layoutParams);
            this.mLine = this.contentView.findViewById(R.id.g5m);
            ViewGroup.LayoutParams layoutParams2 = this.mLine.getLayoutParams();
            layoutParams2.width = at.fromDPToPix(this.mContext, 60);
            layoutParams2.height = at.fromDPToPix(this.mContext, 60);
            this.mLine.setBackground(this.mContext.getResources().getDrawable(R.drawable.f3));
            this.mLine.setLayoutParams(layoutParams2);
        }
        AppMethodBeat.o(170121);
    }

    @Override // com.tencent.kinda.gen.KDashLineView
    public boolean getVertical() {
        return this.isVertical;
    }
}
