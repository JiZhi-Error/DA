package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 )2\u00020\u0001:\u0001)B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u001a2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u001aH\u0016J\b\u0010#\u001a\u00020\u001aH\u0002J\u001a\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "maxDuration", "", "revertBtn", "Landroid/widget/ImageView;", "getRevertBtn", "()Landroid/widget/ImageView;", "revertBtn$delegate", "Lkotlin/Lazy;", "sendBtn", "getSendBtn", "sendBtn$delegate", "singhtBtnContainer", "Landroid/widget/RelativeLayout;", "getSinghtBtnContainer", "()Landroid/widget/RelativeLayout;", "singhtBtnContainer$delegate", "getLayoutId", "", "initLogic", "", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onAttach", "setInvisiblePlugin", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-textstatus_release"})
public final class TextStatusEditVideoPluginLayout extends EditorVideoPluginLayoutNew {
    public static final a Gfe = new a((byte) 0);
    private final kotlin.f GeZ = kotlin.g.ah(new g(this));
    private final kotlin.f Gfa = kotlin.g.ah(new e(this));
    private long Gfd = 15;
    private final kotlin.f vRo = kotlin.g.ah(new f(this));

    static {
        AppMethodBeat.i(216598);
        AppMethodBeat.o(216598);
    }

    private final ImageView getRevertBtn() {
        AppMethodBeat.i(216591);
        ImageView imageView = (ImageView) this.Gfa.getValue();
        AppMethodBeat.o(216591);
        return imageView;
    }

    private final ImageView getSendBtn() {
        AppMethodBeat.i(216592);
        ImageView imageView = (ImageView) this.vRo.getValue();
        AppMethodBeat.o(216592);
        return imageView;
    }

