package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.webkit.ConsoleMessage;
import android.widget.TextView;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.Scopes;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.m;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.c;
import com.tencent.xweb.d;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public class BindGoogleContactUI extends MMActivity implements i {
    private MMWebView iGY;
    private boolean ifz = false;
    private boolean jZE = false;
    String jZG;
    private ProgressDialog jZH;
    private int jZJ;
    private TextView jZO;
    private boolean jZP = false;
    private String jZQ;
    String jZR;
    String jZS;
    private x jZT;
    private boolean jZU = false;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(BindGoogleContactUI bindGoogleContactUI, int i2) {
        AppMethodBeat.i(109812);
        bindGoogleContactUI.vc(i2);
        AppMethodBeat.o(109812);
    }

    static /* synthetic */ void a(BindGoogleContactUI bindGoogleContactUI, String str, int i2) {
        AppMethodBeat.i(109811);
        bindGoogleContactUI.aD(str, i2);
        AppMethodBeat.o(109811);
    }

    static /* synthetic */ void c(BindGoogleContactUI bindGoogleContactUI) {
        AppMethodBeat.i(109809);
        bindGoogleContactUI.bnk();
        AppMethodBeat.o(109809);
    }

    static /* synthetic */ void d(BindGoogleContactUI bindGoogleContactUI) {
        AppMethodBeat.i(109813);
        bindGoogleContactUI.bni();
        AppMethodBeat.o(109813);
    }

    static /* synthetic */ void e(BindGoogleContactUI bindGoogleContactUI) {
        AppMethodBeat.i(109814);
        bindGoogleContactUI.bng();
        AppMethodBeat.o(109814);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.iz;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(109792);
        super.onCreate(bundle);
        this.jZJ = getIntent().getIntExtra("enter_scene", 0);
        this.jZU = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.jZE = m.dB(this);
        this.jZG = (String) g.aAh().azQ().get(208903, (Object) null);
        initView();
        if (this.jZE) {
            startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 1005);
            AppMethodBeat.o(109792);
            return;
        }
        updateView();
        AppMethodBeat.o(109792);
    }

    private void updateView() {
        AppMethodBeat.i(109793);
        if (this.jZE) {
            bnd();
            bnj();
            bnf();
            AppMethodBeat.o(109793);
            return;
        }
        bne();
        bng();
        AppMethodBeat.o(109793);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(109794);
        super.onResume();
        g.azz().a(487, this);
        this.jZP = ((Boolean) g.aAh().azQ().get(208905, Boolean.FALSE)).booleanValue();
        if (this.jZP) {
            bni();
            this.jZP = false;
            g.aAh().azQ().set(208905, Boolean.FALSE);
        }
        AppMethodBeat.o(109794);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(109795);
        super.onPause();
        g.azz().b(487, this);
        AppMethodBeat.o(109795);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(109796);
        setMMTitle(R.string.dtw);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(109773);
                BindGoogleContactUI.this.finish();
                AppMethodBeat.o(109773);
                return true;
            }
        });
        this.iGY = MMWebView.a.r(this, R.id.djk);
        this.jZO = (TextView) findViewById(R.id.c2g);
        AppMethodBeat.o(109796);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(109797);
        Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "requestCode:%d, resultCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 == -1) {
            switch (i2) {
                case 1003:
                    int intExtra = intent.getIntExtra("error_code", -1);
                    Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d ", Integer.valueOf(intExtra));
                    if (intExtra == 0) {
                        this.jZG = intent.getStringExtra("account");
                        if (this.ifz) {
                            bnk();
                            AppMethodBeat.o(109797);
                            return;
                        }
                        Log.d("MicroMsg.GoogleContact.BindGoogleContactUI", "startAcitivtyForGetToken");
                        Intent intent2 = new Intent("com.tencent.mm.gms.ACTION_GET_TOKEN");
                        intent2.putExtra("gmail", this.jZG);
                        intent2.putExtra("scope", "oauth2:https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds");
                        startActivityForResult(intent2, 1004);
                        AppMethodBeat.o(109797);
                        return;
                    }
                    bnk();
                    bnh();
                    AppMethodBeat.o(109797);
                    return;
                case 1004:
                    int intExtra2 = intent.getIntExtra("error_code", -1);
                    Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "errorCode:%d errorMsg:%s", Integer.valueOf(intExtra2), intent.getStringExtra("error_msg"));
                    if (intExtra2 != 0) {
                        bnk();
                        bnh();
                        break;
                    } else {
                        this.jZQ = intent.getStringExtra("token");
                        vc(x.keX);
                        AppMethodBeat.o(109797);
                        return;
                    }
                case 1005:
                    this.jZE = intent.getBooleanExtra("gpservices", false);
                    updateView();
                    AppMethodBeat.o(109797);
                    return;
            }
            AppMethodBeat.o(109797);
        } else if (i2 == 1005) {
            this.jZE = intent.getBooleanExtra("gpservices", false);
            updateView();
            AppMethodBeat.o(109797);
        } else {
            bnk();
            bnh();
            AppMethodBeat.o(109797);
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(109798);
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr[2] = str;
        Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s", objArr);
        bnk();
        if (i2 == 0 && i3 == 0) {
            if (this.jZE) {
                g.aAh().azQ().set(208903, this.jZG);
                g.aAh().azQ().set(208901, this.jZQ);
            } else {
                g.aAh().azQ().set(208903, this.jZG);
                g.aAh().azQ().set(208902, this.jZR);
                g.aAh().azQ().set(208904, this.jZS);
            }
            g.aAh().azQ().gBI();
            Intent intent = new Intent(this, GoogleFriendUI.class);
            intent.putExtra("enter_scene", this.jZJ);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindGoogleContactUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            finish();
            if (this.jZU) {
                h.INSTANCE.a(ErrorCode.ERROR_OUTOF_MEMORY, 6, 6);
            }
            AppMethodBeat.o(109798);
        } else if (i3 == x.keZ) {
            com.tencent.mm.ui.base.h.a(this, getString(R.string.du3), "", new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(109779);
                    BindGoogleContactUI.a(BindGoogleContactUI.this, x.keY);
                    AppMethodBeat.o(109779);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI.AnonymousClass7 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(109780);
                    BindGoogleContactUI.d(BindGoogleContactUI.this);
                    BindGoogleContactUI.e(BindGoogleContactUI.this);
                    AppMethodBeat.o(109780);
                }
            });
            AppMethodBeat.o(109798);
        } else {
            bnh();
            AppMethodBeat.o(109798);
        }
    }

    private void bnd() {
        AppMethodBeat.i(109799);
        this.iGY.setVisibility(8);
        AppMethodBeat.o(109799);
    }

    private void bne() {
        AppMethodBeat.i(109800);
        this.jZO.setVisibility(4);
        this.iGY.setVisibility(0);
        AppMethodBeat.o(109800);
    }

    private void bnf() {
        AppMethodBeat.i(109801);
        startActivityForResult(new Intent("com.tencent.mm.gms.ACTION_CHOOSE_ACCOUNT"), 1003);
        AppMethodBeat.o(109801);
    }

    private void bng() {
        AppMethodBeat.i(109802);
        bnj();
        this.iGY.getSettings().setJavaScriptEnabled(true);
        this.iGY.setWebViewClient(new ac() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI.AnonymousClass2 */

            @Override // com.tencent.xweb.ac
            public final void b(WebView webView, String str) {
                AppMethodBeat.i(109774);
                Log.d("MicroMsg.GoogleContact.BindGoogleContactUI", "onPageFinished URL:".concat(String.valueOf(str)));
                if (!(BindGoogleContactUI.this.iGY == null || BindGoogleContactUI.this.iGY.getVisibility() == 0)) {
                    BindGoogleContactUI.this.iGY.setVisibility(0);
                    if (BindGoogleContactUI.this.jZO != null) {
                        BindGoogleContactUI.this.jZO.setVisibility(4);
                    }
                }
                BindGoogleContactUI.c(BindGoogleContactUI.this);
                if (webView != null) {
                    String title = webView.getTitle();
                    Log.d("MicroMsg.GoogleContact.BindGoogleContactUI", "title:%s", title);
                    if (!TextUtils.isEmpty(title)) {
                        if (title.toLowerCase().contains("success")) {
                            if (BindGoogleContactUI.this.iGY != null) {
                                BindGoogleContactUI.this.iGY.setVisibility(4);
                            }
                            z.a(BindGoogleContactUI.this.iGY, "weixin://private/googlegetcode", "document.getElementById('code').value");
                            AppMethodBeat.o(109774);
                            return;
                        } else if (title.toLowerCase().contains("error")) {
                            Log.w("MicroMsg.GoogleContact.BindGoogleContactUI", "failed." + title.substring(title.indexOf("=")));
                        }
                    }
                }
                AppMethodBeat.o(109774);
            }

            @Override // com.tencent.xweb.ac
            public final boolean a(WebView webView, String str) {
                AppMethodBeat.i(109775);
                Log.d("MicroMsg.GoogleContact.BindGoogleContactUI", "shouldOverrideUrlLoading, url = %s", str);
                if (str.toLowerCase().startsWith("weixin://private/googlegetcode")) {
                    BindGoogleContactUI.a(BindGoogleContactUI.this, str);
                    AppMethodBeat.o(109775);
                    return true;
                }
                boolean a2 = super.a(webView, str);
                AppMethodBeat.o(109775);
                return a2;
            }
        });
        this.iGY.setWebChromeClient(new com.tencent.xweb.x() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI.AnonymousClass3 */

            @Override // com.tencent.xweb.x
            public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                AppMethodBeat.i(109776);
                String bfJ = z.bfJ(consoleMessage != null ? consoleMessage.message() : null);
                if (bfJ.toLowerCase().startsWith("weixin://private/googlegetcode")) {
                    BindGoogleContactUI.a(BindGoogleContactUI.this, bfJ);
                    AppMethodBeat.o(109776);
                    return true;
                }
                boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
                AppMethodBeat.o(109776);
                return onConsoleMessage;
            }
        });
        this.iGY.loadUrl(m.boj());
        AppMethodBeat.o(109802);
    }

    private void vc(int i2) {
        AppMethodBeat.i(109803);
        this.jZT = new x(x.a.MM_BIND_GCONTACT_OPCODE_BIND, this.jZG, i2);
        g.azz().a(this.jZT, 0);
        Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "doScene mAppToken:%s, mWebToke:%s", this.jZQ, this.jZR);
        AppMethodBeat.o(109803);
    }

    /* access modifiers changed from: package-private */
    public final void aD(String str, int i2) {
        AppMethodBeat.i(109804);
        this.jZG = str;
        vc(i2);
        AppMethodBeat.o(109804);
    }

    /* access modifiers changed from: package-private */
    public final void bnh() {
        String string;
        AppMethodBeat.i(109805);
        if (this.iGY != null) {
            this.iGY.setVisibility(4);
        }
        if (this.jZO != null) {
            this.jZO.setVisibility(0);
        }
        if (!NetStatusUtil.isConnected(this)) {
            string = getString(R.string.du5);
        } else {
            string = getString(R.string.dtx);
        }
        this.jZO.setText(string);
        AppMethodBeat.o(109805);
    }

    private void bni() {
        AppMethodBeat.i(109806);
        try {
            d.lA(this);
            c.hsp().removeAllCookie();
            AppMethodBeat.o(109806);
        } catch (Exception e2) {
            Log.d("Google Login", "Clear cookie failed");
            AppMethodBeat.o(109806);
        }
    }

    private void bnj() {
        AppMethodBeat.i(109807);
        if (this.jZH == null || !this.jZH.isShowing()) {
            getString(R.string.zb);
            this.jZH = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI.AnonymousClass8 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(109781);
                    BindGoogleContactUI.this.ifz = true;
                    if (BindGoogleContactUI.this.jZT != null) {
                        g.azz().a(BindGoogleContactUI.this.jZT);
                    }
                    AppMethodBeat.o(109781);
                }
            });
        }
        AppMethodBeat.o(109807);
    }

    /* access modifiers changed from: package-private */
    public final void bnk() {
        AppMethodBeat.i(109808);
        if (this.jZH != null && this.jZH.isShowing()) {
            this.jZH.dismiss();
        }
        AppMethodBeat.o(109808);
    }

    /* access modifiers changed from: package-private */
    public class b extends AsyncTask<Void, Void, Void> {
        private boolean isSuccess;
        private String jZX;
        private String kaa;
        private String kab;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ Void doInBackground(Void[] voidArr) {
            AppMethodBeat.i(109791);
            Void bnl = bnl();
            AppMethodBeat.o(109791);
            return bnl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ void onPostExecute(Void r6) {
            AppMethodBeat.i(109790);
            super.onPostExecute(r6);
            Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPostExecute");
            BindGoogleContactUI bindGoogleContactUI = BindGoogleContactUI.this;
            boolean z = this.isSuccess;
            String str = this.jZX;
            String str2 = this.kab;
            if (!z || TextUtils.isEmpty(str)) {
                bindGoogleContactUI.bnk();
                bindGoogleContactUI.bnh();
                AppMethodBeat.o(109790);
                return;
            }
            bindGoogleContactUI.jZR = str;
            bindGoogleContactUI.jZS = str2;
            new a(bindGoogleContactUI.jZR).execute(new Void[0]);
            AppMethodBeat.o(109790);
        }

        public b(String str) {
            this.kaa = str;
        }

        /* access modifiers changed from: protected */
        public final void onPreExecute() {
            AppMethodBeat.i(109787);
            super.onPreExecute();
            Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPreExecute");
            this.jZX = "";
            this.kab = "";
            this.isSuccess = false;
            AppMethodBeat.o(109787);
        }

        private Void bnl() {
            AppMethodBeat.i(109788);
            try {
                String SJ = SJ(this.kaa);
                this.jZX = new JSONObject(SJ).optString("access_token");
                this.kab = new JSONObject(SJ).optString("refresh_token");
                Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "response:%s", SJ);
                Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "mAccessToken:%s", this.jZX);
                Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "mRefreshToken:%s", this.kab);
                this.isSuccess = true;
            } catch (MalformedURLException e2) {
                Log.e("MicroMsg.GoogleContact.BindGoogleContactUI", "MalformedURLException:%s" + e2.getMessage());
            } catch (ProtocolException e3) {
                Log.e("MicroMsg.GoogleContact.BindGoogleContactUI", "ProtocolException:%s" + e3.getMessage());
            } catch (IOException e4) {
                Log.e("MicroMsg.GoogleContact.BindGoogleContactUI", "IOException:%s" + e4.getMessage());
            } catch (JSONException e5) {
                Log.e("MicroMsg.GoogleContact.BindGoogleContactUI", "JSONException:%s" + e5.getMessage());
            }
            AppMethodBeat.o(109788);
            return null;
        }

        private static String SJ(String str) {
            AppMethodBeat.i(109789);
            String str2 = "";
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://accounts.google.com/o/oauth2/token").openConnection();
            httpURLConnection.setRequestProperty("Charset", MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT);
            httpURLConnection.setReadTimeout(com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, str));
            arrayList.add(new BasicNameValuePair("client_id", "369820936870.apps.googleusercontent.com"));
            arrayList.add(new BasicNameValuePair("client_secret", "wcFhvo-s7wNcmQ9Zjr00H06u"));
            arrayList.add(new BasicNameValuePair(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, "urn:ietf:wg:oauth:2.0:oob"));
            arrayList.add(new BasicNameValuePair("grant_type", "authorization_code"));
            String aY = m.aY(arrayList);
            Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "QueryString:%s", aY);
            httpURLConnection.setRequestProperty("Content-length", String.valueOf(aY.getBytes().length));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
            bufferedWriter.write(aY);
            bufferedWriter.flush();
            bufferedWriter.close();
            int responseCode = httpURLConnection.getResponseCode();
            Log.e("MicroMsg.GoogleContact.BindGoogleContactUI", "responseCode:".concat(String.valueOf(responseCode)));
            if (200 == responseCode) {
                StringBuffer stringBuffer = new StringBuffer();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                }
                bufferedReader.close();
                str2 = stringBuffer.toString();
                Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "exchange token respone:%s", str2);
            }
            try {
                httpURLConnection.getInputStream().close();
            } catch (Exception e2) {
                Log.e("MicroMsg.GoogleContact.BindGoogleContactUI", e2.getMessage());
            }
            httpURLConnection.disconnect();
            AppMethodBeat.o(109789);
            return str2;
        }
    }

    class a extends AsyncTask<Void, Void, Void> {
        private String jZX;
        private String jZY;
        private boolean jZZ;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ Void doInBackground(Void[] voidArr) {
            AppMethodBeat.i(109786);
            Void bnl = bnl();
            AppMethodBeat.o(109786);
            return bnl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ void onPostExecute(Void r7) {
            AppMethodBeat.i(109785);
            super.onPostExecute(r7);
            Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPostExecute");
            BindGoogleContactUI bindGoogleContactUI = BindGoogleContactUI.this;
            boolean z = this.jZZ;
            String str = this.jZY;
            if (!z || TextUtils.isEmpty(str)) {
                bindGoogleContactUI.bnk();
                bindGoogleContactUI.bnh();
                AppMethodBeat.o(109785);
            } else if (TextUtils.isEmpty(bindGoogleContactUI.jZG) || TextUtils.isEmpty(str) || bindGoogleContactUI.jZG.equalsIgnoreCase(str)) {
                bindGoogleContactUI.jZG = str;
                bindGoogleContactUI.aD(bindGoogleContactUI.jZG, x.keX);
                AppMethodBeat.o(109785);
            } else {
                bindGoogleContactUI.bnk();
                com.tencent.mm.ui.base.h.a(bindGoogleContactUI, bindGoogleContactUI.getString(R.string.du4), "", new DialogInterface.OnClickListener(str) {
                    /* class com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI.AnonymousClass4 */
                    final /* synthetic */ String jZW;

                    {
                        this.jZW = r2;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(109777);
                        BindGoogleContactUI.a(BindGoogleContactUI.this, this.jZW, x.keX);
                        AppMethodBeat.o(109777);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.bind.ui.BindGoogleContactUI.AnonymousClass5 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(109778);
                        g.aAh().azQ().set(208905, Boolean.TRUE);
                        BindGoogleContactUI.this.finish();
                        AppMethodBeat.o(109778);
                    }
                });
                AppMethodBeat.o(109785);
            }
        }

        public a(String str) {
            this.jZX = str;
        }

        /* access modifiers changed from: protected */
        public final void onPreExecute() {
            AppMethodBeat.i(109782);
            super.onPreExecute();
            Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "onPreExecute");
            this.jZZ = false;
            AppMethodBeat.o(109782);
        }

        private Void bnl() {
            AppMethodBeat.i(109783);
            Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "doInBackground");
            try {
                this.jZY = new JSONObject(SI(this.jZX)).optString(Scopes.EMAIL);
                if (!TextUtils.isEmpty(this.jZY)) {
                    this.jZZ = true;
                }
            } catch (MalformedURLException e2) {
                Log.e("MicroMsg.GoogleContact.BindGoogleContactUI", "MalformedURLException:%s", e2.getMessage());
            } catch (ProtocolException e3) {
                Log.e("MicroMsg.GoogleContact.BindGoogleContactUI", "ProtocolException:%s", e3.getMessage());
            } catch (UnsupportedEncodingException e4) {
                Log.e("MicroMsg.GoogleContact.BindGoogleContactUI", "UnsupportedEncodingException:%s", e4.getMessage());
            } catch (IOException e5) {
                Log.e("MicroMsg.GoogleContact.BindGoogleContactUI", "IOException:%s", e5.getMessage());
            } catch (JSONException e6) {
                Log.printErrStackTrace("MicroMsg.GoogleContact.BindGoogleContactUI", e6, "", new Object[0]);
            }
            AppMethodBeat.o(109783);
            return null;
        }

        private static String SI(String str) {
            AppMethodBeat.i(109784);
            String str2 = "";
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token=".concat(String.valueOf(str))).openConnection();
            httpURLConnection.setRequestProperty("Charset", MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT);
            httpURLConnection.setReadTimeout(com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT);
            int responseCode = httpURLConnection.getResponseCode();
            Log.e("MicroMsg.GoogleContact.BindGoogleContactUI", "responseCode:".concat(String.valueOf(responseCode)));
            if (200 == responseCode) {
                StringBuffer stringBuffer = new StringBuffer();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                }
                bufferedReader.close();
                str2 = stringBuffer.toString();
                Log.i("MicroMsg.GoogleContact.BindGoogleContactUI", "get EmailAccount respone:%s", str2);
            }
            try {
                httpURLConnection.getInputStream().close();
            } catch (Exception e2) {
                Log.e("MicroMsg.GoogleContact.BindGoogleContactUI", e2.getMessage());
            }
            httpURLConnection.disconnect();
            AppMethodBeat.o(109784);
            return str2;
        }
    }

    static /* synthetic */ void a(BindGoogleContactUI bindGoogleContactUI, String str) {
        AppMethodBeat.i(109810);
        String substring = str.substring(30);
        Log.d("MicroMsg.GoogleContact.BindGoogleContactUI", "keep_GET_TOKEN_CODE value:".concat(String.valueOf(substring)));
        bindGoogleContactUI.bnj();
        new b(substring).execute(new Void[0]);
        Log.d("MicroMsg.GoogleContact.BindGoogleContactUI", "keep_GET_TOKEN_CODE End.");
        AppMethodBeat.o(109810);
    }
}
