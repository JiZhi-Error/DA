package com.tencent.mm.ui.chatting.d.b;

import android.view.MenuItem;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.af;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate;

public interface au extends af {
    boolean b(MenuItem menuItem, ca caVar);

    ChattingItemTranslate.c cj(ca caVar);

    String g(ca caVar, boolean z);

    void gRw();
}
