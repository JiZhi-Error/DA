package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.pay.tool.APPluginConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.cc.h;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.b.a.ka;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.platformtools.b;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.friend.a.ag;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.x;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.vfs.o;
import com.tencent.wxmm.v2helper;
import java.util.LinkedList;

public class RegSetInfoUI extends MMActivity implements i {
    private ProgressDialog gtM = null;
    private String gwF;
    private SecurityImage kdp = null;
    private ka kkY = new ka();
    private b kmf;
    private String knu;
    private int koh;
    private int kon;
    private int kop;
    private boolean kpI = false;
    private String kph;
    private EditText kqA;
    private boolean krA = false;
    private ImageView krB;
    private int krC = 3;
    private LinkedList<String> krD = new LinkedList<>();
    private ImageView krE;
    private ProgressBar krF;
    private String krG = "";
    private ImageView krH;
    private View krI;
    private TextView krJ;
    private String krK = null;
    private boolean krL = false;
    private p krM;
    private View krN;
    private boolean krO = false;
    private String krP;
    private MTimerHandler krQ = new MTimerHandler(Looper.myLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.account.ui.RegSetInfoUI.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            String str;
            AppMethodBeat.i(128668);
            String trim = RegSetInfoUI.this.krr.getText().toString().trim();
            String trim2 = RegSetInfoUI.this.kqA.getText().toString().trim();
            if (Util.isNullOrNil(trim) && !Util.isNullOrNil(trim2)) {
                trim = trim2.length() > 5 ? trim2.substring(0, 5) : trim2;
            }
            if (Util.isNullOrNil(trim) || !Util.isNullOrNil(trim2)) {
                str = trim2;
            } else {
                str = trim;
            }
            if (!Util.isNullOrNil(trim) && RegSetInfoUI.c(RegSetInfoUI.this) && RegSetInfoUI.d(RegSetInfoUI.this)) {
                int e2 = RegSetInfoUI.e(RegSetInfoUI.this);
                String f2 = RegSetInfoUI.f(RegSetInfoUI.this);
                g.azz().a(v2helper.EMethodSetIosMicAbCheckOff, RegSetInfoUI.this);
                g.azz().a(new ag(f2, RegSetInfoUI.this.gwF, e2, str, trim, "", ""), 0);
                RegSetInfoUI.this.krF.setVisibility(0);
            }
            AppMethodBeat.o(128668);
            return false;
        }
    }, true);
    private EditText krr;
    private Button krs;
    private String krt;
    private String kru;
    private int krv;
    private String krw;
    private String krx;
    private TextView kry;
    private View krz;
    private String nickName;
    private int sceneType = 0;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RegSetInfoUI() {
        AppMethodBeat.i(128701);
        AppMethodBeat.o(128701);
    }

    static /* synthetic */ boolean c(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.i(128717);
        boolean bpK = regSetInfoUI.bpK();
        AppMethodBeat.o(128717);
        return bpK;
    }

    static /* synthetic */ boolean d(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.i(128718);
        boolean bpN = regSetInfoUI.bpN();
        AppMethodBeat.o(128718);
        return bpN;
    }

    static /* synthetic */ int e(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.i(128719);
        int bpT = regSetInfoUI.bpT();
        AppMethodBeat.o(128719);
        return bpT;
    }

    static /* synthetic */ String f(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.i(128720);
        String bpU = regSetInfoUI.bpU();
        AppMethodBeat.o(128720);
        return bpU;
    }

    static /* synthetic */ void n(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.i(128721);
        regSetInfoUI.bpL();
        AppMethodBeat.o(128721);
    }

    static /* synthetic */ void s(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.i(128723);
        regSetInfoUI.q(false, false);
        AppMethodBeat.o(128723);
    }

    static /* synthetic */ void w(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.i(128724);
        regSetInfoUI.bnm();
        AppMethodBeat.o(128724);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128702);
        super.onCreate(bundle);
        String string = getString(R.string.g16);
        if (d.KyR || BuildInfo.IS_FLAVOR_BLUE) {
            string = getString(R.string.wx) + h.jr(this);
        }
        setMMTitle(string);
        a.jRu.Xc();
        this.krt = getIntent().getStringExtra("regsetinfo_user");
        this.kru = getIntent().getStringExtra("regsetinfo_bind_email");
        this.gwF = getIntent().getStringExtra("regsetinfo_ticket");
        this.krw = getIntent().getStringExtra("regsetinfo_pwd");
        this.krx = getIntent().getStringExtra("regsetinfo_binduin");
        this.koh = getIntent().getIntExtra("mobile_check_type", 0);
        if (!Util.isNullOrNil(this.krx)) {
            this.krv = com.tencent.mm.b.p.fd(this.krx);
        }
        this.sceneType = getIntent().getExtras().getInt("regsetinfo_ismobile", 0);
        this.krA = getIntent().getExtras().getBoolean("regsetinfo_isForce", false);
        this.krC = getIntent().getIntExtra("regsetinfo_NextControl", 3);
        this.knu = getIntent().getStringExtra("regsession_id");
        this.kph = getIntent().getStringExtra("reg_3d_app_ticket");
        this.kop = getIntent().getIntExtra("reg_3d_app_type", 0);
        this.kon = getIntent().getIntExtra("key_reg_style", 1);
        initView();
        if (this.sceneType == 1) {
            StringBuilder sb = new StringBuilder();
            g.aAf();
            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_900_phone,");
            g.aAf();
            com.tencent.mm.plugin.b.a.j(true, append.append(com.tencent.mm.kernel.a.FN("R200_900_phone")).append(",1").toString());
            com.tencent.mm.plugin.b.a.bxk("R200_900_phone");
        } else if (this.sceneType == 2) {
            StringBuilder sb2 = new StringBuilder();
            g.aAf();
            StringBuilder append2 = sb2.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R4_QQ,");
            g.aAf();
            com.tencent.mm.plugin.b.a.j(true, append2.append(com.tencent.mm.kernel.a.FN("R4_QQ")).append(",1").toString());
            com.tencent.mm.plugin.b.a.bxk("R4_QQ");
        } else if (this.sceneType == 3) {
            StringBuilder sb3 = new StringBuilder();
            g.aAf();
            StringBuilder append3 = sb3.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_900_email,");
            g.aAf();
            com.tencent.mm.plugin.b.a.j(true, append3.append(com.tencent.mm.kernel.a.FN("R200_900_email")).append(",1").toString());
            com.tencent.mm.plugin.b.a.bxk("R200_900_email");
        }
        this.krO = false;
        this.kmf = new b();
        AppMethodBeat.o(128702);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(128703);
        super.onResume();
        this.kqA.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.account.ui.RegSetInfoUI.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(128679);
                RegSetInfoUI.this.krB.requestFocus();
                RegSetInfoUI.this.kqA.clearFocus();
                AppMethodBeat.o(128679);
            }
        }, 500);
        AppMethodBeat.o(128703);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(128704);
        super.onDestroy();
        if (this.sceneType == 1) {
            StringBuilder sb = new StringBuilder();
            g.aAf();
            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_900_phone,");
            g.aAf();
            com.tencent.mm.plugin.b.a.j(false, append.append(com.tencent.mm.kernel.a.FN("R200_900_phone")).append(",2").toString());
        } else if (this.sceneType == 2) {
            StringBuilder sb2 = new StringBuilder();
            g.aAf();
            StringBuilder append2 = sb2.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R4_QQ,");
            g.aAf();
            com.tencent.mm.plugin.b.a.j(false, append2.append(com.tencent.mm.kernel.a.FN("R4_QQ")).append(",2").toString());
        } else if (this.sceneType == 3) {
            StringBuilder sb3 = new StringBuilder();
            g.aAf();
            StringBuilder append3 = sb3.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_900_email,");
            g.aAf();
            com.tencent.mm.plugin.b.a.j(false, append3.append(com.tencent.mm.kernel.a.FN("R200_900_email")).append(",2").toString());
        }
        if (this.kmf != null) {
            this.kmf.close();
        }
        AppMethodBeat.o(128704);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(128705);
        this.krN = findViewById(R.id.geg);
        this.krI = findViewById(R.id.hlg);
        this.krB = (ImageView) findViewById(R.id.hlf);
        this.kqA = (EditText) findViewById(R.id.gz1);
        this.krJ = (TextView) findViewById(R.id.hli);
        this.krr = (EditText) findViewById(R.id.gz8);
        this.kry = (TextView) findViewById(R.id.lp);
        this.krz = findViewById(R.id.gzq);
        this.krE = (ImageView) findViewById(R.id.jlj);
        this.krF = (ProgressBar) findViewById(R.id.gl8);
        this.krH = (ImageView) findViewById(R.id.hlh);
        this.krs = (Button) findViewById(R.id.fz0);
        this.krE.setVisibility(8);
        this.krF.setVisibility(8);
        this.krH.setVisibility(8);
        this.kpI = false;
        this.krL = false;
        this.krI.setVisibility(bpM() ? 0 : 8);
        View view = this.krz;
        if (bpN()) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        view.setVisibility(i2);
        TextView textView = this.kry;
        if (!bpN()) {
            i3 = 8;
        }
        textView.setVisibility(i3);
        if (bpM() && bpN()) {
            this.krJ.setText(getString(R.string.g13));
        } else if (bpM() && !bpN()) {
            this.krJ.setText(getString(R.string.g11));
        } else if (bpM() || !bpN()) {
            this.krJ.setText(getString(R.string.g10));
        } else {
            this.krJ.setText(getString(R.string.g12));
        }
        g.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread() {
            /* class com.tencent.mm.plugin.account.ui.RegSetInfoUI.AnonymousClass23 */
            String krY;
            Bitmap mBitmap;

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public final boolean onPostExecute() {
                AppMethodBeat.i(128689);
                if (!Util.isNullOrNil(this.krY) && Util.isNullOrNil(new StringBuilder().append((Object) RegSetInfoUI.this.kqA.getText()).toString().trim())) {
                    RegSetInfoUI.this.kqA.setText(this.krY);
                }
                if (!e.apn()) {
                    Log.e("MiroMsg.RegSetInfoUI", "SDcard is not available");
                    AppMethodBeat.o(128689);
                    return false;
                }
                if (this.mBitmap != null && !this.mBitmap.isRecycled() && !RegSetInfoUI.this.kpI) {
                    RegSetInfoUI.this.krB.setImageBitmap(this.mBitmap);
                    RegSetInfoUI.this.kpI = true;
                    RegSetInfoUI.this.krH.setVisibility(0);
                }
                AppMethodBeat.o(128689);
                return true;
            }

            @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
            public final boolean doInBackground() {
                AppMethodBeat.i(128690);
                AppMethodBeat.o(128690);
                return true;
            }

            public final String toString() {
                AppMethodBeat.i(128691);
                String str = super.toString() + "|initView";
                AppMethodBeat.o(128691);
                return str;
            }
        });
        this.kqA.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.account.ui.RegSetInfoUI.AnonymousClass28 */

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(128694);
                String trim = RegSetInfoUI.this.kqA.getText().toString().trim();
                if (trim == null || trim.length() <= 16) {
                    if (!RegSetInfoUI.this.krQ.stopped()) {
                        RegSetInfoUI.this.krQ.stopTimer();
                    }
                    RegSetInfoUI.n(RegSetInfoUI.this);
                    if (!RegSetInfoUI.this.krO) {
                        RegSetInfoUI.this.krr.setText(trim);
                    }
                    AppMethodBeat.o(128694);
                    return;
                }
                RegSetInfoUI.this.kqA.setText(trim.substring(0, 16));
                AppMethodBeat.o(128694);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.krs.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegSetInfoUI.AnonymousClass29 */

            public final void onClick(View view) {
                AppMethodBeat.i(128695);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegSetInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                RegSetInfoUI.p(RegSetInfoUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128695);
            }
        });
        this.krr.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tencent.mm.plugin.account.ui.RegSetInfoUI.AnonymousClass30 */

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(128696);
                if (z) {
                    RegSetInfoUI.this.krO = true;
                    RegSetInfoUI.this.krQ.startTimer(200);
                }
                AppMethodBeat.o(128696);
            }
        });
        this.krr.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.account.ui.RegSetInfoUI.AnonymousClass31 */

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(128698);
                if (!RegSetInfoUI.this.krQ.stopped()) {
                    RegSetInfoUI.this.krQ.stopTimer();
                }
                String trim = RegSetInfoUI.this.krr.getText().toString().trim();
                if (Util.isNullOrNil(trim)) {
                    RegSetInfoUI.this.kry.setText(RegSetInfoUI.this.getString(R.string.g15));
                    RegSetInfoUI.s(RegSetInfoUI.this);
                    if (RegSetInfoUI.this.krM != null) {
                        RegSetInfoUI.this.krM.dismiss();
                        RegSetInfoUI.this.krM = null;
                    }
                    RegSetInfoUI.this.krr.postDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.account.ui.RegSetInfoUI.AnonymousClass31.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(128697);
                            RegSetInfoUI.this.krr.clearFocus();
                            RegSetInfoUI.this.krr.requestFocus();
                            AppMethodBeat.o(128697);
                        }
                    }, 50);
                }
                if (!Util.isNullOrNil(trim) && (RegSetInfoUI.c(RegSetInfoUI.this) || !trim.equals(RegSetInfoUI.this.krG))) {
                    RegSetInfoUI.s(RegSetInfoUI.this);
                    RegSetInfoUI.this.krQ.startTimer(500);
                }
                RegSetInfoUI.this.krG = trim;
                AppMethodBeat.o(128698);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegSetInfoUI.AnonymousClass32 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(128699);
                RegSetInfoUI.w(RegSetInfoUI.this);
                AppMethodBeat.o(128699);
                return true;
            }
        });
        this.kqA.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.account.ui.RegSetInfoUI.AnonymousClass33 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(128700);
                if (i2 == 6 || i2 == 5) {
                    RegSetInfoUI.p(RegSetInfoUI.this);
                    AppMethodBeat.o(128700);
                    return true;
                }
                AppMethodBeat.o(128700);
                return false;
            }
        });
        this.kqA.setOnKeyListener(new View.OnKeyListener() {
            /* class com.tencent.mm.plugin.account.ui.RegSetInfoUI.AnonymousClass2 */

            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(128669);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                bVar.pH(i2);
                bVar.bm(keyEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegSetInfoUI$10", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
                if (66 == i2 && keyEvent.getAction() == 0) {
                    RegSetInfoUI.p(RegSetInfoUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$10", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(128669);
                    return true;
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$10", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(128669);
                return false;
            }
        });
        this.krr.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.account.ui.RegSetInfoUI.AnonymousClass3 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(128670);
                if (i2 == 6 || i2 == 5) {
                    RegSetInfoUI.p(RegSetInfoUI.this);
                    AppMethodBeat.o(128670);
                    return true;
                }
                AppMethodBeat.o(128670);
                return false;
            }
        });
        this.krr.setOnKeyListener(new View.OnKeyListener() {
            /* class com.tencent.mm.plugin.account.ui.RegSetInfoUI.AnonymousClass4 */

            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(128671);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                bVar.pH(i2);
                bVar.bm(keyEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegSetInfoUI$12", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
                if (66 == i2 && keyEvent.getAction() == 0) {
                    RegSetInfoUI.p(RegSetInfoUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$12", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                    AppMethodBeat.o(128671);
                    return true;
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$12", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(128671);
                return false;
            }
        });
        this.krB.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegSetInfoUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(128672);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegSetInfoUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                RegSetInfoUI.x(RegSetInfoUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128672);
            }
        });
        o oVar = new o(com.tencent.mm.loader.j.b.aKR());
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        bpL();
        AppMethodBeat.o(128705);
    }

    private void bpJ() {
        final v vVar;
        int i2;
        AppMethodBeat.i(128706);
        int bpT = bpT();
        g.azz().a(126, this);
        if (bpN()) {
            if (this.krD == null || this.krD.size() == 0) {
                i2 = 0;
            } else if (this.krD.contains(this.krP)) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            vVar = new v("", this.krw, this.nickName, this.krv, this.kru, this.krt, "", "", this.gwF, bpT, this.krP, "", "", this.krA, this.kpI);
            ((x.a) vVar.iMO.getReqObj()).KAi.MyA = i2;
        } else {
            vVar = new v("", this.krw, this.nickName, this.krv, this.kru, this.krt, "", "", this.gwF, bpT, "", "", "", this.krA, this.kpI);
        }
        vVar.PB(this.knu);
        vVar.PC(this.kph);
        vVar.tL(this.koh);
        g.azz().a(vVar, 0);
        getString(R.string.zb);
        this.gtM = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.g0m), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.ui.RegSetInfoUI.AnonymousClass7 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(128673);
                g.azz().a(vVar);
                g.azz().b(126, RegSetInfoUI.this);
                AppMethodBeat.o(128673);
            }
        });
        AppMethodBeat.o(128706);
    }

    private void q(boolean z, boolean z2) {
        boolean z3 = false;
        AppMethodBeat.i(128707);
        if (Util.isNullOrNil(this.krr.getText().toString().trim())) {
            z = false;
        }
        this.krE.setImageResource(z2 ? R.drawable.bnw : R.drawable.bnt);
        this.krE.setVisibility(z ? 0 : 8);
        if (z && z2) {
            z3 = true;
        }
        this.krL = z3;
        AppMethodBeat.o(128707);
    }

    private boolean bpK() {
        AppMethodBeat.i(128708);
        if (this.krE.getVisibility() == 8 || this.krL) {
            AppMethodBeat.o(128708);
            return true;
        }
        AppMethodBeat.o(128708);
        return false;
    }

    private void bpL() {
        AppMethodBeat.i(128709);
        this.krs.setEnabled(!Util.isNullOrNil(this.kqA.getText().toString().trim()));
        AppMethodBeat.o(128709);
    }

    private boolean bpM() {
        return (this.krC & 1) > 0;
    }

    private boolean bpN() {
        return (this.krC & 2) > 0;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(128710);
        Log.i("MiroMsg.RegSetInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (intent == null || i2 != 300) {
            Bitmap b2 = a.jRu.b(this, i2, i3, intent);
            if (b2 != null) {
                this.krB.setImageBitmap(b2);
                this.kpI = true;
                this.krH.setVisibility(0);
            }
            AppMethodBeat.o(128710);
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra("result_data");
        if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("birthdayComfirmOK")) {
            bpJ();
        }
        AppMethodBeat.o(128710);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bmg;
    }

    private boolean bpO() {
        return this.sceneType == 1;
    }

    private boolean bpP() {
        return this.sceneType == 2;
    }

    private boolean bpQ() {
        return this.sceneType == 0;
    }

    private boolean bpR() {
        return this.sceneType == 4;
    }

    private boolean bpS() {
        return this.sceneType == 3;
    }

    private int bpT() {
        AppMethodBeat.i(128711);
        if (bpO()) {
            AppMethodBeat.o(128711);
            return 4;
        } else if (bpP()) {
            AppMethodBeat.o(128711);
            return 2;
        } else if (bpS()) {
            AppMethodBeat.o(128711);
            return 6;
        } else if (bpR()) {
            AppMethodBeat.o(128711);
            return 1;
        } else {
            AppMethodBeat.o(128711);
            return 2;
        }
    }

    private String bpU() {
        AppMethodBeat.i(128712);
        if (bpO() || bpR()) {
            String str = this.krt;
            AppMethodBeat.o(128712);
            return str;
        } else if (bpS()) {
            String str2 = this.kru;
            AppMethodBeat.o(128712);
            return str2;
        } else {
            String str3 = this.krx;
            AppMethodBeat.o(128712);
            return str3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x01e8  */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSceneEnd(int r22, int r23, java.lang.String r24, final com.tencent.mm.ak.q r25) {
        /*
        // Method dump skipped, instructions count: 1465
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.account.ui.RegSetInfoUI.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }

    private boolean n(int i2, int i3, String str) {
        String ayX;
        AppMethodBeat.i(128714);
        if (this.kmf.a(this, new ae(i2, i3, str))) {
            AppMethodBeat.o(128714);
            return true;
        } else if (a.jRu.a(getContext(), i2, i3, str)) {
            AppMethodBeat.o(128714);
            return true;
        } else {
            switch (i3) {
                case -2023:
                case -100:
                    com.tencent.mm.kernel.a.hold();
                    AppCompatActivity context = getContext();
                    g.aAf();
                    if (TextUtils.isEmpty(com.tencent.mm.kernel.a.ayX())) {
                        ayX = com.tencent.mm.cb.a.aI(getContext(), R.string.ev5);
                    } else {
                        g.aAf();
                        ayX = com.tencent.mm.kernel.a.ayX();
                    }
                    com.tencent.mm.ui.base.h.a(context, ayX, getContext().getString(R.string.zb), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.ui.RegSetInfoUI.AnonymousClass19 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    }, new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.account.ui.RegSetInfoUI.AnonymousClass20 */

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    AppMethodBeat.o(128714);
                    return true;
                case -75:
                    com.tencent.mm.ui.base.h.n(this, R.string.h0, R.string.fxq);
                    AppMethodBeat.o(128714);
                    return true;
                case APPluginConstants.ERROR_IO_SocketException_PortUnreachableException:
                    com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
                    if (Dk != null) {
                        Dk.a(this, null, null);
                    } else {
                        com.tencent.mm.ui.base.h.c(this, getString(R.string.g14), "", true);
                    }
                    AppMethodBeat.o(128714);
                    return true;
                case -10:
                case -7:
                    com.tencent.mm.ui.base.h.n(this, R.string.fxp, R.string.fxq);
                    AppMethodBeat.o(128714);
                    return true;
                default:
                    AppMethodBeat.o(128714);
                    return false;
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(128715);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            bnm();
            AppMethodBeat.o(128715);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(128715);
        return onKeyDown;
    }

    private void bnm() {
        AppMethodBeat.i(128716);
        hideVKB();
        if (bpO()) {
            com.tencent.mm.ui.base.h.a(this, getString(R.string.g0y), "", new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.ui.RegSetInfoUI.AnonymousClass21 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    Intent intent;
                    AppMethodBeat.i(128688);
                    if (RegSetInfoUI.this.kon == 2) {
                        Intent intent2 = new Intent(RegSetInfoUI.this, MobileInputUI.class);
                        intent2.putExtra("mobile_input_purpose", 2);
                        intent = intent2;
                    } else {
                        intent = new Intent(RegSetInfoUI.this, RegByMobileRegAIOUI.class);
                    }
                    intent.addFlags(67108864);
                    RegSetInfoUI regSetInfoUI = RegSetInfoUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(regSetInfoUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$28", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    regSetInfoUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(regSetInfoUI, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$28", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    RegSetInfoUI.this.finish();
                    AppMethodBeat.o(128688);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.ui.RegSetInfoUI.AnonymousClass22 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            AppMethodBeat.o(128716);
            return;
        }
        if (!bpP()) {
            if (bpQ()) {
                com.tencent.mm.ui.base.h.a(this, getString(R.string.g0x), "", new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.ui.RegSetInfoUI.AnonymousClass24 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(128692);
                        com.tencent.mm.plugin.b.a.bxl("R400_100_signup");
                        Intent intent = new Intent(RegSetInfoUI.this, LoginUI.class);
                        intent.addFlags(67108864);
                        RegSetInfoUI regSetInfoUI = RegSetInfoUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(regSetInfoUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$30", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        regSetInfoUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(regSetInfoUI, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$30", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        RegSetInfoUI.this.finish();
                        AppMethodBeat.o(128692);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.ui.RegSetInfoUI.AnonymousClass25 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(128716);
                return;
            } else if (bpS()) {
                com.tencent.mm.ui.base.h.a(this, getString(R.string.g0x), "", new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.ui.RegSetInfoUI.AnonymousClass26 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(128693);
                        com.tencent.mm.plugin.b.a.bxl("R500_100");
                        Intent intent = new Intent(RegSetInfoUI.this, RegByEmailUI.class);
                        intent.addFlags(67108864);
                        RegSetInfoUI regSetInfoUI = RegSetInfoUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(regSetInfoUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI$32", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        regSetInfoUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(regSetInfoUI, "com/tencent/mm/plugin/account/ui/RegSetInfoUI$32", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        RegSetInfoUI.this.finish();
                        AppMethodBeat.o(128693);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.ui.RegSetInfoUI.AnonymousClass27 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(128716);
                return;
            } else {
                com.tencent.mm.plugin.b.a.bxl("R200_100");
                Intent intent = new Intent(this, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 2);
                intent.addFlags(67108864);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "goback", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "goback", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                finish();
            }
        }
        AppMethodBeat.o(128716);
    }

    static /* synthetic */ void p(RegSetInfoUI regSetInfoUI) {
        boolean z;
        AppMethodBeat.i(128722);
        regSetInfoUI.nickName = regSetInfoUI.kqA.getText().toString().trim();
        regSetInfoUI.krP = regSetInfoUI.krr.getText().toString().trim();
        if (Util.isNullOrNil(regSetInfoUI.nickName)) {
            com.tencent.mm.ui.base.h.n(regSetInfoUI, R.string.hvb, R.string.fzn);
            AppMethodBeat.o(128722);
        } else if (regSetInfoUI.krF.getVisibility() == 0) {
            regSetInfoUI.getString(R.string.zb);
            regSetInfoUI.gtM = com.tencent.mm.ui.base.h.a((Context) regSetInfoUI, regSetInfoUI.getString(R.string.g0m), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.account.ui.RegSetInfoUI.AnonymousClass6 */

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            AppMethodBeat.o(128722);
        } else if (!regSetInfoUI.bpK() || !regSetInfoUI.bpN() || Util.isNullOrNil(regSetInfoUI.krP)) {
            regSetInfoUI.hideVKB();
            String extractCountryCode = PhoneFormater.extractCountryCode(regSetInfoUI.krt);
            Log.i("MiroMsg.RegSetInfoUI", "countryCode %s", extractCountryCode);
            if (Util.isNullOrNil(extractCountryCode) || !com.tencent.mm.aw.b.Pj(extractCountryCode)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                if (!Util.isNullOrNil(regSetInfoUI.krt, regSetInfoUI.knu)) {
                    com.tencent.mm.plugin.account.a.b.a.b(regSetInfoUI, regSetInfoUI.getString(R.string.du_, new Object[]{regSetInfoUI.krt, regSetInfoUI.knu, LocaleUtil.getApplicationLanguage()}), 300, false);
                    AppMethodBeat.o(128722);
                    return;
                }
                Intent intent = new Intent(regSetInfoUI, MobileInputUI.class);
                intent.putExtra("mobile_input_purpose", 2);
                intent.addFlags(67108864);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(regSetInfoUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "doNext", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                regSetInfoUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(regSetInfoUI, "com/tencent/mm/plugin/account/ui/RegSetInfoUI", "doNext", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                regSetInfoUI.finish();
                AppMethodBeat.o(128722);
                return;
            }
            regSetInfoUI.bpJ();
            AppMethodBeat.o(128722);
        } else {
            String charSequence = regSetInfoUI.kry.getText().toString();
            if (Util.isNullOrNil(charSequence) || charSequence.equals(regSetInfoUI.getString(R.string.g15))) {
                if (Util.isNullOrNil(regSetInfoUI.krK)) {
                    charSequence = regSetInfoUI.getString(R.string.g18);
                } else {
                    charSequence = regSetInfoUI.krK;
                }
            }
            com.tencent.mm.ui.base.h.c(regSetInfoUI, charSequence, "", true);
            AppMethodBeat.o(128722);
        }
    }

    static /* synthetic */ boolean x(RegSetInfoUI regSetInfoUI) {
        AppMethodBeat.i(128725);
        boolean s = a.jRu.s(regSetInfoUI);
        AppMethodBeat.o(128725);
        return s;
    }
}
