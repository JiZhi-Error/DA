package com.tencent.mm.plugin.appbrand.media.record;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public final class j {
    private static b nea = new a();

    public interface b {
        void J(ArrayList<IDKey> arrayList);

        void yU(long j2);
    }

    static {
        AppMethodBeat.i(146336);
        AppMethodBeat.o(146336);
    }

    public static void a(b bVar) {
        nea = bVar;
    }

    static class a implements b {
        a() {
        }

        @Override // com.tencent.mm.plugin.appbrand.media.record.j.b
        public final void yU(long j2) {
            AppMethodBeat.i(146331);
            Log.v("Luggage.RecordStat", "ID:%d, key:%d, val:%d, isImportant:%b", 689L, Long.valueOf(j2), 1L, Boolean.TRUE);
            AppMethodBeat.o(146331);
        }

        @Override // com.tencent.mm.plugin.appbrand.media.record.j.b
        public final void J(ArrayList<IDKey> arrayList) {
            AppMethodBeat.i(146332);
            Log.v("Luggage.RecordStat", "lstIdKeyDataInfos:%s, isImportant:%b", arrayList, Boolean.TRUE);
            AppMethodBeat.o(146332);
        }
    }

    public static void bPi() {
        AppMethodBeat.i(146333);
        nea.yU(0);
        AppMethodBeat.o(146333);
    }

    public static void yy(int i2) {
        AppMethodBeat.i(146334);
        ArrayList<IDKey> arrayList = new ArrayList<>();
        IDKey iDKey = new IDKey();
        iDKey.SetID(689);
        iDKey.SetKey(1);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(689);
        iDKey2.SetKey(i.yx(i2));
        iDKey2.SetValue(1);
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        nea.J(arrayList);
        AppMethodBeat.o(146334);
    }

    public static void yz(int i2) {
        AppMethodBeat.i(146335);
        nea.yU((long) i.yx(i2));
        AppMethodBeat.o(146335);
    }
}
