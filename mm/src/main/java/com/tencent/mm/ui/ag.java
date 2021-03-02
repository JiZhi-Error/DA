package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.multitalk.d.f;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000e\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u000203J\u0018\u00104\u001a\u0004\u0018\u00010\u00172\u0006\u00102\u001a\u0002032\u0006\u00105\u001a\u000206J\u0018\u00107\u001a\u0004\u0018\u00010\u00172\u0006\u00102\u001a\u0002032\u0006\u00105\u001a\u000206J\u0006\u00108\u001a\u00020\u0006R$\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001c\u0010%\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\u001c\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-¨\u00069"}, hxF = {"Lcom/tencent/mm/ui/ScreenProfileReadyPluginUI;", "", "filePath", "", "callback", "Lkotlin/Function0;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getCallback", "()Lkotlin/jvm/functions/Function0;", "setCallback", "(Lkotlin/jvm/functions/Function0;)V", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "indexLayout", "Landroid/widget/TextView;", "getIndexLayout", "()Landroid/widget/TextView;", "setIndexLayout", "(Landroid/widget/TextView;)V", "indexRootLayout", "Landroid/view/View;", "getIndexRootLayout", "()Landroid/view/View;", "setIndexRootLayout", "(Landroid/view/View;)V", "mCurrentIndex", "", "getMCurrentIndex", "()I", "setMCurrentIndex", "(I)V", "maxCount", "getMaxCount", "setMaxCount", "readerLayout", "getReaderLayout", "setReaderLayout", "readerLayoutRootView", "Landroid/widget/RelativeLayout;", "getReaderLayoutRootView", "()Landroid/widget/RelativeLayout;", "setReaderLayoutRootView", "(Landroid/widget/RelativeLayout;)V", "startBtn", "getStartBtn", "setStartBtn", "applyClickEvent", "context", "Landroid/content/Context;", "getLandscapeLayout", "rootView", "Landroid/view/ViewGroup;", "getPortraitLayout", "refreshIndexLayout", "app_release"})
public final class ag {
    private RelativeLayout OKA;
    private RelativeLayout OKB;
    private View OKx;
    private TextView OKy;
    private View OKz;
    String filePath;
    public int maxCount;
    public int rmJ;
    private kotlin.g.a.a<x> uGD;

    private ag(String str) {
        p.h(str, "filePath");
        AppMethodBeat.i(231172);
        this.filePath = str;
        this.uGD = null;
        AppMethodBeat.o(231172);
    }

    public /* synthetic */ ag(String str, byte b2) {
        this(str);
    }

    public final View f(Context context, ViewGroup viewGroup) {
        AppMethodBeat.i(231168);
        p.h(context, "context");
        p.h(viewGroup, "rootView");
        this.OKx = LayoutInflater.from(context).inflate(R.layout.boh, viewGroup);
        jR(context);
        View view = this.OKx;
        AppMethodBeat.o(231168);
        return view;
    }

    public final View g(Context context, ViewGroup viewGroup) {
        AppMethodBeat.i(231169);
        p.h(context, "context");
        p.h(viewGroup, "rootView");
        this.OKx = LayoutInflater.from(context).inflate(R.layout.boi, viewGroup);
        jR(context);
        View view = this.OKx;
        AppMethodBeat.o(231169);
        return view;
    }

    private void jR(Context context) {
        TextView textView;
        View view;
        RelativeLayout relativeLayout;
        AppMethodBeat.i(231170);
        p.h(context, "context");
        View view2 = this.OKx;
        this.OKB = view2 != null ? (RelativeLayout) view2.findViewById(R.id.hbw) : null;
        View view3 = this.OKx;
        if (view3 != null) {
            textView = (TextView) view3.findViewById(R.id.hbx);
        } else {
            textView = null;
        }
        this.OKy = textView;
        TextView textView2 = this.OKy;
        if (textView2 != null) {
            textView2.setVisibility(4);
        }
        View view4 = this.OKx;
        if (view4 != null) {
            view = view4.findViewById(R.id.hby);
        } else {
            view = null;
        }
        this.OKz = view;
        View view5 = this.OKz;
        if (view5 != null) {
            view5.setVisibility(4);
        }
        View view6 = this.OKx;
        if (view6 != null) {
            relativeLayout = (RelativeLayout) view6.findViewById(R.id.hc0);
        } else {
            relativeLayout = null;
        }
        this.OKA = relativeLayout;
        RelativeLayout relativeLayout2 = this.OKA;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(4);
        }
        RelativeLayout relativeLayout3 = this.OKA;
        if (relativeLayout3 != null) {
            relativeLayout3.setOnClickListener(new a(this, context));
            AppMethodBeat.o(231170);
            return;
        }
        AppMethodBeat.o(231170);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class a implements View.OnClickListener {
        final /* synthetic */ Context $context;
        final /* synthetic */ ag OKC;

        a(ag agVar, Context context) {
            this.OKC = agVar;
            this.$context = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(231167);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/ScreenProfileReadyPluginUI$applyClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            q eom = ac.eom();
            p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
            if (eom.emr()) {
                Intent intent = new Intent(this.$context, MultiTalkMainUI.class);
                intent.setFlags(603979776);
                intent.putExtra("filePath", this.OKC.filePath);
                f fVar = f.zZd;
                f.eqm();
                Context context = this.$context;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/ScreenProfileReadyPluginUI$applyClickEvent$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/ScreenProfileReadyPluginUI$applyClickEvent$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } else {
                u.cH(this.$context, this.$context.getString(R.string.geo));
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/ScreenProfileReadyPluginUI$applyClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(231167);
        }
    }

    public final void gJA() {
        AppMethodBeat.i(231171);
        RelativeLayout relativeLayout = this.OKA;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        View view = this.OKx;
        this.OKz = view != null ? view.findViewById(R.id.hby) : null;
        View view2 = this.OKz;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        TextView textView = this.OKy;
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = this.OKy;
        if (textView2 != null) {
            textView2.setText(new StringBuilder().append(this.rmJ + 1).append('/').append(this.maxCount).toString());
            AppMethodBeat.o(231171);
            return;
        }
        AppMethodBeat.o(231171);
    }
}
