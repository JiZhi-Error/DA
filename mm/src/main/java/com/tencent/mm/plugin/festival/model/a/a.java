package com.tencent.mm.plugin.festival.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.of;
import com.tencent.mm.plugin.festival.model.ParcelableFestivalWish;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/report/FestivalCanvasOpReporter;", "", "()V", "reportTimestamp", "", "getReportTimestamp", "()J", "canvasClickClearScreen", "", "danmakuClick", "wishInfo", "Lcom/tencent/mm/plugin/festival/model/ParcelableFestivalWish;", "deleteMyWish", "wishId", "", "menuClickClearScreen", "menuMyWishClick", "popupClick", "wishCardAvatarClicked", "plugin-festival_release"})
public final class a {
    public static final a UzS = new a();

    static {
        AppMethodBeat.i(263162);
        AppMethodBeat.o(263162);
    }

    private a() {
    }

    public static long hRU() {
        AppMethodBeat.i(263160);
        long nowSecond = Util.nowSecond();
        AppMethodBeat.o(263160);
        return nowSecond;
    }

    public static void a(ParcelableFestivalWish parcelableFestivalWish) {
        AppMethodBeat.i(263161);
        p.h(parcelableFestivalWish, "wishInfo");
        of PF = new of().PF(Util.nowSecond());
        b bVar = b.UzX;
        PF.GK(b.hRV()).TA(parcelableFestivalWish.UzM).Tz(parcelableFestivalWish.UzO).SM(1).SR(1).bfK();
        AppMethodBeat.o(263161);
    }
}
