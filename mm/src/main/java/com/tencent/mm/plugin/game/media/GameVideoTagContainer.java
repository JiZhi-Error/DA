package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a;
import com.tencent.mm.plugin.game.b.b.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import java.util.LinkedList;

public class GameVideoTagContainer extends LinearLayout {
    public GameVideoTagContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GameVideoTagContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(41167);
        super.onMeasure(i2, i3);
        AppMethodBeat.o(41167);
    }

    public void setData(LinkedList<l> linkedList) {
        AppMethodBeat.i(41168);
        if (Util.isNullOrNil(linkedList)) {
            setVisibility(8);
            AppMethodBeat.o(41168);
            return;
        }
        setVisibility(0);
        while (getChildCount() < linkedList.size()) {
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.height = at.fromDPToPix(getContext(), 14);
            layoutParams.rightMargin = at.fromDPToPix(getContext(), 4);
            imageView.setLayoutParams(layoutParams);
            addView(imageView);
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            getChildAt(i2).setVisibility(8);
        }
        for (int i3 = 0; i3 < linkedList.size(); i3++) {
            l lVar = linkedList.get(i3);
            ImageView imageView2 = (ImageView) getChildAt(i3);
            ((LinearLayout.LayoutParams) imageView2.getLayoutParams()).width = at.fromDPToPix(getContext(), lVar.width);
            a.bdb().loadImage(lVar.xve, imageView2);
            imageView2.setVisibility(0);
        }
        AppMethodBeat.o(41168);
    }
}
