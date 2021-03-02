package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class an extends RelativeLayout {
    private int PMC;
    private LayoutInflater kgB;

    public an(LayoutInflater layoutInflater, int i2) {
        super(layoutInflater.getContext());
        AppMethodBeat.i(37191);
        this.kgB = layoutInflater;
        this.PMC = i2;
        setClipChildren(false);
        View inflate = this.kgB.inflate(R.layout.ty, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        inflate.setId(R.id.axn);
        layoutParams.setMargins(0, getResources().getDimensionPixelSize(R.dimen.ir), 0, getResources().getDimensionPixelSize(R.dimen.ir));
        inflate.setVisibility(8);
        addView(inflate, layoutParams);
        View inflate2 = this.kgB.inflate(R.layout.qi, (ViewGroup) null);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        inflate2.setId(R.id.avm);
        layoutParams2.setMargins(0, getResources().getDimensionPixelSize(R.dimen.ir), 0, getResources().getDimensionPixelSize(R.dimen.ir));
        layoutParams2.addRule(3, R.id.axn);
        inflate2.setVisibility(8);
        addView(inflate2, layoutParams2);
        TextView textView = new TextView(getContext(), null, R.style.h1);
        textView.setId(R.id.ayf);
        int dimensionPixelSize = textView.getResources().getDimensionPixelSize(R.dimen.kc);
        int aG = a.aG(getContext(), R.dimen.kc);
        if (aG != dimensionPixelSize) {
            Log.e("MicroMsg.ChattingItemContainer", "warn!!! cacheSize:%s sysSize:%s", Integer.valueOf(aG), Integer.valueOf(dimensionPixelSize));
        }
        textView.setTextSize(0, (float) dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(3, R.id.avm);
        layoutParams3.addRule(14);
        layoutParams3.setMargins(0, getResources().getDimensionPixelSize(R.dimen.ir), 0, getResources().getDimensionPixelSize(R.dimen.ir));
        addView(textView, layoutParams3);
        CheckBox checkBox = (CheckBox) LayoutInflater.from(getContext()).inflate(R.layout.b7m, (ViewGroup) this, false);
        checkBox.setId(R.id.aue);
        int fromDPToPix = a.fromDPToPix(getContext(), 24);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(fromDPToPix, fromDPToPix);
        layoutParams4.setMargins(getResources().getDimensionPixelSize(R.dimen.k5), getResources().getDimensionPixelSize(R.dimen.r), -getResources().getDimensionPixelSize(R.dimen.bt), 0);
        layoutParams4.addRule(3, R.id.ayf);
        layoutParams4.addRule(9);
        layoutParams4.width = fromDPToPix;
        layoutParams4.height = fromDPToPix;
        addView(checkBox, layoutParams4);
        View inflate3 = this.kgB.inflate(this.PMC, (ViewGroup) null);
        int id = inflate3.getId();
        if (-1 == id) {
            Log.v("MicroMsg.ChattingItemContainer", "content view has no id, use defaul id");
            id = R.id.aui;
            inflate3.setId(R.id.aui);
        }
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(3, R.id.ayf);
        layoutParams5.addRule(1, R.id.aue);
        addView(inflate3, layoutParams5);
        View view = new View(getContext());
        view.setId(R.id.ax3);
        view.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams6.addRule(6, id);
        layoutParams6.addRule(8, id);
        addView(view, layoutParams6);
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundColor(imageView.getResources().getColor(R.color.FG_2));
        imageView.setId(R.id.aug);
        imageView.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams7.addRule(6, id);
        layoutParams7.addRule(8, id);
        addView(imageView, layoutParams7);
        AppMethodBeat.o(37191);
    }
}
