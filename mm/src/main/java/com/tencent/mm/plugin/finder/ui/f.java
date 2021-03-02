package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Looper;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.cgi.bu;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.live.model.cgi.s;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.ak;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqb;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.axq;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 B2\u00020\u0001:\u0001BB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0013H\u0002J\b\u0010 \u001a\u00020\u0017H\u0002J\b\u0010!\u001a\u00020\u0017H\u0002J2\u0010\"\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001d2\b\u0010&\u001a\u0004\u0018\u00010\u00132\u0006\u0010'\u001a\u00020(H\u0002J2\u0010)\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001d2\b\u0010&\u001a\u0004\u0018\u00010\u00132\u0006\u0010'\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0006H\u0002J\b\u0010-\u001a\u00020\u000eH\u0002J \u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u001d2\b\u00101\u001a\u0004\u0018\u000102J+\u00103\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u001d2\u000e\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u0013052\u0006\u00106\u001a\u000207¢\u0006\u0002\u00108J,\u00109\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001d2\b\u0010&\u001a\u0004\u0018\u00010\u00132\b\u0010'\u001a\u0004\u0018\u00010:H\u0016J\u0006\u0010;\u001a\u00020\u0017J\u0010\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u001dH\u0002J\u0006\u0010>\u001a\u00020\u0017J\u0006\u0010?\u001a\u00020\u0017J\u0012\u0010@\u001a\u00020\u00172\b\b\u0002\u0010A\u001a\u00020\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderLivePostForNearby;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "finderCreateLivePrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "finderLiveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "finderLiveVerifyResp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveVerifyResp;", "finderUserPrepareResponse", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "hasEnterLiveRoom", "", "loadingComponent", "Lcom/tencent/mm/plugin/finder/utils/MultiDelayLoadingComponent;", "checkAccountValid", "finderUsername", "", "checkLivePermission", "context", "checkLivePrepare", "", "checkNetworkAvailable", "checkUserInfo", "checkVerify", "globalEnable", "globalFlag", "", "gotoFaceVerify", "verifyUrl", "gotoLive", "handleConfirmPostLive", "handleNetSceneFinderLiveVerify", "Landroid/content/Context;", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderLiveVerify;", "handleNetSceneFinderPrepareUser", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPrepareUser;", "handleOnCreateLivePrepareResponse", "resp", "isVerify", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onRequestPermissionsResult", NativeProtocol.RESULT_ARGS_PERMISSIONS, "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSceneEnd", "Lcom/tencent/mm/modelbase/NetSceneBase;", "prepare", "privateEnable", "privateFlag", "release", "reset", "showErrPage", "type", "Companion", "plugin-finder_release"})
public final class f implements i {
    public static final a vKQ = new a((byte) 0);
    private final Activity activity;
    public awt uiv;
    public bed vKL;
    public aqb vKM;
    public axq vKN;
    private ak vKO = ak.a.dm(this.activity, this.activity.getResources().getString(R.string.dbf));
    private boolean vKP;

    static {
        AppMethodBeat.i(252471);
        AppMethodBeat.o(252471);
    }