    private final RelativeLayout getSinghtBtnContainer() {
        AppMethodBeat.i(216590);
        RelativeLayout relativeLayout = (RelativeLayout) this.GeZ.getValue();
        AppMethodBeat.o(216590);
        return relativeLayout;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "mixVideo", "", "mixThumb", "ret", "", "invoke"})
    static final class d extends q implements kotlin.g.a.q<String, String, Boolean, x> {
        final /* synthetic */ TextStatusEditVideoPluginLayout Gff;
        final /* synthetic */ com.tencent.mm.media.widget.camerarecordview.b.b Gfg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(TextStatusEditVideoPluginLayout textStatusEditVideoPluginLayout, com.tencent.mm.media.widget.camerarecordview.b.b bVar) {
            super(3);
            this.Gff = textStatusEditVideoPluginLayout;
            this.Gfg = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(String str, String str2, Boolean bool) {
            String str3;
            int i2;
            int i3;
            Bitmap bitmap;
            AppMethodBeat.i(216586);
            String str4 = str2;
            boolean booleanValue = bool.booleanValue();
            p.h(str, "mixVideo");
            p.h(str4, "mixThumb");
            Log.i("MicroMsg.TextStatusEditVideoPluginLayout", "is in main thread:" + MMHandlerThread.isMainThread());
            if (booleanValue) {
                com.tencent.mm.media.widget.camerarecordview.b.b bVar = this.Gfg;
                if (bVar != null) {
                    str3 = bVar.iqd;
                } else {
                    str3 = null;
                }
                if (s.YS(str3)) {
                    com.tencent.mm.plugin.gallery.a.c cVar = com.tencent.mm.plugin.gallery.a.c.xsz;
                    com.tencent.mm.media.widget.camerarecordview.b.b bVar2 = this.Gfg;
                    if (bVar2 == null) {
                        p.hyc();
                    }
                    com.tencent.mm.plugin.sight.base.a awl = com.tencent.mm.plugin.gallery.a.c.awl(bVar2.iqd);
                    int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_text_state_image_size, 1920);
                    if (awl.width > awl.height) {
                        i3 = (awl.height * a2) / awl.width;
                        i2 = a2;
                    } else {
                        i2 = (awl.width * a2) / awl.height;
                        i3 = a2;
                    }
                    Log.i("MicroMsg.TextStatusEditVideoPluginLayout", "outputHeight:" + i3 + " outputWidth:" + i2 + " startTime:" + TextStatusEditVideoPluginLayout.a(this.Gff).dvv);
                    Bitmap ba = com.tencent.mm.plugin.mmsight.d.ba(this.Gfg.iqd, (long) TextStatusEditVideoPluginLayout.a(this.Gff).dvv);
                    if (i3 < awl.height || i2 < awl.width) {
                        bitmap = Bitmap.createScaledBitmap(ba, i2, i3, true);
                        ba.recycle();
                    } else {
                        bitmap = ba;
                    }
                    if (bitmap != null) {
                        s.deleteFile(str4);
                        BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.JPEG, str4, true);
                    }
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(216586);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextStatusEditVideoPluginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(216597);
        AppMethodBeat.o(216597);
    }

    public static final /* synthetic */ com.tencent.mm.plugin.recordvideo.plugin.s a(TextStatusEditVideoPluginLayout textStatusEditVideoPluginLayout) {
        AppMethodBeat.i(216599);
        com.tencent.mm.plugin.recordvideo.plugin.s previewPlugin = textStatusEditVideoPluginLayout.getPreviewPlugin();
        AppMethodBeat.o(216599);
        return previewPlugin;
    }

    public static final /* synthetic */ com.tencent.mm.plugin.recordvideo.plugin.e b(TextStatusEditVideoPluginLayout textStatusEditVideoPluginLayout) {
        AppMethodBeat.i(216600);
        com.tencent.mm.plugin.recordvideo.plugin.e backToRecordPlugin = textStatusEditVideoPluginLayout.getBackToRecordPlugin();
        AppMethodBeat.o(216600);
        return backToRecordPlugin;
    }

    public static final /* synthetic */ com.tencent.mm.plugin.recordvideo.plugin.f c(TextStatusEditVideoPluginLayout textStatusEditVideoPluginLayout) {
        AppMethodBeat.i(216601);
        com.tencent.mm.plugin.recordvideo.plugin.f editFinishPlugin = textStatusEditVideoPluginLayout.getEditFinishPlugin();
        AppMethodBeat.o(216601);
        return editFinishPlugin;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout$Companion;", "", "()V", "DEFAULT_SIZE", "", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void a(com.tencent.mm.media.widget.camerarecordview.b.b bVar) {
        AppMethodBeat.i(216593);
        getReMuxPlugin().BRT = new d(this, bVar);
        getAddEmojiPlugin().setVisibility(4);
        getAddTextPlugin().setVisibility(4);
        getAddMusicPlugin().setVisibility(4);
        getCropVideoPlugin().setVisibility(4);
        getEditFinishPlugin().view.setVisibility(4);
        getBackToRecordPlugin().setVisibility(4);
        if (bVar != null) {
            com.tencent.mm.plugin.gallery.a.c cVar = com.tencent.mm.plugin.gallery.a.c.xsz;
            com.tencent.mm.plugin.sight.base.a awl = com.tencent.mm.plugin.gallery.a.c.awl(bVar.iqd);
            Log.i("MicroMsg.TextStatusEditVideoPluginLayout", "mediaInfo ".concat(String.valueOf(awl)));
            if (((long) awl.getVideoDuration()) <= this.Gfd) {
                getSinghtBtnContainer().setVisibility(0);
                getRevertBtn().setOnClickListener(new b(this));
                getSendBtn().setOnClickListener(new c(this));
            } else {
                getSinghtBtnContainer().setVisibility(4);
            }
        }
        super.a(bVar);
        AppMethodBeat.o(216593);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout$loadCurrentPage$2$1"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ TextStatusEditVideoPluginLayout Gff;

        b(TextStatusEditVideoPluginLayout textStatusEditVideoPluginLayout) {
            this.Gff = textStatusEditVideoPluginLayout;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216584);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout$loadCurrentPage$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            TextStatusEditVideoPluginLayout.b(this.Gff).onClick(view);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout$loadCurrentPage$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216584);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout$loadCurrentPage$2$2"})
    static final class c implements View.OnClickListener {
        final /* synthetic */ TextStatusEditVideoPluginLayout Gff;

        c(TextStatusEditVideoPluginLayout textStatusEditVideoPluginLayout) {
            this.Gff = textStatusEditVideoPluginLayout;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216585);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout$loadCurrentPage$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            TextStatusEditVideoPluginLayout.c(this.Gff).onClick(view);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditVideoPluginLayout$loadCurrentPage$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216585);
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void a(com.tencent.mm.plugin.recordvideo.activity.a aVar, RecordConfigProvider recordConfigProvider) {
        AppMethodBeat.i(216594);
        p.h(aVar, "navigator");
        p.h(recordConfigProvider, "configProvider");
        super.a(aVar, recordConfigProvider);
        this.Gfd = (long) recordConfigProvider.BOm.duration;
        AppMethodBeat.o(216594);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew, com.tencent.mm.plugin.recordvideo.plugin.parent.d
    public final void a(d.c cVar, Bundle bundle) {
        AppMethodBeat.i(216595);
        p.h(cVar, "status");
        switch (i.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                super.a(d.c.BVw, bundle);
                AppMethodBeat.o(216595);
                return;
            default:
                super.a(cVar, bundle);
                AppMethodBeat.o(216595);
                return;
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout
    public final int getLayoutId() {
        return R.layout.c32;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void aSs() {
        AppMethodBeat.i(216596);
        super.aSs();
        getEditFinishPlugin().view.setVisibility(4);
        AppMethodBeat.o(216596);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class g extends q implements kotlin.g.a.a<RelativeLayout> {
        final /* synthetic */ TextStatusEditVideoPluginLayout Gff;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(TextStatusEditVideoPluginLayout textStatusEditVideoPluginLayout) {
            super(0);
            this.Gff = textStatusEditVideoPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RelativeLayout invoke() {
            AppMethodBeat.i(216589);
            RelativeLayout relativeLayout = (RelativeLayout) this.Gff.findViewById(R.id.hrh);
            AppMethodBeat.o(216589);
            return relativeLayout;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ TextStatusEditVideoPluginLayout Gff;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(TextStatusEditVideoPluginLayout textStatusEditVideoPluginLayout) {
            super(0);
            this.Gff = textStatusEditVideoPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(216587);
            ImageView imageView = (ImageView) this.Gff.findViewById(R.id.hri);
            AppMethodBeat.o(216587);
            return imageView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class f extends q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ TextStatusEditVideoPluginLayout Gff;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(TextStatusEditVideoPluginLayout textStatusEditVideoPluginLayout) {
            super(0);
            this.Gff = textStatusEditVideoPluginLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(216588);
            ImageView imageView = (ImageView) this.Gff.findViewById(R.id.hrj);
            AppMethodBeat.o(216588);
            return imageView;
        }
    }
}
