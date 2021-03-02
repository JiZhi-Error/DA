package com.tencent.smtt.sandbox;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ContentChildProcessService extends ChildProcessService {
    public ContentChildProcessService() {
        super(new SandboxContentChildProcessServiceDelegate());
        AppMethodBeat.i(53815);
        AppMethodBeat.o(53815);
    }
}
