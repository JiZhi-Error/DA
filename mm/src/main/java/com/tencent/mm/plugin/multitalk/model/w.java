package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.wecall.talkroom.model.TalkRoom;
import com.tencent.wecall.talkroom.model.c;
import java.util.ArrayList;
import java.util.List;

public final class w {
    public static w zNS;
    private TalkRoom zNT;

    public final List<String> aGl(String str) {
        int byteArrayToInt;
        AppMethodBeat.i(239429);
        ArrayList arrayList = new ArrayList();
        this.zNT = c.hqY().brg(str);
        if (this.zNT != null) {
            for (a.bb bbVar : this.zNT.hqS()) {
                int i2 = bbVar.qrD;
                if (i2 >= 0) {
                    byte[] bArr = new byte[4];
                    if (ac.eol().zMd.setAppCmd(10, bArr, i2) < 0) {
                        Log.d("MicroMsg.Multitalk.VoipNetStatusChecker", "get netStatus failed memberId :%d", Integer.valueOf(i2));
                        byteArrayToInt = -1;
                    } else {
                        byteArrayToInt = Util.byteArrayToInt(bArr);
                        Log.d("MicroMsg.Multitalk.VoipNetStatusChecker", "netStatus: %d", Integer.valueOf(byteArrayToInt));
                    }
                    if (byteArrayToInt != -1 && byteArrayToInt <= 3) {
                        arrayList.add(bbVar.dLN);
                    }
                }
            }
        }
        AppMethodBeat.o(239429);
        return arrayList;
    }
}
