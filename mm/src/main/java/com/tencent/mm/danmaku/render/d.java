package com.tencent.mm.danmaku.render;

import android.graphics.Canvas;
import android.view.View;

public interface d {

    public interface a {
        void asg();

        void ash();

        void asi();
    }

    public interface b {
        void l(Canvas canvas);
    }

    void a(a aVar);

    void a(b bVar);

    float atd();

    Canvas lockCanvas();

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void unlock();

    void unlockCanvasAndPost(Canvas canvas);
}
