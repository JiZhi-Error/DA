package com.tencent.mm.booter.notification.queue;

import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URLDecoder;
import java.net.URLEncoder;

public final class c {
    public static String a(Serializable serializable) {
        AppMethodBeat.i(20034);
        long currentTimeMillis = System.currentTimeMillis();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(serializable);
        String encode = URLEncoder.encode(byteArrayOutputStream.toString(KindaConfigCacheStg.SAVE_CHARSET), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        objectOutputStream.close();
        byteArrayOutputStream.close();
        Log.d("MicroMsg.NotificationQueueTool", "serialize consume: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(20034);
        return encode;
    }

    public static Serializable Db(String str) {
        AppMethodBeat.i(20035);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(20035);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(URLDecoder.decode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET).getBytes(KindaConfigCacheStg.SAVE_CHARSET));
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Serializable serializable = (Serializable) objectInputStream.readObject();
        objectInputStream.close();
        byteArrayInputStream.close();
        Log.d("MicroMsg.NotificationQueueTool", "de serialize consume: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(20035);
        return serializable;
    }
}
