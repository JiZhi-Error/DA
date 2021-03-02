package com.tencent.mm.plugin.profile.ui.tab.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.m;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.plugin.profile.ui.tab.data.a;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.protocal.protobuf.ng;
import com.tencent.mm.protocal.protobuf.nh;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u0000 B2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004?@ABB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#H\u0016J\u0018\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(2\u0006\u0010%\u001a\u00020#H\u0002J\u0018\u0010)\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u00022\u0006\u0010%\u001a\u00020#H\u0016J\u0018\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020#H\u0016J\b\u0010.\u001a\u00020\u0016H\u0002J\b\u0010/\u001a\u00020\u0016H\u0002J.\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u000f2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u00105\u001a\u00020#H\u0002J \u00106\u001a\u00020\u00162\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020#H\u0002J\u0017\u0010<\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\u000f0=H\u0002¢\u0006\u0002\u0010>R#\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006C"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "dataList", "", "Lcom/tencent/mm/protocal/protobuf/BizMessage;", "(Ljava/util/List;)V", "brandService", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "kotlin.jvm.PlatformType", "getBrandService", "()Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "brandService$delegate", "Lkotlin/Lazy;", "footerWording", "", "getFooterWording", "()Ljava/lang/String;", "setFooterWording", "(Ljava/lang/String;)V", "onLoadMore", "Lkotlin/Function0;", "", "getOnLoadMore", "()Lkotlin/jvm/functions/Function0;", "setOnLoadMore", "(Lkotlin/jvm/functions/Function0;)V", "value", "", "showLoading", "getShowLoading", "()Z", "setShowLoading", "(Z)V", "getItemCount", "", "getItemViewType", "position", "onBindVideoItem", "holder", "Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter$BizProfileTabVideoVH;", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onImageLoadFinish", "onImageLoadStart", "setNeatText", "neatText", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "text", "url", "scene", "setupCoverImage", "bizAppMsgDetailInfo", "Lcom/tencent/mm/protocal/protobuf/BizAppMsgDetailInfo;", "coverImageView", "Landroid/widget/ImageView;", "coverHeightForVideo", "firstNotEmpty", "", "([Ljava/lang/String;)Ljava/lang/String;", "BizProfileTabLoadingVH", "BizProfileTabNoMoreVH", "BizProfileTabVideoVH", "Companion", "app_release"})
public final class e extends RecyclerView.a<RecyclerView.v> {
    public static final d Bnp = new d((byte) 0);
    private final kotlin.f Bkx = kotlin.g.ah(C1606e.Bnx);
    kotlin.g.a.a<x> BmU;
    private boolean Bno;
    private final List<ou> dataList;
    String footerWording = "";

    static {
        AppMethodBeat.i(230841);
        AppMethodBeat.o(230841);
    }

    private final com.tencent.mm.plugin.brandservice.a.b eFj() {
        AppMethodBeat.i(230833);
        com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) this.Bkx.getValue();
        AppMethodBeat.o(230833);
        return bVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.tencent.mm.protocal.protobuf.ou> */
    /* JADX WARN: Multi-variable type inference failed */
    public e(List<? extends ou> list) {
        p.h(list, "dataList");
        AppMethodBeat.i(230840);
        this.dataList = list;
        AppMethodBeat.o(230840);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter$Companion;", "", "()V", "TAG", "", "TYPE_VIDEO_FOOTER_LOADING", "", "TYPE_VIDEO_FOOTER_NO_MORE", "TYPE_VIDEO_NORMAL", "app_release"})
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(byte b2) {
            this();
        }
    }

