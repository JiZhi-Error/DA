package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.finder.live.h;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.widget.l;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.det;
import com.tencent.mm.protocal.protobuf.ffq;
import com.tencent.mm.protocal.protobuf.fhd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.neattextview.textview.view.NeatTextView;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0001 B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J$\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0002J\b\u0010\u0018\u001a\u00020\rH\u0002J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "entranceRoot", "Landroid/view/ViewGroup;", "shoppingWidgetRoot", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "shoppingWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingWidget;", "adjustBubbleLayout", "", "canClearScreen", "", "onPortraitDelayAction", "extraMsg", "Landroid/os/Bundle;", "extraData", "", "delayMs", "", "onShoppingBubbleClick", "onShoppingBubbleClickImpl", "setVisible", "visible", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Companion", "plugin-finder_release"})
public final class bd extends d {
    private static final String utD = utD;
    public static final a utE = new a((byte) 0);
    private final String TAG = "Finder.LiveShoppingBubblePlugin";
    private final com.tencent.mm.live.c.b hOp;
    public final com.tencent.mm.plugin.finder.live.widget.l utB;
    private final ViewGroup utC;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "gotoHalfScreen", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "invoke"})
    public static final class c extends q implements m<Boolean, g, x> {
        final /* synthetic */ bo UMY;
        final /* synthetic */ bd utF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(bd bdVar, bo boVar) {
            super(2);
            this.utF = bdVar;
            this.UMY = boVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, g gVar) {
            String str;
            AppMethodBeat.i(246973);
            boolean booleanValue = bool.booleanValue();
            g gVar2 = gVar;
            if (gVar2 != null) {
                com.tencent.mm.plugin.finder.live.g gVar3 = com.tencent.mm.plugin.finder.live.g.ufT;
                com.tencent.mm.plugin.finder.live.g.c(gVar2);
                if (booleanValue) {
                    o oVar = o.ujN;
                    s finderLiveAssistant = o.getFinderLiveAssistant();
                    if (finderLiveAssistant != null) {
                        Context context = this.utF.hwr.getContext();
                        p.g(context, "root.context");
                        finderLiveAssistant.c(context, gVar2);
                    }
                } else if (!booleanValue) {
                    o oVar2 = o.ujN;
                    s finderLiveAssistant2 = o.getFinderLiveAssistant();
                    if (finderLiveAssistant2 != null) {
                        Context context2 = this.utF.hwr.getContext();
                        p.g(context2, "root.context");
                        s.a.a(finderLiveAssistant2, context2, gVar2);
                    }
                }
                o oVar3 = o.ujN;
                s finderLiveAssistant3 = o.getFinderLiveAssistant();
                if (finderLiveAssistant3 != null) {
                    finderLiveAssistant3.EH(((com.tencent.mm.plugin.finder.live.view.a.c) this.UMY).uko);
                }
            }
            if (this.utF.hOp.getLiveRole() == 0) {
                com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
                s.au auVar = s.au.CommerceActionBubbleTipClick;
                if (gVar2 != null) {
                    str = gVar2.dCw;
                } else {
                    str = null;
                }
                com.tencent.mm.plugin.finder.report.live.m.a(mVar, auVar, str, String.valueOf(((com.tencent.mm.plugin.finder.live.view.a.c) this.UMY).uko));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246973);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bd(ViewGroup viewGroup, ViewGroup viewGroup2, com.tencent.mm.live.c.b bVar) {
        super(viewGroup2, bVar);
        p.h(viewGroup, "entranceRoot");
        p.h(viewGroup2, "shoppingWidgetRoot");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(246978);
        this.utC = viewGroup2;
        this.hOp = bVar;
        Context context = viewGroup.getContext();
        p.g(context, "entranceRoot.context");
        this.utB = new com.tencent.mm.plugin.finder.live.widget.l(context, viewGroup, this.utC, this.hOp);
        this.utB.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.bd.AnonymousClass1 */
            final /* synthetic */ bd utF;

            {
                this.utF = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(246970);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                bd.d(this.utF);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(246970);
            }
        });
        AppMethodBeat.o(246978);
    }

    public static final /* synthetic */ void b(bd bdVar) {
        AppMethodBeat.i(246980);
        bdVar.dhL();
        AppMethodBeat.o(246980);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingBubblePlugin$Companion;", "", "()V", bd.utD, "", "getPORTRAIT_ACTION_BUBBLE_CLICK", "()Ljava/lang/String;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(246979);
        AppMethodBeat.o(246979);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    private final void dhL() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = null;
        AppMethodBeat.i(246974);
        bo boVar = getLiveData().UPW;
        if (boVar instanceof com.tencent.mm.plugin.finder.live.view.a.c) {
            b.a aVar = com.tencent.mm.live.core.core.d.b.hCo;
            if (b.a.aDp()) {
                String str6 = this.TAG;
                StringBuilder append = new StringBuilder("shopping bubble click, productId:").append(((com.tencent.mm.plugin.finder.live.view.a.c) boVar).uko).append(",buy appId:");
                det det = ((com.tencent.mm.plugin.finder.live.view.a.c) boVar).LHN;
                StringBuilder append2 = append.append(det != null ? det.appId : null).append(',').append("buy path:");
                det det2 = ((com.tencent.mm.plugin.finder.live.view.a.c) boVar).LHN;
                if (det2 != null) {
                    str3 = det2.path;
                } else {
                    str3 = null;
                }
                StringBuilder append3 = append2.append(str3).append(",detail appId:");
                det det3 = ((com.tencent.mm.plugin.finder.live.view.a.c) boVar).LHI;
                if (det3 != null) {
                    str4 = det3.appId;
                } else {
                    str4 = null;
                }
                StringBuilder append4 = append3.append(str4).append(" detail path:");
                det det4 = ((com.tencent.mm.plugin.finder.live.view.a.c) boVar).LHI;
                if (det4 != null) {
                    str5 = det4.path;
                }
                Log.i(str6, append4.append(str5).toString());
                com.tencent.mm.plugin.finder.live.g gVar = com.tencent.mm.plugin.finder.live.g.ufT;
                com.tencent.mm.plugin.finder.live.g.c(getLiveData(), ((com.tencent.mm.plugin.finder.live.view.a.c) boVar).UPJ, new c(this, boVar));
                AppMethodBeat.o(246974);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putLong("PARAM_FINDER_LIVE_BUBBLE_PRODUCTID", ((com.tencent.mm.plugin.finder.live.view.a.c) boVar).uko);
            this.hOp.statusChange(b.c.hMZ, bundle);
            AppMethodBeat.o(246974);
            return;
        }
        if (boVar instanceof com.tencent.mm.plugin.finder.live.view.a.b) {
            b.a aVar2 = com.tencent.mm.live.core.core.d.b.hCo;
            if (!b.a.aDp()) {
                Bundle bundle2 = new Bundle();
                bundle2.putLong("PARAM_FINDER_LIVE_BUBBLE_ADID", ((com.tencent.mm.plugin.finder.live.view.a.b) boVar).UPE);
                this.hOp.statusChange(b.c.hMZ, bundle2);
                AppMethodBeat.o(246974);
                return;
            }
            ffq ffq = ((com.tencent.mm.plugin.finder.live.view.a.b) boVar).UPF;
            if (ffq != null) {
                com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                Context context = this.umb.getContext();
                p.g(context, "vg.context");
                String str7 = ffq.LYB;
                if (str7 == null) {
                    str = "";
                } else {
                    str = str7;
                }
                String str8 = ((com.tencent.mm.plugin.finder.live.view.a.b) boVar).gTk;
                if (str8 == null) {
                    str8 = "";
                }
                com.tencent.mm.plugin.finder.utils.m.ad(context, str, str8);
                if (this.hOp.getLiveRole() == 0) {
                    com.tencent.mm.plugin.finder.report.live.m mVar2 = com.tencent.mm.plugin.finder.report.live.m.vli;
                    s.au auVar = s.au.CommerceActionBubbleTipClick;
                    String valueOf = String.valueOf(((com.tencent.mm.plugin.finder.live.view.a.b) boVar).UPE);
                    ffq ffq2 = ((com.tencent.mm.plugin.finder.live.view.a.b) boVar).UPF;
                    if (ffq2 == null || (str2 = ffq2.LYB) == null) {
                        str2 = "";
                    }
                    String valueOf2 = String.valueOf(((com.tencent.mm.plugin.finder.live.view.a.b) boVar).UPE);
                    String str9 = ((com.tencent.mm.plugin.finder.live.view.a.b) boVar).gTk;
                    if (str9 == null) {
                        str9 = "";
                    }
                    mVar2.a(auVar, null, valueOf, str2, valueOf2, str9);
                }
                AppMethodBeat.o(246974);
                return;
            }
        }
        AppMethodBeat.o(246974);
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        bo boVar;
        String str;
        String str2;
        AppMethodBeat.i(246975);
        p.h(cVar, "status");
        switch (be.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                com.tencent.mm.plugin.finder.live.widget.l lVar = this.utB;
                com.tencent.mm.plugin.finder.live.viewmodel.g liveData = getLiveData();
                if (liveData != null) {
                    boVar = liveData.UPW;
                } else {
                    boVar = null;
                }
                if (boVar != null) {
                    lVar.liveData = liveData;
                    bo boVar2 = liveData.UPW;
                    if (!(boVar2 instanceof com.tencent.mm.plugin.finder.live.view.a.c)) {
                        if (boVar2 instanceof com.tencent.mm.plugin.finder.live.view.a.b) {
                            Log.i(lVar.TAG, "update shopping bubble," + ((com.tencent.mm.plugin.finder.live.view.a.b) boVar2).UPE + ", productId:" + ((com.tencent.mm.plugin.finder.live.view.a.b) boVar2).title + ", promoting:" + ((com.tencent.mm.plugin.finder.live.view.a.b) boVar2).LHK);
                            if (((com.tencent.mm.plugin.finder.live.view.a.b) boVar2).LHK != 1) {
                                if (lVar.hOp.getLiveRole() == 0) {
                                    com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
                                    s.au auVar = s.au.CommerceActionAnchorCloseBubble;
                                    String valueOf = String.valueOf(((com.tencent.mm.plugin.finder.live.view.a.b) boVar2).UPE);
                                    ffq ffq = ((com.tencent.mm.plugin.finder.live.view.a.b) boVar2).UPF;
                                    if (ffq == null || (str = ffq.LYB) == null) {
                                        str = "";
                                    }
                                    String valueOf2 = String.valueOf(((com.tencent.mm.plugin.finder.live.view.a.b) boVar2).UPE);
                                    String str3 = ((com.tencent.mm.plugin.finder.live.view.a.b) boVar2).gTk;
                                    if (str3 == null) {
                                        str3 = "";
                                    }
                                    mVar.a(auVar, null, valueOf, str, valueOf2, str3);
                                }
                                lVar.djM();
                                break;
                            } else {
                                fhd fhd = ((com.tencent.mm.plugin.finder.live.view.a.b) boVar2).UPI;
                                if (fhd.UPE == 0 || Util.isNullOrNil(fhd.KRv)) {
                                    Log.i(lVar.TAG, "showShoppingBubble ad_id:" + fhd.UPE + ", imgUrl:" + fhd.KRv);
                                } else {
                                    lVar.uBN.setVisibility(8);
                                    View view = lVar.USk;
                                    if (view != null) {
                                        view.setVisibility(0);
                                    }
                                    TextView textView = lVar.USm;
                                    if (textView != null) {
                                        textView.setOnClickListener(null);
                                    }
                                    com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                                    d<com.tencent.mm.plugin.finder.loader.o> dkb = com.tencent.mm.plugin.finder.loader.m.dkb();
                                    com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(fhd.KRv);
                                    ImageView imageView = lVar.uBJ;
                                    com.tencent.mm.plugin.finder.loader.m mVar3 = com.tencent.mm.plugin.finder.loader.m.uJa;
                                    dkb.a(aVar, imageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.LIVE_SHOPPING_DEFAULT));
                                    if (fhd.LHK == 1) {
                                        lVar.uHj.setVisibility(0);
                                        lVar.uHk.setVisibility(0);
                                    } else {
                                        lVar.uHj.setVisibility(8);
                                        lVar.uHk.setVisibility(8);
                                    }
                                    com.tencent.mm.plugin.finder.utils.m mVar4 = com.tencent.mm.plugin.finder.utils.m.vVH;
                                    if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
                                        lVar.uhh.setVisibility(8);
                                        lVar.uHl.aw("");
                                        lVar.uBN.setText("");
                                        lVar.uHm.setVisibility(8);
                                    } else {
                                        lVar.uhh.setVisibility(0);
                                        NeatTextView neatTextView = lVar.uHl;
                                        String str4 = fhd.UPH;
                                        if (str4 == null) {
                                            str4 = "";
                                        }
                                        String str5 = fhd.title;
                                        if (str5 == null) {
                                            str5 = "";
                                        }
                                        com.tencent.mm.plugin.finder.live.widget.l.a(neatTextView, str4, str5);
                                        TextView textView2 = lVar.USl;
                                        if (textView2 != null) {
                                            String str6 = fhd.desc;
                                            textView2.setText(str6 != null ? str6 : "");
                                        }
                                        TextView textView3 = lVar.USm;
                                        if (textView3 != null) {
                                            String str7 = fhd.UPG;
                                            textView3.setText(str7 != null ? str7 : "");
                                        }
                                        TextView textView4 = lVar.USm;
                                        if (textView4 != null) {
                                            textView4.setOnClickListener(new l.c(lVar, fhd));
                                        }
                                        lVar.uHm.setVisibility(0);
                                    }
                                    lVar.nE(true);
                                    h.ufY.a(lVar.liveData);
                                    lVar.hUs();
                                    lVar.hUt();
                                }
                                if (lVar.hOp.getLiveRole() == 0) {
                                    com.tencent.mm.plugin.finder.report.live.m mVar5 = com.tencent.mm.plugin.finder.report.live.m.vli;
                                    s.au auVar2 = s.au.CommerceActionBubbleTipShow;
                                    String valueOf3 = String.valueOf(((com.tencent.mm.plugin.finder.live.view.a.b) boVar2).UPE);
                                    ffq ffq2 = ((com.tencent.mm.plugin.finder.live.view.a.b) boVar2).UPF;
                                    if (ffq2 == null || (str2 = ffq2.LYB) == null) {
                                        str2 = "";
                                    }
                                    String valueOf4 = String.valueOf(((com.tencent.mm.plugin.finder.live.view.a.b) boVar2).UPE);
                                    String str8 = ((com.tencent.mm.plugin.finder.live.view.a.b) boVar2).gTk;
                                    if (str8 == null) {
                                        str8 = "";
                                    }
                                    mVar5.a(auVar2, null, valueOf3, str2, valueOf4, str8);
                                    AppMethodBeat.o(246975);
                                    return;
                                }
                            }
                        }
                    } else {
                        Log.i(lVar.TAG, "update shopping bubble,platformName:" + ((com.tencent.mm.plugin.finder.live.view.a.c) boVar2).LHM + ", productId:" + ((com.tencent.mm.plugin.finder.live.view.a.c) boVar2).uko + ", currentId:" + ((com.tencent.mm.plugin.finder.live.view.a.c) boVar2).uko + ", promoting:" + ((com.tencent.mm.plugin.finder.live.view.a.c) boVar2).LHK + ",platformId:" + ((com.tencent.mm.plugin.finder.live.view.a.c) boVar2).LHO + '!');
                        if (((com.tencent.mm.plugin.finder.live.view.a.c) boVar2).LHK == 1) {
                            axg axg = ((com.tencent.mm.plugin.finder.live.view.a.c) boVar2).UPJ;
                            if (axg.uko != 0 && !Util.isNullOrNil(axg.twt)) {
                                lVar.uBN.setVisibility(0);
                                View view2 = lVar.USk;
                                if (view2 != null) {
                                    view2.setVisibility(8);
                                }
                                com.tencent.mm.plugin.finder.loader.m mVar6 = com.tencent.mm.plugin.finder.loader.m.uJa;
                                d<com.tencent.mm.plugin.finder.loader.o> dkb2 = com.tencent.mm.plugin.finder.loader.m.dkb();
                                com.tencent.mm.plugin.finder.loader.a aVar2 = new com.tencent.mm.plugin.finder.loader.a(axg.twt);
                                ImageView imageView2 = lVar.uBJ;
                                com.tencent.mm.plugin.finder.loader.m mVar7 = com.tencent.mm.plugin.finder.loader.m.uJa;
                                dkb2.a(aVar2, imageView2, com.tencent.mm.plugin.finder.loader.m.a(m.a.LIVE_SHOPPING_DEFAULT));
                                if (axg.LHK == 1) {
                                    lVar.uHj.setVisibility(0);
                                    lVar.uHk.setVisibility(0);
                                } else {
                                    lVar.uHj.setVisibility(8);
                                    lVar.uHk.setVisibility(8);
                                }
                                com.tencent.mm.plugin.finder.utils.m mVar8 = com.tencent.mm.plugin.finder.utils.m.vVH;
                                if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
                                    lVar.uhh.setVisibility(8);
                                    lVar.uHl.aw("");
                                    lVar.uBN.setText("");
                                    lVar.uHm.setVisibility(8);
                                } else {
                                    lVar.uhh.setVisibility(0);
                                    NeatTextView neatTextView2 = lVar.uHl;
                                    String str9 = axg.LHM;
                                    if (str9 == null) {
                                        str9 = "";
                                    }
                                    String str10 = axg.title;
                                    if (str10 == null) {
                                        str10 = "";
                                    }
                                    com.tencent.mm.plugin.finder.live.widget.l.a(neatTextView2, str9, str10);
                                    if (axg.AZr < 0 || axg.AZq < axg.AZr) {
                                        Log.i(lVar.TAG, "invalid price,min:" + axg.AZr + ",max:" + axg.AZq);
                                    } else {
                                        TextView textView5 = lVar.uBN;
                                        y yVar = y.vXH;
                                        textView5.setText(y.LS(axg.AZr));
                                    }
                                    lVar.uHm.setVisibility(0);
                                }
                                lVar.nE(true);
                                h.ufY.a(lVar.liveData);
                                lVar.hUs();
                                lVar.hUt();
                            }
                            if (lVar.hOp.getLiveRole() == 0) {
                                com.tencent.mm.plugin.finder.report.live.m.a(com.tencent.mm.plugin.finder.report.live.m.vli, s.au.CommerceActionBubbleTipShow, (String) null, String.valueOf(((com.tencent.mm.plugin.finder.live.view.a.c) boVar2).uko));
                                AppMethodBeat.o(246975);
                                return;
                            }
                        } else {
                            lVar.djM();
                            if (lVar.hOp.getLiveRole() == 0) {
                                com.tencent.mm.plugin.finder.report.live.m.a(com.tencent.mm.plugin.finder.report.live.m.vli, s.au.CommerceActionAnchorCloseBubble, (String) null, String.valueOf(((com.tencent.mm.plugin.finder.live.view.a.c) boVar2).uko));
                            }
                            AppMethodBeat.o(246975);
                            return;
                        }
                    }
                }
                break;
        }
        AppMethodBeat.o(246975);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void rg(int i2) {
        AppMethodBeat.i(246976);
        if (getLiveData().isLiveStarted() || i2 != 0) {
            super.rg(i2);
            AppMethodBeat.o(246976);
            return;
        }
        o oVar = o.ujN;
        com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = o.getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            finderLiveAssistant.ag(this.utC, i2);
            AppMethodBeat.o(246976);
            return;
        }
        AppMethodBeat.o(246976);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final void a(Bundle bundle, Object obj, long j2) {
        String str;
        AppMethodBeat.i(260719);
        if (bundle == null || (str = bundle.getString("ACTION_POST_PORTRAIT", "")) == null) {
            str = "";
        }
        if (p.j(str, utD)) {
            com.tencent.mm.ac.d.a(j2, new b(this, j2));
        }
        AppMethodBeat.o(260719);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ bd utF;
        final /* synthetic */ long utG;

        b(bd bdVar, long j2) {
            this.utF = bdVar;
            this.utG = j2;
        }

        public final void run() {
            AppMethodBeat.i(246972);
            if (!this.utF.isFinished()) {
                bd.b(this.utF);
                AppMethodBeat.o(246972);
                return;
            }
            Log.i(this.utF.TAG, "onShoppingBubbleClickImpl delayMs:" + this.utG + ",isFinished!");
            AppMethodBeat.o(246972);
        }
    }

    public static final /* synthetic */ void d(bd bdVar) {
        AppMethodBeat.i(246981);
        boolean isLandscape = bdVar.isLandscape();
        Log.i(bdVar.TAG, "onShoppingBubbleClick isLandscape:".concat(String.valueOf(isLandscape)));
        if (isLandscape) {
            d.a(bdVar, utD, null, 0, 6);
            AppMethodBeat.o(246981);
            return;
        }
        bdVar.dhL();
        AppMethodBeat.o(246981);
    }
}
