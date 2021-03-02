package com.tencent.mm.storagebase;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.LinkedHashSet;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;

public class IMEISave {
    public static Collection<String> gFy() {
        BufferedReader bufferedReader;
        Throwable th;
        AppMethodBeat.i(176872);
        Context context = MMApplicationContext.getContext();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(q.dr(true));
        linkedHashSet.add(q.dr(false));
        BufferedReader bufferedReader2 = null;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec("_wEcHAT_".getBytes(), "RC4");
            Cipher instance = Cipher.getInstance("RC4");
            instance.init(2, secretKeySpec);
            bufferedReader = new BufferedReader(new InputStreamReader(new CipherInputStream(context.openFileInput("KeyInfo.bin"), instance)));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    linkedHashSet.add(readLine);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        Log.printErrStackTrace("MicroMsg.DBInit", e, "Failed to load key information.", new Object[0]);
                        Util.qualityClose(bufferedReader);
                        linkedHashSet.add("1234567890ABCDEF");
                        AppMethodBeat.o(176872);
                        return linkedHashSet;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                        Util.qualityClose(bufferedReader2);
                        AppMethodBeat.o(176872);
                        throw th;
                    }
                }
            }
            Util.qualityClose(bufferedReader);
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
            Log.printErrStackTrace("MicroMsg.DBInit", e, "Failed to load key information.", new Object[0]);
            Util.qualityClose(bufferedReader);
            linkedHashSet.add("1234567890ABCDEF");
            AppMethodBeat.o(176872);
            return linkedHashSet;
        } catch (Throwable th3) {
            th = th3;
            Util.qualityClose(bufferedReader2);
            AppMethodBeat.o(176872);
            throw th;
        }
        linkedHashSet.add("1234567890ABCDEF");
        AppMethodBeat.o(176872);
        return linkedHashSet;
    }
}
