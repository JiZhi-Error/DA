package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u00105\u001a\u00020\u0016H\u0002J\b\u00106\u001a\u00020\u0016H\u0002J\b\u00107\u001a\u00020\u0016H\u0002J\u0012\u00108\u001a\u00020\u00162\b\u00109\u001a\u0004\u0018\u00010:H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u0010\u0010$\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u000f\"\u0004\b+\u0010\u0011R\u001a\u0010,\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u000f\"\u0004\b.\u0010\u0011R\u001a\u0010/\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u000f\"\u0004\b1\u0010\u0011R\u001a\u00102\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u000f\"\u0004\b4\u0010\u0011¨\u0006;"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog;", "Landroid/support/design/widget/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "delete", "Landroid/view/View;", "deleteIcon", "Landroid/widget/ImageView;", "favorite", "favoriteIcon", "favoriteTv", "Landroid/widget/TextView;", "isFavorite", "", "()Z", "setFavorite", "(Z)V", "isPrivacy", "setPrivacy", "onDelete", "Lkotlin/Function0;", "", "getOnDelete", "()Lkotlin/jvm/functions/Function0;", "setOnDelete", "(Lkotlin/jvm/functions/Function0;)V", "onResend", "getOnResend", "setOnResend", "onSetFavorite", "getOnSetFavorite", "setOnSetFavorite", "onSetPrivacy", "getOnSetPrivacy", "setOnSetPrivacy", ShareConstants.WEB_DIALOG_PARAM_PRIVACY, "privacyIcon", "privacyTv", "resend", "resendIcon", "showDelete", "getShowDelete", "setShowDelete", "showFavorite", "getShowFavorite", "setShowFavorite", "showPrivacy", "getShowPrivacy", "setShowPrivacy", "showResend", "getShowResend", "setShowResend", "initDelBtn", "initFavoriteBtn", "initPrivacyBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "plugin-story_release"})
public final class a extends android.support.design.widget.a {
    private View Cdl;
    private TextView Cdm;
    private ImageView Cdn;
    boolean EHQ;
    kotlin.g.a.a<x> FEA;
    kotlin.g.a.a<x> FEB;
    kotlin.g.a.a<x> FEC;
    boolean FED;
    boolean FEE = true;
    boolean FEF;
    boolean FEG = true;
    private View FEt;
    private View FEu;
    private View FEv;
    private ImageView FEw;
    private ImageView FEx;
    private TextView FEy;
    kotlin.g.a.a<x> FEz;
    boolean nze = true;
    private ImageView ruA;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(120325);
        setContentView(R.layout.bzu);
        AppMethodBeat.o(120325);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ a FEH;

