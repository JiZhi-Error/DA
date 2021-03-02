package com.tencent.mm.plugin.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a {
    private int scene;
    public List<String> xhA;
    public List<String> xhB;
    public List<String> xhC;
    public HashMap<String, Integer> xhD;
    public int xhq;
    public int xhr;
    public int xhs;
    private int xht;
    private int xhu;
    private int xhv;
    private int xhw;
    private int xhx;
    public List<String> xhy;
    public List<String> xhz;

    /* synthetic */ a(byte b2) {
        this();
    }

    private a() {
        AppMethodBeat.i(111226);
        this.xhy = new ArrayList(9);
        this.xhz = new ArrayList(9);
        this.xhA = new ArrayList(9);
        this.xhB = new ArrayList(9);
        this.xhC = new ArrayList(9);
        this.xhD = new HashMap<>(9);
        AppMethodBeat.o(111226);
    }

    /* renamed from: com.tencent.mm.plugin.gallery.a$a  reason: collision with other inner class name */
    public static class C1384a {
        public static a xhE = new a((byte) 0);

        static {
            AppMethodBeat.i(111225);
            AppMethodBeat.o(111225);
        }
    }

    public static a dQq() {
        return C1384a.xhE;
    }

    public final void al(String str, int i2, int i3) {
        boolean z = true;
        AppMethodBeat.i(173726);
        if (i2 < 0 || i2 > 4) {
            Log.e("MicroMsg.GalleryReporter", "type error, %d.", Integer.valueOf(i2));
            AppMethodBeat.o(173726);
        } else if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.GalleryReporter", "path is invalid!");
            AppMethodBeat.o(173726);
        } else {
            Log.i("MicroMsg.GalleryReporter", "type: %d, path: %s.", Integer.valueOf(i2), str);
            if (this.xhy.contains(str)) {
                this.xhy.remove(str);
                Log.i("MicroMsg.GalleryReporter", "sendCountFromSearchUnOCRList, remove.");
            } else if (this.xhz.contains(str)) {
                this.xhz.remove(str);
                Log.i("MicroMsg.GalleryReporter", "sendCountFromSearchOCRList, remove.");
            } else if (this.xhA.contains(str)) {
                this.xhA.remove(str);
                Log.i("MicroMsg.GalleryReporter", "sendCountFromClassifyList, remove.");
            } else if (this.xhB.contains(str)) {
                this.xhB.remove(str);
                Log.i("MicroMsg.GalleryReporter", "sendCountFromDefaultList, remove.");
            } else if (this.xhC.contains(str)) {
                this.xhC.remove(str);
                Log.i("MicroMsg.GalleryReporter", "sendCountFromOtherList, remove.");
            } else {
                Log.i("MicroMsg.GalleryReporter", "add!!!");
                switch (i2) {
                    case 0:
                        this.xhy.add(str);
                        break;
                    case 1:
                        this.xhz.add(str);
                        break;
                    case 2:
                        this.xhA.add(str);
                        break;
                    case 3:
                        this.xhB.add(str);
                        break;
                    case 4:
                        this.xhC.add(str);
                        break;
                }
                this.xhD.put(str, Integer.valueOf(i3));
                z = false;
            }
            if (z) {
                this.xhD.remove(str);
            }
            AppMethodBeat.o(173726);
        }
    }

    public final void setScene(int i2) {
        switch (i2) {
            case 4:
                this.scene = 2;
                return;
            case 5:
                this.scene = 11;
                return;
            case 6:
            case 9:
            case 10:
            case 12:
            case 15:
            case 23:
            default:
                this.scene = i2;
                return;
            case 7:
            case 8:
                this.scene = 3;
                return;
            case 11:
                this.scene = 12;
                return;
            case 13:
                this.scene = 6;
                return;
            case 14:
            case 22:
                this.scene = 8;
                return;
            case 16:
                this.scene = 10;
                return;
            case 17:
                this.scene = 5;
                return;
            case 18:
                this.scene = 9;
                return;
            case 19:
                this.scene = 13;
                return;
            case 20:
                this.scene = 14;
                return;
            case 21:
                this.scene = 15;
                return;
            case 24:
                this.scene = 16;
                return;
        }
    }

    public final void reset() {
        AppMethodBeat.i(173727);
        this.scene = 0;
        this.xhq = 0;
        this.xhr = 0;
        this.xhs = 0;
        this.xht = 0;
        this.xhu = 0;
        this.xhv = 0;
        this.xhw = 0;
        this.xhx = 0;
        this.xhy.clear();
        this.xhz.clear();
        this.xhA.clear();
        this.xhB.clear();
        this.xhC.clear();
        this.xhD.clear();
        AppMethodBeat.o(173727);
    }

    public final void report() {
        AppMethodBeat.i(173728);
        this.xht = this.xhy.size();
        this.xhu = this.xhz.size();
        this.xhv = this.xhA.size();
        this.xhw = this.xhB.size();
        this.xhx = this.xhC.size();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : this.xhD.entrySet()) {
            sb.append(entry.getValue()).append("|");
        }
        Log.d("MicroMsg.GalleryReporter", "poiStr: %s.", sb);
        h.INSTANCE.a(18077, Integer.valueOf(this.scene), Integer.valueOf(this.xhq), Integer.valueOf(this.xhr), Integer.valueOf(this.xhs), Integer.valueOf(this.xht), Integer.valueOf(this.xhu), Integer.valueOf(this.xhv), Integer.valueOf(this.xhw), Integer.valueOf(this.xhx), sb);
        reset();
        AppMethodBeat.o(173728);
    }
}
