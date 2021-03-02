package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.a.b;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.vfs.o;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public interface q extends b {

    public interface a {
        long bxm();

        String getFileName();

        long lastModified();
    }

    o VV(String str);

    boolean VW(String str);

    m VX(String str);

    o VY(String str);

    boolean VZ(String str);

    boolean Vi(String str);

    m Vj(String str);

    m Vl(String str);

    o Wa(String str);

    boolean Wb(String str);

    InputStream Wc(String str);

    m a(i<String> iVar);

    m a(o oVar, String str, i<String> iVar);

    m a(o oVar, String str, boolean z, i<String> iVar);

    m a(String str, long j2, long j3, i<ByteBuffer> iVar);

    m a(String str, i<List<k>> iVar);

    m a(String str, FileStructStat fileStructStat);

    m a(String str, o oVar);

    m a(String str, o oVar, boolean z);

    m a(String str, InputStream inputStream, boolean z);

    o ag(String str, boolean z);

    m ai(String str, boolean z);

    m aj(String str, boolean z);

    m b(String str, i<ByteBuffer> iVar);

    List<? extends a> bxs();

    m h(String str, List<x> list);

    void initialize();

    void release();
}
