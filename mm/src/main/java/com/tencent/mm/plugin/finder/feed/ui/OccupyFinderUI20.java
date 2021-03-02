package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.abk;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.cgi.bu;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.live.model.cgi.s;
import com.tencent.mm.plugin.finder.ui.FinderCreateContactUI;
import com.tencent.mm.plugin.finder.ui.FinderLivePostHelperUI;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.ak;
import com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqb;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.axq;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.t;
import kotlin.x;

@com.tencent.mm.ui.base.a(7)
@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0001\\B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010&\u001a\u00020\u00122\b\u0010'\u001a\u0004\u0018\u00010!H\u0002J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u0012H\u0002J\b\u0010.\u001a\u00020,H\u0002J\b\u0010/\u001a\u00020,H\u0002J\b\u00100\u001a\u000201H\u0014J\u0010\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u000201H\u0002J\u0010\u00104\u001a\u00020,2\u0006\u00105\u001a\u00020!H\u0002J\b\u00106\u001a\u00020,H\u0002J\b\u00107\u001a\u00020,H\u0002J2\u00108\u001a\u00020,2\u0006\u0010)\u001a\u0002092\u0006\u0010:\u001a\u0002012\u0006\u0010;\u001a\u0002012\b\u0010<\u001a\u0004\u0018\u00010!2\u0006\u0010=\u001a\u00020>H\u0002J2\u0010?\u001a\u00020,2\u0006\u0010)\u001a\u0002092\u0006\u0010:\u001a\u0002012\u0006\u0010;\u001a\u0002012\b\u0010<\u001a\u0004\u0018\u00010!2\u0006\u0010=\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u00020,2\u0006\u0010B\u001a\u00020\nH\u0002J\b\u0010C\u001a\u00020\u0012H\u0002J\"\u0010D\u001a\u00020,2\u0006\u0010E\u001a\u0002012\u0006\u0010F\u001a\u0002012\b\u0010G\u001a\u0004\u0018\u00010HH\u0014J\u0012\u0010I\u001a\u00020,2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\b\u0010L\u001a\u00020,H\u0014J-\u0010M\u001a\u00020,2\u0006\u0010E\u001a\u0002012\u000e\u0010N\u001a\n\u0012\u0006\b\u0001\u0012\u00020!0O2\u0006\u0010P\u001a\u00020QH\u0016¢\u0006\u0002\u0010RJ,\u0010S\u001a\u00020,2\u0006\u0010:\u001a\u0002012\u0006\u0010;\u001a\u0002012\b\u0010<\u001a\u0004\u0018\u00010!2\b\u0010=\u001a\u0004\u0018\u00010TH\u0016J\u0006\u0010U\u001a\u00020,J\u0010\u0010V\u001a\u00020\u00122\u0006\u0010W\u001a\u000201H\u0002J\u0006\u0010X\u001a\u00020,J\u0006\u0010Y\u001a\u00020,J\u0012\u0010Z\u001a\u00020,2\b\b\u0002\u0010[\u001a\u000201H\u0002R\u001a\u0010\u0004\u001a\u00020\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006]"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI20;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "getActivity", "()Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI20;", "setActivity", "(Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI20;)V", "finderCreateLivePrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "finderLiveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "finderLiveVerifyResp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveVerifyResp;", "finderUserPrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "hasEnterLiveRoom", "", "isVerifyFin", "()Z", "setVerifyFin", "(Z)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderRealNameVertifyFinishEvent;", "getListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "loadingComponent", "Lcom/tencent/mm/plugin/finder/utils/MultiDelayLoadingComponent;", "roomId", "", "getRoomId", "()Ljava/lang/String;", "setRoomId", "(Ljava/lang/String;)V", "checkAccountValid", "finderUsername", "checkLivePermission", "context", "Landroid/app/Activity;", "checkLivePrepare", "", "checkNetworkAvailable", "checkUserInfo", "checkVerify", "getLayoutId", "", "globalEnable", "globalFlag", "gotoFaceVerify", "verifyUrl", "gotoLive", "handleConfirmPostLive", "handleNetSceneFinderLiveVerify", "Landroid/content/Context;", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderLiveVerify;", "handleNetSceneFinderPrepareUser", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPrepareUser;", "handleOnCreateLivePrepareResponse", "resp", "isVerify", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onRequestPermissionsResult", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSceneEnd", "Lcom/tencent/mm/modelbase/NetSceneBase;", "prepare", "privateEnable", "privateFlag", "release", "reset", "showErrPage", "type", "Companion", "plugin-finder_release"})
public final class OccupyFinderUI20 extends MMFinderUI implements com.tencent.mm.ak.i {
    public static final a UJu = new a((byte) 0);
    OccupyFinderUI20 UJs = this;
    boolean UJt;
    private HashMap _$_findViewCache;
    private IListener<abk> gmC = new k(this);
    private String roomId = "";
    private awt uiv;
    private bed vKL;
    private aqb vKM;
    private axq vKN;
    private ak vKO;
    private boolean vKP;

