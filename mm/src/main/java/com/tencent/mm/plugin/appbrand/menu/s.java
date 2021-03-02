package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.huawei.easygo.sdk.EasyGo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.m;

public final class s extends a<ag> {
    private EasyGo easyGoManager = null;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, com.tencent.mm.ui.base.m, java.lang.String] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* bridge */ /* synthetic */ void a(Context context, ag agVar, m mVar, String str) {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.appbrand.page.ac, java.lang.String, com.tencent.mm.plugin.appbrand.menu.t] */
    @Override // com.tencent.mm.plugin.appbrand.menu.a.a
    public final /* synthetic */ void a(Context context, ag agVar, String str, t tVar) {
        AppMethodBeat.i(227177);
        ag agVar2 = agVar;
        if (this.easyGoManager == null) {
            this.easyGoManager = new EasyGo(context);
        }
        this.easyGoManager.init(new String[]{"magicwindow"});
        if (aw.a(this.easyGoManager, agVar2.getActivity().getTaskId()) == 2) {
            aw.a(this.easyGoManager, agVar2.getActivity().getTaskId(), 0);
            AppMethodBeat.o(227177);
            return;
        }
        aw.a(this.easyGoManager, agVar2.getActivity().getTaskId(), 2);
        AppMethodBeat.o(227177);
    }

    public s() {
        super(u.splitScreen.ordinal());
        AppMethodBeat.i(227176);
        AppMethodBeat.o(227176);
    }
}
