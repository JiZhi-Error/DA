package com.tencent.mm.msgsubscription.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.b.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tavkit.component.TAVExporter;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;

@com.tencent.mm.ui.base.a(7)
@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001)\b\u0007\u0018\u0000 H2\u00020\u0001:\u0001HB\u0005¢\u0006\u0002\u0010\u0002J\b\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u000205H\u0002J\b\u00107\u001a\u000205H\u0002J\u0012\u00108\u001a\u0002052\b\b\u0002\u00109\u001a\u00020!H\u0002J.\u0010:\u001a\u0002052\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\n2\b\b\u0002\u00109\u001a\u00020!2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>H\u0002J\b\u0010?\u001a\u00020\u0004H\u0014J\b\u0010@\u001a\u000205H\u0016J\u0012\u0010A\u001a\u0002052\b\u0010B\u001a\u0004\u0018\u00010>H\u0016J\b\u0010C\u001a\u000205H\u0014J\b\u0010D\u001a\u000205H\u0014J\u0012\u0010E\u001a\u0002052\b\b\u0002\u00109\u001a\u00020!H\u0002J\b\u0010F\u001a\u000205H\u0002J\b\u0010G\u001a\u000205H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u000f\u0010\fR\u001b\u0010\u0011\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0012\u0010\fR\u000e\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0016\u0010\fR\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010\b\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b'\u0010\b\u001a\u0004\b&\u0010\u0006R\u0010\u0010(\u001a\u00020)X\u0004¢\u0006\u0004\n\u0002\u0010*R\u001b\u0010+\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b-\u0010\b\u001a\u0004\b,\u0010\fR+\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\n0/j\b\u0012\u0004\u0012\u00020\n`08BX\u0002¢\u0006\f\n\u0004\b3\u0010\b\u001a\u0004\b1\u00102¨\u0006I"}, hxF = {"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestProxyUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", NativeProtocol.WEB_DIALOG_ACTION, "", "getAction", "()I", "action$delegate", "Lkotlin/Lazy;", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "bizAppId$delegate", "bizUsername", "getBizUsername", "bizUsername$delegate", "content", "getContent", "content$delegate", "currentAction", IssueStorage.COLUMN_EXT_INFO, "getExtInfo", "extInfo$delegate", "mDialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "mDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mRequestTask", "Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestTask;", "needResult", "", "getNeedResult", "()Z", "needResult$delegate", "scene", "getScene", "scene$delegate", "subscribeMsgRequestCallback", "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestProxyUI$subscribeMsgRequestCallback$1", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestProxyUI$subscribeMsgRequestCallback$1;", "subscribeUrl", "getSubscribeUrl", "subscribeUrl$delegate", "templateIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTemplateIds", "()Ljava/util/ArrayList;", "templateIds$delegate", "configNavigationBar", "", "configStatusBar", "doRequest", "finishSelf", "delayed", "finishUIWithResult", "errCode", "errMsg", "data", "Landroid/os/Bundle;", "getLayoutId", "onBackPressed", "onCreate", "savedInstanceState", "onDestroy", "onResume", "onUserCancel", "setFullScreen", "showProgressDialog", "Companion", "plugin-comm_release"})
@com.tencent.mm.kernel.i
public final class SubscribeMsgRequestProxyUI extends MMActivity {
    public static final a jCX = new a((byte) 0);
    private HashMap _$_findViewCache;
    private q gxX;
    private com.tencent.mm.plugin.appbrand.widget.dialog.k jCJ;
    private com.tencent.mm.plugin.appbrand.widget.dialog.e jCK;
    private a.b jCL;
    private int jCM;
    private final kotlin.f jCN = kotlin.g.ah(new i(this));
    private final kotlin.f jCO = kotlin.g.ah(new d(this));
    private final kotlin.f jCP = kotlin.g.ah(new c(this));
    private final kotlin.f jCQ = kotlin.g.ah(new b(this));
    private final kotlin.f jCR = kotlin.g.ah(new l(this));
    private final kotlin.f jCS = kotlin.g.ah(new k(this));
    private final kotlin.f jCT = kotlin.g.ah(new e(this));
    private final kotlin.f jCU = kotlin.g.ah(new h(this));
    private final kotlin.f jCV = kotlin.g.ah(new f(this));
    private final j jCW = new j(this);