    public f(Activity activity2) {
        p.h(activity2, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(252470);
        this.activity = activity2;
        ak.a aVar = ak.wan;
        AppMethodBeat.o(252470);
    }

    public static final /* synthetic */ void d(f fVar) {
        AppMethodBeat.i(252474);
        fVar.dzC();
        AppMethodBeat.o(252474);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderLivePostForNearby$Companion;", "", "()V", "ENTER_LIVE_FACE_VERIFY_REQUEST_CODE", "", "ENTER_LIVE_FORBIDDEN_REQUEST_CODE", "PREPARE_TIME_OUT_MS", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(252456);
        Log.i("Finder.FinderLivePostForNearby", "onActivityResult,requestCode:" + i2 + ",resultCode:" + i3 + ",face verify result:" + (intent != null ? Integer.valueOf(intent.getIntExtra("FACE_VERIFY_RESULT", 0)) : null));
        if (i2 == 10000 && i3 == -1) {
            if (intent == null) {
                AppMethodBeat.o(252456);
                return;
            } else if (intent.getIntExtra("FACE_VERIFY_RESULT", 0) == 1) {
                dzC();
            }
        }
        AppMethodBeat.o(252456);
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        boolean z = true;
        AppMethodBeat.i(252457);
        p.h(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        p.h(iArr, "grantResults");
        if (i2 == 16 || i2 == 80) {
            if (iArr.length == 0) {
                z = false;
            }
            if (!z || iArr[0] != 0) {
                Log.i("Finder.FinderLivePostForNearby", "FinderLive request permission " + i2 + " failed");
            } else {
                dzC();
                AppMethodBeat.o(252457);
                return;
            }
        }
        AppMethodBeat.o(252457);
    }

    public final void prepare() {
        AppMethodBeat.i(252458);
        Log.i("Finder.FinderLivePostForNearby", "prepare()");
        String aUg = z.aUg();
        if (!dzA()) {
            Log.e("Finder.FinderLivePostForNearby", "prepare() checkNetworkAvailable failed");
            AppMethodBeat.o(252458);
        } else if (!avQ(aUg)) {
            Log.e("Finder.FinderLivePostForNearby", "prepare() checkAccountValid failed");
            AppMethodBeat.o(252458);
        } else {
            k kVar = k.vkd;
            k.dpl().a(s.ah.START_LIVE_BY_FINDER_IDENTITY);
            p.g(aUg, "finderUsername");
            FinderBottomCustomDialogHelper.Companion.showUserInfoConfirmDialog$default(FinderBottomCustomDialogHelper.Companion, this.activity, aUg, new e(this), DialogInterface$OnClickListenerC1297f.vKU, null, 16, null);
            AppMethodBeat.o(252458);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    public static final class e implements DialogInterface.OnClickListener {
        final /* synthetic */ f vKS;

        e(f fVar) {
            this.vKS = fVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(252454);
            f.a(this.vKS);
            k kVar = k.vkd;
            k.a(s.af.CLICK_START_LIVE);
            AppMethodBeat.o(252454);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    /* renamed from: com.tencent.mm.plugin.finder.ui.f$f  reason: collision with other inner class name */
    public static final class DialogInterface$OnClickListenerC1297f implements DialogInterface.OnClickListener {
        public static final DialogInterface$OnClickListenerC1297f vKU = new DialogInterface$OnClickListenerC1297f();

        static {
            AppMethodBeat.i(252455);
            AppMethodBeat.o(252455);
        }

        DialogInterface$OnClickListenerC1297f() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
        }
    }

    public final void reset() {
        AppMethodBeat.i(252459);
        Log.i("Finder.FinderLivePostForNearby", "reset()");
        this.vKP = false;
        ak akVar = this.vKO;
        if (akVar != null) {
            akVar.wam = 0;
            AppMethodBeat.o(252459);
            return;
        }
        AppMethodBeat.o(252459);
    }

    private final boolean dzA() {
        AppMethodBeat.i(252460);
        if (!NetStatusUtil.isConnected(this.activity)) {
            new f.a(this.activity).hbu().bow(this.activity.getResources().getString(R.string.ct_)).boA(this.activity.getResources().getString(R.string.w0)).b(c.vKT).show();
            Log.e("Finder.FinderLivePostForNearby", "checkNetworkAvailable() network problem");
            AppMethodBeat.o(252460);
            return false;
        }
        AppMethodBeat.o(252460);
        return true;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    public static final class c implements f.c {
        public static final c vKT = new c();

        static {
            AppMethodBeat.i(252452);
            AppMethodBeat.o(252452);
        }

        c() {
        }

        @Override // com.tencent.mm.ui.widget.a.f.c
        public final void e(boolean z, String str) {
        }
    }

    private final boolean avQ(String str) {
        AppMethodBeat.i(252461);
        Log.i("Finder.FinderLivePostForNearby", "checkAccountValid()");
        if (Util.isNullOrNil(str)) {
            Log.i("Finder.FinderLivePostForNearby", "checkAccountValid() need create finder contact.");
            k kVar = k.vkd;
            k.dpl().a(s.ah.CREATE_FINDER);
            FinderBottomCustomDialogHelper.Companion.showCreateFinderUserDialog$default(FinderBottomCustomDialogHelper.Companion, this.activity, 3, null, 4, null);
            AppMethodBeat.o(252461);
            return false;
        }
        com.tencent.mm.kernel.e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_PREPARE_USER_FLAG_INT_SYNC, 0);
        if ((i2 & 1) != 0) {
            Log.i("Finder.FinderLivePostForNearby", "checkAccountValid() check has real name userFlag %d", Integer.valueOf(i2));
            k kVar2 = k.vkd;
            k.dpl().a(s.ah.WECHAT_REALNAME_AUTH);
            FinderBottomCustomDialogHelper.Companion.showRealNameCertificationDialog(this.activity);
            AppMethodBeat.o(252461);
            return false;
        }
        AppMethodBeat.o(252461);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderLivePostForNearby$checkLivePrepare$1$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLivePrepare$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "reqId", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLivePrepareResponse;", "plugin-finder_release"})
    public static final class b implements s.a {
        final /* synthetic */ z.e vKR;
        final /* synthetic */ f vKS;

        b(z.e eVar, f fVar) {
            this.vKR = eVar;
            this.vKS = fVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.s.a
        public final void a(int i2, int i3, String str, long j2, aqb aqb) {
            AppMethodBeat.i(252451);
            p.h(aqb, "resp");
            if (this.vKR.SYF != j2) {
                Log.i("Finder.FinderLivePostForNearby", "result errCode:" + i3 + ",errMsg:" + str + ",errType:" + i2 + ",requestId:" + this.vKR.SYF + ",scene.requestId:" + j2);
            } else if (i2 == 0 && i3 == 0) {
                f.a(this.vKS, aqb);
            } else {
                u.makeText(this.vKS.activity, (int) R.string.d5v, 1).show();
            }
            ak akVar = this.vKS.vKO;
            if (akVar != null) {
                akVar.end();
                AppMethodBeat.o(252451);
                return;
            }
            AppMethodBeat.o(252451);
        }
    }

    private static boolean dzB() {
        AppMethodBeat.i(252462);
        com.tencent.mm.kernel.e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_FINDER_LIVE_VERIFY_BOOLEAN_SYNC, Boolean.FALSE);
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(252462);
            throw tVar;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        Log.i("Finder.FinderLivePostForNearby", "isVerify:".concat(String.valueOf(booleanValue)));
        if (BuildInfo.DEBUG) {
            booleanValue = true;
        }
        AppMethodBeat.o(252462);
        return booleanValue;
    }

    private static boolean Lp(int i2) {
        boolean z = true;
        AppMethodBeat.i(252463);
        if (com.tencent.mm.ac.d.cW(i2, 1)) {
            z = false;
        }
        Log.i("Finder.FinderLivePostForNearby", "globalEnable enable:" + z + ",flag:" + i2);
        AppMethodBeat.o(252463);
        return z;
    }

    private static boolean Lq(int i2) {
        boolean z = true;
        AppMethodBeat.i(252464);
        if (com.tencent.mm.ac.d.cW(i2, 1)) {
            z = false;
        }
        Log.i("Finder.FinderLivePostForNearby", "privateEnable enable:" + z + ",flag:" + i2);
        AppMethodBeat.o(252464);
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
        AppMethodBeat.i(252465);
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        p.g(mainLooper, "Looper.getMainLooper()");
        if (!p.j(currentThread, mainLooper.getThread())) {
            com.tencent.mm.ac.d.h(new d(this));
            AppMethodBeat.o(252465);
            return;
        }
        Log.i("Finder.FinderLivePostForNearby", "gotoLive");
        if (this.vKP) {
            Log.e("Finder.FinderLivePostForNearby", "gotoLive 已经进入直播间.");
            AppMethodBeat.o(252465);
        } else if (this.vKL == null) {
            Log.e("Finder.FinderLivePostForNearby", "gotoLive finderUserPrepareResponse is null.");
            AppMethodBeat.o(252465);
        } else {
            aqb aqb = this.vKM;
            if (aqb != null) {
                o oVar = o.ujN;
                if (o.dfZ() == null && aqb.LBU != null) {
                    FinderObject finderObject2 = aqb.LBU;
                    if ((finderObject2 != null ? finderObject2.liveInfo : null) != null && ((finderObject = aqb.LBU) == null || (awe2 = finderObject.liveInfo) == null || awe2.liveId != 0)) {
                        StringBuilder sb = new StringBuilder("gotoLive continue live:");
                        FinderObject finderObject3 = aqb.LBU;
                        Log.i("Finder.FinderLivePostForNearby", sb.append((finderObject3 == null || (awe = finderObject3.liveInfo) == null) ? null : Long.valueOf(awe.liveId)).toString());
                        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                        Activity activity2 = this.activity;
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
                        m mVar = m.vVH;
                        bed bed = this.vKL;
                        int i2 = bed != null ? bed.LNW : 0;
                        bed bed2 = this.vKL;
                        String str2 = (bed2 == null || (bel4 = bed2.wxaShopInfo) == null) ? null : bel4.appId;
                        bed bed3 = this.vKL;
                        boolean z = m.z(i2, str2, (bed3 == null || (bel3 = bed3.wxaShopInfo) == null) ? null : bel3.LOg);
                        awt awt = this.uiv;
                        FinderObject finderObject7 = aqb.LBU;
                        com.tencent.mm.plugin.finder.utils.a.a(activity2, j2, str, awe3, z, awt, null, aqb.LBV, aqb.LBW, null, finderObject7 != null ? finderObject7.sessionBuffer : null, aqb.LBX, null, 9360);
                        AppMethodBeat.o(252465);
                        return;
                    }
                }
                if (!Lp(aqb.LBS)) {
                    Lr(2);
                    Log.w("Finder.FinderLivePostForNearby", "gotoLive type:" + aqb.LBS);
                    AppMethodBeat.o(252465);
                } else if (!Lq(aqb.KTQ)) {
                    Lr(2);
                    Log.w("Finder.FinderLivePostForNearby", "gotoLive type:" + aqb.KTQ);
                    AppMethodBeat.o(252465);
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
                                    u.makeText(this.activity, this.activity.getResources().getString(R.string.cxt), 0).show();
                                    StringBuilder sb2 = new StringBuilder("handleNetSceneFinderLiveVerify() real name Url is empty:");
                                    axq axq4 = this.vKN;
                                    Log.e("Finder.FinderLivePostForNearby", sb2.append(axq4 != null ? axq4.HIt : null).toString());
                                }
                                StringBuilder sb3 = new StringBuilder("gotoLive, is verify:");
                                axq axq5 = this.vKN;
                                if (axq5 == null) {
                                    p.hyc();
                                }
                                Log.i("Finder.FinderLivePostForNearby", sb3.append(axq5.sPX).toString());
                                AppMethodBeat.o(252465);
                                return;
                            }
                        } else {
                            Log.e("Finder.FinderLivePostForNearby", "gotoLive finderLiveVerifyResp is null.");
                            AppMethodBeat.o(252465);
                            return;
                        }
                    }
                    if (!al(this.activity)) {
                        Log.e("Finder.FinderLivePostForNearby", "gotoLive permission is invalid.");
                        AppMethodBeat.o(252465);
                        return;
                    }
                    if (this.vKM != null) {
                        com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                        Activity activity3 = this.activity;
                        m mVar2 = m.vVH;
                        bed bed4 = this.vKL;
                        int i3 = bed4 != null ? bed4.LNW : 0;
                        bed bed5 = this.vKL;
                        String str4 = (bed5 == null || (bel2 = bed5.wxaShopInfo) == null) ? null : bel2.appId;
                        bed bed6 = this.vKL;
                        com.tencent.mm.plugin.finder.utils.a.a(activity3, m.z(i3, str4, (bed6 == null || (bel = bed6.wxaShopInfo) == null) ? null : bel.LOg), this.vKM);
                    }
                    this.vKP = true;
                    Log.w("Finder.FinderLivePostForNearby", "gotoLive 进入直播间.");
                    AppMethodBeat.o(252465);
                }
            } else {
                Log.e("Finder.FinderLivePostForNearby", "gotoLive finderCreateLivePrepareResponse is null.");
                AppMethodBeat.o(252465);
            }
        }
    }

    private static boolean al(Activity activity2) {
        AppMethodBeat.i(252466);
        Log.i("Finder.FinderLivePostForNearby", "checkLivePermission()");
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(activity2, "android.permission.CAMERA", 16, "", "");
        if (!a2) {
            Log.i("Finder.FinderLivePostForNearby", "checkLivePermission() invalid checkCamera:".concat(String.valueOf(a2)));
            AppMethodBeat.o(252466);
            return false;
        }
        boolean a3 = com.tencent.mm.pluginsdk.permission.b.a(activity2, "android.permission.RECORD_AUDIO", 80, "", "");
        if (!a3) {
            Log.i("Finder.FinderLivePostForNearby", "checkLivePermission() invalid checkMicroPhone:".concat(String.valueOf(a3)));
            AppMethodBeat.o(252466);
            return false;
        }
        AppMethodBeat.o(252466);
        return true;
    }

    private final void avR(String str) {
        AppMethodBeat.i(252467);
        Log.i("Finder.FinderLivePostForNearby", "gotoFaceVerify ".concat(String.valueOf(str)));
        Intent intent = new Intent();
        intent.putExtra("LIVE_HELP_TYPE", 1);
        intent.putExtra("FACE_VERIFY_URL", str);
        intent.setClass(this.activity, FinderLivePostHelperUI.class);
        this.activity.startActivityForResult(intent, 10000);
        AppMethodBeat.o(252467);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(252468);
        Log.i("Finder.FinderLivePostForNearby", "onSceneEnd scene:" + (qVar != null ? Integer.valueOf(qVar.getType()) : null) + " result errCode:" + i3 + ",errMsg:" + str + ",errType:" + i2);
        if (qVar instanceof bu) {
            Activity activity2 = this.activity;
            bu buVar = (bu) qVar;
            Log.i("Finder.FinderLivePostForNearby", "handleNetSceneFinderLiveVerify()");
            g.azz().b(5231, this);
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
                        u.makeText(activity2, activity2.getResources().getString(R.string.cs1), 0).show();
                        break;
                    case -200011:
                        Lr(3);
                        break;
                    case -200010:
                        u.makeText(activity2, activity2.getResources().getString(R.string.cqt), 0).show();
                        break;
                    case -200009:
                        u.makeText(activity2, activity2.getResources().getString(R.string.cqx), 0).show();
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
                Log.i("Finder.FinderLivePostForNearby", sb.append(axq.sPX).toString());
            }
            ak akVar = this.vKO;
            if (akVar != null) {
                akVar.end();
                AppMethodBeat.o(252468);
                return;
            }
            AppMethodBeat.o(252468);
            return;
        }
        if (qVar instanceof cd) {
            Activity activity3 = this.activity;
            cd cdVar = (cd) qVar;
            Log.i("Finder.FinderLivePostForNearby", "handleNetSceneFinderPrepareUser()");
            g.azz().b(3761, this);
            if (i2 == 0 && i3 == 0) {
                this.vKL = cdVar.cZc();
                dzC();
            } else {
                u.makeText(activity3, (int) R.string.d5v, 1).show();
            }
            ak akVar2 = this.vKO;
            if (akVar2 != null) {
                akVar2.end();
                AppMethodBeat.o(252468);
                return;
            }
        }
        AppMethodBeat.o(252468);
    }

    private final void Lr(int i2) {
        AppMethodBeat.i(252469);
        Log.i("Finder.FinderLivePostForNearby", "showErrPage type:".concat(String.valueOf(i2)));
        Intent intent = new Intent();
        intent.putExtra("LIVE_HELP_TYPE", i2);
        intent.setClass(this.activity, FinderLivePostHelperUI.class);
        this.activity.startActivityForResult(intent, 10001);
        AppMethodBeat.o(252469);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ f vKS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(f fVar) {
            super(0);
            this.vKS = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(252453);
            f.d(this.vKS);
            x xVar = x.SXb;
            AppMethodBeat.o(252453);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(f fVar) {
        AppMethodBeat.i(252472);
        Log.i("Finder.FinderLivePostForNearby", "handleConfirmPostLive");
        if (fVar.vKL == null) {
            g.azz().a(3761, fVar);
            g.azz().b(new cd(8));
            ak akVar = fVar.vKO;
            if (akVar != null) {
                akVar.begin();
                x xVar = x.SXb;
            }
        }
        if (dzB() && fVar.vKN == null) {
            g.azz().a(5231, fVar);
            g.azz().b(new bu());
            ak akVar2 = fVar.vKO;
            if (akVar2 != null) {
                akVar2.begin();
                x xVar2 = x.SXb;
            }
        }
        if (fVar.vKM == null) {
            z.e eVar = new z.e();
            eVar.SYF = System.currentTimeMillis();
            am amVar = am.tuw;
            new com.tencent.mm.plugin.finder.live.model.cgi.s(am.cXY(), com.tencent.mm.model.z.aUg(), eVar.SYF, new b(eVar, fVar), (byte) 0).aYI();
            ak akVar3 = fVar.vKO;
            if (akVar3 != null) {
                akVar3.begin();
                x xVar3 = x.SXb;
            }
        }
        fVar.dzC();
        AppMethodBeat.o(252472);
    }

    public static final /* synthetic */ void a(f fVar, aqb aqb) {
        AppMethodBeat.i(252473);
        Log.i("Finder.FinderLivePostForNearby", "handleOnCreateLivePrepareResponse()");
        fVar.vKM = aqb;
        fVar.uiv = aqb.live_notice_info;
        fVar.dzC();
        AppMethodBeat.o(252473);
    }
}
