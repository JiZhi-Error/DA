package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.gallery.ui.c;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 i2\u00020\u00012\u00020\u0002:\u0006ijklmnB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rJ\u000e\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020/J\u000e\u0010V\u001a\u00020T2\u0006\u0010@\u001a\u00020AJ\u0006\u0010W\u001a\u00020TJ\b\u0010X\u001a\u00020\nH\u0016J\b\u0010Y\u001a\u00020TH\u0002J\b\u0010Z\u001a\u00020TH\u0016J\u0006\u0010[\u001a\u00020TJ,\u0010\\\u001a\u00020T2\u0006\u0010]\u001a\u00020\n2\u0006\u0010^\u001a\u00020\n2\b\u0010_\u001a\u0004\u0018\u00010)2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\u0010\u0010b\u001a\u00020T2\b\u0010.\u001a\u0004\u0018\u00010cJ\u000e\u0010d\u001a\u00020T2\u0006\u0010e\u001a\u00020\nJ\u000e\u0010f\u001a\u00020T2\u0006\u0010g\u001a\u00020\nJ\u001c\u0010h\u001a\u00020T2\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0016j\b\u0012\u0004\u0012\u00020\u0010`\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020 0\u0016j\b\u0012\u0004\u0012\u00020 `\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020GX.¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010L\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u000e\u0010Q\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006o"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "emptyLL", "getEmptyLL", "()Landroid/widget/LinearLayout;", "setEmptyLL", "(Landroid/widget/LinearLayout;)V", "feedIdMap", "", "getFeedIdMap", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "keyword", "", "getKeyword", "()Ljava/lang/String;", "setKeyword", "(Ljava/lang/String;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentItemClickedListener;", "getListener", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentItemClickedListener;", "setListener", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentItemClickedListener;)V", "loadingTv", "Landroid/widget/TextView;", "getLoadingTv", "()Landroid/widget/TextView;", "setLoadingTv", "(Landroid/widget/TextView;)V", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "getMusic", "()Lcom/tencent/mm/plugin/music/model/storage/Music;", "setMusic", "(Lcom/tencent/mm/plugin/music/model/storage/Music;)V", "resultListener", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentResultListener;", "getResultListener", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentResultListener;", "setResultListener", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentResultListener;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "screenWidth", "getScreenWidth", "()I", "setScreenWidth", "(I)V", "videoMaxDurationMs", "videoMinDurationMs", "addItemClickedListener", "", "itemClickedListener", "addResultCountListener", "clear", "getFeedFrom", "initContentView", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setOnFlingListener", "Landroid/support/v7/widget/RecyclerView$OnFlingListener;", "setResultView", "visibility", "setVideoDuration", "videoMinDuration", "syncGetFeeds", "Companion", "FragmentItemClickedListener", "FragmentResultListener", "MusicFeedsConvertData", "MusicFeedsConverter", "MusicFeedsItemData", "plugin-mv_release"})
public class MusicMvTabFragment extends LinearLayout implements com.tencent.mm.ak.i {
    public static final a Azh = new a((byte) 0);
    private com.tencent.mm.plugin.music.model.e.a AkC;
    private int ArJ = 10001;
    private int ArK = Integer.MAX_VALUE;
    private final ArrayList<Long> Azd = new ArrayList<>();
    private b Aze;
    public c Azf;
    private LinearLayout Azg;
    private TextView Vau;
    private HashMap _$_findViewCache;
    private String dDv;
    private boolean hasMore;
    private final ArrayList<d> kgc = new ArrayList<>();
    private int mEX;
    protected WxRecyclerAdapter<d> tFp;
    protected RefreshLoadMoreLayout tLS;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentItemClickedListener;", "", "onItemClicked", "", "errType", "", "data", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "position", "itemView", "Landroid/view/View;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-mv_release"})
    public interface b {
        void a(f fVar, View view, RecyclerView recyclerView);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentResultListener;", "", "onCountResult", "", "type", "", "cnt", "plugin-mv_release"})
    public interface c {
        void hx(int i2, int i3);
    }

