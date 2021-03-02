package com.tencent.qqmusic.mediaplayer.seektable.mp3;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.g;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.wcdb.FileUtils;
import com.tencent.wxmm.v2encoder;

class Mp3FrameInfoParse {
    private static final int[][][] BitrateTable = {new int[][]{new int[]{0, 32, 64, 96, 128, 160, 192, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, 256, 288, 320, g.CTRL_INDEX, 384, 416, FileUtils.S_IRWXU}, new int[]{0, 32, 48, 56, 64, 80, 96, 112, 128, 160, 192, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, 256, 320, 384}, new int[]{0, 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, 256, 320}}, new int[][]{new int[]{0, 32, 48, 56, 64, 80, 96, 112, 128, 144, 160, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6, 192, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, 256}, new int[]{0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160}, new int[]{0, 8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160}}};
    private static final int DECODE_ERROR_IO_READ = -3;
    private static final int DECODE_ERROR_MEMORY_ALLOC = -2;
    private static final int DECODE_ERROR_SUCCESS = 0;
    private static final int DECODE_FAIL = -1;
    private static final int[][] SAMPLE_PER_FRAME = {new int[]{384, 1152, 1152}, new int[]{384, 1152, 576}, new int[]{384, 1152, 576}};
    private static final int[][] SAMPLE_RATE_TABLE = {new int[]{11025, 12000, TXRecordCommon.AUDIO_SAMPLERATE_8000}, new int[]{0, 0, 0}, new int[]{22050, 24000, 16000}, new int[]{44100, 48000, 32000}};
    private static final String TAG = "Mp3FrameInfoParse";
    public static final int VBR_TYPE_CBR = 0;
    public static final int VBR_TYPE_VBRI = 1;
    public static final int VBR_TYPE_XING = 2;

    Mp3FrameInfoParse() {
    }

    /* access modifiers changed from: package-private */
    public static class Mp3Info {
        int VBRType = 0;
        int bit_rate = 0;
        int channels = 0;
        long duration = 0;
        int entry_count = 0;
        int entry_size = 0;
        long fileLengthInBytes = 0;
        long firstFramePosition = 0;
        long firstFrameSize = 0;
        int flag_value = 0;
        int idv2Size = 0;
        int isVbr = 0;
        int layer = 0;
        long lengthInFrames = 0;
        int mpeg_version = 0;
        long sample_rate = 0;
        int scale_factor = 0;
        long[] toc_table = null;

        Mp3Info() {
        }
    }

    public static int parseFrameInfo(TrackPositionDataSource trackPositionDataSource, Mp3Info mp3Info) {
        AppMethodBeat.i(114231);
        if (trackPositionDataSource == null) {
            AppMethodBeat.o(114231);
            return -1;
        }
        byte[] bArr = new byte[1024];
        if (trackPositionDataSource.read(bArr, 1024) < 1024) {
            AppMethodBeat.o(114231);
            return -2;
        }
        if (Mp3DecodeBase.hasId3v2(bArr, 4)) {
            Logger.i(TAG, "hasId3v2");
            skipId3v2(trackPositionDataSource, bArr, mp3Info);
        } else {
            trackPositionDataSource.seek(0);
        }
        int i2 = 0;
        long size = trackPositionDataSource.getSize();
        long j2 = (long) mp3Info.idv2Size;
        if (j2 > 0 && size > j2) {
            size -= j2;
        }
        while (true) {
            long curPosition = trackPositionDataSource.getCurPosition();
            if (j2 > 0) {
                curPosition -= j2;
            }
            if (curPosition >= size / 10) {
                AppMethodBeat.o(114231);
                return -3;
            } else if (i2 < 3 || trackPositionDataSource.seek(trackPositionDataSource.getCurPosition() - 3) >= 0) {
                int read = trackPositionDataSource.read(bArr, 1024);
                if (read == -1) {
                    mp3Info.firstFramePosition = -1;
                    AppMethodBeat.o(114231);
                    return -3;
                }
                i2 += read;
                int i3 = 0;
                while (true) {
                    if (i3 + 4 <= read) {
                        if (255 == (bArr[i3] & 255) && 224 == (bArr[i3 + 1] & 224) && IsMp3Header(trackPositionDataSource, bArr, 1024, i3, mp3Info)) {
                            mp3Info.firstFramePosition = (long) (((mp3Info.idv2Size + i2) - read) + i3);
                            Logger.i(TAG, "FirstFramePos = " + mp3Info.firstFramePosition);
                            if (trackPositionDataSource.seek(mp3Info.firstFramePosition) < 0) {
                                AppMethodBeat.o(114231);
                                return -1;
                            }
                            boolean parseVBRFrameInfo = parseVBRFrameInfo(trackPositionDataSource, mp3Info);
                            if (trackPositionDataSource.seek(0) < 0 || !parseVBRFrameInfo) {
                                AppMethodBeat.o(114231);
                                return -1;
                            }
                            AppMethodBeat.o(114231);
                            return 0;
                        }
                        i3++;
                    }
                }
            } else {
                AppMethodBeat.o(114231);
                return -3;
            }
        }
    }

