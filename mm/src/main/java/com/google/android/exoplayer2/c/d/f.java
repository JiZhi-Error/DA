package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;

/* access modifiers changed from: package-private */
public final class f {
    private static final int bnF = x.bJ("nam");
    private static final int bnG = x.bJ("trk");
    private static final int bnH = x.bJ("cmt");
    private static final int bnI = x.bJ("day");
    private static final int bnJ = x.bJ("ART");
    private static final int bnK = x.bJ("too");
    private static final int bnL = x.bJ("alb");
    private static final int bnM = x.bJ("com");
    private static final int bnN = x.bJ("wrt");
    private static final int bnO = x.bJ("lyr");
    private static final int bnP = x.bJ("gen");
    private static final int bnQ = x.bJ("covr");
    private static final int bnR = x.bJ("gnre");
    private static final int bnS = x.bJ("grp");
    private static final int bnT = x.bJ("disk");
    private static final int bnU = x.bJ("trkn");
    private static final int bnV = x.bJ("tmpo");
    private static final int bnW = x.bJ("cpil");
    private static final int bnX = x.bJ("aART");
    private static final int bnY = x.bJ("sonm");
    private static final int bnZ = x.bJ("soal");
    private static final int boa = x.bJ("soar");
    private static final int bob = x.bJ("soaa");
    private static final int boc = x.bJ("soco");
    private static final int bod = x.bJ("rtng");
    private static final int boe = x.bJ("pgap");
    private static final int bof = x.bJ("sosn");
    private static final int bog = x.bJ("tvsh");
    private static final int boh = x.bJ("----");
    private static final String[] boi = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    static {
        AppMethodBeat.i(92111);
        AppMethodBeat.o(92111);
    }

    private static TextInformationFrame a(int i2, String str, m mVar) {
        AppMethodBeat.i(92106);
        int readInt = mVar.readInt();
        if (mVar.readInt() == a.bmo) {
            mVar.eZ(8);
            TextInformationFrame textInformationFrame = new TextInformationFrame(str, null, mVar.fa(readInt - 16));
            AppMethodBeat.o(92106);
            return textInformationFrame;
        }
        new StringBuilder("Failed to parse text attribute: ").append(a.ee(i2));
        AppMethodBeat.o(92106);
        return null;
    }

    private static Id3Frame a(int i2, String str, m mVar, boolean z, boolean z2) {
        int i3;
        AppMethodBeat.i(92107);
        int p = p(mVar);
        if (z2) {
            i3 = Math.min(1, p);
        } else {
            i3 = p;
        }
        if (i3 < 0) {
            new StringBuilder("Failed to parse uint8 attribute: ").append(a.ee(i2));
            AppMethodBeat.o(92107);
            return null;
        } else if (z) {
            TextInformationFrame textInformationFrame = new TextInformationFrame(str, null, Integer.toString(i3));
            AppMethodBeat.o(92107);
            return textInformationFrame;
        } else {
            CommentFrame commentFrame = new CommentFrame("und", str, Integer.toString(i3));
            AppMethodBeat.o(92107);
            return commentFrame;
        }
    }

    private static TextInformationFrame b(int i2, String str, m mVar) {
        AppMethodBeat.i(92108);
        int readInt = mVar.readInt();
        if (mVar.readInt() == a.bmo && readInt >= 22) {
            mVar.eZ(10);
            int readUnsignedShort = mVar.readUnsignedShort();
            if (readUnsignedShort > 0) {
                String valueOf = String.valueOf(readUnsignedShort);
                int readUnsignedShort2 = mVar.readUnsignedShort();
                if (readUnsignedShort2 > 0) {
                    valueOf = valueOf + FilePathGenerator.ANDROID_DIR_SEP + readUnsignedShort2;
                }
                TextInformationFrame textInformationFrame = new TextInformationFrame(str, null, valueOf);
                AppMethodBeat.o(92108);
                return textInformationFrame;
            }
        }
        new StringBuilder("Failed to parse index/count attribute: ").append(a.ee(i2));
        AppMethodBeat.o(92108);
        return null;
    }

    private static int p(m mVar) {
        AppMethodBeat.i(92110);
        mVar.eZ(4);
        if (mVar.readInt() == a.bmo) {
            mVar.eZ(8);
            int readUnsignedByte = mVar.readUnsignedByte();
            AppMethodBeat.o(92110);
            return readUnsignedByte;
        }
        AppMethodBeat.o(92110);
        return -1;
    }

