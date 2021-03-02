package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;

public class BakOperatingUI extends MMWizardActivity implements e.d {
    private MMHandler handler = new MMHandler(Looper.getMainLooper());
    private boolean oSC = false;
    private ProgressBar oSD = null;
    private TextView oSE = null;
    private TextView oSF = null;
    private TextView oSG = null;
    private boolean oSH = false;
    private int oSI = 0;
    private boolean oSJ = false;
    private int oSz = -1;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BakOperatingUI() {
        AppMethodBeat.i(22001);
        AppMethodBeat.o(22001);
    }

    static /* synthetic */ void e(BakOperatingUI bakOperatingUI) {
        AppMethodBeat.i(22018);
        bakOperatingUI.cht();
        AppMethodBeat.o(22018);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22002);
        Log.i("MicroMsg.BakOperatingUI", "onCreate");
        super.onCreate(bundle);
        if (getIntent().getExtras().getBoolean("MMWizardActivity.WIZARD_ROOT_KILLSELF", false)) {
            Log.i("MicroMsg.BakOperatingUI", "onCreate WizardRootKillSelf cmd:%d", Integer.valueOf(this.oSz));
            AppMethodBeat.o(22002);
            return;
        }
        a.cgZ().cha().a(this);
        a.cgZ().cha().jH(true);
        this.oSH = getIntent().getBooleanExtra("from_bak_banner", false);
        if (this.oSH) {
            int i2 = a.cgZ().cha().oRT;
            if (2 == i2 || a.cgZ().cha().oRS == 2) {
                this.oSz = 1;
                this.oSI = a.cgZ().cha().chk();
            } else if (4 == i2) {
                this.oSz = 6;
                this.oSI = a.cgZ().cha().chk();
            } else if (5 == i2) {
                this.oSz = 6;
                this.oSC = true;
                com.tencent.mm.plugin.backup.a.jRt.Xc();
                a.cgZ().cha().cgk();
            }
        } else {
            this.oSz = getIntent().getIntExtra("cmd", 6);
        }
        if (this.oSz == 6 && a.cgZ().cha().oRM.oSd) {
            this.oSC = true;
            com.tencent.mm.plugin.backup.a.jRt.Xc();
            a.cgZ().cha().cgk();
        }
        Log.i("MicroMsg.BakOperatingUI", "before initView onCreate BakOperatingUI  nowCmd:%d fromBanner:%b status:%d opePercent:%d", Integer.valueOf(this.oSz), Boolean.valueOf(this.oSH), Integer.valueOf(a.cgZ().cha().oRT), Integer.valueOf(this.oSI));
        initView();
        if (a.cgZ().cha().oRS == 2) {
            this.oSF.setText(getString(R.string.a_h));
            this.oSE.setText(getString(R.string.a_7) + this.oSI + "%");
            this.oSG.setText(getString(R.string.a_g));
            AppMethodBeat.o(22002);
        } else if (6 != this.oSz) {
            if (1 == this.oSz) {
                this.oSF.setText(getString(R.string.a_b));
                this.oSE.setText(getString(R.string.a_1) + this.oSI + "%");
                this.oSG.setText(getString(R.string.a_g));
            }
            AppMethodBeat.o(22002);
        } else if (this.oSC) {
            this.oSF.setText(getString(R.string.a_f));
            this.oSG.setText(getString(R.string.a_e));
            this.oSE.setText(getString(R.string.a_6) + this.oSI + "%");
            AppMethodBeat.o(22002);
        } else {
            this.oSF.setText(getString(R.string.a_i));
            this.oSE.setText(getString(R.string.a_8) + this.oSI + "%");
            this.oSG.setText(getString(R.string.a_g));
            AppMethodBeat.o(22002);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(22003);
        setMMTitle(R.string.a_n);
        if (!this.oSC) {
            if (6 == this.oSz) {
                addTextOptionMenu(0, getString(R.string.a_9), new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.AnonymousClass1 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(21989);
                        if (BakOperatingUI.this.oSC) {
                            AppMethodBeat.o(21989);
                        } else {
                            BakOperatingUI.this.oSJ = true;
                            BakOperatingUI.c(BakOperatingUI.this);
                            AppMethodBeat.o(21989);
                        }
                        return true;
                    }
                });
            } else if (1 == this.oSz) {
                addTextOptionMenu(0, getString(R.string.a9q), new MenuItem.OnMenuItemClickListener() {
                    /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.AnonymousClass4 */

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMethodBeat.i(21992);
                        if (BakOperatingUI.this.oSC) {
                            AppMethodBeat.o(21992);
                        } else {
                            BakOperatingUI.this.oSJ = true;
                            BakOperatingUI.d(BakOperatingUI.this);
                            AppMethodBeat.o(21992);
                        }
                        return true;
                    }
                });
            } else {
                Log.e("MicroMsg.BakOperatingUI", "BakOperatingUI operate type is invalid");
            }
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(21993);
                if (BakOperatingUI.this.oSC) {
                    BakOperatingUI.e(BakOperatingUI.this);
                    AppMethodBeat.o(21993);
                    return false;
                }
                BakOperatingUI.this.oSJ = true;
                BakOperatingUI.f(BakOperatingUI.this);
                AppMethodBeat.o(21993);
                return true;
            }
        });
        this.oSD = (ProgressBar) findViewById(R.id.z4);
        this.oSD.setProgress(this.oSI);
        this.oSF = (TextView) findViewById(R.id.zd);
        this.oSG = (TextView) findViewById(R.id.ze);
        this.oSE = (TextView) findViewById(R.id.z5);
        AppMethodBeat.o(22003);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.i0;
    }

    private void cht() {
        AppMethodBeat.i(22004);
        a.cgZ().cha().pause();
        d a2 = h.a(this, (int) R.string.a__, 0, (int) R.string.a0_, (int) R.string.x6, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(21994);
                e cha = a.cgZ().cha();
                cha.oRL.cancel();
                cha.oRM.cancel();
                if (cha.oRP == 1 || cha.oRT == 2) {
                    e.Bv(4);
                } else if (cha.oRP == 6 || cha.oRT == 4 || cha.oRT == 6) {
                    e.Bv(7);
                }
                a.cgZ().cha().oRS = -1;
                a.cgZ().chb().oRx++;
                BakOperatingUI.this.oSJ = true;
                BakOperatingUI.g(BakOperatingUI.this);
                AppMethodBeat.o(21994);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.AnonymousClass7 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(21995);
                e cha = a.cgZ().cha();
                if (cha.oRP == 1) {
                    cha.oRL.resume();
                    AppMethodBeat.o(21995);
                } else if (cha.oRP == 6) {
                    cha.oRM.resume();
                    AppMethodBeat.o(21995);
                } else {
                    Log.e("MicroMsg.BakPcProcessMgr", "cancel in error state, %d", Integer.valueOf(cha.oRP));
                    AppMethodBeat.o(21995);
                }
            }
        });
        a2.setCanceledOnTouchOutside(false);
        a2.setCancelable(false);
        AppMethodBeat.o(22004);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(22005);
        super.onDestroy();
        a.cgZ().cha().a((e.d) null);
        a.cgZ().cha().jH(false);
        Log.i("MicroMsg.BakOperatingUI", "BakOperatingUI onDestroy nowCmd:%d", Integer.valueOf(this.oSz));
        AppMethodBeat.o(22005);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(22006);
        super.onStart();
        AppMethodBeat.o(22006);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(22007);
        a.cgZ().cha().jH(true);
        a.cgZ().cha().a(this);
        Log.i("MicroMsg.BakOperatingUI", "onResume nowCmd:%d", Integer.valueOf(this.oSz));
        super.onResume();
        AppMethodBeat.o(22007);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(22008);
        a.cgZ().cha().jH(false);
        super.onPause();
        Log.i("MicroMsg.BakOperatingUI", "onPause nowCmd:%d", Integer.valueOf(this.oSz));
        AppMethodBeat.o(22008);
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d
    public final synchronized void By(final int i2) {
        AppMethodBeat.i(22009);
        Log.d("MicroMsg.BakOperatingUI", "BakOperatingUI onNetProgress percent:%d, isFinishingWizard:%b", Integer.valueOf(i2), Boolean.valueOf(this.oSJ));
        if (this.oSJ) {
            AppMethodBeat.o(22009);
        } else {
            this.handler.post(new Runnable() {
                /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(21996);
                    if (BakOperatingUI.this.oSD != null) {
                        BakOperatingUI.this.oSD.setProgress(i2);
                    }
                    if (BakOperatingUI.this.oSE != null) {
                        int i2 = R.string.a_1;
                        int i3 = R.string.a_b;
                        if (6 == BakOperatingUI.this.oSz) {
                            i2 = R.string.a_8;
                            i3 = R.string.a_i;
                        }
                        BakOperatingUI.this.oSE.setText(BakOperatingUI.this.getString(i2) + i2 + "%");
                        BakOperatingUI.this.oSF.setText(BakOperatingUI.this.getString(i3));
                    }
                    AppMethodBeat.o(21996);
                }
            });
            AppMethodBeat.o(22009);
        }
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d
    public final synchronized void Bz(final int i2) {
        AppMethodBeat.i(22010);
        if (this.oSJ) {
            AppMethodBeat.o(22010);
        } else {
            Log.d("MicroMsg.BakOperatingUI", "BakOperatingUI onMergeProgress percent:%d", Integer.valueOf(i2));
            this.handler.post(new Runnable() {
                /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(21997);
                    if (BakOperatingUI.this.oSD != null) {
                        BakOperatingUI.this.oSD.setProgress(i2);
                    }
                    if (!(BakOperatingUI.this.oSE == null || BakOperatingUI.this.oSF == null)) {
                        BakOperatingUI.this.oSE.setText(BakOperatingUI.this.getString(R.string.a_6) + i2 + "%");
                        BakOperatingUI.this.oSF.setText(BakOperatingUI.this.getString(R.string.a_f));
                    }
                    AppMethodBeat.o(21997);
                }
            });
            AppMethodBeat.o(22010);
        }
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d
    public final synchronized void chn() {
        AppMethodBeat.i(22011);
        Log.d("MicroMsg.BakOperatingUI", "onNetFinish now cmd:%d", Integer.valueOf(this.oSz));
        if (this.oSJ) {
            AppMethodBeat.o(22011);
        } else {
            if (6 == this.oSz || 5 == a.cgZ().cha().oRT) {
                this.oSz = 6;
                this.oSC = true;
                com.tencent.mm.plugin.backup.a.jRt.Xc();
                a.cgZ().cha().cgk();
            } else {
                Log.e("MicroMsg.BakOperatingUI", "onNetFinish now cmd:%d", Integer.valueOf(this.oSz));
            }
            this.handler.post(new Runnable() {
                /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.AnonymousClass10 */

                public final void run() {
                    AppMethodBeat.i(21999);
                    if (6 == BakOperatingUI.this.oSz) {
                        BakOperatingUI.this.handler.post(new Runnable() {
                            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.AnonymousClass10.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(21998);
                                BakOperatingUI.this.showOptionMenu(false);
                                if (BakOperatingUI.this.oSD != null) {
                                    BakOperatingUI.this.oSD.setProgress(0);
                                }
                                if (BakOperatingUI.this.oSF != null) {
                                    BakOperatingUI.this.oSF.setText(BakOperatingUI.this.getString(R.string.a_f));
                                }
                                if (BakOperatingUI.this.oSG != null) {
                                    BakOperatingUI.this.oSG.setText(BakOperatingUI.this.getString(R.string.a_e));
                                }
                                if (BakOperatingUI.this.oSE != null) {
                                    BakOperatingUI.this.oSE.setText(BakOperatingUI.this.getString(R.string.a_6) + "0%");
                                }
                                AppMethodBeat.o(21998);
                            }
                        });
                        AppMethodBeat.o(21999);
                        return;
                    }
                    if (1 == BakOperatingUI.this.oSz) {
                        Intent intent = new Intent(BakOperatingUI.this, BakFinishUI.class);
                        intent.putExtra("cmd", BakOperatingUI.this.oSz);
                        MMWizardActivity.ay(BakOperatingUI.this, intent);
                    }
                    AppMethodBeat.o(21999);
                }
            });
            AppMethodBeat.o(22011);
        }
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d
    public final synchronized void ceL() {
        AppMethodBeat.i(22012);
        if (this.oSJ) {
            AppMethodBeat.o(22012);
        } else {
            this.oSC = false;
            Log.d("MicroMsg.BakOperatingUI", "onMergeFinish now cmd:%d", Integer.valueOf(this.oSz));
            this.handler.post(new Runnable() {
                /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.AnonymousClass11 */

                public final void run() {
                    AppMethodBeat.i(22000);
                    Intent intent = new Intent(BakOperatingUI.this, BakFinishUI.class);
                    intent.putExtra("cmd", BakOperatingUI.this.oSz);
                    MMWizardActivity.ay(BakOperatingUI.this, intent);
                    AppMethodBeat.o(22000);
                }
            });
            AppMethodBeat.o(22012);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public synchronized boolean onKeyDown(int i2, KeyEvent keyEvent) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(22013);
            if (i2 != 4) {
                z = super.onKeyDown(i2, keyEvent);
                AppMethodBeat.o(22013);
            } else if (this.oSC) {
                cht();
                a.cgZ().cha().pause();
                AppMethodBeat.o(22013);
            } else {
                Log.d("MicroMsg.BakOperatingUI", "onKeyDown keyCode == KeyEvent.KEYCODE_BACK  finishWizard cmd:%d", Integer.valueOf(this.oSz));
                this.oSJ = true;
                a.cgZ().cha().jH(false);
                ala(1);
                AppMethodBeat.o(22013);
            }
        }
        return z;
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.b
    public final void onError(final int i2) {
        AppMethodBeat.i(22014);
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(21990);
                Log.i("MicroMsg.BakOperatingUI", "BakOperatingUI onCloseSocket, %d", Integer.valueOf(i2));
                if (i2 == 15) {
                    BakOperatingUI.n(BakOperatingUI.this);
                    AppMethodBeat.o(21990);
                    return;
                }
                MMWizardActivity.ay(BakOperatingUI.this, new Intent(BakOperatingUI.this, BakConnErrorUI.class));
                AppMethodBeat.o(21990);
            }
        });
        AppMethodBeat.o(22014);
    }

    @Override // com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d
    public final void cho() {
        AppMethodBeat.i(22015);
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(21991);
                Log.d("MicroMsg.BakOperatingUI", "BakOperatingUI onOperateCancel");
                BakOperatingUI.o(BakOperatingUI.this);
                AppMethodBeat.o(21991);
            }
        });
        AppMethodBeat.o(22015);
    }

    static /* synthetic */ void c(BakOperatingUI bakOperatingUI) {
        AppMethodBeat.i(22016);
        bakOperatingUI.ala(1);
        AppMethodBeat.o(22016);
    }

    static /* synthetic */ void d(BakOperatingUI bakOperatingUI) {
        AppMethodBeat.i(22017);
        bakOperatingUI.ala(1);
        AppMethodBeat.o(22017);
    }

    static /* synthetic */ void f(BakOperatingUI bakOperatingUI) {
        AppMethodBeat.i(22019);
        bakOperatingUI.ala(1);
        AppMethodBeat.o(22019);
    }

    static /* synthetic */ void g(BakOperatingUI bakOperatingUI) {
        AppMethodBeat.i(22020);
        bakOperatingUI.ala(1);
        AppMethodBeat.o(22020);
    }

    static /* synthetic */ void n(BakOperatingUI bakOperatingUI) {
        AppMethodBeat.i(22021);
        bakOperatingUI.ala(1);
        AppMethodBeat.o(22021);
    }

    static /* synthetic */ void o(BakOperatingUI bakOperatingUI) {
        AppMethodBeat.i(22022);
        bakOperatingUI.ala(1);
        AppMethodBeat.o(22022);
    }
}