    static {
        AppMethodBeat.i(149802);
        AppMethodBeat.o(149802);
    }

    private final String bjd() {
        AppMethodBeat.i(149803);
        String str = (String) this.jCO.getValue();
        AppMethodBeat.o(149803);
        return str;
    }

    private final String bje() {
        AppMethodBeat.i(223430);
        String str = (String) this.jCP.getValue();
        AppMethodBeat.o(223430);
        return str;
    }

    private final boolean bjf() {
        AppMethodBeat.i(223431);
        boolean booleanValue = ((Boolean) this.jCU.getValue()).booleanValue();
        AppMethodBeat.o(223431);
        return booleanValue;
    }

    private final String bjg() {
        AppMethodBeat.i(223432);
        String str = (String) this.jCV.getValue();
        AppMethodBeat.o(223432);
        return str;
    }

    private final int getAction() {
        AppMethodBeat.i(149804);
        int intValue = ((Number) this.jCQ.getValue()).intValue();
        AppMethodBeat.o(149804);
        return intValue;
    }

    private final int getScene() {
        AppMethodBeat.i(223429);
        int intValue = ((Number) this.jCN.getValue()).intValue();
        AppMethodBeat.o(223429);
        return intValue;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(223437);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(223437);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(223436);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(223436);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SubscribeMsgRequestProxyUI() {
        AppMethodBeat.i(149810);
        AppMethodBeat.o(149810);
    }

    public static final /* synthetic */ void a(SubscribeMsgRequestProxyUI subscribeMsgRequestProxyUI) {
        AppMethodBeat.i(149815);
        super.finish();
        AppMethodBeat.o(149815);
    }

    public static final /* synthetic */ String c(SubscribeMsgRequestProxyUI subscribeMsgRequestProxyUI) {
        AppMethodBeat.i(149811);
        String bjd = subscribeMsgRequestProxyUI.bjd();
        AppMethodBeat.o(149811);
        return bjd;
    }

    public static final /* synthetic */ int e(SubscribeMsgRequestProxyUI subscribeMsgRequestProxyUI) {
        AppMethodBeat.i(149813);
        int action = subscribeMsgRequestProxyUI.getAction();
        AppMethodBeat.o(149813);
        return action;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestProxyUI$Companion;", "", "()V", "TAG", "", "plugin-comm_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0017"}, hxF = {"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestProxyUI$subscribeMsgRequestCallback$1", "Lcom/tencent/mm/msgsubscription/model/biz_service/BrandSubscribeMsgRequestController$SubscribeMsgRequestCallback;", "dismissProgressDialog", "", "onCancel", "onDismissDialog", "onError", NativeProtocol.WEB_DIALOG_ACTION, "", "errCode", "errMsg", "", "onGetSubscribeListSuccess", "showDialog", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onShowDialog", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "containerLayout", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "onSubscribeMsgSuccess", "plugin-comm_release"})
    public static final class j implements a.AbstractC0465a {
        final /* synthetic */ SubscribeMsgRequestProxyUI jCY;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        j(SubscribeMsgRequestProxyUI subscribeMsgRequestProxyUI) {
            this.jCY = subscribeMsgRequestProxyUI;
        }

        @Override // com.tencent.mm.msgsubscription.b.a.a.AbstractC0465a
        public final void a(com.tencent.mm.plugin.appbrand.widget.dialog.k kVar, com.tencent.mm.plugin.appbrand.widget.dialog.e eVar) {
            AppMethodBeat.i(223422);
            Log.i("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo subscribeMsgRequest onShowDialog");
            this.jCY.jCJ = kVar;
            this.jCY.jCK = eVar;
            AppMethodBeat.o(223422);
        }

        @Override // com.tencent.mm.msgsubscription.b.a.a.AbstractC0465a
        public final void biV() {
            AppMethodBeat.i(223423);
            Log.i("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo subscribeMsgRequest onDismissDialog");
            this.jCY.jCJ = null;
            AppMethodBeat.o(223423);
        }

