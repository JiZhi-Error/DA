package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class FavDetailTitleView extends LinearLayout {
    private ImageView gvv;
    private TextView jVO;

    public FavDetailTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(107512);
        super.onFinishInflate();
        this.gvv = (ImageView) findViewById(R.id.x1);
        this.jVO = (TextView) findViewById(R.id.ir3);
        AppMethodBeat.o(107512);
    }
}
