package com.tencent.mm.storagebase;

import android.database.AbstractCursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class e extends AbstractCursor {
    private final int columnCount;
    private final String[] columnNames;
    private Object[] data;
    private int rowCount;

    private e(String[] strArr) {
        AppMethodBeat.i(133331);
        this.rowCount = 0;
        this.columnNames = strArr;
        this.columnCount = strArr.length;
        this.data = new Object[(this.columnCount * 16)];
        AppMethodBeat.o(133331);
    }

    public e(String[] strArr, byte b2) {
        this(strArr);
    }

    private Object get(int i2) {
        AppMethodBeat.i(133332);
        if (i2 < 0 || i2 >= this.columnCount) {
            CursorIndexOutOfBoundsException cursorIndexOutOfBoundsException = new CursorIndexOutOfBoundsException("Requested column: " + i2 + ", # of columns: " + this.columnCount);
            AppMethodBeat.o(133332);
            throw cursorIndexOutOfBoundsException;
        } else if (this.mPos < 0) {
            CursorIndexOutOfBoundsException cursorIndexOutOfBoundsException2 = new CursorIndexOutOfBoundsException("Before first row.");
            AppMethodBeat.o(133332);
            throw cursorIndexOutOfBoundsException2;
        } else if (this.mPos >= this.rowCount) {
            CursorIndexOutOfBoundsException cursorIndexOutOfBoundsException3 = new CursorIndexOutOfBoundsException("After last row.");
            AppMethodBeat.o(133332);
            throw cursorIndexOutOfBoundsException3;
        } else {
            Object obj = this.data[(this.mPos * this.columnCount) + i2];
            AppMethodBeat.o(133332);
            return obj;
        }
    }

    public final void addRow(Object[] objArr) {
        AppMethodBeat.i(133333);
        if (objArr.length != this.columnCount) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("columnNames.length = " + this.columnCount + ", columnValues.length = " + objArr.length);
            AppMethodBeat.o(133333);
            throw illegalArgumentException;
        }
        int i2 = this.rowCount;
        this.rowCount = i2 + 1;
        int i3 = i2 * this.columnCount;
        ensureCapacity(this.columnCount + i3);
        System.arraycopy(objArr, 0, this.data, i3, this.columnCount);
        AppMethodBeat.o(133333);
    }

    private void ensureCapacity(int i2) {
        AppMethodBeat.i(133334);
        if (i2 > this.data.length) {
            Object[] objArr = this.data;
            int length = this.data.length * 2;
            if (length >= i2) {
                i2 = length;
            }
            this.data = new Object[i2];
            System.arraycopy(objArr, 0, this.data, 0, objArr.length);
        }
        AppMethodBeat.o(133334);
    }

    public final int getCount() {
        return this.rowCount;
    }

    public final String[] getColumnNames() {
        return this.columnNames;
    }

    public final String getString(int i2) {
        AppMethodBeat.i(133335);
        Object obj = get(i2);
        if (obj == null) {
            AppMethodBeat.o(133335);
            return null;
        }
        String obj2 = obj.toString();
        AppMethodBeat.o(133335);
        return obj2;
    }

    public final short getShort(int i2) {
        AppMethodBeat.i(133336);
        Object obj = get(i2);
        if (obj == null) {
            AppMethodBeat.o(133336);
            return 0;
        } else if (obj instanceof Number) {
            short shortValue = ((Number) obj).shortValue();
            AppMethodBeat.o(133336);
            return shortValue;
        } else {
            short parseShort = Short.parseShort(obj.toString());
            AppMethodBeat.o(133336);
            return parseShort;
        }
    }

    public final int getInt(int i2) {
        AppMethodBeat.i(133337);
        Object obj = get(i2);
        if (obj == null) {
            AppMethodBeat.o(133337);
            return 0;
        } else if (obj instanceof Number) {
            int intValue = ((Number) obj).intValue();
            AppMethodBeat.o(133337);
            return intValue;
        } else {
            int i3 = Util.getInt(obj.toString(), 0);
            AppMethodBeat.o(133337);
            return i3;
        }
    }

    public final long getLong(int i2) {
        AppMethodBeat.i(133338);
        Object obj = get(i2);
        if (obj == null) {
            AppMethodBeat.o(133338);
            return 0;
        } else if (obj instanceof Number) {
            long longValue = ((Number) obj).longValue();
            AppMethodBeat.o(133338);
            return longValue;
        } else {
            long j2 = Util.getLong(obj.toString(), 0);
            AppMethodBeat.o(133338);
            return j2;
        }
    }

    public final float getFloat(int i2) {
        AppMethodBeat.i(133339);
        Object obj = get(i2);
        if (obj == null) {
            AppMethodBeat.o(133339);
            return 0.0f;
        } else if (obj instanceof Number) {
            float floatValue = ((Number) obj).floatValue();
            AppMethodBeat.o(133339);
            return floatValue;
        } else {
            float f2 = Util.getFloat(obj.toString(), 0.0f);
            AppMethodBeat.o(133339);
            return f2;
        }
    }

    public final double getDouble(int i2) {
        AppMethodBeat.i(133340);
        Object obj = get(i2);
        if (obj == null) {
            AppMethodBeat.o(133340);
            return 0.0d;
        } else if (obj instanceof Number) {
            double doubleValue = ((Number) obj).doubleValue();
            AppMethodBeat.o(133340);
            return doubleValue;
        } else {
            double d2 = Util.getDouble(obj.toString(), 0.0d);
            AppMethodBeat.o(133340);
            return d2;
        }
    }

    public final byte[] getBlob(int i2) {
        AppMethodBeat.i(133341);
        byte[] bArr = (byte[]) get(i2);
        AppMethodBeat.o(133341);
        return bArr;
    }

    public final int getType(int i2) {
        AppMethodBeat.i(133342);
        int type = getType(get(i2));
        AppMethodBeat.o(133342);
        return type;
    }

    public final boolean isNull(int i2) {
        AppMethodBeat.i(133343);
        if (get(i2) == null) {
            AppMethodBeat.o(133343);
            return true;
        }
        AppMethodBeat.o(133343);
        return false;
    }

    private static int getType(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof byte[]) {
            return 4;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return 2;
        }
        if ((obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
            return 1;
        }
        return 3;
    }

    public final void fillWindow(int i2, CursorWindow cursorWindow) {
        boolean putNull;
        AppMethodBeat.i(133344);
        if (i2 < 0 || i2 >= getCount()) {
            AppMethodBeat.o(133344);
            return;
        }
        cursorWindow.acquireReference();
        try {
            int position = getPosition();
            int columnCount2 = getColumnCount();
            cursorWindow.clear();
            cursorWindow.setStartPosition(i2);
            cursorWindow.setNumColumns(columnCount2);
            if (moveToPosition(i2)) {
                while (cursorWindow.allocRow()) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < columnCount2) {
                            switch (getType(get(i3))) {
                                case 0:
                                    putNull = cursorWindow.putNull(i2, i3);
                                    break;
                                case 1:
                                    putNull = cursorWindow.putLong(getLong(i3), i2, i3);
                                    break;
                                case 2:
                                    putNull = cursorWindow.putDouble(getDouble(i3), i2, i3);
                                    break;
                                case 3:
                                default:
                                    String string = getString(i3);
                                    if (string == null) {
                                        putNull = cursorWindow.putNull(i2, i3);
                                        break;
                                    } else {
                                        putNull = cursorWindow.putString(string, i2, i3);
                                        break;
                                    }
                                case 4:
                                    byte[] blob = getBlob(i3);
                                    if (blob == null) {
                                        putNull = cursorWindow.putNull(i2, i3);
                                        break;
                                    } else {
                                        putNull = cursorWindow.putBlob(blob, i2, i3);
                                        break;
                                    }
                            }
                            if (!putNull) {
                                cursorWindow.freeLastRow();
                            } else {
                                i3++;
                            }
                        }
                    }
                    i2++;
                    if (!moveToNext()) {
                    }
                }
            }
            moveToPosition(position);
        } catch (IllegalStateException e2) {
        } finally {
            cursorWindow.releaseReference();
            AppMethodBeat.o(133344);
        }
    }
}
