package com.tencent.mm.plugin.finder.upload;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.loader.g.a.f;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.loader.g.d;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.upload.action.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.p;

public final class b {
    public static final String TAG = TAG;
    private static final b vRL = new b();
    public static final a vRM = new a((byte) 0);
    public d<a> vRJ = new d<>(new f(new com.tencent.mm.loader.g.a.a(100), new g(1, (byte) 0), 1, "finder_action_post_quene"));
    private final Runnable vRK = new c(this);

    public b() {
        AppMethodBeat.i(167721);
        AppMethodBeat.o(167721);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(167722);
        AppMethodBeat.o(167722);
    }

    public static /* synthetic */ an a(b bVar, long j2, String str, long j3, String str2, String str3, String str4, String str5, String str6, String str7, int i2, bbn bbn, int i3) {
        AppMethodBeat.i(253044);
        an a2 = bVar.a(j2, str, j3, str2, str3, str4, str5, null, null, str6, str7, i2, false, null, bbn, i3);
        AppMethodBeat.o(253044);
        return a2;
    }

    public final an a(long j2, String str, long j3, String str2, String str3, String str4, String str5, Long l, String str6, String str7, String str8, int i2, boolean z, FinderCommentInfo finderCommentInfo, bbn bbn, int i3) {
        AppMethodBeat.i(253043);
        p.h(str, "feedUsername");
        p.h(str2, "objectNonceId");
        p.h(str4, "replyUsername");
        p.h(str5, "replyNickname");
        p.h(str7, ch.COL_USERNAME);
        p.h(str8, "nickname");
        com.tencent.mm.plugin.finder.storage.logic.a aVar = com.tencent.mm.plugin.finder.storage.logic.a.vGJ;
        an a2 = com.tencent.mm.plugin.finder.storage.logic.a.a(j3, str2, str7, str, l, str6, str4, str5, str3, str8, i2, j2, z, finderCommentInfo, bbn, i3);
        ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderActionStorage().a(a2);
        a(new a(a2));
        AppMethodBeat.o(253043);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public static final class c implements Runnable {
        final /* synthetic */ b vRN;

        c(b bVar) {
            this.vRN = bVar;
        }

        public final void run() {
            AppMethodBeat.i(167717);
            this.vRN.dAP();
            AppMethodBeat.o(167717);
        }
    }

    /* renamed from: com.tencent.mm.plugin.finder.upload.b$b */
    public static final class C1305b implements com.tencent.mm.loader.g.f<a> {
        final /* synthetic */ b vRN;

        C1305b(b bVar) {
            this.vRN = bVar;
        }

        @Override // com.tencent.mm.loader.g.f
        public final /* synthetic */ void a(a aVar, j jVar) {
            AppMethodBeat.i(167716);
            p.h(aVar, "task");
            p.h(jVar, "status");
            a aVar2 = b.vRM;
            Log.i(b.TAG, "task callback ".concat(String.valueOf(jVar)));
            if (jVar == j.OK) {
                this.vRN.dAP();
                AppMethodBeat.o(167716);
                return;
            }
            MMHandlerThread.removeRunnable(this.vRN.vRK);
            Runnable runnable = this.vRN.vRK;
            a.C1302a aVar3 = com.tencent.mm.plugin.finder.upload.action.a.vTR;
            MMHandlerThread.postToMainThreadDelayed(runnable, com.tencent.mm.plugin.finder.upload.action.a.qnq);
            AppMethodBeat.o(167716);
        }
    }

    public final void a(a aVar) {
        AppMethodBeat.i(167719);
        p.h(aVar, NativeProtocol.WEB_DIALOG_ACTION);
        this.vRJ.a(aVar, new C1305b(this));
        AppMethodBeat.o(167719);
    }

    public final void dAP() {
        AppMethodBeat.i(167720);
        an dqh = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderActionStorage().dqh();
        if (dqh != null) {
            a(new a(dqh));
            AppMethodBeat.o(167720);
            return;
        }
        AppMethodBeat.o(167720);
    }
}
