package com.tencent.mm.plugin.teenmode.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.plugin.wallet.wecoin.a.c;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e;

public class SettingsTeenModeMain extends MMActivity {
    private RelativeLayout FWA;
    private TextView FWB;
    private TextView FWC;
    private TextView FWD;
    private int FWE = 0;
    private int FWF = 0;
    private int FWG = 0;
    private RelativeLayout FWq;
    private RelativeLayout FWr;
    private RelativeLayout FWs;
    private RelativeLayout FWt;
    private RelativeLayout FWu;
    private RelativeLayout FWv;
    private RelativeLayout FWw;
    private RelativeLayout FWx;
    private RelativeLayout FWy;
    private RelativeLayout FWz;
    private View hRd;
    private e ojT;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.brc;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(187409);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(187409);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(187410);
        super.onResume();
        is(false);
        AppMethodBeat.o(187410);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(187411);
        if ((this.FWE != ((b) g.af(b.class)).dxW()) || this.FWF != ((b) g.af(b.class)).fvo()) {
            z = true;
        } else {
            z = false;
        }
        if (z || this.FWG != ((b) g.af(b.class)).fvo()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            ((b) g.af(b.class)).pl(3);
        }
        super.onDestroy();
        AppMethodBeat.o(187411);
    }

    private void is(boolean z) {
        AppMethodBeat.i(187412);
        if (this.FWB != null) {
            int dxW = ((b) g.af(b.class)).dxW();
            if (z) {
                this.FWE = dxW;
            }
            switch (dxW) {
                case 0:
                    this.FWB.setText(R.string.hlt);
                    break;
                case 1:
                    this.FWB.setText(R.string.hma);
                    break;
                case 2:
                    this.FWB.setText(R.string.hmc);
                    break;
                default:
                    this.FWB.setText("");
                    break;
            }
        }
        if (this.FWC != null) {
            int fvo = ((b) g.af(b.class)).fvo();
            if (z) {
                this.FWF = fvo;
            }
            switch (fvo) {
                case 0:
                    this.FWC.setText(R.string.hm8);
                    break;
                case 1:
                    this.FWC.setText(R.string.hma);
                    break;
                case 2:
                    this.FWC.setText(R.string.hmc);
                    break;
                default:
                    this.FWC.setText("");
                    break;
            }
        }
        if (this.FWD != null) {
            int fvp = ((b) g.af(b.class)).fvp();
            if (z) {
                this.FWG = fvp;
            }
            switch (fvp) {
                case 0:
                    this.FWD.setText(R.string.hlr);
                    break;
                case 1:
                    this.FWD.setText(R.string.hma);
                    break;
                case 2:
                    this.FWD.setText(R.string.hlq);
                    break;
                default:
                    this.FWD.setText("");
                    break;
            }
        }
        if (a.glB()) {
            this.FWw.setVisibility(8);
            this.FWx.setVisibility(0);
            AppMethodBeat.o(187412);
            return;
        }
        this.FWw.setVisibility(0);
        this.FWx.setVisibility(8);
        AppMethodBeat.o(187412);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(187413);
        setMMTitle("");
        hideActionbarLine();
        setActionbarColor(getResources().getColor(R.color.afz));
        boolean nullAsFalse = Util.nullAsFalse(Boolean.valueOf(g.aAh().azQ().getBoolean(ar.a.USERINFO_SETTING_TEEN_MODE_STATE_BOOLEAN_SYNC, false)));
        if (!nullAsFalse) {
            g.aAh().azQ().set(ar.a.USERINFO_SETTING_TEEN_MODE_STATE_BOOLEAN_SYNC, Boolean.TRUE);
            ((b) g.af(b.class)).fvq();
        }
        boolean nullAsFalse2 = Util.nullAsFalse(Boolean.valueOf(g.aAh().azQ().getBoolean(ar.a.USERINFO_SETTING_TEEN_MODE_ALREADY_SWITCH_OFF_BOOLEAN, false)));
        if (!nullAsFalse && nullAsFalse2) {
            ((b) g.af(b.class)).pl(5);
        }
        bfx bfx = new bfx();
        bfx.LPB = 59;
        bfx.BsD = 1;
        ((l) g.af(l.class)).aSM().d(new k.a(23, bfx));
        this.FWB = (TextView) findViewById(R.id.iim);
        this.FWq = (RelativeLayout) findViewById(R.id.czu);
        this.FWq.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMain.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(187392);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainFinder.class);
                SettingsTeenModeMain settingsTeenModeMain = SettingsTeenModeMain.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(settingsTeenModeMain, bl.axQ(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                settingsTeenModeMain.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(settingsTeenModeMain, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187392);
            }
        });
        boolean showFinderEntry = ((aj) g.ah(aj.class)).showFinderEntry();
        Log.i("MicroMsg.SettingsTeenModeMain", "showFinder %s", Boolean.valueOf(showFinderEntry));
        if (!showFinderEntry) {
            this.FWq.setVisibility(8);
        }
        this.FWC = (TextView) findViewById(R.id.iio);
        this.FWr = (RelativeLayout) findViewById(R.id.flh);
        this.FWr.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMain.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(187401);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainBizAcct.class);
                SettingsTeenModeMain settingsTeenModeMain = SettingsTeenModeMain.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(settingsTeenModeMain, bl.axQ(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                settingsTeenModeMain.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(settingsTeenModeMain, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187401);
            }
        });
        this.FWD = (TextView) findViewById(R.id.iik);
        this.FWs = (RelativeLayout) findViewById(R.id.p9);
        this.FWs.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMain.AnonymousClass10 */

            public final void onClick(View view) {
                AppMethodBeat.i(187402);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainMiniProgram.class);
                SettingsTeenModeMain settingsTeenModeMain = SettingsTeenModeMain.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(settingsTeenModeMain, bl.axQ(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                settingsTeenModeMain.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(settingsTeenModeMain, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187402);
            }
        });
        this.FWu = (RelativeLayout) findViewById(R.id.itb);
        this.FWu.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMain.AnonymousClass11 */

            public final void onClick(View view) {
                AppMethodBeat.i(187403);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
                intent.putExtra("biz_type", 1);
                SettingsTeenModeMain settingsTeenModeMain = SettingsTeenModeMain.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(settingsTeenModeMain, bl.axQ(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                settingsTeenModeMain.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(settingsTeenModeMain, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187403);
            }
        });
        this.FWt = (RelativeLayout) findViewById(R.id.brm);
        this.FWt.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMain.AnonymousClass12 */

            public final void onClick(View view) {
                AppMethodBeat.i(187404);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
                intent.putExtra("biz_type", 2);
                SettingsTeenModeMain settingsTeenModeMain = SettingsTeenModeMain.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(settingsTeenModeMain, bl.axQ(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                settingsTeenModeMain.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(settingsTeenModeMain, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187404);
            }
        });
        this.FWv = (RelativeLayout) findViewById(R.id.dde);
        this.FWv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMain.AnonymousClass13 */

            public final void onClick(View view) {
                AppMethodBeat.i(187405);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
                intent.putExtra("biz_type", 3);
                SettingsTeenModeMain settingsTeenModeMain = SettingsTeenModeMain.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(settingsTeenModeMain, bl.axQ(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                settingsTeenModeMain.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(settingsTeenModeMain, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187405);
            }
        });
        this.FWw = (RelativeLayout) findViewById(R.id.fuj);
        this.FWw.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMain.AnonymousClass14 */

            public final void onClick(View view) {
                AppMethodBeat.i(187406);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
                intent.putExtra("biz_type", 4);
                SettingsTeenModeMain settingsTeenModeMain = SettingsTeenModeMain.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(settingsTeenModeMain, bl.axQ(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                settingsTeenModeMain.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(settingsTeenModeMain, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187406);
            }
        });
        this.FWx = (RelativeLayout) findViewById(R.id.fuk);
        this.FWx.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMain.AnonymousClass15 */

            public final void onClick(View view) {
                AppMethodBeat.i(187407);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
                intent.putExtra("biz_type", 8);
                SettingsTeenModeMain settingsTeenModeMain = SettingsTeenModeMain.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(settingsTeenModeMain, bl.axQ(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                settingsTeenModeMain.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(settingsTeenModeMain, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187407);
            }
        });
        this.FWy = (RelativeLayout) findViewById(R.id.hnn);
        this.FWy.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMain.AnonymousClass16 */

            public final void onClick(View view) {
                AppMethodBeat.i(187408);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
                intent.putExtra("biz_type", 5);
                SettingsTeenModeMain settingsTeenModeMain = SettingsTeenModeMain.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(settingsTeenModeMain, bl.axQ(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                settingsTeenModeMain.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(settingsTeenModeMain, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187408);
            }
        });
        this.FWz = (RelativeLayout) findViewById(R.id.hqm);
        this.FWz.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMain.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(187393);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
                intent.putExtra("biz_type", 6);
                SettingsTeenModeMain settingsTeenModeMain = SettingsTeenModeMain.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(settingsTeenModeMain, bl.axQ(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                settingsTeenModeMain.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(settingsTeenModeMain, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$10", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187393);
            }
        });
        this.FWA = (RelativeLayout) findViewById(R.id.jmb);
        this.FWA.setVisibility(((c) g.af(c.class)).dfq() ? 0 : 8);
        this.FWA.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMain.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(187394);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(SettingsTeenModeMain.this, SettingsTeenModeMainOther.class);
                intent.putExtra("biz_type", 7);
                SettingsTeenModeMain settingsTeenModeMain = SettingsTeenModeMain.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(settingsTeenModeMain, bl.axQ(), "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                settingsTeenModeMain.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(settingsTeenModeMain, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$11", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187394);
            }
        });
        this.hRd = findViewById(R.id.b4l);
        this.hRd.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMain.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(187395);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SettingsTeenModeMain.a(SettingsTeenModeMain.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/teenmode/ui/SettingsTeenModeMain$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187395);
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMain.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(187396);
                SettingsTeenModeMain.this.onBackPressed();
                AppMethodBeat.o(187396);
                return true;
            }
        });
        is(true);
        addTextOptionMenu(0, getString(R.string.hlk), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMain.AnonymousClass6 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(187397);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=youngmode/faq&wechat_real_lang=zh_CN");
                com.tencent.mm.br.c.b(SettingsTeenModeMain.this, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(187397);
                return true;
            }
        });
        AppMethodBeat.o(187413);
    }

    static /* synthetic */ void a(SettingsTeenModeMain settingsTeenModeMain) {
        AppMethodBeat.i(187414);
        settingsTeenModeMain.ojT = new e((Context) settingsTeenModeMain, 1, true);
        TextView textView = new TextView(settingsTeenModeMain.getContext());
        textView.setGravity(17);
        textView.setHeight(com.tencent.mm.cb.a.fromDPToPix((Context) settingsTeenModeMain.getContext(), 40));
        textView.setTextSize(12.0f);
        textView.setTextColor(settingsTeenModeMain.getResources().getColor(R.color.FG_1));
        textView.setText(settingsTeenModeMain.getString(R.string.hlh));
        settingsTeenModeMain.ojT.V(textView, false);
        settingsTeenModeMain.ojT.HLX = new o.f() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMain.AnonymousClass7 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(187398);
                mVar.a(0, SettingsTeenModeMain.this.getResources().getColor(R.color.a5c), SettingsTeenModeMain.this.getString(R.string.hlg));
                AppMethodBeat.o(187398);
            }
        };
        settingsTeenModeMain.ojT.HLY = new o.g() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMain.AnonymousClass8 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(187400);
                if (menuItem.getItemId() == 0) {
                    g.aAh().azQ().set(ar.a.USERINFO_SETTING_TEEN_MODE_STATE_BOOLEAN_SYNC, Boolean.FALSE);
                    g.aAh().azQ().set(ar.a.USERINFO_SETTING_TEEN_MODE_ALREADY_SWITCH_OFF_BOOLEAN, Boolean.TRUE);
                    ((b) g.af(b.class)).fvq();
                    ((b) g.af(b.class)).pl(4);
                    bfx bfx = new bfx();
                    bfx.LPB = 59;
                    bfx.BsD = 2;
                    ((l) g.af(l.class)).aSM().d(new k.a(23, bfx));
                    u.cG(SettingsTeenModeMain.this, SettingsTeenModeMain.this.getString(R.string.hli));
                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMain.AnonymousClass8.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(187399);
                            SettingsTeenModeMain.this.finish();
                            com.tencent.mm.br.c.V(SettingsTeenModeMain.this, "teenmode", ".ui.SettingsTeenModeIntro");
                            SettingsTeenModeMain.this.overridePendingTransition(0, 0);
                            AppMethodBeat.o(187399);
                        }
                    }, 2000);
                }
                AppMethodBeat.o(187400);
            }
        };
        settingsTeenModeMain.ojT.mLN = true;
        settingsTeenModeMain.ojT.mLO = true;
        settingsTeenModeMain.ojT.dGm();
        AppMethodBeat.o(187414);
    }
}
