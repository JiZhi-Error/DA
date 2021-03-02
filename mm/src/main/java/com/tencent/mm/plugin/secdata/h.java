package com.tencent.mm.plugin.secdata;

import android.content.Intent;
import com.tencent.mm.bw.a;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\r\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/secdata/ISecData;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "", "check", "", "intent", "Landroid/content/Intent;", "getTransformData", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getType", "", "reuse", "plugin-sec-data_release"})
public interface h<T extends a> {
    boolean aS(Intent intent);

    T eSl();

    boolean eSm();

    int getType();
}
