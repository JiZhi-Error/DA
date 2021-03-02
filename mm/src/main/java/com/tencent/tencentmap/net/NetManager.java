package com.tencent.tencentmap.net;

import android.content.Context;
import com.tencent.map.tools.net.NetAdapter;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.http.HttpCanceler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class NetManager {
    private static NetManager sInstance;

    public static synchronized NetManager getInstance() {
        NetManager netManager;
        synchronized (NetManager.class) {
            AppMethodBeat.i(181091);
            if (sInstance == null) {
                sInstance = new NetManager();
            }
            netManager = sInstance;
            AppMethodBeat.o(181091);
        }
        return netManager;
    }

    private NetManager() {
    }

    public void setAdapter(Context context, NetAdapter netAdapter) {
        AppMethodBeat.i(181092);
        com.tencent.map.tools.net.NetManager.getInstance().setAdapter(context, netAdapter);
        AppMethodBeat.o(181092);
    }

    public NetResponse doGet(String str) {
        AppMethodBeat.i(181093);
        NetResponse doGet = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).doGet();
        if (doGet != null) {
            NetResponse netResponse = new NetResponse(doGet);
            AppMethodBeat.o(181093);
            return netResponse;
        }
        AppMethodBeat.o(181093);
        return null;
    }

    public NetResponse doGet(String str, String str2) {
        AppMethodBeat.i(181094);
        NetResponse doGet = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).doGet();
        if (doGet != null) {
            NetResponse netResponse = new NetResponse(doGet);
            AppMethodBeat.o(181094);
            return netResponse;
        }
        AppMethodBeat.o(181094);
        return null;
    }

    public NetResponse doGet(String str, String str2, int i2) {
        AppMethodBeat.i(181095);
        NetResponse doGet = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).retryNum(i2).doGet();
        if (doGet != null) {
            NetResponse netResponse = new NetResponse(doGet);
            AppMethodBeat.o(181095);
            return netResponse;
        }
        AppMethodBeat.o(181095);
        return null;
    }

    public NetResponse doGet(String str, String str2, int i2, int i3, HashMap<String, String> hashMap) {
        AppMethodBeat.i(181096);
        NetResponse doGet = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).retryNum(i2).timeOut(i3).header(hashMap).doGet();
        if (doGet != null) {
            NetResponse netResponse = new NetResponse(doGet);
            AppMethodBeat.o(181096);
            return netResponse;
        }
        AppMethodBeat.o(181096);
        return null;
    }

    public NetResponse doGet(String str, int i2, HttpCanceler httpCanceler) {
        AppMethodBeat.i(181097);
        NetResponse doGet = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).retryNum(i2).canceler(httpCanceler).doGet();
        if (doGet != null) {
            NetResponse netResponse = new NetResponse(doGet);
            AppMethodBeat.o(181097);
            return netResponse;
        }
        AppMethodBeat.o(181097);
        return null;
    }

    public NetResponse doGet(String str, String str2, int i2, HttpCanceler httpCanceler) {
        AppMethodBeat.i(181098);
        NetResponse doGet = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).retryNum(i2).canceler(httpCanceler).doGet();
        if (doGet != null) {
            NetResponse netResponse = new NetResponse(doGet);
            AppMethodBeat.o(181098);
            return netResponse;
        }
        AppMethodBeat.o(181098);
        return null;
    }

    public NetResponse doGet(String str, String str2, int i2, HashMap<String, String> hashMap, HttpCanceler httpCanceler) {
        AppMethodBeat.i(181099);
        NetResponse doGet = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).retryNum(i2).header(hashMap).canceler(httpCanceler).doGet();
        if (doGet != null) {
            NetResponse netResponse = new NetResponse(doGet);
            AppMethodBeat.o(181099);
            return netResponse;
        }
        AppMethodBeat.o(181099);
        return null;
    }

    public NetResponse doGet(String str, String str2, int i2, int i3, HashMap<String, String> hashMap, HttpCanceler httpCanceler) {
        AppMethodBeat.i(181100);
        NetResponse doGet = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).timeOut(i3).retryNum(i2).header(hashMap).canceler(httpCanceler).doGet();
        if (doGet != null) {
            NetResponse netResponse = new NetResponse(doGet);
            AppMethodBeat.o(181100);
            return netResponse;
        }
        AppMethodBeat.o(181100);
        return null;
    }

    public NetResponse doPost(String str, byte[] bArr) {
        AppMethodBeat.i(181101);
        NetResponse doPost = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).postData(bArr).doPost();
        if (doPost != null) {
            NetResponse netResponse = new NetResponse(doPost);
            AppMethodBeat.o(181101);
            return netResponse;
        }
        AppMethodBeat.o(181101);
        return null;
    }

    public NetResponse doPost(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(181102);
        NetResponse doPost = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).postData(bArr).doPost();
        if (doPost != null) {
            NetResponse netResponse = new NetResponse(doPost);
            AppMethodBeat.o(181102);
            return netResponse;
        }
        AppMethodBeat.o(181102);
        return null;
    }

    public NetResponse doPost(String str, String str2, byte[] bArr, int i2) {
        AppMethodBeat.i(181103);
        NetResponse doPost = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).retryNum(i2).postData(bArr).doPost();
        if (doPost != null) {
            NetResponse netResponse = new NetResponse(doPost);
            AppMethodBeat.o(181103);
            return netResponse;
        }
        AppMethodBeat.o(181103);
        return null;
    }

    public NetResponse doPost(String str, String str2, byte[] bArr, int i2, int i3, HashMap<String, String> hashMap) {
        AppMethodBeat.i(181104);
        NetResponse doPost = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).timeOut(i3).retryNum(i2).header(hashMap).postData(bArr).doPost();
        if (doPost != null) {
            NetResponse netResponse = new NetResponse(doPost);
            AppMethodBeat.o(181104);
            return netResponse;
        }
        AppMethodBeat.o(181104);
        return null;
    }

    public NetResponse doPost(String str, byte[] bArr, int i2, HttpCanceler httpCanceler) {
        AppMethodBeat.i(181105);
        NetResponse doPost = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).retryNum(i2).canceler(httpCanceler).postData(bArr).doPost();
        if (doPost != null) {
            NetResponse netResponse = new NetResponse(doPost);
            AppMethodBeat.o(181105);
            return netResponse;
        }
        AppMethodBeat.o(181105);
        return null;
    }

    public NetResponse doPost(String str, String str2, byte[] bArr, int i2, HttpCanceler httpCanceler) {
        AppMethodBeat.i(181106);
        NetResponse doPost = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).retryNum(i2).canceler(httpCanceler).postData(bArr).doPost();
        if (doPost != null) {
            NetResponse netResponse = new NetResponse(doPost);
            AppMethodBeat.o(181106);
            return netResponse;
        }
        AppMethodBeat.o(181106);
        return null;
    }

    public NetResponse doPost(String str, String str2, byte[] bArr, int i2, HashMap<String, String> hashMap, HttpCanceler httpCanceler) {
        AppMethodBeat.i(181107);
        NetResponse doPost = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).retryNum(i2).header(hashMap).canceler(httpCanceler).postData(bArr).doPost();
        if (doPost != null) {
            NetResponse netResponse = new NetResponse(doPost);
            AppMethodBeat.o(181107);
            return netResponse;
        }
        AppMethodBeat.o(181107);
        return null;
    }

    public NetResponse doPost(String str, String str2, byte[] bArr, int i2, HashMap<String, String> hashMap, HttpCanceler httpCanceler, int i3) {
        AppMethodBeat.i(181108);
        NetResponse doPost = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).timeOut(i3).retryNum(i2).header(hashMap).canceler(httpCanceler).postData(bArr).doPost();
        if (doPost != null) {
            NetResponse netResponse = new NetResponse(doPost);
            AppMethodBeat.o(181108);
            return netResponse;
        }
        AppMethodBeat.o(181108);
        return null;
    }

    public NetResponse doPost(String str, String str2, byte[] bArr, int i2, HashMap<String, String> hashMap, int i3) {
        AppMethodBeat.i(181109);
        NetResponse doPost = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).timeOut(i3).retryNum(i2).header(hashMap).postData(bArr).doPost();
        if (doPost != null) {
            NetResponse netResponse = new NetResponse(doPost);
            AppMethodBeat.o(181109);
            return netResponse;
        }
        AppMethodBeat.o(181109);
        return null;
    }

    public NetResponse doPostNoBuffer(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(181110);
        NetResponse doPostNoBuffer = com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).userAgent(str2).postData(bArr).doPostNoBuffer();
        if (doPostNoBuffer != null) {
            NetResponse netResponse = new NetResponse(doPostNoBuffer);
            AppMethodBeat.o(181110);
            return netResponse;
        }
        AppMethodBeat.o(181110);
        return null;
    }

    public void doRangePost(String str, byte[] bArr, String str2, String str3, String str4, String str5, HttpCanceler httpCanceler) {
        AppMethodBeat.i(181111);
        com.tencent.map.tools.net.NetManager.getInstance().builder().url(str).token(str2).postData(bArr).nonce(str3).timestamp(str4).startTag(str5).canceler(httpCanceler).doRangePost();
        AppMethodBeat.o(181111);
    }
}
