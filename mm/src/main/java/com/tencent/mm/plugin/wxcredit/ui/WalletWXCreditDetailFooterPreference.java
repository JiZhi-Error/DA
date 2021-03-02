package com.tencent.mm.plugin.wxcredit.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletWXCreditDetailFooterPreference extends Preference implements View.OnClickListener {
    private TextView JQE;
    private TextView JQF;
    private LayoutInflater mInflater;
    View.OnClickListener zHh;

    public WalletWXCreditDetailFooterPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WalletWXCreditDetailFooterPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(72357);
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        setLayoutResource(R.layout.b8j);
        AppMethodBeat.o(72357);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(72358);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        this.mInflater.inflate(R.layout.caj, viewGroup2);
        AppMethodBeat.o(72358);
        return onCreateView;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(72359);
        super.onBindView(view);
        this.JQE = (TextView) view.findViewById(R.id.jis);
        this.JQF = (TextView) view.findViewById(R.id.jiq);
        this.JQE.setOnClickListener(this);
        this.JQF.setOnClickListener(this);
        AppMethodBeat.o(72359);
    }

    public void onClick(View view) {
        AppMethodBeat.i(72360);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditDetailFooterPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (this.zHh != null) {
            this.zHh.onClick(view);
        }
        a.a(this, "com/tencent/mm/plugin/wxcredit/ui/WalletWXCreditDetailFooterPreference", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72360);
    }
}
