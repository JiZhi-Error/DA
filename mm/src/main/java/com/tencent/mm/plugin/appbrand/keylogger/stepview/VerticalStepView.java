package com.tencent.mm.plugin.appbrand.keylogger.stepview;

import android.content.Context;
import android.support.v4.content.b;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepViewIndicator;
import java.util.List;

public class VerticalStepView extends LinearLayout implements VerticalStepViewIndicator.a {
    private TextView Ws;
    private int mAk;
    private RelativeLayout mPK;
    public VerticalStepViewIndicator mPL;
    public List<c> mPM;
    private int mPN;
    private int mPO;
    private int mPP;

    public VerticalStepView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerticalStepView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(221336);
        this.mPO = b.n(getContext(), R.color.acl);
        this.mPP = b.n(getContext(), 17170443);
        this.mAk = 14;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ccm, this);
        this.mPL = (VerticalStepViewIndicator) inflate.findViewById(R.id.i5x);
        this.mPL.setOnDrawListener(this);
        this.mPK = (RelativeLayout) inflate.findViewById(R.id.h7w);
        AppMethodBeat.o(221336);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(221337);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(221337);
    }

    @Override // com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepViewIndicator.a
    public final void bNc() {
        AppMethodBeat.i(221338);
        if (this.mPK != null) {
            this.mPK.removeAllViews();
            List<Float> circleCenterPointPositionList = this.mPL.getCircleCenterPointPositionList();
            if (!(this.mPM == null || circleCenterPointPositionList == null || circleCenterPointPositionList.size() <= 0)) {
                for (int i2 = 0; i2 < this.mPM.size(); i2++) {
                    this.Ws = new TextView(getContext());
                    this.Ws.setTextSize(2, (float) this.mAk);
                    this.Ws.setText(this.mPM.get(i2).mPJ);
                    this.Ws.setY(circleCenterPointPositionList.get(i2).floatValue() - (this.mPL.getCircleRadius() / 2.0f));
                    this.Ws.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    if (i2 <= this.mPN) {
                        this.Ws.setTypeface(null, 1);
                        this.Ws.setTextColor(this.mPP);
                    } else {
                        this.Ws.setTextColor(this.mPO);
                    }
                    this.mPK.addView(this.Ws);
                }
            }
        }
        AppMethodBeat.o(221338);
    }
}
