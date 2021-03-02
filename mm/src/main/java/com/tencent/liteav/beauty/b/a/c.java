package com.tencent.liteav.beauty.b.a;

import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c extends h {
    @Override // com.tencent.liteav.basic.c.h
    public boolean a() {
        AppMethodBeat.i(15001);
        NativeLoad.getInstance();
        this.f300a = NativeLoad.nativeLoadGLProgram(6);
        if (this.f300a == 0 || !b()) {
            this.f306g = false;
        } else {
            this.f306g = true;
        }
        c();
        boolean z = this.f306g;
        AppMethodBeat.o(15001);
        return z;
    }
}
