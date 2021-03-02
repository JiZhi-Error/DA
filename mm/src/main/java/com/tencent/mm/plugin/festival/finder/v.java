package com.tencent.mm.plugin.festival.finder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.festival.ui.view.FestivalRealNamePanel;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J1\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\t0\u0013R\u000e\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentRealNamePlugin;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePlugin;", "root", "Lcom/tencent/mm/plugin/festival/ui/view/FestivalRealNamePanel;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Lcom/tencent/mm/plugin/festival/ui/view/FestivalRealNamePanel;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "realNamePanel", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "show", "realNameUrl", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "plugin-festival_release"})
public final class v extends p {
    FestivalRealNamePanel UsL;
    private final com.tencent.mm.live.c.b hOp;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, hxF = {"<anonymous>", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "requestCode", "", "invoke", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Integer;)V"})
    static final class a extends q implements kotlin.g.a.q<Context, Intent, Integer, x> {
        public static final a UsM = new a();

        static {
            AppMethodBeat.i(262306);
            AppMethodBeat.o(262306);
        }

        a() {
            super(3);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(Context context, Intent intent, Integer num) {
            AppMethodBeat.i(262305);
            Context context2 = context;
            Intent intent2 = intent;
            Integer num2 = num;
            p.h(context2, "context");
            p.h(intent2, "intent");
            at atVar = at.Uuv;
            s finderLiveAssistant = at.getFinderLiveAssistant();
            if (finderLiveAssistant != null) {
                finderLiveAssistant.a(context2, intent2, num2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(262305);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "success", "", "invoke"})
    static final class b extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ kotlin.g.a.b gWe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(kotlin.g.a.b bVar) {
            super(1);
            this.gWe = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(262307);
            this.gWe.invoke(Boolean.valueOf(bool.booleanValue()));
            x xVar = x.SXb;
            AppMethodBeat.o(262307);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(FestivalRealNamePanel festivalRealNamePanel, com.tencent.mm.live.c.b bVar) {
        super(festivalRealNamePanel, bVar);
        p.h(festivalRealNamePanel, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(262309);
        this.hOp = bVar;
        this.UsL = festivalRealNamePanel;
        AppMethodBeat.o(262309);
    }

    @Override // com.tencent.mm.live.c.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(262308);
        super.onActivityResult(i2, i3, intent);
        FestivalRealNamePanel festivalRealNamePanel = this.UsL;
        boolean z = false;
        if (i2 == 10000) {
            Bundle bundleExtra = intent != null ? intent.getBundleExtra("result_data") : null;
            if (i3 == -1 && bundleExtra != null) {
                String string = bundleExtra.getString("go_next", "");
                String string2 = bundleExtra.getString("result_json");
                if (!Util.isNullOrNil(string2)) {
                    int i4 = new i(string2).getInt(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                    Log.i("Finder.FinderMaxSizeLayout", "onActivityResult, nextStep:" + string + ", code:" + i4);
                    if (p.j(string, "roomlive_verify") && i4 == 0) {
                        kotlin.g.a.b<? super Boolean, x> bVar = festivalRealNamePanel.uym;
                        if (bVar != null) {
                            bVar.invoke(Boolean.TRUE);
                        }
                        g gVar = festivalRealNamePanel.uyo;
                        if (gVar == null) {
                            p.btv("bottomDialog");
                        }
                        gVar.bMo();
                        z = true;
                    }
                }
            }
        }
        if (z) {
            m.vli.a(s.as.AuthSucc);
            AppMethodBeat.o(262308);
            return;
        }
        m.vli.a(s.as.AuthFail);
        AppMethodBeat.o(262308);
    }
}
