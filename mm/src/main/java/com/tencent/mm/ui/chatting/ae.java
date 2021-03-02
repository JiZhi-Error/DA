package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.ui.chatting.h.d;

public interface ae {
    void BN(boolean z);

    void a(d.a aVar);

    void addHeaderView(View view);

    void amm(int i2);

    void amo(int i2);

    void b(Context context, String str, String str2, DialogInterface.OnCancelListener onCancelListener);

    int cda();

    void cmy();

    void dismissDialog();

    void gNX();

    void gNY();

    void gOc();

    void gOe();

    View getChildAt(int i2);

    int getFirstVisiblePosition();

    int getHeaderViewsCount();

    int getLastVisiblePosition();

    ListView getListView();

    boolean hideVKB();

    void lf(int i2, int i3);

    boolean removeOptionMenu(int i2);

    void scrollToPosition(int i2);

    void setKeepScreenOn(boolean z);

    void showOptionMenu(int i2, boolean z);

    void showOptionMenu(boolean z);

    void updateOptionMenuIcon(int i2, int i3);
}
