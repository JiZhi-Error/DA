package com.tencent.map.tools.internal;

public interface d {
    Object callSheetMth(Object obj, String str, Class[] clsArr, Object[] objArr);

    Object callSheetMth(Object obj, String str, Object... objArr);

    Object callSheetStaMth(Class cls, String str, Class[] clsArr, Object[] objArr);

    Class findSheet(String str);

    <T> Class<? extends T> findSheet(String str, Class<T> cls);

    ClassLoader getSheetLoader();

    int loadSheetGroups();

    <T> T newSheetIns(Class<T> cls, Object... objArr);

    Object newSheetIns(String str);
}
