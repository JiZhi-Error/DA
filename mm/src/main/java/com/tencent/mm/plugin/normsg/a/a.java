package com.tencent.mm.plugin.normsg.a;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.event.IEvent;

public interface a {
    boolean K(byte[] bArr, int i2, int i3);

    byte[] TJ(int i2);

    String TK(int i2);

    void TL(int i2);

    byte[] TM(int i2);

    void a(View view, Class<? extends IEvent> cls);

    void a(b bVar);

    void a(String str, MotionEvent motionEvent);

    boolean a(int i2, byte[] bArr, int i3, int i4, PByteArray pByteArray);

    boolean a(int i2, byte[] bArr, int i3, int i4, PInt pInt, PInt pInt2, PByteArray pByteArray);

    void aA(String str, String str2, String str3);

    String aIJ(String str);

    void aIL(String str);

    void aIM(String str);

    void aIN(String str);

    boolean aIO(String str);

    byte[] aIP(String str);

    void aIQ(String str);

    boolean aIR(String str);

    byte[] aIS(String str);

    String aIT(String str);

    String[] aIU(String str);

    String aoK();

    void au(int i2, int i3, int i4);

    boolean c(Object obj, Class cls);

    boolean dH(Object obj);

    void eW(String str, int i2);

    String exG();

    boolean exH();

    boolean exI();

    byte[] exJ();

    byte[] exK();

    boolean exL();

    byte[] exM();

    boolean exN();

    String exO();

    String exP();

    String exQ();

    com.tencent.mm.normsg.a exR();

    com.tencent.mm.normsgext.a exS();

    void exT();

    void jf(String str, String str2);

    String sv(boolean z);

    void sw(boolean z);
}
