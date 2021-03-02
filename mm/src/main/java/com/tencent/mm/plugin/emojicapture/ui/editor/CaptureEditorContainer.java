package com.tencent.mm.plugin.emojicapture.ui.editor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.hilive.mediasdk.SdkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.api.ac;
import com.tencent.mm.api.ad;
import com.tencent.mm.api.r;
import com.tencent.mm.plugin.appbrand.jsapi.k.ab;
import com.tencent.mm.plugin.appbrand.jsapi.pay.g;
import com.tencent.mm.plugin.appbrand.jsapi.x.d;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.c.b;
import com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView;
import com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView;
import com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\r\n\u0002\b\u0003*\u00017\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u0011H\u0002J(\u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\n2\u0006\u0010C\u001a\u00020\n2\u0006\u0010B\u001a\u00020\n2\u0006\u0010D\u001a\u00020\nH\u0002J\b\u0010E\u001a\u00020?H\u0016J\b\u0010F\u001a\u00020\u001bH\u0016J\n\u0010G\u001a\u0004\u0018\u00010:H\u0016J\b\u0010H\u001a\u00020?H\u0002J\b\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020JH\u0016J\b\u0010L\u001a\u00020JH\u0016J\u0012\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010NH\u0016J\b\u0010P\u001a\u00020?H\u0016J\u000e\u0010Q\u001a\u00020?2\u0006\u0010(\u001a\u00020)J\u0010\u0010R\u001a\u00020?2\u0006\u0010S\u001a\u00020\nH\u0016J8\u0010T\u001a\u00020?2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010U\u001a\u00020\r2\u0006\u0010V\u001a\u00020J2\u0006\u0010W\u001a\u00020J2\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010>H\u0016J\u0010\u0010X\u001a\u00020?2\u0006\u0010Y\u001a\u00020JH\u0016J\"\u0010Z\u001a\u00020?2\u0006\u0010Y\u001a\u00020J2\b\u0010[\u001a\u0004\u0018\u00010\\2\u0006\u0010]\u001a\u00020\nH\u0016J\b\u0010^\u001a\u00020?H\u0016R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0010\u00106\u001a\u000207X\u0004¢\u0006\u0004\n\u0002\u00108R\u0010\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010=\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "addEmojiIcon", "Landroid/widget/ImageView;", "addEmojiIconNor", "Landroid/graphics/drawable/Drawable;", "addEmojiIconSel", "addEmojiView", "Landroid/view/View;", "backBtn", "captureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "changeTextRoot", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorChangeTextView;", "editorItemContainer", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "editorTypeRoot", "mixBtn", "presenter", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;)V", "removeBgIcon", "removeBgIconNor", "removeBgIconSel", "removeBgView", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "smileyPanel", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel;", "speedUpIcon", "speedUpIconNor", "speedUpIconSel", "speedUpView", "startTick", "", "getStartTick", "()J", "setStartTick", "(J)V", "videoCallback", "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1;", "videoPlayView", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiVideoPlayTextureView;", "videoPlayViewContainer", "Landroid/view/ViewGroup;", "videoPreparedCallback", "Lkotlin/Function0;", "", "createDrawable", "selected", "normal", "selectedColor", "normalColor", "destroy", "getItemContainer", "getVideoPlayView", "initSmileyPanel", "isShow", "", "isShowSmileyPanel", "isShowTextEditor", "onApplyWindowInsets", "Landroid/view/WindowInsets;", "insets", "reset", "setReporter", "setVisibility", "visibility", "setup", "videoPath", "removeBgEnable", "removeBg", "toggleSmileyPanel", "show", "toggleTextEditor", "text", "", "textColor", "viewPrepared", "plugin-emojicapture_release"})
public final class CaptureEditorContainer extends RelativeLayout implements b.AbstractC0968b {
    private final String TAG;
    private long gXF;
    private ImageView hNZ;
    private EmojiCaptureReporter rqJ;
    private b.a rtY;
    private com.tencent.mm.plugin.emojicapture.model.a.b rtZ;
    private final ViewGroup rua;
    private EmojiVideoPlayTextureView rub;
    private EditorItemContainer ruc;
    private EditorChangeTextView rud;
    private View rue;
    private View ruf;
    private View rug;
    private View ruh;
    private final ImageView rui;
    private final ImageView ruj;
    private final ImageView ruk;
    private ImageView rul;
    private final ChatFooterPanel rum;
    private final Drawable run;
    private final Drawable ruo;
    private final Drawable rup;
    private final Drawable ruq;
    private final Drawable rur;
    private final Drawable rus;
    private kotlin.g.a.a<x> rut;
    private final c ruu;

