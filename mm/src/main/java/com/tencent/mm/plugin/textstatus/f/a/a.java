package com.tencent.mm.plugin.textstatus.f.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.g.g;
import com.tencent.mm.plugin.textstatus.g.q;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/album/AlbumItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "history", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusHistory;", "(Lcom/tencent/mm/plugin/textstatus/proto/TextStatusHistory;)V", "getHistory", "()Lcom/tencent/mm/plugin/textstatus/proto/TextStatusHistory;", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getItem", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "setItem", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;)V", "monthDayStr", "", "getMonthDayStr", "()Ljava/lang/String;", "setMonthDayStr", "(Ljava/lang/String;)V", "yearStr", "getYearStr", "setYearStr", "getItemId", "", "getItemType", "", "plugin-textstatus_release"})
public final class a implements com.tencent.mm.view.recyclerview.a {
    public com.tencent.mm.plugin.textstatus.f.f.a FZq;
    public String FZr;
    public String FZs;
    private final q FZt;

    public a(q qVar) {
        p.h(qVar, "history");
        AppMethodBeat.i(216229);
        this.FZt = qVar;
        com.tencent.mm.plugin.textstatus.f.f.a aVar = new com.tencent.mm.plugin.textstatus.f.f.a();
        aVar.field_UserName = com.tencent.mm.plugin.auth.a.a.ceA();
        aVar.field_StatusID = this.FZt.Gas;
        g gVar = new g();
        gVar.parseFrom(Base64.decode(this.FZt.GaN, 0));
        f fVar = f.FXJ;
        f.a(aVar, gVar);
        this.FZq = aVar;
        AppMethodBeat.o(216229);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        AppMethodBeat.i(216228);
        long hashCode = (long) hashCode();
        AppMethodBeat.o(216228);
        return hashCode;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return 0;
    }
}
