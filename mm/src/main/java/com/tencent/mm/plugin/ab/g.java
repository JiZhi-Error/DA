package com.tencent.mm.plugin.ab;

import com.eclipsesource.v8.V8Object;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\u0007H&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0007H&J\b\u0010\u000f\u001a\u00020\u0007H&J\b\u0010\u0010\u001a\u00020\u0007H&J\b\u0010\u0011\u001a\u00020\u0003H&J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\rH&J8\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\rH&J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0017H&J\u0018\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0017H&¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/webjsapi/WxCanvasAPIContext;", "Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;", "canVideoAutoPlay", "", "getCanvas", "Lcom/eclipsesource/v8/V8Object;", "getElementId", "", "getFontSize", "", "getFps", "getHeight", "getId", "", "getOffsetHeight", "getOffsetTop", "getWidth", "isOnScreen", "restore", "canvasId", "save", "", "left", "", "top", "width", "height", "layout", "setHeight", "setVideo", "bottom", "webview-sdk_release"})
public interface g extends b {
    boolean canVideoAutoPlay();

    V8Object getCanvas();

    int getElementId();

    float getFontSize();

    int getFps();

    int getHeight();

    String getId();

    int getOffsetHeight();

    int getOffsetTop();

    int getWidth();

    boolean isOnScreen();

    String restore(String str);

    void save(String str, Number number, Number number2, Number number3, Number number4, String str2);

    void setHeight(Number number);

    void setVideo(Number number, Number number2);
}
