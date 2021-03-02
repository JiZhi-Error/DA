package com.tencent.mm.plugin.sns.ui.d;

import android.view.ContextMenu;
import android.view.View;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class d implements View.OnCreateContextMenuListener {
    public abstract void a(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo);

    public abstract boolean fD(View view);

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        if (fD(view)) {
            a(contextMenu, view, contextMenuInfo);
        } else {
            Log.e("MicroMsg.TimelineOnCreateContextMenuListener", "onMMCreateContextMenu error");
        }
    }
}
