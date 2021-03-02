package com.tencent.mm.plugin.webview.emojistore.ui;

import android.view.ContextMenu;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.b.b.h;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/webview/emojistore/ui/MenuItemCreateListener;", "Landroid/view/View$OnCreateContextMenuListener;", "item", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "(Lcom/tencent/mm/emoji/model/panel/EmojiItem;)V", "getItem", "()Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "plugin-webview_release"})
public final class a implements View.OnCreateContextMenuListener {
    private final h INy;

    public a(h hVar) {
        this.INy = hVar;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(210286);
        if (contextMenu != null) {
            contextMenu.add(0, 0, 0, R.string.d2);
        }
        AppMethodBeat.o(210286);
    }
}
