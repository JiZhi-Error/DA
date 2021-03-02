package com.tencent.wcdb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class CursorJoiner implements Iterable<Result>, Iterator<Result> {
    private int[] mColumnsLeft;
    private int[] mColumnsRight;
    private Result mCompareResult;
    private boolean mCompareResultIsValid;
    private Cursor mCursorLeft;
    private Cursor mCursorRight;
    private String[] mValues;

    public enum Result {
        RIGHT,
        LEFT,
        BOTH;

        public static Result valueOf(String str) {
            AppMethodBeat.i(2673);
            Result result = (Result) Enum.valueOf(Result.class, str);
            AppMethodBeat.o(2673);
            return result;
        }

        static {
            AppMethodBeat.i(2674);
            AppMethodBeat.o(2674);
        }
    }

    public CursorJoiner(Cursor cursor, String[] strArr, Cursor cursor2, String[] strArr2) {
        AppMethodBeat.i(2675);
        if (strArr.length != strArr2.length) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("you must have the same number of columns on the left and right, " + strArr.length + " != " + strArr2.length);
            AppMethodBeat.o(2675);
            throw illegalArgumentException;
        }
        this.mCursorLeft = cursor;
        this.mCursorRight = cursor2;
        this.mCursorLeft.moveToFirst();
        this.mCursorRight.moveToFirst();
        this.mCompareResultIsValid = false;
        this.mColumnsLeft = buildColumnIndiciesArray(cursor, strArr);
        this.mColumnsRight = buildColumnIndiciesArray(cursor2, strArr2);
        this.mValues = new String[(this.mColumnsLeft.length * 2)];
        AppMethodBeat.o(2675);
    }

    @Override // java.lang.Iterable
    public final Iterator<Result> iterator() {
        return this;
    }

    private int[] buildColumnIndiciesArray(Cursor cursor, String[] strArr) {
        AppMethodBeat.i(2676);
        int[] iArr = new int[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            iArr[i2] = cursor.getColumnIndexOrThrow(strArr[i2]);
        }
        AppMethodBeat.o(2676);
        return iArr;
    }

    public final boolean hasNext() {
        AppMethodBeat.i(2677);
        if (this.mCompareResultIsValid) {
            switch (this.mCompareResult) {
                case BOTH:
                    if (!this.mCursorLeft.isLast() || !this.mCursorRight.isLast()) {
                        AppMethodBeat.o(2677);
                        return true;
                    }
                    AppMethodBeat.o(2677);
                    return false;
                case LEFT:
                    if (!this.mCursorLeft.isLast() || !this.mCursorRight.isAfterLast()) {
                        AppMethodBeat.o(2677);
                        return true;
                    }
                    AppMethodBeat.o(2677);
                    return false;
                case RIGHT:
                    if (!this.mCursorLeft.isAfterLast() || !this.mCursorRight.isLast()) {
                        AppMethodBeat.o(2677);
                        return true;
                    }
                    AppMethodBeat.o(2677);
                    return false;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("bad value for mCompareResult, " + this.mCompareResult);
                    AppMethodBeat.o(2677);
                    throw illegalStateException;
            }
        } else if (!this.mCursorLeft.isAfterLast() || !this.mCursorRight.isAfterLast()) {
            AppMethodBeat.o(2677);
            return true;
        } else {
            AppMethodBeat.o(2677);
            return false;
        }
    }

    @Override // java.util.Iterator
    public final Result next() {
        boolean z;
        AppMethodBeat.i(2678);
        if (!hasNext()) {
            IllegalStateException illegalStateException = new IllegalStateException("you must only call next() when hasNext() is true");
            AppMethodBeat.o(2678);
            throw illegalStateException;
        }
        incrementCursors();
        boolean z2 = !this.mCursorLeft.isAfterLast();
        if (!this.mCursorRight.isAfterLast()) {
            z = true;
        } else {
            z = false;
        }
        if (z2 && z) {
            populateValues(this.mValues, this.mCursorLeft, this.mColumnsLeft, 0);
            populateValues(this.mValues, this.mCursorRight, this.mColumnsRight, 1);
            switch (compareStrings(this.mValues)) {
                case -1:
                    this.mCompareResult = Result.LEFT;
                    break;
                case 0:
                    this.mCompareResult = Result.BOTH;
                    break;
                case 1:
                    this.mCompareResult = Result.RIGHT;
                    break;
            }
        } else if (z2) {
            this.mCompareResult = Result.LEFT;
        } else {
            this.mCompareResult = Result.RIGHT;
        }
        this.mCompareResultIsValid = true;
        Result result = this.mCompareResult;
        AppMethodBeat.o(2678);
        return result;
    }

    public final void remove() {
        AppMethodBeat.i(2679);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("not implemented");
        AppMethodBeat.o(2679);
        throw unsupportedOperationException;
    }

    private static void populateValues(String[] strArr, Cursor cursor, int[] iArr, int i2) {
        AppMethodBeat.i(2680);
        for (int i3 = 0; i3 < iArr.length; i3++) {
            strArr[(i3 * 2) + i2] = cursor.getString(iArr[i3]);
        }
        AppMethodBeat.o(2680);
    }

    private void incrementCursors() {
        AppMethodBeat.i(2681);
        if (this.mCompareResultIsValid) {
            switch (this.mCompareResult) {
                case BOTH:
                    this.mCursorLeft.moveToNext();
                    this.mCursorRight.moveToNext();
                    break;
                case LEFT:
                    this.mCursorLeft.moveToNext();
                    break;
                case RIGHT:
                    this.mCursorRight.moveToNext();
                    break;
            }
            this.mCompareResultIsValid = false;
        }
        AppMethodBeat.o(2681);
    }

    private static int compareStrings(String... strArr) {
        AppMethodBeat.i(2682);
        if (strArr.length % 2 != 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("you must specify an even number of values");
            AppMethodBeat.o(2682);
            throw illegalArgumentException;
        }
        for (int i2 = 0; i2 < strArr.length; i2 += 2) {
            if (strArr[i2] == null) {
                if (strArr[i2 + 1] != null) {
                    AppMethodBeat.o(2682);
                    return -1;
                }
            } else if (strArr[i2 + 1] == null) {
                AppMethodBeat.o(2682);
                return 1;
            } else {
                int compareTo = strArr[i2].compareTo(strArr[i2 + 1]);
                if (compareTo != 0) {
                    if (compareTo < 0) {
                        AppMethodBeat.o(2682);
                        return -1;
                    }
                    AppMethodBeat.o(2682);
                    return 1;
                }
            }
        }
        AppMethodBeat.o(2682);
        return 0;
    }
}
