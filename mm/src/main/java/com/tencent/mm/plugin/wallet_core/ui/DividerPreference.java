package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.ui.base.preference.Preference;

public class DividerPreference extends Preference {
    private boolean AQN;
    private boolean AQO;
    private View mView;
    private boolean oAJ;

    public DividerPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(70645);
        this.mView = null;
        this.AQN = false;
        this.AQO = false;
        this.oAJ = true;
        setLayoutResource(R.layout.zz);
        AppMethodBeat.o(70645);
    }

    public DividerPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(70646);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(70646);
        return view2;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        int i2;
        AppMethodBeat.i(70647);
        super.onBindView(view);
        View findViewById = view.findViewById(R.id.bsk);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 10.0f);
        if (this.AQN) {
            i2 = fromDPToPix;
        } else {
            i2 = 0;
        }
        if (!this.AQO) {
            fromDPToPix = 0;
        }
        layoutParams.setMargins(0, i2, 0, fromDPToPix);
        findViewById.setLayoutParams(layoutParams);
        if (!this.oAJ) {
            findViewById.setVisibility(4);
            AppMethodBeat.o(70647);
            return;
        }
        findViewById.setVisibility(0);
        AppMethodBeat.o(70647);
    }
}
