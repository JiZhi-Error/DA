package com.tencent.mm.plugin.webview.ui.tools.browser.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.e;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0006H\u0016¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "Landroid/support/v7/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "initContentView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialogView", "Landroid/view/View;", "release", "Companion", "plugin-webview_release"})
public abstract class a extends e {
    public static final C1983a JlQ = new C1983a((byte) 0);

    public abstract View onCreateDialogView();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.browser.view.a$a  reason: collision with other inner class name */
    public static final class C1983a {
        private C1983a() {
        }

        public /* synthetic */ C1983a(byte b2) {
            this();
        }
    }

    public a(Context context) {
        super(context, R.style.fv);
    }

    @Override // android.support.v7.app.e
    public void onCreate(Bundle bundle) {
        WindowManager.LayoutParams attributes;
        View decorView;
        Resources resources;
        DisplayMetrics displayMetrics;
        super.onCreate(bundle);
        Log.i("MicroMsg.BrowseChooseDialog", "alvinluo BrowserDialog onCreate");
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.addFlags(67108864);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setDimAmount(0.5f);
        }
        Window window4 = getWindow();
        if (window4 != null) {
            window4.setWindowAnimations(R.style.fs);
        }
        Window window5 = getWindow();
        if (!(window5 == null || (decorView = window5.getDecorView()) == null)) {
            p.g(decorView, "this");
            Context context = decorView.getContext();
            decorView.setMinimumWidth((context == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) ? com.tencent.mm.cb.a.jn(decorView.getContext()) : displayMetrics.widthPixels);
            decorView.setPadding(0, 0, 0, 0);
        }
        Window window6 = getWindow();
        if (!(window6 == null || (attributes = window6.getAttributes()) == null)) {
            attributes.width = -1;
            attributes.height = -2;
            attributes.gravity = 80;
        }
        setContentView(onCreateDialogView());
    }
}
