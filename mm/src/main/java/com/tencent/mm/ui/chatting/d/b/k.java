package com.tencent.mm.ui.chatting.d.b;

import android.util.SparseArray;
import android.view.View;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pluginsdk.ui.chat.l;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ac;
import com.tencent.mm.ui.chatting.c;
import com.tencent.mm.ui.chatting.d.af;
import com.tencent.mm.ui.chatting.h.d;
import com.tencent.mm.ui.chatting.t;
import java.util.Set;

public interface k extends k.a, af {
    boolean Nu(long j2);

    void Q(long j2, boolean z);

    void a(int i2, d.a aVar);

    void a(long j2, ca caVar, boolean z);

    void a(long j2, boolean z, d.a aVar);

    ca amt(int i2);

    void amu(int i2);

    void amv(int i2);

    boolean bT(ca caVar);

    void cVM();

    int cZm();

    int eGR();

    t.a gOA();

    t.f gOB();

    t.g gOC();

    ac gOD();

    l gOE();

    c gOF();

    long gOG();

    com.tencent.mm.av.a.a.c gOH();

    SparseArray<ca> gOq();

    Set<Long> gOs();

    void gOt();

    void gOu();

    void gOv();

    void gOw();

    void gOx();

    void gOy();

    void gOz();

    int getCount();

    void i(View.OnClickListener onClickListener);

    boolean isInEditMode();

    void s(long j2, int i2, int i3);

    void uo(boolean z);

    View zh(long j2);
}
