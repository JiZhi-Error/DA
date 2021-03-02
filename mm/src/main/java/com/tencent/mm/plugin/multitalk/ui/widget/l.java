package com.tencent.mm.plugin.multitalk.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.ui.a;

public final class l implements View.OnClickListener {
    private Context context;
    private int size = 0;
    private int wfQ = f.wfQ;
    private int zSk = (f.wfQ * 4);
    private int zSn = f.zSn;
    private LinearLayout zTA;
    private LinearLayout zTB;
    private LinearLayout zTC;
    private int zTD;
    private int zTE;
    private int zTF = (f.wfQ + f.zSd);
    private int zTG = ((f.wfQ * 2) + f.zSd);
    public int zTH;

    public l(Activity activity) {
        AppMethodBeat.i(114726);
        this.context = activity.getBaseContext();
        int jn = a.jn(this.context) - (this.zSk * 2);
        this.zTD = (jn - (this.zTF * 10)) / 5;
        this.zTE = (jn - (this.zTG * 10)) / 5;
        this.zTA = (LinearLayout) activity.findViewById(R.id.wv);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.zTA.getLayoutParams();
        layoutParams.topMargin = this.wfQ * 2;
        layoutParams.bottomMargin = this.wfQ * 2;
        layoutParams.leftMargin = this.zSk;
        layoutParams.rightMargin = this.zSk;
        this.zTA.setLayoutParams(layoutParams);
        this.zTB = new LinearLayout(this.context);
        this.zTC = new LinearLayout(this.context);
        this.zTB.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        this.zTC.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        RelativeLayout relativeLayout = new RelativeLayout(this.context);
        relativeLayout.addView(this.zTC);
        relativeLayout.setLayoutParams(layoutParams3);
        this.zTA.addView(this.zTB);
        this.zTA.addView(relativeLayout);
        AppMethodBeat.o(114726);
    }

    public final void aGw(String str) {
        AppMethodBeat.i(114727);
        this.size++;
        ImageView imageView = new ImageView(this.context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView.setTag(str);
        imageView.setOnClickListener(this);
        a.b.c(imageView, str);
        if (this.size <= 5) {
            this.zTB.addView(imageView);
        } else {
            this.zTC.addView(imageView);
        }
        Rt(this.size);
        Ru(this.size);
        AppMethodBeat.o(114727);
    }

    public final void KK(String str) {
        boolean z;
        int i2;
        boolean z2 = true;
        AppMethodBeat.i(178927);
        if (this.size == 0) {
            AppMethodBeat.o(178927);
            return;
        }
        int i3 = -1;
        int i4 = 0;
        while (true) {
            if (i4 >= this.zTB.getChildCount()) {
                z = false;
                break;
            } else if (this.zTB.getChildAt(i4).getTag().equals(str)) {
                i3 = i4;
                z = true;
                break;
            } else {
                i4++;
            }
        }
        if (i3 < 0) {
            i2 = 0;
            while (true) {
                if (i2 >= this.zTC.getChildCount()) {
                    break;
                } else if (this.zTC.getChildAt(i2).getTag().equals(str)) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        i2 = i3;
        z2 = false;
        if (i2 < 0) {
            AppMethodBeat.o(178927);
            return;
        }
        if (z2) {
            this.zTC.removeViewAt(i2);
            this.size--;
        }
        if (z) {
            if (this.size <= 5) {
                this.zTB.removeViewAt(i2);
                this.size--;
            } else {
                this.zTB.removeViewAt(i2);
                View childAt = this.zTC.getChildAt(0);
                this.zTC.removeViewAt(0);
                this.zTB.addView(childAt);
                this.size--;
            }
        }
        Rt(this.size);
        Ru(this.size);
        AppMethodBeat.o(178927);
    }

    private void Rt(int i2) {
        AppMethodBeat.i(114728);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.zTB.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.zTC.getLayoutParams();
        if (i2 <= 5) {
            layoutParams.height = this.zTD;
            this.zTC.setVisibility(8);
            AppMethodBeat.o(114728);
            return;
        }
        layoutParams.height = this.zTE;
        layoutParams.topMargin = this.wfQ * 2;
        layoutParams.bottomMargin = this.wfQ * 2;
        this.zTC.setVisibility(0);
        layoutParams2.height = this.zTE;
        layoutParams2.topMargin = this.wfQ * 2;
        layoutParams2.bottomMargin = this.wfQ * 2;
        AppMethodBeat.o(114728);
    }

    private void Ru(int i2) {
        int i3 = 0;
        AppMethodBeat.i(114729);
        if (i2 <= 5) {
            for (int i4 = 0; i4 < this.zTB.getChildCount(); i4++) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.zTB.getChildAt(i4).getLayoutParams();
                layoutParams.width = this.zTD;
                layoutParams.height = this.zTD;
                layoutParams.rightMargin = this.zTF;
                layoutParams.leftMargin = this.zTF;
            }
            while (i3 < this.zTC.getChildCount()) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.zTC.getChildAt(i3).getLayoutParams();
                layoutParams2.width = this.zTE;
                layoutParams2.height = this.zTE;
                layoutParams2.rightMargin = this.zTF;
                layoutParams2.leftMargin = this.zTF;
                i3++;
            }
            AppMethodBeat.o(114729);
            return;
        }
        for (int i5 = 0; i5 < this.zTB.getChildCount(); i5++) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.zTB.getChildAt(i5).getLayoutParams();
            layoutParams3.width = this.zTE;
            layoutParams3.height = this.zTE;
            layoutParams3.rightMargin = this.zTG;
            layoutParams3.leftMargin = this.zTG;
        }
        while (i3 < this.zTC.getChildCount()) {
            LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.zTC.getChildAt(i3).getLayoutParams();
            layoutParams4.width = this.zTE;
            layoutParams4.height = this.zTE;
            layoutParams4.rightMargin = this.zTG;
            layoutParams4.leftMargin = this.zTG;
            i3++;
        }
        AppMethodBeat.o(114729);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(114730);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSelectContactGallery", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        this.zTH++;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/MultiTalkSelectContactGallery", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(114730);
    }
}
