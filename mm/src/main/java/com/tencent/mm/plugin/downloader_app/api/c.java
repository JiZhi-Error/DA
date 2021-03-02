package com.tencent.mm.plugin.downloader_app.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.downloader_app.api.a;
import java.util.LinkedList;

public interface c extends a {
    void EN(String str);

    long a(com.tencent.mm.plugin.downloader_app.a.a aVar, a.b bVar);

    void a(Context context, Intent intent, a.c cVar);

    void a(e eVar);

    boolean a(long j2, boolean z, a.b bVar);

    void at(Context context, String str);

    void b(e eVar);

    boolean cBP();

    void cBQ();

    LinkedList<DownloadWidgetTaskInfo> cBR();

    void cBS();

    boolean cBT();

    void e(Context context, Bundle bundle);
}
