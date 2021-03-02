package com.tencent.mm.flutter.plugins.platform_video_player;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.VideoView;

public class DefaultFlutterPlatformVideoView extends VideoView {
    public DefaultFlutterPlatformVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DefaultFlutterPlatformVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public View getView() {
        return this;
    }
}
