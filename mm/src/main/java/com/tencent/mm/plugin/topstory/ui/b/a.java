package com.tencent.mm.plugin.topstory.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.f;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiv;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class a extends f {
    private static e lqt = new com.tencent.mm.plugin.ball.c.f() {
        /* class com.tencent.mm.plugin.topstory.ui.b.a.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void b(BallInfo ballInfo) {
            AppMethodBeat.i(125898);
            a.a(ballInfo);
            AppMethodBeat.o(125898);
        }

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void c(BallInfo ballInfo) {
        }

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void d(BallInfo ballInfo) {
        }
    };

    public a(com.tencent.mm.plugin.ball.a.f fVar) {
        super(fVar);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean aGg() {
        return true;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void G(int i2, String str) {
        AppMethodBeat.i(125899);
        super.G(i2, str);
        ciw().hDa = 7;
        AppMethodBeat.o(125899);
    }

    static {
        AppMethodBeat.i(125904);
        AppMethodBeat.o(125904);
    }

    public static void bCM() {
        AppMethodBeat.i(125900);
        if (g.af(b.class) != null) {
            ((b) g.af(b.class)).a(8, lqt);
        }
        AppMethodBeat.o(125900);
    }

    public static void bCN() {
        AppMethodBeat.i(125901);
        if (g.af(b.class) != null) {
            ((b) g.af(b.class)).b(8, lqt);
        }
        AppMethodBeat.o(125901);
    }

    public final void a(eit eit, eiw eiw) {
        AppMethodBeat.i(125902);
        Log.i("MicroMsg.TopStory.TopStoryFloatBallHelper", "updateFloatBallData contextId:%s videoId:%s", eit.sGQ, eiw.psI);
        eiv eiv = new eiv();
        eiv.NhX = eit.NhX;
        eiv.NhY = eit.NhY;
        if (Util.isNullOrNil(eit.hes)) {
            eiv.NhZ = eit.NhZ;
        } else {
            eiv.NhZ = eit.hes;
        }
        eiv.Nia = eit.Nia;
        eiv.Nid = eit.Nid;
        eiv.sGQ = eit.sGQ;
        eiv.Nik = eit.Nik;
        eiv.offset = eit.offset;
        eiv.Nib = eit.Nib;
        eiv.scene = eit.scene;
        eiv.dDv = eit.dDv;
        eiv.IDO = eit.IDO;
        eiv.Mub.add(eiw);
        try {
            agT(eiw.title);
            byte[] byteArray = eiv.toByteArray();
            if (this.oWE != null) {
                Log.i("MicroMsg.FloatBallHelper", "updateByteArrayExtra, %s", "key_context");
                this.oWE.G("key_context", byteArray);
                cit();
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryFloatBallHelper", e2, "updateFloatBallData exception:%s", e2);
        }
        ciw().dPJ = eiv.NhZ;
        ciw().oWy = eiw.psI;
        ciw().oWx = eiv.scene;
        Log.d("MicroMsg.TopStory.TopStoryFloatBallHelper", "updateFloatBallData, searchId:%s vid:%s", eiv.NhZ, eiw.psI);
        cit();
        AppMethodBeat.o(125902);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean bCG() {
        return true;
    }

    static /* synthetic */ void a(BallInfo ballInfo) {
        AppMethodBeat.i(125903);
        if (ballInfo != null) {
            byte[] byteArrayExtra = ballInfo.getByteArrayExtra("key_context");
            eiv eiv = new eiv();
            try {
                eiv.parseFrom(byteArrayExtra);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.TopStory.TopStoryFloatBallHelper", e2, "handleBallInfoClicked exception:%s", e2);
            }
            if (eiv.Mub.size() > 0) {
                eit eit = new eit();
                eit.scene = eiv.scene;
                eit.Nid = eiv.Nid;
                eit.Nic = eiv.Mub.get(0);
                eit.NhX = eit.Nic.psI;
                eit.NhZ = eiv.NhZ;
                eit.NhY = eiv.NhY;
                eit.Nia = eiv.Nia;
                eit.Nib = eiv.Nib;
                eit.sGQ = eiv.sGQ;
                eit.Nik = eiv.Nik;
                eit.offset = eiv.offset;
                eit.dDv = eiv.dDv;
                eit.IDO = eiv.IDO;
                Log.i("MicroMsg.TopStory.TopStoryFloatBallHelper", "handleBallInfoClicked, contextId:%s videoId:%s", eit.sGQ, eit.Nic.psI);
                ai.a(MMApplicationContext.getContext(), eit);
                AppMethodBeat.o(125903);
                return;
            }
            Log.e("MicroMsg.TopStory.TopStoryFloatBallHelper", "handleBallInfoClicked, cache video list size == 0");
        }
        AppMethodBeat.o(125903);
    }
}
