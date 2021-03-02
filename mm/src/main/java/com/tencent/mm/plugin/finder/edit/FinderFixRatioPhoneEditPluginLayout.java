package com.tencent.mm.plugin.finder.edit;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u001a\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/edit/FinderFixRatioPhoneEditPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setOutputSize", "path", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderFixRatioPhoneEditPluginLayout extends EditPhotoPluginLayout {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFixRatioPhoneEditPluginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(243399);
        AppMethodBeat.o(243399);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void a(b bVar) {
        Bundle bundle;
        AppMethodBeat.i(243397);
        super.a(bVar);
        com.tencent.mm.bt.b bVar2 = getEditPhotoWrapper().zQp;
        if (bVar2 != null) {
            RecordConfigProvider configProvider = getConfigProvider();
            bVar2.cW((configProvider == null || (bundle = configProvider.jkf) == null) ? 0.75f : bundle.getFloat("crop_fix_ratio"));
        }
        post(new a(this));
        if (bVar != null) {
            setOutputSize(bVar.iql);
            AppMethodBeat.o(243397);
            return;
        }
        AppMethodBeat.o(243397);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ FinderFixRatioPhoneEditPluginLayout tHk;

        a(FinderFixRatioPhoneEditPluginLayout finderFixRatioPhoneEditPluginLayout) {
            this.tHk = finderFixRatioPhoneEditPluginLayout;
        }

        public final void run() {
            AppMethodBeat.i(243396);
            d.b.a(this.tHk, d.c.BVB);
            AppMethodBeat.o(243396);
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.d
    public final void a(d.c cVar, Bundle bundle) {
        AppMethodBeat.i(243398);
        p.h(cVar, "status");
        switch (a.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                getEditPhotoWrapper().eKA();
                getEditPhotoWrapper().dJF();
                AppMethodBeat.o(243398);
                return;
            case 2:
                Context context = getContext();
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(243398);
                    throw tVar;
                }
                ((Activity) context).finish();
                AppMethodBeat.o(243398);
                return;
            case 3:
            case 4:
                AppMethodBeat.o(243398);
                return;
            case 5:
                super.a(cVar, bundle);
                ImageView imageView = getPhotoControlUI().BQD;
                p.g(imageView, "photoControlUI.unDoImg");
                imageView.setVisibility(4);
                ImageView imageView2 = getPhotoControlUI().BQE;
                p.g(imageView2, "photoControlUI.rotateImg");
                imageView2.setVisibility(4);
                getPhotoControlUI().BQD.setOnClickListener(null);
                getPhotoControlUI().BQE.setOnClickListener(null);
                AppMethodBeat.o(243398);
                return;
            default:
                super.a(cVar, bundle);
                AppMethodBeat.o(243398);
                return;
        }
    }

    private final void setOutputSize(String str) {
        AppMethodBeat.i(260217);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapUtil.decodeFile(str, options);
        if (options.outWidth <= 0 || options.outHeight <= 0) {
            "setOutputSize getOption error. path:".concat(String.valueOf(str));
            h.hkS();
            AppMethodBeat.o(260217);
            return;
        }
        new StringBuilder("setOutputSize config[origin[").append(options.outWidth).append(',').append(options.outHeight).append("] target[1080,1440").append(']');
        h.hkS();
        getEditPhotoWrapper().setOutputSize(1080, 1440);
        AppMethodBeat.o(260217);
    }
}
