package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class FavCapacityPanel extends LinearLayout {
    private View.OnClickListener dec = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.fav.ui.widget.FavCapacityPanel.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(107503);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/fav/ui/widget/FavCapacityPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            if (FavCapacityPanel.this.tmk == 0) {
                intent.putExtra("key_enter_fav_cleanui_from", 1);
            } else {
                intent.putExtra("key_enter_fav_cleanui_from", 2);
            }
            com.tencent.mm.plugin.fav.a.b.b(FavCapacityPanel.this.getContext(), ".ui.FavCleanUI", intent);
            a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavCapacityPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107503);
        }
    };
    private LinearLayout tmh = this;
    public long tmi;
    public TextView tmj;
    public int tmk = 0;
    public long tml;

    public FavCapacityPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        long j2;
        AppMethodBeat.i(107504);
        View inflate = View.inflate(getContext(), R.layout.a81, null);
        inflate.measure(-2, -2);
        View findViewById = inflate.findViewById(R.id.cb7);
        View findViewById2 = inflate.findViewById(R.id.cb8);
        this.tmj = (TextView) inflate.findViewById(R.id.cb5);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        layoutParams.width = inflate.getMeasuredWidth();
        findViewById.setLayoutParams(layoutParams);
        findViewById2.setOnClickListener(this.dec);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.weight = 1.0f;
        this.tmh.addView(inflate, layoutParams2);
        this.tmi = com.tencent.mm.plugin.fav.a.b.cUh() / 1048576;
        this.tml = com.tencent.mm.plugin.fav.a.b.cUi() / 1048576;
        TextView textView = this.tmj;
        Context context2 = this.tmj.getContext();
        Object[] objArr = new Object[2];
        if (this.tml - this.tmi > 0) {
            j2 = this.tml - this.tmi;
        } else {
            j2 = 0;
        }
        objArr[0] = Long.valueOf(j2);
        objArr[1] = Long.valueOf(this.tmi);
        textView.setText(context2.getString(R.string.c8a, objArr));
        AppMethodBeat.o(107504);
    }
}
