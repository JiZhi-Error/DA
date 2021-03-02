package com.tencent.mm.storage;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.storage.IStorageEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public interface bw extends IStorageEx {

    public interface a {
        void a(az azVar, bw bwVar);
    }

    public interface b {
        String a(int i2, String str, String str2, int i3, Context context);

        void a(ca caVar, PString pString, PString pString2, PInt pInt, boolean z);
    }

    int JP(String str);

    boolean Tf(String str);

    b Xh();

    int a(az azVar, String str);

    int a(az azVar, String str, boolean z);

    Cursor a(String str, List<String> list, String str2, boolean z);

    Cursor a(ArrayList<String> arrayList, String str, List<String> list, String str2);

    com.tencent.mm.vending.b.b a(g gVar);

    void a(f fVar);

    void a(az azVar, int i2, int i3);

    void a(a aVar);

    void a(b bVar);

    boolean a(String str, int i2, boolean z, int i3);

    void aY(ca caVar);

    boolean ayk(String str);

    Cursor b(String str, List<String> list, String str2, boolean z, String str3);

    void b(i iVar, i.c cVar);

    void b(g gVar);

    void b(a aVar);

    void bI(LinkedList<String> linkedList);

    void bjW(String str);

    boolean bjX(String str);

    az bjY(String str);

    void bjZ(String str);

    boolean bka(String str);

    boolean bkb(String str);

    boolean bkc(String str);

    boolean bkd(String str);

    boolean bke(String str);

    boolean bkf(String str);

    boolean bkg(String str);

    Cursor bkh(String str);

    Cursor bki(String str);

    Cursor bkj(String str);

    int bkk(String str);

    String bkl(String str);

    az bkm(String str);

    int bkn(String str);

    void bko(String str);

    void bkp(String str);

    int bkq(String str);

    Cursor c(String str, List<String> list, String str2);

    void c(a aVar);

    void c(String[] strArr, String str);

    void d(a aVar);

    String dk(int i2, String str);

    long e(az azVar);

    Cursor f(List<String> list, int i2, int i3);

    boolean g(az azVar);

    Cursor gCA();

    az gCB();

    Cursor gCC();

    boolean gCs();

    HashMap<String, Long> gCt();

    void gCu();

    List<String> gCv();

    List<String> gCw();

    Cursor gCx();

    int gCy();

    String gCz();

    boolean h(az azVar);

    Cursor mT(String str, String str2);
}
