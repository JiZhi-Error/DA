package com.tencent.mm.storagebase.a;

import android.database.CursorIndexOutOfBoundsException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.a.c;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectQuery;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.support.CancellationSignal;

public final class h extends SQLiteDirectQuery {
    /* access modifiers changed from: package-private */
    public final int a(b bVar, int i2, int i3) {
        boolean z = true;
        AppMethodBeat.i(133505);
        acquireReference();
        bVar.acquireReference();
        if (i2 > 0) {
            try {
                int step = step(i2);
                if (step < i2) {
                    Log.w("WCDB.SQLiteNewQuery", "startPos %d > actual rows %d", Integer.valueOf(i2), Integer.valueOf(step));
                    bVar.releaseReference();
                    releaseReference();
                    AppMethodBeat.o(133505);
                    return step;
                }
            } catch (IllegalStateException e2) {
                Log.printErrStackTrace("WCDB.SQLiteNewQuery", e2, "fillWindow failed", new Object[0]);
                bVar.releaseReference();
                releaseReference();
                AppMethodBeat.o(133505);
                return 0;
            } catch (SQLiteException e3) {
                Log.e("WCDB.SQLiteNewQuery", "exception: " + e3.getMessage() + "; query: " + getSql());
                checkCorruption(e3);
                AppMethodBeat.o(133505);
                throw e3;
            } catch (Throwable th) {
                bVar.releaseReference();
                releaseReference();
                AppMethodBeat.o(133505);
                throw th;
            }
        }
        int length = getColumnNames().length;
        int i4 = i3 + i2;
        int i5 = i2;
        while (true) {
            if (i5 >= i4) {
                z = false;
            } else if (step(1) == 1) {
                bVar.OtO = (T) bVar.gFJ();
                for (int i6 = 0; i6 < length; i6++) {
                    switch (getType(i6)) {
                        case 0:
                            break;
                        case 1:
                            long j2 = getLong(i6);
                            if (bVar.OtO != null) {
                                bVar.OtO.aT(i6, j2);
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            getDouble(i6);
                            break;
                        case 3:
                            String string = getString(i6);
                            if (bVar.OtO != null) {
                                bVar.OtO.dh(i6, string);
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            byte[] blob = getBlob(i6);
                            if (bVar.OtO != null) {
                                bVar.OtO.t(i6, blob);
                                break;
                            } else {
                                break;
                            }
                        default:
                            bVar.kN(i5, 1);
                            SQLiteException sQLiteException = new SQLiteException("Unknown column type when filling window.");
                            AppMethodBeat.o(133505);
                            throw sQLiteException;
                    }
                }
                bVar.kN(i5, 0);
                i5++;
            }
        }
        if (!z) {
            i5 += step(Integer.MAX_VALUE);
        }
        reset(true);
        bVar.releaseReference();
        releaseReference();
        AppMethodBeat.o(133505);
        return i5;
    }

    /* access modifiers changed from: package-private */
    public final int a(c cVar, int i2, int i3) {
        boolean z;
        int i4;
        Object[] objArr;
        Object blob;
        AppMethodBeat.i(133506);
        acquireReference();
        if (i2 > 0) {
            try {
                i4 = step(i2);
                if (i4 < i2) {
                    Log.w("WCDB.SQLiteNewQuery", "startPos %d > actual rows %d", Integer.valueOf(i2), Integer.valueOf(i4));
                    releaseReference();
                    AppMethodBeat.o(133506);
                    return i4;
                }
            } catch (SQLiteException e2) {
                Log.e("WCDB.SQLiteNewQuery", "exception: " + e2.getMessage() + "; query: " + getSql());
                checkCorruption(e2);
                AppMethodBeat.o(133506);
                throw e2;
            } catch (Throwable th) {
                releaseReference();
                AppMethodBeat.o(133506);
                throw th;
            }
        }
        int length = getColumnNames().length;
        int i5 = i3 + i2;
        int i6 = i2;
        while (true) {
            if (i6 >= i5) {
                z = false;
            } else if (step(1) == 1) {
                int i7 = i6 / cVar.OtQ;
                if (cVar.OtP.indexOfKey(i7) < 0) {
                    Object[] objArr2 = new Object[(cVar.OtQ * cVar.columnCount)];
                    cVar.OtP.put(i7, objArr2);
                    objArr = objArr2;
                } else {
                    objArr = cVar.OtP.get(i7);
                }
                int i8 = cVar.columnCount * (i6 % cVar.OtQ);
                int i9 = i8 + cVar.columnCount;
                int i10 = i6 + 1;
                if (i10 <= cVar.OtR) {
                    i10 = cVar.OtR;
                }
                cVar.OtR = i10;
                c.a aVar = new c.a(i8, i9, objArr);
                for (int i11 = 0; i11 < length; i11++) {
                    switch (getType(i11)) {
                        case 0:
                            blob = null;
                            break;
                        case 1:
                            blob = Long.valueOf(getLong(i11));
                            break;
                        case 2:
                            blob = Double.valueOf(getDouble(i11));
                            break;
                        case 3:
                            blob = getString(i11);
                            break;
                        case 4:
                            blob = getBlob(i11);
                            break;
                        default:
                            SQLiteException sQLiteException = new SQLiteException("Unknown column type when filling window.");
                            AppMethodBeat.o(133506);
                            throw sQLiteException;
                    }
                    if (aVar.index == aVar.endIndex) {
                        CursorIndexOutOfBoundsException cursorIndexOutOfBoundsException = new CursorIndexOutOfBoundsException("No more columns left.");
                        AppMethodBeat.o(133506);
                        throw cursorIndexOutOfBoundsException;
                    }
                    Object[] objArr3 = aVar.OtS;
                    int i12 = aVar.index;
                    aVar.index = i12 + 1;
                    objArr3[i12] = blob;
                }
                i6++;
            } else {
                z = true;
            }
        }
        if (!z) {
            i4 = step(Integer.MAX_VALUE) + i6;
        } else {
            i4 = i6;
        }
        reset(true);
        releaseReference();
        AppMethodBeat.o(133506);
        return i4;
    }

    h(SQLiteDatabase sQLiteDatabase, String str, CancellationSignal cancellationSignal) {
        super(sQLiteDatabase, str, null, cancellationSignal);
    }

    public final String toString() {
        AppMethodBeat.i(133507);
        String str = "SQLiteNewQuery: " + getSql();
        AppMethodBeat.o(133507);
        return str;
    }
}
