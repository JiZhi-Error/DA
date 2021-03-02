package com.tencent.xweb.xwalk;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.ValueCallback;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.xweb.JsRuntime;
import com.tencent.xweb.WebView;
import com.tencent.xweb.e;
import com.tencent.xweb.f;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.h;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.q;
import com.tencent.xweb.s;
import com.tencent.xweb.xwalk.a.a;
import com.tencent.xweb.xwalk.a.g;
import com.tencent.xweb.xwalk.a.j;
import com.tencent.xweb.xwalk.a.k;
import com.tencent.xweb.xwalk.a.m;
import com.tencent.xweb.xwalk.updater.Scheduler;
import com.tencent.xweb.xwalk.updater.XWebCoreScheduler;
import com.tencent.xweb.xwalk.updater.i;
import com.tencent.xweb.y;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkUpdater;

public final class d implements com.tencent.xweb.internal.d {
    WebView SFP;
    String SFQ = "";
    ScrollView SFR = null;
    TextView SFS = null;
    TextView SFT = null;
    TextView SFU = null;
    Button SFV = null;
    View SFW;
    boolean SFX = false;
    String SFY = "tools";
    private final String SFZ = "当前Dark Mode强制智能反色[%d,%d]（点击切换）";
    private final String SGa = "当前Dark Mode不强制智能反色[%d,%d]（点击切换）";
    private final String SGb = "当前Light Mode[%d,%d]（点击切换）";
    private final String SGc = "当前未知Mode[%d,%d]（点击切换）";
    private View.OnClickListener SGd = new View.OnClickListener() {
        /* class com.tencent.xweb.xwalk.d.AnonymousClass40 */

        public final void onClick(View view) {
            AppMethodBeat.i(207257);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            d.this.SFW.setVisibility(8);
            d.this.SFP.startLongScreenshot(new q() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass40.AnonymousClass1 */

                @Override // com.tencent.xweb.q
                public final void onLongScreenshotFinished(int i2, String str) {
                    AppMethodBeat.i(207254);
                    Log.d("WebDebugPage", "onLongScreenshotFinished with " + i2 + " / " + str);
                    AppMethodBeat.o(207254);
                }

                @Override // com.tencent.xweb.q
                public final File getCacheFileDir() {
                    AppMethodBeat.i(207255);
                    File file = new File(d.this.SzQ.getExternalCacheDir().getAbsolutePath(), "LongScreenshot");
                    AppMethodBeat.o(207255);
                    return file;
                }

                @Override // com.tencent.xweb.q
                public final File getResultFileDir() {
                    AppMethodBeat.i(207256);
                    File file = new File(d.this.SzQ.getExternalCacheDir().getAbsolutePath(), "LongScreenshot");
                    AppMethodBeat.o(207256);
                    return file;
                }

                @Override // com.tencent.xweb.q
                public final Bitmap overrideScreenshot(Bitmap bitmap) {
                    return bitmap;
                }

                @Override // com.tencent.xweb.q
                public final int getMaxHeightSupported() {
                    return 0;
                }
            }, true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$45", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(207257);
        }
    };
    Context SzQ;

    static /* synthetic */ void b(d dVar, String str) {
        AppMethodBeat.i(207288);
        dVar.agw(str);
        AppMethodBeat.o(207288);
    }

    public d(WebView webView) {
        AppMethodBeat.i(154224);
        this.SzQ = webView.getContext();
        this.SFP = webView;
        huO();
        huM();
        AppMethodBeat.o(154224);
    }

