package com.tencent.mm.emoji.b.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0013\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "designer", "Lcom/tencent/mm/protocal/protobuf/PersonalDesigner;", "getDesigner", "()Lcom/tencent/mm/protocal/protobuf/PersonalDesigner;", "setDesigner", "(Lcom/tencent/mm/protocal/protobuf/PersonalDesigner;)V", "getGroupInfo", "()Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "hasNew", "", "getHasNew", "()Z", "setHasNew", "(Z)V", "contentEquals", FacebookRequestErrorClassification.KEY_OTHER, "", "equals", "plugin-emojisdk_release"})
public final class u extends ac {
    public final EmojiGroupInfo gVA;
    public PersonalDesigner gYM;
    public boolean gYN;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(EmojiGroupInfo emojiGroupInfo) {
        super(2);
        p.h(emojiGroupInfo, "groupInfo");
        AppMethodBeat.i(105562);
        this.gVA = emojiGroupInfo;
        AppMethodBeat.o(105562);
    }

    @Override // com.tencent.mm.emoji.b.b.ac
    public final boolean equals(Object obj) {
        AppMethodBeat.i(105561);
        if (!super.equals(obj) || !(obj instanceof u) || !p.j(((u) obj).gVA.hYf(), this.gVA.hYf())) {
            AppMethodBeat.o(105561);
            return false;
        }
        AppMethodBeat.o(105561);
        return true;
    }

    @Override // com.tencent.mm.emoji.b.b.ac
    public final boolean aZ(Object obj) {
        String str = null;
        AppMethodBeat.i(183956);
        if (super.aZ(obj) && (obj instanceof u)) {
            PersonalDesigner personalDesigner = ((u) obj).gYM;
            Integer valueOf = personalDesigner != null ? Integer.valueOf(personalDesigner.DesignerUin) : null;
            PersonalDesigner personalDesigner2 = this.gYM;
            if (p.j(valueOf, personalDesigner2 != null ? Integer.valueOf(personalDesigner2.DesignerUin) : null)) {
                PersonalDesigner personalDesigner3 = ((u) obj).gYM;
                String str2 = personalDesigner3 != null ? personalDesigner3.Name : null;
                PersonalDesigner personalDesigner4 = this.gYM;
                if (p.j(str2, personalDesigner4 != null ? personalDesigner4.Name : null)) {
                    PersonalDesigner personalDesigner5 = ((u) obj).gYM;
                    String str3 = personalDesigner5 != null ? personalDesigner5.HeadUrl : null;
                    PersonalDesigner personalDesigner6 = this.gYM;
                    if (personalDesigner6 != null) {
                        str = personalDesigner6.HeadUrl;
                    }
                    if (p.j(str3, str) && ((u) obj).gYN == this.gYN) {
                        AppMethodBeat.o(183956);
                        return true;
                    }
                }
            }
        }
        AppMethodBeat.o(183956);
        return false;
    }
}
