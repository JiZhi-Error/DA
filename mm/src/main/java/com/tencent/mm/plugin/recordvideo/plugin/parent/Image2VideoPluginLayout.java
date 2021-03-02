package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.jf;
import com.tencent.mm.media.widget.camerarecordview.b.b;
import com.tencent.mm.plugin.recordvideo.activity.a;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.plugin.ab;
import com.tencent.mm.plugin.recordvideo.plugin.h;
import com.tencent.mm.plugin.recordvideo.plugin.o;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.ui.editor.StoryFakeVideoPlayView;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.m;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.s;
import com.tencent.mm.protocal.protobuf.cka;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\u001a\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/Image2VideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "photoToViewPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/EditPhotoToVideoPlugin;", "createReportString", "", "city", "poiName", "getPlayerView", "Landroid/view/View;", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "", "prepareImageSizeReport", "prepareStoryBehaviorReport", "prepareStoryFailBehaviorReport", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public final class Image2VideoPluginLayout extends BaseEditVideoPluginLayout implements d {
    public static final a BWZ = new a((byte) 0);
    private o BWY;

    static {
        AppMethodBeat.i(75793);
        AppMethodBeat.o(75793);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Image2VideoPluginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(75792);
        AppMethodBeat.o(75792);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/Image2VideoPluginLayout$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout
    public final View getPlayerView() {
        AppMethodBeat.i(75786);
        StoryFakeVideoPlayView storyFakeVideoPlayView = new StoryFakeVideoPlayView(getContext());
        storyFakeVideoPlayView.setAlpha(0.0f);
        Log.i("MicroMsg.Image2VideoPluginLayout", "playerView :".concat(String.valueOf(storyFakeVideoPlayView)));
        o oVar = new o(storyFakeVideoPlayView, this);
        this.BWY = oVar;
        getPluginList().add(oVar);
        StoryFakeVideoPlayView storyFakeVideoPlayView2 = storyFakeVideoPlayView;
        AppMethodBeat.o(75786);
        return storyFakeVideoPlayView2;
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final void a(b bVar) {
        AppMethodBeat.i(75787);
        super.a(bVar);
        Log.i("MicroMsg.Image2VideoPluginLayout", "loadCurrentPage info ".concat(String.valueOf(bVar)));
        if (bVar != null) {
            o oVar = this.BWY;
            if (oVar != null) {
                p.h(bVar, "info");
                Log.i("MicroMsg.EditPhotoToVideoPlugin", "start preview ".concat(String.valueOf(bVar)));
                oVar.BQt = bVar;
                oVar.BQN.setVisibility(0);
                oVar.BQN.setAlpha(0.0f);
                oVar.BQN.setCallback(oVar.BQM);
                oVar.BQN.aK(bVar.iqm);
                oVar.dvv = bVar.dvv;
                oVar.iqg = bVar.iqg;
            }
            ab reMuxPlugin = getReMuxPlugin();
            RecordConfigProvider configProvider = getConfigProvider();
            if (configProvider == null) {
                p.hyc();
            }
            reMuxPlugin.a(bVar, configProvider);
        }
        AppMethodBeat.o(75787);
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.d
    public final void a(d.c cVar, Bundle bundle) {
        int i2;
        ArrayList<String> arrayList;
        int i3;
        b bVar;
        int i4 = 0;
        AppMethodBeat.i(75788);
        p.h(cVar, "status");
        if (cVar != d.c.BVq) {
            Log.i("MicroMsg.Image2VideoPluginLayout", "statusChange " + cVar + " ,param : " + bundle);
        }
        switch (e.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                getItemContainerPlugin().onPause();
                getAddMusicPlugin().onPause();
                if (getMoreMenuPlugin().BQn) {
                    i2 = 1;
                } else {
                    i2 = 0;
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
                boolean muteOrigin = getAddMusicPlugin().wgL.getMuteOrigin();
                AudioCacheInfo audioCacheInfo = getAddMusicPlugin().wgG;
                ArrayList a2 = h.a(getItemContainerPlugin());
                ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> editorDataList = getItemContainerPlugin().getEditorDataList();
                float[] eKr = getItemContainerPlugin().eKr();
                o oVar = this.BWY;
                if (oVar == null || (bVar = oVar.BQt) == null || (arrayList = bVar.iqm) == null) {
                    arrayList = new ArrayList<>();
                }
                getItemContainerPlugin();
                f fVar = new f(muteOrigin, audioCacheInfo, a2, editorDataList, eKr, arrayList, h.eKs());
                Log.i("MicroMsg.Image2VideoPluginLayout", "edit config: ".concat(String.valueOf(fVar)));
                getReMuxPlugin().a(fVar);
                c cVar2 = c.BXI;
                c.x("KEY_ADD_EMOJI_COUNT_INT", Integer.valueOf(getItemContainerPlugin().eKu()));
                c cVar3 = c.BXI;
                c.x("KEY_ADD_TEXT_COUNT_INT", Integer.valueOf(getItemContainerPlugin().eKv()));
                c cVar4 = c.BXI;
                c.x("KEY_SELECT_MUSIC_INT", Integer.valueOf(getAddMusicPlugin().wgG == null ? 0 : 1));
                c cVar5 = c.BXI;
                if (getAddMusicPlugin().wgL.getMuteOrigin()) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                c.x("KEY_SELECT_ORIGIN_INT", Integer.valueOf(i3));
                c cVar6 = c.BXI;
                c.x("KEY_AFTER_EDIT_INT", 1);
                eKS();
                eKT();
                c cVar7 = c.BXI;
                c.VI(13);
                c cVar8 = c.BXI;
                c.eKX().ry(System.currentTimeMillis());
                c cVar9 = c.BXI;
                RecordConfigProvider configProvider = getConfigProvider();
                if (configProvider != null) {
                    i4 = configProvider.scene;
                }
                c.VJ(i4);
                AppMethodBeat.o(75788);
                return;
            case 2:
                AppMethodBeat.o(75788);
                return;
            default:
                super.a(cVar, bundle);
                AppMethodBeat.o(75788);
                return;
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final boolean onBackPress() {
        AppMethodBeat.i(75789);
        if (!super.onBackPress()) {
            Log.i("MicroMsg.Image2VideoPluginLayout", "onBackPress");
            c cVar = c.BXI;
            c.x("KEY_AFTER_EDIT_INT", 0);
            int i2 = 0;
            int i3 = 0;
            for (T t : getItemContainerPlugin().BQh.getAllItemViews()) {
                if (t instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.f) {
                    i3++;
                } else if (t instanceof r) {
                    i2++;
                } else if (t instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.p) {
                    c cVar2 = c.BXI;
                    c.eKY().ahN();
                } else if (!(t instanceof m) && (t instanceof s)) {
                    c cVar3 = c.BXI;
                    c.eKY().ahP();
                }
            }
            c cVar4 = c.BXI;
            c.eKY().sJ(getMoreMenuPlugin().BQn ? 1 : 0);
            c cVar5 = c.BXI;
            c.eKY().sF((long) i3);
            c cVar6 = c.BXI;
            c.eKY().sG((long) i2);
            com.tencent.mm.plugin.recordvideo.activity.a navigator = getNavigator();
            if (navigator != null) {
                a.C1633a.a(navigator);
            }
        }
        AppMethodBeat.o(75789);
        return true;
    }

    private final void eKS() {
        long j2;
        AppMethodBeat.i(75790);
        int i2 = 0;
        int i3 = 0;
        for (T t : getItemContainerPlugin().getEditorDataList()) {
            switch (e.haE[t.Cex.ordinal()]) {
                case 1:
                    i3++;
                    break;
                case 2:
                    i2++;
                    break;
                case 3:
                    com.tencent.mm.bw.a eMk = t.eMk();
                    if (eMk != null) {
                        cka cka = (cka) eMk;
                        c cVar = c.BXI;
                        jf eKX = c.eKX();
                        String str = cka.Cfy;
                        p.g(str, "poiData.cityName");
                        String str2 = cka.kHV;
                        p.g(str2, "poiData.poiName");
                        StringBuilder sb = new StringBuilder();
                        if (!TextUtils.isEmpty(str)) {
                            sb.append(n.j(str, ",", " ", true));
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            if (sb.length() > 0) {
                                sb.append("|");
                            }
                            sb.append(n.j(str2, ",", " ", true));
                        }
                        String sb2 = sb.toString();
                        p.g(sb2, "reportPositionString.toString()");
                        eKX.wE(sb2);
                        c cVar2 = c.BXI;
                        c.eKX().wF(String.valueOf(cka.latitude));
                        c cVar3 = c.BXI;
                        c.eKX().wG(String.valueOf(cka.dTj));
                        break;
                    } else {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LocationItemData");
                        AppMethodBeat.o(75790);
                        throw tVar;
                    }
                case 4:
                    c cVar4 = c.BXI;
                    c.eKX().ahl();
                    break;
                case 5:
                    c cVar5 = c.BXI;
                    c.eKX().ahm();
                    break;
            }
        }
        c cVar6 = c.BXI;
        c.eKX().rB((long) i3);
        c cVar7 = c.BXI;
        c.eKX().rC((long) i2);
        c cVar8 = c.BXI;
        c.eKX().rH(getMoreMenuPlugin().BQn ? 1 : 0);
        c cVar9 = c.BXI;
        jf eKX2 = c.eKX();
        AudioCacheInfo audioCacheInfo = getAddMusicPlugin().wgG;
        if (audioCacheInfo != null) {
            int i4 = audioCacheInfo.source;
            AudioCacheInfo.a aVar = AudioCacheInfo.BPo;
            if (i4 == AudioCacheInfo.BPn) {
                j2 = 1;
                eKX2.rG(j2);
                AppMethodBeat.o(75790);
            }
        }
        j2 = 0;
        eKX2.rG(j2);
        AppMethodBeat.o(75790);
    }

    private final void eKT() {
        ArrayList<String> arrayList;
        AppMethodBeat.i(75791);
        StringBuilder sb = new StringBuilder();
        b captureInfo = getCaptureInfo();
        if (!(captureInfo == null || (arrayList = captureInfo.iqm) == null)) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(it.next(), options);
                sb.append(options.outHeight + ':' + options.outWidth + "||");
            }
        }
        int lastIndexOf = sb.lastIndexOf("||");
        if (lastIndexOf >= 0) {
            c cVar = c.BXI;
            c.eKX().wI(sb.substring(0, lastIndexOf).toString());
        }
        AppMethodBeat.o(75791);
    }
}
