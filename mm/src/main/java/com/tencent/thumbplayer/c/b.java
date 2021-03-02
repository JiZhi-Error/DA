package com.tencent.thumbplayer.c;

import android.util.Xml;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.thumbplayer.api.composition.ITPMediaComposition;
import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.utils.g;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

public final class b implements ITPMediaComposition {
    private int RYJ = 0;
    private int RYK = 0;
    private int RYL = 0;
    private List<ITPMediaTrack> RYM = new ArrayList(1);
    private List<ITPMediaTrack> RYN = new ArrayList(1);
    private List<ITPMediaTrack> RYO = new ArrayList(1);

    public b() {
        AppMethodBeat.i(189107);
        AppMethodBeat.o(189107);
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaComposition
    public final synchronized ITPMediaTrack addVideoTrack() {
        d dVar;
        AppMethodBeat.i(189108);
        dVar = new d(hnf(), 2);
        this.RYM.add(dVar);
        AppMethodBeat.o(189108);
        return dVar;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaComposition
    public final synchronized ITPMediaTrack addAudioTrack() {
        d dVar;
        AppMethodBeat.i(189109);
        dVar = new d(hng(), 3);
        this.RYN.add(dVar);
        AppMethodBeat.o(189109);
        return dVar;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaComposition
    public final synchronized ITPMediaTrack addAVTrack() {
        d dVar;
        AppMethodBeat.i(189110);
        dVar = new d(hnh(), 1);
        this.RYO.add(dVar);
        AppMethodBeat.o(189110);
        return dVar;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaComposition
    public final synchronized boolean removeVideoTrack(ITPMediaTrack iTPMediaTrack) {
        boolean remove;
        AppMethodBeat.i(189111);
        if (iTPMediaTrack == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("remove video track , track is null .");
            AppMethodBeat.o(189111);
            throw illegalArgumentException;
        }
        remove = this.RYM.remove(iTPMediaTrack);
        AppMethodBeat.o(189111);
        return remove;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaComposition
    public final synchronized boolean removeAudioTrack(ITPMediaTrack iTPMediaTrack) {
        boolean remove;
        AppMethodBeat.i(189112);
        if (iTPMediaTrack == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("remove audio track , track is null .");
            AppMethodBeat.o(189112);
            throw illegalArgumentException;
        }
        remove = this.RYN.remove(iTPMediaTrack);
        AppMethodBeat.o(189112);
        return remove;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaComposition
    public final boolean removeAVTrack(ITPMediaTrack iTPMediaTrack) {
        AppMethodBeat.i(189113);
        if (iTPMediaTrack == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("remove audio track , track is null .");
            AppMethodBeat.o(189113);
            throw illegalArgumentException;
        }
        boolean remove = this.RYO.remove(iTPMediaTrack);
        AppMethodBeat.o(189113);
        return remove;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaComposition
    public final synchronized List<ITPMediaTrack> getAllVideoTracks() {
        return this.RYM;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaComposition
    public final synchronized List<ITPMediaTrack> getAllAudioTracks() {
        return this.RYN;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaComposition
    public final List<ITPMediaTrack> getAllAVTracks() {
        return this.RYO;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaComposition
    public final long getDurationMs() {
        long hni;
        AppMethodBeat.i(189114);
        if (!com.tencent.thumbplayer.utils.b.isEmpty(this.RYO)) {
            long j2 = 0;
            if (this.RYO != null) {
                Iterator<ITPMediaTrack> it = this.RYO.iterator();
                while (true) {
                    hni = j2;
                    if (!it.hasNext()) {
                        break;
                    }
                    ITPMediaTrack next = it.next();
                    if (hni < next.getTimelineDurationMs()) {
                        j2 = next.getTimelineDurationMs();
                    } else {
                        j2 = hni;
                    }
                }
            } else {
                hni = 0;
            }
            AppMethodBeat.o(189114);
        } else {
            long audioDuration = getAudioDuration();
            hni = hni();
            long j3 = hni > audioDuration ? hni : audioDuration;
            String str = c.RYP;
            char c2 = 65535;
            switch (str.hashCode()) {
                case -2046821033:
                    if (str.equals("base_longer")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -491658008:
                    if (str.equals("base_audio")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -472621683:
                    if (str.equals("base_video")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    break;
                case 1:
                    hni = audioDuration;
                    break;
                case 2:
                    if (hni <= audioDuration) {
                        hni = audioDuration;
                        break;
                    }
                    break;
                default:
                    hni = j3;
                    break;
            }
            AppMethodBeat.o(189114);
        }
        return hni;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaComposition
    public final void release() {
        AppMethodBeat.i(189115);
        if (this.RYM != null) {
            this.RYM.clear();
            this.RYM = null;
        }
        if (this.RYN != null) {
            this.RYN.clear();
            this.RYN = null;
        }
        if (this.RYO != null) {
            this.RYO.clear();
            this.RYO = null;
        }
        AppMethodBeat.o(189115);
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public final int getMediaType() {
        return 4;
    }

    private synchronized int hnf() {
        int i2;
        i2 = this.RYJ + 1;
        this.RYJ = i2;
        return i2;
    }

    private synchronized int hng() {
        int i2;
        i2 = this.RYK + 1;
        this.RYK = i2;
        return i2;
    }

    private synchronized int hnh() {
        int i2;
        i2 = this.RYL + 1;
        this.RYL = i2;
        return i2;
    }

    private long hni() {
        long j2;
        AppMethodBeat.i(189117);
        long j3 = 0;
        if (this.RYM != null) {
            Iterator<ITPMediaTrack> it = this.RYM.iterator();
            while (true) {
                j2 = j3;
                if (!it.hasNext()) {
                    break;
                }
                ITPMediaTrack next = it.next();
                if (j2 < next.getTimelineDurationMs()) {
                    j3 = next.getTimelineDurationMs();
                } else {
                    j3 = j2;
                }
            }
        } else {
            j2 = 0;
        }
        AppMethodBeat.o(189117);
        return j2;
    }

    private long getAudioDuration() {
        long j2;
        AppMethodBeat.i(189118);
        long j3 = 0;
        if (this.RYN != null) {
            Iterator<ITPMediaTrack> it = this.RYN.iterator();
            while (true) {
                j2 = j3;
                if (!it.hasNext()) {
                    break;
                }
                ITPMediaTrack next = it.next();
                if (j2 < next.getTimelineDurationMs()) {
                    j3 = next.getTimelineDurationMs();
                } else {
                    j3 = j2;
                }
            }
        } else {
            j2 = 0;
        }
        AppMethodBeat.o(189118);
        return j2;
    }

    @Override // com.tencent.thumbplayer.api.composition.ITPMediaAsset
    public final String getUrl() {
        AppMethodBeat.i(189116);
        try {
            XmlSerializer newSerializer = Xml.newSerializer();
            StringWriter stringWriter = new StringWriter();
            newSerializer.setOutput(stringWriter);
            newSerializer.startDocument(MimeTypeUtil.ContentType.DEFAULT_CHARSET, Boolean.TRUE);
            newSerializer.startTag("", "assets");
            List<ITPMediaTrack> allAVTracks = getAllAVTracks();
            if (!com.tencent.thumbplayer.utils.b.isEmpty(allAVTracks)) {
                f.a(newSerializer, allAVTracks, 1, 0);
            } else {
                List<ITPMediaTrack> allVideoTracks = getAllVideoTracks();
                List<ITPMediaTrack> allAudioTracks = getAllAudioTracks();
                if (!com.tencent.thumbplayer.utils.b.isEmpty(allVideoTracks) || !com.tencent.thumbplayer.utils.b.isEmpty(allAudioTracks)) {
                    long hni = hni();
                    f.a(newSerializer, allVideoTracks, 2, getAudioDuration());
                    f.a(newSerializer, allAudioTracks, 3, hni);
                } else {
                    AppMethodBeat.o(189116);
                    return "";
                }
            }
            newSerializer.endTag("", "assets");
            newSerializer.endDocument();
            String stringWriter2 = stringWriter.toString();
            AppMethodBeat.o(189116);
            return stringWriter2;
        } catch (Exception e2) {
            g.e("TPMediaComposition", e2);
            AppMethodBeat.o(189116);
            return null;
        }
    }
}
