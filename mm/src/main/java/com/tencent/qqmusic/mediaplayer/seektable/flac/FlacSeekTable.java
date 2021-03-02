package com.tencent.qqmusic.mediaplayer.seektable.flac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;
import com.tencent.qqmusic.mediaplayer.seektable.ParsableInputStreamWrapper;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.util.Arrays;
import java.util.HashSet;

public class FlacSeekTable implements SeekTable {
    private static final int SEEK_POINT_SIZE = 18;
    private static final byte TYPE_SEEKTABLE = 3;
    private static final byte TYPE_STREAMINFO = 0;
    private long firstFrameOffset;
    private long[] offsets;
    private long[] sampleNumbers;
    private int sampleRate = 0;

    /* access modifiers changed from: package-private */
    public interface BlockHandler {
        boolean handle(Parsable parsable, int i2);
    }

    static /* synthetic */ boolean access$200(Parsable parsable) {
        AppMethodBeat.i(114281);
        boolean seekToFirstFrame = seekToFirstFrame(parsable);
        AppMethodBeat.o(114281);
        return seekToFirstFrame;
    }

    public FlacSeekTable(int i2) {
        this.sampleRate = i2;
    }

    public long[] getOffsetRangeOfSample(int i2) {
        AppMethodBeat.i(114274);
        int binarySearchFloor = binarySearchFloor(this.sampleNumbers, (long) i2, true, true);
        if (binarySearchFloor + 1 >= this.offsets.length) {
            long[] jArr = {this.firstFrameOffset + this.offsets[binarySearchFloor], -1};
            AppMethodBeat.o(114274);
            return jArr;
        }
        long[] jArr2 = {this.firstFrameOffset + this.offsets[binarySearchFloor], this.firstFrameOffset + this.offsets[binarySearchFloor + 1]};
        AppMethodBeat.o(114274);
        return jArr2;
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.SeekTable
    public void parse(IDataSource iDataSource) {
        AppMethodBeat.i(114275);
        ParsableInputStreamWrapper parsableInputStreamWrapper = new ParsableInputStreamWrapper(iDataSource);
        if (!seekToFlac(parsableInputStreamWrapper)) {
            AppMethodBeat.o(114275);
            return;
        }
        if (!walkThrough(parsableInputStreamWrapper, this.sampleRate == 0 ? new BlockHandler[]{new SeektableHandler(), new StreamInfoHandler()} : new BlockHandler[]{new SeektableHandler()})) {
            InvalidBoxException invalidBoxException = new InvalidBoxException("lack one or more critical BLOCK(s) to create seek table!");
            AppMethodBeat.o(114275);
            throw invalidBoxException;
        }
        AppMethodBeat.o(114275);
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.SeekTable
    public long seek(long j2) {
        AppMethodBeat.i(114276);
        int binarySearchFloor = binarySearchFloor(this.sampleNumbers, (long) ((int) (Math.round(((double) j2) / 1000.0d) * ((long) this.sampleRate))), true, true);
        long j3 = this.offsets[binarySearchFloor] + this.firstFrameOffset;
        AppMethodBeat.o(114276);
        return j3;
    }

    private static boolean seekToFlac(Parsable parsable) {
        AppMethodBeat.i(114277);
        byte[] bArr = new byte[4];
        parsable.readBytes(bArr, 0, 4);
        if (bArr[0] == 73 && bArr[1] == 68 && bArr[2] == 51) {
            parsable.skip(2);
            parsable.skip((long) Id3Util.unsynchsafe(parsable.readInt()));
            parsable.readBytes(bArr, 0, 4);
        }
        if (bArr[0] == 102 && bArr[1] == 76 && bArr[2] == 97 && bArr[3] == 67) {
            AppMethodBeat.o(114277);
            return true;
        }
        AppMethodBeat.o(114277);
        return false;
    }

    private static boolean walkThrough(Parsable parsable, BlockHandler... blockHandlerArr) {
        AppMethodBeat.i(114278);
        byte[] bArr = new byte[1];
        byte[] bArr2 = new byte[3];
        HashSet hashSet = new HashSet();
        while (hashSet.size() < blockHandlerArr.length && parsable.available() > 0) {
            parsable.readBytes(bArr, 0, 1);
            int i2 = bArr[0] & Byte.MAX_VALUE;
            int length = blockHandlerArr.length;
            int i3 = 0;
            boolean z = false;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                BlockHandler blockHandler = blockHandlerArr[i3];
                z = blockHandler.handle(parsable, i2);
                if (z) {
                    hashSet.add(Integer.valueOf(blockHandler.hashCode()));
                    break;
                }
                i3++;
            }
            if (!z) {
                if (((bArr[0] & 255) >> 7) == 1) {
                    break;
                }
                parsable.readBytes(bArr2, 0, 3);
                parsable.skip((long) BytesUtil.from(bArr2));
            }
        }
        if (hashSet.size() == blockHandlerArr.length) {
            AppMethodBeat.o(114278);
            return true;
        }
        AppMethodBeat.o(114278);
        return false;
    }

    private static boolean seekToFirstFrame(Parsable parsable) {
        boolean z = false;
        AppMethodBeat.i(114279);
        byte[] bArr = new byte[1];
        byte[] bArr2 = new byte[3];
        boolean z2 = false;
        while (true) {
            if (parsable.available() <= 0) {
                break;
            } else if (z2) {
                byte[] bArr3 = new byte[2];
                parsable.readBytes(bArr3, 0, 2);
                if ((bArr3[0] & 255) == 255 && ((bArr3[1] & 255) >> 2) == 62) {
                    z = true;
                }
            } else {
                parsable.readBytes(bArr, 0, 1);
                if (((bArr[0] & 255) >> 7) == 1) {
                    z2 = true;
                }
                parsable.readBytes(bArr2, 0, 3);
                parsable.skip((long) BytesUtil.from(bArr2));
            }
        }
        AppMethodBeat.o(114279);
        return z;
    }

    private static int binarySearchFloor(long[] jArr, long j2, boolean z, boolean z2) {
        AppMethodBeat.i(114280);
        int binarySearch = Arrays.binarySearch(jArr, j2);
        if (binarySearch < 0) {
            binarySearch = -(binarySearch + 2);
        } else if (!z) {
            binarySearch--;
        }
        if (z2) {
            int max = Math.max(0, binarySearch);
            AppMethodBeat.o(114280);
            return max;
        }
        AppMethodBeat.o(114280);
        return binarySearch;
    }

    class SeektableHandler implements BlockHandler {
        SeektableHandler() {
        }

        @Override // com.tencent.qqmusic.mediaplayer.seektable.flac.FlacSeekTable.BlockHandler
        public boolean handle(Parsable parsable, int i2) {
            AppMethodBeat.i(114272);
            if (i2 != 3) {
                AppMethodBeat.o(114272);
                return false;
            }
            byte[] bArr = new byte[3];
            parsable.readBytes(bArr, 0, 3);
            int from = BytesUtil.from(bArr) / 18;
            FlacSeekTable.this.sampleNumbers = new long[from];
            FlacSeekTable.this.offsets = new long[from];
            for (int i3 = 0; i3 < from; i3++) {
                FlacSeekTable.this.sampleNumbers[i3] = parsable.readLong();
                FlacSeekTable.this.offsets[i3] = parsable.readLong();
                parsable.skip(2);
            }
            if (!FlacSeekTable.access$200(parsable)) {
                InvalidBoxException invalidBoxException = new InvalidBoxException("can't find audio frame!");
                AppMethodBeat.o(114272);
                throw invalidBoxException;
            }
            FlacSeekTable.this.firstFrameOffset = parsable.tell() - 2;
            AppMethodBeat.o(114272);
            return true;
        }
    }

    class StreamInfoHandler implements BlockHandler {
        StreamInfoHandler() {
        }

        @Override // com.tencent.qqmusic.mediaplayer.seektable.flac.FlacSeekTable.BlockHandler
        public boolean handle(Parsable parsable, int i2) {
            AppMethodBeat.i(114282);
            if (i2 != 0) {
                AppMethodBeat.o(114282);
                return false;
            }
            parsable.skip(13);
            parsable.readBytes(new byte[3], 0, 3);
            parsable.skip(21);
            AppMethodBeat.o(114282);
            return true;
        }
    }
}
