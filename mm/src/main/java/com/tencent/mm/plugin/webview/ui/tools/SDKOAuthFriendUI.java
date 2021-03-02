package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.protocal.protobuf.cuh;
import com.tencent.mm.protocal.protobuf.drk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

@a(3)
public class SDKOAuthFriendUI extends MMActivity implements i {
    private aj JeI;
    private drk JeJ;
    private boolean JeK = false;
    private int accountType = 2;
    private String appId;
    private String edo;
    private String extData;
    private q gxX;
    private int lGW;
    private String scope;
    private long startTime;
    private String state;
    private String transaction;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ int d(SDKOAuthFriendUI sDKOAuthFriendUI) {
        AppMethodBeat.i(79706);
        int gev = sDKOAuthFriendUI.gev();
        AppMethodBeat.o(79706);
        return gev;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(79694);
        super.onCreate(bundle);
        g.azz().a(1346, this);
        g.azz().a(1137, this);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        ((TextView) findViewById(R.id.ea4)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthFriendUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(211042);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.webview.k.b.INSTANCE.a(SDKOAuthFriendUI.this.appId, SDKOAuthFriendUI.this.startTime, 0, SDKOAuthFriendUI.this.accountType, SDKOAuthFriendUI.d(SDKOAuthFriendUI.this), 1, 0);
                SDKOAuthFriendUI.this.JeI.agb(-2);
                SDKOAuthFriendUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(211042);
            }
        });
        Intent intent = getIntent();
        this.appId = intent.getStringExtra(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.scope = intent.getStringExtra("auth_scope");
        this.transaction = intent.getStringExtra("1");
        try {
            this.JeJ = (drk) new drk().parseFrom(intent.getByteArrayExtra("2"));
        } catch (IOException e2) {
            Log.e("MicroMsg.SDKOAuthFriendUI", "SdkOauthAuthorizeResp parseFrom byteArray failed");
        }
        this.state = intent.getStringExtra("4");
        this.extData = intent.getStringExtra("7");
        this.JeK = intent.getBooleanExtra("auth_from_scan", false);
        if (this.JeK) {
            this.accountType = 3;
            this.edo = intent.getStringExtra("auth_raw_url");
            this.JeI = new aj(this, this.appId, this.edo);
        } else {
            this.JeI = new aj(this, this.appId, this.transaction, this.state, this.extData);
        }
        this.lGW = intent.getIntExtra(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, -1);
        TextView textView = (TextView) findViewById(R.id.vv);
        Iterator<cuh> it = this.JeJ.Mzs.iterator();
        while (it.hasNext()) {
            cuh next = it.next();
            if (next.scope.equals(this.scope)) {
                textView.setText(next.desc);
            }
        }
        textView.getPaint().setFakeBoldText(true);
        TextView textView2 = (TextView) findViewById(R.id.vu);
        if (!Util.isNullOrNil(this.JeJ.MUa)) {
            textView2.setVisibility(0);
            textView2.setText(this.JeJ.MUa);
        } else {
            textView2.setVisibility(8);
        }
        c.a aVar = new c.a();
        aVar.jbq = R.raw.native_oauth_default_head_img;
        aVar.jbx = getResources().getDimension(R.dimen.aie);
        aVar.iaT = true;
        com.tencent.mm.av.q.bcV().a(this.JeJ.Mzt, (ImageView) findViewById(R.id.fv6), aVar.bdv());
        ((TextView) findViewById(R.id.fv9)).setText(this.JeJ.ixZ);
        final cuh e3 = aj.e(this.scope, this.JeJ.Mzs);
        final int intExtra = intent.getIntExtra("5", -1);
        this.startTime = System.currentTimeMillis();
        ((Button) findViewById(R.id.erq)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthFriendUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(79690);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.webview.k.b.INSTANCE.a(SDKOAuthFriendUI.this.appId, SDKOAuthFriendUI.this.startTime, 1, SDKOAuthFriendUI.this.accountType, SDKOAuthFriendUI.d(SDKOAuthFriendUI.this), 1, 0);
                SDKOAuthFriendUI.a(SDKOAuthFriendUI.this, intExtra);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(79690);
            }
        });
        ((Button) findViewById(R.id.ert)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthFriendUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(79691);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.webview.k.b.INSTANCE.a(SDKOAuthFriendUI.this.appId, SDKOAuthFriendUI.this.startTime, 0, SDKOAuthFriendUI.this.accountType, SDKOAuthFriendUI.d(SDKOAuthFriendUI.this), 1, 0);
                SDKOAuthFriendUI.a(SDKOAuthFriendUI.this, e3, intExtra);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(79691);
            }
        });
        AppMethodBeat.o(79694);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(79695);
        super.onResume();
        AppMethodBeat.o(79695);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(79696);
        super.onPause();
        AppMethodBeat.o(79696);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(79697);
        super.onDestroy();
        gep();
        g.azz().b(1346, this);
        g.azz().b(1137, this);
        AppMethodBeat.o(79697);
    }

    private void gep() {
        AppMethodBeat.i(79698);
        if (this.gxX == null) {
            AppMethodBeat.o(79698);
            return;
        }
        this.gxX.dismiss();
        AppMethodBeat.o(79698);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(79699);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            this.JeI.agb(-2);
            com.tencent.mm.plugin.webview.k.b.INSTANCE.a(this.appId, this.startTime, 0, this.accountType, gev(), 1, 0);
            finish();
            AppMethodBeat.o(79699);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(79699);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bor;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(79700);
        if (!(i2 == 0 && i3 == 0)) {
            com.tencent.mm.plugin.webview.k.b.INSTANCE.a(this.appId, this.startTime, 2, this.accountType, gev(), 1, i3);
        }
        gep();
        if (qVar instanceof ac) {
            this.JeI.i(i2, i3, str, qVar);
            AppMethodBeat.o(79700);
            return;
        }
        if (qVar instanceof aa) {
            this.JeI.Q(i2, i3, str);
        }
        AppMethodBeat.o(79700);
    }

    private int gev() {
        AppMethodBeat.i(79701);
        if ("snsapi_friend".equals(this.scope)) {
            AppMethodBeat.o(79701);
            return 3;
        }
        AppMethodBeat.o(79701);
        return 4;
    }

    private void kn(final int i2, final int i3) {
        AppMethodBeat.i(79702);
        Log.i("MicroMsg.SDKOAuthFriendUI", "accept go  MPGdprPolicyUtil.checkPolicy");
        com.tencent.mm.model.gdpr.c.a(this, com.tencent.mm.model.gdpr.a.OPENSDK, this.appId, new com.tencent.mm.model.gdpr.b() {
            /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthFriendUI.AnonymousClass5 */

            @Override // com.tencent.mm.model.gdpr.b
            public final void sx(int i2) {
                AppMethodBeat.i(79692);
                Log.i("MicroMsg.SDKOAuthFriendUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", Integer.valueOf(i2));
                if (i2 == 1) {
                    SDKOAuthFriendUI.this.JeI.agb(-4);
                    AppMethodBeat.o(79692);
                } else if (i2 == 8 && i3 == 8) {
                    SDKOAuthFriendUI.this.JeI.agb(-4);
                    AppMethodBeat.o(79692);
                } else {
                    LinkedList<String> linkedList = new LinkedList<>();
                    if (i3 == 7) {
                        linkedList.add(SDKOAuthFriendUI.this.scope);
                    }
                    SDKOAuthFriendUI.g(SDKOAuthFriendUI.this);
                    if (i2 == 7) {
                        aj unused = SDKOAuthFriendUI.this.JeI;
                        aj.a(SDKOAuthFriendUI.this.JeJ, linkedList);
                        if (SDKOAuthFriendUI.this.lGW == -1) {
                            Log.e("MicroMsg.SDKOAuthFriendUI", "btnCallback: do not get avatarId from pageone");
                        }
                        if (SDKOAuthFriendUI.this.JeK) {
                            aj unused2 = SDKOAuthFriendUI.this.JeI;
                            aj.a(linkedList, SDKOAuthFriendUI.this.lGW, SDKOAuthFriendUI.this.edo);
                            AppMethodBeat.o(79692);
                            return;
                        }
                        SDKOAuthFriendUI.this.JeI.k(linkedList, SDKOAuthFriendUI.this.lGW);
                        AppMethodBeat.o(79692);
                    } else if (SDKOAuthFriendUI.this.JeK) {
                        aj unused3 = SDKOAuthFriendUI.this.JeI;
                        aj.a(linkedList, 0, SDKOAuthFriendUI.this.edo);
                        AppMethodBeat.o(79692);
                    } else {
                        SDKOAuthFriendUI.this.JeI.bE(linkedList);
                        AppMethodBeat.o(79692);
                    }
                }
            }
        });
        AppMethodBeat.o(79702);
    }

    private void agD(final int i2) {
        AppMethodBeat.i(79703);
        Log.i("MicroMsg.SDKOAuthFriendUI", "accept go  MPGdprPolicyUtil.checkPolicy");
        com.tencent.mm.model.gdpr.c.a(this, com.tencent.mm.model.gdpr.a.OPENSDK, this.appId, new com.tencent.mm.model.gdpr.b() {
            /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthFriendUI.AnonymousClass6 */

            @Override // com.tencent.mm.model.gdpr.b
            public final void sx(int i2) {
                AppMethodBeat.i(79693);
                Log.i("MicroMsg.SDKOAuthFriendUI", " MPGdprPolicyUtil.checkPolicy onPermissionReturn:%d", Integer.valueOf(i2));
                if (i2 == 1 || i2 != 7) {
                    SDKOAuthFriendUI.this.JeI.agb(-4);
                    AppMethodBeat.o(79693);
                    return;
                }
                SDKOAuthFriendUI.g(SDKOAuthFriendUI.this);
                LinkedList<String> linkedList = new LinkedList<>();
                linkedList.add(SDKOAuthFriendUI.this.scope);
                if (SDKOAuthFriendUI.this.JeK) {
                    aj unused = SDKOAuthFriendUI.this.JeI;
                    aj.a(linkedList, 0, SDKOAuthFriendUI.this.edo);
                    AppMethodBeat.o(79693);
                    return;
                }
                SDKOAuthFriendUI.this.JeI.bE(linkedList);
                AppMethodBeat.o(79693);
            }
        });
        AppMethodBeat.o(79703);
    }

    private void a(drk drk, Class<?> cls, int i2) {
        AppMethodBeat.i(79704);
        Intent intent = new Intent(this, cls);
        intent.putExtra(AppEventsConstants.EVENT_PARAM_VALUE_NO, this.appId);
        intent.putExtra("1", this.transaction);
        intent.putExtra("4", this.state);
        intent.putExtra("7", this.extData);
        intent.putExtra("6", i2);
        intent.putExtra("auth_raw_url", this.edo);
        intent.putExtra("auth_from_scan", this.JeK);
        try {
            intent.putExtra("2", drk.toByteArray());
        } catch (IOException e2) {
            Log.e("MicroMsg.SDKOAuthFriendUI", "SdkOauthAuthorizeResp toByteArray failed");
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(79704);
    }

    private void a(drk drk, Class<?> cls, int i2, int i3, int i4) {
        AppMethodBeat.i(79705);
        Intent intent = new Intent(this, cls);
        intent.putExtra(AppEventsConstants.EVENT_PARAM_VALUE_NO, this.appId);
        intent.putExtra("1", this.transaction);
        intent.putExtra("4", this.state);
        intent.putExtra("7", this.extData);
        intent.putExtra(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, i2);
        intent.putExtra("5", i3);
        intent.putExtra("6", i4);
        intent.putExtra("auth_raw_url", this.edo);
        intent.putExtra("auth_from_scan", this.JeK);
        try {
            intent.putExtra("2", drk.toByteArray());
        } catch (IOException e2) {
            Log.e("MicroMsg.SDKOAuthFriendUI", "SdkOauthAuthorizeResp toByteArray failed");
        }
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/SDKOAuthFriendUI", "startScopeActivity", "(Lcom/tencent/mm/protocal/protobuf/SdkOauthAuthorizeResp;Ljava/lang/Class;III)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(79705);
    }

    static /* synthetic */ void a(SDKOAuthFriendUI sDKOAuthFriendUI, int i2) {
        AppMethodBeat.i(79707);
        if (aj.b(sDKOAuthFriendUI.JeJ)) {
            if (sDKOAuthFriendUI.JeJ.Mzs.size() == 2) {
                sDKOAuthFriendUI.kn(i2, 7);
                AppMethodBeat.o(79707);
                return;
            }
            sDKOAuthFriendUI.a(sDKOAuthFriendUI.JeJ, SDKOAuthOtherUI.class, sDKOAuthFriendUI.lGW, i2, 7);
            aj.aT(sDKOAuthFriendUI);
            AppMethodBeat.o(79707);
        } else if (sDKOAuthFriendUI.JeJ.Mzs.size() == 1) {
            sDKOAuthFriendUI.agD(7);
            AppMethodBeat.o(79707);
        } else {
            sDKOAuthFriendUI.a(sDKOAuthFriendUI.JeJ, SDKOAuthOtherUI.class, 7);
            aj.aT(sDKOAuthFriendUI);
            AppMethodBeat.o(79707);
        }
    }

    static /* synthetic */ void a(SDKOAuthFriendUI sDKOAuthFriendUI, cuh cuh, int i2) {
        AppMethodBeat.i(79708);
        if (cuh == null) {
            Log.e("MicroMsg.SDKOAuthFriendUI", "do not get scope request for user friend");
            AppMethodBeat.o(79708);
            return;
        }
        if (cuh.MzA == 3) {
            sDKOAuthFriendUI.JeI.agb(-4);
        }
        if (aj.b(sDKOAuthFriendUI.JeJ)) {
            if (sDKOAuthFriendUI.JeJ.Mzs.size() == 2) {
                sDKOAuthFriendUI.kn(i2, 8);
                AppMethodBeat.o(79708);
                return;
            }
            sDKOAuthFriendUI.a(sDKOAuthFriendUI.JeJ, SDKOAuthOtherUI.class, sDKOAuthFriendUI.lGW, i2, 8);
            aj.aT(sDKOAuthFriendUI);
            AppMethodBeat.o(79708);
        } else if (sDKOAuthFriendUI.JeJ.Mzs.size() == 1) {
            sDKOAuthFriendUI.agD(8);
            AppMethodBeat.o(79708);
        } else {
            sDKOAuthFriendUI.a(sDKOAuthFriendUI.JeJ, SDKOAuthOtherUI.class, 8);
            aj.aT(sDKOAuthFriendUI);
            AppMethodBeat.o(79708);
        }
    }

    static /* synthetic */ void g(SDKOAuthFriendUI sDKOAuthFriendUI) {
        AppMethodBeat.i(79709);
        sDKOAuthFriendUI.gep();
        sDKOAuthFriendUI.gxX = h.a((Context) sDKOAuthFriendUI, sDKOAuthFriendUI.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.SDKOAuthFriendUI.AnonymousClass1 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(79688);
                try {
                    dialogInterface.dismiss();
                    AppMethodBeat.o(79688);
                } catch (Exception e2) {
                    Log.e("MicroMsg.SDKOAuthFriendUI", "showProgressDlg onCancel exp: %s ", e2.getLocalizedMessage());
                    AppMethodBeat.o(79688);
                }
            }
        });
        AppMethodBeat.o(79709);
    }
}
