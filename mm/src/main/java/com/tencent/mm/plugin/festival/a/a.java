package com.tencent.mm.plugin.festival.a;

import android.content.Context;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;

public interface a extends com.tencent.mm.kernel.c.a {

    /* renamed from: com.tencent.mm.plugin.festival.a.a$a  reason: collision with other inner class name */
    public static class C1051a {
        public long UpZ;
        public int Uqa;
        public boolean VC;
        public int liveStatus;
        public String title;
    }

    void ba(Context context, int i2);

    boolean dml();

    C1051a dnB();

    void dqm();

    MultiTaskInfo dqr();

    boolean fQ(Context context);

    void init();
}
