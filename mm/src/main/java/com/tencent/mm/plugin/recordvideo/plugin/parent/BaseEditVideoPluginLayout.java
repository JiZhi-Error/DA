package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.ab;
import com.tencent.mm.plugin.recordvideo.plugin.d;
import com.tencent.mm.plugin.recordvideo.plugin.e;
import com.tencent.mm.plugin.recordvideo.plugin.f;
import com.tencent.mm.plugin.recordvideo.plugin.g;
import com.tencent.mm.plugin.recordvideo.plugin.h;
import com.tencent.mm.plugin.recordvideo.plugin.i;
import com.tencent.mm.plugin.recordvideo.plugin.p;
import com.tencent.mm.plugin.recordvideo.plugin.q;
import com.tencent.mm.plugin.recordvideo.plugin.r;
import com.tencent.mm.plugin.recordvideo.plugin.s;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 q2\u00020\u00012\u00020\u0002:\u0001qB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010^\u001a\u00020_H\u0016J\b\u0010`\u001a\u00020aH&J\b\u0010b\u001a\u00020cH\u0004J\u0018\u0010d\u001a\u00020c2\u0006\u0010J\u001a\u00020K2\u0006\u0010.\u001a\u00020/H\u0016J\b\u0010e\u001a\u00020cH\u0002J\u0012\u0010f\u001a\u00020c2\b\u0010g\u001a\u0004\u0018\u00010)H\u0016J\b\u0010h\u001a\u00020cH\u0016J\u0010\u0010i\u001a\u00020c2\u0006\u0010j\u001a\u00020kH\u0004J\u001a\u0010l\u001a\u00020c2\u0006\u0010m\u001a\u00020n2\b\u0010o\u001a\u0004\u0018\u00010pH\u0016R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u00104\u001a\u000205X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0010\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010:\u001a\u00020;X\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020?X\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020CX\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0014\u0010F\u001a\u00020GX\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u001c\u0010J\u001a\u0004\u0018\u00010KX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001a\u0010P\u001a\u00020QX.¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0014\u0010V\u001a\u00020WX\u0004¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u0014\u0010Z\u001a\u00020[X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]¨\u0006r"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "addEmojiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "getAddEmojiPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "addMusicPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin;", "getAddMusicPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/music/EditAddMusicPlugin;", "addPoiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin;", "getAddPoiPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddPoiPlugin;", "addTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "getAddTextPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "addTipPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTipPlugin;", "getAddTipPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTipPlugin;", "addonTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoAddonTextPlugin;", "getAddonTextPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoAddonTextPlugin;", "backToRecordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "getBackToRecordPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "bgPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoBgPlugin;", "getBgPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoBgPlugin;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "getCaptureInfo", "()Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "cropVideoPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "getCropVideoPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/cropvideo/EditCropVideoPlugin;", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "editFinishPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "getEditFinishPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "inputPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "getInputPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "itemContainerPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditItemContainerPlugin;", "getItemContainerPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditItemContainerPlugin;", "moreMenuPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin;", "getMoreMenuPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditMenuPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "getNavigator", "()Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "setNavigator", "(Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;)V", "previewPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "getPreviewPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;", "setPreviewPlugin", "(Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoPlayPlugin;)V", "reMuxPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "getReMuxPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "videoControlContainerPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "getVideoControlContainerPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditVideoControlContainerPlugin;", "getLayoutId", "", "getPlayerView", "Landroid/view/View;", "hideDialog", "", "initLogic", "initSafeArea", "loadCurrentPage", "info", "loadPlayerView", "showDialog", "tip", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public abstract class BaseEditVideoPluginLayout extends BasePluginLayout implements d {
    public static final a BUc = new a((byte) 0);
    private com.tencent.mm.media.widget.camerarecordview.b.b BQt;
    protected s BTM;
    private final com.tencent.mm.plugin.recordvideo.plugin.a BTN;
    private final h BTO;
    private final r BTP;
    private final com.tencent.mm.plugin.recordvideo.plugin.c BTQ;
    private final d BTR;
    private final com.tencent.mm.plugin.recordvideo.plugin.b BTS;
    private final com.tencent.mm.plugin.recordvideo.plugin.a.a BTT;
    private final com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a BTU;
    private final f BTV;
    private final e BTW;
    private final ab BTX;
    private final p BTY;
    private final q BTZ;
    private final i BUa;
    private final g BUb;
    public com.tencent.mm.ui.base.q nUq;
    private com.tencent.mm.plugin.recordvideo.activity.a wdl;
    private RecordConfigProvider wdm;

    public abstract View getPlayerView();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseEditVideoPluginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.g.b.p.h(context, "context");
        this.BTX = new ab(context);
        Log.i("MicroMsg.EditorVideoPluginLayout", "EditorVideoPluginLayoutNew invoke init");
        LayoutInflater.from(context).inflate(getLayoutId(), (ViewGroup) this, true);
        View playerView = getPlayerView();
        ViewStub viewStub = (ViewStub) findViewById(R.id.gc3);
        kotlin.g.b.p.g(viewStub, "placeholder");
        ViewParent parent = viewStub.getParent();
        if (parent == null) {
            throw new t("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        int indexOfChild = viewGroup.indexOfChild(viewStub);
        viewGroup.removeViewAt(indexOfChild);
        viewGroup.addView(playerView, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
        View findViewById = findViewById(R.id.bwl);
        kotlin.g.b.p.g(findViewById, "findViewById(R.id.editor_add_emoji)");
        this.BTN = new com.tencent.mm.plugin.recordvideo.plugin.a(this, (ImageView) findViewById, this);
        View findViewById2 = findViewById(R.id.bxc);
        kotlin.g.b.p.g(findViewById2, "findViewById(R.id.editor_item_container)");
        this.BTO = new h((EditorItemContainer) findViewById2, this);
        View findViewById3 = findViewById(R.id.bfp);
        kotlin.g.b.p.g(findViewById3, "findViewById(R.id.control_container)");
        this.BTP = new r((ViewGroup) findViewById3, this);
        View findViewById4 = findViewById(R.id.ar2);
        kotlin.g.b.p.g(findViewById4, "findViewById(R.id.change_text_root)");
        this.BUb = new g((EditorInputView) findViewById4);
        this.BTQ = new com.tencent.mm.plugin.recordvideo.plugin.c(this, this, this.BUb.BPY);
        this.BTT = new com.tencent.mm.plugin.recordvideo.plugin.a.a(this, this);
        this.BTU = new com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a(this, this);
        View findViewById5 = findViewById(R.id.bxg);
        kotlin.g.b.p.g(findViewById5, "findViewById(R.id.editor_mix)");
        this.BTV = new f(findViewById5, this);
        View findViewById6 = findViewById(R.id.bx1);
        kotlin.g.b.p.g(findViewById6, "findViewById(R.id.editor_close)");
        this.BTW = new e((ImageView) findViewById6, this);
        View findViewById7 = findViewById(R.id.c7a);
        kotlin.g.b.p.g(findViewById7, "findViewById(R.id.ext_text_area)");
        this.BTY = new p((TextView) findViewById7, this);
        View findViewById8 = findViewById(R.id.gxt);
        kotlin.g.b.p.g(findViewById8, "findViewById(R.id.recorder_black_mask)");
        this.BTZ = new q((ImageView) findViewById8, this);
        this.BTR = new d(this, this, this.BUb.BPY);
        this.BTS = new com.tencent.mm.plugin.recordvideo.plugin.b(this, this);
        this.BUa = new i(this, this);
        getPluginList().add(this.BTN);
        getPluginList().add(this.BTO);
        getPluginList().add(this.BTP);
        getPluginList().add(this.BTQ);
        getPluginList().add(this.BTT);
        getPluginList().add(this.BTU);
        getPluginList().add(this.BTV);
        getPluginList().add(this.BTX);
        getPluginList().add(this.BTW);
        getPluginList().add(this.BTY);
        getPluginList().add(this.BTZ);
        getPluginList().add(this.BTR);
        getPluginList().add(this.BTS);
        getPluginList().add(this.BUa);
        com.tencent.mm.plugin.recordvideo.model.a aVar = com.tencent.mm.plugin.recordvideo.model.a.BOO;
        int displayHeight = com.tencent.mm.plugin.recordvideo.model.a.getDisplayHeight();
        com.tencent.mm.plugin.recordvideo.model.a aVar2 = com.tencent.mm.plugin.recordvideo.model.a.BOO;
        int eJO = com.tencent.mm.plugin.recordvideo.model.a.eJO();
        float f2 = ((float) displayHeight) / ((float) eJO);
        float f3 = ((float) displayHeight) / 2.18f;
        float f4 = (((float) eJO) - f3) / 2.0f;
        float f5 = ((float) eJO) * 1.78f;
        float f6 = (((float) displayHeight) - f5) / 2.0f;
        if (f2 <= 1.78f) {
            this.BUb.bL(f4);
            this.BTO.ac(f3, f4);
        } else if (f2 >= 2.18f) {
            this.BUb.bM(f4);
            this.BTO.ad(f5, f6);
        } else {
            this.BUb.bL(f4);
            this.BUb.bM(f4);
            this.BTO.ac(f3, f4);
            this.BTO.ad(f5, f6);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final com.tencent.mm.plugin.recordvideo.activity.a getNavigator() {
        return this.wdl;
    }

    /* access modifiers changed from: protected */
    public final void setNavigator(com.tencent.mm.plugin.recordvideo.activity.a aVar) {
        this.wdl = aVar;
    }

    public final s getPreviewPlugin() {
        s sVar = this.BTM;
        if (sVar == null) {
            kotlin.g.b.p.btv("previewPlugin");
        }
        return sVar;
    }

    /* access modifiers changed from: protected */
    public final void setPreviewPlugin(s sVar) {
        kotlin.g.b.p.h(sVar, "<set-?>");
        this.BTM = sVar;
    }

    /* access modifiers changed from: protected */
    public final com.tencent.mm.plugin.recordvideo.plugin.a getAddEmojiPlugin() {
        return this.BTN;
    }

    /* access modifiers changed from: protected */
    public final h getItemContainerPlugin() {
        return this.BTO;
    }

    /* access modifiers changed from: protected */
    public final r getVideoControlContainerPlugin() {
        return this.BTP;
    }

    /* access modifiers changed from: protected */
    public final com.tencent.mm.plugin.recordvideo.plugin.c getAddTextPlugin() {
        return this.BTQ;
    }

    /* access modifiers changed from: protected */
    public final d getAddTipPlugin() {
        return this.BTR;
    }

    /* access modifiers changed from: protected */
    public final com.tencent.mm.plugin.recordvideo.plugin.b getAddPoiPlugin() {
        return this.BTS;
    }

    /* access modifiers changed from: protected */
    public final com.tencent.mm.plugin.recordvideo.plugin.a.a getAddMusicPlugin() {
        return this.BTT;
    }

    /* access modifiers changed from: protected */
    public final com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a getCropVideoPlugin() {
        return this.BTU;
    }

    public final f getEditFinishPlugin() {
        return this.BTV;
    }

    public final e getBackToRecordPlugin() {
        return this.BTW;
    }

    /* access modifiers changed from: protected */
    public final ab getReMuxPlugin() {
        return this.BTX;
    }

    /* access modifiers changed from: protected */
    public final p getAddonTextPlugin() {
        return this.BTY;
    }

    /* access modifiers changed from: protected */
    public final q getBgPlugin() {
        return this.BTZ;
    }

    /* access modifiers changed from: protected */
    public final i getMoreMenuPlugin() {
        return this.BUa;
    }

    /* access modifiers changed from: protected */
    public final g getInputPlugin() {
        return this.BUb;
    }

    /* access modifiers changed from: protected */
    public final RecordConfigProvider getConfigProvider() {
        return this.wdm;
    }

    /* access modifiers changed from: protected */
    public final void setConfigProvider(RecordConfigProvider recordConfigProvider) {
        this.wdm = recordConfigProvider;
    }

    /* access modifiers changed from: protected */
    public final com.tencent.mm.media.widget.camerarecordview.b.b getCaptureInfo() {
        return this.BQt;
    }

    /* access modifiers changed from: protected */
    public final void setCaptureInfo(com.tencent.mm.media.widget.camerarecordview.b.b bVar) {
        this.BQt = bVar;
    }

    public int getLayoutId() {
        return R.layout.c5c;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public void a(com.tencent.mm.plugin.recordvideo.activity.a aVar, RecordConfigProvider recordConfigProvider) {
        Map<String, Boolean> map;
        Boolean bool;
        Integer num = null;
        kotlin.g.b.p.h(aVar, "navigator");
        kotlin.g.b.p.h(recordConfigProvider, "configProvider");
        this.wdl = aVar;
        this.wdm = recordConfigProvider;
        com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
        com.tencent.mm.plugin.recordvideo.e.c.e(recordConfigProvider);
        h hVar = this.BTO;
        kotlin.g.b.p.h(recordConfigProvider, "configProvider");
        EditorItemContainer editorItemContainer = hVar.BQh;
        kotlin.g.b.p.h(recordConfigProvider, "configProvider");
        editorItemContainer.wdm = recordConfigProvider;
        this.BTT.setVisibility(0);
        this.BTU.setVisibility(0);
        f fVar = this.BTV;
        UICustomParam uICustomParam = recordConfigProvider.BOn;
        Integer valueOf = uICustomParam != null ? Integer.valueOf(uICustomParam.gLM) : null;
        UICustomParam uICustomParam2 = recordConfigProvider.BOn;
        Integer valueOf2 = uICustomParam2 != null ? Integer.valueOf(uICustomParam2.gLN) : null;
        UICustomParam uICustomParam3 = recordConfigProvider.BOn;
        String str = uICustomParam3 != null ? uICustomParam3.text : null;
        UICustomParam uICustomParam4 = recordConfigProvider.BOn;
        fVar.a(valueOf, valueOf2, str, uICustomParam4 != null ? Integer.valueOf(uICustomParam4.gLO) : null);
        com.tencent.mm.plugin.recordvideo.plugin.a.a aVar2 = this.BTT;
        UICustomParam uICustomParam5 = recordConfigProvider.BOn;
        Integer valueOf3 = uICustomParam5 != null ? Integer.valueOf(uICustomParam5.gLM) : null;
        UICustomParam uICustomParam6 = recordConfigProvider.BOn;
        com.tencent.mm.plugin.recordvideo.plugin.a.a.a(aVar2, valueOf3, uICustomParam6 != null ? Integer.valueOf(uICustomParam6.gLN) : null);
        p pVar = this.BTY;
        UICustomParam uICustomParam7 = recordConfigProvider.BOn;
        pVar.setText(uICustomParam7 != null ? uICustomParam7.gLP : null);
        com.tencent.mm.plugin.recordvideo.plugin.c cVar2 = this.BTQ;
        UICustomParam uICustomParam8 = recordConfigProvider.BOn;
        Integer valueOf4 = uICustomParam8 != null ? Integer.valueOf(uICustomParam8.gLM) : null;
        UICustomParam uICustomParam9 = recordConfigProvider.BOn;
        cVar2.a(valueOf4, uICustomParam9 != null ? Integer.valueOf(uICustomParam9.gLN) : null);
        com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a aVar3 = this.BTU;
        UICustomParam uICustomParam10 = recordConfigProvider.BOn;
        Integer valueOf5 = uICustomParam10 != null ? Integer.valueOf(uICustomParam10.gLM) : null;
        UICustomParam uICustomParam11 = recordConfigProvider.BOn;
        if (uICustomParam11 != null) {
            num = Integer.valueOf(uICustomParam11.gLN);
        }
        Button finishButton = aVar3.BSs.getFinishButton();
        if (finishButton != null) {
            if (!(valueOf5 == null || valueOf5.intValue() == 0)) {
                finishButton.setBackgroundResource(valueOf5.intValue());
            }
            if (!(num == null || num.intValue() == 0 || !(finishButton instanceof TextView))) {
                finishButton.setTextColor(android.support.v4.content.b.n(finishButton.getContext(), num.intValue()));
            }
        }
        this.BUa.setScene(recordConfigProvider.scene);
        d dVar = this.BTR;
        Map<String, Boolean> map2 = recordConfigProvider.BOn.gLL;
        kotlin.g.b.p.g(map2, "configProvider.uiParam.pluginHiddenMap");
        dVar.BQc = map2.containsKey("plugin_tip") ? 8 : 0;
        for (T t : getPluginList()) {
            UICustomParam uICustomParam12 = recordConfigProvider.BOn;
            t.setVisibility(!((uICustomParam12 == null || (map = uICustomParam12.gLL) == null || (bool = map.get(t.name())) == null) ? false : bool.booleanValue()) ? 0 : 8);
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public void a(com.tencent.mm.media.widget.camerarecordview.b.b bVar) {
        super.a(bVar);
        this.BQt = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x03e6  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x03fa  */
    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.d
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.tencent.mm.plugin.recordvideo.plugin.parent.d.c r17, android.os.Bundle r18) {
        /*
        // Method dump skipped, instructions count: 2074
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout.a(com.tencent.mm.plugin.recordvideo.plugin.parent.d$c, android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public final void aLt(String str) {
        kotlin.g.b.p.h(str, "tip");
        Log.i("MicroMsg.EditorVideoPluginLayout", "showDialog");
        Context context = getContext();
        if (context == null) {
            throw new t("null cannot be cast to non-null type android.app.Activity");
        }
        ((Activity) context).runOnUiThread(new c(this, str));
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ BaseEditVideoPluginLayout BUd;
        final /* synthetic */ String hRn;

        c(BaseEditVideoPluginLayout baseEditVideoPluginLayout, String str) {
            this.BUd = baseEditVideoPluginLayout;
            this.hRn = str;
        }

        public final void run() {
            AppMethodBeat.i(75763);
            this.BUd.nUq = com.tencent.mm.ui.base.h.a(this.BUd.getContext(), this.hRn, false, (DialogInterface.OnCancelListener) null);
            AppMethodBeat.o(75763);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ BaseEditVideoPluginLayout BUd;

        public b(BaseEditVideoPluginLayout baseEditVideoPluginLayout) {
            this.BUd = baseEditVideoPluginLayout;
        }

        public final void run() {
            AppMethodBeat.i(75762);
            com.tencent.mm.ui.base.q qVar = this.BUd.nUq;
            if (qVar != null) {
                qVar.dismiss();
            }
            this.BUd.nUq = null;
            AppMethodBeat.o(75762);
        }
    }
}
