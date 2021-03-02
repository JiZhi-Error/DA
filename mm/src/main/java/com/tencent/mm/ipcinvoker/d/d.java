package com.tencent.mm.ipcinvoker.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import junit.framework.Assert;

public class d {
    public String event;
    public f hnu;
    private String process;

    public <T extends b> d(String str, Class<T> cls) {
        AppMethodBeat.i(158789);
        Assert.assertNotNull(str);
        Assert.assertNotNull(cls);
        this.process = str;
        this.event = cls.getName();
        this.hnu = new f(str);
        AppMethodBeat.o(158789);
    }
}