        @Override // com.tencent.mm.msgsubscription.b.a.a.AbstractC0465a
        public final void biW() {
            AppMethodBeat.i(223424);
            q qVar = this.jCY.gxX;
            if (qVar != null) {
                qVar.dismiss();
                AppMethodBeat.o(223424);
                return;
            }
            AppMethodBeat.o(223424);
        }

        @Override // com.tencent.mm.msgsubscription.b.a.a.AbstractC0465a
        public final void a(boolean z, SubscribeMsgRequestResult subscribeMsgRequestResult) {
            AppMethodBeat.i(223425);
            p.h(subscribeMsgRequestResult, "result");
            Log.i("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo onGetSubscribeListSuccess bizUsername: %s, %d, showDialog: %b", SubscribeMsgRequestProxyUI.c(this.jCY), Integer.valueOf(subscribeMsgRequestResult.jyk.size()), Boolean.valueOf(z));
            q qVar = this.jCY.gxX;
            if (qVar != null) {
                qVar.dismiss();
            }
            this.jCY.jCM = com.tencent.mm.msgsubscription.b.a.a.un(this.jCY.jCM);
            if (SubscribeMsgRequestProxyUI.e(this.jCY) == 1 || !z) {
                SubscribeMsgRequestProxyUI.a(this.jCY, 0, "", false, null, 12);
            }
            AppMethodBeat.o(223425);
        }

        @Override // com.tencent.mm.msgsubscription.b.a.a.AbstractC0465a
        public final void b(SubscribeMsgRequestResult subscribeMsgRequestResult) {
            AppMethodBeat.i(223426);
            p.h(subscribeMsgRequestResult, "result");
            Log.i("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo onSubscribeMsgSuccess bizUsername: %s, %d", SubscribeMsgRequestProxyUI.c(this.jCY), Integer.valueOf(subscribeMsgRequestResult.jyk.size()));
            this.jCY.jCM = com.tencent.mm.msgsubscription.b.a.a.un(this.jCY.jCM);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("key_result_data", subscribeMsgRequestResult.jyk);
            bundle.putString("key_result_ext_data", subscribeMsgRequestResult.extData);
            SubscribeMsgRequestProxyUI.a(this.jCY, 0, "", false, bundle, 4);
            AppMethodBeat.o(223426);
        }

        @Override // com.tencent.mm.msgsubscription.b.a.a.AbstractC0465a
        public final void i(int i2, int i3, String str) {
            AppMethodBeat.i(223427);
            p.h(str, "errMsg");
            Log.e("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo subscribeMsgRequest onError bizUsername: %s, action: %d, errCode: %d, errMsg: %s", SubscribeMsgRequestProxyUI.c(this.jCY), Integer.valueOf(i2), Integer.valueOf(i3), str);
            q qVar = this.jCY.gxX;
            if (qVar != null) {
                qVar.dismiss();
            }
            SubscribeMsgRequestProxyUI.a(this.jCY, i3, str, true, null, 8);
            AppMethodBeat.o(223427);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return -1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        a.b bVar;
        AppMethodBeat.i(149805);
        super.onCreate(bundle);
        Window window = getWindow();
        p.g(window, "window");
        View decorView = window.getDecorView();
        p.g(decorView, "window.decorView");
        decorView.setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        this.gxX = com.tencent.mm.ui.base.h.a((Context) this, getResources().getString(R.string.ek_), false, (DialogInterface.OnCancelListener) null);
        if (getScene() == 1) {
            AppCompatActivity context = getContext();
            p.g(context, "context");
            bVar = new a.b(context, getAction(), bjd(), bje(), (String) this.jCS.getValue(), (String) this.jCT.getValue(), bjg(), this.jCW);
        } else if (getScene() == 2) {
            AppCompatActivity context2 = getContext();
            p.g(context2, "context");
            bVar = new a.b(context2, getAction(), bje(), (ArrayList) this.jCR.getValue(), bjg(), this.jCW);
        } else {
            Log.i("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo requestSubscribeMessage scene invalid: " + getScene());
            bVar = null;
        }
        this.jCL = bVar;
        a.b bVar2 = this.jCL;
        if (bVar2 != null) {
            bVar2.gwE = getScene();
            if (com.tencent.mm.msgsubscription.b.a.a.uo(getAction())) {
                com.tencent.mm.msgsubscription.b.a.a aVar = com.tencent.mm.msgsubscription.b.a.a.jzQ;
                com.tencent.mm.msgsubscription.b.a.a.a(bVar2);
            } else if (com.tencent.mm.msgsubscription.b.a.a.up(getAction())) {
                com.tencent.mm.msgsubscription.b.a.a aVar2 = com.tencent.mm.msgsubscription.b.a.a.jzQ;
                com.tencent.mm.msgsubscription.b.a.a.b(bVar2);
            }
        }
        this.jCM = getAction();
        AppMethodBeat.o(149805);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(149806);
        super.onResume();
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            p.g(window, "window");
            window.setStatusBarColor(getResources().getColor(R.color.ac_));
        }
        setNavigationbarColor(getResources().getColor(R.color.f3044b));
        AppMethodBeat.o(149806);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class g implements Runnable {
        final /* synthetic */ SubscribeMsgRequestProxyUI jCY;

        g(SubscribeMsgRequestProxyUI subscribeMsgRequestProxyUI) {
            this.jCY = subscribeMsgRequestProxyUI;
        }

        public final void run() {
            AppMethodBeat.i(149800);
            SubscribeMsgRequestProxyUI.a(this.jCY);
            AppMethodBeat.o(149800);
        }
    }

