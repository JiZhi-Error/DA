package com.tencent.map.tools.net;

import android.content.Context;
import com.tencent.map.tools.net.http.HttpCanceler;
import java.util.HashMap;

public interface NetAdapter {
    boolean cancel();

    NetResponse doGet(String str, String str2, int i2, int i3, HashMap<String, String> hashMap, HttpCanceler httpCanceler);

    NetResponse doPost(String str, String str2, byte[] bArr, int i2, int i3, HashMap<String, String> hashMap, HttpCanceler httpCanceler);

    NetResponse doPostNoBuffer(String str, String str2, byte[] bArr);

    void doRangePost(String str, byte[] bArr, String str2, String str3, String str4, String str5, HttpCanceler httpCanceler);

    void initNet(Context context);
}
