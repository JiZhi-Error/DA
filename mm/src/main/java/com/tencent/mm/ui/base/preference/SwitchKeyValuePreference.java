package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.tools.u;

public class SwitchKeyValuePreference extends Preference {
    private TextView BfZ;
    private boolean enable;

    public SwitchKeyValuePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwitchKeyValuePreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142675);
        this.enable = true;
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(142675);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(142676);
        super.onBindView(view);
        this.BfZ = (TextView) view.findViewById(16908304);
        updateView();
        AppMethodBeat.o(142676);
    }

    public final void BE(boolean z) {
        AppMethodBeat.i(142677);
        this.enable = z;
        updateView();
        AppMethodBeat.o(142677);
    }

    private void updateView() {
        AppMethodBeat.i(142678);
        if (this.BfZ == null) {
            AppMethodBeat.o(142678);
        } else if (this.enable) {
            this.BfZ.setTextColor(u.kF(this.mContext));
            AppMethodBeat.o(142678);
        } else {
            this.BfZ.setTextColor(u.kG(this.mContext));
            AppMethodBeat.o(142678);
        }
    }
}
