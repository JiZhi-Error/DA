package com.tencent.mm.msgsubscription.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR \u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\f\"\u0004\b-\u0010\u000eR\u001c\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0006\"\u0004\b6\u0010\b¨\u00067"}, hxF = {"Lcom/tencent/mm/msgsubscription/api/SubscribeMsgUpdateRequest;", "", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "async", "", "getAsync", "()Z", "setAsync", "(Z)V", "buffer", "", "getBuffer", "()[B", "setBuffer", "([B)V", "callback", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "getCallback", "()Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "setCallback", "(Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;)V", IssueStorage.COLUMN_EXT_INFO, "getExtInfo", "setExtInfo", "forRequestDialog", "getForRequestDialog", "setForRequestDialog", "replaced", "getReplaced", "setReplaced", "subscribeMsgList", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "getSubscribeMsgList", "()Ljava/util/List;", "setSubscribeMsgList", "(Ljava/util/List;)V", "switchOpened", "getSwitchOpened", "setSwitchOpened", "uiData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "getUiData", "()Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "setUiData", "(Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;)V", ch.COL_USERNAME, "getUsername", "setUsername", "plugin-comm_release"})
public final class c {
    public String appId = "";
    public byte[] buffer = {0};
    public String extInfo = "";
    public List<SubscribeMsgTmpItem> jyV = new ArrayList();
    public boolean jzb;
    public SubscribeMsgRequestDialogUiData jzc;
    public boolean jzd;
    public a jze;
    public boolean jzf;
    public boolean jzg;
    public String username = "";

    public c() {
        AppMethodBeat.i(223236);
        AppMethodBeat.o(223236);
    }

    public final void setUsername(String str) {
        AppMethodBeat.i(223232);
        p.h(str, "<set-?>");
        this.username = str;
        AppMethodBeat.o(223232);
    }

    public final void setAppId(String str) {
        AppMethodBeat.i(223233);
        p.h(str, "<set-?>");
        this.appId = str;
        AppMethodBeat.o(223233);
    }

    public final void setBuffer(byte[] bArr) {
        AppMethodBeat.i(223234);
        p.h(bArr, "<set-?>");
        this.buffer = bArr;
        AppMethodBeat.o(223234);
    }

    public final void Rv(String str) {
        AppMethodBeat.i(223235);
        p.h(str, "<set-?>");
        this.extInfo = str;
        AppMethodBeat.o(223235);
    }
}
