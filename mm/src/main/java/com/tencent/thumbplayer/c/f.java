package com.tencent.thumbplayer.c;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import com.tencent.thumbplayer.utils.g;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

public final class f {
    static void a(XmlSerializer xmlSerializer, List<ITPMediaTrackClip> list, String str, String str2) {
        AppMethodBeat.i(189134);
        xmlSerializer.startTag("", str);
        xmlSerializer.startTag("", str2);
        for (ITPMediaTrackClip iTPMediaTrackClip : list) {
            a(xmlSerializer, iTPMediaTrackClip, 0);
        }
        xmlSerializer.endTag("", str2);
        xmlSerializer.endTag("", str);
        AppMethodBeat.o(189134);
    }

    static void a(XmlSerializer xmlSerializer, List<ITPMediaTrack> list, int i2, long j2) {
        AppMethodBeat.i(189135);
        if (list != null) {
            try {
                if (list.size() > 0) {
                    String bX = bX(i2, true);
                    String bX2 = bX(i2, false);
                    xmlSerializer.startTag("", bX);
                    for (ITPMediaTrack iTPMediaTrack : list) {
                        if (iTPMediaTrack.getMediaType() == i2) {
                            xmlSerializer.startTag("", bX2);
                            xmlSerializer.startTag("", "track_id");
                            xmlSerializer.text(Integer.toString(iTPMediaTrack.getTrackId()));
                            xmlSerializer.endTag("", "track_id");
                            if (i2 != 1 && c.RYP.equals("base_audio") && iTPMediaTrack.getTimelineDurationMs() > j2) {
                                long j3 = 0;
                                Iterator<ITPMediaTrackClip> it = iTPMediaTrack.getAllTrackClips().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    ITPMediaTrackClip next = it.next();
                                    j3 += next.getOriginalDurationMs();
                                    if (j3 > j2) {
                                        a(xmlSerializer, next, j3 - j2);
                                        break;
                                    }
                                    a(xmlSerializer, next, 0);
                                }
                            } else {
                                for (ITPMediaTrackClip iTPMediaTrackClip : iTPMediaTrack.getAllTrackClips()) {
                                    a(xmlSerializer, iTPMediaTrackClip, 0);
                                }
                            }
                            xmlSerializer.endTag("", bX2);
                        }
                    }
                    xmlSerializer.endTag("", bX);
                }
            } catch (IOException e2) {
                g.e("TPMediaCompositionXmlGenerator", e2);
                AppMethodBeat.o(189135);
                return;
            }
        }
        AppMethodBeat.o(189135);
    }

    private static void a(XmlSerializer xmlSerializer, ITPMediaTrackClip iTPMediaTrackClip, long j2) {
        AppMethodBeat.i(189136);
        if (iTPMediaTrackClip instanceof a) {
            b(xmlSerializer, iTPMediaTrackClip, j2);
            AppMethodBeat.o(189136);
        } else if (iTPMediaTrackClip instanceof e) {
            c(xmlSerializer, iTPMediaTrackClip, j2);
            AppMethodBeat.o(189136);
        } else {
            AppMethodBeat.o(189136);
        }
    }

    private static void b(XmlSerializer xmlSerializer, ITPMediaTrackClip iTPMediaTrackClip, long j2) {
        AppMethodBeat.i(189137);
        xmlSerializer.startTag("", "track_clip");
        xmlSerializer.startTag("", "clip_id");
        xmlSerializer.text(Integer.toString(iTPMediaTrackClip.getClipId()));
        xmlSerializer.endTag("", "clip_id");
        xmlSerializer.startTag("", "clip_placeHolder");
        xmlSerializer.text("1");
        xmlSerializer.endTag("", "clip_placeHolder");
        xmlSerializer.startTag("", "clip_playTimeMs");
        if (j2 > 0) {
            xmlSerializer.text(Long.toString(iTPMediaTrackClip.getOriginalDurationMs() - j2));
        } else {
            xmlSerializer.text(Long.toString(iTPMediaTrackClip.getOriginalDurationMs()));
        }
        xmlSerializer.endTag("", "clip_playTimeMs");
        xmlSerializer.endTag("", "track_clip");
        AppMethodBeat.o(189137);
    }

    private static void c(XmlSerializer xmlSerializer, ITPMediaTrackClip iTPMediaTrackClip, long j2) {
        AppMethodBeat.i(189138);
        xmlSerializer.startTag("", "track_clip");
        xmlSerializer.startTag("", "clip_id");
        xmlSerializer.text(Integer.toString(iTPMediaTrackClip.getClipId()));
        xmlSerializer.endTag("", "clip_id");
        xmlSerializer.startTag("", "clip_placeHolder");
        xmlSerializer.text(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        xmlSerializer.endTag("", "clip_placeHolder");
        xmlSerializer.startTag("", "clip_path");
        xmlSerializer.text(iTPMediaTrackClip.getFilePath());
        xmlSerializer.endTag("", "clip_path");
        xmlSerializer.startTag("", "clip_startTimeMs");
        xmlSerializer.text(Long.toString(iTPMediaTrackClip.getStartTimeMs()));
        xmlSerializer.endTag("", "clip_startTimeMs");
        xmlSerializer.startTag("", "clip_durationMs");
        xmlSerializer.text(Long.toString(iTPMediaTrackClip.getOriginalDurationMs()));
        xmlSerializer.endTag("", "clip_durationMs");
        if (j2 > 0) {
            xmlSerializer.startTag("", "clip_endTimeMs");
            xmlSerializer.text(Long.toString(iTPMediaTrackClip.getEndTimeMs() - j2));
            xmlSerializer.endTag("", "clip_endTimeMs");
            xmlSerializer.startTag("", "clip_playTimeMs");
            xmlSerializer.text(Long.toString(iTPMediaTrackClip.getOriginalDurationMs() - j2));
            xmlSerializer.endTag("", "clip_playTimeMs");
        } else {
            xmlSerializer.startTag("", "clip_endTimeMs");
            xmlSerializer.text(Long.toString(iTPMediaTrackClip.getEndTimeMs()));
            xmlSerializer.endTag("", "clip_endTimeMs");
            xmlSerializer.startTag("", "clip_playTimeMs");
            xmlSerializer.text(Long.toString(iTPMediaTrackClip.getOriginalDurationMs()));
            xmlSerializer.endTag("", "clip_playTimeMs");
        }
        xmlSerializer.endTag("", "track_clip");
        AppMethodBeat.o(189138);
    }

    private static String bX(int i2, boolean z) {
        if (i2 == 1) {
            return z ? "av_tracks" : "av_track";
        }
        if (i2 == 2) {
            return z ? "video_tracks" : "video_track";
        }
        if (i2 == 3) {
            return z ? "audio_tracks" : "audio_track";
        }
        return "";
    }
}
