package com.tencent.mm.plugin.base.stub;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWeWorkObject;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.r.a.a;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.tools.d;
import com.tencent.mm.protocal.protobuf.aew;
import com.tencent.mm.protocal.protobuf.aex;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.z;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Map;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class WXEntryActivity extends AutoLoginActivity implements i {
    private int EX;
    private String LG;
    private String appId;
    private String authority;
    private String content;
    private ProgressDialog gtM;
    private int msgType = 0;
    private WeakReference<WXEntryActivity> peA = new WeakReference<>(this);
    private Boolean peB = null;
    private String peC = "";
    private WXMediaMessage pez;
    private int sdkVersion;
    private String token;
    private int tokenType = 0;
    private Uri uri;

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WXEntryActivity() {
        AppMethodBeat.i(22287);
        AppMethodBeat.o(22287);
    }

    static /* synthetic */ byte[] E(String str, int i2, String str2) {
        AppMethodBeat.i(22309);
        byte[] D = D(str, i2, str2);
        AppMethodBeat.o(22309);
        return D;
    }

    static /* synthetic */ void a(WXEntryActivity wXEntryActivity) {
        AppMethodBeat.i(22311);
        wXEntryActivity.goBack();
        AppMethodBeat.o(22311);
    }

    static /* synthetic */ void a(WXEntryActivity wXEntryActivity, int i2, int i3, String str) {
        AppMethodBeat.i(169748);
        wXEntryActivity.r(i2, i3, str);
        AppMethodBeat.o(169748);
    }

    static /* synthetic */ boolean a(WXEntryActivity wXEntryActivity, q qVar, g gVar) {
        AppMethodBeat.i(169747);
        boolean a2 = wXEntryActivity.a(qVar, gVar);
        AppMethodBeat.o(169747);
        return a2;
    }

    static /* synthetic */ void b(WXEntryActivity wXEntryActivity) {
        AppMethodBeat.i(22312);
        wXEntryActivity.ckk();
        AppMethodBeat.o(22312);
    }

    static /* synthetic */ void c(WXEntryActivity wXEntryActivity) {
        AppMethodBeat.i(169745);
        wXEntryActivity.ckm();
        AppMethodBeat.o(169745);
    }

    static /* synthetic */ void e(WXEntryActivity wXEntryActivity) {
        AppMethodBeat.i(169746);
        wXEntryActivity.cki();
        AppMethodBeat.o(169746);
    }

    static /* synthetic */ void f(WXEntryActivity wXEntryActivity) {
        AppMethodBeat.i(169750);
        wXEntryActivity.ckl();
        AppMethodBeat.o(169750);
    }

    static /* synthetic */ boolean i(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(22310);
        boolean checkSumConsistent = checkSumConsistent(bArr, bArr2);
        AppMethodBeat.o(22310);
        return checkSumConsistent;
    }

    static /* synthetic */ boolean vF(int i2) {
        AppMethodBeat.i(22308);
        boolean CG = CG(i2);
        AppMethodBeat.o(22308);
        return CG;
    }

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public static class EntryReceiver extends BroadcastReceiver {
        private static MMHandler handler;
        private String LG;
        private String appId;
        private String appName;
        private Context context;
        private long peH;
        private int sdkVersion;

        static /* synthetic */ void a(EntryReceiver entryReceiver, g gVar) {
            AppMethodBeat.i(22286);
            entryReceiver.b(gVar);
            AppMethodBeat.o(22286);
        }

        public void onReceive(final Context context2, final Intent intent) {
            AppMethodBeat.i(22283);
            if (context2 == null || intent == null) {
                AppMethodBeat.o(22283);
                return;
            }
            c.gsX();
            if (handler == null) {
                handler = new MMHandler("WXEntryReceiver");
            }
            if (!com.tencent.mm.kernel.g.aAi().hrh.hrB) {
                com.tencent.mm.kernel.g.aAi().a(new com.tencent.mm.kernel.api.g() {
                    /* class com.tencent.mm.plugin.base.stub.WXEntryActivity.EntryReceiver.AnonymousClass1 */

                    @Override // com.tencent.mm.kernel.api.g
                    public final void WY() {
                        AppMethodBeat.i(22280);
                        com.tencent.mm.kernel.g.aAi().b(this);
                        EntryReceiver.a(EntryReceiver.this, context2, intent);
                        AppMethodBeat.o(22280);
                    }

                    @Override // com.tencent.mm.kernel.api.g
                    public final void cQ(boolean z) {
                    }
                });
                AppMethodBeat.o(22283);
                return;
            }
            handler.post(new Runnable() {
                /* class com.tencent.mm.plugin.base.stub.WXEntryActivity.EntryReceiver.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(22281);
                    long currentTimeMillis = System.currentTimeMillis();
                    EntryReceiver.a(EntryReceiver.this, context2, intent);
                    Log.i("MicroMsg.WXEntryActivity", "cost:%s", new StringBuilder().append(System.currentTimeMillis() - currentTimeMillis).toString());
                    AppMethodBeat.o(22281);
                }
            });
            AppMethodBeat.o(22283);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x008d, code lost:
            if (r0 == false) goto L_0x008f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void b(com.tencent.mm.pluginsdk.model.app.g r9) {
            /*
            // Method dump skipped, instructions count: 442
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.base.stub.WXEntryActivity.EntryReceiver.b(com.tencent.mm.pluginsdk.model.app.g):void");
        }

        static /* synthetic */ void a(EntryReceiver entryReceiver, Context context2, Intent intent) {
            AppMethodBeat.i(22285);
            entryReceiver.context = context2;
            String stringExtra = IntentUtil.getStringExtra(intent, ConstantsAPI.CONTENT);
            entryReceiver.peH = IntentUtil.getLongExtra(intent, ConstantsAPI.APP_SUPORT_CONTENT_TYPE, 0);
            entryReceiver.sdkVersion = IntentUtil.getIntExtra(intent, ConstantsAPI.SDK_VERSION, 0);
            if (!WXEntryActivity.vF(entryReceiver.sdkVersion)) {
                Log.e("MicroMsg.WXEntryActivity", "sdk version is not supported, sdkVersion = " + entryReceiver.sdkVersion);
                AppMethodBeat.o(22285);
                return;
            }
            entryReceiver.LG = IntentUtil.getStringExtra(intent, ConstantsAPI.APP_PACKAGE);
            if (entryReceiver.LG == null || entryReceiver.LG.length() <= 0) {
                Log.e("MicroMsg.WXEntryActivity", "unknown package, ignore");
                AppMethodBeat.o(22285);
            } else if (!WXEntryActivity.i(IntentUtil.getByteArrayExtra(intent, ConstantsAPI.CHECK_SUM), WXEntryActivity.E(stringExtra, entryReceiver.sdkVersion, entryReceiver.LG))) {
                Log.e("MicroMsg.WXEntryActivity", "checksum fail");
                AppMethodBeat.o(22285);
            } else if (stringExtra == null) {
                Log.e("MicroMsg.WXEntryActivity", "check appid failed, null content");
                AppMethodBeat.o(22285);
            } else {
                Uri parse = Uri.parse(stringExtra);
                String authority = parse.getAuthority();
                try {
                    entryReceiver.appId = parse.getQueryParameter("appid");
                    Log.i("MicroMsg.WXEntryActivity", "onReceive, appId = " + entryReceiver.appId);
                    if (entryReceiver.appId == null || entryReceiver.appId.length() <= 0) {
                        Log.e("MicroMsg.WXEntryActivity", "invalid appid, ignore");
                        AppMethodBeat.o(22285);
                    } else if (!bg.aAc() || bg.azj()) {
                        Log.w("MicroMsg.WXEntryActivity", "not login, just save the appid : %s", entryReceiver.appId);
                        com.tencent.mm.pluginsdk.model.app.q.bdL(entryReceiver.appId);
                        AppMethodBeat.o(22285);
                    } else if (!com.tencent.mm.kernel.g.aAf().hpY) {
                        Log.w("MicroMsg.WXEntryActivity", "not login accInitializing, just save the appid : %s", entryReceiver.appId);
                        com.tencent.mm.pluginsdk.model.app.q.bdL(entryReceiver.appId);
                        AppMethodBeat.o(22285);
                    } else if ("registerapp".equals(authority)) {
                        Log.i("MicroMsg.WXEntryActivity", "handle app registeration: " + entryReceiver.LG + ", sdkver=" + entryReceiver.sdkVersion);
                        if (!bg.aAc()) {
                            Log.e("MicroMsg.WXEntryActivity", "no available account");
                            AppMethodBeat.o(22285);
                            return;
                        }
                        final g o = h.o(entryReceiver.appId, true, false);
                        if (o == null || !Util.isEqual(entryReceiver.LG, o.field_packageName)) {
                            h.a(entryReceiver.appId, entryReceiver.LG, new h.a() {
                                /* class com.tencent.mm.plugin.base.stub.WXEntryActivity.EntryReceiver.AnonymousClass3 */

                                @Override // com.tencent.mm.pluginsdk.model.app.h.a
                                public final void a(g gVar) {
                                    AppMethodBeat.i(22282);
                                    if (gVar == null) {
                                        gVar = o;
                                    }
                                    EntryReceiver.a(EntryReceiver.this, gVar);
                                    AppMethodBeat.o(22282);
                                }
                            });
                            AppMethodBeat.o(22285);
                            return;
                        }
                        entryReceiver.b(o);
                        AppMethodBeat.o(22285);
                    } else {
                        if ("unregisterapp".equals(authority)) {
                            Log.d("MicroMsg.WXEntryActivity", "handle app unregisteration: " + entryReceiver.LG + ", sdkver=" + entryReceiver.sdkVersion);
                            if (!bg.aAc()) {
                                Log.e("MicroMsg.WXEntryActivity", "no available account");
                                AppMethodBeat.o(22285);
                                return;
                            }
                            g o2 = h.o(entryReceiver.appId, false, false);
                            if (!com.tencent.mm.pluginsdk.model.app.q.a(entryReceiver.context, o2, entryReceiver.LG, false)) {
                                Log.e("MicroMsg.WXEntryActivity", "unreg fail, check app fail");
                                AppMethodBeat.o(22285);
                                return;
                            } else if (!(o2 == null || o2.field_status == 5)) {
                                o2.field_status = 4;
                                ao.eAS().a(o2, new String[0]);
                                d.bfo(entryReceiver.appId);
                            }
                        }
                        AppMethodBeat.o(22285);
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.WXEntryActivity", "init: %s", e2.toString());
                    AppMethodBeat.o(22285);
                }
            }
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22288);
        IntentUtil.putExtra(getIntent(), "key_auto_login_wizard_exit", true);
        super.onCreate(bundle);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.base.stub.WXEntryActivity.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(22273);
                WXEntryActivity.a(WXEntryActivity.this);
                AppMethodBeat.o(22273);
                return false;
            }
        });
        AppMethodBeat.o(22288);
    }

    private void CF(int i2) {
        AppMethodBeat.i(231626);
        if (getController() != null) {
            getController().setStatusBarColor(i2);
        }
        AppMethodBeat.o(231626);
    }

    private boolean af(Intent intent) {
        AppMethodBeat.i(22289);
        this.sdkVersion = IntentUtil.getIntExtra(intent, ConstantsAPI.SDK_VERSION, 0);
        this.content = IntentUtil.getStringExtra(intent, ConstantsAPI.CONTENT);
        if (this.content != null) {
            this.uri = Uri.parse(this.content);
            this.authority = this.uri.getAuthority();
            try {
                this.appId = this.uri.getQueryParameter("appid");
                this.LG = IntentUtil.getStringExtra(intent, ConstantsAPI.APP_PACKAGE);
                this.token = IntentUtil.getStringExtra(intent, ConstantsAPI.TOKEN);
                AppMethodBeat.o(22289);
                return true;
            } catch (Exception e2) {
                Log.e("MicroMsg.WXEntryActivity", "init: %s", e2.toString());
                AppMethodBeat.o(22289);
                return false;
            }
        } else {
            AppMethodBeat.o(22289);
            return false;
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity
    public final boolean ab(Intent intent) {
        AppMethodBeat.i(22290);
        if (!af(intent)) {
            Log.e("MicroMsg.WXEntryActivity", "Init failed");
            finish();
            AppMethodBeat.o(22290);
            return false;
        }
        if (!bg.aAc() || bg.azj()) {
            Log.w("MicroMsg.WXEntryActivity", "preLogin not login, save the appid : %s", this.appId);
            com.tencent.mm.pluginsdk.model.app.q.bdL(this.appId);
        }
        if (!CG(this.sdkVersion)) {
            Log.e("MicroMsg.WXEntryActivity", "sdk version is not supported, sdkVersion = " + this.sdkVersion);
            finish();
            AppMethodBeat.o(22290);
            return false;
        } else if (this.uri == null) {
            Log.e("MicroMsg.WXEntryActivity", "check appid failed, null content");
            finish();
            AppMethodBeat.o(22290);
            return false;
        } else {
            Log.i("MicroMsg.WXEntryActivity", "preLogin, appId = " + this.appId);
            if (af.isNullOrNil(this.appId)) {
                Log.e("MicroMsg.WXEntryActivity", "invalid appid, ignore");
                finish();
                AppMethodBeat.o(22290);
                return false;
            }
            Log.i("MicroMsg.WXEntryActivity", "preLogin, pkg = " + this.LG);
            if (af.isNullOrNil(this.LG)) {
                Log.e("MicroMsg.WXEntryActivity", "unknown package, ignore");
                finish();
                AppMethodBeat.o(22290);
                return false;
            } else if (!checkSumConsistent(IntentUtil.getByteArrayExtra(intent, ConstantsAPI.CHECK_SUM), D(this.content, this.sdkVersion, this.LG))) {
                Log.e("MicroMsg.WXEntryActivity", "checksum fail");
                finish();
                AppMethodBeat.o(22290);
                return false;
            } else {
                AppMethodBeat.o(22290);
                return true;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x018e  */
    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a r14, android.content.Intent r15) {
        /*
        // Method dump skipped, instructions count: 1694
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.base.stub.WXEntryActivity.a(com.tencent.mm.pluginsdk.ui.AutoLoginActivity$a, android.content.Intent):void");
    }

    private static String Fg(String str) {
        AppMethodBeat.i(22292);
        if (af.isNullOrNil(str)) {
            AppMethodBeat.o(22292);
            return "";
        }
        try {
            String encode = URLEncoder.encode(str);
            AppMethodBeat.o(22292);
            return encode;
        } catch (Exception e2) {
            Log.e("MicroMsg.WXEntryActivity", "urlEncode fail, str = %s, ex = %s", str, e2.getMessage());
            AppMethodBeat.o(22292);
            return str;
        }
    }

    private void f(final q qVar) {
        AppMethodBeat.i(22293);
        if (!bg.aAc()) {
            Log.w("MicroMsg.WXEntryActivity", "accHasReady not ready, do nothing");
            finish();
            AppMethodBeat.o(22293);
            return;
        }
        final g o = h.o(this.appId, true, false);
        if (o == null || !Util.isEqual(this.LG, o.field_packageName)) {
            this.gtM = com.tencent.mm.ui.base.h.a((Context) getContext(), getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.base.stub.WXEntryActivity.AnonymousClass4 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(169739);
                    WXEntryActivity.this.finish();
                    AppMethodBeat.o(169739);
                }
            });
            h.a(this.appId, this.LG, new h.a() {
                /* class com.tencent.mm.plugin.base.stub.WXEntryActivity.AnonymousClass5 */

                @Override // com.tencent.mm.pluginsdk.model.app.h.a
                public final void a(g gVar) {
                    AppMethodBeat.i(169740);
                    if (gVar == null) {
                        gVar = o;
                    }
                    if (WXEntryActivity.this.peA.get() != null) {
                        WXEntryActivity.e((WXEntryActivity) WXEntryActivity.this.peA.get());
                        WXEntryActivity.a((WXEntryActivity) WXEntryActivity.this.peA.get(), qVar, gVar);
                    }
                    WXEntryActivity.this.finish();
                    AppMethodBeat.o(169740);
                }
            });
            AppMethodBeat.o(22293);
            return;
        }
        a(qVar, o);
        finish();
        AppMethodBeat.o(22293);
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.tencent.mm.ak.q r12, com.tencent.mm.pluginsdk.model.app.g r13) {
        /*
        // Method dump skipped, instructions count: 950
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.base.stub.WXEntryActivity.a(com.tencent.mm.ak.q, com.tencent.mm.pluginsdk.model.app.g):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0141 A[SYNTHETIC, Splitter:B:41:0x0141] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x015c A[SYNTHETIC, Splitter:B:48:0x015c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.tencent.mm.opensdk.modelmsg.WXMediaMessage r14, int r15) {
        /*
        // Method dump skipped, instructions count: 381
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.base.stub.WXEntryActivity.a(com.tencent.mm.opensdk.modelmsg.WXMediaMessage, int):boolean");
    }

    private boolean ckh() {
        AppMethodBeat.i(22296);
        if (this.peB != null) {
            boolean booleanValue = this.peB.booleanValue();
            AppMethodBeat.o(22296);
            return booleanValue;
        } else if (IntentUtil.getInt(getIntent().getExtras(), "_wxapi_command_type", 0) != 2) {
            this.peB = Boolean.TRUE;
            this.tokenType = 4;
            if (!af.isNullOrNil(this.token)) {
                ad.aVe().JW(this.token);
            }
            AppMethodBeat.o(22296);
            return true;
        } else if (af.isNullOrNil(this.token)) {
            Log.i("MicroMsg.WXEntryActivity", "token is null");
            this.peB = Boolean.FALSE;
            this.tokenType = 1;
            AppMethodBeat.o(22296);
            return false;
        } else {
            ad.b JW = ad.aVe().JW(this.token);
            if (JW != null) {
                this.peC = JW.getString("open_sdk_token_package_name", "");
                if (this.peC.equals(this.LG)) {
                    Log.i("MicroMsg.WXEntryActivity", "token check success");
                    this.peB = Boolean.TRUE;
                    this.tokenType = 0;
                    AppMethodBeat.o(22296);
                    return true;
                }
                Log.w("MicroMsg.WXEntryActivity", "token check fail %s/%s", this.peC, this.LG);
                this.peB = Boolean.FALSE;
                this.tokenType = 3;
                AppMethodBeat.o(22296);
                return false;
            }
            this.peB = Boolean.FALSE;
            this.tokenType = 2;
            Log.i("MicroMsg.WXEntryActivity", "keyValueSet is null");
            AppMethodBeat.o(22296);
            return false;
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.boq;
    }

    private static boolean CG(int i2) {
        return i2 >= 553713665;
    }

    private static byte[] D(String str, int i2, String str2) {
        AppMethodBeat.i(22297);
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i2);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        byte[] bytes = com.tencent.mm.b.g.getMessageDigest(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
        AppMethodBeat.o(22297);
        return bytes;
    }

    private static boolean checkSumConsistent(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(22298);
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            Log.e("MicroMsg.WXEntryActivity", "checkSumConsistent fail, invalid arguments");
            AppMethodBeat.o(22298);
            return false;
        } else if (bArr.length != bArr2.length) {
            Log.e("MicroMsg.WXEntryActivity", "checkSumConsistent fail, length is different");
            AppMethodBeat.o(22298);
            return false;
        } else {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                if (bArr[i2] != bArr2[i2]) {
                    AppMethodBeat.o(22298);
                    return false;
                }
            }
            AppMethodBeat.o(22298);
            return true;
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, final q qVar) {
        int i4;
        AppMethodBeat.i(22299);
        Log.i("MicroMsg.WXEntryActivity", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (!(qVar instanceof ac)) {
            AppMethodBeat.o(22299);
            return;
        }
        bg.azz().b(1200, this);
        if (this.msgType != 49) {
            cki();
        }
        if (i2 == 0 && i3 == 0) {
            ac acVar = (ac) qVar;
            if (acVar.bfD() != null) {
                i4 = acVar.bfD().version;
            } else {
                i4 = 0;
            }
            Log.i("MicroMsg.WXEntryActivity", "server appversion = %d", Integer.valueOf(i4));
            g o = h.o(this.appId, false, false);
            if (o == null) {
                Log.e("MicroMsg.WXEntryActivity", "null appinfo");
                a.C1616a.eAZ().aJz(this.appId);
            } else {
                int i5 = o.field_appVersion;
                Log.i("MicroMsg.WXEntryActivity", "local appversion = %d", Integer.valueOf(i5));
                if (i5 < i4) {
                    a.C1616a.eAZ().aJz(this.appId);
                }
            }
            if (this.msgType == 49) {
                d.a aVar = new d.a();
                aVar.iLN = new aew();
                aVar.iLO = new aex();
                aVar.uri = "/cgi-bin/micromsg-bin/decryptwxworkchatrecord";
                aVar.funcId = 3869;
                com.tencent.mm.ak.d aXF = aVar.aXF();
                aew aew = (aew) aXF.iLK.iLR;
                byte[] bArr = ((WXWeWorkObject) this.pez.mediaObject).data;
                if (bArr == null || bArr.length == 0) {
                    cki();
                    fa("", "");
                    AppMethodBeat.o(22299);
                    return;
                }
                aew.Lqh = b.cD(bArr);
                aa.a(aXF, new aa.a() {
                    /* class com.tencent.mm.plugin.base.stub.WXEntryActivity.AnonymousClass6 */

                    @Override // com.tencent.mm.ak.aa.a
                    public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
                        AppMethodBeat.i(169741);
                        if (WXEntryActivity.this.peA.get() == null || ((WXEntryActivity) WXEntryActivity.this.peA.get()).isFinishing()) {
                            AppMethodBeat.o(169741);
                        } else {
                            WXEntryActivity.e((WXEntryActivity) WXEntryActivity.this.peA.get());
                            if (i2 == 0 && i3 == 0) {
                                WXEntryActivity.a((WXEntryActivity) WXEntryActivity.this.peA.get(), qVar, dVar);
                                AppMethodBeat.o(169741);
                            } else {
                                WXEntryActivity.a((WXEntryActivity) WXEntryActivity.this.peA.get(), i2, i3, str);
                                AppMethodBeat.o(169741);
                            }
                        }
                        return 0;
                    }
                });
                AppMethodBeat.o(22299);
                return;
            }
            f(qVar);
            AppMethodBeat.o(22299);
            return;
        }
        r(i2, i3, str);
        AppMethodBeat.o(22299);
    }

    private void r(int i2, int i3, String str) {
        AppMethodBeat.i(22300);
        if (z.a.a(this, i2, i3, null, 4)) {
            Log.i("MicroMsg.WXEntryActivity", "mm error processor process this errcode");
            finish();
            AppMethodBeat.o(22300);
        } else if (com.tencent.mm.kernel.a.azj()) {
            Log.w("MicroMsg.WXEntryActivity", "account is hold, do finish");
            finish();
            AppMethodBeat.o(22300);
        } else {
            fa(str, "");
            AppMethodBeat.o(22300);
        }
    }

    private void cki() {
        AppMethodBeat.i(22301);
        if (this.gtM != null && this.gtM.isShowing()) {
            this.gtM.dismiss();
        }
        AppMethodBeat.o(22301);
    }

    private void fa(String str, String str2) {
        Map<String, String> parseXml;
        AppMethodBeat.i(231627);
        CF(getResources().getColor(R.color.a2h));
        cki();
        findViewById(R.id.hd0).setVisibility(0);
        setMMTitle(R.string.h0q);
        TextView textView = (TextView) findViewById(R.id.hpy);
        TextView textView2 = (TextView) findViewById(R.id.hpx);
        if (!af.isNullOrNil(str)) {
            if (str.startsWith("autoauth_errmsg_")) {
                str = str.substring(16);
            }
            if (str.startsWith("<e>") && (parseXml = XmlParser.parseXml(str, "e", null)) != null && !af.isNullOrNil(parseXml.get(".e.Content"))) {
                str = parseXml.get(".e.Content");
            }
            if (!Util.isNullOrNil(str)) {
                textView.setText(str);
            }
        }
        if (!Util.isNullOrNil(str2)) {
            textView2.setVisibility(0);
            textView2.setText(str2);
        } else {
            textView2.setVisibility(8);
        }
        Button button = (Button) findViewById(R.id.y0);
        String ckj = ckj();
        Log.i("MicroMsg.WXEntryActivity", "appName = %s", ckj);
        if (!af.isNullOrNil(ckj)) {
            button.setText(getString(R.string.h0o) + ckj);
        } else {
            button.setText(R.string.h0o);
        }
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.base.stub.WXEntryActivity.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(169742);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/base/stub/WXEntryActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WXEntryActivity.f(WXEntryActivity.this);
                WXEntryActivity.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/base/stub/WXEntryActivity$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(169742);
            }
        });
        AppMethodBeat.o(231627);
    }

    private String ckj() {
        AppMethodBeat.i(231628);
        if (com.tencent.mm.kernel.g.aAc()) {
            String r = h.r(this, this.appId);
            AppMethodBeat.o(231628);
            return r;
        }
        AppMethodBeat.o(231628);
        return "";
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(22303);
        if (keyEvent.getRepeatCount() == 0 && keyEvent.getKeyCode() == 4) {
            Log.i("MicroMsg.WXEntryActivity", "user click back button");
            goBack();
            AppMethodBeat.o(22303);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(22303);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(22304);
        View findViewById = findViewById(R.id.hd0);
        if (findViewById == null || findViewById.getVisibility() == 8) {
            ckk();
            AppMethodBeat.o(22304);
            return;
        }
        ckl();
        AppMethodBeat.o(22304);
    }

    private void ckk() {
        AppMethodBeat.i(22305);
        ReportUtil.a(this, ReportUtil.d(IntentUtil.getExtras(getIntent()), -2));
        finish();
        AppMethodBeat.o(22305);
    }

    private void ckl() {
        AppMethodBeat.i(22306);
        ReportUtil.a(this, ReportUtil.d(IntentUtil.getExtras(getIntent()), -6), false);
        finish();
        AppMethodBeat.o(22306);
    }

    private void ckm() {
        AppMethodBeat.i(169744);
        ReportUtil.a(this, ReportUtil.d(IntentUtil.getExtras(getIntent()), -1), false);
        finish();
        AppMethodBeat.o(169744);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AutoLoginActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(22307);
        super.onDestroy();
        bg.azz().b(1200, this);
        cki();
        AppMethodBeat.o(22307);
    }

    static /* synthetic */ void a(WXEntryActivity wXEntryActivity, q qVar, com.tencent.mm.ak.d dVar) {
        AppMethodBeat.i(169749);
        aex aex = (aex) dVar.iLL.iLR;
        if (aex == null || af.isNullOrNil(aex.content)) {
            wXEntryActivity.fa("", "");
            AppMethodBeat.o(169749);
            return;
        }
        ad.aVe().G("kWXEntryActivity_data_center_session_id", true).l("kWXEntryActivity_data_center_wework_msgcontent", aex.content);
        wXEntryActivity.f(qVar);
        AppMethodBeat.o(169749);
    }
}
