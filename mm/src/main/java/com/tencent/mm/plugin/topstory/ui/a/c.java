package com.tencent.mm.plugin.topstory.ui.a;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.protocal.protobuf.eii;
import com.tencent.mm.protocal.protobuf.eij;
import com.tencent.mm.protocal.protobuf.fam;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends com.tencent.mm.plugin.websearch.webview.a<eii> implements i {
    private com.tencent.mm.plugin.topstory.a.c.b GiP;
    public i Gnc = new i() {
        /* class com.tencent.mm.plugin.topstory.ui.a.c.AnonymousClass2 */

        /* JADX WARNING: Removed duplicated region for block: B:8:0x0040  */
        @Override // com.tencent.mm.ak.i
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSceneEnd(int r8, int r9, java.lang.String r10, com.tencent.mm.ak.q r11) {
            /*
            // Method dump skipped, instructions count: 106
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.topstory.ui.a.c.AnonymousClass2.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
        }
    };
    private boolean Gqn;
    public b Gqo;
    public byte[] Gqp;
    public i Gqq = new i() {
        /* class com.tencent.mm.plugin.topstory.ui.a.c.AnonymousClass1 */

        /* JADX WARNING: Removed duplicated region for block: B:8:0x0040  */
        @Override // com.tencent.mm.ak.i
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSceneEnd(int r9, int r10, java.lang.String r11, com.tencent.mm.ak.q r12) {
            /*
            // Method dump skipped, instructions count: 122
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.topstory.ui.a.c.AnonymousClass1.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
        }
    };
    public i Gqr = new i() {
        /* class com.tencent.mm.plugin.topstory.ui.a.c.AnonymousClass3 */

        /* JADX WARNING: Removed duplicated region for block: B:8:0x004a  */
        @Override // com.tencent.mm.ak.i
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSceneEnd(int r9, int r10, java.lang.String r11, com.tencent.mm.ak.q r12) {
            /*
            // Method dump skipped, instructions count: 132
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.topstory.ui.a.c.AnonymousClass3.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
        }
    };

    public c() {
        super(null);
        AppMethodBeat.i(126558);
        AppMethodBeat.o(126558);
    }

    public final void fzT() {
        AppMethodBeat.i(126559);
        h.RTc.b(new a(this, (byte) 0), "TopStory.LoadHtmlDataFromSdcardTask");
        AppMethodBeat.o(126559);
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(126557);
            String format = String.format("%s/%s", ai.afr(1).fYs(), "app.html");
            c.this.Gqp = s.aW(format, 0, -1);
            AppMethodBeat.o(126557);
        }
    }

    public final void A(String str, String str2, boolean z) {
        AppMethodBeat.i(126560);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(126560);
            return;
        }
        if (this.Gqp != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("json", str);
                jSONObject.put("newQuery", true);
                jSONObject.put("isCache", true);
                jSONObject.put("recType", z ? 1 : 0);
                if (!Util.isNullOrNil(str2)) {
                    jSONObject.put("filterDocidList", new JSONArray(str2));
                }
            } catch (Exception e2) {
            }
            this.Gqp = new String(this.Gqp).replace("'###preloadObjFeedsData###'", jSONObject.toString() + "\n").getBytes();
            Log.i("MicroMsg.TopStory.TopStoryWebData", "attachDataToHtml htmlBytes:%s", Integer.valueOf(this.Gqp.length));
        }
        AppMethodBeat.o(126560);
    }

    public final void a(eii eii, boolean z, boolean z2, int i2) {
        AppMethodBeat.i(126561);
        a(eii, z, z2, i2, "");
        AppMethodBeat.o(126561);
    }

    public final void a(eii eii, boolean z, boolean z2, int i2, String str) {
        AppMethodBeat.i(126562);
        Log.i("MicroMsg.TopStory.TopStoryWebData", "loadDataFromServer directRequest:%s", Boolean.valueOf(z2));
        if (z2 || this.GiP == null || !eii.sessionId.equals(this.GiP.eel.sessionId)) {
            this.GiP = new com.tencent.mm.plugin.topstory.a.c.b(eii, i2, str);
            g.azz().a(1943, this);
            g.azz().a(this.GiP, 0);
            this.Gqn = z;
            Log.i("MicroMsg.TopStory.TopStoryWebData", "Start new net scene");
            AppMethodBeat.o(126562);
            return;
        }
        this.Gqn = z;
        Log.i("MicroMsg.TopStory.TopStoryWebData", "Wait current net scene");
        com.tencent.mm.plugin.topstory.a.i.a(eii, "WaitCurrentNetScene", System.currentTimeMillis());
        AppMethodBeat.o(126562);
    }

    @Override // com.tencent.mm.ak.i, com.tencent.mm.plugin.websearch.webview.a
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(126563);
        if (qVar.equals(this.GiP)) {
            g.azz().b(1943, this);
            this.GiP = null;
            com.tencent.mm.plugin.topstory.a.c.b bVar = (com.tencent.mm.plugin.topstory.a.c.b) qVar;
            if (i2 == 0 && i3 == 0) {
                final fam fxZ = bVar.fxZ();
                final String str2 = fxZ.MaZ;
                ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().KH((long) fxZ.NwP);
                a(bVar.eel, str2, false);
                if (bVar.fxZ().NwO != null && bVar.fxZ().NwO.MOe == 1) {
                    h.RTc.aX(new com.tencent.f.i.h() {
                        /* class com.tencent.mm.plugin.topstory.ui.a.c.AnonymousClass4 */

                        @Override // com.tencent.f.i.h, com.tencent.f.i.g
                        public final String getKey() {
                            return "TopStory.CacheHomeData";
                        }

                        public final void run() {
                            AppMethodBeat.i(126556);
                            eij eij = new eij();
                            eij.Category = fxZ.NwO.Category;
                            eij.NhD = System.currentTimeMillis();
                            eij.MOb = fxZ.NwO.MOb;
                            eij.NhE = fxZ.NwO.MOc;
                            eij.iAc = str2;
                            eij.MOd = fxZ.NwO.MOd;
                            ((PluginTopStoryUI) g.ah(PluginTopStoryUI.class)).getWebViewMgr().GlL.put(Integer.valueOf(eij.Category), eij);
                            try {
                                byte[] byteArray = eij.toByteArray();
                                o oVar = new o(com.tencent.mm.plugin.topstory.a.h.fxS());
                                if (!oVar.exists()) {
                                    oVar.mkdirs();
                                }
                                s.f(com.tencent.mm.plugin.topstory.a.h.fxS() + eij.Category, byteArray, byteArray.length);
                                Log.i("MicroMsg.TopStory.TopStoryWebViewMgr", "putHomeDataCache write data key: %d length: %d", Integer.valueOf(eij.Category), Integer.valueOf(byteArray.length));
                            } catch (IOException e2) {
                                Log.printErrStackTrace("MicroMsg.TopStory.TopStoryWebViewMgr", e2, "putHomeDataCache ", new Object[0]);
                            }
                            ((PluginTopStoryUI) g.ah(PluginTopStoryUI.class)).getWebViewMgr().cC(eij.Category, "");
                            AppMethodBeat.o(126556);
                        }
                    });
                }
            } else {
                Log.i("MicroMsg.TopStory.TopStoryWebData", "netscene topstory error");
                a(bVar.eel, fzU(), true);
                AppMethodBeat.o(126563);
                return;
            }
        }
        AppMethodBeat.o(126563);
    }

    private void a(eii eii, String str, boolean z) {
        AppMethodBeat.i(126564);
        if (this.Gqn) {
            if (((com.tencent.mm.plugin.topstory.ui.home.a) this.IHe) != null) {
                ((com.tencent.mm.plugin.topstory.ui.home.a) this.IHe).aTA(str);
            }
            this.Gqn = false;
            AppMethodBeat.o(126564);
        } else if (z || eii.channelId != 100) {
            this.Gqo = null;
            AppMethodBeat.o(126564);
        } else {
            this.Gqo = new b(this, (byte) 0);
            this.Gqo.Gqw = eii;
            this.Gqo.pnE = System.currentTimeMillis();
            this.Gqo.Gqv = str;
            AppMethodBeat.o(126564);
        }
    }

    private static String fzU() {
        AppMethodBeat.i(126565);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", -1);
        } catch (JSONException e2) {
        }
        String jSONObject2 = jSONObject.toString();
        AppMethodBeat.o(126565);
        return jSONObject2;
    }

    /* access modifiers changed from: package-private */
    public class b {
        String Gqv;
        eii Gqw;
        long pnE;

        private b() {
        }

        /* synthetic */ b(c cVar, byte b2) {
            this();
        }
    }
}
