package com.tencent.mm.plugin.sns.ui.c.a;

import android.view.View;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.protocal.protobuf.TimeLineObject;

public abstract class a {
    public SnsInfo DsC;
    protected c Dyw;
    public View EAV;
    public at EUK;
    public View contentView;
    public View lJI;
    protected TimeLineObject timeLineObject;

    public abstract void n(View view, View view2);

    public abstract void refreshView();

    public void onPause() {
    }
}
