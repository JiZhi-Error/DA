package com.tencent.mm.plugin.finder.edit;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.c;
import com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditorVideoPlayView;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.s;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\u001a\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/edit/FinderVideoEditPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "invertMatrix", "Landroid/graphics/Matrix;", "getPlayerView", "Landroid/view/View;", "getScale", "", "values", "", "initLogic", "", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "startRemux", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderVideoEditPluginLayout extends EditorVideoPluginLayoutNew {
    private Matrix tHm;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderVideoEditPluginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(165510);
        AppMethodBeat.o(165510);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void a(com.tencent.mm.plugin.recordvideo.activity.a aVar, RecordConfigProvider recordConfigProvider) {
        AppMethodBeat.i(165506);
        p.h(aVar, "navigator");
        p.h(recordConfigProvider, "configProvider");
        super.a(aVar, recordConfigProvider);
        Bundle bundle = recordConfigProvider.jkf;
        if (bundle != null) {
            ViewParent parent = getPreviewPlugin().zyd.getParent();
            p.g(parent, "previewPlugin.videoPlayView.parent");
            ViewParent parent2 = parent.getParent();
            if (parent2 == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout");
                AppMethodBeat.o(165506);
                throw tVar;
            }
            Context context = getContext();
            p.g(context, "context");
            WxCropOperationLayout wxCropOperationLayout = new WxCropOperationLayout(context);
            wxCropOperationLayout.getVisibilityRect().set((Rect) bundle.getParcelable("cropRect"));
            ((RelativeLayout) parent2).addView(wxCropOperationLayout, new ViewGroup.LayoutParams(-1, -1));
            wxCropOperationLayout.setStyle(WxCropOperationLayout.j.RECT_HARD);
            wxCropOperationLayout.bringToFront();
            float[] floatArray = bundle.getFloatArray("matrix");
            float[] floatArray2 = bundle.getFloatArray("offset");
            if (floatArray2 == null) {
                floatArray2 = new float[2];
            }
            p.g(floatArray2, "getFloatArray(\"offset\") ?: FloatArray(2)");
            float f2 = floatArray2[0];
            float f3 = floatArray2[1];
            if (floatArray != null) {
                Matrix matrix = new Matrix();
                matrix.setValues(floatArray);
                getPreviewPlugin().zyd.setScaleX(l(floatArray));
                getPreviewPlugin().zyd.setScaleY(l(floatArray));
                getPreviewPlugin().zyd.setTranslationX(f2);
                getPreviewPlugin().zyd.setTranslationY(f3);
                Log.i("MicroMsg.EditorVideoPluginLayoutNew", "translationX=" + getPreviewPlugin().zyd.getTranslationX() + " translationY=" + getPreviewPlugin().zyd.getTranslationY() + ' ' + "scaleX=" + getPreviewPlugin().zyd.getScaleX() + " offsetX=" + f2 + " offsetY=" + f3 + " matrix=" + matrix);
                this.tHm = new Matrix();
                matrix.invert(this.tHm);
            }
        }
        getCropVideoPlugin().BSz = true;
        AppMethodBeat.o(165506);
    }

    private static float l(float[] fArr) {
        AppMethodBeat.i(165507);
        p.h(fArr, "values");
        float f2 = fArr[0];
        float f3 = fArr[3];
        float sqrt = (float) Math.sqrt((((double) f3) * ((double) f3)) + ((double) (f2 * f2)));
        AppMethodBeat.o(165507);
        return sqrt;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew
    public final View getPlayerView() {
        AppMethodBeat.i(165508);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        a aVar = new a(this, getContext());
        setPreviewPlugin(new s(aVar, this, (TextView) findViewById(R.id.j4b)));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(aVar, layoutParams);
        FrameLayout frameLayout2 = frameLayout;
        AppMethodBeat.o(165508);
        return frameLayout2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/edit/FinderVideoEditPluginLayout$getPlayerView$playerView$1", "Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditorVideoPlayView;", "setVideoCenter", "", "plugin-finder_release"})
    public static final class a extends EditorVideoPlayView {
        final /* synthetic */ FinderVideoEditPluginLayout tHn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(FinderVideoEditPluginLayout finderVideoEditPluginLayout, Context context) {
            super(context);
            this.tHn = finderVideoEditPluginLayout;
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView
        public final void crn() {
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew, com.tencent.mm.plugin.recordvideo.plugin.parent.d
    public final void a(d.c cVar, Bundle bundle) {
        AppMethodBeat.i(165509);
        p.h(cVar, "status");
        switch (b.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
                String eKD = getBgPlugin().eKD();
                getPreviewPlugin().release();
                getItemContainerPlugin().onPause();
                getAddMusicPlugin().onPause();
                int i2 = 0;
                if (getMoreMenuPlugin().BQn) {
                    i2 = 1;
                }
                CaptureDataManager captureDataManager = CaptureDataManager.BOb;
                p.g(captureDataManager, "CaptureDataManager.INSTANCE");
                captureDataManager.getExtData().putInt("key_extra_feature_flag", i2);
                if (getMoreMenuPlugin().bxP == 2) {
                    CaptureDataManager captureDataManager2 = CaptureDataManager.BOb;
                    p.g(captureDataManager2, "CaptureDataManager.INSTANCE");
                    captureDataManager2.getExtData().putString("key_group_list", getMoreMenuPlugin().eKy());
                } else if (getMoreMenuPlugin().bxP == 3) {
                    CaptureDataManager captureDataManager3 = CaptureDataManager.BOb;
                    p.g(captureDataManager3, "CaptureDataManager.INSTANCE");
                    captureDataManager3.getExtData().putString("key_black_list", getMoreMenuPlugin().eKy());
                }
                f fVar = new f(getAddMusicPlugin().wgL.getMuteOrigin(), getAddMusicPlugin().wgG, getItemContainerPlugin().d(this.tHm), getItemContainerPlugin().getEditorDataList(), getItemContainerPlugin().eKr(), getPreviewPlugin().dvv, getPreviewPlugin().iqg, new ArrayList(), eKD, getItemContainerPlugin().eKr());
                Log.i("MicroMsg.EditorVideoPluginLayoutNew", "edit config: ".concat(String.valueOf(fVar)));
                getReMuxPlugin().a(fVar);
                c cVar2 = c.BXI;
                c.x("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(getItemContainerPlugin().eKu()));
                c cVar3 = c.BXI;
                c.x("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(getItemContainerPlugin().eKv()));
                c cVar4 = c.BXI;
                c.x("KEY_SELECT_MUSIC_INT", Integer.valueOf(getAddMusicPlugin().wgG == null ? 0 : 1));
                c cVar5 = c.BXI;
                c.x("KEY_SELECT_ORIGIN_INT", Integer.valueOf(getAddMusicPlugin().wgL.getMuteOrigin() ? 0 : 1));
                c cVar6 = c.BXI;
                c.x("KEY_AFTER_EDIT_INT", 1);
                c cVar7 = c.BXI;
                c.VI(13);
                c cVar8 = c.BXI;
                c.eKX().ry(System.currentTimeMillis());
                c cVar9 = c.BXI;
                RecordConfigProvider configProvider = getConfigProvider();
                c.VJ(configProvider != null ? configProvider.scene : 0);
                c.a aVar = com.tencent.mm.plugin.recordvideo.model.audio.c.BPD;
                com.tencent.mm.plugin.recordvideo.model.audio.c cVar10 = com.tencent.mm.plugin.recordvideo.model.audio.c.BPz;
                if (cVar10 != null) {
                    cVar10.eKe();
                    AppMethodBeat.o(165509);
                    return;
                }
                AppMethodBeat.o(165509);
                return;
            default:
                if (cVar != d.c.BVq) {
                    Log.e("MicroMsg.EditorVideoPluginLayoutNew", "unknown status ".concat(String.valueOf(cVar)));
                }
                super.a(cVar, bundle);
                AppMethodBeat.o(165509);
                return;
        }
    }
}
