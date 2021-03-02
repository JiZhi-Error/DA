package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ab.i;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.ad;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXChannelOpenFeed;
import com.tencent.mm.opensdk.modelbiz.WXChannelOpenLive;
import com.tencent.mm.opensdk.modelbiz.WXChannelOpenProfile;
import com.tencent.mm.opensdk.modelbiz.WXChannelShareVideo;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgramWithToken;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelpay.JumpToOfflinePay;
import com.tencent.mm.plugin.appbrand.ah.a.a;
import com.tencent.mm.plugin.appbrand.service.d;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.base.stub.d;
import com.tencent.mm.plugin.ext.a.b;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.protocal.protobuf.eg;
import com.tencent.mm.protocal.protobuf.ekp;
import com.tencent.mm.protocal.protobuf.ekq;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.thumbplayer.api.TPPlayerMgr;

public class WXBizEntryActivity extends AutoLoginActivity {
    private IListener<d> pdA = null;
    private int pdB;
    private boolean pdC;
    private boolean pdD = false;

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(WXBizEntryActivity wXBizEntryActivity, String str, String str2) {
        AppMethodBeat.i(22220);
        wXBizEntryActivity.b(str, str2, true, -1000);
        AppMethodBeat.o(22220);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void onCreateBeforeSetContentView() {
        AppMethodBeat.i(22207);
        super.onCreateBeforeSetContentView();
        supportRequestWindowFeature(9);
        AppMethodBeat.o(22207);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22208);
        this.pdC = f.ae(getIntent());
        g.aAf();
        if (com.tencent.mm.kernel.a.azo() && !com.tencent.mm.kernel.a.azj()) {
            f.ad(getIntent());
        }
        setTheme(R.style.q7);
        super.onCreate(bundle);
        Log.i("MicroMsg.WXBizEntryActivity", "onCreate");
        if (f.cjV()) {
            boolean booleanExtra = getIntent().getBooleanExtra("__BIZ_ENTRY_FROM_RETRY", false);
            if (this.pdC) {
                f.CD(booleanExtra ? 32 : 33);
                Log.i("MicroMsg.WXBizEntryActivity", "Safe Launch WXBizEntry isInConsumedSet finished");
                finish();
                AppMethodBeat.o(22208);
                return;
            }
            f.CD(booleanExtra ? 34 : 35);
        }
        setTitleVisibility(0);
        AppMethodBeat.o(22208);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.jm;
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity
    public final boolean ab(Intent intent) {
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity
    public final void a(AutoLoginActivity.a aVar, Intent intent) {
        Uri uri;
        final WXLaunchWxaRedirectingPage.Req req;
        Uri uri2;
        Uri uri3;
        Uri uri4;
        Uri uri5;
        AppMethodBeat.i(22209);
        Log.i("MicroMsg.WXBizEntryActivity", "postLogin, loginResult = ".concat(String.valueOf(aVar)));
        if (getIntent() != null) {
            this.pdB = getIntent().getIntExtra("key_command_id", 0);
        }
        switch (aVar) {
            case LOGIN_OK:
                Log.i("MicroMsg.WXBizEntryActivity", "req type = %d", Integer.valueOf(this.pdB));
                if (!f.cjV() || !this.pdC) {
                    switch (this.pdB) {
                        case 7:
                        case 8:
                            Intent intent2 = getIntent();
                            intent2.setClassName(this, "com.tencent.mm.ui.CheckCanSubscribeBizUI");
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/base/stub/WXBizEntryActivity", "dealRequest", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/base/stub/WXBizEntryActivity", "dealRequest", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            finish();
                            break;
                        case 9:
                            c.c(this, "card", ".ui.CardAddEntranceUI", getIntent());
                            finish();
                            break;
                        case 10:
                        case 18:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 27:
                        case 28:
                        case 31:
                        case 32:
                        default:
                            finish();
                            break;
                        case 11:
                            Intent intent3 = getIntent();
                            intent3.putExtra("device_type", 1);
                            c.c(this, "exdevice", ".ui.ExdeviceRankInfoUI", intent3);
                            finish();
                            break;
                        case 12:
                            try {
                                uri5 = getIntent().getData();
                            } catch (Exception e2) {
                                Log.e("MicroMsg.WXBizEntryActivity", "post login get url from intent failed : %s", e2.getMessage());
                                uri5 = null;
                            }
                            if (uri5 != null && com.tencent.mm.pluginsdk.g.bda(uri5.toString())) {
                                ad.aVe().JW("key_data_center_session_id");
                                com.tencent.mm.pluginsdk.g.a(this, uri5.toString(), getIntent().getIntExtra("translate_link_scene", 1), new g.a() {
                                    /* class com.tencent.mm.plugin.base.stub.WXBizEntryActivity.AnonymousClass4 */

                                    @Override // com.tencent.mm.pluginsdk.g.a
                                    public final void a(int i2, int i3, String str, q qVar, boolean z) {
                                        AppMethodBeat.i(22197);
                                        Log.i("MicroMsg.WXBizEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(z));
                                        if (qVar == null || i2 == 0 || i3 == 0 || !(qVar instanceof ac)) {
                                            WXBizEntryActivity.this.finish();
                                            AppMethodBeat.o(22197);
                                            return;
                                        }
                                        ekq bfD = ((ac) qVar).bfD();
                                        if (bfD == null || WXBizEntryActivity.this.isFinishing()) {
                                            WXBizEntryActivity.this.finish();
                                            AppMethodBeat.o(22197);
                                            return;
                                        }
                                        h.a((Context) WXBizEntryActivity.this, Util.nullAs(bfD.NjR, WXBizEntryActivity.this.getString(R.string.fiy)), WXBizEntryActivity.this.getString(R.string.zb), WXBizEntryActivity.this.getString(R.string.x_), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                            /* class com.tencent.mm.plugin.base.stub.WXBizEntryActivity.AnonymousClass4.AnonymousClass1 */

                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                AppMethodBeat.i(22196);
                                                WXBizEntryActivity.a(WXBizEntryActivity.this);
                                                WXBizEntryActivity.this.finish();
                                                AppMethodBeat.o(22196);
                                            }
                                        });
                                        AppMethodBeat.o(22197);
                                    }
                                }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
                                break;
                            }
                        case 13:
                            Intent intent4 = getIntent();
                            intent4.putExtra("key_static_from_scene", TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND);
                            c.c(this, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent4);
                            finish();
                            break;
                        case 14:
                        case 15:
                            new a(this, getIntent().getStringExtra("key_app_id"), getIntent().getStringExtra("open_id"), new d.a() {
                                /* class com.tencent.mm.plugin.base.stub.WXBizEntryActivity.AnonymousClass1 */

                                @Override // com.tencent.mm.plugin.base.stub.d.a
                                public final void jZ(boolean z) {
                                    AppMethodBeat.i(22189);
                                    if (z) {
                                        c.c(WXBizEntryActivity.this, "game", ".ui.CreateOrJoinChatroomUI", WXBizEntryActivity.this.getIntent());
                                    } else {
                                        Log.e("MicroMsg.WXBizEntryActivity", "openIdCheck false");
                                    }
                                    WXBizEntryActivity.this.finish();
                                    AppMethodBeat.o(22189);
                                }
                            }).cjR();
                            break;
                        case 16:
                            c.c(this, "card", ".ui.CardListSelectedUI", getIntent());
                            finish();
                            break;
                        case 17:
                            try {
                                f.a(this, getIntent().getData(), getIntent().getIntExtra("translate_link_scene", 1), getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"), new Runnable() {
                                    /* class com.tencent.mm.plugin.base.stub.WXBizEntryActivity.AnonymousClass3 */

                                    public final void run() {
                                        AppMethodBeat.i(22195);
                                        WXBizEntryActivity.this.findViewById(R.id.fge).setVisibility(8);
                                        AppMethodBeat.o(22195);
                                    }
                                });
                                break;
                            } catch (Exception e3) {
                                Log.e("MicroMsg.WXBizEntryActivity", "get url from intent failed : %s", e3.getMessage());
                                break;
                            }
                        case 19:
                        case 29:
                            try {
                                uri3 = getIntent().getData();
                            } catch (Exception e4) {
                                Log.e("MicroMsg.WXBizEntryActivity", "get data from intent for launch wxminiprogram failed : %s", e4.getMessage());
                                uri3 = null;
                            }
                            if (uri3 != null) {
                                String uri6 = uri3.toString();
                                if (getIntent().getBooleanExtra("key_launch_mini_program_is_used_token", false)) {
                                    String stringExtra = getIntent().getStringExtra("key_launch_mini_program_token");
                                    b arm = com.tencent.mm.plugin.ext.b.cSj().arm(stringExtra);
                                    if (arm == null) {
                                        h.a((Context) this, Util.nullAsNil(getString(R.string.eds)), getString(R.string.zb), getString(R.string.x_), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                            /* class com.tencent.mm.plugin.base.stub.WXBizEntryActivity.AnonymousClass6 */

                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                AppMethodBeat.i(22200);
                                                WXBizEntryActivity.a(WXBizEntryActivity.this, "", "invalid_token");
                                                WXBizEntryActivity.this.finish();
                                                AppMethodBeat.o(22200);
                                            }
                                        });
                                        break;
                                    } else {
                                        String str = arm.field_username;
                                        if (str.endsWith("@app")) {
                                            str = str.substring(0, str.lastIndexOf("@app"));
                                        }
                                        uri6 = uri6.replace(stringExtra, str);
                                        Log.i("MicroMsg.WXBizEntryActivity", "launchWXMiniprogramWithToken, url with username=".concat(String.valueOf(uri6)));
                                    }
                                }
                                f.CD(5);
                                final String queryParameter = uri3.getQueryParameter("invokeData");
                                final long currentTimeMillis = System.currentTimeMillis();
                                com.tencent.mm.pluginsdk.g.a(this, uri6, getIntent().getIntExtra("translate_link_scene", 1), new g.a() {
                                    /* class com.tencent.mm.plugin.base.stub.WXBizEntryActivity.AnonymousClass7 */

                                    @Override // com.tencent.mm.pluginsdk.g.a
                                    public final void a(int i2, int i3, String str, q qVar, boolean z) {
                                        AppMethodBeat.i(22202);
                                        Log.i("MicroMsg.WXBizEntryActivity", "launchWXMiniprogram, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(z));
                                        WXBizEntryActivity.a(WXBizEntryActivity.this, i3, qVar, (int) (System.currentTimeMillis() - currentTimeMillis));
                                        if (qVar == null || i2 == 0 || i3 == 0 || !(qVar instanceof ac)) {
                                            f.CD(6);
                                            WXBizEntryActivity.this.finish();
                                            AppMethodBeat.o(22202);
                                            return;
                                        }
                                        f.CD(7);
                                        final ekq bfD = ((ac) qVar).bfD();
                                        if (bfD == null || WXBizEntryActivity.this.isFinishing()) {
                                            WXBizEntryActivity.this.finish();
                                            AppMethodBeat.o(22202);
                                            return;
                                        }
                                        h.a((Context) WXBizEntryActivity.this, Util.nullAs(bfD.NjR, WXBizEntryActivity.this.getString(R.string.fiy)), WXBizEntryActivity.this.getString(R.string.zb), WXBizEntryActivity.this.getString(R.string.x_), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                            /* class com.tencent.mm.plugin.base.stub.WXBizEntryActivity.AnonymousClass7.AnonymousClass1 */

                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                AppMethodBeat.i(22201);
                                                WXBizEntryActivity.a(WXBizEntryActivity.this, queryParameter, bfD.NjR, WXBizEntryActivity.this.pdB == 29);
                                                WXBizEntryActivity.this.finish();
                                                AppMethodBeat.o(22201);
                                            }
                                        });
                                        AppMethodBeat.o(22202);
                                    }
                                }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
                                break;
                            }
                            break;
                        case 24:
                            try {
                                uri = getIntent().getData();
                            } catch (Exception e5) {
                                Log.e("MicroMsg.WXBizEntryActivity", "get data from intent for offline pay failed : %s", e5.getMessage());
                                uri = null;
                            }
                            if (uri != null) {
                                com.tencent.mm.pluginsdk.g.a(this, uri.toString(), getIntent().getIntExtra("translate_link_scene", 1), new g.a() {
                                    /* class com.tencent.mm.plugin.base.stub.WXBizEntryActivity.AnonymousClass8 */

                                    @Override // com.tencent.mm.pluginsdk.g.a
                                    public final void a(int i2, int i3, String str, q qVar, boolean z) {
                                        AppMethodBeat.i(22204);
                                        Log.i("MicroMsg.WXBizEntryActivity", "offline pay, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(z));
                                        if (qVar == null || i2 == 0 || i3 == 0 || !(qVar instanceof ac)) {
                                            WXBizEntryActivity.this.finish();
                                            AppMethodBeat.o(22204);
                                            return;
                                        }
                                        ekq bfD = ((ac) qVar).bfD();
                                        if (bfD == null || WXBizEntryActivity.this.isFinishing()) {
                                            WXBizEntryActivity.this.finish();
                                            AppMethodBeat.o(22204);
                                            return;
                                        }
                                        h.a((Context) WXBizEntryActivity.this, Util.nullAs(bfD.NjR, WXBizEntryActivity.this.getString(R.string.fiy)), WXBizEntryActivity.this.getString(R.string.zb), WXBizEntryActivity.this.getString(R.string.x_), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                            /* class com.tencent.mm.plugin.base.stub.WXBizEntryActivity.AnonymousClass8.AnonymousClass1 */

                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                AppMethodBeat.i(22203);
                                                WXBizEntryActivity.f(WXBizEntryActivity.this);
                                                WXBizEntryActivity.this.finish();
                                                AppMethodBeat.o(22203);
                                            }
                                        });
                                        AppMethodBeat.o(22204);
                                    }
                                }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
                                break;
                            }
                            break;
                        case 25:
                            try {
                                uri4 = getIntent().getData();
                            } catch (Exception e6) {
                                Log.e("MicroMsg.WXBizEntryActivity", "post login get url from intent failed : %s", e6.getMessage());
                                uri4 = null;
                            }
                            if (uri4 != null && com.tencent.mm.pluginsdk.g.bdc(uri4.toString())) {
                                ad.aVe().JW("key_data_center_session_id");
                                com.tencent.mm.pluginsdk.g.a(this, uri4.toString(), getIntent().getIntExtra("translate_link_scene", 1), new g.a() {
                                    /* class com.tencent.mm.plugin.base.stub.WXBizEntryActivity.AnonymousClass5 */

                                    @Override // com.tencent.mm.pluginsdk.g.a
                                    public final void a(int i2, int i3, String str, q qVar, boolean z) {
                                        AppMethodBeat.i(22199);
                                        Log.i("MicroMsg.WXBizEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(z));
                                        if (qVar == null || i2 == 0 || i3 == 0 || !(qVar instanceof ac)) {
                                            WXBizEntryActivity.this.finish();
                                            AppMethodBeat.o(22199);
                                            return;
                                        }
                                        ekq bfD = ((ac) qVar).bfD();
                                        if (bfD == null || WXBizEntryActivity.this.isFinishing()) {
                                            WXBizEntryActivity.this.finish();
                                            AppMethodBeat.o(22199);
                                            return;
                                        }
                                        h.a((Context) WXBizEntryActivity.this, Util.nullAs(bfD.NjR, WXBizEntryActivity.this.getString(R.string.fiy)), WXBizEntryActivity.this.getString(R.string.zb), WXBizEntryActivity.this.getString(R.string.x_), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                            /* class com.tencent.mm.plugin.base.stub.WXBizEntryActivity.AnonymousClass5.AnonymousClass1 */

                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                AppMethodBeat.i(22198);
                                                WXBizEntryActivity.b(WXBizEntryActivity.this);
                                                WXBizEntryActivity.this.finish();
                                                AppMethodBeat.o(22198);
                                            }
                                        });
                                        AppMethodBeat.o(22199);
                                    }
                                }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
                                break;
                            }
                        case 26:
                            try {
                                uri2 = getIntent().getData();
                            } catch (Exception e7) {
                                Log.e("MicroMsg.WXBizEntryActivity", "get data from intent for launch fake native miniprogram failed : %s", e7.getMessage());
                                uri2 = null;
                            }
                            if (uri2 != null) {
                                com.tencent.mm.pluginsdk.g.a(this, uri2.toString(), getIntent().getIntExtra("translate_link_scene", 1), new a(), getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
                                break;
                            }
                            break;
                        case 30:
                            Intent intent5 = getIntent();
                            ((f) com.tencent.mm.kernel.g.af(f.class)).a(z.PRE_LAUNCH_REDIRECTING_PAGE);
                            try {
                                Uri data = intent5.getData();
                                final String queryParameter2 = data == null ? null : data.getQueryParameter("appid");
                                int intExtra = intent5.getIntExtra("translate_link_scene", 1);
                                final String stringExtra2 = intent5.getStringExtra("key_package_name");
                                String stringExtra3 = intent5.getStringExtra("key_package_signature");
                                Bundle bundleExtra = intent5.getBundleExtra("key_launch_wxa_redirecting_page_req");
                                if (bundleExtra != null) {
                                    req = new WXLaunchWxaRedirectingPage.Req();
                                    req.fromBundle(bundleExtra);
                                } else {
                                    req = null;
                                }
                                Object[] objArr = new Object[6];
                                objArr[0] = data;
                                objArr[1] = Integer.valueOf(intExtra);
                                objArr[2] = stringExtra2;
                                objArr[3] = stringExtra3;
                                objArr[4] = req == null ? BuildConfig.COMMAND : req.invokeTicket;
                                objArr[5] = Integer.valueOf(hashCode());
                                Log.i("MicroMsg.WXBizEntryActivity", "dealRequest COMMAND_LAUNCH_WX_WXA_REDIRECTING_PAGE, deepLink[%s] translateLinkScene[%d], appPackage[%s | %s], req.ticket[%s], activity[%d]", objArr);
                                if (data != null && intExtra > 0 && !TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra3) && req != null) {
                                    final ekp ekp = new ekp();
                                    ekp.link = data.toString();
                                    ekp.scene = 1;
                                    eg egVar = new eg();
                                    egVar.signature = stringExtra3;
                                    egVar.qGp = stringExtra2;
                                    ekp.NjP.add(egVar);
                                    d.a aVar2 = new d.a();
                                    aVar2.iLN = ekp;
                                    aVar2.iLO = new ekq();
                                    aVar2.uri = "/cgi-bin/mmbiz-bin/translatelink";
                                    aVar2.funcId = 1200;
                                    f.CE(3);
                                    aa.a(aVar2.aXF(), new aa.a() {
                                        /* class com.tencent.mm.plugin.base.stub.WXBizEntryActivity.AnonymousClass10 */

                                        @Override // com.tencent.mm.ak.aa.a
                                        public final int a(int i2, final int i3, final String str, com.tencent.mm.ak.d dVar, q qVar) {
                                            AppMethodBeat.i(258834);
                                            final ekq ekq = (ekq) dVar.iLL.iLR;
                                            if (i2 != 0 || i3 != 0) {
                                                Log.e("MicroMsg.WXBizEntryActivity", "doLaunchWxaRedirectingPage, with ticket[%s] hostAppId[%s], cgi failed, errType[%d] errCode[%d] errMsg[%s]", req.invokeTicket, queryParameter2, Integer.valueOf(i2), Integer.valueOf(i3), str);
                                                f.CE(5);
                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                    /* class com.tencent.mm.plugin.base.stub.WXBizEntryActivity.AnonymousClass10.AnonymousClass1 */

                                                    public final void run() {
                                                        String str;
                                                        AppMethodBeat.i(258832);
                                                        String str2 = ekq != null ? ekq.NjR : null;
                                                        if (TextUtils.isEmpty(str2)) {
                                                            str = !TextUtils.isEmpty(str) ? str : WXBizEntryActivity.this.getString(R.string.fiy);
                                                        } else {
                                                            str = str2;
                                                        }
                                                        h.a((Context) WXBizEntryActivity.this, str, WXBizEntryActivity.this.getString(R.string.zb), WXBizEntryActivity.this.getString(R.string.x_), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                                            /* class com.tencent.mm.plugin.base.stub.WXBizEntryActivity.AnonymousClass10.AnonymousClass1.AnonymousClass1 */

                                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                                AppMethodBeat.i(258831);
                                                                f.a(WXBizEntryActivity.this, req, stringExtra2, i3, str);
                                                                AppMethodBeat.o(258831);
                                                            }
                                                        });
                                                        AppMethodBeat.o(258832);
                                                    }
                                                });
                                                AppMethodBeat.o(258834);
                                            } else if (ekq.NjU == null || ekq.NjU.zy.length <= 0) {
                                                f.CE(6);
                                                Log.e("MicroMsg.WXBizEntryActivity", "doLaunchWxaRedirectingPage, with ticket[%s] hostAppId[%s], get invalid wxa_runtime_buff from cgi", req.invokeTicket, queryParameter2);
                                                MMHandlerThread.postToMainThread(new Runnable() {
                                                    /* class com.tencent.mm.plugin.base.stub.WXBizEntryActivity.AnonymousClass10.AnonymousClass2 */

                                                    public final void run() {
                                                        AppMethodBeat.i(258833);
                                                        Toast.makeText(MMApplicationContext.getContext(), (int) R.string.j5p, 0).show();
                                                        AppMethodBeat.o(258833);
                                                    }
                                                });
                                                f.a(WXBizEntryActivity.this, req, stringExtra2, -1, "Invalid wxa_runtime_buff");
                                                AppMethodBeat.o(258834);
                                            } else {
                                                f.CE(4);
                                                Pair<Integer, String> a2 = ((f) com.tencent.mm.kernel.g.af(f.class)).a(WXBizEntryActivity.this, req, ekp.NjP.getFirst().qGp, ekq.NjQ, ekq.NjU.yO());
                                                if (((Integer) a2.first).intValue() != 0) {
                                                    f.a(WXBizEntryActivity.this, req, stringExtra2, ((Integer) a2.first).intValue(), (String) a2.second);
                                                } else {
                                                    a.C0537a.b(req.invokeTicket, WXBizEntryActivity.this);
                                                }
                                                AppMethodBeat.o(258834);
                                            }
                                            return 0;
                                        }
                                    }, true);
                                    break;
                                } else {
                                    finish();
                                    break;
                                }
                            } catch (Exception e8) {
                                Log.printErrStackTrace("MicroMsg.WXBizEntryActivity", e8, "dealRequest COMMAND_LAUNCH_WX_WXA_REDIRECTING_PAGE", new Object[0]);
                                finish();
                                break;
                            }
                        case 33:
                            awA(33);
                            break;
                        case 34:
                            awA(34);
                            break;
                        case 35:
                            awA(35);
                            break;
                        case 36:
                            awA(36);
                            break;
                    }
                } else {
                    Log.i("MicroMsg.WXBizEntryActivity", "Safe Launch WXBizEntry dealRequest isInConsumedSet finished");
                    finish();
                }
                f.CD(4);
                AppMethodBeat.o(22209);
                return;
            case LOGIN_CANCEL:
            case LOGIN_FAIL:
                Log.e("MicroMsg.WXBizEntryActivity", "postLogin fail, loginResult = ".concat(String.valueOf(aVar)));
                break;
            default:
                Log.e("MicroMsg.WXBizEntryActivity", "postLogin, unknown login result = ".concat(String.valueOf(aVar)));
                break;
        }
        f.CD(3);
        finish();
        AppMethodBeat.o(22209);
    }

    class a implements r.a, g.a {
        a() {
        }

        @Override // com.tencent.mm.pluginsdk.g.a
        public final void a(int i2, int i3, String str, q qVar, boolean z) {
            AppMethodBeat.i(22192);
            Log.i("MicroMsg.WXBizEntryActivity", "openBusinessView, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(z));
            if (qVar != null && (((!z && !Util.isNullOrNil(str)) || (i2 != 0 && i3 != 0)) && (qVar instanceof ac))) {
                ekq bfD = ((ac) qVar).bfD();
                if (bfD == null || WXBizEntryActivity.this.isFinishing()) {
                    WXBizEntryActivity.this.finish();
                    AppMethodBeat.o(22192);
                    return;
                }
                final String nullAs = Util.nullAs(Util.nullAs(bfD.NjR, str), WXBizEntryActivity.this.getString(R.string.fiy));
                h.a((Context) WXBizEntryActivity.this, nullAs, WXBizEntryActivity.this.getString(R.string.zb), WXBizEntryActivity.this.getString(R.string.x_), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.base.stub.WXBizEntryActivity.a.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(22190);
                        WXBizEntryActivity.a(WXBizEntryActivity.this, nullAs);
                        WXBizEntryActivity.this.finish();
                        AppMethodBeat.o(22190);
                    }
                });
                AppMethodBeat.o(22192);
            } else if (qVar instanceof ac) {
                String bfC = ((ac) qVar).bfC();
                Log.i("MicroMsg.WXBizEntryActivity", "openBusinessView, DeepLinkHelper.DeepLinkCallback transUri[%s]", bfC);
                if (!Util.nullAsNil(bfC).startsWith("weixin://dl/jumpFakeWxa/")) {
                    WXBizEntryActivity.this.finish();
                }
                AppMethodBeat.o(22192);
            } else {
                Log.e("MicroMsg.WXBizEntryActivity", "openBusinessView, DeepLinkHelper.DeepLinkCallback, scene is not NetSceneTranslateLink, finish activity");
                WXBizEntryActivity.this.finish();
                AppMethodBeat.o(22192);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.service.r.a
        public final void bNR() {
            AppMethodBeat.i(22193);
            if (WXBizEntryActivity.this.pdA != null) {
                WXBizEntryActivity.this.pdA.dead();
                WXBizEntryActivity.this.pdA = null;
            }
            WXBizEntryActivity.this.pdA = new IListener<com.tencent.mm.plugin.appbrand.service.d>() {
                /* class com.tencent.mm.plugin.base.stub.WXBizEntryActivity.a.AnonymousClass2 */

                {
                    AppMethodBeat.i(161297);
                    this.__eventId = com.tencent.mm.plugin.appbrand.service.d.class.getName().hashCode();
                    AppMethodBeat.o(161297);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                @Override // com.tencent.mm.sdk.event.IListener
                public final /* synthetic */ boolean callback(com.tencent.mm.plugin.appbrand.service.d dVar) {
                    AppMethodBeat.i(22191);
                    WXBizEntryActivity.this.finish();
                    AppMethodBeat.o(22191);
                    return false;
                }
            };
            WXBizEntryActivity.this.pdA.alive();
            WXBizEntryActivity.e(WXBizEntryActivity.this);
            AppMethodBeat.o(22193);
        }

        @Override // com.tencent.mm.plugin.appbrand.service.r.a
        public final void bNS() {
            AppMethodBeat.i(22194);
            WXBizEntryActivity.this.finish();
            AppMethodBeat.o(22194);
        }
    }

    private void awA(final int i2) {
        AppMethodBeat.i(258835);
        Uri uri = null;
        try {
            uri = getIntent().getData();
        } catch (Exception e2) {
            Log.e("MicroMsg.WXBizEntryActivity", "get data from intent for finder task failed : %s", e2.getMessage());
        }
        String stringExtra = getIntent().getStringExtra("key_finder_video_path");
        Bundle bundle = new Bundle();
        bundle.putString("key_finder_video_path", stringExtra);
        if (uri != null) {
            com.tencent.mm.pluginsdk.g.a(this, uri.toString(), getIntent().getIntExtra("translate_link_scene", 1), bundle, new g.a() {
                /* class com.tencent.mm.plugin.base.stub.WXBizEntryActivity.AnonymousClass9 */

                @Override // com.tencent.mm.pluginsdk.g.a
                public final void a(int i2, int i3, String str, q qVar, boolean z) {
                    AppMethodBeat.i(258830);
                    Log.i("MicroMsg.WXBizEntryActivity", "handleFinderTask, type = %d, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i2), Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(z));
                    if (i2 == 0 || i3 == 0 || !(qVar instanceof ac)) {
                        WXBizEntryActivity.this.finish();
                        AppMethodBeat.o(258830);
                        return;
                    }
                    f.CD(7);
                    ekq bfD = ((ac) qVar).bfD();
                    if (bfD == null || WXBizEntryActivity.this.isFinishing()) {
                        WXBizEntryActivity.this.finish();
                        AppMethodBeat.o(258830);
                        return;
                    }
                    h.a((Context) WXBizEntryActivity.this, Util.nullAs(bfD.NjR, WXBizEntryActivity.this.getString(R.string.fiy)), WXBizEntryActivity.this.getString(R.string.zb), WXBizEntryActivity.this.getString(R.string.x_), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.base.stub.WXBizEntryActivity.AnonymousClass9.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(258829);
                            WXBizEntryActivity.a(WXBizEntryActivity.this, i2);
                            WXBizEntryActivity.this.finish();
                            AppMethodBeat.o(258829);
                        }
                    });
                    AppMethodBeat.o(258830);
                }
            }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
        }
        AppMethodBeat.o(258835);
    }

    private void b(String str, String str2, boolean z, int i2) {
        BaseResp resp;
        AppMethodBeat.i(22210);
        com.tencent.mm.pluginsdk.model.app.g o = com.tencent.mm.pluginsdk.model.app.h.o(getIntent().getStringExtra("key_app_id"), true, false);
        if (o == null) {
            Log.e("MicroMsg.WXBizEntryActivity", "launchMiniProgramBackToApp info is null");
            AppMethodBeat.o(22210);
            return;
        }
        Bundle bundle = new Bundle();
        if (z) {
            resp = new WXLaunchMiniProgramWithToken.Resp(bundle);
        } else {
            resp = new WXLaunchMiniProgram.Resp(bundle);
            ((WXLaunchMiniProgram.Resp) resp).extMsg = Util.nullAs(str, "{}");
        }
        resp.errStr = str2;
        resp.openId = o.field_openId;
        resp.errCode = i2;
        a(bundle, resp, o);
        AppMethodBeat.o(22210);
    }

    private static void a(Bundle bundle, BaseResp baseResp, com.tencent.mm.pluginsdk.model.app.g gVar) {
        AppMethodBeat.i(22211);
        baseResp.toBundle(bundle);
        MMessageActV2.Args args = new MMessageActV2.Args();
        args.targetPkgName = gVar.field_packageName;
        args.bundle = bundle;
        com.tencent.mm.pluginsdk.model.app.q.bo(bundle);
        com.tencent.mm.pluginsdk.model.app.q.bp(bundle);
        MMessageActV2.send(MMApplicationContext.getContext(), args);
        AppMethodBeat.o(22211);
    }

    private void ka(final boolean z) {
        AppMethodBeat.i(22213);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.base.stub.WXBizEntryActivity.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(258827);
                View findViewById = WXBizEntryActivity.this.findViewById(R.id.fge);
                if (findViewById != null) {
                    findViewById.setVisibility(z ? 0 : 8);
                }
                AppMethodBeat.o(258827);
            }
        });
        AppMethodBeat.o(22213);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void hideAllManagedDialogs() {
        AppMethodBeat.i(22214);
        super.hideAllManagedDialogs();
        ka(false);
        AppMethodBeat.o(22214);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(22215);
        super.onNewIntent(intent);
        Log.i("MicroMsg.WXBizEntryActivity", "onNewIntent");
        this.pdD = false;
        if (this.pdA != null) {
            this.pdA.dead();
            this.pdA = null;
        }
        ka(true);
        AppMethodBeat.o(22215);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(22216);
        super.onResume();
        Log.i("MicroMsg.WXBizEntryActivity", "onResume, mDoFinishOnNextResume[%b]", Boolean.valueOf(this.pdD));
        if (this.pdD) {
            finish();
        }
        AppMethodBeat.o(22216);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(22217);
        super.onPause();
        Log.i("MicroMsg.WXBizEntryActivity", "onPause");
        AppMethodBeat.o(22217);
    }

    private static void eZ(String str, String str2) {
        AppMethodBeat.i(22212);
        com.tencent.mm.pluginsdk.model.app.g o = com.tencent.mm.pluginsdk.model.app.h.o(str, true, false);
        if (o == null) {
            AppMethodBeat.o(22212);
            return;
        }
        WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
        wXAppExtendObject.extInfo = str2;
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
        wXMediaMessage.sdkVer = Build.SDK_INT;
        wXMediaMessage.messageExt = str2;
        com.tencent.mm.pluginsdk.model.app.h.a(MMApplicationContext.getContext(), o.field_appId, wXMediaMessage, 2, (al) null, (Bundle) null);
        AppMethodBeat.o(22212);
    }

    static /* synthetic */ void a(WXBizEntryActivity wXBizEntryActivity) {
        AppMethodBeat.i(22218);
        try {
            Uri data = wXBizEntryActivity.getIntent().getData();
            int i2 = Util.getInt(data.getQueryParameter("type"), 0);
            String nullAsNil = Util.nullAsNil(data.getQueryParameter("appid"));
            eZ(nullAsNil, String.format("%s://opentypewebview?wx_internal_resptype=%d&ret=%d", nullAsNil, Integer.valueOf(i2), -3));
            AppMethodBeat.o(22218);
        } catch (Exception e2) {
            Log.e("MicroMsg.WXBizEntryActivity", "launchOpenTypeWebView get url from intent failed : %s", e2.getMessage());
            AppMethodBeat.o(22218);
        }
    }

    static /* synthetic */ void b(WXBizEntryActivity wXBizEntryActivity) {
        AppMethodBeat.i(22219);
        try {
            Uri data = wXBizEntryActivity.getIntent().getData();
            int i2 = Util.getInt(data.getQueryParameter("type"), 0);
            String nullAsNil = Util.nullAsNil(data.getQueryParameter("appid"));
            eZ(nullAsNil, String.format("%s://openbusinesswebview?type=%d&ret=%d", nullAsNil, Integer.valueOf(i2), -3));
            AppMethodBeat.o(22219);
        } catch (Exception e2) {
            Log.e("MicroMsg.WXBizEntryActivity", "launchOpenTypeWebView get url from intent failed : %s", e2.getMessage());
            AppMethodBeat.o(22219);
        }
    }

    static /* synthetic */ void a(WXBizEntryActivity wXBizEntryActivity, int i2, q qVar, int i3) {
        int i4;
        Uri parse;
        AppMethodBeat.i(22221);
        if (qVar != null && (qVar instanceof ac)) {
            String stringExtra = wXBizEntryActivity.getIntent().getStringExtra("key_app_id");
            String stringExtra2 = wXBizEntryActivity.getIntent().getStringExtra("key_user_name");
            String str = "";
            String str2 = "";
            ekq bfD = ((ac) qVar).bfD();
            if (bfD == null || bfD.NjQ == null || (parse = Uri.parse(bfD.NjQ)) == null) {
                i4 = 0;
            } else {
                i4 = Util.getInt(Util.nullAsNil(parse.getQueryParameter("pathType")), 0);
                String queryParameter = parse.getQueryParameter("invokeData");
                if (!Util.isNullOrNil(queryParameter)) {
                    try {
                        str = new i(queryParameter).optString("token");
                    } catch (Exception e2) {
                    }
                }
                str2 = parse.getQueryParameter("ad_trace_key");
            }
            if (i3 < 0 || ((long) i3) > Util.MILLSECONDS_OF_HOUR) {
                i3 = 0;
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(18479, stringExtra, Integer.valueOf(i4), stringExtra2, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
        }
        AppMethodBeat.o(22221);
    }

    static /* synthetic */ void a(WXBizEntryActivity wXBizEntryActivity, String str, String str2, boolean z) {
        AppMethodBeat.i(22222);
        wXBizEntryActivity.b(str, str2, z, -3);
        AppMethodBeat.o(22222);
    }

    static /* synthetic */ void a(WXBizEntryActivity wXBizEntryActivity, String str) {
        AppMethodBeat.i(22223);
        String stringExtra = wXBizEntryActivity.getIntent().getStringExtra("key_app_id");
        String stringExtra2 = wXBizEntryActivity.getIntent().getStringExtra("key_business_type");
        com.tencent.mm.pluginsdk.model.app.g o = com.tencent.mm.pluginsdk.model.app.h.o(stringExtra, true, false);
        if (o == null) {
            Log.e("MicroMsg.WXBizEntryActivity", "launchFakeMiniProgramBackToApp info is null");
            AppMethodBeat.o(22223);
            return;
        }
        Bundle bundle = new Bundle();
        WXOpenBusinessView.Resp resp = new WXOpenBusinessView.Resp(bundle);
        resp.extMsg = "{}";
        resp.errStr = str;
        resp.openId = o.field_openId;
        resp.errCode = -3;
        resp.businessType = stringExtra2;
        resp.transaction = n.Kwp;
        a(bundle, resp, o);
        AppMethodBeat.o(22223);
    }

    static /* synthetic */ void e(WXBizEntryActivity wXBizEntryActivity) {
        AppMethodBeat.i(22224);
        Log.i("MicroMsg.WXBizEntryActivity", "setDoFinishOnNextResume");
        wXBizEntryActivity.pdD = true;
        AppMethodBeat.o(22224);
    }

    static /* synthetic */ void f(WXBizEntryActivity wXBizEntryActivity) {
        AppMethodBeat.i(22225);
        String stringExtra = wXBizEntryActivity.getIntent().getStringExtra("key_app_id");
        Log.i("MicroMsg.WXBizEntryActivity", "offlinePayBackToApp: %s", stringExtra);
        com.tencent.mm.pluginsdk.model.app.g o = com.tencent.mm.pluginsdk.model.app.h.o(stringExtra, true, false);
        if (o == null) {
            Log.w("MicroMsg.WXBizEntryActivity", "can not find app info");
            AppMethodBeat.o(22225);
            return;
        }
        Bundle bundle = new Bundle();
        JumpToOfflinePay.Resp resp = new JumpToOfflinePay.Resp();
        resp.errCode = -3;
        a(bundle, resp, o);
        AppMethodBeat.o(22225);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ void a(WXBizEntryActivity wXBizEntryActivity, int i2) {
        AppMethodBeat.i(258836);
        String stringExtra = wXBizEntryActivity.getIntent().getStringExtra("key_app_id");
        com.tencent.mm.pluginsdk.model.app.g o = com.tencent.mm.pluginsdk.model.app.h.o(stringExtra, true, false);
        if (o == null) {
            Log.w("MicroMsg.WXBizEntryActivity", "can not find app info");
            AppMethodBeat.o(258836);
            return;
        }
        Bundle bundle = new Bundle();
        switch (i2) {
            case 33:
                Log.i("MicroMsg.WXBizEntryActivity", "Finder share video backToApp: %s", stringExtra);
                WXChannelShareVideo.Resp resp = new WXChannelShareVideo.Resp();
                resp.errCode = -3;
                resp.extMsg = "{}";
                a(bundle, resp, o);
                AppMethodBeat.o(258836);
                return;
            case 34:
                Log.i("MicroMsg.WXBizEntryActivity", "Finder open profile backToApp: %s", stringExtra);
                WXChannelOpenProfile.Resp resp2 = new WXChannelOpenProfile.Resp();
                resp2.errCode = -3;
                resp2.extMsg = "{}";
                a(bundle, resp2, o);
                AppMethodBeat.o(258836);
                return;
            case 35:
                Log.i("MicroMsg.WXBizEntryActivity", "Finder open live backToApp: %s", stringExtra);
                WXChannelOpenLive.Resp resp3 = new WXChannelOpenLive.Resp();
                resp3.errCode = -3;
                resp3.extMsg = "{}";
                a(bundle, resp3, o);
                AppMethodBeat.o(258836);
                return;
            case 36:
                Log.i("MicroMsg.WXBizEntryActivity", "Finder open feed backToApp: %s", stringExtra);
                WXChannelOpenFeed.Resp resp4 = new WXChannelOpenFeed.Resp();
                resp4.errCode = -3;
                resp4.extMsg = "{}";
                a(bundle, resp4, o);
                break;
        }
        AppMethodBeat.o(258836);
    }
}
