package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.g.a.jh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.plugin.webview.model.ab;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.model.z;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.cue;
import com.tencent.mm.protocal.protobuf.cuh;
import com.tencent.mm.protocal.protobuf.dgt;
import com.tencent.mm.protocal.protobuf.dri;
import com.tencent.mm.protocal.protobuf.drk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

@com.tencent.mm.ui.base.a(3)
public final class SDKOAuthUI extends MMActivity implements i {
    private static int Jfb;
    private boolean IYZ;
    private boolean JeK = false;
    private SendAuth.Req JeZ;
    private int Jfa;
    private MTimerHandler Jfc;
    private a Jfd;
    private b Jfe;
    private com.tencent.mm.ui.widget.b.a Jff;
    private boolean Jfg;
    private aj Jfh;
    private boolean Jfi = true;
    private String Jfj;
    private int accountType = 2;
    private String edo;
    private q gxX;
    private String mAppId;
    private int ppd;
    private int ppe;
    private o.g pso = new o.g() {
        /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.AnonymousClass7 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(79738);
            SDKOAuthUI.r(SDKOAuthUI.this);
            AppMethodBeat.o(79738);
        }
    };
    private long startTime;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SDKOAuthUI() {
        AppMethodBeat.i(79760);
        AppMethodBeat.o(79760);
    }

    static /* synthetic */ void a(SDKOAuthUI sDKOAuthUI, int i2) {
        AppMethodBeat.i(79787);
        sDKOAuthUI.agb(i2);
        AppMethodBeat.o(79787);
    }

    static /* synthetic */ String baj(String str) {
        AppMethodBeat.i(79788);
        String aYG = aYG(str);
        AppMethodBeat.o(79788);
        return aYG;
    }

    static /* synthetic */ int d(SDKOAuthUI sDKOAuthUI) {
        AppMethodBeat.i(79786);
        int gew = sDKOAuthUI.gew();
        AppMethodBeat.o(79786);
        return gew;
    }

    static /* synthetic */ void n(SDKOAuthUI sDKOAuthUI) {
        AppMethodBeat.i(79792);
        sDKOAuthUI.gey();
        AppMethodBeat.o(79792);
    }

    static /* synthetic */ void q(SDKOAuthUI sDKOAuthUI) {
        AppMethodBeat.i(79794);
        sDKOAuthUI.bWL();
        AppMethodBeat.o(79794);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        String str;
        AppMethodBeat.i(79761);
        super.onCreate(bundle);
        g.azz().a(1346, this);
        g.azz().a(1388, this);
        g.azz().a(2700, this);
        g.azz().a(2543, this);
        g.azz().a(1137, this);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        ((TextView) findViewById(R.id.ea4)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(211044);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.SdkOAuthUI", "BackBtn click");
                com.tencent.mm.plugin.webview.k.b.INSTANCE.a(SDKOAuthUI.this.mAppId, SDKOAuthUI.this.startTime, 0, SDKOAuthUI.this.accountType, SDKOAuthUI.d(SDKOAuthUI.this), 1, 0);
                SDKOAuthUI.a(SDKOAuthUI.this, -2);
                SDKOAuthUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(211044);
            }
        });
        if (!g.aAc()) {
            Log.e("MicroMsg.SdkOAuthUI", "start, hasSetUin fail");
            Toast.makeText(this, (int) R.string.cn, 1).show();
            AppMethodBeat.o(79761);
            return;
        }
        this.IYZ = false;
        Intent intent = getIntent();
        this.JeK = intent.getBooleanExtra("auth_from_scan", false);
        this.startTime = System.currentTimeMillis();
        Log.i("MicroMsg.SdkOAuthUI", "init isFromQRCodeScan %b", Boolean.valueOf(this.JeK));
        if (this.JeK) {
            this.accountType = 3;
            this.edo = intent.getStringExtra("auth_raw_url");
            String str2 = this.edo;
            Log.i("MicroMsg.SdkOAuthUI", "doQRCodeOauthAuthorize url: %s", str2);
            bWL();
            g.azz().a(new z(str2), 0);
            this.Jfh = new aj(this, null, this.edo);
            com.tencent.mm.plugin.webview.k.b.INSTANCE.da(3, "");
            AppMethodBeat.o(79761);
            return;
        }
        Bundle extras = getIntent().getExtras();
        String string = extras.getString(ConstantsAPI.CONTENT);
        if (Util.isNullOrNil(string)) {
            Log.e("MicroMsg.SdkOAuthUI", "init content is nil");
            AppMethodBeat.o(79761);
            return;
        }
        this.mAppId = Uri.parse(string).getQueryParameter("appid");
        if (Util.isNullOrNil(this.mAppId)) {
            Log.i("MicroMsg.SdkOAuthUI", "parseAppId try case not sensitive, content:%s", string);
            this.mAppId = Uri.parse(string.toLowerCase()).getQueryParameter("appid");
        }
        String str3 = this.mAppId;
        com.tencent.mm.pluginsdk.model.app.g o = h.o(str3, false, false);
        if (o != null && Util.isNullOrNil(o.field_openId)) {
            Log.i("MicroMsg.SdkOAuthUI", "checkGetAppSetting appId: %s ", str3);
            jh jhVar = new jh();
            jhVar.dOa.appId = str3;
            EventCenter.instance.publish(jhVar);
        }
        this.JeZ = new SendAuth.Req(extras);
        com.tencent.mm.plugin.webview.k.b.INSTANCE.da(2, this.JeZ.extData);
        this.Jfh = new aj(this, this.mAppId, this.JeZ.transaction, this.JeZ.state, this.JeZ.extData);
        if (Util.isNullOrNil(this.JeZ.scope) || !this.JeZ.scope.contains("snsapi_wxaapp_info") || this.JeZ.scope.equals("snsapi_wxaapp_info")) {
            String str4 = this.mAppId;
            String str5 = this.JeZ.scope;
            String str6 = this.JeZ.state;
            String aYG = aYG(this.mAppId);
            Log.i("MicroMsg.SdkOAuthUI", "doSDKOauthAuthorize appid: %s, extData：%s", str4, this.JeZ.extData);
            bWL();
            if (Util.isNullOrNil(aYG)) {
                str = null;
            } else {
                Signature[] cj = com.tencent.mm.pluginsdk.model.app.q.cj(this, aYG);
                if (cj == null || cj.length == 0) {
                    Log.e("MicroMsg.SdkOAuthUI", "getSignature signatures failed");
                    str = null;
                } else {
                    str = com.tencent.mm.b.g.getMessageDigest(cj[0].toByteArray());
                }
            }
            g.azz().a(new ab(str4, str5, str6, aYG, str, this.JeZ.extData), 0);
            AppMethodBeat.o(79761);
            return;
        }
        cY(-1000, String.format(getContext().getResources().getString(R.string.j1k), "snsapi_wxaapp_info"));
        finish();
        AppMethodBeat.o(79761);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(79762);
        super.onResume();
        AppMethodBeat.o(79762);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(79763);
        super.onPause();
        AppMethodBeat.o(79763);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(79764);
        super.onDestroy();
        if (this.gxX != null) {
            this.gxX.dismiss();
        }
        if (this.Jfc != null) {
            this.Jfc.stopTimer();
        }
        g.azz().b(1388, this);
        g.azz().b(1346, this);
        g.azz().b(2700, this);
        g.azz().b(2543, this);
        g.azz().b(1137, this);
        AppMethodBeat.o(79764);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.bop;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(79765);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            com.tencent.mm.plugin.webview.k.b.INSTANCE.a(this.mAppId, this.startTime, 0, this.accountType, gew(), 1, 0);
            agb(-2);
            Log.i("MicroMsg.SdkOAuthUI", "key back click");
            finish();
            AppMethodBeat.o(79765);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(79765);
        return onKeyDown;
    }

    private void a(int i2, int i3, String str, final drk drk) {
        boolean z;
        AppMethodBeat.i(79766);
        Log.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        gep();
        if (i2 == 0 && i3 == 0) {
            Log.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd is_use_newpage %b", Boolean.valueOf(drk.Mzy));
            this.Jfj = drk.lHJ;
            if (drk.Mzu || drk.Mzv) {
                Log.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd direct login");
                c.a(this, com.tencent.mm.model.gdpr.a.OPENSDK, this.mAppId, new com.tencent.mm.model.gdpr.b() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.AnonymousClass8 */

                    @Override // com.tencent.mm.model.gdpr.b
                    public final void sx(int i2) {
                        AppMethodBeat.i(79739);
                        Log.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", Integer.valueOf(i2));
                        if (i2 == 1) {
                            SDKOAuthUI.a(SDKOAuthUI.this, -4);
                            com.tencent.mm.plugin.webview.k.b.INSTANCE.a(SDKOAuthUI.this.mAppId, SDKOAuthUI.this.startTime, 0, SDKOAuthUI.this.accountType, 0, 0, 0);
                            SDKOAuthUI.this.finish();
                            AppMethodBeat.o(79739);
                            return;
                        }
                        SDKOAuthUI.this.Jfh.a(ai.a.a(drk), SDKOAuthUI.this.JeZ.scope);
                        com.tencent.mm.plugin.webview.k.b.INSTANCE.a(SDKOAuthUI.this.mAppId, SDKOAuthUI.this.startTime, 1, SDKOAuthUI.this.accountType, 0, 0, 0);
                        AppMethodBeat.o(79739);
                    }
                });
                AppMethodBeat.o(79766);
            } else if (!drk.Mzy) {
                this.Jfi = false;
                TextView textView = (TextView) findViewById(R.id.sa);
                c.a aVar = new c.a();
                aVar.jbq = R.raw.native_oauth_default_head_img;
                com.tencent.mm.av.q.bcV().a(drk.Mzt, (ImageView) findViewById(R.id.f3095rx), aVar.bdv());
                textView.setText(l.b(this, drk.ixZ, textView.getTextSize()));
                this.Jfd = new a(this, drk.Mzs);
                ((ListView) findViewById(R.id.vw)).setAdapter((ListAdapter) this.Jfd);
                ((Button) findViewById(R.id.erp)).setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.AnonymousClass9 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(79741);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Log.i("MicroMsg.SdkOAuthUI", "accept go  MPGdprPolicyUtil.checkPolicy");
                        com.tencent.mm.model.gdpr.c.a(SDKOAuthUI.this, com.tencent.mm.model.gdpr.a.OPENSDK, SDKOAuthUI.this.mAppId, new com.tencent.mm.model.gdpr.b() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.AnonymousClass9.AnonymousClass1 */

                            @Override // com.tencent.mm.model.gdpr.b
                            public final void sx(int i2) {
                                AppMethodBeat.i(79740);
                                Log.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", Integer.valueOf(i2));
                                if (i2 == 1) {
                                    SDKOAuthUI.a(SDKOAuthUI.this, -4);
                                    com.tencent.mm.plugin.webview.k.b.INSTANCE.a(SDKOAuthUI.this.mAppId, SDKOAuthUI.this.startTime, 0, SDKOAuthUI.this.accountType, 1, 1, 0);
                                    SDKOAuthUI.this.finish();
                                    AppMethodBeat.o(79740);
                                } else if (drk.Mzw) {
                                    SDKOAuthUI.a(SDKOAuthUI.this, SDKOAuthUI.this.mAppId, SDKOAuthUI.this.JeZ.state, SDKOAuthUI.baj(SDKOAuthUI.this.mAppId), SDKOAuthUI.this.Jfd.gez());
                                    AppMethodBeat.o(79740);
                                } else {
                                    com.tencent.mm.plugin.webview.k.b.INSTANCE.a(SDKOAuthUI.this.mAppId, SDKOAuthUI.this.startTime, 1, SDKOAuthUI.this.accountType, 1, 1, 0);
                                    SDKOAuthUI.this.Jfh.a(ai.a.a(drk), SDKOAuthUI.this.JeZ.scope);
                                    AppMethodBeat.o(79740);
                                }
                            }
                        });
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(79741);
                    }
                });
                findViewById(R.id.h8v).setVisibility(0);
                AppMethodBeat.o(79766);
            } else if (aj.b(drk)) {
                TextView textView2 = (TextView) findViewById(R.id.vt);
                Iterator<cuh> it = drk.Mzs.iterator();
                while (it.hasNext()) {
                    cuh next = it.next();
                    if (next == null || (!"snsapi_userinfo".equals(next.scope) && !"snsapi_login".equals(next.scope) && !"group_sns_login".equals(next.scope))) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        textView2.setText(next.desc);
                    }
                }
                textView2.getPaint().setFakeBoldText(true);
                TextView textView3 = (TextView) findViewById(R.id.vu);
                if (!Util.isNullOrNil(drk.MUa)) {
                    textView3.setVisibility(0);
                    textView3.setText(drk.MUa);
                } else {
                    textView3.setVisibility(8);
                }
                c.a aVar2 = new c.a();
                aVar2.jbq = R.raw.native_oauth_default_head_img;
                aVar2.jbx = getResources().getDimension(R.dimen.aie);
                aVar2.iaT = true;
                com.tencent.mm.av.q.bcV().a(drk.Mzt, (ImageView) findViewById(R.id.fv5), aVar2.bdv());
                ((TextView) findViewById(R.id.fv8)).setText(drk.ixZ);
                ((Button) findViewById(R.id.err)).setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.AnonymousClass10 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(79742);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        SDKOAuthUI.a(SDKOAuthUI.this, drk);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(79742);
                    }
                });
                ((Button) findViewById(R.id.eru)).setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.AnonymousClass11 */

                    public final void onClick(View view) {
                        cuh cuh;
                        AppMethodBeat.i(79743);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        aj unused = SDKOAuthUI.this.Jfh;
                        cuh e2 = aj.e("snsapi_userinfo", drk.Mzs);
                        if (e2 == null) {
                            aj unused2 = SDKOAuthUI.this.Jfh;
                            e2 = aj.e("snsapi_login", drk.Mzs);
                        }
                        if (e2 == null) {
                            aj unused3 = SDKOAuthUI.this.Jfh;
                            cuh = aj.e("group_sns_login", drk.Mzs);
                        } else {
                            cuh = e2;
                        }
                        com.tencent.mm.plugin.webview.k.b.INSTANCE.a(SDKOAuthUI.this.mAppId, SDKOAuthUI.this.startTime, 0, SDKOAuthUI.this.accountType, 2, 1, 0);
                        SDKOAuthUI.a(SDKOAuthUI.this, cuh, drk);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(79743);
                    }
                });
                Jfb = drk.lHG;
                this.Jff = new com.tencent.mm.ui.widget.b.a(this);
                this.Jfe = new b(this, drk.Mzx, drk.lHH);
                gex();
                ListView listView = (ListView) findViewById(R.id.x6);
                listView.setAdapter((ListAdapter) this.Jfe);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.AnonymousClass12 */

                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                        AppMethodBeat.i(79744);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(adapterView);
                        bVar.bm(view);
                        bVar.pH(i2);
                        bVar.zo(j2);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                        SDKOAuthUI.this.Jfe.Jfs = SDKOAuthUI.this.Jfe.agF(i2).id;
                        SDKOAuthUI.this.Jfe.notifyDataSetChanged();
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(79744);
                    }
                });
                listView.setOnTouchListener(new View.OnTouchListener() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.AnonymousClass13 */

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        AppMethodBeat.i(79745);
                        switch (motionEvent.getAction()) {
                            case 0:
                                SDKOAuthUI.this.ppd = (int) motionEvent.getRawX();
                                SDKOAuthUI.this.ppe = (int) motionEvent.getRawY();
                                break;
                        }
                        AppMethodBeat.o(79745);
                        return false;
                    }
                });
                listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.AnonymousClass14 */

                    @Override // android.widget.AdapterView.OnItemLongClickListener
                    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                        AppMethodBeat.i(79746);
                        SDKOAuthUI.this.Jfa = i2;
                        int i3 = SDKOAuthUI.this.Jfe.agF(i2).id;
                        if (!(i3 == 0 || i3 == 1)) {
                            SDKOAuthUI.this.Jff.a(view, i2, j2, SDKOAuthUI.this, SDKOAuthUI.this.pso, SDKOAuthUI.this.ppd, SDKOAuthUI.this.ppe);
                        }
                        AppMethodBeat.o(79746);
                        return true;
                    }
                });
                findViewById(R.id.bhz).setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.AnonymousClass15 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(79747);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        Intent intent = new Intent(SDKOAuthUI.this, CreateAvatarUI.class);
                        intent.putExtra(AppEventsConstants.EVENT_PARAM_VALUE_NO, SDKOAuthUI.this.mAppId);
                        intent.putExtra("default_fileid", SDKOAuthUI.this.Jfj);
                        SDKOAuthUI.this.startActivityForResult(intent, 6);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(79747);
                    }
                });
                this.Jfg = drk.lHF;
                if (drk.lHF) {
                    findViewById(R.id.bi1).setVisibility(8);
                }
                findViewById(R.id.fxh).setVisibility(0);
                AppMethodBeat.o(79766);
            } else if (aj.e("snsapi_friend", drk.Mzs) != null) {
                a(drk, SDKOAuthFriendUI.class, "snsapi_friend");
                aj.aT(this);
                AppMethodBeat.o(79766);
            } else if (aj.e("snsapi_wxaapp_info", drk.Mzs) != null) {
                a(drk, SDKOAuthFriendUI.class, "snsapi_wxaapp_info");
                aj.aT(this);
                AppMethodBeat.o(79766);
            } else {
                a(drk, SDKOAuthOtherUI.class, "");
                aj.aT(this);
                AppMethodBeat.o(79766);
            }
        } else if (!agc(i2)) {
            cQ(getString(R.string.j1j), true);
            com.tencent.mm.plugin.webview.k.b.INSTANCE.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, i3);
            AppMethodBeat.o(79766);
        } else {
            com.tencent.mm.plugin.webview.k.b.INSTANCE.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, i3);
            cQ(str, true);
            AppMethodBeat.o(79766);
        }
    }

    private int gew() {
        return this.Jfi ? 2 : 1;
    }

    private void agb(int i2) {
        LinkedList<String> linkedList = null;
        AppMethodBeat.i(79767);
        Log.i("MicroMsg.SdkOAuthUI", "dealWithCancel");
        if (this.JeK) {
            g.azz().a(new aa(2, this.edo, null, 0), 0);
            AppMethodBeat.o(79767);
        } else if (this.JeZ == null) {
            AppMethodBeat.o(79767);
        } else {
            String aYG = aYG(this.mAppId);
            String str = this.mAppId;
            String str2 = this.JeZ.state;
            if (this.Jfd != null) {
                linkedList = this.Jfd.gez();
            }
            g.azz().a(new ac(2, str, str2, aYG, linkedList, this.JeZ.extData), 0);
            SendAuth.Resp resp = new SendAuth.Resp();
            resp.transaction = this.JeZ.transaction;
            resp.errCode = i2;
            resp.lang = gcM();
            resp.country = getCountry();
            a(aYG, resp);
            AppMethodBeat.o(79767);
        }
    }

    private void cY(int i2, String str) {
        AppMethodBeat.i(79768);
        String aYG = aYG(this.mAppId);
        if (Util.isNullOrNil(aYG)) {
            Log.e("MicroMsg.SdkOAuthUI", "dealWithError pkg nil");
            AppMethodBeat.o(79768);
            return;
        }
        SendAuth.Resp resp = new SendAuth.Resp();
        resp.transaction = this.JeZ.transaction;
        resp.errCode = i2;
        resp.errStr = str;
        resp.lang = gcM();
        resp.country = getCountry();
        a(aYG, resp);
        AppMethodBeat.o(79768);
    }

    private void a(String str, SendAuth.Resp resp) {
        AppMethodBeat.i(79769);
        if (this.IYZ) {
            Log.i("MicroMsg.SdkOAuthUI", "doCallback has callback");
            AppMethodBeat.o(79769);
        } else if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(79769);
        } else {
            this.IYZ = true;
            Bundle bundle = new Bundle();
            resp.toBundle(bundle);
            com.tencent.mm.pluginsdk.model.app.q.bo(bundle);
            MMessageActV2.Args args = new MMessageActV2.Args();
            args.targetPkgName = str;
            args.bundle = bundle;
            MMessageActV2.send(this, args);
            AppMethodBeat.o(79769);
        }
    }

    private void a(drk drk, Class<?> cls, int i2, int i3) {
        AppMethodBeat.i(79770);
        a(drk, cls, i2, i3, "");
        AppMethodBeat.o(79770);
    }

    private void a(drk drk, Class<?> cls, int i2, int i3, String str) {
        AppMethodBeat.i(79771);
        Intent intent = new Intent(this, cls);
        intent.putExtra(AppEventsConstants.EVENT_PARAM_VALUE_NO, this.mAppId);
        if (this.JeZ != null) {
            intent.putExtra("1", this.JeZ.transaction);
            intent.putExtra("4", this.JeZ.state);
            intent.putExtra("7", this.JeZ.extData);
        }
        intent.putExtra(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, i2);
        intent.putExtra("5", i3);
        intent.putExtra("auth_from_scan", this.JeK);
        intent.putExtra("auth_raw_url", this.edo);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("auth_scope", str);
        }
        try {
            intent.putExtra("2", drk.toByteArray());
        } catch (IOException e2) {
            Log.e("MicroMsg.SdkOAuthUI", "SdkOauthAuthorizeResp toByteArray failed");
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;IILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;IILjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(79771);
    }

    private void a(drk drk, Class<?> cls, String str) {
        AppMethodBeat.i(79772);
        Log.i("MicroMsg.SdkOAuthUI", "startScopeActivity %s", cls.getSimpleName());
        Intent intent = new Intent(this, cls);
        intent.putExtra(AppEventsConstants.EVENT_PARAM_VALUE_NO, this.mAppId);
        if (this.JeZ != null) {
            intent.putExtra("1", this.JeZ.transaction);
            intent.putExtra("4", this.JeZ.state);
            intent.putExtra("7", this.JeZ.extData);
        }
        intent.putExtra("auth_from_scan", this.JeK);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("auth_scope", str);
        }
        intent.putExtra("auth_raw_url", this.edo);
        try {
            intent.putExtra("2", drk.toByteArray());
        } catch (IOException e2) {
            Log.e("MicroMsg.SdkOAuthUI", "SdkOauthAuthorizeResp toByteArray failed");
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(79772);
    }

    private void gex() {
        AppMethodBeat.i(79773);
        if (this.Jfg) {
            AppMethodBeat.o(79773);
        } else if (this.Jfe.getCount() >= Jfb) {
            findViewById(R.id.bhz).setVisibility(8);
            findViewById(R.id.j11).setVisibility(0);
            findViewById(R.id.j12).setVisibility(4);
            AppMethodBeat.o(79773);
        } else {
            findViewById(R.id.bhz).setVisibility(0);
            findViewById(R.id.j11).setVisibility(8);
            findViewById(R.id.j12).setVisibility(0);
            AppMethodBeat.o(79773);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(79774);
        Log.i("MicroMsg.SdkOAuthUI", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 != -1) {
            Log.e("MicroMsg.SdkOAuthUI", "Create avatar cancel or failed");
            AppMethodBeat.o(79774);
            return;
        }
        switch (i2) {
            case 6:
                cue cue = new cue();
                cue.id = intent.getIntExtra("id", -1);
                cue.nickname = intent.getStringExtra("nickname");
                cue.lHM = intent.getStringExtra("avatarurl");
                cue.desc = null;
                if (this.Jfe != null) {
                    b bVar = this.Jfe;
                    if (cue.id == -1 || bVar.Jfp == null || bVar.Jfp.size() >= Jfb) {
                        z = false;
                    } else {
                        bVar.Jfp.add(cue);
                        z = true;
                    }
                    if (z) {
                        this.Jfe.Jfs = cue.id;
                        gex();
                        this.Jfe.notifyDataSetChanged();
                        AppMethodBeat.o(79774);
                        return;
                    }
                }
                Object[] objArr = new Object[1];
                if (this.Jfe != null) {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                Log.e("MicroMsg.SdkOAuthUI", "onActivityResult mAvatarAdapter == null:%b", objArr);
                break;
        }
        AppMethodBeat.o(79774);
    }

    private void cQ(final String str, final boolean z) {
        AppMethodBeat.i(79775);
        com.tencent.mm.ui.base.h.d(this, str, getString(R.string.j1i), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(79734);
                if (!SDKOAuthUI.this.JeK) {
                    SDKOAuthUI.a(SDKOAuthUI.this, str);
                }
                if (z) {
                    SDKOAuthUI.this.finish();
                }
                AppMethodBeat.o(79734);
            }
        });
        AppMethodBeat.o(79775);
    }

    private void bai(String str) {
        AppMethodBeat.i(79776);
        com.tencent.mm.ui.base.h.c(this, str, getString(R.string.fc0), true);
        AppMethodBeat.o(79776);
    }

    private void bWL() {
        AppMethodBeat.i(79777);
        if (this.gxX == null || this.gxX.isShowing()) {
            this.gxX = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.fhx), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.AnonymousClass4 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(79735);
                    try {
                        dialogInterface.dismiss();
                        AppMethodBeat.o(79735);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.SdkOAuthUI", "showProgressDlg onCancel exp: %s ", e2.getLocalizedMessage());
                        AppMethodBeat.o(79735);
                    }
                }
            });
            AppMethodBeat.o(79777);
            return;
        }
        this.gxX.show();
        AppMethodBeat.o(79777);
    }

    private void gey() {
        AppMethodBeat.i(79778);
        gep();
        this.gxX = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.AnonymousClass5 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(79736);
                try {
                    dialogInterface.dismiss();
                    AppMethodBeat.o(79736);
                } catch (Exception e2) {
                    Log.e("MicroMsg.SdkOAuthUI", "showProgressDlg onCancel exp: %s ", e2.getLocalizedMessage());
                    AppMethodBeat.o(79736);
                }
            }
        });
        AppMethodBeat.o(79778);
    }

    private void gep() {
        AppMethodBeat.i(79779);
        if (this.gxX == null) {
            AppMethodBeat.o(79779);
            return;
        }
        this.gxX.dismiss();
        AppMethodBeat.o(79779);
    }

    private boolean agc(int i2) {
        AppMethodBeat.i(79780);
        if (i2 == 1 || i2 == 2 || i2 == 7 || i2 == 8) {
            Log.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, errType = ".concat(String.valueOf(i2)));
            AppMethodBeat.o(79780);
            return false;
        } else if (!NetStatusUtil.isConnected(this)) {
            Log.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, not connected");
            AppMethodBeat.o(79780);
            return false;
        } else {
            AppMethodBeat.o(79780);
            return true;
        }
    }

    private String gcM() {
        AppMethodBeat.i(79781);
        String loadApplicationLanguage = LocaleUtil.loadApplicationLanguage(getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this);
        AppMethodBeat.o(79781);
        return loadApplicationLanguage;
    }

    private static String getCountry() {
        AppMethodBeat.i(79782);
        String nullAs = Util.nullAs((String) g.aAh().azQ().get(274436, (Object) null), (String) null);
        AppMethodBeat.o(79782);
        return nullAs;
    }

    private static String aYG(String str) {
        AppMethodBeat.i(79783);
        String str2 = null;
        com.tencent.mm.pluginsdk.model.app.g o = h.o(str, false, false);
        if (o != null) {
            str2 = o.field_packageName;
        } else {
            Log.w("MicroMsg.SdkOAuthUI", "dealWithCancel getAppInfo null; appid: %s", str);
        }
        AppMethodBeat.o(79783);
        return str2;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        boolean remove;
        boolean z;
        drk drk;
        AppMethodBeat.i(79784);
        if (qVar instanceof ab) {
            a(i2, i3, str, (drk) ((ab) qVar).rr.iLL.iLR);
            com.tencent.mm.plugin.webview.k.b.INSTANCE.aO(3, (int) (System.currentTimeMillis() - this.startTime), i3);
        } else if (qVar instanceof ac) {
            Log.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            if (this.Jfc != null) {
                this.Jfc.stopTimer();
            }
            gep();
            if (i2 == 0 && i3 == 0) {
                dri gcA = ((ac) qVar).gcA();
                com.tencent.mm.plugin.webview.k.b.INSTANCE.a(this.mAppId, this.startTime, 1, this.accountType, gew(), 1, 0);
                this.Jfh.a(ai.a.a(gcA), this.JeZ.scope);
            } else if (!agc(i2)) {
                cQ(getString(R.string.j1j), false);
                com.tencent.mm.plugin.webview.k.b.INSTANCE.a(this.mAppId, this.startTime, 2, this.accountType, gew(), 1, i3);
            } else {
                cQ(str, false);
                com.tencent.mm.plugin.webview.k.b.INSTANCE.a(this.mAppId, this.startTime, 2, this.accountType, gew(), 1, i3);
            }
        } else if (qVar instanceof com.tencent.mm.modelsimple.h) {
            Log.i("MicroMsg.SdkOAuthUI", "onAddAvatarEnd errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            if (i2 == 0 && i3 == 0) {
                if (this.Jfe.agF(this.Jfa).id == this.Jfe.Jfs) {
                    this.Jfe.Jfs = this.Jfe.agF(0).id;
                }
                b bVar = this.Jfe;
                int i4 = this.Jfa;
                if (bVar.Jfp == null) {
                    remove = false;
                } else {
                    remove = bVar.Jfp.remove(bVar.agF(i4));
                }
                if (!remove) {
                    Log.e("MicroMsg.SdkOAuthUI", "remove avatar failed: not found");
                }
                gex();
                this.Jfe.notifyDataSetChanged();
            } else if (!agc(i2)) {
                bai(getString(R.string.j1j));
            } else {
                bai(str);
            }
        }
        if (qVar instanceof z) {
            Log.i("MicroMsg.SdkOAuthUI", "onQRCodeOauthAuthorizeEnd errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            if (i2 == 0 && i3 == 0) {
                dgt dgt = (dgt) ((z) qVar).rr.iLL.iLR;
                this.mAppId = dgt.dNI;
                this.Jfh.mAppId = dgt.dNI;
                if (dgt.MLk) {
                    Log.i("MicroMsg.SdkOAuthUI", "fallback to h5");
                    com.tencent.mm.plugin.webview.k.b.INSTANCE.a(this.mAppId, this.startTime, 1, this.accountType, 0, 0, i3);
                    com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", getIntent());
                    aj.aT(this);
                    z = true;
                } else {
                    if (dgt == null) {
                        drk = null;
                    } else {
                        drk drk2 = new drk();
                        drk2.BaseResponse = dgt.BaseResponse;
                        drk2.Mzu = false;
                        drk2.Mzv = false;
                        drk2.Mzy = true;
                        drk2.Mzw = false;
                        drk2.Mzs = dgt.Mzs;
                        drk2.ixZ = dgt.ixZ;
                        drk2.Mzt = dgt.Mzt;
                        drk2.KJw = "";
                        drk2.Mzx = dgt.Mzx;
                        drk2.lHF = dgt.lHF;
                        drk2.lHG = dgt.lHG;
                        drk2.lHH = dgt.lHH;
                        drk2.lHI = dgt.lHI;
                        drk2.lHJ = dgt.lHJ;
                        drk = drk2;
                    }
                    a(i2, i3, str, drk);
                    z = false;
                }
            } else if (!agc(i2)) {
                cQ(getString(R.string.j1j), true);
                com.tencent.mm.plugin.webview.k.b.INSTANCE.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, i3);
                z = false;
            } else {
                com.tencent.mm.plugin.webview.k.b.INSTANCE.a(this.mAppId, this.startTime, 2, this.accountType, 0, 0, i3);
                cQ(str, true);
                z = false;
            }
            if (!z) {
                gep();
            }
            com.tencent.mm.plugin.webview.k.b.INSTANCE.aO(3, (int) (System.currentTimeMillis() - this.startTime), i3);
        } else if (qVar instanceof aa) {
            Log.i("MicroMsg.SdkOAuthUI", "onQRCodeOauthAuthorizeConfirmEnd errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            gep();
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.plugin.webview.k.b.INSTANCE.a(this.mAppId, this.startTime, 1, this.accountType, gew(), 1, 0);
                finish();
            } else if (!agc(i2)) {
                cQ(getString(R.string.j1j), false);
                com.tencent.mm.plugin.webview.k.b.INSTANCE.a(this.mAppId, this.startTime, 2, this.accountType, gew(), 1, i3);
            } else {
                cQ(str, false);
                com.tencent.mm.plugin.webview.k.b.INSTANCE.a(this.mAppId, this.startTime, 2, this.accountType, gew(), 1, i3);
            }
        }
        gep();
        AppMethodBeat.o(79784);
    }

    /* access modifiers changed from: package-private */
    public static final class b extends BaseAdapter {
        LinkedList<cue> Jfp;
        private c.a Jfq;
        private Context Jfr;
        private int Jfs;
        private LayoutInflater mInflater;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(79759);
            cue agF = agF(i2);
            AppMethodBeat.o(79759);
            return agF;
        }

        public b(Context context, LinkedList<cue> linkedList, int i2) {
            AppMethodBeat.i(79755);
            this.Jfr = context;
            this.mInflater = LayoutInflater.from(context);
            this.Jfp = linkedList;
            if (this.Jfp == null) {
                this.Jfp = new LinkedList<>();
            }
            Log.i("MicroMsg.SdkOAuthUI", "LoginAvatarListAdapter avatars size:%d", Integer.valueOf(this.Jfp.size()));
            this.Jfq = new c.a();
            this.Jfq.jbq = R.raw.native_oauth_default_head_img;
            c.a aVar = this.Jfq;
            aVar.iaT = true;
            aVar.jbx = this.Jfr.getResources().getDimension(R.dimen.aid);
            this.Jfs = i2;
            AppMethodBeat.o(79755);
        }

        public final int getCount() {
            AppMethodBeat.i(79756);
            if (this.Jfp == null) {
                AppMethodBeat.o(79756);
                return 0;
            }
            int size = this.Jfp.size();
            AppMethodBeat.o(79756);
            return size;
        }

        public final cue agF(int i2) {
            AppMethodBeat.i(79757);
            if (this.Jfp == null || i2 < 0 || i2 >= this.Jfp.size()) {
                AppMethodBeat.o(79757);
                return null;
            }
            cue cue = this.Jfp.get(i2);
            AppMethodBeat.o(79757);
            return cue;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(79758);
            cue agF = agF(i2);
            if (agF == null) {
                AppMethodBeat.o(79758);
            } else {
                if (view == null) {
                    a aVar2 = new a((byte) 0);
                    view = this.mInflater.inflate(R.layout.hj, (ViewGroup) null, false);
                    aVar2.Jft = (ImageView) view.findViewById(R.id.wy);
                    aVar2.Jfu = (TextView) view.findViewById(R.id.x7);
                    aVar2.Jfv = (TextView) view.findViewById(R.id.wu);
                    aVar2.Jfw = (ImageView) view.findViewById(R.id.x_);
                    view.setTag(aVar2);
                    aVar = aVar2;
                } else {
                    aVar = (a) view.getTag();
                }
                aVar.Jfu.setText(l.b(this.Jfr, agF.nickname, aVar.Jfu.getTextSize()));
                com.tencent.mm.av.q.bcV().a(agF.lHM, aVar.Jft, this.Jfq.bdv());
                if (agF.desc != null) {
                    aVar.Jfv.setText(agF.desc);
                    aVar.Jfv.setVisibility(0);
                } else {
                    aVar.Jfv.setVisibility(8);
                }
                if (agF.id == this.Jfs) {
                    aVar.Jfw.setVisibility(0);
                } else {
                    aVar.Jfw.setVisibility(4);
                }
                AppMethodBeat.o(79758);
            }
            return view;
        }

        static final class a {
            ImageView Jft;
            TextView Jfu;
            TextView Jfv;
            ImageView Jfw;

            private a() {
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(79785);
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        contextMenu.add(0, 1, 0, getString(R.string.fbz));
        AppMethodBeat.o(79785);
    }

    /* access modifiers changed from: package-private */
    public static final class a extends BaseAdapter {
        private LinkedList<cuh> JeV;
        private LayoutInflater mInflater;

        public final /* synthetic */ Object getItem(int i2) {
            AppMethodBeat.i(79754);
            cuh agE = agE(i2);
            AppMethodBeat.o(79754);
            return agE;
        }

        public a(Context context, LinkedList<cuh> linkedList) {
            AppMethodBeat.i(79749);
            this.mInflater = LayoutInflater.from(context);
            this.JeV = linkedList;
            AppMethodBeat.o(79749);
        }

        public final LinkedList<String> gez() {
            AppMethodBeat.i(79750);
            LinkedList<String> linkedList = new LinkedList<>();
            for (int i2 = 0; i2 < this.JeV.size(); i2++) {
                cuh cuh = this.JeV.get(i2);
                if (cuh.MzA == 2 || cuh.MzA == 3) {
                    linkedList.add(cuh.scope);
                }
            }
            AppMethodBeat.o(79750);
            return linkedList;
        }

        public final int getCount() {
            AppMethodBeat.i(79751);
            if (this.JeV == null) {
                AppMethodBeat.o(79751);
                return 0;
            }
            int size = this.JeV.size();
            AppMethodBeat.o(79751);
            return size;
        }

        private cuh agE(int i2) {
            AppMethodBeat.i(79752);
            if (i2 < 0 || i2 >= this.JeV.size()) {
                AppMethodBeat.o(79752);
                return null;
            }
            cuh cuh = this.JeV.get(i2);
            AppMethodBeat.o(79752);
            return cuh;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1975a aVar;
            AppMethodBeat.i(79753);
            if (this.JeV == null || this.JeV.size() <= 0) {
                AppMethodBeat.o(79753);
                return null;
            }
            final cuh agE = agE(i2);
            if (agE == null) {
                AppMethodBeat.o(79753);
                return view;
            }
            if (view == null) {
                C1975a aVar2 = new C1975a((byte) 0);
                view = this.mInflater.inflate(R.layout.bon, (ViewGroup) null, false);
                aVar2.JeY = (ImageView) view.findViewById(R.id.n8);
                aVar2.oqe = (TextView) view.findViewById(R.id.n7);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C1975a) view.getTag();
            }
            if (agE.MzA == 1) {
                aVar.JeY.setImageResource(R.raw.login_auth_state_not_selected);
            } else if (agE.MzA == 3) {
                aVar.JeY.setImageResource(R.raw.login_auth_state_must_select);
            } else {
                aVar.JeY.setImageResource(R.raw.login_auth_state_default_select);
            }
            aVar.oqe.setText(agE.desc);
            final ImageView imageView = aVar.JeY;
            aVar.JeY.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.a.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(79748);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (agE.MzA == 2) {
                        imageView.setImageResource(R.raw.login_auth_state_not_selected);
                        agE.MzA = 1;
                    } else if (agE.MzA == 1) {
                        imageView.setImageResource(R.raw.login_auth_state_default_select);
                        agE.MzA = 2;
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthUI$LoginAuthListAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(79748);
                }
            });
            AppMethodBeat.o(79753);
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI$a$a  reason: collision with other inner class name */
        static final class C1975a {
            ImageView JeY;
            TextView oqe;

            private C1975a() {
            }

            /* synthetic */ C1975a(byte b2) {
                this();
            }
        }
    }

    static /* synthetic */ void a(SDKOAuthUI sDKOAuthUI, String str, String str2, String str3, LinkedList linkedList) {
        AppMethodBeat.i(79789);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            sb.append((String) linkedList.get(i2)).append(",");
        }
        Log.i("MicroMsg.SdkOAuthUI", "doSDKOauthAuthorizeConfirm selectedScopes: %s", sb.toString());
        if (sDKOAuthUI.Jfc != null) {
            sDKOAuthUI.Jfc.stopTimer();
            sDKOAuthUI.Jfc.startTimer(3000);
        } else {
            sDKOAuthUI.Jfc = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.AnonymousClass6 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(79737);
                    if (SDKOAuthUI.this.isFinishing()) {
                        Log.i("MicroMsg.SdkOAuthUI", "onTimerExpired isFinishing");
                        AppMethodBeat.o(79737);
                    } else {
                        SDKOAuthUI.q(SDKOAuthUI.this);
                        AppMethodBeat.o(79737);
                    }
                    return false;
                }
            }, false);
            sDKOAuthUI.Jfc.startTimer(3000);
        }
        g.azz().a(new ac(1, str, str2, str3, linkedList, sDKOAuthUI.JeZ.extData), 0);
        AppMethodBeat.o(79789);
    }

    static /* synthetic */ void a(SDKOAuthUI sDKOAuthUI, final drk drk) {
        AppMethodBeat.i(79790);
        if (drk.Mzs.size() == 1) {
            Log.i("MicroMsg.SdkOAuthUI", "accept go  MPGdprPolicyUtil.checkPolicy");
            com.tencent.mm.model.gdpr.c.a(sDKOAuthUI, com.tencent.mm.model.gdpr.a.OPENSDK, sDKOAuthUI.mAppId, new com.tencent.mm.model.gdpr.b() {
                /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.AnonymousClass2 */

                @Override // com.tencent.mm.model.gdpr.b
                public final void sx(int i2) {
                    AppMethodBeat.i(79733);
                    Log.i("MicroMsg.SdkOAuthUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", Integer.valueOf(i2));
                    if (i2 == 1) {
                        SDKOAuthUI.a(SDKOAuthUI.this, -4);
                        com.tencent.mm.plugin.webview.k.b.INSTANCE.a(SDKOAuthUI.this.mAppId, SDKOAuthUI.this.startTime, 0, SDKOAuthUI.this.accountType, 2, 1, 0);
                        SDKOAuthUI.this.finish();
                        AppMethodBeat.o(79733);
                        return;
                    }
                    LinkedList<String> linkedList = new LinkedList<>();
                    aj unused = SDKOAuthUI.this.Jfh;
                    aj.a(drk, linkedList);
                    SDKOAuthUI.n(SDKOAuthUI.this);
                    if (SDKOAuthUI.this.JeK) {
                        aj unused2 = SDKOAuthUI.this.Jfh;
                        aj.a(linkedList, SDKOAuthUI.this.Jfe.Jfs, SDKOAuthUI.this.edo);
                        AppMethodBeat.o(79733);
                        return;
                    }
                    SDKOAuthUI.this.Jfh.k(linkedList, SDKOAuthUI.this.Jfe.Jfs);
                    AppMethodBeat.o(79733);
                }
            });
            AppMethodBeat.o(79790);
        } else if (aj.e("snsapi_friend", drk.Mzs) != null) {
            com.tencent.mm.plugin.webview.k.b.INSTANCE.a(sDKOAuthUI.mAppId, sDKOAuthUI.startTime, 1, sDKOAuthUI.accountType, 2, 1, 0);
            sDKOAuthUI.a(drk, SDKOAuthFriendUI.class, sDKOAuthUI.Jfe.Jfs, 7, "snsapi_friend");
            aj.aT(sDKOAuthUI);
            AppMethodBeat.o(79790);
        } else if (aj.e("snsapi_wxaapp_info", drk.Mzs) != null) {
            sDKOAuthUI.a(drk, SDKOAuthFriendUI.class, -1, 8, "snsapi_wxaapp_info");
            aj.aT(sDKOAuthUI);
            AppMethodBeat.o(79790);
        } else {
            com.tencent.mm.plugin.webview.k.b.INSTANCE.a(sDKOAuthUI.mAppId, sDKOAuthUI.startTime, 1, sDKOAuthUI.accountType, 2, 1, 0);
            sDKOAuthUI.a(drk, SDKOAuthOtherUI.class, sDKOAuthUI.Jfe.Jfs, 7);
            aj.aT(sDKOAuthUI);
            AppMethodBeat.o(79790);
        }
    }

    static /* synthetic */ void a(SDKOAuthUI sDKOAuthUI, cuh cuh, drk drk) {
        AppMethodBeat.i(79791);
        if (cuh == null) {
            Log.e("MicroMsg.SdkOAuthUI", "fillNewOauthPage: do not get scope request for user info");
            AppMethodBeat.o(79791);
            return;
        }
        Log.i("MicroMsg.SdkOAuthUI", "disagreeBtnCallback click");
        if (cuh.MzA == 3 || drk.Mzs.size() == 1) {
            sDKOAuthUI.agb(-4);
            sDKOAuthUI.finish();
            AppMethodBeat.o(79791);
        } else if (aj.e("snsapi_friend", drk.Mzs) != null) {
            sDKOAuthUI.a(drk, SDKOAuthFriendUI.class, -1, 8, "snsapi_friend");
            aj.aT(sDKOAuthUI);
            AppMethodBeat.o(79791);
        } else if (aj.e("snsapi_wxaapp_info", drk.Mzs) != null) {
            sDKOAuthUI.a(drk, SDKOAuthFriendUI.class, -1, 8, "snsapi_wxaapp_info");
            aj.aT(sDKOAuthUI);
            AppMethodBeat.o(79791);
        } else {
            sDKOAuthUI.a(drk, SDKOAuthOtherUI.class, -1, 8);
            aj.aT(sDKOAuthUI);
            AppMethodBeat.o(79791);
        }
    }

    static /* synthetic */ void a(SDKOAuthUI sDKOAuthUI, String str) {
        AppMethodBeat.i(79793);
        sDKOAuthUI.cY(-1, str);
        AppMethodBeat.o(79793);
    }

    static /* synthetic */ void r(SDKOAuthUI sDKOAuthUI) {
        AppMethodBeat.i(79795);
        Log.i("MicroMsg.SdkOAuthUI", "doDelAvatar appid: %s", sDKOAuthUI.mAppId);
        sDKOAuthUI.gey();
        g.azz().a(new com.tencent.mm.modelsimple.h(sDKOAuthUI.Jfe.agF(sDKOAuthUI.Jfa).id), 0);
        AppMethodBeat.o(79795);
    }
}
