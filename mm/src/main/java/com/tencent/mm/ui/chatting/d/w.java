package com.tencent.mm.ui.chatting.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.b.t;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u0000 \u001f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\u0012\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u001c\u001a\u00020\u000fH\u0016J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/ui/chatting/component/FloatBallComponent;", "Lcom/tencent/mm/ui/chatting/component/AbstractChattingComponent;", "Lcom/tencent/mm/ui/chatting/component/api/IFloatBallComponent;", "Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter$OnFooterPanelSwitchListener;", "()V", "chatFooter", "Lcom/tencent/mm/pluginsdk/ui/chat/ChatFooter;", "chattingContext", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "floatBallService", "Lcom/tencent/mm/plugin/ball/api/IFloatBallService;", "lastPanelHeight", "", "lastPanelType", "attachFooter", "", "detachFooter", "getDelayDuration", "", "panelType", "getExtraHeight", "needDelay", "", "needShowFloatBall", "onChattingPause", "onChattingResume", "onComponentInstall", "context", "onComponentUnInstall", "onFooterPanelSwitch", "panelHeight", "Companion", "app_release"})
@com.tencent.mm.ui.chatting.d.a.a(gRF = t.class)
public final class w extends a implements ChatFooter.f, t {
    public static final a PpB = new a((byte) 0);
    private com.tencent.mm.ui.chatting.e.a OFl;
    private int PpA = -1;
    private ChatFooter Ppy;
    private int Ppz = -1;
    private com.tencent.mm.plugin.ball.c.b oWG;

    static {
        AppMethodBeat.i(180128);
        AppMethodBeat.o(180128);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/ui/chatting/component/FloatBallComponent$Companion;", "", "()V", "TAG", "", "app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void a(com.tencent.mm.ui.chatting.e.a aVar) {
        AppMethodBeat.i(180122);
        super.a(aVar);
        this.OFl = aVar;
        this.oWG = (com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class);
        AppMethodBeat.o(180122);
    }

    @Override // com.tencent.mm.ui.chatting.d.ag, com.tencent.mm.ui.chatting.d.a
    public final void gOK() {
        AppMethodBeat.i(180123);
        super.gOK();
        ChatFooter chatFooter = this.Ppy;
        if (chatFooter != null) {
            chatFooter.setOnFooterPanelSwitchListener(null);
        }
        this.Ppy = null;
        AppMethodBeat.o(180123);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFx() {
        boolean z;
        MMFragment gRJ;
        Bundle arguments;
        MMFragment gRJ2;
        Bundle arguments2;
        MMFragment gRJ3;
        Bundle arguments3;
        AppMethodBeat.i(180124);
        super.cFx();
        com.tencent.mm.plugin.ball.c.b bVar = this.oWG;
        if (bVar != null) {
            bVar.jR(true);
        }
        com.tencent.mm.plugin.ball.c.b bVar2 = this.oWG;
        if (bVar2 != null) {
            bVar2.chX();
        }
        com.tencent.mm.ui.chatting.e.a aVar = this.OFl;
        int i2 = (aVar == null || (gRJ3 = aVar.gRJ()) == null || (arguments3 = gRJ3.getArguments()) == null) ? 0 : arguments3.getInt("chat_from_scene", 0);
        com.tencent.mm.ui.chatting.e.a aVar2 = this.OFl;
        if (aVar2 == null || (gRJ2 = aVar2.gRJ()) == null || (arguments2 = gRJ2.getArguments()) == null) {
            z = false;
        } else {
            z = arguments2.getBoolean("key_can_show_message_float_ball", false);
        }
        com.tencent.mm.plugin.ball.c.b bVar3 = this.oWG;
        if (bVar3 != null && bVar3.chO()) {
            Log.w("MicroMsg.FloatBallComponent", "alvinluo onChattingResume current is in QBFileViewPage");
        }
        if (i2 == 1 && z) {
            com.tencent.mm.plugin.ball.c.b bVar4 = this.oWG;
            if (bVar4 == null) {
                AppMethodBeat.o(180124);
                return;
            } else if (!bVar4.chO()) {
                com.tencent.mm.plugin.ball.c.b bVar5 = this.oWG;
                if (bVar5 != null) {
                    bVar5.jP(true);
                }
                com.tencent.mm.plugin.ball.c.b bVar6 = this.oWG;
                if (bVar6 != null) {
                    bVar6.By(System.currentTimeMillis());
                }
                com.tencent.mm.ui.chatting.e.a aVar3 = this.OFl;
                if (!(aVar3 == null || (gRJ = aVar3.gRJ()) == null || (arguments = gRJ.getArguments()) == null)) {
                    arguments.putBoolean("key_can_show_message_float_ball", false);
                }
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.mm.plugin.ball.c.b bVar7 = this.oWG;
                if (bVar7 != null) {
                    bVar7.a(currentTimeMillis, new b(i2, z, currentTimeMillis));
                    AppMethodBeat.o(180124);
                    return;
                }
            }
        }
        AppMethodBeat.o(180124);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "result", "", "onAddResult"})
    static final class b implements b.a {
        final /* synthetic */ boolean PpC;
        final /* synthetic */ long PpD;
        final /* synthetic */ int pnf;

        b(int i2, boolean z, long j2) {
            this.pnf = i2;
            this.PpC = z;
            this.PpD = j2;
        }

        @Override // com.tencent.mm.plugin.ball.c.b.a
        public final void BE(int i2) {
            AppMethodBeat.i(231213);
            Log.i("MicroMsg.FloatBallComponent", "alvinluo onChattingResume fromScene: %d, canShowMessageFloatBall: %b, addMessageBallResult: %d", Integer.valueOf(this.pnf), Boolean.valueOf(this.PpC), Integer.valueOf(i2));
            com.tencent.mm.plugin.ball.c.a aVar = (com.tencent.mm.plugin.ball.c.a) g.af(com.tencent.mm.plugin.ball.c.a.class);
            if (aVar != null) {
                aVar.l(this.PpD, i2);
            }
            AppMethodBeat.o(231213);
        }
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void cFy() {
        AppMethodBeat.i(180125);
        super.cFy();
        com.tencent.mm.plugin.ball.c.b bVar = this.oWG;
        if (bVar != null) {
            bVar.jR(false);
        }
        com.tencent.mm.plugin.ball.c.b bVar2 = this.oWG;
        if (bVar2 != null) {
            bVar2.chW();
            AppMethodBeat.o(180125);
            return;
        }
        AppMethodBeat.o(180125);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.t
    public final void bD(ChatFooter chatFooter) {
        AppMethodBeat.i(180126);
        this.Ppy = chatFooter;
        ChatFooter chatFooter2 = this.Ppy;
        if (chatFooter2 != null) {
            chatFooter2.setOnFooterPanelSwitchListener(this);
            AppMethodBeat.o(180126);
            return;
        }
        AppMethodBeat.o(180126);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009e  */
    @Override // com.tencent.mm.pluginsdk.ui.chat.ChatFooter.f
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void kE(int r11, int r12) {
        /*
        // Method dump skipped, instructions count: 175
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.d.w.kE(int, int):void");
    }
}
