package com.tencent.mm.plugin.festival.finder;

import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v7.h.c;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.style.LeadingMarginSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.d.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.festival.model.ag;
import com.tencent.mm.plugin.finder.cgi.x;
import com.tencent.mm.plugin.finder.live.util.ad;
import com.tencent.mm.plugin.finder.live.view.FinderMaxSizeLayout;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.ban;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.g.a.r;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0001mB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\tJ\b\u0010;\u001a\u00020\rH\u0016J\b\u0010<\u001a\u000209H\u0002J\b\u0010=\u001a\u000209H\u0002J\b\u0010>\u001a\u000209H\u0002J\u0010\u0010?\u001a\u0002092\u0006\u0010@\u001a\u00020AH\u0002J\u001a\u0010B\u001a\u0002092\u0006\u0010C\u001a\u00020\r2\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J\b\u0010F\u001a\u00020\tH\u0016J\b\u0010G\u001a\u000209H\u0002J\b\u0010H\u001a\u00020\rH\u0002J\b\u0010I\u001a\u00020\rH\u0002J\u0010\u0010J\u001a\u0002092\u0006\u0010K\u001a\u00020\rH\u0016J\u0006\u0010L\u001a\u000209J\u0012\u0010M\u001a\u0002092\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J\b\u0010N\u001a\u000209H\u0002J\u000e\u0010O\u001a\u0002092\u0006\u0010@\u001a\u00020PJ\b\u0010Q\u001a\u000209H\u0016J\b\u0010R\u001a\u000209H\u0002J\u0018\u0010S\u001a\u0002092\u0006\u0010T\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010U\u001a\u0002092\u0006\u0010V\u001a\u00020\tH\u0016J\u0010\u0010W\u001a\u0002092\u0006\u0010X\u001a\u00020&H\u0002J\u0018\u0010Y\u001a\u0002092\u0006\u0010Z\u001a\u00020E2\u0006\u0010[\u001a\u00020\rH\u0002J\u001a\u0010\\\u001a\u0002092\u0006\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\u0010\u0010a\u001a\u0002092\u0006\u0010b\u001a\u00020cH\u0002J\b\u0010d\u001a\u000209H\u0016J\u0016\u0010e\u001a\u0002092\f\u0010f\u001a\b\u0012\u0004\u0012\u00020A0gH\u0002J\u0016\u0010h\u001a\u0002092\f\u0010i\u001a\b\u0012\u0004\u0012\u00020A0jH\u0002J\u0014\u0010k\u001a\u0002092\f\u0010i\u001a\b\u0012\u0004\u0012\u00020A0jJ\u0016\u0010l\u001a\u0002092\f\u0010i\u001a\b\u0012\u0004\u0012\u00020A0jH\u0002R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001aR\u001c\u0010 \u001a\n \"*\u0004\u0018\u00010!0!8BX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001b\u0010+\u001a\u00020,8BX\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b-\u0010.R\u000e\u00101\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006n"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentPlugin;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePlugin;", "Lcom/tencent/mm/plugin/festival/model/IForbiddenCallback;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "bottomMarginByShopBubble", "", "bulletComment", "Lcom/tencent/mm/plugin/festival/finder/BulletCommentWidget;", "canClear", "", "chosenCommentView", "Landroid/view/View;", "chosenCommentViewBg", "Landroid/graphics/drawable/Drawable;", "commentAdapter", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentAdapter;", "commentListBound", "Lcom/tencent/mm/plugin/finder/live/view/FinderMaxSizeLayout;", "commentListH", "getCommentListH", "()I", "setCommentListH", "(I)V", "commentListView", "Landroid/support/v7/widget/RecyclerView;", "commentListW", "getCommentListW", "setCommentListW", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "enterLiveTimeStamp", "", "getEnterLiveTimeStamp", "()J", "setEnterLiveTimeStamp", "(J)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "ifComementEnable", "newTipGroup", "newTipTv", "Landroid/widget/TextView;", "positionChange", "readCount", "showShopBubble", "adjustCommentLayout", "", "distance", "canClearScreen", "checkBottomOptionLayout", "checkComment", "commentScrollToEnd", "complaintMsg", "msg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "doCommentAction", "enableComment", ch.COL_USERNAME, "", "getFlagBit", "hideNewCommentTip", "ifReachLast", "isCommentPluginInInputPlugin", "onForbiddenChange", "isBitFlagSet", "onMsgPosted", "putInBlack", "recordCommmentStatus", "reportCommentTopOp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "reset", "resetFlowOpWindow", "setCommentChoseBg", "view", "setVisible", "visible", "showNewCommentTip", "count", "showOrHideBanComment", "content", "visibility", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "tickleSomeone", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "unMount", "updateComments", "newDatas", "", "updateMessageInrtetnal", "msgList", "", "updateMessages", "updateMessagesOnViewAttach", "Companion", "plugin-festival_release"})
public final class t extends p implements ag {
    public static final a UsE = new a((byte) 0);
    private static final double uon = uon;
    private static final double uoo = uoo;
    private static final double uop = uop;
    private static final double uor = uor;
    private static final float uos;
    private static final float uot;
    private static final int uou;
    private static final int uov;
    private static final float uow;
    private static final float uox;
    private static final int uoy = 10000;
    private final s UsC = new s(getLiveData());
    private a UsD;
    private long dtY;
    private final com.tencent.mm.live.c.b hOp;
    private final ViewGroup hPq;
    private final TextView hPr;
    private final RecyclerView hPs;
    private final kotlin.f lhN;
    private final FinderMaxSizeLayout uoa;
    private boolean uod;
    private boolean uoe;
    private boolean uof;
    private int uog;
    private View uoh;
    private int uoi;
    private int uoj;
    private Drawable uok;
    private boolean uol;
    private volatile long uom;