    static {
        AppMethodBeat.i(260374);
        AppMethodBeat.o(260374);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(260379);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(260379);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(260378);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(260378);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public OccupyFinderUI20() {
        AppMethodBeat.i(260373);
        AppMethodBeat.o(260373);
    }

    public static final /* synthetic */ void a(OccupyFinderUI20 occupyFinderUI20) {
        AppMethodBeat.i(260375);
        occupyFinderUI20.hSU();
        AppMethodBeat.o(260375);
    }

    public static final /* synthetic */ void c(OccupyFinderUI20 occupyFinderUI20) {
        AppMethodBeat.i(260377);
        occupyFinderUI20.dzC();
        AppMethodBeat.o(260377);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI20$Companion;", "", "()V", "ENTER_LIVE_CREATE_CONTACT_REQUEST_CODE", "", "ENTER_LIVE_FACE_VERIFY_REQUEST_CODE", "ENTER_LIVE_FORBIDDEN_REQUEST_CODE", "PREPARE_TIME_OUT_MS", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI20$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderRealNameVertifyFinishEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class k extends IListener<abk> {
        final /* synthetic */ OccupyFinderUI20 UJw;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        k(OccupyFinderUI20 occupyFinderUI20) {
            this.UJw = occupyFinderUI20;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(abk abk) {
            AppMethodBeat.i(260348);
            Log.i("Finder.FinderLivePostPendingUI", "[listener] Vertify finish ");
            this.UJw.UJt = true;
            ak akVar = this.UJw.vKO;
            if (akVar != null) {
                akVar.begin();
            }
            com.tencent.mm.kernel.g.azz().b(new cd(8));
            AppMethodBeat.o(260348);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return -1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(260354);
        setTheme(R.style.q6);
        super.onCreate(bundle);
        com.tencent.mm.kernel.g.azz().a(3761, this);
        com.tencent.mm.ui.statusbar.d.e(getWindow());
        ak.a aVar = ak.wan;
        this.vKO = ak.a.dm(this.UJs, this.UJs.getResources().getString(R.string.dbf));
        ak akVar = this.vKO;
        if (akVar != null) {
            akVar.begin();
        }
        setBackBtn(new l(this));
        this.gmC.alive();
        String stringExtra = getIntent().getStringExtra("KEY_LUCKY_MONEY_CHAT_ROOM_USERNAME");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.roomId = stringExtra;
        Log.i("Finder.FinderLivePostPendingUI", "roomId " + this.roomId);
        prepare();
        AppMethodBeat.o(260354);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class l implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ OccupyFinderUI20 UJw;

        l(OccupyFinderUI20 occupyFinderUI20) {
            this.UJw = occupyFinderUI20;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(260349);
            this.UJw.finish();
            AppMethodBeat.o(260349);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(260355);
        Log.i("Finder.FinderLivePostPendingUI", "onActivityResult,requestCode:" + i2 + ",resultCode:" + i3 + ",face verify result:" + (intent != null ? Integer.valueOf(intent.getIntExtra("FACE_VERIFY_RESULT", 0)) : null));
        if (i2 == 10000) {
            if (i3 == -1) {
                if (intent == null) {
                    AppMethodBeat.o(260355);
                    return;
                } else if (intent.getIntExtra("FACE_VERIFY_RESULT", 0) == 1) {
                    dzC();
                    AppMethodBeat.o(260355);
                    return;
                }
            }
        } else if (i2 != 10001 && i2 == 10002) {
            FinderCreateContactUI.a aVar = FinderCreateContactUI.vIZ;
            if (i3 == FinderCreateContactUI.hVm()) {
                hSU();
                AppMethodBeat.o(260355);
                return;
            }
            this.UJs.finish();
        }
        AppMethodBeat.o(260355);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        boolean z = true;
        AppMethodBeat.i(260356);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        if (i2 == 16 || i2 == 80) {
            if (iArr.length == 0) {
                z = false;
            }
            if (!z || iArr[0] != 0) {
                Log.i("Finder.FinderLivePostPendingUI", "FinderLive request permission " + i2 + " failed");
            } else {
                dzC();
                AppMethodBeat.o(260356);
                return;
            }
        }
        AppMethodBeat.o(260356);
    }

    private void prepare() {
        AppMethodBeat.i(260357);
        Log.i("Finder.FinderLivePostPendingUI", "prepare()");
        String aUg = z.aUg();
        if (!dzA()) {
            Log.e("Finder.FinderLivePostPendingUI", "prepare() checkNetworkAvailable failed");
            ak akVar = this.vKO;
            if (akVar != null) {
                akVar.end();
                AppMethodBeat.o(260357);
                return;
            }
            AppMethodBeat.o(260357);
        } else if (!avQ(aUg)) {
            Log.e("Finder.FinderLivePostPendingUI", "prepare() checkAccountValid failed");
            ak akVar2 = this.vKO;
            if (akVar2 != null) {
                akVar2.end();
                AppMethodBeat.o(260357);
                return;
            }
            AppMethodBeat.o(260357);
        } else {
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            if (p.j(aAh.azQ().get(ar.a.USERINFO_FINDER_LIVE_SHOW_FIDNER_ACCOUNT_CONFIRM_INT_SYNC, (Object) 0), 0)) {
                com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
                p.g(aAh2, "MMKernel.storage()");
                aAh2.azQ().set(ar.a.USERINFO_FINDER_LIVE_SHOW_FIDNER_ACCOUNT_CONFIRM_INT_SYNC, (Object) 1);
                ak akVar3 = this.vKO;
                if (akVar3 != null) {
                    akVar3.end();
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(22385, 5, Long.valueOf(System.currentTimeMillis()));
                z.a aVar = new z.a();
                aVar.SYB = false;
                p.g(aUg, "finderUsername");
                FinderBottomCustomDialogHelper.Companion.showUserInfoConfirmDialog(this.UJs, aUg, new m(this, aVar), n.UJx, new o(this, aVar));
                AppMethodBeat.o(260357);
                return;
            }
            hSU();
            AppMethodBeat.o(260357);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    public static final class m implements DialogInterface.OnClickListener {
        final /* synthetic */ z.a UJv;
        final /* synthetic */ OccupyFinderUI20 UJw;

        m(OccupyFinderUI20 occupyFinderUI20, z.a aVar) {
            this.UJw = occupyFinderUI20;
            this.UJv = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(260350);
            this.UJv.SYB = true;
            OccupyFinderUI20.a(this.UJw);
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(22385, 6, Long.valueOf(System.currentTimeMillis()));
            AppMethodBeat.o(260350);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    public static final class n implements DialogInterface.OnClickListener {
        public static final n UJx = new n();

        static {
            AppMethodBeat.i(260352);
            AppMethodBeat.o(260352);
        }

        n() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(260351);
            if (dialogInterface != null) {
                dialogInterface.dismiss();
                AppMethodBeat.o(260351);
                return;
            }
            AppMethodBeat.o(260351);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    public static final class o implements DialogInterface.OnDismissListener {
        final /* synthetic */ z.a UJv;
        final /* synthetic */ OccupyFinderUI20 UJw;

        o(OccupyFinderUI20 occupyFinderUI20, z.a aVar) {
            this.UJw = occupyFinderUI20;
            this.UJv = aVar;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(260353);
            if (!this.UJv.SYB) {
                this.UJw.UJs.finish();
            }
            AppMethodBeat.o(260353);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(260358);
        super.onDestroy();
        this.gmC.dead();
        Log.i("Finder.FinderLivePostPendingUI", "release()");
        Log.i("Finder.FinderLivePostPendingUI", "reset()");
        this.vKP = false;
        ak akVar = this.vKO;
        if (akVar != null) {
            akVar.wam = 0;
        }
        com.tencent.mm.kernel.g.azz().b(5231, this);
        com.tencent.mm.kernel.g.azz().b(3761, this);
        this.vKL = null;
        this.vKM = null;
        this.uiv = null;
        this.vKN = null;
        AppMethodBeat.o(260358);
    }

    private final boolean dzA() {
        AppMethodBeat.i(260359);
        if (!NetStatusUtil.isConnected(this.UJs)) {
            new f.a(this.UJs).hbu().bow(this.UJs.getResources().getString(R.string.ct_)).boA(this.UJs.getResources().getString(R.string.w0)).b(new i(this)).show();
            Log.e("Finder.FinderLivePostPendingUI", "checkNetworkAvailable() network problem");
            AppMethodBeat.o(260359);
            return false;
        }
        AppMethodBeat.o(260359);
        return true;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    public static final class i implements f.c {
        final /* synthetic */ OccupyFinderUI20 UJw;

        i(OccupyFinderUI20 occupyFinderUI20) {
            this.UJw = occupyFinderUI20;
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
            AppMethodBeat.i(260346);
            this.UJw.UJs.finish();
            AppMethodBeat.o(260346);
        }
    }

    private final boolean avQ(String str) {
        AppMethodBeat.i(260360);
        Log.i("Finder.FinderLivePostPendingUI", "checkAccountValid()");
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_PREPARE_USER_FLAG_INT_SYNC, 0);
        if ((i2 & 1) != 0) {
            Log.i("Finder.FinderLivePostPendingUI", "checkAccountValid() check has real name userFlag %d", Integer.valueOf(i2));
            z.a aVar = new z.a();
            aVar.SYB = false;
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(22385, 9, Long.valueOf(System.currentTimeMillis()));
            FinderBottomCustomDialogHelper.Companion.showRealNameCertificationDialogOnRedPacket(this.UJs, new b(aVar), new c(this), new d(this, aVar));
            AppMethodBeat.o(260360);
            return false;
        } else if (Util.isNullOrNil(str)) {
            Log.i("Finder.FinderLivePostPendingUI", "checkAccountValid() need create finder contact.");
            Intent intent = new Intent();
            intent.putExtra("KEY_GO_TO_AFTER_CREATE_SUCCESS", 1);
            intent.putExtra("key_router_to_profile", false);
            z.a aVar2 = new z.a();
            aVar2.SYB = false;
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(22385, 7, Long.valueOf(System.currentTimeMillis()));
            FinderBottomCustomDialogHelper.Companion.showCreateFinderUserDialogOnLiveRedPacket(this.UJs, 5, intent, 10002, new e(aVar2), new f(this), new g(this, aVar2));
            AppMethodBeat.o(260360);
            return false;
        } else {
            AppMethodBeat.o(260360);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    public static final class b implements DialogInterface.OnClickListener {
        final /* synthetic */ z.a UJv;

        b(z.a aVar) {
            this.UJv = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(260339);
            this.UJv.SYB = true;
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(22385, 10, Long.valueOf(System.currentTimeMillis()));
            AppMethodBeat.o(260339);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    public static final class c implements DialogInterface.OnClickListener {
        final /* synthetic */ OccupyFinderUI20 UJw;

        c(OccupyFinderUI20 occupyFinderUI20) {
            this.UJw = occupyFinderUI20;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(260340);
            this.UJw.UJs.finish();
            AppMethodBeat.o(260340);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    public static final class d implements DialogInterface.OnDismissListener {
        final /* synthetic */ z.a UJv;
        final /* synthetic */ OccupyFinderUI20 UJw;

        d(OccupyFinderUI20 occupyFinderUI20, z.a aVar) {
            this.UJw = occupyFinderUI20;
            this.UJv = aVar;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(260341);
            if (!this.UJv.SYB) {
                this.UJw.UJs.finish();
            }
            AppMethodBeat.o(260341);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    public static final class e implements DialogInterface.OnClickListener {
        final /* synthetic */ z.a UJv;

        e(z.a aVar) {
            this.UJv = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(260342);
            this.UJv.SYB = true;
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(22385, 8, Long.valueOf(System.currentTimeMillis()));
            AppMethodBeat.o(260342);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    public static final class f implements DialogInterface.OnClickListener {
        final /* synthetic */ OccupyFinderUI20 UJw;

        f(OccupyFinderUI20 occupyFinderUI20) {
            this.UJw = occupyFinderUI20;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(260343);
            this.UJw.UJs.finish();
            AppMethodBeat.o(260343);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    public static final class g implements DialogInterface.OnDismissListener {
        final /* synthetic */ z.a UJv;
        final /* synthetic */ OccupyFinderUI20 UJw;

        g(OccupyFinderUI20 occupyFinderUI20, z.a aVar) {
            this.UJw = occupyFinderUI20;
            this.UJv = aVar;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(260344);
            if (!this.UJv.SYB) {
                this.UJw.UJs.finish();
            }
            AppMethodBeat.o(260344);
        }
    }

    private final void hSU() {
        AppMethodBeat.i(260361);
        Log.i("Finder.FinderLivePostPendingUI", "handleConfirmPostLive");
        ak akVar = this.vKO;
        if (akVar != null) {
            akVar.end();
        }
        hSV();
        hSW();
        hSX();
        dzC();
        AppMethodBeat.o(260361);
    }

    private final void hSV() {
        AppMethodBeat.i(260362);
        if (this.vKL == null) {
            com.tencent.mm.kernel.g.azz().b(new cd(8));
            ak akVar = this.vKO;
            if (akVar != null) {
                akVar.begin();
                x xVar = x.SXb;
                AppMethodBeat.o(260362);
                return;
            }
        }
        AppMethodBeat.o(260362);
    }

    private final void hSW() {
        AppMethodBeat.i(260363);
        if (dzB() && this.vKN == null) {
            com.tencent.mm.kernel.g.azz().a(5231, this);
            com.tencent.mm.kernel.g.azz().b(new bu());
            ak akVar = this.vKO;
            if (akVar != null) {
                akVar.begin();
                x xVar = x.SXb;
                AppMethodBeat.o(260363);
                return;
            }
        }
        AppMethodBeat.o(260363);
    }

    private final void hSX() {
        AppMethodBeat.i(260364);
        if (this.vKM == null) {
            z.e eVar = new z.e();
            eVar.SYF = System.currentTimeMillis();
            am amVar = am.tuw;
            new s(am.cXY(), com.tencent.mm.model.z.aUg(), eVar.SYF, new h(eVar, this), (byte) 0).aYI();
            ak akVar = this.vKO;
            if (akVar != null) {
                akVar.begin();
                x xVar = x.SXb;
                AppMethodBeat.o(260364);
                return;
            }
        }
        AppMethodBeat.o(260364);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/feed/ui/OccupyFinderUI20$checkLivePrepare$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "reqId", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "plugin-finder_release"})
    public static final class h implements s.a {
        final /* synthetic */ OccupyFinderUI20 UJw;
        final /* synthetic */ z.e vKR;

        h(z.e eVar, OccupyFinderUI20 occupyFinderUI20) {
            this.vKR = eVar;
            this.UJw = occupyFinderUI20;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.s.a
        public final void a(int i2, int i3, String str, long j2, aqb aqb) {
            AppMethodBeat.i(260345);
            p.h(aqb, "resp");
            if (this.vKR.SYF != j2) {
                Log.i("Finder.FinderLivePostPendingUI", "result errCode:" + i3 + ",errMsg:" + str + ",errType:" + i2 + ",requestId:" + this.vKR.SYF + ",scene.requestId:" + j2);
            } else if (i2 == 0 && i3 == 0) {
                OccupyFinderUI20.a(this.UJw, aqb);
            } else {
                u.makeText(this.UJw.UJs, (int) R.string.d5v, 1).show();
            }
            ak akVar = this.UJw.vKO;
            if (akVar != null) {
                akVar.end();
                AppMethodBeat.o(260345);
                return;
            }
            AppMethodBeat.o(260345);
        }
    }

    private static boolean dzB() {
        AppMethodBeat.i(260365);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_FINDER_LIVE_VERIFY_BOOLEAN_SYNC, Boolean.FALSE);
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(260365);
            throw tVar;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        Log.i("Finder.FinderLivePostPendingUI", "isVerify:".concat(String.valueOf(booleanValue)));
        if (BuildInfo.DEBUG) {
            booleanValue = true;
        }
        AppMethodBeat.o(260365);
        return booleanValue;
    }

    private static boolean Lp(int i2) {
        boolean z = true;
        AppMethodBeat.i(260366);
        if (com.tencent.mm.ac.d.cW(i2, 1)) {
            z = false;
        }
        Log.i("Finder.FinderLivePostPendingUI", "globalEnable enable:" + z + ",flag:" + i2);
        AppMethodBeat.o(260366);
        return z;
    }

    private static boolean Lq(int i2) {
        boolean z = true;
        AppMethodBeat.i(260367);
        if (com.tencent.mm.ac.d.cW(i2, 1)) {
            z = false;
        }
        Log.i("Finder.FinderLivePostPendingUI", "privateEnable enable:" + z + ",flag:" + i2);
        AppMethodBeat.o(260367);
        return z;
    }

    private final void dzC() {
        bel bel;
        bel bel2;
        FinderObject finderObject;
        String str;
        bel bel3;
        bel bel4;
        awe awe;
        awe awe2;
        AppMethodBeat.i(260368);
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        p.g(mainLooper, "Looper.getMainLooper()");
        if (!p.j(currentThread, mainLooper.getThread())) {
            com.tencent.mm.ac.d.h(new j(this));
            AppMethodBeat.o(260368);
            return;
        }
        Log.i("Finder.FinderLivePostPendingUI", "gotoLive");
        if (this.vKP) {
            Log.e("Finder.FinderLivePostPendingUI", "gotoLive 已经进入直播间.");
            AppMethodBeat.o(260368);
        } else if (this.vKL == null) {
            Log.e("Finder.FinderLivePostPendingUI", "gotoLive finderUserPrepareResponse is null.");
            AppMethodBeat.o(260368);
        } else {
            aqb aqb = this.vKM;
            if (aqb != null) {
                com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
                if (com.tencent.mm.plugin.finder.live.model.o.dfZ() == null && aqb.LBU != null) {
                    FinderObject finderObject2 = aqb.LBU;
                    if ((finderObject2 != null ? finderObject2.liveInfo : null) != null && ((finderObject = aqb.LBU) == null || (awe2 = finderObject.liveInfo) == null || awe2.liveId != 0)) {
                        StringBuilder sb = new StringBuilder("gotoLive continue live:");
                        FinderObject finderObject3 = aqb.LBU;
                        Log.i("Finder.FinderLivePostPendingUI", sb.append((finderObject3 == null || (awe = finderObject3.liveInfo) == null) ? null : Long.valueOf(awe.liveId)).toString());
                        Intent intent = new Intent();
                        ArrayList<String> arrayList = new ArrayList<>();
                        arrayList.add(this.roomId);
                        intent.putStringArrayListExtra("KEY_LUCKY_MONEY_CHAT_ROOM_USERNAME", arrayList);
                        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                        OccupyFinderUI20 occupyFinderUI20 = this.UJs;
                        FinderObject finderObject4 = aqb.LBU;
                        if (finderObject4 == null) {
                            p.hyc();
                        }
                        long j2 = finderObject4.id;
                        FinderObject finderObject5 = aqb.LBU;
                        if (finderObject5 == null || (str = finderObject5.objectNonceId) == null) {
                            str = "";
                        }
                        FinderObject finderObject6 = aqb.LBU;
                        if (finderObject6 == null) {
                            p.hyc();
                        }
                        awe awe3 = finderObject6.liveInfo;
                        if (awe3 == null) {
                            p.hyc();
                        }
                        p.g(awe3, "it.recover_live_object!!.liveInfo!!");
                        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                        bed bed = this.vKL;
                        int i2 = bed != null ? bed.LNW : 0;
                        bed bed2 = this.vKL;
                        String str2 = (bed2 == null || (bel4 = bed2.wxaShopInfo) == null) ? null : bel4.appId;
                        bed bed3 = this.vKL;
                        boolean z = com.tencent.mm.plugin.finder.utils.m.z(i2, str2, (bed3 == null || (bel3 = bed3.wxaShopInfo) == null) ? null : bel3.LOg);
                        awt awt = this.uiv;
                        FinderObject finderObject7 = aqb.LBU;
                        com.tencent.mm.plugin.finder.utils.a.a(occupyFinderUI20, j2, str, awe3, z, awt, null, aqb.LBV, aqb.LBW, null, finderObject7 != null ? finderObject7.sessionBuffer : null, aqb.LBX, intent, 1168);
                        AppMethodBeat.o(260368);
                        return;
                    }
                }
                if (!Lp(aqb.LBS)) {
                    Lr(2);
                    Log.w("Finder.FinderLivePostPendingUI", "gotoLive type:" + aqb.LBS);
                    AppMethodBeat.o(260368);
                } else if (!Lq(aqb.KTQ)) {
                    Lr(2);
                    Log.w("Finder.FinderLivePostPendingUI", "gotoLive type:" + aqb.KTQ);
                    AppMethodBeat.o(260368);
                } else {
                    if (dzB()) {
                        if (this.vKN != null) {
                            axq axq = this.vKN;
                            if (axq == null) {
                                p.hyc();
                            }
                            if (!axq.sPX) {
                                axq axq2 = this.vKN;
                                if (axq2 == null) {
                                    p.hyc();
                                }
                                if (!Util.isNullOrNil(axq2.HIt)) {
                                    axq axq3 = this.vKN;
                                    if (axq3 == null) {
                                        p.hyc();
                                    }
                                    String str3 = axq3.HIt;
                                    if (str3 == null) {
                                        str3 = "";
                                    }
                                    avR(str3);
                                } else {
                                    u.makeText(this.UJs, this.UJs.getResources().getString(R.string.cxt), 0).show();
                                    StringBuilder sb2 = new StringBuilder("handleNetSceneFinderLiveVerify() real name Url is empty:");
                                    axq axq4 = this.vKN;
                                    Log.e("Finder.FinderLivePostPendingUI", sb2.append(axq4 != null ? axq4.HIt : null).toString());
                                }
                                StringBuilder sb3 = new StringBuilder("gotoLive, is verify:");
                                axq axq5 = this.vKN;
                                if (axq5 == null) {
                                    p.hyc();
                                }
                                Log.i("Finder.FinderLivePostPendingUI", sb3.append(axq5.sPX).toString());
                                AppMethodBeat.o(260368);
                                return;
                            }
                        } else {
                            Log.e("Finder.FinderLivePostPendingUI", "gotoLive finderLiveVerifyResp is null.");
                            AppMethodBeat.o(260368);
                            return;
                        }
                    }
                    if (!al(this.UJs)) {
                        Log.e("Finder.FinderLivePostPendingUI", "gotoLive permission is invalid.");
                        AppMethodBeat.o(260368);
                        return;
                    }
                    if (this.vKM != null) {
                        Intent intent2 = new Intent();
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        arrayList2.add(this.roomId);
                        intent2.putStringArrayListExtra("KEY_LUCKY_MONEY_CHAT_ROOM_USERNAME", arrayList2);
                        com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                        OccupyFinderUI20 occupyFinderUI202 = this.UJs;
                        com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
                        bed bed4 = this.vKL;
                        int i3 = bed4 != null ? bed4.LNW : 0;
                        bed bed5 = this.vKL;
                        String str4 = (bed5 == null || (bel2 = bed5.wxaShopInfo) == null) ? null : bel2.appId;
                        bed bed6 = this.vKL;
                        com.tencent.mm.plugin.finder.utils.a.a(occupyFinderUI202, com.tencent.mm.plugin.finder.utils.m.z(i3, str4, (bed6 == null || (bel = bed6.wxaShopInfo) == null) ? null : bel.LOg), this.vKM, intent2);
                    }
                    this.vKP = true;
                    Log.w("Finder.FinderLivePostPendingUI", "gotoLive 进入直播间.");
                    finish();
                    AppMethodBeat.o(260368);
                }
            } else {
                Log.e("Finder.FinderLivePostPendingUI", "gotoLive finderCreateLivePrepareResponse is null.");
                AppMethodBeat.o(260368);
            }
        }
    }

    private static boolean al(Activity activity) {
        AppMethodBeat.i(260369);
        Log.i("Finder.FinderLivePostPendingUI", "checkLivePermission()");
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(activity, "android.permission.CAMERA", 16, "", "");
        if (!a2) {
            Log.i("Finder.FinderLivePostPendingUI", "checkLivePermission() invalid checkCamera:".concat(String.valueOf(a2)));
            AppMethodBeat.o(260369);
            return false;
        }
        boolean a3 = com.tencent.mm.pluginsdk.permission.b.a(activity, "android.permission.RECORD_AUDIO", 80, "", "");
        if (!a3) {
            Log.i("Finder.FinderLivePostPendingUI", "checkLivePermission() invalid checkMicroPhone:".concat(String.valueOf(a3)));
            AppMethodBeat.o(260369);
            return false;
        }
        AppMethodBeat.o(260369);
        return true;
    }

    private final void avR(String str) {
        AppMethodBeat.i(260370);
        Log.i("Finder.FinderLivePostPendingUI", "gotoFaceVerify ".concat(String.valueOf(str)));
        Intent intent = new Intent();
        intent.putExtra("LIVE_HELP_TYPE", 1);
        intent.putExtra("FACE_VERIFY_URL", str);
        intent.setClass(this.UJs, FinderLivePostHelperUI.class);
        this.UJs.startActivityForResult(intent, 10000);
        AppMethodBeat.o(260370);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(260371);
        Log.i("Finder.FinderLivePostPendingUI", "onSceneEnd scene:" + (qVar != null ? Integer.valueOf(qVar.getType()) : null) + " result errCode:" + i3 + ",errMsg:" + str + ",errType:" + i2);
        if (qVar instanceof bu) {
            OccupyFinderUI20 occupyFinderUI20 = this.UJs;
            bu buVar = (bu) qVar;
            Log.i("Finder.FinderLivePostPendingUI", "handleNetSceneFinderLiveVerify()");
            com.tencent.mm.kernel.g.azz().b(5231, this);
            if ((i2 != 0 || i3 != 0) && i3 != -200008) {
                switch (i3) {
                    case -200018:
                    case -200012:
                        Lr(2);
                        break;
                    case -200017:
                    case -200016:
                    case -200015:
                    case -200014:
                    case -200013:
                    default:
                        u.makeText(occupyFinderUI20, occupyFinderUI20.getResources().getString(R.string.cs1), 0).show();
                        break;
                    case -200011:
                        Lr(3);
                        break;
                    case -200010:
                        u.makeText(occupyFinderUI20, occupyFinderUI20.getResources().getString(R.string.cqt), 0).show();
                        break;
                    case -200009:
                        u.makeText(occupyFinderUI20, occupyFinderUI20.getResources().getString(R.string.cqx), 0).show();
                        break;
                }
            } else {
                this.vKN = buVar.cYK();
                dzC();
                StringBuilder sb = new StringBuilder("handleNetSceneFinderLiveVerify() is verify:");
                axq axq = this.vKN;
                if (axq == null) {
                    p.hyc();
                }
                Log.i("Finder.FinderLivePostPendingUI", sb.append(axq.sPX).toString());
            }
            ak akVar = this.vKO;
            if (akVar != null) {
                akVar.end();
                AppMethodBeat.o(260371);
                return;
            }
            AppMethodBeat.o(260371);
            return;
        }
        if (qVar instanceof cd) {
            if (this.UJt) {
                ak akVar2 = this.vKO;
                if (akVar2 != null) {
                    akVar2.end();
                }
                this.UJt = false;
                prepare();
                AppMethodBeat.o(260371);
                return;
            }
            OccupyFinderUI20 occupyFinderUI202 = this.UJs;
            cd cdVar = (cd) qVar;
            Log.i("Finder.FinderLivePostPendingUI", "handleNetSceneFinderPrepareUser()");
            if (i2 == 0 && i3 == 0) {
                this.vKL = cdVar.cZc();
                dzC();
            } else {
                u.makeText(occupyFinderUI202, (int) R.string.d5v, 1).show();
            }
            ak akVar3 = this.vKO;
            if (akVar3 != null) {
                akVar3.end();
                AppMethodBeat.o(260371);
                return;
            }
        }
        AppMethodBeat.o(260371);
    }

    private final void Lr(int i2) {
        AppMethodBeat.i(260372);
        Log.i("Finder.FinderLivePostPendingUI", "showErrPage type:".concat(String.valueOf(i2)));
        Intent intent = new Intent();
        intent.putExtra("LIVE_HELP_TYPE", i2);
        intent.setClass(this.UJs, FinderLivePostHelperUI.class);
        this.UJs.startActivityForResult(intent, 10001);
        AppMethodBeat.o(260372);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class j extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ OccupyFinderUI20 UJw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(OccupyFinderUI20 occupyFinderUI20) {
            super(0);
            this.UJw = occupyFinderUI20;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(260347);
            OccupyFinderUI20.c(this.UJw);
            x xVar = x.SXb;
            AppMethodBeat.o(260347);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(OccupyFinderUI20 occupyFinderUI20, aqb aqb) {
        AppMethodBeat.i(260376);
        Log.i("Finder.FinderLivePostPendingUI", "handleOnCreateLivePrepareResponse()");
        occupyFinderUI20.vKM = aqb;
        occupyFinderUI20.uiv = aqb.live_notice_info;
        occupyFinderUI20.dzC();
        AppMethodBeat.o(260376);
    }
}
