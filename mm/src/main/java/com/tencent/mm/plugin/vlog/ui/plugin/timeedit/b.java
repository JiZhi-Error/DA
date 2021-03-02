package com.tencent.mm.plugin.vlog.ui.plugin.timeedit;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001>B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020.H\u0002J\u0006\u0010/\u001a\u00020\nJ \u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020.H\u0002J\u0012\u00104\u001a\u00020\n2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0016\u00107\u001a\u00020\n2\u0006\u0010,\u001a\u00020.2\u0006\u00108\u001a\u00020\"J\u0006\u00109\u001a\u00020\nJ\u0010\u0010:\u001a\u00020\n2\b\b\u0002\u0010;\u001a\u00020\"J\u0010\u0010<\u001a\u00020\n2\b\b\u0002\u0010;\u001a\u00020\"J\u0006\u0010=\u001a\u00020\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR\u000e\u0010\u001d\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\"\u0010$\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u000e\u0010'\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R#\u0010(\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118BX\u0002¢\u0006\f\n\u0004\b*\u0010\u0016\u001a\u0004\b)\u0010\u0014¨\u0006?"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditMenuView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "captionMenu", "Landroid/view/ViewGroup;", "deleteListener", "Lkotlin/Function0;", "", "getDeleteListener", "()Lkotlin/jvm/functions/Function0;", "setDeleteListener", "(Lkotlin/jvm/functions/Function0;)V", "deleteMenu", "downDrawable", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "getDownDrawable", "()Landroid/graphics/drawable/Drawable;", "downDrawable$delegate", "Lkotlin/Lazy;", "editCaptionListener", "getEditCaptionListener", "setEditCaptionListener", "editContentListener", "getEditContentListener", "setEditContentListener", "editMenu", "editTimeListener", "getEditTimeListener", "setEditTimeListener", "enableReadMenu", "", "readMenu", "readTextListener", "getReadTextListener", "setReadTextListener", "timeMenu", "upDrawable", "getUpDrawable", "upDrawable$delegate", "doSetMenuChecked", "menu", "visibility", "", "downBackground", "loadMenuLayout", "layout", "iconRes", "titleRes", "onClick", "v", "Landroid/view/View;", "setMenuChecked", "checked", "showCaptionMenu", "showNormalMenu", "enableTimeEdit", "showTextMenu", "upwardsBackground", "Companion", "plugin-vlog_release"})
public final class b extends LinearLayout implements View.OnClickListener {
    public static final a GNa = new a((byte) 0);
    private kotlin.g.a.a<x> GMM;
    private kotlin.g.a.a<x> GMN;
    private kotlin.g.a.a<x> GMO;
    private kotlin.g.a.a<x> GMP;
    private kotlin.g.a.a<x> GMQ;
    ViewGroup GMR;
    private ViewGroup GMS;
    ViewGroup GMU;
    ViewGroup GMV;
    ViewGroup GMW;
    final boolean GMX = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_edit_text_to_voice, false);
    private final f GMY = kotlin.g.ah(new c(this));
    private final f GMZ = kotlin.g.ah(new C1876b(this));

    static {
        AppMethodBeat.i(191901);
        AppMethodBeat.o(191901);
    }

    private final Drawable getDownDrawable() {
        AppMethodBeat.i(191894);
        Drawable drawable = (Drawable) this.GMZ.getValue();
        AppMethodBeat.o(191894);
        return drawable;
    }

    private final Drawable getUpDrawable() {
        AppMethodBeat.i(191893);
        Drawable drawable = (Drawable) this.GMY.getValue();
        AppMethodBeat.o(191893);
        return drawable;
    }

    public b(Context context) {
        super(context);
        AppMethodBeat.i(191900);
        LayoutInflater.from(context).inflate(R.layout.c34, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.e37);
        p.g(findViewById, "findViewById(R.id.item_menu_time)");
        this.GMR = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.e34);
        p.g(findViewById2, "findViewById(R.id.item_menu_delete)");
        this.GMS = (ViewGroup) findViewById2;
        View findViewById3 = findViewById(R.id.e35);
        p.g(findViewById3, "findViewById(R.id.item_menu_edit)");
        this.GMU = (ViewGroup) findViewById3;
        View findViewById4 = findViewById(R.id.e33);
        p.g(findViewById4, "findViewById(R.id.item_menu_caption)");
        this.GMV = (ViewGroup) findViewById4;
        View findViewById5 = findViewById(R.id.e36);
        p.g(findViewById5, "findViewById(R.id.item_menu_read)");
        this.GMW = (ViewGroup) findViewById5;
        if (!this.GMX) {
            this.GMW.setVisibility(8);
        }
        e(this.GMR, R.raw.icons_filled_time, R.string.hy_);
        e(this.GMS, R.raw.icons_filled_delete, R.string.hy7);
        e(this.GMU, R.raw.icons_filled_pencil, R.string.hy8);
        e(this.GMV, R.raw.icons_filled_caption, R.string.hy6);
        e(this.GMW, R.raw.icons_filled_talk, R.string.hy9);
        AppMethodBeat.o(191900);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditMenuView$Companion;", "", "()V", "MENU_CAPTION", "", "MENU_DELETE", "MENU_EDIT", "MENU_READ", "MENU_TIME", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final kotlin.g.a.a<x> getEditTimeListener() {
        return this.GMM;
    }

    public final void setEditTimeListener(kotlin.g.a.a<x> aVar) {
        this.GMM = aVar;
    }

    public final kotlin.g.a.a<x> getDeleteListener() {
        return this.GMN;
    }

    public final void setDeleteListener(kotlin.g.a.a<x> aVar) {
        this.GMN = aVar;
    }

    public final kotlin.g.a.a<x> getEditContentListener() {
        return this.GMO;
    }

    public final void setEditContentListener(kotlin.g.a.a<x> aVar) {
        this.GMO = aVar;
    }

    public final kotlin.g.a.a<x> getEditCaptionListener() {
        return this.GMP;
    }

    public final void setEditCaptionListener(kotlin.g.a.a<x> aVar) {
        this.GMP = aVar;
    }

    public final kotlin.g.a.a<x> getReadTextListener() {
        return this.GMQ;
    }

    public final void setReadTextListener(kotlin.g.a.a<x> aVar) {
        this.GMQ = aVar;
    }

    public final void onClick(View view) {
        kotlin.g.a.a<x> aVar;
        AppMethodBeat.i(191895);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditMenuView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.e34) {
            kotlin.g.a.a<x> aVar2 = this.GMN;
            if (aVar2 != null) {
                aVar2.invoke();
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.e37) {
            kotlin.g.a.a<x> aVar3 = this.GMM;
            if (aVar3 != null) {
                aVar3.invoke();
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.e35) {
            kotlin.g.a.a<x> aVar4 = this.GMO;
            if (aVar4 != null) {
                aVar4.invoke();
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.e33) {
            kotlin.g.a.a<x> aVar5 = this.GMP;
            if (aVar5 != null) {
                aVar5.invoke();
            }
        } else if (!(valueOf == null || valueOf.intValue() != R.id.e36 || (aVar = this.GMQ) == null)) {
            aVar.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/timeedit/TimeEditMenuView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191895);
    }

    private final void e(ViewGroup viewGroup, int i2, int i3) {
        AppMethodBeat.i(191896);
        View findViewById = viewGroup.findViewById(R.id.ipm);
        p.g(findViewById, "layout.findViewById<TextView>(R.id.title)");
        ((TextView) findViewById).setText(com.tencent.mm.cb.a.aI(getContext(), i3));
        ((WeImageView) viewGroup.findViewById(R.id.dt5)).setImageResource(i2);
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.azg);
        if (imageView != null) {
            imageView.setImageDrawable(com.tencent.mm.cb.a.l(getContext(), R.raw.popvideo_post_selected_origin));
        }
        viewGroup.setOnClickListener(this);
        AppMethodBeat.o(191896);
    }

    public final void setMenuChecked$2563266(boolean z) {
        AppMethodBeat.i(191897);
        int i2 = z ? 0 : 4;
        View findViewById = this.GMW.findViewById(R.id.azg);
        if (findViewById != null) {
            findViewById.setVisibility(i2);
            AppMethodBeat.o(191897);
            return;
        }
        AppMethodBeat.o(191897);
    }

    public final void fEo() {
        AppMethodBeat.i(191898);
        setBackground(getUpDrawable());
        AppMethodBeat.o(191898);
    }

    public final void fEp() {
        AppMethodBeat.i(191899);
        setBackground(getDownDrawable());
        AppMethodBeat.o(191899);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends q implements kotlin.g.a.a<Drawable> {
        final /* synthetic */ b GNb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(b bVar) {
            super(0);
            this.GNb = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Drawable invoke() {
            AppMethodBeat.i(191892);
            Drawable l = com.tencent.mm.cb.a.l(this.GNb.getContext(), R.drawable.c5y);
            AppMethodBeat.o(191892);
            return l;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.vlog.ui.plugin.timeedit.b$b  reason: collision with other inner class name */
    static final class C1876b extends q implements kotlin.g.a.a<Drawable> {
        final /* synthetic */ b GNb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1876b(b bVar) {
            super(0);
            this.GNb = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Drawable invoke() {
            AppMethodBeat.i(191891);
            Drawable l = com.tencent.mm.cb.a.l(this.GNb.getContext(), R.drawable.c5x);
            AppMethodBeat.o(191891);
            return l;
        }
    }
}
