package com.tencent.mm.media.f;

import android.media.MediaFormat;
import android.util.SparseArray;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import kotlin.g.b.p;
import kotlin.n.n;

public final class a {
    public static final C0414a igm = new C0414a((byte) 0);
    public int audioTrackIndex = -1;
    public final String filePath;
    public boolean ife;
    public final c igg = new c();
    public MediaFormat igh;
    public MediaFormat igi;
    private boolean igj;
    private long igk;
    public boolean igl;
    public int sampleSize;
    public int videoBitrate;
    private int videoTrackIndex = -1;

    static {
        AppMethodBeat.i(93679);
        AppMethodBeat.o(93679);
    }

    public a(String str) {
        int i2;
        int integer;
        p.h(str, "filePath");
        AppMethodBeat.i(93678);
        this.filePath = str;
        try {
            this.igg.setDataSource(this.filePath);
            int trackCount = this.igg.getTrackCount();
            Log.i("MicroMsg.MediaExtractorWrapper", "trackCount :" + trackCount + " filePath :" + this.filePath);
            SparseArray sparseArray = new SparseArray();
            SparseArray sparseArray2 = new SparseArray();
            for (int i3 = 0; i3 < trackCount; i3++) {
                MediaFormat trackFormat = this.igg.getTrackFormat(i3);
                p.g(trackFormat, "mediaExtractor.getTrackFormat(track)");
                String string = trackFormat.getString("mime");
                p.g(string, "mime");
                if (n.e(string, "video")) {
                    sparseArray.put(i3, trackFormat);
                } else if (n.e(string, SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)) {
                    sparseArray2.put(i3, trackFormat);
                }
            }
            Log.i("MicroMsg.MediaExtractorWrapper", "video track count:" + sparseArray.size() + ", audio track count:" + sparseArray2.size());
            if (sparseArray2.size() > 0) {
                this.audioTrackIndex = sparseArray2.keyAt(0);
                this.igi = (MediaFormat) sparseArray2.get(this.audioTrackIndex);
            }
            if (sparseArray.size() > 0) {
                int i4 = Integer.MAX_VALUE;
                int size = sparseArray.size();
                for (int i5 = 0; i5 < size; i5++) {
                    int keyAt = sparseArray.keyAt(i5);
                    MediaFormat mediaFormat = (MediaFormat) sparseArray.get(keyAt);
                    if (!mediaFormat.containsKey("frame-rate") || (integer = mediaFormat.getInteger("frame-rate")) >= i4) {
                        i2 = i4;
                    } else {
                        this.videoTrackIndex = keyAt;
                        this.igh = mediaFormat;
                        i2 = integer;
                    }
                    i4 = i2;
                }
                if (this.videoTrackIndex < 0) {
                    this.videoTrackIndex = sparseArray.keyAt(0);
                    this.igh = (MediaFormat) sparseArray.get(this.videoTrackIndex);
                }
            }
            Log.i("MicroMsg.MediaExtractorWrapper", "audio track index:" + this.audioTrackIndex + ", format:" + this.igi);
            Log.i("MicroMsg.MediaExtractorWrapper", "video track index: " + this.videoTrackIndex + ", format:" + this.igh);
            if (this.videoTrackIndex >= 0) {
                this.igg.selectTrack(this.videoTrackIndex);
                this.igj = true;
            }
            d dVar = new d();
            dVar.setDataSource(this.filePath);
            this.videoBitrate = Integer.parseInt(dVar.extractMetadata(20));
            dVar.release();
            Log.d("MicroMsg.MediaExtractorWrapper", "current info :" + toString());
            AppMethodBeat.o(93678);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaExtractorWrapper", e2, "", new Object[0]);
            this.igl = true;
            AppMethodBeat.o(93678);
        }
    }

    /* renamed from: com.tencent.mm.media.f.a$a */
    public static final class C0414a {
        private C0414a() {
        }

        public /* synthetic */ C0414a(byte b2) {
            this();
        }
    }

    public final boolean aMp() {
        return this.igi != null && this.audioTrackIndex >= 0;
    }

