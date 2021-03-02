package com.tencent.wcdb;

public interface CrossProcessCursor extends Cursor {
    void fillWindow(int i2, CursorWindow cursorWindow);

    CursorWindow getWindow();

    boolean onMove(int i2, int i3);
}
