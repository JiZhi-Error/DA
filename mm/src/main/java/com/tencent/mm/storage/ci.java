package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k.c;

public final class ci {
    public a OrA;
    int OrB;
    int cSx;
    public String name;
    int status;

    public static class a {
        private String dWq;
        private String domain;

        public a(String str) {
            AppMethodBeat.i(43297);
            int indexOf = str.indexOf("@");
            if (indexOf >= 0) {
                this.dWq = str.substring(0, indexOf);
                this.domain = str.substring(indexOf);
                AppMethodBeat.o(43297);
                return;
            }
            this.dWq = str;
            this.domain = "";
            AppMethodBeat.o(43297);
        }

        public final String bkR(String str) {
            return this.domain != null ? this.domain : str;
        }
    }

    public ci() {
        this.cSx = c.CTRL_INDEX;
        this.name = "";
        this.OrA = null;
        this.OrA = null;
        this.name = "";
        this.status = 0;
        this.OrB = 0;
    }

    public ci(String str, boolean z, int i2) {
        AppMethodBeat.i(43298);
        this.cSx = c.CTRL_INDEX;
        this.name = "";
        this.OrA = null;
        this.OrA = new a(str);
        this.name = str;
        this.status = (z ? 1 : 0) | 2;
        this.OrB = i2;
        AppMethodBeat.o(43298);
    }

    public final void setEnable(boolean z) {
        if (z) {
            this.status = (z ? 1 : 0) | this.status;
            return;
        }
        this.status &= -2;
    }

    public final boolean isEnable() {
        return (this.status & 1) != 0;
    }

    public final boolean gEp() {
        return (this.status & 2) != 0;
    }

    public final boolean gEq() {
        return this.OrB == 1;
    }

    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(43299);
        if ((this.cSx & 2) != 0) {
            this.name = cursor.getString(1);
            if (this.OrA == null) {
                this.OrA = new a(this.name);
            }
        }
        if ((this.cSx & 4) != 0) {
            this.status = cursor.getInt(2);
        }
        if ((this.cSx & 128) != 0) {
            this.OrB = cursor.getInt(7);
        }
        AppMethodBeat.o(43299);
    }

    public final ContentValues convertTo() {
        AppMethodBeat.i(43300);
        ContentValues contentValues = new ContentValues();
        if ((this.cSx & 2) != 0) {
            contentValues.put("name", this.name);
        }
        if ((this.cSx & 4) != 0) {
            contentValues.put("status", Integer.valueOf(this.status));
        }
        if ((this.cSx & 128) != 0) {
            contentValues.put("int_reserved1", Integer.valueOf(this.OrB));
        }
        AppMethodBeat.o(43300);
        return contentValues;
    }
}
