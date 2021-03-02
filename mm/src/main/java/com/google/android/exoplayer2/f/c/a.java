package com.google.android.exoplayer2.f.c;

import android.text.TextUtils;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TimeUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends b {
    private static final Pattern bCx = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");
    private int bCA;
    private int bCB;
    private int bCC;
    private final boolean bCy;
    private int bCz;

    static {
        AppMethodBeat.i(92810);
        AppMethodBeat.o(92810);
    }

    public a() {
        this(null);
    }

    public a(List<byte[]> list) {
        super("SsaDecoder");
        AppMethodBeat.i(92804);
        if (list != null) {
            this.bCy = true;
            String str = new String(list.get(0));
            com.google.android.exoplayer2.i.a.checkArgument(str.startsWith("Format: "));
            bk(str);
            B(new m(list.get(1)));
            AppMethodBeat.o(92804);
            return;
        }
        this.bCy = false;
        AppMethodBeat.o(92804);
    }

    private static void B(m mVar) {
        String readLine;
        AppMethodBeat.i(92805);
        do {
            readLine = mVar.readLine();
            if (readLine == null) {
                AppMethodBeat.o(92805);
                return;
            }
        } while (!readLine.startsWith("[Events]"));
        AppMethodBeat.o(92805);
    }

    private void a(m mVar, List<com.google.android.exoplayer2.f.a> list, h hVar) {
        long j2;
        AppMethodBeat.i(92806);
        while (true) {
            String readLine = mVar.readLine();
            if (readLine == null) {
                AppMethodBeat.o(92806);
                return;
            } else if (!this.bCy && readLine.startsWith("Format: ")) {
                bk(readLine);
            } else if (readLine.startsWith("Dialogue: ") && this.bCz != 0) {
                String[] split = readLine.substring(10).split(",", this.bCz);
                long bl = bl(split[this.bCA]);
                if (bl != -9223372036854775807L) {
                    String str = split[this.bCB];
                    if (!str.trim().isEmpty()) {
                        j2 = bl(str);
                        if (j2 == -9223372036854775807L) {
                        }
                    } else {
                        j2 = -9223372036854775807L;
                    }
                    list.add(new com.google.android.exoplayer2.f.a(split[this.bCC].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n")));
                    hVar.add(bl);
                    if (j2 != -9223372036854775807L) {
                        list.add(null);
                        hVar.add(j2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void bk(String str) {
        char c2;
        AppMethodBeat.i(92807);
        String[] split = TextUtils.split(str.substring(8), ",");
        this.bCz = split.length;
        this.bCA = -1;
        this.bCB = -1;
        this.bCC = -1;
        for (int i2 = 0; i2 < this.bCz; i2++) {
            String bH = x.bH(split[i2].trim());
            switch (bH.hashCode()) {
                case 100571:
                    if (bH.equals("end")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3556653:
                    if (bH.equals("text")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 109757538:
                    if (bH.equals("start")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    this.bCA = i2;
                    break;
                case 1:
                    this.bCB = i2;
                    break;
                case 2:
                    this.bCC = i2;
                    break;
            }
        }
        AppMethodBeat.o(92807);
    }

    private static long bl(String str) {
        AppMethodBeat.i(92808);
        Matcher matcher = bCx.matcher(str);
        if (!matcher.matches()) {
            AppMethodBeat.o(92808);
            return -9223372036854775807L;
        }
        long parseLong = (Long.parseLong(matcher.group(4)) * 10000) + (Long.parseLong(matcher.group(1)) * 60 * 60 * TimeUtil.SECOND_TO_US) + (Long.parseLong(matcher.group(2)) * 60 * TimeUtil.SECOND_TO_US) + (Long.parseLong(matcher.group(3)) * TimeUtil.SECOND_TO_US);
        AppMethodBeat.o(92808);
        return parseLong;
    }

    @Override // com.google.android.exoplayer2.f.b
    public final /* synthetic */ d b(byte[] bArr, int i2, boolean z) {
        AppMethodBeat.i(92809);
        ArrayList arrayList = new ArrayList();
        h hVar = new h();
        m mVar = new m(bArr, i2);
        if (!this.bCy) {
            B(mVar);
        }
        a(mVar, arrayList, hVar);
        com.google.android.exoplayer2.f.a[] aVarArr = new com.google.android.exoplayer2.f.a[arrayList.size()];
        arrayList.toArray(aVarArr);
        b bVar = new b(aVarArr, hVar.toArray());
        AppMethodBeat.o(92809);
        return bVar;
    }
}
