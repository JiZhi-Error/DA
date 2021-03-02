package com.tencent.mm.plugin.finder.feed.model.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0015\u0010\u0010\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bJ\r\u0010\u0015\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0016J!\u0010\u0017\u001a\u0004\u0018\u0001H\u0018\"\u0004\b\u0001\u0010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a¢\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u0005J \u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001e\"\u0004\b\u0001\u0010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001aJ\u0006\u0010\u001f\u001a\u00020\u0012J\u0006\u0010 \u001a\u00020!J\u0015\u0010\"\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataStore;", "T", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "getDataList", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "setDataList", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;)V", "get", FirebaseAnalytics.b.INDEX, "", "(I)Ljava/lang/Object;", "getDataListJustForAdapter", "getLast", "()Ljava/lang/Object;", "getLastItemOfType", QLog.TAG_REPORTLEVEL_USER, "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "getListInfo", "getListOfType", "", "getSize", "isEmpty", "", "safeGet", "plugin-finder_release"})
public class DataStore<T> {
    private String TAG = ("Finder." + getClass().getSimpleName() + "_@" + hashCode());
    private DataBuffer<T> dataList = new DataBuffer<>(new ArrayList());

    public DataStore() {
        AppMethodBeat.i(166103);
        AppMethodBeat.o(166103);
    }

    public String getTAG() {
        return this.TAG;
    }

    public void setTAG(String str) {
        AppMethodBeat.i(166099);
        p.h(str, "<set-?>");
        this.TAG = str;
        AppMethodBeat.o(166099);
    }

    public final DataBuffer<T> getDataList() {
        return this.dataList;
    }

    public final void setDataList(DataBuffer<T> dataBuffer) {
        AppMethodBeat.i(245000);
        p.h(dataBuffer, "<set-?>");
        this.dataList = dataBuffer;
        AppMethodBeat.o(245000);
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(245001);
        boolean isEmpty = this.dataList.isEmpty();
        AppMethodBeat.o(245001);
        return isEmpty;
    }

    public final int getSize() {
        AppMethodBeat.i(245002);
        int size = this.dataList.size();
        AppMethodBeat.o(245002);
        return size;
    }

    public final T getLast() {
        AppMethodBeat.i(166100);
        T t = (T) j.kv(this.dataList);
        AppMethodBeat.o(166100);
        return t;
    }

    public final T get(int i2) {
        AppMethodBeat.i(166101);
        T t = this.dataList.get(i2);
        AppMethodBeat.o(166101);
        return t;
    }

    public final T safeGet(int i2) {
        AppMethodBeat.i(166102);
        if (i2 < 0 || i2 >= this.dataList.size()) {
            AppMethodBeat.o(166102);
            return null;
        }
        T t = this.dataList.get(i2);
        AppMethodBeat.o(166102);
        return t;
    }

    public final DataBuffer<T> getDataListJustForAdapter() {
        return this.dataList;
    }

    public final String getListInfo() {
        AppMethodBeat.i(245003);
        String str = "DataStore: info count: " + this.dataList.size();
        Log.i(getTAG(), str);
        int i2 = 0;
        for (T t : this.dataList) {
            i2++;
            if (i2 < 0) {
                j.hxH();
            }
            Log.i(getTAG(), "DataStore:index " + i2 + " obj:" + String.valueOf(t));
        }
        AppMethodBeat.o(245003);
        return str;
    }

    public final <E> List<E> getListOfType(Class<E> cls) {
        AppMethodBeat.i(245004);
        p.h(cls, "clazz");
        ArrayList arrayList = new ArrayList();
        for (T t : this.dataList) {
            if (cls.isInstance(t)) {
                arrayList.add(t);
            }
        }
        AppMethodBeat.o(245004);
        return arrayList;
    }

    public final <E> E getLastItemOfType(Class<E> cls) {
        E e2;
        AppMethodBeat.i(245005);
        p.h(cls, "clazz");
        DataBuffer<T> dataBuffer = this.dataList;
        ListIterator<E> listIterator = dataBuffer.listIterator(dataBuffer.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                e2 = null;
                break;
            }
            e2 = listIterator.previous();
            if (cls.isInstance(e2)) {
                break;
            }
        }
        if (e2 != null) {
            AppMethodBeat.o(245005);
            return e2;
        }
        AppMethodBeat.o(245005);
        return null;
    }
}
