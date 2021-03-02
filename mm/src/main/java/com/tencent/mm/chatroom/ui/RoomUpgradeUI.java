package com.tencent.mm.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.chatroom.d.m;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.n;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class RoomUpgradeUI extends MMActivity implements i {
    private String chatroomName;
    private int gsf;
    private int gsg;
    private ProgressDialog gtM = null;
    private ah gtd;
    private View gyK;
    private ImageView gyL;
    private TextView gyM;
    private TextView gyN;
    private TextView gyO;
    private TextView gyS;
    private View gyT;
    private TextView gyU;
    private m gyV;
    private String gyW;
    private boolean gyX;
    private boolean gyY;
    private int status;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(RoomUpgradeUI roomUpgradeUI, String str) {
        AppMethodBeat.i(12803);
        roomUpgradeUI.DK(str);
        AppMethodBeat.o(12803);
    }

    static /* synthetic */ void d(RoomUpgradeUI roomUpgradeUI) {
        AppMethodBeat.i(12802);
        roomUpgradeUI.amY();
        AppMethodBeat.o(12802);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(12787);
        super.onCreate(bundle);
        amZ();
        initView();
        AppMethodBeat.o(12787);
    }

    private void amY() {
        AppMethodBeat.i(12789);
        Intent intent = new Intent(this, RoomAlphaProcessUI.class);
        intent.addFlags(67108864);
        intent.addFlags(65536);
        intent.putExtra("RoomInfo_Id", this.chatroomName);
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/chatroom/ui/RoomUpgradeUI", "doUpgrade", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/RoomUpgradeUI", "doUpgrade", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(12789);
    }

    private void amZ() {
        boolean z;
        AppMethodBeat.i(12790);
        this.chatroomName = getIntent().getStringExtra("room_name");
        Log.i("MicroMsg.RoomUpgradeProductsUI", "the roomName is %s", this.chatroomName);
        g.aAg().hqi.a(n.CTRL_INDEX, this);
        this.gtd = ((c) g.af(c.class)).aSX().Kd(this.chatroomName);
        if (this.gtd == null) {
            finish();
            AppMethodBeat.o(12790);
            return;
        }
        this.gyX = z.aTY().equals(this.gtd.field_roomowner);
        if (!LocaleUtil.isSimplifiedChineseAppLang()) {
            z = true;
        } else {
            z = false;
        }
        this.gyY = z;
        AppMethodBeat.o(12790);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(12791);
        setMMTitle(R.string.g9x);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.chatroom.ui.RoomUpgradeUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(12780);
                RoomUpgradeUI.this.finish();
                AppMethodBeat.o(12780);
                return true;
            }
        });
        this.gyK = findViewById(R.id.j0s);
        this.gyT = findViewById(R.id.j0u);
        this.gyL = (ImageView) findViewById(R.id.j0r);
        this.gyM = (TextView) findViewById(R.id.j0t);
        this.gyN = (TextView) findViewById(R.id.j0o);
        this.gyO = (TextView) findViewById(R.id.j0p);
        this.gyU = (TextView) findViewById(R.id.j0n);
        this.gyU.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.chatroom.ui.RoomUpgradeUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(12781);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/RoomUpgradeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                switch (RoomUpgradeUI.this.status) {
                    case 1:
                        if (!RoomUpgradeUI.this.gyY) {
                            RoomUpgradeUI.a(RoomUpgradeUI.this, true);
                            break;
                        } else {
                            b.a(RoomUpgradeUI.this, RoomUpgradeUI.this.chatroomName, true);
                            break;
                        }
                    case 2:
                    case 5:
                        if (!RoomUpgradeUI.this.gyY) {
                            RoomUpgradeUI.a(RoomUpgradeUI.this, false);
                            break;
                        } else {
                            RoomUpgradeUI.d(RoomUpgradeUI.this);
                            break;
                        }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/RoomUpgradeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(12781);
            }
        });
        this.gyS = (TextView) findViewById(R.id.dq8);
        this.gyS.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.chatroom.ui.RoomUpgradeUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(12782);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/RoomUpgradeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (RoomUpgradeUI.this.gyS.getVisibility() == 0) {
                    Intent intent = new Intent();
                    RoomUpgradeUI.this.gyW = RoomUpgradeUI.this.getString(R.string.awk, new Object[]{LocaleUtil.getApplicationLanguage()});
                    intent.putExtra("rawUrl", RoomUpgradeUI.this.gyW);
                    intent.putExtra("geta8key_username", z.aTY());
                    intent.putExtra("showShare", false);
                    com.tencent.mm.br.c.b(RoomUpgradeUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 500);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/RoomUpgradeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(12782);
            }
        });
        if (this.gyX) {
            this.gtM = h.a((Context) this, getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.chatroom.ui.RoomUpgradeUI.AnonymousClass5 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(12785);
                    if (RoomUpgradeUI.this.gyV != null) {
                        g.aAg().hqi.a(RoomUpgradeUI.this.gyV);
                        RoomUpgradeUI.this.gyV = null;
                    }
                    RoomUpgradeUI.this.finish();
                    AppMethodBeat.o(12785);
                }
            });
            this.gyV = new m(this.chatroomName);
            g.aAg().hqi.a(this.gyV, 0);
        } else {
            ana();
            if (!this.gyY) {
                this.gyS.setVisibility(0);
            }
            this.gyS.setText(R.string.g_0);
            this.gyU.setVisibility(8);
            this.gyO.setVisibility(8);
        }
        if (this.gyY) {
            this.gyS.setVisibility(8);
        }
        AppMethodBeat.o(12791);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(12792);
        super.onResume();
        AppMethodBeat.o(12792);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(12793);
        super.onPause();
        AppMethodBeat.o(12793);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(12794);
        g.aAg().hqi.a(this.gyV);
        g.aAg().hqi.b(n.CTRL_INDEX, this);
        if (this.gtM != null) {
            this.gtM.dismiss();
        }
        super.onDestroy();
        AppMethodBeat.o(12794);
    }

    private void ana() {
        AppMethodBeat.i(12795);
        DL(this.gtd.field_roomowner);
        int gBw = this.gtd.gBw();
        this.gyN.setVisibility(0);
        if (gBw <= 40) {
            this.gyN.setText(getString(R.string.g_5, new Object[]{getString(R.string.g9z)}));
            AppMethodBeat.o(12795);
            return;
        }
        this.gyN.setText(getString(R.string.g_5, new Object[]{getString(R.string.g9y)}));
        AppMethodBeat.o(12795);
    }

    private void DL(final String str) {
        AppMethodBeat.i(12796);
        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        if (Kn == null || ((int) Kn.gMZ) > 0) {
            DK(str);
            AppMethodBeat.o(12796);
            return;
        }
        ay.a.iDq.a(str, this.chatroomName, new ay.b.a() {
            /* class com.tencent.mm.chatroom.ui.RoomUpgradeUI.AnonymousClass4 */

            @Override // com.tencent.mm.model.ay.b.a
            public final void p(String str, boolean z) {
                AppMethodBeat.i(12784);
                if (z) {
                    RoomUpgradeUI.this.gyK.post(new Runnable() {
                        /* class com.tencent.mm.chatroom.ui.RoomUpgradeUI.AnonymousClass4.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(12783);
                            RoomUpgradeUI.b(RoomUpgradeUI.this, str);
                            AppMethodBeat.o(12783);
                        }
                    });
                }
                AppMethodBeat.o(12784);
            }
        });
        AppMethodBeat.o(12796);
    }

    private void DK(String str) {
        String str2;
        AppMethodBeat.i(12797);
        as Kn = ((l) g.af(l.class)).aSN().Kn(str);
        if (Kn == null || ((int) Kn.gMZ) <= 0) {
            str2 = null;
        } else {
            str2 = Kn.field_conRemark;
        }
        if (Util.isNullOrNil(str2)) {
            str2 = DH(str);
        }
        if (Util.isNullOrNil(str2) && Kn != null && ((int) Kn.gMZ) > 0) {
            str2 = Kn.arI();
        }
        if (Util.isNullOrNil(str2)) {
            str2 = str;
        }
        a.b.c(this.gyL, str);
        this.gyM.setVisibility(0);
        this.gyM.setText(com.tencent.mm.pluginsdk.ui.span.l.e((Context) this, (CharSequence) str2, (int) this.gyM.getTextSize()));
        AppMethodBeat.o(12797);
    }

    private String DH(String str) {
        AppMethodBeat.i(12798);
        if (this.gtd == null) {
            AppMethodBeat.o(12798);
            return null;
        }
        String displayName = this.gtd.getDisplayName(str);
        AppMethodBeat.o(12798);
        return displayName;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.pt;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(12799);
        Log.d("MicroMsg.RoomUpgradeProductsUI", "onActivityResult . requestCode:" + i2 + "  resultCode:" + i3);
        switch (i2) {
            case 400:
                finish();
                AppMethodBeat.o(12799);
                return;
            default:
                Log.e("MicroMsg.RoomUpgradeProductsUI", "onActivityResult unknow request");
                AppMethodBeat.o(12799);
                return;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(12800);
        Log.d("MicroMsg.RoomUpgradeProductsUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.gtM != null) {
            this.gtM.dismiss();
        }
        if (i2 == 0 && i3 == 0) {
            if (i2 == 0 && i3 == 0 && qVar.getType() == 519) {
                m mVar = (m) qVar;
                this.status = mVar.status;
                this.gsf = mVar.gsf;
                this.gsg = mVar.gsg;
                ana();
                this.gyO.setVisibility(0);
                this.gyU.setText(getString(R.string.g9w));
                if (this.gsg > 0) {
                    this.gyO.setText(getString(R.string.g_3, new Object[]{Integer.valueOf(this.gsg)}));
                } else {
                    this.gyO.setText(getString(R.string.g_4));
                }
                if (!this.gyY) {
                    this.gyS.setVisibility(0);
                }
                switch (this.status) {
                    case 1:
                    case 2:
                    case 5:
                        this.gyU.setVisibility(0);
                        this.gyS.setText(R.string.g_1);
                        AppMethodBeat.o(12800);
                        return;
                    case 3:
                    case 4:
                    case 6:
                        this.gyU.setVisibility(0);
                        this.gyU.setEnabled(false);
                        this.gyS.setText(R.string.g_1);
                        AppMethodBeat.o(12800);
                        return;
                    case 7:
                        this.gyU.setVisibility(8);
                        this.gyS.setText(R.string.g_0);
                        this.gyU.setEnabled(false);
                        break;
                }
            }
            AppMethodBeat.o(12800);
            return;
        }
        h.a((Context) this, getString(R.string.g_2), getString(R.string.zb), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.chatroom.ui.RoomUpgradeUI.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(12786);
                RoomUpgradeUI.this.finish();
                AppMethodBeat.o(12786);
            }
        });
        AppMethodBeat.o(12800);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        boolean z;
        AppMethodBeat.i(12788);
        if (intent.hasExtra("upgrade_success")) {
            z = intent.getBooleanExtra("upgrade_success", false);
        } else {
            if (intent.hasExtra("wizard_activity_result_code") && intent.getIntExtra("wizard_activity_result_code", -1) == -1) {
                amY();
            }
            if (intent.hasExtra("announce_ok")) {
                amY();
            }
            z = false;
        }
        if (z) {
            amZ();
            int intExtra = intent.getIntExtra("left_quota", 0);
            ana();
            this.gyU.setVisibility(8);
            this.gsg = intExtra;
            if (this.gsg > 0) {
                this.gyO.setText(getString(R.string.g_3, new Object[]{Integer.valueOf(this.gsg)}));
            } else {
                this.gyO.setText(getString(R.string.g_4));
            }
            if (!this.gyY) {
                this.gyS.setVisibility(0);
            }
            this.gyS.setText(R.string.g_0);
            AppMethodBeat.o(12788);
            return;
        }
        AppMethodBeat.o(12788);
    }

    static /* synthetic */ void a(RoomUpgradeUI roomUpgradeUI, boolean z) {
        AppMethodBeat.i(12801);
        Intent intent = new Intent(roomUpgradeUI, RoomAnnouncementUI.class);
        intent.putExtra("need_bind_mobile", z);
        intent.putExtra("RoomInfo_Id", roomUpgradeUI.chatroomName);
        roomUpgradeUI.startActivityForResult(intent, 600);
        AppMethodBeat.o(12801);
    }
}
