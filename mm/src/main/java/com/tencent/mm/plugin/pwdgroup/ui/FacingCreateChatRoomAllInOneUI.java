package com.tencent.mm.plugin.pwdgroup.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.appbrand.jsapi.w.c;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.protobuf.amg;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMScrollGridView;
import com.tencent.tavkit.component.TAVExporter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FacingCreateChatRoomAllInOneUI extends MMActivity implements i {
    private a BoA;
    private View BoB;
    private TextView BoC;
    private MMScrollGridView BoD;
    private View BoE;
    private View BoF;
    private Button BoG;
    private MMCallBackScrollView BoH;
    private TextView BoI;
    private boolean BoJ = false;
    private Runnable BoK;
    private MMHandler BoL;
    private MTimerHandler BoM = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(27622);
            FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this);
            AppMethodBeat.o(27622);
            return false;
        }
    }, false);
    private com.tencent.mm.plugin.pwdgroup.a.a BoN;
    private com.tencent.mm.plugin.pwdgroup.a.a BoO;
    private int BoP;
    private Animation BoQ;
    private AnimationSet BoR;
    private Animation BoS;
    public MenuItem.OnMenuItemClickListener BoT = new MenuItem.OnMenuItemClickListener() {
        /* class com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.AnonymousClass12 */

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(27633);
            FacingCreateChatRoomAllInOneUI.this.finish();
            AppMethodBeat.o(27633);
            return false;
        }
    };
    public MMPwdInputView.a BoU = new MMPwdInputView.a() {
        /* class com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.AnonymousClass13 */

        @Override // com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView.a
        public final void z(boolean z, String str) {
            AppMethodBeat.i(27634);
            Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onFinishInput] %b %s", Boolean.valueOf(z), str);
            FacingCreateChatRoomAllInOneUI.this.Boo = str;
            if (z) {
                FacingCreateChatRoomAllInOneUI.this.Boj = true;
                FacingCreateChatRoomAllInOneUI.e(FacingCreateChatRoomAllInOneUI.this);
            }
            AppMethodBeat.o(27634);
        }
    };
    private View.OnClickListener BoV = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.AnonymousClass14 */

        public final void onClick(View view) {
            AppMethodBeat.i(27635);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/pwdgroup/ui/FacingCreateChatRoomAllInOneUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FacingCreateChatRoomAllInOneUI.this.Bov = false;
            FacingCreateChatRoomAllInOneUI.d(FacingCreateChatRoomAllInOneUI.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/pwdgroup/ui/FacingCreateChatRoomAllInOneUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(27635);
        }
    };
    public MMKeyBoardView.a BoW = new MMKeyBoardView.a() {
        /* class com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.AnonymousClass15 */

        @Override // com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView.a
        public final void input(String str) {
            AppMethodBeat.i(27636);
            if (FacingCreateChatRoomAllInOneUI.this.Bop != null) {
                if (FacingCreateChatRoomAllInOneUI.this.Boi || FacingCreateChatRoomAllInOneUI.this.Bom) {
                    MMPwdInputView mMPwdInputView = FacingCreateChatRoomAllInOneUI.this.Bop;
                    mMPwdInputView.byC();
                    mMPwdInputView.input(str);
                    FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, a.Normal);
                    AppMethodBeat.o(27636);
                    return;
                }
                FacingCreateChatRoomAllInOneUI.this.Bop.input(str);
            }
            AppMethodBeat.o(27636);
        }

        @Override // com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView.a
        public final void byC() {
            AppMethodBeat.i(27637);
            if (FacingCreateChatRoomAllInOneUI.this.Bop != null) {
                FacingCreateChatRoomAllInOneUI.this.Bop.byC();
            }
            AppMethodBeat.o(27637);
        }

        @Override // com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView.a
        public final void delete() {
            AppMethodBeat.i(27638);
            if (FacingCreateChatRoomAllInOneUI.this.Bop != null) {
                if (FacingCreateChatRoomAllInOneUI.this.Boi || FacingCreateChatRoomAllInOneUI.this.Bom) {
                    FacingCreateChatRoomAllInOneUI.this.Bop.byC();
                    FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, a.Normal);
                    AppMethodBeat.o(27638);
                    return;
                }
                MMPwdInputView mMPwdInputView = FacingCreateChatRoomAllInOneUI.this.Bop;
                if (mMPwdInputView.sWx > 0) {
                    mMPwdInputView.gBy.deleteCharAt(mMPwdInputView.sWx - 1);
                }
                mMPwdInputView.cTV();
                mMPwdInputView.eFX();
            }
            AppMethodBeat.o(27638);
        }
    };
    private MTimerHandler BoX = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.AnonymousClass17 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(27641);
            FacingCreateChatRoomAllInOneUI.this.Boj = false;
            FacingCreateChatRoomAllInOneUI.a(FacingCreateChatRoomAllInOneUI.this, a.Unknow);
            AppMethodBeat.o(27641);
            return true;
        }
    }, false);
    private d Boh;
    private boolean Boi = false;
    private boolean Boj;
    private boolean Bok;
    private boolean Bol;
    private boolean Bom = false;
    private Location Bon;
    private String Boo;
    private MMPwdInputView Bop;
    private View Boq;
    private ProgressBar Bor;
    private TextView Bos;
    private MMKeyBoardView Bot;
    private TextView Bou;
    private boolean Bov = false;
    private boolean Bow = false;
    private LinkedList<amg> Box = new LinkedList<>();
    private HashMap<String, amg> Boy = new HashMap<>();
    private LinkedList<amg> Boz = new LinkedList<>();
    private b.a gmA = new b.a() {
        /* class com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.AnonymousClass16 */

        @Override // com.tencent.mm.modelgeo.b.a
        public final boolean a(boolean z, float f2, float f3, int i2, double d2, double d3) {
            AppMethodBeat.i(27640);
            Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "lat:%f lng:%f accuracy:%f", Float.valueOf(f3), Float.valueOf(f2), Double.valueOf(d3));
            if (z) {
                Location location = new Location(f3, f2, (int) d3, i2, "", "");
                if (!location.gnj()) {
                    FacingCreateChatRoomAllInOneUI.this.Bon = location;
                    FacingCreateChatRoomAllInOneUI.this.Bok = true;
                    FacingCreateChatRoomAllInOneUI.e(FacingCreateChatRoomAllInOneUI.this);
                }
            } else {
                if (!FacingCreateChatRoomAllInOneUI.this.uSu && !d.bcc()) {
                    FacingCreateChatRoomAllInOneUI.this.uSu = true;
                    h.a((Context) FacingCreateChatRoomAllInOneUI.this, FacingCreateChatRoomAllInOneUI.this.getString(R.string.dvi), FacingCreateChatRoomAllInOneUI.this.getString(R.string.zb), FacingCreateChatRoomAllInOneUI.this.getString(R.string.e_k), FacingCreateChatRoomAllInOneUI.this.getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.AnonymousClass16.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(27639);
                            d.cZ(FacingCreateChatRoomAllInOneUI.this);
                            AppMethodBeat.o(27639);
                        }
                    }, (DialogInterface.OnClickListener) null);
                }
                FacingCreateChatRoomAllInOneUI.this.Bok = false;
            }
            AppMethodBeat.o(27640);
            return false;
        }
    };
    private String gwF;
    private ProgressDialog jZH;
    private MMHandler mHandler = new MMHandler() {
        /* class com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.AnonymousClass11 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(27632);
            switch (message.what) {
                case 10001:
                    if (FacingCreateChatRoomAllInOneUI.this.BoA != null) {
                        FacingCreateChatRoomAllInOneUI.this.BoA.setData(FacingCreateChatRoomAllInOneUI.this.Box);
                        AppMethodBeat.o(27632);
                        return;
                    }
                    break;
                case 10002:
                    FacingCreateChatRoomAllInOneUI.d(FacingCreateChatRoomAllInOneUI.this);
                    break;
            }
            AppMethodBeat.o(27632);
        }
    };
    private boolean pjO = false;
    private boolean uSu;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FacingCreateChatRoomAllInOneUI() {
        AppMethodBeat.i(27646);
        AppMethodBeat.o(27646);
    }

    static /* synthetic */ void a(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI, a aVar) {
        AppMethodBeat.i(27667);
        facingCreateChatRoomAllInOneUI.a(aVar);
        AppMethodBeat.o(27667);
    }

    /* access modifiers changed from: package-private */
    public enum a {
        Normal,
        Loading,
        ToSimple,
        Unknow;

        public static a valueOf(String str) {
            AppMethodBeat.i(27644);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(27644);
            return aVar;
        }

        static {
            AppMethodBeat.i(27645);
            AppMethodBeat.o(27645);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.a6s;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(27647);
        customfixStatusbar(true);
        super.onCreate(bundle);
        if (!com.tencent.mm.aw.b.Pi((String) g.aAh().azQ().get(274436, (Object) null))) {
            boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_FINE_LOCATION", 64, (String) null, (String) null);
            Log.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "summerper checkPermission checkCamera[%b]", Boolean.valueOf(a2));
            if (!a2) {
                AppMethodBeat.o(27647);
                return;
            }
        } else if (!com.tencent.mm.pluginsdk.permission.b.n(this, "android.permission.ACCESS_FINE_LOCATION")) {
            if (!((Boolean) g.aAh().azQ().get(ar.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                com.tencent.mm.plugin.account.a.b.a.b(this, getString(R.string.el_, new Object[]{LocaleUtil.getApplicationLanguage()}), 30764, true);
                AppMethodBeat.o(27647);
                return;
            }
            com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_FINE_LOCATION", 64);
            AppMethodBeat.o(27647);
            return;
        }
        bnD();
        AppMethodBeat.o(27647);
    }

    private void bnD() {
        AppMethodBeat.i(27648);
        this.Boh = d.bca();
        this.Boh.a(this.gmA, true);
        bg.azz().a(c.b.CTRL_INDEX, this);
        getWindow().getDecorView().setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
        initView();
        AppMethodBeat.o(27648);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(27649);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(27649);
            return;
        }
        Log.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 64:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.fl_), getString(R.string.flp), getString(R.string.e_k), getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.AnonymousClass18 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(27642);
                            FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI = FacingCreateChatRoomAllInOneUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(facingCreateChatRoomAllInOneUI, bl.axQ(), "com/tencent/mm/plugin/pwdgroup/ui/FacingCreateChatRoomAllInOneUI$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            facingCreateChatRoomAllInOneUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(facingCreateChatRoomAllInOneUI, "com/tencent/mm/plugin/pwdgroup/ui/FacingCreateChatRoomAllInOneUI$9", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            FacingCreateChatRoomAllInOneUI.this.finish();
                            AppMethodBeat.o(27642);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(27623);
                            FacingCreateChatRoomAllInOneUI.this.finish();
                            AppMethodBeat.o(27623);
                        }
                    });
                    break;
                } else {
                    bnD();
                    AppMethodBeat.o(27649);
                    return;
                }
        }
        AppMethodBeat.o(27649);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(27650);
        if (this.Boh != null) {
            this.Boh.a(this.gmA, true);
        }
        if (this.BoJ) {
            eFT();
        }
        super.onResume();
        AppMethodBeat.o(27650);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(27651);
        if (this.Boh != null) {
            this.Boh.c(this.gmA);
        }
        if (this.BoJ) {
            eFU();
        }
        super.onPause();
        AppMethodBeat.o(27651);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(27652);
        bg.azz().b(c.b.CTRL_INDEX, this);
        if (this.Boh != null) {
            this.Boh.c(this.gmA);
        }
        if (!this.Bow) {
            bg.azz().cancel(c.b.CTRL_INDEX);
            if (this.Bon != null) {
                this.BoO = new com.tencent.mm.plugin.pwdgroup.a.a(2, this.Boo, "", this.Bon.iUY, this.Bon.iUZ, this.Bon.accuracy, this.Bon.dTl, this.Bon.mac, this.Bon.dTn);
                bg.azz().a(this.BoO, 0);
            }
        }
        if (this.BoJ) {
            eFU();
        }
        if (!(this.BoL == null || this.BoK == null)) {
            this.BoL.removeCallbacks(this.BoK);
        }
        super.onDestroy();
        AppMethodBeat.o(27652);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(27653);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 30764) {
            if (intent != null) {
                Bundle bundleExtra = intent.getBundleExtra("result_data");
                if (bundleExtra == null || !bundleExtra.getString("go_next", "").equals("gdpr_auth_location")) {
                    finish();
                    AppMethodBeat.o(27653);
                    return;
                }
                g.aAh().azQ().set(ar.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.TRUE);
                com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_FINE_LOCATION", 64);
                AppMethodBeat.o(27653);
                return;
            }
            finish();
        }
        AppMethodBeat.o(27653);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(27654);
        setMMTitle(R.string.cf3);
        setBackBtn(this.BoT);
        setActionbarColor(getResources().getColor(R.color.ac_));
        this.Boq = findViewById(R.id.cal);
        this.Bor = (ProgressBar) findViewById(R.id.cak);
        this.Bos = (TextView) findViewById(R.id.cam);
        this.Bot = (MMKeyBoardView) findViewById(R.id.caj);
        this.Bou = (TextView) findViewById(R.id.cai);
        this.Bop = (MMPwdInputView) findViewById(R.id.cag);
        this.Bop.setOnFinishInputListener(this.BoU);
        this.Bop.requestFocus();
        this.Bot.setOnInputDeleteListener(this.BoW);
        a(a.Normal);
        this.BoB = findViewById(R.id.ca_);
        this.BoC = (TextView) findViewById(R.id.cab);
        this.BoD = (MMScrollGridView) findViewById(R.id.caa);
        this.BoD.setVisibility(4);
        this.BoG = (Button) findViewById(R.id.cac);
        this.BoG.setOnClickListener(this.BoV);
        this.BoE = findViewById(R.id.cad);
        this.BoF = findViewById(R.id.cae);
        this.BoC.setText(R.string.c85);
        this.BoH = (MMCallBackScrollView) findViewById(R.id.can);
        this.BoI = (TextView) findViewById(R.id.cah);
        this.BoH.setMMOnScrollListener(new MMCallBackScrollView.a() {
            /* class com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView.a
            public final void onScrollStateChanged(int i2) {
                AppMethodBeat.i(27624);
                if (FacingCreateChatRoomAllInOneUI.this.BoF != null) {
                    if (i2 == 0) {
                        FacingCreateChatRoomAllInOneUI.this.BoF.setVisibility(4);
                        AppMethodBeat.o(27624);
                        return;
                    }
                    FacingCreateChatRoomAllInOneUI.this.BoF.setVisibility(0);
                }
                AppMethodBeat.o(27624);
            }
        });
        this.BoA = new a(this);
        this.BoD.setAdapter((ListAdapter) this.BoA);
        this.BoA.setData(this.Box);
        AppMethodBeat.o(27654);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(27655);
        Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        switch (qVar.getType()) {
            case c.b.CTRL_INDEX:
                com.tencent.mm.plugin.pwdgroup.a.a aVar = (com.tencent.mm.plugin.pwdgroup.a.a) qVar;
                int i4 = aVar.dKp;
                if (i4 == 0) {
                    this.Bol = false;
                    if (this.BoJ) {
                        if (this.BoM != null) {
                            this.BoM.startTimer(3000);
                        }
                        if (i2 == 0 && i3 == 0) {
                            final LinkedList<amg> linkedList = aVar.eFS().KGQ;
                            if (this.BoL == null) {
                                this.BoL = new MMHandler("FacingCreateChatRoomAllInOneUI");
                            }
                            if (this.BoK != null) {
                                this.BoL.removeCallbacks(this.BoK);
                            }
                            this.BoK = new Runnable() {
                                /* class com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.AnonymousClass7 */

                                public final void run() {
                                    AppMethodBeat.i(27628);
                                    if (FacingCreateChatRoomAllInOneUI.this.Boz != null) {
                                        FacingCreateChatRoomAllInOneUI.this.Boz.clear();
                                    }
                                    if (FacingCreateChatRoomAllInOneUI.this.Boy != null) {
                                        FacingCreateChatRoomAllInOneUI.this.Boy.clear();
                                    }
                                    if (linkedList != null && linkedList.size() > 0) {
                                        int size = linkedList.size();
                                        for (int i2 = 0; i2 < size; i2++) {
                                            amg amg = (amg) linkedList.get(i2);
                                            if (!Util.isNullOrNil(amg.LuX)) {
                                                FacingCreateChatRoomAllInOneUI.this.Boy.put(amg.LuX, amg);
                                            }
                                        }
                                    }
                                    int size2 = FacingCreateChatRoomAllInOneUI.this.Box.size();
                                    for (int i3 = 0; i3 < size2; i3++) {
                                        amg amg2 = (amg) FacingCreateChatRoomAllInOneUI.this.Box.get(i3);
                                        if (!FacingCreateChatRoomAllInOneUI.this.Boy.containsKey(amg2.LuX)) {
                                            Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] delete member name:%s", amg2.LuX);
                                        } else {
                                            FacingCreateChatRoomAllInOneUI.this.Boy.remove(amg2.LuX);
                                        }
                                    }
                                    if (FacingCreateChatRoomAllInOneUI.this.Boy != null && FacingCreateChatRoomAllInOneUI.this.Boy.size() > 0) {
                                        for (Map.Entry entry : FacingCreateChatRoomAllInOneUI.this.Boy.entrySet()) {
                                            amg amg3 = (amg) entry.getValue();
                                            FacingCreateChatRoomAllInOneUI.this.Boz.add(amg3);
                                            Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[updateMember] add member name:%s", amg3.LuX);
                                        }
                                    }
                                    FacingCreateChatRoomAllInOneUI.this.Box.addAll(FacingCreateChatRoomAllInOneUI.this.Boz);
                                    FacingCreateChatRoomAllInOneUI.this.mHandler.sendEmptyMessage(10001);
                                    AppMethodBeat.o(27628);
                                }
                            };
                            this.BoL.post(this.BoK);
                            this.gwF = aVar.eFS().Bri;
                            AppMethodBeat.o(27655);
                            return;
                        }
                    } else if (i2 == 0 && i3 == 0) {
                        a(a.Normal);
                        this.BoP = this.Bou.getHeight();
                        Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "mFacingInputMsgViewHeigth:%d", Integer.valueOf(this.BoP));
                        this.BoQ = AnimationUtils.loadAnimation(this, R.anim.bi);
                        this.BoS = AnimationUtils.loadAnimation(this, R.anim.b9);
                        this.BoR = new AnimationSet(true);
                        this.BoR.addAnimation(AnimationUtils.loadAnimation(this, R.anim.e7));
                        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-this.BoP));
                        translateAnimation.setDuration(300);
                        this.BoR.addAnimation(translateAnimation);
                        this.BoQ.setDuration(200);
                        this.BoR.setDuration(300);
                        this.BoS.setDuration(300);
                        this.BoQ.setInterpolator(new AccelerateDecelerateInterpolator());
                        this.BoR.setInterpolator(new AccelerateDecelerateInterpolator());
                        this.BoS.setInterpolator(new AccelerateDecelerateInterpolator());
                        this.BoR.setFillAfter(true);
                        translateAnimation.setFillAfter(true);
                        this.BoR.setAnimationListener(new Animation.AnimationListener() {
                            /* class com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.AnonymousClass4 */

                            public final void onAnimationStart(Animation animation) {
                                AppMethodBeat.i(27625);
                                FacingCreateChatRoomAllInOneUI.this.BoB.setVisibility(4);
                                AppMethodBeat.o(27625);
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }

                            public final void onAnimationEnd(Animation animation) {
                                AppMethodBeat.i(27626);
                                FacingCreateChatRoomAllInOneUI.this.BoI.setVisibility(8);
                                FacingCreateChatRoomAllInOneUI.this.Bop.setVisibility(0);
                                FacingCreateChatRoomAllInOneUI.this.BoD.setVisibility(0);
                                FacingCreateChatRoomAllInOneUI.this.BoE.setVisibility(0);
                                FacingCreateChatRoomAllInOneUI.this.BoB.setVisibility(0);
                                FacingCreateChatRoomAllInOneUI.this.Boq.setVisibility(8);
                                FacingCreateChatRoomAllInOneUI.this.Bot.setVisibility(8);
                                FacingCreateChatRoomAllInOneUI.this.Bop.clearAnimation();
                                FacingCreateChatRoomAllInOneUI.this.BoD.clearAnimation();
                                FacingCreateChatRoomAllInOneUI.this.BoB.clearAnimation();
                                AppMethodBeat.o(27626);
                            }
                        });
                        this.Bop.setVisibility(4);
                        this.Bop.setAnimation(translateAnimation);
                        this.Bot.startAnimation(this.BoQ);
                        this.Boq.startAnimation(this.BoQ);
                        this.Bou.startAnimation(this.BoQ);
                        this.BoE.startAnimation(this.BoS);
                        this.BoB.startAnimation(this.BoR);
                        this.BoE.setVisibility(4);
                        this.Bot.setVisibility(8);
                        this.Bou.setVisibility(8);
                        this.BoJ = true;
                        eFT();
                        AppMethodBeat.o(27655);
                        return;
                    } else if (i3 == -431) {
                        this.Boi = true;
                        a(a.ToSimple);
                        AppMethodBeat.o(27655);
                        return;
                    } else {
                        this.Boi = true;
                        a(a.Unknow);
                        AppMethodBeat.o(27655);
                        return;
                    }
                } else if (i4 == 3) {
                    if (!(i2 == 0 && i3 == 0)) {
                        if (i3 == -431) {
                            a(a.ToSimple);
                            this.Boi = true;
                            AppMethodBeat.o(27655);
                            return;
                        }
                        a(a.Unknow);
                        AppMethodBeat.o(27655);
                        return;
                    }
                } else if (i4 != 1) {
                    hideLoading();
                    AppMethodBeat.o(27655);
                    return;
                } else if (i2 == 0 && i3 == 0) {
                    hideLoading();
                    String str2 = aVar.eFS().KGO;
                    Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "ChatRoomName is:%s", String.valueOf(str2));
                    this.Bow = true;
                    finish();
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", str2);
                    com.tencent.mm.plugin.pwdgroup.a.jRt.d(intent, this);
                    AppMethodBeat.o(27655);
                    return;
                } else if (i3 == -432 && !this.Bov) {
                    this.Bov = true;
                    this.mHandler.sendEmptyMessageDelayed(10002, 3000);
                    AppMethodBeat.o(27655);
                    return;
                } else if (i3 == -23) {
                    hideLoading();
                    amW(getString(R.string.c87));
                    if (this.BoM != null) {
                        this.BoM.startTimer(3000);
                        AppMethodBeat.o(27655);
                        return;
                    }
                } else {
                    hideLoading();
                    com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
                    if (Dk != null) {
                        Dk.a(getContext(), null, null);
                    } else {
                        amW(getString(R.string.ft3));
                    }
                    if (this.BoM != null) {
                        this.BoM.startTimer(3000);
                    }
                    AppMethodBeat.o(27655);
                    return;
                }
                break;
            default:
                Log.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd] unknow scene type");
                break;
        }
        AppMethodBeat.o(27655);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(27656);
        super.onBackPressed();
        finish();
        AppMethodBeat.o(27656);
    }

    private void sQ(boolean z) {
        AppMethodBeat.i(27657);
        if (this.Bot != null) {
            this.Bot.setKeyBoardEnable(z);
        }
        AppMethodBeat.o(27657);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void a(a aVar) {
        AppMethodBeat.i(27658);
        if (this.Bos != null) {
            switch (aVar) {
                case Normal:
                    sQ(true);
                    this.Boi = false;
                    this.Bom = false;
                    this.Bor.setVisibility(8);
                    this.Bos.setVisibility(8);
                    AppMethodBeat.o(27658);
                    return;
                case Loading:
                    sQ(false);
                    this.Bos.setText(R.string.ft4);
                    this.Bor.setVisibility(0);
                    this.Bos.setVisibility(8);
                    AppMethodBeat.o(27658);
                    return;
                case ToSimple:
                    sQ(true);
                    this.Bor.setVisibility(8);
                    this.Bos.setVisibility(0);
                    this.Bos.setText(R.string.ft1);
                    eFV();
                    AppMethodBeat.o(27658);
                    return;
                case Unknow:
                    sQ(true);
                    this.Bor.setVisibility(8);
                    this.Bos.setVisibility(0);
                    this.Bos.setText(R.string.ft3);
                    eFV();
                    AppMethodBeat.o(27658);
                    return;
                default:
                    Log.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "unknow statue tip");
                    break;
            }
        }
        AppMethodBeat.o(27658);
    }

    private void hideLoading() {
        AppMethodBeat.i(27659);
        if (this.jZH != null && this.jZH.isShowing()) {
            this.jZH.dismiss();
        }
        AppMethodBeat.o(27659);
    }

    private void amW(String str) {
        AppMethodBeat.i(27660);
        h.a(this, str, "", getString(R.string.x_), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(27660);
    }

    private void eFT() {
        AppMethodBeat.i(27661);
        this.pjO = false;
        if (this.BoM != null) {
            this.BoM.startTimer(0);
        }
        AppMethodBeat.o(27661);
    }

    private void eFU() {
        AppMethodBeat.i(27662);
        this.pjO = true;
        if (this.BoM != null) {
            this.BoM.stopTimer();
        }
        bg.azz().a(this.BoN);
        AppMethodBeat.o(27662);
    }

    private void eFV() {
        AppMethodBeat.i(27663);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.o);
        final Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R.anim.n);
        loadAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.AnonymousClass8 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(27629);
                FacingCreateChatRoomAllInOneUI.this.Bop.byC();
                FacingCreateChatRoomAllInOneUI.this.Bop.startAnimation(loadAnimation2);
                AppMethodBeat.o(27629);
            }
        });
        loadAnimation2.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.AnonymousClass9 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(27630);
                if (FacingCreateChatRoomAllInOneUI.this.Bot != null) {
                    FacingCreateChatRoomAllInOneUI.this.Bot.setKeyBoardEnable(true);
                }
                AppMethodBeat.o(27630);
            }
        });
        if (this.Bop != null) {
            this.Bop.startAnimation(loadAnimation);
        }
        if (this.Bot != null) {
            this.Bot.setKeyBoardEnable(false);
        }
        AppMethodBeat.o(27663);
    }

    static /* synthetic */ void a(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        AppMethodBeat.i(27664);
        if (facingCreateChatRoomAllInOneUI.pjO || facingCreateChatRoomAllInOneUI.Bon == null) {
            Log.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cancel refresh chat room member.");
            AppMethodBeat.o(27664);
            return;
        }
        Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[tryDoSearchScene]-----------");
        facingCreateChatRoomAllInOneUI.BoN = new com.tencent.mm.plugin.pwdgroup.a.a(0, facingCreateChatRoomAllInOneUI.Boo, facingCreateChatRoomAllInOneUI.gwF, facingCreateChatRoomAllInOneUI.Bon.iUY, facingCreateChatRoomAllInOneUI.Bon.iUZ, facingCreateChatRoomAllInOneUI.Bon.accuracy, facingCreateChatRoomAllInOneUI.Bon.dTl, facingCreateChatRoomAllInOneUI.Bon.mac, facingCreateChatRoomAllInOneUI.Bon.dTn);
        bg.azz().a(facingCreateChatRoomAllInOneUI.BoN, 0);
        AppMethodBeat.o(27664);
    }

    static /* synthetic */ void d(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        AppMethodBeat.i(27665);
        facingCreateChatRoomAllInOneUI.getString(R.string.zb);
        facingCreateChatRoomAllInOneUI.jZH = h.a((Context) facingCreateChatRoomAllInOneUI, facingCreateChatRoomAllInOneUI.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.pwdgroup.ui.FacingCreateChatRoomAllInOneUI.AnonymousClass5 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(27627);
                FacingCreateChatRoomAllInOneUI.eFW();
                AppMethodBeat.o(27627);
            }
        });
        facingCreateChatRoomAllInOneUI.eFU();
        bg.azz().a(new com.tencent.mm.plugin.pwdgroup.a.a(1, facingCreateChatRoomAllInOneUI.Boo, facingCreateChatRoomAllInOneUI.gwF, facingCreateChatRoomAllInOneUI.Bon.iUY, facingCreateChatRoomAllInOneUI.Bon.iUZ, facingCreateChatRoomAllInOneUI.Bon.accuracy, facingCreateChatRoomAllInOneUI.Bon.dTl, facingCreateChatRoomAllInOneUI.Bon.mac, facingCreateChatRoomAllInOneUI.Bon.dTn), 0);
        AppMethodBeat.o(27665);
    }

    static /* synthetic */ void e(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        AppMethodBeat.i(27666);
        Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[tryGetChatRoomUser]");
        if (facingCreateChatRoomAllInOneUI.BoX != null) {
            facingCreateChatRoomAllInOneUI.BoX.stopTimer();
        }
        if (!facingCreateChatRoomAllInOneUI.Bok) {
            Log.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "tryGetChatRoomUser location is no ready.");
            facingCreateChatRoomAllInOneUI.a(a.Loading);
            if (facingCreateChatRoomAllInOneUI.BoX != null) {
                facingCreateChatRoomAllInOneUI.BoX.startTimer(15000);
            }
            AppMethodBeat.o(27666);
            return;
        }
        if (facingCreateChatRoomAllInOneUI.Boj) {
            facingCreateChatRoomAllInOneUI.a(a.Loading);
        }
        if (facingCreateChatRoomAllInOneUI.Bok && facingCreateChatRoomAllInOneUI.Boj && !facingCreateChatRoomAllInOneUI.Bol) {
            Log.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "do tryGetChatRoomUser");
            facingCreateChatRoomAllInOneUI.Bol = true;
            facingCreateChatRoomAllInOneUI.Boj = false;
            facingCreateChatRoomAllInOneUI.BoO = new com.tencent.mm.plugin.pwdgroup.a.a(0, facingCreateChatRoomAllInOneUI.Boo, "", facingCreateChatRoomAllInOneUI.Bon.iUY, facingCreateChatRoomAllInOneUI.Bon.iUZ, facingCreateChatRoomAllInOneUI.Bon.accuracy, facingCreateChatRoomAllInOneUI.Bon.dTl, facingCreateChatRoomAllInOneUI.Bon.mac, facingCreateChatRoomAllInOneUI.Bon.dTn);
            bg.azz().a(facingCreateChatRoomAllInOneUI.BoO, 0);
        }
        AppMethodBeat.o(27666);
    }

    static /* synthetic */ void eFW() {
        AppMethodBeat.i(27668);
        bg.azz().cancel(c.b.CTRL_INDEX);
        AppMethodBeat.o(27668);
    }
}
