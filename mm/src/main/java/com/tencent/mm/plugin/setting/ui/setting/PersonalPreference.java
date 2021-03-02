package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.Preference;

public class PersonalPreference extends Preference {
    int CZh = -1;
    private String dWp;
    private String fMb;
    private TextView gwR = null;
    Bitmap iKs = null;
    private View.OnClickListener tAc;
    ImageView tlo = null;
    String uNR = null;
    private TextView userTV = null;
    private String username;

    public PersonalPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PersonalPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(73903);
        setLayoutResource(R.layout.b8j);
        setWidgetLayoutResource(R.layout.b_t);
        AppMethodBeat.o(73903);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(73904);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.b9h, viewGroup2);
        AppMethodBeat.o(73904);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(73905);
        if (this.tlo == null) {
            this.tlo = (ImageView) view.findViewById(R.id.dvz);
        }
        if (this.iKs != null) {
            this.tlo.setImageBitmap(this.iKs);
        } else if (this.CZh > 0) {
            this.tlo.setImageResource(this.CZh);
        } else if (this.uNR != null) {
            a.b.c(this.tlo, this.uNR);
        }
        this.tlo.setOnClickListener(this.tAc);
        if (!(this.gwR == null || this.dWp == null)) {
            this.gwR.setText(l.b(this.mContext, this.dWp, this.gwR.getTextSize()));
        }
        if (this.userTV != null) {
            String str = Util.isNullOrNil(this.fMb) ? this.username : this.fMb;
            if (Util.isNullOrNil(this.fMb) && as.bjx(this.username)) {
                this.userTV.setVisibility(8);
            }
            this.userTV.setText(this.mContext.getString(R.string.v1) + str);
        }
        super.onBindView(view);
        AppMethodBeat.o(73905);
    }
}
