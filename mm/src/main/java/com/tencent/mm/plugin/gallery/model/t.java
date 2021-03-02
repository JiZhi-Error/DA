package com.tencent.mm.plugin.gallery.model;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import com.tencent.f.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.plugin.gallery.model.GalleryItem;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

@TargetApi(16)
public final class t implements h {
    public MediaFormat audioFormat;
    public String path;
    public int position;
    public MediaFormat videoFormat;
    public GalleryItem.VideoMediaItem xjZ;
    public a xka;

    public interface a {
        void a(t tVar);
    }

    public t(String str, int i2, GalleryItem.VideoMediaItem videoMediaItem, a aVar) {
        this.path = str;
        this.position = i2;
        this.xjZ = videoMediaItem;
        this.xka = aVar;
    }

    @Override // com.tencent.f.i.h, com.tencent.f.i.g
    public final String getKey() {
        return "video_analysis";
    }

    public final void run() {
        String string;
        AppMethodBeat.i(111378);
        c cVar = new c();
        try {
            cVar.setDataSource(this.path);
            int trackCount = cVar.gLF.getTrackCount();
            for (int i2 = 0; i2 < trackCount; i2++) {
                MediaFormat trackFormat = cVar.getTrackFormat(i2);
                if (trackFormat.containsKey("mime")) {
                    String string2 = trackFormat.getString("mime");
                    Log.d("VideoAnalysisTask", "find video mime : %s", string2);
                    if (string2 != null) {
                        if (string2.startsWith("video/")) {
                            if (this.videoFormat == null) {
                                this.videoFormat = trackFormat;
                            }
                        } else if (string2.startsWith("audio/") && this.audioFormat == null) {
                            this.audioFormat = trackFormat;
                        }
                        if (!(this.audioFormat == null || this.videoFormat == null)) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Log.d("VideoAnalysisTask", "find video mime : not found.");
                }
            }
            if (this.xjZ != null) {
                if (this.videoFormat != null) {
                    this.xjZ.jkS = !this.videoFormat.containsKey("durationUs") ? 0 : (int) (this.videoFormat.getLong("durationUs") / 1000);
                    this.xjZ.videoHeight = !this.videoFormat.containsKey("height") ? 0 : this.videoFormat.getInteger("height");
                    this.xjZ.videoWidth = !this.videoFormat.containsKey("width") ? 0 : this.videoFormat.getInteger("width");
                    this.xjZ.jkQ = !this.videoFormat.containsKey("mime") ? "" : this.videoFormat.getString("mime");
                    this.xjZ.videoBitRate = !this.videoFormat.containsKey(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE) ? 0 : this.videoFormat.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE);
                    this.xjZ.videoIFrameInterval = !this.videoFormat.containsKey("i-frame-interval") ? 0 : this.videoFormat.getInteger("i-frame-interval");
                    this.xjZ.videoFrameRate = !this.videoFormat.containsKey("frame-rate") ? 0 : this.videoFormat.getInteger("frame-rate");
                }
                if (this.audioFormat != null) {
                    GalleryItem.VideoMediaItem videoMediaItem = this.xjZ;
                    if (!this.audioFormat.containsKey("mime")) {
                        string = "";
                    } else {
                        string = this.audioFormat.getString("mime");
                    }
                    videoMediaItem.jkR = string;
                }
            }
            cVar.gLF.release();
        } catch (Exception e2) {
            Log.d("VideoAnalysisTask", "Video extractor init failed. video path = [%s] e = [%s]", this.path, e2.getMessage());
            cVar.gLF.release();
        } catch (Throwable th) {
            cVar.gLF.release();
            AppMethodBeat.o(111378);
            throw th;
        }
        if (this.xka == null) {
            Log.d("VideoAnalysisTask", "video analysis end. observer == null, position = [%d], mediaItem = [%s]", Integer.valueOf(this.position), this.xjZ);
            AppMethodBeat.o(111378);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.gallery.model.t.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(111377);
                if (t.this.xka != null) {
                    t.this.xka.a(t.this);
                }
                AppMethodBeat.o(111377);
            }
        });
        AppMethodBeat.o(111378);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(111379);
        if (!(obj instanceof t) || !(this == obj || this.position == ((t) obj).position || (this.path != null && this.path.equals(((t) obj).path)))) {
            AppMethodBeat.o(111379);
            return false;
        }
        AppMethodBeat.o(111379);
        return true;
    }
}
