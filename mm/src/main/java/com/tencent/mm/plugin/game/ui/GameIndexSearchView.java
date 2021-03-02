package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GameIndexSearchView extends LinearLayout {
    private Context mContext;
    LayoutInflater mInflater = ((LayoutInflater) this.mContext.getSystemService("layout_inflater"));

    public GameIndexSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(42171);
        setOrientation(0);
        this.mContext = context;
        AppMethodBeat.o(42171);
    }
}
