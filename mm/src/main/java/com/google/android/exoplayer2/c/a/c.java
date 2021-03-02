package com.google.android.exoplayer2.c.a;

import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

final class c extends d {
    long bdJ = -9223372036854775807L;

    public c() {
        super(null);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c.a.d
    public final boolean a(m mVar) {
        return true;
    }

    private static Boolean b(m mVar) {
        boolean z = true;
        AppMethodBeat.i(91985);
        if (mVar.readUnsignedByte() != 1) {
            z = false;
        }
        Boolean valueOf = Boolean.valueOf(z);
        AppMethodBeat.o(91985);
        return valueOf;
    }

    private static Double c(m mVar) {
        AppMethodBeat.i(91986);
        Double valueOf = Double.valueOf(Double.longBitsToDouble(mVar.readLong()));
        AppMethodBeat.o(91986);
        return valueOf;
    }

    private static String d(m mVar) {
        AppMethodBeat.i(91987);
        int readUnsignedShort = mVar.readUnsignedShort();
        int i2 = mVar.position;
        mVar.eZ(readUnsignedShort);
        String str = new String(mVar.data, i2, readUnsignedShort);
        AppMethodBeat.o(91987);
        return str;
    }

    private static ArrayList<Object> e(m mVar) {
        AppMethodBeat.i(91988);
        int xk = mVar.xk();
        ArrayList<Object> arrayList = new ArrayList<>(xk);
        for (int i2 = 0; i2 < xk; i2++) {
            arrayList.add(b(mVar, mVar.readUnsignedByte()));
        }
        AppMethodBeat.o(91988);
        return arrayList;
    }

    private static HashMap<String, Object> f(m mVar) {
        AppMethodBeat.i(91989);
        HashMap<String, Object> hashMap = new HashMap<>();
        while (true) {
            String d2 = d(mVar);
            int readUnsignedByte = mVar.readUnsignedByte();
            if (readUnsignedByte != 9) {
                hashMap.put(d2, b(mVar, readUnsignedByte));
            } else {
                AppMethodBeat.o(91989);
                return hashMap;
            }
        }
    }

    private static HashMap<String, Object> g(m mVar) {
        AppMethodBeat.i(91990);
        int xk = mVar.xk();
        HashMap<String, Object> hashMap = new HashMap<>(xk);
        for (int i2 = 0; i2 < xk; i2++) {
            hashMap.put(d(mVar), b(mVar, mVar.readUnsignedByte()));
        }
        AppMethodBeat.o(91990);
        return hashMap;
    }

    private static Date h(m mVar) {
        AppMethodBeat.i(91991);
        Date date = new Date((long) c(mVar).doubleValue());
        mVar.eZ(2);
        AppMethodBeat.o(91991);
        return date;
    }

    private static Object b(m mVar, int i2) {
        AppMethodBeat.i(91992);
        switch (i2) {
            case 0:
                Double c2 = c(mVar);
                AppMethodBeat.o(91992);
                return c2;
            case 1:
                Boolean b2 = b(mVar);
                AppMethodBeat.o(91992);
                return b2;
            case 2:
                String d2 = d(mVar);
                AppMethodBeat.o(91992);
                return d2;
            case 3:
                HashMap<String, Object> f2 = f(mVar);
                AppMethodBeat.o(91992);
                return f2;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            default:
                AppMethodBeat.o(91992);
                return null;
            case 8:
                HashMap<String, Object> g2 = g(mVar);
                AppMethodBeat.o(91992);
                return g2;
            case 10:
                ArrayList<Object> e2 = e(mVar);
                AppMethodBeat.o(91992);
                return e2;
            case 11:
                Date h2 = h(mVar);
                AppMethodBeat.o(91992);
                return h2;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.c.a.d
    public final void a(m mVar, long j2) {
        AppMethodBeat.i(91984);
        if (mVar.readUnsignedByte() != 2) {
            o oVar = new o();
            AppMethodBeat.o(91984);
            throw oVar;
        } else if (!"onMetaData".equals(d(mVar))) {
            AppMethodBeat.o(91984);
        } else if (mVar.readUnsignedByte() != 8) {
            AppMethodBeat.o(91984);
        } else {
            HashMap<String, Object> g2 = g(mVar);
            if (g2.containsKey(FFmpegMetadataRetriever.METADATA_KEY_DURATION)) {
                double doubleValue = ((Double) g2.get(FFmpegMetadataRetriever.METADATA_KEY_DURATION)).doubleValue();
                if (doubleValue > 0.0d) {
                    this.bdJ = (long) (doubleValue * 1000000.0d);
                }
            }
            AppMethodBeat.o(91984);
        }
    }
}
