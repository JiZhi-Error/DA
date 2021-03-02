package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.collector.d;
import org.json.JSONArray;

public interface a extends b, d {

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.widget.a$a  reason: collision with other inner class name */
    public interface AbstractC0561a {
        void a(DrawCanvasArg drawCanvasArg);
    }

    void U(Runnable runnable);

    void a(DrawCanvasArg drawCanvasArg, AbstractC0561a aVar);

    void a(JSONArray jSONArray, AbstractC0561a aVar);

    void b(DrawCanvasArg drawCanvasArg, AbstractC0561a aVar);

    void b(JSONArray jSONArray, AbstractC0561a aVar);

    void bzg();

    void bzh();

    com.tencent.mm.plugin.appbrand.canvas.d getDrawContext();

    String getTraceId();

    boolean o(Canvas canvas);

    void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a aVar);

    void setTraceId(String str);
}
