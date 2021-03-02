package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.f;
import com.tencent.mm.ag.k;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.bci;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020\u0001H\u0016J>\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010\u000b2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0004H\u0016J&\u0010.\u001a\u00020$2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b002\b\u0010'\u001a\u0004\u0018\u00010(H\u0016R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000f¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderNameCard;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "value", "", "authIcon", "getAuthIcon", "()I", "setAuthIcon", "(I)V", "authIconUrl", "", "getAuthIconUrl", "()Ljava/lang/String;", "setAuthIconUrl", "(Ljava/lang/String;)V", "authJob", "getAuthJob", "setAuthJob", "avatar", "getAvatar", "setAvatar", "nickname", "getNickname", "setNickname", "shareNameCard", "Lcom/tencent/mm/protocal/protobuf/FinderShareNameCard;", "getShareNameCard", "()Lcom/tencent/mm/protocal/protobuf/FinderShareNameCard;", "setShareNameCard", "(Lcom/tencent/mm/protocal/protobuf/FinderShareNameCard;)V", ch.COL_USERNAME, "getUsername", "setUsername", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "thumbHeight", "parseContent", "values", "", "finder-sdk_release"})
public final class e extends f {
    public String authIconUrl = "";
    public String nickname = "";
    public String uNR = "";
    public String username = "";
    public bci wDW = new bci();
    public String wDX = "";
    public int wDY;

    public e() {
        AppMethodBeat.i(208777);
        AppMethodBeat.o(208777);
    }

    public final void setUsername(String str) {
        AppMethodBeat.i(208772);
        p.h(str, "value");
        this.wDW.username = str;
        this.username = str;
        AppMethodBeat.o(208772);
    }

    public final void setAvatar(String str) {
        AppMethodBeat.i(208773);
        p.h(str, "value");
        this.wDW.uNR = str;
        this.uNR = str;
        AppMethodBeat.o(208773);
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final void setNickname(String str) {
        AppMethodBeat.i(208774);
        p.h(str, "value");
        this.wDW.nickname = str;
        this.nickname = str;
        AppMethodBeat.o(208774);
    }

    public final void axa(String str) {
        AppMethodBeat.i(208775);
        p.h(str, "value");
        this.wDW.wDX = str;
        this.wDX = str;
        AppMethodBeat.o(208775);
    }

    public final void ML(int i2) {
        this.wDW.wDY = i2;
        this.wDY = i2;
    }

    public final void axb(String str) {
        AppMethodBeat.i(208776);
        p.h(str, "<set-?>");
        this.authIconUrl = str;
        AppMethodBeat.o(208776);
    }

    @Override // com.tencent.mm.ag.f
    public final f aHj() {
        AppMethodBeat.i(168864);
        e eVar = new e();
        eVar.setUsername(this.username);
        eVar.setAvatar(this.uNR);
        eVar.setNickname(this.nickname);
        eVar.axa(this.wDX);
        eVar.ML(this.wDY);
        eVar.authIconUrl = this.authIconUrl;
        eVar.wDW = this.wDW;
        e eVar2 = eVar;
        AppMethodBeat.o(168864);
        return eVar2;
    }

    @Override // com.tencent.mm.ag.f
    public final void a(StringBuilder sb, k.b bVar, String str, d dVar, int i2, int i3) {
        AppMethodBeat.i(168865);
        p.h(sb, "sb");
        sb.append("<findernamecard><username>").append(Util.escapeStringForXml(this.username)).append("</username><avatar>").append(k.b.HE(this.uNR)).append("</avatar><nickname>").append(Util.escapeStringForXml(this.nickname)).append("</nickname><auth_job>").append(Util.escapeStringForXml(this.wDX)).append("</auth_job><auth_icon>").append(this.wDY).append("</auth_icon><auth_icon_url>").append(Util.escapeStringForXml(this.authIconUrl)).append("</auth_icon_url></findernamecard>");
        AppMethodBeat.o(168865);
    }

    @Override // com.tencent.mm.ag.f
    public final void a(Map<String, String> map, k.b bVar) {
        AppMethodBeat.i(168866);
        p.h(map, "values");
        String nullAsNil = Util.nullAsNil(map.get(".msg.appmsg.findernamecard.username"));
        p.g(nullAsNil, "Util.nullAsNil(values.ge…indernamecard.username\"))");
        setUsername(nullAsNil);
        String nullAsNil2 = Util.nullAsNil(map.get(".msg.appmsg.findernamecard.avatar"));
        p.g(nullAsNil2, "Util.nullAsNil(values.ge….findernamecard.avatar\"))");
        setAvatar(nullAsNil2);
        String nullAsNil3 = Util.nullAsNil(map.get(".msg.appmsg.findernamecard.nickname"));
        p.g(nullAsNil3, "Util.nullAsNil(values.ge…indernamecard.nickname\"))");
        setNickname(nullAsNil3);
        String nullAsNil4 = Util.nullAsNil(map.get(".msg.appmsg.findernamecard.auth_job"));
        p.g(nullAsNil4, "Util.nullAsNil(values.ge…indernamecard.auth_job\"))");
        axa(nullAsNil4);
        ML(Util.safeParseInt(map.get(".msg.appmsg.findernamecard.auth_icon")));
        String nullAsNil5 = Util.nullAsNil(map.get(".msg.appmsg.findernamecard.auth_icon_url"));
        p.g(nullAsNil5, "Util.nullAsNil(values.ge…namecard.auth_icon_url\"))");
        this.authIconUrl = nullAsNil5;
        this.wDW.username = this.username;
        this.wDW.uNR = this.uNR;
        this.wDW.nickname = this.nickname;
        this.wDW.wDX = this.wDX;
        this.wDW.wDY = this.wDY;
        AppMethodBeat.o(168866);
    }
}
