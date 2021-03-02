package com.tencent.kinda.framework.widget.base;

import android.view.View;
import com.tencent.mm.wallet_core.ui.a;

public interface IExtendUI {
    void hideTenpayKB();

    void scrollTo(View view, int i2, int i3);

    void scrollToFormEditPosAfterShowTenPay(View view, View view2, int i2);

    void setEditFocusListener(View view, int i2, boolean z);

    void setEditFocusListener(View view, int i2, boolean z, boolean z2);

    void setTenpayKBStateListener(a aVar);

    void showTenpayKB();

    void showVKB();
}
