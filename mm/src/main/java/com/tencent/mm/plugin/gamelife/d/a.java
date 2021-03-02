package com.tencent.mm.plugin.gamelife.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cz;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.as;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0014J\n\u0010\f\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact;", "Lcom/tencent/mm/autogen/table/BaseGameLifeContact;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "()V", "isValid", "", "getAccountType", "", "getAvatarUrl", "", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getNickname", "getProfileJumpInfo", "getTag", "getUsername", SharePatchInfo.FINGER_PRINT, "setIsValid", "", "toString", "toWxContact", "Lcom/tencent/mm/storage/Contact;", "Companion", "plugin-gamelife_release"})
public final class a extends cz implements com.tencent.mm.plugin.gamelife.a.a {
    private static final IAutoDBItem.MAutoDBInfo info;
    private static final int ybB = 1;
    private static final int ybC = 2;
    private static final int ybD = 4;
    private static final int ybE = 8;
    public static final C1414a ybF = new C1414a((byte) 0);
    boolean daZ = true;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeContact$Companion;", "", "()V", "GAME_CONTACTFLAG_BLACKLISTCONTACT", "", "getGAME_CONTACTFLAG_BLACKLISTCONTACT", "()I", "GAME_CONTACTFLAG_CHATCONTACT", "getGAME_CONTACTFLAG_CHATCONTACT", "GAME_CONTACTFLAG_CHATROOMCONTACT", "getGAME_CONTACTFLAG_CHATROOMCONTACT", "GAME_CONTACTFLAG_CONTACT", "getGAME_CONTACTFLAG_CONTACT", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-gamelife_release"})
    /* renamed from: com.tencent.mm.plugin.gamelife.d.a$a  reason: collision with other inner class name */
    public static final class C1414a {
        private C1414a() {
        }

        public /* synthetic */ C1414a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(241297);
        IAutoDBItem.MAutoDBInfo ajs = cz.ajs();
        p.g(ajs, "BaseGameLifeContact.init…eLifeContact::class.java)");
        info = ajs;
        AppMethodBeat.o(241297);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    @Override // com.tencent.mm.plugin.gamelife.a.a
    public final as dWW() {
        AppMethodBeat.i(241292);
        as asVar = new as();
        if (!this.daZ) {
            this.field_nickname = this.field_username;
        }
        asVar.setNickname(this.field_nickname);
        asVar.ao(com.tencent.mm.pluginsdk.ui.span.l.c(MMApplicationContext.getContext(), this.field_nickname));
        asVar.setUsername(this.field_username);
        asVar.gMZ = asVar.systemRowid;
        AppMethodBeat.o(241292);
        return asVar;
    }

    public final String print() {
        AppMethodBeat.i(241293);
        String str = "username: " + this.field_username;
        AppMethodBeat.o(241293);
        return str;
    }

    @Override // com.tencent.mm.plugin.gamelife.a.a
    public final String getNickname() {
        return this.field_nickname;
    }

    @Override // com.tencent.mm.plugin.gamelife.a.a
    public final String getUsername() {
        AppMethodBeat.i(241294);
        String str = this.field_username;
        p.g(str, "field_username");
        AppMethodBeat.o(241294);
        return str;
    }

    @Override // com.tencent.mm.plugin.gamelife.a.a
    public final String cXH() {
        return this.field_avatarURL;
    }

    @Override // com.tencent.mm.plugin.gamelife.a.a
    public final String getTag() {
        return this.field_tag;
    }

    @Override // com.tencent.mm.plugin.gamelife.a.a
    public final int dWY() {
        return this.field_accountType;
    }

    @Override // com.tencent.mm.plugin.gamelife.a.a
    public final String dWX() {
        AppMethodBeat.i(241295);
        com.tencent.mm.plugin.gamelife.b.l lVar = this.field_jumpInfo;
        if (lVar == null) {
            AppMethodBeat.o(241295);
            return "";
        } else if (lVar == null || lVar.uSc != com.tencent.mm.plugin.gamelife.a.xZW) {
            AppMethodBeat.o(241295);
            return "";
        } else {
            String str = lVar.pTL;
            p.g(str, "jumpInfo.jump_url");
            AppMethodBeat.o(241295);
            return str;
        }
    }

    @Override // com.tencent.mm.plugin.gamelife.a.a
    public final boolean isValid() {
        return this.daZ;
    }

    public final String toString() {
        AppMethodBeat.i(241296);
        String str = "username: " + this.field_username + " nickname: " + this.field_nickname;
        AppMethodBeat.o(241296);
        return str;
    }
}
