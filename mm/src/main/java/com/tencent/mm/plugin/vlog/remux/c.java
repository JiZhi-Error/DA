package com.tencent.mm.plugin.vlog.remux;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.vlog.model.ae;
import com.tencent.mm.plugin.vlog.model.af;
import com.tencent.mm.plugin.vlog.model.ah;
import com.tencent.mm.plugin.vlog.model.s;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.epc;
import com.tencent.mm.protocal.protobuf.erh;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/vlog/remux/VLogMixerInstanceManager;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IMixInstanceManager;", "()V", "createMixInstance", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "editorData", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "extraConfig", "Lcom/tencent/mm/protocal/protobuf/ExtraConfig;", "Companion", "plugin-vlog_release"})
public final class c implements com.tencent.mm.plugin.recordvideo.background.c.a {
    public static final a GCW = new a((byte) 0);

    static {
        AppMethodBeat.i(111052);
        AppMethodBeat.o(111052);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/remux/VLogMixerInstanceManager$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.recordvideo.background.c.a
    public final com.tencent.mm.plugin.recordvideo.background.c.c a(com.tencent.mm.plugin.recordvideo.background.c cVar, ald ald) {
        AppMethodBeat.i(111051);
        p.h(cVar, "editorData");
        p.h(ald, "extraConfig");
        aio aio = new aio();
        try {
            aio.parseFrom(cVar.field_baseItemData);
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            aio = null;
        }
        aio aio2 = aio;
        if (aio2 != null) {
            af afVar = new af();
            afVar.audioBitrate = cVar.field_audioBitrate;
            afVar.videoBitrate = cVar.field_videoBitrate;
            afVar.targetWidth = cVar.field_targetWidth;
            afVar.targetHeight = cVar.field_targetHeight;
            afVar.frameRate = cVar.field_frameRate;
            afVar.audioSampleRate = cVar.field_audioSampleRate;
            afVar.audioChannelCount = cVar.field_audioChannelCount;
            afVar.ihS = cVar.field_videoRotate;
            afVar.GzM = aio2.idq;
            afVar.GzL = (int) aio2.endTime;
            String str = ald.BOA;
            p.g(str, "extraConfig.outputVideoPath");
            afVar.aUb(str);
            epc epc = new epc();
            try {
                epc.parseFrom(aio2.Lsd.toByteArray());
            } catch (Exception e3) {
                Log.printDebugStack("safeParser", "", e3);
                epc = null;
            }
            epc epc2 = epc;
            if (epc2 != null) {
                erh erh = epc2.NmX;
                float[] fArr = {(float) aio2.LrU, (float) aio2.LrW, (float) aio2.LrV, (float) aio2.LrX};
                e eVar = e.BKp;
                LinkedList<jn> linkedList = aio2.Lna;
                p.g(linkedList, "editorProtoData.baseItemData");
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                ArrayList<com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a> a2 = e.a(linkedList, context);
                if (erh != null) {
                    long j2 = erh.KPe;
                    ae.a aVar = ae.GzI;
                    List<s> a3 = ae.a.a(erh);
                    String str2 = erh.NoU.MqU;
                    p.g(str2, "music.music_url");
                    ah ahVar = new ah(j2, a3, str2, erh);
                    ahVar.p(fArr);
                    ahVar.aT(a2);
                    d dVar = new d(ahVar, afVar);
                    Log.i("MicroMsg.VLogMixerInstanceManager", "music url:" + erh.NoU.MxH + " exist:" + com.tencent.mm.vfs.s.YS(erh.NoU.MxH));
                    dVar.aUg(erh.NoU.MxH);
                    dVar.jw(epc2.previewWidth, epc2.previewHeight);
                    d dVar2 = dVar;
                    AppMethodBeat.o(111051);
                    return dVar2;
                }
            }
        }
        Log.e("MicroMsg.VLogMixerInstanceManager", "return null mixer");
        AppMethodBeat.o(111051);
        return null;
    }
}
