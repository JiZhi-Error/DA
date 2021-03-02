package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Util;

public class NormalIconTipPreference extends NormalIconPreference {
    private String OZm;
    private TextView pJV;

    public NormalIconTipPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NormalIconTipPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.pJV = null;
        this.OZm = "";
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference, com.tencent.mm.ui.base.preference.IconPreference, com.tencent.mm.ui.base.preference.NormalIconPreference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(205301);
        View onCreateView = super.onCreateView(viewGroup);
        AppMethodBeat.o(205301);
        return onCreateView;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.preference.Preference, com.tencent.mm.ui.base.preference.IconPreference
    public final void onBindView(View view) {
        AppMethodBeat.i(205302);
        super.onBindView(view);
        this.pJV = (TextView) view.findViewById(R.id.dua);
        gLP();
        View findViewById = view.findViewById(R.id.h7f);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        AppMethodBeat.o(205302);
    }

    public final void bml(String str) {
        AppMethodBeat.i(205303);
        this.OZm = str;
        gLP();
        AppMethodBeat.o(205303);
    }

    private void gLP() {
        AppMethodBeat.i(205304);
        if (this.pJV != null) {
            if (Util.isNullOrNil(this.OZm)) {
                this.pJV.setVisibility(8);
                this.pJV.setText("");
                AppMethodBeat.o(205304);
                return;
            }
            this.pJV.setVisibility(0);
            this.pJV.setText(this.OZm);
        }
        AppMethodBeat.o(205304);
    }
}
