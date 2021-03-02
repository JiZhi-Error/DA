package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.ab;
import com.tencent.mm.component.api.jumper.UICustomParam;
import com.tencent.mm.e.d;
import com.tencent.mm.e.h;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.activity.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.c;
import com.tencent.mm.plugin.recordvideo.plugin.doodle.PhotoDoodlePlugin;
import com.tencent.mm.plugin.recordvideo.plugin.e;
import com.tencent.mm.plugin.recordvideo.plugin.f;
import com.tencent.mm.plugin.recordvideo.plugin.g;
import com.tencent.mm.plugin.recordvideo.plugin.j;
import com.tencent.mm.plugin.recordvideo.plugin.k;
import com.tencent.mm.plugin.recordvideo.plugin.m;
import com.tencent.mm.plugin.recordvideo.plugin.n;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0001IB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010<\u001a\u00020=H\u0016J\u0018\u0010>\u001a\u00020?2\u0006\u00106\u001a\u0002072\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010@\u001a\u00020?2\b\u0010A\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010B\u001a\u00020CH\u0016J\u001a\u0010D\u001a\u00020?2\u0006\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020'X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020+X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020/X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u000e\u00102\u001a\u000203X\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0004¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u000e¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\u000209X\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;¨\u0006J"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "addEmojiPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "getAddEmojiPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddEmojiPlugin;", "backToRecordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "getBackToRecordPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditBackToRecordPlugin;", "captureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "getCaptureInfo", "()Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "setCaptureInfo", "(Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;)V", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getConfigProvider", "()Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setConfigProvider", "(Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;)V", "editAddTextPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "getEditAddTextPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "editCropPhotoPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoCropPlugin;", "getEditCropPhotoPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoCropPlugin;", "editFilterPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/filter/EditPhotoFilterPlugin;", "editFinishPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "getEditFinishPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditFinishPlugin;", "editPencilPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin;", "getEditPencilPlugin", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoPencilPlugin;", "editPhotoWrapper", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin;", "getEditPhotoWrapper", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin;", "editShadowPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoShadowPlugin;", "inputPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditInputPlugin;", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "photoControlUI", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin;", "getPhotoControlUI", "()Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoControlPlugin;", "getLayoutId", "", "initLogic", "", "loadCurrentPage", "info", "onBackPress", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public class EditPhotoPluginLayout extends BasePluginLayout implements d {
    public static final a BUm = new a((byte) 0);
    private b BQt;
    private final com.tencent.mm.plugin.recordvideo.plugin.a BTN;
    private final f BTV;
    private final e BTW;
    private final g BUb;
    private final m BUf = new m(this, this);
    private final com.tencent.mm.plugin.recordvideo.plugin.filter.a BUg = new com.tencent.mm.plugin.recordvideo.plugin.filter.a(this, this);
    private final com.tencent.mm.plugin.recordvideo.plugin.l BUh;
    private final j BUi;
    private final k BUj;
    private final c BUk;
    private final n BUl;
    private com.tencent.mm.plugin.recordvideo.activity.a wdl;
    private RecordConfigProvider wdm;

    static {
        AppMethodBeat.i(75770);
        AppMethodBeat.o(75770);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditPhotoPluginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(75769);
        View.inflate(context, getLayoutId(), this);
        View findViewById = findViewById(R.id.ar2);
        p.g(findViewById, "findViewById(R.id.change_text_root)");
        this.BUb = new g((EditorInputView) findViewById);
        View findViewById2 = findViewById(R.id.bx1);
        p.g(findViewById2, "findViewById(R.id.editor_close)");
        this.BTW = new e((ImageView) findViewById2, this);
        View findViewById3 = findViewById(R.id.bwl);
        p.g(findViewById3, "findViewById(R.id.editor_add_emoji)");
        this.BTN = new com.tencent.mm.plugin.recordvideo.plugin.a(this, (ImageView) findViewById3, this);
        this.BUk = new c(this, this, this.BUb.BPY);
        View findViewById4 = findViewById(R.id.bxk);
        p.g(findViewById4, "findViewById(R.id.editor_photo_crop)");
        this.BUh = new com.tencent.mm.plugin.recordvideo.plugin.l((ImageView) findViewById4, this);
        View findViewById5 = findViewById(R.id.bxg);
        p.g(findViewById5, "findViewById(R.id.editor_mix)");
        this.BTV = new f(findViewById5, this);
        View findViewById6 = findViewById(R.id.gbe);
        p.g(findViewById6, "findViewById(R.id.photo_preview_plugin)");
        this.BUi = new j((FrameLayout) findViewById6, this);
        View findViewById7 = findViewById(R.id.bfp);
        p.g(findViewById7, "findViewById(R.id.control_container)");
        this.BUj = new k((ViewGroup) findViewById7, this);
        View findViewById8 = findViewById(R.id.hn_);
        p.g(findViewById8, "findViewById(R.id.shadow_bg)");
        this.BUl = new n(findViewById8, this);
        this.BTN.setVisibility(0);
        this.BUk.setVisibility(0);
        this.BUf.setVisibility(0);
        getPluginList().add(this.BUj);
        getPluginList().add(this.BUf);
        getPluginList().add(this.BUg);
        getPluginList().add(this.BUh);
        getPluginList().add(this.BUi);
        getPluginList().add(this.BTW);
        getPluginList().add(this.BTN);
        getPluginList().add(this.BTV);
        getPluginList().add(this.BUk);
        AppMethodBeat.o(75769);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
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

    /* access modifiers changed from: protected */
    public final b getCaptureInfo() {
        return this.BQt;
    }

    /* access modifiers changed from: protected */
    public final void setCaptureInfo(b bVar) {
        this.BQt = bVar;
    }

    /* access modifiers changed from: protected */
    public final m getEditPencilPlugin() {
        return this.BUf;
    }

    /* access modifiers changed from: protected */
    public final com.tencent.mm.plugin.recordvideo.plugin.l getEditCropPhotoPlugin() {
        return this.BUh;
    }

    /* access modifiers changed from: protected */
    public final j getEditPhotoWrapper() {
        return this.BUi;
    }

    public final e getBackToRecordPlugin() {
        return this.BTW;
    }

    /* access modifiers changed from: protected */
    public final k getPhotoControlUI() {
        return this.BUj;
    }

    /* access modifiers changed from: protected */
    public final com.tencent.mm.plugin.recordvideo.plugin.a getAddEmojiPlugin() {
        return this.BTN;
    }

    public final f getEditFinishPlugin() {
        return this.BTV;
    }

    /* access modifiers changed from: protected */
    public final c getEditAddTextPlugin() {
        return this.BUk;
    }

    public int getLayoutId() {
        return R.layout.bhz;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public void a(com.tencent.mm.plugin.recordvideo.activity.a aVar, RecordConfigProvider recordConfigProvider) {
        Map<String, Boolean> map;
        Boolean bool;
        AppMethodBeat.i(75765);
        p.h(aVar, "navigator");
        p.h(recordConfigProvider, "configProvider");
        Log.i("MicroMsg.EditPhotoPluginLayout", "configProvider ".concat(String.valueOf(recordConfigProvider)));
        this.wdl = aVar;
        this.wdm = recordConfigProvider;
        com.tencent.mm.plugin.recordvideo.e.c cVar = com.tencent.mm.plugin.recordvideo.e.c.Cic;
        com.tencent.mm.plugin.recordvideo.e.c.d(recordConfigProvider);
        for (T t : getPluginList()) {
            UICustomParam uICustomParam = recordConfigProvider.BOn;
            int i2 = !((uICustomParam == null || (map = uICustomParam.gLL) == null || (bool = map.get(t.name())) == null) ? false : bool.booleanValue()) ? 0 : 8;
            t.setVisibility(i2);
            if ((t instanceof com.tencent.mm.plugin.recordvideo.plugin.filter.a) && i2 == 0) {
                PhotoDoodlePlugin photoDoodlePlugin = this.BUf.BQL;
                photoDoodlePlugin.b(null, null);
                GridView gridView = photoDoodlePlugin.BST;
                if (gridView != null) {
                    gridView.deferNotifyDataSetChanged();
                }
            }
        }
        AppMethodBeat.o(75765);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public void a(b bVar) {
        ab eow;
        com.tencent.mm.api.e eVar;
        h hVar;
        d dVar;
        com.tencent.mm.view.footer.c cVar;
        Bundle bundle;
        float[] floatArray;
        com.tencent.mm.view.b.a baseBoardView;
        boolean z;
        RecordConfigProvider recordConfigProvider;
        AppMethodBeat.i(75766);
        super.a(bVar);
        if (bVar != null) {
            this.BQt = bVar;
            j jVar = this.BUi;
            RecordConfigProvider recordConfigProvider2 = this.wdm;
            if (recordConfigProvider2 == null) {
                p.hyc();
            }
            p.h(recordConfigProvider2, "configProvider");
            p.h(bVar, "captureInfo");
            jVar.wdm = recordConfigProvider2;
            jVar.BQt = bVar;
            j jVar2 = this.BUi;
            String str = bVar.iql;
            p.h(str, "path");
            jVar2.zQv.setVisibility(0);
            b bVar2 = jVar2.BQt;
            if (bVar2 == null || !bVar2.iqo) {
                eow = jVar2.eow();
            } else {
                eow = jVar2.eKz();
            }
            jVar2.zCl = eow;
            ab abVar = jVar2.zCl;
            if (abVar != null) {
                ab.a.C0260a aVar = new ab.a.C0260a();
                RecordConfigProvider recordConfigProvider3 = jVar2.wdm;
                if ((recordConfigProvider3 == null || recordConfigProvider3.scene != 291) && ((recordConfigProvider = jVar2.wdm) == null || recordConfigProvider.scene != 293)) {
                    z = true;
                } else {
                    z = false;
                }
                ab.a.C0260a a2 = aVar.cJ(z).VH().j(new Rect(jVar2.zQv.getLeft(), jVar2.zQv.getTop(), jVar2.zQv.getRight(), jVar2.zQv.getBottom())).a(ab.c.PHOTO);
                b bVar3 = jVar2.BQt;
                abVar.a(a2.cK(bVar3 != null && bVar3.iqf).fN(str).VJ());
            }
            ab abVar2 = jVar2.zCl;
            if (abVar2 != null) {
                eVar = abVar2.bB(jVar2.context);
            } else {
                eVar = null;
            }
            if (eVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
                AppMethodBeat.o(75766);
                throw tVar;
            }
            jVar2.BQu = (com.tencent.mm.view.m) eVar;
            RecordConfigProvider recordConfigProvider4 = jVar2.wdm;
            if (!(recordConfigProvider4 == null || (bundle = recordConfigProvider4.jkf) == null || (floatArray = bundle.getFloatArray("matrix")) == null)) {
                Matrix matrix = new Matrix();
                matrix.setValues(floatArray);
                com.tencent.mm.view.m mVar = jVar2.BQu;
                if (!(mVar == null || (baseBoardView = mVar.getBaseBoardView()) == null)) {
                    baseBoardView.setForceMatrix(matrix);
                }
            }
            com.tencent.mm.view.m mVar2 = jVar2.BQu;
            if (!(mVar2 == null || (cVar = (com.tencent.mm.view.footer.c) mVar2.getBaseFooterView()) == null)) {
                cVar.setHideFooter(true);
            }
            com.tencent.mm.view.m mVar3 = jVar2.BQu;
            if (mVar3 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.view.PhotoDrawingView");
                AppMethodBeat.o(75766);
                throw tVar2;
            }
            jVar2.zQp = mVar3.getPresenter();
            com.tencent.mm.bt.b bVar4 = jVar2.zQp;
            if (bVar4 == null) {
                t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.presenter.DrawingPresenter");
                AppMethodBeat.o(75766);
                throw tVar3;
            }
            ((com.tencent.mm.bt.a) bVar4).Kyn = new j.c(jVar2);
            jVar2.zQv.addView(jVar2.BQu, new FrameLayout.LayoutParams(-1, -1));
            com.tencent.mm.view.m mVar4 = jVar2.BQu;
            if (mVar4 != null) {
                mVar4.setSelectedFeatureListener(new j.d(jVar2));
            }
            com.tencent.mm.bt.b bVar5 = jVar2.zQp;
            if (!(bVar5 == null || (dVar = (d) bVar5.c(com.tencent.mm.api.h.DOODLE)) == null)) {
                dVar.a(new j.e(jVar2));
            }
            com.tencent.mm.bt.b bVar6 = jVar2.zQp;
            if (!(bVar6 == null || (hVar = (h) bVar6.c(com.tencent.mm.api.h.MOSAIC)) == null)) {
                hVar.a(new j.f(jVar2));
            }
            BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str);
            if (imageOptions != null) {
                com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ORIGIN_MEDIA_WIDTH_INT", Integer.valueOf(imageOptions.outWidth));
                com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ORIGIN_MEDIA_HEIGHT_INT", Integer.valueOf(imageOptions.outHeight));
            }
            com.tencent.mm.plugin.recordvideo.d.c cVar4 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            com.tencent.mm.plugin.recordvideo.d.c.x("KEY_ENTER_EDIT_PAGE_TIME_MS_LONG", Long.valueOf(System.currentTimeMillis()));
            com.tencent.mm.plugin.recordvideo.d.c cVar5 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            com.tencent.mm.plugin.recordvideo.d.c.x("KEY_EDIT_PUBLISHID_INT", Long.valueOf(System.currentTimeMillis()));
            com.tencent.mm.plugin.recordvideo.d.c cVar6 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            com.tencent.mm.plugin.recordvideo.d.c.x("KEY_MEDIA_TYPE_INT", 1);
            if (!bVar.iqf) {
                RecordConfigProvider recordConfigProvider5 = this.wdm;
                if ((recordConfigProvider5 != null ? recordConfigProvider5.scene : 0) > 0) {
                    com.tencent.mm.plugin.recordvideo.d.c cVar7 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                    com.tencent.mm.plugin.recordvideo.d.c.x("KEY_MEDIA_SOURCE_INT", 0);
                }
            }
            com.tencent.mm.media.k.e eVar2 = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aNM();
        }
        AppMethodBeat.o(75766);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.d
    public void a(d.c cVar, Bundle bundle) {
        EmojiInfo emojiInfo;
        Bitmap bitmap = null;
        AppMethodBeat.i(75767);
        p.h(cVar, "status");
        Log.i("MicroMsg.EditPhotoPluginLayout", "status :" + cVar + " , param :" + bundle);
        switch (b.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                com.tencent.mm.plugin.recordvideo.d.g gVar = com.tencent.mm.plugin.recordvideo.d.g.BXY;
                com.tencent.mm.plugin.recordvideo.d.g.ax(2, 3);
                onBackPress();
                AppMethodBeat.o(75767);
                return;
            case 2:
            case 3:
            case 4:
                this.BUj.setVisibility(4);
                AppMethodBeat.o(75767);
                return;
            case 5:
                this.BUj.setVisibility(0);
                AppMethodBeat.o(75767);
                return;
            case 6:
                if (bundle == null || (emojiInfo = (EmojiInfo) bundle.getParcelable("PARAM_EDIT_EMOJI_INFO")) == null) {
                    AppMethodBeat.o(75767);
                    return;
                }
                j jVar = this.BUi;
                p.g(emojiInfo, "this");
                EmojiInfo emojiInfo2 = emojiInfo;
                p.h(emojiInfo2, "emojiInfo");
                com.tencent.mm.bt.b bVar = jVar.zQp;
                if (bVar != null) {
                    bVar.getSelectedFeatureListener().a(com.tencent.mm.api.h.TEXT);
                }
                com.tencent.mm.bt.b bVar2 = jVar.zQp;
                if (bVar2 != null) {
                    bVar2.c(emojiInfo2);
                    AppMethodBeat.o(75767);
                    return;
                }
                AppMethodBeat.o(75767);
                return;
            case 7:
                this.BUj.eKC();
                this.BUi.reset();
                AppMethodBeat.o(75767);
                return;
            case 8:
                AppMethodBeat.o(75767);
                return;
            case 9:
                j jVar2 = this.BUi;
                jVar2.zQt = com.tencent.mm.api.h.MOSAIC;
                jVar2.sTB = 0;
                com.tencent.mm.bt.b bVar3 = jVar2.zQp;
                if (bVar3 != null) {
                    bVar3.getSelectedFeatureListener().a(com.tencent.mm.api.h.MOSAIC);
                }
                com.tencent.mm.bt.b bVar4 = jVar2.zQp;
                if (bVar4 != null) {
                    bVar4.getSelectedFeatureListener().a(com.tencent.mm.api.h.MOSAIC, 0, null);
                }
                com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.aLu("KEY_CLICK_MOSAIC_COUNT_INT");
                com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.VH(8);
                AppMethodBeat.o(75767);
                return;
            case 10:
                j jVar3 = this.BUi;
                jVar3.zQt = com.tencent.mm.api.h.MOSAIC;
                jVar3.sTB = 1;
                com.tencent.mm.bt.b bVar5 = jVar3.zQp;
                if (bVar5 != null) {
                    bVar5.getSelectedFeatureListener().a(com.tencent.mm.api.h.MOSAIC);
                }
                com.tencent.mm.bt.b bVar6 = jVar3.zQp;
                if (bVar6 != null) {
                    bVar6.getSelectedFeatureListener().a(com.tencent.mm.api.h.MOSAIC, 1, null);
                }
                com.tencent.mm.plugin.recordvideo.d.c cVar4 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.aLu("KEY_CLICK_BRUSH_COUNT_INT");
                com.tencent.mm.plugin.recordvideo.d.c cVar5 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                com.tencent.mm.plugin.recordvideo.d.c.VH(9);
                AppMethodBeat.o(75767);
                return;
            case 11:
                this.BUg.reset();
                if (bundle != null) {
                    j jVar4 = this.BUi;
                    int i2 = bundle.getInt("EDIT_PHOTO_DOODLE_PENCIL_INDEX_INT");
                    jVar4.zQt = com.tencent.mm.api.h.DOODLE;
                    jVar4.sTB = i2;
                    com.tencent.mm.bt.b bVar7 = jVar4.zQp;
                    if (bVar7 != null) {
                        bVar7.getSelectedFeatureListener().a(com.tencent.mm.api.h.DOODLE);
                    }
                    com.tencent.mm.bt.b bVar8 = jVar4.zQp;
                    if (bVar8 != null) {
                        bVar8.getSelectedFeatureListener().a(com.tencent.mm.api.h.DOODLE, i2, null);
                        AppMethodBeat.o(75767);
                        return;
                    }
                    AppMethodBeat.o(75767);
                    return;
                }
                AppMethodBeat.o(75767);
                return;
            case 12:
                this.BUf.reset();
                com.tencent.mm.plugin.recordvideo.plugin.filter.a aVar = this.BUg;
                com.tencent.mm.bt.b bVar9 = this.BUi.zQp;
                if (bVar9 != null) {
                    bitmap = bVar9.gtm();
                }
                if (bitmap != null) {
                    aVar.BTj.setPreImage(bitmap);
                }
                if (bundle != null) {
                    j jVar5 = this.BUi;
                    int i3 = bundle.getInt("EDIT_FILTER_INDEX_INT");
                    float f2 = bundle.getFloat("EDIT_FILTER_COLOR_WEIGHT_FLOAT");
                    jVar5.zQt = com.tencent.mm.api.h.FILTER;
                    jVar5.sTB = i3;
                    com.tencent.mm.bt.b bVar10 = jVar5.zQp;
                    if (bVar10 != null) {
                        bVar10.getSelectedFeatureListener().a(jVar5.zQt);
                    }
                    com.tencent.mm.bt.b bVar11 = jVar5.zQp;
                    if (bVar11 != null) {
                        bVar11.getSelectedFeatureListener().a(jVar5.zQt, jVar5.sTB, Float.valueOf(f2));
                        AppMethodBeat.o(75767);
                        return;
                    }
                    AppMethodBeat.o(75767);
                    return;
                }
                AppMethodBeat.o(75767);
                return;
            case 13:
                j jVar6 = this.BUi;
                com.tencent.mm.bt.b bVar12 = jVar6.zQp;
                if (bVar12 != null) {
                    bVar12.getSelectedFeatureListener().a(com.tencent.mm.cache.c.alF().alG(), -1, null);
                }
                com.tencent.mm.bt.b bVar13 = jVar6.zQp;
                if (bVar13 != null) {
                    bVar13.getSelectedFeatureListener().a(jVar6.zQt);
                }
                com.tencent.mm.bt.b bVar14 = jVar6.zQp;
                if (bVar14 != null) {
                    bVar14.getSelectedFeatureListener().a(jVar6.zQt, jVar6.sTB, null);
                    AppMethodBeat.o(75767);
                    return;
                }
                AppMethodBeat.o(75767);
                return;
            case 14:
                this.BTW.setVisibility(0);
                this.BUj.setVisibility(0);
                break;
            case 15:
                this.BTW.setVisibility(4);
                this.BUj.setVisibility(4);
                com.tencent.mm.bt.b bVar15 = this.BUi.zQp;
                if (bVar15 != null) {
                    bVar15.getSelectedFeatureListener().a(com.tencent.mm.api.h.EMOJI);
                    AppMethodBeat.o(75767);
                    return;
                }
                AppMethodBeat.o(75767);
                return;
            case 16:
                this.BTW.setVisibility(4);
                this.BUj.setVisibility(4);
                com.tencent.mm.bt.b bVar16 = this.BUi.zQp;
                if (bVar16 != null) {
                    bVar16.getSelectedFeatureListener().a(com.tencent.mm.api.h.TEXT);
                    AppMethodBeat.o(75767);
                    return;
                }
                AppMethodBeat.o(75767);
                return;
            case 17:
                if (bundle != null) {
                    CharSequence charSequence = bundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT");
                    int i4 = bundle.getInt("PARAM_EDIT_TEXT_COLOR");
                    int i5 = bundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT");
                    j jVar7 = this.BUi;
                    Editable editable = (Editable) charSequence;
                    if (editable == null) {
                        p.hyc();
                    }
                    p.h(editable, "text");
                    editable.clearSpans();
                    com.tencent.mm.bt.b bVar17 = jVar7.zQp;
                    if (bVar17 != null) {
                        bVar17.getSelectedFeatureListener().a(com.tencent.mm.api.h.TEXT);
                    }
                    com.tencent.mm.bt.b bVar18 = jVar7.zQp;
                    if (bVar18 != null) {
                        bVar18.a(editable, i4, i5);
                        AppMethodBeat.o(75767);
                        return;
                    }
                    AppMethodBeat.o(75767);
                    return;
                }
                AppMethodBeat.o(75767);
                return;
            case 18:
                if (bundle != null) {
                    c.a(this.BUk, bundle.getCharSequence("PARAM_EDIT_TEXT_CONTENT"), bundle.getInt("PARAM_EDIT_TEXT_COLOR"), bundle.getInt("PARAM_EDIT_TEXT_COLOR_BG_INT"));
                    AppMethodBeat.o(75767);
                    return;
                }
                AppMethodBeat.o(75767);
                return;
            case 19:
                this.BTW.setVisibility(0);
                this.BUj.eKC();
                this.BUf.eox();
                this.BUi.eKB();
                AppMethodBeat.o(75767);
                return;
            case 20:
                this.BUi.dJF();
                AppMethodBeat.o(75767);
                return;
            case 21:
                this.BUf.BQL.setVisibility(4);
                this.BTW.setVisibility(4);
                k kVar = this.BUj;
                kVar.BQF = k.a.CROP_FUNC;
                ViewGroup viewGroup = kVar.BQB;
                p.g(viewGroup, "normalFuncLayout");
                viewGroup.setVisibility(4);
                ViewGroup viewGroup2 = kVar.BQC;
                p.g(viewGroup2, "cropFuncLayout");
                viewGroup2.setVisibility(0);
                j jVar8 = this.BUi;
                if (jVar8.zQt != com.tencent.mm.api.h.CROP_PHOTO) {
                    jVar8.zQt = com.tencent.mm.api.h.CROP_PHOTO;
                    com.tencent.mm.bt.b bVar19 = jVar8.zQp;
                    if (bVar19 != null) {
                        bVar19.getSelectedFeatureListener().a(com.tencent.mm.api.h.CROP_PHOTO);
                        AppMethodBeat.o(75767);
                        return;
                    }
                }
                AppMethodBeat.o(75767);
                return;
            case 22:
                this.BTW.setVisibility(0);
                this.BUi.eKA();
                this.BUf.eox();
                AppMethodBeat.o(75767);
                return;
            case 23:
                j jVar9 = this.BUi;
                jVar9.zQt = com.tencent.mm.api.h.CROP_PHOTO;
                com.tencent.mm.bt.b bVar20 = jVar9.zQp;
                if (bVar20 != null) {
                    bVar20.getSelectedFeatureListener().a(com.tencent.mm.api.h.CROP_PHOTO, 0, null);
                    AppMethodBeat.o(75767);
                    return;
                }
                AppMethodBeat.o(75767);
                return;
            case 24:
                j jVar10 = this.BUi;
                jVar10.zQt = com.tencent.mm.api.h.CROP_PHOTO;
                com.tencent.mm.bt.b bVar21 = jVar10.zQp;
                if (bVar21 != null) {
                    bVar21.getSelectedFeatureListener().a(com.tencent.mm.api.h.CROP_PHOTO, 3, null);
                    AppMethodBeat.o(75767);
                    return;
                }
                AppMethodBeat.o(75767);
                return;
            case 25:
                if (this.BUj.wgR.getVisibility() != 4) {
                    if (this.BUj.wgR.getVisibility() == 0) {
                        this.BUj.setVisibility(4);
                    }
                    AppMethodBeat.o(75767);
                    return;
                }
                this.BUj.setVisibility(0);
                break;
            case 26:
                this.BUj.setVisibility(4);
                AppMethodBeat.o(75767);
                return;
            case 27:
                this.BUj.setVisibility(0);
                break;
        }
        AppMethodBeat.o(75767);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final boolean onBackPress() {
        AppMethodBeat.i(75768);
        if (!super.onBackPress()) {
            com.tencent.mm.media.k.e eVar = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aNP();
            com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            com.tencent.mm.plugin.recordvideo.d.c.x("KEY_AFTER_EDIT_INT", 0);
            com.tencent.mm.plugin.recordvideo.activity.a aVar = this.wdl;
            if (aVar != null) {
                a.C1633a.a(aVar);
            }
        }
        AppMethodBeat.o(75768);
        return true;
    }
}
