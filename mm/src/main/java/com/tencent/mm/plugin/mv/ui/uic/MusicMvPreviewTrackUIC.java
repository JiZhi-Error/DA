package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.plugin.gallery.ui.SpeedyLinearLayoutManager;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0003EFGB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J$\u00107\u001a\u0002082\n\u00109\u001a\u00060\bR\u00020\u00002\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u000eH\u0002J\u0006\u0010=\u001a\u000208J\u0016\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@J\u0010\u0010B\u001a\u0002082\u0006\u0010C\u001a\u00020\u000eH\u0016J\u000e\u0010D\u001a\u0002082\u0006\u0010C\u001a\u00020\u000eR%\u0010\u0006\u001a\f\u0012\b\u0012\u00060\bR\u00020\u00000\u00078FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158FX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010+\u001a\f\u0012\b\u0012\u00060\bR\u00020\u00000,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006H"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/mv/ui/uic/OnMediaSelectListener;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC$TrackDataConvert;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "currentSelectIndex", "", "getCurrentSelectIndex", "()I", "setCurrentSelectIndex", "(I)V", "edge_6A", "layoutManager", "Lcom/tencent/mm/plugin/gallery/ui/SpeedyLinearLayoutManager;", "getLayoutManager", "()Lcom/tencent/mm/plugin/gallery/ui/SpeedyLinearLayoutManager;", "layoutManager$delegate", "mediaInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "getMediaInfoList", "()Ljava/util/LinkedList;", "setMediaInfoList", "(Ljava/util/LinkedList;)V", "mediaSelectListener", "getMediaSelectListener", "()Lcom/tencent/mm/plugin/mv/ui/uic/OnMediaSelectListener;", "setMediaSelectListener", "(Lcom/tencent/mm/plugin/mv/ui/uic/OnMediaSelectListener;)V", "trackData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getTrackData", "()Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "setTrackData", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "trackDataList", "Ljava/util/ArrayList;", "getTrackDataList", "()Ljava/util/ArrayList;", "setTrackDataList", "(Ljava/util/ArrayList;)V", "trackRV", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getTrackRV", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setTrackRV", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "attachThumb", "", "item", "thumbView", "Landroid/widget/ImageView;", "position", "initBgTrackView", "onVideoProgressUpdate", "timeMs", "", "videoDuration", "select", FirebaseAnalytics.b.INDEX, "selectMedia", "Companion", "TrackDataConvert", "TrackItemConvert", "plugin-mv_release"})
public final class MusicMvPreviewTrackUIC extends UIComponent implements b {
    public static final a AvK = new a((byte) 0);
    private static final String TAG = TAG;
    public csp AqY;
    private final kotlin.f AtV;
    ArrayList<b> AvF = new ArrayList<>();
    private WxRecyclerView AvG;
    int AvH = -1;
    private final int AvI;
    public b AvJ;
    LinkedList<com.tencent.mm.plugin.thumbplayer.d.a> oNM = new LinkedList<>();
    private final kotlin.f vat;

    public final WxRecyclerAdapter<b> getAdapter() {
        AppMethodBeat.i(257340);
        WxRecyclerAdapter<b> wxRecyclerAdapter = (WxRecyclerAdapter) this.AtV.getValue();
        AppMethodBeat.o(257340);
        return wxRecyclerAdapter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMvPreviewTrackUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(257342);
        this.AvI = com.tencent.mm.cb.a.aH(appCompatActivity, R.dimen.cn);
        this.AtV = kotlin.g.ah(new d(this));
        this.vat = kotlin.g.ah(new e(appCompatActivity));
        AppMethodBeat.o(257342);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC$Companion;", "", "()V", "PAYLOAD_PROGRESS", "", "PAYLOAD_SELECTED", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(257343);
        AppMethodBeat.o(257343);
    }

