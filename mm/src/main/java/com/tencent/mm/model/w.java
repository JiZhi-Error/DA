package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.a.a.a;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.protocal.protobuf.xg;
import com.tencent.mm.sdk.event.IEvent;
import java.util.ArrayList;
import java.util.List;

public final class w implements b {
    @Override // com.tencent.mm.plugin.chatroom.a.b
    public final List<String> Ic(String str) {
        AppMethodBeat.i(101776);
        List<String> Ic = v.Ic(str);
        AppMethodBeat.o(101776);
        return Ic;
    }

    @Override // com.tencent.mm.plugin.chatroom.a.b
    public final int Ie(String str) {
        AppMethodBeat.i(101777);
        int Ie = v.Ie(str);
        AppMethodBeat.o(101777);
        return Ie;
    }

    @Override // com.tencent.mm.plugin.chatroom.a.b
    public final boolean a(String str, ArrayList<String> arrayList, String str2) {
        AppMethodBeat.i(101778);
        boolean a2 = v.a(str, arrayList, str2);
        AppMethodBeat.o(101778);
        return a2;
    }

    @Override // com.tencent.mm.plugin.chatroom.a.b
    public final String ao(List<String> list) {
        AppMethodBeat.i(101779);
        String e2 = v.e(list, -1);
        AppMethodBeat.o(101779);
        return e2;
    }

    @Override // com.tencent.mm.plugin.chatroom.a.b
    public final boolean Ih(String str) {
        AppMethodBeat.i(194529);
        boolean Ih = v.Ih(str);
        AppMethodBeat.o(194529);
        return Ih;
    }

    @Override // com.tencent.mm.plugin.chatroom.a.b
    public final boolean a(String str, String str2, xg xgVar, String str3, a aVar, IEvent iEvent) {
        AppMethodBeat.i(101781);
        boolean a2 = v.a(str, str2, xgVar, 0, -1, str3, aVar, iEvent);
        AppMethodBeat.o(101781);
        return a2;
    }
}
