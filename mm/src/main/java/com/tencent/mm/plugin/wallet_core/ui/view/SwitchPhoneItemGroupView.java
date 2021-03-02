package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.ArrayList;
import java.util.List;

public class SwitchPhoneItemGroupView extends LinearLayout {
    List<SwitchPhoneItemView> ImV = new ArrayList();
    private a ImW;
    private View.OnClickListener ImX = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(71484);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/view/SwitchPhoneItemGroupView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            for (SwitchPhoneItemView switchPhoneItemView : SwitchPhoneItemGroupView.this.ImV) {
                switchPhoneItemView.Inb.setImageResource(R.raw.radio_off);
            }
            ((SwitchPhoneItemView) view).Inb.setImageResource(R.raw.radio_on);
            if (SwitchPhoneItemGroupView.this.ImW != null) {
                SwitchPhoneItemGroupView.this.ImW.gb(view);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/view/SwitchPhoneItemGroupView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(71484);
        }
    };

    public interface a {
        void gb(View view);
    }

    public SwitchPhoneItemGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(71485);
        AppMethodBeat.o(71485);
    }

    public SwitchPhoneItemGroupView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(71486);
        AppMethodBeat.o(71486);
    }

    public void setOnItemSelectListener(a aVar) {
        this.ImW = aVar;
    }

    public final void a(SwitchPhoneItemView switchPhoneItemView, int i2) {
        AppMethodBeat.i(71487);
        addView(switchPhoneItemView, i2);
        this.ImV.add(switchPhoneItemView);
        switchPhoneItemView.setOnClickListener(this.ImX);
        AppMethodBeat.o(71487);
    }
}
