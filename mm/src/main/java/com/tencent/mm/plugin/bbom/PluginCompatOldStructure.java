package com.tencent.mm.plugin.bbom;

import com.google.android.gms.common.Scopes;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.d;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.y;
import com.tencent.mm.modelmulti.p;
import com.tencent.mm.plugin.bbom.a.b;
import com.tencent.mm.pluginsdk.model.app.ao;

public class PluginCompatOldStructure extends f implements b {
    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(22432);
        super.dependency();
        AppMethodBeat.o(22432);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(22433);
        if (com.tencent.mm.kernel.g.aAe().azG().aBb()) {
            new a() {
                /* class com.tencent.mm.plugin.bbom.m.AnonymousClass1 */

                @Override // com.tencent.mm.kernel.a.c.b
                public final void execute(g gVar) {
                    AppMethodBeat.i(22368);
                    new y(d.class);
                    AppMethodBeat.o(22368);
                }
            }.alone();
            new a() {
                /* class com.tencent.mm.plugin.bbom.m.AnonymousClass2 */

                @Override // com.tencent.mm.kernel.a.c.b
                public final void execute(g gVar) {
                    AppMethodBeat.i(22369);
                    new y(ao.class);
                    AppMethodBeat.o(22369);
                }
            }.alone();
            new a() {
                /* class com.tencent.mm.plugin.bbom.m.AnonymousClass3 */

                @Override // com.tencent.mm.kernel.a.c.b
                public final void execute(g gVar) {
                    AppMethodBeat.i(22370);
                    new e();
                    AppMethodBeat.o(22370);
                }
            }.alone();
            new a() {
                /* class com.tencent.mm.plugin.bbom.m.AnonymousClass4 */

                @Override // com.tencent.mm.kernel.a.c.b
                public final void execute(g gVar) {
                    AppMethodBeat.i(22371);
                    new y(p.class);
                    AppMethodBeat.o(22371);
                }
            }.alone();
            com.tencent.mm.br.b.b(Scopes.PROFILE, null);
            com.tencent.mm.br.b.b("setting", null);
            com.tencent.mm.br.b.b("subapp", null);
            com.tencent.mm.br.b.b("sandbox", null);
            com.tencent.mm.br.b.b("nearby", null);
            com.tencent.mm.br.b.b("brandservice", null);
            com.tencent.mm.br.b.b("favorite", new com.tencent.mm.plugin.favorite.a());
            com.tencent.mm.br.b.b("scanner", null);
            com.tencent.mm.br.b.b("shake", null);
            com.tencent.mm.br.b.b("voip", null);
            com.tencent.mm.br.b.b("radar", null);
            com.tencent.mm.br.b.b("ext", null);
            com.tencent.mm.br.b.b("emoji", new com.tencent.mm.plugin.emoji.model.b());
            com.tencent.mm.br.b.b("account", null);
            com.tencent.mm.br.b.b("qqmail", null);
            com.tencent.mm.br.b.b("readerapp", null);
            com.tencent.mm.br.b.b("talkroom", null);
            com.tencent.mm.br.b.b("bottle", null);
            com.tencent.mm.br.b.b("masssend", null);
            com.tencent.mm.br.b.b("chatroom", null);
            com.tencent.mm.br.b.b(FirebaseAnalytics.b.LOCATION, null);
            com.tencent.mm.br.b.b("clean", null);
            com.tencent.mm.br.b.b("card", null);
            com.tencent.mm.br.b.b("search", new f());
            com.tencent.mm.br.b.b("translate", null);
            com.tencent.mm.br.b.b("extqlauncher", null);
            com.tencent.mm.br.b.b("nearlife", null);
            com.tencent.mm.br.b.b("webview", null);
            com.tencent.mm.br.b.b("exdevice", null);
            com.tencent.mm.br.b.b("freewifi", null);
            com.tencent.mm.br.b.b("pwdgroup", null);
            com.tencent.mm.br.b.b("gallery", null);
            com.tencent.mm.br.b.b("label", null);
            com.tencent.mm.br.b.b("address", null);
            com.tencent.mm.br.b.b("backup", null);
            com.tencent.mm.br.b.b("record", null);
            com.tencent.mm.br.b.b("webwx", null);
            com.tencent.mm.br.b.b("extaccessories", null);
            com.tencent.mm.br.b.b("voiceprint", null);
            com.tencent.mm.br.b.b(PutDataRequest.WEAR_URI_SCHEME, null);
            com.tencent.mm.br.b.b("auto", null);
            com.tencent.mm.br.b.b("gai", null);
            com.tencent.mm.br.b.b("nfc", null);
            com.tencent.mm.br.b.b("tmassistant", null);
            com.tencent.mm.br.b.b("nfc_open", null);
            com.tencent.mm.br.b.b("ipcall", null);
            com.tencent.mm.br.b.b("voip_cs", null);
            com.tencent.mm.br.b.b("multitalk", null);
            com.tencent.mm.br.b.b("wenote", new com.tencent.mm.plugin.wenote.model.a());
            com.tencent.mm.br.b.b("dbbackup", null);
            com.tencent.mm.br.b.b("soter_mp", null);
            com.tencent.mm.br.b.b("sl_warpgate", null);
            com.tencent.mm.br.b.b("aa", null);
            com.tencent.mm.br.b.b("sport", null);
            com.tencent.mm.br.b.b("fps_lighter", null);
            com.tencent.mm.br.b.b("mmsight", null);
            com.tencent.mm.br.b.b("login_exdevice", null);
            com.tencent.mm.br.b.b("finder", null);
            com.tencent.mm.br.b.b("groupcollect", null);
            com.tencent.mm.br.b.b("editor", null);
            com.tencent.mm.br.b.b("teenmode", null);
            com.tencent.mm.br.b.b("kidswatch", null);
        }
        AppMethodBeat.o(22433);
    }
}
