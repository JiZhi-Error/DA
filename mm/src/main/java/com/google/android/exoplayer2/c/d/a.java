package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* access modifiers changed from: package-private */
public abstract class a {
    public static final int bkJ = x.bJ("ftyp");
    public static final int bkK = x.bJ("avc1");
    public static final int bkL = x.bJ("avc3");
    public static final int bkM = x.bJ("hvc1");
    public static final int bkN = x.bJ("hev1");
    public static final int bkO = x.bJ("s263");
    public static final int bkP = x.bJ("d263");
    public static final int bkQ = x.bJ("mdat");
    public static final int bkR = x.bJ("mp4a");
    public static final int bkS = x.bJ(".mp3");
    public static final int bkT = x.bJ("wave");
    public static final int bkU = x.bJ("lpcm");
    public static final int bkV = x.bJ("sowt");
    public static final int bkW = x.bJ("ac-3");
    public static final int bkX = x.bJ("dac3");
    public static final int bkY = x.bJ("ec-3");
    public static final int bkZ = x.bJ("dec3");
    public static final int blA = x.bJ("mdhd");
    public static final int blB = x.bJ("hdlr");
    public static final int blC = x.bJ("stsd");
    public static final int blD = x.bJ("pssh");
    public static final int blE = x.bJ("sinf");
    public static final int blF = x.bJ("schm");
    public static final int blG = x.bJ("schi");
    public static final int blH = x.bJ("tenc");
    public static final int blI = x.bJ("encv");
    public static final int blJ = x.bJ("enca");
    public static final int blK = x.bJ("frma");
    public static final int blL = x.bJ("saiz");
    public static final int blM = x.bJ("saio");
    public static final int blN = x.bJ("sbgp");
    public static final int blO = x.bJ("sgpd");
    public static final int blP = x.bJ("uuid");
    public static final int blQ = x.bJ("senc");
    public static final int blR = x.bJ("pasp");
    public static final int blS = x.bJ("TTML");
    public static final int blT = x.bJ("vmhd");
    public static final int blU = x.bJ("mp4v");
    public static final int blV = x.bJ("stts");
    public static final int blW = x.bJ("stss");
    public static final int blX = x.bJ("ctts");
    public static final int blY = x.bJ("stsc");
    public static final int blZ = x.bJ("stsz");
    public static final int bla = x.bJ("dtsc");
    public static final int blb = x.bJ("dtsh");
    public static final int blc = x.bJ("dtsl");
    public static final int bld = x.bJ("dtse");
    public static final int ble = x.bJ("ddts");
    public static final int blf = x.bJ("tfdt");
    public static final int blg = x.bJ("tfhd");
    public static final int blh = x.bJ("trex");
    public static final int bli = x.bJ("trun");
    public static final int blj = x.bJ("sidx");
    public static final int blk = x.bJ("moov");
    public static final int bll = x.bJ("mvhd");
    public static final int blm = x.bJ("trak");
    public static final int bln = x.bJ("mdia");
    public static final int blo = x.bJ("minf");
    public static final int blp = x.bJ("stbl");
    public static final int blq = x.bJ("avcC");
    public static final int blr = x.bJ("hvcC");
    public static final int bls = x.bJ("esds");
    public static final int blt = x.bJ("moof");
    public static final int blu = x.bJ("traf");
    public static final int blv = x.bJ("mvex");
    public static final int blw = x.bJ("mehd");
    public static final int blx = x.bJ("tkhd");
    public static final int bly = x.bJ("edts");
    public static final int blz = x.bJ("elst");
    public static final int bma = x.bJ("stz2");
    public static final int bmb = x.bJ("stco");
    public static final int bmc = x.bJ("co64");
    public static final int bmd = x.bJ("tx3g");
    public static final int bme = x.bJ("wvtt");
    public static final int bmf = x.bJ("stpp");
    public static final int bmg = x.bJ("c608");
    public static final int bmh = x.bJ("samr");
    public static final int bmi = x.bJ("sawb");
    public static final int bmj = x.bJ("udta");
    public static final int bmk = x.bJ("meta");
    public static final int bml = x.bJ("ilst");
    public static final int bmm = x.bJ("mean");
    public static final int bmn = x.bJ("name");
    public static final int bmo = x.bJ("data");
    public static final int bmp = x.bJ("emsg");
    public static final int bmq = x.bJ("st3d");
    public static final int bmr = x.bJ("sv3d");
    public static final int bms = x.bJ("proj");
    public static final int bmt = x.bJ("vp08");
    public static final int bmu = x.bJ("vp09");
    public static final int bmv = x.bJ("vpcC");
    public static final int bmw = x.bJ("camm");
    public static final int bmx = x.bJ("alac");
    public final int type;

    public a(int i2) {
        this.type = i2;
    }

    public String toString() {
        return ee(this.type);
    }

    /* access modifiers changed from: package-private */
    public static final class b extends a {
        public final m bmB;

        public b(int i2, m mVar) {
            super(i2);
            this.bmB = mVar;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.google.android.exoplayer2.c.d.a$a  reason: collision with other inner class name */
    public static final class C0101a extends a {
        public final List<C0101a> bmA = new ArrayList();
        public final long bmy;
        public final List<b> bmz = new ArrayList();

        public C0101a(int i2, long j2) {
            super(i2);
            AppMethodBeat.i(92050);
            this.bmy = j2;
            AppMethodBeat.o(92050);
        }

        public final void a(b bVar) {
            AppMethodBeat.i(92051);
            this.bmz.add(bVar);
            AppMethodBeat.o(92051);
        }

        public final void a(C0101a aVar) {
            AppMethodBeat.i(92052);
            this.bmA.add(aVar);
            AppMethodBeat.o(92052);
        }

        public final b ef(int i2) {
            AppMethodBeat.i(92053);
            int size = this.bmz.size();
            for (int i3 = 0; i3 < size; i3++) {
                b bVar = this.bmz.get(i3);
                if (bVar.type == i2) {
                    AppMethodBeat.o(92053);
                    return bVar;
                }
            }
            AppMethodBeat.o(92053);
            return null;
        }

        public final C0101a eg(int i2) {
            AppMethodBeat.i(92054);
            int size = this.bmA.size();
            for (int i3 = 0; i3 < size; i3++) {
                C0101a aVar = this.bmA.get(i3);
                if (aVar.type == i2) {
                    AppMethodBeat.o(92054);
                    return aVar;
                }
            }
            AppMethodBeat.o(92054);
            return null;
        }

        @Override // com.google.android.exoplayer2.c.d.a
        public final String toString() {
            AppMethodBeat.i(92055);
            String str = ee(this.type) + " leaves: " + Arrays.toString(this.bmz.toArray()) + " containers: " + Arrays.toString(this.bmA.toArray());
            AppMethodBeat.o(92055);
            return str;
        }
    }

    public static int ec(int i2) {
        return (i2 >> 24) & 255;
    }

    public static int ed(int i2) {
        return 16777215 & i2;
    }

    public static String ee(int i2) {
        return new StringBuilder().append((char) ((i2 >> 24) & 255)).append((char) ((i2 >> 16) & 255)).append((char) ((i2 >> 8) & 255)).append((char) (i2 & 255)).toString();
    }
}
