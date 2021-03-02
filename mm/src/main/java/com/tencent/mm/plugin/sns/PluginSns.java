package com.tencent.mm.plugin.sns;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.sns.ad.a;
import com.tencent.mm.plugin.sns.ad.f.b;
import com.tencent.mm.plugin.sns.ad.f.e;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.ui.album.SnsAlbumUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.vfs.y;

public class PluginSns extends f implements c {
    l DqT = new l();
    a DqU = new a();
    o DqV = new o();
    a DqW = new a();

    public PluginSns() {
        AppMethodBeat.i(94896);
        AppMethodBeat.o(94896);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(94897);
        dependsOn(d.class);
        dependsOn(com.tencent.mm.plugin.normsg.a.class);
        AppMethodBeat.o(94897);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(94898);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.b(j.class, this.DqT);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.sns.b.d.class, this.DqW);
        a aVar = this.DqW;
        aVar.a(new e());
        aVar.a(new com.tencent.mm.plugin.sns.ad.f.d());
        aVar.a(new b());
        aVar.a(new com.tencent.mm.plugin.sns.ad.f.c());
        if (gVar.aBb()) {
            Log.i("MicroMsg.PluginSns", "PluginSns configure");
            y.nA("sns", "sns");
            y.b("sns_ad_landingpages", "sns_ad_landingpages", 2592000000L, 103);
            pin(new com.tencent.mm.model.y(aj.class));
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.sns.b.a.class, this.DqU);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.b(n.class, this.DqV);
        }
        AppMethodBeat.o(94898);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(94899);
        com.tencent.mm.br.b.bfQ("sns");
        AppMethodBeat.o(94899);
    }

    @Override // com.tencent.mm.plugin.sns.b.c
    public String getAccSnsPath() {
        AppMethodBeat.i(179063);
        String str = com.tencent.mm.kernel.g.aAh().hqG + "sns/";
        AppMethodBeat.o(179063);
        return str;
    }

    @Override // com.tencent.mm.plugin.sns.b.c
    public String getAccSnsTmpPath() {
        AppMethodBeat.i(179064);
        String str = com.tencent.mm.kernel.g.aAh().hqG + "sns/temp/";
        AppMethodBeat.o(179064);
        return str;
    }

    @Override // com.tencent.mm.plugin.sns.b.c
    public String getSnsAdPath() {
        AppMethodBeat.i(179065);
        String str = com.tencent.mm.kernel.g.aAh().hqG + "sns/sns_ad//";
        AppMethodBeat.o(179065);
        return str;
    }

    @Override // com.tencent.mm.plugin.sns.b.c
    public MMFragment instantiateAlbumFragment(Context context, Bundle bundle) {
        AppMethodBeat.i(94900);
        MMFragment mMFragment = (MMFragment) Fragment.instantiate(context, SnsAlbumUI.class.getName(), bundle);
        AppMethodBeat.o(94900);
        return mMFragment;
    }

    public p getUIManager() {
        AppMethodBeat.i(94901);
        p eWt = p.eWt();
        AppMethodBeat.o(94901);
        return eWt;
    }
}
