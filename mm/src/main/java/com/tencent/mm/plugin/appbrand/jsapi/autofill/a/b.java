package com.tencent.mm.plugin.appbrand.jsapi.autofill.a;

import android.content.Context;
import android.graphics.Color;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.appbrand.utils.html.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001BZ\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\r¢\u0006\u0002\u0010\u0012J\b\u0010%\u001a\u00020\u0011H\u0016J\b\u0010&\u001a\u00020\u0011H\u0016J\b\u0010'\u001a\u00020\u001aH\u0016J\b\u0010(\u001a\u00020\nH\u0016J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020*H\u0016J\b\u0010,\u001a\u00020*H\u0016J\b\u0010-\u001a\u00020\u0011H\u0016J\b\u0010.\u001a\u00020\u0011H\u0016J\u0010\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\nH\u0016J\u0012\u00101\u001a\u00020\u00112\b\u00102\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R,\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u000e\u0010\"\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u000e\u0010$\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/RealnameAuthExplainDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "dialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "title", "", "content", "context", "Landroid/content/Context;", "minHeight", "", "maxHeight", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "url", "", "(Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;IILkotlin/jvm/functions/Function1;)V", "backIv", "Landroid/widget/ImageView;", "getContent", "()Ljava/lang/String;", "contentTv", "Landroid/widget/TextView;", "contentV", "Landroid/view/View;", "getContext", "()Landroid/content/Context;", "getHandler", "()Lkotlin/jvm/functions/Function1;", "getMaxHeight", "()I", "getMinHeight", "rootView", "getTitle", "titleTv", "cancel", "dismiss", "getContentView", "getPosition", "isCancelable", "", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onDismiss", "onScreenOrientationChanged", "rotation", "onShow", "dialogHelper", "plugin-appbrand-integration_release"})
public final class b implements k {
    private final String content;
    private final Context context;
    private final TextView hXC;
    private final View lJG;
    private final ImageView lJH;
    private final View lJI;
    private final m lJJ;
    final kotlin.g.a.b<String, x> lJK;
    final int maxHeight;
    final int minHeight;
    private final String title;
    private final TextView titleTv;

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: kotlin.g.a.b<? super java.lang.String, kotlin.x> */
    /* JADX WARN: Multi-variable type inference failed */
    public b(m mVar, String str, String str2, Context context2, int i2, int i3, kotlin.g.a.b<? super String, x> bVar) {
        p.h(str, "title");
        p.h(str2, "content");
        p.h(context2, "context");
        p.h(bVar, "handler");
        AppMethodBeat.i(50482);
        this.lJJ = mVar;
        this.title = str;
        this.content = str2;
        this.context = context2;
        this.minHeight = i2;
        this.maxHeight = i3;
        this.lJK = bVar;
        View inflate = View.inflate(this.context, R.layout.ei, null);
        p.g(inflate, "View.inflate(context, R.…ber_explain_dialog, null)");
        this.lJI = inflate;
        View findViewById = this.lJI.findViewById(R.id.gak);
        p.g(findViewById, "rootView.findViewById(R.…e_number_explain_content)");
        this.lJG = findViewById;
        this.lJG.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.lJG.setMinimumHeight(this.minHeight);
        this.lJG.addOnLayoutChangeListener(new View.OnLayoutChangeListener(this) {
            /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.a.b.AnonymousClass1 */
            final /* synthetic */ b lJL;

            {
                this.lJL = r1;
            }

            public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                AppMethodBeat.i(50479);
                if (Math.abs(i5 - i3) > this.lJL.maxHeight && this.lJL.maxHeight > this.lJL.minHeight) {
                    this.lJL.lJG.post(new Runnable(this) {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.a.b.AnonymousClass1.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass1 lJM;

                        {
                            this.lJM = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(50478);
                            this.lJM.lJL.lJG.setLayoutParams(new LinearLayout.LayoutParams(-1, this.lJM.lJL.maxHeight));
                            AppMethodBeat.o(50478);
                        }
                    });
                }
                AppMethodBeat.o(50479);
            }
        });
        View findViewById2 = this.lJI.findViewById(R.id.gal);
        p.g(findViewById2, "rootView.findViewById(R.…mber_explain_dialog_back)");
        this.lJH = (ImageView) findViewById2;
        ImageView imageView = this.lJH;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.a.b.AnonymousClass2 */
                final /* synthetic */ b lJL;

                {
                    this.lJL = r1;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(50480);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/RealnameAuthExplainDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    m mVar = this.lJL.lJJ;
                    if (mVar != null) {
                        mVar.c(this.lJL);
                    }
                    a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/autofill/realname_auth/RealnameAuthExplainDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(50480);
                }
            });
        }
        View findViewById3 = this.lJI.findViewById(R.id.gan);
        p.g(findViewById3, "rootView.findViewById(R.…ber_explain_dialog_title)");
        this.titleTv = (TextView) findViewById3;
        this.titleTv.setText(this.title);
        View findViewById4 = this.lJI.findViewById(R.id.gam);
        p.g(findViewById4, "rootView.findViewById(R.…r_explain_dialog_content)");
        this.hXC = (TextView) findViewById4;
        this.hXC.setText(c.a(this.content, false, (c.a) new c.a(this) {
            /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.a.b.AnonymousClass3 */
            final /* synthetic */ b lJL;

            {
                this.lJL = r1;
            }

            @Override // com.tencent.mm.plugin.appbrand.utils.html.c.a
            public final void YF(String str) {
                AppMethodBeat.i(50481);
                kotlin.g.a.b<String, x> bVar = this.lJL.lJK;
                p.g(str, "url");
                bVar.invoke(str);
                AppMethodBeat.o(50481);
            }
        }));
        this.hXC.setMovementMethod(LinkMovementMethod.getInstance());
        this.hXC.setLinkTextColor(Color.parseColor("#FF576B95"));
        AppMethodBeat.o(50482);
    }

    public final void dismiss() {
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final int getPosition() {
        return 2;
    }

    public final void cancel() {
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.dialog.k
    public final void a(m mVar) {
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
