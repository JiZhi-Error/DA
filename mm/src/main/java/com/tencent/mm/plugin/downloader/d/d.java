package com.tencent.mm.plugin.downloader.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;

public final class d {
    public static Map<Integer, ByteBuffer> K(o oVar) {
        AppMethodBeat.i(177460);
        if (oVar == null || !oVar.exists() || !oVar.isFile()) {
            AppMethodBeat.o(177460);
            return null;
        }
        try {
            ByteBuffer M = f.M(oVar);
            a.C(M);
            ByteBuffer c2 = a.c(M, M.capacity() - 24);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i2 = 0;
            while (c2.hasRemaining()) {
                i2++;
                if (c2.remaining() < 8) {
                    a.b bVar = new a.b("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i2)));
                    AppMethodBeat.o(177460);
                    throw bVar;
                }
                long j2 = c2.getLong();
                if (j2 < 4 || j2 > 2147483647L) {
                    a.b bVar2 = new a.b("APK Signing Block entry #" + i2 + " size out of range: " + j2);
                    AppMethodBeat.o(177460);
                    throw bVar2;
                }
                int i3 = (int) j2;
                int position = c2.position() + i3;
                if (i3 > c2.remaining()) {
                    a.b bVar3 = new a.b("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + c2.remaining());
                    AppMethodBeat.o(177460);
                    throw bVar3;
                }
                int i4 = c2.getInt();
                linkedHashMap.put(Integer.valueOf(i4), a.d(c2, i3 - 4));
                if (i4 == 1896449818) {
                    Log.i("MicroMsg.Channel.V2SchemeUtil", "find V2 signature block Id : 1896449818");
                }
                c2.position(position);
            }
            if (linkedHashMap.isEmpty()) {
                a.b bVar4 = new a.b("not have Id-Value Pair in APK Signing Block entry #".concat(String.valueOf(i2)));
                AppMethodBeat.o(177460);
                throw bVar4;
            }
            AppMethodBeat.o(177460);
            return linkedHashMap;
        } catch (IOException e2) {
            AppMethodBeat.o(177460);
            return null;
        } catch (a.b e3) {
            org.xwalk.core.Log.e("MicroMsg.Channel.IdValueReader", "APK : " + aa.z(oVar.her()) + " not have apk signature block");
            AppMethodBeat.o(177460);
            return null;
        }
    }
}
