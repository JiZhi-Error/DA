package com.tencent.mm.ui.o;

import android.annotation.SuppressLint;
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
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.i;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
@SuppressLint({"SetJavaScriptEnabled"})
public final class b extends i {
    static final float[] QjT = {20.0f, 60.0f};
    static final float[] QjU = {40.0f, 60.0f};
    static final FrameLayout.LayoutParams QjV = new FrameLayout.LayoutParams(-1, -1);
    private WebView IJw;
    private a QAU;
    private ProgressDialog QjX;
    private ImageView QjY;
    private FrameLayout QjZ;
    private String mUrl;

    public interface a {
        void E(Bundle bundle);

        void gYy();

        void onCancel();
    }

    static {
        AppMethodBeat.i(152881);
        AppMethodBeat.o(152881);
    }

    public b(Context context, String str, a aVar) {
        super(context, 16973840);
        this.mUrl = str;
        this.QAU = aVar;
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(152879);
        super.onCreate(bundle);
        this.QjX = new ProgressDialog(getContext());
        this.QjX.requestWindowFeature(1);
        this.QjX.setMessage(getContext().getString(R.string.hrq));
        requestWindowFeature(1);
        this.QjZ = new FrameLayout(getContext());
        this.QjY = new ImageView(getContext());
        this.QjY.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.o.b.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(152871);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/twitter/TwitterDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.this.QAU.onCancel();
                b.this.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/twitter/TwitterDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(152871);
            }
        });
        this.QjY.setImageDrawable(getContext().getResources().getDrawable(R.drawable.bc3));
        this.QjY.setVisibility(4);
        int intrinsicWidth = this.QjY.getDrawable().getIntrinsicWidth() / 2;
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.IJw = new WebView(getContext());
        this.IJw.setVerticalScrollBarEnabled(false);
        this.IJw.setHorizontalScrollBarEnabled(false);
        this.IJw.setWebViewClient(new C2124b(this, (byte) 0));
        this.IJw.getSettings().setJavaScriptEnabled(true);
        this.IJw.loadUrl(this.mUrl);
        this.IJw.setLayoutParams(QjV);
        this.IJw.setVisibility(4);
        linearLayout.setPadding(intrinsicWidth, intrinsicWidth, intrinsicWidth, intrinsicWidth);
        linearLayout.addView(this.IJw);
        this.QjZ.addView(linearLayout);
        this.QjZ.addView(this.QjY, new ViewGroup.LayoutParams(-2, -2));
        addContentView(this.QjZ, new ViewGroup.LayoutParams(-1, -1));
        AppMethodBeat.o(152879);
    }

    @JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
    /* renamed from: com.tencent.mm.ui.o.b$b  reason: collision with other inner class name */
    class C2124b extends ac {
        boolean Qkb;

        private C2124b() {
            this.Qkb = true;
        }

        /* synthetic */ C2124b(b bVar, byte b2) {
            this();
        }

        @Override // com.tencent.xweb.ac
        public final boolean a(WebView webView, String str) {
            AppMethodBeat.i(152873);
            Log.d("Twitter-WebView", "Redirect URL: ".concat(String.valueOf(str)));
            if (str.startsWith("wechatapp://sign-in-twitter.wechatapp.com/")) {
                Bundle bnH = bnH(str);
                if (bnH.getString("denied") == null) {
                    b.this.QAU.E(bnH);
                } else {
                    b.this.QAU.onCancel();
                }
                b.this.dismiss();
                AppMethodBeat.o(152873);
            } else {
                Context context = b.this.getContext();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/twitter/TwitterDialog$TwitterWebViewClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/twitter/TwitterDialog$TwitterWebViewClient", "shouldOverrideUrlLoading", "(Lcom/tencent/xweb/WebView;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(152873);
            }
            return true;
        }

        @Override // com.tencent.xweb.ac
        public final void a(WebView webView, int i2, String str, String str2) {
            AppMethodBeat.i(152874);
            super.a(webView, i2, str, str2);
            this.Qkb = false;
            a aVar = b.this.QAU;
            new com.tencent.mm.ui.h.a.b(str, i2, str2);
            aVar.gYy();
            try {
                b.this.dismiss();
                b.this.QjX.dismiss();
                AppMethodBeat.o(152874);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.TwitterDialog", e2, "", new Object[0]);
                AppMethodBeat.o(152874);
            }
        }

        @Override // com.tencent.xweb.ac
        public final void b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(152875);
            Log.d("Twitter-WebView", "Webview loading URL: ".concat(String.valueOf(str)));
            super.b(webView, str, bitmap);
            try {
                b.this.QjX.show();
                b.this.QjX.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    /* class com.tencent.mm.ui.o.b.C2124b.AnonymousClass1 */

                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(152872);
                        if (C2124b.this.Qkb && b.this != null) {
                            b.this.QAU.onCancel();
                            b.this.dismiss();
                        }
                        AppMethodBeat.o(152872);
                    }
                });
                AppMethodBeat.o(152875);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.TwitterDialog", e2, "", new Object[0]);
                AppMethodBeat.o(152875);
            }
        }

        @Override // com.tencent.xweb.ac
        public final void b(WebView webView, String str) {
            AppMethodBeat.i(152876);
            super.b(webView, str);
            this.Qkb = false;
            try {
                b.this.QjX.dismiss();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.TwitterDialog", e2, "", new Object[0]);
            }
            b.this.QjZ.setBackgroundColor(0);
            b.this.IJw.setVisibility(0);
            b.this.QjY.setVisibility(0);
            AppMethodBeat.o(152876);
        }

        private static Bundle bnG(String str) {
            AppMethodBeat.i(152877);
            Bundle bundle = new Bundle();
            if (str != null) {
                for (String str2 : str.split("&")) {
                    String[] split = str2.split("=");
                    bundle.putString(URLDecoder.decode(split[0]), URLDecoder.decode(split[1]));
                }
            }
            AppMethodBeat.o(152877);
            return bundle;
        }

        private static Bundle bnH(String str) {
            AppMethodBeat.i(152878);
            try {
                URL url = new URL(str.replace("wechatapp", "http"));
                Bundle bnG = bnG(url.getQuery());
                bnG.putAll(bnG(url.getRef()));
                AppMethodBeat.o(152878);
                return bnG;
            } catch (MalformedURLException e2) {
                Bundle bundle = new Bundle();
                AppMethodBeat.o(152878);
                return bundle;
            }
        }
    }

    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(152880);
        if (i2 == 4) {
            this.QAU.onCancel();
            dismiss();
            AppMethodBeat.o(152880);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(152880);
        return onKeyDown;
    }
}
