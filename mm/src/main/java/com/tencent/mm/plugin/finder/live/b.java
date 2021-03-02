package com.tencent.mm.plugin.finder.live;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.live.FinderLiveViewCallback;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout;
import com.tencent.mm.plugin.finder.live.viewmodel.c;
import com.tencent.mm.plugin.finder.live.viewmodel.d;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.utils.ad;
import com.tencent.mm.plugin.finder.utils.af;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.avq;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020#H\u0016J\u0018\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0002H\u0016J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.H\u0002R\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/FinderLiveAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveViewHolder;", "finderLiveDataModel", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;", "viewManager", "Lcom/tencent/mm/plugin/finder/live/FinderLiveViewManager;", "isFromFloat", "", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;Lcom/tencent/mm/plugin/finder/live/FinderLiveViewManager;ZLcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "datas", "getDatas", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;", "setDatas", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;)V", "itemViewList", "", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout;", "getItemViewList", "()Ljava/util/List;", "getViewManager", "()Lcom/tencent/mm/plugin/finder/live/FinderLiveViewManager;", "setViewManager", "(Lcom/tencent/mm/plugin/finder/live/FinderLiveViewManager;)V", "consumeView", "", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "getData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "pos", "", "getItemCount", "onBindViewHolder", "vh", "onCreateViewHolder", "vg", "onViewDetachedFromWindow", "holder", "produceView", "protectViewItemRecycleHealthy", "view", "Landroid/view/View;", "plugin-finder_release"})
public final class b extends RecyclerView.a<e> {
    private final bbn reportObj;
    private d ufm;
    f ufn;
    private final List<FinderLiveVisitorPluginLayout> ufo = new ArrayList();
    private final boolean ufp;

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ e a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(245788);
        e q = q(viewGroup);
        AppMethodBeat.o(245788);
        return q;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(e eVar, int i2) {
        View view;
        String str;
        awe awe;
        FinderObjectDesc finderObjectDesc;
        avq avq;
        AppMethodBeat.i(245790);
        e eVar2 = eVar;
        p.h(eVar2, "vh");
        FinderLiveViewCallback.a aVar = FinderLiveViewCallback.ufM;
        Log.i(FinderLiveViewCallback.TAG, "lxl bind view, pos: " + i2 + ", " + eVar2.hashCode());
        c IW = IW(i2);
        o oVar = o.ujN;
        g a2 = o.a(IW);
        if (IW != null) {
            af afVar = af.waa;
            StringBuilder sb = new StringBuilder();
            af afVar2 = af.waa;
            String sb2 = sb.append(af.dEm()).append(IW.uCr.getLiveId()).toString();
            ad.a aVar2 = ad.vZu;
            af.a(afVar, sb2, ad.vYJ.name, null, true, false, 20);
        }
        View view2 = eVar2.aus;
        if (view2 == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(245790);
            throw tVar;
        }
        ViewGroup viewGroup = (ViewGroup) view2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        z.f fVar = new z.f();
        synchronized (this.ufo) {
            try {
                if (this.ufo.isEmpty()) {
                    Context context = viewGroup.getContext();
                    p.g(context, "parent.context");
                    fVar.SYG = (T) new FinderLiveVisitorPluginLayout(context, null, this.reportObj);
                } else {
                    fVar.SYG = (T) this.ufo.remove(this.ufo.size() - 1);
                }
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(245790);
                throw th;
            }
        }
        fVar.SYG.setId(R.id.cz5);
        View findViewById = viewGroup.findViewById(R.id.cz5);
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        viewGroup.addView(fVar.SYG, layoutParams);
        FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout = (FinderLiveVisitorPluginLayout) eVar2.aus.findViewById(R.id.cz5);
        if (IW == null || a2 == null) {
            FinderLiveViewCallback.a aVar3 = FinderLiveViewCallback.ufM;
            Log.w(FinderLiveViewCallback.TAG, "bind view err: data is null!!!");
            AppMethodBeat.o(245790);
            return;
        }
        finderLiveVisitorPluginLayout.bindData(IW, a2, this.ufm.getInitPos() == i2);
        ImageView imageView = (ImageView) eVar2.aus.findViewById(R.id.ei4);
        if (imageView != null) {
            view = imageView;
        } else {
            view = eVar2.aus;
            p.g(view, "vh.itemView");
        }
        if (view instanceof ImageView) {
            ((ImageView) view).setImageDrawable(null);
        } else {
            view.setBackground(null);
        }
        View findViewById2 = eVar2.aus.findViewById(R.id.cr8);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new a(this, i2));
        }
        FinderObject finderObject = a2.uDz;
        if (finderObject == null || (finderObjectDesc = finderObject.objectDesc) == null || (avq = finderObjectDesc.liveDesc) == null) {
            str = null;
        } else {
            str = avq.uEu;
        }
        FinderObject finderObject2 = a2.uDz;
        if (!(finderObject2 == null || (awe = finderObject2.liveInfo) == null || awe.Vjf != 1)) {
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                if (view instanceof ImageView) {
                    ((aj) com.tencent.mm.kernel.g.ah(aj.class)).loadImage(str, (ImageView) view);
                    FinderLiveViewCallback.a aVar4 = FinderLiveViewCallback.ufM;
                    Log.i(FinderLiveViewCallback.TAG, "showThumbUrlBg username:" + a2.hwd + ", url:" + str);
                } else {
                    com.tencent.mm.plugin.finder.live.util.g gVar = com.tencent.mm.plugin.finder.live.util.g.uwd;
                    com.tencent.mm.plugin.finder.live.util.g.a(a2.hwd, str, view);
                    FinderLiveViewCallback.a aVar5 = FinderLiveViewCallback.ufM;
                    Log.i(FinderLiveViewCallback.TAG, "showThumbUrlBg2 username:" + a2.hwd + ", url:" + str);
                }
                finderLiveVisitorPluginLayout.reset(this.ufp);
                af afVar3 = af.waa;
                StringBuilder sb3 = new StringBuilder();
                af afVar4 = af.waa;
                String sb4 = sb3.append(af.dEm()).append(IW.uCr.getLiveId()).toString();
                ad.a aVar6 = ad.vZu;
                af.a(afVar3, sb4, ad.vYK.name, null, false, false, 28);
                FinderLiveViewCallback.a aVar7 = FinderLiveViewCallback.ufM;
                Log.i(FinderLiveViewCallback.TAG, "bind view " + a2.liveInfo.liveId + ", " + finderLiveVisitorPluginLayout + ", data:" + IW(i2));
                AppMethodBeat.o(245790);
            }
        }
        com.tencent.mm.plugin.finder.live.util.g gVar2 = com.tencent.mm.plugin.finder.live.util.g.uwd;
        com.tencent.mm.plugin.finder.live.util.g.a(a2.hwd, a2.uEu, view);
        finderLiveVisitorPluginLayout.reset(this.ufp);
        af afVar32 = af.waa;
        StringBuilder sb32 = new StringBuilder();
        af afVar42 = af.waa;
        String sb42 = sb32.append(af.dEm()).append(IW.uCr.getLiveId()).toString();
        ad.a aVar62 = ad.vZu;
        af.a(afVar32, sb42, ad.vYK.name, null, false, false, 28);
        FinderLiveViewCallback.a aVar72 = FinderLiveViewCallback.ufM;
        Log.i(FinderLiveViewCallback.TAG, "bind view " + a2.liveInfo.liveId + ", " + finderLiveVisitorPluginLayout + ", data:" + IW(i2));
        AppMethodBeat.o(245790);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void l(e eVar) {
        AppMethodBeat.i(245792);
        e eVar2 = eVar;
        p.h(eVar2, "holder");
        FinderLiveViewCallback.a aVar = FinderLiveViewCallback.ufM;
        Log.i(FinderLiveViewCallback.TAG, "onViewDetachedFromWindow, " + eVar2.hashCode());
        super.l(eVar2);
        View view = eVar2.aus;
        p.g(view, "holder.itemView");
        dW(view);
        AppMethodBeat.o(245792);
    }

    public b(d dVar, f fVar, boolean z, bbn bbn) {
        p.h(dVar, "finderLiveDataModel");
        p.h(fVar, "viewManager");
        AppMethodBeat.i(245794);
        this.ufp = z;
        this.reportObj = bbn;
        this.ufm = dVar;
        this.ufn = fVar;
        AppMethodBeat.o(245794);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(245789);
        int size = this.ufm.uCu.size();
        AppMethodBeat.o(245789);
        return size;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ int prP;
        final /* synthetic */ b ufq;

        a(b bVar, int i2) {
            this.ufq = bVar;
            this.prP = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(245786);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/FinderLiveAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            WxRecyclerView wxRecyclerView = this.ufq.ufn.ufR;
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.prP, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/live/FinderLiveAdapter$onBindViewHolder$2", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
            wxRecyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView, "com/tencent/mm/plugin/finder/live/FinderLiveAdapter$onBindViewHolder$2", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/FinderLiveAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(245786);
        }
    }

    public final c IW(int i2) {
        AppMethodBeat.i(245791);
        if (i2 < 0 || i2 >= getItemCount()) {
            FinderLiveViewCallback.a aVar = FinderLiveViewCallback.ufM;
            Log.i(FinderLiveViewCallback.TAG, "getData invalid pos!");
            AppMethodBeat.o(245791);
            return null;
        }
        c cVar = this.ufm.uCu.get(i2);
        AppMethodBeat.o(245791);
        return cVar;
    }

    private final void dW(View view) {
        AppMethodBeat.i(245793);
        if (view instanceof ViewGroup) {
            int childCount = ((ViewGroup) view).getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = ((ViewGroup) view).getChildAt(i2);
                if (childAt != null) {
                    childAt.animate().cancel();
                    if (childAt.hasTransientState()) {
                        Log.i("RecyclerViewAdapterEx", "[protectViewItemRecycleHealthy] child=".concat(String.valueOf(childAt)));
                    }
                    dW(childAt);
                }
            }
            view.animate().cancel();
        }
        AppMethodBeat.o(245793);
    }

    private e q(ViewGroup viewGroup) {
        AppMethodBeat.i(245787);
        p.h(viewGroup, "vg");
        Context context = viewGroup.getContext();
        p.g(context, "parent.context");
        FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout = new FinderLiveVisitorPluginLayout(context, null, this.reportObj);
        synchronized (this.ufo) {
            try {
                this.ufo.add(finderLiveVisitorPluginLayout);
            } catch (Throwable th) {
                AppMethodBeat.o(245787);
                throw th;
            }
        }
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        e eVar = new e(frameLayout);
        AppMethodBeat.o(245787);
        return eVar;
    }
}
