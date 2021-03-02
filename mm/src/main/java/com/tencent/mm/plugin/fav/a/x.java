package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public interface x extends IStorage {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(g.info, "FavItemInfo")};

    long A(long j2, int i2);

    void A(g gVar);

    LinkedList<Integer> B(long j2, int i2);

    long C(long j2, int i2);

    g DY(long j2);

    g DZ(long j2);

    int HX(int i2);

    ArrayList<g> a(List<Long> list, List<g> list2, Set<Integer> set, w wVar);

    List<g> a(int i2, Set<Integer> set, w wVar);

    boolean a(g gVar, String... strArr);

    void af(int i2, long j2);

    g asb(String str);

    List<g> b(long j2, int i2, Set<Integer> set, w wVar);

    boolean b(g gVar, String... strArr);

    ISQLiteDatabase cUP();

    int cUQ();

    List<g> cUR();

    List<g> cUS();

    List<g> cUT();

    List<g> cUU();

    List<g> cUV();

    List<g> cUW();

    List<Long> cUX();

    void cUY();

    List<Long> cUZ();

    List<g> fT(int i2, int i3);

    int getCount();

    boolean z(long j2, int i2);

    boolean z(g gVar);
}
