package com.google.android.exoplayer2.source.b.a;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.d.b;
import com.google.android.exoplayer2.h.u;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.source.b.a.a;
import com.google.android.exoplayer2.source.b.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.thumbplayer.api.ITPPlayer;
import java.io.BufferedReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class d implements u.a<c> {
    private static final Pattern bzA = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final Pattern bzB = bj("AUTOSELECT");
    private static final Pattern bzC = bj("DEFAULT");
    private static final Pattern bzD = bj("FORCED");
    private static final Pattern bzi = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    private static final Pattern bzj = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    private static final Pattern bzk = Pattern.compile("CODECS=\"(.+?)\"");
    private static final Pattern bzl = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    private static final Pattern bzm = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    private static final Pattern bzn = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    private static final Pattern bzo = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    private static final Pattern bzp = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final Pattern bzq = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    private static final Pattern bzr = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final Pattern bzs = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    private static final Pattern bzt = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final Pattern bzu = Pattern.compile("METHOD=(NONE|AES-128)");
    private static final Pattern bzv = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern bzw = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern bzx = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern bzy = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern bzz = Pattern.compile("NAME=\"(.+?)\"");

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.google.android.exoplayer2.h.u.a
    public final /* synthetic */ c b(Uri uri, InputStream inputStream) {
        AppMethodBeat.i(62902);
        c a2 = a(uri, inputStream);
        AppMethodBeat.o(62902);
        return a2;
    }

    static {
        AppMethodBeat.i(62903);
        AppMethodBeat.o(62903);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 148
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
        */
    private static com.google.android.exoplayer2.source.b.a.c a(android.net.Uri r7, java.io.InputStream r8) {
        /*
        // Method dump skipped, instructions count: 237
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.b.a.d.a(android.net.Uri, java.io.InputStream):com.google.android.exoplayer2.source.b.a.c");
    }

    private static boolean a(BufferedReader bufferedReader) {
        AppMethodBeat.i(62892);
        int read = bufferedReader.read();
        if (read == 239) {
            if (bufferedReader.read() == 187 && bufferedReader.read() == 191) {
                read = bufferedReader.read();
            } else {
                AppMethodBeat.o(62892);
                return false;
            }
        }
        int a2 = a(bufferedReader, true, read);
        for (int i2 = 0; i2 < 7; i2++) {
            if (a2 != "#EXTM3U".charAt(i2)) {
                AppMethodBeat.o(62892);
                return false;
            }
            a2 = bufferedReader.read();
        }
        boolean fd = x.fd(a(bufferedReader, false, a2));
        AppMethodBeat.o(62892);
        return fd;
    }

    private static int a(BufferedReader bufferedReader, boolean z, int i2) {
        AppMethodBeat.i(62893);
        while (i2 != -1 && Character.isWhitespace(i2) && (z || !x.fd(i2))) {
            i2 = bufferedReader.read();
        }
        AppMethodBeat.o(62893);
        return i2;
    }

    private static a a(a aVar, String str) {
        int i2;
        int i3;
        int i4;
        String str2;
        int parseInt;
        AppMethodBeat.i(62894);
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Format format = null;
        List list = null;
        boolean z = false;
        while (aVar.hasNext()) {
            String next = aVar.next();
            b.i("master ExoPlayer", next, new Object[0]);
            if (next.startsWith("#EXT")) {
                arrayList4.add(next);
            }
            if (next.startsWith("#EXT-X-MEDIA")) {
                int i5 = (e(next, bzD) ? 2 : 0) | (e(next, bzC) ? 1 : 0);
                if (e(next, bzB)) {
                    i4 = 4;
                } else {
                    i4 = 0;
                }
                int i6 = i5 | i4;
                String c2 = c(next, bzv);
                String d2 = d(next, bzz);
                String c3 = c(next, bzy);
                String d3 = d(next, bzx);
                char c4 = 65535;
                switch (d3.hashCode()) {
                    case -959297733:
                        if (d3.equals("SUBTITLES")) {
                            c4 = 1;
                            break;
                        }
                        break;
                    case -333210994:
                        if (d3.equals("CLOSED-CAPTIONS")) {
                            c4 = 2;
                            break;
                        }
                        break;
                    case 62628790:
                        if (d3.equals("AUDIO")) {
                            c4 = 0;
                            break;
                        }
                        break;
                }
                switch (c4) {
                    case 0:
                        Format a2 = Format.a(d2, "application/x-mpegURL", i6, c3);
                        if (c2 != null) {
                            arrayList2.add(new a.C0114a(c2, a2));
                            break;
                        } else {
                            format = a2;
                            continue;
                        }
                    case 1:
                        arrayList3.add(new a.C0114a(c2, Format.a(d2, "application/x-mpegURL", ITPPlayer.TP_MIMETYPE_TEXT_VTT, i6, c3)));
                        continue;
                    case 2:
                        String d4 = d(next, bzA);
                        if (d4.startsWith("CC")) {
                            str2 = "application/cea-608";
                            parseInt = Integer.parseInt(d4.substring(2));
                        } else {
                            str2 = "application/cea-708";
                            parseInt = Integer.parseInt(d4.substring(7));
                        }
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.add(Format.a(d2, (String) null, str2, i6, c3, parseInt));
                        continue;
                }
            } else if (next.startsWith("#EXT-X-STREAM-INF")) {
                int a3 = a(next, bzj);
                String c5 = c(next, bzi);
                if (c5 != null) {
                    a3 = Integer.parseInt(c5);
                }
                String c6 = c(next, bzk);
                String c7 = c(next, bzl);
                z |= next.contains("CLOSED-CAPTIONS=NONE");
                if (c7 != null) {
                    String[] split = c7.split("x");
                    int parseInt2 = Integer.parseInt(split[0]);
                    int parseInt3 = Integer.parseInt(split[1]);
                    if (parseInt2 <= 0 || parseInt3 <= 0) {
                        parseInt2 = -1;
                        parseInt3 = -1;
                    }
                    i3 = parseInt3;
                    i2 = parseInt2;
                } else {
                    i2 = -1;
                    i3 = -1;
                }
                String next2 = aVar.next();
                if (hashSet.add(next2)) {
                    arrayList.add(new a.C0114a(next2, Format.a(Integer.toString(arrayList.size()), "application/x-mpegURL", c6, a3, i2, i3)));
                }
            }
        }
        if (z) {
            list = Collections.emptyList();
        }
        a aVar2 = new a(str, arrayList4, arrayList, arrayList2, arrayList3, format, list);
        AppMethodBeat.o(62894);
        return aVar2;
    }

    private static b b(a aVar, String str) {
        String hexString;
        long j2;
        long j3;
        long j4;
        long j5;
        int i2;
        AppMethodBeat.i(62895);
        int i3 = 0;
        long j6 = -9223372036854775807L;
        int i4 = 0;
        int i5 = 1;
        long j7 = -9223372036854775807L;
        boolean z = false;
        boolean z2 = false;
        b.a aVar2 = null;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        long j8 = 0;
        boolean z3 = false;
        long j9 = 0;
        long j10 = -1;
        boolean z4 = false;
        String str2 = null;
        String str3 = null;
        int i6 = 0;
        long j11 = 0;
        long j12 = 0;
        int i7 = 0;
        int i8 = 0;
        while (aVar.hasNext()) {
            String next = aVar.next();
            com.google.android.exoplayer2.d.b.i("ExoPlayer", next, new Object[0]);
            if (next.startsWith("#EXT")) {
                arrayList2.add(next);
            }
            if (next.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                String d2 = d(next, bzo);
                if ("VOD".equals(d2)) {
                    i3 = 1;
                } else {
                    if ("EVENT".equals(d2)) {
                        i2 = 2;
                    } else {
                        i2 = i3;
                    }
                    i3 = i2;
                }
            } else if (next.startsWith("#EXT-X-START")) {
                j6 = (long) (b(next, bzr) * 1000000.0d);
            } else if (next.startsWith("#EXT-X-MAP")) {
                String d3 = d(next, bzv);
                String c2 = c(next, bzt);
                if (c2 != null) {
                    String[] split = c2.split("@");
                    j5 = Long.parseLong(split[0]);
                    if (split.length > 1) {
                        j9 = Long.parseLong(split[1]);
                    }
                } else {
                    j5 = j10;
                }
                b.a aVar3 = new b.a(d3, j9, j5);
                j9 = 0;
                j10 = -1;
                aVar2 = aVar3;
            } else if (next.startsWith("#EXT-X-TARGETDURATION")) {
                j7 = ((long) a(next, bzm)) * TimeUtil.SECOND_TO_US;
            } else if (next.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                int a2 = a(next, bzp);
                i6 = a2;
                i4 = a2;
            } else if (next.startsWith("#EXT-X-VERSION")) {
                i5 = a(next, bzn);
            } else if (next.startsWith("#EXTINF")) {
                j8 = (long) (b(next, bzq) * 1000000.0d);
            } else if (next.startsWith("#EXT-X-KEY")) {
                z4 = "AES-128".equals(d(next, bzu));
                if (z4) {
                    str2 = d(next, bzv);
                    str3 = c(next, bzw);
                } else {
                    str2 = null;
                    str3 = null;
                }
            } else if (next.startsWith("#EXT-X-BYTERANGE")) {
                String[] split2 = d(next, bzs).split("@");
                j10 = Long.parseLong(split2[0]);
                if (split2.length > 1) {
                    j4 = Long.parseLong(split2[1]);
                } else {
                    j4 = j9;
                }
                j9 = j4;
            } else if (next.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                i8 = Integer.parseInt(next.substring(next.indexOf(58) + 1));
                z3 = true;
            } else if (next.equals("#EXT-X-DISCONTINUITY")) {
                i7++;
            } else if (next.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                if (j12 == 0) {
                    j12 = com.google.android.exoplayer2.b.w(x.bI(next.substring(next.indexOf(58) + 1))) - j11;
                }
            } else if (!next.startsWith("#")) {
                if (!z4) {
                    hexString = null;
                } else if (str3 != null) {
                    hexString = str3;
                } else {
                    hexString = Integer.toHexString(i6);
                }
                int i9 = i6 + 1;
                if (j10 == -1) {
                    j2 = 0;
                } else {
                    j2 = j9;
                }
                arrayList.add(new b.a(next, j8, i7, j11, z4, str2, hexString, j2, j10));
                long j13 = j11 + j8;
                j8 = 0;
                if (j10 != -1) {
                    j3 = j2 + j10;
                } else {
                    j3 = j2;
                }
                j10 = -1;
                i6 = i9;
                j9 = j3;
                j11 = j13;
            } else if (next.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                z = true;
            } else if (next.equals("#EXT-X-ENDLIST")) {
                z2 = true;
            }
        }
        b bVar = new b(i3, str, arrayList2, j6, j12, z3, i8, i4, i5, j7, z, z2, j12 != 0, aVar2, arrayList);
        AppMethodBeat.o(62895);
        return bVar;
    }

    private static int a(String str, Pattern pattern) {
        AppMethodBeat.i(62896);
        int parseInt = Integer.parseInt(d(str, pattern));
        AppMethodBeat.o(62896);
        return parseInt;
    }

    private static double b(String str, Pattern pattern) {
        AppMethodBeat.i(62897);
        double parseDouble = Double.parseDouble(d(str, pattern));
        AppMethodBeat.o(62897);
        return parseDouble;
    }

    private static String c(String str, Pattern pattern) {
        AppMethodBeat.i(62898);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            String group = matcher.group(1);
            AppMethodBeat.o(62898);
            return group;
        }
        AppMethodBeat.o(62898);
        return null;
    }

    private static String d(String str, Pattern pattern) {
        AppMethodBeat.i(62899);
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find() || matcher.groupCount() != 1) {
            o oVar = new o("Couldn't match " + pattern.pattern() + " in " + str);
            AppMethodBeat.o(62899);
            throw oVar;
        }
        String group = matcher.group(1);
        AppMethodBeat.o(62899);
        return group;
    }

    private static boolean e(String str, Pattern pattern) {
        AppMethodBeat.i(62900);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            boolean equals = matcher.group(1).equals("YES");
            AppMethodBeat.o(62900);
            return equals;
        }
        AppMethodBeat.o(62900);
        return false;
    }

    private static Pattern bj(String str) {
        AppMethodBeat.i(62901);
        Pattern compile = Pattern.compile(str + "=(NO|YES)");
        AppMethodBeat.o(62901);
        return compile;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private final BufferedReader bzE;
        private final Queue<String> bzF;
        private String bzG;

        public a(Queue<String> queue, BufferedReader bufferedReader) {
            this.bzF = queue;
            this.bzE = bufferedReader;
        }

        public final boolean hasNext() {
            AppMethodBeat.i(62889);
            if (this.bzG != null) {
                AppMethodBeat.o(62889);
                return true;
            } else if (!this.bzF.isEmpty()) {
                this.bzG = this.bzF.poll();
                AppMethodBeat.o(62889);
                return true;
            } else {
                do {
                    String readLine = this.bzE.readLine();
                    this.bzG = readLine;
                    if (readLine != null) {
                        this.bzG = this.bzG.trim();
                    } else {
                        AppMethodBeat.o(62889);
                        return false;
                    }
                } while (this.bzG.isEmpty());
                AppMethodBeat.o(62889);
                return true;
            }
        }

        public final String next() {
            String str;
            AppMethodBeat.i(62890);
            if (hasNext()) {
                str = this.bzG;
                this.bzG = null;
            } else {
                str = null;
            }
            AppMethodBeat.o(62890);
            return str;
        }
    }
}
