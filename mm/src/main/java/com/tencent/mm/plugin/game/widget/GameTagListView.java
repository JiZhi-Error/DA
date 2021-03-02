package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class GameTagListView extends LinearLayout {
    private int textColor;
    private int textSize;

    public GameTagListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42622);
        super.onFinishInflate();
        this.textColor = getResources().getColor(R.color.sx);
        this.textSize = getResources().getDimensionPixelSize(R.dimen.go);
        AppMethodBeat.o(42622);
    }

    public final void h(LinkedList<String> linkedList, int i2) {
        AppMethodBeat.i(42623);
        if (Util.isNullOrNil(linkedList)) {
            setVisibility(8);
            AppMethodBeat.o(42623);
            return;
        }
        setVisibility(0);
        while (getChildCount() < linkedList.size()) {
            TextView textView = new TextView(getContext());
            textView.setBackgroundResource(R.drawable.a6g);
            textView.setMaxLines(1);
            textView.setTextColor(this.textColor);
            textView.setTextSize(0, (float) this.textSize);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, getResources().getDimensionPixelSize(R.dimen.gk), 0);
            textView.setLayoutParams(layoutParams);
            addView(textView);
        }
        int i3 = 0;
        float f2 = 0.0f;
        while (true) {
            if (i3 >= linkedList.size()) {
                break;
            }
            String str = linkedList.get(i3);
            Log.d("MicroMsg.GameTagListView", str);
            TextView textView2 = (TextView) getChildAt(i3);
            textView2.setVisibility(0);
            textView2.setText(str);
            f2 = ((float) getResources().getDimensionPixelSize(R.dimen.gk)) + textView2.getPaint().measureText(str) + ((float) textView2.getPaddingLeft()) + ((float) textView2.getPaddingRight()) + f2;
            if (f2 > ((float) i2)) {
                textView2.setVisibility(8);
                break;
            }
            i3++;
        }
        while (i3 < getChildCount()) {
            getChildAt(i3).setVisibility(8);
            i3++;
        }
        AppMethodBeat.o(42623);
    }
}
