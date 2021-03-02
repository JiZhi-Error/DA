package com.tencent.mm.plugin.secdata;

import com.tencent.mm.bw.a;
import java.util.Map;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0017\u0010\t\u001a\u0004\u0018\u00018\u00002\u0006\u0010\n\u001a\u00020\u0007H&¢\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u001d\u0010\u0011\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/secdata/IListSecData;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "", "copyItemObj", "", "fromKey", "", "toKey", "getItemObj", "key", "(Ljava/lang/String;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getListItemObjMap", "", "getType", "", "moveItemObj", "putItemObj", "value", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;)V", "plugin-sec-data_release"})
public interface f<T extends a> {
    void c(String str, T t);

    Map<String, T> eSo();

    int getType();

    void jS(String str, String str2);
}
