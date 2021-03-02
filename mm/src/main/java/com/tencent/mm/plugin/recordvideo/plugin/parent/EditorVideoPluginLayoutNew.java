package com.tencent.mm.plugin.recordvideo.plugin.parent;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.jf;
import com.tencent.mm.plugin.recordvideo.activity.a;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.d.c;
import com.tencent.mm.plugin.recordvideo.d.g;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.recordvideo.model.audio.c;
import com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditorVideoPlayView;
import com.tencent.mm.plugin.recordvideo.plugin.h;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.s;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.m;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.r;
import com.tencent.mm.protocal.protobuf.cka;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0002J\u001a\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseEditVideoPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "createReportString", "", "city", "poiName", "getPlayerView", "Landroid/view/View;", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "onBackPress", "", "prepareImageSizeReport", "prepareStoryBehaviorReport", "prepareStoryFailBehaviorReport", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-recordvideo_release"})
public class EditorVideoPluginLayoutNew extends BaseEditVideoPluginLayout implements d {
    public static final a BUn = new a((byte) 0);

    static {
        AppMethodBeat.i(75779);
        AppMethodBeat.o(75779);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditorVideoPluginLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(75778);
        AppMethodBeat.o(75778);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditorVideoPluginLayoutNew$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout
    public View getPlayerView() {
        AppMethodBeat.i(75772);
        EditorVideoPlayView editorVideoPlayView = new EditorVideoPlayView(getContext());
        Log.i("MicroMsg.EditorVideoPluginLayoutNew", "playerView :".concat(String.valueOf(editorVideoPlayView)));
        setPreviewPlugin(new s(editorVideoPlayView, this, (TextView) findViewById(R.id.j4b)));
        getPluginList().add(getPreviewPlugin());
        EditorVideoPlayView editorVideoPlayView2 = editorVideoPlayView;
        AppMethodBeat.o(75772);
        return editorVideoPlayView2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x030d  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x032e  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0337  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0350  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x036d  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0374  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0400 A[Catch:{ all -> 0x0489 }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0414  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x041d  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0437  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x043b  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0468  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x046f  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0473  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0219  */
    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.tencent.mm.media.widget.camerarecordview.b.b r14) {
        /*
        // Method dump skipped, instructions count: 1168
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.plugin.parent.EditorVideoPluginLayoutNew.a(com.tencent.mm.media.widget.camerarecordview.b.b):void");
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.parent.BaseEditVideoPluginLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.d
    public void a(d.c cVar, Bundle bundle) {
        AppMethodBeat.i(75774);
        p.h(cVar, "status");
        if (cVar != d.c.BVq) {
            Log.i("MicroMsg.EditorVideoPluginLayoutNew", "statusChange " + cVar + " ,param : " + bundle);
        }
        switch (c.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
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
                boolean muteOrigin = getAddMusicPlugin().wgL.getMuteOrigin();
                AudioCacheInfo audioCacheInfo = getAddMusicPlugin().wgG;
                ArrayList a2 = h.a(getItemContainerPlugin());
                ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a> editorDataList = getItemContainerPlugin().getEditorDataList();
                float[] eKr = getItemContainerPlugin().eKr();
                int i3 = getPreviewPlugin().dvv;
                int i4 = getPreviewPlugin().iqg;
                ArrayList arrayList = new ArrayList();
                getItemContainerPlugin();
                f fVar = new f(muteOrigin, audioCacheInfo, a2, editorDataList, eKr, i3, i4, arrayList, eKD, h.eKs());
                Log.i("MicroMsg.EditorVideoPluginLayoutNew", "edit config: ".concat(String.valueOf(fVar)));
                g gVar = g.BXY;
                int[] iArr = new int[3];
                iArr[0] = getItemContainerPlugin().eKu();
                iArr[1] = getItemContainerPlugin().eKv();
                iArr[2] = getAddMusicPlugin().wgG == null ? 0 : 1;
                g.J(iArr);
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
                eKS();
                eKT();
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
                    AppMethodBeat.o(75774);
                    return;
                }
                AppMethodBeat.o(75774);
                return;
            default:
                if (cVar != d.c.BVq) {
                    Log.e("MicroMsg.EditorVideoPluginLayoutNew", "unknown status ".concat(String.valueOf(cVar)));
                }
                super.a(cVar, bundle);
                AppMethodBeat.o(75774);
                return;
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.plugin.t, com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout
    public final boolean onBackPress() {
        AppMethodBeat.i(75775);
        if (!super.onBackPress()) {
            Log.i("MicroMsg.EditorVideoPluginLayoutNew", "onBackPress");
            com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            com.tencent.mm.plugin.recordvideo.d.c.x("KEY_AFTER_EDIT_INT", 0);
            int i2 = 0;
            int i3 = 0;
            for (T t : getItemContainerPlugin().BQh.getAllItemViews()) {
                if (t instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.f) {
                    i3++;
                } else if (t instanceof r) {
                    i2++;
                } else if (t instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.p) {
                    com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                    com.tencent.mm.plugin.recordvideo.d.c.eKY().ahN();
                } else if (!(t instanceof m) && (t instanceof com.tencent.mm.plugin.recordvideo.ui.editor.item.s)) {
                    com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                    com.tencent.mm.plugin.recordvideo.d.c.eKY().ahP();
                }
            }
            com.tencent.mm.plugin.recordvideo.d.c cVar4 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            com.tencent.mm.plugin.recordvideo.d.c.eKY().sJ(getMoreMenuPlugin().BQn ? 1 : 0);
            com.tencent.mm.plugin.recordvideo.d.c cVar5 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            com.tencent.mm.plugin.recordvideo.d.c.eKY().sF((long) i3);
            com.tencent.mm.plugin.recordvideo.d.c cVar6 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            com.tencent.mm.plugin.recordvideo.d.c.eKY().sG((long) i2);
            com.tencent.mm.media.widget.camerarecordview.b.b captureInfo = getCaptureInfo();
            if (captureInfo != null && captureInfo.iqf) {
                com.tencent.f.h.RTc.aX(new b(this));
            }
            getPreviewPlugin().reset();
            com.tencent.mm.plugin.recordvideo.activity.a navigator = getNavigator();
            if (navigator != null) {
                a.C1633a.a(navigator);
            }
        }
        AppMethodBeat.o(75775);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ EditorVideoPluginLayoutNew BUo;

        b(EditorVideoPluginLayoutNew editorVideoPluginLayoutNew) {
            this.BUo = editorVideoPluginLayoutNew;
        }

        public final void run() {
            String str;
            String str2 = null;
            AppMethodBeat.i(169939);
            com.tencent.mm.media.widget.camerarecordview.b.b captureInfo = this.BUo.getCaptureInfo();
            if (captureInfo != null) {
                str = captureInfo.iqh;
            } else {
                str = null;
            }
            com.tencent.mm.vfs.s.deleteFile(str);
            com.tencent.mm.media.widget.camerarecordview.b.b captureInfo2 = this.BUo.getCaptureInfo();
            if (captureInfo2 != null) {
                str2 = captureInfo2.iqd;
            }
            com.tencent.mm.vfs.s.deleteFile(str2);
            AppMethodBeat.o(169939);
        }
    }

    private final void eKS() {
        AppMethodBeat.i(75776);
        int i2 = 0;
        int i3 = 0;
        for (T t : getItemContainerPlugin().getEditorDataList()) {
            switch (c.haE[t.Cex.ordinal()]) {
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
                        com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                        jf eKX = com.tencent.mm.plugin.recordvideo.d.c.eKX();
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
                        com.tencent.mm.plugin.recordvideo.d.c cVar2 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                        com.tencent.mm.plugin.recordvideo.d.c.eKX().wF(String.valueOf(cka.latitude));
                        com.tencent.mm.plugin.recordvideo.d.c cVar3 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                        com.tencent.mm.plugin.recordvideo.d.c.eKX().wG(String.valueOf(cka.dTj));
                        break;
                    } else {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.LocationItemData");
                        AppMethodBeat.o(75776);
                        throw tVar;
                    }
                case 4:
                    com.tencent.mm.plugin.recordvideo.d.c cVar4 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                    com.tencent.mm.plugin.recordvideo.d.c.eKX().ahl();
                    break;
                case 5:
                    com.tencent.mm.plugin.recordvideo.d.c cVar5 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
                    com.tencent.mm.plugin.recordvideo.d.c.eKX().ahm();
                    break;
            }
        }
        com.tencent.mm.plugin.recordvideo.d.c cVar6 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.eKX().rB((long) i3);
        com.tencent.mm.plugin.recordvideo.d.c cVar7 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.eKX().rC((long) i2);
        com.tencent.mm.plugin.recordvideo.d.c cVar8 = com.tencent.mm.plugin.recordvideo.d.c.BXI;
        com.tencent.mm.plugin.recordvideo.d.c.eKX().rH(getMoreMenuPlugin().BQn ? 1 : 0);
        AppMethodBeat.o(75776);
    }

    private final void eKT() {
        ArrayList<String> arrayList;
        AppMethodBeat.i(75777);
        StringBuilder sb = new StringBuilder();
        com.tencent.mm.media.widget.camerarecordview.b.b captureInfo = getCaptureInfo();
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
            com.tencent.mm.plugin.recordvideo.d.c cVar = com.tencent.mm.plugin.recordvideo.d.c.BXI;
            com.tencent.mm.plugin.recordvideo.d.c.eKX().wI(sb.substring(0, lastIndexOf).toString());
        }
        AppMethodBeat.o(75777);
    }
}
