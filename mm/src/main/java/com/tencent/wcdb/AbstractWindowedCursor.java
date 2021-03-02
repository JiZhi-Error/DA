package com.tencent.wcdb;

import android.database.CharArrayBuffer;

public abstract class AbstractWindowedCursor extends AbstractCursor {
    protected CursorWindow mWindow;

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public byte[] getBlob(int i2) {
        checkPosition();
        return this.mWindow.getBlob(this.mPos, i2);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public String getString(int i2) {
        checkPosition();
        return this.mWindow.getString(this.mPos, i2);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public void copyStringToBuffer(int i2, CharArrayBuffer charArrayBuffer) {
        checkPosition();
        this.mWindow.copyStringToBuffer(this.mPos, i2, charArrayBuffer);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public short getShort(int i2) {
        checkPosition();
        return this.mWindow.getShort(this.mPos, i2);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public int getInt(int i2) {
        checkPosition();
        return this.mWindow.getInt(this.mPos, i2);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public long getLong(int i2) {
        checkPosition();
        return this.mWindow.getLong(this.mPos, i2);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public float getFloat(int i2) {
        checkPosition();
        return this.mWindow.getFloat(this.mPos, i2);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public double getDouble(int i2) {
        checkPosition();
        return this.mWindow.getDouble(this.mPos, i2);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public boolean isNull(int i2) {
        checkPosition();
        return this.mWindow.getType(this.mPos, i2) == 0;
    }

    @Deprecated
    public boolean isBlob(int i2) {
        return getType(i2) == 4;
    }

    @Deprecated
    public boolean isString(int i2) {
        return getType(i2) == 3;
    }

    @Deprecated
    public boolean isLong(int i2) {
        return getType(i2) == 1;
    }

    @Deprecated
    public boolean isFloat(int i2) {
        return getType(i2) == 2;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor
    public int getType(int i2) {
        checkPosition();
        return this.mWindow.getType(this.mPos, i2);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.wcdb.AbstractCursor
    public void checkPosition() {
        super.checkPosition();
        if (this.mWindow == null) {
            throw new StaleDataException("Attempting to access a closed CursorWindow.Most probable cause: cursor is deactivated prior to calling this method.");
        }
    }

    @Override // com.tencent.wcdb.CrossProcessCursor, com.tencent.wcdb.AbstractCursor
    public CursorWindow getWindow() {
        return this.mWindow;
    }

    public void setWindow(CursorWindow cursorWindow) {
        if (cursorWindow != this.mWindow) {
            closeWindow();
            this.mWindow = cursorWindow;
        }
    }

    public boolean hasWindow() {
        return this.mWindow != null;
    }

    /* access modifiers changed from: protected */
    public void closeWindow() {
        if (this.mWindow != null) {
            this.mWindow.close();
            this.mWindow = null;
        }
    }

    /* access modifiers changed from: protected */
    public void clearOrCreateWindow(String str) {
        if (this.mWindow == null) {
            this.mWindow = new CursorWindow(str);
        } else {
            this.mWindow.clear();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.wcdb.AbstractCursor
    public void onDeactivateOrClose() {
        super.onDeactivateOrClose();
        closeWindow();
    }
}
