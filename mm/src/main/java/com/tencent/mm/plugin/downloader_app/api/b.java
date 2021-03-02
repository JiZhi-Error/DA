package com.tencent.mm.plugin.downloader_app.api;

import android.content.Context;
import android.content.DialogInterface;

public interface b extends com.tencent.mm.kernel.c.a {

    public interface a {
        void onClick();
    }

    void a(Context context, a aVar, a aVar2);

    void a(Context context, String str, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnCancelListener onCancelListener);

    void a(Context context, String str, a aVar, a aVar2, a aVar3);
}
