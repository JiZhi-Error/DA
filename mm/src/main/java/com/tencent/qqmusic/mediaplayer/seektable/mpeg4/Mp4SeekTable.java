package com.tencent.qqmusic.mediaplayer.seektable.mpeg4;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;
import com.tencent.qqmusic.mediaplayer.seektable.ParsableInputStreamWrapper;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Co64;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.GhostBox;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.IMpeg4Box;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Mdhd;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Stco;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Stsc;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Stsz;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Stts;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Mp4SeekTable implements SeekTable {
    private final Map<String, IMpeg4Box> essentialStblChunkMap = new HashMap();
    private final Mdhd mdhd;

    /* access modifiers changed from: package-private */
    public interface Function1<T, R> {
        R call(T t);
    }

    static /* synthetic */ boolean access$000(HashSet hashSet) {
        AppMethodBeat.i(114261);
        boolean needMoreChunks = needMoreChunks(hashSet);
        AppMethodBeat.o(114261);
        return needMoreChunks;
    }

    public Mp4SeekTable() {
        AppMethodBeat.i(114249);
        this.essentialStblChunkMap.put("stco", new Stco());
        this.essentialStblChunkMap.put("co64", new Co64());
        this.essentialStblChunkMap.put("stts", new Stts());
        this.essentialStblChunkMap.put("stsc", new Stsc());
        this.essentialStblChunkMap.put("stsz", new Stsz());
        this.mdhd = new Mdhd();
        AppMethodBeat.o(114249);
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.SeekTable
    public void parse(IDataSource iDataSource) {
        AppMethodBeat.i(114250);
        ParsableInputStreamWrapper parsableInputStreamWrapper = new ParsableInputStreamWrapper(iDataSource);
        if (seekTo(parsableInputStreamWrapper, "moov.trak.mdia") == null) {
            InvalidBoxException invalidBoxException = new InvalidBoxException("invalid mp4: no [mdia] was found!");
            AppMethodBeat.o(114250);
            throw invalidBoxException;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("mdhd", this.mdhd);
        hashMap.put("minf", new GhostBox());
        parseChunks(parsableInputStreamWrapper, hashMap, null);
        if (seekTo(parsableInputStreamWrapper, "stbl") == null) {
            InvalidBoxException invalidBoxException2 = new InvalidBoxException("invalid mp4: no [stbl] was found!");
            AppMethodBeat.o(114250);
            throw invalidBoxException2;
        }
        parseChunks(parsableInputStreamWrapper, this.essentialStblChunkMap, new Function1<HashSet<String>, Boolean>() {
            /* class com.tencent.qqmusic.mediaplayer.seektable.mpeg4.Mp4SeekTable.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.qqmusic.mediaplayer.seektable.mpeg4.Mp4SeekTable.Function1
            public /* bridge */ /* synthetic */ Boolean call(HashSet<String> hashSet) {
                AppMethodBeat.i(114270);
                Boolean call = call(hashSet);
                AppMethodBeat.o(114270);
                return call;
            }

            public Boolean call(HashSet<String> hashSet) {
                AppMethodBeat.i(114269);
                Boolean valueOf = Boolean.valueOf(Mp4SeekTable.access$000(hashSet));
                AppMethodBeat.o(114269);
                return valueOf;
            }
        });
        AppMethodBeat.o(114250);
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.SeekTable
    public long seek(long j2) {
        AppMethodBeat.i(114251);
        long seekInternal = seekInternal((int) Math.round(((double) (((long) this.mdhd.getTimeScale()) * j2)) / 1000.0d));
        AppMethodBeat.o(114251);
        return seekInternal;
    }

    private long seekInternal(int i2) {
        long offset64OfChunk;
        AppMethodBeat.i(114252);
        int[] iArr = new int[2];
        int sampleOfTime = sampleOfTime((Stts) this.essentialStblChunkMap.get("stts"), i2);
        chunkOfSample((Stsc) this.essentialStblChunkMap.get("stsc"), sampleOfTime, iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        if (this.essentialStblChunkMap.get("stco").getSize() != 0) {
            offset64OfChunk = (long) offsetOfChunk((Stco) this.essentialStblChunkMap.get("stco"), i3);
        } else if (this.essentialStblChunkMap.get("co64").getSize() != 0) {
            offset64OfChunk = offset64OfChunk((Co64) this.essentialStblChunkMap.get("co64"), i3);
        } else {
            RuntimeException runtimeException = new RuntimeException("invalid stbl: both [stco] nor [co64] was found!");
            AppMethodBeat.o(114252);
            throw runtimeException;
        }
        long offsetOfSampleInChunk = ((long) offsetOfSampleInChunk((Stsz) this.essentialStblChunkMap.get("stsz"), sampleOfTime, i4)) + offset64OfChunk;
        AppMethodBeat.o(114252);
        return offsetOfSampleInChunk;
    }

    private static void chunkOfSample(Stsc stsc, int i2, int[] iArr) {
        boolean z;
        int i3;
        int i4;
        AppMethodBeat.i(114253);
        int entryCount = stsc.getEntryCount();
        int i5 = 0;
        int i6 = 1;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            int i9 = stsc.getFirstChunk()[i8];
            int i10 = (i9 - i6) * i5;
            if (i2 < i7 + i10) {
                z = true;
                i3 = i5;
                break;
            }
            i5 = stsc.getSamplesPerChunk()[i8];
            if (i8 < entryCount) {
                i8++;
                i7 += i10;
            }
            if (i8 >= entryCount) {
                z = false;
                i3 = i5;
                i6 = i9;
                break;
            }
            i6 = i9;
        }
        if (i3 == 0) {
            i4 = 1;
        } else if (z) {
            i4 = ((i2 - i7) / i3) + i6;
        } else {
            i4 = i6;
        }
        iArr[0] = i4;
        iArr[1] = ((i4 - i6) * i3) + i7;
        AppMethodBeat.o(114253);
    }

    private static int offsetOfChunk(Stco stco, int i2) {
        AppMethodBeat.i(114254);
        if (i2 > stco.getEntryCount()) {
            int i3 = stco.getChunkOffset()[stco.getEntryCount() - 1];
            AppMethodBeat.o(114254);
            return i3;
        } else if (stco.getEntryCount() > 0) {
            int i4 = stco.getChunkOffset()[i2 - 1];
            AppMethodBeat.o(114254);
            return i4;
        } else {
            AppMethodBeat.o(114254);
            return 8;
        }
    }

    private static long offset64OfChunk(Co64 co64, int i2) {
        AppMethodBeat.i(114255);
        if (i2 > co64.getEntryCount()) {
            long j2 = co64.getChunkOffset()[co64.getEntryCount() - 1];
            AppMethodBeat.o(114255);
            return j2;
        } else if (co64.getEntryCount() > 0) {
            long j3 = co64.getChunkOffset()[i2 - 1];
            AppMethodBeat.o(114255);
            return j3;
        } else {
            AppMethodBeat.o(114255);
            return 8;
        }
    }

    private static int offsetOfSampleInChunk(Stsz stsz, int i2, int i3) {
        AppMethodBeat.i(114256);
        if (stsz.getSampleSize() != 0) {
            int sampleSize = (i2 - i3) * stsz.getSampleSize();
            AppMethodBeat.o(114256);
            return sampleSize;
        }
        int i4 = 0;
        int min = Math.min(i2, stsz.getSampleCount());
        while (i3 < min) {
            i4 += stsz.getEntrySize()[i3];
            i3++;
        }
        AppMethodBeat.o(114256);
        return i4;
    }

    private static int sampleOfTime(Stts stts, int i2) {
        boolean z = false;
        AppMethodBeat.i(114257);
        int entryCount = stts.getEntryCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i3 >= entryCount) {
                break;
            }
            i5 = stts.getSampleDelta()[i3];
            int i6 = stts.getSampleCount()[i3];
            int i7 = i6 * i5;
            if (i2 < i7) {
                z = true;
                break;
            }
            i2 -= i7;
            i4 += i6;
            i3++;
        }
        if (z) {
            int i8 = i4 + (i2 / i5);
            AppMethodBeat.o(114257);
            return i8;
        }
        AppMethodBeat.o(114257);
        return i4;
    }

    private static IMpeg4Box seekTo(Parsable parsable, String str) {
        AppMethodBeat.i(114258);
        GhostBox ghostBox = new GhostBox();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        GhostBox ghostBox2 = null;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            boolean z = false;
            while (true) {
                if (z || parsable.available() <= 0) {
                    break;
                }
                ghostBox.parse(parsable, null);
                if (!nextToken.equalsIgnoreCase(ghostBox.getType())) {
                    parsable.skip(ghostBox.getSize() - 8);
                } else {
                    z = true;
                    if (!stringTokenizer.hasMoreTokens()) {
                        ghostBox2 = ghostBox;
                        break;
                    }
                }
            }
        }
        AppMethodBeat.o(114258);
        return ghostBox2;
    }

    private static void parseChunks(Parsable parsable, Map<String, IMpeg4Box> map, Function1<HashSet<String>, Boolean> function1) {
        AppMethodBeat.i(114259);
        GhostBox ghostBox = new GhostBox();
        HashSet<String> hashSet = new HashSet<>(map.keySet());
        while (true) {
            if ((function1 == null || function1.call(hashSet).booleanValue()) && hashSet.size() != 0 && parsable.available() > 0) {
                ghostBox.parse(parsable, null);
                String type = ghostBox.getType();
                IMpeg4Box iMpeg4Box = map.get(type);
                if (iMpeg4Box == null) {
                    parsable.skip(ghostBox.getSize() - 8);
                } else {
                    iMpeg4Box.parse(parsable, ghostBox);
                    hashSet.remove(type);
                }
            }
        }
        if (function1 == null || !function1.call(hashSet).booleanValue()) {
            AppMethodBeat.o(114259);
            return;
        }
        InvalidBoxException invalidBoxException = new InvalidBoxException("invalid box: critical box not found!");
        AppMethodBeat.o(114259);
        throw invalidBoxException;
    }

    private static boolean needMoreChunks(HashSet<String> hashSet) {
        AppMethodBeat.i(114260);
        if (hashSet.size() > 2) {
            AppMethodBeat.o(114260);
            return true;
        } else if (!hashSet.contains("stco") || !hashSet.contains("co64")) {
            AppMethodBeat.o(114260);
            return false;
        } else {
            AppMethodBeat.o(114260);
            return true;
        }
    }
}
