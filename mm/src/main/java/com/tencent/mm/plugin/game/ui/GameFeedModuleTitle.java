package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedModuleTitle extends LinearLayout {
    private TextView mPa;

    public GameFeedModuleTitle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42113);
        super.onFinishInflate();
        this.mPa = (TextView) findViewById(R.id.dfh);
        AppMethodBeat.o(42113);
    }

    public void setData(d dVar) {
        AppMethodBeat.i(42114);
        if (dVar == null || Util.isNullOrNil(dVar.xEp)) {
            setVisibility(8);
            AppMethodBeat.o(42114);
            return;
        }
        setVisibility(0);
        this.mPa.setText(dVar.xEp);
        AppMethodBeat.o(42114);
    }
}
