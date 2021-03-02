package com.tencent.mm.plugin.music.b.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.pay.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class b {
    public static int Sv(int i2) {
        AppMethodBeat.i(62940);
        Log.i("MicroMsg.Audio.AudioPlayIdKeyReport", "getQQAudioPlayerErrIdKey, errCode:".concat(String.valueOf(i2)));
        switch (i2) {
            case 702:
                AppMethodBeat.o(62940);
                return 98;
            case 703:
                AppMethodBeat.o(62940);
                return 99;
            case 704:
                AppMethodBeat.o(62940);
                return 100;
            case 705:
                AppMethodBeat.o(62940);
                return 101;
            case 706:
                AppMethodBeat.o(62940);
                return 102;
            case 707:
                AppMethodBeat.o(62940);
                return 103;
            case 708:
                AppMethodBeat.o(62940);
                return 104;
            case 709:
                AppMethodBeat.o(62940);
                return 105;
            case 710:
                AppMethodBeat.o(62940);
                return 106;
            case 711:
                AppMethodBeat.o(62940);
                return 107;
            case 712:
                AppMethodBeat.o(62940);
                return 108;
            case 713:
                AppMethodBeat.o(62940);
                return 119;
            case g.CTRL_INDEX:
                AppMethodBeat.o(62940);
                return 120;
            case 715:
                AppMethodBeat.o(62940);
                return 109;
            case 716:
                AppMethodBeat.o(62940);
                return 110;
            default:
                AppMethodBeat.o(62940);
                return 115;
        }
    }

    static void M(ArrayList<IDKey> arrayList) {
        AppMethodBeat.i(62941);
        StringBuilder sb = new StringBuilder();
        sb.append("idkeyGroupStat:  id:688");
        Iterator<IDKey> it = arrayList.iterator();
        while (it.hasNext()) {
            IDKey next = it.next();
            sb.append(", key:" + next.GetKey() + " value:" + next.GetValue());
        }
        com.tencent.mm.audio.mix.i.b.d("MicroMsg.Audio.AudioPlayIdKeyReport", sb.toString());
        AppMethodBeat.o(62941);
    }
}
