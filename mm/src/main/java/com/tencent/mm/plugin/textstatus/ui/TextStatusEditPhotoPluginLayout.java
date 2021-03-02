package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\nR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditPhotoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "revertBtn", "Landroid/widget/ImageView;", "getRevertBtn", "()Landroid/widget/ImageView;", "revertBtn$delegate", "Lkotlin/Lazy;", "sendBtn", "getSendBtn", "sendBtn$delegate", "singhtBtnContainer", "Landroid/widget/RelativeLayout;", "getSinghtBtnContainer", "()Landroid/widget/RelativeLayout;", "singhtBtnContainer$delegate", "getLayoutId", "", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onAttach", "setOutputSize", "path", "", "Companion", "plugin-textstatus_release"})
public final class TextStatusEditPhotoPluginLayout extends EditPhotoPluginLayout {
    public static final a Gfb = new a((byte) 0);
    private final kotlin.f GeZ = g.ah(new f(this));
    private final kotlin.f Gfa = g.ah(new d(this));
    private final kotlin.f vRo = g.ah(new e(this));

    static {
        AppMethodBeat.i(216580);
        AppMethodBeat.o(216580);
    }

    private final ImageView getRevertBtn() {
        AppMethodBeat.i(216574);
        ImageView imageView = (ImageView) this.Gfa.getValue();
        AppMethodBeat.o(216574);
        return imageView;
    }

    private final ImageView getSendBtn() {
        AppMethodBeat.i(216575);
        ImageView imageView = (ImageView) this.vRo.getValue();
        AppMethodBeat.o(216575);
        return imageView;
    }

    private final RelativeLayout getSinghtBtnContainer() {
        AppMethodBeat.i(216573);
        RelativeLayout relativeLayout = (RelativeLayout) this.GeZ.getValue();
        AppMethodBeat.o(216573);
        return relativeLayout;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextStatusEditPhotoPluginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(216579);
        AppMethodBeat.o(216579);
    }

    public static final /* synthetic */ com.tencent.mm.plugin.recordvideo.plugin.e a(TextStatusEditPhotoPluginLayout textStatusEditPhotoPluginLayout) {
        AppMethodBeat.i(216581);
        com.tencent.mm.plugin.recordvideo.plugin.e backToRecordPlugin = textStatusEditPhotoPluginLayout.getBackToRecordPlugin();
        AppMethodBeat.o(216581);
        return backToRecordPlugin;
    }

    public static final /* synthetic */ com.tencent.mm.plugin.recordvideo.plugin.f b(TextStatusEditPhotoPluginLayout textStatusEditPhotoPluginLayout) {
        AppMethodBeat.i(216582);
        com.tencent.mm.plugin.recordvideo.plugin.f editFinishPlugin = textStatusEditPhotoPluginLayout.getEditFinishPlugin();
        AppMethodBeat.o(216582);
        return editFinishPlugin;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditPhotoPluginLayout$Companion;", "", "()V", "DEFAULT_SIZE", "", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void a(com.tencent.mm.media.widget.camerarecordview.b.b bVar) {
        AppMethodBeat.i(216576);
        getEditPencilPlugin().setVisibility(4);
        getAddEmojiPlugin().setVisibility(4);
        getEditAddTextPlugin().setVisibility(4);
        getEditCropPhotoPlugin().setVisibility(4);
        getBackToRecordPlugin().setVisibility(4);
        getSinghtBtnContainer().setVisibility(0);
        getRevertBtn().setOnClickListener(new b(this));
        getSendBtn().setOnClickListener(new c(this));
        super.a(bVar);
        if (bVar == null) {
            p.hyc();
        }
        setOutputSize(bVar.iql);
        AppMethodBeat.o(216576);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ TextStatusEditPhotoPluginLayout Gfc;

        b(TextStatusEditPhotoPluginLayout textStatusEditPhotoPluginLayout) {
            this.Gfc = textStatusEditPhotoPluginLayout;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216568);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditPhotoPluginLayout$loadCurrentPage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            TextStatusEditPhotoPluginLayout.a(this.Gfc).onClick(view);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditPhotoPluginLayout$loadCurrentPage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216568);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ TextStatusEditPhotoPluginLayout Gfc;

        c(TextStatusEditPhotoPluginLayout textStatusEditPhotoPluginLayout) {
            this.Gfc = textStatusEditPhotoPluginLayout;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216569);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditPhotoPluginLayout$loadCurrentPage$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            TextStatusEditPhotoPluginLayout.b(this.Gfc).onClick(view);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditPhotoPluginLayout$loadCurrentPage$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216569);
        }
    }

    private final void setOutputSize(String str) {
        int i2;
        int i3;
        AppMethodBeat.i(216577);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapUtil.decodeFile(str, options);
        if (options.outWidth <= 0 || options.outHeight <= 0) {
            "setOutputSize getOption error. path:".concat(String.valueOf(str));
            h.hkS();
            AppMethodBeat.o(216577);
            return;
        }
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_text_state_image_size, 1920);
        if (options.outWidth > options.outHeight) {
            i3 = (options.outHeight * a2) / options.outWidth;
            i2 = a2;
        } else {
            i2 = (options.outWidth * a2) / options.outHeight;
            i3 = a2;
        }
        new StringBuilder("setOutputSize config[").append(a2).append("] origin[").append(options.outWidth).append(',').append(options.outHeight).append("] target[").append(i2).append(',').append(i3).append(']');
        h.hkS();
        getEditPhotoWrapper().setOutputSize(i2, i3);
        AppMethodBeat.o(216577);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout
    public final int getLayoutId() {
        return R.layout.c2o;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void aSs() {
        AppMethodBeat.i(216578);
        super.aSs();
        getEditFinishPlugin().view.setVisibility(4);
        AppMethodBeat.o(216578);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class f extends q implements kotlin.g.a.a<RelativeLayout> {
        final /* synthetic */ TextStatusEditPhotoPluginLayout Gfc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(TextStatusEditPhotoPluginLayout textStatusEditPhotoPluginLayout) {
            super(0);
            this.Gfc = textStatusEditPhotoPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RelativeLayout invoke() {
            AppMethodBeat.i(216572);
            RelativeLayout relativeLayout = (RelativeLayout) this.Gfc.findViewById(R.id.hrh);
            AppMethodBeat.o(216572);
            return relativeLayout;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ TextStatusEditPhotoPluginLayout Gfc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(TextStatusEditPhotoPluginLayout textStatusEditPhotoPluginLayout) {
            super(0);
            this.Gfc = textStatusEditPhotoPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(216570);
            ImageView imageView = (ImageView) this.Gfc.findViewById(R.id.hri);
            AppMethodBeat.o(216570);
            return imageView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ TextStatusEditPhotoPluginLayout Gfc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(TextStatusEditPhotoPluginLayout textStatusEditPhotoPluginLayout) {
            super(0);
            this.Gfc = textStatusEditPhotoPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(216571);
            ImageView imageView = (ImageView) this.Gfc.findViewById(R.id.hrj);
            AppMethodBeat.o(216571);
            return imageView;
        }
    }
}
