package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010%\u001a\u00020\u0017H\u0002J\b\u0010&\u001a\u00020\u0017H\u0002J\b\u0010'\u001a\u00020\u0017H\u0002J\u0012\u0010(\u001a\u00020\u00172\b\u0010)\u001a\u0004\u0018\u00010*H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u0010\u0010\"\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorMoreDialog;", "Landroid/support/design/widget/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "favorite", "Landroid/view/View;", "favoriteIcon", "Landroid/widget/ImageView;", "favoriteTv", "Landroid/widget/TextView;", "isFavorite", "", "()Z", "setFavorite", "(Z)V", "isNotifySns", "setNotifySns", "notifySns", "notifySnsIcon", "notifySnsTv", "onNotifySns", "Lkotlin/Function0;", "", "getOnNotifySns", "()Lkotlin/jvm/functions/Function0;", "setOnNotifySns", "(Lkotlin/jvm/functions/Function0;)V", "onSelectRange", "getOnSelectRange", "setOnSelectRange", "onSetFav", "getOnSetFav", "setOnSetFav", "rangeIcon", "rangeTv", "rangeView", "initFavoriteBtn", "initNotifySnsBtn", "initRangeBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-recordvideo_release"})
public final class e extends android.support.design.widget.a {
    private View Cdi;
    private TextView Cdj;
    private ImageView Cdk;
    private View Cdl;
    private TextView Cdm;
    private ImageView Cdn;
    private View Cdo;
    private TextView Cdp;
    private ImageView Cdq;
    public kotlin.g.a.a<x> Cdr;
    public boolean Cds = true;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(76012);
        setContentView(R.layout.bzy);
        AppMethodBeat.o(76012);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ e Cdt;

        a(e eVar) {
            this.Cdt = eVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(76010);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/EditorMoreDialog$initNotifySnsBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.a<x> aVar = this.Cdt.Cdr;
            if (aVar != null) {
                aVar.invoke();
            }
            this.Cdt.dismiss();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/EditorMoreDialog$initNotifySnsBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(76010);
        }
    }

    @Override // android.support.v7.app.e, android.support.design.widget.a
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(76011);
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.addFlags(134218752);
            window.clearFlags(2);
        }
        this.Cdl = findViewById(R.id.i_r);
        this.Cdm = (TextView) findViewById(R.id.i_t);
        this.Cdn = (ImageView) findViewById(R.id.i_s);
        this.Cdi = findViewById(R.id.i_u);
        this.Cdj = (TextView) findViewById(R.id.i_w);
        this.Cdk = (ImageView) findViewById(R.id.i_v);
        this.Cdo = findViewById(R.id.i_x);
        this.Cdp = (TextView) findViewById(R.id.i_z);
        this.Cdq = (ImageView) findViewById(R.id.i_y);
        if (!com.tencent.mm.plugin.recordvideo.b.a.a.BNL.eJD()) {
            View view = this.Cdi;
            if (view != null) {
                view.setVisibility(8);
            }
        } else {
            View view2 = this.Cdi;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            View view3 = this.Cdi;
            if (view3 != null) {
                view3.setOnClickListener(new a(this));
            }
            if (this.Cds) {
                TextView textView = this.Cdj;
                if (textView != null) {
                    Context context = getContext();
                    p.g(context, "context");
                    textView.setText(context.getResources().getString(R.string.hhp));
                }
                ImageView imageView = this.Cdk;
                if (imageView != null) {
                    Context context2 = getContext();
                    Context context3 = getContext();
                    p.g(context3, "context");
                    imageView.setImageDrawable(ar.m(context2, R.raw.icons_outlined_moment_off, context3.getResources().getColor(R.color.BW_0_Alpha_0_9)));
                }
            } else {
                TextView textView2 = this.Cdj;
                if (textView2 != null) {
                    Context context4 = getContext();
                    p.g(context4, "context");
                    textView2.setText(context4.getResources().getString(R.string.hhq));
                }
                ImageView imageView2 = this.Cdk;
                if (imageView2 != null) {
                    Context context5 = getContext();
                    Context context6 = getContext();
                    p.g(context6, "context");
                    imageView2.setImageDrawable(ar.m(context5, R.raw.icons_outlined_moment, context6.getResources().getColor(R.color.BW_0_Alpha_0_9)));
                }
            }
        }
        View view4 = this.Cdl;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        View view5 = this.Cdo;
        if (view5 != null) {
            view5.setVisibility(8);
        }
        View findViewById = findViewById(R.id.bn_);
        if (findViewById != null) {
            findViewById.setBackgroundResource(R.color.ac_);
            AppMethodBeat.o(76011);
            return;
        }
        AppMethodBeat.o(76011);
    }
}