    static {
        AppMethodBeat.i(257682);
        AppMethodBeat.o(257682);
    }

    public View ewN() {
        AppMethodBeat.i(257683);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf((int) R.id.fps));
        if (view == null) {
            view = findViewById(R.id.fps);
            this._$_findViewCache.put(Integer.valueOf((int) R.id.fps), view);
        }
        AppMethodBeat.o(257683);
        return view;
    }

    /* access modifiers changed from: protected */
    public final ArrayList<d> getDataList() {
        return this.kgc;
    }

    /* access modifiers changed from: protected */
    public final ArrayList<Long> getFeedIdMap() {
        return this.Azd;
    }

    /* access modifiers changed from: protected */
    public final WxRecyclerAdapter<d> getAdapter() {
        AppMethodBeat.i(257669);
        WxRecyclerAdapter<d> wxRecyclerAdapter = this.tFp;
        if (wxRecyclerAdapter == null) {
            p.btv("adapter");
        }
        AppMethodBeat.o(257669);
        return wxRecyclerAdapter;
    }

    /* access modifiers changed from: protected */
    public final void setAdapter(WxRecyclerAdapter<d> wxRecyclerAdapter) {
        AppMethodBeat.i(257670);
        p.h(wxRecyclerAdapter, "<set-?>");
        this.tFp = wxRecyclerAdapter;
        AppMethodBeat.o(257670);
    }

    /* access modifiers changed from: protected */
    public final com.tencent.mm.plugin.music.model.e.a getMusic() {
        return this.AkC;
    }

    /* access modifiers changed from: protected */
    public final void setMusic(com.tencent.mm.plugin.music.model.e.a aVar) {
        this.AkC = aVar;
    }

    /* access modifiers changed from: protected */
    public final String getKeyword() {
        return this.dDv;
    }

    /* access modifiers changed from: protected */
    public final void setKeyword(String str) {
        this.dDv = str;
    }

    /* access modifiers changed from: protected */
    public final b getListener() {
        return this.Aze;
    }

    /* access modifiers changed from: protected */
    public final void setListener(b bVar) {
        this.Aze = bVar;
    }

    /* access modifiers changed from: protected */
    public final c getResultListener() {
        return this.Azf;
    }

    /* access modifiers changed from: protected */
    public final void setResultListener(c cVar) {
        this.Azf = cVar;
    }

    /* access modifiers changed from: protected */
    public final LinearLayout getEmptyLL() {
        return this.Azg;
    }

    /* access modifiers changed from: protected */
    public final void setEmptyLL(LinearLayout linearLayout) {
        this.Azg = linearLayout;
    }

    /* access modifiers changed from: protected */
    public final TextView getLoadingTv() {
        return this.Vau;
    }

    /* access modifiers changed from: protected */
    public final void setLoadingTv(TextView textView) {
        this.Vau = textView;
    }

    /* access modifiers changed from: protected */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    /* access modifiers changed from: protected */
    public final void setHasMore(boolean z) {
        this.hasMore = z;
    }

    /* access modifiers changed from: protected */
    public final int getScreenWidth() {
        return this.mEX;
    }

    /* access modifiers changed from: protected */
    public final void setScreenWidth(int i2) {
        this.mEX = i2;
    }

    /* access modifiers changed from: protected */
    public final RefreshLoadMoreLayout getRlLayout() {
        AppMethodBeat.i(257671);
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        AppMethodBeat.o(257671);
        return refreshLoadMoreLayout;
    }

