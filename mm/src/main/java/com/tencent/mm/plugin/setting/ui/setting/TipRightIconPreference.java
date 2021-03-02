package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.IconPreference;

public class TipRightIconPreference extends IconPreference {
    public TipRightIconPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public TipRightIconPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference, com.tencent.mm.ui.base.preference.IconPreference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(74567);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.b_4, viewGroup2);
        AppMethodBeat.o(74567);
        return onCreateView;
    }
}
