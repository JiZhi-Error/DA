package com.tencent.mm.roomsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.roomsdk.a.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class b {
    private static b NDJ = new b();
    private HashMap<String, a> NDI = new HashMap<>();

    public b() {
        AppMethodBeat.i(152755);
        AppMethodBeat.o(152755);
    }

    static {
        AppMethodBeat.i(152758);
        AppMethodBeat.o(152758);
    }

    public static a bhF(String str) {
        a aVar;
        AppMethodBeat.i(152756);
        int indexOf = str.indexOf("@");
        if (indexOf < 0) {
            Log.e("MicroMsg.RoomServiceFactory", "get NotNullChatRoom %s", str);
            com.tencent.mm.roomsdk.a.a.b bVar = new com.tencent.mm.roomsdk.a.a.b();
            AppMethodBeat.o(152756);
            return bVar;
        }
        String substring = str.substring(indexOf);
        b bVar2 = NDJ;
        if (bVar2.NDI.containsKey(substring)) {
            aVar = bVar2.NDI.get(substring);
        } else {
            aVar = null;
        }
        if (aVar == null) {
            com.tencent.mm.roomsdk.a.a.b bVar3 = new com.tencent.mm.roomsdk.a.a.b();
            AppMethodBeat.o(152756);
            return bVar3;
        }
        AppMethodBeat.o(152756);
        return aVar;
    }

    public static void a(String str, a aVar) {
        AppMethodBeat.i(152757);
        int indexOf = str.indexOf("@");
        if (indexOf >= 0) {
            str = str.substring(indexOf);
        }
        b bVar = NDJ;
        if (!bVar.NDI.containsKey(str)) {
            bVar.NDI.put(str, aVar);
        }
        AppMethodBeat.o(152757);
    }
}
