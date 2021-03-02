package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class GameSmallAvatarList extends LinearLayout {
    public GameSmallAvatarList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setData(LinkedList<String> linkedList) {
        AppMethodBeat.i(42620);
        if (Util.isNullOrNil(linkedList)) {
            setVisibility(8);
            AppMethodBeat.o(42620);
            return;
        }
        setVisibility(0);
        while (getChildCount() < linkedList.size()) {
            ImageView imageView = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.gr), getResources().getDimensionPixelSize(R.dimen.gr));
            layoutParams.setMargins(0, 0, getResources().getDimensionPixelSize(R.dimen.gk), 0);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            addView(imageView);
        }
        int i2 = 0;
        while (i2 < linkedList.size()) {
            e.a.C1397a aVar = new e.a.C1397a();
            aVar.iaT = true;
            e.dWR().a((ImageView) getChildAt(i2), linkedList.get(i2), aVar.dWS());
            getChildAt(i2).setVisibility(0);
            i2++;
        }
        while (i2 < getChildCount()) {
            getChildAt(i2).setVisibility(8);
            i2++;
        }
        AppMethodBeat.o(42620);
    }
}
