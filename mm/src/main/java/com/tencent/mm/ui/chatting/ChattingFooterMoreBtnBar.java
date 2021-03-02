package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.imageview.WeImageButton;

public class ChattingFooterMoreBtnBar extends LinearLayout {
    private WeImageButton Phu;
    private WeImageButton Phv;
    private WeImageButton Phw;
    private WeImageButton Phx;
    private WeImageButton Phy;
    private LinearLayout.LayoutParams xTw = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.dimen.k4), 1.0f);

    public ChattingFooterMoreBtnBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(34552);
        setOrientation(0);
        setGravity(16);
        setBackground(at.aN(getContext(), R.attr.sh));
        this.xTw.topMargin = a.fromDPToPix(getContext(), 0);
        this.Phu = new WeImageButton(getContext());
        this.Phu.setImageResource(R.drawable.mm);
        this.Phu.setScaleType(ImageView.ScaleType.CENTER);
        this.Phu.setBackgroundResource(0);
        this.Phu.setContentDescription(context.getString(R.string.b11));
        this.Phy = new WeImageButton(getContext());
        this.Phy.setImageResource(R.drawable.mj);
        this.Phy.setScaleType(ImageView.ScaleType.CENTER);
        this.Phy.setBackgroundResource(0);
        this.Phy.setContentDescription(context.getString(R.string.b10));
        this.Phx = new WeImageButton(getContext());
        this.Phx.setImageResource(R.drawable.mh);
        this.Phx.setScaleType(ImageView.ScaleType.CENTER);
        this.Phx.setBackgroundResource(0);
        this.Phx.setContentDescription(context.getString(R.string.b0y));
        this.Phw = new WeImageButton(getContext());
        this.Phw.setImageResource(R.drawable.mk);
        this.Phw.setScaleType(ImageView.ScaleType.CENTER);
        this.Phw.setBackgroundResource(0);
        this.Phw.setContentDescription(context.getString(R.string.b0x));
        this.Phv = new WeImageButton(getContext());
        this.Phv.setImageResource(R.drawable.mi);
        this.Phv.setScaleType(ImageView.ScaleType.CENTER);
        this.Phv.setBackgroundResource(0);
        this.Phv.setContentDescription(context.getString(R.string.b0z));
        eer();
        AppMethodBeat.o(34552);
    }

    public final void eer() {
        AppMethodBeat.i(34553);
        removeAllViews();
        addView(this.Phu, this.xTw);
        addView(this.Phy, this.xTw);
        addView(this.Phx, this.xTw);
        addView(this.Phv, this.xTw);
        AppMethodBeat.o(34553);
    }

    public final void amj(int i2) {
        AppMethodBeat.i(34554);
        boolean z = i2 > 0;
        this.Phu.setClickable(z);
        this.Phu.setEnabled(z);
        if (k.gNu().size() > 0) {
            this.Phw.setClickable(z);
            this.Phw.setEnabled(z);
        } else {
            this.Phv.setClickable(z);
            this.Phv.setEnabled(z);
        }
        this.Phx.setClickable(z);
        this.Phx.setEnabled(z);
        this.Phy.setClickable(z);
        this.Phy.setEnabled(z);
        AppMethodBeat.o(34554);
    }

    public final void b(int i2, View.OnClickListener onClickListener) {
        AppMethodBeat.i(34555);
        switch (i2) {
            case 0:
                this.Phu.setOnClickListener(onClickListener);
                AppMethodBeat.o(34555);
                return;
            case 1:
                this.Phv.setOnClickListener(onClickListener);
                AppMethodBeat.o(34555);
                return;
            case 2:
                this.Phw.setOnClickListener(onClickListener);
                AppMethodBeat.o(34555);
                return;
            case 3:
                this.Phx.setOnClickListener(onClickListener);
                AppMethodBeat.o(34555);
                return;
            case 4:
                this.Phy.setOnClickListener(onClickListener);
                AppMethodBeat.o(34555);
                return;
            default:
                Log.w("Ashu.ChattingFooterMoreBtnBar", "set button listener error button index %d", Integer.valueOf(i2));
                AppMethodBeat.o(34555);
                return;
        }
    }
}
