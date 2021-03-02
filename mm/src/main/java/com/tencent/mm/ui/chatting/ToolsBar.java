package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.imageview.WeImageButton;

public class ToolsBar extends LinearLayout {
    private WeImageButton Phu = new WeImageButton(getContext());
    private WeImageButton Phy;
    private WeImageButton Pld;
    private LinearLayout.LayoutParams xTw = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.dimen.k4), 1.0f);

    public ToolsBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(34960);
        setOrientation(0);
        setGravity(16);
        setBackground(at.aN(getContext(), R.attr.sh));
        this.Phu.setImageResource(R.drawable.mm);
        this.Phu.setScaleType(ImageView.ScaleType.CENTER);
        this.Phu.setBackgroundResource(0);
        this.Phu.setContentDescription(context.getString(R.string.b11));
        this.Phy = new WeImageButton(getContext());
        this.Phy.setImageResource(R.drawable.mj);
        this.Phy.setScaleType(ImageView.ScaleType.CENTER);
        this.Phy.setBackgroundResource(0);
        this.Phy.setContentDescription(context.getString(R.string.b10));
        this.Pld = new WeImageButton(getContext());
        this.Pld.setImageResource(R.drawable.ml);
        this.Pld.setScaleType(ImageView.ScaleType.CENTER);
        this.Pld.setBackgroundResource(0);
        this.Pld.setContentDescription(context.getString(R.string.b10));
        removeAllViews();
        addView(this.Phu, this.xTw);
        addView(this.Phy, this.xTw);
        addView(this.Pld, this.xTw);
        AppMethodBeat.o(34960);
    }

    public final void b(int i2, View.OnClickListener onClickListener) {
        AppMethodBeat.i(34961);
        switch (i2) {
            case 0:
                this.Phu.setOnClickListener(onClickListener);
                AppMethodBeat.o(34961);
                return;
            case 1:
                this.Phy.setOnClickListener(onClickListener);
                AppMethodBeat.o(34961);
                return;
            case 2:
                this.Pld.setOnClickListener(onClickListener);
                AppMethodBeat.o(34961);
                return;
            default:
                Log.w("MicroMsg.ToolsBar", "set button listener error button index %d", Integer.valueOf(i2));
                AppMethodBeat.o(34961);
                return;
        }
    }
}
