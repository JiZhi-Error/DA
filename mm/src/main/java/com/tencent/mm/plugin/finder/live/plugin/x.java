package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.view.FinderLiveCommentPostRealNamePanel;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J1\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\t0\u0013R\u000e\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentRealNamePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCommentPostRealNamePanel;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCommentPostRealNamePanel;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "realNamePanel", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "show", "realNameUrl", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "plugin-finder_release"})
public final class x extends d {
    private final com.tencent.mm.live.c.b hOp;
    private FinderLiveCommentPostRealNamePanel uoQ;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, hxF = {"<anonymous>", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "requestCode", "", "invoke", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Integer;)V"})
    public static final class a extends q implements kotlin.g.a.q<Context, Intent, Integer, kotlin.x> {
        final /* synthetic */ x uoR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(x xVar) {
            super(3);
            this.uoR = xVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ kotlin.x d(Context context, Intent intent, Integer num) {
            AppMethodBeat.i(246604);
            Context context2 = context;
            Intent intent2 = intent;
            Integer num2 = num;
            p.h(context2, "context");
            p.h(intent2, "intent");
            o oVar = o.ujN;
            s finderLiveAssistant = o.getFinderLiveAssistant();
            if (finderLiveAssistant != null) {
                finderLiveAssistant.a(context2, intent2, num2);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(246604);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "success", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<Boolean, kotlin.x> {
        final /* synthetic */ kotlin.g.a.b gWe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(kotlin.g.a.b bVar) {
            super(1);
            this.gWe = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Boolean bool) {
            AppMethodBeat.i(246605);
            this.gWe.invoke(Boolean.valueOf(bool.booleanValue()));
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(246605);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x(FinderLiveCommentPostRealNamePanel finderLiveCommentPostRealNamePanel, com.tencent.mm.live.c.b bVar) {
        super(finderLiveCommentPostRealNamePanel, bVar);
        p.h(finderLiveCommentPostRealNamePanel, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(246608);
        this.hOp = bVar;
        this.uoQ = finderLiveCommentPostRealNamePanel;
        AppMethodBeat.o(246608);
    }

    @Override // com.tencent.mm.live.c.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(246606);
        super.onActivityResult(i2, i3, intent);
        FinderLiveCommentPostRealNamePanel finderLiveCommentPostRealNamePanel = this.uoQ;
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
                        kotlin.g.a.b<? super Boolean, kotlin.x> bVar = finderLiveCommentPostRealNamePanel.uym;
                        if (bVar != null) {
                            bVar.invoke(Boolean.TRUE);
                        }
                        g gVar = finderLiveCommentPostRealNamePanel.uyo;
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
            AppMethodBeat.o(246606);
            return;
        }
        m.vli.a(s.as.AuthFail);
        AppMethodBeat.o(246606);
    }

    public final void l(String str, kotlin.g.a.b<? super Boolean, kotlin.x> bVar) {
        AppMethodBeat.i(246607);
        p.h(str, "realNameUrl");
        p.h(bVar, "callback");
        this.uoQ.setDialogHeight(((double) ((float) au.az(MMApplicationContext.getContext()).y)) * 0.55d);
        this.uoQ.setWebviewForwardCallback(new a(this));
        FinderLiveCommentPostRealNamePanel finderLiveCommentPostRealNamePanel = this.uoQ;
        b bVar2 = new b(bVar);
        p.h(str, "verifyUrl");
        p.h(bVar2, "callback");
        finderLiveCommentPostRealNamePanel.hJl = str;
        finderLiveCommentPostRealNamePanel.uym = bVar2;
        g gVar = finderLiveCommentPostRealNamePanel.uyo;
        if (gVar == null) {
            p.btv("bottomDialog");
        }
        gVar.dGm();
        m.vli.a(s.as.AuthExposure);
        AppMethodBeat.o(246607);
    }
}