    public static Metadata.Entry o(m mVar) {
        String str;
        Metadata.Entry entry = null;
        AppMethodBeat.i(92105);
        int readInt = mVar.readInt() + mVar.position;
        int readInt2 = mVar.readInt();
        int i2 = (readInt2 >> 24) & 255;
        if (i2 == 169 || i2 == 65533) {
            int i3 = 16777215 & readInt2;
            try {
                if (i3 == bnH) {
                    int readInt3 = mVar.readInt();
                    if (mVar.readInt() == a.bmo) {
                        mVar.eZ(8);
                        String fa = mVar.fa(readInt3 - 16);
                        entry = new CommentFrame("und", fa, fa);
                    } else {
                        new StringBuilder("Failed to parse comment attribute: ").append(a.ee(readInt2));
                    }
                    return entry;
                } else if (i3 == bnF || i3 == bnG) {
                    TextInformationFrame a2 = a(readInt2, "TIT2", mVar);
                    mVar.setPosition(readInt);
                    AppMethodBeat.o(92105);
                    return a2;
                } else if (i3 == bnM || i3 == bnN) {
                    TextInformationFrame a3 = a(readInt2, "TCOM", mVar);
                    mVar.setPosition(readInt);
                    AppMethodBeat.o(92105);
                    return a3;
                } else if (i3 == bnI) {
                    TextInformationFrame a4 = a(readInt2, "TDRC", mVar);
                    mVar.setPosition(readInt);
                    AppMethodBeat.o(92105);
                    return a4;
                } else if (i3 == bnJ) {
                    TextInformationFrame a5 = a(readInt2, "TPE1", mVar);
                    mVar.setPosition(readInt);
                    AppMethodBeat.o(92105);
                    return a5;
                } else if (i3 == bnK) {
                    TextInformationFrame a6 = a(readInt2, "TSSE", mVar);
                    mVar.setPosition(readInt);
                    AppMethodBeat.o(92105);
                    return a6;
                } else if (i3 == bnL) {
                    TextInformationFrame a7 = a(readInt2, "TALB", mVar);
                    mVar.setPosition(readInt);
                    AppMethodBeat.o(92105);
                    return a7;
                } else if (i3 == bnO) {
                    TextInformationFrame a8 = a(readInt2, "USLT", mVar);
                    mVar.setPosition(readInt);
                    AppMethodBeat.o(92105);
                    return a8;
                } else if (i3 == bnP) {
                    TextInformationFrame a9 = a(readInt2, "TCON", mVar);
                    mVar.setPosition(readInt);
                    AppMethodBeat.o(92105);
                    return a9;
                } else if (i3 == bnS) {
                    TextInformationFrame a10 = a(readInt2, "TIT1", mVar);
                    mVar.setPosition(readInt);
                    AppMethodBeat.o(92105);
                    return a10;
                }
            } finally {
                mVar.setPosition(readInt);
                AppMethodBeat.o(92105);
            }
        } else if (readInt2 == bnR) {
            int p = p(mVar);
            String str2 = (p <= 0 || p > boi.length) ? null : boi[p - 1];
            if (str2 != null) {
                entry = new TextInformationFrame("TCON", null, str2);
            }
            mVar.setPosition(readInt);
            AppMethodBeat.o(92105);
            return entry;
        } else if (readInt2 == bnT) {
            TextInformationFrame b2 = b(readInt2, "TPOS", mVar);
            mVar.setPosition(readInt);
            AppMethodBeat.o(92105);
            return b2;
        } else if (readInt2 == bnU) {
            TextInformationFrame b3 = b(readInt2, "TRCK", mVar);
            mVar.setPosition(readInt);
            AppMethodBeat.o(92105);
            return b3;
        } else if (readInt2 == bnV) {
            Id3Frame a11 = a(readInt2, "TBPM", mVar, true, false);
            mVar.setPosition(readInt);
            AppMethodBeat.o(92105);
            return a11;
        } else if (readInt2 == bnW) {
            Id3Frame a12 = a(readInt2, "TCMP", mVar, true, true);
            mVar.setPosition(readInt);
            AppMethodBeat.o(92105);
            return a12;
        } else if (readInt2 == bnQ) {
            int readInt4 = mVar.readInt();
            if (mVar.readInt() == a.bmo) {
                int ed = a.ed(mVar.readInt());
                if (ed == 13) {
                    str = "image/jpeg";
                } else {
                    str = ed == 14 ? "image/png" : null;
                }
                if (str != null) {
                    mVar.eZ(4);
                    byte[] bArr = new byte[(readInt4 - 16)];
                    mVar.readBytes(bArr, 0, bArr.length);
                    entry = new ApicFrame(str, null, 3, bArr);
                }
            }
            mVar.setPosition(readInt);
            AppMethodBeat.o(92105);
            return entry;
        } else if (readInt2 == bnX) {
            TextInformationFrame a13 = a(readInt2, "TPE2", mVar);
            mVar.setPosition(readInt);
            AppMethodBeat.o(92105);
            return a13;
        } else if (readInt2 == bnY) {
            TextInformationFrame a14 = a(readInt2, "TSOT", mVar);
            mVar.setPosition(readInt);
            AppMethodBeat.o(92105);
            return a14;
        } else if (readInt2 == bnZ) {
            TextInformationFrame a15 = a(readInt2, "TSO2", mVar);
            mVar.setPosition(readInt);
            AppMethodBeat.o(92105);
            return a15;
        } else if (readInt2 == boa) {
            TextInformationFrame a16 = a(readInt2, "TSOA", mVar);
            mVar.setPosition(readInt);
            AppMethodBeat.o(92105);
            return a16;
        } else if (readInt2 == bob) {
            TextInformationFrame a17 = a(readInt2, "TSOP", mVar);
            mVar.setPosition(readInt);
            AppMethodBeat.o(92105);
            return a17;
        } else if (readInt2 == boc) {
            TextInformationFrame a18 = a(readInt2, "TSOC", mVar);
            mVar.setPosition(readInt);
            AppMethodBeat.o(92105);
            return a18;
        } else if (readInt2 == bod) {
            Id3Frame a19 = a(readInt2, "ITUNESADVISORY", mVar, false, false);
            mVar.setPosition(readInt);
            AppMethodBeat.o(92105);
            return a19;
        } else if (readInt2 == boe) {
            Id3Frame a20 = a(readInt2, "ITUNESGAPLESS", mVar, false, true);
            mVar.setPosition(readInt);
            AppMethodBeat.o(92105);
            return a20;
        } else if (readInt2 == bof) {
            TextInformationFrame a21 = a(readInt2, "TVSHOWSORT", mVar);
            mVar.setPosition(readInt);
            AppMethodBeat.o(92105);
            return a21;
        } else if (readInt2 == bog) {
            TextInformationFrame a22 = a(readInt2, "TVSHOW", mVar);
            mVar.setPosition(readInt);
            AppMethodBeat.o(92105);
            return a22;
        } else if (readInt2 == boh) {
            Id3Frame d2 = d(mVar, readInt);
            mVar.setPosition(readInt);
            AppMethodBeat.o(92105);
            return d2;
        }
        new StringBuilder("Skipped unknown metadata entry: ").append(a.ee(readInt2));
        mVar.setPosition(readInt);
        AppMethodBeat.o(92105);
        return null;
    }

    private static Id3Frame d(m mVar, int i2) {
        AppMethodBeat.i(92109);
        int i3 = -1;
        int i4 = -1;
        String str = null;
        String str2 = null;
        while (mVar.position < i2) {
            int i5 = mVar.position;
            int readInt = mVar.readInt();
            int readInt2 = mVar.readInt();
            mVar.eZ(4);
            if (readInt2 == a.bmm) {
                str2 = mVar.fa(readInt - 12);
            } else if (readInt2 == a.bmn) {
                str = mVar.fa(readInt - 12);
            } else {
                if (readInt2 == a.bmo) {
                    i3 = readInt;
                    i4 = i5;
                }
                mVar.eZ(readInt - 12);
            }
        }
        if (!"com.apple.iTunes".equals(str2) || !"iTunSMPB".equals(str) || i4 == -1) {
            AppMethodBeat.o(92109);
            return null;
        }
        mVar.setPosition(i4);
        mVar.eZ(16);
        CommentFrame commentFrame = new CommentFrame("und", str, mVar.fa(i3 - 16));
        AppMethodBeat.o(92109);
        return commentFrame;
    }
}