    public final void ewi() {
        FinderObject finderObject;
        FinderObjectDesc finderObjectDesc;
        axw axw;
        LinkedList<axz> linkedList;
        LinkedList<FinderObject> linkedList2;
        boolean z;
        AppMethodBeat.i(257338);
        csp csp = this.AqY;
        if (!(csp == null || (finderObject = csp.MxE) == null || (finderObjectDesc = finderObject.objectDesc) == null || (axw = finderObjectDesc.mvInfo) == null || (linkedList = axw.LId) == null)) {
            int i2 = 0;
            for (T t : linkedList) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    j.hxH();
                }
                T t2 = t;
                boolean z2 = false;
                if (t2.refObjectId != 0) {
                    csp csp2 = this.AqY;
                    if (!(csp2 == null || (linkedList2 = csp2.LDi) == null)) {
                        int i4 = 0;
                        for (T t3 : linkedList2) {
                            int i5 = i4 + 1;
                            if (i4 < 0) {
                                j.hxH();
                            }
                            T t4 = t3;
                            if (t4.id == t2.refObjectId) {
                                b bVar = new b((long) i4);
                                bVar.AvL = t2;
                                bVar.AvM = t4;
                                this.AvF.add(bVar);
                                z = true;
                            } else {
                                z = z2;
                            }
                            i4 = i5;
                            z2 = z;
                        }
                    }
                } else {
                    String str = t2.LIm;
                    if (!(str == null || str.length() == 0)) {
                        b bVar2 = new b((long) i2);
                        bVar2.AvL = t2;
                        bVar2.dLQ = true;
                        this.AvF.add(bVar2);
                        z2 = true;
                    }
                }
                if (!z2) {
                    ArrayList<b> arrayList = this.AvF;
                    b bVar3 = new b((long) i2);
                    bVar3.AvL = t2;
                    bVar3.dLQ = true;
                    bVar3.isDefault = true;
                    arrayList.add(bVar3);
                }
                i2 = i3;
            }
        }
        b bVar4 = (b) j.kt(this.AvF);
        if (bVar4 != null) {
            bVar4.pWp = true;
        }
        this.AvH = 0;
        kotlinx.coroutines.f.b(bn.TUK, ba.hMW(), new g(this, null), 2);
        this.AvG = (WxRecyclerView) getActivity().findViewById(R.id.b3u);
        View view = new View(getActivity());
        view.setLayoutParams(new RecyclerView.LayoutParams(com.tencent.mm.cb.a.fromDPToPix((Context) getActivity(), 24), com.tencent.mm.cb.a.fromDPToPix((Context) getActivity(), 64)));
        g.b unused = getAdapter().f(view, -1, true);
        View view2 = new View(getActivity());
        view2.setLayoutParams(new RecyclerView.LayoutParams(com.tencent.mm.cb.a.fromDPToPix((Context) getActivity(), 24), com.tencent.mm.cb.a.fromDPToPix((Context) getActivity(), 64)));
        g.b unused2 = getAdapter().g(view2, -2, true);
        WxRecyclerView wxRecyclerView = this.AvG;
        if (wxRecyclerView != null) {
            wxRecyclerView.setLayoutManager((SpeedyLinearLayoutManager) this.vat.getValue());
        }
        WxRecyclerView wxRecyclerView2 = this.AvG;
        if (wxRecyclerView2 != null) {
            wxRecyclerView2.setAdapter(getAdapter());
            AppMethodBeat.o(257338);
            return;
        }
        AppMethodBeat.o(257338);
    }

    public final void Tr(int i2) {
        AppMethodBeat.i(257339);
        b bVar = (b) j.L(this.AvF, this.AvH);
        if (bVar != null) {
            bVar.pWp = false;
            getAdapter().b(this.AvH + getAdapter().RqM.size(), (Object) 1);
        }
        b bVar2 = (b) j.L(this.AvF, i2);
        if (bVar2 != null) {
            bVar2.progress = 0.0f;
            bVar2.pWp = true;
            getAdapter().b(getAdapter().RqM.size() + i2, (Object) 1);
        }
        WxRecyclerView wxRecyclerView = this.AvG;
        if (wxRecyclerView != null) {
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(getAdapter().RqM.size() + i2, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView, a2.axQ(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC", "selectMedia", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
            wxRecyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView, "com/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC", "selectMedia", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
        }
        this.AvH = i2;
        AppMethodBeat.o(257339);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016JD\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0016J \u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\nH\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC$TrackItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC$TrackDataConvert;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/mv/ui/uic/OnMediaSelectListener;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC;Lcom/tencent/mm/plugin/mv/ui/uic/OnMediaSelectListener;)V", "getListener", "()Lcom/tencent/mm/plugin/mv/ui/uic/OnMediaSelectListener;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-mv_release"})
    public final class c extends com.tencent.mm.view.recyclerview.e<b> {
        final b AvO;

        public c(b bVar) {
            this.AvO = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
        @Override // com.tencent.mm.view.recyclerview.e
        public final /* synthetic */ void a(h hVar, b bVar, int i2, int i3, boolean z, List list) {
            axz axz;
            View Mn;
            float f2;
            float f3 = 1.0f;
            AppMethodBeat.i(257333);
            b bVar2 = bVar;
            p.h(hVar, "holder");
            p.h(bVar2, "item");
            if (list != null) {
                if (list.contains(1)) {
                    View Mn2 = hVar.Mn(R.id.hh3);
                    if (Mn2 != null) {
                        Mn2.setVisibility(bVar2.pWp ? 0 : 4);
                    }
                    View Mn3 = hVar.Mn(R.id.glk);
                    if (Mn3 != null) {
                        if (bVar2.pWp) {
                            f2 = 1.0f - bVar2.progress;
                        } else {
                            f2 = 1.0f;
                        }
                        Mn3.setScaleX(f2);
                    }
                }
                if (!list.contains(2) || (Mn = hVar.Mn(R.id.glk)) == null) {
                    AppMethodBeat.o(257333);
                    return;
                }
                if (bVar2.pWp) {
                    f3 = 1.0f - bVar2.progress;
                }
                Mn.setScaleX(f3);
                AppMethodBeat.o(257333);
                return;
            }
            TextView textView = (TextView) hVar.aus.findViewById(R.id.in3);
            if (!(textView == null || (axz = bVar2.AvL) == null)) {
                textView.setText(new StringBuilder().append(com.tencent.mm.plugin.mv.ui.a.e.Tl(axz.LIl)).append('s').toString());
            }
            View findViewById = hVar.aus.findViewById(R.id.hh3);
            if (findViewById != null) {
                if (bVar2.pWp) {
                    findViewById.setVisibility(0);
                } else {
                    findViewById.setVisibility(4);
                }
            }
            hVar.aus.setOnClickListener(new a(this, i2));
            View Mn4 = hVar.Mn(R.id.glk);
            p.g(Mn4, "maskView");
            Mn4.setPivotX((float) MusicMvPreviewTrackUIC.this.AvI);
            if (bVar2.pWp) {
                Mn4.setScaleX(1.0f - bVar2.progress);
            } else {
                Mn4.setScaleX(1.0f);
            }
            ImageView imageView = (ImageView) hVar.Mn(R.id.bh7);
            imageView.setImageDrawable(null);
            MusicMvPreviewTrackUIC musicMvPreviewTrackUIC = MusicMvPreviewTrackUIC.this;
            p.g(imageView, "thumbView");
            MusicMvPreviewTrackUIC.a(musicMvPreviewTrackUIC, bVar2, imageView, i2);
            AppMethodBeat.o(257333);
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final int getLayoutId() {
            return R.layout.bed;
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final void a(RecyclerView recyclerView, h hVar, int i2) {
            AppMethodBeat.i(257332);
            p.h(recyclerView, "recyclerView");
            p.h(hVar, "holder");
            AppMethodBeat.o(257332);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ c AvP;
            final /* synthetic */ int gUj;

            a(c cVar, int i2) {
                this.AvP = cVar;
                this.gUj = i2;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(257331);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC$TrackItemConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b bVar2 = this.AvP.AvO;
                if (bVar2 != null) {
                    bVar2.select(this.gUj);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC$TrackItemConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(257331);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010&\u001a\u00020\u0003H\u0016J\b\u0010'\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC$TrackDataConvert;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "id", "", "type", "", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC;JI)V", "getId", "()J", "isDefault", "", "()Z", "setDefault", "(Z)V", "isLocal", "setLocal", "isSelect", "setSelect", "progress", "", "getProgress", "()F", "setProgress", "(F)V", "trackInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;", "getTrackInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;", "setTrackInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;)V", "trackObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getTrackObj", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setTrackObj", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getType", "()I", "getItemId", "getItemType", "plugin-mv_release"})
    public final class b implements com.tencent.mm.view.recyclerview.a {
        axz AvL;
        FinderObject AvM;
        boolean dLQ;
        private final long id;
        boolean isDefault;
        boolean pWp;
        float progress = 1.0f;
        private final int type = 0;

        /* JADX WARN: Incorrect types in method signature: (JI)V */
        public b(long j2) {
            this.id = j2;
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final long lT() {
            return this.id;
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final int cxn() {
            return this.type;
        }
    }

    @Override // com.tencent.mm.plugin.mv.ui.uic.b
    public final void select(int i2) {
        AppMethodBeat.i(257341);
        Tr(i2);
        b bVar = this.AvJ;
        if (bVar != null) {
            bVar.select(i2);
            AppMethodBeat.o(257341);
            return;
        }
        AppMethodBeat.o(257341);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ MusicMvPreviewTrackUIC AvN;
        final /* synthetic */ long AvR;
        final /* synthetic */ long wfK;

        f(MusicMvPreviewTrackUIC musicMvPreviewTrackUIC, long j2, long j3) {
            this.AvN = musicMvPreviewTrackUIC;
            this.wfK = j2;
            this.AvR = j3;
        }

        public final void run() {
            AppMethodBeat.i(257337);
            b bVar = (b) j.L(this.AvN.AvF, this.AvN.AvH);
            if (bVar != null) {
                float f2 = 0.0f;
                axz axz = bVar.AvL;
                if (axz != null) {
                    if (bVar.isDefault) {
                        k euj = k.euj();
                        p.g(euj, "MusicPlayerManager.Instance()");
                        com.tencent.mm.plugin.music.f.a.d etW = euj.etW();
                        p.g(etW, "MusicPlayerManager.Instance().musicPlayer");
                        f2 = (((float) etW.etn()) - ((float) axz.Ghu)) / ((float) axz.LIl);
                    } else {
                        f2 = ((float) this.wfK) / ((float) this.AvR);
                    }
                    this.AvN.getAdapter().b(this.AvN.AvH + this.AvN.getAdapter().RqM.size(), (Object) 2);
                }
                bVar.progress = f2;
                this.AvN.getAdapter().b(this.AvN.AvH + this.AvN.getAdapter().RqM.size(), (Object) 2);
                AppMethodBeat.o(257337);
                return;
            }
            AppMethodBeat.o(257337);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.mv.ui.uic.MusicMvPreviewTrackUIC$initBgTrackView$2", f = "MusicMvPreviewTrackUIC.kt", hxM = {PlayerException.EXCEPTION_IN_PAUSE}, m = "invokeSuspend")
    public static final class g extends kotlin.d.b.a.j implements m<ai, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ MusicMvPreviewTrackUIC AvN;
        Object L$0;
        int label;
        private ai p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(MusicMvPreviewTrackUIC musicMvPreviewTrackUIC, kotlin.d.d dVar) {
            super(2, dVar);
            this.AvN = musicMvPreviewTrackUIC;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(259288);
            p.h(dVar, "completion");
            g gVar = new g(this.AvN, dVar);
            gVar.p$ = (ai) obj;
            AppMethodBeat.o(259288);
            return gVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, kotlin.d.d<? super x> dVar) {
            AppMethodBeat.i(259289);
            Object invokeSuspend = ((g) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(259289);
            return invokeSuspend;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            Integer num;
            LinkedList<FinderObject> linkedList;
            AppMethodBeat.i(259287);
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    ai aiVar = this.p$;
                    MusicMvPreviewTrackUIC musicMvPreviewTrackUIC = this.AvN;
                    com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                    LinkedList<com.tencent.mm.plugin.thumbplayer.d.a> ewh = ((MusicMvPreviewBgUIC) com.tencent.mm.ui.component.a.b(this.AvN.getActivity()).get(MusicMvPreviewBgUIC.class)).ewh();
                    p.h(ewh, "<set-?>");
                    musicMvPreviewTrackUIC.oNM = ewh;
                    a aVar3 = MusicMvPreviewTrackUIC.AvK;
                    String str = MusicMvPreviewTrackUIC.TAG;
                    StringBuilder append = new StringBuilder("initBgTrackView size:").append(this.AvN.AvF.size()).append(", mediaInfoList.size:").append(this.AvN.oNM.size()).append(", trackData?.refObjectList.size:");
                    csp csp = this.AvN.AqY;
                    if (csp == null || (linkedList = csp.LDi) == null) {
                        num = null;
                    } else {
                        num = Integer.valueOf(linkedList.size());
                    }
                    Log.i(str, append.append(num).toString());
                    this.L$0 = aiVar;
                    this.label = 1;
                    if (kotlinx.coroutines.g.a(ba.hMV(), new m<ai, kotlin.d.d<? super x>, Object>(this, null) {
                        /* class com.tencent.mm.plugin.mv.ui.uic.MusicMvPreviewTrackUIC.g.AnonymousClass1 */
                        final /* synthetic */ g Vaq;
                        int label;
                        private ai p$;

                        {
                            this.Vaq = r2;
                        }

                        @Override // kotlin.d.b.a.a
                        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                            AppMethodBeat.i(259285);
                            p.h(dVar, "completion");
                            AnonymousClass1 r0 = 

                            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC$TrackDataConvert;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC;", "invoke"})
                            static final class d extends q implements kotlin.g.a.a<WxRecyclerAdapter<b>> {
                                final /* synthetic */ MusicMvPreviewTrackUIC AvN;

                                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                                d(MusicMvPreviewTrackUIC musicMvPreviewTrackUIC) {
                                    super(0);
                                    this.AvN = musicMvPreviewTrackUIC;
                                }

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                @Override // kotlin.g.a.a
                                public final /* synthetic */ WxRecyclerAdapter<b> invoke() {
                                    AppMethodBeat.i(257335);
                                    WxRecyclerAdapter wxRecyclerAdapter = new WxRecyclerAdapter(new com.tencent.mm.view.recyclerview.f(this) {
                                        /* class com.tencent.mm.plugin.mv.ui.uic.MusicMvPreviewTrackUIC.d.AnonymousClass1 */
                                        final /* synthetic */ d AvQ;

                                        /* JADX WARN: Incorrect args count in method signature: ()V */
                                        {
                                            this.AvQ = r1;
                                        }

                                        @Override // com.tencent.mm.view.recyclerview.f
                                        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
                                            AppMethodBeat.i(257334);
                                            c cVar = new c(this.AvQ.AvN);
                                            AppMethodBeat.o(257334);
                                            return cVar;
                                        }
                                    }, this.AvN.AvF, false);
                                    AppMethodBeat.o(257335);
                                    return wxRecyclerAdapter;
                                }
                            }

                            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/gallery/ui/SpeedyLinearLayoutManager;", "invoke"})
                            static final class e extends q implements kotlin.g.a.a<SpeedyLinearLayoutManager> {
                                final /* synthetic */ AppCompatActivity uQi;

                                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                                e(AppCompatActivity appCompatActivity) {
                                    super(0);
                                    this.uQi = appCompatActivity;
                                }

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                @Override // kotlin.g.a.a
                                public final /* synthetic */ SpeedyLinearLayoutManager invoke() {
                                    AppMethodBeat.i(257336);
                                    SpeedyLinearLayoutManager speedyLinearLayoutManager = new SpeedyLinearLayoutManager();
                                    speedyLinearLayoutManager.hVQ();
                                    AppMethodBeat.o(257336);
                                    return speedyLinearLayoutManager;
                                }
                            }

                            public static final /* synthetic */ void a(MusicMvPreviewTrackUIC musicMvPreviewTrackUIC, b bVar, ImageView imageView, int i2) {
                                boolean z;
                                AppMethodBeat.i(257344);
                                if (i2 < musicMvPreviewTrackUIC.oNM.size()) {
                                    com.tencent.mm.plugin.thumbplayer.d.a aVar = musicMvPreviewTrackUIC.oNM.get(i2);
                                    p.g(aVar, "mediaInfoList[position]");
                                    com.tencent.mm.plugin.thumbplayer.d.a aVar2 = aVar;
                                    if (bVar.dLQ) {
                                        if (aVar2.path.length() > 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (z) {
                                            String str = aVar2.path;
                                            com.tencent.mm.plugin.music.model.g gVar = com.tencent.mm.plugin.music.model.g.Aku;
                                            com.tencent.mm.plugin.gallery.ui.h.a(imageView, 2, com.tencent.mm.plugin.music.model.g.aHP("thumb_" + aVar2.path.hashCode()), str, (long) str.hashCode(), i2, 0);
                                            AppMethodBeat.o(257344);
                                            return;
                                        }
                                    }
                                    if (aVar2.thumbUrl.length() > 0) {
                                        c.a aVar3 = new c.a();
                                        com.tencent.mm.plugin.music.model.g gVar2 = com.tencent.mm.plugin.music.model.g.Aku;
                                        aVar3.OS(com.tencent.mm.plugin.music.model.g.aHP("thumb_" + aVar2.mediaId));
                                        aVar3.bdp();
                                        aVar3.bdo();
                                        com.tencent.mm.av.q.bcV().a(aVar2.thumbUrl + aVar2.Ghs, imageView, aVar3.bdv());
                                        AppMethodBeat.o(257344);
                                        return;
                                    }
                                    imageView.setImageDrawable(null);
                                }
                                AppMethodBeat.o(257344);
                            }
                        }
