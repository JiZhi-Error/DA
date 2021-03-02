package com.tencent.matrix.report;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.report.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class b extends d {
    private final long cWb = Util.MILLSECONDS_OF_DAY;
    private final SharedPreferences.Editor cWc;
    private final HashMap<String, Long> cWd;
    public final Context context;
    private final SharedPreferences sharedPreferences;

    public b(Context context2, String str, d.a aVar) {
        super(aVar);
        this.context = context2;
        this.sharedPreferences = context2.getSharedPreferences(str + com.tencent.matrix.g.d.getProcessName(context2), 0);
        this.cWd = new HashMap<>();
        long currentTimeMillis = System.currentTimeMillis();
        this.cWc = this.sharedPreferences.edit();
        HashSet hashSet = this.sharedPreferences.getAll() != null ? new HashSet(this.sharedPreferences.getAll().keySet()) : null;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                long j2 = this.sharedPreferences.getLong(str2, 0);
                long j3 = currentTimeMillis - j2;
                if (j2 <= 0 || j3 > this.cWb) {
                    this.cWc.remove(str2);
                } else {
                    this.cWd.put(str2, Long.valueOf(j2));
                }
            }
        }
        if (this.cWc != null) {
            this.cWc.apply();
        }
    }

    @Override // com.tencent.matrix.report.d
    public final void eB(String str) {
        if (str != null && !this.cWd.containsKey(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            this.cWd.put(str, Long.valueOf(currentTimeMillis));
            SharedPreferences.Editor putLong = this.cWc.putLong(str, currentTimeMillis);
            if (putLong != null) {
                putLong.apply();
            }
        }
    }

    @Override // com.tencent.matrix.report.d
    public final boolean eC(String str) {
        if (!this.cWd.containsKey(str)) {
            return false;
        }
        long longValue = this.cWd.get(str).longValue();
        if (longValue > 0 && System.currentTimeMillis() - longValue <= this.cWb) {
            return true;
        }
        SharedPreferences.Editor remove = this.cWc.remove(str);
        if (remove != null) {
            remove.apply();
        }
        this.cWd.remove(str);
        return false;
    }
}
