package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class CheckPreference extends Preference {
    private int HIJ;
    private String HIK;
    private int HIL;
    private TextView HMo;
    private CheckBox OXt;
    public int OXu;
    public boolean oD;

    public CheckPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142518);
        this.oD = false;
        this.HIJ = -1;
        this.HIK = "";
        this.HIL = 8;
        this.OXu = -1;
        setLayoutResource(R.layout.b_x);
        AppMethodBeat.o(142518);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(142519);
        View onCreateView = super.onCreateView(viewGroup);
        AppMethodBeat.o(142519);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(142520);
        super.onBindView(view);
        this.OXt = (CheckBox) view.findViewById(R.id.b0m);
        this.OXt.setChecked(this.oD);
        this.HMo = (TextView) view.findViewById(R.id.iou);
        String str = this.HIK;
        int i2 = this.HIJ;
        this.HIJ = i2;
        this.HIK = str;
        if (this.HMo != null) {
            if (i2 > 0) {
                this.HMo.setBackgroundResource(this.HIJ);
            }
            if (!TextUtils.isEmpty(this.HIK)) {
                this.HMo.setText(this.HIK);
            }
        }
        this.HIL = this.HIL;
        if (this.HMo != null) {
            this.HMo.setVisibility(this.HIL);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.OXt.getLayoutParams();
        if (-1 != this.OXu) {
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, this.OXu, layoutParams.bottomMargin);
        }
        AppMethodBeat.o(142520);
    }
}