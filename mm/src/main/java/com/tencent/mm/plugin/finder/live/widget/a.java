package com.tencent.mm.plugin.finder.live.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.model.cgi.o;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.live.viewmodel.i;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001'B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0002J \u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u0010\u0010!\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010#J\u000e\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u001dJ\b\u0010&\u001a\u00020\u0014H\u0002R\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLotteryEntranceWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "checkVisible", "", "initView", "isVisible", "", "jumpToCreateLotteryImpl", "jumpToCreateLotttery", "lotteryEntranceLogic", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onPortraitAction", "extraMsg", "Landroid/os/Bundle;", "setVisible", "visible", "showCard", "Companion", "plugin-finder_release"})
public final class a {
    public static final String uFx = uFx;
    public static final C1205a uFy = new C1205a((byte) 0);
    public final String TAG = "Finder.FinderLiveAnchorLotteryEntranceWidget";
    public final com.tencent.mm.live.c.b hOp;
    public final ViewGroup hwr;
    public final d uFw;

    public a(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar, d dVar) {
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        p.h(dVar, "basePlugin");
        AppMethodBeat.i(248019);
        this.hwr = viewGroup;
        this.hOp = bVar;
        this.uFw = dVar;
        this.hwr.setOnClickListener(new b(this));
        AppMethodBeat.o(248019);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLotteryEntranceWidget$Companion;", "", "()V", a.uFx, "", "getPORTRAIT_ACTION_GOTO_CREATE_LOTTERY", "()Ljava/lang/String;", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.live.widget.a$a  reason: collision with other inner class name */
    public static final class C1205a {
        private C1205a() {
        }

        public /* synthetic */ C1205a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(248020);
        AppMethodBeat.o(248020);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ a uFz;

        b(a aVar) {
            this.uFz = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(248015);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLotteryEntranceWidget$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.uFz.hOp.getLiveRole() == 1) {
                k kVar = k.vkd;
                k.a(s.f.CLICK_LOTTERY_ICON, "");
            }
            a.a(this.uFz);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLotteryEntranceWidget$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248015);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorLotteryEntranceWidget$showCard$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder_release"})
    public static final class c implements o.a {
        final /* synthetic */ a uFz;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(a aVar) {
            this.uFz = aVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.o.a
        public final void a(int i2, int i3, String str, avy avy) {
            AppMethodBeat.i(248016);
            p.h(avy, "resp");
            if (i2 == 0 && i3 == 0) {
                this.uFz.uFw.getLiveData().a(avy.tWe);
                this.uFz.uFw.getLiveData().d(avy);
            }
            b.C0376b.a(this.uFz.hOp, b.c.hNG);
            com.tencent.mm.live.c.b bVar = this.uFz.hOp;
            b.c cVar = b.c.hNE;
            Bundle bundle = new Bundle();
            bundle.putBoolean("PARAM_FINDER_LIVE_LOTTERY_CARD_SHOW_STATUS", false);
            bVar.statusChange(cVar, bundle);
            AppMethodBeat.o(248016);
        }
    }

    public final void djt() {
        Long l;
        Long l2;
        awe awe;
        Long l3 = null;
        AppMethodBeat.i(248017);
        String str = this.uFw.getLiveData().hwg;
        String str2 = this.TAG;
        StringBuilder append = new StringBuilder("jumpToCreateLotteryImpl root.context is activity:").append(this.hwr.getContext() instanceof Activity).append(",liveId:");
        awe awe2 = this.uFw.getLiveData().liveInfo;
        if (awe2 != null) {
            l = Long.valueOf(awe2.liveId);
        } else {
            l = null;
        }
        Log.i(str2, append.append(l.longValue()).append(",objectId:").append(this.uFw.getLiveData().hFK).append(",nonceId:").append(str).toString());
        if (this.hwr.getContext() instanceof Activity) {
            awe awe3 = this.uFw.getLiveData().liveInfo;
            if (awe3 != null) {
                l2 = Long.valueOf(awe3.liveId);
            } else {
                l2 = null;
            }
            if (l2 != null && (((awe = this.uFw.getLiveData().liveInfo) == null || awe.liveId != 0) && this.uFw.getLiveData().hFK != 0)) {
                String str3 = str;
                if (!(str3 == null || str3.length() == 0)) {
                    Context context = this.hwr.getContext();
                    if (context == null) {
                        t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                        AppMethodBeat.o(248017);
                        throw tVar;
                    }
                    Activity activity = (Activity) context;
                    com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                    Intent intent = new Intent();
                    awe awe4 = this.uFw.getLiveData().liveInfo;
                    if (awe4 != null) {
                        l3 = Long.valueOf(awe4.liveId);
                    }
                    intent.putExtra("KEY_PARAMS_LIVE_ID", l3.longValue());
                    intent.putExtra("KEY_PARAMS_OBJECT_ID", this.uFw.getLiveData().hFK);
                    intent.putExtra("KEY_PARAMS_NONCE_ID", str);
                    com.tencent.mm.plugin.finder.utils.a.d(activity, intent);
                }
            }
        }
        AppMethodBeat.o(248017);
    }

    public final void rg(int i2) {
        AppMethodBeat.i(248018);
        this.hwr.setVisibility(i2);
        AppMethodBeat.o(248018);
    }

    public static final /* synthetic */ void a(a aVar) {
        Boolean bool;
        String str;
        awi awi;
        String str2;
        AppMethodBeat.i(248021);
        i iVar = aVar.uFw.getLiveData().uEa;
        Integer valueOf = iVar != null ? Integer.valueOf(iVar.uhD) : null;
        i iVar2 = aVar.uFw.getLiveData().uEa;
        if (iVar2 != null) {
            bool = Boolean.valueOf(iVar2.uFv);
        } else {
            bool = null;
        }
        Log.i(aVar.TAG, "lotteryEntranceLogic lotteryStatus:" + valueOf + ",bubbleFinish:" + bool);
        if (p.j(bool, Boolean.FALSE) && ((valueOf != null && valueOf.intValue() == 1) || (valueOf != null && valueOf.intValue() == 2))) {
            com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
            com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
            if (finderLiveAssistant != null) {
                i iVar3 = aVar.uFw.getLiveData().uEa;
                if (iVar3 == null || (awi = iVar3.tWe) == null || (str2 = awi.id) == null) {
                    str = "";
                } else {
                    str = str2;
                }
                finderLiveAssistant.a(str, (com.tencent.mm.bw.b) null, new c(aVar));
                AppMethodBeat.o(248021);
                return;
            }
            AppMethodBeat.o(248021);
        } else if (aVar.uFw.isLandscape()) {
            d.a(aVar.uFw, uFx);
            AppMethodBeat.o(248021);
        } else {
            aVar.djt();
            AppMethodBeat.o(248021);
        }
    }
}
