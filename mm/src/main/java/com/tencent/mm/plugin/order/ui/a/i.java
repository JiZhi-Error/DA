package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.ui.base.preference.Preference;

public final class i extends Preference {
    private int AQP = Integer.MAX_VALUE;
    String AQQ;
    private View mView = null;

    public i(Context context) {
        super(context);
        AppMethodBeat.i(66827);
        setLayoutResource(R.layout.b5y);
        AppMethodBeat.o(66827);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(66828);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(66828);
        return view2;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(66829);
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.id.f7v);
        ((TextView) view.findViewById(R.id.f7w)).setText(getTitle());
        textView.setText(this.AQQ);
        if (this.AQP != Integer.MAX_VALUE) {
            textView.setTextColor(this.AQP);
        }
        AppMethodBeat.o(66829);
    }

    public final void aJH(String str) {
        AppMethodBeat.i(66830);
        try {
            this.AQP = g.cI(str, true);
            AppMethodBeat.o(66830);
        } catch (Exception e2) {
            this.AQP = -1;
            AppMethodBeat.o(66830);
        }
    }
}