    public static final /* synthetic */ EmojiCaptureReporter c(CaptureEditorContainer captureEditorContainer) {
        AppMethodBeat.i(715);
        EmojiCaptureReporter emojiCaptureReporter = captureEditorContainer.rqJ;
        if (emojiCaptureReporter == null) {
            p.btv("reporter");
        }
        AppMethodBeat.o(715);
        return emojiCaptureReporter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CaptureEditorContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(713);
        this.TAG = "MicroMsg.CaptureEditorContainer";
        this.rtZ = new com.tencent.mm.plugin.emojicapture.model.a.b();
        View.inflate(context, R.layout.a1t, this);
        View findViewById = findViewById(R.id.bzm);
        p.g(findViewById, "findViewById(R.id.emoji_…e_video_play_view_layout)");
        this.rua = (ViewGroup) findViewById;
        View findViewById2 = findViewById(R.id.bxc);
        p.g(findViewById2, "findViewById(R.id.editor_item_container)");
        this.ruc = (EditorItemContainer) findViewById2;
        View findViewById3 = findViewById(R.id.ar2);
        p.g(findViewById3, "findViewById(R.id.change_text_root)");
        this.rud = (EditorChangeTextView) findViewById3;
        View findViewById4 = findViewById(R.id.bxw);
        p.g(findViewById4, "findViewById(R.id.editor_type_root)");
        this.rue = findViewById4;
        View findViewById5 = findViewById(R.id.bxl);
        p.g(findViewById5, "findViewById(R.id.editor_remove_background)");
        this.ruf = findViewById5;
        View findViewById6 = findViewById(R.id.bxo);
        p.g(findViewById6, "findViewById(R.id.editor_speed_up)");
        this.rug = findViewById6;
        View findViewById7 = findViewById(R.id.bwl);
        p.g(findViewById7, "findViewById(R.id.editor_add_emoji)");
        this.ruh = findViewById7;
        View findViewById8 = findViewById(R.id.bxm);
        p.g(findViewById8, "findViewById(R.id.editor_remove_background_icon)");
        this.rui = (ImageView) findViewById8;
        View findViewById9 = findViewById(R.id.bxp);
        p.g(findViewById9, "findViewById(R.id.editor_speed_up_icon)");
        this.ruj = (ImageView) findViewById9;
        View findViewById10 = findViewById(R.id.bwm);
        p.g(findViewById10, "findViewById(R.id.editor_add_emoji_icon)");
        this.ruk = (ImageView) findViewById10;
        View findViewById11 = findViewById(R.id.irb);
        p.g(findViewById11, "findViewById(R.id.to_capture)");
        this.hNZ = (ImageView) findViewById11;
        View findViewById12 = findViewById(R.id.ff2);
        p.g(findViewById12, "findViewById(R.id.mix_video)");
        this.rul = (ImageView) findViewById12;
        Drawable m = ar.m(context, R.raw.icons_filled_remove_bg, com.tencent.mm.plugin.emojicapture.ui.c.dH(this));
        p.g(m, "getColorDrawable(context…ve_bg, getIconSelColor())");
        this.run = m;
        Drawable m2 = ar.m(context, R.raw.icons_outlined_remove_bg, com.tencent.mm.plugin.emojicapture.ui.c.dI(this));
        p.g(m2, "getColorDrawable(context…ve_bg, getIconNorColor())");
        this.ruo = m2;
        Drawable m3 = ar.m(context, R.raw.icons_filled_play_quickly, com.tencent.mm.plugin.emojicapture.ui.c.dH(this));
        p.g(m3, "getColorDrawable(context…ickly, getIconSelColor())");
        this.rup = m3;
        Drawable m4 = ar.m(context, R.raw.icons_outlined_play_quickly, com.tencent.mm.plugin.emojicapture.ui.c.dI(this));
        p.g(m4, "getColorDrawable(context…ickly, getIconNorColor())");
        this.ruq = m4;
        Drawable m5 = ar.m(context, R.raw.icons_filled_add_emoji, com.tencent.mm.plugin.emojicapture.ui.c.dH(this));
        p.g(m5, "getColorDrawable(context…emoji, getIconSelColor())");
        this.rur = m5;
        Drawable m6 = ar.m(context, R.raw.icons_outlined_add_emoji, com.tencent.mm.plugin.emojicapture.ui.c.dI(this));
        p.g(m6, "getColorDrawable(context…emoji, getIconNorColor())");
        this.rus = m6;
        this.rui.setImageDrawable(this.ruo);
        this.ruj.setImageDrawable(this.ruq);
        this.ruk.setImageDrawable(this.rus);
        this.hNZ.setImageDrawable(ar.m(context, R.raw.icons_outlined_previous, com.tencent.mm.plugin.emojicapture.ui.c.dI(this)));
        this.rul.setImageDrawable(ar.m(context, R.raw.icons_filled_done, com.tencent.mm.plugin.emojicapture.ui.c.dH(this)));
        this.ruf.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer.AnonymousClass1 */
            final /* synthetic */ CaptureEditorContainer ruv;

            {
                this.ruv = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.x.c.CTRL_INDEX);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                EmojiCaptureReporter.a(10, CaptureEditorContainer.c(this.ruv).hdz, 0, 0, 0, 0, 0, 0, CaptureEditorContainer.c(this.ruv).scene);
                View view2 = this.ruv.ruf;
                b.a presenter = this.ruv.getPresenter();
                view2.setSelected(presenter != null ? presenter.cIx() : false);
                this.ruv.rui.setImageDrawable(this.ruv.ruf.isSelected() ? this.ruv.run : this.ruv.ruo);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.x.c.CTRL_INDEX);
            }
        });
        this.rug.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer.AnonymousClass2 */
            final /* synthetic */ CaptureEditorContainer ruv;

            {
                this.ruv = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(d.CTRL_INDEX);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                EmojiCaptureReporter.a(11, CaptureEditorContainer.c(this.ruv).hdz, 0, 0, 0, 0, 0, 0, CaptureEditorContainer.c(this.ruv).scene);
                View view2 = this.ruv.rug;
                b.a presenter = this.ruv.getPresenter();
                view2.setSelected(presenter != null ? presenter.cIy() : false);
                this.ruv.ruj.setImageDrawable(this.ruv.rug.isSelected() ? this.ruv.rup : this.ruv.ruq);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(d.CTRL_INDEX);
            }
        });
        this.ruh.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer.AnonymousClass3 */
            final /* synthetic */ CaptureEditorContainer ruv;

            {
                this.ruv = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(com.tencent.mm.plugin.appbrand.game.e.b.c.CTRL_INDEX);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                EmojiCaptureReporter.a(12, CaptureEditorContainer.c(this.ruv).hdz, 0, 0, 0, 0, 0, 0, CaptureEditorContainer.c(this.ruv).scene);
                this.ruv.lE(!this.ruv.cIC());
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(com.tencent.mm.plugin.appbrand.game.e.b.c.CTRL_INDEX);
            }
        });
        findViewById(R.id.bz3).setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer.AnonymousClass4 */
            final /* synthetic */ CaptureEditorContainer ruv;

            {
                this.ruv = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(689);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.a presenter = this.ruv.getPresenter();
                if (presenter != null) {
                    presenter.Ul();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(689);
            }
        });
        findViewById(R.id.bz2).setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer.AnonymousClass5 */
            final /* synthetic */ CaptureEditorContainer ruv;

            {
                this.ruv = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(ab.CTRL_INDEX);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                CaptureEditorContainer.c(this.ruv).rnM = System.currentTimeMillis() - CaptureEditorContainer.c(this.ruv).rnI;
                CaptureEditorContainer.c(this.ruv).cIv();
                EmojiCaptureReporter.Gi(3);
                b.a presenter = this.ruv.getPresenter();
                if (presenter != null) {
                    presenter.cIz();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(ab.CTRL_INDEX);
            }
        });
        setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer.AnonymousClass6 */
            final /* synthetic */ CaptureEditorContainer ruv;

            {
                this.ruv = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.pay.l.CTRL_INDEX);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (this.ruv.cIC()) {
                    this.ruv.lE(false);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.pay.l.CTRL_INDEX);
            }
        });
        this.rud.setCallback(new EditorChangeTextView.a(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer.AnonymousClass7 */
            final /* synthetic */ CaptureEditorContainer ruv;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.ruv = r1;
            }

            @Override // com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView.a
            public final void i(CharSequence charSequence, int i2) {
                AppMethodBeat.i(692);
                String obj = charSequence != null ? charSequence.toString() : null;
                if (obj != null && obj.length() > 50) {
                    obj = obj.substring(0, 50);
                    p.g(obj, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                b.a presenter = this.ruv.getPresenter();
                if (presenter != null) {
                    presenter.n(obj, i2, true);
                }
                this.ruv.rud.setShow(false);
                AppMethodBeat.o(692);
            }

            @Override // com.tencent.mm.plugin.emojicapture.ui.editor.EditorChangeTextView.a
            public final void onCancel() {
                AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.pay.c.CTRL_INDEX);
                b.a presenter = this.ruv.getPresenter();
                if (presenter != null) {
                    presenter.n(null, 0, false);
                }
                this.ruv.rud.setShow(false);
                AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.pay.c.CTRL_INDEX);
            }
        });
        this.ruc.setStateChangeListener(new EditorItemContainer.b(this) {
            /* class com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer.AnonymousClass8 */
            final /* synthetic */ CaptureEditorContainer ruv;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.ruv = r1;
            }

            @Override // com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer.b
            public final void lL(boolean z) {
                AppMethodBeat.i(694);
                if (z) {
                    this.ruv.rue.setVisibility(8);
                    AppMethodBeat.o(694);
                    return;
                }
                this.ruv.rue.setVisibility(0);
                AppMethodBeat.o(694);
            }
        });
        SmileyPanel bC = ad.bC(context);
        p.g(bC, "SmileyPanelFactory.getSmileyPanel(context)");
        this.rum = bC;
        Log.i(this.TAG, "initSmileyPanel " + this.rum);
        this.rum.setEntranceScene(ChatFooterPanel.KbE);
        this.rum.setShowSmiley(false);
        this.rum.setShowClose(true);
        this.rum.setVisibility(8);
        this.rum.onResume();
        ac VK = ad.VK();
        p.g(VK, "callbackWrapper");
        VK.a(new a(this));
        this.rum.setCallback(VK);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ad.bD(getContext()));
        layoutParams.addRule(12);
        addView(this.rum, layoutParams);
        this.rum.setTranslationY((float) layoutParams.height);
        this.ruu = new c(this);
        AppMethodBeat.o(713);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CaptureEditorContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(g.CTRL_INDEX);
        AppMethodBeat.o(g.CTRL_INDEX);
    }

    public final b.a getPresenter() {
        return this.rtY;
    }

    public final void setPresenter(b.a aVar) {
        this.rtY = aVar;
    }

    public final long getStartTick() {
        return this.gXF;
    }

    public final void setStartTick(long j2) {
        this.gXF = j2;
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.b.AbstractC0968b
    public final void a(com.tencent.mm.plugin.emojicapture.model.a.b bVar, String str, boolean z, boolean z2, kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(702);
        p.h(bVar, "captureInfo");
        p.h(str, "videoPath");
        this.rtZ = bVar;
        Context context = getContext();
        p.g(context, "context");
        this.rub = new EmojiVideoPlayTextureView(context);
        this.rua.addView(this.rub);
        EmojiVideoPlayTextureView emojiVideoPlayTextureView = this.rub;
        if (emojiVideoPlayTextureView != null) {
            emojiVideoPlayTextureView.setRemoveBgEnable(z);
        }
        EmojiVideoPlayTextureView emojiVideoPlayTextureView2 = this.rub;
        if (emojiVideoPlayTextureView2 != null) {
            emojiVideoPlayTextureView2.setRemoveBackground(z2);
        }
        EmojiVideoPlayTextureView emojiVideoPlayTextureView3 = this.rub;
        if (emojiVideoPlayTextureView3 != null) {
            emojiVideoPlayTextureView3.setVideoCallback(this.ruu);
        }
        EmojiVideoPlayTextureView emojiVideoPlayTextureView4 = this.rub;
        if (emojiVideoPlayTextureView4 != null) {
            emojiVideoPlayTextureView4.setVideoPath(str);
        }
        EmojiVideoPlayTextureView emojiVideoPlayTextureView5 = this.rub;
        if (emojiVideoPlayTextureView5 != null) {
            emojiVideoPlayTextureView5.setAlpha(0.0f);
        }
        if (!z) {
            this.ruf.setEnabled(false);
            this.ruf.setSelected(false);
            this.rui.setImageDrawable(this.ruo);
            this.ruf.setAlpha(0.3f);
        } else {
            this.ruf.setEnabled(true);
            this.ruf.setAlpha(1.0f);
            this.ruf.setSelected(z2);
            this.rui.setImageDrawable(this.ruf.isSelected() ? this.run : this.ruo);
        }
        this.rut = aVar;
        AppMethodBeat.o(702);
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.b.AbstractC0968b
    public final void cIA() {
        AppMethodBeat.i(703);
        EmojiVideoPlayTextureView emojiVideoPlayTextureView = this.rub;
        if (emojiVideoPlayTextureView != null) {
            emojiVideoPlayTextureView.setAlpha(1.0f);
        }
        EmojiCaptureReporter emojiCaptureReporter = this.rqJ;
        if (emojiCaptureReporter == null) {
            p.btv("reporter");
        }
        emojiCaptureReporter.rnI = System.currentTimeMillis();
        AppMethodBeat.o(703);
    }

    public final void setReporter(EmojiCaptureReporter emojiCaptureReporter) {
        AppMethodBeat.i(704);
        p.h(emojiCaptureReporter, "reporter");
        this.rqJ = emojiCaptureReporter;
        this.rud.setReporter(emojiCaptureReporter);
        AppMethodBeat.o(704);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$initSmileyPanel$1", "Lcom/tencent/mm/api/SmileyPanelCallbackWrapper$Callback;", "onHide", "", "onSelectedEmoji", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "plugin-emojicapture_release"})
    public static final class a implements ac.a {
        final /* synthetic */ CaptureEditorContainer ruv;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(CaptureEditorContainer captureEditorContainer) {
            this.ruv = captureEditorContainer;
        }

        @Override // com.tencent.mm.api.ac.a
        public final void a(r rVar) {
            AppMethodBeat.i(695);
            p.h(rVar, "emojiInfo");
            Log.i(this.ruv.TAG, "[onSelectedEmoji] emojiInfo:%s", rVar);
            b.a presenter = this.ruv.getPresenter();
            if (presenter != null) {
                presenter.a(rVar, null);
            }
            onHide();
            AppMethodBeat.o(695);
        }

        @Override // com.tencent.mm.api.ac.a
        public final void onHide() {
            AppMethodBeat.i(696);
            this.ruv.lE(false);
            AppMethodBeat.o(696);
        }
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.b.AbstractC0968b
    public final EmojiVideoPlayTextureView getVideoPlayView() {
        return this.rub;
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.b.AbstractC0968b
    public final EditorItemContainer getItemContainer() {
        return this.ruc;
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.b.AbstractC0968b
    public final boolean bJw() {
        AppMethodBeat.i(705);
        if (getVisibility() == 0) {
            AppMethodBeat.o(705);
            return true;
        }
        AppMethodBeat.o(705);
        return false;
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.b.AbstractC0968b
    public final boolean cIB() {
        AppMethodBeat.i(706);
        if (this.rud.getVisibility() == 0) {
            AppMethodBeat.o(706);
            return true;
        }
        AppMethodBeat.o(706);
        return false;
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.b.AbstractC0968b
    public final void a(boolean z, CharSequence charSequence, int i2) {
        int safeInsetTop;
        AppMethodBeat.i(707);
        if (z) {
            this.rud.setVisibility(0);
            EditorChangeTextView editorChangeTextView = this.rud;
            editorChangeTextView.ova.setText(charSequence);
            if (charSequence != null) {
                editorChangeTextView.ova.setSelection(charSequence.length());
            }
            int n = e.n(com.tencent.mm.plugin.emojicapture.ui.c.cJF(), i2);
            if (n == -1) {
                n = 0;
            }
            editorChangeTextView.ruB.setSelected(n);
            editorChangeTextView.ruC = com.tencent.mm.plugin.emojicapture.ui.c.cJF()[n];
            editorChangeTextView.ruD = com.tencent.mm.plugin.emojicapture.ui.c.cJG()[n];
            editorChangeTextView.ova.setTextColor(editorChangeTextView.ruC);
            editorChangeTextView.ruI = false;
            if (com.tencent.mm.compatible.util.d.oD(28)) {
                WindowInsets rootWindowInsets = editorChangeTextView.getRootWindowInsets();
                DisplayCutout displayCutout = rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null;
                if (!(displayCutout == null || (safeInsetTop = displayCutout.getSafeInsetTop()) <= 0 || editorChangeTextView.getPaddingTop() == safeInsetTop)) {
                    editorChangeTextView.setPadding(0, safeInsetTop, 0, 0);
                }
            }
            AppMethodBeat.o(707);
            return;
        }
        this.rud.cancel();
        AppMethodBeat.o(707);
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.b.AbstractC0968b
    public final boolean cIC() {
        AppMethodBeat.i(708);
        if (this.rum.getVisibility() == 0) {
            AppMethodBeat.o(708);
            return true;
        }
        AppMethodBeat.o(708);
        return false;
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.b.AbstractC0968b
    public final void lE(boolean z) {
        AppMethodBeat.i(709);
        float f2 = (float) this.rum.getLayoutParams().height;
        if (z) {
            this.ruh.setSelected(true);
            this.rum.setVisibility(0);
            this.rum.animate().translationY(0.0f).start();
        } else {
            this.ruh.setSelected(false);
            this.rum.animate().translationY(f2).withEndAction(new b(this)).start();
        }
        this.ruk.setImageDrawable(this.ruh.isSelected() ? this.rur : this.rus);
        AppMethodBeat.o(709);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ CaptureEditorContainer ruv;

        b(CaptureEditorContainer captureEditorContainer) {
            this.ruv = captureEditorContainer;
        }

        public final void run() {
            AppMethodBeat.i(697);
            this.ruv.rum.setVisibility(8);
            AppMethodBeat.o(697);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, hxF = {"com/tencent/mm/plugin/emojicapture/ui/editor/CaptureEditorContainer$videoCallback$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-emojicapture_release"})
    public static final class c implements j.a {
        final /* synthetic */ CaptureEditorContainer ruv;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(CaptureEditorContainer captureEditorContainer) {
            this.ruv = captureEditorContainer;
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final void tf() {
            AppMethodBeat.i(700);
            EmojiVideoPlayTextureView emojiVideoPlayTextureView = this.ruv.rub;
            if (emojiVideoPlayTextureView != null) {
                emojiVideoPlayTextureView.setOnDrawCallback(new a(this));
            }
            this.ruv.setStartTick(Util.currentTicks());
            EmojiVideoPlayTextureView emojiVideoPlayTextureView2 = this.ruv.rub;
            if (emojiVideoPlayTextureView2 != null) {
                emojiVideoPlayTextureView2.start();
                AppMethodBeat.o(700);
                return;
            }
            AppMethodBeat.o(700);
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final void onCompletion() {
            AppMethodBeat.i(701);
            Log.i(this.ruv.TAG, "onCompletion cost " + Util.ticksToNow(this.ruv.getStartTick()) + LocaleUtil.MALAY);
            this.ruv.setStartTick(Util.currentTicks());
            EmojiVideoPlayTextureView emojiVideoPlayTextureView = this.ruv.rub;
            if (emojiVideoPlayTextureView != null) {
                emojiVideoPlayTextureView.rsm = true;
                com.tencent.mm.plugin.n.j jVar = emojiVideoPlayTextureView.rsl;
                if (jVar != null) {
                    jVar.QC(0);
                    AppMethodBeat.o(701);
                    return;
                }
                AppMethodBeat.o(701);
                return;
            }
            AppMethodBeat.o(701);
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final int fh(int i2, int i3) {
            return 0;
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final void eo(int i2, int i3) {
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
        public final void onError(int i2, int i3) {
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ c ruw;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(c cVar) {
                super(0);
                this.ruw = cVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(SdkInfo.ErrCode.kErrCodeEnd);
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.emojicapture.ui.editor.CaptureEditorContainer.c.a.AnonymousClass1 */
                    final /* synthetic */ a rux;

                    {
                        this.rux = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(698);
                        EmojiVideoPlayTextureView emojiVideoPlayTextureView = this.rux.ruw.ruv.rub;
                        if (emojiVideoPlayTextureView != null) {
                            emojiVideoPlayTextureView.setVisibility(0);
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(698);
                        return xVar;
                    }
                });
                kotlin.g.a.a aVar = this.ruw.ruv.rut;
                if (aVar != null) {
                    aVar.invoke();
                }
                EmojiVideoPlayTextureView emojiVideoPlayTextureView = this.ruw.ruv.rub;
                if (emojiVideoPlayTextureView != null) {
                    emojiVideoPlayTextureView.setOnDrawCallback(null);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(SdkInfo.ErrCode.kErrCodeEnd);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.b.AbstractC0968b
    public final void reset() {
        AppMethodBeat.i(710);
        this.ruf.setSelected(false);
        this.rug.setSelected(false);
        this.rui.setImageDrawable(this.ruo);
        this.ruj.setImageDrawable(this.ruq);
        EmojiVideoPlayTextureView emojiVideoPlayTextureView = this.rub;
        if (emojiVideoPlayTextureView != null) {
            emojiVideoPlayTextureView.stop();
        }
        this.rua.removeView(this.rub);
        this.rub = null;
        AppMethodBeat.o(710);
    }

    public final void setVisibility(int i2) {
        AppMethodBeat.i(711);
        super.setVisibility(i2);
        EmojiVideoPlayTextureView emojiVideoPlayTextureView = this.rub;
        if (emojiVideoPlayTextureView != null) {
            emojiVideoPlayTextureView.setVisibility(i2);
            AppMethodBeat.o(711);
            return;
        }
        AppMethodBeat.o(711);
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.b.AbstractC0968b
    public final void destroy() {
        AppMethodBeat.i(712);
        Log.i(this.TAG, "destroy " + this.rum);
        this.rum.destroy();
        AppMethodBeat.o(712);
    }

    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        AppMethodBeat.i(256446);
        if (windowInsets != null) {
            findViewById(R.id.bzn).setPadding(0, windowInsets.getSystemWindowInsetTop(), 0, 0);
        }
        WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        p.g(onApplyWindowInsets, "super.onApplyWindowInsets(insets)");
        AppMethodBeat.o(256446);
        return onApplyWindowInsets;
    }
}
