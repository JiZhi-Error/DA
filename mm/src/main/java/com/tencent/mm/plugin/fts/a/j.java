package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.mm.storage.as;
import java.util.List;

public interface j {
    as ayj(String str);

    boolean ayk(String str);

    long ayl(String str);

    List<String> aym(String str);

    Cursor i(String str, String[] strArr);

    Cursor rawQuery(String str, String[] strArr);
}
