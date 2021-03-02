package com.tencent.thumbplayer.c;

import android.util.Xml;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import com.tencent.thumbplayer.utils.b;
import com.tencent.thumbplayer.utils.g;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

public final class d implements ITPMediaTrack, Serializable {
    private int RYT = -1;
    private int RYU;
    private List<ITPMediaTrackClip> RYV;

    public d(int i2) {
        AppMethodBeat.i(189119);
        this.RYU = i2;
        this.RYV = new ArrayList();
        AppMethodBeat.o(189119);
    }

    public d(int i2, int i3) {
        AppMethodBeat.i(189120);
        this.RYT = i2;
        this.RYU = i3;
        this.RYV = new ArrayList();
        AppMethodBeat.o(189120);
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrack
    public final synchronized int addTrackClip(ITPMediaTrackClip iTPMediaTrackClip) {
        int clipId;
        AppMethodBeat.i(189121);
        a(iTPMediaTrackClip);
        if (this.RYV.contains(iTPMediaTrackClip)) {
            g.i("TPMediaCompositionTrack", "add track clip failed, clip already exists : " + iTPMediaTrackClip.getClipId());
            clipId = iTPMediaTrackClip.getClipId();
            AppMethodBeat.o(189121);
        } else {
            this.RYV.add(iTPMediaTrackClip);
            clipId = iTPMediaTrackClip.getClipId();
            AppMethodBeat.o(189121);
        }
        return clipId;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrack
    public final synchronized int insertTrackClip(ITPMediaTrackClip iTPMediaTrackClip, int i2) {
        int clipId;
        AppMethodBeat.i(189122);
        a(iTPMediaTrackClip);
        if (!this.RYV.contains(iTPMediaTrackClip)) {
            if (i2 != -1) {
                int size = this.RYV.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        this.RYV.add(iTPMediaTrackClip);
                        g.i("TPMediaCompositionTrack", "insert track clip into the end, coz after clip not found :".concat(String.valueOf(i2)));
                        clipId = iTPMediaTrackClip.getClipId();
                        AppMethodBeat.o(189122);
                        break;
                    } else if (this.RYV.get(i3).getClipId() == i2) {
                        this.RYV.add(i3 + 1, iTPMediaTrackClip);
                        clipId = iTPMediaTrackClip.getClipId();
                        AppMethodBeat.o(189122);
                        break;
                    } else {
                        i3++;
                    }
                }
            } else {
                this.RYV.add(0, iTPMediaTrackClip);
                clipId = iTPMediaTrackClip.getClipId();
                AppMethodBeat.o(189122);
            }
        } else {
            g.i("TPMediaCompositionTrack", "add track clip failed, clip already exists : " + iTPMediaTrackClip.getClipId());
            clipId = iTPMediaTrackClip.getClipId();
            AppMethodBeat.o(189122);
        }
        return clipId;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrack
    public final synchronized boolean swapTrackClip(int i2, int i3) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(189123);
            if (i2 < 0 || i2 >= this.RYV.size()) {
                g.w("TPMediaCompositionTrack", "swap clip failed, from pos invalid , from pos : ".concat(String.valueOf(i2)));
                AppMethodBeat.o(189123);
            } else if (i3 < 0 || i3 >= this.RYV.size()) {
                g.w("TPMediaCompositionTrack", "swap clip failed, to pos invalid , to pos :".concat(String.valueOf(i3)));
                AppMethodBeat.o(189123);
            } else {
                Collections.swap(this.RYV, i2, i3);
                z = true;
                AppMethodBeat.o(189123);
            }
        }
        return z;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrack
    public final synchronized boolean removeTrackClip(ITPMediaTrackClip iTPMediaTrackClip) {
        boolean remove;
        AppMethodBeat.i(189124);
        if (iTPMediaTrackClip == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("remove track clip , clip can not be null");
            AppMethodBeat.o(189124);
            throw illegalArgumentException;
        }
        remove = this.RYV.remove(iTPMediaTrackClip);
        AppMethodBeat.o(189124);
        return remove;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrack
    public final synchronized void removeAllTrackClips() {
        AppMethodBeat.i(189125);
        this.RYV.clear();
        AppMethodBeat.o(189125);
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrack
    public final synchronized List<ITPMediaTrackClip> getAllTrackClips() {
        return this.RYV;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrack
    public final synchronized ITPMediaTrackClip getTrackClip(int i2) {
        ITPMediaTrackClip iTPMediaTrackClip;
        AppMethodBeat.i(189126);
        Iterator<ITPMediaTrackClip> it = this.RYV.iterator();
        while (true) {
            if (!it.hasNext()) {
                iTPMediaTrackClip = null;
                AppMethodBeat.o(189126);
                break;
            }
            iTPMediaTrackClip = it.next();
            if (iTPMediaTrackClip.getClipId() == i2) {
                AppMethodBeat.o(189126);
                break;
            }
        }
        return iTPMediaTrackClip;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrack
    public final synchronized int getTrackId() {
        return this.RYT;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public final synchronized int getMediaType() {
        return this.RYU;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public final synchronized String getUrl() {
        String str;
        String str2;
        String str3;
        AppMethodBeat.i(189127);
        try {
            List<ITPMediaTrackClip> list = this.RYV;
            int i2 = this.RYU;
            if (b.isEmpty(list)) {
                str = "";
                AppMethodBeat.o(189127);
            } else {
                if (i2 == 1) {
                    str2 = "av_tracks";
                    str3 = "av_track";
                } else if (i2 == 2) {
                    str2 = "video_tracks";
                    str3 = "video_track";
                } else if (i2 == 3) {
                    str2 = "audio_tracks";
                    str3 = "audio_track";
                } else {
                    str = "";
                    AppMethodBeat.o(189127);
                }
                XmlSerializer newSerializer = Xml.newSerializer();
                StringWriter stringWriter = new StringWriter();
                newSerializer.setOutput(stringWriter);
                newSerializer.startDocument(MimeTypeUtil.ContentType.DEFAULT_CHARSET, Boolean.TRUE);
                newSerializer.startTag("", "assets");
                f.a(newSerializer, list, str2, str3);
                newSerializer.endTag("", "assets");
                newSerializer.endDocument();
                str = stringWriter.toString();
                AppMethodBeat.o(189127);
            }
        } catch (IOException e2) {
            g.e("TPMediaCompositionTrack", e2);
            str = null;
            AppMethodBeat.o(189127);
        }
        return str;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaTrack
    public final synchronized long getTimelineDurationMs() {
        long j2;
        AppMethodBeat.i(189128);
        j2 = 0;
        for (ITPMediaTrackClip iTPMediaTrackClip : this.RYV) {
            j2 = iTPMediaTrackClip.getOriginalDurationMs() + j2;
        }
        AppMethodBeat.o(189128);
        return j2;
    }

    private synchronized void a(ITPMediaTrackClip iTPMediaTrackClip) {
        AppMethodBeat.i(189129);
        if (iTPMediaTrackClip == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("add track clip , clip can not be null");
            AppMethodBeat.o(189129);
            throw illegalArgumentException;
        } else if (iTPMediaTrackClip.getMediaType() != this.RYU) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("add track clip failed, media type is not same");
            AppMethodBeat.o(189129);
            throw illegalArgumentException2;
        } else {
            AppMethodBeat.o(189129);
        }
    }
}
