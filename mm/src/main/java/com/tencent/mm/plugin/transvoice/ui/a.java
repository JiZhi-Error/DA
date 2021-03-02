package com.tencent.mm.plugin.transvoice.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.MMBottomSheetBehavior;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.n.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u0001:\u0002*+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\"\u001a\u00020#H\u0002J\u0012\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\u0010\u0010'\u001a\u00020#2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\b\u0010(\u001a\u00020#H\u0016J\u0006\u0010)\u001a\u00020#R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u000fj\b\u0012\u0004\u0012\u00020\u0017`\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog;", "Landroid/support/v7/app/AppCompatDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bottomSheetBehavior", "Landroid/support/design/widget/MMBottomSheetBehavior;", "Landroid/view/View;", "canClosePanel", "", "closePanel", "Landroid/widget/ImageView;", "containerView", "Landroid/widget/LinearLayout;", "langStringArr", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getLangStringArr", "()Ljava/util/ArrayList;", "setLangStringArr", "(Ljava/util/ArrayList;)V", "langType", "", "getLangType", "()I", "setLangType", "(I)V", "langTypeArr", "getLangTypeArr", "setLangTypeArr", "onLanguageItemClick", "Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "targetView", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setOnLanguageItemClick", "show", "updateSelectedType", "Companion", "OnLanguageItemClick", "plugin-transvoice_release"})
public final class a extends android.support.v7.app.e {
    public static final C1842a Gul = new C1842a((byte) 0);
    private ImageView Guf;
    ArrayList<Integer> Gug = new ArrayList<>();
    private ArrayList<String> Guh = new ArrayList<>();
    private MMBottomSheetBehavior<View> Gui;
    private boolean Guj;
    b Guk;
    private LinearLayout containerView;
    int jvS = g.jwq;
    private View targetView;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$OnLanguageItemClick;", "", "onLanguageItemClick", "", "langType", "", "plugin-transvoice_release"})
    public interface b {
        void acp(int i2);
    }

    static {
        AppMethodBeat.i(102557);
        AppMethodBeat.o(102557);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context, R.style.zq);
        p.h(context, "context");
        AppMethodBeat.i(102556);
        gR();
        int i2 = h.aqJ().getInt("VoiceInputLanguageSupportType", g.jwq);
        if (LocaleUtil.isChineseAppLang()) {
            this.Guh.add(getContext().getString(R.string.ec2));
            this.Gug.add(Integer.valueOf(g.jwq));
            if ((g.jwr & i2) != 0) {
                this.Guh.add(getContext().getString(R.string.ec0));
                this.Gug.add(Integer.valueOf(g.jwr));
            }
            if ((g.jws & i2) != 0) {
                this.Guh.add(getContext().getString(R.string.ec1));
                this.Gug.add(Integer.valueOf(g.jws));
            }
            if ((i2 & g.jwt) != 0) {
                this.Guh.add(getContext().getString(R.string.ec3));
                this.Gug.add(Integer.valueOf(g.jwt));
                AppMethodBeat.o(102556);
                return;
            }
        } else if (LocaleUtil.getApplicationLanguage().equals(LocaleUtil.ENGLISH)) {
            this.Guh.add(getContext().getString(R.string.ec1));
            this.Gug.add(Integer.valueOf(g.jws));
            this.Guh.add(getContext().getString(R.string.ec2));
            this.Gug.add(Integer.valueOf(g.jwq));
            if ((i2 & g.jwr) != 0) {
                this.Guh.add(getContext().getString(R.string.ec0));
                this.Gug.add(Integer.valueOf(g.jwr));
            }
        }
        AppMethodBeat.o(102556);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$Companion;", "", "()V", "MODE_ONLY_PANEL_CLOSE_PANEL_OFFSET", "", "TAG", "", "plugin-transvoice_release"})
    /* renamed from: com.tencent.mm.plugin.transvoice.ui.a$a  reason: collision with other inner class name */
    public static final class C1842a {
        private C1842a() {
        }

        public /* synthetic */ C1842a(byte b2) {
            this();
        }
    }

