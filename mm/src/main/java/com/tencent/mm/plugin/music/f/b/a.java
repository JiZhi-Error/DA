package com.tencent.mm.plugin.music.f.b;

import com.google.android.exoplayer2.d.b;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.sharp.jni.QLog;
import java.text.NumberFormat;
import java.util.Locale;

public final class a {
    private static final NumberFormat Amm;

    static {
        AppMethodBeat.i(137413);
        NumberFormat instance = NumberFormat.getInstance(Locale.US);
        Amm = instance;
        instance.setMinimumFractionDigits(2);
        Amm.setMaximumFractionDigits(2);
        Amm.setGroupingUsed(false);
        AppMethodBeat.o(137413);
    }

    public static void euZ() {
        AppMethodBeat.i(137410);
        b.DEBUG = false;
        b.a(new com.google.android.exoplayer2.d.a() {
            /* class com.tencent.mm.plugin.music.f.b.a.AnonymousClass1 */

            @Override // com.google.android.exoplayer2.d.a
            public final void i(String str, String str2, Object... objArr) {
                AppMethodBeat.i(137407);
                Log.i(str, str2, objArr);
                AppMethodBeat.o(137407);
            }

            @Override // com.google.android.exoplayer2.d.a
            public final void w(String str, String str2, Object... objArr) {
                AppMethodBeat.i(137408);
                Log.w(str, str2, objArr);
                AppMethodBeat.o(137408);
            }

            @Override // com.google.android.exoplayer2.d.a
            public final void e(String str, String str2, Object... objArr) {
                AppMethodBeat.i(137409);
                Log.e(str, str2, objArr);
                AppMethodBeat.o(137409);
            }
        });
        AppMethodBeat.o(137410);
    }

    public static String Hq(long j2) {
        AppMethodBeat.i(137411);
        if (j2 == -9223372036854775807L) {
            AppMethodBeat.o(137411);
            return "?";
        }
        String format = Amm.format((double) (((float) j2) / 1000.0f));
        AppMethodBeat.o(137411);
        return format;
    }

    public static String Td(int i2) {
        switch (i2) {
            case 1:
                return "I";
            case 2:
                return "B";
            case 3:
                return "R";
            case 4:
                return QLog.TAG_REPORTLEVEL_USER;
            default:
                return "?";
        }
    }

    public static void a(Metadata metadata, String str) {
        AppMethodBeat.i(137412);
        for (int i2 = 0; i2 < metadata.btX.length; i2++) {
            Metadata.Entry entry = metadata.btX[i2];
            if (entry instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) entry;
                Log.d("MicroMsg.ExoPlayer", str + String.format("%s: value=%s", textInformationFrame.id, textInformationFrame.value));
            } else if (entry instanceof UrlLinkFrame) {
                UrlLinkFrame urlLinkFrame = (UrlLinkFrame) entry;
                Log.d("MicroMsg.ExoPlayer", str + String.format("%s: url=%s", urlLinkFrame.id, urlLinkFrame.url));
            } else if (entry instanceof PrivFrame) {
                PrivFrame privFrame = (PrivFrame) entry;
                Log.d("MicroMsg.ExoPlayer", str + String.format("%s: owner=%s", privFrame.id, privFrame.buA));
            } else if (entry instanceof GeobFrame) {
                GeobFrame geobFrame = (GeobFrame) entry;
                Log.d("MicroMsg.ExoPlayer", str + String.format("%s: mimeType=%s, filename=%s, description=%s", geobFrame.id, geobFrame.mimeType, geobFrame.filename, geobFrame.description));
            } else if (entry instanceof ApicFrame) {
                ApicFrame apicFrame = (ApicFrame) entry;
                Log.d("MicroMsg.ExoPlayer", str + String.format("%s: mimeType=%s, description=%s", apicFrame.id, apicFrame.mimeType, apicFrame.description));
            } else if (entry instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entry;
                Log.d("MicroMsg.ExoPlayer", str + String.format("%s: language=%s, description=%s", commentFrame.id, commentFrame.language, commentFrame.description));
            } else if (entry instanceof Id3Frame) {
                Log.d("MicroMsg.ExoPlayer", str + String.format("%s", ((Id3Frame) entry).id));
            } else if (entry instanceof EventMessage) {
                EventMessage eventMessage = (EventMessage) entry;
                Log.d("MicroMsg.ExoPlayer", str + String.format("EMSG: scheme=%s, id=%d, value=%s", eventMessage.buj, Long.valueOf(eventMessage.id), eventMessage.value));
            }
        }
        AppMethodBeat.o(137412);
    }
}
