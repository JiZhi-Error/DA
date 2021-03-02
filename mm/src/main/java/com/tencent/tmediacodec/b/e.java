package com.tencent.tmediacodec.b;

import android.media.MediaFormat;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.g.b;
import com.tencent.tmediacodec.g.d;
import java.util.ArrayList;

public final class e {
    private boolean Sly;
    public ArrayList<byte[]> Slz = new ArrayList<>();
    private String bdn = "";
    public final String bdq;
    public int bdr = -1;
    public int bdv;
    public int channelCount;
    public int height = -1;
    public int maxHeight = -1;
    public int maxWidth = -1;
    public int sampleRate;
    private boolean tkD;
    public int width = -1;

    private e(String str) {
        AppMethodBeat.i(190114);
        this.bdq = str;
        AppMethodBeat.o(190114);
    }

    public final boolean cWJ() {
        AppMethodBeat.i(190115);
        if (!this.Sly) {
            this.Sly = true;
            this.tkD = d.by(this.bdq);
        }
        boolean z = this.tkD;
        AppMethodBeat.o(190115);
        return z;
    }

    public static e i(MediaFormat mediaFormat) {
        AppMethodBeat.i(190116);
        e eVar = new e(mediaFormat.getString("mime"));
        try {
            eVar.sampleRate = a(mediaFormat, "sample-rate");
            eVar.bdr = a(mediaFormat, "max-input-size");
            eVar.Slz = d.j(mediaFormat);
            if (eVar.cWJ()) {
                eVar.bdv = a(mediaFormat, "rotation-degrees");
                eVar.width = a(mediaFormat, "width");
                eVar.height = a(mediaFormat, "height");
                if (Build.VERSION.SDK_INT >= 19) {
                    eVar.maxWidth = a(mediaFormat, "max-width");
                    eVar.maxHeight = a(mediaFormat, "max-height");
                }
            } else {
                eVar.channelCount = a(mediaFormat, "channel-count");
            }
        } catch (Throwable th) {
            b.bqV("FormatWrapper");
        }
        AppMethodBeat.o(190116);
        return eVar;
    }

    public static void bA(ArrayList<byte[]> arrayList) {
        AppMethodBeat.i(190117);
        if (arrayList == null) {
            AppMethodBeat.o(190117);
            return;
        }
        if (b.isLogEnable()) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                sb.append(E(d.Sna[i2], arrayList.get(i2)));
                sb.append("\n");
            }
            new StringBuilder("csdData size:").append(arrayList.size()).append("    ").append(sb.toString());
            b.bqQ("FormatWrapper");
        }
        AppMethodBeat.o(190117);
    }

    private static String E(String str, byte[] bArr) {
        AppMethodBeat.i(190118);
        StringBuilder sb = new StringBuilder(str);
        sb.append(", length:");
        sb.append(bArr.length);
        sb.append("  [");
        for (int i2 = 0; i2 < Math.min(bArr.length, 20); i2++) {
            if (i2 != 0) {
                sb.append(" ,");
            }
            sb.append((int) bArr[i2]);
        }
        sb.append("]");
        String sb2 = sb.toString();
        AppMethodBeat.o(190118);
        return sb2;
    }

    private static int a(MediaFormat mediaFormat, String str) {
        AppMethodBeat.i(190119);
        if (mediaFormat.containsKey(str)) {
            int integer = mediaFormat.getInteger(str);
            AppMethodBeat.o(190119);
            return integer;
        }
        AppMethodBeat.o(190119);
        return -1;
    }
}
