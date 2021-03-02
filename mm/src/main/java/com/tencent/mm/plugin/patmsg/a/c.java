package com.tencent.mm.plugin.patmsg.a;

import android.view.View;

public interface c {

    public interface a {
        boolean eF(View view);
    }

    a getDoubleClickListener();

    View.OnClickListener getOnClickListener();

    int getTagScene();

    String getTagTalker();

    String getTagUsername();
}
