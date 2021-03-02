package com.tencent.mm.plugin.appbrand.backgroundrunning.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;

public class AppBrandAuthPreference extends Preference {
    private boolean edw;
    private String kYJ;
    private TextView kYK;
    private CheckBox kYL;

    public AppBrandAuthPreference(Context context) {
        this(context, null);
    }

    public AppBrandAuthPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppBrandAuthPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(44802);
        this.edw = false;
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(44802);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(44803);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.ep, viewGroup2);
        AppMethodBeat.o(44803);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(44804);
        super.onBindView(view);
        this.kYL = (CheckBox) view.findViewById(R.id.b0m);
        if (this.kYL != null) {
            this.kYL.setChecked(this.edw);
        }
        this.kYK = (TextView) view.findViewById(R.id.vs);
        if (this.kYK != null && !Util.isNullOrNil(this.kYJ)) {
            this.kYK.setText(this.kYJ);
        }
        alO(8);
        AppMethodBeat.o(44804);
    }

    public final void setChecked(boolean z) {
        AppMethodBeat.i(44806);
        this.edw = z;
        if (this.kYL != null) {
            this.kYL.setChecked(z);
        }
        AppMethodBeat.o(44806);
    }

    public final void wd(int i2) {
        AppMethodBeat.i(44805);
        this.kYJ = this.mContext.getString(i2);
        AppMethodBeat.o(44805);
    }
}
