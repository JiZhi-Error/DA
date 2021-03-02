package com.google.android.exoplayer2.f.d;

import android.text.Html;
import android.text.TextUtils;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends b {
    private static final Pattern bCF = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");
    private final StringBuilder bCG = new StringBuilder();

    @Override // com.google.android.exoplayer2.f.b
    public final /* synthetic */ d b(byte[] bArr, int i2, boolean z) {
        AppMethodBeat.i(92817);
        b h2 = h(bArr, i2);
        AppMethodBeat.o(92817);
        return h2;
    }

    static {
        AppMethodBeat.i(92818);
        AppMethodBeat.o(92818);
    }

    public a() {
        super("SubripDecoder");
        AppMethodBeat.i(92814);
        AppMethodBeat.o(92814);
    }

    private b h(byte[] bArr, int i2) {
        boolean z;
        AppMethodBeat.i(92815);
        ArrayList arrayList = new ArrayList();
        h hVar = new h();
        m mVar = new m(bArr, i2);
        while (true) {
            String readLine = mVar.readLine();
            if (readLine == null) {
                break;
            } else if (readLine.length() != 0) {
                try {
                    Integer.parseInt(readLine);
                    String readLine2 = mVar.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    Matcher matcher = bCF.matcher(readLine2);
                    if (matcher.matches()) {
                        hVar.add(a(matcher, 1));
                        if (!TextUtils.isEmpty(matcher.group(6))) {
                            hVar.add(a(matcher, 6));
                            z = true;
                        } else {
                            z = false;
                        }
                        this.bCG.setLength(0);
                        while (true) {
                            String readLine3 = mVar.readLine();
                            if (TextUtils.isEmpty(readLine3)) {
                                break;
                            }
                            if (this.bCG.length() > 0) {
                                this.bCG.append("<br>");
                            }
                            this.bCG.append(readLine3.trim());
                        }
                        arrayList.add(new com.google.android.exoplayer2.f.a(Html.fromHtml(this.bCG.toString())));
                        if (z) {
                            arrayList.add(null);
                        }
                    }
                } catch (NumberFormatException e2) {
                }
            }
        }
        com.google.android.exoplayer2.f.a[] aVarArr = new com.google.android.exoplayer2.f.a[arrayList.size()];
        arrayList.toArray(aVarArr);
        b bVar = new b(aVarArr, hVar.toArray());
        AppMethodBeat.o(92815);
        return bVar;
    }

    private static long a(Matcher matcher, int i2) {
        AppMethodBeat.i(92816);
        long parseLong = ((Long.parseLong(matcher.group(i2 + 1)) * 60 * 60 * 1000) + (Long.parseLong(matcher.group(i2 + 2)) * 60 * 1000) + (Long.parseLong(matcher.group(i2 + 3)) * 1000) + Long.parseLong(matcher.group(i2 + 4))) * 1000;
        AppMethodBeat.o(92816);
        return parseLong;
    }
}
