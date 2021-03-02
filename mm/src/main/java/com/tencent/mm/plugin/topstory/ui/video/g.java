package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.graphics.Color;
import com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar;

public abstract class g extends WebSearchVideoPlayerSeekBar {
    public abstract void hide();

    public abstract void show();

    public g(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar
    public void init() {
        super.init();
        setBackgroundColor(Color.parseColor("#40000000"));
    }

    public void setCurrentPlaySecond(int i2) {
        this.mPosition = i2;
        this.mCQ.setText(xt(i2 / 60) + ":" + xt(i2 % 60));
        afE(afD(i2));
    }
}
