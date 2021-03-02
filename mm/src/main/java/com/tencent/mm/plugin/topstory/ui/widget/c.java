package com.tencent.mm.plugin.topstory.ui.widget;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.topstory.a.c.f;

public final class c {
    private View GqJ;
    private View GqK;
    public f GqS;
    a GqT;
    private int GqU = 16;
    public View contentView;
    public String vid;

    public interface a {
        void a(f fVar);
    }

    public c(View view, a aVar, f fVar, String str) {
        AppMethodBeat.i(126639);
        this.contentView = view;
        this.GqS = fVar;
        this.GqJ = view.findViewById(R.id.bte);
        this.GqK = view.findViewById(R.id.j0d);
        this.GqT = aVar;
        this.vid = str;
        view.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.topstory.ui.widget.c.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(126638);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/topstory/ui/widget/HaokanPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c.this.GqT.a(c.this.GqS);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/HaokanPopupWindow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(126638);
            }
        });
        AppMethodBeat.o(126639);
    }

    public final void a(View view, boolean z, int i2) {
        AppMethodBeat.i(126640);
        int[] b2 = e.b(view.getContext(), view, this.contentView, z);
        b2[0] = b2[0] + 0;
        b2[1] = b2[1] + i2;
        if (!(this.GqK == null || this.GqJ == null)) {
            int fX = e.fX(view) - e.dip2px(view.getContext(), (float) this.GqU);
            if (z) {
                this.GqK.setVisibility(0);
                this.GqJ.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.GqK.getLayoutParams();
                layoutParams.leftMargin = fX;
                this.GqK.setLayoutParams(layoutParams);
            } else {
                this.GqK.setVisibility(8);
                this.GqJ.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.GqJ.getLayoutParams();
                layoutParams2.leftMargin = fX;
                this.GqJ.setLayoutParams(layoutParams2);
            }
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.contentView.getLayoutParams();
        layoutParams3.topMargin = b2[1];
        this.contentView.setLayoutParams(layoutParams3);
        AppMethodBeat.o(126640);
    }
}
