package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;

public final class AppBrandLauncherBlankPage extends AppBrandLauncherUI.Fragment {
    public static AppBrandLauncherBlankPage eJ(String str, String str2) {
        AppMethodBeat.i(48619);
        AppBrandLauncherBlankPage appBrandLauncherBlankPage = new AppBrandLauncherBlankPage();
        Bundle bundle = new Bundle(2);
        bundle.putString("extra_title", str);
        bundle.putString("extra_tip", str2);
        appBrandLauncherBlankPage.setArguments(bundle);
        AppMethodBeat.o(48619);
        return appBrandLauncherBlankPage;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment
    public final int getLayoutId() {
        return -1;
    }

    @Override // android.support.v4.app.Fragment
    public final void onResume() {
        AppMethodBeat.i(48620);
        super.onResume();
        if (getActivity() != null) {
            getActivity().setTitle(getArguments() == null ? "" : getArguments().getString("extra_title"));
        }
        AppMethodBeat.o(48620);
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.Fragment
    public final void initView() {
        String string;
        AppMethodBeat.i(48621);
        FragmentActivity activity = getActivity();
        if (getArguments() == null) {
            string = null;
        } else {
            string = getArguments().getString("extra_tip");
        }
        ((ViewGroup) this.mContentView).addView(ag(activity, string), new ViewGroup.LayoutParams(-1, -1));
        i.a(this.mScene, "", "", 0, "", this.nTU);
        AppMethodBeat.o(48621);
    }

    public static ViewGroup ag(Context context, String str) {
        AppMethodBeat.i(48622);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.raw.app_brand_launcher_blank_tip_icon);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a.fromDPToPix(context, 50), a.fromDPToPix(context, 50));
        layoutParams.topMargin = a.fromDPToPix(context, 91);
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(context);
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(Color.parseColor("#B2B2B2"));
        textView.setGravity(17);
        if (str == null) {
            str = "";
        }
        textView.setText(str);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = a.fromDPToPix(context, 16);
        layoutParams2.gravity = 1;
        linearLayout.addView(textView, layoutParams2);
        AppMethodBeat.o(48622);
        return linearLayout;
    }
}
