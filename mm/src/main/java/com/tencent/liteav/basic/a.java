package com.tencent.liteav.basic;

import com.tencent.liteav.TXLiteAVExternalDecoderFactoryInterface;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static TXLiteAVExternalDecoderFactoryInterface f197a;

    public static synchronized boolean a() {
        boolean z;
        synchronized (a.class) {
            if (f197a != null) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public static synchronized void a(TXLiteAVExternalDecoderFactoryInterface tXLiteAVExternalDecoderFactoryInterface) {
        synchronized (a.class) {
            f197a = tXLiteAVExternalDecoderFactoryInterface;
        }
    }

    public static synchronized TXLiteAVExternalDecoderFactoryInterface b() {
        TXLiteAVExternalDecoderFactoryInterface tXLiteAVExternalDecoderFactoryInterface;
        synchronized (a.class) {
            tXLiteAVExternalDecoderFactoryInterface = f197a;
        }
        return tXLiteAVExternalDecoderFactoryInterface;
    }
}
