package com.tencent.mm.plugin.appbrand.media.record;

import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.IOException;

public class h {
    private static a ndQ = new a() {
        /* class com.tencent.mm.plugin.appbrand.media.record.h.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.media.record.h.a
        public final void ef(String str) {
            AppMethodBeat.i(175888);
            System.loadLibrary(str);
            AppMethodBeat.o(175888);
        }
    };

    public interface a {
        void ef(String str);
    }

    static {
        AppMethodBeat.i(175889);
        AppMethodBeat.o(175889);
    }

    public static void a(a aVar) {
        synchronized (h.class) {
            ndQ = aVar;
        }
    }

    public static a bPg() {
        a aVar;
        synchronized (h.class) {
            aVar = ndQ;
        }
        return aVar;
    }

    public static String et(String str, String str2) {
        String str3;
        AppMethodBeat.i(146324);
        o oVar = new o(b.aKJ(), "AudioRecord");
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        StringBuilder append = new StringBuilder(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE).append(MD5Util.getMD5String(String.valueOf(str2)));
        if (!TextUtils.isEmpty(str)) {
            if ("aac".equalsIgnoreCase(str)) {
                str3 = ".m4a";
            } else if ("mp3".equalsIgnoreCase(str)) {
                str3 = ".mp3";
            } else if ("wav".equalsIgnoreCase(str)) {
                str3 = ".wav";
            }
            String sb = append.append(str3).toString();
            o oVar2 = new o(oVar, sb);
            Log.d("MicroMsg.Record.AudioRecordUtil", "getAudioFilePath audio name %s path %s", sb, oVar2.hes());
            String z = aa.z(oVar2.her());
            AppMethodBeat.o(146324);
            return z;
        }
        str3 = "";
        String sb2 = append.append(str3).toString();
        o oVar22 = new o(oVar, sb2);
        Log.d("MicroMsg.Record.AudioRecordUtil", "getAudioFilePath audio name %s path %s", sb2, oVar22.hes());
        String z2 = aa.z(oVar22.her());
        AppMethodBeat.o(146324);
        return z2;
    }

    public static String acG(String str) {
        AppMethodBeat.i(146325);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(146325);
            return "";
        } else if ("aac".equalsIgnoreCase(str)) {
            AppMethodBeat.o(146325);
            return "m4a";
        } else if ("mp3".equalsIgnoreCase(str)) {
            AppMethodBeat.o(146325);
            return "mp3";
        } else if ("wav".equalsIgnoreCase(str)) {
            AppMethodBeat.o(146325);
            return "wav";
        } else if ("pcm".equalsIgnoreCase(str)) {
            AppMethodBeat.o(146325);
            return "pcm";
        } else {
            AppMethodBeat.o(146325);
            return "";
        }
    }

    public static boolean acH(String str) {
        AppMethodBeat.i(146326);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(146326);
            return false;
        } else if ("aac".equalsIgnoreCase(str)) {
            AppMethodBeat.o(146326);
            return true;
        } else if ("mp3".equalsIgnoreCase(str)) {
            AppMethodBeat.o(146326);
            return true;
        } else if ("wav".equalsIgnoreCase(str)) {
            AppMethodBeat.o(146326);
            return true;
        } else if ("pcm".equalsIgnoreCase(str)) {
            AppMethodBeat.o(146326);
            return true;
        } else {
            AppMethodBeat.o(146326);
            return false;
        }
    }

    public static boolean acI(String str) {
        boolean z = false;
        AppMethodBeat.i(146327);
        o oVar = new o(str);
        if (!oVar.exists()) {
            try {
                Log.i("MicroMsg.Record.AudioRecordUtil", "new audio file");
                z = oVar.createNewFile();
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", e2, "prepareCacheFile", new Object[0]);
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", e3, "prepareCacheFile", new Object[0]);
            }
        } else {
            Log.i("MicroMsg.Record.AudioRecordUtil", "delete audio file");
            oVar.delete();
            try {
                z = oVar.createNewFile();
            } catch (IOException e4) {
                Log.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", e4, "prepareCacheFile", new Object[0]);
            } catch (Exception e5) {
                Log.printErrStackTrace("MicroMsg.Record.AudioRecordUtil", e5, "prepareCacheFile", new Object[0]);
            }
        }
        AppMethodBeat.o(146327);
        return z;
    }

    public static long acJ(String str) {
        AppMethodBeat.i(146328);
        o oVar = new o(str);
        long j2 = -1;
        if (oVar.exists()) {
            Log.i("MicroMsg.Record.AudioRecordUtil", "exist audio file");
            j2 = oVar.length();
        } else {
            Log.i("MicroMsg.Record.AudioRecordUtil", "audio file not exit, path:%s", str);
        }
        AppMethodBeat.o(146328);
        return j2;
    }

    public static short[] G(byte[] bArr, int i2) {
        short[] sArr = new short[(i2 / 2)];
        for (int i3 = 0; i3 < sArr.length; i3++) {
            sArr[i3] = (short) ((bArr[i3 * 2] & 255) | ((bArr[(i3 * 2) + 1] & 255) << 8));
        }
        return sArr;
    }
}
