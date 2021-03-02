package com.tencent.mm.plugin.finder.live.plugin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.finder.cgi.s;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.plugin.finder.utils.ae;
import com.tencent.mm.plugin.finder.utils.af;
import com.tencent.mm.plugin.finder.utils.fake.b;
import com.tencent.mm.plugin.finder.utils.fake.d;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 T2\u00020\u0001:\u0001TB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\u0006\u0010-\u001a\u00020*J\b\u0010.\u001a\u00020#H\u0016J\b\u0010/\u001a\u00020*H\u0002J\b\u00100\u001a\u00020*H\u0002J\b\u00101\u001a\u00020*H\u0002J\b\u00102\u001a\u00020*H\u0002J\b\u00103\u001a\u00020*H\u0002J\"\u00104\u001a\u00020*2\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\n2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u001c\u00109\u001a\u00020*2\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0010\u0010>\u001a\u00020*2\u0006\u0010?\u001a\u00020\u001fH\u0002J\u0010\u0010@\u001a\u00020*2\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u00020*2\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010D\u001a\u00020*2\u0006\u0010A\u001a\u00020BH\u0002J\b\u0010E\u001a\u00020*H\u0002J\b\u0010F\u001a\u00020*H\u0002J\b\u0010G\u001a\u00020*H\u0002J\b\u0010H\u001a\u00020*H\u0002J\b\u0010I\u001a\u00020*H\u0002J\b\u0010J\u001a\u00020*H\u0002J\b\u0010K\u001a\u00020*H\u0002J\b\u0010L\u001a\u00020*H\u0002J\u0012\u0010M\u001a\u00020*2\b\u0010N\u001a\u0004\u0018\u00010OH\u0002J\u001a\u0010P\u001a\u00020*2\u0006\u0010Q\u001a\u00020R2\b\u0010S\u001a\u0004\u0018\u00010;H\u0016R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006U"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/ui/MMActivity;)V", "SHEET_MORE_ACTION_AUDIO_LINK", "", "SHEET_MORE_ACTION_BAN_COMMENT", "SHEET_MORE_ACTION_COST_TIME_LOG", "SHEET_MORE_ACTION_GIFT", "SHEET_MORE_ACTION_GIFTS_MOCK_SINGLE", "SHEET_MORE_ACTION_GIFTS_MOCK_TCASE", "SHEET_MORE_ACTION_LINK_MIC", "SHEET_MORE_ACTION_LIVE_DEBUG", "SHEET_MORE_ACTION_LOTTERY_RECORD", "SHEET_MORE_ACTION_MINI_WINDOW", "SHEET_MORE_ACTION_REPORT", "SHEET_MORE_ACTION_SCREEN_CLEAR", "SHEET_MORE_ACTION_SHARE_2_FRIEMD", "SHEET_MORE_ACTION_SHARE_2_SNS", "SHEET_MORE_ACTION_SHARE_2_STATUS", "SHEET_MORE_ACTION_SHOW_STATISTICS", "SHEET_MORE_ACTION_STOP_LINK", "SHEET_MORE_ACTION_VIDEO_LINK", "SHEET_MORE_ACTION_VISITOR_ROLE", "SHEET_MORE_ACTION_WIN_LOTTERY_RECORD", "TAG", "", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "enableVisitorRoleEntrance", "", "isLiving", "menuItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "moreActionBtn", "Landroid/widget/RelativeLayout;", "banComment", "", "menuItem", "Landroid/view/MenuItem;", "buildConfirmDialog", "canClearScreen", "chooseVisitorRole", "expose", "exposeImpl", "hideMoreActionBottomSheet", "miniWindow", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onPortraitAction", "actionInfo", "Landroid/os/Bundle;", "extraData", "", "postDelayForDialogDismiss", NativeProtocol.WEB_DIALOG_ACTION, "prepareLinkMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "prepareMenuItems", "prepareSecondMenuItems", "screenClearAction", "setJumpWithoutMiniWindow", "share2Friend", "share2FriendImpl", "share2SNS", "share2SNSImpl", "share2Status", "share2StatusImpl", "showDebugLiveInfo", ch.COL_FINDEROBJECT, "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Companion", "plugin-finder_release"})
public final class at extends d {
    private static final String UMQ = UMQ;
    private static final String ute = ute;
    private static final String utf = utf;
    private static final String utg = utg;
    private static final String uth = uth;
    public static final a uti = new a((byte) 0);
    private final String TAG = "Finder.FinderLiveMoreActionPlugin";
    private final int UMP = 11;
    private boolean UvI = true;
    private final MMActivity activity;
    private final com.tencent.mm.live.c.b hOp;
    private com.tencent.mm.ui.widget.a.e hOv;
    private boolean hSh;
    private o.g uhx;
    private final int urZ = 3;
    private final int usM;
    private final int usN = 1;
    private final int usO = 2;
    private final int usP = 4;
    private final int usQ = 5;
    private final int usR = 7;
    private final int usS = 8;
    private final int usT = 9;
    private final int usU = 10;
    private final int usV = 500;
    private final int usW = 501;
    private final int usX = 502;
    private final int usY = 1000;
    private final int usZ = 1001;
    private final int usc = 6;
    private final int uta = 1002;
    private final int utb = 1003;
    private final int utc = 1004;
    private final RelativeLayout utd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public at(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar, MMActivity mMActivity) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(246922);
        this.hOp = bVar;
        this.activity = mMActivity;
        View findViewById = viewGroup.findViewById(R.id.cvy);
        p.g(findViewById, "root.findViewById(R.id.f…ve_more_action_btn_group)");
        this.utd = (RelativeLayout) findViewById;
        m mVar = m.vVH;
        this.UvI = m.hVq();
        this.utd.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.plugin.at.AnonymousClass1 */
            final /* synthetic */ at utj;

