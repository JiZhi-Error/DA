package com.tencent.mm.plugin.nfc_open.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.view.MenuItem;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.nfc_open.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.protocal.protobuf.ctt;
import com.tencent.mm.protocal.protobuf.tx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.Iterator;
import java.util.regex.Pattern;

public class NfcWebViewUI extends WebViewUI {
    private static final String AEo = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2f) + "/security/readtemplate?t=bus_recharge/index_error");
    private String AEp = null;
    private boolean AEq = false;
    private a AEr = new a();

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public NfcWebViewUI() {
        AppMethodBeat.i(26698);
        AppMethodBeat.o(26698);
    }

    static /* synthetic */ void b(NfcWebViewUI nfcWebViewUI) {
        AppMethodBeat.i(26716);
        nfcWebViewUI.exD();
        AppMethodBeat.o(26716);
    }

    static {
        AppMethodBeat.i(231766);
        AppMethodBeat.o(231766);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(26699);
        Intent intent = getIntent();
        if (aN(intent)) {
            Log.e("MicroMsg.NfcWebViewUI", "onCreate judgeIllegalCall finish");
            try {
                intent.putExtra("key_trust_url", false);
            } catch (Exception e2) {
            }
            super.onCreate(bundle);
            finish();
            AppMethodBeat.o(26699);
            return;
        }
        intent.putExtra("key_trust_url", false);
        super.onCreate(bundle);
        EventCenter.instance.addListener(this.AEr);
        c.gsX();
        Log.i("MicroMsg.NfcWebViewUI", "onCreate, intent action = " + intent.getAction());
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(26695);
                if (NfcWebViewUI.this.AEq) {
                    NfcWebViewUI.b(NfcWebViewUI.this);
                } else {
                    NfcWebViewUI.this.finish();
                }
                AppMethodBeat.o(26695);
                return true;
            }
        });
        getIntent().putExtra("showShare", false);
        zj(false);
        AppMethodBeat.o(26699);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    @TargetApi(11)
    public void onDestroy() {
        AppMethodBeat.i(26700);
        super.onDestroy();
        EventCenter.instance.removeListener(this.AEr);
        AppMethodBeat.o(26700);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final void bXg() {
        AppMethodBeat.i(26701);
        super.bXg();
        if (exA()) {
            finish();
            Log.w("MicroMsg.NfcWebViewUI", "not login, go to SimpleLogin");
            AppMethodBeat.o(26701);
            return;
        }
        a(AutoLoginActivity.a.LOGIN_OK, getIntent());
        su(false);
        AppMethodBeat.o(26701);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(26702);
        if (aN(intent)) {
            Log.e("MicroMsg.NfcWebViewUI", "onNewIntent judgeIllegalCall finish");
            AppMethodBeat.o(26702);
            return;
        }
        intent.putExtra("key_trust_url", false);
        super.onNewIntent(intent);
        String coX = coX();
        setIntent(intent);
        if (!Util.isNullOrNil(coX) && Util.isNullOrNil(coX())) {
            intent.putExtra("rawUrl", coX);
        }
        int intExtra = IntentUtil.getIntExtra(intent, "wizard_activity_result_code", Integer.MAX_VALUE);
        Log.i("MicroMsg.NfcWebViewUI", "onNewIntent, resultCode = ".concat(String.valueOf(intExtra)));
        if (intExtra != Integer.MAX_VALUE) {
            this.AEq = true;
        }
        switch (intExtra) {
            case -1:
                a(AutoLoginActivity.a.LOGIN_OK, intent);
                break;
            case 0:
                exA();
                AppMethodBeat.o(26702);
                return;
            case 1:
                a(AutoLoginActivity.a.LOGIN_CANCEL, intent);
                break;
        }
        su(true);
        Log.i("Foreground dispatch", "Discovered tag with intent: ".concat(String.valueOf(intent)));
        AppMethodBeat.o(26702);
    }

    private boolean exA() {
        AppMethodBeat.i(26703);
        try {
            if (this.mHh.gei()) {
                Log.w("MicroMsg.NfcWebViewUI", "not login");
                Intent intent = new Intent(this, getClass());
                intent.putExtras(getIntent());
                intent.addFlags(67108864);
                this.mHh.bm(intent);
                AppMethodBeat.o(26703);
                return true;
            }
            AppMethodBeat.o(26703);
            return false;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.NfcWebViewUI", e2, "", new Object[0]);
            AppMethodBeat.o(26703);
            return true;
        }
    }

    private void a(AutoLoginActivity.a aVar, Intent intent) {
        Tag tag;
        AppMethodBeat.i(26704);
        switch (aVar) {
            case LOGIN_OK:
                Parcelable parcelableExtra = IntentUtil.getParcelableExtra(intent, "android.nfc.extra.TAG");
                if (parcelableExtra == null || !(parcelableExtra instanceof Tag)) {
                    tag = null;
                } else {
                    tag = (Tag) parcelableExtra;
                }
                if (tag == null) {
                    Log.e("MicroMsg.NfcWebViewUI", "[NFC]tag is null");
                    AppMethodBeat.o(26704);
                    return;
                }
                try {
                    com.tencent.mm.plugin.nfc.b.a.a.exw().a(tag);
                    Log.i("MicroMsg.NfcWebViewUI", "[NFC] connect status : ".concat(String.valueOf(com.tencent.mm.plugin.nfc.b.a.a.exw().gJ(getContext()))));
                    AppMethodBeat.o(26704);
                    return;
                } catch (Exception e2) {
                    Log.e("MicroMsg.NfcWebViewUI", "exp protect");
                    AppMethodBeat.o(26704);
                    return;
                }
            default:
                finish();
                AppMethodBeat.o(26704);
                return;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00d1, code lost:
        if (r2.equals(r3) != false) goto L_0x00d3;
     */
    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void su(boolean r9) {
        /*
        // Method dump skipped, instructions count: 267
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI.su(boolean):void");
    }

    private boolean exB() {
        AppMethodBeat.i(26706);
        boolean startsWith = coX().startsWith(AEo);
        AppMethodBeat.o(26706);
        return startsWith;
    }

    private static String TI(int i2) {
        String str;
        AppMethodBeat.i(26707);
        StringBuilder sb = new StringBuilder(AEo);
        sb.append("&type=").append(i2);
        if (!ChannelUtil.isNokiaAol && LocaleUtil.getApplicationLanguage().equals(LocaleUtil.CHINA)) {
            str = LocaleUtil.CHINA;
        } else if (LocaleUtil.isTraditionalChineseAppLang()) {
            str = LocaleUtil.TAIWAN;
        } else {
            str = LocaleUtil.ENGLISH;
        }
        sb.append("&lang=").append(str);
        String sb2 = sb.toString();
        AppMethodBeat.o(26707);
        return sb2;
    }

    private String exC() {
        String str = null;
        AppMethodBeat.i(26708);
        Log.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl start");
        try {
            Bundle j2 = this.mHh.j(WearableStatusCodes.DUPLICATE_CAPABILITY, null);
            if (j2 == null) {
                Log.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl data is null");
                AppMethodBeat.o(26708);
                return str;
            }
            j2.setClassLoader(getClass().getClassLoader());
            String string = j2.getString("debugConfig");
            String string2 = j2.getString("config");
            if (string != null) {
                str = aIF(string);
            } else {
                str = aIG(string2);
            }
            Log.i("MicroMsg.NfcWebViewUI", "nfc-getNfcCpuCardGuideUrl targetUrl=" + Util.nullAsNil(str));
            AppMethodBeat.o(26708);
            return str;
        } catch (RemoteException e2) {
            Log.e("MicroMsg.NfcWebViewUI", e2.toString());
            Log.printErrStackTrace("MicroMsg.NfcWebViewUI", e2, "", new Object[0]);
        }
    }

    private String aIF(String str) {
        AppMethodBeat.i(26709);
        Log.i("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl start");
        this.AEp = "";
        try {
            String[] split = str.split(" ");
            if (split != null && split.length > 1) {
                boolean z = false;
                for (int i2 = 0; i2 < split.length - 1; i2 = i2 + 1 + 1) {
                    String str2 = split[i2];
                    String str3 = split[i2 + 1];
                    Log.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl cmd = " + str2 + " anwser = " + str3);
                    z = a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.c.a.hexStringToByteArray(str2)), str3);
                    if (!z) {
                        break;
                    }
                }
                if (z) {
                    this.AEp = split[split.length - 1];
                    Log.d("MicroMsg.NfcWebViewUI", "nfc-getDebugNfcCardGuideUrl tempurl = " + this.AEp);
                    String str4 = this.AEp;
                    AppMethodBeat.o(26709);
                    return str4;
                }
            }
            String str5 = this.AEp;
            AppMethodBeat.o(26709);
            return str5;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.NfcWebViewUI", e2, "", new Object[0]);
            Log.e("MicroMsg.NfcWebViewUI", "[NFC] Debug get nfc card type exception!" + e2.toString());
            Log.e("MicroMsg.NfcWebViewUI", "isConnect:".concat(String.valueOf(com.tencent.mm.plugin.nfc.b.a.a.exw().gI(getContext()))));
            this.AEp = TI(1);
            String str6 = this.AEp;
            AppMethodBeat.o(26709);
            return str6;
        }
    }

    private String aIG(String str) {
        boolean z;
        AppMethodBeat.i(26710);
        Log.i("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl start");
        this.AEp = "";
        ctt ctt = new ctt();
        if (!Util.isNullOrNil(str)) {
            try {
                ctt.parseFrom(str.getBytes(KindaConfigCacheStg.SAVE_CHARSET));
                if (ctt.Lps != null) {
                    boolean z2 = false;
                    for (int i2 = 0; i2 < ctt.Lps.size(); i2++) {
                        tx txVar = ctt.Lps.get(i2);
                        com.tencent.mm.plugin.nfc.b.a.a exw = com.tencent.mm.plugin.nfc.b.a.a.exw();
                        if (exw.AEi != null) {
                            exw.AEi.exx();
                        }
                        if (txVar != null && !Util.isNullOrNil(txVar.KBH) && !Util.isNullOrNil(txVar.Lch)) {
                            int i3 = 0;
                            boolean z3 = z2;
                            while (true) {
                                if (i3 >= txVar.Lch.size()) {
                                    z2 = z3;
                                    break;
                                }
                                if (!Util.isNullOrNil(txVar.Lch.get(i3).Lpv)) {
                                    int i4 = 0;
                                    while (true) {
                                        if (i4 >= txVar.Lch.get(i3).Lpv.size()) {
                                            z2 = z3;
                                            break;
                                        }
                                        if (txVar.Lch.get(i3).Lpv.get(i4) == null || Util.isNullOrNil(txVar.Lch.get(i3).Lpv.get(i4).Lmp) || Util.isNullOrNil(txVar.Lch.get(i3).Lpv.get(i4).yWF)) {
                                            z = z3;
                                        } else {
                                            String str2 = txVar.Lch.get(i3).Lpv.get(i4).Lmp;
                                            String str3 = txVar.Lch.get(i3).Lpv.get(i4).yWF;
                                            Log.d("MicroMsg.NfcWebViewUI", "nfc-getCommonNfcCardGuideUrl cmd = " + str2 + " anwser = " + str3);
                                            if (!a(new com.tencent.mm.plugin.nfc.a.a(com.tencent.mm.plugin.nfc.c.a.hexStringToByteArray(str2)), str3)) {
                                                z2 = false;
                                                break;
                                            }
                                            z = true;
                                        }
                                        i4++;
                                        z3 = z;
                                    }
                                    if (z2) {
                                        break;
                                    }
                                } else {
                                    z2 = z3;
                                }
                                i3++;
                                z3 = z2;
                            }
                            if (z2) {
                                final String str4 = txVar.KBH;
                                Log.i("MicroMsg.NfcWebViewUI", "doCardTypeReport start");
                                ThreadPool.post(new Runnable() {
                                    /* class com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI.AnonymousClass2 */

                                    public final void run() {
                                        AppMethodBeat.i(26696);
                                        h.INSTANCE.a(12794, str4, 0);
                                        Log.d("MicroMsg.NfcWebViewUI", "doCardTypeReport url = " + str4);
                                        AppMethodBeat.o(26696);
                                    }
                                }, getClass().getName());
                                String str5 = txVar.KBH;
                                AppMethodBeat.o(26710);
                                return str5;
                            }
                        }
                        z2 = z2;
                    }
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.NfcWebViewUI", e2, "", new Object[0]);
                Log.e("MicroMsg.NfcWebViewUI", "[NFC] Common get nfc card type exception!" + e2.toString());
                Log.e("MicroMsg.NfcWebViewUI", "isConnect:".concat(String.valueOf(com.tencent.mm.plugin.nfc.b.a.a.exw().gI(getContext()))));
                this.AEp = TI(1);
                String str6 = this.AEp;
                AppMethodBeat.o(26710);
                return str6;
            }
        }
        String str7 = this.AEp;
        AppMethodBeat.o(26710);
        return str7;
    }

    private static boolean a(com.tencent.mm.plugin.nfc.a.a aVar, String str) {
        AppMethodBeat.i(26711);
        Log.i("MicroMsg.NfcWebViewUI", "nfc-doCmd start");
        if (je(str, com.tencent.mm.plugin.nfc.b.a.a.exw().a(aVar).toString())) {
            AppMethodBeat.o(26711);
            return true;
        }
        AppMethodBeat.o(26711);
        return false;
    }

    private static boolean je(String str, String str2) {
        AppMethodBeat.i(26712);
        if (Util.isNullOrNil(str2)) {
            AppMethodBeat.o(26712);
            return false;
        }
        Log.d("MicroMsg.NfcWebViewUI", "nfc-judge mAnwser = " + Util.nullAsNil(str) + " resp = " + Util.nullAsNil(str2));
        if (Pattern.compile(str, 2).matcher(str2).find()) {
            AppMethodBeat.o(26712);
            return true;
        }
        AppMethodBeat.o(26712);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(26713);
        if (this.AEq) {
            exD();
            AppMethodBeat.o(26713);
            return;
        }
        super.onBackPressed();
        AppMethodBeat.o(26713);
    }

    private void exD() {
        AppMethodBeat.i(26714);
        Intent intent = new Intent();
        intent.addFlags(67108864);
        c.f(this, "com.tencent.mm.ui.LauncherUI", intent);
        finish();
        overridePendingTransition(R.anim.s, R.anim.di);
        Log.i("MicroMsg.NfcWebViewUI", "lo-nfc-setBackBtn:back click after login");
        AppMethodBeat.o(26714);
    }

    private static boolean aN(Intent intent) {
        Tag tag;
        AppMethodBeat.i(26715);
        if (intent == null) {
            Log.e("MicroMsg.NfcWebViewUI", "intent is null");
            AppMethodBeat.o(26715);
            return true;
        }
        try {
            Iterator<String> it = intent.getExtras().keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next != null && !next.startsWith("android.nfc")) {
                    Log.e("MicroMsg.NfcWebViewUI", "extra wrong key = ".concat(String.valueOf(next)));
                    it.remove();
                }
            }
            Parcelable parcelableExtra = IntentUtil.getParcelableExtra(intent, "android.nfc.extra.TAG");
            if (parcelableExtra == null || !(parcelableExtra instanceof Tag)) {
                tag = null;
            } else {
                tag = (Tag) parcelableExtra;
            }
            if (tag == null) {
                Log.e("MicroMsg.NfcWebViewUI", "tag is null");
                AppMethodBeat.o(26715);
                return true;
            }
            AppMethodBeat.o(26715);
            return false;
        } catch (Exception e2) {
            Log.e("MicroMsg.NfcWebViewUI", "judgeIllegalCall e:%s", e2);
            AppMethodBeat.o(26715);
            return true;
        }
    }
}
