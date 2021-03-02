package com.tencent.magicbrush;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.fs.IMBFileSystem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.aa;
import kotlin.g.b.u;
import kotlin.l;
import kotlin.l.b;
import kotlin.l.d;
import kotlin.l.h;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16})
public final /* synthetic */ class x extends u {
    public static final h cMy = new x();

    static {
        AppMethodBeat.i(140160);
        AppMethodBeat.o(140160);
    }

    x() {
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        AppMethodBeat.i(140161);
        b bp = aa.bp(MBRuntime.MBParams.class);
        AppMethodBeat.o(140161);
        return bp;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return "file_system_";
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return "getFile_system_()Lcom/tencent/magicbrush/handler/fs/IMBFileSystem;";
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        return ((MBRuntime.MBParams) obj).file_system_;
    }

    @Override // kotlin.l.h
    public final void set(Object obj, Object obj2) {
        ((MBRuntime.MBParams) obj).file_system_ = (IMBFileSystem) obj2;
    }
}
