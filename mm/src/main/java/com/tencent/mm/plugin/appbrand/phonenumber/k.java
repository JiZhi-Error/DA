package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.graphics.Color;
import android.text.method.LinkMovementMethod;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.permission.f;
import com.tencent.mm.plugin.appbrand.permission.g;
import com.tencent.mm.plugin.appbrand.utils.html.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B3\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020 H\u0016J\u0010\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0016H\u0016J\b\u0010&\u001a\u00020\nH\u0016J\b\u0010'\u001a\u00020\fH\u0016J\b\u0010(\u001a\u00020\fH\u0016J\b\u0010)\u001a\u00020\fH\u0016J\b\u0010*\u001a\u00020 H\u0016J\b\u0010+\u001a\u00020 H\u0016J\u0010\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020\nH\u0016J\u0012\u0010.\u001a\u00020 2\b\u0010/\u001a\u0004\u0018\u00010\u001aH\u0016J\u000e\u00100\u001a\u00020 2\u0006\u00101\u001a\u00020\nJ\u0010\u00102\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0016R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/DialogExplainDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "webviewOpener", "Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;", "content", "", "context", "Landroid/content/Context;", "height", "", "shouldInLargeScreenCompatMode", "", "(Lcom/tencent/mm/plugin/appbrand/jsapi/IExternalToolsHelper;Ljava/lang/String;Landroid/content/Context;IZ)V", "_position", "backIv", "Landroid/widget/ImageView;", "getContent", "()Ljava/lang/String;", "contentTv", "Landroid/widget/TextView;", "contentV", "Landroid/view/View;", "getContext", "()Landroid/content/Context;", "dialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "getHeight", "()I", "rootView", "titleTv", "applyStyleByRotation", "", "cancel", "dismiss", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "getContentView", "getPosition", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "setPosition", "position", "show", "Companion", "luggage-wechat-full-sdk_release"})
public final class k implements g, com.tencent.mm.plugin.appbrand.widget.dialog.k {
    @Deprecated
    public static final a nzo = new a((byte) 0);
    private final String content;
    final Context context;
    private final TextView hXC;
    private final int height;
    private int jCs;
    private final View lJG;
    private final ImageView lJH;
    private final View lJI;
    private m lJJ;
    private final ag nzm;
    private final boolean nzn;
    private final TextView titleTv;

    static {
        AppMethodBeat.i(230145);
        AppMethodBeat.o(230145);
    }

