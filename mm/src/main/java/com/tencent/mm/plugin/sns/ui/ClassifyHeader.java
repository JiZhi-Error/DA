package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class ClassifyHeader extends LinearLayout {
    private TextView hPW;
    private Context mContext;
    private ImageView zky;

    @TargetApi(11)
    public ClassifyHeader(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(97829);
        init(context);
        AppMethodBeat.o(97829);
    }

    public ClassifyHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(97830);
        init(context);
        AppMethodBeat.o(97830);
    }

    private void init(Context context) {
        AppMethodBeat.i(97831);
        this.mContext = context;
        View inflate = View.inflate(this.mContext, R.layout.uj, this);
        this.zky = (ImageView) inflate.findViewById(R.id.eaa);
        this.hPW = (TextView) inflate.findViewById(R.id.do_);
        AppMethodBeat.o(97831);
    }

    public void setDesc(String str) {
        AppMethodBeat.i(97832);
        this.hPW.setText(String.valueOf(str));
        AppMethodBeat.o(97832);
    }
}
