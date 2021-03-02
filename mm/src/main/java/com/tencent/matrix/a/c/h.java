package com.tencent.matrix.a.c;

import android.os.SystemClock;
import android.support.v4.e.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class h {
    public static void K(List<?> list) {
        int size;
        int size2;
        int i2;
        if (list != null && (size2 = (size = list.size()) / 2) < size - 1) {
            list.subList(size2, i2).clear();
        }
    }

    public static b a(List<? extends a> list, long j2) {
        long longValue;
        final HashMap hashMap = new HashMap();
        long j3 = 0;
        long j4 = Long.MIN_VALUE;
        if (j2 > 0) {
            Iterator<? extends a> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                a aVar = (a) it.next();
                if (j4 != Long.MIN_VALUE) {
                    if (j4 < aVar.cTi) {
                        break;
                    }
                    long j5 = j4 - aVar.cTi;
                    if (j3 + j5 >= j2) {
                        long j6 = j2 - j3;
                        j3 += j6;
                        Long l = (Long) hashMap.get(aVar.key);
                        String str = aVar.key;
                        if (l == null) {
                            longValue = 0;
                        } else {
                            longValue = l.longValue();
                        }
                        hashMap.put(str, Long.valueOf(longValue + j6));
                    } else {
                        j3 += j5;
                        Long l2 = (Long) hashMap.get(aVar.key);
                        hashMap.put(aVar.key, Long.valueOf((l2 == null ? 0 : l2.longValue()) + j5));
                    }
                }
                j4 = aVar.cTi;
            }
        } else {
            for (a aVar2 : list) {
                if (j4 != Long.MIN_VALUE) {
                    if (j4 < aVar2.cTi) {
                        break;
                    }
                    long j7 = j4 - aVar2.cTi;
                    j3 += j7;
                    Long l3 = (Long) hashMap.get(aVar2.key);
                    hashMap.put(aVar2.key, Long.valueOf((l3 == null ? 0 : l3.longValue()) + j7));
                }
                j4 = aVar2.cTi;
            }
        }
        b bVar = new b();
        if (j3 <= 0) {
            bVar.cTq = false;
        } else {
            if (j2 > j3) {
                bVar.cTq = false;
            }
            bVar.cUw = j3;
            new android.arch.a.c.a<String, Long>() {
                /* class com.tencent.matrix.a.c.h.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.arch.a.c.a
                public final /* synthetic */ Long apply(String str) {
                    long longValue;
                    Long l = (Long) hashMap.get(str);
                    if (l == null) {
                        longValue = 0;
                    } else {
                        longValue = l.longValue();
                    }
                    return Long.valueOf(longValue);
                }
            };
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : hashMap.entrySet()) {
                arrayList.add(new k((String) entry.getKey(), Integer.valueOf(p(((Long) entry.getValue()).longValue(), j3))));
            }
            Collections.sort(arrayList, new Comparator<k<String, Integer>>() {
                /* class com.tencent.matrix.a.c.h.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(k<String, Integer> kVar, k<String, Integer> kVar2) {
                    k<String, Integer> kVar3 = kVar;
                    k<String, Integer> kVar4 = kVar2;
                    long intValue = (long) ((kVar3.second == null ? 0 : kVar3.second.intValue()) - (kVar4.second == null ? 0 : kVar4.second.intValue()));
                    if (intValue == 0) {
                        return 0;
                    }
                    if (intValue > 0) {
                        return -1;
                    }
                    return 1;
                }
            });
            bVar.cUx = arrayList;
        }
        return bVar;
    }

    private static int p(long j2, long j3) {
        long round = Math.round((((double) j2) / ((double) j3)) * 100.0d);
        if (round >= 100) {
            return 100;
        }
        if (round <= 0) {
            return 0;
        }
        return (int) round;
    }

    public static class a {
        public final long cTi = SystemClock.uptimeMillis();
        public final String key;

        public a(String str) {
            this.key = str;
        }
    }

    public static final class b {
        public boolean cTq = true;
        public long cUw;
        public List<k<String, Integer>> cUx = Collections.emptyList();

        public final int ex(String str) {
            for (k<String, Integer> kVar : this.cUx) {
                if (kVar.first != null && kVar.first.equals(str)) {
                    if (kVar.second == null) {
                        return 0;
                    }
                    return kVar.second.intValue();
                }
            }
            return 0;
        }

        public final k<String, Integer> Ss() {
            if (this.cUx.size() > 0) {
                return this.cUx.get(0);
            }
            return null;
        }
    }
}
