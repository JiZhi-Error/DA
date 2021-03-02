package com.tencent.mm.plugin.forcenotify.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyMsgItem;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItem;", "forcePushId", "", ch.COL_USERNAME, "nickname", "wording", "avatarUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "getNickname", "getUsername", "getWording", "getItemId", "", "getItemType", "", "plugin-force-notify_release"})
public final class h extends e {
    public final String dQx;
    public final String kog;
    public final String nickname;
    public final String username;

    public /* synthetic */ h(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(String str, String str2, String str3, String str4, String str5) {
        super(str);
        p.h(str, "forcePushId");
        p.h(str2, ch.COL_USERNAME);
        p.h(str3, "nickname");
        p.h(str4, "wording");
        AppMethodBeat.i(261759);
        this.username = str2;
        this.nickname = str3;
        this.dQx = str4;
        this.kog = str5;
        AppMethodBeat.o(261759);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        return 0;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return 0;
    }
}