    static /* synthetic */ void a(SubscribeMsgRequestProxyUI subscribeMsgRequestProxyUI, int i2, String str, boolean z, Bundle bundle, int i3) {
        AppMethodBeat.i(223433);
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            bundle = null;
        }
        Log.v("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo finishUIWithResult needResult: %b", Boolean.valueOf(subscribeMsgRequestProxyUI.bjf()));
        if (subscribeMsgRequestProxyUI.bjf()) {
            Intent intent = new Intent();
            intent.putExtra("key_result_err_code", i2);
            intent.putExtra("key_result_err_msg", str);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            subscribeMsgRequestProxyUI.setResult(-1, intent);
        }
        q qVar = subscribeMsgRequestProxyUI.gxX;
        if (qVar != null) {
            qVar.dismiss();
        }
        if (z) {
            subscribeMsgRequestProxyUI.getContentView().postDelayed(new g(subscribeMsgRequestProxyUI), 300);
            AppMethodBeat.o(223433);
            return;
        }
        super.finish();
        AppMethodBeat.o(223433);
    }

    private final void gb(boolean z) {
        AppMethodBeat.i(223434);
        a(this, 10005, "user cancel", false, null, 8);
        AppMethodBeat.o(223434);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(149809);
        Log.v("MicroMsg.SubscribeMsgRequestProxyUI", "alvinluo onBackPressed currentAction: %d", Integer.valueOf(this.jCM));
        if (com.tencent.mm.msgsubscription.b.a.a.uo(this.jCM)) {
            q qVar = this.gxX;
            if (qVar != null) {
                qVar.dismiss();
            }
            gb(false);
            AppMethodBeat.o(149809);
        } else if (com.tencent.mm.msgsubscription.b.a.a.up(this.jCM)) {
            com.tencent.mm.plugin.appbrand.widget.dialog.e eVar = this.jCK;
            if (eVar != null) {
                eVar.onBackPressed();
                AppMethodBeat.o(149809);
                return;
            }
            AppMethodBeat.o(149809);
        } else {
            gb(false);
            AppMethodBeat.o(149809);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(223435);
        super.onDestroy();
        q qVar = this.gxX;
        if (qVar != null) {
            qVar.dismiss();
        }
        a.b bVar = this.jCL;
        if (bVar != null) {
            Log.i("MicroMsg.BrandSubscribeMsgRequestController", "alvinluo release");
            com.tencent.mm.ui.widget.a.d dVar = bVar.jzT;
            if (dVar != null) {
                dVar.dismiss();
            }
            b bVar2 = bVar.jzU;
            if (bVar2 != null) {
                bVar2.dismiss();
                AppMethodBeat.o(223435);
                return;
            }
            AppMethodBeat.o(223435);
            return;
        }
        AppMethodBeat.o(223435);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ SubscribeMsgRequestProxyUI jCY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(SubscribeMsgRequestProxyUI subscribeMsgRequestProxyUI) {
            super(0);
            this.jCY = subscribeMsgRequestProxyUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(223421);
            Integer valueOf = Integer.valueOf(this.jCY.getIntent().getIntExtra("key_scene", -1));
            AppMethodBeat.o(223421);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ SubscribeMsgRequestProxyUI jCY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(SubscribeMsgRequestProxyUI subscribeMsgRequestProxyUI) {
            super(0);
            this.jCY = subscribeMsgRequestProxyUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(149791);
            String stringExtra = this.jCY.getIntent().getStringExtra("key_biz_username");
            if (stringExtra == null) {
                stringExtra = "";
            }
            AppMethodBeat.o(149791);
            return stringExtra;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ SubscribeMsgRequestProxyUI jCY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(SubscribeMsgRequestProxyUI subscribeMsgRequestProxyUI) {
            super(0);
            this.jCY = subscribeMsgRequestProxyUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(223418);
            String stringExtra = this.jCY.getIntent().getStringExtra("key_biz_app_id");
            if (stringExtra == null) {
                stringExtra = "";
            }
            AppMethodBeat.o(223418);
            return stringExtra;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ SubscribeMsgRequestProxyUI jCY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(SubscribeMsgRequestProxyUI subscribeMsgRequestProxyUI) {
            super(0);
            this.jCY = subscribeMsgRequestProxyUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(149790);
            Integer valueOf = Integer.valueOf(this.jCY.getIntent().getIntExtra("key_action", -1));
            AppMethodBeat.o(149790);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Ljava/util/ArrayList;", "", "kotlin.jvm.PlatformType", "invoke"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.a<ArrayList<String>> {
        final /* synthetic */ SubscribeMsgRequestProxyUI jCY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(SubscribeMsgRequestProxyUI subscribeMsgRequestProxyUI) {
            super(0);
            this.jCY = subscribeMsgRequestProxyUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ArrayList<String> invoke() {
            AppMethodBeat.i(223428);
            ArrayList<String> stringArrayListExtra = this.jCY.getIntent().getStringArrayListExtra("key_template_id_list");
            AppMethodBeat.o(223428);
            return stringArrayListExtra;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ SubscribeMsgRequestProxyUI jCY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(SubscribeMsgRequestProxyUI subscribeMsgRequestProxyUI) {
            super(0);
            this.jCY = subscribeMsgRequestProxyUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(149801);
            String stringExtra = this.jCY.getIntent().getStringExtra("key_subscribe_url");
            if (stringExtra == null) {
                stringExtra = "";
            }
            AppMethodBeat.o(149801);
            return stringExtra;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ SubscribeMsgRequestProxyUI jCY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(SubscribeMsgRequestProxyUI subscribeMsgRequestProxyUI) {
            super(0);
            this.jCY = subscribeMsgRequestProxyUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(149792);
            String stringExtra = this.jCY.getIntent().getStringExtra("key_extra_content");
            if (stringExtra == null) {
                stringExtra = "";
            }
            AppMethodBeat.o(149792);
            return stringExtra;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ SubscribeMsgRequestProxyUI jCY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(SubscribeMsgRequestProxyUI subscribeMsgRequestProxyUI) {
            super(0);
            this.jCY = subscribeMsgRequestProxyUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(223420);
            Boolean valueOf = Boolean.valueOf(this.jCY.getIntent().getBooleanExtra("key_need_result", false));
            AppMethodBeat.o(223420);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ SubscribeMsgRequestProxyUI jCY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(SubscribeMsgRequestProxyUI subscribeMsgRequestProxyUI) {
            super(0);
            this.jCY = subscribeMsgRequestProxyUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(223419);
            String stringExtra = this.jCY.getIntent().getStringExtra("key_extra_info");
            if (stringExtra == null) {
                stringExtra = "";
            }
            AppMethodBeat.o(223419);
            return stringExtra;
        }
    }
}
