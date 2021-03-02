package com.google.android.gms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CursorWrapper extends android.database.CursorWrapper implements CrossProcessCursor {
    private AbstractWindowedCursor zzxu;

    public CursorWrapper(Cursor cursor) {
        super(cursor);
        AppMethodBeat.i(4957);
        Cursor cursor2 = cursor;
        for (int i2 = 0; i2 < 10 && (cursor2 instanceof android.database.CursorWrapper); i2++) {
            cursor2 = ((android.database.CursorWrapper) cursor2).getWrappedCursor();
        }
        if (!(cursor2 instanceof AbstractWindowedCursor)) {
            String valueOf = String.valueOf(cursor2.getClass().getName());
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(valueOf.length() != 0 ? "Unknown type: ".concat(valueOf) : new String("Unknown type: "));
            AppMethodBeat.o(4957);
            throw illegalArgumentException;
        }
        this.zzxu = (AbstractWindowedCursor) cursor2;
        AppMethodBeat.o(4957);
    }

    public void fillWindow(int i2, CursorWindow cursorWindow) {
        AppMethodBeat.i(4960);
        this.zzxu.fillWindow(i2, cursorWindow);
        AppMethodBeat.o(4960);
    }

    public CursorWindow getWindow() {
        AppMethodBeat.i(4958);
        CursorWindow window = this.zzxu.getWindow();
        AppMethodBeat.o(4958);
        return window;
    }

    public AbstractWindowedCursor getWrappedCursor() {
        return this.zzxu;
    }

    public boolean onMove(int i2, int i3) {
        AppMethodBeat.i(4961);
        boolean onMove = this.zzxu.onMove(i2, i3);
        AppMethodBeat.o(4961);
        return onMove;
    }

    public void setWindow(CursorWindow cursorWindow) {
        AppMethodBeat.i(4959);
        this.zzxu.setWindow(cursorWindow);
        AppMethodBeat.o(4959);
    }
}
