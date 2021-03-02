package com.tencent.mm.plugin.webview.luggage;

import com.tencent.luggage.d.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.service.f;
import com.tencent.mm.plugin.webview.f.c;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Set;

public final class q extends f {
    private static final Set<String> IUM;
    private g ISU;
    private String IUJ;
    private boolean IUK;
    private String IUL;

    public q(com.tencent.mm.plugin.ball.a.f fVar, g gVar) {
        super(fVar);
        this.ISU = gVar;
    }

    static {
        AppMethodBeat.i(78425);
        HashSet hashSet = new HashSet();
        IUM = hashSet;
        hashSet.add("title");
        IUM.add("webpageTitle");
        IUM.add("srcUsername");
        IUM.add("srcDisplayname");
        IUM.add("mode");
        IUM.add("KTemplateId");
        IUM.add("KPublisherId");
        AppMethodBeat.o(78425);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean aGh() {
        AppMethodBeat.i(78415);
        boolean gbH = this.ISU.gbH();
        AppMethodBeat.o(78415);
        return gbH;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean aGg() {
        AppMethodBeat.i(78416);
        if (!this.ISU.gbH() || !this.oXA.aGg()) {
            AppMethodBeat.o(78416);
            return false;
        }
        AppMethodBeat.o(78416);
        return true;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void G(int i2, String str) {
        AppMethodBeat.i(78417);
        Log.i("MicroMsg.LuggageWebViewFloatBallHelper", "onCreate, type:%s, key:%s", Integer.valueOf(i2), str);
        super.G(i2, str);
        ciw().hDa = 8;
        ciw().oWx = 32;
        cit();
        if (!(this.oXA.getIntent() == null || this.oWE.jkf == null)) {
            com.tencent.mm.plugin.ball.f.a.b(this.oXA.getIntent(), this.oWE.jkf, IUM);
            cit();
        }
        this.IUJ = str;
        this.IUK = true;
        if (!Util.isNullOrNil(this.IUL)) {
            aYt(this.IUL);
        }
        AppMethodBeat.o(78417);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final boolean wu(int i2) {
        AppMethodBeat.i(78418);
        Log.i("MicroMsg.LuggageWebViewFloatBallHelper", "onClose :%s", Integer.valueOf(this.ISU.hashCode()));
        boolean wu = super.wu(i2);
        AppMethodBeat.o(78418);
        return wu;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void onDestroy() {
        AppMethodBeat.i(78419);
        Log.i("MicroMsg.LuggageWebViewFloatBallHelper", "onDestroy :%s", Integer.valueOf(this.ISU.hashCode()));
        super.onDestroy();
        AppMethodBeat.o(78419);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void bCA() {
        AppMethodBeat.i(78420);
        Log.i("MicroMsg.LuggageWebViewFloatBallHelper", "onEnterPage :%s", Integer.valueOf(this.ISU.hashCode()));
        super.bCA();
        AppMethodBeat.o(78420);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGj() {
        AppMethodBeat.i(78421);
        Log.i("MicroMsg.LuggageWebViewFloatBallHelper", "onExitPage :%s", Integer.valueOf(this.ISU.hashCode()));
        super.aGj();
        AppMethodBeat.o(78421);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGi() {
        AppMethodBeat.i(78422);
        Log.i("MicroMsg.LuggageWebViewFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent:%s", Integer.valueOf(this.ISU.hashCode()));
        super.aGi();
        this.oXA.hb(false);
        AppMethodBeat.o(78422);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final void agT(String str) {
        AppMethodBeat.i(78423);
        if (this.oWE == null || Util.isNullOrNil(this.oWE.name) || this.oWE.name.startsWith(HttpWrapperBase.PROTOCAL_HTTP) || this.oWE.name.startsWith(HttpWrapperBase.PROTOCAL_HTTPS) || Util.isNullOrNil(str) || (!str.startsWith(HttpWrapperBase.PROTOCAL_HTTP) && !str.startsWith(HttpWrapperBase.PROTOCAL_HTTPS))) {
            super.agT(str);
            AppMethodBeat.o(78423);
            return;
        }
        AppMethodBeat.o(78423);
    }

    public final void aYt(String str) {
        AppMethodBeat.i(78424);
        this.IUL = str;
        if (!this.IUK) {
            AppMethodBeat.o(78424);
            return;
        }
        ciw().dPJ = str;
        cit();
        AppMethodBeat.o(78424);
    }

    public static class a implements com.tencent.luggage.d.a.a {
        private g ISU;
        private c ITv;
        private Set<String> IUN = new HashSet();

        public a(g gVar, c cVar) {
            AppMethodBeat.i(210935);
            this.ISU = gVar;
            this.ITv = cVar;
            AppMethodBeat.o(210935);
        }

        public final void aYu(String str) {
            AppMethodBeat.i(210936);
            this.IUN.add(str);
            AppMethodBeat.o(210936);
        }

        @Override // com.tencent.luggage.d.a.a
        public final void a(com.tencent.luggage.d.a.c cVar) {
            AppMethodBeat.i(210937);
            cVar.a(b.PASS);
            AppMethodBeat.o(210937);
        }

        @Override // com.tencent.luggage.d.a.a
        public final void a(String str, com.tencent.luggage.d.a.c cVar) {
            AppMethodBeat.i(210938);
            if (this.IUN.contains(str)) {
                this.IUN.remove(str);
                cVar.a(b.PASS);
                AppMethodBeat.o(210938);
                return;
            }
            cVar.a(this.ITv.gs(this.ISU.getUrl(), c.aZG(str)) ? b.PASS : b.REJECT);
            AppMethodBeat.o(210938);
        }
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean bCG() {
        AppMethodBeat.i(210939);
        boolean gbH = this.ISU.gbH();
        AppMethodBeat.o(210939);
        return gbH;
    }
}
