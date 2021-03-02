package com.tencent.mm.plugin.sns.b;

import android.widget.ImageView;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;

public interface n extends a {
    boolean IM(long j2);

    TimeLineObject PM(String str);

    void a(long j2, ImageView imageView, int i2);
}
