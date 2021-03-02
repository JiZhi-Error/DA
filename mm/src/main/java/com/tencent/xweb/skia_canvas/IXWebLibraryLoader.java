package com.tencent.xweb.skia_canvas;

public interface IXWebLibraryLoader {
    boolean afterLoad();

    boolean beforeLoad();

    boolean load(String str);
}
