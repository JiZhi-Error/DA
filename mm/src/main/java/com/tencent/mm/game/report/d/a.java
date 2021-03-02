package com.tencent.mm.game.report.d;

import android.os.Bundle;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.LinkedList;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\fJ\b\u0010\u0018\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/game/report/service/GameChatReportWrapper;", "", "()V", "CMD_UNREAD_MSG", "", "KEY_CMD", "", "KEY_HAS_UNREAD_MSG", "TAG", "curSeq", "", "isBusy", "", "waitingList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/game/report/protobuf/ChatReportRequest;", "report", "", "data", "Landroid/os/Bundle;", "reportInMainProcess", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "reportUnreadState", "hasUnreadMsg", "tryDoScene", "IpcChatReportTask", "report-api_release"})
public final class a {
    private static final LinkedList<com.tencent.mm.game.report.c.a> hhn = new LinkedList<>();
    private static boolean hho;
    private static long his;
    public static final a hit = new a();

    static {
        AppMethodBeat.i(190344);
        AppMethodBeat.o(190344);
    }

    private a() {
    }

    public static final /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(190346);
        aVar.axe();
        AppMethodBeat.o(190346);
    }

    public static final /* synthetic */ void a(a aVar, Bundle bundle) {
        AppMethodBeat.i(190345);
        aVar.u(bundle);
        AppMethodBeat.o(190345);
    }

    public static void ek(boolean z) {
        AppMethodBeat.i(190340);
        Bundle bundle = new Bundle();
        bundle.putInt("cmd", 1);
        bundle.putBoolean("has_unread_msg", z);
        hit.u(bundle);
        AppMethodBeat.o(190340);
    }

    private final synchronized void u(Bundle bundle) {
        AppMethodBeat.i(190341);
        if (bundle == null) {
            AppMethodBeat.o(190341);
        } else if (MMApplicationContext.isMainProcess()) {
            com.tencent.mm.game.report.c.a aVar = new com.tencent.mm.game.report.c.a();
            switch (bundle.getInt("cmd", 0)) {
                case 1:
                    if (his == 0) {
                        Object obj = g.aAh().azQ().get(ar.a.USERINFO_GAME_CHAT_UNREAD_MSG_SEQ_LONG_SYNC, (Object) 1000L);
                        if (obj == null) {
                            t tVar = new t("null cannot be cast to non-null type kotlin.Long");
                            AppMethodBeat.o(190341);
                            throw tVar;
                        }
                        his = Util.nullAsNil((Long) obj);
                    }
                    com.tencent.mm.game.report.c.g gVar = new com.tencent.mm.game.report.c.g();
                    long j2 = his + 1;
                    his = j2;
                    gVar.seq = j2;
                    gVar.hiq = q.aoJ();
                    gVar.hir = bundle.getBoolean("has_unread_msg", false);
                    aVar.hic = gVar;
                    hit.a(aVar);
                    AppMethodBeat.o(190341);
                    break;
                default:
                    AppMethodBeat.o(190341);
                    break;
            }
        } else {
            h.a(MainProcessIPCService.dkO, bundle, C0346a.class, null);
            AppMethodBeat.o(190341);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J#\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bH\u0002¨\u0006\t"}, hxF = {"Lcom/tencent/mm/game/report/service/GameChatReportWrapper$IpcChatReportTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "report-api_release"})
    /* renamed from: com.tencent.mm.game.report.d.a$a  reason: collision with other inner class name */
    public static final class C0346a implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
            AppMethodBeat.i(190338);
            a.a(a.hit, bundle);
            AppMethodBeat.o(190338);
        }
    }

    private final synchronized void a(com.tencent.mm.game.report.c.a aVar) {
        AppMethodBeat.i(190342);
        if (!g.aAf().azp() || com.tencent.mm.kernel.a.azj()) {
            Log.w("MicroMsg.GameChatReport", "report, account not ready");
            AppMethodBeat.o(190342);
        } else {
            hhn.add(aVar);
            axe();
            AppMethodBeat.o(190342);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0081, code lost:
        if (com.tencent.mm.ak.aa.a(r3.aXF(), new com.tencent.mm.game.report.d.a.b(r1)) == null) goto L_0x0083;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void axe() {
        /*
        // Method dump skipped, instructions count: 143
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.game.report.d.a.axe():void");
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\b2\u000e\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    public static final class b implements aa.a {
        final /* synthetic */ com.tencent.mm.game.report.c.a hiu;

        b(com.tencent.mm.game.report.c.a aVar) {
            this.hiu = aVar;
        }

        @Override // com.tencent.mm.ak.aa.a
        public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, com.tencent.mm.ak.q qVar) {
            com.tencent.mm.game.report.c.g gVar;
            AppMethodBeat.i(190339);
            Log.i("MicroMsg.GameChatReport", "tryDoScene, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
            if (i2 == 0 && i3 == 0 && (gVar = this.hiu.hic) != null) {
                g.aAh().azQ().set(ar.a.USERINFO_GAME_CHAT_UNREAD_MSG_SEQ_LONG_SYNC, Long.valueOf(gVar.seq));
                g.aAh().azQ().set(ar.a.USERINFO_GAME_CHAT_UNREAD_MSG_STATE_BOOLEAN_SYNC, Boolean.valueOf(gVar.hir));
            }
            a aVar = a.hit;
            a.hho = false;
            a.a(a.hit);
            AppMethodBeat.o(190339);
            return 0;
        }
    }
}
