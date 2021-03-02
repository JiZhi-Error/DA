package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCLong;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.qqmail.c.f;
import com.tencent.mm.plugin.qqmail.c.i;
import com.tencent.mm.plugin.qqmail.c.k;
import com.tencent.mm.plugin.qqmail.d.o;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.plugin.webview.ui.tools.widget.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.e;
import com.tencent.mm.plugin.webview.ui.tools.widget.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class ReadMailUI extends MMActivity implements View.OnCreateContextMenuListener {
    private static String Bxs = "var mail_css = document.createElement(\"style\");";
    private static String Bxt = "";
    private static String Bxu = "";
    private static float Bxv;
    private static int Bxw;
    private o BwT;
    private ImageView BwU;
    private TextView BwV;
    private MailAddrsViewControl BwW;
    private MailAddrsViewControl BwX;
    private MailAddrsViewControl BwY;
    private TextView BwZ;
    private View Bxa;
    private LinearLayout Bxb;
    private TextView Bxc;
    private TextView Bxd;
    private LinearLayout Bxe;
    private MailAttachListLinearLayout Bxf;
    private View Bxg;
    private TextView Bxh;
    private TextView Bxi;
    private View Bxj;
    private boolean Bxk;
    private String Bxl;
    private String Bxm;
    private String Bxn;
    private int Bxo = 0;
    private String Bxp;
    private int Bxq = 0;
    private int Bxr = 0;
    private String Bxx;
    private int Bxy;
    private MTimerHandler Bxz = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass8 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(198749);
            ReadMailUI.C(ReadMailUI.this);
            AppMethodBeat.o(198749);
            return true;
        }
    }, true);
    private ProgressBar kdb;
    private long lAs = -1;
    private long msgId = -1;
    private SharedPreferences sp;
    private TextView timeTv;
    private MMWebView webView;

    public class a {
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ReadMailUI() {
        AppMethodBeat.i(123176);
        AppMethodBeat.o(123176);
    }

    static /* synthetic */ void A(ReadMailUI readMailUI) {
        AppMethodBeat.i(198775);
        readMailUI.eGZ();
        AppMethodBeat.o(198775);
    }

    static /* synthetic */ void a(ReadMailUI readMailUI) {
        AppMethodBeat.i(198765);
        readMailUI.eGY();
        AppMethodBeat.o(198765);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void eGY() {
        AppMethodBeat.i(123177);
        switch (this.Bxr) {
            case 0:
                this.Bxi.setText(R.string.fud);
                AppMethodBeat.o(123177);
                return;
            case 1:
                this.Bxi.setText(R.string.fub);
                AppMethodBeat.o(123177);
                return;
            case 2:
                this.Bxi.setText(R.string.fuc);
                AppMethodBeat.o(123177);
                return;
            case 3:
                String str = "";
                if (this.Bxy > 99) {
                    str = "99+";
                } else if (this.Bxy > 0) {
                    str = Integer.toString(this.Bxy);
                }
                if (!Util.isNullOrNil(str)) {
                    this.Bxi.setText(String.format(com.tencent.mm.cb.a.aI(this, R.string.fuf), str));
                    break;
                } else {
                    this.Bxi.setText(R.string.fue);
                    AppMethodBeat.o(123177);
                    return;
                }
        }
        AppMethodBeat.o(123177);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bl3;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(123178);
        super.onCreate(bundle);
        this.msgId = getIntent().getLongExtra("msgid", -1);
        Log.i("MicroMsg.ReadMailUI", "onCreate msgId %d", Long.valueOf(this.msgId));
        initView();
        eGZ();
        h.a(MMApplicationContext.getPackageName(), new IPCLong(this.msgId), f.class, new d<IPCString>() {
            /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(IPCString iPCString) {
                o oVar = null;
                AppMethodBeat.i(198739);
                IPCString iPCString2 = iPCString;
                if (ReadMailUI.this.isFinishing() || ReadMailUI.this.isDestroyed()) {
                    AppMethodBeat.o(198739);
                    return;
                }
                if (iPCString2 != null && !Util.isNullOrNil(iPCString2.value)) {
                    ReadMailUI readMailUI = ReadMailUI.this;
                    String str = iPCString2.value;
                    Map<String, String> parseXml = XmlParser.parseXml(str, "msg", null);
                    if (parseXml == null) {
                        Log.e("MicroMsg.MailMsgHelper", "parse fail, maps is null");
                    } else {
                        Log.i("MicroMsg.MailMsgHelper", "parse mail msg %s", str);
                        o oVar2 = new o();
                        oVar2.BrG = parseXml.get(".msg.pushmail.mailid");
                        oVar2.BrH = parseXml.get(".msg.pushmail.content.date");
                        oVar2.Bru = parseXml.get(".msg.pushmail.content.subject");
                        int i2 = Util.getInt(parseXml.get(".msg.pushmail.content.fromlist.$count"), 0);
                        int i3 = Util.getInt(parseXml.get(".msg.pushmail.content.tolist.$count"), 0);
                        int i4 = Util.getInt(parseXml.get(".msg.pushmail.content.cclist.$count"), 0);
                        for (int i5 = 0; i5 < i2; i5++) {
                            Bundle bundle = new Bundle();
                            String str2 = ".msg.pushmail.content.fromlist.item";
                            if (i5 > 0) {
                                str2 = str2 + i5;
                            }
                            bundle.putString(FirebaseAnalytics.b.ITEM_NAME, parseXml.get(str2 + ".name"));
                            bundle.putString("item_addr", parseXml.get(str2 + ".addr"));
                            oVar2.BrI.add(bundle);
                        }
                        for (int i6 = 0; i6 < i3; i6++) {
                            Bundle bundle2 = new Bundle();
                            String str3 = ".msg.pushmail.content.tolist.item";
                            if (i6 > 0) {
                                str3 = str3 + i6;
                            }
                            bundle2.putString(FirebaseAnalytics.b.ITEM_NAME, parseXml.get(str3 + ".name"));
                            bundle2.putString("item_addr", parseXml.get(str3 + ".addr"));
                            oVar2.BrJ.add(bundle2);
                        }
                        for (int i7 = 0; i7 < i4; i7++) {
                            Bundle bundle3 = new Bundle();
                            String str4 = ".msg.pushmail.content.cclist.item";
                            if (i7 > 0) {
                                str4 = str4 + i7;
                            }
                            bundle3.putString(FirebaseAnalytics.b.ITEM_NAME, parseXml.get(str4 + ".name"));
                            bundle3.putString("item_addr", parseXml.get(str4 + ".addr"));
                            oVar2.BrK.add(bundle3);
                        }
                        oVar = oVar2;
                    }
                    readMailUI.BwT = oVar;
                    if (ReadMailUI.this.BwT != null) {
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(198738);
                                ReadMailUI.this.Bxf.setMailId(ReadMailUI.this.BwT.BrG);
                                ReadMailUI.d(ReadMailUI.this);
                                ReadMailUI.e(ReadMailUI.this);
                                AppMethodBeat.o(198738);
                            }
                        });
                    }
                }
                AppMethodBeat.o(198739);
            }
        });
        AppMethodBeat.o(123178);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(123179);
        super.onPause();
        AppMethodBeat.o(123179);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(123180);
        super.onStop();
        this.webView.stopLoading();
        AppMethodBeat.o(123180);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(123181);
        super.onDestroy();
        this.webView.setVisibility(8);
        this.webView.destroy();
        AppMethodBeat.o(123181);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(123183);
        this.BwW = (MailAddrsViewControl) findViewById(R.id.gnt);
        this.BwY = (MailAddrsViewControl) findViewById(R.id.gnu);
        this.BwX = (MailAddrsViewControl) findViewById(R.id.gns);
        this.BwZ = (TextView) findViewById(R.id.gtd);
        this.Bxa = findViewById(R.id.gtf);
        this.Bxb = (LinearLayout) findViewById(R.id.gtc);
        this.Bxc = (TextView) findViewById(R.id.gti);
        this.timeTv = (TextView) findViewById(R.id.gtj);
        this.Bxd = (TextView) findViewById(R.id.gth);
        this.Bxe = (LinearLayout) findViewById(R.id.gtb);
        this.Bxf = (MailAttachListLinearLayout) findViewById(R.id.gta);
        this.kdb = (ProgressBar) findViewById(R.id.gte);
        this.BwU = (ImageView) findViewById(R.id.gtg);
        this.BwV = (TextView) findViewById(R.id.gtk);
        setMMTitle("");
        this.webView = g.a.Jyt.eK(this);
        if (this.webView.gYU()) {
            this.webView.setBackgroundColor(getResources().getColor(R.color.am));
        }
        ((FrameLayout) findViewById(R.id.gt4)).addView(this.webView);
        this.Bxj = findViewById(R.id.f63);
        this.Bxg = findViewById(R.id.f5x);
        this.Bxi = (TextView) findViewById(R.id.f60);
        this.Bxh = (TextView) findViewById(R.id.f5z);
        this.Bxg.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass13 */

            public final void onClick(View view) {
                AppMethodBeat.i(123156);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ReadMailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                switch (ReadMailUI.this.Bxr) {
                    case 0:
                        ReadMailUI.Vk(2);
                        if (!Util.isNullOrNil(ReadMailUI.this.Bxm) && !Util.isNullOrNil(ReadMailUI.this.Bxn)) {
                            ReadMailUI.m(ReadMailUI.this);
                            break;
                        } else {
                            ReadMailUI.n(ReadMailUI.this);
                            break;
                        }
                    case 1:
                        ReadMailUI.Vk(1);
                        Log.e("MicroMsg.ReadMailUI", "cancel_download_task:fail_apilevel_too_low downloadId = %d", Long.valueOf(ReadMailUI.this.lAs));
                        break;
                    case 2:
                        ReadMailUI.Vk(3);
                        ReadMailUI.q(ReadMailUI.this);
                        break;
                    case 3:
                        ReadMailUI.Vk(4);
                        ReadMailUI.r(ReadMailUI.this);
                        break;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(123156);
            }
        });
        this.BwZ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass14 */

            public final void onClick(View view) {
                AppMethodBeat.i(198756);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ReadMailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (ReadMailUI.this.Bxa.getVisibility() == 8) {
                    ReadMailUI.this.BwZ.setText(R.string.fu5);
                    ReadMailUI.this.Bxa.setVisibility(0);
                    ReadMailUI.this.Bxa.post(new Runnable() {
                        /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass14.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(198755);
                            ReadMailUI.this.BwY.eGW();
                            ReadMailUI.this.BwX.eGW();
                            AppMethodBeat.o(198755);
                        }
                    });
                    ReadMailUI.this.Bxd.setVisibility(0);
                } else {
                    ReadMailUI.this.BwZ.setText(R.string.fu6);
                    ReadMailUI.this.Bxa.setVisibility(8);
                    ReadMailUI.this.Bxd.setVisibility(8);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(198756);
            }
        });
        this.BwU.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass15 */

            public final void onClick(View view) {
                AppMethodBeat.i(198757);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ReadMailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ReadMailUI.this.BwU.setVisibility(8);
                ReadMailUI.e(ReadMailUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(198757);
            }
        });
        this.Bxd.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass16 */

            public final void onClick(View view) {
                AppMethodBeat.i(123162);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/ReadMailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ReadMailUI.x(ReadMailUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(123162);
            }
        });
        addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass17 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(198759);
                if (ReadMailUI.this.BwT == null) {
                    Log.w("MicroMsg.ReadMailUI", "mailObject is null!");
                    AppMethodBeat.o(198759);
                    return true;
                }
                com.tencent.mm.ui.base.h.b(ReadMailUI.this, null, ReadMailUI.this.getResources().getStringArray(R.array.s), ReadMailUI.this.getResources().getString(R.string.fu_), new h.d() {
                    /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass17.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.h.d
                    public final void oj(int i2) {
                        AppMethodBeat.i(198758);
                        if (i2 == 3) {
                            ReadMailUI.y(ReadMailUI.this);
                            AppMethodBeat.o(198758);
                            return;
                        }
                        Intent intent = new Intent();
                        intent.setClass(ReadMailUI.this, ComposeUI.class);
                        intent.putExtra("mailid", ReadMailUI.this.BwT.BrG);
                        intent.putExtra("subject", ReadMailUI.this.BwT.Bru);
                        String[] mailAddrStringArray = ReadMailUI.this.BwW.getMailAddrStringArray();
                        String[] mailAddrStringArray2 = ReadMailUI.this.BwY.getMailAddrStringArray();
                        String[] mailAddrStringArray3 = ReadMailUI.this.BwX.getMailAddrStringArray();
                        switch (i2) {
                            case 0:
                                intent.putExtra("composeType", 2);
                                intent.putExtra("toList", mailAddrStringArray);
                                break;
                            case 1:
                                intent.putExtra("composeType", 2);
                                String[] strArr = new String[(mailAddrStringArray.length + mailAddrStringArray2.length)];
                                int length = mailAddrStringArray.length;
                                int i3 = 0;
                                int i4 = 0;
                                while (i3 < length) {
                                    strArr[i4] = mailAddrStringArray[i3];
                                    i3++;
                                    i4++;
                                }
                                int length2 = mailAddrStringArray2.length;
                                int i5 = 0;
                                while (i5 < length2) {
                                    strArr[i4] = mailAddrStringArray2[i5];
                                    i5++;
                                    i4++;
                                }
                                intent.putExtra("toList", strArr);
                                intent.putExtra("ccList", mailAddrStringArray3);
                                break;
                            case 2:
                                intent.putExtra("mail_content", ReadMailUI.this.BwT.content);
                                intent.putExtra("mail_attach", ReadMailUI.this.BwT.BrL);
                                intent.putExtra("mail_mode", 21);
                                intent.putExtra("composeType", 3);
                                break;
                            default:
                                AppMethodBeat.o(198758);
                                return;
                        }
                        ReadMailUI readMailUI = ReadMailUI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(readMailUI, bl.axQ(), "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$7$1", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        readMailUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(readMailUI, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$7$1", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(198758);
                    }
                });
                AppMethodBeat.o(198759);
                return false;
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass18 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(123165);
                ReadMailUI.this.finish();
                AppMethodBeat.o(123165);
                return true;
            }
        });
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Bxv = ((float) displayMetrics.widthPixels) / displayMetrics.scaledDensity;
        Bxw = displayMetrics.heightPixels;
        this.webView.getSettings().setDefaultTextEncodingName(ProtocolPackage.ServerEncoding);
        this.webView.getSettings().setSupportZoom(false);
        this.webView.getSettings().setBuiltInZoomControls(false);
        this.webView.getSettings().hsK();
        this.webView.getSettings().setLoadsImagesAutomatically(false);
        this.webView.getSettings().setUseWideViewPort(true);
        this.webView.gYW();
        ((com.tencent.mm.plugin.webview.ui.tools.widget.h) this.webView).setEmbeddedTitleBarCompat(this.Bxj);
        ((com.tencent.mm.plugin.webview.ui.tools.widget.h) this.webView).setEmbeddedBottomBar(this.Bxg);
        Intent intent = getContext().getIntent();
        byte[] bArr = new byte[112];
        bArr[25] = 1;
        bArr[16] = 1;
        bArr[57] = 1;
        bArr[63] = 1;
        bArr[61] = 1;
        bArr[70] = 1;
        bArr[68] = 1;
        bArr[82] = 1;
        bArr[111] = 1;
        intent.putExtra("hardcode_jspermission", new JsapiPermissionWrapper(bArr));
        getContext().setIntent(intent);
        this.webView.setWebViewClient(c.a.Jyr.a(this.webView, true, (com.tencent.mm.plugin.webview.ui.tools.widget.d) new e() {
            /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass19 */

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.d
            public final boolean f(int i2, Bundle bundle) {
                return false;
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.e
            public final boolean Lb(String str) {
                AppMethodBeat.i(198762);
                Log.d("MicroMsg.ReadMailUI", "url:%s", str);
                if (str != null && str.startsWith(WebView.SCHEME_MAILTO)) {
                    String replace = str.trim().replace(WebView.SCHEME_MAILTO, "");
                    Intent intent = new Intent(ReadMailUI.this, ComposeUI.class);
                    intent.putExtra("composeType", 4);
                    intent.putExtra("toList", new String[]{replace + " " + replace});
                    ReadMailUI readMailUI = ReadMailUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(readMailUI, bl.axQ(), "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$9", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    readMailUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(readMailUI, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$9", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                } else if (str != null && str.startsWith(WebView.SCHEME_TEL)) {
                    Intent intent2 = new Intent("android.intent.action.DIAL", Uri.parse(str));
                    intent2.addFlags(268435456);
                    ReadMailUI readMailUI2 = ReadMailUI.this;
                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(readMailUI2, bl2.axQ(), "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$9", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    readMailUI2.startActivity((Intent) bl2.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(readMailUI2, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI$9", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                } else if (str == null || str.startsWith("data:")) {
                    AppMethodBeat.o(198762);
                    return false;
                } else if (((com.tencent.mm.plugin.webview.ui.tools.widget.h) ReadMailUI.this.webView).gik()) {
                    ((com.tencent.mm.plugin.webview.ui.tools.widget.h) ReadMailUI.this.webView).gil();
                    AppMethodBeat.o(198762);
                    return true;
                } else if (str.startsWith("http")) {
                    Intent intent3 = new Intent();
                    intent3.putExtra("rawUrl", str);
                    com.tencent.mm.br.c.b(ReadMailUI.this, "webview", ".ui.tools.WebViewUI", intent3);
                } else {
                    AppMethodBeat.o(198762);
                    return false;
                }
                AppMethodBeat.o(198762);
                return true;
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.e
            public final boolean aXk() {
                return false;
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.e
            public final void aXl() {
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.widget.e
            public final void c(MMWebView mMWebView) {
                AppMethodBeat.i(198763);
                mMWebView.evaluateJavascript("javascript:var meta = document.createElement(\"meta\");meta.name=\"viewport\";meta.id=\"viewport\";meta.content=\"initial-scale=1,user-scalable=yes,maximum-scale=3.0\";document.head.appendChild(meta);", null);
                mMWebView.evaluateJavascript("javascript:" + ReadMailUI.Bxs, null);
                mMWebView.evaluateJavascript("javascript:" + ReadMailUI.Bxt, null);
                mMWebView.evaluateJavascript("javascript:" + ReadMailUI.Bxu, null);
                new MMHandler(ReadMailUI.this.getMainLooper()).postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass19.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(198760);
                        ReadMailUI.this.webView.getSettings().setLoadsImagesAutomatically(true);
                        ReadMailUI.this.webView.getSettings().setSupportZoom(true);
                        ReadMailUI.this.webView.getSettings().setBuiltInZoomControls(true);
                        ((com.tencent.mm.plugin.webview.ui.tools.widget.h) ReadMailUI.this.webView).gim();
                        ((com.tencent.mm.plugin.webview.ui.tools.widget.h) ReadMailUI.this.webView).gin();
                        AppMethodBeat.o(198760);
                    }
                }, 200);
                new MMHandler(ReadMailUI.this.getMainLooper()).postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass19.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(198761);
                        Log.d("MicroMsg.ReadMailUI", ReadMailUI.this.webView.getContentHeight() + "," + ReadMailUI.this.webView.getHeight() + "," + ReadMailUI.this.webView.getScale());
                        if (Math.abs(((int) (((float) ReadMailUI.this.webView.getContentHeight()) * ReadMailUI.this.webView.getScale())) - ReadMailUI.this.webView.getHeight()) < 10) {
                            ((com.tencent.mm.plugin.webview.ui.tools.widget.h) ReadMailUI.this.webView).zu(true);
                        }
                        AppMethodBeat.o(198761);
                    }
                }, 400);
                AppMethodBeat.o(198763);
            }
        }));
        if (Bxt.equals("")) {
            try {
                Bxt += Util.convertStreamToString(getAssets().open("mail/lib.js"));
                Bxu += Util.convertStreamToString(getAssets().open("mail/readmail.js"));
                Bxs += "mail_css.innerHTML='" + Util.convertStreamToString(getAssets().open("mail/qmail_webview.css")) + "'; document.head.appendChild(mail_css);";
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.ReadMailUI", e2, "", new Object[0]);
                Log.e("MicroMsg.ReadMailUI", "evaluateJavascript error " + e2.getMessage());
            }
        }
        registerForContextMenu(this.webView);
        new l(this).a(this.webView, this, null);
        AppMethodBeat.o(123183);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(123184);
        if (view instanceof com.tencent.xweb.WebView) {
            WebView.b hitTestResult = ((com.tencent.xweb.WebView) view).getHitTestResult();
            if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                AppMethodBeat.o(123184);
                return;
            }
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AppMethodBeat.o(123184);
    }

    private void eGZ() {
        AppMethodBeat.i(198764);
        com.tencent.mm.ipcinvoker.h.a(MMApplicationContext.getPackageName(), null, com.tencent.mm.plugin.qqmail.c.e.class, new d<Bundle>() {
            /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass4 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(Bundle bundle) {
                AppMethodBeat.i(198743);
                final Bundle bundle2 = bundle;
                com.tencent.f.h.RTc.aV(new Runnable() {
                    /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass4.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(198742);
                        if (bundle2 != null) {
                            ReadMailUI.this.Bxl = bundle2.getString("mail_app_download_url", "");
                            ReadMailUI.this.Bxx = bundle2.getString("mail_app_enter_url", "");
                            ReadMailUI.this.Bxk = bundle2.getBoolean("mail_app_show_recommend", false);
                            if (!ReadMailUI.this.Bxk) {
                                ReadMailUI.this.Bxg.setVisibility(8);
                                Log.e("MicroMsg.ReadMailUI", "promote qq mail error:MailAppRecomend = %s", Boolean.valueOf(ReadMailUI.this.Bxk));
                            }
                        }
                        AppMethodBeat.o(198742);
                    }
                });
                AppMethodBeat.o(198743);
            }
        });
        com.tencent.mm.ipcinvoker.h.a(MMApplicationContext.getPackageName(), null, com.tencent.mm.plugin.qqmail.c.g.class, new d<IPCInteger>() {
            /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass5 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(IPCInteger iPCInteger) {
                AppMethodBeat.i(198744);
                IPCInteger iPCInteger2 = iPCInteger;
                if (ReadMailUI.this.isFinishing() || ReadMailUI.this.isDestroyed()) {
                    AppMethodBeat.o(198744);
                    return;
                }
                ReadMailUI.this.Bxy = iPCInteger2.value;
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass5.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(123158);
                        ReadMailUI.a(ReadMailUI.this);
                        AppMethodBeat.o(123158);
                    }
                });
                AppMethodBeat.o(198744);
            }
        });
        if (q.s(this, "com.tencent.androidqqmail")) {
            this.Bxr = 3;
            eGY();
            AppMethodBeat.o(198764);
            return;
        }
        this.sp = MMApplicationContext.getContext().getSharedPreferences("QQMAIL", com.tencent.mm.compatible.util.g.aps());
        if (this.sp == null) {
            AppMethodBeat.o(198764);
            return;
        }
        this.lAs = this.sp.getLong("qqmail_downloadid", -1);
        com.tencent.mm.ipcinvoker.h.a(MMApplicationContext.getPackageName(), new IPCLong(this.lAs), com.tencent.mm.plugin.qqmail.c.d.class, new d<Bundle>() {
            /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass6 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(Bundle bundle) {
                AppMethodBeat.i(198746);
                final Bundle bundle2 = bundle;
                com.tencent.f.h.RTc.aV(new Runnable() {
                    /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass6.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(198745);
                        if (bundle2 != null) {
                            ReadMailUI.this.Bxo = bundle2.getInt("download_status");
                            ReadMailUI.this.Bxp = bundle2.getString("download_apk_path", "");
                        }
                        if (ReadMailUI.this.Bxo == 3 && s.YS(ReadMailUI.this.Bxp)) {
                            ReadMailUI.this.Bxr = 2;
                            ReadMailUI.a(ReadMailUI.this);
                        }
                        AppMethodBeat.o(198745);
                    }
                });
                AppMethodBeat.o(198746);
            }
        });
        AppMethodBeat.o(198764);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(123193);
        super.onResume();
        if (this.Bxk) {
            eGZ();
        }
        AppMethodBeat.o(123193);
    }

    static /* synthetic */ void d(ReadMailUI readMailUI) {
        AppMethodBeat.i(198766);
        if (readMailUI.BwT != null) {
            readMailUI.Bxc.setText(readMailUI.BwT.Bru);
            readMailUI.timeTv.setText(readMailUI.BwT.BrH);
            readMailUI.Bxd.setEnabled(true);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Iterator<Bundle> it = readMailUI.BwT.BrI.iterator();
            while (it.hasNext()) {
                Bundle next = it.next();
                com.tencent.mm.plugin.qqmail.d.l lVar = new com.tencent.mm.plugin.qqmail.d.l();
                lVar.name = next.getString(FirebaseAnalytics.b.ITEM_NAME, "");
                lVar.yFq = next.getString("item_addr", "");
                arrayList.add(lVar);
            }
            readMailUI.BwW.j(arrayList, true);
            Iterator<Bundle> it2 = readMailUI.BwT.BrJ.iterator();
            while (it2.hasNext()) {
                Bundle next2 = it2.next();
                com.tencent.mm.plugin.qqmail.d.l lVar2 = new com.tencent.mm.plugin.qqmail.d.l();
                lVar2.name = next2.getString(FirebaseAnalytics.b.ITEM_NAME, "");
                lVar2.yFq = next2.getString("item_addr", "");
                arrayList2.add(lVar2);
            }
            readMailUI.BwY.j(arrayList2, true);
            Iterator<Bundle> it3 = readMailUI.BwT.BrK.iterator();
            while (it3.hasNext()) {
                Bundle next3 = it3.next();
                com.tencent.mm.plugin.qqmail.d.l lVar3 = new com.tencent.mm.plugin.qqmail.d.l();
                lVar3.name = next3.getString(FirebaseAnalytics.b.ITEM_NAME, "");
                lVar3.yFq = next3.getString("item_addr", "");
                arrayList3.add(lVar3);
            }
            if (!arrayList3.isEmpty()) {
                readMailUI.BwX.j(arrayList3, true);
                AppMethodBeat.o(198766);
                return;
            }
            readMailUI.BwX.setVisibility(8);
        }
        AppMethodBeat.o(198766);
    }

    static /* synthetic */ void e(ReadMailUI readMailUI) {
        AppMethodBeat.i(198767);
        readMailUI.kdb.setVisibility(0);
        com.tencent.mm.ipcinvoker.h.a(MMApplicationContext.getPackageName(), new IPCString(readMailUI.BwT.BrG), com.tencent.mm.plugin.qqmail.c.h.class, new d<Bundle>() {
            /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass11 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(Bundle bundle) {
                AppMethodBeat.i(198753);
                final Bundle bundle2 = bundle;
                if (ReadMailUI.this.isFinishing() || ReadMailUI.this.isDestroyed()) {
                    AppMethodBeat.o(198753);
                    return;
                }
                final String string = bundle2.getString("mail_id");
                if (ReadMailUI.this.BwT.BrG.equals(string)) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass11.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(198752);
                            ReadMailUI.this.kdb.setVisibility(8);
                            int i2 = bundle2.getInt("err_type");
                            int i3 = bundle2.getInt("err_code");
                            String string = bundle2.getString("err_msg");
                            Log.i("MicroMsg.ReadMailUI", "mailId %s, errType %d, errCode %d, errMsg %s", string, Integer.valueOf(i2), Integer.valueOf(i3), string);
                            if (i2 == 0 && i3 == 0) {
                                o oVar = ReadMailUI.this.BwT;
                                Bundle bundle = bundle2;
                                oVar.content = bundle.getString("mail_content");
                                oVar.BrL = bundle.getParcelableArrayList("mail_normal_attach");
                                oVar.BrM = bundle.getParcelableArrayList("mail_big_attach");
                                oVar.BrN = (Bundle) bundle.getParcelable("mail_cookie");
                                Log.d("MicroMsg.ReadMailUI", "mail content %s", ReadMailUI.this.BwT.content);
                                ReadMailUI.this.webView.loadDataWithBaseURL(v.eGq() + "?pageWidth=" + ReadMailUI.Bxv, "<html style=\"margin-top:" + ReadMailUI.Bxw + "px\">" + ReadMailUI.this.BwT.content + "</html>", "text/html", ProtocolPackage.ServerEncoding, null);
                                ArrayList arrayList = new ArrayList();
                                if (ReadMailUI.this.BwT.BrL != null) {
                                    arrayList.addAll(ReadMailUI.this.BwT.BrL);
                                }
                                if (ReadMailUI.this.BwT.BrM != null) {
                                    arrayList.addAll(ReadMailUI.this.BwT.BrM);
                                }
                                if (!arrayList.isEmpty()) {
                                    ReadMailUI.this.Bxe.setVisibility(0);
                                    ((TextView) ReadMailUI.this.findViewById(R.id.gt6)).setText(ReadMailUI.this.getString(R.string.fu7, new Object[]{Integer.valueOf(arrayList.size())}));
                                    ReadMailUI.this.Bxf.removeAllViews();
                                    ReadMailUI.this.Bxf.fY(arrayList);
                                } else {
                                    ReadMailUI.this.Bxe.setVisibility(8);
                                }
                                ReadMailUI.b(ReadMailUI.this, ReadMailUI.this.BwT);
                                AppMethodBeat.o(198752);
                                return;
                            }
                            if (Util.isNullOrNil(string)) {
                                string = ReadMailUI.this.getString(R.string.fob);
                            }
                            Toast.makeText(ReadMailUI.this, string, 1).show();
                            ReadMailUI.this.BwU.setVisibility(0);
                            AppMethodBeat.o(198752);
                        }
                    });
                }
                AppMethodBeat.o(198753);
            }
        });
        AppMethodBeat.o(198767);
    }

    static /* synthetic */ void b(ReadMailUI readMailUI, o oVar) {
        AppMethodBeat.i(198768);
        com.tencent.xweb.d.lA(readMailUI);
        com.tencent.xweb.c hsp = com.tencent.xweb.c.hsp();
        hsp.SyN.removeSessionCookie();
        if (oVar.BrN == null) {
            Log.w("MicroMsg.ReadMailUI", "cookie is null");
            AppMethodBeat.o(198768);
            return;
        }
        hsp.setCookie(v.eGq(), "xm_skey=" + oVar.BrN.getString("cookie_xmail_skey"));
        hsp.setCookie(v.eGq(), "xm_uin=" + oVar.BrN.getLong("cookie_xmail_uin"));
        hsp.setCookie(v.eGq(), "xm_sid=" + oVar.BrN.getString("cookie_xmail_sid"));
        com.tencent.xweb.d.hsr();
        com.tencent.xweb.d.sync();
        AppMethodBeat.o(198768);
    }

    static /* synthetic */ void Vk(int i2) {
        AppMethodBeat.i(198769);
        Bundle bundle = new Bundle();
        bundle.putInt("kv_report_key", 11288);
        bundle.putInt("kv_report_value", i2);
        com.tencent.mm.ipcinvoker.h.a(MMApplicationContext.getPackageName(), bundle, i.class, null);
        AppMethodBeat.o(198769);
    }

    static /* synthetic */ void m(ReadMailUI readMailUI) {
        AppMethodBeat.i(198770);
        Bundle bundle = new Bundle();
        bundle.putString("download_url", readMailUI.Bxm);
        bundle.putString("download_md5", readMailUI.Bxn);
        com.tencent.mm.ipcinvoker.h.a(MMApplicationContext.getPackageName(), bundle, com.tencent.mm.plugin.qqmail.c.b.class, new d<IPCLong>() {
            /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(IPCLong iPCLong) {
                AppMethodBeat.i(198741);
                IPCLong iPCLong2 = iPCLong;
                if (ReadMailUI.this.isFinishing() || ReadMailUI.this.isDestroyed()) {
                    AppMethodBeat.o(198741);
                    return;
                }
                ReadMailUI.this.lAs = iPCLong2.value;
                if (ReadMailUI.this.lAs <= 0) {
                    Log.e("MicroMsg.ReadMailUI", "doAddDownloadTask fail, downloadId = %d ", Long.valueOf(ReadMailUI.this.lAs));
                    AppMethodBeat.o(198741);
                    return;
                }
                ReadMailUI.this.sp = MMApplicationContext.getContext().getSharedPreferences("QQMAIL", com.tencent.mm.compatible.util.g.aps());
                if (ReadMailUI.this.sp != null) {
                    ReadMailUI.this.sp.edit().putLong("qqmail_downloadid", ReadMailUI.this.lAs).commit();
                }
                ReadMailUI.this.Bxr = 1;
                ReadMailUI.C(ReadMailUI.this);
                AppMethodBeat.o(198741);
            }
        });
        AppMethodBeat.o(198770);
    }

    static /* synthetic */ void n(ReadMailUI readMailUI) {
        AppMethodBeat.i(198771);
        com.tencent.f.h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass7 */

            /* JADX WARNING: Removed duplicated region for block: B:28:0x010e A[SYNTHETIC, Splitter:B:28:0x010e] */
            /* JADX WARNING: Removed duplicated region for block: B:36:0x012d A[SYNTHETIC, Splitter:B:36:0x012d] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 338
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass7.run():void");
            }
        }, "initQQMailDownloadUrlAndMD5");
        AppMethodBeat.o(198771);
    }

    static /* synthetic */ void b(ReadMailUI readMailUI, int i2) {
        AppMethodBeat.i(198772);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) readMailUI.Bxh.getLayoutParams();
        layoutParams.width = i2;
        readMailUI.Bxh.setLayoutParams(layoutParams);
        AppMethodBeat.o(198772);
    }

    static /* synthetic */ void q(ReadMailUI readMailUI) {
        AppMethodBeat.i(123197);
        Log.i("MicroMsg.ReadMailUI", "try to install %s", readMailUI.Bxp);
        if (!Util.isNullOrNil(readMailUI.Bxp)) {
            r.b(readMailUI, readMailUI.Bxp, null, false);
        }
        AppMethodBeat.o(123197);
    }

    static /* synthetic */ void r(ReadMailUI readMailUI) {
        AppMethodBeat.i(123198);
        final Intent intent = new Intent();
        if (Util.isNullOrNil(readMailUI.Bxx)) {
            Log.w("MicroMsg.ReadMailUI", "mQQMailSchemeForUnread is null");
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(readMailUI.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail"));
            com.tencent.mm.hellhoundlib.a.a.a(readMailUI, bl.axQ(), "com/tencent/mm/plugin/qqmail/ui/ReadMailUI", "openQQMail", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            readMailUI.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(readMailUI, "com/tencent/mm/plugin/qqmail/ui/ReadMailUI", "openQQMail", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(123198);
            return;
        }
        String str = readMailUI.Bxx;
        Log.d("MicroMsg.ReadMailUI", "qq mail scheme:%s", str);
        intent.setData(Uri.parse(str));
        intent.addFlags(268435456);
        if (Build.VERSION.SDK_INT >= 11) {
            intent.addFlags(32768);
        }
        if (Util.isIntentAvailable(readMailUI, intent)) {
            com.tencent.mm.ch.a.post(new Runnable() {
                /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass10 */

                public final void run() {
                    AppMethodBeat.i(123148);
                    com.tencent.mm.pluginsdk.model.app.h.c(ReadMailUI.this, intent, ReadMailUI.this.getString(R.string.awf));
                    AppMethodBeat.o(123148);
                }
            });
            AppMethodBeat.o(123198);
            return;
        }
        Log.w("MicroMsg.ReadMailUI", "schema failed");
        com.tencent.mm.ch.a.post(new Runnable() {
            /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(198754);
                com.tencent.mm.pluginsdk.model.app.h.c(ReadMailUI.this, ReadMailUI.this.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail"), ReadMailUI.this.getString(R.string.awf));
                AppMethodBeat.o(198754);
            }
        });
        AppMethodBeat.o(123198);
    }

    static /* synthetic */ void x(ReadMailUI readMailUI) {
        AppMethodBeat.i(198773);
        Bundle bundle = new Bundle();
        bundle.putString("mail_id", readMailUI.BwT.BrG);
        bundle.putInt("mail_status", 2);
        com.tencent.mm.ipcinvoker.h.a(MMApplicationContext.getPackageName(), bundle, k.class, new d<Bundle>() {
            /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(Bundle bundle) {
                AppMethodBeat.i(198740);
                final Bundle bundle2 = bundle;
                if (ReadMailUI.this.isFinishing() || ReadMailUI.this.isDestroyed()) {
                    AppMethodBeat.o(198740);
                    return;
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(123149);
                        int i2 = bundle2.getInt("err_type");
                        int i3 = bundle2.getInt("err_type");
                        String string = bundle2.getString("err_msg");
                        if (Util.isNullOrNil(string)) {
                            string = ReadMailUI.this.getString(R.string.foc);
                        }
                        if (i2 == 0 && i3 == 0) {
                            ReadMailUI.this.Bxd.setEnabled(false);
                            ReadMailUI.this.Bxd.setText(R.string.fuk);
                            ReadMailUI.this.Bxd.setTextColor(-7829368);
                            ReadMailUI.this.Bxd.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.cb.a.l(ReadMailUI.this, R.drawable.bn0), (Drawable) null, (Drawable) null, (Drawable) null);
                            ReadMailUI.A(ReadMailUI.this);
                            AppMethodBeat.o(123149);
                            return;
                        }
                        Toast.makeText(ReadMailUI.this, string, 1).show();
                        AppMethodBeat.o(123149);
                    }
                });
                AppMethodBeat.o(198740);
            }
        });
        AppMethodBeat.o(198773);
    }

    static /* synthetic */ void y(ReadMailUI readMailUI) {
        AppMethodBeat.i(198774);
        com.tencent.mm.ipcinvoker.h.a(MMApplicationContext.getPackageName(), new IPCLong(readMailUI.msgId), com.tencent.mm.plugin.qqmail.c.a.class, null);
        readMailUI.finish();
        AppMethodBeat.o(198774);
    }

    static /* synthetic */ void C(ReadMailUI readMailUI) {
        AppMethodBeat.i(198776);
        com.tencent.mm.ipcinvoker.h.a(MMApplicationContext.getPackageName(), new IPCLong(readMailUI.lAs), com.tencent.mm.plugin.qqmail.c.d.class, new d<Bundle>() {
            /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass9 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(Bundle bundle) {
                AppMethodBeat.i(198751);
                final Bundle bundle2 = bundle;
                if (bundle2 != null) {
                    com.tencent.f.h.RTc.aV(new Runnable() {
                        /* class com.tencent.mm.plugin.qqmail.ui.ReadMailUI.AnonymousClass9.AnonymousClass1 */

                        public final void run() {
                            int i2 = 0;
                            AppMethodBeat.i(198750);
                            ReadMailUI.this.Bxo = bundle2.getInt("download_status");
                            float f2 = bundle2.getFloat("download_progress");
                            Log.d("MicroMsg.ReadMailUI", "download progress %f", Float.valueOf(f2));
                            ReadMailUI.this.Bxg.setVisibility(0);
                            if (f2 == 1.0f) {
                                ReadMailUI.this.Bxz.stopTimer();
                                ReadMailUI.A(ReadMailUI.this);
                                AppMethodBeat.o(198750);
                                return;
                            }
                            ReadMailUI.a(ReadMailUI.this);
                            if (ReadMailUI.this.Bxq == 0) {
                                ReadMailUI.this.Bxq = ReadMailUI.this.Bxg.getWidth();
                            } else {
                                i2 = (int) (((float) ReadMailUI.this.Bxq) * f2);
                            }
                            ReadMailUI.b(ReadMailUI.this, i2);
                            ReadMailUI.this.Bxz.startTimer(500);
                            AppMethodBeat.o(198750);
                        }
                    });
                }
                AppMethodBeat.o(198751);
            }
        });
        AppMethodBeat.o(198776);
    }
}
