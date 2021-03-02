package com.tencent.tbs.one.impl.e;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.f;
import java.io.File;

public final class a extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final File f2628a;

    public a(File file) {
        this.f2628a = file;
    }

    public final void run() {
        AppMethodBeat.i(173978);
        super.run();
        f.a("Running cleanup thread", new Object[0]);
        c.a(com.tencent.tbs.one.impl.common.f.a(this.f2628a, Process.myPid()));
        File[] listFiles = com.tencent.tbs.one.impl.common.f.a(this.f2628a).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                f.d(file);
            }
        }
        AppMethodBeat.o(173978);
    }
}
