package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.f;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class GameMessageListContainerView extends LinearLayout {
    private Context mContext;

    public GameMessageListContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(42283);
        super.onFinishInflate();
        AppMethodBeat.o(42283);
    }

    public final void a(o oVar, LinkedList<o.k> linkedList, int i2, int i3, f<String, Bitmap> fVar) {
        AppMethodBeat.i(42284);
        if (oVar == null || Util.isNullOrNil(linkedList)) {
            setVisibility(8);
            AppMethodBeat.o(42284);
            return;
        }
        setVisibility(0);
        int i4 = i2 > linkedList.size() ? 1 : 2;
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.f3062g);
        while (getChildCount() < i4) {
            GameMessageListUserIconView gameMessageListUserIconView = new GameMessageListUserIconView(this.mContext);
            if (getChildCount() > 0) {
                gameMessageListUserIconView.setPadding(0, dimensionPixelSize, 0, 0);
            }
            gameMessageListUserIconView.setSourceScene(i3);
            addView(gameMessageListUserIconView);
        }
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            if (i5 < i4) {
                getChildAt(i5).setVisibility(0);
                GameMessageListUserIconView gameMessageListUserIconView2 = (GameMessageListUserIconView) getChildAt(i5);
                LinkedList<o.k> linkedList2 = new LinkedList<>();
                int i6 = i5 * i2;
                while (i6 < (i5 + 1) * i2 && i6 < linkedList.size()) {
                    linkedList2.add(linkedList.get(i6));
                    i6++;
                }
                gameMessageListUserIconView2.a(oVar, linkedList2, fVar);
            } else {
                getChildAt(i5).setVisibility(8);
            }
        }
        AppMethodBeat.o(42284);
    }
}
