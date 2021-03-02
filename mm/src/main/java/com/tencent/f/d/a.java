package com.tencent.f.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;

public interface a {
    void dispatchMessage(Message message);

    void dump(Printer printer, String str);

    boolean executeOrSendMessage(Message message);

    Looper getLooper();

    String getMessageName(Message message);

    Handler getSelf();

    com.tencent.f.j.a getSerial();

    String getSerialTag();

    boolean hasMessages(int i2);

    boolean hasMessages(int i2, Object obj);

    boolean isQuit();

    Message obtainMessage();

    Message obtainMessage(int i2);

    Message obtainMessage(int i2, int i3, int i4);

    Message obtainMessage(int i2, int i3, int i4, Object obj);

    Message obtainMessage(int i2, Object obj);

    boolean post(Runnable runnable);

    boolean postAtFrontOfQueue(Runnable runnable);

    boolean postAtTime(Runnable runnable, long j2);

    boolean postAtTime(Runnable runnable, Object obj, long j2);

    boolean postDelayed(Runnable runnable, long j2);

    boolean postDelayed(Runnable runnable, Object obj, long j2);

    boolean quit();

    void removeCallbacks(Runnable runnable);

    void removeCallbacks(Runnable runnable, Object obj);

    void removeCallbacksAndMessages(Object obj);

    void removeMessages(int i2);

    void removeMessages(int i2, Object obj);

    boolean sendEmptyMessage(int i2);

    boolean sendEmptyMessageAtTime(int i2, long j2);

    boolean sendEmptyMessageDelayed(int i2, long j2);

    boolean sendMessage(Message message);

    boolean sendMessageAtFrontOfQueue(Message message);

    boolean sendMessageAtTime(Message message, long j2);

    boolean sendMessageDelayed(Message message, long j2);
}
