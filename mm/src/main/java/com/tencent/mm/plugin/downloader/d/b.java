package com.tencent.mm.plugin.downloader.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;

public final class b {
    public static String I(o oVar) {
        AppMethodBeat.i(177457);
        try {
            Log.i("MicroMsg.Channel.ChannelReader", "get channel by v1");
            byte[] ala = g.ala(aa.z(oVar.her()));
            if (ala == null) {
                AppMethodBeat.o(177457);
                return null;
            }
            c cVar = new c();
            cVar.W(ala);
            String property = cVar.qHA.getProperty("channelId");
            AppMethodBeat.o(177457);
            return property;
        } catch (Exception e2) {
            Log.e("MicroMsg.Channel.ChannelReader", "APK : %s not have channel info from zip comment", aa.z(oVar.her()));
            AppMethodBeat.o(177457);
            return null;
        }
    }

    public static String J(o oVar) {
        byte[] bArr;
        ByteBuffer byteBuffer;
        AppMethodBeat.i(177458);
        Log.i("MicroMsg.Channel.ChannelReader", "get channel by v2");
        if (!oVar.exists() || !oVar.isFile()) {
            bArr = null;
        } else {
            if (!oVar.exists() || !oVar.isFile()) {
                byteBuffer = null;
            } else {
                Map<Integer, ByteBuffer> K = d.K(oVar);
                byteBuffer = K != null ? K.get(1903261812) : null;
            }
            if (byteBuffer != null) {
                bArr = Arrays.copyOfRange(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.limit() + byteBuffer.arrayOffset());
            } else {
                bArr = null;
            }
        }
        if (bArr == null) {
            AppMethodBeat.o(177458);
            return null;
        }
        c cVar = new c();
        cVar.W(bArr);
        String property = cVar.qHA.getProperty("channelId");
        AppMethodBeat.o(177458);
        return property;
    }

    public static boolean akZ(String str) {
        boolean z = false;
        AppMethodBeat.i(88860);
        try {
            z = a.akY(str);
            AppMethodBeat.o(88860);
        } catch (Exception e2) {
            Log.e("MicroMsg.Channel.ChannelReader", "isV2ChannelApk error: %s", e2.getMessage());
            AppMethodBeat.o(88860);
        }
        return z;
    }
}
