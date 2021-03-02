package com.tencent.mm.plugin.vlog.model.panel;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ac;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0013\u0010\u000f\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/vlog/model/panel/PagPanelItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "name", "", "pagPath", "pagIconPath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getPagIconPath", "getPagPath", "contentEquals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "equals", "plugin-vlog_release"})
public final class e extends ac {
    public final String Cga;
    final String GAV;
    final String name;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(String str, String str2, String str3) {
        super(b.fCc());
        p.h(str, "name");
        p.h(str2, "pagPath");
        p.h(str3, "pagIconPath");
        AppMethodBeat.i(190794);
        this.name = str;
        this.Cga = str2;
        this.GAV = str3;
        AppMethodBeat.o(190794);
    }

    @Override // com.tencent.mm.emoji.b.b.ac
    public final boolean equals(Object obj) {
        AppMethodBeat.i(190792);
        if (!super.equals(obj) || !(obj instanceof e) || !p.j(((e) obj).name, this.name)) {
            AppMethodBeat.o(190792);
            return false;
        }
        AppMethodBeat.o(190792);
        return true;
    }

    @Override // com.tencent.mm.emoji.b.b.ac
    public final boolean aZ(Object obj) {
        AppMethodBeat.i(190793);
        if (!super.aZ(obj) || !(obj instanceof e) || !p.j(((e) obj).Cga, this.Cga) || !p.j(((e) obj).GAV, this.GAV)) {
            AppMethodBeat.o(190793);
            return false;
        }
        AppMethodBeat.o(190793);
        return true;
    }
}
