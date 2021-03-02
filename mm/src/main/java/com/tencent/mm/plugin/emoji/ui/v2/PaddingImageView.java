package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;

public class PaddingImageView extends FrameLayout {
    ImageView cIN;
    ImageView rnd;
    private int rne;

    public ImageView getImageView() {
        return this.cIN;
    }

    public ImageView getImageViewFG() {
        return this.rnd;
    }

    public PaddingImageView(Context context) {
        super(context);
        AppMethodBeat.i(109408);
        init(context);
        AppMethodBeat.o(109408);
    }

    public PaddingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(109409);
        init(context);
        AppMethodBeat.o(109409);
    }

    public PaddingImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(109410);
        init(context);
        AppMethodBeat.o(109410);
    }

    private void init(Context context) {
        AppMethodBeat.i(109411);
        this.rne = a.aG(getContext(), R.dimen.ir);
        this.cIN = new ImageView(context);
        this.cIN.setPadding(this.rne, this.rne, this.rne, this.rne);
        this.rnd = new ImageView(context);
        AppMethodBeat.o(109411);
    }
}
