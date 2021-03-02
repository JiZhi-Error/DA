package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.i;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageLoadTaskListener;", "Lcom/tencent/mm/modelimage/loader/listener/IImageLoadTaskListener;", "scene", "", "(I)V", "url", "", "onAfterRun", "", "onBeforeRun", "Companion", "plugin-biz_release"})
public final class l implements i {
    public static final a KeN = new a((byte) 0);
    private int scene = 1;
    private String url = "";

    static {
        AppMethodBeat.i(124896);
        AppMethodBeat.o(124896);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/pluginsdk/ui/applet/BizImageLoadTaskListener$Companion;", "", "()V", "TAG", "", "plugin-biz_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.av.a.c.i
    public final void Pa(String str) {
        String str2;
        AppMethodBeat.i(124894);
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        this.url = str2;
        g gVar = g.Kev;
        if (g.aig(this.scene)) {
            com.tencent.mm.pluginsdk.model.a aVar = com.tencent.mm.pluginsdk.model.a.JUl;
            com.tencent.mm.pluginsdk.model.a.de(8, str);
            com.tencent.mm.pluginsdk.model.a aVar2 = com.tencent.mm.pluginsdk.model.a.JUl;
            com.tencent.mm.pluginsdk.model.a.dd(2, str);
        }
        AppMethodBeat.o(124894);
    }

    @Override // com.tencent.mm.av.a.c.i
    public final void bdy() {
        AppMethodBeat.i(124895);
        g gVar = g.Kev;
        if (g.aig(this.scene)) {
            com.tencent.mm.pluginsdk.model.a aVar = com.tencent.mm.pluginsdk.model.a.JUl;
            com.tencent.mm.pluginsdk.model.a.de(2, this.url);
        }
        AppMethodBeat.o(124895);
    }
}
