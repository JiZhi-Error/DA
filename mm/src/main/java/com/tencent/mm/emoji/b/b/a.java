package com.tencent.mm.emoji.b.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/emoji/model/panel/AbsPanelItemGroup;", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "contentList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "getContentList", "()Ljava/util/LinkedList;", "groupItem", "Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "getGroupItem", "()Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "getGroupInfo", "getItemList", "", "plugin-emojisdk_release"})
public abstract class a implements w {
    final u gXV;
    protected final LinkedList<ac> gXW = new LinkedList<>();

    public a(EmojiGroupInfo emojiGroupInfo) {
        p.h(emojiGroupInfo, "groupInfo");
        this.gXV = new u(emojiGroupInfo);
    }

    @Override // com.tencent.mm.emoji.b.b.w
    public final EmojiGroupInfo avm() {
        return this.gXV.gVA;
    }

    @Override // com.tencent.mm.emoji.b.b.w
    public final List<ac> avn() {
        return this.gXW;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && p.j(((a) obj).gXV.gVA.hYf(), this.gXV.gVA.hYf());
    }
}
