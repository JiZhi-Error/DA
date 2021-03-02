package com.tencent.mm.plugin.fingerprint.faceid.auth;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.bm;
import com.tencent.mm.plugin.fingerprint.b.l;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.soter.a.g.f;

@com.tencent.mm.ui.base.a(3)
public class WalletFaceIdAuthUI extends WalletBaseUI {
    int mScene;
    private c wEA;
    Button wEz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64252);
        this.mScene = getIntent().getIntExtra("key_scene", 1);
        Log.i("MicroMsg.WalletFaceIdAuthUI", "scene: %s", Integer.valueOf(this.mScene));
        if (this.mScene == 0) {
            this.wEA = new b(this);
        } else if (this.mScene == 1) {
            this.wEA = new a(this);
        }
        super.onCreate(bundle);
        setMMTitle(R.string.c81);
        this.wEA.onCreate();
        initView();
        AppMethodBeat.o(64252);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(64253);
        this.wEz = (Button) findViewById(R.id.d56);
        this.wEz.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(64230);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fingerprint/faceid/auth/WalletFaceIdAuthUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletFaceIdAuthUI.this.wEA.dJD();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fingerprint/faceid/auth/WalletFaceIdAuthUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(64230);
            }
        });
        AppMethodBeat.o(64253);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean isTransparent() {
        AppMethodBeat.i(64254);
        boolean isTransparent = this.wEA.isTransparent();
        AppMethodBeat.o(64254);
        return isTransparent;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onProgressFinish() {
        return true;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(64255);
        boolean onSceneEnd = this.wEA.onSceneEnd(i2, i3, str, qVar);
        AppMethodBeat.o(64255);
        return onSceneEnd;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a6r;
    }

    public final void axc(String str) {
        AppMethodBeat.i(64256);
        h.a((Context) this, str, "", getString(R.string.w1), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(64231);
                WalletFaceIdAuthUI.this.wEA.dJC();
                AppMethodBeat.o(64231);
            }
        });
        AppMethodBeat.o(64256);
    }

    public static abstract class c {
        protected String krw;
        protected Bundle mgW;
        protected com.tencent.mm.plugin.fingerprint.d.a wEE;
        protected l wEF;
        protected WalletFaceIdAuthUI wEG;

        /* access modifiers changed from: protected */
        public abstract void dJB();

        /* access modifiers changed from: protected */
        public abstract void dJC();

        /* access modifiers changed from: protected */
        public abstract void dJD();

        /* access modifiers changed from: protected */
        public abstract int dJE();

        /* access modifiers changed from: protected */
        public abstract boolean isTransparent();

        /* access modifiers changed from: protected */
        public abstract boolean onSceneEnd(int i2, int i3, String str, q qVar);

        public c(WalletFaceIdAuthUI walletFaceIdAuthUI) {
            Bundle extras;
            this.wEG = walletFaceIdAuthUI;
            if (walletFaceIdAuthUI.mScene == 0) {
                extras = walletFaceIdAuthUI.getProcess().dQL;
            } else {
                extras = walletFaceIdAuthUI.getIntent().getExtras();
            }
            this.mgW = extras;
            this.wEF = new l();
            this.wEE = (com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
        }

        public void onCreate() {
            boolean z;
            boolean z2 = true;
            if (this.wEE == null) {
                Log.w("MicroMsg.WalletFaceIdAuthUI", "no mgr");
                this.wEG.axc(this.wEG.getString(R.string.c7y));
                return;
            }
            boolean dKb = this.wEE.dKb();
            boolean dKc = this.wEE.dKc();
            if (ae.gKx.gIE != 1) {
                z = true;
            } else {
                z = false;
            }
            if (!dKb || !dKc || z || this.mgW == null) {
                Object[] objArr = new Object[4];
                objArr[0] = Boolean.valueOf(dKb);
                objArr[1] = Boolean.valueOf(dKc);
                objArr[2] = Boolean.valueOf(z);
                if (this.mgW != null) {
                    z2 = false;
                }
                objArr[3] = Boolean.valueOf(z2);
                Log.w("MicroMsg.WalletFaceIdAuthUI", "support: %s, enrolled: %s, forceClose: %s, data: %s", objArr);
                this.wEG.axc(this.wEG.getString(R.string.c7y));
                return;
            }
            this.krw = this.mgW.getString("pwd");
            if (Util.isNullOrNil(this.krw)) {
                Log.w("MicroMsg.WalletFaceIdAuthUI", "no pwd");
                this.wEG.axc(this.wEG.getString(R.string.c7y));
                return;
            }
            f.hlO().hlP();
            dJB();
        }

        /* access modifiers changed from: protected */
        public final void MN(int i2) {
            int i3 = 1;
            this.wEG.showProgress();
            if (dJE() == 1) {
                i3 = 2;
            }
            l lVar = this.wEF;
            AnonymousClass1 r2 = new com.tencent.mm.plugin.fingerprint.d.b() {
                /* class com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.c.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.fingerprint.d.b
                public final void bg(int i2, String str) {
                    int i3 = 2;
                    AppMethodBeat.i(64248);
                    if (i2 == 0) {
                        Log.i("MicroMsg.WalletFaceIdAuthUI", "open fingerprintpay success");
                        c.this.wEG.doSceneProgress(new ad(null, 19), false);
                        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                        Object[] objArr = new Object[1];
                        if (c.this.dJE() == 1) {
                            i3 = 1;
                        }
                        objArr[0] = Integer.valueOf(i3);
                        hVar.a(15817, objArr);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(bm.CTRL_INDEX, 1);
                        AppMethodBeat.o(64248);
                        return;
                    }
                    c.this.wEG.hideProgress();
                    Log.e("MicroMsg.WalletFaceIdAuthUI", "open fingerprintpay failed");
                    c.this.wEG.axc(c.this.wEG.getString(R.string.c7y));
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(bm.CTRL_INDEX, 2);
                    AppMethodBeat.o(64248);
                }
            };
            String.valueOf(i2);
            lVar.a(r2, i3);
        }

        /* access modifiers changed from: protected */
        public final void dJH() {
            Log.i("MicroMsg.WalletFaceIdAuthUI", "do face id auth");
            Bundle bundle = new Bundle();
            bundle.putInt("face_auth_scene", 0);
            ((com.tencent.mm.plugin.fingerprint.b.h) g.af(com.tencent.mm.plugin.fingerprint.b.h.class)).a(this.wEG, new a() {
                /* class com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.c.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.a
                public final void onAuthSuccess(int i2, int i3) {
                    AppMethodBeat.i(64249);
                    c.this.MN(i2);
                    AppMethodBeat.o(64249);
                }

                @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.a
                public final void onAuthFail(int i2) {
                    AppMethodBeat.i(64250);
                    c.this.wEG.axc(c.this.wEG.getString(R.string.c7y));
                    AppMethodBeat.o(64250);
                }

                @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.a
                public final void onAuthCancel() {
                    AppMethodBeat.i(64251);
                    c.this.wEG.finish();
                    AppMethodBeat.o(64251);
                }
            }, bundle);
        }
    }

    public static class b extends c {
        public b(WalletFaceIdAuthUI walletFaceIdAuthUI) {
            super(walletFaceIdAuthUI);
            AppMethodBeat.i(64242);
            com.tencent.mm.plugin.soter.d.a.aat(1);
            AppMethodBeat.o(64242);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.c
        public final void dJB() {
            AppMethodBeat.i(64243);
            Log.i("MicroMsg.WalletFaceIdAuthUI", "do prepare ");
            this.wEG.showProgress();
            this.wEF.a(this.wEG, new com.tencent.mm.plugin.fingerprint.d.b() {
                /* class com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.b.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.fingerprint.d.b
                public final void bg(int i2, String str) {
                    AppMethodBeat.i(64241);
                    Log.i("MicroMsg.WalletFaceIdAuthUI", "prepared finish: %s, %s", Integer.valueOf(i2), str);
                    b.this.wEG.hideProgress();
                    if (i2 == 0) {
                        b.this.wEG.wEz.setEnabled(true);
                        AppMethodBeat.o(64241);
                        return;
                    }
                    b.this.wEG.axc(b.this.wEG.getString(R.string.agg));
                    AppMethodBeat.o(64241);
                }
            }, this.krw);
            AppMethodBeat.o(64243);
        }

        @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.c
        public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(64244);
            if (this.wEF.onSceneEnd(i2, i3, str, qVar)) {
                AppMethodBeat.o(64244);
                return true;
            } else if (qVar instanceof ad) {
                this.wEG.hideProgress();
                dJG();
                Toast.makeText(this.wEG, (int) R.string.dc0, 0).show();
                AppMethodBeat.o(64244);
                return true;
            } else {
                AppMethodBeat.o(64244);
                return false;
            }
        }

        @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.c
        public final void dJD() {
            AppMethodBeat.i(64245);
            Log.i("MicroMsg.WalletFaceIdAuthUI", "do verify face id");
            dJH();
            AppMethodBeat.o(64245);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.c
        public final boolean isTransparent() {
            return false;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.c
        public final int dJE() {
            return 0;
        }

        @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.c
        public final void dJC() {
            AppMethodBeat.i(64246);
            dJG();
            AppMethodBeat.o(64246);
        }

        private void dJG() {
            AppMethodBeat.i(64247);
            Log.i("MicroMsg.WalletFaceIdAuthUI", "do end process");
            com.tencent.mm.wallet_core.a.c(this.wEG, new Bundle(), 0);
            AppMethodBeat.o(64247);
        }
    }

    static class a extends c {
        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(64240);
            aVar.dJF();
            AppMethodBeat.o(64240);
        }

        public a(WalletFaceIdAuthUI walletFaceIdAuthUI) {
            super(walletFaceIdAuthUI);
            AppMethodBeat.i(64234);
            com.tencent.mm.plugin.soter.d.a.aat(0);
            AppMethodBeat.o(64234);
        }

        @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.c
        public final void onCreate() {
            AppMethodBeat.i(64235);
            this.wEG.getWindow().setDimAmount(0.0f);
            super.onCreate();
            this.wEG.hideTitleView();
            this.wEG.hideActionbarLine();
            this.wEG.setContentViewVisibility(8);
            AppMethodBeat.o(64235);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.c
        public final void dJB() {
            AppMethodBeat.i(64236);
            Log.i("MicroMsg.WalletFaceIdAuthUI", "do prepare ");
            this.wEG.showProgress();
            this.wEF.a(this.wEG, new com.tencent.mm.plugin.fingerprint.d.b() {
                /* class com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.a.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.fingerprint.d.b
                public final void bg(int i2, String str) {
                    AppMethodBeat.i(64232);
                    Log.i("MicroMsg.WalletFaceIdAuthUI", "prepared finish: %s, %s", Integer.valueOf(i2), str);
                    a.this.wEG.hideProgress();
                    if (i2 == 0) {
                        a.this.dJH();
                        AppMethodBeat.o(64232);
                        return;
                    }
                    a.this.wEG.axc(a.this.wEG.getString(R.string.agg));
                    AppMethodBeat.o(64232);
                }
            }, this.krw);
            AppMethodBeat.o(64236);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.c
        public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(64237);
            if (this.wEF.onSceneEnd(i2, i3, str, qVar)) {
                AppMethodBeat.o(64237);
                return true;
            } else if (qVar instanceof ad) {
                this.wEG.hideProgress();
                h.a((Context) this.wEG, this.wEG.getString(R.string.c80), this.wEG.getString(R.string.c7z), this.wEG.getString(R.string.imn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.a.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(64233);
                        a.a(a.this);
                        AppMethodBeat.o(64233);
                    }
                });
                AppMethodBeat.o(64237);
                return true;
            } else {
                AppMethodBeat.o(64237);
                return false;
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.c
        public final void dJC() {
            AppMethodBeat.i(64238);
            dJF();
            AppMethodBeat.o(64238);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.c
        public final void dJD() {
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.c
        public final boolean isTransparent() {
            return true;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.fingerprint.faceid.auth.WalletFaceIdAuthUI.c
        public final int dJE() {
            return 1;
        }

        private void dJF() {
            AppMethodBeat.i(64239);
            Log.i("MicroMsg.WalletFaceIdAuthUI", "do finish");
            this.wEG.finish();
            AppMethodBeat.o(64239);
        }
    }
}