    @Override // com.tencent.xweb.internal.d
    public final void hsZ() {
        AppMethodBeat.i(154225);
        if (y.hsF().SzS) {
            a(true, (Button) null, false);
        }
        AppMethodBeat.o(154225);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0649  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x067f  */
    @Override // com.tencent.xweb.internal.d
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean bsn(java.lang.String r15) {
        /*
        // Method dump skipped, instructions count: 2308
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.xwalk.d.bsn(java.lang.String):boolean");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean dP(String str, boolean z) {
        char c2;
        f.c cVar;
        String[] strArr;
        f.a aVar;
        String[] strArr2;
        AppMethodBeat.i(154227);
        if (str.contains("debugxweb.qq.com") || z) {
            Uri parse = Uri.parse(str);
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames == null || queryParameterNames.size() == 0) {
                huQ();
                AppMethodBeat.o(154227);
                return true;
            }
            for (String str2 : queryParameterNames) {
                if (str2 != null) {
                    switch (str2.hashCode()) {
                        case -1688684924:
                            if (str2.equals("set_apkver")) {
                                c2 = 4;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1534940989:
                            if (str2.equals("clear_all_plugin")) {
                                c2 = 11;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1479708147:
                            if (str2.equals("set_config_peroid")) {
                                c2 = 7;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1302829141:
                            if (str2.equals("wait_debugger")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -1004318384:
                            if (str2.equals("set_force_filereader")) {
                                c2 = '\t';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -939528941:
                            if (str2.equals("revert_to_apk")) {
                                c2 = 6;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -83404669:
                            if (str2.equals("debug_process")) {
                                c2 = 3;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 208243139:
                            if (str2.equals("recheck_cmds")) {
                                c2 = '\b';
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 368659514:
                            if (str2.equals("clear_commands")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 603805332:
                            if (str2.equals("load_local_xwalk")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1098980480:
                            if (str2.equals("check_files")) {
                                c2 = 5;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case 1112413629:
                            if (str2.equals("set_force_use_office_reader")) {
                                c2 = '\n';
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    switch (c2) {
                        case 0:
                            Es(false);
                            continue;
                        case 1:
                            com.tencent.xweb.a.a(null, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                            continue;
                        case 2:
                            boolean booleanQueryParameter = parse.getBooleanQueryParameter("wait_debugger", false);
                            y hsF = y.hsF();
                            hsF.SzX = booleanQueryParameter;
                            hsF.SzQ.getSharedPreferences("wcwebview", 0).edit().putBoolean("bWaitforDebugger", booleanQueryParameter).commit();
                            continue;
                        case 3:
                            y.hsF().SzQ.getSharedPreferences("wcwebview", 4).edit().putString("strDebugProcess", parse.getQueryParameter("debug_process")).commit();
                            continue;
                        case 4:
                            String queryParameter = parse.getQueryParameter("set_apkver");
                            try {
                                XWalkEnvironment.setAvailableVersion(Integer.parseInt(queryParameter), "1.0.".concat(String.valueOf(queryParameter)), XWalkEnvironment.getRuntimeAbi());
                                dR("版本号设置到:" + queryParameter + " 点击空白处退出重启进程", true);
                                continue;
                            } catch (Exception e2) {
                                dQ("设置版本号失败:" + e2.getMessage(), true);
                                break;
                            }
                        case 5:
                            p.Et(true);
                            continue;
                        case 6:
                            try {
                                dR("版本号回滚到:" + p.aX(XWalkEnvironment.getApplicationContext(), Integer.parseInt(parse.getQueryParameter("revert_to_apk"))) + " 点击空白处退出重启进程", true);
                                continue;
                            } catch (Exception e3) {
                                dQ("版本号回滚到失败:" + e3.getMessage(), true);
                                break;
                            }
                        case 7:
                            String queryParameter2 = parse.getQueryParameter("set_config_peroid");
                            try {
                                com.tencent.xweb.a.asP(Integer.parseInt(queryParameter2));
                                dR("设置配置拉取周期为:" + queryParameter2 + "分钟", false);
                                continue;
                            } catch (Exception e4) {
                                dQ("设置配置拉取周期失败:" + e4.getMessage(), true);
                                break;
                            }
                        case '\b':
                            l.g(WebView.c.WV_KIND_CW).excute("STR_CMD_SET_RECHECK_COMMAND", null);
                            dR("重新跑了一遍命令配置 点击空白处退出重启进程", true);
                            continue;
                        case '\t':
                            String str3 = "";
                            try {
                                str3 = parse.getQueryParameter("set_force_filereader");
                            } catch (Exception e5) {
                            }
                            String[] split = str3.split("_");
                            if (str3.length() >= 2) {
                                String str4 = split[split.length - 1];
                                if ("xweb".equalsIgnoreCase(str4)) {
                                    aVar = f.a.XWEB;
                                } else if ("x5".equalsIgnoreCase(str4)) {
                                    aVar = f.a.X5;
                                } else if (!"none".equalsIgnoreCase(str4)) {
                                    dQ("强制设置文件预览方式失败，类型错误", true);
                                    break;
                                } else {
                                    aVar = f.a.NONE;
                                }
                                if (split.length != 2 || !"all".equalsIgnoreCase(split[0])) {
                                    String[] strArr3 = new String[(split.length - 1)];
                                    for (int i2 = 0; i2 < split.length - 1; i2++) {
                                        strArr3[i2] = split[i2];
                                    }
                                    strArr2 = strArr3;
                                } else {
                                    strArr2 = f.SyR;
                                }
                                String a2 = y.hsF().a(strArr2, aVar);
                                if (!a2.isEmpty()) {
                                    dQ("格式:" + a2 + "强制使用" + aVar.name() + "打开", true);
                                    break;
                                } else {
                                    dQ("强制设置文件预览方式失败", true);
                                    break;
                                }
                            } else {
                                dQ("强制设置文件预览方式失败，参数错误", true);
                                continue;
                            }
                            break;
                        case '\n':
                            String str5 = "";
                            try {
                                str5 = parse.getQueryParameter("set_force_filereader");
                            } catch (Exception e6) {
                            }
                            String[] split2 = str5.split("_");
                            if (str5.length() >= 2) {
                                String str6 = split2[split2.length - 1];
                                if ("yes".equalsIgnoreCase(str6)) {
                                    cVar = f.c.yes;
                                } else if ("no".equalsIgnoreCase(str6)) {
                                    cVar = f.c.no;
                                } else if (!"none".equalsIgnoreCase(str6)) {
                                    dQ("强制设置OfficeReader失败，类型错误", true);
                                    break;
                                } else {
                                    cVar = f.c.none;
                                }
                                if (split2.length != 2 || !"all".equalsIgnoreCase(split2[0])) {
                                    String[] strArr4 = new String[(split2.length - 1)];
                                    for (int i3 = 0; i3 < split2.length - 1; i3++) {
                                        strArr4[i3] = split2[i3];
                                    }
                                    strArr = strArr4;
                                } else {
                                    strArr = new String[]{"doc", "docx", "xls", "xlsx", "ppt", "pptx"};
                                }
                                String a3 = y.hsF().a(strArr, cVar);
                                if (!a3.isEmpty()) {
                                    dQ("格式:" + a3 + "强制OfficeReader状态：" + cVar.toString(), true);
                                    break;
                                } else {
                                    dQ("强制设置OfficeReader失败", true);
                                    break;
                                }
                            } else {
                                dQ("强制设置OfficeReader失败，参数错误", true);
                                continue;
                            }
                            break;
                        case 11:
                            huS();
                            continue;
                    }
                }
            }
            AppMethodBeat.o(154227);
            return true;
        }
        AppMethodBeat.o(154227);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void huM() {
        AppMethodBeat.i(154228);
        if (!y.hsF().SzV) {
            AppMethodBeat.o(154228);
        } else if (this.SFV != null) {
            AppMethodBeat.o(154228);
        } else {
            this.SFV = new Button(this.SzQ);
            this.SFV.setText("保存页面");
            this.SFV.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154152);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    new AlertDialog.Builder(d.this.SzQ).setTitle("保存页面").setMessage("确定保存页面？").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        /* class com.tencent.xweb.xwalk.d.AnonymousClass1.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(154151);
                            d dVar = d.this;
                            Date date = new Date();
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss");
                            String str = Environment.getExternalStorageDirectory().getPath() + "/xweb_dump/" + simpleDateFormat.format(date);
                            dVar.SFP.savePage(str + "/main.html", str + "/resource", 1);
                            new Thread(new Runnable(str) {
                                /* class com.tencent.xweb.xwalk.d.AnonymousClass49 */
                                final /* synthetic */ String SGJ;

                                {
                                    this.SGJ = r2;
                                }

                                public final void run() {
                                    AppMethodBeat.i(207271);
                                    try {
                                        Thread.sleep(5000);
                                    } catch (InterruptedException e2) {
                                    }
                                    u.a(new File[]{new File(this.SGJ)}, this.SGJ + ".zip", -1);
                                    AppMethodBeat.o(207271);
                                }
                            }).start();
                            AppMethodBeat.o(154151);
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        /* class com.tencent.xweb.xwalk.d.AnonymousClass1.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    }).show();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154152);
                }
            });
            this.SFP.getTopView().addView(this.SFV);
            AppMethodBeat.o(154228);
        }
    }

    private static String a(Context context, WebView.c cVar, String str) {
        boolean z;
        WebView.c cVar2;
        WebView.c cVar3;
        boolean z2 = true;
        AppMethodBeat.i(154229);
        XWalkEnvironment.init(context);
        StringBuilder sb = new StringBuilder();
        sb.append("\n   default core type ".concat(String.valueOf(cVar)));
        if (XWalkEnvironment.isIaDevice()) {
            sb.append(", is prefer WV_KIND_SYS because of this is x86 device");
            String sb2 = sb.toString();
            AppMethodBeat.o(154229);
            return sb2;
        }
        if (com.tencent.xweb.a.brE(str) != WebView.c.WV_KIND_NONE) {
            cVar = com.tencent.xweb.a.brE(str);
            sb.append("\n   has command type ".concat(String.valueOf(cVar)));
        }
        if (y.hsF().dI(str, true) != WebView.c.WV_KIND_NONE) {
            cVar = y.hsF().bsk(str);
            sb.append("\n   has abtest type ".concat(String.valueOf(cVar)));
            z = true;
        } else {
            z = false;
        }
        if (y.hsF().dI(str, false) != WebView.c.WV_KIND_NONE) {
            cVar2 = y.hsF().bsk(str);
            sb.append("\n   has hardcode type ".concat(String.valueOf(cVar2)));
        } else {
            z2 = z;
            cVar2 = cVar;
        }
        if (z2 || cVar2 != WebView.c.WV_KIND_CW || !XWalkEnvironment.getXWebInitArgs(XWalkEnvironment.XWALK_ENV_MAP_KEY_ISGPVERSION, false)) {
            cVar3 = cVar2;
        } else {
            cVar3 = WebView.c.WV_KIND_SYS;
            sb.append("\n   is prefer " + cVar3 + " because of gp version");
        }
        if (cVar3 == WebView.c.WV_KIND_CW && !XWalkEnvironment.hasAvailableVersion()) {
            cVar3 = WebView.c.WV_KIND_X5;
            sb.append("\n   is prefer " + cVar3 + " because of xwalk is not available");
        }
        h.d(cVar3);
        if (h.htF().htK()) {
            cVar3 = WebView.c.WV_KIND_SYS;
            sb.append("\n   is prefer " + cVar3 + " because of LoadUrlWatchDog");
        }
        if (com.tencent.xweb.internal.b.c(cVar3)) {
            sb.append("\n   will not use " + cVar3 + " because of CrashWatchDog hit");
        }
        if (cVar3 == WebView.c.WV_KIND_X5) {
            com.tencent.xweb.x5.sdk.d.huK();
        }
        sb.insert(0, "module: " + str + " core type is " + cVar3);
        String sb3 = sb.toString();
        AppMethodBeat.o(154229);
        return sb3;
    }

    /* access modifiers changed from: package-private */
    public final void huN() {
        String str;
        AppMethodBeat.i(154230);
        if (this.SFU == null) {
            AppMethodBeat.o(154230);
            return;
        }
        String xWalkUpdateConfigUrl = XWalkEnvironment.getXWalkUpdateConfigUrl();
        String str2 = "\n\n" + this.SFP.getAbstractInfo();
        if (WebView.getCurWebType() != WebView.c.WV_KIND_CW) {
            str2 = str2 + "\n xwebsdk is = 201201 apk ver is " + XWalkEnvironment.getAvailableVersion() + " des " + XWalkEnvironment.getAvailableVersionDetail();
        }
        int i2 = XWalkEnvironment.getApplicationContext().getApplicationInfo() != null ? XWalkEnvironment.getApplicationContext().getApplicationInfo().targetSdkVersion : 0;
        String str3 = (str2 + "\n\n current js engine: =  " + JsRuntime.hsu() + "\n prefered js engine =  " + JsRuntime.a(JsRuntime.JsRuntimeType.RT_TYPE_AUTO, "appbrand", this.SzQ) + "\n user id(uin) = " + XWalkEnvironment.getUserId() + "\n local gray value = " + XWalkEnvironment.getGrayValue() + "\n local gray device rd value = " + XWalkEnvironment.getDeviceRd() + "\n today gray value = " + XWalkEnvironment.getTodayGrayValue() + "\n config url = " + xWalkUpdateConfigUrl + "\n config period(minutes) = " + (Scheduler.hvH() / Util.MILLSECONDS_OF_MINUTE) + "\n\n apilevel = " + Build.VERSION.SDK_INT + "\n apilevel = " + i2 + "\n sys webversion = " + XWalkEnvironment.safeGetChromiunVersion() + "\n device is  " + Build.BRAND + " " + Build.MODEL + "\n usertype is " + XWalkEnvironment.getUserType() + "\n runtime abi is " + XWalkEnvironment.getRuntimeAbi() + "\n device abi is " + XWalkEnvironment.getDeviceAbi() + "\n installed ver for arm32 is " + XWalkEnvironment.getInstalledNewstVersion(XWalkEnvironment.RUNTIME_ABI_ARM32_STR) + "\n installed ver for arm64 is " + XWalkEnvironment.getInstalledNewstVersion(XWalkEnvironment.RUNTIME_ABI_ARM64_STR) + "\n should embed =  false\n embed lib md5 match =  true\n embed config ver =  0/0" + "\n embed try installed ver =  " + XWalkUpdater.getLastTryInstallVer(XWalkEnvironment.getRuntimeAbi()) + "\n current useragent: " + this.SFP.getSettings().getUserAgentString() + "\n current clientversion: 0x" + Integer.toHexString(XWalkEnvironment.getAppClientVersion()) + "\n current app infos dump : " + XWalkEnvironment.dumpAppInfo()) + "\n\n ------dump module prefer webview core start:------\n";
        try {
            str3 = (((str3 + a(this.SzQ, WebView.c.WV_KIND_X5, "tools") + "\n") + a(this.SzQ, WebView.c.WV_KIND_CW, "toolsmp") + "\n") + a(this.SzQ, WebView.c.WV_KIND_NONE, "mm") + "\n") + a(this.SzQ, WebView.c.WV_KIND_CW, "appbrand") + "\n";
            str = str3 + a(this.SzQ, WebView.c.WV_KIND_CW, "support") + "\n";
        } catch (Exception e2) {
            str = str3 + e2.getMessage() + "\n";
        }
        String str4 = ((str + "------dump module prefer webview core end------") + "\n" + XWebCoreScheduler.hvW().hvx()) + "\n" + i.hvV().hvx();
        for (g gVar : com.tencent.xweb.xwalk.a.h.hvo()) {
            if (gVar != null) {
                str4 = str4 + "\n" + com.tencent.xweb.xwalk.a.a.bsQ(gVar.getPluginName()).hvx();
            }
        }
        String str5 = (((str4 + "\n current update match gap backward(update speed) is " + Scheduler.bsT(Scheduler.Ev(false).Ex(false))) + "\n current update match gap forward(提前更新) is " + Scheduler.bsT(Scheduler.Ev(false).Ex(true))) + "\n plugin current update match gap backward(update speed) is " + Scheduler.bsT(new a.C2235a("").Ex(false))) + "\n plugin current update match gap forward(提前更新) is " + Scheduler.bsT(new a.C2235a("").Ex(true));
        String abstractInfo = com.tencent.xweb.a.getAbstractInfo();
        String str6 = (abstractInfo == null || abstractInfo.isEmpty()) ? str5 : str5 + "\n\n ------dump commands start:------\n" + abstractInfo + "\n ------dump commands end------";
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n ------plugin info start:------\n plugin config url = ").append(XWalkEnvironment.getPluginConfigUrl()).append("\n plugin config period(minutes) = ").append(XWalkEnvironment.getPluginUpdatePeriod() / 60000).append("\n\n plugin version:");
        for (g gVar2 : com.tencent.xweb.xwalk.a.h.hvo()) {
            if (gVar2 != null) {
                sb.append("\n ").append(gVar2.getPluginName()).append(" = ").append(gVar2.hvk());
            }
        }
        sb.append("\n\n plugin commands:");
        String abstractInfo2 = com.tencent.xweb.b.getAbstractInfo();
        if (abstractInfo2 == null || abstractInfo2.isEmpty()) {
            sb.append("\n null\n");
        } else {
            sb.append("\n").append(abstractInfo2);
        }
        sb.append("\n xfiles setting:");
        if (y.hsF() != null) {
            sb.append("\n disable cache = ").append(y.hsF().hsG());
            sb.append("\n disable crash detect = ").append(y.hsF().hsH());
        }
        sb.append(huR()).append("\n\n ------plugin info end:------");
        String str7 = str6 + sb.toString();
        String str8 = "";
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TimeUtil.YYYY2MM2DD_HH1MM1SS);
            if (Scheduler.Ev(false).hvz()) {
                String format = simpleDateFormat.format(new Date(Scheduler.Ev(false).hvJ().SJf));
                str8 = ((((((((((str8 + "going to update to apk ver = " + Scheduler.Ev(false).hvJ().version) + "\n update time is = " + format) + "\n is patch update = " + Scheduler.Ev(false).hvJ().SJc) + "\n can use cellular = " + Scheduler.Ev(false).hvJ().SIE) + "\n updateHourStart = " + Scheduler.Ev(false).hvJ().SJj) + "\n updateHourEnd = " + Scheduler.Ev(false).hvJ().SJk) + "\n versionId = " + Scheduler.Ev(false).hvJ().SIv) + "\n update time is = " + format) + "\n try count = " + Scheduler.Ev(false).hvJ().SJh) + "\n try use shared core count = " + Scheduler.Ev(false).hvJ().SJi) + "\n";
            }
            str8 = (str8 + " last fetch config time = " + simpleDateFormat.format(new Date(Scheduler.Ev(false).hvJ().SJa))) + " last fetch config abi = " + Scheduler.Ev(false).hvJ().SJb;
        } catch (Exception e3) {
        }
        if (str8 != null && !str8.isEmpty()) {
            str7 = str7 + "\n\n ------dump schedule updateInfo start:------\n" + str8 + "\n ------dump schedule updateInfo end------";
        }
        String xWalkInitializeLog = XWalkEnvironment.getXWalkInitializeLog();
        if (xWalkInitializeLog != null && !xWalkInitializeLog.isEmpty()) {
            str7 = str7 + "\n\n ------dump xweb log------\n" + xWalkInitializeLog;
        }
        this.SFU.setText(str7);
        AppMethodBeat.o(154230);
    }

    /* access modifiers changed from: package-private */
    public final void huO() {
        AppMethodBeat.i(154231);
        if (!y.hsF().SzT && (!y.hsF().SzU || this.SFP.getWebCoreType() != WebView.c.WV_KIND_X5)) {
            AppMethodBeat.o(154231);
        } else if (this.SFT != null) {
            AppMethodBeat.o(154231);
        } else {
            this.SFT = new TextView(this.SzQ);
            this.SFT.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass23 */

                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(154176);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    d.this.huQ();
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/xweb/xwalk/WebDebugPage$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(154176);
                    return true;
                }
            });
            huP();
            this.SFP.getTopView().addView(this.SFT);
            AppMethodBeat.o(154231);
        }
    }

    /* access modifiers changed from: package-private */
    public final String Er(boolean z) {
        AppMethodBeat.i(154232);
        String versionInfo = this.SFP.getVersionInfo();
        if (!z) {
            int indexOf = versionInfo.indexOf(",apkversion");
            if (indexOf > 0) {
                versionInfo = versionInfo.substring(0, indexOf);
            }
        } else {
            versionInfo = versionInfo + ", " + com.tencent.xweb.xwalk.a.h.hvp() + " current process is " + XWalkEnvironment.getProcessName();
        }
        AppMethodBeat.o(154232);
        return versionInfo;
    }

    private void huP() {
        AppMethodBeat.i(154233);
        if (this.SFT == null) {
            AppMethodBeat.o(154233);
            return;
        }
        this.SFT.setText(Er(false));
        AppMethodBeat.o(154233);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: package-private */
    public final void m(WebView.c cVar) {
        AppMethodBeat.i(154234);
        switch (cVar) {
            case WV_KIND_CW:
                ((RadioButton) this.SFW.findViewById(R.id.a1)).setChecked(true);
                AppMethodBeat.o(154234);
                return;
            case WV_KIND_X5:
                ((RadioButton) this.SFW.findViewById(R.id.a0)).setChecked(true);
                AppMethodBeat.o(154234);
                return;
            case WV_KIND_SYS:
                ((RadioButton) this.SFW.findViewById(R.id.z)).setChecked(true);
                break;
            case WV_KIND_NONE:
                ((RadioButton) this.SFW.findViewById(R.id.y)).setChecked(true);
                AppMethodBeat.o(154234);
                return;
        }
        AppMethodBeat.o(154234);
    }

    /* access modifiers changed from: package-private */
    public final boolean huQ() {
        String concat;
        AppMethodBeat.i(154235);
        b(this.SFP);
        if (this.SFW != null) {
            this.SFW.setVisibility(0);
            AppMethodBeat.o(154235);
        } else {
            this.SFW = ((LayoutInflater) this.SzQ.getSystemService("layout_inflater")).inflate(R.layout.z1, this.SFP.getTopView(), true).findViewById(R.id.j7o);
            ((Button) this.SFW.findViewById(R.id.agx)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass34 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154187);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    d.this.SFW.setVisibility(8);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154187);
                }
            });
            final CheckBox checkBox = (CheckBox) this.SFW.findViewById(R.id.b0y);
            checkBox.setChecked(y.hsF().SzT);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass45 */

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AppMethodBeat.i(154208);
                    y hsF = y.hsF();
                    if (z != hsF.SzT) {
                        hsF.SzT = z;
                        hsF.SzQ.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowVersion", hsF.SzT).commit();
                    }
                    if (z) {
                        d.this.huO();
                        d.this.SFT.setVisibility(0);
                        AppMethodBeat.o(154208);
                        return;
                    }
                    if (d.this.SFT != null) {
                        d.this.SFT.setVisibility(8);
                    }
                    AppMethodBeat.o(154208);
                }
            });
            ((TextView) this.SFW.findViewById(R.id.b0e)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass52 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154212);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    checkBox.setChecked(!checkBox.isChecked());
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154212);
                }
            });
            final EditText editText = (EditText) this.SFW.findViewById(R.id.izh);
            if (editText != null) {
                editText.setInputType(2);
                editText.setText(new StringBuilder().append(XWalkEnvironment.getGrayValue()).toString());
                editText.addTextChangedListener(new TextWatcher() {
                    /* class com.tencent.xweb.xwalk.d.AnonymousClass53 */

                    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }

                    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }

                    public final void afterTextChanged(Editable editable) {
                        AppMethodBeat.i(154213);
                        int i2 = 0;
                        try {
                            i2 = Integer.parseInt(editText.getText().toString());
                        } catch (Exception e2) {
                        }
                        XWalkEnvironment.setGrayValueForTest(i2);
                        AppMethodBeat.o(154213);
                    }
                });
            }
            ((Spinner) this.SFW.findViewById(R.id.hj6)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass54 */

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(154214);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(adapterView);
                    bVar.bm(view);
                    bVar.pH(i2);
                    bVar.zo(j2);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$8", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                    d.this.SFY = d.this.SzQ.getResources().getStringArray(R.array.b3)[i2];
                    d dVar = d.this;
                    dVar.SFX = true;
                    if (dVar.SFY.equals("all")) {
                        String[] stringArray = dVar.SzQ.getResources().getStringArray(R.array.b2);
                        WebView.c bsk = y.hsF().bsk(stringArray[0]);
                        int i3 = 1;
                        while (true) {
                            if (i3 >= stringArray.length) {
                                dVar.m(bsk);
                                break;
                            } else if (y.hsF().bsk(stringArray[i3]) != bsk) {
                                ((RadioButton) dVar.SFW.findViewById(R.id.y)).setChecked(false);
                                ((RadioButton) dVar.SFW.findViewById(R.id.a1)).setChecked(false);
                                ((RadioButton) dVar.SFW.findViewById(R.id.a0)).setChecked(false);
                                ((RadioButton) dVar.SFW.findViewById(R.id.z)).setChecked(false);
                                break;
                            } else {
                                i3++;
                            }
                        }
                    } else {
                        dVar.m(y.hsF().bsk(dVar.SFY));
                    }
                    dVar.SFX = false;
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$8", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(154214);
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public final void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            ((RadioGroup) this.SFW.findViewById(R.id.jkh)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass55 */

                public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                    AppMethodBeat.i(154215);
                    if (d.this.SFX) {
                        AppMethodBeat.o(154215);
                        return;
                    }
                    WebView.c cVar = WebView.c.WV_KIND_NONE;
                    if (i2 == R.id.y) {
                        cVar = WebView.c.WV_KIND_NONE;
                    } else if (i2 == R.id.a1) {
                        cVar = WebView.c.WV_KIND_CW;
                    } else if (i2 == R.id.a0) {
                        cVar = WebView.c.WV_KIND_X5;
                    } else if (i2 == R.id.z) {
                        cVar = WebView.c.WV_KIND_SYS;
                    }
                    if (!d.this.SFY.equals("all")) {
                        y.hsF().a(d.this.SFY, cVar);
                        Log.d("WebDebugPage", "webview change to=".concat(String.valueOf(cVar)));
                        AppMethodBeat.o(154215);
                        return;
                    }
                    String[] stringArray = d.this.SzQ.getResources().getStringArray(R.array.b2);
                    for (int i3 = 0; i3 < stringArray.length; i3++) {
                        y.hsF().a(stringArray[i3], cVar);
                        Log.d("WebDebugPage", "webview " + stringArray[i3] + " change to=" + cVar);
                    }
                    AppMethodBeat.o(154215);
                }
            });
            switch (y.hsF().SzZ) {
                case RT_TYPE_AUTO:
                    ((RadioButton) this.SFW.findViewById(R.id.j1w)).setChecked(true);
                    break;
                case RT_TYPE_SYS:
                    ((RadioButton) this.SFW.findViewById(R.id.j20)).setChecked(true);
                    break;
                case RT_TYPE_X5:
                    ((RadioButton) this.SFW.findViewById(R.id.j21)).setChecked(true);
                    break;
                case RT_TYPE_NATIVE_SCRIPT:
                    ((RadioButton) this.SFW.findViewById(R.id.j1y)).setChecked(true);
                    break;
                case RT_TYPE_MMV8:
                    ((RadioButton) this.SFW.findViewById(R.id.j1x)).setChecked(true);
                    break;
            }
            ((RadioGroup) this.SFW.findViewById(R.id.j1z)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass2 */

                public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                    AppMethodBeat.i(154153);
                    JsRuntime.JsRuntimeType jsRuntimeType = JsRuntime.JsRuntimeType.RT_TYPE_AUTO;
                    if (i2 == R.id.j1w) {
                        jsRuntimeType = JsRuntime.JsRuntimeType.RT_TYPE_AUTO;
                    } else if (i2 == R.id.j20) {
                        jsRuntimeType = JsRuntime.JsRuntimeType.RT_TYPE_SYS;
                    } else if (i2 == R.id.j21) {
                        jsRuntimeType = JsRuntime.JsRuntimeType.RT_TYPE_X5;
                    } else if (i2 == R.id.j1y) {
                        jsRuntimeType = JsRuntime.JsRuntimeType.RT_TYPE_NATIVE_SCRIPT;
                    } else if (i2 == R.id.j1x) {
                        jsRuntimeType = JsRuntime.JsRuntimeType.RT_TYPE_MMV8;
                    }
                    y.hsF().a(jsRuntimeType);
                    Log.d("WebDebugPage", "v8 type change to=".concat(String.valueOf(jsRuntimeType)));
                    AppMethodBeat.o(154153);
                }
            });
            ((Button) this.SFW.findViewById(R.id.ah5)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154154);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    d.this.SFW.setVisibility(8);
                    d.this.bCn();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154154);
                }
            });
            final Button button = (Button) this.SFW.findViewById(R.id.aer);
            a(y.hsF().SzS, button, false);
            button.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass4 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154155);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    boolean z = !y.hsF().SzS;
                    y.hsF().setDebugEnable(z);
                    d.this.a(z, button, true);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154155);
                }
            });
            ((Button) this.SFW.findViewById(R.id.agu)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154156);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    XWalkEnvironment.clearAllVersion(d.this.SzQ);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154156);
                }
            });
            ((Button) this.SFW.findViewById(R.id.ahh)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass6 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154157);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    ((TextView) d.this.SFW.findViewById(R.id.izc)).setText(d.this.Er(true) + "\n" + XWalkInitializer.getXWalkInitializeLog());
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154157);
                }
            });
            ((Button) this.SFW.findViewById(R.id.ah8)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass7 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154158);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    d.this.Es(true);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154158);
                }
            });
            final Button button2 = (Button) this.SFW.findViewById(R.id.agz);
            if (!this.SFP.isXWalkKernel() || !XWalkEnvironment.isCurrentVersionSupportForceDarkMode()) {
                button2.setVisibility(8);
            } else {
                button2.setVisibility(0);
            }
            f(button2);
            button2.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass8 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154159);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    d dVar = d.this;
                    Button button = button2;
                    int forceDarkMode = dVar.SFP.getSettings().getForceDarkMode();
                    int forceDarkBehavior = dVar.SFP.getSettings().getForceDarkBehavior();
                    if (forceDarkMode != 0 && forceDarkMode == 2) {
                        if (forceDarkBehavior == 2) {
                            dVar.SFP.getSettings().setForceDarkBehavior(1);
                        } else if (forceDarkBehavior == 1) {
                            dVar.SFP.getSettings().setForceDarkMode(0);
                        } else if (forceDarkBehavior == 0) {
                            dVar.SFP.getSettings().setForceDarkMode(0);
                        }
                        dVar.f(button);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(154159);
                    }
                    dVar.SFP.getSettings().setForceDarkMode(2);
                    dVar.SFP.getSettings().setForceDarkBehavior(2);
                    dVar.f(button);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154159);
                }
            });
            final Button button3 = (Button) this.SFW.findViewById(R.id.agy);
            String xWalkUpdateConfigUrl = XWalkEnvironment.getXWalkUpdateConfigUrl();
            String str = "(当前为" + xWalkUpdateConfigUrl.substring(xWalkUpdateConfigUrl.lastIndexOf(47) + 1) + ")";
            if (y.hsF().SAa) {
                concat = "使用正式版config".concat(String.valueOf(str));
            } else {
                concat = "使用测试config".concat(String.valueOf(str));
            }
            button3.setText(concat);
            button3.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass9 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154160);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    y.hsF().Ej(!y.hsF().SAa);
                    String xWalkUpdateConfigUrl = XWalkEnvironment.getXWalkUpdateConfigUrl();
                    String str = "(当前为" + xWalkUpdateConfigUrl.substring(xWalkUpdateConfigUrl.lastIndexOf(47) + 1) + ")";
                    button3.setText(y.hsF().SAa ? "使用正式版config".concat(String.valueOf(str)) : "使用测试config".concat(String.valueOf(str)));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154160);
                }
            });
            ((Button) this.SFW.findViewById(R.id.ahk)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass10 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154161);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    d.this.huT();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154161);
                }
            });
            final LinearLayout linearLayout = (LinearLayout) this.SFW.findViewById(R.id.gd6);
            linearLayout.setVisibility(8);
            Button button4 = (Button) this.SFW.findViewById(R.id.ahe);
            button4.setText("插件设置");
            button4.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass11 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154162);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (linearLayout.getVisibility() == 8) {
                        linearLayout.setVisibility(0);
                        ((Button) view).setText("隐藏插件设置");
                    } else {
                        linearLayout.setVisibility(8);
                        ((Button) view).setText("插件设置");
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154162);
                }
            });
            final Button button5 = (Button) this.SFW.findViewById(R.id.ahd);
            String pluginTestConfigUrl = XWalkEnvironment.getPluginTestConfigUrl();
            if (pluginTestConfigUrl == null || pluginTestConfigUrl.isEmpty()) {
                button5.setText("切换插件配置，当前使用正式版");
            } else if (pluginTestConfigUrl.equalsIgnoreCase(XWalkEnvironment.DOWNLOAD_PLUGIN_UPDATE_TEST_CONFIG_DEFAULT_URL)) {
                button5.setText("切换插件配置，当前使用默认测试版");
            } else {
                button5.setText("切换插件配置, 当前使用自定义测试版");
            }
            button5.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass13 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154164);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    String pluginTestConfigUrl = XWalkEnvironment.getPluginTestConfigUrl();
                    if (pluginTestConfigUrl == null || pluginTestConfigUrl.isEmpty()) {
                        if (XWalkEnvironment.setPluginTestConfigUrl(XWalkEnvironment.DOWNLOAD_PLUGIN_UPDATE_TEST_CONFIG_DEFAULT_URL)) {
                            button5.setText("切换插件配置，当前使用默认测试版");
                        } else {
                            d.this.dQ("切换失败", true);
                        }
                    } else if (XWalkEnvironment.setPluginTestConfigUrl("")) {
                        button5.setText("切换插件配置，当前使用正式版");
                    } else {
                        d.this.dQ("切换失败", true);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154164);
                }
            });
            ((Button) this.SFW.findViewById(R.id.ahl)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass14 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154165);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    d.lF(d.this.SzQ);
                    Toast.makeText(d.this.SzQ, "开始检测插件更新", 0).show();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154165);
                }
            });
            ((Button) this.SFW.findViewById(R.id.agv)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass15 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154166);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    d.this.huS();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154166);
                }
            });
            ((Spinner) this.SFW.findViewById(R.id.i3o)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass16 */

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppMethodBeat.i(154167);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(adapterView);
                    bVar.bm(view);
                    bVar.pH(i2);
                    bVar.zo(j2);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$23", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                    String[] stringArray = d.this.SzQ.getResources().getStringArray(R.array.a_);
                    d.this.SFQ = stringArray[i2];
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$23", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(154167);
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public final void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            ((Button) this.SFW.findViewById(R.id.ah_)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass17 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154169);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    d.a(d.this.SzQ, d.this.SFQ, false, new ValueCallback<Boolean>() {
                        /* class com.tencent.xweb.xwalk.d.AnonymousClass17.AnonymousClass1 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // android.webkit.ValueCallback
                        public final /* synthetic */ void onReceiveValue(Boolean bool) {
                            AppMethodBeat.i(154168);
                            if (bool.booleanValue()) {
                                d.a(d.this, d.this.SFQ);
                            }
                            AppMethodBeat.o(154168);
                        }
                    });
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154169);
                }
            });
            ((Button) this.SFW.findViewById(R.id.aha)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass18 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154171);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    d.a(d.this.SzQ, d.this.SFQ, true, new ValueCallback<Boolean>() {
                        /* class com.tencent.xweb.xwalk.d.AnonymousClass18.AnonymousClass1 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // android.webkit.ValueCallback
                        public final /* synthetic */ void onReceiveValue(Boolean bool) {
                            AppMethodBeat.i(154170);
                            if (bool.booleanValue()) {
                                d.a(d.this, d.this.SFQ);
                            }
                            AppMethodBeat.o(154170);
                        }
                    });
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154171);
                }
            });
            ((Button) this.SFW.findViewById(R.id.ahm)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass19 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154172);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    d.dc(d.this.SzQ, d.this.SFQ);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154172);
                }
            });
            ((Button) this.SFW.findViewById(R.id.agw)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass20 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154173);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    g brX = com.tencent.xweb.xwalk.a.h.brX(d.this.SFQ);
                    if (brX == null) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(154173);
                        return;
                    }
                    int hvk = brX.hvk();
                    if (hvk < 0) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(154173);
                        return;
                    }
                    String atd = brX.atd(hvk);
                    brX.atc(-1);
                    if (atd != null && !atd.isEmpty()) {
                        com.tencent.xweb.util.c.bsB(atd);
                    }
                    Toast.makeText(d.this.SzQ, "清理完成", 0).show();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154173);
                }
            });
            CheckBox checkBox2 = (CheckBox) this.SFW.findViewById(R.id.b0w);
            checkBox2.setChecked(y.hsF().hsG());
            checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass21 */

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    SharedPreferences.Editor edit;
                    int hvk;
                    AppMethodBeat.i(154174);
                    SharedPreferences sharedPreferences = y.hsF().SzQ.getSharedPreferences("wcwebview", 4);
                    if (!(sharedPreferences == null || (edit = sharedPreferences.edit()) == null)) {
                        edit.putBoolean("fr_disable_cache", z);
                        edit.commit();
                        if (z) {
                            for (g gVar : com.tencent.xweb.xwalk.a.h.hvo()) {
                                if ((gVar instanceof m) && (hvk = gVar.hvk()) >= 0) {
                                    String ate = gVar.ate(hvk);
                                    if (!ate.isEmpty()) {
                                        com.tencent.xweb.util.c.bsB(ate);
                                    }
                                }
                            }
                        }
                    }
                    AppMethodBeat.o(154174);
                }
            });
            CheckBox checkBox3 = (CheckBox) this.SFW.findViewById(R.id.b0x);
            checkBox3.setChecked(y.hsF().hsH());
            checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass22 */

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    SharedPreferences.Editor edit;
                    AppMethodBeat.i(154175);
                    SharedPreferences sharedPreferences = y.hsF().SzQ.getSharedPreferences("wcwebview", 4);
                    if (!(sharedPreferences == null || (edit = sharedPreferences.edit()) == null)) {
                        edit.putBoolean("fr_disable_crash_detect", z);
                        edit.commit();
                    }
                    AppMethodBeat.o(154175);
                }
            });
            ((TextView) this.SFW.findViewById(R.id.ik_)).setText(huR());
            final EditText editText2 = (EditText) this.SFW.findViewById(R.id.bw4);
            ((Button) this.SFW.findViewById(R.id.ah2)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass24 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154177);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    d.a(d.this, editText2.getText().toString(), f.a.XWEB);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154177);
                }
            });
            ((Button) this.SFW.findViewById(R.id.ah1)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass25 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154178);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    d.a(d.this, editText2.getText().toString(), f.a.X5);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154178);
                }
            });
            ((Button) this.SFW.findViewById(R.id.ah0)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass26 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154179);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    d.a(d.this, editText2.getText().toString(), f.a.NONE);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154179);
                }
            });
            final EditText editText3 = (EditText) this.SFW.findViewById(R.id.bw7);
            ((Button) this.SFW.findViewById(R.id.ahp)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass27 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154180);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    d.a(d.this, editText3.getText().toString(), f.c.yes);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154180);
                }
            });
            ((Button) this.SFW.findViewById(R.id.ahn)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass28 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154181);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    d.a(d.this, editText3.getText().toString(), f.c.no);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154181);
                }
            });
            ((Button) this.SFW.findViewById(R.id.aho)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass29 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154182);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    d.a(d.this, editText3.getText().toString(), f.c.none);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154182);
                }
            });
            ((TextView) this.SFW.findViewById(R.id.izc)).setText(Er(true) + "\n" + XWalkInitializer.getXWalkInitializeLog());
            ((LinearLayout) this.SFW.findViewById(R.id.b_1)).setVisibility(8);
            ((Button) this.SFW.findViewById(R.id.agt)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass30 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154183);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    XWalkEnvironment.setGrayValueForTest(1);
                    if (XWalkEnvironment.hasAvailableVersion()) {
                        y.hsF().a("tools", WebView.c.WV_KIND_CW);
                        y.hsF().a("toolsmp", WebView.c.WV_KIND_CW);
                        y.hsF().a("appbrand", WebView.c.WV_KIND_CW);
                        y.hsF().a("support", WebView.c.WV_KIND_CW);
                        y.hsF().a("mm", WebView.c.WV_KIND_CW);
                        d.this.dR("已使用XWeb，点任意位置重启进程生效\n", true);
                    } else if (XWalkEnvironment.isIaDevice()) {
                        d.this.bsn("http://debugxweb.qq.com/?set_web_config=WV_KIND_CW&set_appbrand_config=WV_KIND_CW&set_config_url=https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86_test.xml&check_xwalk_update");
                    } else {
                        d.this.bsn("http://debugxweb.qq.com/?set_web_config=WV_KIND_CW&set_appbrand_config=WV_KIND_CW&set_config_url=https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml&check_xwalk_update");
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154183);
                }
            });
            ((Button) this.SFW.findViewById(R.id.ags)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass31 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154184);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    y.hsF().a("tools", WebView.c.WV_KIND_X5);
                    y.hsF().a("toolsmp", WebView.c.WV_KIND_X5);
                    y.hsF().a("appbrand", WebView.c.WV_KIND_X5);
                    y.hsF().a("support", WebView.c.WV_KIND_X5);
                    y.hsF().a("mm", WebView.c.WV_KIND_X5);
                    if (WebView.getInstalledTbsCoreVersion(d.this.SzQ) <= 0) {
                        d.this.dQ("已切换x5，但是x5未ready，点任意位置重启进程生效\n", true);
                    } else {
                        d.this.dR("已使用x5，点任意位置重启进程生效\n", true);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154184);
                }
            });
            ((Button) this.SFW.findViewById(R.id.agr)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass32 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154185);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    y.hsF().a("tools", WebView.c.WV_KIND_SYS);
                    y.hsF().a("toolsmp", WebView.c.WV_KIND_SYS);
                    y.hsF().a("appbrand", WebView.c.WV_KIND_SYS);
                    y.hsF().a("support", WebView.c.WV_KIND_SYS);
                    y.hsF().a("mm", WebView.c.WV_KIND_SYS);
                    d.this.dR("已使用system，点任意位置重启进程生效\n", true);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$38", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154185);
                }
            });
            ((Button) this.SFW.findViewById(R.id.agq)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass33 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154186);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    XWalkEnvironment.setGrayValueForTest(0);
                    XWalkEnvironment.setTestDownLoadUrl(d.this.SzQ, "");
                    y.hsF().a("tools", WebView.c.WV_KIND_NONE);
                    y.hsF().a("toolsmp", WebView.c.WV_KIND_NONE);
                    y.hsF().a("appbrand", WebView.c.WV_KIND_NONE);
                    y.hsF().a("support", WebView.c.WV_KIND_NONE);
                    y.hsF().a("mm", WebView.c.WV_KIND_NONE);
                    d.this.dR("已使用AUTO，点任意位置重启进程生效\n", true);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$39", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154186);
                }
            });
            ((Button) this.SFW.findViewById(R.id.agn)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass35 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154188);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    LinearLayout linearLayout = (LinearLayout) d.this.SFW.findViewById(R.id.b_1);
                    if (linearLayout.getVisibility() == 8) {
                        linearLayout.setVisibility(0);
                        ((Button) view).setText("隐藏高级设置");
                    } else {
                        linearLayout.setVisibility(8);
                        ((Button) view).setText("高级设置");
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$40", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154188);
                }
            });
            ((Button) this.SFW.findViewById(R.id.ahi)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass36 */

                public final void onClick(View view) {
                    AppMethodBeat.i(207250);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    boolean z = !y.hsF().SzV;
                    y.hsF().Ei(z);
                    if (z) {
                        d.this.huM();
                        d.this.SFV.setVisibility(0);
                    } else if (d.this.SFV != null) {
                        d.this.SFV.setVisibility(8);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(207250);
                }
            });
            Button button6 = (Button) this.SFW.findViewById(R.id.ah9);
            button6.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass37 */

                public final void onClick(View view) {
                    AppMethodBeat.i(154194);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    d dVar = d.this;
                    com.tencent.xweb.b.h hVar = new com.tencent.xweb.b.h(Environment.getExternalStorageDirectory());
                    hVar.htu();
                    String str = hVar.getPath() + "/xweb_dump";
                    try {
                        com.tencent.xweb.b.h[] htu = new com.tencent.xweb.b.h(str).htu();
                        if (htu.length != 0) {
                            int i2 = 0;
                            while (true) {
                                if (i2 >= htu.length) {
                                    dVar.dQ("web_dump目录下没有.zip文件", true);
                                    break;
                                } else if (htu[i2].getName().endsWith(".zip")) {
                                    new AlertDialog.Builder(dVar.SzQ).setTitle("提示").setMessage("确定加载:" + htu[i2].getName() + "?").setPositiveButton("确定", new DialogInterface.OnClickListener(str, htu[i2].getAbsolutePath()) {
                                        /* class com.tencent.xweb.xwalk.d.AnonymousClass47 */
                                        final /* synthetic */ String SGF;
                                        final /* synthetic */ String SGI;

                                        {
                                            this.SGI = r2;
                                            this.SGF = r3;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(207269);
                                            d dVar = d.this;
                                            String str = this.SGI;
                                            String str2 = this.SGF;
                                            u.cg(str, str2);
                                            String[] split = str2.split("\\.");
                                            if (split.length == 2) {
                                                dVar.SFP.loadUrl("file://" + split[0] + "/main.html");
                                            }
                                            dVar.SFW.setVisibility(8);
                                            AppMethodBeat.o(207269);
                                        }
                                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                        /* class com.tencent.xweb.xwalk.d.AnonymousClass46 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                        }
                                    }).show();
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                        } else {
                            dVar.dQ("web_dump目录下没有.zip文件,请确认应用权限，在权限管理打开应用的读写存储权限", true);
                        }
                    } catch (Exception e2) {
                        dVar.dQ("没有找到web_dump目录,请确认应用权限，在权限管理打开应用的读写存储权限", true);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(154194);
                }
            });
            ((Button) this.SFW.findViewById(R.id.ahj)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass38 */

                public final void onClick(View view) {
                    AppMethodBeat.i(207251);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    boolean z = !y.hsF().SAb;
                    y.hsF().setShowFps(z);
                    d.b(d.this.SFP);
                    d.this.dR(z ? "打开显示fps" : "关闭显示fps", false);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(207251);
                }
            });
            button6.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.tencent.xweb.xwalk.d.AnonymousClass39 */

                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(207253);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/xwalk/WebDebugPage$44", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    new AlertDialog.Builder(d.this.SzQ).setTitle("提示").setMessage("清空保存页面文件").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        /* class com.tencent.xweb.xwalk.d.AnonymousClass39.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(207252);
                            d.b(d.this, Environment.getExternalStorageDirectory() + "/xweb_dump");
                            AppMethodBeat.o(207252);
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        /* class com.tencent.xweb.xwalk.d.AnonymousClass39.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(154200);
                            AppMethodBeat.o(154200);
                        }
                    }).show();
                    com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/xweb/xwalk/WebDebugPage$44", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(207253);
                    return false;
                }
            });
            ((Button) this.SFW.findViewById(R.id.ahb)).setOnClickListener(this.SGd);
            AppMethodBeat.o(154235);
        }
        return true;
    }

    private static int mP(int i2, int i3) {
        if (i2 == 0) {
            return 3;
        }
        if (i2 == 2) {
            if (i3 == 2) {
                return 1;
            }
            if (i3 == 1) {
                return 2;
            }
            if (i3 != 0) {
                return 4;
            }
            return 1;
        }
        return 4;
    }

    /* access modifiers changed from: package-private */
    public final void f(Button button) {
        AppMethodBeat.i(154236);
        int forceDarkMode = this.SFP.getSettings().getForceDarkMode();
        int forceDarkBehavior = this.SFP.getSettings().getForceDarkBehavior();
        int mP = mP(forceDarkMode, forceDarkBehavior);
        if (mP == 1) {
            button.setText(String.format("当前Dark Mode强制智能反色[%d,%d]（点击切换）", Integer.valueOf(forceDarkMode), Integer.valueOf(forceDarkBehavior)));
            AppMethodBeat.o(154236);
        } else if (mP == 2) {
            button.setText(String.format("当前Dark Mode不强制智能反色[%d,%d]（点击切换）", Integer.valueOf(forceDarkMode), Integer.valueOf(forceDarkBehavior)));
            AppMethodBeat.o(154236);
        } else if (mP == 3) {
            button.setText(String.format("当前Light Mode[%d,%d]（点击切换）", Integer.valueOf(forceDarkMode), Integer.valueOf(forceDarkBehavior)));
            AppMethodBeat.o(154236);
        } else {
            if (mP == 4) {
                button.setText(String.format("当前未知Mode[%d,%d]（点击切换）", Integer.valueOf(forceDarkMode), Integer.valueOf(forceDarkBehavior)));
            }
            AppMethodBeat.o(154236);
        }
    }

    private static String huR() {
        AppMethodBeat.i(154237);
        StringBuilder sb = new StringBuilder();
        String[] strArr = f.SyR;
        for (String str : strArr) {
            sb.append("\n ").append(str).append(": force-").append(y.hsF().bsl(str)).append("  cmd-tools-").append(com.tencent.xweb.b.nW(str, "tools")).append("  cmd-appbrand-").append(com.tencent.xweb.b.nW(str, "appbrand"));
        }
        sb.append("\n\n use office reader:");
        String[] strArr2 = f.SyR;
        for (String str2 : strArr2) {
            if (!"pdf".equals(str2)) {
                sb.append("\n ").append(str2).append(": force-").append(y.hsF().bsm(str2)).append("  cmd-tools-").append(com.tencent.xweb.b.nV(str2, "tools")).append("  cmd-appbrand-").append(com.tencent.xweb.b.nV(str2, "appbrand")).append("  cmd-mm-").append(com.tencent.xweb.b.nV(str2, "mm"));
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(154237);
        return sb2;
    }

    /* access modifiers changed from: package-private */
    public final void huS() {
        AppMethodBeat.i(207283);
        for (g gVar : com.tencent.xweb.xwalk.a.h.hvo()) {
            gVar.atc(-1);
        }
        String pluginBaseDir = XWalkEnvironment.getPluginBaseDir();
        if (pluginBaseDir.isEmpty()) {
            AppMethodBeat.o(207283);
            return;
        }
        com.tencent.xweb.util.c.bsB(pluginBaseDir);
        dQ("所有插件清理完成", true);
        AppMethodBeat.o(207283);
    }

    public static void lF(Context context) {
        AppMethodBeat.i(154238);
        Scheduler.SIT = true;
        k kVar = new k();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("UpdaterCheckType", "1");
        kVar.b(context, hashMap);
        AppMethodBeat.o(154238);
    }

    public static void dc(final Context context, final String str) {
        AppMethodBeat.i(207284);
        final k kVar = new k();
        kVar.a(str, new j() {
            /* class com.tencent.xweb.xwalk.d.AnonymousClass41 */
            ProgressDialog SGr = null;
            final /* synthetic */ boolean SGu = false;
            final /* synthetic */ f.a SGv = null;
            final /* synthetic */ ValueCallback lVB = null;
            boolean mFinished = false;

            @Override // com.tencent.xweb.xwalk.a.j
            public final void hst() {
                AppMethodBeat.i(207260);
                this.SGr = new ProgressDialog(context);
                this.SGr.setProgressStyle(1);
                this.SGr.setMessage(str + " 下载更新中");
                this.SGr.setCancelable(false);
                this.SGr.setCanceledOnTouchOutside(false);
                this.SGr.setButton(-2, "取消", new DialogInterface.OnClickListener() {
                    /* class com.tencent.xweb.xwalk.d.AnonymousClass41.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(207258);
                        if (!AnonymousClass41.this.mFinished) {
                            kVar.hsE();
                        }
                        AppMethodBeat.o(207258);
                    }
                });
                this.SGr.setButton(-1, "完成", new DialogInterface.OnClickListener() {
                    /* class com.tencent.xweb.xwalk.d.AnonymousClass41.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(207259);
                        AnonymousClass41.this.SGr.dismiss();
                        AppMethodBeat.o(207259);
                    }
                });
                this.SGr.show();
                this.SGr.getButton(-1).setVisibility(8);
                AppMethodBeat.o(207260);
            }

            @Override // com.tencent.xweb.xwalk.a.j
            public final void asQ(int i2) {
                AppMethodBeat.i(207261);
                if (this.mFinished || this.SGr == null) {
                    AppMethodBeat.o(207261);
                    return;
                }
                this.SGr.setProgress(i2);
                AppMethodBeat.o(207261);
            }

            @Override // com.tencent.xweb.xwalk.a.j
            public final void asR(int i2) {
                String[] strArr;
                AppMethodBeat.i(207262);
                this.mFinished = true;
                if (this.SGr == null) {
                    AppMethodBeat.o(207262);
                    return;
                }
                g brX = com.tencent.xweb.xwalk.a.h.brX(str);
                int hvk = brX != null ? brX.hvk() : -1;
                switch (i2) {
                    case -9:
                        this.SGr.setMessage(str + " 更新失败，下载安装出错，ErrCode = " + i2);
                        break;
                    case -8:
                        this.SGr.setMessage(str + " 更新失败，未找到可用更新，当前已安装版本" + hvk + "，ErrCode = " + i2);
                        if (this.SGu) {
                            this.SGr.dismiss();
                            break;
                        }
                        break;
                    case -7:
                        this.SGr.setMessage(str + " 更新失败，配置中未包含插件信息，ErrCode = " + i2);
                        break;
                    case -6:
                        this.SGr.setMessage(str + " 更新失败，配置解析失败，ErrCode = " + i2);
                        break;
                    case -5:
                        this.SGr.setMessage(str + " 更新失败，配置下载失败，ErrCode = " + i2);
                        break;
                    case -4:
                        this.SGr.setMessage(str + " 更新失败，其它任务正在更新插件，ErrCode = " + i2);
                        break;
                    case -3:
                        this.SGr.setMessage(str + " 更新失败，未到检查时间，ErrCode = " + i2);
                        break;
                    case -2:
                        this.SGr.setMessage(str + " 更新失败，无网络，ErrCode = " + i2);
                        break;
                    case -1:
                        this.SGr.setMessage(str + " 更新被取消，ErrCode = " + i2);
                        break;
                    case 0:
                        this.SGr.setMessage(str + " 更新完成，已安装版本" + hvk);
                        this.SGr.setProgress(100);
                        this.SGr.getButton(-2).setVisibility(8);
                        this.SGr.getButton(-1).setVisibility(0);
                        if (this.SGu) {
                            this.SGr.dismiss();
                            break;
                        }
                        break;
                    default:
                        this.SGr.setMessage(str + " 更新失败，未知错误，ErrCode = " + i2);
                        break;
                }
                if (!(this.SGv == null || y.hsF() == null)) {
                    if (XWalkEnvironment.XWALK_PLUGIN_NAME_PPT.equals(str)) {
                        strArr = new String[]{"ppt", "pptx"};
                    } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_PDF.equals(str)) {
                        strArr = new String[]{"pdf"};
                    } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_WORD.equals(str)) {
                        strArr = new String[]{"doc", "docx"};
                    } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_EXCEL.equals(str)) {
                        strArr = new String[]{"xls", "xlsx"};
                    } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_OFFICE.equals(str)) {
                        strArr = new String[]{"doc", "docx", "xls", "xlsx", "ppt", "pptx"};
                    } else {
                        AppMethodBeat.o(207262);
                        return;
                    }
                    String a2 = y.hsF().a(strArr, this.SGv);
                    e.ah(strArr);
                    Toast.makeText(context, "格式:" + a2 + "强制使用" + this.SGv.name() + "打开", 0).show();
                }
                if (this.lVB != null) {
                    this.lVB.onReceiveValue(Integer.valueOf(i2));
                }
                AppMethodBeat.o(207262);
            }
        });
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("UpdaterCheckType", "1");
        kVar.b(context, hashMap);
        AppMethodBeat.o(207284);
    }

    private void agw(String str) {
        String[] list;
        AppMethodBeat.i(154240);
        com.tencent.xweb.b.h hVar = new com.tencent.xweb.b.h(str);
        if (hVar.isDirectory() && (list = hVar.list()) != null) {
            for (int i2 = 0; i2 < list.length; i2++) {
                agw(str + "//" + list[i2]);
            }
        }
        hVar.delete();
        AppMethodBeat.o(154240);
    }

    /* access modifiers changed from: package-private */
    public final void huT() {
        AppMethodBeat.i(154241);
        Scheduler.SIT = true;
        Scheduler.hvD();
        new c(this.SzQ).C(null);
        AppMethodBeat.o(154241);
    }

    /* access modifiers changed from: package-private */
    public class c extends p {
        public c(Context context) {
            super(context);
            AppMethodBeat.i(207282);
            new a(d.this.SzQ);
            AppMethodBeat.o(207282);
        }
    }

    protected static void iH(Context context) {
        AppMethodBeat.i(154243);
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.uid == myUid && runningAppProcessInfo.pid != myPid) {
                String str = runningAppProcessInfo.processName;
                if (str == null || !str.contains("com.tencent.mm") || runningAppProcessInfo.processName.contains("tools") || runningAppProcessInfo.processName.contains("appbrand") || runningAppProcessInfo.processName.contains("support") || runningAppProcessInfo.processName.contains("sandbox")) {
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(runningAppProcessInfo.pid, new com.tencent.mm.hellhoundlib.b.a());
                    Object obj = new Object();
                    com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/xweb/xwalk/WebDebugPage", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                    Process.killProcess(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/xweb/xwalk/WebDebugPage", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
                }
            }
        }
        com.tencent.mm.hellhoundlib.b.a a3 = com.tencent.mm.hellhoundlib.b.c.a(myPid, new com.tencent.mm.hellhoundlib.b.a());
        Object obj2 = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(obj2, a3.axQ(), "com/tencent/xweb/xwalk/WebDebugPage", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer) a3.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(obj2, "com/tencent/xweb/xwalk/WebDebugPage", "killAllProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        AppMethodBeat.o(154243);
    }

    public final void a(boolean z, Button button, boolean z2) {
        AppMethodBeat.i(154244);
        try {
            XWalkPreferences.setValue(XWalkPreferences.REMOTE_DEBUGGING, z);
        } catch (Exception e2) {
        }
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                android.webkit.WebView.setWebContentsDebuggingEnabled(z);
            }
        } catch (Exception e3) {
        }
        try {
            com.tencent.xweb.x5.sdk.d.setWebContentsDebuggingEnabled(z);
        } catch (Exception e4) {
        }
        if (z2 && this.SFP.getX5WebViewExtension() != null) {
            if (z) {
                this.SFP.loadUrl("http://debugx5.qq.com/?inspector=true");
            } else {
                this.SFP.loadUrl("http://debugx5.qq.com/?inspector=false");
            }
        }
        if (button != null) {
            if (z) {
                button.setText("关闭远程调试模式(当前已打开)");
                AppMethodBeat.o(154244);
                return;
            }
            button.setText("打开远程调试模式(当前已关闭)");
        }
        AppMethodBeat.o(154244);
    }

    /* access modifiers changed from: package-private */
    public final void Es(final boolean z) {
        AppMethodBeat.i(154246);
        com.tencent.xweb.b.h hVar = new com.tencent.xweb.b.h(Environment.getExternalStorageDirectory());
        hVar.htu();
        try {
            com.tencent.xweb.b.h[] htu = new com.tencent.xweb.b.h(hVar.getPath() + "/apkxwebtest").htu();
            if (htu.length == 0) {
                dQ("apkxwebtest目录下没有.zip文件,请确认应用权限，在权限管理打开应用的读写存储权限", true);
                AppMethodBeat.o(154246);
                return;
            }
            for (int i2 = 0; i2 < htu.length; i2++) {
                if (htu[i2].getName().endsWith(".zip")) {
                    final String absolutePath = htu[i2].getAbsolutePath();
                    final String name = htu[i2].getName();
                    if (z) {
                        new AlertDialog.Builder(this.SzQ).setTitle("提示").setMessage("确定加载:" + name + "?").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            /* class com.tencent.xweb.xwalk.d.AnonymousClass44 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(207268);
                                d.this.G(absolutePath, name, z);
                                AppMethodBeat.o(207268);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            /* class com.tencent.xweb.xwalk.d.AnonymousClass43 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(154206);
                                AppMethodBeat.o(154206);
                            }
                        }).show();
                        AppMethodBeat.o(154246);
                        return;
                    }
                    G(absolutePath, name, z);
                    AppMethodBeat.o(154246);
                    return;
                }
            }
            dQ("apkxwebtest目录下没有.zip文件", true);
            AppMethodBeat.o(154246);
        } catch (Exception e2) {
            dQ("没有找到apkxwebtest目录,请确认应用权限，在权限管理打开应用的读写存储权限", true);
            AppMethodBeat.o(154246);
        }
    }

    /* access modifiers changed from: package-private */
    public static class b extends XWalkUpdater.UpdateConfig {
        String SGO;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public b(java.lang.String r5, java.lang.String r6) {
            /*
                r4 = this;
                r0 = 100000000(0x5f5e100, float:2.3122341E-35)
                r3 = 154216(0x25a68, float:2.16103E-40)
                r2 = 0
                int r1 = org.xwalk.core.XWalkEnvironment.getAvailableVersion()
                if (r1 < r0) goto L_0x000f
                int r0 = r1 + 1
            L_0x000f:
                r4.<init>(r0)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                r4.SGO = r5
                r4.isMatchMd5 = r2
                r4.isPatchUpdate = r2
                java.lang.String r0 = "local:"
                java.lang.String r1 = java.lang.String.valueOf(r6)
                java.lang.String r0 = r0.concat(r1)
                r4.versionDetail = r0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.xwalk.d.b.<init>(java.lang.String, java.lang.String):void");
        }

        @Override // org.xwalk.core.XWalkUpdater.UpdateConfig
        public final boolean checkValid() {
            return true;
        }

        private b(int i2) {
            super(null, false, i2, XWalkEnvironment.getRuntimeAbi(), 0);
            AppMethodBeat.i(154217);
            AppMethodBeat.o(154217);
        }
    }

    /* access modifiers changed from: package-private */
    public final void G(String str, String str2, boolean z) {
        AppMethodBeat.i(154247);
        b bVar = new b(str, str2);
        try {
            com.tencent.xweb.b.h hVar = new com.tencent.xweb.b.h(XWalkEnvironment.getDownloadZipDir(bVar.apkVer));
            if (hVar.exists()) {
                hVar.delete();
            }
            InputStream openRead = com.tencent.xweb.b.i.openRead(str);
            OutputStream LM = com.tencent.xweb.b.i.LM(hVar.getAbsolutePath());
            byte[] bArr = new byte[1048576];
            while (true) {
                int read = openRead.read(bArr);
                if (read == -1) {
                    break;
                }
                LM.write(bArr, 0, read);
            }
            LM.flush();
            openRead.close();
            LM.close();
        } catch (IOException e2) {
        }
        try {
            Integer onHandleFile = XWalkUpdater.onHandleFile(bVar);
            if (onHandleFile.intValue() == 0) {
                dQ("安装" + str2 + "成功", z);
                AppMethodBeat.o(154247);
                return;
            }
            dQ("安装" + str2 + "失败,错误码=" + onHandleFile, true);
            AppMethodBeat.o(154247);
        } catch (Exception e3) {
            dQ("安装失败", true);
            Log.e("WebDebugPage", "install local apk failed : " + e3.getMessage());
            AppMethodBeat.o(154247);
        }
    }

    /* access modifiers changed from: package-private */
    public final void dQ(String str, boolean z) {
        AppMethodBeat.i(154248);
        if (z) {
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(this.SzQ);
                builder.setMessage(str);
                builder.create().show();
                AppMethodBeat.o(154248);
            } catch (Exception e2) {
                Log.i("WebDebugPage", "show alert failed may be in abtets exe " + e2.getMessage());
                AppMethodBeat.o(154248);
            }
        } else {
            Log.e("WebDebugPage", str);
            AppMethodBeat.o(154248);
        }
    }

    /* access modifiers changed from: package-private */
    public final void dR(String str, boolean z) {
        AppMethodBeat.i(154249);
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.SzQ);
            builder.setMessage(str);
            builder.create();
            builder.setCancelable(true);
            if (z) {
                builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    /* class com.tencent.xweb.xwalk.d.AnonymousClass48 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(207270);
                        d.this.bCn();
                        AppMethodBeat.o(207270);
                    }
                });
            }
            builder.show();
            AppMethodBeat.o(154249);
        } catch (Exception e2) {
            Log.i("WebDebugPage", "show alert failed may be in abtets exe " + e2.getMessage());
            AppMethodBeat.o(154249);
        }
    }

    public static synchronized void a(IWebView iWebView) {
        synchronized (d.class) {
            AppMethodBeat.i(154250);
            if (iWebView == null || !y.hsF().SAb) {
                AppMethodBeat.o(154250);
            } else {
                b(iWebView);
                AppMethodBeat.o(154250);
            }
        }
    }

    public static synchronized void b(IWebView iWebView) {
        synchronized (d.class) {
            AppMethodBeat.i(154251);
            if (iWebView == null || !y.hsF().SAb) {
                AppMethodBeat.o(154251);
            } else {
                iWebView.evaluateJavascript("if (!window.showFPS) {\n    window.showFPS = (function () {\n        var requestAnimationFrame =\n            window.requestAnimationFrame || //Chromium  \n            window.webkitRequestAnimationFrame || //Webkit \n            window.mozRequestAnimationFrame || //Mozilla Geko \n            window.oRequestAnimationFrame || //Opera Presto \n            window.msRequestAnimationFrame || //IE Trident? \n            function (callback) { //Fallback function \n                window.setTimeout(callback, 1000 / 60);\n            };\n        var e, pe, pid, fps, last, offset, step, appendFps, curSeconds;\n        fps = 0;\n        curSeconds = 0;\n        last = Date.now();\n        step = function () {\n            offset = Date.now() - last;\n            fps += 1;\n            if (offset >= 1000) {\n                last += offset;\n                if (curSeconds % 3 == 0) {\n                    addFpsElement();\n                }\n                ++curSeconds;\n                appendFps(fps);\n                fps = 0;\n            }\n            requestAnimationFrame(step);\n        };\n\n        addFpsElement = function () {\n                var fpsview = document.getElementById(\"fpsview\");\n                if (!fpsview) {\n                    var div = document.createElement('div');\n                    div.innerHTML = \"<div style=\\\"z-index: 9999; position: fixed ! important; right: 50px; top: 10px; font-size:36px\\\" id=\\\"fpsview\\\"> </div>\";\n                    document.body.appendChild(div);\n                }\n            }\n            //显示fps;\n        appendFps = function (fps) {\n            if (!e) e = document.createElement('span');\n            e.innerHTML = \"fps: \" + fps;\n            if (!pe) {\n                pe = document.getElementById(\"fpsview\");\n                if (pe) pe.appendChild(e);\n            }\n        };\n        return {\n            go: function () {\n                step();\n            }\n        }\n    })();\n\n    console.log(\"show fps start\");\n    window.showFPS.go();\n\n}", new ValueCallback<String>() {
                    /* class com.tencent.xweb.xwalk.d.AnonymousClass50 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.webkit.ValueCallback
                    public final /* synthetic */ void onReceiveValue(String str) {
                        AppMethodBeat.i(207272);
                        Log.i("WebDebugPage", "show fps js done");
                        AppMethodBeat.o(207272);
                    }
                });
                AppMethodBeat.o(154251);
            }
        }
    }

    public static boolean bsN(String str) {
        boolean z = false;
        AppMethodBeat.i(154252);
        if (str == null) {
            AppMethodBeat.o(154252);
        } else {
            if (str.contains("debugxweb.qq.com") || str.contains("debugmm.qq.com") || str.contains("public.debugxweb.qq.com")) {
                z = true;
            }
            if (z) {
                com.tencent.xweb.util.h.OQ(223);
                Log.e("WebDebugPage", "this url contians debug piece, url =  ".concat(String.valueOf(str)));
            }
            AppMethodBeat.o(154252);
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public static class a implements s.a {
        boolean SGM = false;
        private ProgressDialog SGr;
        Context mContext;

        public a(Context context) {
            AppMethodBeat.i(207275);
            this.mContext = context;
            s.a(this);
            bsO("正在监听更新,点空白区域取消");
            AppMethodBeat.o(207275);
        }

        @Override // com.tencent.xweb.s.a
        public final void cdG() {
            AppMethodBeat.i(207276);
            bsO("开始更新");
            AppMethodBeat.o(207276);
        }

        @Override // com.tencent.xweb.s.a
        public final void AN(int i2) {
            AppMethodBeat.i(207277);
            if (i2 == 0) {
                try {
                    bsO("更新完成，点任意位置重启进程生效");
                    this.SGM = true;
                    this.SGr.setCancelable(true);
                    this.SGr.setCanceledOnTouchOutside(true);
                    this.SGr.setProgress(100);
                    AppMethodBeat.o(207277);
                } catch (Exception e2) {
                    Log.i("WebDebugPage", "may run in background failed to load alert:" + e2.getMessage());
                    AppMethodBeat.o(207277);
                }
            } else if (i2 == -5) {
                bsO("暂无需要立即更新的版本");
                this.SGr.setCancelable(true);
                this.SGr.setCanceledOnTouchOutside(true);
                AppMethodBeat.o(207277);
            } else {
                this.SGr.setCancelable(true);
                this.SGr.setCanceledOnTouchOutside(true);
                bsO("更新失败, error code = :".concat(String.valueOf(i2)));
                AppMethodBeat.o(207277);
            }
        }

        @Override // com.tencent.xweb.s.a
        public final void AO(int i2) {
            AppMethodBeat.i(207278);
            try {
                bsO("正在下载内核");
                if (this.SGr != null) {
                    this.SGr.setCancelable(false);
                    this.SGr.setProgress(i2);
                }
                AppMethodBeat.o(207278);
            } catch (Exception e2) {
                Log.i("WebDebugPage", "may run in background failed to load alert:" + e2.getMessage());
                AppMethodBeat.o(207278);
            }
        }

        @Override // com.tencent.xweb.s.a
        public final void cdH() {
            AppMethodBeat.i(207279);
            bsO("主配置更新完成");
            AppMethodBeat.o(207279);
        }

        @Override // com.tencent.xweb.s.a
        public final void cdI() {
            AppMethodBeat.i(207280);
            bsO("插件配置更新完成");
            AppMethodBeat.o(207280);
        }

        private void bsO(String str) {
            AppMethodBeat.i(207281);
            if (this.SGr == null) {
                this.SGr = new ProgressDialog(this.mContext);
                this.SGr.setProgressStyle(1);
                this.SGr.setMessage(str);
                this.SGr.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    /* class com.tencent.xweb.xwalk.d.a.AnonymousClass1 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(207274);
                        s.b(a.this);
                        if (a.this.SGM) {
                            d.iH(a.this.mContext);
                        }
                        AppMethodBeat.o(207274);
                    }
                });
                this.SGr.setCancelable(true);
                this.SGr.show();
            }
            this.SGr.setMessage(str);
            AppMethodBeat.o(207281);
        }
    }

    /* access modifiers changed from: package-private */
    public final void bCn() {
        AppMethodBeat.i(154242);
        iH(this.SzQ);
        AppMethodBeat.o(154242);
    }

    public static void a(final Context context, String str, boolean z, final ValueCallback<Boolean> valueCallback) {
        final String str2;
        AppMethodBeat.i(154245);
        com.tencent.xweb.b.h hVar = new com.tencent.xweb.b.h(Environment.getExternalStorageDirectory().getPath());
        hVar.htu();
        final g brX = com.tencent.xweb.xwalk.a.h.brX(str);
        if (brX == null) {
            Toast.makeText(context, "找不到对应插件", 0).show();
            valueCallback.onReceiveValue(Boolean.FALSE);
            AppMethodBeat.o(154245);
            return;
        }
        if (XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO.equals(str)) {
            str2 = "xweb_fullscreen_video.js";
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_PPT.equals(str)) {
            str2 = "xfiles_ppt_reader.zip";
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_PDF.equals(str)) {
            if (z) {
                str2 = "xfiles_pdf_reader_arm64.zip";
            } else {
                str2 = "xfiles_pdf_reader_arm.zip";
            }
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_WORD.equals(str)) {
            if (z) {
                str2 = "xfiles_word_reader_arm64.zip";
            } else {
                str2 = "xfiles_word_reader_arm.zip";
            }
        } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_EXCEL.equals(str)) {
            str2 = "xfiles_excel_reader.zip";
        } else if (!XWalkEnvironment.XWALK_PLUGIN_NAME_OFFICE.equals(str)) {
            str2 = "";
        } else if (z) {
            str2 = "xfiles_office_reader_arm64.zip";
        } else {
            str2 = "xfiles_office_reader_arm.zip";
        }
        final String str3 = hVar.getPath() + "/apkxwebtest/" + str2;
        new AsyncTask<Void, Void, Boolean>() {
            /* class com.tencent.xweb.xwalk.d.AnonymousClass42 */
            final /* synthetic */ boolean SGC;
            final /* synthetic */ int SGy = -1;
            final /* synthetic */ boolean SGz = false;
            private ProgressDialog yuB;

            {
                this.SGC = false;
                this.yuB = null;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
            /* access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public final /* synthetic */ Boolean doInBackground(Void[] voidArr) {
                AppMethodBeat.i(207267);
                Boolean huU = huU();
                AppMethodBeat.o(207267);
                return huU;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public final /* synthetic */ void onPostExecute(Boolean bool) {
                AppMethodBeat.i(207266);
                Boolean bool2 = bool;
                if (bool2.booleanValue()) {
                    this.yuB.setMessage("安装完成");
                } else {
                    this.yuB.setMessage("安装失败，请确保文件存在: " + (this.SGz ? "asset/" : "sdcard/apkxwebtest/") + str2);
                }
                this.yuB.getButton(-1).setVisibility(0);
                if (this.SGC) {
                    this.yuB.hide();
                }
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(bool2);
                }
                AppMethodBeat.o(207266);
            }

            /* access modifiers changed from: protected */
            public final void onPreExecute() {
                AppMethodBeat.i(207264);
                this.yuB = new ProgressDialog(context);
                this.yuB.setProgressStyle(0);
                this.yuB.setMessage("安装中");
                this.yuB.setCancelable(false);
                this.yuB.setCanceledOnTouchOutside(false);
                this.yuB.setButton(-1, "完成", new DialogInterface.OnClickListener() {
                    /* class com.tencent.xweb.xwalk.d.AnonymousClass42.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(207263);
                        AnonymousClass42.this.yuB.hide();
                        AppMethodBeat.o(207263);
                    }
                });
                this.yuB.show();
                this.yuB.getButton(-1).setVisibility(8);
                AppMethodBeat.o(207264);
            }

            /* JADX WARNING: Removed duplicated region for block: B:27:0x00a8 A[SYNTHETIC, Splitter:B:27:0x00a8] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private java.lang.Boolean huU() {
                /*
                // Method dump skipped, instructions count: 183
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.xwalk.d.AnonymousClass42.huU():java.lang.Boolean");
            }
        }.execute(new Void[0]);
        AppMethodBeat.o(154245);
    }

    static /* synthetic */ void a(d dVar, String str) {
        String[] strArr;
        AppMethodBeat.i(207285);
        if (y.hsF() != null) {
            if (XWalkEnvironment.XWALK_PLUGIN_NAME_PPT.equals(str)) {
                strArr = new String[]{"ppt", "pptx"};
            } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_PDF.equals(str)) {
                strArr = new String[]{"pdf"};
            } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_WORD.equals(str)) {
                strArr = new String[]{"doc", "docx"};
            } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_EXCEL.equals(str)) {
                strArr = new String[]{"xls", "xlsx"};
            } else if (XWalkEnvironment.XWALK_PLUGIN_NAME_OFFICE.equals(str)) {
                strArr = new String[]{"doc", "docx", "xls", "xlsx", "ppt", "pptx"};
            } else {
                AppMethodBeat.o(207285);
                return;
            }
            String a2 = y.hsF().a(strArr, f.a.XWEB);
            e.ah(strArr);
            if (!(dVar.SFW == null || dVar.SzQ == null || a2.isEmpty())) {
                Toast.makeText(dVar.SzQ, "格式:" + a2 + "强制使用" + f.a.XWEB.name() + "打开", 0).show();
                TextView textView = (TextView) dVar.SFW.findViewById(R.id.ik_);
                if (textView != null) {
                    textView.setText(huR());
                }
            }
        }
        AppMethodBeat.o(207285);
    }

    static /* synthetic */ void a(d dVar, String str, f.a aVar) {
        AppMethodBeat.i(207286);
        if (y.hsF() != null) {
            String[] strArr = (str == null || str.isEmpty()) ? f.SyR : new String[]{str};
            String a2 = y.hsF().a(strArr, aVar);
            e.ah(strArr);
            if (!(dVar.SFW == null || dVar.SzQ == null || a2.isEmpty())) {
                Toast.makeText(dVar.SzQ, "格式:" + a2 + "强制使用" + aVar.name() + "打开", 0).show();
                TextView textView = (TextView) dVar.SFW.findViewById(R.id.ik_);
                if (textView != null) {
                    textView.setText(huR());
                }
            }
        }
        AppMethodBeat.o(207286);
    }

    static /* synthetic */ void a(d dVar, String str, f.c cVar) {
        AppMethodBeat.i(207287);
        if (y.hsF() != null) {
            String[] strArr = (str == null || str.isEmpty()) ? new String[]{"doc", "docx", "xls", "xlsx", "ppt", "pptx"} : new String[]{str};
            String a2 = y.hsF().a(strArr, cVar);
            e.ah(strArr);
            if (!(dVar.SFW == null || dVar.SzQ == null || a2.isEmpty())) {
                Toast.makeText(dVar.SzQ, "格式:" + a2 + "强制OfficeReader状态：" + cVar.toString(), 0).show();
                TextView textView = (TextView) dVar.SFW.findViewById(R.id.ik_);
                if (textView != null) {
                    textView.setText(huR());
                }
            }
        }
        AppMethodBeat.o(207287);
    }
}
