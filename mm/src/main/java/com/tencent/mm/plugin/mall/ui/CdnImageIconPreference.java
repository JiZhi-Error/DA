package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.IconPreference;

public class CdnImageIconPreference extends IconPreference {
    String iconUrl;
    private CdnImageView zjO;

    public CdnImageIconPreference(Context context) {
        super(context);
    }

    public CdnImageIconPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CdnImageIconPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference, com.tencent.mm.ui.base.preference.IconPreference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(66028);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.pc, viewGroup2);
        AppMethodBeat.o(66028);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference, com.tencent.mm.ui.base.preference.IconPreference
    public final void onBindView(View view) {
        AppMethodBeat.i(66029);
        super.onBindView(view);
        this.zjO = (CdnImageView) view.findViewById(R.id.dvz);
        if (!Util.isNullOrNil(this.iconUrl)) {
            this.zjO.setUseSdcardCache(true);
            this.zjO.setUrl(this.iconUrl);
            this.zjO.setVisibility(0);
        }
        AppMethodBeat.o(66029);
    }
}
