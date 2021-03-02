package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.util.Base64;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.webview.modeltools.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import java.lang.reflect.Field;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20141210", reviewer = 20, vComment = {EType.HTTPSCHECK})
public final class c {
    private final SimpleDateFormat BGt = new SimpleDateFormat("yyyy-MM-dd HH:mmZ", Locale.getDefault());
    WebView IRR;
    Map<String, List<r>> Jer;
    Map<String, Boolean> Jes;
    Context context;
    private d kvo = null;
    private List<String> niZ = null;
    private KeyStore nja = null;

    public c(Context context2, WebView webView) {
        AppMethodBeat.i(79605);
        this.context = context2;
        this.IRR = webView;
        this.Jer = new HashMap();
        this.Jes = new HashMap();
        AppMethodBeat.o(79605);
    }

    public final void aG(Context context2) {
        this.context = context2;
    }

    private boolean b(SslCertificate sslCertificate) {
        boolean z;
        AppMethodBeat.i(79606);
        if (sslCertificate == null) {
            Log.i("MicroMsg.WebView.MMSslErrorHandler", "isUserCertificates sslCertificate is null");
            AppMethodBeat.o(79606);
            return false;
        }
        Log.i("MicroMsg.WebView.MMSslErrorHandler", "isUserCertificates dnName = %s", sslCertificate.getIssuedBy().getDName());
        try {
            Field declaredField = sslCertificate.getClass().getDeclaredField("mX509Certificate");
            declaredField.setAccessible(true);
            X509Certificate x509Certificate = (X509Certificate) declaredField.get(sslCertificate);
            if (this.nja == null) {
                this.nja = KeyStore.getInstance("AndroidCAStore");
                this.nja.load(null, null);
            }
            if (this.niZ == null) {
                this.niZ = new ArrayList();
                Enumeration<String> aliases = this.nja.aliases();
                while (aliases.hasMoreElements()) {
                    String nextElement = aliases.nextElement();
                    if (nextElement != null && nextElement.startsWith("user:")) {
                        this.niZ.add(nextElement);
                    }
                }
            }
            Iterator<String> it = this.niZ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                try {
                    x509Certificate.verify(((X509Certificate) this.nja.getCertificate(it.next())).getPublicKey());
                    z = true;
                    break;
                } catch (Exception e2) {
                }
            }
        } catch (Exception e3) {
            Log.e("MicroMsg.WebView.MMSslErrorHandler", "isUserCertificates ex %s", e3.getMessage());
            z = false;
        }
        AppMethodBeat.o(79606);
        return z;
    }

    public final void a(final String str, r rVar, SslError sslError) {
        AppMethodBeat.i(79607);
        Log.e("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError, currentUrl = %s", str);
        if (this.IRR == null) {
            Log.e("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError fail, has been detached");
            AppMethodBeat.o(79607);
        } else if (Util.isNullOrNil(str)) {
            rVar.cancel();
            AppMethodBeat.o(79607);
        } else {
            Boolean bool = this.Jes.get(str);
            if (bool != null) {
                Log.v("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError, already selected = %b", bool);
                if (bool.booleanValue()) {
                    rVar.proceed();
                    AppMethodBeat.o(79607);
                    return;
                }
                rVar.cancel();
                AppMethodBeat.o(79607);
                return;
            }
            try {
                int a2 = ((b) g.af(b.class)).a(b.a.clicfg_webview_skip_user_cert, 1);
                Log.i("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError skipUserCert = %d", Integer.valueOf(a2));
                if (a2 == 1 && b(sslError.getCertificate())) {
                    Log.i("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError use user certificatess");
                    this.Jes.put(str, Boolean.TRUE);
                    rVar.proceed();
                    AppMethodBeat.o(79607);
                    return;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.WebView.MMSslErrorHandler", "onReceiveSslError : " + e2.getLocalizedMessage());
            }
            try {
                URL url = new URL(str);
                if (((b) g.af(b.class)).a(b.a.clicfg_webview_show_ssl_dialog, 0) != 1 || !url.getHost().endsWith(".qq.com")) {
                    Log.d("MicroMsg.WebView.MMSslErrorHandler", "host = " + url.getHost() + ", but it not end with '.qq.com'");
                    rVar.cancel();
                    AppMethodBeat.o(79607);
                    return;
                }
                List<r> list = this.Jer.get(str);
                if (list == null || list.size() == 0) {
                    a(str, sslError);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(rVar);
                    this.Jer.put(str, arrayList);
                    if (this.kvo == null || !this.kvo.isShowing()) {
                        this.kvo = h.a(this.context, false, this.context.getString(R.string.j43, url.getHost()), this.context.getString(R.string.j44), this.context.getString(R.string.t9), this.context.getString(R.string.he), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.c.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(79603);
                                List<r> list = c.this.Jer.get(str);
                                if (list == null) {
                                    Log.e("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, continue selected, list should not be null");
                                    AppMethodBeat.o(79603);
                                    return;
                                }
                                c.this.Jes.put(str, Boolean.FALSE);
                                Log.i("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, continue selected, list size = %d", Integer.valueOf(list.size()));
                                for (r rVar : list) {
                                    rVar.cancel();
                                }
                                list.clear();
                                c.this.IRR.clearSslPreferences();
                                new a().c((Activity) c.this.context, str);
                                AppMethodBeat.o(79603);
                            }
                        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.c.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(79604);
                                List<r> list = c.this.Jer.get(str);
                                if (list == null) {
                                    Log.e("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, cancel selected, list should not be null");
                                    AppMethodBeat.o(79604);
                                    return;
                                }
                                c.this.Jes.put(str, Boolean.FALSE);
                                Log.i("MicroMsg.WebView.MMSslErrorHandler", "onReceivedSslError, cancel selected, list size = %d", Integer.valueOf(list.size()));
                                for (r rVar : list) {
                                    rVar.cancel();
                                }
                                list.clear();
                                c.this.IRR.clearSslPreferences();
                                AppMethodBeat.o(79604);
                            }
                        });
                        AppMethodBeat.o(79607);
                        return;
                    }
                    rVar.cancel();
                    AppMethodBeat.o(79607);
                    return;
                }
                list.add(rVar);
                AppMethodBeat.o(79607);
            } catch (Exception e3) {
                Log.e("MicroMsg.WebView.MMSslErrorHandler", "create url fail : " + e3.getLocalizedMessage());
                AppMethodBeat.o(79607);
            }
        }
    }

    public final void detach() {
        AppMethodBeat.i(79608);
        Log.i("MicroMsg.WebView.MMSslErrorHandler", "detach");
        this.context = null;
        this.IRR = null;
        this.Jer.clear();
        this.Jes.clear();
        AppMethodBeat.o(79608);
    }

    @TargetApi(8)
    private void a(String str, SslError sslError) {
        AppMethodBeat.i(79609);
        String str2 = "1" + "," + b(str, sslError);
        Log.i("MicroMsg.WebView.MMSslErrorHandler", "reportWebViewSslError, value = %s", str2);
        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(11098, str2);
        AppMethodBeat.o(79609);
    }

    @TargetApi(14)
    private String b(String str, SslError sslError) {
        Object valueOf;
        AppMethodBeat.i(79610);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("<sslerror>");
            sb.append("<primaryerror>");
            if (sslError == null) {
                valueOf = "-1";
            } else {
                valueOf = Integer.valueOf(sslError.getPrimaryError());
            }
            sb.append(valueOf);
            sb.append("</primaryerror>");
            sb.append("<clienttime>");
            sb.append(Base64.encodeToString(this.BGt.format(new Date()).getBytes(), 0));
            sb.append("</clienttime>");
            sb.append("<currenturl>");
            if (!Util.isNullOrNil(str)) {
                sb.append(Util.escapeStringForXml(str));
            }
            sb.append("</currenturl>");
            SslCertificate certificate = sslError == null ? null : sslError.getCertificate();
            if (certificate != null) {
                SslCertificate.DName issuedBy = certificate.getIssuedBy();
                if (issuedBy != null) {
                    sb.append("<issuedby>");
                    if (issuedBy.getDName() != null) {
                        sb.append(Base64.encodeToString(issuedBy.getDName().getBytes(), 0));
                    }
                    sb.append("</issuedby>");
                }
                SslCertificate.DName issuedTo = certificate.getIssuedTo();
                if (issuedTo != null) {
                    sb.append("<issuedto>");
                    if (issuedTo.getDName() != null) {
                        sb.append(Base64.encodeToString(issuedTo.getDName().getBytes(), 0));
                    }
                    sb.append("</issuedto>");
                }
                String validNotAfter = certificate.getValidNotAfter();
                if (validNotAfter != null) {
                    sb.append("<getvalidnotafter>");
                    sb.append(Base64.encodeToString(validNotAfter.getBytes(), 0));
                    sb.append("</getvalidnotafter>");
                }
                String validNotBefore = certificate.getValidNotBefore();
                if (validNotBefore != null) {
                    sb.append("<getvalidnotbefore>");
                    sb.append(Base64.encodeToString(validNotBefore.getBytes(), 0));
                    sb.append("</getvalidnotbefore>");
                }
            }
            sb.append("</sslerror>");
            String sb2 = sb.toString();
            AppMethodBeat.o(79610);
            return sb2;
        } catch (Exception e2) {
            Log.w("MicroMsg.WebView.MMSslErrorHandler", "buildXml ex = %s", e2.getMessage());
            AppMethodBeat.o(79610);
            return "";
        }
    }
}
