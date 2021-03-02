package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.plugin.ball.view.CircleAnimateView;
import com.tencent.mm.plugin.mv.a.e;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvMainUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axx;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 ;2\u00020\u0001:\u0003;<=B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020,J\b\u0010-\u001a\u00020*H\u0002J,\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0006\u00106\u001a\u00020*J\u001c\u00107\u001a\u00020*2\u0006\u00108\u001a\u00020\u000f2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000f0:R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00070!j\b\u0012\u0004\u0012\u00020\u0007`\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$MusicMVItemConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "getContext", "()Landroid/content/Context;", "currentPlayingMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "feedIdList", "", "", "getFeedIdList", "()Ljava/util/List;", "setFeedIdList", "(Ljava/util/List;)V", "footerInfo", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "footerView", "Landroid/view/View;", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "layoutManager$delegate", "mvListData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mvListHalfDialog", "Lcom/tencent/mm/plugin/music/ui/view/MusicHalfDialog;", "mvListRV", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "titleTv", "Landroid/widget/TextView;", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "", "isShow", "", "onDataSetChanged", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "show", "updateData", "currentMusicMv", "dataList", "", "Companion", "MusicMVItemConvertData", "MusicMVListItemConverter", "plugin-mv_release"})
public final class e implements i {
    private static final int AxZ = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    public static final c Aya = new c((byte) 0);
    private final kotlin.f AtV = kotlin.g.ah(new f(this));
    private WxRecyclerView AxT;
    private final ArrayList<d> AxU = new ArrayList<>();
    public final com.tencent.mm.plugin.music.ui.view.a AxV = new com.tencent.mm.plugin.music.ui.view.a(this.context);
    private List<Long> AxW;
    private com.tencent.mm.plugin.mv.a.e AxX;
    private g.b AxY;
    final Context context;
    private final View psf;
    private TextView titleTv;
    private final kotlin.f vat;

    private final WxRecyclerAdapter<d> getAdapter() {
        AppMethodBeat.i(257540);
        WxRecyclerAdapter<d> wxRecyclerAdapter = (WxRecyclerAdapter) this.AtV.getValue();
        AppMethodBeat.o(257540);
        return wxRecyclerAdapter;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$Companion;", "", "()V", "TAG", "", "dp4", "", "plugin-mv_release"})
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }
    }

    public e(Context context2) {
        TextView textView;
        WxRecyclerView wxRecyclerView;
        ViewGroup.LayoutParams layoutParams;
        p.h(context2, "context");
        AppMethodBeat.i(257544);
        this.context = context2;
        List<Long> synchronizedList = Collections.synchronizedList(new ArrayList());
        p.g(synchronizedList, "Collections.synchronizedList(ArrayList())");
        this.AxW = synchronizedList;
        this.vat = kotlin.g.ah(new g(this));
        com.tencent.mm.plugin.music.ui.view.a aVar = this.AxV;
        View view = aVar.lJI;
        if (view == null) {
            p.hyc();
        }
        View findViewById = view.findViewById(R.id.ab3);
        p.g(findViewById, "rootView!!.findViewById(…ttom_sheet_custom_layout)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        View view2 = aVar.lJI;
        if (view2 == null) {
            p.hyc();
        }
        LayoutInflater.from(view2.getContext()).inflate(R.layout.bds, (ViewGroup) linearLayout, true);
        View view3 = aVar.lJI;
        if (!(view3 == null || (layoutParams = view3.getLayoutParams()) == null)) {
            layoutParams.height = au.az(this.context).y / 2;
        }
        View view4 = aVar.lJI;
        View findViewById2 = view4 != null ? view4.findViewById(R.id.b46) : null;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new a(this));
        }
        View view5 = aVar.lJI;
        if (view5 != null) {
            textView = (TextView) view5.findViewById(R.id.ir3);
        } else {
            textView = null;
        }
        this.titleTv = textView;
        View view6 = aVar.lJI;
        if (view6 != null) {
            wxRecyclerView = (WxRecyclerView) view6.findViewById(R.id.frz);
        } else {
            wxRecyclerView = null;
        }
        this.AxT = wxRecyclerView;
        WxRecyclerView wxRecyclerView2 = this.AxT;
        if (wxRecyclerView2 != null) {
            wxRecyclerView2.setLayoutManager((LinearLayoutManager) this.vat.getValue());
        }
        WxRecyclerView wxRecyclerView3 = this.AxT;
        if (wxRecyclerView3 != null) {
            wxRecyclerView3.setAdapter(getAdapter());
        }
        getAdapter().RqP = new b(this);
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.bdy, (ViewGroup) this.AxT, false);
        p.g(inflate, "LayoutInflater.from(cont…_footer, mvListRV, false)");
        this.psf = inflate;
        AppMethodBeat.o(257544);
    }

    static {
        AppMethodBeat.i(257545);
        AppMethodBeat.o(257545);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$1$1"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ e Ayb;

        a(e eVar) {
            this.Ayb = eVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257532);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.Ayb.AxV.bMo();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257532);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$1$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-mv_release"})
    public static final class b implements g.c<h> {
        final /* synthetic */ e Ayb;

        b(e eVar) {
            this.Ayb = eVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
        @Override // com.tencent.mm.view.recyclerview.g.c
        public final /* synthetic */ void a(RecyclerView.a<h> aVar, View view, int i2, h hVar) {
            boolean z;
            d dVar;
            int i3 = 0;
            AppMethodBeat.i(257533);
            p.h(aVar, "adapter");
            p.h(view, "view");
            p.h(hVar, "holder");
            ArrayList arrayList = this.Ayb.AxU;
            if (arrayList.size() > i2) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                arrayList = null;
            }
            if (arrayList == null || (dVar = (d) arrayList.get(i2)) == null) {
                AppMethodBeat.o(257533);
                return;
            }
            if (!p.j(this.Ayb.AxX, dVar.Ayc)) {
                this.Ayb.AxX = dVar.Ayc;
                com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                MusicMvMainUIC musicMvMainUIC = (MusicMvMainUIC) com.tencent.mm.ui.component.a.ko(this.Ayb.context).get(MusicMvMainUIC.class);
                com.tencent.mm.plugin.mv.a.e eVar = dVar.Ayc;
                p.h(eVar, "musicMv");
                Log.i(musicMvMainUIC.TAG, "start switchToMv from musicMv, dataList.size:" + musicMvMainUIC.kgc.size());
                MusicMvMainUIC musicMvMainUIC2 = musicMvMainUIC;
                Iterator<T> it = musicMvMainUIC2.kgc.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    T next = it.next();
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        j.hxH();
                    }
                    if (p.j(next.ArY, eVar)) {
                        Log.i(musicMvMainUIC2.TAG, "switchToMv index:".concat(String.valueOf(i3)));
                        musicMvMainUIC2.hWF();
                        SecDataUIC.a aVar3 = SecDataUIC.CWq;
                        cst cst = (cst) SecDataUIC.a.a(musicMvMainUIC2.getContext(), 7, cst.class);
                        if (cst != null) {
                            cst.scene = 12;
                        }
                        musicMvMainUIC2.To(i3);
                    } else {
                        i3 = i4;
                    }
                }
                aVar.notifyDataSetChanged();
            }
            this.Ayb.AxV.bMo();
            AppMethodBeat.o(257533);
        }
    }

    public final void a(com.tencent.mm.plugin.mv.a.e eVar, List<com.tencent.mm.plugin.mv.a.e> list) {
        AppMethodBeat.i(257541);
        p.h(eVar, "currentMusicMv");
        p.h(list, "dataList");
        this.AxU.clear();
        this.AxX = eVar;
        int i2 = 0;
        for (T t : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            T t2 = t;
            e.a aVar = com.tencent.mm.plugin.mv.a.e.ApR;
            if (e.a.b((com.tencent.mm.plugin.mv.a.e) t2)) {
                this.AxU.add(new d((long) i2, t2));
            }
            i2 = i3;
        }
        if (this.AxU.isEmpty()) {
            this.AxY = getAdapter().g(this.psf, -2, true);
        } else {
            g.b bVar = this.AxY;
            if (bVar != null) {
                getAdapter().U(bVar.lT(), false);
            }
        }
        TextView textView = this.titleTv;
        if (textView != null) {
            textView.setText(this.context.getString(R.string.f_9, Integer.valueOf(this.AxU.size())));
        }
        getAdapter().notifyDataSetChanged();
        AppMethodBeat.o(257541);
    }

    public final void show() {
        AppMethodBeat.i(257542);
        if (!this.AxV.isShowing()) {
            this.AxV.dGm();
        }
        AppMethodBeat.o(257542);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(257543);
        Log.i("Music.Mv.MusicMvListDialog", "onSceneEnd errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + " scene:" + qVar);
        AppMethodBeat.o(257543);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J@\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0017J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0005H\u0016J(\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0003¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$MusicMVListItemConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$MusicMVItemConvertData;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "updateLikeStatus", "likeIt", "likeIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "likeCntTv", "Landroid/widget/TextView;", "likeCnt", "plugin-mv_release"})
    /* renamed from: com.tencent.mm.plugin.mv.ui.view.e$e  reason: collision with other inner class name */
    public final class C1561e extends com.tencent.mm.view.recyclerview.e<d> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public C1561e() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
        @Override // com.tencent.mm.view.recyclerview.e
        public final /* synthetic */ void a(h hVar, d dVar, int i2, int i3, boolean z, List list) {
            boolean z2;
            String str;
            axw axw;
            axx axx;
            TextView textView;
            AppMethodBeat.i(257536);
            d dVar2 = dVar;
            p.h(hVar, "holder");
            p.h(dVar2, "item");
            MMRoundCornerImageView mMRoundCornerImageView = (MMRoundCornerImageView) hVar.Mn(R.id.frr);
            String str2 = dVar2.Ayc.ApD;
            if (str2 != null) {
                com.tencent.mm.av.a.a.c bdv = new c.a().bdo().bdr().bdv();
                p.g(bdv, "ImageLoaderOptions.Build…ns.LoadFrom.FILE).build()");
                com.tencent.mm.av.q.bcV().a(str2, mMRoundCornerImageView, bdv);
            } else {
                String str3 = dVar2.Ayc.coverUrl;
                if (str3 == null || str3.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    str = dVar2.Ayc.coverUrl;
                } else {
                    str = null;
                }
                if (str != null) {
                    c.a aVar = new c.a();
                    com.tencent.mm.plugin.mv.ui.a aVar2 = com.tencent.mm.plugin.mv.ui.a.ArA;
                    aVar.OS(com.tencent.mm.plugin.mv.ui.a.aIo(str));
                    aVar.bdp();
                    aVar.bdo();
                    aVar.aw((float) e.AxZ);
                    com.tencent.mm.av.q.bcV().a(str, mMRoundCornerImageView, aVar.bdv());
                }
            }
            e.a aVar3 = com.tencent.mm.plugin.mv.a.e.ApR;
            FinderObject a2 = e.a.a(dVar2.Ayc);
            if (a2 != null) {
                FinderContact finderContact = a2.contact;
                if (!(finderContact == null || (textView = (TextView) hVar.Mn(R.id.fs7)) == null)) {
                    textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(e.this.context, e.this.context.getString(R.string.f__, finderContact.nickname)));
                }
                FinderObjectDesc finderObjectDesc = a2.objectDesc;
                if (!(finderObjectDesc == null || (axw = finderObjectDesc.mvInfo) == null || (axx = axw.ApI) == null)) {
                    int rint = (int) ((float) Math.rint((double) (axx.LIe * 100.0f)));
                    TextView textView2 = (TextView) hVar.Mn(R.id.fs4);
                    if (textView2 != null) {
                        textView2.setText(e.this.context.getString(R.string.f_b, Integer.valueOf(rint)));
                    }
                }
                CircleAnimateView circleAnimateView = (CircleAnimateView) hVar.Mn(R.id.gd3);
                if (circleAnimateView != null) {
                    circleAnimateView.setImageResource(R.raw.float_ball_state_music);
                }
                CircleAnimateView circleAnimateView2 = (CircleAnimateView) hVar.Mn(R.id.gd3);
                if (circleAnimateView2 != null) {
                    circleAnimateView2.setVisibility(p.j(e.this.AxX, dVar2.Ayc) ? 0 : 8);
                }
                TextView textView3 = (TextView) hVar.Mn(R.id.frx);
                WeImageView weImageView = (WeImageView) hVar.Mn(R.id.fry);
                if (textView3 != null) {
                    textView3.setText(String.valueOf(a2.likeCount));
                }
                if (weImageView != null) {
                    weImageView.setImageResource(R.raw.icons_filled_like);
                    weImageView.setIconColor(e.this.context.getResources().getColor(R.color.am));
                    AppMethodBeat.o(257536);
                    return;
                }
                AppMethodBeat.o(257536);
                return;
            }
            AppMethodBeat.o(257536);
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final int getLayoutId() {
            return R.layout.bdx;
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final void a(RecyclerView recyclerView, h hVar, int i2) {
            AppMethodBeat.i(257535);
            p.h(recyclerView, "recyclerView");
            p.h(hVar, "holder");
            AppMethodBeat.o(257535);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$MusicMVItemConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "id", "", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "(JLcom/tencent/mm/plugin/mv/model/MusicMv;)V", "getId", "()J", "getMusicMv", "()Lcom/tencent/mm/plugin/mv/model/MusicMv;", "getItemId", "getItemType", "", "plugin-mv_release"})
    public static final class d implements com.tencent.mm.view.recyclerview.a {
        final com.tencent.mm.plugin.mv.a.e Ayc;
        private final long id;

        public d(long j2, com.tencent.mm.plugin.mv.a.e eVar) {
            p.h(eVar, "musicMv");
            AppMethodBeat.i(257534);
            this.id = j2;
            this.Ayc = eVar;
            AppMethodBeat.o(257534);
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final long lT() {
            return this.id;
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final int cxn() {
            return 5;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$MusicMVItemConvertData;", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<WxRecyclerAdapter<d>> {
        final /* synthetic */ e Ayb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(e eVar) {
            super(0);
            this.Ayb = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ WxRecyclerAdapter<d> invoke() {
            AppMethodBeat.i(257538);
            WxRecyclerAdapter wxRecyclerAdapter = new WxRecyclerAdapter(new com.tencent.mm.view.recyclerview.f(this) {
                /* class com.tencent.mm.plugin.mv.ui.view.e.f.AnonymousClass1 */
                final /* synthetic */ f Ayd;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.Ayd = r1;
                }

                @Override // com.tencent.mm.view.recyclerview.f
                public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
                    AppMethodBeat.i(257537);
                    C1561e eVar = new C1561e();
                    AppMethodBeat.o(257537);
                    return eVar;
                }
            }, this.Ayb.AxU, true);
            AppMethodBeat.o(257538);
            return wxRecyclerAdapter;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/support/v7/widget/LinearLayoutManager;", "invoke"})
    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayoutManager> {
        final /* synthetic */ e Ayb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(e eVar) {
            super(0);
            this.Ayb = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayoutManager invoke() {
            AppMethodBeat.i(257539);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
            AppMethodBeat.o(257539);
            return linearLayoutManager;
        }
    }
}
