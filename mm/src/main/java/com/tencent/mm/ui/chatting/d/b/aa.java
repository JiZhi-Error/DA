package com.tencent.mm.ui.chatting.d.b;

import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.ui.chatting.d.af;
import com.tencent.mm.ui.w;

public interface aa extends af {
    void BR(boolean z);

    void a(boolean z, View.OnClickListener onClickListener);

    void amB(int i2);

    void gC(View view);

    w gNg();

    void gPx();

    void gQk();

    void gQn();

    void gQp();

    void gQr();

    void gQs();

    int gQy();

    int gQz();

    void setBackBtn(MenuItem.OnMenuItemClickListener onMenuItemClickListener);

    void setMMSubTitle(String str);

    void setMMTitle(int i2);

    void setMMTitle(CharSequence charSequence);

    void setTitleMuteIconVisibility(int i2);

    void setTitlePhoneIconVisibility(int i2);
}
