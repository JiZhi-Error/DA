package com.tencent.mm.network;

import com.tencent.mm.network.a.b;
import com.tencent.mm.protocal.ab;
import java.util.List;

public interface g {
    void MH(String str);

    void MI(String str);

    void MJ(String str);

    int a(t tVar, n nVar);

    int a(String str, boolean z, List<String> list);

    void a(int i2, String str, int i3, boolean z);

    void a(b bVar);

    void a(j jVar);

    void a(q qVar);

    void a(ab abVar);

    void a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i2, int i3, String str3, String str4);

    boolean aYT();

    e aZh();

    k aZi();

    void aZj();

    void aZk();

    String[] aZl();

    void addHostInfo(String[] strArr, String[] strArr2, int[] iArr);

    void cancel(int i2);

    void d(String str, long j2, String str2);

    void fA(boolean z);

    void fB(boolean z);

    void forceUseV6(boolean z);

    void fy(boolean z);

    void fz(boolean z);

    int getHostByName(String str, List<String> list);

    String[] getIPsString(boolean z);

    String getIspId();

    String getNetworkServerIp();

    void keepSignalling();

    void reportFailIp(String str);

    void reportV6Status(boolean z);

    void reset();

    void setDebugHost(String str);

    void setHostInfo(String[] strArr, String[] strArr2, int[] iArr);

    void setSignallingStrategy(long j2, long j3);

    void stopSignalling();

    void switchProcessActiveState(boolean z);
}