    @Override // android.support.v7.app.e
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(102553);
        this.targetView = LayoutInflater.from(getContext()).inflate(R.layout.ay3, (ViewGroup) null, false);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        View view = this.targetView;
        if (view == null) {
            p.hyc();
        }
        setContentView(view, layoutParams);
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.addFlags(67108864);
            window.setLayout(-1, -1);
            window.setSoftInputMode(34);
            window.setDimAmount(0.5f);
            window.setWindowAnimations(R.style.fs);
        }
        View view2 = this.targetView;
        if (view2 != null) {
            this.Guf = (ImageView) view2.findViewById(R.id.b4j);
            this.containerView = (LinearLayout) view2.findViewById(R.id.e7j);
        }
        ImageView imageView = this.Guf;
        if (imageView != null) {
            imageView.setOnClickListener(new c(this));
        }
        View view3 = this.targetView;
        this.Gui = MMBottomSheetBehavior.x(view3 != null ? view3.findViewById(R.id.gs3) : null);
        MMBottomSheetBehavior<View> mMBottomSheetBehavior = this.Gui;
        if (mMBottomSheetBehavior != null) {
            mMBottomSheetBehavior.a(new d(this));
        }
        fAw();
        AppMethodBeat.o(102553);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ a Gum;

        c(a aVar) {
            this.Gum = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(102549);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.Gum.dismiss();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(102549);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$init$3", "Landroid/support/design/widget/MMBottomSheetBehavior$BottomSheetCallback;", "onSlide", "", "bottomSheet", "Landroid/view/View;", "slideOffset", "", "onStateChanged", "newState", "", "plugin-transvoice_release"})
    public static final class d extends MMBottomSheetBehavior.a {
        final /* synthetic */ a Gum;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(a aVar) {
            this.Gum = aVar;
        }

        @Override // android.support.design.widget.MMBottomSheetBehavior.a
        public final void b(View view, float f2) {
            AppMethodBeat.i(102550);
            p.h(view, "bottomSheet");
            this.Gum.Guj = 0.7f >= f2;
            AppMethodBeat.o(102550);
        }

        @Override // android.support.design.widget.MMBottomSheetBehavior.a
        public final void f(View view, int i2) {
            AppMethodBeat.i(102551);
            p.h(view, "bottomSheet");
            if (2 == i2) {
                if (this.Gum.Guj) {
                    this.Gum.dismiss();
                    AppMethodBeat.o(102551);
                    return;
                }
                MMBottomSheetBehavior mMBottomSheetBehavior = this.Gum.Gui;
                if (mMBottomSheetBehavior != null) {
                    mMBottomSheetBehavior.cU();
                    AppMethodBeat.o(102551);
                    return;
                }
            }
            AppMethodBeat.o(102551);
        }
    }

    public final void fAw() {
        AppMethodBeat.i(102554);
        LinearLayout linearLayout = this.containerView;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        int i2 = 0;
        for (T t : this.Gug) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            int intValue = t.intValue();
            View inflate = getLayoutInflater().inflate(R.layout.ay4, (ViewGroup) null);
            if (inflate == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout");
                AppMethodBeat.o(102554);
                throw tVar;
            }
            FrameLayout frameLayout = (FrameLayout) inflate;
            ((TextView) frameLayout.findViewById(R.id.e7m)).setText(this.Guh.get(i2));
            View findViewById = frameLayout.findViewById(R.id.e7l);
            p.g(findViewById, "item.findViewById<View>(…language_choice_selected)");
            findViewById.setVisibility(intValue == this.jvS ? 0 : 4);
            frameLayout.setOnClickListener(new e(intValue, this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            LinearLayout linearLayout2 = this.containerView;
            if (linearLayout2 != null) {
                linearLayout2.addView(frameLayout, layoutParams);
                i2 = i3;
            } else {
                i2 = i3;
            }
        }
        AppMethodBeat.o(102554);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$updateSelectedType$1$1"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ int $type;
        final /* synthetic */ a Gum;

        e(int i2, a aVar) {
            this.$type = i2;
            this.Gum = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(102552);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$updateSelectedType$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.Gum.jvS = this.$type;
            this.Gum.fAw();
            b bVar2 = this.Gum.Guk;
            if (bVar2 != null) {
                bVar2.acp(this.Gum.jvS);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/transvoice/ui/LanguageChoiceDialog$updateSelectedType$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(102552);
        }
    }

    public final void show() {
        AppMethodBeat.i(102555);
        super.show();
        MMBottomSheetBehavior<View> mMBottomSheetBehavior = this.Gui;
        if (mMBottomSheetBehavior != null) {
            mMBottomSheetBehavior.cU();
            AppMethodBeat.o(102555);
            return;
        }
        AppMethodBeat.o(102555);
    }
}