    private final MMHandler bkj() {
        AppMethodBeat.i(262277);
        MMHandler mMHandler = (MMHandler) this.lhN.getValue();
        AppMethodBeat.o(262277);
        return mMHandler;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "kotlin.jvm.PlatformType", "invoke"})
    static final class h extends q implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.model.t, Boolean> {
        final /* synthetic */ String uoN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(String str) {
            super(1);
            this.uoN = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(com.tencent.mm.plugin.finder.live.model.t tVar) {
            boolean z;
            AppMethodBeat.i(262264);
            com.tencent.mm.plugin.finder.live.model.t tVar2 = tVar;
            if (!Util.isEqual(tVar2.getContent(), this.uoN) || !Util.isEqual(tVar2.csW(), z.aTY())) {
                z = false;
            } else {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(262264);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgResponse;", "invoke"})
    public static final class i extends q implements r<Integer, Integer, String, ban, x> {
        final /* synthetic */ t UsF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(t tVar) {
            super(4);
            this.UsF = tVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(Integer num, Integer num2, String str, ban ban) {
            AppMethodBeat.i(262265);
            num.intValue();
            int intValue = num2.intValue();
            p.h(ban, "resp");
            if (intValue != 0) {
                if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE) {
                    u.makeText(this.UsF.hwr.getContext(), "拍一拍失败", 0).show();
                }
                Log.i("MicroMsg.FestivalFinderLiveCommentPlugin", "tickle failed ,errCode ".concat(String.valueOf(intValue)));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(262265);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(262293);
        this.hOp = bVar;
        View findViewById = viewGroup.findViewById(R.id.ege);
        p.g(findViewById, "root.findViewById(R.id.l…e_comment_list_tip_group)");
        this.hPq = (ViewGroup) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.egf);
        p.g(findViewById2, "root.findViewById(R.id.live_comment_list_tip_tv)");
        this.hPr = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.cpq);
        p.g(findViewById3, "root.findViewById(R.id.finder_live_comment_bound)");
        this.uoa = (FinderMaxSizeLayout) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.cpr);
        p.g(findViewById4, "root.findViewById(R.id.finder_live_comment_list)");
        this.hPs = (RecyclerView) findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.cor);
        p.g(findViewById5, "root.findViewById(R.id.finder_live_bullet_comment)");
        this.UsD = new a((ViewGroup) findViewById5, this.hPs);
        this.uoe = true;
        this.uol = true;
        this.lhN = kotlin.g.ah(new d(this));
        this.uoi = (int) (((double) ((float) au.az(MMApplicationContext.getContext()).x)) * uon);
        this.uoj = (int) (((double) ((float) au.az(MMApplicationContext.getContext()).y)) * uop);
        if (isLandscape()) {
            this.uoa.setMaxWidth((int) (((double) au.az(MMApplicationContext.getContext()).x) * uoo));
            this.uoa.setMaxHeight(((int) (((float) this.uoi) + uos)) / 3);
        } else {
            this.uoa.setMaxWidth(this.uoi);
            this.uoa.setMaxHeight((int) (((float) this.uoj) + uos));
        }
        this.hPs.setLayoutParams(new FrameLayout.LayoutParams(this.uoa.getMaxWidth(), -2));
        RecyclerView recyclerView = this.hPs;
        viewGroup.getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager());
        this.hPs.setAdapter(this.UsC);
        new kotlin.g.a.m<com.tencent.mm.plugin.finder.live.model.t, String, x>(this) {
            /* class com.tencent.mm.plugin.festival.finder.t.AnonymousClass1 */
            final /* synthetic */ t UsF;

            {
                this.UsF = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(com.tencent.mm.plugin.finder.live.model.t tVar, String str) {
                AppMethodBeat.i(262246);
                com.tencent.mm.plugin.finder.live.model.t tVar2 = tVar;
                String str2 = str;
                p.h(tVar2, "msg");
                p.h(str2, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
                Bundle bundle = new Bundle();
                bundle.putString("PARAM_MEMBERS_PROFILE_USERNAME", tVar2.csW());
                bundle.putString("PARAM_MEMBERS_PROFILE_USERMSG", str2);
                bundle.putString("PARAM_FINDER_LIVE_COMMENT", tVar2.getContent());
                bundle.putBoolean("PARAM_MEMBERS_PROFILE_NEED_NOTIFY_CLOSE", false);
                bundle.putInt("PARAM_FINDER_LIVE_CONTACT_SCENE", 0);
                bundle.putString("PARAM_FINDER_LIVE_NICE_NAME", tVar2.dfr());
                this.UsF.hOp.statusChange(b.c.hNr, bundle);
                x xVar = x.SXb;
                AppMethodBeat.o(262246);
                return xVar;
            }
        };
        this.UsC.uAk = new kotlin.g.a.b<com.tencent.mm.plugin.finder.live.model.t, x>(this) {
            /* class com.tencent.mm.plugin.festival.finder.t.AnonymousClass2 */
            final /* synthetic */ t UsF;

            {
                this.UsF = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(com.tencent.mm.plugin.finder.live.model.t tVar) {
                avn dfs;
                AppMethodBeat.i(262247);
                com.tencent.mm.plugin.finder.live.model.t tVar2 = tVar;
                p.h(tVar2, "msg");
                com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
                    int type = tVar2.getType();
                    o.c cVar = o.c.hGH;
                    if (type == o.c.aFn()) {
                        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                        if (com.tencent.mm.plugin.finder.storage.c.dwD().value().intValue() == 1 && (dfs = tVar2.dfs()) != null) {
                            t.a(this.UsF, dfs);
                        }
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(262247);
                return xVar;
            }
        };
        this.UsC.uAj = new kotlin.g.a.m<com.tencent.mm.plugin.finder.live.model.t, View, x>(this) {
            /* class com.tencent.mm.plugin.festival.finder.t.AnonymousClass3 */
            final /* synthetic */ t UsF;

            {
                this.UsF = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(com.tencent.mm.plugin.finder.live.model.t tVar, View view) {
                boolean z;
                AppMethodBeat.i(262251);
                final com.tencent.mm.plugin.finder.live.model.t tVar2 = tVar;
                final View view2 = view;
                p.h(tVar2, "msg");
                p.h(view2, "view");
                c.a aVar = com.tencent.mm.live.core.core.d.c.uKx;
                if (com.tencent.mm.live.core.core.d.c.uKw != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    int type = tVar2.getType();
                    o.c cVar = o.c.hGH;
                    if (type == o.c.aFn()) {
                        com.tencent.mm.plugin.finder.view.i iVar = com.tencent.mm.plugin.finder.view.i.wnk;
                        com.tencent.mm.plugin.finder.view.i.dGO();
                        this.UsF.uoh = view2;
                        this.UsF.uok = view2.getBackground();
                        com.tencent.mm.plugin.finder.view.i iVar2 = com.tencent.mm.plugin.finder.view.i.wnk;
                        com.tencent.mm.plugin.finder.view.i.a(view2, new o.e() {
                            /* class com.tencent.mm.plugin.festival.finder.t.AnonymousClass3.AnonymousClass1 */

                            @Override // com.tencent.mm.ui.base.o.e
                            public final void a(com.tencent.mm.ui.base.m mVar, View view) {
                                AppMethodBeat.i(262248);
                                if (mVar.findItem(154) == null) {
                                    com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                                    if (com.tencent.mm.plugin.finder.storage.c.dwE().value().intValue() == 1) {
                                        mVar.b(154, view2.getContext().getString(R.string.cr4), R.raw.icons_filled_reply);
                                    }
                                }
                                if (mVar.findItem(155) == null) {
                                    mVar.b(155, view2.getContext().getString(R.string.cwv), R.raw.icons_filled_copy);
                                }
                                if (mVar.findItem(156) == null) {
                                    mVar.b(156, view2.getContext().getString(R.string.cx_), R.raw.icons_filled_report_problem);
                                }
                                AppMethodBeat.o(262248);
                            }
                        }, new o.g(this) {
                            /* class com.tencent.mm.plugin.festival.finder.t.AnonymousClass3.AnonymousClass2 */
                            final /* synthetic */ AnonymousClass3 UsG;

                            {
                                this.UsG = r1;
                            }

                            @Override // com.tencent.mm.ui.base.o.g
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                                byte[] bArr;
                                AppMethodBeat.i(262249);
                                p.g(menuItem, "menuItem");
                                switch (menuItem.getItemId()) {
                                    case 154:
                                        Bundle bundle = new Bundle();
                                        bundle.putBoolean("PARAM_IS_ENTERING_COMMENT", true);
                                        avn dfs = tVar2.dfs();
                                        if (dfs != null) {
                                            bArr = dfs.toByteArray();
                                        } else {
                                            bArr = null;
                                        }
                                        bundle.putByteArray("PARAM_ENTER_COMMENT_AT_NAME", bArr);
                                        this.UsG.UsF.hOp.statusChange(b.c.hMd, bundle);
                                        break;
                                    case 155:
                                        Object systemService = MMApplicationContext.getContext().getSystemService("clipboard");
                                        if (systemService != null) {
                                            ((ClipboardManager) systemService).setText(tVar2.getContent());
                                            if (this.UsG.UsF.hOp.getLiveRole() == 0) {
                                                com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
                                                com.tencent.mm.plugin.finder.report.live.m.a(s.ar.CopyComment, (String) null);
                                                break;
                                            }
                                        } else {
                                            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.content.ClipboardManager");
                                            AppMethodBeat.o(262249);
                                            throw tVar;
                                        }
                                        break;
                                    case 156:
                                        t.a(this.UsG.UsF, tVar2);
                                        if (this.UsG.UsF.hOp.getLiveRole() == 0) {
                                            com.tencent.mm.plugin.finder.report.live.m.vli.a(tVar2.csW(), s.k.COMMENT_ZONE);
                                            break;
                                        }
                                        break;
                                }
                                view2.setBackground(this.UsG.UsF.uok);
                                com.tencent.mm.plugin.finder.view.i iVar = com.tencent.mm.plugin.finder.view.i.wnk;
                                com.tencent.mm.plugin.finder.view.i.dGO();
                                AppMethodBeat.o(262249);
                            }
                        }, new PopupWindow.OnDismissListener(this) {
                            /* class com.tencent.mm.plugin.festival.finder.t.AnonymousClass3.AnonymousClass3 */
                            final /* synthetic */ AnonymousClass3 UsG;

                            {
                                this.UsG = r1;
                            }

                            public final void onDismiss() {
                                AppMethodBeat.i(262250);
                                view2.setBackground(this.UsG.UsF.uok);
                                AppMethodBeat.o(262250);
                            }
                        });
                        t.b(view2, tVar2);
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(262251);
                return xVar;
            }
        };
        this.hPs.a(new RecyclerView.l(this) {
            /* class com.tencent.mm.plugin.festival.finder.t.AnonymousClass4 */
            final /* synthetic */ t UsF;

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                AppMethodBeat.i(262253);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentPlugin$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                super.onScrollStateChanged(recyclerView, i2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentPlugin$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                AppMethodBeat.o(262253);
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.UsF = r1;
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                AppMethodBeat.i(262252);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                bVar.pH(i3);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentPlugin$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                p.h(recyclerView, "recyclerView");
                RecyclerView.LayoutManager layoutManager = this.UsF.hPs.getLayoutManager();
                if (layoutManager == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                    AppMethodBeat.o(262252);
                    throw tVar;
                }
                int ku = ((LinearLayoutManager) layoutManager).ku();
                this.UsF.getLiveData().uEO = ku;
                com.tencent.mm.plugin.finder.live.viewmodel.g liveData = this.UsF.getLiveData();
                RecyclerView.LayoutManager layoutManager2 = this.UsF.hPs.getLayoutManager();
                if (layoutManager2 == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                    AppMethodBeat.o(262252);
                    throw tVar2;
                }
                liveData.uEP = ((LinearLayoutManager) layoutManager2).ks();
                com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                if (ku < com.tencent.mm.plugin.finder.live.model.o.dgb() - 1) {
                    this.UsF.dtY = kotlin.k.j.aM((long) (ku + 1), this.UsF.dtY);
                } else {
                    this.UsF.dtY = this.UsF.getLiveData().uDW;
                }
                if (ku == this.UsF.UsC.getItemCount() + -1) {
                    t.h(this.UsF);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentPlugin$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(262252);
            }
        });
        this.hPq.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.festival.finder.t.AnonymousClass5 */
            final /* synthetic */ t UsF;

            {
                this.UsF = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(262254);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                t.h(this.UsF);
                t.a(this.UsF);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(262254);
            }
        });
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        com.tencent.mm.plugin.finder.utils.m.a((com.tencent.mm.plugin.finder.live.plugin.d) this, true);
        AppMethodBeat.o(262293);
    }

    public static final /* synthetic */ void a(t tVar) {
        AppMethodBeat.i(262295);
        tVar.dha();
        AppMethodBeat.o(262295);
    }

    public static final /* synthetic */ void a(t tVar, List list) {
        AppMethodBeat.i(262297);
        tVar.aj(list);
        AppMethodBeat.o(262297);
    }

    public static final /* synthetic */ void b(t tVar, long j2) {
        AppMethodBeat.i(262298);
        tVar.EL(j2);
        AppMethodBeat.o(262298);
    }

    public static final /* synthetic */ void e(t tVar) {
        AppMethodBeat.i(262299);
        tVar.nq(false);
        AppMethodBeat.o(262299);
    }

    public static final /* synthetic */ void h(t tVar) {
        AppMethodBeat.i(262304);
        tVar.aHw();
        AppMethodBeat.o(262304);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u0010XD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0010XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0006R\u0011\u0010 \u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\nR\u000e\u0010\"\u001a\u00020#XT¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0006R\u0014\u0010&\u001a\u00020\u0010XD¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0012R\u0014\u0010(\u001a\u00020\u0010XD¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0012¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentPlugin$Companion;", "", "()V", "BULLET_ITEM_HEIGHT", "", "getBULLET_ITEM_HEIGHT", "()I", "BULLET_MARGIN_BOTTOM", "", "getBULLET_MARGIN_BOTTOM", "()F", "GIFT_QUEUE_HEIGHT", "getGIFT_QUEUE_HEIGHT", "GIFT_QUEUE_HEIGHT_MARGIN_BOTTOM", "getGIFT_QUEUE_HEIGHT_MARGIN_BOTTOM", "H_SCALE", "", "getH_SCALE", "()D", "H_SCALE_ANCHOR_WITHOUT_SHOPPING", "getH_SCALE_ANCHOR_WITHOUT_SHOPPING", "LONGCLICK_MENU_FINDER_LIVE_ANCHOR_BAN", "LONGCLICK_MENU_FINDER_LIVE_ANCHOR_BLACK", "LONGCLICK_MENU_FINDER_LIVE_ANCHOR_BLACK_CONFIRM", "LONGCLICK_MENU_FINDER_LIVE_COMPLAINT", "LONGCLICK_MENU_FINDER_LIVE_COPY", "LONGCLICK_MENU_FINDER_LIVE_MORE_OP", "LONGCLICK_MENU_FINDER_LIVE_REPLY", "LONGCLICK_MENU_FINDER_LIVE_TICKLE", "LONGCLICK_MENU_FINDER_LIVE_TOP_COMMENT", "NEW_COMING_ITEM_HEIGHT", "getNEW_COMING_ITEM_HEIGHT", "PADING_EDGE_LENGTH", "getPADING_EDGE_LENGTH", "TAG", "", "TICKLE_SAME_ONE_INTERVAL", "getTICKLE_SAME_ONE_INTERVAL", "W_SCALE_LANDSCAPE", "getW_SCALE_LANDSCAPE", "W_SCALE_PORTRAIT", "getW_SCALE_PORTRAIT", "plugin-festival_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(262294);
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        uos = context.getResources().getDimension(R.dimen.cb);
        Context context2 = MMApplicationContext.getContext();
        p.g(context2, "MMApplicationContext.getContext()");
        uot = context2.getResources().getDimension(R.dimen.ct);
        int e2 = com.tencent.mm.view.d.e(MMApplicationContext.getContext(), 36.0f);
        uou = e2;
        uov = e2;
        Context context3 = MMApplicationContext.getContext();
        p.g(context3, "MMApplicationContext.getContext()");
        uow = context3.getResources().getDimension(R.dimen.c1);
        Context context4 = MMApplicationContext.getContext();
        p.g(context4, "MMApplicationContext.getContext()");
        uox = context4.getResources().getDimension(R.dimen.bt);
        AppMethodBeat.o(262294);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
    static final class d extends q implements kotlin.g.a.a<MMHandler> {
        final /* synthetic */ t UsF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(t tVar) {
            super(0);
            this.UsF = tVar;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
        static final class a implements MMHandler.Callback {
            final /* synthetic */ d UsJ;

            a(d dVar) {
                this.UsJ = dVar;
            }

            public final boolean handleMessage(Message message) {
                AppMethodBeat.i(262259);
                Object obj = message.obj;
                if (obj == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.collections.ArrayList<com.tencent.mm.plugin.finder.live.model.IFinderLiveMsg> /* = java.util.ArrayList<com.tencent.mm.plugin.finder.live.model.IFinderLiveMsg> */");
                    AppMethodBeat.o(262259);
                    throw tVar;
                }
                t.b(this.UsJ.UsF, (ArrayList) obj);
                AppMethodBeat.o(262259);
                return true;
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MMHandler invoke() {
            AppMethodBeat.i(262260);
            MMHandler mMHandler = new MMHandler(Looper.getMainLooper(), new a(this));
            mMHandler.setLogging(false);
            AppMethodBeat.o(262260);
            return mMHandler;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
    public static final class c implements u.b {
        public static final c UsI = new c();

        static {
            AppMethodBeat.i(262258);
            AppMethodBeat.o(262258);
        }

        c() {
        }

        @Override // com.tencent.mm.ui.base.u.b
        public final void dU(View view) {
            WeImageView weImageView;
            TextView textView;
            AppMethodBeat.i(262257);
            if (!(view == null || (textView = (TextView) view.findViewById(R.id.ird)) == null)) {
                textView.setTextSize(1, 14.0f);
            }
            if (view == null || (weImageView = (WeImageView) view.findViewById(R.id.irc)) == null) {
                AppMethodBeat.o(262257);
                return;
            }
            weImageView.setImageResource(R.raw.icons_filled_done);
            AppMethodBeat.o(262257);
        }
    }

    @Override // com.tencent.mm.plugin.festival.finder.p, com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(262278);
        super.unMount();
        com.tencent.mm.plugin.finder.view.i iVar = com.tencent.mm.plugin.finder.view.i.wnk;
        com.tencent.mm.plugin.finder.view.i.dGO();
        dhb();
        this.uol = true;
        AppMethodBeat.o(262278);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        AppMethodBeat.i(262279);
        if (isLandscape() || this.uol) {
            AppMethodBeat.o(262279);
            return true;
        }
        AppMethodBeat.o(262279);
        return false;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class l implements Runnable {
        final /* synthetic */ t UsF;

        l(t tVar) {
            this.UsF = tVar;
        }

        public final void run() {
            AppMethodBeat.i(262274);
            t.a(this.UsF);
            t.fvP();
            AppMethodBeat.o(262274);
        }
    }

    private final boolean dgZ() {
        AppMethodBeat.i(262281);
        if (this.UsC.getItemCount() != 0) {
            RecyclerView.LayoutManager layoutManager = this.hPs.getLayoutManager();
            if (layoutManager == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(262281);
                throw tVar;
            } else if (((LinearLayoutManager) layoutManager).ku() == this.UsC.getItemCount() - 1) {
                com.tencent.mm.plugin.finder.view.i iVar = com.tencent.mm.plugin.finder.view.i.wnk;
                if (!com.tencent.mm.plugin.finder.view.i.isShowing()) {
                    AppMethodBeat.o(262281);
                    return true;
                }
            }
        }
        AppMethodBeat.o(262281);
        return false;
    }

    private final void eb(List<com.tencent.mm.plugin.finder.live.model.t> list) {
        boolean z;
        AppMethodBeat.i(262282);
        List<com.tencent.mm.plugin.finder.live.model.t> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z || getLiveData().uEO == -1) {
            Log.i("MicroMsg.FestivalFinderLiveCommentPlugin", "[updateMessagesOnViewAttach] curVisiableFirstPosition:" + getLiveData().uEP);
            AppMethodBeat.o(262282);
            return;
        }
        this.hPs.post(new m(this, list));
        AppMethodBeat.o(262282);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class m implements Runnable {
        final /* synthetic */ t UsF;
        final /* synthetic */ List uoO;

        m(t tVar, List list) {
            this.UsF = tVar;
            this.uoO = list;
        }

        public final void run() {
            int i2;
            AppMethodBeat.i(262276);
            t.a(this.UsF, this.uoO);
            this.UsF.dtY = this.UsF.getLiveData().uER;
            boolean z = this.UsF.getLiveData().uEQ;
            int i3 = this.UsF.getLiveData().uEP;
            long j2 = this.UsF.getLiveData().uDW - this.UsF.dtY;
            Log.i("MicroMsg.FestivalFinderLiveCommentPlugin", "[updateMessagesOnViewAttach] readCount:" + this.UsF.dtY + ", unreadCount" + j2 + ",reachLast" + z + ", position" + i3);
            if (this.UsF.UsC.getItemCount() > 0) {
                if (z) {
                    this.UsF.hPs.post(new Runnable(this) {
                        /* class com.tencent.mm.plugin.festival.finder.t.m.AnonymousClass1 */
                        final /* synthetic */ m UsK;

                        {
                            this.UsK = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(262275);
                            t.a(this.UsK.UsF);
                            AppMethodBeat.o(262275);
                        }
                    });
                    AppMethodBeat.o(262276);
                    return;
                }
                if (i3 < 0) {
                    i2 = 0;
                } else {
                    i2 = i3 >= this.UsF.UsC.getItemCount() ? this.UsF.UsC.getItemCount() - 1 : i3;
                }
                RecyclerView recyclerView = this.UsF.hPs;
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentPlugin$updateMessagesOnViewAttach$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentPlugin$updateMessagesOnViewAttach$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                t.b(this.UsF, j2);
            }
            AppMethodBeat.o(262276);
        }
    }

    private final void dha() {
        AppMethodBeat.i(262283);
        RecyclerView recyclerView = this.hPs;
        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(kotlin.k.j.mZ(this.UsC.getItemCount() - 1, 0), new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentPlugin", "commentScrollToEnd", "()V", "Undefined", "scrollToPosition", "(I)V");
        recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentPlugin", "commentScrollToEnd", "()V", "Undefined", "scrollToPosition", "(I)V");
        this.dtY = getLiveData().uDW;
        AppMethodBeat.o(262283);
    }

    private final void EL(long j2) {
        String str;
        AppMethodBeat.i(262284);
        if (j2 <= 0 || !getLiveData().uDD) {
            aHw();
            AppMethodBeat.o(262284);
            return;
        }
        this.hPq.setVisibility(0);
        if (j2 <= 99) {
            str = String.valueOf(j2);
        } else {
            str = "99+";
        }
        TextView textView = this.hPr;
        ae aeVar = ae.SYK;
        Context context = this.hwr.getContext();
        p.g(context, "root.context");
        String string = context.getResources().getString(R.string.cxq);
        p.g(string, "root.context.resources.g…der_live_new_comment_tip)");
        String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
        p.g(format, "java.lang.String.format(format, *args)");
        textView.setText(format);
        AppMethodBeat.o(262284);
    }

    private final void aHw() {
        AppMethodBeat.i(262285);
        this.hPq.setVisibility(8);
        AppMethodBeat.o(262285);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentPlugin$updateComments$result$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-festival_release"})
    public static final class k extends c.a {
        final /* synthetic */ t UsF;
        final /* synthetic */ List hPD;

        k(t tVar, List list) {
            this.UsF = tVar;
            this.hPD = list;
        }

        @Override // android.support.v7.h.c.a
        public final int aB() {
            AppMethodBeat.i(262270);
            int size = this.UsF.UsC.hXy.size();
            AppMethodBeat.o(262270);
            return size;
        }

        @Override // android.support.v7.h.c.a
        public final int aC() {
            AppMethodBeat.i(262271);
            int size = this.hPD.size();
            AppMethodBeat.o(262271);
            return size;
        }

        @Override // android.support.v7.h.c.a
        public final boolean i(int i2, int i3) {
            AppMethodBeat.i(262272);
            boolean j2 = p.j((com.tencent.mm.plugin.finder.live.model.t) kotlin.a.j.L(this.UsF.UsC.hXy, i2), (com.tencent.mm.plugin.finder.live.model.t) kotlin.a.j.L(this.hPD, i3));
            AppMethodBeat.o(262272);
            return j2;
        }

        @Override // android.support.v7.h.c.a
        public final boolean j(int i2, int i3) {
            AppMethodBeat.i(262273);
            boolean j2 = p.j((com.tencent.mm.plugin.finder.live.model.t) kotlin.a.j.L(this.UsF.UsC.hXy, i2), (com.tencent.mm.plugin.finder.live.model.t) kotlin.a.j.L(this.hPD, i3));
            AppMethodBeat.o(262273);
            return j2;
        }
    }

    private final void aj(List<? extends com.tencent.mm.plugin.finder.live.model.t> list) {
        AppMethodBeat.i(262286);
        c.b a2 = android.support.v7.h.c.a(new k(this, list), false);
        p.g(a2, "DiffUtil.calculateDiff(o…      }\n        }, false)");
        a2.a(new j(this, list));
        AppMethodBeat.o(262286);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentPlugin$updateComments$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-festival_release"})
    public static final class j implements android.support.v7.h.d {
        final /* synthetic */ t UsF;
        final /* synthetic */ List hPD;

        j(t tVar, List list) {
            this.UsF = tVar;
            this.hPD = list;
        }

        @Override // android.support.v7.h.d
        public final void c(int i2, int i3, Object obj) {
            AppMethodBeat.i(262266);
            Log.d("MicroMsg.FestivalFinderLiveCommentPlugin", "onChanged position:" + i2 + ", count:" + i3);
            this.UsF.UsC.hXy.clear();
            this.UsF.UsC.hXy.addAll(this.hPD);
            this.UsF.UsC.aq(i2, i3);
            AppMethodBeat.o(262266);
        }

        @Override // android.support.v7.h.d
        public final void l(int i2, int i3) {
            AppMethodBeat.i(262267);
            Log.d("MicroMsg.FestivalFinderLiveCommentPlugin", "onMoved fromPosition:" + i2 + ", toPosition:" + i3);
            this.UsF.UsC.ar(i2, i3);
            AppMethodBeat.o(262267);
        }

        @Override // android.support.v7.h.d
        public final void f(int i2, int i3) {
            AppMethodBeat.i(262268);
            Log.d("MicroMsg.FestivalFinderLiveCommentPlugin", "onInserted position:" + i2 + ", count:" + i3);
            this.UsF.UsC.hXy.clear();
            this.UsF.UsC.hXy.addAll(this.hPD);
            this.UsF.UsC.as(i2, i3);
            AppMethodBeat.o(262268);
        }

        @Override // android.support.v7.h.d
        public final void k(int i2, int i3) {
            AppMethodBeat.i(262269);
            Log.d("MicroMsg.FestivalFinderLiveCommentPlugin", "onRemoved position:" + i2 + ", count:" + i3);
            this.UsF.UsC.hXy.clear();
            this.UsF.UsC.hXy.addAll(this.hPD);
            this.UsF.UsC.at(i2, i3);
            AppMethodBeat.o(262269);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        boolean z;
        String str;
        boolean z2;
        boolean z3 = true;
        boolean z4 = false;
        AppMethodBeat.i(262287);
        p.h(cVar, "status");
        switch (u.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                if (getLiveData().uDD && ((bundle != null && bundle.getBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW")) || isLandscape())) {
                    List<com.tencent.mm.plugin.finder.live.model.t> list = getLiveData().uDs;
                    p.g(list, "liveData.msgList");
                    eb(list);
                }
                this.uom = System.currentTimeMillis();
                AppMethodBeat.o(262287);
                return;
            case 2:
                int i2 = bundle != null ? bundle.getInt("PARAM_FINDER_LIVE_COMMENT_MOVE_DISTANCE") : 0;
                if (i2 > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.uof = z2;
                this.uog = i2;
                Log.i("MicroMsg.FestivalFinderLiveCommentPlugin", "comment move distance:" + i2 + ",has change:" + this.uod);
                if ((!this.uod && i2 > 0) || (this.uod && i2 < 0)) {
                    if (this.uod) {
                        z3 = false;
                    }
                    this.uod = z3;
                    ViewGroup.LayoutParams layoutParams = this.hwr.getLayoutParams();
                    if (layoutParams == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        AppMethodBeat.o(262287);
                        throw tVar;
                    }
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += i2;
                }
                AppMethodBeat.o(262287);
                return;
            case 3:
            case 4:
                if (bundle != null) {
                    String string = bundle.getString("PARAM_FINDER_LIVE_COMMENT");
                    if (string == null) {
                        str = "";
                    } else {
                        str = string;
                    }
                    p.g(str, "param.getString(ILiveSta…INDER_LIVE_COMMENT) ?: \"\"");
                    List<com.tencent.mm.plugin.finder.live.model.t> list2 = getLiveData().uDs;
                    p.g(list2, "liveData.msgList");
                    kotlin.a.j.c((List) list2, (kotlin.g.a.b) new h(str));
                    com.tencent.mm.ac.d.h(new g(this, bundle));
                    AppMethodBeat.o(262287);
                    return;
                }
                AppMethodBeat.o(262287);
                return;
            case 5:
                aHw();
                dha();
                AppMethodBeat.o(262287);
                return;
            case 6:
                AppMethodBeat.o(262287);
                return;
            case 7:
                com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                com.tencent.mm.plugin.finder.utils.m.a((com.tencent.mm.plugin.finder.live.plugin.d) this, true);
                AppMethodBeat.o(262287);
                return;
            case 8:
                if (bundle != null) {
                    z4 = bundle.getBoolean("PARAM_FINDER_LIVE_SCREEN_CLEAR");
                }
                if (z4) {
                    dhb();
                    AppMethodBeat.o(262287);
                    return;
                }
                List<com.tencent.mm.plugin.finder.live.model.t> list3 = getLiveData().uDs;
                p.g(list3, "liveData.msgList");
                eb(list3);
                AppMethodBeat.o(262287);
                return;
            case 9:
            case 10:
                dhb();
                AppMethodBeat.o(262287);
                return;
            case 11:
                if (bundle != null) {
                    z = bundle.getBoolean("PARAM_IS_ENTERING_COMMENT");
                } else {
                    z = false;
                }
                if (z) {
                    z3 = false;
                }
                this.uol = z3;
                break;
        }
        AppMethodBeat.o(262287);
    }

    private final void dhb() {
        AppMethodBeat.i(262288);
        if (this.dtY > 0) {
            getLiveData().uEQ = dgZ();
            getLiveData().uER = kotlin.k.j.aM(getLiveData().uER, this.dtY);
        }
        AppMethodBeat.o(262288);
    }

    private final void nq(boolean z) {
        AppMethodBeat.i(262289);
        z.f fVar = new z.f();
        fVar.SYG = (T) this.hwr.findViewById(R.id.co0);
        if (z) {
            this.UsD.ulL.clear();
            this.UsD.dgJ();
            aHw();
            Context context = MMApplicationContext.getContext();
            p.g(context, "context");
            com.tencent.mm.pluginsdk.ui.span.m mVar = new com.tencent.mm.pluginsdk.ui.span.m(context.getResources().getString(R.string.cr1, context.getResources().getString(R.string.crg)));
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            mVar.a(new ad(context2.getResources().getColor(R.color.BW_100_Alpha_0_8), context.getResources().getColor(R.color.BW_0_Alpha_0_8), 0, 0.0f, 12), context.getResources().getString(R.string.cr2), 0);
            z.f fVar2 = new z.f();
            View findViewById = fVar.SYG.findViewById(R.id.egb);
            p.g(findViewById, "banComment.findViewById<…_comment_item_content_tv)");
            ViewParent parent = ((TextView) findViewById).getParent();
            if (parent == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
                AppMethodBeat.o(262289);
                throw tVar;
            }
            fVar2.SYG = (T) ((RelativeLayout) parent);
            View findViewById2 = fVar.SYG.findViewById(R.id.egb);
            p.g(findViewById2, "banComment.findViewById<…_comment_item_content_tv)");
            ViewParent parent2 = ((TextView) findViewById2).getParent();
            if (parent2 == null) {
                kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
                AppMethodBeat.o(262289);
                throw tVar2;
            }
            ((RelativeLayout) parent2).setPadding(0, fVar2.SYG.getPaddingTop(), fVar2.SYG.getPaddingRight(), fVar2.SYG.getPaddingBottom());
            View findViewById3 = fVar.SYG.findViewById(R.id.egb);
            p.g(findViewById3, "banComment.findViewById<…_comment_item_content_tv)");
            ((TextView) findViewById3).setText(mVar);
            T t = fVar.SYG;
            p.g(t, "banComment");
            t.setVisibility(0);
            fVar.SYG.post(new e(fVar, fVar2, mVar, context));
            fVar.SYG.postDelayed(new f(this), 3000);
            AppMethodBeat.o(262289);
            return;
        }
        EL(0);
        a aVar = this.UsD;
        List<awq> list = getLiveData().uDt;
        p.g(list, "liveData.bulletCommetList");
        aVar.dZ(list);
        T t2 = fVar.SYG;
        p.g(t2, "banComment");
        t2.setVisibility(8);
        AppMethodBeat.o(262289);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ Context $context;
        final /* synthetic */ z.f uoK;
        final /* synthetic */ z.f uoL;
        final /* synthetic */ com.tencent.mm.pluginsdk.ui.span.m uoM;

        e(z.f fVar, z.f fVar2, com.tencent.mm.pluginsdk.ui.span.m mVar, Context context) {
            this.uoK = fVar;
            this.uoL = fVar2;
            this.uoM = mVar;
            this.$context = context;
        }

        public final void run() {
            AppMethodBeat.i(262261);
            TextView textView = (TextView) this.uoK.SYG.findViewById(R.id.egb);
            p.g(textView, "textView");
            if (textView.getLineCount() > 1) {
                ViewParent parent = textView.getParent();
                if (parent == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
                    AppMethodBeat.o(262261);
                    throw tVar;
                }
                ((RelativeLayout) parent).setPadding(0, this.uoL.SYG.getPaddingTop(), this.uoL.SYG.getPaddingRight(), this.uoL.SYG.getPaddingBottom());
                textView.setLineSpacing(5.0f, 1.0f);
                com.tencent.mm.pluginsdk.ui.span.m mVar = this.uoM;
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                int color = context.getResources().getColor(R.color.BW_100_Alpha_0_8);
                Context context2 = this.$context;
                p.g(context2, "context");
                ad adVar = new ad(color, context2.getResources().getColor(R.color.BW_0_Alpha_0_8), 5, 0.0f, 8);
                Context context3 = this.$context;
                p.g(context3, "context");
                mVar.a(adVar, context3.getResources().getString(R.string.cr2), 0);
                SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(this.uoM);
                valueOf.setSpan(new LeadingMarginSpan.Standard(0, at.fromDPToPix(MMApplicationContext.getContext(), 6)), 0, this.uoM.length(), 33);
                textView.setText(valueOf);
            }
            AppMethodBeat.o(262261);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class f implements Runnable {
        final /* synthetic */ t UsF;

        f(t tVar) {
            this.UsF = tVar;
        }

        public final void run() {
            AppMethodBeat.i(262262);
            t.e(this.UsF);
            AppMethodBeat.o(262262);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final void reset() {
        AppMethodBeat.i(262290);
        this.UsC.hXy.clear();
        this.UsC.notifyDataSetChanged();
        AppMethodBeat.o(262290);
    }

    @Override // com.tencent.mm.plugin.festival.model.ag
    public final void Fe(boolean z) {
        AppMethodBeat.i(262291);
        Log.i("MicroMsg.FestivalFinderLiveCommentPlugin", "onForbiddenChange :".concat(String.valueOf(z)));
        if (z) {
            rg(8);
        }
        AppMethodBeat.o(262291);
    }

    @Override // com.tencent.mm.plugin.festival.model.ag
    public final int dCX() {
        return 8;
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void rg(int i2) {
        AppMethodBeat.i(262292);
        while (i2 == 0) {
            com.tencent.mm.plugin.festival.model.t tVar = com.tencent.mm.plugin.festival.model.t.UyR;
            if (!com.tencent.mm.plugin.festival.model.t.awC(8)) {
                break;
            }
            i2 = 8;
        }
        super.rg(i2);
        AppMethodBeat.o(262292);
    }

    public final void ea(List<com.tencent.mm.plugin.finder.live.model.t> list) {
        AppMethodBeat.i(262280);
        p.h(list, "msgList");
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
            if (!getLiveData().uit && !getLiveData().uEe && !getLiveData().diZ()) {
                ViewGroup.LayoutParams layoutParams = this.hwr.getLayoutParams();
                if (layoutParams == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    AppMethodBeat.o(262280);
                    throw tVar;
                }
                com.tencent.mm.plugin.festival.c.j jVar = com.tencent.mm.plugin.festival.c.j.UGJ;
                Context context = this.hwr.getContext();
                p.g(context, "context");
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = com.tencent.mm.plugin.festival.c.j.aD(context);
            } else if (this.uof) {
                ViewGroup.LayoutParams layoutParams2 = this.hwr.getLayoutParams();
                if (layoutParams2 == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    AppMethodBeat.o(262280);
                    throw tVar2;
                }
                com.tencent.mm.plugin.festival.c.j jVar2 = com.tencent.mm.plugin.festival.c.j.UGJ;
                Context context2 = this.hwr.getContext();
                p.g(context2, "context");
                ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = com.tencent.mm.plugin.festival.c.j.aD(context2) + com.tencent.mm.view.d.e(MMApplicationContext.getContext(), 72.0f) + this.uog;
            } else {
                ViewGroup.LayoutParams layoutParams3 = this.hwr.getLayoutParams();
                if (layoutParams3 == null) {
                    kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    AppMethodBeat.o(262280);
                    throw tVar3;
                }
                com.tencent.mm.plugin.festival.c.j jVar3 = com.tencent.mm.plugin.festival.c.j.UGJ;
                Context context3 = this.hwr.getContext();
                p.g(context3, "context");
                ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin = com.tencent.mm.plugin.festival.c.j.aD(context3) + com.tencent.mm.view.d.e(MMApplicationContext.getContext(), 72.0f);
            }
        }
        Message obtainMessage = bkj().obtainMessage();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        obtainMessage.obj = arrayList;
        bkj().sendMessage(obtainMessage);
        AppMethodBeat.o(262280);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentPlugin$statusChange$1$2"})
    static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Bundle $param$inlined;
        final /* synthetic */ t UsF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(t tVar, Bundle bundle) {
            super(0);
            this.UsF = tVar;
            this.$param$inlined = bundle;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(262263);
            s sVar = this.UsF.UsC;
            List<com.tencent.mm.plugin.finder.live.model.t> list = this.UsF.getLiveData().uDs;
            p.g(list, "liveData.msgList");
            p.h(list, "commentList");
            sVar.hXy.clear();
            sVar.hXy.addAll(list);
            this.UsF.UsC.notifyDataSetChanged();
            x xVar = x.SXb;
            AppMethodBeat.o(262263);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveCommentPlugin$checkComment$1$1"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ t UsF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(t tVar) {
            super(0);
            this.UsF = tVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(262256);
            this.UsF.hPs.setVisibility(8);
            x xVar = x.SXb;
            AppMethodBeat.o(262256);
            return xVar;
        }
    }

    public static final /* synthetic */ void fvP() {
        AppMethodBeat.i(262296);
        com.tencent.mm.plugin.finder.view.i iVar = com.tencent.mm.plugin.finder.view.i.wnk;
        com.tencent.mm.plugin.finder.view.i.dGO();
        AppMethodBeat.o(262296);
    }

    public static final /* synthetic */ void b(t tVar, List list) {
        boolean z;
        Boolean bool;
        boolean z2;
        awe awe;
        AppMethodBeat.i(262300);
        List list2 = list;
        if (!(list2 == null || list2.isEmpty())) {
            StringBuilder sb = new StringBuilder("liveMessageCallback liveId:");
            com.tencent.mm.plugin.finder.live.viewmodel.g liveData = tVar.getLiveData();
            Log.i("MicroMsg.FestivalFinderLiveCommentPlugin", sb.append(((liveData == null || (awe = liveData.liveInfo) == null) ? null : Long.valueOf(awe.liveId)).longValue()).append(",msgListCount:").append(list.size()).toString());
            boolean dgZ = tVar.dgZ();
            long j2 = tVar.getLiveData().uDW - tVar.dtY;
            tVar.aj(list);
            if (tVar.UsC.getItemCount() > 0) {
                if (dgZ) {
                    tVar.hPs.post(new l(tVar));
                } else if (j2 > 0) {
                    tVar.EL(j2);
                }
            }
        }
        if (p.j(tVar.getLiveData().uES, Boolean.TRUE)) {
            a aVar = tVar.UsD;
            List<awq> list3 = tVar.getLiveData().uDt;
            p.g(list3, "liveData.bulletCommetList");
            aVar.dZ(list3);
        }
        b.C0376b.a(tVar.hOp, b.c.hNh);
        if (!list.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z && (bool = tVar.getLiveData().uES) != null) {
            boolean booleanValue = bool.booleanValue();
            if (tVar.uoe != booleanValue) {
                if (System.currentTimeMillis() - tVar.uom < 3000) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                tVar.uoe = booleanValue;
                if (tVar.uoe) {
                    tVar.hPs.setVisibility(0);
                    tVar.nq(false);
                    tVar.dha();
                } else if (z2) {
                    com.tencent.mm.ac.d.a(3000, new b(tVar));
                } else {
                    tVar.hPs.setVisibility(8);
                    Context context = MMApplicationContext.getContext();
                    p.g(context, "context");
                    p.g(context.getResources().getString(R.string.crg), "context.resources.getStr…e_comment_anchor_disable)");
                    tVar.nq(true);
                }
                Log.i("MicroMsg.FestivalFinderLiveCommentPlugin", "enableLiveRoomComment:".concat(String.valueOf(booleanValue)));
                AppMethodBeat.o(262300);
                return;
            }
        }
        AppMethodBeat.o(262300);
    }

    public static final /* synthetic */ void a(t tVar, avn avn) {
        String str;
        String str2;
        String str3 = null;
        AppMethodBeat.i(262301);
        com.tencent.mm.b.h<String, Long> hVar = tVar.getLiveData().uEw;
        FinderContact finderContact = avn.contact;
        if (finderContact == null || (str = finderContact.username) == null) {
            str = "";
        }
        Long l2 = (Long) hVar.get(str);
        if (System.currentTimeMillis() - (l2 != null ? l2.longValue() : 0) < ((long) uoy)) {
            u.makeText(tVar.hwr.getContext(), tVar.hwr.getContext().getString(R.string.czt), 0).show();
            com.tencent.mm.b.h<String, Long> hVar2 = tVar.getLiveData().uEw;
            FinderContact finderContact2 = avn.contact;
            if (finderContact2 != null) {
                str2 = finderContact2.username;
            } else {
                str2 = null;
            }
            hVar2.put(str2, Long.valueOf(System.currentTimeMillis()));
            AppMethodBeat.o(262301);
            return;
        }
        com.tencent.mm.b.h<String, Long> hVar3 = tVar.getLiveData().uEw;
        FinderContact finderContact3 = avn.contact;
        if (finderContact3 != null) {
            str3 = finderContact3.username;
        }
        hVar3.put(str3, Long.valueOf(System.currentTimeMillis()));
        x.a aVar = com.tencent.mm.plugin.finder.cgi.x.ttF;
        aut a2 = x.a.a(avn);
        new com.tencent.mm.plugin.finder.cgi.x(a2, tVar.getLiveData(), new i(tVar)).aYI();
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        com.tencent.mm.plugin.finder.utils.m.eg(tVar.hwr);
        com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
        com.tencent.mm.plugin.finder.utils.m.a(a2, tVar.getLiveData());
        b.C0376b.a(tVar.hOp, b.c.hMb);
        if (tVar.hOp.getLiveRole() == 1) {
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.a(s.c.LIVE_ANCHOR_TICKLE, "");
            com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtC++;
        }
        AppMethodBeat.o(262301);
    }

    public static final /* synthetic */ void a(t tVar, com.tencent.mm.plugin.finder.live.model.t tVar2) {
        AppMethodBeat.i(262302);
        if (tVar2 instanceof com.tencent.mm.plugin.finder.live.model.r) {
            x.a aVar = com.tencent.mm.plugin.finder.cgi.x.ttF;
            new com.tencent.mm.plugin.finder.cgi.x(x.a.a(((com.tencent.mm.plugin.finder.live.model.r) tVar2).uke), tVar.getLiveData(), null).aYI();
            Context context = tVar.hwr.getContext();
            p.g(context, "root.context");
            String string = context.getResources().getString(R.string.crs);
            p.g(string, "root.context.resources.g…nder_live_complaint_done)");
            u.a(tVar.hwr.getContext(), string, c.UsI);
        }
        AppMethodBeat.o(262302);
    }

    public static final /* synthetic */ void b(View view, com.tencent.mm.plugin.finder.live.model.t tVar) {
        AppMethodBeat.i(262303);
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (com.tencent.mm.plugin.finder.utils.m.a(tVar)) {
            view.setBackground(view.getContext().getDrawable(R.drawable.a04));
            AppMethodBeat.o(262303);
            return;
        }
        view.setBackground(view.getContext().getDrawable(R.drawable.a0g));
        AppMethodBeat.o(262303);
    }
}
