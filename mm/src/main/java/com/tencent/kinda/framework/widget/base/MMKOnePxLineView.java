package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.kinda.gen.KOnePxLineView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class MMKOnePxLineView extends MMKView<LinearLayout> implements KOnePxLineView {
    private static final String TAG = "MMKOnePxLineView";
    private View mOnePxView;
    private float mOnePxViewHeight;
    private float mOnePxViewWidth;

    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public LinearLayout createView(Context context) {
        AppMethodBeat.i(19089);
        LinearLayout linearLayout = new LinearLayout(context);
        this.mOnePxView = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
        this.mOnePxViewWidth = -1.0f;
        this.mOnePxViewHeight = 1.0f;
        linearLayout.addView(this.mOnePxView, layoutParams);
        AppMethodBeat.o(19089);
        return linearLayout;
    }

    @Override // com.tencent.kinda.gen.KView, com.tencent.kinda.framework.widget.base.MMKView
    public void setHeight(float f2) {
        AppMethodBeat.i(19090);
        super.setHeight(f2);
        this.mOnePxViewHeight = f2;
        updateOrientation();
        AppMethodBeat.o(19090);
    }

    @Override // com.tencent.kinda.gen.KView, com.tencent.kinda.framework.widget.base.MMKView
    public void setWidth(float f2) {
        AppMethodBeat.i(19091);
        super.setWidth(f2);
        this.mOnePxViewWidth = f2;
        updateOrientation();
        AppMethodBeat.o(19091);
    }

    private void updateOrientation() {
        LinearLayout.LayoutParams layoutParams;
        AppMethodBeat.i(19092);
        Log.d(TAG, "updateOrientation，更新分隔线方向前，本控件宽度：" + this.mOnePxViewWidth + "，高度：" + this.mOnePxViewHeight);
        if (this.mOnePxViewWidth >= this.mOnePxViewHeight) {
            Log.d(TAG, "updateOrientation，分隔线为横向");
            layoutParams = new LinearLayout.LayoutParams(-1, 1);
        } else {
            Log.d(TAG, "updateOrientation，分隔线为纵向");
            layoutParams = new LinearLayout.LayoutParams(1, -1);
        }
        this.mOnePxView.setLayoutParams(layoutParams);
        AppMethodBeat.o(19092);
    }
}
