package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.tencent.mm.ui.widget.a.e;
import java.util.List;

public interface e {

    public static class a {
        public static e KqE;
    }

    void a(Context context, String str, DialogInterface.OnDismissListener onDismissListener, Bundle bundle);

    void a(Context context, List<String> list, e.b bVar);
}
