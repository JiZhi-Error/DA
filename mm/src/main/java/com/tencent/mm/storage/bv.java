package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.sdk.storage.IStorageEx;
import java.util.List;

public interface bv extends IStorageEx {

    public interface a {
        as Kn(String str);

        void a(bv bvVar, as asVar);

        int b(as asVar, boolean z);
    }

    int B(String str, byte[] bArr);

    as Kn(String str);

    as Nh(long j2);

    Cursor a(String str, String str2, List<String> list, List<String> list2, boolean z, boolean z2);

    Cursor a(List<String> list, String str, List<String> list2);

    Cursor a(String[] strArr, String str, String str2, List<String> list, List<String> list2);

    Cursor a(String[] strArr, String str, List<String> list);

    void a(a aVar);

    int aNa(String str);

    String aZD();

    void am(as asVar);

    boolean an(as asVar);

    boolean ao(as asVar);

    boolean ap(as asVar);

    int aq(as asVar);

    void ayf(String str);

    Cursor b(String str, String str2, List<String> list, List<String> list2, boolean z, boolean z2);

    Cursor b(List<String> list, String str, List<String> list2);

    void b(a aVar);

    int[] b(String str, String str2, String[] strArr, List<String> list);

    int[] b(String[] strArr, String str, String str2, String str3, List<String> list);

    as bjF(String str);

    boolean bjG(String str);

    as bjH(String str);

    Cursor bjI(String str);

    as bjJ(String str);

    as bjK(String str);

    as bjL(String str);

    long bjM(String str);

    boolean bjN(String str);

    boolean bjO(String str);

    byte[] bjP(String str);

    int bjQ(String str);

    String bjR(String str);

    int bjS(String str);

    String bjT(String str);

    int c(String str, as asVar);

    int c(String[] strArr, String... strArr2);

    Cursor c(String str, String str2, List<String> list);

    Cursor c(List<String> list, String str, List<String> list2);

    int[] c(String str, String str2, String[] strArr, List<String> list);

    int[] c(String[] strArr, String str, String str2, String str3, List<String> list);

    int ce(String str, long j2);

    int d(String str, as asVar);

    int d(String[] strArr, String... strArr2);

    Cursor d(String str, String str2, List<String> list);

    Cursor d(String[] strArr, String str, String str2, String str3, List<String> list);

    void d(as asVar, boolean z);

    Cursor e(String str, String str2, List<String> list);

    void e(String str, as asVar);

    String f(String str, String str2, List<String> list);

    List<String> gBY();

    List<String> gBZ();

    Cursor gCa();

    Cursor gCb();

    Cursor gCc();

    Cursor gCd();

    int gCe();

    int gCn();

    Cursor gCo();

    Cursor gCp();

    Cursor gCq();

    Cursor iJ(List<String> list);

    Cursor iK(List<String> list);

    Cursor iL(List<String> list);

    Cursor iM(List<String> list);

    Cursor iP(List<String> list);

    Cursor iQ(List<String> list);

    Cursor iR(List<String> list);

    Cursor iS(List<String> list);

    Cursor iT(List<String> list);

    List<String> iU(List<String> list);

    int[] iV(List<String> list);

    int[] iW(List<String> list);

    Cursor mR(String str, String str2);

    int mS(String str, String str2);

    Cursor x(List<String> list, boolean z);
}
