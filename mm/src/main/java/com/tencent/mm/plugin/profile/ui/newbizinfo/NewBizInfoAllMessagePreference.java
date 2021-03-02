package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class NewBizInfoAllMessagePreference extends Preference {
    private LinearLayout Bjo;
    private h Bjp;
    private MMActivity gte;
    private TextView hXK;
    private TextView titleTv;

    public NewBizInfoAllMessagePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(27492);
        this.gte = (MMActivity) context;
        AppMethodBeat.o(27492);
    }

    public NewBizInfoAllMessagePreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(27493);
        this.gte = (MMActivity) context;
        AppMethodBeat.o(27493);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        boolean z;
        AppMethodBeat.i(27494);
        this.Bjo = (LinearLayout) view.findViewById(R.id.fvj);
        this.titleTv = (TextView) view.findViewById(R.id.fvr);
        this.hXK = (TextView) view.findViewById(R.id.fvk);
        if (this.Bjp != null) {
            if (!Util.isNullOrNil(this.Bjp.field_allArticleWording)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.Bjo.setVisibility(0);
                this.titleTv.setText(this.gte.getString(R.string.b_3));
                this.hXK.setText(this.Bjp.field_allArticleWording);
                AppMethodBeat.o(27494);
                return;
            }
        }
        this.Bjo.setVisibility(8);
        AppMethodBeat.o(27494);
    }
}
