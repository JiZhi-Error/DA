package com.tencent.mm.plugin.appbrand.appcache.pkg;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.vfs.o;
import java.io.Closeable;
import java.nio.channels.FileChannel;
import java.util.Map;

public interface a extends Closeable {
    Map<String, WxaPkg.Info> a(FileChannel fileChannel, o oVar);

    boolean a(FileChannel fileChannel);

    boolean b(WxaPkg.Info info);

    int bwF();

    int bwG();

    int getVersion();
}
