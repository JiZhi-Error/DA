package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public final class f extends Preference {
    private View mView = null;

    public f(Context context) {
        super(context);
        AppMethodBeat.i(51812);
        setLayoutResource(R.layout.bit);
        AppMethodBeat.o(51812);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(51813);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        super.onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(51813);
        return view2;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(261896);
        super.onBindView(view);
        AppMethodBeat.o(261896);
    }
}