    private static void skipId3v2(TrackPositionDataSource trackPositionDataSource, byte[] bArr, Mp3Info mp3Info) {
        int i2;
        boolean z;
        AppMethodBeat.i(114232);
        if (trackPositionDataSource == null || bArr == null) {
            AppMethodBeat.o(114232);
            return;
        }
        if (bArr[0] == 73 && bArr[1] == 68 && bArr[2] == 51) {
            int i3 = ((bArr[6] & Byte.MAX_VALUE) << 21) + ((bArr[7] & Byte.MAX_VALUE) << 14) + ((bArr[8] & Byte.MAX_VALUE) << 7) + (bArr[9] & Byte.MAX_VALUE);
            if ((bArr[5] & v2encoder.enumCODEC_vcodec2) != 0) {
                i2 = i3 + 20;
                z = true;
            } else {
                i2 = i3 + 10;
                z = false;
            }
            if (trackPositionDataSource.seek((long) i2) < 0) {
                AppMethodBeat.o(114232);
                return;
            }
            if (!z) {
                byte[] bArr2 = new byte[1];
                int read = trackPositionDataSource.read(bArr2, 1);
                while (bArr2[0] == 0 && read == 1) {
                    i2++;
                    read = trackPositionDataSource.read(bArr2, 1);
                }
            }
            mp3Info.idv2Size = i2;
            Logger.i(TAG, "id3V2 Size: " + mp3Info.idv2Size);
            trackPositionDataSource.seek((long) i2);
        }
        AppMethodBeat.o(114232);
    }

    private static boolean IsMp3Header(TrackPositionDataSource trackPositionDataSource, byte[] bArr, int i2, int i3, Mp3Info mp3Info) {
        int i4;
        AppMethodBeat.i(114233);
        if (bArr == null || mp3Info == null) {
            AppMethodBeat.o(114233);
            return false;
        }
        int i5 = (bArr[i3 + 1] >> 3) & 3;
        if (1 == i5) {
            AppMethodBeat.o(114233);
            return false;
        }
        int i6 = (bArr[i3 + 1] >> 1) & 3;
        if (i6 == 0) {
            AppMethodBeat.o(114233);
            return false;
        }
        int i7 = 4 - i6;
        int i8 = (bArr[i3 + 2] >> 4) & 15;
        if (15 == i8) {
            AppMethodBeat.o(114233);
            return false;
        }
        int i9 = (bArr[i3 + 2] >> 2) & 3;
        if (3 == i9) {
            AppMethodBeat.o(114233);
            return false;
        }
        int i10 = (bArr[i3 + 3] >> 6) & 3;
        int i11 = (bArr[i3 + 2] >> 1) & 1;
        int i12 = i5 == 3 ? 0 : 1;
        if (1 == i7) {
            i4 = (((BitrateTable[i12][0][i8] * 12000) / SAMPLE_RATE_TABLE[i5][i9]) + i11) << 2;
        } else if (2 == i7) {
            i4 = ((BitrateTable[i12][1][i8] * 144000) / SAMPLE_RATE_TABLE[i5][i9]) + i11;
        } else {
            i4 = ((BitrateTable[i12][2][i8] * 144000) / (SAMPLE_RATE_TABLE[i5][i9] << i12)) + i11;
        }
        if (i4 > 0) {
            long curPosition = trackPositionDataSource.getCurPosition();
            if (trackPositionDataSource.seek((curPosition - ((long) i2)) + ((long) i3) + ((long) i4)) < 0) {
                AppMethodBeat.o(114233);
                return false;
            }
            byte[] bArr2 = new byte[4];
            if (trackPositionDataSource.read(bArr2, 4) == -1) {
                AppMethodBeat.o(114233);
                return false;
            }
            int readInt = Mp3DecodeBase.readInt(bArr, i3, 4);
            int readInt2 = Mp3DecodeBase.readInt(bArr2, 4);
            trackPositionDataSource.seek(curPosition);
            if (readInt == 0 || readInt2 == 0 || (-128000 & readInt) != (readInt2 & -128000)) {
                AppMethodBeat.o(114233);
                return false;
            }
            Logger.i(TAG, "FirstFrameSize = ".concat(String.valueOf(i4)));
            mp3Info.firstFrameSize = (long) i4;
            int i13 = 0;
            if (i5 == 3) {
                i13 = 0;
            } else if (i5 == 2) {
                i13 = 1;
            } else if (i5 == 0) {
                i13 = 2;
            }
            mp3Info.mpeg_version = i13;
            mp3Info.layer = i7;
            mp3Info.sample_rate = (long) SAMPLE_RATE_TABLE[i5][i9];
            mp3Info.bit_rate = BitrateTable[i12][i7 - 1][i8];
            mp3Info.channels = i10 == 3 ? 1 : 2;
            AppMethodBeat.o(114233);
            return true;
        }
        mp3Info.firstFrameSize = -1;
        AppMethodBeat.o(114233);
        return false;
    }

