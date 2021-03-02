package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.e;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.vlog.model.local.a;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/TemplateModeContainer;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "templateAdapter", "Lcom/tencent/mm/plugin/vlog/ui/plugin/TemplateModeContainer$TemplateListAdapter;", "templateList", "Landroid/support/v7/widget/RecyclerView;", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "currentSelectedTemplate", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "enable", "", "setVisibility", "", "visibility", "", "TemplateListAdapter", "plugin-vlog_release"})
public final class ab implements t {
    private final RecyclerView GIq;
    public final a GIr;
    private ViewGroup parent;
    private final View view = this.parent.findViewById(R.id.ij2);
    d wgr;

    public ab(ViewGroup viewGroup, d dVar) {
        p.h(viewGroup, "parent");
        p.h(dVar, "status");
        AppMethodBeat.i(191468);
        this.parent = viewGroup;
        this.wgr = dVar;
        View findViewById = this.parent.findViewById(R.id.ij1);
        p.g(findViewById, "parent.findViewById(R.id.template_list)");
        this.GIq = (RecyclerView) findViewById;
        this.GIr = new a();
        this.parent.getContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        linearLayoutManager.setOrientation(0);
        linearLayoutManager.setItemPrefetchEnabled(true);
        this.GIq.setLayoutManager(linearLayoutManager);
        this.GIq.setItemAnimator(new v());
        this.GIq.setHasFixedSize(true);
        a aVar = this.GIr;
        com.tencent.mm.plugin.vlog.model.local.a aVar2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
        LinkedList<a.c> fBN = com.tencent.mm.plugin.vlog.model.local.a.fBN();
        p.h(fBN, "list");
        aVar.GIt.clear();
        aVar.GIt.addAll(fBN);
        aVar.notifyDataSetChanged();
        this.GIq.setAdapter(this.GIr);
        this.GIr.wpI = new b<Integer, x>(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.ab.AnonymousClass1 */
            final /* synthetic */ ab GIs;

            {
                this.GIs = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Integer num) {
                AppMethodBeat.i(191459);
                int intValue = num.intValue();
                Bundle bundle = new Bundle();
                bundle.putInt("PARAM_1_INT", intValue);
                this.GIs.wgr.a(d.c.BWT, bundle);
                x xVar = x.SXb;
                AppMethodBeat.o(191459);
                return xVar;
            }
        };
        a aVar3 = this.GIr;
        aVar3.GIu = 0;
        aVar3.notifyDataSetChanged();
        AppMethodBeat.o(191468);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void aSs() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final String name() {
        return null;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onActivityResult(int i2, int i3, Intent intent) {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final boolean onBackPress() {
        return false;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onDetach() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onPause() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(191469);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        t.a.a(strArr, iArr);
        AppMethodBeat.o(191469);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void onResume() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void release() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void reset() {
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t
    public final void setVisibility(int i2) {
        AppMethodBeat.i(191467);
        View view2 = this.view;
        p.g(view2, "view");
        view2.setVisibility(i2);
        AppMethodBeat.o(191467);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001!B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0012\u001a\u00020\u0010J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\u0012\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\u000e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0006J\u0014\u0010\u001e\u001a\u00020\t2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100 R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/TemplateModeContainer$TemplateListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/TemplateModeContainer$TemplateListAdapter$TemplateListViewHolder;", "Landroid/view/View$OnClickListener;", "()V", "currentSelectedPos", "", "onItemSelected", "Lkotlin/Function1;", "", "getOnItemSelected", "()Lkotlin/jvm/functions/Function1;", "setOnItemSelected", "(Lkotlin/jvm/functions/Function1;)V", "templateList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "Lkotlin/collections/ArrayList;", "currentSelectedTemplate", "getItemCount", "onBindViewHolder", "holder", FirebaseAnalytics.b.INDEX, "onClick", "v", "Landroid/view/View;", "onCreateViewHolder", "view", "Landroid/view/ViewGroup;", "setSelected", "setTemplates", "list", "", "TemplateListViewHolder", "plugin-vlog_release"})
    public static final class a extends RecyclerView.a<C1860a> implements View.OnClickListener {
        final ArrayList<a.c> GIt = new ArrayList<>();
        int GIu;
        b<? super Integer, x> wpI;

        public a() {
            AppMethodBeat.i(191466);
            AppMethodBeat.o(191466);
        }

        /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ C1860a a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(191461);
            p.h(viewGroup, "view");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c20, viewGroup, false);
            inflate.setOnClickListener(this);
            p.g(inflate, "itemView");
            C1860a aVar = new C1860a(inflate);
            AppMethodBeat.o(191461);
            return aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ void a(C1860a aVar, int i2) {
            boolean z;
            AppMethodBeat.i(191463);
            C1860a aVar2 = aVar;
            p.h(aVar2, "holder");
            e eVar = e.hXU;
            e.aJs().He(this.GIt.get(i2).icon).c(aVar2.puw);
            aVar2.gxs.setText(this.GIt.get(i2).name);
            if (this.GIu == i2) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                View view = aVar2.GIv;
                p.g(view, "selectMask");
                view.setVisibility(0);
            } else {
                View view2 = aVar2.GIv;
                p.g(view2, "selectMask");
                view2.setVisibility(4);
            }
            View view3 = aVar2.aus;
            p.g(view3, "holder.itemView");
            view3.setTag(Integer.valueOf(i2));
            AppMethodBeat.o(191463);
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            AppMethodBeat.i(191462);
            int size = this.GIt.size();
            AppMethodBeat.o(191462);
            return size;
        }

        public final a.c fDN() {
            AppMethodBeat.i(191464);
            a.c cVar = this.GIt.get(this.GIu);
            p.g(cVar, "templateList[currentSelectedPos]");
            a.c cVar2 = cVar;
            AppMethodBeat.o(191464);
            return cVar2;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\n \u000e*\u0004\u0018\u00010\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/TemplateModeContainer$TemplateListAdapter$TemplateListViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "coverIv", "Landroid/widget/ImageView;", "getCoverIv", "()Landroid/widget/ImageView;", "nameTv", "Landroid/widget/TextView;", "getNameTv", "()Landroid/widget/TextView;", "selectMask", "kotlin.jvm.PlatformType", "getSelectMask", "()Landroid/view/View;", "setSelected", "", "select", "", "plugin-vlog_release"})
        /* renamed from: com.tencent.mm.plugin.vlog.ui.plugin.ab$a$a  reason: collision with other inner class name */
        public static final class C1860a extends RecyclerView.v {
            final View GIv;
            final TextView gxs;
            final ImageView puw;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C1860a(View view) {
                super(view);
                p.h(view, "itemView");
                AppMethodBeat.i(191460);
                View findViewById = view.findViewById(R.id.ij3);
                p.g(findViewById, "itemView.findViewById(R.id.template_name)");
                this.gxs = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.ij0);
                p.g(findViewById2, "itemView.findViewById(R.id.template_cover)");
                this.puw = (ImageView) findViewById2;
                this.GIv = view.findViewById(R.id.hj0);
                AppMethodBeat.o(191460);
            }
        }

        public final void onClick(View view) {
            AppMethodBeat.i(191465);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/TemplateModeContainer$TemplateListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Integer num = (Integer) (view != null ? view.getTag() : null);
            int intValue = num != null ? num.intValue() : -1;
            if (intValue >= 0) {
                this.GIu = intValue;
                notifyDataSetChanged();
                b<? super Integer, x> bVar2 = this.wpI;
                if (bVar2 != null) {
                    bVar2.invoke(Integer.valueOf(intValue));
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/TemplateModeContainer$TemplateListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(191465);
        }
    }
}
