package com.tencent.mm.plugin.sns.data;

import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e {
    public int DDA = -1;
    public int DDB = 0;
    public boolean DDC = false;
    public int DDD = -1;
    public boolean DDE = false;
    public int DDF = -1;
    public int DDG = 0;
    public int DDt = -1;
    public int DDu = -1;
    public boolean DDv = false;
    public int DDw = -1;
    public String DDx = "";
    public String DDy = "";
    public String DDz = "";
    public int uUn = 0;

    public final void eZq() {
        this.DDu = -1;
        this.DDD = -1;
        this.DDt = -1;
        this.DDx = "";
        this.DDy = "";
        this.DDz = "";
        this.DDC = false;
        this.DDv = false;
        this.DDE = false;
        this.DDF = -1;
        this.DDw = -1;
        this.DDA = -1;
        this.DDB = 0;
        this.uUn = 0;
        this.DDG = 0;
    }

    private static boolean Yi(int i2) {
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 15:
            case 18:
            case 26:
            case 28:
            case 29:
            case 34:
            case 36:
            case 37:
            case 38:
            case 39:
            case 42:
            case 43:
                return true;
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 27:
            case 30:
            case 31:
            case 32:
            case 33:
            case 35:
            case 40:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
            default:
                return false;
        }
    }

    public final boolean eZr() {
        AppMethodBeat.i(95065);
        if (this.DDA == 2) {
            AppMethodBeat.o(95065);
            return true;
        } else if (this.DDu == -1) {
            AppMethodBeat.o(95065);
            return true;
        } else if (this.DDA != this.DDw) {
            AppMethodBeat.o(95065);
            return true;
        } else if (Yi(this.DDA)) {
            AppMethodBeat.o(95065);
            return true;
        } else if (Yi(this.DDw)) {
            AppMethodBeat.o(95065);
            return true;
        } else if (this.DDB > 1 || this.uUn > 1) {
            AppMethodBeat.o(95065);
            return true;
        } else if (this.DDz != null && !this.DDz.equals("")) {
            AppMethodBeat.o(95065);
            return true;
        } else if (this.DDx != null && !this.DDx.equals("")) {
            AppMethodBeat.o(95065);
            return true;
        } else if (this.DDt != this.DDu) {
            AppMethodBeat.o(95065);
            return true;
        } else {
            AppMethodBeat.o(95065);
            return false;
        }
    }

    public final boolean eZs() {
        AppMethodBeat.i(95066);
        if (this.DDD == -1) {
            AppMethodBeat.o(95066);
            return true;
        } else if (this.DDw != this.DDF) {
            AppMethodBeat.o(95066);
            return true;
        } else if (Yi(this.DDF)) {
            AppMethodBeat.o(95066);
            return true;
        } else if (this.DDG > 1) {
            AppMethodBeat.o(95066);
            return true;
        } else if (this.DDy != null && !this.DDy.equals("")) {
            AppMethodBeat.o(95066);
            return true;
        } else if (this.DDu != this.DDD) {
            AppMethodBeat.o(95066);
            return true;
        } else {
            AppMethodBeat.o(95066);
            return false;
        }
    }
}