    public final void aMq() {
        AppMethodBeat.i(93668);
        try {
            if (this.audioTrackIndex >= 0) {
                this.igg.unselectTrack(this.audioTrackIndex);
            }
            if (this.videoTrackIndex >= 0) {
                this.igj = true;
                this.igg.selectTrack(this.videoTrackIndex);
                this.sampleSize = 0;
                AppMethodBeat.o(93668);
                return;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaExtractorWrapper", e2, "selectVideo error", new Object[0]);
        }
        AppMethodBeat.o(93668);
    }

    public final void aMr() {
        AppMethodBeat.i(93669);
        try {
            if (this.videoTrackIndex >= 0) {
                this.igg.unselectTrack(this.videoTrackIndex);
            }
            if (this.audioTrackIndex >= 0) {
                this.igj = false;
                this.igg.selectTrack(this.audioTrackIndex);
                this.sampleSize = 0;
                AppMethodBeat.o(93669);
                return;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaExtractorWrapper", e2, "selectAudio error", new Object[0]);
        }
        AppMethodBeat.o(93669);
    }

    public final String aMs() {
        AppMethodBeat.i(93670);
        MediaFormat mediaFormat = this.igh;
        if (mediaFormat != null) {
            String string = mediaFormat.getString("mime");
            AppMethodBeat.o(93670);
            return string;
        }
        AppMethodBeat.o(93670);
        return null;
    }

    public final String aMt() {
        AppMethodBeat.i(93671);
        MediaFormat mediaFormat = this.igi;
        if (mediaFormat != null) {
            String string = mediaFormat.getString("mime");
            AppMethodBeat.o(93671);
            return string;
        }
        AppMethodBeat.o(93671);
        return null;
    }

    public final long getSampleTime() {
        AppMethodBeat.i(93672);
        try {
            long j2 = this.igk;
            AppMethodBeat.o(93672);
            return j2;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaExtractorWrapper", e2, "getSampleTime error", new Object[0]);
            AppMethodBeat.o(93672);
            return -1;
        }
    }

    public static /* synthetic */ boolean a(a aVar, ByteBuffer byteBuffer) {
        AppMethodBeat.i(218747);
        boolean j2 = aVar.j(byteBuffer);
        AppMethodBeat.o(218747);
        return j2;
    }

    private boolean j(ByteBuffer byteBuffer) {
        AppMethodBeat.i(218746);
        p.h(byteBuffer, "byteBuffer");
        try {
            if (this.ife) {
                Log.e("MicroMsg.MediaExtractorWrapper", "readNextSampleData already release");
                AppMethodBeat.o(218746);
                return false;
            }
            this.sampleSize = this.igg.readSampleData(byteBuffer, 0);
            this.igk = this.igg.getSampleTime();
            this.igg.advance();
            if (this.igg.getSampleTrackIndex() != (this.igj ? this.videoTrackIndex : this.audioTrackIndex)) {
                AppMethodBeat.o(218746);
                return false;
            }
            AppMethodBeat.o(218746);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MediaExtractorWrapper", e2, "readNextSampleData", new Object[0]);
            AppMethodBeat.o(218746);
            return false;
        }
    }

    public final void release() {
        AppMethodBeat.i(93675);
        this.igg.release();
        this.ife = true;
        AppMethodBeat.o(93675);
    }

    public final int getDuration() {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(93676);
        MediaFormat mediaFormat = this.igh;
        if (mediaFormat != null) {
            i2 = (int) mediaFormat.getLong("durationUs");
        } else {
            i2 = 0;
        }
        if (i2 <= 0) {
            MediaFormat mediaFormat2 = this.igi;
            if (mediaFormat2 != null) {
                i3 = (int) mediaFormat2.getLong("durationUs");
            }
        } else {
            i3 = i2;
        }
        AppMethodBeat.o(93676);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(93677);
        String str = "MediaExtractorWrapper(filePath='" + this.filePath + "', mediaExtractor=" + this.igg + ", videoTrackIndex=" + this.videoTrackIndex + ", audioTrackIndex=" + this.audioTrackIndex + ", videoTrackFormat=" + this.igh + ", audioTrackForamt=" + this.igi + ", videoBitrate=" + this.videoBitrate + ", selectVideo=" + this.igj + ", sampleSize=" + this.sampleSize + ", hasError=" + this.igl + ", isRelease=" + this.ife + ')';
        AppMethodBeat.o(93677);
        return str;
    }

    public final void seek(long j2) {
        AppMethodBeat.i(93673);
        if (!this.ife) {
            this.igg.seekTo(j2, 0);
            AppMethodBeat.o(93673);
            return;
        }
        Log.e("MicroMsg.MediaExtractorWrapper", "seek error, mediaExtractor already release!");
        AppMethodBeat.o(93673);
    }
}