            {
                this.utj = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(246901);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.C0376b.a(this.utj.hOp, b.c.hNn);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(246901);
            }
        });
        m mVar2 = m.vVH;
        m.a(this);
        Log.i(this.TAG, "enableVisitorRoleEntrance:" + this.UvI);
        this.uhx = new f(this, viewGroup);
        AppMethodBeat.o(246922);
    }

    public static final /* synthetic */ void m(at atVar) {
        AppMethodBeat.i(246930);
        atVar.dhE();
        AppMethodBeat.o(246930);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin$Companion;", "", "()V", at.uth, "", "getPORTRAIT_ACTION_EXPOSE", "()Ljava/lang/String;", at.ute, "getPORTRAIT_ACTION_SHARE_2_FRIEND", at.utf, "getPORTRAIT_ACTION_SHARE_2_SNS", at.utg, "getPORTRAIT_ACTION_SHARE_2_STATUS", at.UMQ, "getPORTRAIT_ACTION_VISITOR_MODE", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(246923);
        AppMethodBeat.o(246923);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin$miniWindow$1", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog;", "onResultCancel", "onResultRefuse", "plugin-finder_release"})
    public static final class g implements RequestFloatWindowPermissionDialog.a {
        final /* synthetic */ at utj;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(at atVar) {
            this.utj = atVar;
        }

        @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
        public final void onResultAllow(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
            AppMethodBeat.i(246910);
            p.h(requestFloatWindowPermissionDialog, "dialog");
            requestFloatWindowPermissionDialog.finish();
            if (this.utj.hSh) {
                if (this.utj.hOp.getLiveRole() == 1) {
                    b.a aVar = com.tencent.mm.live.core.core.a.b.hyv;
                    this.utj.hwr.getContext();
                    b.a.aDo().hAz.hzz = true;
                } else {
                    b.a aVar2 = com.tencent.mm.live.core.core.d.b.hCo;
                    this.utj.hwr.getContext();
                    b.a.aEf().hAz.hzz = true;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 2);
                bundle.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 12);
                this.utj.hOp.statusChange(b.c.hLQ, bundle);
                if (this.utj.hOp.getLiveRole() == 1) {
                    k kVar = k.vkd;
                    k.dpl().vmk = true;
                    k kVar2 = k.vkd;
                    k.dpl().vml = false;
                    k kVar3 = k.vkd;
                    k.a(s.c.LIVE_ANCHOR_ACTION_MINIMIZE, String.valueOf(s.r.LIVE_FLOAT_ACTION_COLLAPSE_ANIMATION.type));
                    AppMethodBeat.o(246910);
                    return;
                }
                com.tencent.mm.plugin.finder.report.live.m.vli.a(true, s.r.LIVE_FLOAT_ACTION_COLLAPSE_ANIMATION);
            }
            AppMethodBeat.o(246910);
        }

        @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
        public final void onResultRefuse(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
            AppMethodBeat.i(246911);
            p.h(requestFloatWindowPermissionDialog, "dialog");
            requestFloatWindowPermissionDialog.finish();
            b.C0376b.a(this.utj.hOp, b.c.hLT);
            AppMethodBeat.o(246911);
        }

        @Override // com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a
        public final void onResultCancel(RequestFloatWindowPermissionDialog requestFloatWindowPermissionDialog) {
            AppMethodBeat.i(246912);
            p.h(requestFloatWindowPermissionDialog, "dialog");
            b.C0376b.a(this.utj.hOp, b.c.hLU);
            AppMethodBeat.o(246912);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0017¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveMoreActionPlugin$banComment$callBack$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveAnchorStatus$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "anchorStatus", "onSuccess", "plugin-finder_release"})
    public static final class b implements s.a {
        final /* synthetic */ at utj;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(at atVar) {
            this.utj = atVar;
        }

        @Override // com.tencent.mm.plugin.finder.cgi.s.a
        @SuppressLint({"ResourceType"})
        public final void onSuccess(int i2) {
            String string;
            AppMethodBeat.i(246904);
            boolean z = !com.tencent.mm.ac.d.cW(i2, 8);
            if (z) {
                Context context = this.utj.hwr.getContext();
                p.g(context, "root.context");
                string = context.getResources().getString(R.string.cws);
            } else {
                Context context2 = this.utj.hwr.getContext();
                p.g(context2, "root.context");
                string = context2.getResources().getString(R.string.cwu);
            }
            p.g(string, "if (enable) {\n          …t_done)\n                }");
            z.d dVar = new z.d();
            dVar.SYE = z ? R.raw.icons_outlined_comment : R.raw.icon_outlined_close_comment;
            u.a(this.utj.hwr.getContext(), string, new a(dVar));
            AppMethodBeat.o(246904);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
        static final class a implements u.b {
            final /* synthetic */ z.d utk;

            a(z.d dVar) {
                this.utk = dVar;
            }

            @Override // com.tencent.mm.ui.base.u.b
            public final void dU(View view) {
                WeImageView weImageView;
                AppMethodBeat.i(246903);
                if (view != null) {
                    view.findViewById(R.id.ird);
                }
                if (view == null || (weImageView = (WeImageView) view.findViewById(R.id.irc)) == null) {
                    AppMethodBeat.o(246903);
                    return;
                }
                weImageView.setImageResource(this.utk.SYE);
                AppMethodBeat.o(246903);
            }
        }

        @Override // com.tencent.mm.plugin.finder.cgi.s.a
        public final void b(int i2, int i3, String str, int i4) {
            boolean z;
            String string;
            AppMethodBeat.i(246905);
            if (!com.tencent.mm.ac.d.cW(i4, 8)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Context context = this.utj.hwr.getContext();
                p.g(context, "root.context");
                string = context.getResources().getString(R.string.cwr);
            } else {
                Context context2 = this.utj.hwr.getContext();
                p.g(context2, "root.context");
                string = context2.getResources().getString(R.string.cwt);
            }
            p.g(string, "if (enable) root.context…_more_action_ban_comment)");
            u.makeText(this.utj.hwr.getContext(), string + "失败", 0).show();
            ae aeVar = ae.vZW;
            String dEi = ae.dEi();
            if (str == null) {
                str = "";
            }
            ae.a(dEi, i3, i2, str, this.utj.getLiveData());
            AppMethodBeat.o(246905);
        }
    }

    private final void dhC() {
        AppMethodBeat.i(246913);
        getLiveData().uDS = false;
        AppMethodBeat.o(246913);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    static final class f implements o.g {
        final /* synthetic */ ViewGroup hOA;
        final /* synthetic */ at utj;

        f(at atVar, ViewGroup viewGroup) {
            this.utj = atVar;
            this.hOA = viewGroup;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            String str;
            int i3;
            boolean z = false;
            AppMethodBeat.i(246909);
            Integer valueOf = menuItem != null ? Integer.valueOf(menuItem.getItemId()) : null;
            int i4 = this.utj.usM;
            if (valueOf != null && valueOf.intValue() == i4) {
                at.g(this.utj);
                AppMethodBeat.o(246909);
                return;
            }
            int i5 = this.utj.usN;
            if (valueOf != null && valueOf.intValue() == i5) {
                at.i(this.utj);
                AppMethodBeat.o(246909);
                return;
            }
            int i6 = this.utj.usO;
            if (valueOf != null && valueOf.intValue() == i6) {
                at.k(this.utj);
                AppMethodBeat.o(246909);
                return;
            }
            int i7 = this.utj.urZ;
            if (valueOf != null && valueOf.intValue() == i7) {
                at.a(this.utj, menuItem);
            } else {
                int i8 = this.utj.usP;
                if (valueOf != null && valueOf.intValue() == i8) {
                    at.o(this.utj);
                } else {
                    int i9 = this.utj.usc;
                    if (valueOf != null && valueOf.intValue() == i9) {
                        at.q(this.utj);
                        if (this.utj.hOp.getLiveRole() == 0) {
                            com.tencent.mm.plugin.finder.report.live.m.vli.hUH();
                            AppMethodBeat.o(246909);
                            return;
                        }
                        AppMethodBeat.o(246909);
                    }
                    int i10 = this.utj.usQ;
                    if (valueOf != null && valueOf.intValue() == i10) {
                        at.m(this.utj);
                        at.s(this.utj);
                        AppMethodBeat.o(246909);
                        return;
                    }
                    int i11 = this.utj.usY;
                    if (valueOf != null && valueOf.intValue() == i11) {
                        m mVar = m.vVH;
                        if (m.dBP()) {
                            ac acVar = ac.vYp;
                            str = ac.dDk();
                        } else {
                            af afVar = af.waa;
                            HashMap<String, String> dEo = af.dEo();
                            StringBuilder sb = new StringBuilder();
                            af afVar2 = af.waa;
                            String str2 = dEo.get(sb.append(af.dEm()).append(this.utj.getLiveData().liveInfo.liveId).toString());
                            if (str2 == null) {
                                str = "";
                            } else {
                                str = str2;
                            }
                        }
                        FinderDebugUIC.a aVar = FinderDebugUIC.wvw;
                        FinderDebugUIC.a.aG(this.utj.activity, str);
                    } else {
                        int i12 = this.utj.usZ;
                        if (valueOf != null && valueOf.intValue() == i12) {
                            y yVar = y.vXH;
                            if (y.dCM()) {
                                com.tencent.mm.plugin.finder.live.viewmodel.g liveData = this.utj.getLiveData();
                                if (!this.utj.getLiveData().uEN) {
                                    z = true;
                                }
                                liveData.uEN = z;
                            }
                            at.m(this.utj);
                            AppMethodBeat.o(246909);
                            return;
                        }
                        int i13 = this.utj.utb;
                        if (valueOf != null && valueOf.intValue() == i13) {
                            com.tencent.mm.plugin.finder.utils.fake.b bVar = new com.tencent.mm.plugin.finder.utils.fake.b(this.utj.activity, this.utj.getLiveData());
                            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) bVar.activity, 1, false);
                            eVar.a(new b.C1315b(bVar));
                            eVar.a(new b.c(bVar));
                            eVar.dGm();
                        } else {
                            int i14 = this.utj.utc;
                            if (valueOf != null && valueOf.intValue() == i14) {
                                at.a(this.utj, this.utj.getLiveData().uDz);
                                AppMethodBeat.o(246909);
                                return;
                            }
                            int i15 = this.utj.uta;
                            if (valueOf != null && valueOf.intValue() == i15) {
                                com.tencent.mm.plugin.finder.utils.fake.d dVar = new com.tencent.mm.plugin.finder.utils.fake.d(this.utj.activity);
                                com.tencent.mm.ui.widget.a.e eVar2 = new com.tencent.mm.ui.widget.a.e((Context) dVar.activity, 1, false);
                                eVar2.a(new d.b(dVar));
                                eVar2.dGm();
                            } else {
                                int i16 = this.utj.usS;
                                if (valueOf == null || valueOf.intValue() != i16) {
                                    int i17 = this.utj.usR;
                                    if (valueOf == null || valueOf.intValue() != i17) {
                                        int i18 = this.utj.usT;
                                        if (valueOf != null && valueOf.intValue() == i18) {
                                            Log.i(this.utj.TAG, "enable/disable link mic. curEnableLinkMic:" + this.utj.getLiveData().diZ());
                                            at.m(this.utj);
                                            if (this.utj.getLiveData().diZ()) {
                                                this.utj.getLiveData().uDA &= -65;
                                                Context context = this.hOA.getContext();
                                                Context context2 = this.hOA.getContext();
                                                p.g(context2, "root.context");
                                                u.cG(context, context2.getResources().getString(R.string.ctv));
                                                Bundle bundle = new Bundle();
                                                bundle.putBoolean("PARAM_FINDER_LIVE_LINK_MIC_ENABLE", false);
                                                this.utj.hOp.statusChange(b.c.hNS, bundle);
                                                if (this.utj.hOp.getLiveRole() == 1) {
                                                    k kVar = k.vkd;
                                                    k.a(s.c.LINKMIC_SWITCH, String.valueOf(s.y.CLOSE.action));
                                                }
                                            } else {
                                                this.utj.getLiveData().uDA |= 64;
                                                Context context3 = this.hOA.getContext();
                                                Context context4 = this.hOA.getContext();
                                                p.g(context4, "root.context");
                                                u.cG(context3, context4.getResources().getString(R.string.ctx));
                                                Bundle bundle2 = new Bundle();
                                                bundle2.putBoolean("PARAM_FINDER_LIVE_LINK_MIC_ENABLE", true);
                                                this.utj.hOp.statusChange(b.c.hNS, bundle2);
                                                if (this.utj.hOp.getLiveRole() == 1) {
                                                    k kVar2 = k.vkd;
                                                    k.a(s.c.LINKMIC_SWITCH, String.valueOf(s.y.OPEN.action));
                                                }
                                            }
                                            this.utj.getLiveData();
                                            com.tencent.mm.plugin.finder.live.viewmodel.g.EP((long) this.utj.getLiveData().uDA);
                                            AppMethodBeat.o(246909);
                                            return;
                                        }
                                        int i19 = this.utj.usU;
                                        if (valueOf != null && valueOf.intValue() == i19) {
                                            Log.i(this.utj.TAG, "enable/disable gift. curEnableGift:" + this.utj.getLiveData().dja());
                                            at.m(this.utj);
                                            if (this.utj.getLiveData().dja()) {
                                                this.utj.getLiveData().uDA &= -129;
                                                Context context5 = this.hOA.getContext();
                                                Context context6 = this.hOA.getContext();
                                                p.g(context6, "root.context");
                                                u.cG(context5, context6.getResources().getString(R.string.csp));
                                                if (this.utj.hOp.getLiveRole() == 1) {
                                                    k kVar3 = k.vkd;
                                                    k.a(s.c.GIFT_SWITCH, String.valueOf(s.u.BY_MORE_CLOSE_GIFT.action));
                                                }
                                            } else {
                                                this.utj.getLiveData().uDA |= 128;
                                                Context context7 = this.hOA.getContext();
                                                Context context8 = this.hOA.getContext();
                                                p.g(context8, "root.context");
                                                u.cG(context7, context8.getResources().getString(R.string.csr));
                                                if (this.utj.hOp.getLiveRole() == 1) {
                                                    k kVar4 = k.vkd;
                                                    k.a(s.c.GIFT_SWITCH, String.valueOf(s.u.BY_MORE_OPEN_GIFT.action));
                                                }
                                            }
                                            this.utj.getLiveData();
                                            com.tencent.mm.plugin.finder.live.viewmodel.g.EP((long) this.utj.getLiveData().uDA);
                                            com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                                            com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
                                            if (finderLiveAssistant != null) {
                                                s.a.a(finderLiveAssistant, this.utj.getLiveData().liveInfo.liveId, this.utj.getLiveData().hFK, this.utj.getLiveData().uDA);
                                                AppMethodBeat.o(246909);
                                                return;
                                            }
                                            AppMethodBeat.o(246909);
                                            return;
                                        }
                                        int i20 = this.utj.UMP;
                                        if (valueOf != null && valueOf.intValue() == i20) {
                                            at.E(this.utj);
                                            AppMethodBeat.o(246909);
                                            return;
                                        }
                                    }
                                }
                                Intent intent = new Intent();
                                if (menuItem.getItemId() == this.utj.usR) {
                                    i3 = 1;
                                } else {
                                    i3 = 2;
                                }
                                intent.putExtra("KEY_LOTTERY_HISTORY_SCENE", i3);
                                intent.putExtra("KEY_LOTTERY_HISTORY_LIVE_ID", this.utj.getLiveData().liveInfo.liveId);
                                intent.putExtra("KEY_LOTTERY_HISTORY_OBJECT_ID", this.utj.getLiveData().hFK);
                                intent.putExtra("KEY_LOTTERY_HISTORY_OBJECT_NONCE_ID", this.utj.getLiveData().hwg);
                                intent.putExtra("KEY_LIVE_ANCHOR_USERNAME", this.utj.getLiveData().hwd);
                                FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                                FinderReporterUIC.a.a(this.utj.activity, intent, 0, 0, false, 124);
                                com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                                com.tencent.mm.plugin.finder.utils.a.f(this.utj.activity, intent);
                                at.m(this.utj);
                                if (this.utj.hOp.getLiveRole() == 1) {
                                    k kVar5 = k.vkd;
                                    k.a(s.f.CLICK_ENTER_LOTTERY_RECORD_BY_RIGHT, "");
                                    AppMethodBeat.o(246909);
                                    return;
                                }
                                if (this.utj.hOp.getLiveRole() == 0) {
                                    com.tencent.mm.plugin.finder.report.live.m.vli.a(s.ay.ENTER_WIN_RECORD_BY_RIGHH_CORNER, "");
                                }
                                AppMethodBeat.o(246909);
                                return;
                            }
                        }
                    }
                }
            }
            at.m(this.utj);
            AppMethodBeat.o(246909);
        }
    }

    public final void dhD() {
        AppMethodBeat.i(246914);
        if (this.hOv == null) {
            this.hOv = new com.tencent.mm.ui.widget.a.e(this.hwr.getContext(), 0, true);
            com.tencent.mm.ui.widget.a.e eVar = this.hOv;
            if (eVar != null) {
                eVar.Do(isLandscape());
            }
            com.tencent.mm.ui.widget.a.e eVar2 = this.hOv;
            if (eVar2 != null) {
                eVar2.hbs();
            }
        }
        com.tencent.mm.ui.widget.a.e eVar3 = this.hOv;
        if (eVar3 != null) {
            eVar3.hbr();
        }
        com.tencent.mm.ui.widget.a.e eVar4 = this.hOv;
        if (eVar4 != null) {
            eVar4.Dp(false);
        }
        com.tencent.mm.ui.widget.a.e eVar5 = this.hOv;
        if (eVar5 != null) {
            eVar5.a(new c(this));
        }
        com.tencent.mm.ui.widget.a.e eVar6 = this.hOv;
        if (eVar6 != null) {
            eVar6.b(new d(this));
        }
        com.tencent.mm.ui.widget.a.e eVar7 = this.hOv;
        if (eVar7 != null) {
            eVar7.a(this.uhx);
        }
        com.tencent.mm.ui.widget.a.e eVar8 = this.hOv;
        if (eVar8 != null) {
            eVar8.b(this.uhx);
        }
        com.tencent.mm.ui.widget.a.e eVar9 = this.hOv;
        if (eVar9 != null) {
            eVar9.b(new e(this));
        }
        com.tencent.mm.ui.widget.a.e eVar10 = this.hOv;
        if (eVar10 != null) {
            eVar10.dGm();
            AppMethodBeat.o(246914);
            return;
        }
        AppMethodBeat.o(246914);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class c implements o.f {
        final /* synthetic */ at utj;

        c(at atVar) {
            this.utj = atVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(246906);
            com.tencent.mm.ui.widget.a.e eVar = this.utj.hOv;
            if (eVar != null) {
                eVar.setFooterView(null);
            }
            mVar.clear();
            at atVar = this.utj;
            p.g(mVar, "menu");
            at.a(atVar, mVar);
            AppMethodBeat.o(246906);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class d implements o.f {
        final /* synthetic */ at utj;

        d(at atVar) {
            this.utj = atVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(246907);
            com.tencent.mm.ui.widget.a.e eVar = this.utj.hOv;
            if (eVar != null) {
                eVar.setFooterView(null);
            }
            mVar.clear();
            at atVar = this.utj;
            p.g(mVar, "menu");
            at.b(atVar, mVar);
            AppMethodBeat.o(246907);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class e implements e.b {
        final /* synthetic */ at utj;

        e(at atVar) {
            this.utj = atVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(246908);
            b.C0376b.a(this.utj.hOp, b.c.hNo);
            this.utj.hOv = null;
            AppMethodBeat.o(246908);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(246915);
        p.h(cVar, "status");
        super.statusChange(cVar, bundle);
        switch (au.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
                rg(4);
                this.hSh = false;
                AppMethodBeat.o(246915);
                return;
            case 3:
            case 4:
                this.hSh = true;
                AppMethodBeat.o(246915);
                return;
            case 5:
                m mVar = m.vVH;
                m.a(this);
                break;
        }
        AppMethodBeat.o(246915);
    }

    private final void dhE() {
        AppMethodBeat.i(246916);
        b.C0376b.a(this.hOp, b.c.hNo);
        com.tencent.mm.ui.widget.a.e eVar = this.hOv;
        if (eVar != null) {
            eVar.bMo();
            AppMethodBeat.o(246916);
            return;
        }
        AppMethodBeat.o(246916);
    }

    private final void dhF() {
        AppMethodBeat.i(246917);
        Log.i(this.TAG, "share2FriendImpl");
        FinderObject finderObject = getLiveData().uDz;
        if (finderObject != null) {
            FinderItem.a aVar = FinderItem.Companion;
            s.a.a(com.tencent.mm.plugin.finder.utils.s.vWt, this.activity, FinderItem.a.a(finderObject, 16384), 0, 12);
            dhC();
            AppMethodBeat.o(246917);
            return;
        }
        AppMethodBeat.o(246917);
    }

    private final void dhG() {
        AppMethodBeat.i(246918);
        Log.i(this.TAG, "share2SNSImpl");
        FinderObject finderObject = getLiveData().uDz;
        if (finderObject != null) {
            s.a aVar = com.tencent.mm.plugin.finder.utils.s.vWt;
            FinderItem.a aVar2 = FinderItem.Companion;
            s.a.a(this.activity, new w(FinderItem.a.a(finderObject, 16384)), 0, 0, 28);
            dhC();
            AppMethodBeat.o(246918);
            return;
        }
        AppMethodBeat.o(246918);
    }

    private final void dhH() {
        AppMethodBeat.i(246919);
        Log.i(this.TAG, "share2StatusImpl");
        FinderObject finderObject = getLiveData().uDz;
        if (finderObject != null) {
            c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
            String str = getLiveData().hwd;
            if (str == null) {
                str = finderObject.username;
            }
            if (str == null) {
                str = "";
            }
            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEo = str;
            s.a aVar2 = com.tencent.mm.plugin.finder.utils.s.vWt;
            FinderItem.a aVar3 = FinderItem.Companion;
            Bundle bundle = new Bundle();
            bundle.putString("FINDER_LIVE_SHARE_KEY_STATUS_VERIFY", getLiveData().uFc);
            s.a.a(this.activity, new w(FinderItem.a.a(finderObject, 16384)), bundle);
            dhC();
            AppMethodBeat.o(246919);
            return;
        }
        AppMethodBeat.o(246919);
    }

    private final void dhI() {
        AppMethodBeat.i(246920);
        Log.i(this.TAG, "exposeImpl");
        com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
        com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            s.a.a(finderLiveAssistant, this.activity, getLiveData().liveInfo.liveId, getLiveData().hwd);
            AppMethodBeat.o(246920);
            return;
        }
        AppMethodBeat.o(246920);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final void ai(Bundle bundle) {
        String str;
        AppMethodBeat.i(260686);
        if (bundle == null || (str = bundle.getString("ACTION_POST_PORTRAIT", "")) == null) {
            str = "";
        }
        if (p.j(str, ute)) {
            dhF();
            AppMethodBeat.o(260686);
        } else if (p.j(str, utf)) {
            dhG();
            AppMethodBeat.o(260686);
        } else if (p.j(str, utg)) {
            dhH();
            AppMethodBeat.o(260686);
        } else if (p.j(str, uth)) {
            dhI();
            AppMethodBeat.o(260686);
        } else {
            if (p.j(str, UMQ)) {
                com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
                if (finderLiveAssistant != null) {
                    s.a.a(finderLiveAssistant, this.activity);
                    AppMethodBeat.o(260686);
                    return;
                }
            }
            AppMethodBeat.o(260686);
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
        boolean z = false;
        AppMethodBeat.i(260687);
        switch (i2) {
            case 1009:
                if (intent != null) {
                    z = intent.getBooleanExtra("KEY_IS_FROM_SETTING", false);
                }
                Log.i(this.TAG, "REQUEST_FINDER_LIVE_ROLE fromUserGuide:".concat(String.valueOf(z)));
                if (i3 != -1 || z) {
                    Log.i(this.TAG, "REQUEST_FINDER_LIVE_ROLE resultCode:" + i3 + ",data:" + intent);
                    break;
                } else {
                    com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                    com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
                    if (finderLiveAssistant != null) {
                        finderLiveAssistant.b(this);
                        AppMethodBeat.o(260687);
                        return;
                    }
                    AppMethodBeat.o(260687);
                    return;
                }
        }
        AppMethodBeat.o(260687);
    }

    public static final /* synthetic */ void a(at atVar, com.tencent.mm.ui.base.m mVar) {
        boolean z;
        boolean z2;
        FinderObject finderObject;
        FinderObject finderObject2;
        FinderObject finderObject3;
        boolean z3;
        FinderObject finderObject4;
        FinderObject finderObject5;
        boolean z4 = false;
        AppMethodBeat.i(246924);
        m mVar2 = m.vVH;
        if (m.dBP()) {
            int i2 = atVar.usM;
            Context context = atVar.hwr.getContext();
            p.g(context, "root.context");
            String string = context.getResources().getString(R.string.cxd);
            Context context2 = atVar.hwr.getContext();
            p.g(context2, "root.context");
            mVar.a(i2, string, R.raw.finder_icons_filled_share, context2.getResources().getColor(R.color.Brand), atVar.getLiveData().uDz == null || ((finderObject5 = atVar.getLiveData().uDz) != null && finderObject5.id == 0));
            int i3 = atVar.usN;
            Context context3 = atVar.hwr.getContext();
            p.g(context3, "root.context");
            String string2 = context3.getResources().getString(R.string.cxe);
            if (atVar.getLiveData().uDz == null || ((finderObject4 = atVar.getLiveData().uDz) != null && finderObject4.id == 0)) {
                z3 = true;
            } else {
                z3 = false;
            }
            mVar.a(i3, string2, R.raw.bottomsheet_icon_moment, 0, z3);
        } else {
            b.a aVar = com.tencent.mm.live.core.core.d.b.hCo;
            if (b.a.aDp()) {
                int i4 = atVar.usM;
                Context context4 = atVar.hwr.getContext();
                p.g(context4, "root.context");
                String string3 = context4.getResources().getString(R.string.cxd);
                Context context5 = atVar.hwr.getContext();
                p.g(context5, "root.context");
                int color = context5.getResources().getColor(R.color.Brand);
                if (atVar.getLiveData().uDz == null || ((finderObject3 = atVar.getLiveData().uDz) != null && finderObject3.id == 0)) {
                    z = true;
                } else {
                    z = false;
                }
                mVar.a(i4, string3, R.raw.finder_icons_filled_share, color, z);
                int i5 = atVar.usN;
                Context context6 = atVar.hwr.getContext();
                p.g(context6, "root.context");
                String string4 = context6.getResources().getString(R.string.cxe);
                if (atVar.getLiveData().uDz == null || ((finderObject2 = atVar.getLiveData().uDz) != null && finderObject2.id == 0)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                mVar.a(i5, string4, R.raw.bottomsheet_icon_moment, 0, z2);
                if (com.tencent.mm.plugin.textstatus.a.p.fvC()) {
                    int i6 = atVar.usO;
                    Context context7 = atVar.hwr.getContext();
                    p.g(context7, "root.context");
                    String string5 = context7.getResources().getString(R.string.cxf);
                    if (atVar.getLiveData().uDz == null || ((finderObject = atVar.getLiveData().uDz) != null && finderObject.id == 0)) {
                        z4 = true;
                    }
                    mVar.a(i6, string5, R.raw.state_icon_main, z4);
                }
            }
        }
        y yVar = y.vXH;
        if (y.dCM()) {
            mVar.b(atVar.utb, "礼物用例(内部)", R.raw.icons_outlined_tv);
            mVar.b(atVar.uta, "单礼物动画(内部)", R.raw.icons_outlined_tv);
            mVar.b(atVar.usY, "耗时(内部)", R.raw.icons_outlined_time);
            mVar.b(atVar.usZ, "直播统计(内部)", R.raw.icons_outlined_transfer);
        }
        AppMethodBeat.o(246924);
    }

    public static final /* synthetic */ void b(at atVar, com.tencent.mm.ui.base.m mVar) {
        String string;
        String string2;
        int i2;
        String string3;
        int i3;
        AppMethodBeat.i(246925);
        m mVar2 = m.vVH;
        if (m.dBP()) {
            int i4 = atVar.usP;
            Context context = atVar.hwr.getContext();
            p.g(context, "root.context");
            mVar.b(i4, context.getResources().getString(R.string.cx9), R.raw.icons_outlined_mini_window);
            if (atVar.getLiveData().uDD) {
                Context context2 = atVar.hwr.getContext();
                p.g(context2, "root.context");
                string = context2.getResources().getString(R.string.cwt);
            } else {
                Context context3 = atVar.hwr.getContext();
                p.g(context3, "root.context");
                string = context3.getResources().getString(R.string.cwr);
            }
            p.g(string, "if (liveData.enableLiveR…ore_action_allow_comment)");
            mVar.b(atVar.urZ, string, atVar.getLiveData().uDD ? R.raw.icon_outlined_close_comment : R.raw.icons_outlined_comment);
            if (atVar.getLiveData().uEG && atVar.getLiveData().uEH && !atVar.getLiveData().djm()) {
                if (atVar.getLiveData().diZ()) {
                    Context context4 = atVar.hwr.getContext();
                    p.g(context4, "root.context");
                    string3 = context4.getResources().getString(R.string.cwx);
                    p.g(string3, "root.context.resources.g…_action_disable_link_mic)");
                    i3 = R.raw.finder_live_unmic;
                } else {
                    Context context5 = atVar.hwr.getContext();
                    p.g(context5, "root.context");
                    string3 = context5.getResources().getString(R.string.cwz);
                    p.g(string3, "root.context.resources.g…e_action_enable_link_mic)");
                    i3 = R.raw.finder_icons_request_link_mic;
                }
                mVar.b(atVar.usT, string3, i3);
            }
            if (atVar.getLiveData().uEJ && atVar.getLiveData().uEL) {
                m mVar3 = m.vVH;
                if (m.dBQ()) {
                    if (atVar.getLiveData().dja()) {
                        Context context6 = atVar.hwr.getContext();
                        p.g(context6, "root.context");
                        string2 = context6.getResources().getString(R.string.cww);
                        p.g(string2, "root.context.resources.g…more_action_disable_gift)");
                        i2 = R.raw.finder_live_ungift;
                    } else {
                        Context context7 = atVar.hwr.getContext();
                        p.g(context7, "root.context");
                        string2 = context7.getResources().getString(R.string.cwy);
                        p.g(string2, "root.context.resources.g…_more_action_enable_gift)");
                        i2 = R.raw.finder_live_gift;
                    }
                    mVar.b(atVar.usU, string2, i2);
                }
            }
            if (atVar.getLiveData().uEd) {
                mVar.aS(atVar.usR, R.string.cx8, R.raw.icons_outlined_winningrecord);
            }
        } else {
            b.a aVar = com.tencent.mm.live.core.core.d.b.hCo;
            if (b.a.aDp()) {
                int i5 = atVar.usP;
                Context context8 = atVar.hwr.getContext();
                p.g(context8, "root.context");
                mVar.b(i5, context8.getResources().getString(R.string.cx9), R.raw.icons_outlined_mini_window);
                if (!atVar.getLiveData().uDR) {
                    Context context9 = atVar.hwr.getContext();
                    p.g(context9, "root.context");
                    String string4 = context9.getResources().getString(R.string.cxa);
                    p.g(string4, "root.context.resources.g…more_action_screen_clear)");
                    mVar.b(atVar.usQ, string4, R.raw.finder_icons_screen_clear);
                }
                int i6 = atVar.usc;
                Context context10 = atVar.hwr.getContext();
                p.g(context10, "root.context");
                mVar.b(i6, context10.getResources().getString(R.string.cx_), R.raw.icons_outlined_report_problem);
                if (atVar.UvI) {
                    int i7 = atVar.UMP;
                    Context context11 = atVar.hwr.getContext();
                    p.g(context11, "root.context");
                    mVar.b(i7, context11.getResources().getString(R.string.jcn), R.raw.icons_outlined_exchange);
                }
                if (atVar.getLiveData().uEd) {
                    mVar.aS(atVar.usS, R.string.cxi, R.raw.icons_outlined_winningrecord);
                }
            }
        }
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.ui.component.a.b(atVar.activity).get(FinderDebugUIC.class);
        if (FinderDebugUIC.dHZ()) {
            mVar.b(atVar.utc, "推荐信息", R.raw.finder_icons_link);
        }
        AppMethodBeat.o(246925);
    }

    public static final /* synthetic */ void g(at atVar) {
        AppMethodBeat.i(246926);
        boolean isLandscape = atVar.isLandscape();
        Log.i(atVar.TAG, "share2Friend isLandscape:".concat(String.valueOf(isLandscape)));
        if (isLandscape) {
            b.C0376b.a(atVar.hOp, b.c.hNo);
            d.a(atVar, ute);
            AppMethodBeat.o(246926);
            return;
        }
        atVar.dhF();
        b.C0376b.a(atVar.hOp, b.c.hNo);
        com.tencent.mm.ui.widget.a.e eVar = atVar.hOv;
        if (eVar != null) {
            eVar.bMo();
            AppMethodBeat.o(246926);
            return;
        }
        AppMethodBeat.o(246926);
    }

    public static final /* synthetic */ void i(at atVar) {
        AppMethodBeat.i(246927);
        boolean isLandscape = atVar.isLandscape();
        Log.i(atVar.TAG, "share2SNS isLandscape:".concat(String.valueOf(isLandscape)));
        if (isLandscape) {
            b.C0376b.a(atVar.hOp, b.c.hNo);
            d.a(atVar, utf);
            AppMethodBeat.o(246927);
            return;
        }
        atVar.dhG();
        b.C0376b.a(atVar.hOp, b.c.hNo);
        com.tencent.mm.ui.widget.a.e eVar = atVar.hOv;
        if (eVar != null) {
            eVar.bMo();
            AppMethodBeat.o(246927);
            return;
        }
        AppMethodBeat.o(246927);
    }

    public static final /* synthetic */ void k(at atVar) {
        AppMethodBeat.i(246928);
        boolean isLandscape = atVar.isLandscape();
        Log.i(atVar.TAG, "share2Status isLandscape:".concat(String.valueOf(isLandscape)));
        if (isLandscape) {
            b.C0376b.a(atVar.hOp, b.c.hNo);
            d.a(atVar, utg);
            AppMethodBeat.o(246928);
            return;
        }
        atVar.dhH();
        b.C0376b.a(atVar.hOp, b.c.hNo);
        com.tencent.mm.ui.widget.a.e eVar = atVar.hOv;
        if (eVar != null) {
            eVar.bMo();
            AppMethodBeat.o(246928);
            return;
        }
        AppMethodBeat.o(246928);
    }

    public static final /* synthetic */ void a(at atVar, MenuItem menuItem) {
        AppMethodBeat.i(246929);
        Context context = atVar.hwr.getContext();
        p.g(context, "root.context");
        String string = context.getResources().getString(R.string.cwt);
        p.g(string, "root.context.resources.g…_more_action_ban_comment)");
        Context context2 = atVar.hwr.getContext();
        p.g(context2, "root.context");
        String string2 = context2.getResources().getString(R.string.cwr);
        p.g(string2, "root.context.resources.g…ore_action_allow_comment)");
        b bVar = new b(atVar);
        CharSequence title = menuItem.getTitle();
        if (p.j(title, string)) {
            atVar.getLiveData().uDA |= 8;
            long j2 = atVar.getLiveData().liveInfo.liveId;
            long j3 = atVar.getLiveData().hFK;
            int i2 = atVar.getLiveData().uDA;
            String aUg = com.tencent.mm.model.z.aUg();
            p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
            new com.tencent.mm.plugin.finder.cgi.s(j2, j3, i2, aUg, bVar).aYI();
            if (atVar.hOp.getLiveRole() == 1) {
                k kVar = k.vkd;
                k.dpl().vmj.vtv++;
                k kVar2 = k.vkd;
                k.a(s.c.LIVE_ANCHOR_ACTION_COMMENT, String.valueOf(s.b.LIVE_ALL_COMMENT_CLOSE.type));
                AppMethodBeat.o(246929);
                return;
            }
        } else if (p.j(title, string2)) {
            atVar.getLiveData().uDA &= -9;
            long j4 = atVar.getLiveData().liveInfo.liveId;
            long j5 = atVar.getLiveData().hFK;
            int i3 = atVar.getLiveData().uDA;
            String aUg2 = com.tencent.mm.model.z.aUg();
            p.g(aUg2, "ConfigStorageLogic.getMyFinderUsername()");
            new com.tencent.mm.plugin.finder.cgi.s(j4, j5, i3, aUg2, bVar).aYI();
            if (atVar.hOp.getLiveRole() == 1) {
                k kVar3 = k.vkd;
                k.dpl().vmj.vtw++;
                k kVar4 = k.vkd;
                k.a(s.c.LIVE_ANCHOR_ACTION_COMMENT, String.valueOf(s.b.LIVE_ALL_COMMENT_OPEN.type));
                AppMethodBeat.o(246929);
                return;
            }
        } else {
            Log.e(atVar.TAG, "comment state err!");
        }
        AppMethodBeat.o(246929);
    }

    public static final /* synthetic */ void o(at atVar) {
        AppMethodBeat.i(246931);
        if (!com.tencent.mm.compatible.e.b.cx(MMApplicationContext.getContext())) {
            Log.e(atVar.TAG, "showVideoTalking, permission denied");
            b.C0376b.a(atVar.hOp, b.c.hLS);
            RequestFloatWindowPermissionDialog.a(atVar.hwr.getContext(), atVar.hwr.getContext().getString(R.string.ej9), new g(atVar), false, com.tencent.mm.bq.a.apJ());
            AppMethodBeat.o(246931);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", 2);
        bundle.putInt("PARAM_LIVE_MINI_WINDOW_OP_TYPE", 12);
        atVar.hOp.statusChange(b.c.hLQ, bundle);
        if (atVar.hOp.getLiveRole() == 1) {
            k kVar = k.vkd;
            k.dpl().vmk = true;
            k kVar2 = k.vkd;
            k.dpl().vml = false;
            k kVar3 = k.vkd;
            k.a(s.c.LIVE_ANCHOR_ACTION_MINIMIZE, String.valueOf(s.r.LIVE_FLOAT_ACTION_COLLAPSE_ANIMATION.type));
            AppMethodBeat.o(246931);
            return;
        }
        if (atVar.hOp.getLiveRole() == 0) {
            com.tencent.mm.plugin.finder.report.live.m.vli.a(true, s.r.LIVE_FLOAT_ACTION_COLLAPSE_ANIMATION);
        }
        AppMethodBeat.o(246931);
    }

    public static final /* synthetic */ void q(at atVar) {
        AppMethodBeat.i(246932);
        boolean isLandscape = atVar.isLandscape();
        Log.i(atVar.TAG, "expose isLandscape:".concat(String.valueOf(isLandscape)));
        if (isLandscape) {
            b.C0376b.a(atVar.hOp, b.c.hNo);
            d.a(atVar, uth);
            AppMethodBeat.o(246932);
            return;
        }
        atVar.dhI();
        atVar.dhE();
        AppMethodBeat.o(246932);
    }

    public static final /* synthetic */ void s(at atVar) {
        s.h hVar;
        AppMethodBeat.i(246933);
        atVar.getLiveData().uDR = true;
        Bundle bundle = new Bundle();
        bundle.putBoolean("PARAM_FINDER_LIVE_SCREEN_CLEAR", atVar.getLiveData().uDR);
        atVar.hOp.statusChange(b.c.hNl, bundle);
        if (atVar.hOp.getLiveRole() == 0) {
            if (atVar.getLiveData().uDR) {
                hVar = s.h.CLICK_CLEAR_SCREEN_MENU;
            } else {
                hVar = s.h.CLICK_CLEAR_SCREEN_CANCEL;
            }
            com.tencent.mm.plugin.finder.report.live.m.vli.a(hVar);
        }
        AppMethodBeat.o(246933);
    }

    public static final /* synthetic */ void a(at atVar, FinderObject finderObject) {
        String str;
        String str2;
        String str3;
        AppMethodBeat.i(246934);
        if (!(finderObject == null || (str2 = finderObject.debugMessage) == null)) {
            if (!TextUtils.isEmpty(str2)) {
                str3 = str2;
            } else {
                str3 = "empty msg.";
            }
            if (str3 != null) {
                str = str3;
                p.g(str, "finderObject?.debugMessa…         }?: \"empty msg.\"");
                FinderDebugUIC.a aVar = FinderDebugUIC.wvw;
                AppCompatActivity context = atVar.activity.getContext();
                p.g(context, "activity.context");
                FinderDebugUIC.a.aG(context, str);
                AppMethodBeat.o(246934);
            }
        }
        str = "empty msg.";
        p.g(str, "finderObject?.debugMessa…         }?: \"empty msg.\"");
        FinderDebugUIC.a aVar2 = FinderDebugUIC.wvw;
        AppCompatActivity context2 = atVar.activity.getContext();
        p.g(context2, "activity.context");
        FinderDebugUIC.a.aG(context2, str);
        AppMethodBeat.o(246934);
    }

    public static final /* synthetic */ void E(at atVar) {
        T t;
        boolean z;
        AppMethodBeat.i(260688);
        List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = atVar.getLiveData().UPZ;
        p.g(list, "liveData.audienceLinkMicUserList");
        List<com.tencent.mm.plugin.finder.live.viewmodel.e> list2 = list;
        synchronized (list2) {
            try {
                Iterator<T> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it.next();
                    if (Util.isEqual(t.uCo, atVar.getLiveData().djq())) {
                        break;
                    }
                }
            } catch (Throwable th) {
                AppMethodBeat.o(260688);
                throw th;
            }
        }
        if (t != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Log.i(atVar.TAG, "chooseVisitorRole linking");
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            atVar.hTt().showAlertDialog(atVar.activity, "", context.getResources().getString(R.string.jci), "");
            AppMethodBeat.o(260688);
        } else if (atVar.getLiveData().djr()) {
            b.C0376b.a(atVar.hOp, b.c.hNP);
            Log.i(atVar.TAG, "chooseVisitorRole linkWaiting");
            AppMethodBeat.o(260688);
        } else {
            boolean isLandscape = atVar.isLandscape();
            Log.i(atVar.TAG, "chooseVisitorRole isLandscape:".concat(String.valueOf(isLandscape)));
            if (isLandscape) {
                b.C0376b.a(atVar.hOp, b.c.hNo);
                d.a(atVar, UMQ);
                AppMethodBeat.o(260688);
                return;
            }
            com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
            com.tencent.mm.plugin.finder.live.model.s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
            if (finderLiveAssistant != null) {
                s.a.a(finderLiveAssistant, atVar.activity);
            }
            atVar.dhE();
            AppMethodBeat.o(260688);
        }
    }
}
