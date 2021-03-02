package com.tencent.mm.ui.chatting.d.b;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.MenuItem;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.af;

public interface an extends af {
    void Q(String str, int i2, String str2);

    void T(int i2, int i3, String str);

    void a(ContextMenu contextMenu, int i2, ca caVar);

    void a(SightCaptureResult sightCaptureResult);

    boolean a(MenuItem menuItem, ca caVar);

    boolean bU(ca caVar);

    boolean i(int i2, int i3, Intent intent);
}
