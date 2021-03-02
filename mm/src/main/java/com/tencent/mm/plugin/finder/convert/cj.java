package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.ag;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderStreamCardVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHomeUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0016J2\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J@\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&H\u0016J \u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020*2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/feed/FinderStreamCardFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)V", "streamCardVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "getStreamCardVM", "()Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "streamCardVM$delegate", "Lkotlin/Lazy;", "getTabType", "()I", "bindData", "", "cardView", "Landroid/view/View;", ch.COL_FINDEROBJECT, "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "buildFinderImage", "Lcom/tencent/mm/plugin/finder/loader/FinderImageLoadData;", "getLayoutId", "jump2HotTab", "context", "Lcom/tencent/mm/ui/MMActivity;", "item", NativeProtocol.WEB_DIALOG_ACTION, "position", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class cj extends com.tencent.mm.view.recyclerview.e<ag> {
    public static final a tHc = new a((byte) 0);
    private final int dLS;
    private final kotlin.f tGQ = kotlin.g.ah(i.tHf);
    private final bbn ttO;

    static {
        AppMethodBeat.i(243368);
        AppMethodBeat.o(243368);
    }

    private final FinderStreamCardVM cZQ() {
        AppMethodBeat.i(243362);
        FinderStreamCardVM finderStreamCardVM = (FinderStreamCardVM) this.tGQ.getValue();
        AppMethodBeat.o(243362);
        return finderStreamCardVM;
    }

    public cj(bbn bbn, int i2) {
        AppMethodBeat.i(243367);
        this.ttO = bbn;
        this.dLS = i2;
        AppMethodBeat.o(243367);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, ag agVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(243364);
        ag agVar2 = agVar;
        p.h(hVar, "holder");
        p.h(agVar2, "item");
        hVar.aus.setOnClickListener(new c(this, agVar2, i2));
        View view = hVar.aus;
        p.g(view, "holder.itemView");
        view.findViewById(R.id.aji).setOnClickListener(new d(this, hVar, agVar2, i2));
        View view2 = hVar.aus;
        p.g(view2, "holder.itemView");
        view2.findViewById(R.id.ajj).setOnClickListener(new e(this, hVar, agVar2, i2));
        View view3 = hVar.aus;
        p.g(view3, "holder.itemView");
        view3.findViewById(R.id.ajk).setOnClickListener(new f(this, hVar, agVar2, i2));
        View view4 = hVar.aus;
        p.g(view4, "holder.itemView");
        ((LinearLayout) view4.findViewById(R.id.ec9)).setOnClickListener(new g(this, agVar2, i2));
        FinderStreamCardVM cZQ = cZQ();
        p.h(agVar2, "item");
        cZQ.wuE.put(FinderStreamCardVM.a.b(agVar2), Integer.valueOf(i2));
        View view5 = hVar.aus;
        p.g(view5, "holder.itemView");
        TextView textView = (TextView) view5.findViewById(R.id.ipm);
        p.g(textView, "holder.itemView.title");
        textView.setText(agVar2.tQQ.IFO);
        View view6 = hVar.aus;
        p.g(view6, "holder.itemView");
        TextView textView2 = (TextView) view6.findViewById(R.id.ec8);
        p.g(textView2, "holder.itemView.linkTitle");
        textView2.setText(agVar2.tQQ.LLO);
        LinkedList<FinderObject> linkedList = agVar2.tQQ.object;
        p.g(linkedList, "item.card.`object`");
        int i4 = 0;
        for (T t : linkedList) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                j.hxH();
            }
            T t2 = t;
            switch (i4) {
                case 0:
                    View view7 = hVar.aus;
                    p.g(view7, "holder.itemView");
                    View findViewById = view7.findViewById(R.id.aji);
                    p.g(findViewById, "holder.itemView.card1");
                    p.g(t2, ch.COL_FINDEROBJECT);
                    a(findViewById, t2);
                    i4 = i5;
                    continue;
                case 1:
                    View view8 = hVar.aus;
                    p.g(view8, "holder.itemView");
                    View findViewById2 = view8.findViewById(R.id.ajj);
                    p.g(findViewById2, "holder.itemView.card2");
                    p.g(t2, ch.COL_FINDEROBJECT);
                    a(findViewById2, t2);
                    i4 = i5;
                    continue;
                case 2:
                    View view9 = hVar.aus;
                    p.g(view9, "holder.itemView");
                    View findViewById3 = view9.findViewById(R.id.ajk);
                    p.g(findViewById3, "holder.itemView.card3");
                    p.g(t2, ch.COL_FINDEROBJECT);
                    a(findViewById3, t2);
                    break;
            }
            i4 = i5;
        }
        AppMethodBeat.o(243364);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.a0;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.h hVar, int i2) {
        AppMethodBeat.i(243363);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        View view = hVar.aus;
        p.g(view, "holder.itemView");
        TextView textView = (TextView) view.findViewById(R.id.ipm);
        p.g(textView, "holder.itemView.title");
        ao.a(textView.getPaint(), 0.8f);
        View view2 = hVar.aus;
        p.g(view2, "holder.itemView");
        TextView textView2 = (TextView) view2.findViewById(R.id.ec8);
        p.g(textView2, "holder.itemView.linkTitle");
        ao.a(textView2.getPaint(), 0.8f);
        View view3 = hVar.aus;
        p.g(view3, "holder.itemView");
        View findViewById = view3.findViewById(R.id.aji);
        p.g(findViewById, "holder.itemView.card1");
        TextView textView3 = (TextView) findViewById.findViewById(R.id.fz6);
        p.g(textView3, "holder.itemView.card1.nickName");
        ao.a(textView3.getPaint(), 0.8f);
        View view4 = hVar.aus;
        p.g(view4, "holder.itemView");
        View findViewById2 = view4.findViewById(R.id.ajj);
        p.g(findViewById2, "holder.itemView.card2");
        TextView textView4 = (TextView) findViewById2.findViewById(R.id.fz6);
        p.g(textView4, "holder.itemView.card2.nickName");
        ao.a(textView4.getPaint(), 0.8f);
        View view5 = hVar.aus;
        p.g(view5, "holder.itemView");
        View findViewById3 = view5.findViewById(R.id.ajk);
        p.g(findViewById3, "holder.itemView.card3");
        TextView textView5 = (TextView) findViewById3.findViewById(R.id.fz6);
        p.g(textView5, "holder.itemView.card3.nickName");
        ao.a(textView5.getPaint(), 0.8f);
        View view6 = hVar.aus;
        p.g(view6, "holder.itemView");
        View findViewById4 = view6.findViewById(R.id.aji);
        p.g(findViewById4, "holder.itemView.card1");
        Context context = hVar.getContext();
        Context context2 = hVar.getContext();
        p.g(context2, "holder.context");
        ((WeImageView) findViewById4.findViewById(R.id.ebf)).setImageDrawable(ar.m(context, R.raw.icon_filled_awesome, context2.getResources().getColor(R.color.am)));
        View view7 = hVar.aus;
        p.g(view7, "holder.itemView");
        View findViewById5 = view7.findViewById(R.id.ajj);
        p.g(findViewById5, "holder.itemView.card2");
        Context context3 = hVar.getContext();
        Context context4 = hVar.getContext();
        p.g(context4, "holder.context");
        ((WeImageView) findViewById5.findViewById(R.id.ebf)).setImageDrawable(ar.m(context3, R.raw.icon_filled_awesome, context4.getResources().getColor(R.color.am)));
        View view8 = hVar.aus;
        p.g(view8, "holder.itemView");
        View findViewById6 = view8.findViewById(R.id.ajk);
        p.g(findViewById6, "holder.itemView.card3");
        Context context5 = hVar.getContext();
        Context context6 = hVar.getContext();
        p.g(context6, "holder.context");
        ((WeImageView) findViewById6.findViewById(R.id.ebf)).setImageDrawable(ar.m(context5, R.raw.icon_filled_awesome, context6.getResources().getColor(R.color.am)));
        View view9 = hVar.aus;
        p.g(view9, "holder.itemView");
        com.tencent.mm.view.f.a(view9, new h(this, hVar));
        AppMethodBeat.o(243363);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onCreateViewHolder$1", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "onViewExposed", "", "view", "Landroid/view/View;", "oldExposedId", "", "newExposedId", "isExposed", "", "plugin-finder_release"})
    public static final class h extends e.b {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ cj tHe;

        h(cj cjVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.tHe = cjVar;
            this.qhp = hVar;
        }

        @Override // com.tencent.mm.view.e.b
        public final void p(View view, boolean z) {
            int i2;
            AppMethodBeat.i(243359);
            p.h(view, "view");
            if (!z) {
                AppMethodBeat.o(243359);
                return;
            }
            String str = "";
            try {
                ag agVar = (ag) this.qhp.hgv();
                if (agVar != null) {
                    List<FinderObject> subList = agVar.tQQ.object.subList(0, Math.min(3, agVar.tQQ.object.size()));
                    p.g(subList, "it.card.`object`.subList…, it.card.`object`.size))");
                    Iterator<T> it = subList.iterator();
                    while (it.hasNext()) {
                        str = str + com.tencent.mm.ac.d.zs(it.next().id) + '|';
                    }
                    bbn bbn = this.tHe.ttO;
                    if (bbn != null) {
                        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                        p.h(agVar, "item");
                        Integer num = ((FinderStreamCardVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamCardVM.class)).wuE.get(FinderStreamCardVM.a.b(agVar));
                        if (num != null) {
                            i2 = num.intValue();
                        } else {
                            i2 = -1;
                        }
                        k kVar = k.vfA;
                        k.a(str, i2, bbn);
                        AppMethodBeat.o(243359);
                        return;
                    }
                    AppMethodBeat.o(243359);
                    return;
                }
                AppMethodBeat.o(243359);
            } catch (Exception e2) {
                Log.printErrStackTrace("Finder.StreamCardFeedConvert", e2, "", new Object[0]);
                AppMethodBeat.o(243359);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ ag tGw;
        final /* synthetic */ cj tHe;

        c(cj cjVar, ag agVar, int i2) {
            this.tHe = cjVar;
            this.tGw = agVar;
            this.gUj = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243354);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            cj cjVar = this.tHe;
            p.g(view, LocaleUtil.ITALIAN);
            Context context = view.getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(243354);
                throw tVar;
            }
            cj.a(cjVar, (MMActivity) context, (FinderObject) null, this.tGw, 4, this.gUj);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243354);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ ag tGw;
        final /* synthetic */ cj tHe;

        d(cj cjVar, com.tencent.mm.view.recyclerview.h hVar, ag agVar, int i2) {
            this.tHe = cjVar;
            this.qhp = hVar;
            this.tGw = agVar;
            this.gUj = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243355);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            cj cjVar = this.tHe;
            p.g(view, LocaleUtil.ITALIAN);
            Context context = view.getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(243355);
                throw tVar;
            }
            MMActivity mMActivity = (MMActivity) context;
            View view2 = this.qhp.aus;
            p.g(view2, "holder.itemView");
            View findViewById = view2.findViewById(R.id.aji);
            p.g(findViewById, "holder.itemView.card1");
            Object tag = findViewById.getTag();
            if (!(tag instanceof FinderObject)) {
                tag = null;
            }
            cj.a(cjVar, mMActivity, (FinderObject) tag, this.tGw, 1, this.gUj);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243355);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ ag tGw;
        final /* synthetic */ cj tHe;

        e(cj cjVar, com.tencent.mm.view.recyclerview.h hVar, ag agVar, int i2) {
            this.tHe = cjVar;
            this.qhp = hVar;
            this.tGw = agVar;
            this.gUj = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243356);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            cj cjVar = this.tHe;
            p.g(view, LocaleUtil.ITALIAN);
            Context context = view.getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(243356);
                throw tVar;
            }
            MMActivity mMActivity = (MMActivity) context;
            View view2 = this.qhp.aus;
            p.g(view2, "holder.itemView");
            View findViewById = view2.findViewById(R.id.ajj);
            p.g(findViewById, "holder.itemView.card2");
            Object tag = findViewById.getTag();
            if (!(tag instanceof FinderObject)) {
                tag = null;
            }
            cj.a(cjVar, mMActivity, (FinderObject) tag, this.tGw, 1, this.gUj);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243356);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ ag tGw;
        final /* synthetic */ cj tHe;

        f(cj cjVar, com.tencent.mm.view.recyclerview.h hVar, ag agVar, int i2) {
            this.tHe = cjVar;
            this.qhp = hVar;
            this.tGw = agVar;
            this.gUj = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243357);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            cj cjVar = this.tHe;
            p.g(view, LocaleUtil.ITALIAN);
            Context context = view.getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(243357);
                throw tVar;
            }
            MMActivity mMActivity = (MMActivity) context;
            View view2 = this.qhp.aus;
            p.g(view2, "holder.itemView");
            View findViewById = view2.findViewById(R.id.ajk);
            p.g(findViewById, "holder.itemView.card3");
            Object tag = findViewById.getTag();
            if (!(tag instanceof FinderObject)) {
                tag = null;
            }
            cj.a(cjVar, mMActivity, (FinderObject) tag, this.tGw, 1, this.gUj);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243357);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g implements View.OnClickListener {
        final /* synthetic */ int gUj;
        final /* synthetic */ ag tGw;
        final /* synthetic */ cj tHe;

        g(cj cjVar, ag agVar, int i2) {
            this.tHe = cjVar;
            this.tGw = agVar;
            this.gUj = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243358);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            cj cjVar = this.tHe;
            p.g(view, LocaleUtil.ITALIAN);
            Context context = view.getContext();
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(243358);
                throw tVar;
            }
            cj.a(cjVar, (MMActivity) context, (FinderObject) null, this.tGw, 3, this.gUj);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderStreamJumpHotCardConvert$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243358);
        }
    }

    private static void a(View view, FinderObject finderObject) {
        String str;
        String str2 = null;
        AppMethodBeat.i(243365);
        view.setTag(finderObject);
        TextView textView = (TextView) view.findViewById(R.id.eba);
        p.g(textView, "cardView.like_count_tv");
        textView.setText(finderObject.likeCount > 0 ? com.tencent.mm.plugin.finder.utils.k.gm(2, finderObject.likeCount) : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        TextView textView2 = (TextView) view.findViewById(R.id.fz6);
        p.g(textView2, "cardView.nickName");
        Context context = view.getContext();
        FinderContact finderContact = finderObject.contact;
        if (finderContact != null) {
            str = finderContact.nickname;
        } else {
            str = null;
        }
        textView2.setText(com.tencent.mm.pluginsdk.ui.span.l.c(context, str));
        m mVar = m.uJa;
        com.tencent.mm.loader.d<o> dka = m.dka();
        FinderContact finderContact2 = finderObject.contact;
        if (finderContact2 != null) {
            str2 = finderContact2.headUrl;
        }
        com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(str2);
        ImageView imageView = (ImageView) view.findViewById(R.id.wm);
        p.g(imageView, "cardView.avatar");
        m mVar2 = m.uJa;
        dka.a(aVar, imageView, m.a(m.a.AVATAR));
        m mVar3 = m.uJa;
        com.tencent.mm.loader.a.b<o, Bitmap> bQ = m.djY().bQ(f(finderObject));
        m mVar4 = m.uJa;
        com.tencent.mm.loader.b<o, Bitmap> a2 = bQ.a(m.a(m.a.TIMELINE));
        ImageView imageView2 = (ImageView) view.findViewById(R.id.bgv);
        p.g(imageView2, "cardView.cover");
        a2.c(imageView2);
        AppMethodBeat.o(243365);
    }

    private static com.tencent.mm.plugin.finder.loader.k f(FinderObject finderObject) {
        FinderMedia finderMedia;
        LinkedList<FinderMedia> linkedList;
        AppMethodBeat.i(243366);
        c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        FinderObjectDesc finderObjectDesc = finderObject.objectDesc;
        if (finderObjectDesc == null || (linkedList = finderObjectDesc.media) == null || (finderMedia = linkedList.getFirst()) == null) {
            finderMedia = new FinderMedia();
        }
        com.tencent.mm.plugin.finder.loader.k kVar = new com.tencent.mm.plugin.finder.loader.k(c.a.b(finderMedia), x.THUMB_IMAGE, null, null, 12);
        AppMethodBeat.o(243366);
        return kVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderStreamCardVM;", "invoke"})
    static final class i extends q implements kotlin.g.a.a<FinderStreamCardVM> {
        public static final i tHf = new i();

        static {
            AppMethodBeat.i(243361);
            AppMethodBeat.o(243361);
        }

        i() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FinderStreamCardVM invoke() {
            AppMethodBeat.i(243360);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            FinderStreamCardVM finderStreamCardVM = (FinderStreamCardVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderStreamCardVM.class);
            AppMethodBeat.o(243360);
            return finderStreamCardVM;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ Bundle tHd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Bundle bundle) {
            super(0);
            this.tHd = bundle;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(243353);
            this.tHd.putBoolean("RequestLoadMore", true);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(243353);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(cj cjVar, MMActivity mMActivity, FinderObject finderObject, ag agVar, int i2, int i3) {
        Long l;
        int i4;
        long j2;
        AppMethodBeat.i(243369);
        LinkedList<FinderObject> linkedList = agVar.tQQ.object;
        p.g(linkedList, "item.card.`object`");
        LinkedList<FinderObject> linkedList2 = linkedList;
        StringBuilder sb = new StringBuilder("[jump2HotTab] finderObject=");
        if (finderObject != null) {
            l = Long.valueOf(finderObject.id);
        } else {
            l = null;
        }
        StringBuilder append = sb.append(l).append(" objectList=");
        LinkedList<FinderObject> linkedList3 = linkedList2;
        ArrayList arrayList = new ArrayList(j.a(linkedList3, 10));
        Iterator<T> it = linkedList3.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(it.next().id));
        }
        Log.i("Finder.StreamCardFeedConvert", append.append(arrayList).toString());
        LinkedList<BaseFinderFeed> linkedList4 = agVar.rvFeedList;
        if (linkedList4 == null || linkedList4.isEmpty()) {
            Log.e("Finder.StreamCardFeedConvert", "rvFeedList is empty");
            AppMethodBeat.o(243369);
            return;
        }
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.b(mMActivity).get(FinderHomeUIC.class);
        p.g(viewModel, "UICProvider.of(context).…inderHomeUIC::class.java)");
        FinderHomeUIC finderHomeUIC = (FinderHomeUIC) viewModel;
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        FinderHomeTabStateVM.a Mq = ((FinderHomeTabStateVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Mq(4);
        Mq.a(FinderHomeTabStateVM.d.InCacheTime);
        Mq.wuh = System.currentTimeMillis();
        Mq.eF(new LinkedList(agVar.rvFeedList));
        Bundle bundle = new Bundle();
        FinderStreamCardVM cZQ = cjVar.cZQ();
        LinkedList<FinderObject> linkedList5 = agVar.tQQ.object;
        p.g(linkedList5, "item.card.`object`");
        FinderStreamCardVM.a aVar3 = FinderStreamCardVM.wuH;
        cZQ.a(linkedList5, FinderStreamCardVM.a.b(agVar), new b(bundle));
        bundle.putInt("RequestScene", 1);
        if (finderObject != null) {
            int i5 = 0;
            Iterator<FinderObject> it2 = linkedList2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    i4 = -1;
                    break;
                }
                if (it2.next().id == finderObject.id) {
                    i4 = i5;
                    break;
                }
                i5++;
            }
        } else {
            i4 = -1;
        }
        bundle.putInt("ScrollPosition", i4);
        switch (i2) {
            case 1:
                bundle.putInt("Source", 3);
                break;
            case 2:
            default:
                bundle.putInt("Source", 4);
                break;
            case 3:
                bundle.putInt("Source", 2);
                break;
            case 4:
                bundle.putInt("Source", 2);
                break;
        }
        String str = "";
        List<FinderObject> subList = agVar.tQQ.object.subList(0, Math.min(3, agVar.tQQ.object.size()));
        p.g(subList, "item.card.`object`.subLi…item.card.`object`.size))");
        Iterator<T> it3 = subList.iterator();
        while (it3.hasNext()) {
            str = str + com.tencent.mm.ac.d.zs(it3.next().id) + '|';
        }
        k kVar = k.vfA;
        if (finderObject != null) {
            j2 = finderObject.id;
        } else {
            j2 = 0;
        }
        com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
        k.a(i2, com.tencent.mm.ac.d.zs(j2), i4 + 1, str, i3, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(mMActivity).get(FinderReporterUIC.class)).Mz(cjVar.dLS));
        finderHomeUIC.p(4, bundle);
        AppMethodBeat.o(243369);
    }
}
