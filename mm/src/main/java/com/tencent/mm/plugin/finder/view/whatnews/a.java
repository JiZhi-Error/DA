package com.tencent.mm.plugin.finder.view.whatnews;

import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u001b\u0010\n\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\n\u0010\tR\u0011\u0010\r\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/whatnews/FinderWhatsNewController;", "", "()V", "ID_KEY", "", "TAG", "", "isAvailableBoot", "", "()Z", "isAvailableBootLazy", "isAvailableBootLazy$delegate", "Lkotlin/Lazy;", "isAvailableEnter", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "", "getStyle", "()I", "clearShowFlag", "", "hasShown", "plugin-finder_release"})
public final class a {
    private static final f wtF = g.ah(C1349a.wtH);
    public static final a wtG = new a();

    static {
        AppMethodBeat.i(168552);
        e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().getBoolean(ar.a.USERINFO_FINDER_WHATS_NEW_SHOWN_BOOLEAN_SYNC, false);
        AppMethodBeat.o(168552);
    }

    private a() {
    }

    public static final /* synthetic */ boolean dHN() {
        AppMethodBeat.i(168554);
        e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        boolean z = aAh.azQ().getBoolean(ar.a.USERINFO_FINDER_WHATS_NEW_SHOWN_BOOLEAN_SYNC, false);
        if (1 == ChannelUtil.channelId) {
            Log.w("Finder.WhatNewsController", "[GET] This is GP Version, just ignore.");
            AppMethodBeat.o(168554);
        } else if (d.KyR) {
            Log.w("Finder.WhatNewsController", "[GET] This is alpha Version, just ignore.");
            AppMethodBeat.o(168554);
        } else if (!c.bfW("whatsnew")) {
            Log.e("Finder.WhatNewsController", "[GET] the WhatsNewUI plugin without install , just ignore.");
            AppMethodBeat.o(168554);
        } else if (!LocaleUtil.isSimplifiedChineseAppLang()) {
            Log.w("Finder.WhatNewsController", "[GET] This is not Chinese Language , just ignore.");
            h.INSTANCE.n(1305, 20, 1);
            AppMethodBeat.o(168554);
        } else {
            Log.i("Finder.WhatNewsController", "[GET] showFinderEntry=" + ((aj) com.tencent.mm.kernel.g.ah(aj.class)).showFinderEntry() + " isShown=" + z + " style=0 isAvailableBoot=false");
            AppMethodBeat.o(168554);
        }
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.finder.view.whatnews.a$a  reason: collision with other inner class name */
    static final class C1349a extends q implements kotlin.g.a.a<Boolean> {
        public static final C1349a wtH = new C1349a();

        static {
            AppMethodBeat.i(168551);
            AppMethodBeat.o(168551);
        }

        C1349a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(168550);
            a aVar = a.wtG;
            Boolean valueOf = Boolean.valueOf(a.dHN());
            AppMethodBeat.o(168550);
            return valueOf;
        }
    }
}
