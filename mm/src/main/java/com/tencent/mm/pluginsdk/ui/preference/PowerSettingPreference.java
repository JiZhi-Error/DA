package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.Preference;

public class PowerSettingPreference extends Preference {
    private ImageView BgV;
    private ImageView BgW;
    private ImageView BgX;
    private as rjX;
    private View zlc;

    public PowerSettingPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public PowerSettingPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(31902);
        if (this.zlc == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
            viewGroup2.removeAllViews();
            viewGroup2.addView(LayoutInflater.from(this.mContext).inflate(R.layout.bjo, (ViewGroup) null), new AbsListView.LayoutParams(-1, -2));
            this.zlc = onCreateView;
        }
        View view = this.zlc;
        AppMethodBeat.o(31902);
        return view;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(31903);
        super.onBindView(view);
        if (this.rjX == null) {
            AppMethodBeat.o(31903);
            return;
        }
        if (this.BgV == null) {
            this.BgV = (ImageView) view.findViewById(R.id.bcp);
        }
        if (this.BgW == null) {
            this.BgW = (ImageView) view.findViewById(R.id.bcn);
        }
        if (this.BgX == null) {
            this.BgX = (ImageView) view.findViewById(R.id.bco);
        }
        this.BgV.setVisibility(this.rjX.arA() ? 0 : 8);
        AppMethodBeat.o(31903);
    }
}
