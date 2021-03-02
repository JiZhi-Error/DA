package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Util;

public class GameBestSellingTitle extends LinearLayout {
    public GameBestSellingTitle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setText(String str) {
        AppMethodBeat.i(41898);
        if (Util.isNullOrNil(str)) {
            setVisibility(8);
            AppMethodBeat.o(41898);
            return;
        }
        setVisibility(0);
        ((TextView) findViewById(R.id.dd3)).setText(str);
        AppMethodBeat.o(41898);
    }
}
