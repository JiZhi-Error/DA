package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import java.util.Iterator;
import java.util.LinkedList;

public class FavourLayout extends LinearLayout {
    public FavourLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FavourLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setWording(LinkedList<String> linkedList) {
        AppMethodBeat.i(71482);
        removeAllViews();
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            TextView textView = new TextView(getContext());
            textView.setText(it.next());
            textView.setTextColor(Color.parseColor("#ff891e"));
            textView.setTextSize(0, (float) a.aG(getContext(), R.dimen.k6));
            addView(textView);
        }
        AppMethodBeat.o(71482);
    }
}
