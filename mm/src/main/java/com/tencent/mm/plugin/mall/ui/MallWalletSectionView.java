package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class MallWalletSectionView extends LinearLayout {
    public MallWalletSectionView(Context context) {
        super(context);
        AppMethodBeat.i(66158);
        init(context);
        AppMethodBeat.o(66158);
    }

    public MallWalletSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(66159);
        init(context);
        AppMethodBeat.o(66159);
    }

    public MallWalletSectionView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(66160);
        init(context);
        AppMethodBeat.o(66160);
    }

    private void init(Context context) {
        AppMethodBeat.i(66161);
        inflate(context, R.layout.b6c, this);
        setOrientation(1);
        AppMethodBeat.o(66161);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.protocal.protobuf.cdv r11, boolean r12) {
        /*
        // Method dump skipped, instructions count: 376
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mall.ui.MallWalletSectionView.a(com.tencent.mm.protocal.protobuf.cdv, boolean):void");
    }
}
