package com.tencent.mm.plugin.webview.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.plugin.appbrand.widget.dialog.h;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.webview.model.ag;
import com.tencent.mm.protocal.protobuf.afa;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.cua;
import com.tencent.mm.protocal.protobuf.cub;
import com.tencent.mm.protocal.protobuf.cue;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u000223B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0007J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\bH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0004H\u0007J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\u00142\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\"H\u0007J*\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010)H\u0007J(\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0012H\u0007J\u0016\u0010/\u001a\u00020\u00192\f\u00100\u001a\b\u0012\u0004\u0012\u0002010\"H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u000e\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr;", "", "()V", "START_CREATE_AVATAR_UI_REQUEST_CODE", "", "getSTART_CREATE_AVATAR_UI_REQUEST_CODE", "()I", "TAG", "", "getTAG", "()Ljava/lang/String;", "USER_INFO", "getUSER_INFO", "lastWebviewHash", "oauthQueue", "Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "webviewDelegate", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$WebviewUIDelegate;", "bytesListToAvatarList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/OauthAvatarInfo;", "bytesList", "", "destroy", "", "goBackWebview", "goRedirectWebview", "redirectUrl", "keyBack", "", "hashCode", "oauthAvatarListToBytesList", "avatarList", "Ljava/util/LinkedList;", "onActivityResult", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "showDialogQueue", UserDataStore.CITY, "Landroid/content/Context;", "resp", "Landroid/os/Bundle;", "sortScopeList", "list", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "OauthDialog", "OauthQueue", "plugin-webview_release"})
public final class ah {
    private static final String IYu = IYu;
    private static b IYv = null;
    private static int IYw = 0;
    private static WeakReference<ag.c> IYx = null;
    public static final ah IYy = new ah();
    private static final String TAG = TAG;
    private static final int lHP = 4;

    static {
        AppMethodBeat.i(182642);
        AppMethodBeat.o(182642);
    }

    private ah() {
    }

    public static String getTAG() {
        return TAG;
    }

    public static int gcE() {
        return lHP;
    }

