package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.webkit.GeolocationPermissions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.o;
import com.tencent.xweb.x;
import java.util.Comparator;
import java.util.concurrent.ConcurrentSkipListSet;

public class i extends x {
    private int Jja = 0;
    public final ConcurrentSkipListSet<JsResult> Jyu = new ConcurrentSkipListSet<>(new Comparator<JsResult>() {
        /* class com.tencent.mm.plugin.webview.ui.tools.widget.i.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(JsResult jsResult, JsResult jsResult2) {
            AppMethodBeat.i(212062);
            int hashCode = jsResult.hashCode() - jsResult2.hashCode();
            AppMethodBeat.o(212062);
            return hashCode;
        }
    });
    private MMWebViewWithJsApi mHe;

    public i(MMWebViewWithJsApi mMWebViewWithJsApi) {
        AppMethodBeat.i(212069);
        this.mHe = mMWebViewWithJsApi;
        AppMethodBeat.o(212069);
    }

    private JsResult a(final JsResult jsResult) {
        AppMethodBeat.i(212070);
        AnonymousClass4 r0 = new JsResult() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.i.AnonymousClass4 */
            private boolean mCalled = false;

            {
                AppMethodBeat.i(212065);
                i.this.Jyu.add(this);
                AppMethodBeat.o(212065);
            }

            @Override // org.xwalk.core.XWalkJavascriptResult
            public final void confirmWithResult(String str) {
                AppMethodBeat.i(212066);
                if (!this.mCalled) {
                    jsResult.confirmWithResult(str);
                    this.mCalled = true;
                }
                i.this.Jyu.remove(this);
                AppMethodBeat.o(212066);
            }

            @Override // org.xwalk.core.XWalkJavascriptResult
            public final void confirm() {
                AppMethodBeat.i(212067);
                if (!this.mCalled) {
                    jsResult.confirm();
                    this.mCalled = true;
                }
                i.this.Jyu.remove(this);
                AppMethodBeat.o(212067);
            }

            @Override // org.xwalk.core.XWalkJavascriptResult
            public final void cancel() {
                AppMethodBeat.i(212068);
                if (!this.mCalled) {
                    jsResult.cancel();
                    this.mCalled = true;
                }
                i.this.Jyu.remove(this);
                AppMethodBeat.o(212068);
            }
        };
        AppMethodBeat.o(212070);
        return r0;
    }

    @Override // com.tencent.xweb.x
    public void d(WebView webView, String str) {
        AppMethodBeat.i(82122);
        super.d(webView, str);
        AppMethodBeat.o(82122);
    }

    @Override // com.tencent.xweb.x
    public final void onGeolocationPermissionsShowPrompt(final String str, final GeolocationPermissions.Callback callback) {
        AppMethodBeat.i(82123);
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.mHe.getContext());
        if (castActivityOrNull == null) {
            Log.e("MicroMsg.WebView.MMWebChromeClient", "onGeolocationPermissionsShowPrompt with origin(%s) NULL activity, return denial", str);
            callback.invoke(str, false, false);
            AppMethodBeat.o(82123);
            return;
        }
        h.a((Context) castActivityOrNull, false, castActivityOrNull.getString(R.string.j4o, str), castActivityOrNull.getString(R.string.j4p), castActivityOrNull.getString(R.string.x_), castActivityOrNull.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.i.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(82115);
                callback.invoke(str, true, true);
                AppMethodBeat.o(82115);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.widget.i.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(82116);
                callback.invoke(str, false, false);
                AppMethodBeat.o(82116);
            }
        });
        AppMethodBeat.o(82123);
    }

    @Override // com.tencent.xweb.x
    public final boolean a(WebView webView, String str, String str2, JsResult jsResult) {
        d a2;
        AppMethodBeat.i(82124);
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.mHe.getContext());
        if (castActivityOrNull == null) {
            Log.e("MicroMsg.WebView.MMWebChromeClient", "onJsAlert with url(%s) message(%s), NULL activity, return cancel", str, str2);
            jsResult.cancel();
            AppMethodBeat.o(82124);
            return true;
        }
        final JsResult a3 = a(jsResult);
        this.Jja++;
        if (this.Jja > 2) {
            a2 = h.a(castActivityOrNull, str2, "", castActivityOrNull.getString(R.string.j4i), castActivityOrNull.getString(R.string.x_), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.webview.ui.tools.widget.i.AnonymousClass7 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(82117);
                    a3.cancel();
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    i.this.onClose();
                    AppMethodBeat.o(82117);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.webview.ui.tools.widget.i.AnonymousClass8 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(82118);
                    a3.confirm();
                    AppMethodBeat.o(82118);
                }
            }, (int) R.color.x0);
        } else {
            a2 = h.a(castActivityOrNull, str2, "", castActivityOrNull.getString(R.string.x_), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.webview.ui.tools.widget.i.AnonymousClass9 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(82119);
                    a3.confirm();
                    AppMethodBeat.o(82119);
                }
            });
        }
        if (a2 != null) {
            a2.setCanceledOnTouchOutside(false);
            a2.Dh(false);
            AppMethodBeat.o(82124);
            return true;
        }
        boolean a4 = super.a(webView, str, str2, a3);
        AppMethodBeat.o(82124);
        return a4;
    }

    @Override // com.tencent.xweb.x
    public final boolean b(WebView webView, String str, String str2, JsResult jsResult) {
        d a2;
        AppMethodBeat.i(82125);
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.mHe.getContext());
        if (castActivityOrNull == null) {
            Log.e("MicroMsg.WebView.MMWebChromeClient", "onJsConfirm with url(%s) message(%s), NULL activity, return cancel", str, str2);
            jsResult.cancel();
            AppMethodBeat.o(82125);
            return true;
        }
        final JsResult a3 = a(jsResult);
        this.Jja++;
        if (this.Jja > 2) {
            a2 = h.a(castActivityOrNull, str2, "", castActivityOrNull.getString(R.string.j4i), castActivityOrNull.getString(R.string.x_), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.webview.ui.tools.widget.i.AnonymousClass10 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(82120);
                    a3.cancel();
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    i.this.onClose();
                    AppMethodBeat.o(82120);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.webview.ui.tools.widget.i.AnonymousClass11 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(82121);
                    a3.confirm();
                    AppMethodBeat.o(82121);
                }
            }, (int) R.color.go);
        } else {
            a2 = h.a((Context) castActivityOrNull, false, str2, "", castActivityOrNull.getString(R.string.x_), castActivityOrNull.getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.webview.ui.tools.widget.i.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(212063);
                    a3.confirm();
                    AppMethodBeat.o(212063);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.webview.ui.tools.widget.i.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(212064);
                    a3.cancel();
                    AppMethodBeat.o(212064);
                }
            });
        }
        if (a2 != null) {
            a2.setCancelable(false);
            a2.setCanceledOnTouchOutside(false);
            AppMethodBeat.o(82125);
            return true;
        }
        boolean b2 = super.b(webView, str, str2, a3);
        AppMethodBeat.o(82125);
        return b2;
    }

    @Override // com.tencent.xweb.x
    public final boolean a(WebView webView, String str, String str2, String str3, o oVar) {
        AppMethodBeat.i(82126);
        boolean a2 = super.a(webView, str, str2, str3, oVar);
        AppMethodBeat.o(82126);
        return a2;
    }

    /* access modifiers changed from: protected */
    public void onClose() {
        AppMethodBeat.i(82127);
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(this.mHe.getContext());
        if (castActivityOrNull == null) {
            AppMethodBeat.o(82127);
            return;
        }
        castActivityOrNull.finish();
        AppMethodBeat.o(82127);
    }
}
