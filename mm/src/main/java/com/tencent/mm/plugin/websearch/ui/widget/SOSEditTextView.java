package com.tencent.mm.plugin.websearch.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.c;
import com.tencent.mm.ui.search.FTSEditTextView;

public class SOSEditTextView extends FTSEditTextView {
    private View IHa;
    private View IHb;
    private View IHc;
    private int IHd = 100;

    public SOSEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SOSEditTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView
    public int getLayoutById() {
        return R.layout.byd;
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView
    @SuppressLint({"WrongViewCast"})
    public final void init() {
        AppMethodBeat.i(116570);
        super.init();
        this.IHa = findViewById(R.id.j9o);
        this.IHb = findViewById(R.id.ik1);
        this.IHc = findViewById(R.id.hd_);
        getEditText().setOnFocusChangeListener(null);
        getEditText().setHintTextColor(getResources().getColor(R.color.wr));
        getEditText().setTextColor(getResources().getColor(R.color.a2x));
        AppMethodBeat.o(116570);
    }

    public final void fYP() {
        AppMethodBeat.i(116571);
        getEditText().setOnFocusChangeListener(this.heD);
        AppMethodBeat.o(116571);
    }

    public void setSearchBarCancelTextContainerVisibile(int i2) {
        AppMethodBeat.i(116572);
        if (this.IHc != null) {
            this.IHc.setVisibility(i2);
        }
        AppMethodBeat.o(116572);
    }

    public void setVoiceImageButtonVisibile(int i2) {
        AppMethodBeat.i(116573);
        if (this.IHa != null) {
            this.IHa.setVisibility(i2);
        }
        AppMethodBeat.o(116573);
    }

    public void setVoiceBtnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(116574);
        if (this.IHa != null) {
            this.IHa.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(116574);
    }

    public void setCancelTextViewVisibile(int i2) {
        AppMethodBeat.i(116575);
        if (this.IHb != null) {
            this.IHb.setVisibility(i2);
        }
        AppMethodBeat.o(116575);
    }

    public void setCancelTextViewClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(116576);
        if (this.IHb != null) {
            this.IHb.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(116576);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView
    public int getLimitInputLength() {
        AppMethodBeat.i(201778);
        int max = Math.max(this.IHd, ((c) g.ah(c.class)).getSosLimitLength());
        AppMethodBeat.o(201778);
        return max;
    }
}