    /* access modifiers changed from: protected */
    public final void setRlLayout(RefreshLoadMoreLayout refreshLoadMoreLayout) {
        AppMethodBeat.i(257672);
        p.h(refreshLoadMoreLayout, "<set-?>");
        this.tLS = refreshLoadMoreLayout;
        AppMethodBeat.o(257672);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMvTabFragment(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(257679);
        LayoutInflater.from(getContext()).inflate(R.layout.bej, (ViewGroup) this, true);
        initContentView();
        AppMethodBeat.o(257679);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMvTabFragment(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(257680);
        LayoutInflater.from(getContext()).inflate(R.layout.bej, (ViewGroup) this, true);
        initContentView();
        AppMethodBeat.o(257680);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMvTabFragment(Context context, AttributeSet attributeSet, int i2, byte b2) {
        super(context, attributeSet, i2, 0);
        p.h(context, "context");
        AppMethodBeat.i(257681);
        LayoutInflater.from(getContext()).inflate(R.layout.bej, (ViewGroup) this, true);
        initContentView();
        Resources resources = context.getResources();
        p.g(resources, "context.resources");
        this.mEX = resources.getDisplayMetrics().widthPixels;
        AppMethodBeat.o(257681);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$Companion;", "", "()V", "SPAN_COUNT", "", "TAG", "", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void a(b bVar) {
        AppMethodBeat.i(257673);
        p.h(bVar, "itemClickedListener");
        this.Aze = bVar;
        AppMethodBeat.o(257673);
    }

    public final void setVideoDuration(int i2) {
        AppMethodBeat.i(257674);
        this.ArJ = i2;
        WxRecyclerAdapter<d> wxRecyclerAdapter = this.tFp;
        if (wxRecyclerAdapter == null) {
            p.btv("adapter");
        }
        wxRecyclerAdapter.notifyDataSetChanged();
        AppMethodBeat.o(257674);
    }

    public void a(com.tencent.mm.plugin.music.model.e.a aVar, String str) {
        this.AkC = aVar;
        this.dDv = str;
    }

    public final void clear() {
        AppMethodBeat.i(257675);
        this.kgc.clear();
        WxRecyclerAdapter<d> wxRecyclerAdapter = this.tFp;
        if (wxRecyclerAdapter == null) {
            p.btv("adapter");
        }
        wxRecyclerAdapter.notifyDataSetChanged();
        AppMethodBeat.o(257675);
    }

    public void onDestroy() {
    }

    public final void setResultView(int i2) {
        AppMethodBeat.i(257676);
        WxRecyclerView wxRecyclerView = (WxRecyclerView) ewN();
        if (wxRecyclerView != null) {
            wxRecyclerView.setVisibility(i2);
            AppMethodBeat.o(257676);
            return;
        }
        AppMethodBeat.o(257676);
    }

    private final void initContentView() {
        AppMethodBeat.i(257677);
        this.Azg = (LinearLayout) findViewById(R.id.c37);
        this.Vau = (TextView) findViewById(R.id.epw);
        View findViewById = findViewById(R.id.ige);
        p.g(findViewById, "findViewById(R.id.tab_rl_layout)");
        this.tLS = (RefreshLoadMoreLayout) findViewById;
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        refreshLoadMoreLayout.setEnablePullDownHeader(false);
        RefreshLoadMoreLayout refreshLoadMoreLayout2 = this.tLS;
        if (refreshLoadMoreLayout2 == null) {
            p.btv("rlLayout");
        }
        refreshLoadMoreLayout2.setEnableRefresh(false);
        RefreshLoadMoreLayout refreshLoadMoreLayout3 = this.tLS;
        if (refreshLoadMoreLayout3 == null) {
            p.btv("rlLayout");
        }
        refreshLoadMoreLayout3.setActionCallback(new g(this));
        this.tFp = new WxRecyclerAdapter<>(new h(this), this.kgc, true);
        WxRecyclerView wxRecyclerView = (WxRecyclerView) ewN();
        if (wxRecyclerView != null) {
            WxRecyclerAdapter<d> wxRecyclerAdapter = this.tFp;
            if (wxRecyclerAdapter == null) {
                p.btv("adapter");
            }
            wxRecyclerView.setAdapter(wxRecyclerAdapter);
        }
        FirstRowLayoutManager firstRowLayoutManager = new FirstRowLayoutManager(getContext(), 3);
        WxRecyclerView wxRecyclerView2 = (WxRecyclerView) ewN();
        if (wxRecyclerView2 != null) {
            wxRecyclerView2.setLayoutManager(firstRowLayoutManager);
        }
        com.tencent.mm.plugin.gallery.ui.c dSf = new c.a(getContext()).NP(R.dimen.af2).NO(R.dimen.af2).dSd().dSe().dSf();
        WxRecyclerView wxRecyclerView3 = (WxRecyclerView) ewN();
        if (wxRecyclerView3 != null) {
            wxRecyclerView3.b(dSf);
        }
        WxRecyclerAdapter<d> wxRecyclerAdapter2 = this.tFp;
        if (wxRecyclerAdapter2 == null) {
            p.btv("adapter");
        }
        wxRecyclerAdapter2.RqP = new i(this);
        AppMethodBeat.o(257677);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-mv_release"})
    public static final class g extends RefreshLoadMoreLayout.a {
        final /* synthetic */ MusicMvTabFragment Azl;

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(257665);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            super.ED(i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(257665);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(257666);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.onRefreshEnd(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(257666);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(MusicMvTabFragment musicMvTabFragment) {
            this.Azl = musicMvTabFragment;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            AppMethodBeat.i(257663);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            Log.i("Music.MusicMvTabFragment", "onLoadMoreBegin");
            if (this.Azl.getHasMore()) {
                this.Azl.a(this.Azl.getMusic(), this.Azl.getKeyword());
            } else {
                this.Azl.getRlLayout().apT(0);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(257663);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(257664);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            p.h(cVar, "reason");
            if (!this.Azl.getHasMore()) {
                RefreshLoadMoreLayout.e(this.Azl.getRlLayout());
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(257664);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void IF(int i2) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-mv_release"})
    public static final class h implements com.tencent.mm.view.recyclerview.f {
        final /* synthetic */ MusicMvTabFragment Azl;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(MusicMvTabFragment musicMvTabFragment) {
            this.Azl = musicMvTabFragment;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(257667);
            Log.i("Music.MusicMvTabFragment", "getItemConvert, type:".concat(String.valueOf(i2)));
            e eVar = new e();
            AppMethodBeat.o(257667);
            return eVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-mv_release"})
    public static final class i implements g.c<com.tencent.mm.view.recyclerview.h> {
        final /* synthetic */ MusicMvTabFragment Azl;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(MusicMvTabFragment musicMvTabFragment) {
            this.Azl = musicMvTabFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
        @Override // com.tencent.mm.view.recyclerview.g.c
        public final /* synthetic */ void a(RecyclerView.a<com.tencent.mm.view.recyclerview.h> aVar, View view, int i2, com.tencent.mm.view.recyclerview.h hVar) {
            f fVar;
            FinderObjectDesc finderObjectDesc;
            LinkedList<FinderMedia> linkedList;
            FinderMedia finderMedia;
            AppMethodBeat.i(257668);
            p.h(aVar, "adapter");
            p.h(view, "view");
            p.h(hVar, "holder");
            WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) aVar;
            if (i2 >= 0 || i2 < wxRecyclerAdapter.getItemCount()) {
                d dVar = (d) j.L(wxRecyclerAdapter.data, i2);
                if (dVar == null || (fVar = dVar.Azi) == null) {
                    AppMethodBeat.o(257668);
                    return;
                }
                FinderObject finderObject = fVar.feedObject;
                if (finderObject == null || (finderObjectDesc = finderObject.objectDesc) == null || (linkedList = finderObjectDesc.media) == null || (finderMedia = (FinderMedia) j.kt(linkedList)) == null) {
                    AppMethodBeat.o(257668);
                } else if (finderMedia.videoDuration < com.tencent.mm.plugin.mv.ui.a.e.Tl(this.Azl.ArJ)) {
                    Log.i("Music.MusicMvTabFragment", "post fail, duration:" + finderMedia.videoDuration);
                    u.cE(this.Azl.getContext(), this.Azl.getContext().getString(R.string.dnb, Integer.valueOf(com.tencent.mm.plugin.mv.ui.a.e.Tl(this.Azl.ArJ))));
                    AppMethodBeat.o(257668);
                } else if (finderMedia.videoDuration > com.tencent.mm.plugin.mv.ui.a.e.Tn(this.Azl.ArK)) {
                    Log.i("Music.MusicMvTabFragment", "post fail, duration:" + finderMedia.videoDuration);
                    u.cE(this.Azl.getContext(), this.Azl.getContext().getString(R.string.dnc, Integer.valueOf(com.tencent.mm.plugin.mv.ui.a.e.Tn(this.Azl.ArK))));
                    AppMethodBeat.o(257668);
                } else {
                    Log.i("Music.MusicMvTabFragment", "post feedId:".concat(String.valueOf(com.tencent.mm.ac.d.zs(fVar.feedId))));
                    com.tencent.mm.plugin.mv.a.l lVar = com.tencent.mm.plugin.mv.a.l.UZs;
                    com.tencent.mm.plugin.mv.a.l.axb(i2);
                    com.tencent.mm.plugin.mv.a.l lVar2 = com.tencent.mm.plugin.mv.a.l.UZs;
                    com.tencent.mm.plugin.mv.a.l.axc(this.Azl.getFeedFrom());
                    b listener = this.Azl.getListener();
                    if (listener != null) {
                        WxRecyclerView wxRecyclerView = (WxRecyclerView) this.Azl.ewN();
                        p.g(wxRecyclerView, "musicFeedsRecyclerView");
                        listener.a(fVar, view, wxRecyclerView);
                        AppMethodBeat.o(257668);
                        return;
                    }
                    AppMethodBeat.o(257668);
                }
            } else {
                Log.e("Music.MusicMvTabFragment", "invalid position:".concat(String.valueOf(i2)));
                AppMethodBeat.o(257668);
            }
        }
    }

    public final void setOnFlingListener(RecyclerView.j jVar) {
        AppMethodBeat.i(257678);
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
        if (refreshLoadMoreLayout == null) {
            p.btv("rlLayout");
        }
        refreshLoadMoreLayout.getRecyclerView().setOnFlingListener(jVar);
        AppMethodBeat.o(257678);
    }

    public int getFeedFrom() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0016J@\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0016J \u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsConvertData;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;)V", "MEDIA_MAX_HEIGHT_RATIO", "", "MEDIA_MIN_HEIGHT_RATIO", "calculateStaggeredLayoutParams", "", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "originWidth", "formatVideoPlayTime", "", "time", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-mv_release"})
    public final class e extends com.tencent.mm.view.recyclerview.e<d> {
        private final float Azj = 1.3166667f;
        private final float Azk = 0.95f;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public e() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
        @Override // com.tencent.mm.view.recyclerview.e
        public final /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, d dVar, int i2, int i3, boolean z, List list) {
            LinkedList<FinderMedia> linkedList;
            FinderMedia finderMedia;
            String str;
            String str2;
            AppMethodBeat.i(257662);
            d dVar2 = dVar;
            p.h(hVar, "holder");
            p.h(dVar2, "item");
            Log.d("Music.MusicMvTabFragment", "onBindViewHolder " + dVar2.Azi.feedId + ' ' + dVar2.Azi.feedObject);
            FinderObject finderObject = dVar2.Azi.feedObject;
            if (finderObject != null) {
                FinderObjectDesc finderObjectDesc = finderObject.objectDesc;
                if (finderObjectDesc == null || (linkedList = finderObjectDesc.media) == null || (finderMedia = (FinderMedia) j.kt(linkedList)) == null) {
                    AppMethodBeat.o(257662);
                    return;
                }
                c.a aVar = new c.a();
                com.tencent.mm.plugin.music.model.g gVar = com.tencent.mm.plugin.music.model.g.Aku;
                aVar.OS(com.tencent.mm.plugin.music.model.g.aHP("thumb_" + dVar2.Azi.feedId));
                aVar.bdp();
                aVar.bdo();
                String str3 = finderMedia.thumbUrl + finderMedia.thumb_url_token;
                Log.d("Music.MusicMvTabFragment", dVar2.Azi.feedId + " thumb load " + str3);
                q.bcV().a(str3, (ImageView) hVar.Mn(R.id.j6n), aVar.bdv());
                ImageView imageView = (ImageView) hVar.Mn(R.id.j5c);
                if (finderMedia.videoDuration < com.tencent.mm.plugin.mv.ui.a.e.Tl(MusicMvTabFragment.this.ArJ) || finderMedia.videoDuration > com.tencent.mm.plugin.mv.ui.a.e.Tn(MusicMvTabFragment.this.ArK)) {
                    imageView.setBackgroundColor(com.tencent.mm.cb.a.n(MusicMvTabFragment.this.getContext(), R.color.ad));
                } else {
                    imageView.setBackgroundResource(R.drawable.ali);
                }
                TextView textView = (TextView) hVar.Mn(R.id.j4n);
                if (textView != null) {
                    int i4 = finderMedia.videoDuration;
                    if (i4 <= 0 || ((long) i4) >= 86400) {
                        str = null;
                    } else {
                        if (((long) i4) < 3600) {
                            str2 = "mm:ss";
                        } else {
                            str2 = "HH:mm:ss";
                        }
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2);
                        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
                        str = simpleDateFormat.format(Long.valueOf(((long) i4) * 1000));
                    }
                    textView.setText(str);
                    AppMethodBeat.o(257662);
                    return;
                }
                AppMethodBeat.o(257662);
                return;
            }
            AppMethodBeat.o(257662);
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final int getLayoutId() {
            return R.layout.be7;
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.h hVar, int i2) {
            ViewGroup.LayoutParams layoutParams;
            ViewGroup.LayoutParams layoutParams2;
            AppMethodBeat.i(257661);
            p.h(recyclerView, "recyclerView");
            p.h(hVar, "holder");
            int screenWidth = (MusicMvTabFragment.this.getScreenWidth() - com.tencent.mm.cb.a.fromDPToPix(MusicMvTabFragment.this.getContext(), 4)) / 3;
            RelativeLayout relativeLayout = (RelativeLayout) hVar.Mn(R.id.h8y);
            if (!(relativeLayout == null || (layoutParams2 = relativeLayout.getLayoutParams()) == null)) {
                layoutParams2.width = screenWidth;
            }
            if (relativeLayout == null || (layoutParams = relativeLayout.getLayoutParams()) == null) {
                AppMethodBeat.o(257661);
                return;
            }
            layoutParams.height = screenWidth;
            AppMethodBeat.o(257661);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "", "feedId", "", "nonceId", "", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(JLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getFeedId", "()J", "setFeedId", "(J)V", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getNonceId", "()Ljava/lang/String;", "setNonceId", "(Ljava/lang/String;)V", "plugin-mv_release"})
    public static final class f {
        long feedId;
        public FinderObject feedObject;
        private String hwg;

        public f(long j2, String str, FinderObject finderObject) {
            this.feedId = j2;
            this.hwg = str;
            this.feedObject = finderObject;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "itemData", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;)V", "getItemData", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "getItemId", "", "getItemType", "", "plugin-mv_release"})
    public static final class d implements com.tencent.mm.view.recyclerview.a {
        final f Azi;

        public d(f fVar) {
            p.h(fVar, "itemData");
            AppMethodBeat.i(257660);
            this.Azi = fVar;
            AppMethodBeat.o(257660);
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final long lT() {
            AppMethodBeat.i(257659);
            long hashCode = (long) this.Azi.hashCode();
            AppMethodBeat.o(257659);
            return hashCode;
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final int cxn() {
            return 3;
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
    }
}
