package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.asu;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e;
import java.util.Arrays;
import kotlin.g.a.r;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\bH\u0002J\"\u0010?\u001a\u00020=2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J6\u0010D\u001a\u00020=2\u0006\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020\b2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020=0JH\u0002J\u0010\u0010K\u001a\u00020=2\u0006\u0010L\u001a\u00020MH\u0002J\u0012\u0010N\u001a\u00020=2\b\u0010O\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010P\u001a\u00020=H\u0002J\b\u0010Q\u001a\u00020=H\u0002J\b\u0010R\u001a\u00020=H\u0002J\b\u0010S\u001a\u00020MH\u0016J\u0006\u0010T\u001a\u00020=J\u0010\u0010U\u001a\u00020=2\b\b\u0002\u0010V\u001a\u00020MJ$\u0010W\u001a\u00020=2\b\u0010B\u001a\u0004\u0018\u00010C2\b\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010Z\u001a\u00020[H\u0016J\u0018\u0010\\\u001a\u00020=2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\bH\u0002J\b\u0010`\u001a\u00020=H\u0002J\b\u0010a\u001a\u00020=H\u0002J\u0010\u0010b\u001a\u00020=2\u0006\u0010_\u001a\u00020\bH\u0002J\u0010\u0010c\u001a\u00020=2\u0006\u0010d\u001a\u00020\u0011H\u0002J\u0010\u0010e\u001a\u00020=2\u0006\u0010f\u001a\u00020\bH\u0002J\u001a\u0010g\u001a\u00020=2\u0006\u0010h\u001a\u00020i2\b\u0010j\u001a\u0004\u0018\u00010CH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\u0011XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0011XD¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0011XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000¨\u0006k"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "DEFAULT_PANEL_HEIGHT", "", "getDEFAULT_PANEL_HEIGHT", "()I", "setDEFAULT_PANEL_HEIGHT", "(I)V", "DEFAULT_TITLE_GROUP_HEIGHT", "getDEFAULT_TITLE_GROUP_HEIGHT", "setDEFAULT_TITLE_GROUP_HEIGHT", "PORTRAIT_ACTION_GOTO_PROFILE", "", "getPORTRAIT_ACTION_GOTO_PROFILE", "()Ljava/lang/String;", "PORTRAIT_ACTION_KEY_FINDER_USERNAME", "getPORTRAIT_ACTION_KEY_FINDER_USERNAME", "SHEET_MORE_ACTION_BAN_COMMENT", "SHEET_MORE_ACTION_BLACK_LIST", "SHEET_MORE_ACTION_GOTO_PROFILE", "SHEET_MORE_ACTION_RECOVER_COMMENT", "SHEET_MORE_ACTION_REPORT", "SHEET_REMOVE", "TAG", "backGroup", "Landroid/view/View;", "blankArea", "contentGroup", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "curSelectedContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "emptyActionTip", "Landroid/widget/TextView;", "emptyGroup", "emptyTip", "helpIcon", "kickMemberBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "loadingBar", "Landroid/widget/ProgressBar;", "membersAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMemberLinearAdapter;", "moreActionBottomSheet", "moreActionItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "recyclerRoot", "Landroid/widget/RelativeLayout;", "retryTip", "singleRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "singleTitleTv", "stickViewContainer", "titleGroup", "titleTipTv", "visibilityTipTv", "adjustPanelLayout", "", "titleGroupHeight", "applyState", "liveState", "uiState", "extraMsg", "Landroid/os/Bundle;", "buildConfirmDialog", "title", "item", "titleColor", "itemColor", "click", "Lkotlin/Function0;", "doCommentAction", "enableComment", "", "goToFinderProfile", "finderUsername", "hideMembersList", "initTitleGroupHeight", "kickMember", "onBackPress", "onGetLiveOnlineMemberFail", "onGetLiveOnlineMemberSuccess", "autoRefresh", "onPortraitDelayAction", "extraData", "", "delayMs", "", "prepareMenuItems", "menuItem", "Lcom/tencent/mm/ui/base/MMMenu;", "roleType", "showMembersListContent", "showMembersListLoading", "showMoreActionSheet", "showProfileSheet", ch.COL_USERNAME, "showTitle", "totalCnt", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "plugin-finder_release"})
public final class ap extends d {
    final String TAG = "Finder.FinderLiveMemberListPlugin";
    final String ULy = "PORTRAIT_ACTION_KEY_FINDER_USERNAME";
    final int UMF = 14;
    final com.tencent.mm.live.c.b hOp;
    private final TextView hRK;
    final TextView hRL;
    private final TextView hRM;
    final RecyclerView hRN;
    final ProgressBar hRO;
    final View hRR;
    final int hRp = 1;
    private final View hRx;
    final LiveBottomSheetPanel hRy;
    final int urZ = 10;
    final int usa = 11;
    final int usb = 12;
    final int usc = 13;
    private int usd;
    private int use;
    private final View usf;
    private final TextView usg;
    final View ush;
    private final RelativeLayout usi;
    private final View usj;
    private final TextView usk;
    private final TextView usl;
    private final View usm;
    private final com.tencent.mm.plugin.finder.live.view.adapter.g usn;
    avn uso;
    com.tencent.mm.ui.widget.a.e usp;
    com.tencent.mm.ui.widget.a.e usq;
    o.g usr;
    final String uuf = "PORTRAIT_ACTION_GOTO_PROFILE_MEMBERLIST";

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "success", "", "enable", "invoke"})
    public static final class e extends q implements kotlin.g.a.m<Boolean, Boolean, x> {
        final /* synthetic */ ap uss;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(ap apVar) {
            super(2);
            this.uss = apVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Boolean bool, Boolean bool2) {
            String string;
            String string2;
            AppMethodBeat.i(246857);
            boolean booleanValue = bool.booleanValue();
            boolean booleanValue2 = bool2.booleanValue();
            if (booleanValue) {
                b.C0376b.a(this.uss.hOp, b.c.hMU);
                if (booleanValue2) {
                    Context context = this.uss.hwr.getContext();
                    p.g(context, "root.context");
                    string2 = context.getResources().getString(R.string.cyq);
                } else {
                    Context context2 = this.uss.hwr.getContext();
                    p.g(context2, "root.context");
                    string2 = context2.getResources().getString(R.string.cyo);
                }
                p.g(string2, "if (enable) root.context…action_comment_forbidden)");
                u.makeText(this.uss.hwr.getContext(), string2, 0).show();
            } else {
                Context context3 = this.uss.hwr.getContext();
                p.g(context3, "root.context");
                String string3 = context3.getResources().getString(R.string.cyi);
                p.g(string3, "root.context.resources.g…ofile_action_fail_prefix)");
                if (booleanValue2) {
                    Context context4 = this.uss.hwr.getContext();
                    p.g(context4, "root.context");
                    string = context4.getResources().getString(R.string.cyl);
                } else {
                    Context context5 = this.uss.hwr.getContext();
                    p.g(context5, "root.context");
                    string = context5.getResources().getString(R.string.cyp);
                }
                p.g(string, "if (enable) root.context…e_action_recover_comment)");
                u.makeText(this.uss.hwr.getContext(), string3 + string, 0).show();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246857);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "req", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "invoke"})
    static final class f extends q implements kotlin.g.a.m<ayt, apg, x> {
        final /* synthetic */ ap uss;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(ap apVar) {
            super(2);
            this.uss = apVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(ayt ayt, apg apg) {
            String str;
            FinderContact finderContact;
            AppMethodBeat.i(246858);
            apg apg2 = apg;
            p.h(ayt, "req");
            p.h(apg2, "ret");
            if (apg2.retCode == 0) {
                b.C0376b.a(this.uss.hOp, b.c.hMU);
                Context context = this.uss.hwr.getContext();
                Context context2 = this.uss.hwr.getContext();
                p.g(context2, "root.context");
                u.makeText(context, context2.getResources().getString(R.string.cyj), 0).show();
                String str2 = this.uss.TAG;
                StringBuilder sb = new StringBuilder("kicked member succ");
                avn avn = this.uss.uso;
                if (avn == null || (finderContact = avn.contact) == null) {
                    str = null;
                } else {
                    str = finderContact.username;
                }
                Log.i(str2, sb.append(str).toString());
            } else {
                Context context3 = this.uss.hwr.getContext();
                Context context4 = this.uss.hwr.getContext();
                p.g(context4, "root.context");
                u.makeText(context3, context4.getResources().getString(R.string.cyk), 0).show();
                Log.i(this.uss.TAG, "kicked member failed:" + apg2.retCode);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246858);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "errCode", "", "errType", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveOnlineMemberResp;", "invoke"})
    static final class n extends q implements r<Integer, Integer, String, asu, x> {
        final /* synthetic */ ap uss;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(ap apVar) {
            super(4);
            this.uss = apVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.r
        public final /* synthetic */ x invoke(Integer num, Integer num2, String str, asu asu) {
            AppMethodBeat.i(260667);
            final int intValue = num.intValue();
            final int intValue2 = num2.intValue();
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.ap.n.AnonymousClass1 */
                final /* synthetic */ n UMG;

                {
                    this.UMG = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(260666);
                    if (this.UMG.uss.hwr.getVisibility() == 0) {
                        if (intValue2 == 0 && intValue == 0) {
                            this.UMG.uss.nw(false);
                        } else {
                            ap apVar = this.UMG.uss;
                            apVar.hRL.setVisibility(0);
                            apVar.hRO.setVisibility(8);
                            apVar.hRR.setVisibility(8);
                            apVar.hRN.setVisibility(8);
                            apVar.ush.setVisibility(8);
                            Log.i(apVar.TAG, "onGetLiveOnlineByRoomFail");
                        }
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(260666);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(260667);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ap(final ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(246872);
        this.hOp = bVar;
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        this.use = (int) (((float) au.az(MMApplicationContext.getContext()).y) * (((float) com.tencent.mm.plugin.finder.storage.c.duX()) / 100.0f));
        View findViewById = viewGroup.findViewById(R.id.cup);
        p.g(findViewById, "root.findViewById(R.id.f…bers_list_icon_btn_group)");
        this.usf = findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.cuv);
        p.g(findViewById2, "root.findViewById(R.id.f…ve_members_list_title_tv)");
        this.hRK = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.cur);
        p.g(findViewById3, "root.findViewById(R.id.f…e_members_list_retry_tip)");
        this.hRL = (TextView) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.cul);
        p.g(findViewById4, "root.findViewById(R.id.f…e_members_list_empty_tip)");
        this.hRM = (TextView) findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.cuk);
        p.g(findViewById5, "root.findViewById(R.id.f…rs_list_empty_action_tip)");
        this.usg = (TextView) findViewById5;
        View findViewById6 = viewGroup.findViewById(R.id.cum);
        p.g(findViewById6, "root.findViewById(R.id.f…ers_list_empty_tip_group)");
        this.ush = findViewById6;
        View findViewById7 = viewGroup.findViewById(R.id.cuj);
        p.g(findViewById7, "root.findViewById(R.id.f…embers_list_content_view)");
        this.hRN = (RecyclerView) findViewById7;
        View findViewById8 = viewGroup.findViewById(R.id.cuh);
        p.g(findViewById8, "root.findViewById(R.id.f…embers_list_content_area)");
        this.hRy = (LiveBottomSheetPanel) findViewById8;
        View findViewById9 = viewGroup.findViewById(R.id.cui);
        p.g(findViewById9, "root.findViewById(R.id.f…mbers_list_content_group)");
        this.usi = (RelativeLayout) findViewById9;
        View findViewById10 = viewGroup.findViewById(R.id.cuq);
        p.g(findViewById10, "root.findViewById(R.id.f…ive_members_list_loading)");
        this.hRO = (ProgressBar) findViewById10;
        View findViewById11 = viewGroup.findViewById(R.id.cug);
        p.g(findViewById11, "root.findViewById(R.id.f…_members_list_blank_area)");
        this.hRx = findViewById11;
        View findViewById12 = viewGroup.findViewById(R.id.cun);
        p.g(findViewById12, "root.findViewById(R.id.f…e_members_list_help_icon)");
        this.usj = findViewById12;
        View findViewById13 = viewGroup.findViewById(R.id.cuu);
        p.g(findViewById13, "root.findViewById(R.id.f…embers_list_title_tip_tv)");
        this.usk = (TextView) findViewById13;
        View findViewById14 = viewGroup.findViewById(R.id.cuw);
        p.g(findViewById14, "root.findViewById(R.id.f…s_list_visibility_tip_tv)");
        this.usl = (TextView) findViewById14;
        View findViewById15 = viewGroup.findViewById(R.id.cue);
        p.g(findViewById15, "root.findViewById(R.id.f…e_member_stick_container)");
        this.usm = findViewById15;
        this.usn = new com.tencent.mm.plugin.finder.live.view.adapter.g(this.hRN, this.usm);
        View findViewById16 = viewGroup.findViewById(R.id.cut);
        p.g(findViewById16, "root.findViewById(R.id.f…members_list_title_group)");
        this.hRR = findViewById16;
        this.usr = new g(this, viewGroup);
        ViewGroup.LayoutParams layoutParams = this.hRR.getLayoutParams();
        this.usd = layoutParams != null ? layoutParams.height : 0;
        if (this.usd <= 0) {
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            this.usd = context.getResources().getDimensionPixelOffset(R.dimen.cr);
        }
        Log.i(this.TAG, "initTitleGroupHeight:" + this.usd);
        this.hRy.setOnVisibilityListener(new kotlin.g.a.b<Boolean, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.ap.AnonymousClass1 */
            final /* synthetic */ ap uss;

            {
                this.uss = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(246846);
                if (!bool.booleanValue()) {
                    b.C0376b.a(this.uss.hOp, b.c.hLP);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(246846);
                return xVar;
            }
        });
        this.usf.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.ap.AnonymousClass2 */
            final /* synthetic */ ap uss;

            {
                this.uss = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(246847);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.uss.hRy.hide();
                if (this.uss.hOp.getLiveRole() == 1) {
                    com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.a(s.c.SEE_GIFT_LIST, String.valueOf(s.ak.RETURN_LIVE_ROOM.action));
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(246847);
            }
        });
        this.hRx.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.ap.AnonymousClass3 */
            final /* synthetic */ ap uss;

            {
                this.uss = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(246848);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.uss.hRy.hide();
                if (this.uss.hOp.getLiveRole() == 1) {
                    com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.a(s.c.SEE_GIFT_LIST, String.valueOf(s.ak.RETURN_LIVE_ROOM.action));
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(246848);
            }
        });
        RecyclerView recyclerView = this.hRN;
        viewGroup.getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager());
        this.hRN.setAdapter(this.usn);
        this.usn.hXE = new kotlin.g.a.b<avn, x>(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.ap.AnonymousClass4 */
            final /* synthetic */ ap uss;

            {
                this.uss = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(avn avn) {
                int i2;
                String str;
                String str2;
                String str3;
                FinderContact finderContact;
                FinderContact finderContact2;
                FinderContact finderContact3;
                FinderContact finderContact4;
                FinderContact finderContact5;
                String str4;
                Integer num = null;
                AppMethodBeat.i(246849);
                avn avn2 = avn;
                com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
                    if (this.uss.hOp.getLiveRole() == 0) {
                        com.tencent.mm.plugin.finder.report.live.m mVar2 = com.tencent.mm.plugin.finder.report.live.m.vli;
                        com.tencent.mm.plugin.finder.report.live.m.a(s.aw.CLICK_VISITOR_IN_HOT_LIST, "", 0);
                    }
                    this.uss.uso = avn2;
                    com.tencent.mm.plugin.finder.utils.m mVar3 = com.tencent.mm.plugin.finder.utils.m.vVH;
                    avn avn3 = this.uss.uso;
                    boolean byb = com.tencent.mm.plugin.finder.utils.m.byb((avn3 == null || (finderContact4 = avn3.contact) == null) ? null : finderContact4.username);
                    if (avn2 != null) {
                        i2 = avn2.Viq;
                    } else {
                        i2 = 1;
                    }
                    String str5 = this.uss.TAG;
                    StringBuilder sb = new StringBuilder("itemClick username:");
                    avn avn4 = this.uss.uso;
                    if (avn4 == null || (finderContact3 = avn4.contact) == null) {
                        str = null;
                    } else {
                        str = finderContact3.username;
                    }
                    StringBuilder append = sb.append(str).append(", nickname:");
                    avn avn5 = this.uss.uso;
                    if (avn5 == null || (finderContact2 = avn5.contact) == null) {
                        str2 = null;
                    } else {
                        str2 = finderContact2.nickname;
                    }
                    StringBuilder append2 = append.append(str2).append(", disableComment:");
                    avn avn6 = this.uss.uso;
                    if (avn6 != null) {
                        num = Integer.valueOf(avn6.LGh);
                    }
                    Log.i(str5, append2.append(num).append(",isMySelf:").append(byb).append(",userRoleType:").append(i2).toString());
                    com.tencent.mm.plugin.finder.utils.m mVar4 = com.tencent.mm.plugin.finder.utils.m.vVH;
                    if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
                        ap apVar = this.uss;
                        avn avn7 = this.uss.uso;
                        if (avn7 == null || (finderContact = avn7.contact) == null || (str3 = finderContact.username) == null) {
                            str3 = "";
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString("PARAM_MEMBERS_PROFILE_USERNAME", str3);
                        bundle.putBoolean("PARAM_MEMBERS_PROFILE_NEED_NOTIFY_CLOSE", false);
                        bundle.putInt("PARAM_MEMBERS_PROFILE_SOURCE_TYPE", 1);
                        apVar.hOp.statusChange(b.c.hMk, bundle);
                        apVar.hRy.hide();
                        if (apVar.hOp.getLiveRole() == 1) {
                            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                            com.tencent.mm.plugin.finder.report.live.k.a(s.ak.EXPOSE_USER_FINDER_HALF_BOARD);
                        }
                    } else if (!byb) {
                        ap apVar2 = this.uss;
                        if (apVar2.usp == null) {
                            apVar2.usp = new com.tencent.mm.ui.widget.a.e(apVar2.hwr.getContext(), 1, false);
                        }
                        com.tencent.mm.ui.widget.a.e eVar = apVar2.usp;
                        if (eVar != null) {
                            eVar.hbr();
                        }
                        com.tencent.mm.ui.widget.a.e eVar2 = apVar2.usp;
                        if (eVar2 != null) {
                            eVar2.a(new k(apVar2, i2));
                        }
                        com.tencent.mm.ui.widget.a.e eVar3 = apVar2.usp;
                        if (eVar3 != null) {
                            eVar3.a(apVar2.usr);
                        }
                        com.tencent.mm.ui.widget.a.e eVar4 = apVar2.usp;
                        if (eVar4 != null) {
                            eVar4.b(new l(apVar2));
                        }
                        com.tencent.mm.ui.widget.a.e eVar5 = apVar2.usp;
                        if (eVar5 != null) {
                            eVar5.dGm();
                        }
                        if (i2 == 3) {
                            com.tencent.mm.plugin.finder.report.live.m mVar5 = com.tencent.mm.plugin.finder.report.live.m.vli;
                            com.tencent.mm.plugin.finder.report.live.m.a(s.aw.EXPOSE_HALF_BOARD_HOT_LIST, "", 0);
                        }
                    }
                } else if (!(avn2 == null || avn2.Viq != 3 || (finderContact5 = avn2.contact) == null || (str4 = finderContact5.username) == null)) {
                    com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                    com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
                    if (finderLiveAssistant != null) {
                        p.g(str4, LocaleUtil.ITALIAN);
                        s.a.a(finderLiveAssistant, false, str4);
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(246849);
                return xVar;
            }
        };
        this.usn.uBe = new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.ap.AnonymousClass5 */
            final /* synthetic */ ap uss;

            {
                this.uss = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(246850);
                this.uss.hRy.hide();
                b.C0376b.a(this.uss.hOp, b.c.hMG);
                if (this.uss.hOp.getLiveRole() == 0) {
                    com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
                    com.tencent.mm.plugin.finder.report.live.m.a(s.aw.CLICK_READ_BTN_HOT_LIST, "", 0);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(246850);
                return xVar;
            }
        };
        int i2 = this.usd;
        int aD = au.aD(this.hwr.getContext());
        if (!isLandscape()) {
            this.hRy.setTranslationY((float) au.az(this.hwr.getContext()).y);
            this.hRy.getLayoutParams().height = this.use;
            ViewGroup.LayoutParams layoutParams2 = this.usi.getLayoutParams();
            if (layoutParams2 == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(246872);
                throw tVar;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin += aD;
            this.usi.getLayoutParams().height = (this.use - i2) - aD;
            this.hRN.getLayoutParams().height = (this.use - i2) - aD;
        } else {
            this.hRy.getLayoutParams().width = au.az(this.hwr.getContext()).y;
            this.hRy.setTranslationX((float) au.az(this.hwr.getContext()).x);
            this.usi.getLayoutParams().height = au.az(this.hwr.getContext()).y - i2;
            this.hRN.getLayoutParams().height = au.az(this.hwr.getContext()).y - i2;
        }
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.hVh().value().intValue() == 1) {
            com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
            if (!com.tencent.mm.plugin.finder.utils.m.dBP()) {
                this.hRM.setText(this.hRM.getContext().getText(R.string.j_r));
            }
        }
        this.usg.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.ap.AnonymousClass6 */
            final /* synthetic */ ap uss;

            {
                this.uss = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(246851);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FinderObject finderObject = this.uss.getLiveData().uDz;
                if (finderObject != null) {
                    this.uss.getLiveData().uDS = false;
                    s.a aVar = com.tencent.mm.plugin.finder.utils.s.vWt;
                    Context context = viewGroup.getContext();
                    if (context == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                        AppMethodBeat.o(246851);
                        throw tVar;
                    }
                    FinderItem.a aVar2 = FinderItem.Companion;
                    s.a.a(aVar, (MMActivity) context, FinderItem.a.a(finderObject, 16384), 0, 12);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(246851);
            }
        });
        this.usj.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.ap.AnonymousClass7 */
            final /* synthetic */ ap uss;

            {
                this.uss = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(246852);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                if (this.uss.hOp.getLiveRole() == 1) {
                    com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.a(s.c.SEE_GIFT_LIST, String.valueOf(s.ak.CLICK_HELF_PAGE_INSTRUCTION.action));
                } else if (this.uss.hOp.getLiveRole() == 0) {
                    com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
                    com.tencent.mm.plugin.finder.report.live.m.a(s.aw.CLICK_Y_IN_HOT_LIST, "", 0);
                }
                intent.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=support/we-coin/protocol/index");
                com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
                if (finderLiveAssistant != null) {
                    Context context = viewGroup.getContext();
                    p.g(context, "root.context");
                    finderLiveAssistant.a(context, intent, (Integer) null);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(246852);
            }
        });
        ao.a(this.hRK.getPaint(), 0.8f);
        AppMethodBeat.o(246872);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    static final class g implements o.g {
        final /* synthetic */ ViewGroup hOA;
        final /* synthetic */ ap uss;

        g(ap apVar, ViewGroup viewGroup) {
            this.uss = apVar;
            this.hOA = viewGroup;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            String str;
            FinderContact finderContact;
            String str2;
            FinderContact finderContact2;
            String str3;
            FinderContact finderContact3;
            FinderContact finderContact4;
            String str4;
            String str5;
            FinderContact finderContact5;
            AppMethodBeat.i(246860);
            Integer valueOf = menuItem != null ? Integer.valueOf(menuItem.getItemId()) : null;
            int i3 = this.uss.urZ;
            if (valueOf != null && valueOf.intValue() == i3) {
                ap.a(this.uss, false);
                com.tencent.mm.ui.widget.a.e eVar = this.uss.usp;
                if (eVar != null) {
                    eVar.bMo();
                }
                if (this.uss.hOp.getLiveRole() == 1) {
                    com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtx++;
                    JSONObject jSONObject = new JSONObject();
                    String valueOf2 = String.valueOf(s.ac.LIVE_PERSONAL_COMMENT_CLOSE.action);
                    avn avn = this.uss.uso;
                    if (avn == null || (finderContact = avn.contact) == null || (str = finderContact.username) == null) {
                        str = "";
                    }
                    jSONObject.put(valueOf2, str);
                    s.c cVar = s.c.LIVE_ANCHOR_ACTION_BARRAGE;
                    com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    if (com.tencent.mm.plugin.finder.report.live.k.dpl().vmm) {
                        cVar = s.c.LIVE_ANCHOR_ACTION_AUDIENCE;
                    }
                    com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.a(cVar, jSONObject.toString());
                    AppMethodBeat.o(246860);
                    return;
                }
            } else {
                int i4 = this.uss.usa;
                if (valueOf != null && valueOf.intValue() == i4) {
                    ap.a(this.uss, true);
                    com.tencent.mm.ui.widget.a.e eVar2 = this.uss.usp;
                    if (eVar2 != null) {
                        eVar2.bMo();
                    }
                    if (this.uss.hOp.getLiveRole() == 1) {
                        com.tencent.mm.plugin.finder.report.live.k kVar4 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                        com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vty++;
                        JSONObject jSONObject2 = new JSONObject();
                        String valueOf3 = String.valueOf(s.ac.LIVE_PERSONAL_COMMENT_OPEN.action);
                        avn avn2 = this.uss.uso;
                        if (avn2 == null || (finderContact2 = avn2.contact) == null || (str2 = finderContact2.username) == null) {
                            str2 = "";
                        }
                        jSONObject2.put(valueOf3, str2);
                        s.c cVar2 = s.c.LIVE_ANCHOR_ACTION_BARRAGE;
                        com.tencent.mm.plugin.finder.report.live.k kVar5 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                        if (com.tencent.mm.plugin.finder.report.live.k.dpl().vmm) {
                            cVar2 = s.c.LIVE_ANCHOR_ACTION_AUDIENCE;
                        }
                        com.tencent.mm.plugin.finder.report.live.k kVar6 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                        com.tencent.mm.plugin.finder.report.live.k.a(cVar2, jSONObject2.toString());
                        AppMethodBeat.o(246860);
                        return;
                    }
                } else {
                    int i5 = this.uss.usb;
                    if (valueOf != null && valueOf.intValue() == i5) {
                        ap apVar = this.uss;
                        AnonymousClass1 r0 = new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.finder.live.plugin.ap.g.AnonymousClass1 */
                            final /* synthetic */ g usu;

                            {
                                this.usu = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                String str;
                                String str2;
                                FinderContact finderContact;
                                String str3;
                                FinderContact finderContact2;
                                AppMethodBeat.i(246859);
                                ap apVar = this.usu.uss;
                                String str4 = apVar.TAG;
                                StringBuilder sb = new StringBuilder("kickMember:");
                                avn avn = apVar.uso;
                                if (avn == null || (finderContact2 = avn.contact) == null) {
                                    str = null;
                                } else {
                                    str = finderContact2.username;
                                }
                                Log.i(str4, sb.append(str).toString());
                                com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                                com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
                                if (finderLiveAssistant != null) {
                                    avn avn2 = apVar.uso;
                                    if (avn2 == null || (finderContact = avn2.contact) == null || (str3 = finderContact.username) == null) {
                                        str2 = "";
                                    } else {
                                        str2 = str3;
                                    }
                                    finderLiveAssistant.c(str2, new f(apVar));
                                }
                                x xVar = x.SXb;
                                AppMethodBeat.o(246859);
                                return xVar;
                            }
                        };
                        if (apVar.usq == null) {
                            apVar.usq = new com.tencent.mm.ui.widget.a.e(apVar.hwr.getContext(), 1, true);
                            com.tencent.mm.ui.widget.a.e eVar3 = apVar.usq;
                            if (eVar3 != null) {
                                eVar3.hbs();
                            }
                            View inflate = View.inflate(apVar.hwr.getContext(), R.layout.b0l, null);
                            TextView textView = (TextView) inflate.findViewById(R.id.eg6);
                            p.g(textView, "bottomSheetTitleTv");
                            textView.setText(apVar.hwr.getContext().getString(R.string.cyn));
                            com.tencent.mm.ui.widget.a.e eVar4 = apVar.usq;
                            if (eVar4 != null) {
                                eVar4.setTitleView(inflate);
                            }
                            com.tencent.mm.ui.widget.a.e eVar5 = apVar.usq;
                            if (eVar5 != null) {
                                eVar5.b(a.ust);
                            }
                        }
                        com.tencent.mm.ui.widget.a.e eVar6 = apVar.usq;
                        if (eVar6 != null) {
                            eVar6.hbr();
                        }
                        com.tencent.mm.ui.widget.a.e eVar7 = apVar.usq;
                        if (eVar7 != null) {
                            eVar7.setFooterView(null);
                        }
                        com.tencent.mm.ui.widget.a.e eVar8 = apVar.usq;
                        if (eVar8 != null) {
                            eVar8.a(new b(apVar));
                        }
                        com.tencent.mm.ui.widget.a.e eVar9 = apVar.usq;
                        if (eVar9 != null) {
                            eVar9.a(new c(apVar, r0));
                        }
                        com.tencent.mm.ui.widget.a.e eVar10 = apVar.usq;
                        if (eVar10 != null) {
                            eVar10.b(new d(apVar));
                        }
                        com.tencent.mm.ui.widget.a.e eVar11 = this.uss.usq;
                        if (eVar11 != null) {
                            eVar11.dGm();
                        }
                        com.tencent.mm.ui.widget.a.e eVar12 = this.uss.usp;
                        if (eVar12 != null) {
                            eVar12.bMo();
                            AppMethodBeat.o(246860);
                            return;
                        }
                        AppMethodBeat.o(246860);
                        return;
                    }
                    int i6 = this.uss.usc;
                    if (valueOf != null && valueOf.intValue() == i6) {
                        avn avn3 = this.uss.uso;
                        if (!(avn3 == null || (finderContact4 = avn3.contact) == null || (str4 = finderContact4.username) == null)) {
                            com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                            com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
                            if (finderLiveAssistant != null) {
                                Context context = this.hOA.getContext();
                                p.g(context, "root.context");
                                long j2 = this.uss.getLiveData().liveInfo.liveId;
                                p.g(str4, LocaleUtil.ITALIAN);
                                finderLiveAssistant.a(context, j2, str4, (Long) 0L);
                            }
                        }
                        com.tencent.mm.ui.widget.a.e eVar13 = this.uss.usp;
                        if (eVar13 != null) {
                            eVar13.bMo();
                        }
                        if (this.uss.hOp.getLiveRole() == 1) {
                            com.tencent.mm.plugin.finder.report.live.k kVar7 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                            com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtu++;
                            JSONObject jSONObject3 = new JSONObject();
                            String valueOf4 = String.valueOf(s.ac.LIVE_PERSONAL_COMPLAIN.action);
                            avn avn4 = this.uss.uso;
                            if (avn4 == null || (finderContact3 = avn4.contact) == null || (str3 = finderContact3.username) == null) {
                                str3 = "";
                            }
                            jSONObject3.put(valueOf4, str3);
                            s.c cVar3 = s.c.LIVE_ANCHOR_ACTION_BARRAGE;
                            com.tencent.mm.plugin.finder.report.live.k kVar8 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                            if (com.tencent.mm.plugin.finder.report.live.k.dpl().vmm) {
                                cVar3 = s.c.LIVE_ANCHOR_ACTION_AUDIENCE;
                            }
                            com.tencent.mm.plugin.finder.report.live.k kVar9 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                            com.tencent.mm.plugin.finder.report.live.k.a(cVar3, jSONObject3.toString());
                            AppMethodBeat.o(246860);
                            return;
                        }
                    } else {
                        int i7 = this.uss.UMF;
                        if (valueOf != null && valueOf.intValue() == i7) {
                            ap apVar2 = this.uss;
                            avn avn5 = this.uss.uso;
                            if (avn5 == null || (finderContact5 = avn5.contact) == null) {
                                str5 = null;
                            } else {
                                str5 = finderContact5.username;
                            }
                            String str6 = str5;
                            if (str6 == null || str6.length() == 0) {
                                Log.i(apVar2.TAG, "goToFinderProfile finderUsername:".concat(String.valueOf(str5)));
                                AppMethodBeat.o(246860);
                                return;
                            }
                            if (apVar2.hOp.getLiveRole() == 0) {
                                com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
                                com.tencent.mm.plugin.finder.report.live.m.a(s.aw.CLICK_PROFILE_HOT_LIST, "", 0);
                            }
                            boolean isLandscape = apVar2.isLandscape();
                            Log.i(apVar2.TAG, "goToFinderProfile isLandscape:".concat(String.valueOf(isLandscape)));
                            if (isLandscape) {
                                Bundle bundle = new Bundle();
                                bundle.putString(apVar2.ULy, str5);
                                d.a(apVar2, apVar2.uuf, bundle, 0, 4);
                                AppMethodBeat.o(246860);
                                return;
                            }
                            com.tencent.mm.plugin.finder.live.model.o oVar2 = com.tencent.mm.plugin.finder.live.model.o.ujN;
                            com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant2 = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
                            if (finderLiveAssistant2 != null) {
                                s.a.a(finderLiveAssistant2, false, str5);
                                AppMethodBeat.o(246860);
                                return;
                            }
                            AppMethodBeat.o(246860);
                            return;
                        }
                        com.tencent.mm.ui.widget.a.e eVar14 = this.uss.usp;
                        if (eVar14 != null) {
                            eVar14.bMo();
                            AppMethodBeat.o(246860);
                            return;
                        }
                    }
                }
            }
            AppMethodBeat.o(246860);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class k implements o.f {
        final /* synthetic */ int UMH;
        final /* synthetic */ ap uss;

        k(ap apVar, int i2) {
            this.uss = apVar;
            this.UMH = i2;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(246864);
            mVar.clear();
            ap apVar = this.uss;
            p.g(mVar, LocaleUtil.ITALIAN);
            if (this.UMH == 3) {
                int i2 = apVar.UMF;
                Context context = apVar.hwr.getContext();
                p.g(context, "root.context");
                mVar.d(i2, context.getResources().getString(R.string.jc9));
            }
            int i3 = apVar.usc;
            Context context2 = apVar.hwr.getContext();
            p.g(context2, "root.context");
            mVar.d(i3, context2.getResources().getString(R.string.cx_));
            AppMethodBeat.o(246864);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    static final class l implements e.b {
        final /* synthetic */ ap uss;

        l(ap apVar) {
            this.uss = apVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            this.uss.usp = null;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    static final class a implements e.b {
        public static final a ust = new a();

        static {
            AppMethodBeat.i(246854);
            AppMethodBeat.o(246854);
        }

        a() {
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class b implements o.f {
        final /* synthetic */ int hRB = R.color.xq;
        final /* synthetic */ int hRC = R.string.cym;
        final /* synthetic */ ap uss;

        b(ap apVar) {
            this.uss = apVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(246855);
            mVar.clear();
            if (this.hRB == 0) {
                int i2 = this.uss.hRp;
                Context context = this.uss.hwr.getContext();
                p.g(context, "root.context");
                mVar.d(i2, context.getResources().getString(this.hRC));
                AppMethodBeat.o(246855);
                return;
            }
            int i3 = this.uss.hRp;
            Context context2 = this.uss.hwr.getContext();
            p.g(context2, "root.context");
            int color = context2.getResources().getColor(this.hRB);
            Context context3 = this.uss.hwr.getContext();
            p.g(context3, "root.context");
            mVar.a(i3, color, context3.getResources().getString(this.hRC));
            AppMethodBeat.o(246855);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "i", "", "onMMMenuItemSelected"})
    static final class c implements o.g {
        final /* synthetic */ kotlin.g.a.a hRD;
        final /* synthetic */ ap uss;

        c(ap apVar, kotlin.g.a.a aVar) {
            this.uss = apVar;
            this.hRD = aVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            String str;
            FinderContact finderContact;
            AppMethodBeat.i(246856);
            p.h(menuItem, "menuItem");
            if (menuItem.getItemId() == this.uss.hRp) {
                this.hRD.invoke();
                com.tencent.mm.ui.widget.a.e eVar = this.uss.usq;
                if (eVar != null) {
                    eVar.bMo();
                }
                if (this.uss.hOp.getLiveRole() == 1) {
                    com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.dpl().vmj.vtz++;
                    JSONObject jSONObject = new JSONObject();
                    String valueOf = String.valueOf(s.ac.LIVE_PERSONAL_KICK_OUT.action);
                    avn avn = this.uss.uso;
                    if (avn == null || (finderContact = avn.contact) == null || (str = finderContact.username) == null) {
                        str = "";
                    }
                    jSONObject.put(valueOf, str);
                    s.c cVar = s.c.LIVE_ANCHOR_ACTION_BARRAGE;
                    com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    if (com.tencent.mm.plugin.finder.report.live.k.dpl().vmm) {
                        cVar = s.c.LIVE_ANCHOR_ACTION_AUDIENCE;
                    }
                    com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.a(cVar, jSONObject.toString());
                    AppMethodBeat.o(246856);
                    return;
                }
            } else {
                com.tencent.mm.ui.widget.a.e eVar2 = this.uss.usq;
                if (eVar2 != null) {
                    eVar2.bMo();
                    AppMethodBeat.o(246856);
                    return;
                }
            }
            AppMethodBeat.o(246856);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    static final class d implements e.b {
        final /* synthetic */ ap uss;

        d(ap apVar) {
            this.uss = apVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            this.uss.usq = null;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class j implements Runnable {
        final /* synthetic */ ap uss;

        j(ap apVar) {
            this.uss = apVar;
        }

        public final void run() {
            AppMethodBeat.i(246863);
            this.uss.hRy.show();
            AppMethodBeat.o(246863);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class i implements Runnable {
        final /* synthetic */ ap uss;

        i(ap apVar) {
            this.uss = apVar;
        }

        public final void run() {
            AppMethodBeat.i(246862);
            this.uss.hRy.show();
            AppMethodBeat.o(246862);
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void B(int i2, Bundle bundle) {
        AppMethodBeat.i(260668);
        if (!com.tencent.mm.ac.d.cW(i2, 16)) {
            rg(8);
        } else if (this.hwr.getVisibility() != 0) {
            rg(0);
            if (bundle != null ? bundle.getBoolean("PARAM_FINDER_LIVE_MEMBER_SKIP_LOADING") : false) {
                this.hRy.post(new i(this));
                this.usn.diK();
                AppMethodBeat.o(260668);
                return;
            }
            this.hRO.setVisibility(0);
            this.hRL.setVisibility(8);
            this.ush.setVisibility(8);
            this.hRR.setVisibility(8);
            this.hRN.setVisibility(8);
            this.usn.diK();
            this.hRy.post(new j(this));
            com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
            com.tencent.mm.plugin.finder.utils.m.dBP();
            com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
            com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
            if (finderLiveAssistant != null) {
                finderLiveAssistant.d(new n(this));
                AppMethodBeat.o(260668);
                return;
            }
            AppMethodBeat.o(260668);
            return;
        }
        AppMethodBeat.o(260668);
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(246868);
        p.h(cVar, "status");
        AppMethodBeat.o(246868);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final void a(Bundle bundle, Object obj, long j2) {
        String str;
        AppMethodBeat.i(260669);
        if (bundle == null || (str = bundle.getString("ACTION_POST_PORTRAIT", "")) == null) {
            str = "";
        }
        if (p.j(str, this.uuf)) {
            com.tencent.mm.ac.d.a(j2, new m(this, bundle, obj, j2));
        }
        AppMethodBeat.o(260669);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class m implements Runnable {
        final /* synthetic */ Bundle ULG;
        final /* synthetic */ Object ULH;
        final /* synthetic */ ap uss;
        final /* synthetic */ long utG;

        m(ap apVar, Bundle bundle, Object obj, long j2) {
            this.uss = apVar;
            this.ULG = bundle;
            this.ULH = obj;
            this.utG = j2;
        }

        public final void run() {
            AppMethodBeat.i(260665);
            if (!this.uss.isFinished()) {
                com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
                if (finderLiveAssistant != null) {
                    finderLiveAssistant.k(this.ULH, this.uss.ULy);
                    AppMethodBeat.o(260665);
                    return;
                }
                AppMethodBeat.o(260665);
                return;
            }
            Log.i(this.uss.TAG, "goToFinderProfileImpl delayMs:" + this.utG + ",isFinished!");
            AppMethodBeat.o(260665);
        }
    }

    private final void Jm(int i2) {
        String str;
        long j2;
        String str2;
        long j3 = 0;
        AppMethodBeat.i(246869);
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        if ((!com.tencent.mm.plugin.finder.utils.m.dBP() || !getLiveData().uEJ) && !getLiveData().uEK) {
            this.usk.setVisibility(8);
            this.usj.setVisibility(8);
            Context context = this.hwr.getContext();
            p.g(context, "root.context");
            Resources resources = context.getResources();
            y yVar = y.vXH;
            String string = resources.getString(R.string.cwh, y.LT(i2));
            p.g(string, "root.context.resources.g….formatLiveNum(totalCnt))");
            Context context2 = this.hwr.getContext();
            p.g(context2, "root.context");
            Resources resources2 = context2.getResources();
            y yVar2 = y.vXH;
            String string2 = resources2.getString(R.string.cwg, y.LT(getLiveData().uDq));
            p.g(string2, "root.context.resources.g…eData.onlineMemberCount))");
            this.hRK.setText(string + " · " + string2);
        } else {
            if (getLiveData().dja()) {
                this.usk.setVisibility(8);
            } else {
                this.usk.setVisibility(0);
            }
            this.usj.setVisibility(0);
            com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
            if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
                ae aeVar = ae.SYK;
                String string3 = this.hwr.getContext().getString(R.string.cwg);
                p.g(string3, "root.context.getString(R….finder_live_members_tip)");
                y yVar3 = y.vXH;
                String format = String.format(string3, Arrays.copyOf(new Object[]{y.LT(getLiveData().uDq)}, 1));
                p.g(format, "java.lang.String.format(format, *args)");
                str = format;
            } else {
                ae aeVar2 = ae.SYK;
                String string4 = this.hwr.getContext().getString(R.string.cwh);
                p.g(string4, "root.context.getString(R…r_live_members_total_tip)");
                y yVar4 = y.vXH;
                String format2 = String.format(string4, Arrays.copyOf(new Object[]{y.LT(getLiveData().uDV)}, 1));
                p.g(format2, "java.lang.String.format(format, *args)");
                str = format2;
            }
            com.tencent.mm.plugin.finder.utils.m mVar3 = com.tencent.mm.plugin.finder.utils.m.vVH;
            Long a2 = com.tencent.mm.plugin.finder.utils.m.a(getLiveData().liveInfo);
            if (a2 != null) {
                j2 = a2.longValue();
            } else {
                j2 = 0;
            }
            if (j2 == 0) {
                str2 = this.hwr.getContext().getString(R.string.jcp);
            } else {
                ae aeVar3 = ae.SYK;
                String string5 = this.hwr.getContext().getString(R.string.d09);
                p.g(string5, "root.context.getString(R…ive_wecoin_amount_in_hot)");
                Object[] objArr = new Object[1];
                y yVar5 = y.vXH;
                com.tencent.mm.plugin.finder.utils.m mVar4 = com.tencent.mm.plugin.finder.utils.m.vVH;
                Long a3 = com.tencent.mm.plugin.finder.utils.m.a(getLiveData().liveInfo);
                if (a3 != null) {
                    j3 = a3.longValue();
                }
                objArr[0] = y.RN(j3);
                String format3 = String.format(string5, Arrays.copyOf(objArr, 1));
                p.g(format3, "java.lang.String.format(format, *args)");
                str2 = format3;
            }
            p.g(str2, "if(FinderLiveUtil.getLiv…eInfo)?:0))\n            }");
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.hVh().value().intValue() == 1) {
                this.hRK.setText(String.valueOf(str2));
            } else {
                this.hRK.setText(str + (char) 8226 + str2);
            }
        }
        com.tencent.mm.plugin.finder.utils.m mVar5 = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
            if (getLiveData().uFa == 1) {
                TextView textView = this.usl;
                Context context3 = MMApplicationContext.getContext();
                p.g(context3, "MMApplicationContext.getContext()");
                textView.setText(context3.getResources().getString(R.string.d06));
                this.usl.setVisibility(0);
            } else {
                this.usl.setVisibility(8);
            }
            int i3 = this.usd;
            if (this.usl.getVisibility() == 0 && this.usk.getVisibility() == 0) {
                int i4 = this.usd;
                Context context4 = MMApplicationContext.getContext();
                p.g(context4, "MMApplicationContext.getContext()");
                i3 = i4 + context4.getResources().getDimensionPixelOffset(R.dimen.cb);
            }
            this.hRR.getLayoutParams().height = i3;
        }
        AppMethodBeat.o(246869);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0115  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void nw(boolean r12) {
        /*
        // Method dump skipped, instructions count: 428
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.plugin.ap.nw(boolean):void");
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveMemberListPlugin$onGetLiveOnlineMemberSuccess$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder_release"})
    public static final class h implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ ap uss;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(ap apVar) {
            this.uss = apVar;
        }

        public final void onGlobalLayout() {
            AppMethodBeat.i(246861);
            this.uss.hRN.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            this.uss.hRN.scrollBy(0, 1);
            AppMethodBeat.o(246861);
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(246866);
        if (this.hwr.getVisibility() == 0) {
            this.hRy.hide();
            if (this.hOp.getLiveRole() == 1) {
                com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.a(s.c.SEE_GIFT_LIST, String.valueOf(s.ak.RETURN_LIVE_ROOM.action));
            }
            AppMethodBeat.o(246866);
            return true;
        }
        boolean onBackPress = super.onBackPress();
        AppMethodBeat.o(246866);
        return onBackPress;
    }

    public static final /* synthetic */ void a(ap apVar, boolean z) {
        String str;
        FinderContact finderContact;
        FinderContact finderContact2;
        String str2 = null;
        AppMethodBeat.i(246873);
        String str3 = apVar.TAG;
        StringBuilder sb = new StringBuilder("kickMember:");
        avn avn = apVar.uso;
        if (avn == null || (finderContact2 = avn.contact) == null) {
            str = null;
        } else {
            str = finderContact2.username;
        }
        Log.i(str3, sb.append(str).toString());
        com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
        com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            avn avn2 = apVar.uso;
            if (!(avn2 == null || (finderContact = avn2.contact) == null)) {
                str2 = finderContact.username;
            }
            finderLiveAssistant.a(str2, z, new e(apVar));
            AppMethodBeat.o(246873);
            return;
        }
        AppMethodBeat.o(246873);
    }
}
