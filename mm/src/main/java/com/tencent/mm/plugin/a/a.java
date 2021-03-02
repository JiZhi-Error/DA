package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a {
    public static final int bkJ = c.bJ("ftyp");
    public static final int bkK = c.bJ("avc1");
    public static final int bkL = c.bJ("avc3");
    public static final int bkM = c.bJ("hvc1");
    public static final int bkN = c.bJ("hev1");
    public static final int bkO = c.bJ("s263");
    public static final int bkP = c.bJ("d263");
    public static final int bkQ = c.bJ("mdat");
    public static final int bkR = c.bJ("mp4a");
    public static final int bkT = c.bJ("wave");
    public static final int bkW = c.bJ("ac-3");
    public static final int bkX = c.bJ("dac3");
    public static final int bkY = c.bJ("ec-3");
    public static final int bkZ = c.bJ("dec3");
    public static final int blA = c.bJ("mdhd");
    public static final int blB = c.bJ("hdlr");
    public static final int blC = c.bJ("stsd");
    public static final int blD = c.bJ("pssh");
    public static final int blE = c.bJ("sinf");
    public static final int blF = c.bJ("schm");
    public static final int blG = c.bJ("schi");
    public static final int blH = c.bJ("tenc");
    public static final int blI = c.bJ("encv");
    public static final int blJ = c.bJ("enca");
    public static final int blK = c.bJ("frma");
    public static final int blL = c.bJ("saiz");
    public static final int blM = c.bJ("saio");
    public static final int blP = c.bJ("uuid");
    public static final int blQ = c.bJ("senc");
    public static final int blR = c.bJ("pasp");
    public static final int blS = c.bJ("TTML");
    public static final int blT = c.bJ("vmhd");
    public static final int blU = c.bJ("mp4v");
    public static final int blV = c.bJ("stts");
    public static final int blW = c.bJ("stss");
    public static final int blX = c.bJ("ctts");
    public static final int blY = c.bJ("stsc");
    public static final int blZ = c.bJ("stsz");
    public static final int bla = c.bJ("dtsc");
    public static final int blb = c.bJ("dtsh");
    public static final int blc = c.bJ("dtsl");
    public static final int bld = c.bJ("dtse");
    public static final int ble = c.bJ("ddts");
    public static final int blf = c.bJ("tfdt");
    public static final int blg = c.bJ("tfhd");
    public static final int blh = c.bJ("trex");
    public static final int bli = c.bJ("trun");
    public static final int blj = c.bJ("sidx");
    public static final int blk = c.bJ("moov");
    public static final int bll = c.bJ("mvhd");
    public static final int blm = c.bJ("trak");
    public static final int bln = c.bJ("mdia");
    public static final int blo = c.bJ("minf");
    public static final int blp = c.bJ("stbl");
    public static final int blq = c.bJ("avcC");
    public static final int blr = c.bJ("hvcC");
    public static final int bls = c.bJ("esds");
    public static final int blt = c.bJ("moof");
    public static final int blu = c.bJ("traf");
    public static final int blv = c.bJ("mvex");
    public static final int blx = c.bJ("tkhd");
    public static final int bly = c.bJ("edts");
    public static final int blz = c.bJ("elst");
    public static final int bmb = c.bJ("stco");
    public static final int bmc = c.bJ("co64");
    public static final int bmd = c.bJ("tx3g");
    public static final int bme = c.bJ("wvtt");
    public static final int bmf = c.bJ("stpp");
    public static final int bmh = c.bJ("samr");
    public static final int bmi = c.bJ("sawb");
    public static final int bmj = c.bJ("udta");
    public static final int bmk = c.bJ("meta");
    public static final int bml = c.bJ("ilst");
    public static final int bmm = c.bJ("mean");
    public static final int bmn = c.bJ("name");
    public static final int bmo = c.bJ("data");
    public static final int jPS = c.bJ("----");
    private int jPT;
    private long jPU;
    public long jPV;
    private int type;

    static {
        AppMethodBeat.i(133849);
        AppMethodBeat.o(133849);
    }

    public a(int i2, long j2, int i3, long j3) {
        this.jPT = i2;
        this.jPV = j2;
        this.type = i3;
        this.jPU = j3;
    }

    public final boolean blO() {
        return this.type == blk;
    }

    public final boolean blP() {
        return this.jPT == 0;
    }

    public final long blQ() {
        return this.jPV;
    }

    public final long getEndPos() {
        AppMethodBeat.i(133847);
        long size = this.jPV + getSize();
        AppMethodBeat.o(133847);
        return size;
    }

    public final long getSize() {
        if (this.jPU > 0) {
            return this.jPU;
        }
        return (long) this.jPT;
    }

    public String toString() {
        AppMethodBeat.i(133848);
        StringBuilder append = new StringBuilder("Atom{atomSize=").append(this.jPT).append(", atomLargeSize=").append(this.jPU).append(", type=");
        int i2 = this.type;
        String sb = append.append(new String(new byte[]{(byte) ((i2 >> 24) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 8) & 255), (byte) (i2 & 255)})).append(", beginPos=").append(this.jPV).append('}').toString();
        AppMethodBeat.o(133848);
        return sb;
    }
}
