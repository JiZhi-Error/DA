package com.tencent.mm.ui.h.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.h.a.c;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public final class g extends i {
    static final float[] QjT = {20.0f, 60.0f};
    static final float[] QjU = {40.0f, 60.0f};
    static final FrameLayout.LayoutParams QjV = new FrameLayout.LayoutParams(-1, -1);
    private WebView IJw;
    private c.a QjW;
    private ProgressDialog QjX;
    private ImageView QjY;
    private FrameLayout QjZ;
    private String mUrl;

    static {
        AppMethodBeat.i(152851);
        AppMethodBeat.o(152851);
    }

    public g(Context context, String str, c.a aVar) {
        super(context, 16973840);
        this.mUrl = str;
        this.QjW = aVar;
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(152849);
        super.onCreate(bundle);
        this.QjX = new ProgressDialog(getContext());
        this.QjX.requestWindowFeature(1);
        this.QjX.setMessage(getContext().getString(R.string.c7q));
        requestWindowFeature(1);
        this.QjZ = new FrameLayout(getContext());
        this.QjY = new ImageView(getContext());
        this.QjY.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.h.a.g.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(152843);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/facebook/sdk/FbDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                g.this.QjW.onCancel();
                g.this.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/facebook/sdk/FbDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(152843);
            }
        });
        this.QjY.setImageDrawable(getContext().getResources().getDrawable(R.drawable.bc3));
        this.QjY.setVisibility(4);
        int intrinsicWidth = this.QjY.getDrawable().getIntrinsicWidth() / 2;
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.IJw = new WebView(getContext());
        this.IJw.setVerticalScrollBarEnabled(false);
        this.IJw.setHorizontalScrollBarEnabled(false);
        this.IJw.setWebViewClient(new a(this, (byte) 0));
        this.IJw.getSettings().setJavaScriptEnabled(true);
        this.IJw.loadUrl(this.mUrl);
        this.IJw.setLayoutParams(QjV);
        this.IJw.setVisibility(4);
        linearLayout.setPadding(intrinsicWidth, intrinsicWidth, intrinsicWidth, intrinsicWidth);
        linearLayout.addView(this.IJw);
        this.QjZ.addView(linearLayout);
        this.QjZ.addView(this.QjY, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.QjZ, new ViewGroup.LayoutParams(-1, -1));
        AppMethodBeat.o(152849);
    }

    class a extends ac {
        boolean Qkb;

        private a() {
            this.Qkb = true;
        }

        /* synthetic */ a(g gVar, byte b2) {
            this();
        }

        @Override // com.tencent.xweb.ac
        public final boolean a(WebView webView, String str) {
            AppMethodBeat.i(152845);
            Log.d("Facebook-WebView", "Redirect URL: ".concat(String.valueOf(str)));
            if (str.startsWith(ServerProtocol.DIALOG_REDIRECT_URI)) {
                Bundle bnH = f.bnH(str);
                String string = bnH.getString("error");
                if (string == null) {
                    string = bnH.getString(NativeProtocol.BRIDGE_ARG_ERROR_TYPE);
                }
                if (string == null) {
                    g.this.QjW.E(bnH);
                } else if (string.equals("access_denied") || string.equals("OAuthAccessDeniedException")) {
                    g.this.QjW.onCancel();
                } else {
                    g.this.QjW.a(new e(string));
                }
                g.this.dismiss();
                AppMethodBeat.o(152845);
                return true;
            } else if (str.startsWith(ServerProtocol.DIALOG_CANCEL_URI)) {
                g.this.QjW.onCancel();
                try {
                    g.this.dismiss();
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.FbDialog", e2, "", new Object[0]);
                }
                AppMethodBeat.o(152845);
                return true;
            } else if (str.contains("touch")) {
                AppMethodBeat.o(152845);
                return false;
            } else {
                Context context = g.this.getContext();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/facebook/sdk/FbDialog$FbWebViewClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/facebook/sdk/FbDialog$FbWebViewClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(152845);
                return true;
            }
        }

        @Override // com.tencent.xweb.ac
        public final void a(WebView webView, int i2, String str, String str2) {
            AppMethodBeat.i(152846);
            super.a(webView, i2, str, str2);
            this.Qkb = false;
            g.this.QjW.a(new b(str, i2, str2));
            try {
                g.this.dismiss();
                g.this.QjX.dismiss();
                AppMethodBeat.o(152846);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FbDialog", e2, "", new Object[0]);
                AppMethodBeat.o(152846);
            }
        }

        @Override // com.tencent.xweb.ac
        public final void b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(152847);
            Log.d("Facebook-WebView", "Webview loading URL: ".concat(String.valueOf(str)));
            super.b(webView, str, bitmap);
            try {
                g.this.QjX.show();
                g.this.QjX.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    /* class com.tencent.mm.ui.h.a.g.a.AnonymousClass1 */

                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(152844);
                        if (a.this.Qkb && g.this != null) {
                            g.this.QjW.onCancel();
                            g.this.dismiss();
                        }
                        AppMethodBeat.o(152844);
                    }
                });
                AppMethodBeat.o(152847);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FbDialog", e2, "", new Object[0]);
                AppMethodBeat.o(152847);
            }
        }

        @Override // com.tencent.xweb.ac
        public final void b(WebView webView, String str) {
            AppMethodBeat.i(152848);
            super.b(webView, str);
            this.Qkb = false;
            try {
                g.this.QjX.dismiss();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FbDialog", e2, "", new Object[0]);
            }
            g.this.QjZ.setBackgroundColor(0);
            g.this.IJw.setVisibility(0);
            g.this.QjY.setVisibility(0);
            AppMethodBeat.o(152848);
        }
    }

    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(152850);
        if (i2 == 4) {
            this.QjW.onCancel();
            dismiss();
            AppMethodBeat.o(152850);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(152850);
        return onKeyDown;
    }
}
