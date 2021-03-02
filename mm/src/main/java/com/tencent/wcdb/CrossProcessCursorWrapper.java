package com.tencent.wcdb;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CrossProcessCursorWrapper extends CursorWrapper implements CrossProcessCursor {
    public CrossProcessCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    @Override // com.tencent.wcdb.CrossProcessCursor
    public void fillWindow(int i2, CursorWindow cursorWindow) {
        AppMethodBeat.i(2667);
        if (this.mCursor instanceof CrossProcessCursor) {
            ((CrossProcessCursor) this.mCursor).fillWindow(i2, cursorWindow);
            AppMethodBeat.o(2667);
            return;
        }
        DatabaseUtils.cursorFillWindow(this.mCursor, i2, cursorWindow);
        AppMethodBeat.o(2667);
    }

    @Override // com.tencent.wcdb.CrossProcessCursor
    public CursorWindow getWindow() {
        AppMethodBeat.i(2668);
        if (this.mCursor instanceof CrossProcessCursor) {
            CursorWindow window = ((CrossProcessCursor) this.mCursor).getWindow();
            AppMethodBeat.o(2668);
            return window;
        }
        AppMethodBeat.o(2668);
        return null;
    }

    @Override // com.tencent.wcdb.CrossProcessCursor
    public boolean onMove(int i2, int i3) {
        AppMethodBeat.i(2669);
        if (this.mCursor instanceof CrossProcessCursor) {
            boolean onMove = ((CrossProcessCursor) this.mCursor).onMove(i2, i3);
            AppMethodBeat.o(2669);
            return onMove;
        }
        AppMethodBeat.o(2669);
        return true;
    }
}
