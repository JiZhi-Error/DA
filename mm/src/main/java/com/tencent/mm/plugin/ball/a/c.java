package com.tencent.mm.plugin.ball.a;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mm.plugin.ball.model.BallInfo;

public class c implements b {
    @Override // com.tencent.mm.plugin.ball.a.b
    public boolean a(Context context, BallInfo ballInfo) {
        return false;
    }

    @Override // com.tencent.mm.plugin.ball.a.b
    public boolean a(TextView textView, BallInfo ballInfo) {
        return false;
    }
}
