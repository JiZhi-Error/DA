package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.csi;
import com.tencent.mm.protocal.protobuf.csk;
import com.tencent.mm.protocal.protobuf.csl;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.t;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u0000 12\u00020\u0001:\u00041234B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010\u001f\u001a\u00020\u001bJ\u001e\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$J\u001e\u0010%\u001a\u00020\u001b2\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\r0\u000fj\b\u0012\u0004\u0012\u00020\r`\u0010J\u0006\u0010'\u001a\u00020\u001bJ\u0006\u0010(\u001a\u00020\u001bJ\b\u0010)\u001a\u00020\u001bH\u0002J\u000e\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\tJ\u000e\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u0012J\u0010\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\tH\u0002J\b\u00100\u001a\u00020\u001bH\u0002R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX.¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\r0\u000fj\b\u0012\u0004\u0012\u00020\r`\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u00065"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConvertData;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "liveRoomListener", "Lcom/tencent/mm/plugin/mv/ui/uic/callback/OnChattingViewEventListener;", "msgIdList", "", "", "readCount", "buildFakeMsgPack", "Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;", "random", "hideNewCommentTip", "", "initFakeData", "isLandscape", "", "onDestroy", "onLongClicked", "feedId", "commentId", "text", "", "onMsgUpdated", "lstConvertData", "onPause", "onResume", "prepareViews", "setMaxWidth", "maxWidth", "setViewEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showNewCommentTip", "count", "smoothScrollToLastPosition", "Companion", "MusicCommentConvertData", "MusicCommentConverter", "MusicCommentItemData", "plugin-mv_release"})
public final class MusicMvCommentView extends RelativeLayout {
    private static final int AxL = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8);
    public static final a AxM = new a((byte) 0);
    private com.tencent.mm.plugin.mv.ui.uic.a.a AxK;
    private HashMap _$_findViewCache;
    private ArrayList<b> kgc;
    private int readCount;
    private WxRecyclerAdapter<b> tFp;
    private final List<Long> xEG;

    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(257523);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(257523);
        return view;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMvCommentView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(257518);
        this.kgc = new ArrayList<>();
        List<Long> synchronizedList = Collections.synchronizedList(new ArrayList());
        p.g(synchronizedList, "Collections.synchronizedList(ArrayList())");
        this.xEG = synchronizedList;
        View.inflate(context, R.layout.be6, this);
        this.tFp = new WxRecyclerAdapter<>(new g(this), this.kgc, true);
        WxRecyclerView wxRecyclerView = (WxRecyclerView) _$_findCachedViewById(R.id.ed5);
        if (wxRecyclerView != null) {
            WxRecyclerAdapter<b> wxRecyclerAdapter = this.tFp;
            if (wxRecyclerAdapter == null) {
                p.btv("adapter");
            }
            wxRecyclerView.setAdapter(wxRecyclerAdapter);
        }
        WxRecyclerView wxRecyclerView2 = (WxRecyclerView) _$_findCachedViewById(R.id.ed5);
        if (wxRecyclerView2 != null) {
            getContext();
            wxRecyclerView2.setLayoutManager(new LinearLayoutManager(1, false));
        }
        WxRecyclerView wxRecyclerView3 = (WxRecyclerView) _$_findCachedViewById(R.id.ed5);
        if (wxRecyclerView3 != null) {
            wxRecyclerView3.b(new h());
        }
        WxRecyclerAdapter<b> wxRecyclerAdapter2 = this.tFp;
        if (wxRecyclerAdapter2 == null) {
            p.btv("adapter");
        }
        if (wxRecyclerAdapter2 != null) {
            wxRecyclerAdapter2.RqP = new i(this);
        }
        WxRecyclerAdapter<b> wxRecyclerAdapter3 = this.tFp;
        if (wxRecyclerAdapter3 == null) {
            p.btv("adapter");
        }
        if (wxRecyclerAdapter3 != null) {
            wxRecyclerAdapter3.RqO = new j(this);
        }
        ((WxRecyclerView) _$_findCachedViewById(R.id.ed5)).a(new k(this));
        ((RelativeLayout) _$_findCachedViewById(R.id.fv3)).setOnClickListener(new l(this));
        setTag(this);
        AppMethodBeat.o(257518);
    }

    public static final /* synthetic */ WxRecyclerAdapter c(MusicMvCommentView musicMvCommentView) {
        AppMethodBeat.i(257521);
        WxRecyclerAdapter<b> wxRecyclerAdapter = musicMvCommentView.tFp;
        if (wxRecyclerAdapter == null) {
            p.btv("adapter");
        }
        AppMethodBeat.o(257521);
        return wxRecyclerAdapter;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$Companion;", "", "()V", "MENU_ID_COPY", "", "MENU_ID_EXPOSE", "PADDING_EDGE_HEIGHT", "TAG", "", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(257520);
        AppMethodBeat.o(257520);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MusicMvCommentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(257519);
        AppMethodBeat.o(257519);
    }

    public final void setViewEventListener(com.tencent.mm.plugin.mv.ui.uic.a.a aVar) {
        AppMethodBeat.i(257514);
        p.h(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.AxK = aVar;
        AppMethodBeat.o(257514);
    }

    public final void aE(ArrayList<b> arrayList) {
        ArrayList<D> arrayList2;
        Long l2;
        Long l3;
        csk csk;
        csk csk2;
        AppMethodBeat.i(257515);
        p.h(arrayList, "lstConvertData");
        ArrayList arrayList3 = new ArrayList();
        Iterator<b> it = arrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            List<Long> list = this.xEG;
            d dVar = next.AxN;
            if (dVar == null || (csk2 = dVar.AxR) == null) {
                l2 = null;
            } else {
                l2 = Long.valueOf(csk2.dFm);
            }
            if (!list.contains(l2)) {
                List<Long> list2 = this.xEG;
                d dVar2 = next.AxN;
                if (dVar2 == null || (csk = dVar2.AxR) == null) {
                    l3 = null;
                } else {
                    l3 = Long.valueOf(csk.dFm);
                }
                list2.add(l3);
                arrayList3.add(next);
            }
        }
        if (!arrayList3.isEmpty()) {
            WxRecyclerAdapter<b> wxRecyclerAdapter = this.tFp;
            if (wxRecyclerAdapter == null) {
                p.btv("adapter");
            }
            if (!(wxRecyclerAdapter == null || (arrayList2 = wxRecyclerAdapter.data) == null)) {
                arrayList2.addAll(arrayList3);
            }
            WxRecyclerAdapter<b> wxRecyclerAdapter2 = this.tFp;
            if (wxRecyclerAdapter2 == null) {
                p.btv("adapter");
            }
            if (wxRecyclerAdapter2 != null) {
                wxRecyclerAdapter2.notifyDataSetChanged();
            }
            dcz();
        }
        AppMethodBeat.o(257515);
    }

    private final void dcz() {
        AppMethodBeat.i(257516);
        WxRecyclerAdapter<b> wxRecyclerAdapter = this.tFp;
        if (wxRecyclerAdapter == null) {
            p.btv("adapter");
        }
        if (wxRecyclerAdapter != null) {
            if (wxRecyclerAdapter.getItemCount() > 0) {
                WxRecyclerView wxRecyclerView = (WxRecyclerView) _$_findCachedViewById(R.id.ed5);
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(wxRecyclerAdapter.getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView, a2.axQ(), "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView", "smoothScrollToLastPosition", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                wxRecyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView", "smoothScrollToLastPosition", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            }
            AppMethodBeat.o(257516);
            return;
        }
        AppMethodBeat.o(257516);
    }

    public final void setMaxWidth(int i2) {
        AppMethodBeat.i(257517);
        if (i2 > 0) {
            FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.ed4);
            p.g(frameLayout, "liveCommentArea");
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            if (i2 > 0) {
                layoutParams.width = i2;
            }
        }
        AppMethodBeat.o(257517);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class e implements o.f {
        final /* synthetic */ MusicMvCommentView AxO;

        e(MusicMvCommentView musicMvCommentView) {
            this.AxO = musicMvCommentView;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(257505);
            p.g(mVar, "menu");
            if (mVar.gKQ()) {
                mVar.b(1, this.AxO.getContext().getString(R.string.f8n), 0);
                mVar.b(2, this.AxO.getContext().getString(R.string.f8p), 0);
            }
            AppMethodBeat.o(257505);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    static final class f implements o.g {
        final /* synthetic */ MusicMvCommentView AxO;
        final /* synthetic */ String rry;
        final /* synthetic */ long txv;
        final /* synthetic */ long vwa;

        f(MusicMvCommentView musicMvCommentView, String str, long j2, long j3) {
            this.AxO = musicMvCommentView;
            this.rry = str;
            this.txv = j2;
            this.vwa = j3;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(257506);
            p.g(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 1:
                    ClipboardHelper.setText(this.rry);
                    Toast.makeText(this.AxO.getContext(), (int) R.string.ta, 0).show();
                    AppMethodBeat.o(257506);
                    return;
                case 2:
                    com.tencent.mm.plugin.music.model.m.F(this.AxO.getContext(), com.tencent.mm.ac.d.zs(this.txv), com.tencent.mm.ac.d.zs(this.vwa));
                    break;
            }
            AppMethodBeat.o(257506);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-mv_release"})
    public static final class g implements com.tencent.mm.view.recyclerview.f {
        final /* synthetic */ MusicMvCommentView AxO;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(MusicMvCommentView musicMvCommentView) {
            this.AxO = musicMvCommentView;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(257507);
            Log.i("MicroMsg.MusicMvCommentView", "getItemConvert, type:".concat(String.valueOf(i2)));
            c cVar = new c();
            AppMethodBeat.o(257507);
            return cVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$2", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-mv_release"})
    public static final class h extends RecyclerView.h {
        h() {
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
            AppMethodBeat.i(257508);
            p.h(rect, "outRect");
            p.h(view, "view");
            p.h(recyclerView, "parent");
            p.h(sVar, "state");
            int bw = RecyclerView.bw(view);
            RecyclerView.a adapter = recyclerView.getAdapter();
            if (bw < (adapter != null ? adapter.getItemCount() : -1)) {
                rect.top = MusicMvCommentView.AxL;
                AppMethodBeat.o(257508);
                return;
            }
            rect.top = 0;
            AppMethodBeat.o(257508);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-mv_release"})
    public static final class i implements g.c<com.tencent.mm.view.recyclerview.h> {
        final /* synthetic */ MusicMvCommentView AxO;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(MusicMvCommentView musicMvCommentView) {
            this.AxO = musicMvCommentView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
        @Override // com.tencent.mm.view.recyclerview.g.c
        public final /* synthetic */ void a(RecyclerView.a<com.tencent.mm.view.recyclerview.h> aVar, View view, int i2, com.tencent.mm.view.recyclerview.h hVar) {
            d dVar;
            Long l;
            com.tencent.mm.plugin.mv.ui.uic.a.a aVar2;
            d dVar2;
            csk csk;
            String str = null;
            AppMethodBeat.i(257509);
            p.h(aVar, "adapter");
            p.h(view, "view");
            p.h(hVar, "holder");
            WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) aVar;
            if (i2 >= 0 || i2 < wxRecyclerAdapter.getItemCount()) {
                b bVar = (b) wxRecyclerAdapter.data.get(i2);
                if (bVar != null) {
                    dVar = bVar.AxN;
                } else {
                    dVar = null;
                }
                csk csk2 = dVar.AxR;
                if (csk2 != null) {
                    l = Long.valueOf(csk2.Mxv);
                } else {
                    l = null;
                }
                long longValue = l.longValue();
                b bVar2 = (b) wxRecyclerAdapter.data.get(i2);
                if (!(bVar2 == null || (dVar2 = bVar2.AxN) == null || (csk = dVar2.AxR) == null)) {
                    str = csk.LGs;
                }
                if (0 == longValue || (aVar2 = this.AxO.AxK) == null) {
                    AppMethodBeat.o(257509);
                    return;
                }
                p.g(str, "nonceId");
                aVar2.B(longValue, str);
                AppMethodBeat.o(257509);
                return;
            }
            Log.e("MicroMsg.MusicMvCommentView", "invalid position:".concat(String.valueOf(i2)));
            AppMethodBeat.o(257509);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$4", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemLongClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-mv_release"})
    public static final class j implements g.d<com.tencent.mm.view.recyclerview.h> {
        final /* synthetic */ MusicMvCommentView AxO;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        j(MusicMvCommentView musicMvCommentView) {
            this.AxO = musicMvCommentView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
        @Override // com.tencent.mm.view.recyclerview.g.d
        public final /* synthetic */ boolean b(RecyclerView.a<com.tencent.mm.view.recyclerview.h> aVar, View view, int i2, com.tencent.mm.view.recyclerview.h hVar) {
            d dVar;
            Long l;
            d dVar2;
            Long l2;
            d dVar3;
            AppMethodBeat.i(257510);
            p.h(aVar, "adapter");
            p.h(view, "view");
            p.h(hVar, "holder");
            WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) aVar;
            if (i2 >= 0 || i2 < wxRecyclerAdapter.getItemCount()) {
                b bVar = (b) wxRecyclerAdapter.data.get(i2);
                if (bVar != null) {
                    dVar = bVar.AxN;
                } else {
                    dVar = null;
                }
                csk csk = dVar.AxR;
                if (csk != null) {
                    l = Long.valueOf(csk.Mxv);
                } else {
                    l = null;
                }
                long longValue = l.longValue();
                b bVar2 = (b) wxRecyclerAdapter.data.get(i2);
                if (bVar2 != null) {
                    dVar2 = bVar2.AxN;
                } else {
                    dVar2 = null;
                }
                csk csk2 = dVar2.AxR;
                if (csk2 != null) {
                    l2 = Long.valueOf(csk2.dFm);
                } else {
                    l2 = null;
                }
                long longValue2 = l2.longValue();
                b bVar3 = (b) wxRecyclerAdapter.data.get(i2);
                if (bVar3 != null) {
                    dVar3 = bVar3.AxN;
                } else {
                    dVar3 = null;
                }
                csk csk3 = dVar3.AxR;
                String str = (csk3 != null ? csk3.Mxr : null).Mxp.text;
                if (0 != longValue) {
                    MusicMvCommentView musicMvCommentView = this.AxO;
                    p.g(str, "text");
                    p.h(str, "text");
                    com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(musicMvCommentView.getContext(), 1, false);
                    eVar.a(new e(musicMvCommentView));
                    eVar.a(new f(musicMvCommentView, str, longValue, longValue2));
                    eVar.dGm();
                }
                AppMethodBeat.o(257510);
                return true;
            }
            Log.e("MicroMsg.MusicMvCommentView", "invalid position:".concat(String.valueOf(i2)));
            AppMethodBeat.o(257510);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$5", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-mv_release"})
    public static final class k extends RecyclerView.l {
        final /* synthetic */ MusicMvCommentView AxO;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(257512);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(257512);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        k(MusicMvCommentView musicMvCommentView) {
            this.AxO = musicMvCommentView;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(257511);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            WxRecyclerView wxRecyclerView = (WxRecyclerView) this.AxO._$_findCachedViewById(R.id.ed5);
            p.g(wxRecyclerView, "liveCommentListRV");
            RecyclerView.LayoutManager layoutManager = wxRecyclerView.getLayoutManager();
            if (layoutManager == null) {
                t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(257511);
                throw tVar;
            }
            int ku = ((LinearLayoutManager) layoutManager).ku();
            MusicMvCommentView musicMvCommentView = this.AxO;
            musicMvCommentView.readCount = kotlin.k.j.mZ(ku, musicMvCommentView.readCount);
            if (ku == MusicMvCommentView.c(this.AxO).getItemCount() + -1) {
                MusicMvCommentView.d(this.AxO);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(257511);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class l implements View.OnClickListener {
        final /* synthetic */ MusicMvCommentView AxO;

        l(MusicMvCommentView musicMvCommentView) {
            this.AxO = musicMvCommentView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257513);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            MusicMvCommentView.d(this.AxO);
            if (this.AxO.kgc.size() > 0) {
                WxRecyclerView wxRecyclerView = (WxRecyclerView) this.AxO._$_findCachedViewById(R.id.ed5);
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.AxO.kgc.size() - 1, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView, a2.axQ(), "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$6", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
                wxRecyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$6", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257513);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J@\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConvertData;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "updateNickname", "nickname", "", "referInfoTv", "Landroid/widget/TextView;", "plugin-mv_release"})
    public final class c extends com.tencent.mm.view.recyclerview.e<b> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
        @Override // com.tencent.mm.view.recyclerview.e
        public final /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, b bVar, int i2, int i3, boolean z, List list) {
            String str;
            csk csk;
            csk csk2;
            csk csk3;
            csi csi;
            csk csk4;
            csi csi2;
            csl csl;
            AppMethodBeat.i(257503);
            b bVar2 = bVar;
            p.h(hVar, "holder");
            p.h(bVar2, "item");
            String str2 = bVar2.AxN.AxR.Mxt;
            TextView textView = (TextView) hVar.Mn(R.id.b8g);
            d dVar = bVar2.AxN;
            if (!(dVar == null || (csk3 = dVar.AxR) == null || (csi = csk3.Mxr) == null || 1 != csi.type)) {
                d dVar2 = bVar2.AxN;
                String str3 = (dVar2 == null || (csk4 = dVar2.AxR) == null || (csi2 = csk4.Mxr) == null || (csl = csi2.Mxp) == null) ? null : csl.text;
                if (str3 != null) {
                    com.tencent.mm.pluginsdk.ui.span.m mVar = new com.tencent.mm.pluginsdk.ui.span.m(com.tencent.mm.pluginsdk.ui.span.l.c(MusicMvCommentView.this.getContext(), str3));
                    String str4 = str2 + (char) 65306;
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) str4).append((CharSequence) mVar);
                    int length = str4.length();
                    if (length >= 0) {
                        Context context = MusicMvCommentView.this.getContext();
                        p.g(context, "context");
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.BW_100_Alpha_0_5)), 0, length, 33);
                        if (textView != null) {
                            textView.setText(spannableStringBuilder);
                        }
                    }
                    AppMethodBeat.o(257503);
                }
            }
            View Mn = hVar.Mn(R.id.bs7);
            TextView textView2 = (TextView) hVar.Mn(R.id.j38);
            if (textView2 != null) {
                textView2.setOnClickListener(new a(this, bVar2));
            }
            d dVar3 = bVar2.AxN;
            if (!Util.isNullOrNil((dVar3 == null || (csk2 = dVar3.AxR) == null) ? null : csk2.Mxw)) {
                if (Mn != null) {
                    Mn.setVisibility(0);
                }
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                d dVar4 = bVar2.AxN;
                if (dVar4 == null || (csk = dVar4.AxR) == null) {
                    str = null;
                } else {
                    str = csk.Mxw;
                }
                p.g(str, "item.commentItemData?.msgPack?.mv_post_nickname");
                p.g(textView2, "referInfoTv");
                Context context2 = MusicMvCommentView.this.getContext();
                p.g(context2, "context");
                String str5 = str + "的音乐视频";
                String str6 = String.valueOf(context2.getResources().getString(R.string.f7w)) + ' ' + str5;
                int g2 = n.g(str6, str5);
                if (g2 >= 0) {
                    int length2 = g2 + str5.length();
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str6);
                    spannableStringBuilder2.setSpan(new ForegroundColorSpan(Color.parseColor("#FF7D90A9")), g2, length2, 18);
                    textView2.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(MusicMvCommentView.this.getContext()));
                    textView2.setClickable(true);
                    textView2.setText(spannableStringBuilder2);
                }
                AppMethodBeat.o(257503);
                return;
            }
            if (Mn != null) {
                Mn.setVisibility(8);
            }
            if (textView2 != null) {
                textView2.setVisibility(8);
                AppMethodBeat.o(257503);
                return;
            }
            AppMethodBeat.o(257503);
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final int getLayoutId() {
            return R.layout.be5;
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.h hVar, int i2) {
            AppMethodBeat.i(257502);
            p.h(recyclerView, "recyclerView");
            p.h(hVar, "holder");
            AppMethodBeat.o(257502);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ c AxP;
            final /* synthetic */ b AxQ;

            a(c cVar, b bVar) {
                this.AxP = cVar;
                this.AxQ = bVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(257501);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConverter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                long j2 = this.AxQ.AxN.AxR.Mxv;
                String str = this.AxQ.AxN.AxR.LGs;
                com.tencent.mm.plugin.mv.ui.uic.a.a aVar = MusicMvCommentView.this.AxK;
                if (aVar != null) {
                    p.g(str, "nonceId");
                    aVar.B(j2, str);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConverter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(257501);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentItemData;", "", "msgPack", "Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;)V", "getMsgPack", "()Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;", "setMsgPack", "plugin-mv_release"})
    public static final class d {
        csk AxR;

        public d(csk csk) {
            p.h(csk, "msgPack");
            AppMethodBeat.i(257504);
            this.AxR = csk;
            AppMethodBeat.o(257504);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "commentItemData", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentItemData;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentItemData;)V", "getCommentItemData", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentItemData;", "getItemId", "", "getItemType", "", "plugin-mv_release"})
    public static final class b implements com.tencent.mm.view.recyclerview.a {
        final d AxN;

        public b(d dVar) {
            p.h(dVar, "commentItemData");
            AppMethodBeat.i(257500);
            this.AxN = dVar;
            AppMethodBeat.o(257500);
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final long lT() {
            AppMethodBeat.i(257499);
            long hashCode = (long) this.AxN.hashCode();
            AppMethodBeat.o(257499);
            return hashCode;
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final int cxn() {
            return 2;
        }
    }

    public static final /* synthetic */ void d(MusicMvCommentView musicMvCommentView) {
        AppMethodBeat.i(257522);
        RelativeLayout relativeLayout = (RelativeLayout) musicMvCommentView._$_findCachedViewById(R.id.fv3);
        p.g(relativeLayout, "newTipGroupRL");
        relativeLayout.setVisibility(8);
        AppMethodBeat.o(257522);
    }
}
