package com.tencent.qqmusic.mediaplayer.seektable.mp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.mp3.Mp3FrameInfoParse;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;

public class Mp3SeekTable implements SeekTable {
    private final Mp3FrameInfoParse.Mp3Info mInfo = new Mp3FrameInfoParse.Mp3Info();

    public Mp3SeekTable() {
        AppMethodBeat.i(114237);
        AppMethodBeat.o(114237);
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.SeekTable
    public void parse(IDataSource iDataSource) {
        AppMethodBeat.i(114238);
        Mp3FrameInfoParse.parseFrameInfo(new TrackPositionDataSource(iDataSource), this.mInfo);
        AppMethodBeat.o(114238);
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.SeekTable
    public long seek(long j2) {
        AppMethodBeat.i(114239);
        if (j2 < 0) {
            AppMethodBeat.o(114239);
            return -1;
        }
        switch (this.mInfo.VBRType) {
            case 0:
                long timeToBytePositionInCbr = timeToBytePositionInCbr(this.mInfo, j2);
                AppMethodBeat.o(114239);
                return timeToBytePositionInCbr;
            case 1:
                long timeToBytePositionInVBRIVbr = timeToBytePositionInVBRIVbr(this.mInfo, j2);
                AppMethodBeat.o(114239);
                return timeToBytePositionInVBRIVbr;
            case 2:
                long timeToBytePositionInXingVbr = timeToBytePositionInXingVbr(this.mInfo, j2);
                AppMethodBeat.o(114239);
                return timeToBytePositionInXingVbr;
            default:
                AppMethodBeat.o(114239);
                return -1;
        }
    }

    private static long timeToBytePositionInCbr(Mp3FrameInfoParse.Mp3Info mp3Info, long j2) {
        if (mp3Info == null || mp3Info.bit_rate <= 0 || j2 < 0) {
            return -1;
        }
        long j3 = ((long) (mp3Info.bit_rate / 8)) * j2;
        if (mp3Info.idv2Size > 0) {
            return j3 + ((long) mp3Info.idv2Size);
        }
        return j3;
    }

    private static long timeToBytePositionInXingVbr(Mp3FrameInfoParse.Mp3Info mp3Info, long j2) {
        float f2;
        float f3;
        double d2;
        AppMethodBeat.i(114240);
        if (mp3Info == null || mp3Info.toc_table == null || mp3Info.fileLengthInBytes <= 0 || mp3Info.firstFramePosition < 0 || mp3Info.duration < 0 || j2 < 0) {
            AppMethodBeat.o(114240);
            return -1;
        }
        long j3 = mp3Info.fileLengthInBytes;
        long j4 = mp3Info.firstFramePosition;
        long[] jArr = mp3Info.toc_table;
        double d3 = (((double) j2) * 100.0d) / ((double) mp3Info.duration);
        if (d3 <= 0.0d) {
            d2 = 0.0d;
        } else if (d3 >= 100.0d) {
            d2 = 256.0d;
        } else {
            int i2 = (int) d3;
            if (i2 == 0) {
                f2 = 0.0f;
            } else {
                f2 = (float) jArr[i2];
            }
            if (i2 < 99) {
                f3 = (float) jArr[i2 + 1];
            } else {
                f3 = 256.0f;
            }
            d2 = (((double) (f3 - f2)) * (d3 - ((double) i2))) + ((double) f2);
        }
        long round = Math.round(d2 * 0.00390625d * ((double) j3)) + j4;
        long j5 = (j3 + j4) - 1;
        if (mp3Info.idv2Size > 0) {
            j5 -= (long) mp3Info.idv2Size;
        }
        if (round < j5) {
            AppMethodBeat.o(114240);
            return round;
        }
        AppMethodBeat.o(114240);
        return j5;
    }

    private static long timeToBytePositionInVBRIVbr(Mp3FrameInfoParse.Mp3Info mp3Info, long j2) {
        if (mp3Info == null || mp3Info.toc_table == null || mp3Info.fileLengthInBytes <= 0 || mp3Info.firstFramePosition < 0 || mp3Info.duration <= 0 || j2 < 0) {
            return -1;
        }
        long j3 = mp3Info.fileLengthInBytes;
        long j4 = mp3Info.firstFramePosition;
        int i2 = mp3Info.entry_count;
        long[] jArr = mp3Info.toc_table;
        long j5 = mp3Info.duration;
        int i3 = (int) (((((double) j2) * 1.0d) / ((double) j5)) * ((double) (i2 + 1)));
        if (i3 >= 0) {
            j4 = jArr[i3];
        }
        if (i3 < i2) {
            j3 = jArr[i3 + 1];
        }
        long j6 = (((long) i3) * j5) / ((long) (i2 + 1));
        return (j3 == j4 ? 0 : (long) (((((double) (j3 - j4)) * 1.0d) * ((double) (j2 - j6))) / ((double) (((j5 * ((long) (i3 + 1))) / ((long) (i2 + 1))) - j6)))) + j4;
    }
}
