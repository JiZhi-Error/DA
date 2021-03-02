package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class TranslateCommentTextView extends LinearLayout {
    public SnsTranslateResultView ECF;
    public MaskTextView ERU;

    public TranslateCommentTextView(Context context) {
        super(context);
        AppMethodBeat.i(99778);
        init();
        AppMethodBeat.o(99778);
    }

    public TranslateCommentTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(99779);
        init();
        AppMethodBeat.o(99779);
    }

    private void init() {
        AppMethodBeat.i(99780);
        LayoutInflater.from(getContext()).inflate(R.layout.c38, this);
        this.ERU = (MaskTextView) findViewById(R.id.b9h);
        this.ECF = (SnsTranslateResultView) findViewById(R.id.i1c);
        this.ECF.setVisibility(8);
        AppMethodBeat.o(99780);
    }

    public TextView getOriginCommentTextView() {
        return this.ERU;
    }

    public SnsTranslateResultView getTranslateResultView() {
        return this.ECF;
    }
}
