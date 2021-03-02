package com.tencent.mm.plugin.recordvideo.model.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cll;
import com.tencent.mm.protocal.protobuf.clm;
import com.tencent.mm.protocal.protobuf.dqi;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BK\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/model/audio/CgiGetRecommendMusic;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/MMSPRGetRecommendedMusicResponse;", "imageData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protobuf/ByteString;", "latitude", "", "longitude", "requestId", "", "videoDuration", "scene", "", "audioCount", "(Ljava/util/LinkedList;FFJJII)V", "plugin-recordvideo_release"})
public final class e extends c<clm> {
    public /* synthetic */ e(LinkedList linkedList, float f2, float f3, long j2, long j3, int i2, byte b2) {
        this(linkedList, f2, f3, j2, j3, i2);
    }

    private e(LinkedList<b> linkedList, float f2, float f3, long j2, long j3, int i2) {
        p.h(linkedList, "imageData");
        AppMethodBeat.i(75422);
        cll cll = new cll();
        clm clm = new clm();
        clm.setBaseResponse(new BaseResponse());
        clm.getBaseResponse().ErrMsg = new dqi();
        cll.MqL = linkedList;
        cll.MqK = 10;
        cll.latitude = f2;
        cll.dTj = f3;
        cll.BPd = j2;
        cll.MqN = j3;
        cll.MqM = (long) i2;
        d.a aVar = new d.a();
        aVar.c(cll);
        aVar.d(clm);
        aVar.MB("/cgi-bin/spr-bin/mmsprgetrecommendedmusiclist");
        aVar.sG(3859);
        c(aVar.aXF());
        AppMethodBeat.o(75422);
    }
}
