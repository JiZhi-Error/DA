package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.ui.base.preference.Preference;

public final class h extends Preference {
    boolean AQN = false;
    boolean AQO = false;
    private View mView = null;
    boolean oAJ = true;

    public h(Context context) {
        super(context);
        AppMethodBeat.i(66824);
        setLayoutResource(R.layout.b5x);
        AppMethodBeat.o(66824);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(66825);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(66825);
        return view2;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        int i2;
        AppMethodBeat.i(66826);
        super.onBindView(view);
        View findViewById = view.findViewById(R.id.f7u);
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
            AppMethodBeat.o(66826);
            return;
        }
        findViewById.setVisibility(0);
        AppMethodBeat.o(66826);
    }
}
