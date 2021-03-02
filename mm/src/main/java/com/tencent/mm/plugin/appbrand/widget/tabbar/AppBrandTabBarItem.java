package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;

public class AppBrandTabBarItem extends RelativeLayout {
    public AppBrandTabBarItem(Context context) {
        super(context);
        AppMethodBeat.i(219636);
        init();
        AppMethodBeat.o(219636);
    }

    public AppBrandTabBarItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(219637);
        init();
        AppMethodBeat.o(219637);
    }

    private void init() {
        AppMethodBeat.i(219638);
        Context context = getContext();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
        layoutParams.gravity = 16;
        layoutParams.weight = 1.0f;
        setId(R.id.r9);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(R.id.ra);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13, -1);
        linearLayout.setLayoutParams(layoutParams2);
        ImageView imageView = new ImageView(context);
        imageView.setId(R.id.r_);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(a.aG(context, R.dimen.cf), a.aG(context, R.dimen.cf)));
        linearLayout.addView(imageView);
        TextView textView = new TextView(context);
        textView.setId(R.id.rd);
        textView.setTextSize(1, (float) a.aG(context, R.dimen.kc));
        textView.setPadding(a.aG(context, R.dimen.bt), 0, a.aG(context, R.dimen.bt), 0);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        linearLayout.addView(textView);
        addView(linearLayout);
        TextView textView2 = new TextView(context);
        textView2.setId(R.id.r8);
        textView2.setTextSize(1, (float) a.aG(context, R.dimen.ka));
        textView2.setBackground(a.l(context, R.drawable.dz));
        textView2.setTextAppearance(context, R.style.zr);
        textView2.setGravity(17);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(6, R.id.ra);
        layoutParams3.addRule(17, R.id.ra);
        layoutParams3.setMarginStart(a.aG(context, R.dimen.s5));
        textView2.setLayoutParams(layoutParams3);
        addView(textView2);
        ImageView imageView2 = new ImageView(context);
        imageView2.setId(R.id.rc);
        imageView2.setBackground(a.l(context, R.drawable.b1a));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(a.aG(context, R.dimen.c5), a.aG(context, R.dimen.c5));
        layoutParams4.addRule(6, R.id.ra);
        layoutParams4.addRule(17, R.id.ra);
        layoutParams4.setMarginStart(a.aG(context, R.dimen.s6));
        layoutParams4.topMargin = a.fromDPToPix(context, 1);
        imageView2.setLayoutParams(layoutParams4);
        addView(imageView2);
        View view = new View(context);
        view.setId(R.id.rb);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, a.aG(context, R.dimen.bt));
        layoutParams5.addRule(18, R.id.ra);
        layoutParams5.addRule(19, R.id.ra);
        layoutParams5.addRule(12, -1);
        view.setLayoutParams(layoutParams5);
        addView(view);
        AppMethodBeat.o(219638);
    }
}
