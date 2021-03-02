package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.bb;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.ag;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.upload.action.g;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.r;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.ayu;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020,2\u0006\u00100\u001a\u00020\fH\u0002J\b\u00101\u001a\u00020,H\u0002J\b\u00102\u001a\u00020,H\u0002J$\u00103\u001a\u00020,2\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u00020\u0013H\u0016J\b\u00109\u001a\u00020,H\u0016J\b\u0010:\u001a\u00020,H\u0016J\u0018\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u00020\fH\u0002J\u001a\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u000105H\u0016J\b\u0010B\u001a\u00020,H\u0016J\u0010\u0010C\u001a\u00020,2\b\b\u0002\u0010D\u001a\u00020\fR\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0010\u0010\u0016\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\u001e\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "DIMISS_FOLLOWED_BTN", "", "PORTRAIT_ACTION_GOTO_PROFILE", "", "getPORTRAIT_ACTION_GOTO_PROFILE", "()Ljava/lang/String;", "PORTRAIT_ACTION_KEY_FINDER_USERNAME", "getPORTRAIT_ACTION_KEY_FINDER_USERNAME", "SHOW_FOLLOW_BTN", "SHOW_FOLLOW_BTN_DELAY", "", "TAG", "getTAG", "anchorAvatarUrl", "anchorNickname", "authIv", "Landroid/widget/ImageView;", "avatarIcon", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "followBtn", "Landroid/widget/TextView;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "value", "mNavigatorHeight", "setMNavigatorHeight", "(I)V", "nameTv", "adjustMarginEnd", "", "canClearScreen", "", "doBlockOpLog", ch.COL_USERNAME, "goToAnchorFinderProfile", "initFollowBtn", "onPortraitDelayAction", "extraMsg", "Landroid/os/Bundle;", "extraData", "", "delayMs", "reset", "resume", "setFollowBtnState", "isFollow", "source", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "unMount", "updateLiveTitle", "anchorUsername", "plugin-finder_release"})
public final class bh extends d {
    final String TAG;
    private final String ULy;
    final TextView UMZ;
    final int UNa;
    final int UNb;
    private final long UNc;
    Context context;
    final TextView gxs;
    final com.tencent.mm.live.c.b hOp;
    private int hOw;
    final ImageView hXu;
    private final kotlin.f lhN;
    private final ImageView uuc;
    private String uud;
    private String uue;
    private final String uuf;

