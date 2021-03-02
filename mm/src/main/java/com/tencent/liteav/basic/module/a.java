package com.tencent.liteav.basic.module;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a {
    private String mID = "";

    public void finalize() {
        AppMethodBeat.i(14414);
        clearID();
        super.finalize();
        AppMethodBeat.o(14414);
    }

    public void setID(String str) {
        AppMethodBeat.i(14415);
        clearID();
        synchronized (this) {
            try {
                if (str.length() != 0) {
                    this.mID = str;
                    TXCStatus.a(this.mID);
                }
            } finally {
                AppMethodBeat.o(14415);
            }
        }
    }

    public void clearID() {
        AppMethodBeat.i(14416);
        synchronized (this) {
            try {
                if (this.mID.length() != 0) {
                    TXCStatus.b(this.mID);
                    this.mID = "";
                }
            } finally {
                AppMethodBeat.o(14416);
            }
        }
    }

    public String getID() {
        return this.mID;
    }

    public boolean setStatusValue(int i2, Object obj) {
        AppMethodBeat.i(14417);
        boolean a2 = TXCStatus.a(this.mID, i2, obj);
        AppMethodBeat.o(14417);
        return a2;
    }

    public boolean setStatusValue(int i2, int i3, Object obj) {
        AppMethodBeat.i(14418);
        boolean a2 = TXCStatus.a(this.mID, i2, i3, obj);
        AppMethodBeat.o(14418);
        return a2;
    }

    public long getLongValue(int i2) {
        AppMethodBeat.i(14419);
        long a2 = TXCStatus.a(this.mID, i2);
        AppMethodBeat.o(14419);
        return a2;
    }

    public String getStringValue(int i2) {
        AppMethodBeat.i(14420);
        String b2 = TXCStatus.b(this.mID, i2);
        AppMethodBeat.o(14420);
        return b2;
    }

    public int getIntValue(int i2) {
        AppMethodBeat.i(14421);
        int c2 = TXCStatus.c(this.mID, i2);
        AppMethodBeat.o(14421);
        return c2;
    }

    public double getDoubleValue(int i2) {
        AppMethodBeat.i(14422);
        double d2 = TXCStatus.d(this.mID, i2);
        AppMethodBeat.o(14422);
        return d2;
    }

    public String getStringValue(int i2, int i3) {
        AppMethodBeat.i(14423);
        String b2 = TXCStatus.b(this.mID, i2, i3);
        AppMethodBeat.o(14423);
        return b2;
    }

    public int getIntValue(int i2, int i3) {
        AppMethodBeat.i(14424);
        int c2 = TXCStatus.c(this.mID, i2, i3);
        AppMethodBeat.o(14424);
        return c2;
    }

    public long getLongValue(int i2, int i3) {
        AppMethodBeat.i(14425);
        long a2 = TXCStatus.a(this.mID, i2, i3);
        AppMethodBeat.o(14425);
        return a2;
    }

    public double getDoubleValue(int i2, int i3) {
        AppMethodBeat.i(14426);
        double d2 = TXCStatus.d(this.mID, i2, i3);
        AppMethodBeat.o(14426);
        return d2;
    }
}
