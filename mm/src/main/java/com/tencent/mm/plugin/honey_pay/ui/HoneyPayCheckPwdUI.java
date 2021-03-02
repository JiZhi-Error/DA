package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.honey_pay.a.c;
import com.tencent.mm.plugin.honey_pay.a.d;
import com.tencent.mm.plugin.honey_pay.a.g;
import com.tencent.mm.plugin.honey_pay.a.n;
import com.tencent.mm.plugin.wallet_core.c.ab;
import com.tencent.mm.protocal.protobuf.eig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.a;
import java.io.IOException;

public class HoneyPayCheckPwdUI extends HoneyPayBaseUI {
    private TextView jVn;
    private TextView mPa;
    private String mRa;
    private int mScene;
    private int qjx;
    private String yjY;
    private eig yjZ;
    private EditHintPasswdView ykY;
    private String ykZ;
    private String yla;
    private long ylb;

    @Override // com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(64740);
        super.onCreate(bundle);
        this.mRa = getIntent().getStringExtra("key_username");
        this.ykZ = getIntent().getStringExtra("key_take_message");
        this.ylb = getIntent().getLongExtra("key_credit_line", 0);
        this.mScene = getIntent().getIntExtra("key_scene", 0);
        this.yjY = getIntent().getStringExtra("key_card_no");
        this.yla = getIntent().getStringExtra("key_wishing");
        if (this.mScene == 1) {
            this.qjx = getIntent().getIntExtra("key_cardtype", 0);
            if (this.qjx == 0) {
                Log.w("MicroMsg.HoneyPayCheckPwdUI", "error card type: %s", Integer.valueOf(this.qjx));
                finish();
            }
        }
        if (this.mScene == 3) {
            eig eig = new eig();
            try {
                byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_toke_mess");
                if (byteArrayExtra == null || byteArrayExtra.length == 0) {
                    Log.w("MicroMsg.HoneyPayCheckPwdUI", "toke mess is null when unbind !!!");
                    finish();
                }
                eig.parseFrom(byteArrayExtra);
                this.yjZ = eig;
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.HoneyPayCheckPwdUI", e2, "", new Object[0]);
                finish();
            }
        }
        setMMTitle("");
        addSceneEndListener(2662);
        addSceneEndListener(2685);
        addSceneEndListener(2630);
        addSceneEndListener(2815);
        addSceneEndListener(2659);
        initView();
        AppMethodBeat.o(64740);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(64741);
        this.ykY = (EditHintPasswdView) findViewById(R.id.dyp);
        a.a(this.ykY);
        this.ykY.setOnInputValidListener(new EditHintPasswdView.a() {
            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.AnonymousClass1 */

            @Override // com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a
            public final void onInputValidChange(boolean z) {
                AppMethodBeat.i(64722);
                if (z) {
                    if (HoneyPayCheckPwdUI.this.mScene == 1) {
                        HoneyPayCheckPwdUI.b(HoneyPayCheckPwdUI.this);
                    } else if (HoneyPayCheckPwdUI.this.mScene == 2) {
                        HoneyPayCheckPwdUI.c(HoneyPayCheckPwdUI.this);
                    } else if (HoneyPayCheckPwdUI.this.mScene == 3) {
                        HoneyPayCheckPwdUI.d(HoneyPayCheckPwdUI.this);
                    } else {
                        Log.w("MicroMsg.HoneyPayCheckPwdUI", "unknown scene: %s", Integer.valueOf(HoneyPayCheckPwdUI.this.mScene));
                    }
                    HoneyPayCheckPwdUI.this.hideTenpayKB();
                }
                AppMethodBeat.o(64722);
            }
        });
        setEditFocusListener(this.ykY, 0, false);
        this.mPa = (TextView) findViewById(R.id.jhz);
        this.jVn = (TextView) findViewById(R.id.jhv);
        if (this.mScene == 1) {
            this.mPa.setText(R.string.e07);
        } else if (this.mScene == 2) {
            this.mPa.setText(R.string.e08);
        } else {
            this.mPa.setText(R.string.e0_);
        }
        this.jVn.setText(R.string.e09);
        AppMethodBeat.o(64741);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(64742);
        super.onDestroy();
        removeSceneEndListener(2662);
        removeSceneEndListener(2685);
        removeSceneEndListener(2630);
        removeSceneEndListener(2815);
        removeSceneEndListener(2659);
        AppMethodBeat.o(64742);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(64743);
        Log.d("MicroMsg.HoneyPayCheckPwdUI", "scene end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (qVar instanceof ab) {
            ab abVar = (ab) qVar;
            if (i2 != 0 || i3 != 0) {
                if (this.ykY != null) {
                    this.ykY.eIj();
                }
                hideProgress();
                if (!abVar.hasProcessWalletError() && !Util.isNullOrNil(str)) {
                    Log.i("MicroMsg.HoneyPayCheckPwdUI", "show normal error msg");
                    h.a((Context) getContext(), str, (String) null, false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.AnonymousClass10 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                }
                AppMethodBeat.o(64743);
                return true;
            } else if (this.mScene == 1) {
                String str2 = abVar.HQm;
                Log.i("MicroMsg.HoneyPayCheckPwdUI", "do give card");
                showSafeProgress();
                c cVar = new c(str2, this.ylb, this.mRa, this.ykZ, this.qjx, this.yla);
                cVar.t(this);
                doSceneProgress(cVar, false);
            } else if (this.mScene == 2) {
                String str3 = abVar.HQm;
                Log.i("MicroMsg.HoneyPayCheckPwdUI", "do modify quota");
                showSafeProgress();
                com.tencent.mm.plugin.honey_pay.a.h hVar = new com.tencent.mm.plugin.honey_pay.a.h(this.ylb, str3, this.yjY);
                hVar.t(this);
                doSceneProgress(hVar, false);
            } else if (this.mScene == 3) {
                String str4 = abVar.HQm;
                Log.i("MicroMsg.HoneyPayCheckPwdUI", "do unbind: %s", this.yjY);
                showSafeProgress();
                n nVar = new n(this.yjY, str4);
                nVar.t(this);
                doSceneProgress(nVar, false);
            }
        } else if (qVar instanceof c) {
            final c cVar2 = (c) qVar;
            hideProgress();
            cVar2.a(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.AnonymousClass13 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64735);
                    Log.i("MicroMsg.HoneyPayCheckPwdUI", "create success");
                    Intent intent = new Intent(HoneyPayCheckPwdUI.this.getContext(), HoneyPayMainUI.class);
                    intent.putExtra("key_create_succ", true);
                    if (cVar2.yjz.LpE != null) {
                        intent.putExtra("key_card_no", cVar2.yjz.LpE.LWD);
                        intent.putExtra("key_card_type", cVar2.yjz.LpE.pTn);
                    }
                    Toast.makeText(HoneyPayCheckPwdUI.this.getContext(), (int) R.string.e0a, 1).show();
                    HoneyPayCheckPwdUI honeyPayCheckPwdUI = HoneyPayCheckPwdUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(honeyPayCheckPwdUI, bl.axQ(), "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCheckPwdUI$5", "onCallback", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    honeyPayCheckPwdUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(honeyPayCheckPwdUI, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCheckPwdUI$5", "onCallback", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(875, 2, 1);
                    AppMethodBeat.o(64735);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.AnonymousClass12 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64734);
                    if (HoneyPayCheckPwdUI.this.ykY != null) {
                        HoneyPayCheckPwdUI.this.ykY.eIj();
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(875, 3, 1);
                    AppMethodBeat.o(64734);
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.AnonymousClass11 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64733);
                    if (HoneyPayCheckPwdUI.this.ykY != null) {
                        HoneyPayCheckPwdUI.this.ykY.eIj();
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(875, 3, 1);
                    AppMethodBeat.o(64733);
                }
            });
        } else if (qVar instanceof com.tencent.mm.plugin.honey_pay.a.h) {
            hideProgress();
            final com.tencent.mm.plugin.honey_pay.a.h hVar2 = (com.tencent.mm.plugin.honey_pay.a.h) qVar;
            hVar2.a(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.AnonymousClass16 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64738);
                    Log.i("MicroMsg.HoneyPayCheckPwdUI", "modify success");
                    Intent intent = new Intent();
                    intent.putExtra("key_modify_create_line_succ", true);
                    intent.putExtra("key_credit_line", hVar2.yjF);
                    HoneyPayCheckPwdUI.this.setResult(-1, intent);
                    HoneyPayCheckPwdUI.this.finish();
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(875, 8, 1);
                    AppMethodBeat.o(64738);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.AnonymousClass15 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64737);
                    if (HoneyPayCheckPwdUI.this.ykY != null) {
                        HoneyPayCheckPwdUI.this.ykY.eIj();
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(875, 9, 1);
                    AppMethodBeat.o(64737);
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.AnonymousClass14 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64736);
                    if (HoneyPayCheckPwdUI.this.ykY != null) {
                        HoneyPayCheckPwdUI.this.ykY.eIj();
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(875, 9, 1);
                    AppMethodBeat.o(64736);
                }
            });
        } else if (qVar instanceof d) {
            final d dVar = (d) qVar;
            dVar.a(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.AnonymousClass3 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64726);
                    HoneyPayCheckPwdUI.this.yjZ = dVar.yjA.LUW;
                    if (dVar.yjA.LUX != null) {
                        com.tencent.mm.plugin.honey_pay.model.c.a(HoneyPayCheckPwdUI.this, dVar.yjA.LUX, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.AnonymousClass3.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(64725);
                                HoneyPayCheckPwdUI.d(HoneyPayCheckPwdUI.this);
                                AppMethodBeat.o(64725);
                            }
                        });
                        HoneyPayCheckPwdUI.this.hideProgress();
                        AppMethodBeat.o(64726);
                        return;
                    }
                    HoneyPayCheckPwdUI.d(HoneyPayCheckPwdUI.this);
                    AppMethodBeat.o(64726);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.AnonymousClass2 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64724);
                    if (dVar.yjA.LUX != null) {
                        com.tencent.mm.plugin.honey_pay.model.c.a(HoneyPayCheckPwdUI.this, dVar.yjA.LUX, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.AnonymousClass2.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(64723);
                                HoneyPayCheckPwdUI.d(HoneyPayCheckPwdUI.this);
                                AppMethodBeat.o(64723);
                            }
                        });
                    } else if (HoneyPayCheckPwdUI.this.ykY != null) {
                        HoneyPayCheckPwdUI.this.ykY.eIj();
                    }
                    HoneyPayCheckPwdUI.this.hideProgress();
                    AppMethodBeat.o(64724);
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.AnonymousClass17 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64739);
                    if (HoneyPayCheckPwdUI.this.ykY != null) {
                        HoneyPayCheckPwdUI.this.ykY.eIj();
                    }
                    HoneyPayCheckPwdUI.this.hideProgress();
                    AppMethodBeat.o(64739);
                }
            });
        } else if (qVar instanceof g) {
            g gVar = (g) qVar;
            this.yjZ = gVar.yjD.LUW;
            gVar.a(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.AnonymousClass6 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64729);
                    HoneyPayCheckPwdUI.d(HoneyPayCheckPwdUI.this);
                    AppMethodBeat.o(64729);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.AnonymousClass5 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64728);
                    if (HoneyPayCheckPwdUI.this.ykY != null) {
                        HoneyPayCheckPwdUI.this.ykY.eIj();
                    }
                    HoneyPayCheckPwdUI.this.hideProgress();
                    AppMethodBeat.o(64728);
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.AnonymousClass4 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64727);
                    if (HoneyPayCheckPwdUI.this.ykY != null) {
                        HoneyPayCheckPwdUI.this.ykY.eIj();
                    }
                    HoneyPayCheckPwdUI.this.hideProgress();
                    AppMethodBeat.o(64727);
                }
            });
        } else if (qVar instanceof n) {
            hideProgress();
            ((n) qVar).a(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.AnonymousClass9 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64732);
                    HoneyPayCheckPwdUI.this.setResult(-1);
                    HoneyPayCheckPwdUI.this.finish();
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(875, 6, 1);
                    AppMethodBeat.o(64732);
                }
            }).b(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.AnonymousClass8 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64731);
                    if (HoneyPayCheckPwdUI.this.ykY != null) {
                        HoneyPayCheckPwdUI.this.ykY.eIj();
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(875, 7, 1);
                    AppMethodBeat.o(64731);
                }
            }).c(new r.a() {
                /* class com.tencent.mm.plugin.honey_pay.ui.HoneyPayCheckPwdUI.AnonymousClass7 */

                @Override // com.tencent.mm.wallet_core.c.r.a
                public final void d(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(64730);
                    if (HoneyPayCheckPwdUI.this.ykY != null) {
                        HoneyPayCheckPwdUI.this.ykY.eIj();
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(875, 7, 1);
                    AppMethodBeat.o(64730);
                }
            });
        }
        AppMethodBeat.o(64743);
        return true;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void cleanUiData(int i2) {
        AppMethodBeat.i(64744);
        super.cleanUiData(i2);
        if (this.ykY != null) {
            this.ykY.eIj();
        }
        AppMethodBeat.o(64744);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.aum;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    static /* synthetic */ void b(HoneyPayCheckPwdUI honeyPayCheckPwdUI) {
        AppMethodBeat.i(64745);
        Log.i("MicroMsg.HoneyPayCheckPwdUI", "do get create token sign");
        honeyPayCheckPwdUI.showSafeProgress();
        d dVar = new d(honeyPayCheckPwdUI.ykZ, honeyPayCheckPwdUI.ylb);
        dVar.t(honeyPayCheckPwdUI);
        honeyPayCheckPwdUI.doSceneProgress(dVar, false);
        AppMethodBeat.o(64745);
    }

    static /* synthetic */ void c(HoneyPayCheckPwdUI honeyPayCheckPwdUI) {
        AppMethodBeat.i(64746);
        Log.i("MicroMsg.HoneyPayCheckPwdUI", "modify credit line token sign");
        honeyPayCheckPwdUI.showSafeProgress();
        g gVar = new g(honeyPayCheckPwdUI.yjY, honeyPayCheckPwdUI.ylb);
        gVar.t(honeyPayCheckPwdUI);
        honeyPayCheckPwdUI.doSceneProgress(gVar, false);
        AppMethodBeat.o(64746);
    }

    static /* synthetic */ void d(HoneyPayCheckPwdUI honeyPayCheckPwdUI) {
        boolean z = true;
        AppMethodBeat.i(64747);
        Object[] objArr = new Object[1];
        if (honeyPayCheckPwdUI.yjZ != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.i("MicroMsg.HoneyPayCheckPwdUI", "do get pwd token: %s", objArr);
        if (honeyPayCheckPwdUI.yjZ != null) {
            honeyPayCheckPwdUI.showSafeProgress();
            honeyPayCheckPwdUI.doSceneProgress(new ab(honeyPayCheckPwdUI.ykY.getText(), honeyPayCheckPwdUI.yjZ.Nhx, honeyPayCheckPwdUI.yjZ.Nhw, honeyPayCheckPwdUI.yjZ.sign, honeyPayCheckPwdUI.yjZ.qcK, honeyPayCheckPwdUI.yjZ.GaP), false);
        }
        AppMethodBeat.o(64747);
    }
}
