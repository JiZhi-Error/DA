package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.LinkedList;
import java.util.List;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015H\u0016J\u0012\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0015H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH\u0016R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/emoji/model/panel/EmojiPanelGroupData;", "Lcom/tencent/mm/emoji/model/panel/IEmojiPanelData;", "()V", "groupList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "getGroupList$plugin_emojisdk_release", "()Ljava/util/LinkedList;", "groupModels", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "getGroupModels$plugin_emojisdk_release", "groupToTabOffset", "", "getGroupToTabOffset$plugin_emojisdk_release", "()I", "setGroupToTabOffset$plugin_emojisdk_release", "(I)V", "tabList", "Lcom/tencent/mm/emoji/model/panel/PanelTab;", "getTabList$plugin_emojisdk_release", "getGroupList", "", "getGroupModels", "getGroupTabList", "groupToTab", "groupIndex", "plugin-emojisdk_release"})
public final class l implements v {
    final LinkedList<ab<?>> gYD = new LinkedList<>();
    final LinkedList<EmojiGroupInfo> gYE = new LinkedList<>();
    final LinkedList<ag> gYF = new LinkedList<>();
    int gYG;

    public l() {
        AppMethodBeat.i(105557);
        AppMethodBeat.o(105557);
    }

    @Override // com.tencent.mm.emoji.b.b.v
    public final List<EmojiGroupInfo> avv() {
        return this.gYE;
    }

    @Override // com.tencent.mm.emoji.b.b.v
    public final List<ab<?>> avw() {
        return this.gYD;
    }

    @Override // com.tencent.mm.emoji.b.b.v
    public final List<ag> avx() {
        return this.gYF;
    }

    @Override // com.tencent.mm.emoji.b.b.v
    public final int pi(int i2) {
        return this.gYG + i2;
    }
}
