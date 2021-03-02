package com.tencent.mm.ui.base.preference;

import android.content.Context;
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
    private boolean OXp;
    private TextView OXq;
    private a OXr;
    private View.OnClickListener hEZ;
    private View mView;
    private boolean oD;
    private MMSwitchBtn sLW;

    public interface a {
        void dCy();
    }

    public CheckBoxPreference(Context context) {
        this(context, null);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142512);
        this.oD = false;
        this.OXp = false;
        this.HIJ = -1;
        this.HIK = "";
        this.HIL = 8;
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(142512);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference
    public View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(142513);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.b_y, viewGroup2);
        this.mView = onCreateView;
        gLA();
        View view = this.mView;
        AppMethodBeat.o(142513);
        return view;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public void onBindView(View view) {
        AppMethodBeat.i(142514);
        super.onBindView(view);
        alO(8);
        this.OXq = (TextView) view.findViewById(16908304);
        this.sLW = (MMSwitchBtn) view.findViewById(R.id.b0m);
        this.sLW.setSwitchListener(new MMSwitchBtn.a() {
            /* class com.tencent.mm.ui.base.preference.CheckBoxPreference.AnonymousClass1 */

            @Override // com.tencent.mm.ui.widget.MMSwitchBtn.a
            public final void onStatusChange(boolean z) {
                AppMethodBeat.i(142511);
                CheckBoxPreference.this.callChangeListener(Boolean.valueOf(z));
                AppMethodBeat.o(142511);
            }
        });
        this.sLW.setCheck(this.oD);
        this.HMo = (TextView) view.findViewById(R.id.iou);
        fZ(this.HIK, this.HIJ);
        aez(this.HIL);
        gLB();
        if (this.OXr != null) {
            this.OXr.dCy();
        }
        AppMethodBeat.o(142514);
    }

    public final TextView gLy() {
        return this.OXq;
    }

    public boolean isChecked() {
        if (this.sLW != null) {
            return this.sLW.QDw;
        }
        return this.oD;
    }

    public void setChecked(boolean z) {
        this.oD = z;
    }

    public void xZ(boolean z) {
        AppMethodBeat.i(142515);
        if (this.sLW != null) {
            this.oD = z;
            this.sLW.setCheck(z);
        }
        AppMethodBeat.o(142515);
    }

    public void fZ(String str, int i2) {
        AppMethodBeat.i(142516);
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
        AppMethodBeat.o(142516);
    }

    public void aez(int i2) {
        AppMethodBeat.i(142517);
        this.HIL = i2;
        if (this.HMo != null) {
            this.HMo.setVisibility(this.HIL);
        }
        AppMethodBeat.o(142517);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(205290);
        this.hEZ = onClickListener;
        gLA();
        AppMethodBeat.o(205290);
    }

    public final void gLz() {
        AppMethodBeat.i(205291);
        this.OXp = true;
        gLB();
        AppMethodBeat.o(205291);
    }

    private void gLA() {
        AppMethodBeat.i(205292);
        if (!(this.mView == null || this.hEZ == null)) {
            this.mView.setOnClickListener(this.hEZ);
        }
        AppMethodBeat.o(205292);
    }

    private void gLB() {
        AppMethodBeat.i(205293);
        if (!isEnabled() || this.OXp) {
            if (!(this.sLW == null || this.mView == null)) {
                this.sLW.setEnabled(false);
                if (!isEnabled()) {
                    ((TextView) this.mView.findViewById(16908310)).setTextColor(this.mView.getResources().getColor(R.color.m5));
                    ((TextView) this.mView.findViewById(16908304)).setTextColor(this.mView.getResources().getColor(R.color.m5));
                }
            }
            AppMethodBeat.o(205293);
            return;
        }
        AppMethodBeat.o(205293);
    }

    public final void a(a aVar) {
        this.OXr = aVar;
    }
}
