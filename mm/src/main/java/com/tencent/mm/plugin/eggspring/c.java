package com.tencent.mm.plugin.eggspring;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J&\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\fJ\u001e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\fJ\u0010\u0010!\u001a\u00020\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/SpringEggRpt;", "", "()V", "appId", "", "chatRoomId", "chattingType", "", "Ljava/lang/Integer;", "keyWord", "senderType", "timeStamp", "", "Ljava/lang/Long;", "userName", "eggRpt", "", NativeProtocol.WEB_DIALOG_ACTION, "keyWords", "initEggRptMsg", "isSend", "", "isGroup", "name", "luckyBagRptAcceptedMoney", "amount", "luckyBagRptAction", "luckyBagRptLoadingTimeMs", "timeMs", "luckyBagRptVideoInfo", "videoDuration", "playCount", "playDuration", "setAppId", "Companion", "SingletonHolder", "plugin-eggspring_release"})
public final class c {
    private static final c qUN = b.cEI();
    public static final a qUO = new a((byte) 0);
    public String appId;
    public String jgR;
    public Integer qUJ;
    public String qUK;
    public Long qUL;
    public Integer qUM;
    public String userName;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/SpringEggRpt$Companion;", "", "()V", "RECEIVER", "", "SENDER", "TYPE_GROUP", "TYPE_SINGLE", "instance", "Lcom/tencent/mm/plugin/eggspring/SpringEggRpt;", "getInstance", "()Lcom/tencent/mm/plugin/eggspring/SpringEggRpt;", "plugin-eggspring_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private c() {
    }

    public /* synthetic */ c(byte b2) {
        this();
    }

    static {
        AppMethodBeat.i(162208);
        b bVar = b.qUQ;
        AppMethodBeat.o(162208);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/SpringEggRpt$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mm/plugin/eggspring/SpringEggRpt;", "getHolder", "()Lcom/tencent/mm/plugin/eggspring/SpringEggRpt;", "plugin-eggspring_release"})
    static final class b {
        private static final c qUP = new c((byte) 0);
        public static final b qUQ = new b();

        static {
            AppMethodBeat.i(162203);
            AppMethodBeat.o(162203);
        }

        private b() {
        }

        public static c cEI() {
            return qUP;
        }
    }

    public final void FE(int i2) {
        AppMethodBeat.i(162205);
        aP(i2, this.jgR);
        AppMethodBeat.o(162205);
    }

    public final void aP(int i2, String str) {
        AppMethodBeat.i(162206);
        h.INSTANCE.a(18914, str, this.qUJ, this.userName, this.qUK, this.qUL, this.qUM, Integer.valueOf(i2));
        AppMethodBeat.o(162206);
    }

    public final void FF(int i2) {
        AppMethodBeat.i(162207);
        h.INSTANCE.a(18916, this.qUL, "", Integer.valueOf(i2), "", "", "", "", "", this.appId);
        AppMethodBeat.o(162207);
    }
}