    private static boolean parseVBRFrameInfo(TrackPositionDataSource trackPositionDataSource, Mp3Info mp3Info) {
        long j2;
        AppMethodBeat.i(114234);
        if (trackPositionDataSource == null || mp3Info == null) {
            AppMethodBeat.o(114234);
            return false;
        }
        long j3 = mp3Info.sample_rate;
        int i2 = mp3Info.channels;
        byte[] bArr = new byte[1024];
        if (mp3Info.mpeg_version == 0) {
            j2 = i2 != 1 ? 36 : 21;
        } else {
            j2 = i2 != 1 ? 21 : 13;
        }
        if (trackPositionDataSource.seek(trackPositionDataSource.getCurPosition() + j2) < 0) {
            AppMethodBeat.o(114234);
            return false;
        } else if (trackPositionDataSource.read(bArr, 1024) < 1024) {
            AppMethodBeat.o(114234);
            return false;
        } else {
            if (Mp3DecodeBase.isXingVBRheader(bArr, 4)) {
                Logger.i(TAG, "is Xing VBR");
                mp3Info.VBRType = 2;
                mp3Info.isVbr = 1;
                parseXingInfo(bArr, j3, mp3Info);
            } else if (trackPositionDataSource.seek(trackPositionDataSource.getCurPosition() - (j2 + 1024)) < 0) {
                AppMethodBeat.o(114234);
                return false;
            } else if (trackPositionDataSource.seek(trackPositionDataSource.getCurPosition() + 36) < 0) {
                AppMethodBeat.o(114234);
                return false;
            } else if (trackPositionDataSource.read(bArr, 1024) < 1024) {
                AppMethodBeat.o(114234);
                return false;
            } else if (Mp3DecodeBase.isVBRIVBRHeader(bArr, 4)) {
                Logger.i(TAG, "is VBRI VBR");
                mp3Info.VBRType = 1;
                mp3Info.isVbr = 1;
                parseVBRIInfo(mp3Info, bArr, j3);
            } else {
                Logger.i(TAG, "is CBR");
                mp3Info.VBRType = 0;
                long size = trackPositionDataSource.getSize();
                if (mp3Info.fileLengthInBytes <= 0) {
                    mp3Info.fileLengthInBytes = size;
                }
                mp3Info.duration = (long) ((((float) (mp3Info.fileLengthInBytes - ((long) mp3Info.idv2Size))) * 8.0f) / ((float) mp3Info.bit_rate));
            }
            AppMethodBeat.o(114234);
            return true;
        }
    }

