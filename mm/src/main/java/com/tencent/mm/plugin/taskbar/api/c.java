package com.tencent.mm.plugin.taskbar.api;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;

public interface c extends com.tencent.mm.kernel.c.a {

    public interface a {
        void a(MultiTaskInfo multiTaskInfo);

        void b(MultiTaskInfo multiTaskInfo);

        void c(MultiTaskInfo multiTaskInfo);
    }

    b a(Context context, ListView listView, HeaderContainer headerContainer);

    void a(int i2, a aVar);

    void b(int i2, a aVar);

    void fuu();

    boolean fuv();

    void hWP();

    HeaderContainer hn(Context context);

    View ho(Context context);
}