        c(a aVar) {
            this.FEH = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(120322);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initPrivacyBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.a<x> aVar = this.FEH.FEB;
            if (aVar != null) {
                aVar.invoke();
            }
            this.FEH.dismiss();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initPrivacyBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(120322);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ a FEH;

        b(a aVar) {
            this.FEH = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(120321);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initFavoriteBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.a<x> aVar = this.FEH.FEC;
            if (aVar != null) {
                aVar.invoke();
            }
            this.FEH.dismiss();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initFavoriteBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(120321);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.a$a  reason: collision with other inner class name */
    static final class View$OnClickListenerC1785a implements View.OnClickListener {
        final /* synthetic */ a FEH;

        View$OnClickListenerC1785a(a aVar) {
            this.FEH = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(120320);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initDelBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.a<x> aVar = this.FEH.FEz;
            if (aVar != null) {
                aVar.invoke();
            }
            this.FEH.dismiss();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$initDelBtn$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(120320);
        }
    }

    @Override // android.support.v7.app.e, android.support.design.widget.a
    public final void onCreate(Bundle bundle) {
        View view;
        AppMethodBeat.i(120324);
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.addFlags(134218752);
            window.clearFlags(2);
        }
        this.FEt = findViewById(R.id.i99);
        this.FEu = findViewById(R.id.i9g);
        this.FEv = findViewById(R.id.i9d);
        this.ruA = (ImageView) findViewById(R.id.i9_);
        this.FEw = (ImageView) findViewById(R.id.i9h);
        this.FEx = (ImageView) findViewById(R.id.i9e);
        this.FEy = (TextView) findViewById(R.id.i9f);
        this.Cdl = findViewById(R.id.i9a);
        this.Cdl = findViewById(R.id.i9a);
        this.Cdm = (TextView) findViewById(R.id.i9c);
        this.Cdn = (ImageView) findViewById(R.id.i9b);
        Context context = getContext();
        p.g(context, "context");
        int color = context.getResources().getColor(R.color.Red);
        ImageView imageView = this.ruA;
        if (imageView != null) {
            imageView.setImageDrawable(ar.m(getContext(), R.raw.delete_icon_nor, color));
        }
        ImageView imageView2 = this.FEw;
        if (imageView2 != null) {
            Context context2 = getContext();
            Context context3 = getContext();
            p.g(context3, "context");
            imageView2.setImageDrawable(ar.m(context2, R.raw.icons_outlined_refresh, context3.getResources().getColor(R.color.BW_0_Alpha_0_9)));
        }
        ImageView imageView3 = this.Cdn;
        if (imageView3 != null) {
            Context context4 = getContext();
            Context context5 = getContext();
            p.g(context5, "context");
            imageView3.setImageDrawable(ar.m(context4, R.raw.icons_outlined_star, context5.getResources().getColor(R.color.BW_0_Alpha_0_9)));
        }
        View view2 = this.FEu;
        if (view2 != null) {
            view2.setOnClickListener(new d(this));
        }
        if (this.FED && (view = this.FEu) != null) {
            view.setVisibility(0);
        }
        if (this.nze) {
            View view3 = this.FEt;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            View view4 = this.FEt;
            if (view4 != null) {
                view4.setOnClickListener(new View$OnClickListenerC1785a(this));
            }
        } else {
            View view5 = this.FEt;
            if (view5 != null) {
                view5.setVisibility(8);
            }
        }
        if (this.FEE) {
            View view6 = this.FEv;
            if (view6 != null) {
                view6.setVisibility(0);
            }
            View view7 = this.FEv;
            if (view7 != null) {
                view7.setOnClickListener(new c(this));
            }
            if (this.EHQ) {
                ImageView imageView4 = this.FEx;
                if (imageView4 != null) {
                    Context context6 = getContext();
                    Context context7 = getContext();
                    p.g(context7, "context");
                    imageView4.setImageDrawable(ar.m(context6, R.raw.icons_outlined_unlock, context7.getResources().getColor(R.color.BW_0_Alpha_0_9)));
                }
                TextView textView = this.FEy;
                if (textView != null) {
                    textView.setText(getContext().getString(R.string.hh7));
                }
            } else {
                ImageView imageView5 = this.FEx;
                if (imageView5 != null) {
                    Context context8 = getContext();
                    Context context9 = getContext();
                    p.g(context9, "context");
                    imageView5.setImageDrawable(ar.m(context8, R.raw.icons_outlined_lock, context9.getResources().getColor(R.color.BW_0_Alpha_0_9)));
                }
                TextView textView2 = this.FEy;
                if (textView2 != null) {
                    textView2.setText(getContext().getString(R.string.hh8));
                }
            }
        } else {
            View view8 = this.FEv;
            if (view8 != null) {
                view8.setVisibility(8);
            }
        }
        if (!this.FEG || !com.tencent.mm.plugin.story.c.a.a.FkW.fnd()) {
            View view9 = this.Cdl;
            if (view9 != null) {
                view9.setVisibility(8);
            }
        } else {
            View view10 = this.Cdl;
            if (view10 != null) {
                view10.setVisibility(0);
            }
            View view11 = this.Cdl;
            if (view11 != null) {
                view11.setOnClickListener(new b(this));
            }
            if (this.FEF) {
                TextView textView3 = this.Cdm;
                if (textView3 != null) {
                    textView3.setText(getContext().getString(R.string.hh6));
                }
            } else {
                TextView textView4 = this.Cdm;
                if (textView4 != null) {
                    textView4.setText(getContext().getString(R.string.hh5));
                }
            }
        }
        View findViewById = findViewById(R.id.bn_);
        if (findViewById != null) {
            findViewById.setBackgroundResource(R.color.ac_);
            AppMethodBeat.o(120324);
            return;
        }
        AppMethodBeat.o(120324);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ a FEH;

        d(a aVar) {
            this.FEH = aVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(120323);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.a<x> aVar = this.FEH.FEA;
            if (aVar != null) {
                aVar.invoke();
            }
            this.FEH.dismiss();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(120323);
        }
    }
}