    public static String gcF() {
        return IYu;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020,H\u0002J\u0006\u0010-\u001a\u00020*J\u000e\u0010.\u001a\u00020*2\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010/\u001a\u00020,J(\u00100\u001a\u00020*2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u00132\b\u00105\u001a\u0004\u0018\u000106J\u000e\u00107\u001a\u00020*2\u0006\u00108\u001a\u00020\u0007J\b\u00109\u001a\u00020*H\u0002J\u0010\u0010:\u001a\u00020*2\u0006\u0010;\u001a\u00020\u0013H\u0002J\b\u0010<\u001a\u00020*H\u0002J\u0006\u0010=\u001a\u00020*R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010&\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0013@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0015\"\u0004\b(\u0010\u0017¨\u0006>"}, hxF = {"Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allowScope", "Ljava/util/ArrayList;", "", "container", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "getContext", "()Landroid/content/Context;", "curDialog", "Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;", "getCurDialog", "()Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;", "setCurDialog", "(Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;)V", "curIndex", "", "getCurIndex", "()I", "setCurIndex", "(I)V", "resp", "Landroid/os/Bundle;", "getResp", "()Landroid/os/Bundle;", "setResp", "(Landroid/os/Bundle;)V", "scopeList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "getScopeList", "()Ljava/util/LinkedList;", "setScopeList", "(Ljava/util/LinkedList;)V", "value", "selectAvatarId", "getSelectAvatarId", "setSelectAvatarId", "accept", "", "checkEnd", "", "destroy", "enqueOauth", "isQueueEmpty", "onActivityResult", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "recordAllowScope", "scope", "reject", "sendReq", "allow", "sendResult", "showNextOauth", "plugin-webview_release"})
    public static final class b {
        LinkedList<drb> IXZ = new LinkedList<>();
        private e IYF = new e(this.context);
        Bundle IYN;
        private a IYO;
        final ArrayList<String> IYP = new ArrayList<>();
        private int IYQ;
        final Context context;
        private int sTB;

        public b(Context context2) {
            p.h(context2, "context");
            AppMethodBeat.i(182634);
            this.context = context2;
            Context context3 = this.context;
            if (context3 == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(182634);
                throw tVar;
            }
            Window window = ((Activity) context3).getWindow();
            p.g(window, "(context as Activity).window");
            View decorView = window.getDecorView();
            if (decorView != null) {
                ViewGroup viewGroup = (ViewGroup) (!(decorView instanceof ViewGroup) ? null : decorView);
                if (viewGroup != null) {
                    viewGroup.addView(this.IYF);
                    AppMethodBeat.o(182634);
                    return;
                }
                AppMethodBeat.o(182634);
                return;
            }
            AppMethodBeat.o(182634);
        }

        public final void afZ(int i2) {
            AppMethodBeat.i(182627);
            this.IYQ = i2;
            ah ahVar = ah.IYy;
            Log.v(ah.getTAG(), "[QauthQueue] selectAvatartId = ".concat(String.valueOf(i2)));
            AppMethodBeat.o(182627);
        }

        public final void gcI() {
            h hVar;
            e eVar;
            h hVar2 = null;
            AppMethodBeat.i(182628);
            if (this.IYO != null) {
                a aVar = this.IYO;
                if (aVar != null) {
                    hVar = aVar.IYA;
                } else {
                    hVar = null;
                }
                if (!(hVar == null || (eVar = this.IYF) == null)) {
                    a aVar2 = this.IYO;
                    if (aVar2 != null) {
                        hVar2 = aVar2.IYA;
                    }
                    eVar.c(hVar2);
                }
            }
            if (gcJ()) {
                eKh();
                AppMethodBeat.o(182628);
                return;
            }
            Context context2 = this.context;
            e eVar2 = this.IYF;
            if (eVar2 == null) {
                p.hyc();
            }
            a aVar3 = new a(context2, eVar2);
            aVar3.IYv = this;
            Bundle bundle = this.IYN;
            if (bundle == null) {
                p.hyc();
            }
            drb drb = this.IXZ.get(this.sTB);
            p.g(drb, "scopeList[curIndex]");
            aVar3.a(bundle, drb);
            this.IYO = aVar3;
            this.sTB++;
            AppMethodBeat.o(182628);
        }

        public final void destroy() {
            AppMethodBeat.i(182629);
            if (this.IYF != null) {
                e eVar = this.IYF;
                if (eVar != null) {
                    eVar.cbm();
                }
                this.IYF = null;
                this.IYO = null;
            }
            AppMethodBeat.o(182629);
        }

        private final boolean gcJ() {
            AppMethodBeat.i(182630);
            if (Util.isNullOrNil(this.IXZ)) {
                ah ahVar = ah.IYy;
                Log.v(ah.getTAG(), "[OauthQueue.checkEnd] scopeList null");
                AppMethodBeat.o(182630);
                return true;
            } else if (this.sTB >= this.IXZ.size()) {
                ah ahVar2 = ah.IYy;
                Log.v(ah.getTAG(), "[OauthQueue.checkEnd] curIndex end");
                AppMethodBeat.o(182630);
                return true;
            } else {
                AppMethodBeat.o(182630);
                return false;
            }
        }

        private final void eKh() {
            AppMethodBeat.i(182631);
            Bundle bundle = this.IYN;
            String aYE = ag.b.aYE(bundle != null ? bundle.getString("oauth_url", "") : null);
            if (Util.isNullOrNil(this.IYP)) {
                ah ahVar = ah.IYy;
                Log.i(ah.getTAG(), "[OauthQueue.sendResult] allowScope empty");
                com.tencent.mm.plugin.webview.k.b bVar = com.tencent.mm.plugin.webview.k.b.INSTANCE;
                if (aYE == null) {
                    aYE = "";
                }
                bVar.a(aYE, ag.b.startTime, 0, 1, 0, 1, 0);
                com.tencent.mm.plugin.webview.k.b.INSTANCE.aO(2, (int) (System.currentTimeMillis() - ag.b.IYc), 0);
                reject();
                AppMethodBeat.o(182631);
                return;
            }
            c.a(this.context, com.tencent.mm.model.gdpr.a.OPENSDK, aYE, new C1968b(this, aYE));
            AppMethodBeat.o(182631);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "ret", "", "onPermissionReturn"})
        /* renamed from: com.tencent.mm.plugin.webview.model.ah$b$b  reason: collision with other inner class name */
        public static final class C1968b implements com.tencent.mm.model.gdpr.b {
            final /* synthetic */ b IYR;
            final /* synthetic */ String IYU;

            C1968b(b bVar, String str) {
                this.IYR = bVar;
                this.IYU = str;
            }

            @Override // com.tencent.mm.model.gdpr.b
            public final void sx(final int i2) {
                AppMethodBeat.i(182626);
                com.tencent.mm.ch.a.y(new Runnable(this) {
                    /* class com.tencent.mm.plugin.webview.model.ah.b.C1968b.AnonymousClass1 */
                    final /* synthetic */ C1968b IYV;

                    {
                        this.IYV = r1;
                    }

                    public final void run() {
                        String str;
                        AppMethodBeat.i(182625);
                        if (i2 == 1) {
                            ah ahVar = ah.IYy;
                            Log.i(ah.getTAG(), "[OauthQueue.sendResult] MPGdprPolicyUtil.checkPolicy DENY");
                            com.tencent.mm.plugin.webview.k.b bVar = com.tencent.mm.plugin.webview.k.b.INSTANCE;
                            String str2 = this.IYV.IYU;
                            if (str2 == null) {
                                str2 = "";
                            }
                            bVar.a(str2, ag.b.startTime, 0, 1, 0, 1, 0);
                            ah ahVar2 = ah.IYy;
                            ah.gcG();
                        } else {
                            ah ahVar3 = ah.IYy;
                            Log.i(ah.getTAG(), "[OauthQueue.sendResult] MPGdprPolicyUtil.checkPolicy PROCEED");
                            com.tencent.mm.plugin.webview.k.b bVar2 = com.tencent.mm.plugin.webview.k.b.INSTANCE;
                            String str3 = this.IYV.IYU;
                            if (str3 == null) {
                                str3 = "";
                            }
                            bVar2.a(str3, ag.b.startTime, 1, 1, 0, 1, 0);
                            b bVar3 = this.IYV.IYR;
                            Bundle bundle = bVar3.IYN;
                            boolean z = bundle != null ? bundle.getBoolean("is_call_server_when_confirm") : false;
                            ah ahVar4 = ah.IYy;
                            Log.i(ah.getTAG(), "[OauthQueue.accept] isCallServerWhenConfirm = ".concat(String.valueOf(z)));
                            if (z) {
                                bVar3.aga(1);
                            } else {
                                Bundle bundle2 = bVar3.IYN;
                                if (bundle2 == null || (str = bundle2.getString("redirect_url")) == null) {
                                    str = "";
                                }
                                p.g(str, "resp?.getString(Constant…ESULT_REDIRECT_URL) ?: \"\"");
                                ah ahVar5 = ah.IYy;
                                ah.aYF(str);
                            }
                        }
                        com.tencent.mm.plugin.webview.k.b.INSTANCE.aO(2, (int) (System.currentTimeMillis() - ag.b.IYc), 0);
                        AppMethodBeat.o(182625);
                    }
                });
                AppMethodBeat.o(182626);
            }
        }

        private final void reject() {
            ag.c cVar;
            AppMethodBeat.i(182632);
            ah ahVar = ah.IYy;
            Log.i(ah.getTAG(), "[OauthQueue.reject] reject");
            aga(2);
            ah ahVar2 = ah.IYy;
            WeakReference weakReference = ah.IYx;
            if (weakReference == null || (cVar = (ag.c) weakReference.get()) == null) {
                AppMethodBeat.o(182632);
                return;
            }
            cVar.goBack();
            AppMethodBeat.o(182632);
        }

        /* access modifiers changed from: package-private */
        public final void aga(int i2) {
            String str;
            AppMethodBeat.i(182633);
            cua cua = new cua();
            Bundle bundle = this.IYN;
            if (bundle == null || (str = bundle.getString("oauth_url", "")) == null) {
                str = "";
            }
            cua.Mzp = str;
            cua.Mzq = i2;
            cua.Mzr.addAll(this.IYP);
            cua.Lqj = this.IYQ;
            ah ahVar = ah.IYy;
            Log.v(ah.getTAG(), "[OauthQueue.sendReq] scope = " + cua.Mzr + ", avatarId = " + this.IYQ);
            d.a aVar = new d.a();
            aVar.c(cua);
            aVar.d(new cub());
            aVar.MB("/cgi-bin/mmbiz-bin/oauth_authorize_confirm");
            aVar.sG(1373);
            aVar.sI(0);
            aVar.sJ(0);
            IPCRunCgi.a(aVar.aXF(), new a(this));
            AppMethodBeat.o(182633);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
        public static final class a implements IPCRunCgi.a {
            final /* synthetic */ b IYR;

            a(b bVar) {
                this.IYR = bVar;
            }

            @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
            public final void a(final int i2, final int i3, final String str, final d dVar) {
                AppMethodBeat.i(182624);
                MMHandlerThread.postToMainThread(new Runnable(this) {
                    /* class com.tencent.mm.plugin.webview.model.ah.b.a.AnonymousClass1 */
                    final /* synthetic */ a IYS;

                    {
                        this.IYS = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(182623);
                        if (i2 == 0 && i3 == 0) {
                            d dVar = dVar;
                            p.g(dVar, "rr");
                            com.tencent.mm.bw.a aYK = dVar.aYK();
                            if (aYK == null) {
                                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.OauthAuthorizeConfirmResp");
                                AppMethodBeat.o(182623);
                                throw tVar;
                            }
                            cub cub = (cub) aYK;
                            if (!Util.isNullOrNil(cub.KJw)) {
                                ah ahVar = ah.IYy;
                                String str = cub.KJw;
                                p.g(str, "rsp.redirect_url");
                                ah.aYF(str);
                                AppMethodBeat.o(182623);
                                return;
                            }
                            ah.destroy();
                            AppMethodBeat.o(182623);
                            return;
                        }
                        com.tencent.mm.ui.base.h.d(this.IYS.IYR.context, str, MMApplicationContext.getContext().getString(R.string.j1i), AnonymousClass1.IYT);
                        AppMethodBeat.o(182623);
                    }
                });
                AppMethodBeat.o(182624);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J6\u00109\u001a\u00020:2\u0006\u00103\u001a\u0002042\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020%0<2\u0006\u0010=\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010>\u001a\u00020:2\u0006\u0010\u0002\u001a\u00020\u0003J \u0010?\u001a\u00020:2\u0006\u00103\u001a\u0002042\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010@\u001a\u00020\u001fH\u0002J,\u0010A\u001a\b\u0012\u0004\u0012\u00020%0<2\u0006\u00103\u001a\u00020\b2\u0006\u0010B\u001a\u00020\u000e2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020D0$H\u0002J\u000e\u0010E\u001a\u00020:2\u0006\u0010F\u001a\u00020GJ\u0016\u0010H\u001a\u00020:2\u0006\u0010I\u001a\u00020J2\u0006\u00103\u001a\u000204R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R(\u0010*\u001a\u0004\u0018\u00010)2\b\u0010(\u001a\u0004\u0018\u00010)@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0011\u0010/\u001a\u000200¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006K"}, hxF = {"Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog;", "", "context", "Landroid/content/Context;", "container", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;)V", "appid", "", "getAppid", "()Ljava/lang/String;", "setAppid", "(Ljava/lang/String;)V", "avatarLimit", "", "getAvatarLimit", "()I", "setAvatarLimit", "(I)V", "getContainer", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandDialogContainerLayout;", "getContext", "()Landroid/content/Context;", "currentCheckedAvatarId", "getCurrentCheckedAvatarId", "setCurrentCheckedAvatarId", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "getDialog", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "isBanModifyAvatar", "", "()Z", "setBanModifyAvatar", "(Z)V", "mCurrentItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "getMCurrentItems", "()Ljava/util/ArrayList;", "value", "Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "oauthQueue", "getOauthQueue", "()Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;", "setOauthQueue", "(Lcom/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthQueue;)V", "recvListener", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "getRecvListener", "()Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "scope", "Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "getScope", "()Lcom/tencent/mm/protocal/protobuf/ScopeInfo;", "setScope", "(Lcom/tencent/mm/protocal/protobuf/ScopeInfo;)V", "applyDialogItem", "", "items", "", "isBanAvatar", "destroy", "enableAddNewAvatarListener", "enable", "genDialogItem", "defaultId", "avatarList", "Lcom/tencent/mm/protocal/protobuf/OauthAvatarInfo;", "onActivityResult", "data", "Landroid/content/Intent;", "showDialog", "resp", "Landroid/os/Bundle;", "plugin-webview_release"})
    public static final class a {
        final h IYA = new h(this.context, this.IYz);
        private drb IYB;
        boolean IYC;
        int IYD;
        int IYE;
        final com.tencent.mm.plugin.appbrand.widget.dialog.e IYF;
        b IYv;
        private final h.b IYz = new b(this);
        final Context context;
        String dNI = "";
        final ArrayList<i.a> lHN = new ArrayList<>();

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "onCallback"})
        public static final class f<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
            final /* synthetic */ a IYG;
            final /* synthetic */ drb IYH;

            f(a aVar, drb drb) {
                this.IYG = aVar;
                this.IYH = drb;
            }

            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(Object obj) {
                AppMethodBeat.i(182615);
                Bundle bundle = (Bundle) obj;
                h hVar = this.IYG.IYA;
                ArrayList arrayList = new ArrayList();
                arrayList.add(new i.a(bundle.getString("userName", ""), this.IYG.context.getResources().getString(R.string.a0j), this.IYH.KWK, com.tencent.mm.aj.e.Mq(bundle.getString("userIcon", "")), (byte) 0));
                hVar.setSelectListItem(arrayList);
                this.IYG.IYF.b(this.IYG.IYA);
                AppMethodBeat.o(182615);
            }
        }

        public a(Context context2, com.tencent.mm.plugin.appbrand.widget.dialog.e eVar) {
            p.h(context2, "context");
            p.h(eVar, "container");
            AppMethodBeat.i(182619);
            this.context = context2;
            this.IYF = eVar;
            AppMethodBeat.o(182619);
        }

        public static final /* synthetic */ void a(a aVar, h hVar, List list, boolean z, int i2) {
            AppMethodBeat.i(182620);
            aVar.a(hVar, list, z, i2);
            AppMethodBeat.o(182620);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$recvListener$1", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Listener;", "onMsg", "", "resultCode", "", "select", "Ljava/util/ArrayList;", "", "avatarId", "plugin-webview_release"})
        public static final class b implements h.b {
            final /* synthetic */ a IYG;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            b(a aVar) {
                this.IYG = aVar;
            }

            @Override // com.tencent.mm.plugin.appbrand.permission.a.b.c
            public final void a(int i2, ArrayList<String> arrayList, int i3) {
                b bVar;
                AppMethodBeat.i(182606);
                p.h(arrayList, "select");
                switch (i2) {
                    case 1:
                        ah ahVar = ah.IYy;
                        Log.i(ah.getTAG(), "[OauthDialog.revnListener] ACCEPT, scope = " + arrayList.get(0));
                        if (!Util.isNullOrNil(arrayList) && (bVar = this.IYG.IYv) != null) {
                            String str = arrayList.get(0);
                            p.g(str, "select.get(0)");
                            String str2 = str;
                            p.h(str2, "scope");
                            bVar.IYP.add(str2);
                        }
                        b bVar2 = this.IYG.IYv;
                        if (bVar2 != null) {
                            bVar2.gcI();
                            AppMethodBeat.o(182606);
                            return;
                        }
                        AppMethodBeat.o(182606);
                        return;
                    default:
                        ah ahVar2 = ah.IYy;
                        Log.i(ah.getTAG(), "[OauthDialog.revnListener] REJECT, scope = " + arrayList.get(0));
                        b bVar3 = this.IYG.IYv;
                        if (bVar3 != null) {
                            bVar3.gcI();
                            AppMethodBeat.o(182606);
                            return;
                        }
                        AppMethodBeat.o(182606);
                        return;
                }
            }
        }

        public final void a(Bundle bundle, drb drb) {
            AppMethodBeat.i(182616);
            p.h(bundle, "resp");
            p.h(drb, "scope");
            this.IYB = drb;
            this.IYA.setPosition(2);
            h hVar = this.IYA;
            hVar.setAppBrandName(hVar.getContext().getString(R.string.eln, bundle.getString("appname", "")));
            hVar.setRequestDesc(drb.Desc);
            hVar.setApplyWording("");
            hVar.setNegativeButtonText(hVar.getContext().getResources().getString(R.string.ems));
            hVar.setPositiveButtonText(hVar.getContext().getResources().getString(R.string.ela));
            hVar.setIconUrl(bundle.getString("appicon_url", ""));
            ah ahVar = ah.IYy;
            Serializable serializable = bundle.getSerializable("avatar_list");
            if (serializable == null) {
                t tVar = new t("null cannot be cast to non-null type java.util.ArrayList<kotlin.ByteArray>");
                AppMethodBeat.o(182616);
                throw tVar;
            }
            ArrayList<cue> ba = ah.ba((ArrayList) serializable);
            int i2 = bundle.getInt("default_avatar_id");
            this.IYC = bundle.getBoolean("is_ban_modify_avatar");
            this.IYD = bundle.getInt("avatar_limit");
            this.IYE = 0;
            String aYE = ag.b.aYE(bundle.getString("oauth_url", ""));
            p.g(aYE, "OauthAuthorizeLogic.Tool…ZE_RESULT_OAUTH_URL, \"\"))");
            this.dNI = aYE;
            String str = drb.KWK;
            ah ahVar2 = ah.IYy;
            if (p.j(str, ah.gcF())) {
                this.IYE = i2;
                b bVar = this.IYv;
                if (bVar != null) {
                    bVar.afZ(this.IYE);
                }
                this.IYA.setItemCheckedListener(new c(this));
                if (!Util.isNullOrNil(ba)) {
                    this.lHN.clear();
                    ArrayList<i.a> arrayList = this.lHN;
                    String str2 = drb.KWK;
                    p.g(str2, "scope.Scope");
                    ArrayList<cue> arrayList2 = ba;
                    ArrayList arrayList3 = new ArrayList(j.a(arrayList2, 10));
                    for (T t : arrayList2) {
                        String str3 = t.nickname;
                        String str4 = t.desc;
                        boolean z = i2 == t.id;
                        String str5 = t.lHM;
                        p.g(str5, "it.avatarurl");
                        arrayList3.add(new i.a(str3, str4, str2, z, str5, t.id));
                    }
                    arrayList.addAll(arrayList3);
                    a(this.IYA, this.lHN, this.IYC, this.IYD);
                    this.IYA.setOnListItemLongClickListener(new d(this, drb));
                    this.IYF.b(this.IYA);
                    AppMethodBeat.o(182616);
                    return;
                }
                this.IYE = i2;
                b bVar2 = this.IYv;
                if (bVar2 != null) {
                    bVar2.afZ(this.IYE);
                }
                ah ahVar3 = ah.IYy;
                Log.i(ah.getTAG(), "[OauthDialog.showDialog] avatarList null");
                com.tencent.mm.ipcinvoker.h.a(MMApplicationContext.getApplicationId(), null, e.IYM.getClass(), new f(this, drb));
                AppMethodBeat.o(182616);
                return;
            }
            ah ahVar4 = ah.IYy;
            Log.i(ah.getTAG(), "[OauthDialog.showDialog] non snsapi_userinfo");
            this.IYA.setAppBrandName(this.context.getString(R.string.ell, bundle.getString("appname", "")));
            h hVar2 = this.IYA;
            String str6 = drb.KWK;
            p.g(str6, "scope.Scope");
            hVar2.setScope(str6);
            this.IYF.b(this.IYA);
            AppMethodBeat.o(182616);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$showDialog$2", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$ItemCheckedListener;", "onChecked", "", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "plugin-webview_release"})
        public static final class c implements i.b {
            final /* synthetic */ a IYG;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            c(a aVar) {
                this.IYG = aVar;
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.dialog.i.b
            public final void a(i.a aVar) {
                AppMethodBeat.i(210346);
                p.h(aVar, "item");
                this.IYG.IYE = aVar.lGW;
                b bVar = this.IYG.IYv;
                if (bVar != null) {
                    bVar.afZ(this.IYG.IYE);
                    AppMethodBeat.o(210346);
                    return;
                }
                AppMethodBeat.o(210346);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$showDialog$3", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$OnListItemLongClickListener;", "onLongClick", "", "v", "Landroid/view/View;", "item", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AuthorizeOptionalListAdapter$Item;", "longClickIndex", "", "plugin-webview_release"})
        public static final class d implements i.d {
            final /* synthetic */ a IYG;
            final /* synthetic */ drb IYH;

            d(a aVar, drb drb) {
                this.IYG = aVar;
                this.IYH = drb;
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.dialog.i.d
            public final void a(View view, i.a aVar, int i2) {
                AppMethodBeat.i(210347);
                p.h(view, "v");
                p.h(aVar, "item");
                com.tencent.mm.ui.widget.b.a aVar2 = new com.tencent.mm.ui.widget.b.a(view.getContext());
                if (i2 == 0) {
                    AppMethodBeat.o(210347);
                    return;
                }
                TouchableLayout.a aVar3 = TouchableLayout.Rni;
                int i3 = TouchableLayout.kuv;
                TouchableLayout.a aVar4 = TouchableLayout.Rni;
                aVar2.a(view, i2, 0, new View$OnCreateContextMenuListenerC1967a(this), new b(this, i2, aVar), i3, TouchableLayout.kuw);
                AppMethodBeat.o(210347);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
            /* renamed from: com.tencent.mm.plugin.webview.model.ah$a$d$a  reason: collision with other inner class name */
            static final class View$OnCreateContextMenuListenerC1967a implements View.OnCreateContextMenuListener {
                final /* synthetic */ d IYI;

                View$OnCreateContextMenuListenerC1967a(d dVar) {
                    this.IYI = dVar;
                }

                public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                    AppMethodBeat.i(182608);
                    contextMenu.add(0, 1, 0, this.IYI.IYG.context.getResources().getString(R.string.fbz));
                    AppMethodBeat.o(182608);
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "i", "", "onMMMenuItemSelected"})
            static final class b implements o.g {
                final /* synthetic */ d IYI;
                final /* synthetic */ int IYJ;
                final /* synthetic */ i.a orf;

                b(d dVar, int i2, i.a aVar) {
                    this.IYI = dVar;
                    this.IYJ = i2;
                    this.orf = aVar;
                }

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(182611);
                    final ArrayList arrayList = new ArrayList(this.IYI.IYG.lHN);
                    arrayList.remove(this.IYJ);
                    if (this.IYI.IYG.lHN.get(this.IYJ).lGW == this.IYI.IYG.IYE) {
                        ((i.a) arrayList.get(0)).jCx = true;
                    }
                    a.a(this.IYI.IYG, this.IYI.IYG.IYA, arrayList, this.IYI.IYG.IYC, this.IYI.IYG.IYD);
                    ah ahVar = ah.IYy;
                    Log.i(ah.getTAG(), "[[OauthDialog.showDialog] try delete avatarIdx = " + this.IYJ);
                    afa afa = new afa();
                    afa.Lqj = this.orf.lGW;
                    d.a aVar = new d.a();
                    aVar.c(afa);
                    aVar.d(new afb());
                    aVar.MB("/cgi-bin/mmbiz-bin/oauth_delavatar");
                    aVar.sG(2700);
                    aVar.sI(0);
                    aVar.sJ(0);
                    IPCRunCgi.a(aVar.aXF(), new IPCRunCgi.a(this) {
                        /* class com.tencent.mm.plugin.webview.model.ah.a.d.b.AnonymousClass1 */
                        final /* synthetic */ b IYK;

                        {
                            this.IYK = r1;
                        }

                        @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                        public final void a(final int i2, final int i3, String str, com.tencent.mm.ak.d dVar) {
                            AppMethodBeat.i(182610);
                            MMHandlerThread.postToMainThread(new Runnable(this) {
                                /* class com.tencent.mm.plugin.webview.model.ah.a.d.b.AnonymousClass1.AnonymousClass1 */
                                final /* synthetic */ AnonymousClass1 IYL;

                                {
                                    this.IYL = r1;
                                }

                                public final void run() {
                                    AppMethodBeat.i(182609);
                                    if (i2 == 0 && i3 == 0) {
                                        this.IYL.IYK.IYI.IYG.lHN.clear();
                                        this.IYL.IYK.IYI.IYG.lHN.addAll(arrayList);
                                        AppMethodBeat.o(182609);
                                        return;
                                    }
                                    a.a(this.IYL.IYK.IYI.IYG, this.IYL.IYK.IYI.IYG.IYA, this.IYL.IYK.IYI.IYG.lHN, this.IYL.IYK.IYI.IYG.IYC, this.IYL.IYK.IYI.IYG.IYD);
                                    AppMethodBeat.o(182609);
                                }
                            });
                            AppMethodBeat.o(182610);
                        }
                    });
                    AppMethodBeat.o(182611);
                }
            }
        }

        private final void a(h hVar, List<i.a> list, boolean z, int i2) {
            AppMethodBeat.i(182617);
            hVar.setSelectListItem(list);
            if (z || i2 <= list.size()) {
                if (!z) {
                    hVar.setFunctionButtonText(this.context.getResources().getString(R.string.j1h));
                    hVar.setFunctionButtonTextColor(this.context.getResources().getColor(R.color.BW_0_Alpha_0_3));
                } else {
                    hVar.setFunctionButtonText("");
                }
                b(hVar, false);
                AppMethodBeat.o(182617);
                return;
            }
            hVar.setFunctionButtonText(this.context.getResources().getString(R.string.j1h));
            hVar.setFunctionButtonTextColor(this.context.getResources().getColor(R.color.x0));
            b(hVar, true);
            AppMethodBeat.o(182617);
        }

        private final void b(h hVar, boolean z) {
            AppMethodBeat.i(182618);
            if (!z) {
                hVar.setFunctionButtonOnClickListener(null);
                AppMethodBeat.o(182618);
                return;
            }
            hVar.setFunctionButtonOnClickListener(new View$OnClickListenerC1966a(this));
            AppMethodBeat.o(182618);
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        /* renamed from: com.tencent.mm.plugin.webview.model.ah$a$a  reason: collision with other inner class name */
        public static final class View$OnClickListenerC1966a implements View.OnClickListener {
            final /* synthetic */ a IYG;

            View$OnClickListenerC1966a(a aVar) {
                this.IYG = aVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(182605);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$enableAddNewAvatarListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra(AppEventsConstants.EVENT_PARAM_VALUE_NO, this.IYG.dNI);
                Context context = this.IYG.context;
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(182605);
                    throw tVar;
                }
                Activity activity = (Activity) context;
                if (activity == null) {
                    ah ahVar = ah.IYy;
                    Log.e(ah.getTAG(), "try start CreateAvatarUI failed by NULL activity");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$enableAddNewAvatarListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(182605);
                    return;
                }
                ah ahVar2 = ah.IYy;
                com.tencent.mm.br.c.c(activity, ".plugin.webview.ui.tools.CreateAvatarUI", intent, ah.gcE());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/model/OauthMultiAccountMgr$OauthDialog$enableAddNewAvatarListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(182605);
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032*\u0010\u0005\u001a&\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003 \u0004*\u0012\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "invoke"})
        public static final class e<InputType, ResultType> implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle> {
            public static final e IYM = new e();

            static {
                AppMethodBeat.i(182614);
                AppMethodBeat.o(182614);
            }

            e() {
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
            @Override // com.tencent.mm.ipcinvoker.b
            public final /* synthetic */ void invoke(Bundle bundle, com.tencent.mm.ipcinvoker.d<Bundle> dVar) {
                AppMethodBeat.i(182613);
                Bundle bundle2 = new Bundle();
                bundle2.putString("userName", z.aUa());
                com.tencent.mm.kernel.e aAh = g.aAh();
                p.g(aAh, "MMKernel.storage()");
                Object obj = aAh.azQ().get(2);
                if (obj == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(182613);
                    throw tVar;
                }
                bundle2.putString("userIcon", com.tencent.mm.aj.c.Md(Util.nullAs((String) obj, "")));
                dVar.bn(bundle2);
                AppMethodBeat.o(182613);
            }
        }
    }

    public static final void a(Context context, Bundle bundle, int i2, ag.c cVar) {
        boolean z;
        AppMethodBeat.i(182635);
        p.h(context, UserDataStore.CITY);
        p.h(bundle, "resp");
        p.h(cVar, "webviewDelegate");
        if (context instanceof MutableContextWrapper) {
            context = ((MutableContextWrapper) context).getBaseContext();
            p.g(context, "(ct as MutableContextWrapper).baseContext");
        }
        if (!(context instanceof Activity)) {
            Log.v(TAG, "[showDialogQueue] context !is Activity");
            AppMethodBeat.o(182635);
            return;
        }
        if (!(IYw == i2 || IYv == null)) {
            Log.v(TAG, "[showDialogQueue] destroy last oauthQueue");
            destroy();
        }
        IYw = i2;
        if (IYv == null) {
            IYv = new b(context);
        }
        b bVar = IYv;
        if (bVar == null) {
            p.hyc();
        }
        if (bVar.IYN == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            IYx = new WeakReference<>(cVar);
            b bVar2 = IYv;
            if (bVar2 != null) {
                p.h(bundle, "resp");
                bVar2.IYN = bundle;
                Serializable serializable = bundle.getSerializable("scope_list");
                if (serializable == null) {
                    t tVar = new t("null cannot be cast to non-null type java.util.ArrayList<kotlin.ByteArray>");
                    AppMethodBeat.o(182635);
                    throw tVar;
                }
                LinkedList<drb> aZ = ag.aZ((ArrayList) serializable);
                p.g(aZ, "OauthAuthorizeLogic.byte…tScopeInfoList(bytesList)");
                bVar2.IXZ = aZ;
                bD(bVar2.IXZ);
                bVar2.gcI();
                AppMethodBeat.o(182635);
                return;
            }
            AppMethodBeat.o(182635);
            return;
        }
        Log.i(TAG, "[showDialogQueue] repeat call");
        AppMethodBeat.o(182635);
    }

    public static final void destroy() {
        AppMethodBeat.i(182638);
        b bVar = IYv;
        if (bVar != null) {
            bVar.destroy();
        }
        IYv = null;
        IYx = null;
        AppMethodBeat.o(182638);
    }

    public static final ArrayList<byte[]> bC(LinkedList<cue> linkedList) {
        AppMethodBeat.i(182639);
        ArrayList<byte[]> arrayList = new ArrayList<>();
        if (Util.isNullOrNil(linkedList)) {
            AppMethodBeat.o(182639);
            return arrayList;
        }
        if (linkedList != null) {
            Iterator<T> it = linkedList.iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add(it.next().toByteArray());
                } catch (IOException e2) {
                    Log.w(TAG, "oauthAvatarListToBytesList exception");
                    arrayList.clear();
                    AppMethodBeat.o(182639);
                    return arrayList;
                }
            }
        }
        AppMethodBeat.o(182639);
        return arrayList;
    }

    public static ArrayList<cue> ba(ArrayList<byte[]> arrayList) {
        AppMethodBeat.i(182640);
        ArrayList<cue> arrayList2 = new ArrayList<>();
        if (Util.isNullOrNil(arrayList)) {
            AppMethodBeat.o(182640);
            return arrayList2;
        }
        if (arrayList != null) {
            for (byte[] bArr : arrayList) {
                try {
                    cue cue = new cue();
                    cue.parseFrom(bArr);
                    arrayList2.add(cue);
                } catch (IOException e2) {
                    Log.w(TAG, "bytesListToAvatarList: exception");
                    arrayList2.clear();
                    AppMethodBeat.o(182640);
                    return arrayList2;
                }
            }
        }
        AppMethodBeat.o(182640);
        return arrayList2;
    }

    private static void bD(LinkedList<drb> linkedList) {
        AppMethodBeat.i(182641);
        if (Util.isNullOrNil(linkedList) || linkedList.size() == 1) {
            AppMethodBeat.o(182641);
            return;
        }
        Iterator<T> it = linkedList.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = 0;
                break;
            }
            T next = it.next();
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            if (p.j(next.KWK, IYu)) {
                break;
            }
            i2 = i3;
        }
        if (i2 > 0) {
            linkedList.addFirst(linkedList.remove(i2));
        }
        AppMethodBeat.o(182641);
    }

    public static final /* synthetic */ void gcG() {
        ag.c cVar;
        AppMethodBeat.i(182643);
        if (IYx != null) {
            WeakReference<ag.c> weakReference = IYx;
            if ((weakReference != null ? weakReference.get() : null) != null) {
                Log.i(TAG, "[goBackWebview]");
                WeakReference<ag.c> weakReference2 = IYx;
                if (!(weakReference2 == null || (cVar = weakReference2.get()) == null)) {
                    cVar.goBack();
                }
            }
        }
        destroy();
        AppMethodBeat.o(182643);
    }

    public static final /* synthetic */ void aYF(String str) {
        ag.c cVar;
        AppMethodBeat.i(182644);
        if (IYx != null) {
            WeakReference<ag.c> weakReference = IYx;
            if ((weakReference != null ? weakReference.get() : null) != null) {
                Log.i(TAG, "[goRedirectWebview] redirectUrl = ".concat(String.valueOf(str)));
                WeakReference<ag.c> weakReference2 = IYx;
                if (!(weakReference2 == null || (cVar = weakReference2.get()) == null)) {
                    cVar.aXL(str);
                }
            }
        }
        destroy();
        AppMethodBeat.o(182644);
    }
}
