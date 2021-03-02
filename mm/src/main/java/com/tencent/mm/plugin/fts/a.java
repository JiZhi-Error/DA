package com.tencent.mm.plugin.fts;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Iterator;

public final class a extends CursorWrapper {
    private static HashSet<Cursor> wTm = new HashSet<>();

    static {
        AppMethodBeat.i(52498);
        AppMethodBeat.o(52498);
    }

    public a(Cursor cursor) {
        super(cursor);
        AppMethodBeat.i(52495);
        wTm.add(cursor);
        Log.v("MicroMsg.FTS.FTSCursor", "add cursor %d", Integer.valueOf(cursor.hashCode()));
        AppMethodBeat.o(52495);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(52496);
        super.close();
        Cursor wrappedCursor = getWrappedCursor();
        wTm.remove(wrappedCursor);
        Log.v("MicroMsg.FTS.FTSCursor", "remove cursor %d", Integer.valueOf(wrappedCursor.hashCode()));
        AppMethodBeat.o(52496);
    }

    public static final void dOj() {
        AppMethodBeat.i(52497);
        Iterator<Cursor> it = wTm.iterator();
        while (it.hasNext()) {
            Cursor next = it.next();
            if (!next.isClosed()) {
                try {
                    next.close();
                } catch (Exception e2) {
                }
                Log.e("MicroMsg.FTS.FTSCursor", "not close cursor!!! %d", Integer.valueOf(next.hashCode()));
            }
        }
        wTm.clear();
        AppMethodBeat.o(52497);
    }
}