    public final void sP(boolean z) {
        AppMethodBeat.i(230834);
        if (this.Bno == z) {
            AppMethodBeat.o(230834);
            return;
        }
        this.Bno = z;
        ci(this.dataList.size());
        AppMethodBeat.o(230834);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u0004R\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0014\"\u0004\b)\u0010\u0016¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter$BizProfileTabVideoVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "coverHeightForVideo", "", "getCoverHeightForVideo", "()I", "coverHeightForVideo$delegate", "Lkotlin/Lazy;", "coverImageView", "Landroid/widget/ImageView;", "getCoverImageView", "()Landroid/widget/ImageView;", "setCoverImageView", "(Landroid/widget/ImageView;)V", "friendRelateInfoTextView", "Landroid/widget/TextView;", "getFriendRelateInfoTextView", "()Landroid/widget/TextView;", "setFriendRelateInfoTextView", "(Landroid/widget/TextView;)V", "shadowView", "getShadowView", "()Landroid/view/View;", "setShadowView", "titleLayout", "Landroid/view/ViewGroup;", "getTitleLayout", "()Landroid/view/ViewGroup;", "setTitleLayout", "(Landroid/view/ViewGroup;)V", "titleTextView", "Lcom/tencent/mm/ui/widget/MMNeat7extView;", "getTitleTextView", "()Lcom/tencent/mm/ui/widget/MMNeat7extView;", "setTitleTextView", "(Lcom/tencent/mm/ui/widget/MMNeat7extView;)V", "videoDurationTextView", "getVideoDurationTextView", "setVideoDurationTextView", "app_release"})
    public static final class c extends RecyclerView.v {
        TextView Bnr;
        TextView Bns;
        View Bnt;
        ViewGroup Bnu;
        MMNeat7extView Bnv;
        final kotlin.f Bnw;
        ImageView cxe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            p.h(view, "itemView");
            AppMethodBeat.i(230826);
            View findViewById = view.findViewById(R.id.a5x);
            p.g(findViewById, "itemView.findViewById(R.…profile_item_video_image)");
            this.cxe = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.a5w);
            p.g(findViewById2, "itemView.findViewById(R.…e_item_video_duration_tv)");
            this.Bnr = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.a5v);
            p.g(findViewById3, "itemView.findViewById(R.…ofile_item_video_desc_tv)");
            this.Bns = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.a5u);
            p.g(findViewById4, "itemView.findViewById(R.…e_item_video_desc_shadow)");
            this.Bnt = findViewById4;
            View findViewById5 = view.findViewById(R.id.a5z);
            p.g(findViewById5, "itemView.findViewById(R.…_item_video_title_layout)");
            this.Bnu = (ViewGroup) findViewById5;
            View findViewById6 = view.findViewById(R.id.a60);
            p.g(findViewById6, "itemView.findViewById(R.…file_item_video_title_tv)");
            this.Bnv = (MMNeat7extView) findViewById6;
            this.Bnw = kotlin.g.ah(new a(view));
            AppMethodBeat.o(230826);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<Integer> {
            final /* synthetic */ View rsM;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(View view) {
                super(0);
                this.rsM = view;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Integer invoke() {
                AppMethodBeat.i(230825);
                int jn = com.tencent.mm.cb.a.jn(this.rsM.getContext());
                int jo = com.tencent.mm.cb.a.jo(this.rsM.getContext());
                if (jn >= jo) {
                    jn = jo;
                }
                Integer valueOf = Integer.valueOf((int) (((float) (jn - ((int) (com.tencent.mm.cb.a.getDensity(this.rsM.getContext()) * 24.0f)))) / 1.7777778f));
                AppMethodBeat.o(230825);
                return valueOf;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter$BizProfileTabLoadingVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "app_release"})
    public static final class a extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            p.h(view, "itemView");
            AppMethodBeat.i(230823);
            AppMethodBeat.o(230823);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter$BizProfileTabNoMoreVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "footerText", "Landroid/widget/TextView;", "getFooterText", "()Landroid/widget/TextView;", "app_release"})
    public static final class b extends RecyclerView.v {
        final TextView Bnq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            p.h(view, "itemView");
            AppMethodBeat.i(230824);
            View findViewById = view.findViewById(R.id.a61);
            p.g(findViewById, "itemView.findViewById(R.…rofile_list_no_more_text)");
            this.Bnq = (TextView) findViewById;
            AppMethodBeat.o(230824);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(230835);
        p.h(viewGroup, "parent");
        switch (i2) {
            case 0:
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.x4, viewGroup, false);
                p.g(inflate, "view");
                c cVar = new c(inflate);
                AppMethodBeat.o(230835);
                return cVar;
            case 1:
                View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wr, viewGroup, false);
                p.g(inflate2, "view");
                a aVar = new a(inflate2);
                AppMethodBeat.o(230835);
                return aVar;
            default:
                View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.xl, viewGroup, false);
                p.g(inflate3, "view");
                b bVar = new b(inflate3);
                AppMethodBeat.o(230835);
                return bVar;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(230836);
        if (i2 < this.dataList.size()) {
            AppMethodBeat.o(230836);
            return 0;
        } else if (this.Bno) {
            AppMethodBeat.o(230836);
            return 1;
        } else {
            AppMethodBeat.o(230836);
            return 2;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(230837);
        int size = this.dataList.size() + 1;
        AppMethodBeat.o(230837);
        return size;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final void a(RecyclerView.v vVar, int i2) {
        String str;
        boolean z;
        float[] b2;
        boolean z2;
        AppMethodBeat.i(230838);
        p.h(vVar, "holder");
        if (vVar instanceof c) {
            c cVar = (c) vVar;
            ou ouVar = this.dataList.get(i2);
            nh nhVar = ouVar.KVv.KSK.get(0);
            ng ngVar = ouVar.KVv.KSJ;
            o.hp(cVar.aus);
            cVar.aus.setOnClickListener(new f(cVar, nhVar, ngVar));
            if (ouVar.KVq.xKb == 49 && eFj().CR(16)) {
                com.tencent.mm.plugin.brandservice.a.b eFj = eFj();
                LinkedList<nh> linkedList = ouVar.KVv.KSK;
                p.g(linkedList, "bizMessage.AppMsg.DetailInfo");
                LinkedList<nh> linkedList2 = linkedList;
                ArrayList arrayList = new ArrayList(j.a(linkedList2, 10));
                for (T t : linkedList2) {
                    arrayList.add(j.listOf((Object[]) new String[]{t.KSj, String.valueOf(t.iAb)}));
                }
                eFj.j(arrayList, 126);
            }
            String str2 = nhVar.KSy;
            if (str2 == null || n.aL(str2)) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                cVar.Bns.setVisibility(0);
                cVar.Bnt.setVisibility(0);
                cVar.Bns.setText(nhVar.KSy);
            } else {
                cVar.Bns.setVisibility(8);
                cVar.Bnt.setVisibility(8);
            }
            cVar.Bnr.setText(m.rJ(nhVar.KSx));
            p.g(nhVar, "bizAppMsgDetailInfo");
            ImageView imageView = cVar.cxe;
            int intValue = ((Number) cVar.Bnw.getValue()).intValue();
            String str3 = nhVar.KSy;
            int i3 = str3 == null || n.aL(str3) ? R.drawable.aov : R.drawable.aow;
            imageView.setBackgroundResource(i3);
            String str4 = nhVar.Title;
            if (str4 == null || str4.length() == 0) {
                b2 = kotlin.a.e.b(new Float[]{Float.valueOf(com.tencent.mm.plugin.profile.ui.tab.a.eFy()), Float.valueOf(com.tencent.mm.plugin.profile.ui.tab.a.eFy()), Float.valueOf(com.tencent.mm.plugin.profile.ui.tab.a.eFy()), Float.valueOf(com.tencent.mm.plugin.profile.ui.tab.a.eFy())});
            } else {
                b2 = kotlin.a.e.b(new Float[]{Float.valueOf(com.tencent.mm.plugin.profile.ui.tab.a.eFy()), Float.valueOf(com.tencent.mm.plugin.profile.ui.tab.a.eFy()), Float.valueOf(0.0f), Float.valueOf(0.0f)});
            }
            String L = L(new String[]{nhVar.KSl, nhVar.KSn});
            if (L == null) {
                L = "";
            }
            String u = com.tencent.mm.api.b.u(L, 2);
            p.g(u, "BizImageStrategy.getUrl(…rategy.SCENE_BIZ_PROFILE)");
            g gVar = new g(this);
            imageView.setImageBitmap(null);
            imageView.setImageDrawable(null);
            imageView.setImageResource(i3);
            imageView.setTag(u);
            int jn = com.tencent.mm.cb.a.jn(imageView.getContext()) - ((int) (com.tencent.mm.cb.a.getDensity(imageView.getContext()) * 24.0f));
            c.a bdp = new c.a().bdp();
            StringBuilder sb = new StringBuilder("radius_");
            String arrays = Arrays.toString(b2);
            p.g(arrays, "java.util.Arrays.toString(this)");
            com.tencent.mm.av.a.a.c bdv = bdp.OU(sb.append(arrays).toString()).tz(i3).dr(jn, intValue).a(new com.tencent.mm.pluginsdk.ui.applet.n(3)).a(new com.tencent.mm.pluginsdk.ui.applet.e(3)).OS(s.bdu(u)).bdv();
            com.tencent.mm.pluginsdk.ui.applet.m mVar = new com.tencent.mm.pluginsdk.ui.applet.m(3, -1, -1, b2, gVar);
            mVar.aG(h.BnC);
            com.tencent.mm.av.q.bcV().a(u, imageView, bdv, mVar);
            String str5 = nhVar.Title;
            if (str5 == null || str5.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                cVar.Bnu.setVisibility(8);
                cVar.Bnv.setVisibility(8);
                AppMethodBeat.o(230838);
                return;
            }
            cVar.Bnu.setVisibility(0);
            cVar.Bnv.setVisibility(0);
            MMNeat7extView mMNeat7extView = cVar.Bnv;
            String str6 = nhVar.Title;
            p.g(str6, "bizAppMsgDetailInfo.Title");
            String str7 = nhVar.KSj;
            SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(mMNeat7extView.getContext(), str6);
            com.tencent.mm.plugin.brandservice.b.a aVar = com.tencent.mm.plugin.brandservice.b.a.pmT;
            p.g(c2, "text");
            aVar.a(c2, mMNeat7extView, false, str7, 4);
            mMNeat7extView.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.h(mMNeat7extView, new com.tencent.mm.pluginsdk.ui.span.o(mMNeat7extView.getContext())));
            AppMethodBeat.o(230838);
        } else if (vVar instanceof a) {
            kotlin.g.a.a<x> aVar2 = this.BmU;
            if (aVar2 != null) {
                aVar2.invoke();
                AppMethodBeat.o(230838);
                return;
            }
            AppMethodBeat.o(230838);
        } else {
            if (vVar instanceof b) {
                if (n.aL(this.footerWording)) {
                    View view = vVar.aus;
                    p.g(view, "holder.itemView");
                    str = view.getContext().getText(R.string.aih);
                } else {
                    str = this.footerWording;
                }
                p.g(str, "if (footerWording.isBlan…            footerWording");
                ((b) vVar).Bnq.setText(str);
            }
            AppMethodBeat.o(230838);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ ng BnA;
        final /* synthetic */ c Bny;
        final /* synthetic */ nh Bnz;

        f(c cVar, nh nhVar, ng ngVar) {
            this.Bny = cVar;
            this.Bnz = nhVar;
            this.BnA = ngVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(230829);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter$onBindVideoItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.profile.ui.tab.data.a aVar = com.tencent.mm.plugin.profile.ui.tab.data.a.BmH;
            View view2 = this.Bny.aus;
            p.g(view2, "holder.itemView");
            Context context = view2.getContext();
            p.g(context, "holder.itemView.context");
            a.C1596a aVar2 = new a.C1596a();
            aVar2.BmK = this.Bnz;
            aVar2.BmL = this.BnA;
            p.h("", "<set-?>");
            aVar2.sPQ = "";
            p.h("", "<set-?>");
            aVar2.BmI = "";
            aVar2.BmJ = this.Bny.cxe;
            com.tencent.mm.plugin.profile.ui.tab.data.a.a(context, aVar2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter$onBindVideoItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(230829);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter$setupCoverImage$imageLoaderCallback$1", "Lcom/tencent/mm/pluginsdk/ui/applet/ChattingBizImageDownloadListener$LoadTitleBitmapCallback;", "onFinish", "", "onStart", "app_release"})
    public static final class g implements m.a {
        final /* synthetic */ e BnB;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(e eVar) {
            this.BnB = eVar;
        }

        @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
        public final void onFinish() {
            AppMethodBeat.i(230830);
            e.eFN();
            AppMethodBeat.o(230830);
        }

        @Override // com.tencent.mm.pluginsdk.ui.applet.m.a
        public final void onStart() {
            AppMethodBeat.i(230831);
            e.eFO();
            AppMethodBeat.o(230831);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class h implements Runnable {
        public static final h BnC = new h();

        static {
            AppMethodBeat.i(230832);
            AppMethodBeat.o(230832);
        }

        h() {
        }

        public final void run() {
        }
    }

    private static String L(String[] strArr) {
        String str;
        AppMethodBeat.i(230839);
        int i2 = 0;
        while (true) {
            if (i2 >= 2) {
                str = null;
                break;
            }
            String str2 = strArr[i2];
            String str3 = str2;
            if (!(str3 == null || n.aL(str3))) {
                str = str2;
                break;
            }
            i2++;
        }
        if (str == null) {
            str = "";
        }
        AppMethodBeat.o(230839);
        return str;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/api/IBrandService;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.profile.ui.tab.list.e$e  reason: collision with other inner class name */
    static final class C1606e extends q implements kotlin.g.a.a<com.tencent.mm.plugin.brandservice.a.b> {
        public static final C1606e Bnx = new C1606e();

        static {
            AppMethodBeat.i(230828);
            AppMethodBeat.o(230828);
        }

        C1606e() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.brandservice.a.b invoke() {
            AppMethodBeat.i(230827);
            com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class);
            AppMethodBeat.o(230827);
            return bVar;
        }
    }

    public static final /* synthetic */ void eFN() {
        AppMethodBeat.i(230842);
        com.tencent.e.f.h.hkS();
        AppMethodBeat.o(230842);
    }

    public static final /* synthetic */ void eFO() {
        AppMethodBeat.i(230843);
        com.tencent.e.f.h.hkS();
        AppMethodBeat.o(230843);
    }
}
