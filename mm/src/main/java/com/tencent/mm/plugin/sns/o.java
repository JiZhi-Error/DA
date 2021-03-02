package com.tencent.mm.plugin.sns;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.storage.bp;

public final class o implements n {
    @Override // com.tencent.mm.plugin.sns.b.n
    public final TimeLineObject PM(String str) {
        AppMethodBeat.i(94913);
        TimeLineObject PM = com.tencent.mm.modelsns.n.PM(str);
        AppMethodBeat.o(94913);
        return PM;
    }

    @Override // com.tencent.mm.plugin.sns.b.n
    public final boolean IM(long j2) {
        AppMethodBeat.i(94914);
        SnsInfo JJ = aj.faO().JJ(j2);
        if (JJ == null) {
            AppMethodBeat.o(94914);
            return false;
        } else if (JJ.getTimeLine().ContentObj.LoV.size() > 0) {
            AppMethodBeat.o(94914);
            return true;
        } else {
            AppMethodBeat.o(94914);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.sns.b.n
    public final void a(long j2, ImageView imageView, int i2) {
        AppMethodBeat.i(94915);
        SnsInfo JJ = aj.faO().JJ(j2);
        if (JJ == null) {
            AppMethodBeat.o(94915);
            return;
        }
        TimeLineObject timeLine = JJ.getTimeLine();
        if (timeLine.ContentObj.LoV.size() > 0) {
            cnb cnb = timeLine.ContentObj.LoV.get(0);
            Bitmap b2 = aj.faL().b(cnb);
            if (b2 != null) {
                imageView.setImageBitmap(b2);
                AppMethodBeat.o(94915);
                return;
            }
            aj.faL().b(cnb, imageView, i2, bp.Oqt);
        }
        AppMethodBeat.o(94915);
    }
}
