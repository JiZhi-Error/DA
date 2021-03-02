package com.tencent.weui.base.preference;

import android.content.Context;
import android.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.MMSwitchBtn;

public class CheckBoxPreference extends Preference {
    private int HIJ;
    private String HIK;
    private int HIL;
    private TextView HMo;
    private View mView;
    boolean oD;
    private MMSwitchBtn sLW;

    static /* synthetic */ boolean a(CheckBoxPreference checkBoxPreference, Object obj) {
        AppMethodBeat.i(159989);
        boolean callChangeListener = checkBoxPreference.callChangeListener(obj);
        AppMethodBeat.o(159989);
        return callChangeListener;
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(159986);
        this.oD = false;
        this.HIJ = -1;
        this.HIK = "";
        this.HIL = 8;
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(159986);
    }

    /* access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(159987);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        View.inflate(getContext(), R.layout.b_y, viewGroup2);
        this.mView = onCreateView;
        View view = this.mView;
        AppMethodBeat.o(159987);
        return view;
    }

    public void onBindView(View view) {
        AppMethodBeat.i(159988);
        super.onBindView(view);
        this.sLW = (MMSwitchBtn) view.findViewById(R.id.b0m);
        this.sLW.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.weui.base.preference.CheckBoxPreference.AnonymousClass1 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                AppMethodBeat.i(159985);
                CheckBoxPreference.a(CheckBoxPreference.this, Boolean.valueOf(z));
                AppMethodBeat.o(159985);
            }
        });
        this.sLW.setCheck(this.oD);
        if (!isEnabled()) {
            this.sLW.setEnabled(false);
            ((TextView) view.findViewById(16908310)).setTextColor(view.getResources().getColor(R.color.fs));
        }
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
        aez(this.HIL);
        AppMethodBeat.o(159988);
    }

    public final boolean isChecked() {
        if (this.sLW != null) {
            return this.sLW.QDw;
        }
        return this.oD;
    }

    public final void setChecked(boolean z) {
        this.oD = z;
    }

    public final void xZ(boolean z) {
        AppMethodBeat.i(198547);
        if (this.sLW != null) {
            this.oD = z;
            this.sLW.setCheck(z);
        }
        AppMethodBeat.o(198547);
    }

    public final void aez(int i2) {
        AppMethodBeat.i(198548);
        this.HIL = i2;
        if (this.HMo != null) {
            this.HMo.setVisibility(this.HIL);
        }
        AppMethodBeat.o(198548);
    }
}