    /* access modifiers changed from: package-private */
    public final MMHandler bkj() {
        AppMethodBeat.i(260731);
        MMHandler mMHandler = (MMHandler) this.lhN.getValue();
        AppMethodBeat.o(260731);
        return mMHandler;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u00072\u000e\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
    public static final class d<T, R> implements com.tencent.mm.loader.f.e<o, Bitmap> {
        final /* synthetic */ bh uuh;

        d(bh bhVar) {
            this.uuh = bhVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.e.b.g, java.lang.Object] */
        @Override // com.tencent.mm.loader.f.e
        public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a<o> aVar, com.tencent.mm.loader.e.b.g gVar, Bitmap bitmap) {
            AppMethodBeat.i(247058);
            final Bitmap bitmap2 = bitmap;
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.bh.d.AnonymousClass1 */
                final /* synthetic */ d uui;

                {
                    this.uui = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(247057);
                    if (bitmap2 != null) {
                        this.uui.uuh.hXu.setImageBitmap(BitmapUtil.getRoundedCornerBitmap(bitmap2, false, ((float) bitmap2.getWidth()) / 2.0f));
                    } else {
                        ImageView imageView = this.uui.uuh.hXu;
                        Context context = this.uui.uuh.context;
                        p.g(context, "context");
                        imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.bcd));
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(247057);
                    return xVar;
                }
            });
            AppMethodBeat.o(247058);
        }
    }

    public /* synthetic */ bh(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        this(viewGroup, bVar, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bh(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar, bbn bbn) {
        super(viewGroup, bVar, bbn);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(247065);
        this.hOp = bVar;
        this.TAG = "Finder.LiveTitlePlugin";
        this.uuf = "PORTRAIT_ACTION_GOTO_PROFILE_TITLE";
        this.ULy = "PORTRAIT_ACTION_KEY_FINDER_USERNAME";
        this.context = viewGroup.getContext();
        View findViewById = viewGroup.findViewById(R.id.emh);
        p.g(findViewById, "root.findViewById(R.id.l…e_title_info_avatar_icon)");
        this.hXu = (ImageView) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.emj);
        p.g(findViewById2, "root.findViewById(R.id.live_title_info_name_tv)");
        this.gxs = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.emk);
        p.g(findViewById3, "root.findViewById(R.id.live_title_info_tag_iv)");
        this.uuc = (ImageView) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.k08);
        p.g(findViewById4, "root.findViewById(R.id.live_follow_btn)");
        this.UMZ = (TextView) findViewById4;
        this.hOw = au.aD(viewGroup.getContext());
        this.UNa = 1;
        this.UNb = 2;
        this.UNc = Util.MILLSECONDS_OF_MINUTE;
        this.lhN = kotlin.g.ah(new e(this));
        b bVar2 = new b(this);
        this.hXu.setOnClickListener(bVar2);
        ImageView imageView = this.hXu;
        Context context2 = this.context;
        p.g(context2, "context");
        imageView.setImageDrawable(context2.getResources().getDrawable(R.drawable.bcd));
        this.gxs.setOnClickListener(bVar2);
        m mVar = m.vVH;
        m.a((d) this, true);
        m mVar2 = m.vVH;
        m.a(this);
        a(this);
        this.gxs.postDelayed(new Runnable(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.bh.AnonymousClass1 */
            final /* synthetic */ bh uuh;

            {
                this.uuh = r1;
            }

            public final void run() {
                AppMethodBeat.i(260722);
                bh.c(this.uuh);
                AppMethodBeat.o(260722);
            }
        }, 1000);
        AppMethodBeat.o(247065);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
    static final class e extends q implements kotlin.g.a.a<MMHandler> {
        final /* synthetic */ bh uuh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(bh bhVar) {
            super(0);
            this.uuh = bhVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
        static final class a implements MMHandler.Callback {
            final /* synthetic */ e UNd;

            a(e eVar) {
                this.UNd = eVar;
            }

            public final boolean handleMessage(Message message) {
                AppMethodBeat.i(260724);
                int i2 = message.what;
                if (i2 == this.UNd.uuh.UNb) {
                    this.UNd.uuh.UMZ.setVisibility(8);
                } else if (i2 == this.UNd.uuh.UNa) {
                    g.a aVar = com.tencent.mm.plugin.finder.upload.action.g.vUn;
                    boolean asJ = com.tencent.mm.plugin.finder.upload.action.g.vUm.asJ(this.UNd.uuh.getLiveData().hwd);
                    Log.i(this.UNd.uuh.TAG, "has been look for one min ,isFollow".concat(String.valueOf(asJ)));
                    this.UNd.uuh.X(asJ, "#3");
                    Long valueOf = Long.valueOf(this.UNd.uuh.getLiveData().liveInfo.liveId);
                    Long l = (valueOf.longValue() > 0 ? 1 : (valueOf.longValue() == 0 ? 0 : -1)) != 0 ? valueOf : null;
                    if (l != null) {
                        long longValue = l.longValue();
                        g.a aVar2 = com.tencent.mm.plugin.finder.live.viewmodel.g.uFg;
                        com.tencent.mm.plugin.finder.live.viewmodel.g.UQr.put(Long.valueOf(longValue), Boolean.TRUE);
                    }
                }
                AppMethodBeat.o(260724);
                return true;
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MMHandler invoke() {
            AppMethodBeat.i(260725);
            MMHandler mMHandler = new MMHandler(Looper.getMainLooper(), new a(this));
            mMHandler.setLogging(false);
            AppMethodBeat.o(260725);
            return mMHandler;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ bh uuh;

        b(bh bhVar) {
            this.uuh = bhVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(247055);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin$avatarClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            b.a aVar = com.tencent.mm.live.core.core.d.b.hCo;
            if (b.a.aDp()) {
                bh.b(this.uuh);
                if (this.uuh.hOp.getLiveRole() == 0) {
                    com.tencent.mm.plugin.finder.report.live.m.vli.hUI();
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin$avatarClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(247055);
        }
    }

    /* access modifiers changed from: package-private */
    public final void X(boolean z, String str) {
        AppMethodBeat.i(260732);
        Log.i(this.TAG, "[setFollowBtnState] source:" + str + ", isFollow:" + z);
        this.gxs.getViewTreeObserver().addOnGlobalLayoutListener(new g(this, this.UMZ.getVisibility() == 8 ? at.fromDPToPix(this.hwr.getContext(), 30) : 0));
        this.UMZ.setVisibility(0);
        if (this.hOp.getLiveRole() == 0) {
            com.tencent.mm.plugin.finder.report.live.m.vli.a(s.bd.EXPOSE);
        }
        this.UMZ.post(new h(this));
        if (!z) {
            this.UMZ.setBackground(this.hwr.getContext().getDrawable(R.drawable.cur));
            this.UMZ.setText(this.context.getString(R.string.j_n));
            TextView textView = this.UMZ;
            Context context2 = this.hwr.getContext();
            p.g(context2, "root.context");
            textView.setTextColor(context2.getResources().getColor(R.color.am));
            this.UMZ.setOnClickListener(new i(this));
            AppMethodBeat.o(260732);
            return;
        }
        this.UMZ.setText(this.context.getString(R.string.dzl));
        this.UMZ.setBackground(this.hwr.getContext().getDrawable(R.drawable.z6));
        TextView textView2 = this.UMZ;
        Context context3 = this.context;
        p.g(context3, "context");
        textView2.setTextColor(context3.getResources().getColor(R.color.v5));
        this.UMZ.setOnClickListener(new j(this));
        AppMethodBeat.o(260732);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin$setFollowBtnState$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder_release"})
    public static final class g implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ int UNe;
        final /* synthetic */ bh uuh;

        g(bh bhVar, int i2) {
            this.uuh = bhVar;
            this.UNe = i2;
        }

        public final void onGlobalLayout() {
            AppMethodBeat.i(260727);
            this.uuh.gxs.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (this.uuh.gxs.getWidth() > 0 && this.uuh.gxs.getWidth() > this.UNe * 4) {
                TextView textView = this.uuh.gxs;
                textView.setWidth(textView.getWidth() - this.UNe);
            }
            AppMethodBeat.o(260727);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class h implements Runnable {
        final /* synthetic */ bh uuh;

        h(bh bhVar) {
            this.uuh = bhVar;
        }

        public final void run() {
            AppMethodBeat.i(260728);
            Rect rect = new Rect();
            this.uuh.UMZ.getHitRect(rect);
            rect.inset(rect.width() * -2, -rect.width());
            ViewParent parent = this.uuh.UMZ.getParent();
            if (parent == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(260728);
                throw tVar;
            }
            ((View) parent).setTouchDelegate(new TouchDelegate(rect, this.uuh.UMZ));
            AppMethodBeat.o(260728);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class i implements View.OnClickListener {
        final /* synthetic */ bh uuh;

        i(bh bhVar) {
            this.uuh = bhVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(260729);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin$setFollowBtnState$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
            com.tencent.mm.plugin.finder.api.g asG = c.a.asG(this.uuh.getLiveData().hwd);
            if (asG != null) {
                y yVar = y.vXH;
                boolean i2 = y.i(asG);
                y yVar2 = y.vXH;
                boolean j2 = y.j(asG);
                Log.i(this.uuh.TAG, "followBtn click, nickName:" + asG.getNickname() + ", isPrivate:" + i2 + " , isBlock" + j2);
                ag agVar = ag.uOs;
                com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                Context context = this.uuh.hwr.getContext();
                p.g(context, "root.context");
                bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.ko(context).get(FinderReporterUIC.class)).dIx();
                String username = asG.getUsername();
                bb.a aVar3 = bb.tve;
                ag.a(dIx, username, bb.tvb, i2);
                if (j2) {
                    bh bhVar = this.uuh;
                    String username2 = asG.getUsername();
                    com.tencent.e.f.h.hkS();
                    ((r) com.tencent.mm.kernel.g.af(r.class)).a(username2, false, new a(bhVar));
                }
                this.uuh.X(true, "#4");
                this.uuh.bkj().sendEmptyMessageDelayed(this.uuh.UNb, 5000);
                com.tencent.mm.plugin.finder.report.live.m.vli.a(s.bd.CLICK_2_FOLLOW);
            } else {
                bh bhVar2 = this.uuh;
                bhVar2.UMZ.setVisibility(8);
                Log.i(bhVar2.TAG, "no anchor finder contact ");
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin$setFollowBtnState$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260729);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class j implements View.OnClickListener {
        final /* synthetic */ bh uuh;

        j(bh bhVar) {
            this.uuh = bhVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(260730);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin$setFollowBtnState$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.report.live.m.vli.a(s.bd.CLICK_2_PROFILE);
            bh.b(this.uuh);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin$setFollowBtnState$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(260730);
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void resume() {
        AppMethodBeat.i(247060);
        super.resume();
        int aD = au.aD(this.hwr.getContext());
        if (aD == 0) {
            aD = at.fromDPToPix(this.hwr.getContext(), 16);
        }
        this.hOw = aD;
        this.UMZ.post(new f(this));
        AppMethodBeat.o(247060);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ bh uuh;

        f(bh bhVar) {
            this.uuh = bhVar;
        }

        public final void run() {
            AppMethodBeat.i(260726);
            bh.c(this.uuh);
            AppMethodBeat.o(260726);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final void a(Bundle bundle, Object obj, long j2) {
        String str;
        AppMethodBeat.i(260733);
        if (bundle == null || (str = bundle.getString("ACTION_POST_PORTRAIT", "")) == null) {
            str = "";
        }
        if (p.j(str, this.uuf)) {
            com.tencent.mm.ac.d.a(j2, new c(this, j2));
        }
        AppMethodBeat.o(260733);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ long utG;
        final /* synthetic */ bh uuh;

        c(bh bhVar, long j2) {
            this.uuh = bhVar;
            this.utG = j2;
        }

        public final void run() {
            AppMethodBeat.i(247056);
            if (!this.uuh.isFinished()) {
                com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
                if (finderLiveAssistant != null) {
                    s.a.a(finderLiveAssistant, true, "");
                    AppMethodBeat.o(247056);
                    return;
                }
                AppMethodBeat.o(247056);
                return;
            }
            Log.i(this.uuh.TAG, "goToFinderProfileImpl delayMs:" + this.utG + ",isFinished!");
            AppMethodBeat.o(247056);
        }
    }

    public static /* synthetic */ void a(bh bhVar) {
        AppMethodBeat.i(247062);
        bhVar.atN(bhVar.getLiveData().hwd);
        AppMethodBeat.o(247062);
    }

    public final void atN(String str) {
        String str2;
        boolean z;
        ViewGroup.LayoutParams layoutParams;
        AppMethodBeat.i(247061);
        p.h(str, "anchorUsername");
        c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
        com.tencent.mm.plugin.finder.api.g asG = c.a.asG(str);
        String str3 = this.TAG;
        StringBuilder sb = new StringBuilder("updateLiveTitle contact avatarUrl is null:");
        if (asG != null) {
            str2 = asG.cXH();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            z = true;
        } else {
            z = false;
        }
        Log.i(str3, sb.append(z).append(' ').append(str).append(",liveData username:").append(getLiveData().hwd).toString());
        if (asG != null) {
            if (!isLandscape() && (layoutParams = this.hwr.getLayoutParams()) != null) {
                if (getLiveData().djm()) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(at.fromDPToPix(this.hwr.getContext(), 160));
                } else {
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(at.fromDPToPix(this.hwr.getContext(), 112));
                }
            }
            this.uud = asG.getNickname();
            this.uue = asG.cXH();
            com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
            com.tencent.mm.loader.d<o> dka = com.tencent.mm.plugin.finder.loader.m.dka();
            com.tencent.mm.plugin.finder.loader.a aVar2 = new com.tencent.mm.plugin.finder.loader.a(this.uue);
            com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
            dka.a(aVar2, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR)).a(new d(this)).vC();
            this.gxs.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, this.uud, this.gxs.getTextSize()));
            if (asG.field_authInfo == null) {
                this.gxs.setPadding(this.gxs.getPaddingLeft(), this.gxs.getPaddingTop(), 0, this.gxs.getPaddingBottom());
                this.uuc.setVisibility(8);
            } else if (asG.field_authInfo.authIconType > 0) {
                this.gxs.setPadding(this.gxs.getPaddingLeft(), this.gxs.getPaddingTop(), at.fromDPToPix(this.hwr.getContext(), 20), this.gxs.getPaddingBottom());
                this.uuc.setVisibility(0);
                y yVar = y.vXH;
                y.a(this.uuc, asG.field_authInfo, 0);
            } else {
                this.gxs.setPadding(this.gxs.getPaddingLeft(), this.gxs.getPaddingTop(), 0, this.gxs.getPaddingBottom());
                this.uuc.setVisibility(8);
            }
        }
        this.gxs.requestLayout();
        AppMethodBeat.o(247061);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(247063);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (bi.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
                rg(4);
                AppMethodBeat.o(247063);
                return;
            case 4:
                com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                com.tencent.mm.plugin.finder.utils.m.a((d) this, true);
                com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
                com.tencent.mm.plugin.finder.utils.m.a(this);
                AppMethodBeat.o(247063);
                return;
            case 5:
                bkj().removeMessages(this.UNa);
                break;
        }
        AppMethodBeat.o(247063);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(260734);
        super.unMount();
        bkj().removeMessages(this.UNa);
        AppMethodBeat.o(260734);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final void reset() {
        AppMethodBeat.i(260735);
        super.reset();
        bkj().removeMessages(this.UNa);
        AppMethodBeat.o(260735);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveTitlePlugin$doBlockOpLog$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlockPosterSetting;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"})
    public static final class a implements ai<ayu> {
        final /* synthetic */ bh uuh;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(bh bhVar) {
            this.uuh = bhVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
        @Override // com.tencent.mm.plugin.i.a.ai
        public final /* synthetic */ void a(ayu ayu, apg apg) {
            AppMethodBeat.i(260723);
            p.h(ayu, "req");
            p.h(apg, "ret");
            new StringBuilder("[doBlockOpLog] retcode = ").append(apg.retCode);
            com.tencent.e.f.h.hkS();
            AppMethodBeat.o(260723);
        }
    }

    public static final /* synthetic */ void b(bh bhVar) {
        AppMethodBeat.i(260736);
        boolean isLandscape = bhVar.isLandscape();
        Log.i(bhVar.TAG, "goToAnchorFinderProfile isLandscape:".concat(String.valueOf(isLandscape)));
        if (isLandscape) {
            d.a(bhVar, bhVar.uuf, null, 0, 6);
            AppMethodBeat.o(260736);
            return;
        }
        com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
        com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            s.a.a(finderLiveAssistant, true, "");
            AppMethodBeat.o(260736);
            return;
        }
        AppMethodBeat.o(260736);
    }

    public static final /* synthetic */ void c(bh bhVar) {
        String str;
        String nickname;
        AppMethodBeat.i(260737);
        c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
        com.tencent.mm.plugin.finder.api.g asG = c.a.asG(bhVar.getLiveData().hwd);
        if (asG == null || (nickname = asG.getNickname()) == null) {
            str = "";
        } else {
            str = nickname;
        }
        g.a aVar2 = com.tencent.mm.plugin.finder.upload.action.g.vUn;
        boolean asJ = com.tencent.mm.plugin.finder.upload.action.g.vUm.asJ(bhVar.getLiveData().hwd);
        g.a aVar3 = com.tencent.mm.plugin.finder.live.viewmodel.g.uFg;
        Boolean bool = (Boolean) com.tencent.mm.plugin.finder.live.viewmodel.g.UQr.get(Long.valueOf(bhVar.getLiveData().liveInfo.liveId));
        boolean booleanValue = bool != null ? bool.booleanValue() : false;
        Log.i(bhVar.TAG, str + "  followStatus = " + asJ + ", hasLookOneMin:" + booleanValue);
        if (asJ) {
            bhVar.bkj().removeMessages(bhVar.UNa);
            bhVar.UMZ.setVisibility(8);
            AppMethodBeat.o(260737);
        } else if (booleanValue) {
            bhVar.X(false, "#1");
            AppMethodBeat.o(260737);
        } else {
            bhVar.UMZ.setVisibility(8);
            bhVar.bkj().sendEmptyMessageDelayed(bhVar.UNa, bhVar.UNc);
            AppMethodBeat.o(260737);
        }
    }
}
