package com.tencent.mm.plugin.i.a;

import android.content.Context;
import com.tencent.mm.protocal.protobuf.azi;
import com.tencent.mm.protocal.protobuf.azj;
import java.util.LinkedList;
import java.util.List;

public interface aa extends com.tencent.mm.kernel.c.a {

    public interface a {
        void j(String str, int i2, int i3, String str2);
    }

    public interface b {
        void er(List<azj> list);
    }

    void a(Context context, int i2, String str, a aVar);

    void a(Context context, int i2, String str, String str2, Long l, a aVar);

    void a(Context context, String str, String str2, a aVar);

    void a(Context context, String str, String str2, Long l, Long l2, a aVar);

    void a(LinkedList<azi> linkedList, b bVar);

    String avi(String str);

    String avj(String str);

    String avk(String str);

    boolean avl(String str);
}
