package com.tencent.mm.plugin.finder.live.plugin;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v7.h.c;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
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
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.x;
import com.tencent.mm.plugin.finder.live.model.cgi.w;
import com.tencent.mm.plugin.finder.live.model.m;
import com.tencent.mm.plugin.finder.live.model.n;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.model.t;
import com.tencent.mm.plugin.finder.live.model.y;
import com.tencent.mm.plugin.finder.live.view.FinderMaxSizeLayout;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.i.a.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.ban;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.protocal.protobuf.fgy;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.g.a.r;
import kotlin.g.b.ae;
import kotlin.g.b.z;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\u0018\u0000 q2\u00020\u0001:\u0001qB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\bJ\b\u00105\u001a\u00020\fH\u0016J\b\u00106\u001a\u000203H\u0002J\b\u00107\u001a\u000203H\u0002J\b\u00108\u001a\u000203H\u0002J\u0010\u00109\u001a\u0002032\u0006\u0010:\u001a\u00020;H\u0002J\u001a\u0010<\u001a\u0002032\u0006\u0010=\u001a\u00020\f2\b\u0010>\u001a\u0004\u0018\u00010?H\u0002J\u0012\u0010@\u001a\u0002032\b\u0010A\u001a\u0004\u0018\u00010?H\u0002J\u0010\u0010B\u001a\u0002032\u0006\u0010C\u001a\u00020\bH\u0002J\b\u0010D\u001a\u000203H\u0002J\b\u0010E\u001a\u00020\fH\u0002J\b\u0010F\u001a\u00020\fH\u0002J4\u0010G\u001a\u0002032\"\u0010H\u001a\u001e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020J0Ij\u000e\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020J`K2\u0006\u0010L\u001a\u00020\fH\u0016J\u0006\u0010M\u001a\u000203J$\u0010N\u001a\u0002032\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010S\u001a\u00020 H\u0016J\u0012\u0010T\u001a\u0002032\b\u0010>\u001a\u0004\u0018\u00010?H\u0002J\b\u0010U\u001a\u000203H\u0002J\u000e\u0010V\u001a\u0002032\u0006\u0010:\u001a\u00020WJ\b\u0010X\u001a\u000203H\u0016J\b\u0010Y\u001a\u000203H\u0002J\u0018\u0010Z\u001a\u0002032\u0006\u0010[\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020;H\u0002J\u0010\u0010\\\u001a\u0002032\u0006\u0010]\u001a\u00020 H\u0002J\u0018\u0010^\u001a\u0002032\u0006\u0010_\u001a\u00020?2\u0006\u0010`\u001a\u00020\fH\u0002J\u001a\u0010a\u001a\u0002032\u0006\u0010b\u001a\u00020c2\b\u0010d\u001a\u0004\u0018\u00010PH\u0016J\u0010\u0010e\u001a\u0002032\u0006\u0010f\u001a\u00020gH\u0002J\b\u0010h\u001a\u000203H\u0016J\u0016\u0010i\u001a\u0002032\f\u0010j\u001a\b\u0012\u0004\u0012\u00020;0kH\u0002J\u0016\u0010l\u001a\u0002032\f\u0010m\u001a\b\u0012\u0004\u0012\u00020;0nH\u0002J\u0014\u0010o\u001a\u0002032\f\u0010m\u001a\b\u0012\u0004\u0012\u00020;0nJ\u0016\u0010p\u001a\u0002032\f\u0010m\u001a\b\u0012\u0004\u0012\u00020;0nH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u0019R\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001b\u0010%\u001a\u00020&8BX\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u000e\u0010+\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006r"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "bottomMarginByShopBubble", "", "bulletComment", "Lcom/tencent/mm/plugin/finder/live/plugin/BulletCommentWidget;", "canClear", "", "chosenCommentView", "Landroid/view/View;", "chosenCommentViewBg", "Landroid/graphics/drawable/Drawable;", "commentAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveCommentAdapter;", "commentListBound", "Lcom/tencent/mm/plugin/finder/live/view/FinderMaxSizeLayout;", "commentListH", "getCommentListH", "()I", "setCommentListH", "(I)V", "commentListView", "Landroid/support/v7/widget/RecyclerView;", "commentListW", "getCommentListW", "setCommentListW", "enterLiveTimeStamp", "", "getEnterLiveTimeStamp", "()J", "setEnterLiveTimeStamp", "(J)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "ifComementEnable", "newTipGroup", "newTipTv", "Landroid/widget/TextView;", "positionChange", "readCount", "showShopBubble", "adjustCommentLayout", "", "distance", "canClearScreen", "checkBottomOptionLayout", "checkComment", "commentScrollToEnd", "complaintMsg", "msg", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "doCommentAction", "enableComment", ch.COL_USERNAME, "", "goToFinderProfile", "finderUsername", "handleRecvLuckyMoneyErr", "errCode", "hideNewCommentTip", "ifReachLast", "isCommentPluginInInputPlugin", "onAudienceMicUserChanged", "micUserMap", "Ljava/util/LinkedHashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "onMsgPosted", "onPortraitDelayAction", "extraMsg", "Landroid/os/Bundle;", "extraData", "", "delayMs", "putInBlack", "recordCommmentStatus", "reportCommentTopOp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "reset", "resetFlowOpWindow", "setCommentChoseBg", "view", "showNewCommentTip", "count", "showOrHideBanComment", "content", "visibility", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "tickleSomeone", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "unMount", "updateComments", "newDatas", "", "updateMessageInrtetnal", "msgList", "", "updateMessages", "updateMessagesOnViewAttach", "Companion", "plugin-finder_release"})
public final class v extends d {
    private static final String ULy = ULy;
    private static final double uon = uon;
    private static final double uoo = uoo;
    private static final double uop = uop;
    private static final double uoq = uoq;
    private static final double uor = uor;
    private static final float uos;
    private static final float uot;
    private static final int uou;
    private static final int uov;
    private static final float uow;
    private static final float uox;
    private static final int uoy = 10000;
    public static final a uoz = new a((byte) 0);
    private static final String uuf = uuf;
    private long dtY;
    final com.tencent.mm.live.c.b hOp;
    private final ViewGroup hPq;
    private final TextView hPr;
    private final RecyclerView hPs;
    private final kotlin.f lhN;
    private final FinderMaxSizeLayout uoa;
    private final com.tencent.mm.plugin.finder.live.view.adapter.c uob = new com.tencent.mm.plugin.finder.live.view.adapter.c(getLiveData());
    private b uoc;
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
        AppMethodBeat.i(246576);
        MMHandler mMHandler = (MMHandler) this.lhN.getValue();
        AppMethodBeat.o(246576);
        return mMHandler;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "success", "", "enable", "invoke"})
    public static final class d extends kotlin.g.b.q implements kotlin.g.a.m<Boolean, Boolean, x> {
        final /* synthetic */ v uoA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(v vVar) {
            super(2);
            this.uoA = vVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, Boolean bool2) {
            String string;
            String string2;
            AppMethodBeat.i(246550);
            boolean booleanValue = bool.booleanValue();
            boolean booleanValue2 = bool2.booleanValue();
            if (booleanValue) {
                if (booleanValue2) {
                    Context context = this.uoA.hwr.getContext();
                    kotlin.g.b.p.g(context, "root.context");
                    string2 = context.getResources().getString(R.string.cyq);
                } else {
                    Context context2 = this.uoA.hwr.getContext();
                    kotlin.g.b.p.g(context2, "root.context");
                    string2 = context2.getResources().getString(R.string.cyo);
                }
                kotlin.g.b.p.g(string2, "if (enable) root.context…action_comment_forbidden)");
                u.a(this.uoA.hwr.getContext(), string2, AnonymousClass1.uoE);
            } else {
                Context context3 = this.uoA.hwr.getContext();
                kotlin.g.b.p.g(context3, "root.context");
                String string3 = context3.getResources().getString(R.string.cyi);
                kotlin.g.b.p.g(string3, "root.context.resources.g…ofile_action_fail_prefix)");
                StringBuilder append = new StringBuilder().append(string3);
                if (booleanValue2) {
                    Context context4 = this.uoA.hwr.getContext();
                    kotlin.g.b.p.g(context4, "root.context");
                    string = context4.getResources().getString(R.string.cyl);
                } else {
                    Context context5 = this.uoA.hwr.getContext();
                    kotlin.g.b.p.g(context5, "root.context");
                    string = context5.getResources().getString(R.string.cyp);
                }
                u.a(this.uoA.hwr.getContext(), append.append(string).toString(), AnonymousClass2.uoF);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246550);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "kotlin.jvm.PlatformType", "invoke"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.b<t, Boolean> {
        final /* synthetic */ String uoN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(String str) {
            super(1);
            this.uoN = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(t tVar) {
            boolean z;
            AppMethodBeat.i(246563);
            t tVar2 = tVar;
            if (!Util.isEqual(tVar2.getContent(), this.uoN) || !Util.isEqual(tVar2.csW(), z.aTY())) {
                z = false;
            } else {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(246563);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderPostLiveAppMsgResponse;", "invoke"})
    public static final class l extends kotlin.g.b.q implements r<Integer, Integer, String, ban, x> {
        final /* synthetic */ v uoA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(v vVar) {
            super(4);
            this.uoA = vVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(Integer num, Integer num2, String str, ban ban) {
            AppMethodBeat.i(246564);
            num.intValue();
            int intValue = num2.intValue();
            kotlin.g.b.p.h(ban, "resp");
            if (intValue != 0) {
                if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE) {
                    u.makeText(this.uoA.hwr.getContext(), "拍一拍失败", 0).show();
                }
                Log.i("Finder.LiveCommentPlugin", "tickle failed ,errCode ".concat(String.valueOf(intValue)));
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246564);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(final ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        kotlin.g.b.p.h(viewGroup, "root");
        kotlin.g.b.p.h(bVar, "statusMonitor");
        AppMethodBeat.i(246590);
        this.hOp = bVar;
        View findViewById = viewGroup.findViewById(R.id.ege);
        kotlin.g.b.p.g(findViewById, "root.findViewById(com.te…e_comment_list_tip_group)");
        this.hPq = (ViewGroup) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.egf);
        kotlin.g.b.p.g(findViewById2, "root.findViewById(com.te…live_comment_list_tip_tv)");
        this.hPr = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.cpq);
        kotlin.g.b.p.g(findViewById3, "root.findViewById(R.id.finder_live_comment_bound)");
        this.uoa = (FinderMaxSizeLayout) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.cpr);
        kotlin.g.b.p.g(findViewById4, "root.findViewById(R.id.finder_live_comment_list)");
        this.hPs = (RecyclerView) findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.cor);
        kotlin.g.b.p.g(findViewById5, "root.findViewById(R.id.finder_live_bullet_comment)");
        this.uoc = new b((ViewGroup) findViewById5, this.hPs);
        this.uoe = true;
        this.uol = true;
        this.lhN = kotlin.g.ah(new e(this));
        this.uoi = (int) (((double) ((float) au.az(MMApplicationContext.getContext()).x)) * uon);
        this.uoj = (int) (((double) ((float) au.az(MMApplicationContext.getContext()).y)) * uop);
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
            if (getLiveData().uit || getLiveData().uEe || getLiveData().diZ()) {
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                if (layoutParams == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    AppMethodBeat.o(246590);
                    throw tVar;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = au.aD(viewGroup.getContext()) + com.tencent.mm.view.d.e(MMApplicationContext.getContext(), 72.0f);
            } else {
                ViewGroup.LayoutParams layoutParams2 = viewGroup.getLayoutParams();
                if (layoutParams2 == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    AppMethodBeat.o(246590);
                    throw tVar2;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = au.aD(viewGroup.getContext());
                this.uoj = (int) (((double) ((float) au.az(MMApplicationContext.getContext()).y)) * uor);
            }
        }
        if (isLandscape()) {
            this.uoa.setMaxWidth((int) (((double) au.az(MMApplicationContext.getContext()).x) * uoo));
            this.uoa.setMaxHeight((int) (((double) au.az(MMApplicationContext.getContext()).y) * uoq));
        } else {
            this.uoa.setMaxWidth(this.uoi);
            this.uoa.setMaxHeight((int) (((float) this.uoj) + uos));
        }
        this.hPs.setLayoutParams(new FrameLayout.LayoutParams(this.uoa.getMaxWidth(), -2));
        RecyclerView recyclerView = this.hPs;
        viewGroup.getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager());
        this.uob.UOf = this.uoa.getMaxWidth();
        this.hPs.setAdapter(this.uob);
        this.uob.uAk = new kotlin.g.a.b<t, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.v.AnonymousClass1 */
            final /* synthetic */ v uoA;

            {
                this.uoA = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(t tVar) {
                avn dfs;
                AppMethodBeat.i(260581);
                t tVar2 = tVar;
                kotlin.g.b.p.h(tVar2, "msg");
                com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
                    int type = tVar2.getType();
                    o.c cVar = o.c.hGH;
                    if (type == o.c.aFn()) {
                        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                        if (com.tencent.mm.plugin.finder.storage.c.dwD().value().intValue() == 1 && (dfs = tVar2.dfs()) != null) {
                            v.a(this.uoA, dfs);
                        }
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(260581);
                return xVar;
            }
        };
        this.uob.uAj = new kotlin.g.a.m<t, View, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.v.AnonymousClass2 */
            final /* synthetic */ v uoA;

            {
                this.uoA = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(t tVar, View view) {
                final boolean z;
                AppMethodBeat.i(260593);
                final t tVar2 = tVar;
                final View view2 = view;
                kotlin.g.b.p.h(tVar2, "msg");
                kotlin.g.b.p.h(view2, "view");
                avn dfs = tVar2.dfs();
                if ((dfs != null ? dfs.Viq : 1) == 3) {
                    z = true;
                } else {
                    z = false;
                }
                com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
                    int type = tVar2.getType();
                    o.c cVar = o.c.hGH;
                    if (type == o.c.aFn() || tVar2.getType() == 20002) {
                        final String csW = tVar2.csW();
                        com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                        s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
                        if (finderLiveAssistant != null) {
                            finderLiveAssistant.bxD(csW);
                        }
                        com.tencent.mm.plugin.finder.view.i iVar = com.tencent.mm.plugin.finder.view.i.wnk;
                        com.tencent.mm.plugin.finder.view.i.dGO();
                        this.uoA.uoh = view2;
                        this.uoA.uok = view2.getBackground();
                        com.tencent.mm.plugin.finder.view.i iVar2 = com.tencent.mm.plugin.finder.view.i.wnk;
                        com.tencent.mm.plugin.finder.view.i.a(view2, new o.e(this) {
                            /* class com.tencent.mm.plugin.finder.live.plugin.v.AnonymousClass2.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass2 ULz;

                            {
                                this.ULz = r1;
                            }

                            @Override // com.tencent.mm.ui.base.o.e
                            public final void a(final com.tencent.mm.ui.base.m mVar, View view) {
                                AppMethodBeat.i(260584);
                                if (mVar.findItem(157) == null) {
                                    com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                                    if (com.tencent.mm.plugin.finder.storage.c.dwD().value().intValue() == 1) {
                                        mVar.b(157, view2.getContext().getString(R.string.czs), R.raw.icons_filled_tickle);
                                    }
                                }
                                if (mVar.findItem(152) == null) {
                                    mVar.b(152, view2.getContext().getString(R.string.crp), R.raw.icons_filled_top);
                                }
                                if (z && mVar.findItem(TbsListener.ErrorCode.STARTDOWNLOAD_4) == null) {
                                    mVar.b(TbsListener.ErrorCode.STARTDOWNLOAD_4, view2.getContext().getString(R.string.da9), R.raw.icons_filled_finder_icon);
                                }
                                AnonymousClass1 r1 = new kotlin.g.a.q<Integer, CharSequence, Integer, x>(this) {
                                    /* class com.tencent.mm.plugin.finder.live.plugin.v.AnonymousClass2.AnonymousClass1.AnonymousClass1 */
                                    final /* synthetic */ AnonymousClass1 ULB;

                                    {
                                        this.ULB = r2;
                                    }

                                    /* Return type fixed from 'java.lang.Object' to match base method */
                                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
                                    @Override // kotlin.g.a.q
                                    public final /* synthetic */ x d(Integer num, CharSequence charSequence, Integer num2) {
                                        AppMethodBeat.i(260582);
                                        a(num.intValue(), charSequence, num2.intValue());
                                        x xVar = x.SXb;
                                        AppMethodBeat.o(260582);
                                        return xVar;
                                    }

                                    public final void a(int i2, CharSequence charSequence, int i3) {
                                        AppMethodBeat.i(260583);
                                        kotlin.g.b.p.h(charSequence, "title");
                                        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                                        if (com.tencent.mm.plugin.finder.storage.c.dwD().value().intValue() == 1 || z) {
                                            mVar.c(i2, charSequence, i3);
                                            AppMethodBeat.o(260583);
                                            return;
                                        }
                                        mVar.b(i2, charSequence, i3);
                                        AppMethodBeat.o(260583);
                                    }
                                };
                                if (mVar.findItem(158) == null) {
                                    if (kotlin.g.b.p.j(this.ULz.uoA.getLiveData().uDX.get(csW), Boolean.TRUE)) {
                                        String string = view2.getContext().getString(R.string.crl);
                                        kotlin.g.b.p.g(string, "view.context.getString(R…r_live_comment_op_ban_on)");
                                        r1.a(158, string, R.raw.icons_filled_ban_comment_on);
                                    } else {
                                        String string2 = view2.getContext().getString(R.string.crk);
                                        kotlin.g.b.p.g(string2, "view.context.getString(R…_live_comment_op_ban_off)");
                                        r1.a(158, string2, R.raw.icons_filled_ban_comment_off);
                                    }
                                }
                                if (mVar.findItem(156) == null) {
                                    String string3 = view2.getContext().getString(R.string.crn);
                                    kotlin.g.b.p.g(string3, "view.context.getString(R…r_live_comment_op_expose)");
                                    r1.a(156, string3, R.raw.icons_filled_report_problem);
                                }
                                if (mVar.findItem(161) == null) {
                                    String string4 = view2.getContext().getString(R.string.crm);
                                    kotlin.g.b.p.g(string4, "view.context.getString(R…er_live_comment_op_black)");
                                    r1.a(161, string4, R.raw.icons_filled_black);
                                }
                                AppMethodBeat.o(260584);
                            }
                        }, new o.g(this) {
                            /* class com.tencent.mm.plugin.finder.live.plugin.v.AnonymousClass2.AnonymousClass2 */
                            final /* synthetic */ AnonymousClass2 ULz;

                            {
                                this.ULz = r1;
                            }

                            @Override // com.tencent.mm.ui.base.o.g
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                                awq awq;
                                AppMethodBeat.i(260585);
                                kotlin.g.b.p.g(menuItem, "menuItem");
                                switch (menuItem.getItemId()) {
                                    case 152:
                                        int type = tVar2.getType();
                                        o.c cVar = o.c.hGH;
                                        if (type == o.c.aFn()) {
                                            t tVar = tVar2;
                                            if (tVar == null) {
                                                kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.model.FinderLiveTextMsg");
                                                AppMethodBeat.o(260585);
                                                throw tVar2;
                                            }
                                            awq = ((com.tencent.mm.plugin.finder.live.model.r) tVar).uke;
                                        } else if (tVar2.getType() == 20002) {
                                            t tVar3 = tVar2;
                                            if (tVar3 == null) {
                                                kotlin.t tVar4 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.model.FinderLiveInteractiveMsg");
                                                AppMethodBeat.o(260585);
                                                throw tVar4;
                                            }
                                            com.tencent.mm.plugin.finder.live.model.f fVar = (com.tencent.mm.plugin.finder.live.model.f) tVar3;
                                            awq awq2 = new awq();
                                            awq2.nickname = fVar.dfr();
                                            awq2.content = fVar.getContent();
                                            o.c cVar2 = o.c.hGH;
                                            awq2.type = o.c.aFn();
                                            awq2.username = fVar.csW();
                                            awq2.seq = fVar.uio.seq;
                                            awq2.fQY = fVar.uio.LFr;
                                            awq2.LHp = fVar.uio.LFE;
                                            awq2.Vjm = fVar.uio.LFz;
                                            awq2.LHq = fVar.uio.LFF;
                                            awq = awq2;
                                        } else {
                                            awq = null;
                                        }
                                        if (awq != null) {
                                            Bundle bundle = new Bundle();
                                            bundle.putByteArray("PARAM_FINDER_LIVE_TOP_COMMENT", awq.toByteArray());
                                            this.ULz.uoA.hOp.statusChange(b.c.hNq, bundle);
                                            new w(this.ULz.uoA.getLiveData(), awq).aYI();
                                            v vVar = this.ULz.uoA;
                                            kotlin.g.b.p.h(awq, "msg");
                                            if (vVar.hOp.getLiveRole() == 1) {
                                                com.tencent.mm.ab.i iVar = new com.tencent.mm.ab.i();
                                                iVar.h("content", awq.content);
                                                iVar.U("msgtype", awq.type);
                                                com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                                                com.tencent.mm.plugin.finder.report.live.k.a(s.c.LIVE_ANCHOR_TOP_COMMENT, iVar.toString());
                                                break;
                                            }
                                        }
                                        break;
                                    case 156:
                                        v.a(this.ULz.uoA, tVar2);
                                        break;
                                    case 157:
                                        avn dfs = tVar2.dfs();
                                        if (dfs != null) {
                                            v.a(this.ULz.uoA, dfs);
                                            break;
                                        }
                                        break;
                                    case 158:
                                        Boolean bool = this.ULz.uoA.getLiveData().uDX.get(csW);
                                        if (bool == null) {
                                            bool = Boolean.FALSE;
                                        }
                                        kotlin.g.b.p.g(bool, "liveData.disableCommentCacheMap[username] ?: false");
                                        boolean booleanValue = bool.booleanValue();
                                        Log.i("Finder.LiveCommentPlugin", "LONGCLICK_MENU_FINDER_LIVE_ANCHOR_BAN username:" + csW + " disableComment:" + booleanValue);
                                        String str = csW;
                                        if (str != null) {
                                            v.a(this.ULz.uoA, booleanValue, str);
                                            if (this.ULz.uoA.hOp.getLiveRole() == 1) {
                                                com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                                                com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtx++;
                                                JSONObject jSONObject = new JSONObject();
                                                String valueOf = String.valueOf(s.ac.LIVE_PERSONAL_COMMENT_CLOSE.action);
                                                if (str == null) {
                                                    str = "";
                                                }
                                                jSONObject.put(valueOf, str);
                                                s.c cVar3 = s.c.LIVE_ANCHOR_ACTION_BARRAGE;
                                                com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                                                if (com.tencent.mm.plugin.finder.report.live.k.dpl().vmm) {
                                                    cVar3 = s.c.LIVE_ANCHOR_ACTION_AUDIENCE;
                                                }
                                                com.tencent.mm.plugin.finder.report.live.k kVar4 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                                                com.tencent.mm.plugin.finder.report.live.k.a(cVar3, jSONObject.toString());
                                                break;
                                            }
                                        }
                                        break;
                                    case 161:
                                        v.a(this.ULz.uoA, csW);
                                        break;
                                    case TbsListener.ErrorCode.STARTDOWNLOAD_4 /*{ENCODED_INT: 163}*/:
                                        t tVar5 = tVar2;
                                        if (tVar5 != null) {
                                            awq awq3 = ((com.tencent.mm.plugin.finder.live.model.r) tVar5).uke;
                                            Bundle bundle2 = new Bundle();
                                            bundle2.putString("PARAM_MEMBERS_PROFILE_USERNAME", awq3.username);
                                            bundle2.putInt("PARAM_MEMBERS_PROFILE_SOURCE_TYPE", 2);
                                            this.ULz.uoA.hOp.statusChange(b.c.hMk, bundle2);
                                            break;
                                        } else {
                                            kotlin.t tVar6 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.model.FinderLiveTextMsg");
                                            AppMethodBeat.o(260585);
                                            throw tVar6;
                                        }
                                }
                                view2.setBackground(this.ULz.uoA.uok);
                                com.tencent.mm.plugin.finder.view.i iVar2 = com.tencent.mm.plugin.finder.view.i.wnk;
                                com.tencent.mm.plugin.finder.view.i.dGO();
                                AppMethodBeat.o(260585);
                            }
                        }, new PopupWindow.OnDismissListener(this) {
                            /* class com.tencent.mm.plugin.finder.live.plugin.v.AnonymousClass2.AnonymousClass3 */
                            final /* synthetic */ AnonymousClass2 ULz;

                            {
                                this.ULz = r1;
                            }

                            public final void onDismiss() {
                                AppMethodBeat.i(260586);
                                view2.setBackground(this.ULz.uoA.uok);
                                AppMethodBeat.o(260586);
                            }
                        });
                        v.a(view2, tVar2);
                        x xVar = x.SXb;
                        AppMethodBeat.o(260593);
                        return xVar;
                    }
                }
                b.a aVar = com.tencent.mm.live.core.core.d.b.hCo;
                if (b.a.aDp()) {
                    int type2 = tVar2.getType();
                    o.c cVar2 = o.c.hGH;
                    if (type2 == o.c.aFn() || tVar2.getType() == 20002) {
                        com.tencent.mm.plugin.finder.view.i iVar3 = com.tencent.mm.plugin.finder.view.i.wnk;
                        com.tencent.mm.plugin.finder.view.i.dGO();
                        this.uoA.uoh = view2;
                        this.uoA.uok = view2.getBackground();
                        com.tencent.mm.plugin.finder.view.i iVar4 = com.tencent.mm.plugin.finder.view.i.wnk;
                        com.tencent.mm.plugin.finder.view.i.a(view2, new o.e() {
                            /* class com.tencent.mm.plugin.finder.live.plugin.v.AnonymousClass2.AnonymousClass4 */

                            @Override // com.tencent.mm.ui.base.o.e
                            public final void a(com.tencent.mm.ui.base.m mVar, View view) {
                                AppMethodBeat.i(260587);
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
                                if (z && mVar.findItem(TbsListener.ErrorCode.STARTDOWNLOAD_4) == null) {
                                    mVar.b(TbsListener.ErrorCode.STARTDOWNLOAD_4, view2.getContext().getString(R.string.da9), R.raw.icons_filled_finder_icon);
                                }
                                AppMethodBeat.o(260587);
                            }
                        }, new o.g(this) {
                            /* class com.tencent.mm.plugin.finder.live.plugin.v.AnonymousClass2.AnonymousClass5 */
                            final /* synthetic */ AnonymousClass2 ULz;

                            {
                                this.ULz = r1;
                            }

                            @Override // com.tencent.mm.ui.base.o.g
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                                byte[] bArr;
                                AppMethodBeat.i(260590);
                                kotlin.g.b.p.g(menuItem, "menuItem");
                                switch (menuItem.getItemId()) {
                                    case 154:
                                        Log.i("Finder.LiveCommentPlugin", "[LONGCLICK_MENU_FINDER_LIVE_REPLY],riskControlEnableComment:" + this.ULz.uoA.getLiveData().uDB + ",enableLiveRoomComment:" + this.ULz.uoA.getLiveData().uDD + ", enableCustomerComment:" + this.ULz.uoA.getLiveData().uDC);
                                        if (this.ULz.uoA.getLiveData().uDB && this.ULz.uoA.getLiveData().uDD && this.ULz.uoA.getLiveData().uDC) {
                                            Bundle bundle = new Bundle();
                                            bundle.putBoolean("PARAM_IS_ENTERING_COMMENT", true);
                                            avn dfs = tVar2.dfs();
                                            if (dfs != null) {
                                                bArr = dfs.toByteArray();
                                            } else {
                                                bArr = null;
                                            }
                                            bundle.putByteArray("PARAM_ENTER_COMMENT_AT_NAME", bArr);
                                            this.ULz.uoA.hOp.statusChange(b.c.hMd, bundle);
                                            break;
                                        } else {
                                            Context context = viewGroup.getContext();
                                            Context context2 = MMApplicationContext.getContext();
                                            kotlin.g.b.p.g(context2, "MMApplicationContext.getContext()");
                                            u.a(context, context2.getResources().getString(R.string.jbv), AnonymousClass1.ULC);
                                            break;
                                        }
                                    case 155:
                                        Object systemService = MMApplicationContext.getContext().getSystemService("clipboard");
                                        if (systemService != null) {
                                            ((ClipboardManager) systemService).setText(tVar2.getContent());
                                            if (this.ULz.uoA.hOp.getLiveRole() == 0) {
                                                com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
                                                com.tencent.mm.plugin.finder.report.live.m.a(s.ar.CopyComment, (String) null);
                                                break;
                                            }
                                        } else {
                                            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.content.ClipboardManager");
                                            AppMethodBeat.o(260590);
                                            throw tVar;
                                        }
                                        break;
                                    case 156:
                                        v.a(this.ULz.uoA, tVar2);
                                        if (this.ULz.uoA.hOp.getLiveRole() == 0) {
                                            com.tencent.mm.plugin.finder.report.live.m.vli.a(tVar2.csW(), s.k.COMMENT_ZONE);
                                            break;
                                        }
                                        break;
                                    case TbsListener.ErrorCode.STARTDOWNLOAD_4 /*{ENCODED_INT: 163}*/:
                                        t tVar2 = tVar2;
                                        if (tVar2 != null) {
                                            v.b(this.ULz.uoA, ((com.tencent.mm.plugin.finder.live.model.r) tVar2).uke.username);
                                            break;
                                        } else {
                                            kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.model.FinderLiveTextMsg");
                                            AppMethodBeat.o(260590);
                                            throw tVar3;
                                        }
                                }
                                view2.setBackground(this.ULz.uoA.uok);
                                com.tencent.mm.plugin.finder.view.i iVar = com.tencent.mm.plugin.finder.view.i.wnk;
                                com.tencent.mm.plugin.finder.view.i.dGO();
                                AppMethodBeat.o(260590);
                            }
                        }, new PopupWindow.OnDismissListener(this) {
                            /* class com.tencent.mm.plugin.finder.live.plugin.v.AnonymousClass2.AnonymousClass6 */
                            final /* synthetic */ AnonymousClass2 ULz;

                            {
                                this.ULz = r1;
                            }

                            public final void onDismiss() {
                                AppMethodBeat.i(260591);
                                view2.setBackground(this.ULz.uoA.uok);
                                AppMethodBeat.o(260591);
                            }
                        });
                        v.a(view2, tVar2);
                        x xVar2 = x.SXb;
                        AppMethodBeat.o(260593);
                        return xVar2;
                    }
                }
                int type3 = tVar2.getType();
                o.c cVar3 = o.c.hGH;
                if (type3 == o.c.caa()) {
                    y yVar = tVar2 instanceof y ? tVar2 : null;
                    if (yVar == null) {
                        Log.i("Finder.LiveCommentPlugin", "msg is not FinderLiveLocationMsg");
                    } else if (yVar == null) {
                        kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.model.FinderLiveLocationMsg");
                        AppMethodBeat.o(260593);
                        throw tVar3;
                    } else {
                        y yVar2 = yVar;
                        eaa eaa = new eaa();
                        eaa.LbC = yVar2.UKp.dTj;
                        eaa.LbD = yVar2.UKp.latitude;
                        eaa.kea = yVar2.UKp.fuK;
                        eaa.kHV = yVar2.UKp.kHV;
                        eaa.ErZ = yVar2.UKp.ErZ;
                        eaa.LIb = yVar2.UKp.LIb;
                        eaa.Esb = yVar2.UKp.Esb;
                        eaa.country = yVar2.UKp.country;
                        ((com.tencent.mm.plugin.i.a.y) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.y.class)).a(eaa, y.a.FINDER_POI_FROM_TYPE_SNS, z.aTY(), new a());
                    }
                }
                x xVar22 = x.SXb;
                AppMethodBeat.o(260593);
                return xVar22;
            }

            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin$2$8$1", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$PoiRedirectCallBack;", "onPoiRedirect", "", "type", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPoiService$FinderPoiRedirectType;", "plugin-finder_release"})
            /* renamed from: com.tencent.mm.plugin.finder.live.plugin.v$2$a */
            public static final class a implements y.c {
                a() {
                }

                @Override // com.tencent.mm.plugin.i.a.y.c
                public final void a(y.b bVar) {
                    AppMethodBeat.i(260592);
                    kotlin.g.b.p.h(bVar, "type");
                    AppMethodBeat.o(260592);
                }
            }
        };
        this.uob.UOh = new kotlin.g.a.b<String, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.v.AnonymousClass3 */
            final /* synthetic */ v uoA;

            {
                this.uoA = r2;
            }

            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "errCode", "", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin$3$1$2"})
            /* renamed from: com.tencent.mm.plugin.finder.live.plugin.v$3$a */
            static final class a extends kotlin.g.b.q implements kotlin.g.a.b<Integer, x> {
                final /* synthetic */ AnonymousClass3 ULE;
                final /* synthetic */ fgy ULF;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                a(AnonymousClass3 r2, fgy fgy) {
                    super(1);
                    this.ULE = r2;
                    this.ULF = fgy;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(Integer num) {
                    AppMethodBeat.i(260595);
                    v.a(this.ULE.uoA, num.intValue());
                    x xVar = x.SXb;
                    AppMethodBeat.o(260595);
                    return xVar;
                }
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(String str) {
                T t;
                String str2;
                s.bg bgVar;
                String str3 = null;
                AppMethodBeat.i(260596);
                String str4 = str;
                List<fgy> list = this.uoA.getLiveData().UQo;
                kotlin.g.b.p.g(list, "liveData.luckyMoneyList");
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    T next = it.next();
                    if (Util.isEqual(next.ViT, str4)) {
                        t = next;
                        break;
                    }
                }
                T t2 = t;
                if (t2 != null) {
                    com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
                    s.bh bhVar = s.bh.CLICK_COMMENT_AREA_RED_PACKET_SYS_MSG;
                    if (TextUtils.isEmpty(t2.ViX)) {
                        bgVar = s.bg.ANCHOR;
                    } else {
                        bgVar = s.bg.LINKMIC_VISITOR;
                    }
                    mVar.a(bhVar, bgVar);
                    com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                    com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
                    if (finderLiveAssistant != null) {
                        Context context = viewGroup.getContext();
                        if (context == null) {
                            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                            AppMethodBeat.o(260596);
                            throw tVar;
                        }
                        finderLiveAssistant.a((Activity) context, t2, new FinderLiveCommentPlugin$3$$special$$inlined$let$lambda$1(t2, MMHandler.createFreeHandler(Looper.getMainLooper()), this, t2), new a(this, t2));
                    }
                }
                StringBuilder sb = new StringBuilder("click lucky money item :[");
                if (t2 != null) {
                    str2 = t2.ViT;
                } else {
                    str2 = null;
                }
                StringBuilder append = sb.append(str2).append(", ");
                if (t2 != null) {
                    str3 = t2.Vjk;
                }
                Log.i("Finder.LiveCommentPlugin", append.append(str3).append(']').toString());
                x xVar = x.SXb;
                AppMethodBeat.o(260596);
                return xVar;
            }
        };
        this.hPs.a(new RecyclerView.l(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.v.AnonymousClass4 */
            final /* synthetic */ v uoA;

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                AppMethodBeat.i(246540);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
                super.onScrollStateChanged(recyclerView, i2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
                AppMethodBeat.o(246540);
            }

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.uoA = r1;
            }

            @Override // android.support.v7.widget.RecyclerView.l
            public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                AppMethodBeat.i(246539);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(recyclerView);
                bVar.pH(i2);
                bVar.pH(i3);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
                kotlin.g.b.p.h(recyclerView, "recyclerView");
                RecyclerView.LayoutManager layoutManager = this.uoA.hPs.getLayoutManager();
                if (layoutManager == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                    AppMethodBeat.o(246539);
                    throw tVar;
                }
                int ku = ((LinearLayoutManager) layoutManager).ku();
                this.uoA.getLiveData().uEO = ku;
                com.tencent.mm.plugin.finder.live.viewmodel.g liveData = this.uoA.getLiveData();
                RecyclerView.LayoutManager layoutManager2 = this.uoA.hPs.getLayoutManager();
                if (layoutManager2 == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                    AppMethodBeat.o(246539);
                    throw tVar2;
                }
                liveData.uEP = ((LinearLayoutManager) layoutManager2).ks();
                com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                if (ku < com.tencent.mm.plugin.finder.live.model.o.dgb() - 1) {
                    this.uoA.dtY = kotlin.k.j.aM((long) (ku + 1), this.uoA.dtY);
                } else {
                    this.uoA.dtY = this.uoA.getLiveData().uDW;
                }
                if (ku == this.uoA.uob.getItemCount() + -1) {
                    v.h(this.uoA);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
                AppMethodBeat.o(246539);
            }
        });
        this.hPq.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.v.AnonymousClass5 */
            final /* synthetic */ v uoA;

            {
                this.uoA = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(246541);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                v.h(this.uoA);
                v.a(this.uoA);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(246541);
            }
        });
        com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
        com.tencent.mm.plugin.finder.utils.m.a((d) this, true);
        AppMethodBeat.o(246590);
    }

    public static final /* synthetic */ void a(v vVar) {
        AppMethodBeat.i(246592);
        vVar.dha();
        AppMethodBeat.o(246592);
    }

    public static final /* synthetic */ void a(v vVar, List list) {
        AppMethodBeat.i(246594);
        vVar.aj(list);
        AppMethodBeat.o(246594);
    }

    public static final /* synthetic */ void b(v vVar, long j2) {
        AppMethodBeat.i(246595);
        vVar.EL(j2);
        AppMethodBeat.o(246595);
    }

    public static final /* synthetic */ void e(v vVar) {
        AppMethodBeat.i(246596);
        vVar.nq(false);
        AppMethodBeat.o(246596);
    }

    public static final /* synthetic */ void h(v vVar) {
        AppMethodBeat.i(246603);
        vVar.aHw();
        AppMethodBeat.o(246603);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u0010XD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0010XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u0010XD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0011\u0010#\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\nR\u0014\u0010%\u001a\u00020&XD¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020&XD¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u000e\u0010+\u001a\u00020&XT¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0006R\u0014\u0010.\u001a\u00020\u0010XD¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0012R\u0014\u00100\u001a\u00020\u0010XD¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0012¨\u00062"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin$Companion;", "", "()V", "BULLET_ITEM_HEIGHT", "", "getBULLET_ITEM_HEIGHT", "()I", "BULLET_MARGIN_BOTTOM", "", "getBULLET_MARGIN_BOTTOM", "()F", "GIFT_QUEUE_HEIGHT", "getGIFT_QUEUE_HEIGHT", "GIFT_QUEUE_HEIGHT_MARGIN_BOTTOM", "getGIFT_QUEUE_HEIGHT_MARGIN_BOTTOM", "H_SCALE", "", "getH_SCALE", "()D", "H_SCALE_ANCHOR_WITHOUT_SHOPPING", "getH_SCALE_ANCHOR_WITHOUT_SHOPPING", "H_SCALE_LANDSCAPE", "getH_SCALE_LANDSCAPE", "LONGCLICK_MENU_FINDER_LIVE_ANCHOR_BAN", "LONGCLICK_MENU_FINDER_LIVE_ANCHOR_BLACK", "LONGCLICK_MENU_FINDER_LIVE_ANCHOR_BLACK_CONFIRM", "LONGCLICK_MENU_FINDER_LIVE_COMPLAINT", "LONGCLICK_MENU_FINDER_LIVE_COPY", "LONGCLICK_MENU_FINDER_LIVE_FINDER_ENTRANCE", "LONGCLICK_MENU_FINDER_LIVE_MORE_OP", "LONGCLICK_MENU_FINDER_LIVE_REPLY", "LONGCLICK_MENU_FINDER_LIVE_TICKLE", "LONGCLICK_MENU_FINDER_LIVE_TOP_COMMENT", "NEW_COMING_ITEM_HEIGHT", "getNEW_COMING_ITEM_HEIGHT", "PADING_EDGE_LENGTH", "getPADING_EDGE_LENGTH", "PORTRAIT_ACTION_GOTO_PROFILE", "", "getPORTRAIT_ACTION_GOTO_PROFILE", "()Ljava/lang/String;", v.ULy, "getPORTRAIT_ACTION_KEY_FINDER_USERNAME", "TAG", "TICKLE_SAME_ONE_INTERVAL", "getTICKLE_SAME_ONE_INTERVAL", "W_SCALE_LANDSCAPE", "getW_SCALE_LANDSCAPE", "W_SCALE_PORTRAIT", "getW_SCALE_PORTRAIT", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(246591);
        Context context = MMApplicationContext.getContext();
        kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
        uos = context.getResources().getDimension(R.dimen.cb);
        Context context2 = MMApplicationContext.getContext();
        kotlin.g.b.p.g(context2, "MMApplicationContext.getContext()");
        uot = context2.getResources().getDimension(R.dimen.ct);
        int e2 = com.tencent.mm.view.d.e(MMApplicationContext.getContext(), 36.0f);
        uou = e2;
        uov = e2;
        Context context3 = MMApplicationContext.getContext();
        kotlin.g.b.p.g(context3, "MMApplicationContext.getContext()");
        uow = context3.getResources().getDimension(R.dimen.c1);
        Context context4 = MMApplicationContext.getContext();
        kotlin.g.b.p.g(context4, "MMApplicationContext.getContext()");
        uox = context4.getResources().getDimension(R.dimen.bt);
        AppMethodBeat.o(246591);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<MMHandler> {
        final /* synthetic */ v uoA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(v vVar) {
            super(0);
            this.uoA = vVar;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
        static final class a implements MMHandler.Callback {
            final /* synthetic */ e uoG;

            a(e eVar) {
                this.uoG = eVar;
            }

            public final boolean handleMessage(Message message) {
                AppMethodBeat.i(246551);
                Object obj = message.obj;
                if (obj == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.collections.ArrayList<com.tencent.mm.plugin.finder.live.model.IFinderLiveMsg> /* = java.util.ArrayList<com.tencent.mm.plugin.finder.live.model.IFinderLiveMsg> */");
                    AppMethodBeat.o(246551);
                    throw tVar;
                }
                v.b(this.uoG.uoA, (ArrayList) obj);
                AppMethodBeat.o(246551);
                return true;
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MMHandler invoke() {
            AppMethodBeat.i(246552);
            MMHandler mMHandler = new MMHandler(Looper.getMainLooper(), new a(this));
            mMHandler.setLogging(false);
            AppMethodBeat.o(246552);
            return mMHandler;
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void a(LinkedHashMap<String, Rect> linkedHashMap, boolean z) {
        AppMethodBeat.i(260598);
        kotlin.g.b.p.h(linkedHashMap, "micUserMap");
        Log.i("Finder.LiveCommentPlugin", "onAudienceMicUserChanged commentAdapter micEnable true");
        this.uob.UOg = true;
        AppMethodBeat.o(260598);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
    public static final class c implements u.b {
        public static final c uoD = new c();

        static {
            AppMethodBeat.i(246545);
            AppMethodBeat.o(246545);
        }

        c() {
        }

        @Override // com.tencent.mm.ui.base.u.b
        public final void dU(View view) {
            WeImageView weImageView;
            TextView textView;
            AppMethodBeat.i(246544);
            if (!(view == null || (textView = (TextView) view.findViewById(R.id.ird)) == null)) {
                textView.setTextSize(1, 14.0f);
            }
            if (view == null || (weImageView = (WeImageView) view.findViewById(R.id.irc)) == null) {
                AppMethodBeat.o(246544);
                return;
            }
            weImageView.setImageResource(R.raw.icons_filled_done);
            AppMethodBeat.o(246544);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class f implements o.f {
        final /* synthetic */ v uoA;

        f(v vVar) {
            this.uoA = vVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(246553);
            kotlin.g.b.p.g(mVar, LocaleUtil.ITALIAN);
            if (mVar.gKQ()) {
                Context context = this.uoA.hwr.getContext();
                kotlin.g.b.p.g(context, "root.context");
                int color = context.getResources().getColor(R.color.Red);
                Context context2 = this.uoA.hwr.getContext();
                kotlin.g.b.p.g(context2, "root.context");
                mVar.a(TbsListener.ErrorCode.STARTDOWNLOAD_3, color, context2.getResources().getString(R.string.d7f));
            }
            AppMethodBeat.o(246553);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class g implements o.g {
        final /* synthetic */ String hLl;
        final /* synthetic */ v uoA;

        g(v vVar, String str) {
            this.uoA = vVar;
            this.hLl = str;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(246559);
            kotlin.g.b.p.g(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case TbsListener.ErrorCode.STARTDOWNLOAD_3 /*{ENCODED_INT: 162}*/:
                    com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                    com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
                    if (finderLiveAssistant != null) {
                        finderLiveAssistant.c(this.hLl, new kotlin.g.a.m<ayt, apg, x>(this) {
                            /* class com.tencent.mm.plugin.finder.live.plugin.v.g.AnonymousClass1 */
                            final /* synthetic */ g uoH;

                            {
                                this.uoH = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                            @Override // kotlin.g.a.m
                            public final /* synthetic */ x invoke(ayt ayt, apg apg) {
                                AppMethodBeat.i(246558);
                                apg apg2 = apg;
                                kotlin.g.b.p.h(ayt, "req");
                                kotlin.g.b.p.h(apg2, "ret");
                                if (apg2.retCode == 0) {
                                    Context context = this.uoH.uoA.hwr.getContext();
                                    kotlin.g.b.p.g(context, "root.context");
                                    String string = context.getResources().getString(R.string.cyj);
                                    kotlin.g.b.p.g(string, "root.context.resources.g…ile_join_black_list_done)");
                                    u.a(this.uoH.uoA.hwr.getContext(), string, AnonymousClass1.uoI);
                                    Log.i("Finder.LiveCommentPlugin", "kicked member succ" + this.uoH.hLl);
                                } else {
                                    Context context2 = this.uoH.uoA.hwr.getContext();
                                    kotlin.g.b.p.g(context2, "root.context");
                                    String string2 = context2.getResources().getString(R.string.cyk);
                                    kotlin.g.b.p.g(string2, "root.context.resources.g…ile_join_black_list_fail)");
                                    u.a(this.uoH.uoA.hwr.getContext(), string2, AnonymousClass2.uoJ);
                                    Log.i("Finder.LiveCommentPlugin", "kicked member failed:" + apg2.retCode);
                                }
                                x xVar = x.SXb;
                                AppMethodBeat.o(246558);
                                return xVar;
                            }
                        });
                        AppMethodBeat.o(246559);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(246559);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(246577);
        super.unMount();
        com.tencent.mm.plugin.finder.view.i iVar = com.tencent.mm.plugin.finder.view.i.wnk;
        com.tencent.mm.plugin.finder.view.i.dGO();
        dhb();
        this.uol = true;
        AppMethodBeat.o(246577);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        AppMethodBeat.i(246578);
        if (isLandscape() || this.uol) {
            AppMethodBeat.o(246578);
            return true;
        }
        AppMethodBeat.o(246578);
        return false;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class o implements Runnable {
        final /* synthetic */ v uoA;

        o(v vVar) {
            this.uoA = vVar;
        }

        public final void run() {
            AppMethodBeat.i(246573);
            v.a(this.uoA);
            v.dhc();
            AppMethodBeat.o(246573);
        }
    }

    private final boolean dgZ() {
        AppMethodBeat.i(246580);
        if (this.uob.getItemCount() != 0) {
            RecyclerView.LayoutManager layoutManager = this.hPs.getLayoutManager();
            if (layoutManager == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(246580);
                throw tVar;
            } else if (((LinearLayoutManager) layoutManager).ku() == this.uob.getItemCount() - 1) {
                com.tencent.mm.plugin.finder.view.i iVar = com.tencent.mm.plugin.finder.view.i.wnk;
                if (!com.tencent.mm.plugin.finder.view.i.isShowing()) {
                    AppMethodBeat.o(246580);
                    return true;
                }
            }
        }
        AppMethodBeat.o(246580);
        return false;
    }

    private final void eb(List<t> list) {
        boolean z;
        AppMethodBeat.i(246581);
        List<t> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z || getLiveData().uEO == -1) {
            Log.i("Finder.LiveCommentPlugin", "[updateMessagesOnViewAttach] curVisiableFirstPosition:" + getLiveData().uEP);
            AppMethodBeat.o(246581);
            return;
        }
        this.hPs.post(new p(this, list));
        AppMethodBeat.o(246581);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class p implements Runnable {
        final /* synthetic */ v uoA;
        final /* synthetic */ List uoO;

        p(v vVar, List list) {
            this.uoA = vVar;
            this.uoO = list;
        }

        public final void run() {
            int i2;
            AppMethodBeat.i(246575);
            v.a(this.uoA, this.uoO);
            this.uoA.dtY = this.uoA.getLiveData().uER;
            boolean z = this.uoA.getLiveData().uEQ;
            int i3 = this.uoA.getLiveData().uEP;
            long j2 = this.uoA.getLiveData().uDW - this.uoA.dtY;
            Log.i("Finder.LiveCommentPlugin", "[updateMessagesOnViewAttach] readCount:" + this.uoA.dtY + ", unreadCount" + j2 + ",reachLast" + z + ", position" + i3);
            if (this.uoA.uob.getItemCount() > 0) {
                if (z) {
                    this.uoA.hPs.post(new Runnable(this) {
                        /* class com.tencent.mm.plugin.finder.live.plugin.v.p.AnonymousClass1 */
                        final /* synthetic */ p uoP;

                        {
                            this.uoP = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(246574);
                            v.a(this.uoP.uoA);
                            AppMethodBeat.o(246574);
                        }
                    });
                    AppMethodBeat.o(246575);
                    return;
                }
                if (i3 < 0) {
                    i2 = 0;
                } else {
                    i2 = i3 >= this.uoA.uob.getItemCount() ? this.uoA.uob.getItemCount() - 1 : i3;
                }
                RecyclerView recyclerView = this.uoA.hPs;
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin$updateMessagesOnViewAttach$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin$updateMessagesOnViewAttach$1", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
                v.b(this.uoA, j2);
            }
            AppMethodBeat.o(246575);
        }
    }

    private final void dha() {
        AppMethodBeat.i(246582);
        RecyclerView recyclerView = this.hPs;
        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(kotlin.k.j.mZ(this.uob.getItemCount() - 1, 0), new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin", "commentScrollToEnd", "()V", "Undefined", "scrollToPosition", "(I)V");
        recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin", "commentScrollToEnd", "()V", "Undefined", "scrollToPosition", "(I)V");
        this.dtY = getLiveData().uDW;
        AppMethodBeat.o(246582);
    }

    private final void EL(long j2) {
        String str;
        AppMethodBeat.i(246583);
        if (j2 <= 0 || !getLiveData().uDD) {
            aHw();
            AppMethodBeat.o(246583);
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
        kotlin.g.b.p.g(context, "root.context");
        String string = context.getResources().getString(R.string.cxq);
        kotlin.g.b.p.g(string, "root.context.resources.g…der_live_new_comment_tip)");
        String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
        kotlin.g.b.p.g(format, "java.lang.String.format(format, *args)");
        textView.setText(format);
        AppMethodBeat.o(246583);
    }

    private final void aHw() {
        AppMethodBeat.i(246584);
        this.hPq.setVisibility(8);
        AppMethodBeat.o(246584);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin$updateComments$result$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-finder_release"})
    public static final class n extends c.a {
        final /* synthetic */ List hPD;
        final /* synthetic */ v uoA;

        n(v vVar, List list) {
            this.uoA = vVar;
            this.hPD = list;
        }

        @Override // android.support.v7.h.c.a
        public final int aB() {
            AppMethodBeat.i(246569);
            int size = this.uoA.uob.hXy.size();
            AppMethodBeat.o(246569);
            return size;
        }

        @Override // android.support.v7.h.c.a
        public final int aC() {
            AppMethodBeat.i(246570);
            int size = this.hPD.size();
            AppMethodBeat.o(246570);
            return size;
        }

        @Override // android.support.v7.h.c.a
        public final boolean i(int i2, int i3) {
            AppMethodBeat.i(246571);
            boolean j2 = kotlin.g.b.p.j((t) kotlin.a.j.L(this.uoA.uob.hXy, i2), (t) kotlin.a.j.L(this.hPD, i3));
            AppMethodBeat.o(246571);
            return j2;
        }

        @Override // android.support.v7.h.c.a
        public final boolean j(int i2, int i3) {
            AppMethodBeat.i(246572);
            boolean j2 = kotlin.g.b.p.j((t) kotlin.a.j.L(this.uoA.uob.hXy, i2), (t) kotlin.a.j.L(this.hPD, i3));
            AppMethodBeat.o(246572);
            return j2;
        }
    }

    private final void aj(List<? extends t> list) {
        AppMethodBeat.i(246585);
        c.b a2 = android.support.v7.h.c.a(new n(this, list), false);
        kotlin.g.b.p.g(a2, "DiffUtil.calculateDiff(o…      }\n        }, false)");
        a2.a(new m(this, list));
        AppMethodBeat.o(246585);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin$updateComments$1", "Landroid/support/v7/util/ListUpdateCallback;", "onChanged", "", "position", "", "count", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-finder_release"})
    public static final class m implements android.support.v7.h.d {
        final /* synthetic */ List hPD;
        final /* synthetic */ v uoA;

        m(v vVar, List list) {
            this.uoA = vVar;
            this.hPD = list;
        }

        @Override // android.support.v7.h.d
        public final void c(int i2, int i3, Object obj) {
            AppMethodBeat.i(246565);
            Log.d("Finder.LiveCommentPlugin", "onChanged position:" + i2 + ", count:" + i3);
            this.uoA.uob.hXy.clear();
            this.uoA.uob.hXy.addAll(this.hPD);
            this.uoA.uob.aq(i2, i3);
            AppMethodBeat.o(246565);
        }

        @Override // android.support.v7.h.d
        public final void l(int i2, int i3) {
            AppMethodBeat.i(246566);
            Log.d("Finder.LiveCommentPlugin", "onMoved fromPosition:" + i2 + ", toPosition:" + i3);
            this.uoA.uob.ar(i2, i3);
            AppMethodBeat.o(246566);
        }

        @Override // android.support.v7.h.d
        public final void f(int i2, int i3) {
            AppMethodBeat.i(246567);
            Log.d("Finder.LiveCommentPlugin", "onInserted position:" + i2 + ", count:" + i3);
            this.uoA.uob.hXy.clear();
            this.uoA.uob.hXy.addAll(this.hPD);
            this.uoA.uob.as(i2, i3);
            AppMethodBeat.o(246567);
        }

        @Override // android.support.v7.h.d
        public final void k(int i2, int i3) {
            AppMethodBeat.i(246568);
            Log.d("Finder.LiveCommentPlugin", "onRemoved position:" + i2 + ", count:" + i3);
            this.uoA.uob.hXy.clear();
            this.uoA.uob.hXy.addAll(this.hPD);
            this.uoA.uob.at(i2, i3);
            AppMethodBeat.o(246568);
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
        AppMethodBeat.i(246586);
        kotlin.g.b.p.h(cVar, "status");
        switch (w.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                if (getLiveData().uDD && ((bundle != null && bundle.getBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW")) || isLandscape())) {
                    List<t> list = getLiveData().uDs;
                    kotlin.g.b.p.g(list, "liveData.msgList");
                    eb(list);
                }
                this.uom = System.currentTimeMillis();
                AppMethodBeat.o(246586);
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
                Log.i("Finder.LiveCommentPlugin", "comment move distance:" + i2 + ",has change:" + this.uod);
                if ((!this.uod && i2 > 0) || (this.uod && i2 < 0)) {
                    if (this.uod) {
                        z3 = false;
                    }
                    this.uod = z3;
                    ViewGroup.LayoutParams layoutParams = this.hwr.getLayoutParams();
                    if (layoutParams == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        AppMethodBeat.o(246586);
                        throw tVar;
                    }
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += i2;
                }
                AppMethodBeat.o(246586);
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
                    kotlin.g.b.p.g(str, "param.getString(ILiveSta…INDER_LIVE_COMMENT) ?: \"\"");
                    List<t> list2 = getLiveData().uDs;
                    kotlin.g.b.p.g(list2, "liveData.msgList");
                    kotlin.a.j.c((List) list2, (kotlin.g.a.b) new k(str));
                    com.tencent.mm.ac.d.h(new j(this, bundle));
                    AppMethodBeat.o(246586);
                    return;
                }
                AppMethodBeat.o(246586);
                return;
            case 5:
                aHw();
                dha();
                AppMethodBeat.o(246586);
                return;
            case 6:
                AppMethodBeat.o(246586);
                return;
            case 7:
                com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                com.tencent.mm.plugin.finder.utils.m.a((d) this, true);
                AppMethodBeat.o(246586);
                return;
            case 8:
                if (bundle != null) {
                    z4 = bundle.getBoolean("PARAM_FINDER_LIVE_SCREEN_CLEAR");
                }
                if (z4) {
                    dhb();
                    AppMethodBeat.o(246586);
                    return;
                }
                List<t> list3 = getLiveData().uDs;
                kotlin.g.b.p.g(list3, "liveData.msgList");
                eb(list3);
                AppMethodBeat.o(246586);
                return;
            case 9:
                dhb();
                AppMethodBeat.o(246586);
                return;
            case 10:
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
        AppMethodBeat.o(246586);
    }

    private final void dhb() {
        AppMethodBeat.i(246587);
        if (this.dtY > 0) {
            getLiveData().uEQ = dgZ();
            getLiveData().uER = kotlin.k.j.aM(getLiveData().uER, this.dtY);
        }
        AppMethodBeat.o(246587);
    }

    private final void nq(boolean z) {
        AppMethodBeat.i(246588);
        z.f fVar = new z.f();
        fVar.SYG = (T) this.hwr.findViewById(R.id.co0);
        if (z) {
            this.uoc.ulL.clear();
            this.uoc.dgJ();
            aHw();
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "context");
            com.tencent.mm.pluginsdk.ui.span.m mVar = new com.tencent.mm.pluginsdk.ui.span.m(context.getResources().getString(R.string.cr1, context.getResources().getString(R.string.crg)));
            String string = context.getResources().getString(R.string.cr2);
            kotlin.g.b.p.g(string, "context.resources.getStr…_annoucement_replacement)");
            m.a aVar = com.tencent.mm.plugin.finder.live.model.m.ujk;
            Drawable atF = m.a.atF(string);
            n.a aVar2 = com.tencent.mm.plugin.finder.live.model.n.ujr;
            float f2 = com.tencent.mm.plugin.finder.live.model.n.ujp;
            n.a aVar3 = com.tencent.mm.plugin.finder.live.model.n.ujr;
            float f3 = com.tencent.mm.plugin.finder.live.model.n.ujp;
            Context context2 = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context2, "MMApplicationContext.getContext()");
            int color = context2.getResources().getColor(R.color.BW_100_Alpha_0_8);
            n.a aVar4 = com.tencent.mm.plugin.finder.live.model.n.ujr;
            int i2 = com.tencent.mm.plugin.finder.live.model.n.ujn;
            Context context3 = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context3, "MMApplicationContext.getContext()");
            int color2 = context3.getResources().getColor(R.color.BW_0_Alpha_0_8);
            n.a aVar5 = com.tencent.mm.plugin.finder.live.model.n.ujr;
            mVar.a(new com.tencent.mm.plugin.finder.live.model.m(atF, new com.tencent.mm.plugin.finder.live.model.n(string, f2, f3, color, i2, color2, com.tencent.mm.plugin.finder.live.model.n.ujo)), string, 0);
            z.f fVar2 = new z.f();
            View findViewById = fVar.SYG.findViewById(R.id.egb);
            kotlin.g.b.p.g(findViewById, "banComment.findViewById<…_comment_item_content_tv)");
            ViewParent parent = ((NeatTextView) findViewById).getParent();
            if (parent == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
                AppMethodBeat.o(246588);
                throw tVar;
            }
            fVar2.SYG = (T) ((RelativeLayout) parent);
            View findViewById2 = fVar.SYG.findViewById(R.id.egb);
            kotlin.g.b.p.g(findViewById2, "banComment.findViewById<…_comment_item_content_tv)");
            ViewParent parent2 = ((NeatTextView) findViewById2).getParent();
            if (parent2 == null) {
                kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
                AppMethodBeat.o(246588);
                throw tVar2;
            }
            ((RelativeLayout) parent2).setPadding(0, fVar2.SYG.getPaddingTop(), fVar2.SYG.getPaddingRight(), fVar2.SYG.getPaddingBottom());
            ((NeatTextView) fVar.SYG.findViewById(R.id.egb)).aw(mVar);
            T t = fVar.SYG;
            kotlin.g.b.p.g(t, "banComment");
            t.setVisibility(0);
            fVar.SYG.post(new h(fVar, fVar2, mVar));
            fVar.SYG.postDelayed(new i(this), 3000);
            AppMethodBeat.o(246588);
            return;
        }
        EL(0);
        b bVar = this.uoc;
        List<awq> list = getLiveData().uDt;
        kotlin.g.b.p.g(list, "liveData.bulletCommetList");
        bVar.dZ(list);
        T t2 = fVar.SYG;
        kotlin.g.b.p.g(t2, "banComment");
        t2.setVisibility(8);
        AppMethodBeat.o(246588);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class h implements Runnable {
        final /* synthetic */ z.f uoK;
        final /* synthetic */ z.f uoL;
        final /* synthetic */ com.tencent.mm.pluginsdk.ui.span.m uoM;

        h(z.f fVar, z.f fVar2, com.tencent.mm.pluginsdk.ui.span.m mVar) {
            this.uoK = fVar;
            this.uoL = fVar2;
            this.uoM = mVar;
        }

        public final void run() {
            AppMethodBeat.i(246560);
            NeatTextView neatTextView = (NeatTextView) this.uoK.SYG.findViewById(R.id.egb);
            kotlin.g.b.p.g(neatTextView, "textView");
            if (neatTextView.getLineCount() > 1) {
                ViewParent parent = neatTextView.getParent();
                if (parent == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
                    AppMethodBeat.o(246560);
                    throw tVar;
                }
                ((RelativeLayout) parent).setPadding(0, this.uoL.SYG.getPaddingTop(), this.uoL.SYG.getPaddingRight(), this.uoL.SYG.getPaddingBottom());
                neatTextView.setSpacingAdd(5);
                SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(this.uoM);
                valueOf.setSpan(new LeadingMarginSpan.Standard(0, at.fromDPToPix(MMApplicationContext.getContext(), 6)), 0, this.uoM.length(), 33);
                neatTextView.aw(valueOf);
            }
            AppMethodBeat.o(246560);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class i implements Runnable {
        final /* synthetic */ v uoA;

        i(v vVar) {
            this.uoA = vVar;
        }

        public final void run() {
            AppMethodBeat.i(246561);
            v.e(this.uoA);
            AppMethodBeat.o(246561);
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final void reset() {
        AppMethodBeat.i(246589);
        this.uob.hXy.clear();
        this.uob.notifyDataSetChanged();
        AppMethodBeat.o(246589);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final void a(Bundle bundle, Object obj, long j2) {
        String str;
        AppMethodBeat.i(260599);
        if (bundle == null || (str = bundle.getString("ACTION_POST_PORTRAIT", "")) == null) {
            str = "";
        }
        if (kotlin.g.b.p.j(str, uuf)) {
            com.tencent.mm.ac.d.a(j2, new q(this, bundle, obj, j2));
        }
        AppMethodBeat.o(260599);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class q implements Runnable {
        final /* synthetic */ Bundle ULG;
        final /* synthetic */ Object ULH;
        final /* synthetic */ v uoA;
        final /* synthetic */ long utG;

        q(v vVar, Bundle bundle, Object obj, long j2) {
            this.uoA = vVar;
            this.ULG = bundle;
            this.ULH = obj;
            this.utG = j2;
        }

        public final void run() {
            AppMethodBeat.i(260597);
            if (!this.uoA.isFinished()) {
                com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
                if (finderLiveAssistant != null) {
                    Object obj = this.ULH;
                    a aVar = v.uoz;
                    finderLiveAssistant.k(obj, v.ULy);
                    AppMethodBeat.o(260597);
                    return;
                }
                AppMethodBeat.o(260597);
                return;
            }
            Log.i("Finder.LiveCommentPlugin", "goToFinderProfileImpl delayMs:" + this.utG + ",isFinished!");
            AppMethodBeat.o(260597);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin$statusChange$1$2"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ Bundle $param$inlined;
        final /* synthetic */ v uoA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(v vVar, Bundle bundle) {
            super(0);
            this.uoA = vVar;
            this.$param$inlined = bundle;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246562);
            com.tencent.mm.plugin.finder.live.view.adapter.c cVar = this.uoA.uob;
            List<t> list = this.uoA.getLiveData().uDs;
            kotlin.g.b.p.g(list, "liveData.msgList");
            kotlin.g.b.p.h(list, "commentList");
            cVar.hXy.clear();
            cVar.hXy.addAll(list);
            this.uoA.uob.notifyDataSetChanged();
            x xVar = x.SXb;
            AppMethodBeat.o(246562);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveCommentPlugin$checkComment$1$1"})
    public static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ v uoA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(v vVar) {
            super(0);
            this.uoA = vVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246543);
            this.uoA.hPs.setVisibility(8);
            x xVar = x.SXb;
            AppMethodBeat.o(246543);
            return xVar;
        }
    }

    public final void ea(List<t> list) {
        AppMethodBeat.i(246579);
        kotlin.g.b.p.h(list, "msgList");
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
            if (!getLiveData().uit && !getLiveData().uEe && !getLiveData().diZ()) {
                ViewGroup.LayoutParams layoutParams = this.hwr.getLayoutParams();
                if (layoutParams == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    AppMethodBeat.o(246579);
                    throw tVar;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = au.aD(this.hwr.getContext());
            } else if (this.uof) {
                ViewGroup.LayoutParams layoutParams2 = this.hwr.getLayoutParams();
                if (layoutParams2 == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    AppMethodBeat.o(246579);
                    throw tVar2;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = au.aD(this.hwr.getContext()) + com.tencent.mm.view.d.e(MMApplicationContext.getContext(), 72.0f) + this.uog;
            } else {
                ViewGroup.LayoutParams layoutParams3 = this.hwr.getLayoutParams();
                if (layoutParams3 == null) {
                    kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    AppMethodBeat.o(246579);
                    throw tVar3;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin = au.aD(this.hwr.getContext()) + com.tencent.mm.view.d.e(MMApplicationContext.getContext(), 72.0f);
            }
        }
        Message obtainMessage = bkj().obtainMessage();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        obtainMessage.obj = arrayList;
        bkj().sendMessage(obtainMessage);
        AppMethodBeat.o(246579);
    }

    public static final /* synthetic */ void dhc() {
        AppMethodBeat.i(246593);
        com.tencent.mm.plugin.finder.view.i iVar = com.tencent.mm.plugin.finder.view.i.wnk;
        com.tencent.mm.plugin.finder.view.i.dGO();
        AppMethodBeat.o(246593);
    }

    public static final /* synthetic */ void b(v vVar, List list) {
        boolean z;
        Boolean bool;
        boolean z2;
        awe awe;
        AppMethodBeat.i(246597);
        List list2 = list;
        if (!(list2 == null || list2.isEmpty())) {
            StringBuilder sb = new StringBuilder("liveMessageCallback liveId:");
            com.tencent.mm.plugin.finder.live.viewmodel.g liveData = vVar.getLiveData();
            Log.i("Finder.LiveCommentPlugin", sb.append(((liveData == null || (awe = liveData.liveInfo) == null) ? null : Long.valueOf(awe.liveId)).longValue()).append(",msgListCount:").append(list.size()).toString());
            boolean dgZ = vVar.dgZ();
            long j2 = vVar.getLiveData().uDW - vVar.dtY;
            vVar.aj(list);
            if (vVar.uob.getItemCount() > 0) {
                if (dgZ) {
                    vVar.hPs.post(new o(vVar));
                } else if (j2 > 0) {
                    vVar.EL(j2);
                }
            }
        }
        if (kotlin.g.b.p.j(vVar.getLiveData().uES, Boolean.TRUE)) {
            b bVar = vVar.uoc;
            List<awq> list3 = vVar.getLiveData().uDt;
            kotlin.g.b.p.g(list3, "liveData.bulletCommetList");
            bVar.dZ(list3);
        }
        b.C0376b.a(vVar.hOp, b.c.hNb);
        b.C0376b.a(vVar.hOp, b.c.hNh);
        if (!list.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        if (z && (bool = vVar.getLiveData().uES) != null) {
            boolean booleanValue = bool.booleanValue();
            if (vVar.uoe != booleanValue) {
                if (System.currentTimeMillis() - vVar.uom < 3000) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                vVar.uoe = booleanValue;
                if (vVar.uoe) {
                    vVar.hPs.setVisibility(0);
                    vVar.nq(false);
                    vVar.dha();
                } else if (z2) {
                    com.tencent.mm.ac.d.a(3000, new b(vVar));
                } else {
                    vVar.hPs.setVisibility(8);
                    Context context = MMApplicationContext.getContext();
                    kotlin.g.b.p.g(context, "context");
                    kotlin.g.b.p.g(context.getResources().getString(R.string.crg), "context.resources.getStr…e_comment_anchor_disable)");
                    vVar.nq(true);
                }
                Log.i("Finder.LiveCommentPlugin", "enableLiveRoomComment:".concat(String.valueOf(booleanValue)));
                AppMethodBeat.o(246597);
                return;
            }
        }
        AppMethodBeat.o(246597);
    }

    public static final /* synthetic */ void a(v vVar, avn avn) {
        String str;
        String str2;
        String str3 = null;
        AppMethodBeat.i(246598);
        com.tencent.mm.b.h<String, Long> hVar = vVar.getLiveData().uEw;
        FinderContact finderContact = avn.contact;
        if (finderContact == null || (str = finderContact.username) == null) {
            str = "";
        }
        Long l2 = (Long) hVar.get(str);
        if (System.currentTimeMillis() - (l2 != null ? l2.longValue() : 0) < ((long) uoy)) {
            u.makeText(vVar.hwr.getContext(), vVar.hwr.getContext().getString(R.string.czt), 0).show();
            com.tencent.mm.b.h<String, Long> hVar2 = vVar.getLiveData().uEw;
            FinderContact finderContact2 = avn.contact;
            if (finderContact2 != null) {
                str2 = finderContact2.username;
            } else {
                str2 = null;
            }
            hVar2.put(str2, Long.valueOf(System.currentTimeMillis()));
            AppMethodBeat.o(246598);
            return;
        }
        com.tencent.mm.b.h<String, Long> hVar3 = vVar.getLiveData().uEw;
        FinderContact finderContact3 = avn.contact;
        if (finderContact3 != null) {
            str3 = finderContact3.username;
        }
        hVar3.put(str3, Long.valueOf(System.currentTimeMillis()));
        x.a aVar = com.tencent.mm.plugin.finder.cgi.x.ttF;
        aut a2 = x.a.a(avn);
        new com.tencent.mm.plugin.finder.cgi.x(a2, vVar.getLiveData(), new l(vVar)).aYI();
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        com.tencent.mm.plugin.finder.utils.m.eg(vVar.hwr);
        com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
        com.tencent.mm.plugin.finder.utils.m.a(a2, vVar.getLiveData());
        b.C0376b.a(vVar.hOp, b.c.hMb);
        if (vVar.hOp.getLiveRole() == 1) {
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.a(s.c.LIVE_ANCHOR_TICKLE, "");
            com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtC++;
        }
        AppMethodBeat.o(246598);
    }

    public static final /* synthetic */ void a(v vVar, boolean z, String str) {
        AppMethodBeat.i(246599);
        com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
        com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            finderLiveAssistant.a(str, z, new d(vVar));
            AppMethodBeat.o(246599);
            return;
        }
        AppMethodBeat.o(246599);
    }

    public static final /* synthetic */ void a(v vVar, t tVar) {
        AppMethodBeat.i(246600);
        if (tVar instanceof com.tencent.mm.plugin.finder.live.model.r) {
            x.a aVar = com.tencent.mm.plugin.finder.cgi.x.ttF;
            new com.tencent.mm.plugin.finder.cgi.x(x.a.a(((com.tencent.mm.plugin.finder.live.model.r) tVar).uke), vVar.getLiveData(), null).aYI();
            Context context = vVar.hwr.getContext();
            kotlin.g.b.p.g(context, "root.context");
            String string = context.getResources().getString(R.string.crs);
            kotlin.g.b.p.g(string, "root.context.resources.g…nder_live_complaint_done)");
            u.a(vVar.hwr.getContext(), string, c.uoD);
        }
        AppMethodBeat.o(246600);
    }

    public static final /* synthetic */ void a(v vVar, String str) {
        AppMethodBeat.i(246601);
        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(vVar.hwr.getContext(), 1, true);
        eVar.setTitleView(aa.jQ(vVar.hwr.getContext()).inflate(R.layout.adi, (ViewGroup) null));
        eVar.hbr();
        eVar.a(new f(vVar));
        eVar.a(new g(vVar, str));
        eVar.dGm();
        AppMethodBeat.o(246601);
    }

    public static final /* synthetic */ void a(View view, t tVar) {
        AppMethodBeat.i(246602);
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (com.tencent.mm.plugin.finder.utils.m.a(tVar)) {
            view.setBackground(view.getContext().getDrawable(R.drawable.a04));
            AppMethodBeat.o(246602);
            return;
        }
        view.setBackground(view.getContext().getDrawable(R.drawable.a0g));
        AppMethodBeat.o(246602);
    }

    public static final /* synthetic */ void b(v vVar, String str) {
        AppMethodBeat.i(260600);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            Log.i("Finder.LiveCommentPlugin", "goToFinderProfile finderUsername:".concat(String.valueOf(str)));
            AppMethodBeat.o(260600);
            return;
        }
        boolean isLandscape = vVar.isLandscape();
        Log.i("Finder.LiveCommentPlugin", "goToFinderProfile isLandscape:".concat(String.valueOf(isLandscape)));
        if (isLandscape) {
            Bundle bundle = new Bundle();
            bundle.putString(ULy, str);
            d.a(vVar, uuf, bundle, 0, 4);
            AppMethodBeat.o(260600);
            return;
        }
        com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
        com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            s.a.a(finderLiveAssistant, false, str);
            AppMethodBeat.o(260600);
            return;
        }
        AppMethodBeat.o(260600);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static final /* synthetic */ void a(v vVar, int i2) {
        AppMethodBeat.i(260601);
        Log.i("Finder.LiveCommentPlugin", "handleRecvLuckyMoneyErr errCode:".concat(String.valueOf(i2)));
        switch (i2) {
            case 0:
                AppMethodBeat.o(260601);
                return;
            case 1:
                Bundle bundle = new Bundle();
                bundle.putInt("PARAM_FINDER_BOTTOM_TIP_SCENE", 1);
                vVar.hOp.statusChange(b.c.wlu, bundle);
                AppMethodBeat.o(260601);
                return;
            case 2:
                Bundle bundle2 = new Bundle();
                bundle2.putInt("PARAM_FINDER_BOTTOM_TIP_SCENE", 2);
                vVar.hOp.statusChange(b.c.wlu, bundle2);
                break;
        }
        AppMethodBeat.o(260601);
    }
}
