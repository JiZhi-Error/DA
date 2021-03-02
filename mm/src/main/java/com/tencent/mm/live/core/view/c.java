package com.tencent.mm.live.core.view;

import android.content.Context;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.au;
import java.util.ArrayList;

public final class c {
    public static int dip2px(Context context, float f2) {
        AppMethodBeat.i(196372);
        int i2 = (int) ((context.getResources().getDisplayMetrics().density * f2) + 0.5f);
        AppMethodBeat.o(196372);
        return i2;
    }

    public static RelativeLayout.LayoutParams G(Context context, int i2) {
        AppMethodBeat.i(196373);
        int dip2px = dip2px(context, 10.0f);
        int dip2px2 = dip2px(context, 15.0f);
        int dip2px3 = dip2px(context, 50.0f);
        int dip2px4 = dip2px(context, 192.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px4, dip2px(context, 108.0f));
        layoutParams.leftMargin = ((i2 - dip2px2) - dip2px4) - au.aD(context);
        layoutParams.topMargin = dip2px + dip2px3;
        AppMethodBeat.o(196373);
        return layoutParams;
    }

    public static RelativeLayout.LayoutParams H(Context context, int i2) {
        AppMethodBeat.i(196374);
        int dip2px = dip2px(context, 10.0f);
        int dip2px2 = dip2px(context, 15.0f);
        int dip2px3 = dip2px(context, 50.0f);
        int dip2px4 = dip2px(context, 108.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px4, dip2px(context, 192.0f));
        layoutParams.leftMargin = (i2 - dip2px2) - dip2px4;
        layoutParams.topMargin = dip2px + dip2px3;
        AppMethodBeat.o(196374);
        return layoutParams;
    }

    public static ArrayList<RelativeLayout.LayoutParams> b(Context context, int i2, int i3) {
        AppMethodBeat.i(196375);
        int dip2px = dip2px(context, 10.0f);
        int dip2px2 = dip2px(context, 50.0f);
        ArrayList<RelativeLayout.LayoutParams> arrayList = new ArrayList<>();
        int i4 = (i2 - (dip2px * 2)) / 2;
        int i5 = ((i3 - (dip2px * 2)) - dip2px2) / 2;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i4, i5);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        layoutParams.topMargin = dip2px;
        layoutParams.leftMargin = dip2px;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i4, i5);
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        layoutParams2.topMargin = dip2px;
        layoutParams2.rightMargin = dip2px;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i4, i5);
        layoutParams3.addRule(9);
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = dip2px + dip2px2;
        layoutParams3.leftMargin = dip2px;
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(i4, i5);
        layoutParams4.addRule(11);
        layoutParams4.addRule(12);
        layoutParams4.bottomMargin = dip2px2 + dip2px;
        layoutParams4.rightMargin = dip2px;
        arrayList.add(layoutParams);
        arrayList.add(layoutParams2);
        arrayList.add(layoutParams3);
        arrayList.add(layoutParams4);
        AppMethodBeat.o(196375);
        return arrayList;
    }

    public static ArrayList<RelativeLayout.LayoutParams> c(Context context, int i2, int i3) {
        AppMethodBeat.i(196376);
        int dip2px = dip2px(context, 10.0f);
        int dip2px2 = dip2px(context, 50.0f);
        ArrayList<RelativeLayout.LayoutParams> arrayList = new ArrayList<>();
        int i4 = (i2 - (dip2px * 2)) / 3;
        int i5 = ((i3 - (dip2px * 2)) - dip2px2) / 3;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i4, i5);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        layoutParams.topMargin = dip2px;
        layoutParams.leftMargin = dip2px;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i4, i5);
        layoutParams2.addRule(14);
        layoutParams2.addRule(10);
        layoutParams2.topMargin = dip2px;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i4, i5);
        layoutParams3.addRule(11);
        layoutParams3.addRule(10);
        layoutParams3.topMargin = dip2px;
        layoutParams3.rightMargin = dip2px;
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(i4, i5);
        layoutParams4.addRule(10);
        layoutParams4.addRule(9);
        layoutParams4.leftMargin = dip2px;
        layoutParams4.topMargin = dip2px + i5;
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(i4, i5);
        layoutParams5.addRule(14);
        layoutParams5.topMargin = dip2px + i5;
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(i4, i5);
        layoutParams6.addRule(10);
        layoutParams6.addRule(11);
        layoutParams6.topMargin = dip2px + i5;
        layoutParams6.rightMargin = dip2px;
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(i4, i5);
        layoutParams7.addRule(9);
        layoutParams7.addRule(12);
        layoutParams7.bottomMargin = dip2px + dip2px2;
        layoutParams7.leftMargin = dip2px;
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(i4, i5);
        layoutParams8.addRule(14);
        layoutParams8.addRule(12);
        layoutParams8.bottomMargin = dip2px + dip2px2;
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(i4, i5);
        layoutParams9.addRule(11);
        layoutParams9.addRule(12);
        layoutParams9.bottomMargin = dip2px2 + dip2px;
        layoutParams9.rightMargin = dip2px;
        arrayList.add(layoutParams);
        arrayList.add(layoutParams2);
        arrayList.add(layoutParams3);
        arrayList.add(layoutParams4);
        arrayList.add(layoutParams5);
        arrayList.add(layoutParams6);
        arrayList.add(layoutParams7);
        arrayList.add(layoutParams8);
        arrayList.add(layoutParams9);
        AppMethodBeat.o(196376);
        return arrayList;
    }

    public static RelativeLayout.LayoutParams I(Context context, int i2) {
        AppMethodBeat.i(196377);
        int dip2px = dip2px(context, 10.0f);
        int dip2px2 = dip2px(context, 15.0f);
        int dip2px3 = dip2px(context, 50.0f);
        int dip2px4 = dip2px(context, 108.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px4, dip2px(context, 192.0f));
        layoutParams.leftMargin = (i2 - dip2px2) - dip2px4;
        layoutParams.topMargin = dip2px + dip2px3;
        AppMethodBeat.o(196377);
        return layoutParams;
    }
}
