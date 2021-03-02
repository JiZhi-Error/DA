package com.tencent.mm.plugin.vlog.model.panel;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.b.b.o;
import com.tencent.mm.emoji.e.e;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelGroupViewProvider;", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelGroupViewProvider;", "()V", "getGroupId", "", "setTabIcon", "", "icon", "Landroid/widget/ImageView;", "color", "", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "plugin-vlog_release"})
public final class d implements o {
    @Override // com.tencent.mm.emoji.b.b.o
    public final String avy() {
        AppMethodBeat.i(190790);
        String fCd = b.fCd();
        AppMethodBeat.o(190790);
        return fCd;
    }

    @Override // com.tencent.mm.emoji.b.b.o
    public final void a(ImageView imageView, int i2, EmojiGroupInfo emojiGroupInfo) {
        AppMethodBeat.i(190791);
        p.h(imageView, "icon");
        p.h(emojiGroupInfo, "groupInfo");
        e.a(imageView, R.raw.icons_filled_magic, i2);
        AppMethodBeat.o(190791);
    }
}