    private static void parseXingInfo(byte[] bArr, long j2, Mp3Info mp3Info) {
        int i2;
        AppMethodBeat.i(114235);
        if (bArr == null || mp3Info == null) {
            AppMethodBeat.o(114235);
            return;
        }
        long[] jArr = null;
        int readInt = Mp3DecodeBase.readInt(bArr, 4, 4);
        int i3 = 8;
        if ((readInt & 1) == 1) {
            long readLong = Mp3DecodeBase.readLong(bArr, 8, 4) - 1;
            if (readLong > 0 && j2 > 0) {
                int i4 = mp3Info.mpeg_version;
                mp3Info.lengthInFrames = readLong;
                mp3Info.duration = (long) (((((double) (readLong * ((long) SAMPLE_PER_FRAME[i4][mp3Info.layer - 1]))) * 1.0d) / ((double) j2)) * 1000.0d);
            }
            i3 = 12;
        }
        if ((readInt & 2) == 2) {
            mp3Info.fileLengthInBytes = Mp3DecodeBase.readLong(bArr, i3, 4);
            i2 = i3 + 4;
        } else {
            i2 = i3;
        }
        if ((readInt & 4) == 4) {
            jArr = new long[100];
            for (int i5 = 0; i5 < 100; i5++) {
                jArr[i5] = (long) (bArr[i5 + i2] & 255);
            }
        }
        if (readInt > 0 && jArr != null) {
            mp3Info.toc_table = jArr;
            mp3Info.flag_value = readInt;
        }
        AppMethodBeat.o(114235);
    }

    private static void parseVBRIInfo(Mp3Info mp3Info, byte[] bArr, long j2) {
        AppMethodBeat.i(114236);
        if (bArr == null || mp3Info == null) {
            AppMethodBeat.o(114236);
            return;
        }
        long readLong = Mp3DecodeBase.readLong(bArr, 10, 4);
        mp3Info.fileLengthInBytes = readLong;
        long readLong2 = Mp3DecodeBase.readLong(bArr, 14, 4);
        if (readLong2 > 0 && j2 > 0) {
            int i2 = mp3Info.mpeg_version;
            mp3Info.lengthInFrames = readLong2;
            mp3Info.duration = (long) (((((double) (readLong2 * ((long) SAMPLE_PER_FRAME[i2][mp3Info.layer - 1]))) * 1.0d) / ((double) j2)) * 1000.0d);
        }
        int readShort = Mp3DecodeBase.readShort(bArr, 18, 2);
        int readShort2 = Mp3DecodeBase.readShort(bArr, 20, 2);
        int readShort3 = Mp3DecodeBase.readShort(bArr, 22, 2);
        int i3 = 24;
        if (readShort > 0 && readShort2 > 0) {
            int i4 = readShort + 1;
            long[] jArr = new long[i4];
            int i5 = 0;
            if (mp3Info.firstFramePosition > 0) {
                i5 = (int) (0 + mp3Info.firstFramePosition);
            }
            if (mp3Info.firstFrameSize > 0) {
                i5 = (int) (((long) i5) + mp3Info.firstFrameSize);
            }
            int i6 = 1;
            int i7 = i5;
            while (i6 < i4) {
                int i8 = -1;
                if (readShort3 == 1) {
                    i8 = Mp3DecodeBase.readByte(bArr, i3, 1);
                    i3++;
                } else if (readShort3 == 2) {
                    i8 = Mp3DecodeBase.readShort(bArr, i3, 2);
                    i3 += 2;
                } else if (readShort3 == 3) {
                    i8 = Mp3DecodeBase.readUnsignedInt24(bArr, i3, 3);
                    i3 += 3;
                } else if (readShort3 == 4) {
                    i8 = Mp3DecodeBase.readInt(bArr, i3, 4);
                    i3 += 4;
                } else {
                    jArr = null;
                }
                if (i8 < 0) {
                    break;
                }
                int i9 = (i8 * readShort2) + i7;
                if (((long) i9) >= readLong) {
                    i9 = (int) readLong;
                }
                jArr[i6] = (long) i9;
                i6++;
                i7 = i9;
            }
            mp3Info.entry_count = readShort;
            mp3Info.entry_size = readShort3;
            mp3Info.scale_factor = readShort2;
            mp3Info.toc_table = jArr;
        }
        AppMethodBeat.o(114236);
    }
}
