package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.span.l;
import java.util.LinkedList;

public class GameListSocialView extends LinearLayout {
    public GameListSocialView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42252);
        super.onFinishInflate();
        AppMethodBeat.o(42252);
    }

    public void setData(LinkedList<String> linkedList) {
        AppMethodBeat.i(42253);
        if (linkedList == null || linkedList.size() == 0 || linkedList.size() % 2 != 0) {
            setVisibility(8);
            AppMethodBeat.o(42253);
            return;
        }
        setVisibility(0);
        if (getChildCount() < linkedList.size() / 2) {
            int size = (linkedList.size() / 2) - getChildCount();
            for (int i2 = 0; i2 < size; i2++) {
                inflate(getContext(), R.layout.ard, this);
            }
        }
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (i3 < linkedList.size() / 2) {
                getChildAt(i3).setVisibility(0);
            } else {
                getChildAt(i3).setVisibility(8);
            }
        }
        for (int i4 = 0; i4 < linkedList.size() / 2; i4++) {
            View childAt = getChildAt(i4);
            TextView textView = (TextView) childAt.findViewById(R.id.diq);
            TextView textView2 = (TextView) childAt.findViewById(R.id.dir);
            textView.setText(l.b(getContext(), linkedList.get(i4 * 2), textView.getTextSize()));
            textView2.setText(l.b(getContext(), linkedList.get((i4 * 2) + 1), textView2.getTextSize()));
        }
        AppMethodBeat.o(42253);
    }
}
