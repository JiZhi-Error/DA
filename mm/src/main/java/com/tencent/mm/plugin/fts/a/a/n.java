package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

public final class n extends m {
    public final n g(Cursor cursor) {
        AppMethodBeat.i(131711);
        this.wXc = cursor.getLong(0);
        this.type = cursor.getInt(1);
        this.wVW = cursor.getInt(2);
        this.wXe = cursor.getLong(3);
        this.wVX = cursor.getString(4);
        this.timestamp = cursor.getLong(5);
        this.talker = cursor.getString(6);
        AppMethodBeat.o(131711);
        return this;
    }

    public final n h(Cursor cursor) {
        AppMethodBeat.i(131712);
        this.wXc = cursor.getLong(0);
        this.type = cursor.getInt(1);
        this.wVW = cursor.getInt(2);
        this.wXe = cursor.getLong(3);
        this.wVX = cursor.getString(4);
        this.timestamp = cursor.getLong(5);
        this.content = cursor.getString(6);
        this.wXg = cursor.getString(7);
        this.wXm = cursor.getLong(8);
        AppMethodBeat.o(131712);
        return this;
    }

    public final n i(Cursor cursor) {
        AppMethodBeat.i(131713);
        this.wXc = cursor.getLong(0);
        this.type = cursor.getInt(1);
        this.wVW = cursor.getInt(2);
        this.wXe = cursor.getLong(3);
        this.wVX = cursor.getString(4);
        this.timestamp = cursor.getLong(5);
        if (cursor.getColumnCount() >= 7) {
            this.content = cursor.getString(6);
        }
        if (cursor.getColumnCount() >= 8) {
            this.wXg = cursor.getString(7);
        }
        AppMethodBeat.o(131713);
        return this;
    }

    private void a(Pattern pattern) {
        int i2 = 0;
        AppMethodBeat.i(131714);
        this.wXj = pattern.split(this.content);
        this.wXk = new int[this.wXj.length];
        for (int i3 = 0; i3 < this.wXk.length; i3++) {
            this.wXk[i3] = i2;
            i2 = this.wXj[i3].length() + 1 + i2;
        }
        AppMethodBeat.o(131714);
    }

    public final void dOC() {
        AppMethodBeat.i(131715);
        if (Util.isNullOrNil(this.wXg)) {
            AppMethodBeat.o(131715);
            return;
        }
        switch (this.type) {
            case 131072:
            case 131073:
            case 131074:
            case 131076:
            case 131081:
            case TPMediaCodecProfileLevel.HEVCMainTierLevel52 /*{ENCODED_INT: 262144}*/:
            case 327680:
                dOE();
                AppMethodBeat.o(131715);
                return;
            case 131075:
                dOD();
                break;
        }
        AppMethodBeat.o(131715);
    }

    private void dOD() {
        int i2;
        AppMethodBeat.i(131716);
        switch (this.wVW) {
            case 38:
                ArrayList arrayList = new ArrayList();
                a(c.a.wVa);
                String[] split = c.a.wUZ.split(this.wXg);
                byte[] bytes = this.content.getBytes();
                for (int i3 = 0; i3 < split.length; i3 += 2) {
                    int intValue = Integer.valueOf(split[i3]).intValue();
                    int length = new String(bytes, 0, Integer.valueOf(split[i3 + 1]).intValue()).length();
                    int binarySearch = Arrays.binarySearch(this.wXk, length);
                    if (binarySearch < 0) {
                        binarySearch = (-binarySearch) - 2;
                    }
                    String str = null;
                    String[] split2 = c.a.wVb.split(this.wXj[binarySearch]);
                    int i4 = length - this.wXk[binarySearch];
                    int i5 = 0;
                    while (true) {
                        if (i5 < split2.length) {
                            i4 = (i4 - split2[i5].length()) - 1;
                            if (i4 < 0) {
                                str = split2[i5];
                                i2 = c.wUS[i5];
                            } else {
                                i5++;
                            }
                        } else {
                            i2 = -1;
                        }
                    }
                    if (i2 > 0) {
                        arrayList.add(new g(binarySearch, intValue, i2, str, split2[split2.length - 1]));
                    }
                }
                this.wXl = arrayList;
                break;
        }
        AppMethodBeat.o(131716);
    }

    private void dOE() {
        AppMethodBeat.i(131717);
        switch (this.wVW) {
            case 2:
            case 3:
            case 6:
            case 7:
                try {
                    String[] split = c.a.wUZ.split(this.wXg);
                    a(c.a.wVd);
                    this.wXh = Arrays.binarySearch(this.wXk, new String(this.content.getBytes(), 0, Integer.valueOf(split[1]).intValue()).length());
                    if (this.wXh < 0) {
                        this.wXh = (-this.wXh) - 2;
                    }
                    this.wXi = this.wXj[this.wXh];
                    AppMethodBeat.o(131717);
                    return;
                } catch (Exception e2) {
                    this.wXh = Integer.MAX_VALUE;
                    this.wXi = "";
                    AppMethodBeat.o(131717);
                    return;
                }
            case 11:
            case 51:
                this.wXh = Integer.MAX_VALUE;
                this.wXi = "";
                AppMethodBeat.o(131717);
                return;
            default:
                try {
                    this.wXh = new String(this.content.getBytes(), 0, Integer.valueOf(c.a.wUZ.split(this.wXg)[1]).intValue()).length();
                    this.wXi = this.content;
                    AppMethodBeat.o(131717);
                    return;
                } catch (Exception e3) {
                    this.wXh = Integer.MAX_VALUE;
                    this.wXi = "";
                    AppMethodBeat.o(131717);
                    return;
                }
        }
    }

    public final void a(h hVar) {
        AppMethodBeat.i(131718);
        if (hVar.wWD.length > 1) {
            this.wXn = 1;
        } else {
            this.wXn = 0;
        }
        if (this.type == 131075) {
            if (System.currentTimeMillis() - this.timestamp < 1209600000) {
                this.wWz += 50;
                String aTY = z.aTY();
                if (this.wVW == 38) {
                    HashSet hashSet = new HashSet();
                    if (this.wXl != null) {
                        for (g gVar : this.wXl) {
                            if (!aTY.equals(gVar.fMb)) {
                                hashSet.add(Integer.valueOf(gVar.wWv));
                            }
                        }
                    }
                    if (((long) hashSet.size()) >= this.wXe - 1) {
                        this.wWz += 20;
                        this.wXo = true;
                    }
                    if (hVar.wWD.length > 1 && this.content.contains(hVar.wWB)) {
                        this.wXn = 2;
                        this.wWz += 5;
                    }
                    if (this.wXe <= 15) {
                        this.wXq = 1;
                    }
                }
                if ((this.wVW == 5 || this.wVW == 1) && this.content.contains(hVar.wWB)) {
                    if (hVar.wWD.length > 1) {
                        this.wXn = 2;
                    }
                    this.wWz += 10;
                }
                AppMethodBeat.o(131718);
                return;
            }
        } else if (this.type == 131072) {
            if (System.currentTimeMillis() - this.timestamp < 1105032704) {
                this.wWz += 50;
            }
            if ((this.wVW == 5 || this.wVW == 1) && this.content.contains(hVar.wWB)) {
                if (hVar.wWD.length > 1) {
                    this.wXn = 2;
                }
                this.wWz += 10;
            }
        }
        AppMethodBeat.o(131718);
    }
}
