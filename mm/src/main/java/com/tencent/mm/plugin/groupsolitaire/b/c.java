package com.tencent.mm.plugin.groupsolitaire.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.c.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c {
    private ConcurrentHashMap<String, a> yfd = new ConcurrentHashMap<>();
    private ConcurrentLinkedQueue<a> yfe = new ConcurrentLinkedQueue<>();
    private ConcurrentHashMap<String, com.tencent.mm.plugin.groupsolitaire.c.a> yff = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, com.tencent.mm.plugin.groupsolitaire.c.a> yfg = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, a> yfh = new ConcurrentHashMap<>();
    private Pattern yfi = Pattern.compile(b.dXC());
    private Pattern yfj = Pattern.compile(b.dXI());
    private Pattern yfk = Pattern.compile(b.dXD());
    private Pattern yfl = Pattern.compile(b.dXF());
    private Pattern yfm = Pattern.compile(b.dXE());
    private Pattern yfn = Pattern.compile(b.dXH());
    private Pattern yfo = Pattern.compile(b.dXG());

    public c() {
        AppMethodBeat.i(110369);
        try {
            String[] split = PluginGroupSolitaire.getKV().getString("analyze_crash_content_num", "").split(";");
            if (split != null) {
                int i2 = 0;
                for (int length = split.length - 1; length >= 0; length--) {
                    String str = split[length];
                    if (!Util.isNullOrNil(str)) {
                        i2++;
                        if (i2 > 20) {
                            break;
                        }
                        String[] split2 = str.split(",");
                        if (split2 != null && split2.length == 2) {
                            a aVar = new a(split2[0], Util.getInt(split2[1], 0));
                            this.yfd.put(split2[0], aVar);
                            this.yfe.add(aVar);
                        }
                    }
                }
            }
            AppMethodBeat.o(110369);
        } catch (Exception e2) {
            Log.e("MicroMsg.groupsolitaire.GroupSolitatireManager", "GroupSolitatireManager %s %s", e2.getClass().getSimpleName(), e2.getMessage());
            AppMethodBeat.o(110369);
        }
    }

    public final Pair<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> ia(String str, String str2) {
        int i2;
        boolean z;
        int i3;
        com.tencent.mm.plugin.groupsolitaire.c.a aVar;
        int i4;
        int i5;
        String substring;
        int i6;
        int i7;
        AppMethodBeat.i(110370);
        Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire()");
        if (Util.isNullOrNil(str)) {
            Pair<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> pair = new Pair<>(0, null);
            AppMethodBeat.o(110370);
            return pair;
        }
        String trim = str.trim();
        if (Util.isNullOrNil(trim)) {
            Pair<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> pair2 = new Pair<>(0, null);
            AppMethodBeat.o(110370);
            return pair2;
        }
        String[] split = trim.split("\n");
        boolean z2 = false;
        int i8 = -1;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        if (split.length > 1000) {
            Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() contentArray.length > 1000");
            Pair<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> pair3 = new Pair<>(0, null);
            AppMethodBeat.o(110370);
            return pair3;
        }
        if (!Util.isNullOrNil(trim)) {
            String aBo = aBo(trim);
            if (this.yfd.contains(aBo)) {
                i2 = this.yfd.get(aBo).ibS;
            } else {
                i2 = 0;
            }
        } else {
            i2 = 0;
        }
        if (i2 > 3) {
            Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() getCrashNum() > 3");
            Pair<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> pair4 = new Pair<>(0, null);
            AppMethodBeat.o(110370);
            return pair4;
        }
        long aWz = cl.aWz();
        com.tencent.mm.plugin.groupsolitaire.c.a aVar2 = new com.tencent.mm.plugin.groupsolitaire.c.a();
        try {
            if (!Util.isNullOrNil(trim)) {
                String aBo2 = aBo(trim);
                if (this.yfd.contains(aBo2)) {
                    this.yfd.get(aBo2).ibS++;
                } else {
                    a aVar3 = new a(aBo2, 1);
                    this.yfd.put(aBo2, aVar3);
                    this.yfe.add(aVar3);
                }
                dXT();
            }
            int i12 = 0;
            while (true) {
                if (i12 >= split.length) {
                    i12 = 0;
                    z = false;
                    break;
                }
                String str3 = split[i12];
                Matcher matcher = this.yfi.matcher(str3.trim());
                if (BuildInfo.DEBUG) {
                    Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "str(first):%s", str3);
                }
                boolean find = matcher.find();
                if (BuildInfo.DEBUG) {
                    Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "mainBody(first) result:%s", Boolean.valueOf(find));
                }
                if (find) {
                    z = true;
                    i9 = trim.indexOf(str3, i11);
                    break;
                }
                if (!z2) {
                    Matcher matcher2 = this.yfj.matcher(str3.trim());
                    z2 = matcher2.find();
                    if (BuildInfo.DEBUG) {
                        Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "example str:%s hasExample:%s", str3, Boolean.valueOf(z2));
                    }
                    if (z2) {
                        String group = matcher2.group(0);
                        if (Util.isNullOrNil(group)) {
                            i7 = trim.indexOf(str3, i11);
                        } else {
                            i7 = trim.indexOf(group, i11);
                        }
                        i11 = str3.length() + i11 + 1;
                        i12++;
                        i8 = i7;
                    }
                }
                i7 = i8;
                i11 = str3.length() + i11 + 1;
                i12++;
                i8 = i7;
            }
            if (!z) {
                Pair<Boolean, com.tencent.mm.plugin.groupsolitaire.c.a> l = l(trim, split);
                if (((Boolean) l.first).booleanValue()) {
                    aVar = (com.tencent.mm.plugin.groupsolitaire.c.a) l.second;
                } else {
                    Pair<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> pair5 = new Pair<>(0, null);
                    long aWz2 = cl.aWz() - aWz;
                    if (aWz2 <= 1000) {
                        h.INSTANCE.idkeyStat(1174, 0, 1, false);
                    } else if (aWz2 <= 2000) {
                        h.INSTANCE.idkeyStat(1174, 1, 1, false);
                    } else if (aWz2 <= 3000) {
                        h.INSTANCE.idkeyStat(1174, 2, 1, false);
                    } else if (aWz2 <= 4000) {
                        h.INSTANCE.idkeyStat(1174, 3, 1, false);
                    } else if (aWz2 <= 5000) {
                        h.INSTANCE.idkeyStat(1174, 4, 1, false);
                    } else {
                        h.INSTANCE.idkeyStat(1174, 5, 1, false);
                    }
                    Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", Long.valueOf(aWz2));
                    AppMethodBeat.o(110370);
                    return pair5;
                }
            } else {
                int length = trim.length();
                int length2 = split.length - 1;
                while (true) {
                    if (length2 < i12) {
                        i3 = 0;
                        break;
                    }
                    String str4 = split[length2];
                    int length3 = length - str4.length();
                    if (BuildInfo.DEBUG) {
                        Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "str(last):%s", str4);
                    }
                    boolean find2 = this.yfi.matcher(str4.trim()).find();
                    if (BuildInfo.DEBUG) {
                        Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "mainBody(last) result:%s", Boolean.valueOf(find2));
                    }
                    if (find2) {
                        i3 = length2;
                        i10 = trim.indexOf(str4, length3);
                        break;
                    }
                    length = length3 - 1;
                    length2--;
                }
                if (i9 > 0 && i9 <= trim.length()) {
                    if (i8 != 0) {
                        if (i8 == -1) {
                            aVar2.header = trim.substring(0, i9).trim();
                        } else {
                            aVar2.header = trim.substring(0, i8).trim();
                        }
                    }
                    if (b.aBj(aVar2.header)) {
                        Pair<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> pair6 = new Pair<>(0, null);
                        long aWz3 = cl.aWz() - aWz;
                        if (aWz3 <= 1000) {
                            h.INSTANCE.idkeyStat(1174, 0, 1, false);
                        } else if (aWz3 <= 2000) {
                            h.INSTANCE.idkeyStat(1174, 1, 1, false);
                        } else if (aWz3 <= 3000) {
                            h.INSTANCE.idkeyStat(1174, 2, 1, false);
                        } else if (aWz3 <= 4000) {
                            h.INSTANCE.idkeyStat(1174, 3, 1, false);
                        } else if (aWz3 <= 5000) {
                            h.INSTANCE.idkeyStat(1174, 4, 1, false);
                        } else {
                            h.INSTANCE.idkeyStat(1174, 5, 1, false);
                        }
                        Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", Long.valueOf(aWz3));
                        AppMethodBeat.o(110370);
                        return pair6;
                    } else if (i8 >= 0 && i8 <= i9) {
                        aVar2.yfB = trim.substring(i8, i9).trim();
                    }
                }
                int length4 = i10 + split[i3].length();
                if (length4 > 0 && length4 < trim.length()) {
                    aVar2.xxN = trim.substring(length4).trim();
                }
                if (b.aBk(aVar2.xxN)) {
                    Pair<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> pair7 = new Pair<>(0, null);
                    long aWz4 = cl.aWz() - aWz;
                    if (aWz4 <= 1000) {
                        h.INSTANCE.idkeyStat(1174, 0, 1, false);
                    } else if (aWz4 <= 2000) {
                        h.INSTANCE.idkeyStat(1174, 1, 1, false);
                    } else if (aWz4 <= 3000) {
                        h.INSTANCE.idkeyStat(1174, 2, 1, false);
                    } else if (aWz4 <= 4000) {
                        h.INSTANCE.idkeyStat(1174, 3, 1, false);
                    } else if (aWz4 <= 5000) {
                        h.INSTANCE.idkeyStat(1174, 4, 1, false);
                    } else {
                        h.INSTANCE.idkeyStat(1174, 5, 1, false);
                    }
                    Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", Long.valueOf(aWz4));
                    AppMethodBeat.o(110370);
                    return pair7;
                }
                String a2 = b.a(aVar2);
                com.tencent.mm.plugin.groupsolitaire.c.a ie = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().ie(str2, a2);
                aVar2.dXU();
                int i13 = 0;
                ArrayList arrayList = new ArrayList();
                int indexOf = trim.indexOf(split[i12]);
                com.tencent.mm.plugin.groupsolitaire.c.a aVar4 = ie;
                int i14 = length4;
                int i15 = i12;
                while (i15 <= i3) {
                    int length5 = split[i15].length() + indexOf + 1;
                    int i16 = i15 + 1;
                    while (i16 <= i3) {
                        if (this.yfl.matcher(split[i16].trim()).find()) {
                            break;
                        }
                        length5 = length5 + split[i16].length() + 1;
                        i16++;
                    }
                    if (i16 > i3) {
                        if (i14 > trim.length()) {
                            i14 = trim.length();
                        }
                        substring = trim.substring(trim.indexOf(split[i15], indexOf), i14);
                        i6 = i14;
                    } else {
                        if (length5 >= trim.length()) {
                            length5 = indexOf;
                        }
                        substring = trim.substring(trim.indexOf(split[i15], indexOf), trim.indexOf(split[i16], length5));
                        i6 = i14;
                    }
                    indexOf += substring.length();
                    String a3 = b.a(aVar2);
                    if (!Util.isEqual(a2, a3)) {
                        aVar4 = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().ie(str2, a3);
                    }
                    aVar2.dXU();
                    List<b> a4 = a(aVar4, substring);
                    if (a4 == null) {
                        i14 = i6;
                        i15 = i16;
                    } else {
                        int i17 = 0;
                        while (i17 < a4.size()) {
                            b bVar = a4.get(i17);
                            if (b.aBi(bVar.content)) {
                                Pair<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> pair8 = new Pair<>(0, null);
                                long aWz5 = cl.aWz() - aWz;
                                if (aWz5 <= 1000) {
                                    h.INSTANCE.idkeyStat(1174, 0, 1, false);
                                } else if (aWz5 <= 2000) {
                                    h.INSTANCE.idkeyStat(1174, 1, 1, false);
                                } else if (aWz5 <= 3000) {
                                    h.INSTANCE.idkeyStat(1174, 2, 1, false);
                                } else if (aWz5 <= 4000) {
                                    h.INSTANCE.idkeyStat(1174, 3, 1, false);
                                } else if (aWz5 <= 5000) {
                                    h.INSTANCE.idkeyStat(1174, 4, 1, false);
                                } else {
                                    h.INSTANCE.idkeyStat(1174, 5, 1, false);
                                }
                                Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", Long.valueOf(aWz5));
                                AppMethodBeat.o(110370);
                                return pair8;
                            }
                            if (aVar2.yfE.size() == 0) {
                                aVar2.separator = bVar.separator;
                            }
                            if ((i17 != 0 || !Util.isNullOrNil(bVar.content)) && !Util.isNullOrNil(bVar.content.trim())) {
                                i13++;
                                aVar2.yfE.put(Integer.valueOf(i13), bVar);
                            } else {
                                aVar2.yfG++;
                                arrayList.add(Integer.valueOf(bVar.yfI));
                            }
                            i17++;
                            i13 = i13;
                        }
                        i14 = i6;
                        i15 = i16;
                    }
                }
                if (aVar2.yfE.size() + arrayList.size() >= 4) {
                    HashSet hashSet = new HashSet();
                    int i18 = 0;
                    int i19 = 1;
                    while (i19 <= aVar2.yfE.size()) {
                        b bVar2 = aVar2.yfE.get(Integer.valueOf(i19));
                        if (hashSet.contains(Integer.valueOf(bVar2.yfI))) {
                            i5 = i18 + 1;
                            if (i5 >= 2) {
                                Pair<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> pair9 = new Pair<>(0, null);
                                long aWz6 = cl.aWz() - aWz;
                                if (aWz6 <= 1000) {
                                    h.INSTANCE.idkeyStat(1174, 0, 1, false);
                                } else if (aWz6 <= 2000) {
                                    h.INSTANCE.idkeyStat(1174, 1, 1, false);
                                } else if (aWz6 <= 3000) {
                                    h.INSTANCE.idkeyStat(1174, 2, 1, false);
                                } else if (aWz6 <= 4000) {
                                    h.INSTANCE.idkeyStat(1174, 3, 1, false);
                                } else if (aWz6 <= 5000) {
                                    h.INSTANCE.idkeyStat(1174, 4, 1, false);
                                } else {
                                    h.INSTANCE.idkeyStat(1174, 5, 1, false);
                                }
                                Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", Long.valueOf(aWz6));
                                AppMethodBeat.o(110370);
                                return pair9;
                            }
                        } else {
                            hashSet.add(Integer.valueOf(bVar2.yfI));
                            i5 = i18;
                        }
                        i19++;
                        i18 = i5;
                    }
                    int i20 = 0;
                    while (i20 < arrayList.size()) {
                        int intValue = ((Integer) arrayList.get(i20)).intValue();
                        if (hashSet.contains(Integer.valueOf(intValue))) {
                            i4 = i18 + 1;
                            if (i4 >= 2) {
                                Pair<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> pair10 = new Pair<>(0, null);
                                long aWz7 = cl.aWz() - aWz;
                                if (aWz7 <= 1000) {
                                    h.INSTANCE.idkeyStat(1174, 0, 1, false);
                                } else if (aWz7 <= 2000) {
                                    h.INSTANCE.idkeyStat(1174, 1, 1, false);
                                } else if (aWz7 <= 3000) {
                                    h.INSTANCE.idkeyStat(1174, 2, 1, false);
                                } else if (aWz7 <= 4000) {
                                    h.INSTANCE.idkeyStat(1174, 3, 1, false);
                                } else if (aWz7 <= 5000) {
                                    h.INSTANCE.idkeyStat(1174, 4, 1, false);
                                } else {
                                    h.INSTANCE.idkeyStat(1174, 5, 1, false);
                                }
                                Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", Long.valueOf(aWz7));
                                AppMethodBeat.o(110370);
                                return pair10;
                            }
                        } else {
                            hashSet.add(Integer.valueOf(intValue));
                            i4 = i18;
                        }
                        i20++;
                        i18 = i4;
                    }
                }
                if (Util.isNullOrNil(aVar2.separator) && aVar2.yfE.size() > 0) {
                    aVar2.separator = aVar2.yfE.get(1).separator;
                }
                aVar = aVar2;
            }
            if (Util.isNullOrNil(aVar.separator) || Util.isNullOrNil(aVar.separator.trim())) {
                aVar.separator = ".";
            }
            if (!Util.isNullOrNil(trim)) {
                this.yfe.remove(this.yfd.remove(aBo(trim)));
                dXT();
            }
            long aWz8 = cl.aWz() - aWz;
            if (aWz8 <= 1000) {
                h.INSTANCE.idkeyStat(1174, 0, 1, false);
            } else if (aWz8 <= 2000) {
                h.INSTANCE.idkeyStat(1174, 1, 1, false);
            } else if (aWz8 <= 3000) {
                h.INSTANCE.idkeyStat(1174, 2, 1, false);
            } else if (aWz8 <= 4000) {
                h.INSTANCE.idkeyStat(1174, 3, 1, false);
            } else if (aWz8 <= 5000) {
                h.INSTANCE.idkeyStat(1174, 4, 1, false);
            } else {
                h.INSTANCE.idkeyStat(1174, 5, 1, false);
            }
            Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", Long.valueOf(aWz8));
            if (BuildInfo.DEBUG) {
                Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() groupSolitatire:%s", aVar);
            }
            Pair<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> pair11 = new Pair<>(Integer.valueOf(aVar.yfE.size()), aVar);
            AppMethodBeat.o(110370);
            return pair11;
        } catch (Exception e2) {
            Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire Exception：%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            Pair<Integer, com.tencent.mm.plugin.groupsolitaire.c.a> pair12 = new Pair<>(0, null);
            long aWz9 = cl.aWz() - aWz;
            if (aWz9 <= 1000) {
                h.INSTANCE.idkeyStat(1174, 0, 1, false);
            } else if (aWz9 <= 2000) {
                h.INSTANCE.idkeyStat(1174, 1, 1, false);
            } else if (aWz9 <= 3000) {
                h.INSTANCE.idkeyStat(1174, 2, 1, false);
            } else if (aWz9 <= 4000) {
                h.INSTANCE.idkeyStat(1174, 3, 1, false);
            } else if (aWz9 <= 5000) {
                h.INSTANCE.idkeyStat(1174, 4, 1, false);
            } else {
                h.INSTANCE.idkeyStat(1174, 5, 1, false);
            }
            Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", Long.valueOf(aWz9));
            AppMethodBeat.o(110370);
            return pair12;
        } catch (Throwable th) {
            long aWz10 = cl.aWz() - aWz;
            if (aWz10 <= 1000) {
                h.INSTANCE.idkeyStat(1174, 0, 1, false);
            } else if (aWz10 <= 2000) {
                h.INSTANCE.idkeyStat(1174, 1, 1, false);
            } else if (aWz10 <= 3000) {
                h.INSTANCE.idkeyStat(1174, 2, 1, false);
            } else if (aWz10 <= 4000) {
                h.INSTANCE.idkeyStat(1174, 3, 1, false);
            } else if (aWz10 <= 5000) {
                h.INSTANCE.idkeyStat(1174, 4, 1, false);
            } else {
                h.INSTANCE.idkeyStat(1174, 5, 1, false);
            }
            Log.i("MicroMsg.groupsolitaire.GroupSolitatireManager", "matchGroupSolitatire() internal:%s", Long.valueOf(aWz10));
            AppMethodBeat.o(110370);
            throw th;
        }
    }

    private Pair<Boolean, com.tencent.mm.plugin.groupsolitaire.c.a> l(String str, String[] strArr) {
        int i2;
        boolean z;
        int length;
        int i3;
        AppMethodBeat.i(194432);
        int length2 = str.length();
        int length3 = strArr.length - 1;
        while (true) {
            if (length3 < 0) {
                i2 = 0;
                z = false;
                length3 = 0;
                break;
            }
            String str2 = strArr[length3];
            int length4 = length2 - str2.length();
            if (this.yfo.matcher(str2.trim()).find()) {
                z = true;
                i2 = str.indexOf(str2, length4);
                break;
            }
            length2 = length4 - 1;
            length3--;
        }
        if (!z) {
            Pair<Boolean, com.tencent.mm.plugin.groupsolitaire.c.a> pair = new Pair<>(Boolean.FALSE, null);
            AppMethodBeat.o(194432);
            return pair;
        }
        com.tencent.mm.plugin.groupsolitaire.c.a aVar = new com.tencent.mm.plugin.groupsolitaire.c.a();
        if (i2 >= 0 && i2 <= str.length()) {
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (i4 >= length3) {
                    i3 = -1;
                    break;
                }
                String str3 = strArr[i4];
                Matcher matcher = this.yfj.matcher(str3.trim());
                if (matcher.find()) {
                    String group = matcher.group(0);
                    if (Util.isNullOrNil(group)) {
                        i3 = str.indexOf(str3, i5);
                    } else {
                        i3 = str.indexOf(group, i5);
                    }
                } else {
                    i5 = i5 + str3.length() + 1;
                    i4++;
                }
            }
            if (i3 != 0) {
                if (i3 == -1) {
                    aVar.header = str.substring(0, i2).trim();
                } else {
                    aVar.header = str.substring(0, i3).trim();
                }
            }
            if (b.aBj(aVar.header)) {
                Pair<Boolean, com.tencent.mm.plugin.groupsolitaire.c.a> pair2 = new Pair<>(Boolean.FALSE, null);
                AppMethodBeat.o(194432);
                return pair2;
            } else if (i3 >= 0 && i3 <= i2) {
                aVar.yfB = str.substring(i3, i2).trim();
            }
        }
        if (length3 >= 0 && length3 < strArr.length && (length = strArr[length3].length() + i2) > 0 && length < str.length()) {
            aVar.xxN = str.substring(length).trim();
        }
        if (b.aBk(aVar.xxN)) {
            Pair<Boolean, com.tencent.mm.plugin.groupsolitaire.c.a> pair3 = new Pair<>(Boolean.FALSE, null);
            AppMethodBeat.o(194432);
            return pair3;
        }
        aVar.yfG++;
        Pair<Boolean, com.tencent.mm.plugin.groupsolitaire.c.a> pair4 = new Pair<>(Boolean.TRUE, aVar);
        AppMethodBeat.o(194432);
        return pair4;
    }

    private List<b> a(com.tencent.mm.plugin.groupsolitaire.c.a aVar, String str) {
        b bVar;
        AppMethodBeat.i(110371);
        ArrayList arrayList = new ArrayList();
        b bVar2 = new b();
        Matcher matcher = this.yfk.matcher(str.trim());
        Matcher matcher2 = this.yfl.matcher(str.trim());
        if (matcher.find()) {
            Matcher matcher3 = this.yfl.matcher(matcher.group(0).trim());
            if (matcher3.find()) {
                bVar2.yfI = Util.getInt(matcher3.group(0), 0);
            }
            bVar2.separator = matcher3.replaceFirst("").trim();
            bVar2.content = matcher.replaceFirst("").trim();
        } else if (matcher2.find()) {
            bVar2.yfI = Util.getInt(matcher2.group(0), 0);
            bVar2.content = matcher2.replaceFirst("").trim();
            if (Util.isNullOrNil(bVar2.content) || Util.isNullOrNil(bVar2.content.trim())) {
                AppMethodBeat.o(110371);
                return null;
            }
        }
        if (aVar != null) {
            Matcher matcher4 = this.yfm.matcher(bVar2.content);
            if (matcher4.find()) {
                int indexOf = bVar2.content.indexOf(matcher4.group(0));
                if (indexOf != -1) {
                    String substring = bVar2.content.substring(0, indexOf);
                    if (Util.isNullOrNil(substring) || Util.isNullOrNil(substring.trim())) {
                        arrayList.add(bVar2);
                    } else {
                        int i2 = 1;
                        while (true) {
                            if (i2 > aVar.yfE.size()) {
                                bVar = null;
                                break;
                            } else if (b.id(aVar.yfE.get(Integer.valueOf(i2)).content, substring.trim())) {
                                bVar = aVar.yfE.get(Integer.valueOf(i2));
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (bVar != null) {
                            String str2 = bVar2.content;
                            bVar2.content = bVar.content;
                            arrayList.add(bVar2);
                            String substring2 = str2.substring(indexOf);
                            if (!Util.isNullOrNil(substring2) && !Util.isNullOrNil(substring2.trim())) {
                                a(arrayList, aVar, substring2.trim());
                            }
                        } else {
                            arrayList.add(bVar2);
                        }
                    }
                } else {
                    arrayList.add(bVar2);
                }
            } else {
                arrayList.add(bVar2);
            }
        } else {
            arrayList.add(bVar2);
        }
        if (arrayList.size() == 0) {
            AppMethodBeat.o(110371);
            return null;
        }
        AppMethodBeat.o(110371);
        return arrayList;
    }

    private void a(List<b> list, com.tencent.mm.plugin.groupsolitaire.c.a aVar, String str) {
        b bVar;
        AppMethodBeat.i(110372);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(110372);
            return;
        }
        b bVar2 = new b();
        Matcher matcher = this.yfm.matcher(str);
        if (matcher.find()) {
            Matcher matcher2 = this.yfn.matcher(matcher.group(0).trim());
            if (matcher2.find()) {
                bVar2.yfI = Util.getInt(matcher2.group(0), 0);
            }
            bVar2.separator = matcher2.replaceFirst("").trim();
            bVar2.content = matcher.replaceFirst("").trim();
            Matcher matcher3 = this.yfm.matcher(bVar2.content);
            if (matcher3.find()) {
                int indexOf = bVar2.content.indexOf(matcher3.group(0));
                if (indexOf != -1) {
                    String substring = bVar2.content.substring(0, indexOf);
                    if (Util.isNullOrNil(substring) || Util.isNullOrNil(substring.trim())) {
                        list.add(bVar2);
                        AppMethodBeat.o(110372);
                        return;
                    }
                    int i2 = 1;
                    while (true) {
                        if (i2 > aVar.yfE.size()) {
                            bVar = null;
                            break;
                        } else if (Util.isEqual(aVar.yfE.get(Integer.valueOf(i2)).content, substring.trim())) {
                            bVar = aVar.yfE.get(Integer.valueOf(i2));
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (bVar != null) {
                        String str2 = bVar2.content;
                        bVar2.content = bVar.content;
                        list.add(bVar2);
                        String substring2 = str2.substring(indexOf);
                        if (!Util.isNullOrNil(substring2) && !Util.isNullOrNil(substring2.trim())) {
                            a(list, aVar, substring2.trim());
                        }
                        AppMethodBeat.o(110372);
                        return;
                    }
                    list.add(bVar2);
                    AppMethodBeat.o(110372);
                    return;
                }
                list.add(bVar2);
                AppMethodBeat.o(110372);
                return;
            }
            list.add(bVar2);
        }
        AppMethodBeat.o(110372);
    }

    public final com.tencent.mm.plugin.groupsolitaire.c.a ib(final String str, final String str2) {
        AppMethodBeat.i(110373);
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "getGroupSolitatireFromCache() username:%s key:%s", str, str2);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(110373);
            return null;
        }
        com.tencent.mm.plugin.groupsolitaire.c.a aVar = this.yff.get(str + str2);
        if (aVar == null) {
            aVar = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().r(str, str2, true);
            if (aVar != null) {
                this.yff.put(str + str2, aVar);
            }
        } else {
            a aBm = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().aBm(str);
            if (aBm != null && ((aVar.field_active == 1 && aVar.field_lastActiveTime < aBm.yfa) || (aVar.field_active == 0 && aVar.field_lastActiveTime < aBm.yfc))) {
                ic(str, str2);
                com.tencent.f.h.RTc.aX(new Runnable() {
                    /* class com.tencent.mm.plugin.groupsolitaire.b.c.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(110366);
                        ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().r(str, str2, true);
                        AppMethodBeat.o(110366);
                    }
                });
                AppMethodBeat.o(110373);
                return null;
            }
        }
        AppMethodBeat.o(110373);
        return aVar;
    }

    public final void ic(String str, String str2) {
        AppMethodBeat.i(110374);
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "deleteGroupSolitatireInCache() username:%s key:%s", str, str2);
        this.yff.remove(str + str2);
        AppMethodBeat.o(110374);
    }

    public final void c(String str, com.tencent.mm.plugin.groupsolitaire.c.a aVar) {
        AppMethodBeat.i(194433);
        if (aVar != null && !Util.isNullOrNil(aVar.field_key)) {
            Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "putTempGroupSolitatireToCache() username:%s key:%s", str, aVar.field_key);
            this.yfg.put(str + aVar.field_key, aVar);
        }
        AppMethodBeat.o(194433);
    }

    public final a aBm(String str) {
        AppMethodBeat.i(110375);
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "getChatRoomGroupSolitatire() username:%s", str);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(110375);
            return null;
        }
        a aVar = this.yfh.get(str);
        if (aVar == null) {
            a aVar2 = new a();
            aVar2.dXB();
            List<com.tencent.mm.plugin.groupsolitaire.c.a> eo = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().eo(str, 0);
            List<com.tencent.mm.plugin.groupsolitaire.c.a> eo2 = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().eo(str, 1);
            if (eo.size() > b.dXM()) {
                aVar2.yfb = false;
                aVar2.yfc = eo.get(b.dXM() - 1).field_lastActiveTime;
            } else {
                aVar2.yfb = true;
                aVar2.yfc = ((long) cl.aWB()) - (((long) b.dXL()) * com.tencent.mm.plugin.groupsolitaire.c.c.yfK.longValue());
            }
            if (eo2.size() > b.dXK()) {
                aVar2.yeZ = false;
                aVar2.yfa = eo2.get(b.dXK() - 1).field_lastActiveTime;
            } else {
                aVar2.yeZ = true;
                aVar2.yfa = ((long) cl.aWB()) - (((long) b.dXJ()) * com.tencent.mm.plugin.groupsolitaire.c.c.yfJ.longValue());
            }
            this.yfh.put(str, aVar2);
            aVar = aVar2;
        } else if (aVar.lastUpdateTime - ((long) cl.aWB()) > 10) {
            aVar.dXB();
            a(str, aVar);
            b(str, aVar);
        }
        AppMethodBeat.o(110375);
        return aVar;
    }

    public final void aBn(String str) {
        AppMethodBeat.i(110376);
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "updateChatRoomGroupSolitatire() username:%s", str);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(110376);
            return;
        }
        a aVar = new a();
        aVar.dXB();
        List<com.tencent.mm.plugin.groupsolitaire.c.a> eo = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().eo(str, 0);
        List<com.tencent.mm.plugin.groupsolitaire.c.a> eo2 = ((PluginGroupSolitaire) g.ah(PluginGroupSolitaire.class)).getGroupSolitatireStorage().eo(str, 1);
        if (eo.size() > b.dXM()) {
            aVar.yfb = false;
            aVar.yfc = eo.get(b.dXM() - 1).field_lastActiveTime;
        } else {
            aVar.yfb = true;
            aVar.yfc = ((long) cl.aWB()) - (((long) b.dXL()) * com.tencent.mm.plugin.groupsolitaire.c.c.yfK.longValue());
        }
        if (eo2.size() > b.dXK()) {
            aVar.yeZ = false;
            aVar.yfa = eo2.get(b.dXK() - 1).field_lastActiveTime;
        } else {
            aVar.yeZ = true;
            aVar.yfa = ((long) cl.aWB()) - (((long) b.dXJ()) * com.tencent.mm.plugin.groupsolitaire.c.c.yfJ.longValue());
        }
        this.yfh.put(str, aVar);
        AppMethodBeat.o(110376);
    }

    private static void a(String str, a aVar) {
        AppMethodBeat.i(110377);
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "updateMatchChatRoomGroupSolitatire() username:%s", str);
        if (Util.isNullOrNil(str) || aVar == null) {
            AppMethodBeat.o(110377);
            return;
        }
        long aWB = ((long) cl.aWB()) - (((long) b.dXL()) * com.tencent.mm.plugin.groupsolitaire.c.c.yfK.longValue());
        if (aVar.yfb) {
            aVar.yfc = aWB;
            AppMethodBeat.o(110377);
            return;
        }
        if (aVar.yfc < aWB) {
            aVar.yfb = true;
            aVar.yfc = aWB;
        }
        AppMethodBeat.o(110377);
    }

    private static void b(String str, a aVar) {
        AppMethodBeat.i(110378);
        Log.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "updateActiveChatRoomGroupSolitatire() username:%s", str);
        if (Util.isNullOrNil(str) || aVar == null) {
            AppMethodBeat.o(110378);
            return;
        }
        long aWB = ((long) cl.aWB()) - (((long) b.dXJ()) * com.tencent.mm.plugin.groupsolitaire.c.c.yfJ.longValue());
        if (aVar.yeZ) {
            aVar.yfa = aWB;
            AppMethodBeat.o(110378);
            return;
        }
        if (aVar.yfa < aWB) {
            aVar.yeZ = true;
            aVar.yfa = aWB;
        }
        AppMethodBeat.o(110378);
    }

    private static String aBo(String str) {
        AppMethodBeat.i(110379);
        if (str.length() > 200) {
            str = str.substring(0, 199);
        }
        String messageDigest = com.tencent.mm.b.g.getMessageDigest(str.getBytes());
        AppMethodBeat.o(110379);
        return messageDigest;
    }

    private void dXT() {
        AppMethodBeat.i(110380);
        StringBuilder sb = new StringBuilder();
        Iterator<a> it = this.yfe.iterator();
        while (it.hasNext()) {
            a next = it.next();
            sb.append(next.key).append(",").append(next.ibS).append(";");
        }
        PluginGroupSolitaire.getKV().edit().putString("analyze_crash_content_num", sb.toString());
        AppMethodBeat.o(110380);
    }

    /* access modifiers changed from: package-private */
    public class a {
        int ibS = 0;
        String key = "";

        public a(String str, int i2) {
            this.key = str;
            this.ibS = i2;
        }

        public final int hashCode() {
            AppMethodBeat.i(110367);
            int hashCode = this.key.hashCode();
            AppMethodBeat.o(110367);
            return hashCode;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(110368);
            if (Util.isEqual(this.key, ((a) obj).key)) {
                AppMethodBeat.o(110368);
                return true;
            }
            AppMethodBeat.o(110368);
            return false;
        }
    }
}
