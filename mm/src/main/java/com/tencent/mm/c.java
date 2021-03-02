package com.tencent.mm;

import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.FieldPacker;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.Script;
import android.renderscript.ScriptC;
import android.renderscript.Type;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c extends ScriptC {
    private Allocation dgA;
    private Element dgm;
    private Element dgn;
    private Element dgo;
    private Element dgp;
    private FieldPacker dgq;
    private Allocation dgr;
    private int dgs;
    private int dgt;
    private long dgu;
    private long dgv;
    private long dgw;
    private long dgx;
    private Allocation dgy;
    private Allocation dgz;

    public c(RenderScript renderScript) {
        super(renderScript, "imagerenderscriptutil", a.Uj(), a.Uk());
        AppMethodBeat.i(93336);
        this.dgm = Element.ALLOCATION(renderScript);
        this.dgn = Element.I32(renderScript);
        this.dgo = Element.U32(renderScript);
        this.dgp = Element.U8_4(renderScript);
        AppMethodBeat.o(93336);
    }

    public final synchronized void a(Allocation allocation) {
        AppMethodBeat.i(93337);
        setVar(0, allocation);
        this.dgr = allocation;
        AppMethodBeat.o(93337);
    }

    public final synchronized void iA(int i2) {
        AppMethodBeat.i(93338);
        setVar(1, i2);
        this.dgs = i2;
        AppMethodBeat.o(93338);
    }

    public final synchronized void iB(int i2) {
        AppMethodBeat.i(93339);
        setVar(2, i2);
        this.dgt = i2;
        AppMethodBeat.o(93339);
    }

    public final synchronized void Up() {
        AppMethodBeat.i(93340);
        if (this.dgq != null) {
            this.dgq.reset();
        } else {
            this.dgq = new FieldPacker(4);
        }
        this.dgq.addU32(0);
        setVar(3, this.dgq);
        this.dgu = 0;
        AppMethodBeat.o(93340);
    }

    public final synchronized void bl(long j2) {
        AppMethodBeat.i(93341);
        if (this.dgq != null) {
            this.dgq.reset();
        } else {
            this.dgq = new FieldPacker(4);
        }
        this.dgq.addU32(j2);
        setVar(4, this.dgq);
        this.dgv = j2;
        AppMethodBeat.o(93341);
    }

    public final synchronized void bm(long j2) {
        AppMethodBeat.i(93342);
        if (this.dgq != null) {
            this.dgq.reset();
        } else {
            this.dgq = new FieldPacker(4);
        }
        this.dgq.addU32(j2);
        setVar(5, this.dgq);
        this.dgw = j2;
        AppMethodBeat.o(93342);
    }

    public final synchronized void bn(long j2) {
        AppMethodBeat.i(93343);
        if (this.dgq != null) {
            this.dgq.reset();
        } else {
            this.dgq = new FieldPacker(4);
        }
        this.dgq.addU32(j2);
        setVar(6, this.dgq);
        this.dgx = j2;
        AppMethodBeat.o(93343);
    }

    public final synchronized void b(Allocation allocation) {
        AppMethodBeat.i(93344);
        setVar(8, allocation);
        this.dgy = allocation;
        AppMethodBeat.o(93344);
    }

    public final synchronized void c(Allocation allocation) {
        AppMethodBeat.i(93345);
        setVar(9, allocation);
        this.dgz = allocation;
        AppMethodBeat.o(93345);
    }

    public final synchronized void d(Allocation allocation) {
        AppMethodBeat.i(93346);
        setVar(10, allocation);
        this.dgA = allocation;
        AppMethodBeat.o(93346);
    }

    public final void a(Allocation allocation, Allocation allocation2) {
        AppMethodBeat.i(93347);
        if (!allocation.getType().getElement().isCompatible(this.dgp)) {
            RSRuntimeException rSRuntimeException = new RSRuntimeException("Type mismatch with U8_4!");
            AppMethodBeat.o(93347);
            throw rSRuntimeException;
        } else if (!allocation2.getType().getElement().isCompatible(this.dgp)) {
            RSRuntimeException rSRuntimeException2 = new RSRuntimeException("Type mismatch with U8_4!");
            AppMethodBeat.o(93347);
            throw rSRuntimeException2;
        } else {
            Type type = allocation.getType();
            Type type2 = allocation2.getType();
            if (type.getCount() == type2.getCount() && type.getX() == type2.getX() && type.getY() == type2.getY() && type.getZ() == type2.getZ() && type.hasFaces() == type2.hasFaces() && type.hasMipmaps() == type2.hasMipmaps()) {
                forEach(1, allocation, allocation2, (FieldPacker) null, (Script.LaunchOptions) null);
                AppMethodBeat.o(93347);
                return;
            }
            RSRuntimeException rSRuntimeException3 = new RSRuntimeException("Dimension mismatch between parameters ain and aout!");
            AppMethodBeat.o(93347);
            throw rSRuntimeException3;
        }
    }

    public final void b(Allocation allocation, Allocation allocation2) {
        AppMethodBeat.i(93348);
        if (!allocation.getType().getElement().isCompatible(this.dgp)) {
            RSRuntimeException rSRuntimeException = new RSRuntimeException("Type mismatch with U8_4!");
            AppMethodBeat.o(93348);
            throw rSRuntimeException;
        } else if (!allocation2.getType().getElement().isCompatible(this.dgp)) {
            RSRuntimeException rSRuntimeException2 = new RSRuntimeException("Type mismatch with U8_4!");
            AppMethodBeat.o(93348);
            throw rSRuntimeException2;
        } else {
            Type type = allocation.getType();
            Type type2 = allocation2.getType();
            if (type.getCount() == type2.getCount() && type.getX() == type2.getX() && type.getY() == type2.getY() && type.getZ() == type2.getZ() && type.hasFaces() == type2.hasFaces() && type.hasMipmaps() == type2.hasMipmaps()) {
                forEach(3, allocation, allocation2, (FieldPacker) null, (Script.LaunchOptions) null);
                AppMethodBeat.o(93348);
                return;
            }
            RSRuntimeException rSRuntimeException3 = new RSRuntimeException("Dimension mismatch between parameters ain and aout!");
            AppMethodBeat.o(93348);
            throw rSRuntimeException3;
        }
    }

    public final void c(Allocation allocation, Allocation allocation2) {
        AppMethodBeat.i(93349);
        if (!allocation.getType().getElement().isCompatible(this.dgp)) {
            RSRuntimeException rSRuntimeException = new RSRuntimeException("Type mismatch with U8_4!");
            AppMethodBeat.o(93349);
            throw rSRuntimeException;
        } else if (!allocation2.getType().getElement().isCompatible(this.dgp)) {
            RSRuntimeException rSRuntimeException2 = new RSRuntimeException("Type mismatch with U8_4!");
            AppMethodBeat.o(93349);
            throw rSRuntimeException2;
        } else {
            Type type = allocation.getType();
            Type type2 = allocation2.getType();
            if (type.getCount() == type2.getCount() && type.getX() == type2.getX() && type.getY() == type2.getY() && type.getZ() == type2.getZ() && type.hasFaces() == type2.hasFaces() && type.hasMipmaps() == type2.hasMipmaps()) {
                forEach(4, allocation, allocation2, (FieldPacker) null, (Script.LaunchOptions) null);
                AppMethodBeat.o(93349);
                return;
            }
            RSRuntimeException rSRuntimeException3 = new RSRuntimeException("Dimension mismatch between parameters ain and aout!");
            AppMethodBeat.o(93349);
            throw rSRuntimeException3;
        }
    }

    public final void d(Allocation allocation, Allocation allocation2) {
        AppMethodBeat.i(93350);
        if (!allocation.getType().getElement().isCompatible(this.dgp)) {
            RSRuntimeException rSRuntimeException = new RSRuntimeException("Type mismatch with U8_4!");
            AppMethodBeat.o(93350);
            throw rSRuntimeException;
        } else if (!allocation2.getType().getElement().isCompatible(this.dgp)) {
            RSRuntimeException rSRuntimeException2 = new RSRuntimeException("Type mismatch with U8_4!");
            AppMethodBeat.o(93350);
            throw rSRuntimeException2;
        } else {
            Type type = allocation.getType();
            Type type2 = allocation2.getType();
            if (type.getCount() == type2.getCount() && type.getX() == type2.getX() && type.getY() == type2.getY() && type.getZ() == type2.getZ() && type.hasFaces() == type2.hasFaces() && type.hasMipmaps() == type2.hasMipmaps()) {
                forEach(5, allocation, allocation2, (FieldPacker) null, (Script.LaunchOptions) null);
                AppMethodBeat.o(93350);
                return;
            }
            RSRuntimeException rSRuntimeException3 = new RSRuntimeException("Dimension mismatch between parameters ain and aout!");
            AppMethodBeat.o(93350);
            throw rSRuntimeException3;
        }
    }

    public final void e(Allocation allocation) {
        AppMethodBeat.i(93351);
        if (!allocation.getType().getElement().isCompatible(this.dgp)) {
            RSRuntimeException rSRuntimeException = new RSRuntimeException("Type mismatch with U8_4!");
            AppMethodBeat.o(93351);
            throw rSRuntimeException;
        }
        forEach(7, (Allocation) null, allocation, (FieldPacker) null, (Script.LaunchOptions) null);
        AppMethodBeat.o(93351);
    }
}
