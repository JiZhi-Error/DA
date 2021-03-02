package com.tencent.mm.plugin.mmsight.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar;
import com.tencent.mm.ui.aa;

public class VideoSeekBarEditorView extends LinearLayout {
    private Button sTL;
    public RecyclerThumbSeekBar zDX;
    private Button zDY;
    private LinearLayout zDZ;

    public VideoSeekBarEditorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(94754);
        init(context);
        AppMethodBeat.o(94754);
    }

    public VideoSeekBarEditorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(94755);
        init(context);
        AppMethodBeat.o(94755);
    }

    private void init(Context context) {
        AppMethodBeat.i(94756);
        this.zDZ = (LinearLayout) aa.jQ(context).inflate(R.layout.c5r, (ViewGroup) this, true);
        this.zDX = (RecyclerThumbSeekBar) findViewById(R.id.j6o);
        this.sTL = (Button) findViewById(R.id.bw3);
        this.zDY = (Button) findViewById(R.id.bw6);
        AppMethodBeat.o(94756);
    }

    public void setTextColor(String str) {
        AppMethodBeat.i(94757);
        if (str != null) {
            this.zDY.setTextColor(Color.parseColor(str));
        }
        AppMethodBeat.o(94757);
    }

    public void setFinishButtonClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(94758);
        this.zDY.setOnClickListener(onClickListener);
        AppMethodBeat.o(94758);
    }

    public void setCancelButtonClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(94759);
        this.sTL.setOnClickListener(onClickListener);
        AppMethodBeat.o(94759);
    }

    public final void ele() {
        AppMethodBeat.i(94760);
        this.zDX.release();
        ViewParent parent = this.zDX.getParent();
        if (parent instanceof LinearLayout) {
            ((LinearLayout) parent).removeView(this.zDX);
            this.zDX = new RecyclerThumbSeekBar(getContext());
            ((LinearLayout) parent).addView(this.zDX, 0, (LinearLayout.LayoutParams) this.zDX.getLayoutParams());
        }
        AppMethodBeat.o(94760);
    }
}
