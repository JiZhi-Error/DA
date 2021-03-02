package com.tencent.mm.plugin.multitalk.ui.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.ab;
import com.tencent.mm.api.h;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.plugin.multitalk.ui.a.a;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.a;
import com.tencent.mm.plugin.multitalk.ui.widget.projector.e;
import com.tencent.mm.plugin.recordvideo.e.c;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 L2\u00020\u00012\u00020\u0002:\u0001LB!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0006\u00101\u001a\u000202J\b\u00103\u001a\u0004\u0018\u00010\rJ\u0018\u00104\u001a\u0002022\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u00105\u001a\u0002022\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0006\u00108\u001a\u000202J\b\u00109\u001a\u00020:H\u0016J\u001e\u0010;\u001a\u0002022\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020\u001fJ\u000e\u0010@\u001a\u0002022\u0006\u0010A\u001a\u00020:J\"\u0010B\u001a\u0002022\u0006\u0010\u0007\u001a\u0002072\u0012\b\u0002\u0010C\u001a\f\u0012\u0006\u0012\u0004\u0018\u000102\u0018\u00010DJ\u000e\u0010E\u001a\u0002022\u0006\u0010F\u001a\u00020:J\u001a\u0010G\u001a\u0002022\u0006\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u0011\u0010'\u001a\u00020(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006M"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkScreenEditContainerPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "config", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "bgView", "Landroid/view/View;", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "getConfig", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "setConfig", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "editPencilPlugin", "Lcom/tencent/mm/plugin/multitalk/ui/editor/MultitalkScreenEditPhotoPencilPlugin;", "mHeight", "", "getMHeight", "()I", "setMHeight", "(I)V", "mWidth", "getMWidth", "setMWidth", "multiTalkEditPhotoWrapper", "Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin;", "getMultiTalkEditPhotoWrapper", "()Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkEditPhotoContainerPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "clearScreen", "", "drawBitmap", "initLogic", "loadCurrentPage", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "loadDoodle", "onBackPress", "", "onViewStatusChange", "zoom", "", "transX", "transY", "refreshDoodleLayout", "isLand", "refreshEditLayout", "callback", "Lkotlin/Function0;", "setDrawingEnable", "enable", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-multitalk_release"})
public final class b extends BasePluginLayout implements d {
    public static final a zQE = new a((byte) 0);
    public Bitmap bitmap;
    private View cBH;
    public int mHeight;
    public int mWidth;
    private com.tencent.mm.plugin.recordvideo.activity.a wdl;
    private RecordConfigProvider wdm;
    public final d zQB = new d(this, this);
    public final a zQC;
    public com.tencent.mm.plugin.multitalk.ui.widget.projector.a zQD;
    private e zQw;

    static {
        AppMethodBeat.i(239750);
        AppMethodBeat.o(239750);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context, com.tencent.mm.plugin.multitalk.ui.widget.projector.a aVar, e eVar) {
        super(context, null);
        p.h(context, "context");
        p.h(aVar, "statusManager");
        AppMethodBeat.i(239749);
        this.zQD = aVar;
        this.zQw = eVar;
        this.cBH = View.inflate(context, R.layout.bof, this);
        View findViewById = findViewById(R.id.hbu);
        p.g(findViewById, "findViewById(R.id.screen_preview_plugin)");
        this.zQC = new a((FrameLayout) findViewById, this, this.zQw);
        getPluginList().add(this.zQB);
        getPluginList().add(this.zQC);
        AppMethodBeat.o(239749);
    }

    public final e getConfig() {
        return this.zQw;
    }

    public final com.tencent.mm.plugin.multitalk.ui.widget.projector.a getStatusManager() {
        return this.zQD;
    }

    public final void setConfig(e eVar) {
        this.zQw = eVar;
    }

