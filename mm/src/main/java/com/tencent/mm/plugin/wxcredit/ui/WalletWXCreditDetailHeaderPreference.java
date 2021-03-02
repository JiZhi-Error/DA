package com.tencent.mm.plugin.wxcredit.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletWXCreditDetailHeaderPreference extends Preference {
    TextView JQG;
    TextView jUP;
    private LayoutInflater mInflater;

    public WalletWXCreditDetailHeaderPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WalletWXCreditDetailHeaderPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(72361);
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(72361);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(72362);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        this.mInflater.inflate(R.layout.cak, viewGroup2);
        AppMethodBeat.o(72362);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(72363);
        super.onBindView(view);
        this.jUP = (TextView) view.findViewById(R.id.jir);
        this.JQG = (TextView) view.findViewById(R.id.jiy);
        AppMethodBeat.o(72363);
    }
}
