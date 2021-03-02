package com.tencent.mm.plugin.music.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.g.b;
import com.tencent.mm.R;
import com.tencent.mm.model.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e {
    private boolean Akm = false;
    public ArrayList<a> Akn = new ArrayList<>();
    private LinkedList<Long> Ako = new LinkedList<>();
    private String Akp;
    private String Akq;
    private String Akr;
    private boolean Aks = false;
    private String album;
    private String lDR;
    private long offset;
    private int sTB = 0;
    private String title;

    public static final class a {
        public boolean Akt;
        public String content;
        public long timestamp;

        public final String toString() {
            AppMethodBeat.i(63002);
            String format = String.format("[%d %s]", Long.valueOf(this.timestamp), this.content);
            AppMethodBeat.o(63002);
            return format;
        }

        public final boolean isEmpty() {
            AppMethodBeat.i(219833);
            boolean eP = b.eP(this.content.trim());
            AppMethodBeat.o(219833);
            return eP;
        }
    }

    public static e a(String str, String str2, String str3, boolean z, String str4, boolean z2, boolean z3) {
        AppMethodBeat.i(219834);
        e eVar = new e();
        long currentTicks = Util.currentTicks();
        if (!Util.isNullOrNil(str)) {
            if (str == null) {
                Log.w("MicroMsg.Music.LyricObj", "parserLrc: but lrc or lrcMgr is null");
            } else {
                Matcher matcher = Pattern.compile("(\\[((\\d{2}:\\d{2}(\\.\\d{2}){0,1}\\])|(al:|ar:|by:|offset:|re:|ti:|ve:))[^\\[]*)").matcher(str.replaceAll("\n", " ").replaceAll("\r", " "));
                while (matcher.find()) {
                    String group = matcher.group();
                    matcher.start();
                    matcher.end();
                    if (group == null) {
                        Log.w("MicroMsg.Music.LyricObj", "parserLine fail: lrcMgr or str is null");
                    } else if (group.startsWith("[ti:")) {
                        eVar.title = iY(group, "[ti:");
                    } else if (group.startsWith("[ar:")) {
                        eVar.lDR = iY(group, "[ar:");
                    } else if (group.startsWith("[al:")) {
                        eVar.album = iY(group, "[al:");
                    } else if (group.startsWith("[by:")) {
                        eVar.Akp = iY(group, "[by:");
                    } else if (group.startsWith("[offset:")) {
                        eVar.offset = Util.getLong(iY(group, "[offset:"), 0);
                    } else if (group.startsWith("[re:")) {
                        eVar.Akq = iY(group, "[re:");
                    } else if (group.startsWith("[ve:")) {
                        eVar.Akr = iY(group, "[ve:");
                    } else {
                        Pattern compile = Pattern.compile("\\[(\\d{2}:\\d{2}(\\.\\d{2}){0,1})\\]");
                        Matcher matcher2 = compile.matcher(group);
                        a aVar = new a();
                        while (true) {
                            if (!matcher2.find()) {
                                break;
                            }
                            if (matcher2.groupCount() > 0) {
                                aVar.timestamp = aHO(matcher2.group(1));
                            }
                            String[] split = compile.split(group);
                            if (split == null || split.length <= 0) {
                                eVar.Ako.add(Long.valueOf(aVar.timestamp));
                            } else {
                                String str5 = split[split.length - 1];
                                if (str5 != null) {
                                    str5 = str5.trim();
                                }
                                if (Util.isNullOrNil(str5)) {
                                    str5 = " ";
                                }
                                aVar.content = str5;
                                for (int i2 = 0; i2 < eVar.Ako.size(); i2++) {
                                    a aVar2 = new a();
                                    aVar2.timestamp = eVar.Ako.get(i2).longValue();
                                    aVar2.content = aVar.content;
                                    aVar2.Akt = true;
                                }
                                eVar.Ako.clear();
                                if (!aVar.isEmpty()) {
                                    int size = eVar.Akn.size() - 1;
                                    while (true) {
                                        if (size < 0 || eVar.Akn.get(size).timestamp == aVar.timestamp) {
                                            break;
                                        } else if (eVar.Akn.get(size).timestamp < aVar.timestamp) {
                                            eVar.Akn.add(size + 1, aVar);
                                            break;
                                        } else {
                                            size--;
                                        }
                                    }
                                    if (size < 0) {
                                        eVar.Akn.add(0, aVar);
                                    }
                                }
                            }
                        }
                    }
                }
                Log.d("MicroMsg.Music.LyricObj", "handle offset %d", Long.valueOf(eVar.offset));
                if (eVar.offset != 0) {
                    for (int i3 = 0; i3 < eVar.Akn.size(); i3++) {
                        eVar.Akn.get(i3).timestamp += eVar.offset;
                    }
                    eVar.offset = 0;
                }
                for (int i4 = 0; i4 < eVar.Akn.size() - 1; i4++) {
                    a aVar3 = eVar.Akn.get(i4);
                    if (aVar3.Akt && aVar3.content.equals(eVar.Akn.get(i4 + 1).content)) {
                        aVar3.content = " ";
                    }
                }
            }
            Log.d("MicroMsg.Music.LyricObj", "getLrcMgr beg: src lrc = %s", str);
            Log.d("MicroMsg.Music.LyricObj", "parse finish: sentence size [%d], result:", Integer.valueOf(eVar.Akn.size()));
            eVar.Akm = true;
        } else {
            a aVar4 = new a();
            aVar4.timestamp = 0;
            if (z2) {
                aVar4.content = str4;
            } else if (!z) {
                aVar4.content = MMApplicationContext.getContext().getString(R.string.fdr);
            } else {
                aVar4.content = "";
            }
            if (aVar4.content != null) {
                eVar.Akn.add(aVar4);
            }
            eVar.Akm = false;
        }
        if (z3) {
            if (Util.isNullOrNil(str3)) {
                Log.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
            } else {
                a aVar5 = new a();
                aVar5.timestamp = 0;
                aVar5.content = MMApplicationContext.getContext().getString(R.string.hug, aa.getDisplayName(str3));
                if (eVar.Akn.isEmpty()) {
                    eVar.Akn.add(aVar5);
                } else if (eVar.Akn.size() == 1) {
                    eVar.Akn.add(0, aVar5);
                    eVar.Akn.get(1).timestamp = 5000;
                } else {
                    eVar.Akn.add(0, aVar5);
                    eVar.Akn.get(1).timestamp = 3 * (eVar.Akn.get(2).timestamp >> 2);
                }
            }
        }
        if (!Util.isNullOrNil(str) && z3) {
            if (Util.isNullOrNil(str2)) {
                Log.w("MicroMsg.Music.LyricObj", "add lyric prefix: but prefix is empty, return");
            } else {
                a aVar6 = new a();
                aVar6.timestamp = 0;
                aVar6.content = str2;
                if (eVar.Akn.isEmpty()) {
                    eVar.Akn.add(aVar6);
                } else if (eVar.Akn.size() == 1) {
                    eVar.Akn.add(0, aVar6);
                    eVar.Akn.get(1).timestamp = 5000;
                } else {
                    eVar.Akn.add(0, aVar6);
                    eVar.Akn.get(1).timestamp = 3 * (eVar.Akn.get(2).timestamp >> 2);
                }
            }
        }
        Log.d("MicroMsg.Music.LyricObj", "getLrcMgr finish: use %d ms", Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(219834);
        return eVar;
    }

    private static String iY(String str, String str2) {
        AppMethodBeat.i(63004);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2)) {
            AppMethodBeat.o(63004);
            return str;
        } else if (str2.length() >= str.length() - 1) {
            AppMethodBeat.o(63004);
            return "";
        } else {
            String substring = str.substring(str2.length(), str.length() - 1);
            Log.d("MicroMsg.Music.LyricObj", "str[%s] prefix[%s] attr[%s]", str, str2, substring);
            AppMethodBeat.o(63004);
            return substring;
        }
    }

    private static long aHO(String str) {
        int i2;
        int i3;
        AppMethodBeat.i(63005);
        try {
            String[] split = str.split(":");
            int cL = m.cL(split[0]);
            if (split.length > 1) {
                String[] split2 = split[1].split("\\.");
                i3 = m.cL(split2[0]);
                i2 = split2.length > 1 ? m.cL(split2[1]) : 0;
            } else {
                i2 = 0;
                i3 = 0;
            }
            long j2 = ((long) (i2 * 10)) + ((long) (i3 * 1000)) + (((long) cL) * 60 * 1000);
            AppMethodBeat.o(63005);
            return j2;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Music.LyricObj", e2, "", new Object[0]);
            Log.w("MicroMsg.Music.LyricObj", "strToLong error: %s", e2.getLocalizedMessage());
            AppMethodBeat.o(63005);
            return 0;
        }
    }

    public final a SQ(int i2) {
        AppMethodBeat.i(63006);
        if (i2 < 0 || i2 >= this.Akn.size()) {
            AppMethodBeat.o(63006);
            return null;
        }
        a aVar = this.Akn.get(i2);
        AppMethodBeat.o(63006);
        return aVar;
    }

    public final int euw() {
        AppMethodBeat.i(219835);
        int size = this.Akn.size();
        AppMethodBeat.o(219835);
        return size;
    }

    public final int Hp(long j2) {
        AppMethodBeat.i(219836);
        if (this.Akn.isEmpty()) {
            Log.w("MicroMsg.Music.LyricObj", "getCurIndex: but sentence list is empty");
            AppMethodBeat.o(219836);
            return -1;
        }
        if (this.Akn.get(this.sTB).timestamp <= j2) {
            int size = this.Akn.size() - 1;
            for (int i2 = this.sTB; i2 < size; i2++) {
                if (this.Akn.get(i2).timestamp <= j2 && j2 < this.Akn.get(i2 + 1).timestamp) {
                    this.sTB = i2;
                    int i3 = this.sTB;
                    AppMethodBeat.o(219836);
                    return i3;
                }
            }
            this.sTB = size;
        } else {
            for (int i4 = this.sTB; i4 > 0; i4--) {
                if (this.Akn.get(i4).timestamp >= j2 && j2 > this.Akn.get(i4 - 1).timestamp) {
                    this.sTB = i4 - 1;
                    int i5 = this.sTB;
                    AppMethodBeat.o(219836);
                    return i5;
                }
            }
            this.sTB = 0;
        }
        Log.d("MicroMsg.Music.LyricObj", "curIndex %d", Integer.valueOf(this.sTB));
        int i6 = this.sTB;
        AppMethodBeat.o(219836);
        return i6;
    }

    private e() {
        AppMethodBeat.i(63007);
        AppMethodBeat.o(63007);
    }
}