    public final void setStatusManager(com.tencent.mm.plugin.multitalk.ui.widget.projector.a aVar) {
        AppMethodBeat.i(239748);
        p.h(aVar, "<set-?>");
        this.zQD = aVar;
        AppMethodBeat.o(239748);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkScreenEditContainerPlugin$Companion;", "", "()V", "TAG", "", "plugin-multitalk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final RecordConfigProvider getConfigProvider() {
        return this.wdm;
    }

    /* access modifiers changed from: protected */
    public final void setConfigProvider(RecordConfigProvider recordConfigProvider) {
        this.wdm = recordConfigProvider;
    }

    public final a getMultiTalkEditPhotoWrapper() {
        return this.zQC;
    }

    public final void setDrawingEnable(boolean z) {
        com.tencent.mm.view.b.b bVar;
        AppMethodBeat.i(239743);
        com.tencent.mm.view.l lVar = this.zQC.zQo;
        if (lVar == null || (bVar = (com.tencent.mm.view.b.b) lVar.getBaseBoardView()) == null) {
            AppMethodBeat.o(239743);
            return;
        }
        bVar.setTouchEnable(z);
        AppMethodBeat.o(239743);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void a(com.tencent.mm.plugin.recordvideo.activity.a aVar, RecordConfigProvider recordConfigProvider) {
        Map<String, Boolean> map;
        Boolean bool;
        AppMethodBeat.i(239744);
        p.h(aVar, "navigator");
        p.h(recordConfigProvider, "configProvider");
        Log.i("MicroMsg.MultiTalkScreenEditContainerPlugin", "configProvider ".concat(String.valueOf(recordConfigProvider)));
        this.wdl = aVar;
        this.wdm = recordConfigProvider;
        c cVar = c.Cic;
        c.d(recordConfigProvider);
        for (T t : getPluginList()) {
            UICustomParam uICustomParam = recordConfigProvider.BOn;
            t.setVisibility(!((uICustomParam == null || (map = uICustomParam.gLL) == null || (bool = map.get(t.name())) == null) ? false : bool.booleanValue()) ? 0 : 8);
        }
        AppMethodBeat.o(239744);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void a(com.tencent.mm.media.widget.camerarecordview.b.b bVar) {
        AppMethodBeat.i(239745);
        super.a(bVar);
        if (bVar != null) {
            if (bVar.rect != null) {
                this.zQC.b(bVar);
            }
            AppMethodBeat.o(239745);
            return;
        }
        AppMethodBeat.o(239745);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.d
    public final void a(d.c cVar, Bundle bundle) {
        EmojiInfo emojiInfo;
        AppMethodBeat.i(239746);
        p.h(cVar, "status");
        Log.i("MicroMsg.MultiTalkScreenEditContainerPlugin", "status :" + cVar + " , param :" + bundle);
        switch (c.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                onBackPress();
                AppMethodBeat.o(239746);
                return;
            case 2:
                AppMethodBeat.o(239746);
                return;
            case 3:
            case 4:
                AppMethodBeat.o(239746);
                return;
            case 5:
                AppMethodBeat.o(239746);
                return;
            case 6:
                if (bundle == null || (emojiInfo = (EmojiInfo) bundle.getParcelable("PARAM_EDIT_EMOJI_INFO")) == null) {
                    AppMethodBeat.o(239746);
                    return;
                }
                a aVar = this.zQC;
                p.g(emojiInfo, "this");
                EmojiInfo emojiInfo2 = emojiInfo;
                p.h(emojiInfo2, "emojiInfo");
                com.tencent.mm.bt.b bVar = aVar.zQp;
                if (bVar != null) {
                    bVar.getSelectedFeatureListener().a(h.TEXT);
                }
                com.tencent.mm.bt.b bVar2 = aVar.zQp;
                if (bVar2 != null) {
                    bVar2.c(emojiInfo2);
                    AppMethodBeat.o(239746);
                    return;
                }
                AppMethodBeat.o(239746);
                return;
            case 7:
                this.zQC.reset();
                AppMethodBeat.o(239746);
                return;
            case 8:
                a aVar2 = this.zQC;
                aVar2.zQt = h.MOSAIC;
                aVar2.sTB = 0;
                com.tencent.mm.bt.b bVar3 = aVar2.zQp;
                if (bVar3 != null) {
                    bVar3.getSelectedFeatureListener().a(h.MOSAIC);
                }
                com.tencent.mm.bt.b bVar4 = aVar2.zQp;
                if (bVar4 != null) {
                    bVar4.getSelectedFeatureListener().a(h.MOSAIC, 0, null);
                }
                com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.aLu("KEY_CLICK_MOSAIC_COUNT_INT");
                com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.VH(8);
                AppMethodBeat.o(239746);
                return;
            case 9:
                a aVar3 = this.zQC;
                aVar3.zQt = h.MOSAIC;
                aVar3.sTB = 1;
                com.tencent.mm.bt.b bVar5 = aVar3.zQp;
                if (bVar5 != null) {
                    bVar5.getSelectedFeatureListener().a(h.MOSAIC);
                }
                com.tencent.mm.bt.b bVar6 = aVar3.zQp;
                if (bVar6 != null) {
                    bVar6.getSelectedFeatureListener().a(h.MOSAIC, 1, null);
                }
                com.tencent.mm.plugin.recordvideo.d.c cVar4 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.aLu("KEY_CLICK_BRUSH_COUNT_INT");
                com.tencent.mm.plugin.recordvideo.d.c cVar5 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.VH(9);
                AppMethodBeat.o(239746);
                return;
            case 10:
                if (bundle != null) {
                    a aVar4 = this.zQC;
                    int i2 = bundle.getInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT");
                    aVar4.zQt = h.DOODLE;
                    aVar4.sTB = i2;
                    com.tencent.mm.bt.b bVar7 = aVar4.zQp;
                    if (bVar7 != null) {
                        bVar7.getSelectedFeatureListener().a(h.DOODLE);
                    }
                    com.tencent.mm.bt.b bVar8 = aVar4.zQp;
                    if (bVar8 != null) {
                        bVar8.getSelectedFeatureListener().a(h.DOODLE, i2, null);
                        AppMethodBeat.o(239746);
                        return;
                    }
                    AppMethodBeat.o(239746);
                    return;
                }
                AppMethodBeat.o(239746);
                return;
            case 11:
                a aVar5 = this.zQC;
                com.tencent.mm.bt.b bVar9 = aVar5.zQp;
                if (bVar9 != null) {
                    bVar9.getSelectedFeatureListener().a(com.tencent.mm.cache.c.alF().alG(), -1, null);
                }
                com.tencent.mm.bt.b bVar10 = aVar5.zQp;
                if (bVar10 != null) {
                    bVar10.getSelectedFeatureListener().a(aVar5.zQt);
                }
                com.tencent.mm.bt.b bVar11 = aVar5.zQp;
                if (bVar11 != null) {
                    bVar11.getSelectedFeatureListener().a(aVar5.zQt, aVar5.sTB, null);
                    AppMethodBeat.o(239746);
                    return;
                }
                AppMethodBeat.o(239746);
                return;
            case 12:
                com.tencent.mm.bt.b bVar12 = this.zQC.zQp;
                if (bVar12 != null) {
                    bVar12.getSelectedFeatureListener().a(h.EMOJI);
                    AppMethodBeat.o(239746);
                    return;
                }
                AppMethodBeat.o(239746);
                return;
            case 13:
                a.b.a(this.zQD, a.c.HIDE_DOODLE_LAYOUT);
                AppMethodBeat.o(239746);
                return;
            case 14:
                com.tencent.mm.bt.b bVar13 = this.zQC.zQp;
                if (bVar13 != null) {
                    bVar13.getSelectedFeatureListener().a(h.TEXT);
                    AppMethodBeat.o(239746);
                    return;
                }
                AppMethodBeat.o(239746);
                return;
            case 15:
                if (bundle != null) {
                    CharSequence charSequence = bundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
                    int i3 = bundle.getInt("PARAM_EDIT_TEXT_COLOR");
                    int i4 = bundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
                    a aVar6 = this.zQC;
                    Editable editable = (Editable) charSequence;
                    if (editable == null) {
                        p.hyc();
                    }
                    p.h(editable, "text");
                    editable.clearSpans();
                    com.tencent.mm.bt.b bVar14 = aVar6.zQp;
                    if (bVar14 != null) {
                        bVar14.getSelectedFeatureListener().a(h.TEXT);
                    }
                    com.tencent.mm.bt.b bVar15 = aVar6.zQp;
                    if (bVar15 != null) {
                        bVar15.a(editable, i3, i4);
                    }
                    kotlin.g.a.a<x> aVar7 = aVar6.zQr;
                    if (aVar7 != null) {
                        aVar7.invoke();
                        AppMethodBeat.o(239746);
                        return;
                    }
                    AppMethodBeat.o(239746);
                    return;
                }
                AppMethodBeat.o(239746);
                return;
            case 16:
                a aVar8 = this.zQC;
                if (aVar8 != null) {
                    kotlin.g.a.a<x> aVar9 = aVar8.zQr;
                    if (aVar9 != null) {
                        aVar9.invoke();
                        AppMethodBeat.o(239746);
                        return;
                    }
                    AppMethodBeat.o(239746);
                    return;
                }
                AppMethodBeat.o(239746);
                return;
            case 17:
                if (bundle != null) {
                    bundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
                    bundle.getInt("PARAM_EDIT_TEXT_COLOR");
                    bundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
                    AppMethodBeat.o(239746);
                    return;
                }
                AppMethodBeat.o(239746);
                return;
            case 18:
                a aVar10 = this.zQC;
                if (!aVar10.isFinishing) {
                    Context context = aVar10.context;
                    if (context == null) {
                        t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                        AppMethodBeat.o(239746);
                        throw tVar;
                    } else if (!((Activity) context).isFinishing()) {
                        aVar10.isFinishing = true;
                        ab abVar = aVar10.zCl;
                        if (abVar != null) {
                            abVar.a(new a.b(aVar10));
                            AppMethodBeat.o(239746);
                            return;
                        }
                    }
                }
                AppMethodBeat.o(239746);
                return;
        }
        AppMethodBeat.o(239746);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final boolean onBackPress() {
        AppMethodBeat.i(239747);
        super.onBackPress();
        AppMethodBeat.o(239747);
        return true;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final void setBitmap(Bitmap bitmap2) {
        this.bitmap = bitmap2;
    }

    public final int getMWidth() {
        return this.mWidth;
    }

    public final void setMWidth(int i2) {
        this.mWidth = i2;
    }

    public final int getMHeight() {
        return this.mHeight;
    }

    public final void setMHeight(int i2) {
        this.mHeight = i2;
    }
}
