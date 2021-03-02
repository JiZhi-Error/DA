package com.tencent.mm.plugin.chatroom.a;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.xg;
import com.tencent.mm.sdk.event.IEvent;
import java.util.ArrayList;
import java.util.List;

public interface b extends a {
    List<String> Ic(String str);

    int Ie(String str);

    boolean Ih(String str);

    boolean a(String str, String str2, xg xgVar, String str3, com.tencent.mm.k.a.a.a aVar, IEvent iEvent);

    boolean a(String str, ArrayList<String> arrayList, String str2);

    String ao(List<String> list);
}
