package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.model.k;
import com.tencent.mm.plugin.account.model.l;
import com.tencent.mm.protocal.protobuf.dua;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.h.a.c;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.wxmm.v2helper;

@a(3)
public class ShareToFacebookRedirectUI extends MMActivity implements i {
    private static String TAG = "MicroMsg.ShareToFacebookRedirectUI";
    private q gut;
    private String ksh;
    private String ksi;
    private String ksj;
    private String ksk;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128738);
        super.onCreate(bundle);
        g.azz().a(v2helper.EMethodSetSendToNetworkOff, this);
        this.ksh = getIntent().getStringExtra("title");
        this.ksi = getIntent().getStringExtra("digest");
        this.ksj = getIntent().getStringExtra("img");
        this.ksk = getIntent().getStringExtra("link");
        Log.i(TAG, "title %s, digest:%s, img:%s, link:%s", this.ksh, this.ksi, this.ksj, this.ksk);
        if (!z.aUF()) {
            Intent intent = new Intent(this, FacebookAuthUI.class);
            intent.putExtra("is_force_unbind", true);
            startActivityForResult(intent, 0);
            AppMethodBeat.o(128738);
            return;
        }
        bpW();
        bpw();
        AppMethodBeat.o(128738);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(128739);
        g.azz().b(v2helper.EMethodSetSendToNetworkOff, this);
        super.onDestroy();
        AppMethodBeat.o(128739);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return -1;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(128740);
        Log.i(TAG, "type:%d, code:%d, msg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        hideVKB();
        this.gut.dismiss();
        if (i2 == 4 && i3 == -68) {
            if (Util.isNullOrNil(str)) {
                str = "error";
            }
            cb(getString(R.string.zb), str);
            AppMethodBeat.o(128740);
        } else if (i2 == 0 && i3 == 0) {
            String string = getString(R.string.h0k);
            new DialogInterface.OnDismissListener() {
                /* class com.tencent.mm.plugin.account.ui.ShareToFacebookRedirectUI.AnonymousClass1 */

                public final void onDismiss(DialogInterface dialogInterface) {
                }
            };
            h.cD(this, string);
            finish();
            AppMethodBeat.o(128740);
        } else {
            h.a(getContext(), "err(" + i3 + "," + i2 + ")", getString(R.string.zb), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.ui.ShareToFacebookRedirectUI.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(128732);
                    ShareToFacebookRedirectUI.this.finish();
                    AppMethodBeat.o(128732);
                }
            }, (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(128740);
        }
    }

    private void bpW() {
        AppMethodBeat.i(128741);
        Log.i(TAG, "refreshFacebookToken");
        long nullAsNil = Util.nullAsNil((Long) g.aAh().azQ().get(65831, (Object) null));
        String nullAsNil2 = Util.nullAsNil((String) g.aAh().azQ().get(65830, (Object) null));
        if (Util.milliSecondsToNow(nullAsNil) <= Util.MILLSECONDS_OF_DAY || nullAsNil2.length() <= 0) {
            bpw();
            AppMethodBeat.o(128741);
            return;
        }
        c cVar = new c(getString(R.string.c71));
        cVar.bnE(nullAsNil2);
        new k(cVar, new l() {
            /* class com.tencent.mm.plugin.account.ui.ShareToFacebookRedirectUI.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.account.model.l, com.tencent.mm.plugin.account.model.k.a
            public final void E(Bundle bundle) {
                AppMethodBeat.i(128733);
                super.E(bundle);
                AppMethodBeat.o(128733);
            }

            @Override // com.tencent.mm.plugin.account.model.l, com.tencent.mm.plugin.account.model.k.a
            public final void onError(int i2, String str) {
                AppMethodBeat.i(128734);
                Log.e(ShareToFacebookRedirectUI.TAG, "refresh token error. errType:%d, errMsg:%s", Integer.valueOf(i2), str);
                super.onError(i2, str);
                if (i2 == 3) {
                    ShareToFacebookRedirectUI.a(ShareToFacebookRedirectUI.this);
                }
                AppMethodBeat.o(128734);
            }
        }).bnw();
        AppMethodBeat.o(128741);
    }

    private void bpw() {
        AppMethodBeat.i(128742);
        Log.i(TAG, "doSend");
        final f.a aVar = new f.a(this);
        aVar.aC(this.ksh).box(this.ksj).aD(this.ksi).boy(getString(R.string.t5)).apa(R.string.yx).c(new f.c() {
            /* class com.tencent.mm.plugin.account.ui.ShareToFacebookRedirectUI.AnonymousClass4 */

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
                AppMethodBeat.i(128736);
                ShareToFacebookRedirectUI.this.hideVKB();
                aVar.kdo.dismiss();
                if (z) {
                    dua dua = new dua();
                    if (Util.isNullOrNil(str)) {
                        str = " ";
                    }
                    dua.xJz = str;
                    dua.Name = ShareToFacebookRedirectUI.this.ksh;
                    dua.KHk = ShareToFacebookRedirectUI.this.ksi;
                    dua.AAN = ShareToFacebookRedirectUI.this.ksk;
                    dua.MVL = ShareToFacebookRedirectUI.this.ksj;
                    g.azz().a(new com.tencent.mm.plugin.account.model.i(dua), 0);
                    ShareToFacebookRedirectUI.this.gut = h.a((Context) ShareToFacebookRedirectUI.this, "", false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.account.ui.ShareToFacebookRedirectUI.AnonymousClass4.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(128735);
                            ShareToFacebookRedirectUI.this.gut.dismiss();
                            ShareToFacebookRedirectUI.this.finish();
                            AppMethodBeat.o(128735);
                        }
                    });
                    AppMethodBeat.o(128736);
                    return;
                }
                ShareToFacebookRedirectUI.this.finish();
                AppMethodBeat.o(128736);
            }
        }).show();
        AppMethodBeat.o(128742);
    }

    private void cb(String str, String str2) {
        AppMethodBeat.i(128743);
        h.a(getContext(), str2, str, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.ShareToFacebookRedirectUI.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(128737);
                Intent intent = new Intent(ShareToFacebookRedirectUI.this.getContext(), FacebookAuthUI.class);
                intent.putExtra("is_force_unbind", true);
                ShareToFacebookRedirectUI.this.getContext().startActivityForResult(intent, 0);
                AppMethodBeat.o(128737);
            }
        }, (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(128743);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(128744);
        super.onActivityResult(i2, i3, intent);
        String str = TAG;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Boolean.valueOf(intent == null);
        Log.i(str, "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b", objArr);
        if (i2 == 0 && i3 == -1 && intent != null) {
            boolean booleanExtra = intent.getBooleanExtra("bind_facebook_succ", false);
            Log.i(TAG, "bind facebooksucc %b", Boolean.valueOf(booleanExtra));
            if (booleanExtra) {
                bpW();
                bpw();
                AppMethodBeat.o(128744);
                return;
            }
        }
        finish();
        AppMethodBeat.o(128744);
    }

    static /* synthetic */ void a(ShareToFacebookRedirectUI shareToFacebookRedirectUI) {
        AppMethodBeat.i(128745);
        Log.e(TAG, "dealWithRefreshTokenFail");
        shareToFacebookRedirectUI.cb(shareToFacebookRedirectUI.getContext().getString(R.string.zb), shareToFacebookRedirectUI.getContext().getString(R.string.c7h));
        AppMethodBeat.o(128745);
    }
}
