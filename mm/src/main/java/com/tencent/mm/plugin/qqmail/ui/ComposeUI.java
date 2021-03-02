package com.tencent.mm.plugin.qqmail.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.d.ab;
import com.tencent.mm.plugin.qqmail.d.aj;
import com.tencent.mm.plugin.qqmail.d.j;
import com.tencent.mm.plugin.qqmail.d.k;
import com.tencent.mm.plugin.qqmail.d.l;
import com.tencent.mm.plugin.qqmail.d.m;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.plugin.qqmail.e.d;
import com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl;
import com.tencent.mm.plugin.qqmail.ui.b;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.o;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.x;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"SetJavaScriptEnabled"})
public class ComposeUI extends MMActivity implements i {
    private static List<l> BtS;
    private ab BqV = ((k) g.ah(k.class)).getShareModeMailAppService();
    private int Brp = 1;
    private Map<String, String> Bsl = new HashMap();
    private ScrollView BtT;
    protected MailAddrsViewControl BtU;
    private ImageView BtV;
    private LinearLayout BtW;
    private LinearLayout BtX;
    private MailAddrsViewControl BtY;
    private ImageView BtZ;
    private String BuA = "weixin://get_mail_content/";
    private String BuB = "weixin://img_onclick/";
    private boolean BuC = false;
    private boolean BuD = false;
    private MTimerHandler BuE = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(122892);
            ComposeUI.this.enableOptionMenu(ComposeUI.a(ComposeUI.this, true));
            AppMethodBeat.o(122892);
            return true;
        }
    }, true);
    private MTimerHandler BuF = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass12 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(122909);
            if (ComposeUI.this.Buo && ComposeUI.a(ComposeUI.this, false) && ComposeUI.this.mode == 20) {
                ComposeUI.b(ComposeUI.this);
                if (ComposeUI.this.Bun != null) {
                    ComposeUI.this.Bun.dismiss();
                }
                ComposeUI.this.Bun = u.a(ComposeUI.this, ComposeUI.this.getString(R.string.fnu), 2000);
            }
            AppMethodBeat.o(122909);
            return true;
        }
    }, true);
    m.a BuG = new m.a() {
        /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass13 */

        @Override // com.tencent.mm.plugin.qqmail.d.m.a
        public final void onComplete() {
            AppMethodBeat.i(122920);
            Log.i("MicroMsg.Mail.ComposeUI", "sync addr complete");
            MailAddrsViewControl.b bVar = new MailAddrsViewControl.b(ComposeUI.this, ComposeUI.this.Buj.aKD(null));
            ComposeUI.this.BtU.setAddrsAdapter(bVar);
            ComposeUI.this.BtY.setAddrsAdapter(bVar);
            ComposeUI.this.Bub.setAddrsAdapter(bVar);
            AppMethodBeat.o(122920);
        }
    };
    private View.OnClickListener BuH = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass6 */

        public final void onClick(View view) {
            AppMethodBeat.i(198680);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ComposeUI.this.BtW.setVisibility(8);
            ComposeUI.this.BtX.setVisibility(0);
            ComposeUI.this.Bua.setVisibility(0);
            ComposeUI.this.BtW.post(new Runnable() {
                /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass6.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(198679);
                    ComposeUI.this.BtX.requestFocus();
                    ComposeUI.this.BtY.eGW();
                    ComposeUI.this.Bub.eGW();
                    AppMethodBeat.o(198679);
                }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(198680);
        }
    };
    private View.OnClickListener BuI = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass7 */

        public final void onClick(View view) {
            AppMethodBeat.i(122899);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            h.a(ComposeUI.this, (String) null, new String[]{ComposeUI.this.getString(R.string.fnt), ComposeUI.this.getString(R.string.fnq), ComposeUI.this.getString(R.string.fnr)}, (String) null, new h.d() {
                /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass7.AnonymousClass1 */

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // com.tencent.mm.ui.base.h.d
                public final void oj(int i2) {
                    AppMethodBeat.i(198681);
                    switch (i2) {
                        case 0:
                            boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(ComposeUI.this.getContext(), "android.permission.CAMERA", 16, "", "");
                            Log.i("MicroMsg.Mail.ComposeUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(a2), Util.getStack(), ComposeUI.this.getContext());
                            if (!a2) {
                                AppMethodBeat.o(198681);
                                return;
                            }
                            ComposeUI.B(ComposeUI.this);
                            AppMethodBeat.o(198681);
                            return;
                        case 1:
                            s.c(ComposeUI.this, 4, null);
                            AppMethodBeat.o(198681);
                            return;
                        case 2:
                            ComposeUI.this.startActivityForResult(new Intent(ComposeUI.this, FileExplorerUI.class), 5);
                            break;
                    }
                    AppMethodBeat.o(198681);
                }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(122899);
        }
    };
    private MenuItem.OnMenuItemClickListener BuJ = new MenuItem.OnMenuItemClickListener() {
        /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass9 */

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(198684);
            if ((!ComposeUI.a(ComposeUI.this, false) || ComposeUI.this.mode != 20) && ComposeUI.this.mode != 21) {
                ComposeUI.this.setResult(0);
                ComposeUI.this.finish();
            } else {
                h.c(ComposeUI.this.getContext(), ComposeUI.this.getString(R.string.fo0), "", ComposeUI.this.getString(R.string.fo2), ComposeUI.this.getString(R.string.sz), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass9.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(198683);
                        ComposeUI.this.setResult(0);
                        ComposeUI.this.finish();
                        AppMethodBeat.o(198683);
                    }
                }, null);
            }
            AppMethodBeat.o(198684);
            return true;
        }
    };
    private View.OnClickListener BuK = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass10 */

        public final void onClick(View view) {
            AppMethodBeat.i(198688);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ComposeUI.this.hideVKB();
            ComposeUI.this.Bud.getText();
            ComposeUI.C(ComposeUI.this);
            if (!ComposeUI.this.eGF()) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(198688);
                return;
            }
            for (Map.Entry entry : ComposeUI.this.Bsl.entrySet()) {
                b bVar2 = ComposeUI.this.Buk;
                String str = (String) entry.getValue();
                Log.i("MicroMsg.Mail.FileUploadHelper", "uploadContentImage path=%s", str);
                if (!(str == null || str.length() == 0 || bVar2.Bvz.containsKey(str))) {
                    o oVar = new o(str);
                    if (oVar.exists() && oVar.isFile()) {
                        aj ajVar = new aj();
                        ajVar.path = str;
                        ajVar.name = oVar.getName();
                        ajVar.size = oVar.length();
                        ajVar.state = 0;
                        bVar2.Bvz.put(str, ajVar);
                        if (ajVar.state == 0) {
                            ajVar.ulj = bVar2.aKJ(ajVar.path);
                        }
                    }
                }
            }
            ComposeUI composeUI = ComposeUI.this;
            ComposeUI composeUI2 = ComposeUI.this;
            ComposeUI.this.getString(R.string.zb);
            composeUI.kkW = h.a((Context) composeUI2, ComposeUI.this.getString(R.string.fnk), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass10.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(198685);
                    ComposeUI.this.Buk.eGO();
                    ComposeUI.this.Buk.BvC = null;
                    AppMethodBeat.o(198685);
                }
            });
            if (!ComposeUI.this.Buk.eGP()) {
                ComposeUI.this.kkW.setMessage(ComposeUI.this.getString(R.string.fnh));
                ComposeUI.this.Buk.BvC = new b.AbstractC1615b() {
                    /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass10.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.qqmail.ui.b.AbstractC1615b
                    public final void eGG() {
                        AppMethodBeat.i(198686);
                        ComposeUI.this.kkW.setMessage(ComposeUI.this.getString(R.string.fnh));
                        AppMethodBeat.o(198686);
                    }

                    @Override // com.tencent.mm.plugin.qqmail.ui.b.AbstractC1615b
                    public final void onComplete() {
                        AppMethodBeat.i(198687);
                        ComposeUI.this.dPI = ComposeUI.q(ComposeUI.this);
                        AppMethodBeat.o(198687);
                    }
                };
            } else {
                ComposeUI.this.dPI = ComposeUI.q(ComposeUI.this);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(198688);
        }
    };
    private LinearLayout Bua;
    private MailAddrsViewControl Bub;
    private ImageView Buc;
    private EditText Bud;
    private LinearLayout Bue;
    private TextView Buf;
    private ImageView Bug;
    private LinearLayout Buh;
    private MMWebView Bui;
    private m Buj;
    private b Buk;
    public c Bul = new c(this);
    private String Bum;
    private p Bun;
    public boolean Buo = true;
    public boolean Bup = true;
    public boolean Buq = false;
    private String Bur = ("(function() { \nvar imgList = document.getElementsByTagName('img');var result = ''; \nfor (var i = 0; i < imgList.length; i++) {var img = imgList[i];var info = img.id + '@@' + img.src;result += info + '&&'}return result;" + "})()".trim());
    private String Bus = "document.getElementById('history').innerHTML";
    private String But = "<div id=\"htmlContent\" contenteditable=\"true\" >";
    private String Buu = "</div>";
    private String Buv = null;
    private String Buw = null;
    private List<Bundle> Bux = null;
    private List<String> Buy = null;
    private String Buz = "weixin://get_img_info/";
    private String dPI;
    private q kkW;
    private int mode = 20;
    private EditText nBD;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ComposeUI() {
        AppMethodBeat.i(122938);
        AppMethodBeat.o(122938);
    }

    static /* synthetic */ void B(ComposeUI composeUI) {
        AppMethodBeat.i(198695);
        composeUI.dRW();
        AppMethodBeat.o(198695);
    }

    static /* synthetic */ String C(ComposeUI composeUI) {
        AppMethodBeat.i(198696);
        String eGE = composeUI.eGE();
        AppMethodBeat.o(198696);
        return eGE;
    }

    static /* synthetic */ void h(ComposeUI composeUI) {
        AppMethodBeat.i(122957);
        composeUI.eGC();
        AppMethodBeat.o(122957);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bk1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(122939);
        super.onCreate(bundle);
        this.Buv = this.But + "%s" + this.Buu;
        this.BuC = false;
        this.BuD = false;
        this.Brp = getIntent().getIntExtra("composeType", 1);
        this.Bum = getIntent().getStringExtra("mailid");
        if (this.Bum == null) {
            this.Bum = "";
        }
        this.mode = getIntent().getIntExtra("mail_mode", 20);
        Log.d("MicroMsg.Mail.ComposeUI", "onCreate, mode = %d", Integer.valueOf(this.mode));
        initView();
        this.Buj = ((k) g.ah(k.class)).getNormalMailAppService().BrU;
        this.Buj.a(this.BuG);
        this.Buj.eGn();
        this.BuF.startTimer(180000);
        g.azz().a(11166, this);
        AppMethodBeat.o(122939);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(122940);
        super.onResume();
        this.BuE.startTimer(1500);
        AppMethodBeat.o(122940);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(122941);
        super.onPause();
        hideVKB();
        this.BuE.stopTimer();
        if (this.Bun != null) {
            this.Bun.dismiss();
        }
        AppMethodBeat.o(122941);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(122942);
        super.onDestroy();
        if (BtS != null) {
            BtS = null;
        }
        this.Buk.eGO();
        g.aAg().hqi.b(11665, this.Buk);
        this.Buj.b(this.BuG);
        this.Bul.release();
        g.azz().b(11166, this);
        this.BuF.stopTimer();
        AppMethodBeat.o(122942);
    }

    private void eGC() {
        AppMethodBeat.i(122943);
        this.BtU.clearFocus();
        this.BtY.clearFocus();
        this.Bub.clearFocus();
        AppMethodBeat.o(122943);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(122944);
        this.BtT = (ScrollView) findViewById(R.id.gnm);
        this.BtU = (MailAddrsViewControl) findViewById(R.id.gni);
        this.BtV = (ImageView) findViewById(R.id.gnd);
        this.BtW = (LinearLayout) findViewById(R.id.gnl);
        this.BtX = (LinearLayout) findViewById(R.id.gnh);
        this.BtY = (MailAddrsViewControl) findViewById(R.id.gng);
        this.BtZ = (ImageView) findViewById(R.id.gnc);
        this.Bua = (LinearLayout) findViewById(R.id.gnf);
        this.Bub = (MailAddrsViewControl) findViewById(R.id.gne);
        this.Buc = (ImageView) findViewById(R.id.gnb);
        this.Bud = (EditText) findViewById(R.id.gnq);
        this.Bue = (LinearLayout) findViewById(R.id.gna);
        this.nBD = (EditText) findViewById(R.id.gnn);
        this.Bui = MMWebView.a.r(this, R.id.gno);
        this.Buf = (TextView) findViewById(R.id.gnk);
        this.Bug = (ImageView) findViewById(R.id.gnj);
        this.Buh = (LinearLayout) findViewById(R.id.gde);
        this.BtU.setEditable(true);
        this.BtY.setEditable(true);
        this.Bub.setEditable(true);
        String stringExtra = getIntent().getStringExtra("mail_content");
        this.Bux = getIntent().getParcelableArrayListExtra("mail_attach");
        this.Buy = getIntent().getStringArrayListExtra("mail_attach_file");
        com.tencent.mm.plugin.qqmail.d.i fe = ((k) g.ah(k.class)).getNormalMailAppService().BrV.fe(this.Bum, this.Brp);
        this.Buk = new b(this, this.Buf, this.Bug, this.Buh, (byte) 0);
        if (!Util.isNullOrNil(stringExtra)) {
            if (this.mode == 21) {
                eGD();
                this.BtU.requestFocus();
                this.Buw = String.format(this.Buv, stringExtra);
                this.Bui.loadDataWithBaseURL("", this.Buw, "text/html", ProtocolPackage.ServerEncoding, "");
                this.Bui.setVisibility(0);
            } else if (this.mode == 20) {
                this.nBD.setVisibility(0);
                this.Bui.setVisibility(8);
                if (stringExtra.indexOf("<div>") != -1) {
                    Log.i("MicroMsg.Mail.ComposeUI", "set content in html format");
                    this.nBD.setText(Html.fromHtml(stringExtra));
                } else {
                    this.nBD.setText(stringExtra);
                }
            }
        } else if (fe == null || this.mode != 21) {
            Log.i("MicroMsg.Mail.ComposeUI", "no extra or draf mail content");
            if (this.mode == 21) {
                eGD();
                this.BtU.requestFocus();
                this.Buw = String.format(this.Buv, "");
                this.Bui.loadDataWithBaseURL("", this.Buw, "text/html", ProtocolPackage.ServerEncoding, "");
                this.nBD.setVisibility(8);
                this.Bui.setVisibility(0);
            } else if (this.mode == 20) {
                this.Bui.setVisibility(8);
                this.nBD.setVisibility(0);
            }
        } else {
            Log.i("MicroMsg.Mail.ComposeUI", "read mail from draftMail");
            this.BtU.j(fe.Brq, false);
            this.BtY.j(fe.Brr, false);
            this.Bub.j(fe.Brs, false);
            this.Bud.setText(fe.Bru);
            String str = fe.content;
            this.mode = 20;
            if (str.indexOf("<div>") != -1) {
                Log.i("MicroMsg.Mail.ComposeUI", "set content in html format");
                this.nBD.setText(Html.fromHtml(str));
            } else {
                this.nBD.setText(str);
            }
            this.Buk.fX(fe.Brt);
            this.Buk.eGQ();
            this.Bui.setVisibility(8);
            this.nBD.setVisibility(0);
        }
        if (this.Brp != 1) {
            String[] stringArrayExtra = getIntent().getStringArrayExtra("toList");
            String[] stringArrayExtra2 = getIntent().getStringArrayExtra("ccList");
            String[] stringArrayExtra3 = getIntent().getStringArrayExtra("bccList");
            String stringExtra2 = getIntent().getStringExtra("subject");
            this.BtU.j(M(stringArrayExtra), false);
            this.BtY.j(M(stringArrayExtra2), false);
            this.Bub.j(M(stringArrayExtra3), false);
            if (!Util.isNullOrNil(stringExtra2)) {
                this.Bud.setText((this.Brp == 2 ? "Re:" : "Fwd:") + stringExtra2);
            }
            if (this.Bux != null) {
                ArrayList arrayList = new ArrayList();
                for (Bundle bundle : this.Bux) {
                    aj ajVar = new aj();
                    ajVar.name = bundle.getString("attach_name");
                    StringBuilder sb = new StringBuilder();
                    ((k) g.ah(k.class)).getNormalMailAppService();
                    ajVar.path = sb.append(v.getDownloadPath()).append(ajVar.name).toString();
                    ajVar.state = 2;
                    ajVar.size = (long) bundle.getInt("attach_size");
                    ajVar.svrId = bundle.getString("attach_fileId");
                    arrayList.add(ajVar);
                }
                if (!arrayList.isEmpty()) {
                    this.Buk.fX(arrayList);
                }
            }
        } else {
            String stringExtra3 = getIntent().getStringExtra("subject");
            if (!Util.isNullOrNil(stringExtra3)) {
                this.Bud.setText(stringExtra3);
            }
            if (this.Buy != null) {
                for (String str2 : this.Buy) {
                    aKG(str2);
                }
            }
        }
        if (this.BtY.getMailAddrs().size() > 0 || this.Bub.getMailAddrs().size() > 0) {
            this.BtW.setVisibility(8);
            this.BtX.setVisibility(0);
            this.Bua.setVisibility(0);
        }
        if (this.Brp == 2 && this.mode != 21 && this.mode == 20) {
            this.nBD.requestFocus();
            this.nBD.setSelection(0);
            this.BtT.postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass14 */

                public final void run() {
                    AppMethodBeat.i(122921);
                    ComposeUI.this.BtT.fullScroll(130);
                    AppMethodBeat.o(122921);
                }
            }, 1000);
        }
        this.BtU.setOnActionListener(new c(this.BtV, 0));
        this.BtY.setOnActionListener(new c(this.BtZ, 1));
        this.Bub.setOnActionListener(new c(this.Buc, 2));
        AnonymousClass15 r0 = new MailAddrsViewControl.a() {
            /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass15 */

            @Override // com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.a
            public final void b(final MailAddrsViewControl mailAddrsViewControl) {
                AppMethodBeat.i(122926);
                h.a(ComposeUI.this.getContext(), ComposeUI.this.getString(R.string.foa), "", new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass15.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(122923);
                        mailAddrsViewControl.Bwb.setText("");
                        ComposeUI.this.BuF.postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass15.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(122922);
                                ComposeUI.h(ComposeUI.this);
                                mailAddrsViewControl.requestFocus();
                                ComposeUI.this.showVKB();
                                AppMethodBeat.o(122922);
                            }
                        }, 150);
                        AppMethodBeat.o(122923);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass15.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(122925);
                        ComposeUI.this.BuF.postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass15.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(122924);
                                ComposeUI.h(ComposeUI.this);
                                mailAddrsViewControl.requestFocus();
                                ComposeUI.this.showVKB();
                                AppMethodBeat.o(122924);
                            }
                        }, 150);
                        AppMethodBeat.o(122925);
                    }
                });
                AppMethodBeat.o(122926);
            }

            @Override // com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.a
            public final void eGH() {
                AppMethodBeat.i(122927);
                u.a(ComposeUI.this, ComposeUI.this.getString(R.string.foa), 1500);
                AppMethodBeat.o(122927);
            }
        };
        this.BtU.setInvalidMailAddrListener(r0);
        this.BtY.setInvalidMailAddrListener(r0);
        this.Bub.setInvalidMailAddrListener(r0);
        this.BtV.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass16 */

            public final void onClick(View view) {
                AppMethodBeat.i(122928);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(ComposeUI.this, MailAddrListUI.class);
                intent.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.this.BtU.getMailAddrStringArray());
                intent.putExtra("MMActivity.OverrideExitAnimation", R.anim.f6do);
                intent.putExtra("MMActivity.OverrideEnterAnimation", R.anim.br);
                ComposeUI.this.startActivityForResult(intent, 0);
                BackwardSupportUtil.AnimationHelper.overridePendingTransition(ComposeUI.this, R.anim.dq, R.anim.bs);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(122928);
            }
        });
        this.BtZ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass17 */

            public final void onClick(View view) {
                AppMethodBeat.i(122929);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(ComposeUI.this, MailAddrListUI.class);
                intent.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.this.BtY.getMailAddrStringArray());
                intent.putExtra("MMActivity.OverrideExitAnimation", R.anim.f6do);
                intent.putExtra("MMActivity.OverrideEnterAnimation", R.anim.br);
                ComposeUI.this.startActivityForResult(intent, 1);
                BackwardSupportUtil.AnimationHelper.overridePendingTransition(ComposeUI.this, R.anim.dq, R.anim.bs);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(122929);
            }
        });
        this.Buc.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass18 */

            public final void onClick(View view) {
                AppMethodBeat.i(122930);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(ComposeUI.this, MailAddrListUI.class);
                intent.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", ComposeUI.this.Bub.getMailAddrStringArray());
                intent.putExtra("MMActivity.OverrideExitAnimation", R.anim.f6do);
                intent.putExtra("MMActivity.OverrideEnterAnimation", R.anim.br);
                ComposeUI.this.startActivityForResult(intent, 2);
                BackwardSupportUtil.AnimationHelper.overridePendingTransition(ComposeUI.this, R.anim.dq, R.anim.bs);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(122930);
            }
        });
        this.BtW.setOnClickListener(this.BuH);
        final ImageView imageView = (ImageView) findViewById(R.id.gnp);
        if (this.Bup && this.Bud.getText().length() > 0) {
            imageView.setVisibility(0);
        }
        this.Bud.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass19 */

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(122931);
                if (z) {
                    ComposeUI.this.Bud.setSelection(ComposeUI.this.Bud.getText().length());
                }
                AppMethodBeat.o(122931);
            }
        });
        this.Bud.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass2 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                int i5 = 4;
                AppMethodBeat.i(122893);
                if (ComposeUI.this.Bup) {
                    ImageView imageView = imageView;
                    if (ComposeUI.this.Bud.getText().length() > 0) {
                        i5 = 0;
                    }
                    imageView.setVisibility(i5);
                    AppMethodBeat.o(122893);
                    return;
                }
                imageView.setVisibility(4);
                AppMethodBeat.o(122893);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(122894);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ComposeUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ComposeUI.this.Bud.getText().clear();
                ComposeUI.this.Bud.requestFocus();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(122894);
            }
        });
        this.Bue.setOnClickListener(this.BuI);
        setMMTitle(R.string.fo5);
        setBackBtn(this.BuJ);
        addTextOptionMenu(0, getString(R.string.yq), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(122895);
                ComposeUI.this.BuK.onClick(null);
                AppMethodBeat.o(122895);
                return false;
            }
        });
        enableOptionMenu(false);
        eGC();
        AppMethodBeat.o(122944);
    }

    private static List<l> M(String[] strArr) {
        AppMethodBeat.i(198690);
        ArrayList arrayList = new ArrayList();
        if (strArr != null) {
            for (String str : strArr) {
                l aKE = m.aKE(str);
                if (aKE != null) {
                    arrayList.add(aKE);
                }
            }
        }
        AppMethodBeat.o(198690);
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public class b extends ac {
        private boolean BuV;

        private b() {
            this.BuV = false;
        }

        /* synthetic */ b(ComposeUI composeUI, byte b2) {
            this();
        }

        @Override // com.tencent.xweb.ac
        public final boolean a(WebView webView, String str) {
            String[] split;
            AppMethodBeat.i(122933);
            Log.d("MicroMsg.Mail.ComposeUI", "shouldOverrideUrlLoading, url = %s", str);
            if (str.startsWith(ComposeUI.this.BuB)) {
                ComposeUI.this.hideVKB();
                try {
                    String[] split2 = URLDecoder.decode(str.substring(ComposeUI.this.BuB.length()), ProtocolPackage.ServerEncoding).split("@@");
                    String[] split3 = split2[0].split(":");
                    String str2 = split3[0];
                    Log.i("MicroMsg.Mail.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", split2[1], str2, split3[1]);
                    ca Hb = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb((long) Integer.valueOf(str2).intValue());
                    Intent intent = new Intent(ComposeUI.this, MailImageDownloadUI.class);
                    intent.putExtra("img_msg_id", Hb.field_msgId);
                    intent.putExtra("img_server_id", Hb.field_msgSvrId);
                    intent.putExtra("img_download_compress_type", 0);
                    intent.putExtra("img_download_username", Hb.field_talker);
                    ComposeUI composeUI = ComposeUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(composeUI, bl.axQ(), "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    composeUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(composeUI, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(122933);
                } catch (Exception e2) {
                    Log.w("MicroMsg.Mail.ComposeUI", "shouldOverrideUrlLoading IMG_ONCLICK, ex = %s", e2.getMessage());
                }
            } else if (str.startsWith(ComposeUI.this.BuA)) {
                try {
                    ComposeUI.this.Buw = URLDecoder.decode(str.substring(ComposeUI.this.BuA.length()), ProtocolPackage.ServerEncoding);
                } catch (Exception e3) {
                    Log.w("MicroMsg.Mail.ComposeUI", "shouldOverrideUrlLoading GET_MAIL_CONTENT, ex = %s", e3.getMessage());
                }
                if (ComposeUI.this.BuD) {
                    if (ComposeUI.this.Buw.indexOf("<img") == -1) {
                        ComposeUI.this.Bsl.clear();
                        ComposeUI.q(ComposeUI.this);
                        AppMethodBeat.o(122933);
                    } else {
                        z.a(ComposeUI.this.Bui, ComposeUI.this.Buz, ComposeUI.this.Bur);
                    }
                }
                AppMethodBeat.o(122933);
            } else {
                if (str.startsWith(ComposeUI.this.Buz)) {
                    ComposeUI.this.Bsl.clear();
                    try {
                        for (String str3 : URLDecoder.decode(str.substring(ComposeUI.this.Buz.length()), ProtocolPackage.ServerEncoding).split("&&")) {
                            String[] split4 = str3.split("@@");
                            if (split4.length >= 2) {
                                String str4 = split4[0];
                                String str5 = split4[1];
                                if (str5.startsWith("file://")) {
                                    str5 = str5.replaceFirst("file://", "");
                                }
                                Log.i("MicroMsg.Mail.ComposeUI", "put msgImgInfoMap, fileName: %s, path: %s", str4, str5);
                                ComposeUI.this.Bsl.put(str4, str5);
                            }
                        }
                        if (ComposeUI.this.BuD) {
                            ComposeUI.q(ComposeUI.this);
                        }
                        AppMethodBeat.o(122933);
                    } catch (Exception e4) {
                        Log.w("MicroMsg.Mail.ComposeUI", "shouldOverrideUrlLoading GET_IMG_INFO, ex = %s", e4.getMessage());
                        AppMethodBeat.o(122933);
                    }
                }
                AppMethodBeat.o(122933);
            }
            return true;
        }

        @Override // com.tencent.xweb.ac
        public final void b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(122934);
            super.b(webView, str, bitmap);
            if (!ComposeUI.this.BuC) {
                z.c(ComposeUI.this.Bui);
                ComposeUI.this.BuC = true;
            }
            AppMethodBeat.o(122934);
        }

        @Override // com.tencent.xweb.ac
        public final void b(WebView webView, String str) {
            AppMethodBeat.i(122935);
            Log.d("MicroMsg.Mail.ComposeUI", "onPageFinished, url = %s, firstTimeLoaded = %b", str, Boolean.valueOf(this.BuV));
            if (!this.BuV) {
                this.BuV = true;
                z.a(ComposeUI.this.Bui, ComposeUI.this.BuA, ComposeUI.this.Bus);
                if (ComposeUI.this.getIntent().getBooleanExtra("mail_edit_mode", false)) {
                    z.a(ComposeUI.this.Bui, ComposeUI.this.Buz, ComposeUI.this.Bur);
                }
            }
            super.b(webView, str);
            AppMethodBeat.o(122935);
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends x {
        private a() {
        }

        /* synthetic */ a(ComposeUI composeUI, byte b2) {
            this();
        }

        @Override // com.tencent.xweb.x
        @Deprecated
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            AppMethodBeat.i(122932);
            Log.i("MicroMsg.Mail.ComposeUI", "console, consoleMessage: %s", consoleMessage);
            String bfJ = z.bfJ(consoleMessage != null ? consoleMessage.message() : null);
            if (bfJ.startsWith(ComposeUI.this.BuB)) {
                ComposeUI.this.hideVKB();
                try {
                    String[] split = URLDecoder.decode(bfJ.substring(ComposeUI.this.BuB.length()), ProtocolPackage.ServerEncoding).split("@@");
                    String[] split2 = split[0].split(":");
                    String str = split2[0];
                    Log.i("MicroMsg.Mail.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", split[1], str, split2[1]);
                    ca Hb = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb((long) Integer.valueOf(str).intValue());
                    Intent intent = new Intent(ComposeUI.this, MailImageDownloadUI.class);
                    intent.putExtra("img_msg_id", Hb.field_msgId);
                    intent.putExtra("img_server_id", Hb.field_msgSvrId);
                    intent.putExtra("img_download_compress_type", 0);
                    intent.putExtra("img_download_username", Hb.field_talker);
                    ComposeUI composeUI = ComposeUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(composeUI, bl.axQ(), "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentChromeClient", "onConsoleMessage", "(Landroid/webkit/ConsoleMessage;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    composeUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(composeUI, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$ContentChromeClient", "onConsoleMessage", "(Landroid/webkit/ConsoleMessage;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(122932);
                    return true;
                } catch (Exception e2) {
                    Log.w("MicroMsg.Mail.ComposeUI", "consoleMessage IMG_ONCLICK, ex = %s", e2.getMessage());
                }
            } else if (bfJ.startsWith(ComposeUI.this.BuA)) {
                try {
                    ComposeUI.this.Buw = URLDecoder.decode(bfJ.substring(ComposeUI.this.BuA.length()), ProtocolPackage.ServerEncoding);
                } catch (Exception e3) {
                    Log.w("MicroMsg.Mail.ComposeUI", "consoleMessage GET_MAIL_CONTENT, ex = %s", e3.getMessage());
                }
                if (ComposeUI.this.BuD) {
                    if (ComposeUI.this.Buw.indexOf("<img") == -1) {
                        ComposeUI.this.Bsl.clear();
                        ComposeUI.q(ComposeUI.this);
                        AppMethodBeat.o(122932);
                        return true;
                    }
                    z.a(ComposeUI.this.Bui, ComposeUI.this.Buz, ComposeUI.this.Bur);
                }
                AppMethodBeat.o(122932);
                return true;
            } else {
                if (bfJ.startsWith(ComposeUI.this.Buz)) {
                    ComposeUI.this.Bsl.clear();
                    try {
                        String[] split3 = URLDecoder.decode(bfJ.substring(ComposeUI.this.Buz.length()), ProtocolPackage.ServerEncoding).split("&&");
                        for (String str2 : split3) {
                            String[] split4 = str2.split("@@");
                            if (split4.length >= 2) {
                                String str3 = split4[0];
                                String str4 = split4[1];
                                if (str4.startsWith("file://")) {
                                    str4 = str4.replaceFirst("file://", "");
                                }
                                Log.i("MicroMsg.Mail.ComposeUI", "put msgImgInfoMap, fileName: %s, path: %s", str3, str4);
                                ComposeUI.this.Bsl.put(str3, str4);
                            }
                        }
                        if (ComposeUI.this.BuD) {
                            ComposeUI.q(ComposeUI.this);
                        }
                        AppMethodBeat.o(122932);
                        return true;
                    } catch (Exception e4) {
                        Log.w("MicroMsg.Mail.ComposeUI", "consoleMessage GET_IMG_INFO, ex = %s", e4.getMessage());
                        AppMethodBeat.o(122932);
                        return true;
                    }
                }
                boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
                AppMethodBeat.o(122932);
                return onConsoleMessage;
            }
        }
    }

    private void eGD() {
        AppMethodBeat.i(122945);
        if (this.Bui != null) {
            this.Bui.clearFocus();
            this.Bui.getSettings().setJavaScriptEnabled(true);
            this.Bui.setWebViewClient(new b(this, (byte) 0));
            this.Bui.setWebChromeClient(new a(this, (byte) 0));
            this.Bui.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass5 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(198678);
                    switch (motionEvent.getAction()) {
                        case 0:
                        case 1:
                            if (!view.hasFocus()) {
                                view.requestFocus();
                                break;
                            }
                            break;
                    }
                    AppMethodBeat.o(198678);
                    return false;
                }
            });
        }
        AppMethodBeat.o(122945);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(122946);
        if (i2 == 4) {
            this.BuJ.onMenuItemClick(null);
            AppMethodBeat.o(122946);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(122946);
        return onKeyDown;
    }

    /* access modifiers changed from: package-private */
    public class c extends MailAddrsViewControl.c {
        private ImageView BuW;
        private int tag;

        public c(ImageView imageView, int i2) {
            this.BuW = imageView;
            this.tag = i2;
        }

        @Override // com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.c
        public final void sS(boolean z) {
            ImageView imageView;
            int i2 = 0;
            AppMethodBeat.i(122937);
            ComposeUI.x(ComposeUI.this);
            if (ComposeUI.this.Buq) {
                imageView = this.BuW;
            } else {
                imageView = this.BuW;
                if (!z) {
                    i2 = 4;
                }
            }
            imageView.setVisibility(i2);
            if ((this.tag == 1 || this.tag == 2) && !z) {
                ComposeUI.this.BtW.postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.c.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(122936);
                        if (!ComposeUI.this.BtY.Bwb.isFocused() && !ComposeUI.this.Bub.Bwb.isFocused() && ComposeUI.this.BtY.getMailAddrs().size() == 0 && ComposeUI.this.Bub.getMailAddrs().size() == 0 && ComposeUI.this.BtY.eGS() && ComposeUI.this.Bub.eGS()) {
                            ComposeUI.this.BtW.setVisibility(0);
                            ComposeUI.this.BtX.setVisibility(8);
                            ComposeUI.this.Bua.setVisibility(8);
                        }
                        AppMethodBeat.o(122936);
                    }
                }, 10);
            }
            AppMethodBeat.o(122937);
        }
    }

    private void dRW() {
        AppMethodBeat.i(122947);
        if (!s.d(this, com.tencent.mm.loader.j.b.aKV(), "microMsg." + System.currentTimeMillis() + ".jpg", 3)) {
            Toast.makeText(this, getString(R.string.gix), 1).show();
        }
        AppMethodBeat.o(122947);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(122948);
        if (iArr == null || iArr.length <= 0) {
            Log.i("MicroMsg.Mail.ComposeUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i2), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(122948);
            return;
        }
        Log.i("MicroMsg.Mail.ComposeUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 16:
                if (iArr[0] != 0) {
                    h.a((Context) this, getString(R.string.fl0), getString(R.string.flp), getString(R.string.e_k), getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass8 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(198682);
                            ComposeUI composeUI = ComposeUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            com.tencent.mm.hellhoundlib.a.a.a(composeUI, bl.axQ(), "com/tencent/mm/plugin/qqmail/ui/ComposeUI$16", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            composeUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(composeUI, "com/tencent/mm/plugin/qqmail/ui/ComposeUI$16", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(198682);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    break;
                } else {
                    dRW();
                    AppMethodBeat.o(122948);
                    return;
                }
        }
        AppMethodBeat.o(122948);
    }

    private String eGE() {
        AppMethodBeat.i(122949);
        StringBuilder sb = new StringBuilder(this.nBD.getText().toString());
        z.a(this.Bui, this.BuA, this.Bus);
        if (!Util.isNullOrNil(this.Buw)) {
            int indexOf = this.Buw.indexOf(this.But);
            int lastIndexOf = this.Buw.lastIndexOf(this.Buu);
            if (indexOf == -1 || lastIndexOf == -1) {
                sb.append("\n").append(this.Buw);
            } else {
                sb.append("\n").append(this.Buw.substring(indexOf + this.But.length(), lastIndexOf + this.Buu.length()));
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(122949);
        return sb2;
    }

    private static ArrayList<Bundle> fV(List<l> list) {
        AppMethodBeat.i(198691);
        ArrayList<Bundle> arrayList = new ArrayList<>();
        for (l lVar : list) {
            Bundle bundle = new Bundle();
            bundle.putString("item_addr", lVar.yFq);
            bundle.putString(FirebaseAnalytics.b.ITEM_NAME, lVar.name);
            arrayList.add(bundle);
        }
        AppMethodBeat.o(198691);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public final boolean eGF() {
        AppMethodBeat.i(122951);
        if (!this.BtU.eGV()) {
            Toast.makeText(this, (int) R.string.fo7, 1).show();
            AppMethodBeat.o(122951);
            return false;
        } else if (!this.BtY.eGV()) {
            Toast.makeText(this, (int) R.string.fny, 1).show();
            AppMethodBeat.o(122951);
            return false;
        } else if (!this.Bub.eGV()) {
            Toast.makeText(this, (int) R.string.fnw, 1).show();
            AppMethodBeat.o(122951);
            return false;
        } else if (this.BtU.getMailAddrs().size() + this.BtY.getMailAddrs().size() + this.Bub.getMailAddrs().size() > 20) {
            Toast.makeText(this, (int) R.string.fod, 1).show();
            AppMethodBeat.o(122951);
            return false;
        } else {
            AppMethodBeat.o(122951);
            return true;
        }
    }

    static void fW(List<l> list) {
        BtS = list;
    }

    private static void a(MailAddrsViewControl mailAddrsViewControl) {
        AppMethodBeat.i(122952);
        if (BtS == null) {
            AppMethodBeat.o(122952);
            return;
        }
        mailAddrsViewControl.setMailAdds(BtS);
        AppMethodBeat.o(122952);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(198692);
        Log.i("MicroMsg.Mail.ComposeUI", "errType %d, errCode %d, errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (!((d) qVar).dPI.equals(this.dPI)) {
            Log.w("MicroMsg.Mail.ComposeUI", "not current request, ignore");
            AppMethodBeat.o(198692);
            return;
        }
        if (this.kkW != null) {
            this.kkW.dismiss();
        }
        if (i2 == 0 && i3 == 0) {
            Toast.makeText(this, (int) R.string.fnl, 1).show();
            o oVar = new o(((k) g.ah(k.class)).getNormalMailAppService().BrV.Bro.Brx + com.tencent.mm.plugin.qqmail.d.h.ff(this.Bum, this.Brp));
            if (oVar.exists()) {
                oVar.delete();
            }
            this.Buj.fU(this.BtU.getMailAddrs());
            this.Buj.fU(this.BtY.getMailAddrs());
            this.Buj.fU(this.Bub.getMailAddrs());
            setResult(-1);
            finish();
            AppMethodBeat.o(198692);
            return;
        }
        if (Util.isNullOrNil(str)) {
            str = getString(R.string.fnj);
        }
        Toast.makeText(this, str, 1).show();
        AppMethodBeat.o(198692);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String i4;
        AppMethodBeat.i(122953);
        if (i3 != -1) {
            AppMethodBeat.o(122953);
            return;
        }
        switch (i2) {
            case 0:
                a(this.BtU);
                showVKB();
                AppMethodBeat.o(122953);
                return;
            case 1:
                a(this.BtY);
                showVKB();
                AppMethodBeat.o(122953);
                return;
            case 2:
                a(this.Bub);
                showVKB();
                AppMethodBeat.o(122953);
                return;
            case 3:
                String h2 = s.h(this, intent, com.tencent.mm.plugin.image.d.aSY());
                if (h2 != null) {
                    aKG(h2);
                    eGC();
                    AppMethodBeat.o(122953);
                    return;
                }
                break;
            case 4:
                if (!(intent == null || (i4 = com.tencent.mm.ui.tools.a.i(this, intent, com.tencent.mm.plugin.image.d.aSY())) == null || i4.length() <= 0)) {
                    aKG(i4);
                    eGC();
                    AppMethodBeat.o(122953);
                    return;
                }
            case 5:
                if (intent != null) {
                    aKG(intent.getStringExtra("choosed_file_path"));
                    eGC();
                    break;
                }
                break;
        }
        AppMethodBeat.o(122953);
    }

    private void aKG(final String str) {
        AppMethodBeat.i(122954);
        final o oVar = new o(str);
        if (!oVar.exists()) {
            AppMethodBeat.o(122954);
        } else if (this.Buk.Tf(str)) {
            h.n(getContext(), R.string.fom, R.string.zb);
            AppMethodBeat.o(122954);
        } else {
            final int length = (int) oVar.length();
            if (length > 20971520) {
                h.a(this, (int) R.string.fon, (int) R.string.zb, (DialogInterface.OnClickListener) null);
                AppMethodBeat.o(122954);
                return;
            }
            h.a(this, getString(R.string.fop, new Object[]{Util.getSizeKB((long) length)}), getString(R.string.zb), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.qqmail.ui.ComposeUI.AnonymousClass11 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(198689);
                    if (ComposeUI.this.Buk.getTotalSize() + length > 52428800) {
                        h.a(ComposeUI.this, (int) R.string.foo, (int) R.string.zb, (DialogInterface.OnClickListener) null);
                        AppMethodBeat.o(198689);
                        return;
                    }
                    if (ComposeUI.this.Bud.getText().toString().trim().length() == 0) {
                        String trim = oVar.getName().trim();
                        int lastIndexOf = trim.lastIndexOf(".");
                        EditText editText = ComposeUI.this.Bud;
                        if (lastIndexOf <= 0) {
                            lastIndexOf = trim.length();
                        }
                        editText.setText(trim.substring(0, lastIndexOf));
                    }
                    Log.i("MicroMsg.Mail.ComposeUI", "in upload file mode = %d", Integer.valueOf(ComposeUI.this.mode));
                    b bVar = ComposeUI.this.Buk;
                    String str = str;
                    if (str == null || str.length() == 0 || bVar.Bvz.containsKey(str)) {
                        AppMethodBeat.o(198689);
                        return;
                    }
                    o oVar = new o(str);
                    if (!oVar.exists() || !oVar.isFile()) {
                        AppMethodBeat.o(198689);
                        return;
                    }
                    aj ajVar = new aj();
                    ajVar.path = str;
                    ajVar.name = oVar.getName();
                    ajVar.size = oVar.length();
                    ajVar.state = 0;
                    bVar.Bvz.put(str, ajVar);
                    bVar.a(ajVar);
                    AppMethodBeat.o(198689);
                }
            }, (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(122954);
        }
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public void setRequestedOrientation(int i2) {
    }

    static /* synthetic */ boolean a(ComposeUI composeUI, boolean z) {
        AppMethodBeat.i(122955);
        if (!z || composeUI.BtU.getMailAddrs().size() != 0 || composeUI.BtY.getMailAddrs().size() != 0 || composeUI.Bub.getMailAddrs().size() != 0 || composeUI.BtU.eGT() || composeUI.BtY.eGT() || composeUI.Bub.eGT()) {
            if (composeUI.mode == 20) {
                if (composeUI.Bud.getText().toString().trim().length() == 0 && composeUI.Buk.eGN().size() == 0 && composeUI.nBD.getText().length() == 0) {
                    AppMethodBeat.o(122955);
                    return false;
                }
            } else if (composeUI.mode == 21 && composeUI.Bud.getText().toString().trim().length() == 0 && composeUI.Buk.eGN().size() == 0) {
                AppMethodBeat.o(122955);
                return false;
            }
            AppMethodBeat.o(122955);
            return true;
        }
        AppMethodBeat.o(122955);
        return false;
    }

    static /* synthetic */ void b(ComposeUI composeUI) {
        AppMethodBeat.i(122956);
        com.tencent.mm.plugin.qqmail.d.i iVar = new com.tencent.mm.plugin.qqmail.d.i();
        iVar.Brp = composeUI.Brp;
        iVar.BqZ = composeUI.Bum;
        iVar.Brq = composeUI.BtU.getMailAddrs();
        iVar.Brr = composeUI.BtY.getMailAddrs();
        iVar.Brs = composeUI.Bub.getMailAddrs();
        iVar.Bru = composeUI.Bud.getText().toString();
        iVar.Brt = composeUI.Buk.eGN();
        if (composeUI.mode != 21 && composeUI.mode == 20) {
            iVar.content = composeUI.eGE();
            iVar.Brv = composeUI.mode;
            Log.i("MicroMsg.Mail.ComposeUI", "save draft mail as normal mode");
        }
        com.tencent.mm.plugin.qqmail.d.h hVar = ((k) g.ah(k.class)).getNormalMailAppService().BrV;
        try {
            hVar.Bro.eGm();
            j.writeToFile(hVar.Bro.Brx + com.tencent.mm.plugin.qqmail.d.h.ff(iVar.BqZ, iVar.Brp), iVar.toByteArray());
            AppMethodBeat.o(122956);
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.DraftBoxMgr", e2, "", new Object[0]);
            AppMethodBeat.o(122956);
        }
    }

    static /* synthetic */ String q(ComposeUI composeUI) {
        int i2;
        int i3 = 40;
        AppMethodBeat.i(198693);
        composeUI.dPI = "SendMail_" + System.currentTimeMillis();
        Bundle bundle = new Bundle();
        bundle.putString("mail_id", composeUI.Bum);
        switch (composeUI.Brp) {
            case 2:
                i2 = 2;
                break;
            case 3:
                i2 = 3;
                break;
            default:
                i2 = 1;
                break;
        }
        bundle.putInt("mail_send_type", i2);
        String obj = composeUI.Bud.getText().toString();
        if (obj.trim().length() <= 0) {
            String eGE = composeUI.eGE();
            if (composeUI.mode == 20) {
                if (eGE.length() > 0) {
                    obj = eGE.substring(0, eGE.length() > 40 ? 40 : eGE.length());
                }
            } else if (composeUI.mode == 21 && !Util.isNullOrNil(eGE)) {
                if (eGE.length() <= 40) {
                    i3 = eGE.length();
                }
                obj = eGE.substring(0, i3);
            }
            obj = composeUI.getString(R.string.fo1);
        }
        bundle.putString("mail_subject", obj);
        bundle.putString("mail_content", composeUI.eGE());
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        Bundle bundle2 = new Bundle();
        String eGr = v.eGr();
        if (Util.isNullOrNil(eGr)) {
            Log.w("MicroMsg.Mail.ComposeUI", "bindMail is null");
            Toast.makeText(composeUI, (int) R.string.fnj, 1).show();
            if (composeUI.kkW != null) {
                composeUI.kkW.dismiss();
            }
            String str = composeUI.dPI;
            AppMethodBeat.o(198693);
            return str;
        }
        bundle2.putString("item_addr", eGr);
        arrayList.add(bundle2);
        bundle.putParcelableArrayList("mail_from_list", arrayList);
        bundle.putParcelableArrayList("mail_to_list", fV(composeUI.BtU.getMailAddrs()));
        bundle.putParcelableArrayList("mail_cc_list", fV(composeUI.BtY.getMailAddrs()));
        bundle.putParcelableArrayList("mail_bcc_list", fV(composeUI.Bub.getMailAddrs()));
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
        ArrayList<? extends Parcelable> arrayList3 = new ArrayList<>();
        for (aj ajVar : composeUI.Buk.eGN()) {
            Bundle bundle3 = new Bundle();
            bundle3.putString("attach_fileId", ajVar.svrId);
            bundle3.putString("attach_name", ajVar.name);
            bundle3.putString("attach_path", ajVar.path);
            bundle3.putInt("attach_size", (int) ajVar.size);
            if (!composeUI.Bsl.containsKey(ajVar.name)) {
                arrayList2.add(bundle3);
            } else {
                arrayList3.add(bundle3);
            }
        }
        bundle.putParcelableArrayList("mail_normal_attach", arrayList2);
        bundle.putParcelableArrayList("mail_image_attach", arrayList3);
        g.azz().a(new d(composeUI.dPI, v.at(bundle)), 0);
        String str2 = composeUI.dPI;
        AppMethodBeat.o(198693);
        return str2;
    }

    static /* synthetic */ void x(ComposeUI composeUI) {
        AppMethodBeat.i(198694);
        composeUI.BtV.setVisibility(4);
        composeUI.BtZ.setVisibility(4);
        composeUI.Buc.setVisibility(4);
        AppMethodBeat.o(198694);
    }
}
