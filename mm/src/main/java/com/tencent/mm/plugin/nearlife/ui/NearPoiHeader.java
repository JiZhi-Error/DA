package com.tencent.mm.plugin.nearlife.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class NearPoiHeader extends LinearLayout {
    private TextView hPW;
    private ImageView zky;

    @TargetApi(11)
    public NearPoiHeader(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(26621);
        init(context);
        AppMethodBeat.o(26621);
    }

    public NearPoiHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(26622);
        init(context);
        AppMethodBeat.o(26622);
    }

    private void init(Context context) {
        AppMethodBeat.i(26623);
        View inflate = View.inflate(context, R.layout.bet, this);
        this.zky = (ImageView) inflate.findViewById(R.id.eq9);
        this.hPW = (TextView) inflate.findViewById(R.id.eb0);
        AppMethodBeat.o(26623);
    }

    public void setText(CharSequence charSequence) {
        AppMethodBeat.i(26624);
        this.hPW.setText(charSequence);
        AppMethodBeat.o(26624);
    }
}