    public k(ag agVar, String str, Context context2, int i2, boolean z) {
        p.h(context2, "context");
        AppMethodBeat.i(230144);
        this.nzm = agVar;
        this.content = str;
        this.context = context2;
        this.height = i2;
        this.nzn = z;
        if (this.nzm == null) {
            Log.w("Luggage.FULL.DialogExplainDialog", "<init> get NULL webviewOpener");
        }
        this.jCs = 2;
        View inflate = View.inflate(this.context, R.layout.ei, null);
        p.g(inflate, "View.inflate(context, R.…ber_explain_dialog, null)");
        this.lJI = inflate;
        View findViewById = this.lJI.findViewById(R.id.gak);
        p.g(findViewById, "rootView.findViewById(R.…e_number_explain_content)");
        this.lJG = findViewById;
        View view = this.lJG;
        if (view != null) {
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, this.height));
        }
        View findViewById2 = this.lJI.findViewById(R.id.gal);
        p.g(findViewById2, "rootView.findViewById(R.…mber_explain_dialog_back)");
        this.lJH = (ImageView) findViewById2;
        ImageView imageView = this.lJH;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.appbrand.phonenumber.k.AnonymousClass1 */
                final /* synthetic */ k nzp;

                {
                    this.nzp = r1;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(148060);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/phonenumber/DialogExplainDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    m mVar = this.nzp.lJJ;
                    if (mVar != null) {
                        mVar.c(this.nzp);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/DialogExplainDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(148060);
                }
            });
        }
        View findViewById3 = this.lJI.findViewById(R.id.gan);
        p.g(findViewById3, "rootView.findViewById(R.…ber_explain_dialog_title)");
        this.titleTv = (TextView) findViewById3;
        this.titleTv.setText(this.lJI.getContext().getText(R.string.a2f));
        View findViewById4 = this.lJI.findViewById(R.id.gam);
        p.g(findViewById4, "rootView.findViewById(R.…r_explain_dialog_content)");
        this.hXC = (TextView) findViewById4;
        this.hXC.setText(c.a(this.content, false, (c.a) new c.a(this) {
            /* class com.tencent.mm.plugin.appbrand.phonenumber.k.AnonymousClass2 */
            final /* synthetic */ k nzp;

            {
                this.nzp = r1;
            }

            @Override // com.tencent.mm.plugin.appbrand.utils.html.c.a
            public final void YF(String str) {
                AppMethodBeat.i(148061);
                ag agVar = this.nzp.nzm;
                if (agVar != null) {
                    agVar.a(this.nzp.context, str, null);
                    AppMethodBeat.o(148061);
                    return;
                }
                AppMethodBeat.o(148061);
            }
        }));
        this.hXC.setMovementMethod(LinkMovementMethod.getInstance());
        this.hXC.setLinkTextColor(Color.parseColor("#FF576B95"));
        AppMethodBeat.o(230144);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/DialogExplainDialog$Companion;", "", "()V", "TAG", "", "luggage-wechat-full-sdk_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public /* synthetic */ k(ag agVar, String str, Context context2, int i2) {
        this(agVar, str, context2, i2, false);
    }

    @Override // com.tencent.mm.plugin.appbrand.permission.f
    public final void h(d dVar) {
        AppMethodBeat.i(230138);
        p.h(dVar, "component");
        setPosition(this.jCs);
        p.h(dVar, "$this$findPromptViewContainer");
        p.h(dVar, "$this$findPromptViewContainer");
        f.a.j(dVar).b(this);
        AppMethodBeat.o(230138);
    }

    public final void dismiss() {
        AppMethodBeat.i(230139);
        m mVar = this.lJJ;
        if (mVar != null) {
            mVar.c(this);
            AppMethodBeat.o(230139);
            return;
        }
        AppMethodBeat.o(230139);
    }

    public final void setPosition(int i2) {
        AppMethodBeat.i(230140);
        this.jCs = i2;
        switch (i2) {
            case 1:
                this.lJI.setBackground(android.support.v4.content.b.l(this.context, R.drawable.eh));
                AppMethodBeat.o(230140);
                return;
            case 2:
                this.lJI.setBackground(android.support.v4.content.b.l(this.context, R.drawable.eg));
                break;
        }
        AppMethodBeat.o(230140);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final int getPosition() {
        return this.jCs;
    }

    public final void cancel() {
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final void a(m mVar) {
        AppMethodBeat.i(230141);
        this.lJJ = mVar;
        bTt();
        AppMethodBeat.o(230141);
    }

    private final void bTt() {
        AppMethodBeat.i(230142);
        Object systemService = this.context.getSystemService("window");
        if (!(systemService instanceof WindowManager)) {
            systemService = null;
        }
        WindowManager windowManager = (WindowManager) systemService;
        if (windowManager != null) {
            n nVar = n.JjY;
            Context context2 = this.lJI.getContext();
            p.g(context2, "contentView.context");
            View view = this.lJI;
            Display defaultDisplay = windowManager.getDefaultDisplay();
            p.g(defaultDisplay, "it.defaultDisplay");
            n.a(context2, view, null, defaultDisplay.getRotation(), this.nzn);
            AppMethodBeat.o(230142);
            return;
        }
        AppMethodBeat.o(230142);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final void onCancel() {
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final View getContentView() {
        return this.lJI;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final void ut(int i2) {
        AppMethodBeat.i(230143);
        bTt();
        AppMethodBeat.o(230143);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final boolean bjc() {
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final boolean isCancelable() {
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final boolean bjb() {
        return false;
    }
}
